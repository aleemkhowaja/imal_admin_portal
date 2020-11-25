package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class COUNTERVO extends COUNTERVOKey {
    /**
     * This field corresponds to the database column COUNTER.LAST_NUMBER
     */
    private BigDecimal LAST_NUMBER;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COUNTER.LAST_NUMBER
     *
     * @return the value of COUNTER.LAST_NUMBER
     */
    public BigDecimal getLAST_NUMBER() {
        return LAST_NUMBER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COUNTER.LAST_NUMBER
     *
     * @param LAST_NUMBER the value for COUNTER.LAST_NUMBER
     */
    public void setLAST_NUMBER(BigDecimal LAST_NUMBER) {
        this.LAST_NUMBER = LAST_NUMBER;
    }
}