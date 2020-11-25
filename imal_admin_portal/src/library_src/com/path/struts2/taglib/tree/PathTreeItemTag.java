package com.path.struts2.taglib.tree;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.views.jsp.ui.AbstractRemoteTag;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>PathTreeItemTag.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
@SuppressWarnings("serial")
public class PathTreeItemTag extends AbstractRemoteTag
{
    protected String title;
    protected String type;

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	return new PathTreeItem(stack, request, response);
    }

    @Override
    protected void populateParams()
    {
	super.populateParams();

	PathTreeItem treeItem = (PathTreeItem) component;
	treeItem.setTitle(title);
	treeItem.setType(type);
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
	return title;
    }

    /**
     * @param title the title to set
     */
    @Override
    public void setTitle(String title)
    {
	this.title = title;
    }

    /**
     * @return the type
     */
    public String getType()
    {
	return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
	this.type = type;
    }

}
