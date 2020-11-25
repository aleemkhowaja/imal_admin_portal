package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;

public class SYS_PARAM_KEY_LABEL_TRANSVO extends BaseVO {
    /**
     * This field corresponds to the database column SYS_PARAM_KEY_LABEL_TRANS.APP_NAME
     */
    private String APP_NAME;

    /**
     * This field corresponds to the database column SYS_PARAM_KEY_LABEL_TRANS.KEY_LABEL_CODE
     */
    private String KEY_LABEL_CODE;

    /**
     * This field corresponds to the database column SYS_PARAM_KEY_LABEL_TRANS.LANG_CODE
     */
    private String LANG_CODE;

    /**
     * This field corresponds to the database column SYS_PARAM_KEY_LABEL_TRANS.PROG_REF
     */
    private String PROG_REF;

    /**
     * This field corresponds to the database column SYS_PARAM_KEY_LABEL_TRANS.VALUE_TRANS
     */
    private String VALUE_TRANS;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_KEY_LABEL_TRANS.APP_NAME
     *
     * @return the value of SYS_PARAM_KEY_LABEL_TRANS.APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_KEY_LABEL_TRANS.APP_NAME
     *
     * @param APP_NAME the value for SYS_PARAM_KEY_LABEL_TRANS.APP_NAME
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME == null ? null : APP_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_KEY_LABEL_TRANS.KEY_LABEL_CODE
     *
     * @return the value of SYS_PARAM_KEY_LABEL_TRANS.KEY_LABEL_CODE
     */
    public String getKEY_LABEL_CODE() {
        return KEY_LABEL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_KEY_LABEL_TRANS.KEY_LABEL_CODE
     *
     * @param KEY_LABEL_CODE the value for SYS_PARAM_KEY_LABEL_TRANS.KEY_LABEL_CODE
     */
    public void setKEY_LABEL_CODE(String KEY_LABEL_CODE) {
        this.KEY_LABEL_CODE = KEY_LABEL_CODE == null ? null : KEY_LABEL_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_KEY_LABEL_TRANS.LANG_CODE
     *
     * @return the value of SYS_PARAM_KEY_LABEL_TRANS.LANG_CODE
     */
    public String getLANG_CODE() {
        return LANG_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_KEY_LABEL_TRANS.LANG_CODE
     *
     * @param LANG_CODE the value for SYS_PARAM_KEY_LABEL_TRANS.LANG_CODE
     */
    public void setLANG_CODE(String LANG_CODE) {
        this.LANG_CODE = LANG_CODE == null ? null : LANG_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_KEY_LABEL_TRANS.PROG_REF
     *
     * @return the value of SYS_PARAM_KEY_LABEL_TRANS.PROG_REF
     */
    public String getPROG_REF() {
        return PROG_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_KEY_LABEL_TRANS.PROG_REF
     *
     * @param PROG_REF the value for SYS_PARAM_KEY_LABEL_TRANS.PROG_REF
     */
    public void setPROG_REF(String PROG_REF) {
        this.PROG_REF = PROG_REF == null ? null : PROG_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_KEY_LABEL_TRANS.VALUE_TRANS
     *
     * @return the value of SYS_PARAM_KEY_LABEL_TRANS.VALUE_TRANS
     */
    public String getVALUE_TRANS() {
        return VALUE_TRANS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_KEY_LABEL_TRANS.VALUE_TRANS
     *
     * @param VALUE_TRANS the value for SYS_PARAM_KEY_LABEL_TRANS.VALUE_TRANS
     */
    public void setVALUE_TRANS(String VALUE_TRANS) {
        this.VALUE_TRANS = VALUE_TRANS == null ? null : VALUE_TRANS;
    }
}