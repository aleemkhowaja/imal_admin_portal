package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SWIFT_MSG_REFVOKey extends BaseVO {
    /**
     * This field corresponds to the database column SWIFT_MSG_REF.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column SWIFT_MSG_REF.MODULE
     */
    private String MODULE;

    /**
     * This field corresponds to the database column SWIFT_MSG_REF.MSG_CODE
     */
    private String MSG_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSG_REF.COMP_CODE
     *
     * @return the value of SWIFT_MSG_REF.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSG_REF.COMP_CODE
     *
     * @param COMP_CODE the value for SWIFT_MSG_REF.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSG_REF.MODULE
     *
     * @return the value of SWIFT_MSG_REF.MODULE
     */
    public String getMODULE() {
        return MODULE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSG_REF.MODULE
     *
     * @param MODULE the value for SWIFT_MSG_REF.MODULE
     */
    public void setMODULE(String MODULE) {
        this.MODULE = MODULE == null ? null : MODULE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SWIFT_MSG_REF.MSG_CODE
     *
     * @return the value of SWIFT_MSG_REF.MSG_CODE
     */
    public String getMSG_CODE() {
        return MSG_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SWIFT_MSG_REF.MSG_CODE
     *
     * @param MSG_CODE the value for SWIFT_MSG_REF.MSG_CODE
     */
    public void setMSG_CODE(String MSG_CODE) {
        this.MSG_CODE = MSG_CODE == null ? null : MSG_CODE.trim();
    }
}