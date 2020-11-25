package com.path.bo.common.customization;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.customization.BusTransCO;
import com.path.vo.common.customization.BusTransSC;
import com.path.vo.common.customization.CustomElementActivitiesSC;
import com.path.vo.common.customization.CustomizationCO;
import com.path.vo.common.customization.CustomizationSC;
import com.path.vo.common.customization.SavedAsScreensCO;
import com.path.vo.common.customization.button.SysParamGlobalActArgMapSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: deniskhaddad
 * 
 *          CustomizationBO.java used to Call needed Method For Sreen
 *          Customization
 */
public interface CustomizationBO
{
    /**
     * used to reject the changes on approve process.
     * @param custCO
     * @throws BaseException
     */
    public void rejectChanges(CustomizationCO custCO) throws BaseException;
    /**
     * 
     * Used for returning Customization CO Object
     * 
     * @param reqSc
     * @return
     * @throws BOException
     */
    public CustomizationCO returnElemCustomization(RequiredFieldsSC reqSc) throws BaseException;

    /**
     * 
     * Used for updating the details of Customization Object
     * 
     * @param custCO
     * @throws BOException
     */
    public void updateElemCustomization(CustomizationCO custCO) throws BaseException;

    /**
     * 
     * Used for returning list of Business Translation
     * 
     * @param busTransSC
     * @return
     * @throws BaseException
     */
    public List<BusTransCO> returnBusTranList(BusTransSC busTransSC) throws BaseException;
    /**
     * 
     * Used for returning the SQL of the Customization Specifications
     * 
     * @param custCO
     * @return
     * @throws BaseException
     */
    public String returnCustSQL(CustomizationCO custCO) throws BaseException;
    /**
     * 
     * Used for resetting the details of Customisation Object
     * 
     * @param custCO
     * @throws BOException
     */
    public void resetElemCustomization(CustomizationCO custCO) throws BaseException;
    /**
     * Method used to check whether the expression is correct
     * 
     * @param exprBoolSyntax
     */
    void checkExpression(String exprBoolSyntax,RequiredFieldsSC reqSc) throws BaseException;
    /**
     * Method to save as the selected screen.
     * @param custCO
     * @return 
     */
    public CustomizationCO updateSaveAsChanges(CustomizationCO custCO) throws BaseException;

    /**
     * returns if this opt is within the list of excluded opts 
     * @param sc
     * @throws BaseException
     */
    void checkAllowDuplicate(CommonLibSC sc)throws BaseException;
    
    /**
     * returns count from opt_series 
     * @param sc
     * @return
     * @throws BaseException
     */
    String checkSaveAsSeries(CommonLibSC sc)throws BaseException;
    /**
     * 
     * @author marwanmaddah
     * @date   Sep 3, 2014
     * @param criteria
     * @return
     * @throws BaseException int
     *
     */
    public int returnSeriesOptsListCount(CustomizationSC criteria) throws BaseException;
    /**
     * 
     * @author marwanmaddah
     * @date   Sep 3, 2014
     * @param criteria
     * @return
     * @throws BaseException List
     *
     */
    public List returnSeriesOptsListRecords(CustomizationSC criteria) throws BaseException;
    
    /**
     * Returns the user's available printers' list.
     * @author RabihElKhatib
     * @date   March, 4, 2015
     * @param CustomizationSC
     * @return List
     * @throws BaseException
     *
     */
    public List loadUsrPrntrList(CustomizationSC criteria) throws BaseException;
    
    /**
     * returns all saved as screens
     * @author SimonRizkallah
     * @date   April, 11, 2016
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List returnSavedScreensList(CustomizationSC criteria) throws BaseException;

    /**
     * returns the count of all saved as screens
     * @author SimonRizkallah
     * @date   April, 11, 2016
     * @param CustomizationSC
     * @return int
     * @throws BaseException
     */    
    public int returnSavedScreensCount(CustomizationSC criteria) throws BaseException;

    /**
     * delete selected saved as screens
     * @author SimonRizkallah
     * @date   April, 11, 2016
     * @param lstDel
     * @return String
     * @throws BaseException
     */
    public String deleteSavedScreens(List<SavedAsScreensCO> lstDel) throws BaseException;

    public void deletePageRefScreen( String pageRef, String appName ) throws BaseException;

    
    /**
     * Return the screen/field customization as a comma separated StringBuffer
     * @param custSC
     * @return StringBuffer
     * @throws BaseException
     */
    public StringBuffer returnCustExp(CustomizationSC custSC) throws BaseException;
    
    /**
     * imports the exported customization screen/field from a CSV file.
     * @param custSC
     * @throws BaseException
     */
    public void importCustomization(CustomizationSC custSC) throws BaseException;
    
    /**
     * insert a new record in SYS_PARAM_SCREEN_DISPLAY and a record in FIELD_TECH_DETAILS if not already defined
     * @param customizationSC
     * @throws BaseException
     */
    public void insertCustomizationImport(CustomizationSC customizationSC)throws BaseException;
    
    /**
     * return list of custom element activities
     * @param customElementActivitiesSC
     * @return
     * @throws BaseException
     */
    public List<CustomElementActivitiesSC> returnElementActivitiesList(CustomElementActivitiesSC customElementActivitiesSC) throws BaseException;
    /**
     * return customActivities count
     * @param customElementActivitiesSC
     * @return
     * @throws BaseException
     */
    public int returnElementActivitiesCount(CustomElementActivitiesSC customElementActivitiesSC) throws BaseException;

    /**
     * delete activity element
     * @param criteria
     */
    public void deleteElementActivity(CustomElementActivitiesSC criteria) throws BaseException;
    
    /**
     * fill auto complete tags
     */
    public CustomElementActivitiesSC fillAutoCompleteTags(CustomElementActivitiesSC customElementActivitiesSC) throws BaseException;
    /**
     * fill auto complete tags
     * @param tags
     * @param criteria
     * @return
     * @throws BaseException
     */
    public String buildAutoCompleteTags(Map<String, Object> tags,RequiredFieldsSC criteria) throws BaseException;
    public int checkScreenDisplayMirData(CustomizationCO custCO) throws BaseException;
    public int checkTableAvailablity() throws BaseException;
    public List<String> saveCustomElement(CustomElementActivitiesSC customElementActivitiesSC, List<CustomElementActivitiesSC> customElementActivitiesSCList) throws BaseException;
    public void saveButtonCustParamMap(SysParamGlobalActArgMapSC buttonCustParamsMapSC, List<SysParamGlobalActArgMapSC> buttonCustParamsMapSCList) throws BaseException;
    /**
     * @description used to return field technical details from FIELD_TECH_DETAILS
     * 
     * @param reqSc
     * @return CustomizationCO
     * @throws BaseException
     */
    public CustomizationCO returnFldTechDetails(RequiredFieldsSC reqSc) throws BaseException;
    /**
     * @description used to save field technical details and return field identifier Id 
     * 
     * @param customizationCO
     * @return BigDecimal
     * @throws BaseException
     */
    public BigDecimal saveFldTechDetails(CustomizationCO customizationCO) throws BaseException;
}
