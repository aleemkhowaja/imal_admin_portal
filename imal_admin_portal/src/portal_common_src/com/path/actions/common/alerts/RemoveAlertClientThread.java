/**
 * 
 */
package com.path.actions.common.alerts;

import org.eclipse.jetty.continuation.Continuation;

import com.path.bo.common.alerts.AlertsEngineBO;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.log.Log;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          AlertsCommonMethods.java used to: This class is used to execute the
 *          removeAlertClientTask in a separate thread so that the
 *          UnsecureAction.logout() or the
 *          CustomSessionListener.sessionDestroyed() will complete processing
 *          without waiting the removeAlertClientTask() to be completed.
 */
public class RemoveAlertClientThread extends Thread
{
    private static Log log = Log.getInstance();

    private final String currentAppName;
    private final String usrCompBrKey;
    private final String userName;
    private final String httpSessionID;
    
    public RemoveAlertClientThread(String currentAppName, String usrCompBrKey, String userName, String httpSessionID)
    {
	super();
	this.currentAppName = currentAppName;
	this.usrCompBrKey = usrCompBrKey;
	this.userName = userName;
	this.httpSessionID = httpSessionID;
    }

    @Override
    public void run()
    {
	try
	{
	    // this thread will call the method removeAlertClientTask
	    removeAlertClientTask(currentAppName, usrCompBrKey, userName, httpSessionID);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in  RemoveAlertClientThread.removeAlertClientTask");
	}
    }

    /**
     * This task is used on sessionTimeout or on logout to close the
     * AlertsAjaxWebClient client, in order to close the consumer on the client
     * topic
     * 
     * @param currentAppName
     * @param usrCompBr
     * @param userName
     * @throws Exception
     */
    private void removeAlertClientTask(String currentAppName, String usrCompBrKey, String userName, String httpSessionID) throws Exception
    {
	AlertsEngineBO alertsEngineBO = (AlertsEngineBO) ApplicationContextProvider.getApplicationContext().getBean(
		"alertsEngineBO");
	// If the alerts engine is started
	if(alertsEngineBO.isAlertsEnabled(currentAppName))
	{
	    // Get the AlertsAjaxWebClient
	    AlertsAjaxWebClient client = AlertsAjaxServlet.getAlertAjaxClient(usrCompBrKey);
	    if(client != null)
	    {
	      try
	      {
		
		Continuation continuation = client.getContinuation();
		// If the continuation is null we should close the client
		// directly and clear the map
		if(continuation == null)
		{
		    AlertsAjaxServlet.closeAndRemoveAlertAjaxClient(client, httpSessionID);
		}
		else
		{
		    // If there is a pending httprequest, we should send a
		    // timeout message because we are sure
		    // that the timeout message will reach the AlertsAjaxServlet
		    // and it will not be kept in
		    // the MessageBuffer of the listener. The timeout message
		    // sent will cause the following actions :
		    // 1-Free the pending HttpRequest
		    // 2-Close the AlertsAjaxWebClient inside the
		    // AlertsAjaxServlet and remove the client from the map of
		    // AlertsAjaxWebClient
		    // 3-Return a timeout message to the browse
		    // 4-Stop polling in the alert_engine.js at the browser side
		    // Note that the pending request exists when there isn't a
		    // popup alerts opened
		    // When the popup alerts opens on the client side, we stop
		    // the polling so no pending request

		    if(continuation.isSuspended())
		    {
			client.setSessionTimeout(true);
			continuation.setAttribute(AlertsAjaxServlet.PATH_ALERT_TIMEOUT_USRCOMPBRKEY, usrCompBrKey);
			alertsEngineBO.sendTimeoutMessage(usrCompBrKey, userName);
		    }
		    // Other wise If there is no pending httprequest, then we
		    // should close the client directly an d clean the map of
		    // the AlertsAjaxWebClient
		    // We cannot send a timeout message because it will not
		    // reach the servlet it will be blocked in the MessageBuffer
		    else
		    {
			AlertsAjaxServlet.closeAndRemoveAlertAjaxClient(client, httpSessionID);
		    }
		}
              }
	      catch(Throwable e)
	      {
		log.error(e, "Error in  RemoveAlertClientThread.removeAlertClientTask, exception at level of continuation");
		AlertsAjaxServlet.closeAndRemoveAlertAjaxClient(client, httpSessionID);
	      }
	    }
	}

    }

}