package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_PRODUCT_VDATEVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_PRODUCT_VDATE.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column CTS_PRODUCT_VDATE.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_PRODUCT_VDATE.DOCUMENT_TYPE
     */
    private String DOCUMENT_TYPE;

    /**
     * This field corresponds to the database column CTS_PRODUCT_VDATE.ENTITY_CODE
     */
    private BigDecimal ENTITY_CODE;

    /**
     * This field corresponds to the database column CTS_PRODUCT_VDATE.ENTITY_TYPE
     */
    private String ENTITY_TYPE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_PRODUCT_VDATE.CIF_NO
     *
     * @return the value of CTS_PRODUCT_VDATE.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_PRODUCT_VDATE.CIF_NO
     *
     * @param CIF_NO the value for CTS_PRODUCT_VDATE.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_PRODUCT_VDATE.COMP_CODE
     *
     * @return the value of CTS_PRODUCT_VDATE.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_PRODUCT_VDATE.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_PRODUCT_VDATE.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_PRODUCT_VDATE.DOCUMENT_TYPE
     *
     * @return the value of CTS_PRODUCT_VDATE.DOCUMENT_TYPE
     */
    public String getDOCUMENT_TYPE() {
        return DOCUMENT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_PRODUCT_VDATE.DOCUMENT_TYPE
     *
     * @param DOCUMENT_TYPE the value for CTS_PRODUCT_VDATE.DOCUMENT_TYPE
     */
    public void setDOCUMENT_TYPE(String DOCUMENT_TYPE) {
        this.DOCUMENT_TYPE = DOCUMENT_TYPE == null ? null : DOCUMENT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_PRODUCT_VDATE.ENTITY_CODE
     *
     * @return the value of CTS_PRODUCT_VDATE.ENTITY_CODE
     */
    public BigDecimal getENTITY_CODE() {
        return ENTITY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_PRODUCT_VDATE.ENTITY_CODE
     *
     * @param ENTITY_CODE the value for CTS_PRODUCT_VDATE.ENTITY_CODE
     */
    public void setENTITY_CODE(BigDecimal ENTITY_CODE) {
        this.ENTITY_CODE = ENTITY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_PRODUCT_VDATE.ENTITY_TYPE
     *
     * @return the value of CTS_PRODUCT_VDATE.ENTITY_TYPE
     */
    public String getENTITY_TYPE() {
        return ENTITY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_PRODUCT_VDATE.ENTITY_TYPE
     *
     * @param ENTITY_TYPE the value for CTS_PRODUCT_VDATE.ENTITY_TYPE
     */
    public void setENTITY_TYPE(String ENTITY_TYPE) {
        this.ENTITY_TYPE = ENTITY_TYPE == null ? null : ENTITY_TYPE.trim();
    }
}