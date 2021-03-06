package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class S_CONTROL_PARAMVOKey extends BaseVO {
    /**
     * This field corresponds to the database column IMAL141_DEV_O18.S_CONTROL_PARAM.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column IMAL141_DEV_O18.S_CONTROL_PARAM.PROG_REFERENCE
     */
    private String PROG_REFERENCE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IMAL141_DEV_O18.S_CONTROL_PARAM.COMP_CODE
     *
     * @return the value of IMAL141_DEV_O18.S_CONTROL_PARAM.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IMAL141_DEV_O18.S_CONTROL_PARAM.COMP_CODE
     *
     * @param COMP_CODE the value for IMAL141_DEV_O18.S_CONTROL_PARAM.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IMAL141_DEV_O18.S_CONTROL_PARAM.PROG_REFERENCE
     *
     * @return the value of IMAL141_DEV_O18.S_CONTROL_PARAM.PROG_REFERENCE
     */
    public String getPROG_REFERENCE() {
        return PROG_REFERENCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IMAL141_DEV_O18.S_CONTROL_PARAM.PROG_REFERENCE
     *
     * @param PROG_REFERENCE the value for IMAL141_DEV_O18.S_CONTROL_PARAM.PROG_REFERENCE
     */
    public void setPROG_REFERENCE(String PROG_REFERENCE) {
        this.PROG_REFERENCE = PROG_REFERENCE == null ? null : PROG_REFERENCE.trim();
    }
}