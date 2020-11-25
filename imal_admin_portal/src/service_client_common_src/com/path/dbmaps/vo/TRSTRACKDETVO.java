package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRSTRACKDETVO extends TRSTRACKDETVOKey {
    /**
     * This field corresponds to the database column TRSTRACKDET.EXPREV_CODE
     */
    private BigDecimal EXPREV_CODE;

    /**
     * This field corresponds to the database column TRSTRACKDET.AMOUNT
     */
    private BigDecimal AMOUNT;

    /**
     * This field corresponds to the database column TRSTRACKDET.CROSS_EXCH_RATE
     */
    private BigDecimal CROSS_EXCH_RATE;

    /**
     * This field corresponds to the database column TRSTRACKDET.CY_RATE
     */
    private BigDecimal CY_RATE;

    /**
     * This field corresponds to the database column TRSTRACKDET.CY_UNIT
     */
    private BigDecimal CY_UNIT;

    /**
     * This field corresponds to the database column TRSTRACKDET.CY_MULT_DIV
     */
    private String CY_MULT_DIV;

    /**
     * This field corresponds to the database column TRSTRACKDET.DR_ACC_CY
     */
    private BigDecimal DR_ACC_CY;

    /**
     * This field corresponds to the database column TRSTRACKDET.DR_ACC_GL
     */
    private BigDecimal DR_ACC_GL;

    /**
     * This field corresponds to the database column TRSTRACKDET.DR_ACC_CIF
     */
    private BigDecimal DR_ACC_CIF;

    /**
     * This field corresponds to the database column TRSTRACKDET.DR_ACC_SL
     */
    private BigDecimal DR_ACC_SL;

    /**
     * This field corresponds to the database column TRSTRACKDET.CR_ACC_CY
     */
    private BigDecimal CR_ACC_CY;

    /**
     * This field corresponds to the database column TRSTRACKDET.CR_ACC_GL
     */
    private BigDecimal CR_ACC_GL;

    /**
     * This field corresponds to the database column TRSTRACKDET.CR_ACC_CIF
     */
    private BigDecimal CR_ACC_CIF;

    /**
     * This field corresponds to the database column TRSTRACKDET.CR_ACC_SL
     */
    private BigDecimal CR_ACC_SL;

    /**
     * This field corresponds to the database column TRSTRACKDET.CLI_DR_ACC_CY
     */
    private BigDecimal CLI_DR_ACC_CY;

    /**
     * This field corresponds to the database column TRSTRACKDET.CLI_DR_ACC_GL
     */
    private BigDecimal CLI_DR_ACC_GL;

    /**
     * This field corresponds to the database column TRSTRACKDET.CLI_DR_ACC_CIF
     */
    private BigDecimal CLI_DR_ACC_CIF;

    /**
     * This field corresponds to the database column TRSTRACKDET.CLI_DR_ACC_SL
     */
    private BigDecimal CLI_DR_ACC_SL;

    /**
     * This field corresponds to the database column TRSTRACKDET.CLI_CR_ACC_CY
     */
    private BigDecimal CLI_CR_ACC_CY;

    /**
     * This field corresponds to the database column TRSTRACKDET.CLI_CR_ACC_GL
     */
    private BigDecimal CLI_CR_ACC_GL;

    /**
     * This field corresponds to the database column TRSTRACKDET.CLI_CR_ACC_CIF
     */
    private BigDecimal CLI_CR_ACC_CIF;

    /**
     * This field corresponds to the database column TRSTRACKDET.CLI_CR_ACC_SL
     */
    private BigDecimal CLI_CR_ACC_SL;

    /**
     * This field corresponds to the database column TRSTRACKDET.CROSS_CY_MULT_DIV
     */
    private String CROSS_CY_MULT_DIV;

    /**
     * This field corresponds to the database column TRSTRACKDET.CHARGE_ALLOCATION_CRITERIA
     */
    private String CHARGE_ALLOCATION_CRITERIA;

    /**
     * This field corresponds to the database column TRSTRACKDET.CHARGE_NO_INSTALLMENTS
     */
    private BigDecimal CHARGE_NO_INSTALLMENTS;

    /**
     * This field corresponds to the database column TRSTRACKDET.CHARGE_FROM_DATE
     */
    private Date CHARGE_FROM_DATE;

    /**
     * This field corresponds to the database column TRSTRACKDET.CHARGE_TO_DATE
     */
    private Date CHARGE_TO_DATE;

    /**
     * This field corresponds to the database column TRSTRACKDET.DR_ACC_BR
     */
    private BigDecimal DR_ACC_BR;

    /**
     * This field corresponds to the database column TRSTRACKDET.CR_ACC_BR
     */
    private BigDecimal CR_ACC_BR;

    /**
     * This field corresponds to the database column TRSTRACKDET.AMOUNT_CHARGE_CY
     */
    private BigDecimal AMOUNT_CHARGE_CY;

    /**
     * This field corresponds to the database column TRSTRACKDET.REASON
     */
    private String REASON;

    /**
     * This field corresponds to the database column TRSTRACKDET.CHARGES_REVERSED_AMOUNT
     */
    private BigDecimal CHARGES_REVERSED_AMOUNT;

    /**
     * This field corresponds to the database column TRSTRACKDET.MUSHARAKA_PSR
     */
    private BigDecimal MUSHARAKA_PSR;

    /**
     * This field corresponds to the database column TRSTRACKDET.FUND_DR_ACC_CY
     */
    private BigDecimal FUND_DR_ACC_CY;

    /**
     * This field corresponds to the database column TRSTRACKDET.FUND_DR_ACC_GL
     */
    private BigDecimal FUND_DR_ACC_GL;

    /**
     * This field corresponds to the database column TRSTRACKDET.FUND_DR_ACC_CIF
     */
    private BigDecimal FUND_DR_ACC_CIF;

    /**
     * This field corresponds to the database column TRSTRACKDET.FUND_DR_ACC_SL
     */
    private BigDecimal FUND_DR_ACC_SL;

    /**
     * This field corresponds to the database column TRSTRACKDET.FUND_CR_ACC_CY
     */
    private BigDecimal FUND_CR_ACC_CY;

    /**
     * This field corresponds to the database column TRSTRACKDET.FUND_CR_ACC_GL
     */
    private BigDecimal FUND_CR_ACC_GL;

    /**
     * This field corresponds to the database column TRSTRACKDET.FUND_CR_ACC_CIF
     */
    private BigDecimal FUND_CR_ACC_CIF;

    /**
     * This field corresponds to the database column TRSTRACKDET.FUND_CR_ACC_SL
     */
    private BigDecimal FUND_CR_ACC_SL;

    /**
     * This field corresponds to the database column TRSTRACKDET.VAT_AMOUNT
     */
    private BigDecimal VAT_AMOUNT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.EXPREV_CODE
     *
     * @return the value of TRSTRACKDET.EXPREV_CODE
     */
    public BigDecimal getEXPREV_CODE() {
        return EXPREV_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.EXPREV_CODE
     *
     * @param EXPREV_CODE the value for TRSTRACKDET.EXPREV_CODE
     */
    public void setEXPREV_CODE(BigDecimal EXPREV_CODE) {
        this.EXPREV_CODE = EXPREV_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.AMOUNT
     *
     * @return the value of TRSTRACKDET.AMOUNT
     */
    public BigDecimal getAMOUNT() {
        return AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.AMOUNT
     *
     * @param AMOUNT the value for TRSTRACKDET.AMOUNT
     */
    public void setAMOUNT(BigDecimal AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CROSS_EXCH_RATE
     *
     * @return the value of TRSTRACKDET.CROSS_EXCH_RATE
     */
    public BigDecimal getCROSS_EXCH_RATE() {
        return CROSS_EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CROSS_EXCH_RATE
     *
     * @param CROSS_EXCH_RATE the value for TRSTRACKDET.CROSS_EXCH_RATE
     */
    public void setCROSS_EXCH_RATE(BigDecimal CROSS_EXCH_RATE) {
        this.CROSS_EXCH_RATE = CROSS_EXCH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CY_RATE
     *
     * @return the value of TRSTRACKDET.CY_RATE
     */
    public BigDecimal getCY_RATE() {
        return CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CY_RATE
     *
     * @param CY_RATE the value for TRSTRACKDET.CY_RATE
     */
    public void setCY_RATE(BigDecimal CY_RATE) {
        this.CY_RATE = CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CY_UNIT
     *
     * @return the value of TRSTRACKDET.CY_UNIT
     */
    public BigDecimal getCY_UNIT() {
        return CY_UNIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CY_UNIT
     *
     * @param CY_UNIT the value for TRSTRACKDET.CY_UNIT
     */
    public void setCY_UNIT(BigDecimal CY_UNIT) {
        this.CY_UNIT = CY_UNIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CY_MULT_DIV
     *
     * @return the value of TRSTRACKDET.CY_MULT_DIV
     */
    public String getCY_MULT_DIV() {
        return CY_MULT_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CY_MULT_DIV
     *
     * @param CY_MULT_DIV the value for TRSTRACKDET.CY_MULT_DIV
     */
    public void setCY_MULT_DIV(String CY_MULT_DIV) {
        this.CY_MULT_DIV = CY_MULT_DIV == null ? null : CY_MULT_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.DR_ACC_CY
     *
     * @return the value of TRSTRACKDET.DR_ACC_CY
     */
    public BigDecimal getDR_ACC_CY() {
        return DR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.DR_ACC_CY
     *
     * @param DR_ACC_CY the value for TRSTRACKDET.DR_ACC_CY
     */
    public void setDR_ACC_CY(BigDecimal DR_ACC_CY) {
        this.DR_ACC_CY = DR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.DR_ACC_GL
     *
     * @return the value of TRSTRACKDET.DR_ACC_GL
     */
    public BigDecimal getDR_ACC_GL() {
        return DR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.DR_ACC_GL
     *
     * @param DR_ACC_GL the value for TRSTRACKDET.DR_ACC_GL
     */
    public void setDR_ACC_GL(BigDecimal DR_ACC_GL) {
        this.DR_ACC_GL = DR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.DR_ACC_CIF
     *
     * @return the value of TRSTRACKDET.DR_ACC_CIF
     */
    public BigDecimal getDR_ACC_CIF() {
        return DR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.DR_ACC_CIF
     *
     * @param DR_ACC_CIF the value for TRSTRACKDET.DR_ACC_CIF
     */
    public void setDR_ACC_CIF(BigDecimal DR_ACC_CIF) {
        this.DR_ACC_CIF = DR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.DR_ACC_SL
     *
     * @return the value of TRSTRACKDET.DR_ACC_SL
     */
    public BigDecimal getDR_ACC_SL() {
        return DR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.DR_ACC_SL
     *
     * @param DR_ACC_SL the value for TRSTRACKDET.DR_ACC_SL
     */
    public void setDR_ACC_SL(BigDecimal DR_ACC_SL) {
        this.DR_ACC_SL = DR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CR_ACC_CY
     *
     * @return the value of TRSTRACKDET.CR_ACC_CY
     */
    public BigDecimal getCR_ACC_CY() {
        return CR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CR_ACC_CY
     *
     * @param CR_ACC_CY the value for TRSTRACKDET.CR_ACC_CY
     */
    public void setCR_ACC_CY(BigDecimal CR_ACC_CY) {
        this.CR_ACC_CY = CR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CR_ACC_GL
     *
     * @return the value of TRSTRACKDET.CR_ACC_GL
     */
    public BigDecimal getCR_ACC_GL() {
        return CR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CR_ACC_GL
     *
     * @param CR_ACC_GL the value for TRSTRACKDET.CR_ACC_GL
     */
    public void setCR_ACC_GL(BigDecimal CR_ACC_GL) {
        this.CR_ACC_GL = CR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CR_ACC_CIF
     *
     * @return the value of TRSTRACKDET.CR_ACC_CIF
     */
    public BigDecimal getCR_ACC_CIF() {
        return CR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CR_ACC_CIF
     *
     * @param CR_ACC_CIF the value for TRSTRACKDET.CR_ACC_CIF
     */
    public void setCR_ACC_CIF(BigDecimal CR_ACC_CIF) {
        this.CR_ACC_CIF = CR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CR_ACC_SL
     *
     * @return the value of TRSTRACKDET.CR_ACC_SL
     */
    public BigDecimal getCR_ACC_SL() {
        return CR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CR_ACC_SL
     *
     * @param CR_ACC_SL the value for TRSTRACKDET.CR_ACC_SL
     */
    public void setCR_ACC_SL(BigDecimal CR_ACC_SL) {
        this.CR_ACC_SL = CR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CLI_DR_ACC_CY
     *
     * @return the value of TRSTRACKDET.CLI_DR_ACC_CY
     */
    public BigDecimal getCLI_DR_ACC_CY() {
        return CLI_DR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CLI_DR_ACC_CY
     *
     * @param CLI_DR_ACC_CY the value for TRSTRACKDET.CLI_DR_ACC_CY
     */
    public void setCLI_DR_ACC_CY(BigDecimal CLI_DR_ACC_CY) {
        this.CLI_DR_ACC_CY = CLI_DR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CLI_DR_ACC_GL
     *
     * @return the value of TRSTRACKDET.CLI_DR_ACC_GL
     */
    public BigDecimal getCLI_DR_ACC_GL() {
        return CLI_DR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CLI_DR_ACC_GL
     *
     * @param CLI_DR_ACC_GL the value for TRSTRACKDET.CLI_DR_ACC_GL
     */
    public void setCLI_DR_ACC_GL(BigDecimal CLI_DR_ACC_GL) {
        this.CLI_DR_ACC_GL = CLI_DR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CLI_DR_ACC_CIF
     *
     * @return the value of TRSTRACKDET.CLI_DR_ACC_CIF
     */
    public BigDecimal getCLI_DR_ACC_CIF() {
        return CLI_DR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CLI_DR_ACC_CIF
     *
     * @param CLI_DR_ACC_CIF the value for TRSTRACKDET.CLI_DR_ACC_CIF
     */
    public void setCLI_DR_ACC_CIF(BigDecimal CLI_DR_ACC_CIF) {
        this.CLI_DR_ACC_CIF = CLI_DR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CLI_DR_ACC_SL
     *
     * @return the value of TRSTRACKDET.CLI_DR_ACC_SL
     */
    public BigDecimal getCLI_DR_ACC_SL() {
        return CLI_DR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CLI_DR_ACC_SL
     *
     * @param CLI_DR_ACC_SL the value for TRSTRACKDET.CLI_DR_ACC_SL
     */
    public void setCLI_DR_ACC_SL(BigDecimal CLI_DR_ACC_SL) {
        this.CLI_DR_ACC_SL = CLI_DR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CLI_CR_ACC_CY
     *
     * @return the value of TRSTRACKDET.CLI_CR_ACC_CY
     */
    public BigDecimal getCLI_CR_ACC_CY() {
        return CLI_CR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CLI_CR_ACC_CY
     *
     * @param CLI_CR_ACC_CY the value for TRSTRACKDET.CLI_CR_ACC_CY
     */
    public void setCLI_CR_ACC_CY(BigDecimal CLI_CR_ACC_CY) {
        this.CLI_CR_ACC_CY = CLI_CR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CLI_CR_ACC_GL
     *
     * @return the value of TRSTRACKDET.CLI_CR_ACC_GL
     */
    public BigDecimal getCLI_CR_ACC_GL() {
        return CLI_CR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CLI_CR_ACC_GL
     *
     * @param CLI_CR_ACC_GL the value for TRSTRACKDET.CLI_CR_ACC_GL
     */
    public void setCLI_CR_ACC_GL(BigDecimal CLI_CR_ACC_GL) {
        this.CLI_CR_ACC_GL = CLI_CR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CLI_CR_ACC_CIF
     *
     * @return the value of TRSTRACKDET.CLI_CR_ACC_CIF
     */
    public BigDecimal getCLI_CR_ACC_CIF() {
        return CLI_CR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CLI_CR_ACC_CIF
     *
     * @param CLI_CR_ACC_CIF the value for TRSTRACKDET.CLI_CR_ACC_CIF
     */
    public void setCLI_CR_ACC_CIF(BigDecimal CLI_CR_ACC_CIF) {
        this.CLI_CR_ACC_CIF = CLI_CR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CLI_CR_ACC_SL
     *
     * @return the value of TRSTRACKDET.CLI_CR_ACC_SL
     */
    public BigDecimal getCLI_CR_ACC_SL() {
        return CLI_CR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CLI_CR_ACC_SL
     *
     * @param CLI_CR_ACC_SL the value for TRSTRACKDET.CLI_CR_ACC_SL
     */
    public void setCLI_CR_ACC_SL(BigDecimal CLI_CR_ACC_SL) {
        this.CLI_CR_ACC_SL = CLI_CR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CROSS_CY_MULT_DIV
     *
     * @return the value of TRSTRACKDET.CROSS_CY_MULT_DIV
     */
    public String getCROSS_CY_MULT_DIV() {
        return CROSS_CY_MULT_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CROSS_CY_MULT_DIV
     *
     * @param CROSS_CY_MULT_DIV the value for TRSTRACKDET.CROSS_CY_MULT_DIV
     */
    public void setCROSS_CY_MULT_DIV(String CROSS_CY_MULT_DIV) {
        this.CROSS_CY_MULT_DIV = CROSS_CY_MULT_DIV == null ? null : CROSS_CY_MULT_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CHARGE_ALLOCATION_CRITERIA
     *
     * @return the value of TRSTRACKDET.CHARGE_ALLOCATION_CRITERIA
     */
    public String getCHARGE_ALLOCATION_CRITERIA() {
        return CHARGE_ALLOCATION_CRITERIA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CHARGE_ALLOCATION_CRITERIA
     *
     * @param CHARGE_ALLOCATION_CRITERIA the value for TRSTRACKDET.CHARGE_ALLOCATION_CRITERIA
     */
    public void setCHARGE_ALLOCATION_CRITERIA(String CHARGE_ALLOCATION_CRITERIA) {
        this.CHARGE_ALLOCATION_CRITERIA = CHARGE_ALLOCATION_CRITERIA == null ? null : CHARGE_ALLOCATION_CRITERIA.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CHARGE_NO_INSTALLMENTS
     *
     * @return the value of TRSTRACKDET.CHARGE_NO_INSTALLMENTS
     */
    public BigDecimal getCHARGE_NO_INSTALLMENTS() {
        return CHARGE_NO_INSTALLMENTS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CHARGE_NO_INSTALLMENTS
     *
     * @param CHARGE_NO_INSTALLMENTS the value for TRSTRACKDET.CHARGE_NO_INSTALLMENTS
     */
    public void setCHARGE_NO_INSTALLMENTS(BigDecimal CHARGE_NO_INSTALLMENTS) {
        this.CHARGE_NO_INSTALLMENTS = CHARGE_NO_INSTALLMENTS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CHARGE_FROM_DATE
     *
     * @return the value of TRSTRACKDET.CHARGE_FROM_DATE
     */
    public Date getCHARGE_FROM_DATE() {
        return CHARGE_FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CHARGE_FROM_DATE
     *
     * @param CHARGE_FROM_DATE the value for TRSTRACKDET.CHARGE_FROM_DATE
     */
    public void setCHARGE_FROM_DATE(Date CHARGE_FROM_DATE) {
        this.CHARGE_FROM_DATE = CHARGE_FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CHARGE_TO_DATE
     *
     * @return the value of TRSTRACKDET.CHARGE_TO_DATE
     */
    public Date getCHARGE_TO_DATE() {
        return CHARGE_TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CHARGE_TO_DATE
     *
     * @param CHARGE_TO_DATE the value for TRSTRACKDET.CHARGE_TO_DATE
     */
    public void setCHARGE_TO_DATE(Date CHARGE_TO_DATE) {
        this.CHARGE_TO_DATE = CHARGE_TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.DR_ACC_BR
     *
     * @return the value of TRSTRACKDET.DR_ACC_BR
     */
    public BigDecimal getDR_ACC_BR() {
        return DR_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.DR_ACC_BR
     *
     * @param DR_ACC_BR the value for TRSTRACKDET.DR_ACC_BR
     */
    public void setDR_ACC_BR(BigDecimal DR_ACC_BR) {
        this.DR_ACC_BR = DR_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CR_ACC_BR
     *
     * @return the value of TRSTRACKDET.CR_ACC_BR
     */
    public BigDecimal getCR_ACC_BR() {
        return CR_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CR_ACC_BR
     *
     * @param CR_ACC_BR the value for TRSTRACKDET.CR_ACC_BR
     */
    public void setCR_ACC_BR(BigDecimal CR_ACC_BR) {
        this.CR_ACC_BR = CR_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.AMOUNT_CHARGE_CY
     *
     * @return the value of TRSTRACKDET.AMOUNT_CHARGE_CY
     */
    public BigDecimal getAMOUNT_CHARGE_CY() {
        return AMOUNT_CHARGE_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.AMOUNT_CHARGE_CY
     *
     * @param AMOUNT_CHARGE_CY the value for TRSTRACKDET.AMOUNT_CHARGE_CY
     */
    public void setAMOUNT_CHARGE_CY(BigDecimal AMOUNT_CHARGE_CY) {
        this.AMOUNT_CHARGE_CY = AMOUNT_CHARGE_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.REASON
     *
     * @return the value of TRSTRACKDET.REASON
     */
    public String getREASON() {
        return REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.REASON
     *
     * @param REASON the value for TRSTRACKDET.REASON
     */
    public void setREASON(String REASON) {
        this.REASON = REASON == null ? null : REASON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.CHARGES_REVERSED_AMOUNT
     *
     * @return the value of TRSTRACKDET.CHARGES_REVERSED_AMOUNT
     */
    public BigDecimal getCHARGES_REVERSED_AMOUNT() {
        return CHARGES_REVERSED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.CHARGES_REVERSED_AMOUNT
     *
     * @param CHARGES_REVERSED_AMOUNT the value for TRSTRACKDET.CHARGES_REVERSED_AMOUNT
     */
    public void setCHARGES_REVERSED_AMOUNT(BigDecimal CHARGES_REVERSED_AMOUNT) {
        this.CHARGES_REVERSED_AMOUNT = CHARGES_REVERSED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.MUSHARAKA_PSR
     *
     * @return the value of TRSTRACKDET.MUSHARAKA_PSR
     */
    public BigDecimal getMUSHARAKA_PSR() {
        return MUSHARAKA_PSR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.MUSHARAKA_PSR
     *
     * @param MUSHARAKA_PSR the value for TRSTRACKDET.MUSHARAKA_PSR
     */
    public void setMUSHARAKA_PSR(BigDecimal MUSHARAKA_PSR) {
        this.MUSHARAKA_PSR = MUSHARAKA_PSR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.FUND_DR_ACC_CY
     *
     * @return the value of TRSTRACKDET.FUND_DR_ACC_CY
     */
    public BigDecimal getFUND_DR_ACC_CY() {
        return FUND_DR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.FUND_DR_ACC_CY
     *
     * @param FUND_DR_ACC_CY the value for TRSTRACKDET.FUND_DR_ACC_CY
     */
    public void setFUND_DR_ACC_CY(BigDecimal FUND_DR_ACC_CY) {
        this.FUND_DR_ACC_CY = FUND_DR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.FUND_DR_ACC_GL
     *
     * @return the value of TRSTRACKDET.FUND_DR_ACC_GL
     */
    public BigDecimal getFUND_DR_ACC_GL() {
        return FUND_DR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.FUND_DR_ACC_GL
     *
     * @param FUND_DR_ACC_GL the value for TRSTRACKDET.FUND_DR_ACC_GL
     */
    public void setFUND_DR_ACC_GL(BigDecimal FUND_DR_ACC_GL) {
        this.FUND_DR_ACC_GL = FUND_DR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.FUND_DR_ACC_CIF
     *
     * @return the value of TRSTRACKDET.FUND_DR_ACC_CIF
     */
    public BigDecimal getFUND_DR_ACC_CIF() {
        return FUND_DR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.FUND_DR_ACC_CIF
     *
     * @param FUND_DR_ACC_CIF the value for TRSTRACKDET.FUND_DR_ACC_CIF
     */
    public void setFUND_DR_ACC_CIF(BigDecimal FUND_DR_ACC_CIF) {
        this.FUND_DR_ACC_CIF = FUND_DR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.FUND_DR_ACC_SL
     *
     * @return the value of TRSTRACKDET.FUND_DR_ACC_SL
     */
    public BigDecimal getFUND_DR_ACC_SL() {
        return FUND_DR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.FUND_DR_ACC_SL
     *
     * @param FUND_DR_ACC_SL the value for TRSTRACKDET.FUND_DR_ACC_SL
     */
    public void setFUND_DR_ACC_SL(BigDecimal FUND_DR_ACC_SL) {
        this.FUND_DR_ACC_SL = FUND_DR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.FUND_CR_ACC_CY
     *
     * @return the value of TRSTRACKDET.FUND_CR_ACC_CY
     */
    public BigDecimal getFUND_CR_ACC_CY() {
        return FUND_CR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.FUND_CR_ACC_CY
     *
     * @param FUND_CR_ACC_CY the value for TRSTRACKDET.FUND_CR_ACC_CY
     */
    public void setFUND_CR_ACC_CY(BigDecimal FUND_CR_ACC_CY) {
        this.FUND_CR_ACC_CY = FUND_CR_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.FUND_CR_ACC_GL
     *
     * @return the value of TRSTRACKDET.FUND_CR_ACC_GL
     */
    public BigDecimal getFUND_CR_ACC_GL() {
        return FUND_CR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.FUND_CR_ACC_GL
     *
     * @param FUND_CR_ACC_GL the value for TRSTRACKDET.FUND_CR_ACC_GL
     */
    public void setFUND_CR_ACC_GL(BigDecimal FUND_CR_ACC_GL) {
        this.FUND_CR_ACC_GL = FUND_CR_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.FUND_CR_ACC_CIF
     *
     * @return the value of TRSTRACKDET.FUND_CR_ACC_CIF
     */
    public BigDecimal getFUND_CR_ACC_CIF() {
        return FUND_CR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.FUND_CR_ACC_CIF
     *
     * @param FUND_CR_ACC_CIF the value for TRSTRACKDET.FUND_CR_ACC_CIF
     */
    public void setFUND_CR_ACC_CIF(BigDecimal FUND_CR_ACC_CIF) {
        this.FUND_CR_ACC_CIF = FUND_CR_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.FUND_CR_ACC_SL
     *
     * @return the value of TRSTRACKDET.FUND_CR_ACC_SL
     */
    public BigDecimal getFUND_CR_ACC_SL() {
        return FUND_CR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.FUND_CR_ACC_SL
     *
     * @param FUND_CR_ACC_SL the value for TRSTRACKDET.FUND_CR_ACC_SL
     */
    public void setFUND_CR_ACC_SL(BigDecimal FUND_CR_ACC_SL) {
        this.FUND_CR_ACC_SL = FUND_CR_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSTRACKDET.VAT_AMOUNT
     *
     * @return the value of TRSTRACKDET.VAT_AMOUNT
     */
    public BigDecimal getVAT_AMOUNT() {
        return VAT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSTRACKDET.VAT_AMOUNT
     *
     * @param VAT_AMOUNT the value for TRSTRACKDET.VAT_AMOUNT
     */
    public void setVAT_AMOUNT(BigDecimal VAT_AMOUNT) {
        this.VAT_AMOUNT = VAT_AMOUNT;
    }
}