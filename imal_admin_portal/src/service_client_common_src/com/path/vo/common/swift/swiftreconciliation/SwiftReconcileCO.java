package com.path.vo.common.swift.swiftreconciliation;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.NV_AUTO_RECONCIL_GROUPSVO;
import com.path.dbmaps.vo.SWIFT_HST_RECONCILEVO;
import com.path.lib.vo.BaseVO;

public class SwiftReconcileCO extends BaseVO
{
    private SWIFT_HST_RECONCILEVO swiftHstReconcileVO = new SWIFT_HST_RECONCILEVO();
    private String account;
    private BigDecimal reconInd;
    private String reason;
    private Date minTradeDate;
    private Date minValueDate;
    private Date maxTradeDate;
    private Date maxValueDate;
    private BigDecimal decPoint;
    private BigDecimal cyCode;
    private BigDecimal opBalInd;
    private String subtag6;
    private String subtag7;
    private String subtag8;
    private String compute3;
    private String fullMatchExp;
    private String[] partialMatchCondList;
    private String[] partialReasonList;
    private NV_AUTO_RECONCIL_GROUPSVO swiftNvAutoReconcilGroupsVO = new  NV_AUTO_RECONCIL_GROUPSVO(); //Added by Lara Bedrane  #766421 - DASI180599 
    public NV_AUTO_RECONCIL_GROUPSVO getSwiftNvAutoReconcilGroupsVO() 
    {
		return swiftNvAutoReconcilGroupsVO;
	}
	public void setSwiftNvAutoReconcilGroupsVO(NV_AUTO_RECONCIL_GROUPSVO swiftNvAutoReconcilGroupsVO) 
	{
		this.swiftNvAutoReconcilGroupsVO = swiftNvAutoReconcilGroupsVO;
	}

	public String[] getPartialReasonList()
    {
        return partialReasonList;
    }

    public void setPartialReasonList(String[] partialReasonList)
    {
        this.partialReasonList = partialReasonList;
    }

    public String getFullMatchExp()
    {
        return fullMatchExp;
    }

    public void setFullMatchExp(String fullMatchExp)
    {
        this.fullMatchExp = fullMatchExp;
    }

    public String[] getPartialMatchCondList()
    {
        return partialMatchCondList;
    }

    public void setPartialMatchCondList(String[] partialMatchCondList)
    {
        this.partialMatchCondList = partialMatchCondList;
    }

    public String getCompute3()
    {
	return compute3;
    }

    public void setCompute3(String compute3)
    {
	this.compute3 = compute3;
    }

    public SWIFT_HST_RECONCILEVO getSwiftHstReconcileVO()
    {
	return swiftHstReconcileVO;
    }

    public void setSwiftHstReconcileVO(SWIFT_HST_RECONCILEVO swiftHstReconcileVO)
    {
	this.swiftHstReconcileVO = swiftHstReconcileVO;
    }

    public String getAccount()
    {
	return account;
    }

    public void setAccount(String account)
    {
	this.account = account;
    }

    public BigDecimal getReconInd()
    {
	return reconInd;
    }

    public void setReconInd(BigDecimal reconInd)
    {
	this.reconInd = reconInd;
    }

    public String getReason()
    {
	return reason;
    }

    public void setReason(String reason)
    {
	this.reason = reason;
    }

    public Date getMinTradeDate()
    {
	return minTradeDate;
    }

    public void setMinTradeDate(Date minTradeDate)
    {
	this.minTradeDate = minTradeDate;
    }

    public Date getMinValueDate()
    {
	return minValueDate;
    }

    public void setMinValueDate(Date minValueDate)
    {
	this.minValueDate = minValueDate;
    }

    public Date getMaxTradeDate()
    {
	return maxTradeDate;
    }

    public void setMaxTradeDate(Date maxTradeDate)
    {
	this.maxTradeDate = maxTradeDate;
    }

    public Date getMaxValueDate()
    {
	return maxValueDate;
    }

    public void setMaxValueDate(Date maxValueDate)
    {
	this.maxValueDate = maxValueDate;
    }

    public BigDecimal getDecPoint()
    {
	return decPoint;
    }

    public void setDecPoint(BigDecimal decPoint)
    {
	this.decPoint = decPoint;
    }

    public BigDecimal getCyCode()
    {
	return cyCode;
    }

    public void setCyCode(BigDecimal cyCode)
    {
	this.cyCode = cyCode;
    }

    public BigDecimal getOpBalInd()
    {
	return opBalInd;
    }

    public void setOpBalInd(BigDecimal opBalInd)
    {
	this.opBalInd = opBalInd;
    }

    public String getSubtag6()
    {
	return subtag6;
    }

    public void setSubtag6(String subtag6)
    {
	this.subtag6 = subtag6;
    }

    public String getSubtag7()
    {
	return subtag7;
    }

    public void setSubtag7(String subtag7)
    {
	this.subtag7 = subtag7;
    }

    public String getSubtag8()
    {
	return subtag8;
    }

    public void setSubtag8(String subtag8)
    {
	this.subtag8 = subtag8;
    }

}
