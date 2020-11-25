package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;

public class IRP_SESSION_ATTRIBUTESVO extends BaseVO {
    /**
     * This field corresponds to the database column IRP_SESSION_ATTRIBUTES.ATTRIBUTE_NAME
     */
    private String ATTRIBUTE_NAME;

    /**
     * This field corresponds to the database column IRP_SESSION_ATTRIBUTES.ATTRIBUTE_TYPE
     */
    private String ATTRIBUTE_TYPE;

    /**
     * This field corresponds to the database column IRP_SESSION_ATTRIBUTES.TECHNICAL_NAME
     */
    private String TECHNICAL_NAME;

    /**
     * This field corresponds to the database column IRP_SESSION_ATTRIBUTES.LANG_INDEPENDENT_YN
     */
    private String LANG_INDEPENDENT_YN;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_SESSION_ATTRIBUTES.ATTRIBUTE_NAME
     *
     * @return the value of IRP_SESSION_ATTRIBUTES.ATTRIBUTE_NAME
     */
    public String getATTRIBUTE_NAME() {
        return ATTRIBUTE_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_SESSION_ATTRIBUTES.ATTRIBUTE_NAME
     *
     * @param ATTRIBUTE_NAME the value for IRP_SESSION_ATTRIBUTES.ATTRIBUTE_NAME
     */
    public void setATTRIBUTE_NAME(String ATTRIBUTE_NAME) {
        this.ATTRIBUTE_NAME = ATTRIBUTE_NAME == null ? null : ATTRIBUTE_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_SESSION_ATTRIBUTES.ATTRIBUTE_TYPE
     *
     * @return the value of IRP_SESSION_ATTRIBUTES.ATTRIBUTE_TYPE
     */
    public String getATTRIBUTE_TYPE() {
        return ATTRIBUTE_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_SESSION_ATTRIBUTES.ATTRIBUTE_TYPE
     *
     * @param ATTRIBUTE_TYPE the value for IRP_SESSION_ATTRIBUTES.ATTRIBUTE_TYPE
     */
    public void setATTRIBUTE_TYPE(String ATTRIBUTE_TYPE) {
        this.ATTRIBUTE_TYPE = ATTRIBUTE_TYPE == null ? null : ATTRIBUTE_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_SESSION_ATTRIBUTES.TECHNICAL_NAME
     *
     * @return the value of IRP_SESSION_ATTRIBUTES.TECHNICAL_NAME
     */
    public String getTECHNICAL_NAME() {
        return TECHNICAL_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_SESSION_ATTRIBUTES.TECHNICAL_NAME
     *
     * @param TECHNICAL_NAME the value for IRP_SESSION_ATTRIBUTES.TECHNICAL_NAME
     */
    public void setTECHNICAL_NAME(String TECHNICAL_NAME) {
        this.TECHNICAL_NAME = TECHNICAL_NAME == null ? null : TECHNICAL_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_SESSION_ATTRIBUTES.LANG_INDEPENDENT_YN
     *
     * @return the value of IRP_SESSION_ATTRIBUTES.LANG_INDEPENDENT_YN
     */
    public String getLANG_INDEPENDENT_YN() {
        return LANG_INDEPENDENT_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_SESSION_ATTRIBUTES.LANG_INDEPENDENT_YN
     *
     * @param LANG_INDEPENDENT_YN the value for IRP_SESSION_ATTRIBUTES.LANG_INDEPENDENT_YN
     */
    public void setLANG_INDEPENDENT_YN(String LANG_INDEPENDENT_YN) {
        this.LANG_INDEPENDENT_YN = LANG_INDEPENDENT_YN == null ? null : LANG_INDEPENDENT_YN.trim();
    }
}