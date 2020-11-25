package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class CTSCARDS_LIEN_CATVOKey extends BaseVO {
    /**
     * This field corresponds to the database column CTSCARDS_LIEN_CAT.CAT_CODE
     */
    private BigDecimal CAT_CODE;

    /**
     * This field corresponds to the database column CTSCARDS_LIEN_CAT.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column CTSCARDS_LIEN_CAT.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_LIEN_CAT.CAT_CODE
     *
     * @return the value of CTSCARDS_LIEN_CAT.CAT_CODE
     */
    public BigDecimal getCAT_CODE() {
        return CAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_LIEN_CAT.CAT_CODE
     *
     * @param CAT_CODE the value for CTSCARDS_LIEN_CAT.CAT_CODE
     */
    public void setCAT_CODE(BigDecimal CAT_CODE) {
        this.CAT_CODE = CAT_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_LIEN_CAT.COMP_CODE
     *
     * @return the value of CTSCARDS_LIEN_CAT.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_LIEN_CAT.COMP_CODE
     *
     * @param COMP_CODE the value for CTSCARDS_LIEN_CAT.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CTSCARDS_LIEN_CAT.LINE_NO
     *
     * @return the value of CTSCARDS_LIEN_CAT.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CTSCARDS_LIEN_CAT.LINE_NO
     *
     * @param LINE_NO the value for CTSCARDS_LIEN_CAT.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }
}