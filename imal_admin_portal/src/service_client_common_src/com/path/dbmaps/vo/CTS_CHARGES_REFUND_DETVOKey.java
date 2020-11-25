package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class CTS_CHARGES_REFUND_DETVOKey extends BaseVO
{
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND_DET.COMP_CODE
     */
    private BigDecimal COMP_CODE;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND_DET.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND_DET.REFUND_CODE
     */
    private BigDecimal REFUND_CODE;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND_DET.LINE_NO
     */
    private BigDecimal LINE_NO;

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

    public BigDecimal getREFUND_CODE()
    {
        return REFUND_CODE;
    }

    public void setREFUND_CODE(BigDecimal REFUND_CODE)
    {
        this.REFUND_CODE = REFUND_CODE;
    }

    public BigDecimal getLINE_NO()
    {
        return LINE_NO;
    }

    public void setLINE_NO(BigDecimal LINE_NO)
    {
        this.LINE_NO = LINE_NO;
    }
}
