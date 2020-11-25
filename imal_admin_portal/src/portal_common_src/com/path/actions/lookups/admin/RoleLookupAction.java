package com.path.actions.lookups.admin;

import java.util.List;

import com.path.bo.admin.role.RoleBO;
import com.path.dbmaps.vo.S_ROLEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.role.RoleSC;

public class RoleLookupAction extends LookupBaseAction
{
    private RoleSC roleSC = new RoleSC();

    public RoleSC getRoleSC()
    {
	return roleSC;
    }

    public void setRoleSC(RoleSC roleSC)
    {
	this.roleSC = roleSC;
    }

    private RoleBO roleBO;

    public Object getModel()
    {
	return roleSC;
    }

    public String constructLookup()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "ROLE_NAME", "LONG_NAME", "APP_NAME" };
	    String[] colType = { "text", "text", "text" };
	    String[] titles = { getText("role_name_key"), getText("role_long_name_key"),
		    getText("APPLICATION_NAME_key") };

	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("roles_key"));
	    grid.setRowNum("5");
	    grid.setShrinkToFit("true");
	    grid.setUrl("/pathdesktop/RoleLookupAction_fillLookupRoles");
	    lookup(grid, roleSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;

    }

    public String fillLookupRoles()
    {
	try
	{
	    setSearchFilter(roleSC);
	    // Get the data from BO
	    copyproperties(roleSC);
	    if(getRecords() == 0)
	    {
		setRecords(roleBO.returnRolesCount(roleSC));
	    }
	    List<S_ROLEVO> rolesLst = roleBO.returnRolesList(roleSC);
	    setGridModel(rolesLst);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setRoleBO(RoleBO roleBO)
    {
	this.roleBO = roleBO;
    }
}
