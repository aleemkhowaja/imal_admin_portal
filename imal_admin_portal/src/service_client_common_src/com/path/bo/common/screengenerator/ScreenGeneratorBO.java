package com.path.bo.common.screengenerator;

import java.util.List;

import com.path.dbmaps.vo.SYS_DYN_SCREEN_DEFVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.screengenerator.DynButtonSourceCO;
import com.path.vo.common.screengenerator.DynScrTableColsCO;
import com.path.vo.common.screengenerator.DynScrTablesCO;
import com.path.vo.common.screengenerator.DynamicScreenCreatorCO;
import com.path.vo.common.screengenerator.ElementPropertiesDetCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * ScreenGeneratorBO.java used to
 */
public interface ScreenGeneratorBO 
{
    public int  dynScreensListCount(ScreenGeneratorSC criteria) throws BaseException;
    public List<SYS_DYN_SCREEN_DEFVO> dynScreensList(ScreenGeneratorSC criteria) throws BaseException;
    public List<ElementPropertiesDetCO> returnElementPropDetails(ScreenGeneratorSC criteria) throws BaseException;
    public DynButtonSourceCO changeLayoutBasedOnSourceType(DynButtonSourceCO dynButtonSourceCO) throws BaseException;
    public int dynScrTablesListCount(ScreenGeneratorSC criteria) throws BaseException;
    public List<DynScrTableColsCO> dynScrTablesList(ScreenGeneratorSC criteria) throws BaseException;
    public int dynScrGeneratedTblListCount(ScreenGeneratorSC criteria) throws BaseException;
    public List<DynScrTablesCO> dynScrGeneratedTblList(ScreenGeneratorSC criteria) throws BaseException;
    public int dynScrGeneratedColListCount(ScreenGeneratorSC criteria) throws BaseException;
    public List<DynScrTablesCO> dynScrGeneratedColList(ScreenGeneratorSC criteria) throws BaseException;
    /**
     * return table id, tech name and desc related to dynamic table
     * @param  
     * @return BigDecimal
     * @throws BaseException
     */
    public DynScrTablesCO returnScrTblInfo(ScreenGeneratorSC screenGeneratorSC) throws BaseException;
    /**
     * return grid widget columns properties list count
     * @param  
     * @return BigDecimal
     * @throws BaseException
     */
    public int dynScrGridWidgetColsListCount(ScreenGeneratorSC criteria) throws BaseException;
    /**
     * return grid widget columns properties list
     * @param  
     * @return List<DynScrTablesCO>
     * @throws BaseException
     */
    public List<DynScrTableColsCO> dynScrGridWidgetColsList(ScreenGeneratorSC criteria) throws BaseException;
    
    /**
     * return list of records for global activity grid 
     * @param  ScreenGeneratorSC
     * @return List<DynamicScreenCreatorCO>
     * @throws BaseException
     */
    public List<DynamicScreenCreatorCO> loadGlobalActivityGrid(ScreenGeneratorSC criteria) throws BaseException;
    /**
     * return number of record for global activity grid 
     * @param  ScreenGeneratorSC
     * @return int
     * @throws BaseException
     */
    public int loadGlobalActivityGridCount(ScreenGeneratorSC criteria) throws BaseException;
    /**
     * return dependency on global activity grid 
     * @param  ScreenGeneratorSC
     * @return DynamicScreenCreatorCO
     * @throws BaseException
     */
	public DynamicScreenCreatorCO returnDependencyByGlobalActivityId(ScreenGeneratorSC criteria) throws BaseException;
	   /**
     * return number of record for rest operation grid  
     * @param  ScreenGeneratorSC
     * @return int 
     * @throws BaseException
     */
	public int loadRestOperationCount(ScreenGeneratorSC criteria) throws BaseException;
	/**
     * return list of record for Rest operation grid 
     * @param  ScreenGeneratorSC
     * @return List<DynamicScreenCreatorCO>
     * @throws BaseException
     */
	public List<DynamicScreenCreatorCO> loadRestOperation(ScreenGeneratorSC criteria) throws BaseException;
	/**
     * return number of record for Rest out parameter grid 
     * @param  ScreenGeneratorSC
     * @return int
     * @throws BaseException
     */
	public int loadOperationOutParameterCount(ScreenGeneratorSC criteria) throws BaseException;
	/**
     * return list of record for Rest out parameter grid 
     * @param  ScreenGeneratorSC
     * @return List<DynamicScreenCreatorCO>
     * @throws BaseException
     */
	public List<DynamicScreenCreatorCO> loadOperationOutParameter(ScreenGeneratorSC criteria) throws BaseException;
	/**
     * return dependency on Rest operation grid 
     * @param  ScreenGeneratorSC
     * @return DynamicScreenCreatorCO
     * @throws BaseException
     */
	public DynamicScreenCreatorCO returnDependencyByRestOperationId(ScreenGeneratorSC criteria) throws BaseException;
	/**
     * return dependency on Rest out parameter grid 
     * @param  ScreenGeneratorSC
     * @return DynamicScreenCreatorCO
     * @throws BaseException
     */
	public DynamicScreenCreatorCO returnDependencyByOperationOutParameter(ScreenGeneratorSC criteria) throws BaseException;

}