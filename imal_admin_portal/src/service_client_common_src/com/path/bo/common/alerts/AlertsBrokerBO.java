/**
 * 
 */
package com.path.bo.common.alerts;

import com.path.lib.common.exception.BaseException;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          PathJmsBrokerBO.java used to
 */
public interface AlertsBrokerBO
{
    //If the PTH_CTRL.TODO_REFRESH_TIME is NULL the default periodicity (time in seconds) will be applied to the scheduled task
    public static final  Long SCHEDULE_DEFAULT_PERIODICITY = 30L;
    //if the PTH_CTRL.TODO_REFRESH_TIME is NULL the default periodicity (time in seconds) in string;
    public static final  String SCHEDULE_DEFAULT_PERIODICITY_STRING  = "000030";
    //The parameters to be added to the broker url to enhance the performance  
    public static final String BROKER_URL_PARAMETERS = "wireFormat.maxInactivityDuration=0&jms.watchTopicAdvisories=false&jms.optimizeAcknowledge=true&jms.useAsyncSend=false&jms.alwaysSyncSend=true&jms.dispatchAsync=false&jms.alwaysSessionAsync=false&jms.copyMessageOnSend=false";
   
    public void startBroker() throws Exception;
    public void stopBroker() throws Exception;
    public boolean isAlertsBrokerStarted();
    public void restartScheduledTask() throws BaseException;
    public boolean checkIfClusterEnabled();
    public void startBroker(Boolean forceStart) throws Exception;
    public String returnActiveBrokerURL()throws BaseException;
    //FIBS200046 reduce usage of global shared variable across clusters
    public Object[] checkIfBrokerAlreadyRunning(boolean brokerStartedFlag, boolean checkOnly, boolean forceStart)throws BaseException;

}
