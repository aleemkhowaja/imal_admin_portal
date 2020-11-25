package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Label;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;
/**
 * 
 * Copyright 2011, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: george
 *
 * PathLabel.java used to write the property key to the tag for Audit purpose.
 */
public class PathLabel extends Label
{
	private String labelKeyCode;
    private String required;


    public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public PathLabel(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void evaluateExtraParams()
    {
	super.evaluateExtraParams();
	String labelName = name;
	String labelKey = null;
	if(labelName == null)
	{
	    labelName = id;
	}
	SYS_PARAM_SCREEN_DISPLAYVO theVO = RootUtil.returnParamScreenDisplay(request, labelName, id,RootUtil.LABEL_ELEM_TYPE);
	if(theVO != null)
	{
	    if(!StringUtil.nullToEmpty(theVO.getLABEL_KEY()).isEmpty())
	    {
		BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
		value =  baseAction.getText(theVO.getLABEL_KEY());
		labelKey = theVO.getLabelKeyVal();
		addParameter("nameValue", findString(value));
	    }
	    if(theVO.getIS_VISIBLE() != null && theVO.getIS_VISIBLE().intValue() == 0)
	    {
		if(cssStyle == null || cssStyle.isEmpty())
		{
		    cssStyle = "";
		}
		else
		{
		    cssStyle += ";";
		}
		cssStyle += "display:none";
		addParameter("cssStyle", findString(cssStyle));
	    }
	}
	if(key != null)
	{
	    if( !StringUtil.nullToEmpty(labelKey).isEmpty())
	    {
		key = labelKey;
	    }
	    /** 
	     * to avoid the conflict in case of dynamic screen
	     * when the label is inside the element paramVO
	     * and the paramVO label equals 'name' or 'value'
	     * before this checking 
	     * the label will put the name/value of the constructed element as label value 
	     * in case the label is equal name/value
	     */
	    if(theVO==null && ("value".equalsIgnoreCase(name) || "name".equalsIgnoreCase(name) || "id".equalsIgnoreCase(name)))
	    {		
    	      addParameter("nameValue", findString(key));
	    }
	    if(StringUtil.isNotEmpty(labelKeyCode))
	    {
	    	dynamicAttributes.put("labelKey", labelKeyCode);
	    }
	    else
	    {
		    dynamicAttributes.put("labelKey", key);
	    }
	}

	if(StringUtil.isNotEmpty(required))
	{
	    addParameter("required", findValue(required, Boolean.class));
	}
    }

	public String getLabelKeyCode() {
		return labelKeyCode;
	}

	public void setLabelKeyCode(String labelKeyCode) {
		this.labelKeyCode = labelKeyCode;
	}
}
