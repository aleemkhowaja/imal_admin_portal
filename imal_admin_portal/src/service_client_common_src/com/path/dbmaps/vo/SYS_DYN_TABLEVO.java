package com.path.dbmaps.vo;

import java.util.Date;

public class SYS_DYN_TABLEVO extends SYS_DYN_TABLEVOKey {
    /**
     * This field corresponds to the database column SYS_DYN_TABLE.TABLE_TECH_NAME
     */
    private String TABLE_TECH_NAME;

    /**
     * This field corresponds to the database column SYS_DYN_TABLE.TABLE_DESC
     */
    private String TABLE_DESC;

    /**
     * This field corresponds to the database column SYS_DYN_TABLE.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column SYS_DYN_TABLE.CREATION_DATE
     */
    private Date CREATION_DATE;

    /**
     * This field corresponds to the database column SYS_DYN_TABLE.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column SYS_DYN_TABLE.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_TABLE.TABLE_TECH_NAME
     *
     * @return the value of SYS_DYN_TABLE.TABLE_TECH_NAME
     */
    public String getTABLE_TECH_NAME() {
        return TABLE_TECH_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_TABLE.TABLE_TECH_NAME
     *
     * @param TABLE_TECH_NAME the value for SYS_DYN_TABLE.TABLE_TECH_NAME
     */
    public void setTABLE_TECH_NAME(String TABLE_TECH_NAME) {
        this.TABLE_TECH_NAME = TABLE_TECH_NAME == null ? null : TABLE_TECH_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_TABLE.TABLE_DESC
     *
     * @return the value of SYS_DYN_TABLE.TABLE_DESC
     */
    public String getTABLE_DESC() {
        return TABLE_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_TABLE.TABLE_DESC
     *
     * @param TABLE_DESC the value for SYS_DYN_TABLE.TABLE_DESC
     */
    public void setTABLE_DESC(String TABLE_DESC) {
        this.TABLE_DESC = TABLE_DESC == null ? null : TABLE_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_TABLE.CREATED_BY
     *
     * @return the value of SYS_DYN_TABLE.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_TABLE.CREATED_BY
     *
     * @param CREATED_BY the value for SYS_DYN_TABLE.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_TABLE.CREATION_DATE
     *
     * @return the value of SYS_DYN_TABLE.CREATION_DATE
     */
    public Date getCREATION_DATE() {
        return CREATION_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_TABLE.CREATION_DATE
     *
     * @param CREATION_DATE the value for SYS_DYN_TABLE.CREATION_DATE
     */
    public void setCREATION_DATE(Date CREATION_DATE) {
        this.CREATION_DATE = CREATION_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_TABLE.MODIFIED_BY
     *
     * @return the value of SYS_DYN_TABLE.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_TABLE.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for SYS_DYN_TABLE.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_DYN_TABLE.MODIFIED_DATE
     *
     * @return the value of SYS_DYN_TABLE.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_DYN_TABLE.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for SYS_DYN_TABLE.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }
}