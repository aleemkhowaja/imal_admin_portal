/**
 * 
 */
package com.path.actions.lookups.admin;

import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.dynclientparams.DynClientParamsBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynclientparams.DynClientParamsCO;
import com.path.vo.common.dynclientparams.DynClientParamsSC;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: rabihelkhatib
 * 
 *          DynClientParamsLookupAction.java used to generate the Dynamic Client
 *          params Screen Lookups
 */
public class DynClientParamsLookupAction extends LookupBaseAction
{

    private DynClientParamsBO dynClientParamsBO;
    private DynClientParamsSC dynClientParamsSC = new DynClientParamsSC();

    @Override
    public Object getModel()
    {
	return dynClientParamsSC;
    }

    /**
     * Group ID lookup
     * 
     * @return
     */
    public String constructDynClientGridDataLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] colsNamesArray = null;
	    //check for Additional columns in the lookupQuery
	    String colsNames = dynClientParamsSC.getColsNames();
		colsNamesArray = colsNames.split(",");
		String[] colsType = new String[colsNamesArray.length];
		String[] titles = new String[colsNamesArray.length];
	    if(colsNames != null)
	    {
		for(int i = 0; colsNamesArray.length > i; i++)
		{
		    colsType[i] = "text";
		    if(colsNamesArray[i]!=null&&colsNamesArray[i].equalsIgnoreCase(dynClientParamsSC.getDisplayField()))
		    {
			titles[i] = getText(dynClientParamsSC.getDisplayField());
		    }
		    else if(colsNamesArray[i]!=null&&colsNamesArray[i].equalsIgnoreCase(dynClientParamsSC.getValueField()))
		    {
			titles[i] = getText(dynClientParamsSC.getValueField());
		    }
		    else
		    {
			titles[i] = colsNamesArray[i];
		    }
		}
	    }
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Operation_List_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/DynClientParamsLookup_fillDynClientGridDataLookup"
		    + "?dynClientParamsSC.tableName=" + dynClientParamsSC.getTableName()
		    + "&dynClientParamsSC.groupCode=" + dynClientParamsSC.getGroupCode()
		    + "&dynClientParamsSC.dynamicQuery=" + dynClientParamsSC.getDynamicQuery());
	    lookup(grid, dynClientParamsSC, colsNamesArray, colsType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public String fillDynClientGridDataLookup()
    {
	try
	{
	    SessionCO currSession = returnSessionObject();
	    dynClientParamsSC.setCompCode(currSession.getCompanyCode());
	    dynClientParamsSC.setBranchCode(currSession.getBranchCode());
	    dynClientParamsSC.setBaseCurrencyCode(currSession.getBaseCurrencyCode());
	    dynClientParamsSC.setUserId(currSession.getUserName());
	    ArrayList<DynClientParamsCO> columnsList = dynClientParamsBO.selectColumnsList(dynClientParamsSC);
	    if(columnsList != null)
	    {
		for(DynClientParamsCO colDetailsCO : columnsList)
		{
		    if(colDetailsCO.getSysDynParamColumns().getCOLUMN_NAME()
			    .equals(dynClientParamsSC.getDynamicQuery())
			    && ConstantsCommon.LIVESEARCH_CONTROL_TYPE.equals(colDetailsCO.getSysDynParamColumns()
				    .getCONTROL_TYPE()))
		    {
			dynClientParamsSC.setDynamicQuery(colDetailsCO.getSysDynParamColumns().getLOOKUP_EXPRESSION());
		    }
		}
	    }

	    if("false".equals(dynClientParamsSC.get_search()))
	    {
		dynClientParamsSC.setLiveSearchCols("");
	    }
	    setSearchFilter(dynClientParamsSC);
	    copyproperties(dynClientParamsSC);

	    if(checkNbRec(dynClientParamsSC))
	    {
		setRecords(dynClientParamsBO.returnDynClientParamsQueryListCount(dynClientParamsSC));
	    }
	    List<Object> actionsList = dynClientParamsBO.returnDynClientParamsQueryList(dynClientParamsSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(actionsList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public DynClientParamsSC getDynClientParamsSC()
    {
	return dynClientParamsSC;
    }

    public void setDynClientParamsSC(DynClientParamsSC dynClientParamsSC)
    {
	this.dynClientParamsSC = dynClientParamsSC;
    }

    public void setDynClientParamsBO(DynClientParamsBO dynClientParamsBO)
    {
	this.dynClientParamsBO = dynClientParamsBO;
    }
}
