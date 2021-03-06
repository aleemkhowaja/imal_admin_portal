package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class TRS_VEND_INCENTIVE_CIFVO extends TRS_VEND_INCENTIVE_CIFVOKey {
    /**
     * This field corresponds to the database column TRS_VEND_INCENTIVE_CIF.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_VEND_INCENTIVE_CIF.CIF_NO
     *
     * @return the value of TRS_VEND_INCENTIVE_CIF.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_VEND_INCENTIVE_CIF.CIF_NO
     *
     * @param CIF_NO the value for TRS_VEND_INCENTIVE_CIF.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }
}