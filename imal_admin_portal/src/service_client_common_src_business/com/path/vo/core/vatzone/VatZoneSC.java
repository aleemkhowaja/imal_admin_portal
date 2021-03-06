package com.path.vo.core.vatzone;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Raees
 * 
 *          VatCodeSC.java used to
 */
public class VatZoneSC extends GridParamsSC
{
    private BigDecimal zoneCode;
    private BigDecimal code;
    private String genFacilityType;
    private BigDecimal classType;
    private String PERCENTAGE_IND;

    public BigDecimal getZoneCode()
    {
	return zoneCode;
    }

    public void setZoneCode(BigDecimal zoneCode)
    {
	this.zoneCode = zoneCode;
    }

    /**
     * @return the code
     */
    public BigDecimal getCode()
    {
	return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(BigDecimal code)
    {
	this.code = code;
    }

    /**
     * @return the genFacilityType
     */
    public String getGenFacilityType()
    {
	return genFacilityType;
    }

    /**
     * @param genFacilityType the genFacilityType to set
     */
    public void setGenFacilityType(String genFacilityType)
    {
	this.genFacilityType = genFacilityType;
    }

    /**
     * @return the classType
     */
    public BigDecimal getClassType()
    {
	return classType;
    }

    /**
     * @param classType the classType to set
     */
    public void setClassType(BigDecimal classType)
    {
	this.classType = classType;
    }

    public String getPERCENTAGE_IND()
    {
	return PERCENTAGE_IND;
    }

    public void setPERCENTAGE_IND(String pERCENTAGEIND)
    {
	PERCENTAGE_IND = pERCENTAGEIND;
    }

}
