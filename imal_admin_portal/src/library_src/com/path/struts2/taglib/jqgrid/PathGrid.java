/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.path.struts2.taglib.jqgrid;

import java.io.Writer;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jgeppert.struts2.jquery.grid.components.Grid;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.SYS_PARAM_ELEM_ACTIVITIESVO;
import com.path.dbmaps.vo.SYS_PARAM_OBJ_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.CustomElementActivitiesSC;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;

public class PathGrid extends Grid
{

    protected String accessRights;
    protected String securityRef;
    protected String multiHeader;
    protected String addfunc;
    protected String editfunc;
    protected String delfunc;
    protected String viewfunc;

    protected String treeGrid;
    protected String treeGridModel;
    protected String disableEditableFocus;
    protected String subGridOptions;
    protected String forceNavAdd;
    protected String forceNavDelete;
    protected String expandColumn;
    protected String serializeGridData;
    protected String multiSort;
    protected String dragLockRowColor;
    protected String dragLockColName;
    protected String dragLockColVal;
    protected String fromCustomization;
    protected String rowColorCssColumn;
    protected String dontLoadData;
    protected String hasDefaultValueOnAddRow;
    
    /**
     * [MarwanMaddah]: Used in the columns reordering management
     */
    protected String columnsOrder;
    
    /**
     * [KhaledHussein]: Add ability to export grid into excel file
     */
    protected String exportExcel;
    
    private String customBtnData;

    public PathGrid(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);

    }

    @Override
    public boolean start(Writer arg0)
    {
	//the additional code should exists before calling super.start()	

	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	SYS_PARAM_OBJ_DISPLAYVO theVO   = RootUtil.returnParamObjDisplay(request, name, id); 
	//initial editinline of the grid
	String edit = editinline == null ? "false" : editinline;
	if(theVO != null)
	{
        	    if(theVO.getIS_READONLY() != null && theVO.getIS_READONLY().intValue() == 1)
        	    {
        		  editinline 		= "false";
        		  navigatorAdd 		= "false";
        		  navigatorDelete	= "false";
        	    }
        	    else
        	    {
        		   if(theVO.getADD_DELETE_ROW_YN() != null && theVO.getADD_DELETE_ROW_YN().intValue() == 0)
        		    {
        			    navigatorAdd 	= "false";
        			    navigatorDelete 	= "false";
        		    }
        		    else
        		    {
        			    navigatorAdd 	= "true";
        			    navigatorDelete 	= "true";
        		    }
        		    addParameter("editurl", "dummy");
        		    editinline = "true";
        	    }
        	    addParameter("navigatorAdd", findValue(navigatorAdd, Boolean.class));
        	    addParameter("navigatorDelete", findValue(navigatorDelete, Boolean.class));
        	    addParameter("editinline", findValue(editinline, Boolean.class));

	    if(theVO.getIS_VISIBLE() != null && theVO.getIS_VISIBLE().intValue() == 0)
	    {
		    hiddengrid = "true";
	    }
	    else
	    {
		    hiddengrid = "false";
	    }
	    addParameter("hiddengrid", findValue(hiddengrid, Boolean.class));
	    // if editinline changed therefore the readonly is set from customization not from development
	    if(!edit.equals(editinline))
	    {
		addParameter("fromCustomization", true);
	    }
	    
	    // get list of activities since we can now add before and after execution on the same button.
	    if(theVO != null)
	    {
		List<CustomElementActivitiesSC> activitiesVOList = RootUtil.returnParamElemActivities(theVO);

		if(activitiesVOList != null && activitiesVOList.size() > 0)
		{
		    SessionCO sessionCO = baseAction.returnSessionObject();
		    for(CustomElementActivitiesSC activityVO : activitiesVOList)
		    {
			SYS_PARAM_ELEM_ACTIVITIESVO sysParamElemActivity = activityVO.getSysParamElemActivitiesVO();
			
			SYS_PARAM_SCREEN_DISPLAYVO displayVO = new SYS_PARAM_SCREEN_DISPLAYVO();
			displayVO.setPROG_REF(theVO.getPROG_REF());
			displayVO.setElemSequenceId(sysParamElemActivity.getSEQUENCE_ID());
			
			try
			{
			    if(ButtonCustomizationConstants.ACTIVITY_TYPE.DOUBLECLICK
				    .equals(sysParamElemActivity.getACTIVITY_TYPE()))
			    {
				Map<String, Object> customBtnDataMap = RootUtil.returnButtonCustActionData(request,
					sysParamElemActivity.getACTIVITY_ID(), true, displayVO);
				customBtnDataMap.put("dynScreenAppName", theVO.getAPP_NAME());
				customBtnDataMap.put("dynScreenProgRef", theVO.getPROG_REF());
				customBtnDataMap.put("dynScreenCompCode", sessionCO.getCompanyCode());
				customBtnDataMap.put("dynScreenFldIdentifier",
					sysParamElemActivity.getFLD_IDENTIFIER());
				customBtnDataMap.put("isGlobalActivity", true);
				customBtnDataMap.put("elemSequenceId", sysParamElemActivity.getSEQUENCE_ID());
				customBtnDataMap.put("proceedExpression",
					sysParamElemActivity.getPROCEED_ON_EXPRESSION());
				RootUtil.addScreenElements(customBtnDataMap, activitiesVOList, request);
				customBtnData = PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null, false, true);
				addParameter("customBtnData", findString(customBtnData));
				String initialOnDblClick = ondblclick;
				String onDblClickValue = "var stopPropagation = customBtnActionCall('" + id + "', '0',"
					+ ("1".equals(sysParamElemActivity.getPROCEED_ON_FAIL()))
					+ ",$('#"+id+"').jqGrid('getGridParam').customBtnData); if(!stopPropagation){" + initialOnDblClick + "}";
				ondblclick = onDblClickValue;
				addParameter("ondblclick", onDblClickValue);
			    }
			}
			catch(Exception e)
			{
			    customBtnData = null;
			}
		    }
		}
	    }
	}
	
	/**
	 * [MarwanMaddah]: grid column re-ordering management...
	 */
	if("true".equals(StringUtil.nullToEmpty(sortable)))
	{
	    try
	    {
		columnsOrder = baseAction.returnObjectColumnsOrder(id,ConstantsCommon.PREF_OBJECT_TYPE_GRID);
		addParameter("columnsOrder",columnsOrder);
		/**
		 * in case the grid is sortable and pager is false
		 * in this case will display the toolbar without the pager button
		 */
		if(pager == null || "false".equals(StringUtil.nullToEmpty(pager)))
		{
		    pager = "true";
		    addParameter("pager",true);
		    pagerButtons = "false";
		    addParameter("pagerButtons",false);
		}
		
		/**
		 * Enable Grid column default order settings 
		 */
		String gridColSortRight = baseAction.returnAccessRightByProgRef(ConstantsCommon.GRID_COL_SORT_OPT);
		if(ConstantsCommon.GRID_COL_SORT_OPT.equals(StringUtil.nullToEmpty(gridColSortRight)))
		{
		    addParameter("gridColSortRight",true);
		}
	    }
	    catch(Exception ex)
	    {
		Log.getInstance().error(ex,"ERROR in reordering management on the load of the Grid"+id);
	    }
	}

	/*
	 * [KhaledHussein]: Check if the feature is enabled and add the
	 * translated key
	 */
	// Check if disable print screen
	boolean isDisableScreen = "1".equals(baseAction.returnSessionObject().getDisablePrntScrn()) ? true : false;

	if("true".equals(StringUtil.nullToEmpty(exportExcel)) && !isDisableScreen)
	{
	    addParameter("exportExcel", true);
	    addParameter("exportText", findString(baseAction.getEscText("export_to_excel")));
	    addParameter("exportOkBtn", findString(baseAction.getEscText("ok_key")));
	    addParameter("exportAllPagesLbl", findString(baseAction.getEscText("export_all_pages_key")));
	    addParameter("exportCurrentPageLbl", findString(baseAction.getEscText("Current_Page_key")));
	}

	if(accessRights != null)
	{
	    if(accessRights.isEmpty())
	    {
		navigatorAdd    = "false";
		navigatorEdit   = "false";
		navigatorDelete = "false";
		dataType        = "local";
		addParameter("navigatorAdd", false);
		addParameter("navigatorEdit", false);
		addParameter("navigatorDelete", false);
		addParameter("dataType", "local");
	    }
	    if(accessRights.indexOf("C") == -1)
	    {
		navigatorAdd = "false";
		addParameter("navigatorAdd", false);
	    }
	    if(accessRights.indexOf("R") == -1)
	    {
		dataType = "local";
		addParameter("dataType", "local");
	    }
	    if(accessRights.indexOf("U") == -1)
	    {
		navigatorEdit = "false";
		addParameter("navigatorEdit", false);
	    }
	    if(accessRights.indexOf("D") == -1)
	    {
		navigatorDelete = "false";
		addParameter("navigatorDelete", false);
	    }

	    addParameter("accessRights", findString(accessRights));
	}
        
	if(securityRef != null)
	{
	    addParameter("securityRef", findString(securityRef));
	}

	if(multiHeader != null)
	{
	    addParameter("multiHeader", findString(multiHeader));
	}

	if(addfunc != null)
	{
	    addParameter("addfunc", findString(addfunc));
	}
	if(editfunc != null)
	{
	    addParameter("editfunc", findString(editfunc));
	}
	if(delfunc != null)
	{
	    addParameter("delfunc", findString(delfunc));
	}
	if(viewfunc != null)
	{
	    addParameter("viewfunc", findString(viewfunc));
	}
	if(pagerButtons != null && pagerButtons.equals("false"))
	{
	    pagerInput = "false";
	    rowList = "";
	    rowNum = "-1";
	}
	if(treeGrid != null)
	{
	    addParameter("treeGrid", findValue(this.treeGrid, Boolean.class));
	}
	if(expandColumn != null)
	{
	    addParameter("expandColumn", findString(expandColumn));
	}
	if(treeGridModel != null)
	{
	    addParameter("treeGridModel", findString(treeGridModel));
	}
	// making grid not editable if global readonly set
	
	String _recReadOnly = StringUtil.nullToEmpty(baseAction.get_recReadOnly());
	if("true".equals(_recReadOnly))
	{
	    // addParameter("editinline", false);
	    if(!"true".equals(StringUtil.nullToEmpty(forceNavAdd)))
	    {
		navigatorAdd = "false";
		addParameter("navigatorAdd", false);
	    }
	    navigatorEdit = "false";
	    addParameter("navigatorEdit", false);
	    if(!"true".equals(StringUtil.nullToEmpty(forceNavDelete)))
	    {
		navigatorDelete = "false";
		addParameter("navigatorDelete", false);
	    }
	}
	
	if(disableEditableFocus != null)
	{
	    addParameter("disableEditableFocus", findString(disableEditableFocus));
	}
	if(!StringUtil.nullToEmpty(subGridOptions).isEmpty())
	{
	    addParameter("subGridOptions", findString(subGridOptions));
	}
	if(serializeGridData != null)
	{
	    addParameter("serializeGridData", findString(serializeGridData));
	}
	if(multiSort != null)
	{
	    addParameter("multiSort", findString(multiSort));
	}
	if(requestType == null)
	{
	    requestType = "POST"; // setting default of ajax calling of
				  // gridpopulate to POST
	}
	addParameter("requestType", requestType);
	
	if(dragLockRowColor != null)
	{
		addParameter("dragLockRowColor",findString(dragLockRowColor));
	}
	if(dragLockColName != null)
	{
		addParameter("dragLockColName",findString(dragLockColName));
	}
	if(dragLockColVal != null)
	{
		addParameter("dragLockColVal",findString(dragLockColVal));	
	}
	
	if(rowColorCssColumn!=null)
	{
	    addParameter("rowColorCssColumn",findString(rowColorCssColumn));
	}
	// TP 703941 
	if(!StringUtil.nullToEmpty(dontLoadData).isEmpty())
	{
		addParameter("dontLoadData",findString(dontLoadData));
	}
	else
	{
		addParameter("dontLoadData","false");
	}
	
	// TP 897711 - SUPT190250 - AMANA FMS Workflow project: Dynamic screen customization 
	if(!StringUtil.nullToEmpty(hasDefaultValueOnAddRow).isEmpty())
	{
	    addParameter("hasDefaultValueOnAddRow", findString(hasDefaultValueOnAddRow));
	}
	
	//escape id from special characters that might be used for security intrusion
	id =  RootUtil.escapeJS(id);
	//the super.start() should be called at the end of the method
	return super.start(arg0);
    }

    public String getSecurityRef()
    {
	return securityRef;
    }

    public void setSecurityRef(String securityRef)
    {
	this.securityRef = securityRef;
    }

    public String getMultiHeader()
    {
	return multiHeader;
    }

    public void setMultiHeader(String multiHeader)
    {
	this.multiHeader = multiHeader;
    }

    public String getAddfunc()
    {
	return addfunc;
    }

    public void setAddfunc(String addfunc)
    {
	this.addfunc = addfunc;
    }

    public String getEditfunc()
    {
	return editfunc;
    }

    public void setEditfunc(String editfunc)
    {
	this.editfunc = editfunc;
    }

    public String getDelfunc()
    {
	return delfunc;
    }

    public void setDelfunc(String delfunc)
    {
	this.delfunc = delfunc;
    }

    public String getViewfunc()
    {
	return viewfunc;
    }

    public void setViewfunc(String viewfunc)
    {
	this.viewfunc = viewfunc;
    }

    public void setTreeGrid(String treeGrid)
    {
	this.treeGrid = treeGrid;
    }

    public String getTreeGrid()
    {
	return treeGrid;
    }

    public String getTreeGridModel()
    {
	return treeGridModel;
    }

    public void setTreeGridModel(String treeGridModel)
    {
	this.treeGridModel = treeGridModel;
    }

    public String getAccessRights()
    {
	return accessRights;
    }

    public void setAccessRights(String accessRights)
    {
	this.accessRights = accessRights;
    }

    public String getDisableEditableFocus()
    {
	return disableEditableFocus;
    }

    public void setDisableEditableFocus(String disableEditableFocus)
    {
	this.disableEditableFocus = disableEditableFocus;
    }

    /**
     * @return the subGridOptions
     */
    public String getSubGridOptions()
    {
	return subGridOptions;
    }

    /**
     * @param subGridOptions the subGridOptions to set
     */
    public void setSubGridOptions(String subGridOptions)
    {
	this.subGridOptions = subGridOptions;
    }

    public String getForceNavAdd()
    {
	return forceNavAdd;
    }

    public void setForceNavAdd(String forceNavAdd)
    {
	this.forceNavAdd = forceNavAdd;
    }

    public String getForceNavDelete()
    {
	return forceNavDelete;
    }

    public void setForceNavDelete(String forceNavDelete)
    {
	this.forceNavDelete = forceNavDelete;
    }

    /**
     * @return the expandColumn
     */
    public String getExpandColumn()
    {
	return expandColumn;
    }

    /**
     * @param expandColumn the expandColumn to set
     */
    public void setExpandColumn(String expandColumn)
    {
	this.expandColumn = expandColumn;
    }

    public String getSerializeGridData()
    {
	return serializeGridData;
    }

    public void setSerializeGridData(String serializeGridData)
    {
	this.serializeGridData = serializeGridData;
    }

    /**
     * @param columnsOrder the columnsOrder to set
     */
    public void setColumnsOrder(String columnsOrder)
    {
        this.columnsOrder = columnsOrder;
    }

    /**
     * @return the exportExcel
     */
    public String getExportExcel()
    {
        return exportExcel;
    }

    /**
     * @param exportExcel the exportExcel to set
     */
    public void setExportExcel(String exportExcel)
    {
        this.exportExcel = exportExcel;
    }

    public String getMultiSort()
    {
        return multiSort;
    }

    public void setMultiSort(String multiSort)
    {
        this.multiSort = multiSort;
    }

    public String getDragLockRowColor() {
	return dragLockRowColor; 
    }

    public void setDragLockRowColor(String dragLockRowColor) {
	this.dragLockRowColor = dragLockRowColor;
    }

    public String getDragLockColName() {
	return dragLockColName;
    }

    public void setDragLockColName(String dragLockColName) {
	this.dragLockColName = dragLockColName;
    }

    public String getDragLockColVal() {
	return dragLockColVal;
    }

    public void setDragLockColVal(String dragLockColVal) {
	this.dragLockColVal = dragLockColVal;
    }

    public String getFromCustomization()
    {
        return fromCustomization;
    }

    public void setFromCustomization(String fromCustomization)
    {
        this.fromCustomization = fromCustomization;
    }

    public String getRowColorCssColumn()
    {
        return rowColorCssColumn;
    }

    public void setRowColorCssColumn(String rowColorCssColumn)
    {
        this.rowColorCssColumn = rowColorCssColumn;
    }    
    
    /**
     * @return the dontLoadData
     */
    public String getDontLoadData()
    {
        return dontLoadData;
    }

    /**
     * @param dontLoadData the dontLoadData to set
     */
    public void setDontLoadData(String dontLoadData)
    {
        this.dontLoadData = dontLoadData;
    }

    public String getHasDefaultValueOnAddRow() 
    {
    	return hasDefaultValueOnAddRow;
    }
    
    public void setHasDefaultValueOnAddRow(String hasDefaultValueOnAddRow) 
    {
    	this.hasDefaultValueOnAddRow = hasDefaultValueOnAddRow;
    }
    
    /**
     * @return the customBtnData
     */
    public String getCustomBtnData()
    {
        return customBtnData;
    }

    /**
     * @param customBtnData the customBtnData to set
     */
    public void setCustomBtnData(String customBtnData)
    {
        this.customBtnData = customBtnData;
    }
    
}
