package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSCY_RATE_TOLERANCE_LEVELVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSCY_RATE_TOLERANCE_LEVEL.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRSCY_RATE_TOLERANCE_LEVEL.CURRENCY_CODE
     */
    private BigDecimal CURRENCY_CODE;

    /**
     * This field corresponds to the database column TRSCY_RATE_TOLERANCE_LEVEL.USER_ID
     */
    private String USER_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCY_RATE_TOLERANCE_LEVEL.COMP_CODE
     *
     * @return the value of TRSCY_RATE_TOLERANCE_LEVEL.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCY_RATE_TOLERANCE_LEVEL.COMP_CODE
     *
     * @param COMP_CODE the value for TRSCY_RATE_TOLERANCE_LEVEL.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCY_RATE_TOLERANCE_LEVEL.CURRENCY_CODE
     *
     * @return the value of TRSCY_RATE_TOLERANCE_LEVEL.CURRENCY_CODE
     */
    public BigDecimal getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCY_RATE_TOLERANCE_LEVEL.CURRENCY_CODE
     *
     * @param CURRENCY_CODE the value for TRSCY_RATE_TOLERANCE_LEVEL.CURRENCY_CODE
     */
    public void setCURRENCY_CODE(BigDecimal CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCY_RATE_TOLERANCE_LEVEL.USER_ID
     *
     * @return the value of TRSCY_RATE_TOLERANCE_LEVEL.USER_ID
     */
    public String getUSER_ID() {
        return USER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCY_RATE_TOLERANCE_LEVEL.USER_ID
     *
     * @param USER_ID the value for TRSCY_RATE_TOLERANCE_LEVEL.USER_ID
     */
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID == null ? null : USER_ID.trim();
    }
}