package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

public class PathTextEditorTag extends AbstractUITag{

	private String id;
	private String width;
	private String height;
	private String required;
	private String readonly;
	
	
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new PathTextEditor(stack, req, res);
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	

	/* (non-Javadoc)
	 * @see org.apache.struts2.views.jsp.ui.AbstractUITag#populateParams()
	 */
	@Override
	protected void populateParams() {
		// TODO Auto-generated method stub
		super.populateParams();
		PathTextEditor te = (PathTextEditor)component;
		te.setId(id);
		te.setWidth(width);
		te.setHeight(height);
		te.setRequired(required);
		te.setReadonly(readonly);
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
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

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}
	
	
}