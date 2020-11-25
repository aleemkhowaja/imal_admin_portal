package com.path.actions.common.alerts;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.common.login.LoginBO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.SYS_PARAM_TODO_ALERT_TYPEVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.AlertCO;
import com.path.vo.common.PasswordChangeCO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.alerts.AlertsSC;
import com.path.vo.core.ctsteller.CTSTELLERSC;

@SuppressWarnings("serial")
public class ApproveAlertsMaintAction extends BaseAction
{
    private AlertsBO alertsBO;
    private LoginBO loginBO;
    private final AlertCO alertCO = new AlertCO();
    private String _appName;

    @Override
    @JSON(serialize = false)
    public Object getModel()
    {
	return alertCO;
    }

    public String getCustomAccessRightsOptList()
    {
	if(alertCO.getAlertsParamCO().getAccessRightsOptList()!=null && alertCO.getAlertsParamCO().getAccessRightsOptList().size()>0)
	{
	    StringBuffer s = new StringBuffer();
	    s.append("[");
	    for (int i = 0 ; i < alertCO.getAlertsParamCO().getAccessRightsOptList().size();i++)
	    {
		s.append("\"");
		s.append(alertCO.getAlertsParamCO().getAccessRightsOptList().get(i));
		s.append("\"");
		if(i < (alertCO.getAlertsParamCO().getAccessRightsOptList().size() - 1))
		{
		    s.append(",");
		}
	    }
	    s.append("]");
	return s.toString();
	}
	return null;
    }
    /**
     * Loads the Approve Alerts details page
     * 
     * @return
     */
    public String loadApproveAlerts() throws JSONException
    {
	return "loadApproveAlertsPage";
    }

    /**
     * Check the userName & password for approval
     * 
     * @return
     * @throws BaseException
     */
    public String checkApproveAlerts() throws AuthenticationException, BaseException
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    BigDecimal compCode = sessionCO.getCompanyCode();
	    BigDecimal branchCode = sessionCO.getBranchCode();
	    String apName = sessionCO.getCurrentAppName();
	    String machineIp = sessionCO.getMachineIp();

	    int allowAccess = -1;
	    // allowAccess = loginBO.authenticateUser(alertCO.getUserName(),
	    // alertCO.getPassword(), machineIp, apName,
	    // sessionCO.getLanguage());
	    // NABIL FEGHALI - 21/02/2014 -As per the modifcation done by Paty,
	    // the loginBO.encryptAuthenticateUser should be called
	    String[] res = loginBO.encryptAuthenticateUser(alertCO.getUserName(), alertCO.getPassword(), machineIp,
		    apName, sessionCO.getLanguage(), ConstantsCommon.returnAppVersion(),sessionCO.getHttpSessionID());
	    if(res != null && res.length > 1)
	    {
		allowAccess = Integer.parseInt(StringUtil.nullEmptyToValue(res[1], "-1"));
	    }
	    // brach open function to be added by denisk
	    if(apName.equals(ConstantsCommon.RET_APP_NAME) || apName.equals(ConstantsCommon.RADM_APP_NAME))
	    {
		loginBO.checkBranchSession(compCode, branchCode, sessionCO.getUserName());
	    }

	    if(allowAccess == 1)
	    {
		CTSTELLERSC ctsTellerSC = new CTSTELLERSC();
		ctsTellerSC.setUserId(alertCO.getUserName());
		ctsTellerSC.setCompCode(compCode);
		ctsTellerSC.setBranchCode(branchCode);
		CTSTELLERVO ctsTellerVO = loginBO.loadTellerDetails(ctsTellerSC, sessionCO.getMachineIp(),sessionCO.getHttpSessionID());
		// String
		// isBranchManger=ctsTellerVO.getUSER_IS_BRANCH_MANAGER();
		ctsTellerSC.setSubTellerCode(ctsTellerVO.getCODE());
		ctsTellerSC.setSubTellerUserId(sessionCO.getUserName());
		int isSubordinate = alertsBO.returnIsSubordinate(ctsTellerSC);

		// The condition to check if the user doing the local approve is
		// a branchManager is commented because in PB its also commented
		/*
		 * isBranchManger != null && ( isBranchManger.equals("0") ||
		 * isSubordinate<=0 )
		 */
		if(isSubordinate <= 0)
		{
		    throw new BOException(MessageCodes.TELLER_NOT_SUBORDINATE_OF_MANAGER, new String[] {
			    sessionCO.getUserName(), alertCO.getUserName() });
		}

		AlertsSC alertsSC = new AlertsSC();
		alertsSC.setTellerId(sessionCO.getUserName());// the initial
		// user that have
		// to send the
		// alert
		alertsSC.setUserId(alertCO.getUserName());// the one who will do
		// the approve
		alertsSC.setAppName(apName);
		alertsSC.setBranchCode(branchCode);
		alertsSC.setCompCode(compCode);

		// The call of callToDoDet is not needed in java, its used in PB
		// to open the item datawindow
		// alertsSC.setUserAction(AlertsConstants.USER_ACTION_G);
		// alertsSC.setJobAction(AlertsConstants.JOB_ACTION_G);
		// alertsSC=alertsBO.callToDoDet(alertsSC);
		sessionCO.setLocalApproveUserName(alertCO.getUserName());
		alertsSC.setProgRef(alertCO.getAlertsParamCO().getProgRef());
		if(alertCO.getAlertsParamCO().getAccessRightsOptList()!=null &&alertCO.getAlertsParamCO().getAccessRightsOptList().size()>0)
		{
		    alertsSC.setAccessRightsOptList( Arrays.asList(alertCO.getAlertsParamCO().getAccessRightsOptList().toArray(new String[]{})));
		}
		// Set profType from PTH_CTRL because its used inside
		// commonLibMapper.select_Common_Priveleges"
		PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
		alertsSC.setProfType(NumberUtil.nullToZero(pthCtrl.getPOP_PROF_MOD_ACCESS()));

		int accessPrivilege = alertsBO.returnAccessPrivileges(alertsSC);
		if(accessPrivilege <= 0)
		{
		    throw new BOException(MessageCodes.NO_ACCESS);
		}
		else
		{
		    // Setting the local approve user name
		    sessionCO.setLocalApproveUserName(alertCO.getUserName());
		    return "success";
		}
	    }
	    else if(allowAccess == ConstantsCommon.NO_OLD_PWD_UPON_LOGIN
		    || allowAccess == ConstantsCommon.OLD_PWD_UPON_LOGIN_EXSTS
		    || allowAccess == ConstantsCommon.OLD_PWD_UPON_PWD_EXPIRY)
	    {
		// Throw a message to indicate that password should be changed
		throw new BOException(MessageCodes.INVALID_LOGON_PASSWORD);
	    }

	}
	catch(BaseException e)
	{
	    // Catch the baseException that be thrown from
	    // loginBO.loadTellerDetails and transform them into BOException to
	    // handle the message
	    if(e.getErrorCode() != null
		    && (e.getErrorCode().equals(MessageCodes.USER_TELLER_INACTIVE)
			    || e.getErrorCode().equals(MessageCodes.USER_TELLER_SUSPENDED)
			    || e.getErrorCode().equals(MessageCodes.INVALID_USER_TELLER) || e.getErrorCode().equals(
			    MessageCodes.ERROR_RETRIEVE_USR_INFO)))
	    {
		e = new BOException(e.getErrorCode());
	    }
	    handleException(e, null, null);
	}
	// Fix issue #245524 - When throwing a BadCredentialsException, the
	// message title is by default ERROR.
	// A catch is added to change the error title to Access Denied
	catch(BadCredentialsException e)
	{
	    BOException ex = new BOException(e.getMessage());
	    handleException(ex, null, null);
	    set_msgTitle(getText("access_denied_key"));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "success";
    }

    /**
     * This function is called to check the password before opening the item of
     * a transactionnal alert
     * 
     * @return
     * @throws BaseException
     */
    public String checkPassWordAlerts() throws BaseException
    {
	try
	{
	    // Check for password
	    // Call of f_validate_password(ls_password,gv_userid)
	    SessionCO sessionCO = returnSessionObject();
	    PasswordChangeCO pwdChangeCO = new PasswordChangeCO();
	    pwdChangeCO.setUserName(sessionCO.getUserName());
	    pwdChangeCO.setOldPwd(alertCO.getPassword());
	    pwdChangeCO.setSessionID(sessionCO.getHttpSessionID());
	    pwdChangeCO.setAppName(sessionCO.getCurrentAppName());
	    loginBO.checkOldPassword(pwdChangeCO);
	}
	catch(BOException e)
	{
	    if(e.getErrorCode() != null && e.getErrorCode().equals(MessageCodes.INVALID_OLD_PWD))
	    {
		e = new BOException(MessageCodes.INVALID_LOGON_PASSWORD);
	    }
	    handleException(e, null, null);
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return "success";
    }

    /**
     * function used to check if the alert status not changed before opening the item
     * @return
     * @throws BaseException
     */
    public String checkBeforeOpenItemForApprove() throws BaseException
    {
	try
	{
	    alertCO.getAlertsParamCO().setStatus(AlertsConstants.STATUS_ACTIVE);
	    alertsBO.checkIfSameStatus(alertCO.getAlertsParamCO());
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return "success";
    }
    
    /*
     * Redirect to the AlertsOpenItem.jsp
     */
    public String openItemForApprove() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	alertCO.setLanguage(sessionCO.getLanguage());
	// check if its ask for password : CTSCONTROL.PASSWD_ALERT
	if(alertCO.getAlertsParamCO() != null && !Boolean.valueOf(alertCO.getAlertsParamCO().getIsLocalApprove())
		&& AlertsConstants.ALERT_TYPE_TRANS.equals(alertCO.getAlertsParamCO().getAlertType())
		&& !Boolean.valueOf(alertCO.getIsCheckForPassWord()))
	{

	    String askForPassword = "0";
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
		ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
		ctsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
		ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);
		if(ctsControlVO != null)
		{
		    askForPassword = ctsControlVO.getPASSWD_ALERT();
		}
	    }

	    if("1".equals(askForPassword))
	    {
		alertCO.setIsCheckForPassWord(Boolean.TRUE.toString());
		alertCO.setUserName(sessionCO.getUserName());
		return "loadCheckPassWordAlert";
	    }

	}
	// end checking if ask for password

	// Set refresh data message
	alertCO.setRefreshDataMessage(returnCommonLibBO().returnTranslErrorMessage(MessageCodes.RECORD_CHANGED,
		sessionCO.getLanguage()));

	// Getting the OPT_URL, OPEN_METHOD, APPROVE_METHOD and REJECT_METHOD
	// from SYS_PARAM_TODO_ALERT_TYPEVO
	SYS_PARAM_TODO_ALERT_TYPEVO sysParamTodoAlertTypeVO = new SYS_PARAM_TODO_ALERT_TYPEVO();
	sysParamTodoAlertTypeVO.setTODO_ALERT(alertCO.getAlertsParamCO().getTodoAlert());
	sysParamTodoAlertTypeVO.setAPP_NAME(StringUtil.nullToEmpty(_appName).isEmpty() ? sessionCO.getCurrentAppName()
		: _appName);
	sysParamTodoAlertTypeVO = alertsBO.returnSysParamTodoAlertType(sysParamTodoAlertTypeVO);

	if(alertCO != null)
	{
	    if(!Boolean.valueOf(alertCO.getAlertsParamCO().getIsLocalApprove()))
	    {
		S_TODO_DETVO currentSTodoDet = new S_TODO_DETVO();
		currentSTodoDet.setTODO_CODE(alertCO.getAlertsParamCO().getTodoCode());
		currentSTodoDet.setTODO_LINE(alertCO.getAlertsParamCO().getTodoLine());
		currentSTodoDet = alertsBO.returnSTodoDet(currentSTodoDet);
		if(currentSTodoDet != null)
		{
		    alertCO.getAlertsParamCO().setCompCode(currentSTodoDet.getCOMP_CODE());
		    alertCO.getAlertsParamCO().setBranchCode(currentSTodoDet.getBRANCH_CODE());
		}
	    }

	    String optURL = StringUtil.nullToEmpty(sysParamTodoAlertTypeVO.getOPT_URL());
	    StringBuffer openMethodUrl = new StringBuffer(StringUtil.nullToEmpty(sysParamTodoAlertTypeVO
		    .getOPEN_METHOD()));
	    StringBuffer approveMethodUrl = new StringBuffer(StringUtil.nullToEmpty(sysParamTodoAlertTypeVO
		    .getAPPROVE_METHOD()));
	    StringBuffer rejectMethodUrl = new StringBuffer(StringUtil.nullToEmpty(sysParamTodoAlertTypeVO
		    .getREJECT_METHOD()));

	    // Adjust OPEN_METHOD by adding the mapped parameters.
	    String parameters = addMappedParameters(alertCO.getAlertsParamCO().getProgRef(), sessionCO
		    .getCurrentAppName());
	    alertCO.setItemPageRef(alertCO.getAlertsParamCO().getProgRef() + AlertsConstants.PAGE_REF_SUFFIX);
	    alertCO.setOpenItemParams(parameters);
	    if(openMethodUrl.indexOf(AlertsConstants.PARMETERS_SEPARATOR) == -1)
	    {
		openMethodUrl.append(AlertsConstants.PARMETERS_SEPARATOR);
		alertCO.setOpenMethodUrl(optURL + openMethodUrl.toString());

	    }
	    else
	    {
		alertCO.setOpenMethodUrl(optURL + openMethodUrl.toString() + AlertsConstants.PARMETERS_CONCATENATOR);
	    }

	    // Adjust APPROVE_METHOD by adding the mapped parameters.
	    if(approveMethodUrl.indexOf(AlertsConstants.PARMETERS_SEPARATOR) == -1)
	    {
		approveMethodUrl.append(AlertsConstants.PARMETERS_SEPARATOR);
		alertCO.setApproveMethodeUrl(optURL + approveMethodUrl.toString());
	    }
	    else
	    {
		alertCO.setApproveMethodeUrl(optURL + approveMethodUrl.toString()
			+ AlertsConstants.PARMETERS_CONCATENATOR);
	    }

	    // Adjust REJECT_METHOD by adding the mapped parameters.
	    if(rejectMethodUrl.indexOf(AlertsConstants.PARMETERS_SEPARATOR) == -1)
	    {
		rejectMethodUrl.append(AlertsConstants.PARMETERS_SEPARATOR);
		alertCO.setRejectMethodUrl(optURL + rejectMethodUrl.toString());
	    }
	    else
	    {
		alertCO
			.setRejectMethodUrl(optURL + rejectMethodUrl.toString()
				+ AlertsConstants.PARMETERS_CONCATENATOR);
	    }
	}

	return "loadApproveAlertsItem";
    }
    
    /**
     * function used to load forward alert in iframe when clicked from landing page and in case the alert record had specific FORWARD_METHOD in SYS_PARAM_TODO_ALERT_TYPE
     * @return
     * @throws BaseException
     */
    public String loadForwardIframe() throws BaseException
    {
	returnForwardUrl();
	return "loadForwardIframe";
    }

    /**
     * This function is called from forward button to construct forward url
     * 
     * @return
     * @throws BaseException
     */
    public String returnForwardUrl() throws BaseException
    {
	try
	{
	    //check if alert status has been changed    
	    alertsBO.checkIfSameStatus(alertCO.getAlertsParamCO());
        	
	    // Getting the OPT_URL, OPEN_METHOD, APPROVE_METHOD and REJECT_METHOD
	    // from SYS_PARAM_TODO_ALERT_TYPEVO
	    SYS_PARAM_TODO_ALERT_TYPEVO sysParamTodoAlertTypeVO = new SYS_PARAM_TODO_ALERT_TYPEVO();
	    sysParamTodoAlertTypeVO.setTODO_ALERT(alertCO.getAlertsParamCO().getTodoAlert());
	    sysParamTodoAlertTypeVO.setAPP_NAME(alertCO.getAlertsParamCO().getAppName());
	    sysParamTodoAlertTypeVO = alertsBO.returnSysParamTodoAlertType(sysParamTodoAlertTypeVO);
	    if(alertCO != null && sysParamTodoAlertTypeVO != null
        		&& StringUtil.isNotEmpty(sysParamTodoAlertTypeVO.getFORWARD_METHOD()))
	    {
		S_TODO_DETVO currentSTodoDet = new S_TODO_DETVO();
		currentSTodoDet.setTODO_CODE(alertCO.getAlertsParamCO().getTodoCode());
		currentSTodoDet.setTODO_LINE(alertCO.getAlertsParamCO().getTodoLine());
		currentSTodoDet = alertsBO.returnSTodoDet(currentSTodoDet);
		if(currentSTodoDet != null)
		{
		    alertCO.getAlertsParamCO().setReceivedFrom(currentSTodoDet.getRECEIVED_FROM());
		    alertCO.getAlertsParamCO().setCompCode(currentSTodoDet.getCOMP_CODE());
		    alertCO.getAlertsParamCO().setBranchCode(currentSTodoDet.getBRANCH_CODE());
		    alertCO.getsTodoDet().setTODO_STATUS(currentSTodoDet.getTODO_STATUS()); 
        	}
        
		String optURL = StringUtil.nullToEmpty(sysParamTodoAlertTypeVO.getOPT_URL());
		StringBuffer forwardMethodUrl = new StringBuffer(StringUtil.nullToEmpty(sysParamTodoAlertTypeVO
			.getFORWARD_METHOD()));
		
		// Adjust OPEN_METHOD by adding the mapped parameters.
		String parameters = addMappedParameters(alertCO.getAlertsParamCO().getProgRef(), alertCO.getAlertsParamCO().getAppName());
		alertCO.setItemPageRef(alertCO.getAlertsParamCO().getProgRef() + AlertsConstants.PAGE_REF_SUFFIX);
		alertCO.setOpenItemParams(parameters);
        
		// Adjust FORWARD_METHOD by adding the mapped parameters.
		if(forwardMethodUrl.indexOf(AlertsConstants.PARMETERS_SEPARATOR) == -1)
		{
		    forwardMethodUrl.append(AlertsConstants.PARMETERS_SEPARATOR);
		    alertCO.setForwardMethodUrl(optURL + forwardMethodUrl.toString());
        	}
		else
		{
		    alertCO.setForwardMethodUrl(optURL + forwardMethodUrl.toString()
		    + AlertsConstants.PARMETERS_CONCATENATOR);
        	}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }

    public String printAlertIframe() throws BaseException
    {
	setIv_crud("print");
	return "loadTrxDetailsIframe";
    }

    /**
     * This function is called from print button to construct print url
     * 
     * @return
     * @throws BaseException
     */
    public String returnPrintUrl() throws BaseException
    {
	// Getting the OPT_URL, OPEN_METHOD, APPROVE_METHOD and REJECT_METHOD
	// from SYS_PARAM_TODO_ALERT_TYPEVO
	String appName = alertCO.getAlertsParamCO().getAppName();

	SYS_PARAM_TODO_ALERT_TYPEVO sysParamTodoAlertTypeVO = new SYS_PARAM_TODO_ALERT_TYPEVO();
	sysParamTodoAlertTypeVO.setTODO_ALERT(alertCO.getAlertsParamCO().getTodoAlert());
	sysParamTodoAlertTypeVO.setAPP_NAME(appName);
	sysParamTodoAlertTypeVO = alertsBO.returnSysParamTodoAlertType(sysParamTodoAlertTypeVO);
	if(alertCO != null && sysParamTodoAlertTypeVO != null)
	{
	    S_TODO_DETVO currentSTodoDet = new S_TODO_DETVO();
	    currentSTodoDet.setTODO_CODE(alertCO.getAlertsParamCO().getTodoCode());
	    currentSTodoDet.setTODO_LINE(alertCO.getAlertsParamCO().getTodoLine());
	    currentSTodoDet = alertsBO.returnSTodoDet(currentSTodoDet);
	    if(currentSTodoDet != null)
	    {
		alertCO.getAlertsParamCO().setCompCode(currentSTodoDet.getCOMP_CODE());
		alertCO.getAlertsParamCO().setBranchCode(currentSTodoDet.getBRANCH_CODE());
	    }

	    String optURL = StringUtil.nullToEmpty(sysParamTodoAlertTypeVO.getOPT_URL());
	    StringBuffer printMethodUrl = new StringBuffer(StringUtil.nullToEmpty(sysParamTodoAlertTypeVO
		    .getPRINT_METHOD()));
	    
	    if(printMethodUrl.length() == 0)
	    {
		alertCO.setPrintMethodUrl("");
		return SUCCESS;
	    }

	    // Adjust OPEN_METHOD by adding the mapped parameters.
	    String parameters = addMappedParameters(alertCO.getAlertsParamCO().getProgRef(), appName);
	    alertCO.setItemPageRef(alertCO.getAlertsParamCO().getProgRef() + AlertsConstants.PAGE_REF_SUFFIX);
	    alertCO.setOpenItemParams(parameters);

	    // Adjust PRINT_METHOD by adding the mapped parameters.
	    if(printMethodUrl.indexOf(AlertsConstants.PARMETERS_SEPARATOR) == -1)
	    {
		printMethodUrl.append(AlertsConstants.PARMETERS_SEPARATOR);
		alertCO.setPrintMethodUrl(optURL + printMethodUrl.toString());
	    }
	    else
	    {
		alertCO.setPrintMethodUrl(optURL + printMethodUrl.toString() + AlertsConstants.PARMETERS_CONCATENATOR);
	    }

	    // Fix Issue #242382 - change the status of the alert to D
	    S_TODO_DETVO updateSTodoDet = new S_TODO_DETVO();
	    updateSTodoDet.setTODO_CODE(alertCO.getAlertsParamCO().getTodoCode());
	    updateSTodoDet.setTODO_LINE(alertCO.getAlertsParamCO().getTodoLine());
	    updateSTodoDet.setTODO_STATUS(AlertsConstants.STATUS_DELETED);
	    alertsBO.updateAlertStatusAfterOk(updateSTodoDet);
	}

	return SUCCESS;
    }

    /**
     * This function will add the additional parameters to the action based on
     * the mapping defined in alertsConstant
     * 
     * @param method
     * @return
     */
    private String addMappedParameters(String progRef, String appName) throws BaseException
    {
	Map<String, Object> params = new HashMap<String, Object>();
	String parenRef = "";
	String ivCrud = "";
	String optRef = "";
	String jsonStringParams = "";
	Map<String, Object> openItemMap = null;
	if(StringUtil.isNotEmpty(progRef) && StringUtil.isNotEmpty(appName))
	{
	    String originPageRef = returnCommonLibBO().returnOrginProgRef(appName, progRef);

	    String[] optDetailsArr = returnCommonLibBO().returnOptDetailsList(appName, originPageRef);
	    if(optDetailsArr != null && optDetailsArr.length >= 5)
	    {
		ivCrud = StringUtil.nullToEmpty(optDetailsArr[2]);
		parenRef = StringUtil.nullToEmpty(optDetailsArr[3]);
		optRef = StringUtil.nullToEmpty(optDetailsArr[4]);
	    }
	    if(ConstantsCommon.FMS_APP_NAME.equals(appName))
	    {
		// TP#667779; Ajas.Abbas; 10/05/2018
		// This condition is added to avoid the static prog ref

		if(progRef.length() >= 7)
		{
		    if(StringUtil.isNotEmpty(parenRef))
		    {
			parenRef = parenRef.substring(3);
		    }
		    if(StringUtil.isNotEmpty(optRef))
		    {
			optRef = optRef.substring(3);
		    }

		    // TP#221234; Ajas.Abbas; Date 23/09/2014

		    // originPageRef = originPageRef.substring(0, 4);

		    // TP#267235; Ajas.Abbas; Date 19/02/2015,Commented above
		    // and
		    // added below
		    originPageRef = progRef.substring(3, 7);
		}
	    }

	    // Check if OPEN_ITEM_PARAMS_MAPPING contains an entry for progRef
	    openItemMap = alertsBO.returnAlertsParamMap(appName, originPageRef);// AlertsConstants.OPEN_ITEM_PARAMS_MAPPING.get(progRef);
	    if(openItemMap != null && !openItemMap.isEmpty())
	    {
		if(openItemMap.containsKey(AlertsConstants.OPEN_ITEM_IV_CRUD_KEY))
		{
		    String crudValue = StringUtil.nullToEmpty(openItemMap.get(AlertsConstants.OPEN_ITEM_IV_CRUD_KEY))
			    .trim();
		    if(!crudValue.isEmpty())
		    {
			ivCrud = crudValue;
		    }
		}
		params = applyOpenItemParams(openItemMap);
	    }
	    // Check if OPEN_ITEM_PARAMS_MAPPING contains an entry for parentRef
	    // of the progRef
	    if(openItemMap == null && parenRef != null && StringUtil.isNotEmpty(parenRef))
	    {
		openItemMap = alertsBO.returnAlertsParamMap(appName, parenRef); // AlertsConstants.OPEN_ITEM_PARAMS_MAPPING.get(parenRef);
		if(openItemMap != null && !openItemMap.isEmpty())
		{
		    params = applyOpenItemParams(openItemMap);
		}
	    }
	    // Check if OPT_REFERENCE is defined for the specific pageRef
	    // This is the checking on dynamic opt
	    if(openItemMap == null && optRef != null && StringUtil.isNotEmpty(optRef))
	    {
		openItemMap = alertsBO.returnAlertsParamMap(appName, optRef);// AlertsConstants.OPEN_ITEM_PARAMS_MAPPING.get(optRef);
		if(openItemMap == null || openItemMap.isEmpty())
		{
		    optDetailsArr = returnCommonLibBO().returnOptDetailsList(appName, optRef);
		    if(optDetailsArr != null && optDetailsArr.length >= 5)
		    {
			ivCrud = StringUtil.nullToEmpty(optDetailsArr[2]);
			parenRef = StringUtil.nullToEmpty(optDetailsArr[3]);
		    }

		    // Check if OPEN_ITEM_PARAMS_MAPPING contains an entry for
		    // parentRef of the progRef
		    if(openItemMap == null && parenRef != null && StringUtil.isNotEmpty(parenRef))
		    {
			openItemMap = alertsBO.returnAlertsParamMap(appName, parenRef);// AlertsConstants.OPEN_ITEM_PARAMS_MAPPING.get(parenRef);
			if(openItemMap != null && !openItemMap.isEmpty())
			{
			    params = applyOpenItemParams(openItemMap);
			}
		    }
		}
		else
		{
		    params = applyOpenItemParams(openItemMap);

		}
	    }

	    params.put("_pageRef", progRef + AlertsConstants.ALERTS_PAGE_REF_SUFFIX);
	    params.put("iv_crud", ivCrud);

	    try
	    {
		jsonStringParams = PathJSONUtil.strutsJsonSerialize(params);
	    }
	    catch(Exception e)
	    {
		throw new BaseException(e);
	    }

	}
	return jsonStringParams;
    }

    /**
     * @author nabilfeghali
     * @param openItemMap
     * @return
     * @throws BaseException
     */
    private Map<String, Object> applyOpenItemParams(Map<String, Object> openItemMap) throws BaseException
    {
	Map<String, Object> params = new HashMap<String, Object>();
	if(openItemMap != null && !openItemMap.isEmpty())
	{
	    Map<String, String> paramMap = (Map<String, String>) openItemMap.get(AlertsConstants.OPEN_ITEM_PARAMS_KEY);
	    if(paramMap != null && !paramMap.isEmpty())
	    {
		params = buildURLParams(paramMap);
	    }

	    if(params.containsKey(AlertsConstants.LOAD_IN_NEW_WINDOW))
	    {
		alertCO.setLoadInNewWindow(String.valueOf(params.get(AlertsConstants.LOAD_IN_NEW_WINDOW)));
	    }

	    alertCO.setPrepareParamsJsFunction(StringUtil.nullToEmpty(
		    openItemMap.get(AlertsConstants.OPEN_ITEM_JS_FUNC_KEY)).trim());

	    alertCO.setAddButtonJsFunction(StringUtil.nullToEmpty(
		    openItemMap.get(AlertsConstants.OPEN_ITEM_ADD_BUTTON_FUNCTION_KEY)).trim());

	    alertCO.setCallBackJsFunc(StringUtil.nullToEmpty(openItemMap.get(AlertsConstants.CALL_BACK_FUNC_KEY))
		    .trim());

	    alertCO.setCallBackPrintFunc(StringUtil.nullToEmpty(
		    openItemMap.get(AlertsConstants.CALL_BACK_PRINT_FUNC_KEY)).trim());

	    alertCO.setCallBackPrintFuncRequireJs(StringUtil.nullToEmpty(
		    openItemMap.get(AlertsConstants.CALL_BACK_PRINT_REQUIRE_JS_KEY)).trim());

	    alertCO.setCallBackPrintFuncRequirePath(StringUtil.nullToEmpty(
		    openItemMap.get(AlertsConstants.CALL_BACK_PRINT_REQUIRE_PATH_KEY)).trim());

	}
	return params;
    }

    /**
     * @author NabilFeghali
     * @param paramMap
     * @return
     * @throws BaseException
     */
    private Map<String, Object> buildURLParams(Map<String, String> paramMap) throws BaseException
    {
	Map<String, Object> returnedParamMap = new HashMap<String, Object>();

	if(paramMap != null && !paramMap.isEmpty())
	{
	    for(Entry<String, String> entry : paramMap.entrySet())
	    {
		// In case a String value is defined in the
		// SYS_PARAM_OPT_TECH_DETAILS_D
		// The double quotes are removed from the beginning and the end
		// of the String
		// And the value is directly assigned to the key.
		String openItemParam = entry.getValue();

		// Add case when SYS_PARAM_OPT_TECH_DETAILS_D.ALERT_PARAM field
		// start with quotation or double quotation
		if(openItemParam != null
			&& ((openItemParam.startsWith("\"") && openItemParam.endsWith("\"")) || (openItemParam
				.startsWith("\'") && openItemParam.endsWith("\'"))))
		{
		    // In case of String value, the value is returned directly
		    // without any evaluation
		    returnedParamMap.put(entry.getKey(), openItemParam.substring(1, openItemParam.length() - 1));
		}
		else
		{
		    Object propertyObject = PathPropertyUtil.returnProperty(alertCO, openItemParam);
		    returnedParamMap.put(entry.getKey(), propertyObject);
		}
	    }
	}

	return returnedParamMap;
    }

    /**
     * This function is called
     * 
     * @return
     * @throws BaseException
     */
    public String clearLocalApproveUserName() throws BaseException
    {
	// Set the local approve user name to null
	returnSessionObject().setLocalApproveUserName(null);
	return SUCCESS;
    }

    /**
     * This function is used to set the alert status to 'D' if the item is
     * approved from the OPT
     * 
     * @return
     * @throws BaseException
     */
    public String refreshAlertData() throws BaseException
    {
	try
	{
	    S_TODO_DETVO sTodoDet = new S_TODO_DETVO();
	    sTodoDet.setTODO_CODE(alertCO.getAlertsParamCO().getTodoCode());
	    sTodoDet.setTODO_LINE(alertCO.getAlertsParamCO().getTodoLine());
	    alertsBO.fUpdateTodo(sTodoDet, AlertsConstants.UPDATE_NO_TRX);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setLoginBO(LoginBO loginBO)
    {
	this.loginBO = loginBO;
    }

    public void setAlertsBO(AlertsBO alertsBO)
    {
	this.alertsBO = alertsBO;
    }

    /**
     * @param appName the _appName to set
     */
    public void set_appName(String appName)
    {
	_appName = appName;
    }

    public AlertCO getAlertCO()
    {
	return alertCO;
    }

}
