package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class CTSTRXTYPE_DETVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTSTRXTYPE_DET.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column CTSTRXTYPE_DET.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTSTRXTYPE_DET.LINE_NBR
     */
    private BigDecimal LINE_NBR;
    
    /**
     * This field corresponds to the database column CTSTRXTYPE_DET.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRXTYPE_DET.CODE
     *
     * @return the value of CTSTRXTYPE_DET.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRXTYPE_DET.CODE
     *
     * @param CODE the value for CTSTRXTYPE_DET.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRXTYPE_DET.COMP_CODE
     *
     * @return the value of CTSTRXTYPE_DET.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRXTYPE_DET.COMP_CODE
     *
     * @param COMP_CODE the value for CTSTRXTYPE_DET.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRXTYPE_DET.LINE_NBR
     *
     * @return the value of CTSTRXTYPE_DET.LINE_NBR
     */
    public BigDecimal getLINE_NBR() {
        return LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRXTYPE_DET.LINE_NBR
     *
     * @param LINE_NBR the value for CTSTRXTYPE_DET.LINE_NBR
     */
    public void setLINE_NBR(BigDecimal LINE_NBR) {
        this.LINE_NBR = LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTRXTYPE_DET.CIF_NO
     *
     * @return the value of CTSTRXTYPE_DET.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTRXTYPE_DET.CIF_NO
     *
     * @param CIF_NO the value for CTSTRXTYPE_DET.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }
}