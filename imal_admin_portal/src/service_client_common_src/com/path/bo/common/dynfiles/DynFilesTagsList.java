package com.path.bo.common.dynfiles;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DynFilesTagsList
{
    private String tagName;
    private String tagPath;
    private BigDecimal paramNo;
    private int occurrences;
    
    public String getTagName()
    {
        return tagName;
    }
    public void setTagName(String tagName)
    {
        this.tagName = tagName;
    }
    public String getTagPath()
    {
        return tagPath;
    }
    public void setTagPath(String tagPath)
    {
        this.tagPath = tagPath;
    }
    public BigDecimal getParamNo()
    {
        return paramNo;
    }
    public void setParamNo(BigDecimal paramNo)
    {
        this.paramNo = paramNo;
    }
    public int getOccurrences()
    {
        return occurrences;
    }
    public void setOccurrences(int occurrences)
    {
        this.occurrences = occurrences;
    }
    public void setDynFilesAttributes(ArrayList<DynFilesTagAttributes> myAttributes)
    {
	// TODO Auto-generated method stub
    }
}
