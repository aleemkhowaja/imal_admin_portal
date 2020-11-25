package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class RELATIONVOKey extends BaseVO {
    /**
     * This field corresponds to the database column RELATION.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column RELATION.RELATION_CODE
     */
    private BigDecimal RELATION_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RELATION.COMP_CODE
     *
     * @return the value of RELATION.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RELATION.COMP_CODE
     *
     * @param COMP_CODE the value for RELATION.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RELATION.RELATION_CODE
     *
     * @return the value of RELATION.RELATION_CODE
     */
    public BigDecimal getRELATION_CODE() {
        return RELATION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RELATION.RELATION_CODE
     *
     * @param RELATION_CODE the value for RELATION.RELATION_CODE
     */
    public void setRELATION_CODE(BigDecimal RELATION_CODE) {
        this.RELATION_CODE = RELATION_CODE;
    }
}