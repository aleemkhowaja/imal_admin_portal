package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class FMSAPPLCOMMITTEEVO extends FMSAPPLCOMMITTEEVOKey {
    /**
     * This field corresponds to the database column FMSAPPLCOMMITTEE.COMMITTEE
     */
    private BigDecimal COMMITTEE;

    /**
     * This field corresponds to the database column FMSAPPLCOMMITTEE.APPROVE_RECOMMEND
     */
    private String APPROVE_RECOMMEND;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLCOMMITTEE.COMMITTEE
     *
     * @return the value of FMSAPPLCOMMITTEE.COMMITTEE
     */
    public BigDecimal getCOMMITTEE() {
        return COMMITTEE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLCOMMITTEE.COMMITTEE
     *
     * @param COMMITTEE the value for FMSAPPLCOMMITTEE.COMMITTEE
     */
    public void setCOMMITTEE(BigDecimal COMMITTEE) {
        this.COMMITTEE = COMMITTEE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLCOMMITTEE.APPROVE_RECOMMEND
     *
     * @return the value of FMSAPPLCOMMITTEE.APPROVE_RECOMMEND
     */
    public String getAPPROVE_RECOMMEND() {
        return APPROVE_RECOMMEND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLCOMMITTEE.APPROVE_RECOMMEND
     *
     * @param APPROVE_RECOMMEND the value for FMSAPPLCOMMITTEE.APPROVE_RECOMMEND
     */
    public void setAPPROVE_RECOMMEND(String APPROVE_RECOMMEND) {
        this.APPROVE_RECOMMEND = APPROVE_RECOMMEND == null ? null : APPROVE_RECOMMEND.trim();
    }
}