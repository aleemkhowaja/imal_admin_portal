package com.path.actions.common.dynamicscreen;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

/**
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Nazim Jassar
 *
 */

public class ColumnWiseProcessor extends AbstractGridProcessor<String, String, BigDecimal>
{

    @Override
    public void addToColumnProcessor(String id, AbstractGridOperation<String, BigDecimal> entry)
    {
	if(gridOperation == null)
	    gridOperation = new LinkedHashMap<>();
	if(!gridOperation.containsKey(id))
	    gridOperation.put(id, entry);
    }

    @Override
    public AbstractGridOperation<String, BigDecimal> getColumnProcessor(String id)
    {
	if(gridOperation != null && gridOperation.containsKey(id))
	    return gridOperation.get(id);
	return null;
    }

    @Override
    public void inputAndProcess(String id, String input)
    {
	super.inputAndProcess(id, input);
    }
}
