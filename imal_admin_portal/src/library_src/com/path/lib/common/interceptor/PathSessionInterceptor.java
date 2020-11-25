/**
 * 
 */
package com.path.lib.common.interceptor;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.path.bo.common.BaseServices;
import com.path.bo.common.CommonLibBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.dbmaps.vo.S_APPLOGVO;
import com.path.lib.common.base.BaseServicesImpl;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.struts2.lib.common.base.BaseInterceptor;
import com.path.vo.common.CommonLibCO;
import com.path.vo.common.SessionCO;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: marwanmaddah
 * 
 *          PathSessionInterceptor.java used to
 */
@SuppressWarnings("serial")
public class PathSessionInterceptor extends BaseInterceptor
{
    protected final static Log pathlog = Log.getInstance();

    @Override
    public String intercept(ActionInvocation invocation) throws Exception
    {
	boolean toLogout = false;
	String accessChangedMsg = null;
	String result;
	try
	{
	    CommonLibCO commonLibCO = null;
	    Map<String, Object> session = ActionContext.getContext().getSession();
	    BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext().getBean(
		    "baseServices");
	    CommonLibBO commonLibBO = baseServices.returnCommonLibBO();
	    SessionCO sessionCO = (SessionCO) session.get(ConstantsCommon.SESSION_VO_ATTR);
	    /**
	     * in case of kill the session if forced to logout and set attribute in new session to
             * catch it in sessionTimeout method to display correct message
             * in this case we have to avoid the interceptor for that we will check the forcedLoggedOut
             *  
	     * the condition on companyCode has been added to avoid http session checking in case company & branch are not defined yet 
	     * (added after the changes on setSessionId location to be before company & branch step)
	     */
	    if(session.get("forcedLoggedOut") == null && sessionCO != null && sessionCO.getHttpSessionID()!=null && sessionCO.getCompanyCode()!=null)
	    {
		String sessionId = sessionCO.getHttpSessionID();
		S_APPLOGVO sAppLogVO = new S_APPLOGVO();
		sAppLogVO.setCOMP_CODE(sessionCO.getCompanyCode());
		sAppLogVO.setBRANCH_CODE(sessionCO.getBranchCode());
		sAppLogVO.setAPP_NAME(sessionCO.getCurrentAppName());
		sAppLogVO.setUSER_ID(sessionCO.getUserName());
		sAppLogVO.setWEB_HTTP_SESSION_ID(sessionId);
		commonLibCO = commonLibBO.checkHttpSession(sAppLogVO);
		if(commonLibCO !=null && !commonLibCO.getCheckStillLoggedIn())
		{
		    toLogout = true;
		}
		
		//in case comming from login in premain.jsp and the username or comp or branch is changed, we need to bypass the force logout and open the screen directly
		HttpServletRequest request = ServletActionContext.getRequest();
		if(toLogout && request != null && request.getSession().getAttribute("reload_user_session_details") != null)
		{
		    toLogout = false;
		}
		
		if(commonLibCO != null 
			&& BigDecimal.ONE.equals(NumberUtil.emptyDecimalToZero(commonLibCO.getAxsChanged())))
		{
		    String[] confirmationMessage = commonLibBO.returnTranslMessage(MessageCodes.ACCESS_PRIVILEGES_FOR_USER_HAVE_BEEN_CHANGED, sessionCO.getLanguage());
		    if(confirmationMessage != null && confirmationMessage.length > 0)
		    {
			accessChangedMsg = confirmationMessage[0]; 
		    }
		}
	    }
	    if(toLogout)
	    {
		result = "forced_logged_out";
	    }
	    else
	    {
		/* Login Alert Implementation TP#297149 
		 In case the session does not contains the alertLoginApprovalFlag that means the login alert is disabled
		 In case of alertLoginApprovalFlag = 0 that means the login alert is enabled but the teller didn't receive the approval
		 */
		String alertLoginApprovalFlag = (String)session.get(AlertsConstants.ALERT_LOGIN_APPROVAL_FLAG);
		if(ConstantsCommon.ZERO.equals(alertLoginApprovalFlag))
		{
		    HttpServletRequest request = ServletActionContext.getRequest();
		    String requestURL = request.getRequestURL().toString();
		    boolean urlFound = false;
		    //check if the url is allowed in login alert mode
		    for(String url : AlertsConstants.LOGIN_ALERT_ALLOWED_URL)
		    {
			if(requestURL.contains(url))
			{
			    urlFound = true;
			    break;
			}
		    } 
		    
		    if(urlFound)
		    {
			//we need to set the path_axs_changed before the invocation.invoke() otherwise it will stay null
			//if the request is coming from DesktopAction_resetUserAxsChange, we don't need to set path_axs_changed in response header
			if(StringUtil.isNotEmpty(accessChangedMsg) 
				&& !"resetUserAxsChange".equals(ServletActionContext.getRequest().getParameter("action")))
			{ 
			    ServletActionContext.getResponse().setHeader("path_axs_changed", accessChangedMsg);    
			} 
			//the url is allowed 
			result = invocation.invoke();
		    }
		    else
		    {
		    	// TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
		    	String alertLoginAfterFinalSignoffFlag = StringUtil.nullToEmpty(session.get(AlertsConstants.ALERT_LOGIN_AFTER_FINAL_SIGNOFF_FLAG));
		    	if(ConstantsCommon.ONE.equals(alertLoginAfterFinalSignoffFlag)) 
		    	{
					request.setAttribute(AlertsConstants.ALERT_LOGIN_AFTER_FINAL_SIGNOFF_FLAG, ConstantsCommon.ONE);
		    	}
		    	else 
		    	{
		    		request.setAttribute(AlertsConstants.ALERT_LOGIN_AFTER_FINAL_SIGNOFF_FLAG, ConstantsCommon.ZERO);
		    	}
		    	
		    	//return an error to block the url
				result = "login_alert_redirection";
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setStatus(ConstantsCommon.PATHSOL_INTERNAL_ERROR);
		    }
		}
		else
		{   
		    //we need to set the path_axs_changed before the invocation.invoke() otherwise it will stay null
		    //if the request is coming from DesktopAction_resetUserAxsChange, we don't need to set path_axs_changed in response header
		    if(StringUtil.isNotEmpty(accessChangedMsg)
			    && !"resetUserAxsChange".equals(ServletActionContext.getRequest().getParameter("action")))
		    { 
			ServletActionContext.getResponse().setHeader("path_axs_changed", accessChangedMsg); 
		    }
		    /**
		     * [MarwanMaddah]:this pre-listener class has been added to call the dynamic expression process after action invocation
		     * and the main purpose behind creating it is to catch all the need Args from the main request and also the variables that are changed inside the invoked action   
		     */
		    invocation.addPreResultListener(new PathPreResultListener(invocation,invocation.getResultCode()));
		    /**
		     * 
		     */
		    result = invocation.invoke();
		}    
	    }

	}
	catch(Exception e)
	{
	    Object action = invocation.getAction();
	    Log.getInstance().error(e, "Error in Path Session Interceptor"+ action.getClass().getCanonicalName());
	    result = ActionSupport.ERROR;
	    if(action instanceof BaseAction)
	    {
		BaseAction theBase = (BaseAction) action;
		try
		{
		    theBase.handleException(e, null, null);
		}
		catch(Exception ex)
		{
		    Log.getInstance().error(ex, "Error in Path Session Interceptor Catch block");
		    theBase.addActionError(theBase.getText("session_interceptor_exception_key")+"\nERROR:"+ex.getMessage());
		}
		result = theBase.ERROR_ACTION;
	    }
	}


	return result;
    }
}
