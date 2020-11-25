package com.path.bo.common.notifications;

import com.path.bo.common.notifications.engine.NotificationsEngineBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.remote.RmiServiceCaller;
/**
 * 
 * @author DeniskHaddad on behalf Adel Nasrallah
 * Notifications Common Methods TP 715899
 */
public class NotificationsCommonMethods {
	
    //notification
	public static final String notificationsServiceName = "notificationsEngineBOService";
	public static final String notificationsServiceUrl = "notification.serviceURL";
	public static NotificationsEngineBO returnNotificationServiceBean() throws BaseException 
	{
		NotificationsEngineBO notificationServiceWrapperBO;
		try 
		{
			String notificationServiceUrl = PathPropertyUtil.returnPathPropertyFromFile("PathNotificationsRemoting.properties",
					notificationsServiceUrl) == null
							? PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties",
									notificationsServiceUrl)
							: PathPropertyUtil.returnPathPropertyFromFile("PathNotificationsRemoting.properties",
									notificationsServiceUrl);

			if (notificationServiceUrl == null) 
			{
				throw new BOException("Invalid notification URL");
			}
			notificationServiceWrapperBO = (NotificationsEngineBO) RmiServiceCaller.returnRmiInterface(
					notificationServiceUrl.concat(notificationsServiceName), NotificationsEngineBO.class);
		} 
		catch (Exception e) 
		{
			throw new BaseException(e);
		}
		return notificationServiceWrapperBO;
	}

}
