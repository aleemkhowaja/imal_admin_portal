package com.path.vo.common.dashboardportal;

import com.path.struts2.lib.common.GridParamsSC;

public class DashboardWkspceWidgetSC extends GridParamsSC
{

    private String roleName;
    private String userId;
    private String wkspacePortletCode = "USR_WORKSPACE";
    
    public String getRoleName()
    {
        return roleName;
    }
    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
    public String getUserId()
    {
        return userId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    public String getWkspacePortletCode()
    {
        return wkspacePortletCode;
    }
    public void setWkspacePortletCode(String wkspacePortletCode)
    {
        this.wkspacePortletCode = wkspacePortletCode;
    }
}
