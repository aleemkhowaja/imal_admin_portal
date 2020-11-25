package com.path.actions.common.dashboard.workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.dashboardportal.DashboardPortalBO;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.dashboard.WorkspaceWidgetCO;
import com.path.vo.common.dashboardportal.DashboardWkspceWidgetSC;

public class DashWorkspaceAction extends GridBaseAction
{
    DashboardWkspceWidgetSC sc = new DashboardWkspceWidgetSC();
    private DashboardPortalBO dashboardPortalBO;
    private String updates;
    List<WorkspaceWidgetCO> lstWorkspaceDet = new ArrayList<WorkspaceWidgetCO>();
    String encryptedPassword;
    
    public Object getModel()
    {
	return sc;
    }

    public String loadCustomizationGrid()
    {
	try
	{
	    sc.setSearchCols(new String[]{"userWorkspaceVO.DISPLAY_CAPTION_KEY","userWorkspaceVO.DISPLAY_STYLE","fullPath"});
	    copyproperties(sc);
	    List<WorkspaceWidgetCO> lst = dashboardPortalBO.returnWorkspaceList(sc);
	    setGridModel(lst);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public String userDependency()
    {
	return SUCCESS;
    }

    public String saveWorkspaceForUserGroup()
    {
	try
	{
		GridUpdates gu = getGridUpdates(updates, WorkspaceWidgetCO.class, true);
		dashboardPortalBO.updateUserWorkspace(sc.getUserId(), sc.getRoleName(), gu.getLstAllRec());
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String loadDashWorkspaceByUser()
    {
	boolean propNotLoaded = false;
	Properties prop = null;
	try
	{
	    DashboardWkspceWidgetSC sc = new DashboardWkspceWidgetSC();
	    sc.setUserId(returnSessionObject().getUserName());
	    lstWorkspaceDet = dashboardPortalBO.returnWorkspaceForUser(sc);
	    WorkspaceWidgetCO theCO;
	    for(int i = 0; i < lstWorkspaceDet.size(); i++)
	    {
		theCO = lstWorkspaceDet.get(i);
		if(!propNotLoaded)
		{
		    prop = PropertiesLoaderUtils.loadAllProperties("PathRemoting.properties");
		    propNotLoaded = true;
		}
		theCO.setAppUrl(prop.getProperty("app." + theCO.getUserWorkspaceVO().getAPP_NAME() + ".url"));
	    }
	    
	    encryptedPassword = CommonMethods.returnEncryptedJpassword((String)SecurityContextHolder.getContext().getAuthentication().getCredentials());
	    
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

    public List<WorkspaceWidgetCO> getLstWorkspaceDet()
    {
	return lstWorkspaceDet;
    }

    public void setLstWorkspaceDet(List<WorkspaceWidgetCO> lstWorkspaceDet)
    {
	this.lstWorkspaceDet = lstWorkspaceDet;
    }

    /**
     * @return the encryptedPassword
     */
    public String getEncryptedPassword()
    {
        return encryptedPassword;
    }

    /**
     * @param encryptedPassword the encryptedPassword to set
     */
    public void setEncryptedPassword(String encryptedPassword)
    {
        this.encryptedPassword = encryptedPassword;
    }
       
}
