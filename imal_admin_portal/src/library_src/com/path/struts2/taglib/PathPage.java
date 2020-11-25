package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.ConstantsCommon;
import com.path.struts2.lib.common.base.BaseAction;
/**
 * 
 * Copyright 2011, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: george
 *
 * PathPage.java used to add hidden attribute _pageRef to the jsp page * 
 * 
 */
public class PathPage extends UIBean
{

    private String ref;
    public static final String PATH_TEMPLATE = "page-attributes";
    public static final String PATH_THEME = "path-xhtml";

    public PathPage(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
	// TODO Auto-generated constructor stub
    }

    @Override
    protected String getDefaultTemplate()
    {
	// TODO Auto-generated method stub
	return PATH_TEMPLATE;
    }
    /**
     * 
     * @param ref
     * If the action mode is in READ_MODE then the pageRef will be set to the Action for Audit purpose 
     */
    public void setRef(String ref)
    {
	this.ref = ref;
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	if(ConstantsCommon.READ_MODE.equals(baseAction.getAuditMode()))
	{
	    baseAction.set_pageRef(ref);
	}
    }

    public String getRef()
    {
	return ref;
    }

}
