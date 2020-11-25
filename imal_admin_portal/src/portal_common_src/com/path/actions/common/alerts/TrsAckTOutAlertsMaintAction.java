package com.path.actions.common.alerts;

import java.util.Calendar;
import java.util.Date;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsBrokerBO;
import com.path.bo.common.alerts.AlertsEngineBO;
import com.path.dbmaps.vo.FMSCTRLVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.AlertCO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.alerts.AlertsSC;
import com.path.vo.core.ctsteller.CTSTELLERSC;

@SuppressWarnings("serial")
public class TrsAckTOutAlertsMaintAction extends BaseAction
{
    private AlertsBO alertsBO;
    private CTSTELLERSC ctsTellerSC = new CTSTELLERSC();
    private AlertsSC alertsSC = new AlertsSC();
    private AlertCO alertCO = new AlertCO();
    private String refreshTime;
    private String refreshTimeVal;
    private String refreshTimeForm;
    /* Login Alert Implementation TP#297149 */
    private String isLoginAlertEnabled;
    
    
    /**
	 * Loads the TrsAckTOutAlerts details page
	 * 
	 * @return
	 */
	@Override
	public Object getModel()
	{
	   return  alertsSC;
	}
	public String loadTrsAckTOutAlertsMaint()
	{		 
	    
	   
	      try
		{
		  SessionCO sessionCO = returnSessionObject();
		  alertsSC.setUserId(sessionCO.getUserName());
		  String defaultRefreshTime= StringUtil.nullToEmpty(alertsBO.returnDefaultRefreshTime(alertsSC));
		  if(defaultRefreshTime.isEmpty())
		  {
		      alertCO.setTODO_REFRESH_TIME("00:00:00");
		  }
		  else
		  {
        		Long defaultRefreshTimeSeconds = Long.valueOf(defaultRefreshTime);
        		String hours = completeWithDigits((defaultRefreshTimeSeconds / 3600L));
        		String minutes = completeWithDigits((defaultRefreshTimeSeconds % 3600L) / 60L);
        		String seconds = completeWithDigits(defaultRefreshTimeSeconds % 60L);
        		alertCO.setTODO_REFRESH_TIME(hours + ":" + minutes + ":" + seconds);
		  }
		  
		  if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
		  {
			  // TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
			  if(sessionCO.isFinalSignOff())
			  {
				  setIsLoginAlertEnabled("true");
			  }
		      alertCO.setSnoozeAlertDisabled(Boolean.FALSE.toString());
		  }
		  else if(ConstantsCommon.FMS_APP_NAME.equals(sessionCO.getCurrentAppName()))
	          {
	            FMSCTRLVO fmsctrlVO = new FMSCTRLVO();
	            fmsctrlVO.setCOMP_CODE(sessionCO.getCompanyCode());
	            fmsctrlVO.setBRANCH_CODE(sessionCO.getBranchCode());
	            fmsctrlVO = returnCommonLibBO().returnFMSControlDetails(fmsctrlVO);

	            if(fmsctrlVO != null)
	            {
	                if("Y".equals(fmsctrlVO.getALERT_DISABLE_SNOOZE()))
	                {
	                  alertCO.setSnoozeAlertDisabled(Boolean.TRUE.toString());
	                }
	                else
	                {
	                  alertCO.setSnoozeAlertDisabled(Boolean.FALSE.toString());
	                }
	            }
	          }


		}
		catch(Exception e)
		{
			log.error(e, "Error in Alert Grid");
			handleException(e, null, null);
			return ERROR_ACTION;
		}
		return "loadTrsAckTOutMaint";
		
	}
	
    /**
     * This function will complete hours, minutes and seconds to follow the
     * format hh:mm:ss
     * 
     * @param number
     * @return
     */
    private String completeWithDigits(Long number)
    {
	if(number == null)
	{
	    return "00";
	}
	else
	{
	    StringBuffer returnedString = new StringBuffer(String.valueOf(number));
	    if(returnedString.length() == 1)
	    {
		returnedString = new StringBuffer("0").append(returnedString);
	    }
	    return returnedString.toString();
	}

    }
	
	    /**
	     * Loads the OkForAll details page
	     * 
	     * @return
	     */
	    
	    
	    public String okForAll()
	    {
		try
		{
		    GridUpdates gu = getGridUpdates(alertCO.getGridSelectedRow(), S_TODO_DETVO.class);
		    alertCO.setListAlertsAdd(gu.getLstAdd());
		    alertsBO.okForAll(alertCO);
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
		return "success";
	    }
	    
    public String snoozeAll()
    {
	try
	{
	    if(refreshTime != null && !refreshTime.isEmpty() && NumberUtil.isNumber(refreshTime))
	    {
		String pthCtrRefreshTimeStr = returnCommonLibBO().returnPthCtrl().getTODO_REFRESH_TIME();
		if(pthCtrRefreshTimeStr == null || pthCtrRefreshTimeStr.isEmpty())
		{
		    pthCtrRefreshTimeStr = AlertsBrokerBO.SCHEDULE_DEFAULT_PERIODICITY_STRING;
		}
		
		String hours = pthCtrRefreshTimeStr.substring(0, 2);
		String minutes = pthCtrRefreshTimeStr.substring(2, 4);
		String seconds = pthCtrRefreshTimeStr.substring(4, 6);
		int pthCtrRefreshTime = (Integer.parseInt(hours) * 3600) + (Integer.parseInt(minutes) * 60)
			+ (Integer.parseInt(seconds));
		int refreshTimeFromForm = Integer.parseInt(refreshTime);
		
		if(pthCtrRefreshTime == 0)
		{
		    pthCtrRefreshTime = AlertsBrokerBO.SCHEDULE_DEFAULT_PERIODICITY.intValue();
		    hours = completeWithDigits((Long.valueOf(pthCtrRefreshTime) / 3600));
		    minutes = completeWithDigits((Long.valueOf(pthCtrRefreshTime) % 3600) / 60);
		    seconds = completeWithDigits(Long.valueOf(pthCtrRefreshTime) % 60);
    		}
		
		if(pthCtrRefreshTime <= refreshTimeFromForm)
		{
		    SessionCO sessionCO = returnSessionObject();
		    // Update USR_PUSH_ALERT
		    alertsSC.setUserId(sessionCO.getUserName());
		    alertsSC.setTodoRefreshTime(refreshTime);
		    alertsSC.setUserAction(AlertsEngineBO.FROM_USR_SNOOZE);
		    alertsBO.updateUsrPushAlert(alertsSC);
		    
		    //insert or update the USR_SNOOZE_ALERT
		    alertsSC.setAppName(sessionCO.getCurrentAppName());
		    alertsBO.insertOrUpdateUsrSnoozeAlert(alertsSC);
		}
		else
		{
		    throw new BOException(MessageCodes.SNOOZE_TIME_LESS_THEN_PTH_REF_TIME,new String[]{hours+":"+minutes+":"+seconds});
		}
	    }
	    else
	    {
		throw new BOException(MessageCodes.INVALID_TIME);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "success";
    }
	    /**
	     * Call the function SnoozeSelectedTransactional that update the S_TODO_DET NO_ACTION_TIME
	     * 
	     * @return
	     */
	    
	    
	    public String snoozeSelectedTransactional()
	    {
		try
		{
		    Date sysdate=returnCommonLibBO().returnSystemDateWithTime();
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(sysdate);
		    calendar.add(Calendar.HOUR, Integer.parseInt(refreshTimeForm.split(":")[0]));
		    calendar.add(Calendar.MINUTE, Integer.parseInt(refreshTimeForm.split(":")[1]));
		    calendar.add(Calendar.SECOND, Integer.parseInt(refreshTimeForm.split(":")[2]));
		    Date noActionDate=calendar.getTime();    
		    GridUpdates gu = getGridUpdates(alertCO.getGridSelectedRow(), S_TODO_DETVO.class);
		    alertCO.getsTodoDet().setNO_ACTION_TIME(noActionDate);
		    alertCO.setListAlertsAdd(gu.getLstAdd());
		    alertsBO.snoozeSelectedTransactional(alertCO);
		    
		    
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
		return "success";
	    }
	    
	    public String getRefreshTime()
	    {
	        return refreshTime;
	    }
	    public void setRefreshTime(String refreshTime)
	    {
	        this.refreshTime = refreshTime;
	    }
	    public String getRefreshTimeVal()
	    {
	        return refreshTimeVal;
	    }
	   
	    public String getRefreshTimeForm()
	    {
	        return refreshTimeForm;
	    }
	    public void setRefreshTimeForm(String refreshTimeForm)
	    {
	        this.refreshTimeForm = refreshTimeForm;
	    }
	    public void setRefreshTimeVal(String refreshTimeVal)
	    {
	        this.refreshTimeVal = refreshTimeVal;
	    }
	    public AlertCO getAlertCO()
	    {
	        return alertCO;
	    }
	    public void setAlertCO(AlertCO alertCO)
	    {
	        this.alertCO = alertCO;
	    }
	    public CTSTELLERSC getCtsTellerSC()
	    {
	        return ctsTellerSC;
	    }
	    public void setAlertsBO(AlertsBO alertsBO)
	    {
	        this.alertsBO = alertsBO;
	    }
	    public void setCtsTellerSC(CTSTELLERSC ctsTellerSC)
	    {
	        this.ctsTellerSC = ctsTellerSC;
	    }
	    public void setAlertsSC(AlertsSC alertsSC)
	    {
	        this.alertsSC = alertsSC;
	    }
	    public AlertsSC getAlertsSC()
	    {
	        return alertsSC;
	    }
	    public String getIsLoginAlertEnabled()
	    {
	        return isLoginAlertEnabled;
	    }
	    public void setIsLoginAlertEnabled(String isLoginAlertEnabled)
	    {
	        this.isLoginAlertEnabled = isLoginAlertEnabled;
	    }
    
    
}
