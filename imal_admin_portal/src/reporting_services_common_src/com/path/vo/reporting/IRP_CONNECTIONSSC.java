package com.path.vo.reporting;

import java.math.BigDecimal;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

public class IRP_CONNECTIONSSC extends GridParamsSC
{
    
    private BigDecimal CONN_ID;
    private List<BigDecimal> connIdLst;
    
    
    
    
    public List<BigDecimal> getConnIdLst()
    {
        return connIdLst;
    }

    public void setConnIdLst(List<BigDecimal> connIdLst)
    {
        this.connIdLst = connIdLst;
    }

    public IRP_CONNECTIONSSC()
    {
	super.setSearchCols(new String[] {"CONN_DESC","CONN_ID","URL","DBMS"});
    }

    public BigDecimal getCONN_ID()
    {
        return CONN_ID;
    }

    public void setCONN_ID(BigDecimal cONNID)
    {
        CONN_ID = cONNID;
    }

}
