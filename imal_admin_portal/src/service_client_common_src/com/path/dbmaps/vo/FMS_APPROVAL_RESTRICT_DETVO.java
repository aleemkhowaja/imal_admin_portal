package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class FMS_APPROVAL_RESTRICT_DETVO extends FMS_APPROVAL_RESTRICT_DETVOKey {
    /**
     * This field corresponds to the database column FMS_APPROVAL_RESTRICT_DET.SUSPEND_REASON
     */
    private BigDecimal SUSPEND_REASON;

    /**
     * This field corresponds to the database column FMS_APPROVAL_RESTRICT_DET.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column FMS_APPROVAL_RESTRICT_DET.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column FMS_APPROVAL_RESTRICT_DET.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column FMS_APPROVAL_RESTRICT_DET.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_APPROVAL_RESTRICT_DET.SUSPEND_REASON
     *
     * @return the value of FMS_APPROVAL_RESTRICT_DET.SUSPEND_REASON
     */
    public BigDecimal getSUSPEND_REASON() {
        return SUSPEND_REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_APPROVAL_RESTRICT_DET.SUSPEND_REASON
     *
     * @param SUSPEND_REASON the value for FMS_APPROVAL_RESTRICT_DET.SUSPEND_REASON
     */
    public void setSUSPEND_REASON(BigDecimal SUSPEND_REASON) {
        this.SUSPEND_REASON = SUSPEND_REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_APPROVAL_RESTRICT_DET.CREATED_BY
     *
     * @return the value of FMS_APPROVAL_RESTRICT_DET.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_APPROVAL_RESTRICT_DET.CREATED_BY
     *
     * @param CREATED_BY the value for FMS_APPROVAL_RESTRICT_DET.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_APPROVAL_RESTRICT_DET.CREATED_DATE
     *
     * @return the value of FMS_APPROVAL_RESTRICT_DET.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_APPROVAL_RESTRICT_DET.CREATED_DATE
     *
     * @param CREATED_DATE the value for FMS_APPROVAL_RESTRICT_DET.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_APPROVAL_RESTRICT_DET.MODIFIED_BY
     *
     * @return the value of FMS_APPROVAL_RESTRICT_DET.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_APPROVAL_RESTRICT_DET.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for FMS_APPROVAL_RESTRICT_DET.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_APPROVAL_RESTRICT_DET.MODIFIED_DATE
     *
     * @return the value of FMS_APPROVAL_RESTRICT_DET.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_APPROVAL_RESTRICT_DET.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for FMS_APPROVAL_RESTRICT_DET.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }
}