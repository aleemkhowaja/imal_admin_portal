package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.LabelTag;

import com.opensymphony.xwork2.util.ValueStack;
/**
 * 
 * Copyright 2011, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: george
 *
 * PathLabelTag.java used to write the property key to the tag for Audit purpose.
 */
public class PathLabelTag extends LabelTag
{
	private String labelKeyCode;
	 private String required;

    public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
	return new PathLabel(stack, req, res);
    }
    
    protected void populateParams()
    {
	super.populateParams();
	PathLabel label = ((PathLabel) component);
	label.setLabelKeyCode(labelKeyCode);
	label.setRequired(required);
    }
    
	public String getLabelKeyCode() {
		return labelKeyCode;
	}
	public void setLabelKeyCode(String labelKeyCode) {
		this.labelKeyCode = labelKeyCode;
	}
}
