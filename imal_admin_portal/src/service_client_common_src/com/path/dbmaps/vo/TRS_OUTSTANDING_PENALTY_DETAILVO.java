package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class TRS_OUTSTANDING_PENALTY_DETAILVO extends TRS_OUTSTANDING_PENALTY_DETAILVOKey {
    /**
     * This field corresponds to the database column TRS_OUTSTANDING_PENALTY_DETAIL.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column TRS_OUTSTANDING_PENALTY_DETAIL.DEAL_NBR
     */
    private BigDecimal DEAL_NBR;

    /**
     * This field corresponds to the database column TRS_OUTSTANDING_PENALTY_DETAIL.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column TRS_OUTSTANDING_PENALTY_DETAIL.SETTLEMENT_NBR
     */
    private BigDecimal SETTLEMENT_NBR;

    /**
     * This field corresponds to the database column TRS_OUTSTANDING_PENALTY_DETAIL.PENALTY_AMOUNT
     */
    private BigDecimal PENALTY_AMOUNT;

    /**
     * This field corresponds to the database column TRS_OUTSTANDING_PENALTY_DETAIL.SETTLED_AMOUNT
     */
    private BigDecimal SETTLED_AMOUNT;

    /**
     * This field corresponds to the database column TRS_OUTSTANDING_PENALTY_DETAIL.WAIVED_AMOUNT
     */
    private BigDecimal WAIVED_AMOUNT;

    /**
     * This field corresponds to the database column TRS_OUTSTANDING_PENALTY_DETAIL.BLOCKED_AMOUNT
     */
    private BigDecimal BLOCKED_AMOUNT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.STATUS
     *
     * @return the value of TRS_OUTSTANDING_PENALTY_DETAIL.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.STATUS
     *
     * @param STATUS the value for TRS_OUTSTANDING_PENALTY_DETAIL.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.DEAL_NBR
     *
     * @return the value of TRS_OUTSTANDING_PENALTY_DETAIL.DEAL_NBR
     */
    public BigDecimal getDEAL_NBR() {
        return DEAL_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.DEAL_NBR
     *
     * @param DEAL_NBR the value for TRS_OUTSTANDING_PENALTY_DETAIL.DEAL_NBR
     */
    public void setDEAL_NBR(BigDecimal DEAL_NBR) {
        this.DEAL_NBR = DEAL_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.CIF_NO
     *
     * @return the value of TRS_OUTSTANDING_PENALTY_DETAIL.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.CIF_NO
     *
     * @param CIF_NO the value for TRS_OUTSTANDING_PENALTY_DETAIL.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.SETTLEMENT_NBR
     *
     * @return the value of TRS_OUTSTANDING_PENALTY_DETAIL.SETTLEMENT_NBR
     */
    public BigDecimal getSETTLEMENT_NBR() {
        return SETTLEMENT_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.SETTLEMENT_NBR
     *
     * @param SETTLEMENT_NBR the value for TRS_OUTSTANDING_PENALTY_DETAIL.SETTLEMENT_NBR
     */
    public void setSETTLEMENT_NBR(BigDecimal SETTLEMENT_NBR) {
        this.SETTLEMENT_NBR = SETTLEMENT_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.PENALTY_AMOUNT
     *
     * @return the value of TRS_OUTSTANDING_PENALTY_DETAIL.PENALTY_AMOUNT
     */
    public BigDecimal getPENALTY_AMOUNT() {
        return PENALTY_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.PENALTY_AMOUNT
     *
     * @param PENALTY_AMOUNT the value for TRS_OUTSTANDING_PENALTY_DETAIL.PENALTY_AMOUNT
     */
    public void setPENALTY_AMOUNT(BigDecimal PENALTY_AMOUNT) {
        this.PENALTY_AMOUNT = PENALTY_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.SETTLED_AMOUNT
     *
     * @return the value of TRS_OUTSTANDING_PENALTY_DETAIL.SETTLED_AMOUNT
     */
    public BigDecimal getSETTLED_AMOUNT() {
        return SETTLED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.SETTLED_AMOUNT
     *
     * @param SETTLED_AMOUNT the value for TRS_OUTSTANDING_PENALTY_DETAIL.SETTLED_AMOUNT
     */
    public void setSETTLED_AMOUNT(BigDecimal SETTLED_AMOUNT) {
        this.SETTLED_AMOUNT = SETTLED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.WAIVED_AMOUNT
     *
     * @return the value of TRS_OUTSTANDING_PENALTY_DETAIL.WAIVED_AMOUNT
     */
    public BigDecimal getWAIVED_AMOUNT() {
        return WAIVED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.WAIVED_AMOUNT
     *
     * @param WAIVED_AMOUNT the value for TRS_OUTSTANDING_PENALTY_DETAIL.WAIVED_AMOUNT
     */
    public void setWAIVED_AMOUNT(BigDecimal WAIVED_AMOUNT) {
        this.WAIVED_AMOUNT = WAIVED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.BLOCKED_AMOUNT
     *
     * @return the value of TRS_OUTSTANDING_PENALTY_DETAIL.BLOCKED_AMOUNT
     */
    public BigDecimal getBLOCKED_AMOUNT() {
        return BLOCKED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_OUTSTANDING_PENALTY_DETAIL.BLOCKED_AMOUNT
     *
     * @param BLOCKED_AMOUNT the value for TRS_OUTSTANDING_PENALTY_DETAIL.BLOCKED_AMOUNT
     */
    public void setBLOCKED_AMOUNT(BigDecimal BLOCKED_AMOUNT) {
        this.BLOCKED_AMOUNT = BLOCKED_AMOUNT;
    }
}