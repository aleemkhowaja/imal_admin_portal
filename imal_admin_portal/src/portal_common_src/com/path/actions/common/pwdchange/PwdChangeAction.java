package com.path.actions.common.pwdchange;

import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.struts2.ServletActionContext;

import com.path.actions.common.login.DesktopAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.login.LoginBO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.common.MainMenuVO;
import com.path.vo.common.PasswordChangeCO;
import com.path.vo.common.SessionCO;

public class PwdChangeAction extends DesktopAction
{
    PasswordChangeCO pwdChangeCO = new PasswordChangeCO();
    String language;
    String isRTL;
    String successMessage;
    private String currentURL;

    @Override
    public Object getModel()
    {
	return pwdChangeCO;
    }

    public String openChangePwd() 
    {
	String returnResult;
	try
	{
	    SessionCO sessionCO = sessionCOInitialize();
	    UsrCO usrCO = loginBO.returnAdDetails(sessionCO.getUserName());
	    boolean isADUser = ConstantsCommon.AUTH_LDAP_ENABLED.equals(usrCO.getAD_AUTH_YN()) && !StringUtil.nullToEmpty(usrCO.getAD_USER_ID()).isEmpty();
	    // TP #933826 :ABSAI190603 - Cannot change iMAL password from Java applications
	 	boolean authenticatedByIMAL = sessionCO.getAuthenticatedBy().equals(ConstantsCommon.USER_LOGIN_CRITERIA_IMAL);
	    if(isADUser && !authenticatedByIMAL)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }
	    
	    if(sessionCO.getBranchCode() == null || sessionCO.getCompanyCode() == null)
	    {
	        sessionCO.setMachineIp(returnIP());
	        // fill User Details in SessionCO
	        fillUserDetails(sessionCO);
	    }
	    currentURL = "/pwdchange/changePwdAction";
	    portalSettings();
	    returnResult = "";
	    int allowAccess = sessionCO.getAllowAccess() ; 
	    // redirect to ChangePwdScreen
	    if(allowAccess == ConstantsCommon.NO_OLD_PWD_UPON_LOGIN || allowAccess == ConstantsCommon.OLD_PWD_UPON_LOGIN_EXSTS
		  || allowAccess ==   ConstantsCommon.OLD_PWD_UPON_PWD_EXPIRY
		  || allowAccess ==   ConstantsCommon.PASSWD_SET_BY_ADMIN)
	    {
	        pwdChangeCO.setAllowAccess(sessionCO.getAllowAccess());
	        if(allowAccess ==   ConstantsCommon.OLD_PWD_UPON_PWD_EXPIRY)
	        {
	            addActionMessage(getText("pwdvalidityExpired_key"));
	        }
	        returnResult = "pwdChange";
	    }
	    // check if the old pwd exists and capthca must be displayed or not.
	    if(allowAccess == ConstantsCommon.OLD_PWD_UPON_LOGIN_EXSTS
		  || allowAccess ==   ConstantsCommon.OLD_PWD_UPON_PWD_EXPIRY
		  || allowAccess ==   ConstantsCommon.PASSWD_SET_BY_ADMIN)
	    {
		PTH_CTRLVO pth = returnCommonLibBO().returnPthCtrl();
		if(ConstantsCommon.ONE.equals(pth.getENABLE_CAPTCHA_YN()))
		{
		    if((pth.getNBR_BEF_CAPTCHA() == null || pth.getNBR_BEF_CAPTCHA().compareTo(new BigDecimal(0)) == 0))
		    {
			pwdChangeCO.setCaptchaEnabled(ConstantsCommon.ONE);
		    }
		    else if(NumberUtil.nullToZero(usrCO.getUNSUCCESS_LOGINS()).compareTo(pth.getNBR_BEF_CAPTCHA()) > -1)
		    {
			pwdChangeCO.setCaptchaEnabled(ConstantsCommon.ONE);
		    }
		 }
	    }
	    
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    returnResult = ERROR;
	}
	return returnResult;
    }

    private void portalSettings() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	applyDirection();
	setHeaderMenu();
	HashMap<String, Object> userNbFormats = new HashMap<String, Object>();
	userNbFormats.put(DateUtil.DATE_MASK_ATTRIBUTE, DateUtil.DEFAULT_DATE_FORMAT);
	// default number format specification
	userNbFormats.put("default", "###");
	sessionCO.setUserNbFormats(userNbFormats);
    }

    private void setHeaderMenu()
    {
	MainMenuVO menuVO = new MainMenuVO();
	 menuVO.setMenuHeaderName(getText("language_key"));
	 menuVO.setList_id("lang_id");
	 menuVO.setSubHref("pathdesktop/TopMenuAction_menuLang.action");
	 lstMenu.add(menuVO);

	menuVO = new MainMenuVO();
	menuVO.setMenuHeaderName(getText("logout"));
	menuVO.setHref("j_spring_security_logout");
	lstMenu.add(menuVO);

	super.setHeaderMenu("");
    }
    @Override
    public void fillUserDetails(SessionCO sessionCO) throws Exception
    {
        UsrCO uinfo = loginBO.userLoginDet(returnUserName());
        if(uinfo != null)
	{
            setLoginBO(loginBO);
	    sessionCO.setLanguage(uinfo.getPREFERED_LANGUAGE());
	}
        super.fillUserDetails(sessionCO);
    }

    public String updatePwd()
    {
	String result = SUCCESS;
	SessionCO sessionCO = null;
	try
	{
	    sessionCO = returnSessionObject();
	    pwdChangeCO.setUserName(sessionCO.getUserName());
	    // setting allowAccess to specify if old password checking needed
	    pwdChangeCO.setAllowAccess(sessionCO.getAllowAccess());
	    
	    String userName  = sessionCO.getUserName();
	    String sessionID = sessionCO.getHttpSessionID();
	    String hostName  = sessionCO.getMachineIp();
	    
	    pwdChangeCO.setUserName(userName);
	    pwdChangeCO.setSessionID(sessionID);
	    pwdChangeCO.setHostName(hostName);
	    pwdChangeCO.setAppName(sessionCO.getCurrentAppName());
	    pwdChangeCO.setCompCode(sessionCO.getCompanyCode());
	    pwdChangeCO.setBranchCode(sessionCO.getBranchCode());
	    pwdChangeCO.setLanguage(sessionCO.getLanguage());
	    pwdChangeCO.setRunningDate(sessionCO.getRunningDateRET());
	    pwdChangeCO.setMachineIp(sessionCO.getMachineIp());
	    if(!ConstantsCommon.ONE.equals(pwdChangeCO.getCaptchaText()))
	    {
		pwdChangeCO.setCaptchUserText(null);
	    }
	    pwdChangeCO.setCaptchaText((String)ServletActionContext.getRequest().getSession().getAttribute("captchaText"));
	    
	    boolean userSuspended = loginBO.changePwd(pwdChangeCO, userName);
	    if(userSuspended)
	    {
		if(pwdChangeCO.getCompCode()!=null && pwdChangeCO.getBranchCode()!=null)
		{			
		    loginBO.logoutUserFromModule(pwdChangeCO.getUserName(), pwdChangeCO.getAppName(), pwdChangeCO.getHostName(), pwdChangeCO.getCompCode(), pwdChangeCO.getBranchCode(), "1", pwdChangeCO.getSessionID(), false);
		}
		ServletActionContext.getRequest().getSession().invalidate();
		ServletActionContext.getRequest().getSession(true).setAttribute("userTokenSuspended", "1");
		ServletActionContext.getRequest().getSession(true).setAttribute("fromChangePwd", "1");
		result = "suspendRedirect";
	    }
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		UsrCO usrCO = loginBO.returnAdDetails(sessionCO.getUserName());
		PTH_CTRLVO pth = returnCommonLibBO().returnPthCtrl();
		if(ConstantsCommon.ONE.equals(pth.getENABLE_CAPTCHA_YN()) && (ConstantsCommon.OLD_PWD_UPON_LOGIN_EXSTS == sessionCO.getAllowAccess()
			|| ConstantsCommon.OLD_PWD_UPON_PWD_EXPIRY == sessionCO.getAllowAccess()))
		{
		    if((pth.getNBR_BEF_CAPTCHA() == null || pth.getNBR_BEF_CAPTCHA().compareTo(new BigDecimal(0)) == 0))
		    {
			pwdChangeCO.setCaptchaEnabled(ConstantsCommon.ONE);
		    }
		    else if(NumberUtil.nullToZero(usrCO.getUNSUCCESS_LOGINS()).compareTo(pth.getNBR_BEF_CAPTCHA()) > -1)
		    {
			pwdChangeCO.setCaptchaEnabled(ConstantsCommon.ONE);
		    }
		}
	    }catch(Exception ex)
	    {
	    	handleException(ex, null, null);
	    }
	    	
	}
	pwdChangeCO.setOldPwd(null);
	pwdChangeCO.setNewPwd(null);
	pwdChangeCO.setConfirmPwd(null);
	pwdChangeCO.setCaptchUserText(null);
	return result;
    }

    public String reloginAction()
    {
	    try
	    {
		successMessage = getText("pwdChangeSuccess_key");
		addActionMessage(successMessage );
		sessionCOInitialize();
		portalSettings();
		// removing attribute that redirect to Change pwd screen
		ServletActionContext.getRequest().getSession().removeAttribute("Change_PWD");
		return SUCCESS;
	    }
	    catch(Exception e)
	    {
		// TODO Auto-generated catch block
		return ERROR;
	    }
    }
    
    public String checkOldPwd()
    {
	String result 		= SUCCESS;
	SessionCO sessionCO 	= null;
	String userName  	= null;
	try
	{
	    sessionCO = returnSessionObject();
	    userName  = sessionCO.getUserName();
	    String sessionID = sessionCO.getHttpSessionID();
	    String hostName  = sessionCO.getMachineIp();
	    
	    pwdChangeCO.setUserName(userName);
	    pwdChangeCO.setSessionID(sessionID);
	    pwdChangeCO.setHostName(hostName);
	    pwdChangeCO.setAppName(sessionCO.getCurrentAppName());
	    pwdChangeCO.setCompCode(sessionCO.getCompanyCode());
	    pwdChangeCO.setBranchCode(sessionCO.getBranchCode());
	    pwdChangeCO.setLanguage(sessionCO.getLanguage());
	    boolean userSuspended = loginBO.checkOldPassword(pwdChangeCO);
	    if(userSuspended)
	    {
		if(pwdChangeCO.getCompCode()!=null && pwdChangeCO.getBranchCode()!=null)
		{			
		    loginBO.logoutUserFromModule(pwdChangeCO.getUserName(), pwdChangeCO.getAppName(), pwdChangeCO.getHostName(), pwdChangeCO.getCompCode(), pwdChangeCO.getBranchCode(), "1", pwdChangeCO.getSessionID(), false);
		}
		ServletActionContext.getRequest().getSession().invalidate();
		ServletActionContext.getRequest().getSession(true).setAttribute("userTokenSuspended", "1");
		ServletActionContext.getRequest().getSession(true).setAttribute("fromChangePwd", "1");
		result = "suspendRedirect";
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		
		UsrCO usrCO = loginBO.returnAdDetails(sessionCO.getUserName());
		PTH_CTRLVO pth = returnCommonLibBO().returnPthCtrl();
		if(ConstantsCommon.ONE.equals(pth.getENABLE_CAPTCHA_YN()))
		{
		    if((pth.getNBR_BEF_CAPTCHA() == null || pth.getNBR_BEF_CAPTCHA().compareTo(new BigDecimal(0)) == 0))
		    {
			pwdChangeCO.setCaptchaEnabled(ConstantsCommon.ONE);
		    }
		    else if(NumberUtil.nullToZero(usrCO.getUNSUCCESS_LOGINS()).compareTo(pth.getNBR_BEF_CAPTCHA()) > -1)
		    {
			pwdChangeCO.setCaptchaEnabled(ConstantsCommon.ONE);
		    }
		}
	    }catch(Exception ex)
	    {
		handleException(ex, null, null);
	    }
	    
	}
	return result;
    }

    public void setLoginBO(LoginBO loginBO)
    {
	this.loginBO = loginBO;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public String getIsRTL()
    {
	return isRTL;
    }

    public void setIsRTL(String isRTL)
    {
	this.isRTL = isRTL;
    }

    public String getSuccessMessage()
    {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage)
    {
        this.successMessage = successMessage;
    }

    public String getCurrentURL()
    {
        return currentURL;
    }

    public void setCurrentURL(String currentURL)
    {
        this.currentURL = currentURL;
    }
}