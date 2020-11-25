package com.path.vo.common.status;

import com.path.struts2.lib.common.BaseObject;

/**
 * 
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: deniskhaddad
 * 
 *          StatusAddFieldCO.java used to Construct Additional Columns needed
 *          for Status Common Dialog Display, So if it is needed to have new
 *          column for status grid other that User, Status, and Date then this
 *          object is used to specify Field details
 */
public class StatusAddFieldCO extends BaseObject
{
    /**
     * new column/Field type, ConstantCommon.COLUMN_DATE_TYPE,
     * ConstantCommon.COLUMN_NUMBER_TYPE , ConstantCommon.COLUMN_TEXT_TYPE
     */
    private final String colType;
    /**
     * key of the title that to be displayed on new column/Field of status
     * common grid
     */
    private final String colTitleKey;

    public StatusAddFieldCO(String colType, String colTitleKey)
    {
	this.colType = colType;
	this.colTitleKey = colTitleKey;
    }

    public String getColType()
    {
	return colType;
    }

    public String getColTitleKey()
    {
	return colTitleKey;
    }
}
