package com.path.bo.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.ACC_NV_CONTROLVO;
import com.path.dbmaps.vo.ACC_NV_CONTROLVOKey;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.BRANCHESVOKey;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIFVOKey;
import com.path.dbmaps.vo.CIVIL_CODESVO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.COUNTRIESVOKey;
import com.path.dbmaps.vo.CSM_CTRLVO;
import com.path.dbmaps.vo.CTSCITDET2VO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.CTSTRXTYPEVOKey;
import com.path.dbmaps.vo.CTS_EXCEPTIONS_TRACEVO;
import com.path.dbmaps.vo.CTS_REP_ARGVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.DEPARTMENTSVO;
import com.path.dbmaps.vo.DEPARTMENTSVOKey;
import com.path.dbmaps.vo.DIVISIONSVO;
import com.path.dbmaps.vo.DIVISIONSVOKey;
import com.path.dbmaps.vo.DMS_SEARCH_INDEXVO;
import com.path.dbmaps.vo.DMS_SEARCH_INDEX_HEADERVO;
import com.path.dbmaps.vo.DMS_USER_MAPVO;
import com.path.dbmaps.vo.FMSCTRLVO;
import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.dbmaps.vo.IISCTRLVO;
import com.path.dbmaps.vo.IRP_SESSION_ATTRIBUTESVO;
import com.path.dbmaps.vo.LOCVO;
import com.path.dbmaps.vo.OPTVO;
import com.path.dbmaps.vo.PMSCONTROL1VO;
import com.path.dbmaps.vo.PMSCONTROL1VOKey;
import com.path.dbmaps.vo.PMSCONTROLVO;
import com.path.dbmaps.vo.PMSCONTROLVOKey;
import com.path.dbmaps.vo.PTH_CTRL1VO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.dbmaps.vo.RIFCRTVO;
import com.path.dbmaps.vo.RIFPCTVO;
import com.path.dbmaps.vo.SWIFT_CONTROLVO;
import com.path.dbmaps.vo.SYS_PARAM_BTN_CUSTVO;
import com.path.dbmaps.vo.SYS_PARAM_LANGUAGESVO;
import com.path.dbmaps.vo.SYS_PARAM_OBJ_DETAILS_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_OBJ_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ELEMENTSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ENTITY_TYPEVO;
import com.path.dbmaps.vo.SYS_PARAM_USER_PREFERENCESVO;
import com.path.dbmaps.vo.S_APPLOGVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.dbmaps.vo.TFSCTRL1VO;
import com.path.dbmaps.vo.TFSCTRL1VOKey;
import com.path.dbmaps.vo.TFSCTRLVO;
import com.path.dbmaps.vo.TFSCTRLVOKey;
import com.path.dbmaps.vo.TRSCLASSVO;
import com.path.dbmaps.vo.USER_FAVORITESVO;
import com.path.dbmaps.vo.USRVO;
import com.path.dbmaps.vo.YRTVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.struts2.lib.common.BaseObject;
import com.path.struts2.lib.common.ConnectionCO;
import com.path.vo.admin.cif.CIFCO;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.common.ActiveTransCO;
import com.path.vo.common.AdditionalFlagsCO;
import com.path.vo.common.AmountCO;
import com.path.vo.common.BaseProcedureSC;
import com.path.vo.common.CheckRequiredCO;
import com.path.vo.common.CommonLibCO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.CurrElementExpressionsCO;
import com.path.vo.common.CurrencyToWordsCO;
import com.path.vo.common.DBSequenceSC;
import com.path.vo.common.DateParamSC;
import com.path.vo.common.FieldsBusTransCO;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.ScreenElementsMapCO;
import com.path.vo.common.additionalfield.AdditionalFieldCO;
import com.path.vo.common.additionalfield.AdditionalFieldSC;
import com.path.vo.common.customization.CustomElementActivitiesSC;
import com.path.vo.common.customization.button.ButtonCustomizationCO;
import com.path.vo.common.customization.button.ButtonCustomizationSC;
import com.path.vo.common.customization.button.ScreenElementCO;
import com.path.vo.common.customization.object.ObjectCustomizationSC;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapSC;
import com.path.vo.common.dynamicscreen.LinkDynScrTabCO;
import com.path.vo.common.email.MailCO;
import com.path.vo.common.email.MailServerCO;
import com.path.vo.common.integration.DmsRequestSC;
import com.path.vo.common.mandatorylanguage.MandatoryLanguage;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardSC;
import com.path.vo.common.trshijridetailcalendar.TrsHijriDetailCalendarSC;
import com.path.vo.common.yrt.YRTSC;
import com.path.vo.core.account.AccountCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cheque.ChequeSC;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.ctsreparg.CtsReportArgSC;
import com.path.vo.core.transfercash.TransferCashSC;

public interface CommonLibBO
{
    
    /**
     * return error message whether BO or DOA with verbose option and language provided
     * @param cause Exception thrown
     * @param language Language of message to be translated
     * @param verbose boolean to specify whether generic message to be displayed for no BOException
     * @return array containing message, title, SQL error code
     */
    String[] translateErrorMessage(Throwable cause, String language, boolean verbose);
    /**
     * method to translate the Exceptions thrown in the application
     * 
     * @param cause Exception Occurred
     * @return the translated Message
     */
    String[] translateErrorMessage(BaseException cause, String language);

    /**
     * returns the current DBMS if it is sybase then 1 otherwise 0
     */
    int returnIsSybase() throws BaseException;
    /**
     * returns the current DBMS if it is sybase then 1 otherwise 0 taken from different db
     */
    int returnIsSybase(BaseObject baseObj) throws BaseException;

    /**
     * 
     * @param code
     * @param language
     * @return
     * @throws BaseException
     */
    String returnTranslErrorMessage(Integer code, String language) throws BaseException;
    
    /**
     * This method is a wrapper method for private applyExpression method called from ServicesCommon.java
     * @param resultVO
     * @param criteria
     */
    SYS_PARAM_SCREEN_DISPLAYVO handleExpressions(SYS_PARAM_SCREEN_DISPLAYVO resultVO, RequiredFieldsSC criteria) throws BaseException;
    
    /**
     * 
     *  Used for returning Message given its code and list of Parameters
     * 
     * @param code Message Code
     * @param params List of Parameters, Should be passed translated if needed
     * @param language User Language
     * @return
     * @throws BaseException
     */
    String returnTranslErrorMessage(Integer code, String[] params ,String language) throws BaseException;
    /**
     * Added by Charbel Obeidi to be used in SwiftOutwardBOImpl. Used for returning Message given its code and list of Parameters
     * @param code
     * @param language
     * @return
     * @throws BaseException
     */
    String[] returnTranslMessage(Integer code, String language) throws BaseException;
    /**
     * 
     * Used for returning translation Message Only without the Code inside MEssage text
     * 
     * @param code
     * @param params
     * @param language
     * @return
     * @throws BaseException
     */
    String returnTranslMessageOnly(Integer code,String[] params , String language) throws BaseException;
    /**
     * 
     * Used for returning translation Message Only without the Code inside MEssage text
     * 
     * @param code
     * @param language
     * @return
     * @throws BaseException
     */
    String returnTranslMessageOnly(Integer code, String language) throws BaseException;
    /**
     * 
     * @param obj
     * @param colList
     * @return
     * @throws BaseException
     */
    List generateStatusList(Object obj, List<String> colList, SelectSC lovCriteria) throws BaseException;

    /**
     * 
     * Used for to return the system date with Time from the database
     * 
     * @return
     * @throws BaseException
     */
    Date returnSystemDateWithTime() throws BaseException;

    /**
     * 
     * Used for return the system date without Time from the database
     * 
     * @return
     * @throws BaseException
     */
    Date returnSystemDateNoTime() throws BaseException;

    /**
     * 
     * Used for set System Database Time to the given Date
     * 
     * @param dateToSetTime Date to which system Time to be set
     * @return
     * @throws BaseException
     */
    Date addSystemTimeToDate(Date dateToSetTime) throws BaseException;
/**
 * Used for returning Currency VO for given company and Currency From Cache if cache Enabled and already cashed else from database
 * CURRENCIESVOKey currKey
 * @return
 * @throws BaseException
 */
    CURRENCIESVO returnCurrency(CURRENCIESVOKey currKey) throws BaseException;
  
    /**
     * Used for returning Currency VO for given company and Currency From Cache for Omni Admin Module based on ETL table 
     * if cache Enabled and already cashed else from database
     * CURRENCIESVOKey currKey 
     * @return CURRENCIESVO but in fact is is the Table OC_ETL_CURRENCIES
     * @throws BaseException
     */
     CURRENCIESVO returnOmniETLCurrency(CURRENCIESVOKey currKey) throws BaseException;
    
    /**
     * Used for returning Branch VO for given company and branch code From Cache if cache Enabled and already cached else from database
     * CURRENCIESVOKey currKey
     * @return
     * @throws BaseException
     */
    BRANCHESVO returnBranch(BRANCHESVOKey branchKey) throws BaseException;
    
    /**
     * 
     * Used for returning Company VO  From Cache if cache Enabled and already cashed else from database
     * 
     * @param compVO COMPANIESVO where COMP_CODE property need to be set
     * @return
     * @throws BaseException
     */
    COMPANIESVO returnCompany(COMPANIESVO compVO) throws BaseException;
    /**
     * return Country VO from Cache
     * @param countryVO COUNTRIESVOKey where COMP_CODE and COUNTRY_CODE need to be set
     * @return COUNTRIESVO object related to requested Country.
     * @throws BaseException
     */
    COUNTRIESVO returnCountry(COUNTRIESVOKey countryVO) throws BaseException;
    /**
     * 
     * Used for returning Application VO  From Cache if cache Enabled and already cashed else from database
     * 
     * @param compCode
     * @param currCode
     * @return
     * @throws BaseException
     */
    S_APPVO returnApplication(S_APPVO sAppVO) throws BaseException;
    /**
     * 
     * Used for returning RIFCRT used for Exposure Currency  From Cache if cache Enabled and already cashed else from database
     * 
     * @param rifcrtVO
     * @return
     * @throws BaseException
     */
    RIFCRTVO returnRIFCRT(RIFCRTVO rifcrtVO) throws BaseException;

    /**
     * Method for returning General Ledger details from Cache if cached, base on
     * Company and GL Code parameters passed in genLedgerVO
     * 
     * @param genLedgerVO
     * @return
     * @throws BaseException
     */
    GEN_LEDGERVO returnGenralLegder(GEN_LEDGERVO genLedgerVO) throws BaseException;
    /**
     * Used for returning RIFATT (Account Type) From Cache if cache Enabled and already cached else from database
     * @param rifattVO
     * @return
     * @throws BaseException
     */
    RIFATTVO returnRIFATT(RIFATTVO rifattVO) throws BaseException;
    /**
     * returns the control record of SADS
     */
    PTH_CTRLVO returnPthCtrl() throws BaseException;
    /**
     * returns the control record of SADS taken from different DB
     */
    PTH_CTRLVO returnPthCtrl(CommonLibSC sc) throws BaseException;

    /**
     * returns the general control record
     */
    PTH_CTRL1VO returnPthCtrl1() throws BaseException;

    /**
     * Author: Denisk Haddad Function Name: returnCTSCTR Powerbuilder function:
     * f_get_ctsctr
     * 
     * @param companyCode COMPANY CODE
     * @param branchCode BRANCH CODE
     * @param trsType TRS TYPE
     * @param cbType CB TYPE
     * @param appName application Name calling the counter,used for tracing purpose
     * @param usrName user Name calling who need the counter,used for tracing purpose
     * @param progRef screen reference from which the counter is called,used for tracing purpose
     * @return next ctsctr counter value.
     */
    BigDecimal returnCTSCTR(BigDecimal companyCode, BigDecimal branchCode, String trsType, String cbType,
	    String appName, String userName, String progRef) throws BaseException; 
	    
    /**
     * return next value of counter table after locking the table, based on
     * company code, branch code and transaction type
     * 
     * @param companyCode COMPANY CODE
     * @param branchCode BRANCH CODE
     * @param trxType
     * @param appName application Name calling the counter,used for tracing purpose
     * @param usrName user Name calling who need the counter,used for tracing purpose
     * @param progRef screen reference from which the counter is called,used for tracing purpose
     * @return next counter value
     */
    public BigDecimal returnCOUNTER(BigDecimal companyCode, BigDecimal branchCode, BigDecimal trxType, String appName,
	    String userName, String progRef) throws BaseException;

    /**
     * method that returns counter for IBISCOUNTER Table according to give
     * Company , Branch and Transaction Type
     * 
     * @param companyCode company Code of the counter
     * @param branchCode branch Code of the counter
     * @param trxType transaction Type of the counter
     * @param appName application Name calling the counter,used for tracing purpose
     * @param usrName user Name calling who need the counter,used for tracing purpose
     * @param progRef screen reference from which the counter is called,used for tracing purpose
     * @return next counter value
     * @throws BaseException
     */
    BigDecimal returnIBISCOUNTER(BigDecimal companyCode, BigDecimal branchCode, String trxType,String appName,String userName, String progRef)
	    throws BaseException;

    /**
     * Fill CTSCONTROL control record details for RET
     * 
     * @param ctsControlVO
     * @return
     * @throws BaseException
     */
    CTSCONTROLVO returnCtsControlDetails(CTSCONTROLVO ctsControlVO) throws BaseException;
    
    /**
     * @author elieachkar
     * @param compCode
     * @param branchCode
     * @return
     * @throws BaseException
     * method to be called whenever CTSCONTROLVO data is needed
     */
    CTSCONTROLVO returnCTSCONTROLVO(BigDecimal compCode, BigDecimal branchCode) throws BaseException;
    /**
     * returns control record taken from different db
     * sc containing company,branch and connection object
     * @return
     * @throws BaseException
     */
    CTSCONTROLVO returnCTSCONTROLVO(CommonLibSC sc) throws BaseException;

    /**
     * Fill CIFCONTROL control record details for CIF
     * 
     * @param cifcontrolvo
     * @return
     * @throws BaseException
     */
    CIFCONTROLVO returnCifControlDetails(CIFCONTROLVO cifcontrolvo) throws BaseException;
    /**
     * Fill CTSTRXType control record details for CIF
     * 
     * @param ctsTrxTypevo CTSTRXTYPEVO having PK Filled
     * @return CTSTRXTYPEVO
     * @throws BaseException
     */
    public CTSTRXTYPEVO returnTrxType(CTSTRXTYPEVO ctsTrxTypevo) throws BaseException;
    /**
     * Method that returns Civil Code Object Cached
     * @param civilCodesVo CIVI_CODESVO Object should contain COMP_CODE and CIVIL_CODE
     * @return CIVIL_CODESVO from Cache if availble, or from DB
     * @throws BaseException
     */
    public CIVIL_CODESVO returnCivilCodes(CIVIL_CODESVO civilCodesVo) throws BaseException;


    /**
     * Fill CSM control record details for CSM_CTRL
     * 
     * @param csmControlvo
     * @return CSM_CTRLVO object with all details
     * @throws BaseException
     */
    CSM_CTRLVO returnCSMControlDetails(CSM_CTRLVO csmControlvo) throws BaseException;
    /**
     * 
     * Used for returning list of Values from LOV table for select Boxes
     * 
     * @param selectSC
     * @return
     * @throws BaseException
     */
    List<SelectCO> returnLOV(SelectSC selectSC) throws BaseException;

    /**
     * Performs checking for maker checker if the same
     * 
     * @param creator
     * @param modifier
     * @return
     * @throws BaseException
     */
    int validateMakerChecker(String creator, String modifier, String userID) throws BaseException;

    Object returnRequiredData(RequiredFieldsSC criteria) throws BaseException;

    Map<String, SelectCO> returnLOVMap(SelectSC selectSC) throws BaseException;

    CIFVO returnCIF(CifSC criteria) throws BaseException;
    
    CIFCO returnCIFInfo(CifSC criteria) throws BaseException;

    String returnSingleLOV(SelectSC selectSC) throws BaseException;

    void checkRequired(CheckRequiredCO requiredInfos) throws BaseException;
    public void checkRequired(CheckRequiredCO requiredInfos,AdditionalFlagsCO additionalFlagsCO) throws BaseException;
    /**
     * Method to perform CheckREquired and different Customization defined to the elements on given screen
     * @param requiredInfos toExcludeFromChecking
     * @param toExcludeFromChecking List of Element Names/ids to Exclude from validation
     * @param additionaListToCheck List of Additional Elements Names/Ids to validate as Mandatory
     * @throws BaseException
     */
    public void checkRequired(CheckRequiredCO requiredInfos,List<String> toExcludeFromChecking, String... additionaListToCheck) throws BaseException;
   /**
    * Method to perform CheckREquired and different Customization defined to the elements on given screen
    * @param requiredInfos Required CO object containing the details of the screen, application,Company, language
    * @param toExcludeFromChecking List of Element Names/ids to Exclude from validation
    * @throws BaseException
    */
    public void checkRequired(CheckRequiredCO requiredInfos,List<String> toExcludeFromChecking) throws BaseException;
    
    void checkRequired( HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm ,CheckRequiredCO requiredInfos) throws BaseException;
    public void checkRequired(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm, CheckRequiredCO requiredInfos,AdditionalFlagsCO additionalFlagsCO)
	    throws BaseException;
    /**
     * Method to perform CheckREquired and different Customization defined to the elements on given screen passed throughrequiredInfos
     * parameter  with adding element available in hm parameter to the checking
     * @param hm additional Elements to be verified
     * @param requiredInfos Required CO object containing the details of the screen, application,Company, language
     * @param excludedCOsList List of Element Names/ids to Exclude from validation
     * @throws BaseException
     */
    public void checkRequired(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm, CheckRequiredCO requiredInfos,List<String> excludedCOsList)
	    throws BaseException;
    /**
     * Method to perform CheckREquired and different Customization defined to the elements on given screen passed throughrequiredInfos
     * parameter  with adding element available in hm parameter to the checking
     * @param hm additional Elements to be verified
     * @param requiredInfos Required CO object containing the details of the screen, application,Company, language
     * @param excludedCOsList List of Element Names/ids to Exclude from validation
     * @param additionalListToCheck List of Additional Elements Names/Ids to validate as Mandatory
     * @throws BaseException
     */
    public void checkRequired(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm, CheckRequiredCO requiredInfos,
	    List<String> excludedCOsList, String... additionalListToCheck) throws BaseException;
    /**
     * Method to perform CheckREquired and different Customization defined to the elements on given screen passed throughrequiredInfos
     * parameter  with adding element available in hm parameter to the checking
     * @param hm additional Elements to be verified
     * @param requiredInfos Required CO object containing the details of the screen, application,Company, language
     * @param additionalFlagsCO Additional Flags CO object that could contain applyExpression boolean flag
     * @param excludedCOsList List of Element Names/ids to Exclude from validation
     * @param additionalListToCheck List of Additional Elements Names/Ids to validate as Mandatory
     * @throws BaseException
     */
    public void checkRequired(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm, CheckRequiredCO requiredInfos,
	    AdditionalFlagsCO additionalFlagsCO,List<String> excludedCOsList, String... additionalListToCheck) throws BaseException;

    /**
     * Returns the Fiscal Year details
     * 
     * @param yrtSC
     * @return
     * @throws BaseException
     */
    YRTVO returnYrtDetails(YRTSC yrtSC) throws BaseException;

    /**
     * Returns the logged in Company Details
     * 
     * @param companiesVO
     * @return
     * @throws BaseException
     */
    COMPANIESVO returnLoggedCompanyDetails(COMPANIESVO companiesVO) throws BaseException;
    
     void updateAccountsDetails(AccountCO accountCO)throws BaseException;
   /**
    * This function is common general function to get information from AMF :
    * 
    * used to validate and get information based on criteria.
    * @param criteria
    * @return
    * @throws BaseException
    */
    AMFVO checkAccountValidation(AccountSC criteria) throws BaseException;
    /*
     * //This Function Return the language of the Client, in order to show or hide arabic data
        // 0 null = Both Arabic and English, nothing is mandatory
        // 1 = Only English without Arabic
        // 2 = both visible, arabic is mandatory
        // 3 = Only Arabic without Eng, and Arabic Mand.
       
     */
    String returnArabicVisiblityLanguage(PTH_CTRLVO pthCtrlVO) throws BaseException;
   
  
    /**
     * returnRIFATTInfo.
     * @param rifAttVO
     * @return RIFATTVO
     * @throws BaseException
     */
    RIFATTVO returnRIFATTInfo(RIFATTVO rifAttVO) throws BaseException;
  //This Function Return 3 values
   // 1-language of the Client,
   // 2-englishMandatory(true or false)
    //3-arabicDescriptionVisible(the arabic description visible or not)
    
   
    MandatoryLanguage returnLanguagesMandatory(PTH_CTRLVO pthCtrlVO) throws BaseException;
    
    
    /**
     * Converts from Gregorian to Hijri Dates and vis versa depending on asInto (G = grego, H = hijri)
     * PB = f_convert_date_grego_hijiri
     * @param date
     * @param asInto
     * @return
     * @throws BaseException
     */
    String returnConvertDateGregoHijri(TrsHijriDetailCalendarSC hijriDetailCalendarSC) throws BaseException;
  
    /**
     * THIS FUNCTION TEST IF CHEQUE IS ALREADY DRAWN, RETURN 0 --> NON, RETURN 1 --> YES
     * PB = f_chq_already_drawn
     * @param chequeSC
     * @return
     * @throws BaseException
     */
    int chequeAlreadyDrawn(ChequeSC chequeSC) throws BaseException;
    

    /**
     * Returns the next working date by adding holidays to the From Date
     * @return
     */
    Date returnHolidayAddedNextWorkingDate(DateParamSC dateParamSC)throws BaseException;

    /**
     * THIS FUNCTION WILL RETURN THE STATUS LIST OF THE CHEQUEBOOK 
     * @param chequeSC
     * @return
     */
    List<String> getChequeBookStatus(ChequeSC chequeSC) throws BaseException;
    
     /****
     * Method for getting the next working day by checking companies,branches,countries holidays
     * @param dateParamSC
     * @return
     * @throws BaseException
     */
    Date getNextWrkingDate(DateParamSC dateParamSC)throws BaseException;
    
    /**
     * vipAlert
     * @param commonLibSC.
     * @return RIFPCTVO.
     * @throws BaseException
     */
    RIFPCTVO vipAlert(CommonLibSC commonLibSC)throws BaseException;

    /**
     * Get company extend flag
     * @param dateParamSC
     * @return
     * @throws BaseException
     */
    COMPANIESVO getCompanyExtendFlag(BigDecimal compCode)throws BaseException;
    
    /**
     * 
     * Used for clearing the objects from Cache, if null parameter passed all objects will be cleared 
     * otherwise specific object key will be cleared example currencies
     * 
     * @param specificKey clear specific Key
     * @throws BaseException
     */
    void clearCachedObject(String specificKey) throws BaseException;
    /**
     * 
     * Used for clearing Everything from Cache
     * 
     * @throws BaseException
     */
    void clearCache() throws BaseException;
    
    /**
     * 
     * Return the TFSCTRL1VO from cache if it is Enabled else it is being fetched from database
     * 
     * @param tfsctrl1vo TFSCTRL1VO
     * @return
     * @throws BaseException
     */
    TFSCTRL1VO returnTfsCtrl_1(TFSCTRL1VOKey tfsctrl1vo) throws BaseException;
    /**
     * 
     * Return the PMSCONTROL (Assets Control Record) from cache if it is Enabled else it is being fetched
     * from database
     * 
     * @param pmsCtrlvo PMSCONTROLVOKey
     * @return
     * @throws BaseException
     */
    PMSCONTROLVO returnPMSCtrl(PMSCONTROLVOKey pmsCtrlvo) throws BaseException;
    
    /**
     * 
     * Return the TFSCTRL1VO (Assets Control Record 1) from cache if it is Enabled else it is being fetched from database
     * 
     * @param pmsCtrl1vo PMSCONTROL1VOKey
     * @return
     * @throws BaseException
     */
    PMSCONTROL1VO returnPMSCtrl_1(PMSCONTROL1VOKey pmsCtrl1vo) throws BaseException;
    /**
     * 
     * Return the TFSCTRLVO from cache if it is Enabled else it is being fetched
     * from database
     * 
     * @param tfsctrlvo TFSCTRLVO
     * @return
     * @throws BaseException
     */
    TFSCTRLVO returnTfsCtrl(TFSCTRLVOKey tfsctrlvo) throws BaseException;
    
    /**
     * Return the SWIFT_CONTROLVO from cache if it is Enabled, otherwise it will be fetched from database
     * @author CharbelObeidi
     * @return
     * @throws BaseException
     */
    SWIFT_CONTROLVO returnSwiftCtrlRecValues() throws BaseException;
    
    /**
     * This function will check if the date passed in parameter is a holiday in
     * a specified country. PB = f_check_holiday_country()
     * 
     * @author nabil feghali
     * @return -1 if the date is a holiday otherwise 1.
     * @throws BaseException
     */
    
    DateParamSC checkHolidayCountry(Date date, BigDecimal countryCode, BigDecimal companyCode, boolean withMessage) throws BaseException;
    
    /**
     * This function will check if the date passed in parameter is a holiday in
     * the specified branch. PB = f_check_holiday_comp_branch()
     * @author nabilfeghali
     * @param date
     * @param branchCode
     * @param companyCode
     * @param withMessage
     * @return -1 if the date is a holiday otherwise 1.
     * @throws BaseException
     */
    DateParamSC checkHolidayCompBranch(Date date, BigDecimal branchCode, BigDecimal companyCode, boolean withMessage) throws BaseException;
    
    
    /**
     * This function will check if the date passed in parameter is a holiday in
     * the specified branch. PB = f_check_holiday_comp_branch(). 
     * In case the passed checkType is "0" then the checking is done by comp and branch, 
     * if "1" then checking by company holiday only and if "2" then checking by branch holiday only. 
     * 
     * @author nabilfeghali
     * @param date
     * @param branchCode
     * @param companyCode
     * @param withMessage
     * @param checkType
     * @return DateParamSC or BOException in case the date is a holiday 
     * @throws BaseException
     */
    public DateParamSC checkHolidayCompBranch(Date date, BigDecimal branchCode, BigDecimal companyCode,
	    boolean withMessage, String checkType) throws BaseException;
    
    /****
     * Returns the ACC_NV_CONTROLVO from cache if it is Enabled  else it is being fetched from database
     * @param accNVCONTROLVOKey
     * @return
     * @throws BaseException
     */
    ACC_NV_CONTROLVO returnAccountNvCtrl(ACC_NV_CONTROLVOKey accNVCONTROLVOKey) throws BaseException;


    CTSTRXTYPEVO returnCtsTrxType(CTSTRXTYPEVOKey accNVCONTROLVOKey) throws BaseException;

    /**
     * Return Hash Map of SYS_PARAM_SCREEN_DISPLAYVO with label, and properties (visible, mandatory and read only) 
     * from SControl or JVType which used to manage the additional fields
     * @param additionalFieldSC
     * @return HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> 
     * @throws BaseException
     */
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> returnAdditionalFieldsParam(AdditionalFieldSC additionalFieldSC) throws BaseException;
    
    /**
     * Method to set the descriptions to lookup fields if value is in additionalFieldCO
     * @param additionalFieldCO
     * @param additionalFieldSC
     * @return AdditionalFieldCO
     * @throws BaseException
     */
    AdditionalFieldCO returnAdditionalFieldsDetails(AdditionalFieldCO additionalFieldCO, AdditionalFieldSC additionalFieldSC) throws BaseException;
 
    /****
     * Method to check passed access privileges is present for the user
     * @param privilegesToCheck
     * @param baseVO
     * @return privilegesPresents
     * @throws BaseException
     */
    List<String> checkAccessPrivilegeForUser(CommonLibSC criteria) throws BaseException;
    
    void checkRequired(CheckRequiredCO requiredInfos,String... additionaListToCheck) throws BaseException;
    public void checkRequired(CheckRequiredCO requiredInfos,AdditionalFlagsCO additionalFlagsCO,String... additionaListToCheck) throws BaseException;
    
    void checkRequired(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm , CheckRequiredCO requiredInfos, String... additionalListToCheck) throws BaseException;
    public void checkRequired(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm, CheckRequiredCO requiredInfos,AdditionalFlagsCO additionalFlagsCO,
	    String... additionalListToCheck) throws BaseException;
    
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> returnMapRequiredData(RequiredFieldsSC criteria)throws BaseException;
    /**
     * 
     * @author marwanmaddah
     * @date   Jan 4, 2013
     * @param criteria
     * @return
     * @throws BaseException SYS_PARAM_SCREEN_DISPLAYVO
     *
     */
    SYS_PARAM_SCREEN_DISPLAYVO returnParamScreenDisplay(RequiredFieldsSC criteria) throws BaseException;
    
	/****
	 * Method for validating the passed date with Running Date 
	 * @param dateToValidate
	 * @param runningDate
	 * @param validateMethod
	 * @return true if the checking passed all validation /Throws Exceptions : Less than Running Date, Greater than Running Date
	 * @throws BaseException
	 */
	Boolean validateDateWithRunningDate(Date dateToValidate,Date runningDate,String validateMethod) throws BaseException;
	
	/****
	 * Method for getting the record for the using application from S_APP table by passing APP_NAME
	 * @param sappVO
	 * @return
	 * @throws BaseException
	 */
	S_APPVO returnApplicationDetails(S_APPVO sappVO) throws BaseException;
	/**
	 * 
	 * Used for returning a map of Business Fields Translation
	 * 
	 * @param criteria Search Criteria by Application, OPT
	 * @return
	 * @throws BaseException
	 */
	Map<String,FieldsBusTransCO> returnFldBusinessTrans(RequiredFieldsSC criteria) throws BaseException;
	
	
	/**
	 * This function returns from cache the OPT details
	 * @param appName
	 * @param progRef
	 * @return
	 * @throws BaseException
	 */
	String[] returnOptDetailsList(String appName, String progRef) throws BaseException;
	/**
	 * 
	 * Used for returning all Languages for SYS_PARAM_LAnguages
	 * 
	 * @return
	 * @throws BaseException
	 */
	List<SYS_PARAM_LANGUAGESVO> returnLanguages(SelectSC sc)throws BaseException;
	/**
	 * MEthod to return Language Object based on it LANGUAGE CODE
	 * @param language language Code value
	 * @return Language VO Object
	 * @throws BaseException
	 */
	public SYS_PARAM_LANGUAGESVO returnLanguage(String language) throws BaseException;
	
	/**
	 * 
	 */
	SYS_PARAM_LANGUAGESVO returnDirection(SYS_PARAM_LANGUAGESVO sc)throws BaseException; 
	
	/**
	 * 
	 * Used for returning All applications in the System
	 * 
	 * @return
	 * @throws BaseException
	 */
	List<S_APPVO> returnAllApplications()throws BaseException;

    /**
     * 
     * Used for returning Sequence for Particular Sequence Name in Oracle or
     * Identity with Table Name in Sybase
     * 
     * @param dbSeqSC
     * @return
     * @throws BaseException
     */
    BigDecimal returnTableSequence(DBSequenceSC dbSeqSC) throws BaseException;	
	/****
	 * Method for getting the computed CV amount
	 * @param commonLibSC
	 * @return
	 * @throws BaseException
	 */
    AmountCO selectComputedCvAmount(AmountCO criteria)throws BaseException;
	/****
	 * Returns the opening balance amount from RIFATD. 
	 * @param accountSC
	 * @return
	 * @throws BaseException
	 */
	BigDecimal returnOpeningBalance(AccountSC accountSC)throws BaseException;
	/**
	 * 
	 * Used for returning CIF information for given CIF and Company
	 * 
	 * @param cifVOKey
	 * @return
	 * @throws BaseException
	 */
	CIFVO returnCIFVO(CIFVOKey cifVOKey) throws BaseException;

	/**
	 * return the country amount (balance) for use with the availment report 
	 * f_get_country_amt
	 * @param commonLibSC
	 * @return
	 * @throws BaseException
	 */
	BigDecimal returnCountryAmt(CommonLibSC commonLibSC) throws BaseException;
	/**
	 * Checks if the account is Unclaimed
	 * @param accountSC
	 * @return
	 * @throws BaseException
	 */
	BigDecimal checkUnclaimedAccount(AccountSC accountSC)throws BaseException;
	/**
	 * f_get_short_over
	 * @return
	 */
	BigDecimal returnShortOver(TransferCashSC transferCashSC)throws BaseException;

	/**
	 * f_get_one_obligor
	 * @param commonLibSC
	 * @param obligorLimit
	 * @return
	 * @throws BaseException
	 */
	BigDecimal returnOneObligor(CommonLibSC commonLibSC,BigDecimal obligorLimit)throws BaseException;
	/**
	 * f_get_cif_amt
	 * @param commonLibSC
	 * @return
	 * @throws BaseException
	 */
	BigDecimal returnCifAmt(CommonLibSC commonLibSC) throws BaseException;
	
	/**
	 * PB=f_checkaccess_without_message
	 * @param alertsSC
	 * @return
	 * @throws BaseException
	 */
	Integer checkAccessByProgRef(CommonLibSC commonLibSC) throws BaseException;
	
	
	
    /**
     * This function will check accounts Restrictions pbd :
     * f_check_acc_restrictions_new
     * 
     * @param accountSC
     * @throws BaseException
     */
    String returnProgRefToCheckAccRestrictions(AccountSC accountSC) throws BaseException;
	
	
    String returnKeyLabelTrans(CommonLibSC sc ) throws BaseException;
    
    /**
     * This method reads from SWIFT_PRINT_HDR table based on MODULE and PROG_REF fields 
     * @author CharbelObeidi
     * @param swiftOutwardSC
     * @return 0 in case no record found or a value greater than 0 in case records are found
     * @throws BaseException
     */
    Integer checkPrintSwiftAccess(SwiftOutwardSC swiftOutwardSC) throws BaseException;
    
    BigDecimal checkIrisWindow(BigDecimal cifNo, Boolean confirmFlag, String afterConfirm) throws BaseException;
    
    AmountCO selectComputedFCAmount(AmountCO criteria) throws BaseException;
    Integer validateConfirmationReport(BigDecimal reportId) throws BaseException;
    String createDynamicReportParams(CtsReportArgSC ctsReportArg, CTS_REP_ARGVO ctsRepArgVO) throws BaseException;
    CTS_EXCEPTIONS_TRACEVO addExceptionTrace(CTS_EXCEPTIONS_TRACEVO exceptionsTraceVO) throws BaseException;
    Map<BigDecimal,CtsReportArgSC> createMultiDynamicReportParams(Map<BigDecimal,CtsReportArgSC> ctsReportArgMap, BigDecimal compCode, List<CTS_REP_ARGVO> ctsRepArgVOList) throws BaseException;
    List<CTS_REP_ARGVO> returnCtsRepArgList(CtsReportArgSC ctsReportArgSC) throws BaseException;
    /**
     * this function add buisnes checking to the required list based on buis ness checking
     * @param elementName
     * @param propertyName
     * @param voName
     * @param labelKey
     * @param mandatoryValue
     * @param elementHashmap
     */
    void addBuisnesCheckingToRequired(String elementName,String propertyName,String voName,String labelKey,BigDecimal mandatoryValue,HashMap<String ,SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap);
    String checkUserPrivileges(CommonLibSC commonLibSC)throws BaseException;
    /**
     * 
     * Used for Parsing , Translating, and Executing PowerBuilder Expression.
     * 
     * @param expCode DW Expression Syntax
     * @param rowIndex row index of row whose expression to be calculated
     * @param allRows list of All Records.
     * @return
     */
    Object executeExpression(String expCode, int rowIndex, List<Map<String,Object>> allRows,RequiredFieldsSC criteria)throws BaseException;

    /**
     * 
     * Used for for Parsing , Translating, and Executing PowerBuilder
     * Expression.
     * 
     * @param expCode DW Expression Syntax
     * @param rowIndex row index of row whose expression to be calculated
     * @param allRows list of All Records List<Map> containing LinkedHashMap
     *            Entries.
     * @param serviceURL service URL RMI to call the functions in
     *            ExpressionGlobalMethodsBO if not mentioned then default
     *            Expression URL is taken form PathRemoting.properties having
     *            property Name expression.default.serviceURL
     * @return
     * @throws BaseException
     */
    Object executeExpression(String expCode,int rowIndex, List<Map<String,Object>> allRows, String serviceURL,RequiredFieldsSC criteria)throws BaseException;
    Object executeExpression(String expCode, int rowIndex, List<Map<String, Object>> allRows, String serviceURL)throws BaseException;
    Object executeExpression(String expCode, int rowIndex, List<Map<String, Object>> allRows)throws BaseException;

    /**
     * send mail management
     * @author marwanmaddah
     * @date   Aug 30, 2013
     * @param mailCO
     * @throws BaseException void
     *
     */
    void sendEmail(MailCO mailCO) throws BaseException;
    void sendEmail(List<MailCO> mailCOLst) throws BaseException;
    void sendEmail(MailCO mailCO,MailServerCO mailServerCO) throws BaseException;
    void sendEmail(List<MailCO> mailCOLst,MailServerCO mailServerCO) throws BaseException;
    HashMap<String, HashMap> returnAllKeyLabelTrans(String language, String appName, String progRef) throws BaseException;
    /**
     * Method returns Minimum Currency Code for given Company and Profit Group from CTSCITDET2
     * @param companyCode Company Code
     * @param profitGroup profit group Id
     * @return currency Code
     * @throws BaseException
     */
    BigDecimal returnCtsCitDet2Currency(BigDecimal companyCode, BigDecimal profitGroup)throws BaseException;
    /**
     * Method returns Minimum Currency Code for given Company and Profit Group from CTSCITDET2 with connection object set in vo
     * @param vo
     * @return
     * @throws BaseException
     */
    BigDecimal returnCtsCitDet2Currency(CTSCITDET2VO vo)throws BaseException;
    
    /**
     * Used for returning the session attribute list from db
     * @param sessionAttrVO
     * @author CharbelObeidi
     * @date   Dec 18, 2013
     * @throws BaseException
     */
    List<IRP_SESSION_ATTRIBUTESVO> returnSessionAttrList(IRP_SESSION_ATTRIBUTESVO sessionAttrVO) throws BaseException;
    /**
     * method that checks whether single user mode can be activated or not 
     * (PB method f_singleusermode_noapp CHECK case adjusted to be dynamic)
     * @param companyCode Company Code
     * @param userId User Id logged in to the application
     * @param branchCode Branch Code, can be null if checking not require company
     * @param appName application name to which the check to be perform, can be null so checkign will be regardless of application
     * @return 1 if the single user mode can be activated
     * @throws BaseException
     */
    int checkSingleUserMode(BigDecimal companyCode,String userId,BigDecimal branchCode, String appName) throws BaseException;
    /**
     * method that activate single user mode (PB method f_singleusermode_noapp SET case adjusted to be dynamic)
     * @param companyCode company code (Mandatory)
     * @param userId user ID performing the operation (Mandatory)
     * @param branchCode branch Code (Optional can be null)
     * @param appName application Name (Optional can be null)
     * @param machineIP machine IP performing the operation (optional) 
     * @return 1 if activated successfully
     * @throws BaseException
     */
    int activateSingleUserMode(BigDecimal companyCode,String userId,BigDecimal branchCode, String appName, String machineIP) throws BaseException;
    /**
     * method for deactivating single user mode, set all users to be Authorised, should be called after activateSingleUserMode
     *  (PB method f_singleusermode_noapp UNSET case adjusted to be dynamic)
     * @param companyCode company code (Mandatory)
     * @param userId user ID performing the operation (Mandatory)
     * @param branchCode branch Code (Optional can be null)
     * @param appName application Name (Optional can be null)
     * @return 1 if deactivated successfully
     * @throws BaseException
     */
    int deActivateSingleUserMode(BigDecimal companyCode,String userId,BigDecimal branchCode, String appName)throws BaseException;
    /**
     * activation process execution  (PB method f_check_process SET case adjusted to be dynamic)
     * @param companyCode company code (Mandatory)
     * @param userId user ID performing the operation (Mandatory)
     * @param processType type of the process Periodical or Posting ConstantCommon.PROCESS_PREIODICAL,  ConstantCommon.PROCESS_POSTING
     * @param branchCode branch Code (Optional can be null)
     * @param appName application Name of the process (Mandatory)
     * @return  1 if activated successfully
     * @throws BaseException
     */
    int activateProcessExec(BigDecimal companyCode, String userId, String processType, BigDecimal branchCode, String appName) throws BaseException;
    /**
     * de-activation process execution (PB method f_check_process SET case adjusted to be dynamic)
     * @param companyCode company code (Mandatory)
     * @param userId user ID performing the operation (Mandatory)
     * @param processType type of the process Periodical or Posting ConstantCommon.PROCESS_PREIODICAL,  ConstantCommon.PROCESS_POSTING
     * @param branchCode branch Code (Optional can be null)
     * @param appName application Name of the process (Mandatory)
     * @return  1 if activated successfully
     * @throws BaseException
     */
    int deActivateProcessExec(BigDecimal companyCode, String userId, String processType, BigDecimal branchCode,
	    String appName) throws BaseException;
    /**
     * Method that calls apply Dynamic Display Common processing to specify
     * needed action Type
     * 
     * @param elementId element ID to which actionType to be applied
     * @param elementName element Name to which actionType to be applied
     *            (elementId, and elementId both cannot be null)
     * @param actionType action to be applied (READONLY, MANDATORY, VISIBLE,...)
     *            ConstatntsCommon.ACTION_TYPE_...
     * @param value the value to be set (can be null), can be of Date or String data types
     * @param businessMapToApplyTo current business element HashMap
     * @param criteria in case value is null then the criteria should be specified to fetch the
     *            details from DB
     * @return businessMapToApplyTo HashMap filled with requested action type
     *         details
     * @throws BaseException
     */
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> applyDynScreenDisplay(String elementId, String elementName,
	    String actionType, Object value, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMapToApplyTo,
	    RequiredFieldsSC criteria) throws BaseException;
    /**
     * 
     * @author marwanmaddah
     * @date   Dec 16, 2015
     * @param elementId
     * @param elementName
     * @param actionType
     * @param value
     * @param businessMapToApplyTo
     * @param criteria
     * @param forceLoadFromDb
     * @return
     * @throws BaseException HashMap<String,SYS_PARAM_SCREEN_DISPLAYVO>
     *
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> applyDynScreenDisplay(String elementId, String elementName,
    	    String actionType, Object value, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMapToApplyTo,
    	    RequiredFieldsSC criteria,Boolean forceLoadFromDb) throws BaseException;
    /**
     * Method that calls apply Dynamic Display Common processing to specify
     * needed action Type on Array of provided Element Names or Ids
     * @param elementIdsOrNames array of provided names or ids to apply action on
      * @param actionType action to be applied (READONLY, MANDATORY, VISIBLE,...)
     *            ConstatntsCommon.ACTION_TYPE_...
     * @param value the value to be set (can be null), can be of Date or String data types
     * @param businessMapToApplyTo current business element HashMap
     * @param criteria in case value is null then the criteria should be specified to fetch the
     *            details from DB
     * @return businessMapToApplyTo HashMap filled with requested action type
     *         details
     * @throws BaseException
     */
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> applyDynScreenDisplay(String[] elementIdsOrNames,
	    String actionType, Object value, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMapToApplyTo,
	    RequiredFieldsSC criteria) throws BaseException;
    /**
     * 
     * This method has been added to cover the case where there is a need to  
     * send 2 list one for element ids and the second is for the element name
     * the 2 list should be compatible and in case there is mismatch between  
     * them and exception will be handled, and there is an additional argument 
     * 'forceLoadFromDb' which is have to be equals TRUE in case there is a 
     * need to load data from DB, so data will be loaded from DB in case there 
     * is no data sent in the business Hashmap related to the current element 
     * @author marwanmaddah
     * @date   Dec 16, 2015
     * @param elementIds
     * @param elementNames
     * @param actionType
     * @param value
     * @param theBusinessMapToApplyTo
     * @param criteria
     * @param forceLoadFromDb
     * @return
     * @throws BaseException HashMap<String,SYS_PARAM_SCREEN_DISPLAYVO>
     *
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> applyDynScreenDisplay(String[] elementIds,String[] elementNames,
		String actionType, Object value, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> theBusinessMapToApplyTo,
		RequiredFieldsSC criteria,Boolean forceLoadFromDb) throws BaseException;
    /**
     * f_set_teller_mask
     * chady - TAR BB120337
     * @param cardNum
     * @return String
     */
    String returnMaskedCardNo(CardsManagementCO cardsManagementCO) throws BaseException;
    
    /**
     * Used to do the opening branch Management 
     * @author marwanmaddah
     * @date   Jan 21, 2014
     * @param criteria
     * @throws BaseException void
     *
     */
    void openBranchMgnt(CommonLibSC criteria) throws BaseException;
    
    /**
     * used to do the open branch management 
     * @author marwanmaddah
     * @date   Feb 3, 2014
     * @param criteria
     * @throws BaseException void
     *
     */
    void openSessionMgnt(CommonLibSC criteria) throws BaseException;
    
    /**
     * used to do the final sign off management
     * @author marwanmaddah
     * @date   Feb 17, 2014
     * @param criteria
     * @throws BaseException void
     *
     */
    void branchSessionChecking(CommonLibSC criteria) throws BaseException;
    /**
     * 
     * @author marwanmaddah
     * @date   Feb 19, 2014
     * @param criteria
     * @throws BaseException void
     *
     */
    void switchCompanyBranchMgnt(CommonLibSC criteria) throws BaseException;

    /**
     * return favorite details based on favorite ID
     * @param favId favorite ID
     * @return
     * @throws BaseException
     */    
    USER_FAVORITESVO returnFavMenuApp(BigDecimal favId)throws BaseException;
    /**
     * Method that checks whether expression syntax is correct , throws Exception if not
     * @param expCode Expression Syntax
     * @return true is valid Expression
     * @throws BaseException
     */
    boolean checkExpressionSyntax(String expCode)throws BaseException;
    /**
     * Method used to return DB session details of current session
     * @return CO containing session ID and DB Node
     * @throws BaseException
     */
    CommonLibCO returnDBSessionDetails() throws BaseException;
    /**
     * returns list of companies/branches allowed per user
     * @param sc, user id
     * @return
     * @throws BaseException
     */
    List<LOCVO> returnUserCompanyBranch(CommonLibSC sc)throws BaseException;
    /**
     * Method used in IIS reports to return total amount of deals for specific CIF 
     * corresponds to PB Method f_get_mddr_utilized_iis_for_next (IIS Team: Fathima Reem Usman)
     * @param cifNo CIF Number Mandatory
     * @param runningDate Running Data (Optional)
     * @param branchCode Branch Code Mandatory
     * @param compCode Company Code Mandatory
     * @param baseCurrency Base Currency Code
     * @return total Amount of Deals 
     * @throws BaseException
     */
    BigDecimal returnMddrUtilizedIISForNext(BigDecimal cifNo, Date runningDate, BigDecimal branchCode,
	    BigDecimal compCode, BigDecimal baseCurrencyCode) throws BaseException;
    /**
     * Method used in IIS reports to return total amount of deals for specific CIF taken from different DB
     * @param cifNo CIF Number Mandatory
     * @param runningDate Running Data (Optional)
     * @param branchCode Branch Code Mandatory
     * @param compCode Company Code Mandatory
     * @param baseCurrency Base Currency Code
     * @param conn contains connection details
     * @return total Amount of Deals 
     * @throws BaseException
     */	    
    BigDecimal returnMddrUtilizedIISForNext(BigDecimal cifNo, Date runningDate, BigDecimal branchCode,
	    BigDecimal compCode, BigDecimal baseCurrencyCode, ConnectionCO conn) throws BaseException;
    /**
     * Method used in IIS reports to return total amount on specific date for specific CIF 
     * corresponds to PB Method f_get_mddr_utilized_report_iis(IIS Team: Fathima Reem Usman)
     * @param cifNo  CIF Number Mandatory
     * @param adtDate Date on which the amount to be returned
     * @param compCode  Company Code Mandatory
     * @param branchCode Branch Code Mandatory
     * @param runningDate Running Data (Optional)
     * @param baseCurrencyCode BaseCurrency Code (Optional)
     * @return
     * @throws BaseException
     */
    BigDecimal returnMddrUtilizedReportIIS(BigDecimal cifNo, Date adtDate, BigDecimal compCode,
	    BigDecimal branchCode, Date runningDate, BigDecimal baseCurrencyCode) throws BaseException;
    /**
     * Method used in IIS reports to return total amount on specific date for specific CIF  taken from different DB
     * @param cifNo  CIF Number Mandatory
     * @param adtDate Date on which the amount to be returned
     * @param compCode  Company Code Mandatory
     * @param branchCode Branch Code Mandatory
     * @param runningDate Running Data (Optional)
     * @param baseCurrencyCode BaseCurrency Code (Optional)
     * @param conn contains connection details
     * @return
     * @throws BaseException
     */	    
    BigDecimal returnMddrUtilizedReportIIS(BigDecimal cifNo, Date adtDate, BigDecimal compCode,
	    BigDecimal branchCode, Date runningDate, BigDecimal baseCurrencyCode, ConnectionCO conn) throws BaseException;
    /**
     * Method return IIS control details by company and Branch, Caching is applied
     * @param iisControlVO VO specifying Company and branch for which control record to return
     * @return IISCTRLVO
     * @throws BaseException
     */
    IISCTRLVO returnIISControlDetails(IISCTRLVO iisControlVO) throws BaseException;
    /**
     * Method return FMS control details by company and Branch, Caching is applied
     * @param fmsControlVO VO specifying Company and branch for which control record to return
     * @return FMSCTRLVO
     * @throws BaseException
     */
    FMSCTRLVO returnFMSControlDetails(FMSCTRLVO fmsControlVO) throws BaseException;
    /**
     * returns concatenated string of user profiles Ex prof1,Prof3,prof8...
     * @param commonLibSc
     * @return
     * @throws BaseException
     */
    String returnUserProfiles(CommonLibSC commonLibSc) throws BaseException;
    /**
     * returns result of SQL query which should be select query and not update/insert/delete
     * @param commonLibSc Object containing the SQL syntax in dynamicSQLSyntax property
     * @return first row of SQL result as Map object 
     * @throws BaseException Error in case the SQL syntax not starts with SELECT, or error in execution
     */
    Map<String, Object> returnSQLSyntaxResultFirstRow(CommonLibSC commonLibSc) throws BaseException;
    /**
     * Method that called in IIS report to convert to forex currency amount into Base currency amount
     * Based on PB method f_convert_to_cv (IIS Team: Fathima Reem Usman)
     * @param arAmount amount to convert
     * @param arFromcurr from currency code
     * @param arTocurr to currency code
     * @param arDate data of conversion
     * @param compCode company code
     * @param branchCode branch Code
     * @param baseCurrencyCode base Currency Code
     * @return converted amount
     * @throws BaseException
     */
    BigDecimal returnConvertToCvIIS(BigDecimal arAmount, BigDecimal arFromcurr, BigDecimal arTocurr,
	    Date arDate, BigDecimal compCode, BigDecimal branchCode, BigDecimal baseCurrencyCode)
	    throws BaseException;
     /**
     * Method that called in IIS report to convert to forex currency amount into Base currency amount taken from different DB
     * @param arAmount amount to convert
     * @param arFromcurr from currency code
     * @param arTocurr to currency code
     * @param arDate data of conversion
     * @param compCode company code
     * @param branchCode branch Code
     * @param baseCurrencyCode base Currency Code
     * @param conn contains connection details
     * @return converted amount
     * @throws BaseException
     */
    BigDecimal returnConvertToCvIIS(BigDecimal arAmount, BigDecimal arFromcurr, BigDecimal arTocurr,
	    Date arDate, BigDecimal compCode, BigDecimal branchCode, BigDecimal baseCurrencyCode, ConnectionCO conn)
    throws BaseException;
    /**
     * This method will add number of days to aDate and returns new
     * date, it will exclude the holidays.Based on IIS team request (IIS Team: Fathima Reem Usman)
     * @param alDays number of days to Add
     * @param aDate Date to add the days to
     * @param compCode Company Code
     * @param countryCode Country Code
     * @return New Date added the provided days and counting holidays
     * @throws BaseException
     */
    Date returnNextWorkingDayByCountry(BigDecimal alDays, Date aDate, BigDecimal compCode, BigDecimal countryCode)
	    throws BaseException;
    /**
     * This method will add number of days to aDate and returns new date, it will exclude the holidays (taken from different db)
     * @param alDays number of days to Add
     * @param aDate Date to add the days to
     * @param compCode Company Code
     * @param countryCode Country Code
     * @param conn contains connection details
     * @return New Date added the provided days and counting holidays
     * @throws BaseException
     */
    Date returnNextWorkingDayByCountry(BigDecimal alDays, Date aDate, BigDecimal compCode, BigDecimal countryCode,ConnectionCO conn)
    throws BaseException;
    /**
     * Used to return Opt Reference of the entered OPT 
     * @author marwanmaddah
     * @date   Mar 3, 2014
     * @param appName
     * @param theProgRef
     * @return
     * @throws BaseException String
     *
     */
    String returnOrginProgRef(String appName,String theProgRef) throws BaseException;
    /**
     * Used to process the closing of branch
     * @author RabihElKhatib
     * @date   Feb 03, 2014
     * @param criteria
     * @throws BaseException
     */
    void closeBranchMgnt(CommonLibSC criteria) throws BaseException;

    /**
     * Used to process the closing of session
     * @author RabihElKhatib
     * @date   Feb 11, 2014
     * @param criteria
     * @throws BaseException
     */
    ActiveTransCO closeSessionMgnt(CommonLibSC criteria) throws BaseException;
    
    /**
     * Used to check the CashBalances
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<UsrCO> unstldNotTransCashBalChecking(CommonLibSC criteria) throws BaseException;
    
    /**
     *  return cross rate of given from currency and to currency, running date, base currency 
     * @param compCode Company Code
     * @param fromCyCode from Currency Code
     * @param branchCode Branch Code
     * @param toCyCode to Currency Code
     * @param baseCurrencyCode Base Currency Code
     * @param runningDate Running Date
     * @return
     * @throws BaseException
     */
    BigDecimal returnCrossRate(BigDecimal compCode,BigDecimal fromCyCode, BigDecimal branchCode, BigDecimal toCyCode, BigDecimal baseCurrencyCode, Date runningDate)throws BaseException;
   /**
     *  return cross rate of given from currency and to currency, running date, base currency taken from different db
     * @param compCode Company Code
     * @param fromCyCode from Currency Code
     * @param branchCode Branch Code
     * @param toCyCode to Currency Code
     * @param baseCurrencyCode Base Currency Code
     * @param runningDate Running Date
     * @param conn contains connection details
     * @return
     * @throws BaseException
     */
    BigDecimal returnCrossRate(BigDecimal compCode,BigDecimal fromCyCode, BigDecimal branchCode, BigDecimal toCyCode, BigDecimal baseCurrencyCode, Date runningDate, ConnectionCO conn)throws BaseException;
    /**
     * Check user validity to open/close session/branch for CSM application.
     * @param cyCode
     * @param runningdate
     * @param decimalPoint
     * @return
     * @throws BaseException
     */
    public HashMap<String,String> checkUserValidity(CommonLibSC criteria) throws BaseException;
    
    /**
     * 
     * @author marwanmaddah
     * @date   Apr 8, 2014
     * @param sysParamScreenEntityTypeVO
     * @return
     * @throws BaseException SYS_PARAM_SCREEN_ENTITY_TYPEVO
     *
     */
    public List<SYS_PARAM_SCREEN_ENTITY_TYPEVO> returnEntityTypeInfos(SYS_PARAM_SCREEN_ENTITY_TYPEVO sysParamScreenEntityTypeVO) throws BaseException;

    /**
     * Method return department from Cache if exists given company code, devision code and department code inside
     * DEPARTMENTSVOKey
     * @param departmentKey DEPARTMENTSVO providing PK to retrieve department
     * @return
     * @throws BaseException
     */
    public DEPARTMENTSVO returnDepartment(DEPARTMENTSVOKey departmentKey) throws BaseException;
    /**
     * method that returns Division details for provided company and division code
     * @param divisionKey Object containing parameter for Company code and Division code
     * @return
     * @throws BaseException
     */
    public DIVISIONSVO returnDivision(DIVISIONSVOKey divisionKey) throws BaseException;
    /**
     * check if the web session Id is still available or not 
     * @author marwanmaddah
     * @date   Apr 23, 2014
     * @param sAppLogVO
     * @return
     * @throws BaseException Boolean
     *
     */
    public CommonLibCO checkHttpSession(S_APPLOGVO sAppLogVO) throws BaseException;
    /**
     * used to return data from OPT table by PK 
     * @author marwanmaddah
     * @date   May 28, 2014
     * @param criteria
     * @return
     * @throws BaseException OPTVO
     *
     */
    public OPTVO returnOptDetails(OPTVO optVO) throws BaseException;
    /**
     * Method that return Branch Manager details for given Company and Branch Code passed in cteTeller VO parameter
     * @param ctsTeller USRVO of branch Manager
     * @return
     */
    USRVO returnBranchManagerDetails(CTSTELLERVO ctsTeller) throws BaseException;
    
    /**
     * method that return the series prog ref by opt reference
     * @author nabil feghali
     * @param CommonLibSC
     * @return
     * @throws BaseException 
     *
     */
    public String returnSeriesOptByRef(CommonLibSC commonLibSc) throws BaseException;
    
    /**
     * method that return the Teller Details (same details of Logging Teller)
     * @param compCode
     * @param branchCode
     * @param userId
     * @return
     * @throws BaseException
     */
    public CTSTELLERVO returnCtsTellerDetails(BigDecimal compCode, BigDecimal branchCode, String userId) throws BaseException;
    
    /**
     * returns the help_path from OPT table
     * @param commonLibSc
     * @return
     * @throws BaseException
     */
    String returnHelpPathFromOpt(CommonLibSC commonLibSc) throws BaseException;
    /**
     * used to check if the selected running date is great than system date
     * in case is greater than , an exception will appear
     * @author marwanmaddah
     * @date   Sep 18, 2014
     * @param newRunningDate
     * @throws BaseException void
     *
     */
    public void checkRunningDate(Date newRunningDate) throws BaseException;
    /**
     * Used to save Grid Column index
     * @author marwanmaddah
     * @date   Oct 22, 2014 void
     *
     */
    public void saveGridColumnsOrder(CommonLibSC criteria) throws BaseException;
    /**
     * Used to return the User prefernces that are related to the current Grid 
     * based on Application , progRef, userId and Grid id
     * @author marwanmaddah
     * @date   Oct 23, 2014
     * @param criteria
     * @return
     * @throws BaseException SYS_ORDER_GRID_COLUMNSVO
     *
     */
    public SYS_PARAM_USER_PREFERENCESVO returnGridColumnsOrder(CommonLibSC criteria) throws BaseException;
    /**
     * Used to reset grid user Preferences
     * @author marwanmaddah
     * @date   Oct 29, 2014
     * @param criteria
     * @throws BaseException void
     *
     */
    public void resetGridColumnsOrder(CommonLibSC criteria) throws BaseException;
    /**
     * method to update log level at service layer
     * @param currLogLevel
     * @throws BaseException
     */
    void updateLogLevel(String currLogLevel) throws BaseException;
    
    /**
     * checks if the running date to be set has a corresponding fiscal year defined  
     * @param sc contains the company/branch/date/language
     * @throws BaseException	
     */
    void checkBackdatedTrx(BaseProcedureSC sc) throws BaseException;

    /**
     * returns for each language the convert_like_language 
     * @return
     * @throws BaseException
     */
    Map<String, String> returnConvertLikeLangMap(String langCode) throws BaseException;
    /**
     * return for specified language what is the conversion_method_id to be used
     * @param langCode
     * @return
     * @throws BaseException
     */
    String returnConversionMethodId(String langCode) throws BaseException;
    /**
     * returns currency names per language
     * @param langCode
     * @param vo
     * @return
     * @throws BaseException
     */
    CurrencyToWordsCO returnCurrencyToWordsCO(String langCode,CURRENCIESVO vo) throws BaseException;
    /**
     * returns numbers in words values for specified language
     * @param langCode
     * @return
     * @throws BaseException
     */
    HashMap<String, String[]> returnNumInWordsByLangDefaultMap(String langCode) throws BaseException;
    /**
     * Used to check if the report has arguments
     * in case it has the returned value will be greater than 0  
     * @author marwanmaddah
     * @date   Mar 25, 2015
     * @param criteria
     * @return
     * @throws BaseException int
     *
     */
    public int checkReportDisplayArgs(CommonLibSC criteria) throws BaseException;
    
    /**
     * This function is used to return all custom button VOs defined for a specific pageRef and a specific toolbarId.
     * In case the toolbarId is null, all the button added for this pageRef will be returned.
     * @param pageRef
     * @param toolbarId
     * @param appName
     * @return
     */
    public List<SYS_PARAM_BTN_CUSTVO> returnToolBarButtonCust(String pageRef, String toolbarId, String appName, Map<String,Map<String, Object>> variablesMap,Map<String,Object> elementObjList) throws BaseException;
    
    /**
     * This function will return all the mapping data for all the arguments of the custom buttons actions.
     * In case mapeType = 1 all the arguments mapped to the screen will be returned.
     * showArgDetails is a flag that extends the returned data to return more info
     * @param buttonCustomizationSC
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO returnButtonCustActionData(ButtonCustomizationSC buttonCustomizationSC) throws BaseException;
    
    /**
     * function that returns all the screen elements (instance of SYS_PARAM_SCREEN_ELEMENTSVO) used by the operations of the custom button
     * @param appName
     * @param progRef
     * @param idList
     * @return
     * @throws BaseException
     */
    public List<SYS_PARAM_SCREEN_ELEMENTSVO> returnButtonCustScreenElement(String appName, String progRef, List<BigDecimal> idList) throws BaseException;
    /**
     * Method that will return Array of Application Version of Service Wars.
     * @return Array Containing [APP_VERION, APP_INTERNAL Build]
     * @throws BaseException
     */
    public String[] returnServiceAppVersions() throws BaseException;
    /**
     * Used to return the Running date from an external source via a web services call.
     * @author marwanmaddah
     * @date   Oct 29, 2015
     * @param criteria
     * @return
     * @throws BaseException Date
     *
     */
    public Date returnExternalRunningDate(CommonLibSC criteria) throws BaseException;
    
    /**
     * used to apply the expressions
     * @author marwanmaddah
     * @date   Feb 17, 2016
     * @param resultVO
     * @param criteria
     * @return
     * @throws BaseException SYS_PARAM_SCREEN_DISPLAYVO
     *
     */
    public SYS_PARAM_SCREEN_DISPLAYVO applyExpression(SYS_PARAM_SCREEN_DISPLAYVO resultVO, RequiredFieldsSC criteria) throws BaseException;
    
    /**
     * Control Clustered operations to lock or synchronize a scheduled task
     * operationName is the name of the task to be controled
     * blocking when set to true the control will perform a pessimistic lock
     * else optimistic lock and returns boolean value to allow/stop runing a task.
     * 
     * @param operationName
     * @param blocking
     * @return boolean
     * @throws BaseException
     */
    public boolean clusterOperationControl(String operationName, boolean blocking) throws BaseException;
    //TP 773207
    /**
     * Method that will update the time in SYS_CLUSTER_OPERATION_CTRL, that could be used to identify which is the active server
     * @param operationName Operation name on which the time to be updated
     * @param timeDifference the milliseconds which to compare as difference between operation time and current time, if passed as null then value of property
     * global.cluster.timespan from PathService.properties will be considered.
     * @return true/ false whether the record is updated or not
     * @throws BaseException
     */
    public boolean clusterOperationControlTimeUpdate(String operationName, Long timeDifference) throws BaseException;
    /**
     * When using clusterOperationControl with blocking set to true
     * then this method must be called after the processing is complete
     * in order to release locked threads/sessions.
     * 
     * @param operationName
     * @return boolean
     * @throws BaseException
     */
    public boolean unlockClusterOperation(String operationName) throws BaseException;
    
    /**
     * This function returns all the mapped parameters defined for a dynamic screen
     * @param criteria
     * @throws DAOException
     */
    public List<DynamicScreenParamsMapCO> returnDynScreenMappedParameters(DynamicScreenParamsMapSC criteria) throws BaseException;

    
    /**
     * return the DMS_SEARCH_INDEX_HEADER for the specified app_name and prog_ref
     * @param DMS_SEARCH_INDEX_HEADERVO
     * @return DMS_SEARCH_INDEX_HEADERVO
     * @throws BaseException
     */
    public DMS_SEARCH_INDEX_HEADERVO returnDMSIndexFieldHeader(DMS_SEARCH_INDEX_HEADERVO headerVO) throws BaseException;
    
    /**
     * Return Docuware service link.
     * @param DmsRequestSC
     * @return String
     * @throws BaseException
     */
    public String returnServiceLink(DmsRequestSC criteria) throws BaseException;
    
    /**
     * return List of DMS IndexFieldNames
     * @param DmsRequestSC
     * @return List<DMS_SEARCH_INDEXVO>
     * @throws BaseException
     */
    public List<DMS_SEARCH_INDEXVO> returnDMSIndexFieldNames(DmsRequestSC criteria) throws BaseException;
    
    /**
     * return DMS Access Right by screen
     * @param criteria
     * @return int
     * @throws BaseException
     */
    public int returnDMSAccessRight(DmsRequestSC criteria) throws BaseException;
    
    /**
     * return the DMS user map details
     * @param userMap
     * @return
     * @throws BaseException
     */
    public DMS_USER_MAPVO returnDMSUserMap(DMS_USER_MAPVO userMap)  throws BaseException;
    
    /**
     * 
     * marwanmaddah
     */
    public List<LinkDynScrTabCO> returnAdditionalObjElements(ScreenGeneratorSC criteria) throws BaseException;
    /**
     * 
     * marwanmaddah
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> applyDynScreenDisplay(String elementId, String elementName,
	    String actionType, Object value, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMapToApplyTo,
	    RequiredFieldsSC criteria,AdditionalFlagsCO additionalFlagsCO) throws BaseException;
    /**
     * 
     * marwanmaddah
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> applyDynScreenDisplay(String elementId, String elementName,
	    String actionType, Object value, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessMapToApplyTo,
	    RequiredFieldsSC criteria,Boolean forceLoadFromDb,AdditionalFlagsCO additionalFlagsCO) throws BaseException;
    /**
     * 
     * marwanmaddah
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> applyDynScreenDisplay(String[] elementIds,String[] elementNames,
	    String actionType, Object value, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> theBusinessMapToApplyTo,
	    RequiredFieldsSC criteria,Boolean forceLoadFromDb,AdditionalFlagsCO additionalFlagsCO) throws BaseException;
    /**
     * 
     * marwanmaddah
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> applyDynScreenDisplay(String[] elementIdsOrNames,
	    String actionType, Object value, HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> theBusinessMapToApplyTo,
	    RequiredFieldsSC criteria,AdditionalFlagsCO additionalFlagsCO) throws BaseException;
    /**
     * 
     * marwanmaddah
     */
    public Object returnRequiredData(RequiredFieldsSC criteria,AdditionalFlagsCO additionalFlagsCO) throws BaseException;
    
    /**
     * 
     * marwanmaddah
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> returnMapRequiredData(RequiredFieldsSC criteria,AdditionalFlagsCO additionalFlagsCO)throws BaseException;
   
    /**
     * 
     * marwanmaddah
     */
    public Map<String,ScreenElementsMapCO> returnScreenElementsMap(RequiredFieldsSC criteria) throws BaseException;
    
    /**
     * 
     * marwanmaddah
     */
    public Map<String,SYS_PARAM_SCREEN_DISPLAYVO> applyDynDependencyExprs(Map<String,Object> paramsMap,RequiredFieldsSC criteria) throws BaseException;
    
    /**
     * 
     * marwanmaddah
     */
    public List<CurrElementExpressionsCO> returnCurrElementExpression(CommonLibSC commonLibSC) throws BaseException;
    /**
     * used to reset to 0 the column AXS_CHANGED_YN in S_APPLOG after changing the access rights of the user from SADS
     * @param sAppLogVO
     * @throws BaseException
     */
    public void resetUserAxsChange(S_APPLOGVO sAppLogVO) throws BaseException;
    /**
     * Method that return MessageCodes that are available in MessageCodes.java but not existing in CTSMESSAGES in the DB 
     * Methood used for debugging reason, and prior identification what is missing.
     * @return String of Message codes to be displayed
     * @throws BaseException
     */
    public String returnMissingMessageCodes() throws BaseException;
    
    /**
     * Method that returns CTSMESSAGES that have empty desc or title in EN, FR or AR in the DB 
     * Method used for debugging reason, and prior identification what is empty.
     * @param languages
     * @return String of Message codes, desc and titles to be displayed
     * @throws BaseException
     */
    public String returnEmptyCtsMessages(String languages) throws BaseException;
    /**
     * Method that returns CTSMESSAGES that have corrupted desc or title in EN, FR or AR in the DB 
     * Method used for debugging reason, and prior identification what is corrupted.
     * @param languages
     * @return String of Message codes, desc and titles to be displayed
     * @throws BaseException
     */
    public String returnCorruptedCtsMessages(String languages) throws BaseException;
    
    /**
     * method used to populate printers found on server into table SYS_WEB_PRINTERS
     * @throws Exception
     */
    public void populatePrinters() throws Exception;
    
    /**
     * return list of element activities
     * @param customElementActivitiesSC
     * @return
     * @throws BaseException
     */
    public List<CustomElementActivitiesSC> returnElementActivitiesList(CustomElementActivitiesSC customElementActivitiesSC)
	    throws BaseException;
    /**
     * return Cached TRSCLASS table VO
     * @param trsClassVO
     * @return
     * @throws BaseException
     */
    public TRSCLASSVO returnTrsClassVO(TRSCLASSVO trsClassVO) throws BaseException;
    /**
     * return customization data for grid 
     * @param criteria
     * @return
     * @throws BaseException
     */
    SYS_PARAM_OBJ_DISPLAYVO returnRequiredObjData(RequiredFieldsSC criteria)throws BaseException;
    
    SYS_PARAM_OBJ_DETAILS_DISPLAYVO returnRequiredObjDetailsData(RequiredFieldsSC criteria)throws BaseException;
    
    public void forceLogoutUsers(CommonLibSC commonLibSC) throws BaseException;
    
    /**
     * enable / disable the log by user
     * @param userName
     * @param enableFlag
     * @throws BaseException
     */
    public void updateLogByUser(String userName, boolean enableFlag) throws BaseException;
    
    /**
     * @param afterExecParamsMap
     * @throws BaseException
     */
    public ArrayList<Map<String,Object>> globalActivityAfterExec(HashMap<String,Object> afterExecParamsMap) throws BaseException;

    /*953614 Specify Grid Filter Query Expression - Grid/Livesearch Customization Enhancements*/
    /**
     *  returns filter expression associated with a grid/live_search if existed.
     *  null - otherwise.
     * @param objectCustomizationSC
     * @return 
     * @throws BaseException
     */
    String returnFilterExpression(ObjectCustomizationSC objectCustomizationSC) throws BaseException;
    /*end: 953614*/
    /**
     * @param  screenElementsList:List of screen elements
     * @param  visibilityExpression
     * @param  VariablesMap
     * used to validate expression for button customization visibility
     */
    public void validateExpression(List<SYS_PARAM_SCREEN_ENTITY_TYPEVO>entityTypeInfosLst,List<ButtonCustomizationCO> screenElementsList, String visibilityExpression, Map<String, Object> variablesMap) throws BaseException;
    /**
     * @description used to return object display id
     * 
     * @param criteria
     * @return BigDecimal
     * @throws BaseException
     */
    public BigDecimal returnObjDisplayId(SYS_PARAM_OBJ_DISPLAYVO criteria) throws BaseException;
    /**
     * Tp#1015205
     * used to return screen elements details
     * @param criteria
     * @return
     * @throws BaseException
     */
    public  List<ScreenElementCO> returnScreenElementsDetails(ButtonCustomizationSC criteria)throws BaseException; 
}
