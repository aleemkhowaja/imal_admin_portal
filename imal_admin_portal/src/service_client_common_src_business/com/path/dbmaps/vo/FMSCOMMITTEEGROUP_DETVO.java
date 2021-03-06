package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class FMSCOMMITTEEGROUP_DETVO extends FMSCOMMITTEEGROUP_DETVOKey {
    /**
     * This field corresponds to the database column FMSCOMMITTEEGROUP_DET.COMMITTEE_CODE
     */
    private BigDecimal COMMITTEE_CODE;

    /**
     * This field corresponds to the database column FMSCOMMITTEEGROUP_DET.APPROVAL_HIERARCHY
     */
    private BigDecimal APPROVAL_HIERARCHY;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSCOMMITTEEGROUP_DET.COMMITTEE_CODE
     *
     * @return the value of FMSCOMMITTEEGROUP_DET.COMMITTEE_CODE
     */
    public BigDecimal getCOMMITTEE_CODE() {
        return COMMITTEE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSCOMMITTEEGROUP_DET.COMMITTEE_CODE
     *
     * @param COMMITTEE_CODE the value for FMSCOMMITTEEGROUP_DET.COMMITTEE_CODE
     */
    public void setCOMMITTEE_CODE(BigDecimal COMMITTEE_CODE) {
        this.COMMITTEE_CODE = COMMITTEE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSCOMMITTEEGROUP_DET.APPROVAL_HIERARCHY
     *
     * @return the value of FMSCOMMITTEEGROUP_DET.APPROVAL_HIERARCHY
     */
    public BigDecimal getAPPROVAL_HIERARCHY() {
        return APPROVAL_HIERARCHY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSCOMMITTEEGROUP_DET.APPROVAL_HIERARCHY
     *
     * @param APPROVAL_HIERARCHY the value for FMSCOMMITTEEGROUP_DET.APPROVAL_HIERARCHY
     */
    public void setAPPROVAL_HIERARCHY(BigDecimal APPROVAL_HIERARCHY) {
        this.APPROVAL_HIERARCHY = APPROVAL_HIERARCHY;
    }
}