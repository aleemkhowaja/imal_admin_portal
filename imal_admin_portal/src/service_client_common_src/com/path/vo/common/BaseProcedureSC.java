package com.path.vo.common;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.BaseSC;

public class BaseProcedureSC extends BaseSC
{
    /**
     * Procedure Error message
     */
    private String errorMessage;
    /**
     * Procedure Error code
     */
    private BigDecimal errorCode;
    /**
     * Procedure Error type example : E=Error W=Warning
     */
    private String errorType;

    private Date tradeDate; // trade Date filled in calls for assets app in method checkbackdatedtrx
    public String getErrorMessage()
    {
	return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
	this.errorMessage = errorMessage;
    }

    public BigDecimal getErrorCode()
    {
	return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
	this.errorCode = errorCode;
    }

    public String getErrorType()
    {
	return errorType;
    }

    public void setErrorType(String errorType)
    {
	this.errorType = errorType;
    }

    public Date getTradeDate()
    {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate)
    {
        this.tradeDate = tradeDate;
    }

}
