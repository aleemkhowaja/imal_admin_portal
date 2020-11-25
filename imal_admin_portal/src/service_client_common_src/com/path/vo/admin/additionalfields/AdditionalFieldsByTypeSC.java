/**
 * 
 */
package com.path.vo.admin.additionalfields;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.common.additionalfield.AdditionalFieldsByTypeCO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AdditionalFieldsByTypeSC.java used to
 */
public class AdditionalFieldsByTypeSC extends GridParamsSC
{
    private BigDecimal CTS_ADD_FIELDSVO_CODE;
    private BigDecimal COLUMN_NUMBER;
    private String DATA_ENTRY;
    private String DESC_OUTPUT;
    private String PARAM1_LINK_VALUE;
    private String PARAM2_LINK_VALUE;
    private String PARAM3_LINK_VALUE;
    private String PARAM4_LINK_VALUE;
    private String PARAM5_LINK_VALUE;
    private String dynamicQuery;
    Map<String, Object> params = new HashMap<String, Object>();

    //Session variables
    private BigDecimal branchCode; 
    private BigDecimal baseCurrencyCode;
    private BigDecimal fiscalYear;
    private BigDecimal baseCurrDecPoint; 
    private BigDecimal exposCurCode;
    private String companyName;
    private String companyArabName;
    private String userName;
    private String clientType;
    private String baseCurrencyName;
    private String exposCurName;
    private String currentAppName;
    private Date runningDateRET ;
    
    private BigDecimal dependencyCode;
    private String description;
    
    private boolean numberDependency;
    
    private String param1LinkLabel;
    private String param2LinkLabel;
    private String param3LinkLabel;
    private String param4LinkLabel;
    private String param5LinkLabel;
    private BigDecimal listCode;
    private ArrayList<AdditionalFieldsByTypeCO> mandatoryElemsList;
    
    private String fieldType;
    private String dependencyString;
    
    /**
     * @return the dynamicQuery
     */
    public String getDynamicQuery()
    {
        return dynamicQuery;
    }

    /**
     * @param dynamicQuery the dynamicQuery to set
     */
    public void setDynamicQuery(String dynamicQuery)
    {
        this.dynamicQuery = dynamicQuery;
    }

    /**
     * @return the cTS_ADD_FIELDSVO_CODE
     */
    public BigDecimal getCTS_ADD_FIELDSVO_CODE()
    {
        return CTS_ADD_FIELDSVO_CODE;
    }

    /**
     * @param cTSADDFIELDSVOCODE the cTS_ADD_FIELDSVO_CODE to set
     */
    public void setCTS_ADD_FIELDSVO_CODE(BigDecimal cTSADDFIELDSVOCODE)
    {
        CTS_ADD_FIELDSVO_CODE = cTSADDFIELDSVOCODE;
    }

    /**
     * @return the cOLUMN_NUMBER
     */
    public BigDecimal getCOLUMN_NUMBER()
    {
        return COLUMN_NUMBER;
    }

    /**
     * @param cOLUMNNUMBER the cOLUMN_NUMBER to set
     */
    public void setCOLUMN_NUMBER(BigDecimal cOLUMNNUMBER)
    {
        COLUMN_NUMBER = cOLUMNNUMBER;
    }

    /**
     * @return the branchCode
     */
    public BigDecimal getBranchCode()
    {
        return branchCode;
    }

    /**
     * @param branchCode the branchCode to set
     */
    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }

    /**
     * @return the baseCurrencyCode
     */
    public BigDecimal getBaseCurrencyCode()
    {
        return baseCurrencyCode;
    }

    /**
     * @param baseCurrencyCode the baseCurrencyCode to set
     */
    public void setBaseCurrencyCode(BigDecimal baseCurrencyCode)
    {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    /**
     * @return the fiscalYear
     */
    public BigDecimal getFiscalYear()
    {
        return fiscalYear;
    }

    /**
     * @param fiscalYear the fiscalYear to set
     */
    public void setFiscalYear(BigDecimal fiscalYear)
    {
        this.fiscalYear = fiscalYear;
    }

    /**
     * @return the baseCurrDecPoint
     */
    public BigDecimal getBaseCurrDecPoint()
    {
        return baseCurrDecPoint;
    }

    /**
     * @param baseCurrDecPoint the baseCurrDecPoint to set
     */
    public void setBaseCurrDecPoint(BigDecimal baseCurrDecPoint)
    {
        this.baseCurrDecPoint = baseCurrDecPoint;
    }

    /**
     * @return the exposCurCode
     */
    public BigDecimal getExposCurCode()
    {
        return exposCurCode;
    }

    /**
     * @param exposCurCode the exposCurCode to set
     */
    public void setExposCurCode(BigDecimal exposCurCode)
    {
        this.exposCurCode = exposCurCode;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName()
    {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    /**
     * @return the companyArabName
     */
    public String getCompanyArabName()
    {
        return companyArabName;
    }

    /**
     * @param companyArabName the companyArabName to set
     */
    public void setCompanyArabName(String companyArabName)
    {
        this.companyArabName = companyArabName;
    }

    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * @return the clientType
     */
    public String getClientType()
    {
        return clientType;
    }

    /**
     * @param clientType the clientType to set
     */
    public void setClientType(String clientType)
    {
        this.clientType = clientType;
    }

    /**
     * @return the baseCurrencyName
     */
    public String getBaseCurrencyName()
    {
        return baseCurrencyName;
    }

    /**
     * @param baseCurrencyName the baseCurrencyName to set
     */
    public void setBaseCurrencyName(String baseCurrencyName)
    {
        this.baseCurrencyName = baseCurrencyName;
    }

    /**
     * @return the exposCurName
     */
    public String getExposCurName()
    {
        return exposCurName;
    }

    /**
     * @param exposCurName the exposCurName to set
     */
    public void setExposCurName(String exposCurName)
    {
        this.exposCurName = exposCurName;
    }

    /**
     * @return the currentAppName
     */
    public String getCurrentAppName()
    {
        return currentAppName;
    }

    /**
     * @param currentAppName the currentAppName to set
     */
    public void setCurrentAppName(String currentAppName)
    {
        this.currentAppName = currentAppName;
    }

    /**
     * @return the runningDateRET
     */
    public Date getRunningDateRET()
    {
        return runningDateRET;
    }

    /**
     * @param runningDateRET the runningDateRET to set
     */
    public void setRunningDateRET(Date runningDateRET)
    {
        this.runningDateRET = runningDateRET;
    }

    /**
     * @return the dependencyCode
     */
    public BigDecimal getDependencyCode()
    {
        return dependencyCode;
    }

    /**
     * @param dependencyCode the dependencyCode to set
     */
    public void setDependencyCode(BigDecimal dependencyCode)
    {
        this.dependencyCode = dependencyCode;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the dATA_ENTRY
     */
    public String getDATA_ENTRY()
    {
        return DATA_ENTRY;
    }

    /**
     * @param dATAENTRY the dATA_ENTRY to set
     */
    public void setDATA_ENTRY(String dATAENTRY)
    {
        DATA_ENTRY = dATAENTRY;
    }

    /**
     * @return the dESC_OUTPUT
     */
    public String getDESC_OUTPUT()
    {
        return DESC_OUTPUT;
    }

    /**
     * @param dESCOUTPUT the dESC_OUTPUT to set
     */
    public void setDESC_OUTPUT(String dESCOUTPUT)
    {
        DESC_OUTPUT = dESCOUTPUT;
    }

    /**
     * @return the pARAM1_LINK_VALUE
     */
    public String getPARAM1_LINK_VALUE()
    {
        return PARAM1_LINK_VALUE;
    }

    /**
     * @param pARAM1LINKVALUE the pARAM1_LINK_VALUE to set
     */
    public void setPARAM1_LINK_VALUE(String pARAM1LINKVALUE)
    {
        PARAM1_LINK_VALUE = pARAM1LINKVALUE;
    }

    /**
     * @return the pARAM2_LINK_VALUE
     */
    public String getPARAM2_LINK_VALUE()
    {
        return PARAM2_LINK_VALUE;
    }

    /**
     * @param pARAM2LINKVALUE the pARAM2_LINK_VALUE to set
     */
    public void setPARAM2_LINK_VALUE(String pARAM2LINKVALUE)
    {
        PARAM2_LINK_VALUE = pARAM2LINKVALUE;
    }

    /**
     * @return the pARAM3_LINK_VALUE
     */
    public String getPARAM3_LINK_VALUE()
    {
        return PARAM3_LINK_VALUE;
    }

    /**
     * @param pARAM3LINKVALUE the pARAM3_LINK_VALUE to set
     */
    public void setPARAM3_LINK_VALUE(String pARAM3LINKVALUE)
    {
        PARAM3_LINK_VALUE = pARAM3LINKVALUE;
    }

    /**
     * @return the pARAM4_LINK_VALUE
     */
    public String getPARAM4_LINK_VALUE()
    {
        return PARAM4_LINK_VALUE;
    }

    /**
     * @param pARAM4LINKVALUE the pARAM4_LINK_VALUE to set
     */
    public void setPARAM4_LINK_VALUE(String pARAM4LINKVALUE)
    {
        PARAM4_LINK_VALUE = pARAM4LINKVALUE;
    }

    /**
     * @return the pARAM5_LINK_VALUE
     */
    public String getPARAM5_LINK_VALUE()
    {
        return PARAM5_LINK_VALUE;
    }

    /**
     * @param pARAM5LINKVALUE the pARAM5_LINK_VALUE to set
     */
    public void setPARAM5_LINK_VALUE(String pARAM5LINKVALUE)
    {
        PARAM5_LINK_VALUE = pARAM5LINKVALUE;
    }

    /**
     * @return the params
     */
    public Map<String, Object> getParams()
    {
        return params;
    }

    /**
     * @param params the params to set
     */
    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }

    /**
     * @return the numberDependency
     */
    public boolean isNumberDependency()
    {
        return numberDependency;
    }

    /**
     * @param numberDependency the numberDependency to set
     */
    public void setNumberDependency(boolean numberDependency)
    {
        this.numberDependency = numberDependency;
    }

    /**
     * @return the param1LinkLabel
     */
    public String getParam1LinkLabel()
    {
        return param1LinkLabel;
    }

    /**
     * @param param1LinkLabel the param1LinkLabel to set
     */
    public void setParam1LinkLabel(String param1LinkLabel)
    {
        this.param1LinkLabel = param1LinkLabel;
    }

    /**
     * @return the param2LinkLabel
     */
    public String getParam2LinkLabel()
    {
        return param2LinkLabel;
    }

    /**
     * @param param2LinkLabel the param2LinkLabel to set
     */
    public void setParam2LinkLabel(String param2LinkLabel)
    {
        this.param2LinkLabel = param2LinkLabel;
    }

    /**
     * @return the param3LinkLabel
     */
    public String getParam3LinkLabel()
    {
        return param3LinkLabel;
    }

    /**
     * @param param3LinkLabel the param3LinkLabel to set
     */
    public void setParam3LinkLabel(String param3LinkLabel)
    {
        this.param3LinkLabel = param3LinkLabel;
    }

    /**
     * @return the param4LinkLabel
     */
    public String getParam4LinkLabel()
    {
        return param4LinkLabel;
    }

    /**
     * @param param4LinkLabel the param4LinkLabel to set
     */
    public void setParam4LinkLabel(String param4LinkLabel)
    {
        this.param4LinkLabel = param4LinkLabel;
    }

    /**
     * @return the param5LinkLabel
     */
    public String getParam5LinkLabel()
    {
        return param5LinkLabel;
    }

    /**
     * @param param5LinkLabel the param5LinkLabel to set
     */
    public void setParam5LinkLabel(String param5LinkLabel)
    {
        this.param5LinkLabel = param5LinkLabel;
    }

    public String getFieldType()
    {
	return fieldType;
    }

    public void setFieldType(String fieldType)
    {
	this.fieldType = fieldType;
    }

    public String getDependencyString()
    {
	return dependencyString;
    }

    public void setDependencyString(String dependencyString)
    {
	this.dependencyString = dependencyString;
    }

    public BigDecimal getListCode()
    {
        return listCode;
    }

    public void setListCode(BigDecimal listCode)
    {
        this.listCode = listCode;
    }

    public ArrayList<AdditionalFieldsByTypeCO> getMandatoryElemsList()
    {
        return mandatoryElemsList;
    }

    public void setMandatoryElemsList(ArrayList<AdditionalFieldsByTypeCO> mandatoryElemsList)
    {
        this.mandatoryElemsList = mandatoryElemsList;
    }

   
   

}
