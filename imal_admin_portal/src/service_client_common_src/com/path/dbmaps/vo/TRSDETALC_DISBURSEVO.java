package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRSDETALC_DISBURSEVO extends TRSDETALC_DISBURSEVOKey {
    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.DEAL_TYPE
     */
    private BigDecimal DEAL_TYPE;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.PARTY_TYPE
     */
    private String PARTY_TYPE;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.PARTY_BANK_ACC_NO
     */
    private String PARTY_BANK_ACC_NO;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.BANK_CIF
     */
    private BigDecimal BANK_CIF;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.PARTY_BR
     */
    private BigDecimal PARTY_BR;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.PARTY_CY
     */
    private BigDecimal PARTY_CY;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.PARTY_GL
     */
    private BigDecimal PARTY_GL;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.PARTY_CIF
     */
    private BigDecimal PARTY_CIF;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.PARTY_SL
     */
    private BigDecimal PARTY_SL;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.NOSTRO_BR
     */
    private BigDecimal NOSTRO_BR;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.NOSTRO_CY
     */
    private BigDecimal NOSTRO_CY;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.NOSTRO_GL
     */
    private BigDecimal NOSTRO_GL;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.NOSTRO_CIF
     */
    private BigDecimal NOSTRO_CIF;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.NOSTRO_SL
     */
    private BigDecimal NOSTRO_SL;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.AMOUNT
     */
    private BigDecimal AMOUNT;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.YIELD
     */
    private BigDecimal YIELD;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.BC_FLAG
     */
    private String BC_FLAG;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.RATE
     */
    private BigDecimal RATE;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.UNIT
     */
    private BigDecimal UNIT;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.ROLLOVER_IND
     */
    private String ROLLOVER_IND;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.ROLLOVER_AMOUNT
     */
    private BigDecimal ROLLOVER_AMOUNT;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.AMOUNT_USED
     */
    private BigDecimal AMOUNT_USED;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLASS
     */
    private BigDecimal CLASS;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.ROLLOVER_SERIAL_NO
     */
    private BigDecimal ROLLOVER_SERIAL_NO;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.ROLLOVER_LINE_NO
     */
    private BigDecimal ROLLOVER_LINE_NO;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.ROLLOVER_LINE_NO_ALC
     */
    private BigDecimal ROLLOVER_LINE_NO_ALC;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.PAYMENT_INSTRUCTION
     */
    private BigDecimal PAYMENT_INSTRUCTION;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.INVESTMENT_ACC_GL
     */
    private BigDecimal INVESTMENT_ACC_GL;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.INVESTMENT_ACC_CIF
     */
    private BigDecimal INVESTMENT_ACC_CIF;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.INVESTMENT_ACC_SL
     */
    private BigDecimal INVESTMENT_ACC_SL;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CROSS_CY_RATE
     */
    private BigDecimal CROSS_CY_RATE;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CROSS_CY_MULT_DIV
     */
    private String CROSS_CY_MULT_DIV;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CROSS_CY_AMOUNT
     */
    private BigDecimal CROSS_CY_AMOUNT;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_RATE
     */
    private BigDecimal NOSTRO_CROSS_CY_RATE;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_MULT_DIV
     */
    private String NOSTRO_CROSS_CY_MULT_DIV;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_AMOUNT
     */
    private BigDecimal NOSTRO_CROSS_CY_AMOUNT;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.EXPECTED_YIELD
     */
    private BigDecimal EXPECTED_YIELD;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.POINT_CY
     */
    private BigDecimal POINT_CY;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.POINT_GL
     */
    private BigDecimal POINT_GL;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.POINT_CIF
     */
    private BigDecimal POINT_CIF;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.POINT_SL
     */
    private BigDecimal POINT_SL;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.LIBOR_RATE
     */
    private BigDecimal LIBOR_RATE;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.MATURITY_INSTRUCTION
     */
    private BigDecimal MATURITY_INSTRUCTION;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.POINT_TRX_NO
     */
    private BigDecimal POINT_TRX_NO;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.ORG_EXPECTED_YIELD
     */
    private BigDecimal ORG_EXPECTED_YIELD;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_CY
     */
    private BigDecimal CLI_DEP_CY;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_GL
     */
    private BigDecimal CLI_DEP_GL;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_CIF
     */
    private BigDecimal CLI_DEP_CIF;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_SL
     */
    private BigDecimal CLI_DEP_SL;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CY
     */
    private BigDecimal CLI_DEP_NOSTRO_CY;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_GL
     */
    private BigDecimal CLI_DEP_NOSTRO_GL;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CIF
     */
    private BigDecimal CLI_DEP_NOSTRO_CIF;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_SL
     */
    private BigDecimal CLI_DEP_NOSTRO_SL;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_RATE
     */
    private BigDecimal CLI_DEP_CROSS_CY_RATE;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_MULT_DIV
     */
    private String CLI_DEP_CROSS_CY_MULT_DIV;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_AMOUNT
     */
    private BigDecimal CLI_DEP_CROSS_CY_AMOUNT;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_CY_RATE
     */
    private BigDecimal CLI_DEP_NOSTRO_CROSS_CY_RATE;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_MULT_DIV
     */
    private String CLI_DEP_NOSTRO_CROSS_MULT_DIV;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_CY_AMOUNT
     */
    private BigDecimal CLI_DEP_NOSTRO_CROSS_CY_AMOUNT;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.VALUE_DATE
     */
    private Date VALUE_DATE;

    /**
     * This field corresponds to the database column TRSDETALC_DISBURSE.DISBURSEMENT_NO
     */
    private BigDecimal DISBURSEMENT_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.DEAL_TYPE
     *
     * @return the value of TRSDETALC_DISBURSE.DEAL_TYPE
     */
    public BigDecimal getDEAL_TYPE() {
        return DEAL_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.DEAL_TYPE
     *
     * @param DEAL_TYPE the value for TRSDETALC_DISBURSE.DEAL_TYPE
     */
    public void setDEAL_TYPE(BigDecimal DEAL_TYPE) {
        this.DEAL_TYPE = DEAL_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.PARTY_TYPE
     *
     * @return the value of TRSDETALC_DISBURSE.PARTY_TYPE
     */
    public String getPARTY_TYPE() {
        return PARTY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.PARTY_TYPE
     *
     * @param PARTY_TYPE the value for TRSDETALC_DISBURSE.PARTY_TYPE
     */
    public void setPARTY_TYPE(String PARTY_TYPE) {
        this.PARTY_TYPE = PARTY_TYPE == null ? null : PARTY_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.PARTY_BANK_ACC_NO
     *
     * @return the value of TRSDETALC_DISBURSE.PARTY_BANK_ACC_NO
     */
    public String getPARTY_BANK_ACC_NO() {
        return PARTY_BANK_ACC_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.PARTY_BANK_ACC_NO
     *
     * @param PARTY_BANK_ACC_NO the value for TRSDETALC_DISBURSE.PARTY_BANK_ACC_NO
     */
    public void setPARTY_BANK_ACC_NO(String PARTY_BANK_ACC_NO) {
        this.PARTY_BANK_ACC_NO = PARTY_BANK_ACC_NO == null ? null : PARTY_BANK_ACC_NO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.BANK_CIF
     *
     * @return the value of TRSDETALC_DISBURSE.BANK_CIF
     */
    public BigDecimal getBANK_CIF() {
        return BANK_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.BANK_CIF
     *
     * @param BANK_CIF the value for TRSDETALC_DISBURSE.BANK_CIF
     */
    public void setBANK_CIF(BigDecimal BANK_CIF) {
        this.BANK_CIF = BANK_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.PARTY_BR
     *
     * @return the value of TRSDETALC_DISBURSE.PARTY_BR
     */
    public BigDecimal getPARTY_BR() {
        return PARTY_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.PARTY_BR
     *
     * @param PARTY_BR the value for TRSDETALC_DISBURSE.PARTY_BR
     */
    public void setPARTY_BR(BigDecimal PARTY_BR) {
        this.PARTY_BR = PARTY_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.PARTY_CY
     *
     * @return the value of TRSDETALC_DISBURSE.PARTY_CY
     */
    public BigDecimal getPARTY_CY() {
        return PARTY_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.PARTY_CY
     *
     * @param PARTY_CY the value for TRSDETALC_DISBURSE.PARTY_CY
     */
    public void setPARTY_CY(BigDecimal PARTY_CY) {
        this.PARTY_CY = PARTY_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.PARTY_GL
     *
     * @return the value of TRSDETALC_DISBURSE.PARTY_GL
     */
    public BigDecimal getPARTY_GL() {
        return PARTY_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.PARTY_GL
     *
     * @param PARTY_GL the value for TRSDETALC_DISBURSE.PARTY_GL
     */
    public void setPARTY_GL(BigDecimal PARTY_GL) {
        this.PARTY_GL = PARTY_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.PARTY_CIF
     *
     * @return the value of TRSDETALC_DISBURSE.PARTY_CIF
     */
    public BigDecimal getPARTY_CIF() {
        return PARTY_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.PARTY_CIF
     *
     * @param PARTY_CIF the value for TRSDETALC_DISBURSE.PARTY_CIF
     */
    public void setPARTY_CIF(BigDecimal PARTY_CIF) {
        this.PARTY_CIF = PARTY_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.PARTY_SL
     *
     * @return the value of TRSDETALC_DISBURSE.PARTY_SL
     */
    public BigDecimal getPARTY_SL() {
        return PARTY_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.PARTY_SL
     *
     * @param PARTY_SL the value for TRSDETALC_DISBURSE.PARTY_SL
     */
    public void setPARTY_SL(BigDecimal PARTY_SL) {
        this.PARTY_SL = PARTY_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.NOSTRO_BR
     *
     * @return the value of TRSDETALC_DISBURSE.NOSTRO_BR
     */
    public BigDecimal getNOSTRO_BR() {
        return NOSTRO_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.NOSTRO_BR
     *
     * @param NOSTRO_BR the value for TRSDETALC_DISBURSE.NOSTRO_BR
     */
    public void setNOSTRO_BR(BigDecimal NOSTRO_BR) {
        this.NOSTRO_BR = NOSTRO_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.NOSTRO_CY
     *
     * @return the value of TRSDETALC_DISBURSE.NOSTRO_CY
     */
    public BigDecimal getNOSTRO_CY() {
        return NOSTRO_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.NOSTRO_CY
     *
     * @param NOSTRO_CY the value for TRSDETALC_DISBURSE.NOSTRO_CY
     */
    public void setNOSTRO_CY(BigDecimal NOSTRO_CY) {
        this.NOSTRO_CY = NOSTRO_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.NOSTRO_GL
     *
     * @return the value of TRSDETALC_DISBURSE.NOSTRO_GL
     */
    public BigDecimal getNOSTRO_GL() {
        return NOSTRO_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.NOSTRO_GL
     *
     * @param NOSTRO_GL the value for TRSDETALC_DISBURSE.NOSTRO_GL
     */
    public void setNOSTRO_GL(BigDecimal NOSTRO_GL) {
        this.NOSTRO_GL = NOSTRO_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.NOSTRO_CIF
     *
     * @return the value of TRSDETALC_DISBURSE.NOSTRO_CIF
     */
    public BigDecimal getNOSTRO_CIF() {
        return NOSTRO_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.NOSTRO_CIF
     *
     * @param NOSTRO_CIF the value for TRSDETALC_DISBURSE.NOSTRO_CIF
     */
    public void setNOSTRO_CIF(BigDecimal NOSTRO_CIF) {
        this.NOSTRO_CIF = NOSTRO_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.NOSTRO_SL
     *
     * @return the value of TRSDETALC_DISBURSE.NOSTRO_SL
     */
    public BigDecimal getNOSTRO_SL() {
        return NOSTRO_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.NOSTRO_SL
     *
     * @param NOSTRO_SL the value for TRSDETALC_DISBURSE.NOSTRO_SL
     */
    public void setNOSTRO_SL(BigDecimal NOSTRO_SL) {
        this.NOSTRO_SL = NOSTRO_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.AMOUNT
     *
     * @return the value of TRSDETALC_DISBURSE.AMOUNT
     */
    public BigDecimal getAMOUNT() {
        return AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.AMOUNT
     *
     * @param AMOUNT the value for TRSDETALC_DISBURSE.AMOUNT
     */
    public void setAMOUNT(BigDecimal AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.YIELD
     *
     * @return the value of TRSDETALC_DISBURSE.YIELD
     */
    public BigDecimal getYIELD() {
        return YIELD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.YIELD
     *
     * @param YIELD the value for TRSDETALC_DISBURSE.YIELD
     */
    public void setYIELD(BigDecimal YIELD) {
        this.YIELD = YIELD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.BC_FLAG
     *
     * @return the value of TRSDETALC_DISBURSE.BC_FLAG
     */
    public String getBC_FLAG() {
        return BC_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.BC_FLAG
     *
     * @param BC_FLAG the value for TRSDETALC_DISBURSE.BC_FLAG
     */
    public void setBC_FLAG(String BC_FLAG) {
        this.BC_FLAG = BC_FLAG == null ? null : BC_FLAG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.RATE
     *
     * @return the value of TRSDETALC_DISBURSE.RATE
     */
    public BigDecimal getRATE() {
        return RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.RATE
     *
     * @param RATE the value for TRSDETALC_DISBURSE.RATE
     */
    public void setRATE(BigDecimal RATE) {
        this.RATE = RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.UNIT
     *
     * @return the value of TRSDETALC_DISBURSE.UNIT
     */
    public BigDecimal getUNIT() {
        return UNIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.UNIT
     *
     * @param UNIT the value for TRSDETALC_DISBURSE.UNIT
     */
    public void setUNIT(BigDecimal UNIT) {
        this.UNIT = UNIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.ROLLOVER_IND
     *
     * @return the value of TRSDETALC_DISBURSE.ROLLOVER_IND
     */
    public String getROLLOVER_IND() {
        return ROLLOVER_IND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.ROLLOVER_IND
     *
     * @param ROLLOVER_IND the value for TRSDETALC_DISBURSE.ROLLOVER_IND
     */
    public void setROLLOVER_IND(String ROLLOVER_IND) {
        this.ROLLOVER_IND = ROLLOVER_IND == null ? null : ROLLOVER_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.ROLLOVER_AMOUNT
     *
     * @return the value of TRSDETALC_DISBURSE.ROLLOVER_AMOUNT
     */
    public BigDecimal getROLLOVER_AMOUNT() {
        return ROLLOVER_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.ROLLOVER_AMOUNT
     *
     * @param ROLLOVER_AMOUNT the value for TRSDETALC_DISBURSE.ROLLOVER_AMOUNT
     */
    public void setROLLOVER_AMOUNT(BigDecimal ROLLOVER_AMOUNT) {
        this.ROLLOVER_AMOUNT = ROLLOVER_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.AMOUNT_USED
     *
     * @return the value of TRSDETALC_DISBURSE.AMOUNT_USED
     */
    public BigDecimal getAMOUNT_USED() {
        return AMOUNT_USED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.AMOUNT_USED
     *
     * @param AMOUNT_USED the value for TRSDETALC_DISBURSE.AMOUNT_USED
     */
    public void setAMOUNT_USED(BigDecimal AMOUNT_USED) {
        this.AMOUNT_USED = AMOUNT_USED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLASS
     *
     * @return the value of TRSDETALC_DISBURSE.CLASS
     */
    public BigDecimal getCLASS() {
        return CLASS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLASS
     *
     * @param CLASS the value for TRSDETALC_DISBURSE.CLASS
     */
    public void setCLASS(BigDecimal CLASS) {
        this.CLASS = CLASS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.ROLLOVER_SERIAL_NO
     *
     * @return the value of TRSDETALC_DISBURSE.ROLLOVER_SERIAL_NO
     */
    public BigDecimal getROLLOVER_SERIAL_NO() {
        return ROLLOVER_SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.ROLLOVER_SERIAL_NO
     *
     * @param ROLLOVER_SERIAL_NO the value for TRSDETALC_DISBURSE.ROLLOVER_SERIAL_NO
     */
    public void setROLLOVER_SERIAL_NO(BigDecimal ROLLOVER_SERIAL_NO) {
        this.ROLLOVER_SERIAL_NO = ROLLOVER_SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.ROLLOVER_LINE_NO
     *
     * @return the value of TRSDETALC_DISBURSE.ROLLOVER_LINE_NO
     */
    public BigDecimal getROLLOVER_LINE_NO() {
        return ROLLOVER_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.ROLLOVER_LINE_NO
     *
     * @param ROLLOVER_LINE_NO the value for TRSDETALC_DISBURSE.ROLLOVER_LINE_NO
     */
    public void setROLLOVER_LINE_NO(BigDecimal ROLLOVER_LINE_NO) {
        this.ROLLOVER_LINE_NO = ROLLOVER_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.ROLLOVER_LINE_NO_ALC
     *
     * @return the value of TRSDETALC_DISBURSE.ROLLOVER_LINE_NO_ALC
     */
    public BigDecimal getROLLOVER_LINE_NO_ALC() {
        return ROLLOVER_LINE_NO_ALC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.ROLLOVER_LINE_NO_ALC
     *
     * @param ROLLOVER_LINE_NO_ALC the value for TRSDETALC_DISBURSE.ROLLOVER_LINE_NO_ALC
     */
    public void setROLLOVER_LINE_NO_ALC(BigDecimal ROLLOVER_LINE_NO_ALC) {
        this.ROLLOVER_LINE_NO_ALC = ROLLOVER_LINE_NO_ALC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.PAYMENT_INSTRUCTION
     *
     * @return the value of TRSDETALC_DISBURSE.PAYMENT_INSTRUCTION
     */
    public BigDecimal getPAYMENT_INSTRUCTION() {
        return PAYMENT_INSTRUCTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.PAYMENT_INSTRUCTION
     *
     * @param PAYMENT_INSTRUCTION the value for TRSDETALC_DISBURSE.PAYMENT_INSTRUCTION
     */
    public void setPAYMENT_INSTRUCTION(BigDecimal PAYMENT_INSTRUCTION) {
        this.PAYMENT_INSTRUCTION = PAYMENT_INSTRUCTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.INVESTMENT_ACC_GL
     *
     * @return the value of TRSDETALC_DISBURSE.INVESTMENT_ACC_GL
     */
    public BigDecimal getINVESTMENT_ACC_GL() {
        return INVESTMENT_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.INVESTMENT_ACC_GL
     *
     * @param INVESTMENT_ACC_GL the value for TRSDETALC_DISBURSE.INVESTMENT_ACC_GL
     */
    public void setINVESTMENT_ACC_GL(BigDecimal INVESTMENT_ACC_GL) {
        this.INVESTMENT_ACC_GL = INVESTMENT_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.INVESTMENT_ACC_CIF
     *
     * @return the value of TRSDETALC_DISBURSE.INVESTMENT_ACC_CIF
     */
    public BigDecimal getINVESTMENT_ACC_CIF() {
        return INVESTMENT_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.INVESTMENT_ACC_CIF
     *
     * @param INVESTMENT_ACC_CIF the value for TRSDETALC_DISBURSE.INVESTMENT_ACC_CIF
     */
    public void setINVESTMENT_ACC_CIF(BigDecimal INVESTMENT_ACC_CIF) {
        this.INVESTMENT_ACC_CIF = INVESTMENT_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.INVESTMENT_ACC_SL
     *
     * @return the value of TRSDETALC_DISBURSE.INVESTMENT_ACC_SL
     */
    public BigDecimal getINVESTMENT_ACC_SL() {
        return INVESTMENT_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.INVESTMENT_ACC_SL
     *
     * @param INVESTMENT_ACC_SL the value for TRSDETALC_DISBURSE.INVESTMENT_ACC_SL
     */
    public void setINVESTMENT_ACC_SL(BigDecimal INVESTMENT_ACC_SL) {
        this.INVESTMENT_ACC_SL = INVESTMENT_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CROSS_CY_RATE
     *
     * @return the value of TRSDETALC_DISBURSE.CROSS_CY_RATE
     */
    public BigDecimal getCROSS_CY_RATE() {
        return CROSS_CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CROSS_CY_RATE
     *
     * @param CROSS_CY_RATE the value for TRSDETALC_DISBURSE.CROSS_CY_RATE
     */
    public void setCROSS_CY_RATE(BigDecimal CROSS_CY_RATE) {
        this.CROSS_CY_RATE = CROSS_CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CROSS_CY_MULT_DIV
     *
     * @return the value of TRSDETALC_DISBURSE.CROSS_CY_MULT_DIV
     */
    public String getCROSS_CY_MULT_DIV() {
        return CROSS_CY_MULT_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CROSS_CY_MULT_DIV
     *
     * @param CROSS_CY_MULT_DIV the value for TRSDETALC_DISBURSE.CROSS_CY_MULT_DIV
     */
    public void setCROSS_CY_MULT_DIV(String CROSS_CY_MULT_DIV) {
        this.CROSS_CY_MULT_DIV = CROSS_CY_MULT_DIV == null ? null : CROSS_CY_MULT_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CROSS_CY_AMOUNT
     *
     * @return the value of TRSDETALC_DISBURSE.CROSS_CY_AMOUNT
     */
    public BigDecimal getCROSS_CY_AMOUNT() {
        return CROSS_CY_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CROSS_CY_AMOUNT
     *
     * @param CROSS_CY_AMOUNT the value for TRSDETALC_DISBURSE.CROSS_CY_AMOUNT
     */
    public void setCROSS_CY_AMOUNT(BigDecimal CROSS_CY_AMOUNT) {
        this.CROSS_CY_AMOUNT = CROSS_CY_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_RATE
     *
     * @return the value of TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_RATE
     */
    public BigDecimal getNOSTRO_CROSS_CY_RATE() {
        return NOSTRO_CROSS_CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_RATE
     *
     * @param NOSTRO_CROSS_CY_RATE the value for TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_RATE
     */
    public void setNOSTRO_CROSS_CY_RATE(BigDecimal NOSTRO_CROSS_CY_RATE) {
        this.NOSTRO_CROSS_CY_RATE = NOSTRO_CROSS_CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_MULT_DIV
     *
     * @return the value of TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_MULT_DIV
     */
    public String getNOSTRO_CROSS_CY_MULT_DIV() {
        return NOSTRO_CROSS_CY_MULT_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_MULT_DIV
     *
     * @param NOSTRO_CROSS_CY_MULT_DIV the value for TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_MULT_DIV
     */
    public void setNOSTRO_CROSS_CY_MULT_DIV(String NOSTRO_CROSS_CY_MULT_DIV) {
        this.NOSTRO_CROSS_CY_MULT_DIV = NOSTRO_CROSS_CY_MULT_DIV == null ? null : NOSTRO_CROSS_CY_MULT_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_AMOUNT
     *
     * @return the value of TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_AMOUNT
     */
    public BigDecimal getNOSTRO_CROSS_CY_AMOUNT() {
        return NOSTRO_CROSS_CY_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_AMOUNT
     *
     * @param NOSTRO_CROSS_CY_AMOUNT the value for TRSDETALC_DISBURSE.NOSTRO_CROSS_CY_AMOUNT
     */
    public void setNOSTRO_CROSS_CY_AMOUNT(BigDecimal NOSTRO_CROSS_CY_AMOUNT) {
        this.NOSTRO_CROSS_CY_AMOUNT = NOSTRO_CROSS_CY_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.EXPECTED_YIELD
     *
     * @return the value of TRSDETALC_DISBURSE.EXPECTED_YIELD
     */
    public BigDecimal getEXPECTED_YIELD() {
        return EXPECTED_YIELD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.EXPECTED_YIELD
     *
     * @param EXPECTED_YIELD the value for TRSDETALC_DISBURSE.EXPECTED_YIELD
     */
    public void setEXPECTED_YIELD(BigDecimal EXPECTED_YIELD) {
        this.EXPECTED_YIELD = EXPECTED_YIELD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.POINT_CY
     *
     * @return the value of TRSDETALC_DISBURSE.POINT_CY
     */
    public BigDecimal getPOINT_CY() {
        return POINT_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.POINT_CY
     *
     * @param POINT_CY the value for TRSDETALC_DISBURSE.POINT_CY
     */
    public void setPOINT_CY(BigDecimal POINT_CY) {
        this.POINT_CY = POINT_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.POINT_GL
     *
     * @return the value of TRSDETALC_DISBURSE.POINT_GL
     */
    public BigDecimal getPOINT_GL() {
        return POINT_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.POINT_GL
     *
     * @param POINT_GL the value for TRSDETALC_DISBURSE.POINT_GL
     */
    public void setPOINT_GL(BigDecimal POINT_GL) {
        this.POINT_GL = POINT_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.POINT_CIF
     *
     * @return the value of TRSDETALC_DISBURSE.POINT_CIF
     */
    public BigDecimal getPOINT_CIF() {
        return POINT_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.POINT_CIF
     *
     * @param POINT_CIF the value for TRSDETALC_DISBURSE.POINT_CIF
     */
    public void setPOINT_CIF(BigDecimal POINT_CIF) {
        this.POINT_CIF = POINT_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.POINT_SL
     *
     * @return the value of TRSDETALC_DISBURSE.POINT_SL
     */
    public BigDecimal getPOINT_SL() {
        return POINT_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.POINT_SL
     *
     * @param POINT_SL the value for TRSDETALC_DISBURSE.POINT_SL
     */
    public void setPOINT_SL(BigDecimal POINT_SL) {
        this.POINT_SL = POINT_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.LIBOR_RATE
     *
     * @return the value of TRSDETALC_DISBURSE.LIBOR_RATE
     */
    public BigDecimal getLIBOR_RATE() {
        return LIBOR_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.LIBOR_RATE
     *
     * @param LIBOR_RATE the value for TRSDETALC_DISBURSE.LIBOR_RATE
     */
    public void setLIBOR_RATE(BigDecimal LIBOR_RATE) {
        this.LIBOR_RATE = LIBOR_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.MATURITY_INSTRUCTION
     *
     * @return the value of TRSDETALC_DISBURSE.MATURITY_INSTRUCTION
     */
    public BigDecimal getMATURITY_INSTRUCTION() {
        return MATURITY_INSTRUCTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.MATURITY_INSTRUCTION
     *
     * @param MATURITY_INSTRUCTION the value for TRSDETALC_DISBURSE.MATURITY_INSTRUCTION
     */
    public void setMATURITY_INSTRUCTION(BigDecimal MATURITY_INSTRUCTION) {
        this.MATURITY_INSTRUCTION = MATURITY_INSTRUCTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.POINT_TRX_NO
     *
     * @return the value of TRSDETALC_DISBURSE.POINT_TRX_NO
     */
    public BigDecimal getPOINT_TRX_NO() {
        return POINT_TRX_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.POINT_TRX_NO
     *
     * @param POINT_TRX_NO the value for TRSDETALC_DISBURSE.POINT_TRX_NO
     */
    public void setPOINT_TRX_NO(BigDecimal POINT_TRX_NO) {
        this.POINT_TRX_NO = POINT_TRX_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.ORG_EXPECTED_YIELD
     *
     * @return the value of TRSDETALC_DISBURSE.ORG_EXPECTED_YIELD
     */
    public BigDecimal getORG_EXPECTED_YIELD() {
        return ORG_EXPECTED_YIELD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.ORG_EXPECTED_YIELD
     *
     * @param ORG_EXPECTED_YIELD the value for TRSDETALC_DISBURSE.ORG_EXPECTED_YIELD
     */
    public void setORG_EXPECTED_YIELD(BigDecimal ORG_EXPECTED_YIELD) {
        this.ORG_EXPECTED_YIELD = ORG_EXPECTED_YIELD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_CY
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_CY
     */
    public BigDecimal getCLI_DEP_CY() {
        return CLI_DEP_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_CY
     *
     * @param CLI_DEP_CY the value for TRSDETALC_DISBURSE.CLI_DEP_CY
     */
    public void setCLI_DEP_CY(BigDecimal CLI_DEP_CY) {
        this.CLI_DEP_CY = CLI_DEP_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_GL
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_GL
     */
    public BigDecimal getCLI_DEP_GL() {
        return CLI_DEP_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_GL
     *
     * @param CLI_DEP_GL the value for TRSDETALC_DISBURSE.CLI_DEP_GL
     */
    public void setCLI_DEP_GL(BigDecimal CLI_DEP_GL) {
        this.CLI_DEP_GL = CLI_DEP_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_CIF
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_CIF
     */
    public BigDecimal getCLI_DEP_CIF() {
        return CLI_DEP_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_CIF
     *
     * @param CLI_DEP_CIF the value for TRSDETALC_DISBURSE.CLI_DEP_CIF
     */
    public void setCLI_DEP_CIF(BigDecimal CLI_DEP_CIF) {
        this.CLI_DEP_CIF = CLI_DEP_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_SL
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_SL
     */
    public BigDecimal getCLI_DEP_SL() {
        return CLI_DEP_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_SL
     *
     * @param CLI_DEP_SL the value for TRSDETALC_DISBURSE.CLI_DEP_SL
     */
    public void setCLI_DEP_SL(BigDecimal CLI_DEP_SL) {
        this.CLI_DEP_SL = CLI_DEP_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CY
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CY
     */
    public BigDecimal getCLI_DEP_NOSTRO_CY() {
        return CLI_DEP_NOSTRO_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CY
     *
     * @param CLI_DEP_NOSTRO_CY the value for TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CY
     */
    public void setCLI_DEP_NOSTRO_CY(BigDecimal CLI_DEP_NOSTRO_CY) {
        this.CLI_DEP_NOSTRO_CY = CLI_DEP_NOSTRO_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_GL
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_GL
     */
    public BigDecimal getCLI_DEP_NOSTRO_GL() {
        return CLI_DEP_NOSTRO_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_GL
     *
     * @param CLI_DEP_NOSTRO_GL the value for TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_GL
     */
    public void setCLI_DEP_NOSTRO_GL(BigDecimal CLI_DEP_NOSTRO_GL) {
        this.CLI_DEP_NOSTRO_GL = CLI_DEP_NOSTRO_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CIF
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CIF
     */
    public BigDecimal getCLI_DEP_NOSTRO_CIF() {
        return CLI_DEP_NOSTRO_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CIF
     *
     * @param CLI_DEP_NOSTRO_CIF the value for TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CIF
     */
    public void setCLI_DEP_NOSTRO_CIF(BigDecimal CLI_DEP_NOSTRO_CIF) {
        this.CLI_DEP_NOSTRO_CIF = CLI_DEP_NOSTRO_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_SL
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_SL
     */
    public BigDecimal getCLI_DEP_NOSTRO_SL() {
        return CLI_DEP_NOSTRO_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_SL
     *
     * @param CLI_DEP_NOSTRO_SL the value for TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_SL
     */
    public void setCLI_DEP_NOSTRO_SL(BigDecimal CLI_DEP_NOSTRO_SL) {
        this.CLI_DEP_NOSTRO_SL = CLI_DEP_NOSTRO_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_RATE
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_RATE
     */
    public BigDecimal getCLI_DEP_CROSS_CY_RATE() {
        return CLI_DEP_CROSS_CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_RATE
     *
     * @param CLI_DEP_CROSS_CY_RATE the value for TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_RATE
     */
    public void setCLI_DEP_CROSS_CY_RATE(BigDecimal CLI_DEP_CROSS_CY_RATE) {
        this.CLI_DEP_CROSS_CY_RATE = CLI_DEP_CROSS_CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_MULT_DIV
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_MULT_DIV
     */
    public String getCLI_DEP_CROSS_CY_MULT_DIV() {
        return CLI_DEP_CROSS_CY_MULT_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_MULT_DIV
     *
     * @param CLI_DEP_CROSS_CY_MULT_DIV the value for TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_MULT_DIV
     */
    public void setCLI_DEP_CROSS_CY_MULT_DIV(String CLI_DEP_CROSS_CY_MULT_DIV) {
        this.CLI_DEP_CROSS_CY_MULT_DIV = CLI_DEP_CROSS_CY_MULT_DIV == null ? null : CLI_DEP_CROSS_CY_MULT_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_AMOUNT
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_AMOUNT
     */
    public BigDecimal getCLI_DEP_CROSS_CY_AMOUNT() {
        return CLI_DEP_CROSS_CY_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_AMOUNT
     *
     * @param CLI_DEP_CROSS_CY_AMOUNT the value for TRSDETALC_DISBURSE.CLI_DEP_CROSS_CY_AMOUNT
     */
    public void setCLI_DEP_CROSS_CY_AMOUNT(BigDecimal CLI_DEP_CROSS_CY_AMOUNT) {
        this.CLI_DEP_CROSS_CY_AMOUNT = CLI_DEP_CROSS_CY_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_CY_RATE
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_CY_RATE
     */
    public BigDecimal getCLI_DEP_NOSTRO_CROSS_CY_RATE() {
        return CLI_DEP_NOSTRO_CROSS_CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_CY_RATE
     *
     * @param CLI_DEP_NOSTRO_CROSS_CY_RATE the value for TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_CY_RATE
     */
    public void setCLI_DEP_NOSTRO_CROSS_CY_RATE(BigDecimal CLI_DEP_NOSTRO_CROSS_CY_RATE) {
        this.CLI_DEP_NOSTRO_CROSS_CY_RATE = CLI_DEP_NOSTRO_CROSS_CY_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_MULT_DIV
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_MULT_DIV
     */
    public String getCLI_DEP_NOSTRO_CROSS_MULT_DIV() {
        return CLI_DEP_NOSTRO_CROSS_MULT_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_MULT_DIV
     *
     * @param CLI_DEP_NOSTRO_CROSS_MULT_DIV the value for TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_MULT_DIV
     */
    public void setCLI_DEP_NOSTRO_CROSS_MULT_DIV(String CLI_DEP_NOSTRO_CROSS_MULT_DIV) {
        this.CLI_DEP_NOSTRO_CROSS_MULT_DIV = CLI_DEP_NOSTRO_CROSS_MULT_DIV == null ? null : CLI_DEP_NOSTRO_CROSS_MULT_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_CY_AMOUNT
     *
     * @return the value of TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_CY_AMOUNT
     */
    public BigDecimal getCLI_DEP_NOSTRO_CROSS_CY_AMOUNT() {
        return CLI_DEP_NOSTRO_CROSS_CY_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_CY_AMOUNT
     *
     * @param CLI_DEP_NOSTRO_CROSS_CY_AMOUNT the value for TRSDETALC_DISBURSE.CLI_DEP_NOSTRO_CROSS_CY_AMOUNT
     */
    public void setCLI_DEP_NOSTRO_CROSS_CY_AMOUNT(BigDecimal CLI_DEP_NOSTRO_CROSS_CY_AMOUNT) {
        this.CLI_DEP_NOSTRO_CROSS_CY_AMOUNT = CLI_DEP_NOSTRO_CROSS_CY_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.VALUE_DATE
     *
     * @return the value of TRSDETALC_DISBURSE.VALUE_DATE
     */
    public Date getVALUE_DATE() {
        return VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.VALUE_DATE
     *
     * @param VALUE_DATE the value for TRSDETALC_DISBURSE.VALUE_DATE
     */
    public void setVALUE_DATE(Date VALUE_DATE) {
        this.VALUE_DATE = VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC_DISBURSE.DISBURSEMENT_NO
     *
     * @return the value of TRSDETALC_DISBURSE.DISBURSEMENT_NO
     */
    public BigDecimal getDISBURSEMENT_NO() {
        return DISBURSEMENT_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC_DISBURSE.DISBURSEMENT_NO
     *
     * @param DISBURSEMENT_NO the value for TRSDETALC_DISBURSE.DISBURSEMENT_NO
     */
    public void setDISBURSEMENT_NO(BigDecimal DISBURSEMENT_NO) {
        this.DISBURSEMENT_NO = DISBURSEMENT_NO;
    }
}