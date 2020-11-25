package com.path.struts2.taglib.toolbar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.opensymphony.xwork2.util.ValueStack;

public class ToolItemTagSupport extends AbstractClosingTag {

	private String id;
	private String icon;
	private String actionName;

	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new ToolItem(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();
		ToolItem tItem = (ToolItem) component;
		tItem.setId(id);
		tItem.setIcon(icon);
		tItem.setActionName(actionName);

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcon() {
		return icon;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionName() {
		return actionName;
	}

	 

}
