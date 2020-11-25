package com.path.bo.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * sets additional properties from request to be used in the pathcustomauthenticationfilter on autologin
 * @author PatriciaNasrallah
 *
 */
public class PathWebAuthDets extends WebAuthenticationDetails
{
    private final String login_comp_code;
    private final String login_bra_code;
    private final String scannedCIFNo;
    private final String runningDateRET;
    private final String appName;
    private final String paramSessionId;
    private final String externalScreen;
    private final String originalProgRef;
    private final String originalAppName;
    private final String originalAppUrl;
    private final String additionalParams;
    private final String fromLoginFlag;
    private final String captchaUserText;
    public PathWebAuthDets(HttpServletRequest request) {
	    super(request);
	    this.login_comp_code = request.getParameter("login_comp_code");
	    this.login_bra_code = request.getParameter("login_bra_code");
	    this.scannedCIFNo = request.getParameter("scannedCIFNo");
	    this.runningDateRET = request.getParameter("runningDateRET");
	    this.appName = request.getParameter("appName");
	    this.paramSessionId = request.getParameter("paramSessionId");
	    this.externalScreen = request.getParameter("externalScreen");
	    this.originalProgRef = request.getParameter("originalProgRef");
	    this.originalAppName = request.getParameter("originalAppName");
	    this.originalAppUrl = request.getParameter("originalAppUrl");
	  //TP 475542
	    this.additionalParams = request.getParameter("additionalParams");
	    this.fromLoginFlag = request.getParameter("fromLoginFlag");
	    this.captchaUserText = request.getParameter("captchaUserText");
	  }

    public String getLogin_comp_code()
    {
        return login_comp_code;
    }

    public String getLogin_bra_code()
    {
        return login_bra_code;
    }

    public String getScannedCIFNo()
    {
        return scannedCIFNo;
    }

    public String getRunningDateRET()
    {
        return runningDateRET;
    }

    public String getAppName()
    {
        return appName;
    }

    public String getParamSessionId()
    {
        return paramSessionId;
    }

    public String getExternalScreen()
    {
        return externalScreen;
    }

    public String getOriginalProgRef()
    {
        return originalProgRef;
    }

    public String getOriginalAppName()
    {
        return originalAppName;
    }

    public String getOriginalAppUrl()
    {
        return originalAppUrl;
    }

    public String getAdditionalParams()
    {
        return additionalParams;
    }

    /**
     * @return the fromLoginFlag
     */
    public String getFromLoginFlag()
    {
        return fromLoginFlag;
    }

    public String getCaptchaUserText()
    {
        return captchaUserText;
    }

}
