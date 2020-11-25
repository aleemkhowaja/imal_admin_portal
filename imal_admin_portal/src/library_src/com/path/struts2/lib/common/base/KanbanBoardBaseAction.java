package com.path.struts2.lib.common.base;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.kanbanboard.KanbanBoardAddOrRemoveItem;
import com.path.struts2.lib.common.kanbanboard.KanbanBoardHeaderDetails;
import com.path.struts2.lib.common.kanbanboard.KanbanBoardRowModel;

/**
 * 
 * Copyright 2020, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author Nazim.jassar
 * 
 */
public class KanbanBoardBaseAction extends BaseAction
{
    private String id;
    private String rowModelsJSON;
    private String headerDetailsJSON;
    private Boolean isRTL;
    private String[] itemIdList;
    private List<KanbanBoardRowModel> kanbanModelsTemplate;
    private List<KanbanBoardHeaderDetails> headerDetails;
    private List<KanbanBoardRowModel> rowModels;
    private KanbanBoardAddOrRemoveItem addOrRemoveItem = new KanbanBoardAddOrRemoveItem();

    /**
     * 
     * This method should be called with given arguments in order to load a drag
     * and drop component Arguments to the methods are
     * 
     * @param headerDetails header details for the component.
     * @param rowModels data model for the component.
     * @param itemIds array of item ids rendered inside the component.
     * 
     */
    protected void addToKanbanBoardGridModel(List<KanbanBoardHeaderDetails> headerDetails,
	    List<KanbanBoardRowModel> rowModels, String[] itemIds) throws Exception
    {
	this.rowModels = rowModels;
	if(rowModels == null)
	    return;
	setItemIdList(itemIds);
	for(KanbanBoardRowModel rowModel : rowModels)
	{
	    if(rowModel.getColumnModels().size() > headerDetails.size())
		throw new Exception("Exception with Kanban Board Component : Number of Columns cannot exceed "
			+ headerDetails.size());
	    for(int i = 0; i < headerDetails.size(); i++)
		rowModel.getColumnModels().get(i).setColumnHeader(headerDetails.get(i).getId());
	}
	this.setHeaderDetails(headerDetails);
	kanbanModelsTemplate = new ArrayList<>();
	rowModels.forEach(kanbanBoardRowModel -> kanbanModelsTemplate.add(kanbanBoardRowModel.deepCloneRowModel()));
    }

    public String loadKanbanBoardAction()
    {
	try
	{
	    if(ActionContext.getContext().getLocale() != null)
		setIsRTL(returnSessionObject().getIsRTLDir() == 1);
	    setRowModels((ArrayList) PathJSONUtil.deserialize(getRowModelsJSON()));
	    setHeaderDetails((ArrayList) PathJSONUtil.deserialize(getHeaderDetailsJSON()));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return "kanbanBoardBaseActionResp";
    }

    public String getId()
    {
	return id;
    }

    public void setId(String id)
    {
	this.id = id;
    }

    public List<KanbanBoardRowModel> getRowModels()
    {
	return rowModels;
    }

    public void setRowModels(List<KanbanBoardRowModel> rowModels)
    {
	this.rowModels = rowModels;
    }

    public String getRowModelsJSON()
    {
	return rowModelsJSON;
    }

    public void setRowModelsJSON(String rowModelsJSON)
    {
	this.rowModelsJSON = rowModelsJSON;
    }

    public void setItemIdList(String[] itemIdList)
    {
	this.itemIdList = itemIdList;
    }

    public String[] getItemIdList()
    {
	return itemIdList;
    }

    public List<KanbanBoardHeaderDetails> getHeaderDetails()
    {
	return headerDetails;
    }

    public void setHeaderDetails(List<KanbanBoardHeaderDetails> headerDetails)
    {
	this.headerDetails = headerDetails;
    }

    public String getHeaderDetailsJSON()
    {
	return headerDetailsJSON;
    }

    public void setHeaderDetailsJSON(String headerDetailsJSON)
    {
	this.headerDetailsJSON = headerDetailsJSON;
    }

    public void setNewItemUrl(String newItemUrl)
    {
	addOrRemoveItem.setNewItemUrl(newItemUrl);
    }

    public void setNewItemPopupUrl(String newItemPopupUrl)
    {
	addOrRemoveItem.setNewItemPopupUrl(newItemPopupUrl);
    }

    public KanbanBoardAddOrRemoveItem getAddOrRemoveItem()
    {
	return addOrRemoveItem;
    }

    public void setAddOrRemoveItem(KanbanBoardAddOrRemoveItem addOrRemoveItem)
    {
	this.addOrRemoveItem = addOrRemoveItem;
    }

    public Boolean getIsRTL()
    {
	return isRTL;
    }

    public void setIsRTL(Boolean isRTL)
    {
	this.isRTL = isRTL;
    }

    public List<KanbanBoardRowModel> getKanbanModelsTemplate()
    {
	return kanbanModelsTemplate;
    }

    public void setKanbanModelsTemplate(List<KanbanBoardRowModel> kanbanModelsTemplate)
    {
	this.kanbanModelsTemplate = kanbanModelsTemplate;
    }
}
