package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class CTS_CHARGES_REFUNDVOKey extends BaseVO
{

    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.COMP_CODE
     */
    private BigDecimal COMP_CODE;
    
    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column CTS_CHARGES_REFUND.REFUND_CODE
     */
    private BigDecimal REFUND_CODE;

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
}
