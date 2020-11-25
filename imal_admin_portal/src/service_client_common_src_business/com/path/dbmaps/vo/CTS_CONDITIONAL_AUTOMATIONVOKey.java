package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_CONDITIONAL_AUTOMATIONVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_CONDITIONAL_AUTOMATION.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column CTS_CONDITIONAL_AUTOMATION.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CONDITIONAL_AUTOMATION.CODE
     *
     * @return the value of CTS_CONDITIONAL_AUTOMATION.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CONDITIONAL_AUTOMATION.CODE
     *
     * @param CODE the value for CTS_CONDITIONAL_AUTOMATION.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CONDITIONAL_AUTOMATION.COMP_CODE
     *
     * @return the value of CTS_CONDITIONAL_AUTOMATION.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CONDITIONAL_AUTOMATION.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_CONDITIONAL_AUTOMATION.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}