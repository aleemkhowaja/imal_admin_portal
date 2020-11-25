package com.path.struts2.taglib.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("serial")
public class AccordionMenuTagSupport extends AbstractUITag {
	
	String actionName;
	String collapseprev;
	String targetName;
	String appName;
	
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
	  {
	    return new AccordionMenu(stack, req, res);
	  }

	  protected void populateParams()
	  {
	    super.populateParams();
	    AccordionMenu gc = (AccordionMenu) component;
	    gc.setId(id);
	    gc.setActionName(actionName);
	    gc.setCollapseprev(collapseprev);
	    gc.setTargetName(targetName);
	    gc.setAppName(appName);
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

	public void setAppName(String appName)
	{
	    this.appName = appName;
	}


	


}
