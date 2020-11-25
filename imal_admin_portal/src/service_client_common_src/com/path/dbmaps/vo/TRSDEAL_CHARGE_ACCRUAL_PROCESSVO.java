package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRSDEAL_CHARGE_ACCRUAL_PROCESSVO extends TRSDEAL_CHARGE_ACCRUAL_PROCESSVOKey {
    /**
     * This field corresponds to the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESS_DATE
     */
    private Date PROCESS_DATE;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESSED_BY
     */
    private String PROCESSED_BY;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.OUTSTANDING_AMOUNT
     */
    private BigDecimal OUTSTANDING_AMOUNT;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.ACCRUED_AMOUNT_FC
     */
    private BigDecimal ACCRUED_AMOUNT_FC;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.ACCRUED_AMOUNT_CV
     */
    private BigDecimal ACCRUED_AMOUNT_CV;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESS_IND
     */
    private String PROCESS_IND;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.SETTLEMENT_NO
     */
    private BigDecimal SETTLEMENT_NO;

    /**
     * This field corresponds to the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.STATUS
     */
    private String STATUS;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESS_DATE
     *
     * @return the value of TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESS_DATE
     */
    public Date getPROCESS_DATE() {
        return PROCESS_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESS_DATE
     *
     * @param PROCESS_DATE the value for TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESS_DATE
     */
    public void setPROCESS_DATE(Date PROCESS_DATE) {
        this.PROCESS_DATE = PROCESS_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESSED_BY
     *
     * @return the value of TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESSED_BY
     */
    public String getPROCESSED_BY() {
        return PROCESSED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESSED_BY
     *
     * @param PROCESSED_BY the value for TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESSED_BY
     */
    public void setPROCESSED_BY(String PROCESSED_BY) {
        this.PROCESSED_BY = PROCESSED_BY == null ? null : PROCESSED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.OUTSTANDING_AMOUNT
     *
     * @return the value of TRSDEAL_CHARGE_ACCRUAL_PROCESS.OUTSTANDING_AMOUNT
     */
    public BigDecimal getOUTSTANDING_AMOUNT() {
        return OUTSTANDING_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.OUTSTANDING_AMOUNT
     *
     * @param OUTSTANDING_AMOUNT the value for TRSDEAL_CHARGE_ACCRUAL_PROCESS.OUTSTANDING_AMOUNT
     */
    public void setOUTSTANDING_AMOUNT(BigDecimal OUTSTANDING_AMOUNT) {
        this.OUTSTANDING_AMOUNT = OUTSTANDING_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.ACCRUED_AMOUNT_FC
     *
     * @return the value of TRSDEAL_CHARGE_ACCRUAL_PROCESS.ACCRUED_AMOUNT_FC
     */
    public BigDecimal getACCRUED_AMOUNT_FC() {
        return ACCRUED_AMOUNT_FC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.ACCRUED_AMOUNT_FC
     *
     * @param ACCRUED_AMOUNT_FC the value for TRSDEAL_CHARGE_ACCRUAL_PROCESS.ACCRUED_AMOUNT_FC
     */
    public void setACCRUED_AMOUNT_FC(BigDecimal ACCRUED_AMOUNT_FC) {
        this.ACCRUED_AMOUNT_FC = ACCRUED_AMOUNT_FC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.ACCRUED_AMOUNT_CV
     *
     * @return the value of TRSDEAL_CHARGE_ACCRUAL_PROCESS.ACCRUED_AMOUNT_CV
     */
    public BigDecimal getACCRUED_AMOUNT_CV() {
        return ACCRUED_AMOUNT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.ACCRUED_AMOUNT_CV
     *
     * @param ACCRUED_AMOUNT_CV the value for TRSDEAL_CHARGE_ACCRUAL_PROCESS.ACCRUED_AMOUNT_CV
     */
    public void setACCRUED_AMOUNT_CV(BigDecimal ACCRUED_AMOUNT_CV) {
        this.ACCRUED_AMOUNT_CV = ACCRUED_AMOUNT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESS_IND
     *
     * @return the value of TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESS_IND
     */
    public String getPROCESS_IND() {
        return PROCESS_IND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESS_IND
     *
     * @param PROCESS_IND the value for TRSDEAL_CHARGE_ACCRUAL_PROCESS.PROCESS_IND
     */
    public void setPROCESS_IND(String PROCESS_IND) {
        this.PROCESS_IND = PROCESS_IND == null ? null : PROCESS_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.SETTLEMENT_NO
     *
     * @return the value of TRSDEAL_CHARGE_ACCRUAL_PROCESS.SETTLEMENT_NO
     */
    public BigDecimal getSETTLEMENT_NO() {
        return SETTLEMENT_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.SETTLEMENT_NO
     *
     * @param SETTLEMENT_NO the value for TRSDEAL_CHARGE_ACCRUAL_PROCESS.SETTLEMENT_NO
     */
    public void setSETTLEMENT_NO(BigDecimal SETTLEMENT_NO) {
        this.SETTLEMENT_NO = SETTLEMENT_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.STATUS
     *
     * @return the value of TRSDEAL_CHARGE_ACCRUAL_PROCESS.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_CHARGE_ACCRUAL_PROCESS.STATUS
     *
     * @param STATUS the value for TRSDEAL_CHARGE_ACCRUAL_PROCESS.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }
}