package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRS_EMAIL_DETAILSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRS_EMAIL_DETAILS.APP_NAME
     */
    private String APP_NAME;

    /**
     * This field corresponds to the database column TRS_EMAIL_DETAILS.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRS_EMAIL_DETAILS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRS_EMAIL_DETAILS.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column TRS_EMAIL_DETAILS.WINDOW_REFERENCE
     */
    private String WINDOW_REFERENCE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_EMAIL_DETAILS.APP_NAME
     *
     * @return the value of TRS_EMAIL_DETAILS.APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_EMAIL_DETAILS.APP_NAME
     *
     * @param APP_NAME the value for TRS_EMAIL_DETAILS.APP_NAME
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME == null ? null : APP_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_EMAIL_DETAILS.BRANCH_CODE
     *
     * @return the value of TRS_EMAIL_DETAILS.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_EMAIL_DETAILS.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRS_EMAIL_DETAILS.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_EMAIL_DETAILS.COMP_CODE
     *
     * @return the value of TRS_EMAIL_DETAILS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_EMAIL_DETAILS.COMP_CODE
     *
     * @param COMP_CODE the value for TRS_EMAIL_DETAILS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_EMAIL_DETAILS.LINE_NO
     *
     * @return the value of TRS_EMAIL_DETAILS.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_EMAIL_DETAILS.LINE_NO
     *
     * @param LINE_NO the value for TRS_EMAIL_DETAILS.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_EMAIL_DETAILS.WINDOW_REFERENCE
     *
     * @return the value of TRS_EMAIL_DETAILS.WINDOW_REFERENCE
     */
    public String getWINDOW_REFERENCE() {
        return WINDOW_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_EMAIL_DETAILS.WINDOW_REFERENCE
     *
     * @param WINDOW_REFERENCE the value for TRS_EMAIL_DETAILS.WINDOW_REFERENCE
     */
    public void setWINDOW_REFERENCE(String WINDOW_REFERENCE) {
        this.WINDOW_REFERENCE = WINDOW_REFERENCE == null ? null : WINDOW_REFERENCE.trim();
    }
}