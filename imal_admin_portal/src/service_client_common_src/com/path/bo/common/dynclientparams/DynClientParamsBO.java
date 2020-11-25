/**
 * 
 */
package com.path.bo.common.dynclientparams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.SYS_DYN_PARAM_GROUPSVO;
import com.path.dbmaps.vo.SYS_DYN_PARAM_TABLESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.dynclientparams.DynClientParamsCO;
import com.path.vo.common.dynclientparams.DynClientParamsSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: rabihelkhatib
 * 
 *          TranslationBO.java used to declare the Dynamic Client's Params screen business
 *          methods
 */
public interface DynClientParamsBO 
{
    /**
     * Method to fill the Groups' Grid
     * 
     * @param DynClientParamsSC
     * @throws BaseException
     * @return ArrayList<SYS_DYN_PARAM_GROUPSVO>
     */
    public ArrayList<SYS_DYN_PARAM_GROUPSVO> selectGroupsList(DynClientParamsSC dynClientParamsSC) throws BaseException;

    /**
     * Method to return the Groups' count
     * 
     * @param DynClientParamsSC
     * @throws BaseException
     * @return int
     */
    public int selectGroupsListCount(DynClientParamsSC dynClientParamsSC) throws BaseException;
    
    /**
     * Method to fetch the Tables' Grid
     * 
     * @param DynClientParamsSC
     * @throws BaseException
     * @return ArrayList<SYS_DYN_PARAM_TABLESVO>
     */
    public ArrayList<SYS_DYN_PARAM_TABLESVO> selectTablesList(DynClientParamsSC dynClientParamsSC) throws BaseException;

    /**
     * Method to return the Tables' count
     * 
     * @param DynClientParamsSC
     * @throws BaseException
     * @return int
     */
    public int selectTablesListCount(DynClientParamsSC dynClientParamsSC) throws BaseException;
    
    /**
     * Returns Count of columns of the selected table
     * @param dynClientParamsSC
     * @return
     * @throws BaseException
     */
    public int selectColumnsListCount(DynClientParamsSC dynClientParamsSC) throws BaseException;
    
    /**
     * Returns list of columns of the selected table
     * @param dynClientParamsSC
     * @return ArrayList<DynClientParamsCO>
     * @throws BaseException
     */
    public ArrayList<DynClientParamsCO> selectColumnsList(DynClientParamsSC dynClientParamsSC) throws BaseException;

    /**
     * Returns the list of records found in the selected table
     * @param dynClientParamsSC
     * @return List<Object>
     * @throws BaseException
     */
    public List<Object> returnDynClientParamsQueryList(DynClientParamsSC dynClientParamsSC) throws BaseException;
    
    /**
     * Returns the count of records found in the selected table
     * @param dynClientParamsSC
     * @return List<Object>
     * @throws BaseException
     */
    public int returnDynClientParamsQueryListCount(DynClientParamsSC dynClientParamsSC) throws BaseException;

    /**
     * Returns columns information (type, size, nullable)
     * @param tableName
     * @return HashMap<String, String[]>
     * @throws BaseException
     */
    public HashMap<String, String[]> returnColumnsInfo(String tableName) throws BaseException;

    /**
     * Returns the dynamic client parameters form items data values.
     * @param dynClientParamsSC
     * @return HashMap<String, Object>
     * @throws BaseException
     */
    public HashMap<String, Object> returnDynClientParamsFormData(DynClientParamsSC dynClientParamsSC) throws BaseException;
    
    /**
     * Returns a comma separated String of COlumns names.
     * @param colsList
     * @return String
     * @throws BaseException
     */
    public String returnColsNames(ArrayList<DynClientParamsCO> colsList) throws BaseException;
    
    /**
     * Update (Add/Modify/Delete/Approve) the  currently selected table data.
     * @param dynClientParamsSC
     * @throws BaseException
     */
    public void updateDynClientParams(DynClientParamsSC dynClientParamsSC) throws BaseException;
    
    /**
     * Returns the columns names of a lookUpExpression as a comma separated String
     * @param theQuery
     * @return String
     * @throws BaseException
     */
    public String returnLookupColsNames(String theQuery) throws BaseException;
    
    /**
     * Returns the DB table ID
     * @param tableName
     * @return
     * @throws BaseException
     */
    public String returnTableID(DynClientParamsSC dynClientParamsSC) throws BaseException;
    
    /**
     * Save the columns add/delete/modify operations on the created INT_PARAM_... tables
     * @param DynClientParamsSC
     * @throws BaseException
     */
    public void saveDynClientParamsTblsColumns(DynClientParamsSC dynClientParamsSC) throws BaseException;
    
    /**
     * Evaluates the lookupExpressions to the specified criteria
     * @param dynClientParamsSC
     * @return
     * @throws BaseException
     */
    public List<Object> evaluateLookupExpression(DynClientParamsSC dynClientParamsSC) throws BaseException;
}
