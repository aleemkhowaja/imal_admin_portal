package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRSDEALLINK_IRSVO extends TRSDEALLINK_IRSVOKey {
    /**
     * This field corresponds to the database column TRSDEALLINK_IRS.DEAL_CY
     */
    private BigDecimal DEAL_CY;

    /**
     * This field corresponds to the database column TRSDEALLINK_IRS.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column TRSDEALLINK_IRS.IRS_TYPE
     */
    private String IRS_TYPE;

    /**
     * This field corresponds to the database column TRSDEALLINK_IRS.DEAL_STATUS
     */
    private String DEAL_STATUS;

    /**
     * This field corresponds to the database column TRSDEALLINK_IRS.CLOSED_DATE
     */
    private Date CLOSED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEALLINK_IRS.DEAL_CY
     *
     * @return the value of TRSDEALLINK_IRS.DEAL_CY
     */
    public BigDecimal getDEAL_CY() {
        return DEAL_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEALLINK_IRS.DEAL_CY
     *
     * @param DEAL_CY the value for TRSDEALLINK_IRS.DEAL_CY
     */
    public void setDEAL_CY(BigDecimal DEAL_CY) {
        this.DEAL_CY = DEAL_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEALLINK_IRS.CIF_NO
     *
     * @return the value of TRSDEALLINK_IRS.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEALLINK_IRS.CIF_NO
     *
     * @param CIF_NO the value for TRSDEALLINK_IRS.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEALLINK_IRS.IRS_TYPE
     *
     * @return the value of TRSDEALLINK_IRS.IRS_TYPE
     */
    public String getIRS_TYPE() {
        return IRS_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEALLINK_IRS.IRS_TYPE
     *
     * @param IRS_TYPE the value for TRSDEALLINK_IRS.IRS_TYPE
     */
    public void setIRS_TYPE(String IRS_TYPE) {
        this.IRS_TYPE = IRS_TYPE == null ? null : IRS_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEALLINK_IRS.DEAL_STATUS
     *
     * @return the value of TRSDEALLINK_IRS.DEAL_STATUS
     */
    public String getDEAL_STATUS() {
        return DEAL_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEALLINK_IRS.DEAL_STATUS
     *
     * @param DEAL_STATUS the value for TRSDEALLINK_IRS.DEAL_STATUS
     */
    public void setDEAL_STATUS(String DEAL_STATUS) {
        this.DEAL_STATUS = DEAL_STATUS == null ? null : DEAL_STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEALLINK_IRS.CLOSED_DATE
     *
     * @return the value of TRSDEALLINK_IRS.CLOSED_DATE
     */
    public Date getCLOSED_DATE() {
        return CLOSED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEALLINK_IRS.CLOSED_DATE
     *
     * @param CLOSED_DATE the value for TRSDEALLINK_IRS.CLOSED_DATE
     */
    public void setCLOSED_DATE(Date CLOSED_DATE) {
        this.CLOSED_DATE = CLOSED_DATE;
    }
}