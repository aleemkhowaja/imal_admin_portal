package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSCATEGORYSUBVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSCATEGORYSUB.APP_NAME
     */
    private String APP_NAME;

    /**
     * This field corresponds to the database column TRSCATEGORYSUB.CATEGORY_CODE
     */
    private BigDecimal CATEGORY_CODE;

    /**
     * This field corresponds to the database column TRSCATEGORYSUB.SUBCATEGORY_CODE
     */
    private BigDecimal SUBCATEGORY_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCATEGORYSUB.APP_NAME
     *
     * @return the value of TRSCATEGORYSUB.APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCATEGORYSUB.APP_NAME
     *
     * @param APP_NAME the value for TRSCATEGORYSUB.APP_NAME
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME == null ? null : APP_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCATEGORYSUB.CATEGORY_CODE
     *
     * @return the value of TRSCATEGORYSUB.CATEGORY_CODE
     */
    public BigDecimal getCATEGORY_CODE() {
        return CATEGORY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCATEGORYSUB.CATEGORY_CODE
     *
     * @param CATEGORY_CODE the value for TRSCATEGORYSUB.CATEGORY_CODE
     */
    public void setCATEGORY_CODE(BigDecimal CATEGORY_CODE) {
        this.CATEGORY_CODE = CATEGORY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCATEGORYSUB.SUBCATEGORY_CODE
     *
     * @return the value of TRSCATEGORYSUB.SUBCATEGORY_CODE
     */
    public BigDecimal getSUBCATEGORY_CODE() {
        return SUBCATEGORY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCATEGORYSUB.SUBCATEGORY_CODE
     *
     * @param SUBCATEGORY_CODE the value for TRSCATEGORYSUB.SUBCATEGORY_CODE
     */
    public void setSUBCATEGORY_CODE(BigDecimal SUBCATEGORY_CODE) {
        this.SUBCATEGORY_CODE = SUBCATEGORY_CODE;
    }
}