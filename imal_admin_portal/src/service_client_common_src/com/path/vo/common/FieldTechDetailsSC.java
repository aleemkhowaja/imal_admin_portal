/**
 * 
 */
package com.path.vo.common;

import com.path.struts2.lib.common.BaseSC;


/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * FieldTechDetailssc.java used to
 */
public class FieldTechDetailsSC extends BaseSC
{
    private String entityType;
    private String pbFieldName;
    private String elementId;
    private String elementName;
    private String voPropertyName;
    /**
     * @return the entityType
     */
    public String getEntityType()
    {
        return entityType;
    }
    /**
     * @param entityType the entityType to set
     */
    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }
    /**
     * @return the pbFieldName
     */
    public String getPbFieldName()
    {
        return pbFieldName;
    }
    /**
     * @param pbFieldName the pbFieldName to set
     */
    public void setPbFieldName(String pbFieldName)
    {
        this.pbFieldName = pbFieldName;
    }
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
     * @return the elementName
     */
    public String getElementName()
    {
        return elementName;
    }
    /**
     * @param elementName the elementName to set
     */
    public void setElementName(String elementName)
    {
        this.elementName = elementName;
    }
    /**
     * @return the voPropertyName
     */
    public String getVoPropertyName()
    {
        return voPropertyName;
    }
    /**
     * @param voPropertyName the voPropertyName to set
     */
    public void setVoPropertyName(String voPropertyName)
    {
        this.voPropertyName = voPropertyName;
    }

}
