package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_BILL_TYPE_PROVIDER_FIELDSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_BILL_TYPE_PROVIDER_FIELDS.BILL_TYPE
     */
    private BigDecimal BILL_TYPE;

    /**
     * This field corresponds to the database column CTS_BILL_TYPE_PROVIDER_FIELDS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_LINE_NO
     */
    private BigDecimal FIELD_LINE_NO;

    /**
     * This field corresponds to the database column CTS_BILL_TYPE_PROVIDER_FIELDS.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.BILL_TYPE
     *
     * @return the value of CTS_BILL_TYPE_PROVIDER_FIELDS.BILL_TYPE
     */
    public BigDecimal getBILL_TYPE() {
        return BILL_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.BILL_TYPE
     *
     * @param BILL_TYPE the value for CTS_BILL_TYPE_PROVIDER_FIELDS.BILL_TYPE
     */
    public void setBILL_TYPE(BigDecimal BILL_TYPE) {
        this.BILL_TYPE = BILL_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.COMP_CODE
     *
     * @return the value of CTS_BILL_TYPE_PROVIDER_FIELDS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_BILL_TYPE_PROVIDER_FIELDS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_LINE_NO
     *
     * @return the value of CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_LINE_NO
     */
    public BigDecimal getFIELD_LINE_NO() {
        return FIELD_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_LINE_NO
     *
     * @param FIELD_LINE_NO the value for CTS_BILL_TYPE_PROVIDER_FIELDS.FIELD_LINE_NO
     */
    public void setFIELD_LINE_NO(BigDecimal FIELD_LINE_NO) {
        this.FIELD_LINE_NO = FIELD_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.LINE_NO
     *
     * @return the value of CTS_BILL_TYPE_PROVIDER_FIELDS.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_BILL_TYPE_PROVIDER_FIELDS.LINE_NO
     *
     * @param LINE_NO the value for CTS_BILL_TYPE_PROVIDER_FIELDS.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }
}