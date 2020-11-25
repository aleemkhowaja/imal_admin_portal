package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class FMSAPPDOCDET_HISTORYVO extends FMSAPPDOCDET_HISTORYVOKey {
    /**
     * This field corresponds to the database column FMSAPPDOCDET_HISTORY.DOC_TYPE
     */
    private String DOC_TYPE;

    /**
     * This field corresponds to the database column FMSAPPDOCDET_HISTORY.DOC_AMOUNT
     */
    private BigDecimal DOC_AMOUNT;

    /**
     * This field corresponds to the database column FMSAPPDOCDET_HISTORY.DOC_DATE
     */
    private Date DOC_DATE;

    /**
     * This field corresponds to the database column FMSAPPDOCDET_HISTORY.DOC_EXPIRY_DATE
     */
    private Date DOC_EXPIRY_DATE;

    /**
     * This field corresponds to the database column FMSAPPDOCDET_HISTORY.FROM_DATE
     */
    private Date FROM_DATE;

    /**
     * This field corresponds to the database column FMSAPPDOCDET_HISTORY.TO_DATE
     */
    private Date TO_DATE;

    /**
     * This field corresponds to the database column FMSAPPDOCDET_HISTORY.UPLOAD_DATE_TIME
     */
    private Date UPLOAD_DATE_TIME;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPDOCDET_HISTORY.DOC_TYPE
     *
     * @return the value of FMSAPPDOCDET_HISTORY.DOC_TYPE
     */
    public String getDOC_TYPE() {
        return DOC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPDOCDET_HISTORY.DOC_TYPE
     *
     * @param DOC_TYPE the value for FMSAPPDOCDET_HISTORY.DOC_TYPE
     */
    public void setDOC_TYPE(String DOC_TYPE) {
        this.DOC_TYPE = DOC_TYPE == null ? null : DOC_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPDOCDET_HISTORY.DOC_AMOUNT
     *
     * @return the value of FMSAPPDOCDET_HISTORY.DOC_AMOUNT
     */
    public BigDecimal getDOC_AMOUNT() {
        return DOC_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPDOCDET_HISTORY.DOC_AMOUNT
     *
     * @param DOC_AMOUNT the value for FMSAPPDOCDET_HISTORY.DOC_AMOUNT
     */
    public void setDOC_AMOUNT(BigDecimal DOC_AMOUNT) {
        this.DOC_AMOUNT = DOC_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPDOCDET_HISTORY.DOC_DATE
     *
     * @return the value of FMSAPPDOCDET_HISTORY.DOC_DATE
     */
    public Date getDOC_DATE() {
        return DOC_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPDOCDET_HISTORY.DOC_DATE
     *
     * @param DOC_DATE the value for FMSAPPDOCDET_HISTORY.DOC_DATE
     */
    public void setDOC_DATE(Date DOC_DATE) {
        this.DOC_DATE = DOC_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPDOCDET_HISTORY.DOC_EXPIRY_DATE
     *
     * @return the value of FMSAPPDOCDET_HISTORY.DOC_EXPIRY_DATE
     */
    public Date getDOC_EXPIRY_DATE() {
        return DOC_EXPIRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPDOCDET_HISTORY.DOC_EXPIRY_DATE
     *
     * @param DOC_EXPIRY_DATE the value for FMSAPPDOCDET_HISTORY.DOC_EXPIRY_DATE
     */
    public void setDOC_EXPIRY_DATE(Date DOC_EXPIRY_DATE) {
        this.DOC_EXPIRY_DATE = DOC_EXPIRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPDOCDET_HISTORY.FROM_DATE
     *
     * @return the value of FMSAPPDOCDET_HISTORY.FROM_DATE
     */
    public Date getFROM_DATE() {
        return FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPDOCDET_HISTORY.FROM_DATE
     *
     * @param FROM_DATE the value for FMSAPPDOCDET_HISTORY.FROM_DATE
     */
    public void setFROM_DATE(Date FROM_DATE) {
        this.FROM_DATE = FROM_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPDOCDET_HISTORY.TO_DATE
     *
     * @return the value of FMSAPPDOCDET_HISTORY.TO_DATE
     */
    public Date getTO_DATE() {
        return TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPDOCDET_HISTORY.TO_DATE
     *
     * @param TO_DATE the value for FMSAPPDOCDET_HISTORY.TO_DATE
     */
    public void setTO_DATE(Date TO_DATE) {
        this.TO_DATE = TO_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPDOCDET_HISTORY.UPLOAD_DATE_TIME
     *
     * @return the value of FMSAPPDOCDET_HISTORY.UPLOAD_DATE_TIME
     */
    public Date getUPLOAD_DATE_TIME() {
        return UPLOAD_DATE_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPDOCDET_HISTORY.UPLOAD_DATE_TIME
     *
     * @param UPLOAD_DATE_TIME the value for FMSAPPDOCDET_HISTORY.UPLOAD_DATE_TIME
     */
    public void setUPLOAD_DATE_TIME(Date UPLOAD_DATE_TIME) {
        this.UPLOAD_DATE_TIME = UPLOAD_DATE_TIME;
    }
}