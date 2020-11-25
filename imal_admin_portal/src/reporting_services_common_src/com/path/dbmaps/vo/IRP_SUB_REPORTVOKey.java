package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class IRP_SUB_REPORTVOKey extends BaseVO {
    /**
     * This field corresponds to the database column IRP_SUB_REPORT.REPORT_ID
     */
    private BigDecimal REPORT_ID;

    /**
     * This field corresponds to the database column IRP_SUB_REPORT.SUB_REPORT_ID
     */
    private BigDecimal SUB_REPORT_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_SUB_REPORT.REPORT_ID
     *
     * @return the value of IRP_SUB_REPORT.REPORT_ID
     */
    public BigDecimal getREPORT_ID() {
        return REPORT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_SUB_REPORT.REPORT_ID
     *
     * @param REPORT_ID the value for IRP_SUB_REPORT.REPORT_ID
     */
    public void setREPORT_ID(BigDecimal REPORT_ID) {
        this.REPORT_ID = REPORT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_SUB_REPORT.SUB_REPORT_ID
     *
     * @return the value of IRP_SUB_REPORT.SUB_REPORT_ID
     */
    public BigDecimal getSUB_REPORT_ID() {
        return SUB_REPORT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_SUB_REPORT.SUB_REPORT_ID
     *
     * @param SUB_REPORT_ID the value for IRP_SUB_REPORT.SUB_REPORT_ID
     */
    public void setSUB_REPORT_ID(BigDecimal SUB_REPORT_ID) {
        this.SUB_REPORT_ID = SUB_REPORT_ID;
    }
}