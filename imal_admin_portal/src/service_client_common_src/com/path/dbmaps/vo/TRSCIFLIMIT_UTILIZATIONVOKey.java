package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSCIFLIMIT_UTILIZATIONVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSCIFLIMIT_UTILIZATION.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRSCIFLIMIT_UTILIZATION.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRSCIFLIMIT_UTILIZATION.TRX_NO
     */
    private BigDecimal TRX_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCIFLIMIT_UTILIZATION.BRANCH_CODE
     *
     * @return the value of TRSCIFLIMIT_UTILIZATION.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCIFLIMIT_UTILIZATION.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRSCIFLIMIT_UTILIZATION.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCIFLIMIT_UTILIZATION.COMP_CODE
     *
     * @return the value of TRSCIFLIMIT_UTILIZATION.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCIFLIMIT_UTILIZATION.COMP_CODE
     *
     * @param COMP_CODE the value for TRSCIFLIMIT_UTILIZATION.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCIFLIMIT_UTILIZATION.TRX_NO
     *
     * @return the value of TRSCIFLIMIT_UTILIZATION.TRX_NO
     */
    public BigDecimal getTRX_NO() {
        return TRX_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCIFLIMIT_UTILIZATION.TRX_NO
     *
     * @param TRX_NO the value for TRSCIFLIMIT_UTILIZATION.TRX_NO
     */
    public void setTRX_NO(BigDecimal TRX_NO) {
        this.TRX_NO = TRX_NO;
    }
}