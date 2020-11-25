package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class SYS_PARAM_CUSTOM_EXPRESSIONVO extends BaseVO {
    /**
     * This field corresponds to the database column SYS_PARAM_CUSTOM_EXPRESSION.EXPRESSION_ID
     */
    private BigDecimal EXPRESSION_ID;

    /**
     * This field corresponds to the database column SYS_PARAM_CUSTOM_EXPRESSION.APP_NAME
     */
    private String APP_NAME;

    /**
     * This field corresponds to the database column SYS_PARAM_CUSTOM_EXPRESSION.SHORT_NAME
     */
    private String SHORT_NAME;

    /**
     * This field corresponds to the database column SYS_PARAM_CUSTOM_EXPRESSION.DESCRIPTION
     */
    private String DESCRIPTION;

    /**
     * This field corresponds to the database column SYS_PARAM_CUSTOM_EXPRESSION.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column SYS_PARAM_CUSTOM_EXPRESSION.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column SYS_PARAM_CUSTOM_EXPRESSION.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column SYS_PARAM_CUSTOM_EXPRESSION.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This field corresponds to the database column SYS_PARAM_CUSTOM_EXPRESSION.EXPRESSION
     */
    private String EXPRESSION;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.EXPRESSION_ID
     *
     * @return the value of SYS_PARAM_CUSTOM_EXPRESSION.EXPRESSION_ID
     */
    public BigDecimal getEXPRESSION_ID() {
        return EXPRESSION_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.EXPRESSION_ID
     *
     * @param EXPRESSION_ID the value for SYS_PARAM_CUSTOM_EXPRESSION.EXPRESSION_ID
     */
    public void setEXPRESSION_ID(BigDecimal EXPRESSION_ID) {
        this.EXPRESSION_ID = EXPRESSION_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.APP_NAME
     *
     * @return the value of SYS_PARAM_CUSTOM_EXPRESSION.APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.APP_NAME
     *
     * @param APP_NAME the value for SYS_PARAM_CUSTOM_EXPRESSION.APP_NAME
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME == null ? null : APP_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.SHORT_NAME
     *
     * @return the value of SYS_PARAM_CUSTOM_EXPRESSION.SHORT_NAME
     */
    public String getSHORT_NAME() {
        return SHORT_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.SHORT_NAME
     *
     * @param SHORT_NAME the value for SYS_PARAM_CUSTOM_EXPRESSION.SHORT_NAME
     */
    public void setSHORT_NAME(String SHORT_NAME) {
        this.SHORT_NAME = SHORT_NAME == null ? null : SHORT_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.DESCRIPTION
     *
     * @return the value of SYS_PARAM_CUSTOM_EXPRESSION.DESCRIPTION
     */
    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.DESCRIPTION
     *
     * @param DESCRIPTION the value for SYS_PARAM_CUSTOM_EXPRESSION.DESCRIPTION
     */
    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.CREATED_BY
     *
     * @return the value of SYS_PARAM_CUSTOM_EXPRESSION.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.CREATED_BY
     *
     * @param CREATED_BY the value for SYS_PARAM_CUSTOM_EXPRESSION.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.CREATED_DATE
     *
     * @return the value of SYS_PARAM_CUSTOM_EXPRESSION.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.CREATED_DATE
     *
     * @param CREATED_DATE the value for SYS_PARAM_CUSTOM_EXPRESSION.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.MODIFIED_BY
     *
     * @return the value of SYS_PARAM_CUSTOM_EXPRESSION.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for SYS_PARAM_CUSTOM_EXPRESSION.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.MODIFIED_DATE
     *
     * @return the value of SYS_PARAM_CUSTOM_EXPRESSION.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for SYS_PARAM_CUSTOM_EXPRESSION.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.EXPRESSION
     *
     * @return the value of SYS_PARAM_CUSTOM_EXPRESSION.EXPRESSION
     */
    public String getEXPRESSION() {
        return EXPRESSION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_CUSTOM_EXPRESSION.EXPRESSION
     *
     * @param EXPRESSION the value for SYS_PARAM_CUSTOM_EXPRESSION.EXPRESSION
     */
    public void setEXPRESSION(String EXPRESSION) {
        this.EXPRESSION = EXPRESSION == null ? null : EXPRESSION.trim();
    }
}