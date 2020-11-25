package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class FASCLASSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column FASCLASS.CATEGORY_CODE
     */
    private BigDecimal CATEGORY_CODE;

    /**
     * This field corresponds to the database column FASCLASS.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column FASCLASS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FASCLASS.CATEGORY_CODE
     *
     * @return the value of FASCLASS.CATEGORY_CODE
     */
    public BigDecimal getCATEGORY_CODE() {
        return CATEGORY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FASCLASS.CATEGORY_CODE
     *
     * @param CATEGORY_CODE the value for FASCLASS.CATEGORY_CODE
     */
    public void setCATEGORY_CODE(BigDecimal CATEGORY_CODE) {
        this.CATEGORY_CODE = CATEGORY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FASCLASS.CODE
     *
     * @return the value of FASCLASS.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FASCLASS.CODE
     *
     * @param CODE the value for FASCLASS.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FASCLASS.COMP_CODE
     *
     * @return the value of FASCLASS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FASCLASS.COMP_CODE
     *
     * @param COMP_CODE the value for FASCLASS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}