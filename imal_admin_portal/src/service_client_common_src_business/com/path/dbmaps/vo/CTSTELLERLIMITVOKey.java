package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTSTELLERLIMITVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTSTELLERLIMIT.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTSTELLERLIMIT.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column CTSTELLERLIMIT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTSTELLERLIMIT.CY_CODE
     */
    private BigDecimal CY_CODE;

    /**
     * This field corresponds to the database column CTSTELLERLIMIT.LIMIT_TYPE
     */
    private String LIMIT_TYPE;

    /**
     * This field corresponds to the database column CTSTELLERLIMIT.TRX_TYPE
     */
    private BigDecimal TRX_TYPE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTELLERLIMIT.BRANCH_CODE
     *
     * @return the value of CTSTELLERLIMIT.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTELLERLIMIT.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for CTSTELLERLIMIT.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTELLERLIMIT.CODE
     *
     * @return the value of CTSTELLERLIMIT.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTELLERLIMIT.CODE
     *
     * @param CODE the value for CTSTELLERLIMIT.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTELLERLIMIT.COMP_CODE
     *
     * @return the value of CTSTELLERLIMIT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTELLERLIMIT.COMP_CODE
     *
     * @param COMP_CODE the value for CTSTELLERLIMIT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTELLERLIMIT.CY_CODE
     *
     * @return the value of CTSTELLERLIMIT.CY_CODE
     */
    public BigDecimal getCY_CODE() {
        return CY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTELLERLIMIT.CY_CODE
     *
     * @param CY_CODE the value for CTSTELLERLIMIT.CY_CODE
     */
    public void setCY_CODE(BigDecimal CY_CODE) {
        this.CY_CODE = CY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTELLERLIMIT.LIMIT_TYPE
     *
     * @return the value of CTSTELLERLIMIT.LIMIT_TYPE
     */
    public String getLIMIT_TYPE() {
        return LIMIT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTELLERLIMIT.LIMIT_TYPE
     *
     * @param LIMIT_TYPE the value for CTSTELLERLIMIT.LIMIT_TYPE
     */
    public void setLIMIT_TYPE(String LIMIT_TYPE) {
        this.LIMIT_TYPE = LIMIT_TYPE == null ? null : LIMIT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSTELLERLIMIT.TRX_TYPE
     *
     * @return the value of CTSTELLERLIMIT.TRX_TYPE
     */
    public BigDecimal getTRX_TYPE() {
        return TRX_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSTELLERLIMIT.TRX_TYPE
     *
     * @param TRX_TYPE the value for CTSTELLERLIMIT.TRX_TYPE
     */
    public void setTRX_TYPE(BigDecimal TRX_TYPE) {
        this.TRX_TYPE = TRX_TYPE;
    }
}