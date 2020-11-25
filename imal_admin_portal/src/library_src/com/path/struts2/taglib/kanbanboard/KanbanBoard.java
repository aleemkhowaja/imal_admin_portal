package com.path.struts2.taglib.kanbanboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.util.ValueStack;
import com.path.struts2.taglib.PathDiv;

public class KanbanBoard extends PathDiv
{
    public static final String TEMPLATE_CLOSE = "kanban-board";
    public static final String PATH_THEME = "path-xhtml";

    private String id;
    private String childIdList;
    private String childNameList;
    private String dragAndDropEvent;
    private String expandCollapseEvent;
    private String enableDragAndDrop;
    private String enableExpandCollapse;
    private String dragAndDropItemLayout;
    private String itemClickListener;
    private String _pageRef;
    private String href;

    public KanbanBoard(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    @Override
    public void evaluateExtraParams()
    {
	super.evaluateExtraParams();
	addParameter("id", id);
	addParameter("childIdList", childIdList);
	addParameter("childNameList", childNameList);
	addParameter("dragAndDropEvent", dragAndDropEvent);
	addParameter("expandCollapseEvent", expandCollapseEvent);
	addParameter("enableDragAndDrop", enableDragAndDrop);
	addParameter("enableExpandCollapse", enableExpandCollapse);
	addParameter("dragAndDropItemLayout", dragAndDropItemLayout);
	addParameter("_pageRef", _pageRef);
	addParameter("itemClickListener", itemClickListener);
	addParameter("href", findString(href));

    }

    public String getId()
    {
	return id;
    }

    public void setId(String id)
    {
	this.id = id;
    }

    @Override
    protected String getDefaultTemplate()
    {
	return TEMPLATE_CLOSE;
    }

    @Override
    public String getTheme()
    {
	return PATH_THEME;
    }

    public String getLabel()
    {
	return label;
    }

    @Override
    public void setLabel(String label)
    {
	this.label = label;
    }

    public String getDragAndDropEvent()
    {
	return dragAndDropEvent;
    }

    public String getExpandCollapseEvent()
    {
	return expandCollapseEvent;
    }

    public String getEnableDragAndDrop()
    {
	return enableDragAndDrop;
    }

    public String getEnableExpandCollapse()
    {
	return enableExpandCollapse;
    }

    public void setDragAndDropEvent(String dragAndDropEvent)
    {
	this.dragAndDropEvent = dragAndDropEvent;
    }

    public void setExpandCollapseEvent(String expandCollapseEvent)
    {
	this.expandCollapseEvent = expandCollapseEvent;
    }

    public void setEnableDragAndDrop(String enableDragAndDrop)
    {
	this.enableDragAndDrop = enableDragAndDrop;
    }

    public void setEnableExpandCollapse(String enableExpandCollapse)
    {
	this.enableExpandCollapse = enableExpandCollapse;
    }

    public String getDragAndDropItemLayout()
    {
	return dragAndDropItemLayout;
    }

    public void setDragAndDropItemLayout(String dragAndDropItemLayout)
    {
	this.dragAndDropItemLayout = dragAndDropItemLayout;
    }

    public String getChildIdList()
    {
	return childIdList;
    }

    public void setChildIdList(String childIdList)
    {
	this.childIdList = childIdList;
    }

    public String getChildNameList()
    {
	return childNameList;
    }

    public void setChildNameList(String childNameList)
    {
	this.childNameList = childNameList;
    }

    public String getItemClickListener()
    {
	return itemClickListener;
    }

    public void setItemClickListener(String itemClickListener)
    {
	this.itemClickListener = itemClickListener;
    }

    public String get_pageRef()
    {
	return _pageRef;
    }

    public void set_pageRef(String _pageRef)
    {
	this._pageRef = _pageRef;
    }

    public String getHref()
    {
	return href;
    }

    public void setHref(String href)
    {
	this.href = href;
    }
}
