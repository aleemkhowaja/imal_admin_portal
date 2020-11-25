package com.path.vo.admin.category;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CategorySC extends GridParamsSC
{
    private BigDecimal categId;
    private String categDesc;

    /**
     * @return the categId
     */
    public BigDecimal getCategId()
    {
        return categId;
    }

    /**
     * @param categId the categId to set
     */
    public void setCategId(BigDecimal categId)
    {
        this.categId = categId;
    }

    /**
     * @return the categDesc
     */
    public String getCategDesc()
    {
        return categDesc;
    }

    /**
     * @param categDesc the categDesc to set
     */
    public void setCategDesc(String categDesc)
    {
        this.categDesc = categDesc;
    }
    
    
    
}
