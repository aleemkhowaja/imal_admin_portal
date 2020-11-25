package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.HeadTag;

import com.opensymphony.xwork2.util.ValueStack;

public class PathHeadTag extends HeadTag
{
    private String decoratorName;
    
	 public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
	        return new PathHead(stack, req, res);
	    }

	public void setDecoratorName(String decoratorName)
	{
	    this.decoratorName = decoratorName;
	}

	@Override
	protected void populateParams()
	{
	    // TODO Auto-generated method stub
	    super.populateParams();
	    PathHead ph = (PathHead )component;
	    ph.setDecoratorName(decoratorName);
	}
}
