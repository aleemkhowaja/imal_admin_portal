package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TRSDEALLINK_IRSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRSDEALLINK_IRS.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRSDEALLINK_IRS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRSDEALLINK_IRS.DEAL_NBR
     */
    private BigDecimal DEAL_NBR;

    /**
     * This field corresponds to the database column TRSDEALLINK_IRS.IRS_ID
     */
    private BigDecimal IRS_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEALLINK_IRS.BRANCH_CODE
     *
     * @return the value of TRSDEALLINK_IRS.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEALLINK_IRS.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRSDEALLINK_IRS.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEALLINK_IRS.COMP_CODE
     *
     * @return the value of TRSDEALLINK_IRS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEALLINK_IRS.COMP_CODE
     *
     * @param COMP_CODE the value for TRSDEALLINK_IRS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEALLINK_IRS.DEAL_NBR
     *
     * @return the value of TRSDEALLINK_IRS.DEAL_NBR
     */
    public BigDecimal getDEAL_NBR() {
        return DEAL_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEALLINK_IRS.DEAL_NBR
     *
     * @param DEAL_NBR the value for TRSDEALLINK_IRS.DEAL_NBR
     */
    public void setDEAL_NBR(BigDecimal DEAL_NBR) {
        this.DEAL_NBR = DEAL_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSDEALLINK_IRS.IRS_ID
     *
     * @return the value of TRSDEALLINK_IRS.IRS_ID
     */
    public BigDecimal getIRS_ID() {
        return IRS_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSDEALLINK_IRS.IRS_ID
     *
     * @param IRS_ID the value for TRSDEALLINK_IRS.IRS_ID
     */
    public void setIRS_ID(BigDecimal IRS_ID) {
        this.IRS_ID = IRS_ID;
    }
}