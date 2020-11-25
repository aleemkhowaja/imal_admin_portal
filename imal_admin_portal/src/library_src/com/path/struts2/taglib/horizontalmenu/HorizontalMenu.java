package com.path.struts2.taglib.horizontalmenu;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;

import com.opensymphony.xwork2.util.ValueStack;
import com.path.lib.vo.MenuVO;

public class HorizontalMenu extends UIBean// Component
{
	public static final String PATH_TEMPLATE = "path-horizontalmenu";
	public static final String PATH_THEME = "path-xhtml";
	
	private Collection<MenuVO> menuData;
	
	private String id;
	private String actionName;
	private String collapseprev;
	private String targetName;
	private String scrollSize;
	private String targetLoadAction;

	

	public String getTargetLoadAction() {
		return targetLoadAction;
	}


	public void setTargetLoadAction(String targetLoadAction) {
		this.targetLoadAction = targetLoadAction;
	}


	public String getScrollSize() {
		return scrollSize;
	}


	public void setScrollSize(String scrollSize) {
		this.scrollSize = scrollSize;
	}


	public HorizontalMenu(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
	{
		super(stack, request, response);
	}
	

	@Override
	public void evaluateExtraParams()
	{
		super.evaluateExtraParams();
		if (id != null) 
		{
		      addParameter("id", findString(id));
		}
		if (actionName != null) 
		{
		    addParameter("actionName", findString(actionName));
		}
		if (menuData != null)
		{
		    addParameter("menuData", menuData);
		}
		if (collapseprev != null)
		{
		    addParameter("collapseprev", collapseprev);
		}
		if (targetName != null)
		{
		    addParameter("targetName", targetName);
		}
		if (scrollSize != null)
		{
		    addParameter("scrollSize", scrollSize);
		}
		if (targetLoadAction != null)
		{
		    addParameter("targetLoadAction", targetLoadAction);
		}
	}


	@Override
	public void setTheme(String theme)
	{
		super.setTheme(PATH_THEME);
	}

	@Override
	protected String getDefaultTemplate()
	{
		return PATH_TEMPLATE;
	}

	@Override
	public String getId()
	{
		return id;
	}

	@Override
	public void setId(String id)
	{
		this.id = id;
	}

	public String getActionName()
	{
		return actionName;
	}

	public void setActionName(String actionName)
	{
		this.actionName = actionName;
	}

	public String getCollapseprev()
	{
		return collapseprev;
	}

	public void setCollapseprev(String collapseprev)
	{
		this.collapseprev = collapseprev;
	}

	public String getTargetName()
	{
		return targetName;
	}

	public void setTargetName(String targetName)
	{
		this.targetName = targetName;
	}


	public Collection<MenuVO> getMenuData()
	{
		return menuData;
	}


	public void setMenuData(Collection<MenuVO> menuData)
	{
		this.menuData = menuData;
	}



}