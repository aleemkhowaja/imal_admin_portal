package com.path.vo.admin.role;

import com.path.struts2.lib.common.GridParamsSC;

public class RoleSC extends GridParamsSC
{
    	private String roleName;
    	private String rolePrevName;
    	private String appList;//Comma Separated App Names
    	
	public String getRoleName()
	{
	    return roleName;
	}
	public void setRoleName(String roleName)
	{
	    this.roleName = roleName;
	}
	public RoleSC()
	{
		super.setSearchCols(new String[] { "ROLE_NAME", "LONG_NAME","APP_NAME" });
	}
	/**
	 * @return the rolePrevName
	 */
	public String getRolePrevName()
	{
	    return rolePrevName;
	}
	/**
	 * @param rolePrevName the rolePrevName to set
	 */
	public void setRolePrevName(String rolePrevName)
	{
	    this.rolePrevName = rolePrevName;
	}
	public String getAppList() {
		return appList;
	}
	public void setAppList(String appList) {
		this.appList = appList;
	}
}
