package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class IRP_REP_ARGUMENTSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column IRP_REP_ARGUMENTS.ARGUMENT_ID
     */
    private BigDecimal ARGUMENT_ID;

    /**
     * This field corresponds to the database column IRP_REP_ARGUMENTS.REPORT_ID
     */
    private BigDecimal REPORT_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_REP_ARGUMENTS.ARGUMENT_ID
     *
     * @return the value of IRP_REP_ARGUMENTS.ARGUMENT_ID
     */
    public BigDecimal getARGUMENT_ID() {
        return ARGUMENT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_REP_ARGUMENTS.ARGUMENT_ID
     *
     * @param ARGUMENT_ID the value for IRP_REP_ARGUMENTS.ARGUMENT_ID
     */
    public void setARGUMENT_ID(BigDecimal ARGUMENT_ID) {
        this.ARGUMENT_ID = ARGUMENT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_REP_ARGUMENTS.REPORT_ID
     *
     * @return the value of IRP_REP_ARGUMENTS.REPORT_ID
     */
    public BigDecimal getREPORT_ID() {
        return REPORT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_REP_ARGUMENTS.REPORT_ID
     *
     * @param REPORT_ID the value for IRP_REP_ARGUMENTS.REPORT_ID
     */
    public void setREPORT_ID(BigDecimal REPORT_ID) {
        this.REPORT_ID = REPORT_ID;
    }
}