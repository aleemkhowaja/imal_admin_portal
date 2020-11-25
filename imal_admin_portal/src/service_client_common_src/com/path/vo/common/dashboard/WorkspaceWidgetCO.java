package com.path.vo.common.dashboard;

import com.path.dbmaps.vo.USER_WORKSPACEVO;
import com.path.lib.vo.BaseVO;

public class WorkspaceWidgetCO extends BaseVO
{
    private USER_WORKSPACEVO userWorkspaceVO;
    private String fullPath;
    private String appUrl;
    public USER_WORKSPACEVO getUserWorkspaceVO()
    {
        return userWorkspaceVO;
    }
    public void setUserWorkspaceVO(USER_WORKSPACEVO userWorkspaceVO)
    {
        this.userWorkspaceVO = userWorkspaceVO;
    }
    public String getFullPath()
    {
        return fullPath;
    }
    public void setFullPath(String fullPath)
    {
        this.fullPath = fullPath;
    }
    public String getAppUrl()
    {
        return appUrl;
    }
    public void setAppUrl(String appUrl)
    {
        this.appUrl = appUrl;
    }
}
