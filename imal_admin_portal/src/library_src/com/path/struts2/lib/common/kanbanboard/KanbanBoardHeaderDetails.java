package com.path.struts2.lib.common.kanbanboard;

/**
 * 
 * Copyright 2020, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author Nazim.jassar
 * 
 */
@SuppressWarnings("serial")
public class KanbanBoardHeaderDetails
{
    private String id;
    private String title;
    private String connectedColumns;
    private boolean enableDragAndDrop;

    public String getId()
    {
	return id;
    }

    public void setId(String id)
    {
	this.id = id;
    }

    public String getTitle()
    {
	return title;
    }

    public void setTitle(String title)
    {
	this.title = title;
    }

    /**
     * To make the column under these header droppable these method should be
     * called with destination ids as arguments.
     * 
     * @param connectedColumns array of header ids.
     * 
     *            Ex: headerDetail.addConnectedColumnsForDnd("headerId2_" +
     *            get_pageRef());
     * 
     *            This method call enables the items under this header to be
     *            droppable at another column which comes under "headerId2_" +
     *            get_pageRef(). Here "headerId2_" + get_pageRef() is the id to
     *            the destination header
     */
    public void addConnectedColumnsForDnd(String... connectedColumns)
    {
	for(String connectedColumn : connectedColumns)
	{
	    if(this.connectedColumns == null)
		this.connectedColumns = this.id;
	    this.connectedColumns = this.connectedColumns + "," + connectedColumn;
	}
    }

    public boolean isEnableDragAndDrop()
    {
	return enableDragAndDrop;
    }

    public void setEnableDragAndDrop(boolean enableDragAndDrop)
    {
	this.enableDragAndDrop = enableDragAndDrop;
    }

    public String getConnectedColumns()
    {
	return connectedColumns;
    }

    public void setConnectedColumns(String connectedColumns)
    {
	this.connectedColumns = connectedColumns;
    }
}
