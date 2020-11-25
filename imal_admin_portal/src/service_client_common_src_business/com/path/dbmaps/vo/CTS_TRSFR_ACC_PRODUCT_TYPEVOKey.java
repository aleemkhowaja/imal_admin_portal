package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_TRSFR_ACC_PRODUCT_TYPEVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_TRSFR_ACC_PRODUCT_TYPE.BATCH_NO
     */
    private BigDecimal BATCH_NO;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC_PRODUCT_TYPE.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC_PRODUCT_TYPE.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC_PRODUCT_TYPE.PRODUCT
     */
    private String PRODUCT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC_PRODUCT_TYPE.BATCH_NO
     *
     * @return the value of CTS_TRSFR_ACC_PRODUCT_TYPE.BATCH_NO
     */
    public BigDecimal getBATCH_NO() {
        return BATCH_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC_PRODUCT_TYPE.BATCH_NO
     *
     * @param BATCH_NO the value for CTS_TRSFR_ACC_PRODUCT_TYPE.BATCH_NO
     */
    public void setBATCH_NO(BigDecimal BATCH_NO) {
        this.BATCH_NO = BATCH_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC_PRODUCT_TYPE.COMP_CODE
     *
     * @return the value of CTS_TRSFR_ACC_PRODUCT_TYPE.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC_PRODUCT_TYPE.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_TRSFR_ACC_PRODUCT_TYPE.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC_PRODUCT_TYPE.LINE_NO
     *
     * @return the value of CTS_TRSFR_ACC_PRODUCT_TYPE.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC_PRODUCT_TYPE.LINE_NO
     *
     * @param LINE_NO the value for CTS_TRSFR_ACC_PRODUCT_TYPE.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC_PRODUCT_TYPE.PRODUCT
     *
     * @return the value of CTS_TRSFR_ACC_PRODUCT_TYPE.PRODUCT
     */
    public String getPRODUCT() {
        return PRODUCT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC_PRODUCT_TYPE.PRODUCT
     *
     * @param PRODUCT the value for CTS_TRSFR_ACC_PRODUCT_TYPE.PRODUCT
     */
    public void setPRODUCT(String PRODUCT) {
        this.PRODUCT = PRODUCT == null ? null : PRODUCT.trim();
    }
}