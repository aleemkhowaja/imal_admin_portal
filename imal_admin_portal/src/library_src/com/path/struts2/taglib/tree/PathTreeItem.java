package com.path.struts2.taglib.tree;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.jgeppert.struts2.jquery.components.AbstractRemoteBean;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.struts2.lib.common.RootUtil;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>PathTreeItem.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
public class PathTreeItem extends AbstractRemoteBean
{

    public static final String TEMPLATE = "tree-item";
    public static final String TEMPLATE_CLOSE = "tree-item-close";
    public static final String THEME = "jquery";
    public static final String JQUERYACTION = "treeitem";
    
    private static final transient Random RANDOM = new Random();

    protected String title;
    protected String type;

    public PathTreeItem(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    @Override
    public String getDefaultOpenTemplate()
    {
	return TEMPLATE;
    }

    @Override
    protected String getDefaultTemplate()
    {
	return TEMPLATE_CLOSE;
    }

    @Override
    public void evaluateExtraParams()
    {
	super.evaluateExtraParams();
	
	addParameter("jqueryaction", JQUERYACTION);
	
	if(title != null)
	{
	    addParameter("title", findString(title));
	}
	if(type != null)
	{
	    addParameter("type", findString(type));
	}

	if((this.id == null || this.id.length() == 0))
	{
	    int nextInt = RANDOM.nextInt();
	    nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
	    this.id = "treeitem" + String.valueOf(nextInt);
	    addParameter("id", this.id);
	}

	PathTree parentTree = (PathTree) findAncestor(PathTree.class);
	if(parentTree != null)
	{
	    addParameter("tree", parentTree.getId());
	}

	PathTreeItem parentTreeItem = (PathTreeItem) findAncestor(PathTreeItem.class);
	if(parentTreeItem != null)
	{
	    addParameter("parentTreeItem", parentTreeItem.getId());
	}
	
	//escape id from special characters that might be used for security intrusion
	id =  RootUtil.escapeJS(id);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setTheme(String theme)
    {
	super.setTheme(theme);
    }

    @Override
    public String getTheme()
    {
	return THEME;
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
