package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class ACC_VAT_BR_CYVOKey extends BaseVO {
    /**
     * This field corresponds to the database column ACC_VAT_BR_CY.BR_CODE
     */
    private BigDecimal BR_CODE;

    /**
     * This field corresponds to the database column ACC_VAT_BR_CY.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column ACC_VAT_BR_CY.CY_CODE
     */
    private BigDecimal CY_CODE;

    /**
     * This field corresponds to the database column ACC_VAT_BR_CY.VAT_CODE
     */
    private BigDecimal VAT_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACC_VAT_BR_CY.BR_CODE
     *
     * @return the value of ACC_VAT_BR_CY.BR_CODE
     */
    public BigDecimal getBR_CODE() {
        return BR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACC_VAT_BR_CY.BR_CODE
     *
     * @param BR_CODE the value for ACC_VAT_BR_CY.BR_CODE
     */
    public void setBR_CODE(BigDecimal BR_CODE) {
        this.BR_CODE = BR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACC_VAT_BR_CY.COMP_CODE
     *
     * @return the value of ACC_VAT_BR_CY.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACC_VAT_BR_CY.COMP_CODE
     *
     * @param COMP_CODE the value for ACC_VAT_BR_CY.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACC_VAT_BR_CY.CY_CODE
     *
     * @return the value of ACC_VAT_BR_CY.CY_CODE
     */
    public BigDecimal getCY_CODE() {
        return CY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACC_VAT_BR_CY.CY_CODE
     *
     * @param CY_CODE the value for ACC_VAT_BR_CY.CY_CODE
     */
    public void setCY_CODE(BigDecimal CY_CODE) {
        this.CY_CODE = CY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ACC_VAT_BR_CY.VAT_CODE
     *
     * @return the value of ACC_VAT_BR_CY.VAT_CODE
     */
    public BigDecimal getVAT_CODE() {
        return VAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ACC_VAT_BR_CY.VAT_CODE
     *
     * @param VAT_CODE the value for ACC_VAT_BR_CY.VAT_CODE
     */
    public void setVAT_CODE(BigDecimal VAT_CODE) {
        this.VAT_CODE = VAT_CODE;
    }
}