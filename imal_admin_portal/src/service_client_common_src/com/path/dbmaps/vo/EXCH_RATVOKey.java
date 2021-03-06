package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class EXCH_RATVOKey extends BaseVO {
    /**
     * This field corresponds to the database column EXCH_RAT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column EXCH_RAT.CURRENCY_CODE
     */
    private BigDecimal CURRENCY_CODE;

    /**
     * This field corresponds to the database column EXCH_RAT.DATE_RATE
     */
    private Date DATE_RATE;

    /**
     * This field corresponds to the database column EXCH_RAT.TIME
     */
    private String TIME;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXCH_RAT.COMP_CODE
     *
     * @return the value of EXCH_RAT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXCH_RAT.COMP_CODE
     *
     * @param COMP_CODE the value for EXCH_RAT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXCH_RAT.CURRENCY_CODE
     *
     * @return the value of EXCH_RAT.CURRENCY_CODE
     */
    public BigDecimal getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXCH_RAT.CURRENCY_CODE
     *
     * @param CURRENCY_CODE the value for EXCH_RAT.CURRENCY_CODE
     */
    public void setCURRENCY_CODE(BigDecimal CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXCH_RAT.DATE_RATE
     *
     * @return the value of EXCH_RAT.DATE_RATE
     */
    public Date getDATE_RATE() {
        return DATE_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXCH_RAT.DATE_RATE
     *
     * @param DATE_RATE the value for EXCH_RAT.DATE_RATE
     */
    public void setDATE_RATE(Date DATE_RATE) {
        this.DATE_RATE = DATE_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXCH_RAT.TIME
     *
     * @return the value of EXCH_RAT.TIME
     */
    public String getTIME() {
        return TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXCH_RAT.TIME
     *
     * @param TIME the value for EXCH_RAT.TIME
     */
    public void setTIME(String TIME) {
        this.TIME = TIME == null ? null : TIME.trim();
    }
}