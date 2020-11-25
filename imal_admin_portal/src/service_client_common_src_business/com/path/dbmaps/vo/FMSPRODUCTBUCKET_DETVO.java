package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class FMSPRODUCTBUCKET_DETVO extends FMSPRODUCTBUCKET_DETVOKey {
    /**
     * This field corresponds to the database column FMSPRODUCTBUCKET_DET.PRODUCT_CLASS
     */
    private BigDecimal PRODUCT_CLASS;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSPRODUCTBUCKET_DET.PRODUCT_CLASS
     *
     * @return the value of FMSPRODUCTBUCKET_DET.PRODUCT_CLASS
     */
    public BigDecimal getPRODUCT_CLASS() {
        return PRODUCT_CLASS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSPRODUCTBUCKET_DET.PRODUCT_CLASS
     *
     * @param PRODUCT_CLASS the value for FMSPRODUCTBUCKET_DET.PRODUCT_CLASS
     */
    public void setPRODUCT_CLASS(BigDecimal PRODUCT_CLASS) {
        this.PRODUCT_CLASS = PRODUCT_CLASS;
    }
}