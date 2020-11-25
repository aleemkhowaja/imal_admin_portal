package com.path.actions.common.alerts;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.common.login.LoginBO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.core.alerts.AlertsParamSC;
import com.path.vo.core.alerts.AlertsSC;
import com.path.vo.core.ctsteller.CTSTELLERSC;

@SuppressWarnings("serial")
public class AlertsMaintAction extends BaseAction
{
    private AlertsBO alertsBO;
    private LoginBO loginBO;
    private CTSTELLERSC ctsTellerSC = new CTSTELLERSC();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private AlertsSC alertsSC = new AlertsSC();
    private String allowLocalApprove;
    private String allowLocalApproveOnly;
    private BigDecimal alertWaitingTime;

    public String getCustomAccessRightsOptList()
    {
	if(ctsTellerSC.getAccessRightsOptList()!=null && ctsTellerSC.getAccessRightsOptList().size()>0)
	{
	    StringBuffer s = new StringBuffer();
	    s.append("[");
	    for (int i = 0 ; i < ctsTellerSC.getAccessRightsOptList().size();i++)
	    {
		s.append("\"");
		s.append(ctsTellerSC.getAccessRightsOptList().get(i));
		s.append("\"");
		if(i < (ctsTellerSC.getAccessRightsOptList().size() - 1))
		{
		    s.append(",");
		}
	    }
	    s.append("]");
	return s.toString();
	}
	return null;
    }
    
    public Object getModel()
    {
        return ctsTellerSC;
    }

    public BigDecimal getAlertWaitingTime()
    {
        return alertWaitingTime;
    }

    public void setAlertWaitingTime(BigDecimal alertWaitingTime)
    {
        this.alertWaitingTime = alertWaitingTime;
    }

    public String getAllowLocalApprove()
    {
        return allowLocalApprove;
    }

    public void setAllowLocalApprove(String allowLocalApprove)
    {
        this.allowLocalApprove = allowLocalApprove;
    }

    /**
     * Loads the SendAlert details page
     * 
     * @return
     */
    public String loadAlertsPage() throws JSONException
    {
        try
        {
            SessionCO sessionCO = returnSessionObject();

            if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
            {
                CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
                ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
                ctsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
                ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);
                if(ctsControlVO != null)
                {
                    setAllowLocalApprove(ctsControlVO.getALLOW_LOCAL_APPROVE());
                    setAlertWaitingTime(ctsControlVO.getALERT_WAIT_TIME());
                }
            }
            else if(ConstantsCommon.FMS_APP_NAME.equals(sessionCO.getCurrentAppName())
                || ConstantsCommon.TFA_APP_NAME.equals(sessionCO.getCurrentAppName())
                || isFromIISModule(sessionCO.getCurrentAppName()))
            {
                setAllowLocalApprove("0");
                setAlertWaitingTime(AlertsConstants.ALERT_WAIT_TIME_BY_DEFAULT);
            }
            else
            {
                setAllowLocalApprove(AlertsConstants.ALLOW_LOCAL_APPROVE_BY_DEFAULT);
                setAlertWaitingTime(AlertsConstants.ALERT_WAIT_TIME_BY_DEFAULT);
            }

            copyAlertsParameters();

            // Check for localApproveOnly parameter
            AlertsParamCO alertParamCO = get_alert();
            if(alertParamCO != null)
            {
                if("1".equals(alertParamCO.getAllowLocalApproveOnly()))
                {
                    allowLocalApproveOnly = alertParamCO.getAllowLocalApproveOnly();
                    allowLocalApprove = alertParamCO.getAllowLocalApproveOnly();
                }
                else if("0".equals(alertParamCO.getAllowLocalApprove()))
                {
                    allowLocalApprove = alertParamCO.getAllowLocalApprove();
                    allowLocalApproveOnly = alertParamCO.getAllowLocalApprove();
                }
            }

            ctsTellerSC.setAlertDescTranslated(translateMatchingMessage(ctsTellerSC.getAlertDesc()));

            // NABIL FEGHALI - Fix Issue BB120315
            ctsTellerSC.setUserLevelMessage(returnCommonLibBO().returnTranslErrorMessage(
                MessageCodes.ENTER_VALID_VAT_CODE/* 1006 */,
                new String[] {StringUtil.nullToEmpty(NumberUtil
                    .emptyDecimalToNull(ctsTellerSC.getTellerLevel()))}, sessionCO.getLanguage()));
            
            if(ctsTellerSC.getAccessRightsOptList() != null 
        	    && !ctsTellerSC.getAccessRightsOptList().isEmpty())
            {
		StringBuffer accessRightOptString = new StringBuffer();
		for(int i = 0; i < ctsTellerSC.getAccessRightsOptList().size(); i++)
		{
		    accessRightOptString.append(ctsTellerSC.getAccessRightsOptList().get(i));
		    if(i < ctsTellerSC.getAccessRightsOptList().size() - 1)
		    {
			accessRightOptString.append("~#~");
		    }
		}

		ctsTellerSC.setAccessRightOptString(accessRightOptString.toString());
            }

        }
        catch(BaseException e)
        {
            handleException(e, null, null);
        }
        return "loadPage";
    }

    /**
     * @author nabilfeghali
     */
    private void copyAlertsParameters() throws BaseException
    {

	AlertsParamCO alertParamCO = get_alert();
	if(alertParamCO != null)
	{
	    //Reset empty bigdecimal to null
	    NumberUtil.resetEmptyValues(alertParamCO);
	    PathPropertyUtil.copyProperties((AlertsParamSC)alertParamCO, (AlertsParamSC)ctsTellerSC);
	    ctsTellerSC.setAlertDesc(alertParamCO.getAlertDescription());
	    //Refactoring 
	    /*
	    ctsTellerSC.setAuthOdAcc(alertParamCO.getAuthOdAcc());
	    ctsTellerSC.setTodoAlert(alertParamCO.getTodoAlert());
	    ctsTellerSC.setCIF_NO(alertParamCO.getCIF_NO());
	    ctsTellerSC.setTrsNo(alertParamCO.getTrsNo());
	    ctsTellerSC.setStatus(alertParamCO.getStatus());
	    ctsTellerSC.setCompCode(alertParamCO.getCompCode());
	    ctsTellerSC.setBranchCode(alertParamCO.getBranchCode());
	    ctsTellerSC.setCifNb(alertParamCO.getCifNb());
	    ctsTellerSC.setIsLang(alertParamCO.getIsLang());
	    ctsTellerSC.setEntityType(alertParamCO.getEntityType());
	    ctsTellerSC.setReasonCode(alertParamCO.getReasonCode());
	    ctsTellerSC.setTrs_cy(alertParamCO.getTrs_cy());
	    ctsTellerSC.setAmount(alertParamCO.getAmount());
	    ctsTellerSC.setIsMultibranch(alertParamCO.getIsMultibranch());
	    ctsTellerSC.setAppName(alertParamCO.getAppName());
	    ctsTellerSC.setProgRef(alertParamCO.getProgRef());
	    ctsTellerSC.setIvCrud(alertParamCO.getIvCrud());
	    ctsTellerSC.setUserId(alertParamCO.getUserId());
	    ctsTellerSC.setAlertDesc(alertParamCO.getAlertDescription());
	    ctsTellerSC.setAlertType(alertParamCO.getAlertType());
	    ctsTellerSC.setTrsType(alertParamCO.getTrsType());
	    ctsTellerSC.setAlertLabelKey(alertParamCO.getAlertLabelKey());
	    
	    ctsTellerSC.setBriefNameEnglish(alertParamCO.getBriefNameEnglish());
	    ctsTellerSC.setLongNameEnglish(alertParamCO.getLongNameEnglish());	
	    ctsTellerSC.setBriefNameArab(alertParamCO.getBriefNameArab());	
	    ctsTellerSC.setLongNameArab(alertParamCO.getLongNameArab()); 
	    ctsTellerSC.setDistributionType(alertParamCO.getDistributionType());
	    ctsTellerSC.setDistributionTo(alertParamCO.getDistributionTo()); 	
	    ctsTellerSC.setTodoType(alertParamCO.getTodoType());	
	    ctsTellerSC.setTodoPriority(alertParamCO.getTodoPriority()); 	
	    ctsTellerSC.setTodoExternal(alertParamCO.getTodoExternal()); 	
	    ctsTellerSC.setAllowToSend(alertParamCO.getAllowToSend());	
	    ctsTellerSC.setTodoChecked(alertParamCO.getTodoChecked());	
	    ctsTellerSC.setTodoParam(alertParamCO.getTodoParam());	
	    ctsTellerSC.setTodoExecution(alertParamCO.getTodoExecution());	
	    ctsTellerSC.setTodoExcepEnglish(alertParamCO.getTodoExcepEnglish());	
	    ctsTellerSC.setTodoExcepArabic(alertParamCO.getTodoExcepArabic()); 	
	    ctsTellerSC.setTodoTellerBranch(alertParamCO.getTodoTellerBranch()); 	
	    ctsTellerSC.setTodoTellerId(alertParamCO.getTodoTellerId()); 	
	    ctsTellerSC.setActionType(alertParamCO.getActionType());
	    ctsTellerSC.setTodoFrBranch(alertParamCO.getTodoFrBranch());
	    ctsTellerSC.setSubTellerCode(alertParamCO.getSubTellerCode());
	    ctsTellerSC.setCIF_NO(alertParamCO.getCIF_NO());
	    ctsTellerSC.setAndOr(alertParamCO.getAndOr());
	    ctsTellerSC.setAndOrFlag(alertParamCO.getAndOrFlag());
	    
	    ctsTellerSC.setBranchCodeList(alertParamCO.getBranchCodeList());
	    ctsTellerSC.setCompSubCode(alertParamCO.getCompSubCode());
	    ctsTellerSC.setBranchSubCode(alertParamCO.getBranchSubCode());
	    ctsTellerSC.setTellerLevel(alertParamCO.getTellerLevel());
	    ctsTellerSC.setAmountCV(alertParamCO.getAmountCV());
	    ctsTellerSC.setTrxType(alertParamCO.getTrxType());
	    ctsTellerSC.setGlCode(alertParamCO.getGlCode());
	    ctsTellerSC.setCifType(alertParamCO.getCifType());
	    ctsTellerSC.setEcoSector(alertParamCO.getEcoSector());
	    ctsTellerSC.setPriorityCode(alertParamCO.getPriorityCode());
	    ctsTellerSC.setTodoAlertOldStatus(alertParamCO.getTodoAlertOldStatus());
	    ctsTellerSC.setSendAlertCallBackFunction(alertParamCO.getSendAlertCallBackFunction());
	    ctsTellerSC.setSendAlertCallBackOnChkPwd(alertParamCO.getSendAlertCallBackOnChkPwd());
	    ctsTellerSC.setSendAlertCallBackOnItemClose(alertParamCO.getSendAlertCallBackOnItemClose());
	    ctsTellerSC.setTodoRemarqs(alertParamCO.getTodoRemarqs());
	    
	    ctsTellerSC.setAllowLocalApproveOnly(alertParamCO.getAllowLocalApproveOnly());
	    //NABIL FEGHALI - BISI120150 - Alert Offline.
	    ctsTellerSC.setAllowOffline(alertParamCO.getAllowOffline());
	    ctsTellerSC.setHighLightMap(alertParamCO.getHighLightMap());
	    ctsTellerSC.setSendAlertCallBackOnChkPwdSuccess(alertParamCO.getSendAlertCallBackOnChkPwdSuccess());
	    */
	}

    }

    /**
     * Loads the SendAlert details page
     * 
     * @return
     * @throws ParseException
     */
    public String sendAlert() throws JSONException, ParseException
    {
        try
        {

            S_TODO_DETVO sToDoDetVO = new S_TODO_DETVO();
            SessionCO sessionCO = returnSessionObject();
            Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
            calendar.setTime(returnCommonLibBO().returnSystemDateWithTime()); // Set the system date

            if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
            {
                CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
                ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
                ctsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
                ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);
                // Commented because we use the SYSDATE in the engine to check for time-out alerts.
                // calendar.setTime(DateUtil.addTimeToDate(sessionCO.getRunningDateRET())); //Set
                // the running date
                setAllowLocalApprove(ctsControlVO.getALLOW_LOCAL_APPROVE());
                setAlertWaitingTime(ctsControlVO.getALERT_WAIT_TIME());
                calendar.add(Calendar.SECOND, NumberUtil.emptyDecimalToZero(ctsControlVO.getALERT_WAIT_TIME())
                    .intValue());
            }
            else
            {
                setAllowLocalApprove(AlertsConstants.ALLOW_LOCAL_APPROVE_BY_DEFAULT);
                setAlertWaitingTime(AlertsConstants.ALERT_WAIT_TIME_BY_DEFAULT);
                calendar.add(Calendar.SECOND, NumberUtil.emptyDecimalToZero(
                    AlertsConstants.ALERT_WAIT_TIME_BY_DEFAULT).intValue());
            }

            sToDoDetVO.setALERT_WAITING_TIME(calendar.getTime());
            sToDoDetVO.setCOMP_CODE(sessionCO.getCompanyCode());
            if(NumberUtil.isEmptyDecimal(ctsTellerSC.getBranchCode()))
            {
                sToDoDetVO.setBRANCH_CODE(sessionCO.getBranchCode());
            }
            else
            {
                sToDoDetVO.setBRANCH_CODE(ctsTellerSC.getBranchCode());
            }
            sToDoDetVO.setRECEIVED_CODE(ctsTellerVO.getCODE());

            sToDoDetVO.setRECEIVED_FROM(sessionCO.getUserName());
            sToDoDetVO.setTODO_APPLICATION(sessionCO.getCurrentAppName());

            sToDoDetVO.setTODO_PROG_REF(ctsTellerSC.getProgRef());

            /*
             * Adding the Substr because from different screens the Name has a length > 20 and it
             * will produce error on insert in s_todo_det
             */
            sToDoDetVO.setBRIEF_NAME_ARAB(StringUtil.substring(ctsTellerSC.getBriefNameArab(),20));
            sToDoDetVO.setBRIEF_NAME_ENG(StringUtil.substring(ctsTellerSC.getBriefNameEnglish(),20));
            sToDoDetVO.setALERT_DESC(alertsSC.getAlertDesc());
            // Commented because we use the SYSDATE in the engine to get the timeout alerts
            // sToDoDetVO.setDATE_RECEIVED(sessionCO.getRunningDateRET());
            sToDoDetVO.setDATE_RECEIVED(returnCommonLibBO().returnSystemDateWithTime());

            alertsSC.setTellerId(sessionCO.getUserName());
            alertsSC.setUserId(ctsTellerSC.getReceiverUserId());
            alertsSC.setUserAction(AlertsConstants.USER_ACTION_G);
            alertsSC.setJobAction(AlertsConstants.JOB_ACTION_G);
            alertsSC = alertsBO.callToDoDet(alertsSC);
            sToDoDetVO.setTODO_CODE(alertsSC.getTodoCode());
            sToDoDetVO.setTODO_LINE(alertsSC.getTodoLine());
            sToDoDetVO.setJOB_ID(alertsSC.getJobId());

            sToDoDetVO.setTODO_STATUS(AlertsConstants.STATUS_ACTIVE);
            
            // TP #969401 - check if login approval after final signoff is needed
            if(checkFinalSignOffEnabled())
            {
            	sToDoDetVO.setTODO_ALERT(AlertsConstants.TODO_ALERT_LOGIN_REQUEST_AFTER_FINAL_SIGNOFF);
            }
            else
            {
            	sToDoDetVO.setTODO_ALERT(ctsTellerSC.getTodoAlert());
            }
            
            sToDoDetVO.setACTION_TYPE(ctsTellerSC.getActionType());
            sToDoDetVO.setTODO_REASON(ctsTellerSC.getReasonCode());
            sToDoDetVO.setDISTRIBUTION_TYPE(ctsTellerSC.getDistributionType());
            sToDoDetVO.setDISTRIBUTION_TO(ctsTellerSC.getDistributionTo());
            sToDoDetVO.setTODO_PARAM(ctsTellerSC.getTodoParam());
            sToDoDetVO.setUSER_ID(ctsTellerSC.getReceiverUserId());
            sToDoDetVO.setTODO_PRIORITY(ctsTellerSC.getTodoPriority());
            sToDoDetVO.setTODO_CHECKED(ctsTellerSC.getTodoChecked());
            sToDoDetVO.setTODO_EXECUTION(ctsTellerSC.getTodoExecution());
            sToDoDetVO.setTODO_TYPE(ctsTellerSC.getTodoType());
            sToDoDetVO.setALLOW_TO_SEND(ctsTellerSC.getAllowToSend());

            sToDoDetVO.setCIF_NO(ctsTellerSC.getCIF_NO());
            sToDoDetVO.setTODO_EXTERNAL(ctsTellerSC.getTodoExternal());
            sToDoDetVO.setTRX_NUMBER(NumberUtil.emptyDecimalToZero(ctsTellerSC.getTrsNo()).toString());
            sToDoDetVO.setTODO_TELLER_BR(ctsTellerSC.getTodoTellerBranch());
            sToDoDetVO.setTODO_FR_BRANCH(ctsTellerSC.getTodoFrBranch());
            sToDoDetVO.setTODO_TELLER_ID(ctsTellerSC.getTodoTellerId());
            sToDoDetVO.setALERT_DESC(ctsTellerSC.getAlertDesc());
            sToDoDetVO.setTODO_EXCEP_ENG(StringUtil.substring(ctsTellerSC.getTodoExcepEnglish(),250));
            sToDoDetVO.setTODO_EXCEP_ARABIC(StringUtil.substring(ctsTellerSC.getTodoExcepArabic(),250));
            sToDoDetVO.setTODO_ALERT_OLD_STATUS(ctsTellerSC.getTodoAlertOldStatus());
            sToDoDetVO.setTODO_REMARQS(ctsTellerSC.getTodoRemarqs());
            sToDoDetVO.setTODO_ADDITIONAL_PARAMS(ctsTellerSC.getAdditionalParams());
            alertsBO.saveAlert(sToDoDetVO);

        }
        catch(BaseException e)
        {
            handleException(e, null, null);
        }
        return "success";
    }
    
    /**
     * TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
	 * Check if login approval after final signoff is needed
     * @return
     */
    private boolean checkFinalSignOffEnabled() 
    {
    	boolean isFinalSignOff = false;
    	try {
	    	SessionCO sessionCO = returnSessionObject();

	    	if(NumberUtil.isEmptyDecimal(ctsTellerSC.getCompCode()))
			{
			    ctsTellerSC.setCompCode(sessionCO.getCompanyCode());
			}
			if(NumberUtil.isEmptyDecimal(ctsTellerSC.getBranchCode()))
			{
			    ctsTellerSC.setBranchCode(sessionCO.getBranchCode());
			}
			if(!StringUtil.isNotEmpty(ctsTellerSC.getUserId()))
			{
			    ctsTellerSC.setUserId(sessionCO.getUserName());
			}
			if(ctsTellerSC.getAppName() == null || ctsTellerSC.getAppName().isEmpty())
			{
			    ctsTellerSC.setAppName(sessionCO.getCurrentAppName());
			}
			
			 CommonLibSC commonLibSC = new CommonLibSC();
			 commonLibSC.setUserId(sessionCO.getUserName());
			 commonLibSC.setCurrAppName(ctsTellerSC.getAppName());
			 commonLibSC.setFinalSignOff(sessionCO.isFinalSignOff());
			 commonLibSC.setCompanyCode(ctsTellerSC.getCompCode());
			 commonLibSC.setBranchCode(ctsTellerSC.getBranchCode());
			 commonLibSC.setHostName(sessionCO.getMachineIp());
			 commonLibSC.setHttpSessionId(sessionCO.getHttpSessionID());
			isFinalSignOff = loginBO.checkLoginAlertEnabled(commonLibSC, true);
		} 
    	catch (Exception e) 
    	{
			handleException(e, null, null);
		}
	    return isFinalSignOff;
    }

    private boolean isFromIISModule(String appName)
    {
	return ConstantsCommon.IIS_APP_NAME.equals(appName) || ConstantsCommon.ITRS_APP_NAME.equals(appName)
		|| ConstantsCommon.PROV_APP_NAME.equals(appName) || ConstantsCommon.ICOR_APP_NAME.equals(appName)
		|| ConstantsCommon.IRET_APP_NAME.equals(appName);
    }

    
    public CTSTELLERVO getCtsTellerVO()
    {
        return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
        this.ctsTellerVO = ctsTellerVO;
    }

    public AlertsSC getAlertsSC()
    {
        return alertsSC;
    }

    public void setAlertsSC(AlertsSC alertsSC)
    {
        this.alertsSC = alertsSC;
    }

    public CTSTELLERSC getCtsTellerSC()
    {
        return ctsTellerSC;
    }

    public void setCtsTellerSC(CTSTELLERSC ctsTellerSC)
    {
        this.ctsTellerSC = ctsTellerSC;
    }

    public void setAlertsBO(AlertsBO alertsBO)
    {
        this.alertsBO = alertsBO;
    }

    public String getAllowLocalApproveOnly()
    {
        return allowLocalApproveOnly;
    }

    public void setAllowLocalApproveOnly(String allowLocalApproveOnly)
    {
        this.allowLocalApproveOnly = allowLocalApproveOnly;
    }

	public void setLoginBO(LoginBO loginBO) 
	{
		this.loginBO = loginBO;
	}
    
}
