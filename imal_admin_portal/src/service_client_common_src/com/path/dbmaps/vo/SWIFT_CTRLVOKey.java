package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SWIFT_CTRLVOKey extends BaseVO {
    /**
     * This field corresponds to the database column SWIFT_CTRL.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column SWIFT_CTRL.CURRENCY
     */
    private BigDecimal CURRENCY;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_CTRL.COMP_CODE
     *
     * @return the value of SWIFT_CTRL.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_CTRL.COMP_CODE
     *
     * @param COMP_CODE the value for SWIFT_CTRL.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_CTRL.CURRENCY
     *
     * @return the value of SWIFT_CTRL.CURRENCY
     */
    public BigDecimal getCURRENCY() {
        return CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_CTRL.CURRENCY
     *
     * @param CURRENCY the value for SWIFT_CTRL.CURRENCY
     */
    public void setCURRENCY(BigDecimal CURRENCY) {
        this.CURRENCY = CURRENCY;
    }
}