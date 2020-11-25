package com.path.struts2.lib.common.kanbanboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * Copyright 2020, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author Nazim.jassar
 * 
 */
public class KanbanBoardColumnModel
{
    private String columnName;
    private String columnHeader;
    private List<KanbanBoardItemModel> itemModels = new ArrayList<KanbanBoardItemModel>();

    public KanbanBoardColumnModel deepCloneColumnModelWithoutItem()
    {
	KanbanBoardColumnModel kanbanBoardColumnModel = new KanbanBoardColumnModel();
	kanbanBoardColumnModel.setColumnName(columnName);
	kanbanBoardColumnModel.setColumnHeader(columnHeader);
	return kanbanBoardColumnModel;
    }

    public List<KanbanBoardItemModel> getItemModels()
    {
	return itemModels;
    }

    public void setItemModels(List<KanbanBoardItemModel> itemModels)
    {
	this.itemModels = itemModels;
    }

    public void addToItemModel(KanbanBoardItemModel itemModel)
    {
	this.itemModels.add(itemModel);
    }

    public String getColumnName()
    {
	return columnName;
    }

    public void setColumnName(String columnName)
    {
	this.columnName = columnName;
    }

    public String getColumnHeader()
    {
	return columnHeader;
    }

    public void setColumnHeader(String columnHeader)
    {
	this.columnHeader = columnHeader;
    }

    public static KanbanBoardColumnModel createColumnModel(Map columnModel)
    {
	KanbanBoardColumnModel kanbanBoardColumnModel = new KanbanBoardColumnModel();
	kanbanBoardColumnModel.setColumnName((String) columnModel.get("columnName"));
	kanbanBoardColumnModel.setColumnHeader((String) columnModel.get("columnHeader"));
	((List) columnModel.get("itemModels")).forEach(itemModel -> kanbanBoardColumnModel
		.addToItemModel(KanbanBoardItemModel.createItemModel((List) itemModel)));
	return kanbanBoardColumnModel;
    }

}
