package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class COUNTRY_CALENDARVOKey extends BaseVO {
    /**
     * This field corresponds to the database column COUNTRY_CALENDAR.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column COUNTRY_CALENDAR.COUNTRY_CODE
     */
    private BigDecimal COUNTRY_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COUNTRY_CALENDAR.COMP_CODE
     *
     * @return the value of COUNTRY_CALENDAR.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COUNTRY_CALENDAR.COMP_CODE
     *
     * @param COMP_CODE the value for COUNTRY_CALENDAR.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COUNTRY_CALENDAR.COUNTRY_CODE
     *
     * @return the value of COUNTRY_CALENDAR.COUNTRY_CODE
     */
    public BigDecimal getCOUNTRY_CODE() {
        return COUNTRY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COUNTRY_CALENDAR.COUNTRY_CODE
     *
     * @param COUNTRY_CODE the value for COUNTRY_CALENDAR.COUNTRY_CODE
     */
    public void setCOUNTRY_CODE(BigDecimal COUNTRY_CODE) {
        this.COUNTRY_CODE = COUNTRY_CODE;
    }
}