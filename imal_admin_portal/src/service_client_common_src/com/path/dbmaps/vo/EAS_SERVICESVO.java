package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class EAS_SERVICESVO extends BaseVO {
    /**
     * This field corresponds to the database column EAS_SERVICES.SERVICE_NAME
     */
    private String SERVICE_NAME;

    /**
     * This field corresponds to the database column EAS_SERVICES.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column EAS_SERVICES.REFRESH_RATE
     */
    private BigDecimal REFRESH_RATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EAS_SERVICES.SERVICE_NAME
     *
     * @return the value of EAS_SERVICES.SERVICE_NAME
     */
    public String getSERVICE_NAME() {
        return SERVICE_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EAS_SERVICES.SERVICE_NAME
     *
     * @param SERVICE_NAME the value for EAS_SERVICES.SERVICE_NAME
     */
    public void setSERVICE_NAME(String SERVICE_NAME) {
        this.SERVICE_NAME = SERVICE_NAME == null ? null : SERVICE_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EAS_SERVICES.STATUS
     *
     * @return the value of EAS_SERVICES.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EAS_SERVICES.STATUS
     *
     * @param STATUS the value for EAS_SERVICES.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EAS_SERVICES.REFRESH_RATE
     *
     * @return the value of EAS_SERVICES.REFRESH_RATE
     */
    public BigDecimal getREFRESH_RATE() {
        return REFRESH_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EAS_SERVICES.REFRESH_RATE
     *
     * @param REFRESH_RATE the value for EAS_SERVICES.REFRESH_RATE
     */
    public void setREFRESH_RATE(BigDecimal REFRESH_RATE) {
        this.REFRESH_RATE = REFRESH_RATE;
    }
}