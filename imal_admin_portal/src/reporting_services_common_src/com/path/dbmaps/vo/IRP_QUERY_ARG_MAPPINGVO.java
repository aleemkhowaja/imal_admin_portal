package com.path.dbmaps.vo;

public class IRP_QUERY_ARG_MAPPINGVO extends IRP_QUERY_ARG_MAPPINGVOKey {
    /**
     * This field corresponds to the database column IRP_QUERY_ARG_MAPPING.REPORT_MAPPED_ARG_NAME
     */
    private String REPORT_MAPPED_ARG_NAME;

    /**
     * This field corresponds to the database column IRP_QUERY_ARG_MAPPING.STATIC_VALUE
     */
    private String STATIC_VALUE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_QUERY_ARG_MAPPING.REPORT_MAPPED_ARG_NAME
     *
     * @return the value of IRP_QUERY_ARG_MAPPING.REPORT_MAPPED_ARG_NAME
     */
    public String getREPORT_MAPPED_ARG_NAME() {
        return REPORT_MAPPED_ARG_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_QUERY_ARG_MAPPING.REPORT_MAPPED_ARG_NAME
     *
     * @param REPORT_MAPPED_ARG_NAME the value for IRP_QUERY_ARG_MAPPING.REPORT_MAPPED_ARG_NAME
     */
    public void setREPORT_MAPPED_ARG_NAME(String REPORT_MAPPED_ARG_NAME) {
        this.REPORT_MAPPED_ARG_NAME = REPORT_MAPPED_ARG_NAME == null ? null : REPORT_MAPPED_ARG_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_QUERY_ARG_MAPPING.STATIC_VALUE
     *
     * @return the value of IRP_QUERY_ARG_MAPPING.STATIC_VALUE
     */
    public String getSTATIC_VALUE() {
        return STATIC_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_QUERY_ARG_MAPPING.STATIC_VALUE
     *
     * @param STATIC_VALUE the value for IRP_QUERY_ARG_MAPPING.STATIC_VALUE
     */
    public void setSTATIC_VALUE(String STATIC_VALUE) {
        this.STATIC_VALUE = STATIC_VALUE == null ? null : STATIC_VALUE.trim();
    }
}