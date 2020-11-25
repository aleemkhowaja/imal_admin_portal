package com.path.vo.reporting;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class ReportOutputCO implements Serializable
{
    private byte[] reportBytes;
    private byte[] reportBytes2;
    private String outputFormat;
    private int pagesNbr;
    private boolean hasData;
    private String repStr;
    private HashMap<BigDecimal,BigDecimal> cifMap;
    private String outputHtml;
    private boolean hasPagination; // comment ...
    private int paginationCount; //comment ...
    private String reportName;
    private BigDecimal snpShotID;
    private Date execDate;
    
    
    
    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public int getPaginationCount()
    {
	return paginationCount;
    }

    public void setPaginationCount(int paginationCount)
    {
	this.paginationCount = paginationCount;
    }

    public String getOutputHtml()
    {
	return outputHtml;
    }

    public void setOutputHtml(String outputHtml)
    {
	this.outputHtml = outputHtml;
    }

    public boolean isHasPagination()
    {
	return hasPagination;
    }

    public void setHasPagination(boolean hasPagination)
    {
	this.hasPagination = hasPagination;
    }
   
    public HashMap<BigDecimal, BigDecimal> getCifMap()
    {
        return cifMap;
    }
    public void setCifMap(HashMap<BigDecimal, BigDecimal> cifMap)
    {
        this.cifMap = cifMap;
    }
    public String getRepStr() {
		return repStr;
	}
	public void setRepStr(String repStr) {
		this.repStr = repStr;
	}
	public boolean isHasData()
    {
        return hasData;
    }
    public void setHasData(boolean hasData)
    {
        this.hasData = hasData;
    }
    public byte[] getReportBytes()
    {
        return reportBytes;
    }
    public void setReportBytes(byte[] reportBytes)
    {
        this.reportBytes = reportBytes;
    }
    public byte[] getReportBytes2()
    {
        return reportBytes2;
    }
    public void setReportBytes2(byte[] reportBytes2)
    {
        this.reportBytes2 = reportBytes2;
    }
    public String getOutputFormat()
    {
        return outputFormat;
    }
    public void setOutputFormat(String outputFormat)
    {
        this.outputFormat = outputFormat;
    }
    public int getPagesNbr()
    {
        return pagesNbr;
    }
    public void setPagesNbr(int pagesNbr)
    {
        this.pagesNbr = pagesNbr;
    }

	public BigDecimal getSnpShotID() {
		return snpShotID;
	}

	public void setSnpShotID(BigDecimal snpShotID) {
		this.snpShotID = snpShotID;
	}
	
	public Date getExecDate() {
		return execDate;
	}
	public void setExecDate(Date execDate) {
		this.execDate = execDate;
	}
    
    
}
