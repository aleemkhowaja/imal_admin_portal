package com.path.vo.common.dynfiles;

import com.path.dbmaps.vo.DF_DT_FILE_GROUPVO;
import com.path.dbmaps.vo.DF_FILE_SQLVO;
import com.path.dbmaps.vo.DF_FILE_STRUCTVO;
import com.path.dbmaps.vo.DF_FILE_STRUCT_DETAILVO;
import com.path.dbmaps.vo.DF_FILE_TAG_INP_PARAMVO;
import com.path.dbmaps.vo.DF_FILE_TAG_VALUESVO;
import com.path.dbmaps.vo.DF_SRC_SQL_STRUCTVO;
import com.path.lib.vo.BaseVO;

public class DynFilesTagsCO extends BaseVO
{
    private DF_FILE_STRUCTVO dfFileStructVO;
    private DF_FILE_STRUCT_DETAILVO dfFileStructDetailVO;
    private DF_FILE_SQLVO dfFileSQLVO;
    private DF_FILE_TAG_VALUESVO dfTagValuesVO;
    private DF_DT_FILE_GROUPVO dfDTFileGroupVO;
    private DF_SRC_SQL_STRUCTVO dfSrcSqlStructVO;
    private DF_FILE_TAG_INP_PARAMVO dfFileTagInpParamVO;

    public DF_FILE_STRUCTVO getDfFileStructVO()
    {
	return dfFileStructVO;
    }
    public void setDfFileStructVO(DF_FILE_STRUCTVO dfFileStructVO)
    {
	this.dfFileStructVO = dfFileStructVO;
    }
    public DF_FILE_STRUCT_DETAILVO getDfFileStructDetailVO()
    {
	return dfFileStructDetailVO;
    }
    public void setDfFileStructDetailVO(DF_FILE_STRUCT_DETAILVO dfFileStructDetailVO)
    {
	this.dfFileStructDetailVO = dfFileStructDetailVO;
    }
    public DF_FILE_SQLVO getDfFileSQLVO()
    {
	return dfFileSQLVO;
    }
    public void setDfFileSQLVO(DF_FILE_SQLVO dfFileSQLVO)
    {
	this.dfFileSQLVO = dfFileSQLVO;
    }
    public DF_FILE_TAG_VALUESVO getDfTagValuesVO()
    {
	return dfTagValuesVO;
    }
    public void setDfTagValuesVO(DF_FILE_TAG_VALUESVO dfTagValuesVO)
    {
	this.dfTagValuesVO = dfTagValuesVO;
    }
    public DF_DT_FILE_GROUPVO getDfDTFileGroupVO()
    {
	return dfDTFileGroupVO;
    }
    public void setDfDTFileGroupVO(DF_DT_FILE_GROUPVO dfDTFileGroupVO)
    {
	this.dfDTFileGroupVO = dfDTFileGroupVO;
    }
    public DF_SRC_SQL_STRUCTVO getDfSrcSqlStructVO() 
    {
	return dfSrcSqlStructVO;
    }
    public void setDfSrcSqlStructVO(DF_SRC_SQL_STRUCTVO dfSrcSqlStructVO) 
    {
	this.dfSrcSqlStructVO = dfSrcSqlStructVO;
    }
    public DF_FILE_TAG_INP_PARAMVO getDfFileTagInpParamVO()
    {
        return dfFileTagInpParamVO;
    }
    public void setDfFileTagInpParamVO(DF_FILE_TAG_INP_PARAMVO dfFileTagInpParamVO)
    {
        this.dfFileTagInpParamVO = dfFileTagInpParamVO;
    }
}
