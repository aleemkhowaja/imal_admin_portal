package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class TRS_SUB_PURPOSEVO extends TRS_SUB_PURPOSEVOKey {
    /**
     * This field corresponds to the database column TRS_SUB_PURPOSE.PURPOSE_CODE
     */
    private BigDecimal PURPOSE_CODE;

    /**
     * This field corresponds to the database column TRS_SUB_PURPOSE.BRIEF_DESC_ENG
     */
    private String BRIEF_DESC_ENG;

    /**
     * This field corresponds to the database column TRS_SUB_PURPOSE.LONG_DESC_ENG
     */
    private String LONG_DESC_ENG;

    /**
     * This field corresponds to the database column TRS_SUB_PURPOSE.BRIEF_DESC_ARAB
     */
    private String BRIEF_DESC_ARAB;

    /**
     * This field corresponds to the database column TRS_SUB_PURPOSE.LONG_DESC_ARAB
     */
    private String LONG_DESC_ARAB;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_SUB_PURPOSE.PURPOSE_CODE
     *
     * @return the value of TRS_SUB_PURPOSE.PURPOSE_CODE
     */
    public BigDecimal getPURPOSE_CODE() {
        return PURPOSE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_SUB_PURPOSE.PURPOSE_CODE
     *
     * @param PURPOSE_CODE the value for TRS_SUB_PURPOSE.PURPOSE_CODE
     */
    public void setPURPOSE_CODE(BigDecimal PURPOSE_CODE) {
        this.PURPOSE_CODE = PURPOSE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_SUB_PURPOSE.BRIEF_DESC_ENG
     *
     * @return the value of TRS_SUB_PURPOSE.BRIEF_DESC_ENG
     */
    public String getBRIEF_DESC_ENG() {
        return BRIEF_DESC_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_SUB_PURPOSE.BRIEF_DESC_ENG
     *
     * @param BRIEF_DESC_ENG the value for TRS_SUB_PURPOSE.BRIEF_DESC_ENG
     */
    public void setBRIEF_DESC_ENG(String BRIEF_DESC_ENG) {
        this.BRIEF_DESC_ENG = BRIEF_DESC_ENG == null ? null : BRIEF_DESC_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_SUB_PURPOSE.LONG_DESC_ENG
     *
     * @return the value of TRS_SUB_PURPOSE.LONG_DESC_ENG
     */
    public String getLONG_DESC_ENG() {
        return LONG_DESC_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_SUB_PURPOSE.LONG_DESC_ENG
     *
     * @param LONG_DESC_ENG the value for TRS_SUB_PURPOSE.LONG_DESC_ENG
     */
    public void setLONG_DESC_ENG(String LONG_DESC_ENG) {
        this.LONG_DESC_ENG = LONG_DESC_ENG == null ? null : LONG_DESC_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_SUB_PURPOSE.BRIEF_DESC_ARAB
     *
     * @return the value of TRS_SUB_PURPOSE.BRIEF_DESC_ARAB
     */
    public String getBRIEF_DESC_ARAB() {
        return BRIEF_DESC_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_SUB_PURPOSE.BRIEF_DESC_ARAB
     *
     * @param BRIEF_DESC_ARAB the value for TRS_SUB_PURPOSE.BRIEF_DESC_ARAB
     */
    public void setBRIEF_DESC_ARAB(String BRIEF_DESC_ARAB) {
        this.BRIEF_DESC_ARAB = BRIEF_DESC_ARAB == null ? null : BRIEF_DESC_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_SUB_PURPOSE.LONG_DESC_ARAB
     *
     * @return the value of TRS_SUB_PURPOSE.LONG_DESC_ARAB
     */
    public String getLONG_DESC_ARAB() {
        return LONG_DESC_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_SUB_PURPOSE.LONG_DESC_ARAB
     *
     * @param LONG_DESC_ARAB the value for TRS_SUB_PURPOSE.LONG_DESC_ARAB
     */
    public void setLONG_DESC_ARAB(String LONG_DESC_ARAB) {
        this.LONG_DESC_ARAB = LONG_DESC_ARAB == null ? null : LONG_DESC_ARAB.trim();
    }
}