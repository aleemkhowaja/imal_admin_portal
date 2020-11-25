package com.path.struts2.lib.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.path.bo.common.BaseServices;
import com.path.bo.common.CachedConstantsCommon;
import com.path.bo.common.CommonLibBO;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.SYS_PARAM_BTN_CUSTVO;
import com.path.dbmaps.vo.SYS_PARAM_OBJ_DETAILS_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_OBJ_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ELEMENTSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ENTITY_TYPEVO;
import com.path.lib.common.base.BaseServicesImpl;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.AdditionalFlagsCO;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.ScreenElementsMapCO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.CustomElementActivitiesSC;
import com.path.vo.common.customization.button.ButtonCustomizationCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.customization.button.ButtonCustomizationSC;
import com.path.vo.common.customization.button.CustomActionParamCO;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapSC;

public final class RootUtil
{
    private final static String noFormat = "false";
    private final static String groupSepa = ",";
    private final static String decimalSepa = ".";
    public static final String SUBMIT_ELEM_TYPE = "1";
    public static final String LABEL_ELEM_TYPE = "2";
    public static final String ANCHOR_ELEM_TYPE = "3";
    public static final String TAB_ELEM_TYPE = "4";
    public static final String COLLAPS_ELEM_TYPE = "5";
    /**
     * Private constructor only to prevent instantiation in the class
     */
    private RootUtil()
    {
	Log.getInstance().error("This Class Should not be Instantiated");
    }
    /**
     * Sets the nbFormat and noFormat value according to the format set in USM
     * 
     * @param theNbFormat String
     * @param theNoFormat String
     * @param numberFormats HashMap
     */
    public static HashMap manageNumberFormat(String theNbFormat, String theNoFormat, HashMap numberFormats)
    {

	HashMap formats = new HashMap();
	String nbFormat = theNbFormat;
	String noNbFormat = theNoFormat;
	if(numberFormats == null)
	{
	    formats.put("noFormat", noNbFormat);
	    formats.put("nbFormat", nbFormat);
	    formats.put("decimalSepa", decimalSepa);
	    formats.put("groupSepa", groupSepa);
	}
	else
	{
	    Object tmpObj = null;
	    if(nbFormat == null)
	    {
		tmpObj = numberFormats.get("default");
		if(tmpObj == null)
		{
		    nbFormat = "#,###.0#";
		}
		else
		{
		    nbFormat = (String) tmpObj;
		}
	    }
	    else
	    {
		if(nbFormat.indexOf("#") == -1 && nbFormat.indexOf("0") == -1)
		{
		    tmpObj = numberFormats.get(nbFormat);
		    if(tmpObj == null)
		    {
			tmpObj = numberFormats.get("default");
			if(tmpObj == null)
			{
			    nbFormat = "#,###.0#";
			}
			else
			{
			    nbFormat = (String)tmpObj;
			}
		    }
		    else
		    {
			nbFormat = (String) tmpObj;
		    }
		}
	    }
	    if(noNbFormat == null)
	    {
		noNbFormat = "false";
	    }
	    formats.put("noFormat", noNbFormat);
	    formats.put("nbFormat", nbFormat);
	    formats.put("decimalSepa", StringUtil.nullEmptyToValue(numberFormats.get("decimalSepa"), decimalSepa));
	    formats.put("groupSepa", StringUtil.nullEmptyToValue(numberFormats.get("groupSepa"), groupSepa));
	}
	return formats;
    }

    /**
     * Sets the numberFormats hashMap from the session and if it is null in the
     * session set noFormat and nbFormat by the default values
     * 
     * @param pageContext
     * @return
     */
    public static HashMap returnNumberFormat(HttpSession session)
    {
	HashMap numberFormats = new HashMap();
	Object numFormatObj = null;
	SessionCO sesCO = (SessionCO) session.getAttribute(ConstantsCommon.SESSION_VO_ATTR);
	if(sesCO != null && sesCO.getUserNbFormats() != null)
	{
	    numFormatObj = sesCO.getUserNbFormats();
	}

	if(numFormatObj == null)
	{
	    numberFormats.put("noFormat", noFormat);
	    numberFormats.put("groupSepa", groupSepa);
	    numberFormats.put("decimalSepa", decimalSepa);
	    numberFormats.put(DateUtil.DATE_MASK_ATTRIBUTE, DateUtil.DEFAULT_DATE_FORMAT);
	}
	else
	{
	    numberFormats = (HashMap) numFormatObj;
	}
	return numberFormats;
    }

    /**
     * Returns the date mask in the pagecontext for the logged in user. If there
     * is no date mask then the default date mask will be returned.
     * 
     * @param pageContext
     * @return String
     */
    public static String returnDateMask(HttpSession session)
    {
	Map userFormats = RootUtil.returnNumberFormat(session);
	String serverDateFormat = DateUtil.returnDateFormat(userFormats);
	// replacing the server format with characters accepted by Jquery
	// DatePicker
	serverDateFormat = serverDateFormat.split(" ")[0];
	String clientFormat = serverDateFormat.replace("MM", "mm");
	if(clientFormat.indexOf("yyyy") >= 0)
	{
	    clientFormat = clientFormat.replace("yyyy", "yy");
	}
	else
	{
	    clientFormat = clientFormat.replace("yy", "y");
	}
	return clientFormat;
    }

    /**
     * Returns the date mask according to the grid fmatter.js for displaying
     * formatted date on retrieved records
     * 
     * @param pageContext
     * @return String
     */
    public static String returnGridDateMask(HttpSession session)
    {
	Map userFormats = RootUtil.returnNumberFormat(session);
	String serverDateFormat = DateUtil.returnDateFormat(userFormats);
	// replacing the server format with characters accepted by Jquery grid
	serverDateFormat = serverDateFormat.split(" ")[0];
	String clientFormat = serverDateFormat.replace("MM", "m");
	clientFormat = clientFormat.replace("dd", "d");
	if(clientFormat.indexOf("yyyy") >= 0)
	{
	    clientFormat = clientFormat.replace("yyyy", "Y");
	}
	else
	{
	    clientFormat = clientFormat.replace("yy", "y");
	}
	return clientFormat;
    }

    /**
     * Used for returning a tooltip of Particular Field/Element control on
     * Screen
     * 
     * @param request
     * @param elementName
     * @param ElementId
     * @return toolTIp
     */
    public static String returnFieldToolTip(HttpServletRequest request, String elementName, String elemId)
    {
	return returnFieldToolTip(request, elementName, elemId, null);
    }
    
    /**
     * TP #945072 - Adding tooltip option via SYS_PARAM_SCREEN_DISPLAY_VO
     * Used for returning a tooltip of Particular Field/Element control on Screen if the tooltip not exist in theVO
     * @param request
     * @param elementName
     * @param elemId
     * @param theVO
     * @return
     * @author HusseinZaraket
     */
    public static String returnFieldToolTipWithCustomization(HttpServletRequest request, String elementName, String elemId, SYS_PARAM_SCREEN_DISPLAYVO theVO)
    {
    	if(null != theVO && null != theVO.getTooltip()) 
    	{
    		return theVO.getTooltip();
    	}
    	return returnFieldToolTip(request, elementName, elemId, null);
    }

    /**
     * 
     * Used for returning a tooltip of Particular Field/Element control on
     * Screen
     * 
     * @param request
     * @param elementName
     * @param ElementId
     * @param element Type
     * @return
     */
    public static String returnFieldToolTip(HttpServletRequest request, String elementName, String elemId,
	    String elemType)
    {
	String currToolTip = null;
	// if tooltip not found in DB then put Element name and Id as ToolTip,
	// if Translation of tooltip Enabled
	if(currToolTip == null && 1 == ConstantsCommon.ENABLE_TOOLTIP_TRANS)
	{
	    BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	    SessionCO sesCO = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
	    // same SC that used in Required Fields is suitable here since it
	    // contains all Fields
	    RequiredFieldsSC criteria = new RequiredFieldsSC();
	    criteria.setAppName(sesCO.getCurrentAppName());
	    String pageRef = request.getParameter("_pageRef");
	    criteria.setProgRef(pageRef);
	    criteria.setLoginUserId(sesCO.getUserName());
	    criteria.setLangCode(sesCO.getLanguage());
	    // set Element Id after removing progRef from it if Exists
	    String currElId = (pageRef == null || elemId == null ? elemId  :(elemId.endsWith("_" + pageRef) ? elemId.substring(0, elemId
		    .lastIndexOf("_" + pageRef)) : elemId));
	    criteria.setElementId(currElId);
	    criteria.setElementName(elementName == null?currElId:elementName);
	    currToolTip = baseAction.returnToolTipTrans(criteria);

	}
	return currToolTip;
    }

    /**
     * 
     * Used for Dynamic Screen Display with element Type providing so that in
     * case of submit default readonly will not be applied
     * 
     * @param request
     * @param elementName
     * @return
     */
    public static SYS_PARAM_SCREEN_DISPLAYVO returnParamScreenDisplay(HttpServletRequest request, String elementName,
	    String elemId, String elemType)
    {
	SYS_PARAM_SCREEN_DISPLAYVO sysParamScreenDisplayVO = null;
	// SYS_PARAM_SCREEN_DISPLAYVO sysParamScreenDisplayVOFromHm = null;
	String[] propArr = null;
	if(elementName!=null)
	{
	    propArr = elementName.split("\\."); 
	}
	
	Object obj = null;
	if(propArr!=null && propArr.length > 0 && !"propertiesValMap".equals(propArr[0]))
	{
	    obj = request.getAttribute(propArr[0]);
	}
	    
	if("1".equals(CachedConstantsCommon.apply_dynamic_screen))
	{
	    BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext().getBean(
		    "baseServices");
	    RequiredFieldsSC criteria = new RequiredFieldsSC();
	    SessionCO sesCO = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
	    BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	    
	    //TP 1044445 fill the object to be the related screen data, in case not already taken from request attribute.
	    if(obj == null)
	    {
		// this custom object need to be set by DEV in the Action Class
		obj = baseAction.getCustomModelObj();
		if(obj == null)
		{
		    // read the standard Model attribute set in the Action if any.
		    obj = baseAction.getModel();
		}
	    }
	    /*
	     * variable from BaseAction Class on which the Dynamic details will
	     * be dependent on if this variable true then if there is specific
	     * progref in SREEEN_DEISPLAY table it will be considered otherwise
	     * readonly will be true for the element (parent progref not
	     * considered) if this variable is false then specific prog ref will
	     * be considered , if not available then parent progref will be
	     * considered
	     */
	    String _recReadOnly = StringUtil.nullToEmpty(baseAction.get_recReadOnly());
	    String _ignoreSpecificMenu = StringUtil.nullToEmpty(baseAction.get_ignoreSpecificMenu());
	    String pageRef = request.getParameter("_pageRef");
	    
	    String currElId = null;
	    if(elemId != null)
	    {
		currElId = (pageRef == null ? elemId:(elemId.endsWith("_" + pageRef) ? elemId.substring(0, elemId
			.lastIndexOf("_" + pageRef)) : elemId));
	    }
	    /**
             * To get the customization in case are defined from alert screen   
             */
	    // ALERTS. If pageRef ends with _ALERT, then we should remove
	    // the suffix "_ALERT"
	    boolean fromAlert = false;
	    if(pageRef != null && pageRef.endsWith("_ALERT"))
	    {
		fromAlert = true;
		pageRef = pageRef.substring(0, pageRef.indexOf("_ALERT"));
	    }
	    
            /**
             * [MarwanMaddah]: in case the progRef is empty, so it is a common screen(labeling, running date, saveAs....) 
             * in this case we will get the display information based on SETTINGS_CONFIG_OPT
             */
	    if(StringUtil.nullToEmpty(pageRef).isEmpty())
            {
        	pageRef = ConstantsCommon.SETTINGS_CONFIG_OPT;
            }

	    // if not found by element Name in AdditionalScreenParams Map then
	    // try by Id after removing _pageRef if Exists
	    if(elemId != null)
	    {
		sysParamScreenDisplayVO = baseAction.getAdditionalScreenParams().get(currElId);
	    }
	    // check if VO in additional elements hm first this will overwrite
	    // database details
	    if(sysParamScreenDisplayVO == null)
	    {
		sysParamScreenDisplayVO = baseAction.getAdditionalScreenParams().get(elementName);
	    }
	    
	    boolean busRelated = false;
	    if(sysParamScreenDisplayVO != null)
	    {
		busRelated = true;
	    }

	    String progRef = pageRef;
	    // do not proceed to the service layer if element is label or Anchor
	    /**
	     * the checking on company code has been added to avoid the entrance on display management 
	     * on login screen 
	     */
	    if((!busRelated || ConstantsCommon.APPLY_DYN_EXPRESSION) && sesCO != null && sesCO.getCompanyCode()!=null && pageRef != null && !LABEL_ELEM_TYPE.equals(elemType) 
		    && !ANCHOR_ELEM_TYPE.equals(elemType))
	    {
		String trxType = request.getParameter("trxType");
		BigDecimal windTrxType = (BigDecimal) request.getAttribute("dynamicTrxType");
		if(progRef.isEmpty())
		{
		    Log.getInstance().error(
			    "progRef Recieving Null value (_pageRef attribute) to returnParamScreenDisplay Root Util");
		}
		// ALERTS. If ALERTS pageRef, then we should remove
		// the suffix "_ALERT"
		if(fromAlert && progRef.endsWith("_ALERT"))
		{
		    progRef = progRef.substring(0, progRef.indexOf("_ALERT"));
		}
		criteria.setElementName(elementName);
		if(elemId!=null && elemId.equals(elementName))
		{
		     criteria.setElementName(currElId);
		}
		criteria.setAppName(sesCO.getCurrentAppName());
		criteria.setProgRef(progRef);
		criteria.setCompCode(sesCO.getCompanyCode());
		criteria.setLoginUserId(sesCO.getUserName());
		
		// in case of Expression the following values could be used
		criteria.setBranchCode(sesCO.getBranchCode());
		criteria.setBranchName(sesCO.getBranchName());
		criteria.setCompanyName(sesCO.getCompanyName());
		criteria.setUserFirstName(sesCO.getUserFirstName());
		criteria.setUserLastName(sesCO.getUserLastName());
		criteria.setBaseCurrencyName(sesCO.getBaseCurrencyName());
		if(sesCO.getCtsTellerVO() != null && sesCO.getCtsTellerVO().getCODE() !=null)
		{
		    criteria.setIsTeller(BigDecimal.ONE);
		}
		
		
		if(StringUtil.isNotEmpty(trxType) || NumberUtil.emptyDecimalToNull(windTrxType) != null)
		{
		    if(StringUtil.isNotEmpty(trxType))
		    {
			criteria.setTrxType(new BigDecimal(trxType));
		    }
		    else
		    {
			criteria.setTrxType(windTrxType);
		    }

		    String trsNo = request.getParameter("trsNo");
		    String cbInd = request.getParameter("cbInd");
		    String branchCode = request.getParameter("branchCode");
		    String trsType = request.getParameter("trsType");
		    String cifNo = request.getParameter("cifNo");
		    String requiredDataByCifNoOnly = request.getParameter("requiredDataByCifNoOnly");
		    if(!StringUtil.nullToEmpty(trsNo).isEmpty())
		    {
			criteria.setTrsNo(new BigDecimal(trsNo));
		    }
		    if(!StringUtil.nullToEmpty(branchCode).isEmpty())
		    {
			criteria.setBranchCode(new BigDecimal(branchCode));
		    }
		    if(!StringUtil.nullToEmpty(cbInd).isEmpty())
		    {
			criteria.setCbInd(cbInd);
		    }
		    if(!StringUtil.nullToEmpty(trsType).isEmpty())
		    {
			criteria.setTrsType(trsType);
		    }
		    if(!StringUtil.nullToEmpty(cifNo).isEmpty())
		    {
			criteria.setCifNo(new BigDecimal(cifNo));
		    }
		    if(!StringUtil.nullToEmpty(requiredDataByCifNoOnly).isEmpty())
		    {
			criteria.setRequiredDataByCifNoOnly(Boolean.valueOf(requiredDataByCifNoOnly));
		    }
		}
		try
		{
		    List<SYS_PARAM_SCREEN_ENTITY_TYPEVO> entityTypeInfosLst = new ArrayList<SYS_PARAM_SCREEN_ENTITY_TYPEVO>();
		    SYS_PARAM_SCREEN_ENTITY_TYPEVO sysParamScreenEntityType = new SYS_PARAM_SCREEN_ENTITY_TYPEVO();
		    sysParamScreenEntityType.setAPP_NAME(criteria.getAppName());
		    sysParamScreenEntityType.setPROG_REF(criteria.getProgRef());
		    entityTypeInfosLst = baseAction.returnScreenEntityTypeInfos(sysParamScreenEntityType);
		    /**
		     * [MarwanMaddah]: in case there is entity type related to the loaded progref
		     * we will get the entity type from the table and get the related value from the request and 
		     * and add it in the criteria
		     */
		    String entityCode;
		    if(entityTypeInfosLst!=null && entityTypeInfosLst.size() > 0)
		    {
			   Map<String,Object> entityTypeInfosMap = new HashMap<String,Object>(); 
			   for(SYS_PARAM_SCREEN_ENTITY_TYPEVO currEntityTypeCO:entityTypeInfosLst)
			   {
			        entityCode = request.getParameter(currEntityTypeCO.getPROPERTY_NAME());
				if(!StringUtil.nullToEmpty(entityCode).isEmpty())
				{
				    // TP 771818
				    String propDataType = StringUtil.nullToEmpty(currEntityTypeCO.getPROPERTY_DATA_TYPE());
				    if(ConstantsCommon.DATA_TYPE_ENTITY_VARCHAR.equalsIgnoreCase(propDataType))
				    {
				      entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(), entityCode);
				    }
				    else if(ConstantsCommon.DATA_TYPE_ENTITY_DATE.equalsIgnoreCase(propDataType) || ConstantsCommon.DATA_TYPE_ENTITY_DATETIME.equalsIgnoreCase(propDataType))
				    {
					try
					{
					    entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(), DateUtil.returnDateObj(entityCode, ActionContext.getContext().getContextMap()));
					}
					catch(Exception e)
					{
					    Log.getInstance().warning("ERROR Not able to parse the date value entityCode = "+entityCode+" to any format setting currEntityTypeCO.getENTITY_TYPE() to null");	
					    entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(),null);
					}
				    }
				    else
				    {
					 entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(), new BigDecimal(entityCode));
				    }
				}
				else
				{
				    entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(),null);
				}			       
			   }
			   if(!entityTypeInfosMap.isEmpty())
			   {
			       criteria.setEntityTypeInfosMap(entityTypeInfosMap);
			   }
		    }
		    /**
		     * [MarwanMaddah]: In case the progReg is equals to SETTINGS_CONFIG_OPT, so it is mean the request is from translation management 
		     * for that will the element name by the element Id to get the value from the cached hashmap.
		     */
                    if(ConstantsCommon.SETTINGS_CONFIG_OPT.equals(criteria.getProgRef()) && StringUtil.nullToEmpty(criteria.getElementName()).isEmpty())
                    {
                	criteria.setElementName(elemId);
                    }
                    if(obj!=null)
            	    {
            	      criteria.setScreenObject(obj); 
            	    }
                    else
                    {
                      criteria.setScreenObject(new HashMap());
                    }
                    /**
                     * [MarwanMaddah]:
                     * in case the flag is TRUE , so the expression process should be taken into consideration
                     * for that from here the applyExpression flag should be sent true and from business side will be sent as FALSE
                     * to apply the expressions here and then will apply the strongest concept
                     * based on the strong values that will be defined as constants.   
                     */
                    if(ConstantsCommon.APPLY_DYN_EXPRESSION)
                    {
                	AdditionalFlagsCO additionalFlagsCO = new AdditionalFlagsCO();
                	additionalFlagsCO.setApplyExpression(Boolean.TRUE);
                	SYS_PARAM_SCREEN_DISPLAYVO sysParamWithExpressionVO = new SYS_PARAM_SCREEN_DISPLAYVO();
                	sysParamWithExpressionVO = (SYS_PARAM_SCREEN_DISPLAYVO) baseServices.returnCommonLibBO().returnRequiredData(criteria,additionalFlagsCO);
                	if(sysParamWithExpressionVO!=null)
                	{
                	    if(sysParamScreenDisplayVO == null)
                	    {
                		sysParamScreenDisplayVO = sysParamWithExpressionVO; 
                	    }
                	    else
                	    {
                		if(sysParamScreenDisplayVO.getIS_MANDATORY()!=null && !ConstantsCommon.REQUIRED_STRONG_VALUE.equals(sysParamScreenDisplayVO.getIS_MANDATORY()))
                		{
                		    applyStrongestManagement(sysParamScreenDisplayVO,sysParamWithExpressionVO);
                		}
                	    }                	    
                	}
                    }
                    else
                    {                	
                	sysParamScreenDisplayVO = (SYS_PARAM_SCREEN_DISPLAYVO) baseServices.returnCommonLibBO().returnRequiredData(criteria);
                    }
		    // overwrite according to _recReadOnly parameter, check
		    // comments above
		    if(sysParamScreenDisplayVO != null 
		       && "true".equals(_recReadOnly)// check if not specific progref or from Alert then make readonly 
		       && (fromAlert 
			   || !progRef.equals(sysParamScreenDisplayVO.getPROG_REF()) 
			   || (progRef.equals(sysParamScreenDisplayVO.getPROG_REF()) && "true".equals(_ignoreSpecificMenu)))
		       && !SUBMIT_ELEM_TYPE.equals(elemType)
		       && !COLLAPS_ELEM_TYPE.equals(elemType))
		    {
			sysParamScreenDisplayVO.setIS_READONLY(BigDecimal.ONE);
		    }
		}
		catch(BaseException e)
		{
		    Log.getInstance().error(e, "Error in retrieving requiredData for tag");
		}
	    }
	    
	    
	    
	    
	    if("true".equals(_recReadOnly))
	    {
		// if business related ,
		// and no overwrite to readonly Flag done, and if no overwrite
		// of SMART readonly applied
		// then readonly will be applied if _recReadonly true, and not
		// specific progref and not button
		if(busRelated)
		{
		    /**
		     * in case the current progRef is saved from saveAS process, 
		     * the comparison should be done based on the original progRef.
		     */
		    String orginalProgRef = null;
		    try
		    {
			orginalProgRef = baseServices.returnCommonLibBO().returnOrginProgRef(sesCO.getCurrentAppName(), progRef);
		    }
		    catch(BaseException e)
		    {
			Log.getInstance().error(e, "Error in retrieving the Original prog ref");
		    }
		    if(( // check if overwrite flag not specified (null or false
			 // value)
		    sysParamScreenDisplayVO.getOverWriteReadOnly() == null || (sysParamScreenDisplayVO
			    .getOverWriteReadOnly() != null && !sysParamScreenDisplayVO.getOverWriteReadOnly()
			    .booleanValue()))
			    // check Specific Prog REf or from Alert
			    && (fromAlert || (orginalProgRef != null && !orginalProgRef.equals(sysParamScreenDisplayVO.getPROG_REF())))
			    // check if not button
			    && (elemType == null || (!SUBMIT_ELEM_TYPE.equals(elemType) && !TAB_ELEM_TYPE.equals(elemType) && !COLLAPS_ELEM_TYPE.equals(elemType))))
		    {
			sysParamScreenDisplayVO.setIS_READONLY(BigDecimal.ONE);
		    }
		}
		else
		{
		    // if screen flag is readonly and no element exits in DB
		    // table then put readonly
		    // but not for submit buttons
		    if(sysParamScreenDisplayVO == null && (elemType == null || (!SUBMIT_ELEM_TYPE.equals(elemType) && !TAB_ELEM_TYPE.equals(elemType) && !COLLAPS_ELEM_TYPE.equals(elemType))))
		    {
			    sysParamScreenDisplayVO = new SYS_PARAM_SCREEN_DISPLAYVO();
			    sysParamScreenDisplayVO.setIS_READONLY(BigDecimal.ONE);
		    }
		}
	    }

	}
	return sysParamScreenDisplayVO;
    }
    
    private static void applyStrongestManagement(SYS_PARAM_SCREEN_DISPLAYVO sysParamScreenDisplayVO, SYS_PARAM_SCREEN_DISPLAYVO sysParamWithExpressionVO)
    {
	    if(sysParamScreenDisplayVO == null)
	    {
		sysParamScreenDisplayVO = sysParamWithExpressionVO; 
	    }
	    else
	    {
		if(sysParamScreenDisplayVO.getIS_MANDATORY()!=null && !ConstantsCommon.REQUIRED_STRONG_VALUE.equals(sysParamScreenDisplayVO.getIS_MANDATORY()))
		{
		    if(sysParamWithExpressionVO.getIS_MANDATORY()!=null)
		    {
			sysParamScreenDisplayVO.setIS_MANDATORY(sysParamWithExpressionVO.getIS_MANDATORY());
		    }
		}
		if(sysParamScreenDisplayVO.getIS_READONLY()!=null && !ConstantsCommon.READONLY_STRONG_VALUE.equals(sysParamScreenDisplayVO.getIS_READONLY()))
		{
		    if(sysParamWithExpressionVO.getIS_READONLY()!=null)
		    {
			sysParamScreenDisplayVO.setIS_READONLY(sysParamWithExpressionVO.getIS_READONLY());
		    }
		}
		if(sysParamScreenDisplayVO.getIS_VISIBLE()!=null && !ConstantsCommon.VISIBLE_STRONG_VALUE.equals(sysParamScreenDisplayVO.getIS_VISIBLE()))
		{
		    if(sysParamWithExpressionVO.getIS_VISIBLE()!=null)
		    {
			sysParamScreenDisplayVO.setIS_VISIBLE(sysParamWithExpressionVO.getIS_VISIBLE());
		    }
		}
		if(sysParamScreenDisplayVO.getDEFAULT_VALUE()==null || (BigDecimal.ONE.equals(sysParamScreenDisplayVO.getDFLT_VAL_EXPR_PRIORITY_YN()) && sysParamWithExpressionVO.getDEFAULT_VALUE()!=null))
		{
		    sysParamScreenDisplayVO.setDEFAULT_VALUE(sysParamWithExpressionVO.getDEFAULT_VALUE());
		}
	    }                	    
    }
    /**
     * This function is used to return the list of custom button defined for a specific progRef and a specific toolbarId.
     * in case the toolbarId is null the returned button will be added to the existing toolbar in the screen. 
     * @param pageRef
     * @param toolbarId
     * @return
     */
    public static List<SYS_PARAM_BTN_CUSTVO> returnToolBarButtonCust(HttpServletRequest request, String pageRef, String toolbarId)
    {
	if(StringUtil.isNotEmpty(pageRef))
	{
	    try
	    {
		BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext().getBean(
			"baseServices");
		BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
		SessionCO sesCO = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
		//get session Variables
		RequiredFieldsSC requiredFieldsSC   = new RequiredFieldsSC();
		requiredFieldsSC.setAppName(sesCO.getCurrentAppName());
		requiredFieldsSC.setProgRef(pageRef);
		requiredFieldsSC.setLoginUserId(sesCO.getUserName());
		requiredFieldsSC.setCompCode(sesCO.getCompanyCode());
		requiredFieldsSC.setCompanyName(sesCO.getCompanyName());
		requiredFieldsSC.setBranchCode(sesCO.getBranchCode());
		requiredFieldsSC.setBranchName(sesCO.getBranchName());
		requiredFieldsSC.setUserFirstName(sesCO.getUserFirstName());
		requiredFieldsSC.setUserLastName(sesCO.getUserLastName());
		requiredFieldsSC.setBaseCurrencyName(sesCO.getBaseCurrencyName());
		if(null != sesCO.getCtsTellerVO()) 
		{
		    requiredFieldsSC.setIsTeller(BigDecimal.ONE);
		}else 
		{
		    requiredFieldsSC.setIsTeller(BigDecimal.ZERO);
		}
		requiredFieldsSC.setRunningDate(sesCO.getRunningDateRET());
		//Add session variables
		List<Map<String, Object>> currMap = CommonMethods.returnBoolExpressionDataList(requiredFieldsSC);
		Map<String,Map<String, Object>>  variablesMap = new HashMap<String,Map<String, Object>>();
		Map<String, Object> sessionVariablesMap = new HashMap<String, Object>();
		for (Entry<String, Object> entry : currMap.get(0).entrySet()) 
		{
		    sessionVariablesMap.put("session."+entry.getKey(), entry.getValue());
		} 
		variablesMap.put("session", sessionVariablesMap);//contains screen parameters
		//add entity type
		List<SYS_PARAM_SCREEN_ENTITY_TYPEVO> entityTypeInfosLst = new ArrayList<SYS_PARAM_SCREEN_ENTITY_TYPEVO>();
		SYS_PARAM_SCREEN_ENTITY_TYPEVO sysParamScreenEntityType = new SYS_PARAM_SCREEN_ENTITY_TYPEVO();
		sysParamScreenEntityType.setAPP_NAME(requiredFieldsSC.getAppName());
		sysParamScreenEntityType.setPROG_REF(requiredFieldsSC.getProgRef());
		entityTypeInfosLst = baseAction.returnScreenEntityTypeInfos(sysParamScreenEntityType);
		String entityCode;
		Map<String,Object> entityTypeInfosMap = new HashMap<String,Object>();
		if(entityTypeInfosLst!=null && entityTypeInfosLst.size() > 0)
		{
		    for(SYS_PARAM_SCREEN_ENTITY_TYPEVO currEntityTypeCO:entityTypeInfosLst)
		    {
			entityCode = request.getParameter(currEntityTypeCO.getPROPERTY_NAME());
			String propDataType = StringUtil.nullToEmpty(currEntityTypeCO.getPROPERTY_DATA_TYPE());
			if(StringUtil.isNotEmpty(entityCode) && StringUtil.isNotEmpty(propDataType) )
			{
			    if(ConstantsCommon.DATA_TYPE_ENTITY_DATE.equalsIgnoreCase(propDataType) || ConstantsCommon.DATA_TYPE_ENTITY_DATETIME.equalsIgnoreCase(propDataType))
			    {
				try
				{
				    entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(), DateUtil.returnDateObj(entityCode, ActionContext.getContext().getContextMap()));
				}
				catch(Exception e)
				{
				    Log.getInstance().warning("ERROR Not able to parse the date value entityCode = "+entityCode+" to any format setting currEntityTypeCO.getENTITY_TYPE() to null");	
				    entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(),null);
				}
			    }
			    else if(ConstantsCommon.DATA_TYPE_ENTITY_VARCHAR.equalsIgnoreCase(propDataType))
			    {
				
				entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(),entityCode);
			    }
			    else
			    {
				entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(), new BigDecimal(entityCode));
			    }
			    
			}
			else
			{
			    entityTypeInfosMap.put(currEntityTypeCO.getENTITY_TYPE(),null);
			}			       
		    }  
		}
		variablesMap.put("entityType", entityTypeInfosMap);
		//return screen elements list
		Map<String, ScreenElementsMapCO> elementList =  baseServices.returnCommonLibBO().returnScreenElementsMap(requiredFieldsSC);
		//retrieve screen object CO from request
		Map<String,Object> elementObjList = new HashMap<String,Object>();
		for (Entry<String, ScreenElementsMapCO> entry : elementList.entrySet()) 
		{
		    String elementName = entry.getValue().getELEMENT_NAME();
		    String[] propArr = null;
		    if(elementName!=null)
		    {
			propArr = elementName.split("\\."); 
			if(elementObjList.containsKey(propArr[0]))
			{
			    continue;
			}
			Object obj = null;
			if(propArr!=null && propArr.length > 0 )
			{
			    obj = request.getAttribute(propArr[0]);	
			}
			elementObjList.put(propArr[0],obj);
		    }
		}
		return baseServices.returnCommonLibBO().returnToolBarButtonCust(pageRef, toolbarId, sesCO.getCurrentAppName(),variablesMap,elementObjList);
	    }
	    catch(BaseException e)
	    {
		Log.getInstance().error(e, "Error in retrieving the toolbar custom buttons");
	    }
	
	}
	return null;
    }
    
    /**
     * This function is used to return the HTML ELEMENT_IDs defined as mapping data of the custom buttons.
     * That means all the html elements id are returned to be evaluated when clicking the custom button.
     * @param btnId
     * @param mapType
     * @return
     */
    public static Map<String, Object> returnButtonCustActionData(HttpServletRequest request, BigDecimal btnId, boolean isGlobalActivity, SYS_PARAM_SCREEN_DISPLAYVO theVO) 
    {
	
	if(!NumberUtil.isEmptyDecimal(btnId))
	{
	    try
	    {
		 SessionCO sessionCO = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
		 String pageRef = request.getParameter("_pageRef");
			
                 if(StringUtil.isNotEmpty(pageRef) && pageRef.endsWith("_ALERT"))
                 {
                     pageRef = pageRef.substring(0, pageRef.lastIndexOf("_ALERT"));
                 }
		 
		 BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext().getBean(
		    "baseServices");
		 CommonLibBO commonLibBO = baseServices.returnCommonLibBO();
		 
		 // need to send original prog ref in case of Save AS since the original screen elements are defined in SYS_PARAM_SCREEN_ELEMENTS only
		 String theProgRef = commonLibBO.returnOrginProgRef(sessionCO.getCurrentAppName() ,pageRef);
		 
		 Map<BigDecimal, CustomActionParamCO> condDataMap = new HashMap<BigDecimal, CustomActionParamCO>();
		 Map<String, Object> customBtnDataMap = new HashMap<String, Object>();
		 customBtnDataMap.put("customBtnId", btnId);
		 
		 
		 ButtonCustomizationSC buttonCustomizationSC = new ButtonCustomizationSC();
		 buttonCustomizationSC.setButtonId(btnId);
		 buttonCustomizationSC.setProgRef(theProgRef);
		 buttonCustomizationSC.setOnBtnLoad("1");
		 buttonCustomizationSC.setShowArgDetails("1");
		 
		 if(isGlobalActivity)
		 {    
		     buttonCustomizationSC.setGlobalActivity(isGlobalActivity);
		     buttonCustomizationSC.setCurrAppName(sessionCO.getCurrentAppName());
		     if(theVO != null)
		     {		 
			 buttonCustomizationSC.setFldIdentifier(theVO.getFLD_IDENTIFIER());
			 buttonCustomizationSC.setBtnProgRef(theVO.getPROG_REF());
			 buttonCustomizationSC.setElemSequenceId(theVO.getElemSequenceId());
		     }
		 }
		 
		 if(request != null)
		 {
		     Object dynScreenId = request.getAttribute("DYNAMIC_SCREEN_ID");
		     Object dynElementId =request.getAttribute("DYNAMIC_ELEMENT_ID");
		     if(dynScreenId != null)
		     {
			 buttonCustomizationSC.setDynScreenId(new BigDecimal(dynScreenId.toString()));
		     }
		     if(dynElementId != null)
		     {
			 buttonCustomizationSC.setDynElementId(new BigDecimal(dynElementId.toString()));
		     }
		     request.removeAttribute("DYNAMIC_SCREEN_ID");
		     request.removeAttribute("DYNAMIC_ELEMENT_ID");
		 }
		 
		 ButtonCustomizationCO returnedButtonCustomizationCO = commonLibBO.returnButtonCustActionData(buttonCustomizationSC);
		 List<CustomActionParamCO> paramList = new ArrayList<CustomActionParamCO>(); 
		 if(returnedButtonCustomizationCO != null)
		 {
		     paramList.addAll(returnedButtonCustomizationCO.getCustomActionParamCOList());
		     
		     if(returnedButtonCustomizationCO.getGlobalOutputActionParamCOList() != null 
			     && !returnedButtonCustomizationCO.getGlobalOutputActionParamCOList().isEmpty())
		     {
			 customBtnDataMap.put("mappingOutputDataList", returnedButtonCustomizationCO.getGlobalOutputActionParamCOList());
		     }
		 }
		 
		 
		 if(paramList != null && !paramList.isEmpty())
		 {
		    List<CustomActionParamCO> mappingDataList = new ArrayList<CustomActionParamCO>();
		    List<CustomActionParamCO> mappingGridColumnList = new ArrayList<CustomActionParamCO>();
		    
		    for(CustomActionParamCO paramCO : paramList)
		    {
			if(ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(paramCO.getMapType()))
			{
			    mappingDataList.add(paramCO);
			}
			if(ButtonCustomizationConstants.MAP_TYPE.GRIDCOLUMN.equals(paramCO.getMapType()))
			{
			    mappingGridColumnList.add(paramCO);
			}
			if(ButtonCustomizationConstants.OP_TYPE.CONDITION.equals(paramCO.getOperationType()))
			{
			    condDataMap.put(paramCO.getOperationId(), paramCO);
			}
		    }

		    if(mappingDataList != null && !mappingDataList.isEmpty())
		    {
			customBtnDataMap.put("mappingDataList", mappingDataList);
		    }
		    if(mappingGridColumnList != null && !mappingGridColumnList.isEmpty())
		    {
			customBtnDataMap.put("mappingGridColumnList", mappingGridColumnList);
		    }
		    
		    if(!condDataMap.isEmpty())
		    {
			List<CustomActionParamCO> condList = new ArrayList<CustomActionParamCO>(condDataMap.values());
			List<BigDecimal> fieldIdentifierList = new ArrayList<BigDecimal>();
			
			for(CustomActionParamCO paramCO : condList)
			{
			    if(StringUtil.isNotEmpty(paramCO.getCondExpr()))
			    {
				Pattern pattern = Pattern.compile("(.*?)(F.([0-9]*))(.*?)");
				Matcher matcher = pattern.matcher(paramCO.getCondExpr());
				while(matcher.find())
				{
				    if(StringUtil.isNumeric(matcher.group(3),false))
				    {
					BigDecimal fldIdentifier = new BigDecimal(matcher.group(3));
					fieldIdentifierList.add(fldIdentifier);
				    }
				}
			    }
			}
			
			if(!fieldIdentifierList.isEmpty())
			{
			    List<SYS_PARAM_SCREEN_ELEMENTSVO>  screenElementsList = commonLibBO.returnButtonCustScreenElement(sessionCO.getCurrentAppName(), theProgRef, fieldIdentifierList);
			    
			    if(screenElementsList != null && !screenElementsList.isEmpty())
			    {
				customBtnDataMap.put("screenElementsList", screenElementsList);
			    }
			}
		    }
		 }
		 return customBtnDataMap;
	    }
	    catch(BaseException e)
	    {
		Log.getInstance().error(e, "Error in retrieving the toolbar custom buttons");
	    }
	
	}
	
	return null;
    }
    
    /**
     * Dynamic Display Management ...
     * 
     * @param request
     * @param elementName
     * @return
     */
    public static SYS_PARAM_SCREEN_DISPLAYVO returnParamScreenDisplay(HttpServletRequest request, String elementName,
	    String elemId)
    {
	return returnParamScreenDisplay(request, elementName, elemId, null);
    }

    public static HashMap<String,  HashMap<String, String>> returnChangesHighlightsForElt(HttpServletRequest request)
    {
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	return baseAction.get_highlights();
    }
    public static String returnTransMsg(HttpServletRequest request, String text)
    {
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	return baseAction.getText(text);
    }
    
    /**
     * This function returns all the mapped parameters defined for a dynamic screen
     * @param criteria
     * @throws DAOException
     */
    public static List<DynamicScreenParamsMapCO> returnDynScreenMappedParameters(HttpServletRequest request, DynamicScreenParamsMapSC criteria)
    {
	try
	{
	    BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext().getBean("baseServices");
	    CommonLibBO commonLibBO = baseServices.returnCommonLibBO();
	    SessionCO sesCO = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
	    criteria.setCurrAppName(sesCO.getCurrentAppName());
	    
	    String pageRef = request.getParameter("_pageRef");
	    // need to send original prog ref in case of Save AS since the original screen elements are defined in SYS_PARAM_SCREEN_ELEMENTS only
	    String theProgRef = commonLibBO.returnOrginProgRef(sesCO.getCurrentAppName() ,pageRef);
	    //criteria.setProgRef(theProgRef);
	    criteria.setScreenPageRef(theProgRef);
	    
	    return commonLibBO.returnDynScreenMappedParameters(criteria);
        }
        catch(BaseException e)
        {
    	    Log.getInstance().error(e, "Error in retrieving Dynamic Screen Mapped Parameters");
        }
        return null;
    }
    /**
     * return activities list for a custom element
     * @param theVO
     * @return
     */
    public static List<CustomElementActivitiesSC> returnParamElemActivities(SYS_PARAM_SCREEN_DISPLAYVO theVO)
	{
		try {
			//AUBBHU200146 - Performance in CSM
	    	//If no activities are counted then do not request from DB
			if (NumberUtil.isEmptyDecimal((theVO.getActivitiesCount())) || theVO.getActivitiesCount().compareTo(BigDecimal.ZERO) > 0)
			{
				BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext()
						.getBean("baseServices");
				CommonLibBO commonLibBO = baseServices.returnCommonLibBO();
				CustomElementActivitiesSC criteria = new CustomElementActivitiesSC();
				criteria.getSysParamElemActivitiesVO().setPROG_REF(theVO.getPROG_REF());
				criteria.getSysParamElemActivitiesVO().setFLD_IDENTIFIER(theVO.getFLD_IDENTIFIER());
				criteria.getSysParamElemActivitiesVO().setAPP_NAME(theVO.getAPP_NAME());
				criteria.setNbRec(-1);
				criteria.getSysParamElemActivitiesVO().setACTIVITY_ENABLE_YN(ConstantsCommon.ONE);
				if (StringUtil.isNotEmpty(criteria.getSysParamElemActivitiesVO().getPROG_REF())
						&& !NumberUtil.isEmptyDecimal(criteria.getSysParamElemActivitiesVO().getFLD_IDENTIFIER())
						&& StringUtil.isNotEmpty(criteria.getSysParamElemActivitiesVO().getAPP_NAME()))
				{
					return commonLibBO.returnElementActivitiesList(criteria);
				}
			} else
			{
				return null;
			}
		} catch (BaseException e) {
			Log.getInstance().error(e, "Error in retrieving custom element activities");
		}
		return null;
	}
    
    /**
     * return activities list for a custom element
     * 
     * [TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
     * set ACTIVITY_ENABLE_YN into criteria 
     * 
     * @param theVO
     * @return
     */
    public static List<CustomElementActivitiesSC> returnParamElemActivities(SYS_PARAM_OBJ_DISPLAYVO theVO )
    {
	try
	{
	    BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext().getBean("baseServices");
	    CommonLibBO commonLibBO = baseServices.returnCommonLibBO();
	    CustomElementActivitiesSC criteria = new CustomElementActivitiesSC();
	    criteria.getSysParamElemActivitiesVO().setOBJ_DISPLAY_ID(theVO.getOBJ_DISPLAY_ID());
	    criteria.setNbRec(-1);
	    criteria.setFromObjDisplay("true");
	    criteria.getSysParamElemActivitiesVO().setACTIVITY_ENABLE_YN(ConstantsCommon.ONE);
	    if(!NumberUtil.isEmptyDecimal(criteria.getSysParamElemActivitiesVO().getOBJ_DISPLAY_ID()))
	    {
		return commonLibBO.returnElementActivitiesList(criteria);
	    }
	}
	catch(BaseException e)
	{
	    Log.getInstance().error(e, "Error in retrieving custom element activities");
	}
	return null;
    }

    
    /**
     * This function is used to return the HTML ELEMENT_IDs defined as mapping data of the custom buttons.
     * That means all the html elements id are returned to be evaluated when clicking the custom button.
     * @param customBtnDataMap
     * @param activitiesVOList
     * @return
     */
    public static void addScreenElements(Map<String, Object> customBtnDataMap,List<CustomElementActivitiesSC> activitiesVOList, HttpServletRequest request) throws BaseException
    {
	// incase the screenElementsList already filled from rootUtil where there is condition on the custom button then no need to fill the screen elements again.
	if(!customBtnDataMap.containsKey("screenElementsList"))
	{
	    SessionCO sessionCO = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
		String pageRef = request.getParameter("_pageRef");

		BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext()
			.getBean("baseServices");
		CommonLibBO commonLibBO = baseServices.returnCommonLibBO();

		// need to send original prog ref in case of Save AS since the original
		// screen elements are defined in SYS_PARAM_SCREEN_ELEMENTS only
		String theProgRef = commonLibBO.returnOrginProgRef(sessionCO.getCurrentAppName(), pageRef);
		List<BigDecimal> fieldIdentifierList = new ArrayList<BigDecimal>();
		for(CustomElementActivitiesSC activityVO : activitiesVOList)
		{
		    if(StringUtil.isNotEmpty(activityVO.getSysParamElemActivitiesVO().getPROCEED_ON_EXPRESSION()))
		    {
			Pattern pattern = Pattern.compile("(.*?)(F.([0-9]*))(.*?)");
			Matcher matcher = pattern.matcher(activityVO.getSysParamElemActivitiesVO().getPROCEED_ON_EXPRESSION());
			while(matcher.find())
			{
			    if(StringUtil.isNumeric(matcher.group(3), false))
			    {
				BigDecimal fldIdentifier = new BigDecimal(matcher.group(3));
				fieldIdentifierList.add(fldIdentifier);
			    }
			}
		    }
		}
		if(!fieldIdentifierList.isEmpty())
		{
		    List<SYS_PARAM_SCREEN_ELEMENTSVO> screenElementsList = commonLibBO.returnButtonCustScreenElement(sessionCO.getCurrentAppName(), theProgRef, fieldIdentifierList);

		    if(screenElementsList != null && !screenElementsList.isEmpty())
		    {
			 customBtnDataMap.put("screenElementsList", screenElementsList);
		    }
		}
	}
    }
    
    
    /**
     * 
     * Used for Dynamic Screen Display with element Type providing so that in
     * case of submit default readonly will not be applied
     * 
     * @param request
     * @param elementName
     * @return
     */
    public static SYS_PARAM_OBJ_DISPLAYVO returnParamObjDisplay(HttpServletRequest request, String elementName,String objId)
    {
	SYS_PARAM_OBJ_DISPLAYVO sysParamObjDisplayVO = null;
	// SYS_PARAM_SCREEN_DISPLAYVO sysParamScreenDisplayVOFromHm = null;
	String[] propArr = null;
	if(elementName!=null)
	{
	    propArr = elementName.split("\\."); 
	}
	Object obj = null;
	if(propArr!=null && propArr.length > 0 && !"propertiesValMap".equals(propArr[0]))
	{
	    obj = request.getAttribute(propArr[0]);
	}
	    
	if("1".equals(CachedConstantsCommon.apply_dynamic_screen))
	{
	    BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext().getBean(
		    "baseServices");
	    RequiredFieldsSC criteria = new RequiredFieldsSC();
	    SessionCO sesCO = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
	    BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	    /*
	     * variable from BaseAction Class on which the Dynamic details will
	     * be dependent on if this variable true then if there is specific
	     * progref in SREEEN_DEISPLAY table it will be considered otherwise
	     * readonly will be true for the element (parent progref not
	     * considered) if this variable is false then specific prog ref will
	     * be considered , if not available then parent progref will be
	     * considered
	     */
	    String _recReadOnly = StringUtil.nullToEmpty(baseAction.get_recReadOnly());
	    String pageRef = request.getParameter("_pageRef");
            /**
             * [MarwanMaddah]: in case the progRef is empty, so it is a common screen(labeling, running date, saveAs....) 
             * in this case we will get the display information based on SETTINGS_CONFIG_OPT
             */
	    if(StringUtil.nullToEmpty(pageRef).isEmpty())
            {
        	pageRef = ConstantsCommon.SETTINGS_CONFIG_OPT;
            }
	    
	    // if not found by element Name in AdditionalScreenParams Map then
	    // try by Id after removing _pageRef if Exists
	    /*String currElId = null;
	    if(objId != null)
	    {
		currElId = (pageRef == null ? objId:(objId.endsWith("_" + pageRef) ? objId.substring(0, objId
			.lastIndexOf("_" + pageRef)) : objId));

		sysParamObjDisplayVO = baseAction.getAdditionalObjParams().get(currElId);
	    }*/
	    
	    boolean busRelated = false;
	    if(sysParamObjDisplayVO != null)
	    {
		busRelated = true;
	    }

	    String progRef = pageRef;

	    // do not proceed to the service layer if element is label or Anchor
	    /**
	     * the checking on company code has been added to avoid the entrance on display management 
	     * on login screen 
	     */
	    if((!busRelated || ConstantsCommon.APPLY_DYN_EXPRESSION) && sesCO != null && sesCO.getCompanyCode()!=null && pageRef != null )
	    {
		if(objId != null)
		{
		    String currElId = (pageRef == null ? objId:(objId.endsWith("_" + pageRef) ? objId.substring(0, objId
				.lastIndexOf("_" + pageRef)) : objId));

		    criteria.setElementId(currElId);
		}
		criteria.setElementName(elementName);
		criteria.setAppName(sesCO.getCurrentAppName());
		criteria.setProgRef(progRef);
		criteria.setCompCode(sesCO.getCompanyCode());
		criteria.setLoginUserId(sesCO.getUserName());
		
		// in case of Expression the following values could be used
		criteria.setBranchCode(sesCO.getBranchCode());
		criteria.setBranchName(sesCO.getBranchName());
		criteria.setCompanyName(sesCO.getCompanyName());
		criteria.setUserFirstName(sesCO.getUserFirstName());
		criteria.setUserLastName(sesCO.getUserLastName());
		criteria.setBaseCurrencyName(sesCO.getBaseCurrencyName());
		if(sesCO.getCtsTellerVO() != null && sesCO.getCtsTellerVO().getCODE() !=null)
		{
		    criteria.setIsTeller(BigDecimal.ONE);
		}
		
		try
		{
		    /**
		     * [MarwanMaddah]: In case the progReg is equals to SETTINGS_CONFIG_OPT, so it is mean the request is from translation management 
		     * for that will the element name by the element Id to get the value from the cached hashmap.
		     */
                    if(ConstantsCommon.SETTINGS_CONFIG_OPT.equals(criteria.getProgRef()) && StringUtil.nullToEmpty(criteria.getElementName()).isEmpty())
                    {
                	criteria.setElementName(objId);
                    }
                    if(obj!=null)
            	    {
            	      criteria.setScreenObject(obj); 
            	    }
                    else
                    {
                      criteria.setScreenObject(new HashMap());
                    }
		    sysParamObjDisplayVO = (SYS_PARAM_OBJ_DISPLAYVO) baseServices.returnCommonLibBO().returnRequiredObjData(criteria);
		    // overwrite according to _recReadOnly parameter, check
		    // comments above
		    if(sysParamObjDisplayVO != null 
		       && "true".equals(_recReadOnly))// check if not specific progref or from Alert then make readonly 
		    {
			sysParamObjDisplayVO.setIS_READONLY(BigDecimal.ONE);
		    }
		
		}
		catch(BaseException e)
		{
		    Log.getInstance().error(e, "Error in retrieving requiredData for tag");
		}
	    }
	}
	return sysParamObjDisplayVO;
    }
    
    public static SYS_PARAM_OBJ_DETAILS_DISPLAYVO returnParamObjDetailsDisplay(HttpServletRequest request, String gridId,
	    String colName)
    {
	
	SYS_PARAM_OBJ_DETAILS_DISPLAYVO sysParamObjDetailsDisplayVO = null;
	// SYS_PARAM_SCREEN_DISPLAYVO sysParamScreenDisplayVOFromHm = null;
	if("1".equals(CachedConstantsCommon.apply_dynamic_screen))
	{
	    BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext().getBean(
		    "baseServices");
	    RequiredFieldsSC criteria = new RequiredFieldsSC();
	    SessionCO sesCO = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
	    BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	    /*
	     * variable from BaseAction Class on which the Dynamic details will
	     * be dependent on if this variable true then if there is specific
	     * progref in SREEEN_DEISPLAY table it will be considered otherwise
	     * readonly will be true for the element (parent progref not
	     * considered) if this variable is false then specific prog ref will
	     * be considered , if not available then parent progref will be
	     * considered
	     */
	    String _recReadOnly = StringUtil.nullToEmpty(baseAction.get_recReadOnly());
	    String pageRef = request.getParameter("_pageRef");
            /**
             * [MarwanMaddah]: in case the progRef is empty, so it is a common screen(labeling, running date, saveAs....) 
             * in this case we will get the display information based on SETTINGS_CONFIG_OPT
             */
	    if(StringUtil.nullToEmpty(pageRef).isEmpty())
            {
        	pageRef = ConstantsCommon.SETTINGS_CONFIG_OPT;
            }
	    
	    // if not found by element Name in AdditionalScreenParams Map then
	    // try by Id after removing _pageRef if Exists
	    String progRef = pageRef;

	    // do not proceed to the service layer if element is label or Anchor
	    /**
	     * the checking on company code has been added to avoid the entrance on display management 
	     * on login screen 
	     */
	    if(sesCO != null && sesCO.getCompanyCode()!=null && pageRef != null )
	    {
		if(gridId != null)
		{
		    String currElId = (pageRef == null ? gridId:(gridId.endsWith("_" + pageRef) ? gridId.substring(0, gridId
				.lastIndexOf("_" + pageRef)) : gridId));

		    criteria.setElementId(currElId);
		}
		criteria.setElementName(colName);
		criteria.setAppName(sesCO.getCurrentAppName());
		criteria.setProgRef(progRef);
		criteria.setCompCode(sesCO.getCompanyCode());
		criteria.setLoginUserId(sesCO.getUserName());
		
		// in case of Expression the following values could be used
		criteria.setBranchCode(sesCO.getBranchCode());
		criteria.setBranchName(sesCO.getBranchName());
		criteria.setCompanyName(sesCO.getCompanyName());
		criteria.setUserFirstName(sesCO.getUserFirstName());
		criteria.setUserLastName(sesCO.getUserLastName());
		criteria.setBaseCurrencyName(sesCO.getBaseCurrencyName());
		if(sesCO.getCtsTellerVO() != null && sesCO.getCtsTellerVO().getCODE() !=null)
		{
		    criteria.setIsTeller(BigDecimal.ONE);
		}
		
		try
		{
		    /**
		     * [MarwanMaddah]: In case the progReg is equals to SETTINGS_CONFIG_OPT, so it is mean the request is from translation management 
		     * for that will the element name by the element Id to get the value from the cached hashmap.
		     */
                    if(ConstantsCommon.SETTINGS_CONFIG_OPT.equals(criteria.getProgRef()) && StringUtil.nullToEmpty(criteria.getElementName()).isEmpty())
                    {
                	criteria.setElementName(gridId);
                    }
                    sysParamObjDetailsDisplayVO = (SYS_PARAM_OBJ_DETAILS_DISPLAYVO) baseServices.returnCommonLibBO().returnRequiredObjDetailsData(criteria);
		    // overwrite according to _recReadOnly parameter, check
		    // comments above
		    if(sysParamObjDetailsDisplayVO != null 
		       && "true".equals(_recReadOnly))
		    {
			sysParamObjDetailsDisplayVO.setIS_READONLY(BigDecimal.ONE);
		    }
		
		}
		catch(BaseException e)
		{
		    Log.getInstance().error(e, "Error in retrieving requiredData for tag");
		}
	    }
	}
	return sysParamObjDetailsDisplayVO;
    }
    
    /**
     * method used to escape special characters that may affect JS code when it contains struts properties ${}
     * it will escape the property from special characters that might be used for security intrusion
     * @param property
     * @return
     */
    public static String escapeJS(String property)
    {
	if(StringUtil.isNotEmpty(property))
	{
	    return property.replaceAll("[{}'\"();,:/\\\\]", "");
	}
	return property;
    }
    /**
     * [TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
     * @description This function returns object display id
     * @createdBy Sajjad Soomro
     * 
     * @param criteria
     * @return BigDecimal
     */
    public static BigDecimal returnObjDisplayId(SYS_PARAM_OBJ_DISPLAYVO criteria)
    {
	try
	{
	    BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext().getBean("baseServices");
	    String objectId = criteria.getOBJECT_ID();
	    String pageRef = "_" + criteria.getPROG_REF();
	    if(objectId != null && objectId.endsWith(pageRef))
	    {
		objectId = objectId.substring(0, objectId.lastIndexOf(pageRef));
		criteria.setOBJECT_ID(objectId);
	    }
	    return baseServices.returnCommonLibBO().returnObjDisplayId(criteria);
        }
        catch(BaseException e)
        {
    	    Log.getInstance().error(e, "Error in retrieving Dynamic Screen Mapped Company Code");
        }
        return null;
    }
    /**
     * [TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
     * @description This function return activities list for a custom elements of grid
     * @createdBy Sajjad Soomro
     * 
     * @param request
     * @param gridId
     * @return List<CustomElementActivitiesSC>
     */
    public static List<CustomElementActivitiesSC> returnParamElemActivities(HttpServletRequest request, String gridId)
    {
	/**
	 * check if gridId is null or empty then return null
	 * otherwise check list of custom elements is null or empty or doesn't having activities list of custom elements 
	 * then load it from database and put it into the cached map of customElemActivitiesMap
	 * otherwise return activities list of custom elements of grid
	 */
	if(gridId == null || gridId.isEmpty())
	{
	    return null;
	}
	
	HashMap<String, List<CustomElementActivitiesSC>> customElemActivitiesMap = new HashMap<String, List<CustomElementActivitiesSC>>();
	if(CachedConstantsCommon.findInfo != null && !CachedConstantsCommon.findInfo.isEmpty())
	{
	    customElemActivitiesMap = CachedConstantsCommon.findInfo.get(CachedConstantsCommon.CUSTOM_ELEMENT_ACTIVITIES_CACHE_KEY);
	    if(customElemActivitiesMap == null || customElemActivitiesMap.isEmpty() || !customElemActivitiesMap.containsKey(gridId))
	    {
		synchronized(CachedConstantsCommon.findInfo)
		{
		    try
		    {
			BaseServices baseServices = (BaseServicesImpl) ApplicationContextProvider.getApplicationContext().getBean("baseServices");
			SessionCO sesCO = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
			CommonLibBO commonLibBO = baseServices.returnCommonLibBO();

			String pageRef = StringUtil.nullEmptyToValue(request.getParameter("_pageRef"),ConstantsCommon.SETTINGS_CONFIG_OPT);
			// need to send original prog ref in case of Save AS since the original screen elements are defined in SYS_PARAM_SCREEN_ELEMENTS only
			String theProgRef = commonLibBO.returnOrginProgRef(sesCO.getCurrentAppName() ,pageRef);
			String currAppName = sesCO != null ? StringUtil.nullToEmpty(sesCO.getCurrentAppName()) : ConstantsCommon.returnCurrentAppName();

			//fill SYS_PARAM_OBJ_DISPLAYVO to get object display id
			SYS_PARAM_OBJ_DISPLAYVO objDispVO = new SYS_PARAM_OBJ_DISPLAYVO();
			objDispVO.setAPP_NAME(currAppName);
			objDispVO.setPROG_REF(theProgRef);
			objDispVO.setOBJECT_ID(gridId);

			BigDecimal objDipslayId = RootUtil.returnObjDisplayId(objDispVO);	// return object display id
			if(objDipslayId != null)
			{
			    objDispVO.setOBJ_DISPLAY_ID(objDipslayId);
			}
			if(customElemActivitiesMap == null)
			{
			    customElemActivitiesMap = new HashMap<String, List<CustomElementActivitiesSC>>();
			}
			List<CustomElementActivitiesSC> activitiesVOList = RootUtil.returnParamElemActivities(objDispVO);
			customElemActivitiesMap.put(gridId, activitiesVOList);
			CachedConstantsCommon.findInfo.put(CachedConstantsCommon.CUSTOM_ELEMENT_ACTIVITIES_CACHE_KEY, customElemActivitiesMap);
		    }
		    catch(BaseException e)
		    {
			Log.getInstance().error(e, "Error in retrieving custom element activities");
		    }
		}
	    }
	}
	if(customElemActivitiesMap == null) return null;
	return customElemActivitiesMap.get(gridId);
    }
}
