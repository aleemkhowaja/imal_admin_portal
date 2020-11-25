package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class TRSDEAL_COUNTRY_HOLIDAY_PFXVO extends TRSDEAL_COUNTRY_HOLIDAY_PFXVOKey {
    /**
     * This field corresponds to the database column TRSDEAL_COUNTRY_HOLIDAY_PFX.COUNTRY_CODE
     */
    private BigDecimal COUNTRY_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_COUNTRY_HOLIDAY_PFX.COUNTRY_CODE
     *
     * @return the value of TRSDEAL_COUNTRY_HOLIDAY_PFX.COUNTRY_CODE
     */
    public BigDecimal getCOUNTRY_CODE() {
        return COUNTRY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_COUNTRY_HOLIDAY_PFX.COUNTRY_CODE
     *
     * @param COUNTRY_CODE the value for TRSDEAL_COUNTRY_HOLIDAY_PFX.COUNTRY_CODE
     */
    public void setCOUNTRY_CODE(BigDecimal COUNTRY_CODE) {
        this.COUNTRY_CODE = COUNTRY_CODE;
    }
}