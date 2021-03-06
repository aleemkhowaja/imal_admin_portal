package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class OCCUPATIONSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column OCCUPATIONS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column OCCUPATIONS.OCCUPATION_CODE
     */
    private BigDecimal OCCUPATION_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OCCUPATIONS.COMP_CODE
     *
     * @return the value of OCCUPATIONS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OCCUPATIONS.COMP_CODE
     *
     * @param COMP_CODE the value for OCCUPATIONS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OCCUPATIONS.OCCUPATION_CODE
     *
     * @return the value of OCCUPATIONS.OCCUPATION_CODE
     */
    public BigDecimal getOCCUPATION_CODE() {
        return OCCUPATION_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OCCUPATIONS.OCCUPATION_CODE
     *
     * @param OCCUPATION_CODE the value for OCCUPATIONS.OCCUPATION_CODE
     */
    public void setOCCUPATION_CODE(BigDecimal OCCUPATION_CODE) {
        this.OCCUPATION_CODE = OCCUPATION_CODE;
    }
}