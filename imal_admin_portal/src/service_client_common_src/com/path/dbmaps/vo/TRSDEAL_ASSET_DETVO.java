package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class TRSDEAL_ASSET_DETVO extends TRSDEAL_ASSET_DETVOKey {
    /**
     * This field corresponds to the database column TRSDEAL_ASSET_DET.BUY_BACK_YN
     */
    private String BUY_BACK_YN;

    /**
     * This field corresponds to the database column TRSDEAL_ASSET_DET.ASSET_COST
     */
    private BigDecimal ASSET_COST;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_ASSET_DET.BUY_BACK_YN
     *
     * @return the value of TRSDEAL_ASSET_DET.BUY_BACK_YN
     */
    public String getBUY_BACK_YN() {
        return BUY_BACK_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_ASSET_DET.BUY_BACK_YN
     *
     * @param BUY_BACK_YN the value for TRSDEAL_ASSET_DET.BUY_BACK_YN
     */
    public void setBUY_BACK_YN(String BUY_BACK_YN) {
        this.BUY_BACK_YN = BUY_BACK_YN == null ? null : BUY_BACK_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_ASSET_DET.ASSET_COST
     *
     * @return the value of TRSDEAL_ASSET_DET.ASSET_COST
     */
    public BigDecimal getASSET_COST() {
        return ASSET_COST;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_ASSET_DET.ASSET_COST
     *
     * @param ASSET_COST the value for TRSDEAL_ASSET_DET.ASSET_COST
     */
    public void setASSET_COST(BigDecimal ASSET_COST) {
        this.ASSET_COST = ASSET_COST;
    }
}