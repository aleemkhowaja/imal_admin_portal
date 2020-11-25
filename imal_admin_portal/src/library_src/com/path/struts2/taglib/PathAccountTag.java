/**
 * 
 */
package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author MarwanMaddah
 * 
 */
public class PathAccountTag extends AbstractUITag
{
    private String inputIds;
    private String inputNames;
    private String additionalLabels;
    private String toolTipKeys;
    private String accountLabel;
    private String readOnly;
    private String leadZeros;
    private String rowLocation;
    private String colSpan;
    private String onchange;
    private String ondblclick;
    private String onblur;

    private String dependency;
    private String dependencySrc;
    private String afterDepEvent;
    private String beforeDepEvent;
    private String parameter;
    private String nbFormat;
    private String maxlen;

    private String mode;
    private String size;
    private String inputSizes;
    private String cssStyle;
    private String fromAccount;
    
    /**
     * 
     */
    private String actionName;
    private String paramList;
    private String resultList;
    private String onOk;
    private String onCancel;
    private String searchElement;
    private String multiSelect = "false";
    private String selectColumn;
    private String autoSearch = "false";
    private String validateAction;
    private String nameValues;
    private String inputsOrder;
    private String required;
    private String dontLoadData;//TP 887297 dont Load Data for livesearch feature
    /**
   * 
   */
    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
	return new PathAccount(stack, req, res);
    }

    /**
   * 
   */
    @Override
    public int doStartTag() throws JspException
    {
	int idsLength = inputIds.split("~").length;
	if(inputNames != null)
	{
	    int namesLength = inputNames.split("~").length;
	    if(namesLength != idsLength)
	    {
		throw new JspException("input name not compatible with inputs ids");
	    }
	}
	return super.doStartTag();
    }

    /**
   * 
   */
    @Override
    protected void populateParams()
    {
	super.populateParams();
	PathAccount gc = (PathAccount) component;

	gc.setInputIds(inputIds);
	gc.setInputNames(inputNames);
	gc.setAdditionalLabels(additionalLabels);
	gc.setToolTipKeys(toolTipKeys);
	gc.setAccountLabel(accountLabel);
	gc.setReadOnly(readOnly);
	gc.setLeadZeros(leadZeros);
	gc.setRowLocation(rowLocation);
	gc.setColSpan(colSpan);
	gc.setMode(mode);
	gc.setDependency(dependency);
	gc.setDependencySrc(dependencySrc);
	gc.setAfterDepEvent(afterDepEvent);
	gc.setBeforeDepEvent(beforeDepEvent);
	gc.setParameter(parameter);
	gc.setOnchange(onchange);
	gc.setOndblclick(ondblclick);
	gc.setOnblur(onblur);
	gc.setNbFormat(nbFormat);
	gc.setMaxlen(maxlen);

	gc.setInputSizes(inputSizes);
	gc.setSize(size);
	gc.setCssStyle(cssStyle);
	gc.setFromAccount(fromAccount);
        
	/**
         * the attributes related to liveSearch Management ...
         */
	gc.setActionName(actionName);
	gc.setParamList(paramList);
	gc.setResultList(resultList);
	gc.setOnOk(onOk);
	gc.setOnCancel(onCancel);
	gc.setSearchElement(searchElement);
	gc.setAutoSearch(autoSearch);
	gc.setMultiSelect(multiSelect);
	gc.setSelectColumn(selectColumn);
	gc.setValidateAction(validateAction);
	gc.setNameValues(nameValues);
	gc.setInputsOrder(inputsOrder);
	gc.setRequired(required);
	gc.setDontLoadData(dontLoadData);
    }

    /**
     * @return the inputIds
     */
    public String getInputIds()
    {
	return inputIds;
    }

    /**
     * @param inputIds the inputIds to set
     */
    public void setInputIds(String inputIds)
    {
	this.inputIds = inputIds;
    }

    /**
     * @return the leadZeros
     */
    public String getLeadZeros()
    {
	return leadZeros;
    }

    /**
     * @param leadZeros the leadZeros to set
     */
    public void setLeadZeros(String leadZeros)
    {
	this.leadZeros = leadZeros;
    }

    /**
     * @return the inputNames
     */
    public String getInputNames()
    {
	return inputNames;
    }

    /**
     * @param inputNames the inputNames to set
     */
    public void setInputNames(String inputNames)
    {
	this.inputNames = inputNames;
    }

    /**
     * @return the readOnly
     */
    public String getReadOnly()
    {
	return readOnly;
    }

    /**
     * @param readOnly the readOnly to set
     */
    public void setReadOnly(String readOnly)
    {
	this.readOnly = readOnly;
    }

    /**
     * @return the rowLocation
     */
    public String getRowLocation()
    {
	return rowLocation;
    }

    /**
     * @param rowLocation the rowLocation to set
     */
    public void setRowLocation(String rowLocation)
    {
	this.rowLocation = rowLocation;
    }

    /**
     * @return the colSpan
     */
    public String getColSpan()
    {
	return colSpan;
    }

    /**
     * @param colSpan the colSpan to set
     */
    public void setColSpan(String colSpan)
    {
	this.colSpan = colSpan;
    }

    /**
     * @return the onchange
     */
    public String getOnchange()
    {
	return onchange;
    }

    /**
     * @param onchange the onchange to set
     */
    @Override
    public void setOnchange(String onchange)
    {
	this.onchange = onchange;
    }

    /**
     * @return the dependency
     */
    public String getDependency()
    {
	return dependency;
    }

    /**
     * @param dependency the dependency to set
     */
    public void setDependency(String dependency)
    {
	this.dependency = dependency;
    }

    /**
     * @return the dependencySrc
     */
    public String getDependencySrc()
    {
	return dependencySrc;
    }

    /**
     * @param dependencySrc the dependencySrc to set
     */
    public void setDependencySrc(String dependencySrc)
    {
	this.dependencySrc = dependencySrc;
    }

    /**
     * @return the parameter
     */
    public String getParameter()
    {
	return parameter;
    }

    /**
     * @param parameter the parameter to set
     */
    public void setParameter(String parameter)
    {
	this.parameter = parameter;
    }

    /**
     * @return the ondblclick
     */
    public String getOndblclick()
    {
	return ondblclick;
    }

    /**
     * @param ondblclick the ondblclick to set
     */
    @Override
    public void setOndblclick(String ondblclick)
    {
	this.ondblclick = ondblclick;
    }

    /**
     * @return the nbFormat
     */
    public String getNbFormat()
    {
	return nbFormat;
    }

    /**
     * @param nbFormat the nbFormat to set
     */
    public void setNbFormat(String nbFormat)
    {
	this.nbFormat = nbFormat;
    }

    /**
     * @return the accountLabel
     */
    public String getAccountLabel()
    {
	return accountLabel;
    }

    /**
     * @param accountLabel the accountLabel to set
     */
    public void setAccountLabel(String accountLabel)
    {
	this.accountLabel = accountLabel;
    }

    /**
     * @return the size
     */
    public String getSize()
    {
	return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size)
    {
	this.size = size;
    }

    /**
     * @return the inputSizes
     */
    public String getInputSizes()
    {
	return inputSizes;
    }

    /**
     * @param inputSizes the inputSizes to set
     */
    public void setInputSizes(String inputSizes)
    {
	this.inputSizes = inputSizes;
    }

    /**
     * @return the fromAccount
     */
    public String getFromAccount()
    {
	return fromAccount;
    }

    /**
     * @param fromAccount the fromAccount to set
     */
    public void setFromAccount(String fromAccount)
    {
	this.fromAccount = fromAccount;
    }

    /**
     * @return the cssStyle
     */
    public String getCssStyle()
    {
	return cssStyle;
    }

    /**
     * @param cssStyle the cssStyle to set
     */
    @Override
    public void setCssStyle(String cssStyle)
    {
	this.cssStyle = cssStyle;
    }

    /**
     * @return the mode
     */
    public String getMode()
    {
	return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(String mode)
    {
	this.mode = mode;
    }

    /**
     * @return the actionName
     */
    public String getActionName()
    {
	return actionName;
    }

    /**
     * @param actionName the actionName to set
     */
    public void setActionName(String actionName)
    {
	this.actionName = actionName;
    }

    /**
     * @return the paramList
     */
    public String getParamList()
    {
	return paramList;
    }

    /**
     * @param paramList the paramList to set
     */
    public void setParamList(String paramList)
    {
	this.paramList = paramList;
    }

    /**
     * @return the resultList
     */
    public String getResultList()
    {
	return resultList;
    }

    /**
     * @param resultList the resultList to set
     */
    public void setResultList(String resultList)
    {
	this.resultList = resultList;
    }

    /**
     * @return the onOk
     */
    public String getOnOk()
    {
	return onOk;
    }

    /**
     * @param onOk the onOk to set
     */
    public void setOnOk(String onOk)
    {
	this.onOk = onOk;
    }

    /**
     * @return the onCancel
     */
    public String getOnCancel()
    {
	return onCancel;
    }

    /**
     * @param onCancel the onCancel to set
     */
    public void setOnCancel(String onCancel)
    {
	this.onCancel = onCancel;
    }

    /**
     * @return the searchElement
     */
    public String getSearchElement()
    {
	return searchElement;
    }

    /**
     * @param searchElement the searchElement to set
     */
    public void setSearchElement(String searchElement)
    {
	this.searchElement = searchElement;
    }

    /**
     * @return the multiSelect
     */
    public String getMultiSelect()
    {
	return multiSelect;
    }

    /**
     * @param multiSelect the multiSelect to set
     */
    public void setMultiSelect(String multiSelect)
    {
	this.multiSelect = multiSelect;
    }

    /**
     * @return the selectColumn
     */
    public String getSelectColumn()
    {
	return selectColumn;
    }

    /**
     * @param selectColumn the selectColumn to set
     */
    public void setSelectColumn(String selectColumn)
    {
	this.selectColumn = selectColumn;
    }

    /**
     * @return the autoSearch
     */
    public String getAutoSearch()
    {
	return autoSearch;
    }

    /**
     * @param autoSearch the autoSearch to set
     */
    public void setAutoSearch(String autoSearch)
    {
	this.autoSearch = autoSearch;
    }

    /**
     * @return the validateAction
     */
    public String getValidateAction()
    {
	return validateAction;
    }

    /**
     * @param validateAction the validateAction to set
     */
    public void setValidateAction(String validateAction)
    {
	this.validateAction = validateAction;
    }

    /**
     * @param nameValues the nameValues to set
     */
    public void setNameValues(String nameValues)
    {
        this.nameValues = nameValues;
    }

    /**
     * @return the onblur
     */
    public String getOnblur()
    {
        return onblur;
    }

    /**
     * @param onblur the onblur to set
     */
    @Override
    public void setOnblur(String onblur)
    {
        this.onblur = onblur;
    }

    public void setAfterDepEvent(String afterDepEvent)
    {
        this.afterDepEvent = afterDepEvent;
    }

    public String getToolTipKeys()
    {
        return toolTipKeys;
    }

    public void setToolTipKeys(String toolTipKeys)
    {
        this.toolTipKeys = toolTipKeys;
    }

    /**
     * @return the inputsOrder
     */
    public String getInputsOrder()
    {
        return inputsOrder;
    }

    /**
     * @param inputsOrder the inputsOrder to set
     */
    public void setInputsOrder(String inputsOrder)
    {
        this.inputsOrder = inputsOrder;
    }

    /**
     * @return the additionalLabels
     */
    public String getAdditionalLabels()
    {
        return additionalLabels;
    }

    /**
     * @param additionalLabels the additionalLabels to set
     */
    public void setAdditionalLabels(String additionalLabels)
    {
        this.additionalLabels = additionalLabels;
    }

    public String getMaxlen()
    {
        return maxlen;
    }

    public void setMaxlen(String maxlen)
    {
        this.maxlen = maxlen;
    }

    /**
     * @return the beforeDepEvent
     */
    public String getBeforeDepEvent()
    {
        return beforeDepEvent;
    }

    /**
     * @param beforeDepEvent the beforeDepEvent to set
     */
    public void setBeforeDepEvent(String beforeDepEvent)
    {
        this.beforeDepEvent = beforeDepEvent;
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
