package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSCHARGESVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSCHARGES.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column TRSCHARGES.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCHARGES.CODE
     *
     * @return the value of TRSCHARGES.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCHARGES.CODE
     *
     * @param CODE the value for TRSCHARGES.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCHARGES.COMP_CODE
     *
     * @return the value of TRSCHARGES.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCHARGES.COMP_CODE
     *
     * @param COMP_CODE the value for TRSCHARGES.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}