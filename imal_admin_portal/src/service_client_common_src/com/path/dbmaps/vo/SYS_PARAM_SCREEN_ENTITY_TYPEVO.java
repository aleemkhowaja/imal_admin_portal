package com.path.dbmaps.vo;

public class SYS_PARAM_SCREEN_ENTITY_TYPEVO extends SYS_PARAM_SCREEN_ENTITY_TYPEVOKey {
    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_ENTITY_TYPE.ENTITY_TYPE
     */
    private String ENTITY_TYPE;

    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_ENTITY_TYPE.PROPERTY_NAME
     */
    private String PROPERTY_NAME;
    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_ENTITY_TYPE.PROPERTY_NAME
     */
    private String PROPERTY_DATA_TYPE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_SCREEN_ENTITY_TYPE.ENTITY_TYPE
     *
     * @return the value of SYS_PARAM_SCREEN_ENTITY_TYPE.ENTITY_TYPE
     */
    public String getENTITY_TYPE() {
        return ENTITY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_SCREEN_ENTITY_TYPE.ENTITY_TYPE
     *
     * @param ENTITY_TYPE the value for SYS_PARAM_SCREEN_ENTITY_TYPE.ENTITY_TYPE
     */
    public void setENTITY_TYPE(String ENTITY_TYPE) {
        this.ENTITY_TYPE = ENTITY_TYPE == null ? null : ENTITY_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_SCREEN_ENTITY_TYPE.PROPERTY_NAME
     *
     * @return the value of SYS_PARAM_SCREEN_ENTITY_TYPE.PROPERTY_NAME
     */
    public String getPROPERTY_NAME() {
        return PROPERTY_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_SCREEN_ENTITY_TYPE.PROPERTY_NAME
     *
     * @param PROPERTY_NAME the value for SYS_PARAM_SCREEN_ENTITY_TYPE.PROPERTY_NAME
     */
    public void setPROPERTY_NAME(String PROPERTY_NAME) {
        this.PROPERTY_NAME = PROPERTY_NAME == null ? null : PROPERTY_NAME.trim();
    }

    public String getPROPERTY_DATA_TYPE()
    {
        return PROPERTY_DATA_TYPE;
    }

    public void setPROPERTY_DATA_TYPE(String pROPERTY_DATA_TYPE)
    {
        PROPERTY_DATA_TYPE = pROPERTY_DATA_TYPE;
    }
}