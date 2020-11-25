package com.path.vo.common;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: deniskhaddad
 *
 * DBSequenceSC.java used to select the Sequence From DB specific Table
 */
public class DBSequenceSC extends BaseSC
{
    /**
     * Sequence Name for Oracle
     */
    private String sequenceName;
    /**
     * TAble name for Sybase Identity TAble
     */
    private String tableName;
    /**
     * Sequence Value for intenral use
     */
    private BigDecimal seqValue;
    public String getSequenceName()
    {
        return sequenceName;
    }
    public void setSequenceName(String sequenceName)
    {
        this.sequenceName = sequenceName;
    }
    public String getTableName()
    {
        return tableName;
    }
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }
    public BigDecimal getSeqValue()
    {
        return seqValue;
    }
    public void setSeqValue(BigDecimal seqValue)
    {
        this.seqValue = seqValue;
    }
}
