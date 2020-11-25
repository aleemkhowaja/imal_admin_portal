package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SIRON_PD_BIRTHDATEVO extends BaseVO {
    /**
     * This field corresponds to the database column SIRON_PD_BIRTHDATE.LINE
     */
    private BigDecimal LINE;

    /**
     * This field corresponds to the database column SIRON_PD_BIRTHDATE.BIRTHDATE
     */
    private String BIRTHDATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SIRON_PD_BIRTHDATE.LINE
     *
     * @return the value of SIRON_PD_BIRTHDATE.LINE
     */
    public BigDecimal getLINE() {
        return LINE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SIRON_PD_BIRTHDATE.LINE
     *
     * @param LINE the value for SIRON_PD_BIRTHDATE.LINE
     */
    public void setLINE(BigDecimal LINE) {
        this.LINE = LINE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SIRON_PD_BIRTHDATE.BIRTHDATE
     *
     * @return the value of SIRON_PD_BIRTHDATE.BIRTHDATE
     */
    public String getBIRTHDATE() {
        return BIRTHDATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SIRON_PD_BIRTHDATE.BIRTHDATE
     *
     * @param BIRTHDATE the value for SIRON_PD_BIRTHDATE.BIRTHDATE
     */
    public void setBIRTHDATE(String BIRTHDATE) {
        this.BIRTHDATE = BIRTHDATE == null ? null : BIRTHDATE.trim();
    }
}