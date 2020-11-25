package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSSETLMTVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSSETLMT.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column TRSSETLMT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRSSETLMT.SETTLEMENT_NBR
     */
    private BigDecimal SETTLEMENT_NBR;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSSETLMT.BRANCH
     *
     * @return the value of TRSSETLMT.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSSETLMT.BRANCH
     *
     * @param BRANCH the value for TRSSETLMT.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSSETLMT.COMP_CODE
     *
     * @return the value of TRSSETLMT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSSETLMT.COMP_CODE
     *
     * @param COMP_CODE the value for TRSSETLMT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSSETLMT.SETTLEMENT_NBR
     *
     * @return the value of TRSSETLMT.SETTLEMENT_NBR
     */
    public BigDecimal getSETTLEMENT_NBR() {
        return SETTLEMENT_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSSETLMT.SETTLEMENT_NBR
     *
     * @param SETTLEMENT_NBR the value for TRSSETLMT.SETTLEMENT_NBR
     */
    public void setSETTLEMENT_NBR(BigDecimal SETTLEMENT_NBR) {
        this.SETTLEMENT_NBR = SETTLEMENT_NBR;
    }
}