package com.path.vo.common.audit;

import java.util.ArrayList;

import com.path.dbmaps.vo.TRACK_CHANGES_DETAILSVO;
import com.path.dbmaps.vo.TRACK_CHANGES_MASTERVO;

/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: RabihElKhatib
 *
 * TrackPropCO.java used to store the callTrackChanges method variables in AuditBO
 */
public class TrackPropCO extends AuditRefCO
{
//    private String appName; //The current application name
//    private String progRef; //Window opt's reference
//    private String operationType; //Audit operation type (update, insert, delete, retrieve ...)
//    private String keyRef; //The constructed key of the window
//    private Date   runningDate; //The performed action date (running date)
//    private String userID; //The current user logged in name
//    private String machineID;	//The current machine name
//    private String trxNbr;	//The Transaction Number of the window
//    private Boolean auditEnabled; //The audit OPT checking
//    private AuditCO auditCO; //Array list that contains the data to be inserted into AUDIT tables
//    private Boolean disableSmart; //boolean whether not to Consider Smart in validation
//    private Map reportArgs;
//    private String infoDetails; //used to add more details about the field to know the parent related to it
    private String voMainPropRef; //voMainPropRef IS The main VO property name (i.e cifVO, amfVO, ) to generate the TRX_NBR from. Should be "main" if the CO contains the key values
    private boolean trackVoMainPropRef; //TrackVoMainPropRef IS a boolean to track the main propRef, this Boolean is “true” by default and shall be set to false in case the tracking is not on  The main VO property
    private String voPropRef; //voPropRef IS The VO property name (i.e cifVO, amfVO, ).
    private String voPropertiesNames; //voPropertiesNames IS the names of the properties (VOs) to be tracked as a comma separated string
    private String coInstanceName; //coInstanceName IS the instance name of the CO object being tracked
    private String addPropKeyVal; //addPropKeyVal IS The value of the key of each list
    
    private TRACK_CHANGES_MASTERVO trackVO; //header VO representing TRACK_CHANGES_MASTER
    private ArrayList<TRACK_CHANGES_DETAILSVO> trackDtlVO; //details VO representing TRACK_CHANGES_DETAILS
    
    private ArrayList<AddPropCO> addPropCO = new ArrayList<AddPropCO>(); //The lists specific details

    public ArrayList<AddPropCO> getAddPropCO()
    {
        return addPropCO;
    }

    public void setAddPropCO(ArrayList<AddPropCO> addPropCO)
    {
        this.addPropCO = addPropCO;
    }

    public String getVoMainPropRef()
    {
        return voMainPropRef;
    }

    public void setVoMainPropRef(String voMainPropRef)
    {
        this.voMainPropRef = voMainPropRef;
    }

    public String getVoPropertiesNames()
    {
        return voPropertiesNames;
    }

    public void setVoPropertiesNames(String voPropertiesNames)
    {
        this.voPropertiesNames = voPropertiesNames;
    }

    public String getCoInstanceName()
    {
        return coInstanceName;
    }

    public void setCoInstanceName(String coInstanceName)
    {
        this.coInstanceName = coInstanceName;
    }

    public void setAddPropKeyVal(String addPropKeyVal)
    {
	this.addPropKeyVal = addPropKeyVal;
    }

    public String getAddPropKeyVal()
    {
	return addPropKeyVal;
    }

    public TRACK_CHANGES_MASTERVO getTrackVO()
    {
        return trackVO;
    }

    public void setTrackVO(TRACK_CHANGES_MASTERVO trackVO)
    {
        this.trackVO = trackVO;
    }

    public ArrayList<TRACK_CHANGES_DETAILSVO> getTrackDtlVO()
    {
        return trackDtlVO;
    }

    public void setTrackDtlVO(ArrayList<TRACK_CHANGES_DETAILSVO> trackDtlVO)
    {
        this.trackDtlVO = trackDtlVO;
    }

    public String getVoPropRef()
    {
        return voPropRef;
    }

    public void setVoPropRef(String voPropRef)
    {
        this.voPropRef = voPropRef;
    }

    public boolean isTrackVoMainPropRef()
    {
        return trackVoMainPropRef;
    }

    public void setTrackVoMainPropRef(boolean trackVoMainPropRef)
    {
        this.trackVoMainPropRef = trackVoMainPropRef;
    }
}
