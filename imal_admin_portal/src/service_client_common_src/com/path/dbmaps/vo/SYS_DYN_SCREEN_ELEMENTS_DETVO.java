package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class SYS_DYN_SCREEN_ELEMENTS_DETVO extends BaseVO {
    /**
     * This field corresponds to the database column SYS_DYN_SCREEN_ELEMENTS_DET.ELEMENT_ID
     */
    private BigDecimal ELEMENT_ID;

    /**
     * This field corresponds to the database column SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_CODE
     */
    private String PROPERTY_CODE;

    /**
     * This field corresponds to the database column SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_VALUE
     */
    private String PROPERTY_VALUE;

    /**
     * This field corresponds to the database column SYS_DYN_SCREEN_ELEMENTS_DET.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column SYS_DYN_SCREEN_ELEMENTS_DET.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column SYS_DYN_SCREEN_ELEMENTS_DET.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column SYS_DYN_SCREEN_ELEMENTS_DET.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This field corresponds to the database column SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_EXPRESSION_VALUE
     */
    private String PROPERTY_EXPRESSION_VALUE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.ELEMENT_ID
     *
     * @return the value of SYS_DYN_SCREEN_ELEMENTS_DET.ELEMENT_ID
     */
    public BigDecimal getELEMENT_ID() {
        return ELEMENT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.ELEMENT_ID
     *
     * @param ELEMENT_ID the value for SYS_DYN_SCREEN_ELEMENTS_DET.ELEMENT_ID
     */
    public void setELEMENT_ID(BigDecimal ELEMENT_ID) {
        this.ELEMENT_ID = ELEMENT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_CODE
     *
     * @return the value of SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_CODE
     */
    public String getPROPERTY_CODE() {
        return PROPERTY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_CODE
     *
     * @param PROPERTY_CODE the value for SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_CODE
     */
    public void setPROPERTY_CODE(String PROPERTY_CODE) {
        this.PROPERTY_CODE = PROPERTY_CODE == null ? null : PROPERTY_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_VALUE
     *
     * @return the value of SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_VALUE
     */
    public String getPROPERTY_VALUE() {
        return PROPERTY_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_VALUE
     *
     * @param PROPERTY_VALUE the value for SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_VALUE
     */
    public void setPROPERTY_VALUE(String PROPERTY_VALUE) {
        this.PROPERTY_VALUE = PROPERTY_VALUE == null ? null : PROPERTY_VALUE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.CREATED_BY
     *
     * @return the value of SYS_DYN_SCREEN_ELEMENTS_DET.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.CREATED_BY
     *
     * @param CREATED_BY the value for SYS_DYN_SCREEN_ELEMENTS_DET.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.CREATED_DATE
     *
     * @return the value of SYS_DYN_SCREEN_ELEMENTS_DET.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.CREATED_DATE
     *
     * @param CREATED_DATE the value for SYS_DYN_SCREEN_ELEMENTS_DET.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.MODIFIED_BY
     *
     * @return the value of SYS_DYN_SCREEN_ELEMENTS_DET.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for SYS_DYN_SCREEN_ELEMENTS_DET.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.MODIFIED_DATE
     *
     * @return the value of SYS_DYN_SCREEN_ELEMENTS_DET.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for SYS_DYN_SCREEN_ELEMENTS_DET.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_EXPRESSION_VALUE
     *
     * @return the value of SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_EXPRESSION_VALUE
     */
    public String getPROPERTY_EXPRESSION_VALUE() {
        return PROPERTY_EXPRESSION_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_EXPRESSION_VALUE
     *
     * @param PROPERTY_EXPRESSION_VALUE the value for SYS_DYN_SCREEN_ELEMENTS_DET.PROPERTY_EXPRESSION_VALUE
     */
    public void setPROPERTY_EXPRESSION_VALUE(String PROPERTY_EXPRESSION_VALUE) {
        this.PROPERTY_EXPRESSION_VALUE = PROPERTY_EXPRESSION_VALUE == null ? null : PROPERTY_EXPRESSION_VALUE.trim();
    }
}