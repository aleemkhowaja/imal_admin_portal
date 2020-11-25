package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class PROC_PRODUCT_PARAMVOKey extends BaseVO {
    /**
     * This field corresponds to the database column PROC_PRODUCT_PARAM.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column PROC_PRODUCT_PARAM.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column PROC_PRODUCT_PARAM.PRODUCT_CODE
     */
    private BigDecimal PRODUCT_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PROC_PRODUCT_PARAM.BRANCH_CODE
     *
     * @return the value of PROC_PRODUCT_PARAM.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PROC_PRODUCT_PARAM.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for PROC_PRODUCT_PARAM.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PROC_PRODUCT_PARAM.COMP_CODE
     *
     * @return the value of PROC_PRODUCT_PARAM.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PROC_PRODUCT_PARAM.COMP_CODE
     *
     * @param COMP_CODE the value for PROC_PRODUCT_PARAM.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PROC_PRODUCT_PARAM.PRODUCT_CODE
     *
     * @return the value of PROC_PRODUCT_PARAM.PRODUCT_CODE
     */
    public BigDecimal getPRODUCT_CODE() {
        return PRODUCT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PROC_PRODUCT_PARAM.PRODUCT_CODE
     *
     * @param PRODUCT_CODE the value for PROC_PRODUCT_PARAM.PRODUCT_CODE
     */
    public void setPRODUCT_CODE(BigDecimal PRODUCT_CODE) {
        this.PRODUCT_CODE = PRODUCT_CODE;
    }
}