package com.path.actions.common.login;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.path.actions.common.alerts.AlertsCommonMethods;
import com.path.bo.admin.branches.BranchesBO;
import com.path.bo.admin.companies.CompaniesBO;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.bpm.BpmEngineConstant;
import com.path.bo.common.customization.ThemeCustomizationBO;
import com.path.bo.common.login.LoginBO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.SYS_PARAM_LANGUAGESVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.dbmaps.vo.USER_FAVORITESVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.common.util.UnicodeUtil;
import com.path.struts2.lib.common.PathLocalizedTextUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.struts2.lib.common.base.PathActionContextMethods;
import com.path.vo.admin.branches.BranchesSC;
import com.path.vo.admin.companies.CompaniesSC;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.ThemeCustomizationCO;
import com.path.vo.common.customization.ThemeCustomizationConstant;

import net.sf.json.JSONObject;

public class UnSecureAction extends BaseAction
{
    String LOGIN    = "login";
    String PRELOGIN = "prelogin";
    
    String AUTOMATIC_LOGIN = "autoLogin";

    String j_username;
    String j_password;

    private LoginBO loginBO;
    private CompaniesBO companiesBO;
	
    private BranchesBO branchesBO;
    
    /**
     * Load the theme for the login
     */
    private ThemeCustomizationBO themeCustomizationBO;
    
    private String enableScrConf;
    /**
     * Used to return String buffer as response
     */
    private InputStream inputStream;
    
    /**
     * Used to return css stream
     */
    private InputStream cssStream;
    /**
     * Used to return css image
     */
    private InputStream imageStream;
    
    private String imageRef;
    private ThemeCustomizationCO themeCustomizationCO = new ThemeCustomizationCO();
    // used for missing details returning like ctsmessages
    private String languages;	
    
    /** 
     * 
     * Used for  calling upon server start to initialize needed Data
     *
     */
    private static Object helpLock = new Object(); 
    private static Object scrConfigLock = new Object(); 
    private static Object refDBDetailsLock = new Object(); 
    private static Object recLogLock = new Object(); 
    private static Object trackChangesLock = new Object(); 
    private static Object isBpmv7Lock = new Object();
    public void initializeClientData()
    {
	// setting help Server URL from property File PathRemoting.properties
	synchronized(helpLock)
	{
	    try
	    {
		ConstantsCommon.HELP_SERVER_URL = StringUtil.nullToEmpty(PathPropertyUtil.returnPathPropertyFromFile("PathRemoting", "helpServerURL"));
	    }
	    catch(Exception e)
	    {
		log.error(e,"Error in Reading Property translation.reference.db.enabled from PathRemoting.properties");
	    }
	}
	synchronized(scrConfigLock)
	{
	    ConstantsCommon.SCREEN_CONFIG = NumberUtil.parseInt(enableScrConf);
	}
	// setting flag for enabling reference Database details check and send in Translation/Labeling screen
	synchronized(refDBDetailsLock)
	{
	    String refDBEnabled = "0";
	    try
	    {
		refDBEnabled = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting", "translation.reference.db.enabled");
	    }
	    catch(Exception e)
	    {
		refDBEnabled = "0";
		log.error(e,"Error in Reading Property translation.reference.db.enabled from PathRemoting.properties");
	    }
	    ConstantsCommon.ENABLE_REFERENCE_DB_TRANS_PUSH = NumberUtil.parseInt(refDBEnabled);
	}
	
	// setting flag for enabling caching of static files (JS, CSS,...) for browser
	synchronized(scrConfigLock)
	{
	    String staticFileCacheEnabled = "0";
	    try
	    {
		staticFileCacheEnabled = StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile("PathRemoting",
			"caching.static.files.enabled"),"0").trim();
	    }
	    catch(Exception e)
	    {
		staticFileCacheEnabled = "0";
		log.warning(" Reading Property caching.static.files.enabled from PathRemoting.properties");
	    }
	    ConstantsCommon.ENABLE_STATIC_CACHING = NumberUtil.parseInt(staticFileCacheEnabled);
	}
	
	// setting flag for enabling tracking of transactions' update after approve changes 
	synchronized(trackChangesLock)
	{
	    String trackChangesEnabled = "0";
	    try
	    {
		trackChangesEnabled = StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile("PathRemoting",
			"tracking.updates.changes.enabled"),"0").trim();
	    }
	    catch(Exception e)
	    {
		trackChangesEnabled = "0";
		log.warning(" Reading Property tracking.updates.changes.enabled from PathRemoting.properties");
	    }
	    ConstantsCommon.ENABLE_TRACKING_CHANGES = NumberUtil.parseInt(trackChangesEnabled);
	}
	// IMPORTANT: This should be executed before using other FreeMarker classes!
	try
	{
	    freemarker.log.Logger.selectLoggerLibrary(freemarker.log.Logger.LIBRARY_JAVA);
	}
	catch(ClassNotFoundException e)
	{
	    log.error("Error in sEtting FreeMarker Logging to Path JDK Logging");
	    // intended to have print stack Trace here.
	    e.printStackTrace();
	}
	
	//set default timezone if exists, otherwise machine timezone is used.
	try
	{
	    String defaultTimeZone = StringUtil.nullToEmpty(PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties", "default.timezone")).trim();
	    if(!defaultTimeZone.isEmpty())
	    {
		TimeZone.setDefault(TimeZone.getTimeZone(defaultTimeZone));
	    }
	}
	catch(Exception e)
	{
	    log.error(e,"Error in Reading Property default.timezone from PathRemoting.properties");
	}
	
	// setting flag for enabling Record Log Feature screen
	synchronized(recLogLock)
	{
	    int recLogenabled = 0;
	    try
	    {
		String recLogProp = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting", "records.log.feature.enabled");
		if(recLogProp != null)
		{
		    recLogenabled = NumberUtil.parseInt(recLogProp);
		}
	    }
	    catch(Exception e)
	    {
		recLogenabled = 0;
		log.error(e,"Error in Reading Property records.log.feature.enabled from PathRemoting.properties");
	    }
	    ConstantsCommon.ENABLE_RECORDS_LOG_FEATURE = recLogenabled;
	}
	
	// setting flag for enabling SQL session trace
	// same refDBDetailsLock is used for synchronisation since not important to create new Objects
	synchronized(refDBDetailsLock)
	{
	    try
	    {
		String sqlSessionTraceProp = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting",
			"database.sqlsession.trace.enabled");
		if(ConstantsCommon.ONE.equals(StringUtil.nullToEmpty(sqlSessionTraceProp).trim()))
		{
		    ConstantsCommon.SQL_SESSION_TRACE_CODE = true;
		}
	    }
	    catch(Exception e)
	    {
		log.error(e, "Error in Reading Property database.sqlsession.trace.enabled from PathRemoting.properties");
	    }
	}

	// setting the Group and decimal separators if defined at level of PathRemoting
	synchronized(refDBDetailsLock)
	{
	    CommonMethods.initializeGroupDecSeparators();
	}
	
	// check if the used JBPM is of version 7 or not
	synchronized(isBpmv7Lock)
	{
		initIsBPMV7();
	}
	
    }
    
    /**
     * Method that check if the used JBPM is of version 7 or not
     */
    private void initIsBPMV7() 
    {
	// check BPM version
	try
	{
	    if(Boolean.valueOf(PathPropertyUtil.getPathRemotingProp("PathRemoting", "bpm.enabled")))
	    {
    	    	String bpmVersion = PathPropertyUtil.returnPathPropertyFromFile(BpmEngineConstant.PROPERTIES_FILE_NAME,
    	    		BpmEngineConstant.BPM_VERSION);
    	    	if(StringUtil.isNotEmpty(bpmVersion) && bpmVersion.startsWith("7"))
    	    	{
    	    	    BpmEngineConstant.IS_BPMV7 = true;
    	    	}
	    }
	}
	catch(Exception e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    /**
     * method called upon undeploy of web application
     */
    public void destroyData()
    {
	try
	{
	    com.path.lib.common.util.ThreadAttributes.removeThread();
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
    /**
     * 
     * Used to return Application Version and Build Version, used in Selenuim
     *
     */
    public String returnAppVersion()
    {
	try
	{
	    StringBuffer verBuffer = new StringBuffer();
	    verBuffer.append("APP_VERSION:" + ConstantsCommon.returnAppVersion());
	    verBuffer.append("\r\nAPP_BUILD:" + ConstantsCommon.returnAppInterBuildVersion() + " / " + ConstantsCommon.COMMON_COMP_VERSION);

	    inputStream = new ByteArrayInputStream(verBuffer.toString().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    return "SUCCESS_STRING";
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
    }
    /**
     * 
     * Used for clear cache of Web Version only in case of DB Update Applied after Deployment
     *
     */
    public String clearWebVersionCache()
    {
	try
	{
		// clear PTH_CTRL SO that in case of password encryption change to be able to reset the PTH control instead of restarting the server
		returnCommonLibBO().clearCachedObject("PTHCTRL");
		
	  // clearing the Cache of S_APP table Only
	  SessionCO sessCO = returnSessionObject();
	  String currentAppName = null;
	  if(sessCO == null)
	  {
	      Map<String, String[]> theParams = PathActionContextMethods.returnParameters();
	      if(theParams.get("appName") != null 
		      && theParams.get("appName") instanceof String[])
	      {
		  
		  String[] paramArr = (String[])theParams.get("appName");
		  currentAppName = paramArr[0];
		  
	      }
	  }
	  else
	  {
	      currentAppName = sessCO.getCurrentAppName();
	  }
	  
	  String patchNoConcat = "";
	  S_APPVO sAppVO = new S_APPVO();
	  if(currentAppName == null)
	  {
	      addActionError("Application Name not identified");
	  }
	  else
	  {
	      sAppVO.setAPP_NAME(currentAppName);
	      sAppVO = returnCommonLibBO().returnApplication(sAppVO);
	      // prepare the patch Number value if Exists
	      if(sAppVO != null)
	      {
		  BigDecimal patchNo = sAppVO.getPATCH_NO();
		  if(patchNo != null && BigDecimal.ZERO.compareTo(patchNo) <= 0)
		  {
		      patchNoConcat = patchNo.intValue()+"";
		      // patch length is 3 digits maximum
		      patchNoConcat = NumberUtil.fill("0", new BigDecimal(3 - patchNoConcat.length())).concat(patchNoConcat);
		  }
	      }
	      
	      addActionError("Application DB Version before clear cache: "+sAppVO.getWEB_VERSION()
	      + (patchNoConcat.isEmpty()? "" : " Patch: "+ patchNoConcat));
	  }
	  returnCommonLibBO().clearCachedObject("Applic");
	  if(currentAppName != null)
	  {
        	  sAppVO = returnCommonLibBO().returnApplication(sAppVO);
        	  BigDecimal patchNo = sAppVO.getPATCH_NO();
        	  patchNoConcat = "";
		  if(patchNo != null && BigDecimal.ZERO.compareTo(patchNo) <= 0)
		  {
		      patchNoConcat = patchNo.intValue()+"";
		      // patch length is 3 digits maximum
		      patchNoConcat = NumberUtil.fill("0", new BigDecimal(3 - patchNoConcat.length())).concat(patchNoConcat);
		  }
        	  addActionError("Application DB Version after clear cache: "+sAppVO.getWEB_VERSION()+ (patchNoConcat.isEmpty()? "" : " Patch: "+ patchNoConcat));
        	  String[] serviceAppVersions = returnCommonLibBO().returnServiceAppVersions();
        	  addActionError("Portal Application Version: "+ ConstantsCommon.returnAppVersion());
        	  addActionError("Service Application Version: "+ serviceAppVersions[0]);
        	  String appInternalBuild = "Portal Application internal build version: "+ConstantsCommon.returnAppInterBuildVersion() + " / " + ConstantsCommon.COMMON_COMP_VERSION;
        	  String buildDate = ConstantsCommon.returnAppBuildDate();
        	  if(StringUtil.isNotEmpty(buildDate))
        	  {
        	      appInternalBuild = appInternalBuild .concat(" / Build Date-Time "+buildDate);
        	  }
        	  addActionError(appInternalBuild);
        	  String appInternalBuildService = "Service Application internal build version: "+serviceAppVersions[1]  + " / " + serviceAppVersions[2];
        	  String buildServiceDate = serviceAppVersions[3];
        	  if(StringUtil.isNotEmpty(buildServiceDate))
        	  {
        	      appInternalBuildService = appInternalBuildService .concat(" / Build Date-Time "+buildServiceDate);
        	  }
        	  addActionError(appInternalBuildService);
        	 
	  }
	  addActionError("Application clear cache DONE.");
	}
	catch(Exception e)
	{
	    log.error(e,"Error in clearWebVersionCache");
	    addActionError("Error in clearWebVersionCache");
	}
	return ERROR_ACTION;
    }
    /**
     * Method used for investigation and debugging reason to show the missing messages between application Code and database
     * @return Missing Message Codes in DB
     */
    public String showDbMissingMsgs()
    {
	    try
            {
                String missingData = returnCommonLibBO().returnMissingMessageCodes();
                missingData = StringUtil.nullToEmpty(missingData).trim().isEmpty()? "No Missing Messages":missingData;
                byte[] scriptByte = missingData.getBytes(FileUtil.DEFAULT_FILE_ENCODING);
                scriptByte = UnicodeUtil.addBOMToBytes(scriptByte, FileUtil.DEFAULT_FILE_ENCODING);
                inputStream = new ByteArrayInputStream(scriptByte);
            }
            catch(Exception e)
            {
                   handleException(e, null, null);
                try
                {
                   setInputStream(new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING)));
                }
                catch(UnsupportedEncodingException e1)
                {
                   log.error(e,"Error in showDbMissingMsgs");
                }
                return "fileError";
            }
            return "saveScript";
    }
    /**
     * Method used for investigation and debugging reason to show the empty desc and titles in ctsmessages table in database
     * @return Empty Messages in DB
     */
    public String showDbEmptyMsgs()
    {
       try
       {
           log.debug("languages:  "+languages);
           String emptyData = returnCommonLibBO().returnEmptyCtsMessages(languages);
           emptyData = StringUtil.nullToEmpty(emptyData).trim().isEmpty()? "No Empty Messages":emptyData;
           byte[] scriptByte = emptyData.getBytes(FileUtil.DEFAULT_FILE_ENCODING);
           scriptByte = UnicodeUtil.addBOMToBytes(scriptByte, FileUtil.DEFAULT_FILE_ENCODING);
           inputStream = new ByteArrayInputStream(scriptByte);
       }
       catch(Exception e)
       {
           handleException(e, null, null);
           try
           {
              setInputStream(new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING)));
           }
           catch(Exception e1)
           {
              log.error(e1,"Error in showDbEmptyMsgs");
           }
           return "fileError";
       }
       return "saveScript";
    }
    
    /**
     * Method used for investigation and debugging reason to show the corrupted desc and titls in ctsmessages table in database
     * @return Empty Messages in DB
     */
    public String showDbCorruptedMsgs()
    {
       try
       {
           log.debug("languages:  "+languages);
           String corruptedData = returnCommonLibBO().returnCorruptedCtsMessages(languages);
           corruptedData = StringUtil.nullToEmpty(corruptedData).trim().isEmpty()? "No Corrupted Messages":corruptedData;
           byte[] scriptByte = corruptedData.getBytes(FileUtil.DEFAULT_FILE_ENCODING);
           scriptByte = UnicodeUtil.addBOMToBytes(scriptByte, FileUtil.DEFAULT_FILE_ENCODING);
           inputStream = new ByteArrayInputStream(scriptByte);
       }
       catch(Exception e)
       {
           handleException(e, null, null);
           try
           {
              setInputStream(new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING)));
           }
           catch(Exception e1)
           {
              log.error(e1,"Error in showDbCorruptedMsgs");
           }
           return "fileError";
       }
       return "saveScript";
    }
 
    public void setInputStream(InputStream inputStream)
    {
	this.inputStream = inputStream;
    }
 
    /**
     * @return the language
     */
    public String getLanguages()
    {
	return languages;
    }

    /**
     * @param languages the languages of the ctsmessages to be retrieved from db
     */
    public void setLanguages(String languages)
    {
	this.languages = languages;
    }

    /**
     * 
     * Used for redirection from spring security to login Page upon login
     * Failure
     * 
     * @return redirection to login
     */
    public String failLogin()
    {
	try
	{
//	    log.error("[PATH INFO] UnsecureAction failLogin()");
	    Exception loginEx = (Exception) session.get("SPRING_SECURITY_LAST_EXCEPTION");
	    String errorMsg;
	    if(loginEx == null)
	    {
		errorMsg = getText("incorrect_credentials_key");
	    }
	    else
	    {
		errorMsg = loginEx.getLocalizedMessage();
	    }
	    addActionError(errorMsg);
	    return LOGIN;
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	    return ERROR;
	}
    }

    /**
     * 
     * Used for redirection from spring security to login Page upon expire of
     * URL
     * 
     * @return
     */
    public String expiredLogin()
    {
	try
	{
	    return LOGIN;
	}
	catch(Exception e)
	{
	    return ERROR;
	}
    }

    /**
     * method that logs out user from external opened application only in case a screen is opened without being initially logged in to this app separately
     */
    public void logoutExternal()
    {
	try
	{
	    HttpSession httpSession = ServletActionContext.getRequest().getSession();
//	    log.error("[PATH-INFO] logoutExternal  httpSession "+httpSession );
	    SessionCO sessCO = returnSessionObject();
//	    log.error("[PATH-INFO] logoutExternal  sessCO  "+sessCO +"  j_username  "+j_username);
	    if(sessCO != null && sessCO.getExternalScreen() != null && sessCO.getUserName().equals(j_username))
	    {
		//logout user from app only when external screen and without logging in to app separately
		if(sessCO.getManualLogIn() == null)
		{
//		    log.error("[PATH-INFO] logoutExternal------------ Logging out user invalidating Session with id "+httpSession.getId());
		    httpSession.invalidate();
		    ServletActionContext.getRequest().getSession(true).setAttribute("logoutExt", "1");
//		    log.error("[PATH-INFO] logoutExternal------------ New Session id "+ServletActionContext.getRequest().getSession().getId());
		}
		else
		{
//		    log.error("[PATH-INFO] logoutExternal------------ do not logout user");
		    // if application already opened separately and an external
		    // screen of that application was opened, on logout of
		    // original app do not logout user
		    // only clear external screen details
		    sessCO.setExternalScreen(null);
		    sessCO.setOriginalProgRef(null);
		    sessCO.setOriginalAppName(null);
		}
	    }
	}
	catch(Exception e)
	{
	    log.error(e,"Error in logoutExternal ");
	}
    }
    /**
     * 
     * Used for redirection from spring security to login Page upon logout
     * 
     * @return
     */
    public String logout()
    {
	try
	{
	    HttpSession httpSession = ServletActionContext.getRequest().getSession();
	    //in case of manual logout only 
	    if("1".equals(httpSession.getAttribute("manual_log_out")))//manual_log_out set in PathLogoutFilterHandler
	    {
        	    SessionCO sessCO = returnSessionObject();
        	    if(sessCO != null)
        	    {
        		    String sessionId = sessCO.getHttpSessionID();
        		    LoginBO loginBO = (LoginBO) ApplicationContextProvider.getApplicationContext().getBean("loginBO");
        		    String appName = sessCO.getCurrentAppName();
        		    String userName = sessCO.getUserName();
        		    // in case logout clicked on company branch screen the
        		    // sessionCO Ip is not filled yet.
        		    String ip = StringUtil.nullEmptyToValue(sessCO.getMachineIp(), returnIP());
        		    // even if HTTP session is not filled yet (in case logout
        		    // performed from company branch screen directly)
        		    if(httpSession.getId().equals(sessionId))
        		    {
        			// Remove the alertAjaxWebClient from the
        			// AlertsAjaxServlet map and close the consumer on the
        			// topic
        			AlertsCommonMethods.removeAlertClient(sessCO.getCurrentAppName(), AlertsCommonMethods.returnUsrCompBrKey(sessCO),
        				sessCO.getUserName(), sessCO.getHttpSessionID());
        		    }
        		    BigDecimal compCode = sessCO.getCompanyCode();
        		    BigDecimal branchCode = sessCO.getBranchCode();

//        		     log.error("[UnsecureAction]  logout() appName["+appName+"] userName["+userName+"] ip["+ip+"] compCode["+compCode+"] branchCode["+branchCode+"] sessionId["+sessionId+"]");
        		    loginBO.logoutUserFromModule(userName, appName, ip, compCode, branchCode, "0", sessionId, false);
        		    sessCO.setHttpSessionID(null);
        		    /**
        		     * [MarwanMaddah]
        		     * add new flag to the session to don't entry on the logoutFromModule process inside CustomSessionListener
        		     */
        		    httpSession.setAttribute("userLoggedOutFromModule", true);
        	    }
//        	    log.error("[PATH-INFO] logout ------------ invalidating session with id "+ServletActionContext.getRequest().getSession().getId()+"  httpSession.getId() "+httpSession.getId());
        	    ServletActionContext.getRequest().getSession().invalidate();
   		    ServletActionContext.getRequest().getSession(true).setAttribute("loggedout", "true");
//   		   log.error("[PATH-INFO] logout ------------ New Session id "+ServletActionContext.getRequest().getSession().getId());
        	    return PRELOGIN;
	    }
	    //in case logout method in unsecure action is called from browser not through the j_security_logout
	    return ERROR;
	}
	catch(Exception e)
	{
	    log.error(e,"Error in Logout ");
	    return ERROR;
	}
    }

    /**
     * 
     * Used for redirection to the login page when the user is logged out by
     * another one from interceptor MobilePreCalInterceptor
     * 
     * @return redirect to login page
     */ 
    public String forcedLoggedOut()
    {
	try
	{
//	    log.error("[PATH-INFO] UnsecureAction forcedLoggedOut");
	    session.put("forcedLoggedOut", "1");
	    //TP 481457 need this variable to show the set off message once , and not show it upon F5/Refresh
	    session.put("show_forced_logout_msg", "1");
	    addActionError(getText("forced_logged_out_key"));
	    //TP 481457 needed to set the request_locale parameter in url
	    languages =  StringUtil.nullEmptyToValue(getLocale().getLanguage(),"en");
    		
	    return "post_login";
	}
	catch(Exception e)
	{
	    log.error(e, "ERROR in forcedLoggedOut method");
	    addActionError(getText("exception_raised_key"));
	    return ERROR;
	}
    }

    /**
     * 
     * Used for redirection from spring security to login Page
     * 
     * @return
     */
    public String login()
    {
	try
	{
//	    log.error("[PATH INFO] UnsecureAction login()");
	    try
	    {
		SessionCO sessionCO = returnSessionObject(); 
		// fill default language of the application only upon first login, this should be applied before calling applyDirection method
		// and do not consider it if user changed the language and logged out from application
		if((sessionCO == null || sessionCO.getLanguage() == null) && session.get("user_consider_lang_after_logout") == null)
		{
			// detect default ISO code of the current code application
			String defIsoLangCode = returnDefaultAppISOLang(ConstantsCommon.returnCurrentAppName());
			Locale requested_locale = PathLocalizedTextUtil.localeFromString(defIsoLangCode, null);
			ActionContext.getContext().setLocale(requested_locale);
		}
		//TP 481457 attribute to consider the client language upon first login to the application, in case browser is closed and opening again
		session.put("consider_client_language","1");
	    }
	    catch(Exception e1)
	    {
		log.error(e1, "Error in reading default application Language upon login");
	    }
	    return PRELOGIN;
	}
	catch(Exception e)
	{
	    return ERROR;
	}
    }
    /**
     * Method used to return default ISO Language code for provided application
     * 
     * @param apName application Name whose ISO language to return
     * @return ISO Lang Code
     * @throws BaseException
     */
    private String returnDefaultAppISOLang(String apName) throws BaseException
    {
	String defLanguage;
	S_APPVO sAppVO = new S_APPVO();
	sAppVO.setAPP_NAME(apName);
	sAppVO = returnCommonLibBO().returnApplication(sAppVO);
	if(sAppVO == null)
	{
	    defLanguage = returnCommonLibBO().returnPthCtrl().getENABLE_LANGUAGE();
	}
	else
	{
	    defLanguage = sAppVO.getENABLE_LANGUAGE();
	    if(StringUtil.nullToEmpty(defLanguage).isEmpty())
	    {
		defLanguage = returnCommonLibBO().returnPthCtrl().getENABLE_LANGUAGE();
	    }
	}
	defLanguage = StringUtil.nullEmptyToValue(defLanguage, ConstantsCommon.LANGUAGE_ENGLISH);
	// return ISO Code for default language
	SYS_PARAM_LANGUAGESVO sysLangVO = returnCommonLibBO().returnLanguage(defLanguage);
	String defIsoLangCode = ConstantsCommon.LANGUAGE_ENGLISH.toLowerCase();
	if(sysLangVO != null)
	{
	    defIsoLangCode = StringUtil.nullEmptyToValue(sysLangVO.getISO_CODE(), defIsoLangCode);
	}
	return defIsoLangCode;
    }
    /**
     * Used for redirection from Pre-Login to login Page
     * @return
     */
    public String prelogin()
    {
    	try
    	{
//    	log.error("[PATH INFO] UnsecureAction prelogin()");
    	    boolean sessionInvalidate = false;
    	    clearMessages();
	    if(session.get("loggedout") == null)//not from manual logout
	    {
		if(session.get("forcedLoggedOut") != null)
		{
		  //TP 481457
		    String showForcedLogoutMsg = (String)session.get("show_forced_logout_msg");
		    
		    // kill the session if forced to logout and set attribute in new session to
		    // catch it in sessionTimeout method to display correct
		    // message
		    String currUsrLocaleLang = getLocale().getLanguage(); 
		    /*SessionCO sessCO = returnSessionObject();
		    String tracing = "[UnsecureAction.prelogin] forcedLoggedOut !=null Invalidating HTTP Session upon Force logout- HttpSession" +
					 "ID = "+ServletActionContext.getRequest().getSession().getId();
		    if(sessCO != null)
		    {
		    	tracing =tracing + " sessionCO.getCompanyCode() = "+sessCO.getCompanyCode()+" sessionCO.getBranchCode() = "+sessCO.getBranchCode()
		    	+" sessionCO.getCurrentAppName() = "+sessCO.getCurrentAppName()+" sessionCO.getUserName() = "+sessCO.getUserName();
		    }
		    log.error(tracing);*/
		    //in case of external screen, when the OPT_EXTENDED is not defined for the TARGET_PROG_REF we should adjust the displayed message to display the message "NO OPT Reference in Extended OPT table" instead of "Forced logged out" message.
		    String extrScreenErrMsg = (String)ServletActionContext.getRequest().getSession().getAttribute("externalScreenErrorActionMsg");
		    
		    ServletActionContext.getRequest().getSession().invalidate();
		    sessionInvalidate = true;
		    ServletActionContext.getRequest().getSession(true).setAttribute("forcedLoggedOut", "1");
		    ServletActionContext.getRequest().getSession(true).setAttribute("user_lang_before_force_logout", currUsrLocaleLang);
		    //TP 481457  show the set off message only, upon first redirection to login set off page and not later after F5/refresh
		    if(showForcedLogoutMsg != null)
		    {
			 if(StringUtil.isNotEmpty(extrScreenErrMsg))
			 {
			     addActionError(extrScreenErrMsg);
			 }
			 else
			 {
			     addActionError(getText("forced_logged_out_key"));
			 }
		    }			
		}
		else
		{
		    // Normal Login or SessionTimeout Need to show SEssion Time out message
		    if(session.get("userTokenSuspended") != null)
		    {
			if(session.get("fromChangePwd")!=null) 
			{
			    addActionError(getText("user_is_suspended_key"));
			}else 
			{
			    addActionError(getText("user_token_suspended_key"));
			}
			session.remove("userTokenSuspended");
			session.remove("fromChangePwd");
			String currUsrLocaleLang = getLocale().getLanguage(); 
			ServletActionContext.getRequest().getSession().invalidate();
			sessionInvalidate = true;
			ServletActionContext.getRequest().getSession(true).setAttribute("user_lang_before_force_logout", currUsrLocaleLang);
		    }
		    else if(session.get("read_client_side_language_after_timeout") != null)
		    {
			// coming from ordinary session Time out process
			addActionError(getText("session_timeout_key"));
			session.remove("read_client_side_language_after_timeout"); 
		    }

		}
	    }
	    else
	    {
		addActionMessage(getText("thank_you_key"));
		// attribute needed to specify whether to keep the user selected language upon logout, and not consider application default language
		session.put("user_consider_lang_after_logout","1");
		session.remove("loggedout");
	    }
	    
	    //In case of calling the prelogin directly from url and the session is still active (the user is authenticated), then redirect to contextRoot
	    //In case of Session().invalidate() we cannot access the session object
	    if(!sessionInvalidate) 
	    {
		//TP 481457 remove from session the client side language consideration on Normal Login, in all cases it could not exist
		session.remove("consider_client_language");
				
		SessionCO sessCO = returnSessionObject();
		if(sessCO != null && sessCO.getUserName() != null)
		{
		    return "APP_MAIN_CTXROOT";
		}
	    }
	    // captchaEnabled =0(always disabled),captchaEnabled =1(enabled but need to check unsuccessful logins) captchaEnabled =2(always enabled)
	    if(ServletActionContext.getRequest().getSession().getAttribute("captchaEnabled") == null)
	    {
		PTH_CTRLVO pth = returnCommonLibBO().returnPthCtrl();
		if(ConstantsCommon.ONE.equals(pth.getENABLE_CAPTCHA_YN()))
		{
		    ServletActionContext.getRequest().getSession().setAttribute("captchaEnabled", ConstantsCommon.ONE);
		    if((pth.getNBR_BEF_CAPTCHA() == null || pth.getNBR_BEF_CAPTCHA().compareTo(new BigDecimal(0)) == 0))
		    {
			ServletActionContext.getRequest().getSession().setAttribute("captchaEnabled",ConstantsCommon.TWO);
		    }
		}
		else
		{	
		    ServletActionContext.getRequest().getSession().setAttribute("captchaEnabled", ConstantsCommon.ZERO);
		}
	    }
    	   return LOGIN;
    	}
    	catch(Exception e)
    	{
    	    log.error(e,"Error in PreLogin");
    	    return ERROR;
    	}
    }
    
    /**
     * Used for time out redirection
     * @return
     */
    public String sessionTimeout()
    {
    	try
    	{
//    	    log.error("[PATH-INFO] SESSIONTIMEOUT");
    	    	if(session.get("forcedLoggedOut")==null)
    	    	{
    	    	    // set default application language upon session timeout, since not able to capture user language anymore
    	    	    try
    	    	    {
    	    		// detect default ISO code of the current code application
    	    		String defIsoLangCode = returnDefaultAppISOLang(ConstantsCommon.returnCurrentAppName());
    	    		Locale requested_locale = PathLocalizedTextUtil.localeFromString(defIsoLangCode, null);
    	    		ActionContext.getContext().setLocale(requested_locale);
    	    	    }
    	    	    catch(Exception e)
    	    	    {
    	    		log.error(e,"Error in returning default application language upon sessionTime out");
    	    	    }
    	    	    
    	    	    //TP 481457
    	    	    ServletActionContext.getRequest().getSession().setAttribute("read_client_side_language_after_timeout", "1");
    	    	    return PRELOGIN;
    	    	}
    	    	else
    	    	{
    	    	    // check the user language before forced logout to apply on login Page.
    	    	    if(session.get("user_lang_before_force_logout") != null)
    	    	    {
    	    		Locale requested_locale = PathLocalizedTextUtil.localeFromString((String)session.get("user_lang_before_force_logout"), null);
	    		ActionContext.getContext().setLocale(requested_locale);
	    		session.remove("user_lang_before_force_logout");
    	    	    }
    	    	 //if coming from force logout need to display correct message
    	    	    addActionError(getText("forced_logged_out_key"));
    	    	    session.remove("forcedLoggedOut");
    	    	}
    		return LOGIN;
    	}
    	catch(Exception e)
    	{
    		return ERROR;
    	}
    }

    public String automaticLogin()
    {
	try
	{
//	    log.error("[PATH INFO] UnsecureAction automaticLogin ");
		SessionCO sessionCO = returnSessionObject();
	    String apName = sessionCO.getCurrentAppName();
	    if(StringUtil.nullToEmpty(apName).isEmpty())
	    {	    	
	    	USER_FAVORITESVO userFavoritesVO = null;
	    	String favoriteId = sessionCO.getFavoriteId();
	    	if(favoriteId!=null)
	    	{
	    		userFavoritesVO  = returnCommonLibBO().returnFavMenuApp(new BigDecimal(favoriteId));
	    		sessionCO.setCurrentAppName(userFavoritesVO.getAPP_NAME());
	    		apName = userFavoritesVO.getAPP_NAME();
	    	}
	    }
	    log.debug("Automatic Login for application "+apName);
	    S_APPVO appVO = new S_APPVO();
	    appVO.setAPP_NAME(apName);
	    appVO = returnCommonLibBO().returnApplication(appVO);
	    if(appVO != null) 
	    {
		String appLocType = appVO.getAPP_LOCATION_TYPE();
		//	    log.error("[PATH INFO] UnsecureAction automaticLogin sessionCO.getCompanyCode() "+sessionCO.getCompanyCode());
		log.debug("Location Type for application "+apName + " is "+appLocType);
		//TP 934534 in case the Application is have access by Company
		if(ConstantsCommon.ONLY_COMP.equals(appLocType) || ConstantsCommon.COMP_BRANCH.equals(appLocType))
		{
		    BigDecimal theCompCode = sessionCO.getCompanyCode();
		    CompaniesSC companiesSC = new CompaniesSC();
		    companiesSC.setCompCode(theCompCode);
		    /**
		     * [MarwanMaddah]
		     * in case the user is LDAP user, we have to get the iMAL user information to get the company description 
		     * base on it.
		     * 
		     * Bug #567575 "the system is generating an error upon trying to login into CSM from Landing Page"
		     */
		    LoginBO loginBO  = (LoginBO) ApplicationContextProvider.getApplicationContext().getBean("loginBO");
		    UsrCO usrCO = loginBO.returnAdDetails(j_username);
		    if(usrCO!=null)
		    {
			companiesSC.setUserId(usrCO.getUSER_ID()==null?j_username:usrCO.getUSER_ID());		
		    }
		    else
		    {
			companiesSC.setUserId(j_username);
		    }
		    /**
		     * 
		     */

		    COMPANIESVO companiesVO = companiesBO.getCompaniesByUsrDetails(companiesSC);
		    if(companiesVO != null)
		    {
			log.debug("automatic Login Company returned for application "+apName + " and CompCode "+theCompCode);
			sessionCO.setCompanyName(companiesVO.getBRIEF_DESC_ENG());
		    }

		    //TP 934534  in case the Application is have access by Branch
		    if(ConstantsCommon.COMP_BRANCH.equals(appLocType))
		    {
			BigDecimal theBranchCode = sessionCO.getBranchCode();
			BranchesSC branchesSC = new BranchesSC();
			branchesSC.setCompCode(theCompCode);
			//	    log.error("[PATH INFO] UnsecureAction automaticLogin sessionCO.getBranchCode() "+sessionCO.getBranchCode());
			branchesSC.setBranchCode(theBranchCode);
			/**
			 * [MarwanMaddah]
			 * Bug #567575 "the system is generating an error upon trying to login into CSM from Landing Page"
			 */
			if(usrCO!=null)
			{
			    branchesSC.setUserId(usrCO.getUSER_ID()==null?j_username:usrCO.getUSER_ID());
			}
			else
			{
			    branchesSC.setUserId(j_username);
			}
			/**
			 * 
			 */
			BRANCHESVO branchesVO = branchesBO.getBranchesByUsrDetails(branchesSC);
			if(branchesVO != null)
			{
			    log.debug("automatic Login Branch returned for application "+apName + " and BranchCode "+theBranchCode);
			    sessionCO.setBranchName(branchesVO.getBRIEF_DESC_ENG());
			}
		    }
		}
	    }
	    else
	    {
		addActionError("Application Name = \""+apName+"\" for Automatic Login Not Available, Please Contact Administrator.");
		return ERROR;
	    }
	    /**
	     * 1076475 RKFHK200325 - Issue in session time out and closing application web page
	     */
	    String favoriteScrId = sessionCO.getFavoriteId(); //ServletActionContext.getRequest().getParameter("favoriteId");
	    if(!StringUtil.nullToEmpty(favoriteScrId).isEmpty())
	    {
			//get appname and menuvar
			 //get menuVar and appName from user_favorites_opt based on favoriteId
			USER_FAVORITESVO vo = returnCommonLibBO().returnFavMenuApp(new BigDecimal(favoriteScrId));
			if(vo!=null)
			{				
				sessionCO.setCurrentAppName(vo.getAPP_NAME());
				sessionCO.setDirectMenuVar(vo.getPROG_REF());
				if(StringUtil.isNotEmpty(vo.getDESCRIPTION()))
				{
					JSONObject additionalParamsObj = new JSONObject();
					additionalParamsObj.put("screenTitle", URLEncoder.encode(vo.getDESCRIPTION(),"UTF8"));
					sessionCO.setAdditionalParamsQueryString(additionalParamsObj.toString());
				}
			}
	    }
//	    log.error("[PATH INFO] UnsecureAction returning AUTOMATIC_LOGIN ");
	    //in case of first automatic login , we need to pass the flag ManualLogIn = "0", because in PreMain.jsp we will check on this flag to empty sessionCO attributes.
	    sessionCO.setManualLogIn("0");
	    return AUTOMATIC_LOGIN;
	}
	catch(Exception e)
	{
	    e.printStackTrace();
//	    log.error(e,"[PATH INFO] UnsecureAction AUTOMATIC_LOGIN returning error");
	    return ERROR;
	}
    }
    /**
     * Method to be called upon automatic login to application, in case of Websphere server ,TP 500032 Websphere automatic login Issue
     * @return Just redirection to PreMain.jsp page
     */
    public String checkAutoLogin()
    {
	try
	{
	    return "APP_MAIN_PAGE";
	}
	catch(Exception e)
	{
	    log.error(e,"[PATH INFO] UnsecureAction checkAutoLogin returning error");
	    handleException(e, null, null);
	    return ERROR;
	}
    }
    
    /**
     * Load the current active theme for the login page
     * 
     * @return
     */
    public String loadCssFromRepository()
    {
	try
	{
	    if(returnSessionObject()!=null) 
	    {
		String appName = StringUtil.nullEmptyToValue(returnSessionObject().getCurrentAppName(),
			ConstantsCommon.IMAL_APP_NAME);
		String css = themeCustomizationBO.constructCssInRepository(ThemeCustomizationConstant.LOGIN_STYLE_REF,
			appName);
		cssStream = new ByteArrayInputStream(css.getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    }else 
	    {
		 cssStream = new ByteArrayInputStream(new byte[]{});
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    cssStream = new ByteArrayInputStream(new byte[]{});
	}
	return "css";
    }
    
    /**
     * Return the image from the database based on image ref
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String returnImage()
    {
	try
	{
	    Map<String, byte[]> images;
	    if(session.containsKey("ImageUploaded"))
	    {
		images = (Map<String, byte[]>) session.get("ImageUploaded");
		if(images.containsKey(imageRef))
		{
		    byte[] fileBytes = images.get(imageRef);
		    imageStream = new ByteArrayInputStream(fileBytes);
		}
		else
		{
		    imageStream = returnImageFromRepo(imageRef, themeCustomizationCO.getThemeVO() == null ? null
			    : themeCustomizationCO.getThemeVO().getTHEME_ID());
		}
	    }
	    else
	    {
		imageStream = returnImageFromRepo(imageRef, themeCustomizationCO.getThemeVO() == null ? null
			: themeCustomizationCO.getThemeVO().getTHEME_ID());
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		imageStream = new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    }
	    catch(UnsupportedEncodingException e1)
	    {
		log.error(e1, "Error in reading the error message");
	    }
	    return ThemeCustomizationConstant.RESULT_RETURN_IMAGE_ERROR;
	}
	return ThemeCustomizationConstant.RESULT_RETURN_IMAGE;

    }
    
    	/**
	 * construct the captcha image
	 * @return
	 */
	public String loadCaptcha(){

		try {
		    Object[] o  = loginBO.generateCaptcha();
		    session.put("captchaText",(String) o[0]);
		    imageStream = new ByteArrayInputStream((byte[]) o[1]) ;
		}catch(Exception e)
		{	
		    System.out.println(e.getMessage());
		}
		return "returnImage";
	}
    /**
     * Return the image from the repository
     * 
     * @param imageRef
     * @param themeId
     * @return
     * @throws BaseException
     */
    private ByteArrayInputStream returnImageFromRepo(String imageRef, BigDecimal themeId) throws BaseException
    {
	ByteArrayInputStream bais = null;
	if(themeId != null)
	{
	    bais = new ByteArrayInputStream(themeCustomizationBO.readThemeStyleImage(imageRef, themeId));
	}
	return bais;
    }
    
    public String getJ_username()
    {
	return j_username;
    }

    public void setJ_username(String jUsername)
    {
	j_username = jUsername;
    }

    public String getJ_password()
    {
	return j_password;
    }

    public void setJ_password(String jPassword)
    {
	j_password = jPassword;
    }

    public void setCompaniesBO(CompaniesBO companiesBO)
    {
        this.companiesBO = companiesBO;
    }

    public void setBranchesBO(BranchesBO branchesBO)
    {
        this.branchesBO = branchesBO;
    }
    public void setEnableScrConf(String enableScrConf)
    {
        this.enableScrConf = enableScrConf;
    }

    public InputStream getInputStream()
    {
        return inputStream;
    }
    /**
     * @return the cssStream
     */
    public InputStream getCssStream()
    {
        return cssStream;
    }
    /**
     * @param cssStream the cssStream to set
     */
    public void setCssStream(InputStream cssStream)
    {
        this.cssStream = cssStream;
    }
    /**
     * @param themeCustomizationBO the themeCustomizationBO to set
     */
    public void setThemeCustomizationBO(ThemeCustomizationBO themeCustomizationBO)
    {
        this.themeCustomizationBO = themeCustomizationBO;
    }
    /**
     * @return the imageStream
     */
    public InputStream getImageStream()
    {
        return imageStream;
    }
    /**
     * @param imageStream the imageStream to set
     */
    public void setImageStream(InputStream imageStream)
    {
        this.imageStream = imageStream;
    }
    /**
     * @return the imageRef
     */
    public String getImageRef()
    {
        return imageRef;
    }
    /**
     * @param imageRef the imageRef to set
     */
    public void setImageRef(String imageRef)
    {
        this.imageRef = imageRef;
    }
    /**
     * @return the themeCustomizationCO
     */
    public ThemeCustomizationCO getThemeCustomizationCO()
    {
        return themeCustomizationCO;
    }
    /**
     * @param themeCustomizationCO the themeCustomizationCO to set
     */
    public void setThemeCustomizationCO(ThemeCustomizationCO themeCustomizationCO)
    {
        this.themeCustomizationCO = themeCustomizationCO;
    }
    public void setLoginBO(LoginBO loginBO)
    {
        this.loginBO = loginBO;
    }
    
}
