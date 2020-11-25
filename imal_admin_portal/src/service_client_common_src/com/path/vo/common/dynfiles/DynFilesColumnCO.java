package com.path.vo.common.dynfiles;

import com.path.vo.core.common.RetailBaseVO;

public class DynFilesColumnCO extends RetailBaseVO
{
    Object columnValue;
    int columnType;
    String columnName;
    
    public String getColumnName()
    {
        return columnName;
    }
    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }
    public Object getColumnValue()
    {
        return columnValue;
    }
    public void setColumnValue(Object columnValue)
    {
        this.columnValue = columnValue;
    }
    public int getColumnType()
    {
        return columnType;
    }
    public void setColumnType(int columnType)
    {
        this.columnType = columnType;
    }
}
