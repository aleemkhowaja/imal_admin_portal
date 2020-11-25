package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRS_FX_LINKED_UTILIZATION_DETVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRS_FX_LINKED_UTILIZATION_DET.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRS_FX_LINKED_UTILIZATION_DET.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRS_FX_LINKED_UTILIZATION_DET.DEAL_NO
     */
    private BigDecimal DEAL_NO;

    /**
     * This field corresponds to the database column TRS_FX_LINKED_UTILIZATION_DET.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_FX_LINKED_UTILIZATION_DET.BRANCH_CODE
     *
     * @return the value of TRS_FX_LINKED_UTILIZATION_DET.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_FX_LINKED_UTILIZATION_DET.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRS_FX_LINKED_UTILIZATION_DET.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_FX_LINKED_UTILIZATION_DET.COMP_CODE
     *
     * @return the value of TRS_FX_LINKED_UTILIZATION_DET.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_FX_LINKED_UTILIZATION_DET.COMP_CODE
     *
     * @param COMP_CODE the value for TRS_FX_LINKED_UTILIZATION_DET.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_FX_LINKED_UTILIZATION_DET.DEAL_NO
     *
     * @return the value of TRS_FX_LINKED_UTILIZATION_DET.DEAL_NO
     */
    public BigDecimal getDEAL_NO() {
        return DEAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_FX_LINKED_UTILIZATION_DET.DEAL_NO
     *
     * @param DEAL_NO the value for TRS_FX_LINKED_UTILIZATION_DET.DEAL_NO
     */
    public void setDEAL_NO(BigDecimal DEAL_NO) {
        this.DEAL_NO = DEAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_FX_LINKED_UTILIZATION_DET.LINE_NO
     *
     * @return the value of TRS_FX_LINKED_UTILIZATION_DET.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_FX_LINKED_UTILIZATION_DET.LINE_NO
     *
     * @param LINE_NO the value for TRS_FX_LINKED_UTILIZATION_DET.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }
}