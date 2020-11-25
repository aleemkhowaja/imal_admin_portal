package com.path.vo.reporting;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class IRP_SUB_REPORTSC extends GridParamsSC
{
    private BigDecimal SUB_REPORT_ID;
    private String SUB_REPORT_EXPRESSION;
    private Boolean isGrid=true;
    
    public Boolean getIsGrid()
    {
        return isGrid;
    }
    public void setIsGrid(Boolean isGrid)
    {
        this.isGrid = isGrid;
    }
    public BigDecimal getSUB_REPORT_ID()
    {
        return SUB_REPORT_ID;
    }
    public void setSUB_REPORT_ID(BigDecimal sUBREPORTID)
    {
        SUB_REPORT_ID = sUBREPORTID;
    }
    public String getSUB_REPORT_EXPRESSION()
    {
        return SUB_REPORT_EXPRESSION;
    }
    public void setSUB_REPORT_EXPRESSION(String sUBREPORTEXPRESSION)
    {
        SUB_REPORT_EXPRESSION = sUBREPORTEXPRESSION;
    }
    
    
    
}
