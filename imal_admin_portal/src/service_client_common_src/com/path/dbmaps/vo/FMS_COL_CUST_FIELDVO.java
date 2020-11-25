package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class FMS_COL_CUST_FIELDVO extends FMS_COL_CUST_FIELDVOKey {
    /**
     * This field corresponds to the database column FMS_COL_CUST_FIELD.ALPHANUMERIC
     */
    private String ALPHANUMERIC;

    /**
     * This field corresponds to the database column FMS_COL_CUST_FIELD.NUMERIC_1
     */
    private BigDecimal NUMERIC_1;

    /**
     * This field corresponds to the database column FMS_COL_CUST_FIELD.DATE_1
     */
    private Date DATE_1;

    /**
     * This field corresponds to the database column FMS_COL_CUST_FIELD.LABEL
     */
    private String LABEL;

    /**
     * This field corresponds to the database column FMS_COL_CUST_FIELD.ORDER_NUMBER
     */
    private BigDecimal ORDER_NUMBER;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_COL_CUST_FIELD.ALPHANUMERIC
     *
     * @return the value of FMS_COL_CUST_FIELD.ALPHANUMERIC
     */
    public String getALPHANUMERIC() {
        return ALPHANUMERIC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_COL_CUST_FIELD.ALPHANUMERIC
     *
     * @param ALPHANUMERIC the value for FMS_COL_CUST_FIELD.ALPHANUMERIC
     */
    public void setALPHANUMERIC(String ALPHANUMERIC) {
        this.ALPHANUMERIC = ALPHANUMERIC == null ? null : ALPHANUMERIC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_COL_CUST_FIELD.NUMERIC_1
     *
     * @return the value of FMS_COL_CUST_FIELD.NUMERIC_1
     */
    public BigDecimal getNUMERIC_1() {
        return NUMERIC_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_COL_CUST_FIELD.NUMERIC_1
     *
     * @param NUMERIC_1 the value for FMS_COL_CUST_FIELD.NUMERIC_1
     */
    public void setNUMERIC_1(BigDecimal NUMERIC_1) {
        this.NUMERIC_1 = NUMERIC_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_COL_CUST_FIELD.DATE_1
     *
     * @return the value of FMS_COL_CUST_FIELD.DATE_1
     */
    public Date getDATE_1() {
        return DATE_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_COL_CUST_FIELD.DATE_1
     *
     * @param DATE_1 the value for FMS_COL_CUST_FIELD.DATE_1
     */
    public void setDATE_1(Date DATE_1) {
        this.DATE_1 = DATE_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_COL_CUST_FIELD.LABEL
     *
     * @return the value of FMS_COL_CUST_FIELD.LABEL
     */
    public String getLABEL() {
        return LABEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_COL_CUST_FIELD.LABEL
     *
     * @param LABEL the value for FMS_COL_CUST_FIELD.LABEL
     */
    public void setLABEL(String LABEL) {
        this.LABEL = LABEL == null ? null : LABEL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_COL_CUST_FIELD.ORDER_NUMBER
     *
     * @return the value of FMS_COL_CUST_FIELD.ORDER_NUMBER
     */
    public BigDecimal getORDER_NUMBER() {
        return ORDER_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_COL_CUST_FIELD.ORDER_NUMBER
     *
     * @param ORDER_NUMBER the value for FMS_COL_CUST_FIELD.ORDER_NUMBER
     */
    public void setORDER_NUMBER(BigDecimal ORDER_NUMBER) {
        this.ORDER_NUMBER = ORDER_NUMBER;
    }
}