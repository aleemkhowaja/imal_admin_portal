package com.path.dbmaps.vo;

public class SMS_SERVICESVOWithBLOBs extends SMS_SERVICESVO {
    /**
     * This field corresponds to the database column SMS_SERVICES.MSG_STRUCT
     */
    private String MSG_STRUCT;

    /**
     * This field corresponds to the database column SMS_SERVICES.MSG_STRUCT_ARAB
     */
    private String MSG_STRUCT_ARAB;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SERVICES.MSG_STRUCT
     *
     * @return the value of SMS_SERVICES.MSG_STRUCT
     */
    public String getMSG_STRUCT() {
        return MSG_STRUCT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SERVICES.MSG_STRUCT
     *
     * @param MSG_STRUCT the value for SMS_SERVICES.MSG_STRUCT
     */
    public void setMSG_STRUCT(String MSG_STRUCT) {
        this.MSG_STRUCT = MSG_STRUCT == null ? null : MSG_STRUCT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SMS_SERVICES.MSG_STRUCT_ARAB
     *
     * @return the value of SMS_SERVICES.MSG_STRUCT_ARAB
     */
    public String getMSG_STRUCT_ARAB() {
        return MSG_STRUCT_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SMS_SERVICES.MSG_STRUCT_ARAB
     *
     * @param MSG_STRUCT_ARAB the value for SMS_SERVICES.MSG_STRUCT_ARAB
     */
    public void setMSG_STRUCT_ARAB(String MSG_STRUCT_ARAB) {
        this.MSG_STRUCT_ARAB = MSG_STRUCT_ARAB == null ? null : MSG_STRUCT_ARAB.trim();
    }
}