package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class S_LINK_CIF_AMFVOKey extends BaseVO {
    /**
     * This field corresponds to the database column S_LINK_CIF_AMF.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column S_LINK_CIF_AMF.LINK_CODE
     */
    private BigDecimal LINK_CODE;

    /**
     * This field corresponds to the database column S_LINK_CIF_AMF.LINK_SERIAL
     */
    private BigDecimal LINK_SERIAL;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_LINK_CIF_AMF.COMP_CODE
     *
     * @return the value of S_LINK_CIF_AMF.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_LINK_CIF_AMF.COMP_CODE
     *
     * @param COMP_CODE the value for S_LINK_CIF_AMF.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_LINK_CIF_AMF.LINK_CODE
     *
     * @return the value of S_LINK_CIF_AMF.LINK_CODE
     */
    public BigDecimal getLINK_CODE() {
        return LINK_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_LINK_CIF_AMF.LINK_CODE
     *
     * @param LINK_CODE the value for S_LINK_CIF_AMF.LINK_CODE
     */
    public void setLINK_CODE(BigDecimal LINK_CODE) {
        this.LINK_CODE = LINK_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_LINK_CIF_AMF.LINK_SERIAL
     *
     * @return the value of S_LINK_CIF_AMF.LINK_SERIAL
     */
    public BigDecimal getLINK_SERIAL() {
        return LINK_SERIAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_LINK_CIF_AMF.LINK_SERIAL
     *
     * @param LINK_SERIAL the value for S_LINK_CIF_AMF.LINK_SERIAL
     */
    public void setLINK_SERIAL(BigDecimal LINK_SERIAL) {
        this.LINK_SERIAL = LINK_SERIAL;
    }
}