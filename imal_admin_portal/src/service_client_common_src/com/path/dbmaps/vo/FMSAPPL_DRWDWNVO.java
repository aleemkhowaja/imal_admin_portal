package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class FMSAPPL_DRWDWNVO extends FMSAPPL_DRWDWNVOKey {
    /**
     * This field corresponds to the database column FMSAPPL_DRWDWN.TOTAL_AMOUNT
     */
    private BigDecimal TOTAL_AMOUNT;

    /**
     * This field corresponds to the database column FMSAPPL_DRWDWN.UTILIZED_AMOUNT
     */
    private BigDecimal UTILIZED_AMOUNT;

    /**
     * This field corresponds to the database column FMSAPPL_DRWDWN.UNUTILIZED_AMOUNT
     */
    private BigDecimal UNUTILIZED_AMOUNT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_DRWDWN.TOTAL_AMOUNT
     *
     * @return the value of FMSAPPL_DRWDWN.TOTAL_AMOUNT
     */
    public BigDecimal getTOTAL_AMOUNT() {
        return TOTAL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_DRWDWN.TOTAL_AMOUNT
     *
     * @param TOTAL_AMOUNT the value for FMSAPPL_DRWDWN.TOTAL_AMOUNT
     */
    public void setTOTAL_AMOUNT(BigDecimal TOTAL_AMOUNT) {
        this.TOTAL_AMOUNT = TOTAL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_DRWDWN.UTILIZED_AMOUNT
     *
     * @return the value of FMSAPPL_DRWDWN.UTILIZED_AMOUNT
     */
    public BigDecimal getUTILIZED_AMOUNT() {
        return UTILIZED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_DRWDWN.UTILIZED_AMOUNT
     *
     * @param UTILIZED_AMOUNT the value for FMSAPPL_DRWDWN.UTILIZED_AMOUNT
     */
    public void setUTILIZED_AMOUNT(BigDecimal UTILIZED_AMOUNT) {
        this.UTILIZED_AMOUNT = UTILIZED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_DRWDWN.UNUTILIZED_AMOUNT
     *
     * @return the value of FMSAPPL_DRWDWN.UNUTILIZED_AMOUNT
     */
    public BigDecimal getUNUTILIZED_AMOUNT() {
        return UNUTILIZED_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_DRWDWN.UNUTILIZED_AMOUNT
     *
     * @param UNUTILIZED_AMOUNT the value for FMSAPPL_DRWDWN.UNUTILIZED_AMOUNT
     */
    public void setUNUTILIZED_AMOUNT(BigDecimal UNUTILIZED_AMOUNT) {
        this.UNUTILIZED_AMOUNT = UNUTILIZED_AMOUNT;
    }
}