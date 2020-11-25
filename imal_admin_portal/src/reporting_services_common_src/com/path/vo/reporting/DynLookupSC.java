package com.path.vo.reporting;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.struts2.lib.common.GridParamsSC;

public class DynLookupSC extends GridParamsSC
{
    private String sqlStr;
    private String qryId;
    private BigDecimal connId;
    private HashMap<String, String> hmQryParam = new HashMap<String, String>();//to hold the qry parmeters name and value
    private BigDecimal argId;
    private BigDecimal reportId;
    private String argVal;
    private BigDecimal sourceId;
    
    public BigDecimal getSourceId() 
    {
		return sourceId;
	}

	public void setSourceId(BigDecimal sourceId) 
	{
		this.sourceId = sourceId;
	}

	public BigDecimal getArgId()
    {
        return argId;
    }

    public void setArgId(BigDecimal argId)
    {
        this.argId = argId;
    }

    public BigDecimal getReportId()
    {
        return reportId;
    }

    public void setReportId(BigDecimal reportId)
    {
        this.reportId = reportId;
    }

    public String getArgVal()
    {
        return argVal;
    }

    public void setArgVal(String argVal)
    {
        this.argVal = argVal;
    }

    public BigDecimal getConnId()
    {
	return connId;
    }

    public void setConnId(BigDecimal connId)
    {
	this.connId = connId;
    }

    public DynLookupSC()
    {
	super.setSearchCols(new String[] {});
    }

    public HashMap<String, String> getHmQryParam()
    {
	return hmQryParam;
    }

    public void setHmQryParam(HashMap<String, String> hmQryParam)
    {
	this.hmQryParam = hmQryParam;
    }

    public String getSqlStr()
    {
	return sqlStr;
    }

    public void setSqlStr(String sqlStr)
    {
	this.sqlStr = sqlStr;
    }

    public String getQryId()
    {
	return qryId;
    }

    public void setQryId(String qryId)
    {
	this.qryId = qryId;
    }

}
