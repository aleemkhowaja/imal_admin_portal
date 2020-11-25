package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ATM_BASE2_HISTORYVO extends ATM_BASE2_HISTORYVOKey {
    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.DATE_ATM
     */
    private String DATE_ATM;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.CARD_NO
     */
    private String CARD_NO;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.CURRENCY_CODE
     */
    private BigDecimal CURRENCY_CODE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.ISO_CY
     */
    private String ISO_CY;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.CY_NAME
     */
    private String CY_NAME;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.AMOUNT
     */
    private String AMOUNT;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.AUTHORIZATION_CODE
     */
    private String AUTHORIZATION_CODE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.POSITION1
     */
    private String POSITION1;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.POSITION2
     */
    private String POSITION2;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.REVERSED
     */
    private String REVERSED;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.MATCH
     */
    private String MATCH;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.PROCESS
     */
    private String PROCESS;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.OLD_TRX_NBR
     */
    private BigDecimal OLD_TRX_NBR;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.TRX_BR
     */
    private BigDecimal TRX_BR;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.TRS_NO
     */
    private BigDecimal TRS_NO;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.PROCEED_FLAG
     */
    private BigDecimal PROCEED_FLAG;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.ATM_TRX
     */
    private BigDecimal ATM_TRX;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.REASON
     */
    private String REASON;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.LINE_TRX
     */
    private BigDecimal LINE_TRX;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.TRS_CODE
     */
    private String TRS_CODE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.TRS_QUALIFIER
     */
    private String TRS_QUALIFIER;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.TRS_SEQUENCE
     */
    private String TRS_SEQUENCE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.ACCOUNT_NUM
     */
    private String ACCOUNT_NUM;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.ACCOUNT_EXT
     */
    private String ACCOUNT_EXT;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.FLOOR_IND
     */
    private String FLOOR_IND;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.CRB
     */
    private String CRB;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.PCAS
     */
    private String PCAS;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.ACQUIRER_REF
     */
    private String ACQUIRER_REF;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.ACQUIRER_BUSINESS
     */
    private String ACQUIRER_BUSINESS;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.PURCHASE_DATE
     */
    private String PURCHASE_DATE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.DEST_AMOUNT
     */
    private String DEST_AMOUNT;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.DEST_CY
     */
    private String DEST_CY;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.SOURCE_AMOUNT
     */
    private String SOURCE_AMOUNT;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.SOURCE_CY
     */
    private String SOURCE_CY;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.MERCHANT_NAME
     */
    private String MERCHANT_NAME;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.MERCHANT_CITY
     */
    private String MERCHANT_CITY;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.MERCHANT_COUNTRY
     */
    private String MERCHANT_COUNTRY;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.MERCHANT_CATEGORY
     */
    private String MERCHANT_CATEGORY;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.MERCHANT_ZIP
     */
    private String MERCHANT_ZIP;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.MERCHANT_STAT
     */
    private String MERCHANT_STAT;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.REQUESTED_PAY
     */
    private String REQUESTED_PAY;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.RESERVED
     */
    private String RESERVED;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.USAGE_CODE
     */
    private String USAGE_CODE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.REASON_CODE
     */
    private String REASON_CODE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.SETTL
     */
    private String SETTL;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.ACI
     */
    private String ACI;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.AUTH_CODE
     */
    private String AUTH_CODE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.POS_TERMINAL
     */
    private String POS_TERMINAL;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.INTERN_FEE
     */
    private String INTERN_FEE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.CARD_ID
     */
    private String CARD_ID;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.COLLECTION
     */
    private String COLLECTION;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.POS
     */
    private String POS;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.CENTRAL_PROC
     */
    private String CENTRAL_PROC;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.REIMB_ATT
     */
    private String REIMB_ATT;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.ATM_TRX_NO
     */
    private BigDecimal ATM_TRX_NO;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.BASE1_TRX_NO
     */
    private BigDecimal BASE1_TRX_NO;
    
    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.BATCH_NO
     */
    private BigDecimal BATCH_NO;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.DATA_LINE_00
     */
    private String DATA_LINE_00;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.DATA_LINE_01
     */
    private String DATA_LINE_01;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.DATA_LINE_05
     */
    private String DATA_LINE_05;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.DECIMAL_AMOUNT
     */
    private BigDecimal DECIMAL_AMOUNT;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.ISO_INTERFACE
     */
    private BigDecimal ISO_INTERFACE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.MATCH_DATE
     */
    private Date MATCH_DATE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.NB_OF_MATCHING
     */
    private BigDecimal NB_OF_MATCHING;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.NEW_TRX_BR
     */
    private BigDecimal NEW_TRX_BR;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.NEW_TRX_NO
     */
    private BigDecimal NEW_TRX_NO;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.STATE_ON_MATCH
     */
    private String STATE_ON_MATCH;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.STATE_ON_PROCESS
     */
    private String STATE_ON_PROCESS;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.TC_92
     */
    private String TC_92;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.TRS_SEQUENCE2
     */
    private String TRS_SEQUENCE2;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.TRS_SEQUENCE3
     */
    private String TRS_SEQUENCE3;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.TRX_SEQ_NO
     */
    private String TRX_SEQ_NO;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.SOURCE_CY3
     */
    private String SOURCE_CY3;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.SOURCE_AMOUNT3
     */
    private String SOURCE_AMOUNT3;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.PROCESS_DATE
     */
    private Date PROCESS_DATE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.TRX_SEQ_TOTAL
     */
    private String TRX_SEQ_TOTAL;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.REVERSED_SEQUENCE
     */
    private String REVERSED_SEQUENCE;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.PROCESSED_BY
     */
    private String PROCESSED_BY;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.FORCE_POST
     */
    private String FORCE_POST;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.FORCE_DEBIT
     */
    private String FORCE_DEBIT;

    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.UPLOAD_DATE
     */
    private Date UPLOAD_DATE;
    
    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.ADDITIONAL_REFERENCE
     */
    private String ADDITIONAL_REFERENCE;
    
    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.SAME_AMOUNT
     */
    private String SAME_AMOUNT;
    
    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.REV_SAME_FILE
     */
    private String REV_SAME_FILE;
    
    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.RELEASE_STATE
     */
    private String RELEASE_STATE;
    
    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.MATCH_REV_SEQUENCE
     */
    private BigDecimal MATCH_REV_SEQUENCE;
    
    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.NO_BALANCE_YN
     */
    private String NO_BALANCE_YN;
    
    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.DUPLICATE_BASE1_YN
     */
    private String DUPLICATE_BASE1_YN;
    
    /**
     * This field corresponds to the database column ATM_BASE2_HISTORY.USER_ID
     */
    private String USER_ID;
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.LINE_NO
     *
     * @return the value of ATM_BASE2_HISTORY.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.LINE_NO
     *
     * @param LINE_NO the value for ATM_BASE2_HISTORY.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.DATE_ATM
     *
     * @return the value of ATM_BASE2_HISTORY.DATE_ATM
     */
    public String getDATE_ATM() {
        return DATE_ATM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.DATE_ATM
     *
     * @param DATE_ATM the value for ATM_BASE2_HISTORY.DATE_ATM
     */
    public void setDATE_ATM(String DATE_ATM) {
        this.DATE_ATM = DATE_ATM == null ? null : DATE_ATM.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.CARD_NO
     *
     * @return the value of ATM_BASE2_HISTORY.CARD_NO
     */
    public String getCARD_NO() {
        return CARD_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.CARD_NO
     *
     * @param CARD_NO the value for ATM_BASE2_HISTORY.CARD_NO
     */
    public void setCARD_NO(String CARD_NO) {
        this.CARD_NO = CARD_NO == null ? null : CARD_NO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.CURRENCY_CODE
     *
     * @return the value of ATM_BASE2_HISTORY.CURRENCY_CODE
     */
    public BigDecimal getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.CURRENCY_CODE
     *
     * @param CURRENCY_CODE the value for ATM_BASE2_HISTORY.CURRENCY_CODE
     */
    public void setCURRENCY_CODE(BigDecimal CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.ISO_CY
     *
     * @return the value of ATM_BASE2_HISTORY.ISO_CY
     */
    public String getISO_CY() {
        return ISO_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.ISO_CY
     *
     * @param ISO_CY the value for ATM_BASE2_HISTORY.ISO_CY
     */
    public void setISO_CY(String ISO_CY) {
        this.ISO_CY = ISO_CY == null ? null : ISO_CY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.CY_NAME
     *
     * @return the value of ATM_BASE2_HISTORY.CY_NAME
     */
    public String getCY_NAME() {
        return CY_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.CY_NAME
     *
     * @param CY_NAME the value for ATM_BASE2_HISTORY.CY_NAME
     */
    public void setCY_NAME(String CY_NAME) {
        this.CY_NAME = CY_NAME == null ? null : CY_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.AMOUNT
     *
     * @return the value of ATM_BASE2_HISTORY.AMOUNT
     */
    public String getAMOUNT() {
        return AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.AMOUNT
     *
     * @param AMOUNT the value for ATM_BASE2_HISTORY.AMOUNT
     */
    public void setAMOUNT(String AMOUNT) {
        this.AMOUNT = AMOUNT == null ? null : AMOUNT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.AUTHORIZATION_CODE
     *
     * @return the value of ATM_BASE2_HISTORY.AUTHORIZATION_CODE
     */
    public String getAUTHORIZATION_CODE() {
        return AUTHORIZATION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.AUTHORIZATION_CODE
     *
     * @param AUTHORIZATION_CODE the value for ATM_BASE2_HISTORY.AUTHORIZATION_CODE
     */
    public void setAUTHORIZATION_CODE(String AUTHORIZATION_CODE) {
        this.AUTHORIZATION_CODE = AUTHORIZATION_CODE == null ? null : AUTHORIZATION_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.POSITION1
     *
     * @return the value of ATM_BASE2_HISTORY.POSITION1
     */
    public String getPOSITION1() {
        return POSITION1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.POSITION1
     *
     * @param POSITION1 the value for ATM_BASE2_HISTORY.POSITION1
     */
    public void setPOSITION1(String POSITION1) {
        this.POSITION1 = POSITION1 == null ? null : POSITION1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.POSITION2
     *
     * @return the value of ATM_BASE2_HISTORY.POSITION2
     */
    public String getPOSITION2() {
        return POSITION2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.POSITION2
     *
     * @param POSITION2 the value for ATM_BASE2_HISTORY.POSITION2
     */
    public void setPOSITION2(String POSITION2) {
        this.POSITION2 = POSITION2 == null ? null : POSITION2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.REVERSED
     *
     * @return the value of ATM_BASE2_HISTORY.REVERSED
     */
    public String getREVERSED() {
        return REVERSED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.REVERSED
     *
     * @param REVERSED the value for ATM_BASE2_HISTORY.REVERSED
     */
    public void setREVERSED(String REVERSED) {
        this.REVERSED = REVERSED == null ? null : REVERSED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.MATCH
     *
     * @return the value of ATM_BASE2_HISTORY.MATCH
     */
    public String getMATCH() {
        return MATCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.MATCH
     *
     * @param MATCH the value for ATM_BASE2_HISTORY.MATCH
     */
    public void setMATCH(String MATCH) {
        this.MATCH = MATCH == null ? null : MATCH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.PROCESS
     *
     * @return the value of ATM_BASE2_HISTORY.PROCESS
     */
    public String getPROCESS() {
        return PROCESS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.PROCESS
     *
     * @param PROCESS the value for ATM_BASE2_HISTORY.PROCESS
     */
    public void setPROCESS(String PROCESS) {
        this.PROCESS = PROCESS == null ? null : PROCESS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.OLD_TRX_NBR
     *
     * @return the value of ATM_BASE2_HISTORY.OLD_TRX_NBR
     */
    public BigDecimal getOLD_TRX_NBR() {
        return OLD_TRX_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.OLD_TRX_NBR
     *
     * @param OLD_TRX_NBR the value for ATM_BASE2_HISTORY.OLD_TRX_NBR
     */
    public void setOLD_TRX_NBR(BigDecimal OLD_TRX_NBR) {
        this.OLD_TRX_NBR = OLD_TRX_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.TRX_BR
     *
     * @return the value of ATM_BASE2_HISTORY.TRX_BR
     */
    public BigDecimal getTRX_BR() {
        return TRX_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.TRX_BR
     *
     * @param TRX_BR the value for ATM_BASE2_HISTORY.TRX_BR
     */
    public void setTRX_BR(BigDecimal TRX_BR) {
        this.TRX_BR = TRX_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.TRS_NO
     *
     * @return the value of ATM_BASE2_HISTORY.TRS_NO
     */
    public BigDecimal getTRS_NO() {
        return TRS_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.TRS_NO
     *
     * @param TRS_NO the value for ATM_BASE2_HISTORY.TRS_NO
     */
    public void setTRS_NO(BigDecimal TRS_NO) {
        this.TRS_NO = TRS_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.PROCEED_FLAG
     *
     * @return the value of ATM_BASE2_HISTORY.PROCEED_FLAG
     */
    public BigDecimal getPROCEED_FLAG() {
        return PROCEED_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.PROCEED_FLAG
     *
     * @param PROCEED_FLAG the value for ATM_BASE2_HISTORY.PROCEED_FLAG
     */
    public void setPROCEED_FLAG(BigDecimal PROCEED_FLAG) {
        this.PROCEED_FLAG = PROCEED_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.ATM_TRX
     *
     * @return the value of ATM_BASE2_HISTORY.ATM_TRX
     */
    public BigDecimal getATM_TRX() {
        return ATM_TRX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.ATM_TRX
     *
     * @param ATM_TRX the value for ATM_BASE2_HISTORY.ATM_TRX
     */
    public void setATM_TRX(BigDecimal ATM_TRX) {
        this.ATM_TRX = ATM_TRX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.REASON
     *
     * @return the value of ATM_BASE2_HISTORY.REASON
     */
    public String getREASON() {
        return REASON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.REASON
     *
     * @param REASON the value for ATM_BASE2_HISTORY.REASON
     */
    public void setREASON(String REASON) {
        this.REASON = REASON == null ? null : REASON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.LINE_TRX
     *
     * @return the value of ATM_BASE2_HISTORY.LINE_TRX
     */
    public BigDecimal getLINE_TRX() {
        return LINE_TRX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.LINE_TRX
     *
     * @param LINE_TRX the value for ATM_BASE2_HISTORY.LINE_TRX
     */
    public void setLINE_TRX(BigDecimal LINE_TRX) {
        this.LINE_TRX = LINE_TRX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.TRS_CODE
     *
     * @return the value of ATM_BASE2_HISTORY.TRS_CODE
     */
    public String getTRS_CODE() {
        return TRS_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.TRS_CODE
     *
     * @param TRS_CODE the value for ATM_BASE2_HISTORY.TRS_CODE
     */
    public void setTRS_CODE(String TRS_CODE) {
        this.TRS_CODE = TRS_CODE == null ? null : TRS_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.TRS_QUALIFIER
     *
     * @return the value of ATM_BASE2_HISTORY.TRS_QUALIFIER
     */
    public String getTRS_QUALIFIER() {
        return TRS_QUALIFIER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.TRS_QUALIFIER
     *
     * @param TRS_QUALIFIER the value for ATM_BASE2_HISTORY.TRS_QUALIFIER
     */
    public void setTRS_QUALIFIER(String TRS_QUALIFIER) {
        this.TRS_QUALIFIER = TRS_QUALIFIER == null ? null : TRS_QUALIFIER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.TRS_SEQUENCE
     *
     * @return the value of ATM_BASE2_HISTORY.TRS_SEQUENCE
     */
    public String getTRS_SEQUENCE() {
        return TRS_SEQUENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.TRS_SEQUENCE
     *
     * @param TRS_SEQUENCE the value for ATM_BASE2_HISTORY.TRS_SEQUENCE
     */
    public void setTRS_SEQUENCE(String TRS_SEQUENCE) {
        this.TRS_SEQUENCE = TRS_SEQUENCE == null ? null : TRS_SEQUENCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.ACCOUNT_NUM
     *
     * @return the value of ATM_BASE2_HISTORY.ACCOUNT_NUM
     */
    public String getACCOUNT_NUM() {
        return ACCOUNT_NUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.ACCOUNT_NUM
     *
     * @param ACCOUNT_NUM the value for ATM_BASE2_HISTORY.ACCOUNT_NUM
     */
    public void setACCOUNT_NUM(String ACCOUNT_NUM) {
        this.ACCOUNT_NUM = ACCOUNT_NUM == null ? null : ACCOUNT_NUM.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.ACCOUNT_EXT
     *
     * @return the value of ATM_BASE2_HISTORY.ACCOUNT_EXT
     */
    public String getACCOUNT_EXT() {
        return ACCOUNT_EXT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.ACCOUNT_EXT
     *
     * @param ACCOUNT_EXT the value for ATM_BASE2_HISTORY.ACCOUNT_EXT
     */
    public void setACCOUNT_EXT(String ACCOUNT_EXT) {
        this.ACCOUNT_EXT = ACCOUNT_EXT == null ? null : ACCOUNT_EXT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.FLOOR_IND
     *
     * @return the value of ATM_BASE2_HISTORY.FLOOR_IND
     */
    public String getFLOOR_IND() {
        return FLOOR_IND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.FLOOR_IND
     *
     * @param FLOOR_IND the value for ATM_BASE2_HISTORY.FLOOR_IND
     */
    public void setFLOOR_IND(String FLOOR_IND) {
        this.FLOOR_IND = FLOOR_IND == null ? null : FLOOR_IND.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.CRB
     *
     * @return the value of ATM_BASE2_HISTORY.CRB
     */
    public String getCRB() {
        return CRB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.CRB
     *
     * @param CRB the value for ATM_BASE2_HISTORY.CRB
     */
    public void setCRB(String CRB) {
        this.CRB = CRB == null ? null : CRB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.PCAS
     *
     * @return the value of ATM_BASE2_HISTORY.PCAS
     */
    public String getPCAS() {
        return PCAS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.PCAS
     *
     * @param PCAS the value for ATM_BASE2_HISTORY.PCAS
     */
    public void setPCAS(String PCAS) {
        this.PCAS = PCAS == null ? null : PCAS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.ACQUIRER_REF
     *
     * @return the value of ATM_BASE2_HISTORY.ACQUIRER_REF
     */
    public String getACQUIRER_REF() {
        return ACQUIRER_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.ACQUIRER_REF
     *
     * @param ACQUIRER_REF the value for ATM_BASE2_HISTORY.ACQUIRER_REF
     */
    public void setACQUIRER_REF(String ACQUIRER_REF) {
        this.ACQUIRER_REF = ACQUIRER_REF == null ? null : ACQUIRER_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.ACQUIRER_BUSINESS
     *
     * @return the value of ATM_BASE2_HISTORY.ACQUIRER_BUSINESS
     */
    public String getACQUIRER_BUSINESS() {
        return ACQUIRER_BUSINESS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.ACQUIRER_BUSINESS
     *
     * @param ACQUIRER_BUSINESS the value for ATM_BASE2_HISTORY.ACQUIRER_BUSINESS
     */
    public void setACQUIRER_BUSINESS(String ACQUIRER_BUSINESS) {
        this.ACQUIRER_BUSINESS = ACQUIRER_BUSINESS == null ? null : ACQUIRER_BUSINESS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.PURCHASE_DATE
     *
     * @return the value of ATM_BASE2_HISTORY.PURCHASE_DATE
     */
    public String getPURCHASE_DATE() {
        return PURCHASE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.PURCHASE_DATE
     *
     * @param PURCHASE_DATE the value for ATM_BASE2_HISTORY.PURCHASE_DATE
     */
    public void setPURCHASE_DATE(String PURCHASE_DATE) {
        this.PURCHASE_DATE = PURCHASE_DATE == null ? null : PURCHASE_DATE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.DEST_AMOUNT
     *
     * @return the value of ATM_BASE2_HISTORY.DEST_AMOUNT
     */
    public String getDEST_AMOUNT() {
        return DEST_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.DEST_AMOUNT
     *
     * @param DEST_AMOUNT the value for ATM_BASE2_HISTORY.DEST_AMOUNT
     */
    public void setDEST_AMOUNT(String DEST_AMOUNT) {
        this.DEST_AMOUNT = DEST_AMOUNT == null ? null : DEST_AMOUNT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.DEST_CY
     *
     * @return the value of ATM_BASE2_HISTORY.DEST_CY
     */
    public String getDEST_CY() {
        return DEST_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.DEST_CY
     *
     * @param DEST_CY the value for ATM_BASE2_HISTORY.DEST_CY
     */
    public void setDEST_CY(String DEST_CY) {
        this.DEST_CY = DEST_CY == null ? null : DEST_CY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.SOURCE_AMOUNT
     *
     * @return the value of ATM_BASE2_HISTORY.SOURCE_AMOUNT
     */
    public String getSOURCE_AMOUNT() {
        return SOURCE_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.SOURCE_AMOUNT
     *
     * @param SOURCE_AMOUNT the value for ATM_BASE2_HISTORY.SOURCE_AMOUNT
     */
    public void setSOURCE_AMOUNT(String SOURCE_AMOUNT) {
        this.SOURCE_AMOUNT = SOURCE_AMOUNT == null ? null : SOURCE_AMOUNT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.SOURCE_CY
     *
     * @return the value of ATM_BASE2_HISTORY.SOURCE_CY
     */
    public String getSOURCE_CY() {
        return SOURCE_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.SOURCE_CY
     *
     * @param SOURCE_CY the value for ATM_BASE2_HISTORY.SOURCE_CY
     */
    public void setSOURCE_CY(String SOURCE_CY) {
        this.SOURCE_CY = SOURCE_CY == null ? null : SOURCE_CY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.MERCHANT_NAME
     *
     * @return the value of ATM_BASE2_HISTORY.MERCHANT_NAME
     */
    public String getMERCHANT_NAME() {
        return MERCHANT_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.MERCHANT_NAME
     *
     * @param MERCHANT_NAME the value for ATM_BASE2_HISTORY.MERCHANT_NAME
     */
    public void setMERCHANT_NAME(String MERCHANT_NAME) {
        this.MERCHANT_NAME = MERCHANT_NAME == null ? null : MERCHANT_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.MERCHANT_CITY
     *
     * @return the value of ATM_BASE2_HISTORY.MERCHANT_CITY
     */
    public String getMERCHANT_CITY() {
        return MERCHANT_CITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.MERCHANT_CITY
     *
     * @param MERCHANT_CITY the value for ATM_BASE2_HISTORY.MERCHANT_CITY
     */
    public void setMERCHANT_CITY(String MERCHANT_CITY) {
        this.MERCHANT_CITY = MERCHANT_CITY == null ? null : MERCHANT_CITY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.MERCHANT_COUNTRY
     *
     * @return the value of ATM_BASE2_HISTORY.MERCHANT_COUNTRY
     */
    public String getMERCHANT_COUNTRY() {
        return MERCHANT_COUNTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.MERCHANT_COUNTRY
     *
     * @param MERCHANT_COUNTRY the value for ATM_BASE2_HISTORY.MERCHANT_COUNTRY
     */
    public void setMERCHANT_COUNTRY(String MERCHANT_COUNTRY) {
        this.MERCHANT_COUNTRY = MERCHANT_COUNTRY == null ? null : MERCHANT_COUNTRY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.MERCHANT_CATEGORY
     *
     * @return the value of ATM_BASE2_HISTORY.MERCHANT_CATEGORY
     */
    public String getMERCHANT_CATEGORY() {
        return MERCHANT_CATEGORY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.MERCHANT_CATEGORY
     *
     * @param MERCHANT_CATEGORY the value for ATM_BASE2_HISTORY.MERCHANT_CATEGORY
     */
    public void setMERCHANT_CATEGORY(String MERCHANT_CATEGORY) {
        this.MERCHANT_CATEGORY = MERCHANT_CATEGORY == null ? null : MERCHANT_CATEGORY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.MERCHANT_ZIP
     *
     * @return the value of ATM_BASE2_HISTORY.MERCHANT_ZIP
     */
    public String getMERCHANT_ZIP() {
        return MERCHANT_ZIP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.MERCHANT_ZIP
     *
     * @param MERCHANT_ZIP the value for ATM_BASE2_HISTORY.MERCHANT_ZIP
     */
    public void setMERCHANT_ZIP(String MERCHANT_ZIP) {
        this.MERCHANT_ZIP = MERCHANT_ZIP == null ? null : MERCHANT_ZIP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.MERCHANT_STAT
     *
     * @return the value of ATM_BASE2_HISTORY.MERCHANT_STAT
     */
    public String getMERCHANT_STAT() {
        return MERCHANT_STAT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.MERCHANT_STAT
     *
     * @param MERCHANT_STAT the value for ATM_BASE2_HISTORY.MERCHANT_STAT
     */
    public void setMERCHANT_STAT(String MERCHANT_STAT) {
        this.MERCHANT_STAT = MERCHANT_STAT == null ? null : MERCHANT_STAT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.REQUESTED_PAY
     *
     * @return the value of ATM_BASE2_HISTORY.REQUESTED_PAY
     */
    public String getREQUESTED_PAY() {
        return REQUESTED_PAY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.REQUESTED_PAY
     *
     * @param REQUESTED_PAY the value for ATM_BASE2_HISTORY.REQUESTED_PAY
     */
    public void setREQUESTED_PAY(String REQUESTED_PAY) {
        this.REQUESTED_PAY = REQUESTED_PAY == null ? null : REQUESTED_PAY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.RESERVED
     *
     * @return the value of ATM_BASE2_HISTORY.RESERVED
     */
    public String getRESERVED() {
        return RESERVED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.RESERVED
     *
     * @param RESERVED the value for ATM_BASE2_HISTORY.RESERVED
     */
    public void setRESERVED(String RESERVED) {
        this.RESERVED = RESERVED == null ? null : RESERVED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.USAGE_CODE
     *
     * @return the value of ATM_BASE2_HISTORY.USAGE_CODE
     */
    public String getUSAGE_CODE() {
        return USAGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.USAGE_CODE
     *
     * @param USAGE_CODE the value for ATM_BASE2_HISTORY.USAGE_CODE
     */
    public void setUSAGE_CODE(String USAGE_CODE) {
        this.USAGE_CODE = USAGE_CODE == null ? null : USAGE_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.REASON_CODE
     *
     * @return the value of ATM_BASE2_HISTORY.REASON_CODE
     */
    public String getREASON_CODE() {
        return REASON_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.REASON_CODE
     *
     * @param REASON_CODE the value for ATM_BASE2_HISTORY.REASON_CODE
     */
    public void setREASON_CODE(String REASON_CODE) {
        this.REASON_CODE = REASON_CODE == null ? null : REASON_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.SETTL
     *
     * @return the value of ATM_BASE2_HISTORY.SETTL
     */
    public String getSETTL() {
        return SETTL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.SETTL
     *
     * @param SETTL the value for ATM_BASE2_HISTORY.SETTL
     */
    public void setSETTL(String SETTL) {
        this.SETTL = SETTL == null ? null : SETTL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.ACI
     *
     * @return the value of ATM_BASE2_HISTORY.ACI
     */
    public String getACI() {
        return ACI;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.ACI
     *
     * @param ACI the value for ATM_BASE2_HISTORY.ACI
     */
    public void setACI(String ACI) {
        this.ACI = ACI == null ? null : ACI.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.AUTH_CODE
     *
     * @return the value of ATM_BASE2_HISTORY.AUTH_CODE
     */
    public String getAUTH_CODE() {
        return AUTH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.AUTH_CODE
     *
     * @param AUTH_CODE the value for ATM_BASE2_HISTORY.AUTH_CODE
     */
    public void setAUTH_CODE(String AUTH_CODE) {
        this.AUTH_CODE = AUTH_CODE == null ? null : AUTH_CODE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.POS_TERMINAL
     *
     * @return the value of ATM_BASE2_HISTORY.POS_TERMINAL
     */
    public String getPOS_TERMINAL() {
        return POS_TERMINAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.POS_TERMINAL
     *
     * @param POS_TERMINAL the value for ATM_BASE2_HISTORY.POS_TERMINAL
     */
    public void setPOS_TERMINAL(String POS_TERMINAL) {
        this.POS_TERMINAL = POS_TERMINAL == null ? null : POS_TERMINAL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.INTERN_FEE
     *
     * @return the value of ATM_BASE2_HISTORY.INTERN_FEE
     */
    public String getINTERN_FEE() {
        return INTERN_FEE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.INTERN_FEE
     *
     * @param INTERN_FEE the value for ATM_BASE2_HISTORY.INTERN_FEE
     */
    public void setINTERN_FEE(String INTERN_FEE) {
        this.INTERN_FEE = INTERN_FEE == null ? null : INTERN_FEE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.CARD_ID
     *
     * @return the value of ATM_BASE2_HISTORY.CARD_ID
     */
    public String getCARD_ID() {
        return CARD_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.CARD_ID
     *
     * @param CARD_ID the value for ATM_BASE2_HISTORY.CARD_ID
     */
    public void setCARD_ID(String CARD_ID) {
        this.CARD_ID = CARD_ID == null ? null : CARD_ID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.COLLECTION
     *
     * @return the value of ATM_BASE2_HISTORY.COLLECTION
     */
    public String getCOLLECTION() {
        return COLLECTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.COLLECTION
     *
     * @param COLLECTION the value for ATM_BASE2_HISTORY.COLLECTION
     */
    public void setCOLLECTION(String COLLECTION) {
        this.COLLECTION = COLLECTION == null ? null : COLLECTION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.POS
     *
     * @return the value of ATM_BASE2_HISTORY.POS
     */
    public String getPOS() {
        return POS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.POS
     *
     * @param POS the value for ATM_BASE2_HISTORY.POS
     */
    public void setPOS(String POS) {
        this.POS = POS == null ? null : POS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.CENTRAL_PROC
     *
     * @return the value of ATM_BASE2_HISTORY.CENTRAL_PROC
     */
    public String getCENTRAL_PROC() {
        return CENTRAL_PROC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.CENTRAL_PROC
     *
     * @param CENTRAL_PROC the value for ATM_BASE2_HISTORY.CENTRAL_PROC
     */
    public void setCENTRAL_PROC(String CENTRAL_PROC) {
        this.CENTRAL_PROC = CENTRAL_PROC == null ? null : CENTRAL_PROC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ATM_BASE2_HISTORY.REIMB_ATT
     *
     * @return the value of ATM_BASE2_HISTORY.REIMB_ATT
     */
    public String getREIMB_ATT() {
        return REIMB_ATT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ATM_BASE2_HISTORY.REIMB_ATT
     *
     * @param REIMB_ATT the value for ATM_BASE2_HISTORY.REIMB_ATT
     */
    public void setREIMB_ATT(String REIMB_ATT) {
        this.REIMB_ATT = REIMB_ATT == null ? null : REIMB_ATT.trim();
    }
    public BigDecimal getATM_TRX_NO()
    {
        return ATM_TRX_NO;
    }

    public void setATM_TRX_NO(BigDecimal aTM_TRX_NO)
    {
        ATM_TRX_NO = aTM_TRX_NO;
    }

    public BigDecimal getBASE1_TRX_NO()
    {
        return BASE1_TRX_NO;
    }

    public void setBASE1_TRX_NO(BigDecimal bASE1_TRX_NO)
    {
        BASE1_TRX_NO = bASE1_TRX_NO;
    }

    public BigDecimal getBATCH_NO()
    {
        return BATCH_NO;
    }

    public void setBATCH_NO(BigDecimal bATCH_NO)
    {
        BATCH_NO = bATCH_NO;
    }

    public String getDATA_LINE_00()
    {
        return DATA_LINE_00;
    }

    public void setDATA_LINE_00(String dATA_LINE_00)
    {
        DATA_LINE_00 = dATA_LINE_00;
    }

    public String getDATA_LINE_01()
    {
        return DATA_LINE_01;
    }

    public void setDATA_LINE_01(String dATA_LINE_01)
    {
        DATA_LINE_01 = dATA_LINE_01;
    }

    public String getDATA_LINE_05()
    {
        return DATA_LINE_05;
    }

    public void setDATA_LINE_05(String dATA_LINE_05)
    {
        DATA_LINE_05 = dATA_LINE_05;
    }

    public BigDecimal getDECIMAL_AMOUNT()
    {
        return DECIMAL_AMOUNT;
    }

    public void setDECIMAL_AMOUNT(BigDecimal dECIMAL_AMOUNT)
    {
        DECIMAL_AMOUNT = dECIMAL_AMOUNT;
    }

    public BigDecimal getISO_INTERFACE()
    {
        return ISO_INTERFACE;
    }

    public void setISO_INTERFACE(BigDecimal iSO_INTERFACE)
    {
        ISO_INTERFACE = iSO_INTERFACE;
    }

    public Date getMATCH_DATE()
    {
        return MATCH_DATE;
    }

    public void setMATCH_DATE(Date mATCH_DATE)
    {
        MATCH_DATE = mATCH_DATE;
    }

    public BigDecimal getNB_OF_MATCHING()
    {
        return NB_OF_MATCHING;
    }

    public void setNB_OF_MATCHING(BigDecimal nB_OF_MATCHING)
    {
        NB_OF_MATCHING = nB_OF_MATCHING;
    }

    public BigDecimal getNEW_TRX_BR()
    {
        return NEW_TRX_BR;
    }

    public void setNEW_TRX_BR(BigDecimal nEW_TRX_BR)
    {
        NEW_TRX_BR = nEW_TRX_BR;
    }

    public BigDecimal getNEW_TRX_NO()
    {
        return NEW_TRX_NO;
    }

    public void setNEW_TRX_NO(BigDecimal nEW_TRX_NO)
    {
        NEW_TRX_NO = nEW_TRX_NO;
    }

    public String getSTATE_ON_MATCH()
    {
        return STATE_ON_MATCH;
    }

    public void setSTATE_ON_MATCH(String sTATE_ON_MATCH)
    {
        STATE_ON_MATCH = sTATE_ON_MATCH;
    }

    public String getSTATE_ON_PROCESS()
    {
        return STATE_ON_PROCESS;
    }

    public void setSTATE_ON_PROCESS(String sTATE_ON_PROCESS)
    {
        STATE_ON_PROCESS = sTATE_ON_PROCESS;
    }

    public String getTC_92()
    {
        return TC_92;
    }

    public void setTC_92(String tC_92)
    {
        TC_92 = tC_92;
    }

    public String getTRS_SEQUENCE2()
    {
        return TRS_SEQUENCE2;
    }

    public void setTRS_SEQUENCE2(String tRS_SEQUENCE2)
    {
        TRS_SEQUENCE2 = tRS_SEQUENCE2;
    }

    public String getTRS_SEQUENCE3()
    {
        return TRS_SEQUENCE3;
    }

    public void setTRS_SEQUENCE3(String tRS_SEQUENCE3)
    {
        TRS_SEQUENCE3 = tRS_SEQUENCE3;
    }

    public String getTRX_SEQ_NO()
    {
        return TRX_SEQ_NO;
    }

    public void setTRX_SEQ_NO(String tRX_SEQ_NO)
    {
        TRX_SEQ_NO = tRX_SEQ_NO;
    }

    public String getSOURCE_CY3()
    {
        return SOURCE_CY3;
    }

    public void setSOURCE_CY3(String sOURCE_CY3)
    {
        SOURCE_CY3 = sOURCE_CY3;
    }

    public String getSOURCE_AMOUNT3()
    {
        return SOURCE_AMOUNT3;
    }

    public void setSOURCE_AMOUNT3(String sOURCE_AMOUNT3)
    {
        SOURCE_AMOUNT3 = sOURCE_AMOUNT3;
    }

    public Date getPROCESS_DATE()
    {
        return PROCESS_DATE;
    }

    public void setPROCESS_DATE(Date pROCESS_DATE)
    {
        PROCESS_DATE = pROCESS_DATE;
    }

    public String getTRX_SEQ_TOTAL()
    {
        return TRX_SEQ_TOTAL;
    }

    public void setTRX_SEQ_TOTAL(String tRX_SEQ_TOTAL)
    {
        TRX_SEQ_TOTAL = tRX_SEQ_TOTAL;
    }

    public String getREVERSED_SEQUENCE()
    {
        return REVERSED_SEQUENCE;
    }

    public void setREVERSED_SEQUENCE(String rEVERSED_SEQUENCE)
    {
        REVERSED_SEQUENCE = rEVERSED_SEQUENCE;
    }

    public String getPROCESSED_BY()
    {
        return PROCESSED_BY;
    }

    public void setPROCESSED_BY(String pROCESSED_BY)
    {
        PROCESSED_BY = pROCESSED_BY;
    }

    public String getFORCE_POST()
    {
        return FORCE_POST;
    }

    public void setFORCE_POST(String fORCE_POST)
    {
        FORCE_POST = fORCE_POST;
    }

    public String getFORCE_DEBIT()
    {
        return FORCE_DEBIT;
    }

    public void setFORCE_DEBIT(String fORCE_DEBIT)
    {
        FORCE_DEBIT = fORCE_DEBIT;
    }

    public Date getUPLOAD_DATE()
    {
        return UPLOAD_DATE;
    }

    public void setUPLOAD_DATE(Date uPLOAD_DATE)
    {
        UPLOAD_DATE = uPLOAD_DATE;
    }

    public String getADDITIONAL_REFERENCE()
    {
        return ADDITIONAL_REFERENCE;
    }

    public void setADDITIONAL_REFERENCE(String aDDITIONAL_REFERENCE)
    {
        ADDITIONAL_REFERENCE = aDDITIONAL_REFERENCE;
    }

    public String getSAME_AMOUNT()
    {
        return SAME_AMOUNT;
    }

    public void setSAME_AMOUNT(String sAME_AMOUNT)
    {
        SAME_AMOUNT = sAME_AMOUNT;
    }

    public String getREV_SAME_FILE()
    {
        return REV_SAME_FILE;
    }

    public void setREV_SAME_FILE(String rEV_SAME_FILE)
    {
        REV_SAME_FILE = rEV_SAME_FILE;
    }

    public String getRELEASE_STATE()
    {
        return RELEASE_STATE;
    }

    public void setRELEASE_STATE(String rELEASE_STATE)
    {
        RELEASE_STATE = rELEASE_STATE;
    }

    public BigDecimal getMATCH_REV_SEQUENCE()
    {
        return MATCH_REV_SEQUENCE;
    }

    public void setMATCH_REV_SEQUENCE(BigDecimal mATCH_REV_SEQUENCE)
    {
        MATCH_REV_SEQUENCE = mATCH_REV_SEQUENCE;
    }

    public String getNO_BALANCE_YN()
    {
        return NO_BALANCE_YN;
    }

    public void setNO_BALANCE(String nO_BALANCE_YN)
    {
        NO_BALANCE_YN = nO_BALANCE_YN;
    }
    
    public String getDUPLICATE_BASE1_YN()
    {
        return DUPLICATE_BASE1_YN;
    }

    public void setDUPLICATE_BASE1_YN(String dUPLICATE_BASE1_YN)
    {
	DUPLICATE_BASE1_YN = dUPLICATE_BASE1_YN;
    }

    public String getUSER_ID()
    {
        return USER_ID;
    }

    public void setUSER_ID(String uSER_ID)
    {
        USER_ID = uSER_ID;
    }

    public void setNO_BALANCE_YN(String nO_BALANCE_YN)
    {
        NO_BALANCE_YN = nO_BALANCE_YN;
    }
    
    
}