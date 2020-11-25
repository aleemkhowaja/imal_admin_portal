package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.views.jsp.ui.DatePickerTag;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.struts2.lib.common.RootUtil;


public class PathDatePickerTag extends DatePickerTag {

    private String dependency, dependencySrc, parameter,afterDepEvent,beforeDepEvent;
    private String overrideLabelText;
    private String showHijri;
    private String showOnlyHijri;
    private String dateLabelsKeys;
    private String required;
    
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
      return new PathDatePicker(stack, req, res);
    }
    
	protected void populateParams() {
		super.populateParams();

		PathDatePicker datePicker = (PathDatePicker) component;
		if(displayFormat == null)
		{
		    datePicker.setDisplayFormat(RootUtil.returnDateMask(pageContext.getSession()));
		}
		datePicker.setDependency(dependency);
		datePicker.setDependencySrc(dependencySrc);
		datePicker.setParameter(parameter);
		datePicker.setOverrideLabelText(overrideLabelText);
		datePicker.setAfterDepEvent(afterDepEvent);
		datePicker.setBeforeDepEvent(beforeDepEvent);
		datePicker.setShowHijri(showHijri);
		datePicker.setShowOnlyHijri(showOnlyHijri);
		datePicker.setDateLabelsKeys(dateLabelsKeys);		
		datePicker.setRequired(required);
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
	 * @param showHijri the showHijri to set
	 */
	public void setShowHijri(String showHijri)
	{
	    this.showHijri = showHijri;
	}

	/**
	 * @param showOnlyHijri the showOnlyHijri to set
	 */
	public void setShowOnlyHijri(String showOnlyHijri)
	{
	    this.showOnlyHijri = showOnlyHijri;
	}

	/**
	 * @param dateLabelsKeys the dateLabelsKeys to set
	 */
	public void setDateLabelsKeys(String dateLabelsKeys)
	{
	    this.dateLabelsKeys = dateLabelsKeys;
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
