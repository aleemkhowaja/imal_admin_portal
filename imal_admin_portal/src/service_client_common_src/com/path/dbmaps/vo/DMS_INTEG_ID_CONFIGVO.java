package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class DMS_INTEG_ID_CONFIGVO extends BaseVO {
    /**
     * This field corresponds to the database column DMS_INTEG_ID_CONFIG.INTEGRATION_ID
     */
    private BigDecimal INTEGRATION_ID;

    /**
     * This field corresponds to the database column DMS_INTEG_ID_CONFIG.INTEGRATION_BRIEF_NAME
     */
    private String INTEGRATION_BRIEF_NAME;

    /**
     * This field corresponds to the database column DMS_INTEG_ID_CONFIG.DW_APPLICATION_ID
     */
    private String DW_APPLICATION_ID;

    /**
     * This field corresponds to the database column DMS_INTEG_ID_CONFIG.DW_WINDOW_ID
     */
    private String DW_WINDOW_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_INTEG_ID_CONFIG.INTEGRATION_ID
     *
     * @return the value of DMS_INTEG_ID_CONFIG.INTEGRATION_ID
     */
    public BigDecimal getINTEGRATION_ID() {
        return INTEGRATION_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_INTEG_ID_CONFIG.INTEGRATION_ID
     *
     * @param INTEGRATION_ID the value for DMS_INTEG_ID_CONFIG.INTEGRATION_ID
     */
    public void setINTEGRATION_ID(BigDecimal INTEGRATION_ID) {
        this.INTEGRATION_ID = INTEGRATION_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_INTEG_ID_CONFIG.INTEGRATION_BRIEF_NAME
     *
     * @return the value of DMS_INTEG_ID_CONFIG.INTEGRATION_BRIEF_NAME
     */
    public String getINTEGRATION_BRIEF_NAME() {
        return INTEGRATION_BRIEF_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_INTEG_ID_CONFIG.INTEGRATION_BRIEF_NAME
     *
     * @param INTEGRATION_BRIEF_NAME the value for DMS_INTEG_ID_CONFIG.INTEGRATION_BRIEF_NAME
     */
    public void setINTEGRATION_BRIEF_NAME(String INTEGRATION_BRIEF_NAME) {
        this.INTEGRATION_BRIEF_NAME = INTEGRATION_BRIEF_NAME == null ? null : INTEGRATION_BRIEF_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_INTEG_ID_CONFIG.DW_APPLICATION_ID
     *
     * @return the value of DMS_INTEG_ID_CONFIG.DW_APPLICATION_ID
     */
    public String getDW_APPLICATION_ID() {
        return DW_APPLICATION_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_INTEG_ID_CONFIG.DW_APPLICATION_ID
     *
     * @param DW_APPLICATION_ID the value for DMS_INTEG_ID_CONFIG.DW_APPLICATION_ID
     */
    public void setDW_APPLICATION_ID(String DW_APPLICATION_ID) {
        this.DW_APPLICATION_ID = DW_APPLICATION_ID == null ? null : DW_APPLICATION_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_INTEG_ID_CONFIG.DW_WINDOW_ID
     *
     * @return the value of DMS_INTEG_ID_CONFIG.DW_WINDOW_ID
     */
    public String getDW_WINDOW_ID() {
        return DW_WINDOW_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_INTEG_ID_CONFIG.DW_WINDOW_ID
     *
     * @param DW_WINDOW_ID the value for DMS_INTEG_ID_CONFIG.DW_WINDOW_ID
     */
    public void setDW_WINDOW_ID(String DW_WINDOW_ID) {
        this.DW_WINDOW_ID = DW_WINDOW_ID == null ? null : DW_WINDOW_ID.trim();
    }
}