package com.path.dbmaps.vo;

import java.util.Date;

public class USR_SNOOZE_ALERTVO extends USR_SNOOZE_ALERTVOKey {
    /**
     * This field corresponds to the database column USR_SNOOZE_ALERT.NEXT_ALERT_DATE
     */
    private Date NEXT_ALERT_DATE;

    /**
     * This field corresponds to the database column USR_SNOOZE_ALERT.SNOOZE_REFRESH_TIME
     */
    private String SNOOZE_REFRESH_TIME;

    /**
     * This field corresponds to the database column USR_SNOOZE_ALERT.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column USR_SNOOZE_ALERT.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column USR_SNOOZE_ALERT.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column USR_SNOOZE_ALERT.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USR_SNOOZE_ALERT.NEXT_ALERT_DATE
     *
     * @return the value of USR_SNOOZE_ALERT.NEXT_ALERT_DATE
     */
    public Date getNEXT_ALERT_DATE() {
        return NEXT_ALERT_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USR_SNOOZE_ALERT.NEXT_ALERT_DATE
     *
     * @param NEXT_ALERT_DATE the value for USR_SNOOZE_ALERT.NEXT_ALERT_DATE
     */
    public void setNEXT_ALERT_DATE(Date NEXT_ALERT_DATE) {
        this.NEXT_ALERT_DATE = NEXT_ALERT_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USR_SNOOZE_ALERT.SNOOZE_REFRESH_TIME
     *
     * @return the value of USR_SNOOZE_ALERT.SNOOZE_REFRESH_TIME
     */
    public String getSNOOZE_REFRESH_TIME() {
        return SNOOZE_REFRESH_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USR_SNOOZE_ALERT.SNOOZE_REFRESH_TIME
     *
     * @param SNOOZE_REFRESH_TIME the value for USR_SNOOZE_ALERT.SNOOZE_REFRESH_TIME
     */
    public void setSNOOZE_REFRESH_TIME(String SNOOZE_REFRESH_TIME) {
        this.SNOOZE_REFRESH_TIME = SNOOZE_REFRESH_TIME == null ? null : SNOOZE_REFRESH_TIME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USR_SNOOZE_ALERT.CREATED_BY
     *
     * @return the value of USR_SNOOZE_ALERT.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USR_SNOOZE_ALERT.CREATED_BY
     *
     * @param CREATED_BY the value for USR_SNOOZE_ALERT.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USR_SNOOZE_ALERT.CREATED_DATE
     *
     * @return the value of USR_SNOOZE_ALERT.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USR_SNOOZE_ALERT.CREATED_DATE
     *
     * @param CREATED_DATE the value for USR_SNOOZE_ALERT.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USR_SNOOZE_ALERT.MODIFIED_BY
     *
     * @return the value of USR_SNOOZE_ALERT.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USR_SNOOZE_ALERT.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for USR_SNOOZE_ALERT.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USR_SNOOZE_ALERT.MODIFIED_DATE
     *
     * @return the value of USR_SNOOZE_ALERT.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USR_SNOOZE_ALERT.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for USR_SNOOZE_ALERT.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }
}