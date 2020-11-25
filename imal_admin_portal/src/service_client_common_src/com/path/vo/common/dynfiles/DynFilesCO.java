package com.path.vo.common.dynfiles;

import java.util.ArrayList;

import com.path.dbmaps.vo.DF_DATA_FILEVO;
import com.path.dbmaps.vo.DF_DT_FILE_GROUPVO;
import com.path.dbmaps.vo.DF_FILE_MISC_SQLVO;
import com.path.dbmaps.vo.DF_FILE_PARMVO;
import com.path.dbmaps.vo.DF_FILE_SQLVO;
import com.path.dbmaps.vo.DF_FILE_STRUCTVO;
import com.path.dbmaps.vo.DF_FILE_STRUCT_DETAILVO;
import com.path.dbmaps.vo.DF_FILE_TAG_VALUESVO;
import com.path.dbmaps.vo.DF_HD_FILE_GROUPVO;
import com.path.dbmaps.vo.DF_SQL_INP_PARMVO;
import com.path.dbmaps.vo.DF_SRC_SQL_STRUCTVO;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: ElieAchkar
 *
 * DynFilesCO.java used to store the files to be displayed on the screen 
 */

public class DynFilesCO extends BaseVO
{

    /*private ArrayList<DF_DATA_FILEVO> dfDataFileVO;
    private ArrayList<DF_FILE_STRUCTVO> dfFileStructVO ;
    private DF_HD_FILE_GROUPVO dfHDFileGroupVO;
    private ArrayList<DF_FILE_PARMVO> dfFileParamVO;*/

    // Elie Achkar removed this block of code since the behavior has changed for group of files
    // we need to have arraylists of the commented VOs
    // in addition, check with george why are VO initialized here Begin
    private DF_DATA_FILEVO dfDataFileVO  =  new DF_DATA_FILEVO();
    private DF_FILE_STRUCTVO dfFileStructVO   =  new DF_FILE_STRUCTVO();
    private DF_HD_FILE_GROUPVO dfHDFileGroupVO   = new DF_HD_FILE_GROUPVO();
    private ArrayList<DF_FILE_PARMVO> dfFileParamVO =  new ArrayList<DF_FILE_PARMVO>();
     
    // Elie Achkar removed this block of code since the behavior has changed for group of files
    // we need to have arraylists of the commented VOs 
    // in addition, check with george why are VO initialized here Begin
    
    private ArrayList<DF_FILE_MISC_SQLVO> dfFileMiscSQLVO;
    private ArrayList<DF_SRC_SQL_STRUCTVO> dfSrcSQLStructVO;
    private ArrayList<DF_SQL_INP_PARMVO> dfSQLInpParmVO;
    private ArrayList<DF_FILE_STRUCT_DETAILVO> dfFileStructDetailVO = new ArrayList<DF_FILE_STRUCT_DETAILVO>();
    private ArrayList<DF_FILE_TAG_VALUESVO> dfTagValuesVO;

    private ArrayList<DF_FILE_SQLVO> dfFileSQLVO; 
    private ArrayList<DF_DT_FILE_GROUPVO> dfDTFileGroupVO;
    //private BigDecimal groupFlag;

    // Elie Achkar check why groupFlag's datatype was changed to int, shouldn't it be BigDecimal
    private int groupFlag;
    
    // Elie Achkar check with George why is the fileGroup variable declared
    private String fileGroup;
    
    // Elie Achkar commented this block of code since it is causing errors Begin
	/*{
		dfDataFileVO.setFILE_DESC("File Desc");
		dfDataFileVO.setFILE_LOCATION("FILE_LOCATION");
		dfDataFileVO.setFILE_NAME("FILE_NAME");
	}*/
    // Elie Achkar commented this block of code since it is causing errors Begin

    /*
    public DynFilesCO(ArrayList<DF_DATA_FILEVO> dfDataFileVO, ArrayList<DF_FILE_STRUCTVO> dfFileStructVO, 
	    DF_HD_FILE_GROUPVO dfHDFileGroupVO, ArrayList<DF_FILE_PARMVO> dfFileParamVO, ArrayList<DF_FILE_MISC_SQLVO> dfFileMiscSQLVO,
	    ArrayList<DF_SRC_SQL_STRUCTVO> dfSrcSQLStructVO, ArrayList<DF_SQL_INP_PARMVO> dfSQLInpParmVO, 
	    ArrayList<DF_FILE_STRUCT_DETAILVO> dfFileStructDetailVO, ArrayList<DF_FILE_TAG_VALUESVO> dfTagValuesVO, 
	    ArrayList<DF_FILE_SQLVO> dfFileSQLVO, BigDecimal groupFlag, ArrayList<DF_DT_FILE_GROUPVO> dfDTFileGroupVO)
    {
	this.dfDataFileVO = dfDataFileVO;
	this.dfFileStructVO = dfFileStructVO; 
	this.dfHDFileGroupVO = dfHDFileGroupVO;
	this.dfFileParamVO = dfFileParamVO;
	this.dfFileMiscSQLVO = dfFileMiscSQLVO;
	this.dfSrcSQLStructVO = dfSrcSQLStructVO;
	this.dfSQLInpParmVO = dfSQLInpParmVO; 
	this.dfFileStructDetailVO = dfFileStructDetailVO;
	this.dfTagValuesVO = dfTagValuesVO;
	this.dfFileSQLVO = dfFileSQLVO;
	this.groupFlag = groupFlag;
	this.dfDTFileGroupVO = dfDTFileGroupVO;
    }
*/
    
    public ArrayList<DF_DT_FILE_GROUPVO> getDfDTFileGroupVO()
    {
        return dfDTFileGroupVO;
    }

    public DF_DATA_FILEVO getDfDataFileVO()
    {
        return dfDataFileVO;
    }

    public void setDfDataFileVO(DF_DATA_FILEVO dfDataFileVO)
    {
        this.dfDataFileVO = dfDataFileVO;
    }

    public DF_FILE_STRUCTVO getDfFileStructVO()
    {
        return dfFileStructVO;
    }

    public void setDfFileStructVO(DF_FILE_STRUCTVO dfFileStructVO)
    {
        this.dfFileStructVO = dfFileStructVO;
    }

    public int getGroupFlag()
    {
        return groupFlag;
    }

    public void setGroupFlag(int groupFlag)
    {
        this.groupFlag = groupFlag;
    }

    public void setDfDTFileGroupVO(ArrayList<DF_DT_FILE_GROUPVO> dfDTFileGroupVO)
    {
        this.dfDTFileGroupVO = dfDTFileGroupVO;
    }
    
    // Elie Achkar check with George why do we have an empty constructor
//    public DynFilesCO()
//    {
//    	   	
//    }
    
    // Elie Achkar check with George why is the fileGroup variable declared Begin
    public String getFileGroup() 
    {
	return fileGroup;
    }

    public void setFileGroup(String fileGroup) {
	this.fileGroup = fileGroup;
    }
    // Elie Achkar check with George why is the fileGroup variable declared End
    
	public ArrayList<DF_FILE_SQLVO> getDfFileSQLVO()
    {
        return dfFileSQLVO;
    }

    public void setDfFileSQLVO(ArrayList<DF_FILE_SQLVO> dfFileSQLVO)
    {
        this.dfFileSQLVO = dfFileSQLVO;
    }
/*
    public ArrayList<DF_DATA_FILEVO> getDfDataFileVO()
    {
        return dfDataFileVO;
    }

    public void setDfDataFileVO(ArrayList<DF_DATA_FILEVO> dfDataFileVO)
    {
        this.dfDataFileVO = dfDataFileVO;
    }

    public ArrayList<DF_FILE_STRUCTVO> getDfFileStructVO()
    {
        return dfFileStructVO;
    }

    public void setDfFileStructVO(ArrayList<DF_FILE_STRUCTVO> dfFileStructVO)
    {
        this.dfFileStructVO = dfFileStructVO;
    }
*/
    public DF_HD_FILE_GROUPVO getDfHDFileGroupVO()
    {
        return dfHDFileGroupVO;
    }

    public void setDfHDFileGroupVO(DF_HD_FILE_GROUPVO dfHDFileGroupVO)
    {
        this.dfHDFileGroupVO = dfHDFileGroupVO;
    }

    public ArrayList<DF_FILE_PARMVO> getDfFileParamVO()
    {
        return dfFileParamVO;
    }

    public void setDfFileParamVO(ArrayList<DF_FILE_PARMVO> dfFileParamVO)
    {
        this.dfFileParamVO = dfFileParamVO;
    }

    public ArrayList<DF_FILE_MISC_SQLVO> getDfFileMiscSQLVO()
    {
        return dfFileMiscSQLVO;
    }

    public void setDfFileMiscSQLVO(ArrayList<DF_FILE_MISC_SQLVO> dfFileMiscSQLVO)
    {
        this.dfFileMiscSQLVO = dfFileMiscSQLVO;
    }

    public ArrayList<DF_SRC_SQL_STRUCTVO> getDfSrcSQLStructVO()
    {
        return dfSrcSQLStructVO;
    }

    public void setDfSrcSQLStructVO(ArrayList<DF_SRC_SQL_STRUCTVO> dfSrcSQLStructVO)
    {
        this.dfSrcSQLStructVO = dfSrcSQLStructVO;
    }

    public ArrayList<DF_SQL_INP_PARMVO> getDfSQLInpParmVO()
    {
        return dfSQLInpParmVO;
    }

    public void setDfSQLInpParmVO(ArrayList<DF_SQL_INP_PARMVO> dfSQLInpParmVO)
    {
        this.dfSQLInpParmVO = dfSQLInpParmVO;
    }

    public ArrayList<DF_FILE_STRUCT_DETAILVO> getDfFileStructDetailVO()
    {
        return dfFileStructDetailVO;
    }

    public void setDfFileStructDetailVO(ArrayList<DF_FILE_STRUCT_DETAILVO> dfFileStructDetailVO)
    {
        this.dfFileStructDetailVO = dfFileStructDetailVO;
    }

    public ArrayList<DF_FILE_TAG_VALUESVO> getDfTagValuesVO()
    {
        return dfTagValuesVO;
    }

    public void setDfTagValuesVO(ArrayList<DF_FILE_TAG_VALUESVO> dfTagValuesVO)
    {
        this.dfTagValuesVO = dfTagValuesVO;
    }
/*
    public BigDecimal getGroupFlag()
    {
        return groupFlag;
    }

    public void setGroupFlag(BigDecimal groupFlag)
    {
        this.groupFlag = groupFlag;
    }
    */
}
