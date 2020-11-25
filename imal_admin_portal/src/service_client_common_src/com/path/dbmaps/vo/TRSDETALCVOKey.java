package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSDETALCVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSDETALC.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRSDETALC.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRSDETALC.DEAL_IND
     */
    private String DEAL_IND;

    /**
     * This field corresponds to the database column TRSDETALC.FUND_LINE_NO
     */
    private BigDecimal FUND_LINE_NO;

    /**
     * This field corresponds to the database column TRSDETALC.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column TRSDETALC.LINE_NO_ALC
     */
    private BigDecimal LINE_NO_ALC;

    /**
     * This field corresponds to the database column TRSDETALC.SERIAL_NO
     */
    private BigDecimal SERIAL_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC.BRANCH_CODE
     *
     * @return the value of TRSDETALC.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRSDETALC.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC.COMP_CODE
     *
     * @return the value of TRSDETALC.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC.COMP_CODE
     *
     * @param COMP_CODE the value for TRSDETALC.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC.DEAL_IND
     *
     * @return the value of TRSDETALC.DEAL_IND
     */
    public String getDEAL_IND() {
        return DEAL_IND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC.DEAL_IND
     *
     * @param DEAL_IND the value for TRSDETALC.DEAL_IND
     */
    public void setDEAL_IND(String DEAL_IND) {
        this.DEAL_IND = DEAL_IND == null ? null : DEAL_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC.FUND_LINE_NO
     *
     * @return the value of TRSDETALC.FUND_LINE_NO
     */
    public BigDecimal getFUND_LINE_NO() {
        return FUND_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC.FUND_LINE_NO
     *
     * @param FUND_LINE_NO the value for TRSDETALC.FUND_LINE_NO
     */
    public void setFUND_LINE_NO(BigDecimal FUND_LINE_NO) {
        this.FUND_LINE_NO = FUND_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC.LINE_NO
     *
     * @return the value of TRSDETALC.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC.LINE_NO
     *
     * @param LINE_NO the value for TRSDETALC.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC.LINE_NO_ALC
     *
     * @return the value of TRSDETALC.LINE_NO_ALC
     */
    public BigDecimal getLINE_NO_ALC() {
        return LINE_NO_ALC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC.LINE_NO_ALC
     *
     * @param LINE_NO_ALC the value for TRSDETALC.LINE_NO_ALC
     */
    public void setLINE_NO_ALC(BigDecimal LINE_NO_ALC) {
        this.LINE_NO_ALC = LINE_NO_ALC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDETALC.SERIAL_NO
     *
     * @return the value of TRSDETALC.SERIAL_NO
     */
    public BigDecimal getSERIAL_NO() {
        return SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDETALC.SERIAL_NO
     *
     * @param SERIAL_NO the value for TRSDETALC.SERIAL_NO
     */
    public void setSERIAL_NO(BigDecimal SERIAL_NO) {
        this.SERIAL_NO = SERIAL_NO;
    }
}