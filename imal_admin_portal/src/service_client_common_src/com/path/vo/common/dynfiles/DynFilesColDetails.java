package com.path.vo.common.dynfiles;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class DynFilesColDetails extends BaseVO
{
    private String colName;
    private String visible;
    private String editable;
    private BigDecimal tagNo;
    private BigDecimal sqlNo;
    private int colType;	// 0: numeric -- 1: alphabetic
    private BigDecimal fieldLen;
    private String collabeltrans; // Hasan ghrayeb
    
    public BigDecimal getFieldLen()
    {
        return fieldLen;
    }
    public void setFieldLen(BigDecimal fieldLen)
    {
        this.fieldLen = fieldLen;
    }
    public String getColName()
    {
        return colName;
    }
    public void setColName(String colName)
    {
        this.colName = colName;
    }
    public String getVisible()
    {
        return visible;
    }
    public void setVisible(String visible)
    {
        this.visible = visible;
    }
    public String getEditable()
    {
        return editable;
    }
    public void setEditable(String editable)
    {
        this.editable = editable;
    }
    public BigDecimal getTagNo()
    {
        return tagNo;
    }
    public void setTagNo(BigDecimal tagNo)
    {
        this.tagNo = tagNo;
    }
    public BigDecimal getSqlNo()
    {
        return sqlNo;
    }
    public void setSqlNo(BigDecimal sqlNo)
    {
        this.sqlNo = sqlNo;
    }
    public int getColType()
    {
        return colType;
    }
    public void setColType(int colType)
    {
        this.colType = colType;
    }
    public String getCollabeltrans()
    {
        return collabeltrans;
    }
    public void setCollabeltrans(String collabeltrans)
    {
        this.collabeltrans = collabeltrans;
    }

}