package com.path.vo.reporting;

import com.path.lib.vo.BaseVO;

public class USER_TAB_COLSCO extends BaseVO
{

    private String TABLE_NAME;
    private String COLUMN_NAME;
    private String Data_Type;

    
    
    
    
    public String getData_Type()
    {
        return Data_Type;
    }

    public void setData_Type(String dataType)
    {
        Data_Type = dataType;
    }

    public String getTABLE_NAME()
    {
	return TABLE_NAME;
    }

    public void setTABLE_NAME(String tABLENAME)
    {
	TABLE_NAME = tABLENAME;
    }

    public String getCOLUMN_NAME()
    {
	return COLUMN_NAME;
    }

    public void setCOLUMN_NAME(String cOLUMNNAME)
    {
	COLUMN_NAME = cOLUMNNAME;
    }

}
