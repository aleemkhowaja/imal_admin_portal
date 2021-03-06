package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRS_DESK_CURRENCIESVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRS_DESK_CURRENCIES.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRS_DESK_CURRENCIES.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRS_DESK_CURRENCIES.CURRENCY_CODE
     */
    private BigDecimal CURRENCY_CODE;

    /**
     * This field corresponds to the database column TRS_DESK_CURRENCIES.DESK_CODE
     */
    private BigDecimal DESK_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DESK_CURRENCIES.BRANCH_CODE
     *
     * @return the value of TRS_DESK_CURRENCIES.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DESK_CURRENCIES.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRS_DESK_CURRENCIES.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DESK_CURRENCIES.COMP_CODE
     *
     * @return the value of TRS_DESK_CURRENCIES.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DESK_CURRENCIES.COMP_CODE
     *
     * @param COMP_CODE the value for TRS_DESK_CURRENCIES.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DESK_CURRENCIES.CURRENCY_CODE
     *
     * @return the value of TRS_DESK_CURRENCIES.CURRENCY_CODE
     */
    public BigDecimal getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DESK_CURRENCIES.CURRENCY_CODE
     *
     * @param CURRENCY_CODE the value for TRS_DESK_CURRENCIES.CURRENCY_CODE
     */
    public void setCURRENCY_CODE(BigDecimal CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_DESK_CURRENCIES.DESK_CODE
     *
     * @return the value of TRS_DESK_CURRENCIES.DESK_CODE
     */
    public BigDecimal getDESK_CODE() {
        return DESK_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_DESK_CURRENCIES.DESK_CODE
     *
     * @param DESK_CODE the value for TRS_DESK_CURRENCIES.DESK_CODE
     */
    public void setDESK_CODE(BigDecimal DESK_CODE) {
        this.DESK_CODE = DESK_CODE;
    }
}