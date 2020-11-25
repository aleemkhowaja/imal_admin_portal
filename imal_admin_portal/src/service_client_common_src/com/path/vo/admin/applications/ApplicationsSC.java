package com.path.vo.admin.applications;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class ApplicationsSC extends GridParamsSC{
 
	private String userId;
	private BigDecimal compCode;
	private String webAppsOnly;
	private String screenSrc;
	 
	public ApplicationsSC()
	{
		super.setSearchCols(new String[] { "APP_NAME", "LONG_DESC", "LONG_DESC_AR", "LONG_DESC_FR", "APP_DESC", "APP_DESC_AR",
			    "APP_DESC_FR" });
	}
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public BigDecimal getCompCode() {
		return compCode;
	}


	public void setCompCode(BigDecimal compCode) {
		this.compCode = compCode;
	}

	public String getWebAppsOnly()
	{
	    return webAppsOnly;
	}

	public void setWebAppsOnly(String webAppsOnly)
	{
	    this.webAppsOnly = webAppsOnly;
	}

	public String getScreenSrc()
	{
	    return screenSrc;
	}

	public void setScreenSrc(String screenSrc)
	{
	    this.screenSrc = screenSrc;
	}
 

}
