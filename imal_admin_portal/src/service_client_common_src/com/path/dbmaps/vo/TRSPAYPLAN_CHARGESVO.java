package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRSPAYPLAN_CHARGESVO extends TRSPAYPLAN_CHARGESVOKey {
    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.TRACK_NBR
     */
    private BigDecimal TRACK_NBR;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.TRACK_CHARGES_LINE_NBR
     */
    private BigDecimal TRACK_CHARGES_LINE_NBR;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.CHARGE_CODE
     */
    private BigDecimal CHARGE_CODE;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.AMOUNT
     */
    private BigDecimal AMOUNT;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.DR_ACC_BR
     */
    private BigDecimal DR_ACC_BR;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.DR_ACC_CY
     */
    private BigDecimal DR_ACC_CY;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.DR_ACC_GL
     */
    private BigDecimal DR_ACC_GL;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.DR_ACC_CIF
     */
    private BigDecimal DR_ACC_CIF;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.DR_ACC_SL
     */
    private BigDecimal DR_ACC_SL;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.CR_ACC_BR
     */
    private BigDecimal CR_ACC_BR;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.CR_ACC_CY
     */
    private BigDecimal CR_ACC_CY;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.CR_ACC_GL
     */
    private BigDecimal CR_ACC_GL;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.CR_ACC_CIF
     */
    private BigDecimal CR_ACC_CIF;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.CR_ACC_SL
     */
    private BigDecimal CR_ACC_SL;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.ACTION_TYPE
     */
    private String ACTION_TYPE;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.BLOCKED_AMT_CV
     */
    private BigDecimal BLOCKED_AMT_CV;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.BLOCKED_AMT_FC
     */
    private BigDecimal BLOCKED_AMT_FC;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.BLOCK_PROCESS_DATE
     */
    private Date BLOCK_PROCESS_DATE;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.CHARGES_AMT_CV
     */
    private BigDecimal CHARGES_AMT_CV;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.CHARGES_AMT_FC
     */
    private BigDecimal CHARGES_AMT_FC;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.CHARGES_EXCH_RATE
     */
    private BigDecimal CHARGES_EXCH_RATE;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.CHARGES_MULTDIV
     */
    private String CHARGES_MULTDIV;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.CHARGES_PERCENTAGE
     */
    private BigDecimal CHARGES_PERCENTAGE;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.POSTED_YN
     */
    private String POSTED_YN;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.REVERSE_CHARGE_YN
     */
    private String REVERSE_CHARGE_YN;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.VALUE_DATE
     */
    private Date VALUE_DATE;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.VAT_CODE
     */
    private BigDecimal VAT_CODE;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CHARGES.CHARGES_REVERSED_AMOUNT
     */
    private BigDecimal CHARGES_REVERSED_AMOUNT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.TRACK_NBR
     *
     * @return the value of TRSPAYPLAN_CHARGES.TRACK_NBR
     */
    public BigDecimal getTRACK_NBR() {
        return TRACK_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.TRACK_NBR
     *
     * @param TRACK_NBR the value for TRSPAYPLAN_CHARGES.TRACK_NBR
     */
    public void setTRACK_NBR(BigDecimal TRACK_NBR) {
        this.TRACK_NBR = TRACK_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.TRACK_CHARGES_LINE_NBR
     *
     * @return the value of TRSPAYPLAN_CHARGES.TRACK_CHARGES_LINE_NBR
     */
    public BigDecimal getTRACK_CHARGES_LINE_NBR() {
        return TRACK_CHARGES_LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.TRACK_CHARGES_LINE_NBR
     *
     * @param TRACK_CHARGES_LINE_NBR the value for TRSPAYPLAN_CHARGES.TRACK_CHARGES_LINE_NBR
     */
    public void setTRACK_CHARGES_LINE_NBR(BigDecimal TRACK_CHARGES_LINE_NBR) {
        this.TRACK_CHARGES_LINE_NBR = TRACK_CHARGES_LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.CHARGE_CODE
     *
     * @return the value of TRSPAYPLAN_CHARGES.CHARGE_CODE
     */
    public BigDecimal getCHARGE_CODE() {
        return CHARGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.CHARGE_CODE
     *
     * @param CHARGE_CODE the value for TRSPAYPLAN_CHARGES.CHARGE_CODE
     */
    public void setCHARGE_CODE(BigDecimal CHARGE_CODE) {
        this.CHARGE_CODE = CHARGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.AMOUNT
     *
     * @return the value of TRSPAYPLAN_CHARGES.AMOUNT
     */
    public BigDecimal getAMOUNT() {
        return AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.AMOUNT
     *
     * @param AMOUNT the value for TRSPAYPLAN_CHARGES.AMOUNT
     */
    public void setAMOUNT(BigDecimal AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.DR_ACC_BR
     *
     * @return the value of TRSPAYPLAN_CHARGES.DR_ACC_BR
     */
    public BigDecimal getDR_ACC_BR() {
        return DR_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.DR_ACC_BR
     *
     * @param DR_ACC_BR the value for TRSPAYPLAN_CHARGES.DR_ACC_BR
     */
    public void setDR_ACC_BR(BigDecimal DR_ACC_BR) {
        this.DR_ACC_BR = DR_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.DR_ACC_CY
     *
     * @return the value of TRSPAYPLAN_CHARGES.DR_ACC_CY
     */
    public BigDecimal getDR_ACC_CY() {
        return DR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.DR_ACC_CY
     *
     * @param DR_ACC_CY the value for TRSPAYPLAN_CHARGES.DR_ACC_CY
     */
    public void setDR_ACC_CY(BigDecimal DR_ACC_CY) {
        this.DR_ACC_CY = DR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.DR_ACC_GL
     *
     * @return the value of TRSPAYPLAN_CHARGES.DR_ACC_GL
     */
    public BigDecimal getDR_ACC_GL() {
        return DR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.DR_ACC_GL
     *
     * @param DR_ACC_GL the value for TRSPAYPLAN_CHARGES.DR_ACC_GL
     */
    public void setDR_ACC_GL(BigDecimal DR_ACC_GL) {
        this.DR_ACC_GL = DR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.DR_ACC_CIF
     *
     * @return the value of TRSPAYPLAN_CHARGES.DR_ACC_CIF
     */
    public BigDecimal getDR_ACC_CIF() {
        return DR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.DR_ACC_CIF
     *
     * @param DR_ACC_CIF the value for TRSPAYPLAN_CHARGES.DR_ACC_CIF
     */
    public void setDR_ACC_CIF(BigDecimal DR_ACC_CIF) {
        this.DR_ACC_CIF = DR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.DR_ACC_SL
     *
     * @return the value of TRSPAYPLAN_CHARGES.DR_ACC_SL
     */
    public BigDecimal getDR_ACC_SL() {
        return DR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.DR_ACC_SL
     *
     * @param DR_ACC_SL the value for TRSPAYPLAN_CHARGES.DR_ACC_SL
     */
    public void setDR_ACC_SL(BigDecimal DR_ACC_SL) {
        this.DR_ACC_SL = DR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.CR_ACC_BR
     *
     * @return the value of TRSPAYPLAN_CHARGES.CR_ACC_BR
     */
    public BigDecimal getCR_ACC_BR() {
        return CR_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.CR_ACC_BR
     *
     * @param CR_ACC_BR the value for TRSPAYPLAN_CHARGES.CR_ACC_BR
     */
    public void setCR_ACC_BR(BigDecimal CR_ACC_BR) {
        this.CR_ACC_BR = CR_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.CR_ACC_CY
     *
     * @return the value of TRSPAYPLAN_CHARGES.CR_ACC_CY
     */
    public BigDecimal getCR_ACC_CY() {
        return CR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.CR_ACC_CY
     *
     * @param CR_ACC_CY the value for TRSPAYPLAN_CHARGES.CR_ACC_CY
     */
    public void setCR_ACC_CY(BigDecimal CR_ACC_CY) {
        this.CR_ACC_CY = CR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.CR_ACC_GL
     *
     * @return the value of TRSPAYPLAN_CHARGES.CR_ACC_GL
     */
    public BigDecimal getCR_ACC_GL() {
        return CR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.CR_ACC_GL
     *
     * @param CR_ACC_GL the value for TRSPAYPLAN_CHARGES.CR_ACC_GL
     */
    public void setCR_ACC_GL(BigDecimal CR_ACC_GL) {
        this.CR_ACC_GL = CR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.CR_ACC_CIF
     *
     * @return the value of TRSPAYPLAN_CHARGES.CR_ACC_CIF
     */
    public BigDecimal getCR_ACC_CIF() {
        return CR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.CR_ACC_CIF
     *
     * @param CR_ACC_CIF the value for TRSPAYPLAN_CHARGES.CR_ACC_CIF
     */
    public void setCR_ACC_CIF(BigDecimal CR_ACC_CIF) {
        this.CR_ACC_CIF = CR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.CR_ACC_SL
     *
     * @return the value of TRSPAYPLAN_CHARGES.CR_ACC_SL
     */
    public BigDecimal getCR_ACC_SL() {
        return CR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.CR_ACC_SL
     *
     * @param CR_ACC_SL the value for TRSPAYPLAN_CHARGES.CR_ACC_SL
     */
    public void setCR_ACC_SL(BigDecimal CR_ACC_SL) {
        this.CR_ACC_SL = CR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.ACTION_TYPE
     *
     * @return the value of TRSPAYPLAN_CHARGES.ACTION_TYPE
     */
    public String getACTION_TYPE() {
        return ACTION_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.ACTION_TYPE
     *
     * @param ACTION_TYPE the value for TRSPAYPLAN_CHARGES.ACTION_TYPE
     */
    public void setACTION_TYPE(String ACTION_TYPE) {
        this.ACTION_TYPE = ACTION_TYPE == null ? null : ACTION_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.BLOCKED_AMT_CV
     *
     * @return the value of TRSPAYPLAN_CHARGES.BLOCKED_AMT_CV
     */
    public BigDecimal getBLOCKED_AMT_CV() {
        return BLOCKED_AMT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.BLOCKED_AMT_CV
     *
     * @param BLOCKED_AMT_CV the value for TRSPAYPLAN_CHARGES.BLOCKED_AMT_CV
     */
    public void setBLOCKED_AMT_CV(BigDecimal BLOCKED_AMT_CV) {
        this.BLOCKED_AMT_CV = BLOCKED_AMT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.BLOCKED_AMT_FC
     *
     * @return the value of TRSPAYPLAN_CHARGES.BLOCKED_AMT_FC
     */
    public BigDecimal getBLOCKED_AMT_FC() {
        return BLOCKED_AMT_FC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.BLOCKED_AMT_FC
     *
     * @param BLOCKED_AMT_FC the value for TRSPAYPLAN_CHARGES.BLOCKED_AMT_FC
     */
    public void setBLOCKED_AMT_FC(BigDecimal BLOCKED_AMT_FC) {
        this.BLOCKED_AMT_FC = BLOCKED_AMT_FC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.BLOCK_PROCESS_DATE
     *
     * @return the value of TRSPAYPLAN_CHARGES.BLOCK_PROCESS_DATE
     */
    public Date getBLOCK_PROCESS_DATE() {
        return BLOCK_PROCESS_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.BLOCK_PROCESS_DATE
     *
     * @param BLOCK_PROCESS_DATE the value for TRSPAYPLAN_CHARGES.BLOCK_PROCESS_DATE
     */
    public void setBLOCK_PROCESS_DATE(Date BLOCK_PROCESS_DATE) {
        this.BLOCK_PROCESS_DATE = BLOCK_PROCESS_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.CHARGES_AMT_CV
     *
     * @return the value of TRSPAYPLAN_CHARGES.CHARGES_AMT_CV
     */
    public BigDecimal getCHARGES_AMT_CV() {
        return CHARGES_AMT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.CHARGES_AMT_CV
     *
     * @param CHARGES_AMT_CV the value for TRSPAYPLAN_CHARGES.CHARGES_AMT_CV
     */
    public void setCHARGES_AMT_CV(BigDecimal CHARGES_AMT_CV) {
        this.CHARGES_AMT_CV = CHARGES_AMT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.CHARGES_AMT_FC
     *
     * @return the value of TRSPAYPLAN_CHARGES.CHARGES_AMT_FC
     */
    public BigDecimal getCHARGES_AMT_FC() {
        return CHARGES_AMT_FC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.CHARGES_AMT_FC
     *
     * @param CHARGES_AMT_FC the value for TRSPAYPLAN_CHARGES.CHARGES_AMT_FC
     */
    public void setCHARGES_AMT_FC(BigDecimal CHARGES_AMT_FC) {
        this.CHARGES_AMT_FC = CHARGES_AMT_FC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.CHARGES_EXCH_RATE
     *
     * @return the value of TRSPAYPLAN_CHARGES.CHARGES_EXCH_RATE
     */
    public BigDecimal getCHARGES_EXCH_RATE() {
        return CHARGES_EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.CHARGES_EXCH_RATE
     *
     * @param CHARGES_EXCH_RATE the value for TRSPAYPLAN_CHARGES.CHARGES_EXCH_RATE
     */
    public void setCHARGES_EXCH_RATE(BigDecimal CHARGES_EXCH_RATE) {
        this.CHARGES_EXCH_RATE = CHARGES_EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.CHARGES_MULTDIV
     *
     * @return the value of TRSPAYPLAN_CHARGES.CHARGES_MULTDIV
     */
    public String getCHARGES_MULTDIV() {
        return CHARGES_MULTDIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.CHARGES_MULTDIV
     *
     * @param CHARGES_MULTDIV the value for TRSPAYPLAN_CHARGES.CHARGES_MULTDIV
     */
    public void setCHARGES_MULTDIV(String CHARGES_MULTDIV) {
        this.CHARGES_MULTDIV = CHARGES_MULTDIV == null ? null : CHARGES_MULTDIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.CHARGES_PERCENTAGE
     *
     * @return the value of TRSPAYPLAN_CHARGES.CHARGES_PERCENTAGE
     */
    public BigDecimal getCHARGES_PERCENTAGE() {
        return CHARGES_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.CHARGES_PERCENTAGE
     *
     * @param CHARGES_PERCENTAGE the value for TRSPAYPLAN_CHARGES.CHARGES_PERCENTAGE
     */
    public void setCHARGES_PERCENTAGE(BigDecimal CHARGES_PERCENTAGE) {
        this.CHARGES_PERCENTAGE = CHARGES_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.POSTED_YN
     *
     * @return the value of TRSPAYPLAN_CHARGES.POSTED_YN
     */
    public String getPOSTED_YN() {
        return POSTED_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.POSTED_YN
     *
     * @param POSTED_YN the value for TRSPAYPLAN_CHARGES.POSTED_YN
     */
    public void setPOSTED_YN(String POSTED_YN) {
        this.POSTED_YN = POSTED_YN == null ? null : POSTED_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.REVERSE_CHARGE_YN
     *
     * @return the value of TRSPAYPLAN_CHARGES.REVERSE_CHARGE_YN
     */
    public String getREVERSE_CHARGE_YN() {
        return REVERSE_CHARGE_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.REVERSE_CHARGE_YN
     *
     * @param REVERSE_CHARGE_YN the value for TRSPAYPLAN_CHARGES.REVERSE_CHARGE_YN
     */
    public void setREVERSE_CHARGE_YN(String REVERSE_CHARGE_YN) {
        this.REVERSE_CHARGE_YN = REVERSE_CHARGE_YN == null ? null : REVERSE_CHARGE_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.VALUE_DATE
     *
     * @return the value of TRSPAYPLAN_CHARGES.VALUE_DATE
     */
    public Date getVALUE_DATE() {
        return VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.VALUE_DATE
     *
     * @param VALUE_DATE the value for TRSPAYPLAN_CHARGES.VALUE_DATE
     */
    public void setVALUE_DATE(Date VALUE_DATE) {
        this.VALUE_DATE = VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.VAT_CODE
     *
     * @return the value of TRSPAYPLAN_CHARGES.VAT_CODE
     */
    public BigDecimal getVAT_CODE() {
        return VAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.VAT_CODE
     *
     * @param VAT_CODE the value for TRSPAYPLAN_CHARGES.VAT_CODE
     */
    public void setVAT_CODE(BigDecimal VAT_CODE) {
        this.VAT_CODE = VAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CHARGES.CHARGES_REVERSED_AMOUNT
     *
     * @return the value of TRSPAYPLAN_CHARGES.CHARGES_REVERSED_AMOUNT
     */
    public BigDecimal getCHARGES_REVERSED_AMOUNT() {
        return CHARGES_REVERSED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CHARGES.CHARGES_REVERSED_AMOUNT
     *
     * @param CHARGES_REVERSED_AMOUNT the value for TRSPAYPLAN_CHARGES.CHARGES_REVERSED_AMOUNT
     */
    public void setCHARGES_REVERSED_AMOUNT(BigDecimal CHARGES_REVERSED_AMOUNT) {
        this.CHARGES_REVERSED_AMOUNT = CHARGES_REVERSED_AMOUNT;
    }
}