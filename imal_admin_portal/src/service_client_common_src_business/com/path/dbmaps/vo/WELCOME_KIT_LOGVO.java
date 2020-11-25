package com.path.dbmaps.vo;

import java.util.Date;

public class WELCOME_KIT_LOGVO extends WELCOME_KIT_LOGVOKey {
    /**
     * This field corresponds to the database column WELCOME_KIT_LOG.CARD_NO
     */
    private String CARD_NO;

    /**
     * This field corresponds to the database column WELCOME_KIT_LOG.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column WELCOME_KIT_LOG.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column WELCOME_KIT_LOG.APPROVED_YN
     */
    private String APPROVED_YN;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WELCOME_KIT_LOG.CARD_NO
     *
     * @return the value of WELCOME_KIT_LOG.CARD_NO
     */
    public String getCARD_NO() {
        return CARD_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WELCOME_KIT_LOG.CARD_NO
     *
     * @param CARD_NO the value for WELCOME_KIT_LOG.CARD_NO
     */
    public void setCARD_NO(String CARD_NO) {
        this.CARD_NO = CARD_NO == null ? null : CARD_NO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WELCOME_KIT_LOG.DATE_CREATED
     *
     * @return the value of WELCOME_KIT_LOG.DATE_CREATED
     */
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WELCOME_KIT_LOG.DATE_CREATED
     *
     * @param DATE_CREATED the value for WELCOME_KIT_LOG.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WELCOME_KIT_LOG.CREATED_BY
     *
     * @return the value of WELCOME_KIT_LOG.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WELCOME_KIT_LOG.CREATED_BY
     *
     * @param CREATED_BY the value for WELCOME_KIT_LOG.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WELCOME_KIT_LOG.APPROVED_YN
     *
     * @return the value of WELCOME_KIT_LOG.APPROVED_YN
     */
    public String getAPPROVED_YN() {
        return APPROVED_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WELCOME_KIT_LOG.APPROVED_YN
     *
     * @param APPROVED_YN the value for WELCOME_KIT_LOG.APPROVED_YN
     */
    public void setAPPROVED_YN(String APPROVED_YN) {
        this.APPROVED_YN = APPROVED_YN == null ? null : APPROVED_YN.trim();
    }
}