package com.path.vo.common.dynfiles;

import com.path.dbmaps.vo.DF_FILE_SQLVO;
import com.path.dbmaps.vo.DF_FILE_TAG_VALUESVO;
import com.path.dbmaps.vo.DF_SQL_INP_PARMVO;
import com.path.dbmaps.vo.DF_SRC_SQL_STRUCTVO;
import com.path.lib.vo.BaseVO;

public class DynFilesColMapCO extends BaseVO
{
    private DF_SRC_SQL_STRUCTVO dfSrcSQLStructVO;
    private DF_FILE_SQLVO dfFileSQLVO; 
    private DF_SQL_INP_PARMVO dfSQLInpParmVO;
    private DF_FILE_TAG_VALUESVO dfFileTagValuesVO;

    public DF_SRC_SQL_STRUCTVO getDfSrcSQLStructVO()
    {
        return dfSrcSQLStructVO;
    }
    public void setDfSrcSQLStructVO(DF_SRC_SQL_STRUCTVO dfSrcSQLStructVO)
    {
        this.dfSrcSQLStructVO = dfSrcSQLStructVO;
    }
    public DF_FILE_SQLVO getDfFileSQLVO()
    {
        return dfFileSQLVO;
    }
    public void setDfFileSQLVO(DF_FILE_SQLVO dfFileSQLVO)
    {
        this.dfFileSQLVO = dfFileSQLVO;
    }
    public DF_SQL_INP_PARMVO getDfSQLInpParmVO()
    {
        return dfSQLInpParmVO;
    }
    public void setDfSQLInpParmVO(DF_SQL_INP_PARMVO dfSQLInpParmVO)
    {
        this.dfSQLInpParmVO = dfSQLInpParmVO;
    }
    public DF_FILE_TAG_VALUESVO getDfFileTagValuesVO()
    {
        return dfFileTagValuesVO;
    }
    public void setDfFileTagValuesVO(DF_FILE_TAG_VALUESVO dfFileTagValuesVO)
    {
        this.dfFileTagValuesVO = dfFileTagValuesVO;
    }
}
