/**
 * 
 */
package com.path.vo.common.dynamicscreen;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * LinkDynamicScreenCO.java used to
 */
public class LinkDynamicScreenCO extends BaseVO
{
    private BigDecimal DYN_SCREEN_ID;
    private String     SCREEN_DESC;
    private String     PROG_REF;
    private String     APP_NAME;
    private String     MENU_TITLE;
    private String     screenParentName;
    private String     parentRef;
    private String     userId;
    private BigDecimal companyCode;
    private BigDecimal branchCode;
    private BigDecimal categId;
    private String categDesc;
    
    public BigDecimal getDYN_SCREEN_ID()
    {
        return DYN_SCREEN_ID;
    }
    public void setDYN_SCREEN_ID(BigDecimal dYN_SCREEN_ID)
    {
        DYN_SCREEN_ID = dYN_SCREEN_ID;
    }
    public String getSCREEN_DESC()
    {
        return SCREEN_DESC;
    }
    public void setSCREEN_DESC(String sCREEN_DESC)
    {
        SCREEN_DESC = sCREEN_DESC;
    }
    public String getPROG_REF()
    {
        return PROG_REF;
    }
    public void setPROG_REF(String pROG_REF)
    {
        PROG_REF = pROG_REF;
    }
    public String getMENU_TITLE()
    {
        return MENU_TITLE;
    }
    public void setMENU_TITLE(String mENU_TITLE)
    {
        MENU_TITLE = mENU_TITLE;
    }
    public String getScreenParentName()
    {
        return screenParentName;
    }
    public void setScreenParentName(String screenParentName)
    {
        this.screenParentName = screenParentName;
    }
    public String getParentRef()
    {
        return parentRef;
    }
    public void setParentRef(String parentRef)
    {
        this.parentRef = parentRef;
    }
    public String getAPP_NAME()
    {
        return APP_NAME;
    }
    public void setAPP_NAME(String aPP_NAME)
    {
        APP_NAME = aPP_NAME;
    }
    public String getUserId()
    {
        return userId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    public BigDecimal getCompanyCode()
    {
        return companyCode;
    }
    public void setCompanyCode(BigDecimal companyCode)
    {
        this.companyCode = companyCode;
    }
    public BigDecimal getBranchCode()
    {
        return branchCode;
    }
    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }
    /**
     * @return the categId
     */
    public BigDecimal getCategId()
    {
        return categId;
    }
    /**
     * @param categId the categId to set
     */
    public void setCategId(BigDecimal categId)
    {
        this.categId = categId;
    }
    /**
     * @return the categDesc
     */
    public String getCategDesc()
    {
        return categDesc;
    }
    /**
     * @param categDesc the categDesc to set
     */
    public void setCategDesc(String categDesc)
    {
        this.categDesc = categDesc;
    }
    
}
