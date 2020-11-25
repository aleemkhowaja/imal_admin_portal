package com.path.struts2.taglib.horizontalmenu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

public class HorizontalMenuTagSupport extends AbstractUITag {
	
	String actionName;
	String collapseprev;
	String targetName;
	String scrollSize;
	String targetLoadAction;
	
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

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
	  {
	    return new HorizontalMenu(stack, req, res);
	  }

	  protected void populateParams()
	  {
	    super.populateParams();
	    HorizontalMenu gc = (HorizontalMenu) component;
	    gc.setId(id);
	    gc.setActionName(actionName);
	    gc.setCollapseprev(collapseprev);
	    gc.setTargetName(targetName);
	    gc.setScrollSize(scrollSize);
	    gc.setTargetLoadAction(targetLoadAction);	    
	  }

//	public String getId()
//	{
//		return id;
//	}
//
//	public void setId(String id)
//	{
//		this.id = id;
//	}
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


	


}
