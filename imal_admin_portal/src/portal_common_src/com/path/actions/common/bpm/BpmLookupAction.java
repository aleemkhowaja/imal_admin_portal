/**
 * 
 */
package com.path.actions.common.bpm;

import java.util.List;
import java.util.Map;

import com.path.bo.common.bpm.BpmBO;
import com.path.bo.common.bpm.BpmEngineConstant;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DEFINITIONVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.bpm.BpmCO;
import com.path.vo.common.bpm.BpmSC;
import com.path.vo.common.bpm.jbpm.JbpmProcessVarCO;
import com.path.vo.common.dynlookup.DynCommonLookupSC;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * BpmLookupAction.java used to
 */
public class BpmLookupAction extends LookupBaseAction
{
    private BpmBO bpmBO;
    private BpmSC criteria = new BpmSC();
    
    public Object getModel()
    {
        return criteria;
    }
    
    public String constructScreenDefLookup()
    {
	try
	{	    
	   if(BpmEngineConstant.TASK_ACTION_TYPE.DYNAMIC.equals(criteria.getActionType()))
	   {
	       	constructDynScreenLookup();
	   }
	   else
	   {
	       	// Design the Grid by defining the column model and column names
	       	String[] name = {"SCREEN_CODE", "SCREEN_DESC", "APP_NAME", "PROG_REF"};
		    
	       	String[] colType = { "text", "text", "text", "text"};
	       	String[] titles = { getText("screen_code_key"), getText("Description_key"),getText("app_name_key"), getText("prog_ref_key")};
		    
		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("Screen_Definitions_List_key"));
		grid.setRowNum("5");
		grid.setUrl("/path/bpm/BpmLookupAction_fillScreenDefLookup");
		lookup(grid, criteria, name, colType, titles);
	   }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    
    public String fillScreenDefLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    
	    PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    criteria.setLovTypeId(BpmEngineConstant.LOV_TYPE_ID_SCREEN_DESC);
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setProfType(NumberUtil.nullToZero(pthCtrl.getPOP_PROF_MOD_ACCESS()));
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(bpmBO.returnScreenDefListCount(criteria));
	    }
	    List<SYS_PARAM_SCREEN_DEFINITIONVO> actionsList = bpmBO.returnScreenDefList(criteria);
	    
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(actionsList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String constructProcessVarLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"id"};
	    
	    String[] colType = {"text"};
	    String[] titles = { getText("cust.name")};  
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Process_Variables_List_key"));
	    grid.setRowNum("5");
	    grid.setPagerButtons("false");
	    grid.setUrl("/path/bpm/BpmLookupAction_fillProcessVarLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    
    public String fillProcessVarLookup()
    {
	try
	{
	    //no need to search because the search is disabled , PagerButtons is set to false so the search is done at client side 
	    //setSearchFilter(criteria);
	    //copyproperties(criteria);
	    BpmCO bpmCO = new BpmCO(); 
	    bpmCO.setProcessId(criteria.getProcessId());
	    List<JbpmProcessVarCO> processVarList = bpmBO.returnProcessVarList(bpmCO);
	    
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(processVarList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    
    public String constructTaskAssignmentLookup()
    {
	try
	{
	    if(BpmEngineConstant.TASK_ASSIGN_TYPE.USER.equals(criteria.getTaskAssignmentType()))
	    {
		// Design the Grid by defining the column model and column names
		String[] name = { "USER_ID", "FIRST_NAME", "MIDDLE_NAME", "LAST_NAME", "USER_GRP_ID", "USER_GRP_DESC",
			"USER_VALID_DT", "USER_STS", "DATE_AUTHORIZED" };
		String[] colType = { "text", "text", "text", "text", "text", "text", "date", "text", "date" };
		String[] titles = { getText("userId"), getText("First_Name_eng_key"), getText("Middle_Name_eng_key"),
			getText("Last_Name_eng_key"), getText("Group_ID_key"), getText("Group_Description_key"),
			getText("User_Validity_Date_key"), getText("Status_key"), getText("Authorization_key") };

		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setRowNum("5");
		grid.setUrl("/path/bpm/BpmLookupAction_fillUsersLookup");
		lookup(grid, criteria, name, colType, titles);
	    }
	    else if(BpmEngineConstant.TASK_ASSIGN_TYPE.ROLE.equals(criteria.getTaskAssignmentType()))
	    {
		// Design the Grid by defining the column model and column names
		String[] name = { "USER_ID", "LONG_NAME", "APP_NAME" };

		String[] colType = { "text", "text", "text"};
		String[] titles = { getText("Name_key"), getText("Description_key"), getText("app_name_key") };

		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setRowNum("5");
		grid.setUrl("/path/bpm/BpmLookupAction_fillRolesLookup");
		lookup(grid, criteria, name, colType, titles);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    /**
     * Fill the lookup for User data filtered by the defined criteria
     * 
     * @return
     */
    public String fillUsersLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    if(Boolean.valueOf(criteria.getExcludeLoggedInUser()))
	    {
		criteria.setBpmUserName(sessionCO.getUserName());
	    }
	    if(checkNbRec(criteria))
	    {
		setRecords(bpmBO.returnUsersListCount(criteria));
	    }
	    List<USRVO> usersList = bpmBO.returnUsersList(criteria);
	    
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(usersList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillUsersLookup");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Fill the lookup for User data filtered by the defined criteria
     * 
     * @return
     */
    public String fillRolesLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	   
	    if(checkNbRec(criteria))
	    {
		setRecords(bpmBO.returnRolesListCount(criteria));
	    }
	    List<Map<String, Object>> rolesList = bpmBO.returnRolesList(criteria);
	    
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(rolesList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillRolesLookup");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * this method will construct the dynamic screen lookup
     */
    public String constructDynScreenLookup()
    {
	try
	{	    
	    String[] name = { "sysDynScreenDefVO.DYN_SCREEN_ID", "sysDynScreenDefVO.DYN_SCREEN_DESC" };
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("screenId_key"), getText("screenDesc_key") };

	    /**
	     * Defining The Grid ...
	     */
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("screen_list_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/path/dynamicScreen/dynScreenLookupAction_loadDynScreensLookup");
	    lookup(grid, new DynCommonLookupSC(), name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public void setBpmBO(BpmBO bpmBO)
    {
        this.bpmBO = bpmBO;
    }

    public BpmSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(BpmSC criteria)
    {
        this.criteria = criteria;
    }
         
}
