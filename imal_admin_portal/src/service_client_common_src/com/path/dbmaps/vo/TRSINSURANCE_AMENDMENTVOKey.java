package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSINSURANCE_AMENDMENTVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSINSURANCE_AMENDMENT.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRSINSURANCE_AMENDMENT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRSINSURANCE_AMENDMENT.DET_LINE_NO
     */
    private BigDecimal DET_LINE_NO;

    /**
     * This field corresponds to the database column TRSINSURANCE_AMENDMENT.TRANSACTION_NO
     */
    private BigDecimal TRANSACTION_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSINSURANCE_AMENDMENT.BRANCH_CODE
     *
     * @return the value of TRSINSURANCE_AMENDMENT.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSINSURANCE_AMENDMENT.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRSINSURANCE_AMENDMENT.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSINSURANCE_AMENDMENT.COMP_CODE
     *
     * @return the value of TRSINSURANCE_AMENDMENT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSINSURANCE_AMENDMENT.COMP_CODE
     *
     * @param COMP_CODE the value for TRSINSURANCE_AMENDMENT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSINSURANCE_AMENDMENT.DET_LINE_NO
     *
     * @return the value of TRSINSURANCE_AMENDMENT.DET_LINE_NO
     */
    public BigDecimal getDET_LINE_NO() {
        return DET_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSINSURANCE_AMENDMENT.DET_LINE_NO
     *
     * @param DET_LINE_NO the value for TRSINSURANCE_AMENDMENT.DET_LINE_NO
     */
    public void setDET_LINE_NO(BigDecimal DET_LINE_NO) {
        this.DET_LINE_NO = DET_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSINSURANCE_AMENDMENT.TRANSACTION_NO
     *
     * @return the value of TRSINSURANCE_AMENDMENT.TRANSACTION_NO
     */
    public BigDecimal getTRANSACTION_NO() {
        return TRANSACTION_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSINSURANCE_AMENDMENT.TRANSACTION_NO
     *
     * @param TRANSACTION_NO the value for TRSINSURANCE_AMENDMENT.TRANSACTION_NO
     */
    public void setTRANSACTION_NO(BigDecimal TRANSACTION_NO) {
        this.TRANSACTION_NO = TRANSACTION_NO;
    }
}