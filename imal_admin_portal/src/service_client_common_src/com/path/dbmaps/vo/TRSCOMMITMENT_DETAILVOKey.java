package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSCOMMITMENT_DETAILVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSCOMMITMENT_DETAIL.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRSCOMMITMENT_DETAIL.COMMITMENT_TYPE
     */
    private String COMMITMENT_TYPE;

    /**
     * This field corresponds to the database column TRSCOMMITMENT_DETAIL.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRSCOMMITMENT_DETAIL.TRANSACTION_NO
     */
    private BigDecimal TRANSACTION_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCOMMITMENT_DETAIL.BRANCH_CODE
     *
     * @return the value of TRSCOMMITMENT_DETAIL.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCOMMITMENT_DETAIL.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRSCOMMITMENT_DETAIL.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCOMMITMENT_DETAIL.COMMITMENT_TYPE
     *
     * @return the value of TRSCOMMITMENT_DETAIL.COMMITMENT_TYPE
     */
    public String getCOMMITMENT_TYPE() {
        return COMMITMENT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCOMMITMENT_DETAIL.COMMITMENT_TYPE
     *
     * @param COMMITMENT_TYPE the value for TRSCOMMITMENT_DETAIL.COMMITMENT_TYPE
     */
    public void setCOMMITMENT_TYPE(String COMMITMENT_TYPE) {
        this.COMMITMENT_TYPE = COMMITMENT_TYPE == null ? null : COMMITMENT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCOMMITMENT_DETAIL.COMP_CODE
     *
     * @return the value of TRSCOMMITMENT_DETAIL.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCOMMITMENT_DETAIL.COMP_CODE
     *
     * @param COMP_CODE the value for TRSCOMMITMENT_DETAIL.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCOMMITMENT_DETAIL.TRANSACTION_NO
     *
     * @return the value of TRSCOMMITMENT_DETAIL.TRANSACTION_NO
     */
    public BigDecimal getTRANSACTION_NO() {
        return TRANSACTION_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCOMMITMENT_DETAIL.TRANSACTION_NO
     *
     * @param TRANSACTION_NO the value for TRSCOMMITMENT_DETAIL.TRANSACTION_NO
     */
    public void setTRANSACTION_NO(BigDecimal TRANSACTION_NO) {
        this.TRANSACTION_NO = TRANSACTION_NO;
    }
}