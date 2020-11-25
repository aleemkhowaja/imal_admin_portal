package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_AVA_BENEFICIARIESVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_AVA_BENEFICIARIES.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_AVA_BENEFICIARIES.FILE_CODE
     */
    private BigDecimal FILE_CODE;

    /**
     * This field corresponds to the database column CTS_AVA_BENEFICIARIES.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_AVA_BENEFICIARIES.COMP_CODE
     *
     * @return the value of CTS_AVA_BENEFICIARIES.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_AVA_BENEFICIARIES.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_AVA_BENEFICIARIES.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_AVA_BENEFICIARIES.FILE_CODE
     *
     * @return the value of CTS_AVA_BENEFICIARIES.FILE_CODE
     */
    public BigDecimal getFILE_CODE() {
        return FILE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_AVA_BENEFICIARIES.FILE_CODE
     *
     * @param FILE_CODE the value for CTS_AVA_BENEFICIARIES.FILE_CODE
     */
    public void setFILE_CODE(BigDecimal FILE_CODE) {
        this.FILE_CODE = FILE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_AVA_BENEFICIARIES.LINE_NO
     *
     * @return the value of CTS_AVA_BENEFICIARIES.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_AVA_BENEFICIARIES.LINE_NO
     *
     * @param LINE_NO the value for CTS_AVA_BENEFICIARIES.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }
}