package com.path.actions.common.alerts;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.ConnectException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.web.AjaxWebClient;
import org.apache.activemq.web.MessageListenerServlet;
import org.apache.activemq.web.WebClient;
import org.apache.commons.lang.exception.ExceptionUtils;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.alerts.AlertsBrokerBO;
import com.path.bo.common.alerts.AlertsEngineBO;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.vo.common.SessionCO;

import net.sf.json.JSONObject;

public class AlertsAjaxServlet extends MessageListenerServlet
{
    private static Log log = Log.getInstance();
    
    // Path remoting properties
    private static final String PATH_REMOTING_PATH = "PathRemoting";
    private static final String ALERT_BROKER_URL_KEY = "alert.broker.url";
    private static final String CLUSTER_ENABLED_KEY = "global.cluster.enabled";
    private static final String ALERT_POLL_MAX_TIMEOUT_KEY = "alert.poll.maximumReadTimeout";
    private static final String TYPE_CHECK_ALIVE = "check_alive";
    private static final String CLUSTER_FAILOVER_ERROR = "cluster_failover_error";
    private static final String SERVLET_IP = "servletIp";
    private static final String ALERT_CLIENTCLEANER_ENABLED_KEY = "alert.clientcleaner.enabled";
    private static final String ALERT_CLIENTCLEANER_PERIOD_KEY = "alert.clientcleaner.period";
    private static final String ALERT_CLIENTCLEANER_DELAY_KEY = "alert.clientcleaner.delay";
    private static final String ALERT_CLIENTCLEANER_CLIENT_INACTIVE_INTERVAL_KEY = "alert.clientcleaner.clientInactiveInterval";
    private static final String ALERT_CLIENTCLEANER_CLIENT_INACTIVE_INTERVAL_DEFAULT = "32400";//32400s : the client inactivity time is 9h before destroying it
    private static final String ALERT_CLIENTCLEANER_PERIOD_DEFAULT = "36000";//36000s : the cleaner will check for consumers each 10h
    private static final String ALERT_CLIENTCLEANER_DELAY_DEFAULT = "600";//600s : to waits 10 minutes before starting the cleaner
    private static final String ALERT_ENGINE_APPNAME_KEY = "alert.engine.appName";
    // Request parameters
    public static final String PATH_ALERT_TIMEOUT_USRCOMPBRKEY = "alert.timeout.usrCompBrKey";
    
    // Pending timeout parameters This is the time that the query should be pended on the servlet, waiting to recesive a message
    private long pathMaximumReadTimeout = 1L;

    // The hash map to store AlertAjaxWebClient by userid-comp-br
    public static HashMap<String, AlertsAjaxWebClient> pathAjaxWebClients = new HashMap<String, AlertsAjaxWebClient>();

    //timer thread to clean non used consumers
    public static Timer clientCleanupTimer = null; 
    /**
     * This function will call the parent doPost in MessageListenerServlet 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	    IOException
    {
	try
	{
	    checkClusterFailover(request);
	    String type = request.getParameter("type");
	    if(TYPE_CHECK_ALIVE.equals(type))
	    {
		//In case of check_alive request. An empty response is directly returned, with HTTP status OK.
		response.setStatus(HttpServletResponse.SC_OK);
		return;
	    }
		
	    // call parent servlet method
	    super.doPost(request, response);
	}
	catch(Exception e)
	{
	    handleServletException(e,request,response);
	}
    }

    /**
     * This function will call the parent doGet in MessageListenerServlet 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	try
	{
	    checkClusterFailover(request);
	    // call parent servlet method
	    super.doGet(request, response);
	}
	catch(Exception e)
	{
	    handleServletException(e,request,response);
	}
    }
    
    /**
     * This function is used to handle exceptions like connection exception due to failover problems
     * @param e
     */
    private void handleServletException(Exception e, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	ServletContext servletContext = getServletContext();
	String clusterEnabled = String.valueOf(servletContext.getAttribute(CLUSTER_ENABLED_KEY));
	String enableLog = String.valueOf(servletContext.getAttribute("enableAlertLog"));
	Throwable cause = ExceptionUtils.getRootCause(e);
	if(Boolean.valueOf(clusterEnabled)
		&& ((e instanceof ServletException && (cause instanceof javax.jms.IllegalStateException || cause instanceof ConnectException)) 
		   || (e instanceof JMSException && CLUSTER_FAILOVER_ERROR.equals(((JMSException) e).getErrorCode()))
		   || (e instanceof JMSException && cause instanceof java.net.NoRouteToHostException )))
	{
		if("true".equals(enableLog))
		{
		    log.error(e,"[AlertLog AlertsAjaxServlet, handleServletException before returnActiveBrokerURL] "+returnUserAndSessionID(request));

		}
	    returnActiveBrokerURL(request);
	    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    JSONObject responseObject = new JSONObject();
	    responseObject.put("servletIp", CommonMethods.encodeBase64((String)getServletContext().getAttribute(SERVLET_IP)));
		if("true".equals(enableLog))
		{
		    log.error("[AlertLog AlertsAjaxServlet, handleServletException after returnActiveBrokerURL]: servletIp: "+CommonMethods.decodeBase64((String) responseObject.get("servletIp")) + returnUserAndSessionID(request));
		}
	    response.getWriter().write(responseObject.toString());
	    response.flushBuffer();
	}
	else
	{
	    if("true".equals(enableLog))
	    {
	    	log.error(e,"[AlertLog AlertsAjaxServlet, handleServletException Not JMS/connection]"+returnUserAndSessionID(request));
	    }
	    if(e instanceof ServletException)
	    {
		throw (ServletException)e;
	    }
	    else if(e instanceof IOException)
	    {
		throw (IOException)e;
	    }
		
	}
    }
    
    /**
     * function used to start a new instance of the broker in case of cluster failover
     * @param request
     */
    private void returnActiveBrokerURL(HttpServletRequest request)
    {
	try
	{
	    AlertsAjaxWebClient alertAjaxWebClient = (AlertsAjaxWebClient) getAjaxWebClient(request);
	    SessionCO sessCo = null;
	    String httpSessionId = null;
	    sessCo = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
	    if(sessCo != null)
	    {
	    	httpSessionId = sessCo.getHttpSessionID();
	    }
	    ServletContext servletContext = getServletContext();
	    String enableLog = (String) getServletContext().getAttribute("enableAlertLog");
	    if("true".equals(enableLog))
	    {
	    	log.error("[AlertLog AlertsAjaxServlet, returnActiveBrokerURL] " + returnUserAndSessionID(request));
	    }
	    if(alertAjaxWebClient != null)
	    {
	    	closeAndRemoveAlertAjaxClient(alertAjaxWebClient, httpSessionId);
	    }

	    // get an instance of alertsEngineBO
	    AlertsEngineBO alertsEngineBO = (AlertsEngineBO) ApplicationContextProvider.getApplicationContext()
		    .getBean("alertsEngineBO");
	    String newBrokerURL = alertsEngineBO.returnActiveBrokerURL();

	    String currentBrokerURL = servletContext.getAttribute(WebClient.BROKER_URL_INIT_PARAM) == null ? "" : servletContext
		    .getAttribute(WebClient.BROKER_URL_INIT_PARAM).toString();
	    if("true".equals(enableLog))
	    {
	    	String sessionVals = null;
	    	if(sessCo != null)
	    	{
	    		sessionVals = " Company: "+ sessCo.getCompanyCode() + " Branch: " + sessCo.getBranchCode() + returnUserAndSessionID(request)+ " Machine IP: " + sessCo.getMachineIp();
	    	}
	    	log.error("[AlertLog AlertsAjaxServlet, returnActiveBrokerURL]: currentBrokerURL: " + currentBrokerURL +" newBrokerURL: " + newBrokerURL + sessionVals);
	    }
	    if(!currentBrokerURL.contains(newBrokerURL))
	    {
		// add performance parameters to the broker URL
		newBrokerURL = addBrokerURLParameters(newBrokerURL);
		// set the new broker URL value in the servlet context
		servletContext.setAttribute(WebClient.BROKER_URL_INIT_PARAM, newBrokerURL);
		servletContext.setAttribute(WebClient.CONNECTION_FACTORY_ATTRIBUTE, null);
		WebClient.setFactory(null);
		WebClient.initContext(getServletContext());
	    }

	}
	catch(Exception e)
	{
	    log.error(e, "[AlertLog AlertsAjaxServlet] returnActiveBrokerURL , error returning the active broker url");
	}
    }

    /**
     * This function will get the received message an write them in the http response
     */
    @Override
    protected void doMessages(AjaxWebClient client, HttpServletRequest request, HttpServletResponse response)
	    throws JMSException, IOException
    {
	checkClusterFailover(request);
	
	AlertsAjaxWebClient alertAjaxWebClient = (AlertsAjaxWebClient) client;
	
	super.doMessages(client, request, response);

	// check if its a session timeout and then close the client and remove the client from the map
	// in case of manual logout or http session timeout sessionco becomes null in session   
	if(alertAjaxWebClient != null && alertAjaxWebClient.isSessionTimeout())
	{
	    closeAndRemoveAlertAjaxClient(alertAjaxWebClient, null);
	}
    }
    
    /**
     * in case httpSessionId is provided and not null then we need to verify it's value to be equal to the httpsessionid in use inside the client be able to close the client,
     * otherwise if the httpsessionid is null, then we will close the client directly
     */
    public static void closeAndRemoveAlertAjaxClient(AlertsAjaxWebClient alertAjaxWebClient, String httpSessionId)
    {
	try
	{
	    // check is its a session timeout and then close the client and remove the client from the map
	    if(httpSessionId == null || httpSessionId.equals(alertAjaxWebClient.getHttpSessionId()))
	    {
		alertAjaxWebClient.close();
		removeAlertAjaxClient(alertAjaxWebClient.getUsrCompBrKey());
		log.info("[AlertLog AlertsAjaxServlet] closeAndRemoveAlertAjaxClient : removing client key = " + alertAjaxWebClient.getUsrCompBrKey() + " sessionId = " + alertAjaxWebClient.getHttpSessionId() );
	    }
	}
	catch(Throwable t)
	{
	    log.error(t,"[AlertLog AlertsAjaxServlet] closeAndRemoveAlertAjaxClient : error in closing the client");
	}
    }
    
    /**
     * This function will return the AjaxWebClient related to the current http session
     */
    @Override
    protected AjaxWebClient getAjaxWebClient(HttpServletRequest request)
    {
	String usrCompBrKey = null;
	AlertsAjaxWebClient client = null;
	SessionCO sessCo = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
	//If the sessionCO is null, that's mean that the session is timed out and removed from the ServletContext . the usrCompBr is then 
	//taken from the request. In fact, the custom session listener will set the usrCompBr in the request attributes on sessionDestroy
	if(sessCo == null)
	{
	    if(request.getAttribute(PATH_ALERT_TIMEOUT_USRCOMPBRKEY) != null)
	    {
		usrCompBrKey = (String) request.getAttribute(PATH_ALERT_TIMEOUT_USRCOMPBRKEY);
	    }
	    
	}
	//If the sessionCo is not null, thats mean that the HttpSession is alive, then we can take the usrCompBr from the sessionCO
	else
	{
	    usrCompBrKey = AlertsCommonMethods.returnUsrCompBrKey(sessCo);
	}

	//Check if the client exists inside the map
	client = getAlertAjaxClient(usrCompBrKey);
	//If it isnt then create a new client and store it in the map
	if(client == null)
	{
	    client = new AlertsAjaxWebClient(request, pathMaximumReadTimeout);
	    client.setUsrCompBrKey(usrCompBrKey);
	    putAlertAjaxClient(usrCompBrKey, client);
	}
	if(sessCo != null)
	{
	    client.setHttpSessionId(sessCo.getHttpSessionID());
	    client.setHttpSession(request.getSession());
	}
	client.setLastAccessDate(Calendar.getInstance().getTime());
	return client;
    }

    /**
     * This function will return the read timeout. its the time to block the http request (PENDING)
     * waiting to receive a message and return it to the browser (js)
     */
    @Override
    protected long getReadTimeout(HttpServletRequest request)
    {
	//If the request does not contain a timeout parameter, the value of read timeout is defaulted to pathMaximumReadTimeout
	// Path-Solutions - Fix Websphere Issue #177853
	// Read the max polling timeout directly from PathRemoting.properties
	/*
	long timeout = pathMaximumReadTimeout;
	String requestTimeout = request.getParameter(READ_TIMEOUT_PARAMETER);
	if(requestTimeout != null)
	{
	    try
	    {
		timeout = Long.parseLong(requestTimeout);
	    }
	    catch(NumberFormatException e)
	    {
		timeout = pathMaximumReadTimeout;
	    }
	}
	*/
	return pathMaximumReadTimeout;
    }

    /**
     * This function will the message in the response as an XML format :
     * <ajax-response>
     * 	<response id="2B87B46937F106BCAC8BDEF30A20D7E7_PATH_DESTINATION_MODEL.B" destination="topic://PATH_DESTINATION_MODEL.B">
     * 		<alert type="RECEIVE_ALERTS"></alert>
     * 	</response>
     * </ajax-response>
     */
    @Override
    protected void writeMessageResponse(PrintWriter writer, Message message, String idParam, String destinationNameParam)
	    throws JMSException, IOException
    {
	//AvoidReassigningParameters
	String id = idParam;
	
	//Escape single quote from response message
	if(id != null && id.indexOf("'") != -1)
	{
	    id = id.replaceAll("'", "&apos;");
	}
	String destinationName = destinationNameParam;
	if(destinationName != null && destinationName.indexOf("'") != -1)
	{
	    destinationName = destinationName.replaceAll("'", "&apos;");
	}
	// call parent servlet method in MessageListenerServlet
	super.writeMessageResponse(writer, message, id, destinationName);
    }

    /**
     * Initialization of the servlet. This function will get the broker URL and the maxReadTimeout
     * 
     * @throws ServletException if an error occurs
     */

    @Override
    public void init() throws ServletException
    {
	String brokerURI = null;
	String clusterEnabled = null;
	String servletIP = null;
	String enableLog = null;
	try
	{
	    //remove the clientCleanupTimer thread called "ActiveMQ Ajax Client Cleanup Timer" and that was created by the new Timer that has been created in MessageListenerServlet
	    Field timerField = ((MessageListenerServlet)this).getClass().getSuperclass().getDeclaredField("clientCleanupTimer");    
	    timerField.setAccessible(true);
	    Timer clientCleanupTimer = (Timer)timerField.get((MessageListenerServlet)this); 
	    if(clientCleanupTimer != null)
	    {
		clientCleanupTimer.cancel();
	    }
	    // Get the broker url form PathServices properties file.
	    brokerURI = PathPropertyUtil.getPathRemotingProp(PATH_REMOTING_PATH, ALERT_BROKER_URL_KEY);
	    
	    clusterEnabled = PathPropertyUtil.getPathRemotingProp(PATH_REMOTING_PATH, CLUSTER_ENABLED_KEY);
	    
	    // in case of cluster enabled, we need to get the broker URL from the brokerBO
	    if(StringUtil.isNotEmpty(brokerURI) && brokerURI.contains(","))
	    {
		 String[] brokerURIArray = brokerURI.trim().split(",");
		 brokerURI = brokerURIArray[0];
	    }
	    servletIP = InetAddress.getLocalHost().getHostAddress();

	    enableLog = StringUtil.nullEmptyToValue(PathPropertyUtil.getPathRemotingProp(
		    PATH_REMOTING_PATH, "enable.alert.logging"), "false");
	    
	    if("true".equals(enableLog))
	    {
		log.error("[AlertLog AlertsAjaxServlet, init servletIP]: "+servletIP + "brokerURI NO params: "+ brokerURI );
	    }
	}
	catch (Exception e) 
	{
	    log.error(e,"Error in AlertsAjaxServlet.init while preparing init parameters");
	}
	
	//Adjust the broker url defined in pathRemoting by adding the performance configuration 
	if(StringUtil.isNotEmpty(brokerURI))
	{
	    //add performance parameters to the broker URL
	    brokerURI = addBrokerURLParameters(brokerURI);

	    ServletContext servletContext = getServletContext();
	    //servletContext.setInitParameter(WebClient.BROKER_URL_INIT_PARAM, brokerURI);
	    //in order to change the brokerURL after initialization of the AlertsAjaxServlet, 
	    //we need to use setAttribute() instead of setInitParameter() because setAttribute() can be called several times
	    //while setInitParameter() can be called once.
	    servletContext.setAttribute(WebClient.BROKER_URL_INIT_PARAM, brokerURI);
	    //set the cluster enabled flag as attribute in the servlet context
	    servletContext.setAttribute(CLUSTER_ENABLED_KEY, clusterEnabled);
	    //set the servlet ip in context to be used when checking for cluster failover
	    servletContext.setAttribute(SERVLET_IP, servletIP);
	    //set the enable alert log in servlet context to avoid reading from pathremoting on each usage
	    servletContext.setAttribute("enableAlertLog", enableLog);
	    if("true".equals(enableLog))
	    {
		log.error("[AlertLog AlertsAjaxServlet, init servletIP]: "+servletIP + "brokerURI with params: "+ brokerURI);
	    }
	}
	
	try
	{
	    // Initalize maximum read timeout
	    pathMaximumReadTimeout = asLong(StringUtil.nullEmptyToValue(PathPropertyUtil.getPathRemotingProp(
		    PATH_REMOTING_PATH, ALERT_POLL_MAX_TIMEOUT_KEY), "100000000"));
	
	    // The init() method should not be called in order to stop the
	    // TimerCleaner in MessageListenerServlet because this cleaner will
	    // remove the Ajax client if its not accessed since 1 min
	    // super.init();
	    boolean clientCleanerEnabled = ConstantsCommon.TRUE.equals(StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile(PATH_REMOTING_PATH,ALERT_CLIENTCLEANER_ENABLED_KEY),ConstantsCommon.FALSE).trim());
	    if(clientCleanerEnabled)
	    {
		long period = Long.valueOf(StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile(PATH_REMOTING_PATH,ALERT_CLIENTCLEANER_PERIOD_KEY),ALERT_CLIENTCLEANER_PERIOD_DEFAULT).trim());
		long delay = Long.valueOf(StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile(PATH_REMOTING_PATH,ALERT_CLIENTCLEANER_DELAY_KEY),ALERT_CLIENTCLEANER_DELAY_DEFAULT).trim());
		long clientInactivity = Long.valueOf(StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile(PATH_REMOTING_PATH,ALERT_CLIENTCLEANER_CLIENT_INACTIVE_INTERVAL_KEY),ALERT_CLIENTCLEANER_CLIENT_INACTIVE_INTERVAL_DEFAULT).trim());
		
		clientCleanupTimer = new Timer("ActiveMQ_AjaxClientCleanupTimer_"+ConstantsCommon.returnCurrentAppName(), true);
		clientCleanupTimer.schedule( new AlertsAjaxWebClientCleaner(clientInactivity), delay*1000, period*1000 );
		log.info("[AlertLog AlertsAjaxServlet] init() method : starting clientCleanUpTimer with delay : " + delay + "s and period :" + period + "s" );
		
		String applicationName = StringUtil.nullToEmpty(PathPropertyUtil.getPathRemotingProp(PATH_REMOTING_PATH, ALERT_ENGINE_APPNAME_KEY)).trim();
		// initialize the application names to check if the broker should be started
		List<String> appNameList = Arrays.asList(applicationName.replaceAll(" ", "").split(","));
		// don't continue the servlet initialization if the APP_NAME is notdefined in pathremoting
		if(appNameList == null || appNameList.isEmpty() || !appNameList.contains(ConstantsCommon.returnCurrentAppName()))
		{
		    if(clientCleanupTimer != null)
		    {
			clientCleanupTimer.cancel();
		    }
		    return;
		}
	    }
	}
	catch(Exception e)
	{
	    log.error(e,"Error while reading alert.poll.maximumReadTimeout from PathRemoting.properties");
	}
    }
    
    
    
    /* (non-Javadoc)
     * @see org.apache.activemq.web.MessageListenerServlet#destroy()
     */
    @Override
    public void destroy()
    {
	//remove the cleaner thread
	if(clientCleanupTimer != null)
	{
	    clientCleanupTimer.cancel();
	}
	
	//remove all clients to close all connections 
	AlertsAjaxWebClientCleaner.removeAllClients();
	
	// TODO Auto-generated method stub
	super.destroy();
    }

    /**
     * This function will add the performance parameters to the broker url
     * @param brokerURI
     * @return
     */
    private String addBrokerURLParameters(String brokerURI)
    {
	//Adjust the broker url defined in pathRemoting by adding the performance configuration 
	if(StringUtil.isNotEmpty(brokerURI))
	{
	    String questionMark = "?";
	    if(brokerURI.contains(questionMark))
	    {
		brokerURI = brokerURI.substring(0, brokerURI.indexOf(questionMark) + 1).concat(
			AlertsBrokerBO.BROKER_URL_PARAMETERS);
	    }
	    else
	    {
		brokerURI = brokerURI.concat(questionMark).concat(AlertsBrokerBO.BROKER_URL_PARAMETERS);
	    }
	}
	return brokerURI;
    }
    
    /**
     * This function will return the AlertsAjaxWebClient from the storing map
     * @param usrCompBrKey
     * @return
     */
    public static AlertsAjaxWebClient getAlertAjaxClient(String usrCompBrKey)
    {
	AlertsAjaxWebClient client = null;
	synchronized(pathAjaxWebClients)
	{
	    client = pathAjaxWebClients.get(usrCompBrKey);
	}
	return client;
    }
    
    /**
     * This function will put an AlertsAjaxWebClient in the storing map
     * @param client
     */
    public static void putAlertAjaxClient(String usrCompBrKey, AlertsAjaxWebClient client)
    {
	synchronized(pathAjaxWebClients)
	{
	    pathAjaxWebClients.put(usrCompBrKey,client);
	}
    }
    /**
     * This function will remove an AlertsAjaxWebClient from the storing map
     * @param usrCompBrKey
     */
    public static void removeAlertAjaxClient(String usrCompBrKey)
    {
	synchronized(pathAjaxWebClients)
	{
	    pathAjaxWebClients.remove(usrCompBrKey);
	}
    }
    
    /**
     * This function will check if servlet ip has been changed after a cluster failover and will throw an exception
     */
    private void checkClusterFailover(HttpServletRequest request) throws JMSException
    {
	String clusterEnabled = (String) getServletContext().getAttribute(CLUSTER_ENABLED_KEY);
	if(Boolean.valueOf(clusterEnabled))
	{
	    String servletIpParam = CommonMethods.decodeBase64(request.getParameter("servletIp"));
	    String servletIp = (String)getServletContext().getAttribute(SERVLET_IP);
	    if(StringUtil.isNotEmpty(servletIp) && StringUtil.isNotEmpty(servletIpParam)
		    && !servletIp.equals(servletIpParam))
	    {
		String enableLog = (String) getServletContext().getAttribute("enableAlertLog");
		if("true".equals(enableLog))
		{
			log.error("[AlertLog AlertsAjaxServlet, checkClusterFailover servletIP]: "+servletIp + " servletIpParam: "+ servletIpParam + returnUserAndSessionID(request));
		}
		// when the servlet ip is changed that mean the cluster detected a failover in a node
		throw new JMSException("[AlertLog AlertsAjaxServlet][checkClusterSessionFailOver]cluster failover detected", CLUSTER_FAILOVER_ERROR);
	    }
	}
    }
    
    private String returnUserAndSessionID(HttpServletRequest request)
    {
	String userId = null, sessionId = null, machineIp = null;
	SessionCO sessCo = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
	if(sessCo != null)
	{
	    userId = sessCo.getUserName();
	    sessionId = sessCo.getHttpSessionID();
	    machineIp = sessCo.getMachineIp();
	}
	return " userId: "+ userId + " sessionId: "+ sessionId + " machineIp: " + machineIp;
    }
}
