/**
 * 
 */
package com.path.vo.common.smart;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * SObjectDetailVO.java used to
 */
public class SObjectDetailVO extends BaseVO
{
    private byte[] externalFile;
    private BigDecimal additionNumber;
    private BigDecimal optionType;
    private BigDecimal addTypeCode;
    
    //ENH 519846 set variable to media (DB (D), default directory (F) or web service directory (W)) where to save the uploaded file, 
    //and the default directory (FIXED_LOCATION)
    private String saveToMedia;
    private String saveToDestination;
    private String originalFileName;
    private String isThirdPartyManaged; 
    
    /**
     * @return the externalFile
     */
    public byte[] getExternalFile()
    {
        return externalFile;
    }
    /**
     * @param externalFile the externalFile to set
     */
    public void setExternalFile(byte[] externalFile)
    {
        this.externalFile = externalFile;
    }
    /**
     * @return the additionNumber
     */
    public BigDecimal getAdditionNumber()
    {
        return additionNumber;
    }
    /**
     * @param additionNumber the additionNumber to set
     */
    public void setAdditionNumber(BigDecimal additionNumber)
    {
        this.additionNumber = additionNumber;
    }
    /**
     * @return the optionType
     */
    public BigDecimal getOptionType()
    {
        return optionType;
    }
    /**
     * @param optionType the optionType to set
     */
    public void setOptionType(BigDecimal optionType)
    {
        this.optionType = optionType;
    }
    /**
     * @return the addTypeCode
     */
    public BigDecimal getAddTypeCode()
    {
        return addTypeCode;
    }
    /**
     * @param addTypeCode the addTypeCode to set
     */
    public void setAddTypeCode(BigDecimal addTypeCode)
    {
        this.addTypeCode = addTypeCode;
    }
    public String getSaveToDestination()
    {
        return saveToDestination;
    }
    public void setSaveToDestination(String saveToDestination)
    {
        this.saveToDestination = saveToDestination;
    }
    public String getSaveToMedia()
    {
        return saveToMedia;
    }
    public void setSaveToMedia(String saveToMedia)
    {
        this.saveToMedia = saveToMedia;
    }
    public String getOriginalFileName()
    {
	return originalFileName;
    }
    public void setOriginalFileName(String originalFileName)
    {
	this.originalFileName = originalFileName;
    }

    public String getIsThirdPartyManaged()
    {
        return isThirdPartyManaged;
    }
    
    public void setIsThirdPartyManaged(String isThirdPartyManaged)
    {
        this.isThirdPartyManaged = isThirdPartyManaged;
    }
}
