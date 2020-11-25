package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CTSCARDS_ACCVO extends CTSCARDS_ACCVOKey {
    /**
     * This field corresponds to the database column CTSCARDS_ACC.ACCOUNT_STATUS
     */
    private String ACCOUNT_STATUS;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.ACCOUNT_STATUS_REASON
     */
    private String ACCOUNT_STATUS_REASON;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.ACCOUNT_STATUS_DATE
     */
    private Date ACCOUNT_STATUS_DATE;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.LIMIT_BASED_ON
     */
    private String LIMIT_BASED_ON;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.LIMIT_CHECK_PERIOD
     */
    private String LIMIT_CHECK_PERIOD;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.LIMIT_AMOUNT
     */
    private BigDecimal LIMIT_AMOUNT;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.LINE_NUM
     */
    private BigDecimal LINE_NUM;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.ADD_LINK_ACC
     */
    private String ADD_LINK_ACC;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.POS_BASED_ON
     */
    private String POS_BASED_ON;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.POS_PERIODICITY
     */
    private String POS_PERIODICITY;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.POS_LIMIT
     */
    private BigDecimal POS_LIMIT;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.ACC_PRIORITY
     */
    private BigDecimal ACC_PRIORITY;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.ACC_ADD_REF
     */
    private String ACC_ADD_REF;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.PK_SEC_FLAG
     */
    private String PK_SEC_FLAG;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.TEMP_PERMANENT
     */
    private String TEMP_PERMANENT;

    /**
     * This field corresponds to the database column CTSCARDS_ACC.TEMP_PERMANENT_POS
     */
    private String TEMP_PERMANENT_POS;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.ACCOUNT_STATUS
     *
     * @return the value of CTSCARDS_ACC.ACCOUNT_STATUS
     */
    public String getACCOUNT_STATUS() {
        return ACCOUNT_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.ACCOUNT_STATUS
     *
     * @param ACCOUNT_STATUS the value for CTSCARDS_ACC.ACCOUNT_STATUS
     */
    public void setACCOUNT_STATUS(String ACCOUNT_STATUS) {
        this.ACCOUNT_STATUS = ACCOUNT_STATUS == null ? null : ACCOUNT_STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.ACCOUNT_STATUS_REASON
     *
     * @return the value of CTSCARDS_ACC.ACCOUNT_STATUS_REASON
     */
    public String getACCOUNT_STATUS_REASON() {
        return ACCOUNT_STATUS_REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.ACCOUNT_STATUS_REASON
     *
     * @param ACCOUNT_STATUS_REASON the value for CTSCARDS_ACC.ACCOUNT_STATUS_REASON
     */
    public void setACCOUNT_STATUS_REASON(String ACCOUNT_STATUS_REASON) {
        this.ACCOUNT_STATUS_REASON = ACCOUNT_STATUS_REASON == null ? null : ACCOUNT_STATUS_REASON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.ACCOUNT_STATUS_DATE
     *
     * @return the value of CTSCARDS_ACC.ACCOUNT_STATUS_DATE
     */
    public Date getACCOUNT_STATUS_DATE() {
        return ACCOUNT_STATUS_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.ACCOUNT_STATUS_DATE
     *
     * @param ACCOUNT_STATUS_DATE the value for CTSCARDS_ACC.ACCOUNT_STATUS_DATE
     */
    public void setACCOUNT_STATUS_DATE(Date ACCOUNT_STATUS_DATE) {
        this.ACCOUNT_STATUS_DATE = ACCOUNT_STATUS_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.LIMIT_BASED_ON
     *
     * @return the value of CTSCARDS_ACC.LIMIT_BASED_ON
     */
    public String getLIMIT_BASED_ON() {
        return LIMIT_BASED_ON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.LIMIT_BASED_ON
     *
     * @param LIMIT_BASED_ON the value for CTSCARDS_ACC.LIMIT_BASED_ON
     */
    public void setLIMIT_BASED_ON(String LIMIT_BASED_ON) {
        this.LIMIT_BASED_ON = LIMIT_BASED_ON == null ? null : LIMIT_BASED_ON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.LIMIT_CHECK_PERIOD
     *
     * @return the value of CTSCARDS_ACC.LIMIT_CHECK_PERIOD
     */
    public String getLIMIT_CHECK_PERIOD() {
        return LIMIT_CHECK_PERIOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.LIMIT_CHECK_PERIOD
     *
     * @param LIMIT_CHECK_PERIOD the value for CTSCARDS_ACC.LIMIT_CHECK_PERIOD
     */
    public void setLIMIT_CHECK_PERIOD(String LIMIT_CHECK_PERIOD) {
        this.LIMIT_CHECK_PERIOD = LIMIT_CHECK_PERIOD == null ? null : LIMIT_CHECK_PERIOD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.LIMIT_AMOUNT
     *
     * @return the value of CTSCARDS_ACC.LIMIT_AMOUNT
     */
    public BigDecimal getLIMIT_AMOUNT() {
        return LIMIT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.LIMIT_AMOUNT
     *
     * @param LIMIT_AMOUNT the value for CTSCARDS_ACC.LIMIT_AMOUNT
     */
    public void setLIMIT_AMOUNT(BigDecimal LIMIT_AMOUNT) {
        this.LIMIT_AMOUNT = LIMIT_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.LINE_NUM
     *
     * @return the value of CTSCARDS_ACC.LINE_NUM
     */
    public BigDecimal getLINE_NUM() {
        return LINE_NUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.LINE_NUM
     *
     * @param LINE_NUM the value for CTSCARDS_ACC.LINE_NUM
     */
    public void setLINE_NUM(BigDecimal LINE_NUM) {
        this.LINE_NUM = LINE_NUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.ADD_LINK_ACC
     *
     * @return the value of CTSCARDS_ACC.ADD_LINK_ACC
     */
    public String getADD_LINK_ACC() {
        return ADD_LINK_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.ADD_LINK_ACC
     *
     * @param ADD_LINK_ACC the value for CTSCARDS_ACC.ADD_LINK_ACC
     */
    public void setADD_LINK_ACC(String ADD_LINK_ACC) {
        this.ADD_LINK_ACC = ADD_LINK_ACC == null ? null : ADD_LINK_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.POS_BASED_ON
     *
     * @return the value of CTSCARDS_ACC.POS_BASED_ON
     */
    public String getPOS_BASED_ON() {
        return POS_BASED_ON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.POS_BASED_ON
     *
     * @param POS_BASED_ON the value for CTSCARDS_ACC.POS_BASED_ON
     */
    public void setPOS_BASED_ON(String POS_BASED_ON) {
        this.POS_BASED_ON = POS_BASED_ON == null ? null : POS_BASED_ON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.POS_PERIODICITY
     *
     * @return the value of CTSCARDS_ACC.POS_PERIODICITY
     */
    public String getPOS_PERIODICITY() {
        return POS_PERIODICITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.POS_PERIODICITY
     *
     * @param POS_PERIODICITY the value for CTSCARDS_ACC.POS_PERIODICITY
     */
    public void setPOS_PERIODICITY(String POS_PERIODICITY) {
        this.POS_PERIODICITY = POS_PERIODICITY == null ? null : POS_PERIODICITY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.POS_LIMIT
     *
     * @return the value of CTSCARDS_ACC.POS_LIMIT
     */
    public BigDecimal getPOS_LIMIT() {
        return POS_LIMIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.POS_LIMIT
     *
     * @param POS_LIMIT the value for CTSCARDS_ACC.POS_LIMIT
     */
    public void setPOS_LIMIT(BigDecimal POS_LIMIT) {
        this.POS_LIMIT = POS_LIMIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.ACC_PRIORITY
     *
     * @return the value of CTSCARDS_ACC.ACC_PRIORITY
     */
    public BigDecimal getACC_PRIORITY() {
        return ACC_PRIORITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.ACC_PRIORITY
     *
     * @param ACC_PRIORITY the value for CTSCARDS_ACC.ACC_PRIORITY
     */
    public void setACC_PRIORITY(BigDecimal ACC_PRIORITY) {
        this.ACC_PRIORITY = ACC_PRIORITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.ACC_ADD_REF
     *
     * @return the value of CTSCARDS_ACC.ACC_ADD_REF
     */
    public String getACC_ADD_REF() {
        return ACC_ADD_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.ACC_ADD_REF
     *
     * @param ACC_ADD_REF the value for CTSCARDS_ACC.ACC_ADD_REF
     */
    public void setACC_ADD_REF(String ACC_ADD_REF) {
        this.ACC_ADD_REF = ACC_ADD_REF == null ? null : ACC_ADD_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.PK_SEC_FLAG
     *
     * @return the value of CTSCARDS_ACC.PK_SEC_FLAG
     */
    public String getPK_SEC_FLAG() {
        return PK_SEC_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.PK_SEC_FLAG
     *
     * @param PK_SEC_FLAG the value for CTSCARDS_ACC.PK_SEC_FLAG
     */
    public void setPK_SEC_FLAG(String PK_SEC_FLAG) {
        this.PK_SEC_FLAG = PK_SEC_FLAG == null ? null : PK_SEC_FLAG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.TEMP_PERMANENT
     *
     * @return the value of CTSCARDS_ACC.TEMP_PERMANENT
     */
    public String getTEMP_PERMANENT() {
        return TEMP_PERMANENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.TEMP_PERMANENT
     *
     * @param TEMP_PERMANENT the value for CTSCARDS_ACC.TEMP_PERMANENT
     */
    public void setTEMP_PERMANENT(String TEMP_PERMANENT) {
        this.TEMP_PERMANENT = TEMP_PERMANENT == null ? null : TEMP_PERMANENT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_ACC.TEMP_PERMANENT_POS
     *
     * @return the value of CTSCARDS_ACC.TEMP_PERMANENT_POS
     */
    public String getTEMP_PERMANENT_POS() {
        return TEMP_PERMANENT_POS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_ACC.TEMP_PERMANENT_POS
     *
     * @param TEMP_PERMANENT_POS the value for CTSCARDS_ACC.TEMP_PERMANENT_POS
     */
    public void setTEMP_PERMANENT_POS(String TEMP_PERMANENT_POS) {
        this.TEMP_PERMANENT_POS = TEMP_PERMANENT_POS == null ? null : TEMP_PERMANENT_POS.trim();
    }
}