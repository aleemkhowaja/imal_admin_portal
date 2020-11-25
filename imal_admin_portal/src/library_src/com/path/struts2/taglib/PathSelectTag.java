package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.SelectTag;

import com.opensymphony.xwork2.util.ValueStack;

public class PathSelectTag extends SelectTag
{
    private String dependency, dependencySrc, parameter ,afterDepEvent,beforeDepEvent;
    private String overrideLabelText;
    private String considerChoiceValue;
    private String dynValue;
    private String required;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
	return new PathSelect(stack, req, res);
    }

    protected void populateParams()
    {
	super.populateParams();
	PathSelect select = ((PathSelect) component);
	select.setDependency(dependency);
	select.setDependencySrc(dependencySrc);
	select.setParameter(parameter);
	select.setAfterDepEvent(afterDepEvent);
	select.setOverrideLabelText(overrideLabelText);
	select.setBeforeDepEvent(beforeDepEvent);
	select.setConsiderChoiceValue(considerChoiceValue);
	select.setDynValue(dynValue);
	select.setRequired(required);
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

    public void setOverrideLabelText(String overrideLabelText)
    {
        this.overrideLabelText = overrideLabelText;
    }

    public void setAfterDepEvent(String afterDepEvent)
    {
        this.afterDepEvent = afterDepEvent;
    }

    public void setBeforeDepEvent(String beforeDepEvent)
    {
        this.beforeDepEvent = beforeDepEvent;
    }

    /**
     * @return the considerChoiceValue
     */
    public String getConsiderChoiceValue()
    {
        return considerChoiceValue;
    }

    /**
     * @param considerChoiceValue the considerChoiceValue to set
     */
    public void setConsiderChoiceValue(String considerChoiceValue)
    {
        this.considerChoiceValue = considerChoiceValue;
    }

    /**
     * @return the dynValue
     */
    public String getDynValue()
    {
        return dynValue;
    }

    /**
     * @param dynValue the dynValue to set
     */
    public void setDynValue(String dynValue)
    {
        this.dynValue = dynValue;
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
