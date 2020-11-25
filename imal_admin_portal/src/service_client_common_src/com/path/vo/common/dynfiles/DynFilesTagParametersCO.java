package com.path.vo.common.dynfiles;

import com.path.dbmaps.vo.DF_FILE_STRUCT_DETAILVO;
import com.path.dbmaps.vo.DF_FILE_TAG_INP_PARAMVO;
import com.path.lib.vo.BaseVO;

public class DynFilesTagParametersCO  extends BaseVO
{
	private DF_FILE_STRUCT_DETAILVO dfFileStructDetailVO;
	private DF_FILE_TAG_INP_PARAMVO dfFileTagInpParamVO;
	
	public DF_FILE_STRUCT_DETAILVO getDfFileStructDetailVO() 
	{
		return dfFileStructDetailVO;
	}
	public void setDfFileStructDetailVO(DF_FILE_STRUCT_DETAILVO dfFileStructDetailVO) 
	{
		this.dfFileStructDetailVO = dfFileStructDetailVO;
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
