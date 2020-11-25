package com.path.vo.reporting;

import com.path.dbmaps.vo.IRP_CLIENT_REPORTVO;
import com.path.lib.vo.BaseVO;

public class IRP_CLIENT_REPORTCO extends BaseVO
{
    
    IRP_CLIENT_REPORTVO irpClientReportVO = new IRP_CLIENT_REPORTVO();

    private String CLIENT_NAME;
    
    
    
    public String getCLIENT_NAME()
    {
        return CLIENT_NAME;
    }

    public void setCLIENT_NAME(String cLIENTNAME)
    {
        CLIENT_NAME = cLIENTNAME;
    }

    public IRP_CLIENT_REPORTVO getIrpClientReportVO()
    {
        return irpClientReportVO;
    }

    public void setIrpClientReportVO(IRP_CLIENT_REPORTVO irpClientReportVO)
    {
        this.irpClientReportVO = irpClientReportVO;
    }

}
