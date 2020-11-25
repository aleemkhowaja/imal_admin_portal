package com.path.vo.common.menu;

import java.math.BigDecimal;

import com.path.struts2.lib.common.BaseSC;

public class MenuSC extends BaseSC
{
    private String     appName;
    private String     progRef;
    private String     usrName;
    private String     language;
    private String     profType;
    private BigDecimal exclCategId;
    private BigDecimal progGateg;
    private BigDecimal categId;
    private String reportOrdering;
    /**
     * to indicate the version of the application WEB/PB or BOTH
     */
    private BigDecimal webPbVersion;
    /**
     * variable used to specify whether Application Under Reports OPT
     * (ConstantsCommon.REPORTS_OPT) is chosen in order to use it as filter in
     * corresponding SQL
     */
    private int checkRepReportsMenu;
    
    private String branchIsClosedUserLogged; 

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public String getUsrName()
    {
	return usrName;
    }

    public void setUsrName(String usrName)
    {
	this.usrName = usrName;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public String getProfType()
    {
	return profType;
    }

    public void setProfType(String profType)
    {
	this.profType = profType;
    }

    public BigDecimal getProgGateg()
    {
	return progGateg;
    }

    public void setProgGateg(BigDecimal progGateg)
    {
	this.progGateg = progGateg;
    }

    public BigDecimal getCategId()
    {
	return categId;
    }

    public void setCategId(BigDecimal categId)
    {
	this.categId = categId;
    }

    public int getCheckRepReportsMenu()
    {
        return checkRepReportsMenu;
    }

    public void setCheckRepReportsMenu(int checkRepReportsMenu)
    {
        this.checkRepReportsMenu = checkRepReportsMenu;
    }

    /**
     * @return the exclCategId
     */
    public BigDecimal getExclCategId()
    {
        return exclCategId;
    }

    /**
     * @param exclCategId the exclCategId to set
     */
    public void setExclCategId(BigDecimal exclCategId)
    {
        this.exclCategId = exclCategId;
    }

    public BigDecimal getWebPbVersion()
    {
        return webPbVersion;
    }

    public void setWebPbVersion(BigDecimal webPbVersion)
    {
        this.webPbVersion = webPbVersion;
    }

    public String getBranchIsClosedUserLogged()
    {
        return branchIsClosedUserLogged;
    }

    public void setBranchIsClosedUserLogged(String branchIsClosedUserLogged)
    {
        this.branchIsClosedUserLogged = branchIsClosedUserLogged;
    }
    public String getReportOrdering()
    {
        return reportOrdering;
    }

    public void setReportOrdering(String reportOrdering)
    {
        this.reportOrdering = reportOrdering;
    }
}
