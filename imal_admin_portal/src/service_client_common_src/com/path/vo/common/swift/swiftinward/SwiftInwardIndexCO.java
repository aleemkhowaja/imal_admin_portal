package com.path.vo.common.swift.swiftinward;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;


public class SwiftInwardIndexCO extends BaseVO
{
    private BigDecimal lineNbr;
    private String tag;
    private BigDecimal tagLine;
    private BigDecimal index;
    
    public BigDecimal getLineNbr()
    {
        return lineNbr;
    }
    public void setLineNbr(BigDecimal lineNbr)
    {
        this.lineNbr = lineNbr;
    }
    public String getTag()
    {
        return tag;
    }
    public void setTag(String tag)
    {
        this.tag = tag;
    }
    public BigDecimal getTagLine()
    {
        return tagLine;
    }
    public void setTagLine(BigDecimal tagLine)
    {
        this.tagLine = tagLine;
    }
    public BigDecimal getIndex()
    {
        return index;
    }
    public void setIndex(BigDecimal index)
    {
        this.index = index;
    }
    
}
