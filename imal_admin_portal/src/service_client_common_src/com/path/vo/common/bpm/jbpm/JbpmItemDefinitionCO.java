/**
 * 
 */
package com.path.vo.common.bpm.jbpm;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * JbpmItemDefinitionCO.java used to
 */
@XStreamAlias("bpmn2:itemDefinition")
public class JbpmItemDefinitionCO
{
    
    @XStreamAsAttribute 
    @XStreamAlias("id") 
    private String id;
    
    @XStreamAsAttribute 
    @XStreamAlias("structureRef") 
    private String structureRef;

    /**
     * @return the id
     */
    public String getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * @return the structureRef
     */
    public String getStructureRef()
    {
        return structureRef;
    }

    /**
     * @param structureRef the structureRef to set
     */
    public void setStructureRef(String structureRef)
    {
        this.structureRef = structureRef;
    }
    
}
