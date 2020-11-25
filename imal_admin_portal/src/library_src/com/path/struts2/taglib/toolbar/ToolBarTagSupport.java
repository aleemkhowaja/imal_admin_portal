package com.path.struts2.taglib.toolbar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("serial")
public class ToolBarTagSupport extends AbstractClosingTag {

	private String id;
	private String width = "100%";  	//default value
	private String hideInAlert; 

	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new ToolBar(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();
		ToolBar tBar = (ToolBar) component;
		tBar.setId(id);
		tBar.setWidth(width);
		tBar.setHideInAlert(hideInAlert);
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getWidth() {
		return width;
	}

	public String getHideInAlert()
	{
	    return hideInAlert;
	}

	public void setHideInAlert(String hideInAlert)
	{
	    this.hideInAlert = hideInAlert;
	}
	
}
