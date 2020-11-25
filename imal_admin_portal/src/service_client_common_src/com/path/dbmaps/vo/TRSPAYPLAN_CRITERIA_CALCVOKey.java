package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSPAYPLAN_CRITERIA_CALCVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_CALC.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_CALC.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_CALC.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column TRSPAYPLAN_CRITERIA_CALC.REF_NBR
     */
    private BigDecimal REF_NBR;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_CALC.BRANCH
     *
     * @return the value of TRSPAYPLAN_CRITERIA_CALC.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_CALC.BRANCH
     *
     * @param BRANCH the value for TRSPAYPLAN_CRITERIA_CALC.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_CALC.COMP_CODE
     *
     * @return the value of TRSPAYPLAN_CRITERIA_CALC.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_CALC.COMP_CODE
     *
     * @param COMP_CODE the value for TRSPAYPLAN_CRITERIA_CALC.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_CALC.LINE_NO
     *
     * @return the value of TRSPAYPLAN_CRITERIA_CALC.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_CALC.LINE_NO
     *
     * @param LINE_NO the value for TRSPAYPLAN_CRITERIA_CALC.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSPAYPLAN_CRITERIA_CALC.REF_NBR
     *
     * @return the value of TRSPAYPLAN_CRITERIA_CALC.REF_NBR
     */
    public BigDecimal getREF_NBR() {
        return REF_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSPAYPLAN_CRITERIA_CALC.REF_NBR
     *
     * @param REF_NBR the value for TRSPAYPLAN_CRITERIA_CALC.REF_NBR
     */
    public void setREF_NBR(BigDecimal REF_NBR) {
        this.REF_NBR = REF_NBR;
    }
}