package com.path.actions.common.dashboard.alerts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.path.bo.common.dashboardportal.DashboardPortalBO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dashboard.DashPortalAlertCO;
import com.path.vo.common.dashboardportal.DashboardPortalSC;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashPortalAlertsMainAction.java used to
 */
public class DashPortalAlertsMainAction extends BaseAction
{
    DashboardPortalBO  dashboardPortalBO;
    DashboardPortalSC criteria = new DashboardPortalSC();
    DashPortalAlertCO alertCO  = new DashPortalAlertCO();
    public List<DashPortalAlertCO> alertLst = new ArrayList<DashPortalAlertCO>();
    public Integer alertRefreshTime = null;  
	    
    public Object getModel()
    {
 	return criteria;
    }    
    /**
     * Used to get the needed data for alerts widget and forward them to JSP
     * @author marwanmaddah
     * @date   Jan 8, 2014
     * @return String
     *
     */
    public String loadAlertsWidget()
    {
        try
        {
            SessionCO session  = returnSessionObject();
            criteria.setUserId(session.getUserName());
            criteria.setCompCode(session.getCompanyCode());
            criteria.setBranchCode(session.getBranchCode());
            criteria.setLanguageCode(session.getLanguage());
            criteria.setRunningDate(returnCommonLibBO().returnSystemDateWithTime()); 	
	    Properties prop      = PropertiesLoaderUtils.loadAllProperties("PathRemoting.properties");
	    String compBranchApp = prop.getProperty("alert.listener.compBranch");
	    if(!StringUtil.nullToEmpty(compBranchApp).isEmpty())
	    {
		criteria.setAlertAppsList(compBranchApp.split(","));
	    }
            alertLst = dashboardPortalBO.returnAlertsList(criteria);
            
            //initialize the refresh time of the alert widget 
            Map<String, Integer> returnedMap = dashboardPortalBO.returnUserRefreshTime(session.getUserName(), "60");
            alertRefreshTime = returnedMap.get("todoRefreshTimeNumber");
    	    if(alertRefreshTime == null)
    	    {
    		alertRefreshTime = returnedMap.get("pthRefreshTimeNumber");
    	    }
        }
        catch(Exception ex)
        {
 	   handleException(ex, null, null);
 	   return ERROR_ACTION;
        }
        return SUCCESS;
    }

    /**
     * @return the criteria
     */
    public DashboardPortalSC getCriteria()
    {
        return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(DashboardPortalSC criteria)
    {
        this.criteria = criteria;
    }
    /**
     * @param dashboardPortalBO the dashboardPortalBO to set
     */
    public void setDashboardPortalBO(DashboardPortalBO dashboardPortalBO)
    {
        this.dashboardPortalBO = dashboardPortalBO;
    }
}
