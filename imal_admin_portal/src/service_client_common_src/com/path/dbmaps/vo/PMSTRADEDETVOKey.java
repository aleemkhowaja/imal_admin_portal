package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class PMSTRADEDETVOKey extends BaseVO {
    /**
     * This field corresponds to the database column PMSTRADEDET.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column PMSTRADEDET.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column PMSTRADEDET.LINE_NBR
     */
    private BigDecimal LINE_NBR;

    /**
     * This field corresponds to the database column PMSTRADEDET.TRADE_SERIAL_NBR
     */
    private BigDecimal TRADE_SERIAL_NBR;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSTRADEDET.BRANCH
     *
     * @return the value of PMSTRADEDET.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSTRADEDET.BRANCH
     *
     * @param BRANCH the value for PMSTRADEDET.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSTRADEDET.COMP_CODE
     *
     * @return the value of PMSTRADEDET.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSTRADEDET.COMP_CODE
     *
     * @param COMP_CODE the value for PMSTRADEDET.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSTRADEDET.LINE_NBR
     *
     * @return the value of PMSTRADEDET.LINE_NBR
     */
    public BigDecimal getLINE_NBR() {
        return LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSTRADEDET.LINE_NBR
     *
     * @param LINE_NBR the value for PMSTRADEDET.LINE_NBR
     */
    public void setLINE_NBR(BigDecimal LINE_NBR) {
        this.LINE_NBR = LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSTRADEDET.TRADE_SERIAL_NBR
     *
     * @return the value of PMSTRADEDET.TRADE_SERIAL_NBR
     */
    public BigDecimal getTRADE_SERIAL_NBR() {
        return TRADE_SERIAL_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSTRADEDET.TRADE_SERIAL_NBR
     *
     * @param TRADE_SERIAL_NBR the value for PMSTRADEDET.TRADE_SERIAL_NBR
     */
    public void setTRADE_SERIAL_NBR(BigDecimal TRADE_SERIAL_NBR) {
        this.TRADE_SERIAL_NBR = TRADE_SERIAL_NBR;
    }
}