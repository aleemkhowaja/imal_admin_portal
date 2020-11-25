/**
 * 
 */
package com.path.vo.common;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * LicensesInfoCO.java used to
 */
public class PathCounterLcCO extends BaseVO
{
  private BigDecimal dbId;
  private BigDecimal tableId1;
  private BigDecimal tableId2;
  private BigDecimal tableId3;
  private Date       serverDateTime;
  private String     lsError1;
  private String     theTime;
  private String     field5;
  private String     field7;
  private BigDecimal tableSeq;
  private String     encryptedData;
  
  
  /**
   * parsed inforamtion
   */
  private String     saError;
  private Date       ldtDateObj;
  private String     lsTime;
  private BigDecimal tableId;
  private BigDecimal sessionId;
  private BigDecimal oldCounter;
  private BigDecimal compCode;
  private BigDecimal branchCode;
  private String     appName;
  private String     oldVersion;
  private String     lcAudit;
  private String     lsErrorT;
  private String     lsError;
  private String     lsCounter;
  
  /**
   * counter information
   */
  private String     errorCode;
  private BigDecimal counter1;
  private BigDecimal counter2;
  private BigDecimal counter3;
  
  private String     dataStr;
  private String     tableName;
/**
 * @return the lsError1
 */
public String getLsError1()
{
    return lsError1;
}
/**
 * @param lsError1 the lsError1 to set
 */
public void setLsError1(String lsError1)
{
    this.lsError1 = lsError1;
}
/**
 * @return the serverDateTime
 */
public Date getServerDateTime()
{
    return serverDateTime;
}
/**
 * @param serverDateTime the serverDateTime to set
 */
public void setServerDateTime(Date serverDateTime)
{
    this.serverDateTime = serverDateTime;
}
/**
 * @return the theTime
 */
public String getTheTime()
{
    return theTime;
}
/**
 * @param theTime the theTime to set
 */
public void setTheTime(String theTime)
{
    this.theTime = theTime;
}
/**
 * @return the field5
 */
public String getField5()
{
    return field5;
}
/**
 * @param field5 the field5 to set
 */
public void setField5(String field5)
{
    this.field5 = field5;
}
/**
 * @return the tableSeq
 */
public BigDecimal getTableSeq()
{
    return tableSeq;
}
/**
 * @param tableSeq the tableSeq to set
 */
public void setTableSeq(BigDecimal tableSeq)
{
    this.tableSeq = tableSeq;
}
/**
 * @return the saError
 */
public String getSaError()
{
    return saError;
}
/**
 * @param saError the saError to set
 */
public void setSaError(String saError)
{
    this.saError = saError;
}
/**
 * @return the ldtDateObj
 */
public Date getLdtDateObj()
{
    return ldtDateObj;
}
/**
 * @param ldtDateObj the ldtDateObj to set
 */
public void setLdtDateObj(Date ldtDateObj)
{
    this.ldtDateObj = ldtDateObj;
}
/**
 * @return the lsTime
 */
public String getLsTime()
{
    return lsTime;
}
/**
 * @param lsTime the lsTime to set
 */
public void setLsTime(String lsTime)
{
    this.lsTime = lsTime;
}
/**
 * @return the tableId
 */
public BigDecimal getTableId()
{
    return tableId;
}
/**
 * @param tableId the tableId to set
 */
public void setTableId(BigDecimal tableId)
{
    this.tableId = tableId;
}
/**
 * @return the sessionId
 */
public BigDecimal getSessionId()
{
    return sessionId;
}
/**
 * @param sessionId the sessionId to set
 */
public void setSessionId(BigDecimal sessionId)
{
    this.sessionId = sessionId;
}
/**
 * @return the oldCounter
 */
public BigDecimal getOldCounter()
{
    return oldCounter;
}
/**
 * @param oldCounter the oldCounter to set
 */
public void setOldCounter(BigDecimal oldCounter)
{
    this.oldCounter = oldCounter;
}
/**
 * @return the compCode
 */
public BigDecimal getCompCode()
{
    return compCode;
}
/**
 * @param compCode the compCode to set
 */
public void setCompCode(BigDecimal compCode)
{
    this.compCode = compCode;
}
/**
 * @return the branchCode
 */
public BigDecimal getBranchCode()
{
    return branchCode;
}
/**
 * @param branchCode the branchCode to set
 */
public void setBranchCode(BigDecimal branchCode)
{
    this.branchCode = branchCode;
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
 * @return the oldVersion
 */
public String getOldVersion()
{
    return oldVersion;
}
/**
 * @param oldVersion the oldVersion to set
 */
public void setOldVersion(String oldVersion)
{
    this.oldVersion = oldVersion;
}
/**
 * @return the lcAudit
 */
public String getLcAudit()
{
    return lcAudit;
}
/**
 * @param lcAudit the lcAudit to set
 */
public void setLcAudit(String lcAudit)
{
    this.lcAudit = lcAudit;
}
/**
 * @return the lsErrorT
 */
public String getLsErrorT()
{
    return lsErrorT;
}
/**
 * @param lsErrorT the lsErrorT to set
 */
public void setLsErrorT(String lsErrorT)
{
    this.lsErrorT = lsErrorT;
}
/**
 * @return the lsError
 */
public String getLsError()
{
    return lsError;
}
/**
 * @param lsError the lsError to set
 */
public void setLsError(String lsError)
{
    this.lsError = lsError;
}
/**
 * @return the dbId
 */
public BigDecimal getDbId()
{
    return dbId;
}
/**
 * @param dbId the dbId to set
 */
public void setDbId(BigDecimal dbId)
{
    this.dbId = dbId;
}
/**
 * @return the tableId1
 */
public BigDecimal getTableId1()
{
    return tableId1;
}
/**
 * @param tableId1 the tableId1 to set
 */
public void setTableId1(BigDecimal tableId1)
{
    this.tableId1 = tableId1;
}
/**
 * @return the tableId2
 */
public BigDecimal getTableId2()
{
    return tableId2;
}
/**
 * @param tableId2 the tableId2 to set
 */
public void setTableId2(BigDecimal tableId2)
{
    this.tableId2 = tableId2;
}
/**
 * @return the tableId3
 */
public BigDecimal getTableId3()
{
    return tableId3;
}
/**
 * @param tableId3 the tableId3 to set
 */
public void setTableId3(BigDecimal tableId3)
{
    this.tableId3 = tableId3;
}
/**
 * @return the lsCounter
 */
public String getLsCounter()
{
    return lsCounter;
}
/**
 * @param lsCounter the lsCounter to set
 */
public void setLsCounter(String lsCounter)
{
    this.lsCounter = lsCounter;
}
/**
 * @return the errorCode
 */
public String getErrorCode()
{
    return errorCode;
}
/**
 * @param errorCode the errorCode to set
 */
public void setErrorCode(String errorCode)
{
    this.errorCode = errorCode;
}
/**
 * @return the counter1
 */
public BigDecimal getCounter1()
{
    return counter1;
}
/**
 * @param counter1 the counter1 to set
 */
public void setCounter1(BigDecimal counter1)
{
    this.counter1 = counter1;
}
/**
 * @return the counter2
 */
public BigDecimal getCounter2()
{
    return counter2;
}
/**
 * @param counter2 the counter2 to set
 */
public void setCounter2(BigDecimal counter2)
{
    this.counter2 = counter2;
}
/**
 * @return the counter3
 */
public BigDecimal getCounter3()
{
    return counter3;
}
/**
 * @param counter3 the counter3 to set
 */
public void setCounter3(BigDecimal counter3)
{
    this.counter3 = counter3;
}
/**
 * @return the dataStr
 */
public String getDataStr()
{
    return dataStr;
}
/**
 * @param dataStr the dataStr to set
 */
public void setDataStr(String dataStr)
{
    this.dataStr = dataStr;
}
/**
 * @return the tableName
 */
public String getTableName()
{
    return tableName;
}
/**
 * @param tableName the tableName to set
 */
public void setTableName(String tableName)
{
    this.tableName = tableName;
}
/**
 * @return the field7
 */
public String getField7()
{
    return field7;
}
/**
 * @param field7 the field7 to set
 */
public void setField7(String field7)
{
    this.field7 = field7;
}
/**
 * @return the encryptedData
 */
public String getEncryptedData()
{
    return encryptedData;
}
/**
 * @param encryptedData the encryptedData to set
 */
public void setEncryptedData(String encryptedData)
{
    this.encryptedData = encryptedData;
}
}
