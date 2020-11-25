package com.path.bo.common.dynfiles;

public class DynFilesColumnsPosition
{
    private String columnName;
    private int columnPosition;
    private int isPK;
    
    public String getColumnName()
    {
        return columnName;
    }
    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }
    public int getColumnPosition()
    {
        return columnPosition;
    }
    public void setColumnPosition(int columnPosition)
    {
        this.columnPosition = columnPosition;
    }
    public int getIsPK()
    {
        return isPK;
    }
    public void setIsPK(int isPK)
    {
        this.isPK = isPK;
    }
}
