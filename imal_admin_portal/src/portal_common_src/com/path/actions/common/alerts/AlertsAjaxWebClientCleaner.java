package com.path.actions.common.alerts;
import java.util.Iterator;
import java.util.Map;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import com.path.lib.log.Log;
public class AlertsAjaxWebClientCleaner extends TimerTask
{
    private Long clientInactiveInterval = null;
    private static Log log = Log.getInstance();
    
    public AlertsAjaxWebClientCleaner(Long clientInactiveInterval)
    {
	super();
	this.clientInactiveInterval = clientInactiveInterval;
    }

    @Override
    public void run()
    {
	synchronized(AlertsAjaxServlet.pathAjaxWebClients)
	{
	    log.info("[AlertsAjaxWebClientCleaner] 1- number of connected subscribtion = " + AlertsAjaxServlet.pathAjaxWebClients.size() );
	    
	    Iterator<Map.Entry<String, AlertsAjaxWebClient>> iterator = AlertsAjaxServlet.pathAjaxWebClients.entrySet()
		    .iterator();
	    while(iterator.hasNext())
	    {
		Map.Entry<String, AlertsAjaxWebClient> entry = iterator.next();
		AlertsAjaxWebClient client = entry.getValue();

		boolean expired = false;
		long systemTime = System.currentTimeMillis();
		
		// if the session is null, then we should consider the client as expired
		HttpSession httpSession = client.getHttpSession();
		if(httpSession == null)
		{
		    expired = true;
		    log.info("[AlertsAjaxWebClientCleaner] 1- removing client key = " + client.getUsrCompBrKey() + " sessionId = " + client.getHttpSessionId() + " reason : httpSession is null ");
		}
		
		// if the session last accessed time exceeds the max inactive interval, the client is expired,
		// or if an IllegalStateException is thrown when accessing session attributes, the client is expired
		try
		{
		    long lastAccessedTime = httpSession.getLastAccessedTime();
		    if((systemTime - lastAccessedTime) > httpSession.getMaxInactiveInterval() * 1000)
		    {
			// The session has expired
			expired = true;
			log.info("[AlertsAjaxWebClientCleaner] 2- removing client key = " + client.getUsrCompBrKey() + " sessionId = " + client.getHttpSessionId() + " reason : lastAccessedTime = " + lastAccessedTime + " httpSession.getMaxInactiveInterval() = " + httpSession.getMaxInactiveInterval()+ " systemTime = " + systemTime);
		    }
		}
		catch(IllegalStateException e)
		{
		    expired = true;
		    log.info("[AlertsAjaxWebClientCleaner] 3- removing client key = " + client.getUsrCompBrKey() + " sessionId = " + client.getHttpSessionId() + " reason : IllegalStateException ");
		}
	         
		// in case the client is not accessed from the AlertsAjaxServlet for more than the value of clientInactiveInterval, 
		// then we should consider it as expired
		if(clientInactiveInterval != null && ((systemTime - client.getLastAccessDate().getTime()) > clientInactiveInterval * 1000) )
		{
		    expired = true;
		    log.info("[AlertsAjaxWebClientCleaner] 4- removing client key = " + client.getUsrCompBrKey() + " sessionId = " + client.getHttpSessionId() + " reason : clientInactiveInterval = " + clientInactiveInterval + " client.getLastAccessDate() = " + client.getLastAccessDate() + " systemTime = " + systemTime);
		}
		
		// close an expired client and remove it from the
		// pathAjaxWebClients hash.
		if(expired)
		{
		    client.close();
		    iterator.remove();
		    log.info("[AlertsAjaxWebClientCleaner] 5- closing and removing client key = " + client.getUsrCompBrKey() + " sessionId = " + client.getHttpSessionId());
		}
	    }
	    
	    log.info("[AlertsAjaxWebClientCleaner] 2- number of connected subscribtion = " + AlertsAjaxServlet.pathAjaxWebClients.size() );
	}
    }

    /**
     * function used to remove all clients when destroying the AlertsAjaxServlet
     */
    public static void removeAllClients()
    {
	Iterator<Map.Entry<String, AlertsAjaxWebClient>> iterator = AlertsAjaxServlet.pathAjaxWebClients.entrySet()
		.iterator();
	while(iterator.hasNext())
	{
	    Map.Entry<String, AlertsAjaxWebClient> entry = iterator.next();
	    AlertsAjaxWebClient client = entry.getValue();
	    client.close();
	    iterator.remove();
	}
	log.info("[AlertsAjaxWebClientCleaner] in removeAllClients , removing all clients ");
    }
    
}
