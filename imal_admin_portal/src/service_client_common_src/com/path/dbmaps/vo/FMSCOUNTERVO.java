package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class FMSCOUNTERVO extends FMSCOUNTERVOKey {
    /**
     * This field corresponds to the database column FMSCOUNTER.LAST_NBR
     */
    private BigDecimal LAST_NBR;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column FMSCOUNTER.LAST_NBR
     *
     * @return the value of FMSCOUNTER.LAST_NBR
     */
    public BigDecimal getLAST_NBR() {
        return LAST_NBR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column FMSCOUNTER.LAST_NBR
     *
     * @param LAST_NBR the value for FMSCOUNTER.LAST_NBR
     */
    public void setLAST_NBR(BigDecimal LAST_NBR) {
        this.LAST_NBR = LAST_NBR;
    }
}