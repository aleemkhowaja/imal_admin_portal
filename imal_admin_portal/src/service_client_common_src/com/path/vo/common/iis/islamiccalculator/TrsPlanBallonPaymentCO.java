package com.path.vo.common.iis.islamiccalculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TrsPlanBallonPaymentCO implements Serializable
{
    private Date balloonDate;
    private BigDecimal balloonNo;
    private BigDecimal balloonAmount;
    private BigDecimal baloonAmtFormat;
    private BigDecimal currencyDecimal;

    public BigDecimal getBaloonAmtFormat()
    {
	return baloonAmtFormat;
    }

    public void setBaloonAmtFormat(BigDecimal baloonAmtFormat)
    {
	this.baloonAmtFormat = baloonAmtFormat;
    }

    public Date getBalloonDate()
    {
	return balloonDate;
    }

    public void setBalloonDate(Date balloonDate)
    {
	this.balloonDate = balloonDate;
    }

    public BigDecimal getBalloonNo()
    {
	return balloonNo;
    }

    public void setBalloonNo(BigDecimal balloonNo)
    {
	this.balloonNo = balloonNo;
    }

    public BigDecimal getBalloonAmount()
    {
	return balloonAmount;
    }

    public void setBalloonAmount(BigDecimal balloonAmount)
    {
	this.balloonAmount = balloonAmount;
    }

    public BigDecimal getCurrencyDecimal()
    {
	return currencyDecimal;
    }

    public void setCurrencyDecimal(BigDecimal currencyDecimal)
    {
	this.currencyDecimal = currencyDecimal;
    }

}
