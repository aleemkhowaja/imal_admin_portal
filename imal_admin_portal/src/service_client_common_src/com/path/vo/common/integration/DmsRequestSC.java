package com.path.vo.common.integration;

import java.util.HashMap;

import com.path.struts2.lib.common.BaseSC;

public class DmsRequestSC extends BaseSC
{
    private int companyCode; // The logged in company code
    private int brCode; // The logged In branch code
    private String userID; // User Id,
    private String appName; // Application name,
    private String progRef; // prog Ref
    private String[] indexFieldName; // Index Name
    private String[] indexFieldValue; // Index Value

    //ENH 514292 adding header to the index names and values in order to support multiple docuware for same screen 
    private HashMap<String,HashMap<String,String>> indexMap = new HashMap<String,HashMap<String,String>>();
    
    //ENH 514292 flag to consider old/new feature to handle compatibility with previous releases.
    private int dmsDetailsParams;
    
    public int getCompanyCode()
    {
        return companyCode;
    }
    public void setCompanyCode(int companyCode)
    {
        this.companyCode = companyCode;
    }
    public int getBrCode()
    {
        return brCode;
    }
    public void setBrCode(int brCode)
    {
        this.brCode = brCode;
    }
    public String getUserID()
    {
        return userID;
    }
    public void setUserID(String userID)
    {
        this.userID = userID;
    }
    public String getAppName()
    {
        return appName;
    }
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    public String getProgRef()
    {
        return progRef;
    }
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
    public String[] getIndexFieldName()
    {
        return indexFieldName;
    }
    public void setIndexFieldName(String[] indexFieldName)
    {
        this.indexFieldName = indexFieldName;
    }
    public String[] getIndexFieldValue()
    {
        return indexFieldValue;
    }
    public void setIndexFieldValue(String[] indexFieldValue)
    {
        this.indexFieldValue = indexFieldValue;
    }
    public HashMap<String, HashMap<String, String>> getIndexMap()
    {
        return indexMap;
    }
    public void setIndexMap(HashMap<String, HashMap<String, String>> indexMap)
    {
        this.indexMap = indexMap;
    }
    public int getDmsDetailsParams()
    {
        return dmsDetailsParams;
    }
    public void setDmsDetailsParams(int dmsDetailsParams)
    {
        this.dmsDetailsParams = dmsDetailsParams;
    }
    
}