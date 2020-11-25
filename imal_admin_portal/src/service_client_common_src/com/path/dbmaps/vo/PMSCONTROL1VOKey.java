package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class PMSCONTROL1VOKey extends BaseVO {
    /**
     * This field corresponds to the database column PMSCONTROL1.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column PMSCONTROL1.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL1.BRANCH_CODE
     *
     * @return the value of PMSCONTROL1.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL1.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for PMSCONTROL1.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL1.COMP_CODE
     *
     * @return the value of PMSCONTROL1.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL1.COMP_CODE
     *
     * @param COMP_CODE the value for PMSCONTROL1.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}