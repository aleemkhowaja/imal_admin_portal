package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRS_SYN_SETLMTVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRS_SYN_SETLMT.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRS_SYN_SETLMT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRS_SYN_SETLMT.SETTLEMENT_NO
     */
    private BigDecimal SETTLEMENT_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_SYN_SETLMT.BRANCH_CODE
     *
     * @return the value of TRS_SYN_SETLMT.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_SYN_SETLMT.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRS_SYN_SETLMT.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_SYN_SETLMT.COMP_CODE
     *
     * @return the value of TRS_SYN_SETLMT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_SYN_SETLMT.COMP_CODE
     *
     * @param COMP_CODE the value for TRS_SYN_SETLMT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_SYN_SETLMT.SETTLEMENT_NO
     *
     * @return the value of TRS_SYN_SETLMT.SETTLEMENT_NO
     */
    public BigDecimal getSETTLEMENT_NO() {
        return SETTLEMENT_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_SYN_SETLMT.SETTLEMENT_NO
     *
     * @param SETTLEMENT_NO the value for TRS_SYN_SETLMT.SETTLEMENT_NO
     */
    public void setSETTLEMENT_NO(BigDecimal SETTLEMENT_NO) {
        this.SETTLEMENT_NO = SETTLEMENT_NO;
    }
}