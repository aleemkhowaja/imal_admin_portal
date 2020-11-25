package com.path.vo.common.dynfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public class DynFilesSQLResultCO
{
    Map<String, BigDecimal> columns;
    ArrayList<ArrayList<DynFilesColumnCO>> selectResult;
    
    public Map<String, BigDecimal> getColumns()
    {
        return columns;
    }
    public void setColumns(Map<String, BigDecimal> columns)
    {
        this.columns = columns;
    }
    public ArrayList<ArrayList<DynFilesColumnCO>> getSelectResult()
    {
        return selectResult;
    }
    public void setSelectResult(ArrayList<ArrayList<DynFilesColumnCO>> selectResult)
    {
        this.selectResult = selectResult;
    }
}
