/**
 * 
 */
package com.path.actions.common.dashboard.applications;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.bo.common.dashboardportal.DashboardPortalBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dashboard.ApplicationCO;
import com.path.vo.common.dashboardportal.DashboardPortalSC;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * applicationMainAction.java used to
 */
public class ApplicationsMainAction extends BaseAction
{
    private DashboardPortalBO dashboardPortalBO;
    DashboardPortalSC criteria = new DashboardPortalSC();
    ApplicationCO     appsCO   = new ApplicationCO();
    public List<ApplicationCO>                 appLst = new ArrayList<ApplicationCO>();
    public Map<BigDecimal,List<ApplicationCO>> appMap = new HashMap<BigDecimal,List<ApplicationCO>>();
    
    public Object getModel()
    {
 	return criteria;
    }    
    /**
     * 
     * @author marwanmaddah
     * @date   Jan 8, 2014
     * @return String
     *
     */
    public String loadApplicationWidget()
    {
        try
        {
 	     prepareAppData();
        }
        catch(Exception ex)
        {
 	   handleException(ex, null, null);
 	   return ERROR_ACTION;
        }
        return SUCCESS;
    }
    /**
     * Used to arrange the application data in a hashmap and return it to the JSP
     * @author marwanmaddah
     * @date   Dec 26, 2013
     * @throws BaseException
     *
     */
    private void prepareAppData() throws BaseException
    {
	try
	{
	    SessionCO session = returnSessionObject();
	    BigDecimal groupCode = null, prevGroupCode = null;

	    criteria.setUSER_ID(session.getUserName());
	    criteria.setCompCode(session.getCompanyCode());
	    criteria.setBranchCode(session.getBranchCode());
	    criteria.setLanguageCode(session.getLanguage());
	    appLst = dashboardPortalBO.returnAppList(criteria);
	    List<ApplicationCO> screenList = new ArrayList<ApplicationCO>();
	    int lstSize = appLst.size();
	    String currGrpCode = null, prevGrpCode = "";
	    for(int i = 0; i < lstSize; i++)
	    {
		ApplicationCO appCO = appLst.get(i);
		String appName = appCO.getAppVO().getAPP_NAME();
		appCO.setAppUrl(PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties","app." + appName + ".url"));

		currGrpCode = StringUtil.nullToEmpty(appCO.getGroupCode());
		groupCode = appCO.getGroupCode();

		if(!currGrpCode.equals(prevGrpCode) && !screenList.isEmpty())
		{
		    appMap.put(prevGroupCode, screenList);
		    screenList = new ArrayList<ApplicationCO>();
		}


		screenList.add(appCO);

		prevGrpCode = currGrpCode;
		prevGroupCode = groupCode;

	    }
	    if(!screenList.isEmpty())
	    {
		appMap.put(prevGroupCode, screenList);
	    }  
	}
	catch(Exception ex)
	{
	    throw new BaseException(ex);
	}
     }    
    /**
     * Used to get the needed information from database and fill them on the information screen 
     * @author marwanmaddah
     * @date   Jan 8, 2014
     * @return String
     *
     */
    public String loadApplicationInfos()
    {
	try
	{
	    SessionCO session  = returnSessionObject();
	    criteria.setCompCode(session.getCompanyCode());
	    criteria.setBranchCode(session.getBranchCode());
	    criteria.setUserId(session.getUserName());
	    criteria.setLanguageCode(session.getLanguage());
	    appsCO = dashboardPortalBO.returnAppInfos(criteria);
	    String sessionDateFormat = DateUtil.returnDateMask(session.getUserNbFormats());
	    if(sessionDateFormat.indexOf(' ') == -1)
	    {
		sessionDateFormat = sessionDateFormat.concat(" ").concat("HH:mm:ss");
	    }
	    if(appsCO.getLoginDate() != null)
	    {
		appsCO.setLastLogin(DateUtil.format(appsCO.getLoginDate(),sessionDateFormat));
	    }
	    if(appsCO.getLogoutDate() != null)
	    {
		appsCO.setLastLogout(DateUtil.format(appsCO.getLogoutDate(),sessionDateFormat));
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
     * @param dashboardPortalBO the dashboardPortalBO to set
     */
    public void setDashboardPortalBO(DashboardPortalBO dashboardPortalBO)
    {
        this.dashboardPortalBO = dashboardPortalBO;
    }
    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(DashboardPortalSC criteria)
    {
        this.criteria = criteria;
    }
    /**
     * @param appsCO the appsCO to set
     */
    public void setAppsCO(ApplicationCO appsCO)
    {
        this.appsCO = appsCO;
    }
    /**
     * @return the appLst
     */
    public List<ApplicationCO> getAppLst()
    {
        return appLst;
    }
    /**
     * @param appLst the appLst to set
     */
    public void setAppLst(List<ApplicationCO> appLst)
    {
        this.appLst = appLst;
    }
    /**
     * @return the appMap
     */
    public Map<BigDecimal, List<ApplicationCO>> getAppMap()
    {
        return appMap;
    }
    /**
     * @param appMap the appMap to set
     */
    public void setAppMap(Map<BigDecimal, List<ApplicationCO>> appMap)
    {
        this.appMap = appMap;
    }
    /**
     * @return the criteria
     */
    public DashboardPortalSC getCriteria()
    {
        return criteria;
    }
    /**
     * @return the appsCO
     */
    public ApplicationCO getAppsCO()
    {
        return appsCO;
    }
}
