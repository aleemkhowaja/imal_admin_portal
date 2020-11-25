/**
 * 
 */
package com.path.actions.common.customization.object;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.customization.object.ObjectCustomizationBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.CustomElementActivitiesSC;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.customization.button.SysParamGlobalActArgMapSC;
import com.path.vo.common.customization.object.ObjectCustomizationCO;
import com.path.vo.common.customization.object.ObjectCustomizationSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

/**
 * @author marwanmaddah
 *
 */
public class ObjectCustomizationMainAction extends GridBaseAction
{
    private String         objectName; 
    private String         objectId;
    private String         objectType;
    private String 	   viewSQL; //value of the customization SQL
    private String         allowDisableUsrCustRight;
    private List<SelectCO> visibilityCmbList;
    private List<SelectCO> readonlyCmbList;
    private List<SelectCO> addDeleteCmbList;
    private BigDecimal     commonScreen;
    private ObjectCustomizationCO custCO = new ObjectCustomizationCO();
    private ObjectCustomizationSC custSC = new ObjectCustomizationSC();
    private ObjectCustomizationBO objectCustomizationBO;
    private InputStream scriptStream;
    

    private File file;
    //[TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
    private BigDecimal fromLiveSearch;
    private Boolean readOnlyFlag = false;
    //End-[TP#1043972]
    /**
     * 
     * @return
     */
    public String loadCustMaintPage()
    {
	try
	{
	    SessionCO sessCO = returnSessionObject();
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
		String progRef = StringUtil.nullEmptyToValue(get_pageRef(), ConstantsCommon.PROGREF_ROOT);
		String currElemId = StringUtil.nullToEmpty(objectId);
		/**
		 * check if concatinated with Page Ref
		 */
		if(currElemId.endsWith("_" + progRef))
		{
		    currElemId = currElemId.replace("_" + progRef, "");
		}
                if(currElemId.startsWith("gbox_"))
                {
                    currElemId = currElemId.replace("gbox_", ""); 
                }
                
		ObjectCustomizationSC criteria = new ObjectCustomizationSC();
		criteria.setAppName(appName);
		criteria.setProgRef(progRef);
		criteria.setCompCode(BigDecimal.ZERO);
		criteria.setObjectName(objectName);
		criteria.setObjectId(currElemId);
		criteria.setDefaultAppName(ConstantsCommon.IMAL_APP_NAME);
		criteria.setObjectType(objectType);
		Boolean isGridReadOnly = custCO.getIsGridReadOnly();
		custCO = objectCustomizationBO.returnObjectCustomization(criteria);
		
		custCO.setCutomizationPROG_REF(progRef);
		custCO.getSysParamObjDisplayVO().setOBJECT_ID(currElemId);
		custCO.getSysParamObjDisplayVO().setOBJECT_TYPE(ConstantsCommon.PREF_OBJECT_TYPE_GRID);
		custCO.setAppName(appName);
		custCO.setIsGridReadOnly(isGridReadOnly);
		if(custCO.getCustDisplayMgnt()!=null && !custCO.getCustDisplayMgnt().isEmpty())
		{
		    getAdditionalScreenParams().putAll(custCO.getCustDisplayMgnt());
		}
//		/**
//		 * in case disable customization is true an action error will be
//		 * added to JSP and the Customization screen will be on ReadOnly
//		 * mode
//		 */
//		Boolean disableCust = custCO.getDisableCust();
//		if(disableCust)
//		{
//		    addActionError(getText("disable_customization_key"));
//		}

		CommonLibSC commLibSC = new CommonLibSC();
		commLibSC.setProgRef(ConstantsCommon.ALLOW_DISABLE_USER_CUSTOMIZATION_OPT);
		commLibSC.setAppName(StringUtil.nullToEmpty(sessCO.getCurrentAppName()));
		commLibSC.setCompCode(sessCO.getCompanyCode());
		commLibSC.setBranchCode(sessCO.getBranchCode());
		commLibSC.setUserId(sessCO.getUserName());
		setAllowDisableUsrCustRight(returnCommonLibBO().checkUserPrivileges(commLibSC));
		/**
		 *  set readonlyScreen if Business prevent from changing, and not
		 *  opening business tooltip translation
		 */
		if((BigDecimal.ONE.equals(custCO.getSysParamObjDisplayVO().getBUS_RELATED()))
			|| (BigDecimal.ONE.equals(custCO.getSysParamObjDisplayVO().getIS_ADM_CUST_DIS_YN())
				&& StringUtil.nullToEmpty(allowDisableUsrCustRight).isEmpty()))
		{
		    set_recReadOnly("true");
		}
		fillComboBox();
	    }
	    /**
	     *  Access rights for export/import screen customization.
	     */
	    setExpImpCustRight(returnAccessRightByProgRef(ConstantsCommon.EXP_IMP_CUST_OPT));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
	return SUCCESS;
    }
    public String updateChanges()
    {
	try
	{
	    SessionCO sessCO =  returnSessionObject();
	    String appName = StringUtil.nullEmptyToValue(sessCO.getCurrentAppName(), ConstantsCommon.IMAL_APP_NAME);
	    custCO.getSysParamObjDisplayVO().setAPP_NAME(appName);
	    custCO.setLanguage(sessCO.getLanguage());
	    custCO.setUserId(sessCO.getUserName());
	    custCO.setRunningDate(sessCO.getRunningDateRET());
	    ArrayList lstAdd = null,lstMod = null,lstDel = null;
	    if( StringUtil.isNotEmpty(custCO.getObjectCustomizationDetailsGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(custCO.getObjectCustomizationDetailsGridUpdate(),
			ObjectCustomizationSC.class, true);
		    
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<ObjectCustomizationSC> objectCustomizationSCList = gu.getLstAllRec();
		    if(objectCustomizationSCList != null && !objectCustomizationSCList.isEmpty())
		    {
			custCO.setObjectCustomizationSCList(objectCustomizationSCList);
		    }
		}
	    }
	    
	    if(StringUtil.isNotEmpty(custCO.getCustomizationCO().getCustomElementActivitiesGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(custCO.getCustomizationCO().getCustomElementActivitiesGridUpdate(),
			CustomElementActivitiesSC.class, true);

		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<CustomElementActivitiesSC> customElementActivitiesSCList = gu.getLstAllRec();
		    if(customElementActivitiesSCList != null && !customElementActivitiesSCList.isEmpty())
		    {
			custCO.getCustomizationCO().setCustomElementActivitiesSCList(customElementActivitiesSCList);
		    }
		}
	    }

	    if((ButtonCustomizationConstants.ACTIVITY_TYPE.DOUBLECLICK
		    .equals(custCO.getCustomizationCO().getScreenDispVO().getACTIVITY_TYPE()))
		    && StringUtil.isNotEmpty(custCO.getCustomizationCO().getButtonCustParamMapGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(custCO.getCustomizationCO().getButtonCustParamMapGridUpdate(),
			SysParamGlobalActArgMapSC.class, true);

		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<SysParamGlobalActArgMapSC> buttonCustParamsMapSCList = gu.getLstAllRec();
		    if(buttonCustParamsMapSCList != null && !buttonCustParamsMapSCList.isEmpty())
		    {
			custCO.getCustomizationCO().setButtonCustParamsMapSCList(buttonCustParamsMapSCList);
		    }
		}
	    }
	    setListCustActivityOnCols();
	    objectCustomizationBO.updateObjCustomization(custCO);
//	    if((lstAdd != null && !lstAdd.isEmpty()) || (lstMod != null && !lstMod.isEmpty()) || (lstDel != null && !lstDel.isEmpty()))
//	    {
//		synchronized(CachedConstantsCommon.busTransInfo)
//		{
//		    CachedConstantsCommon.busTransInfo = new HashMap<String, Map<String,FieldsBusTransCO>>();
//		}
//	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    /**
     * [TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
     * @createdBy Sajjad Soomro
     * @description if custom element activity grid is not empty and has list of records then
     * get grid all records and set it into objCustomElementActivitiesSCList of CustomizationCO
     */
    private void setListCustActivityOnCols()
    {
	if(StringUtil.isNotEmpty(custCO.getCustomizationCO().getObjCustomElementActivitiesGridUpdate()))
	{
	    GridUpdates gu = getGridUpdates(custCO.getCustomizationCO().getObjCustomElementActivitiesGridUpdate(), CustomElementActivitiesSC.class, true);
	    if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
	    {
		List<CustomElementActivitiesSC> customElementActivitiesSCList = gu.getLstAllRec();
		if(customElementActivitiesSCList != null && !customElementActivitiesSCList.isEmpty())
		{
		    custCO.getCustomizationCO().setObjCustomElementActivitiesSCList(customElementActivitiesSCList);
		}
	    }
	    /**
	     * if parameters of custom element activity grid is not empty and has list of records then
	     * get grid all records and set it into objCustParamsMapSCList of CustomizationCO
	     */
	    if(StringUtil.isNotEmpty(custCO.getCustomizationCO().getObjCustParamMapGridUpdate()))
	    {
		gu = getGridUpdates(custCO.getCustomizationCO().getObjCustParamMapGridUpdate(), SysParamGlobalActArgMapSC.class, true);
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<SysParamGlobalActArgMapSC> objCustParamsMapSCList = gu.getLstAllRec();
		    if(objCustParamsMapSCList != null && !objCustParamsMapSCList.isEmpty())
		    {
			custCO.getCustomizationCO().setObjCustParamsMapSCList(objCustParamsMapSCList);
		    }
		}
	    }
	}
    }
    /**
     * [TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
     * @createdBy Sajjad Soomro
     * @description this function is used to save/update the records of the Grids Custom Activity On COlumn and its Parameters
     */
    public String updateCustActivityOnColumn()
    {
	try
	{
	    SessionCO sessCO =  returnSessionObject();
	    String appName = StringUtil.nullEmptyToValue(sessCO.getCurrentAppName(), ConstantsCommon.IMAL_APP_NAME);
	    custCO.getSysParamObjDisplayVO().setAPP_NAME(appName);
	    custCO.setLanguage(sessCO.getLanguage());
	    custCO.setUserId(sessCO.getUserName());
	    custCO.setRunningDate(sessCO.getRunningDateRET());
	    setListCustActivityOnCols();
	    objectCustomizationBO.updateCustActivtyOnCols(custCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    /*953614 Specify Grid Filter Query Expression - Grid/Livesearch Customization Enhancements*/
    /**
     * validates a request filter-expression param against embedded validation engine
     */
    public String validateFilterExpression()
    {
	String filterExpression = custCO.getSysParamObjDisplayVO().getFILTER_EXPR();
	RequiredFieldsSC reqSc = CommonMethods.returnDummyRequiredFieldsSC();
	try
	{    
	    List<Map<String, Object>> generalParamsMap = CommonMethods
		    .returnBoolExpressionDataList(reqSc);
	    Object result = returnCommonLibBO().executeExpression(filterExpression, 0,
		    generalParamsMap, reqSc);
	    this.filterExpToValidate =  result.toString();
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    /*end: 953614*/
  	
    
    /**
     * fill combos management
     * 
     * @author marwanmaddah
     * @date Apr 10, 2014 void
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
	SelectCO addDeleteCO = null;
	visibilityCmbList = new ArrayList<SelectCO>();
	readonlyCmbList = new ArrayList<SelectCO>();
	addDeleteCmbList = new ArrayList<SelectCO>();
	/**
	 *  define the LOV of the button activity type
	 */
	SelectSC selSC = new SelectSC(ConstantsCommon.BUTTON_ACTIVITY_LOV_TYPE);
	/**
	 * [MarwanMaddah]:the length will be 4 in case the entity type is
	 * cifType to add hide_and_override_business and
	 * hide_and_override_business_based_on_expression management to the
	 * visibility
	 * ConstantsCommon.ENTITY_CIF_TYPE_DISPLAY.equals(StringUtil.nullToEmpty(custCO.getEntityType()))?4:2;
	 */
	int comboLength = 2;
	for(int i = 0; i <= comboLength; i++)
	{
	    visibilityCO = new SelectCO();
	    visibilityCO.setCode(String.valueOf(i));
	    if(i <= 2)
	    {
		readOnlyCO = new SelectCO();
		readOnlyCO.setCode(String.valueOf(i));

		requiredCO = new SelectCO();
		requiredCO.setCode(String.valueOf(i));
		
		addDeleteCO = new SelectCO(); 
		addDeleteCO.setCode(String.valueOf(i));
	    }
	    switch (i)
	    {
		case 0:
		    visibilityCO.setDescValue(getText("not_visibile_key"));
		    readOnlyCO.setDescValue(getText("editable_key"));
		    addDeleteCO.setDescValue(getText("not_visibile_key"));
		    break;
		case 1:
		    visibilityCO.setDescValue(getText("visibile_key"));
		    readOnlyCO.setDescValue(getText("readonly_key"));
		    addDeleteCO.setDescValue(getText("visibile_key"));
		    break;
		case 2:
		    visibilityCO.setDescValue(getText("visibility_expr_key"));
		    readOnlyCO.setDescValue(getText("readOnly_expr_key"));
		    addDeleteCO.setDescValue(getText("add_delete_expr_key"));
		    break;
		case 3:
		    visibilityCO.setDescValue(getText("hide_override_business_expr_key"));
		    // readOnlyCO.setDescValue(getText("readOnly_Expression_of_Business_key"));
		    break;
		case 4:
		    visibilityCO.setDescValue(getText("hide_override_business_key"));
		    // readOnlyCO.setDescValue(getText("readOnly_Expression_of_Business_key"));
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
		addDeleteCmbList.add(addDeleteCO);
	    }
	}
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
	  objectCustomizationBO.resetCustomization(custCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    public String exportObjectCustomization()
    {
	try
	{
    	    SessionCO sesCO = returnSessionObject();
    	    custSC.setAppName(sesCO.getCurrentAppName());
    	    ObjectCustomizationCO objCustCO = objectCustomizationBO.returnCustExp(custSC);
    	    String objCustCOValue = PathJSONUtil.strutsJsonSerialize(objCustCO, null, null, false, true);
	    scriptStream = new ByteArrayInputStream(objCustCOValue.getBytes());
		
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
    
    public String importObjectCustomization()
    {
	try
	{
	    if(file != null && file.isFile() && file.length() > 0)
	    {
		//limit the size of the file to be below of 200 MB = 200000000 bytes 
		byte[] content = PathFileSecure.readFileToByteArray(file,200000000);
		String result = new String(content);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(JsonMethod.ALL, Visibility.NONE);
		mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
	        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        ObjectCustomizationCO objCustCO = new ObjectCustomizationCO();
	        objCustCO =	mapper.readValue(result, ObjectCustomizationCO.class);
	        objCustCO.setOverrideCustImport(custSC.getOverrideCustImport());
		if(objCustCO != null)  
		{
		  objectCustomizationBO.insertObjectCustomization(objCustCO);
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return  "fileSuccess";
    }
    /**
     * get the sql for the customization.
     */
    public String loadCustViewSql()
    {
	try
	{
	    SessionCO sessCO = returnSessionObject();
	    String appName = StringUtil.nullEmptyToValue(sessCO.getCurrentAppName(), ConstantsCommon.IMAL_APP_NAME);
	    custCO.getSysParamObjDisplayVO().setAPP_NAME(appName);
	    custCO.setUserId(sessCO.getUserName());
	    if(StringUtil.isNotEmpty(custCO.getObjectCustomizationDetailsGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(custCO.getObjectCustomizationDetailsGridUpdate(),
			ObjectCustomizationSC.class, true);
		    
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<ObjectCustomizationSC> objectCustomizationSCList = gu.getLstAllRec();
		    if(objectCustomizationSCList != null && !objectCustomizationSCList.isEmpty())
		    {
			custCO.setObjectCustomizationSCList(objectCustomizationSCList);
		    }
		}
	    }
	    viewSQL = objectCustomizationBO.returnObjectCustSQL(custCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
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

    /**
     * @return the allowDisableUsrCustRight
     */
    public String getAllowDisableUsrCustRight()
    {
        return allowDisableUsrCustRight;
    }

    /**
     * @param allowDisableUsrCustRight the allowDisableUsrCustRight to set
     */
    public void setAllowDisableUsrCustRight(String allowDisableUsrCustRight)
    {
        this.allowDisableUsrCustRight = allowDisableUsrCustRight;
    }

    /**
     * @return the custCO
     */
    public ObjectCustomizationCO getCustCO()
    {
        return custCO;
    }

    /**
     * @param custCO the custCO to set
     */
    public void setCustCO(ObjectCustomizationCO custCO)
    {
        this.custCO = custCO;
    }

    /**
     * @param objectCustomizationBO the objectCustomizationBO to set
     */
    public void setObjectCustomizationBO(ObjectCustomizationBO objectCustomizationBO)
    {
        this.objectCustomizationBO = objectCustomizationBO;
    }

    /**
     * @return the objectType
     */
    public String getObjectType()
    {
        return objectType;
    }

    /**
     * @param objectType the objectType to set
     */
    public void setObjectType(String objectType)
    {
        this.objectType = objectType;
    }

    /**
     * @return the objectName
     */
    public String getObjectName()
    {
        return objectName;
    }

    /**
     * @param objectName the objectName to set
     */
    public void setObjectName(String objectName)
    {
        this.objectName = objectName;
    }

    /**
     * @return the objectId
     */
    public String getObjectId()
    {
        return objectId;
    }

    /**
     * @param objectId the objectId to set
     */
    public void setObjectId(String objectId)
    {
        this.objectId = objectId;
    }

    /**
     * @return the addDeleteCmbList
     */
    public List<SelectCO> getAddDeleteCmbList()
    {
        return addDeleteCmbList;
    }

    /**
     * @param addDeleteCmbList the addDeleteCmbList to set
     */
    public void setAddDeleteCmbList(List<SelectCO> addDeleteCmbList)
    {
        this.addDeleteCmbList = addDeleteCmbList;
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
    public ObjectCustomizationSC getCustSC()
    {
        return custSC;
    }
    public void setCustSC(ObjectCustomizationSC custSC)
    {
        this.custSC = custSC;
    }
    public String getViewSQL()
    {
        return viewSQL;
    }
    public void setViewSQL(String viewSQL)
    {
        this.viewSQL = viewSQL;
    }
    /**
     * @return the fromLiveSearch
     */
    public BigDecimal getFromLiveSearch()
    {
	return fromLiveSearch;
    }
    /**
     * @param fromLiveSearch the fromLiveSearch to set
     */
    public void setFromLiveSearch(BigDecimal fromLiveSearch)
    {
	this.fromLiveSearch = fromLiveSearch;
    }
    /**
     * @return the readOnlyFlag
     */
    public Boolean getReadOnlyFlag()
    {
	return readOnlyFlag;
    }
    /**
     * @param readOnlyFlag the readOnlyFlag to set
     */
    public void setReadOnlyFlag(Boolean readOnlyFlag)
    {
	this.readOnlyFlag = readOnlyFlag;
    }
    
}
