package com.path.vo.common.dynclientparams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: rabihelkhatib
 * 
 *          DynClientParamsSC.java used to store the search criteria for Dynamic Client's Params
 *          Screen
 */

public class DynClientParamsSC extends GridParamsSC
{
    private BigDecimal groupCode;
    private String tableName;
    private String tableDesc;
    private String dynamicQuery;
    private String valueField;
    private String lookupVal;
    private String displayField;
    private String lookupQuery;
    private String pkCols;
    private String colsNames;
    private String dynCltRecStatus;
    private String dynCltParOpType;
    private ArrayList<DynClientParamsCO> colsList;
    private DynClientParamsCO auditCO = new DynClientParamsCO();
    Map<String, Object> params = new HashMap<String, Object>();
    HashMap<String, String> colsValues = new HashMap<String, String>();
    private String dynCltParamsGridUpd;
    private List<DynClientParamsCO> modSysDynParamColumns; // used to store  dynamic client params to be modified
    private List<DynClientParamsCO> addSysDynParamColumns; // used to store  dynamic client params to be added
    private List<DynClientParamsCO> delSysDynParamColumns; // used to store  dynamic client params to be deleted

    
    public void setGroupCode(BigDecimal groupCode)
    {
	this.groupCode = groupCode;
    }

    public BigDecimal getGroupCode()
    {
	return groupCode;
    }

    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getDynamicQuery()
    {
        return dynamicQuery;
    }

    public void setDynamicQuery(String dynamicQuery)
    {
        this.dynamicQuery = dynamicQuery;
    }
    public String getValueField()
    {
        return valueField;
    }

    public void setValueField(String valueField)
    {
        this.valueField = valueField;
    }

    public String getDisplayField()
    {
        return displayField;
    }

    public void setDisplayField(String displayField)
    {
        this.displayField = displayField;
    }
    
    public Map<String, Object> getParams()
    {
        return params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }
    public ArrayList<DynClientParamsCO> getColsList()
    {
        return colsList;
    }

    public void setColsList(ArrayList<DynClientParamsCO> colsList)
    {
        this.colsList = colsList;
    }

    public String getLookupQuery()
    {
        return lookupQuery;
    }

    public void setLookupQuery(String lookupQuery)
    {
        this.lookupQuery = lookupQuery;
    }

    public String getPkCols()
    {
        return pkCols;
    }

    public void setPkCols(String pkCols)
    {
        this.pkCols = pkCols;
    }

    public String getColsNames()
    {
        return colsNames;
    }

    public void setColsNames(String colsNames)
    {
        this.colsNames = colsNames;
    }

    public HashMap<String, String> getColsValues()
    {
        return colsValues;
    }

    public void setColsValues(HashMap<String, String> colsValues)
    {
        this.colsValues = colsValues;
    }

    public void setDynCltRecStatus(String dynCltRecStatus)
    {
	this.dynCltRecStatus = dynCltRecStatus;
    }

    public String getDynCltRecStatus()
    {
	return dynCltRecStatus;
    }

    public void setDynCltParOpType(String dynCltParOpType)
    {
	this.dynCltParOpType = dynCltParOpType;
    }

    public String getDynCltParOpType()
    {
	return dynCltParOpType;
    }

    public String getLookupVal()
    {
        return lookupVal;
    }

    public void setLookupVal(String lookupVal)
    {
        this.lookupVal = lookupVal;
    }

    public String getTableDesc()
    {
        return tableDesc;
    }

    public void setTableDesc(String tableDesc)
    {
        this.tableDesc = tableDesc;
    }

    public DynClientParamsCO getAuditCO()
    {
        return auditCO;
    }

    public void setAuditCO(DynClientParamsCO auditCO)
    {
        this.auditCO = auditCO;
    }

    public String getDynCltParamsGridUpd()
    {
        return dynCltParamsGridUpd;
    }

    public void setDynCltParamsGridUpd(String dynCltParamsGridUpd)
    {
        this.dynCltParamsGridUpd = dynCltParamsGridUpd;
    }

    public List<DynClientParamsCO> getModSysDynParamColumns()
    {
        return modSysDynParamColumns;
    }

    public void setModSysDynParamColumns(List<DynClientParamsCO> modSysDynParamColumns)
    {
        this.modSysDynParamColumns = modSysDynParamColumns;
    }

    public List<DynClientParamsCO> getAddSysDynParamColumns()
    {
        return addSysDynParamColumns;
    }

    public void setAddSysDynParamColumns(List<DynClientParamsCO> addSysDynParamColumns)
    {
        this.addSysDynParamColumns = addSysDynParamColumns;
    }

    public List<DynClientParamsCO> getDelSysDynParamColumns()
    {
        return delSysDynParamColumns;
    }

    public void setDelSysDynParamColumns(List<DynClientParamsCO> delSysDynParamColumns)
    {
        this.delSysDynParamColumns = delSysDynParamColumns;
    }

}
