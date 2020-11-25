package com.path.vo.common.dynfiles;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class DynFilesXMLSQLGen extends BaseVO
{
    private BigDecimal sqlNo;
    private String sqlText;
    private String columnValue;
    private int lineNo;
    
    public BigDecimal getSqlNo()
    {
        return sqlNo;
    }
    public void setSqlNo(BigDecimal sqlNo)
    {
        this.sqlNo = sqlNo;
    }
    public String getSqlText()
    {
        return sqlText;
    }
    public void setSqlText(String sqlText)
    {
        this.sqlText = sqlText;
    }
    public String getColumnValue()
    {
        return columnValue;
    }
    public void setColumnValue(String columnValue)
    {
        this.columnValue = columnValue;
    }
    public int getLineNo()
    {
        return lineNo;
    }
    public void setLineNo(int lineNo)
    {
        this.lineNo = lineNo;
    }
}
