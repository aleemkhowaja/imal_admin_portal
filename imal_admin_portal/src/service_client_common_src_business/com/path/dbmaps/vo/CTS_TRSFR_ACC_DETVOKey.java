package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_TRSFR_ACC_DETVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_TRSFR_ACC_DET.BATCH_LINE_NO
     */
    private BigDecimal BATCH_LINE_NO;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC_DET.BATCH_NO
     */
    private BigDecimal BATCH_NO;

    /**
     * This field corresponds to the database column CTS_TRSFR_ACC_DET.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC_DET.BATCH_LINE_NO
     *
     * @return the value of CTS_TRSFR_ACC_DET.BATCH_LINE_NO
     */
    public BigDecimal getBATCH_LINE_NO() {
        return BATCH_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC_DET.BATCH_LINE_NO
     *
     * @param BATCH_LINE_NO the value for CTS_TRSFR_ACC_DET.BATCH_LINE_NO
     */
    public void setBATCH_LINE_NO(BigDecimal BATCH_LINE_NO) {
        this.BATCH_LINE_NO = BATCH_LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC_DET.BATCH_NO
     *
     * @return the value of CTS_TRSFR_ACC_DET.BATCH_NO
     */
    public BigDecimal getBATCH_NO() {
        return BATCH_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC_DET.BATCH_NO
     *
     * @param BATCH_NO the value for CTS_TRSFR_ACC_DET.BATCH_NO
     */
    public void setBATCH_NO(BigDecimal BATCH_NO) {
        this.BATCH_NO = BATCH_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_TRSFR_ACC_DET.COMP_CODE
     *
     * @return the value of CTS_TRSFR_ACC_DET.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_TRSFR_ACC_DET.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_TRSFR_ACC_DET.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}