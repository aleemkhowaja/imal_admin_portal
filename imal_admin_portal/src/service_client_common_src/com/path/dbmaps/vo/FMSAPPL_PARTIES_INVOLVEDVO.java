package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class FMSAPPL_PARTIES_INVOLVEDVO extends FMSAPPL_PARTIES_INVOLVEDVOKey {
    /**
     * This field corresponds to the database column FMSAPPL_PARTIES_INVOLVED.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column FMSAPPL_PARTIES_INVOLVED.ROLE_CODE
     */
    private BigDecimal ROLE_CODE;

    /**
     * This field corresponds to the database column FMSAPPL_PARTIES_INVOLVED.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column FMSAPPL_PARTIES_INVOLVED.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column FMSAPPL_PARTIES_INVOLVED.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column FMSAPPL_PARTIES_INVOLVED.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_PARTIES_INVOLVED.CIF_NO
     *
     * @return the value of FMSAPPL_PARTIES_INVOLVED.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_PARTIES_INVOLVED.CIF_NO
     *
     * @param CIF_NO the value for FMSAPPL_PARTIES_INVOLVED.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_PARTIES_INVOLVED.ROLE_CODE
     *
     * @return the value of FMSAPPL_PARTIES_INVOLVED.ROLE_CODE
     */
    public BigDecimal getROLE_CODE() {
        return ROLE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_PARTIES_INVOLVED.ROLE_CODE
     *
     * @param ROLE_CODE the value for FMSAPPL_PARTIES_INVOLVED.ROLE_CODE
     */
    public void setROLE_CODE(BigDecimal ROLE_CODE) {
        this.ROLE_CODE = ROLE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_PARTIES_INVOLVED.CREATED_BY
     *
     * @return the value of FMSAPPL_PARTIES_INVOLVED.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_PARTIES_INVOLVED.CREATED_BY
     *
     * @param CREATED_BY the value for FMSAPPL_PARTIES_INVOLVED.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_PARTIES_INVOLVED.CREATED_DATE
     *
     * @return the value of FMSAPPL_PARTIES_INVOLVED.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_PARTIES_INVOLVED.CREATED_DATE
     *
     * @param CREATED_DATE the value for FMSAPPL_PARTIES_INVOLVED.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_PARTIES_INVOLVED.MODIFIED_BY
     *
     * @return the value of FMSAPPL_PARTIES_INVOLVED.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_PARTIES_INVOLVED.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for FMSAPPL_PARTIES_INVOLVED.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_PARTIES_INVOLVED.MODIFIED_DATE
     *
     * @return the value of FMSAPPL_PARTIES_INVOLVED.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_PARTIES_INVOLVED.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for FMSAPPL_PARTIES_INVOLVED.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }
}