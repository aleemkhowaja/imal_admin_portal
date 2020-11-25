package com.path.vo.common.dynfiles;

import com.path.dbmaps.vo.DF_DATA_IMPORT_TMPVO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: elieachkar
 *
 * DynFilesDataTmpVO.java used to overwrite the setter for Delimiter since in the original VO
 * it will trim the Space Delimiter
 */
public class DynFilesDataImportTmpVO extends DF_DATA_IMPORT_TMPVO
{
    @Override
    public void setDELIMITER(String DEL)
    {
	// setting without trimming the delimiter
	this.DELIMITER = DEL == null ? null : DEL;
    }
}
