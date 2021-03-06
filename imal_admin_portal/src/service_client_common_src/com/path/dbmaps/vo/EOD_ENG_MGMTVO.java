package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class EOD_ENG_MGMTVO extends EOD_ENG_MGMTVOKey {
    /**
     * This field corresponds to the database column EOD_ENG_MGMT.BATCH_CODE
     */
    private BigDecimal BATCH_CODE;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.PROCESS_CODE
     */
    private BigDecimal PROCESS_CODE;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.EOD_ENG_MGMT_PARENT_ID
     */
    private BigDecimal EOD_ENG_MGMT_PARENT_ID;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.STARTING_TIME
     */
    private Date STARTING_TIME;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.ENDING_TIME
     */
    private Date ENDING_TIME;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.DB_SESSION_ID
     */
    private BigDecimal DB_SESSION_ID;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.DB_INST_ID
     */
    private BigDecimal DB_INST_ID;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.RUNNING_DATE
     */
    private Date RUNNING_DATE;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.CREATION_DATE
     */
    private Date CREATION_DATE;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.CREATION_BY
     */
    private String CREATION_BY;

    /**
     * This field corresponds to the database column EOD_ENG_MGMT.EOD_ENG_MGMT_BATCH_ID
     */
	private BigDecimal EOD_ENG_MGMT_BATCH_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.BATCH_CODE
     *
     * @return the value of EOD_ENG_MGMT.BATCH_CODE
     */
    public BigDecimal getBATCH_CODE() {
        return BATCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.BATCH_CODE
     *
     * @param BATCH_CODE the value for EOD_ENG_MGMT.BATCH_CODE
     */
    public void setBATCH_CODE(BigDecimal BATCH_CODE) {
        this.BATCH_CODE = BATCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.COMP_CODE
     *
     * @return the value of EOD_ENG_MGMT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.COMP_CODE
     *
     * @param COMP_CODE the value for EOD_ENG_MGMT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.BRANCH_CODE
     *
     * @return the value of EOD_ENG_MGMT.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for EOD_ENG_MGMT.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.PROCESS_CODE
     *
     * @return the value of EOD_ENG_MGMT.PROCESS_CODE
     */
    public BigDecimal getPROCESS_CODE() {
        return PROCESS_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.PROCESS_CODE
     *
     * @param PROCESS_CODE the value for EOD_ENG_MGMT.PROCESS_CODE
     */
    public void setPROCESS_CODE(BigDecimal PROCESS_CODE) {
        this.PROCESS_CODE = PROCESS_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.EOD_ENG_MGMT_PARENT_ID
     *
     * @return the value of EOD_ENG_MGMT.EOD_ENG_MGMT_PARENT_ID
     */
    public BigDecimal getEOD_ENG_MGMT_PARENT_ID() {
        return EOD_ENG_MGMT_PARENT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.EOD_ENG_MGMT_PARENT_ID
     *
     * @param EOD_ENG_MGMT_PARENT_ID the value for EOD_ENG_MGMT.EOD_ENG_MGMT_PARENT_ID
     */
    public void setEOD_ENG_MGMT_PARENT_ID(BigDecimal EOD_ENG_MGMT_PARENT_ID) {
        this.EOD_ENG_MGMT_PARENT_ID = EOD_ENG_MGMT_PARENT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.STATUS
     *
     * @return the value of EOD_ENG_MGMT.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.STATUS
     *
     * @param STATUS the value for EOD_ENG_MGMT.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.STARTING_TIME
     *
     * @return the value of EOD_ENG_MGMT.STARTING_TIME
     */
    public Date getSTARTING_TIME() {
        return STARTING_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.STARTING_TIME
     *
     * @param STARTING_TIME the value for EOD_ENG_MGMT.STARTING_TIME
     */
    public void setSTARTING_TIME(Date STARTING_TIME) {
        this.STARTING_TIME = STARTING_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.ENDING_TIME
     *
     * @return the value of EOD_ENG_MGMT.ENDING_TIME
     */
    public Date getENDING_TIME() {
        return ENDING_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.ENDING_TIME
     *
     * @param ENDING_TIME the value for EOD_ENG_MGMT.ENDING_TIME
     */
    public void setENDING_TIME(Date ENDING_TIME) {
        this.ENDING_TIME = ENDING_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.DB_SESSION_ID
     *
     * @return the value of EOD_ENG_MGMT.DB_SESSION_ID
     */
    public BigDecimal getDB_SESSION_ID() {
        return DB_SESSION_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.DB_SESSION_ID
     *
     * @param DB_SESSION_ID the value for EOD_ENG_MGMT.DB_SESSION_ID
     */
    public void setDB_SESSION_ID(BigDecimal DB_SESSION_ID) {
        this.DB_SESSION_ID = DB_SESSION_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.DB_INST_ID
     *
     * @return the value of EOD_ENG_MGMT.DB_INST_ID
     */
    public BigDecimal getDB_INST_ID() {
        return DB_INST_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.DB_INST_ID
     *
     * @param DB_INST_ID the value for EOD_ENG_MGMT.DB_INST_ID
     */
    public void setDB_INST_ID(BigDecimal DB_INST_ID) {
        this.DB_INST_ID = DB_INST_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.RUNNING_DATE
     *
     * @return the value of EOD_ENG_MGMT.RUNNING_DATE
     */
    public Date getRUNNING_DATE() {
        return RUNNING_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.RUNNING_DATE
     *
     * @param RUNNING_DATE the value for EOD_ENG_MGMT.RUNNING_DATE
     */
    public void setRUNNING_DATE(Date RUNNING_DATE) {
        this.RUNNING_DATE = RUNNING_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.CREATION_DATE
     *
     * @return the value of EOD_ENG_MGMT.CREATION_DATE
     */
    public Date getCREATION_DATE() {
        return CREATION_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.CREATION_DATE
     *
     * @param CREATION_DATE the value for EOD_ENG_MGMT.CREATION_DATE
     */
    public void setCREATION_DATE(Date CREATION_DATE) {
        this.CREATION_DATE = CREATION_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EOD_ENG_MGMT.CREATION_BY
     *
     * @return the value of EOD_ENG_MGMT.CREATION_BY
     */
    public String getCREATION_BY() {
        return CREATION_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EOD_ENG_MGMT.CREATION_BY
     *
     * @param CREATION_BY the value for EOD_ENG_MGMT.CREATION_BY
     */
    public void setCREATION_BY(String CREATION_BY) {
        this.CREATION_BY = CREATION_BY == null ? null : CREATION_BY.trim();
    }
    
    /**
     * This method returns the value of the database column EOD_ENG_MGMT.EOD_ENG_MGMT_BATCH_ID
     *
     * @param CREATION_BY the value for EOD_ENG_MGMT.EOD_ENG_MGMT_BATCH_ID
     */
	public BigDecimal getEOD_ENG_MGMT_BATCH_ID() {
		return EOD_ENG_MGMT_BATCH_ID;
	}
	
    
    /**
     * This method sets the value of the database column EOD_ENG_MGMT.EOD_ENG_MGMT_BATCH_ID
     *
     * @param CREATION_BY the value for EOD_ENG_MGMT.EOD_ENG_MGMT_BATCH_ID
     */
	public void setEOD_ENG_MGMT_BATCH_ID(BigDecimal eOD_ENG_MGMT_BATCH_ID) {
		EOD_ENG_MGMT_BATCH_ID = eOD_ENG_MGMT_BATCH_ID;
	}
}