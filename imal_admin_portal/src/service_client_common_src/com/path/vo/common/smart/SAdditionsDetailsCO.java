/**
 * 
 */
package com.path.vo.common.smart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import com.path.dbmaps.vo.S_ADDITIONS_DETAILSVO;
import com.path.lib.vo.BaseVO;

/**
 * @author raees
 * 
 */
public class SAdditionsDetailsCO extends BaseVO implements Serializable
{
    private ArrayList<S_ADDITIONS_DETAILSVO> sAdditionsDetailsVOList = new ArrayList<S_ADDITIONS_DETAILSVO>();
    
    ArrayList<SObjectDetailVO>  sObjectDetailList;
    
    private Date sAddDate;
    
    private String userID;
    
    private Date sAddRunDate;
    
    private Boolean mainEnabled;
    //add field mandatory from type table

    public ArrayList<S_ADDITIONS_DETAILSVO> getsAdditionsDetailsVOList()
    {
        return sAdditionsDetailsVOList;
    }

    public void setsAdditionsDetailsVOList(ArrayList<S_ADDITIONS_DETAILSVO> sAdditionsDetailsVOList)
    {
        this.sAdditionsDetailsVOList = sAdditionsDetailsVOList;
    }

    /**
     * @return the sAddDate
     */
    public Date getSAddDate()
    {
	return sAddDate; 
    }

    /**
     * @param sAddDate the sAddDate to set
     */
    public void setSAddDate(Date sAddDate)
    {
	this.sAddDate = sAddDate;
    }

    /**
     * @return the userId
     */
    public String getUserID()
    {
	return userID;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserID(String userID)
    {
	this.userID = userID;
    }

    /**
     * @return the sAddRunDate
     */
    public Date getSAddRunDate()
    {
	return sAddRunDate;
    }

    /**
     * @param sAddRunDate the sAddRunDate to set
     */
    public void setSAddRunDate(Date sAddRunDate)
    {
	this.sAddRunDate = sAddRunDate;
    }

    /**
     * 
     * @param the mainEnabled to set
     */
    public void setMainEnabled(Boolean mainEnabled)
    {
	this.mainEnabled = mainEnabled;
    }

    /**
     * 
     * @return the mainEnabled
     */
    public Boolean getMainEnabled()
    {
	return mainEnabled;
    }

/**
 * @return the sObjectDetailList
 */
public ArrayList<SObjectDetailVO> getsObjectDetailList()
{
    return sObjectDetailList;
}

/**
 * @param sObjectDetailList the sObjectDetailList to set
 */
public void setsObjectDetailList(ArrayList<SObjectDetailVO> sObjectDetailList)
{
    this.sObjectDetailList = sObjectDetailList;
}

}
