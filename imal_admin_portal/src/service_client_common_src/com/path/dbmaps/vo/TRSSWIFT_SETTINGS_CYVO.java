package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class TRSSWIFT_SETTINGS_CYVO extends TRSSWIFT_SETTINGS_CYVOKey {
    /**
     * This field corresponds to the database column TRSSWIFT_SETTINGS_CY.CY
     */
    private BigDecimal CY;

    /**
     * This field corresponds to the database column TRSSWIFT_SETTINGS_CY.PRODUCT
     */
    private BigDecimal PRODUCT;

    /**
     * This field corresponds to the database column TRSSWIFT_SETTINGS_CY.DAYS
     */
    private BigDecimal DAYS;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSSWIFT_SETTINGS_CY.CY
     *
     * @return the value of TRSSWIFT_SETTINGS_CY.CY
     */
    public BigDecimal getCY() {
        return CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSSWIFT_SETTINGS_CY.CY
     *
     * @param CY the value for TRSSWIFT_SETTINGS_CY.CY
     */
    public void setCY(BigDecimal CY) {
        this.CY = CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSSWIFT_SETTINGS_CY.PRODUCT
     *
     * @return the value of TRSSWIFT_SETTINGS_CY.PRODUCT
     */
    public BigDecimal getPRODUCT() {
        return PRODUCT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSSWIFT_SETTINGS_CY.PRODUCT
     *
     * @param PRODUCT the value for TRSSWIFT_SETTINGS_CY.PRODUCT
     */
    public void setPRODUCT(BigDecimal PRODUCT) {
        this.PRODUCT = PRODUCT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSSWIFT_SETTINGS_CY.DAYS
     *
     * @return the value of TRSSWIFT_SETTINGS_CY.DAYS
     */
    public BigDecimal getDAYS() {
        return DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSSWIFT_SETTINGS_CY.DAYS
     *
     * @param DAYS the value for TRSSWIFT_SETTINGS_CY.DAYS
     */
    public void setDAYS(BigDecimal DAYS) {
        this.DAYS = DAYS;
    }
}