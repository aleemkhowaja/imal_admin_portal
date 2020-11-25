package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class FMSAPPLVOKey extends BaseVO {
    /**
     * This field corresponds to the database column FMSAPPL.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column FMSAPPL.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column FMSAPPL.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL.BRANCH
     *
     * @return the value of FMSAPPL.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL.BRANCH
     *
     * @param BRANCH the value for FMSAPPL.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL.CODE
     *
     * @return the value of FMSAPPL.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL.CODE
     *
     * @param CODE the value for FMSAPPL.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL.COMP_CODE
     *
     * @return the value of FMSAPPL.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL.COMP_CODE
     *
     * @param COMP_CODE the value for FMSAPPL.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}