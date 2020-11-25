package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class FMSAPPLIMITDET_GROUPVOKey extends BaseVO {
    /**
     * This field corresponds to the database column FMSAPPLIMITDET_GROUP.APPL_CODE
     */
    private BigDecimal APPL_CODE;

    /**
     * This field corresponds to the database column FMSAPPLIMITDET_GROUP.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column FMSAPPLIMITDET_GROUP.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column FMSAPPLIMITDET_GROUP.GROUP_ID
     */
    private BigDecimal GROUP_ID;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLIMITDET_GROUP.APPL_CODE
     *
     * @return the value of FMSAPPLIMITDET_GROUP.APPL_CODE
     */
    public BigDecimal getAPPL_CODE() {
        return APPL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLIMITDET_GROUP.APPL_CODE
     *
     * @param APPL_CODE the value for FMSAPPLIMITDET_GROUP.APPL_CODE
     */
    public void setAPPL_CODE(BigDecimal APPL_CODE) {
        this.APPL_CODE = APPL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLIMITDET_GROUP.BRANCH_CODE
     *
     * @return the value of FMSAPPLIMITDET_GROUP.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLIMITDET_GROUP.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for FMSAPPLIMITDET_GROUP.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLIMITDET_GROUP.COMP_CODE
     *
     * @return the value of FMSAPPLIMITDET_GROUP.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLIMITDET_GROUP.COMP_CODE
     *
     * @param COMP_CODE the value for FMSAPPLIMITDET_GROUP.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSAPPLIMITDET_GROUP.GROUP_ID
     *
     * @return the value of FMSAPPLIMITDET_GROUP.GROUP_ID
     */
    public BigDecimal getGROUP_ID() {
        return GROUP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSAPPLIMITDET_GROUP.GROUP_ID
     *
     * @param GROUP_ID the value for FMSAPPLIMITDET_GROUP.GROUP_ID
     */
    public void setGROUP_ID(BigDecimal GROUP_ID) {
        this.GROUP_ID = GROUP_ID;
    }
}