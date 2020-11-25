package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class IBOR_HDRVO extends IBOR_HDRVOKey {
    /**
     * This field corresponds to the database column IBOR_HDR.BRIEF_DESC_ENG
     */
    private String BRIEF_DESC_ENG;

    /**
     * This field corresponds to the database column IBOR_HDR.BRIEF_DESC_ARAB
     */
    private String BRIEF_DESC_ARAB;

    /**
     * This field corresponds to the database column IBOR_HDR.LONG_DESC_ENG
     */
    private String LONG_DESC_ENG;

    /**
     * This field corresponds to the database column IBOR_HDR.PERIODICITY_TYPE
     */
    private String PERIODICITY_TYPE;

    /**
     * This field corresponds to the database column IBOR_HDR.PERIODICITY_NUMBER
     */
    private BigDecimal PERIODICITY_NUMBER;

    /**
     * This field corresponds to the database column IBOR_HDR.DESCRIPTION
     */
    private String DESCRIPTION;

    /**
     * This field corresponds to the database column IBOR_HDR.APPLY_RESTRICTION
     */
    private String APPLY_RESTRICTION;

    /**
     * This field corresponds to the database column IBOR_HDR.LONG_DESC_ARAB
     */
    private String LONG_DESC_ARAB;

    /**
     * This field corresponds to the database column IBOR_HDR.NEXT_RATEDATE
     */
    private Date NEXT_RATEDATE;

    /**
     * This field corresponds to the database column IBOR_HDR.ADDITIONAL_REFERENCE
     */
    private String ADDITIONAL_REFERENCE;

    /**
     * This field corresponds to the database column IBOR_HDR.RATE_REVAL_INCL_AUTOMATION_YN
     */
    private String RATE_REVAL_INCL_AUTOMATION_YN;

    /**
     * This field corresponds to the database column IBOR_HDR.FROM_AMOUNT
     */
    private BigDecimal FROM_AMOUNT;

    /**
     * This field corresponds to the database column IBOR_HDR.TO_AMOUNT
     */
    private BigDecimal TO_AMOUNT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.BRIEF_DESC_ENG
     *
     * @return the value of IBOR_HDR.BRIEF_DESC_ENG
     */
    public String getBRIEF_DESC_ENG() {
        return BRIEF_DESC_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.BRIEF_DESC_ENG
     *
     * @param BRIEF_DESC_ENG the value for IBOR_HDR.BRIEF_DESC_ENG
     */
    public void setBRIEF_DESC_ENG(String BRIEF_DESC_ENG) {
        this.BRIEF_DESC_ENG = BRIEF_DESC_ENG == null ? null : BRIEF_DESC_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.BRIEF_DESC_ARAB
     *
     * @return the value of IBOR_HDR.BRIEF_DESC_ARAB
     */
    public String getBRIEF_DESC_ARAB() {
        return BRIEF_DESC_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.BRIEF_DESC_ARAB
     *
     * @param BRIEF_DESC_ARAB the value for IBOR_HDR.BRIEF_DESC_ARAB
     */
    public void setBRIEF_DESC_ARAB(String BRIEF_DESC_ARAB) {
        this.BRIEF_DESC_ARAB = BRIEF_DESC_ARAB == null ? null : BRIEF_DESC_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.LONG_DESC_ENG
     *
     * @return the value of IBOR_HDR.LONG_DESC_ENG
     */
    public String getLONG_DESC_ENG() {
        return LONG_DESC_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.LONG_DESC_ENG
     *
     * @param LONG_DESC_ENG the value for IBOR_HDR.LONG_DESC_ENG
     */
    public void setLONG_DESC_ENG(String LONG_DESC_ENG) {
        this.LONG_DESC_ENG = LONG_DESC_ENG == null ? null : LONG_DESC_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.PERIODICITY_TYPE
     *
     * @return the value of IBOR_HDR.PERIODICITY_TYPE
     */
    public String getPERIODICITY_TYPE() {
        return PERIODICITY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.PERIODICITY_TYPE
     *
     * @param PERIODICITY_TYPE the value for IBOR_HDR.PERIODICITY_TYPE
     */
    public void setPERIODICITY_TYPE(String PERIODICITY_TYPE) {
        this.PERIODICITY_TYPE = PERIODICITY_TYPE == null ? null : PERIODICITY_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.PERIODICITY_NUMBER
     *
     * @return the value of IBOR_HDR.PERIODICITY_NUMBER
     */
    public BigDecimal getPERIODICITY_NUMBER() {
        return PERIODICITY_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.PERIODICITY_NUMBER
     *
     * @param PERIODICITY_NUMBER the value for IBOR_HDR.PERIODICITY_NUMBER
     */
    public void setPERIODICITY_NUMBER(BigDecimal PERIODICITY_NUMBER) {
        this.PERIODICITY_NUMBER = PERIODICITY_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.DESCRIPTION
     *
     * @return the value of IBOR_HDR.DESCRIPTION
     */
    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.DESCRIPTION
     *
     * @param DESCRIPTION the value for IBOR_HDR.DESCRIPTION
     */
    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.APPLY_RESTRICTION
     *
     * @return the value of IBOR_HDR.APPLY_RESTRICTION
     */
    public String getAPPLY_RESTRICTION() {
        return APPLY_RESTRICTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.APPLY_RESTRICTION
     *
     * @param APPLY_RESTRICTION the value for IBOR_HDR.APPLY_RESTRICTION
     */
    public void setAPPLY_RESTRICTION(String APPLY_RESTRICTION) {
        this.APPLY_RESTRICTION = APPLY_RESTRICTION == null ? null : APPLY_RESTRICTION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.LONG_DESC_ARAB
     *
     * @return the value of IBOR_HDR.LONG_DESC_ARAB
     */
    public String getLONG_DESC_ARAB() {
        return LONG_DESC_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.LONG_DESC_ARAB
     *
     * @param LONG_DESC_ARAB the value for IBOR_HDR.LONG_DESC_ARAB
     */
    public void setLONG_DESC_ARAB(String LONG_DESC_ARAB) {
        this.LONG_DESC_ARAB = LONG_DESC_ARAB == null ? null : LONG_DESC_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.NEXT_RATEDATE
     *
     * @return the value of IBOR_HDR.NEXT_RATEDATE
     */
    public Date getNEXT_RATEDATE() {
        return NEXT_RATEDATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.NEXT_RATEDATE
     *
     * @param NEXT_RATEDATE the value for IBOR_HDR.NEXT_RATEDATE
     */
    public void setNEXT_RATEDATE(Date NEXT_RATEDATE) {
        this.NEXT_RATEDATE = NEXT_RATEDATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.ADDITIONAL_REFERENCE
     *
     * @return the value of IBOR_HDR.ADDITIONAL_REFERENCE
     */
    public String getADDITIONAL_REFERENCE() {
        return ADDITIONAL_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.ADDITIONAL_REFERENCE
     *
     * @param ADDITIONAL_REFERENCE the value for IBOR_HDR.ADDITIONAL_REFERENCE
     */
    public void setADDITIONAL_REFERENCE(String ADDITIONAL_REFERENCE) {
        this.ADDITIONAL_REFERENCE = ADDITIONAL_REFERENCE == null ? null : ADDITIONAL_REFERENCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.RATE_REVAL_INCL_AUTOMATION_YN
     *
     * @return the value of IBOR_HDR.RATE_REVAL_INCL_AUTOMATION_YN
     */
    public String getRATE_REVAL_INCL_AUTOMATION_YN() {
        return RATE_REVAL_INCL_AUTOMATION_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.RATE_REVAL_INCL_AUTOMATION_YN
     *
     * @param RATE_REVAL_INCL_AUTOMATION_YN the value for IBOR_HDR.RATE_REVAL_INCL_AUTOMATION_YN
     */
    public void setRATE_REVAL_INCL_AUTOMATION_YN(String RATE_REVAL_INCL_AUTOMATION_YN) {
        this.RATE_REVAL_INCL_AUTOMATION_YN = RATE_REVAL_INCL_AUTOMATION_YN == null ? null : RATE_REVAL_INCL_AUTOMATION_YN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.FROM_AMOUNT
     *
     * @return the value of IBOR_HDR.FROM_AMOUNT
     */
    public BigDecimal getFROM_AMOUNT() {
        return FROM_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.FROM_AMOUNT
     *
     * @param FROM_AMOUNT the value for IBOR_HDR.FROM_AMOUNT
     */
    public void setFROM_AMOUNT(BigDecimal FROM_AMOUNT) {
        this.FROM_AMOUNT = FROM_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IBOR_HDR.TO_AMOUNT
     *
     * @return the value of IBOR_HDR.TO_AMOUNT
     */
    public BigDecimal getTO_AMOUNT() {
        return TO_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IBOR_HDR.TO_AMOUNT
     *
     * @param TO_AMOUNT the value for IBOR_HDR.TO_AMOUNT
     */
    public void setTO_AMOUNT(BigDecimal TO_AMOUNT) {
        this.TO_AMOUNT = TO_AMOUNT;
    }
}