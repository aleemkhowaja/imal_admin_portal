package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class COUNTRIES_TEL_FORMATVOKey extends BaseVO {
    /**
     * This field corresponds to the database column COUNTRIES_TEL_FORMAT.FORMAT_VALUE
     */
    private String FORMAT_VALUE;

    /**
     * This field corresponds to the database column COUNTRIES_TEL_FORMAT.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COUNTRIES_TEL_FORMAT.FORMAT_VALUE
     *
     * @return the value of COUNTRIES_TEL_FORMAT.FORMAT_VALUE
     */
    public String getFORMAT_VALUE() {
        return FORMAT_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COUNTRIES_TEL_FORMAT.FORMAT_VALUE
     *
     * @param FORMAT_VALUE the value for COUNTRIES_TEL_FORMAT.FORMAT_VALUE
     */
    public void setFORMAT_VALUE(String FORMAT_VALUE) {
        this.FORMAT_VALUE = FORMAT_VALUE == null ? null : FORMAT_VALUE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COUNTRIES_TEL_FORMAT.LINE_NO
     *
     * @return the value of COUNTRIES_TEL_FORMAT.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COUNTRIES_TEL_FORMAT.LINE_NO
     *
     * @param LINE_NO the value for COUNTRIES_TEL_FORMAT.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }
}