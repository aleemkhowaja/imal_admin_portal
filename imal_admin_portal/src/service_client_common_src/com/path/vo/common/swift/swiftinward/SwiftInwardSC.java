package com.path.vo.common.swift.swiftinward;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Mohammed Itani
 * 
 *          SwiftInwardSC.java used to prepare all properties needed for the
 *          DAO to interact with SwiftInwardMapper.xml
 */
public class SwiftInwardSC extends GridParamsSC
{
    private String MSG_CODE;
    private BigDecimal SEQ;
    private BigDecimal ACK;
    private String inwardPath;
    private String archivePath;
    private String severity;
    private Date logDate,engineInDate;
    private BigDecimal refreshRate;
    private String serviceName,engineInDateString;
    private String serviceStatus;
    private int inOutParam;
    private String storedProcedure;
    
    
    
    
    public Date getEngineInDate() {
		return engineInDate;
	}

	public void setEngineInDate(Date engineInDate) {
		this.engineInDate = engineInDate;
	}

	public String getEngineInDateString() {
		return engineInDateString;
	}

	public void setEngineInDateString(String engineInDateString) {
		this.engineInDateString = engineInDateString;
	}

	public String getStoredProcedure()
    {
        return storedProcedure;
    }

    public void setStoredProcedure(String storedProcedure)
    {
        this.storedProcedure = storedProcedure;
    }

    public int getInOutParam()
    {
        return inOutParam;
    }

    public void setInOutParam(int inOutParam)
    {
        this.inOutParam = inOutParam;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public String getServiceStatus()
    {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus)
    {
        this.serviceStatus = serviceStatus;
    }
    
    public BigDecimal getRefreshRate()
    {
        return refreshRate;
    }

    public void setRefreshRate(BigDecimal refreshRate)
    {
        this.refreshRate = refreshRate;
    }

    public Date getLogDate()
    {
        return logDate;
    }

    public void setLogDate(Date logDate)
    {
        this.logDate = logDate;
    }

    public String getSeverity()
    {
        return severity;
    }

    public void setSeverity(String severity)
    {
        this.severity = severity;
    }

    public String getInwardPath()
    {
        return inwardPath;
    }

    public void setInwardPath(String inwardPath)
    {
        this.inwardPath = inwardPath;
    }

    public String getArchivePath()
    {
        return archivePath;
    }

    public void setArchivePath(String archivePath)
    {
        this.archivePath = archivePath;
    }
    
    public String getMSG_CODE()
    {
	return MSG_CODE;
    }

    public void setMSG_CODE(String mSGCODE)
    {
	MSG_CODE = mSGCODE;
    }

    public BigDecimal getSEQ()
    {
	return SEQ;
    }

    public void setSEQ(BigDecimal sEQ)
    {
	SEQ = sEQ;
    }

    public BigDecimal getACK()
    {
	return ACK;
    }

    public void setACK(BigDecimal aCK)
    {
	ACK = aCK;
    }

}
