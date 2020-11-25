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
public class KanbanBoardRowModel
{
    private List<KanbanBoardColumnModel> columnModels = new ArrayList<>();

    public KanbanBoardRowModel deepCloneRowModel()
    {
	KanbanBoardRowModel kanbanBoardRowModel = new KanbanBoardRowModel();
	columnModels.forEach(
		columnModel -> kanbanBoardRowModel.addColumnModel(columnModel.deepCloneColumnModelWithoutItem()));
	return kanbanBoardRowModel;
    }

    public void addColumnModel(KanbanBoardColumnModel columnModel)
    {
	columnModels.add(columnModel);
    }

    public List<KanbanBoardColumnModel> getColumnModels()
    {
	return columnModels;
    }

    public void setColumnModels(List<KanbanBoardColumnModel> columnModels)
    {
	this.columnModels = columnModels;
    }

    public static KanbanBoardRowModel createRowModel(Map rowModel)
    {
	KanbanBoardRowModel kanbanBoardRowModel = new KanbanBoardRowModel();
	((List) rowModel.get("columnModels")).forEach(columnModel -> kanbanBoardRowModel
		.addColumnModel(KanbanBoardColumnModel.createColumnModel((Map) columnModel)));
	return kanbanBoardRowModel;
    }

}
