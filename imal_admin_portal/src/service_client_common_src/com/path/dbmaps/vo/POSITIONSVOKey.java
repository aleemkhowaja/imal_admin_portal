package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class POSITIONSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column POSITIONS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column POSITIONS.POSITION_CODE
     */
    private BigDecimal POSITION_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.COMP_CODE
     *
     * @return the value of POSITIONS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.COMP_CODE
     *
     * @param COMP_CODE the value for POSITIONS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSITIONS.POSITION_CODE
     *
     * @return the value of POSITIONS.POSITION_CODE
     */
    public BigDecimal getPOSITION_CODE() {
        return POSITION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSITIONS.POSITION_CODE
     *
     * @param POSITION_CODE the value for POSITIONS.POSITION_CODE
     */
    public void setPOSITION_CODE(BigDecimal POSITION_CODE) {
        this.POSITION_CODE = POSITION_CODE;
    }
}