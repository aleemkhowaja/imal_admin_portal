package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.TextFieldTag;

import com.opensymphony.xwork2.util.ValueStack;

public class PathBaseTag extends TextFieldTag
{
    private String dependency, dependencySrc, parameter;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
	return new PathTextField(stack, req, res);
    }

    protected void populateParams()
    {
	super.populateParams();

	PathTextField textField = ((PathTextField) component);
	textField.setDependency(dependency);
	textField.setDependencySrc(dependencySrc);
	textField.setParameter(parameter);
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

}
