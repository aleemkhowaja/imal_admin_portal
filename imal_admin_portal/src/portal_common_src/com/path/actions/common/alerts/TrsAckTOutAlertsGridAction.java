package com.path.actions.common.alerts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.common.alerts.AlertsEngineBO;
import com.path.bo.common.login.LoginBO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.AlertCO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.core.alerts.AlertsSC;

public class TrsAckTOutAlertsGridAction extends GridBaseAction 
{

    private AlertsBO alertsBO;
    private ArrayList<AlertCO> alertList = new ArrayList<AlertCO>();
    private AlertsSC alertsSC = new AlertsSC();
    private AlertsEngineBO alertsEngineBO;
    private LoginBO loginBO;
    
    public Object getModel()
    {
	return alertsSC;
    }

    public ArrayList<AlertCO> getAlertList()
    {
        return alertList;
    }

    public void setAlertList(ArrayList<AlertCO> alertList)
    {
        this.alertList = alertList;
    }

    public AlertsSC getAlertsSC()
    {
        return alertsSC;
    }

    public void setAlertsSC(AlertsSC alertsSC)
    {
        this.alertsSC = alertsSC;
    }

    public void setAlertsBO(AlertsBO alertsBO)
    {
        this.alertsBO = alertsBO;
    }
    
    /**
	 * Loads the TrsAckTOutAlerts details page
	 * 
	 * @return
	 */
	
	public String loadTrsAckTOutAlertsGrid()
	{		 
	    String[] searchCol = {"JOB_ID","TODO_ALERT","alertDescription","TODO_PARAM","TRX_DESC","RECEIVED_FROM","USER_ID","TODO_TYPE","TRX_NUMBER"};
	      try
		{
		SessionCO sessionCO = returnSessionObject();
		
		alertsSC.setSearchCols(searchCol);
		copyproperties(alertsSC);
		alertsSC.setStatus(AlertsConstants.STATUS_ACTIVE);
		alertsSC.setLanguage(sessionCO.getLanguage());
		alertsSC.setUserId(sessionCO.getUserName());
		/**
		 * [marwan maddah]: added the if condition 
		 * because in case the call is form IBIS the appName will be passed as parameter, 
		 * so no need to get it from session
		 */
		if(StringUtil.nullToEmpty(alertsSC.getAppName()).isEmpty())
		{
		   alertsSC.setAppName(sessionCO.getCurrentAppName());
		}
		
		alertsSC.setTodoAlertLovType(AlertsConstants.TODO_ALERT_LOV_TYPE);
		if(isFromIISModule())
        	{
        	    alertsSC.setTodoAlertDescLovType(AlertsConstants.TODO_ALERT_DESC_IIS_LOV_TYPE);
        	}
	        else if(ConstantsCommon.FMS_APP_NAME.equals(alertsSC.getAppName()))
	        {
	            alertsSC.setTodoAlertDescLovType(AlertsConstants.TODO_ALERT_DESC_FMS_LOV_TYPE);
	        }
	        else
        	{
        	    alertsSC.setTodoAlertDescLovType(AlertsConstants.TODO_ALERT_DESC_LOV_TYPE);
        	}

		//Commented because we use the SYSDATE in the engine to check for time-out alerts.
		//Date dateTime=DateUtil.addTimeToDate(returnSessionObject().getRunningDateRET());
		Date dateTime=returnCommonLibBO().returnSystemDateWithTime();
		alertsSC.setRunningDate(dateTime);
		
		//Check if alert is by comp/branch, TP 949953 Landing Page Opening IIS not showing records and closing
		boolean alertIsByCompBranch =  alertsEngineBO.returnAlertByCompBranch(alertsSC.getAppName()); 
		/* In case of Login Alert Implementation TP#297149, the alert should be by comp/branch */
		if(alertIsByCompBranch || Boolean.valueOf(alertsSC.getEnableLoginAlert()))
		{
		    alertsSC.setAlertByCompBranch(Boolean.TRUE.toString());
		    alertsSC.setCompCode(sessionCO.getCompanyCode());
		    alertsSC.setBranchCode(sessionCO.getBranchCode());
		}
		
		if(checkNbRec(alertsSC))
		{
		    setRecords(alertsBO.getTrsAckTOutAlertsListCount(alertsSC));
		}
		alertList = alertsBO.getTrsAckTOutAlertsList(alertsSC);
		setGridModel(alertList);
			
		}
		catch(Exception e)
		{
			log.error(e, "Error in loadTrsAckTOutAlertsGrid");
			handleException(e, null, null);
		}
		return "success";
		
	}
	/**
	 * 
	 * 
	 * @return
	 */
	
	public String trsAckTOutAlertsAfterOk()throws BaseException
	{		 
	   
	    try
	    {   
		S_TODO_DETVO stododet = new S_TODO_DETVO();
		stododet.setTODO_LINE(alertsSC.getTodoLine());
		stododet.setTODO_CODE(alertsSC.getTodoCode());
		stododet.setTODO_STATUS(AlertsConstants.STATUS_DELETED);
		alertsBO.updateAlertStatusAfterOk(stododet);
		
		/* Login Alert Implementation TP#297149 */
		PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
		SessionCO sessionCO = returnSessionObject();
		
		// TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
	    // check if alert of type approval after final signoff
		boolean isFinalSignoffApprove = ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()) && AlertsConstants.TODO_ALERT_LOGIN_APPROVAL_AFTER_FINAL_SIGNOFF.equals(alertsSC.getTodoAlert()); 
		
		if((pthCtrl != null && ConstantsCommon.ONE.equals(pthCtrl.getENABLE_ALRT_ON_USER_LOGIN_YN())) || isFinalSignoffApprove) 
		{
		    alertsSC.setHostName(sessionCO.getMachineIp());
		    /**
		     * [Marwan Maddah]
		     * will be used in alertsBO.updateAlertLoginApprovalDate
		     * to save it on the LOG tables
		     */
		    alertsSC.setWebHttpSessionId(sessionCO.getHttpSessionID());
		    //Remove the alertAjaxWebClient from the AlertsAjaxServlet map and close the consumer on the topic
		    AlertsCommonMethods.removeAlertClient(sessionCO.getCurrentAppName(), AlertsCommonMethods.returnUsrCompBrKey(sessionCO), sessionCO.getUserName(), sessionCO.getHttpSessionID());
		    
		    // start - TP #1093467 - CSM - system is not considering time where Branch manager approved the alert request
		    boolean checkLoginAlert = false;
		    if(AlertsConstants.TODO_ALERT_LOGIN_APPROVAL.equals(alertsSC.getTodoAlert())) 
		    {
			PTH_CTRLVO pthCtrlvo = returnCommonLibBO().returnPthCtrl();
			if(null != pthCtrlvo) 
			{
			    BigDecimal alrtTimeIntervalHrs = NumberUtil.emptyDecimalToZero(pthCtrlvo.getALRT_TIME_INTERVAL_HRS());
			    BigDecimal alrtTimeIntervalMins = NumberUtil.emptyDecimalToZero(pthCtrlvo.getALRT_TIME_INTERVAL_MINS());
			    BigDecimal alrtTimeIntervalSecs = NumberUtil.emptyDecimalToZero(pthCtrlvo.getALRT_TIME_INTERVAL_SECS());
			    if(!BigDecimal.ZERO.equals(alrtTimeIntervalHrs) || !BigDecimal.ZERO.equals(alrtTimeIntervalMins) || !BigDecimal.ZERO.equals(alrtTimeIntervalSecs)) 
			    {
				checkLoginAlert = true;
			    }
			}
		    }
		    else if(AlertsConstants.TODO_ALERT_LOGIN_APPROVAL_AFTER_FINAL_SIGNOFF.equals(alertsSC.getTodoAlert())) 
		    {
			CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
		        ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
		        ctsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
		        ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);
		        if(null != ctsControlVO) {
		            BigDecimal alrtTimeIntervalHrs = NumberUtil.emptyDecimalToZero(ctsControlVO.getALERT_TIME_AFTER_FINAL_HRS());
		            BigDecimal alrtTimeIntervalMins = NumberUtil.emptyDecimalToZero(ctsControlVO.getALERT_TIME_AFTER_FINAL_MINS());
		            BigDecimal alrtTimeIntervalSecs = NumberUtil.emptyDecimalToZero(ctsControlVO.getALERT_TIME_AFTER_FINAL_SECS());
		            if(!BigDecimal.ZERO.equals(alrtTimeIntervalHrs) || !BigDecimal.ZERO.equals(alrtTimeIntervalMins) || !BigDecimal.ZERO.equals(alrtTimeIntervalSecs))
		            {
		        	checkLoginAlert = true;
		            }
		        }
		    }
		    CommonLibSC commonLibSC = new CommonLibSC();
		    commonLibSC.setUserId(sessionCO.getUserName());
		    commonLibSC.setCurrAppName(sessionCO.getCurrentAppName());
		    commonLibSC.setFinalSignOff(sessionCO.isFinalSignOff());
		    commonLibSC.setCompanyCode(sessionCO.getCompanyCode());
		    commonLibSC.setBranchCode(sessionCO.getBranchCode());
		    commonLibSC.setHostName(sessionCO.getMachineIp());
		    commonLibSC.setHttpSessionId(sessionCO.getHttpSessionID());
		    if(checkLoginAlert && loginBO.checkLoginAlertEnabled(commonLibSC, isFinalSignoffApprove)) 
		    {
			alertsSC.setErrorMessage(getText("usr_no_longer_acc_to_login_key"));
		    }
		    else if(AlertsConstants.TODO_ALERT_LOGIN_APPROVAL.equals(alertsSC.getTodoAlert()) || isFinalSignoffApprove)
		    {
			session.put(AlertsConstants.ALERT_LOGIN_APPROVAL_FLAG, "1");
			session.put(AlertsConstants.ALERT_LOGIN_AFTER_FINAL_SIGNOFF_FLAG, ConstantsCommon.ZERO);
		    }
		    // end - TP #1093467 - CSM - system is not considering time where Branch manager approved the alert request
		    
		}
	    }
	    catch(Exception e)
	    {
		handleException(e, null, null);
	    }
	    return "success";
	    
	}
	/**
	 * CANCEL THE ROW SELECTED
	 * 
	 * @return
	 */
	
    public String trsAckTOutAlertsAfterDissmiss() throws BaseException
    {
	try
	{
	    S_TODO_DETVO stododet = new S_TODO_DETVO();
	    stododet.setTODO_LINE(alertsSC.getTodoLine());
	    stododet.setTODO_CODE(alertsSC.getTodoCode());
	    stododet.setTODO_STATUS(alertsSC.getStatus());

	    AlertsParamCO alertsParamCO = new AlertsParamCO();
	    alertsParamCO.setTodoCode(alertsSC.getTodoCode());
	    alertsParamCO.setTodoLine(alertsSC.getTodoLine());
	    alertsParamCO.setStatus(alertsSC.getStatus());
	    alertsBO.checkIfSameStatus(alertsParamCO);

	    stododet.setTODO_STATUS(AlertsConstants.STATUS_DELETED);
	    alertsBO.updateAlertStatusAfterOk(stododet);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "success";

    }
    
    public String loadTrxDetailsIframe() throws BaseException
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    setIv_crud("detail");
	    if(sessionCO.getAdditionalParamsMap() != null && !sessionCO.getAdditionalParamsMap().isEmpty())
	    {
		alertsSC.setParameters(PathJSONUtil.strutsJsonSerialize(sessionCO.getAdditionalParamsMap()));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "loadTrxDetailsIframe";
    }
	
    public String loadTrxDetails() throws BaseException
    {
	try
	{
	    String progRef = alertsSC.getProgRef();
	    String parentRef = null;
	    String appName = alertsSC.getAppName();
	    String trxDescriptionJsFunc = null;
	    String trxDescriptionJsFile = null;
	    String trxDescriptionJsPath = null;
	    String originPageRef = returnCommonLibBO().returnOrginProgRef(appName, progRef);
	    
	    Map<String, Object> openItemMap = null;
	    String[] optDetailsArr = returnCommonLibBO().returnOptDetailsList(appName/*sessionCO.getCurrentAppName()*/ , originPageRef);
	    if(optDetailsArr != null && optDetailsArr.length > 0 && StringUtil.isNotEmpty(optDetailsArr[2])
		    && StringUtil.isNotEmpty(optDetailsArr[3]))
	    {
		parentRef = optDetailsArr[3];
	    }
	    if(ConstantsCommon.FMS_APP_NAME.equals(appName)&& StringUtil.isNotEmpty(parentRef))
	    {
		    parentRef = parentRef.substring(3);
	    }
	    
	    openItemMap = alertsBO.returnAlertsParamMap(appName, originPageRef); //AlertsConstants.OPEN_ITEM_PARAMS_MAPPING.get(progRef);
	    if(openItemMap == null || openItemMap.isEmpty())
	    {
		if(StringUtil.isNotEmpty(parentRef))
		{
		    openItemMap = alertsBO.returnAlertsParamMap(appName, parentRef);//AlertsConstants.OPEN_ITEM_PARAMS_MAPPING.get(parentRef);
		    if(openItemMap != null && !openItemMap.isEmpty())
		    {
			trxDescriptionJsFunc = StringUtil.nullToEmpty(openItemMap.get(AlertsConstants.CALL_BACK_TRX_DETAILS_FUNC_KEY)).trim();
			trxDescriptionJsFile =  StringUtil.nullToEmpty(openItemMap.get(AlertsConstants.CALL_BACK_PRINT_REQUIRE_JS_KEY)).trim();
			trxDescriptionJsPath = StringUtil.nullToEmpty(openItemMap.get(AlertsConstants.CALL_BACK_PRINT_REQUIRE_PATH_KEY)).trim();
		    }
		}
	    }
	    else
	    {
		trxDescriptionJsFunc = StringUtil.nullToEmpty(openItemMap.get(AlertsConstants.CALL_BACK_TRX_DETAILS_FUNC_KEY)).trim();
		trxDescriptionJsFile =  StringUtil.nullToEmpty(openItemMap.get(AlertsConstants.CALL_BACK_PRINT_REQUIRE_JS_KEY)).trim();
		trxDescriptionJsPath = StringUtil.nullToEmpty(openItemMap.get(AlertsConstants.CALL_BACK_PRINT_REQUIRE_PATH_KEY)).trim();
	    }
	    
	    alertsSC.setLoadTrxDetailsFunc(trxDescriptionJsFunc);
	    alertsSC.setLoadTrxDetailsJs(trxDescriptionJsFile);
	    alertsSC.setLoadTrxDetailsJsPath(trxDescriptionJsPath);
	   
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return "success";

    }
    
    private boolean isFromIISModule()
    {
	return ConstantsCommon.IIS_APP_NAME.equals(alertsSC.getAppName())
		|| ConstantsCommon.ITRS_APP_NAME.equals(alertsSC.getAppName())
		|| ConstantsCommon.PROV_APP_NAME.equals(alertsSC.getAppName())
		|| ConstantsCommon.ICOR_APP_NAME.equals(alertsSC.getAppName())
		|| ConstantsCommon.IRET_APP_NAME.equals(alertsSC.getAppName());
    }

    public void setAlertsEngineBO(AlertsEngineBO alertsEngineBO)
    {
        this.alertsEngineBO = alertsEngineBO;
    }

    public void setLoginBO(LoginBO loginBO)
    {
        this.loginBO = loginBO;
    }
    
    
	
}
