package com.path.vo.common.statuscustomization;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.lib.vo.BaseVO;
/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * StatusCustomizationCO.java used to
 */
public class StatusCustomizationCO extends BaseVO
{
    private BigDecimal   LOV_TYPE_ID;
    private String       LOV_TYPE_DESCRIPTION;
    private String       STATUS_CODE;
    private String       PROG_REF;
    private String       APP_NAME;
    private String       APP_DESC;
    private String       SECTION_DESC;
    private String       STATUS_DESC;
    private String       screenLocation;
    private String       selectedStsCodes;
    private List<String> selectedStsCodesList = new ArrayList<String>();
    private List<SelectedStatusCO> stsCodesLst = new ArrayList<SelectedStatusCO>();
    private Map<String,List<SelectedStatusCO>> hmSts = new HashMap<String,List<SelectedStatusCO>>();
    private String       selectedKey;
    /**
     * @return the lOV_TYPE_ID
     */
    public BigDecimal getLOV_TYPE_ID()
    {
        return LOV_TYPE_ID;
    }
    /**
     * @param lOVTYPEID the lOV_TYPE_ID to set
     */
    public void setLOV_TYPE_ID(BigDecimal lOVTYPEID)
    {
        LOV_TYPE_ID = lOVTYPEID;
    }
    /**
     * @return the sTATUS_CODE
     */
    public String getSTATUS_CODE()
    {
        return STATUS_CODE;
    }
    /**
     * @param sTATUSCODE the sTATUS_CODE to set
     */
    public void setSTATUS_CODE(String sTATUSCODE)
    {
        STATUS_CODE = sTATUSCODE;
    }
    /**
     * @return the pROG_REF
     */
    public String getPROG_REF()
    {
        return PROG_REF;
    }
    /**
     * @param pROGREF the pROG_REF to set
     */
    public void setPROG_REF(String pROGREF)
    {
        PROG_REF = pROGREF;
    }
    /**
     * @return the aPP_NAME
     */
    public String getAPP_NAME()
    {
        return APP_NAME;
    }
    /**
     * @param aPPNAME the aPP_NAME to set
     */
    public void setAPP_NAME(String aPPNAME)
    {
        APP_NAME = aPPNAME;
    }
    /**
     * @return the aPP_DESC
     */
    public String getAPP_DESC()
    {
        return APP_DESC;
    }
    /**
     * @param aPPDESC the aPP_DESC to set
     */
    public void setAPP_DESC(String aPPDESC)
    {
        APP_DESC = aPPDESC;
    }
    /**
     * @return the sECTION_DESC
     */
    public String getSECTION_DESC()
    {
        return SECTION_DESC;
    }
    /**
     * @param sECTIONDESC the sECTION_DESC to set
     */
    public void setSECTION_DESC(String sECTIONDESC)
    {
        SECTION_DESC = sECTIONDESC;
    }
    /**
     * @return the sTATUS_DESC
     */
    public String getSTATUS_DESC()
    {
        return STATUS_DESC;
    }
    /**
     * @param sTATUSDESC the sTATUS_DESC to set
     */
    public void setSTATUS_DESC(String sTATUSDESC)
    {
        STATUS_DESC = sTATUSDESC;
    }
    /**
     * @return the screenLocation
     */
    public String getScreenLocation()
    {
        return screenLocation;
    }
    /**
     * @param screenLocation the screenLocation to set
     */
    public void setScreenLocation(String screenLocation)
    {
        this.screenLocation = screenLocation;
    }
    /**
     * @return the selectedStsCodes
     */
    public String getSelectedStsCodes()
    {
        return selectedStsCodes;
    }
    /**
     * @param selectedStsCodes the selectedStsCodes to set
     */
    public void setSelectedStsCodes(String selectedStsCodes)
    {
        this.selectedStsCodes = selectedStsCodes;
    }
    /**
     * @return the selectedStsCodesList
     */
    public List<String> getSelectedStsCodesList()
    {
        return selectedStsCodesList;
    }
    /**
     * @param selectedStsCodesList the selectedStsCodesList to set
     */
    public void setSelectedStsCodesList(List<String> selectedStsCodesList)
    {
        this.selectedStsCodesList = selectedStsCodesList;
    }
    /**
     * @return the lOV_TYPE_DESCRIPTION
     */
    public String getLOV_TYPE_DESCRIPTION()
    {
        return LOV_TYPE_DESCRIPTION;
    }
    /**
     * @param lOVTYPEDESCRIPTION the lOV_TYPE_DESCRIPTION to set
     */
    public void setLOV_TYPE_DESCRIPTION(String lOVTYPEDESCRIPTION)
    {
        LOV_TYPE_DESCRIPTION = lOVTYPEDESCRIPTION;
    }
    /**
     * @return the stsCodesLst
     */
    public List<SelectedStatusCO> getStsCodesLst()
    {
        return stsCodesLst;
    }
    /**
     * @param stsCodesLst the stsCodesLst to set
     */
    public void setStsCodesLst(List<SelectedStatusCO> stsCodesLst)
    {
        this.stsCodesLst = stsCodesLst;
    }
    /**
     * @return the hmSts
     */
    public Map<String, List<SelectedStatusCO>> getHmSts()
    {
        return hmSts;
    }
    /**
     * @param hmSts the hmSts to set
     */
    public void setHmSts(Map<String, List<SelectedStatusCO>> hmSts)
    {
        this.hmSts = hmSts;
    }
    /**
     * @return the selectedKey
     */
    public String getSelectedKey()
    {
        return selectedKey;
    }
    /**
     * @param selectedKey the selectedKey to set
     */
    public void setSelectedKey(String selectedKey)
    {
        this.selectedKey = selectedKey;
    }

}
