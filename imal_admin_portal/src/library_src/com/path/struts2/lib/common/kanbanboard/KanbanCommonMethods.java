package com.path.struts2.lib.common.kanbanboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.JSONException;

import com.path.struts2.json.PathJSONUtil;

/**
 * 
 * Copyright 2020, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author Nazim.jassar
 * 
 */
public class KanbanCommonMethods
{
    /**
     * This Method will convert JSON output from Kanban Board Component to the
     * Data Model List
     * 
     * @param JSONOutput - JSON Output from the component
     */
    public static List<KanbanBoardRowModel> returnKanbanBoardValues(String JSONOutput) throws JSONException
    {
	List kanbanBoardValues = (List) PathJSONUtil.deserialize(JSONOutput);
	ArrayList<KanbanBoardRowModel> rowModelList = new ArrayList<>();
	if(kanbanBoardValues != null && !kanbanBoardValues.isEmpty())
	{
	    kanbanBoardValues.forEach(rowModel -> rowModelList.add(KanbanBoardRowModel.createRowModel((Map) rowModel)));
	}
	return rowModelList;
    }
}
