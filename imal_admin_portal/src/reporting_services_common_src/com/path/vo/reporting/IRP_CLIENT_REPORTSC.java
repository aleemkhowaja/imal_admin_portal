package com.path.vo.reporting;

import com.path.struts2.lib.common.GridParamsSC;

public class IRP_CLIENT_REPORTSC extends GridParamsSC
{
    public String REPORT_REF;
    public String APP_NAME;
    public String CLIENT_ACRONYM;
    
    
    public String getREPORT_REF()
    {
        return REPORT_REF;
    }
    public void setREPORT_REF(String rEPORTREF)
    {
        REPORT_REF = rEPORTREF;
    }
    public String getAPP_NAME()
    {
        return APP_NAME;
    }
    public void setAPP_NAME(String aPPNAME)
    {
        APP_NAME = aPPNAME;
    }
    public String getCLIENT_ACRONYM()
    {
        return CLIENT_ACRONYM;
    }
    public void setCLIENT_ACRONYM(String cLIENTACRONYM)
    {
        CLIENT_ACRONYM = cLIENTACRONYM;
    }

}
