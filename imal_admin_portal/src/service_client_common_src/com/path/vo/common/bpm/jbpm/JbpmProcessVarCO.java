/**
 * 
 */
package com.path.vo.common.bpm.jbpm;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * JbpmProcessVarCO.java used to
 */

@XStreamAlias("bpmn2:property")
public class JbpmProcessVarCO implements Serializable
{
    @XStreamAsAttribute 
    @XStreamAlias("id") 
    private String id;
    
    @XStreamAsAttribute 
    @XStreamAlias("itemSubjectRef") 
    private String itemSubjectRef;
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * @return the itemSubjectRef
     */
    public String getItemSubjectRef()
    {
        return itemSubjectRef;
    }

    /**
     * @param itemSubjectRef the itemSubjectRef to set
     */
    public void setItemSubjectRef(String itemSubjectRef)
    {
        this.itemSubjectRef = itemSubjectRef;
    }
    
}
