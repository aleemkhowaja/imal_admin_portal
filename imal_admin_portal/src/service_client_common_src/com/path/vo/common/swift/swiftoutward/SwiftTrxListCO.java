package com.path.vo.common.swift.swiftoutward;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class SwiftTrxListCO extends BaseVO
{

    private boolean trxSelected;
    private BigDecimal trsNo;
    private BigDecimal branchCode;
    
    public BigDecimal getTrsNo()
    {
        return trsNo;
    }
    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }
    public BigDecimal getBranchCode()
    {
        return branchCode;
    }
    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }
    public boolean isTrxSelected()
    {
        return trxSelected;
    }
    public void setTrxSelected(boolean trxSelected)
    {
        this.trxSelected = trxSelected;
    }
   
    
}
