package com.path.vo.reporting;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class IRP_HASH_TABLESC extends GridParamsSC
{

    private BigDecimal REPORT_ID;
    
    private BigDecimal HASH_TABLE_ID;

    private String HASH_TABLE_NAME;
    
    public IRP_HASH_TABLESC(){
	super.setSearchCols(new String[] {"HASH_TABLE_ID","HASH_TABLE_NAME"});
    }

    public BigDecimal getREPORT_ID()
    {
        return REPORT_ID;
    }

    public void setREPORT_ID(BigDecimal rEPORTID)
    {
        REPORT_ID = rEPORTID;
    }

    public BigDecimal getHASH_TABLE_ID()
    {
        return HASH_TABLE_ID;
    }

    public void setHASH_TABLE_ID(BigDecimal hASHTABLEID)
    {
        HASH_TABLE_ID = hASHTABLEID;
    }

    public String getHASH_TABLE_NAME()
    {
        return HASH_TABLE_NAME;
    }

    public void setHASH_TABLE_NAME(String hASHTABLENAME)
    {
        HASH_TABLE_NAME = hASHTABLENAME;
    }
    
}
