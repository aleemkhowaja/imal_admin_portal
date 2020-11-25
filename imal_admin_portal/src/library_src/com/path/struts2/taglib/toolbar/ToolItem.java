package com.path.struts2.taglib.toolbar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;

import com.opensymphony.xwork2.util.ValueStack;

public class ToolItem extends ClosingUIBean {

	public static final String OPEN_TEMPLATE = "path-toolitem";
	public static final String PATH_TEMPLATE = "path-toolitem-close";
	public static final String PATH_THEME = "path-xhtml";
	

	private String id;
	private String icon;
	private String actionName;

	public ToolItem(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	@Override
	public void setTheme(String theme) {
		super.setTheme(PATH_THEME);
	}

	@Override
	protected String getDefaultTemplate() {
		return PATH_TEMPLATE;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getDefaultOpenTemplate() {
		// TODO Auto-generated method stub
		return OPEN_TEMPLATE;
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
