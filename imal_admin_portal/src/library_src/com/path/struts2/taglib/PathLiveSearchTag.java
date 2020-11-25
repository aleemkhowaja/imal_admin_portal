package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

public class PathLiveSearchTag extends AbstractUITag
{// DialogTag

    /**
     * Specify the action name of Action Class(Implementer should define the
     * class) which needs to get invoked while clicking the lookup button of the
     * dialog.
     * 
     */
    private String actionName;

    /**
     * Using for where clause parameters (ColumnName:ComponentId) Column Name =
     * DbColumnName and ComponentId = Id of the component(ie, textfield,textarea
     * etc...)
     */
    private String paramList;

    /**
     * Using for setting the data (Once the record is selected in the grid and
     * clicks OK button of the lookup component) into corresponding components
     * like textfield,textarea,etc...(ColumnName:Component Id) Column Name = The
     * column name (column header) Component Id = The id of the component in
     * which the value get set.
     */
    private String resultList;
    /**
     * Name of the function which needs to call while clicking OK button of the
     * dialog (The implementer should write the function). If no functions
     * specified then the component will take the value of outputparam and fill
     * the content automatically
     */
    private String onOk;

    /**
     * Name of the function which needs to call while clicking CANCEL button of
     * the dialog (The implementer should write the function). If no functions
     * specified then the component will take the value of outputparam and fill
     * the content automatically
     */
    private String onCancel;

    private String searchElement;

    /**
     * The auto search element by default it is off.If it is true then it will
     * open the search window directly once clicks on the text field
     */
    private String autoSearch = "false";
    private String multiSelect = "false";
    private String selectColumn;
    private String afterDepEvent;
    private String beforeDepEvent;
    private String mode;
    protected String size;
    protected String maxlength;
    protected String minValue;
    protected String maxValue;
    private String leadZeros;

    private String dependency, dependencySrc, parameter, readOnlyMode;

    private String overrideLabelText;
    private String relatedDescElt;
    private String tabindex;
    private String reConstruct;
    private String allowDefValCust;
    private String multiResultInput; //input Id of the hidden element that will store the multiselect values as JSON string 
    
    private String required;
    protected String dontLoadData;//TP 887297 dont Load Data for livesearch feature
    
    @Override
    public Component getBean(ValueStack valueStack, HttpServletRequest request, HttpServletResponse response)
    {
	return new PathLiveSearch(valueStack, request, response);
    }

    @Override
    protected void populateParams()
    {
	// TODO Auto-generated method stub
	super.populateParams();
	PathLiveSearch pliveSearch = ((PathLiveSearch) component);
	pliveSearch.setActionName(actionName);
	pliveSearch.setParamList(paramList);
	pliveSearch.setResultList(resultList);
	pliveSearch.setOnOk(onOk);
	pliveSearch.setOnCancel(onCancel);
	pliveSearch.setSearchElement(searchElement);
	pliveSearch.setAutoSearch(autoSearch);
	pliveSearch.setMultiSelect(multiSelect);
	pliveSearch.setSelectColumn(selectColumn);
	pliveSearch.setDependency(dependency);
	pliveSearch.setDependencySrc(dependencySrc);
	pliveSearch.setParameter(parameter);
	pliveSearch.setReadOnlyMode(readOnlyMode);
	pliveSearch.setAfterDepEvent(afterDepEvent);
	pliveSearch.setBeforeDepEvent(beforeDepEvent);
	pliveSearch.setMode(mode);
	pliveSearch.setMaxlength(maxlength);
	pliveSearch.setSize(size);
	pliveSearch.setMinValue(minValue);
	pliveSearch.setMaxValue(maxValue);
	pliveSearch.setLeadZeros(leadZeros);
	pliveSearch.setOverrideLabelText(overrideLabelText);
	pliveSearch.setRelatedDescElt(relatedDescElt);
	pliveSearch.setTabindex(tabindex);
	pliveSearch.setReConstruct(reConstruct);
	pliveSearch.setAllowDefValCust(allowDefValCust);
	pliveSearch.setMultiResultInput(multiResultInput);
	pliveSearch.setRequired(required);
	pliveSearch.setDontLoadData(dontLoadData);

    }

    /**
     * Get the param list
     * 
     * @return
     */
    public String getParamList()
    {
	return paramList;
    }

    /**
     * Set the param list
     * 
     * @param keylist
     */
    public void setParamList(String keyList)
    {
	this.paramList = keyList;
    }

    /**
     * Get the result list
     * 
     * @return
     */
    public String getResultList()
    {
	return resultList;
    }

    /**
     * Set the result list
     * 
     * @param resultlist
     */
    public void setResultList(String resultList)
    {
	this.resultList = resultList;
    }

    /**
     * Get the ok button value
     * 
     * @return
     */
    public String getOnOk()
    {
	return onOk;
    }

    /**
     * Set the ok button value
     * 
     * @param onok
     */
    public void setOnOk(String onOk)
    {
	this.onOk = onOk;
    }

    /**
     * get the cancel button value
     * 
     * @return
     */
    public String getOnCancel()
    {
	return onCancel;
    }

    /**
     * Set the cancel button value
     * 
     * @param oncancel
     */
    public void setOnCancel(String onCancel)
    {
	this.onCancel = onCancel;
    }

    /**
     * Get the action name.
     * 
     * @return
     */
    public String getActionName()
    {
	return actionName;
    }

    /**
     * Set the action name
     * 
     * @param actionName
     */
    public void setActionName(String actionName)
    {
	this.actionName = actionName;
    }

    /**
     * Gets the search column
     * 
     * @return
     */
    public String getSearchElement()
    {
	return searchElement;
    }

    /**
     * Set the search column
     * 
     * @param searchElement
     */
    public void setSearchElement(String searchElement)
    {
	this.searchElement = searchElement;
    }

    /**
     * Get the auto search element
     * 
     * @return autoSearch
     */
    public String getAutoSearch()
    {
	return autoSearch;
    }

    /**
     * Sets the auto Search element
     * 
     * @param autoSearch
     */
    public void setAutoSearch(String autoSearch)
    {
	this.autoSearch = autoSearch;
    }

    public String getMultiSelect()
    {
	return multiSelect;
    }

    public void setMultiSelect(String multiSelect)
    {
	this.multiSelect = multiSelect;
    }

    public String getSelectColumn()
    {
	return selectColumn;
    }

    public void setSelectColumn(String selectColumn)
    {
	this.selectColumn = selectColumn;
    }

    public void setDependency(String dependency)
    {
	this.dependency = dependency;
    }

    public void setDependencySrc(String dependencySrc)
    {
	this.dependencySrc = dependencySrc;
    }

    public void setParameter(String parameter)
    {
	this.parameter = parameter;
    }

    public String getDependency()
    {
	return dependency;
    }

    public String getDependencySrc()
    {
	return dependencySrc;
    }

    public String getParameter()
    {
	return parameter;
    }

    public String getReadOnlyMode()
    {
	return readOnlyMode;
    }

    public void setReadOnlyMode(String readOnlyMode)
    {
	this.readOnlyMode = readOnlyMode;
    }

    public void setAfterDepEvent(String afterDepEvent)
    {
	this.afterDepEvent = afterDepEvent;
    }

    public void setMode(String mode)
    {
	this.mode = mode;
    }

    public void setSize(String size)
    {
	this.size = size;
    }

    public void setMaxlength(String maxlength)
    {
	this.maxlength = maxlength;
    }

    public void setMinValue(String minValue)
    {
	this.minValue = minValue;
    }

    public void setMaxValue(String maxValue)
    {
	this.maxValue = maxValue;
    }

    public void setLeadZeros(String leadZeros)
    {
	this.leadZeros = leadZeros;
    }

    public void setOverrideLabelText(String overrideLabelText)
    {
	this.overrideLabelText = overrideLabelText;
    }

    public void setBeforeDepEvent(String beforeDepEvent)
    {
        this.beforeDepEvent = beforeDepEvent;
    }

    public void setRelatedDescElt(String relatedDescElt)
    {
        this.relatedDescElt = relatedDescElt;
    }

    @Override
    public void setTabindex(String tabindex)
    {
        this.tabindex = tabindex;
    }

    /**
     * @return the reConstruct
     */
    public String getReConstruct()
    {
        return reConstruct;
    }

    /**
     * @param reConstruct the reConstruct to set
     */
    public void setReConstruct(String reConstruct)
    {
        this.reConstruct = reConstruct;
    }
        
    /**
     * 
     * @param allowDefValCust
     */
    public void setAllowDefValCust(String allowDefValCust)
    {
        this.allowDefValCust = allowDefValCust;
    }
    
    public void setMultiResultInput(String multiResultInput)
    {
        this.multiResultInput = multiResultInput;
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
     * @param dontLoadData the dontLoadData to set
     */
    public void setDontLoadData(String dontLoadData)
    {
	this.dontLoadData = dontLoadData;
    }
    
}
