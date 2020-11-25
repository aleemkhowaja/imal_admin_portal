/**
 * 
 */
package com.path.vo.common.customization.object;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.SYS_PARAM_OBJ_DETAILS_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_OBJ_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.common.customization.CustomizationCO;

/**
 * @author marwanmaddah
 *
 */
public class ObjectCustomizationCO extends BaseVO
{
    private Boolean readOnlyFlag = false;
    private Boolean visibleFlag = false;
    private Boolean specificFlag = false;
    private String  cutomizationPROG_REF;
    private String  autocompleteTags;// for auto-complete variables used in
				    // Expressions
    private String  autocompleteValueValidTags;// for auto-complete variables used in
    					      // Value Validation Expressions for texts and textareas
    private String  appName;//the current application name
    private String  screenRef;
    private String  screenParentRef;
    private String  userId;
    private Boolean disableCust;
    private String  language;
    private Date    runningDate;
    private SYS_PARAM_OBJ_DISPLAYVO sysParamObjDisplayVO = new SYS_PARAM_OBJ_DISPLAYVO();
    private List<SYS_PARAM_OBJ_DETAILS_DISPLAYVO> sysParamObjDetailsDisplayList = new ArrayList<SYS_PARAM_OBJ_DETAILS_DISPLAYVO>();
    private String objectCustomizationDetailsGridUpdate ; 
    private List<ObjectCustomizationSC>  ObjectCustomizationSCList = new ArrayList<ObjectCustomizationSC>();
    private Map<String,SYS_PARAM_SCREEN_DISPLAYVO> custDisplayMgnt = new HashMap<String,SYS_PARAM_SCREEN_DISPLAYVO>();
    private String overrideCustImport;
    private Boolean isGridReadOnly = false;
    
    private CustomizationCO customizationCO;
    
    /*953614 Specify Grid Filter Query Expression - Grid/Livesearch Customization Enhancements*/
    private BigDecimal hasFilterExpr;
    /**
     * @return the hasFilterExpr
     */
    public BigDecimal getHasFilterExpr()
    {
	return hasFilterExpr;
    }
    /**
     * @param hasFilterExpr the hasFilterExpr to set
     */
    public void setHasFilterExpr(BigDecimal hasFilterExpr)
    {
	this.hasFilterExpr = hasFilterExpr;
    }
    /*end: 953614*/
    
    
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
    /**
     * @return the visibleFlag
     */
    public Boolean getVisibleFlag()
    {
        return visibleFlag;
    }
    /**
     * @param visibleFlag the visibleFlag to set
     */
    public void setVisibleFlag(Boolean visibleFlag)
    {
        this.visibleFlag = visibleFlag;
    }
    /**
     * @return the specificFlag
     */
    public Boolean getSpecificFlag()
    {
        return specificFlag;
    }
    /**
     * @param specificFlag the specificFlag to set
     */
    public void setSpecificFlag(Boolean specificFlag)
    {
        this.specificFlag = specificFlag;
    }
    /**
     * @return the cutomizationPROG_REF
     */
    public String getCutomizationPROG_REF()
    {
        return cutomizationPROG_REF;
    }
    /**
     * @param cutomizationPROG_REF the cutomizationPROG_REF to set
     */
    public void setCutomizationPROG_REF(String cutomizationPROG_REF)
    {
        this.cutomizationPROG_REF = cutomizationPROG_REF;
    }
    /**
     * @return the autocompleteTags
     */
    public String getAutocompleteTags()
    {
        return autocompleteTags;
    }
    /**
     * @param autocompleteTags the autocompleteTags to set
     */
    public void setAutocompleteTags(String autocompleteTags)
    {
        this.autocompleteTags = autocompleteTags;
    }
    /**
     * @return the autocompleteValueValidTags
     */
    public String getAutocompleteValueValidTags()
    {
        return autocompleteValueValidTags;
    }
    /**
     * @param autocompleteValueValidTags the autocompleteValueValidTags to set
     */
    public void setAutocompleteValueValidTags(String autocompleteValueValidTags)
    {
        this.autocompleteValueValidTags = autocompleteValueValidTags;
    }
    /**
     * @return the appName
     */
    public String getAppName()
    {
        return appName;
    }
    /**
     * @param appName the appName to set
     */
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    /**
     * @return the screenRef
     */
    public String getScreenRef()
    {
        return screenRef;
    }
    /**
     * @param screenRef the screenRef to set
     */
    public void setScreenRef(String screenRef)
    {
        this.screenRef = screenRef;
    }
    /**
     * @return the screenParentRef
     */
    public String getScreenParentRef()
    {
        return screenParentRef;
    }
    /**
     * @param screenParentRef the screenParentRef to set
     */
    public void setScreenParentRef(String screenParentRef)
    {
        this.screenParentRef = screenParentRef;
    }
    /**
     * @return the userId
     */
    public String getUserId()
    {
        return userId;
    }
    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId)
    {
        this.userId = userId;
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
    /**
     * @return the sysParamObjDisplayVO
     */
    public SYS_PARAM_OBJ_DISPLAYVO getSysParamObjDisplayVO()
    {
        return sysParamObjDisplayVO;
    }
    /**
     * @param sysParamObjDisplayVO the sysParamObjDisplayVO to set
     */
    public void setSysParamObjDisplayVO(SYS_PARAM_OBJ_DISPLAYVO sysParamObjDisplayVO)
    {
        this.sysParamObjDisplayVO = sysParamObjDisplayVO;
    }
    /**
     * @return the custDisplayMgnt
     */
    public Map<String, SYS_PARAM_SCREEN_DISPLAYVO> getCustDisplayMgnt()
    {
        return custDisplayMgnt;
    }
    /**
     * @param custDisplayMgnt the custDisplayMgnt to set
     */
    public void setCustDisplayMgnt(Map<String, SYS_PARAM_SCREEN_DISPLAYVO> custDisplayMgnt)
    {
        this.custDisplayMgnt = custDisplayMgnt;
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
     * @return the runningDate
     */
    public Date getRunningDate()
    {
        return runningDate;
    }
    /**
     * @param runningDate the runningDate to set
     */
    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }
    public String getObjectCustomizationDetailsGridUpdate()
    {
        return objectCustomizationDetailsGridUpdate;
    }
    public void setObjectCustomizationDetailsGridUpdate(String objectCustomizationDetailsGridUpdate)
    {
        this.objectCustomizationDetailsGridUpdate = objectCustomizationDetailsGridUpdate;
    }
    public List<ObjectCustomizationSC> getObjectCustomizationSCList()
    {
        return ObjectCustomizationSCList;
    }
    public void setObjectCustomizationSCList(List<ObjectCustomizationSC> objectCustomizationSCList)
    {
        ObjectCustomizationSCList = objectCustomizationSCList;
    }
    public List<SYS_PARAM_OBJ_DETAILS_DISPLAYVO> getSysParamObjDetailsDisplayList()
    {
        return sysParamObjDetailsDisplayList;
    }
    public void setSysParamObjDetailsDisplayList(List<SYS_PARAM_OBJ_DETAILS_DISPLAYVO> sysParamObjDetailsDisplayList)
    {
        this.sysParamObjDetailsDisplayList = sysParamObjDetailsDisplayList;
    }
    public String getOverrideCustImport()
    {
        return overrideCustImport;
    }
    public void setOverrideCustImport(String overrideCustImport)
    {
        this.overrideCustImport = overrideCustImport;
    }
    public Boolean getIsGridReadOnly()
    {
        return isGridReadOnly;
    }
    public void setIsGridReadOnly(Boolean isGridReadOnly)
    {
        this.isGridReadOnly = isGridReadOnly;
    }
    public CustomizationCO getCustomizationCO()
    {
        return customizationCO;
    }
    public void setCustomizationCO(CustomizationCO customizationCO)
    {
        this.customizationCO = customizationCO;
    }
    
}
