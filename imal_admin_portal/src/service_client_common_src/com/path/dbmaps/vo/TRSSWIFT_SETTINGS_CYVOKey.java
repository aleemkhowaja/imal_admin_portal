package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSSWIFT_SETTINGS_CYVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSSWIFT_SETTINGS_CY.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRSSWIFT_SETTINGS_CY.LINE_NBR
     */
    private BigDecimal LINE_NBR;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSSWIFT_SETTINGS_CY.COMP_CODE
     *
     * @return the value of TRSSWIFT_SETTINGS_CY.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSSWIFT_SETTINGS_CY.COMP_CODE
     *
     * @param COMP_CODE the value for TRSSWIFT_SETTINGS_CY.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSSWIFT_SETTINGS_CY.LINE_NBR
     *
     * @return the value of TRSSWIFT_SETTINGS_CY.LINE_NBR
     */
    public BigDecimal getLINE_NBR() {
        return LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSSWIFT_SETTINGS_CY.LINE_NBR
     *
     * @param LINE_NBR the value for TRSSWIFT_SETTINGS_CY.LINE_NBR
     */
    public void setLINE_NBR(BigDecimal LINE_NBR) {
        this.LINE_NBR = LINE_NBR;
    }
}