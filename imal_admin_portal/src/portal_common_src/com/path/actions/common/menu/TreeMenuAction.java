package com.path.actions.common.menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.struts2.ServletActionContext;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.menu.MenuBO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.FMSCTRLVO;
import com.path.dbmaps.vo.IISCTRLVO;
import com.path.dbmaps.vo.OPTVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.MenuVO;
import com.path.struts2.lib.common.base.BaseMenuAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.menu.MenuSC;

@SuppressWarnings("serial")
public class TreeMenuAction extends BaseMenuAction
{
	private MenuBO menuBO;
		
	private String menuId;

	private String menuVar;
	
	private String actionUrl;
	
	private String nameSpacePath;
	
	private String extProgRef ; //OPT of the external screen to be opened from current menu OPT
	
	private String extAppURL; //URL of the external app
	
	private String extAppName; //Name of the external app 
	/**
	 * application Name
	 */
	private String ap_n;
	/**
	 * additional Params provided to loading the screen if called in code (addMenuTab(....))
	 *  Name
	 */
	private String ad_p;
	
	public void setMenuBO(MenuBO menuBO)
	{
		this.menuBO = menuBO;
	}

	
	public String generateMenuOnRequest()
	{
		try
		{
			if(menuId==null || "".equals(menuId))
			{
					menuId="ROOT";
					root=true;
			}
			menuData=(ArrayList<MenuVO>)getRequestedMenuData(menuId); 
			return SUCCESS;
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		    return "SUCCESS_JSON";
		}
		
		
	}
	
	/**
	 * load screen on click on a menuLeaf
	 */
	@Override
	public String loadScreen()
	{
		String result = null;
		try
		{
			SessionCO sessionCO = returnSessionObject();
			String appName = ap_n;
			if(StringUtil.nullToEmpty(appName).isEmpty() )
			{
				appName = sessionCO.getCurrentAppName();
				ap_n = appName; //used in the ExternalFrameLoader.jsp
			}
			
			// super user should not be checking for access rights, or super user  by mistake and accessing non SADS module
			String usrPthStatus = sessionCO.getUsrPathSts();
			if(!ConstantsCommon.SUPER_USER_STATUS.equals(usrPthStatus) 
				|| (ConstantsCommon.SUPER_USER_STATUS.equals(usrPthStatus) && !ConstantsCommon.SADS_APP_NAME.equals(appName)))
			{
        			/**
        			 * [MarwanMaddah]: check Access right
        			 */
        			CommonLibSC commonLibSC = new CommonLibSC();
        			commonLibSC.setAppName(appName);
        			commonLibSC.setUserId(sessionCO.getUserName());
        			commonLibSC.setCompCode(sessionCO.getCompanyCode());
        			commonLibSC.setBranchCode(sessionCO.getBranchCode());
        			commonLibSC.setProgRef(menuVar);
        			String accessRight = returnAccessRightByProgRef(menuVar,appName);
        			if(StringUtil.nullToEmpty(accessRight).isEmpty())
        			{
        			    addActionError(getText("access_denied_key"));
        			    return ERROR_ACTION;
        			}
			}
			/**
			 * 
			 */
			String optUrl = null;
	        	String[] optDetailsArray = returnCommonLibBO().returnOptDetailsList(appName, menuVar);
	        	String originOPTRef = menuVar;
	        	if(optDetailsArray == null || optDetailsArray.length < 1 || StringUtil.nullToEmpty(optDetailsArray[0]).isEmpty())
        		{
	        	    OPTVO optVO = new OPTVO();
	        	    optVO.setAPP_NAME(appName);
	        	    optVO.setPROG_REF(menuVar);
	        	    optVO = returnCommonLibBO().returnOptDetails(optVO);
	        	    String actionErrorMsg;
	        	    if(optVO!=null && ConstantsCommon.PROG_TYPE_ROOT.equals(optVO.getPROG_TYPE()))
	        	    {
	        		actionErrorMsg = getText("menu_type_root_key");
	        	    }
	        	    else
	        	    {
	        		actionErrorMsg = getText("url_not_in_opt_Extended_key");
	        	    }
	        	    addActionError(actionErrorMsg);
        		    return ERROR;
        		}
        		else
        		{
        		    optUrl = optDetailsArray[0];
        		    // OPT Reference is not empty
        		    if(!StringUtil.nullToEmpty(optDetailsArray[4]).isEmpty())
        		    {
        			originOPTRef = optDetailsArray[4];
        		    }
        		    
        		    //target (external) appName
        		    if(!optDetailsArray[5].isEmpty())
        		    {
        			extAppName = optDetailsArray[5];
        			extAppURL  = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties", "app."+extAppName+".url");
        			if(sessionCO.getExternalOpenedUrls() == null)
        			{
        			    sessionCO.setExternalOpenedUrls(new ArrayList<String>());
        			}
        			if(!sessionCO.getExternalOpenedUrls().contains(extAppURL))
        			{
        			    sessionCO.getExternalOpenedUrls().add(extAppURL);
        			}
        			
        			//TP 475542 check if there is additional params added to TRAGET_APP example TARGET_APP?param1=Helloo&param2=25
        			if (optUrl.trim().indexOf(ConstantsCommon.TARGET_APP_URL) == 0 
        				&& optUrl.indexOf("?") > 0)
        			{
        			    ad_p = optUrl.substring(optUrl.indexOf("?")+1);
        			}
        		    }
        		    //target (external) progRef
        		    if(!optDetailsArray[6].isEmpty())
        		    {
        			extProgRef = optDetailsArray[6];
        		    }
        		}
	        	
	        	if(extProgRef != null)
	        	{
	        	    return "successExtScreen";
	        	}
	        	
			if (optUrl != null && optUrl.lastIndexOf('/') > 0)
			{
			 	nameSpacePath = optUrl.substring(0, optUrl.lastIndexOf('/'));
				
                		if(ConstantsCommon.RET_APP_NAME.equals(appName) && ("Q000TP".equals(originOPTRef) || "Q000RP".equals(originOPTRef)))
                		{
                		    CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
                		    ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
                		    ctsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
                		    ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);
                		    if(ctsControlVO.getCHQBOOK_PROCESS() == null || "0".equals(ctsControlVO.getCHQBOOK_PROCESS()))
                		    {
                			result = "errorMsg";
                			throw new BOException(MessageCodes.CHEQUEBOOK_ADVANCED_PROCESS_MSG, ConstantsCommon.MENU_INFO_MSG_TYPE);
                		    }
                		}
                		else
                		// checking for FMS application
                		if(ConstantsCommon.FMS_APP_NAME.equals(appName))
                		{
                		    // for Suspend/ Reactivate sub-limit requirement TP 155917
                		    // TP 339694 Access screen based on grading by cif flag FM
                		    if(ConstantsCommon.FMS_OPT_REACTIVATE_SUBLIMIT.equals(originOPTRef)
                			    || ConstantsCommon.FMS_OPT_SUSPEND_SUBLIMIT.equals(originOPTRef)
                			    || ConstantsCommon.FMS_OPT_CUST_GRAD_UPD_AFT_APPR.equals(originOPTRef))
                		    {
                			FMSCTRLVO fmsControlVO = new FMSCTRLVO();
                			fmsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
                			fmsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
                			fmsControlVO = returnCommonLibBO().returnFMSControlDetails(fmsControlVO);
                                        if((ConstantsCommon.FMS_OPT_REACTIVATE_SUBLIMIT.equals(originOPTRef)
                                                || ConstantsCommon.FMS_OPT_SUSPEND_SUBLIMIT.equals(originOPTRef))
                                                && !ConstantsCommon.YES
                                                       .equals(StringUtil.nullToEmpty(fmsControlVO.getAPP_SUSP_REAC_FAC_SUB())))
                                         {
                                             result = "errorMsg";
                                             throw new BOException(MessageCodes.MARK_FOR_SUSPEND_REACTIVATE_SUBLIMIT_IS_NOT_REQUIRED,
                                                    ConstantsCommon.MENU_INFO_MSG_TYPE);
                                         } 
                                        // TP 690725 based on FMS team request
                                         if(ConstantsCommon.FMS_OPT_CUST_GRAD_UPD_AFT_APPR.equals(originOPTRef) && !ConstantsCommon.YES
                                                .equals(StringUtil.nullToEmpty(fmsControlVO.getGRADING_BY_CIF())))
                                         {
                                             result = "errorMsg";
                                              // "[iMAL FMA]User Donot have previlages since FMS_CONTROL Grading_BY_CIF is not 'Y'");
                                                throw new BOException(MessageCodes.IS_MANDATORY, new String[] { "applicable_only_when_grading_by_cif_is_checked_key" },
                                                 ConstantsCommon.MENU_INFO_MSG_TYPE);
                                         }

                		    }
                		    else // checking for verify Release/ verify Release Un-Categ TIIB130318 User Story 157876 (Navas A. Request)
                			if(ConstantsCommon.FMS_OPT_VERIFY_RELEASE.equals(originOPTRef)
                    			    || ConstantsCommon.FMS_OPT_VERIFY_RELEASE_UND_CATEG.equals(originOPTRef))
                        		    {
                    			    	IISCTRLVO iisControlVO = new IISCTRLVO();
                                                iisControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
                                                iisControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
                                                iisControlVO = returnCommonLibBO().returnIISControlDetails(iisControlVO);
                        			if(ConstantsCommon.NO.equals(iisControlVO.getCOLLATERAL_VERIFY_REQ_YN()))
                        			{
                        			    result = "errorMsg";
                        			    throw new BOException(MessageCodes.VALIDATION_NOT_REQUIRED,
                        				    ConstantsCommon.MENU_INFO_MSG_TYPE);
                        			}
                        		    }
                		}
                		
                		StringBuffer redirectURL = new StringBuffer(optUrl.substring(optUrl.lastIndexOf('/')+1));
                		// check if additional parameter (in case of addMenuTab called by developer) 
                		//Exists then add them to URL
                		if(!StringUtil.nullToEmpty(ad_p).isEmpty())
                		{
                		    redirectURL.append("&"+ad_p);
                		}
                		actionUrl = redirectURL.toString();
				result = SUCCESS;
			}
			else if (optUrl!=null && optUrl.indexOf(ConstantsCommon.REPORTS_OPT_URL) == 0)
			{
			    if(ConstantsCommon.REP_APP_NAME.equals(sessionCO.getCurrentAppName()))
			    {
				nameSpacePath ="/path/reportsRet";
				actionUrl ="dynRepParamsAction_loadReportFromMenu?menu="+menuVar+"&_pageRef="+originOPTRef;
				// if the report related to other application not reporting
				if(!appName.equals(sessionCO.getCurrentAppName()))
				{
				    actionUrl = actionUrl.concat("&appName="+appName);
				}
			    }
			    else
			    {
				//check For TellarCashBalance Report (L000L) Requesting to provide correct Report Reference (RETTLCSBL or RETTLCSTO)
				String repRef = originOPTRef;
				if(ConstantsCommon.TELLER_CASH_BALANCE_OPT.equals(originOPTRef))
				{
				    CTSCONTROLVO ctsCtrl = new CTSCONTROLVO();
				    ctsCtrl.setCOMP_CODE(sessionCO.getCompanyCode());
				    ctsCtrl.setBRANCH_CODE(sessionCO.getBranchCode());
				    ctsCtrl = returnCommonLibBO().returnCtsControlDetails(ctsCtrl);
				    String tvPosition = StringUtil.nullEmptyToValue(ctsCtrl.getTV_POSITION(),"0");
				    repRef = ConstantsCommon.REPORT_TELLER_CASH_BALANCE_TOTAL;
				    if(ConstantsCommon.ONE.equals(tvPosition))
				    {
					repRef = ConstantsCommon.REPORT_TELLER_CASH_BALANCE;
				    }
				}
				
				//reports called from other applications, remotely accessing reporting application 
				nameSpacePath = "/path/reporting";
				actionUrl = "ReportsAction_callReports.action?_pageRef="+menuVar+"&r_r="+repRef;
			    }
			    result = SUCCESS;
			}
			/**
			 * [MarwanMaddah]: in case of Dynamic screen
			 */
			else if(optUrl!=null && optUrl.indexOf(ConstantsCommon.DYNAMIC_OPT_URL) == 0)
			{
			   String dynScreenId = StringUtil.nullEmptyToValue(optDetailsArray[9], "-1");
			   nameSpacePath ="/path/dynamicScreen";
			   actionUrl ="dynamicScreenMainAction_loadDynamicScreen?criteria.screenId="+new BigDecimal(dynScreenId)+"&_pageRef="+menuVar;
			   result = SUCCESS;
			}
			else
			{
				addActionError("Incorrect OPT URL Technical Specification.Please Contact Administrator.");
				return ERROR;
			}
			
			
			if(ConstantsCommon.SECURITY_ENCRYPTPARAMS_ENABLED && SUCCESS.equals(result) && StringUtil.isNotEmpty(actionUrl) && actionUrl.contains("?"))
			{
			    actionUrl = SecurityUtils.returnEncryptedNoPaddingUrl(actionUrl,true,ServletActionContext.getRequest().getSession());
			}
			
		}
		
		catch(Exception ex)
		{
		    	handleException(ex, null, null);
//			addActionError("Error IN Returning Correct OPT reference.Contact Administrator to Check Log Please");
		    	if(result == null)
		    	{
		    	    result = ERROR;
		    	}
		}
		return result;
	}	
	
    private Collection<MenuVO> getRequestedMenuData(String menuId) throws BaseException
    {
	Collection<MenuVO> menuData = null;

	BigDecimal compCode, branchCode;
	SessionCO sessionCO = returnSessionObject();
	String appName = sessionCO.getCurrentAppName();
	MenuSC menuSc = new MenuSC();
	menuSc.setAppName(appName);
	menuSc.setProgRef(menuId);
	menuSc.setBranchIsClosedUserLogged(sessionCO.getBranchIsClosedUserLogged());
	PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();

	if(StringUtil.nullEmptyToValue(pthCtrl.getGLOBAL_AXS_PRIVILEGE(), "0").equals("1"))
	{
	    compCode = pthCtrl.getGLOBAL_COMP_CIF();
	    branchCode = BigDecimal.ONE;
	}
	else
	{
	    compCode = sessionCO.getCompanyCode();
	    branchCode = sessionCO.getBranchCode();
	}

	menuSc.setCompCode(compCode);
	menuSc.setBranchCode(branchCode);
	menuSc.setUsrName(returnUserName());
	menuSc.setLanguage(sessionCO.getLanguage());
	menuSc.setProfType(NumberUtil.nullToZero(pthCtrl.getPOP_PROF_MOD_ACCESS()));
	/**
	 * [MarwanMaddah]:check if the application is WEB & PB in this case we
	 * will exclude the parameters section menu from the menu list
	 */
	S_APPVO sAppVO = new S_APPVO();
	sAppVO.setAPP_NAME(appName);
	sAppVO = returnCommonLibBO().returnApplication(sAppVO);
	menuSc.setWebPbVersion(NumberUtil.nullToZero(sAppVO.getIS_WEB_YN()));
	/*
	 * if(appName.equals(ConstantsCommon.SADS_APP_NAME)) { menuData = new
	 * ArrayList<MenuVO>(); MenuVO menuVO;
	 * if(ConstantsCommon.PROGREF_ROOT.equals(menuId)) { menuVO = new
	 * MenuVO(); menuVO.setMenuName("Profile");
	 * menuVO.setMenuVar("profile"); menuData.add(menuVO);
	 * 
	 * menuVO = new MenuVO(); menuVO.setMenuName("Profile Model");
	 * menuVO.setMenuVar("profileModel"); menuData.add(menuVO); } else
	 * if("profile".equals(menuId)) { menuVO = new MenuVO();
	 * menuVO.setMenuName("Profile Maintenance");
	 * menuVO.setMenuVar("profileMaint");
	 * menuVO.setOnLeafClick("addMenuTab('profileMaint','Profile Maintenance')"
	 * ); menuVO.setLeaf(true); menuData.add(menuVO);
	 * 
	 * } else if("profileModel".equals(menuId)) { menuVO = new MenuVO();
	 * menuVO.setMenuName("Profile Model Maintenance");
	 * menuVO.setMenuVar("profileModelMaint"); menuVO.setLeaf(true);
	 * menuVO.setOnLeafClick
	 * ("addMenuTab('profileModelMaint','Profile Model Maintenance')");
	 * menuData.add(menuVO); } } else {
	 */

	menuData = new ArrayList<MenuVO>();
	BigDecimal categ_menu = sAppVO.getMENU_SHOW_MODE();
	// for menu based on categories, later all should be moved to
	// Categorised menus
	if(ConstantsCommon.CATEGORIZED_MENU_MODE.equals(categ_menu))
	{
	    // set indicator that menu is categorised
	    menuSc.setCategId(BigDecimal.ONE);
	    if(ConstantsCommon.PROGREF_ROOT.equals(menuId))
	    {
		menuData = menuBO.returnCategMenuAndOpts(menuSc);
	    }
	    else
	    {
		if(menuId.startsWith("_CATEG_"))
		{
		    BigDecimal catgId = new BigDecimal(menuId.split("_CATEG_")[1]);
		    menuSc.setProgGateg(catgId);
		    // menuSc.setCategId(catgId);
		    // menuData = menuBO.returnCategMenuAndOpts(menuSc);
		}
		// if reporting application and not category being opened
		if(ConstantsCommon.REP_APP_NAME.equals(appName) && menuSc.getProgGateg() == null)
		{
		    menuData = returnRepSpecificMenu(menuId, menuSc, pthCtrl);
		}
		else
		{
		    // TP 57949 CIHAN CBR170133 Reports Ordering By Name
		    applyOrdering(menuSc,pthCtrl);
		    menuData = menuBO.getMenu(menuSc);
		}

	    }
	}
	else
	{
	    if(ConstantsCommon.REP_APP_NAME.equals(appName))
	    {
		menuData = returnRepSpecificMenu(menuId, menuSc, pthCtrl);
	    }
	    else
	    {
		// TP 57949 CIHAN CBR170133 Reports Ordering By Name
		applyOrdering(menuSc,pthCtrl);
		menuData = menuBO.getMenu(menuSc);
	    }
	}
	return menuData;
    }
    /**
     * apply ordering or REports Menu
     * @param menuSc
     * @param pthCtrl
     */
    private void applyOrdering(MenuSC menuSc, PTH_CTRLVO pthCtrl)
    {
	if((ConstantsCommon.REPORTS_OPT.equals(menuSc.getProgRef())
		|| ConstantsCommon.REPORTS_OPT1.equals(menuSc.getProgRef())
		|| ConstantsCommon.REPORTS_OPT2.equals(menuSc.getProgRef())
		|| ConstantsCommon.REPORTS_OPT3.equals(menuSc.getProgRef())
		|| ConstantsCommon.REPORTS_OPT4.equals(menuSc.getProgRef())
		|| ConstantsCommon.ONE.equals(enableReportOrdering)) && ConstantsCommon.ONE.equals(pthCtrl.getREPORT_ORDERING()))
	{
	    enableReportOrdering = ConstantsCommon.ONE ;
	    menuSc.setReportOrdering(enableReportOrdering);
	}
    }

    /**
     * return REporting Application Specific Menu Details
     * 
     * @param menuId
     * @param menuSc
     * @return
     * @throws BaseException
     */
    private Collection<MenuVO> returnRepSpecificMenu(String menuId, MenuSC menuSc,PTH_CTRLVO pthCtrl) throws BaseException
    {
	Collection<MenuVO> menuData;
	String appName;
	if(ConstantsCommon.REPORTS_OPT.equals(menuId))
	{
	    menuData = menuBO.returnReportsApps(menuSc);
	}
	else
	{
	    if(menuId.endsWith("_" + ConstantsCommon.REPORTS_OPT))
	    {
		//every report/menu under Reports in Reporting Module ,that contains report will end with R00, and will constitute of [AppName]_[ProgRef]_R00, so need to extract the appName and progRef
		String appNameAndProgRef = menuId.substring(0, menuId.lastIndexOf("_" + ConstantsCommon.REPORTS_OPT));
		int indxOf_ =  appNameAndProgRef.indexOf("_");
		appName = appNameAndProgRef;
		// specify ROOT progRef to return all application menu when Application is clicked under Reports
		String progRef = ConstantsCommon.PROGREF_ROOT;
		if(indxOf_ > 0)
		{
		    appName = appNameAndProgRef.substring(0, indxOf_);
		    progRef = appNameAndProgRef.substring(indxOf_+1);
		}
		menuSc.setProgRef(progRef);
		menuSc.setAppName(appName);
		/*
		 * since an application under Reports Menu of Reporting
		 * Application is chosen then add check flag to use in SQL, to construct different menuVar
		 */
		menuSc.setCheckRepReportsMenu(1);
		if(ConstantsCommon.SADS_APP_NAME.equals(appName))
		{
		    menuSc.setCompCode(BigDecimal.ZERO);
		    menuSc.setBranchCode(BigDecimal.ZERO);
		}
		// TP 57949 CIHAN CBR170133 Reports Ordering By Name
		enableReportOrdering = ConstantsCommon.ONE ;
	    }

	    // TP 57949 CIHAN CBR170133 Reports Ordering By Name
	    if(ConstantsCommon.ONE.equals(enableReportOrdering) && ConstantsCommon.ONE.equals(pthCtrl.getREPORT_ORDERING()))
	    {
		enableReportOrdering = ConstantsCommon.ONE ;
		menuSc.setReportOrdering(enableReportOrdering);
	    }
	    menuData = menuBO.getMenu(menuSc);
	    // check if menu is ROOT and Reports OPT available and there is no reports under it, then need to check if applications exists under it to make it as root menu.
	    if(ConstantsCommon.PROGREF_ROOT.equals(menuId) )
	    {
		for(Iterator<MenuVO> iterator = menuData.iterator(); iterator.hasNext();)
		{
		   MenuVO menuVO = iterator.next();
		   if(ConstantsCommon.REPORTS_OPT.equals(menuVO.getMenuVar())
			   && menuVO.isLeaf() && !menuBO.returnReportsApps(menuSc).isEmpty())
		   {
		       menuVO.setLeaf(false);
		       break;
		   }
		    
		}
	    }
	}
	return menuData;
    }

    /**
     * 
     * Used for construct static Categories of menu
     * 
     * @param menuId
     * @param menuSc
     * @return
     * @throws BaseException
     */
   /* private Collection<MenuVO> returnStaticCategoryMenus(String menuId, MenuSC menuSc) throws BaseException
    {
	Collection<MenuVO> menuData;
	if("temp_reports".equals(menuId))
	{
	    menuSc.setProgRef("R000");// for Reports OPT
	}
	else if("temp_cust_operations".equals(menuId) || "temp_teller_operations".equals(menuId))
	{

	    BigDecimal menuCategory = new BigDecimal(11);// Teller Operation
	    if("temp_cust_operations".equals(menuId))
	    {
		menuCategory = new BigDecimal(10);
	    }
	    menuSc.setProgGateg(menuCategory);
	    menuSc.setProgRef("ROOT");// ROOT menu for specific Categories
	}
	menuData = menuBO.getMenu(menuSc);// Menu With Category
	return menuData;
    }*/	

    public String getMenuId()
    {
	return menuId;
    }

    public void setMenuId(String menuId)
    {
	this.menuId = menuId;
    }

    @Override
    public String getMenuVar()
    {
	return menuVar;
    }

    @Override
    public void setMenuVar(String menuVar)
    {
	this.menuVar = menuVar;
    }

    public String getActionUrl()
    {
	return actionUrl;
    }

    public void setActionUrl(String actionUrl)
    {
	this.actionUrl = actionUrl;
    }

    public void setNameSpacePath(String nameSpacePath)
    {
	this.nameSpacePath = nameSpacePath;
    }

    public String getNameSpacePath()
    {
	return nameSpacePath;
    }

    public String getAp_n()
    {
	return ap_n;
    }

    public void setAp_n(String apN)
    {
	ap_n = apN;
    }


    public void setAd_p(String ad_p)
    {
        this.ad_p = ad_p;
    }


    public String getExtAppURL()
    {
        return extAppURL;
    }


    public void setExtAppURL(String extAppURL)
    {
        this.extAppURL = extAppURL;
    }


    /**
     * @return the extAppName
     */
    public String getExtAppName()
    {
        return extAppName;
    }


    /**
     * @param extAppName the extAppName to set
     */
    public void setExtAppName(String extAppName)
    {
        this.extAppName = extAppName;
    }


    /**
     * @return the extProgRef
     */
    public String getExtProgRef()
    {
        return extProgRef;
    }


    /**
     * @param extProgRef the extProgRef to set
     */
    public void setExtProgRef(String extProgRef)
    {
        this.extProgRef = extProgRef;
    }


    public String getAd_p()
    {
        return ad_p;
    }
}