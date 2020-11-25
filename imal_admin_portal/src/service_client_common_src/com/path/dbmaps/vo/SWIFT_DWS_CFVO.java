package com.path.dbmaps.vo;

public class SWIFT_DWS_CFVO extends SWIFT_DWS_CFVOKey {
    /**
     * This field corresponds to the database column SWIFT_DWS_CF.CF_NAME
     */
    private String CF_NAME;

    /**
     * This field corresponds to the database column SWIFT_DWS_CF.CF_EXPRESSION
     */
    private String CF_EXPRESSION;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_DWS_CF.CF_NAME
     *
     * @return the value of SWIFT_DWS_CF.CF_NAME
     */
    public String getCF_NAME() {
        return CF_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_DWS_CF.CF_NAME
     *
     * @param CF_NAME the value for SWIFT_DWS_CF.CF_NAME
     */
    public void setCF_NAME(String CF_NAME) {
        this.CF_NAME = CF_NAME == null ? null : CF_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_DWS_CF.CF_EXPRESSION
     *
     * @return the value of SWIFT_DWS_CF.CF_EXPRESSION
     */
    public String getCF_EXPRESSION() {
        return CF_EXPRESSION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_DWS_CF.CF_EXPRESSION
     *
     * @param CF_EXPRESSION the value for SWIFT_DWS_CF.CF_EXPRESSION
     */
    public void setCF_EXPRESSION(String CF_EXPRESSION) {
        this.CF_EXPRESSION = CF_EXPRESSION == null ? null : CF_EXPRESSION.trim();
    }
}