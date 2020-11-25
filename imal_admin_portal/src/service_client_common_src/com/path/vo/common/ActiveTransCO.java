package com.path.vo.common;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;
import com.path.vo.common.reportresponse.ReportResponseCO;
/**
 * 
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * AllActiveTransCO.java used to
 */
public class ActiveTransCO extends BaseVO
{
    private String     title;
    private String     userID;
    private BigDecimal trxNO;
    private String     strxNO;
    private String     status;
    private Date       trsDate;
    private String     trsDesc;
    private String     accNO;
    private String     confirmationFlag = "false";
    private String     confirmationMsg;
    private ReportResponseCO reportResponseCO;
    private String     appName;
    
    private Boolean hasData;
    private String  repStr;
    
    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    /**
     * @return the userID
     */
    public String getUserID()
    {
        return userID;
    }
    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID)
    {
        this.userID = userID;
    }
    /**
     * @return the trxNO
     */
    public BigDecimal getTrxNO()
    {
        return trxNO;
    }
    /**
     * @param trxNO the trxNO to set
     */
    public void setTrxNO(BigDecimal trxNO)
    {
        this.trxNO = trxNO;
    }
    /**
     * @return the strxNO
     */
    public String getStrxNO()
    {
        return strxNO;
    }
    /**
     * @param strxNO the strxNO to set
     */
    public void setStrxNO(String strxNO)
    {
        this.strxNO = strxNO;
    }
    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
    /**
     * @return the trsDate
     */
    public Date getTrsDate()
    {
        return trsDate;
    }
    /**
     * @param trsDate the trsDate to set
     */
    public void setTrsDate(Date trsDate)
    {
        this.trsDate = trsDate;
    }
    /**
     * @return the trsDesc
     */
    public String getTrsDesc()
    {
        return trsDesc;
    }
    /**
     * @param trsDesc the trsDesc to set
     */
    public void setTrsDesc(String trsDesc)
    {
        this.trsDesc = trsDesc;
    }
    /**
     * @return the accNO
     */
    public String getAccNO()
    {
        return accNO;
    }
    /**
     * @param accNO the accNO to set
     */
    public void setAccNO(String accNO)
    {
        this.accNO = accNO;
    }
    /**
     * @return the reportResponseCO
     */
    public ReportResponseCO getReportResponseCO()
    {
        return reportResponseCO;
    }
    /**
     * @param reportResponseCO the reportResponseCO to set
     */
    public void setReportResponseCO(ReportResponseCO reportResponseCO)
    {
        this.reportResponseCO = reportResponseCO;
    }
    /**
     * @return the confirmationFlag
     */
    public String getConfirmationFlag()
    {
        return confirmationFlag;
    }
    /**
     * @param confirmationFlag the confirmationFlag to set
     */
    public void setConfirmationFlag(String confirmationFlag)
    {
        this.confirmationFlag = confirmationFlag;
    }
    /**
     * @return the confirmationMsg
     */
    public String getConfirmationMsg()
    {
        return confirmationMsg;
    }
    /**
     * @param confirmationMsg the confirmationMsg to set
     */
    public void setConfirmationMsg(String confirmationMsg)
    {
        this.confirmationMsg = confirmationMsg;
    }
    /**
     * @return the appName
     */
    public String getAppName()
    {
        return appName;
    }
    /**
     * @param appName the appName to set
     */
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    /**
     * @return the hasData
     */
    public Boolean getHasData()
    {
        return hasData;
    }
    /**
     * @param hasData the hasData to set
     */
    public void setHasData(Boolean hasData)
    {
        this.hasData = hasData;
    }
    /**
     * @return the repStr
     */
    public String getRepStr()
    {
        return repStr;
    }
    /**
     * @param repStr the repStr to set
     */
    public void setRepStr(String repStr)
    {
        this.repStr = repStr;
    }

}
