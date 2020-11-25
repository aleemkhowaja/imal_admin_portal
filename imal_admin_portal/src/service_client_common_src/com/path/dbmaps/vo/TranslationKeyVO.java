/**
 * 
 */
package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;

/**
 * @author MarwanMaddah
 * 
 */
public class TranslationKeyVO extends BaseVO
{

    private static final long serialVersionUID = 1L;
    private String theKey;
    private String value;

    /**
     * @return the theKey
     */
    public String getTheKey()
    {
	return theKey;
    }

    /**
     * @param theKey the theKey to set
     */
    public void setTheKey(String theKey)
    {
	this.theKey = theKey;
    }

    /**
     * @return the value
     */
    public String getValue()
    {
	return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value)
    {
	this.value = value;
    }

}
