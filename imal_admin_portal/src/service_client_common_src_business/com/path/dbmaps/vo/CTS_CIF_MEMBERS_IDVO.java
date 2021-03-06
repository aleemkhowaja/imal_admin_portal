package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CTS_CIF_MEMBERS_IDVO extends CTS_CIF_MEMBERS_IDVOKey {
    /**
     * This field corresponds to the database column CTS_CIF_MEMBERS_ID.ID_TYPE
     */
    private BigDecimal ID_TYPE;

    /**
     * This field corresponds to the database column CTS_CIF_MEMBERS_ID.ID_NO
     */
    private String ID_NO;

    /**
     * This field corresponds to the database column CTS_CIF_MEMBERS_ID.COUNTRY_OF_ISSUANCE
     */
    private BigDecimal COUNTRY_OF_ISSUANCE;

    /**
     * This field corresponds to the database column CTS_CIF_MEMBERS_ID.ISSUANCE_DATE
     */
    private Date ISSUANCE_DATE;

    /**
     * This field corresponds to the database column CTS_CIF_MEMBERS_ID.EXPIRY_DATE
     */
    private Date EXPIRY_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_MEMBERS_ID.ID_TYPE
     *
     * @return the value of CTS_CIF_MEMBERS_ID.ID_TYPE
     */
    public BigDecimal getID_TYPE() {
        return ID_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_MEMBERS_ID.ID_TYPE
     *
     * @param ID_TYPE the value for CTS_CIF_MEMBERS_ID.ID_TYPE
     */
    public void setID_TYPE(BigDecimal ID_TYPE) {
        this.ID_TYPE = ID_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_MEMBERS_ID.ID_NO
     *
     * @return the value of CTS_CIF_MEMBERS_ID.ID_NO
     */
    public String getID_NO() {
        return ID_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_MEMBERS_ID.ID_NO
     *
     * @param ID_NO the value for CTS_CIF_MEMBERS_ID.ID_NO
     */
    public void setID_NO(String ID_NO) {
        this.ID_NO = ID_NO == null ? null : ID_NO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_MEMBERS_ID.COUNTRY_OF_ISSUANCE
     *
     * @return the value of CTS_CIF_MEMBERS_ID.COUNTRY_OF_ISSUANCE
     */
    public BigDecimal getCOUNTRY_OF_ISSUANCE() {
        return COUNTRY_OF_ISSUANCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_MEMBERS_ID.COUNTRY_OF_ISSUANCE
     *
     * @param COUNTRY_OF_ISSUANCE the value for CTS_CIF_MEMBERS_ID.COUNTRY_OF_ISSUANCE
     */
    public void setCOUNTRY_OF_ISSUANCE(BigDecimal COUNTRY_OF_ISSUANCE) {
        this.COUNTRY_OF_ISSUANCE = COUNTRY_OF_ISSUANCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_MEMBERS_ID.ISSUANCE_DATE
     *
     * @return the value of CTS_CIF_MEMBERS_ID.ISSUANCE_DATE
     */
    public Date getISSUANCE_DATE() {
        return ISSUANCE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_MEMBERS_ID.ISSUANCE_DATE
     *
     * @param ISSUANCE_DATE the value for CTS_CIF_MEMBERS_ID.ISSUANCE_DATE
     */
    public void setISSUANCE_DATE(Date ISSUANCE_DATE) {
        this.ISSUANCE_DATE = ISSUANCE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_MEMBERS_ID.EXPIRY_DATE
     *
     * @return the value of CTS_CIF_MEMBERS_ID.EXPIRY_DATE
     */
    public Date getEXPIRY_DATE() {
        return EXPIRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_MEMBERS_ID.EXPIRY_DATE
     *
     * @param EXPIRY_DATE the value for CTS_CIF_MEMBERS_ID.EXPIRY_DATE
     */
    public void setEXPIRY_DATE(Date EXPIRY_DATE) {
        this.EXPIRY_DATE = EXPIRY_DATE;
    }
}