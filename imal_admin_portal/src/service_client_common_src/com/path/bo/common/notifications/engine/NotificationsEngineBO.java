/**
 * 
 */
package com.path.bo.common.notifications.engine;

import java.util.Map;

import com.path.lib.common.exception.BaseException;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: adelnasrallah
 * 
 *          NotificationsEngineBO.java used to
 */
public interface NotificationsEngineBO
{
    /**
     * Send an alert message
     * @param destination
     * @param isTopic
     * @throws BaseException
     */
    public void sendNotificationMessage(Map<String,Object> notificationMap) throws BaseException;

    /**
     * This function will start the alert broker
     * @return the new broker url of the active broker
     */
    public String startNotificationsBroker() throws BaseException;
    
    /**
     * this function will check if a broker is running and return the active URL.
     * If no active broker is alive then return null
     * @return
     * @throws BaseException
     */
    public String returnActiveBrokerURL()throws BaseException;
    
}
