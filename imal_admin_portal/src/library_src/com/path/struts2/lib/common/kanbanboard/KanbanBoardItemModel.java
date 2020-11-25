package com.path.struts2.lib.common.kanbanboard;

import java.util.ArrayList;
import java.util.HashMap;
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
public class KanbanBoardItemModel
{
    private String itemUrl;
    private Map<String, String> itemArguments = new HashMap<String, String>();
    private List itemValues = new ArrayList();

    public String getItemUrl()
    {
	return itemUrl;
    }

    public void setItemUrl(String itemUrl)
    {
	this.itemUrl = itemUrl;
    }

    public Map<String, String> getItemArguments()
    {
	return itemArguments;
    }

    public void setItemArguments(Map<String, String> itemArguments)
    {
	this.itemArguments = itemArguments;
    }

    public void addToItemArgument(String variable, String value)
    {
	itemArguments.put(variable, value);
    }

    public List getItemValues()
    {
	return itemValues;
    }

    public void setItemValues(List itemValues)
    {
	this.itemValues = itemValues;
    }

    public void addtemValues(Object itemValues)
    {
	this.itemValues.add(itemValues);
    }

    public static KanbanBoardItemModel createItemModel(List itemValues)
    {
	KanbanBoardItemModel kanbanBoardItemModel = new KanbanBoardItemModel();
	kanbanBoardItemModel.setItemValues(itemValues);
	return kanbanBoardItemModel;
    }
}
