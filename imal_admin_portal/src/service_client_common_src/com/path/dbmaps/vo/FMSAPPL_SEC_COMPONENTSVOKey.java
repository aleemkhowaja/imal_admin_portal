package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class FMSAPPL_SEC_COMPONENTSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column FMSAPPL_SEC_COMPONENTS.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column FMSAPPL_SEC_COMPONENTS.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column FMSAPPL_SEC_COMPONENTS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column FMSAPPL_SEC_COMPONENTS.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_SEC_COMPONENTS.BRANCH
     *
     * @return the value of FMSAPPL_SEC_COMPONENTS.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_SEC_COMPONENTS.BRANCH
     *
     * @param BRANCH the value for FMSAPPL_SEC_COMPONENTS.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_SEC_COMPONENTS.CODE
     *
     * @return the value of FMSAPPL_SEC_COMPONENTS.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_SEC_COMPONENTS.CODE
     *
     * @param CODE the value for FMSAPPL_SEC_COMPONENTS.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_SEC_COMPONENTS.COMP_CODE
     *
     * @return the value of FMSAPPL_SEC_COMPONENTS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_SEC_COMPONENTS.COMP_CODE
     *
     * @param COMP_CODE the value for FMSAPPL_SEC_COMPONENTS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPL_SEC_COMPONENTS.LINE_NO
     *
     * @return the value of FMSAPPL_SEC_COMPONENTS.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPL_SEC_COMPONENTS.LINE_NO
     *
     * @param LINE_NO the value for FMSAPPL_SEC_COMPONENTS.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }
}