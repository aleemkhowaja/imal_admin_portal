package com.path.actions.common.alerts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.JSONUtil;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.common.login.LoginBO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.AlertCO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ctsteller.CTSTELLERSC;

@SuppressWarnings("serial")
public class AlertsGridAction extends GridBaseAction
{
    private CTSTELLERSC ctsTellerSC = new CTSTELLERSC();
    private AlertsBO alertsBO;
    private LoginBO loginBO;

    public Object getModel()
    {
	return ctsTellerSC;
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
    
    public void setLoginBO(LoginBO loginBO) 
    {
		this.loginBO = loginBO;
	}

    /**
     * Load the data for Memo details grid
     * Edited in order to apply the modification with TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
     * @return
     */

    public String loadAlertsGrid()
    {
		try
		{	
			ArrayList<String>  searchColList =   new ArrayList<String>(Arrays.asList("USER_ID" , "CODE", "BRANCH_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB",
				  		"LONG_NAME_ARAB", "STATUS") );
			
			SessionCO sessionCO = returnSessionObject();
			//The compCode and branchCode should be taken from alertsParamsCO.
			//If they are not filled, they will be initialized from sessionCO.
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
			//Set application Name
			if(ctsTellerSC.getAppName() == null || ctsTellerSC.getAppName().isEmpty())
			{
			    ctsTellerSC.setAppName(sessionCO.getCurrentAppName());
			}
			
			
			 CommonLibSC commonLibSC = new CommonLibSC();
			 commonLibSC.setUserId(ctsTellerSC.getUserId());
			 commonLibSC.setCurrAppName(ctsTellerSC.getAppName());
			 commonLibSC.setFinalSignOff(sessionCO.isFinalSignOff());
			 commonLibSC.setCompanyCode(ctsTellerSC.getCompCode());
			 commonLibSC.setBranchCode(ctsTellerSC.getBranchCode());
			 commonLibSC.setHostName(sessionCO.getMachineIp());
			 commonLibSC.setHttpSessionId(sessionCO.getHttpSessionID());
			if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()) 
					&& loginBO.checkLoginAlertEnabled(commonLibSC, true))
			{
    	    	ctsTellerSC.setSearchCols(searchColList.toArray(new String[searchColList.size()]));
    	    	S_APPVO appVo = new S_APPVO();
    	    	appVo.setAPP_NAME(ctsTellerSC.getAppName());
    	    	appVo = returnCommonLibBO().returnApplication(appVo);
    	    	if(null == appVo) {
    	    		throw new BOException(MessageCodes.INVALID_APPLICATION_NAME);
    	    	}
    	    	ctsTellerSC.setIsWebVers(appVo.getIS_WEB_YN());
    	    	copyproperties(ctsTellerSC);
    	    	if(checkNbRec(ctsTellerSC))
    	    	{
    	    		setRecords(alertsBO.getAlertsListForFinalSignOffCount(ctsTellerSC));
    	    	}
    	    	ArrayList<AlertCO> alertList = alertsBO.getAlertsListForFinalSignOff(ctsTellerSC);
    	    	setGridModel(alertList);
			}
			else
			{
			    if(StringUtil.isNotEmpty(ctsTellerSC.getAdditionalParams()))
			    {
				    try
				    {
					ctsTellerSC.setAdditionalParamsMap((Map<String, Object>)JSONUtil.deserialize(ctsTellerSC.getAdditionalParams()));
				    }
				    catch(Exception e)
				    {
					log.error(e,"Error in BaseAction while deserializing alert additional params, ctsTellerSC.getAdditionalParams() = " + ctsTellerSC.getAdditionalParams() );
				    }
			    }
			    
			    if(StringUtil.isNotEmpty(ctsTellerSC.getAccessRightOptString()))
			    {
				List<String> s = Arrays.asList(ctsTellerSC.getAccessRightOptString().split("~#~")); 
				ctsTellerSC.setAccessRightsOptList(s);
			    }
			    
			    if("1".equals(ctsTellerSC.getAllowOffline()))
			    {
				searchColList.add("USER_STATUS");
			    }
			    String[] searchCol = searchColList.toArray(new String[searchColList.size()]);
			    
			    //In case of AllowLocalApproveOnly = 1 , the grid of users will be hidden so no need to load the content
			    if("1".equals(ctsTellerSC.getAllowLocalApproveOnly()))
			    {
		        	    setGridModel(new ArrayList<AlertCO>());
			    }
			    else
			    {
		
				ctsTellerSC.setSearchCols(searchCol);
				copyproperties(ctsTellerSC);
				
				if(!StringUtil.isNotEmpty(ctsTellerSC.getReasonCode()))
				{
				    ctsTellerSC.setReasonCode("X");
				}
				
				ctsTellerSC.setAppName(sessionCO.getCurrentAppName());
				ctsTellerSC.setLanguage(sessionCO.getLanguage());
				ctsTellerSC.setStatusLovType(AlertsConstants.STATUS_LOV_TYPE);
				ctsTellerSC.setOnlineStatusLovType(AlertsConstants.ONLINE_STATUS_LOV_TYPE);
				
				//Check if needed 
				//ctsTellerSC.setProgRef(get_pageRef());
				//ctsTellerSC.setIvCrud(getIv_crud());
				
				if(StringUtil.isNotEmpty(ctsTellerSC.getBranchCodeList()))
				{
				    List<String> branchCodeStringList = Arrays.asList(ctsTellerSC.getBranchCodeList().split(","));
				    ArrayList<BigDecimal> barnchCodeBigDecList = new ArrayList<BigDecimal>();
				    for(String number : branchCodeStringList)
				    {
					barnchCodeBigDecList.add(new BigDecimal(number));
				    }
				    ctsTellerSC.setBranchCodeArrayList(barnchCodeBigDecList);
				}
				
				if(checkNbRec(ctsTellerSC))
				{
				    setRecords(alertsBO.getAlertsListCount(ctsTellerSC));
				}
				ArrayList<AlertCO> alertList = alertsBO.getAlertsList(ctsTellerSC);
				setGridModel(alertList);
			    }
			}
		}
		catch(Exception e)
		{
		    log.error(e, "Error in Alert Grid");
		    handleException(e, null, null);
		}
		return SUCCESS;
	}
}
