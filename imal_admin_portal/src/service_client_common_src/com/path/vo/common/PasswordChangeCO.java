package com.path.vo.common;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.BaseObject;

public class PasswordChangeCO extends BaseObject
{ 
    String  oldPwd;
    String  newPwd;
    String  confirmPwd;
    Integer allowAccess;
    String  userName;
    String  sessionID;
    String  hostName;
    String  appName;
    String  language;
    BigDecimal compCode;
    BigDecimal branchCode;
    String captchaEnabled;
    String captchaText;
    String captchUserText;
    Date runningDate;
    String machineIp;
    Boolean fromAutoPass;
    
    public String getOldPwd()
    {
        return oldPwd;
    }
    public void setOldPwd(String oldPwd)
    {
        this.oldPwd = oldPwd;
    }
    public String getNewPwd()
    {
        return newPwd;
    }
    public void setNewPwd(String newPwd)
    {
        this.newPwd = newPwd;
    }
    public String getConfirmPwd()
    {
        return confirmPwd;
    }
    public void setConfirmPwd(String confirmPwd)
    {
        this.confirmPwd = confirmPwd;
    }
    public Integer getAllowAccess()
    {
        return allowAccess;
    }
    public void setAllowAccess(Integer allowAccess)
    {
        this.allowAccess = allowAccess;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    /**
     * @return the sessionID
     */
    public String getSessionID()
    {
        return sessionID;
    }
    /**
     * @param sessionID the sessionID to set
     */
    public void setSessionID(String sessionID)
    {
        this.sessionID = sessionID;
    }
    /**
     * @return the hostName
     */
    public String getHostName()
    {
        return hostName;
    }
    /**
     * @param hostName the hostName to set
     */
    public void setHostName(String hostName)
    {
        this.hostName = hostName;
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
     * @return the compCode
     */
    public BigDecimal getCompCode()
    {
        return compCode;
    }
    /**
     * @param compCode the compCode to set
     */
    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
    }
    /**
     * @return the branchCode
     */
    public BigDecimal getBranchCode()
    {
        return branchCode;
    }
    /**
     * @param branchCode the branchCode to set
     */
    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }
    public String getCaptchaEnabled()
    {
        return captchaEnabled;
    }
    public void setCaptchaEnabled(String captchaEnabled)
    {
        this.captchaEnabled = captchaEnabled;
    }
    public String getCaptchaText()
    {
        return captchaText;
    }
    public void setCaptchaText(String captchaText)
    {
        this.captchaText = captchaText;
    }
    public String getCaptchUserText()
    {
        return captchUserText;
    }
    public void setCaptchUserText(String captchUserText)
    {
        this.captchUserText = captchUserText;
    }
    public Date getRunningDate()
    {
        return runningDate;
    }
    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }
    public String getMachineIp()
    {
        return machineIp;
    }
    public void setMachineIp(String machineIp)
    {
        this.machineIp = machineIp;
    }
    /**
     * @return the fromAutoPass
     */
    public Boolean getFromAutoPass()
    {
        return fromAutoPass;
    }
    /**
     * @param fromAutoPass the fromAutoPass to set
     */
    public void setFromAutoPass(Boolean fromAutoPass)
    {
        this.fromAutoPass = fromAutoPass;
    }
    
}
