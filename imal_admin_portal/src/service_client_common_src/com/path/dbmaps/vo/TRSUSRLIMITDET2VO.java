package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRSUSRLIMITDET2VO extends TRSUSRLIMITDET2VOKey {
    /**
     * This field corresponds to the database column TRSUSRLIMITDET2.PERIOD
     */
    private BigDecimal PERIOD;

    /**
     * This field corresponds to the database column TRSUSRLIMITDET2.PERIOD_TYPE
     */
    private String PERIOD_TYPE;

    /**
     * This field corresponds to the database column TRSUSRLIMITDET2.LIMIT
     */
    private BigDecimal LIMIT;

    /**
     * This field corresponds to the database column TRSUSRLIMITDET2.LIMIT_ACTUAL
     */
    private BigDecimal LIMIT_ACTUAL;

    /**
     * This field corresponds to the database column TRSUSRLIMITDET2.LAST_CLEARING_DATE
     */
    private Date LAST_CLEARING_DATE;

    /**
     * This field corresponds to the database column TRSUSRLIMITDET2.LIMIT_TYPE
     */
    private String LIMIT_TYPE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSUSRLIMITDET2.PERIOD
     *
     * @return the value of TRSUSRLIMITDET2.PERIOD
     */
    public BigDecimal getPERIOD() {
        return PERIOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSUSRLIMITDET2.PERIOD
     *
     * @param PERIOD the value for TRSUSRLIMITDET2.PERIOD
     */
    public void setPERIOD(BigDecimal PERIOD) {
        this.PERIOD = PERIOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSUSRLIMITDET2.PERIOD_TYPE
     *
     * @return the value of TRSUSRLIMITDET2.PERIOD_TYPE
     */
    public String getPERIOD_TYPE() {
        return PERIOD_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSUSRLIMITDET2.PERIOD_TYPE
     *
     * @param PERIOD_TYPE the value for TRSUSRLIMITDET2.PERIOD_TYPE
     */
    public void setPERIOD_TYPE(String PERIOD_TYPE) {
        this.PERIOD_TYPE = PERIOD_TYPE == null ? null : PERIOD_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSUSRLIMITDET2.LIMIT
     *
     * @return the value of TRSUSRLIMITDET2.LIMIT
     */
    public BigDecimal getLIMIT() {
        return LIMIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSUSRLIMITDET2.LIMIT
     *
     * @param LIMIT the value for TRSUSRLIMITDET2.LIMIT
     */
    public void setLIMIT(BigDecimal LIMIT) {
        this.LIMIT = LIMIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSUSRLIMITDET2.LIMIT_ACTUAL
     *
     * @return the value of TRSUSRLIMITDET2.LIMIT_ACTUAL
     */
    public BigDecimal getLIMIT_ACTUAL() {
        return LIMIT_ACTUAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSUSRLIMITDET2.LIMIT_ACTUAL
     *
     * @param LIMIT_ACTUAL the value for TRSUSRLIMITDET2.LIMIT_ACTUAL
     */
    public void setLIMIT_ACTUAL(BigDecimal LIMIT_ACTUAL) {
        this.LIMIT_ACTUAL = LIMIT_ACTUAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSUSRLIMITDET2.LAST_CLEARING_DATE
     *
     * @return the value of TRSUSRLIMITDET2.LAST_CLEARING_DATE
     */
    public Date getLAST_CLEARING_DATE() {
        return LAST_CLEARING_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSUSRLIMITDET2.LAST_CLEARING_DATE
     *
     * @param LAST_CLEARING_DATE the value for TRSUSRLIMITDET2.LAST_CLEARING_DATE
     */
    public void setLAST_CLEARING_DATE(Date LAST_CLEARING_DATE) {
        this.LAST_CLEARING_DATE = LAST_CLEARING_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSUSRLIMITDET2.LIMIT_TYPE
     *
     * @return the value of TRSUSRLIMITDET2.LIMIT_TYPE
     */
    public String getLIMIT_TYPE() {
        return LIMIT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSUSRLIMITDET2.LIMIT_TYPE
     *
     * @param LIMIT_TYPE the value for TRSUSRLIMITDET2.LIMIT_TYPE
     */
    public void setLIMIT_TYPE(String LIMIT_TYPE) {
        this.LIMIT_TYPE = LIMIT_TYPE == null ? null : LIMIT_TYPE.trim();
    }
}