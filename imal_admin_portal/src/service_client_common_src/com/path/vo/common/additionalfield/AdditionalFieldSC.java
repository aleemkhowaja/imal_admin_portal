/**
 * 
 */
package com.path.vo.common.additionalfield;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AdditionalFieldSC.java used to
 */
public class AdditionalFieldSC extends BaseSC
{
    private String progRef;
    private String usedFrom;
    private String entity;
    private BigDecimal additionalReference;
    private BigDecimal trsNo;
    
    private Boolean isReadOnly = false;
    
    private BigDecimal typeCode;
    private BigDecimal cifNo;
    private BigDecimal entityCode;
    private BigDecimal currencyCode;
    private BigDecimal slNo;
    
    private String iv_crud;
    private String _pageRef;
    private String allowToModifyCif;
    private String status;
    
    private String additionalFieldsParams;
    private String accountType;//G-general Account, F-Fixed maturity Account
    
    private String PARAM1_LINK_VALUE;
    private String PARAM2_LINK_VALUE;
    private String PARAM3_LINK_VALUE;
    private String PARAM4_LINK_VALUE;
    private String PARAM5_LINK_VALUE;
    private BigDecimal code ; //additional field code 
     
    private boolean notAllowToLinkOtherFields;

    private String isMoneyLaundring;
    private String depositorFlag;
    private BigDecimal compCodeCif;
    
    private BigDecimal applicationID;//DASI170129
    
    private String elementName;
    
    private BigDecimal linkToOtherTrsNo;
    private BigDecimal linkToOtherTrsBR;
    /**
     * @return the progRef
     */
    public String getProgRef()
    {
        return progRef;
    }

    /**
     * @param progRef the progRef to set
     */
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

    /**
     * @return the isReadOnly
     */
    public Boolean getIsReadOnly()
    {
        return isReadOnly;
    }

    /**
     * @param isReadOnly the isReadOnly to set
     */
    public void setIsReadOnly(Boolean isReadOnly)
    {
        this.isReadOnly = isReadOnly;
    }

    /**
     * @return the typeCode
     */
    public BigDecimal getTypeCode()
    {
        return typeCode;
    }

    /**
     * @param typeCode the typeCode to set
     */
    public void setTypeCode(BigDecimal typeCode)
    {
        this.typeCode = typeCode;
    }

    /**
     * @return the usedFrom
     */
    public String getUsedFrom()
    {
        return usedFrom;
    }

    /**
     * @param usedFrom the usedFrom to set
     */
    public void setUsedFrom(String usedFrom)
    {
        this.usedFrom = usedFrom;
    }

    /**
     * @return the cifNo
     */
    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    /**
     * @param cifNo the cifNo to set
     */
    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    /**
     * @return the entity
     */
    public String getEntity()
    {
        return entity;
    }

    /**
     * @param entity the entity to set
     */
    public void setEntity(String entity)
    {
        this.entity = entity;
    }

    /**
     * @return the entityCode
     */
    public BigDecimal getEntityCode()
    {
        return entityCode;
    }

    /**
     * @param entityCode the entityCode to set
     */
    public void setEntityCode(BigDecimal entityCode)
    {
        this.entityCode = entityCode;
    }

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
     * @return the slNo
     */
    public BigDecimal getSlNo()
    {
        return slNo;
    }

    /**
     * @param slNo the slNo to set
     */
    public void setSlNo(BigDecimal slNo)
    {
        this.slNo = slNo;
    }

    /**
     * @return the iv_crud
     */
    public String getIv_crud()
    {
        return iv_crud;
    }

    /**
     * @param ivCrud the iv_crud to set
     */
    public void setIv_crud(String ivCrud)
    {
        iv_crud = ivCrud;
    }

    /**
     * @return the _pageRef
     */
    public String get_pageRef()
    {
        return _pageRef;
    }

    /**
     * @param pageRef the _pageRef to set
     */
    public void set_pageRef(String pageRef)
    {
        _pageRef = pageRef;
    }

    /**
     * @return the additionalReference
     */
    public BigDecimal getAdditionalReference()
    {
        return additionalReference;
    }

    /**
     * @param additionalReference the additionalReference to set
     */
    public void setAdditionalReference(BigDecimal additionalReference)
    {
        this.additionalReference = additionalReference;
    }

    /**
     * @return the trsNo
     */
    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    /**
     * @param trsNo the trsNo to set
     */
    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    /**
     * @return the additionalFieldsParams
     */
    public String getAdditionalFieldsParams()
    {
        return additionalFieldsParams;
    }

    /**
     * @param additionalFieldsParams the additionalFieldsParams to set
     */
    public void setAdditionalFieldsParams(String additionalFieldsParams)
    {
        this.additionalFieldsParams = additionalFieldsParams;
    }

    /**
     * @return the pARAM1_LINK_VALUE
     */
    public String getPARAM1_LINK_VALUE()
    {
        return PARAM1_LINK_VALUE;
    }

    /**
     * @param pARAM1LINKVALUE the pARAM1_LINK_VALUE to set
     */
    public void setPARAM1_LINK_VALUE(String pARAM1LINKVALUE)
    {
        PARAM1_LINK_VALUE = pARAM1LINKVALUE;
    }

    /**
     * @return the pARAM2_LINK_VALUE
     */
    public String getPARAM2_LINK_VALUE()
    {
        return PARAM2_LINK_VALUE;
    }

    /**
     * @param pARAM2LINKVALUE the pARAM2_LINK_VALUE to set
     */
    public void setPARAM2_LINK_VALUE(String pARAM2LINKVALUE)
    {
        PARAM2_LINK_VALUE = pARAM2LINKVALUE;
    }

    /**
     * @return the pARAM3_LINK_VALUE
     */
    public String getPARAM3_LINK_VALUE()
    {
        return PARAM3_LINK_VALUE;
    }

    /**
     * @param pARAM3LINKVALUE the pARAM3_LINK_VALUE to set
     */
    public void setPARAM3_LINK_VALUE(String pARAM3LINKVALUE)
    {
        PARAM3_LINK_VALUE = pARAM3LINKVALUE;
    }

    /**
     * @return the pARAM4_LINK_VALUE
     */
    public String getPARAM4_LINK_VALUE()
    {
        return PARAM4_LINK_VALUE;
    }

    /**
     * @param pARAM4LINKVALUE the pARAM4_LINK_VALUE to set
     */
    public void setPARAM4_LINK_VALUE(String pARAM4LINKVALUE)
    {
        PARAM4_LINK_VALUE = pARAM4LINKVALUE;
    }

    /**
     * @return the pARAM5_LINK_VALUE
     */
    public String getPARAM5_LINK_VALUE()
    {
        return PARAM5_LINK_VALUE;
    }

    /**
     * @param pARAM5LINKVALUE the pARAM5_LINK_VALUE to set
     */
    public void setPARAM5_LINK_VALUE(String pARAM5LINKVALUE)
    {
        PARAM5_LINK_VALUE = pARAM5LINKVALUE;
    }

    /**
     * @return the notAllowToLinkOtherFields
     */
    public boolean isNotAllowToLinkOtherFields()
    {
        return notAllowToLinkOtherFields;
    }

    /**
     * @param notAllowToLinkOtherFields the notAllowToLinkOtherFields to set
     */
    public void setNotAllowToLinkOtherFields(boolean notAllowToLinkOtherFields)
    {
        this.notAllowToLinkOtherFields = notAllowToLinkOtherFields;
    }

    /**
     * @return the allowToModifyCif
     */
    public String getAllowToModifyCif()
    {
        return allowToModifyCif;
    }

    /**
     * @param allowToModifyCif the allowToModifyCif to set
     */
    public void setAllowToModifyCif(String allowToModifyCif)
    {
        this.allowToModifyCif = allowToModifyCif;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * @return the accountType
     */
    public String getAccountType()
    {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public String getIsMoneyLaundring()
    {
        return isMoneyLaundring;
    }

    public void setIsMoneyLaundring(String isMoneyLaundring)
    {
        this.isMoneyLaundring = isMoneyLaundring;
    }

    public String getDepositorFlag()
    {
        return depositorFlag;
    }

    public void setDepositorFlag(String depositorFlag)
    {
        this.depositorFlag = depositorFlag;
    }

    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }

    public String getElementName()
    {
        return elementName;
    }

    public void setElementName(String elementName)
    {
        this.elementName = elementName;
    }

    public BigDecimal getCode()
    {
        return code;
    }

    public void setCode(BigDecimal code)
    {
        this.code = code;
    }

    public BigDecimal getLinkToOtherTrsNo()
    {
        return linkToOtherTrsNo;
    }

    public void setLinkToOtherTrsNo(BigDecimal linkToOtherTrsNo)
    {
        this.linkToOtherTrsNo = linkToOtherTrsNo;
    }

    public BigDecimal getLinkToOtherTrsBR()
    {
        return linkToOtherTrsBR;
    }

    public void setLinkToOtherTrsBR(BigDecimal linkToOtherTrsBR)
    {
        this.linkToOtherTrsBR = linkToOtherTrsBR;
    }

    public BigDecimal getApplicationID()
    {
        return applicationID;
    }

    public void setApplicationID(BigDecimal applicationID)
    {
        this.applicationID = applicationID;
    }

    
}
