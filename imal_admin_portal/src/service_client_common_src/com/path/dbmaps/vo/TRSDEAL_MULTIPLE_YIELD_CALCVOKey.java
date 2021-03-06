package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class TRSDEAL_MULTIPLE_YIELD_CALCVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSDEAL_MULTIPLE_YIELD_CALC.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRSDEAL_MULTIPLE_YIELD_CALC.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRSDEAL_MULTIPLE_YIELD_CALC.DEAL_NO
     */
    private BigDecimal DEAL_NO;

    /**
     * This field corresponds to the database column TRSDEAL_MULTIPLE_YIELD_CALC.FROM_DATE
     */
    private Date FROM_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_MULTIPLE_YIELD_CALC.BRANCH_CODE
     *
     * @return the value of TRSDEAL_MULTIPLE_YIELD_CALC.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_MULTIPLE_YIELD_CALC.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRSDEAL_MULTIPLE_YIELD_CALC.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_MULTIPLE_YIELD_CALC.COMP_CODE
     *
     * @return the value of TRSDEAL_MULTIPLE_YIELD_CALC.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_MULTIPLE_YIELD_CALC.COMP_CODE
     *
     * @param COMP_CODE the value for TRSDEAL_MULTIPLE_YIELD_CALC.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_MULTIPLE_YIELD_CALC.DEAL_NO
     *
     * @return the value of TRSDEAL_MULTIPLE_YIELD_CALC.DEAL_NO
     */
    public BigDecimal getDEAL_NO() {
        return DEAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_MULTIPLE_YIELD_CALC.DEAL_NO
     *
     * @param DEAL_NO the value for TRSDEAL_MULTIPLE_YIELD_CALC.DEAL_NO
     */
    public void setDEAL_NO(BigDecimal DEAL_NO) {
        this.DEAL_NO = DEAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_MULTIPLE_YIELD_CALC.FROM_DATE
     *
     * @return the value of TRSDEAL_MULTIPLE_YIELD_CALC.FROM_DATE
     */
    public Date getFROM_DATE() {
        return FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_MULTIPLE_YIELD_CALC.FROM_DATE
     *
     * @param FROM_DATE the value for TRSDEAL_MULTIPLE_YIELD_CALC.FROM_DATE
     */
    public void setFROM_DATE(Date FROM_DATE) {
        this.FROM_DATE = FROM_DATE;
    }
}