package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRS_PROVISIONVO extends TRS_PROVISIONVOKey {
    /**
     * This field corresponds to the database column TRS_PROVISION.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRS_PROVISION.BRIEF_NAME_ENG
     */
    private String BRIEF_NAME_ENG;

    /**
     * This field corresponds to the database column TRS_PROVISION.LONG_NAME_ENG
     */
    private String LONG_NAME_ENG;

    /**
     * This field corresponds to the database column TRS_PROVISION.BRIEF_NAME_ARAB
     */
    private String BRIEF_NAME_ARAB;

    /**
     * This field corresponds to the database column TRS_PROVISION.LONG_NAME_ARAB
     */
    private String LONG_NAME_ARAB;

    /**
     * This field corresponds to the database column TRS_PROVISION.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column TRS_PROVISION.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column TRS_PROVISION.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column TRS_PROVISION.DATE_MODIFIED
     */
    private Date DATE_MODIFIED;

    /**
     * This field corresponds to the database column TRS_PROVISION.PROVISION_GROUP
     */
    private BigDecimal PROVISION_GROUP;

    /**
     * This field corresponds to the database column TRS_PROVISION.APPLY_STOP_PAYMENT_DATE_YN
     */
    private String APPLY_STOP_PAYMENT_DATE_YN;

    /**
     * This field corresponds to the database column TRS_PROVISION.RETAIN_PROV_AFTER_RESCHEDULE
     */
    private String RETAIN_PROV_AFTER_RESCHEDULE;

    /**
     * This field corresponds to the database column TRS_PROVISION.BOOK_SUS_PROV_AFTER_RESCHEDULE
     */
    private String BOOK_SUS_PROV_AFTER_RESCHEDULE;

    /**
     * This field corresponds to the database column TRS_PROVISION.MANUAL_CLASSIFICATION_YN
     */
    private String MANUAL_CLASSIFICATION_YN;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.BRANCH_CODE
     *
     * @return the value of TRS_PROVISION.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRS_PROVISION.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.BRIEF_NAME_ENG
     *
     * @return the value of TRS_PROVISION.BRIEF_NAME_ENG
     */
    public String getBRIEF_NAME_ENG() {
        return BRIEF_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.BRIEF_NAME_ENG
     *
     * @param BRIEF_NAME_ENG the value for TRS_PROVISION.BRIEF_NAME_ENG
     */
    public void setBRIEF_NAME_ENG(String BRIEF_NAME_ENG) {
        this.BRIEF_NAME_ENG = BRIEF_NAME_ENG == null ? null : BRIEF_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.LONG_NAME_ENG
     *
     * @return the value of TRS_PROVISION.LONG_NAME_ENG
     */
    public String getLONG_NAME_ENG() {
        return LONG_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.LONG_NAME_ENG
     *
     * @param LONG_NAME_ENG the value for TRS_PROVISION.LONG_NAME_ENG
     */
    public void setLONG_NAME_ENG(String LONG_NAME_ENG) {
        this.LONG_NAME_ENG = LONG_NAME_ENG == null ? null : LONG_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.BRIEF_NAME_ARAB
     *
     * @return the value of TRS_PROVISION.BRIEF_NAME_ARAB
     */
    public String getBRIEF_NAME_ARAB() {
        return BRIEF_NAME_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.BRIEF_NAME_ARAB
     *
     * @param BRIEF_NAME_ARAB the value for TRS_PROVISION.BRIEF_NAME_ARAB
     */
    public void setBRIEF_NAME_ARAB(String BRIEF_NAME_ARAB) {
        this.BRIEF_NAME_ARAB = BRIEF_NAME_ARAB == null ? null : BRIEF_NAME_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.LONG_NAME_ARAB
     *
     * @return the value of TRS_PROVISION.LONG_NAME_ARAB
     */
    public String getLONG_NAME_ARAB() {
        return LONG_NAME_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.LONG_NAME_ARAB
     *
     * @param LONG_NAME_ARAB the value for TRS_PROVISION.LONG_NAME_ARAB
     */
    public void setLONG_NAME_ARAB(String LONG_NAME_ARAB) {
        this.LONG_NAME_ARAB = LONG_NAME_ARAB == null ? null : LONG_NAME_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.CREATED_BY
     *
     * @return the value of TRS_PROVISION.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.CREATED_BY
     *
     * @param CREATED_BY the value for TRS_PROVISION.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.DATE_CREATED
     *
     * @return the value of TRS_PROVISION.DATE_CREATED
     */
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.DATE_CREATED
     *
     * @param DATE_CREATED the value for TRS_PROVISION.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.MODIFIED_BY
     *
     * @return the value of TRS_PROVISION.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for TRS_PROVISION.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.DATE_MODIFIED
     *
     * @return the value of TRS_PROVISION.DATE_MODIFIED
     */
    public Date getDATE_MODIFIED() {
        return DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.DATE_MODIFIED
     *
     * @param DATE_MODIFIED the value for TRS_PROVISION.DATE_MODIFIED
     */
    public void setDATE_MODIFIED(Date DATE_MODIFIED) {
        this.DATE_MODIFIED = DATE_MODIFIED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.PROVISION_GROUP
     *
     * @return the value of TRS_PROVISION.PROVISION_GROUP
     */
    public BigDecimal getPROVISION_GROUP() {
        return PROVISION_GROUP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.PROVISION_GROUP
     *
     * @param PROVISION_GROUP the value for TRS_PROVISION.PROVISION_GROUP
     */
    public void setPROVISION_GROUP(BigDecimal PROVISION_GROUP) {
        this.PROVISION_GROUP = PROVISION_GROUP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.APPLY_STOP_PAYMENT_DATE_YN
     *
     * @return the value of TRS_PROVISION.APPLY_STOP_PAYMENT_DATE_YN
     */
    public String getAPPLY_STOP_PAYMENT_DATE_YN() {
        return APPLY_STOP_PAYMENT_DATE_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.APPLY_STOP_PAYMENT_DATE_YN
     *
     * @param APPLY_STOP_PAYMENT_DATE_YN the value for TRS_PROVISION.APPLY_STOP_PAYMENT_DATE_YN
     */
    public void setAPPLY_STOP_PAYMENT_DATE_YN(String APPLY_STOP_PAYMENT_DATE_YN) {
        this.APPLY_STOP_PAYMENT_DATE_YN = APPLY_STOP_PAYMENT_DATE_YN == null ? null : APPLY_STOP_PAYMENT_DATE_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.RETAIN_PROV_AFTER_RESCHEDULE
     *
     * @return the value of TRS_PROVISION.RETAIN_PROV_AFTER_RESCHEDULE
     */
    public String getRETAIN_PROV_AFTER_RESCHEDULE() {
        return RETAIN_PROV_AFTER_RESCHEDULE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.RETAIN_PROV_AFTER_RESCHEDULE
     *
     * @param RETAIN_PROV_AFTER_RESCHEDULE the value for TRS_PROVISION.RETAIN_PROV_AFTER_RESCHEDULE
     */
    public void setRETAIN_PROV_AFTER_RESCHEDULE(String RETAIN_PROV_AFTER_RESCHEDULE) {
        this.RETAIN_PROV_AFTER_RESCHEDULE = RETAIN_PROV_AFTER_RESCHEDULE == null ? null : RETAIN_PROV_AFTER_RESCHEDULE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.BOOK_SUS_PROV_AFTER_RESCHEDULE
     *
     * @return the value of TRS_PROVISION.BOOK_SUS_PROV_AFTER_RESCHEDULE
     */
    public String getBOOK_SUS_PROV_AFTER_RESCHEDULE() {
        return BOOK_SUS_PROV_AFTER_RESCHEDULE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.BOOK_SUS_PROV_AFTER_RESCHEDULE
     *
     * @param BOOK_SUS_PROV_AFTER_RESCHEDULE the value for TRS_PROVISION.BOOK_SUS_PROV_AFTER_RESCHEDULE
     */
    public void setBOOK_SUS_PROV_AFTER_RESCHEDULE(String BOOK_SUS_PROV_AFTER_RESCHEDULE) {
        this.BOOK_SUS_PROV_AFTER_RESCHEDULE = BOOK_SUS_PROV_AFTER_RESCHEDULE == null ? null : BOOK_SUS_PROV_AFTER_RESCHEDULE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROVISION.MANUAL_CLASSIFICATION_YN
     *
     * @return the value of TRS_PROVISION.MANUAL_CLASSIFICATION_YN
     */
    public String getMANUAL_CLASSIFICATION_YN() {
        return MANUAL_CLASSIFICATION_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROVISION.MANUAL_CLASSIFICATION_YN
     *
     * @param MANUAL_CLASSIFICATION_YN the value for TRS_PROVISION.MANUAL_CLASSIFICATION_YN
     */
    public void setMANUAL_CLASSIFICATION_YN(String MANUAL_CLASSIFICATION_YN) {
        this.MANUAL_CLASSIFICATION_YN = MANUAL_CLASSIFICATION_YN == null ? null : MANUAL_CLASSIFICATION_YN.trim();
    }
}