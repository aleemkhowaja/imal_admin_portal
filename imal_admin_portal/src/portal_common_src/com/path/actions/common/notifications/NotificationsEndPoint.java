package com.path.actions.common.notifications;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jms.Connection;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.struts2.json.JSONUtil;

import com.path.bo.common.CommonLibBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.notifications.NotificationsCommonMethods;
import com.path.bo.common.notifications.engine.NotificationsEngineBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.log.Log;
import com.path.vo.common.SessionCO;

@ServerEndpoint(value = "/path/notificationsWS", configurator = PathWebSocketConfigurator.class)
/**
 * 
 * @author AdelNasrallah
 *
 *Class Used as WEb Socket end Point to listen to the Notification send to the user
 */
public class NotificationsEndPoint 
{

	Map<String, Map<String, Map<String, Session>>> usersByCompBrMap = Collections
			.synchronizedMap(new HashMap<String, Map<String, Map<String, Session>>>());
	private javax.jms.Session amqSession = null;
	private Connection amqConnection = null;
	private static Log log = Log.getInstance();
	private CommonLibBO commonLibBO;
	private List<String> userLanguages = new ArrayList<String>();
	/**
	 * Callback hook for Connection open events.
	 * 
	 * This method will be invoked when a client requests for a WebSocket
	 * connection.
	 * 
	 * @param userSession
	 *            the userSession which is opened.
	 */
	@OnOpen
	public void onOpen(Session userSession, EndpointConfig config) 
	{

		// retrieve the http session saved when intercepting handshake (PathWSHttpSessionConfigurator)
		// the http session allows us to retrieve the company code, branch code and username in order to be saved in hashmap of sessions
		// the hashmap is by company, by branch, by user
		HttpSession httpSession = (HttpSession) userSession.getUserProperties().get(HttpSession.class.getName());
		SessionCO sessCO = (SessionCO) httpSession.getAttribute(ConstantsCommon.SESSION_VO_ATTR);
		String compCode = sessCO.getCompanyCode().toString();
		String branchCode = sessCO.getBranchCode().toString();
		String userName = sessCO.getUserName();
		String userLanguage = sessCO.getLanguage();
		Map<String, Map<String, Session>> usersByBrMap;
		Map<String, Session> usersMap;

		log.debug("NotificationsEndPoint onOpen User Id:" + sessCO.getUserName());
		log.debug("NotificationsEndPoint onOpen Machine Id:" + sessCO.getMachineIp());

		if(!userLanguages.contains(userLanguage))
		{
			userLanguages.add(userLanguage);
		}

		// if the company doesn't exist, add it to the hashmap
		if (usersByCompBrMap.get(compCode) == null) 
		{
			usersByBrMap = new HashMap<String, Map<String, Session>>();
			usersByCompBrMap.put(compCode, usersByBrMap);

		}
		usersByBrMap = usersByCompBrMap.get(compCode);

		// if the branch doesn't exist, add it to the hashmap
		if (usersByBrMap.get(branchCode) == null) 
		{
			usersMap = new HashMap<String, Session>();
			usersByBrMap.put(branchCode, usersMap);
		}

		usersMap = usersByBrMap.get(branchCode);
		
		// there is no need to check if user exist, as if it does exist it will be overridden with the new session
		usersMap.put(userName, userSession);

		// if active mq session is null, connect as a listner in the active mq ( case of first user logged in after application started)
		if (amqSession == null) 
		{
			registerEndPointListener();
		}
	}

	/**
	 * Callback hook for Connection close events.
	 * 
	 * This method will be invoked when a client closes a WebSocket connection.
	 * 
	 * @param userSession
	 *            the userSession which is opened.
	 */
	@OnClose
	public void onClose(Session userSession) 
	{
		
		// retrieve the http session saved when intercepting handshake (PathWSHttpSessionConfigurator)
		// use the company, branch and user name in order to empty the user from the hashmap on close event
		HttpSession httpSession = (HttpSession) userSession.getUserProperties().get(HttpSession.class.getName());

		SessionCO sessCO = (SessionCO) httpSession.getAttribute(ConstantsCommon.SESSION_VO_ATTR);
		String compCode = sessCO.getCompanyCode().toString();
		String branchCode = sessCO.getBranchCode().toString();
		String userName = sessCO.getUserName();

		log.debug("NotificationsEndPoint onClose User Id:" + sessCO.getUserName());
		log.debug("NotificationsEndPoint onClose Machine Id:" + sessCO.getMachineIp());

		Map<String, Map<String, Session>> usersByBrMap;
		Map<String, Session> usersMap;

		// if there is other users in the branch, keep the branch key, else remove it from the hashmap
		// if there is other branches in the company, keep the company key, else remove it from the hashmap
		if (usersByCompBrMap.get(compCode) != null) 
		{
			usersByBrMap = usersByCompBrMap.get(compCode);
			if (usersByBrMap.get(branchCode) != null) 
			{
				usersMap = usersByBrMap.get(branchCode);
				usersMap.remove(userName);

				if (usersMap.isEmpty()) 
				{
					usersByBrMap.remove(branchCode);
					if (usersByBrMap.isEmpty()) 
					{
						usersByCompBrMap.remove(compCode);
					}
				}
			}
		}
		log.debug("NotificationsEndPoint onClose Connection closed. WebSocket Session Id: " + userSession.getId());

	}

	/**
	 * Callback hook for Message Events.
	 * 
	 * This method will be invoked when a client send a message.
	 * 
	 * @param message
	 *            The text message
	 * @param userSession
	 *            The session of the client
	 */
	@OnMessage
	public void onMessage(String message, Session userSession) 
	{
		// used if the websocket client needs to communicate with the web socket endpoint, in our case it is not needed
		log.debug("NotificationsEndPoint onMessage "+message);
	}

	/**
	 * this method receive list of websocket sessions, and send them a specific message
	 * 
	 * @param userSessions
	 * @param message
	 */
	public void sendMessage(List<Session> userSessions,Map<String,String> translatedMessagesMap, String message) 
	{
		String finalMessage = null;
		// iterate through the user sessions that needs to receive the message. 
		for (Session session : userSessions) 
		{
			synchronized (session) 
			{
				if (session.isOpen()) 
				{
					try 
					{
							if(translatedMessagesMap != null) 
							{
								HttpSession httpSession = (HttpSession) session.getUserProperties().get(HttpSession.class.getName());
								SessionCO sessCO = (SessionCO) httpSession.getAttribute(ConstantsCommon.SESSION_VO_ATTR);
								String language = sessCO.getLanguage().toString();
								finalMessage = translatedMessagesMap.get(language);
							} 
							else 
							{
								finalMessage = message;
							}
							session.getBasicRemote().sendText(finalMessage);
					} 
					catch (IOException e) 
					{
						log.error(e, "Exception while sendMessage");
					}
				}
			}
		}
	}

	@OnError
	public void onError(Session session, Throwable thr) 
	{
		log.error(thr.getLocalizedMessage());
	}

	/**
	 * register the websocket end point as a listner in the active mq
	 */
	private void registerEndPointListener() 
	{
		// used to create a connection and a session between endpoint and active mq
		initialiseActiveMQSession();
		
		// listen to the app name topic
		// register NotificationsWebSocketMessageListener as a message listener
		MessageConsumer consumer;
		try 
		{
			consumer = amqSession.createConsumer(amqSession.createTopic(ConstantsCommon.returnCurrentAppName()));
			consumer.setMessageListener(new NotificationsWebSocketMessageListener());
		} 
		catch (JMSException e) 
		{
			log.error(e, "Exception while registerEndPointListener");
		}
	}

	private void initialiseActiveMQSession() 
	{
		try 
		{
			NotificationsEngineBO notificationsEngineBO = NotificationsCommonMethods.returnNotificationServiceBean();

			// connect to notification active mq, and set  NotificationsWebSocketExceptionListener as exception listener 
			// when the connection fails in order to reconnect
			String brokerURI = notificationsEngineBO.returnActiveBrokerURL();
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
			connectionFactory.setBrokerURL(brokerURI);
			amqConnection = connectionFactory.createConnection();
			amqConnection.setExceptionListener(new NotificationsWebSocketExceptionListener());
			amqConnection.start();
			amqSession = amqConnection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
		} 
		catch (Exception e) 
		{
			amqSession = null;
			log.error(e, "Exception while initialiseActiveMQSession");
		}
	}

	private class NotificationsWebSocketMessageListener implements MessageListener 
	{

		@Override
		public void onMessage(Message message) 
		{

			try 
			{
				if (message instanceof TextMessage) 
				{
					TextMessage textMessage = (TextMessage) message;
					String notificationMapStr = textMessage.getText();
					log.debug("NotificationsEndPoint onMessage on message received: " + notificationMapStr);
					Map<String, Session> notifyUsersMap = new HashMap<String, Session>();
					List<String> companiesList = null;
					List<String> notifBranchesList = null;
					List<Session> usersSessionsList = new ArrayList<Session>();
					Set<String> userSet = null;
					String notificationMessage = "";
					Map<String,String> transNotificationsMessagesMap = new HashMap<String,String>();
					// the notification message received is a hashmap containing a list of:
					// companies, branches, users and the message to be sent
					Object jsonObject = JSONUtil.deserialize(notificationMapStr);
					if (jsonObject instanceof Map) 
					{
						Map<String, Object> notificationMap = (HashMap<String, Object>) jsonObject;
						
						// if the company key does not exist, it means that it should be sent to all users companies registered on the end point
						// for that we retrieve all company keys from the main hashmap
						// else retrieve the key and convert the str to a list
						if (notificationMap.get("COMP_CODE") != null) 
						{
							companiesList = Arrays
									.asList(((String) notificationMap.get("COMP_CODE")).trim().replaceAll(" ", "").split(","));
						} 
						else 
						{
							companiesList = new ArrayList<String>(usersByCompBrMap.keySet());
						}

						// if the branches key does not exist, it means that it should be sent to all branches under each company registered on the end point
						// else retrieve the key and convert the str to a list
						if (notificationMap.get("BRANCH_CODE") != null) 
						{
							notifBranchesList = Arrays
									.asList(((String) notificationMap.get("BRANCH_CODE")).trim().replaceAll(" ", "").split(","));
						}
						
						// if the user key does not exist, it means that it should be sent to all users registered on the end point by company/branch(if sent)
						// else retrieve the key and convert the str to a list
						if (notificationMap.get("USER_ID") != null) 
						{
							userSet = new HashSet<String>(Arrays
									.asList(((String) notificationMap.get("USER_ID")).trim().replaceAll(" ", "").split(",")));
						}
						
						// this loop is to filter the websocket sessions that needs to recieve the message
						// we start by iterating over the companies, if the company code exists in the hashmap we iterate over its branches
						// if notifBranchesList is null, it means that the branch_code key was not sent, and we need to send to all branches under each company
						// then we loop over each needed branch and we retain the users sent by the producer of the message
						for (String compCode : companiesList) 
						{
							if (usersByCompBrMap.containsKey(compCode)) 
							{
								List<String> branchesList;
								// if value is send it will not enter this
								// condition
								if (notifBranchesList == null) 
								{
									branchesList = new ArrayList<String>(usersByCompBrMap.get(compCode).keySet());
								} 
								else 
								{
									branchesList = notifBranchesList;
								}

								for (String branchCode : branchesList) 
								{
									if (usersByCompBrMap.get(compCode).containsKey(branchCode)) 
									{
										// we clone the users map in order to retrieve a new reference of the map
										notifyUsersMap = (Map<String, Session>) ((HashMap<String, Session>) usersByCompBrMap
												.get(compCode).get(branchCode)).clone();
										if(userSet != null) 
										{
											notifyUsersMap.keySet().retainAll(userSet);
										}
										List<Session> sessionsList = new ArrayList<Session>(notifyUsersMap.values());
										usersSessionsList.addAll(sessionsList);
									}
								}
							}
						}
						
						if (notificationMap.get("MESSAGE_CODE") != null) 
						{
							Integer ctsCode = Integer.valueOf((String) notificationMap.get("MESSAGE_CODE"));
							String[] params = null;

							if (notificationMap.get("MESSAGE_PARAMS") != null) 
							{
								Object[] objectParams = (Object[]) ((ArrayList) notificationMap.get("MESSAGE_PARAMS")).toArray();
								params = Arrays.copyOf(objectParams, objectParams.length, String[].class);
							}

							for (String userLang : userLanguages) 
							{
								try 
								{
									notificationMessage = commonLibBO.returnTranslMessageOnly(ctsCode, params, userLang);
									transNotificationsMessagesMap.put(userLang, notificationMessage);
								} 
								catch (BaseException e) 
								{
									log.error(e, "BaseException while returnTranslMessageOnly");
								}
							}
						}
						
						if (notificationMap.get("MESSAGE") != null) 
						{
							notificationMessage = (String) notificationMap.get("MESSAGE");
						}
					}
					
					// send the message to the selected sessions
					sendMessage(usersSessionsList, transNotificationsMessagesMap, notificationMessage);
				}
			} 
			catch (Exception e) 
			{
				log.error(e, "NotificationsEndPoint NotificationsWebSocketMessageListener.onMessage Error");
			}
		}
	}

	private class NotificationsWebSocketExceptionListener implements ExceptionListener 
	{

		@Override
		public void onException(JMSException e) 
		{
			// 
			log.error(e, "NotificationsWebSocketExceptionListener onException  JMSException");
			
			if(amqSession != null)
			{
				try 
				{
					amqSession.close();
				} 
				catch (JMSException e1) 
				{
				}
			}
			if(amqConnection != null)
			{
				try 
				{
					amqConnection.close();
				} 
				catch (JMSException e1) 
				{
				}
			}
			
			amqSession = null;
			amqConnection = null;
			
			// reconnect to an active broker url
			registerEndPointListener();
		}

	}

	
	public void setCommonLibBO(CommonLibBO commonLibBO)
	{
		this.commonLibBO = commonLibBO;
	}
	
}
