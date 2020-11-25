package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class CTSMICRDETVO extends CTSMICRDETVOKey {
    /**
     * This field corresponds to the database column CTSMICRDET.LINE_SEQ
     */
    private BigDecimal LINE_SEQ;

    /**
     * This field corresponds to the database column CTSMICRDET.POS1
     */
    private BigDecimal POS1;

    /**
     * This field corresponds to the database column CTSMICRDET.LEN1
     */
    private BigDecimal LEN1;

    /**
     * This field corresponds to the database column CTSMICRDET.FIED_TYPE
     */
    private String FIED_TYPE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSMICRDET.LINE_SEQ
     *
     * @return the value of CTSMICRDET.LINE_SEQ
     */
    public BigDecimal getLINE_SEQ() {
        return LINE_SEQ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSMICRDET.LINE_SEQ
     *
     * @param LINE_SEQ the value for CTSMICRDET.LINE_SEQ
     */
    public void setLINE_SEQ(BigDecimal LINE_SEQ) {
        this.LINE_SEQ = LINE_SEQ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSMICRDET.POS1
     *
     * @return the value of CTSMICRDET.POS1
     */
    public BigDecimal getPOS1() {
        return POS1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSMICRDET.POS1
     *
     * @param POS1 the value for CTSMICRDET.POS1
     */
    public void setPOS1(BigDecimal POS1) {
        this.POS1 = POS1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSMICRDET.LEN1
     *
     * @return the value of CTSMICRDET.LEN1
     */
    public BigDecimal getLEN1() {
        return LEN1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSMICRDET.LEN1
     *
     * @param LEN1 the value for CTSMICRDET.LEN1
     */
    public void setLEN1(BigDecimal LEN1) {
        this.LEN1 = LEN1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSMICRDET.FIED_TYPE
     *
     * @return the value of CTSMICRDET.FIED_TYPE
     */
    public String getFIED_TYPE() {
        return FIED_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSMICRDET.FIED_TYPE
     *
     * @param FIED_TYPE the value for CTSMICRDET.FIED_TYPE
     */
    public void setFIED_TYPE(String FIED_TYPE) {
        this.FIED_TYPE = FIED_TYPE == null ? null : FIED_TYPE.trim();
    }
}