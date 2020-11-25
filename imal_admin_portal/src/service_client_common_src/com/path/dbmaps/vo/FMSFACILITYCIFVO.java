package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class FMSFACILITYCIFVO extends FMSFACILITYCIFVOKey {
    /**
     * This field corresponds to the database column FMSFACILITYCIF.CIF
     */
    private BigDecimal CIF;

    /**
     * This field corresponds to the database column FMSFACILITYCIF.CIF_AMOUNT
     */
    private BigDecimal CIF_AMOUNT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSFACILITYCIF.CIF
     *
     * @return the value of FMSFACILITYCIF.CIF
     */
    public BigDecimal getCIF() {
        return CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSFACILITYCIF.CIF
     *
     * @param CIF the value for FMSFACILITYCIF.CIF
     */
    public void setCIF(BigDecimal CIF) {
        this.CIF = CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSFACILITYCIF.CIF_AMOUNT
     *
     * @return the value of FMSFACILITYCIF.CIF_AMOUNT
     */
    public BigDecimal getCIF_AMOUNT() {
        return CIF_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSFACILITYCIF.CIF_AMOUNT
     *
     * @param CIF_AMOUNT the value for FMSFACILITYCIF.CIF_AMOUNT
     */
    public void setCIF_AMOUNT(BigDecimal CIF_AMOUNT) {
        this.CIF_AMOUNT = CIF_AMOUNT;
    }
}