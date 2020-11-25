package com.path.vo.reporting;

import java.math.BigDecimal;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

public class IRP_REP_FILTERSSC extends GridParamsSC
{

    private String CREATED_BY;
    private BigDecimal FILTER_ID;
    private BigDecimal REPORT_ID;
    private BigDecimal ARGUMENT_ID;
    private List<BigDecimal> reportsIdList;
    private String FILTER_NAME;
    private boolean isGrid = true;
    
    

    public boolean isGrid()
    {
        return isGrid;
    }

    public void setGrid(boolean isGrid)
    {
        this.isGrid = isGrid;
    }

    public IRP_REP_FILTERSSC()
    {
	super.setSearchCols(new String[] { "FILTER_ID", "FILTER_NAME" });
    }

    public String getFILTER_NAME()
    {
	return FILTER_NAME;
    }

    public void setFILTER_NAME(String fILTER_NAME)
    {
	FILTER_NAME = fILTER_NAME;
    }

    public List<BigDecimal> getReportsIdList()
    {
	return reportsIdList;
    }

    public void setReportsIdList(List<BigDecimal> reportsIdList)
    {
	this.reportsIdList = reportsIdList;
    }

    public BigDecimal getARGUMENT_ID()
    {
	return ARGUMENT_ID;
    }

    public void setARGUMENT_ID(BigDecimal aRGUMENT_ID)
    {
	ARGUMENT_ID = aRGUMENT_ID;
    }

    public BigDecimal getFILTER_ID()
    {
	return FILTER_ID;
    }

    public void setFILTER_ID(BigDecimal fILTER_ID)
    {
	FILTER_ID = fILTER_ID;
    }

    public BigDecimal getREPORT_ID()
    {
	return REPORT_ID;
    }

    public void setREPORT_ID(BigDecimal rEPORT_ID)
    {
	REPORT_ID = rEPORT_ID;
    }

    public String getCREATED_BY()
    {
	return CREATED_BY;
    }

    public void setCREATED_BY(String cREATED_BY)
    {
	CREATED_BY = cREATED_BY;
    }

}
