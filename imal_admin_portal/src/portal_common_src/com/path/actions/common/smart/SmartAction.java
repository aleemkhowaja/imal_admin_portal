package com.path.actions.common.smart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import com.path.actions.common.scan.ScanAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.PluginsConstants;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.smart.SmartBO;
import com.path.bo.common.smart.SmartConstant;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ENTITY_TYPEVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.PathPropertyNamingStrategy;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.struts2.json.PathJSONUtil;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.smart.SAdditionsDetailsCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.common.smart.SmartSC;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees 
 * 
 *          SmartAction.java used to handle all action related with smart fields
 */
public class SmartAction extends ScanAction
{
    private SmartBO smartBO;
    private final SmartSC smartSC = new SmartSC();
    private ArrayList<SmartCO> smartCOList;
    private boolean smartDefined;
    private boolean _smartWindowNewMode;
    //Bug 501397 Changed saddTypeCode variable non standard name
    private BigDecimal saddTypeCode;
    private Double randomNumber;
    private String _smartAuditJsonStr;
    private InputStream fileStream;
    private String filename;
    private String _parentPageRef;
    private int smartCount;
    private boolean useActiveX;
    private String smartLanguage;
    private String scanAxVersion = PluginsConstants.TWAIN_AX_VERSION;// The scan ActiveX object version
    private final String scanExVersion = PluginsConstants.SCAN_EX_VERSION;// The scan Chrome Extension version
    private String twainCLSID = PluginsConstants.TWAIN_CLSID;// The scan ActiveX object CLSID
    private String smart_addScreenParams; //to be used when opening smart screen after validation
    private String auditActionDate;//contains audit date
    /**
     * get the list of Smart fields from the BO
     * 
     * @return String
     */
    public String loadAdditionalDetails()
    {
	try
	{
	    // Flag ENABLE_SMART_FUNC in PTH_CTRL overrides editable/readOnly
	    // settings for SMART fields
	    // TP# 272320
	    // TAR# IIAB100378
	    PTH_CTRLVO pthCtrl = returnCommonLibBO().returnPthCtrl();
	    String enableSmartFunc = pthCtrl.getENABLE_SMART_FUNC();
	    if(ConstantsCommon.ZERO.equals(enableSmartFunc))
	    {
		set_recReadOnly("false");
	    }

	    SessionCO sessionCO = returnSessionObject();
	    smartSC.setAppName(sessionCO.getCurrentAppName());
	    //Bug 570461 add special branch / company code
	    smartSC.setCompCode(NumberUtil.isEmptyDecimal(getSmartSpecCompCode())?sessionCO.getCompanyCode():getSmartSpecCompCode());
	    smartSC.setBranchCode(NumberUtil.isEmptyDecimal(getSmartSpecBranchCode())?sessionCO.getBranchCode():getSmartSpecBranchCode());
	    smartSC.setUserId(sessionCO.getUserName());
	    smartSC.setRunningDate(sessionCO.getRunningDateRET());
	    smartSC.setUsrPathSts(sessionCO.getUsrPathSts());
	    set_pageRef(smartSC.getProgRef());
	    set_parentPageRef(smartBO.returnSmartParentRef(smartSC));// set parent ref
	    //TODO
	    //smart.ftl is not reading the parent language variable (we need to check for the reason)
	    //setLanguage(sessionCO.getLanguage());
	    setSmartLanguage(sessionCO.getLanguage());
	    if(!StringUtil.isNotEmpty(smartSC.getTrxNbr()))
	    {
		_smartWindowNewMode = true;
	    }
	    
	    ArrayList<SelectCO> smartScrParams = smartBO.returnSmartScreenParams(smartSC);

	    if(smartScrParams!=null)
	    {
		    JSONObject mainJson = new JSONObject();
		    JSONArray selectArr = new JSONArray();
		    for(SelectCO selectCO : smartScrParams)
		    {
			JSONObject selectIndex = new JSONObject();
			
			selectIndex.put("ID", selectCO.getCode());
			selectIndex.put("isCIF", selectCO.getDescValue());

			selectArr.add(selectIndex);
		    }

		    mainJson.put("smartScreenParams", selectArr);
		    smartSC.setSmartScreenParams(mainJson.toString());
	    }

	    
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.RETRIEVE_SMART);
	    refCO.setTrxNbr(smartSC.getTrxNbr());
	    smartSC.setProgRef(get_parentPageRef());
	    
	    
	    smartCOList = smartBO.returnSMARTfieldsList(smartSC, refCO);
	    
	    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> customScreenDisplay = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
		String enableCustomization = smartBO.checkIfEnabledCustomization();
		//StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile("PathRemoting", "smart.cust.enabled"), ConstantsCommon.ZERO);
		
	    
	    if(!smartCOList.isEmpty())
	    {
		if(!_smartWindowNewMode)
		{
		    setAuditTrxNbr(smartSC.getTrxNbr());
		    SAdditionsDetailsCO sAdditionsDetailsCO = smartBO.returnSAdditionsDetailsCO(false, smartCOList, smartSC);
		    putAuditObject(sAdditionsDetailsCO);
		    auditBO.callAudit(null, sAdditionsDetailsCO, refCO);
		}
		
		SYS_PARAM_SCREEN_DISPLAYVO sysparam = new SYS_PARAM_SCREEN_DISPLAYVO();
		sysparam.setIS_MANDATORY("true".equals(get_recReadOnly())?BigDecimal.ZERO:BigDecimal.ONE);
		sysparam.setIS_READONLY("true".equals(get_recReadOnly())?BigDecimal.ONE:BigDecimal.ZERO);
		
		SYS_PARAM_SCREEN_DISPLAYVO sysparamReadOnly = new SYS_PARAM_SCREEN_DISPLAYVO();
		sysparamReadOnly.setIS_READONLY("true".equals(get_recReadOnly())?BigDecimal.ONE:BigDecimal.ZERO);
		
		SYS_PARAM_SCREEN_DISPLAYVO sysparamButtonReadOnly = new SYS_PARAM_SCREEN_DISPLAYVO();

		customScreenDisplay = returnCommonLibBO().returnMapRequiredData(resetInfoMap(sessionCO));
		
		int id=0;
		Boolean isEditPermissionToUser = Boolean.FALSE;
		
		
	

		for(SmartCO smartCO : smartCOList)
		{
		    //#781186 use S_ADD_TYPE_CODE instead of the old iterator
		    id = smartCO.getSAdditionsDetailsVO().getS_ADD_TYPE_CODE().intValue();
		    isEditPermissionToUser = smartCO.getSmartTypesVO().getbEdit();
		    isEditPermissionToUser = isEditPermissionToUser == null ? Boolean.FALSE :isEditPermissionToUser;
		    if(!isEditPermissionToUser)
		    {
			sysparamReadOnly.setIS_READONLY(BigDecimal.ONE);
			sysparam.setIS_MANDATORY(BigDecimal.ZERO);
		    }
			
		    BigDecimal optionTYPE = smartCO.getSAdditionsOptionsVO().getOPTION_TYPE();
		    if(optionTYPE != null)
		    {
			boolean mandatoy = "Y".equals(smartCO.getSAdditionsTypeVO().getMANDATORY());
			if(optionTYPE.compareTo(new BigDecimal(SmartConstant.PARAMETER))==0)  // PARAMETER
			{
			    if(customScreenDisplay.get("smartCOList["+id+"].sAdditionsDetailsVO.s_ADD_OPTION_CODE") == null)
			    {
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("lookuptxt_sAdditionsDetailsSAddOptionCode_"+id, isEditPermissionToUser.booleanValue()?(mandatoy?sysparam:sysparamReadOnly):sysparamReadOnly);
			    	}
			    }
			    else 
			    {
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("lookuptxt_sAdditionsDetailsSAddOptionCode_"+id,customScreenDisplay.get("smartCOList["+id+"].sAdditionsDetailsVO.s_ADD_OPTION_CODE"));
			    	}
			    }
			}
			if(optionTYPE.compareTo(new BigDecimal(SmartConstant.SCANNEDDOCUMENT))==0)  // Scanned Doc
			{
			    useActiveX = true;
			    boolean bView = smartCO.getSmartTypesVO().getbView() == null?false:smartCO.getSmartTypesVO().getbView().booleanValue();
			    sysparamButtonReadOnly = new SYS_PARAM_SCREEN_DISPLAYVO();
			    sysparamButtonReadOnly.setIS_READONLY(bView ?BigDecimal.ZERO:BigDecimal.ONE);
			    if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    	getAdditionalScreenParams().put("preview_"+id, sysparamButtonReadOnly);
			    }
			    
			    boolean bScan =smartCO.getSmartTypesVO().getbScan()==null?false:smartCO.getSmartTypesVO().getbScan().booleanValue();
			    sysparamButtonReadOnly = new SYS_PARAM_SCREEN_DISPLAYVO();
			    sysparamButtonReadOnly.setIS_READONLY(bScan ?BigDecimal.ZERO:BigDecimal.ONE);
			    if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    	getAdditionalScreenParams().put("scan_"+id, isEditPermissionToUser.booleanValue()?("true".equals(get_recReadOnly())&&mandatoy?sysparamButtonReadOnly:sysparam):sysparamReadOnly);
			    }
			    smartCO.setSoptionDesc(isEditPermissionToUser.booleanValue()?(mandatoy?"true":"false"):"false");
			    setUseActiveX(BigDecimal.ONE != sysparamButtonReadOnly.getIS_READONLY() && !(isEditPermissionToUser.booleanValue() && ("true".equals(get_recReadOnly()))));

			    boolean bRun = ((smartCO.getSmartTypesVO().getbRun()==null?false:smartCO.getSmartTypesVO().getbRun().booleanValue()) && (sessionCO.getDisablePrntScrn()=="1"?false:true));
			    sysparamButtonReadOnly = new SYS_PARAM_SCREEN_DISPLAYVO();
			    sysparamButtonReadOnly.setIS_READONLY(bRun ? BigDecimal.ZERO:BigDecimal.ONE);
			    if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    	getAdditionalScreenParams().put("run_"+id, sysparamButtonReadOnly);
			    }
			}
			else if(optionTYPE.compareTo(new BigDecimal(2))==0) //Text
			{
			    if(customScreenDisplay.get("smartCOList["+id+"].sAdditionsDetailsVO.ADDITION_TEXT") == null)
			    {
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("addText_"+id, isEditPermissionToUser.booleanValue()?(mandatoy?sysparam:sysparamReadOnly):sysparamReadOnly);
			    	}
			    }
			    else
			    {
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("addText_"+id,customScreenDisplay.get("smartCOList["+id+"].sAdditionsDetailsVO.ADDITION_TEXT"));
			    	}
			    }
			}
			else if(optionTYPE.compareTo(new BigDecimal(3))==0)
			{
			    if(customScreenDisplay.get("smartCOList["+id+"].sAdditionsDetailsVO.ADDITION_DATE") == null)
			    {
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("addDate_"+id, isEditPermissionToUser.booleanValue()?(mandatoy?sysparam:sysparamReadOnly):sysparamReadOnly);
			    	}
			    }
			    else
			    {
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("addDate_"+id,customScreenDisplay.get("smartCOList["+id+"].sAdditionsDetailsVO.ADDITION_DATE"));
			    	}
			    }
			}
			else if(optionTYPE.compareTo(new BigDecimal(4))==0)
			{
			    if(customScreenDisplay.get("smartCOList["+id+"].sAdditionsDetailsVO.ADDITION_NUMBER") == null)
			    {
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("addNumber_"+id, isEditPermissionToUser.booleanValue()?(mandatoy?sysparam:sysparamReadOnly):sysparamReadOnly);
			    	}
			    }
			    else
			    {
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("addNumber_"+id,customScreenDisplay.get("smartCOList["+id+"].sAdditionsDetailsVO.ADDITION_NUMBER"));
			    	}
			    }
			    
			    //added to make the option mask compatible with the standard formats
			    String opMask = smartCO.getSAdditionsOptionsVO().getOPTION_MASK();
			    
			    if (!opMask.matches("[#.0,]*"))
			    {
				smartCO.getSAdditionsOptionsVO().setOPTION_MASK("#");
			    }
			}
			else if(optionTYPE.compareTo(new BigDecimal(5))==0)
			{
			    if(NumberUtil.isEmptyDecimal(smartCO.getSAdditionsDetailsVO().getADDITION_NUMBER()))
			    {
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("browse_"+id, isEditPermissionToUser.booleanValue()?(mandatoy?sysparam:sysparamReadOnly):sysparamReadOnly);
			    		getAdditionalScreenParams().put("clearExternalFile_"+id, sysparamReadOnly);
			    	}
				smartCO.setSoptionDesc(isEditPermissionToUser.booleanValue()?(mandatoy?"true":"false"):"false");
			    }
			    else
			    {
			    	boolean bRun =smartCO.getSmartTypesVO().getbRun()==null?false:smartCO.getSmartTypesVO().getbRun().booleanValue();
			    	sysparamButtonReadOnly = new SYS_PARAM_SCREEN_DISPLAYVO();
			    	sysparamButtonReadOnly.setIS_READONLY(bRun ?BigDecimal.ZERO:BigDecimal.ONE);
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("run_"+id, sysparamButtonReadOnly);
			    	}
			    	smartCO.setSoptionDesc(isEditPermissionToUser.booleanValue()?(mandatoy?"true":"false"):"false");
			    	boolean bDetach =smartCO.getSmartTypesVO().getbDetach()==null?false:smartCO.getSmartTypesVO().getbDetach().booleanValue();
			    	sysparamButtonReadOnly = new SYS_PARAM_SCREEN_DISPLAYVO();
			    	sysparamButtonReadOnly.setIS_READONLY(bDetach ?BigDecimal.ZERO:BigDecimal.ONE);
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("detach_"+id, isEditPermissionToUser.booleanValue()?("true".equals(get_recReadOnly())?sysparam:sysparamButtonReadOnly):sysparamReadOnly);
			    	}
			   }
			}
			else if(optionTYPE.compareTo(new BigDecimal(6))==0)
			{
			    //fix issue #551106 GAB170070 - FMS - SMART OPTION - default the url already defined in smart option
			    SYS_PARAM_SCREEN_DISPLAYVO hyperlinkReadOnly = new SYS_PARAM_SCREEN_DISPLAYVO();
			    
			    if(customScreenDisplay.get("smartCOList["+id+"].sAdditionsDetailsVO.ADDITION_TEXT") == null)
			    {
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("hypLink_"+id, isEditPermissionToUser.booleanValue()?(mandatoy?sysparam:sysparamReadOnly):sysparamReadOnly);
			    	}
			    }
			    else
			    {
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("hypLink_"+id,customScreenDisplay.get("smartCOList["+id+"].sAdditionsDetailsVO.ADDITION_TEXT"));
			    	}
			    }
			    
//			    hyperlinkReadOnly.setIS_READONLY(BigDecimal.ONE);
//			    getAdditionalScreenParams().put("hypLink_"+id,hyperlinkReadOnly);    
			    
			    boolean bRun =smartCO.getSmartTypesVO().getbRun()==null?false:smartCO.getSmartTypesVO().getbRun().booleanValue();
			    sysparamButtonReadOnly = new SYS_PARAM_SCREEN_DISPLAYVO();
			    sysparamButtonReadOnly.setIS_READONLY(bRun ?BigDecimal.ZERO:BigDecimal.ONE);
			    if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    	getAdditionalScreenParams().put("run_"+id, sysparamButtonReadOnly);
			    }

			    //fix issue #551106 GAB170070 - FMS - SMART OPTION - default the url already defined in smart option 
			    if(StringUtil.isNotEmpty(smartCO.getSAdditionsOptionsVO().getBRIEF_NAME_ENG()) && StringUtil.isEmptyString(smartCO.getSAdditionsDetailsVO().getADDITION_TEXT()))
			    {
				smartCO.getSAdditionsDetailsVO().setADDITION_TEXT(smartCO.getSAdditionsOptionsVO().getBRIEF_NAME_ENG());
				smartCO.getSAdditionsDetailsVO().setADDITION_TEXT(smartCO.getSAdditionsOptionsVO().getBRIEF_NAME_ENG());
			    }
			    smartCO.setSoptionDesc(smartCO.getSAdditionsDetailsVO().getADDITION_TEXT());
			}
			else if(optionTYPE.compareTo(new BigDecimal(SmartConstant.UPLOADED_FILE))==0)
			{
			    if(NumberUtil.isEmptyDecimal(smartCO.getSAdditionsDetailsVO().getADDITION_NUMBER()))
			    {
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("browse_"+id, isEditPermissionToUser.booleanValue()?(mandatoy?sysparam:sysparamReadOnly):sysparamReadOnly);
			    		getAdditionalScreenParams().put("clearExternalFile_"+id, sysparamReadOnly);
			    	}
				smartCO.setSoptionDesc(isEditPermissionToUser.booleanValue()?(mandatoy?"true":"false"):"false");
			    }
			    else
			    {
			    	boolean bRun =smartCO.getSmartTypesVO().getbRun()==null?false:smartCO.getSmartTypesVO().getbRun().booleanValue();
			    	sysparamButtonReadOnly = new SYS_PARAM_SCREEN_DISPLAYVO();
			    	sysparamButtonReadOnly.setIS_READONLY(bRun ?BigDecimal.ZERO:BigDecimal.ONE);
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("run_"+id, sysparamButtonReadOnly);
			    	}
			    	smartCO.setSoptionDesc(isEditPermissionToUser.booleanValue()?(mandatoy?"true":"false"):"false");
			    	boolean bDetach =smartCO.getSmartTypesVO().getbDetach()==null?false:smartCO.getSmartTypesVO().getbDetach().booleanValue();
			    	sysparamButtonReadOnly = new SYS_PARAM_SCREEN_DISPLAYVO();
			    	sysparamButtonReadOnly.setIS_READONLY(bDetach ?BigDecimal.ZERO:BigDecimal.ONE);
			    	if(null!=enableCustomization && !"1".equals(enableCustomization)){
			    		getAdditionalScreenParams().put("detach_"+id, isEditPermissionToUser.booleanValue()?("true".equals(get_recReadOnly())?sysparam:sysparamButtonReadOnly):sysparamReadOnly);
			    	}
			    }
			}
			
			if(customScreenDisplay != null && customScreenDisplay.get("smartCOList["+id+"].sAdditionsDetailsVO.MANUAL_REFERENCE") == null)
			{
				if(null!=enableCustomization && !"1".equals(enableCustomization)){
					getAdditionalScreenParams().put("manualRef_"+id, sysparamReadOnly);
				}
			}			
			
		    }
		}
		if(null!=enableCustomization && !"1".equals(enableCustomization)){
			getAdditionalScreenParams().put("smartDetailSave_"+get_pageRef(), sysparamReadOnly);
		}
	    }
	    if(null!=enableCustomization && !"1".equals(enableCustomization)){
	    	getAdditionalScreenParams().putAll(customScreenDisplay);
	    }
	    
	    if(null!=enableCustomization && !"1".equals(enableCustomization)){
	    	setSmart_addScreenParams(PathJSONUtil.strutsJsonSerialize(getAdditionalScreenParams()));
	    }
	    //Add empty SMARTCO since the TABLE S_ADDITIONS_TYPE will always have the S_ADD_TYPE_CODE code 0 as empty record.
	    smartCOList.add(0, new SmartCO());
	    //Loop on the retrieved data and insert empty SmartCO instance whenever the S_ADD_TYPE_CODE is not sequential
	    //to avoid sending null objects to FTL
	    for(int f=1; f<smartCOList.size();f++)
	    {
		int id =  smartCOList.get(f).getSAdditionsDetailsVO().getS_ADD_TYPE_CODE().intValue();
		if(id>f)
		{
		    smartCOList.add(f, new SmartCO());
		}
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "smartDetails";
    }

    
    private RequiredFieldsSC resetInfoMap(SessionCO sessionCO) throws BaseException
    {
		//DASI180447 SMART fields customization
		RequiredFieldsSC dispCriteria = new RequiredFieldsSC();
		dispCriteria.setAppName(smartSC.getAppName());
		dispCriteria.setProgRef(smartSC.getProgRef());
		dispCriteria.setCompCode(sessionCO.getCompanyCode());
		
		//id:813541 state:100. Ready for Building EXE comment:Fixed as workaround to be handled with SMART mandatory customization later.
		Map<String,Object> entityTypeInfosMap = new HashMap<String,Object>();
		
		SYS_PARAM_SCREEN_ENTITY_TYPEVO sysParamScreenEntityType = new SYS_PARAM_SCREEN_ENTITY_TYPEVO();
		sysParamScreenEntityType.setAPP_NAME(smartSC.getAppName());
		sysParamScreenEntityType.setPROG_REF(smartSC.getProgRef());
		List<SYS_PARAM_SCREEN_ENTITY_TYPEVO> entityTypeInfosList = returnCommonLibBO().returnEntityTypeInfos(sysParamScreenEntityType);
		if(entityTypeInfosList != null && entityTypeInfosList.size()>0)
		{
			for(SYS_PARAM_SCREEN_ENTITY_TYPEVO entityTypeInfos : entityTypeInfosList)
			{
				entityTypeInfosMap.put(entityTypeInfos.getPROPERTY_NAME(), null);
			}
			
		}

		dispCriteria.setEntityTypeInfosMap(entityTypeInfosMap);
		
		return dispCriteria;
    }
    
    /**
     * Method to load preview image for scanned Object
     * 
     * @return String
     */
    public String showPreviewImage()
    {
	try
	{
	    if(checkImage())
	    {
		return "scanned";
	    }
	    SessionCO session = returnSessionObject();
	    smartSC.setAppName(session.getCurrentAppName());
	    set_parentPageRef(smartBO.returnSmartParentRef(smartSC));
	    setAuditTrxNbr(smartSC.getTrxNbr());
	    setSaddTypeCode(smartSC.getSaddTypeCode());
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "showPreviewImage";
    }

    /**
     * Method to write Scanned Images in jsp page
     */
    public void loadPreviewImage()
    {
	try
	{
	    byte[] previewImage = returnSmartBlobData();
	    HttpServletResponse response = ServletActionContext.getResponse();
	    setServletResponse(response);
	    response.setContentType("image/jpeg");
	    if(previewImage != null)
	    {
		response.getOutputStream().write(previewImage);
	    }
	    response.getOutputStream().flush();
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
    }

    /**
     * Method to retrieve and download the blob files
     * 
     * @return String
     */
    public String downloadExternalFile()
    {
	try
	{
	    set_parentPageRef(smartSC.getProgRef());
	    byte[] blobData = returnSmartBlobData();
	    fileStream = new ByteArrayInputStream(blobData);
	    return "downloadFile";
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		fileStream = new ByteArrayInputStream(getText("Error_retrieving_file_from_database_key").getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    }
	    catch(UnsupportedEncodingException ex)
	    {
		log.error(ex,"Error In Encoding downloadExternalFile");
		handleException(ex, null, null);
	    }
	    return "downloadFileError";
	}
    }

    /**
     * Method to retrieve the blob Data
     * 
     * @return byte[]
     * @throws BaseException
     */
    private byte[] returnSmartBlobData() throws BaseException
    {
	SessionCO session = returnSessionObject();
	smartSC.setAppName(session.getCurrentAppName());
	//Bug 570461 add special branch / company code
	smartSC.setCompCode(NumberUtil.isEmptyDecimal(getSmartSpecCompCode())?session.getCompanyCode():getSmartSpecCompCode());
	smartSC.setBranchCode(NumberUtil.isEmptyDecimal(getSmartSpecBranchCode())?session.getBranchCode():getSmartSpecBranchCode());
	return smartBO.previewSmartObj(smartSC);
    }

    /**
     * checks whether there is any smart fields defined based on the criteria
     * 
     * @return String
     */
    public String checkSmartDetailsDefined()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    smartSC.setAppName(sessionCO.getCurrentAppName());
	  //Bug 570461 add special branch / company code
	    smartSC.setCompCode(NumberUtil.isEmptyDecimal(getSmartSpecCompCode())?sessionCO.getCompanyCode():getSmartSpecCompCode());
	    smartSC.setBranchCode(NumberUtil.isEmptyDecimal(getSmartSpecBranchCode())?sessionCO.getBranchCode():getSmartSpecBranchCode());
	    smartSC.setUserId(sessionCO.getUserName());
	    set_pageRef(smartSC.getProgRef());
	    set_parentPageRef(smartBO.returnSmartParentRef(smartSC));// set
								     // parent
								     // ref
	    smartSC.setProgRef(get_parentPageRef());
	    
	    smartCount = smartBO.checkSmartDetailsDefined(smartSC, false);
	    if(smartCount > 0)
	    {
		smartDefined = true;
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "checkSmart";
    }
    
    /**
     * updates the values from the smart fields
     * 
     * @return String
     */
    public String submitSmartDetails()
    {
	try
	{
	    SessionCO session = returnSessionObject();
	    for(SmartCO smartCO : smartCOList)
	    {
		if(smartCO != null)
		{

			BigDecimal optionTYPE = smartCO.getSAdditionsOptionsVO().getOPTION_TYPE();
			String imgName = smartCO.getExternalFileFileName();
			if(new BigDecimal(SmartConstant.UPLOADED_FILE).compareTo(optionTYPE) == 0 
				&& smartCO.getExternalFile() != null )
			{
			    log.debug("SmartAction.submitSmartDetails: Checking file properties (size, ext)");
	    		    String fileName = StringUtil.nullToEmpty(smartCO.getExternalFileFileName());
	    		    String[] fileAllowedExt = StringUtil.nullEmptyToValue(smartCO.getSAdditionsOptionsVO().getFILE_EXTENSION(), "").split(",");
	    		    String extension = "";
	    
	    		    int i = fileName.lastIndexOf('.');
	    		    if (i > 0) {
	    		        extension = fileName.substring(i);
	    		    }
	    		    if((StringUtil.isNotEmpty(smartCO.getSAdditionsOptionsVO().getFILE_EXTENSION())) && !Arrays.asList(fileAllowedExt).contains(extension))
	    		    {
	    			log.debug("SmartAction.submitSmartDetails: File extension is not allowed: "+ extension);
	    			throw new BOException (getText("allowed_file_extension_key")+smartCO.getSAdditionsOptionsVO().getFILE_EXTENSION());
	    		    }
	    		    //The the maximum allowed file size
	    		    File extFile = smartCO.getExternalFile();
	    		    double bytes = extFile.length();
	    		    double kilobytes = (bytes / 1024);
	    		    if(!NumberUtil.isEmptyDecimal(smartCO.getSAdditionsOptionsVO().getMAX_FILE_SIZE()) && new BigDecimal(kilobytes).compareTo(smartCO.getSAdditionsOptionsVO().getMAX_FILE_SIZE()) > 0)
	    		    {
	    			log.debug("SmartAction.submitSmartDetails: File size is not allowed MAX: "+ kilobytes + " KB");
	    			throw new BOException (MessageCodes.PARAM1_CANNOT_BE_GREATER_THAN_PARAM2, new String[] {getText("file_size_key"),String.valueOf(smartCO.getSAdditionsOptionsVO().getMAX_FILE_SIZE())+" KB"});
	    		    }
			}
			if(StringUtil.isNotEmpty(imgName) && BigDecimal.ONE.compareTo(optionTYPE) == 0)
			{
			    setImgName(imgName);
			    File file = new PathFileSecure(returnFileName());
			  //limit the size of the file to be below of 200 MB = 200000000 bytes 
			    smartCO.setSmartFileBytes(PathFileSecure.readFileToByteArray(file,200000000));
			    smartCO.setExternalFileFileName(imgName+ConstantsCommon.SCANNED_EXT);
			}
			//Bug501397 external file is not saved in the first phase (OK button)
			if(new BigDecimal(SmartConstant.EXTERNALPROGRAM).compareTo(optionTYPE) == 0)
			{
			    if(smartCO.getExternalFile() != null )
			    {
				//limit the size of the file to be below of 200 MB = 200000000 bytes
				smartCO.setSmartFileEncodedBytes(new String(SecurityUtils.encodeB64NoCharEncoding(PathFileSecure.readFileToByteArray(smartCO.getExternalFile(),200000000))));
				smartCO.setSmartFileEncodedFileName(smartCO.getExternalFileFileName());
			    }
				smartCO.setSmartFileBytes(SecurityUtils.decodeB64NoCharEncoding(StringUtil.nullToEmpty(smartCO.getSmartFileEncodedBytes()).getBytes()));
			}
		    
		}
	    }
	    if(StringUtil.isEmptyString(smartSC.getTrxNbr()))
	    {
		return "submitSmart";
	    }
	    smartSC.setAppName(session.getCurrentAppName());
	  //Bug 570461 add special branch / company code
	    smartSC.setCompCode(NumberUtil.isEmptyDecimal(getSmartSpecCompCode())?session.getCompanyCode():getSmartSpecCompCode());
	    smartSC.setBranchCode(NumberUtil.isEmptyDecimal(getSmartSpecBranchCode())?session.getBranchCode():getSmartSpecBranchCode());
	    smartSC.setUserId(session.getUserName());
	    smartSC.setRunningDate(session.getRunningDateRET());
	    smartSC.setNotNewRec(!_smartWindowNewMode);
	    RequiredFieldsSC reqFilds = resetInfoMap(session);
	    smartSC.setEntityTypeInfosMap(reqFilds.getEntityTypeInfosMap());
	    smartBO.validateMandatorySmartFields(smartCOList, smartSC);
	    SAdditionsDetailsCO sAdditionsDetailsCO = smartBO.returnSAdditionsDetailsCO(true, smartCOList, smartSC);
	    // construct Audit Reference
	    set_parentPageRef(smartSC.getProgRef());
	    AuditRefCO auditRefCO = initAuditRefCO();
	    auditRefCO.setOperationType(AuditConstant.UPDATE_SMART);
	    auditRefCO.setTrxNbr(smartSC.getTrxNbr());
	    //Bug 841913 Handle SMART auditing upon upload/delete attachments
	    auditRefCO.setAuditActionDate(auditActionDate);
	    sAdditionsDetailsCO.setAuditRefCO(auditRefCO);
	    sAdditionsDetailsCO.setAuditObj(returnAuditObject(SAdditionsDetailsCO.class));
	    smartBO.updateSMARTfieldsList(sAdditionsDetailsCO, smartSC);

	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "submitSmart";
    }

    //613682
    //BMO160192 - SMART to be Able to Have Expression for Mandatory Functionality
    public String validateMandExpr()
    {
	try
	{
	    SessionCO session = returnSessionObject();

	    // 673374 checking if smartCOList is not null in case there was no
	    // smart records defined.
	    if(smartCOList != null)
	    {
		for(SmartCO smartCO : smartCOList)
		{
		    if(smartCO != null)
		    {
			    String expText = smartCO.getSAdditionsTypeVO().getMANDATORY_EXPRESSION();
			    if(StringUtil.isNotEmpty(expText))
			    {
				String expTypeCode = smartCO.getSAdditionsDetailsVO().getS_ADD_TYPE_CODE()
					.subtract(BigDecimal.ONE).toString();
				String expElementName = "";
				String upperCaseExp = expText.toUpperCase();
				int count = 0;
				boolean test = false;
				while(count >= 0)
				{
				    int start = upperCaseExp.indexOf("VALUE");
				    int left = upperCaseExp.indexOf("[");
				    int end = upperCaseExp.indexOf("]");
				    String typeCode = upperCaseExp.substring(left + 1, end);
				    String valueCode = upperCaseExp.substring(start, end + 1);
				    valueCode = valueCode.replaceAll("\\[", "\\\\[");
				    valueCode = valueCode.replaceAll("\\]", "\\\\]");
				    int intTypeCode = Integer.parseInt(typeCode) - 1;
				    SmartCO smartCOExp = smartCOList.get(intTypeCode);
				    BigDecimal optionType = smartCOExp.getSAdditionsOptionsVO().getOPTION_TYPE();
				    BigDecimal expOptionType = smartCO.getSAdditionsOptionsVO().getOPTION_TYPE();
				    String value = "";
				    if(expOptionType.compareTo(new BigDecimal(SmartConstant.PARAMETER)) == 0)
				    {
					expElementName = "lookuptxt_sAdditionsDetailsSAddOptionCode_" + expTypeCode + "_"
						+ get_pageRef();
				    }
				    else if(expOptionType.compareTo(new BigDecimal(SmartConstant.ADDITIONALTEXT)) == 0)
				    {
					expElementName = "addText_" + expTypeCode + "_" + get_pageRef();
				    }
				    else if(expOptionType.compareTo(new BigDecimal(SmartConstant.ADDITIONALNUMBER)) == 0)
				    {
					expElementName = "addNumber_" + expTypeCode + "_" + get_pageRef();
				    }
				    else if(expOptionType.compareTo(new BigDecimal(SmartConstant.ADDITIONALDATE)) == 0)
				    {
					expElementName = "addDate_" + expTypeCode + "_" + get_pageRef();
				    }
				    if(optionType.compareTo(new BigDecimal(SmartConstant.PARAMETER)) == 0)
				    {
					value = smartCOExp.getSAdditionsDetailsVO().getS_ADD_OPTION_CODE().toString();
				    }
				    else if(optionType.compareTo(new BigDecimal(SmartConstant.ADDITIONALTEXT)) == 0)
				    {
					value = "'" + smartCOExp.getSAdditionsDetailsVO().getADDITION_TEXT().toUpperCase()
						+ "'";
				    }
				    else if(optionType.compareTo(new BigDecimal(SmartConstant.ADDITIONALNUMBER)) == 0)
				    {
					value = smartCOExp.getSAdditionsDetailsVO().getADDITION_NUMBER().toString();
				    }
				    else if(optionType.compareTo(new BigDecimal(SmartConstant.ADDITIONALDATE)) == 0)
				    {
					value = "'" + DateUtil.format(smartCOExp.getSAdditionsDetailsVO().getADDITION_DATE(),
						"dd/MM/yyyy") + "'";
				    }
				    upperCaseExp = upperCaseExp.replaceAll(valueCode, StringUtil.nullEmptyToValue(value, "''"));
				    count = upperCaseExp.indexOf("VALUE");
				}

				Map<String, Object> row;
				List<Map<String, Object>> rowData = new ArrayList<Map<String, Object>>();
				row = new LinkedHashMap<String, Object>();
				row.put("", "");
				rowData.add(row);
				test = (boolean) returnCommonLibBO().executeExpression(upperCaseExp, 0, rowData);
				SYS_PARAM_SCREEN_DISPLAYVO sysparam = new SYS_PARAM_SCREEN_DISPLAYVO();
				sysparam.setIS_MANDATORY(test ? BigDecimal.ONE : BigDecimal.ZERO);
				sysparam.setELEMENT_ID(expTypeCode);
				getAdditionalScreenParams().put(expElementName, sysparam);
			    }
		    }
		}
	    }
	}
	catch(Exception ex)
	{

	    handleException(ex, null, null);
	}

	return "checkSmart";
    }
    
    

    
    
    /**
     * Method to call delete the blob from external program
     * 
     * @return String
     */
    public String detachExternalFile()
    {
	try
	{
	    SessionCO session = returnSessionObject();
	    smartSC.setAppName(session.getCurrentAppName());
	  //Bug 570461 add special branch / company code
	    smartSC.setCompCode(NumberUtil.isEmptyDecimal(getSmartSpecCompCode())?session.getCompanyCode():getSmartSpecCompCode());
	    smartSC.setBranchCode(NumberUtil.isEmptyDecimal(getSmartSpecBranchCode())?session.getBranchCode():getSmartSpecBranchCode());
	    // set maxObjCode to zero as a flag to delete the blob only
	    smartSC.setMaxObjCode(0);
	  //Bug 841913 Handle SMART auditing upon upload/delete attachments
	    set_pageRef(smartSC.getProgRef());
	    setAuditTrxNbr(smartSC.getTrxNbr());
	 // construct Audit Reference
	    AuditRefCO auditRefCO = initAuditRefCO();
	    auditRefCO.setOperationType(AuditConstant.UPDATE_SMART);
	    auditRefCO.setTrxNbr(smartSC.getTrxNbr());
	    smartSC.setAuditRefCO(auditRefCO);
	    auditActionDate = smartBO.deleteSmartRec(smartSC);// TODO finalise and audit
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "detachExtFile";
    }

    /**
     * sets the audit json string --overriding the default
     * 
     * @param obj java bean (CO or VO)
     */
    public void putAuditObject(Object obj)
    {
//	/*
//	 * FIX issue #642232 
//	 https://zerokspot.com/weblog/2008/02/09/default-value-handling-with-jsonlib/
//	 By default Bigdecimal with null values are transfromed to 0 instead of null inside the returned json string,
//	 This was adding additional rows in audit report. to fix this default behavior we should change the DefaultValueProcessor for Bigdecimal 
//	*/
//	JsonConfig jsonConf = new JsonConfig();
//	jsonConf.registerDefaultValueProcessor(BigDecimal.class, 
//	    new DefaultValueProcessor(){
//	        public Object getDefaultValue(Class type){
//	            return JSONNull.getInstance();
//	        }
//	    });
//	
//	JSONObject jsonObj = JSONObject.fromObject(obj,jsonConf);
//	set_smartAuditJsonStr(jsonObj.toString());
	
	//Changed the JSON parsing method from JSONUTIL to JACKSON to prevent BigDecimal false rounding
	set_smartAuditJsonStr(returnSerializedStrFromObj(obj));
    }

    /**
     * gets audit object from audit json string
     * 
     * @param objClass object class to be mapped to
     * @return
     */
    @SuppressWarnings("unchecked")
    public Object returnAuditObject(Class objClass)
    {
	//Changed the JSON parsing method from JSONUTIL to JACKSON to prevent BigDecimal false rounding
	ObjectMapper mapper = new ObjectMapper();
	//ignore null attributes to reduce the generated JSON size
	mapper.setSerializationInclusion(Inclusion.NON_NULL);
	mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
	mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	//added Naming strategy and date format to handle OMNI webservices
	mapper.setPropertyNamingStrategy(PathPropertyNamingStrategy.KEEP_AS_IS);
	mapper.getSerializationConfig().withDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SZ"));
	SAdditionsDetailsCO jsonFilter = null;
	try
	{
	    jsonFilter = (SAdditionsDetailsCO) mapper.readValue(_smartAuditJsonStr, objClass);
	    
	}
	catch (Exception e) {
	    Log.getInstance().error(e,"[SmartAction] ERROR returnAuditObject");
	}
//	JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(_smartAuditJsonStr);
//	SAdditionsDetailsCO sAdditionsDetailsCO = (SAdditionsDetailsCO) JSONObject.toBean(jsonFilter, objClass);
	
//	ArrayList<S_ADDITIONS_DETAILSVO> sAdditionsDetailsVOList = jsonFilter.getSAdditionsDetailsVOList();
//	
//	(ArrayList<S_ADDITIONS_DETAILSVO>) JSONArray
//		.toCollection(JSONArray.fromObject(jsonFilter.get("sAdditionsDetailsVOList")),
//			S_ADDITIONS_DETAILSVO.class);
//	
//	sAdditionsDetailsCO.setSAdditionsDetailsVOList(sAdditionsDetailsVOList);
	return jsonFilter;
    }

    /**
     * @param smartBO the smartBO to set
     */
    public void setSmartBO(SmartBO smartBO)
    {
	this.smartBO = smartBO;
    }

    /**
     * @return the smartCOList
     */
    public ArrayList<SmartCO> getSmartCOList()
    {
	return smartCOList;
    }

    /**
     * @param smartCOList the smartCOList to set
     */
    public void setSmartCOList(ArrayList<SmartCO> smartCOList)
    {
	this.smartCOList = smartCOList;
    }

    /**
     * @return the smartSC
     */
    public Object getModel()
    {
	return smartSC;
    }

    /**
     * @return the smartDefined
     */
    public boolean isSmartDefined()
    {
	return smartDefined;
    }

    /**
     * @param smartDefined the smartDefined to set
     */
    public void setSmartDefined(boolean smartDefined)
    {
	this.smartDefined = smartDefined;
    }

    /**
     * @return the randomNumber
     */
    public Double getRandomNumber()
    {
	return randomNumber;
    }

    /**
     * @param randomNumber the randomNumber to set
     */
    public void setRandomNumber(Double randomNumber)
    {
	this.randomNumber = randomNumber;
    }

    /**
     * @return the _smartAuditJsonStr
     */
    public String get_smartAuditJsonStr()
    {
	return _smartAuditJsonStr;
    }

    /**
     * @param smartAuditJsonStr the _smartAuditJsonStr to set
     */
    public void set_smartAuditJsonStr(String smartAuditJsonStr)
    {
	_smartAuditJsonStr = smartAuditJsonStr;
    }

    /**
     * @return the fileStream
     */
    public InputStream getFileStream()
    {
	return fileStream;
    }

    /**
     * @param fileStream the fileStream to set
     */
    public void setFileStream(InputStream fileStream)
    {
	this.fileStream = fileStream;
    }

    /**
     * @return the filename
     */
    public String getFilename()
    {
	return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename)
    {
	this.filename = filename;
    }

    /**
     * @return the _parentPageRef
     */
    public String get_parentPageRef()
    {
	return _parentPageRef;
    }

    /**
     * @param parentPageRef the _parentPageRef to set
     */
    public void set_parentPageRef(String parentPageRef)
    {
	_parentPageRef = parentPageRef;
    }

    /**
     * @return the _smartWindowNewMode
     */
    public boolean is_smartWindowNewMode()
    {
        return _smartWindowNewMode;
    }

    /**
     * @param smartWindowNewMode the _smartWindowNewMode to set
     */
    public void set_smartWindowNewMode(boolean smartWindowNewMode)
    {
        _smartWindowNewMode = smartWindowNewMode;
    }

    /**
     * @return the smartCount
     */
    public int getSmartCount()
    {
        return smartCount;
    }

    /**
     * @param smartCount the smartCount to set
     */
    public void setSmartCount(int smartCount)
    {
        this.smartCount = smartCount;
    }

    public boolean isUseActiveX()
    {
        return useActiveX;
    }

    public void setUseActiveX(boolean useActiveX)
    {
        this.useActiveX = useActiveX;
    }

    public String getSmartLanguage()
    {
        return smartLanguage;
    }

    public void setSmartLanguage(String smartLanguage)
    {
        this.smartLanguage = smartLanguage;
    }

    public void setScanAxVersion(String scanAxVersion)
    {
	this.scanAxVersion = scanAxVersion;
    }

    public String getScanAxVersion()
    {
	return scanAxVersion;
    }

    public String getTwainCLSID()
    {
        return twainCLSID;
    }

    public void setTwainCLSID(String twainCLSID)
    {
        this.twainCLSID = twainCLSID;
    }

    public String getScanExVersion()
    {
        return scanExVersion;
    }

    public BigDecimal getSaddTypeCode()
    {
        return saddTypeCode;
    }

    public void setSaddTypeCode(BigDecimal saddTypeCode)
    {
        this.saddTypeCode = saddTypeCode;
    }

    public String getSmart_addScreenParams()
    {
        return smart_addScreenParams;
    }

    public void setSmart_addScreenParams(String smart_addScreenParams)
    {
        this.smart_addScreenParams = smart_addScreenParams;
    }

    public String getAuditActionDate()
    {
        return auditActionDate;
    }

    public void setAuditActionDate(String auditActionDate)
    {
        this.auditActionDate = auditActionDate;
    }

}
