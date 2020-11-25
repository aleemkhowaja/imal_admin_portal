package com.path.vo.common;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseSC;

public class DepositerSC extends BaseSC
{
    private String depositerId;
    
    private BigDecimal idType;
    
    private BigDecimal cifNo;
    
    private String warningMessages;
    
    private String showSuspicious;
    
    private String mosBlackListedStatus;
    
    private String checkIdTypesLength;
    
    private String validateId;

    public String getDepositerId()
    {
        return depositerId;
    }

    public void setDepositerId(String depositerId)
    {
        this.depositerId = depositerId;
    }

    public BigDecimal getIdType()
    {
        return idType;
    }

    public void setIdType(BigDecimal idType)
    {
        this.idType = idType;
    }

    public String getWarningMessages()
    {
        return warningMessages;
    }

    public void setWarningMessages(String warningMessages)
    {
        this.warningMessages = warningMessages;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public String getShowSuspicious()
    {
        return showSuspicious;
    }

    public void setShowSuspicious(String showSuspicious)
    {
        this.showSuspicious = showSuspicious;
    }

    public String getMosBlackListedStatus()
    {
        return mosBlackListedStatus;
    }

    public void setMosBlackListedStatus(String mosBlackListedStatus)
    {
        this.mosBlackListedStatus = mosBlackListedStatus;
    }

    public String getCheckIdTypesLength()
    {
        return checkIdTypesLength;
    }

    public void setCheckIdTypesLength(String checkIdTypesLength)
    {
        this.checkIdTypesLength = checkIdTypesLength;
    }

    public String getValidateId()
    {
        return validateId;
    }

    public void setValidateId(String validateId)
    {
        this.validateId = validateId;
    }
}
