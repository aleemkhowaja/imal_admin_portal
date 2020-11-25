package com.path.vo.common.dynfiles;

import com.path.dbmaps.vo.DF_FILE_MISC_SQLVO;
import com.path.dbmaps.vo.DF_SRC_SQL_STRUCTVO;
import com.path.lib.vo.BaseVO;

public class DynFilesMiscSQLListCO extends BaseVO
{
    private DF_SRC_SQL_STRUCTVO dfSrcSQLStructVO;
    private DF_FILE_MISC_SQLVO dfFileMiscSQLVO;
    
    public DF_SRC_SQL_STRUCTVO getDfSrcSQLStructVO()
    {
        return dfSrcSQLStructVO;
    }
    public void setDfSrcSQLStructVO(DF_SRC_SQL_STRUCTVO dfSrcSQLStructVO)
    {
        this.dfSrcSQLStructVO = dfSrcSQLStructVO;
    }
    public DF_FILE_MISC_SQLVO getDfFileMiscSQLVO()
    {
        return dfFileMiscSQLVO;
    }
    public void setDfFileMiscSQLVO(DF_FILE_MISC_SQLVO dfFileMiscSQLVO)
    {
        this.dfFileMiscSQLVO = dfFileMiscSQLVO;
    }
}
