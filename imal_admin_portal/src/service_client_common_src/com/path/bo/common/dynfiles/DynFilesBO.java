package com.path.bo.common.dynfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.path.dbmaps.vo.DF_DATA_FILEVO;
import com.path.dbmaps.vo.DF_DATA_IMPORT_TMPVO;
import com.path.dbmaps.vo.DF_FILE_PARMVO;
import com.path.dbmaps.vo.DF_FILE_TAG_INP_PARAMVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.dynfiles.DynFilesCO;
import com.path.vo.common.dynfiles.DynFilesDetCO;
import com.path.vo.common.dynfiles.DynFilesImportCO;
import com.path.vo.common.dynfiles.DynFilesSC;
import com.path.vo.common.dynfiles.DynFilesTagParametersCO;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: ElieAchkar
 *
 * DynFilesBO.java used to call the DAOs to retrieve needed data
 */

public interface DynFilesBO
{
    public Integer returnDynFilesListCount(DynFilesSC dynFilesSC) throws BaseException;
    
    /**
     * 
     * @param dynFilesSC
     * @return
     * @throws BaseException
     * function called to retrieve the list of files for the logged in user
     */
    public ArrayList<DF_DATA_FILEVO> returnDynFilesList (DynFilesSC dynFilesSC) throws BaseException;
    
    /**
     * 
     * @param dynFilesSC
     * @return
     * @throws BaseException
     * function called to return the details of the selected file
     */
    public DynFilesDetCO returnDynFilesDetails (DynFilesSC dynFilesSC) throws BaseException;
    
    /**
     * 
     * @param dynFilesCO
     * @param dynFilesSC
     * @param importFile
     * @return
     * @throws BaseException
     * function called to import a file and display the rows on the screen
     */
    public DynFilesImportCO processDynFilesImportView (DynFilesDetCO dynFilesDetCO, DynFilesSC dynFilesSC, byte[] importFile) throws BaseException;
    
    /**
     * 
     * @param dynFilesSC
     * @return
     * @throws BaseException
     * function called to retrieve the statements when clicking on a row inside the grid
     * of rows already in the grid
     */
    public ArrayList<DF_DATA_IMPORT_TMPVO> returnInsertStatement(DynFilesSC dynFilesSC) throws BaseException;
    
    /**
     * 
     * @param dynFilesSC
     * @return
     * @throws BaseException
     * below method retrieves a range of rows to be displayed in the grid
     */
    public DynFilesImportCO returnRowsToGrid(DynFilesSC dynFilesSC) throws BaseException;
    
    /**
     * 
     * @param dynFilesSC
     * @param dynFilesDetCO
     * @return
     * @throws BaseException
     * in case there was an error in one of the statements in the file, the user can
     * either choose to ignore the errors and continue anyways, where this method
     * will be called, or stop execution
     */
    public DynFilesImportCO continueExecuting (DynFilesSC dynFilesSC, DynFilesDetCO dynFilesDetCO) throws BaseException;
    
    /**
     * 
     * @param dynFilesSC
     * @param dynFilesDetCO
     * @throws BaseException
     * below method is called when Run Script is clicked to execute procedures and scripts
     */
    public void runExecuteScript (DynFilesSC dynFilesSC, DynFilesDetCO dynFilesDetCO,byte[] importFile) throws BaseException;
    
    /**
     * 
     * @param dynFilesSC
     * @return
     * @throws BaseException
     * below method checks if the file Code entered by the user is valid or not
     */
    public DynFilesDetCO checkDynFilesFileCode(DynFilesSC dynFilesSC) throws BaseException  ;
    
    /**
     * 
     * @param dynFilesSC
     * @return
     * @throws BaseException
     * below method saves all the statements and send them to the interface as byte array 
     */
    public byte[] saveScript(DynFilesSC dynFilesSC) throws BaseException;
    
    /**
     * 
     * @param dynFilesSC
     * @return
     * @throws BaseException
     * method returns the count of all rows for a specific user id and file code
     */
    public Integer returnDynFilesRowsCount(DynFilesSC dynFilesSC) throws BaseException;
    
    /**
     * 
     * @param dynFilesSC
     * @return
     * @throws BaseException
     * method returns the log of all the executed statements
     */
    public byte[] saveExecutionLog(DynFilesSC dynFilesSC) throws BaseException;
    
    /**
     * 
     * @param dynFilesDetCO
     * @param dynFilesSC
     * @throws BaseException
     * method called when the Generate button is clicked to export a file
     * @throws Exception 
     */
    public byte[] processDynFilesGenerateExport(DynFilesDetCO dynFilesDetCO, DynFilesSC dynFilesSC) throws BaseException, Exception;
    
    /**
     * 
     * @param dynFilesDetCO
     * @param dynFilesSC
     * @return
     * @throws BaseException
     * method called to retrieve columns and rows to display the data of the batch processing screen
     * @throws Exception 
     */
    public DynFilesImportCO processDynFilesGenerateExportBatch(DynFilesDetCO dynFilesDetCO, DynFilesSC dynFilesSC) throws BaseException, Exception;

    /**
     * 
     * @param dynFilesSC
     * @param dfAllInputParam
     * @param sqlStatement
     * @param controlChar
     * @return
     * @throws BaseException
     * method called when executing Export Screen, returns the prepared SQL Statement
     * of the file code, where all parameters have been replaced and ready
     * for execution
     */
    public BigDecimal returnGeneratedSQLByFileCode(DynFilesSC dynFilesSC, Map<BigDecimal, DF_FILE_PARMVO> dfAllInputParam, StringBuffer sqlStatement) throws BaseException;
    
    /**
     * 
     * @param dynFilesSC
     * @param dfAllInputParam
     * @param sqlStatement
     * @return
     * @throws BaseException
     * below method retrieves the SQL Statement for the new column SOURCE_LST_SQL_NO
     */
    public String returnLSTSQLNoStatement(DynFilesSC dynFilesSC, Map<BigDecimal, DF_FILE_PARMVO> dfAllInputParam) throws BaseException;
    
    /**
     * 
     * @param columns
     * @param stringSQL
     * @param isDynFiles
     * below method retrieves the columns from the SELECT statement
     */
    public LinkedHashMap<String, BigDecimal> retrieveColumnsFromSelect(Map<String, BigDecimal> columns, String stringSQL, boolean isDynFiles, LinkedHashMap<String, BigDecimal> orderedColumns);
    
    /**
     * 
     * @param dynFilesSC
     * @return
     * @throws BaseException
     * method returns the values to be displayed when the user clicks on the live search
     * for a specific tag no
     */
    public ArrayList<DF_FILE_TAG_INP_PARAMVO> returnDynFilesTagDisplayValues(DynFilesSC dynFilesSC) throws BaseException;
    
    /**
     * 
     * @param dynFilesSc
     * @throws BaseException
     * method returns the tag value list
     */
    public ArrayList<DynFilesTagParametersCO> getDynFilesTagParameterValuesList(DynFilesSC dynFilesSc)throws BaseException;
    
    
    /**
     * 
     * @param dynFilesSC
     * @return
     * @throws DAOException
     */
    public DF_FILE_TAG_INP_PARAMVO getInputTagValues(DynFilesSC dynFilesSC) throws BaseException;
    
    /**
     * 
     * @param dynFilesSc
     * @throws BaseException
     * method returns the File Parameter List
     */
    public ArrayList<DF_FILE_PARMVO> returnDynFilesVisibleInputParameters(DynFilesSC dynFilesSC) throws BaseException ;
    
    /**
     * 
     * @param dynFilesSC
     * @return
     * @throws BaseException
     * method retrieves the SOURCE_LST_SQL_NO for a specifc tag
     */
    public BigDecimal returnDynFilesSourceLSTSQLNo(DynFilesSC dynFilesSC) throws BaseException;
    
    /**
     * selectDynamicFileInfo.
     * @param dynFilesSC
     * @return DynFilesCO
     * @throws DAOException
     */
    public DynFilesCO selectDynamicFileInfo(DynFilesSC dynFilesSC) throws DAOException;
    
    /**
     * 
     * @param dynFilesCOParams
     * @param dynFilesSC
     * @param fileName
     * @param fileLocation
     * @throws BaseException
     * set the parameters to the default values where they apply
     */
    public void setDefaultValues(ArrayList<DF_FILE_PARMVO> dfVisibleFileParmCO, DynFilesSC dynFilesSC, String fileName, String fileLocation, String fileExtension) throws BaseException;
    
    public void refreshDual() throws BaseException;
    
}
