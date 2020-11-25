package com.path.vo.common.swift.swiftreconciliation;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

public class SwiftReconcileSC extends BaseVO
{
    private BigDecimal compCode;
    private BigDecimal brCode;
    private BigDecimal cyCode;
    private BigDecimal glCode;
    private BigDecimal cifNo;
    private BigDecimal slNo;
    private String accNo;
    private String vtFlag;
    private Date minDate;
    private Date maxDate;

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public String getAccNo()
    {
	return accNo;
    }

    public void setAccNo(String accNo)
    {
	this.accNo = accNo;
    }

    public String getVtFlag()
    {
	return vtFlag;
    }

    public void setVtFlag(String vtFlag)
    {
	this.vtFlag = vtFlag;
    }

    public Date getMinDate()
    {
	return minDate;
    }

    public void setMinDate(Date minDate)
    {
	this.minDate = minDate;
    }

    public Date getMaxDate()
    {
	return maxDate;
    }

    public void setMaxDate(Date maxDate)
    {
	this.maxDate = maxDate;
    }

    public BigDecimal getBrCode()
    {
	return brCode;
    }

    public void setBrCode(BigDecimal brCode)
    {
	this.brCode = brCode;
    }

    public BigDecimal getCyCode()
    {
	return cyCode;
    }

    public void setCyCode(BigDecimal cyCode)
    {
	this.cyCode = cyCode;
    }

    public BigDecimal getGlCode()
    {
	return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getSlNo()
    {
	return slNo;
    }

    public void setSlNo(BigDecimal slNo)
    {
	this.slNo = slNo;
    }

}
