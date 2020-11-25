/**
 * 
 */
package com.path.vo.common.dynclientparams;

import com.path.dbmaps.vo.SYS_DYN_PARAM_COLUMNSVOWithBLOBs;
import com.path.lib.vo.BaseVO;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: rabihelkhatib
 *
 * DynClientParamsCO.java used to store the dynamic client params Value objects
 */
@SuppressWarnings("serial")
public class DynClientParamsCO extends BaseVO
{
    private SYS_DYN_PARAM_COLUMNSVOWithBLOBs		sysDynParamColumns = new SYS_DYN_PARAM_COLUMNSVOWithBLOBs();

    private String dynKey;
    
    private String recordStatus;
    
    private String controlDesc;
    
    
    public SYS_DYN_PARAM_COLUMNSVOWithBLOBs getSysDynParamColumns()
    {
        return sysDynParamColumns;
    }

    public void setSysDynParamColumns(SYS_DYN_PARAM_COLUMNSVOWithBLOBs sysDynParamColumns)
    {
        this.sysDynParamColumns = sysDynParamColumns;
    }

    public String getDynKey()
    {
        return dynKey;
    }

    public void setDynKey(String dynKey)
    {
        this.dynKey = dynKey;
    }

    public String getRecordStatus()
    {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus)
    {
        this.recordStatus = recordStatus;
    }

    public String getControlDesc()
    {
        return controlDesc;
    }

    public void setControlDesc(String controlDesc)
    {
        this.controlDesc = controlDesc;
    }
    
}
