package com.path.bo.common.dynfiles;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DynFilesTagsStructure
{
    private String tagName;
    private BigDecimal tagNo;
    private String tagPath;
    private int tagLevel;
    private BigDecimal sqlNo;
    private BigDecimal paramNo;
    private ArrayList<DynFilesTagsStructure> dynFilesTagsStructure;
    
    public String getTagName()
    {
        return tagName;
    }
    public void setTagName(String tagName)
    {
        this.tagName = tagName;
    }
    public BigDecimal getTagNo()
    {
        return tagNo;
    }
    public void setTagNo(BigDecimal tagNo)
    {
        this.tagNo = tagNo;
    }
    public String getTagPath()
    {
        return tagPath;
    }
    public void setTagPath(String tagPath)
    {
        this.tagPath = tagPath;
    }
    public int getTagLevel()
    {
        return tagLevel;
    }
    public void setTagLevel(int tagLevel)
    {
        this.tagLevel = tagLevel;
    }
    public BigDecimal getSqlNo()
    {
        return sqlNo;
    }
    public void setSqlNo(BigDecimal sqlNo)
    {
        this.sqlNo = sqlNo;
    }
    public BigDecimal getParamNo()
    {
        return paramNo;
    }
    public void setParamNo(BigDecimal paramNo)
    {
        this.paramNo = paramNo;
    }
    public ArrayList<DynFilesTagsStructure> getDynFilesTagsStructure()
    {
        return dynFilesTagsStructure;
    }
    public void setDynFilestags(ArrayList<DynFilesTagsStructure> dynFilesTagsStructure)
    {
        this.dynFilesTagsStructure = dynFilesTagsStructure;
    }
}
