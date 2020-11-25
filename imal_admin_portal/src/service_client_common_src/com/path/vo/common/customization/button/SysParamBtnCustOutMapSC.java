package com.path.vo.common.customization.button;

import com.path.dbmaps.vo.SYS_PARAM_BTN_CUST_OUTPUT_MAPVO;
import com.path.struts2.lib.common.GridParamsSC;

public class SysParamBtnCustOutMapSC extends GridParamsSC
{

    private String operationDescription;
    private String argDescription;
    
    private SYS_PARAM_BTN_CUST_OUTPUT_MAPVO sysParamBtnCustOutMap = new SYS_PARAM_BTN_CUST_OUTPUT_MAPVO();

    public SYS_PARAM_BTN_CUST_OUTPUT_MAPVO getSysParamBtnCustOutMap()
    {
        return sysParamBtnCustOutMap;
    }

    public void setSysParamBtnCustOutMap(SYS_PARAM_BTN_CUST_OUTPUT_MAPVO sysParamBtnCustOutMap)
    {
        this.sysParamBtnCustOutMap = sysParamBtnCustOutMap;
    }

    public String getOperationDescription()
    {
        return operationDescription;
    }

    public void setOperationDescription(String opDescription)
    {
        this.operationDescription = opDescription;
    }

    public String getArgDescription()
    {
        return argDescription;
    }

    public void setArgDescription(String argDescription)
    {
        this.argDescription = argDescription;
    }
    
}
