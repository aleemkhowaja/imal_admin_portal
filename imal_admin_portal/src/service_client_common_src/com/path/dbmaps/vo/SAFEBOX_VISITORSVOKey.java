package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class SAFEBOX_VISITORSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column SAFEBOX_VISITORS.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column SAFEBOX_VISITORS.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column SAFEBOX_VISITORS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column SAFEBOX_VISITORS.TRX_NO
     */
    private BigDecimal TRX_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SAFEBOX_VISITORS.BRANCH_CODE
     *
     * @return the value of SAFEBOX_VISITORS.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SAFEBOX_VISITORS.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for SAFEBOX_VISITORS.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SAFEBOX_VISITORS.CODE
     *
     * @return the value of SAFEBOX_VISITORS.CODE
     */
    public BigDecimal getCODE() {
        return CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SAFEBOX_VISITORS.CODE
     *
     * @param CODE the value for SAFEBOX_VISITORS.CODE
     */
    public void setCODE(BigDecimal CODE) {
        this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SAFEBOX_VISITORS.COMP_CODE
     *
     * @return the value of SAFEBOX_VISITORS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SAFEBOX_VISITORS.COMP_CODE
     *
     * @param COMP_CODE the value for SAFEBOX_VISITORS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SAFEBOX_VISITORS.TRX_NO
     *
     * @return the value of SAFEBOX_VISITORS.TRX_NO
     */
    public BigDecimal getTRX_NO() {
        return TRX_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SAFEBOX_VISITORS.TRX_NO
     *
     * @param TRX_NO the value for SAFEBOX_VISITORS.TRX_NO
     */
    public void setTRX_NO(BigDecimal TRX_NO) {
        this.TRX_NO = TRX_NO;
    }
}