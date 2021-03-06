package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class FMSAPPLDOCUMENTSVO extends FMSAPPLDOCUMENTSVOKey {
    /**
     * This field corresponds to the database column FMSAPPLDOCUMENTS.LINE_NBR
     */
    private BigDecimal LINE_NBR;

    /**
     * This field corresponds to the database column FMSAPPLDOCUMENTS.EST_DATE_SENT
     */
    private Date EST_DATE_SENT;

    /**
     * This field corresponds to the database column FMSAPPLDOCUMENTS.EST_DATE_REC
     */
    private Date EST_DATE_REC;

    /**
     * This field corresponds to the database column FMSAPPLDOCUMENTS.SOL_DATE_SENT
     */
    private Date SOL_DATE_SENT;

    /**
     * This field corresponds to the database column FMSAPPLDOCUMENTS.SOL_DATE_REC
     */
    private Date SOL_DATE_REC;

    /**
     * This field corresponds to the database column FMSAPPLDOCUMENTS.CUSTODIAN_SENT
     */
    private Date CUSTODIAN_SENT;

    /**
     * This field corresponds to the database column FMSAPPLDOCUMENTS.MANDATORY
     */
    private String MANDATORY;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLDOCUMENTS.LINE_NBR
     *
     * @return the value of FMSAPPLDOCUMENTS.LINE_NBR
     */
    public BigDecimal getLINE_NBR() {
        return LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLDOCUMENTS.LINE_NBR
     *
     * @param LINE_NBR the value for FMSAPPLDOCUMENTS.LINE_NBR
     */
    public void setLINE_NBR(BigDecimal LINE_NBR) {
        this.LINE_NBR = LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLDOCUMENTS.EST_DATE_SENT
     *
     * @return the value of FMSAPPLDOCUMENTS.EST_DATE_SENT
     */
    public Date getEST_DATE_SENT() {
        return EST_DATE_SENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLDOCUMENTS.EST_DATE_SENT
     *
     * @param EST_DATE_SENT the value for FMSAPPLDOCUMENTS.EST_DATE_SENT
     */
    public void setEST_DATE_SENT(Date EST_DATE_SENT) {
        this.EST_DATE_SENT = EST_DATE_SENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLDOCUMENTS.EST_DATE_REC
     *
     * @return the value of FMSAPPLDOCUMENTS.EST_DATE_REC
     */
    public Date getEST_DATE_REC() {
        return EST_DATE_REC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLDOCUMENTS.EST_DATE_REC
     *
     * @param EST_DATE_REC the value for FMSAPPLDOCUMENTS.EST_DATE_REC
     */
    public void setEST_DATE_REC(Date EST_DATE_REC) {
        this.EST_DATE_REC = EST_DATE_REC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLDOCUMENTS.SOL_DATE_SENT
     *
     * @return the value of FMSAPPLDOCUMENTS.SOL_DATE_SENT
     */
    public Date getSOL_DATE_SENT() {
        return SOL_DATE_SENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLDOCUMENTS.SOL_DATE_SENT
     *
     * @param SOL_DATE_SENT the value for FMSAPPLDOCUMENTS.SOL_DATE_SENT
     */
    public void setSOL_DATE_SENT(Date SOL_DATE_SENT) {
        this.SOL_DATE_SENT = SOL_DATE_SENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLDOCUMENTS.SOL_DATE_REC
     *
     * @return the value of FMSAPPLDOCUMENTS.SOL_DATE_REC
     */
    public Date getSOL_DATE_REC() {
        return SOL_DATE_REC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLDOCUMENTS.SOL_DATE_REC
     *
     * @param SOL_DATE_REC the value for FMSAPPLDOCUMENTS.SOL_DATE_REC
     */
    public void setSOL_DATE_REC(Date SOL_DATE_REC) {
        this.SOL_DATE_REC = SOL_DATE_REC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLDOCUMENTS.CUSTODIAN_SENT
     *
     * @return the value of FMSAPPLDOCUMENTS.CUSTODIAN_SENT
     */
    public Date getCUSTODIAN_SENT() {
        return CUSTODIAN_SENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLDOCUMENTS.CUSTODIAN_SENT
     *
     * @param CUSTODIAN_SENT the value for FMSAPPLDOCUMENTS.CUSTODIAN_SENT
     */
    public void setCUSTODIAN_SENT(Date CUSTODIAN_SENT) {
        this.CUSTODIAN_SENT = CUSTODIAN_SENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLDOCUMENTS.MANDATORY
     *
     * @return the value of FMSAPPLDOCUMENTS.MANDATORY
     */
    public String getMANDATORY() {
        return MANDATORY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLDOCUMENTS.MANDATORY
     *
     * @param MANDATORY the value for FMSAPPLDOCUMENTS.MANDATORY
     */
    public void setMANDATORY(String MANDATORY) {
        this.MANDATORY = MANDATORY == null ? null : MANDATORY.trim();
    }
}