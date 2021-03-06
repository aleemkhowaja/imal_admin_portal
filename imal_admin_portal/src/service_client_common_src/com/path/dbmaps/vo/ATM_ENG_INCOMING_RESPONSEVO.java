package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class ATM_ENG_INCOMING_RESPONSEVO extends BaseVO {
    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_RESPONSE.ATM_ENG_INCOMING_RESPONSE_ID
     */
    private BigDecimal ATM_ENG_INCOMING_RESPONSE_ID;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_RESPONSE.INTERFACE_ID
     */
    private BigDecimal INTERFACE_ID;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_RESPONSE.MTI_CODE_RESPONSE
     */
    private String MTI_CODE_RESPONSE;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_RESPONSE.ISO_RESPONSE
     */
    private String ISO_RESPONSE;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_RESPONSE.RESPONSE_MAP
     */
    private String RESPONSE_MAP;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_RESPONSE.RECEIVED_TIME
     */
    private Date RECEIVED_TIME;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_RESPONSE.STATUS
     */
    private String STATUS;

    /**
     * This field corresponds to the database column ATM_ENG_INCOMING_RESPONSE.ERROR_MESSAGE
     */
    private String ERROR_MESSAGE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_RESPONSE.ATM_ENG_INCOMING_RESPONSE_ID
     *
     * @return the value of ATM_ENG_INCOMING_RESPONSE.ATM_ENG_INCOMING_RESPONSE_ID
     */
    public BigDecimal getATM_ENG_INCOMING_RESPONSE_ID() {
        return ATM_ENG_INCOMING_RESPONSE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_RESPONSE.ATM_ENG_INCOMING_RESPONSE_ID
     *
     * @param ATM_ENG_INCOMING_RESPONSE_ID the value for ATM_ENG_INCOMING_RESPONSE.ATM_ENG_INCOMING_RESPONSE_ID
     */
    public void setATM_ENG_INCOMING_RESPONSE_ID(BigDecimal ATM_ENG_INCOMING_RESPONSE_ID) {
        this.ATM_ENG_INCOMING_RESPONSE_ID = ATM_ENG_INCOMING_RESPONSE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_RESPONSE.INTERFACE_ID
     *
     * @return the value of ATM_ENG_INCOMING_RESPONSE.INTERFACE_ID
     */
    public BigDecimal getINTERFACE_ID() {
        return INTERFACE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_RESPONSE.INTERFACE_ID
     *
     * @param INTERFACE_ID the value for ATM_ENG_INCOMING_RESPONSE.INTERFACE_ID
     */
    public void setINTERFACE_ID(BigDecimal INTERFACE_ID) {
        this.INTERFACE_ID = INTERFACE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_RESPONSE.MTI_CODE_RESPONSE
     *
     * @return the value of ATM_ENG_INCOMING_RESPONSE.MTI_CODE_RESPONSE
     */
    public String getMTI_CODE_RESPONSE() {
        return MTI_CODE_RESPONSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_RESPONSE.MTI_CODE_RESPONSE
     *
     * @param MTI_CODE_RESPONSE the value for ATM_ENG_INCOMING_RESPONSE.MTI_CODE_RESPONSE
     */
    public void setMTI_CODE_RESPONSE(String MTI_CODE_RESPONSE) {
        this.MTI_CODE_RESPONSE = MTI_CODE_RESPONSE == null ? null : MTI_CODE_RESPONSE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_RESPONSE.ISO_RESPONSE
     *
     * @return the value of ATM_ENG_INCOMING_RESPONSE.ISO_RESPONSE
     */
    public String getISO_RESPONSE() {
        return ISO_RESPONSE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_RESPONSE.ISO_RESPONSE
     *
     * @param ISO_RESPONSE the value for ATM_ENG_INCOMING_RESPONSE.ISO_RESPONSE
     */
    public void setISO_RESPONSE(String ISO_RESPONSE) {
        this.ISO_RESPONSE = ISO_RESPONSE == null ? null : ISO_RESPONSE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_RESPONSE.RESPONSE_MAP
     *
     * @return the value of ATM_ENG_INCOMING_RESPONSE.RESPONSE_MAP
     */
    public String getRESPONSE_MAP() {
        return RESPONSE_MAP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_RESPONSE.RESPONSE_MAP
     *
     * @param RESPONSE_MAP the value for ATM_ENG_INCOMING_RESPONSE.RESPONSE_MAP
     */
    public void setRESPONSE_MAP(String RESPONSE_MAP) {
        this.RESPONSE_MAP = RESPONSE_MAP == null ? null : RESPONSE_MAP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_RESPONSE.RECEIVED_TIME
     *
     * @return the value of ATM_ENG_INCOMING_RESPONSE.RECEIVED_TIME
     */
    public Date getRECEIVED_TIME() {
        return RECEIVED_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_RESPONSE.RECEIVED_TIME
     *
     * @param RECEIVED_TIME the value for ATM_ENG_INCOMING_RESPONSE.RECEIVED_TIME
     */
    public void setRECEIVED_TIME(Date RECEIVED_TIME) {
        this.RECEIVED_TIME = RECEIVED_TIME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_RESPONSE.STATUS
     *
     * @return the value of ATM_ENG_INCOMING_RESPONSE.STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_RESPONSE.STATUS
     *
     * @param STATUS the value for ATM_ENG_INCOMING_RESPONSE.STATUS
     */
    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_ENG_INCOMING_RESPONSE.ERROR_MESSAGE
     *
     * @return the value of ATM_ENG_INCOMING_RESPONSE.ERROR_MESSAGE
     */
    public String getERROR_MESSAGE() {
        return ERROR_MESSAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_ENG_INCOMING_RESPONSE.ERROR_MESSAGE
     *
     * @param ERROR_MESSAGE the value for ATM_ENG_INCOMING_RESPONSE.ERROR_MESSAGE
     */
    public void setERROR_MESSAGE(String ERROR_MESSAGE) {
        this.ERROR_MESSAGE = ERROR_MESSAGE == null ? null : ERROR_MESSAGE.trim();
    }
}