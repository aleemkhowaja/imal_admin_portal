/**
 * 
 */
package com.path.bo.security;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.vo.common.SessionCO;

import net.sf.json.JSONObject;
/**
 * @author rwilson
 * 
 */
public class CustomLoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint
{
    	
    public CustomLoginUrlEntryPoint(String loginFormUrl) 
    {
		super(loginFormUrl);
	}
	protected final static Log log = Log.getInstance();
	@Override
	protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception)
	{
//	    	log.error("[PATH-INFO-to be removed]  determineUrlToUseForThisRequest");
		HttpSession session = request.getSession(true);
		String j_username = request.getParameter("j_username");
		String j_password = request.getParameter("j_password");
		String loginUrl = getLoginFormUrl();
		if(j_username!=null)
		{
		        /**
		         * [MarwanMaddah]:
		         * we faced a problem on the decryption process in case the encrypted password finish by =
		         * BUG #595114 CDMI170428-login to applications from landing page
		         */
            		try
            		{
            		   j_username = URLEncoder.encode(j_username,ConstantsCommon.ENCODING_TYPE_UTF); 
            		   j_password = URLEncoder.encode(j_password,ConstantsCommon.ENCODING_TYPE_UTF);
            		}
            		catch(UnsupportedEncodingException e1)
            		{
            		   log.error(e1, "Error during encoding process"); 	
            		}
            		/**
            		 * 
            		 */
			loginUrl = "/login/unSecureAction_automaticLogin?j_username=" + j_username + "&j_password=" + j_password;
			
			// When accessing directly to a screen without clicking on menu leaf,
			// save the menuVar result into session, to be redirected to.
			String menuVar = request.getParameter("menuVar");
			String appName = request.getParameter("appName");
			String loginCompCode = request.getParameter("login_comp_code");
			String loginBraCode = request.getParameter("login_bra_code");
			String favoriteId = request.getParameter("favoriteId");
			String appId = request.getParameter("appId");
			String scannedCIFNo = request.getParameter("scannedCIFNo");
			String runningDateRET = request.getParameter("runningDateRET");
			String externalScreen = request.getParameter("externalScreen");
			String originalProgRef = request.getParameter("originalProgRef");
			String originalAppName = request.getParameter("originalAppName");
			String originalAppUrl = request.getParameter("originalAppUrl");
			String extAppName = request.getParameter("extAppName");
			String destinationScreenUrl = request.getParameter("destinationScreenUrl");
			String destinationProgRef = request.getParameter("destinationProgRef");
			String additionalParams = request.getParameter("additionalParams");
			String screenTitle = request.getParameter("screenTitle");
			
			SessionCO sessionCO = new SessionCO();
			session.setAttribute(ConstantsCommon.SESSION_VO_ATTR,sessionCO);
			sessionCO.setCompanyCode(new BigDecimal(loginCompCode));
			sessionCO.setBranchCode(new BigDecimal(loginBraCode));
			
			String language = request.getParameter("language");
			if(language != null)
			{
				loginUrl = loginUrl.concat("&request_locale=" + language.toLowerCase());
				sessionCO.setLanguage(language);
			}
			
			
			/**
			 * added for the path-session-interceptor 
			 */
			sessionCO.setUserName(j_username);
			/**
			 * 
			 */
			if(menuVar != null  || appName != null)
			{
				if (menuVar != null)
				{
				    sessionCO.setDirectMenuVar(menuVar);
				    if(StringUtil.isNotEmpty(screenTitle))
				    {	
					JSONObject additionalParamsObj = new JSONObject();
					try
					{
					    additionalParamsObj.put("screenTitle", URLEncoder.encode(screenTitle, "UTF8"));
					}
					catch(Exception e)
					{
					    log.error(e,"Error Encoding screen title");
					}
					sessionCO.setAdditionalParamsQueryString(additionalParamsObj.toString());
				    }
				}
				
				if (appName != null)
				{
				    sessionCO.setCurrentAppName(appName);
				}
			}
			
			if(!StringUtil.nullToEmpty(scannedCIFNo).isEmpty())
			{
			    sessionCO.setScannedCIFNo(new BigDecimal(scannedCIFNo));
			}
			if(!StringUtil.nullToEmpty(runningDateRET).isEmpty())
			{
			    try
			    {
				sessionCO.setRunningDateRET(DateUtil.parseDate(runningDateRET, DateUtil.DEFAULT_DATE_FORMAT));
			    }
			    catch(BaseException e)
			    {
				log.error(e,"Error Setting running Date before login");
			    }
			}
			if(favoriteId != null)
			{
			    sessionCO.setFavoriteId(favoriteId);
			}
			if(appId != null)
			{
			    sessionCO.setAppId(appId);
			    sessionCO.setCurrentAppName(appId);
			    sessionCO.setFavoriteId(null);
			}
			if(externalScreen != null) //external screen
			{
			    sessionCO.setExternalScreen(externalScreen);
			    sessionCO.setOriginalAppName(originalAppName);
			    sessionCO.setOriginalProgRef(originalProgRef);
			    sessionCO.setCurrentAppName(extAppName);
			    sessionCO.setOriginalAppUrl(originalAppUrl);
			    // //TP 475542 in case of External Screen From Menu is opened,
			    // the additional params will be as Query String and not JSON String
			    sessionCO.setAdditionalParamsQueryString(additionalParams);
			}
			if(destinationScreenUrl != null) //opening alerts from another application
			{
			    sessionCO.setDestinationScreenUrl(destinationScreenUrl);
			    sessionCO.setDestinationProgRef(destinationProgRef);
			    sessionCO.setCurrentAppName(appName);
			    sessionCO.setOriginalAppUrl(originalAppUrl);
			    HashMap<String,Object> hm = (HashMap<String,Object>)CommonMethods.returnJsonObjectFromStr(HashMap.class, additionalParams);
			    sessionCO.setAdditionalParamsMap(hm);
			}
			
		}
		if(ConstantsCommon.SECURITY_ENCRYPTPARAMS_ENABLED)
		{    
		    try
		    {
			CommonMethods.returnUniqueSessionToken(session);
			CommonMethods.returnEncryptionPassword(session);
			loginUrl = SecurityUtils.returnEncryptedNoPaddingUrl(loginUrl,true,session);
		    }
		    catch(Exception e)
		    {
			e.printStackTrace();
			log.error(e,"Error Encrypting loginUrl");
		    }
		}
		return loginUrl;
	}
}
