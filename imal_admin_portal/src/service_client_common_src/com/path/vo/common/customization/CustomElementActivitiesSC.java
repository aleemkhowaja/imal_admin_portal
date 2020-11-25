/**
 * 
 */
package com.path.vo.common.customization;

import java.util.List;

import com.path.dbmaps.vo.SYS_PARAM_ELEM_ACTIVITIESVO;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.common.customization.button.ButtonCustomizationCO;

/**
 * 
 * Copyright 2017, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: peterabounader
 *
 * CustomElementActivitiesSC.java used to
 */
public class CustomElementActivitiesSC extends GridParamsSC
{
    private SYS_PARAM_ELEM_ACTIVITIESVO sysParamElemActivitiesVO = new SYS_PARAM_ELEM_ACTIVITIESVO();
    private String activityDescription ; 
    private String firstActivityType ; 
    private String fromText;
    private String fromButton;
    private String autoCompleteTags;
    private String pageRef;
    private List<ButtonCustomizationCO> buttonCustCOList;
    private List<String> activityIds;
    private String fromScreen;
    private Boolean specificFlag = false;
    private String changedStatus;
    private String enableAfterExecution;
    private String fromObjDisplay;
    //AUBBHU200146 - Performance in CSM
	//Added custom element activities data to cache
    private String allScreenActivities;
    //[TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
    private Boolean objColumnActivity = false;    //used to validate, is custom activity on column
    private String gridColumnName;	//used to store grid technical column name
    private List<String> activityTypes;
    //End-[TP#1043972]
    
    public String getFromScreen()
    {
        return fromScreen;
    }

    public void setFromScreen(String fromScreen)
    {
        this.fromScreen = fromScreen;
    }

    public List<String> getActivityIds()
    {
        return activityIds;
    }

    public void setActivityIds(List<String> activityIds)
    {
        this.activityIds = activityIds;
    }

    public SYS_PARAM_ELEM_ACTIVITIESVO getSysParamElemActivitiesVO()
    {
        return sysParamElemActivitiesVO;
    }

    public void setSysParamElemActivitiesVO(SYS_PARAM_ELEM_ACTIVITIESVO sysParamElemActivitiesVO)
    {
        this.sysParamElemActivitiesVO = sysParamElemActivitiesVO;
    }

    public String getActivityDescription()
    {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription)
    {
        this.activityDescription = activityDescription;
    }

    public String getFirstActivityType()
    {
        return firstActivityType;
    }

    public void setFirstActivityType(String firstActivityType)
    {
        this.firstActivityType = firstActivityType;
    }

    public String getAutoCompleteTags()
    {
        return autoCompleteTags;
    }

    public void setAutoCompleteTags(String autoCompleteTags)
    {
        this.autoCompleteTags = autoCompleteTags;
    }

    public String getPageRef()
    {
        return pageRef;
    }

    public void setPageRef(String pageRef)
    {
        this.pageRef = pageRef;
    }

    public List<ButtonCustomizationCO> getButtonCustCOList()
    {
        return buttonCustCOList;
    }

    public void setButtonCustCOList(List<ButtonCustomizationCO> buttonCustCOList)
    {
        this.buttonCustCOList = buttonCustCOList;
    }

    public String getFromText()
    {
        return fromText;
    }

    public void setFromText(String fromText)
    {
        this.fromText = fromText;
    }

    public String getFromButton()
    {
        return fromButton;
    }

    public void setFromButton(String fromButton)
    {
        this.fromButton = fromButton;
    }

    public Boolean getSpecificFlag()
    {
        return specificFlag;
    }

    public void setSpecificFlag(Boolean specificFlag)
    {
        this.specificFlag = specificFlag;
    }

    public String getChangedStatus()
    {
        return changedStatus;
    }

    public void setChangedStatus(String changedStatus)
    {
        this.changedStatus = changedStatus;
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
     * @return the fromObjDisplay
     */
    public String getFromObjDisplay()
    {
        return fromObjDisplay;
    }

    /**
     * @param fromObjDisplay the fromObjDisplay to set
     */
    public void setFromObjDisplay(String fromObjDisplay)
    {
        this.fromObjDisplay = fromObjDisplay;
    }

	public String getAllScreenActivities() {
		return allScreenActivities;
	}

	public void setAllScreenActivities(String allScreenActivities) {
		this.allScreenActivities = allScreenActivities;
	}
    
    /**
     * @return the objColumnActivity
     */
    public Boolean getObjColumnActivity()
    {
	return objColumnActivity;
    }

    /**
     * @param objColumnActivity the objColumnActivity to set
     */
    public void setObjColumnActivity(Boolean objColumnActivity)
    {
	this.objColumnActivity = objColumnActivity;
    }

    /**
     * @return the gridColumnName
     */
    public String getGridColumnName()
    {
	return gridColumnName;
    }

    /**
     * @param gridColumnName the gridColumnName to set
     */
    public void setGridColumnName(String gridColumnName)
    {
	this.gridColumnName = gridColumnName;
    }

    /**
     * @return the activityTypes
     */
    public List<String> getActivityTypes()
    {
	return activityTypes;
    }

    /**
     * @param activityTypes the activityTypes to set
     */
    public void setActivityTypes(List<String> activityTypes)
    {
	this.activityTypes = activityTypes;
    }
    
}
