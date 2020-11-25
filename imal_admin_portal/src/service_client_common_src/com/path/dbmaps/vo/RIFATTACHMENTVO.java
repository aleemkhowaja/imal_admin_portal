package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;

public class RIFATTACHMENTVO extends BaseVO {
    /**
     * This field corresponds to the database column RIFATTACHMENT.APP_NAME
     */
    private String APP_NAME;

    /**
     * This field corresponds to the database column RIFATTACHMENT.PROG_REFERENCE
     */
    private String PROG_REFERENCE;

    /**
     * This field corresponds to the database column RIFATTACHMENT.TRX_NBR
     */
    private String TRX_NBR;

    /**
     * This field corresponds to the database column RIFATTACHMENT.ATTACH_TYPE
     */
    private String ATTACH_TYPE;

    /**
     * This field corresponds to the database column RIFATTACHMENT.ATTACHMENT_DETAILS
     */
    private String ATTACHMENT_DETAILS;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFATTACHMENT.APP_NAME
     *
     * @return the value of RIFATTACHMENT.APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFATTACHMENT.APP_NAME
     *
     * @param APP_NAME the value for RIFATTACHMENT.APP_NAME
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME == null ? null : APP_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFATTACHMENT.PROG_REFERENCE
     *
     * @return the value of RIFATTACHMENT.PROG_REFERENCE
     */
    public String getPROG_REFERENCE() {
        return PROG_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFATTACHMENT.PROG_REFERENCE
     *
     * @param PROG_REFERENCE the value for RIFATTACHMENT.PROG_REFERENCE
     */
    public void setPROG_REFERENCE(String PROG_REFERENCE) {
        this.PROG_REFERENCE = PROG_REFERENCE == null ? null : PROG_REFERENCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFATTACHMENT.TRX_NBR
     *
     * @return the value of RIFATTACHMENT.TRX_NBR
     */
    public String getTRX_NBR() {
        return TRX_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFATTACHMENT.TRX_NBR
     *
     * @param TRX_NBR the value for RIFATTACHMENT.TRX_NBR
     */
    public void setTRX_NBR(String TRX_NBR) {
        this.TRX_NBR = TRX_NBR == null ? null : TRX_NBR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFATTACHMENT.ATTACH_TYPE
     *
     * @return the value of RIFATTACHMENT.ATTACH_TYPE
     */
    public String getATTACH_TYPE() {
        return ATTACH_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFATTACHMENT.ATTACH_TYPE
     *
     * @param ATTACH_TYPE the value for RIFATTACHMENT.ATTACH_TYPE
     */
    public void setATTACH_TYPE(String ATTACH_TYPE) {
        this.ATTACH_TYPE = ATTACH_TYPE == null ? null : ATTACH_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RIFATTACHMENT.ATTACHMENT_DETAILS
     *
     * @return the value of RIFATTACHMENT.ATTACHMENT_DETAILS
     */
    public String getATTACHMENT_DETAILS() {
        return ATTACHMENT_DETAILS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RIFATTACHMENT.ATTACHMENT_DETAILS
     *
     * @param ATTACHMENT_DETAILS the value for RIFATTACHMENT.ATTACHMENT_DETAILS
     */
    public void setATTACHMENT_DETAILS(String ATTACHMENT_DETAILS) {
        this.ATTACHMENT_DETAILS = ATTACHMENT_DETAILS == null ? null : ATTACHMENT_DETAILS.trim();
    }
}