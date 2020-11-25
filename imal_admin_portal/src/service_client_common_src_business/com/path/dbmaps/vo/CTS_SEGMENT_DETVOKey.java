package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_SEGMENT_DETVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_SEGMENT_DET.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_SEGMENT_DET.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column CTS_SEGMENT_DET.SEGMENT_CODE
     */
    private BigDecimal SEGMENT_CODE;

    /**
     * This field corresponds to the database column CTS_SEGMENT_DET.SEGMENT_TYPE
     */
    private String SEGMENT_TYPE;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT_DET.COMP_CODE
     *
     * @return the value of CTS_SEGMENT_DET.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT_DET.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_SEGMENT_DET.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT_DET.LINE_NO
     *
     * @return the value of CTS_SEGMENT_DET.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT_DET.LINE_NO
     *
     * @param LINE_NO the value for CTS_SEGMENT_DET.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT_DET.SEGMENT_CODE
     *
     * @return the value of CTS_SEGMENT_DET.SEGMENT_CODE
     */
    public BigDecimal getSEGMENT_CODE() {
        return SEGMENT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT_DET.SEGMENT_CODE
     *
     * @param SEGMENT_CODE the value for CTS_SEGMENT_DET.SEGMENT_CODE
     */
    public void setSEGMENT_CODE(BigDecimal SEGMENT_CODE) {
        this.SEGMENT_CODE = SEGMENT_CODE;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SEGMENT_DET.SEGMENT_TYPE
     *
     * @return the value of CTS_SEGMENT_DET.SEGMENT_TYPE
     */
    public String getSEGMENT_TYPE() {
        return SEGMENT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SEGMENT_DET.SEGMENT_TYPE
     *
     * @param SEGMENT_TYPE the value for CTS_SEGMENT_DET.SEGMENT_TYPE
     */
    public void setSEGMENT_TYPE(String SEGMENT_TYPE) {
        this.SEGMENT_TYPE = SEGMENT_TYPE == null ? null : SEGMENT_TYPE.trim();
    }
}