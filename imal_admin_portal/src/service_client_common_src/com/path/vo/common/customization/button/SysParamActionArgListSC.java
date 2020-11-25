package com.path.vo.common.customization.button;

import com.path.dbmaps.vo.SYS_PARAM_ACTION_ARG_LISTVO;
import com.path.struts2.lib.common.GridParamsSC;

public class SysParamActionArgListSC extends GridParamsSC
{

    private String listTypeDescription ;
    private SYS_PARAM_ACTION_ARG_LISTVO sysParamActionArgListVO = new SYS_PARAM_ACTION_ARG_LISTVO();

    public SYS_PARAM_ACTION_ARG_LISTVO getSysParamActionArgListVO()
    {
        return sysParamActionArgListVO;
    }

    public void setSysParamActionArgListVO(SYS_PARAM_ACTION_ARG_LISTVO sysParamActionArgListVO)
    {
        this.sysParamActionArgListVO = sysParamActionArgListVO;
    }

    public String getListTypeDescription()
    {
        return listTypeDescription;
    }

    public void setListTypeDescription(String listTypeDescription)
    {
        this.listTypeDescription = listTypeDescription;
    }

}
