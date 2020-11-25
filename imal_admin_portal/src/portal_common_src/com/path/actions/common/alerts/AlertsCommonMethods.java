package com.path.actions.common.alerts;

import com.path.lib.log.Log;
import com.path.vo.common.SessionCO;


public final class AlertsCommonMethods
{
    private static final Log log = Log.getInstance();
    /**
     * Private constructor only to prevent instantiation in the class
     */
    private AlertsCommonMethods()
    {
	log.error("This Class Should not be Instantiated");
    }
    
    /**
     * This method will create a new thread instance of RemoveAlertClientThread and will start it
     */
    public static void removeAlertClient(String currentAppName, String usrCompBrKey, String userName, String httpSessionId)
    {
	//create a new thread instance of RemoveAlertClientThread
	RemoveAlertClientThread removeAlertClientThread = new RemoveAlertClientThread(currentAppName, usrCompBrKey, userName, httpSessionId); 
	//start the thread
	removeAlertClientThread.start();
    }
    
    /**
     * method that will return the userid-comp-br key
     * @param sessCo
     * @return
     */
    public static String returnUsrCompBrKey(SessionCO sessCo)
    {
	StringBuilder usrCompBrKeyBuilder = new StringBuilder();
	usrCompBrKeyBuilder.append(sessCo.getUserName());
	usrCompBrKeyBuilder.append("-");
	usrCompBrKeyBuilder.append(sessCo.getCompanyCode());
	usrCompBrKeyBuilder.append("-");
	usrCompBrKeyBuilder.append(sessCo.getBranchCode());
	return usrCompBrKeyBuilder.toString();
    }
   
}
