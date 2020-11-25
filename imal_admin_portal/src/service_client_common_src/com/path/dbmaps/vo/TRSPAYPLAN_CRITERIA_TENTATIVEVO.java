package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRSPAYPLAN_CRITERIA_TENTATIVEVO extends TRSPAYPLAN_CRITERIA_TENTATIVEVOKey {
    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.FROM_DATE
     */
    private Date FROM_DATE;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.TO_DATE
     */
    private Date TO_DATE;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYMENT_TYPE
     */
    private String PAYMENT_TYPE;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.CAPITAL_AMT
     */
    private BigDecimal CAPITAL_AMT;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIODICITY
     */
    private String PAYM_PERIODICITY;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIOD_NBR
     */
    private BigDecimal PAYM_PERIOD_NBR;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIOD_POS
     */
    private String PAYM_PERIOD_POS;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_BR
     */
    private BigDecimal ACC_BR;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_CY
     */
    private BigDecimal ACC_CY;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_GL
     */
    private BigDecimal ACC_GL;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_CIF
     */
    private BigDecimal ACC_CIF;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_SL
     */
    private BigDecimal ACC_SL;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_BR
     */
    private BigDecimal COVERING_ACC_BR;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_CY
     */
    private BigDecimal COVERING_ACC_CY;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_GL
     */
    private BigDecimal COVERING_ACC_GL;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_CIF
     */
    private BigDecimal COVERING_ACC_CIF;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_SL
     */
    private BigDecimal COVERING_ACC_SL;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.AUTO_CREATE_SETTLEMENT_YN
     */
    private String AUTO_CREATE_SETTLEMENT_YN;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_DAY
     */
    private BigDecimal PAYM_DAY;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_TENTATIVE.NO_OF_PAYMENTS
     */
    private BigDecimal NO_OF_PAYMENTS;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.FROM_DATE
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.FROM_DATE
     */
    public Date getFROM_DATE() {
        return FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.FROM_DATE
     *
     * @param FROM_DATE the value for TRSPAYPLAN_CRITERIA_TENTATIVE.FROM_DATE
     */
    public void setFROM_DATE(Date FROM_DATE) {
        this.FROM_DATE = FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.TO_DATE
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.TO_DATE
     */
    public Date getTO_DATE() {
        return TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.TO_DATE
     *
     * @param TO_DATE the value for TRSPAYPLAN_CRITERIA_TENTATIVE.TO_DATE
     */
    public void setTO_DATE(Date TO_DATE) {
        this.TO_DATE = TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYMENT_TYPE
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.PAYMENT_TYPE
     */
    public String getPAYMENT_TYPE() {
        return PAYMENT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYMENT_TYPE
     *
     * @param PAYMENT_TYPE the value for TRSPAYPLAN_CRITERIA_TENTATIVE.PAYMENT_TYPE
     */
    public void setPAYMENT_TYPE(String PAYMENT_TYPE) {
        this.PAYMENT_TYPE = PAYMENT_TYPE == null ? null : PAYMENT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.CAPITAL_AMT
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.CAPITAL_AMT
     */
    public BigDecimal getCAPITAL_AMT() {
        return CAPITAL_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.CAPITAL_AMT
     *
     * @param CAPITAL_AMT the value for TRSPAYPLAN_CRITERIA_TENTATIVE.CAPITAL_AMT
     */
    public void setCAPITAL_AMT(BigDecimal CAPITAL_AMT) {
        this.CAPITAL_AMT = CAPITAL_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIODICITY
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIODICITY
     */
    public String getPAYM_PERIODICITY() {
        return PAYM_PERIODICITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIODICITY
     *
     * @param PAYM_PERIODICITY the value for TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIODICITY
     */
    public void setPAYM_PERIODICITY(String PAYM_PERIODICITY) {
        this.PAYM_PERIODICITY = PAYM_PERIODICITY == null ? null : PAYM_PERIODICITY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIOD_NBR
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIOD_NBR
     */
    public BigDecimal getPAYM_PERIOD_NBR() {
        return PAYM_PERIOD_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIOD_NBR
     *
     * @param PAYM_PERIOD_NBR the value for TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIOD_NBR
     */
    public void setPAYM_PERIOD_NBR(BigDecimal PAYM_PERIOD_NBR) {
        this.PAYM_PERIOD_NBR = PAYM_PERIOD_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIOD_POS
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIOD_POS
     */
    public String getPAYM_PERIOD_POS() {
        return PAYM_PERIOD_POS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIOD_POS
     *
     * @param PAYM_PERIOD_POS the value for TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_PERIOD_POS
     */
    public void setPAYM_PERIOD_POS(String PAYM_PERIOD_POS) {
        this.PAYM_PERIOD_POS = PAYM_PERIOD_POS == null ? null : PAYM_PERIOD_POS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_BR
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_BR
     */
    public BigDecimal getACC_BR() {
        return ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_BR
     *
     * @param ACC_BR the value for TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_BR
     */
    public void setACC_BR(BigDecimal ACC_BR) {
        this.ACC_BR = ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_CY
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_CY
     */
    public BigDecimal getACC_CY() {
        return ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_CY
     *
     * @param ACC_CY the value for TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_CY
     */
    public void setACC_CY(BigDecimal ACC_CY) {
        this.ACC_CY = ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_GL
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_GL
     */
    public BigDecimal getACC_GL() {
        return ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_GL
     *
     * @param ACC_GL the value for TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_GL
     */
    public void setACC_GL(BigDecimal ACC_GL) {
        this.ACC_GL = ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_CIF
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_CIF
     */
    public BigDecimal getACC_CIF() {
        return ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_CIF
     *
     * @param ACC_CIF the value for TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_CIF
     */
    public void setACC_CIF(BigDecimal ACC_CIF) {
        this.ACC_CIF = ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_SL
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_SL
     */
    public BigDecimal getACC_SL() {
        return ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_SL
     *
     * @param ACC_SL the value for TRSPAYPLAN_CRITERIA_TENTATIVE.ACC_SL
     */
    public void setACC_SL(BigDecimal ACC_SL) {
        this.ACC_SL = ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_BR
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_BR
     */
    public BigDecimal getCOVERING_ACC_BR() {
        return COVERING_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_BR
     *
     * @param COVERING_ACC_BR the value for TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_BR
     */
    public void setCOVERING_ACC_BR(BigDecimal COVERING_ACC_BR) {
        this.COVERING_ACC_BR = COVERING_ACC_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_CY
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_CY
     */
    public BigDecimal getCOVERING_ACC_CY() {
        return COVERING_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_CY
     *
     * @param COVERING_ACC_CY the value for TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_CY
     */
    public void setCOVERING_ACC_CY(BigDecimal COVERING_ACC_CY) {
        this.COVERING_ACC_CY = COVERING_ACC_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_GL
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_GL
     */
    public BigDecimal getCOVERING_ACC_GL() {
        return COVERING_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_GL
     *
     * @param COVERING_ACC_GL the value for TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_GL
     */
    public void setCOVERING_ACC_GL(BigDecimal COVERING_ACC_GL) {
        this.COVERING_ACC_GL = COVERING_ACC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_CIF
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_CIF
     */
    public BigDecimal getCOVERING_ACC_CIF() {
        return COVERING_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_CIF
     *
     * @param COVERING_ACC_CIF the value for TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_CIF
     */
    public void setCOVERING_ACC_CIF(BigDecimal COVERING_ACC_CIF) {
        this.COVERING_ACC_CIF = COVERING_ACC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_SL
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_SL
     */
    public BigDecimal getCOVERING_ACC_SL() {
        return COVERING_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_SL
     *
     * @param COVERING_ACC_SL the value for TRSPAYPLAN_CRITERIA_TENTATIVE.COVERING_ACC_SL
     */
    public void setCOVERING_ACC_SL(BigDecimal COVERING_ACC_SL) {
        this.COVERING_ACC_SL = COVERING_ACC_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.AUTO_CREATE_SETTLEMENT_YN
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.AUTO_CREATE_SETTLEMENT_YN
     */
    public String getAUTO_CREATE_SETTLEMENT_YN() {
        return AUTO_CREATE_SETTLEMENT_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.AUTO_CREATE_SETTLEMENT_YN
     *
     * @param AUTO_CREATE_SETTLEMENT_YN the value for TRSPAYPLAN_CRITERIA_TENTATIVE.AUTO_CREATE_SETTLEMENT_YN
     */
    public void setAUTO_CREATE_SETTLEMENT_YN(String AUTO_CREATE_SETTLEMENT_YN) {
        this.AUTO_CREATE_SETTLEMENT_YN = AUTO_CREATE_SETTLEMENT_YN == null ? null : AUTO_CREATE_SETTLEMENT_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_DAY
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_DAY
     */
    public BigDecimal getPAYM_DAY() {
        return PAYM_DAY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_DAY
     *
     * @param PAYM_DAY the value for TRSPAYPLAN_CRITERIA_TENTATIVE.PAYM_DAY
     */
    public void setPAYM_DAY(BigDecimal PAYM_DAY) {
        this.PAYM_DAY = PAYM_DAY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.NO_OF_PAYMENTS
     *
     * @return the value of TRSPAYPLAN_CRITERIA_TENTATIVE.NO_OF_PAYMENTS
     */
    public BigDecimal getNO_OF_PAYMENTS() {
        return NO_OF_PAYMENTS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_TENTATIVE.NO_OF_PAYMENTS
     *
     * @param NO_OF_PAYMENTS the value for TRSPAYPLAN_CRITERIA_TENTATIVE.NO_OF_PAYMENTS
     */
    public void setNO_OF_PAYMENTS(BigDecimal NO_OF_PAYMENTS) {
        this.NO_OF_PAYMENTS = NO_OF_PAYMENTS;
    }
}