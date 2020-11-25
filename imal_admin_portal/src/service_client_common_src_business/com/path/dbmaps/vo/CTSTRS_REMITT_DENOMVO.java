package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class CTSTRS_REMITT_DENOMVO extends CTSTRS_REMITT_DENOMVOKey {
    /**
     * This field corresponds to the database column CTSTRS_REMITT_DENOM.SERIAL_NO
     */
    private String SERIAL_NO;

    /**
     * This field corresponds to the database column CTSTRS_REMITT_DENOM.FR_TC_NO
     */
    private BigDecimal FR_TC_NO;

    /**
     * This field corresponds to the database column CTSTRS_REMITT_DENOM.TO_TC_NO
     */
    private BigDecimal TO_TC_NO;

    /**
     * This field corresponds to the database column CTSTRS_REMITT_DENOM.QTY
     */
    private BigDecimal QTY;

    /**
     * This field corresponds to the database column CTSTRS_REMITT_DENOM.VALUE
     */
    private BigDecimal VALUE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_REMITT_DENOM.SERIAL_NO
     *
     * @return the value of CTSTRS_REMITT_DENOM.SERIAL_NO
     */
    public String getSERIAL_NO() {
        return SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_REMITT_DENOM.SERIAL_NO
     *
     * @param SERIAL_NO the value for CTSTRS_REMITT_DENOM.SERIAL_NO
     */
    public void setSERIAL_NO(String SERIAL_NO) {
        this.SERIAL_NO = SERIAL_NO == null ? null : SERIAL_NO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_REMITT_DENOM.FR_TC_NO
     *
     * @return the value of CTSTRS_REMITT_DENOM.FR_TC_NO
     */
    public BigDecimal getFR_TC_NO() {
        return FR_TC_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_REMITT_DENOM.FR_TC_NO
     *
     * @param FR_TC_NO the value for CTSTRS_REMITT_DENOM.FR_TC_NO
     */
    public void setFR_TC_NO(BigDecimal FR_TC_NO) {
        this.FR_TC_NO = FR_TC_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_REMITT_DENOM.TO_TC_NO
     *
     * @return the value of CTSTRS_REMITT_DENOM.TO_TC_NO
     */
    public BigDecimal getTO_TC_NO() {
        return TO_TC_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_REMITT_DENOM.TO_TC_NO
     *
     * @param TO_TC_NO the value for CTSTRS_REMITT_DENOM.TO_TC_NO
     */
    public void setTO_TC_NO(BigDecimal TO_TC_NO) {
        this.TO_TC_NO = TO_TC_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_REMITT_DENOM.QTY
     *
     * @return the value of CTSTRS_REMITT_DENOM.QTY
     */
    public BigDecimal getQTY() {
        return QTY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_REMITT_DENOM.QTY
     *
     * @param QTY the value for CTSTRS_REMITT_DENOM.QTY
     */
    public void setQTY(BigDecimal QTY) {
        this.QTY = QTY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRS_REMITT_DENOM.VALUE
     *
     * @return the value of CTSTRS_REMITT_DENOM.VALUE
     */
    public BigDecimal getVALUE() {
        return VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRS_REMITT_DENOM.VALUE
     *
     * @param VALUE the value for CTSTRS_REMITT_DENOM.VALUE
     */
    public void setVALUE(BigDecimal VALUE) {
        this.VALUE = VALUE;
    }
}