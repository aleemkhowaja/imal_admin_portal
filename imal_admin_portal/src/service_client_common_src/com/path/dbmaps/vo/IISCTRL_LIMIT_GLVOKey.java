package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class IISCTRL_LIMIT_GLVOKey extends BaseVO {
    /**
     * This field corresponds to the database column IISCTRL_LIMIT_GL.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column IISCTRL_LIMIT_GL.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column IISCTRL_LIMIT_GL.GL_CODE
     */
    private BigDecimal GL_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IISCTRL_LIMIT_GL.BRANCH_CODE
     *
     * @return the value of IISCTRL_LIMIT_GL.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IISCTRL_LIMIT_GL.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for IISCTRL_LIMIT_GL.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IISCTRL_LIMIT_GL.COMP_CODE
     *
     * @return the value of IISCTRL_LIMIT_GL.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IISCTRL_LIMIT_GL.COMP_CODE
     *
     * @param COMP_CODE the value for IISCTRL_LIMIT_GL.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IISCTRL_LIMIT_GL.GL_CODE
     *
     * @return the value of IISCTRL_LIMIT_GL.GL_CODE
     */
    public BigDecimal getGL_CODE() {
        return GL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IISCTRL_LIMIT_GL.GL_CODE
     *
     * @param GL_CODE the value for IISCTRL_LIMIT_GL.GL_CODE
     */
    public void setGL_CODE(BigDecimal GL_CODE) {
        this.GL_CODE = GL_CODE;
    }
}