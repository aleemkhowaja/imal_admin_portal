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
 * JbpmProcessDefCO.java used to
 */
@XStreamAlias("bpmn2:definitions")
public class JbpmProcessDefCO implements Serializable
{
    @XStreamAlias("bpmn2:process")
    private JbpmProcessCO jbpmProcessCO;

    @XStreamImplicit(itemFieldName = "bpmn2:itemDefinition")
    private List<JbpmItemDefinitionCO> itemDefinitionList;
    
    public JbpmProcessCO getJbpmProcessCO()
    {
        return jbpmProcessCO;
    }

    public void setJbpmProcessCO(JbpmProcessCO jbpmProcessCO)
    {
        this.jbpmProcessCO = jbpmProcessCO;
    }

    /**
     * @return the itemDefinitionList
     */
    public List<JbpmItemDefinitionCO> getItemDefinitionList()
    {
        return itemDefinitionList;
    }

    /**
     * @param itemDefinitionList the itemDefinitionList to set
     */
    public void setItemDefinitionList(List<JbpmItemDefinitionCO> itemDefinitionList)
    {
        this.itemDefinitionList = itemDefinitionList;
    }
    
}
