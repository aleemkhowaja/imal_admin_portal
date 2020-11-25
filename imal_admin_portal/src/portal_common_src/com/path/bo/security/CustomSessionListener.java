package com.path.bo.security;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.path.actions.common.alerts.AlertsCommonMethods;
import com.path.bo.common.CommonNonTransBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.login.LoginBO;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.log.Log;
import com.path.vo.common.SessionCO;

public class CustomSessionListener implements HttpSessionListener
{
    Log log = Log.getInstance();
    
    /**
     * have to add it because it is exists in the interface
     */
    public void sessionCreated(HttpSessionEvent arg0)
    {
	// WARNING do not include reading for session id here since it will cause a lot of created session upon logout or
	// performing log operations, since log will call session details again in PathLogFormatter
	//log.debug("Session has been created");
    }

    public void sessionDestroyed(HttpSessionEvent event)
    {
	HttpSession session = event.getSession();
//	log.error("[PATH-INFO] JUST FOR INFO WILL BE REMOVED LATER: session.getId() "+session.getId());
	SessionCO sessCO = (SessionCO) session.getAttribute(ConstantsCommon.SESSION_VO_ATTR);
	if(sessCO != null)
	{
	    String sessionId = sessCO.getHttpSessionID();
	    /**
	     * [MarwanMaddah]
	     * @userLoggedOutFromModule: in case this flag is set as TRUE in UnsecureAction\logout 
	     *                           that's mean no need to logoutFromModul again
	     * check on UserName has been added to avoid the entrance in case the request is from login screen 
	     * when put userName & password and before set them on the sessionCO.                           
	     */
	    if(sessCO.getUserName()!= null && sessionId != null && (session.getId().equals(sessionId) || !Boolean.TRUE.equals(session.getAttribute("userLoggedOutFromModule"))))
	    {
		    try
		    { 
			if(session.getId().equals(sessionId))
			{
			  //Remove the alertAjaxWebClient from the AlertsAjaxServlet map and close the consumer on the topic
    		    	  AlertsCommonMethods.removeAlertClient(sessCO.getCurrentAppName(), AlertsCommonMethods.returnUsrCompBrKey(sessCO), sessCO.getUserName(), sessCO.getHttpSessionID());
			}
			String forcedOut = (String)session.getAttribute("forcedLoggedOut");
			// check if not forced logout because if forced the user already logged out from module
			LoginBO loginBO = (LoginBO) ApplicationContextProvider.getApplicationContext().getBean("loginBO");
			if(forcedOut == null || !forcedOut.equals("1"))
			{
				//Do not put log.error check comments below in catch block
//				System.out.println((new StringBuilder(new java.util.Date()+"[CustomSessionListener] Manual Logout (updte S_APPLOG) - sessionCO.getHttpSession" +
//						 "ID() = "
//						 )).append(String.valueOf(sessCO.getHttpSessionID())).append(" sessionCO.getCompanyCode() = ").append(String.valueOf(sessCO.getCompanyCode())).append(" sessionCO.getBranchCode() = ").append(String.valueOf(sessCO.getBranchCode())).append(" sessionCO.getCurrentAppName() = ").append(String.valueOf(sessCO.getCurrentAppName())).append(" sessionCO.getUserName() = ").append(String.valueOf(sessCO.getUserName())).toString());

			    //logging out user on sessionTimeout
			    loginBO.logoutUserFromModule(sessCO.getUserName(), sessCO.getCurrentAppName(),sessCO.getMachineIp(),sessCO.getCompanyCode(),sessCO.getBranchCode(), "1",sessCO.getHttpSessionID(),false);
			}
			else 
			{
				//Do not put log.error check comments below in catch block
//				System.out.println((new StringBuilder(new java.util.Date()+"[CustomSessionListener] Froce Logout (only Inserting in S_USR_LOGOUT_LOG) - sessionCO.getHttpSession" +
//						 "ID() = "
//						 )).append(String.valueOf(sessCO.getHttpSessionID())).append(" sessionCO.getCompanyCode() = ").append(String.valueOf(sessCO.getCompanyCode())).append(" sessionCO.getBranchCode() = ").append(String.valueOf(sessCO.getBranchCode())).append(" sessionCO.getCurrentAppName() = ").append(String.valueOf(sessCO.getCurrentAppName())).append(" sessionCO.getUserName() = ").append(String.valueOf(sessCO.getUserName())).toString());
			       
			    //update logout log on forcelogout
			    loginBO.updateLogoutLogs(sessCO.getUserName(), sessCO.getCurrentAppName(),sessCO.getMachineIp(),sessCO.getCompanyCode(),sessCO.getBranchCode(), "1",sessCO.getHttpSessionID());
			}
		    }
		    catch(Exception e)
		    {
		    	//log.error(e, "Error in Calling logout method in CustomSessionListener");
		    	// need to have printStack Trace here instead of log.error because faced issue in JBOSS 
		    	//where block occurred since formatter is calling getsession which is destroyed, and hence recursive call is performed
		    	System.out.println("Error in Calling logout method in CustomSessionListener");
		    	e.printStackTrace();
		    }
	    }
	    // check if the session has UserName then need to terminate its sessions
	    if(sessCO.getUserName()!= null)
	    {
		try
		{
		    // need non transactional BO to kill the still pending session upon logout
		    CommonNonTransBO commonNonTransBO = (CommonNonTransBO) ApplicationContextProvider.getApplicationContext().getBean("commonNonTransBO");
		    // terminate SQL sessions related Http Session Id.
		    commonNonTransBO.terminateSQLSession(session.getId());
		}
		catch(Exception e)
		{
//		    log.error(e, "Error in terminating SQL sessions in CustomSessionListener");
		 // need to have printStack Trace here instead of log.error because faced issue in JBOSS 
	    	//where block occurred since formatter is calling getsession which is destroyed, and hence recursive call is performed
	    	System.out.println("Error in terminating SQL sessions in CustomSessionListener");
		    e.printStackTrace();
		}
	    }
	}
	
    }

}
