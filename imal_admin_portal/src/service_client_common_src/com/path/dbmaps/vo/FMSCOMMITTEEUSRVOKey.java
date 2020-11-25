package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class FMSCOMMITTEEUSRVOKey extends BaseVO {
    /**
     * This field corresponds to the database column FMSCOMMITTEEUSR.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column FMSCOMMITTEEUSR.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column FMSCOMMITTEEUSR.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSCOMMITTEEUSR.CODE
     *
     * @return the value of FMSCOMMITTEEUSR.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSCOMMITTEEUSR.CODE
     *
     * @param CODE the value for FMSCOMMITTEEUSR.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSCOMMITTEEUSR.COMP_CODE
     *
     * @return the value of FMSCOMMITTEEUSR.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSCOMMITTEEUSR.COMP_CODE
     *
     * @param COMP_CODE the value for FMSCOMMITTEEUSR.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSCOMMITTEEUSR.LINE_NO
     *
     * @return the value of FMSCOMMITTEEUSR.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSCOMMITTEEUSR.LINE_NO
     *
     * @param LINE_NO the value for FMSCOMMITTEEUSR.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }
}