package com.path.bo.common.statuscustomization;

import java.util.List;

import com.path.dbmaps.vo.SYS_PARAM_LOV_TYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.statuscustomization.StatusCustomizationCO;
import com.path.vo.common.statuscustomization.StatusCustomizationSC;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * StatusCustomizationBO.java used to
 */
public interface StatusCustomizationBO 
{
    /**
     * used to return the status Customization list count 
     * @author marwanmaddah
     * @date   Sep 4, 2015
     * @param criteria
     * @return
     * @throws BaseException int
     *
     */
    public int statusCustCount(StatusCustomizationSC criteria) throws BaseException;
    /**
     * Used to return the Status Customization list  
     * @author marwanmaddah
     * @date   Sep 4, 2015
     * @param criteria
     * @return
     * @throws BaseException List<StatusCustomizationCO>
     *
     */
    public List<StatusCustomizationCO> statusCustList(StatusCustomizationSC criteria) throws BaseException;
    /**
     * Used to return the Count of the list that is related to the defined LOV Type
     * @author marwanmaddah
     * @date   Sep 4, 2015
     * @param criteria
     * @return
     * @throws BaseException int
     *
     */
    public int statusLookupLkpCount(StatusCustomizationSC criteria) throws BaseException;
    /**
     * used to Return the list of Status that are related to the defined LOV type
     * @author marwanmaddah
     * @date   Sep 4, 2015
     * @param criteria
     * @return
     * @throws BaseException List
     *
     */
    public List statusLookupLkpRecords(StatusCustomizationSC criteria) throws BaseException;
    /**
     * Used to save a new customization
     * @author marwanmaddah
     * @date   Sep 4, 2015
     * @param statusCustomizationCO
     * @throws BaseException void
     *
     */
    public void saveNew(StatusCustomizationCO statusCustomizationCO) throws BaseException;
    
    /**
     * Used to update the status selection
     * @author marwanmaddah
     * @date   Sep 30, 2015
     * @param statusCustomizationCO
     * @throws BaseException void
     *
     */
    public void update(StatusCustomizationCO statusCustomizationCO) throws BaseException;
    /**
     * 
     * @author marwanmaddah
     * @date   Sep 23, 2015
     * @param statusCustomizationCO
     * @throws BaseException void
     *
     */
    public void delete(StatusCustomizationCO statusCustomizationCO) throws BaseException;
    /**
     * used to return the status Customization data, based on the selected record from the Grid
     * @author marwanmaddah
     * @date   Sep 4, 2015
     * @param statusCustomizationCO
     * @return
     * @throws BaseException StatusCustomizationCO
     *
     */
    public StatusCustomizationCO returnStatusCustInfo(StatusCustomizationCO statusCustomizationCO) throws BaseException;
    /**
     * Used to return the needed List to load it inside the lov lookup 
     * @author marwanmaddah
     * @date   Sep 4, 2015
     * @param criteria
     * @return
     * @throws BaseException List
     *
     */
    public List statusLovLookupRecords(StatusCustomizationSC criteria) throws BaseException;
    /**
     * Used to return the Count of the LOV list
     * @author marwanmaddah
     * @date   Sep 4, 2015
     * @param criteria
     * @return
     * @throws BaseException int
     *
     */
    public int statusLovLookupCount(StatusCustomizationSC criteria) throws BaseException;
    /**
     * Used to return LOV object and fetch it on LOV dependency.
     * @author marwanmaddah
     * @date   Sep 4, 2015
     * @param statusCustomizationCO
     * @return
     * @throws BaseException SYS_PARAM_LOV_TYPEVO
     *
     */
    public SYS_PARAM_LOV_TYPEVO returnLovTypeObject(StatusCustomizationCO statusCustomizationCO) throws BaseException;
}