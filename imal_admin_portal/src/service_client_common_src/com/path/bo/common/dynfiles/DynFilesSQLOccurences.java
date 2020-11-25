package com.path.bo.common.dynfiles;

import java.util.ArrayList;

import com.path.dbmaps.vo.DF_DATA_IMPORT_TMPVO;

public class DynFilesSQLOccurences
{
    private ArrayList<Integer> parametersReplaced;
    private DF_DATA_IMPORT_TMPVO dataTempVO;
    private String[] dataColumn;
    
    public ArrayList<Integer> getParametersReplaced()
    {
        return parametersReplaced;
    }
    public void setParametersReplaced(ArrayList<Integer> parametersReplaced)
    {
        this.parametersReplaced = parametersReplaced;
    }
    public DF_DATA_IMPORT_TMPVO getDataTempVO()
    {
        return dataTempVO;
    }
    public void setDataTempVO(DF_DATA_IMPORT_TMPVO dataTempVO)
    {
        this.dataTempVO = dataTempVO;
    }
    public String[] getDataColumn()
    {
        return dataColumn;
    }
    public void setDataColumn(String... dataColumn)
    {
        this.dataColumn = dataColumn;
    }
}
