package com.path.vo.common.dynfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: ElieAchkar
 *
 * DynFilesCO.java used to store the headers and details of the file to be displayed on the screen
 */

public class DynFilesImportCO extends BaseVO
{
    LinkedHashMap<String, String> colMap;
    LinkedHashMap<String, DynFilesColDetails> colMapWithDetails;
    ArrayList<Map<String, String>> rowMapList;
    private BigDecimal batchNumber;
    
    public BigDecimal getBatchNumber()
    {
        return batchNumber;
    }
    public void setBatchNumber(BigDecimal batchNumber)
    {
        this.batchNumber = batchNumber;
    }
    
    public LinkedHashMap<String, String> getColMap()
    {
        return colMap;
    }
    public void setColMap(LinkedHashMap<String, String> colMap)
    {
        this.colMap = colMap;
    }
    public LinkedHashMap<String, DynFilesColDetails> getColMapWithDetails()
    {
        return colMapWithDetails;
    }
    public void setColMapWithDetails(LinkedHashMap<String, DynFilesColDetails> colMapWithDetails)
    {
        this.colMapWithDetails = colMapWithDetails;
    }
    public ArrayList<Map<String, String>> getRowMapList()
    {
        return rowMapList;
    }
    public void setRowMapList(ArrayList<Map<String, String>> rowMapList)
    {
        this.rowMapList = rowMapList;
    }
}
