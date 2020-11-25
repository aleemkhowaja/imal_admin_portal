package com.path.vo.reporting;

import com.path.dbmaps.vo.IRP_QUERY_ARG_MAPPINGVO;
import com.path.lib.vo.BaseVO;

public class IRP_QUERY_ARG_MAPPINGCO extends BaseVO
{

    private IRP_QUERY_ARG_MAPPINGVO irpQueryArgsMappingVO = new IRP_QUERY_ARG_MAPPINGVO();
    private String QRY_ARG_NAME;
    private String QRY_ARG_TYPE;
    private String MAP_PARAM_TYPE;
    private String ARGUMENT_TYPE;
    
    
    
    private IRP_AD_HOC_QUERYCO irpAdHocQryCO = new IRP_AD_HOC_QUERYCO();
    private IRP_REP_ARGUMENTSCO argumentCO = new IRP_REP_ARGUMENTSCO();
    
    




    public String getARGUMENT_TYPE()
    {
        return ARGUMENT_TYPE;
    }

    public void setARGUMENT_TYPE(String aRGUMENTTYPE)
    {
        ARGUMENT_TYPE = aRGUMENTTYPE;
    }

    public IRP_REP_ARGUMENTSCO getArgumentCO()
    {
        return argumentCO;
    }

    public void setArgumentCO(IRP_REP_ARGUMENTSCO argumentCO)
    {
        this.argumentCO = argumentCO;
    }

    public IRP_AD_HOC_QUERYCO getIrpAdHocQryCO()
    {
        return irpAdHocQryCO;
    }

    public void setIrpAdHocQryCO(IRP_AD_HOC_QUERYCO irpAdHocQryCO)
    {
        this.irpAdHocQryCO = irpAdHocQryCO;
    }

    public String getMAP_PARAM_TYPE()
    {
        return MAP_PARAM_TYPE;
    }

    public void setMAP_PARAM_TYPE(String mAPPARAMTYPE)
    {
        MAP_PARAM_TYPE = mAPPARAMTYPE;
    }

    public String getQRY_ARG_TYPE()
    {
        return QRY_ARG_TYPE;
    }

    public void setQRY_ARG_TYPE(String qRYARGTYPE)
    {
        QRY_ARG_TYPE = qRYARGTYPE;
    }

    public String getQRY_ARG_NAME()
    {
        return QRY_ARG_NAME;
    }

    public void setQRY_ARG_NAME(String qRYARGNAME)
    {
        QRY_ARG_NAME = qRYARGNAME;
    }

    public IRP_QUERY_ARG_MAPPINGVO getIrpQueryArgsMappingVO()
    {
        return irpQueryArgsMappingVO;
    }

    public void setIrpQueryArgsMappingVO(IRP_QUERY_ARG_MAPPINGVO irpQueryArgsMappingVO)
    {
        this.irpQueryArgsMappingVO = irpQueryArgsMappingVO;
    }

}

