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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.grid.views.jsp.ui.GridTag;
import com.opensymphony.xwork2.util.ValueStack;

public class PathGridTag extends GridTag
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
    protected String columnsOrder;
    protected String exportExcel;
    protected String multiSort;
    protected String dragLockRowColor;
    protected String dragLockColName;
    protected String dragLockColVal;
    protected String rowColorCssColumn;
    protected String dontLoadData;
    protected String hasDefaultValueOnAddRow;
 
    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
	return new PathGrid(stack, req, res);
    }

    @Override
    protected void populateParams()
    {
	super.populateParams();

	PathGrid grid = (PathGrid) component;
	grid.setAccessRights(accessRights);
	grid.setSecurityRef(securityRef);
	grid.setMultiHeader(multiHeader);
	grid.setAddfunc(addfunc);
	grid.setEditfunc(editfunc);
	grid.setDelfunc(delfunc);
	grid.setViewfunc(viewfunc);	
	grid.setTreeGrid(treeGrid);
	grid.setExpandColumn(expandColumn);
	grid.setTreeGridModel(treeGridModel);
	grid.setDisableEditableFocus(disableEditableFocus);
	grid.setSubGridOptions(subGridOptions);
	grid.setForceNavAdd(forceNavAdd);
	grid.setForceNavDelete(forceNavDelete);
	grid.setSerializeGridData(serializeGridData);
	grid.setColumnsOrder(columnsOrder);
	grid.setExportExcel(exportExcel);
	grid.setMultiSort(multiSort);
	grid.setDragLockRowColor(dragLockRowColor);
	grid.setDragLockColName(dragLockColName);
	grid.setDragLockColVal(dragLockColVal);
	grid.setRowColorCssColumn(rowColorCssColumn);
	grid.setDontLoadData(dontLoadData);
	grid.setHasDefaultValueOnAddRow(hasDefaultValueOnAddRow);
	
    }

    public void setSecurityRef(String securityRef)
    {
	this.securityRef = securityRef;
    }

    public void setMultiHeader(String multiHeader)
    {
	this.multiHeader = multiHeader;
    }
    

    public void setAddfunc(String addfunc)
    {
        this.addfunc = addfunc;
    }

    public void setEditfunc(String editfunc)
    {
        this.editfunc = editfunc;
    }

    public void setDelfunc(String delfunc)
    {
        this.delfunc = delfunc;
    }

    public void setViewfunc(String viewfunc)
    {
        this.viewfunc = viewfunc;
    }

	public void setTreeGrid(String treeGrid)
	{
		this.treeGrid = treeGrid;
	}

	public void setTreeGridModel(String treeGridModel)
	{
		this.treeGridModel = treeGridModel;
	}

	public void setAccessRights(String accessRights)
	{
	    this.accessRights = accessRights;
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
	
	public void setForceNavAdd(String forceNavAdd)
	{
	    this.forceNavAdd = forceNavAdd;
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

	public void setSerializeGridData(String serializeGridData)
	{
	    this.serializeGridData = serializeGridData;
	}

	/**
	 * @param remapColumns the remapColumns to set
	 */
	public void setColumnsOrder(String columnsOrder)
	{
	    this.columnsOrder = columnsOrder;
	}

	public void setExportExcel(String exportExcel)
	{
	    this.exportExcel = exportExcel;
	}

	public void setMultiSort(String multiSort)
	{
	    this.multiSort = multiSort;
	}
	public void setDragLockRowColor(String dragLockRowColor) {
		this.dragLockRowColor = dragLockRowColor;
	}

	public void setDragLockColName(String dragLockColName) {
		this.dragLockColName = dragLockColName;
	}

	public void setDragLockColVal(String dragLockColVal) {
		this.dragLockColVal = dragLockColVal;
	}

	public void setRowColorCssColumn(String rowColorCssColumn)
	{
	    this.rowColorCssColumn = rowColorCssColumn;
	}
	/**
	 * @param dontLoadData the dontLoadData to set
	 */
	public void setDontLoadData(String dontLoadData)
	{
	    this.dontLoadData = dontLoadData;
	}
	
	public void setHasDefaultValueOnAddRow(String hasDefaultValueOnAddRow) 
	{
	    this.hasDefaultValueOnAddRow = hasDefaultValueOnAddRow;
	}
	
}
