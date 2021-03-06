package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class FMS_TEMPLATE_PARTICIPANT_DTLVOKey extends BaseVO {
    /**
     * This field corresponds to the database column FMS_TEMPLATE_PARTICIPANT_DTL.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column FMS_TEMPLATE_PARTICIPANT_DTL.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column FMS_TEMPLATE_PARTICIPANT_DTL.LINE_NBR
     */
    private BigDecimal LINE_NBR;

    /**
     * This field corresponds to the database column FMS_TEMPLATE_PARTICIPANT_DTL.TEMPLATE_CODE
     */
    private BigDecimal TEMPLATE_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_TEMPLATE_PARTICIPANT_DTL.BRANCH_CODE
     *
     * @return the value of FMS_TEMPLATE_PARTICIPANT_DTL.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_TEMPLATE_PARTICIPANT_DTL.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for FMS_TEMPLATE_PARTICIPANT_DTL.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_TEMPLATE_PARTICIPANT_DTL.COMP_CODE
     *
     * @return the value of FMS_TEMPLATE_PARTICIPANT_DTL.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_TEMPLATE_PARTICIPANT_DTL.COMP_CODE
     *
     * @param COMP_CODE the value for FMS_TEMPLATE_PARTICIPANT_DTL.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_TEMPLATE_PARTICIPANT_DTL.LINE_NBR
     *
     * @return the value of FMS_TEMPLATE_PARTICIPANT_DTL.LINE_NBR
     */
    public BigDecimal getLINE_NBR() {
        return LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_TEMPLATE_PARTICIPANT_DTL.LINE_NBR
     *
     * @param LINE_NBR the value for FMS_TEMPLATE_PARTICIPANT_DTL.LINE_NBR
     */
    public void setLINE_NBR(BigDecimal LINE_NBR) {
        this.LINE_NBR = LINE_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMS_TEMPLATE_PARTICIPANT_DTL.TEMPLATE_CODE
     *
     * @return the value of FMS_TEMPLATE_PARTICIPANT_DTL.TEMPLATE_CODE
     */
    public BigDecimal getTEMPLATE_CODE() {
        return TEMPLATE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMS_TEMPLATE_PARTICIPANT_DTL.TEMPLATE_CODE
     *
     * @param TEMPLATE_CODE the value for FMS_TEMPLATE_PARTICIPANT_DTL.TEMPLATE_CODE
     */
    public void setTEMPLATE_CODE(BigDecimal TEMPLATE_CODE) {
        this.TEMPLATE_CODE = TEMPLATE_CODE;
    }
}