package com.path.vo.reporting;

import java.math.BigDecimal;

import com.path.dbmaps.vo.IRP_HASH_TABLEVO;
import com.path.lib.vo.BaseVO;

public class IRP_HASH_TABLECO extends BaseVO
{

    private static final long serialVersionUID = 1L;

    private BigDecimal REPORT_ID;
    private IRP_HASH_TABLEVO irpHashTableVO= new IRP_HASH_TABLEVO();
    
    

    
    public BigDecimal getREPORT_ID()
    {
        return REPORT_ID;
    }

    public void setREPORT_ID(BigDecimal rEPORTID)
    {
        REPORT_ID = rEPORTID;
    }

    public IRP_HASH_TABLEVO getIrpHashTableVO()
    {
        return irpHashTableVO;
    }

    public void setIrpHashTableVO(IRP_HASH_TABLEVO irpHashTableVO)
    {
        this.irpHashTableVO = irpHashTableVO;
    }
    
}
