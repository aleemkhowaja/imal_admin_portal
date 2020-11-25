package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class POSTAL_CODEVO extends POSTAL_CODEVOKey {
    /**
     * This field corresponds to the database column POSTAL_CODE.BRIEF_NAME_ENG
     */
    private String BRIEF_NAME_ENG;

    /**
     * This field corresponds to the database column POSTAL_CODE.LONG_NAME_ENG
     */
    private String LONG_NAME_ENG;

    /**
     * This field corresponds to the database column POSTAL_CODE.BRIEF_NAME_ARAB
     */
    private String BRIEF_NAME_ARAB;

    /**
     * This field corresponds to the database column POSTAL_CODE.LONG_NAME_ARAB
     */
    private String LONG_NAME_ARAB;

    /**
     * This field corresponds to the database column POSTAL_CODE.ADDITIONAL_REFERENCE
     */
    private String ADDITIONAL_REFERENCE;

    /**
     * This field corresponds to the database column POSTAL_CODE.FETCH_KEY
     */
    private String FETCH_KEY;

    /**
     * This field corresponds to the database column POSTAL_CODE.COUNTRY_CODE
     */
    private BigDecimal COUNTRY_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSTAL_CODE.BRIEF_NAME_ENG
     *
     * @return the value of POSTAL_CODE.BRIEF_NAME_ENG
     */
    public String getBRIEF_NAME_ENG() {
        return BRIEF_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSTAL_CODE.BRIEF_NAME_ENG
     *
     * @param BRIEF_NAME_ENG the value for POSTAL_CODE.BRIEF_NAME_ENG
     */
    public void setBRIEF_NAME_ENG(String BRIEF_NAME_ENG) {
        this.BRIEF_NAME_ENG = BRIEF_NAME_ENG == null ? null : BRIEF_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSTAL_CODE.LONG_NAME_ENG
     *
     * @return the value of POSTAL_CODE.LONG_NAME_ENG
     */
    public String getLONG_NAME_ENG() {
        return LONG_NAME_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSTAL_CODE.LONG_NAME_ENG
     *
     * @param LONG_NAME_ENG the value for POSTAL_CODE.LONG_NAME_ENG
     */
    public void setLONG_NAME_ENG(String LONG_NAME_ENG) {
        this.LONG_NAME_ENG = LONG_NAME_ENG == null ? null : LONG_NAME_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSTAL_CODE.BRIEF_NAME_ARAB
     *
     * @return the value of POSTAL_CODE.BRIEF_NAME_ARAB
     */
    public String getBRIEF_NAME_ARAB() {
        return BRIEF_NAME_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSTAL_CODE.BRIEF_NAME_ARAB
     *
     * @param BRIEF_NAME_ARAB the value for POSTAL_CODE.BRIEF_NAME_ARAB
     */
    public void setBRIEF_NAME_ARAB(String BRIEF_NAME_ARAB) {
        this.BRIEF_NAME_ARAB = BRIEF_NAME_ARAB == null ? null : BRIEF_NAME_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSTAL_CODE.LONG_NAME_ARAB
     *
     * @return the value of POSTAL_CODE.LONG_NAME_ARAB
     */
    public String getLONG_NAME_ARAB() {
        return LONG_NAME_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSTAL_CODE.LONG_NAME_ARAB
     *
     * @param LONG_NAME_ARAB the value for POSTAL_CODE.LONG_NAME_ARAB
     */
    public void setLONG_NAME_ARAB(String LONG_NAME_ARAB) {
        this.LONG_NAME_ARAB = LONG_NAME_ARAB == null ? null : LONG_NAME_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSTAL_CODE.ADDITIONAL_REFERENCE
     *
     * @return the value of POSTAL_CODE.ADDITIONAL_REFERENCE
     */
    public String getADDITIONAL_REFERENCE() {
        return ADDITIONAL_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSTAL_CODE.ADDITIONAL_REFERENCE
     *
     * @param ADDITIONAL_REFERENCE the value for POSTAL_CODE.ADDITIONAL_REFERENCE
     */
    public void setADDITIONAL_REFERENCE(String ADDITIONAL_REFERENCE) {
        this.ADDITIONAL_REFERENCE = ADDITIONAL_REFERENCE == null ? null : ADDITIONAL_REFERENCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSTAL_CODE.FETCH_KEY
     *
     * @return the value of POSTAL_CODE.FETCH_KEY
     */
    public String getFETCH_KEY() {
        return FETCH_KEY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSTAL_CODE.FETCH_KEY
     *
     * @param FETCH_KEY the value for POSTAL_CODE.FETCH_KEY
     */
    public void setFETCH_KEY(String FETCH_KEY) {
        this.FETCH_KEY = FETCH_KEY == null ? null : FETCH_KEY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSTAL_CODE.COUNTRY_CODE
     *
     * @return the value of POSTAL_CODE.COUNTRY_CODE
     */
    public BigDecimal getCOUNTRY_CODE() {
        return COUNTRY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSTAL_CODE.COUNTRY_CODE
     *
     * @param COUNTRY_CODE the value for POSTAL_CODE.COUNTRY_CODE
     */
    public void setCOUNTRY_CODE(BigDecimal COUNTRY_CODE) {
        this.COUNTRY_CODE = COUNTRY_CODE;
    }
}