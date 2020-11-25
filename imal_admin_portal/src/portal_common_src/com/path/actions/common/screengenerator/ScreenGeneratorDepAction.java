/**
 * 
 */
package com.path.actions.common.screengenerator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.dynamicscreen.DynamicScreenBO;
import com.path.bo.common.screengenerator.ScreenGeneratorBO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
import com.path.vo.common.dynlookup.DynCommonLookupSC;
import com.path.vo.common.screengenerator.DynButtonSourceCO;
import com.path.vo.common.screengenerator.DynScrTablesCO;
import com.path.vo.common.screengenerator.DynamicScreenCreatorCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * ScreenGeneratorDependencyAction.java used to
 */
public class ScreenGeneratorDepAction extends BaseAction
{
    private ScreenGeneratorSC criteria          = new ScreenGeneratorSC();
    private DynButtonSourceCO dynButtonSourceCO = new DynButtonSourceCO();
    private DynamicScreenCreatorCO dynScreenCreatorCO = new DynamicScreenCreatorCO();
    private DynScrTablesCO dynScrTablesCO = new DynScrTablesCO();
    private ScreenGeneratorBO screenGeneratorBO;
    private DynamicScreenBO dynamicScreenBO;
    /**
     * 
     * @author marwanmaddah
     * @date   Feb 19, 2016
     * @return String
     *
     */
    public String dependencyBySourceType()
    {
	try{
	    dynButtonSourceCO = screenGeneratorBO.changeLayoutBasedOnSourceType(dynButtonSourceCO);
	    getAdditionalScreenParams().putAll(dynButtonSourceCO.getDisplayHm());
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
    }
    /**
     * used to manage the dependency by mode type 
     * in the elements properties screen
     * @author marwanmaddah
     * @date   Mar 3, 2016
     * @return String
     *
     */
    public String dependencyByModeType()
    {
	try{
	    SYS_PARAM_SCREEN_DISPLAYVO nbFrmatterDisplayVO     = new SYS_PARAM_SCREEN_DISPLAYVO();
	    SYS_PARAM_SCREEN_DISPLAYVO zeroNotAllowedDisplayVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	    SYS_PARAM_SCREEN_DISPLAYVO negNotAllowedDisplayVO  = new SYS_PARAM_SCREEN_DISPLAYVO();
	    String nbFrmatterFieldId   = criteria.getElementId()+"_"+ConstantsCommon.PROPERTY_CODE_NBFRMTTER;
	    String zeroNtAlwdFieldId = criteria.getElementId()+"_"+ConstantsCommon.PROPERTY_CODE_NBZRONTALW;
	    String negNtAlwdFieldId  = criteria.getElementId()+"_"+ConstantsCommon.PROPERTY_CODE_NBNEGNTALW;
	    if(ConstantsCommon.ONE.equals(criteria.getModeType()))
	    {
		nbFrmatterDisplayVO.setELEMENT_ID(nbFrmatterFieldId);	    
		nbFrmatterDisplayVO.setIS_VISIBLE(BigDecimal.ZERO);
		nbFrmatterDisplayVO.setValue(BigDecimal.ZERO);
		
		zeroNotAllowedDisplayVO.setELEMENT_ID(zeroNtAlwdFieldId);	    
		zeroNotAllowedDisplayVO.setIS_VISIBLE(BigDecimal.ZERO);
		zeroNotAllowedDisplayVO.setValue(BigDecimal.ZERO);
		
		negNotAllowedDisplayVO.setELEMENT_ID(negNtAlwdFieldId);	    
		negNotAllowedDisplayVO.setIS_VISIBLE(BigDecimal.ZERO);
		negNotAllowedDisplayVO.setValue(BigDecimal.ZERO);
	    }
	    else
	    {
		nbFrmatterDisplayVO.setIS_VISIBLE(BigDecimal.ONE);		
		zeroNotAllowedDisplayVO.setIS_VISIBLE(BigDecimal.ONE);		
		negNotAllowedDisplayVO.setIS_VISIBLE(BigDecimal.ONE);		
	    }
	    getAdditionalScreenParams().put(nbFrmatterFieldId, nbFrmatterDisplayVO);
	    getAdditionalScreenParams().put(zeroNtAlwdFieldId, zeroNotAllowedDisplayVO);
	    getAdditionalScreenParams().put(negNtAlwdFieldId, negNotAllowedDisplayVO);
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
    }
    /**
     * 
     * @return
     */
    public String dependencyBtwnMinMaxDate()
    {
	try{
	    Date minDate = criteria.getMinDate();
	    Date maxDate = criteria.getMaxDate();
	    if(minDate!=null && maxDate!=null && minDate.compareTo(maxDate)>0)
	    {
		if(ConstantsCommon.PROPERTY_CODE_MINDATE.equals(criteria.getFromProp()))
		{
		    criteria.setMinDate(null);
		}
		else
		{
		    criteria.setMaxDate(null);
		}
		throw new BOException(MessageCodes.INVALID_DATE);
	    }	    
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
    }
    
    public String dateFormatValidation()
    {
	try{
	    String dateFormat = criteria.getDateFormat();
	    String ptrn = "^(D{1,4})*([\\s])*(M{1,4})*([\\s])*(YY|YYYY)*$|^(D{1,4})*([\\s])*(YY|YYYY)*([\\s])*(M{1,4})*$|^(M{1,4})*([\\s])*(D{1,4})*([\\s])*(YY|YYYY)*$|^(M{1,4})*([\\s])*(YY|YYYY)*([\\s])*(D{1,4})*$|^(YY|YYYY)*([\\s])*(M{1,4})*([\\s])*(D{1,4})*$|^(YY|YYYY)*([\\s])*(D{1,4})*([\\s])*(M{1,4})*$|^(D{1,4})*([\\s])*(M{1,4})*([\\s])*(YY|YYYY)*([\\s])(h|H{1,2})*([:])*(m{1,2})*([:])*(s{1,2})*([\\s](a|A))*([\\s](a|A)[\\s](Z))*$|^(D{1,4})*([\\s])*(YY|YYYY)*([\\s])*(M{1,4})*([\\s])(h|H{1,2})*([:])*(m{1,2})*([:])*(s{1,2})*([\\s](a|A))*([\\s](a|A)[\\s](Z))*$|^(M{1,4})*([\\s])*(D{1,4})*([\\s])*(YY|YYYY)*([\\s])(h|H{1,2})*([:])*(m{1,2})*([:])*(s{1,2})*([\\s](a|A))*([\\s](a|A)[\\s](Z))*$|^(M{1,4})*([\\s])*(YY|YYYY)*([\\s])*(D{1,4})*([\\s])(h|H{1,2})*([:])*(m{1,2})*([:])*(s{1,2})*([\\s](a|A))*([\\s](a|A)[\\s](Z))*$|^(YY|YYYY)*([\\s])*(M{1,4})*([\\s])*(D{1,4})*([\\s])(h|H{1,2})*([:])*(m{1,2})*([:])*(s{1,2})*([\\s](a|A))*([\\s](a|A)[\\s](Z))*$|^(YY|YYYY)*([\\s])*(D{1,4})*([\\s])*(M{1,4})*([\\s])(h|H{1,2})*([:])*(m{1,2})*([:])*(s{1,2})*([\\s](a|A))*([\\s](a|A)[\\s](Z))*$|^(h|H{0,2})*([:|\\s])*(m{1,2})*([:|\\s])*(s{1,2})*([\\s](a|A))*([\\s](a|A)[\\s](Z))*$";
	    if(!dateFormat.matches(ptrn))
	    {
		criteria = new ScreenGeneratorSC();
		throw new BOException(MessageCodes.MESSAGE_DYNAMIC_TITLE_BODY,new String[]{getText("error_key"),getText("invalid_date_format_key")});
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
    }
    /**
     * Used as a dummy dependency for the label key inside screen generator process
     * @return
     */
    public String dependencyByLabelKey()
    {
	return SUCCESS;
    }
//rabih
    public String scrTablesGridDep()
    {
	try{
	    //rabih add dependency on tables
	    //add warning message that all assigned relatedCol will be reset.
	    //if yes rest related cols
	    dynButtonSourceCO = screenGeneratorBO.changeLayoutBasedOnSourceType(dynButtonSourceCO);
	    getAdditionalScreenParams().putAll(dynButtonSourceCO.getDisplayHm());
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
    }
    
    public String scrColsGridDep()
    {
	try
	{
	    //Dependency for all lookups in dynamic screen
	    dynButtonSourceCO = screenGeneratorBO.changeLayoutBasedOnSourceType(dynButtonSourceCO);
	    getAdditionalScreenParams().putAll(dynButtonSourceCO.getDisplayHm());
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
    }
    public String scrTableGridDep()
    {
	try
	{
	    dynButtonSourceCO = screenGeneratorBO.changeLayoutBasedOnSourceType(dynButtonSourceCO);
	    getAdditionalScreenParams().putAll(dynButtonSourceCO.getDisplayHm());
	    //get tableName from DB along with the condition
	    DynCommonLookupSC dynSearchCriteria = new DynCommonLookupSC();
	    dynSearchCriteria.setElementId(criteria.getElementId());
	    dynSearchCriteria.setPropertyCode("tableName");
	    DynamicScreenCO dynScrCO  = dynamicScreenBO.returnelemPropertyDetails(dynSearchCriteria);
	    String tableName=null;
	    if(dynScrCO!=null)
	    {
		tableName = dynScrCO.getPropertyValue();
	    }
	    //if tableName select is similar to the one in DB then retrieve the condition From DB
	    if(StringUtil.nullToEmpty(tableName).equals(criteria.getTableName()))
	    {
		 dynSearchCriteria.setPropertyCode("retCond");
		 dynScrCO  = dynamicScreenBO.returnelemPropertyDetails(dynSearchCriteria);
		String retCond = dynScrCO.getPropertyExprValue();
		criteria.setQueryData(retCond);
	    }
	    else 
	    {
		// Remove Condition
		criteria.setQueryData("");
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
    }
    //rabih
    
    /**
     * Used as a  dependency for screen table in dynamic screen generator
     * @return
     */
    public String dependencyByScreenTable()
    {
    	try
    	{
    		ScreenGeneratorSC screenGeneratorSC = new ScreenGeneratorSC();
    		screenGeneratorSC.setTableId(dynScreenCreatorCO.getScrTableId());
    		dynScrTablesCO = screenGeneratorBO.returnScrTblInfo(screenGeneratorSC);
    		
    		HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> gridFlag = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
			
    		// enable-disable grid flag based if a dynamic table is selected
    		if (dynScrTablesCO == null) 
			{
				gridFlag = returnCommonLibBO().applyDynScreenDisplay("screenTableGridFlagId",
						"dynScreenCreatorCO.scrGridFlag", ConstantsCommon.ACTION_TYPE_READONLY, "1", gridFlag, null);
				gridFlag = returnCommonLibBO().applyDynScreenDisplay("screenTableGridFlagId",
						"dynScreenCreatorCO.scrGridFlag", ConstantsCommon.ACTION_TYPE_VALUE, "0", gridFlag, null);
				dynScrTablesCO= new DynScrTablesCO();
				dynScrTablesCO.setTABLE_TECH_NAME("");
				dynScrTablesCO.setTABLE_DESC("");
			} 
			else 
			{
				gridFlag = returnCommonLibBO().applyDynScreenDisplay("screenTableGridFlagId",
						"dynScreenCreatorCO.scrGridFlag", ConstantsCommon.ACTION_TYPE_READONLY, "0", gridFlag, null);
			}
    		
    	    getAdditionalScreenParams().putAll(gridFlag);

    	}
    	catch(Exception ex)
    	{
    	    handleException(ex,null,null);
    	}
    	return SUCCESS;
     }
    /**
     * 
     * @return
     */
    public String dependencyOnTagFlag()
    {
	try 
	{
	    SYS_PARAM_SCREEN_DISPLAYVO singleInputDisplayVO    = new SYS_PARAM_SCREEN_DISPLAYVO();
	    SYS_PARAM_SCREEN_DISPLAYVO autoSearchOnlyDiaplayVO = new SYS_PARAM_SCREEN_DISPLAYVO();
	    SYS_PARAM_SCREEN_DISPLAYVO queryDiaplayVO          = new SYS_PARAM_SCREEN_DISPLAYVO();
	    
	    String singleInputFieldId    = criteria.getElementId()+"_"+ConstantsCommon.PROPERTY_CODE_SINGLE_INPUT;
	    String autoSearchOnlyFieldId = criteria.getElementId()+"_"+ConstantsCommon.PROPERTY_CODE_AUTO_SEARCH_ONY;
	    String queryFieldId          = criteria.getElementId()+"_"+ConstantsCommon.PROPERTY_CODE_QUERY;
	    if(!BigDecimal.ONE.equals(criteria.getTagInput()))
	    {
		singleInputDisplayVO.setELEMENT_ID(singleInputFieldId);	    
		singleInputDisplayVO.setIS_VISIBLE(BigDecimal.ZERO);
		singleInputDisplayVO.setValue(BigDecimal.ZERO);
		
		autoSearchOnlyDiaplayVO.setELEMENT_ID(autoSearchOnlyFieldId);	    
		autoSearchOnlyDiaplayVO.setIS_VISIBLE(BigDecimal.ZERO);
		autoSearchOnlyDiaplayVO.setValue(BigDecimal.ZERO);
		
		queryDiaplayVO.setELEMENT_ID(queryFieldId);	    
		queryDiaplayVO.setIS_VISIBLE(BigDecimal.ZERO);
		queryDiaplayVO.setValue(BigDecimal.ZERO);
	    }
	    else
	    {
		singleInputDisplayVO.setELEMENT_ID(singleInputFieldId);	    
		singleInputDisplayVO.setIS_VISIBLE(BigDecimal.ONE);
		
		autoSearchOnlyDiaplayVO.setELEMENT_ID(autoSearchOnlyFieldId);	    
		autoSearchOnlyDiaplayVO.setIS_VISIBLE(BigDecimal.ONE);
		
		queryDiaplayVO.setELEMENT_ID(queryFieldId);	    
		queryDiaplayVO.setIS_VISIBLE(BigDecimal.ONE);
	    }
	    getAdditionalScreenParams().put(singleInputFieldId, singleInputDisplayVO);
	    getAdditionalScreenParams().put(autoSearchOnlyFieldId, autoSearchOnlyDiaplayVO);	    
	    getAdditionalScreenParams().put(queryFieldId, queryDiaplayVO);	    
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
    }
    /**
     * @return the criteria
     */
    public ScreenGeneratorSC getCriteria()
    {
        return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(ScreenGeneratorSC criteria)
    {
        this.criteria = criteria;
    }

    /**
     * @return the dynButtonSourceCO
     */
    public DynButtonSourceCO getDynButtonSourceCO()
    {
        return dynButtonSourceCO;
    }

    /**
     * @param dynButtonSourceCO the dynButtonSourceCO to set
     */
    public void setDynButtonSourceCO(DynButtonSourceCO dynButtonSourceCO)
    {
        this.dynButtonSourceCO = dynButtonSourceCO;
    }

    /**
     * @param screenGeneratorBO the screenGeneratorBO to set
     */
    public void setScreenGeneratorBO(ScreenGeneratorBO screenGeneratorBO)
    {
	this.screenGeneratorBO = screenGeneratorBO;
    }
    public DynamicScreenCreatorCO getDynScreenCreatorCO() {
	return dynScreenCreatorCO;
    }
    public void setDynScreenCreatorCO(DynamicScreenCreatorCO dynScreenCreatorCO) {
	this.dynScreenCreatorCO = dynScreenCreatorCO;
    }
    public DynScrTablesCO getDynScrTablesCO() {
	return dynScrTablesCO;
    }
    public void setDynScrTablesCO(DynScrTablesCO dynScrTablesCO) {
	this.dynScrTablesCO = dynScrTablesCO;
    }
    public DynamicScreenBO getDynamicScreenBO()
    {
	return dynamicScreenBO;
    }
    public void setDynamicScreenBO(DynamicScreenBO dynamicScreenBO)
    {
	this.dynamicScreenBO = dynamicScreenBO;
    }
  	/**
     * @author Muhammad.Asif
     * this method is used to load dependency on global activity selection   
     * @date   Jul 7, 2019
     * @return String
     */
	public String dependencyByGlobalActivityId()
    {
	try 
	{
		dynScreenCreatorCO = screenGeneratorBO.returnDependencyByGlobalActivityId(criteria);	      
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
    }
  	/**
     * @author Muhammad.Asif
     * this method is used to load dependency on operation selection   
     * @date   Jul 7, 2019
     * @return String
     */
	public String dependencyByRestOperationId()
    {
	try 
	{
		dynScreenCreatorCO = screenGeneratorBO.returnDependencyByRestOperationId(criteria);	      
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
    }
  	/**
     * @author Muhammad.Asif
     * this method is used to dependency of operation out parameter selection  
     * @date   Jul 7, 2019
     * @return String
     */
	public String dependencyByOperationOutParameter()
    {
	try 
	{
		dynScreenCreatorCO = screenGeneratorBO.returnDependencyByOperationOutParameter(criteria);	      
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
    }
}
