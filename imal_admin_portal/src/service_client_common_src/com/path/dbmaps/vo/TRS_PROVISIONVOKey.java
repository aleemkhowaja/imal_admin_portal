package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRS_PROVISIONVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRS_PROVISION.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column TRS_PROVISION.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.CODE
     *
     * @return the value of TRS_PROVISION.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.CODE
     *
     * @param CODE the value for TRS_PROVISION.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.COMP_CODE
     *
     * @return the value of TRS_PROVISION.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.COMP_CODE
     *
     * @param COMP_CODE the value for TRS_PROVISION.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}