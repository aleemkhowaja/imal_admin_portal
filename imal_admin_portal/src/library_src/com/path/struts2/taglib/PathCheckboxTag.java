package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.CheckboxTag;

import com.opensymphony.xwork2.util.ValueStack;


/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: DeniskHaddad
 *
 * PathCheckboxTag.java used to overwrite Struts Checkbox Tag
 */
public class PathCheckboxTag extends CheckboxTag 
{
    private String dependency, dependencySrc, parameter,afterDepEvent;
    private String overrideLabelText;
    private String allowDefValCust;
    private String valOpt;
    
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new PathCheckbox(stack, req, res);
    }

    protected void populateParams()
    {
	super.populateParams();
	
	PathCheckbox checkbox = (PathCheckbox)component;
	checkbox.setDependency(dependency);
	checkbox.setDependencySrc(dependencySrc);
	checkbox.setParameter(parameter);
	checkbox.setAfterDepEvent(afterDepEvent);
	checkbox.setOverrideLabelText(overrideLabelText);
	checkbox.setValOpt(valOpt);
	checkbox.setAllowDefValCust(allowDefValCust); 
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


    public void setAfterDepEvent(String afterDepEvent)
    {
        this.afterDepEvent = afterDepEvent;
    }

    public void setOverrideLabelText(String overrideLabelText)
    {
        this.overrideLabelText = overrideLabelText;
    }

    public void setValOpt(String valOpt)
    {
        this.valOpt = valOpt;
    }

    /**
     * @param allowDefValCust the allowDefValCust to set
     */
    public void setAllowDefValCust(String allowDefValCust)
    {
        this.allowDefValCust = allowDefValCust;
    }
}
