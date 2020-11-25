package com.path.struts2.taglib.kanbanboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

public class KanbanBoardTag extends AbstractUITag
{
    private String id;
    private String href;
    private String dragAndDropEvent;
    private String expandCollapseEvent;
    private String enableDragAndDrop;
    private String enableExpandCollapse;
    private String dragAndDropItemLayout;
    private String itemClickListener;
    private String pageRef;

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	return new KanbanBoard(stack, request, response);
    }

    @Override
    protected void populateParams()
    {
	super.populateParams();
	KanbanBoard kanbanBoard = (KanbanBoard) component;
	kanbanBoard.setDragAndDropEvent(dragAndDropEvent);
	kanbanBoard.setExpandCollapseEvent(expandCollapseEvent);
	kanbanBoard.setDragAndDropEvent(dragAndDropEvent);
	kanbanBoard.setEnableDragAndDrop(enableDragAndDrop);
	kanbanBoard.setEnableExpandCollapse(enableExpandCollapse);
	kanbanBoard.setHref(href);
	kanbanBoard.setId(id);
	kanbanBoard.setDragAndDropItemLayout(dragAndDropItemLayout);
	kanbanBoard.setItemClickListener(itemClickListener);
	kanbanBoard.set_pageRef(pageRef);
    }

    public String getId()
    {
	return id;
    }

    public void setId(String id)
    {
	this.id = id;
    }

    public String getHref()
    {
	return href;
    }

    public void setHref(String href)
    {
	this.href = href;
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

    public String getItemClickListener()
    {
	return itemClickListener;
    }

    public void setItemClickListener(String itemClickListener)
    {
	this.itemClickListener = itemClickListener;
    }

    public String getPageRef()
    {
	return pageRef;
    }

    public void setPageRef(String pageRef)
    {
	this.pageRef = pageRef;
    }
}
