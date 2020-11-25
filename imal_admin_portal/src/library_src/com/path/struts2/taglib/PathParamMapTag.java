package com.path.struts2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          PathParamMapTag.java used to pass a map of parameter to a struts url
 *          tag
 */
public class PathParamMapTag extends ComponentTagSupport
{

    private static final long serialVersionUID = 1L;
    private String map;

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
    {
	return new PathParamMap(stack);
    }

    @Override
    protected void populateParams()
    {
	super.populateParams();
	PathParamMap param = (PathParamMap) component;
	param.setMap(map);
    }

    public void setMap(String map)
    {
	this.map = map;
    }

}