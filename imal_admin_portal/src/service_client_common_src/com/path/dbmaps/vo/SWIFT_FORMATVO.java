package com.path.dbmaps.vo;

public class SWIFT_FORMATVO extends SWIFT_FORMATVOKey {
    /**
     * This field corresponds to the database column SWIFT_FORMAT.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column SWIFT_FORMAT.TAG
     */
    private String TAG;

    /**
     * This field corresponds to the database column SWIFT_FORMAT.DESCRIPTION
     */
    private String DESCRIPTION;

    /**
     * This field corresponds to the database column SWIFT_FORMAT.OPTIONS
     */
    private String OPTIONS;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_FORMAT.STATUS
     *
     * @return the value of SWIFT_FORMAT.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_FORMAT.STATUS
     *
     * @param STATUS the value for SWIFT_FORMAT.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_FORMAT.TAG
     *
     * @return the value of SWIFT_FORMAT.TAG
     */
    public String getTAG() {
        return TAG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_FORMAT.TAG
     *
     * @param TAG the value for SWIFT_FORMAT.TAG
     */
    public void setTAG(String TAG) {
        this.TAG = TAG == null ? null : TAG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_FORMAT.DESCRIPTION
     *
     * @return the value of SWIFT_FORMAT.DESCRIPTION
     */
    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_FORMAT.DESCRIPTION
     *
     * @param DESCRIPTION the value for SWIFT_FORMAT.DESCRIPTION
     */
    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_FORMAT.OPTIONS
     *
     * @return the value of SWIFT_FORMAT.OPTIONS
     */
    public String getOPTIONS() {
        return OPTIONS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_FORMAT.OPTIONS
     *
     * @param OPTIONS the value for SWIFT_FORMAT.OPTIONS
     */
    public void setOPTIONS(String OPTIONS) {
        this.OPTIONS = OPTIONS == null ? null : OPTIONS.trim();
    }
}