package com.path.vo.common.dynfiles;

import com.path.dbmaps.vo.DF_SQL_INP_PARMVO;
import com.path.dbmaps.vo.DF_SRC_SQL_STRUCTVO;

public class DynFilesSQLExportCO 
{
	private DF_SRC_SQL_STRUCTVO dfSrcSqlStructVO;
	private DF_SQL_INP_PARMVO dfSqlInpParmVO;
	
	public DF_SRC_SQL_STRUCTVO getDfSrcSqlStructVO() 
	{
		return dfSrcSqlStructVO;
	}
	public void setDfSrcSqlStructVO(DF_SRC_SQL_STRUCTVO dfSrcSqlStructVO) 
	{
		this.dfSrcSqlStructVO = dfSrcSqlStructVO;
	}
	public DF_SQL_INP_PARMVO getDfSqlInpParmVO() 
	{
		return dfSqlInpParmVO;
	}
	public void setDfSqlInpParmVO(DF_SQL_INP_PARMVO dfSqlInpParmVO) 
	{
		this.dfSqlInpParmVO = dfSqlInpParmVO;
	}
}
