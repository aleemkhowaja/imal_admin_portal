package com.path.vo.common;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: deniskhaddad
 *
 * TechFieldsDetailsCO.java used to extend the SYS_PARAM_SCREEN_DISPLAY VO to include the Technical details of Each Field
 */
public class TechFieldsDetailsCO extends BaseVO
{
    /**
     * This field corresponds to the database column FIELD_TECH_DETAILS.ELEMENT_NAME
     */
    private String ELEMENT_NAME;
    /**
     * This field corresponds to the database column FIELD_TECH_DETAILS.VO_CO_REFERENCE
     */
    private String VO_CO_REFERENCE;

    /**
     * This field corresponds to the database column FIELD_TECH_DETAILS.VO_PROPERTY_NAME
     */
    private String VO_PROPERTY_NAME;
    /**
     * This field corresponds to the database column FIELD_TECH_DETAILS.PB_FIELD_NAME
     */
    private String PB_FIELD_NAME;
    /**
     * This field corresponds to the database column FIELD_TECH_DETAILS.ELEMENT_ID
     */
    private String ELEMENT_ID;
    
    private BigDecimal LEAD_ZEROS;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FIELD_TECH_DETAILS.ELEMENT_NAME
     *
     * @return the value of FIELD_TECH_DETAILS.ELEMENT_NAME
     */
    public String getELEMENT_NAME() {
        return ELEMENT_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FIELD_TECH_DETAILS.ELEMENT_NAME
     *
     * @param ELEMENT_NAME the value for FIELD_TECH_DETAILS.ELEMENT_NAME
     */
    public void setELEMENT_NAME(String ELEMENT_NAME) {
        this.ELEMENT_NAME = ELEMENT_NAME == null ? null : ELEMENT_NAME.trim();
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SFIELD_TECH_DETAILS.VO_CO_REFERENCE
     *
     * @return the value of FIELD_TECH_DETAILS.VO_CO_REFERENCE
     */
    public String getVO_CO_REFERENCE() {
        return VO_CO_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FIELD_TECH_DETAILS.VO_CO_REFERENCE
     *
     * @param VO_CO_REFERENCE the value for FIELD_TECH_DETAILS.VO_CO_REFERENCE
     */
    public void setVO_CO_REFERENCE(String VO_CO_REFERENCE) {
        this.VO_CO_REFERENCE = VO_CO_REFERENCE == null ? null : VO_CO_REFERENCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FIELD_TECH_DETAILS.VO_PROPERTY_NAME
     *
     * @return the value of FIELD_TECH_DETAILS.VO_PROPERTY_NAME
     */
    public String getVO_PROPERTY_NAME() {
        return VO_PROPERTY_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FIELD_TECH_DETAILS.VO_PROPERTY_NAME
     *
     * @param VO_PROPERTY_NAME the value for FIELD_TECH_DETAILS.VO_PROPERTY_NAME
     */
    public void setVO_PROPERTY_NAME(String VO_PROPERTY_NAME) {
        this.VO_PROPERTY_NAME = VO_PROPERTY_NAME == null ? null : VO_PROPERTY_NAME.trim();
    }

    public String getPB_FIELD_NAME()
    {
        return PB_FIELD_NAME;
    }

    public void setPB_FIELD_NAME(String pBFIELDNAME)
    {
        PB_FIELD_NAME = pBFIELDNAME;
    }

    public String getELEMENT_ID()
    {
        return ELEMENT_ID;
    }

    public void setELEMENT_ID(String eLEMENTID)
    {
        ELEMENT_ID = eLEMENTID;
    }

    public BigDecimal getLEAD_ZEROS()
    {
        return LEAD_ZEROS;
    }

    public void setLEAD_ZEROS(BigDecimal lEADZEROS)
    {
        LEAD_ZEROS = lEADZEROS;
    }
}