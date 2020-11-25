package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class RIFCTT_GLVO extends RIFCTT_GLVOKey {
    /**
     * This field corresponds to the database column RIFCTT_GL.CURRENCY_CODE
     */
    private BigDecimal CURRENCY_CODE;

    /**
     * This field corresponds to the database column RIFCTT_GL.GL_CODE
     */
    private BigDecimal GL_CODE;

    /**
     * This field corresponds to the database column RIFCTT_GL.SL_NO
     */
    private BigDecimal SL_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFCTT_GL.CURRENCY_CODE
     *
     * @return the value of RIFCTT_GL.CURRENCY_CODE
     */
    public BigDecimal getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFCTT_GL.CURRENCY_CODE
     *
     * @param CURRENCY_CODE the value for RIFCTT_GL.CURRENCY_CODE
     */
    public void setCURRENCY_CODE(BigDecimal CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFCTT_GL.GL_CODE
     *
     * @return the value of RIFCTT_GL.GL_CODE
     */
    public BigDecimal getGL_CODE() {
        return GL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFCTT_GL.GL_CODE
     *
     * @param GL_CODE the value for RIFCTT_GL.GL_CODE
     */
    public void setGL_CODE(BigDecimal GL_CODE) {
        this.GL_CODE = GL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFCTT_GL.SL_NO
     *
     * @return the value of RIFCTT_GL.SL_NO
     */
    public BigDecimal getSL_NO() {
        return SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFCTT_GL.SL_NO
     *
     * @param SL_NO the value for RIFCTT_GL.SL_NO
     */
    public void setSL_NO(BigDecimal SL_NO) {
        this.SL_NO = SL_NO;
    }
}