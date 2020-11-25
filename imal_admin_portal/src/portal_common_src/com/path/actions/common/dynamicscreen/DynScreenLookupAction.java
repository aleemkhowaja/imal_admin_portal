/**
 * 
 */
package com.path.actions.common.dynamicscreen;

import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.dynamicscreen.DynamicScreenBO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.customization.button.ButtonCustomizationConstants.BtnCustSessionCO;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
import com.path.vo.common.dynamicscreen.DynamicScreenConstant;
import com.path.vo.common.dynlookup.DynCommonLookupSC;
import com.path.vo.common.screengenerator.DynamicScreenCreatorCO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * ScreenLookupAction.java used to
 */
public class DynScreenLookupAction extends LookupBaseAction
{
    private DynCommonLookupSC criteria = new DynCommonLookupSC();
    private DynamicScreenBO dynamicScreenBO; 
    private List<DynamicScreenCreatorCO> screensLst;
    @Override
    public Object getModel()
    {
	return criteria;
    }
    
    /**
     * Build a Grid inside the LiveSearch ...
     */
    public String drawingDynScreensGrid()
    {
	try
	{
	    String[]  name    = { "sysDynScreenDefVO.DYN_SCREEN_ID", "sysDynScreenDefVO.DYN_SCREEN_DESC", "operationId"};
	    String[]  colType = { "number", "text", "number"};
	    String[]  titles  = { getText("screenId_key"), getText("screenDesc_key"),""};
	    Boolean[] hidden = { false, false, true};
	    
	    /**
	     * Defining The Grid ...
	     */
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("screen_list_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/path/dynamicScreen/dynScreenLookupAction_loadDynScreensLookup");
	    
	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
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

    /**
     * This method is to get data from BO and load them in a grid inside the liveSearch component. 
     * @return
     */
    public String loadDynScreensLookup()
    {
	try
	{
	  SessionCO sessionCO = returnSessionObject();
	  setSearchFilter(criteria);
	  copyproperties(criteria);
	  criteria.setCompCode(sessionCO.getCompanyCode());

	  if(getRecords() == 0)
	  {
	    setRecords(dynamicScreenBO.dynScreensLkpCount(criteria));
	  }
	  screensLst = dynamicScreenBO.dynScreensLkpRecords(criteria);
	  setGridModel(screensLst);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }


    /**
     * Build a Grid inside the LiveSearch ...
     */
    public String drawingDynScreenElementsGrid()
    {
	try
	{
	    String[]  name    = { "elementIdValue", "elementId","elementType"};
	    String[]  colType = { "number", "text", "text"};
	    String[]  titles  = { getText("ID_key"), getText("Element_id_key"), getText("Type_key")};

	    /**
	     * Defining The Grid ...
	     */
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("elements_list_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/path/dynamicScreen/dynScreenLookupAction_loadDynScreenElementsLookup");
	    lookup(grid, criteria, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /* SUPT190250 ,Vysakh,13/11/2019,BEGIN */
    /**
     * Common method to construct screen or session lookup
     * @return
     */
    public String constructDynScreenElementsOrSessionLookup()
    {
	try
	{	
	    // Construct session element lookup if source mapping is session variable
	    if(criteria.getDynParamType().compareTo(ConstantsCommon.SOURCE_MAPPING_SESSION_VARIABLE) == 0)
	    {
	    	constructSessionElementLookup();
	    }
	    else 
	    {
	    	drawingDynScreenElementsGrid();
	    }
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
	    grid.setUrl("/path/dynamicScreen/dynScreenLookupAction_fillSessionElementsLookup");
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
  
    /* SUPT190250 ,Vysakh,13/11/2019,END */
  
    /**
     * This method is to get data from BO and load them in a grid inside the liveSearch component. 
     * @return
     */
    public String loadDynScreenElementsLookup()
    {
	try
	{
	  SessionCO sessionCO = returnSessionObject();
	  setSearchFilter(criteria);
	  copyproperties(criteria);
	  criteria.setPreferredLanguage(sessionCO.getLanguage());
	  criteria.setLovTypeId(DynamicScreenConstant.LOV_ELEMENT_TYPE);
	  
	  if(getRecords() == 0)
	  {
	    setRecords(dynamicScreenBO.dynScreenElementsLkpCount(criteria));
	  }
	  List<DynamicScreenCO> elementsList = dynamicScreenBO.dynScreenElementsLkpRecords(criteria);
	  setGridModel(elementsList);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

   
    /**
     * @return the screensLst
     */
    public List<DynamicScreenCreatorCO> getScreensLst()
    {
        return screensLst;
    }

    /**
     * @param screensLst the screensLst to set
     */
    public void setScreensLst(List<DynamicScreenCreatorCO> screensLst)
    {
        this.screensLst = screensLst;
    }

    /**
     * @param dynamicScreenBO the dynamicScreenBO to set
     */
    public void setDynamicScreenBO(DynamicScreenBO dynamicScreenBO)
    {
        this.dynamicScreenBO = dynamicScreenBO;
    }

    /**
     * @return the criteria
     */
    public DynCommonLookupSC getCriteria()
    {
        return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(DynCommonLookupSC criteria)
    {
        this.criteria = criteria;
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
	    	dynScreenElementsGrid();
	    }
	    else if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(criteria.getMapType()))
	    {
	    	constructSessionElementLookup();
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    /**
     * This method is used to build a Grid inside the LiveSearch ...
     */
    public String dynScreenElementsGrid()
    {
	try
	{
	    String[]  name    = { "elementIdValue", "elementId","elementType","elementTypeCode","element_mode"};
	    String[]  colType = { "text", "text", "text","number", "text"};
	    String[]  titles  = { getText("ID_key"), getText("Element_id_key"), getText("Type_key"), getText("Code_key"), getText("Element_mode_key")};

	    /**
	     * Defining The Grid ...
	     */
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("elements_list_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/path/dynamicScreen/dynScreenLookupAction_dynScreenElementsLookup");
	    lookup(grid, criteria, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    /**
     * This method is to get data from BO and load them in a grid inside the liveSearch component. 
     * @return
     */
    public String dynScreenElementsLookup()
    {
	try
	{
	  SessionCO sessionCO = returnSessionObject();
	  setSearchFilter(criteria);
	  copyproperties(criteria);
	  criteria.setPreferredLanguage(sessionCO.getLanguage());
	  criteria.setLovTypeId(DynamicScreenConstant.LOV_ELEMENT_TYPE);
	  
	  if(getRecords() == 0)
	  {
	    setRecords(dynamicScreenBO.dynScreenElementsLkpCount(criteria));
	  }
	  List<DynamicScreenCO> elementsList = dynamicScreenBO.dynScreenElementsLkpRecords(criteria);
	    for (DynamicScreenCO dynamicScreenCO : elementsList) {
	    	dynamicScreenCO.setElement_mode(String.valueOf(dynamicScreenCO.getElementIdValue()));
		}
	  setGridModel(elementsList);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
  

}
