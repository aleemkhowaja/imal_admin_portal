/**
 * 
 */
package com.path.vo.common.customization.object;

import com.path.dbmaps.vo.SYS_PARAM_OBJ_DETAILS_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_OBJ_DISPLAYVO;
import com.path.struts2.lib.common.GridParamsSC;

/**
 * @author marwanmaddah
 *
 */
public class ObjectCustomizationSC extends GridParamsSC
{
    private String langCode;
    private String appName;
    private String progRef;
    private String objectName;
    private String objectId;
    private String objectType;
    private String defaultAppName;
    private String originalProgRef;
    private String readOnlyComboDesc;
    private String visibilityComboDesc;
    private String mandatoryComboDesc;
    private String columnNameComboDesc;
    private String exportCustType;
    private String overrideCustImport;
    private String  cutomizationPROG_REF;
    private boolean useSpecificPageRef;
    private SYS_PARAM_OBJ_DISPLAYVO sysParamObjDispVO	= new SYS_PARAM_OBJ_DISPLAYVO();
    private SYS_PARAM_OBJ_DETAILS_DISPLAYVO sysParamObjDetailsDispVO = new SYS_PARAM_OBJ_DETAILS_DISPLAYVO();
    /**
     * @return the langCode
     */
    public String getLangCode()
    {
        return langCode;
    }
    /**
     * @param langCode the langCode to set
     */
    public void setLangCode(String langCode)
    {
        this.langCode = langCode;
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
     * @return the progRef
     */
    public String getProgRef()
    {
        return progRef;
    }
    /**
     * @param progRef the progRef to set
     */
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
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
     * @return the defaultAppName
     */
    public String getDefaultAppName()
    {
        return defaultAppName;
    }
    /**
     * @param defaultAppName the defaultAppName to set
     */
    public void setDefaultAppName(String defaultAppName)
    {
        this.defaultAppName = defaultAppName;
    }
    /**
     * @return the originalProgRef
     */
    public String getOriginalProgRef()
    {
        return originalProgRef;
    }
    /**
     * @param originalProgRef the originalProgRef to set
     */
    public void setOriginalProgRef(String originalProgRef)
    {
        this.originalProgRef = originalProgRef;
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
    public SYS_PARAM_OBJ_DETAILS_DISPLAYVO getSysParamObjDetailsDispVO()
    {
        return sysParamObjDetailsDispVO;
    }
    public void setSysParamObjDetailsDispVO(SYS_PARAM_OBJ_DETAILS_DISPLAYVO sysParamObjDetailsDispVO)
    {
        this.sysParamObjDetailsDispVO = sysParamObjDetailsDispVO;
    }
    public String getReadOnlyComboDesc()
    {
        return readOnlyComboDesc;
    }
    public void setReadOnlyComboDesc(String readOnlyComboDesc)
    {
        this.readOnlyComboDesc = readOnlyComboDesc;
    }
    public String getVisibilityComboDesc()
    {
        return visibilityComboDesc;
    }
    public void setVisibilityComboDesc(String visibilityComboDesc)
    {
        this.visibilityComboDesc = visibilityComboDesc;
    }
    public String getMandatoryComboDesc()
    {
        return mandatoryComboDesc;
    }
    public void setMandatoryComboDesc(String mandatoryComboDesc)
    {
        this.mandatoryComboDesc = mandatoryComboDesc;
    }
    public String getColumnNameComboDesc()
    {
        return columnNameComboDesc;
    }
    public void setColumnNameComboDesc(String columnNameComboDesc)
    {
        this.columnNameComboDesc = columnNameComboDesc;
    }
    public String getExportCustType()
    {
        return exportCustType;
    }
    public void setExportCustType(String exportCustType)
    {
        this.exportCustType = exportCustType;
    }
    public String getCutomizationPROG_REF()
    {
        return cutomizationPROG_REF;
    }
    public void setCutomizationPROG_REF(String cutomizationPROG_REF)
    {
        this.cutomizationPROG_REF = cutomizationPROG_REF;
    }
    public boolean isUseSpecificPageRef()
    {
        return useSpecificPageRef;
    }
    public void setUseSpecificPageRef(boolean useSpecificPageRef)
    {
        this.useSpecificPageRef = useSpecificPageRef;
    }
    public SYS_PARAM_OBJ_DISPLAYVO getSysParamObjDispVO()
    {
        return sysParamObjDispVO;
    }
    public void setSysParamObjDispVO(SYS_PARAM_OBJ_DISPLAYVO sysParamObjDispVO)
    {
        this.sysParamObjDispVO = sysParamObjDispVO;
    }
    public String getOverrideCustImport()
    {
        return overrideCustImport;
    }
    public void setOverrideCustImport(String overrideCustImport)
    {
        this.overrideCustImport = overrideCustImport;
    }
    
}
