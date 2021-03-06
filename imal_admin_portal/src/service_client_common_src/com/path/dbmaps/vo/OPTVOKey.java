package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;

public class OPTVOKey extends BaseVO {
    /**
     * This field corresponds to the database column OPT.APP_NAME
     */
    private String APP_NAME;

    /**
     * This field corresponds to the database column OPT.PROG_REF
     */
    private String PROG_REF;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.APP_NAME
     *
     * @return the value of OPT.APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.APP_NAME
     *
     * @param APP_NAME the value for OPT.APP_NAME
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME == null ? null : APP_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.PROG_REF
     *
     * @return the value of OPT.PROG_REF
     */
    public String getPROG_REF() {
        return PROG_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.PROG_REF
     *
     * @param PROG_REF the value for OPT.PROG_REF
     */
    public void setPROG_REF(String PROG_REF) {
        this.PROG_REF = PROG_REF == null ? null : PROG_REF.trim();
    }
}