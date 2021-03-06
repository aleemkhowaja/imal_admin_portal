package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class PFT_EXCEPTIONAL_RATEVO extends PFT_EXCEPTIONAL_RATEVOKey {
    /**
     * This field corresponds to the database column PFT_EXCEPTIONAL_RATE.FROM_AMOUNT
     */
    private BigDecimal FROM_AMOUNT;

    /**
     * This field corresponds to the database column PFT_EXCEPTIONAL_RATE.TO_AMOUNT
     */
    private BigDecimal TO_AMOUNT;

    /**
     * This field corresponds to the database column PFT_EXCEPTIONAL_RATE.PT_RATE
     */
    private BigDecimal PT_RATE;

    /**
     * This field corresponds to the database column PFT_EXCEPTIONAL_RATE.SPECIAL_RATE
     */
    private BigDecimal SPECIAL_RATE;

    /**
     * This field corresponds to the database column PFT_EXCEPTIONAL_RATE.EXPIRY_DATE
     */
    private Date EXPIRY_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PFT_EXCEPTIONAL_RATE.FROM_AMOUNT
     *
     * @return the value of PFT_EXCEPTIONAL_RATE.FROM_AMOUNT
     */
    public BigDecimal getFROM_AMOUNT() {
        return FROM_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PFT_EXCEPTIONAL_RATE.FROM_AMOUNT
     *
     * @param FROM_AMOUNT the value for PFT_EXCEPTIONAL_RATE.FROM_AMOUNT
     */
    public void setFROM_AMOUNT(BigDecimal FROM_AMOUNT) {
        this.FROM_AMOUNT = FROM_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PFT_EXCEPTIONAL_RATE.TO_AMOUNT
     *
     * @return the value of PFT_EXCEPTIONAL_RATE.TO_AMOUNT
     */
    public BigDecimal getTO_AMOUNT() {
        return TO_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PFT_EXCEPTIONAL_RATE.TO_AMOUNT
     *
     * @param TO_AMOUNT the value for PFT_EXCEPTIONAL_RATE.TO_AMOUNT
     */
    public void setTO_AMOUNT(BigDecimal TO_AMOUNT) {
        this.TO_AMOUNT = TO_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PFT_EXCEPTIONAL_RATE.PT_RATE
     *
     * @return the value of PFT_EXCEPTIONAL_RATE.PT_RATE
     */
    public BigDecimal getPT_RATE() {
        return PT_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PFT_EXCEPTIONAL_RATE.PT_RATE
     *
     * @param PT_RATE the value for PFT_EXCEPTIONAL_RATE.PT_RATE
     */
    public void setPT_RATE(BigDecimal PT_RATE) {
        this.PT_RATE = PT_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PFT_EXCEPTIONAL_RATE.SPECIAL_RATE
     *
     * @return the value of PFT_EXCEPTIONAL_RATE.SPECIAL_RATE
     */
    public BigDecimal getSPECIAL_RATE() {
        return SPECIAL_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PFT_EXCEPTIONAL_RATE.SPECIAL_RATE
     *
     * @param SPECIAL_RATE the value for PFT_EXCEPTIONAL_RATE.SPECIAL_RATE
     */
    public void setSPECIAL_RATE(BigDecimal SPECIAL_RATE) {
        this.SPECIAL_RATE = SPECIAL_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PFT_EXCEPTIONAL_RATE.EXPIRY_DATE
     *
     * @return the value of PFT_EXCEPTIONAL_RATE.EXPIRY_DATE
     */
    public Date getEXPIRY_DATE() {
        return EXPIRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PFT_EXCEPTIONAL_RATE.EXPIRY_DATE
     *
     * @param EXPIRY_DATE the value for PFT_EXCEPTIONAL_RATE.EXPIRY_DATE
     */
    public void setEXPIRY_DATE(Date EXPIRY_DATE) {
        this.EXPIRY_DATE = EXPIRY_DATE;
    }
}