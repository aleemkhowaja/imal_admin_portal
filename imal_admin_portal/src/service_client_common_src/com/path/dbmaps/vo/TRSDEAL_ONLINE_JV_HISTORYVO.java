package com.path.dbmaps.vo;

import java.util.Date;

public class TRSDEAL_ONLINE_JV_HISTORYVO extends TRSDEAL_ONLINE_JV_HISTORYVOKey {
    /**
     * This field corresponds to the database column TRSDEAL_ONLINE_JV_HISTORY.DATE_CREATED
     */
    private Date DATE_CREATED;

    /**
     * This field corresponds to the database column TRSDEAL_ONLINE_JV_HISTORY.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column TRSDEAL_ONLINE_JV_HISTORY.SERVER_CREATED_DATE
     */
    private Date SERVER_CREATED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_ONLINE_JV_HISTORY.DATE_CREATED
     *
     * @return the value of TRSDEAL_ONLINE_JV_HISTORY.DATE_CREATED
     */
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_ONLINE_JV_HISTORY.DATE_CREATED
     *
     * @param DATE_CREATED the value for TRSDEAL_ONLINE_JV_HISTORY.DATE_CREATED
     */
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_ONLINE_JV_HISTORY.CREATED_BY
     *
     * @return the value of TRSDEAL_ONLINE_JV_HISTORY.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_ONLINE_JV_HISTORY.CREATED_BY
     *
     * @param CREATED_BY the value for TRSDEAL_ONLINE_JV_HISTORY.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_ONLINE_JV_HISTORY.SERVER_CREATED_DATE
     *
     * @return the value of TRSDEAL_ONLINE_JV_HISTORY.SERVER_CREATED_DATE
     */
    public Date getSERVER_CREATED_DATE() {
        return SERVER_CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_ONLINE_JV_HISTORY.SERVER_CREATED_DATE
     *
     * @param SERVER_CREATED_DATE the value for TRSDEAL_ONLINE_JV_HISTORY.SERVER_CREATED_DATE
     */
    public void setSERVER_CREATED_DATE(Date SERVER_CREATED_DATE) {
        this.SERVER_CREATED_DATE = SERVER_CREATED_DATE;
    }
}