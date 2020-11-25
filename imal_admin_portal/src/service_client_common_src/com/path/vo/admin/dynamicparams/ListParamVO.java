package com.path.vo.admin.dynamicparams;

import com.path.lib.vo.BaseVO;


public class ListParamVO extends BaseVO
{
    private static final long serialVersionUID = 1L;
    String valueList;
    String key;
    String value;
    String hasHiddenOpt;

    public String getValueList()
    {
	return valueList;
    }

    public void setValueList(String valueList)
    {
	this.valueList = valueList;
    }

    public String getKey()
    {
	return key;
    }

    public void setKey(String key)
    {
	this.key = key;
    }

    public String getValue()
    {
	return value;
    }

    public void setValue(String value)
    {
	this.value = value;
    }

    /**
     * @return the hasHiddenOpt
     */
    public String getHasHiddenOpt()
    {
        return hasHiddenOpt;
    }

    /**
     * @param hasHiddenOpt the hasHiddenOpt to set
     */
    public void setHasHiddenOpt(String hasHiddenOpt)
    {
        this.hasHiddenOpt = hasHiddenOpt;
    }
}
