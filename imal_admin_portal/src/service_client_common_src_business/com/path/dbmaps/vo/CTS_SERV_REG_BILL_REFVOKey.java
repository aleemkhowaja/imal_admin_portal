package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_SERV_REG_BILL_REFVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_SERV_REG_BILL_REF.ADD_REF_LINE_NO
     */
    private BigDecimal ADD_REF_LINE_NO;

    /**
     * This field corresponds to the database column CTS_SERV_REG_BILL_REF.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column CTS_SERV_REG_BILL_REF.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_SERV_REG_BILL_REF.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column CTS_SERV_REG_BILL_REF.REG_TYPE
     */
    private String REG_TYPE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SERV_REG_BILL_REF.ADD_REF_LINE_NO
     *
     * @return the value of CTS_SERV_REG_BILL_REF.ADD_REF_LINE_NO
     */
    public BigDecimal getADD_REF_LINE_NO() {
        return ADD_REF_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SERV_REG_BILL_REF.ADD_REF_LINE_NO
     *
     * @param ADD_REF_LINE_NO the value for CTS_SERV_REG_BILL_REF.ADD_REF_LINE_NO
     */
    public void setADD_REF_LINE_NO(BigDecimal ADD_REF_LINE_NO) {
        this.ADD_REF_LINE_NO = ADD_REF_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SERV_REG_BILL_REF.CIF_NO
     *
     * @return the value of CTS_SERV_REG_BILL_REF.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SERV_REG_BILL_REF.CIF_NO
     *
     * @param CIF_NO the value for CTS_SERV_REG_BILL_REF.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SERV_REG_BILL_REF.COMP_CODE
     *
     * @return the value of CTS_SERV_REG_BILL_REF.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SERV_REG_BILL_REF.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_SERV_REG_BILL_REF.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SERV_REG_BILL_REF.LINE_NO
     *
     * @return the value of CTS_SERV_REG_BILL_REF.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SERV_REG_BILL_REF.LINE_NO
     *
     * @param LINE_NO the value for CTS_SERV_REG_BILL_REF.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_SERV_REG_BILL_REF.REG_TYPE
     *
     * @return the value of CTS_SERV_REG_BILL_REF.REG_TYPE
     */
    public String getREG_TYPE() {
        return REG_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_SERV_REG_BILL_REF.REG_TYPE
     *
     * @param REG_TYPE the value for CTS_SERV_REG_BILL_REF.REG_TYPE
     */
    public void setREG_TYPE(String REG_TYPE) {
        this.REG_TYPE = REG_TYPE == null ? null : REG_TYPE.trim();
    }
}