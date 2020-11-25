package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class GEN_LEDGERVOKey extends BaseVO {
    /**
     * This field corresponds to the database column GEN_LEDGER.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column GEN_LEDGER.GL_CODE
     */
    private BigDecimal GL_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GEN_LEDGER.COMP_CODE
     *
     * @return the value of GEN_LEDGER.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GEN_LEDGER.COMP_CODE
     *
     * @param COMP_CODE the value for GEN_LEDGER.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column GEN_LEDGER.GL_CODE
     *
     * @return the value of GEN_LEDGER.GL_CODE
     */
    public BigDecimal getGL_CODE() {
        return GL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column GEN_LEDGER.GL_CODE
     *
     * @param GL_CODE the value for GEN_LEDGER.GL_CODE
     */
    public void setGL_CODE(BigDecimal GL_CODE) {
        this.GL_CODE = GL_CODE;
    }
}