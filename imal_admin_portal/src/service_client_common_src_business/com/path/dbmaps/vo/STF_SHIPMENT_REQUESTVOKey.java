package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class STF_SHIPMENT_REQUESTVOKey extends BaseVO {
    /**
     * This field corresponds to the database column STF_SHIPMENT_REQUEST.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column STF_SHIPMENT_REQUEST.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column STF_SHIPMENT_REQUEST.SHIPMENT_REQUEST_NO
     */
    private BigDecimal SHIPMENT_REQUEST_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column STF_SHIPMENT_REQUEST.BRANCH_CODE
     *
     * @return the value of STF_SHIPMENT_REQUEST.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column STF_SHIPMENT_REQUEST.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for STF_SHIPMENT_REQUEST.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column STF_SHIPMENT_REQUEST.COMP_CODE
     *
     * @return the value of STF_SHIPMENT_REQUEST.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column STF_SHIPMENT_REQUEST.COMP_CODE
     *
     * @param COMP_CODE the value for STF_SHIPMENT_REQUEST.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column STF_SHIPMENT_REQUEST.SHIPMENT_REQUEST_NO
     *
     * @return the value of STF_SHIPMENT_REQUEST.SHIPMENT_REQUEST_NO
     */
    public BigDecimal getSHIPMENT_REQUEST_NO() {
        return SHIPMENT_REQUEST_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column STF_SHIPMENT_REQUEST.SHIPMENT_REQUEST_NO
     *
     * @param SHIPMENT_REQUEST_NO the value for STF_SHIPMENT_REQUEST.SHIPMENT_REQUEST_NO
     */
    public void setSHIPMENT_REQUEST_NO(BigDecimal SHIPMENT_REQUEST_NO) {
        this.SHIPMENT_REQUEST_NO = SHIPMENT_REQUEST_NO;
    }
}