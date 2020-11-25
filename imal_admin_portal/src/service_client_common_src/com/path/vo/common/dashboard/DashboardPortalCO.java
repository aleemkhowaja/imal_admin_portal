/**
 * 
 */
package com.path.vo.common.dashboard;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashboardPortalCO.java used to
 */
public class DashboardPortalCO extends BaseVO
{
    private BigDecimal currencyCode;
    private BigDecimal countedValue;
    private BigDecimal balanceValue;
    private String     currencyDesc;
    private BigDecimal trxNo;
    private BigDecimal cashSituation;
    private String     decValue;
    /**
     * @return the currencyCode
     */
    public BigDecimal getCurrencyCode()
    {
        return currencyCode;
    }
    /**
     * @param currencyCode the currencyCode to set
     */
    public void setCurrencyCode(BigDecimal currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    /**
     * @return the countedValue
     */
    public BigDecimal getCountedValue()
    {
        return countedValue;
    }
    /**
     * @param countedValue the countedValue to set
     */
    public void setCountedValue(BigDecimal countedValue)
    {
        this.countedValue = countedValue;
    }
    /**
     * @return the balanceValue
     */
    public BigDecimal getBalanceValue()
    {
        return balanceValue;
    }
    /**
     * @param balanceValue the balanceValue to set
     */
    public void setBalanceValue(BigDecimal balanceValue)
    {
        this.balanceValue = balanceValue;
    }
    /**
     * @return the currencyDesc
     */
    public String getCurrencyDesc()
    {
        return currencyDesc;
    }
    /**
     * @param currencyDesc the currencyDesc to set
     */
    public void setCurrencyDesc(String currencyDesc)
    {
        this.currencyDesc = currencyDesc;
    }
    /**
     * @return the trxNo
     */
    public BigDecimal getTrxNo()
    {
        return trxNo;
    }
    /**
     * @param trxNo the trxNo to set
     */
    public void setTrxNo(BigDecimal trxNo)
    {
        this.trxNo = trxNo;
    }
    /**
     * @return the cashSituation
     */
    public BigDecimal getCashSituation()
    {
        return cashSituation;
    }
    /**
     * @param cashSituation the cashSituation to set
     */
    public void setCashSituation(BigDecimal cashSituation)
    {
        this.cashSituation = cashSituation;
    }
    /**
     * @return the decValue
     */
    public String getDecValue()
    {
        return decValue;
    }
    /**
     * @param decValue the decValue to set
     */
    public void setDecValue(String decValue)
    {
        this.decValue = decValue;
    }
}
