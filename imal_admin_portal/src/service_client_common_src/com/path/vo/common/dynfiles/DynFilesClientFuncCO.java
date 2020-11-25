package com.path.vo.common.dynfiles;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: ElieAchkar
 *
 * DynFilesCO.java used to store the files to be displayed on the screen 
 */

public class DynFilesClientFuncCO extends BaseVO
{

    private String INP_PARM_NAME,INP_PARM_VALUE,FILE_CODE,FUNC_NAME;
    private BigDecimal FUNC_NO,INP_PARM_NO,COMP_CODE;
    private byte[] fileContent;
    
    public BigDecimal getCOMP_CODE()
    {
        return COMP_CODE;
    }
    public void setCOMP_CODE(BigDecimal cOMP_CODE)
    {
        COMP_CODE = cOMP_CODE;
    }
    public String getINP_PARM_NAME()
    {
        return INP_PARM_NAME;
    }
    public void setINP_PARM_NAME(String iNP_PARM_NAME)
    {
        INP_PARM_NAME = iNP_PARM_NAME;
    }
    public String getINP_PARM_VALUE()
    {
        return INP_PARM_VALUE;
    }
    public void setINP_PARM_VALUE(String iNP_PARM_VALUE)
    {
        INP_PARM_VALUE = iNP_PARM_VALUE;
    }
    public String getFILE_CODE()
    {
        return FILE_CODE;
    }
    public void setFILE_CODE(String fILE_CODE)
    {
        FILE_CODE = fILE_CODE;
    }
    public String getFUNC_NAME()
    {
        return FUNC_NAME;
    }
    public void setFUNC_NAME(String fUNC_NAME)
    {
        FUNC_NAME = fUNC_NAME;
    }
    public BigDecimal getFUNC_NO()
    {
        return FUNC_NO;
    }
    public void setFUNC_NO(BigDecimal fUNC_NO)
    {
        FUNC_NO = fUNC_NO;
    }
    public BigDecimal getINP_PARM_NO()
    {
        return INP_PARM_NO;
    }
    public void setINP_PARM_NO(BigDecimal iNP_PARM_NO)
    {
        INP_PARM_NO = iNP_PARM_NO;
    }
    public byte[] getFileContent()
    {
        return fileContent;
    }
    public void setFileContent(byte[] fileContent)
    {
        this.fileContent = fileContent;
    }
}
