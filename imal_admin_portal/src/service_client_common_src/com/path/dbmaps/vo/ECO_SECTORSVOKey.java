package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class ECO_SECTORSVOKey extends BaseVO {
    /**
     * This field corresponds to the database column ECO_SECTORS.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column ECO_SECTORS.SECTOR_CODE
     */
    private BigDecimal SECTOR_CODE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ECO_SECTORS.COMP_CODE
     *
     * @return the value of ECO_SECTORS.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ECO_SECTORS.COMP_CODE
     *
     * @param COMP_CODE the value for ECO_SECTORS.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ECO_SECTORS.SECTOR_CODE
     *
     * @return the value of ECO_SECTORS.SECTOR_CODE
     */
    public BigDecimal getSECTOR_CODE() {
        return SECTOR_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ECO_SECTORS.SECTOR_CODE
     *
     * @param SECTOR_CODE the value for ECO_SECTORS.SECTOR_CODE
     */
    public void setSECTOR_CODE(BigDecimal SECTOR_CODE) {
        this.SECTOR_CODE = SECTOR_CODE;
    }
}