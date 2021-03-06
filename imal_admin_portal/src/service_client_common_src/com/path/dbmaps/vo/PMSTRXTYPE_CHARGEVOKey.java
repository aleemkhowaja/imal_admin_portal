package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class PMSTRXTYPE_CHARGEVOKey extends BaseVO {
    /**
     * This field corresponds to the database column PMSTRXTYPE_CHARGE.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column PMSTRXTYPE_CHARGE.CHARGE_CODE
     */
    private BigDecimal CHARGE_CODE;

    /**
     * This field corresponds to the database column PMSTRXTYPE_CHARGE.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column PMSTRXTYPE_CHARGE.ENTITY_CODE
     */
    private BigDecimal ENTITY_CODE;

    /**
     * This field corresponds to the database column PMSTRXTYPE_CHARGE.ENTITY_TYPE
     */
    private String ENTITY_TYPE;

    /**
     * This field corresponds to the database column PMSTRXTYPE_CHARGE.TRXTYPE_CODE
     */
    private BigDecimal TRXTYPE_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSTRXTYPE_CHARGE.BRANCH_CODE
     *
     * @return the value of PMSTRXTYPE_CHARGE.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSTRXTYPE_CHARGE.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for PMSTRXTYPE_CHARGE.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSTRXTYPE_CHARGE.CHARGE_CODE
     *
     * @return the value of PMSTRXTYPE_CHARGE.CHARGE_CODE
     */
    public BigDecimal getCHARGE_CODE() {
        return CHARGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSTRXTYPE_CHARGE.CHARGE_CODE
     *
     * @param CHARGE_CODE the value for PMSTRXTYPE_CHARGE.CHARGE_CODE
     */
    public void setCHARGE_CODE(BigDecimal CHARGE_CODE) {
        this.CHARGE_CODE = CHARGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSTRXTYPE_CHARGE.COMP_CODE
     *
     * @return the value of PMSTRXTYPE_CHARGE.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSTRXTYPE_CHARGE.COMP_CODE
     *
     * @param COMP_CODE the value for PMSTRXTYPE_CHARGE.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSTRXTYPE_CHARGE.ENTITY_CODE
     *
     * @return the value of PMSTRXTYPE_CHARGE.ENTITY_CODE
     */
    public BigDecimal getENTITY_CODE() {
        return ENTITY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSTRXTYPE_CHARGE.ENTITY_CODE
     *
     * @param ENTITY_CODE the value for PMSTRXTYPE_CHARGE.ENTITY_CODE
     */
    public void setENTITY_CODE(BigDecimal ENTITY_CODE) {
        this.ENTITY_CODE = ENTITY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSTRXTYPE_CHARGE.ENTITY_TYPE
     *
     * @return the value of PMSTRXTYPE_CHARGE.ENTITY_TYPE
     */
    public String getENTITY_TYPE() {
        return ENTITY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSTRXTYPE_CHARGE.ENTITY_TYPE
     *
     * @param ENTITY_TYPE the value for PMSTRXTYPE_CHARGE.ENTITY_TYPE
     */
    public void setENTITY_TYPE(String ENTITY_TYPE) {
        this.ENTITY_TYPE = ENTITY_TYPE == null ? null : ENTITY_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSTRXTYPE_CHARGE.TRXTYPE_CODE
     *
     * @return the value of PMSTRXTYPE_CHARGE.TRXTYPE_CODE
     */
    public BigDecimal getTRXTYPE_CODE() {
        return TRXTYPE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSTRXTYPE_CHARGE.TRXTYPE_CODE
     *
     * @param TRXTYPE_CODE the value for PMSTRXTYPE_CHARGE.TRXTYPE_CODE
     */
    public void setTRXTYPE_CODE(BigDecimal TRXTYPE_CODE) {
        this.TRXTYPE_CODE = TRXTYPE_CODE;
    }
}