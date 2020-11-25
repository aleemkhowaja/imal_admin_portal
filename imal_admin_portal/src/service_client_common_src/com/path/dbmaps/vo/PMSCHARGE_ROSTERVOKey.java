package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class PMSCHARGE_ROSTERVOKey extends BaseVO {
    /**
     * This field corresponds to the database column PMSCHARGE_ROSTER.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column PMSCHARGE_ROSTER.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column PMSCHARGE_ROSTER.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column PMSCHARGE_ROSTER.SEQ
     */
    private BigDecimal SEQ;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCHARGE_ROSTER.BRANCH
     *
     * @return the value of PMSCHARGE_ROSTER.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCHARGE_ROSTER.BRANCH
     *
     * @param BRANCH the value for PMSCHARGE_ROSTER.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCHARGE_ROSTER.CODE
     *
     * @return the value of PMSCHARGE_ROSTER.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCHARGE_ROSTER.CODE
     *
     * @param CODE the value for PMSCHARGE_ROSTER.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCHARGE_ROSTER.COMP_CODE
     *
     * @return the value of PMSCHARGE_ROSTER.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCHARGE_ROSTER.COMP_CODE
     *
     * @param COMP_CODE the value for PMSCHARGE_ROSTER.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCHARGE_ROSTER.SEQ
     *
     * @return the value of PMSCHARGE_ROSTER.SEQ
     */
    public BigDecimal getSEQ() {
        return SEQ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCHARGE_ROSTER.SEQ
     *
     * @param SEQ the value for PMSCHARGE_ROSTER.SEQ
     */
    public void setSEQ(BigDecimal SEQ) {
        this.SEQ = SEQ;
    }
}