package com.path.vo.common.swift.swiftoutward;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.AMFVO;
import com.path.lib.vo.BaseVO;

public class SwiftProcNostroCO extends BaseVO
{
    private BigDecimal compCode;
    private AMFVO amfVOFrom = new AMFVO();
    private AMFVO amfVOTo = new AMFVO();
    private String mtCode;
    private String mtDesc;
    private BigDecimal cifReceiver;
    private String cifReceiverDesc;
    private String language;
    private String vT; 
    private String userId;
    private String gvUserId;
    private Date ReqDate;
    private Date openedDate;
    private Date prevDate;
    private int year;
    private int month;
    
    

    public BigDecimal getCompCode()
    {
        return compCode;
    }
    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
    }
    public AMFVO getAmfVOFrom()
    {
        return amfVOFrom;
    }
    public void setAmfVOFrom(AMFVO amfVOFrom)
    {
        this.amfVOFrom = amfVOFrom;
    }
    public AMFVO getAmfVOTo()
    {
        return amfVOTo;
    }
    public void setAmfVOTo(AMFVO amfVOTo)
    {
        this.amfVOTo = amfVOTo;
    }
    public String getMtCode()
    {
        return mtCode;
    }
    public void setMtCode(String mtCode)
    {
        this.mtCode = mtCode;
    }
    public String getMtDesc()
    {
        return mtDesc;
    }
    public void setMtDesc(String mtDesc)
    {
        this.mtDesc = mtDesc;
    }
    public BigDecimal getCifReceiver()
    {
        return cifReceiver;
    }
    public void setCifReceiver(BigDecimal cifReceiver)
    {
        this.cifReceiver = cifReceiver;
    }
    public String getCifReceiverDesc()
    {
        return cifReceiverDesc;
    }
    public void setCifReceiverDesc(String cifReceiverDesc)
    {
        this.cifReceiverDesc = cifReceiverDesc;
    }
    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String language)
    {
        this.language = language;
    }
    public String getvT()
    {
        return vT;
    }
    public void setvT(String vT)
    {
        this.vT = vT;
    }
    public Date getReqDate()
    {
        return ReqDate;
    }
    public void setReqDate(Date reqDate)
    {
        ReqDate = reqDate;
    }
    public String getUserId()
    {
        return userId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    public String getGvUserId()
    {
        return gvUserId;
    }
    public void setGvUserId(String gvUserId)
    {
        this.gvUserId = gvUserId;
    }
    public Date getOpenedDate()
    {
        return openedDate;
    }
    public void setOpenedDate(Date openedDate)
    {
        this.openedDate = openedDate;
    }
    public Date getPrevDate()
    {
        return prevDate;
    }
    public void setPrevDate(Date prevDate)
    {
        this.prevDate = prevDate;
    }
    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year = year;
    }
    public int getMonth()
    {
        return month;
    }
    public void setMonth(int month)
    {
        this.month = month;
    }

}
