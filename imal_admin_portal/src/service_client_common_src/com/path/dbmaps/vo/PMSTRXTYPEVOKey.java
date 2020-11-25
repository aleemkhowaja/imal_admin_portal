package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class PMSTRXTYPEVOKey extends BaseVO
{
    /**
     * This field corresponds to the database column PMSTRXTYPE.CODE
     */
    private BigDecimal CODE;

    /**
     * This field corresponds to the database column PMSTRXTYPE.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column PMSTRXTYPE.CODE
     * 
     * @return the value of PMSTRXTYPE.CODE
     */
    public BigDecimal getCODE()
    {
	return CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column PMSTRXTYPE.CODE
     * 
     * @param CODE the value for PMSTRXTYPE.CODE
     */
    public void setCODE(BigDecimal CODE)
    {
	this.CODE = CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column PMSTRXTYPE.COMP_CODE
     * 
     * @return the value of PMSTRXTYPE.COMP_CODE
     */
    public BigDecimal getCOMP_CODE()
    {
	return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column PMSTRXTYPE.COMP_CODE
     * 
     * @param COMP_CODE the value for PMSTRXTYPE.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE)
    {
	this.COMP_CODE = COMP_CODE;
    }
}