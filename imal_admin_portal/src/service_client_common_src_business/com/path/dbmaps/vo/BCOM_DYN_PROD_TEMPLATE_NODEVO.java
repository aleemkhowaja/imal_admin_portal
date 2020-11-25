package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class BCOM_DYN_PROD_TEMPLATE_NODEVO extends BCOM_DYN_PROD_TEMPLATE_NODEVOKey {
    /**
     * This field corresponds to the database column BCOM_DYN_PROD_TEMPLATE_NODE.PARENT_NODE_ID
     */
    private String PARENT_NODE_ID;

    /**
     * This field corresponds to the database column BCOM_DYN_PROD_TEMPLATE_NODE.NODE_TYPE
     */
    private String NODE_TYPE;

    /**
     * This field corresponds to the database column BCOM_DYN_PROD_TEMPLATE_NODE.NODE_DESC
     */
    private String NODE_DESC;

    /**
     * This field corresponds to the database column BCOM_DYN_PROD_TEMPLATE_NODE.NODE_ORDER
     */
    private BigDecimal NODE_ORDER;

    /**
     * This field corresponds to the database column BCOM_DYN_PROD_TEMPLATE_NODE.SCREEN_ID
     */
    private BigDecimal SCREEN_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BCOM_DYN_PROD_TEMPLATE_NODE.PARENT_NODE_ID
     *
     * @return the value of BCOM_DYN_PROD_TEMPLATE_NODE.PARENT_NODE_ID
     */
    public String getPARENT_NODE_ID() {
        return PARENT_NODE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BCOM_DYN_PROD_TEMPLATE_NODE.PARENT_NODE_ID
     *
     * @param PARENT_NODE_ID the value for BCOM_DYN_PROD_TEMPLATE_NODE.PARENT_NODE_ID
     */
    public void setPARENT_NODE_ID(String PARENT_NODE_ID) {
        this.PARENT_NODE_ID = PARENT_NODE_ID == null ? null : PARENT_NODE_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BCOM_DYN_PROD_TEMPLATE_NODE.NODE_TYPE
     *
     * @return the value of BCOM_DYN_PROD_TEMPLATE_NODE.NODE_TYPE
     */
    public String getNODE_TYPE() {
        return NODE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BCOM_DYN_PROD_TEMPLATE_NODE.NODE_TYPE
     *
     * @param NODE_TYPE the value for BCOM_DYN_PROD_TEMPLATE_NODE.NODE_TYPE
     */
    public void setNODE_TYPE(String NODE_TYPE) {
        this.NODE_TYPE = NODE_TYPE == null ? null : NODE_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BCOM_DYN_PROD_TEMPLATE_NODE.NODE_DESC
     *
     * @return the value of BCOM_DYN_PROD_TEMPLATE_NODE.NODE_DESC
     */
    public String getNODE_DESC() {
        return NODE_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BCOM_DYN_PROD_TEMPLATE_NODE.NODE_DESC
     *
     * @param NODE_DESC the value for BCOM_DYN_PROD_TEMPLATE_NODE.NODE_DESC
     */
    public void setNODE_DESC(String NODE_DESC) {
        this.NODE_DESC = NODE_DESC == null ? null : NODE_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BCOM_DYN_PROD_TEMPLATE_NODE.NODE_ORDER
     *
     * @return the value of BCOM_DYN_PROD_TEMPLATE_NODE.NODE_ORDER
     */
    public BigDecimal getNODE_ORDER() {
        return NODE_ORDER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BCOM_DYN_PROD_TEMPLATE_NODE.NODE_ORDER
     *
     * @param NODE_ORDER the value for BCOM_DYN_PROD_TEMPLATE_NODE.NODE_ORDER
     */
    public void setNODE_ORDER(BigDecimal NODE_ORDER) {
        this.NODE_ORDER = NODE_ORDER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BCOM_DYN_PROD_TEMPLATE_NODE.SCREEN_ID
     *
     * @return the value of BCOM_DYN_PROD_TEMPLATE_NODE.SCREEN_ID
     */
    public BigDecimal getSCREEN_ID() {
        return SCREEN_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BCOM_DYN_PROD_TEMPLATE_NODE.SCREEN_ID
     *
     * @param SCREEN_ID the value for BCOM_DYN_PROD_TEMPLATE_NODE.SCREEN_ID
     */
    public void setSCREEN_ID(BigDecimal SCREEN_ID) {
        this.SCREEN_ID = SCREEN_ID;
    }
}