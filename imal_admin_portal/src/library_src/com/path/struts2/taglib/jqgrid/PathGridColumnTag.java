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

import com.jgeppert.struts2.jquery.grid.components.GridColumn;
import com.jgeppert.struts2.jquery.grid.views.jsp.ui.GridColumnTag;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @see GridColumn
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public class PathGridColumnTag extends GridColumnTag
{

    protected String colType;
    protected String dependency;
    protected String dependencySrc;
    protected String params;
    protected String dialogOptions;
    protected String dialogUrl;
    protected String searchType; // number, integer. default string
    protected String searchRules; // required, number, minValue, maxValue,
				  // email, integer, date, time, url. ex:
				  // {"required":true, "number":true,
				  // "maxValue":13}

    protected String dataAction;
    protected String resultList;
    protected String autoSearch;
    protected String searchElement;
    protected String onOkMethod;
    protected String paramList;
    protected String frozen;
    protected String loadOnce;
    private String afterDepEvent;
    private String beforeDepEvent;
    protected String nbFormat;
    protected String leadZeros;
    protected String formatCol;
    protected String applyRounding; 
    protected String mode; 
    private String unformat;
    private String minValue; 
    private String maxValue;
    private String maxLenBeforeDec;
    private String maxDisplayLen;
    private String overrideRecReadOnly;
    private String reConstruct;
    private String multiSelect;
    private String multiResultInput;
    private String selectColumn;
    private String required;
    private String readOnlyMode;
    protected String dontLoadData;//TP 887297 dont Load Data for livesearch feature
    
    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
	return new PathGridColumn(stack, req, res);
    }

    @Override
    protected void populateParams()
    {
	super.populateParams();

	PathGridColumn gc = (PathGridColumn) component;
	gc.setColType(colType);
	gc.setDependency(dependency);
	gc.setDependencySrc(dependencySrc);
	gc.setParams(params);
	gc.setDialogOptions(dialogOptions);
	gc.setDialogUrl(dialogUrl);
	gc.setSearchType(searchType);
	gc.setSearchRules(searchRules);
	gc.setDataAction(dataAction);
	gc.setResultList(resultList);
	gc.setAutoSearch(autoSearch);
	gc.setSearchElement(searchElement);
	gc.setOnOkMethod(onOkMethod);
	gc.setFrozen(frozen);
	gc.setLoadOnce(loadOnce);
	gc.setParamList(paramList);
	gc.setAfterDepEvent(afterDepEvent);
	gc.setNbFormat(nbFormat);
	gc.setLeadZeros(leadZeros);
	gc.setFormatCol(formatCol);
	gc.setBeforeDepEvent(beforeDepEvent);
	gc.setApplyRounding(applyRounding);
	gc.setMode(mode);
	gc.setUnformat(unformat);
	gc.setMaxValue(maxValue);
	gc.setMinValue(minValue);
	gc.setMaxLenBeforeDec(maxLenBeforeDec);
	gc.setMaxDisplayLen(maxDisplayLen);
	gc.setOverrideRecReadOnly(overrideRecReadOnly);
	gc.setReConstruct(reConstruct);
	gc.setMultiSelect(multiSelect);
	gc.setMultiResultInput(multiResultInput);
	gc.setSelectColumn(selectColumn);
	gc.setRequired(required);
	gc.setReadOnlyMode(readOnlyMode);
	gc.setDontLoadData(dontLoadData);

    }

    public void setColType(String colType)
    {
	this.colType = colType;
    }

    public void setDependency(String dependency)
    {
	this.dependency = dependency;
    }

    public void setDependencySrc(String dependencySrc)
    {
	this.dependencySrc = dependencySrc;
    }

    public void setParams(String params)
    {
	this.params = params;
    }

    public void setDialogOptions(String dialogOptions)
    {
	this.dialogOptions = dialogOptions;
    }

    public void setDialogUrl(String dialogUrl)
    {
	this.dialogUrl = dialogUrl;
    }

    public void setSearchType(String searchType)
    {
	this.searchType = searchType;
    }

    public void setSearchRules(String searchRules)
    {
	this.searchRules = searchRules;
    }

    public void setDataAction(String dataAction)
    {
	this.dataAction = dataAction;
    }

    public void setResultList(String resultList)
    {
	this.resultList = resultList;
    }

    public void setAutoSearch(String autoSearch)
    {
	this.autoSearch = autoSearch;
    }

    public void setSearchElement(String searchElement)
    {
	this.searchElement = searchElement;
    }

    public void setOnOkMethod(String onOkMethod)
    {
	this.onOkMethod = onOkMethod;
    }

    public void setParamList(String paramList)
    {
	this.paramList = paramList;
    }

    public void setFrozen(String frozen)
    {
	this.frozen = frozen;
    }

    public void setLoadOnce(String loadOnce)
    {
	this.loadOnce = loadOnce;
    }

    public void setAfterDepEvent(String afterDepEvent)
    {
	this.afterDepEvent = afterDepEvent;
    }

    public void setNbFormat(String nbFormat)
    {
        this.nbFormat = nbFormat;
    }

    public void setLeadZeros(String leadZeros)
    {
        this.leadZeros = leadZeros;
    }
    public void setFormatCol(String formatCol)
    {
        this.formatCol = formatCol;
    }

    public void setBeforeDepEvent(String beforeDepEvent)
    {
        this.beforeDepEvent = beforeDepEvent;
    }

    public void setMaxValue(String maxValue)
    {
        this.maxValue = maxValue;
    }

    public void setApplyRounding(String applyRounding)
    {
        this.applyRounding = applyRounding;
    }

    public void setMode(String mode)
    {
        this.mode = mode;
    }

    public void setUnformat(String unformat)
    {
        this.unformat = unformat;
    }

    public void setMinValue(String minValue)
    {
        this.minValue = minValue;
    }

    public void setOverrideRecReadOnly(String overrideRecReadOnly)
    {
        this.overrideRecReadOnly = overrideRecReadOnly;
    }

    /**
     * @return the maxLenBeforeDec
     */
    public String getMaxLenBeforeDec()
    {
        return maxLenBeforeDec;
    }

    /**
     * @param maxLenBeforeDec the maxLenBeforeDec to set
     */
    public void setMaxLenBeforeDec(String maxLenBeforeDec)
    {
        this.maxLenBeforeDec = maxLenBeforeDec;
    }

    public void setReConstruct(String reConstruct)
    {
        this.reConstruct = reConstruct;
    }

    public void setMaxDisplayLen(String maxDisplayLen)
    {
        this.maxDisplayLen = maxDisplayLen;
    }

    /**
     * @param multiSelect the multiSelect to set
     */
    public void setMultiSelect(String multiSelect)
    {
        this.multiSelect = multiSelect;
    }

    /**
     * @param multiResultInput the multiResultInput to set
     */
    public void setMultiResultInput(String multiResultInput)
    {
        this.multiResultInput = multiResultInput;
    }

    /**
     * @param selectColumn the selectColumn to set
     */
    public void setSelectColumn(String selectColumn)
    {
        this.selectColumn = selectColumn;
    }

    /**
     * @return the required
     */
    public String getRequired()
    {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(String required)
    {
        this.required = required;
    }

    /**
     * @param readOnlyMode the readOnlyMode to set
     */
    public void setReadOnlyMode(String readOnlyMode)
    {
        this.readOnlyMode = readOnlyMode;
    }
    /**
     * @param dontLoadData the dontLoadData to set
     */
    public void setDontLoadData(String dontLoadData)
    {
	this.dontLoadData = dontLoadData;
    }
    
}
