package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class API_SCR_LOGVO extends BaseVO {
    /**
     * This field corresponds to the database column API_SCR_LOG.AUTO_INC
     */
    private BigDecimal AUTO_INC;

    /**
     * This field corresponds to the database column API_SCR_LOG.ENTITY_NAME
     */
    private String ENTITY_NAME;

    /**
     * This field corresponds to the database column API_SCR_LOG.ENTITY_TYPE
     */
    private String ENTITY_TYPE;

    /**
     * This field corresponds to the database column API_SCR_LOG.SERVER_DATE
     */
    private Date SERVER_DATE;

    /**
     * This field corresponds to the database column API_SCR_LOG.VERSION
     */
    private String VERSION;

    /**
     * This field corresponds to the database column API_SCR_LOG.APP_NAME
     */
    private String APP_NAME;

    /**
     * This field corresponds to the database column API_SCR_LOG.COMMENTS
     */
    private String COMMENTS;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column API_SCR_LOG.AUTO_INC
     *
     * @return the value of API_SCR_LOG.AUTO_INC
     */
    public BigDecimal getAUTO_INC() {
        return AUTO_INC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column API_SCR_LOG.AUTO_INC
     *
     * @param AUTO_INC the value for API_SCR_LOG.AUTO_INC
     */
    public void setAUTO_INC(BigDecimal AUTO_INC) {
        this.AUTO_INC = AUTO_INC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column API_SCR_LOG.ENTITY_NAME
     *
     * @return the value of API_SCR_LOG.ENTITY_NAME
     */
    public String getENTITY_NAME() {
        return ENTITY_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column API_SCR_LOG.ENTITY_NAME
     *
     * @param ENTITY_NAME the value for API_SCR_LOG.ENTITY_NAME
     */
    public void setENTITY_NAME(String ENTITY_NAME) {
        this.ENTITY_NAME = ENTITY_NAME == null ? null : ENTITY_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column API_SCR_LOG.ENTITY_TYPE
     *
     * @return the value of API_SCR_LOG.ENTITY_TYPE
     */
    public String getENTITY_TYPE() {
        return ENTITY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column API_SCR_LOG.ENTITY_TYPE
     *
     * @param ENTITY_TYPE the value for API_SCR_LOG.ENTITY_TYPE
     */
    public void setENTITY_TYPE(String ENTITY_TYPE) {
        this.ENTITY_TYPE = ENTITY_TYPE == null ? null : ENTITY_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column API_SCR_LOG.SERVER_DATE
     *
     * @return the value of API_SCR_LOG.SERVER_DATE
     */
    public Date getSERVER_DATE() {
        return SERVER_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column API_SCR_LOG.SERVER_DATE
     *
     * @param SERVER_DATE the value for API_SCR_LOG.SERVER_DATE
     */
    public void setSERVER_DATE(Date SERVER_DATE) {
        this.SERVER_DATE = SERVER_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column API_SCR_LOG.VERSION
     *
     * @return the value of API_SCR_LOG.VERSION
     */
    public String getVERSION() {
        return VERSION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column API_SCR_LOG.VERSION
     *
     * @param VERSION the value for API_SCR_LOG.VERSION
     */
    public void setVERSION(String VERSION) {
        this.VERSION = VERSION == null ? null : VERSION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column API_SCR_LOG.APP_NAME
     *
     * @return the value of API_SCR_LOG.APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column API_SCR_LOG.APP_NAME
     *
     * @param APP_NAME the value for API_SCR_LOG.APP_NAME
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME == null ? null : APP_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column API_SCR_LOG.COMMENTS
     *
     * @return the value of API_SCR_LOG.COMMENTS
     */
    public String getCOMMENTS() {
        return COMMENTS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column API_SCR_LOG.COMMENTS
     *
     * @param COMMENTS the value for API_SCR_LOG.COMMENTS
     */
    public void setCOMMENTS(String COMMENTS) {
        this.COMMENTS = COMMENTS == null ? null : COMMENTS.trim();
    }
}