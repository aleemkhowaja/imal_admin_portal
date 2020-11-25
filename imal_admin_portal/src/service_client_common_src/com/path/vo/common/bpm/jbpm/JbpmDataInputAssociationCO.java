/**
 * 
 */
package com.path.vo.common.bpm.jbpm;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * JbpmDataInputAssociation.java used to
 */
@XStreamAlias("bpmn2:dataInputAssociation")
public class JbpmDataInputAssociationCO
{
    @XStreamAsAttribute 
    @XStreamAlias("bpmn2:targetRef")
    private String targetRef;

    public String getTargetRef()
    {
        return targetRef;
    }

    public void setTargetRef(String targetRef)
    {
        this.targetRef = targetRef;
    }
    
}
