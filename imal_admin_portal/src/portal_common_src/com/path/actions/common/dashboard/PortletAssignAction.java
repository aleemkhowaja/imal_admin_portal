package com.path.actions.common.dashboard;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.dashboardportal.DashboardPortalBO;
import com.path.dbmaps.vo.SYS_PARAM_PORTLET_TYPEVO;
import com.path.dbmaps.vo.SYS_PARAM_USR_ALLOWED_PORTLETSVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.dashboardportal.DashboardPortalSC;

public class PortletAssignAction extends GridBaseAction
{
    private DashboardPortalBO dashboardPortalBO;
    DashboardPortalSC dashBoardSC = new DashboardPortalSC();
    private String updates;

    @Override
    public Object getModel()
    {
	return dashBoardSC;
    }

    public String loadAssignDialog()
    {
	return "loadAssignDialog";
    }
    
    public String returnPortletInfo()
    {
	SYS_PARAM_PORTLET_TYPEVO portletInfo = new SYS_PARAM_PORTLET_TYPEVO();
	
	portletInfo.setPORTLET_CODE(dashBoardSC.getPortletCode());
	try
	{
	    portletInfo = dashboardPortalBO.returnPortletInfo(portletInfo);
	    dashBoardSC.setTITLE_KEY(getText(portletInfo.getTITLE_KEY()));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

     public String userDependency()
    {
	return SUCCESS;
    }

    public String saveAssignedPortlets()
    {
	try
	{
	    if(!StringUtil.nullToEmpty(updates).isEmpty())
	    {		
		GridUpdates gu = getGridUpdates(updates, USRVO.class);
		dashBoardSC.setUserPortletsDel(gu.getLstDelete());
		dashBoardSC.setUserPortletsAdd(gu.getLstAdd());
		dashBoardSC.setCompCode(returnSessionObject().getCompanyCode());
		dashBoardSC.setPreferredLanguage(returnSessionObject().getLanguage());
		dashboardPortalBO.updUserAssignedPortlet(dashBoardSC);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String loadusrAllwdPortletsGrid()
    {
	try
	{
	    dashBoardSC.setSearchCols(new String[]{"USER_ID","PORTLET_CODE", "TITLE_KEY", "ABV_DESC_KEY"});
	    copyproperties(dashBoardSC);
	    
	    List<DashboardPortalSC> lst;
	    
	    if("D".equals(dashBoardSC.getPortletCode()))
	    {
		if(checkNbRec(dashBoardSC))
		{
		    setRecords(dashboardPortalBO.returnUserDashWidgetsListCount(dashBoardSC));
		}
		lst = dashboardPortalBO.returnUserDashWidgetsList(dashBoardSC);
	    }
	    else
	    {
		if(checkNbRec(dashBoardSC))
		{
		    setRecords(dashboardPortalBO.returnUsrAllwdPrtltsListCount(dashBoardSC));
		}
		lst = dashboardPortalBO.returnUsrAllwdPrtltsList(dashBoardSC);
	    }
	    for(int i=0; i<lst.size(); i++)
	    {
		lst.get(i).setTITLE_KEY(getText(lst.get(i).getTITLE_KEY()));
		String pCode = lst.get(i).getPORTLET_CODE();
		if(pCode.startsWith("_"))
		{
		    if(lst.get(i).getPORTLET_URL().startsWith("REPORT_"))
		    {
			lst.get(i).setABV_DESC_KEY(getText("reporting.report"));
		    }
		    else
		    {
			lst.get(i).setABV_DESC_KEY(getText("external_key"));
			lst.get(i).setTITLE_KEY(lst.get(i).getTITLE_KEY()+" ("+lst.get(i).getPORTLET_URL()+")");
		    }
		}
		else
		{
		    lst.get(i).setABV_DESC_KEY(getText("widget_key"));
		}
	    }
	    setGridModel(lst);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    public String saveAllowedPortlets()
    {
	try
	{
	    if(!StringUtil.nullToEmpty(updates).isEmpty())
	    {
		GridUpdates gu = getGridUpdates(updates, SYS_PARAM_USR_ALLOWED_PORTLETSVO.class);
		dashBoardSC.setUserAllowedPortletsDel(gu.getLstDelete());
		dashBoardSC.setUserAllowedPortletsAdd(gu.getLstAdd());
		dashBoardSC.setCompCode(returnSessionObject().getCompanyCode());
		dashBoardSC.setPreferredLanguage(returnSessionObject().getLanguage());
		dashBoardSC.setLovTypeId(ConstantsCommon.USER_STATUS_LOV_TYPE);
		dashboardPortalBO.updUserAllowedPortlet(dashBoardSC);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
  
    public void setDashboardPortalBO(DashboardPortalBO dashboardPortalBO)
    {
	this.dashboardPortalBO = dashboardPortalBO;
    }

    public String getUpdates()
    {
	return updates;
    }

    public void setUpdates(String updates)
    {
	this.updates = updates;
    }

    public DashboardPortalSC getDashBoardSC()
    {
        return dashBoardSC;
    }

    public void setDashBoardSC(DashboardPortalSC dashBoardSC)
    {
        this.dashBoardSC = dashBoardSC;
    }
}
