/**
 * 
 */
package com.path.bo.common.alerts;

import java.util.Map;
import com.path.lib.common.exception.BaseException;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          AlertsEngineBO.java used to
 */
public interface AlertsEngineBO
{
    //The action types used on update of USR_PUSH_ALERTS table
    public static final String FROM_USR_LOGIN = "FROM_USR_LOGIN";
    public static final String FROM_ALERT_LOGIN = "FROM_ALERT_ENGINE";
    public static final String FROM_USR_SNOOZE = "FROM_USR_SNOOZE";
    //The destination prefix added before the userId to name the destination inside the broker
    public static final String DESTINATION_PREFIX = "PATH_DESTINATION_";
    //the property representing the alert type (timeout/alert) setted in the JMSMessage
    public static final String IS_ALERT_PROPERTY_KEY = "isAlertMessage";
    //the property representing the destination name setted in the JMSMessage
    public static final String DESTINATION_PROPERTY_KEY = "destination";
    
    /**
     * Send a timeout message
     * @param sessionId
     * @param destination
     * @param isTopic
     * @throws BaseException
     */
    public void sendTimeoutMessage(final String sessionId, String destination) throws BaseException;

    /**
     * Send an alert message
     * @param destination
     * @param isTopic
     * @throws BaseException
     */
    public void sendAlertMessage(String destination, String applicationName) throws BaseException;

    /**
     * The function used as a scheduled task and repeated by the alerts engine
     * @throws BaseException
     */
    public void alertsEngineScheduledTask() throws BaseException, Exception;

    /**
     * Get if the alerts engine is started
     * @return
     */
    public boolean isAlertsEnabled(String appName) throws BaseException;

    /**
     * Update the default refresh time in USR_PUSH_ALERT 
     * @param userId
     * @param curAppName
     * @throws BaseException
     */
    public void updateUserDefaultRefreshTime(String userId,String curAppName) throws BaseException;
    
    /**
     * This function will restart the scheduled task, after changing the TODO_REFRESH_TIME in PTH_CTRL
     * This function is called on clearCach
     * @throws BaseException
     */
    public void restartScheduledTask(String appName) throws BaseException;
   
    /**
     * This function will return true/false if the alert is enabled by comp/branch
     * @return
     */
    public boolean returnAlertByCompBranch(String appName);
 
    /**
     * This function will start the alert broker
     * @return the new broker url of the active broker
     */
    public String startAlertsBroker() throws BaseException;
    
    /**
     * this function will check if a broker is running and return the active URL.
     * If no active broker is alive then return null
     * @return
     * @throws BaseException
     */
    public String returnActiveBrokerURL()throws BaseException;
    
    /**
     * function used to return the todo_refresh_time from USR and from PTH_CTRL
     * @param userId
     * @param defaultPthRefreshTime
     * @return map that contains 2 keys todoRefreshTimeNumber and pthRefreshTimeNumber 
     * @throws BaseException
     */
    public Map<String, Integer> returnUserRefreshTime(String userId, String defaultPthRefreshTime)  throws BaseException;
}
