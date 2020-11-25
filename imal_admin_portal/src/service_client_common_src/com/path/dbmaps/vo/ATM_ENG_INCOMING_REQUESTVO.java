package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class ATM_ENG_INCOMING_REQUESTVO extends BaseVO {
    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_REQUEST.ATM_ENG_INCOMING_REQUEST_ID
     */
    private BigDecimal ATM_ENG_INCOMING_REQUEST_ID;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_REQUEST.INTERFACE_ID
     */
    private BigDecimal INTERFACE_ID;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_REQUEST.MESSAGE_ID
     */
    private BigDecimal MESSAGE_ID;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_REQUEST.MTI_CODE_REQUEST
     */
    private String MTI_CODE_REQUEST;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_REQUEST.MESSAGE_REQUEST
     */
    private String MESSAGE_REQUEST;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_REQUEST.RECEIVE_TIME
     */
    private Date RECEIVE_TIME;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_REQUEST.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_REQUEST.ERROR_MESSAGE
     */
    private String ERROR_MESSAGE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_REQUEST.ATM_ENG_INCOMING_REQUEST_ID
     *
     * @return the value of ATM_ENG_INCOMING_REQUEST.ATM_ENG_INCOMING_REQUEST_ID
     */
    public BigDecimal getATM_ENG_INCOMING_REQUEST_ID() {
        return ATM_ENG_INCOMING_REQUEST_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_REQUEST.ATM_ENG_INCOMING_REQUEST_ID
     *
     * @param ATM_ENG_INCOMING_REQUEST_ID the value for ATM_ENG_INCOMING_REQUEST.ATM_ENG_INCOMING_REQUEST_ID
     */
    public void setATM_ENG_INCOMING_REQUEST_ID(BigDecimal ATM_ENG_INCOMING_REQUEST_ID) {
        this.ATM_ENG_INCOMING_REQUEST_ID = ATM_ENG_INCOMING_REQUEST_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_REQUEST.INTERFACE_ID
     *
     * @return the value of ATM_ENG_INCOMING_REQUEST.INTERFACE_ID
     */
    public BigDecimal getINTERFACE_ID() {
        return INTERFACE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_REQUEST.INTERFACE_ID
     *
     * @param INTERFACE_ID the value for ATM_ENG_INCOMING_REQUEST.INTERFACE_ID
     */
    public void setINTERFACE_ID(BigDecimal INTERFACE_ID) {
        this.INTERFACE_ID = INTERFACE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_REQUEST.MESSAGE_ID
     *
     * @return the value of ATM_ENG_INCOMING_REQUEST.MESSAGE_ID
     */
    public BigDecimal getMESSAGE_ID() {
        return MESSAGE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_REQUEST.MESSAGE_ID
     *
     * @param MESSAGE_ID the value for ATM_ENG_INCOMING_REQUEST.MESSAGE_ID
     */
    public void setMESSAGE_ID(BigDecimal MESSAGE_ID) {
        this.MESSAGE_ID = MESSAGE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_REQUEST.MTI_CODE_REQUEST
     *
     * @return the value of ATM_ENG_INCOMING_REQUEST.MTI_CODE_REQUEST
     */
    public String getMTI_CODE_REQUEST() {
        return MTI_CODE_REQUEST;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_REQUEST.MTI_CODE_REQUEST
     *
     * @param MTI_CODE_REQUEST the value for ATM_ENG_INCOMING_REQUEST.MTI_CODE_REQUEST
     */
    public void setMTI_CODE_REQUEST(String MTI_CODE_REQUEST) {
        this.MTI_CODE_REQUEST = MTI_CODE_REQUEST == null ? null : MTI_CODE_REQUEST.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_REQUEST.MESSAGE_REQUEST
     *
     * @return the value of ATM_ENG_INCOMING_REQUEST.MESSAGE_REQUEST
     */
    public String getMESSAGE_REQUEST() {
        return MESSAGE_REQUEST;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_REQUEST.MESSAGE_REQUEST
     *
     * @param MESSAGE_REQUEST the value for ATM_ENG_INCOMING_REQUEST.MESSAGE_REQUEST
     */
    public void setMESSAGE_REQUEST(String MESSAGE_REQUEST) {
        this.MESSAGE_REQUEST = MESSAGE_REQUEST == null ? null : MESSAGE_REQUEST.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_REQUEST.RECEIVE_TIME
     *
     * @return the value of ATM_ENG_INCOMING_REQUEST.RECEIVE_TIME
     */
    public Date getRECEIVE_TIME() {
        return RECEIVE_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_REQUEST.RECEIVE_TIME
     *
     * @param RECEIVE_TIME the value for ATM_ENG_INCOMING_REQUEST.RECEIVE_TIME
     */
    public void setRECEIVE_TIME(Date RECEIVE_TIME) {
        this.RECEIVE_TIME = RECEIVE_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_REQUEST.STATUS
     *
     * @return the value of ATM_ENG_INCOMING_REQUEST.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_REQUEST.STATUS
     *
     * @param STATUS the value for ATM_ENG_INCOMING_REQUEST.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_REQUEST.ERROR_MESSAGE
     *
     * @return the value of ATM_ENG_INCOMING_REQUEST.ERROR_MESSAGE
     */
    public String getERROR_MESSAGE() {
        return ERROR_MESSAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_REQUEST.ERROR_MESSAGE
     *
     * @param ERROR_MESSAGE the value for ATM_ENG_INCOMING_REQUEST.ERROR_MESSAGE
     */
    public void setERROR_MESSAGE(String ERROR_MESSAGE) {
        this.ERROR_MESSAGE = ERROR_MESSAGE == null ? null : ERROR_MESSAGE.trim();
    }
}