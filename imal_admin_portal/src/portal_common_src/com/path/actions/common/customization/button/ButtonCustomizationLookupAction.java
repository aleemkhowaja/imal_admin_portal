/**
 * 
 */
package com.path.actions.common.customization.button;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.path.actions.lookups.admin.UserReportsLookupAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.customization.button.ButtonCustomizationBO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ELEMENTSVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.customization.button.ButtonCustomizationConstants.BtnCustSessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationSC;
import com.path.vo.common.dynlookup.DynCommonLookupSC;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * ButtonCustomizationLookupAction.java used to
 */
public class ButtonCustomizationLookupAction extends UserReportsLookupAction
{
    private List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
    private ButtonCustomizationBO buttonCustomizationBO;
    private ButtonCustomizationSC criteria = new ButtonCustomizationSC();
    public Object getModel()
    {
        return criteria;
    }
    
    public String constructActionsLookup()
    {
	try
	{
	    if(ButtonCustomizationConstants.API_TYPE.REPORT.equals(criteria.getActionType()))
	    {
		super.constructLookup();
	    }
	    else if(ButtonCustomizationConstants.API_TYPE.SCREEN.equals(criteria.getActionType()))
	    {
		constructDynScreenActionLookup();
	    }
	    else
	    {
		// Design the Grid by defining the column model and column names

		String[] name = { "REPORT_PROG_REF", "imImalApiVO.DESCRIPTION", "imImalApiVO.SERVICE_TYPE" };

		String[] colType = { "text", "text",
		/* "text", */"text" };
		String[] titles = {
			criteria.getLinkToPreviousAction() == null ? getText("Action_id_key")
				: getText("Operation_id_key"), getText("Description_key"), getText("Action_type_key") };

		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("Actions_List_key"));
		grid.setRowNum("5");
		grid.setUrl("/path/buttoncustomization/ButtonCustomizationLookupAction_fillActionsLookup");
		lookup(grid, criteria, name, colType, titles);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    
    public String constructGlobalActionsLookup()
    {
	try
	{
		// Design the Grid by defining the column model and column names

		String[] name = { "sysParamBtnCustActionsVO.OP_ID", "sysParamBtnCustActionsVO.DESCRIPTION", "sysParamBtnCustActionsVO.API_CODE","btnApiDescription" };

		String[] colType = { "number", "text", "number", "text" };
		String[] titles = {getText("Operation_id_key"),getText("Description_key"),getText("api_code_key"),getText("btn_api_description_key") };
		// Defining the Grid
		LookupGrid grid = new LookupGrid();
		grid.setCaption(getText("Actions_List_key"));
		grid.setRowNum("5");
		grid.setUrl("/path/buttoncustomization/ButtonCustomizationLookupAction_fillActionsLookup");
		lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    
    public String constructBtnOutOpId()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    
	    String[] name = { "sysParamBtnCustActionsVO.OP_ID", "sysParamBtnCustActionsVO.DESCRIPTION", "sysParamBtnCustActionsVO.API_CODE","btnApiDescription" };
	    
	    String[] colType = { "number", "text", "number", "text" };
	    String[] titles = {getText("Operation_id_key"),getText("Description_key"),getText("api_code_key"),getText("btn_api_description_key") };
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Actions_List_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/path/buttoncustomization/ButtonCustomizationLookupAction_fillBtnOutOpIdLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    /**
     * used to construct lookup for ActionId in case of Screen in Dynamic Screen
     * @return
     */
    public String constructDynScreenActionLookup()
    {
	try
	{	    
	    String[] name = { "REPORT_PROG_REF", "sysDynScreenDefVO.DYN_SCREEN_DESC" };
	    construcScreenOrAPILookup(name);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }

    private void construcScreenOrAPILookup(String[] name) throws BaseException
    {
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
    
    public String constructDynScreenLookup()
    {
	try
	{	    
	    String[] name = { "sysDynScreenDefVO.DYN_SCREEN_ID", "sysDynScreenDefVO.DYN_SCREEN_DESC" };
	    construcScreenOrAPILookup(name);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public String fillActionsLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    criteria.setLovTypeId(ButtonCustomizationConstants.LOV_TYPE_API_TYPE);
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(buttonCustomizationBO.returnActionsListCount(criteria));
	    }
	    List<ButtonCustomizationCO> actionsList = buttonCustomizationBO.returnActionsList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(actionsList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String fillBtnOutOpIdLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCurrAppName(sessionCO.getCurrentAppName());
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    criteria.setLovTypeId(ButtonCustomizationConstants.LOV_TYPE_API_TYPE);
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(buttonCustomizationBO.returnActionsOutMapListCount(criteria));
	    }
	    List<ButtonCustomizationCO> actionsList = buttonCustomizationBO.returnActionsOutMapList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(actionsList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String constructScreenElementLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"FLD_IDENTIFIER", "FIELD_KEY_LABEL_CODE",
		    	     "FIELD_ID", "FIELD_TYPE","FROM_SOURCE"};
	    
	    String[] colType = { "number", "text", 
		    		 "text", "text","text"};
	    String[] titles = { getText("Field_identifier_key"), getText("Label_key"),
		    		getText("Element_id_key"), getText("Type_key"),getText("from_source_key")};
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Screen_Element_List_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/path/buttoncustomization/ButtonCustomizationLookupAction_fillScreenElementsLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    
    public String fillScreenElementsLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    
	    criteria.setCurrAppName(StringUtil.nullEmptyToValue(criteria.getCurrAppName(), sessionCO.getCurrentAppName()));
	     String theProgRef = StringUtil.nullEmptyToValue(criteria.getProgRef(),get_pageRef());
	     criteria.setProgRef(returnCommonLibBO().returnOrginProgRef(criteria.getCurrAppName(),theProgRef));
	   
	    if(checkNbRec(criteria))
	    {
		setRecords(buttonCustomizationBO.returnScreenElementListCount(criteria));
	    }
	    List<SYS_PARAM_SCREEN_ELEMENTSVO> actionsList = buttonCustomizationBO.returnScreenElementList(criteria);
	    
	    if(actionsList != null && !actionsList.isEmpty())
	    {
		for(SYS_PARAM_SCREEN_ELEMENTSVO element : actionsList)
		{
		    element.setFIELD_KEY_LABEL_CODE(getText(element.getFIELD_KEY_LABEL_CODE()));
		}
	    }
	    
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(actionsList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String constructSessionElementLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"propertyName", "description"};
	    
	    String[] colType = {"text","text"};
	    String[] titles = { getText("cust.name"),getText("Description_key")};  
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Session_Element_List_key"));
	    grid.setRowNum("5");
	    grid.setPagerButtons("false");
	    grid.setUrl("/path/buttoncustomization/ButtonCustomizationLookupAction_fillSessionElementsLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    
    
    public String fillSessionElementsLookup()
    {
	try
	{
	    //no need to search because the search is disabled , PagerButtons is set to false so the search is done at client side 
	    //setSearchFilter(criteria);
	    //copyproperties(criteria);
	    List<BtnCustSessionCO> declaredFieldsList =  new ArrayList(ButtonCustomizationConstants.SESSIONCO_PROPERTIES.values());
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(declaredFieldsList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String constructGridColumnElementLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"propertyName", "description"};
	    
	    String[] colType = {"text","text"};
	    String[] titles = { getText("cust.name"),getText("Description_key")};  
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Session_Element_List_key"));
	    grid.setRowNum("5");
	    grid.setPagerButtons("false");
	    grid.setUrl("/path/buttoncustomization/ButtonCustomizationLookupAction_fillGridColumnElementsLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    
    
    public String fillGridColumnElementsLookup()
    {
	try
	{
	    //no need to search because the search is disabled , PagerButtons is set to false so the search is done at client side 
	    //setSearchFilter(criteria);
	    //copyproperties(criteria);
	    List<BtnCustSessionCO> declaredFieldsList =  new ArrayList<BtnCustSessionCO>();
	    if(StringUtil.isNotEmpty(criteria.getGridColumns()))
	    {
		ObjectMapper mapper = new ObjectMapper();
		declaredFieldsList = mapper.readValue(URLDecoder.decode(criteria.getGridColumns(),FileUtil.DEFAULT_FILE_ENCODING), new TypeReference<List<BtnCustSessionCO>>(){});
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(declaredFieldsList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    /**
     * Common method to construct screen or session lookup
     * @return
     */
    public String constructScreenElementsOrSessionLookup()
    {
	try
	{	
	    if(ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(criteria.getMapType()))
	    {
		constructScreenElementLookup();
	    }
	    else if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(criteria.getMapType()))
	    {
		constructSessionElementLookup();
	    }
	    else if(ButtonCustomizationConstants.MAP_TYPE.GRIDCOLUMN.equals(criteria.getMapType()))
	    {
		constructGridColumnElementLookup();
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    
    
    public String constructArgLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"imApiArgumentVO.ARG_ID", "imApiArgumentVO.ARG_NAME",
		    	     "imApiArgumentVO.ARG_TYPE", "imApiArgumentVO.STATUS","imApiArgumentVO.DESCRIPTION"};
	    
	    String[] colType = { "number", "text", 
		    		 "text",  "text", "text"};
	    String[] titles = { getText("Argument_id_key"), getText("arg_name_key"), 
		    		getText("arg_type_key"),getText("Status_key"), getText("Description_key")};
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Arg_List_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/path/buttoncustomization/ButtonCustomizationLookupAction_fillArgLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public String fillArgLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    criteria.setLovTypeId(ButtonCustomizationConstants.LOV_TYPE_ARG_TYPE);
	    criteria.setStatusLovTypeId(ButtonCustomizationConstants.LOV_TYPE_ARG_STATUS);
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(buttonCustomizationBO.returnArgListCount(criteria));
	    }
	    List<ButtonCustomizationCO> actionsList = buttonCustomizationBO.returnArgList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(actionsList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    
    public String constructOperationsLookup()
    {
	try
	{	    
	    // Design the Grid by defining the column model and column names
	    String[] name = {"sysParamBtnCustActionsVO.OP_ID", "operationDesc",
		    	     "sysParamBtnCustActionsVO.DESCRIPTION", "sysParamBtnCustActionsVO.PARENT_OP_ID"};
	    
	    String[] colType = { "number", "text", 
		    		 "text",  "number"};
	    String[] titles = { getText("Operation_id_key"), getText("OP_TYPE_key"), 
		    		getText("Description_key"),getText("PARENT_OP_ID_key")};
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Operation_List_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/path/buttoncustomization/ButtonCustomizationLookupAction_fillOperationsLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public String fillOperationsLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    criteria.setLovTypeId(ButtonCustomizationConstants.LOV_TYPE_API_TYPE);
		criteria.setStatusLovTypeId(ButtonCustomizationConstants.LOV_TYPE_OPERATION_TYPE);
	    if(checkNbRec(criteria))
	    {
		setRecords(buttonCustomizationBO.returnButtonActionsListCount(criteria));
	    }
	    List<ButtonCustomizationCO> actionsList = buttonCustomizationBO.returnButtonActionsList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(actionsList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String constructButtonActivityLookup()
    {
	try
	{	
	    // load dynamic screen lookup
	    if(ButtonCustomizationConstants.ACTIVITY_TYPE.DYNAMIC.equals(criteria.getActionType()))
	    {
		constructDynScreenLookup();
	    }
	    // load global activity lookup
	    else if(ButtonCustomizationConstants.ACTIVITY_TYPE.GLOBAL.equals(criteria.getActionType())
		    || ButtonCustomizationConstants.ACTIVITY_TYPE.CUSTOM.equals(criteria.getActionType())
		    || ButtonCustomizationConstants.ACTIVITY_TYPE.BEFOREEXECUTION.equals(criteria.getActionType())
		    || ButtonCustomizationConstants.ACTIVITY_TYPE.AFTEREXECUTION.equals(criteria.getActionType())
		    || ButtonCustomizationConstants.ACTIVITY_TYPE.ONCHANGE.equals(criteria.getActionType())
		    || ButtonCustomizationConstants.ACTIVITY_TYPE.KEYEVENT.equals(criteria.getActionType())
		    || ButtonCustomizationConstants.ACTIVITY_TYPE.BOTH.equals(criteria.getActionType())
		    || ButtonCustomizationConstants.ACTIVITY_TYPE.DOUBLECLICK.equals(criteria.getActionType()))
	    {
		constructGlobalActivityLookup();
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public String constructGlobalActivityLookup()
    {
	try
	{	
	    // Design the Grid by defining the column model and column names
	    String[] name = { "sysParamBtnCustVO.BTN_ID", "DYN_SCREEN_ID", "sysParamBtnCustVO.DESCRIPTION"};
	    Boolean[] hidden = { false, true, false};
	    String[] colType = { "number", "number", "text"};

	    List<String> titlesList = null;
	    //in case of activity type is a custom buttom
	    if("3".equals(criteria.getActionType()))
	    {
		titlesList = Arrays.asList(getText("cust_btn_key"), "", getText("Description_key"));
	    }
	    else
	    {
		titlesList = Arrays.asList(getText("activity_id_key"), "", getText("Description_key"));
	    }
	    String[] titles = (String[])titlesList.toArray(new String[titlesList.size()]);
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("global_activities_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/path/buttoncustomization/ButtonCustomizationLookupAction_fillGlobalActivityLookup");

	    int cols = name.length;
      
	    for(int i = 0; i < cols; i++)
	    {
		/**
		 * Defining each column...
		 */
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(name[i]);
		gridColumn.setIndex(name[i]);
		gridColumn.setColType(colType[i]);
		gridColumn.setHidden(hidden[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);

		/**
		 * adding column to the list...
		 */
		lsGridColumn.add(gridColumn);
	    }
	    lookup(grid, lsGridColumn, null, criteria);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public String fillGlobalActivityLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    //in case of custom button 
	    if("3".equals(criteria.getActionType()))
	    {
		 criteria.setProgRef(returnCommonLibBO().returnOrginProgRef(criteria.getCurrAppName(),criteria.getProgRef()));
	    }
	    //in case of global activity
	    else
	    {
		 criteria.setCurrAppName(ConstantsCommon.IMAL_APP_NAME);
		 criteria.setProgRef(ConstantsCommon.PROGREF_ROOT);
	    }
	   
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(buttonCustomizationBO.returnButtonCustomListCount(criteria));
	    }
	    /**
	     *  return the collection of records
	     */
	    List<ButtonCustomizationCO> buttonCustomizationCOList = buttonCustomizationBO.returnButtonCustomList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(buttonCustomizationCOList);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public ButtonCustomizationSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(ButtonCustomizationSC criteria)
    {
        this.criteria = criteria;
    }

    public void setButtonCustomizationBO(ButtonCustomizationBO buttonCustomizationBO)
    {
        this.buttonCustomizationBO = buttonCustomizationBO;
    }
    
}
