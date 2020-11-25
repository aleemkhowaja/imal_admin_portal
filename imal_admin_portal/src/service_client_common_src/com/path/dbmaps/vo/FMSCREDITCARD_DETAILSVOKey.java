package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class FMSCREDITCARD_DETAILSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column FMSCREDITCARD_DETAILS.APPLICATION_CODE
     */
    private BigDecimal APPLICATION_CODE;

    /**
     * This field corresponds to the database column FMSCREDITCARD_DETAILS.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column FMSCREDITCARD_DETAILS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column FMSCREDITCARD_DETAILS.LINE_NBR
     */
    private BigDecimal LINE_NBR;

    /**
     * This field corresponds to the database column FMSCREDITCARD_DETAILS.SUBLIMIT_LINE_NBR
     */
    private BigDecimal SUBLIMIT_LINE_NBR;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSCREDITCARD_DETAILS.APPLICATION_CODE
     *
     * @return the value of FMSCREDITCARD_DETAILS.APPLICATION_CODE
     */
    public BigDecimal getAPPLICATION_CODE() {
        return APPLICATION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSCREDITCARD_DETAILS.APPLICATION_CODE
     *
     * @param APPLICATION_CODE the value for FMSCREDITCARD_DETAILS.APPLICATION_CODE
     */
    public void setAPPLICATION_CODE(BigDecimal APPLICATION_CODE) {
        this.APPLICATION_CODE = APPLICATION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSCREDITCARD_DETAILS.BRANCH_CODE
     *
     * @return the value of FMSCREDITCARD_DETAILS.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSCREDITCARD_DETAILS.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for FMSCREDITCARD_DETAILS.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSCREDITCARD_DETAILS.COMP_CODE
     *
     * @return the value of FMSCREDITCARD_DETAILS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSCREDITCARD_DETAILS.COMP_CODE
     *
     * @param COMP_CODE the value for FMSCREDITCARD_DETAILS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSCREDITCARD_DETAILS.LINE_NBR
     *
     * @return the value of FMSCREDITCARD_DETAILS.LINE_NBR
     */
    public BigDecimal getLINE_NBR() {
        return LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSCREDITCARD_DETAILS.LINE_NBR
     *
     * @param LINE_NBR the value for FMSCREDITCARD_DETAILS.LINE_NBR
     */
    public void setLINE_NBR(BigDecimal LINE_NBR) {
        this.LINE_NBR = LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSCREDITCARD_DETAILS.SUBLIMIT_LINE_NBR
     *
     * @return the value of FMSCREDITCARD_DETAILS.SUBLIMIT_LINE_NBR
     */
    public BigDecimal getSUBLIMIT_LINE_NBR() {
        return SUBLIMIT_LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSCREDITCARD_DETAILS.SUBLIMIT_LINE_NBR
     *
     * @param SUBLIMIT_LINE_NBR the value for FMSCREDITCARD_DETAILS.SUBLIMIT_LINE_NBR
     */
    public void setSUBLIMIT_LINE_NBR(BigDecimal SUBLIMIT_LINE_NBR) {
        this.SUBLIMIT_LINE_NBR = SUBLIMIT_LINE_NBR;
    }
}