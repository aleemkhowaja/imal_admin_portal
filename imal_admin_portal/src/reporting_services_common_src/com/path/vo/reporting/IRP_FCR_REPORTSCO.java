package com.path.vo.reporting;

import java.math.BigDecimal;

import com.path.dbmaps.vo.IRP_FCR_REPORTSVO;
import com.path.lib.vo.BaseVO;

public class IRP_FCR_REPORTSCO extends BaseVO
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private IRP_FCR_REPORTSVO irpFcrReportsVO= new IRP_FCR_REPORTSVO();
    private String progRef;
    private String STANDARD_FLAG_YN;
    private BigDecimal ROW_COLMN;
    private String GENERATED_FILE_NAME;
    
    public String getGENERATED_FILE_NAME()
    {
        return GENERATED_FILE_NAME;
    }

    public void setGENERATED_FILE_NAME(String gENERATED_FILE_NAME)
    {
        GENERATED_FILE_NAME = gENERATED_FILE_NAME;
    }

    public BigDecimal getROW_COLMN()
    {
	return ROW_COLMN;
    }

    public void setROW_COLMN(BigDecimal rOW_COLMN)
    {
	ROW_COLMN = rOW_COLMN;
    }
    
    
    
    
    public String getSTANDARD_FLAG_YN()
    {
        return STANDARD_FLAG_YN;
    }

    public void setSTANDARD_FLAG_YN(String sTANDARDFLAGYN)
    {
        STANDARD_FLAG_YN = sTANDARDFLAGYN;
    }

    public IRP_FCR_REPORTSVO getIrpFcrReportsVO()
    {
        return irpFcrReportsVO;
    }

    public void setIrpFcrReportsVO(IRP_FCR_REPORTSVO irpFcrReportsVO)
    {
        this.irpFcrReportsVO = irpFcrReportsVO;
    }

    public String getProgRef()
    {
        return progRef;
    }

    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
    
}
