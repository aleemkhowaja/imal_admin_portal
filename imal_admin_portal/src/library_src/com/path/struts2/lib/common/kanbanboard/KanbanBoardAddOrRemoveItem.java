package com.path.struts2.lib.common.kanbanboard;

/**
 * 
 * Copyright 2020, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author Nazim.jassar
 * 
 */
public class KanbanBoardAddOrRemoveItem
{
    private String newItemUrl;
    private String newItemPopupUrl;
    private String newItemPopupTitle = "Add New Item";
    private String addNewItem = "Add New Item";
    private String deleteItem = "Delete Item";
    private String popupButtonLabel = "Add";

    public String getNewItemUrl()
    {
	return newItemUrl;
    }

    public void setNewItemUrl(String newItemUrl)
    {
	this.newItemUrl = newItemUrl;
    }

    public String getNewItemPopupUrl()
    {
	return newItemPopupUrl;
    }

    public void setNewItemPopupUrl(String newItemPopupUrl)
    {
	this.newItemPopupUrl = newItemPopupUrl;
    }

    public String getPopupButtonLabel()
    {
	return popupButtonLabel;
    }

    public void setPopupButtonLabel(String popupButtonLabel)
    {
	this.popupButtonLabel = popupButtonLabel;
    }

    public String getNewItemPopupTitle()
    {
	return newItemPopupTitle;
    }

    public void setNewItemPopupTitle(String newItemPopupTitle)
    {
	this.newItemPopupTitle = newItemPopupTitle;
    }

    public String getAddNewItem()
    {
	return addNewItem;
    }

    public void setAddNewItem(String addNewItem)
    {
	this.addNewItem = addNewItem;
    }

    public String getDeleteItem()
    {
	return deleteItem;
    }

    public void setDeleteItem(String deleteItem)
    {
	this.deleteItem = deleteItem;
    }

}
