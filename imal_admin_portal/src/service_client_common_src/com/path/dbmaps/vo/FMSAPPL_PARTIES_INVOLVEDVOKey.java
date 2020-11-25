package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class FMSAPPL_PARTIES_INVOLVEDVOKey extends BaseVO {
    /**
     * This field corresponds to the database column FMSAPPL_PARTIES_INVOLVED.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column FMSAPPL_PARTIES_INVOLVED.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column FMSAPPL_PARTIES_INVOLVED.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column FMSAPPL_PARTIES_INVOLVED.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_PARTIES_INVOLVED.BRANCH
     *
     * @return the value of FMSAPPL_PARTIES_INVOLVED.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_PARTIES_INVOLVED.BRANCH
     *
     * @param BRANCH the value for FMSAPPL_PARTIES_INVOLVED.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_PARTIES_INVOLVED.CODE
     *
     * @return the value of FMSAPPL_PARTIES_INVOLVED.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_PARTIES_INVOLVED.CODE
     *
     * @param CODE the value for FMSAPPL_PARTIES_INVOLVED.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_PARTIES_INVOLVED.COMP_CODE
     *
     * @return the value of FMSAPPL_PARTIES_INVOLVED.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_PARTIES_INVOLVED.COMP_CODE
     *
     * @param COMP_CODE the value for FMSAPPL_PARTIES_INVOLVED.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_PARTIES_INVOLVED.LINE_NO
     *
     * @return the value of FMSAPPL_PARTIES_INVOLVED.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_PARTIES_INVOLVED.LINE_NO
     *
     * @param LINE_NO the value for FMSAPPL_PARTIES_INVOLVED.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }
}