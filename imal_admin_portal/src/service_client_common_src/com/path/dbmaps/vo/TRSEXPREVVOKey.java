package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSEXPREVVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSEXPREV.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column TRSEXPREV.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSEXPREV.CODE
     *
     * @return the value of TRSEXPREV.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSEXPREV.CODE
     *
     * @param CODE the value for TRSEXPREV.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSEXPREV.COMP_CODE
     *
     * @return the value of TRSEXPREV.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSEXPREV.COMP_CODE
     *
     * @param COMP_CODE the value for TRSEXPREV.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}