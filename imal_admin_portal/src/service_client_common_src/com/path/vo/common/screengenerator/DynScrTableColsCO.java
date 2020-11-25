/**
 * 
 */
package com.path.vo.common.screengenerator;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

/**
 * @author marwanmaddah
 *
 */
public class DynScrTableColsCO extends BaseVO
{
    private BigDecimal TABLE_ID;
    private String     TABLE_TECH_NAME;
    private String     TABLE_DESC;
    private BigDecimal COL_ID;
    private String     COL_TECH_NAME;
    private String     COL_DESC;
    private BigDecimal PRIMARY_KEY;
    private String     COL_TYPE;
    private String     COL_TYPE_DESC;
    private BigDecimal VISIBLE_YN;
    private String 	   HIDDEN;
    private BigDecimal COL_LENGTH;
    private BigDecimal DECIMAL_VALUE;
    private String actionName;
    private String searchElement;
    private String paramList;
    private String resultList;
    private String nbFormat;
    //TP#982174 Add dependency to live search in column properties
    private String dependencySrc;
    private String dependency;
    private String parameter;
    private String		VISIBILITY_YN;
    private String 	SOURCE_MAPPING;
    private BigDecimal	SOURCE_MAPPING_CODE;
    private String      ENABLE_FIELD = "true";

    
	/**
     * @return the tABLE_ID
     */
    public BigDecimal getTABLE_ID()
    {
        return TABLE_ID;
    }
    /**
     * @param tABLE_ID the tABLE_ID to set
     */
    public void setTABLE_ID(BigDecimal tABLE_ID)
    {
        TABLE_ID = tABLE_ID;
    }
    /**
     * @return the tABLE_TECH_NAME
     */
    public String getTABLE_TECH_NAME()
    {
        return TABLE_TECH_NAME;
    }
    /**
     * @param tABLE_TECH_NAME the tABLE_TECH_NAME to set
     */
    public void setTABLE_TECH_NAME(String tABLE_TECH_NAME)
    {
        TABLE_TECH_NAME = tABLE_TECH_NAME;
    }
    /**
     * @return the tABLE_DESC
     */
    public String getTABLE_DESC()
    {
        return TABLE_DESC;
    }
    /**
     * @param tABLE_DESC the tABLE_DESC to set
     */
    public void setTABLE_DESC(String tABLE_DESC)
    {
        TABLE_DESC = tABLE_DESC;
    }
    /**
     * @return the cOL_ID
     */
    public BigDecimal getCOL_ID()
    {
        return COL_ID;
    }
    /**
     * @param cOL_ID the cOL_ID to set
     */
    public void setCOL_ID(BigDecimal cOL_ID)
    {
        COL_ID = cOL_ID;
    }
    /**
     * @return the cOL_TECH_NAME
     */
    public String getCOL_TECH_NAME()
    {
        return COL_TECH_NAME;
    }
    /**
     * @param cOL_TECH_NAME the cOL_TECH_NAME to set
     */
    public void setCOL_TECH_NAME(String cOL_TECH_NAME)
    {
        COL_TECH_NAME = cOL_TECH_NAME;
    }
    /**
     * @return the cOL_DESC
     */
    public String getCOL_DESC()
    {
        return COL_DESC;
    }
    /**
     * @param cOL_DESC the cOL_DESC to set
     */
    public void setCOL_DESC(String cOL_DESC)
    {
        COL_DESC = cOL_DESC;
    }
    /**
     * @return the cOL_TYPE
     */
    public String getCOL_TYPE()
    {
        return COL_TYPE;
    }
    /**
     * @param cOL_TYPE the cOL_TYPE to set
     */
    public void setCOL_TYPE(String cOL_TYPE)
    {
        COL_TYPE = cOL_TYPE;
    }
    /**
     * @return the pRIMARY_KEY
     */
    public BigDecimal getPRIMARY_KEY()
    {
        return PRIMARY_KEY;
    }

    /**
     * @param pRIMARY_KEY the pRIMARY_KEY to set
     */
    public void setPRIMARY_KEY(BigDecimal pRIMARY_KEY)
    {
	PRIMARY_KEY = pRIMARY_KEY;
    }

    public String getCOL_TYPE_DESC()
    {
	return COL_TYPE_DESC;
    }

    public void setCOL_TYPE_DESC(String cOL_TYPE_DESC)
    {
	COL_TYPE_DESC = cOL_TYPE_DESC;
    }

    public BigDecimal getVISIBLE_YN()
    {
	return VISIBLE_YN;
    }

    public void setVISIBLE_YN(BigDecimal vISIBLE_YN)
    {
	VISIBLE_YN = vISIBLE_YN;
    }

    public String getHIDDEN()
    {
	return HIDDEN;
    }

    public void setHIDDEN(String hIDDEN)
    {
	HIDDEN = hIDDEN;
    }

    public BigDecimal getCOL_LENGTH()
    {
	return COL_LENGTH;
    }

    public void setCOL_LENGTH(BigDecimal cOL_LENGTH)
    {
	COL_LENGTH = cOL_LENGTH;
    }

    public BigDecimal getDECIMAL_VALUE()
    {
	return DECIMAL_VALUE;
    }

    public void setDECIMAL_VALUE(BigDecimal dECIMAL_VALUE)
    {
	DECIMAL_VALUE = dECIMAL_VALUE;
    }
    
    public String getActionName()
    {
        return actionName;
    }
    
    public void setActionName(String actionName)
    {
        this.actionName = actionName;
    }
    
    public String getSearchElement()
    {
        return searchElement;
    }
    
    public void setSearchElement(String searchElement)
    {
        this.searchElement = searchElement;
    }
    
    public String getParamList()
    {
        return paramList;
    }
    
    public void setParamList(String paramList)
    {
        this.paramList = paramList;
    }
    
    public String getResultList()
    {
        return resultList;
    }
    
    public void setResultList(String resultList)
    {
        this.resultList = resultList;
    }
    public String getDependencySrc()
    {
        return dependencySrc;
    }
    public void setDependencySrc(String dependencySrc)
    {
        this.dependencySrc = dependencySrc;
    }
    public String getDependency()
    {
        return dependency;
    }
    public void setDependency(String dependency)
    {
        this.dependency = dependency;
    }
    public String getParameter()
    {
        return parameter;
    }
    public void setParameter(String parameter)
    {
        this.parameter = parameter;
    }
    
    public String getNbFormat() {
	return nbFormat;
    }
    public void setNbFormat(String nbFormat) {
	this.nbFormat = nbFormat;
    }    
	public String getVISIBILITY_YN() {
		return VISIBILITY_YN;
	}
	public void setVISIBILITY_YN(String vISIBILITY_YN) {
		VISIBILITY_YN = vISIBILITY_YN;
	}
	public String getSOURCE_MAPPING() {
		return SOURCE_MAPPING;
	}
	public void setSOURCE_MAPPING(String sOURCE_MAPPING) {
		SOURCE_MAPPING = sOURCE_MAPPING;
	}
	public BigDecimal getSOURCE_MAPPING_CODE()
	{
	    return SOURCE_MAPPING_CODE;
	}
	public void setSOURCE_MAPPING_CODE(BigDecimal sOURCE_MAPPING_CODE)
	{
	    SOURCE_MAPPING_CODE = sOURCE_MAPPING_CODE;
	}
	public String getENABLE_FIELD()
	{
	    return ENABLE_FIELD;
	}
	public void setENABLE_FIELD(String eNABLE_FIELD)
	{
	    ENABLE_FIELD = eNABLE_FIELD;
	}
	
}
