package com.path.vo.common.customization.button;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class ScreenElementCO extends BaseVO
{
 private BigDecimal fieldId;
 private String fieldDataType;
 private String fieldRef;
 private String propertyName;
public BigDecimal getFieldId()
{
    return fieldId;
}
public void setFieldId(BigDecimal fieldId)
{
    this.fieldId = fieldId;
}
public String getFieldDataType()
{
    return fieldDataType;
}
public void setFieldDataType(String fieldDataType)
{
    this.fieldDataType = fieldDataType;
}
public String getFieldRef()
{
    return fieldRef;
}
public void setFieldRef(String fieldRef)
{
    this.fieldRef = fieldRef;
}
public String getPropertyName()
{
    return propertyName;
}
public void setPropertyName(String propertyName)
{
    this.propertyName = propertyName;
}
}
