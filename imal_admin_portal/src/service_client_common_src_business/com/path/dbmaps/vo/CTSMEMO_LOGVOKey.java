package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTSMEMO_LOGVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTSMEMO_LOG.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTSMEMO_LOG.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTSMEMO_LOG.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column CTSMEMO_LOG.TRX_NO
     */
    private BigDecimal TRX_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSMEMO_LOG.BRANCH_CODE
     *
     * @return the value of CTSMEMO_LOG.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSMEMO_LOG.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for CTSMEMO_LOG.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSMEMO_LOG.COMP_CODE
     *
     * @return the value of CTSMEMO_LOG.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSMEMO_LOG.COMP_CODE
     *
     * @param COMP_CODE the value for CTSMEMO_LOG.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSMEMO_LOG.LINE_NO
     *
     * @return the value of CTSMEMO_LOG.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSMEMO_LOG.LINE_NO
     *
     * @param LINE_NO the value for CTSMEMO_LOG.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSMEMO_LOG.TRX_NO
     *
     * @return the value of CTSMEMO_LOG.TRX_NO
     */
    public BigDecimal getTRX_NO() {
        return TRX_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSMEMO_LOG.TRX_NO
     *
     * @param TRX_NO the value for CTSMEMO_LOG.TRX_NO
     */
    public void setTRX_NO(BigDecimal TRX_NO) {
        this.TRX_NO = TRX_NO;
    }
}