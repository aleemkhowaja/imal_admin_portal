/**
 * 
 */
package com.path.vo.common.bpm;

import org.codehaus.jackson.annotate.JsonProperty;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * BpmJaxbProcessInstanceLogCO.java used to
 */
public class BpmJaxbProcessInstanceLogCO extends BaseVO
{

    @JsonProperty(value="org.kie.services.client.serialization.jaxb.impl.audit.JaxbProcessInstanceLog")
    private BpmProcessInstanceLogCO processInstanceLogCO;

    public BpmProcessInstanceLogCO getProcessInstanceLogCO()
    {
        return processInstanceLogCO;
    }

    public void setProcessInstanceLogCO(BpmProcessInstanceLogCO processInstanceLogCO)
    {
        this.processInstanceLogCO = processInstanceLogCO;
    }
    
}
