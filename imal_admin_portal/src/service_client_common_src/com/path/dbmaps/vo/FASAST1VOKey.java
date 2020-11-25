package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class FASAST1VOKey extends BaseVO {
    /**
     * This field corresponds to the database column FASAST1.CATEGORY_CODE
     */
    private BigDecimal CATEGORY_CODE;

    /**
     * This field corresponds to the database column FASAST1.CLASS_CODE
     */
    private BigDecimal CLASS_CODE;

    /**
     * This field corresponds to the database column FASAST1.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column FASAST1.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FASAST1.CATEGORY_CODE
     *
     * @return the value of FASAST1.CATEGORY_CODE
     */
    public BigDecimal getCATEGORY_CODE() {
        return CATEGORY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FASAST1.CATEGORY_CODE
     *
     * @param CATEGORY_CODE the value for FASAST1.CATEGORY_CODE
     */
    public void setCATEGORY_CODE(BigDecimal CATEGORY_CODE) {
        this.CATEGORY_CODE = CATEGORY_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FASAST1.CLASS_CODE
     *
     * @return the value of FASAST1.CLASS_CODE
     */
    public BigDecimal getCLASS_CODE() {
        return CLASS_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FASAST1.CLASS_CODE
     *
     * @param CLASS_CODE the value for FASAST1.CLASS_CODE
     */
    public void setCLASS_CODE(BigDecimal CLASS_CODE) {
        this.CLASS_CODE = CLASS_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FASAST1.CODE
     *
     * @return the value of FASAST1.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FASAST1.CODE
     *
     * @param CODE the value for FASAST1.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FASAST1.COMP_CODE
     *
     * @return the value of FASAST1.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FASAST1.COMP_CODE
     *
     * @param COMP_CODE the value for FASAST1.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }
}