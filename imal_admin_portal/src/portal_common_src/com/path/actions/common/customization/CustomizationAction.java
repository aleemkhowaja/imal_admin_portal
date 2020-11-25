package com.path.actions.common.customization;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.path.bo.common.CachedConstantsCommon;
import com.path.bo.common.CommonLibBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.customization.CustomizationBO;
import com.path.dbmaps.vo.OPTVO;
import com.path.dbmaps.vo.SYS_PARAM_LANGUAGESVO;
import com.path.dbmaps.vo.S_AUDIT_ACTION_DTLVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.StringUtil;
import com.path.lib.common.util.UnicodeUtil;
import com.path.lib.log.Log;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.FieldsBusTransCO;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.customization.BusTransCO;
import com.path.vo.common.customization.BusTransSC;
import com.path.vo.common.customization.CustomElementActivitiesSC;
import com.path.vo.common.customization.CustomizationCO;
import com.path.vo.common.customization.CustomizationSC;
import com.path.vo.common.customization.SavedAsScreensCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.customization.button.SysParamGlobalActArgMapSC;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: deniskhaddad
 *
 * CustomizationAction.java used to Manage teh Customization Specification of the Fields on the Screen
 * the Customization is store in SYS_PARAM_SCREEN_DISPLAY
 */
public class CustomizationAction extends GridBaseAction
{
    private String elemName; // element Name (name Attribute) of the Field being Customized
    private String elemId; // element ID (id Attribute) of the Field being Customized
    private String forTrans; //specify whether call coming from Business Translation only
    private String viewSQL; //value of the customization SQL
    private String fromButton;// specify whether call coming from Button customization icon
    private String fromCollaps;// specify whether call coming from collapsible Panel customization icon
    private String fromLiveSearch;// specify whether call coming from LiveSearch customization icon
    private String enableAfterExecution; //specify whether we enable after execution or no 
    private String fromTab;// specify whether call coming from tab customization icon
    
    /* value validation expression implementation */ 
    private String fromText;// specify whether call coming from Text customization icon
    private String fromTextArea;// specify whether call coming from TextArea customization icon
    private String fromDatePicker;// specify whether call coming from DatePicker customization icon
    private String allowDefValCust;// specify whether the default value is enabled on texts or livesearch
    private String mode;// specify whether the text field has a mode "text" or "number"
    //TP#1002338 Value Validation Expression for Element LiveSearch and Select Boxes
    private String fromSelectBox;
    
    private CustomizationCO custCO = new CustomizationCO();
    private final BusTransSC busTransSC = new BusTransSC();
    private CustomizationSC custSC = new CustomizationSC();
    private CustomizationBO customizationBO;
    private List<SYS_PARAM_LANGUAGESVO> languageVO =  new ArrayList<SYS_PARAM_LANGUAGESVO>();
    private final List<SelectCO> languageSelect =  new ArrayList<SelectCO>();
    
    private List<SelectCO> visibilityCmbList;
    private List<SelectCO> readonlyCmbList;
    private List<SelectCO> requiredCmbList;
    private List<SelectCO> allowZeroCmbList;
    private List<SelectCO> activityTypeCmbList;
    
    //specifiy is save as series checkbox shld appear
    private String showSaveAsSeries;
    
    private String helpScreenURL; //help_path from table OPT
    
    private String currLogLevel;// variable to specify current log level used
    private BigDecimal logByLoggedInUser; // flag to indicate if the log is enabled for the current user
    private BigDecimal logByOtherUser;// flag to indicate if the log should be enabled for other user
    private String logByOtherUserId;// the other user selected to enable the log for him
    private String logByUserMsg;//message indicating the time remaining before closing the log by user
    private BigDecimal commonScreen;
    
    List usrPrinters = new ArrayList();
    int usrPrinterCount;
    private String userDefPrntr;
    private SavedAsScreensCO svdScrnsCO = new SavedAsScreensCO();
    private String selectedScrnsDetails;
    private String allowDisableUsrCustRight;										  
    private String custActionType;
    private String showMaintenanceMenu;
    private String showApproveMenu;
    private String showViewMenu;
    private String custMaintRight;
    private String custApproveRight;
    private String mirrorProcess;
    public static final String VIEW_MODE = "V"; 
    public String changesDone;
    private String isClusterCall; //flag to check if clusterLogging method is called from clustered deployment or from user request.
    private String clusterLogUserName;
    private String clusterLogAppName;


	public String getSelectedScrnsDetails()
    {
        return selectedScrnsDetails;
    }

    public void setSelectedScrnsDetails(String selectedScrnsDetails)
    {
        this.selectedScrnsDetails = selectedScrnsDetails;
    }

    public SavedAsScreensCO getSvdScrnsCO()
    {
        return svdScrnsCO;
    }
    
    public void setSvdScrnsCO(SavedAsScreensCO svdScrnsCO)
    {
        this.svdScrnsCO = svdScrnsCO;
    }
        

    private InputStream scriptStream;
    

    private File file;

    public String rejectChanges()
    {
	try {
	    SessionCO sessCO =  returnSessionObject();
	    String appName = StringUtil.nullEmptyToValue(sessCO.getCurrentAppName(), ConstantsCommon.IMAL_APP_NAME);
	    custCO.getScreenDispVO().setAPP_NAME(appName);
	    custCO.setLanguage(sessCO.getLanguage());
	    custCO.setAllowDefValCust(allowDefValCust);
	    custCO.setMode(mode);
	    custCO.setUserId(sessCO.getUserName());
	    custCO.setRunningDate(sessCO.getRunningDateRET());
           /**
            * audit management	    
            */
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setKeyRef(AuditConstant.CUST_KEY);
	    refCO.setTrxNbr(getAuditTrxNbr());
	    custCO.setAuditObj(returnAuditObject(custCO.getClass()));
	    custCO.setAuditRefCO(refCO);
	    custCO.setAuditObj(returnAuditObject(custCO.getClass()));
	    NumberUtil.resetEmptyValues(custCO);
	   /**
	    * 
	    */
	    customizationBO.rejectChanges(custCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    /**
     * 
     * Used for calling the update of the data
     * 
     * @return
     */
    public String updateChanges()
    {
	try
	{
	    SessionCO sessCO =  returnSessionObject();
	    String appName = StringUtil.nullEmptyToValue(sessCO.getCurrentAppName(), ConstantsCommon.IMAL_APP_NAME);
	    custCO.getScreenDispVO().setAPP_NAME(appName);
	    custCO.setLanguage(sessCO.getLanguage());
	    custCO.setAllowDefValCust(allowDefValCust);
	    custCO.setMode(mode);
	    custCO.setUserId(sessCO.getUserName());
	    custCO.setRunningDate(sessCO.getRunningDateRET());
	    String busTransUpdate = StringUtil.nullToEmpty(custCO.getCustBusTransUpdate());
	    ArrayList lstAdd = null,lstMod = null,lstDel = null;
	    if(!busTransUpdate.isEmpty())
	    {
        	    GridUpdates gu    = getGridUpdates(busTransUpdate,BusTransCO.class);
        	     lstAdd  = gu.getLstAdd();
        	    custCO.setAddBusTrans(lstAdd);
        	     lstMod  = gu.getLstModify();
        	    custCO.setModBusTrans(lstMod);
        	     lstDel  = gu.getLstDelete();
        	    custCO.setDelBusTrans(lstDel);
	    }
	    if(ConstantsCommon.ONE.equals(StringUtil.nullToEmpty(fromButton)) || ConstantsCommon.ONE.equals(StringUtil.nullToEmpty(fromCollaps)))
	    {		
		if(NumberUtil.isEmptyDecimal(custCO.getScreenDispVO().getIS_MANDATORY()))
		{
		    custCO.getScreenDispVO().setIS_MANDATORY(BigDecimal.ZERO);
		}
		if(NumberUtil.isEmptyDecimal(custCO.getScreenDispVO().getZERO_NOT_ALLOWED()))
		{
		    custCO.getScreenDispVO().setZERO_NOT_ALLOWED(BigDecimal.ZERO);
		}
		if(NumberUtil.isEmptyDecimal(custCO.getScreenDispVO().getIS_READONLY()))
		{
		    custCO.getScreenDispVO().setIS_READONLY(BigDecimal.ZERO);
		}
	    }
	    
	    if(StringUtil.isNotEmpty(custCO.getCustomElementActivitiesGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(custCO.getCustomElementActivitiesGridUpdate(),
			CustomElementActivitiesSC.class, true);
		    
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<CustomElementActivitiesSC> customElementActivitiesSCList = gu.getLstAllRec();
		    if(customElementActivitiesSCList != null && !customElementActivitiesSCList.isEmpty())
		    {
			custCO.setCustomElementActivitiesSCList(customElementActivitiesSCList);
		    }
		}
	    }
	    
	    if( ButtonCustomizationConstants.ACTIVITY_TYPE.DYNAMIC.equals(custCO.getScreenDispVO().getACTIVITY_TYPE()) && StringUtil.isNotEmpty(custCO.getDynScrParamMapGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(custCO.getDynScrParamMapGridUpdate(),
			DynamicScreenParamsMapCO.class, true);
		    
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<DynamicScreenParamsMapCO> dynamicScreenParamsMapCOList = gu.getLstAllRec();
		    if(dynamicScreenParamsMapCOList != null && !dynamicScreenParamsMapCOList.isEmpty())
		    {
			custCO.setDynamicScreenParamsMapCOList(dynamicScreenParamsMapCOList);
		    }
		}
	    }
	    
	    if( (ButtonCustomizationConstants.ACTIVITY_TYPE.GLOBAL.equals(custCO.getScreenDispVO().getACTIVITY_TYPE()) || ButtonCustomizationConstants.ACTIVITY_TYPE.CUSTOM.equals(custCO.getScreenDispVO().getACTIVITY_TYPE()) || ButtonCustomizationConstants.ACTIVITY_TYPE.BEFOREEXECUTION.equals(custCO.getScreenDispVO().getACTIVITY_TYPE()) || ButtonCustomizationConstants.ACTIVITY_TYPE.AFTEREXECUTION.equals(custCO.getScreenDispVO().getACTIVITY_TYPE()) || ButtonCustomizationConstants.ACTIVITY_TYPE.ONCHANGE.equals(custCO.getScreenDispVO().getACTIVITY_TYPE()) || ButtonCustomizationConstants.ACTIVITY_TYPE.KEYEVENT.equals(custCO.getScreenDispVO().getACTIVITY_TYPE())) || ButtonCustomizationConstants.ACTIVITY_TYPE.AFTEREXECUTION.equals(custCO.getScreenDispVO().getACTIVITY_TYPE()) || ButtonCustomizationConstants.ACTIVITY_TYPE.BOTH.equals(custCO.getScreenDispVO().getACTIVITY_TYPE()) 
		    && StringUtil.isNotEmpty(custCO.getButtonCustParamMapGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(custCO.getButtonCustParamMapGridUpdate(),
			SysParamGlobalActArgMapSC.class, true);
		    
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<SysParamGlobalActArgMapSC> buttonCustParamsMapSCList = gu.getLstAllRec();
		    if(buttonCustParamsMapSCList != null && !buttonCustParamsMapSCList.isEmpty())
		    {
			custCO.setButtonCustParamsMapSCList(buttonCustParamsMapSCList);
		    }
		}
	    }
	    if(StringUtil.nullToEmpty(custActionType).isEmpty())
	    {
		custCO.setActionType(ConstantsCommon.NO_MIR_MODE);
	    }
	    else
	    {
		custCO.setActionType(custActionType);
	    }
	    
	    
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setKeyRef(AuditConstant.CUST_KEY);
	    refCO.setTrxNbr(getAuditTrxNbr());
	    custCO.setAuditObj(returnAuditObject(custCO.getClass()));
	    custCO.setAuditRefCO(refCO);
	    custCO.setAuditObj(returnAuditObject(custCO.getClass()));
	    if(ConstantsCommon.ONE.equals(fromTab))
	    {
		String currElemName = custCO.getScreenDispVO().getELEMENT_NAME();
		if(currElemName!=null && currElemName.endsWith(get_pageRef()))
		{
		    int progRefIndex = currElemName.indexOf("_"+get_pageRef());
		    currElemName = currElemName.substring(0,progRefIndex);
		    custCO.getScreenDispVO().setELEMENT_NAME(currElemName);
		}
	    }
	    NumberUtil.resetEmptyValues(custCO);
	    customizationBO.updateElemCustomization(custCO);
 	    if((lstAdd != null && !lstAdd.isEmpty()) || (lstMod != null && !lstMod.isEmpty()) || (lstDel != null && !lstDel.isEmpty()))
	    {
		synchronized(CachedConstantsCommon.busTransInfo)
		{
		    CachedConstantsCommon.busTransInfo = new HashMap<String, Map<String,FieldsBusTransCO>>();
		}
		
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    /**
     * 
     * Used for calling the reset of the data
     * 
     * @return
     */
    public String resetChanges()
    {
	try
	{
	    SessionCO sessCO =  returnSessionObject();
	    String appName = StringUtil.nullEmptyToValue(sessCO.getCurrentAppName(), ConstantsCommon.IMAL_APP_NAME);
	    custCO.getScreenDispVO().setAPP_NAME(appName);
	    if(StringUtil.isNotEmpty(custCO.getCustomElementActivitiesGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(custCO.getCustomElementActivitiesGridUpdate(),
			CustomElementActivitiesSC.class, true);
		    
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<CustomElementActivitiesSC> customElementActivitiesSCList = gu.getLstAllRec();
		    if(customElementActivitiesSCList != null && !customElementActivitiesSCList.isEmpty())
		    {
			custCO.setCustomElementActivitiesSCList(customElementActivitiesSCList);
		    }
		}
	    }
	    customizationBO.resetElemCustomization(custCO);
	    //reset field identified since the record is deleted
	    custCO.getScreenDispVO().setFLD_IDENTIFIER(null);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    /**
     * @return the busTransSC
     */
    @Override
    public Object getModel()
    {
        return busTransSC;
    }

    public String loadCustViewSql()
    {
	try
	{
	    SessionCO sessCO = returnSessionObject();
	    String appName = StringUtil.nullEmptyToValue(sessCO.getCurrentAppName(), ConstantsCommon.IMAL_APP_NAME);
	    custCO.getScreenDispVO().setAPP_NAME(appName);
	    viewSQL = customizationBO.returnCustSQL(custCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    public String loadLanguageSelect()
    {
	try
	{
	    SelectSC sc = new SelectSC();
	    SelectCO sco;
	    sc.setLovTypeId(ConstantsCommon.LANGUAGES_LOV_TYPE);
	    sc.setLanguage(returnSessionObject().getLanguage());
	    languageVO =  returnCommonLibBO().returnLanguages(sc);
	    int langSize = languageVO.size();
	    for(int i = 0; i < langSize;  i++)
	    {
		sco = new SelectCO();
		sco.setCode(languageVO.get(i).getLANG_CODE());
		sco.setDescValue(languageVO.get(i).getLANG_NAME());
		languageSelect.add(i,sco);
	    }
	    languageSelect.add(0,new SelectCO("-1", ""));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return "jsonSuccess";
    }
    /**
     * Used for loading the Grid of Business Translation
     * @return
     */
    public String loadBusTransList()
    {
	try
	{
        	String[] searchCol = {"LANGUAGE","TOOLTIP"};
        	SessionCO sessionObject = returnSessionObject();
        	String appName = StringUtil.nullEmptyToValue(sessionObject.getCurrentAppName(), ConstantsCommon.IMAL_APP_NAME);
        	busTransSC.setAppName(appName);
        	busTransSC.setPageRef(get_pageRef());
        	busTransSC.setFldIdent(custCO.getScreenDispVO().getFLD_IDENTIFIER());
        	busTransSC.setElemntName(custCO.getScreenDispVO().getELEMENT_NAME());
        	busTransSC.setVoPropName(StringUtil.nullEmptyToValue(custCO.getScreenDispVO().getVO_PROPERTY_NAME(), "default1"));
        	busTransSC.setVoCoRef(StringUtil.nullEmptyToValue(custCO.getScreenDispVO().getVO_CO_REFERENCE(), "default"));
        	busTransSC.setSearchCols(searchCol);
        	copyproperties(busTransSC);
        	 List<BusTransCO> busTransList  =  customizationBO.returnBusTranList(busTransSC);
        	setGridModel(busTransList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    /**
     * redirecting to Save As Page for Screen Duplicating.
     * @return
     */
    public String loadSaveAsPage()
    {
	try
	{
	    String saveAsAccessRight = returnAccessRightByProgRef(ConstantsCommon.SAVE_AS_OPT);
	    if(saveAsAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }

	    SessionCO sessionObject = returnSessionObject();
	    String appName = sessionObject.getCurrentAppName();
	    custCO.getScreenDispVO().setAPP_NAME(appName );
	    String theProgRef = get_pageRef();
	    CommonLibSC sc = new CommonLibSC();
	    sc.setAppName(appName);
	    sc.setProgRef(theProgRef);
	    //check if _pageRef is allowed to be saved as 
	    customizationBO.checkAllowDuplicate(sc);
	    if(!StringUtil.nullToEmpty(customizationBO.checkSaveAsSeries(sc)).isEmpty())
	    {
		showSaveAsSeries = "1";
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
	return "success_save_as";
    }
    

    
    /**
     * redirect to delete saved screens page
     * @author SimonRizkallah
     * @return String
     */
    public String loadDeleteSvdScrnsPageActionMethod()
    {
	try
	{
	    String delSvdScrnAccessRight = returnAccessRightByProgRef(ConstantsCommon.SAVE_AS_OPT);
	    if(delSvdScrnAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
	return "success_delete_saved_screens";	
    }
    
    
    
   /**
    * Delete selected saved screens
    * @author SimonRizkallah
    * @return String if the delete was successful
    */
    public String deleteSvdScrnsActionMethod()
    {				
	try
	{
	    List<SavedAsScreensCO> lstDel = new ArrayList<SavedAsScreensCO>();
	    JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(selectedScrnsDetails);
	    JSONArray jsonModel = jsonFilter.getJSONArray("root");     		
	    for( int i = 0; i < jsonModel.size(); i++ )
	    {  
		SavedAsScreensCO theSvdScrnsCO = new SavedAsScreensCO();
		theSvdScrnsCO.getOptVO().setPROG_REF((String)jsonModel.getJSONObject(i).get("PROG_REF"));     		
		theSvdScrnsCO.getOptVO().setAPP_NAME((String)jsonModel.getJSONObject(i).get("APP_NAME"));  
		theSvdScrnsCO.getOptVO().setPARENT_REF((String)jsonModel.getJSONObject(i).get("PARENT_REF")); 
		theSvdScrnsCO.setDeleteParent((String)jsonModel.getJSONObject(i).get("deleteParent"));
		theSvdScrnsCO.setDeleteSeries((String)jsonModel.getJSONObject(i).get("deleteSeries"));
		lstDel.add(theSvdScrnsCO);
	    } 	   
	    String nonDeletedDuplicatedParents = customizationBO.deleteSavedScreens(lstDel);
	    if( !StringUtil.nullToEmpty(nonDeletedDuplicatedParents).isEmpty() )
	    {
		svdScrnsCO.setMessage(nonDeletedDuplicatedParents);		
	    }	
	}    
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }    
    
   
    
    /**
     * Method for applying SaveAs of the screen.
     * @return
     */
    public String updateSaveAsChanges()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    custCO.getScreenDispVO().setAPP_NAME(sessionObject.getCurrentAppName());
	    custCO.setUserId(sessionObject.getUserName());
	    custCO.setCompCode(sessionObject.getCompanyCode());
	    custCO.setBranchCode(sessionObject.getBranchCode());
	    
	    custCO = customizationBO.updateSaveAsChanges(custCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    /**
     * 
     * Used for loading the customization Page
     * 
     * @return
     */
    public String loadCustMaintPage()
    {
	try
	{

	    String scrSettingAccessRight = returnAccessRightByProgRef(ConstantsCommon.SETTINGS_CONFIG_OPT);
	    if(scrSettingAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }
	    
	    if(ConstantsCommon.CRUD_APPROVE.equals(custActionType))
	    {
		String custApprAccessRight = returnAccessRightByProgRef(ConstantsCommon.CUST_APPROVE_OPT);
		if(custApprAccessRight == null)
		{
		    throw new BOException(MessageCodes.NO_ACCESS);
		}
	    }
	    else if(ConstantsCommon.CRUD_MAINTAIN.equals(custActionType))
	    {
		String custMaintAccessRight = returnAccessRightByProgRef(ConstantsCommon.CUST_MAINTENANCE_OPT);
		if(custMaintAccessRight == null)
		{
		    throw new BOException(MessageCodes.NO_ACCESS);
		}
	    }
	    
	    SessionCO sessCO =  returnSessionObject();
	    /**
	     * on approve, the screen will be disable, where user can approve or reject the saved customization only.
	     */
	    if(ConstantsCommon.CRUD_APPROVE.equals(custActionType) || VIEW_MODE.equals(custActionType))
	    {
		set_recReadOnly(ConstantsCommon.TRUE);
	    }
	    
	    if(BigDecimal.ONE.equals(commonScreen))
	    {
		set_pageRef(ConstantsCommon.SETTINGS_CONFIG_OPT);
	    }
	    String appName = StringUtil.nullToEmpty(sessCO.getCurrentAppName());
	    if(appName.isEmpty())
	    {
        	   throw new BaseException("No Application Specified");
	    }
	    else
	    {
		String progRef =  StringUtil.nullEmptyToValue(get_pageRef(), ConstantsCommon.PROGREF_ROOT);
		/**
		 * [MarwanMaddah]
		 * in case the customization opening is from alert 
		 * will remove the _ALERT from the progRef value.
		 */
		if(progRef != null && progRef.endsWith("_ALERT"))
		{
		    progRef = progRef.substring(0, progRef.indexOf("_ALERT"));
		}
		/**
		 * 
		 */
		String currElemId = StringUtil.nullToEmpty(elemId) ;
		// check if Livesearch
		if(currElemId.startsWith("lookuptxt_"))
		{
		    currElemId = currElemId.replace("lookuptxt_", "") ;
		}
		// check if concatinated with Page Ref
		if(currElemId.endsWith("_"+progRef))
		{
		    currElemId = currElemId.replace("_"+progRef, "");
		}
		
		RequiredFieldsSC reqFldSC = new RequiredFieldsSC(); 
		reqFldSC.setAppName(appName);
		reqFldSC.setProgRef(progRef);
		reqFldSC.setCompCode(BigDecimal.ZERO);
		reqFldSC.setElementName(elemName);
		reqFldSC.setDefaultAppName(ConstantsCommon.IMAL_APP_NAME);
		reqFldSC.setFromText(fromText);
		reqFldSC.setFromTextArea(fromTextArea);
		//TP#1002338 Value Validation Expression for Element LiveSearch and Select Boxes
		reqFldSC.setFromSelectBox(fromSelectBox);
		reqFldSC.setFromLiveSearch(fromLiveSearch);
		reqFldSC.setAllowDefValCust(allowDefValCust);
		reqFldSC.setCustActionType(custActionType);
		/**
		 * [MarwanMaddah]
		 * in case of a tab 
		 * the element Name will be equal to the element id 
		 * so in this case will remove the _pageRef from the value
		 */
		if(ConstantsCommon.ONE.equals(fromTab))
		{
		  if(elemName!=null && elemName.endsWith(get_pageRef()))
		  {
		     int progRefIndex = elemName.indexOf("_"+get_pageRef());
		     String currElemName = elemName.substring(0,progRefIndex);
		     reqFldSC.setElementName(currElemName);
		  }
		}
		
		custCO = customizationBO.returnElemCustomization(reqFldSC);
		
		
		custCO.setCutomizationPROG_REF(progRef);
		custCO.setFromTrans(forTrans);
		custCO.getScreenDispVO().setELEMENT_ID(currElemId);
		
		getAdditionalScreenParams().putAll(custCO.getCustDisplayMgnt());
		custCO.setCustDisplayMgnt(null);
		custCO.setAppName(appName);
		custCO.getScreenDispVO().setAPP_NAME(appName);
		/**
		 * in case disable customization is true an action error will be added to JSP
		 * and the Customization screen will be on ReadOnly mode
		 */
		Boolean disableCust = custCO.getDisableCust();
		if(disableCust)
		{
		     addActionError(getText("disable_customization_key"));
		}

		CommonLibSC commLibSC = new CommonLibSC();	
		commLibSC.setProgRef(ConstantsCommon.ALLOW_DISABLE_USER_CUSTOMIZATION_OPT);	
		commLibSC.setAppName( StringUtil.nullToEmpty(sessCO.getCurrentAppName()) );
		commLibSC.setCompCode(sessCO.getCompanyCode());
		commLibSC.setBranchCode(sessCO.getBranchCode());
		commLibSC.setUserId(sessCO.getUserName());
		setAllowDisableUsrCustRight(returnCommonLibBO().checkUserPrivileges(commLibSC));								     		
		// set readonlyScreen if Business prevent from changing, and not opening business tooltip translation
		if((BigDecimal.ONE.equals(custCO.getScreenDispVO().getBUS_RELATED()) && forTrans == null)
		   ||
		   disableCust
		   || 
		   ( BigDecimal.ONE.equals(custCO.getScreenDispVO().getIS_ADM_CUST_DIS_YN()) && StringUtil.nullToEmpty(allowDisableUsrCustRight).isEmpty() )  
		  )
		{
		    set_recReadOnly("true");
		}
		fillComboBox();			
	    }
            	//Access rights for export/import screen customization.
        	setExpImpCustRight(returnAccessRightByProgRef(ConstantsCommon.EXP_IMP_CUST_OPT)); 
        	
	    if(StringUtil.isNotEmpty(StringUtil.nullToEmpty(custCO.getScreenDispVO().getBACKGROUND_COLOR()))
		    && !custCO.getScreenDispVO().getBACKGROUND_COLOR().startsWith("#"))
	    {
		try
		{
		    /*
		     * In case the color name is provided like 'red', 'white' ..
		     * we need to get the hexadecimal value to pass it to color
		     * picker because the color picker component accepts only
		     * hex values
		     */
		    /* construct a dummy Color instance */
		    Color col1 = new Color(0);
		    Field field = col1.getClass().getField(custCO.getScreenDispVO().getBACKGROUND_COLOR());
		    Color color = (Color) field.get(null);
		    /* return the hex color value from Color instance */
		    custCO.getScreenDispVO().setBACKGROUND_COLOR(returnHexColor(color));
		}
		catch(Throwable e)
		{ 
		    log.error(e, "Error converting color name " + custCO.getScreenDispVO().getBACKGROUND_COLOR() +  " to hexadecimal value ");
		}
	    }
	    /**
	     * [MarwanMaddah]
	     * the if condition has been added to don't mention the default first customization laod as retreive inside audit
	     */
	    if(custCO.getScreenDispVO()!= null && custCO.getScreenDispVO().getFLD_IDENTIFIER()!=null)
	    {
		NumberUtil.resetEmptyValues(custCO.getScreenDispVO());
		applyRetrieveAudit(AuditConstant.CUST_KEY,custCO.getScreenDispVO(),custCO);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
	return SUCCESS;
    }
        
    /**
     * This function takes java.awt.Color in parameters and return the corresponding hexadecimal value as String
     */
    private String returnHexColor(Color colour) 
    {
        String hexColour = Integer.toHexString(colour.getRGB() & 0xffffff);
        if (hexColour.length() < 6) {
          hexColour = "000000".substring(0, 6 - hexColour.length()) + hexColour;
        }
        return "#" + hexColour;
    }

    
    /**
     * fill combos management
     * @author marwanmaddah
     * @date   Apr 10, 2014 void
     *
     */
    private void fillComboBox() throws BaseException
    {
	/**
	 * combo boxes management
	 */
	SelectCO visibilityCO = null;
	SelectCO readOnlyCO = null;
	SelectCO requiredCO = null;
	SelectCO allowedZeroCO = null;
	visibilityCmbList = new ArrayList<SelectCO>();
	readonlyCmbList   = new ArrayList<SelectCO>();
	requiredCmbList   = new ArrayList<SelectCO>();
	allowZeroCmbList  = new ArrayList<SelectCO>();
	//define the LOV of the button activity type
	SelectSC selSC = new SelectSC(ConstantsCommon.BUTTON_ACTIVITY_LOV_TYPE);
	activityTypeCmbList = returnLOV(selSC);
	/**
	 * [MarwanMaddah]:the length will be 4 in case the entity type is cifType 
	 * to add hide_and_override_business and hide_and_override_business_based_on_expression management to the visibility
	 * ConstantsCommon.ENTITY_CIF_TYPE_DISPLAY.equals(StringUtil.nullToEmpty(custCO.getEntityType()))?4:2;
	 */
        int comboLength = 2;  
	for(int i = 0;i<=comboLength;i++)
	{
	    visibilityCO = new SelectCO();
	    visibilityCO.setCode(String.valueOf(i));
	    if(i<=2)
	    {
        	readOnlyCO = new SelectCO();
        	readOnlyCO.setCode(String.valueOf(i));
        	   
        	requiredCO = new SelectCO();
        	requiredCO.setCode(String.valueOf(i));
        	
        	allowedZeroCO = new SelectCO();
        	allowedZeroCO.setCode(String.valueOf(i));
	    }
	    switch(i)
	    {
		case 0:
		    visibilityCO.setDescValue(getText("not_visibile_key"));
		    readOnlyCO.setDescValue(getText("editable_key"));
		    requiredCO.setDescValue(getText("not_required_key"));
		    allowedZeroCO.setDescValue(getText("allow_zero_key"));
		    break;
		case 1:
		    visibilityCO.setDescValue(getText("visibile_key"));
		    readOnlyCO.setDescValue(getText("readonly_key"));
		    requiredCO.setDescValue(getText("required_key"));
		    allowedZeroCO.setDescValue(getText("not_allow_key"));
		    break;
		case 2:
		    visibilityCO.setDescValue(getText("visibility_expr_key"));
		    readOnlyCO.setDescValue(getText("readOnly_expr_key"));
		    requiredCO.setDescValue(getText("required_expr_key"));
		    allowedZeroCO.setDescValue(getText("all_zero_expr_key"));
		    break;
		case 3:
		    visibilityCO.setDescValue(getText("hide_override_business_expr_key"));
//		    readOnlyCO.setDescValue(getText("readOnly_Expression_of_Business_key"));
//		    requiredCO.setDescValue(getText("required_Expression_of_Business_key"));
//		    allowedZeroCO.setDescValue(getText("allowZero_Expression_of_Business_key"));
		    break;
		case 4:
		    visibilityCO.setDescValue(getText("hide_override_business_key"));
//		    readOnlyCO.setDescValue(getText("readOnly_Expression_of_Business_key"));
//		    requiredCO.setDescValue(getText("required_Expression_of_Business_key"));
//		    allowedZeroCO.setDescValue(getText("allowZero_Expression_of_Business_key"));
		    break;
		default:
		    break; 
	    }
	    if(i > 2)
	    {		
	      visibilityCmbList.add(visibilityCO);
	    }
	    else
	    {
	      visibilityCmbList.add(visibilityCO);	
	      readonlyCmbList.add(readOnlyCO);
	      requiredCmbList.add(requiredCO);
	      allowZeroCmbList.add(allowedZeroCO);
	    }
	}	
    }
    
    public String loadHelpPage()
    {
	SessionCO sessCO = returnSessionObject();
	try
	{
	    String helpAppName = sessCO.getCurrentAppName();
	    String originOPTRef = get_pageRef();
	    // return the details of the OPT
	    String[] optDetailsArray = returnCommonLibBO().returnOptDetailsList(helpAppName, originOPTRef);
	    if(optDetailsArray != null)
	    {
		// OPT Reference is not empty
		if(!StringUtil.nullToEmpty(optDetailsArray[4]).isEmpty())
		{
		    originOPTRef = optDetailsArray[4];
		}
		//External appName for the given OPT
		if(!optDetailsArray[5].isEmpty())
		{
		    helpAppName = optDetailsArray[5];
		    //target (external) progRef
		    if(!optDetailsArray[6].isEmpty())
		    {
			originOPTRef = optDetailsArray[6];
		    }
		}

		CommonLibSC sc = new CommonLibSC();
		sc.setAppName(helpAppName);
		sc.setProgRef(originOPTRef);
		helpScreenURL = returnCommonLibBO().returnHelpPathFromOpt(sc);
		if(StringUtil.nullToEmpty(helpScreenURL).isEmpty() )
		{
		    throw new BOException("Help URL not found for appName="+helpAppName+" and Prog Reference ="+originOPTRef);
		}
		if(helpScreenURL.toLowerCase(Locale.ENGLISH).indexOf("htm") < 0)
		{
		    helpScreenURL = helpScreenURL.concat(".htm");
		}
		custCO.setAppName(helpAppName);
	    }
	    else
	    {
		throw new BOException("No OPT Details Found for originOPTRef= "+originOPTRef +" and appName="+helpAppName);
	    }
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    //TP 820336
    /**
     * Method to prepare data to be inserted in audit for clear cache and log level
     * @param isRetreiveOP set to true if operation is a retrieve operation, otherwise false
     * @param old_val contains the old value set before change occurs
     * @return 'true'/'false' in case we have changes or not
     * @throws BaseException 
     */
    private String customInitAudit(boolean isRetreiveOp,String old_val, String old_log_by_user_val, String logForUser) throws BaseException {
	 SessionCO sessCO = returnSessionObject();//call session
	 String appName = ConstantsCommon.returnCurrentAppName();
	 String machineName= sessCO.getMachineIp();
	 String userID= sessCO.getUserName();
	 String progref= ConstantsCommon.TECH_LOGS_OPT;
	 String currLogByUserEnabled = ( BigDecimal.ONE.compareTo(logByLoggedInUser) == 0 ) ? ConstantsCommon.TRUE : ConstantsCommon.FALSE;
	 //BUG#931669 call audit report for Log level only if audit operation flag is enabled
	 OPTVO optVO = new  OPTVO();
	 optVO.setAPP_NAME(sessCO.getCurrentAppName());
	 optVO.setPROG_REF(ConstantsCommon.TECH_LOGS_OPT);
	 OPTVO opt = auditBO.returnAuditDetails(optVO);
	 
	if(!currLogLevel.equals(old_val) 
		|| !currLogByUserEnabled.equals(old_log_by_user_val)
		|| (!NumberUtil.isEmptyDecimal(logByOtherUser) && logByOtherUserId != null && !logByOtherUserId.isEmpty()))
	{// if no change occurs break
	    try
	    {
		List<S_AUDIT_ACTION_DTLVO> auditActionDtlList = new ArrayList<S_AUDIT_ACTION_DTLVO>();
		// call Audit on Opera
		AuditRefCO cacheAuditRefCO = new AuditRefCO();
		cacheAuditRefCO.setAppName(appName);
		cacheAuditRefCO.setProgRef(progref);
		cacheAuditRefCO.setMachineID(machineName);
		cacheAuditRefCO.setUserID(userID);
		cacheAuditRefCO.setAuditEnabled(true);
		//BUG#931669 check if Audit_Retrieve is enabled
		if(isRetreiveOp && "1".equals(opt.getAUDIT_RETRIEVE()))
		{
		    cacheAuditRefCO.setOperationType(AuditConstant.RETRIEVE);
		}
		//BUG#931669 check if Audit_SAVE is enabled
		else if (!isRetreiveOp && "1".equals(opt.getAUDIT_SAVE()))
		{
		    cacheAuditRefCO.setOperationType(AuditConstant.UPDATE);
		    if(!currLogLevel.equals(old_val))
		    {
			S_AUDIT_ACTION_DTLVO sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
			sAuditActionDtlVO.setOLD_VALUE(old_val);
			sAuditActionDtlVO.setNEW_VALUE(currLogLevel);
			sAuditActionDtlVO.setFIELD_NAME("Log Level");
			auditActionDtlList.add(sAuditActionDtlVO);
		    }
		    
		    String severeKeyTrans = null;
		    String allKeyTrans = null;
		    if( (!currLogByUserEnabled.equals(old_log_by_user_val))
			    || (logByOtherUser != null && logByOtherUserId != null && !logByOtherUserId.isEmpty()))
		    {
			CommonLibSC sc = new CommonLibSC();
			sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
			sc.setProgRef(ConstantsCommon.PROGREF_ROOT);
			sc.setKeyLabelCode("log_level_error_key");
			sc.setLanguage(sessCO.getLanguage());
			CommonLibBO commonLibBO = returnCommonLibBO();
			severeKeyTrans = commonLibBO.returnKeyLabelTrans(sc);
			sc.setKeyLabelCode("log_level_all_key");
			allKeyTrans = commonLibBO.returnKeyLabelTrans(sc);
		    }
		    
		    if(!currLogByUserEnabled.equals(old_log_by_user_val))
		    {
			S_AUDIT_ACTION_DTLVO sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
			
			if(Boolean.valueOf(old_log_by_user_val))
			{
			    sAuditActionDtlVO.setOLD_VALUE(allKeyTrans);
			    sAuditActionDtlVO.setNEW_VALUE(severeKeyTrans);
			}
			else
			{
			    sAuditActionDtlVO.setOLD_VALUE(severeKeyTrans);
			    sAuditActionDtlVO.setNEW_VALUE(allKeyTrans);
			}
			sAuditActionDtlVO.setFIELD_NAME("Log Level");
			auditActionDtlList.add(sAuditActionDtlVO);
			
			sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
			sAuditActionDtlVO.setOLD_VALUE(old_log_by_user_val);
			sAuditActionDtlVO.setNEW_VALUE(currLogByUserEnabled);
			sAuditActionDtlVO.setFIELD_NAME("Log By User");
			auditActionDtlList.add(sAuditActionDtlVO);
			
			sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
			sAuditActionDtlVO.setOLD_VALUE("");
			sAuditActionDtlVO.setNEW_VALUE(logForUser);
			sAuditActionDtlVO.setFIELD_NAME("Log For User");
			auditActionDtlList.add(sAuditActionDtlVO);
		    }	
		    if(logByOtherUser != null 
			    && logByOtherUserId != null && !logByOtherUserId.isEmpty())
		    {
			boolean logByOtherUserEnabled = ( BigDecimal.ONE.compareTo(logByOtherUser) == 0 );
			
			S_AUDIT_ACTION_DTLVO sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
			sAuditActionDtlVO.setOLD_VALUE("");
			sAuditActionDtlVO.setNEW_VALUE(logByOtherUserId);
			sAuditActionDtlVO.setFIELD_NAME("Log For Other User");
			auditActionDtlList.add(sAuditActionDtlVO);
			
			sAuditActionDtlVO = new S_AUDIT_ACTION_DTLVO();
			if(logByOtherUserEnabled)
			{
			    sAuditActionDtlVO.setOLD_VALUE(severeKeyTrans);
			    sAuditActionDtlVO.setNEW_VALUE(allKeyTrans);
			}
			else
			{
			    sAuditActionDtlVO.setOLD_VALUE(allKeyTrans);
			    sAuditActionDtlVO.setNEW_VALUE(severeKeyTrans);
			}
			sAuditActionDtlVO.setFIELD_NAME("Log Level for Other User");
			auditActionDtlList.add(sAuditActionDtlVO);
		    }
		    
		}

		// Call specificCallAudit to create and initialize AuditCO
		if(StringUtil.isNotEmpty(cacheAuditRefCO.getOperationType()))
		{
		auditBO.specificCallAudit(cacheAuditRefCO, auditActionDtlList);
		}
	    }
	    catch(Exception e)
	    {
		handleException(e, null, null);
	    }
	    return ConstantsCommon.TRUE;
	}
	return ConstantsCommon.FALSE;
    }
    /**
     * method to load the page of Log Level Changing
     * @return
     */
    public String logLevelPageLoad()
    {
	try
	{
	    String logLevelAccessRight = returnAccessRightByProgRef(ConstantsCommon.TECH_LOGS_OPT);
	    if(logLevelAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }

	    log.debug("load log level page");
	    String accessOnPageRef = ConstantsCommon.TRUE.equals(isClusterCall)?ConstantsCommon.TECH_LOGS_OPT:returnAccessRightByProgRef(ConstantsCommon.TECH_LOGS_OPT);
	    // check access right for log level
	    if(StringUtil.isNotEmpty(accessOnPageRef))
	    {
		SessionCO sessionCO = returnSessionObject();
		if(Log.getInstance().getDefaultLevel() != null)
		{

		    currLogLevel = Log.getInstance().getDefaultLevel().getName().toUpperCase(Locale.ENGLISH);
		}
	    String userName = ConstantsCommon.TRUE.equals(isClusterCall)?clusterLogUserName:sessionCO.getUserName();
		logByLoggedInUser = Log.isLogByUserEnabled(userName) ? BigDecimal.ONE : BigDecimal.ZERO;
		//aa logByUserMsg = Log.returnLogByUserMsg(sessionCO.getUserName());

		Map resultMap = Log.returnLogByUserRemainingTime(userName);
		if(resultMap != null && !ConstantsCommon.TRUE.equals(isClusterCall))
		{
		    logByUserMsg = returnCommonLibBO().returnTranslErrorMessage(MessageCodes.LOG_BY_USER_REMAINING_TIME, new String[] { StringUtil.nullToEmpty(resultMap.get("minutes")), StringUtil.nullToEmpty(resultMap.get("seconds"))}, sessionCO.getLanguage());
		}
		
		//TP 820336
		//Call Audit: true means it's a Retrieve operation with no old value 
		if(!ConstantsCommon.TRUE.equals(isClusterCall))
		{
			customInitAudit(true,null,null,null);
		}
	    }
	    return "logLevelPage";
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
    }
    
    public String updateLogLevel()
    {
	try
	{
	    String accessOnPageRef = ConstantsCommon.TRUE.equals(isClusterCall)?ConstantsCommon.TECH_LOGS_OPT:returnAccessRightByProgRef(ConstantsCommon.TECH_LOGS_OPT);
	    // check access right on log level
	    if(StringUtil.isNotEmpty(accessOnPageRef))
	    {
			SessionCO sessionCO = returnSessionObject();
			CommonLibBO commonLibBO = returnCommonLibBO();
			String old_val=null;
			String old_log_by_user_val=null;
	    String userName = ConstantsCommon.TRUE.equals(isClusterCall)?clusterLogUserName:sessionCO.getUserName();
	    String applicationName = ConstantsCommon.TRUE.equals(isClusterCall)?clusterLogAppName:sessionCO.getCurrentAppName();
	    if(Log.getInstance().getDefaultLevel() != null)
	    {
	    old_val = log.getDefaultLevel().getName().toUpperCase(Locale.ENGLISH);
	    }
	    
	    boolean old_log_by_user = log.isLogByUserEnabled(userName);
	    old_log_by_user_val = old_log_by_user ? ConstantsCommon.TRUE : ConstantsCommon.FALSE;
	    // updating log level at presentation layer
	    log.debug("Updating Log Level at presntation layer to "+currLogLevel+" for "+ConstantsCommon.APP_NAME);
	    Log.getInstance().changeLogLevel(currLogLevel);
	    log.debug("Log Level updated successfully to "+currLogLevel+" at presntation layer for "+ConstantsCommon.APP_NAME);
	    // updating log level at service layer
	    commonLibBO.updateLogLevel(currLogLevel);
	    
	    String logForUser = null;
	    if(logByLoggedInUser != null)
	    {
		logForUser = userName;
		// updating log by user at presentation layer
		boolean logByUserEnabled = BigDecimal.ONE.compareTo(logByLoggedInUser) == 0;
		if(logByUserEnabled != old_log_by_user)
		{  
			log.debug("Updating Log by user at presntation layer for " + userName + " in " + ConstantsCommon.returnCurrentAppName());
			Log.updateLogByUser(logForUser, logByUserEnabled);
			log.debug("Log by user updated successfully for " + userName + " at presntation layer in " + ConstantsCommon.returnCurrentAppName());
			// updating log by user at service layer
			commonLibBO.updateLogByUser(userName, logByUserEnabled);
		    }
	    }

		if(logByOtherUser != null && logByOtherUserId != null && !logByOtherUserId.isEmpty())
		{
		    boolean logByOtherUserEnabled = ( BigDecimal.ONE.compareTo(logByOtherUser) == 0 );
		    // updating log by user at presentation layer
		    log.debug("Updating Log by user at presntation layer for " + logByOtherUserId + " in " + ConstantsCommon.returnCurrentAppName());
		    Log.updateLogByUser(logByOtherUserId, logByOtherUserEnabled);
		    log.debug("Log by user updated successfully for " + logByOtherUserId + " at presntation layer in " + ConstantsCommon.returnCurrentAppName());
		    // updating log by user at service layer
		    commonLibBO.updateLogByUser(logByOtherUserId, logByOtherUserEnabled);
		}
	    
	 	 if (!ConstantsCommon.TRUE.equals(isClusterCall))
	 	 {
	 		// TP 820336
	 		//Call Audit: False means it's not a Retrieve operation and send old value
	 		changesDone = customInitAudit(false,old_val,old_log_by_user_val,logForUser);
	 		
	 		set_msgTitle(clusterLogging(userName, applicationName, NumberUtil.emptyDecimalToZero(logByLoggedInUser).toString(), NumberUtil.emptyDecimalToZero(logByOtherUser).toString(), logByOtherUserId));
			if (StringUtil.isEmptyString(userName) || StringUtil.isEmptyString(applicationName))
			{
				return ERROR_ACTION;
			}
	 	 }
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    /**
     * TP#456163
     * Method to clear the cache of remote instances of the application in a clustered environment
     * This method is effective when PathRemoting.global.cluster.enabled is true
     * And PathRemoting.global.cluster.physical.other.nodes contains at least 1 URL
     */
      private String clusterLogging(String userName, String applicationName, String logByLoggedInUser, String logByOtherUser, String logByOtherUserId)
      {
    	  String requestUrl = "", contextPath = "", messageURL = "", msgText = "\n";
    	  try
    	  {
    		  String clusterEnabled = StringUtil.nullEmptyToValue(
    				  PathPropertyUtil.getPathRemotingProp("PathRemoting", "global.cluster.enabled"),
    				  Boolean.FALSE.toString());
    		  String physicalNodes = StringUtil.nullToEmpty(
    				  PathPropertyUtil.getPathRemotingProp("PathRemoting", "global.cluster.physical.other.nodes"));
    		  String[] physicalUrls = physicalNodes.trim().split(",");
    		  if(ConstantsCommon.TRUE.equals(clusterEnabled) && physicalUrls.length > 0
    				  && physicalUrls[0].trim().length() > 0)
    		  {
    			  HttpServletRequest request = ServletActionContext.getRequest();

    			  contextPath = request.getContextPath();
    			  contextPath = contextPath.startsWith("/") ? contextPath.substring(1) : contextPath;

    			  String urlParameters = "isClusterCall=true&clusterLogUserName="+userName+"&clusterLogAppName="+applicationName+"&currLogLevel="+currLogLevel+"&logByLoggedInUser="+logByLoggedInUser
    					  +"&logByOtherUser="+logByOtherUser+"&logByOtherUserId="+logByOtherUserId;
    			  urlParameters = SecurityUtils.returnAutomaticLoginEncryptedParam(urlParameters);
    			  urlParameters = StringUtil.nullToEmpty(urlParameters).concat("&PARAMPATH=1");
    			  byte[] postData = urlParameters.getBytes(ConstantsCommon.ENCODING_TYPE_UTF);
    			  int postDataLength = postData.length;

    			  // check if an instance is already running, and use it if found
    			  for(String singleUrl : physicalUrls)
    			  {
    				  //#BUG 542852 redirecting clear cluster cache to unsecure method.
    				  requestUrl = singleUrl.concat(contextPath).concat("/login/logging/UpdateLogLevel");
    				  messageURL = singleUrl.concat(contextPath);
    				  URL url = new URL(requestUrl);
    				  HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    				  conn.setDoOutput(true);
    				  conn.setRequestMethod("POST");
    				  conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    				  conn.setRequestProperty("charset", ConstantsCommon.ENCODING_TYPE_UTF);
    				  conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
    				  conn.setRequestProperty("Accept", "application/json");

    				  DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
    				  wr.write(postData);
    				  wr.flush();
    				  wr.close();

    				  if(conn.getResponseCode() == 200)
    				  {
    					  msgText = msgText.concat("Log level updated succefully").concat(" ").concat(messageURL).concat(" \n");
    				  }
    				  else
    				  {
    					  msgText = msgText.concat("Log level failed update").concat(" ").concat(messageURL).concat(" \n");
    				  }
    				  conn.disconnect();
    			  }
    		  }
    	  }
    	  catch(Exception e)
    	  {
    		  log.error(e, "Log level failed update".concat(" ").concat(messageURL));
    		  msgText = msgText.concat("Log level failed update").concat(" ").concat(messageURL).concat(" \n");
        	  addActionError(msgText);
    	  }
    	  return msgText;
      }
    /**
     * Load the user's printers list.
     */
    public String loadUsrPrntrList()
    {
	try
	{
	    String UsrPrntrAccessRight = returnAccessRightByProgRef(ConstantsCommon.DEFAULT_PRINTER_AXS);
	    if(UsrPrntrAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }

	    SessionCO sessCO = returnSessionObject();
	    CustomizationSC sc = new CustomizationSC();
	    sc.setUserId(sessCO.getUserName());
	    usrPrinters = customizationBO.loadUsrPrntrList(sc);
	    usrPrinterCount = usrPrinters.size();
	    if(usrPrinterCount==0)
	    {
		throw new BOException(MessageCodes.COULD_NOT_FIND_ANY_DEFINED_PRINTER);
	    }
	    userDefPrntr = sessCO.getUsrDefPrinter();
	    return "success_prntr_list";
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
    }

    /**
     * Load the user's printers list.
     */
    public String setUsrDefPrntr()
    {
	try
	{
	    SessionCO sessCO = returnSessionObject();
	    sessCO.setUsrDefPrinter(userDefPrntr);
	    return "jsonSuccess";
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
    }
    
    
    public String exportFieldCustomization()
    {
	try
	{
	    //SYS_PARAM_SCREEN_DISPLAYVO scrDispVO = custSC.getScreenDispVO();
    	    SessionCO sesCO = returnSessionObject();
    	    custSC.setAppName(sesCO.getCurrentAppName());
    	    custSC.setCompCode(sesCO.getCompanyCode());
	    StringBuffer scriptBuff = customizationBO.returnCustExp(custSC);
	    byte[] scriptByte = scriptBuff.toString().getBytes(FileUtil.DEFAULT_FILE_ENCODING);
	    scriptByte = UnicodeUtil.addBOMToBytes(scriptByte, FileUtil.DEFAULT_FILE_ENCODING);
	    scriptStream = new ByteArrayInputStream(scriptByte);
	    ServletActionContext.getResponse().setHeader("Set-Cookie", "fileDownload=true; path=/");
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		setScriptStream(new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING)));
	    }
	    catch(UnsupportedEncodingException e1)
	    {
		log.error(e1, "Error in reading the error message");
	    }
	    return "fileError";
	}
	return "saveScript";
    }
    
    /**
     * Method to get the user selected CSV file and send it as byte[] to the BO class
     * @return String
     */
        public String importCustomizationFile()
        {
    	try
    	{
    	    //limit the size of the file to be below of 200 MB = 200000000 bytes 
    	    byte[] fileBytes = PathFileSecure.readFileToByteArray(file,200000000);
    	    custSC.setImportedBytes(fileBytes);
    	    custSC.setIsSybase(ConstantsCommon.CURR_DBMS_SYBASE);
    	    customizationBO.importCustomization(custSC);
    	}
    	catch(Exception e)
    	{
    	    handleException(e, null, null);
    	}
    	return "fileSuccess";
        }
    
    public String loadExpImpCustom()
    {
	try
	{
	    String impExpAccessRight = returnAccessRightByProgRef(ConstantsCommon.EXP_IMP_CUST_OPT);
	    if(impExpAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
	return "loadExpImpCustom";
    }
    
    public String callDefaultDependency()
    {
//	Map<String,SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String,SYS_PARAM_SCREEN_DISPLAYVO>();
//	    SYS_PARAM_SCREEN_DISPLAYVO newDisplay = new SYS_PARAM_SCREEN_DISPLAYVO();
//	    newDisplay.setIS_MANDATORY(BigDecimal.ZERO);
//	    hm.put("long_desc_eng_LM01MT", newDisplay);
//	    getAdditionalScreenParams().putAll(hm);

	return SUCCESS;
    }
    /**
     * [MarwanMaddah]
     * used to check if the current user has access rights to approve management 
     * and if there is a record inside the mirror table needs to be approved 
     * and based on that will construct the menus that will appear for customization management.
     * @return
     */
    public String checkEventsAccess()
    {
	String returnResult = "jsonSuccess";
	try {
	    
	    String scrSettingAccessRight = returnAccessRightByProgRef(ConstantsCommon.SETTINGS_CONFIG_OPT);
	    if(scrSettingAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }

	    SessionCO session = returnSessionObject();
	    String currAppName = session.getCurrentAppName();
	    
	    mirrorProcess = ConstantsCommon.ONE;
	    int tableIsAvailable = customizationBO.checkTableAvailablity();
	    if(tableIsAvailable == 0)
	    {
		mirrorProcess = ConstantsCommon.ZERO;
		return returnResult;
	    }
	    
	    String[] opts = {ConstantsCommon.CUST_APPROVE_OPT, ConstantsCommon.CUST_MAINTENANCE_OPT};
	    HashMap<String, String> accessOpts = returnAccessRightByProgRef(opts, currAppName);	
	    
	    if(accessOpts!=null && !accessOpts.isEmpty())
	    {		
		custMaintRight   = accessOpts.get(ConstantsCommon.CUST_MAINTENANCE_OPT+"_"+currAppName);
		custApproveRight = accessOpts.get(ConstantsCommon.CUST_APPROVE_OPT+"_"+currAppName);
		/**
		 * in case the current user has access right to approve customization 
		 * will check if there is a record to be approved on the Mirror table to display the approve menu 
		 * otherwise it will be hidden 
		 */
		if(!StringUtil.nullToEmpty(custApproveRight).isEmpty())
		{
		    if(BigDecimal.ONE.equals(commonScreen))
		    {
			set_pageRef(ConstantsCommon.SETTINGS_CONFIG_OPT);
		    }
		    
		    String progRef =  StringUtil.nullEmptyToValue(get_pageRef(), ConstantsCommon.PROGREF_ROOT);
		    String currElemId = StringUtil.nullToEmpty(elemId) ;
		    String currElemName = StringUtil.nullToEmpty(elemName);
		    
		    // check if Livesearch
		    if(currElemId.startsWith("lookuptxt_"))
		    {
			currElemId = currElemId.replace("lookuptxt_", "") ;
		    }
		    
		    // check if concatinated with Page Ref
		    if(currElemId.endsWith("_"+progRef))
		    {
			if(elemName!=null && elemName.equals(currElemId))
			{
			    currElemName = currElemName.replace("_"+progRef, "");
			}
			currElemId = currElemId.replace("_"+progRef, "");
			
		    }
		    
		    /**
		     * 
		     */
		    if(progRef != null && progRef.endsWith("_ALERT"))
		    {
			progRef = progRef.substring(0, progRef.indexOf("_ALERT"));
		    }
		    /**
		     * 
		     */
		    custCO.setCutomizationPROG_REF(progRef);
		    custCO.getScreenDispVO().setCOMP_CODE(session.getCompanyCode());
		    custCO.getScreenDispVO().setAPP_NAME(session.getCurrentAppName());
		    custCO.getScreenDispVO().setELEMENT_ID(currElemId);
		    custCO.getScreenDispVO().setELEMENT_NAME(currElemName);
		    
		    int mirDataCount = customizationBO.checkScreenDisplayMirData(custCO);
		    if(mirDataCount == 0)
		    {
			custApproveRight = null;  
		    }
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null); 
	}
	return returnResult;
    }
    /**
     * 
     *
     */
    public String getElemName()
    {
        return elemName;
    }
    public void setElemName(String elemName)
    {
        this.elemName = elemName;
    }
    public String getElemId()
    {
        return elemId;
    }
    public void setElemId(String elemId)
    {
        this.elemId = elemId;
    }
    public void setCustomizationBO(CustomizationBO customizationBO)
    {
        this.customizationBO = customizationBO;
    }
    public CustomizationCO getCustCO()
    {
        return custCO;
    }
    public void setCustCO(CustomizationCO custCO)
    {
        this.custCO = custCO;
    }
    public String getForTrans()
    {
        return forTrans;
    }
    public void setForTrans(String forTrans)
    {
        this.forTrans = forTrans;
    }
    public String getViewSQL()
    {
        return viewSQL;
    }
    public void setViewSQL(String viewSQL)
    {
        this.viewSQL = viewSQL;
    }
    public void setLanguageVO(List<SYS_PARAM_LANGUAGESVO> languageVO)
    {
	this.languageVO = languageVO;
    }
    public List<SYS_PARAM_LANGUAGESVO> getLanguageVO()
    {
	return languageVO;
    }
    public List<SelectCO> getLanguageSelect()
    {
        return languageSelect;
    }
    /**
     * @return the visibilityCmbList
     */
    public List<SelectCO> getVisibilityCmbList()
    {
        return visibilityCmbList;
    }
    /**
     * @param visibilityCmbList the visibilityCmbList to set
     */
    public void setVisibilityCmbList(List<SelectCO> visibilityCmbList)
    {
        this.visibilityCmbList = visibilityCmbList;
    }
    /**
     * @return the readonlyCmbList
     */
    public List<SelectCO> getReadonlyCmbList()
    {
        return readonlyCmbList;
    }
    /**
     * @param readonlyCmbList the readonlyCmbList to set
     */
    public void setReadonlyCmbList(List<SelectCO> readonlyCmbList)
    {
        this.readonlyCmbList = readonlyCmbList;
    }
    /**
     * @return the requiredCmbList
     */
    public List<SelectCO> getRequiredCmbList()
    {
        return requiredCmbList;
    }
    /**
     * @param requiredCmbList the requiredCmbList to set
     */
    public void setRequiredCmbList(List<SelectCO> requiredCmbList)
    {
        this.requiredCmbList = requiredCmbList;
    }
    /**
     * @return the allowZeroCmbList
     */
    public List<SelectCO> getAllowZeroCmbList()
    {
        return allowZeroCmbList;
    }
    /**
     * @param allowZeroCmbList the allowZeroCmbList to set
     */
    public void setAllowZeroCmbList(List<SelectCO> allowZeroCmbList)
    {
        this.allowZeroCmbList = allowZeroCmbList;
    }
    public String getShowSaveAsSeries()
    {
        return showSaveAsSeries;
    }
    public void setShowSaveAsSeries(String showSaveAsSeries)
    {
        this.showSaveAsSeries = showSaveAsSeries;
    }
    public String getHelpScreenURL()
    {
        return helpScreenURL;
    }
    public void setHelpScreenURL(String helpScreenURL)
    {
        this.helpScreenURL = helpScreenURL;
    }
    /**
     * @return the fromButton
     */
    public String getFromButton()
    {
        return fromButton;
    }
    /**
     * @param fromButton the fromButton to set
     */
    public void setFromButton(String fromButton)
    {
        this.fromButton = fromButton;
    }
    public String getCurrLogLevel()
    {
        return currLogLevel;
    }
    public void setCurrLogLevel(String currLogLevel)
    {
        this.currLogLevel = currLogLevel;
    }
    /**
     * @return the commonScreen
     */
    public BigDecimal getCommonScreen()
    {
        return commonScreen;
    }
    /**
     * @param commonScreen the commonScreen to set
     */
    public void setCommonScreen(BigDecimal commonScreen)
    {
        this.commonScreen = commonScreen;
    }
    public List getUsrPrinters()
    {
        return usrPrinters;
    }
    public int getUsrPrinterCount()
    {
        return usrPrinterCount;
    }
    public void setUsrPrinterCount(int usrPrinterCount)
    {
        this.usrPrinterCount = usrPrinterCount;
    }
    public String getUserDefPrntr()
    {
        return userDefPrntr;
    }
    public void setUserDefPrntr(String userDefPrntr)
    {
        this.userDefPrntr = userDefPrntr;
    }
    public String getFromText()
    {
        return fromText;
    }
    public void setFromText(String fromText)
    {
        this.fromText = fromText;
    }
    public String getFromTextArea()
    {
        return fromTextArea;
    }
    public void setFromTextArea(String fromTextArea)
    {
        this.fromTextArea = fromTextArea;
    }
    public String getAllowDefValCust()
    {
        return allowDefValCust;
    }
    public void setAllowDefValCust(String allowDefValCust)
    {
        this.allowDefValCust = allowDefValCust;
    }
    public String getMode()
    {
        return mode;
    }
    public void setMode(String mode)
    {
        this.mode = mode;
    }
    public void setFromCollaps(String fromCollaps)
    {
	this.fromCollaps = fromCollaps;
    }
    public String getFromCollaps()
    {
	return fromCollaps;
    }
    public List<SelectCO> getActivityTypeCmbList()
    {
        return activityTypeCmbList;
    }

    public String getAllowDisableUsrCustRight()
    {
        return allowDisableUsrCustRight;
    }

    public void setAllowDisableUsrCustRight(String allowDisableUsrCustRight)
    {
        this.allowDisableUsrCustRight = allowDisableUsrCustRight;
    }

    public String getFromLiveSearch()
    {
        return fromLiveSearch;
    }

    public void setFromLiveSearch(String fromLiveSearch)
    {
        this.fromLiveSearch = fromLiveSearch;
    }
    
    public InputStream getScriptStream()
    {
        return scriptStream;
    }
    public void setScriptStream(InputStream scriptStream)
    {
        this.scriptStream = scriptStream;
    }
    
    public void setUploadCust(File file)
    {
        this.file = file;
    }
    public void setCustSC(CustomizationSC custSC)
    {
        this.custSC = custSC;
    }

    public CustomizationSC getCustSC()
    {
        return custSC;
    }
    
    public String getFromDatePicker()
    {
        return fromDatePicker;
    }

    public void setFromDatePicker(String fromDatePicker)
    {
        this.fromDatePicker = fromDatePicker;
    }

    public String getEnableAfterExecution()
    {
        return enableAfterExecution;
    }

    public void setEnableAfterExecution(String enableAfterExecution)
    {
        this.enableAfterExecution = enableAfterExecution;
    }

    /**
     * @return the custActionType
     */
    public String getCustActionType()
    {
        return custActionType;
    }

    /**
     * @param custActionType the custActionType to set
     */
    public void setCustActionType(String custActionType)
    {
        this.custActionType = custActionType;
    }

    /**
     * @return the showMaintenanceMenu
     */
    public String getShowMaintenanceMenu()
    {
        return showMaintenanceMenu;
    }

    /**
     * @param showMaintenanceMenu the showMaintenanceMenu to set
     */
    public void setShowMaintenanceMenu(String showMaintenanceMenu)
    {
        this.showMaintenanceMenu = showMaintenanceMenu;
    }

    /**
     * @return the showApproveMenu
     */
    public String getShowApproveMenu()
    {
        return showApproveMenu;
    }

    /**
     * @param showApproveMenu the showApproveMenu to set
     */
    public void setShowApproveMenu(String showApproveMenu)
    {
        this.showApproveMenu = showApproveMenu;
    }

    /**
     * @return the showViewMenu
     */
    public String getShowViewMenu()
    {
        return showViewMenu;
    }

    /**
     * @param showViewMenu the showViewMenu to set
     */
    public void setShowViewMenu(String showViewMenu)
    {
        this.showViewMenu = showViewMenu;
    }

    /**
     * @return the custMaintRight
     */
    public String getCustMaintRight()
    {
        return custMaintRight;
    }

    /**
     * @param custMaintRight the custMaintRight to set
     */
    public void setCustMaintRight(String custMaintRight)
    {
        this.custMaintRight = custMaintRight;
    }

    /**
     * @return the custApproveRight
     */
    public String getCustApproveRight()
    {
        return custApproveRight;
    }

    /**
     * @param custApproveRight the custApproveRight to set
     */
    public void setCustApproveRight(String custApproveRight)
    {
        this.custApproveRight = custApproveRight;
    }

    public String getFromTab()
    {
        return fromTab;
    }

    public void setFromTab(String fromTab)
    {
        this.fromTab = fromTab;
    }

    /**
     * @return the mirrorProcess
     */
    public String getMirrorProcess()
    {
        return mirrorProcess;
    }

    /**
     * @param mirrorProcess the mirrorProcess to set
     */
    public void setMirrorProcess(String mirrorProcess)
    {
        this.mirrorProcess = mirrorProcess;
    }

    /**
     * @return the logByLoggedInUser
     */
    public BigDecimal getLogByLoggedInUser()
    {
        return logByLoggedInUser;
    }

    /**
     * @param logByLoggedInUser the logByLoggedInUser to set
     */
    public void setLogByLoggedInUser(BigDecimal logByLoggedInUser)
    {
        this.logByLoggedInUser = logByLoggedInUser;
    }

    /**
     * @return the logByOtherUser
     */
    public BigDecimal getLogByOtherUser()
    {
        return logByOtherUser;
    }

    /**
     * @param logByOtherUser the logByOtherUser to set
     */
    public void setLogByOtherUser(BigDecimal logByOtherUser)
    {
        this.logByOtherUser = logByOtherUser;
    }

    /**
     * @return the logByOtherUserId
     */
    public String getLogByOtherUserId()
    {
        return logByOtherUserId;
    }

    /**
     * @param logByOtherUserId the logByOtherUserId to set
     */
    public void setLogByOtherUserId(String logByOtherUserId)
    {
        this.logByOtherUserId = logByOtherUserId;
    }

    /**
     * @return the logByUserMsg
     */
    public String getLogByUserMsg()
    {
        return logByUserMsg;
    }

    /**
     * @param logByUserMsg the logByUserMsg to set
     */
    public void setLogByUserMsg(String logByUserMsg)
    {
        this.logByUserMsg = logByUserMsg;
    }

    /**
     * @return the changesDone
     */
    public String getChangesDone()
    {
        return changesDone;
    }

    /**
     * @param changesDone the changesDone to set
     */
    public void setChangesDone(String changesDone)
    {
        this.changesDone = changesDone;
    }

	public void setIsClusterCall(String isClusterCall) {
		this.isClusterCall = isClusterCall;
	}

	public void setClusterLogUserName(String clusterLogUserName) {
		this.clusterLogUserName = clusterLogUserName;
	}

	public void setClusterLogAppName(String clusterLogAppName) {
		this.clusterLogAppName = clusterLogAppName;
	}

	/**
	 * @return the fromSelectBox
	 */
	public String getFromSelectBox()
	{
	    return fromSelectBox;
	}

	/**
	 * @param fromSelectBox the fromSelectBox to set
	 */
	public void setFromSelectBox(String fromSelectBox)
	{
	    this.fromSelectBox = fromSelectBox;
	}
}
