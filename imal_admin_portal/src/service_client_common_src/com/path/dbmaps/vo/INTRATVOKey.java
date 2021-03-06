package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class INTRATVOKey extends BaseVO {
    /**
     * This field corresponds to the database column INTRAT.APPL_DATE
     */
    private Date APPL_DATE;

    /**
     * This field corresponds to the database column INTRAT.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column INTRAT.CIF_SUB_NO
     */
    private BigDecimal CIF_SUB_NO;

    /**
     * This field corresponds to the database column INTRAT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column INTRAT.CURRENCY_CODE
     */
    private BigDecimal CURRENCY_CODE;

    /**
     * This field corresponds to the database column INTRAT.DR_CR_IDX
     */
    private String DR_CR_IDX;

    /**
     * This field corresponds to the database column INTRAT.GL_CODE
     */
    private BigDecimal GL_CODE;

    /**
     * This field corresponds to the database column INTRAT.SL_NO
     */
    private BigDecimal SL_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INTRAT.APPL_DATE
     *
     * @return the value of INTRAT.APPL_DATE
     */
    public Date getAPPL_DATE() {
        return APPL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INTRAT.APPL_DATE
     *
     * @param APPL_DATE the value for INTRAT.APPL_DATE
     */
    public void setAPPL_DATE(Date APPL_DATE) {
        this.APPL_DATE = APPL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INTRAT.BRANCH_CODE
     *
     * @return the value of INTRAT.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INTRAT.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for INTRAT.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INTRAT.CIF_SUB_NO
     *
     * @return the value of INTRAT.CIF_SUB_NO
     */
    public BigDecimal getCIF_SUB_NO() {
        return CIF_SUB_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INTRAT.CIF_SUB_NO
     *
     * @param CIF_SUB_NO the value for INTRAT.CIF_SUB_NO
     */
    public void setCIF_SUB_NO(BigDecimal CIF_SUB_NO) {
        this.CIF_SUB_NO = CIF_SUB_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INTRAT.COMP_CODE
     *
     * @return the value of INTRAT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INTRAT.COMP_CODE
     *
     * @param COMP_CODE the value for INTRAT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INTRAT.CURRENCY_CODE
     *
     * @return the value of INTRAT.CURRENCY_CODE
     */
    public BigDecimal getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INTRAT.CURRENCY_CODE
     *
     * @param CURRENCY_CODE the value for INTRAT.CURRENCY_CODE
     */
    public void setCURRENCY_CODE(BigDecimal CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INTRAT.DR_CR_IDX
     *
     * @return the value of INTRAT.DR_CR_IDX
     */
    public String getDR_CR_IDX() {
        return DR_CR_IDX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INTRAT.DR_CR_IDX
     *
     * @param DR_CR_IDX the value for INTRAT.DR_CR_IDX
     */
    public void setDR_CR_IDX(String DR_CR_IDX) {
        this.DR_CR_IDX = DR_CR_IDX == null ? null : DR_CR_IDX.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INTRAT.GL_CODE
     *
     * @return the value of INTRAT.GL_CODE
     */
    public BigDecimal getGL_CODE() {
        return GL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INTRAT.GL_CODE
     *
     * @param GL_CODE the value for INTRAT.GL_CODE
     */
    public void setGL_CODE(BigDecimal GL_CODE) {
        this.GL_CODE = GL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INTRAT.SL_NO
     *
     * @return the value of INTRAT.SL_NO
     */
    public BigDecimal getSL_NO() {
        return SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INTRAT.SL_NO
     *
     * @param SL_NO the value for INTRAT.SL_NO
     */
    public void setSL_NO(BigDecimal SL_NO) {
        this.SL_NO = SL_NO;
    }
}