/**
 * 
 */
package com.path.vo.common.bpm.jbpm;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * JbpmUserTaskCO.java used to
 */

@XStreamAlias("bpmn2:userTask")
public class JbpmUserTaskCO implements Serializable
{
    @XStreamAsAttribute 
    @XStreamAlias("name")
    private String name;

    @XStreamAlias("bpmn2:ioSpecification")
    private JbpmIOSpecificationCO ioSpecification; 
    
    @XStreamImplicit(itemFieldName = "bpmn2:dataInputAssociation")
    private List<JbpmDataInputAssociationCO> dataInputAssociationList; 
    
    @XStreamImplicit(itemFieldName = "bpmn2:potentialOwner")
    private List<JbpmPotentialOwnerCO> potentialOwnerList; 
    
    @XStreamAlias("bpmn2:documentation")
    private String documentation;
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public JbpmIOSpecificationCO getIoSpecification()
    {
        return ioSpecification;
    }

    public void setIoSpecification(JbpmIOSpecificationCO ioSpecification)
    {
        this.ioSpecification = ioSpecification;
    }

    public List<JbpmDataInputAssociationCO> getDataInputAssociationList()
    {
        return dataInputAssociationList;
    }

    public void setDataInputAssociationList(List<JbpmDataInputAssociationCO> dataInputAssociationList)
    {
        this.dataInputAssociationList = dataInputAssociationList;
    }

    public List<JbpmPotentialOwnerCO> getPotentialOwnerList()
    {
        return potentialOwnerList;
    }

    public void setPotentialOwnerList(List<JbpmPotentialOwnerCO> potentialOwnerList)
    {
        this.potentialOwnerList = potentialOwnerList;
    }

    public String getDocumentation()
    {
        return documentation;
    }

    public void setDocumentation(String documentation)
    {
        this.documentation = documentation;
    }
    
}
