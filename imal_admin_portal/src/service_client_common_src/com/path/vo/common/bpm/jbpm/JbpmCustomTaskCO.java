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
 * JbpmCustomTaskCO.java used to
 */
@XStreamAlias("bpmn2:task")
public class JbpmCustomTaskCO
{

    @XStreamAsAttribute 
    @XStreamAlias("name")
    private String name;
    
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

    public String getDocumentation()
    {
        return documentation;
    }

    public void setDocumentation(String documentation)
    {
        this.documentation = documentation;
    }
    
}
