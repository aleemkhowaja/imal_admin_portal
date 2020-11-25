package com.path.dbmaps.vo;

import java.math.BigDecimal;
  
public class PMSSEC_ECLVO extends PMSSEC_ECLVOKey {
    /**
     * This field corresponds to the database column PMSSEC_ECL.STAGE
     */
    private BigDecimal STAGE;

    /**
     * This field corresponds to the database column PMSSEC_ECL.EL_AMOUNT
     */
    private BigDecimal EL_AMOUNT;

    /**
     * This field corresponds to the database column PMSSEC_ECL.EL_PERCENTAGE
     */
    private BigDecimal EL_PERCENTAGE;

    /**
     * This field corresponds to the database column PMSSEC_ECL.LEL_AMOUNT
     */
    private BigDecimal LEL_AMOUNT;

    /**
     * This field corresponds to the database column PMSSEC_ECL.LEL_PERCENTAGE
     */
    private BigDecimal LEL_PERCENTAGE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSSEC_ECL.STAGE
     *
     * @return the value of PMSSEC_ECL.STAGE
     */
    public BigDecimal getSTAGE() {
        return STAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSSEC_ECL.STAGE
     *
     * @param STAGE the value for PMSSEC_ECL.STAGE
     */
    public void setSTAGE(BigDecimal STAGE) {
        this.STAGE = STAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSSEC_ECL.EL_AMOUNT
     *
     * @return the value of PMSSEC_ECL.EL_AMOUNT
     */
    public BigDecimal getEL_AMOUNT() {
        return EL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSSEC_ECL.EL_AMOUNT
     *
     * @param EL_AMOUNT the value for PMSSEC_ECL.EL_AMOUNT
     */
    public void setEL_AMOUNT(BigDecimal EL_AMOUNT) {
        this.EL_AMOUNT = EL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSSEC_ECL.EL_PERCENTAGE
     *
     * @return the value of PMSSEC_ECL.EL_PERCENTAGE
     */
    public BigDecimal getEL_PERCENTAGE() {
        return EL_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSSEC_ECL.EL_PERCENTAGE
     *
     * @param EL_PERCENTAGE the value for PMSSEC_ECL.EL_PERCENTAGE
     */
    public void setEL_PERCENTAGE(BigDecimal EL_PERCENTAGE) {
        this.EL_PERCENTAGE = EL_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSSEC_ECL.LEL_AMOUNT
     *
     * @return the value of PMSSEC_ECL.LEL_AMOUNT
     */
    public BigDecimal getLEL_AMOUNT() {
        return LEL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSSEC_ECL.LEL_AMOUNT
     *
     * @param LEL_AMOUNT the value for PMSSEC_ECL.LEL_AMOUNT
     */
    public void setLEL_AMOUNT(BigDecimal LEL_AMOUNT) {
        this.LEL_AMOUNT = LEL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSSEC_ECL.LEL_PERCENTAGE
     *
     * @return the value of PMSSEC_ECL.LEL_PERCENTAGE
     */
    public BigDecimal getLEL_PERCENTAGE() {
        return LEL_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSSEC_ECL.LEL_PERCENTAGE
     *
     * @param LEL_PERCENTAGE the value for PMSSEC_ECL.LEL_PERCENTAGE
     */
    public void setLEL_PERCENTAGE(BigDecimal LEL_PERCENTAGE) {
        this.LEL_PERCENTAGE = LEL_PERCENTAGE;
    }
}