package com.path.vo.common;

import com.path.lib.vo.BaseVO;

public class MainMenuVO extends BaseVO
{
    private static final long serialVersionUID = 1L;
    private String menuHeaderName;
    private String href;
    private String subHref;
    private String cssClass;
    private String list_id;

    public String getMenuHeaderName()
    {
	return menuHeaderName;
    }

    public void setMenuHeaderName(String menuHeaderName)
    {
	this.menuHeaderName = menuHeaderName;
    }

    public String getHref()
    {
	return href;
    }

    public void setHref(String href)
    {
	this.href = href;
    }

    public String getSubHref()
    {
	return subHref;
    }

    public void setSubHref(String subHref)
    {
	this.subHref = subHref;
    }

    public String getCssClass()
    {
	return cssClass;
    }

    public void setCssClass(String cssClass)
    {
	this.cssClass = cssClass;
    }

    public String getList_id()
    {
	return list_id;
    }

    public void setList_id(String listId)
    {
	list_id = listId;
    }
}