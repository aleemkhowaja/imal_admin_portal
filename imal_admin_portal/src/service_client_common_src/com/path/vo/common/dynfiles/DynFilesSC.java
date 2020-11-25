package com.path.vo.common.dynfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import com.path.bo.common.dynfiles.DynFilesTagAttributes;
import com.path.dbmaps.vo.DF_DATA_IMPORT_TMPVO;
import com.path.struts2.lib.common.GridParamsSC;

/**
 * @author Elie Achkar
 * 
 */
@SuppressWarnings("serial")
public class DynFilesSC extends GridParamsSC
{
    private String compName;
    private String compNameArab;
    private Date todayDate;
    private Date systemDate;
    private BigDecimal baseCurr;
    private String baseCurrName;
    private BigDecimal baseCurrDecPoint;
    private String reference;
    private BigDecimal fiscalYear;
    private String appName;
    private String structType;
    private Date serverDate;
    private String dynamicSQL;
    private String fileCode;
    private Date processingDate;
    private int fromRow;
    private int rowRange;
    private BigDecimal sourceSQLNo;
    private int lineNumber;
    private String folderPath;
    private String tableName;
    private String fileType;
    private int fileGroup;
    private String commitEachSelect;
    private String updateScript;
    private int proceed;
    private int runImmediatly;
    private int currLineNo;
    private String message;
    private int status;
    private BigDecimal tagNo;
    private BigDecimal inpParamNo;
    private String inpParamDispValue;
    private BigDecimal exposureCurrency;
    private String exposureCurrencyName;
    private boolean isDynFiles;
    private ArrayList<DF_DATA_IMPORT_TMPVO> dfDataImportTmp;
    private int maxTagsCount;
    private LinkedHashMap<Integer, ArrayList<String>> tagsValues = new LinkedHashMap<Integer, ArrayList<String>>();
    private int isOrdered;
    private String profType;
    private BigDecimal threadId;
    private int numberOfThreads;
    private List<Integer> threadIdsList;
    private BigDecimal errorCode;
    private String errorType;
    private String errorMessage;
    private String dynFileName;
    private int isEmpty;//EFARAH FIBSI180308
    private BigDecimal batchNo;
    private Date batchSystemDate;
    private BigDecimal batchType;
    private BigDecimal batchFileType;
    private String getProcessed;
    private String bfAfFlag;
    private BigDecimal changedTagName,tagSqlNumber;
    private String sqlStatement;
    private BigDecimal selectedFileType;
    private boolean validXml;
    ArrayList<DynFilesTagAttributes> tagAttributes = new ArrayList<DynFilesTagAttributes>();
    private BigDecimal attributeTagSqlNo;
    private boolean fillXMLSQLInputValues;
    public boolean isFillXMLSQLInputValues()
    {
        return fillXMLSQLInputValues;
    }
    public void setFillXMLSQLInputValues(boolean fillXMLSQLInputValues)
    {
        this.fillXMLSQLInputValues = fillXMLSQLInputValues;
    }
    public BigDecimal getAttributeTagSqlNo()
    {
        return attributeTagSqlNo;
    }
    public void setAttributeTagSqlNo(BigDecimal attributeTagSqlNo)
    {
        this.attributeTagSqlNo = attributeTagSqlNo;
    }
    public ArrayList<DynFilesTagAttributes> getTagAttributes()
    {
        return tagAttributes;
    }
    public void setTagAttributes(ArrayList<DynFilesTagAttributes> tagAttributes)
    {
        this.tagAttributes = tagAttributes;
    }
    
    public BigDecimal getTagSqlNumber()
    {
        return tagSqlNumber;
    }
    public void setTagSqlNumber(BigDecimal tagSqlNumber)
    {
        this.tagSqlNumber = tagSqlNumber;
    }
    public String getSqlStatement()
    {
        return sqlStatement;
    }
    public void setSqlStatement(String sqlStatement)
    {
        this.sqlStatement = sqlStatement;
    }
    public BigDecimal getChangedTagName()
    {
        return changedTagName;
    }
    public void setChangedTagName(BigDecimal changedTagName)
    {
        this.changedTagName = changedTagName;
    }
    
    public String getBfAfFlag()
    {
        return bfAfFlag;
    }
    public void setBfAfFlag(String bfAfFlag)
    {
        this.bfAfFlag = bfAfFlag;
    }
    public BigDecimal getBatchFileType()
    {
        return batchFileType;
    }
    public void setBatchFileType(BigDecimal batchFileType)
    {
        this.batchFileType = batchFileType;
    }
    public BigDecimal getBatchType()
    {
        return batchType;
    }
    public void setBatchType(BigDecimal batchType)
    {
        this.batchType = batchType;
    }
    public Date getBatchSystemDate()
    {
        return batchSystemDate;
    }
    public void setBatchSystemDate(Date batchSystemDate)
    {
        this.batchSystemDate = batchSystemDate;
    }
    public BigDecimal getBatchNo()
    {
        return batchNo;
    }
    public void setBatchNo(BigDecimal batchNo)
    {
        this.batchNo = batchNo;
    }
    public int getIsEmpty()
    {
        return isEmpty;
    }
    public void setIsEmpty(int isEmpty)
    {
        this.isEmpty = isEmpty;
    }
    public int getLineNumber()
    {
	return lineNumber;
    }
    public void setLineNumber(int lineNumber)
    {
	this.lineNumber = lineNumber;
    }
    public BigDecimal getSourceSQLNo()
    {
	return sourceSQLNo;
    }
    public void setSourceSQLNo(BigDecimal sourceSQLNo)
    {
	this.sourceSQLNo = sourceSQLNo;
    }
    public int getFromRow()
    {
	return fromRow;
    }
    public void setFromRow(int fromRow)
    {
	this.fromRow = fromRow;
    }
    public int getRowRange()
    {
	return rowRange;
    }
    public void setRowRange(int rowRange)
    {
	this.rowRange = rowRange;
    }
    public String getFileCode()
    {
	return fileCode;
    }
    public void setFileCode(String fileCode)
    {
	this.fileCode = fileCode;
    }
    public String getStructCode()
    {
	return structCode;
    }
    public void setStructCode(String structCode)
    {
	this.structCode = structCode;
    }
    private String structCode;

    public BigDecimal getBaseCurr()
    {	
	return baseCurr;
    }
    public void setBaseCurr(BigDecimal baseCurr)
    {
	this.baseCurr = baseCurr;
    }
    public String getBaseCurrName()
    {
        return baseCurrName;
    }
    public void setBaseCurrName(String baseCurrName)
    {
        this.baseCurrName = baseCurrName;
    }
    public BigDecimal getBaseCurrDecPoint()
    {
        return baseCurrDecPoint;
    }
    public void setBaseCurrDecPoint(BigDecimal baseCurrDecPoint)
    {
        this.baseCurrDecPoint = baseCurrDecPoint;
    }
    public String getAppName()
    {
	return appName;
    }
    public void setAppName(String appName)
    {
	this.appName = appName;
    }
    public String getStructType()
    {
	return structType;
    }
    public void setStructType(String structType)
    {
	this.structType = structType;
    }
    public String getDynamicSQL()
    {
	return dynamicSQL;
    }
    public void setDynamicSQL(String dynamicSQL)
    {
	this.dynamicSQL = dynamicSQL;
    }
    public String getCompName()
    {
	return compName;
    }
    public void setCompName(String compName)
    {
	this.compName = compName;
    }
    public String getCompNameArab()
    {
        return compNameArab;
    }
    public void setCompNameArab(String compNameArab)
    {
        this.compNameArab = compNameArab;
    }
    public Date getTodayDate()
    {
	return todayDate;
    }
    public void setTodayDate(Date todayDate)
    {
	this.todayDate = todayDate;
    }
    public Date getSystemDate()
    {
	return systemDate;
    }
    public void setSystemDate(Date systemDate)
    {
	this.systemDate = systemDate;
    }
    public String getReference()
    {
	return reference;
    }
    public void setReference(String reference)
    {
	this.reference = reference;
    }
    public BigDecimal getFiscalYear()
    {
	return fiscalYear;
    }
    public void setFiscalYear(BigDecimal fiscalYear)
    {
	this.fiscalYear = fiscalYear;
    }
    public Date getServerDate()
    {
	return serverDate;
    }
    public void setServerDate(Date serverDate)
    {
	this.serverDate = serverDate;
    }
    public Date getProcessingDate()
    {
	return processingDate;
    }
    public void setProcessingDate(Date processingDate)
    {
	this.processingDate = processingDate;
    }
    public String getFolderPath()
    {
	return folderPath;
    }
    public void setFolderPath(String folderPath)
    {
	this.folderPath = folderPath;
    }
    public String getTableName()
    {
	return tableName;
    }
    public void setTableName(String tableName)
    {
	this.tableName = tableName;
    }
    public String getFileType()
    {
	return fileType;
    }
    public void setFileType(String fileType)
    {
	this.fileType = fileType;
    }
    public int getFileGroup()
    {
	return fileGroup;
    }
    public void setFileGroup(int fileGroup)
    {
	this.fileGroup = fileGroup;
    }
    public String getCommitEachSelect()
    {
	return commitEachSelect;
    }
    public void setCommitEachSelect(String commitEachSelect)
    {
	this.commitEachSelect = commitEachSelect;
    }
    public String getUpdateScript()
    {
	return updateScript;
    }
    public void setUpdateScript(String updateScript)
    {
	this.updateScript = updateScript;
    }
    public int getProceed()
    {
	return proceed;
    }
    public void setProceed(int proceed)
    {
	this.proceed = proceed;
    }
    public int getRunImmediatly()
    {
	return runImmediatly;
    }
    public void setRunImmediatly(int runImmediatly)
    {
	this.runImmediatly = runImmediatly;
    }
    public int getCurrLineNo() 
    {
	return currLineNo;
    }
    public void setCurrLineNo(int currLineNo) 
    {
	this.currLineNo = currLineNo;
    }
    public String getMessage() 
    {
	return message;
    }
    public void setMessage(String message) 
    {
	this.message = message;
    }
    public int getStatus() 
    {
	return status;
    }
    public void setStatus(int status) 
    {
	this.status = status;
    }
    public BigDecimal getTagNo() 
    {
	return tagNo;
    }
    public void setTagNo(BigDecimal tagNo) 
    {
	this.tagNo = tagNo;
    }
    public void setInpParamNo(BigDecimal inpParamNo) 
    {
	this.inpParamNo = inpParamNo;
    }
    public BigDecimal getInpParamNo() 
    {
	return inpParamNo;
    }
    public void setInpParamDispValue(String inpParamDispValue) 
    {
	this.inpParamDispValue = inpParamDispValue;
    }
    public String getInpParamDispValue() 
    {
	return inpParamDispValue;
    }
    public BigDecimal getExposureCurrency()
    {
	return exposureCurrency;
    }
    public void setExposureCurrency(BigDecimal exposureCurrency)
    {
	this.exposureCurrency = exposureCurrency;
    }
    public String getExposureCurrencyName()
    {
        return exposureCurrencyName;
    }
    public void setExposureCurrencyName(String exposureCurrencyName)
    {
        this.exposureCurrencyName = exposureCurrencyName;
    }
    public boolean isDynFiles()
    {
        return isDynFiles;
    }
    public void setDynFiles(boolean isDynFiles)
    {
        this.isDynFiles = isDynFiles;
    }
    public void setDfDataImportTmp(ArrayList<DF_DATA_IMPORT_TMPVO> dfDataImportTmp)
    {
	this.dfDataImportTmp = dfDataImportTmp;
    }
    public ArrayList<DF_DATA_IMPORT_TMPVO> getDfDataImportTmp()
    {
	return dfDataImportTmp;
    }
    public int getMaxTagsCount()
    {
        return maxTagsCount;
    }
    public void setMaxTagsCount(int maxTagsCount)
    {
        this.maxTagsCount = maxTagsCount;
    }
    public LinkedHashMap<Integer, ArrayList<String>> getTagsValues()
    {
        return tagsValues;
    }
    public void setTagsValues(LinkedHashMap<Integer, ArrayList<String>> tagsValues)
    {
        this.tagsValues = tagsValues;
    }
    public void setIsOrdered(int isOrdered)
    {
	this.isOrdered = isOrdered;
    }
    public int getIsOrdered()
    {
	return isOrdered;
    }
    public String getProfType()
    {
        return profType;
    }
    public void setProfType(String profType)
    {
        this.profType = profType;
    }
    public BigDecimal getThreadId()
    {
        return threadId;
    }
    public void setThreadId(BigDecimal threadId)
    {
        this.threadId = threadId;
    }
    public int getNumberOfThreads()
    {
        return numberOfThreads;
    }
    public void setNumberOfThreads(int numberOfThreads)
    {
        this.numberOfThreads = numberOfThreads;
    }
    public List<Integer> getThreadIdsList()
    {
        return threadIdsList;
    }
    public void setThreadIdsList(List<Integer> threadIdsList)
    {
        this.threadIdsList = threadIdsList;
    }
    public BigDecimal getErrorCode()
    {
        return errorCode;
    }
    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }
    public String getErrorType()
    {
        return errorType;
    }
    public void setErrorType(String errorType)
    {
        this.errorType = errorType;
    }
    public String getErrorMessage()
    {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
    public String getDynFileName()
    {
        return dynFileName;
    }
    public void setDynFileName(String dynFileName)
    {
        this.dynFileName = dynFileName;
    }
    public String getGetProcessed()
    {
        return getProcessed;
    }
    public void setGetProcessed(String getProcessed)
    {
        this.getProcessed = getProcessed;
    }
    public BigDecimal getSelectedFileType()
    {
        return selectedFileType;
    }
    public void setSelectedFileType(BigDecimal selectedFileType)
    {
        this.selectedFileType = selectedFileType;
    }
    public boolean isValidXml()
    {
        return validXml;
    }
    public void setValidXml(boolean validXml)
    {
        this.validXml = validXml;
    }


}