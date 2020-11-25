package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class PMSSEC_ECLVOKey extends BaseVO {
    /**
     * This field corresponds to the database column PMSSEC_ECL.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column PMSSEC_ECL.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column PMSSEC_ECL.ECL_DATE
     */
    private Date ECL_DATE;

    /**
     * This field corresponds to the database column PMSSEC_ECL.SECURITY_CODE1
     */
    private BigDecimal SECURITY_CODE1;

    /**
     * This field corresponds to the database column PMSSEC_ECL.SECURITY_CODE2
     */
    private BigDecimal SECURITY_CODE2;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSSEC_ECL.BRANCH
     *
     * @return the value of PMSSEC_ECL.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSSEC_ECL.BRANCH
     *
     * @param BRANCH the value for PMSSEC_ECL.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSSEC_ECL.COMP_CODE
     *
     * @return the value of PMSSEC_ECL.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSSEC_ECL.COMP_CODE
     *
     * @param COMP_CODE the value for PMSSEC_ECL.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSSEC_ECL.ECL_DATE
     *
     * @return the value of PMSSEC_ECL.ECL_DATE
     */
    public Date getECL_DATE() {
        return ECL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSSEC_ECL.ECL_DATE
     *
     * @param ECL_DATE the value for PMSSEC_ECL.ECL_DATE
     */
    public void setECL_DATE(Date ECL_DATE) {
        this.ECL_DATE = ECL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSSEC_ECL.SECURITY_CODE1
     *
     * @return the value of PMSSEC_ECL.SECURITY_CODE1
     */
    public BigDecimal getSECURITY_CODE1() {
        return SECURITY_CODE1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSSEC_ECL.SECURITY_CODE1
     *
     * @param SECURITY_CODE1 the value for PMSSEC_ECL.SECURITY_CODE1
     */
    public void setSECURITY_CODE1(BigDecimal SECURITY_CODE1) {
        this.SECURITY_CODE1 = SECURITY_CODE1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSSEC_ECL.SECURITY_CODE2
     *
     * @return the value of PMSSEC_ECL.SECURITY_CODE2
     */
    public BigDecimal getSECURITY_CODE2() {
        return SECURITY_CODE2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSSEC_ECL.SECURITY_CODE2
     *
     * @param SECURITY_CODE2 the value for PMSSEC_ECL.SECURITY_CODE2
     */
    public void setSECURITY_CODE2(BigDecimal SECURITY_CODE2) {
        this.SECURITY_CODE2 = SECURITY_CODE2;
    }
}