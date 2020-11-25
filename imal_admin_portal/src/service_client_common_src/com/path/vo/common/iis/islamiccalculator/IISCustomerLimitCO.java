package com.path.vo.common.iis.islamiccalculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: saheer.naduthodi
 * 
 *          IISCustomerLimitCO.java used to
 */
public class IISCustomerLimitCO extends BaseVO implements Serializable
{
    BigDecimal compCode;
    BigDecimal branchCode;
    BigDecimal cifNo;
    BigDecimal dealAmount;
    BigDecimal remainingAmount;
    BigDecimal dealCY;
    String baseCurrencyDesc;
    Date runningDate;
    BigDecimal dealNo;
    BigDecimal baseCurrencyDecimal;
    // LOS integration; Saheer.Naduthodi; 13/12/2017 [Begin]
    private String calledFrom;
    private LOSmessagesCO losMessagesCO;
    // LOS integration; Saheer.Naduthodi; 13/12/2017 [End]

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getDealAmount()
    {
	return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount)
    {
	this.dealAmount = dealAmount;
    }

    public BigDecimal getRemainingAmount()
    {
	return remainingAmount;
    }

    public void setRemainingAmount(BigDecimal remainingAmount)
    {
	this.remainingAmount = remainingAmount;
    }

    public BigDecimal getDealCY()
    {
	return dealCY;
    }

    public void setDealCY(BigDecimal dealCY)
    {
	this.dealCY = dealCY;
    }

    public String getBaseCurrencyDesc()
    {
	return baseCurrencyDesc;
    }

    public void setBaseCurrencyDesc(String baseCurrencyDesc)
    {
	this.baseCurrencyDesc = baseCurrencyDesc;
    }

    public Date getRunningDate()
    {
	return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    public BigDecimal getDealNo()
    {
	return dealNo;
    }

    public void setDealNo(BigDecimal dealNo)
    {
	this.dealNo = dealNo;
    }

    public String getCalledFrom()
    {
	return calledFrom;
    }

    public void setCalledFrom(String calledFrom)
    {
	this.calledFrom = calledFrom;
    }

    public LOSmessagesCO getLosMessagesCO()
    {
	return losMessagesCO;
    }

    public void setLosMessagesCO(LOSmessagesCO losMessagesCO)
    {
	this.losMessagesCO = losMessagesCO;
    }

    public BigDecimal getBaseCurrencyDecimal()
    {
	return baseCurrencyDecimal;
    }

    public void setBaseCurrencyDecimal(BigDecimal baseCurrencyDecimal)
    {
	this.baseCurrencyDecimal = baseCurrencyDecimal;
    }
}
