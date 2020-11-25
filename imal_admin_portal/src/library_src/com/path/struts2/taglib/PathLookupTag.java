package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.views.jsp.ui.DialogTag;
import com.opensymphony.xwork2.util.ValueStack;

public class PathLookupTag extends DialogTag
{// DialogTag
    /**
     * Id of the lookup component.It should be unique.
     */
    private String id;
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

    /**
     * Auto open attribute is used to
     */
    private String autoOpen = "false";

    /**
     * Should the dialog be shown as a modal dialog or not
     */
    private String modal = "true";

    /**
     * The effects during closing the lookup dialog
     */
    private String hideEffect = "scale";

    /**
     * Set the width of the lookup dialog
     */
    private String width = "";

    /**
     * Set the height of the lookup dialog
     */
    private String height = "";
    
    private String readOnly;

    private String overrideLabelText;
    
    private String required;

    @Override
    public Component getBean(ValueStack valueStack, HttpServletRequest request, HttpServletResponse response)
    {
	return new PathLookup(valueStack, request, response);
    }

    @Override
    protected void populateParams()
    {
	// TODO Auto-generated method stub
	super.populateParams();
	PathLookup plookup = ((PathLookup) component);
	plookup.setId(id);
	plookup.setActionName(actionName);
	plookup.setParamList(paramList);
	plookup.setResultList(resultList);
	plookup.setOnOk(onOk);
	plookup.setOnCancel(onCancel);
	plookup.setAutoOpen(autoOpen);
	plookup.setModal(modal);
	plookup.setHideEffect(hideEffect);
	plookup.setWidth(width);
	plookup.setHeight(height);
	plookup.setReadOnly(readOnly);
	plookup.setOverrideLabelText(overrideLabelText);
	plookup.setRequired(required);
    }

    /**
     * Get the id
     */
    public String getId()
    {
	return id;
    }

    /**
     *Sets the id
     */
    public void setId(String id)
    {
	this.id = id;
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
     * Get the auto open property
     * 
     * @return
     */
    public String getAutoOpen()
    {
	return autoOpen;
    }

    /**
     * Set the autoOpen property
     * 
     * @param autoOpen
     */
    public void setAutoOpen(String autoOpen)
    {
	this.autoOpen = autoOpen;
    }

    /**
     * Get whether the lookup dialog is modal or not
     * 
     * @return
     */
    public String getModal()
    {
	return modal;
    }

    /**
     * Set the modal attribute
     * 
     * @param modal
     */
    public void setModal(String modal)
    {
	this.modal = modal;
    }

    /**
     * Get the value of hide effect property
     * 
     * @return
     */
    public String getHideEffect()
    {
	return hideEffect;
    }

    /**
     * Set the hide effect property of lookup dialog
     * 
     * @param hideEffect
     */
    public void setHideEffect(String hideEffect)
    {
	this.hideEffect = hideEffect;
    }

    /**
     * Get the width of lookup dialog
     * 
     * @return
     */
    public String getWidth()
    {
	return width;
    }

    /**
     * Set the width of lookup dialog
     * 
     * @param width
     */
    public void setWidth(String width)
    {
	this.width = width;
    }

    /**
     * Get the height of lookup dialog
     * 
     * @return
     */
    public String getHeight()
    {
	return height;
    }

    /**
     * Set the height of lookup dialog
     * 
     * @param height
     */
    public void setHeight(String height)
    {
	this.height = height;
    }

    public String getReadOnly()
    {
        return readOnly;
    }

    public void setReadOnly(String readOnly)
    {
        this.readOnly = readOnly;
    }

    public void setOverrideLabelText(String overrideLabelText)
    {
        this.overrideLabelText = overrideLabelText;
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
    
}
