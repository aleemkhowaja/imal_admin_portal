package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class PMSTYPE_TEMPLATE_DETVO extends PMSTYPE_TEMPLATE_DETVOKey {
    /**
     * This field corresponds to the database column PMSTYPE_TEMPLATE_DET.TRX_TEMPLATE
     */
    private BigDecimal TRX_TEMPLATE;

    /**
     * This field corresponds to the database column PMSTYPE_TEMPLATE_DET.TRX_TEMPLATE_PROC
     */
    private BigDecimal TRX_TEMPLATE_PROC;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSTYPE_TEMPLATE_DET.TRX_TEMPLATE
     *
     * @return the value of PMSTYPE_TEMPLATE_DET.TRX_TEMPLATE
     */
    public BigDecimal getTRX_TEMPLATE() {
        return TRX_TEMPLATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSTYPE_TEMPLATE_DET.TRX_TEMPLATE
     *
     * @param TRX_TEMPLATE the value for PMSTYPE_TEMPLATE_DET.TRX_TEMPLATE
     */
    public void setTRX_TEMPLATE(BigDecimal TRX_TEMPLATE) {
        this.TRX_TEMPLATE = TRX_TEMPLATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSTYPE_TEMPLATE_DET.TRX_TEMPLATE_PROC
     *
     * @return the value of PMSTYPE_TEMPLATE_DET.TRX_TEMPLATE_PROC
     */
    public BigDecimal getTRX_TEMPLATE_PROC() {
        return TRX_TEMPLATE_PROC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSTYPE_TEMPLATE_DET.TRX_TEMPLATE_PROC
     *
     * @param TRX_TEMPLATE_PROC the value for PMSTYPE_TEMPLATE_DET.TRX_TEMPLATE_PROC
     */
    public void setTRX_TEMPLATE_PROC(BigDecimal TRX_TEMPLATE_PROC) {
        this.TRX_TEMPLATE_PROC = TRX_TEMPLATE_PROC;
    }
}