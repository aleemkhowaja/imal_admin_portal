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
 * JbpmDataOutputCO.java used to
 */
@XStreamAlias("bpmn2:dataOutput")
public class JbpmDataOutputCO implements Serializable
{
    @XStreamAsAttribute 
    @XStreamAlias("drools:dtype")
    private String type;
    
    @XStreamAsAttribute 
    @XStreamAlias("name")
    private String name;
    
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
}
