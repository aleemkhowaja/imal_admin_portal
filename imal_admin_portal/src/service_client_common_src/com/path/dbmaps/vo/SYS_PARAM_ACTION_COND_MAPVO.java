package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class SYS_PARAM_ACTION_COND_MAPVO extends SYS_PARAM_ACTION_COND_MAPVOKey {
    /**
     * This field corresponds to the database column SYS_PARAM_ACTION_COND_MAP.RESULT
     */
    private String RESULT;

    /**
     * This field corresponds to the database column SYS_PARAM_ACTION_COND_MAP.RESULT_OP_ID
     */
    private BigDecimal RESULT_OP_ID;

    /**
     * This field corresponds to the database column SYS_PARAM_ACTION_COND_MAP.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column SYS_PARAM_ACTION_COND_MAP.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column SYS_PARAM_ACTION_COND_MAP.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column SYS_PARAM_ACTION_COND_MAP.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_ACTION_COND_MAP.RESULT
     *
     * @return the value of SYS_PARAM_ACTION_COND_MAP.RESULT
     */
    public String getRESULT() {
        return RESULT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_ACTION_COND_MAP.RESULT
     *
     * @param RESULT the value for SYS_PARAM_ACTION_COND_MAP.RESULT
     */
    public void setRESULT(String RESULT) {
        this.RESULT = RESULT == null ? null : RESULT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_ACTION_COND_MAP.RESULT_OP_ID
     *
     * @return the value of SYS_PARAM_ACTION_COND_MAP.RESULT_OP_ID
     */
    public BigDecimal getRESULT_OP_ID() {
        return RESULT_OP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_ACTION_COND_MAP.RESULT_OP_ID
     *
     * @param RESULT_OP_ID the value for SYS_PARAM_ACTION_COND_MAP.RESULT_OP_ID
     */
    public void setRESULT_OP_ID(BigDecimal RESULT_OP_ID) {
        this.RESULT_OP_ID = RESULT_OP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_ACTION_COND_MAP.CREATED_DATE
     *
     * @return the value of SYS_PARAM_ACTION_COND_MAP.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_ACTION_COND_MAP.CREATED_DATE
     *
     * @param CREATED_DATE the value for SYS_PARAM_ACTION_COND_MAP.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_ACTION_COND_MAP.MODIFIED_BY
     *
     * @return the value of SYS_PARAM_ACTION_COND_MAP.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_ACTION_COND_MAP.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for SYS_PARAM_ACTION_COND_MAP.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_ACTION_COND_MAP.CREATED_BY
     *
     * @return the value of SYS_PARAM_ACTION_COND_MAP.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_ACTION_COND_MAP.CREATED_BY
     *
     * @param CREATED_BY the value for SYS_PARAM_ACTION_COND_MAP.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_ACTION_COND_MAP.MODIFIED_DATE
     *
     * @return the value of SYS_PARAM_ACTION_COND_MAP.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_ACTION_COND_MAP.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for SYS_PARAM_ACTION_COND_MAP.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }
}