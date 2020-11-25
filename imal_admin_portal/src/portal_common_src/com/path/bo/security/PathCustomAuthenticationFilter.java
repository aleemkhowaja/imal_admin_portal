package com.path.bo.security;

import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.path.bo.common.BaseServices;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.login.LoginBO;
import com.path.lib.common.base.BaseServicesImpl;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.SecurityUtilsExt;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.common.SessionCO;

/**
 * 
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Denisk Haddad
 * 
 *          PathCustomAuthenticationFilter.java used to perform authentication
 *          check upon login to the application
 */
public class PathCustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
	private LoginBO loginBO;
	private final Log log = Log.getInstance();
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException
	{
	    String username 	= null;
	    HttpSession session = null;
		try {
		    	PathWebAuthDets det = (PathWebAuthDets)authenticationDetailsSource.buildDetails(request);
		    	username = request.getParameter(getUsernameParameter());
			String password = request.getParameter(getPasswordParameter());
			//user captcha text
			String captchaUserText  = det.getCaptchaUserText();
			String _fromLoginFlag = det.getFromLoginFlag();
			String sessionID = det.getParamSessionId();
			String hostName = returnRealIP(request);
			
			// stripping hostNAme to 20 characters.
			if(hostName != null && hostName.length() > 50)
			{
			   hostName = hostName.substring(0,50);
			}
			String appName = ConstantsCommon.returnCurrentAppName();
			session = request.getSession();
			
			SessionCO sesCO = (SessionCO) session.getAttribute(ConstantsCommon.SESSION_VO_ATTR);
			//case IE weblogic creating new session on calling j_spring_security_check on autologin.jsp
            	    	if(sesCO == null && sessionID != null && !sessionID.equals(session.getId()))
            	    	{
                		// fill params in CO from request
            	    	    	sesCO = new SessionCO();
                		sesCO.setCurrentAppName(det.getAppName());
                		sesCO.setCompanyCode(new BigDecimal(det.getLogin_comp_code()));
                		sesCO.setBranchCode(new BigDecimal(det.getLogin_bra_code()));
                		if(!StringUtil.nullToEmpty(det.getRunningDateRET()).isEmpty())
                		{
                		    sesCO.setRunningDateRET(DateUtil.parseDate(det.getRunningDateRET(), DateUtil.DEFAULT_DATE_FORMAT));
                		}
                		if(!StringUtil.nullToEmpty(det.getScannedCIFNo()).isEmpty())
                		{
                		    sesCO.setScannedCIFNo(new BigDecimal(det.getScannedCIFNo()));
                		}
                		if(!StringUtil.nullToEmpty(det.getExternalScreen()).isEmpty())
                		{
                		    sesCO.setExternalScreen(det.getExternalScreen());
                		    sesCO.setOriginalAppName(det.getOriginalAppName());
                		    sesCO.setOriginalProgRef(det.getOriginalProgRef());
                		    sesCO.setOriginalAppUrl(det.getOriginalAppUrl());
                		    //TP 475542
                		    sesCO.setAdditionalParamsQueryString(det.getAdditionalParams());
                		}
                		session.setAttribute(ConstantsCommon.SESSION_VO_ATTR, sesCO);
            	    	}
			
            	    	// take the language Locale Language of the login Page
            	    	String loginPageLang = (String) session.getAttribute("localLang");
            	    	// right capthca text
            	    	String captchaText  = (String) session.getAttribute("captchaText");
            	    	
            	    	if(loginPageLang != null)
            	    	{
            	    	    // convert the language to upper case since in login page is is locale Language
            	    	    loginPageLang = loginPageLang.toUpperCase();
            	    	}
			int allowAccess = -1;
			if (sesCO == null) 
			{
			    /**
			     * [MarwanMaddah]:#BUG 519398 log in - Invalid Logon UserID and Password
			     * In case of CTRl+SHIFT+DELETE in Chrome browser
			     * the session will be empty in this case sesCO will be null and if login screen is opened before that 
			     * any try to login with valid user/password will return invalid
			     * because the process will enter here without any encryption for the password.
			     * to avoid that i change the below process by let the login process in the encryption process.
			     */			    
			            sesCO = new SessionCO();
			            if(!StringUtil.nullToEmpty(det.getAppName()).isEmpty())
			            {			        	
			        	sesCO.setCurrentAppName(det.getAppName());
			            }
			            else
			            {
			        	sesCO.setCurrentAppName(ConstantsCommon.returnCurrentAppName());
			            }
			            
			            if(loginPageLang == null)
			            {
			        	loginPageLang = ConstantsCommon.LANGUAGE_ENGLISH;
			            }
			            sesCO.setLanguage(loginPageLang);
			            session.setAttribute(ConstantsCommon.SESSION_VO_ATTR, sesCO);
			            
			            String[] res = loginBO.encryptAuthenticateUser(username, password, hostName, appName,loginPageLang, ConstantsCommon.returnAppVersion(),session.getId(),captchaText,captchaUserText);
					    password = res[0];
					    allowAccess = Integer.parseInt(res[1]);
					    // TP #933826 :ABSAI190603 - Cannot change iMAL password from Java applications
					    sesCO.setAuthenticatedBy(res[2]);
					    /**
					     * 
					     */
			}
			else 
			{
			    if(sesCO.getCurrentAppName() != null)
			    {
				 appName =  sesCO.getCurrentAppName();
			    }
			    if(!StringUtil.nullToEmpty(request.getParameter("language")).isEmpty())
			    {
			    	sesCO.setLanguage(request.getParameter("language"));
			    	//session.setAttribute(ConstantsCommon.SESSION_VO_ATTR, sesCO);
			    }
			    //branch,comp null means from login screen not autologin process
			    if(sesCO.getBranchCode() == null && sesCO.getCompanyCode() == null)
			    {
				String[] res = loginBO.encryptAuthenticateUser(username, password, hostName, appName,loginPageLang, ConstantsCommon.returnAppVersion(),session.getId(),captchaText,captchaUserText);
				password = res[0];
				allowAccess = Integer.parseInt(res[1]);
				// TP #933826 :ABSAI190603 - Cannot change iMAL password from Java applications
				sesCO.setAuthenticatedBy(res[2]);
			    }
			    else
			    {
				/**
				 * [MarwanMaddah]:#BUG 525057-System generating "Invalid Logon ID and password" after being logged in Automatically to CSM from Assets 
				 * The flag fromLoginFlag has been added to cover this Bug
				 * to know that the request is from login screen 
				 * in this case we have to pass by the encryption process even if the compCode and branchCode are not null
				 * to cover the case where user open 2 application in parallel, both are on the login screen
				 * then enter in the first app, pass through the included screens and open an external screen 
				 * from the second application
				 * then after that user login in to second application from the login screen which is already opened.
				 */
				if(ConstantsCommon.ONE.equals(_fromLoginFlag))
				{
				    String[] res = loginBO.encryptAuthenticateUser(username, password, hostName, appName,null,ConstantsCommon.returnAppVersion(),session.getId(),captchaText,captchaUserText);
				    password     = res[0];
				    allowAccess  = Integer.parseInt(res[1]);
				    // TP #933826 :ABSAI190603 - Cannot change iMAL password from Java applications
				    sesCO.setAuthenticatedBy(res[2]);
				}
				else
				{
				    password = SecurityUtils.decryptNoPadding(password,SecurityUtilsExt.returnAlgorithmCbcNopaddingPwd());
				    //TP 771917 Issue at ICD environment ICDI1800005. password comes with extra password at the end
				    password = password.trim();
				    //autologin, password already encrypted in authentication object
				    String[] res = loginBO.authenticateUserReturningAuthBy(username, password, hostName, appName,null, ConstantsCommon.returnAppVersion(),sessionID,Boolean.TRUE, null, null, null);
				    allowAccess  = Integer.parseInt(res[0]);
				    // TP #933826 :ABSAI190603 - Cannot change iMAL password from Java applications
				    sesCO.setAuthenticatedBy(res[1]);
				}
			    }
			}
			if(allowAccess == 1)
			{
			    	// on success remove captcha from the session
			    	session.removeAttribute("captchaText");
				// basically to check the concurrent session login
				super.attemptAuthentication(request, response);
				// currently the same role as in application_security.xml could be
				// changed per user later on
				String userRole = "ROLE_DESKTOP_ACCESS";
				Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority(userRole));
				resetSessionToken(session);
				return new UsernamePasswordAuthenticationToken(username, password, authorities);
			}
			else if(allowAccess == ConstantsCommon.NO_OLD_PWD_UPON_LOGIN || allowAccess == ConstantsCommon.OLD_PWD_UPON_LOGIN_EXSTS 
				|| allowAccess == ConstantsCommon.OLD_PWD_UPON_PWD_EXPIRY
				|| allowAccess == ConstantsCommon.PASSWD_SET_BY_ADMIN)// redirect to Change Password Screen
			{
			    	// on success remove captcha from the session
			    	session.removeAttribute("captchaText");
			    	// basically to check the concurrent session login
				super.attemptAuthentication(request, response);
				sesCO.setAllowAccess(allowAccess);
				session.setAttribute("Change_PWD", allowAccess);
				// currently the same role as in application_security.xml could be
				// changed per user later on
				String userRole = "ROLE_CHANGEPWD_ACCESS";
				Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority(userRole));
				resetSessionToken(session);
				return new UsernamePasswordAuthenticationToken(username, password, authorities);
			}
			else
			{
				log.error("Login Error: Access Denied");
				throw new BadCredentialsException("Access Denied");
			}
		}  
		catch (Exception e) 
		{
		    if(e instanceof BadCredentialsException)
		    {
        		try
        		{
        		    // if captcha is enabled
        		    if(ConstantsCommon.ONE.equals(session.getAttribute("captchaEnabled")))
        		    {
        			UsrCO user;
        			user = loginBO.returnAdDetails(username);
        			BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider
        				.getApplicationContext().getBean("baseServices");
        			if(user != null)
        			{
        			    // if number of unsuccessful logins greater than nbr
        			    // of captcha we should display the capthca
        			    if(user.getUNSUCCESS_LOGINS().compareTo(
        					    baseServices.returnCommonLibBO().returnPthCtrl().getNBR_BEF_CAPTCHA()) > -1)
        			    {
        				session.setAttribute("captchaEnabled", ConstantsCommon.TWO);
        			    }
        			}
        		    }
        		}
        		catch(BaseException e1)
        		{
        		    log.error(e1, "[PATH INFO] Error in PathCustomAuthenticationFilter capthca verification");
        		}
		    }
		    log.error(e,"[PATH INFO] Error in PathCustomAuthenticationFilter");
		    resetSessionToken(session);
		    throw new BadCredentialsException(e.getMessage(),e);
		}
	}
	
	private void resetSessionToken(HttpSession session)
	{
	    //TP 692485 BMOUPI180328  to randomize token after login
	    CommonMethods.returnUniqueSessionToken(session,true);
	}

	public LoginBO getLoginBO()
	{
		return loginBO;
	}

	public void setLoginBO(LoginBO loginBO)
	{
		this.loginBO = loginBO;
	}
	
        private String returnRealIP(HttpServletRequest request) throws UnknownHostException
        {
        	String ip = request.getHeader("x-forwarded-for");
        	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        	{
        	    ip = request.getHeader("Proxy-Client-IP");
        	}
        	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        	{
        	    ip = request.getHeader("WL-Proxy-Client-IP");
        	}
        	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        	{
        	    ip = request.getRemoteHost();
        	}
        
        	return ip;
        }
}
