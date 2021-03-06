package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class TRSDEAL_STLMT_APTNMTVO extends TRSDEAL_STLMT_APTNMTVOKey {
    /**
     * This field corresponds to the database column TRSDEAL_STLMT_APTNMT.APPORTIONMENT_IND
     */
    private BigDecimal APPORTIONMENT_IND;

    /**
     * This field corresponds to the database column TRSDEAL_STLMT_APTNMT.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column TRSDEAL_STLMT_APTNMT.CHARGE_CODE
     */
    private BigDecimal CHARGE_CODE;

    /**
     * This field corresponds to the database column TRSDEAL_STLMT_APTNMT.DUE_TYPE_ORDER
     */
    private BigDecimal DUE_TYPE_ORDER;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_STLMT_APTNMT.APPORTIONMENT_IND
     *
     * @return the value of TRSDEAL_STLMT_APTNMT.APPORTIONMENT_IND
     */
    public BigDecimal getAPPORTIONMENT_IND() {
        return APPORTIONMENT_IND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_STLMT_APTNMT.APPORTIONMENT_IND
     *
     * @param APPORTIONMENT_IND the value for TRSDEAL_STLMT_APTNMT.APPORTIONMENT_IND
     */
    public void setAPPORTIONMENT_IND(BigDecimal APPORTIONMENT_IND) {
        this.APPORTIONMENT_IND = APPORTIONMENT_IND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_STLMT_APTNMT.STATUS
     *
     * @return the value of TRSDEAL_STLMT_APTNMT.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_STLMT_APTNMT.STATUS
     *
     * @param STATUS the value for TRSDEAL_STLMT_APTNMT.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_STLMT_APTNMT.CHARGE_CODE
     *
     * @return the value of TRSDEAL_STLMT_APTNMT.CHARGE_CODE
     */
    public BigDecimal getCHARGE_CODE() {
        return CHARGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_STLMT_APTNMT.CHARGE_CODE
     *
     * @param CHARGE_CODE the value for TRSDEAL_STLMT_APTNMT.CHARGE_CODE
     */
    public void setCHARGE_CODE(BigDecimal CHARGE_CODE) {
        this.CHARGE_CODE = CHARGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEAL_STLMT_APTNMT.DUE_TYPE_ORDER
     *
     * @return the value of TRSDEAL_STLMT_APTNMT.DUE_TYPE_ORDER
     */
    public BigDecimal getDUE_TYPE_ORDER() {
        return DUE_TYPE_ORDER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEAL_STLMT_APTNMT.DUE_TYPE_ORDER
     *
     * @param DUE_TYPE_ORDER the value for TRSDEAL_STLMT_APTNMT.DUE_TYPE_ORDER
     */
    public void setDUE_TYPE_ORDER(BigDecimal DUE_TYPE_ORDER) {
        this.DUE_TYPE_ORDER = DUE_TYPE_ORDER;
    }
}