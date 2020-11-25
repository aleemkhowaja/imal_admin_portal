package com.path.vo.common.tree;

import java.io.Serializable;

public class GraphicalLinkCO implements Serializable
{
    private String sourceId;
    private String targetId;
    private String customDetails;
    /**
     * @return the sourceId
     */
    public String getSourceId()
    {
        return sourceId;
    }
    /**
     * @param sourceId the sourceId to set
     */
    public void setSourceId(String sourceId)
    {
        this.sourceId = sourceId;
    }
    /**
     * @return the targetId
     */
    public String getTargetId()
    {
        return targetId;
    }
    /**
     * @param targetId the targetId to set
     */
    public void setTargetId(String targetId)
    {
        this.targetId = targetId;
    }
    /**
     * @return the customDetails
     */
    public String getCustomDetails()
    {
        return customDetails;
    }
    /**
     * @param customDetails the customDetails to set
     */
    public void setCustomDetails(String customDetails)
    {
        this.customDetails = customDetails;
    }
    
}
