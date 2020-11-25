package com.path.actions.lookups.admin;

import java.util.List;

import com.path.bo.common.dashboardportal.DashboardPortalBO;
import com.path.dbmaps.vo.SYS_PARAM_PORTLET_TYPEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.dashboardportal.DashboardPortalSC;

public class DashboardPortalLookupAction extends LookupBaseAction
{
    private final DashboardPortalSC criteria = new DashboardPortalSC();
    private DashboardPortalBO dashboardPortalBO;

    public Object getModel()
    {
	return criteria;
    }


    /**
     * Group ID lookup
     * 
     * @return
     */
    public String portletLookup()
    {
	try
	{
	    String[] name = { "ABV_DESC_KEY", "TITLE_KEY", "PORTLET_CODE"};
	    String[] colType = { "text", "text", "text" };
	    String[] titles = { getText("widget_name_key"), getText("title_key"), getText("code_key")};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");

	    grid.setUrl("/pathdesktop/DashboardPortalLookupAction_fillPortletsLookup");
	    lookup(grid, criteria, name, colType, titles);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillPortletsLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);

	    if(checkNbRec(criteria))
	    {
		setRecords(dashboardPortalBO.returnPortletsListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    List<SYS_PARAM_PORTLET_TYPEVO> lst = dashboardPortalBO.returnPortletsList(criteria);

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


    public DashboardPortalSC getCriteria()
    {
        return criteria;
    }
}
