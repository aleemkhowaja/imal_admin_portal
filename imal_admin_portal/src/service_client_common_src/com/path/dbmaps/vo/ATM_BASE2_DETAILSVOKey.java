package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class ATM_BASE2_DETAILSVOKey extends BaseVO
{
    /**
     * This field corresponds to the database column ATM_BASE2_DETAILS.COMP_CODE
     */
    private BigDecimal COMP_CODE;
    
    /**
     * This field corresponds to the database column ATM_BASE2_DETAILS.SEQUENCE_NO
     */
    private BigDecimal SEQUENCE_NO;
    
    /**
     * This field corresponds to the database column ATM_BASE2_DETAILS.CODE
     */
    private BigDecimal CODE;

    public BigDecimal getCOMP_CODE()
    {
        return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMP_CODE)
    {
        COMP_CODE = cOMP_CODE;
    }

    public BigDecimal getSEQUENCE_NO()
    {
        return SEQUENCE_NO;
    }

    public void setSEQUENCE_NO(BigDecimal sEQUENCE_NO)
    {
        SEQUENCE_NO = sEQUENCE_NO;
    }

    public BigDecimal getCODE()
    {
        return CODE;
    }

    public void setCODE(BigDecimal cODE)
    {
        CODE = cODE;
    }
    
    
}
