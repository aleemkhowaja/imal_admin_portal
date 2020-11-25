package com.path.vo.common.dynfiles;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.path.dbmaps.vo.DF_DATA_FILEVO;
import com.path.dbmaps.vo.DF_FILE_PARMVO;
import com.path.dbmaps.vo.DF_FILE_STRUCTVO;
import com.path.lib.vo.BaseVO;

public class DynFilesDetCO extends BaseVO
{
    private DF_DATA_FILEVO dfDataFileVO = new DF_DATA_FILEVO();
    private DF_FILE_STRUCTVO dfFileStructVO = new DF_FILE_STRUCTVO();
    private BigDecimal fileGroup;
    private ArrayList<DF_FILE_PARMVO> dfFileParmVO;
    private ArrayList<DynFilesMiscSQLListCO> dfMiscSQLListCO;
    private ArrayList<DynFilesTagParametersCO> dfFileTagParametersCO;
    private int nbvCalcSessionTimeOut;
    private BigDecimal selectedFileType;
    private boolean xsdAttached;
    
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
    public BigDecimal getFileGroup()
    {
	return fileGroup;
    }
    public void setFileGroup(BigDecimal fileGroup)
    {
	this.fileGroup = fileGroup;
    }
    public ArrayList<DF_FILE_PARMVO> getDfFileParmVO()
    {
	return dfFileParmVO;
    }
    public void setDfFileParmVO(ArrayList<DF_FILE_PARMVO> dfFileParmVO)
    {
	this.dfFileParmVO = dfFileParmVO;
    }
    public ArrayList<DynFilesMiscSQLListCO> getDfMiscSQLListCO()
    {
	return dfMiscSQLListCO;
    }
    public void setDfMiscSQLListCO(ArrayList<DynFilesMiscSQLListCO> dfMiscSQLListCO)
    {
	this.dfMiscSQLListCO = dfMiscSQLListCO;
    }
    public ArrayList<DynFilesTagParametersCO> getDfFileTagParametersCO() 
    {
	return dfFileTagParametersCO;
    }
    public void setDfFileTagParametersCO(ArrayList<DynFilesTagParametersCO> dfFileTagParametersCO) 
    {
	this.dfFileTagParametersCO = dfFileTagParametersCO;
    }
    public int getNbvCalcSessionTimeOut()
    {
        return nbvCalcSessionTimeOut;
    }
    public void setNbvCalcSessionTimeOut(int nbvCalcSessionTimeOut)
    {
        this.nbvCalcSessionTimeOut = nbvCalcSessionTimeOut;
    }
    public BigDecimal getSelectedFileType()
    {
        return selectedFileType;
    }
    public void setSelectedFileType(BigDecimal selectedFileType)
    {
        this.selectedFileType = selectedFileType;
    }
    public boolean isXsdAttached()
    {
        return xsdAttached;
    }
    public void setXsdAttached(boolean xsdAttached)
    {
        this.xsdAttached = xsdAttached;
    }
    
    
}
