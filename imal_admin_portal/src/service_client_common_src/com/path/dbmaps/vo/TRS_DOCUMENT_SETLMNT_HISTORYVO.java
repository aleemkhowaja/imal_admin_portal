package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRS_DOCUMENT_SETLMNT_HISTORYVO extends TRS_DOCUMENT_SETLMNT_HISTORYVOKey {
    /**
     * This field corresponds to the database column TRS_DOCUMENT_SETLMNT_HISTORY.SETTLEMENT_NO
     */
    private BigDecimal SETTLEMENT_NO;

    /**
     * This field corresponds to the database column TRS_DOCUMENT_SETLMNT_HISTORY.DEAL_NO
     */
    private BigDecimal DEAL_NO;

    /**
     * This field corresponds to the database column TRS_DOCUMENT_SETLMNT_HISTORY.AMOUNT_SETTLED
     */
    private BigDecimal AMOUNT_SETTLED;

    /**
     * This field corresponds to the database column TRS_DOCUMENT_SETLMNT_HISTORY.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column TRS_DOCUMENT_SETLMNT_HISTORY.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column TRS_DOCUMENT_SETLMNT_HISTORY.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column TRS_DOCUMENT_SETLMNT_HISTORY.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.SETTLEMENT_NO
     *
     * @return the value of TRS_DOCUMENT_SETLMNT_HISTORY.SETTLEMENT_NO
     */
    public BigDecimal getSETTLEMENT_NO() {
        return SETTLEMENT_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.SETTLEMENT_NO
     *
     * @param SETTLEMENT_NO the value for TRS_DOCUMENT_SETLMNT_HISTORY.SETTLEMENT_NO
     */
    public void setSETTLEMENT_NO(BigDecimal SETTLEMENT_NO) {
        this.SETTLEMENT_NO = SETTLEMENT_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.DEAL_NO
     *
     * @return the value of TRS_DOCUMENT_SETLMNT_HISTORY.DEAL_NO
     */
    public BigDecimal getDEAL_NO() {
        return DEAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.DEAL_NO
     *
     * @param DEAL_NO the value for TRS_DOCUMENT_SETLMNT_HISTORY.DEAL_NO
     */
    public void setDEAL_NO(BigDecimal DEAL_NO) {
        this.DEAL_NO = DEAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.AMOUNT_SETTLED
     *
     * @return the value of TRS_DOCUMENT_SETLMNT_HISTORY.AMOUNT_SETTLED
     */
    public BigDecimal getAMOUNT_SETTLED() {
        return AMOUNT_SETTLED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.AMOUNT_SETTLED
     *
     * @param AMOUNT_SETTLED the value for TRS_DOCUMENT_SETLMNT_HISTORY.AMOUNT_SETTLED
     */
    public void setAMOUNT_SETTLED(BigDecimal AMOUNT_SETTLED) {
        this.AMOUNT_SETTLED = AMOUNT_SETTLED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.CREATED_BY
     *
     * @return the value of TRS_DOCUMENT_SETLMNT_HISTORY.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.CREATED_BY
     *
     * @param CREATED_BY the value for TRS_DOCUMENT_SETLMNT_HISTORY.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.CREATED_DATE
     *
     * @return the value of TRS_DOCUMENT_SETLMNT_HISTORY.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.CREATED_DATE
     *
     * @param CREATED_DATE the value for TRS_DOCUMENT_SETLMNT_HISTORY.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.MODIFIED_BY
     *
     * @return the value of TRS_DOCUMENT_SETLMNT_HISTORY.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for TRS_DOCUMENT_SETLMNT_HISTORY.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.MODIFIED_DATE
     *
     * @return the value of TRS_DOCUMENT_SETLMNT_HISTORY.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DOCUMENT_SETLMNT_HISTORY.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for TRS_DOCUMENT_SETLMNT_HISTORY.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }
}