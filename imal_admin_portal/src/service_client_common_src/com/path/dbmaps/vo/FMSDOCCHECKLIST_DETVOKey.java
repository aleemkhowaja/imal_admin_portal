package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class FMSDOCCHECKLIST_DETVOKey extends BaseVO {
    /**
     * This field corresponds to the database column FMSDOCCHECKLIST_DET.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column FMSDOCCHECKLIST_DET.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column FMSDOCCHECKLIST_DET.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSDOCCHECKLIST_DET.CODE
     *
     * @return the value of FMSDOCCHECKLIST_DET.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSDOCCHECKLIST_DET.CODE
     *
     * @param CODE the value for FMSDOCCHECKLIST_DET.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSDOCCHECKLIST_DET.COMP_CODE
     *
     * @return the value of FMSDOCCHECKLIST_DET.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSDOCCHECKLIST_DET.COMP_CODE
     *
     * @param COMP_CODE the value for FMSDOCCHECKLIST_DET.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSDOCCHECKLIST_DET.LINE_NO
     *
     * @return the value of FMSDOCCHECKLIST_DET.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSDOCCHECKLIST_DET.LINE_NO
     *
     * @param LINE_NO the value for FMSDOCCHECKLIST_DET.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }
}