/**
 * @Auther:MarwanMaddah
 * @Date:Feb 15, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.common;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.path.lib.vo.BaseVO;


public class CheckRequiredCO extends BaseVO
{
   private Object     obj_value;
   private String     opt;
   private String     app;
   private Integer    result_code;
   private String     result_msgs;
   private String     language;
   private BigDecimal compCode;
   private BigDecimal trxType;
   private BigDecimal cifType;   
   private String     entityType;
   private BigDecimal entityCode;
   private Map<String,Object> entityTypeInfosMap = new HashMap<String,Object>();
   private String fromSmart;
   private String fromDynamicScreen;//TP#1085788
    /**
     * @return the obj_value
     */
    public Object getObj_value()
    {
	return obj_value;
    }

    /**
     * @param objValue the obj_value to set
     */
    public void setObj_value(Object objValue)
    {
	obj_value = objValue;
    }

    /**
     * @return the opt
     */
    public String getOpt()
    {
	return opt;
    }

    /**
     * @param opt the opt to set
     */
    public void setOpt(String opt)
    {
	this.opt = opt;
    }

    /**
     * @return the app
     */
    public String getApp()
    {
	return app;
    }

    /**
     * @param app the app to set
     */
    public void setApp(String app)
    {
	this.app = app;
    }

    /**
     * @return the result_code
     */
    public Integer getResult_code()
    {
	return result_code;
    }

    /**
     * @param resultCode the result_code to set
     */
    public void setResult_code(Integer resultCode)
    {
	result_code = resultCode;
    }

    /**
     * @return the result_msgs
     */
    public String getResult_msgs()
    {
	return result_msgs;
    }

    /**
     * @param resultMsgs the result_msgs to set
     */
    public void setResult_msgs(String resultMsgs)
    {
	result_msgs = resultMsgs;
    }

    /**
     * @return the language
     */
    public String getLanguage()
    {
	return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language)
    {
	this.language = language;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    /**
     * @return the trxType
     */
    public BigDecimal getTrxType()
    {
	return trxType;
    }

    /**
     * @param trxType the trxType to set
     */
    public void setTrxType(BigDecimal trxType)
    {
	this.trxType = trxType;
    }

    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public String getEntityType()
    {
        return entityType;
    }

    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }

    public BigDecimal getEntityCode()
    {
        return entityCode;
    }

    public void setEntityCode(BigDecimal entityCode)
    {
        this.entityCode = entityCode;
    }

    public Map<String, Object> getEntityTypeInfosMap()
    {
        return entityTypeInfosMap;
    }

    public void setEntityTypeInfosMap(Map<String, Object> entityTypeInfosMap)
    {
        this.entityTypeInfosMap = entityTypeInfosMap;
    }

	public String getFromSmart() {
		return fromSmart;
	}

	public void setFromSmart(String fromSmart) {
		this.fromSmart = fromSmart;
	}

	public String getFromDynamicScreen()
	{
	    return fromDynamicScreen;
	}

	public void setFromDynamicScreen(String fromDynamicScreen)
	{
	    this.fromDynamicScreen = fromDynamicScreen;
	}
}
