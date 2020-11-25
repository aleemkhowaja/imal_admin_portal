package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class TRSLIBRARYVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSLIBRARY.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRSLIBRARY.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRSLIBRARY.CURRENCY_CODE
     */
    private BigDecimal CURRENCY_CODE;

    /**
     * This field corresponds to the database column TRSLIBRARY.MARKET_DATE
     */
    private Date MARKET_DATE;

    /**
     * This field corresponds to the database column TRSLIBRARY.TIME
     */
    private String TIME;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSLIBRARY.BRANCH_CODE
     *
     * @return the value of TRSLIBRARY.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSLIBRARY.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRSLIBRARY.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSLIBRARY.COMP_CODE
     *
     * @return the value of TRSLIBRARY.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSLIBRARY.COMP_CODE
     *
     * @param COMP_CODE the value for TRSLIBRARY.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSLIBRARY.CURRENCY_CODE
     *
     * @return the value of TRSLIBRARY.CURRENCY_CODE
     */
    public BigDecimal getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSLIBRARY.CURRENCY_CODE
     *
     * @param CURRENCY_CODE the value for TRSLIBRARY.CURRENCY_CODE
     */
    public void setCURRENCY_CODE(BigDecimal CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSLIBRARY.MARKET_DATE
     *
     * @return the value of TRSLIBRARY.MARKET_DATE
     */
    public Date getMARKET_DATE() {
        return MARKET_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSLIBRARY.MARKET_DATE
     *
     * @param MARKET_DATE the value for TRSLIBRARY.MARKET_DATE
     */
    public void setMARKET_DATE(Date MARKET_DATE) {
        this.MARKET_DATE = MARKET_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSLIBRARY.TIME
     *
     * @return the value of TRSLIBRARY.TIME
     */
    public String getTIME() {
        return TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSLIBRARY.TIME
     *
     * @param TIME the value for TRSLIBRARY.TIME
     */
    public void setTIME(String TIME) {
        this.TIME = TIME == null ? null : TIME.trim();
    }
}