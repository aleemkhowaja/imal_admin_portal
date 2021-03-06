package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRSDEALPFTDATEVO extends TRSDEALPFTDATEVOKey {
    /**
     * This field corresponds to the database column TRSDEALPFTDATE.PROFIT_DECLARATION_DATE
     */
    private Date PROFIT_DECLARATION_DATE;

    /**
     * This field corresponds to the database column TRSDEALPFTDATE.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column TRSDEALPFTDATE.PROFIT_DECLARATION_NBR
     */
    private BigDecimal PROFIT_DECLARATION_NBR;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEALPFTDATE.PROFIT_DECLARATION_DATE
     *
     * @return the value of TRSDEALPFTDATE.PROFIT_DECLARATION_DATE
     */
    public Date getPROFIT_DECLARATION_DATE() {
        return PROFIT_DECLARATION_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEALPFTDATE.PROFIT_DECLARATION_DATE
     *
     * @param PROFIT_DECLARATION_DATE the value for TRSDEALPFTDATE.PROFIT_DECLARATION_DATE
     */
    public void setPROFIT_DECLARATION_DATE(Date PROFIT_DECLARATION_DATE) {
        this.PROFIT_DECLARATION_DATE = PROFIT_DECLARATION_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEALPFTDATE.STATUS
     *
     * @return the value of TRSDEALPFTDATE.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEALPFTDATE.STATUS
     *
     * @param STATUS the value for TRSDEALPFTDATE.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEALPFTDATE.PROFIT_DECLARATION_NBR
     *
     * @return the value of TRSDEALPFTDATE.PROFIT_DECLARATION_NBR
     */
    public BigDecimal getPROFIT_DECLARATION_NBR() {
        return PROFIT_DECLARATION_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEALPFTDATE.PROFIT_DECLARATION_NBR
     *
     * @param PROFIT_DECLARATION_NBR the value for TRSDEALPFTDATE.PROFIT_DECLARATION_NBR
     */
    public void setPROFIT_DECLARATION_NBR(BigDecimal PROFIT_DECLARATION_NBR) {
        this.PROFIT_DECLARATION_NBR = PROFIT_DECLARATION_NBR;
    }
}