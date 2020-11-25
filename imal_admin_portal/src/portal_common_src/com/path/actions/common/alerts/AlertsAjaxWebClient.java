/**
 * 
 */
package com.path.actions.common.alerts;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.transport.InactivityMonitor;
import org.apache.activemq.transport.MutexTransport;
import org.apache.activemq.transport.ResponseCorrelator;
import org.apache.activemq.transport.Transport;
import org.apache.activemq.transport.TransportThreadSupport;
import org.apache.activemq.transport.WireFormatNegotiator;
import org.apache.activemq.transport.nio.NIOTransport;
import org.apache.activemq.transport.tcp.TcpTransport;
import org.apache.activemq.web.AjaxListener;
import org.apache.activemq.web.AjaxWebClient;
import org.eclipse.jetty.continuation.Continuation;

import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          AlertsAjaxWebClient.java used to
 */
public class AlertsAjaxWebClient extends AjaxWebClient /*implements HttpSessionActivationListener*/
{ 
    //This is a continuation property. its set in the customSessionListener on sessionDestroy to keep a trace on the destroyed session.
    //This property will be stored as a request attribute in the HTTPREQUEST, 
    //and will be used in the AlertAjaxServlet to find the HttpSessionId when the SessionCO becomes NULL
    private static final String CONTINUATION_FIELD_NAME = "continuation";
    //This is a flag that indicate that the client is invalid due to session timeout.
    private boolean isSessionTimeout;// = false;
    //This property represents the userid-Comp-Br Key
    private String usrCompBrKey;
    //This property represents the httpSessionId
    private String httpSessionId;
    //the http session 
    private HttpSession httpSession;
    //the last access date of client, updated on each retrieve of the client from the pathAjaxWebClients map.  
    private Date lastAccessDate;
    //logger
    private static Log log = Log.getInstance();
        
    public AlertsAjaxWebClient()
    {
	super(null, 100000000);
    }
    
    public AlertsAjaxWebClient(HttpServletRequest request, long maximumReadTimeout)
    {
	super(request, maximumReadTimeout);
    }

    /**
     * This function will return the Continuation object (Instance of Servlet3Continuation) from the AjaxListener of the AlertsAjaxWebClient.
     * The continuation will allow us to know if there is a pending query inside the AlertsAjaxServlet.
     * If continuation.isSuspended() return true, thats means that there is a pending query that waits for message.
     * @return
     * @throws BaseException
     */
    public Continuation getContinuation() throws BaseException
    {
	Continuation continuationReturned = null;
	try
	{
	    Field continuationField = AjaxListener.class.getDeclaredField(CONTINUATION_FIELD_NAME);
	    continuationField.setAccessible(true);
	    //Return the continuation instance from the ajax listener of the client. 
	    continuationReturned = (Continuation) continuationField.get(this.getListener());
	}
	catch(Exception e)
	{
	    throw new BaseException(e);
	}
	return continuationReturned;
    }

    /* 
     * Override the getConnection() to be able to rename the activemq connection thread
     */
    @Override
    public Connection getConnection() throws JMSException
    {
	// TODO Auto-generated method stub
	Connection connection = super.getConnection();
	try
	{
	  if(connection != null && connection instanceof ActiveMQConnection)
	  {
	    ActiveMQConnection amqConnection = (ActiveMQConnection)connection;
	    Transport transport = amqConnection.getTransport();
	    if(transport != null && transport instanceof ResponseCorrelator)
	    {
		ResponseCorrelator responseCorrelator = (ResponseCorrelator)transport;
		Transport transport1 = responseCorrelator.getNext();
		if(transport1 != null && transport1 instanceof MutexTransport )
		{
		    MutexTransport mutexTransport = (MutexTransport)transport1;
		    Transport transport2 = mutexTransport.getNext();
		    if(transport2 != null && transport2 instanceof WireFormatNegotiator)
		    {
			WireFormatNegotiator wireFormatNegotiator = (WireFormatNegotiator)transport2;
			Transport transport3 = wireFormatNegotiator.getNext();
			if(transport3 != null && transport3 instanceof InactivityMonitor)
			{
			    InactivityMonitor inactivityMonitor = (InactivityMonitor)transport3;
			    Transport transport4 = inactivityMonitor.getNext();
			    if(transport4 != null && transport4 instanceof NIOTransport)
			    {
				//in case of NIO transport we cannot set the thread name because the runner thread is null, it is created from the threadpoolexecutor.
				return connection;
			    }
			    if(transport4 != null && transport4 instanceof TcpTransport)
			    {
				TcpTransport tcpTransport = (TcpTransport)transport4;
				if( tcpTransport != null && tcpTransport instanceof TransportThreadSupport)
				{
				    try
				    {
					Field runnerField = tcpTransport.getClass().getSuperclass().getDeclaredField("runner");    
					runnerField.setAccessible(true);
					Thread runner = (Thread)runnerField.get(tcpTransport); 
					if(runner != null)
					{
					    String currentDateStr = DateUtil.format(Calendar.getInstance().getTime(),"dd_MM_yyyy_hh_mm_ss");
					    runner.setName(StringUtil.nullToEmpty(runner.getName() + "-" + currentDateStr + "-" + ConstantsCommon.returnCurrentAppName() + "-" + getUsrCompBrKey()));
					}
				    }
				    catch(Throwable t)
				    {
					log.error(t, "[AlertsAjaxWebClient] getConnection() :  Error setting ActiveMQ Transport thread name");
				    }
				}
			    }
			}
		    }
		}
	    }
	  }
	}
	catch(Throwable e)
	{
	    log.error(e, "[AlertsAjaxWebClient] getConnection() : Error when accessing the TCP Transport");
	}
	
	return connection;
    }

    public boolean isSessionTimeout()
    {
	return isSessionTimeout;
    }

    public void setSessionTimeout(boolean isSessionTimeout)
    {
	this.isSessionTimeout = isSessionTimeout;
    }

    /**
     * @return the usrCompBrKey
     */
    public String getUsrCompBrKey()
    {
        return usrCompBrKey;
    }

    /**
     * @param usrCompBrKey the usrCompBrKey to set
     */
    public void setUsrCompBrKey(String usrCompBrKey)
    {
        this.usrCompBrKey = usrCompBrKey;
    }

    /**
     * @return the httpSessionId
     */
    public String getHttpSessionId()
    {
        return httpSessionId;
    }

    /**
     * @param httpSessionId the httpSessionId to set
     */
    public void setHttpSessionId(String httpSessionId)
    {
        this.httpSessionId = httpSessionId;
    }
    
    /**
     * @return the lastAccessDate
     */
    public Date getLastAccessDate()
    {
        return lastAccessDate;
    }

    /**
     * @param lastAccessDate the lastAccessDate to set
     */
    public void setLastAccessDate(Date lastAccessDate)
    {
        this.lastAccessDate = lastAccessDate;
    }

    /**
     * @return the httpSession
     */
    public HttpSession getHttpSession()
    {
        return httpSession;
    }

    /**
     * @param httpSession the httpSession to set
     */
    public void setHttpSession(HttpSession httpSession)
    {
        this.httpSession = httpSession;
    }
    
}
