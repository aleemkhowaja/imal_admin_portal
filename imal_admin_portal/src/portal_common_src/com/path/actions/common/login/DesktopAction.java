package com.path.actions.common.login;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.opensymphony.xwork2.ActionContext;
import com.path.actions.common.alerts.AlertsCommonMethods;
import com.path.bo.admin.companies.CompaniesBO;
import com.path.bo.common.CachedConstantsCommon;
import com.path.bo.common.CommonLibBO;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.common.alerts.AlertsEngineBO;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.bpm.BpmCommonMethods;
import com.path.bo.common.login.LoginBO;
import com.path.bo.security.PathCustomAuthenticationFilter;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.BRANCHESVOKey;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.LOCVO;
import com.path.dbmaps.vo.PTH_CTRL1VO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.SYS_PARAM_LANGUAGESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.S_APPLOGVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.dbmaps.vo.USER_FAVORITESVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.PathLocalizedTextUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.struts2.lib.common.base.PathActionContextMethods;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.admin.user.UsrSC;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.BaseProcedureSC;
import com.path.vo.common.CommonLibCO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.DateParamSC;
import com.path.vo.common.DefaultCompBranchCO;
import com.path.vo.common.FieldsBusTransCO;
import com.path.vo.common.MainMenuVO;
import com.path.vo.common.PathCounterLcSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.core.ctsteller.CTSTELLERSC;

/**
 * 
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: mireillehaddad
 * 
 *          DesktopAction.java 	checkLoginCompBr used to redirect to specific actions from Welcome
 *          screen
 */
public class DesktopAction extends BaseAction
{
    private PathCustomAuthenticationFilter secureFilter;
    protected LoginBO loginBO;
    private CompaniesBO companiesBO;
    private COMPANIESVO companiesVO = new COMPANIESVO();
    private BRANCHESVO branchesVO = new BRANCHESVO();
    private String headerDecorator; // used in the header of the
    // decorator;AppMainHeader.jsp
    protected String appName; // used in decorator header;AppMainHeader.jsp
    protected String themeName;
    private String currentURL;// url that loads the screen, either Application or ComapnyBranch
    private String readOnlyProp = "true";
    private String welcMsg;
    private Date newUserRunDate;
    private Date newAppRunDate;
    private Date newRunningDate;
    private String newFrmtUserRunDate;
    private String newFrmtAppRunDate;
    private String overrideSession;
    private InputStream inputStream;
    
    private static final String usrSecurityRet = "user_security";
    private static final String csmCustomerRet = "csm_customer";
    private static final String omniAdminCustomer = "omniAdmin_customer";
    private static final String tfaCustomerRet = "tfa_customer";
    private static final String sadsCustomerRet = "sads_customer";
    private static final String fatcaCustomerRet = "fatca_customer";
    private static final String csmAdminCustomerRet = "csm_admin_customer";
    private static final String alertCustomerRet = "alert_customer";
    private static final String assetsCustomerRet = "assets_customer";
    private static final String loginCompBrRet = "login_comp_br";
    private static final String procCustomerRet = "proc_customer";
    private static final String eshrCustomerRet = "eshr_customer";
    private static final String espaCustomerRet = "espa_customer";
    private static final String esplCustomerRet = "espl_customer";
    private static final String imcoCustomerRet = "imco_customer";
    private static final String gateWayCustomerRet = "gateway_customer";
    private static final String atmpCustomerRet = "atmp_customer";
    private static final String SUCCESS_LOGIN ="checkLoginSucess";
    private static final String LOGINCOMPBR= "loginCompBr";
    private static final String LOGIN_LANDING_PAGE = "loginToLandingPage";
    private static final String ifrsCustomerRet = "ifrs_customer";
    private static final String rtrCustomerRet = "rtr_customer";
    
    protected static final String OMNI_THEME = "cupertino";
    protected static final String CORE_THEME = "cupertino";
    protected static final String SADS_THEME = "cupertino";
    protected static final String ESPL_THEME = "cupertino";
    protected static final String REPORTING_THEME = "redmond";
    protected static final String TFA_THEME = "redmond";
    protected static final String ACC_THEME = "cupertino";
    protected static final String PARAM_THEME = "cupertino";
    private static final String cmsCustomerRet = "cms_customer";// Cache Management Application
    private static final String accCustomerRet = "acc_customer";
    private static final String prmCustomerRet = "prm_customer";
    private static final String prfnCustomerRet = "prfn_customer";//TP 642900
    private static final String profCustomerRet = "prof_customer";// TP 872828
    private static final String rcsaCustomerRet = "rcsa_customer";// TP 928061
    private static final String openAPICustomer = "openAPI_customer";//TP 907642
    private static final String amlCustomerRet = "aml_customer";//TP 790433
    private static final String pmspCustomerRet = "pmsp_customer";//TP 984569
    private static final String tfaPCustomerRet = "tfap_customer";
    protected static final String GTW_THEME = "redmond";
    protected static final String ATMP_THEME = "redmond";//888860
    protected static final String OPEN_API_THEME = "redmond";//TP 907642
    protected static final String TFAP_THEME = "cupertino";

    
    private BigDecimal prevCompCode;
    private String     prevCompDesc;
    private BigDecimal prevBranchCode;
    private String     prevBranchDesc;
    private String     prevHttpSessionId;

    List languages = new ArrayList();
    int langCount;
    private String language;
    
    public List<MainMenuVO> lstMenu = new ArrayList();

    private String isRTL;
    private String menuVar;
    private String  loadFunc; //Added parameter to prevent the double loading of path-head in case load decoration is called
    //variable used to indicate if clustering is enables, values true/false
    private String isClusterEnabled;
    // property from PTH_CTRL to enable the Arabic Calendar labels to be named as English 684983, ARIB180053
    private String isArbMnthEng; 
    //Alerts properties
    // This property indicates if the alerts engine is started and is used in AppMain.jsp 
    private String isAlertEnabled;
    /* Login Alert Implementation TP#297149 */
    // This property indicates if the login alert feature is enabled for a specific user, its used in AppMain.jsp to decide if the long polling should be started 
    private String isLoginAlertEnabled;
    // This property contains the alert parameters needed to open the send alert dialog when login alert is enabled
    private String loginAlertParamCO;
    
    // TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
    private String isFinalSignOff;
    
    // This property represents the userId and is used in AppMain.jsp 
    private String userId;
    // The alerts alertsEngineBO 
    private AlertsEngineBO alertsEngineBO;
    // The alerts application names concatenated by comma
    private String alertsAppName;
    
    private String homeURL;
    private String usrSettingRight;
    private String dynScrGenRight;
    private String userRunningDateOPT;
    private String appRunningDateOPT;
    private String usrLabelRight;
    private String usrThemeRight;
    private String switchViewRight;
    private String usrSaveAsRight;
    private String newSessionRight;
    private String usrPrntAxsRight;
    private String techDetailsRight;    
    private String techLogsRight;    
    private String usrBtnCustRight;
    private String enableItrRunningDate;
    private String dynClntPrmsEditRight;//Dynamic client params edit data Option
    private String dynClntPrmsApproveRight;//Dynamic client params approve Option
    private String dynClntPrmsColsEditRight;//Dynamic client params edit columns details Option
    private String globalActivitiesRight;//Access rights for global activities
    //private String usrAllowDisableCustomization;
    /**
     * This variable is used to check if LoginCompBr screen is opened in a dialog
     */
    private Boolean openInDialog = Boolean.FALSE;
    private Boolean switchBranch = Boolean.FALSE;
    
    private String appId; //application id opened from landing page
    private String favoriteId; //favorite screen progref opened from landing page
    private String originalAppUrl; //URL of the original application from which an external screen is opened
    private String targetAppScreenUrl; //URL of the target external Screen to be opened
    private String externalScreen;
    private String originalProgRef;
    private List<String> externalOpenedUrls; //coma separated list of external Application Names called from menu opt
    private String loggedInUserName; //returned in method returnExternalUrls that retrieves external app urls to logout the user
    
    private String destinationAppUrl; //URL to be called (from another application)
    private String destinationScreenUrl; //URL to be called (from another application)
    private String destinationProgRef;//Prog Ref to be used 
    private String additionalParams; //additional parameters to be sent to destionationUrl, JSON string of params
    private String screenTitle;//title of the screen opened from workspace link/button or from favorites
    private String pwdToken;//value of token in the login comp/branch screen
    private boolean reloadUserSessionDetails; //flag set to 1 in premain.jsp to force reload of session details when the user or company or branch are changed
    private String isClusterCall; //flag to check if clearCache method is called from clustered deployment or from user request.
    private String finalSignOffOption;
    private String usrActvXSelectdPrntr; //654601 The local printer selected from ActiveX dialog by user for silent printing
    private String printReportAsPDF; //698427 check if the reports are to be printed as PDF
    //TP 715899 This property indicates if the Notification engine is started and is used in AppMain.jsp 
    private String isNotificationEnabled;
    /**
     * just dummy method to be able to call it in application to check if
     * session is still alive
     * 
     * @return
     */
    public String checkAlive()
    {
	// just to return JSON format with empty value
	additionalParams = "";
	return "JSON_DUMMY";
    }
    
    /**
     * function used to return session details like running date from the session. it is called from landing page favorite/workspace/application button 
     * before opening the external applicaiton from landing page
     * @return
     */
    public String returnSessionDetails()
    {
	SessionCO sessionCO = returnSessionObject();
	newFrmtUserRunDate = DateUtil.format(sessionCO.getRunningDateRET());
	return "jsonSuccess";
    }
    
    
/**
 * 
 * Used for accessing the module after checking of Company and Branch screen
 * 
 * @return
 */
    public String login()
    {
	try
	{
			applyDirection();
	
	 		SessionCO sessionCO = sessionCOInitialize();
	 		String curAppName = sessionCO.getCurrentAppName();
	 		String result = SUCCESS; 
			if (StringUtil.nullToEmpty(menuVar).isEmpty())
			{
			    if (sessionCO.getDirectMenuVar() == null )
			    {
				if(StringUtil.nullToEmpty(externalScreen).isEmpty())
				{
				    if(StringUtil.nullToEmpty(appId).isEmpty())
				    {
                			    if(StringUtil.nullToEmpty(destinationScreenUrl).isEmpty())
                			    {
                				// opening application already authenticated but
                				// not because opened previously from dashboard
                				// since appId is null
                				if(PathActionContextMethods.returnParameters().get("langChanged") == null)
                				{
                				    result = SUCCESS_LOGIN;
                				}
                			    }
                			    else
                			    {
                				try
                				{
                				    fillLoginByCompBrDetails(sessionCO.getCompanyCode(), sessionCO.getBranchCode());
                				    fillOtherCommonParams();
              				    	    fillUserDetails(sessionCO);
              				    	    portalSettings(curAppName);
              				    	    set_pageRef(destinationProgRef);
              				    	    //for the first login, the CustomLoginUrlEntryPoint will get additionalParams from request and add them to AdditionalParamsMap in SessionCO. 
              				    	    //But after the first login,we will pass directly to PreMain.jsp and then to DesktopAction, so we need to check if additionalParams exists in request and set the new value in sessionCO in AdditionalParamsMap.
              				    	    if(StringUtil.isNotEmpty(additionalParams))
              				    	    {
              				    		HashMap<String,Object> hm = (HashMap<String,Object>)CommonMethods.returnJsonObjectFromStr(HashMap.class, additionalParams);
              				    		sessionCO.setAdditionalParamsMap(hm);
              				    	    }
              				    	    loginUserToModule(); // TP 806066
              				    	    return "loadDestinationScreen";
                				}
                				catch(Exception e)
                				{
                				    handleException(e, null, null);
                				    //in case of CAN_LOGIN_AFTER_BR_CLOSURE_YN = 0 , a warning message should appear like : [31368] Branch or Session is not opened
                				    if(StringUtil.isNotEmpty(get_warning()))
                				    {
                					addActionError(get_warning());
                				    }
                				    throw e;
                				}
                			    }
        				   
				    }
				    else//When accessing an application from dashboard (either after autologin process or already authenticated)
				    {
    					    String httpSessionId = sessionCO.getHttpSessionID();
        				    /**
        				     * in case opening application from landing page, 
        				     * in first time login the User to module	, otherwise(opening the same application again) just forward to application since it is already login
        				     * in case the reloadUserDetails is set to true in loginCoBrScreen, we need to reload user details in session co 
        				     */
        				    //check if the flag reload_user_session_details is defined in premain.jsp so that comp/branch/user has been changed
        				    String reload_user_session_details = (String)session.get("reload_user_session_details");
        				    if(reload_user_session_details != null)
        				    {
        					reloadUserSessionDetails = true;
        					session.remove("reload_user_session_details"); 
        				    }
        				    if(StringUtil.nullToEmpty(httpSessionId).isEmpty() || reloadUserSessionDetails )
        				    {
        					portalSettings(curAppName);
                				fillLoginByCompBrDetails(sessionCO.getCompanyCode(), sessionCO.getBranchCode());
                				fillUserDetails(sessionCO);
                				//*********************check already logged in**************************************************
    		        		    	try
						{
    		        		    	    // supper user can access to application with no already login, shifts checking
    		        		    	    if(!ConstantsCommon.ONE.equals(sessionCO.getUsrPathSts()))
    		        		    	    {
    		        		    		checkCompanyBranchAccess();
    		        		    	    }
    		        		    	    loginUserToModule();
						}
						catch(BOException e)
						{
						    if(MessageCodes.USR_ALREADY_LOGGED_IN.equals(e.getErrorCode()) || MessageCodes.USRS_ALREADY_EXEC_PERIODICAL_PROCESS.equals(e.getErrorCode())
							    || MessageCodes.CANNOT_LOGIN_EOD_WEB_VERSION_IS_RUNNING.equals(e.getErrorCode()))
						    {
							String forceLogoutAccessRight = null;
							// 52696 if WEB EOD running users not allowed to login, so no need to check on FORCE logout Access rights
							if(!MessageCodes.CANNOT_LOGIN_EOD_WEB_VERSION_IS_RUNNING.equals(e.getErrorCode()))
							{
							    forceLogoutAccessRight = returnAccessRightByProgRef(ConstantsCommon.SESSION_FORCE_LOGOUT);
							}
							
							if(StringUtil.nullToEmpty(forceLogoutAccessRight).isEmpty())
							{
							    addExceptionToActionError(e);
							    //we need to set the compcode and branchcode to null to block the user from proceeding with the login. 
							    //if we keep the current compcode and branchcode not null the message 'user already logged in ' will not appear when calling checkLoginCompBr()
							    String returnLoginCompBr = loginCompBr();
							    //session comp/branch are set to null after loginCompBr to avoid errors when using sessionco.getCompCode() in loginCompBr
							    sessionCO.setCompanyCode(null);
							    sessionCO.setCompanyName(null);
							    sessionCO.setBranchCode(null);
							    sessionCO.setBranchName(null);
							    return returnLoginCompBr;
							}
							else
							{
							    String msgKey = ConstantsCommon.SESSION_CHECKING_MSG_KEY;
							    if(MessageCodes.USRS_ALREADY_EXEC_PERIODICAL_PROCESS.equals(e.getErrorCode()))
							    {
								msgKey = ConstantsCommon.PERIODICAL_PROCESS_IN_PROGRESS_KEY;
					                    }
							    addActionError(getText(msgKey));

							    companiesVO.setCOMP_CODE(sessionCO.getCompanyCode());
							    branchesVO.setBRANCH_CODE(sessionCO.getBranchCode());
							    sessionCO.setCompanyCode(null);
							    sessionCO.setCompanyName(null);
							    sessionCO.setBranchCode(null);
							    sessionCO.setBranchName(null);
						            sessionCO.setHttpSessionID(null);
						            
						            // in case of force logout , we need to assign the desktop action role only to avoid accessing the menu 
						            // by setting the url /DetkopAction_!corePortal directly from the browser 
						            try
						            {
						        	if(!openInDialog)
						        	{
						        	    assignUserAuthentRole("ROLE_DESKTOP_ACCESS");
						        	}
						            }
						            catch(BaseException b)
						            {
						        	handleException(b, null, null);
						            }
						            
							    return "session_checking";
							}
						    }
						}
    		        		    	//***********************************************************************
        				    }
        				    if(PathActionContextMethods.returnParameters().get("langChanged") == null) //not from language Change 
        				    {
        					result = SUCCESS_LOGIN;
        				    }
				    }
				}
				else	//opening another external app screen from menu
				{
				    //catch all the errors that can be thrown on login from external screens 
				    try
				    {
        				    fillLoginByCompBrDetails(sessionCO.getCompanyCode(), sessionCO.getBranchCode());
        				    fillUserDetails(sessionCO);
        				    portalSettings(curAppName);
        				    set_pageRef(externalScreen);
        				    //retrieve url from opt_extended for the target app name (set as current) and target prog ref
        				    String [] optDetailsArray = returnCommonLibBO().returnOptDetailsList(sessionCO.getCurrentAppName(), externalScreen);
        				    if(optDetailsArray[0].isEmpty())
        				    {
        					ServletActionContext.getRequest().getSession().setAttribute("externalScreenErrorActionMsg", "NO OPT Reference in Extended OPT table. Contact Administration");
        					return "loadExternalScreenErrorPage";
        				    }
        				    
        				    //TP # 446691 - EWBI160549 - Linking CSM request to FMS. add the flag externalScreenYN in case of request screen
        				    String targetAppScreenUrl = optDetailsArray[0];
        				    String originOPTRef = externalScreen;
        				    // OPT Reference is not empty
        	        		    if(!StringUtil.nullToEmpty(optDetailsArray[4]).isEmpty())
        	        		    {
        	        			originOPTRef = optDetailsArray[4];
        	        		    }
        	        		    
        				    // in case target App URL is report, to apply same as in TreeMEnuAction
        				    if (targetAppScreenUrl.indexOf(ConstantsCommon.REPORTS_OPT_URL) == 0)
        				     {
        					    if(ConstantsCommon.REP_APP_NAME.equals(sessionCO.getCurrentAppName()))
        					    {
        						targetAppScreenUrl ="/path/reportsRet/dynRepParamsAction_loadReportFromMenu?menu="+externalScreen;
        					    }
        					    else
        					    {
        						//reports called from other applications, remotely accessing reporting application 
        						targetAppScreenUrl = "/path/reporting/ReportsAction_callReports.action?r_r="+originOPTRef;
        					    }
        				     }
        				    
        				    targetAppScreenUrl = targetAppScreenUrl.concat(targetAppScreenUrl.contains("?")?"&externalScreenYN=Y":"?externalScreenYN=Y");
        				    //TP 475542 check if there is additional Parameters to be sent to the external screen opened from Menu, then concatinate them to URL
        				    if(additionalParams != null && !additionalParams.trim().isEmpty())
        				    {
        					targetAppScreenUrl = targetAppScreenUrl.concat("&"+additionalParams);
        				    }
        				    // if pageRef not found in URL
        				    if(targetAppScreenUrl.indexOf("_pageRef=") < 0)
					    {
						targetAppScreenUrl = targetAppScreenUrl.concat("&_pageRef="+externalScreen);
					    }
        				    setTargetAppScreenUrl(targetAppScreenUrl);
        				    //redirect to newDecoration method not to take default decorators from desktopAction_*

        				    //LOGIN the user to the external screen's application
        				    loginUserToApp();
        				    return "loadTargetScreen"; 
				    }
				    catch(Exception e)
				    {
					//handle the excepion to get the _error filled
					handleException(e, null, null);
					//add the _error to the session to be used in loadExternalScreenErrorPage and removed later
					ServletActionContext.getRequest().getSession().setAttribute("externalScreenErrorActionMsg", get_error());
					return "loadExternalScreenErrorPage";
				    }
				}
    			    }
			    // When accessing a screen directly from favorites dashboard (after autologin process)
			    else
			    {
				//check for user logged in to same application then use same web_http_session_id in sessionCO
				//otherwise insert current http session id in table and set it in sessionco 
				S_APPLOGVO sAppLogVo = new S_APPLOGVO();
				sAppLogVo.setAPP_NAME(sessionCO.getCurrentAppName());
				sAppLogVo.setUSER_ID(sessionCO.getUserName());
				sAppLogVo.setCOMP_CODE(sessionCO.getCompanyCode());
				sAppLogVo.setBRANCH_CODE(sessionCO.getBranchCode());
				String webHttpSessionId = loginBO.returnWebHttpSessionId(sAppLogVo);
				if(StringUtil.nullToEmpty(webHttpSessionId).isEmpty())
				{   
				    loginBO.loginUserToModule(sessionCO.getCompanyCode(),sessionCO.getBranchCode(),sessionCO.getUserName(),sessionCO.getCurrentAppName(),sessionCO.getMachineIp(),sessionCO.getHttpSessionID(),sessionCO.isFinalSignOff());
				}
				else
				{
				    sessionCO.setHttpSessionID(webHttpSessionId);
				}
				result = "loadDecoration";//sessionCO.getDirectMenuVar();
				fillLoginByCompBrDetails(sessionCO.getCompanyCode(), sessionCO.getBranchCode());
				fillUserDetails(sessionCO);
				menuVar = sessionCO.getDirectMenuVar();//result;
				portalSettings("");
				sessionCO.setDirectMenuVar(null);
				if(StringUtil.isNotEmpty(additionalParams))
				{
				    HashMap<String,Object> hm = (HashMap<String,Object>)CommonMethods.returnJsonObjectFromStr(HashMap.class, additionalParams);
				    sessionCO.setAdditionalParamsMap(hm);
				}
			    }
			}
			else
			    //When accessing directly to a screen without clicking on menu leaf
			    //and already having authenticated login
			{
			    result = menuVar;
			    portalSettings("");
			}
			
			return result;
	}
	catch(Exception e)
	{
           /**
            * [MarwanMaddah]:#BUG 518714 Error of CSM application invalid teller while logging in from LandingPage
            * will clean session data and home URL to avoid any problem on home or language click  
            */
	    SessionCO sessionCO = returnSessionObject();
	    sessionCO.setCompanyCode(null);
	    sessionCO.setCompanyName(null);
	    sessionCO.setBranchCode(null);
	    sessionCO.setBranchName(null);
	    homeURL = "";
	   /**
	    * 
	    */
	    //add attribute to enable decorator in case of error #625658
	    ServletActionContext.getRequest().setAttribute("enableDecorator", "true");
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
    }

private void applyHttpSessionId(SessionCO sessionCO)
{
    sessionCO.setHttpSessionID(ServletActionContext.getRequest().getSession().getId());
}
    
    public String openChangeRunningDate() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	Boolean normalRunningDateForITR = false;
	Date runDate = null;
	try{
		// if FATCA module then there is something in the access privileges wrong
    	       /**
    	        * In case the application is IRT & the flag  
    	        * in case the flag itr.runningdate.enable is equals to Zero then the running date is disable for IRT applicaton 
    	        * otherwise the running date will be applicable for IRT application and will appear in the header and can be changed 
    	        */
		if(ConstantsCommon.ITR_APP_NAME.equals(sessionCO.getCurrentAppName()))
		{
		    /**
		     * In case the ITR application is not IMAL
		     */
		    PTH_CTRL1VO pthCtrl1VO = returnCommonLibBO().returnPthCtrl1();
                    if(ConstantsCommon.NO.equals(pthCtrl1VO.getCORE_IMAL_YN()))
                    {                	
                	String itrRunningDateFlag = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties", "itr.runningdate.enable");
                	/**
                	 * [Marwan Maddah]
                	 * if the flag is zero under PathRemoting.properties file
                	 * exception will be handled
                	 * otherwise will call a web services to get the running date for ITR application and the running date will be enable.
                	 */
                	if(ConstantsCommon.ZERO.equals(itrRunningDateFlag))
                	{
                	    enableItrRunningDate = ConstantsCommon.ZERO;
                	    throw new BaseException(ConstantsCommon.ITR_APP_NAME+" Module has no running Date. Access Exception Contact Administration");
                	}
                	else
                	{
                	    enableItrRunningDate = ConstantsCommon.ONE;
                	    /**
                	     * [Marwan Maddah]
                	     * in case the application is not iMAL and the flag is equals to ONE
                	     * will get the running date from an external source via web services call...
                	     */
                	    CommonLibSC criteria = new CommonLibSC();
                	    criteria.setCompanyCode(sessionCO.getCompanyCode());
                	    criteria.setBranchCode(sessionCO.getBranchCode());
                	    criteria.setAppName(sessionCO.getCurrentAppName());
                	    runDate = returnCommonLibBO().returnExternalRunningDate(criteria);
                	}
                    }
                    else
                    {
                	enableItrRunningDate = ConstantsCommon.ONE;
                	normalRunningDateForITR = Boolean.TRUE;
                    }
	    	}
		if(!ConstantsCommon.ITR_APP_NAME.equals(sessionCO.getCurrentAppName()) || normalRunningDateForITR)
		{
	        	setNewUserRunDate(sessionCO.getRunningDateRET());	        	
	        	runDate = loginBO.returnRunningDate(sessionCO.getCompanyCode(),sessionCO.getBranchCode(),sessionCO.getCurrentAppName());
	        	if(runDate == null)
	        	{
	        	    runDate = returnCommonLibBO().returnSystemDateNoTime();
	        	}
	        	
		}	    
		setNewAppRunDate(runDate);
		checkUserAccessRight();
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	
	return SUCCESS;
    }
    
    /**
     * checks if running date to be updated(user or app) is a holiday to show the confirmatin message
     * @return
     * @throws BaseException
     */
    public String checkIfDateHoliday() throws BaseException
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    // if FATCA module then there is something in the access privileges
	    // wrong
	    /**
	     * In case the application is IRT & the flag in case the flag
	     * itr.runningdate.enable is equals to Zero then the running date is
	     * disable for IRT applicaton otherwise the running date will be
	     * applicable for IRT application and will appear in the header and
	     * can be changed
	     */
	    if(ConstantsCommon.ITR_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		PTH_CTRL1VO pthCtrl1VO = returnCommonLibBO().returnPthCtrl1();
		/**
		 * In case the ITR application is not imal
		 */
		if(ConstantsCommon.NO.equals(pthCtrl1VO.getCORE_IMAL_YN()))
		{
		    String itrRunningDateFlag = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties","itr.runningdate.enable");
		    /**
		     * if the flag is zero under PathRemoting.properties file
		     * exception will be handled otherwise will call a web
		     * services to get the running date for ITR application and
		     * the running date will be enable.
		     */
		    if(ConstantsCommon.ZERO.equals(itrRunningDateFlag))
		    {
			enableItrRunningDate = ConstantsCommon.ZERO;
			throw new BaseException(ConstantsCommon.ITR_APP_NAME
				+ " Module has no running Date. Access Exception Contact Administration");
		    }
		    else
		    {
			enableItrRunningDate = ConstantsCommon.ONE;
                	/**
                	* [Marwan Maddah]
                	* in case the application is not iMAL and the flag is equals to ONE
                	* will get the running date from an external source via web services call...
                	*/
                	CommonLibSC criteria = new CommonLibSC();
                	criteria.setCompanyCode(sessionCO.getCompanyCode());
                	criteria.setBranchCode(sessionCO.getBranchCode());
                	criteria.setAppName(sessionCO.getCurrentAppName());
                	newRunningDate = returnCommonLibBO().returnExternalRunningDate(criteria);
		    }
		}
		else
		{
		    enableItrRunningDate = ConstantsCommon.ONE;
		}
	    }
	    if(!ConstantsCommon.ITR_APP_NAME.equals(sessionCO.getCurrentAppName()) || ConstantsCommon.ONE.equals(enableItrRunningDate))
	    {
		/**
		 * system Date checking
		 */
		returnCommonLibBO().checkRunningDate(newRunningDate);

		DateParamSC dateParamrResultSC = returnCommonLibBO().checkHolidayCompBranch(newRunningDate,
			sessionCO.getBranchCode(), sessionCO.getCompanyCode(), false);
		if(dateParamrResultSC != null && dateParamrResultSC.getErrorCode() != null)
		{
		    if(dateParamrResultSC.getErrorParams() == null)
		    {
			set_confirm(returnCommonLibBO().returnTranslErrorMessage(
				dateParamrResultSC.getErrorCode().intValue(), sessionCO.getLanguage()));
		    }
		    else
		    {
			set_confirm(returnCommonLibBO().returnTranslErrorMessage(
				dateParamrResultSC.getErrorCode().intValue(), dateParamrResultSC.getErrorParams(),
				sessionCO.getLanguage()));
		    }

		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    public String saveUserRunningDate() throws BaseException
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    // if FATCA module then there is something in the access privileges
	    // wrong
	    String itrRunningDateFlag = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties", "itr.runningdate.enable");
	    PTH_CTRL1VO pthCtrl1VO = returnCommonLibBO().returnPthCtrl1();
            /**
             * in case the application is ITR & is not iMAL & the flag is ZERO
             */
	    if(ConstantsCommon.ITR_APP_NAME.equals(sessionCO.getCurrentAppName()) && ConstantsCommon.NO.equals(pthCtrl1VO.getCORE_IMAL_YN()) && ConstantsCommon.ZERO.equals(itrRunningDateFlag))
	    {
		enableItrRunningDate = ConstantsCommon.ZERO;
		throw new BaseException(ConstantsCommon.ITR_APP_NAME
			+ " Module has no running Date. Access Exception Contact Administration");
	    }
	    else
	    {
        	    Date theDate = getNewUserRunDate();
        	    if(ConstantsCommon.SUKUK_APP_NAME.equals(sessionCO.getCurrentAppName()) ||
        		    ConstantsCommon.ASSETS_APP_NAME.equals(sessionCO.getCurrentAppName()) || 
        		    ConstantsCommon.DIRECT_INVEST_APP_NAME.equals(sessionCO.getCurrentAppName()) )
        	    {
        		checkBackdatedTrx(theDate);
        	    }
        	    sessionCO.setRunningDateRET(theDate);
        	    newFrmtUserRunDate = DateUtil.format(theDate, "dd MMMMM yyyy");
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return "jsonSuccess";
    }
    
    public String saveAppRunningDate() throws BaseException
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    // if FATCA module then there is something in the access privileges
	    // wrong
	    String itrRunningDateFlag = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties", "itr.runningdate.enable");
	    PTH_CTRL1VO pthCtrl1VO = returnCommonLibBO().returnPthCtrl1();
            /**
             * in case the application is ITR & is not iMAL & the flag is ZERO
             */
	    if(ConstantsCommon.ITR_APP_NAME.equals(sessionCO.getCurrentAppName()) && ConstantsCommon.NO.equals(pthCtrl1VO.getCORE_IMAL_YN()) && ConstantsCommon.ZERO.equals(itrRunningDateFlag))
	    {
		throw new BaseException(ConstantsCommon.ITR_APP_NAME
			+ " Module has no running Date. Access Exception Contact Administration");
	    }
	    else
	    {
        	    Date theDate = getNewAppRunDate();
        	    if(ConstantsCommon.SUKUK_APP_NAME.equals(sessionCO.getCurrentAppName()) ||
        		    ConstantsCommon.ASSETS_APP_NAME.equals(sessionCO.getCurrentAppName()) || 
        		    ConstantsCommon.DIRECT_INVEST_APP_NAME.equals(sessionCO.getCurrentAppName()) )
        	    {
        		checkBackdatedTrx(theDate);
        	    }
        	    loginBO.updateRunningDate(sessionCO.getCompanyCode(), sessionCO.getBranchCode(), sessionCO.getCurrentAppName(), theDate, sessionCO.getFiscalYear(), sessionCO.getUserName());
        	    sessionCO.setRunningDateRET(theDate);
        	    newFrmtAppRunDate = DateUtil.format(theDate, "dd MMMMM yyyy");
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return "jsonSuccess";
    }
    
    private void checkBackdatedTrx(Date theDate) throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	BaseProcedureSC sc = new BaseProcedureSC();
	sc.setCompCode(sessionCO.getCompanyCode());
	sc.setBranchCode(sessionCO.getBranchCode());
	sc.setTradeDate(theDate);
	sc.setRunningDate(theDate);
	sc.setPreferredLanguage(sessionCO.getLanguage());
	returnCommonLibBO().checkBackdatedTrx(sc);
    }
    /**
     * 
     * @throws BaseException
     * @author ElieAchkar
     * 
     * check if the user has access rights to the dates
     */
    private void checkUserAccessRight() throws BaseException
    {
       SessionCO sessionCO = returnSessionObject();
       CommonLibSC commonLibSC = new CommonLibSC();
       List<String> privilegesToCheck = new ArrayList<String>();
       privilegesToCheck.add(ConstantsCommon.USER_RUNNING_DATE_OPT);
       privilegesToCheck.add(ConstantsCommon.APP_RUNNING_DATE_OPT);
       
       commonLibSC.setPrivilegesToCheck(privilegesToCheck);
       commonLibSC.setCompCode(sessionCO.getCompanyCode());
       commonLibSC.setBranchCode(sessionCO.getBranchCode());
       commonLibSC.setUserId(sessionCO.getUserName());
       commonLibSC.setAppName(sessionCO.getCurrentAppName());
       
       List<String> accessResult = returnCommonLibBO().checkAccessPrivilegeForUser(commonLibSC);
       
       if(accessResult.contains(ConstantsCommon.USER_RUNNING_DATE_OPT))
       {
 	  userRunningDateOPT = "true";
       }
       if(accessResult.contains(ConstantsCommon.APP_RUNNING_DATE_OPT))
       {
 	  appRunningDateOPT = "true";
       }
    }

	protected SessionCO sessionCOInitialize() throws BaseException
	{
		SessionCO sessionCO = returnSessionObject();
		if(sessionCO == null) 
		{
			sessionCO = new SessionCO();
			session.put(ConstantsCommon.SESSION_VO_ATTR,sessionCO);
		}
		if(sessionCO.getUserName() == null)
		{
		    UsrCO usrCo = loginBO.returnAdDetails(returnUserName());
		    sessionCO.setUserName(usrCo.getUSER_ID());
		}
		
		/**
		 * [MarwanMaddah]
		 * Bug #567575 "the system is generating an error upon trying to login into CSM from Landing Page"		
		 */
		else
		{
		    UsrCO usrCo = loginBO.returnAdDetails(sessionCO.getUserName());
		    if(usrCo!=null)
		    {
			boolean isADUser = ConstantsCommon.AUTH_LDAP_ENABLED.equals(usrCo.getAD_AUTH_YN()) && !StringUtil.nullToEmpty(usrCo.getAD_USER_ID()).isEmpty();
			if(isADUser && !StringUtil.nullToEmpty(usrCo.getUSER_ID()).isEmpty())
			{
			    sessionCO.setUserName(usrCo.getUSER_ID());
			}
		    }
		}
		
		return sessionCO;
	}
    
	
	/**
	 * Redirect to Login By Company and Branch Screen
	 * @return
	 * @throws Exception
	 */
	public String loginCoBrScreen() throws Exception
	{
		SessionCO sessionCO = sessionCOInitialize();
		sessionCO.setMachineIp(returnIP());
		applyHttpSessionId(sessionCO);
		readOnlyProp = "true";
		String returnResult= "";
		String apName = sessionCO.getCurrentAppName();
		CommonLibBO commonLibBO = returnCommonLibBO();
		S_APPVO appVO = new S_APPVO();
		appVO.setAPP_NAME(sessionCO.getCurrentAppName());
		appVO = commonLibBO.returnApplication(appVO);
		if(appVO!=null) 
		{
		    sessionCO.setAppLocationType(appVO.getAPP_LOCATION_TYPE()); 
		}
		
		if(apName == null) // means the server is restarted/ or session timeout and the Login Page not refreshed
		{
		     returnResult = "timeout";
		}
		else
		{
        		if (sessionCO.getBranchCode() == null || sessionCO.getCompanyCode() == null)
        		{
        		    //fill User Details in SessionCO
        		    fillUserDetails(sessionCO);
        		    
        		    returnResult = LOGINCOMPBR;
        		    
        		    // if SADs application then Company and Branch set to 0, and skip login Company Screen, and no Token verification
        		    if(ConstantsCommon.NO_COMP_BRANCH.equals(sessionCO.getAppLocationType()))
        		    {
                		companiesVO.setCOMP_CODE(BigDecimal.ZERO);
                		branchesVO.setBRANCH_CODE(BigDecimal.ZERO);
                		// if no Token verification needed
                		if(BigDecimal.ZERO.equals(sessionCO.getTokenVerification()))
                		{
                		    returnResult = checkLoginCompBr();
                		}
        		    }
        		}
        		else
        		{
        		    //check if the another user is logged to an existing session. 
        		    //this case occur when user1 open an external screen in another application then user2 opens the external screen again. 
        		    //in case the j_username in request is different then session username, we need to authenticate the user. 
        		    HttpServletRequest request = ServletActionContext.getRequest();
        		    String j_username = request.getParameter("j_username");
        		    if(StringUtil.isNotEmpty(j_username) && !j_username.equals(sessionCO.getUserName()))
        		    {
        			HttpServletResponse response = ServletActionContext.getResponse();
        			Authentication authentication = secureFilter.attemptAuthentication(request, response);
        			SecurityContext securityContext = (SecurityContext) session.get("SPRING_SECURITY_CONTEXT");
        			securityContext.setAuthentication(authentication);
        			//set the new username is session
        			sessionCO.setUserName(j_username);
        		    }
        		    /**
        		     * added for external Screen language issue
        		     */
        		    String requestLocale = request.getParameter("request_locale");
        		    String _externalScreen = request.getParameter("externalScreen");
        		    if(!StringUtil.nullToEmpty(_externalScreen).isEmpty() && !StringUtil.nullToEmpty(requestLocale).isEmpty())
        		    {
	        			sessionCO.setLanguage(requestLocale);
	        			sessionCO.setExternalScreenReq(ConstantsCommon.ONE);
	        			
	        			SYS_PARAM_LANGUAGESVO langDet = new SYS_PARAM_LANGUAGESVO();
	        			langDet.setISO_CODE(requestLocale);
	        		    langDet = returnCommonLibBO().returnDirection(langDet);
	        		    if(langDet != null)
	        		    {
		        			if(ConstantsCommon.ONE.equals(langDet.getIS_RIGHT_LEFT_YN()))
		        			{
		        				sessionCO.setIsRTLDir(1);
		        			    isRTL = "rtl";
		        			}
		        			else
		        			{
		        				sessionCO.setIsRTLDir(0);
		        			    isRTL = "ltr";		        				
		        			}
	        		    }	        		    
        		    }
        		    /**
        		     * 
        		     */
        		    reloadUserSessionDetails = true;
        		    returnResult = login();
        		}
		}
	 	return returnResult;
	}

    private List<String> fillLoginByCompBrDetails(BigDecimal compCode,BigDecimal branchCode)throws Exception
    {
	SessionCO sessionCO = returnSessionObject();
	String apName = sessionCO.getCurrentAppName();
	
	//if the application is RET,check if there is teller and fill Retail Details in SessionCO 
	if(ConstantsCommon.RET_APP_NAME.equals(apName))
	{
	    fillRetailDetails(sessionCO);
	    String res = loginBO.checkBranchSession(compCode, branchCode,sessionCO.getUserName());
	    sessionCO.setBranchIsClosedUserLogged(res);
	}
	
	List<String> res = new ArrayList<>();
	//running date when opening external screen from menu should be the one of the main application not the target application 
	//and it is already filled ins sessionCO
	//in case of application/favorite/workspace opened from landing page we need to keep the running date passed in parameters and not to use the default one
	//in case the running date is null in session then we need to default it
	//in case destinationScreenUrl is not empty which means we are opening from iframe then the runningDateRETis passed in parameters and it should not be defaulted
	if((StringUtil.nullToEmpty(externalScreen).isEmpty() 
		&& StringUtil.nullToEmpty(destinationScreenUrl).isEmpty()
		&& StringUtil.nullToEmpty(appId).isEmpty()
		&& (StringUtil.nullToEmpty(menuVar).isEmpty() && StringUtil.nullToEmpty(sessionCO.getDirectMenuVar()).isEmpty())
		&& StringUtil.nullToEmpty(favoriteId).isEmpty()) || sessionCO.getRunningDateRET() == null )
	{
	    // filling running date into session
	    res = fillRunningDate(sessionCO);
	}

	// fill Application DEtails , Client Specific Information
	fillApplicationDetails(sessionCO);

	// fill Other Details (Company,...), in SADS there is not Company
	if(!ConstantsCommon.NO_COMP_BRANCH.equals(sessionCO.getAppLocationType()))
	{
	    fillOtherDetails(sessionCO);
	}

	// fiscal year not needed for FATCA, SADS module
	if(!ConstantsCommon.ITR_APP_NAME.equals(apName) && !ConstantsCommon.SADS_APP_NAME.equals(apName)  && !ConstantsCommon.UPG_APP_NAME.equals(apName)
		&& !ConstantsCommon.OADM_APP_NAME.equals(apName))
	{
	    // check if Fiscal Year Defined
	    BigDecimal[] fiscalMonthYear = loginBO.returnFiscalYearMonth(compCode, branchCode,
		    sessionCO.getRunningDateRET());
	    if(fiscalMonthYear != null)
	    {
		// setting fiscal year and month into a session
		sessionCO.setFiscalYear(fiscalMonthYear[0]);
		sessionCO.setFiscalMonth(fiscalMonthYear[1]);
	    }
	}
	applyDirection();
	PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
	/*
	 * PTH_CTRL (0,Null= Arabic Visible Not Mandatory But English Mandatory,
	 * 1=Arabic Hidden and English Mandatory, 2= Arabic Visible and
	 * Mandatory And English Mandatory , 3= Arabic Visible and Mandatory
	 * English Not Mandatory).
	 */
	if(ConstantsCommon.ONE.equals(StringUtil.nullEmptyToValue(pthCtrl.getLANGUAGE(), ConstantsCommon.ZERO)))
	{
	    sessionCO.setHideArabicColumns(true);
	}
	return res;
    }
    /**
     * Setting company and branch code sessions and direction
     * @return
     */
    public String checkLoginCompBr()
    {
	try
	{

	    String returnResult  = SUCCESS_LOGIN;
	    
		if (companiesVO.getCOMP_CODE() == null || branchesVO.getBRANCH_CODE() == null )
		{
		         /**
		          * in case loginCompBr is opened in a dialog
		          * return BOException instead of action Error
		          */
		         if(openInDialog)
		         {		             
		             throw new BOException(getText("login.error"));
		         }
			 addActionError(getText("login.error"));
			 returnResult = loginCompBr();
		}
		else
		{
		    	CommonLibBO commonLibBO = returnCommonLibBO();
			SessionCO sessionCO = returnSessionObject();
			BigDecimal compCode = companiesVO.getCOMP_CODE();
			BigDecimal branchCode = branchesVO.getBRANCH_CODE();
			String userName = sessionCO.getUserName();
			String apName = sessionCO.getCurrentAppName();
			String ip = returnIP();
			sessionCO.setMachineIp(ip);
			
			sessionCO.setManualLogIn(ConstantsCommon.ONE);
			
			
			BigDecimal sessCompCode = sessionCO.getCompanyCode();
			BigDecimal sessBranchCode = sessionCO.getBranchCode();
			
			/**
			 * [MarwanMaddah]:used in case of force logout management in case of openInDialog
			 * like (switch company & branch)
			 * in case user break the process (click NO button),we need to go back to the landing page
			 * in this case we have to re-fill the old session informations
			 *  
			 */
			if(openInDialog)
			{
			   prevCompCode      = sessCompCode;
			   prevBranchCode    = sessBranchCode;
			   prevCompDesc      = sessionCO.getCompanyName();
			   prevBranchDesc    = sessionCO.getBranchName();
			   prevHttpSessionId = sessionCO.getHttpSessionID();
			   welcMsg = ConstantsCommon.ZERO;
			}

			// no need to return Companies and Branch Details in case of SADs
			if(ConstantsCommon.TWO.equals(sessionCO.getAppLocationType()))
			{
				// setting company and branch to the session
				sessionCO.setCompanyCode(compCode);
				sessionCO.setBranchCode(branchCode);
				// to avoid getting 403 error when redirecting to DesctopAction_sadsPortal , we need to give FULL ACCESS 
				assignUserAuthentRole("ROLE_FULL_ACCESS");
			}
			else
			{
				//set the related comp name and branch name
				applyCompBranchNames(compCode, branchCode);
			}
			
			//token flag is ON means need to check value of pwd token input
        		if(BigDecimal.ONE.equals(sessionCO.getTokenVerification()))
        		{
        		    Integer errCode = checkPwdToken(); 
        		    if(errCode != null)
        		    {
        			// check if user to be suspended then redirect to
        			// login screen
        			UsrCO usrCO = loginBO.userLoginDet(userName);        			
        			if(usrCO.getUSER_STS().equals(ConstantsCommon.USR_SUSPENDED_STS))
    				{
        			    //invalidate session 
        			    //redirect to login screen
        			    HttpSession httpSession = ServletActionContext.getRequest().getSession();
        			    httpSession.invalidate();
        			    ServletActionContext.getRequest().getSession().setAttribute("userTokenSuspended", ConstantsCommon.ONE);
        			    return "redirectLogin";
        			}
        			setPwdToken(null);
        			throw new BOException(errCode);
        		    }
        		}
        		
    		List<String> runnDateRetMsg = fillLoginByCompBrDetails(compCode,branchCode);
			
			// check if user in same session already logged in , in case of F5 clicked in Browser for Example on Welcome Page
			// this code need to be after fillLoginByCompBrDetails since the checking on menu access with should be done after setting
			// into the sessionCO value for branchIsClosedUserLogged which allow user to Log in after branch closure
			String forceLogoutAccessRight = returnAccessRightByProgRef(ConstantsCommon.SESSION_FORCE_LOGOUT);
			/**
			 * [MarwanMaddah]
			 * The AND condition has been changed to OR to enter the checkCompanyBranchAccess
			 * in case of Switch Branch & switch Session management.  
			 */
	    		if((!compCode.equals(sessCompCode) || !branchCode.equals(sessBranchCode)) || (!StringUtil.nullToEmpty(forceLogoutAccessRight).isEmpty() && !ConstantsCommon.ONE.equals(StringUtil.nullEmptyToValue(overrideSession,ConstantsCommon.ZERO))))
	        	{
        		    /**
        		     * [MarwanMaddah]: http session has been added to the checkCompanyBranchAccess right 
        		     * for the override other logged session
        		     * based on the logged in user and the flag that exists in PathRemoting.properties 
        		     */
        		    // also supper user can access to application with no already login, shifts checking
        		    if(!ConstantsCommon.ONE.equals(sessionCO.getUsrPathSts()))
    			    {
        			checkCompanyBranchAccess();
    			    }
        		   
        		    // redirect to Landing page in case it was set as default
        		    if(!ConstantsCommon.IBIS_APP_NAME.equals(apName))
        		    {        			
        			String defaultPageDisplay = loginBO.returnDefaultPageLogin(compCode, branchCode, apName, userName,sessionCO.getLanguage() , sessionCO.getBranchIsClosedUserLogged());
        			if(ConstantsCommon.ONE.equals(defaultPageDisplay))// not admin portal
        			{
        			    returnResult = LOGIN_LANDING_PAGE;
        			    if(openInDialog)
        			    {
        				addActionMessage(getText("switched_successfully_key"));
        				welcMsg = ConstantsCommon.ONE;
        			    }
        			}
        		    }
        		}
			
			// check whether to display welcome message for CSM application Only
//			returnResult =  SUCCESS_LOGIN;
			
			// welcome Message Displaying
        		if(runnDateRetMsg != null && !runnDateRetMsg.isEmpty())
        		{
        		    // redirect to login Company Branch to Show Welcome
        		    // Message without showing company and Branch
        		    // this will display warning icon on screen and not error
        			for (String msg : runnDateRetMsg)
					{
        				addActionError(msg);
					}
        		    welcMsg = ConstantsCommon.ONE;
        
        		}
        		PTH_CTRLVO pthCtrl = commonLibBO.returnPthCtrl();
        		if(StringUtil.nullToEmpty(pthCtrl.getSHOW_WELCOME_MESSAGE()).equals(ConstantsCommon.ONE)
        			&& !ConstantsCommon.SUPER_USER_STATUS.equals(sessionCO.getUsrPathSts()))
        		{
        		    String userFirstName = sessionCO.getUserFirstName();
        		    String userLastName = sessionCO.getUserLastName();
        		    String userLanguage = sessionCO.getLanguage();
        		    String welcMesage = loginBO.returnWelcomeMsg(userName, userFirstName, userLastName, userLanguage);
        		    if(welcMesage != null)
        		    {
        			addActionMessage(welcMesage);
        			welcMsg = ConstantsCommon.ONE;
        		    }
        		    // fiscal yesr not available for FATCA, OMNI ADMIN and SADS
        		    if(sessionCO.getFiscalYear() == null && !ConstantsCommon.OADM_APP_NAME.equals(apName)  && !ConstantsCommon.UPG_APP_NAME.equals(apName)
        			    && !ConstantsCommon.ITR_APP_NAME.equals(apName) && !ConstantsCommon.SADS_APP_NAME.equals(apName))
        		    {
        			String fiscalYearMsg = commonLibBO.returnTranslMessageOnly(
        				MessageCodes.FISCAL_YEAR_NOT_DEFINED, userLanguage);
        			// this will display warning icon on screen and not
        			// error
        			/**
        			 * in case loginCompBr is opened in a dialog return
        			 * BOException instead of action Error
        			 */
        			addActionError(fiscalYearMsg);
        			welcMsg = ConstantsCommon.ONE;
        		    }
        		    /**
        		     * [MarwanMaddah]
        		     * TP 310524
        		     * This notification message has been added to inform the logged in user 
        		     * that his access privilege will be expired after x days, based on the number of days 
        		     * that defined in SADS \ user section  
        		     */
        		    CommonLibSC notificationDaysSC = new CommonLibSC();
        		    notificationDaysSC.setAppName(apName);
        		    notificationDaysSC.setUserId(userName);
        		    notificationDaysSC.setCompanyCode(compCode);
        		    notificationDaysSC.setBranchCode(branchCode);
        		    notificationDaysSC.setAccessNtfNbDays(pthCtrl.getNOTIFY_PERIOD_EXPIRE_AXS());
        		    notificationDaysSC.setPthCtrlSuspendPrdType(pthCtrl.getSUSPEND_PERIOD_TYPE());
        		    /**
        		     * [MarwanMaddah]:TP 310524 - IIAB150138 - increase security controls.
        		     * Will display a message to notify users about the Access rights that will be expired 
        		     * based on the number of days that will be defined in SADS 
        		     * PTH_CTRL \ NOTIFY_PERIOD_EXPIRE_AXS and suspend period type.
        		     */
        		    int nbOfDays = loginBO.returnExpiryNtfNbDays(notificationDaysSC);
        		    if(NumberUtil.isNumberPositive(nbOfDays))
        		    {
        			addActionError(getText("expiryaccessntfmsg_key").concat(" ").concat(""+nbOfDays).concat(" ").concat(getText("days_key")));
        			welcMsg = ConstantsCommon.ONE;
        		    }
        		}
        		//check if successful login message is defined then add welcome message even if "show welcome message at login" is not checked
        		if(pthCtrl.getPWD_LOGIN_SUCCESS_MSG() != null)
        		{
        		    welcMsg = ConstantsCommon.ONE;
        		    addActionMessage(returnCommonLibBO().returnTranslMessageOnly(pthCtrl.getPWD_LOGIN_SUCCESS_MSG().intValue(), sessionCO.getLanguage()));
        		}

			//redirect to login comp branch page for welcome message
			if(ConstantsCommon.ONE.equals(welcMsg))
			{
			    returnResult = loginCompBr();
			}
			
			//[TP 364923] clear the access rights since Branch is Switched or changed
	            	sessionCO.setUserAxsMap(null);
	            	
	       // TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5)) 
	       // clear loginApproval since Branch is Switched
    	   if(session.containsKey(AlertsConstants.ALERT_LOGIN_APPROVAL_FLAG) && session.get(AlertsConstants.ALERT_LOGIN_APPROVAL_FLAG).equals(ConstantsCommon.ONE)) 
      	   {
      		  session.put(AlertsConstants.ALERT_LOGIN_APPROVAL_FLAG, ConstantsCommon.ZERO);
      	   }
			
			/**
			 * [MarwanMaddah]
			 * in case the calling is from Switch company and Application is not 'IBIS' or 'SADS'
			 * we have to logout the user from the current company and branch before log it in to the selected 
			 */
		        if(openInDialog && !ConstantsCommon.NO_COMP_BRANCH.equals(sessionCO.getAppLocationType()))
		        {
			   String idStatus = ConstantsCommon.ONE;
//			   log.error("[DescktopAction]checkLoginCompBr  calling logoutUserFromModule userName="+userName+" sessionCO.getHttpSessionID()="+sessionCO.getHttpSessionID());
		           loginBO.logoutUserFromModule(userName, apName, ip, sessCompCode, sessBranchCode, idStatus,sessionCO.getHttpSessionID(),openInDialog);
		        }
		        
		        String msgCode = loginUserToModule();
			if(!StringUtil.nullToEmpty(msgCode).isEmpty())
			{
			    addActionError(msgCode);
			    /**
			     * in case there is an error in the licenses management, force the direction to welcome screen
			     * even if it is disabled based on PTH_CTRL \ SHOW_WELCOME_MESSAGE
			     */
			    welcMsg = ConstantsCommon.ONE;
			    returnResult = loginCompBr();
			}
			else
			{
			    // need to set the FULL access role since there is not Welcome message to display. 
			    assignUserAuthentRole("ROLE_FULL_ACCESS");
			}
		}
		if(ConstantsCommon.ZERO.equals(welcMsg))
		{
		    addActionMessage(getText("switched_successfully_key"));
		}		
		return  returnResult;
	}
	catch(BOException e)
	{
	  /**
	    * [MarwanMaddah]
	    * #BUG481199 switch company error
	    * to be used in case of F5 click on forcelogout screen inside switch process
	    */
	    if(openInDialog)
	    {
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		httpSession.setAttribute("prevCompCode", prevCompCode);
		httpSession.setAttribute("prevBranchCode", prevBranchCode);
		httpSession.setAttribute("prevCompDesc", prevCompDesc);
		httpSession.setAttribute("prevBranchDesc", prevBranchDesc);
		httpSession.setAttribute("prevHttpSessionId", prevHttpSessionId);
	    }
	    SessionCO sessionCO = returnSessionObject();
	    if(MessageCodes.USR_ALREADY_LOGGED_IN.equals(e.getErrorCode()) || MessageCodes.USRS_ALREADY_EXEC_PERIODICAL_PROCESS.equals(e.getErrorCode()))
	    {
		String forceLogoutAccessRight = returnAccessRightByProgRef(ConstantsCommon.SESSION_FORCE_LOGOUT);
		if(!StringUtil.nullToEmpty(forceLogoutAccessRight).isEmpty())
		{
		    String msgKey = ConstantsCommon.SESSION_CHECKING_MSG_KEY;
		    if(MessageCodes.USRS_ALREADY_EXEC_PERIODICAL_PROCESS.equals(e.getErrorCode()))
		    {
			msgKey = ConstantsCommon.PERIODICAL_PROCESS_IN_PROGRESS_KEY;
		    }
		    addActionError(getText(msgKey));
		    sessionCO.setCompanyCode(null);
		    sessionCO.setCompanyName(null);
		    sessionCO.setBranchCode(null);
		    sessionCO.setBranchName(null);
	            sessionCO.setHttpSessionID(null);
	            
	            // in case of force logout , we need to assign the desktop action role only to avoid accessing the menu 
	            // by setting the url /DetkopAction_!corePortal directly from the browser 
	            try
	            {
	        	if(!openInDialog)
	        	{
	        	    assignUserAuthentRole("ROLE_DESKTOP_ACCESS");
	        	}
	            }
	            catch(BaseException b)
	            {
	        	handleException(b, null, null);
	            }
	            
		    return "session_checking";
		}
	    }
	    if(openInDialog)
	    {
		handleException(e, null, null);
	    }
	    else
	    {
		addExceptionToActionError(e);
		welcMsg = null;
	    }
	    /**
	     * [MarwanMaddah]TP482666-ABARSU170046
	     * in case there is an exception will Rollback the current comp/branch infos that was changed on the session
	     * the previous data will be null in case of the normal login with exception 
	     * and will be the logged in infos in case of switch company/branch process
	     */	    
	    sessionCO.setCompanyCode(prevCompCode);
	    sessionCO.setCompanyName(prevCompDesc);
	    sessionCO.setBranchCode(prevBranchCode);
	    sessionCO.setBranchName(prevBranchDesc);
	    
	    return returnExceptionResult(openInDialog,false);
	}
	catch(Exception e)
	{
	    addExceptionToActionError(e);
	    log.error(e, "Error in checkLoginCompBr method of DesktopAction");
	    return returnExceptionResult(openInDialog,true);
	}
  }
    
    /**
     * method to set comp name and branch name
     * @param compCode
     * @param branchCode
     * @throws BaseException
     */
    private void applyCompBranchNames(BigDecimal compCode,BigDecimal branchCode) throws BaseException
    {
	// setting company and branch to the session
    	SessionCO sessionCO = returnSessionObject();
    	CommonLibBO commonLibBO = returnCommonLibBO(); 
    	companiesVO = commonLibBO.returnCompany(companiesVO);
    	//TP 450108 check if Valid Company Code provided
    	if(companiesVO == null)
    	{
    	    throw new BOException(MessageCodes.INVALID_COMPANY_CODE);
    	}
	if(!ConstantsCommon.ONLY_COMP.equals(sessionCO.getAppLocationType()))
	{
	    BRANCHESVOKey branchKey = new BRANCHESVOKey();
	    branchKey.setBRANCH_CODE(branchCode);
	    branchKey.setCOMP_CODE(compCode);
	    branchesVO = commonLibBO.returnBranch(branchKey);
	    // TP 450108 check if Valid Branch Code provided
	    if(branchesVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_BRANCH_CODE);
	    }
	    String brName = branchesVO.getBRIEF_DESC_ENG();
	    if(sessionCO.getIsRTLDir() == 1)
	    {
		brName = StringUtil.nullEmptyToValue(branchesVO.getBRIEF_DESC_ARAB(), brName);
	    }
	    sessionCO.setBranchName(brName);
	}
	else if(compCode != null && sessionCO.getCompanyCode() == null
		&& branchCode != null && sessionCO.getBranchCode() == null) 
	{
	    // to avoid getting 403 error when redirecting to DesctopAction_omniAdminPortal , we need to give FULL ACCESS 
	    assignUserAuthentRole("ROLE_FULL_ACCESS");
	}
	sessionCO.setCompanyCode(compCode);
	String cmpName = companiesVO.getBRIEF_DESC_ENG();
	if(sessionCO.getIsRTLDir() == 1)
	{
	    cmpName = StringUtil.nullEmptyToValue(companiesVO.getBRIEF_DESC_ARAB(), cmpName);
	}
	sessionCO.setCompanyName(cmpName);
	sessionCO.setBranchCode(branchCode);
    }
    
    private Integer checkPwdToken()throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	CommonLibSC criteria = new CommonLibSC();
	criteria.setPwdToken(pwdToken);
	criteria.setAppName(sessionCO.getCurrentAppName());
	criteria.setUserId(sessionCO.getUserName());
	criteria.setHostName(sessionCO.getMachineIp());
	criteria.setLanguage(sessionCO.getLanguage());
	/**
	 * filled to be saved on the LOG tables
	 */
	criteria.setHttpSessionId(sessionCO.getHttpSessionID());	
	return loginBO.validateSecurityToken(criteria);
    }
    
    private void checkCompanyBranchAccess() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	CommonLibSC criteria = new CommonLibSC();
	criteria.setCompCode(sessionCO.getCompanyCode());
	criteria.setBranchCode(sessionCO.getBranchCode());
	criteria.setAppName(sessionCO.getCurrentAppName());
	criteria.setUserId(sessionCO.getUserName());
	criteria.setHostName(sessionCO.getMachineIp());
	criteria.setLanguage(sessionCO.getLanguage());
	criteria.setAppLocationType(sessionCO.getAppLocationType());
	criteria.setHttpSessionId(ServletActionContext.getRequest().getSession().getId());
	if(!StringUtil.nullToEmpty(overrideSession).isEmpty())
	{
	    criteria.setOverrideSession(overrideSession);
	}
	loginBO.checkCompanyBranchAccess(criteria);

    }
    
    //LOGIN the user to the external screen's application
    private void loginUserToApp() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();

	if(StringUtil.nullToEmpty(sessionCO.getHttpSessionID()).isEmpty())
	{
	    applyHttpSessionId(sessionCO);
	}
	loginBO.loginUserToApp(sessionCO.getCompanyCode(),sessionCO.getBranchCode(),sessionCO.getUserName(),sessionCO.getCurrentAppName(),sessionCO.getMachineIp(),sessionCO.getHttpSessionID());
    }
    
    private String loginUserToModule()throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	// setting user as logged in to the application
	/**
	 * [Marwan Maddah]; in case of Force Logout the process will  
	 * forward to checkLoginCompBr without any pass by loginCoBrScreen
	 * so httpSessionId will be empty, in this case will refill the sessionId here.  
	 */
	if(StringUtil.nullToEmpty(sessionCO.getHttpSessionID()).isEmpty())
	{
	    applyHttpSessionId(sessionCO);
	}
	loginBO.loginUserToModule(sessionCO.getCompanyCode(),sessionCO.getBranchCode(),sessionCO.getUserName(),sessionCO.getCurrentAppName(),sessionCO.getMachineIp(),sessionCO.getHttpSessionID(),sessionCO.isFinalSignOff());
	
	/**
	 * [MARWAN MADDAH]JAVA :Licenses Management
	 */
	return updatePathLicensesLog();
    }
    
    private String updatePathLicensesLog()throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	PathCounterLcSC pathCounterLcSC = new PathCounterLcSC();
	pathCounterLcSC.setCompCode(sessionCO.getCompanyCode());
	pathCounterLcSC.setBranchCode(sessionCO.getBranchCode());
	pathCounterLcSC.setAppName(sessionCO.getCurrentAppName());
	pathCounterLcSC.setEncPass("y%$4");
	return loginBO.pathLicensesLog(pathCounterLcSC);
    }

    /**
     * @author marwanmaddah
     * @date Oct 15, 2014
     * @param e void
     * 
     */
    private void addExceptionToActionError(Exception e)
    {
	String erroMessage = returnTranslatedMessage(e);
	if(erroMessage == null)
	{
	    erroMessage = (e.getMessage() == null)?e.toString():e.getMessage();
	}
	addActionError(erroMessage);
    }

    private String returnExceptionResult(Boolean openInDialog,boolean techException)
    {
	
	if(openInDialog)
	{
	    /**
	     * [MarwanMaddah]: in order to return the error as JSON string , and not to create a new variable 
	     */
	    try
	    {
		//PathJSONUtil.strutsJsonSerialize is used instead of jsonobject.fromobject to exclude null values
		String inputString = PathJSONUtil.strutsJsonSerialize(this, null, null, false, true);
		byte[] inputByte = inputString.getBytes(FileUtil.DEFAULT_FILE_ENCODING);
		inputStream = new ByteArrayInputStream(inputByte);
	    }
	    catch(Exception ex)
	    {
		handleException(ex, null, null);
	    }
	    return "SUCCESS_STRING";
	}
	else
	{
	    SessionCO sessionCO = returnSessionObject();
	    sessionCO.setCompanyCode(null);
	    sessionCO.setCompanyName(null);
	    sessionCO.setBranchCode(null);
	    sessionCO.setBranchName(null);
	    // For SADS the branch and session should be Kept ZERO in the VO while redirecting to the company branch screen
	    // branchesVO can be null if invalid branch entered and Continue clicked and precedent on dependency delayed
	    if(!ConstantsCommon.NO_COMP_BRANCH.equals(sessionCO.getAppLocationType()) && branchesVO != null)
	    {
		branchesVO.setBRANCH_CODE(null);
		branchesVO.setBRIEF_DESC_ENG(null);
	    }
	    if(techException)
	    {
		return ERROR_ACTION; 
	    }
	    else
	    {		
		return loginCompBr();
	    }
	}
    }
/**
 * returning translated message of Exception in case of BaseException
 * @param e
 * @return
 */
    private String returnTranslatedMessage(Exception e)
    {
	String erroMessage = null;
	if(e instanceof BaseException)
	{
	   BaseException cause = (BaseException) e;
	   // translating Error Message
	   if(cause.getErrorCode() != null)
	   {
	    	try
		{
			erroMessage = returnCommonLibBO().translateErrorMessage(cause, StringUtil.nullEmptyToValue(returnSessionObject().getLanguage(), ConstantsCommon.LANGUAGE_ENGLISH))[0];
		}
		catch(Exception ex)
		{
			log.error(ex, "ERROR in catching Exception");
			erroMessage = "Please Contact Administration";
		}
	   }
	}
	return erroMessage;
    }
    private void fillApplicationDetails(SessionCO sessionCO)  throws BaseException
    {
	CommonLibBO commonLibBO = returnCommonLibBO();
	S_APPVO appVO = new S_APPVO();
	appVO.setAPP_NAME(sessionCO.getCurrentAppName());
	appVO = commonLibBO.returnApplication(appVO);
	String appType = ConstantsCommon.CUSTOMER_TYPE_A;
	if(appVO != null)
	{
	    appType = StringUtil.nullEmptyToValue(appVO.getTYPE(),appType) ;
	    
	}
	sessionCO.setClientType(appType);
    }



    /**
     * 
     * Used for redirecting from Welcom Screen to corresponding Module
     * 
     * @return
     */
   public String moduleRedirect()
   {
       SessionCO sessCO = returnSessionObject();
       String defaultPageDisplay;
       try
        {
	   if(!ConstantsCommon.IBIS_APP_NAME.equals(sessCO.getCurrentAppName()))
	   {	       
	       defaultPageDisplay = loginBO.returnDefaultPageLogin(sessCO.getCompanyCode(), sessCO.getBranchCode(), sessCO.getCurrentAppName(), sessCO.getUserName(), sessCO.getLanguage(), sessCO.getBranchIsClosedUserLogged());
	       //redirect to Landing page in case it was set as default
	       if(ConstantsCommon.ONE.equals(defaultPageDisplay))
	       {
		   return LOGIN_LANDING_PAGE;
	       }
	   }
        }
        catch(Exception e)
        {
            handleException(e,null, null);
        }
      
       return SUCCESS_LOGIN;
   }
   /**
    * to Forward to Language Jsp page that construct language Menu
    * @return
 * @throws BaseException 
    */
    public String menuLang()
    {
	try
	{
	    // initialize Languages
	    initializeLanguages();
	    return "menuLang";
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	    return "menuLang";
    }

    /**
     * 
     * Used for applying the direction of the screens after language change
     * 
     */
    protected void applyDirection() throws BaseException
    {
	
	    SessionCO sessionCO = returnSessionObject();
	    SYS_PARAM_LANGUAGESVO sc = new SYS_PARAM_LANGUAGESVO();
	    String langVal = "en";
	    String isRTL = "ltr";
	    int isRTLDir = 0;
	    String language = ConstantsCommon.LANGUAGE_ENGLISH;
	    /**
	     * added for External screen language issue.
	     */
	    if(!StringUtil.nullToEmpty(sessionCO.getExternalScreenReq()).isEmpty() && ConstantsCommon.ONE.equals(sessionCO.getExternalScreenReq()))
	    {	    	
		    langVal = sessionCO.getLanguage().toLowerCase();
	    }
	    else
	    {		
		// localLang will be filled if loading from Login Page, set in Login.jsp
		if(session.get("localLang") != null )
		{
		    langVal = (String) session.get("localLang");
		    Locale requested_locale = PathLocalizedTextUtil.localeFromString(langVal, null);
		    ActionContext.getContext().setLocale(requested_locale);
		}
		else
		    if(ActionContext.getContext().getLocale().getLanguage() != null)
		    {
			langVal = ActionContext.getContext().getLocale().getLanguage();
		    }
		    else
		    {
			langVal = Locale.getDefault().getLanguage();
			Locale requested_locale = PathLocalizedTextUtil.localeFromString(langVal, null);
			ActionContext.getContext().setLocale(requested_locale);
		    }
		
		// remove login language attribute if exists.
		if(session.get("localLang") != null)
		{
		    session.remove("localLang");
		}
	    }

	    sc.setISO_CODE(langVal);
	    this.language = langVal;
	    SYS_PARAM_LANGUAGESVO langDet = returnCommonLibBO().returnDirection(sc);
	    if(langDet != null)
	    {
		language = langDet.getLANG_CODE();
		if(ConstantsCommon.ONE.equals(langDet.getIS_RIGHT_LEFT_YN()))
		{
		    isRTLDir = 1;
		    isRTL = "rtl";
		}
	    }
	    //when coming from landing page (fav/worksapce/app) we need to keep the language from parameters and not to use the default one
	    //in case the language is null in session then we need to default it
	    if((StringUtil.nullToEmpty(externalScreen).isEmpty() 
			&& StringUtil.nullToEmpty(appId).isEmpty()
			&& (StringUtil.nullToEmpty(menuVar).isEmpty() && StringUtil.nullToEmpty(sessionCO.getDirectMenuVar()).isEmpty())
			&& StringUtil.nullToEmpty(favoriteId).isEmpty()) || StringUtil.nullToEmpty(sessionCO.getLanguage()).isEmpty())
	    {
	    	sessionCO.setLanguage(language);
	    }
	    
	    sessionCO.setIsRTLDir(isRTLDir);
	    this.isRTL = isRTL;
	    
	    // change the translation of data in SessionCO in case of Language change.
	    // in case of reloadUserSessionDetails set to true then reload the branch details
	    if(PathActionContextMethods.returnParameters().get("langChanged") != null
		    || reloadUserSessionDetails)
	    {
		// return Translated BaseCurrency Name
		BigDecimal baseCurrCode =  sessionCO.getBaseCurrencyCode();
		if(baseCurrCode != null)
		{
		    	// fill baseCurrency Name translated
			CURRENCIESVOKey curVOKey = new CURRENCIESVOKey();
			curVOKey.setCOMP_CODE(sessionCO.getCompanyCode());
			curVOKey.setCURRENCY_CODE(baseCurrCode);
			CURRENCIESVO curVO = null;
			if(ConstantsCommon.OADM_APP_NAME.equals(sessionCO.getCurrentAppName()))
			{
			    curVO = returnCommonLibBO().returnOmniETLCurrency(curVOKey);
			}
			else
			{
			    curVO = returnCommonLibBO().returnCurrency(curVOKey);
			}
			if(curVO == null)
			{
			    throw new BOException(MessageCodes.ERROR_WHILE_RETRIEVE_COMPANY_BASE_CURRENCY_INFORMATION);// Error while retrieving base currency from company
			}
			else
			{
			    String baseCurrencyName = curVO.getBRIEF_DESC_ENG();
			    if(isRTLDir == 1)
			    {
				baseCurrencyName =  StringUtil.nullEmptyToValue(curVO.getBRIEF_DESC_ARAB(),baseCurrencyName);
			    }
			    sessionCO.setBaseCurrencyName(baseCurrencyName);
			}
		}
		
		// for SADS, Omni admin do not check on company branch validity to get company and branch
		if(ConstantsCommon.COMP_BRANCH.equals(sessionCO.getAppLocationType()))
		{
		    // filling Branch Name depends on Language
		    BigDecimal branchCode =  sessionCO.getBranchCode();
		    if(branchCode != null)
		    {
			// fill branch Name translated
			BRANCHESVOKey branchVOKey = new BRANCHESVOKey();
			branchVOKey.setCOMP_CODE(sessionCO.getCompanyCode());
			branchVOKey.setBRANCH_CODE(branchCode);
			BRANCHESVO branchVO = returnCommonLibBO().returnBranch(branchVOKey);
			if(branchVO == null)
			{
			    throw new BOException(MessageCodes.INVALID_BRANCH_CODE);// Error
			    // while
			    // retrieving
			    // base
			    // currency
			    // from
			    // company
			}
			else
			{
			    String branchName = branchVO.getBRIEF_DESC_ENG();
			    if(isRTLDir == 1)
			    {
				branchName = StringUtil.nullEmptyToValue(branchVO.getBRIEF_DESC_ARAB(), branchName);
			    }
			    sessionCO.setBranchName(branchName);
			}
		    }
		    
		    // filling Company Name depends on language
		    BigDecimal compCode =  sessionCO.getCompanyCode();
		    if(compCode != null)
		    {
			// fill branch Name translated
			COMPANIESVO compVO = new COMPANIESVO();
			compVO.setCOMP_CODE(compCode);
			compVO = returnCommonLibBO().returnCompany(compVO);
			if(compVO == null)
			{
			    throw new BOException(MessageCodes.INVALID_COMPANY_CODE);
			}
			else
			{
			    String compName = compVO.getBRIEF_DESC_ENG();
			    if(isRTLDir == 1)
			    {
				compName = StringUtil.nullEmptyToValue(compVO.getBRIEF_DESC_ARAB(), compName);
			    }
			    sessionCO.setCompanyName(compName);
			}
		    }
		}
	    }
    }

    private void initializeLanguages()
    {
	try
	{
	    languages = returnLanguages();
	    langCount = languages.size();
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
    }

    public static class Language
    {
	String description;
	String key;

	public Language(String key, String description)
	{
	    this.key = key;
	    this.description = description;
	}

	public String getKey()
	{
	    return key;
	}

	public String getDescription()
	{
	    return description;
	}

    }

    protected void setHeaderMenu(String applicName)
    {
	MainMenuVO menuVO;
//	= new MainMenuVO();
//	menuVO.setMenuHeaderName(getText("language_key"));
//	menuVO.setList_id("lang_id");
//	menuVO.setSubHref("pathdesktop/TopMenuAction_menuLang.action");
//	lstMenu.add(menuVO);
	
	if(!"".equals(applicName))
	{
//		menuVO = new MainMenuVO();
//		menuVO.setMenuHeaderName(getText("home_key"));
		if(ConstantsCommon.RET_APP_NAME.equals(applicName))
		{
//		   menuVO.setHref("pathdesktop/DesktopAction_corePortal");
		   homeURL = "pathdesktop/DesktopAction_corePortal";
		}
		/**
		 * #BUG558539 home issue in SADS 14.1.1
		 */
//		else
//		if(ConstantsCommon.SADS_APP_NAME.equals(applicName))
//		{
////			 menuVO.setHref("pathdesktop/dashboard.action?isRTL="+isRTL);
//			 homeURL = "pathdesktop/dashboard.action?isRTL="+isRTL;
//		}
		else
		if(ConstantsCommon.REP_APP_NAME.equals(applicName))
		{
//		    menuVO.setHref("pathdesktop/DesktopAction_reporting");
		    homeURL = "pathdesktop/DesktopAction_reporting";
		}
		else
		if(ConstantsCommon.TFA_APP_NAME.equals(applicName))
		{
//		   menuVO.setHref("pathdesktop/DesktopAction_tfaPortal");
		   homeURL = "pathdesktop/DesktopAction_tfaPortal";
		}
		else
		if(ConstantsCommon.TFA_PARAM_APP_NAME.equals(applicName))
		{
		   homeURL = "pathdesktop/DesktopAction_tfaParamPortal ";
		}
		else
                 if(ConstantsCommon.ASSETS_APP_NAME.equals(applicName))
                 {
                	homeURL = "pathdesktop/DesktopAction_assetsPortal";
                 }
                 else if(ConstantsCommon.PROC_APP_NAME.equals(applicName))
                 {
                     homeURL = "pathdesktop/DesktopAction_procPortal";
                 }
                 else
        	    if(ConstantsCommon.ALERT_APP_NAME.equals(applicName))
        	    {
        		homeURL = "pathdesktop/DesktopAction_alertPortal";
        	    }
        	    else if(ConstantsCommon.IMCO_APP_NAME.equals(applicName))
        	    {
        	        homeURL = "pathdesktop/DesktopAction_imcoPortal";
        	    }
        	    else if(ConstantsCommon.CMS_APP_NAME.equals(applicName))
                    {
                       homeURL = "pathdesktop/DesktopAction_cmsPortal";
                    }
    		else 
    		if(ConstantsCommon.IFRS_APP_NAME.equals(applicName))
    		{
    		    homeURL = "pathdesktop/DesktopAction_ifrsPortal";
    		}
    		else //TP 642900
    		if(ConstantsCommon.PROJECT_FINANCE_APP_NAME.equals(applicName))
    		{
    			homeURL = "pathdesktop/DesktopAction_prfnPortal";
    		 }
    		else //TP 872828 786289
    		if(ConstantsCommon.PROF_APP_NAME.equals(applicName)) 
    		{
    		    homeURL = "pathdesktop/DesktopAction_profPortal";
    		}
    		else 
		if(ConstantsCommon.RCSA_APP_NAME.equals(applicName)) 
		{
		    homeURL = "pathdesktop/DesktopAction_rcsaPortal";//TP 928061
		}
		else 
		if(ConstantsCommon.OAPI_APP_NAME.equals(applicName)) 
		{
		    homeURL = "pathdesktop/DesktopAction_openapiPortal";//TP 907642
		}
		else
		if(ConstantsCommon.AML_APP_NAME.equals(applicName))
		{
		   homeURL = "pathdesktop/DesktopAction_amlPortal";
		}
		else
		if(ConstantsCommon.ASSETS_PARAM_APP_NAME.equals(applicName))
		{
			homeURL = "pathdesktop/DesktopAction_pmspPortal";
		}
		else if(ConstantsCommon.ESHR_APP_NAME.equals(applicName))
		{
		    homeURL = "pathdesktop/DesktopAction_eshrPortal";
		}
		else if(ConstantsCommon.ESPL_APP_NAME.equals(applicName))
		{
		    homeURL = "pathdesktop/DesktopAction_esplPortal";
		}
		else if(ConstantsCommon.RTR_APP_NAME.equals(applicName))
        {
            homeURL = "pathdesktop/DesktopAction_rtrPortal";
        }
		else
		{
//			menuVO.setHref("");
		    homeURL = "";
		}
		// removing flag for opening "New session" when loading Dashboard, this flag set upon switch functionality
		session.put("newSession",null);
		//lstMenu.add(menuVO);
	}
	
	
	menuVO = new MainMenuVO();
	menuVO.setMenuHeaderName(getText("themes_key"));
	menuVO.setHref("");
	menuVO.setList_id("switcher");
	menuVO.setCssClass("menu_extremeRight");
	lstMenu.add(menuVO);
	
    }
    /**
     * 
     * Used for redirecting To RTR Portal
     * headerDecorator and appName are used in sitemesh decorator
     * 
     * @return
     */    
	public String rtrPortal() 
	{
		try 
		{
			themeName = CORE_THEME;
			fillCommonDetails();
			return rtrCustomerRet;
		} 
		catch (Exception e) 
		{
			log.error(e, "Error in rtrPortal method in DesktopAction");
			addActionError(e.getMessage());
			return ERROR;
		}
	}    
    /**
     * 
     * Used for redirecting when clicking on CSM CUSTOMER in Desktop.jsp
     * headerDecorator and appName are used in sitemesh decorator
     * 
     * @return
     */
    public String corePortal()
    {
	try
	{
	    themeName = CORE_THEME;
	    fillCommonDetails();
	    return csmCustomerRet;
	}
	catch(Exception e)
	{
	    log.error(e, "Error in corePortal method in DesktopAction");
	    addActionError(e.getMessage());
	    return ERROR;
	}
    }
    
    /**
     * 
     * Used for redirecting when clicking on CSM CUSTOMER in Desktop.jsp
     * headerDecorator and appName are used in sitemesh decorator
     * 
     * @return
     */
    public String omniAdminPortal()
    {
	try
	{
	    themeName = OMNI_THEME;
	    fillCommonDetails();
	    return omniAdminCustomer;
	}
	catch(Exception e)
	{
	    log.error(e, "Error in corePortal method in DesktopAction");
	    addActionError(e.getMessage());
	    return ERROR;
	}
    }
    
   /**
    * redirection to Project Finance Module
    * @return
    */
    public String prfnPortal()
    {//TP 642900 for project finance module
         try
         {
             themeName = CORE_THEME;
             fillCommonDetails();
             return prfnCustomerRet;
         }
         catch(Exception e)
         {
             log.error(e, "Error in prfnPortal method in DesktopAction");
             addActionError(e.getMessage());
             return ERROR;
         }
   }

    
    /**
     * Used for opening Main Screen of ESHR
     * @return
     */
    public String eshrPortal()
    {
      try
      {
            themeName = CORE_THEME;
            fillCommonDetails();
            return eshrCustomerRet;
      }
      catch(Exception e)
      {
            log.error(e, "Error in eshrPortal method in DesktopAction");
            addActionError(e.getMessage());
            return ERROR;
      }
    }
    
    /**
     * Used for opening Main Screen of ESPA
     * @return
     */
    public String espaPortal()
    {
      try
      {
            themeName = CORE_THEME;
            fillCommonDetails();
            return espaCustomerRet;
      }
      catch(Exception e)
      {
            log.error(e, "Error in espaPortal method in DesktopAction");
            addActionError(e.getMessage());
            return ERROR;
      }
    }
    
    /**
     * Used for opening Main Screen of ESPL
     * @return
     */
    public String esplPortal()
    {
      try
      {
            themeName = ESPL_THEME;
            fillCommonDetails();
            return esplCustomerRet;
      }
      catch(Exception e)
      {
            log.error(e, "Error in esplPortal method in DesktopAction");
            addActionError(e.getMessage());
            return ERROR;
      }
    }

    
    /**
     * Upgrade Module Portal redirection
     * @return
     */
    public String upgradePortal()
    {
        try
        {
            themeName = CORE_THEME;
            fillCommonDetails();
            return "upgrade_customer";
        }
        catch(Exception e)
        {
            log.error(e, "Error in upgradePortal method in DesktopAction");
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    /**
     * 
     * Used for redirecting when clicking on CSM Admin CUSTOMER in Desktop.jsp
     * headerDecorator and appName are used in sitemesh decorator
     * 
     * @return
     */
    public String coreAdminPortal()
    {
      try
      {
          themeName = CORE_THEME;
          fillCommonDetails();
          return csmAdminCustomerRet;
      }
      catch(Exception e)
      {
          log.error(e, "Error in coreAdminPortal method in DesktopAction");
          addActionError(e.getMessage());
          return ERROR;
      }
    }

    
    /**
     * Portal for PROC Module redirection
     * @return
     */
    public String procPortal()
    {
        try
        {
            themeName = TFA_THEME;
            fillCommonDetails();
            return procCustomerRet;
        }
        catch(Exception e)
        {
            log.error(e, "Error in procPortal method in DesktopAction");
            addActionError(e.getMessage());
            return ERROR;
        }
    }
    /**
     * Used for opening Main Screen of Swift Engine Application
     * @return
     */
    public String swenPortal()
    {
	try
	{
	    themeName = CORE_THEME;
	    fillCommonDetails();
	    return "swen_customer";
	}
	catch(Exception e)
	{
	    log.error(e, "Error in swenPortal method in DesktopAction");
	    addActionError(e.getMessage());
	    return ERROR;
	}
    }
    
    /**
     * Used for opening Main Screen of Swift Application
     * @return
     */
    public String swiftPortal()
    {
      try
      {
          themeName = CORE_THEME;
          fillCommonDetails();
          return "swift_customer";
      }
      catch(Exception e)
      {
          log.error(e, "Error in swiftPortal method in DesktopAction");
          addActionError(e.getMessage());
          return ERROR;
      }
    }
    /**
     * Used for opening Main Screen of SADS and SADS light Applications
     * @return
     */
    public String sadsPortal()
    {
    	try
    	{
    		themeName = SADS_THEME;
    		fillCommonDetails();
    		return sadsCustomerRet;
    	}
    	catch(Exception e)
    	{
    		log.error(e, "Error in fatcaPortal method in DesktopAction");
    		addActionError(e.getMessage());
    		return ERROR;
    	}
    }
    
    /**
     * Alert Portal Redirection
     * @return
     */
    public String alertPortal()
    {
        try
        {
            themeName = CORE_THEME;
            fillCommonDetails();
            return alertCustomerRet;
        }
        catch(Exception e)
        {
            log.error(e, "Error in alertPortal method in DesktopAction");
            addActionError(e.getMessage());
            return ERROR;
        }
    }
    
    /**
     * 
     * Used for opening Main Screen of IMCO Application
     * 
     * @return
     */
    public String imcoPortal()
    {
       try
       {
           themeName = CORE_THEME;
           fillCommonDetails();
           return imcoCustomerRet;
       }
       catch(Exception e)
       {
           log.error(e, "Error in imcoPortal method in DesktopAction");
           addActionError(e.getMessage());
           return ERROR;
       }
    }
    
  /**
    Used for opening Main Screen of Consolidation Application
  */
  public String consolidationPortal()
  {
         try {
                SessionCO sessionCO = returnSessionObject();
                fillCommonDetails();
                headerDecorator = getText("consolidation_key");                
                themeName = REPORTING_THEME;
                 portalSettings(sessionCO.getCurrentAppName());
                 return SUCCESS;
         }
         catch (Exception e) {
                 log.error(e, "Error in consolidation method in DesktopAction");
                 addActionError(getText("login.error"));
                 return ERROR;
         }
  }



  /**
   * Used for opening Main Screen of Accounting
   * @return
   */
  public String accPortal()
  {
     try
     {
           themeName = ACC_THEME;
           fillCommonDetails();
           return accCustomerRet;
     }
     catch(Exception e)
     {
           log.error(e, "Error in accPortal method in DesktopAction");
           addActionError(e.getMessage());
           return ERROR;
     }
  }
  
  /**
   * Used for opening Main Screen of Parameterization module
   * @return
   */
  public String paramPortal()
  {
	  try
	  {
		  themeName = PARAM_THEME;
		  fillCommonDetails();
		  return prmCustomerRet;
	  }
	  catch(Exception e)
	  {
		  log.error(e, "Error in prmPortal method in DesktopAction");
		  addActionError(e.getMessage());
		  return ERROR;
	  }
  }
  
  /**
  * Portal for Gateway Module redirection
  * @return
  */
  public String gatewayPortal()
  {
         try
         {
             themeName = GTW_THEME;
             fillCommonDetails();
             return gateWayCustomerRet;
         }
         catch(Exception e)
         {
             log.error(e, "Error in getwayPortal method in DesktopAction");
             addActionError(e.getMessage());
             return ERROR;
         }
    }

  /**
  * Portal for ATMP Module redirection
  * @return
  */
  public String atmpPortal()
  {
         try
         {
             themeName = ATMP_THEME;
             fillCommonDetails();
             return atmpCustomerRet;
         }
         catch(Exception e)
         {
             log.error(e, "Error in atmpPortal method in DesktopAction");
             addActionError(e.getMessage());
             return ERROR;
         }
    }

  

/**
 * 
 * Used for filling common DEtails among All Applications
 * 
 * @throws BaseException
 */
    private void fillCommonDetails() throws BaseException
    {
	try{
        	currentURL = "/pathdesktop/indexDesktopAction.action";
        	SessionCO sessionCO = returnSessionObject();
        	if(appName == null)
        	{
        	    appName = sessionCO.getCurrentAppName();
        	}
        	/**
        	 * [MarwanMaddah]
        	 * #BUG481199 switch company error
        	 * to be used in case of F5 in case of force logout situation on switch branch/company process.
        	 * to re fill the old login information.
        	 */
        	if(sessionCO.getCompanyCode() == null && sessionCO.getBranchCode() == null && StringUtil.nullToEmpty(sessionCO.getHttpSessionID()).isEmpty())
        	{
        	    
        	  HttpSession httpSession = ServletActionContext.getRequest().getSession();
        	  if(httpSession.getAttribute("prevCompCode")!=null && httpSession.getAttribute("prevBranchCode")!=null && httpSession.getAttribute("prevHttpSessionId")!=null)
        	  {
        	      sessionCO.setBranchCode((BigDecimal)httpSession.getAttribute("prevBranchCode"));
        	      sessionCO.setCompanyCode((BigDecimal)httpSession.getAttribute("prevCompCode"));
        	      sessionCO.setCompanyName((String)httpSession.getAttribute("prevCompDesc")); 
        	      sessionCO.setBranchName((String)httpSession.getAttribute("prevBranchDesc")); 
        	      sessionCO.setHttpSessionID((String)httpSession.getAttribute("prevHttpSessionId"));
        	      session.put(ConstantsCommon.SESSION_VO_ATTR,sessionCO);
            	      httpSession.removeAttribute("prevCompCode");
            	      httpSession.removeAttribute("prevBranchCode");
            	      httpSession.removeAttribute("prevCompDesc");
            	      httpSession.removeAttribute("prevBranchDesc");
            	      httpSession.removeAttribute("prevHttpSessionId");
        	  }
        	  
        	}
        	portalSettings(appName);
        	
        	String[] opts = {ConstantsCommon.DEFAULT_PRINTER_AXS,
        		ConstantsCommon.NEW_SESSION_OPT,
        		ConstantsCommon.BTN_CONFING_OPT,
        		ConstantsCommon.TECH_DETAILS_OPT,
        		ConstantsCommon.TECH_LOGS_OPT,
        		ConstantsCommon.SAVE_AS_OPT,
        		ConstantsCommon.SWITCH_VIEW_OPT,
        		ConstantsCommon.USER_THEME_OPT,
        		ConstantsCommon.LABELING_CONFIG_OPT,
        		ConstantsCommon.SETTINGS_CONFIG_OPT,
        		ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT,
        		ConstantsCommon.DYN_CLNT_PARAMS_APPROVE_OPT,
        		ConstantsCommon.DYN_CLNT_PARAMS_COLS_EDIT_OPT,
        		ConstantsCommon.GLOBAL_ACTIVITY_OPT,
        		ConstantsCommon.DYN_SCR_GEN_OPT,
        		ConstantsCommon.EXP_IMP_CUST_OPT};
        	    
        	HashMap<String,String> accessOpts = returnAccessRightByProgRef(opts, appName);
        	//enable final sign off in case of csm application.
        	if(ConstantsCommon.RET_APP_NAME.equals(appName))
        	{
            		SessionCO sesCO = returnSessionObject();
        	    	CommonLibSC criteria = new CommonLibSC();
        	    	criteria.setCompCode(sesCO.getCompanyCode());
        	    	criteria.setBranchCode(sesCO.getBranchCode());
        	    	criteria.setUserId(sesCO.getUserName());
        	    	criteria.setCurrAppName(sesCO.getCurrentAppName());
        	    	HashMap<String,String> allowAccess = returnCommonLibBO().checkUserValidity(criteria);
        	    	setFinalSignOffOption(allowAccess.get("finalSignOff"));
        	}
        	
        	//initialize the clusterEnabled flag
        	isClusterEnabled = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties", "global.cluster.enabled");
        	//Initialize alerts if alert engine is enabled
        	checkAlertsEnabled();
        	
        	//check if user has privileges for "Settings" change Option Available in application header
        	usrSettingRight = accessOpts.get(ConstantsCommon.SETTINGS_CONFIG_OPT+"_"+appName);
        	
        	//check if user has privileges for "Dynamic Screen Generator" change Option Available in application header
        	dynScrGenRight = accessOpts.get(ConstantsCommon.DYN_SCR_GEN_OPT+"_"+appName);
        	
        	//check if user has privileges for Label Translation Option Available in application header
        	usrLabelRight = accessOpts.get(ConstantsCommon.LABELING_CONFIG_OPT+"_"+appName);
        	
        	// check if the user has the access to activate/update/create themes
        	usrThemeRight = accessOpts.get(ConstantsCommon.USER_THEME_OPT+"_"+appName);
        
        	//check access rights on Switch View
        	switchViewRight = accessOpts.get(ConstantsCommon.SWITCH_VIEW_OPT+"_"+appName);
        	
        	//check access rights on SaveAs
        	usrSaveAsRight = accessOpts.get(ConstantsCommon.SAVE_AS_OPT+"_"+appName);
        	
        	//check access rights on technical details
        	techDetailsRight = accessOpts.get(ConstantsCommon.TECH_DETAILS_OPT+"_"+appName);

        	//check access rights on log level selection
        	techLogsRight = accessOpts.get(ConstantsCommon.TECH_LOGS_OPT+"_"+appName);
        	
        	//check access rights on button customization
        	usrBtnCustRight = accessOpts.get(ConstantsCommon.BTN_CONFING_OPT+"_"+appName);
        	
        	//check access rights on global operation
        	globalActivitiesRight = accessOpts.get(ConstantsCommon.GLOBAL_ACTIVITY_OPT+"_"+appName);
        	
        	/**
        	 * check access rights on new Session
        	 */
        	newSessionRight = accessOpts.get(ConstantsCommon.NEW_SESSION_OPT+"_"+appName);
        	
        	//check access privilege to set default printer
        	usrPrntAxsRight = accessOpts.get(ConstantsCommon.DEFAULT_PRINTER_AXS+"_"+appName); 
        	//654601 set the user selected local printer
        	if(StringUtil.isNotEmpty(usrPrntAxsRight))
        	{
        	    setUsrActvXSelectdPrntr(sessionCO.getUsrActvXSelectdPrntr());        	    
        	}

        	PTH_CTRL1VO pthCtrl1VO = returnCommonLibBO().returnPthCtrl1();
        	/**
        	 * [MarwanMaddah]:
        	 * in case the application is ITR
        	 * will check if it is iMAL or not 
        	 * in case isn't an iMAL application will check the property that is exists under PathRemoting
        	 * in case this property is 0 then the running date will be hidden 
        	 * otherwise will be enable.
        	 */
     	        if(ConstantsCommon.ITR_APP_NAME.equals(appName))
	        {	       
	            String itrRunningDateFlag = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties", "itr.runningdate.enable");
	            if(ConstantsCommon.NO.equals(pthCtrl1VO.getCORE_IMAL_YN()) && ConstantsCommon.ZERO.equals(itrRunningDateFlag))
	            {	        	
	        	enableItrRunningDate = ConstantsCommon.ZERO;
	            }
	            else
	            {
	        	enableItrRunningDate = ConstantsCommon.ONE;
	            }
	        }
	        
	        //check if user has privileges for Dynamic client params approve Option Available in application header
        	dynClntPrmsApproveRight = accessOpts.get(ConstantsCommon.DYN_CLNT_PARAMS_APPROVE_OPT+"_"+appName);

        	//check if user has privileges for Dynamic client params edit Option Available in application header
        	dynClntPrmsEditRight = accessOpts.get(ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT+"_"+appName);
        	
        	//check if user has privileges for Dynamic client params edit columns details Option Available in application header
        	dynClntPrmsColsEditRight = accessOpts.get(ConstantsCommon.DYN_CLNT_PARAMS_COLS_EDIT_OPT+"_"+appName);
        	
        	//Access rights for export/import screen customization.
        	setExpImpCustRight(accessOpts.get(ConstantsCommon.EXP_IMP_CUST_OPT+"_"+appName)); 
        	
        	// TP 715899 set notification to true of false which will enable websocket connection
        	String notificationEnabledFlag = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties", "notification.enabled");
        	if(ConstantsCommon.ZERO.equals(StringUtil.nullEmptyToValue(StringUtil.nullToEmpty(notificationEnabledFlag).trim(),ConstantsCommon.ZERO)))
        	{	        	
        		isNotificationEnabled = ConstantsCommon.FALSE;
        	}
        	else
        	{
        		isNotificationEnabled = ConstantsCommon.TRUE;
        	}
        	
        	// filling additional common details like Arabic Months...
        	fillOtherCommonParams();
        	
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}

    }
    
    /**
     * Method to fill any other common parameters whether opened as dashboard Portlets view or Menu view
     */
    protected void fillOtherCommonParams() throws Exception
    {
	//set the Arabic Months in English Labels 684983 ARIB180053
	PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
	if(pthCtrl != null && ConstantsCommon.ONE.equals(StringUtil.nullToEmpty(pthCtrl.getAR_MNTH_BASED_ENG())))
	{
	    isArbMnthEng = "1";
	}
	PTH_CTRL1VO pthCtrl1VO = returnCommonLibBO().returnPthCtrl1();
	//698427 check if the reports are to be printed as PDF
	if(pthCtrl1VO!=null && ConstantsCommon.ONE.equals(pthCtrl1VO.getREP_PRINT_PDF_YN()))
	{
	    printReportAsPDF = "1";
	}
    }
    
    /**
     * 654601 Method to set the user selected local printer
     */
    public String updateUserSelectedPrinter()
    {
	SessionCO theSession = returnSessionObject();
	try
	{
	    if(StringUtil.isNotEmpty(usrActvXSelectdPrntr))
	    {
		theSession.setUsrActvXSelectdPrntr(usrActvXSelectdPrntr);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }


/**
 * 	
 * Used for opening Main Screen of Assets Application
 * 
 * @return
 */
    public String assetsPortal()
    {
	try
	{
	    themeName = CORE_THEME;
	    fillCommonDetails();
	    return assetsCustomerRet;
	}
	catch(Exception e)
	{
	    log.error(e, "Error in corePortal method in DesktopAction");
	    addActionError(e.getMessage());
	    return ERROR;
	}
    }

	public String reporting()
	 {
	    	try {
	    	    	SessionCO sessionCO = returnSessionObject();
	    	    	fillCommonDetails();
			headerDecorator = getText("reporting");		    
			themeName = REPORTING_THEME;
		 	portalSettings(sessionCO.getCurrentAppName());
	     	        return SUCCESS;
		}
		catch (Exception e) {
		        log.error(e, "Error in reporting method in DesktopAction");
		        addActionError(getText("login.error"));
		        return ERROR;
		}
	}
	
    /**
     * 
     * Used for redirecting to TFA application
     * 
     * @return
     */
	public String tfaPortal()
	{
		try
		{
			themeName = TFA_THEME;
			fillCommonDetails();
			return tfaCustomerRet;
		}
		catch(Exception e)
		{
			log.error(e, "Error in tfaPortal method in DesktopAction");
			addActionError(e.getMessage());
			return ERROR;
		}
	}

	public String tfaParamPortal() 
	{
		try 
		{
			themeName = TFAP_THEME;
			fillCommonDetails();
			return tfaPCustomerRet;
		} 
		catch (Exception e) 
		{
			log.error(e, "Error in tfaParamPortal method in DesktopAction");
			addActionError(e.getMessage());
			return ERROR;
		}
	}
	
    /**
     * 
     * Used for redirecting to FATCA Standalone application
     * 
     * @return
     */
    public String fatcaPortal()
    {
	try
	{
	    themeName = TFA_THEME;
	    fillCommonDetails();
	    return fatcaCustomerRet;
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fatcaPortal method in DesktopAction");
	    addActionError(e.getMessage());
	    return ERROR;
	}
    }
    /**
     * 
     * Used for opening Main Screen of CMS Application
     * 
     * @return
     */
    public String cmsPortal()
    {
       try
       {
           themeName = CORE_THEME;
           fillCommonDetails();
           return cmsCustomerRet;
       }
       catch(Exception e)
       {
           log.error(e, "Error in cmsPortal method in DesktopAction");
           addActionError(e.getMessage());
           return ERROR;
       }
    }


	
	/**
	 * get Retail Details
	 * @param sessionCO
	 * @throws Exception
	 */
	private void fillRetailDetails(SessionCO sessionCO) throws Exception
	{
        	BigDecimal compCode = sessionCO.getCompanyCode();
        	BigDecimal branchCode = sessionCO.getBranchCode();
        	//String apName = sessionCO.getCurrentAppName();
        	
        	// fill Teller details in sessionCO
        	    CTSTELLERSC ctsTellerSC = new CTSTELLERSC();
        	    ctsTellerSC.setUserId(sessionCO.getUserName());
        	    ctsTellerSC.setCompCode(compCode);
        	    ctsTellerSC.setBranchCode(branchCode);
        	    sessionCO.setCtsTellerVO(loginBO.loadTellerDetails(ctsTellerSC, sessionCO.getMachineIp(),sessionCO.getHttpSessionID()));

	}
	/**
	 * 
	 * Used for settign running date into a session
	 * 
	 * @param sessionCO
	 * @return
	 * @throws Exception
	 */
    private List<String> fillRunningDate(SessionCO sessionCO) throws Exception
    {
	List<String> retResult = new ArrayList<>();
	BigDecimal compCode = sessionCO.getCompanyCode();
	BigDecimal branchCode = sessionCO.getBranchCode();
	String apName = sessionCO.getCurrentAppName();
	Date systemDate = returnCommonLibBO().returnSystemDateNoTime();
	Date runDate;
	// SADS or FATCA application
	
	PTH_CTRL1VO pthCtrl1VO = returnCommonLibBO().returnPthCtrl1();
	//#411342 Apply System Date as Running Date by default for HR applications (ESPL and ESHR)
	if(apName.equals(ConstantsCommon.SADS_APP_NAME) || apName.equals(ConstantsCommon.UPG_APP_NAME)
		|| apName.equals(ConstantsCommon.ESPL_APP_NAME) || apName.equals(ConstantsCommon.ESHR_APP_NAME)
		|| ConstantsCommon.OADM_APP_NAME.equals(apName)
		|| (apName.equals(ConstantsCommon.ITR_APP_NAME) && ConstantsCommon.NO.equals(pthCtrl1VO.getCORE_IMAL_YN()))
		// TP 905799 No Running Date message for REP and MTS
		||  ConstantsCommon.REP_APP_NAME.equals(apName) || ConstantsCommon.PROC_APP_NAME.equals(apName))
	{
	    /**
	     * [Marwan Maddah]: in case the application is ITR and the flag
	     * equals to One the the running date will be returned from a web
	     * services call wait to be ready from Integration team to call it.
	     */
	    if(apName.equals(ConstantsCommon.SADS_APP_NAME) || apName.equals(ConstantsCommon.UPG_APP_NAME) || apName.equals(ConstantsCommon.ESPL_APP_NAME) || apName.equals(ConstantsCommon.ESHR_APP_NAME)
			|| ConstantsCommon.OADM_APP_NAME.equals(apName)|| ConstantsCommon.REP_APP_NAME.equals(apName) || ConstantsCommon.PROC_APP_NAME.equals(apName))
	    {
		runDate = systemDate;
	    }
	    else
	    {
		enableItrRunningDate = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties","itr.runningdate.enable");
		if(ConstantsCommon.ONE.equals(enableItrRunningDate))
		{
            	   /**
            	    * [Marwan Maddah]
            	    * in case the application is not iMAL and the flag is equals to ONE
            	    * will get the running date from an external source via web services call...
            	    */
            	    CommonLibSC criteria = new CommonLibSC();
            	    criteria.setCompanyCode(sessionCO.getCompanyCode());
            	    criteria.setBranchCode(sessionCO.getBranchCode());
            	    criteria.setAppName(sessionCO.getCurrentAppName());
            	    runDate = returnCommonLibBO().returnExternalRunningDate(criteria);
		}
		else
		{
		    runDate = systemDate;
		}
	    }
	}
	else
	{
	    // TODO check if application like PROC, NV, CIF the appName is ACC

	    // Running Date of Retail application
	    runDate = loginBO.returnRunningDate(compCode, branchCode, apName);
	    if(runDate == null)
	    {
		retResult.add(returnCommonLibBO().returnTranslMessageOnly(779, sessionCO.getLanguage()));
		runDate = systemDate;
	    }
	    else
	    {
			// check if Running Date differes from System Date
			if(runDate.compareTo(systemDate) != 0)
			{
			    String[] params = new String[2];
			    params[0] = DateUtil.format(runDate, "dd/MM/yyyy");
			    params[1] = DateUtil.format(systemDate, "dd/MM/yyyy");
			    retResult.add(returnCommonLibBO().returnTranslMessageOnly(31327, params, sessionCO.getLanguage()));
			}
			
			//RKFHK190067--No warning message if running date not same as Phoenix running date
			String enablePhoenixDate = StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile("PathRemoting", "phoenix.rundate.enabled"), ConstantsCommon.ZERO);
			if(ConstantsCommon.ONE.equals(enablePhoenixDate))
			{				
				CommonLibCO libCO =loginBO.returnPhoenixRunningDate(compCode);
				if(libCO!=null && ConstantsCommon.YES.equals(libCO.getValidPhoenixExtDate())) {
					if(runDate.compareTo(libCO.getPhoenixExtDate()) != 0) {
						String[] params = new String[2];
						params[0] = DateUtil.format(runDate,"dd/MM/yyyy");
						params[1] = DateUtil.format(libCO.getPhoenixExtDate(), "dd/MM/yyyy");
						retResult.add(returnCommonLibBO().returnTranslMessageOnly(2201, params, sessionCO.getLanguage()));
					}
				}
			}
	    }

	}

	sessionCO.setRunningDateRET(runDate);
	return retResult;
    }

	/**
	 * get and fill User Details
	 * @param sessionCO
	 * @throws Exception
	 */
	protected void fillUserDetails(SessionCO sessionCO) throws Exception
	{
	 // set user Details into SessionCO
		
		UsrCO uinfo = loginBO.userLoginDet(returnUserName());
	    	if(uinfo != null)
	    	{
	    	    sessionCO.setPreferredLanguage(uinfo.getPREFERED_LANGUAGE());
	    	    sessionCO.setUserFirstName(uinfo.getFIRST_NAME());
	    	    sessionCO.setUserLastName(uinfo.getLAST_NAME());
	    	    sessionCO.setUserCIFNo(uinfo.getCIF_NO());
	    	    sessionCO.setAccessRestricted(uinfo.getACCESS_RESTRICTED());
	    	    sessionCO.setUsrPathSts(uinfo.getPATH_STS());
	    	    sessionCO.setUsrDefPrinter(uinfo.getDEFAULT_PRINTER());
	    	    //TP402738 Adding Employee Id , company and Branch into SessionCO
	    	    sessionCO.setEmployeeId(uinfo.getEMPLOYEE_ID());
	    	    sessionCO.setEmpCompCode(uinfo.getEMP_COMP_CODE());
	    	    sessionCO.setEmpBranchCode(uinfo.getEMP_BRANCH_CODE());
	    	    
	    	    //TP317013 setting the flag for show print preview dialog upon report printing
	    	    sessionCO.setShowPrintPreview(StringUtil.nullEmptyToValue(uinfo.getSHOW_PRINT_PREVIEW_YN(), ConstantsCommon.NO).trim()); 
	    	    // set the Token verification flag to show input in login company/branch screen
    	    	    sessionCO.setTokenVerification(uinfo.getTOKEN_VERIFICATION_YN());
	    	    // setting session time out of the user
	    	    BigDecimal idleSec = NumberUtil.nullToZero(uinfo.getIDLE());
	    	    if(idleSec.intValue() > 0)
	    	    {
	    		ServletActionContext.getRequest().getSession().setMaxInactiveInterval(idleSec.intValue());
	    	    }
	    	    
        	    	// check if printing of screen need to be disabled either by user or by whole system
        	    	PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
        	    	if(ConstantsCommon.ONE.equals(StringUtil.nullToEmpty(pthCtrl.getDISABLE_PRINTSCR()))
        	    		||ConstantsCommon.ONE.equals(StringUtil.nullToEmpty(uinfo.getDISABLE_PRINTSCR())))
        	    	{
        	    	    sessionCO.setDisablePrntScrn(ConstantsCommon.ONE);
        	    	}
	    	
	    	}
	}
	
	/**
	 * get and fill User Details
	 * @param sessionCO
	 * @throws Exception
	 */
	private void fillOtherDetails(SessionCO sessionCO) throws Exception
	{
	    // set company Details Details into SessionCO
	    COMPANIESVO compVO = new COMPANIESVO();
	    BigDecimal compCode = sessionCO.getCompanyCode();
	    compVO.setCOMP_CODE(compCode);
	    compVO = companiesBO.getCompaniesDetails(compVO);
	    if(compVO == null)
	    {
		throw new BOException("No Company Exists for company Code "+sessionCO.getCompanyCode());
	    }
	    else
	    {
		BigDecimal bseCurrCode = compVO.getBASE_CURRENCY();
		sessionCO.setBaseCurrencyCode(bseCurrCode);
		String branchChar = "N";
		if(StringUtil.nullToEmpty(compVO.getSHOW_BRANCHES()).equals(ConstantsCommon.ONE))
		{
		    branchChar = "I";
		}
		sessionCO.setShowBranchesChar(branchChar);
		
		// fill Company description
		String cmpName = compVO.getBRIEF_DESC_ENG();
		if(sessionCO.getIsRTLDir() == 1)
		{
		    cmpName = compVO.getBRIEF_DESC_ARAB();
		}
		sessionCO.setCompanyName(cmpName) ;
		sessionCO.setCompanyArabName(compVO.getBRIEF_DESC_ARAB()) ;
		
		// fill baseCurrency Decimal Point
		CURRENCIESVOKey curVOKey = new CURRENCIESVOKey();
		curVOKey.setCOMP_CODE(compCode);
		curVOKey.setCURRENCY_CODE(bseCurrCode);
		CURRENCIESVO curVO = null;
		if(ConstantsCommon.OADM_APP_NAME.equals(sessionCO.getCurrentAppName()))
		{
		    curVO = returnCommonLibBO().returnOmniETLCurrency(curVOKey);
		}
		else
		{
		    curVO = returnCommonLibBO().returnCurrency(curVOKey);
		}
		if(curVO == null)
		{
		    throw new BOException(MessageCodes.ERROR_WHILE_RETRIEVE_COMPANY_BASE_CURRENCY_INFORMATION);// Error while retrieving base currency from company
		}
		else
		{
		    sessionCO.setBaseCurrDecPoint(curVO.getDECIMAL_POINTS());
		    // set base currency name according to the Language choosen
		    String baseCurrencyName = curVO.getBRIEF_DESC_ENG();
		    if(ConstantsCommon.LANGUAGE_ARABIC.equals(sessionCO.getLanguage()))
		    {
			baseCurrencyName = StringUtil.nullEmptyToValue(curVO.getBRIEF_DESC_ARAB(),baseCurrencyName);
		    }
		    sessionCO.setBaseCurrencyName(baseCurrencyName);
		}
		
		// get Exposure Currency
		String appName = sessionCO.getCurrentAppName();
		BigDecimal branchCode = sessionCO.getBranchCode();
		String userName = sessionCO.getUserName();
		String ip = sessionCO.getMachineIp();
		if(!ConstantsCommon.IBIS_APP_NAME.equals(appName))
		{
		    // throws exception if invalid exposure currency
		    CURRENCIESVO exposureCurrVo = loginBO.returnExposureCurrency(compCode,branchCode,appName, userName,ip,sessionCO.getHttpSessionID());
		    BigDecimal exposureCurrCode = BigDecimal.ZERO;
		    String exposureCurName = null;
		    if(exposureCurrVo != null)
		    {
			exposureCurrCode = exposureCurrVo.getCURRENCY_CODE();
			exposureCurName = exposureCurrVo.getBRIEF_DESC_ENG();
		    }
		    sessionCO.setExposCurCode(exposureCurrCode);
		    sessionCO.setExposCurName(exposureCurName);
		}
	    }
	}
	
	
    
    /**
     * 
     * Used for redirecting when clicking on User and Identity
     * headerDecorator and appName are used in sitemesh decorator
     * 
     * @return
     */
	public String adminPortal()
	{
		try
		{
			headerDecorator = getText("usr.security.mngmt");
			appName = ConstantsCommon.SADS_APP_NAME;
			themeName = SADS_THEME;
			currentURL = "/pathdesktop/indexDesktopAction.action";
			portalSettings(appName);
			/**
			 * check access rights on new Session
			 */
			newSessionRight = returnAccessRightByProgRef(ConstantsCommon.NEW_SESSION_OPT);

			return usrSecurityRet;
		}
		catch(Exception e)
		{
			log.error(e, "Error in adminPortal method in DesktopAction");
			addActionError(e.getMessage());
			return ERROR;
		}
	}
	
	
	/**
     * 
     * Used for redirecting when clicking on User and Identity
     * headerDecorator and appName are used in sitemesh decorator
     * 
     * @return
     */
	public String loginCompBr()
	{
		try
		{
			headerDecorator = getText("usr.security.mngmt");
		 	appName = "";//   LOGINCOMPBR ;
		 	currentURL = "/pathdesktop/loginCompBrAction_loginCoBrScreen";
			themeName = SADS_THEME;
			sessionCOInitialize();
			portalSettings(appName);

			SessionCO sessionCO = returnSessionObject();
			
			
            		/**
            		 * to make the company filed readOnly with the logged in company
            		 * information in case of switch branch management
            		 */
            		if(switchBranch && ConstantsCommon.COMP_BRANCH.equals(sessionCO.getAppLocationType()))
            		{
            		    SYS_PARAM_SCREEN_DISPLAYVO screenDisplayVO = new SYS_PARAM_SCREEN_DISPLAYVO();
            		    screenDisplayVO.setELEMENT_ID("lookuptxt_COMP_CODE");
            		    screenDisplayVO.setELEMENT_NAME("companiesVO.COMP_CODE");
            		    screenDisplayVO.setIS_READONLY(BigDecimal.ONE);
            		    getAdditionalScreenParams().put("companiesVO.COMP_CODE", screenDisplayVO);
            		    companiesVO.setCOMP_CODE(sessionCO.getCompanyCode());
            		    companiesVO.setBRIEF_DESC_ENG(sessionCO.getCompanyName());
            		    sessionCO.setTokenVerification(null);
            		}
            		else
            		{
            		    /**
            		     * check for pwd expiry and show message on login by company
            		     * branch screen not in the welcome message screen
            		     */
            		    UsrCO usrCO = loginBO.userLoginDet(sessionCO.getUserName());
            		    PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
            		    // check if the user has expiry date notification then it will overrides the one in pth_ctrl
            		    int  expNotifDays = NumberUtil.nullToZero(usrCO.getUSR_PWD_EXPIRY_NOTIFY_DAYS_NO()).intValue() > 0?usrCO.getUSR_PWD_EXPIRY_NOTIFY_DAYS_NO().intValue():NumberUtil.nullToZero(pthCtrl.getPWD_EXPIRY_NOTIFY_DAYS_NO()).intValue();
            		    if(expNotifDays > 0
            			    && sessionCO.getCompanyCode() == null)
            		    {
            			Date expiryDate = loginBO.returnPwdExpDate(usrCO);
            			if(expiryDate != null)
            			{
            			    long daysToExpiry = DateUtil.numberOfDays(usrCO.getSystemDate(), expiryDate, "dd/MM/yyyy");
            			    if(daysToExpiry <= expNotifDays)
            			    {
            				//check if there is message code for the expiry date notification message then it will take place other wise the default message will appear 
            				int expirayMessageCode =  NumberUtil.nullToZero(pthCtrl.getPWD_EXPIRY_MSG_CODE()).intValue() > 0?pthCtrl.getPWD_EXPIRY_MSG_CODE().intValue():MessageCodes.PWD_EXPIRY;
            				addActionError(returnCommonLibBO().returnTranslMessageOnly(expirayMessageCode,
            					new String[] { "" + daysToExpiry }, sessionCO.getLanguage()));
            			    }
            			}
            		    }
            
            		  
            		    // if SADS application then set the company and branch to Zero and check if there is no errors 
            		    //and not welcome message available to proceed to Menu
                	    if(ConstantsCommon.NO_COMP_BRANCH.equals(sessionCO.getAppLocationType())) 
                	    {
        	        		companiesVO.setCOMP_CODE(BigDecimal.ZERO);
        	        		branchesVO.setBRANCH_CODE(BigDecimal.ZERO);
                	    }
                	    else
                	    {
                        	    /**
                    		     * check if user has one company and one branch redirect
                    		     * automatically to main screen
                    		     */
                    		    CommonLibSC sc = new CommonLibSC();
                    		    sc.setUserId(sessionCO.getUserName());
                		    if(ConstantsCommon.ONLY_COMP.equals(sessionCO.getAppLocationType()))
                		    {
                    			branchesVO.setBRANCH_CODE(BigDecimal.ZERO);
                		    }
                    		    List<LOCVO> coBrList = returnCommonLibBO().returnUserCompanyBranch(sc);
                    		    // actionerrors in case already logged in and relogin in F5
                    		    // or close/open
                    		    if(coBrList.size() == 1 && getActionErrors().size() == 0 && welcMsg == null
                    			    && BigDecimal.ZERO.equals(sessionCO.getTokenVerification()))
                    		    {
	                    			LOCVO theVO = coBrList.get(0);
	                    			companiesVO.setCOMP_CODE(theVO.getCOMP_CODE());
	                    			
	                    			companiesVO = returnCommonLibBO().returnCompany(companiesVO);
	                    			// means that there is incorrect data in LOC table where the company specified not available
	                    			if(companiesVO != null)
	                    			{
	                    			    branchesVO.setBRANCH_CODE(theVO.getBRANCH_CODE());
	                    			    return checkLoginCompBr();
	                    			}
	                    			else
	                    			{
	                    			  addExceptionToActionError(new BOException(MessageCodes.INVALID_COMPANY_CODE));
	                    			}
                    		    }
                    		    /**
                    		     * RKFHK200358- In login screen Company & Branch to default as the last logged in Company & Branch
                    		     * to get the company branch default values form the last log in 
                    		     * that has been made from this user to the current application
                    		     */
                    		    else
                    		    {
                    		    	try 
                    		    	{
                    		    		String dfltCompBrProp = StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile("PathRemoting", "default.compBrValues.enabled"), ConstantsCommon.ONE);
                    		    		if(ConstantsCommon.ONE.equals(dfltCompBrProp) && !Boolean.TRUE.equals(openInDialog))
                    		    		{
                            		    	UsrSC userSC = new UsrSC();
                            		    	userSC.setAppName(sessionCO.getCurrentAppName());
                            		    	userSC.setUserId(sessionCO.getUserName());
                            		    	userSC.setPreferredLanguage(sessionCO.getPreferredLanguage());
                            		    	DefaultCompBranchCO defltCompBrCO = loginBO.returnDefaultCompBr(userSC);
                            		    	if(defltCompBrCO !=null)
                            		    	{
                            		    		companiesVO.setCOMP_CODE(defltCompBrCO.getCompanyCode());
                            		    		companiesVO.setBRIEF_DESC_ENG(defltCompBrCO.getCompanyDesc());
                            		    		branchesVO.setBRANCH_CODE(defltCompBrCO.getBranchCode());
                            		    		branchesVO.setBRIEF_DESC_ENG(defltCompBrCO.getBranchDesc());
                            		    	}
                    		    		}
                    		    	}
                    		    	catch(Exception ex)
                    		    	{
                    		    		handleException(ex,null,null);
                    		    	}
                    		    }
                    		}
			}
			return loginCompBrRet;
		}
		catch(BaseException e)
		{
			log.error(e, "Error in loginCompBr method in DesktopAction");
			return ERROR;
		}
	}
    
	/**
	 * Used to set menu and apply direction
	 */
	private void portalSettings(String appName) throws BaseException
	{
		SessionCO sessionCO = returnSessionObject();
		applyDirection();
		setHeaderMenu(appName);
		//the role full access should be added after defining the comp code and branch code from the screen
		if(sessionCO.getCompanyCode() != null && sessionCO.getBranchCode() != null)
		{
		    assignUserAuthentRole("ROLE_FULL_ACCESS");
		}
		HashMap<String, Object>userNbFormats = new HashMap<String, Object>();
		userNbFormats.put(DateUtil.DATE_MASK_ATTRIBUTE, DateUtil.DEFAULT_DATE_FORMAT);//have to query date format for a user from database
		userNbFormats.put("default", "###");// default number format specification
		userNbFormats.put("decimalSepa", ConstantsCommon.PATH_DECIMAL_SEPARATOR);
		userNbFormats.put("groupSepa", ConstantsCommon.PATH_GROUP_SEPARATOR);
		sessionCO.setUserNbFormats(userNbFormats);
		
	}
    
    /**
     * method used to change user Role in authentication Credentials
     * 
     * @param userRole : Role to be set.
     */
    private void assignUserAuthentRole(String userRole) throws BaseException
    {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	Collection authorities = new ArrayList();
	authorities.add(new SimpleGrantedAuthority(userRole));
	Authentication auth1 = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(),
		authorities);
	SecurityContextHolder.getContext().setAuthentication(auth1);
    }
    
    
    /**
     * method used while opening external screen in iframe. Needed to skip default decorator
     * @return
     */
    public String newDecoration()
    {
	try
	{
	    // TP 868811 DBU191032, When External Screen is loaded without JS Global Variable  printReportAsPDF filled
	    fillOtherCommonParams();
	    applyDirection();
	}
	catch(Exception e)
	{
	    log.error(e, "Error in newDecoration method in DesktopAction");
	}
	return SUCCESS;
    }
    
    /**
     * loads the error page in case of opening external screen from menu
     * @return
     */
    public String loadExternalScreenErrorPage()
    {
	//get the externalScreenError from the session
	HttpSession session = ServletActionContext.getRequest().getSession();
	if(session != null)
	{    
	    String externalScreenError = session.getAttribute("externalScreenErrorActionMsg") == null ? "" : 
			String.valueOf(session.getAttribute("externalScreenErrorActionMsg"));
	    //remove the externalScreenError from the session
	    session.removeAttribute("externalScreenErrorActionMsg");
	    //display the error message by doing a redirection to error_action
	    addActionError(externalScreenError);
	}
	return ERROR_ACTION;
    }
	public String loadDecoration()
	{
	    try
	    {
		SessionCO sessionCO = returnSessionObject();
		//appName = menuVar;
		    HttpServletRequest request = ServletActionContext.getRequest();
		    String appId = request.getParameter("appId");
		    
		    if(!StringUtil.nullToEmpty(appId).isEmpty())
		    {
		    	sessionCO.setFavoriteId(null); 
		    }
	    	String favoriteId = ServletActionContext.getRequest().getParameter("favoriteId");
	    	
	    	//already authenticated and favorites link is clicked favoriteId is not in session(it is set in case of autologin in CustomUrlEntryPoint and here if case of already authenticated) 		    	
	    	if(/*favoriteId  == null && */StringUtil.nullToEmpty(appId).isEmpty() && PathActionContextMethods.returnParameters().get("favoriteId") != null )
		    {
	  	       favoriteId = ((String[])PathActionContextMethods.returnParameters().get("favoriteId"))[0];
	    	}
		
		//handle user session reload
    		String runningDateRET = request.getParameter("runningDateRET");
    		String j_username = request.getParameter("j_username");
    		String language = request.getParameter("language");
    		//check if comp code and branch code changed
    		if(request.getParameter("login_comp_code") != null
    			&& !request.getParameter("login_comp_code").isEmpty())
    		{
    		    BigDecimal loginCompCode = new BigDecimal(request.getParameter("login_comp_code"));
    		    BigDecimal loginBraCode = new BigDecimal(request.getParameter("login_bra_code"));
    		    if((!loginCompCode.equals(sessionCO.getCompanyCode()))
    		    	    || (!loginBraCode.equals(sessionCO.getBranchCode())))
    		    {
    			sessionCO.setCompanyCode(loginCompCode);
    			sessionCO.setBranchCode(loginBraCode);
    			reloadUserSessionDetails = true;
    		    }
    		}
    		
    		//in case of force logout
    		if(sessionCO.getCompanyCode() == null && companiesVO.getCOMP_CODE() != null &&
    			sessionCO.getBranchCode() == null && branchesVO.getBRANCH_CODE() != null)
    		{
    		    applyCompBranchNames(companiesVO.getCOMP_CODE(), branchesVO.getBRANCH_CODE());
    		}
    		//set comp code and branch code in case passed in request params
    		if(sessionCO.getCompanyCode() == null && request.getParameter("login_comp_code") != null
    			&& sessionCO.getBranchCode() == null && request.getParameter("login_bra_code") != null )
    		{
    		    BigDecimal loginCompCode = new BigDecimal(request.getParameter("login_comp_code"));
    		    BigDecimal loginBraCode = new BigDecimal(request.getParameter("login_bra_code"));
    		    companiesVO.setCOMP_CODE(loginCompCode);
    		    branchesVO.setBRANCH_CODE(loginBraCode);
    		    applyCompBranchNames(loginCompCode,loginBraCode);
    		}

    		//set running date passed in request parameters
    		if(StringUtil.isNotEmpty(runningDateRET))
    		{
    		    sessionCO.setRunningDateRET(DateUtil.parseDate(runningDateRET, DateUtil.DEFAULT_DATE_FORMAT));
    		}
    		//check if language changed
    		if(StringUtil.isNotEmpty(language))
    		{
    		    sessionCO.setLanguage(language);
    		    Locale requested_locale = PathLocalizedTextUtil.localeFromString(language, null);
    		    ActionContext.getContext().setLocale(requested_locale);
    		}
    		//in case usename is changed then authenticate and reload session details
    		if(StringUtil.isNotEmpty(j_username) && !j_username.equals(sessionCO.getUserName()))
    		{
    		    HttpServletResponse response = ServletActionContext.getResponse();
    		    Authentication authentication = secureFilter.attemptAuthentication(request, response);
    		    SecurityContext securityContext = (SecurityContext) session.get("SPRING_SECURITY_CONTEXT");
    		    securityContext.setAuthentication(authentication);
    		    sessionCO.setUserName(j_username);
    		    reloadUserSessionDetails = true;
    		    // no need to call login method because the login() will
    		    // call portalSettings that exists below;
    		}
    		//end handle user session reload
    		
		if((menuVar == null || menuVar.isEmpty() ) && favoriteId != null)
		{
		    	//get menuVar and Appname from favoriteId
		    	USER_FAVORITESVO vo = returnCommonLibBO().returnFavMenuApp(new BigDecimal(favoriteId));
            		if(vo != null)
            		{
            		    screenTitle = vo.getDESCRIPTION();
            		    menuVar = vo.getPROG_REF();
            		    returnSessionObject().setCurrentAppName(vo.getAPP_NAME());
            		    sessionCO.setFavoriteId(favoriteId);
            		    currentURL = "pathdesktop/loadDecorationAction?favoriteId=" + favoriteId;
            		}
		}
		    	//opening screen from workspace link/button in case already authenticated through autologin 
		else if(menuVar != null && sessionCO.getCurrentAppName() != null)
		{
		    currentURL = "pathdesktop/loadDecorationAction?appName="+sessionCO.getCurrentAppName()+"&menuVar="+menuVar;
		    if(sessionCO.getAdditionalParamsMap() != null)
		    {
			screenTitle = (String)sessionCO.getAdditionalParamsMap().get("screenTitle");
			if(StringUtil.isNotEmpty(screenTitle))
			{
			    screenTitle = URLDecoder.decode(screenTitle,"UTF8");
			}
			sessionCO.setAdditionalParamsMap(null);
		    }
		}
		portalSettings("");
		/**
		 * [MarwanMaddah]:have been Added to pass the process by all login access right
		 */
		fillLoginByCompBrDetails(sessionCO.getCompanyCode(), sessionCO.getBranchCode());
		fillOtherCommonParams();
		fillUserDetails(sessionCO);
		/**
		 * 
		 */
			
		//*********************check already logged in**************************************************
		try
		{
		     if(reloadUserSessionDetails)
		     {
		    	checkCompanyBranchAccess();
		     }
		     loginUserToModule();
		}
		catch(BOException e)
		{
		    if(MessageCodes.USR_ALREADY_LOGGED_IN.equals(e.getErrorCode()) || MessageCodes.USRS_ALREADY_EXEC_PERIODICAL_PROCESS.equals(e.getErrorCode())
			    || MessageCodes.CANNOT_LOGIN_EOD_WEB_VERSION_IS_RUNNING.equals(e.getErrorCode()))
		    {
		    		/**
		    		 * MarwanMaddah: added to enter in force logout process when opening an application from landing page 
		    		 */
				String forceLogoutAccessRight = null;
				// 52696 if WEB EOD running users not allowed to login, so no need to check on FORCE logout Access rights
				if(!MessageCodes.CANNOT_LOGIN_EOD_WEB_VERSION_IS_RUNNING.equals(e.getErrorCode()))
				{
				    forceLogoutAccessRight = returnAccessRightByProgRef(ConstantsCommon.SESSION_FORCE_LOGOUT);
				}
				// if WEB EOD is running, or FORCE logout is enabled
				if(StringUtil.nullToEmpty(forceLogoutAccessRight).isEmpty())
				{
					addExceptionToActionError(e);
					//we need to set the compcode and branchcode to null to block the user from proceeding with the login. 
					//if we keep the current compcode and branchcode not null the message 'user already logged in ' will not appear when calling checkLoginCompBr()
					String returnLoginCompBr = loginCompBr();
				        sessionCO.setCompanyCode(null);
				        sessionCO.setBranchCode(null);
				        sessionCO.setCompanyName(null);
					sessionCO.setBranchName(null);
					companiesVO.setCOMP_CODE(null);
					branchesVO.setBRANCH_CODE(null);
				        return returnLoginCompBr;  
				}
				else
				{
				    String msgKey = ConstantsCommon.SESSION_CHECKING_MSG_KEY;
				    if(MessageCodes.USRS_ALREADY_EXEC_PERIODICAL_PROCESS.equals(e.getErrorCode()))
				    {
					msgKey = ConstantsCommon.PERIODICAL_PROCESS_IN_PROGRESS_KEY;
			            }
				    addActionError(getText(msgKey));

				    companiesVO.setCOMP_CODE(sessionCO.getCompanyCode());
				    branchesVO.setBRANCH_CODE(sessionCO.getBranchCode());
				    sessionCO.setCompanyCode(null);
				    sessionCO.setCompanyName(null);
				    sessionCO.setBranchCode(null);
				    sessionCO.setBranchName(null);
				    sessionCO.setHttpSessionID(null);
				    
				    // in case of force logout , we need to assign the desktop action role only to avoid accessing the menu 
			            // by setting the url /DetkopAction_!corePortal directly from the browser 
			            try
			            {
			        	if(!openInDialog)
			        	{
			        	    assignUserAuthentRole("ROLE_DESKTOP_ACCESS");
			        	}
			            }
			            catch(BaseException b)
			            {
			        	handleException(b, null, null);
			            }
				    
				    return "session_checking";
				}
			}
		    }
		    //***********************************************************************
		//Added parameter to prevent the double loading of path-head in case load decoration is called
		//BUG #437093, 475257, 454175, 492596, 506339
		loadFunc = "false";	
		}
		catch(Exception ex)
		{
		    handleException(ex, null, null);
		    return ERROR_ACTION;
		}
	    
		return SUCCESS;
	}	
    
  public String clearCache()
  {
      try
      {
	  String techDetailsAccessRight = returnAccessRightByProgRef(ConstantsCommon.TECH_DETAILS_OPT);
	  if(techDetailsAccessRight == null)
	  {
	      throw new BOException(MessageCodes.NO_ACCESS);
	  }

	  // clearing service Side Cache
	 returnCommonLibBO().clearCache(); 
	 // clearing cache for BAseService variables
	 clearBaseServiceCache();
	 // restarting Alert Engine
	 SessionCO sessCO = returnSessionObject();
	 String appName = ConstantsCommon.returnCurrentAppName();
	 String machineName= "RemoteClust";// initialize to RemoteCluster in case coming from Cluster Call, No Audit
	 String userID = "RemotUsr";// initialize to RemoteUsr in case coming from Cluster Call, No Audit;
	 //TP#456163 If remotely called from cluster environment then sessionCO will be null
	 if(sessCO != null)
	 {
	 appName = StringUtil.nullEmptyToValue(sessCO.getCurrentAppName(), ConstantsCommon.returnCurrentAppName());
	 machineName= sessCO.getMachineIp();
	 userID= sessCO.getUserName();
	 }
	 alertsEngineBO.restartScheduledTask(appName);
	 // resetting the alert parameterization map
	 synchronized(CachedConstantsCommon.alertsParamMap) {CachedConstantsCommon.alertsParamMap = new HashMap<String, Map<String,Object>>();}
	 // resetting the translation for Business Fields (ToolTip...)
	 synchronized(CachedConstantsCommon.busTransInfo) {CachedConstantsCommon.busTransInfo = new HashMap<String, Map<String,FieldsBusTransCO>>();}
 	 //TP#456163 get the clear cache messages before clearing the label translation cache 
	 String cacheSuccess = getText("cluster_clear_cache_success_key"),  cacheFail = getText("cluster_clear_cache_fail_key");
	 // resetting the translation for Key Labels
	 synchronized(CachedConstantsCommon.keyLabelTransMap) {CachedConstantsCommon.keyLabelTransMap = new HashMap<String, HashMap>();}
	 // resetting the OPTs' parent List
	 synchronized(CachedConstantsCommon.optHm) {CachedConstantsCommon.optHm = new HashMap<String, String[]>();}
	 // resetting the info map
	 synchronized(CachedConstantsCommon.findInfo) {CachedConstantsCommon.findInfo = new HashMap<String, HashMap>();}
	 // resetting BPM properties from PathBPM.properties and PathBPMBOMapping.properties files
	 BpmCommonMethods.reloadBpmEngineProperties();
	 // reset PathRemoting.properties File cache so that any change in its properties will take effect
	 PathPropertyUtil.removeCachedPropFile("PathRemoting.properties");
 	 //440134 Translation Keys with Non Case Sensitivity BLME Issue
 	 //Reset the DB case sensitivity flag
 	 if(ConstantsCommon.DB_CASE_SENSITIVITY != null)
 	 {
 	     synchronized(ConstantsCommon.DB_CASE_SENSITIVITY)
 	     {
 		 ConstantsCommon.DB_CASE_SENSITIVITY = BigDecimal.TEN;
 	     }
 	 }
 	 //TP#456163 to prevent infinite loop if called from a clustered environment then do not call the clearClusterCache() method
 	 if (!ConstantsCommon.TRUE.equals(isClusterCall))
 	 {
 	     clearClusterCache(cacheSuccess, cacheFail);
 	     if (sessCO == null || !StringUtil.isNotEmpty(sessCO.getCurrentAppName()))
 	     {
 		 return ERROR_ACTION;
 	     }
 	     /**
 	      * TP 820336 call Audit on Successfull Clear Cache
 	      */
 	     //Create Object AuditRefCO & Initialization
 	     AuditRefCO cacheAuditRefCO = new AuditRefCO();
 	     cacheAuditRefCO.setAppName(appName);
 	     cacheAuditRefCO.setProgRef(ConstantsCommon.TECH_DETAILS_OPT);
 	     cacheAuditRefCO.setOperationType(AuditConstant.RETRIEVE);
 	     cacheAuditRefCO.setMachineID(machineName);
 	     cacheAuditRefCO.setUserID(userID);
 	     cacheAuditRefCO.setAuditEnabled(true);
 	     //Call specificCallAudit to create and initialize AuditCO
 	     auditBO.specificCallAudit(cacheAuditRefCO,null,null);
 	 }
      }
    catch (Exception e)
    {
		handleException(e, null, null);
	}
    return "jsonSuccess";
  }
  
  /**
   * TP#456163
   * Method to clear the cache of remote instances of the application in a clustered environment
   * This method is effective when PathRemoting.global.cluster.enabled is true
   * And PathRemoting.global.cluster.physical.other.nodes contains at least 1 URL
   */
    private void clearClusterCache(String cacheSuccess, String cacheFail)
    {
	String requestUrl = "", contextPath = "", messageURL = "", msgText = "\n";
	try
	{
	    String clusterEnabled = StringUtil.nullEmptyToValue(
		    PathPropertyUtil.getPathRemotingProp("PathRemoting", "global.cluster.enabled"),
		    Boolean.FALSE.toString());
	    String physicalNodes = StringUtil.nullToEmpty(
		    PathPropertyUtil.getPathRemotingProp("PathRemoting", "global.cluster.physical.other.nodes"));
	    String[] physicalUrls = physicalNodes.trim().split(",");
	    if(ConstantsCommon.TRUE.equals(clusterEnabled) && physicalUrls.length > 0
		    && physicalUrls[0].trim().length() > 0)
	    {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		contextPath = request.getContextPath();
		contextPath = contextPath.startsWith("/") ? contextPath.substring(1) : contextPath;
		
		String urlParameters = "isClusterCall=true";
		byte[] postData = urlParameters.getBytes(ConstantsCommon.ENCODING_TYPE_UTF);
		int postDataLength = postData.length;

		// check if an instance is already running, and use it if found
		for(String singleUrl : physicalUrls)
		{
		    //#BUG 542852 redirecting clear cluster cache to unsecure method.
		    requestUrl = singleUrl.concat(contextPath).concat("/login/cache/clusterCache/ClearCache");
		    messageURL = singleUrl.concat(contextPath);
		    URL url = new URL(requestUrl);
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		    conn.setDoOutput(true);
		    conn.setRequestMethod("POST");
		    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    conn.setRequestProperty("charset", ConstantsCommon.ENCODING_TYPE_UTF);
		    conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
		    conn.setRequestProperty("Accept", "application/json");

		    DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		    wr.write(postData);
		    wr.flush();
		    wr.close();

		    if(conn.getResponseCode() == 200)
		    {
			msgText = msgText.concat(cacheSuccess).concat(" ").concat(messageURL).concat(" \n");
		    }
		    else
		    {
			msgText = msgText.concat(cacheFail).concat(" ").concat(messageURL).concat(" \n");
		    }
		    conn.disconnect();
		}
	    }
	}
	catch(Exception e)
	{
	    log.error(e, cacheFail.concat(" ").concat(messageURL));
	    msgText = msgText.concat(cacheFail).concat(" ").concat(messageURL).concat(" \n");
	}
	addActionError(msgText);
	welcMsg = msgText;
    }
  
  /**
   * Login Alert Implementation TP#297149
   * This function is a common function used to apply settings needed when alert should be enabled for the current user
   * @throws BaseException
   */
  private void enableUserAlert(SessionCO sessionCO) throws BaseException
  {
      	isAlertEnabled = Boolean.TRUE.toString();
	userId = new String(sessionCO.getUserName());
	// update the NEXT_PUSH_DATE to the DB sysdate and reset the
	// DEFAULT_REFRESH_TIME, pass the application name in parameters
	alertsEngineBO.updateUserDefaultRefreshTime(userId,sessionCO.getCurrentAppName());

	// Escape single quote character to avoid js error
	userId = userId.replace("'", "\\'");
  }
  
  /**
   * Login Alert Implementation TP#297149
   * This function is a common function used to apply settings needed when login alert should be enabled for the current user
   * @throws BaseException
   */
  private void enableUserLoginAlert(SessionCO sessionCO) throws BaseException
  {
	  // TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
	  // if ALERT_LOGIN_APPROVAL_FLAG equal 1, then the user already get login approval from manager
	  if(!session.containsKey(AlertsConstants.ALERT_LOGIN_APPROVAL_FLAG) || !session.get(AlertsConstants.ALERT_LOGIN_APPROVAL_FLAG).equals(ConstantsCommon.ONE)) 
	  {
		  session.put(AlertsConstants.ALERT_LOGIN_APPROVAL_FLAG, ConstantsCommon.ZERO);
	  }
	  
      UsrSC userSC = new UsrSC();
      userSC.setAppName(sessionCO.getCurrentAppName());
      userSC.setCompCode(sessionCO.getCompanyCode());
      userSC.setBranchCode(sessionCO.getBranchCode());
      userSC.setPreferredLanguage(sessionCO.getLanguage());
      userSC.setUser_id(sessionCO.getUserName());
      userSC.setUser_grp_id(sessionCO.getUserFirstName());
      userSC.setUser_grp_desc(sessionCO.getUserLastName());
      AlertsParamCO alertsParamCO = loginBO.returnLoginAlertsParam(userSC);
      if(alertsParamCO != null)
      {
	  try
	  {
	      loginAlertParamCO = PathJSONUtil.strutsJsonSerialize(alertsParamCO, null, null, false, true);
	  }
	  catch (JSONException e) 
	  {
	      loginAlertParamCO = null;
	      log.error(e,"DesktopAction.enableUserLoginAlert : error in the serialize of alertsParamCO");
	      throw new BaseException(e);
	  }
      }
      
  }
  
  /**
   * This function is only called to check if alertsEngine is enabled
   * and to initalize alerts properties
   * @throws BaseException
   */
  public void checkAlertsEnabled() throws BaseException
  {
       SessionCO sessionCO = returnSessionObject();
       isAlertEnabled = Boolean.FALSE.toString();
       isLoginAlertEnabled = Boolean.FALSE.toString();
       isFinalSignOff = Boolean.FALSE.toString();
       
	// Check if alerts is enabled
        // in case the flag alert.enabled is set to false in pathRemoting.properties then the alert or login alert should be disabled.
	if(alertsEngineBO.isAlertsEnabled(sessionCO.getCurrentAppName()))
	{
	    // All users in RET are tellers, check the function
	    // fillRetailDetails(SessionCO sessionCO)
	    List<String> appNameList = new ArrayList<String>();
		
	    //initialize the application names to check if the alert request should be started 
	    if(alertsAppName != null && !alertsAppName.trim().isEmpty())
	    {
		appNameList = Arrays.asList(alertsAppName.trim().replaceAll(" ", "").split(","));
	    }
	    
	    if(appNameList != null && !appNameList.isEmpty() && appNameList.contains(sessionCO.getCurrentAppName()))
	    {
		enableUserAlert(sessionCO);
	    }
	    
	    CommonLibSC commonLibSC = new CommonLibSC();
		commonLibSC.setUserId(sessionCO.getUserName());
		commonLibSC.setCurrAppName(sessionCO.getCurrentAppName());
		commonLibSC.setFinalSignOff(sessionCO.isFinalSignOff());
		commonLibSC.setCompanyCode(sessionCO.getCompanyCode());
		commonLibSC.setBranchCode(sessionCO.getBranchCode());
		commonLibSC.setHostName(sessionCO.getMachineIp());
		commonLibSC.setHttpSessionId(sessionCO.getHttpSessionID());
		if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()) 
				&& loginBO.checkLoginAlertEnabled(commonLibSC, true))
		{
			isFinalSignOff = Boolean.TRUE.toString();
		}
		
		if(isFinalSignOff.equals(Boolean.TRUE.toString())) 
		{
			if(!Boolean.valueOf(isAlertEnabled))
			{
				enableUserAlert(sessionCO);
			}
			session.put(AlertsConstants.ALERT_LOGIN_AFTER_FINAL_SIGNOFF_FLAG, ConstantsCommon.ONE);
			enableUserLoginAlert(sessionCO);
		}
		else
		{
			/* Login Alert Implementation TP#297149 */
			//check if login alert is enabled. in case of isAlertEnabled == true, no need to check.
			PTH_CTRLVO pthCtrlvo = returnCommonLibBO().returnPthCtrl();
			if(pthCtrlvo != null && ConstantsCommon.ONE.equals(pthCtrlvo.getENABLE_ALRT_ON_USER_LOGIN_YN()))
			{
				if(!Boolean.valueOf(isAlertEnabled))
				{
					//Login alert implementation : in case the current login user is has subordinates
					//then the isAlertEnabled should be enabled to be able to receive login alerts requests
					UsrSC usrSC = new UsrSC();
					usrSC.setUser_id(sessionCO.getUserName());
					usrSC = loginBO.returnLoginAlertSubUserCount(usrSC);    
					if(usrSC != null && usrSC.getSubordinate_count() > 0)
					{
						enableUserAlert(sessionCO);
					}
				}
				
				CommonLibSC comLibSC = new CommonLibSC();
				comLibSC.setUserId(sessionCO.getUserName());
				comLibSC.setFinalSignOff(sessionCO.isFinalSignOff());
				//TODO check if we can put in session the result of the loginBO.checkLoginAlertEnabled() already called in LoginBOImpl 
				boolean loginAlertEnabled = loginBO.checkLoginAlertEnabled(comLibSC, false);
				if(loginAlertEnabled)
				{
					isLoginAlertEnabled = Boolean.TRUE.toString();
					enableUserLoginAlert(sessionCO);
				}
			}
		}
	    
	}
  }
  /**
   * used to re-fill the session information after clik on 'NO' button 
   * in Force logout process in case is opened from dialog (landing page \ switch branch or company)
   * @author marwanmaddah
   * @date   Oct 16, 2014 void
   *
   */
    public void refillOldSessionInfo()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    sessionCO.setCompanyCode(prevCompCode);
	    sessionCO.setCompanyName(prevCompDesc);
	    sessionCO.setBranchCode(prevBranchCode);
	    sessionCO.setBranchName(prevBranchDesc);
	    sessionCO.setHttpSessionID(prevHttpSessionId);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
    }
    public String returnExternalUrls()
    {
	SessionCO sessCO = returnSessionObject();
	setLoggedInUserName(sessCO.getUserName());
	externalOpenedUrls = new ArrayList<String>();
	if(sessCO.getExternalOpenedUrls() != null)
	{
	    externalOpenedUrls.addAll(sessCO.getExternalOpenedUrls());
	}
	return "SUCCESS_JSON";
    }
    
    public String loadIframeScreen()
    {
	try
	{
	    destinationAppUrl = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties", "app."+appName+".url");
	    SessionCO sessCO = returnSessionObject();
	    if(sessCO.getExternalOpenedUrls() == null)
	    {
		sessCO.setExternalOpenedUrls(new ArrayList<String>()); 
	    }
	    //adding url to be logged out from upon logout of main application
	    sessCO.getExternalOpenedUrls().add(destinationAppUrl);
	}
	catch(Exception e)
	{
	    handleException(e, null,null);
	}
	return SUCCESS;
    }
    
    /**
     * This function is called from ErrorPageRedirect.jsp to handle the 404 Error Code generated when calling an invalid action url from the menu.
     * It will redirect to ErrorAction.jsp
     * @return
     */
    public String redirectToErrorAction()
    {
	try
	{
	    HttpSession session = ServletActionContext.getRequest().getSession();
	    //get the requestUrl from session and then remove it from the session
	    String requestUrl = (String) session.getAttribute("PathRequestUrl");
	    session.removeAttribute("PathRequestUrl");
	    String errorMessage = "Invalid URL : ".concat(StringUtil.nullToEmpty(requestUrl));
	    
	    //In case the AlertsAjaxServlet is not defined in web.xml and the alert.enabled is set to true in pathRemoting,
	    //the alert polling will make an infinite loop of HTTP polling requests, in amq.js : the messageHandler will fail while parsing
	    //the XML that contains the errorMessage ["Invalid URL : " + StringUtil.nullToEmpty(requestUrl);] and will generate another polling request infinitely. 
	    //The solution is to generate a 600 internal error in this case,so the polling will stop when reaching the errorHandler() in amq.js.
	    if(StringUtil.isNotEmpty(requestUrl) && requestUrl.endsWith("/path/AlertsAjaxServlet"))
	    {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setStatus(ConstantsCommon.PATHSOL_INTERNAL_ERROR); 
		errorMessage = "AlertsAjaxServlet Error - ".concat(errorMessage);
	    }
	    
	    //add the message that indicate the wrong url
	    addActionError(errorMessage);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return ERROR_ACTION;
    }
  
   /**
   * Used for common external screen opening feature
   */
    public String commonDecoration()
    {
	return SUCCESS;
    }
    

    /**
     * 
     * Used for checking user privileges for Setting default printer
     *
     */
    protected String checkDefPrntAxs() throws BaseException
     {
	return returnAccessRightByProgRef(ConstantsCommon.DEFAULT_PRINTER_AXS);
     }
    
    /**
     * used to reset to 0 the column AXS_CHANGED_YN in S_APPLOG after changing the access rights of the user from SADS
     * @throws BaseException
     */
    public String resetUserAxsChange() throws BaseException
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    S_APPLOGVO sAppLogVO = new S_APPLOGVO();
	    sAppLogVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    sAppLogVO.setBRANCH_CODE(sessionCO.getBranchCode());
	    sAppLogVO.setAPP_NAME(sessionCO.getCurrentAppName());
	    sAppLogVO.setUSER_ID(sessionCO.getUserName());
	    /**
	     * [MarwanMaddah]:514057 - 'set user preferences' button exist even there is no access
	     * on access right change(from SADS) will clean the userAxsMap to refresh the access right privileges 
	     */
	    sessionCO.setUserAxsMap(null);
	    /**
	     * 
	     */
	    returnCommonLibBO().resetUserAxsChange(sAppLogVO);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "jsonSuccess";
    }

    /**
     * 
     * Used for opening Main Screen of IFRS Application
     * 
     * @return
     */
    public String ifrsPortal()
    {
	try
	{
	    themeName = CORE_THEME;
	    fillCommonDetails();
	    return ifrsCustomerRet;
	}
	catch(Exception e)
	{
	    log.error(e, "Error in ifrsPortal method in DesktopAction");
	    addActionError(e.getMessage());
	    return ERROR;
	}
    }
    /**
     * Profitability portal //TP 872828 786289
     */
    public String profPortal()
    {
	try
	{
	    themeName = CORE_THEME;
	    fillCommonDetails();
	    return profCustomerRet;
	}
	catch(Exception e)
	{
	    log.error(e, "Error in profitabilityPortal method in DesktopAction");
	    addActionError(e.getMessage());
	    return ERROR;
	}
    }
    /**
     * Risk Control Self Assessment Module
     * @return
     */
    public String rcsaPortal()
    {
	try
	{
	    themeName = CORE_THEME;
	    fillCommonDetails();
	    return rcsaCustomerRet;
	}
	catch(Exception e)
	{
	    log.error(e, "Error in rcsaPortal method in DesktopAction");
	    addActionError(e.getMessage());
	    return ERROR;
	}
    }
    /**
     * Open Api Module opening
     * @return
     */
    public String openAPIPortal()
    {
	try
	{
	    themeName = OPEN_API_THEME;
	    fillCommonDetails();
	    return openAPICustomer;
	}
	catch(Exception e)
	{
	    log.error(e, "Error in openAPI method in DesktopAction");
	    addActionError(e.getMessage());
	    return ERROR;
	}
    }
    /**
     * AML Module 
     * @return
     */
    public String amlPortal()
    {
	try
	{
	    themeName = CORE_THEME;
	    fillCommonDetails();
	    return amlCustomerRet;
	}
	catch(Exception e)
	{
	    log.error(e, "Error in amlPortal method in DesktopAction");
	    addActionError(e.getMessage());
	    return ERROR;
	}
    }
    /**
     * Assets PArams Module TP 984569
     */
    public String pmspPortal()
    {
	try
	{
	    themeName = CORE_THEME;
	    fillCommonDetails();
	    return pmspCustomerRet;
	}
	catch(Exception e)
	{
	    log.error(e, "Error in pmspPortal method in DesktopAction");
	    addActionError(e.getMessage());
	    return ERROR;
	}
    }



    /**
     * method used to invalidate session upon timeout from browser after idle timeout reached without moving the mouse on the borwser
     */
    public String invalidateSession()
    {
	HttpSession httpSession = ServletActionContext.getRequest().getSession();
	try
	{
	    /**
	     * [MarwanMaddah]:
	     * TP: 624152 - RIDB180069 - User not logged off when screen time-out
	     * we added the removeAlertClient to remove the alert before invalidate session 
	     * to avoid the case that faced , where process is not enter in destroy session management after invalidate 
	     * in case the alert engine is active
	     * we faced this issue 
	     */
	    SessionCO sessCO = returnSessionObject();
	    String sessionId = sessCO.getHttpSessionID();
	    log.debug("invalidateSession ******** SessionId="+sessionId);
	    AlertsCommonMethods.removeAlertClient(sessCO.getCurrentAppName(), AlertsCommonMethods.returnUsrCompBrKey(sessCO), sessCO.getUserName(),sessCO.getHttpSessionID());
	}
	catch(Exception ex)
	{
	    log.error("invalidate Session, error in remove alert client management");
	}
	// TP 863160 DBU190982,DBU190992, issue in session timeout not been redirected to login page and causing lot of issues while reading 
	SecurityContextHolder.clearContext();
	httpSession.invalidate();
	return "jsonSuccess";
    }
    
    public String getIsRTL()
    {
	return isRTL;
    }

    public void setIsRTL(String isRTL)
    {
        this.isRTL = isRTL;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getMenuVar()
    {
	return menuVar;
    }

    public void setMenuVar(String menuVar)
    {
	this.menuVar = menuVar;
    }

    public String getThemeName()
    {
	return themeName;
    }

    public COMPANIESVO getCompaniesVO()
    {
	return companiesVO;
    }

    public void setCompaniesVO(COMPANIESVO companiesVO)
    {
	this.companiesVO = companiesVO;
    }

    public BRANCHESVO getBranchesVO()
    {
	return branchesVO;
    }

    public void setBranchesVO(BRANCHESVO branchesVO)
    {
	this.branchesVO = branchesVO;
    }

    public String getCurrentURL()
    {
	return currentURL;
    }

    public String getReadOnlyProp()
    {
	return readOnlyProp;
    }

    public void setReadOnlyProp(String readOnlyProp)
    {
	this.readOnlyProp = readOnlyProp;
    }

    public void setCompaniesBO(CompaniesBO companiesBO)
    {
	this.companiesBO = companiesBO;
    }
	    
    public String getHeaderDecorator()
    {
	return headerDecorator;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setLoginBO(LoginBO loginBO)
    {
	this.loginBO = loginBO;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public List getLanguages()
    {
	return languages;
    }

    public String getWelcMsg()
    {
        return welcMsg;
    }

    public void setAlertsEngineBO(AlertsEngineBO alertsEngineBO)
    {
        this.alertsEngineBO = alertsEngineBO;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getIsAlertEnabled()
    {
        return isAlertEnabled;
    }

    public void setIsAlertEnabled(String isAlertEnabled)
    {
        this.isAlertEnabled = isAlertEnabled;
    }

    public Date getNewUserRunDate()
    {
        return newUserRunDate;
    }

    public void setNewUserRunDate(Date newUserRunDate)
    {
        this.newUserRunDate = newUserRunDate;
    }
    
    public Date getNewAppRunDate()
    {
        return newAppRunDate;
    }

    public void setNewAppRunDate(Date newAppRunDate)
    {
        this.newAppRunDate = newAppRunDate;
    }

    public String getNewFrmtUserRunDate()
    {
        return newFrmtUserRunDate;
    }

    public void setNewFrmtUserRunDate(String newFrmtUserRunDate)
    {
        this.newFrmtUserRunDate = newFrmtUserRunDate;
    }
    
    public String getNewFrmtAppRunDate()
    {
        return newFrmtAppRunDate;
    }

    public void setNewFrmtAppRunDate(String newFrmtAppRunDate)
    {
        this.newFrmtAppRunDate = newFrmtAppRunDate;
    }

    public String getHomeURL()
    {
        return homeURL;
    }

    public String getAlertsAppName()
    {
        return alertsAppName;
    }

    public void setAlertsAppName(String alertsAppName)
    {
        this.alertsAppName = alertsAppName;
    }

    /**
     * @return the usrSettingRight
     */
    public String getUsrSettingRight()
    {
        return usrSettingRight;
    }

    /**
     * @param usrSettingRight the usrSettingRight to set
     */
    public void setUsrSettingRight(String usrSettingRight)
    {
        this.usrSettingRight = usrSettingRight;
    }

    public String getUserRunningDateOPT()
    {
        return userRunningDateOPT;
    }

    public void setUserRunningDateOPT(String userRunningDateOPT)
    {
        this.userRunningDateOPT = userRunningDateOPT;
    }

    public String getAppRunningDateOPT()
    {
        return appRunningDateOPT;
    }

    public void setAppRunningDateOPT(String appRunningDateOPT)
    {
        this.appRunningDateOPT = appRunningDateOPT;
    }

    public String getUsrLabelRight()
    {
        return usrLabelRight;
    }

    public void setUsrLabelRight(String usrLabelRight)
    {
        this.usrLabelRight = usrLabelRight;
    }

    public int getLangCount()
    {
        return langCount;
    }

    public void setLangCount(int langCount)
    {
        this.langCount = langCount;
    }

    public void setCurrentURL(String currentURL)
    {
        this.currentURL = currentURL;
    }
    public String getSwitchViewRight()
    {
        return switchViewRight;
    }

    public void setSwitchViewRight(String switchViewRight)
    {
        this.switchViewRight = switchViewRight;
    }
    
    /**
     * @return the openInDialog
     */
    public Boolean getOpenInDialog()
    {
        return openInDialog;
    }

    /**
     * @param openInDialog the openInDialog to set
     */
    public void setOpenInDialog(Boolean openInDialog)
    {
        this.openInDialog = openInDialog;
    }
    public String getUsrSaveAsRight()
    {
        return usrSaveAsRight;
    }

    public void setUsrSaveAsRight(String usrSaveAsRight)
    {
        this.usrSaveAsRight = usrSaveAsRight;
    }

    public String getOriginalAppUrl()
    {
        return originalAppUrl;
    }

    public void setOriginalAppUrl(String originalAppUrl)
    {
        this.originalAppUrl = originalAppUrl;
    }

    public String getTargetAppScreenUrl()
    {
        return targetAppScreenUrl;
    }

    public void setTargetAppScreenUrl(String targetAppScreenUrl)
    {
        this.targetAppScreenUrl = targetAppScreenUrl;
    }

    public Date getNewRunningDate()
    {
        return newRunningDate;
    }

    public void setNewRunningDate(Date newRunningDate)
    {
        this.newRunningDate = newRunningDate;
    }

    public String getExternalScreen()
    {
        return externalScreen;
    }

    public void setExternalScreen(String externalScreen)
    {
        this.externalScreen = externalScreen;
    }

    public String getOriginalProgRef()
    {
        return originalProgRef;
    }

    public void setOriginalProgRef(String originalProgRef)
    {
        this.originalProgRef = originalProgRef;
    }

    /**
     * @return the newSessionRight
     */
    public String getNewSessionRight()
    {
        return newSessionRight;
    }

    /**
     * @param newSessionRight the newSessionRight to set
     */
    public void setNewSessionRight(String newSessionRight)
    {
        this.newSessionRight = newSessionRight;
    }

    /**
     * @return the switchBranch
     */
    public Boolean getSwitchBranch()
    {
        return switchBranch;
    }

    /**
     * @param switchBranch the switchBranch to set
     */
    public void setSwitchBranch(Boolean switchBranch)
    {
        this.switchBranch = switchBranch;
    }

    public List<String> getExternalOpenedUrls()
    {
        return externalOpenedUrls;
    }

    public void setExternalOpenedUrls(List<String> externalOpenedUrls)
    {
        this.externalOpenedUrls = externalOpenedUrls;
    }

    public String getLoggedInUserName()
    {
        return loggedInUserName;
    }

    public void setLoggedInUserName(String loggedInUserName)
    {
        this.loggedInUserName = loggedInUserName;
    }

    public String getDestinationScreenUrl()
    {
        return destinationScreenUrl;
    }

    public void setDestinationUrl(String destinationScreenUrl)
    {
        this.destinationScreenUrl = destinationScreenUrl;
    }

    public String getDestinationProgRef()
    {
        return destinationProgRef;
    }

    public void setDestinationProgRef(String destinationProgRef)
    {
        this.destinationProgRef = destinationProgRef;
    }

    public String getAdditionalParams()
    {
        return additionalParams;
    }

    public void setAdditionalParams(String additionalParams)
    {
        this.additionalParams = additionalParams;
    }

    public String getDestinationAppUrl()
    {
        return destinationAppUrl;
    }

    public void setDestinationAppUrl(String destinationAppUrl)
    {
        this.destinationAppUrl = destinationAppUrl;
    }
   
   
    /**
     * @return the overrideSession
     */
    public String getOverrideSession()
    {
        return overrideSession;
    }

    /**
     * @param overrideSession the overrideSession to set
     */
    public void setOverrideSession(String overrideSession)
    {
        this.overrideSession = overrideSession;
    }

    /**
     * @return the inputStream
     */
    public InputStream getInputStream()
    {
        return inputStream;
    }

    /**
     * @param inputStream the inputStream to set
     */
    public void setInputStream(InputStream inputStream)
    {
        this.inputStream = inputStream;
    }

    /**
     * @return the prevCompDesc
     */
    public String getPrevCompDesc()
    {
        return prevCompDesc;
    }

    /**
     * @param prevCompDesc the prevCompDesc to set
     */
    public void setPrevCompDesc(String prevCompDesc)
    {
        this.prevCompDesc = prevCompDesc;
    }

    /**
     * @return the prevBranchDesc
     */
    public String getPrevBranchDesc()
    {
        return prevBranchDesc;
    }

    /**
     * @param prevBranchDesc the prevBranchDesc to set
     */
    public void setPrevBranchDesc(String prevBranchDesc)
    {
        this.prevBranchDesc = prevBranchDesc;
    }

    /**
     * @return the prevHttpSessionId
     */
    public String getPrevHttpSessionId()
    {
        return prevHttpSessionId;
    }

    /**
     * @param prevHttpSessionId the prevHttpSessionId to set
     */
    public void setPrevHttpSessionId(String prevHttpSessionId)
    {
        this.prevHttpSessionId = prevHttpSessionId;
    }

    /**
     * @return the prevCompCode
     */
    public BigDecimal getPrevCompCode()
    {
        return prevCompCode;
    }

    /**
     * @param prevCompCode the prevCompCode to set
     */
    public void setPrevCompCode(BigDecimal prevCompCode)
    {
        this.prevCompCode = prevCompCode;
    }

    /**
     * @return the prevBranchCode
     */
    public BigDecimal getPrevBranchCode()
    {
        return prevBranchCode;
    }

    /**
     * @param prevBranchCode the prevBranchCode to set
     */
    public void setPrevBranchCode(BigDecimal prevBranchCode)
    {
        this.prevBranchCode = prevBranchCode;
    }

    public String getUsrPrntAxsRight()
    {
        return usrPrntAxsRight;
    }

    public void setUsrPrntAxsRight(String usrPrntAxsRight)
    {
        this.usrPrntAxsRight = usrPrntAxsRight;
    }

    public String getScreenTitle()
    {
        return screenTitle;
    }

    public void setScreenTitle(String screenTitle)
    {
        this.screenTitle = screenTitle;
    }
    public String getTechDetailsRight()
    {
        return techDetailsRight;
    }

    public void setTechDetailsRight(String techDetailsRight)
    {
        this.techDetailsRight = techDetailsRight;
    }
    /**
     * @return the usrThemeRight
     */
    public String getUsrThemeRight()
    {
        return usrThemeRight;
    }

    public String getUsrBtnCustRight()
    {
        return usrBtnCustRight;
    }

    public void setUsrBtnCustRight(String usrBtnCustRight)
    {
        this.usrBtnCustRight = usrBtnCustRight;
    }

    /**
     * @param usrThemeRight the usrThemeRight to set
     */
    public void setUsrThemeRight(String usrThemeRight)
    {
        this.usrThemeRight = usrThemeRight;
    }

    public String getIsLoginAlertEnabled()
    {
        return isLoginAlertEnabled;
    }

    public void setIsLoginAlertEnabled(String isLoginAlertEnabled)
    {
        this.isLoginAlertEnabled = isLoginAlertEnabled;
    }

    public String getLoginAlertParamCO()
    {
        return loginAlertParamCO;
    }

    public void setLoginAlertParamCO(String loginAlertParamCO)
    {
        this.loginAlertParamCO = loginAlertParamCO;
    }

    public String getPwdToken()
    {
        return pwdToken;
    }

    public void setPwdToken(String pwdToken)
    {
        this.pwdToken = pwdToken;
    }

    /**
     * @return the enableItrRunningDate
     */
    public String getEnableItrRunningDate()
    {
        return enableItrRunningDate;
    }

    /**
     * @param enableItrRunningDate the enableItrRunningDate to set
     */
    public void setEnableItrRunningDate(String enableItrRunningDate)
    {
        this.enableItrRunningDate = enableItrRunningDate;
    }
    public String getDynClntPrmsEditRight()
    {
        return dynClntPrmsEditRight;
    }

    public void setDynClntPrmsEditRight(String dynClntPrmsEditRight)
    {
        this.dynClntPrmsEditRight = dynClntPrmsEditRight;
    }

    public String getDynClntPrmsApproveRight()
    {
        return dynClntPrmsApproveRight;
    }

    public void setDynClntPrmsApproveRight(String dynClntPrmsApproveRight)
    {
        this.dynClntPrmsApproveRight = dynClntPrmsApproveRight;
    }

    public String getTechLogsRight()
    {
        return techLogsRight;
    }

    public void setTechLogsRight(String techLogsRight)
    {
        this.techLogsRight = techLogsRight;
    }

    public String getDynClntPrmsColsEditRight()
    {
        return dynClntPrmsColsEditRight;
    }

    public void setDynClntPrmsColsEditRight(String dynClntPrmsColsEditRight)
    {
        this.dynClntPrmsColsEditRight = dynClntPrmsColsEditRight;
    }

    public String getAppId()
    {
        return appId;
    }

    public void setAppId(String appId)
    {
        this.appId = appId;
    }

    public String getFavoriteId()
    {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId)
    {
        this.favoriteId = favoriteId;
    }

    public void setDestinationScreenUrl(String destinationScreenUrl)
    {
        this.destinationScreenUrl = destinationScreenUrl;
    }

    public void setSecureFilter(PathCustomAuthenticationFilter secureFilter)
    {
        this.secureFilter = secureFilter;
    }

    public String getIsClusterEnabled()
    {
        return isClusterEnabled;
    }

    public String getGlobalActivitiesRight()
    {
        return globalActivitiesRight;
    }

    /**
     * @return the dynScrGenRight
     */
    public String getDynScrGenRight()
    {
        return dynScrGenRight;
    }

    /**
     * @param dynScrGenRight the dynScrGenRight to set
     */
    public void setDynScrGenRight(String dynScrGenRight)
    {
        this.dynScrGenRight = dynScrGenRight;
    }
    
//    public String getUsrAllowDisableCustomization()
//    {
//        return usrAllowDisableCustomization;
//    }
//
//    public void setUsrAllowDisableCustomization(String usrAllowDisableCustomization)
//    {
//        this.usrAllowDisableCustomization = usrAllowDisableCustomization;
//    }

	public void setIsClusterCall(String isClusterCall) {
		this.isClusterCall = isClusterCall;
	}

	public String getLoadFunc()
	{
	    return loadFunc;
	}

	public void setLoadFunc(String loadFunc)
	{
	    this.loadFunc = loadFunc;
	}

	public String getFinalSignOffOption()
	{
	    return finalSignOffOption;
	}

	public void setFinalSignOffOption(String finalSignOffOption)
	{
	    this.finalSignOffOption = finalSignOffOption;
	}

	public String getIsArbMnthEng()
	{
	    return isArbMnthEng;
	}
	
    public void setIsArbMnthEng(String isArbMnthEng) 
    {
	this.isArbMnthEng = isArbMnthEng;
    }

    public String getUsrActvXSelectdPrntr()
    {
	return usrActvXSelectdPrntr;
    }

    public void setUsrActvXSelectdPrntr(String usrActvXSelectdPrntr)
    {
	this.usrActvXSelectdPrntr = usrActvXSelectdPrntr;
    }

    public String getPrintReportAsPDF()
    {
        return printReportAsPDF;
    }

    public void setPrintReportAsPDF(String printReportAsPDF)
    {
        this.printReportAsPDF = printReportAsPDF;
    }

	public String getIsNotificationEnabled() 
	{
		return isNotificationEnabled;
	}
	
	public String getIsFinalSignOff() 
	{
		return isFinalSignOff;
	}

	public void setIsFinalSignOff(String isFinalSignOff) 
	{
		this.isFinalSignOff = isFinalSignOff;
	}
	
}
