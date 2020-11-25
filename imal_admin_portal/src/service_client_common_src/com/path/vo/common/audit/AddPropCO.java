package com.path.vo.common.audit;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: RabihElKhatib
 *
 * AddPropCO.java used to store the callTrackChanges method variables in AuditBO
 */
public class AddPropCO extends BaseVO
{
    private String propertyName; //propertyName IS the name of the property to be tracked
    private BigDecimal propetyType;//propetyType is the type that will specify whether the current element that is being tracked is CUSTOM field, Additional Field By Type (1=Custom Field, 2=Additional Field By Type, 3=SMART Field).
    private String propertyKeyRef; //propertyKeyRef is The corresponding unique identifier key (Columns that have not null value and defines the key of the record) in case the property is list in order to be able to catch the related Objects together
    private String addFieldCode;
    private String addFieldEntity;
    private BigDecimal addFieldColNbr;
    private String customFieldFrom; //coming from JV/IIS...
    
    public String getPropertyName()
    {
        return propertyName;
    }
    public void setPropertyName(String propertyName)
    {
        this.propertyName = propertyName;
    }
    public String getAddFieldCode()
    {
        return addFieldCode;
    }
    public void setAddFieldCode(String addFieldCode)
    {
        this.addFieldCode = addFieldCode;
    }
    public String getAddFieldEntity()
    {
        return addFieldEntity;
    }
    public void setAddFieldEntity(String addFieldEntity)
    {
        this.addFieldEntity = addFieldEntity;
    }
    public String getPropertyKeyRef()
    {
        return propertyKeyRef;
    }
    public void setPropertyKeyRef(String propertyKeyRef)
    {
        this.propertyKeyRef = propertyKeyRef;
    }
    public String getCustomFieldFrom()
    {
        return customFieldFrom;
    }
    public void setCustomFieldFrom(String customFieldFrom)
    {
        this.customFieldFrom = customFieldFrom;
    }
    public void setAddFieldColNbr(BigDecimal addFieldColNbr)
    {
	this.addFieldColNbr = addFieldColNbr;
    }
    public BigDecimal getAddFieldColNbr()
    {
	return addFieldColNbr;
    }
    public BigDecimal getPropetyType()
    {
        return propetyType;
    }
    public void setPropetyType(BigDecimal propetyType)
    {
        this.propetyType = propetyType;
    }
}
