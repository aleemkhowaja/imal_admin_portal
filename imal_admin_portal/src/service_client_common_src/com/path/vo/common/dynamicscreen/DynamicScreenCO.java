/**
 * 
 */
package com.path.vo.common.dynamicscreen;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DynamicScreenCO.java used to
 */
public class DynamicScreenCO extends BaseVO
{
    private String elementId;
    private String propertyCode;
    private String propertyExprValue;
    private String propertyValue;
    private String elementType;
    private String element_mode;
    
    
    private String screenId;
    private String screenDesc;
    
    private BigDecimal elementIdValue;
    private BigDecimal screenIdValue;
    private String     theId;
    private BigDecimal elementTypeCode;
    
    /**
     * @return the elementId
     */
    public String getElementId()
    {
        return elementId;
    }
    /**
     * @param elementId the elementId to set
     */
    public void setElementId(String elementId)
    {
        this.elementId = elementId;
    }
    /**
     * @return the propertyCode
     */
    public String getPropertyCode()
    {
        return propertyCode;
    }
    /**
     * @param propertyCode the propertyCode to set
     */
    public void setPropertyCode(String propertyCode)
    {
        this.propertyCode = propertyCode;
    }
    /**
     * @return the propertyExprValue
     */
    public String getPropertyExprValue()
    {
        return propertyExprValue;
    }
    /**
     * @param propertyExprValue the propertyExprValue to set
     */
    public void setPropertyExprValue(String propertyExprValue)
    {
        this.propertyExprValue = propertyExprValue;
    }
    /**
     * @return the propertyValue
     */
    public String getPropertyValue()
    {
        return propertyValue;
    }
    /**
     * @param propertyValue the propertyValue to set
     */
    public void setPropertyValue(String propertyValue)
    {
        this.propertyValue = propertyValue;
    }
    /**
     * @return the elementType
     */
    public String getElementType()
    {
        return elementType;
    }
    /**
     * @param elementType the elementType to set
     */
    public void setElementType(String elementType)
    {
        this.elementType = elementType;
    }
    /**
     * @return the element_mode
     */
    public String getElement_mode()
    {
        return element_mode;
    }
    /**
     * @param elementMode the element_mode to set
     */
    public void setElement_mode(String elementMode)
    {
        element_mode = elementMode;
    }
    /**
     * @return the screenId
     */
    public String getScreenId()
    {
        return screenId;
    }
    /**
     * @param screenId the screenId to set
     */
    public void setScreenId(String screenId)
    {
        this.screenId = screenId;
    }
    /**
     * @return the screenDesc
     */
    public String getScreenDesc()
    {
        return screenDesc;
    }
    /**
     * @param screenDesc the screenDesc to set
     */
    public void setScreenDesc(String screenDesc)
    {
        this.screenDesc = screenDesc;
    }
    /**
     * @return the elementIdValue
     */
    public BigDecimal getElementIdValue()
    {
        return elementIdValue;
    }
    /**
     * @param elementIdValue the elementIdValue to set
     */
    public void setElementIdValue(BigDecimal elementIdValue)
    {
        this.elementIdValue = elementIdValue;
    }
    /**
     * @return the screenIdValue
     */
    public BigDecimal getScreenIdValue()
    {
        return screenIdValue;
    }
    /**
     * @param screenIdValue the screenIdValue to set
     */
    public void setScreenIdValue(BigDecimal screenIdValue)
    {
        this.screenIdValue = screenIdValue;
    }
    public String getTheId()
    {
        return theId;
    }
    public void setTheId(String theId)
    {
        this.theId = theId;
    }
	public BigDecimal getElementTypeCode() {
		return elementTypeCode;
	}
	public void setElementTypeCode(BigDecimal elementTypeCode) {
		this.elementTypeCode = elementTypeCode;
	}

}
