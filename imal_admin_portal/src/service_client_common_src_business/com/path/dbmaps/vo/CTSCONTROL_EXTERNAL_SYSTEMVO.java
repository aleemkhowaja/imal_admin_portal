package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CTSCONTROL_EXTERNAL_SYSTEMVO extends CTSCONTROL_EXTERNAL_SYSTEMVOKey {
    /**
     * This field corresponds to the database column CTSCONTROL_EXTERNAL_SYSTEM.EXTERNAL_SYSTEM_URL
     */
    private String EXTERNAL_SYSTEM_URL;

    /**
     * This field corresponds to the database column CTSCONTROL_EXTERNAL_SYSTEM.RESPONSE_TIME_LIMIT
     */
    private BigDecimal RESPONSE_TIME_LIMIT;

    /**
     * This field corresponds to the database column CTSCONTROL_EXTERNAL_SYSTEM.OUT_REQUEST_NBR
     */
    private BigDecimal OUT_REQUEST_NBR;

    /**
     * This field corresponds to the database column CTSCONTROL_EXTERNAL_SYSTEM.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column CTSCONTROL_EXTERNAL_SYSTEM.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column CTSCONTROL_EXTERNAL_SYSTEM.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column CTSCONTROL_EXTERNAL_SYSTEM.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.EXTERNAL_SYSTEM_URL
     *
     * @return the value of CTSCONTROL_EXTERNAL_SYSTEM.EXTERNAL_SYSTEM_URL
     */
    public String getEXTERNAL_SYSTEM_URL() {
        return EXTERNAL_SYSTEM_URL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.EXTERNAL_SYSTEM_URL
     *
     * @param EXTERNAL_SYSTEM_URL the value for CTSCONTROL_EXTERNAL_SYSTEM.EXTERNAL_SYSTEM_URL
     */
    public void setEXTERNAL_SYSTEM_URL(String EXTERNAL_SYSTEM_URL) {
        this.EXTERNAL_SYSTEM_URL = EXTERNAL_SYSTEM_URL == null ? null : EXTERNAL_SYSTEM_URL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.RESPONSE_TIME_LIMIT
     *
     * @return the value of CTSCONTROL_EXTERNAL_SYSTEM.RESPONSE_TIME_LIMIT
     */
    public BigDecimal getRESPONSE_TIME_LIMIT() {
        return RESPONSE_TIME_LIMIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.RESPONSE_TIME_LIMIT
     *
     * @param RESPONSE_TIME_LIMIT the value for CTSCONTROL_EXTERNAL_SYSTEM.RESPONSE_TIME_LIMIT
     */
    public void setRESPONSE_TIME_LIMIT(BigDecimal RESPONSE_TIME_LIMIT) {
        this.RESPONSE_TIME_LIMIT = RESPONSE_TIME_LIMIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.OUT_REQUEST_NBR
     *
     * @return the value of CTSCONTROL_EXTERNAL_SYSTEM.OUT_REQUEST_NBR
     */
    public BigDecimal getOUT_REQUEST_NBR() {
        return OUT_REQUEST_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.OUT_REQUEST_NBR
     *
     * @param OUT_REQUEST_NBR the value for CTSCONTROL_EXTERNAL_SYSTEM.OUT_REQUEST_NBR
     */
    public void setOUT_REQUEST_NBR(BigDecimal OUT_REQUEST_NBR) {
        this.OUT_REQUEST_NBR = OUT_REQUEST_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.CREATED_BY
     *
     * @return the value of CTSCONTROL_EXTERNAL_SYSTEM.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.CREATED_BY
     *
     * @param CREATED_BY the value for CTSCONTROL_EXTERNAL_SYSTEM.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.CREATED_DATE
     *
     * @return the value of CTSCONTROL_EXTERNAL_SYSTEM.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.CREATED_DATE
     *
     * @param CREATED_DATE the value for CTSCONTROL_EXTERNAL_SYSTEM.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.MODIFIED_BY
     *
     * @return the value of CTSCONTROL_EXTERNAL_SYSTEM.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for CTSCONTROL_EXTERNAL_SYSTEM.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.MODIFIED_DATE
     *
     * @return the value of CTSCONTROL_EXTERNAL_SYSTEM.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCONTROL_EXTERNAL_SYSTEM.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for CTSCONTROL_EXTERNAL_SYSTEM.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }
}