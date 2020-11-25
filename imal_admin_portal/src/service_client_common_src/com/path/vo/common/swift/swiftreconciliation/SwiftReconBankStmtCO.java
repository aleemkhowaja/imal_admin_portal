package com.path.vo.common.swift.swiftreconciliation;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.HSTVO;
import com.path.lib.vo.BaseVO;

public class SwiftReconBankStmtCO extends BaseVO
{

    private HSTVO hstVO = new HSTVO();
    private String srlNo;
    private BigDecimal reconSet;
    private Date dateOrder;
    private BigDecimal bfFc;
    private BigDecimal bfCv;
    private BigDecimal opBal;
    private BigDecimal reconInd;
    private BigDecimal opBalInd;
    private String accNo;
    private BigDecimal decPoint;
    private String trxRef;
    
    
    public HSTVO getHstVO()
    {
        return hstVO;
    }
    public void setHstVO(HSTVO hstVO)
    {
        this.hstVO = hstVO;
    }
    public String getSrlNo()
    {
        return srlNo;
    }
    public void setSrlNo(String srlNo)
    {
        this.srlNo = srlNo;
    }
    public BigDecimal getReconSet()
    {
        return reconSet;
    }
    public void setReconSet(BigDecimal reconSet)
    {
        this.reconSet = reconSet;
    }
    public Date getDateOrder()
    {
        return dateOrder;
    }
    public void setDateOrder(Date dateOrder)
    {
        this.dateOrder = dateOrder;
    }
    public BigDecimal getBfFc()
    {
        return bfFc;
    }
    public void setBfFc(BigDecimal bfFc)
    {
        this.bfFc = bfFc;
    }
    public BigDecimal getBfCv()
    {
        return bfCv;
    }
    public void setBfCv(BigDecimal bfCv)
    {
        this.bfCv = bfCv;
    }
    public BigDecimal getOpBal()
    {
        return opBal;
    }
    public void setOpBal(BigDecimal opBal)
    {
        this.opBal = opBal;
    }
    public BigDecimal getReconInd()
    {
        return reconInd;
    }
    public void setReconInd(BigDecimal reconInd)
    {
        this.reconInd = reconInd;
    }
    public BigDecimal getOpBalInd()
    {
        return opBalInd;
    }
    public void setOpBalInd(BigDecimal opBalInd)
    {
        this.opBalInd = opBalInd;
    }
    public String getAccNo()
    {
        return accNo;
    }
    public void setAccNo(String accNo)
    {
        this.accNo = accNo;
    }
    public BigDecimal getDecPoint()
    {
        return decPoint;
    }
    public void setDecPoint(BigDecimal decPoint)
    {
        this.decPoint = decPoint;
    }
    public String getTrxRef()
    {
        return trxRef;
    }
    public void setTrxRef(String trxRef)
    {
        this.trxRef = trxRef;
    }
	 
	 
    
        
}
