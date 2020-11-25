package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class SYS_PARAM_BTN_CUST_OUTPUT_MAPVO extends BaseVO {
    /**
     * This field corresponds to the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.BTN_ID
     */
    private BigDecimal BTN_ID;

    /**
     * This field corresponds to the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.OP_ID
     */
    private BigDecimal OP_ID;

    /**
     * This field corresponds to the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.MAP_KEY
     */
    private String MAP_KEY;
    
    /**
     * This field corresponds to the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.NESTED
     */
    private String NESTED;

    /**
     * This field corresponds to the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.ARG_ID
     */
    private BigDecimal ARG_ID;

    /**
     * This field corresponds to the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.BTN_ID
     *
     * @return the value of SYS_PARAM_BTN_CUST_OUTPUT_MAP.BTN_ID
     */
    public BigDecimal getBTN_ID() {
        return BTN_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.BTN_ID
     *
     * @param BTN_ID the value for SYS_PARAM_BTN_CUST_OUTPUT_MAP.BTN_ID
     */
    public void setBTN_ID(BigDecimal BTN_ID) {
        this.BTN_ID = BTN_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.LINE_NO
     *
     * @return the value of SYS_PARAM_BTN_CUST_OUTPUT_MAP.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.LINE_NO
     *
     * @param LINE_NO the value for SYS_PARAM_BTN_CUST_OUTPUT_MAP.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.OP_ID
     *
     * @return the value of SYS_PARAM_BTN_CUST_OUTPUT_MAP.OP_ID
     */
    public BigDecimal getOP_ID() {
        return OP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.OP_ID
     *
     * @param OP_ID the value for SYS_PARAM_BTN_CUST_OUTPUT_MAP.OP_ID
     */
    public void setOP_ID(BigDecimal OP_ID) {
        this.OP_ID = OP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.MAP_KEY
     *
     * @return the value of SYS_PARAM_BTN_CUST_OUTPUT_MAP.MAP_KEY
     */
    public String getMAP_KEY() {
        return MAP_KEY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.MAP_KEY
     *
     * @param MAP_KEY the value for SYS_PARAM_BTN_CUST_OUTPUT_MAP.MAP_KEY
     */
    public void setMAP_KEY(String MAP_KEY) {
        this.MAP_KEY = MAP_KEY == null ? null : MAP_KEY.trim();
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.NESTED
     *
     * @return the value of SYS_PARAM_BTN_CUST_OUTPUT_MAP.NESTED
     */
    public String getNESTED() {
	return NESTED;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.NESTED
     *
     * @param NESTED the value for SYS_PARAM_BTN_CUST_OUTPUT_MAP.NESTED
     */
    public void setNESTED(String NESTED) {
	this.NESTED = NESTED == null ? null : NESTED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.ARG_ID
     *
     * @return the value of SYS_PARAM_BTN_CUST_OUTPUT_MAP.ARG_ID
     */
    public BigDecimal getARG_ID() {
        return ARG_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.ARG_ID
     *
     * @param ARG_ID the value for SYS_PARAM_BTN_CUST_OUTPUT_MAP.ARG_ID
     */
    public void setARG_ID(BigDecimal ARG_ID) {
        this.ARG_ID = ARG_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.CREATED_BY
     *
     * @return the value of SYS_PARAM_BTN_CUST_OUTPUT_MAP.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.CREATED_BY
     *
     * @param CREATED_BY the value for SYS_PARAM_BTN_CUST_OUTPUT_MAP.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.CREATED_DATE
     *
     * @return the value of SYS_PARAM_BTN_CUST_OUTPUT_MAP.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.CREATED_DATE
     *
     * @param CREATED_DATE the value for SYS_PARAM_BTN_CUST_OUTPUT_MAP.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.MODIFIED_BY
     *
     * @return the value of SYS_PARAM_BTN_CUST_OUTPUT_MAP.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for SYS_PARAM_BTN_CUST_OUTPUT_MAP.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.MODIFIED_DATE
     *
     * @return the value of SYS_PARAM_BTN_CUST_OUTPUT_MAP.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_BTN_CUST_OUTPUT_MAP.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for SYS_PARAM_BTN_CUST_OUTPUT_MAP.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }
}