package com.path.vo.common;

import com.path.lib.vo.BaseVO;

public class LabelElemCO extends BaseVO
{
    private String elementId; //html id of element that requires label change,or gridId in case of grid
    private String gridColName; //column name filled in case of grid
    private String value; //new label value trans
    public String getElementId()
    {
        return elementId;
    }
    public void setElementId(String elementId)
    {
        this.elementId = elementId;
    }
    public String getGridColName()
    {
        return gridColName;
    }
    public void setGridColName(String gridColName)
    {
        this.gridColName = gridColName;
    }
    public String getValue()
    {
        return value;
    }
    public void setValue(String value)
    {
        this.value = value;
    }
}
