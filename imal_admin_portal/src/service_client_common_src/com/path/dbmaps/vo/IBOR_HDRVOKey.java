package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class IBOR_HDRVOKey extends BaseVO {
    /**
     * This field corresponds to the database column IBOR_HDR.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column IBOR_HDR.CURRENCY_CODE
     */
    private BigDecimal CURRENCY_CODE;

    /**
     * This field corresponds to the database column IBOR_HDR.IBOR_CODE
     */
    private BigDecimal IBOR_CODE;

    /**
     * This field corresponds to the database column IBOR_HDR.LINE_NUMBER
     */
    private BigDecimal LINE_NUMBER;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.COMP_CODE
     *
     * @return the value of IBOR_HDR.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.COMP_CODE
     *
     * @param COMP_CODE the value for IBOR_HDR.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.CURRENCY_CODE
     *
     * @return the value of IBOR_HDR.CURRENCY_CODE
     */
    public BigDecimal getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.CURRENCY_CODE
     *
     * @param CURRENCY_CODE the value for IBOR_HDR.CURRENCY_CODE
     */
    public void setCURRENCY_CODE(BigDecimal CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.IBOR_CODE
     *
     * @return the value of IBOR_HDR.IBOR_CODE
     */
    public BigDecimal getIBOR_CODE() {
        return IBOR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.IBOR_CODE
     *
     * @param IBOR_CODE the value for IBOR_HDR.IBOR_CODE
     */
    public void setIBOR_CODE(BigDecimal IBOR_CODE) {
        this.IBOR_CODE = IBOR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.LINE_NUMBER
     *
     * @return the value of IBOR_HDR.LINE_NUMBER
     */
    public BigDecimal getLINE_NUMBER() {
        return LINE_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.LINE_NUMBER
     *
     * @param LINE_NUMBER the value for IBOR_HDR.LINE_NUMBER
     */
    public void setLINE_NUMBER(BigDecimal LINE_NUMBER) {
        this.LINE_NUMBER = LINE_NUMBER;
    }
}