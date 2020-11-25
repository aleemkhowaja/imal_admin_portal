/**
 * 
 */
package com.path.vo.common.dynamicscreen;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * DynamicScreenParamsSC.java used to
 */
public class DynamicScreenParamsMapSC extends GridParamsSC
{
    private BigDecimal elementIdentifier;
    private String mapElementType;
    private BigDecimal elementOpId;
    private String progRef;
    private BigDecimal defaultScreenId;
    private String defaultScreenDesc;
    private BigDecimal elementMapId;
    private String mapType;
    private BigDecimal globalActivityId;
    private String screenPageRef;
    
    private BigDecimal screenWidth;
    private BigDecimal screenHeight;
    private String  screenTitle;
    private Boolean showScreenWidthAndHeight;
    
    
    private BigDecimal lovDynParamType;
  
    private String     elementType;
    
    public BigDecimal getElementIdentifier()
    {
        return elementIdentifier;
    }
    public void setElementIdentifier(BigDecimal elementIdentifier)
    {
        this.elementIdentifier = elementIdentifier;
    }
    public String getMapElementType()
    {
        return mapElementType;
    }
    public void setMapElementType(String mapElementType)
    {
        this.mapElementType = mapElementType;
    }
    public BigDecimal getElementOpId()
    {
        return elementOpId;
    }
    public void setElementOpId(BigDecimal elementOpId)
    {
        this.elementOpId = elementOpId;
    }
    public String getProgRef()
    {
        return progRef;
    }
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
    public BigDecimal getDefaultScreenId()
    {
        return defaultScreenId;
    }
    public void setDefaultScreenId(BigDecimal defaultScreenId)
    {
        this.defaultScreenId = defaultScreenId;
    }
    public String getDefaultScreenDesc()
    {
        return defaultScreenDesc;
    }
    public void setDefaultScreenDesc(String defaultScreenDesc)
    {
        this.defaultScreenDesc = defaultScreenDesc;
    }
    public BigDecimal getElementMapId()
    {
        return elementMapId;
    }
    public void setElementMapId(BigDecimal elementMapId)
    {
        this.elementMapId = elementMapId;
    }
    public String getMapType()
    {
        return mapType;
    }
    public void setMapType(String mapType)
    {
        this.mapType = mapType;
    }
    public BigDecimal getGlobalActivityId()
    {
        return globalActivityId;
    }
    public void setGlobalActivityId(BigDecimal globalActivityId)
    {
        this.globalActivityId = globalActivityId;
    }
    public String getScreenPageRef()
    {
        return screenPageRef;
    }
    public void setScreenPageRef(String screenPageRef)
    {
        this.screenPageRef = screenPageRef;
    }
    /**
     * @return the screenWidth
     */
    public BigDecimal getScreenWidth()
    {
        return screenWidth;
    }
    /**
     * @param screenWidth the screenWidth to set
     */
    public void setScreenWidth(BigDecimal screenWidth)
    {
        this.screenWidth = screenWidth;
    }
    /**
     * @return the screenHeight
     */
    public BigDecimal getScreenHeight()
    {
        return screenHeight;
    }
    /**
     * @param screenHeight the screenHeight to set
     */
    public void setScreenHeight(BigDecimal screenHeight)
    {
        this.screenHeight = screenHeight;
    }
    /**
     * @return the showScreenWidthAndHeight
     */
    public Boolean getShowScreenWidthAndHeight()
    {
        return showScreenWidthAndHeight;
    }
    /**
     * @param showScreenWidthAndHeight the showScreenWidthAndHeight to set
     */
    public void setShowScreenWidthAndHeight(Boolean showScreenWidthAndHeight)
    {
        this.showScreenWidthAndHeight = showScreenWidthAndHeight;
    }
    public BigDecimal getLovDynParamType()
    {
	return lovDynParamType;
    }
    public void setLovDynParamType(BigDecimal lovDynParamType)
    {
	this.lovDynParamType = lovDynParamType;
    }
    public String getScreenTitle()
    {
        return screenTitle;
    }
    public void setScreenTitle(String screenTitle)
    {
        this.screenTitle = screenTitle;
    }
    public String getElementType()
    {
	return elementType;
    }
    public void setElementType(String elementType)
    {
	this.elementType = elementType;
    }

    
}
