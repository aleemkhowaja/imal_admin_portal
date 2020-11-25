package com.path.bo.reporting;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.path.lib.reporting.exception.ReportException;
import com.path.vo.reporting.IRP_AD_HOC_REPORTCO;
import com.path.vo.reporting.IRP_AD_HOC_REPORTSC;
import com.path.vo.reporting.IRP_FCR_REPORTSCO;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: annasuccar
 *
 * CommonReportingBO.java used as common for all iMAL applications  
 * and therefore the content should not be application specific.
 */
public interface CommonReportingBO 
{
    public BigDecimal returnConnectionId(String appName) throws ReportException;
    public HashMap<String,Object> returnReportById(BigDecimal reportId) throws  Exception;
    public List<HashMap<String,Object>> retDBFields(String field, String entityDBNAME) throws Exception ;
    public List<HashMap<String,Object>> getLookupListMap(HashMap<String,Object> sysParamLovMap) throws ReportException;
    public List<String[]> returnColsList(String qryId) throws Exception, ClassNotFoundException, IOException, SQLException;
    public Integer returnQryResultCnt(HashMap<String,Object> dynLookupSCMap) throws Exception, ClassNotFoundException, IOException, SQLException;
    public ArrayList<LinkedHashMap> returnQryResult(HashMap<String,Object> dynLookupSCMap) throws Exception, ClassNotFoundException, IOException, SQLException;
    public BigDecimal retRepIdFromOldRepId(BigDecimal oldRepId) throws Exception;
    public HashMap<String,Object> retRepIdByProgRef(HashMap<String,Object> repSCMap)throws Exception;
    public HashMap<String,Object> printReport(String var_reportName, String reportFormat, Map parameters, String saveCopyLocation, String menu, HashMap<String,Object> repSessionCOMap, int decimalPts, String appName, String usrName, String language, String printerName, BigDecimal dbConn, boolean noHeadAndFoot, String csvSepartor,String noData, BigDecimal fromPage, BigDecimal toPage, String origFormat, String fromMenu,HashMap<String,String> TransMsgLangMap) throws Exception;
    public void deleteTempFiles(String filename) throws Exception;
    public List<HashMap<String,Object>> retQryArgMapping(HashMap<String,Object> repSCMap) throws Exception;
    public HashMap<String,Object> returnQueryById(BigDecimal queryId, boolean generateSyntax) throws ReportException, IOException, ClassNotFoundException;
    public void createJRXMLFile(byte[] xml, String reportPath)throws Exception ,IOException;
    public  HashMap<String,Object> createDynamicRowDataJrxml(boolean var_noHeadAndFoot,String var_reportName,String var_menuId,HashMap<String,Object> repCOMap)throws Exception;
    public byte[] loadImage(String fileName, String deleteImg) throws Exception;
    
    public IRP_AD_HOC_REPORTCO returnNewFcrReport(Map parameters) throws Exception;
    public String returnXslName(HashMap<String,Object> reportSCMap) throws Exception;
    public List<HashMap<String,Object>> returnConnectionsList() throws Exception;
    public void verifyReport(HashMap <String,Object> valuesMap) throws Exception;
    public List<HashMap<String,Object>> retRepArgDepList(HashMap<String,Object> reportSCMap)throws ReportException;
    public String retSysDateParamLovVal(String lang) throws ReportException;
    public void sendReportsByMail(HashMap<String,Object> mailCOMap ,BigDecimal msId)throws ReportException;
    public byte[]  readFileFromRepository(String fileName , String ext)throws Exception;
    public void writeFileToRepository(String fileName,String fileContent,String ext)throws Exception ;
    public int checkTemplateGLRecords(BigDecimal templateCode,BigDecimal compCode) throws Exception;
    public int checkColTempCalcType(BigDecimal colCode, BigDecimal compCode) throws Exception;
    /**
     * Returns the display value at the level of the template
     * @param parameters , compCode
     * @return display value
     * @throws Exception
     */
    public String retTemplateDispVal(Map parameters,BigDecimal compCode) throws Exception;
    public Map fillParametersWithCollection(String itemName, String itemValue, Map parameters, String argType,int from) throws Exception;
    /**
     * Method to retrieve fcr prog ref
     * @param repSC
     * @return
     * @throws Exception
     */
    public IRP_FCR_REPORTSCO retFcrRep(IRP_AD_HOC_REPORTSC repSC)throws Exception;
    /**
     * Method that retrieves the parameters of an FCR report
     * @param progRef
     * @return
     * @throws Exception
     */
    public HashMap<String,String> returnDynamicReportByRef(String progRef) throws Exception;
    
    
    /**
     * Method that retrieves the report and return the report bytes
     * @param repParameters : arguments values
     * @param sessionMap : session values,it should contain the properties listed in the implemented method
     * @paramrepDetailsMap : contains the report informations listed in the implemented method
     * @return
     * @throws ReportException and Exception
     */
    public HashMap<String,Object> returnReportBytes(Map repParameters, HashMap<String, Object> sessionMap, HashMap<String, Object> repDetailsMap,boolean isReturnOutput) throws ReportException, Exception;
    
    
    /**
     * Generate a dynamic fcr jrxml
     * @param reportCO
     * @param ftrOptProgRef which is the fcr progRef
     * @param Map parameters
     * @return the jrxml as byte
     * @throws Exception
     */
    public byte[] returnDynamicFcrJrxml(IRP_AD_HOC_REPORTCO reportCO,String ftrOptProgRef,Map parameters) throws UnsupportedEncodingException,Exception;


    /**
     * Method to get the list of filters
     * @param sc
     * @return
     * @throws Exception
     */
    public List<HashMap<String, Object>> retFiltersList(HashMap<String, Object> fitlersSCMap) throws Exception;

    /**
     * Method to get the count of filters
     * 
     * @param sc
     * @return
     * @throws Exception
     */
    public int retFiltersListCount(HashMap<String, Object> fitlersSCMap) throws Exception;

    /**
     * Method used to save or update filters
     * @param nameValueMap
     * @param nameObjMap
     * @param filtersVO
     * @param mode
     * @param overrideArguments
     * @return
     * @throws Exception
     */
    public BigDecimal saveFilter(HashMap<String, String> nameValueMap, HashMap<String, Object> nameObjMap,
	    HashMap<String, Object> filtersVOMap, String mode, boolean overrideArguments) throws Exception;

    /**
     * Method to return arguments values saved within a filter
     * @param filtersSCMap
     * @return
     * @throws Exception 
     */
    public List<HashMap<String, Object>> retFilterArgumentsValues(HashMap<String,Object> filtersSCMap) throws Exception;

    /**
     * Method to remove a given filter
     * 
     * @param filterId
     * @throws Exception
     */
    public void deleteFilterById(BigDecimal filterId) throws Exception;

    /**
     * Method to check the uniqueness of a filter name related to a specific
     * report
     * @param filtersSCMap
     * @return
     * @throws Exception
     */
    public boolean checkFilterNameUnique(HashMap<String, Object> filtersSCMap) throws Exception;
    
    /**
     * Method to check the existence of a snapshot parameter
     * report
     * @param repSCMap
     * @return  
     * @throws Exception
     */
    public int checkTextFormulaExist(HashMap<String,Object> repSCMap) throws Exception;
    
    
    /**
     * Method to will return the file name configured at the level of the upload download or the dynamic report screen 
     * @param  generatedFileName,  parameters
     * @return  the file name after replacing each parameter with the corresponding value
     * @throws Exception
     */
    public String returnGeneratedFileName(String generatedFileName, Map parameters)throws Exception;

    /**
     * Method to return the filter id of the default filter for the report
     * @param filtersSCMap
     * @return
     * @throws Exception
     */
    public BigDecimal selectDefaultFilter(HashMap<String, Object> filtersSCMap) throws Exception;
    
    /**
     * Method that will return the list of argument related to specific queryID
     * @param queryId
     * @return
     * @throws Exception
     */
    public ArrayList<HashMap<String,Object>> returnArgListByQryId(HashMap<String,Object> hm) throws Exception;
    
    /**
     * Method that will return the sql Syntax with replaced Arguments
     * @param queryId
     * @param SCMap
     * @return
     * @throws Exception
     */
    public StringBuffer returnQuerySyntaxWithReplacedArgs(BigDecimal queryId,ArrayList<HashMap<String,Object>> SCMap) throws Exception;
    /**
     * Retrieve connection description
     * @param conId
     * @return
     * @throws Exception
     */
    public String retConnectionDescById(BigDecimal conId) throws Exception;
    
    /**
     * Method that will return the report details based on the progRef and application name
     * @param paramsMap
     * @return HashMap<String,Object>
     * @throws Exception
     */
    public HashMap<String,Object> returnReportDetailsByRef(HashMap<String,Object> paramsMap)throws Exception;
    
    /**
     * Method used to change the name of a file under repository
     * @param paramsMap
     * @throws Exception
     */
    public void renameBatchFolder(HashMap<String,Object> paramsMap)throws Exception;
    
    /**
     * return Report ByteArray related to CurrentPage number
     * @param paramsMap
     * @return
     * @throws Exception
     */
    public HashMap<String,Object> returnReportByteArrayCurrentPage(HashMap<String,Object> paramsMap)throws Exception;
    
    
    /**
     * Alert Required Methods
     */
    
    /**
     * 
     * @param paramsMap
     * @return
     * @throws Exception
     */
    public HashMap<String,Object> returnQueriesList(HashMap<String,Object> paramsMap)throws Exception;
    
    /**
     * 
     * @param paramsMap
     * @return
     * @throws Exception
     */
    public HashMap<String, Object> returnQueriesListCount(HashMap<String, Object> paramsMap) throws Exception;
    
    /**
     * save Sorting in IRP_REP_SORT table
     * @param lstSortingAllMap
     * @return
     * @throws Exception
     */
    public void saveSorting(HashMap<String, Object> lstSortingAllMap) throws Exception;
    
    /**
     * return Sorting List From IrpRepSort table
     * @param lstSortingMap
     * @throws Exception
     */
    public HashMap<String, Object> retSortingListFromIrpRepSort(HashMap<String, Object> lstSortingMap) throws Exception;
    
    /**
     * Return the report details based on the given report id.
     * @param hm
     * @return
     * @throws Exception
     */
    public HashMap<String, Object> retProgRefByRepId(HashMap<String, Object> hm) throws Exception;
    
    
    /**
     * Method that will return All reports
     * @param queryId
     * @return List of all reports
     * @throws Exception
     */
    public ArrayList<HashMap<String,Object>> retAllReports(HashMap<String,Object> hm) throws Exception;
    
    /**
     * Method that will return All reports Count
     * @param queryId
     * @return List of all reports Count
     * @throws Exception
     */
    public int retAllReportsCount(HashMap<String, Object> hm) throws Exception;
    
    /**
     * Method that will report details against PROG REF
     * @param queryId
     * @return Report detail
     * @throws Exception
     */
    public HashMap<String, Object> retReportByProgRef(HashMap<String,Object> hm) throws Exception;
    
    /**
     * Return the report snapshot based on the given snapshot id.
     * @param hm
     * @return
     * @throws Exception
     */
    public HashMap<String, Object> retSnapshotById(HashMap<String, Object> hm) throws Exception;
}
