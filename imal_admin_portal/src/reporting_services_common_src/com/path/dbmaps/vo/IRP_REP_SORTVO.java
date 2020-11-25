package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class IRP_REP_SORTVO extends BaseVO {
    /**
     * This field corresponds to the database column IRP_REP_SORT.FIELD_DESC
     */
    private String FIELD_DESC;

    /**
     * This field corresponds to the database column IRP_REP_SORT.FIELD_ORDER
     */
    private String FIELD_ORDER;

    /**
     * This field corresponds to the database column IRP_REP_SORT.REPORT_ID
     */
    private BigDecimal REPORT_ID;

    /**
     * This field corresponds to the database column IRP_REP_SORT.USER_ID
     */
    private String USER_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_REP_SORT.FIELD_DESC
     *
     * @return the value of IRP_REP_SORT.FIELD_DESC
     */
    public String getFIELD_DESC() {
        return FIELD_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_REP_SORT.FIELD_DESC
     *
     * @param FIELD_DESC the value for IRP_REP_SORT.FIELD_DESC
     */
    public void setFIELD_DESC(String FIELD_DESC) {
        this.FIELD_DESC = FIELD_DESC == null ? null : FIELD_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_REP_SORT.FIELD_ORDER
     *
     * @return the value of IRP_REP_SORT.FIELD_ORDER
     */
    public String getFIELD_ORDER() {
        return FIELD_ORDER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_REP_SORT.FIELD_ORDER
     *
     * @param FIELD_ORDER the value for IRP_REP_SORT.FIELD_ORDER
     */
    public void setFIELD_ORDER(String FIELD_ORDER) {
        this.FIELD_ORDER = FIELD_ORDER == null ? null : FIELD_ORDER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_REP_SORT.REPORT_ID
     *
     * @return the value of IRP_REP_SORT.REPORT_ID
     */
    public BigDecimal getREPORT_ID() {
        return REPORT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_REP_SORT.REPORT_ID
     *
     * @param REPORT_ID the value for IRP_REP_SORT.REPORT_ID
     */
    public void setREPORT_ID(BigDecimal REPORT_ID) {
        this.REPORT_ID = REPORT_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IRP_REP_SORT.USER_ID
     *
     * @return the value of IRP_REP_SORT.USER_ID
     */
    public String getUSER_ID() {
        return USER_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IRP_REP_SORT.USER_ID
     *
     * @param USER_ID the value for IRP_REP_SORT.USER_ID
     */
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID == null ? null : USER_ID.trim();
    }
}