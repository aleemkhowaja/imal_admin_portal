package com.path.vo.common.swift.swiftoutward;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

public class SwiftCO extends BaseVO
{
    private String errorMsg;
    private String schedTime;
    private Date nextReplication;
    private String swiftMessage;
    private BigDecimal nbrTrxSOA;
    private Long countMsg;
    private String tagRefVal;
    private Long returnVar;
    private int skipRepetitiveMsg;
    private String logFileLocation;
    private String msgFileName;
    private String fileMode;
    private String savePathJava;
    
    
    private String printSwiftHistory;
    private BigDecimal bdCompCode;
    private BigDecimal bdTrsNO;
    private String trxType;
    private String sModule;
    private BigDecimal bdMsgOrder;
 

    
    
    
    public int getSkipRepetitiveMsg()
    {
        return skipRepetitiveMsg;
    }
    public void setSkipRepetitiveMsg(int skipRepetitiveMsg)
    {
        this.skipRepetitiveMsg = skipRepetitiveMsg;
    }
    public Long getReturnVar()
    {
        return returnVar;
    }
    public void setReturnVar(Long returnVar)
    {
        this.returnVar = returnVar;
    }
    public String getTagRefVal()
    {
        return tagRefVal;
    }
    public void setTagRefVal(String tagRefVal)
    {
        this.tagRefVal = tagRefVal;
    }
    public Long getCountMsg()
    {
        return countMsg;
    }
    public void setCountMsg(Long countMsg)
    {
        this.countMsg = countMsg;
    }
    public BigDecimal getNbrTrxSOA()
    {
        return nbrTrxSOA;
    }
    public void setNbrTrxSOA(BigDecimal nbrTrxSOA)
    {
        this.nbrTrxSOA = nbrTrxSOA;
    }
    public String getSwiftMessage()
    {
        return swiftMessage;
    }
    public void setSwiftMessage(String swiftMessage)
    {
        this.swiftMessage = swiftMessage;
    }
    public Date getNextReplication()
    {
        return nextReplication;
    }
    public void setNextReplication(Date nextReplication)
    {
        this.nextReplication = nextReplication;
    }
    public String getSchedTime()
    {
        return schedTime;
    }
    public void setSchedTime(String schedTime)
    {
        this.schedTime = schedTime;
    }
    public String getErrorMsg()
    {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }
    public String getLogFileLocation()
    {
        return logFileLocation;
    }
    public void setLogFileLocation(String logFileLocation)
    {
        this.logFileLocation = logFileLocation;
    }
    public String getFileMode()
    {
        return fileMode;
    }
    public void setFileMode(String fileMode)
    {
        this.fileMode = fileMode;
    }
    public String getSavePathJava()
    {
        return savePathJava;
    }
    public void setSavePathJava(String savePathJava)
    {
        this.savePathJava = savePathJava;
    }
    public String getMsgFileName()
    {
        return msgFileName;
    }
    public void setMsgFileName(String msgFileName)
    {
        this.msgFileName = msgFileName;
    }
    public String getPrintSwiftHistory()
    {
        return printSwiftHistory;
    }
    public void setPrintSwiftHistory(String printSwiftHistory)
    {
        this.printSwiftHistory = printSwiftHistory;
    }
    public BigDecimal getBdCompCode()
    {
        return bdCompCode;
    }
    public void setBdCompCode(BigDecimal bdCompCode)
    {
        this.bdCompCode = bdCompCode;
    }
    public BigDecimal getBdTrsNO()
    {
        return bdTrsNO;
    }
    public void setBdTrsNO(BigDecimal bdTrsNO)
    {
        this.bdTrsNO = bdTrsNO;
    }
    public String getTrxType()
    {
        return trxType;
    }
    public void setTrxType(String trxType)
    {
        this.trxType = trxType;
    }
    public String getsModule()
    {
        return sModule;
    }
    public void setsModule(String sModule)
    {
        this.sModule = sModule;
    }
    public BigDecimal getBdMsgOrder()
    {
        return bdMsgOrder;
    }
    public void setBdMsgOrder(BigDecimal bdMsgOrder)
    {
        this.bdMsgOrder = bdMsgOrder;
    }
    
    
    
}
