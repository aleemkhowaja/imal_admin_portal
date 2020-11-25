package com.path.vo.common.dynfiles;

import com.path.dbmaps.vo.DF_FILE_PRCVO;
import com.path.dbmaps.vo.DF_FILE_PRC_INP_PARMVO;
import com.path.dbmaps.vo.DF_PROCEDUREVO;
import com.path.lib.vo.BaseVO;

public class DynFilesProcParamCO extends BaseVO
{
    private DF_FILE_PRC_INP_PARMVO dfFilePrcInpParm;
    private DF_PROCEDUREVO dfProcedureVO;
    private DF_FILE_PRCVO dfFilePrcVO;
    private String defaultValue;
    
    public DF_FILE_PRC_INP_PARMVO getDfFilePrcInpParm()
    {
        return dfFilePrcInpParm;
    }
    public void setDfFilePrcInpParm(DF_FILE_PRC_INP_PARMVO dfFilePrcInpParm)
    {
        this.dfFilePrcInpParm = dfFilePrcInpParm;
    }
    public DF_PROCEDUREVO getDfProcedureVO()
    {
        return dfProcedureVO;
    }
    public void setDfProcedureVO(DF_PROCEDUREVO dfProcedureVO)
    {
        this.dfProcedureVO = dfProcedureVO;
    }
    public DF_FILE_PRCVO getDfFilePrcVO()
    {
        return dfFilePrcVO;
    }
    public void setDfFilePrcVO(DF_FILE_PRCVO dfFilePrcVO)
    {
        this.dfFilePrcVO = dfFilePrcVO;
    }
    public String getDefaultValue()
    {
        return defaultValue;
    }
    public void setDefaultValue(String defaultValue)
    {
        this.defaultValue = defaultValue;
    }
}
