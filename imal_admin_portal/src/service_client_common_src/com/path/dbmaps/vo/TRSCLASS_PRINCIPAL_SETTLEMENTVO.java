package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class TRSCLASS_PRINCIPAL_SETTLEMENTVO extends TRSCLASS_PRINCIPAL_SETTLEMENTVOKey {
    /**
     * This field corresponds to the database column TRSCLASS_PRINCIPAL_SETTLEMENT.TO_PERIOD
     */
    private BigDecimal TO_PERIOD;

    /**
     * This field corresponds to the database column TRSCLASS_PRINCIPAL_SETTLEMENT.MAX_PERCENTAGE
     */
    private BigDecimal MAX_PERCENTAGE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCLASS_PRINCIPAL_SETTLEMENT.TO_PERIOD
     *
     * @return the value of TRSCLASS_PRINCIPAL_SETTLEMENT.TO_PERIOD
     */
    public BigDecimal getTO_PERIOD() {
        return TO_PERIOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCLASS_PRINCIPAL_SETTLEMENT.TO_PERIOD
     *
     * @param TO_PERIOD the value for TRSCLASS_PRINCIPAL_SETTLEMENT.TO_PERIOD
     */
    public void setTO_PERIOD(BigDecimal TO_PERIOD) {
        this.TO_PERIOD = TO_PERIOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCLASS_PRINCIPAL_SETTLEMENT.MAX_PERCENTAGE
     *
     * @return the value of TRSCLASS_PRINCIPAL_SETTLEMENT.MAX_PERCENTAGE
     */
    public BigDecimal getMAX_PERCENTAGE() {
        return MAX_PERCENTAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCLASS_PRINCIPAL_SETTLEMENT.MAX_PERCENTAGE
     *
     * @param MAX_PERCENTAGE the value for TRSCLASS_PRINCIPAL_SETTLEMENT.MAX_PERCENTAGE
     */
    public void setMAX_PERCENTAGE(BigDecimal MAX_PERCENTAGE) {
        this.MAX_PERCENTAGE = MAX_PERCENTAGE;
    }
}