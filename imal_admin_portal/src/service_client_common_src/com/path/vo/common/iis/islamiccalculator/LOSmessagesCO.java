package com.path.vo.common.iis.islamiccalculator;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: saheer.naduthodi
 * 
 *          LOSexceptionCO.java used to store the warning/information messages
 *          thrown from the LOS web service
 */
public class LOSmessagesCO extends BaseVO
{
    private String type;
    private String description;
    private BigDecimal code;

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public String getDescription()
    {
	return description;
    }

    public void setDescription(String description)
    {
	this.description = description;
    }

    public BigDecimal getCode()
    {
	return code;
    }

    public void setCode(BigDecimal code)
    {
	this.code = code;
    }
}
