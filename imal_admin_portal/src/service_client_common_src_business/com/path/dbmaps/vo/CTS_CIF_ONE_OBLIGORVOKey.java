package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTS_CIF_ONE_OBLIGORVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTS_CIF_ONE_OBLIGOR.CIF_NO
     */
    private BigDecimal CIF_NO;

    /**
     * This field corresponds to the database column CTS_CIF_ONE_OBLIGOR.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTS_CIF_ONE_OBLIGOR.OBLIGOR_CODE
     */
    private BigDecimal OBLIGOR_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_ONE_OBLIGOR.CIF_NO
     *
     * @return the value of CTS_CIF_ONE_OBLIGOR.CIF_NO
     */
    public BigDecimal getCIF_NO() {
        return CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_ONE_OBLIGOR.CIF_NO
     *
     * @param CIF_NO the value for CTS_CIF_ONE_OBLIGOR.CIF_NO
     */
    public void setCIF_NO(BigDecimal CIF_NO) {
        this.CIF_NO = CIF_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_ONE_OBLIGOR.COMP_CODE
     *
     * @return the value of CTS_CIF_ONE_OBLIGOR.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_ONE_OBLIGOR.COMP_CODE
     *
     * @param COMP_CODE the value for CTS_CIF_ONE_OBLIGOR.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTS_CIF_ONE_OBLIGOR.OBLIGOR_CODE
     *
     * @return the value of CTS_CIF_ONE_OBLIGOR.OBLIGOR_CODE
     */
    public BigDecimal getOBLIGOR_CODE() {
        return OBLIGOR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTS_CIF_ONE_OBLIGOR.OBLIGOR_CODE
     *
     * @param OBLIGOR_CODE the value for CTS_CIF_ONE_OBLIGOR.OBLIGOR_CODE
     */
    public void setOBLIGOR_CODE(BigDecimal OBLIGOR_CODE) {
        this.OBLIGOR_CODE = OBLIGOR_CODE;
    }
}