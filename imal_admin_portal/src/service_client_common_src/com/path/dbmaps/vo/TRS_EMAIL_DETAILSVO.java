package com.path.dbmaps.vo;

public class TRS_EMAIL_DETAILSVO extends TRS_EMAIL_DETAILSVOKey {
    /**
     * This field corresponds to the database column TRS_EMAIL_DETAILS.EMAIL_ID
     */
    private String EMAIL_ID;

    /**
     * This field corresponds to the database column TRS_EMAIL_DETAILS.USER_ID
     */
    private String USER_ID;

    /**
     * This field corresponds to the database column TRS_EMAIL_DETAILS.TO_CC_BCC_IND
     */
    private String TO_CC_BCC_IND;

    /**
     * This field corresponds to the database column TRS_EMAIL_DETAILS.SEND_ON
     */
    private String SEND_ON;

    /**
     * This field corresponds to the database column TRS_EMAIL_DETAILS.AUTOMATIC_YN
     */
    private String AUTOMATIC_YN;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_EMAIL_DETAILS.EMAIL_ID
     *
     * @return the value of TRS_EMAIL_DETAILS.EMAIL_ID
     */
    public String getEMAIL_ID() {
        return EMAIL_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_EMAIL_DETAILS.EMAIL_ID
     *
     * @param EMAIL_ID the value for TRS_EMAIL_DETAILS.EMAIL_ID
     */
    public void setEMAIL_ID(String EMAIL_ID) {
        this.EMAIL_ID = EMAIL_ID == null ? null : EMAIL_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_EMAIL_DETAILS.USER_ID
     *
     * @return the value of TRS_EMAIL_DETAILS.USER_ID
     */
    public String getUSER_ID() {
        return USER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_EMAIL_DETAILS.USER_ID
     *
     * @param USER_ID the value for TRS_EMAIL_DETAILS.USER_ID
     */
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID == null ? null : USER_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_EMAIL_DETAILS.TO_CC_BCC_IND
     *
     * @return the value of TRS_EMAIL_DETAILS.TO_CC_BCC_IND
     */
    public String getTO_CC_BCC_IND() {
        return TO_CC_BCC_IND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_EMAIL_DETAILS.TO_CC_BCC_IND
     *
     * @param TO_CC_BCC_IND the value for TRS_EMAIL_DETAILS.TO_CC_BCC_IND
     */
    public void setTO_CC_BCC_IND(String TO_CC_BCC_IND) {
        this.TO_CC_BCC_IND = TO_CC_BCC_IND == null ? null : TO_CC_BCC_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_EMAIL_DETAILS.SEND_ON
     *
     * @return the value of TRS_EMAIL_DETAILS.SEND_ON
     */
    public String getSEND_ON() {
        return SEND_ON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_EMAIL_DETAILS.SEND_ON
     *
     * @param SEND_ON the value for TRS_EMAIL_DETAILS.SEND_ON
     */
    public void setSEND_ON(String SEND_ON) {
        this.SEND_ON = SEND_ON == null ? null : SEND_ON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_EMAIL_DETAILS.AUTOMATIC_YN
     *
     * @return the value of TRS_EMAIL_DETAILS.AUTOMATIC_YN
     */
    public String getAUTOMATIC_YN() {
        return AUTOMATIC_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_EMAIL_DETAILS.AUTOMATIC_YN
     *
     * @param AUTOMATIC_YN the value for TRS_EMAIL_DETAILS.AUTOMATIC_YN
     */
    public void setAUTOMATIC_YN(String AUTOMATIC_YN) {
        this.AUTOMATIC_YN = AUTOMATIC_YN == null ? null : AUTOMATIC_YN.trim();
    }
}