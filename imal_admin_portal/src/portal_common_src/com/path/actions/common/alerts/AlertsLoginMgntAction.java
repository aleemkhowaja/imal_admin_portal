/**
 * 
 */
package com.path.actions.common.alerts;

import com.path.bo.admin.user.UsrBO;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.BRANCHESVOKey;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.admin.user.UsrSC;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.SessionCO;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * AlertsLoginMgntAction.java used for Login Alert Implementation TP#297149
 */
public class AlertsLoginMgntAction extends BaseAction
{
    
    private AlertsBO alertsBO; 
    private UsrBO usrBO;
    
    // TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
    private String statusChanged; 
    
    private AlertsParamCO alertsParamCO;
    public Object getModel()
    {
        return alertsParamCO;
    }

    
    public String edit() 
    {
    	// Add some field description for (application, company, branch, user)
    	// TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
	    if(null != alertsParamCO)
	    {
			try {
				
				UsrSC usrSC = new UsrSC();
				usrSC.setUser_id(alertsParamCO.getTodoParam());
				USRVO usrvo = usrBO.getUserDetails(usrSC);
				if(null == usrvo) 
				{
					 throw new BOException(MessageCodes.INVALID_USER_ID);
				}
		    	
		    	COMPANIESVO compVO = new COMPANIESVO();
				compVO.setCOMP_CODE(alertsParamCO.getCompCode());
				compVO = returnCommonLibBO().returnCompany(compVO);
				if(null == compVO) 
				{
					 throw new BOException(MessageCodes.INVALID_COMPANY_CODE);
				}
				
		    	BRANCHESVOKey branchKey = new BRANCHESVOKey();
			    branchKey.setBRANCH_CODE(alertsParamCO.getBranchCode());
			    branchKey.setCOMP_CODE(alertsParamCO.getCompCode());
			    BRANCHESVO branchesVO = returnCommonLibBO().returnBranch(branchKey);
			    if(null == branchesVO) 
				{
					 throw new BOException(MessageCodes.INVALID_BRANCH_CODE);
				}
		    	
		    	S_APPVO appVO = new S_APPVO();
		    	appVO.setAPP_NAME(alertsParamCO.getAppName());
		    	appVO = returnCommonLibBO().returnApplication(appVO);
		    	if(null == appVO) 
				{
					 throw new BOException(MessageCodes.INVALID_APPLICATION_NAME);
				}

		    	if(returnSessionObject().getIsRTLDir() != 1) 
		    	{
		    		alertsParamCO.setTodoRemarqs(StringUtil.nullToEmpty(usrvo.getFIRST_NAME()) + " " + StringUtil.nullToEmpty(usrvo.getLAST_NAME()));
		    		alertsParamCO.setAdditionalParams(StringUtil.nullToEmpty(compVO.getLONG_DESC_ENG()));
		    		alertsParamCO.setBranchCodeList(StringUtil.nullToEmpty(branchesVO.getLONG_DESC_ENG()));
		    		alertsParamCO.setCurrAppName(StringUtil.nullToEmpty(appVO.getLONG_DESC()));
		    	}
		    	else 
		    	{
		    		alertsParamCO.setTodoRemarqs(StringUtil.nullToEmpty(usrvo.getFIRST_NAME_ARABIC()) + " " + StringUtil.nullToEmpty(usrvo.getLAST_NAME_ARABIC()));
		    		alertsParamCO.setAdditionalParams(StringUtil.nullToEmpty(compVO.getLONG_DESC_ARAB()));
		    		alertsParamCO.setBranchCodeList(StringUtil.nullToEmpty(branchesVO.getLONG_DESC_ARAB()));
		    		alertsParamCO.setCurrAppName(StringUtil.nullToEmpty(appVO.getLONG_DESC_AR()));
		    	}
		    	
			} catch (Exception e) 
			{
				handleException(e, null, null);
			}
	    }
		return AlertsConstants.ALERT_LOGIN_MGNT_PAGE;
    }

    public String alertApprove()
    {
	try
	{
	    // TP #969401 - update approval data 
		alertApproveReject(false);
		
		// TP #1093467 - CSM - system is not considering time where Branch manager approved the alert request
		if(null != get_alert()) {
		    alertsBO.updateAlertLoginApprovalDate(get_alert().getTodoParam());
		}
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	//Set _alert to null to avoid opening the sendAlert popup
	set_alert(null);
	
	return AlertsConstants.ALERT_JSON_SUCCESS;
    }
    
    public String alertReject()
    {
	try
	{
	    // TP #969401 - update rejection data
	    alertApproveReject(true);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	//Set _alert to null to avoid opening the sendAlert popup
	set_alert(null);
	
	return AlertsConstants.ALERT_JSON_SUCCESS;
    }
    
    
    /**
     * TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
     * Update login approval/reject data
     * @param alertsParamCO
     * @param isReject
     * @throws BaseException
     */
    private void alertApproveReject(boolean isReject) throws BaseException 
    {
    	SessionCO sessionCO = returnSessionObject();
    	AlertsParamCO alertsParamCO = get_alert();
	    
    	try 
    	{
		    // TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
		    // check if the alert status changed
		    AlertsParamCO alertsParamCOTemp = new AlertsParamCO();
		    alertsParamCOTemp.setTodoCode(alertsParamCO.getTodoCode());
		    alertsParamCOTemp.setTodoLine(alertsParamCO.getTodoLine());
		    alertsParamCOTemp.setStatus(alertsParamCO.getStatus());
		    alertsBO.checkIfSameStatus(alertsParamCOTemp);
    	}
    	catch (Exception e) 
    	{
    		setStatusChanged("true");
    		throw new BOException(MessageCodes.CHECK_ALERT_STATUS_CHANGED);
		}
	    
	    // TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
	    // Differentiate between login approval/reject and login approval/reject after final signoff
	    if(AlertsConstants.TODO_ALERT_LOGIN_REQUEST_AFTER_FINAL_SIGNOFF.equals(StringUtil.nullToEmpty(alertsParamCO.getTodoAlert()))) 
	    {
	    	alertsParamCO.setTodoAlert(isReject?AlertsConstants.TODO_ALERT_LOGIN_REJECTION_AFTER_FINAL_SIGNOFF:AlertsConstants.TODO_ALERT_LOGIN_APPROVAL_AFTER_FINAL_SIGNOFF);
	    }
	    else
	    {
	    	alertsParamCO.setTodoAlert(isReject?AlertsConstants.TODO_ALERT_LOGIN_REJECTION:AlertsConstants.TODO_ALERT_LOGIN_APPROVAL);
	    }
    	
    	alertsParamCO.setUserId(sessionCO.getUserName());
    	alertsParamCO.setAppName(sessionCO.getCurrentAppName());
    	alertsBO.alertApproveReject(alertsParamCO, isReject);
    }

    /**
     * This function is called after clicking on the details button when receiving an alert.
     * @return
     * @throws BaseException
     */
    public String loadLoginAlertDetails() throws BaseException
    {
	try
	{
	    alertsParamCO = alertsBO.loadLoginAlertDetails(alertsParamCO);
	    alertsParamCO.setAlertDescription(translateMatchingMessageByLang(alertsParamCO.getAlertDescription(),
		    returnSessionObject().getLanguage()));
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return AlertsConstants.ALERT_JSON_SUCCESS;
    }
    
    
    public AlertsParamCO getAlertsParamCO()
    {
        return alertsParamCO;
    }

    public void setAlertsParamCO(AlertsParamCO alertsParamCO)
    {
        this.alertsParamCO = alertsParamCO;
    }
    public void setAlertsBO(AlertsBO alertsBO)
    {
        this.alertsBO = alertsBO;
    }

	public void setUsrBO(UsrBO usrBO) 
	{
		this.usrBO = usrBO;
	}

	public String getStatusChanged() 
	{
		return statusChanged;
	}

	public void setStatusChanged(String statusChanged) 
	{
		this.statusChanged = statusChanged;
	}

}
