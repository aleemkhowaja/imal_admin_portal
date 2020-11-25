package com.path.vo.common.swift.swiftoutward;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: CharbelObeidi
 * 
 *          SwiftOutwardSC.java used to prepare all properties needed for the
 *          DAO to interact with SwiftMapper.xml
 */
public class SwiftOutwardSC extends GridParamsSC
{
    private Date nextReplication;
    private BigDecimal repId;
    private String repTitle;
    private String severity;
    private char genMode;
    private String errorMsg;
    private Date logDate;
    private String serviceName;
    private String serviceStatus;
    private Date holValueDate;
    private int holidayCode;
    private String dynamicUpdateStmt;
    private BigDecimal maxAccTrsNo;
    private String msgCode;
    private String module;
    private String transType;
    private BigDecimal trsNo;
    private BigDecimal msgOrder;
    private String appName;
    private String progRef;
    private String progType;
    private BigDecimal refreshRate;
    private String logFileLocation;

    // These fields added for reports procedures MItani 04/04/2014
    private String status,engineDateString;
    private Date trsFromDate;
    private Date trsToDate,engineDate;
    private BigDecimal trsFromNo;
    private BigDecimal trsToNo;  
    private String sReportProcedure;
    private ArrayList<Map<String,Object>> swiftSpResultList ;

    
    public String getEngineDateString() {
		return engineDateString;
	}

	public void setEngineDateString(String engineDateString) {
		this.engineDateString = engineDateString;
	}

	public Date getEngineDate() {
		return engineDate;
	}

	public void setEngineDate(Date engineDate) {
		this.engineDate = engineDate;
	}

	public ArrayList<Map<String,Object>> getSwiftSpResultList()
    {
	return swiftSpResultList;	
    }
    
    public void setSwiftSpResultList(ArrayList<Map<String,Object>> swiftSpResultList)
    {	
	this.swiftSpResultList = swiftSpResultList;
    }
    
    public String getSReportProcedure()
    {
	return sReportProcedure;	
    }
    
    public void setSReportProcedure(String sReportProcedure)
    {
	this.sReportProcedure = sReportProcedure;
    }
    
    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;

    }

    public Date getTrsFromDate()
    {
	return trsFromDate;
    }

    public void setTrsFromDate(Date trsFromDate)
    {
	this.trsFromDate = trsFromDate;
    }

    public Date getTrsToDate()
    {
	return trsToDate;
    }

    public void setTrsToDate(Date trsToDate)
    {
	this.trsToDate = trsToDate;
    }

    public BigDecimal getTrsFromNo()
    {
	return trsFromNo;
    }
    public void setTrsFromNo(BigDecimal trsFromNo)
    {
	this.trsFromNo=trsFromNo;
    }
    
    public BigDecimal getTrsToNo()
    {
	return trsToNo;
    }
    public void setTrsToNo(BigDecimal trsToNo)
    {
	this.trsToNo=trsToNo;
    }
       
    public BigDecimal getRefreshRate()
    {
	return refreshRate;
    }

    public void setRefreshRate(BigDecimal refreshRate)
    {
	this.refreshRate = refreshRate;
    }

    public String getProgType()
    {
	return progType;
    }

    public void setProgType(String progType)
    {
	this.progType = progType;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public BigDecimal getTrsNo()
    {
	return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
	this.trsNo = trsNo;
    }

    public BigDecimal getMsgOrder()
    {
	return msgOrder;
    }

    public void setMsgOrder(BigDecimal msgOrder)
    {
	this.msgOrder = msgOrder;
    }

    public String getMsgCode()
    {
	return msgCode;
    }

    public void setMsgCode(String msgCode)
    {
	this.msgCode = msgCode;
    }

    public String getModule()
    {
	return module;
    }

    public void setModule(String module)
    {
	this.module = module;
    }

    public String getTransType()
    {
	return transType;
    }

    public void setTransType(String transType)
    {
	this.transType = transType;
    }

    public BigDecimal getMaxAccTrsNo()
    {
	return maxAccTrsNo;
    }

    public void setMaxAccTrsNo(BigDecimal maxAccTrsNo)
    {
	this.maxAccTrsNo = maxAccTrsNo;
    }

    public String getDynamicUpdateStmt()
    {
	return dynamicUpdateStmt;
    }

    public void setDynamicUpdateStmt(String dynamicUpdateStmt)
    {
	this.dynamicUpdateStmt = dynamicUpdateStmt;
    }

    public Date getHolValueDate()
    {
	return holValueDate;
    }

    public void setHolValueDate(Date holValueDate)
    {
	this.holValueDate = holValueDate;
    }

    public int getHolidayCode()
    {
	return holidayCode;
    }

    public void setHolidayCode(int holidayCode)
    {
	this.holidayCode = holidayCode;
    }

    public String getServiceStatus()
    {
	return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus)
    {
	this.serviceStatus = serviceStatus;
    }

    public String getServiceName()
    {
	return serviceName;
    }

    public void setServiceName(String serviceName)
    {
	this.serviceName = serviceName;
    }

    public BigDecimal getRepId()
    {
	return repId;
    }

    public void setRepId(BigDecimal repId)
    {
	this.repId = repId;
    }

    public String getRepTitle()
    {
	return repTitle;
    }

    public void setRepTitle(String repTitle)
    {
	this.repTitle = repTitle;
    }

    public String getSeverity()
    {
	return severity;
    }

    public void setSeverity(String severity)
    {
	this.severity = severity;
    }

    public char getGenMode()
    {
	return genMode;
    }

    public void setGenMode(char genMode)
    {
	this.genMode = genMode;
    }

    public String getErrorMsg()
    {
	return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
	this.errorMsg = errorMsg;
    }

    public Date getNextReplication()
    {
	return nextReplication;
    }

    public void setNextReplication(Date nextReplication)
    {
	this.nextReplication = nextReplication;
    }

    public Date getLogDate()
    {
	return logDate;
    }

    public void setLogDate(Date logDate)
    {
	this.logDate = logDate;
    }

    public String getLogFileLocation()
    {
	return logFileLocation;
    }

    public void setLogFileLocation(String logFileLocation)
    {
	this.logFileLocation = logFileLocation;
    }

}
