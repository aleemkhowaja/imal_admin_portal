package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSCONTRIB_SWITCHVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSCONTRIB_SWITCH.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRSCONTRIB_SWITCH.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column TRSCONTRIB_SWITCH.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRSCONTRIB_SWITCH.SERIAL_NO
     */
    private BigDecimal SERIAL_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCONTRIB_SWITCH.BRANCH_CODE
     *
     * @return the value of TRSCONTRIB_SWITCH.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCONTRIB_SWITCH.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRSCONTRIB_SWITCH.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCONTRIB_SWITCH.CODE
     *
     * @return the value of TRSCONTRIB_SWITCH.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCONTRIB_SWITCH.CODE
     *
     * @param CODE the value for TRSCONTRIB_SWITCH.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCONTRIB_SWITCH.COMP_CODE
     *
     * @return the value of TRSCONTRIB_SWITCH.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCONTRIB_SWITCH.COMP_CODE
     *
     * @param COMP_CODE the value for TRSCONTRIB_SWITCH.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCONTRIB_SWITCH.SERIAL_NO
     *
     * @return the value of TRSCONTRIB_SWITCH.SERIAL_NO
     */
    public BigDecimal getSERIAL_NO() {
        return SERIAL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCONTRIB_SWITCH.SERIAL_NO
     *
     * @param SERIAL_NO the value for TRSCONTRIB_SWITCH.SERIAL_NO
     */
    public void setSERIAL_NO(BigDecimal SERIAL_NO) {
        this.SERIAL_NO = SERIAL_NO;
    }
}