package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class CTSCHARGES_ENTRY_LOGVOKey extends BaseVO
{
    /**
     * This field corresponds to the database column CTSCHARGES_ENTRY_LOG.COMP_CODE
     */
    private BigDecimal COMP_CODE;
    
    /**
     * This field corresponds to the database column CTSCHARGES_ENTRY_LOG.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;
    
    /**
     * This field corresponds to the database column CTSCHARGES_ENTRY_LOG.CHARGES_COUNTER
     */
    private BigDecimal CHARGES_COUNTER;

    public BigDecimal getCOMP_CODE()
    {
        return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal COMP_CODE)
    {
        this.COMP_CODE = COMP_CODE;
    }

    public BigDecimal getBRANCH_CODE()
    {
        return BRANCH_CODE;
    }

    public void setBRANCH_CODE(BigDecimal BRANCH_CODE)
    {
	this.BRANCH_CODE = BRANCH_CODE;
    }

    public BigDecimal getCHARGES_COUNTER()
    {
        return CHARGES_COUNTER;
    }

    public void setCHARGES_COUNTER(BigDecimal CHARGES_COUNTER)
    {
	this.CHARGES_COUNTER = CHARGES_COUNTER;
    }
}
