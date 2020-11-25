package com.path.actions.common.dashboard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.path.actions.common.login.DesktopAction;
import com.path.bo.admin.user.UsrBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.dashboardportal.DashboardPortalBO;
import com.path.dbmaps.vo.EMP_PHOTOSVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.SYS_PARAM_PORTLET_TYPEVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.dbmaps.vo.USER_PORTLETSVO;
import com.path.dbmaps.vo.USRVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.user.UsrCO;
import com.path.vo.admin.user.UsrSC;
import com.path.vo.common.ActiveTransCO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.PasswordChangeCO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dashboardportal.DashboardPortalSC;
import com.path.vo.common.dashboardportal.DashboardVO;
import com.path.vo.common.dashboardportal.WidgetVO;
import com.path.vo.core.ctsteller.CTSTELLERSC;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class PortalDashboardAction extends DesktopAction
{
    private DashboardVO dashboardVO;
    private List<WidgetVO> widgetList = new ArrayList<WidgetVO>();
    private DashboardPortalBO dashboardPortalBO;
    private UsrBO usrBO;
    private String userPortalUpdates;

    private SYS_PARAM_PORTLET_TYPEVO theVO = new SYS_PARAM_PORTLET_TYPEVO();
    private WidgetVO widgetVO = new WidgetVO();
    private ActiveTransCO activeTransCO = new ActiveTransCO();
    private String usrSideBarRight;
    private String homeURL;
    private String showHeaderOptions;
    private String captchaEnabled;
    private String captchUserText;
    private String captchaText;
    private String showMgrOptions;
    private String finalSignOffOption;
    private String emptyDash;
    private String dynScrGenRight;
    private String usrSetAsDefaultPageRight;//Access rights to show the Set As Default Page checkbox in layout options

    private String     newPwd;
    private String     confirmPwd;
    private String     oldPwd;
    private String     cifFetch;
    private String     defaultDisplayPage;
    private String     newSessionRight;
    private Boolean    switchBranch;
    private String     profType;
    private String     chooseDashLayoutKey;
    
    private BigDecimal reportId;
    private String     reportProgRef;
    private String     reportDesc;
    private BigDecimal urlType;
    
    private String  appName;
    private String  appDesc;
    private Boolean exceptionConfirmed;
    private String usrAllwdPrtltRight;
    private String fromForceLogout;
    private String forceClosureAccess;
    private BigDecimal noActiveTrx;
    
    private static final String PATH_REMOTING         = "PathRemoting";
    private static final String REP_COMMON_URL_PARAMS = "reports.commonParamsUrl";
    private static final String REP_COMMON_URL_DIRECT = "reports.commonDirectUrl";
    private List<String> marqueeMessages = new ArrayList<String>(); //List of the marquee messages
    private String contentMessage;
    
    @Override
    public Object getModel()
    {
	return theVO;
    }

    public DashboardVO getDashboardVO()
    {
	return dashboardVO;
    }

    public void setDashboardVO(DashboardVO dashboardVO)
    {
	this.dashboardVO = dashboardVO;
    }

    @Override
    public String execute()
    {
	try
	{	
	   /**
	    * [MarwanMaddah]
	    * #BUG481199 switch company error
	    * to be used in case of F5 click on forcelogout screen inside switch process
	    */
	    SessionCO sessionCO = returnSessionObject();
	    
	    if(StringUtil.isEmptyString(appName)) 
	    {
	    	appName = sessionCO.getCurrentAppName();
	    }
	    
	    if(sessionCO.getCompanyCode() == null && sessionCO.getBranchCode() == null
		    && StringUtil.nullToEmpty(sessionCO.getHttpSessionID()).isEmpty())
	    {

		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		if(httpSession.getAttribute("prevCompCode") != null
			&& httpSession.getAttribute("prevBranchCode") != null
			&& httpSession.getAttribute("prevHttpSessionId") != null)
		{
		    sessionCO.setBranchCode((BigDecimal) httpSession.getAttribute("prevBranchCode"));
		    sessionCO.setCompanyCode((BigDecimal) httpSession.getAttribute("prevCompCode"));
		    sessionCO.setCompanyName((String) httpSession.getAttribute("prevCompDesc"));
		    sessionCO.setBranchName((String) httpSession.getAttribute("prevBranchDesc"));
		    sessionCO.setHttpSessionID((String) httpSession.getAttribute("prevHttpSessionId"));
		    session.put(ConstantsCommon.SESSION_VO_ATTR, sessionCO);
		    httpSession.removeAttribute("prevCompCode");
		    httpSession.removeAttribute("prevBranchCode");
		    httpSession.removeAttribute("prevCompDesc");
		    httpSession.removeAttribute("prevBranchDesc");
		    httpSession.removeAttribute("prevHttpSessionId");
		}

	    }
	
	/**
	 * check access rights on new Session
	 */
	newSessionRight = returnAccessRightByProgRef(ConstantsCommon.NEW_SESSION_OPT);
	
	if(!ConstantsCommon.IBIS_APP_NAME.equals(returnSessionObject().getCurrentAppName()))
	{
	    // to show up the "New Session" Dialog on upon Switch to Dashboard and when having access rights
	    String newSes = (String) session.get("newSession");
	    if(newSes == null && newSessionRight != null)
	    {
		cifFetch = "1";// set to one in order to open the dialog upon dashboard load
		session.put("newSession", "1");
	    }
	}


	dashboardVO = new DashboardVO();
	// url to read the dashboard content by user
	dashboardVO.setJson_data("/pathdesktop/dashboardJsonWidget");

	String reposURL = FileUtil.getFileURLByName("repository");
	    fillMarqueeMessages();
	    applyDirection();
	    fillOtherCommonParams();
	    
	    if(ConstantsCommon.IBIS_APP_NAME.equals(returnSessionObject().getCurrentAppName()))
	    {
		/**
		 * [MarwanMaddah]#BUG 514625 - BMOUPI170044 - Home page error at Dashboard
		 * removed the '/' because it is added inside LoginInfoActions.jsp
		 */		
		homeURL = "pathdesktop/dashboard.action";
	    }

	    // apply access right on widget list side bar + delete option + workspace Customize option
	    
	    SessionCO session = returnSessionObject();
	    String currAppName = session.getCurrentAppName();
	    String[] opts = { ConstantsCommon.DASH_WKSPCE_WIDGET_CUST_OPT, ConstantsCommon.DASH_PORTAL_WIDGET_LIST_OPT,
		    ConstantsCommon.DASH_ASSGN_USR_WIDGET_OPT };
	    
	    HashMap<String, String> accessOpts = returnAccessRightByProgRef(opts, currAppName);

	    String wkspceCustRight = accessOpts.get(ConstantsCommon.DASH_WKSPCE_WIDGET_CUST_OPT+"_"+currAppName);
	    usrSideBarRight = accessOpts.get(ConstantsCommon.DASH_PORTAL_WIDGET_LIST_OPT+"_"+currAppName);
	    String wdgtAssignRight = accessOpts.get(ConstantsCommon.DASH_ASSGN_USR_WIDGET_OPT+"_"+currAppName);
	    
	    dashboardVO.setWkspceCustRight(StringUtil.nullEmptyToValue(wkspceCustRight, "0"));
	    dashboardVO.setWdgtAssignRight(StringUtil.nullEmptyToValue(wdgtAssignRight, "0"));
	    
	    dashboardVO.setMaximize(getText(ConstantsCommon.MAXIMIZE_KEY));
	    dashboardVO.setMinimize(getText(ConstantsCommon.MINIMIZE_KEY));
	    dashboardVO.setDel(getText(ConstantsCommon.DELETE_KEY));
	    dashboardVO.setAssign_key_trans(getText(ConstantsCommon.ASSIGN_KEY));
	    dashboardVO.setCustomize_key_trans(getText(ConstantsCommon.CUSTOMIZE_KEY));
	    dashboardVO.setResize_key_trans(getText(ConstantsCommon.RESIZE_KEY));
	    dashboardVO.setRefresh(getText(ConstantsCommon.REFRESH_KEY));
	    dashboardVO.setWdgtDeleteDisplay("");
	    dashboardVO.setAppVersion(ConstantsCommon.returnAppNumericVersion());
	    if(usrSideBarRight == null)
	    {
		dashboardVO.setWdgtDeleteDisplay("display:none");
	    }
	    // set access right of customize functionality workspace
	    PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
	    DashboardPortalSC dpsc = new DashboardPortalSC();
	    dpsc.setUserName(returnSessionObject().getUserName());
	    dpsc.setEnablePortletAXS(pthCtrl.getENABLE_PORTLET_AXS_YN());
	    // list of widgets that appear in the left bar to choose from
	    List lst = dashboardPortalBO.returnWidgetTypeList(dpsc);
	    WidgetVO vo;
	    for(int i = 0; i < lst.size(); i++)
	    {
		vo = new WidgetVO();
		String defaultImg = DashboardPortalConstant.NOT_AVAIL_DEFAULT_IMG;
		SYS_PARAM_PORTLET_TYPEVO portletTypeVO = (SYS_PARAM_PORTLET_TYPEVO) lst.get(i);
		// setting default image in case repository image not found
		if(DashboardPortalConstant.ALERT_PORTLET_CODE.equals(portletTypeVO.getPORTLET_CODE()))
		{
		    defaultImg = DashboardPortalConstant.ALERT_DEFAULT_IMG;
		}
		else if(DashboardPortalConstant.FAVORITES_PORTLET_CODE.equals(portletTypeVO.getPORTLET_CODE()))
		{
		    defaultImg = DashboardPortalConstant.FAVORITES_DEFAULT_IMG;
		}
		else if(DashboardPortalConstant.APPS_PORTLET_CODE.equals(portletTypeVO.getPORTLET_CODE()))
		{
		    defaultImg = DashboardPortalConstant.APPS_DEFAULT_IMG;
		}
		else if(DashboardPortalConstant.WORKSPACE_PORTLET_CODE.equals(portletTypeVO.getPORTLET_CODE()))
		{
		    defaultImg = DashboardPortalConstant.WORKSPACE_DEFAULT_IMG;
		}

		if(FileUtil.existFile(reposURL + "/" + portletTypeVO.getIMG_URL()))
		{
		    portletTypeVO.setIMG_URL("/pathdesktop/portalDashboardAction_loadImages?IMG_URL=" + portletTypeVO.getIMG_URL());
		}
		else
		{
		    portletTypeVO.setIMG_URL(defaultImg);
		}

		vo.setTitle(getText(portletTypeVO.getTITLE_KEY()));
		vo.setDefaultImg(defaultImg);
		vo.setPortletTypeVO(portletTypeVO);
		vo.setWrkspceCustDisplay("");
		vo.setWdgtAssignDisplay("");
		
		if(wkspceCustRight == null || !DashboardPortalConstant.WORKSPACE_PORTLET_CODE.equals(portletTypeVO.getPORTLET_CODE()))
		{
		    vo.setWrkspceCustDisplay("display:none");
		}

		if(wdgtAssignRight == null || !DashboardPortalConstant.WORKSPACE_PORTLET_CODE.equals(vo.getId()))
		{
		    vo.setWdgtAssignDisplay("display:none");
		}
		widgetList.add(vo);
	    }

	    // applying various access rights
	    applyAccessRights();
	    
	    setCurrentURL("pathdesktop/dashboard.action");
	    
	    //set defaultDisplayPage flag
	    UsrSC usrSC = new UsrSC();
	    usrSC.setUser_id(returnSessionObject().getUserName());
	    setDefaultDisplayPage(loginBO.returnUsrDefaultDisplayPage(usrSC));
	    setChooseDashLayoutKey(getText("choose_dash_layout_key"));
	}
	catch(Exception e)
	{
	    handleException(e, "Problem loading widget list", "");
	    return ERROR;
	}
	return SUCCESS;
    }

    public void loadImages()
    {
	String fileName = theVO.getIMG_URL();
	String repositoryPath = FileUtil.getFileURLByName("repository");
	try
	{
	    byte[] data = new byte[0];
	    if(!StringUtil.nullToEmpty(fileName).isEmpty())
	    {
		String newPath = repositoryPath + "/" + fileName;
		File file = new PathFileSecure(newPath);
		if(file.exists())
		{
		    FileInputStream fos = new FileInputStream(file);
		    byte[] b = new byte[fos.available()];
		    fos.read(b);
		    fos.close();
		    data = b;
		}
	    }
	    HttpServletResponse response = ServletActionContext.getResponse();
	    response.setContentLength(data.length);
	    ServletOutputStream ouputStream = response.getOutputStream();
	    ouputStream.write(data, 0, data.length);
	    ouputStream.flush();
	    ouputStream.close();
	}
	catch(Exception e)
	{
	    log.error(e, "Image could not be loaded");
	}
    }

    private void applyAccessRights() throws BaseException
    {
	SessionCO session = returnSessionObject();
	String currAppName = session.getCurrentAppName();
	String[] opts = { ConstantsCommon.SETTINGS_CONFIG_OPT, ConstantsCommon.LABELING_CONFIG_OPT,
		ConstantsCommon.SWITCH_VIEW_OPT, ConstantsCommon.DEFAULT_PRINTER_AXS,
		ConstantsCommon.USR_ALLWD_PRTLT_AXS, ConstantsCommon.TECH_DETAILS_OPT,ConstantsCommon.TECH_LOGS_OPT,
		ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT, ConstantsCommon.DYN_CLNT_PARAMS_APPROVE_OPT,
		ConstantsCommon.DYN_CLNT_PARAMS_COLS_EDIT_OPT,ConstantsCommon.DYN_SCR_GEN_OPT,
		ConstantsCommon.EXP_IMP_CUST_OPT,ConstantsCommon.SET_AS_DEFAULT_PAGE_OPT,ConstantsCommon.USER_THEME_OPT};
	
	HashMap<String, String> accessOpts = returnAccessRightByProgRef(opts, currAppName);

	// check if user has privileges for "Settings" change Option
	// Available in application header
	 setUsrSettingRight(accessOpts.get(ConstantsCommon.SETTINGS_CONFIG_OPT+"_"+currAppName));
	 setDynScrGenRight(accessOpts.get(ConstantsCommon.DYN_SCR_GEN_OPT+"_"+currAppName));

	// check if user has privileges for Label Translation Option
	// Available in application header
	 setUsrLabelRight(accessOpts.get(ConstantsCommon.LABELING_CONFIG_OPT+"_"+currAppName));

	// access rights on Switch view
	 setSwitchViewRight(accessOpts.get(ConstantsCommon.SWITCH_VIEW_OPT+"_"+currAppName));

	// only show header layout options button in dashboard portal screen
	setShowHeaderOptions("true");

	// only show manager header options in dashboard portal screen Options
	// menu
	if(ConstantsCommon.RET_APP_NAME.equals(currAppName) || ConstantsCommon.IBIS_APP_NAME.equals(currAppName) )
	{
	    returnHdrOptionsAccessRightByUserId();
	}

	// check access privilege to set default printer
	 setUsrPrntAxsRight(accessOpts.get(ConstantsCommon.DEFAULT_PRINTER_AXS+"_"+currAppName));

	PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
	if(ConstantsCommon.ONE.equals(pthCtrl.getENABLE_PORTLET_AXS_YN()))
	{
	    // check access privilege to set user allowed portlets
	    setUsrAllwdPrtltRight(returnAccessRightByProgRef(ConstantsCommon.USR_ALLWD_PRTLT_AXS));
	}

	// check access rights on technical details
	 setTechDetailsRight(accessOpts.get(ConstantsCommon.TECH_DETAILS_OPT+"_"+currAppName));

	// check access rights on technical details
	 setTechLogsRight(accessOpts.get(ConstantsCommon.TECH_LOGS_OPT + "_" + currAppName));

	 //check if user has privileges for Dynamic client params approve Option Available in application header
	setDynClntPrmsApproveRight(accessOpts.get(ConstantsCommon.DYN_CLNT_PARAMS_APPROVE_OPT+"_"+currAppName));
		
	//check if user has privileges for Dynamic client params edit Option Available in application header
	setDynClntPrmsEditRight(accessOpts.get(ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT+"_"+currAppName));

	//check if user has privileges for Dynamic client params edit columns details Option Available in application header
	setDynClntPrmsColsEditRight(accessOpts.get(ConstantsCommon.DYN_CLNT_PARAMS_COLS_EDIT_OPT+"_"+currAppName));
	
	//Access rights for export/import screen customization.
	setExpImpCustRight(accessOpts.get(ConstantsCommon.EXP_IMP_CUST_OPT+"_"+currAppName));
	
	// check if the user has the access to activate/update/create themes
	setUsrThemeRight(accessOpts.get(ConstantsCommon.USER_THEME_OPT+"_"+currAppName));
	
	//check access rights to show Set As Default Page checkbox in layout options
	setUsrSetAsDefaultPageRight(accessOpts.get(ConstantsCommon.SET_AS_DEFAULT_PAGE_OPT+"_"+currAppName));
    }

    private List<USER_PORTLETSVO> returnUserPortles()
    {
	List<USER_PORTLETSVO> updatesLst = new ArrayList<USER_PORTLETSVO>();
	JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(userPortalUpdates);
	Iterator it = jsonFilter.keys();
	String key = null;
	USER_PORTLETSVO vo;
	while(it.hasNext())
	{
	    key = (String) it.next();
	    JSONObject obj = (JSONObject) jsonFilter.get(key);
	    vo = (USER_PORTLETSVO) JSONObject.toBean(obj, USER_PORTLETSVO.class);
	    vo.setUSER_ID(returnSessionObject().getUserName());
	    updatesLst.add(vo);
	}
	return updatesLst;
    }

    public String saveLayout()
    {
	try
	{
	    List<USER_PORTLETSVO> updatesLst = returnUserPortles();
	    
	    dashboardPortalBO.saveLayout(updatesLst,returnSessionObject().getUserName());

	    // applying various access rights
	    applyAccessRights();
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String updateUserDefaultDisplayPage()
    {
	USRVO usrVO = new USRVO();
	usrVO.setUSER_ID(returnSessionObject().getUserName());
	usrVO.setDEFAULT_DISPLAY_PAGE(defaultDisplayPage);
	try
	{
	    dashboardPortalBO.updateUserDefaultDisplayPage(usrVO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String loadCustomDialog()
    {
	return "loadCustomDialog";
    }

    public String loadResizeDialog()
    {
	return "loadResizeDialog";
    }

    public String loadCustomizeDialog()
    {
	try
	{
          PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
          profType = StringUtil.nullEmptyToValue(pthCtrl.getPOP_PROF_MOD_ACCESS(),ConstantsCommon.ZERO);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}

	return "loadCustomizeDialog";
    }

    public String saveCustomWidget()
    {
	try
	{
	    List<USER_PORTLETSVO> updatesLst = returnUserPortles();
	    /**
	     * in case of report URL
	     */
	    if(BigDecimal.valueOf(2).equals(urlType))
	    {
		StringBuffer portalRepUrl = new StringBuffer();
		portalRepUrl.append(ConstantsCommon.PORTAL_REP_WIDGET);
		portalRepUrl.append("&r_r=");
		portalRepUrl.append(reportProgRef);
		portalRepUrl.append("&r_i=");
		portalRepUrl.append(reportId);
		portalRepUrl.append("&a=");
		portalRepUrl.append(appName);
		portalRepUrl.append("&_pageRef=");
		portalRepUrl.append(reportProgRef);
		theVO.setPORTLET_URL(portalRepUrl.toString());
	    }
	    
	    theVO.setUSR_DEFINED_PORTLET_YN(DashboardPortalConstant.USR_DEFINED_PORTLET);
	    dashboardPortalBO.insertUserPortlet(theVO, updatesLst);
	    /**
	     * report URL management 
	     */
	    if(BigDecimal.valueOf(2).equals(urlType))
	    {
		CommonLibSC criteria = new CommonLibSC();
		criteria.setReportId(reportId);
		StringBuffer reportURL= new StringBuffer();
		/**
		 * [Marwan Maddah]:
		 * in case the args count >0, then the current report has arguments 
		 * in this case the parameters screen will appear and from it the report can be opened.
		 */
		if(returnCommonLibBO().checkReportDisplayArgs(criteria)>0)
		{
		    String repCommonURLParams = PathPropertyUtil.getPathRemotingProp(PATH_REMOTING, REP_COMMON_URL_PARAMS);
		    if(StringUtil.nullToEmpty(repCommonURLParams).isEmpty())
		    {
			throw new BOException(getText("exist_rep_common_prop_key"));
		    }
		    
		    reportURL.append(repCommonURLParams.trim());
		    reportURL.append("?");
		}
		else
		{
		    String repCommonUrlDirect = PathPropertyUtil.getPathRemotingProp(PATH_REMOTING, REP_COMMON_URL_DIRECT);
		    if(StringUtil.nullToEmpty(repCommonUrlDirect).isEmpty())
		    {
			throw new BOException(getText("exist_rep_common_prop_key"));
		    }
		    
		    reportURL.append(repCommonUrlDirect.trim());
		    reportURL.append("?");
		    reportURL.append("fromMenu=true");
		}
		widgetVO.setUrl(theVO.getPORTLET_URL().replace(ConstantsCommon.PORTAL_REP_WIDGET,reportURL));
		widgetVO.setRepUrl("1");		
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    /**
     * Open Branch Management
     * @author marwanmaddah
     * @date   Jan 22, 2014
     * @return String
     *
     */
    public String openBranchMgnt()
    {
	try
	{
	    SessionCO session = returnSessionObject();
	    CommonLibSC criteria = new CommonLibSC();
	    criteria.setCompanyCode(session.getCompanyCode());
	    criteria.setBranchCode(session.getBranchCode());
	    criteria.setUserId(session.getUserName());
	    criteria.setAppName(session.getCurrentAppName());
	    criteria.setIsBranch(ConstantsCommon.ONE);
	    criteria.setRunningDate(session.getRunningDateRET());
	    returnCommonLibBO().openBranchMgnt(criteria);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * Open Session Management
     * @author marwanmaddah
     * @date   Feb 7, 2014
     * @return String
     *
     */
    public String openSessionMgnt()
    {
	try
	{
	    SessionCO session = returnSessionObject();
	    CommonLibSC criteria = new CommonLibSC();
	    criteria.setCompanyCode(session.getCompanyCode());
	    criteria.setBranchCode(session.getBranchCode());
	    criteria.setUserId(session.getUserName());
	    criteria.setAppName(session.getCurrentAppName());
	    criteria.setRunningDate(session.getRunningDateRET());
	    returnCommonLibBO().openSessionMgnt(criteria);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * Final Sign Off Management
     * 
     * @author marwanmaddah
     * @date Feb 17, 2014
     * @return String
     * 
     */
    public String finalSignOffChecking()
    {
	try
	{
	    SessionCO session = returnSessionObject();
	    DashboardPortalSC criteria = new DashboardPortalSC();
	    criteria.setCompCode(session.getCompanyCode());
	    criteria.setBranchCode(session.getBranchCode());
	    criteria.setUserId(session.getUserName());
	    criteria.setCurrAppName(session.getCurrentAppName());
	    criteria.setRunningDate(session.getRunningDateRET());
	    criteria.setLanguageCode(session.getLanguage());
	    criteria.setExceptionConfirmed(exceptionConfirmed);
	    criteria.setBaseCurrencyCode(session.getBaseCurrencyCode());
	    /**
	     * Final sign off feature is applicable on CSM application and for tellers only
	     */
	    if(!ConstantsCommon.RET_APP_NAME.equals(session.getCurrentAppName()) || session.getCtsTellerVO() == null || session.getCtsTellerVO().getCODE()==null)
	    {
		if(!ConstantsCommon.IBIS_APP_NAME.equals(session.getCurrentAppName()))
		{
		    throw new BOException(getText("finalSignOffTeller_key"));
		}else
		{
		    dashboardPortalBO.finalSignOffChecking(criteria);
		}
	    }
	    else
	    {		
		criteria.setTellerCode(session.getCtsTellerVO().getCODE());
		dashboardPortalBO.finalSignOffChecking(criteria);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    /**
     * After checking the process will call this function to update the Teller status in the table CTSTELLER
     * @author marwanmaddah
     * @date   Mar 12, 2015
     * @return String
     *
     */
    public String finalSignOff()
    {
	try
	{
	    SessionCO session = returnSessionObject();
	    DashboardPortalSC criteria = new DashboardPortalSC();
	    criteria.setCompCode(session.getCompanyCode());
	    criteria.setBranchCode(session.getBranchCode());
	    criteria.setUserId(session.getUserName());
	    criteria.setCurrAppName(session.getCurrentAppName());
	    criteria.setRunningDate(session.getRunningDateRET());
	    criteria.setLanguageCode(session.getLanguage());
	    if(ConstantsCommon.IBIS_APP_NAME.equals(session.getCurrentAppName()))
	    {
		 CTSTELLERSC ctsTellerSC = new CTSTELLERSC();
     	    	ctsTellerSC.setUserId(session.getUserName());
     	    	ctsTellerSC.setCompCode(session.getCompanyCode());
     	    	ctsTellerSC.setBranchCode(session.getBranchCode());
		session.setCtsTellerVO(loginBO.loadTellerDetails(ctsTellerSC, session.getMachineIp(),session.getHttpSessionID()));
	    }
	    criteria.setTellerCode(session.getCtsTellerVO().getCODE());
	    criteria.setBaseCurrencyCode(session.getBaseCurrencyCode());
	    dashboardPortalBO.finalSignOff(criteria);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * Switch company & Branch Managements
     * Used to do the management of switch between companies and branches 
     * @author marwanmaddah
     * @date Feb 19, 2014
     * @return String
     * 
     */
    public String switchCompanyBranchMgnt()
    {
	try
	{
	    SessionCO session = returnSessionObject();
	    CommonLibSC criteria = new CommonLibSC();
	    criteria.setCompCode(session.getCompanyCode());
	    criteria.setBranchCode(session.getBranchCode());
	    criteria.setUserId(session.getUserName());
	    criteria.setAppName(session.getCurrentAppName());
	    criteria.setLanguage(session.getLanguage());
	    criteria.setSwitchBranch(switchBranch);
	    returnCommonLibBO().switchCompanyBranchMgnt(criteria);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    public String openChangePwd() 
    {
	try
	{
	    SessionCO sessionCO = sessionCOInitialize();
	    UsrCO usrCO = loginBO.returnAdDetails(sessionCO.getUserName());
	    // TP #933826 :ABSAI190603 - Cannot change iMAL password from Java applications
	    if(ConstantsCommon.USER_LOGIN_CRITERIA_LDAP.equals(StringUtil.nullToEmpty(sessionCO.getAuthenticatedBy())))
	    {
	    	throw new BOException(MessageCodes.NO_ACCESS);
	    }
	    setOpenInDialog(Boolean.TRUE);
	    setShowHeaderOptions(ConstantsCommon.TRUE);
	    PTH_CTRLVO pth = returnCommonLibBO().returnPthCtrl();
	    if(ConstantsCommon.ONE.equals(pth.getENABLE_CAPTCHA_YN()))
	    {
		if((pth.getNBR_BEF_CAPTCHA() == null || pth.getNBR_BEF_CAPTCHA().compareTo(new BigDecimal(0)) == 0))
		{
		   setCaptchaEnabled(ConstantsCommon.ONE);
		}
		else if(NumberUtil.nullToZero(usrCO.getUNSUCCESS_LOGINS()).compareTo(pth.getNBR_BEF_CAPTCHA()) > -1)
		{
		   setCaptchaEnabled(ConstantsCommon.ONE);
		}
	    }
	    return "loadPwdChangeDialog";
        }
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
    }
    public String updatePwd()
    {
	String result = SUCCESS;
	SessionCO sessionCO = null;
	try
	{
	    HttpServletRequest request = ServletActionContext.getRequest();
	    PasswordChangeCO pwdChangeCO = new PasswordChangeCO();
	    sessionCO = returnSessionObject();
		// TP #933826 :ABSAI190603 - Cannot change iMAL password from Java applications
	    if(ConstantsCommon.USER_LOGIN_CRITERIA_LDAP.equals(StringUtil.nullToEmpty(sessionCO.getAuthenticatedBy())))
	    {
	    	throw new BOException(MessageCodes.NO_ACCESS);
	    }
	    pwdChangeCO.setUserName(sessionCO.getUserName());
	    pwdChangeCO.setNewPwd(newPwd);
	    pwdChangeCO.setConfirmPwd(confirmPwd);
	    /**
	     * BUG TP481200 change password from screen mirroring error
	     */
	    pwdChangeCO.setOldPwd(oldPwd);
	    //to enable checking old password before updating it.
	    pwdChangeCO.setAllowAccess(ConstantsCommon.OLD_PWD_UPON_LOGIN_EXSTS);
	    /**
	     * 
	     */
	    String userName  = sessionCO.getUserName();
	    String sessionID = sessionCO.getHttpSessionID();
	    String hostName  = sessionCO.getMachineIp();
	    
	    pwdChangeCO.setUserName(userName);
	    pwdChangeCO.setSessionID(sessionID);
	    pwdChangeCO.setHostName(hostName);
	    pwdChangeCO.setAppName(sessionCO.getCurrentAppName());
	    pwdChangeCO.setCompCode(sessionCO.getCompanyCode());
	    pwdChangeCO.setBranchCode(sessionCO.getBranchCode());
	    pwdChangeCO.setLanguage(sessionCO.getLanguage());
	    pwdChangeCO.setCaptchUserText(getCaptchUserText());
	    pwdChangeCO.setRunningDate(sessionCO.getRunningDateRET());
	    pwdChangeCO.setMachineIp(sessionCO.getMachineIp());
	    //if(capthca is disabled then we must set the captchausertext to null since it will come empty in the ajax in order not to check it in loginBO.changePwd method.
	    if(!ConstantsCommon.ONE.equals(getCaptchaText()))
	    {
		pwdChangeCO.setCaptchUserText(null);
	    }
	    pwdChangeCO.setCaptchaText((String)request.getSession().getAttribute("captchaText"));
	    boolean userSuspended = loginBO.changePwd(pwdChangeCO, userName);
	    if(userSuspended)
	    {
		if(pwdChangeCO.getCompCode()!=null && pwdChangeCO.getBranchCode()!=null)
		{			
		    loginBO.logoutUserFromModule(pwdChangeCO.getUserName(), pwdChangeCO.getAppName(), pwdChangeCO.getHostName(), pwdChangeCO.getCompCode(), pwdChangeCO.getBranchCode(), "1", pwdChangeCO.getSessionID(), false);
		}
		ServletActionContext.getRequest().getSession().invalidate();
		ServletActionContext.getRequest().getSession(true).setAttribute("userTokenSuspended", "1");
		ServletActionContext.getRequest().getSession(true).setAttribute("fromChangePwd", "1"); 
		result = "suspendRedirect";
	    }
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		// check if the captcha should be displayed or not.
		UsrCO usrCO = loginBO.returnAdDetails(sessionCO.getUserName());
		PTH_CTRLVO pth = returnCommonLibBO().returnPthCtrl();
		if(ConstantsCommon.ONE.equals(pth.getENABLE_CAPTCHA_YN()))
		{
		    if((pth.getNBR_BEF_CAPTCHA() == null || pth.getNBR_BEF_CAPTCHA().compareTo(new BigDecimal(0)) == 0))
		    {
			setCaptchaEnabled(ConstantsCommon.ONE);
		    }
		    else if(NumberUtil.nullToZero(usrCO.getUNSUCCESS_LOGINS()).compareTo(pth.getNBR_BEF_CAPTCHA()) > -1)
		    {
			setCaptchaEnabled(ConstantsCommon.ONE);
		    }
		}
	    }catch(Exception ex)
	    {
		handleException(ex, null, null);
	    }
	}
	setOldPwd(null);
	setNewPwd(null);
	setConfirmPwd(null);
	setCaptchUserText(null);
	return result;
    }

    
    public String closeBranchMgnt()
    {
	SessionCO seObj = returnSessionObject();
	CommonLibSC criteria = new CommonLibSC();
	criteria.setCompanyCode(seObj.getCompanyCode());
	criteria.setBranchCode(seObj.getBranchCode());
	criteria.setUserId(seObj.getUserName());
	criteria.setFlag(theVO.getUSR_DEFINED_PORTLET_YN());
	try
	{
	    returnCommonLibBO().closeBranchMgnt(criteria);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }

public String closeSessionMgnt()
{
	SessionCO seObj = returnSessionObject();
	CommonLibSC criteria = new CommonLibSC();
	criteria.setCompanyCode(seObj.getCompanyCode());
	criteria.setCompCode(seObj.getCompanyCode());
	criteria.setBranchCode(seObj.getBranchCode());
	criteria.setLanguage(seObj.getLanguage());
	criteria.setUserId(seObj.getUserName());
	criteria.setFlag(theVO.getUSR_DEFINED_PORTLET_YN());
	
	if(seObj.getCtsTellerVO()!=null)
	{	    
	    criteria.setTellerCode(seObj.getCtsTellerVO().getCODE());
	}
	
	if(noActiveTrx!=null && !NumberUtil.isEmptyDecimal(noActiveTrx))
	{
	   criteria.setNoActiveTrans(noActiveTrx);
	}
	criteria.setFromForceLogout(fromForceLogout);
	criteria.setAppName(ConstantsCommon.RET_APP_NAME);
	try
	{
	    if(ConstantsCommon.FROM_FORCE_CLOSE_AFTR_PROCEED.equals(fromForceLogout)) 
	    {
	    	returnCommonLibBO().forceLogoutUsers(criteria);
	    }
	    activeTransCO = returnCommonLibBO().closeSessionMgnt(criteria);
	}
	catch(BOException e)
	{
	    if(ConstantsCommon.CONFIRM_MSG_TYPE.equals(e.getMsgType())
		    && MessageCodes.PENDING_PROCESS_PRINT.equals(e.getErrorCode()))
	    {
		activeTransCO = (ActiveTransCO) e.getRetValue();
	    }
	    if(ConstantsCommon.CONFIRM_MSG_TYPE.equals(e.getMsgType())
		    && MessageCodes.CANNOT_CLOSE_THE_SESSION_SOME_USERS_ARE_STILL_LOGGED_TO_CSM.equals(e.getErrorCode()))
	    {
		try
		{
		    // we are replacing 31579 in the contentmessage since in the ajax response. there is a checking for error code to print or show active transaction.
		    contentMessage = returnCommonLibBO().returnTranslErrorMessage(MessageCodes.PENDING_PROCESS_PRINT, criteria.getLanguage()).replace("31579", "");
		    forceClosureAccess  = (String) e.getMsgIdent();
		}
		catch(BaseException e1)
		{
		    log.error(e1, "returning trans for:"+MessageCodes.PENDING_PROCESS_PRINT+" has failed!!");
		}
	    }
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
}

private void returnHdrOptionsAccessRightByUserId()
{
	try
	{
	    SessionCO sesCO = returnSessionObject();
	    CommonLibSC criteria = new CommonLibSC();
	    criteria.setCompCode(sesCO.getCompanyCode());
	    criteria.setBranchCode(sesCO.getBranchCode());
	    criteria.setUserId(sesCO.getUserName());
	    criteria.setCurrAppName(sesCO.getCurrentAppName());
	    HashMap<String,String> allowAccess = returnCommonLibBO().checkUserValidity(criteria);
	    setShowMgrOptions(allowAccess.get("showMgrOptions"));
	    setFinalSignOffOption(allowAccess.get("finalSignOff"));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
}
/**
 * 
 * @author marwanmaddah
 * @date   Feb 23, 2015
 * @return String
 *
 */
public String dashRepDependencyByProgRef()
{
	try
	{
	    UsrSC criteria = new UsrSC();
	    SessionCO sessionCO = returnSessionObject();
	    BigDecimal compCode = sessionCO.getCompanyCode();
	    criteria.setCompCode(compCode);
	    criteria.setBranchCode(sessionCO.getBranchCode());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    criteria.setReportRef(reportProgRef);
	    criteria.setAppName(appName);
	    
	    PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
	    criteria.setProfType(NumberUtil.nullToZero(pthCtrl.getPOP_PROF_MOD_ACCESS()));

	    UsrCO usrReportCO = usrBO.getUsrReports(criteria);
            if(usrReportCO==null)
            {
        	throw new BOException(MessageCodes.INVALID_ENTRY);
            }
            else
            {
        	setReportDesc(usrReportCO.getREPORT_NAME());
        	setReportId(usrReportCO.getREPORT_ID());
        	setReportProgRef(usrReportCO.getREPORT_PROG_REF());        	
            }
	}
	catch(Exception ex)
	{
	    setReportDesc(null);
	    setReportId(null);
	    setReportProgRef(null);
	    handleException(ex, null, null);
	}
	return SUCCESS;
}


public String loadUsrAllwdPortlets()
{
	try
	{
      PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
      profType = StringUtil.nullEmptyToValue(pthCtrl.getPOP_PROF_MOD_ACCESS(),ConstantsCommon.ZERO);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}

	return "loadUsrAllwdPortlets";
}



private void fillMarqueeMessages() throws BaseException
{
    S_APPVO app = new S_APPVO();
    boolean appDeployed = false;
    app.setAPP_NAME(ConstantsCommon.ESHR_APP_NAME);
    app = returnCommonLibBO().returnApplication(app);
    if(app != null)
    {
	appDeployed = BigDecimal.ZERO.compareTo(app.getIS_WEB_YN())<0;
    }
    if(!appDeployed)
    {
	app = new S_APPVO();
	app.setAPP_NAME(ConstantsCommon.ESPL_APP_NAME);
	app = returnCommonLibBO().returnApplication(app);
	if(app != null)
	{
	    appDeployed = BigDecimal.ZERO.compareTo(app.getIS_WEB_YN())<0;
	}
    }

    if(appDeployed)
    {
	SessionCO session = returnSessionObject();
        DashboardPortalSC criteria = new DashboardPortalSC();
        criteria.setCompCode(session.getCompanyCode());
        criteria.setBranchCode(session.getBranchCode());
        criteria.setEmployeeID(session.getEmployeeId());
        if(!NumberUtil.isEmptyDecimal(session.getEmployeeId()))
        {
            marqueeMessages = dashboardPortalBO.returnMarqueeMessages(criteria);
        }
    }
}

/**
 * Method to write Employee Photo in jsp page
 */
    public String loadEmployeePhoto()
    {
	try
	{
	    SessionCO session = returnSessionObject();
	    if(NumberUtil.isEmptyDecimal(session.getEmployeeId()))
	    {
		return "defaultImg";
	    }
	    DashboardPortalSC criteria = new DashboardPortalSC();
	    criteria.setCompCode(session.getCompanyCode());
	    criteria.setBranchCode(session.getBranchCode());
	    criteria.setEmployeeID(session.getEmployeeId());
	    EMP_PHOTOSVO empPhoto = null;
        if(!NumberUtil.isEmptyDecimal(session.getEmployeeId()))
        {
        	empPhoto = dashboardPortalBO.loadEmployeePhoto(criteria);
        }
	   
	    if(empPhoto == null || empPhoto.getEMP_PHOTO() == null || empPhoto.getEMP_PHOTO().length == 0)
	    {
		return "defaultImg";
	    }
	    else
	    {
		//Put the code that uses Streams inside a try/catch block in order to always
		//close the streams in the finally block in case of exception.
		InputStream in = new ByteArrayInputStream(empPhoto.getEMP_PHOTO());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
		    String photoType = StringUtil.nullEmptyToValue(empPhoto.getFILE_TYPE(),
			    ConstantsCommon.PHOTO_EXTENSION_JPEG);
		    int dotPos = photoType.lastIndexOf(".") + 1;
		    photoType = photoType.substring(dotPos, photoType.length()).toUpperCase();
		    if(!((ConstantsCommon.PHOTO_EXTENSION_JPEG.equals(photoType))
			   // || (ConstantsCommon.PHOTO_EXTENSION_JPG.equals(photoType)) // JPG do not work in IE
			    || (ConstantsCommon.PHOTO_EXTENSION_PNG.equals(photoType))
			    || (ConstantsCommon.PHOTO_EXTENSION_BMP.equals(photoType))
			    || (ConstantsCommon.PHOTO_EXTENSION_GIF.equals(photoType))))
		    {
			photoType = ConstantsCommon.PHOTO_EXTENSION_JPEG;
		    }
		    ImageIO.write(ImageIO.read(in), photoType, baos);
		    HttpServletResponse response = ServletActionContext.getResponse();
		    setServletResponse(response);
		    response.setContentType("image/" + photoType);
		    response.getOutputStream().write(baos.toByteArray());
		    response.getOutputStream().flush();
		}
		catch(Exception e)
		{
		    throw e;
		}
		finally
		{
		    baos.close();
		    in.close();
		}
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}

	return null;
    }

    public List getWidgetList()
    {
	return widgetList;
    }

    public void setWidgetList(List widgetList)
    {
	this.widgetList = widgetList;
    }

    public void setDashboardPortalBO(DashboardPortalBO dashboardPortalBO)
    {
	this.dashboardPortalBO = dashboardPortalBO;
    }

    public String getUserPortalUpdates()
    {
	return userPortalUpdates;
    }

    public void setUserPortalUpdates(String userPortalUpdates)
    {
	this.userPortalUpdates = userPortalUpdates;
    }

    public SYS_PARAM_PORTLET_TYPEVO getTheVO()
    {
	return theVO;
    }

    public void setTheVO(SYS_PARAM_PORTLET_TYPEVO theVO)
    {
	this.theVO = theVO;
    }

    public String getUsrSideBarRight()
    {
	return usrSideBarRight;
    }

    public void setUsrSideBarRight(String usrSideBarRight)
    {
	this.usrSideBarRight = usrSideBarRight;
    }
    @Override
    public String getHomeURL()
    {
	return homeURL;
    }

    public void setHomeURL(String homeURL)
    {
	this.homeURL = homeURL;
    }

    public String getShowHeaderOptions()
    {
	return showHeaderOptions;
    }

    public void setShowHeaderOptions(String showHeaderOptions)
    {
	this.showHeaderOptions = showHeaderOptions;
    }

    public String getEmptyDash()
    {
	return emptyDash;
    }

    public void setEmptyDash(String emptyDash)
    {
	this.emptyDash = emptyDash;
    }

    /**
     * @return the activeTransCO
     */
    public ActiveTransCO getActiveTransCO()
    {
	return activeTransCO;
    }

    /**
     * @param activeTransCO the activeTransCO to set
     */
    public void setActiveTransCO(ActiveTransCO activeTransCO)
    {
	this.activeTransCO = activeTransCO;
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

    public String getCifFetch()
    {
        return cifFetch;
    }

    public String getShowMgrOptions()
    {
        return showMgrOptions;
    }

    public void setShowMgrOptions(String showMgrOptions)
    {
        this.showMgrOptions = showMgrOptions;
    }

    public String getDefaultDisplayPage()
    {
        return defaultDisplayPage;
    }

    public void setDefaultDisplayPage(String defaultDisplayPage)
    {
        this.defaultDisplayPage = defaultDisplayPage;
    }

    /**
     * @return the newSessionRight
     */
    @Override
    public String getNewSessionRight()
    {
        return newSessionRight;
    }

    /**
     * @param newSessionRight the newSessionRight to set
     */
    @Override
    public void setNewSessionRight(String newSessionRight)
    {
        this.newSessionRight = newSessionRight;
    }

    /**
     * @return the switchBranch
     */
    @Override
    public Boolean getSwitchBranch()
    {
        return switchBranch;
    }

    /**
     * @param switchBranch the switchBranch to set
     */
    @Override
    public void setSwitchBranch(Boolean switchBranch)
    {
        this.switchBranch = switchBranch;
    }

    /**
     * @return the profType
     */
    public String getProfType()
    {
        return profType;
    }

    /**
     * @param profType the profType to set
     */
    public void setProfType(String profType)
    {
        this.profType = profType;
    }

    /**
     * @return the chooseDashLayoutKey
     */
    public String getChooseDashLayoutKey()
    {
        return chooseDashLayoutKey;
    }

    /**
     * @param chooseDashLayoutKey the chooseDashLayoutKey to set
     */
    public void setChooseDashLayoutKey(String chooseDashLayoutKey)
    {
        this.chooseDashLayoutKey = chooseDashLayoutKey;
    }

    /**
     * @return the reportId
     */
    public BigDecimal getReportId()
    {
        return reportId;
    }

    /**
     * @param reportId the reportId to set
     */
    public void setReportId(BigDecimal reportId)
    {
        this.reportId = reportId;
    }

    /**
     * @return the reportProgRef
     */
    public String getReportProgRef()
    {
        return reportProgRef;
    }

    /**
     * @param reportProgRef the reportProgRef to set
     */
    public void setReportProgRef(String reportProgRef)
    {
        this.reportProgRef = reportProgRef;
    }

    /**
     * @return the urlType
     */
    public BigDecimal getUrlType()
    {
        return urlType;
    }

    /**
     * @param urlType the urlType to set
     */
    public void setUrlType(BigDecimal urlType)
    {
        this.urlType = urlType;
    }

    /**
     * @return the reportDesc
     */
    public String getReportDesc()
    {
        return reportDesc;
    }

    /**
     * @param reportDesc the reportDesc to set
     */
    public void setReportDesc(String reportDesc)
    {
        this.reportDesc = reportDesc;
    }

    /**
     * @param usrBO the usrBO to set
     */
    public void setUsrBO(UsrBO usrBO)
    {
        this.usrBO = usrBO;
    }

    /**
     * @return the appName
     */
    @Override
    public String getAppName()
    {
        return appName;
    }

    /**
     * @param appName the appName to set
     */
    @Override
    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    /**
     * @return the appDesc
     */
    public String getAppDesc()
    {
        return appDesc;
    }

    /**
     * @param appDesc the appDesc to set
     */
    public void setAppDesc(String appDesc)
    {
        this.appDesc = appDesc;
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

    /**
     * @return the finalSignOffOption
     */
    public String getFinalSignOffOption()
    {
        return finalSignOffOption;
    }

    /**
     * @param finalSignOffOption the finalSignOffOption to set
     */
    public void setFinalSignOffOption(String finalSignOffOption)
    {
        this.finalSignOffOption = finalSignOffOption;
    }
    
    public String getUsrAllwdPrtltRight()
    {
        return usrAllwdPrtltRight;
    }

    public void setUsrAllwdPrtltRight(String usrAllwdPrtltRight)
    {
        this.usrAllwdPrtltRight = usrAllwdPrtltRight;
    }

    /**
     * @return the widgetVO
     */
    public WidgetVO getWidgetVO()
    {
        return widgetVO;
    }

    /**
     * @param widgetVO the widgetVO to set
     */
    public void setWidgetVO(WidgetVO widgetVO)
    {
        this.widgetVO = widgetVO;
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

    public List<String> getMarqueeMessages()
    {
        return marqueeMessages;
    }
    public void setMarqueeMessages(List<String> marqueeMessages)
    {
        this.marqueeMessages = marqueeMessages;
    }

    /**
     * @return the usrSetAsDefaultPageRight
     */
    public String getUsrSetAsDefaultPageRight()
    {
        return usrSetAsDefaultPageRight;
    }

    /**
     * @param usrSetAsDefaultPageRight the usrSetAsDefaultPageRight to set
     */
    public void setUsrSetAsDefaultPageRight(String usrSetAsDefaultPageRight)
    {
        this.usrSetAsDefaultPageRight = usrSetAsDefaultPageRight;
    }

    /**
     * @return the oldPwd
     */
    public String getOldPwd()
    {
        return oldPwd;
    }

    /**
     * @param oldPwd the oldPwd to set
     */
    public void setOldPwd(String oldPwd)
    {
        this.oldPwd = oldPwd;
    }

    public String getCaptchaEnabled()
    {
        return captchaEnabled;
    }

    public void setCaptchaEnabled(String captchaEnabled)
    {
        this.captchaEnabled = captchaEnabled;
    }

    public String getCaptchUserText()
    {
        return captchUserText;
    }

    public void setCaptchUserText(String captchUserText)
    {
        this.captchUserText = captchUserText;
    }

    public String getCaptchaText()
    {
        return captchaText;
    }

    public void setCaptchaText(String captchaText)
    {
        this.captchaText = captchaText;
    }

    public String getFromForceLogout()
    {
        return fromForceLogout;
    }

    public void setFromForceLogout(String fromForceLogout)
    {
        this.fromForceLogout = fromForceLogout;
    }

    public String getContentMessage()
    {
        return contentMessage;
    }

    public void setContentMessage(String contentMessage)
    {
        this.contentMessage = contentMessage;
    }

    public String getForceClosureAccess()
    {
        return forceClosureAccess;
    }

    public void setForceClosureAccess(String forceClosureAccess)
    {
        this.forceClosureAccess = forceClosureAccess;
    }
    

    /**
     * @return the noActiveTrx
     */
    public BigDecimal getNoActiveTrx()
    {
        return noActiveTrx;
    }

    /**
     * @param noActiveTrx the noActiveTrx to set
     */
    public void setNoActiveTrx(BigDecimal noActiveTrx)
    {
        this.noActiveTrx = noActiveTrx;
    }
}
