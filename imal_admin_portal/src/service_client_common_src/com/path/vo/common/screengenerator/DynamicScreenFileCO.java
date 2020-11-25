package com.path.vo.common.screengenerator;

import java.io.File;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2018, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: AdelNasrallah
 *
 * DynamicScreenCreatorCO.java used to
 */
public class DynamicScreenFileCO extends BaseVO
{
    private File uploadFile;
    private String uploadFileContentType;
    private String uploadFileFileName;
    private byte[] byteArrUpload;
    private String tableName;
    private String columnName;
    private String primaryKeyStr;
    //TP#989676 Dynamic Screen Button to Save Child Screen opened from Parent with Parent Submit - Enhancement
    private String uploadFileContent;
    
    public File getUploadFile()
    {
        return uploadFile;
    }
    public void setUploadFile(File uploadFile)
    {
        this.uploadFile = uploadFile;
    }
    public String getUploadFileContentType()
    {
        return uploadFileContentType;
    }
    public void setUploadFileContentType(String uploadFileContentType)
    {
        this.uploadFileContentType = uploadFileContentType;
    }
    public String getUploadFileFileName()
    {
        return uploadFileFileName;
    }
    public void setUploadFileFileName(String uploadFileFileName)
    {
        this.uploadFileFileName = uploadFileFileName;
    }
    public byte[] getByteArrUpload()
    {
	return byteArrUpload;
    }
    public void setByteArrUpload(byte[] byteArrUpload)
    {
	this.byteArrUpload = byteArrUpload;
    }
    public String getTableName()
    {
	return tableName;
    }
    public void setTableName(String tableName)
    {
	this.tableName = tableName;
    }
    public String getColumnName()
    {
	return columnName;
    }
    public void setColumnName(String columnName)
    {
	this.columnName = columnName;
    }
    public String getPrimaryKeyStr()
    {
        return primaryKeyStr;
    }
    public void setPrimaryKeyStr(String primaryKeyStr)
    {
        this.primaryKeyStr = primaryKeyStr;
    }
    /**
     * @return the uploadFileContent
     */
    public String getUploadFileContent()
    {
	return uploadFileContent;
    }
    /**
     * @param uploadFileContent the uploadFileContent to set
     */
    public void setUploadFileContent(String uploadFileContent)
    {
	this.uploadFileContent = uploadFileContent;
    }
}
