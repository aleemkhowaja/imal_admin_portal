package com.path.dbmaps.vo;

import java.util.Date;

public class CTSTRS_PROVIDER_INFOVO extends CTSTRS_PROVIDER_INFOVOKey {
    /**
     * This field corresponds to the database column CTSTRS_PROVIDER_INFO.FIELD_NAME
     */
    private String FIELD_NAME;

    /**
     * This field corresponds to the database column CTSTRS_PROVIDER_INFO.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This field corresponds to the database column CTSTRS_PROVIDER_INFO.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column CTSTRS_PROVIDER_INFO.FIELD_VALUE
     */
    private String FIELD_VALUE;

    /**
     * This field corresponds to the database column CTSTRS_PROVIDER_INFO.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column CTSTRS_PROVIDER_INFO.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_PROVIDER_INFO.FIELD_NAME
     *
     * @return the value of CTSTRS_PROVIDER_INFO.FIELD_NAME
     */
    public String getFIELD_NAME() {
        return FIELD_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_PROVIDER_INFO.FIELD_NAME
     *
     * @param FIELD_NAME the value for CTSTRS_PROVIDER_INFO.FIELD_NAME
     */
    public void setFIELD_NAME(String FIELD_NAME) {
        this.FIELD_NAME = FIELD_NAME == null ? null : FIELD_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_PROVIDER_INFO.MODIFIED_DATE
     *
     * @return the value of CTSTRS_PROVIDER_INFO.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_PROVIDER_INFO.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for CTSTRS_PROVIDER_INFO.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_PROVIDER_INFO.MODIFIED_BY
     *
     * @return the value of CTSTRS_PROVIDER_INFO.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_PROVIDER_INFO.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for CTSTRS_PROVIDER_INFO.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_PROVIDER_INFO.FIELD_VALUE
     *
     * @return the value of CTSTRS_PROVIDER_INFO.FIELD_VALUE
     */
    public String getFIELD_VALUE() {
        return FIELD_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_PROVIDER_INFO.FIELD_VALUE
     *
     * @param FIELD_VALUE the value for CTSTRS_PROVIDER_INFO.FIELD_VALUE
     */
    public void setFIELD_VALUE(String FIELD_VALUE) {
        this.FIELD_VALUE = FIELD_VALUE == null ? null : FIELD_VALUE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_PROVIDER_INFO.CREATED_DATE
     *
     * @return the value of CTSTRS_PROVIDER_INFO.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_PROVIDER_INFO.CREATED_DATE
     *
     * @param CREATED_DATE the value for CTSTRS_PROVIDER_INFO.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_PROVIDER_INFO.CREATED_BY
     *
     * @return the value of CTSTRS_PROVIDER_INFO.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_PROVIDER_INFO.CREATED_BY
     *
     * @param CREATED_BY the value for CTSTRS_PROVIDER_INFO.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }
}