/**
 * 
 */
package com.path.vo.common.screengenerator;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * ElementPropertiesDetCO.java used to
 */
public class ElementPropertiesDetCO extends BaseVO
{
   private BigDecimal elementId;
   private String     propertyCode;
   private String     propertyValue;
   private String     propertyValueExpr;
   private String     dataType;
   private String     layoutType;
   private BigDecimal dataLength;
   private String     labelDesc;
   
   /**
    * used to catch the properties form elements in submit process.
    */
   private HashMap<String,String> propertiesValMap = new HashMap<String,String>();
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
 * @return the dataType
 */
public String getDataType()
{
    return dataType;
}
/**
 * @param dataType the dataType to set
 */
public void setDataType(String dataType)
{
    this.dataType = dataType;
}
/**
 * @return the layoutType
 */
public String getLayoutType()
{
    return layoutType;
}
/**
 * @param layoutType the layoutType to set
 */
public void setLayoutType(String layoutType)
{
    this.layoutType = layoutType;
}
/**
 * @return the dataLength
 */
public BigDecimal getDataLength()
{
    return dataLength;
}
/**
 * @param dataLength the dataLength to set
 */
public void setDataLength(BigDecimal dataLength)
{
    this.dataLength = dataLength;
}
/**
 * @return the elementId
 */
public BigDecimal getElementId()
{
    return elementId;
}
/**
 * @param elementId the elementId to set
 */
public void setElementId(BigDecimal elementId)
{
    this.elementId = elementId;
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
 * @return the labelDesc
 */
public String getLabelDesc()
{
    return labelDesc;
}
/**
 * @param labelDesc the labelDesc to set
 */
public void setLabelDesc(String labelDesc)
{
    this.labelDesc = labelDesc;
}
/**
 * @return the propertyValueExpr
 */
public String getPropertyValueExpr()
{
    return propertyValueExpr;
}
/**
 * @param propertyValueExpr the propertyValueExpr to set
 */
public void setPropertyValueExpr(String propertyValueExpr)
{
    this.propertyValueExpr = propertyValueExpr;
}
/**
 * @return the propertiesValMap
 */
public HashMap<String, String> getPropertiesValMap()
{
    return propertiesValMap;
}
/**
 * @param propertiesValMap the propertiesValMap to set
 */
public void setPropertiesValMap(HashMap<String, String> propertiesValMap)
{
    this.propertiesValMap = propertiesValMap;
}
}
