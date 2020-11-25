/**
 * 
 */
package com.path.vo.common.screengenerator;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DynButtonSourceCO.java used to
 */
public class DynButtonSourceCO extends BaseVO
{
   private String     sourceType;
   private BigDecimal sourceScreenId;
   private BigDecimal sourceScreenWidth;
   private BigDecimal sourceScreenHeight;
   private String     sourceScreenDesc;
   private String     sourceScreenTitle;
   private String     sourceScriptData;
   private String     scrParamMapGridUpdate;
   private BigDecimal sourceGlobalActivityId;
   private HashMap<String,SYS_PARAM_SCREEN_DISPLAYVO> displayHm;
   
    /**
     * @return the sourceScreenId
     */
    public BigDecimal getSourceScreenId()
    {
        return sourceScreenId;
    }
    
    /**
     * @param sourceScreenId the sourceScreenId to set
     */
    public void setSourceScreenId(BigDecimal sourceScreenId)
    {
        this.sourceScreenId = sourceScreenId;
    }

    /**
     * @return the sourceScreenDesc
     */
    public String getSourceScreenDesc()
    {
        return sourceScreenDesc;
    }

    /**
     * @param sourceScreenDesc the sourceScreenDesc to set
     */
    public void setSourceScreenDesc(String sourceScreenDesc)
    {
        this.sourceScreenDesc = sourceScreenDesc;
    }

    /**
     * @return the sourceType
     */
    public String getSourceType()
    {
        return sourceType;
    }

    /**
     * @param sourceType the sourceType to set
     */
    public void setSourceType(String sourceType)
    {
        this.sourceType = sourceType;
    }

    /**
     * @return the sourceScriptData
     */
    public String getSourceScriptData()
    {
        return sourceScriptData;
    }

    /**
     * @param sourceScriptData the sourceScriptData to set
     */
    public void setSourceScriptData(String sourceScriptData)
    {
        this.sourceScriptData = sourceScriptData;
    }

    /**
     * @return the scrParamMapGridUpdate
     */
    public String getScrParamMapGridUpdate()
    {
        return scrParamMapGridUpdate;
    }

    /**
     * @param scrParamMapGridUpdate the scrParamMapGridUpdate to set
     */
    public void setScrParamMapGridUpdate(String scrParamMapGridUpdate)
    {
        this.scrParamMapGridUpdate = scrParamMapGridUpdate;
    }

    /**
     * @return the sourceGlobalActivityId
     */
    public BigDecimal getSourceGlobalActivityId()
    {
        return sourceGlobalActivityId;
    }

    /**
     * @param sourceGlobalActivityId the sourceGlobalActivityId to set
     */
    public void setSourceGlobalActivityId(BigDecimal sourceGlobalActivityId)
    {
        this.sourceGlobalActivityId = sourceGlobalActivityId;
    }

    /**
     * @return the displayHm
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getDisplayHm()
    {
        return displayHm;
    }

    /**
     * @param displayHm the displayHm to set
     */
    public void setDisplayHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> displayHm)
    {
        this.displayHm = displayHm;
    }

    /**
     * @return the sourceScreenWidth
     */
    public BigDecimal getSourceScreenWidth()
    {
        return sourceScreenWidth;
    }

    /**
     * @param sourceScreenWidth the sourceScreenWidth to set
     */
    public void setSourceScreenWidth(BigDecimal sourceScreenWidth)
    {
        this.sourceScreenWidth = sourceScreenWidth;
    }

    /**
     * @return the sourceScreenHeight
     */
    public BigDecimal getSourceScreenHeight()
    {
        return sourceScreenHeight;
    }

    /**
     * @param sourceScreenHeight the sourceScreenHeight to set
     */
    public void setSourceScreenHeight(BigDecimal sourceScreenHeight)
    {
        this.sourceScreenHeight = sourceScreenHeight;
    }

	public String getSourceScreenTitle() {
		return sourceScreenTitle;
	}

	public void setSourceScreenTitle(String sourceScreenTitle) {
		this.sourceScreenTitle = sourceScreenTitle;
	} 
    
}
