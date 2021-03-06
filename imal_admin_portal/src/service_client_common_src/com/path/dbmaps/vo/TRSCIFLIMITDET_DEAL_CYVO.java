package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class TRSCIFLIMITDET_DEAL_CYVO extends TRSCIFLIMITDET_DEAL_CYVOKey {
    /**
     * This field corresponds to the database column TRSCIFLIMITDET_DEAL_CY.CURRENCY_CODE
     */
    private BigDecimal CURRENCY_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCIFLIMITDET_DEAL_CY.CURRENCY_CODE
     *
     * @return the value of TRSCIFLIMITDET_DEAL_CY.CURRENCY_CODE
     */
    public BigDecimal getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCIFLIMITDET_DEAL_CY.CURRENCY_CODE
     *
     * @param CURRENCY_CODE the value for TRSCIFLIMITDET_DEAL_CY.CURRENCY_CODE
     */
    public void setCURRENCY_CODE(BigDecimal CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }
}