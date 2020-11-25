/**
 * 
 */
package com.path.vo.common.bpm.jbpm;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * JbpmIOSpecificationCO.java used to
 */
@XStreamAlias("bpmn2:ioSpecification")
public class JbpmIOSpecificationCO implements Serializable
{
    @XStreamImplicit(itemFieldName = "bpmn2:dataOutput")
    private List<JbpmDataOutputCO> dataOutputList;

    public List<JbpmDataOutputCO> getDataOutputList()
    {
        return dataOutputList;
    }

    public void setDataOutputList(List<JbpmDataOutputCO> dataOutputList)
    {
        this.dataOutputList = dataOutputList;
    } 
    
    
}
