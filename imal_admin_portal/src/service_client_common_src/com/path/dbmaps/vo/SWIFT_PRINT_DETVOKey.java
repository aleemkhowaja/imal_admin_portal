package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SWIFT_PRINT_DETVOKey extends BaseVO {
    /**
     * This field corresponds to the database column SWIFT_PRINT_DET.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column SWIFT_PRINT_DET.MODULE
     */
    private String MODULE;

    /**
     * This field corresponds to the database column SWIFT_PRINT_DET.PROG_REF
     */
    private String PROG_REF;

    /**
     * This field corresponds to the database column SWIFT_PRINT_DET.PROG_TYPE
     */
    private String PROG_TYPE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_PRINT_DET.LINE_NO
     *
     * @return the value of SWIFT_PRINT_DET.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_PRINT_DET.LINE_NO
     *
     * @param LINE_NO the value for SWIFT_PRINT_DET.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_PRINT_DET.MODULE
     *
     * @return the value of SWIFT_PRINT_DET.MODULE
     */
    public String getMODULE() {
        return MODULE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_PRINT_DET.MODULE
     *
     * @param MODULE the value for SWIFT_PRINT_DET.MODULE
     */
    public void setMODULE(String MODULE) {
        this.MODULE = MODULE == null ? null : MODULE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_PRINT_DET.PROG_REF
     *
     * @return the value of SWIFT_PRINT_DET.PROG_REF
     */
    public String getPROG_REF() {
        return PROG_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_PRINT_DET.PROG_REF
     *
     * @param PROG_REF the value for SWIFT_PRINT_DET.PROG_REF
     */
    public void setPROG_REF(String PROG_REF) {
        this.PROG_REF = PROG_REF == null ? null : PROG_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_PRINT_DET.PROG_TYPE
     *
     * @return the value of SWIFT_PRINT_DET.PROG_TYPE
     */
    public String getPROG_TYPE() {
        return PROG_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_PRINT_DET.PROG_TYPE
     *
     * @param PROG_TYPE the value for SWIFT_PRINT_DET.PROG_TYPE
     */
    public void setPROG_TYPE(String PROG_TYPE) {
        this.PROG_TYPE = PROG_TYPE == null ? null : PROG_TYPE.trim();
    }
}