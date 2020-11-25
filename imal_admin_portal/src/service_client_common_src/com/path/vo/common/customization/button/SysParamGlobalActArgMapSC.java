package com.path.vo.common.customization.button;

import java.math.BigDecimal;

import com.path.dbmaps.vo.SYS_PARAM_GLOBAL_ACT_ARG_MAPVO;
import com.path.struts2.lib.common.GridParamsSC;

public class SysParamGlobalActArgMapSC extends GridParamsSC
{
    private String mapDescription; 
    private String mapTypeDesc;
    private String screenPageRef;
    private String opIdDescription;
    private String apiType;
    private String mapDirection;
    private BigDecimal lovMapId;
    private BigDecimal apiCode;
    private String screenFldIdDesc;
    private String dynElemDescription;
    private String argDescription;
    private boolean specificFlag;
    private String changedStatus;
    private boolean loadedInObjDisplay;
    private String gridColumns;
    private BigDecimal elementType;
    //TP#934567 Button Customization Dynamic Screen Action Assignment - Parameter from Grid on Source Screen
    private String fromSource;
    private SYS_PARAM_GLOBAL_ACT_ARG_MAPVO sysParamGlobalActArgMapVO = new SYS_PARAM_GLOBAL_ACT_ARG_MAPVO();
    
    private BigDecimal lovDynParamType;
    private String dynParamTypeDesc;
    private String gridColumnName;
    
    public String getMapTypeDesc()
    {
        return mapTypeDesc;
    }

    public void setMapTypeDesc(String mapTypeDesc)
    {
        this.mapTypeDesc = mapTypeDesc;
    }

    public SYS_PARAM_GLOBAL_ACT_ARG_MAPVO getSysParamGlobalActArgMapVO()
    {
        return sysParamGlobalActArgMapVO;
    }

    public void setSysParamGlobalActArgMapVO(SYS_PARAM_GLOBAL_ACT_ARG_MAPVO sysParamGlobalActArgMapVO)
    {
        this.sysParamGlobalActArgMapVO = sysParamGlobalActArgMapVO;
    }
    
    public String getMapDescription()
    {
        return mapDescription;
    }

    public void setMapDescription(String mapDescription)
    {
        this.mapDescription = mapDescription;
    }
    
    public String getScreenPageRef()
    {
        return screenPageRef;
    }

    public void setScreenPageRef(String screenPageRef)
    {
        this.screenPageRef = screenPageRef;
    }
    public String getOpIdDescription()
    {
        return opIdDescription;
    }

    public void setOpIdDescription(String opIdDescription)
    {
        this.opIdDescription = opIdDescription;
    }
    
    public String getApiType()
    {
        return apiType;
    }

    public void setApiType(String apiType)
    {
        this.apiType = apiType;
    }
    
    public String getMapDirection()
    {
        return mapDirection;
    }

    public void setMapDirection(String mapDirection)
    {
        this.mapDirection = mapDirection;
    }
    
    public BigDecimal getLovMapId()
    {
        return lovMapId;
    }

    public void setLovMapId(BigDecimal lovMapId)
    {
        this.lovMapId = lovMapId;
    }
    public BigDecimal getApiCode()
    {
        return apiCode;
    }

    public void setApiCode(BigDecimal apiCode)
    {
        this.apiCode = apiCode;
    }
    
    public String getScreenFldIdDesc()
    {
        return screenFldIdDesc;
    }

    public void setScreenFldIdDesc(String screenFldIdDesc)
    {
        this.screenFldIdDesc = screenFldIdDesc;
    }

    public String getDynElemDescription()
    {
        return dynElemDescription;
    }

    public void setDynElemDescription(String dynElemDescription)
    {
        this.dynElemDescription = dynElemDescription;
    }

    public String getArgDescription()
    {
        return argDescription;
    }

    public void setArgDescription(String argDescription)
    {
        this.argDescription = argDescription;
    }

    public boolean getSpecificFlag()
    {
        return specificFlag;
    }

    public void setSpecificFlag(boolean specificFlag)
    {
        this.specificFlag = specificFlag;
    }

    public String getChangedStatus()
    {
        return changedStatus;
    }

    public void setChangedStatus(String changedStatus)
    {
        this.changedStatus = changedStatus;
    }
    
    public BigDecimal getLovDynParamType()
    {
	return lovDynParamType;
    }
    public void setLovDynParamType(BigDecimal lovDynParamType)
    {
	this.lovDynParamType = lovDynParamType;
    }

    public String getDynParamTypeDesc()
    {
	return dynParamTypeDesc;
    }

    public void setDynParamTypeDesc(String dynParamTypeDesc)
    {
	this.dynParamTypeDesc = dynParamTypeDesc;
    }

    public boolean isLoadedInObjDisplay()
    {
        return loadedInObjDisplay;
    }

    public void setLoadedInObjDisplay(boolean loadedInObjDisplay)
    {
        this.loadedInObjDisplay = loadedInObjDisplay;
    }

    public String getGridColumns()
    {
        return gridColumns;
    }

    public void setGridColumns(String gridColumns)
    {
        this.gridColumns = gridColumns;
    }

    public String getFromSource()
    {
        return fromSource;
    }

    public void setFromSource(String fromSource)
    {
        this.fromSource = fromSource;
    }

	public BigDecimal getElementType() {
		return elementType;
	}

	public void setElementType(BigDecimal elementType) {
		this.elementType = elementType;
	}

	/**
	 * @return the gridColumnName
	 */
	public String getGridColumnName()
	{
	    return gridColumnName;
	}

	/**
	 * @param gridColumnName the gridColumnName to set
	 */
	public void setGridColumnName(String gridColumnName)
	{
	    this.gridColumnName = gridColumnName;
	}
    
}
