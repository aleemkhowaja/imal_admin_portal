package com.path.actions.admin.user;

import java.util.HashMap;
import java.util.List;

import com.path.bo.admin.user.UsrBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.admin.user.UsrSC;

/**
 * 
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: MireilleHaddad
 * 
 *          UsrListAction.java used to load user grid
 */
public class UsrListAction extends GridBaseAction
{
	private UsrBO usrBO;
	private UsrSC usrSC = new UsrSC();

	private String rowId;

	public String execute() throws Exception
	{
		return SUCCESS;
	}

	public Object getModel()
	{
		return usrSC;
	}

	public void setUsrBO(UsrBO usrBO)
	{
		this.usrBO = usrBO;
	}

	public String loadGrid()
	{
		try
		{
			HashMap hm = new HashMap();
			hm.put("A", "Active");
			hm.put("N", "New");
			hm.put("L", "Logged");
			hm.put("S", "Suspended");
			usrSC.setStatus(hm);
			// copy the details related to search criteria to the SC
			copyproperties(usrSC);
			// set number of rows to be displayed in the page of grid, and the
			// total number of records for first time load only
			if(getRecords() == 0)
			{
				setRecords(usrBO.getUserCount(usrSC));
			}
			// return the collection of records
			List<UsrCO> users = usrBO.getUserList(usrSC);
			// set the collection into gridModel attribute defined at JSP grid
			// tag
			setGridModel(users);

		}
		catch(Exception e)
		{
			log.error(e, "Error in loadGrid");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String deleteUsr()
	{
		try
		{
			UsrSC usrSC = new UsrSC();
			usrSC.setUser_id(rowId);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			log.error(ex, "Error in deleteUsr - UsrListAction ");
		}
		return "user_security";
	}

    public String loadAssignPortletGrid()
    {
	try
	{
	    usrSC.setSearchCols(new String[] { "USER_ID" });
	    copyproperties(usrSC);
	    if(checkNbRec(usrSC))
	    {
		setRecords(usrBO.returnPortletUsersListCount(usrSC));
	    }
	    List<UsrCO> lst = usrBO.returnPortletUsersList(usrSC);
	    setGridModel(lst);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
	public String reload()
	{
		return "csm_customer";
	}

	public void setRowId(String rowId)
	{
		this.rowId = rowId;
	}

	public UsrSC getUsrSC()
	{
	    return usrSC;
	}

	public void setUsrSC(UsrSC usrSC)
	{
	    this.usrSC = usrSC;
	}

}
