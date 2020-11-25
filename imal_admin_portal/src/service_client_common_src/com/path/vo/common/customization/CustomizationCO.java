package com.path.vo.common.customization;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.path.dbmaps.vo.FIELD_TECH_DETAILSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.struts2.lib.common.BaseObject;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.customization.button.SysParamGlobalActArgMapSC;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: deniskhaddad
 * 
 *          CustomizationCO.java used to hold Field Customization Details
 */
public class CustomizationCO extends BaseObject
{
    private SYS_PARAM_SCREEN_DISPLAYVO screenDispVO = new SYS_PARAM_SCREEN_DISPLAYVO();
    private Boolean readOnlyFlag = false;
    private Boolean visibleFlag = false;
    private Boolean allowZeroFlag = false;
    private Boolean arabicDepntFlag = false;
    private Boolean requiredFlag = false;
    private Boolean trimFlag = false;
    private Boolean specificFlag = false;
    private String cutomizationPROG_REF;
    private String fromTrans;// specify whether call coming from Business
			     // Translation only
    private String custBusTransUpdate;// used to send JSON updates for Business
				      // Translation
    private List<BusTransCO> addBusTrans; // used to store business translation
					  // to be added
    private List<BusTransCO> modBusTrans;// used to store business translation
					 // to be modified
    private List<BusTransCO> delBusTrans;// used to store business translation
					 // to be deleted

    private String autocompleteTags;// for auto-complete variables used in
				    // Expressions
    
    private String autocompleteValueValidTags;// for auto-complete variables used in
    					      // Value Validation Expressions for texts and textareas
    
    private String appName;//the current application name
    
    private String labelKeyDesc;
    
    private Boolean addFieldTechDetailsOnly = false;//flag to indication if we need to insert a FIELD_TECH_DETAILS with or without a related SYS_PARAM_SCREEN_DISPLAY
    /**
     * screen name used in displaying save as screen in SaveAs dialog
     */
    private String screenName;
    /**
     * parent screen Name, provided by user upon save as in SaveAs dialog with
     * duplicate Parents
     */
    private String screenParentName;
    /**
     * screen Reference (OPT) used in displaying save as screen in SaveAs dialog
     */
    private String screenRef;
    /**
     * screen Reference display Order (OPT) used in displaying save as screen in
     * SaveAs dialog
     */
    private BigDecimal screenDispOrder;
    /**
     * parent screen Reference (OPT) Constructed Automatically in case of SAVE
     * as with duplicate PArents
     */
    private String parentOfScreenRef;
    /**
     * screen Parent Reference (OPT) used to save parent for Save as screen
     */
    private String screenParentRef;
    /**
     * screen Parent Reference Display Order (OPT) used to save parent for Save
     * as screen
     */
    private BigDecimal screenParentDispOrder;
    /**
     * parent of screen Parent Reference (OPT) used to save parent for Save as
     * screen
     */
    private String parentOfScreenParentRef;
    /**
     * used in SaveAs screen for duplicate Parent Option.
     */
    private String dupParentFlag;
    /**
     * userId to whom SavedAs screen to be granted.
     */
    private String userId;
    /**
     * company code whom SavedAs screen to be granted.
     */
    private BigDecimal compCode;
    /**
     * branch Code whom SavedAs screen to be granted.
     */
    private BigDecimal branchCode;
    /**
     * used to store the main origin OPT for Saved As opt
     */
    private String originScreenRef;
    
    /**
     * used to store the category id 
     */
    private BigDecimal catergoryId;
    private HashMap<String,SYS_PARAM_SCREEN_DISPLAYVO> custDisplayMgnt = new HashMap<String,SYS_PARAM_SCREEN_DISPLAYVO>();
    private Boolean labelKeyCode = Boolean.FALSE;
    private Boolean labelExprKeyCode = Boolean.FALSE;
    private Boolean backgroundExprKeyCode = Boolean.FALSE;

    private String entityType;    
    /**
     * used to store the chosen parent ref of save as screen
     */
    private String saveAsParentRef;
    /**
     * choose if to save with corresponding series of related OPTs
     */
    private String saveAsSeries;
    /**
     * Prog REF of the series indicating if saved from save as series option and which series prog ref specified 
     */
    private String FROM_SERIES_PROG_REF;
    private String language;
    private Boolean disableCust;
    private String maintenanceFromMir;
    /**
     * used to define the records of DynamicScreenParamsMapCO taken from the parameters mapping grid and that should be saved to db 
     */
    private List<DynamicScreenParamsMapCO>  dynamicScreenParamsMapCOList = new ArrayList<DynamicScreenParamsMapCO>();
    /**
     * used to define the records of SysParamGlobalActArgMapSC taken from the parameters mapping grid and that should be saved to db 
     */
    private List<SysParamGlobalActArgMapSC>  buttonCustParamsMapSCList = new ArrayList<SysParamGlobalActArgMapSC>();
    
    private List<CustomElementActivitiesSC>  customElementActivitiesSCList = new ArrayList<CustomElementActivitiesSC>();

    /**
     * used to define the modified records of DynamicScreenParamsMapCO taken from the parameters mapping grid
     */
    private String dynScrParamMapGridUpdate;
    /**
     * used to define the modified records of ButtonCustParamsMapCO taken from the parameters mapping grid
     */
    private String buttonCustParamMapGridUpdate;
    
    /**
     * used to define the modified records of ButtonCustParamsMapCO taken from the element activity grid
     */
    private String customElementActivitiesGridUpdate;

    /**
     * the current running date from the sessionCO
     */
    private Date runningDate;
    
    
    /**
     *  specify whether the default value is enabled on texts or livesearch
     */
    private String allowDefValCust;
    /**
     * specify whether the text field has a mode "text" or "number"
     */
    private String mode;
    
    private String isVisibleAfterBrClosureYn;
    
    /**
     * the description of the button activity
     */
    private String activityDesc;
    
    /**
     * FIELD_TECH_DETAILS row data
     */
    private FIELD_TECH_DETAILSVO fieldTechDetailsVO = new  FIELD_TECH_DETAILSVO();

    private String MIN_TENOR_PERIODICTY_TYPE;
    
    private String actionType;
    
    /**
     * [MarwanMaddah]:
     * will be used to compare the current update date with the last database updated date
     * they should be equal to update the record, 
     * otherwise will inform user that the loaded record has been update by another user.
     */
    private Date dateUpdated;
    
    Object auditObj;
    private AuditRefCO auditRefCO; // for audit reference setting to be common
    
    /**
     * [TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
     *  objCustomElementActivitiesGridUpdate used to store json of custom element activity
     *  objCustomElementActivitiesSCList used to store activities list of custom element activities
     *  objCustParamMapGridUpdate used to store the json of the parmeters grid of the custom element activity
     *  objCustParamsMapSCList used to store parameters mapping list of custom element activities
     */
    private String objCustomElementActivitiesGridUpdate;
    private List<CustomElementActivitiesSC>  objCustomElementActivitiesSCList = new ArrayList<CustomElementActivitiesSC>();
    private String objCustParamMapGridUpdate;
    private List<SysParamGlobalActArgMapSC>  objCustParamsMapSCList = new ArrayList<SysParamGlobalActArgMapSC>();
    //End-[TP#1043972]
    
    public SYS_PARAM_SCREEN_DISPLAYVO getScreenDispVO()
    {
	return screenDispVO;
    }

    public void setScreenDispVO(SYS_PARAM_SCREEN_DISPLAYVO screenDispVO)
    {
	this.screenDispVO = screenDispVO;
    }

    public Boolean getReadOnlyFlag()
    {
	return readOnlyFlag;
    }

    public void setReadOnlyFlag(Boolean readOnlyFlag)
    {
	this.readOnlyFlag = readOnlyFlag;
    }

    public Boolean getVisibleFlag()
    {
	return visibleFlag;
    }

    public void setVisibleFlag(Boolean visibleFlag)
    {
	this.visibleFlag = visibleFlag;
    }

    public Boolean getAllowZeroFlag()
    {
	return allowZeroFlag;
    }

    public void setAllowZeroFlag(Boolean allowZeroFlag)
    {
	this.allowZeroFlag = allowZeroFlag;
    }

    public Boolean getArabicDepntFlag()
    {
	return arabicDepntFlag;
    }

    public void setArabicDepntFlag(Boolean arabicDepntFlag)
    {
	this.arabicDepntFlag = arabicDepntFlag;
    }

    public Boolean getRequiredFlag()
    {
	return requiredFlag;
    }

    public void setRequiredFlag(Boolean requiredFlag)
    {
	this.requiredFlag = requiredFlag;
    }

    public Boolean getTrimFlag()
    {
	return trimFlag;
    }

    public void setTrimFlag(Boolean trimFlag)
    {
	this.trimFlag = trimFlag;
    }

    public Boolean getSpecificFlag()
    {
	return specificFlag;
    }

    public void setSpecificFlag(Boolean specificFlag)
    {
	this.specificFlag = specificFlag;
    }

    public String getCutomizationPROG_REF()
    {
	return cutomizationPROG_REF;
    }

    public void setCutomizationPROG_REF(String cutomizationPROGREF)
    {
	cutomizationPROG_REF = cutomizationPROGREF;
    }

    public String getCustBusTransUpdate()
    {
	return custBusTransUpdate;
    }

    public void setCustBusTransUpdate(String custBusTransUpdate)
    {
	this.custBusTransUpdate = custBusTransUpdate;
    }

    @JSON(serialize = false)
    public List<BusTransCO> getAddBusTrans()
    {
	return addBusTrans;
    }

    public void setAddBusTrans(List<BusTransCO> addBusTrans)
    {
	this.addBusTrans = addBusTrans;
    }

    @JSON(serialize = false)
    public List<BusTransCO> getModBusTrans()
    {
	return modBusTrans;
    }

    public void setModBusTrans(List<BusTransCO> modBusTrans)
    {
	this.modBusTrans = modBusTrans;
    }

    @JSON(serialize = false)
    public List<BusTransCO> getDelBusTrans()
    {
	return delBusTrans;
    }

    public void setDelBusTrans(List<BusTransCO> delBusTrans)
    {
	this.delBusTrans = delBusTrans;
    }

    public String getFromTrans()
    {
	return fromTrans;
    }

    public void setFromTrans(String fromTrans)
    {
	this.fromTrans = fromTrans;
    }

    public String getAutocompleteTags()
    {
	return autocompleteTags;
    }

    public void setAutocompleteTags(String autocompleteTags)
    {
	this.autocompleteTags = autocompleteTags;
    }

    public String getScreenName()
    {
	return screenName;
    }

    public void setScreenName(String screenName)
    {
	this.screenName = screenName;
    }

    public String getScreenRef()
    {
	return screenRef;
    }

    public void setScreenRef(String screenRef)
    {
	this.screenRef = screenRef;
    }

    public String getDupParentFlag()
    {
	return dupParentFlag;
    }

    public void setDupParentFlag(String dupParentFlag)
    {
	this.dupParentFlag = dupParentFlag;
    }

    public String getUserId()
    {
	return userId;
    }

    public void setUserId(String userId)
    {
	this.userId = userId;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    public String getScreenParentRef()
    {
	return screenParentRef;
    }

    public void setScreenParentRef(String screenParentRef)
    {
	this.screenParentRef = screenParentRef;
    }

    public String getParentOfScreenRef()
    {
	return parentOfScreenRef;
    }

    public void setParentOfScreenRef(String parentOfScreenRef)
    {
	this.parentOfScreenRef = parentOfScreenRef;
    }

    public String getParentOfScreenParentRef()
    {
	return parentOfScreenParentRef;
    }

    public void setParentOfScreenParentRef(String parentOfScreenParentRef)
    {
	this.parentOfScreenParentRef = parentOfScreenParentRef;
    }

    public BigDecimal getScreenDispOrder()
    {
	return screenDispOrder;
    }

    public void setScreenDispOrder(BigDecimal screenDispOrder)
    {
	this.screenDispOrder = screenDispOrder;
    }

    public BigDecimal getScreenParentDispOrder()
    {
	return screenParentDispOrder;
    }

    public void setScreenParentDispOrder(BigDecimal screenParentDispOrder)
    {
	this.screenParentDispOrder = screenParentDispOrder;
    }

    public String getScreenParentName()
    {
        return screenParentName;
    }

    public void setScreenParentName(String screenParentName)
    {
        this.screenParentName = screenParentName;
    }

    public String getOriginScreenRef()
    {
        return originScreenRef;
    }

    public void setOriginScreenRef(String originScreenRef)
    {
        this.originScreenRef = originScreenRef;
    }

    /**
     * @return the catergoryId
     */
    public BigDecimal getCatergoryId()
    {
        return catergoryId;
    }

    /**
     * @param catergoryId the catergoryId to set
     */
    public void setCatergoryId(BigDecimal catergoryId)
    {
        this.catergoryId = catergoryId;
    }

    /**
     * @return the custDisplayMgnt
     */
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getCustDisplayMgnt()
    {
        return custDisplayMgnt;
    }

    /**
     * @param custDisplayMgnt the custDisplayMgnt to set
     */
    public void setCustDisplayMgnt(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> custDisplayMgnt)
    {
        this.custDisplayMgnt = custDisplayMgnt;
    }

    /**
     * @return the entityType
     */
    public String getEntityType()
    {
        return entityType;
    }

    /**
     * @param entityType the entityType to set
     */
    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }

    /**
     * @return the labelKeyCode
     */
    public Boolean getLabelKeyCode()
    {
        return labelKeyCode;
    }

    /**
     * @param labelKeyCode the labelKeyCode to set
     */
    public void setLabelKeyCode(Boolean labelKeyCode)
    {
        this.labelKeyCode = labelKeyCode;
    }

    /**
     * @return the labelExprKeyCode
     */
    public Boolean getLabelExprKeyCode()
    {
        return labelExprKeyCode;
    }

    /**
     * @param labelExprKeyCode the labelExprKeyCode to set
     */
    public void setLabelExprKeyCode(Boolean labelExprKeyCode)
    {
        this.labelExprKeyCode = labelExprKeyCode;
    }
    
    /**
     * 
     * @return the backgroundExprKeyCode
     */
    public Boolean getBackgroundExprKeyCode()
    {
        return backgroundExprKeyCode;
    }
    
    /**
     * 
     * @param backgroundExprKeyCode the backgroundExprKeyCode to set
     */
    public void setBackgroundExprKeyCode(Boolean backgroundExprKeyCode)
    {
        this.backgroundExprKeyCode = backgroundExprKeyCode;
    }

    public String getSaveAsParentRef()
    {
        return saveAsParentRef;
    }

    public void setSaveAsParentRef(String saveAsParentRef)
    {
        this.saveAsParentRef = saveAsParentRef;
    }

    public String getSaveAsSeries()
    {
        return saveAsSeries;
    }

    public void setSaveAsSeries(String saveAsSeries)
    {
        this.saveAsSeries = saveAsSeries;
    }

    public String getFROM_SERIES_PROG_REF()
    {
        return FROM_SERIES_PROG_REF;
    }

    public void setFROM_SERIES_PROG_REF(String fROM_SERIES_PROG_REF)
    {
        FROM_SERIES_PROG_REF = fROM_SERIES_PROG_REF;
    }

    /**
     * @return the labelKeyDesc
     */
    public String getLabelKeyDesc()
    {
        return labelKeyDesc;
    }

    /**
     * @param labelKeyDesc the labelKeyDesc to set
     */
    public void setLabelKeyDesc(String labelKeyDesc)
    {
        this.labelKeyDesc = labelKeyDesc;
    }

    public String getAutocompleteValueValidTags()
    {
        return autocompleteValueValidTags;
    }

    public void setAutocompleteValueValidTags(String autocompleteValueValidTags)
    {
        this.autocompleteValueValidTags = autocompleteValueValidTags;
    }

    /**
     * @return the language
     */
    public String getLanguage()
    {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language)
    {
        this.language = language;
    }

    /**
     * @return the disableCust
     */
    public Boolean getDisableCust()
    {
        return disableCust;
    }

    /**
     * @param disableCust the disableCust to set
     */
    public void setDisableCust(Boolean disableCust)
    {
        this.disableCust = disableCust;
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

    /**
     * @return the isVisibleAfterBrClosureYn
     */
    public String getIsVisibleAfterBrClosureYn()
    {
        return isVisibleAfterBrClosureYn;
    }

    /**
     * @param isVisibleAfterBrClosureYn the isVisibleAfterBrClosureYn to set
     */
    public void setIsVisibleAfterBrClosureYn(String isVisibleAfterBrClosureYn)
    {
        this.isVisibleAfterBrClosureYn = isVisibleAfterBrClosureYn;
    }

    public String getActivityDesc()
    {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc)
    {
        this.activityDesc = activityDesc;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public List<DynamicScreenParamsMapCO> getDynamicScreenParamsMapCOList()
    {
        return dynamicScreenParamsMapCOList;
    }

    public void setDynamicScreenParamsMapCOList(List<DynamicScreenParamsMapCO> dynamicScreenParamsMapCOList)
    {
        this.dynamicScreenParamsMapCOList = dynamicScreenParamsMapCOList;
    }

    public String getDynScrParamMapGridUpdate()
    {
        return dynScrParamMapGridUpdate;
    }

    public void setDynScrParamMapGridUpdate(String dynScrParamMapGridUpdate)
    {
        this.dynScrParamMapGridUpdate = dynScrParamMapGridUpdate;
    }

    public Date getRunningDate()
    {
        return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

    public FIELD_TECH_DETAILSVO getFieldTechDetailsVO()
    {
	return fieldTechDetailsVO;
    }

    public void setFieldTechDetailsVO(FIELD_TECH_DETAILSVO fieldTechDetailsVO)
    {
	this.fieldTechDetailsVO = fieldTechDetailsVO;
    }

    public Boolean getAddFieldTechDetailsOnly()
    {
        return addFieldTechDetailsOnly;
    }

    public void setAddFieldTechDetailsOnly(Boolean addFieldTechDetailsOnly)
    {
        this.addFieldTechDetailsOnly = addFieldTechDetailsOnly;
    }
    public String getButtonCustParamMapGridUpdate()
    {
        return buttonCustParamMapGridUpdate;
    }

    public void setButtonCustParamMapGridUpdate(String buttonCustParamMapGridUpdate)
    {
        this.buttonCustParamMapGridUpdate = buttonCustParamMapGridUpdate;
    }
    
    public List<SysParamGlobalActArgMapSC> getButtonCustParamsMapSCList()
    {
        return buttonCustParamsMapSCList;
    }

    public void setButtonCustParamsMapSCList(List<SysParamGlobalActArgMapSC> buttonCustParamsMapSCList)
    {
        this.buttonCustParamsMapSCList = buttonCustParamsMapSCList;
    }

    public List<CustomElementActivitiesSC> getCustomElementActivitiesSCList()
    {
        return customElementActivitiesSCList;
    }

    public void setCustomElementActivitiesSCList(List<CustomElementActivitiesSC> customElementActivitiesSCList)
    {
        this.customElementActivitiesSCList = customElementActivitiesSCList;
    }

    public String getCustomElementActivitiesGridUpdate()
    {
        return customElementActivitiesGridUpdate;
    }

    public void setCustomElementActivitiesGridUpdate(String customElementActivitiesGridUpdate)
    {
        this.customElementActivitiesGridUpdate = customElementActivitiesGridUpdate;
    }

    /**
     * @return the mIN_TENOR_PERIODICTY_TYPE
     */
    public String getMIN_TENOR_PERIODICTY_TYPE()
    {
        return MIN_TENOR_PERIODICTY_TYPE;
    }

    /**
     * @param mIN_TENOR_PERIODICTY_TYPE the mIN_TENOR_PERIODICTY_TYPE to set
     */
    public void setMIN_TENOR_PERIODICTY_TYPE(String mIN_TENOR_PERIODICTY_TYPE)
    {
        MIN_TENOR_PERIODICTY_TYPE = mIN_TENOR_PERIODICTY_TYPE;
    }

    /**
     * @return the actionType
     */
    public String getActionType()
    {
        return actionType;
    }

    /**
     * @param actionType the actionType to set
     */
    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }

    /**
     * @return the dateUpdated
     */
    public Date getDateUpdated()
    {
        return dateUpdated;
    }

    /**
     * @param dateUpdated the dateUpdated to set
     */
    public void setDateUpdated(Date dateUpdated)
    {
        this.dateUpdated = dateUpdated;
    }

    /**
     * @return the auditObj
     */
    public Object getAuditObj()
    {
        return auditObj;
    }

    /**
     * @param auditObj the auditObj to set
     */
    public void setAuditObj(Object auditObj)
    {
        this.auditObj = auditObj;
    }

    /**
     * @return the auditRefCO
     */
    public AuditRefCO getAuditRefCO()
    {
        return auditRefCO;
    }

    /**
     * @param auditRefCO the auditRefCO to set
     */
    public void setAuditRefCO(AuditRefCO auditRefCO)
    {
        this.auditRefCO = auditRefCO;
    }

    /**
     * @return the maintenanceFromMir
     */
    public String getMaintenanceFromMir()
    {
        return maintenanceFromMir;
    }

    /**
     * @param maintenanceFromMir the maintenanceFromMir to set
     */
    public void setMaintenanceFromMir(String maintenanceFromMir)
    {
        this.maintenanceFromMir = maintenanceFromMir;
    }

    /**
     * @return the objCustomElementActivitiesGridUpdate
     */
    public String getObjCustomElementActivitiesGridUpdate()
    {
	return objCustomElementActivitiesGridUpdate;
    }

    /**
     * @param objCustomElementActivitiesGridUpdate the objCustomElementActivitiesGridUpdate to set
     */
    public void setObjCustomElementActivitiesGridUpdate(String objCustomElementActivitiesGridUpdate)
    {
	this.objCustomElementActivitiesGridUpdate = objCustomElementActivitiesGridUpdate;
    }

    /**
     * @return the objCustomElementActivitiesSCList
     */
    public List<CustomElementActivitiesSC> getObjCustomElementActivitiesSCList()
    {
	return objCustomElementActivitiesSCList;
    }

    /**
     * @param objCustomElementActivitiesSCList the objCustomElementActivitiesSCList to set
     */
    public void setObjCustomElementActivitiesSCList(List<CustomElementActivitiesSC> objCustomElementActivitiesSCList)
    {
	this.objCustomElementActivitiesSCList = objCustomElementActivitiesSCList;
    }

    /**
     * @return the objCustParamMapGridUpdate
     */
    public String getObjCustParamMapGridUpdate()
    {
	return objCustParamMapGridUpdate;
    }

    /**
     * @param objCustParamMapGridUpdate the objCustParamMapGridUpdate to set
     */
    public void setObjCustParamMapGridUpdate(String objCustParamMapGridUpdate)
    {
	this.objCustParamMapGridUpdate = objCustParamMapGridUpdate;
    }

    /**
     * @return the objCustParamsMapSCList
     */
    public List<SysParamGlobalActArgMapSC> getObjCustParamsMapSCList()
    {
	return objCustParamsMapSCList;
    }

    /**
     * @param objCustParamsMapSCList the objCustParamsMapSCList to set
     */
    public void setObjCustParamsMapSCList(List<SysParamGlobalActArgMapSC> objCustParamsMapSCList)
    {
	this.objCustParamsMapSCList = objCustParamsMapSCList;
    }
    
}
