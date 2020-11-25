package com.path.vo.common.dashboardportal;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.SYS_PARAM_USR_ALLOWED_PORTLETSVO;
import com.path.dbmaps.vo.USRVO;
import com.path.struts2.lib.common.GridParamsSC;

public class DashboardPortalSC extends GridParamsSC
{
    private String PORTLET_CODE;
    private String IMG_URL;
    private String ABV_DESC_KEY;
    private String TITLE_KEY;
    private String PORTLET_URL;
    private String LAYOUT;
    private String USER_ID;
    private BigDecimal COLUMN_INDEX;
    private BigDecimal PORTLET_INDEX;
    private BigDecimal PORTLET_MODE;
    private String     progRef;
    private String     languageCode;
    private String[]   alertAppsList;
    private String portletCode;

    private List<USRVO>  userPortletsDel;
    private List<USRVO>  userPortletsAdd;
    private List<SYS_PARAM_USR_ALLOWED_PORTLETSVO>  userAllowedPortletsDel;
    private List<SYS_PARAM_USR_ALLOWED_PORTLETSVO>  userAllowedPortletsAdd;
    private List<String> userWidgetDefLst;
    private BigDecimal   tellerCode;
    private Boolean      exceptionConfirmed;
    private BigDecimal employeeID;
    private String userName;
    private String enablePortletAXS;

    private String language;
    private String appName;

    private BigDecimal   mrqMsgNbr;

    public String getIMG_URL()
    {
        return IMG_URL;
    }
    public void setIMG_URL(String iMGURL)
    {
        IMG_URL = iMGURL;
    }
    public String getABV_DESC_KEY()
    {
        return ABV_DESC_KEY;
    }
    public void setABV_DESC_KEY(String aBVDESCKEY)
    {
        ABV_DESC_KEY = aBVDESCKEY;
    }
    public String getTITLE_KEY()
    {
        return TITLE_KEY;
    }
    public void setTITLE_KEY(String tITLEKEY)
    {
        TITLE_KEY = tITLEKEY;
    }
    public String getPORTLET_URL()
    {
        return PORTLET_URL;
    }
    public void setPORTLET_URL(String pORTLETURL)
    {
        PORTLET_URL = pORTLETURL;
    }
    public String getLAYOUT()
    {
        return LAYOUT;
    }
    public void setLAYOUT(String lAYOUT)
    {
        LAYOUT = lAYOUT;
    }
    public String getUSER_ID()
    {
        return USER_ID;
    }
    public void setUSER_ID(String uSERID)
    {
        USER_ID = uSERID;
    }
    public BigDecimal getCOLUMN_INDEX()
    {
        return COLUMN_INDEX;
    }
    public void setCOLUMN_INDEX(BigDecimal cOLUMNINDEX)
    {
        COLUMN_INDEX = cOLUMNINDEX;
    }
    public BigDecimal getPORTLET_INDEX()
    {
        return PORTLET_INDEX;
    }
    public void setPORTLET_INDEX(BigDecimal pORTLETINDEX)
    {
        PORTLET_INDEX = pORTLETINDEX;
    }
    public BigDecimal getPORTLET_MODE()
    {
        return PORTLET_MODE;
    }
    public void setPORTLET_MODE(BigDecimal pORTLETMODE)
    {
        PORTLET_MODE = pORTLETMODE;
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
     * @return the languageCode
     */
    public String getLanguageCode()
    {
        return languageCode;
    }
    /**
     * @param languageCode the languageCode to set
     */
    public void setLanguageCode(String languageCode)
    {
        this.languageCode = languageCode;
    }
    /**
     * @return the alertAppsList
     */
    public String[] getAlertAppsList()
    {
        return alertAppsList;
    }
    /**
     * @param alertAppsList the alertAppsList to set
     */
    public void setAlertAppsList(String... alertAppsList)
    {
        this.alertAppsList = alertAppsList;
    }
    public String getPortletCode()
    {
        return portletCode;
    }
    public void setPortletCode(String portletCode)
    {
        this.portletCode = portletCode;
    }
    public List<USRVO> getUserPortletsDel()
    {
        return userPortletsDel;
    }
    public void setUserPortletsDel(List<USRVO> userPortletsDel)
    {
        this.userPortletsDel = userPortletsDel;
    }
    public List<USRVO> getUserPortletsAdd()
    {
        return userPortletsAdd;
    }
    public void setUserPortletsAdd(List<USRVO> userPortletsAdd)
    {
        this.userPortletsAdd = userPortletsAdd;
    }
    /**
     * @return the userWidgetDefLst
     */
    public List<String> getUserWidgetDefLst()
    {
        return userWidgetDefLst;
    }
    /**
     * @param userWidgetDefLst the userWidgetDefLst to set
     */
    public void setUserWidgetDefLst(List<String> userWidgetDefLst)
    {
        this.userWidgetDefLst = userWidgetDefLst;
    }
    /**
     * @return the tellerCode
     */
    public BigDecimal getTellerCode()
    {
        return tellerCode;
    }
    /**
     * @param tellerCode the tellerCode to set
     */
    public void setTellerCode(BigDecimal tellerCode)
    {
        this.tellerCode = tellerCode;
    }
    /**
     * @return the exceptionConfirmed
     */
    public Boolean getExceptionConfirmed()
    {
        return exceptionConfirmed;
    }
    /**
     * @param exceptionConfirmed the exceptionConfirmed to set
     */
    public void setExceptionConfirmed(Boolean exceptionConfirmed)
    {
        this.exceptionConfirmed = exceptionConfirmed;
    }
    public List<SYS_PARAM_USR_ALLOWED_PORTLETSVO> getUserAllowedPortletsDel()
    {
        return userAllowedPortletsDel;
    }
    public void setUserAllowedPortletsDel(List<SYS_PARAM_USR_ALLOWED_PORTLETSVO> userAllowedPortletsDel)
    {
        this.userAllowedPortletsDel = userAllowedPortletsDel;
    }
    public List<SYS_PARAM_USR_ALLOWED_PORTLETSVO> getUserAllowedPortletsAdd()
    {
        return userAllowedPortletsAdd;
    }
    public void setUserAllowedPortletsAdd(List<SYS_PARAM_USR_ALLOWED_PORTLETSVO> userAllowedPortletsAdd)
    {
        this.userAllowedPortletsAdd = userAllowedPortletsAdd;
    }
    public String getPORTLET_CODE()
    {
        return PORTLET_CODE;
    }
    public void setPORTLET_CODE(String pORTLETCODE)
    {
        PORTLET_CODE = pORTLETCODE;
    }
    public BigDecimal getEmployeeID()
    {
        return employeeID;
    }
    public void setEmployeeID(BigDecimal employeeID)
    {
        this.employeeID = employeeID;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getEnablePortletAXS()
    {
        return enablePortletAXS;
    }
    public void setEnablePortletAXS(String enablePortletAXS)
    {
        this.enablePortletAXS = enablePortletAXS;
    }
    public BigDecimal getMrqMsgNbr()
    {
        return mrqMsgNbr;
    }
    public void setMrqMsgNbr(BigDecimal mrqMsgNbr)
    {
        this.mrqMsgNbr = mrqMsgNbr;
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
    
}
