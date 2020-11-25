/**
 * 
 */
package com.path.actions.common.customization.button;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.path.actions.admin.dynamicparams.DynamicParamsAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.customization.button.ButtonCustomizationBO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ENTITY_TYPEVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.vo.admin.dynamicparams.DynamicParamsVO;
import com.path.vo.admin.dynamicparams.ListParamVO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.ThemeCustomizationConstant;
import com.path.vo.common.customization.button.ButtonCustomizationCO;
import com.path.vo.common.customization.button.ButtonCustomizationCommonMethods;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.customization.button.ButtonCustomizationConstants.BtnCustSessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationSC;
import com.path.vo.common.customization.button.CustomActionParamCO;
import com.path.vo.common.customization.button.SysParamActionArgListSC;
import com.path.vo.common.customization.button.SysParamBtnCustOutMapSC;
import com.path.vo.common.customization.button.SysParamGlobalActArgMapSC;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
import com.path.vo.common.dynamicscreen.DynamicScreenConstant;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;
import com.path.vo.common.dynlookup.DynCommonLookupSC;
import com.path.vo.common.screengenerator.DynamicScreenFileCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * WorkflowAction.java used to
 */
public class ButtonCustomizationMaintAction extends DynamicParamsAction
{
    private File uploadFile;
    private InputStream imageStream;
    private ButtonCustomizationBO buttonCustomizationBO;
    private ButtonCustomizationCO buttonCustomizationCO = new ButtonCustomizationCO();
    List<SelectCO> mappingSourceList  = new ArrayList<SelectCO>();
    List<SelectCO> mappingSourceArrayList  = new ArrayList<SelectCO>();
    List<SelectCO> operationTypeList  = new ArrayList<SelectCO>();
    List<SelectCO> actionTypeList  = new ArrayList<SelectCO>();
    List<ButtonCustomizationCO> argumentsList = new ArrayList<ButtonCustomizationCO>();
    private ButtonCustomizationSC dependancyCriteria = new ButtonCustomizationSC();
    
    private Map<String,DynamicScreenFileCO> dynFileElemHm = new HashMap<String,DynamicScreenFileCO>();
    
    @Override
    public Object getModel()
    {
	return buttonCustomizationCO;
    }

    public String loadButtonCustDialog()
    {
	SessionCO sessionCO = returnSessionObject();
	if(StringUtil.isNotEmpty(buttonCustomizationCO.getAppName()))
	{
	    buttonCustomizationCO.getSysParamBtnCustVO().setAPP_NAME(buttonCustomizationCO.getAppName());
	}
	else
	{
	    buttonCustomizationCO.getSysParamBtnCustVO().setAPP_NAME(sessionCO.getCurrentAppName());
	}

	try
	{
	    String globalActvtyAccessRight = null;
	    String btnCustAccessRight = null;	    
	    String currAppName = sessionCO.getCurrentAppName();
	    
	    String[] opts = {ConstantsCommon.GLOBAL_ACTIVITY_OPT, ConstantsCommon.BTN_CONFING_OPT};
	    HashMap<String, String> accessOpts = returnAccessRightByProgRef(opts, currAppName);
	    if(accessOpts!=null && !accessOpts.isEmpty())
	    {
		globalActvtyAccessRight = accessOpts.get(ConstantsCommon.GLOBAL_ACTIVITY_OPT+"_"+currAppName);
		btnCustAccessRight = accessOpts.get(ConstantsCommon.BTN_CONFING_OPT+"_"+currAppName);
	    }
	    
	    /**
	     * (ToolBarId=ROOT is only used for Global Activity)
	     * this block of code check that 
	     * if both Global Activiy and Button Customization rights are disabled
	     * OR one of two is disabled and ToolBarId is empty
	     * OR Global Activity rights are disabled and ToolBarId is equals to ROOT
	     * OR Button Customization rights are disabled and ToolBarId is not equals to ROOT
	     * then throws Exception with Message No Access
	     */
	    if((globalActvtyAccessRight == null && btnCustAccessRight == null)
		|| ((globalActvtyAccessRight == null || btnCustAccessRight ==null)
			&& StringUtil.isEmptyString(buttonCustomizationCO.getSysParamBtnCustVO().getTOOLBAR_ID()))
		|| (globalActvtyAccessRight == null && StringUtil.isNotEmpty(buttonCustomizationCO.getSysParamBtnCustVO().getTOOLBAR_ID())
		    	&& buttonCustomizationCO.getSysParamBtnCustVO().getTOOLBAR_ID().equals(ConstantsCommon.PROGREF_ROOT))
		|| (btnCustAccessRight == null && StringUtil.isNotEmpty(buttonCustomizationCO.getSysParamBtnCustVO().getTOOLBAR_ID())
		    	&& !buttonCustomizationCO.getSysParamBtnCustVO().getTOOLBAR_ID().equals(ConstantsCommon.PROGREF_ROOT)))
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
	return "loadButtonCustDialog";
    }
    
    public String returnIconImage()
    {
	String returnValue = "jsonSuccess";
	try
	{
	    if(!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamBtnCustVO().getBTN_ID()))
	    {
		ButtonCustomizationCO buttonCustomizationCOResult = buttonCustomizationBO.loadButtonCustDetails(buttonCustomizationCO);
		byte[] imagesBytes = buttonCustomizationCOResult.getSysParamBtnCustVO().getICON_IMAGE();
		if(imagesBytes != null && imagesBytes.length > 0)
		{
		    imageStream  = new ByteArrayInputStream(imagesBytes);
		    returnValue  = ButtonCustomizationConstants.RESULT_RETURN_IMAGE; 
		}
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
	return returnValue;
    }
    
    public String loadButtonCustCopyDialog()
    {
	return "loadButtonCustCopyDialog";
    }
    
    public String loadButtonCustDetails()
    {
	try
	{
	    String progRef = StringUtil.nullEmptyToValue(get_pageRef(), ConstantsCommon.PROGREF_ROOT);
	    if(progRef != null && progRef.endsWith("_ALERT"))
	    {
		progRef = progRef.substring(0, progRef.indexOf("_ALERT"));
	    }

	    buttonCustomizationCO.setProgRef(progRef);
	    buttonCustomizationCO.getSysParamBtnCustVO().setPROG_REF(progRef);
	    buttonCustomizationCO.setAppName(returnSessionObject().getCurrentAppName());
	    buttonCustomizationCO = buttonCustomizationBO.loadButtonCustDetails(buttonCustomizationCO);
	    if(buttonCustomizationCO != null)
	    {
	    buttonCustomizationCO.setCurrentAccessProgRef(buttonCustomizationCO.getSysParamBtnCustVO().getACCESS_PROG_REF());
	    if( buttonCustomizationCO.getButtonCustCOList() != null)
	    {
		StringBuffer autoCompleteValues = new StringBuffer(StringUtil.nullToEmpty(buttonCustomizationCO.getAutoCompleteTags())); 
		Map<BigDecimal, ButtonCustomizationCO> screenElementsMap = new HashMap<BigDecimal, ButtonCustomizationCO>();
		for(ButtonCustomizationCO screenCO : buttonCustomizationCO.getButtonCustCOList())
		{
		    autoCompleteValues.append(",");
		    autoCompleteValues.append("\"[screen." + getText(StringUtil.nullToEmpty(screenCO.getSysParamScreenElementsVO().getFIELD_KEY_LABEL_CODE())).replace(" ", "_") + "{F." + screenCO.getSysParamScreenElementsVO().getFLD_IDENTIFIER() +  "}]\"");
		    screenElementsMap.put(screenCO.getSysParamScreenElementsVO().getFLD_IDENTIFIER(), screenCO);
		}
		//Add entity type tags
		for(SYS_PARAM_SCREEN_ENTITY_TYPEVO entityVO : buttonCustomizationCO.getButtonCustCOEntityTypesList())
		{
		    autoCompleteValues.append(",");
		    autoCompleteValues.append("\"[" + getText(StringUtil.nullToEmpty(entityVO.getPROPERTY_NAME())).replace(" ", "_") +"]\"");
		}
		buttonCustomizationCO.setAutoCompleteTags(autoCompleteValues.toString());
		if(StringUtil.isNotEmpty(buttonCustomizationCO.getSysParamBtnCustVO().getRESULT_EXPR()))
		{    
		    ButtonCustomizationGridAction gridAction = new ButtonCustomizationGridAction();
		    String returnedResultExpr = gridAction.unformatScreenElement(screenElementsMap, buttonCustomizationCO.getSysParamBtnCustVO().getRESULT_EXPR());
		    buttonCustomizationCO.getSysParamBtnCustVO().setRESULT_EXPR(returnedResultExpr);
		}
		//set visibility expression on button load
		if(StringUtil.isNotEmpty(buttonCustomizationCO.getSysParamBtnCustVO().getVISIBILITY_EXPRESSION()))
		{    
		    ButtonCustomizationGridAction gridAction = new ButtonCustomizationGridAction();
		    String returnedVisibilityExpr = gridAction.unformatScreenElement(screenElementsMap, buttonCustomizationCO.getSysParamBtnCustVO().getVISIBILITY_EXPRESSION());
		    buttonCustomizationCO.getSysParamBtnCustVO().setVISIBILITY_EXPRESSION(returnedVisibilityExpr);
		}  
	    }
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "loadButtonCustDetails";
    }
    
    public String loadButtonCustActionsDetails()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamBtnCustActionsVO().getBTN_ID())
		    && !NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamBtnCustActionsVO().getOP_ID())
		     &&  ButtonCustomizationConstants.OP_TYPE.ACTION.equals(buttonCustomizationCO.getSysParamBtnCustActionsVO().getOP_TYPE()))
	    {
		SessionCO sessionCO = returnSessionObject();
		buttonCustomizationCO.setLanguage(sessionCO.getLanguage());
		buttonCustomizationCO = buttonCustomizationBO.loadButtonCustActionsDetails(buttonCustomizationCO);
		String screenTitle = buttonCustomizationCO.getSysParamBtnCustActionsVO().getSCREEN_TITLE();
		if(StringUtil.isNotEmpty(screenTitle)) 
		{
		    buttonCustomizationCO.getSysParamBtnCustActionsVO().setSCREEN_TITLE(screenTitle.replaceAll("'", "\\\\'"));
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "loadButtonCustActionsDetails";
    }
    
    public String saveButtonCustDetails()
    {
	try
	{
	    //set the icon image bytes in case it was selected in screen 
	    if(uploadFile != null && uploadFile.isFile() && uploadFile.length() > 0)
	    {
		//limit the size of the file to be below of 200 MB = 200000000 bytes 
		buttonCustomizationCO.getSysParamBtnCustVO().setICON_IMAGE(PathFileSecure.readFileToByteArray(uploadFile,200000000));
	    }
	    buttonCustomizationCO.getSysParamBtnCustVO().setAPPLY_FORM_VALIDATION_YN(NumberUtil.emptyDecimalToZero(buttonCustomizationCO.getSysParamBtnCustVO().getAPPLY_FORM_VALIDATION_YN()));
	    SessionCO sessionCO = returnSessionObject();
	    buttonCustomizationCO.setUserName(sessionCO.getUserName());
	    buttonCustomizationCO.setRunningDate(sessionCO.getRunningDateRET());
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getSysParamBtnCustVO().getAPP_NAME()))
	    {
		buttonCustomizationCO.setAppName(buttonCustomizationCO.getSysParamBtnCustVO().getAPP_NAME());
	    }
	    else
	    {
		buttonCustomizationCO.getSysParamBtnCustVO().setAPP_NAME(sessionCO.getCurrentAppName());
		buttonCustomizationCO.setAppName(sessionCO.getCurrentAppName());
	    }
	    
	    String progRef =  StringUtil.nullEmptyToValue(get_pageRef(), ConstantsCommon.PROGREF_ROOT);
	    if(progRef != null && progRef.endsWith("_ALERT"))
	    {
		progRef = progRef.substring(0, progRef.indexOf("_ALERT"));
	    }
	    buttonCustomizationCO.setProgRef(progRef);
	    
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(buttonCustomizationCO.getGridUpdate(), ButtonCustomizationCO.class, true);
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<ButtonCustomizationCO> buttonCustomizationCOList = gu.getLstAllRec();
		    if(buttonCustomizationCOList != null)
		    {
			for(ButtonCustomizationCO  co : buttonCustomizationCOList)
			{
			    checkConstraint(buttonCustomizationCO.getSysParamBtnCustVO().getBTN_ID(),co.getSysParamBtnCustActionsVO().getOP_ID());
			}
			if( !buttonCustomizationCOList.isEmpty())
			{
			    buttonCustomizationCO.setButtonCustCOList(buttonCustomizationCOList);
			}
		    }
		}
	    }
	    
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getOutputMapGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(buttonCustomizationCO.getOutputMapGridUpdate(), SysParamBtnCustOutMapSC.class, true);
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<SysParamBtnCustOutMapSC> sysParamBtnCustOutMapSCList = gu.getLstAllRec();
		    ArrayList<String> nestedArr = new ArrayList();
		    if(sysParamBtnCustOutMapSCList != null)
		    {
			for(SysParamBtnCustOutMapSC sc : sysParamBtnCustOutMapSCList) 
			{
			    for(String s : nestedArr)
			    {
				if(s.startsWith(sc.getSysParamBtnCustOutMap().getMAP_KEY()) || sc.getSysParamBtnCustOutMap().getMAP_KEY().startsWith(s))
				{
				    throw new BOException(MessageCodes.LABEL_CODE_EXIST);
				}
			    }
			    nestedArr.add(sc.getSysParamBtnCustOutMap().getMAP_KEY());
			}
			if(!sysParamBtnCustOutMapSCList.isEmpty())
			{
			    buttonCustomizationCO.setSysParamBtnCustOutList(sysParamBtnCustOutMapSCList);
			}
		    }
		}
	    }

	    /*TP#983067 Option to load JS Method to be called from js File located on the server*/
	    //checking script Urls validity and existence
	    List<String> urisRetrieved = buttonCustomizationCO.getButtonCustCOList().stream()
		    .map( btnCustCo -> {
			String trimmedUri = (btnCustCo.getSysParamBtnCustActionsVO() != null )?StringUtil.nullToEmpty(btnCustCo.getSysParamBtnCustActionsVO().getSCRIPT_URL()).trim():"";
			btnCustCo.getSysParamBtnCustActionsVO().setSCRIPT_URL(trimmedUri);
			return trimmedUri;
		    })
		    .collect(Collectors.toList());

	    //check invalid uris and add them to invalidUrlsMessage.
	    Pattern pattern = Pattern.compile("^(?!.*\\.\\.\\/.*)([a-zA-Z0-9\\s_\\/\\\\.\\-\\(\\)]*)([a-zA-Z0-9]\\.js)$");
	    String invalidUrlsMessage = urisRetrieved.stream()
		    .filter(uri -> {
			return !pattern.matcher(uri).find();
		    })
		    .reduce("", (message, invalidUri)-> message+invalidUri+((StringUtil.isNotEmpty(invalidUri))?"\r\n":"") );
	    
		if(StringUtil.isNotEmpty(invalidUrlsMessage))
		{
		    throw new BOException(getText("invalid_js_file_key")+":\r\n"+invalidUrlsMessage);
		}
		List<String> jsUris = urisRetrieved.stream()
			.filter(uri -> FileUtil.isExtension(uri, "js"))
			.collect(Collectors.toList());
		for(String jsUri : jsUris)
		{
		    File tmpFile=null;
		    tmpFile = new PathFileSecure(FileUtil.getFileURLByName("repository") + '/'+jsUri);
		    if(!tmpFile.exists() || tmpFile.isDirectory())
		    {
			throw new BOException(getText("specified_file_not_found_key")+": "+jsUri);
		    }   

		}
	    
	    Map<String, Object> condExprMap = buildCondExprValues(false);
	    buttonCustomizationCO = buttonCustomizationBO.saveButtonCustDetails(buttonCustomizationCO,condExprMap);
	    //to avoid returning the image byte in response , for performance reason we should set it to null
	    buttonCustomizationCO.getSysParamBtnCustVO().setICON_IMAGE(null);
	    set_warning(getText("Record_Saved_Successfully_key"));
	    set_msgTitle(getText("info_msg_title_key"));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonFileSuccess";
    }
    
/**
 * check whether the btn and opid exists in the children table (sys_param_btn_cust_output_map) then we cannot 
 * delete or update the record in the parent table (sys_param_btn_cust_actions) unless we delete the children records
 * @param btnId
 * @param opId
 * @throws BaseException 
 */
private void checkConstraint(BigDecimal btnId,BigDecimal opId) throws BaseException
{
    SysParamBtnCustOutMapSC sc = new SysParamBtnCustOutMapSC();
    sc.getSysParamBtnCustOutMap().setBTN_ID(btnId);
    sc.getSysParamBtnCustOutMap().setOP_ID(opId);
    int count = buttonCustomizationBO.returnBtnCustOutMapCount(sc);
    if(count > 0)
    {
	throw new BOException(MessageCodes.MESSAGE_IN_USE);
    }
}

public String saveButtonActionArgList()
{
    if(StringUtil.isNotEmpty(buttonCustomizationCO.getActionArgListGridUpdate()))
    {
	try
	{
        	GridUpdates gu = getGridUpdates(buttonCustomizationCO.getActionArgListGridUpdate(), SysParamActionArgListSC.class, true);
        	if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
        	{
        	    List<SysParamActionArgListSC> buttonCustomizationActionArgList = gu.getLstAllRec();
        	    if(buttonCustomizationActionArgList != null && !buttonCustomizationActionArgList.isEmpty())
        	    {
        		SessionCO sessionCO  = returnSessionObject();
        		buttonCustomizationCO.setRunningDate(sessionCO.getRunningDateRET());
        		buttonCustomizationCO.setUserName(sessionCO.getUserName());
        		buttonCustomizationCO.setSysParamActionArgListArray(buttonCustomizationActionArgList);
        		buttonCustomizationBO.saveButtonActionArgList(buttonCustomizationCO);
        	    }
        	}
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
    }
    return "jsonSuccess";
}

public String deleteButtonActionArgList()
{
    try
	{
	    if(!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamActionArgList().getBTN_ID())
		    &&!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamActionArgList().getARG_ID())
		    &&!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamActionArgList().getOP_ID())
		    &&!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamActionArgList().getLINE_NO()))
	    {
		SessionCO sessCO = returnSessionObject();
		buttonCustomizationCO.setRunningDate(sessCO.getRunningDateRET());
		buttonCustomizationCO.setUserName(sessCO.getUserName());
		buttonCustomizationBO.deleteButtonActionArgList(buttonCustomizationCO);
		
		set_warning(getText("Record_was_Deleted_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
}
    
    public String deleteButtonCustDetails()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamBtnCustVO().getBTN_ID()))
	    {
		buttonCustomizationBO.deleteButtonCustDetails(buttonCustomizationCO);
		
		set_warning(getText("Record_was_Deleted_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    public String deleteButtonCustOutMap()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamBtnCustOutMap().getLINE_NO()))
	    {
		buttonCustomizationBO.deleteButtonCustOutMap(buttonCustomizationCO.getSysParamBtnCustOutMap());
		
		set_warning(getText("Record_was_Deleted_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    public String deleteButtonCustFieldMapping()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getMapId()))
	    {
		buttonCustomizationBO.deleteButtonCustFieldMapping(buttonCustomizationCO);
		
		set_warning(getText("Record_was_Deleted_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    public String deleteButtonAction()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamBtnCustActionsVO().getBTN_ID())
		    && !NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamBtnCustActionsVO().getOP_ID()))
	    {
		checkConstraint(buttonCustomizationCO.getSysParamBtnCustActionsVO().getBTN_ID(), buttonCustomizationCO.getSysParamBtnCustActionsVO().getOP_ID());
		buttonCustomizationBO.deleteButtonAction(buttonCustomizationCO);
		
		set_warning(getText("Record_was_Deleted_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    public String saveButtonAction()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamBtnCustActionsVO().getBTN_ID())
		    && !NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamBtnCustActionsVO().getOP_ID()))
	    {
		SessionCO sessionCO = returnSessionObject();
		buttonCustomizationCO.setUserName(sessionCO.getUserName());
		buttonCustomizationCO.setRunningDate(sessionCO.getRunningDateRET());
		
		if(ButtonCustomizationConstants.API_TYPE.SCREEN.equals(buttonCustomizationCO.getImImalApiVO()
			.getSERVICE_TYPE()) && StringUtil.isNotEmpty(buttonCustomizationCO.getDynScrParamMapGridUpdate()))
		{
		    GridUpdates gu = getGridUpdates(buttonCustomizationCO.getDynScrParamMapGridUpdate(),
			    DynamicScreenParamsMapCO.class, true);
		    
		    if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		    {
			List<DynamicScreenParamsMapCO> dynamicScreenParamsMapCOList = gu.getLstAllRec();
			if(dynamicScreenParamsMapCOList != null && !dynamicScreenParamsMapCOList.isEmpty())
			{
			    buttonCustomizationCO.setDynamicScreenParamsMapCOList(dynamicScreenParamsMapCOList);
			}
		    }
		}
		else
		{
		    buttonCustomizationCO.setButtonCustCOList(argumentsList);
		    for(ButtonCustomizationCO co : argumentsList)
		    {
			if(co!=null)
			{
			    SysParamActionArgListSC sc = new SysParamActionArgListSC();
			    sc.getSysParamActionArgListVO().setARG_ID(co.getSysParamActionArgMapVO().getARG_ID());
			    sc.getSysParamActionArgListVO().setBTN_ID(buttonCustomizationCO.getSysParamBtnCustActionsVO().getBTN_ID());
			    sc.getSysParamActionArgListVO().setOP_ID(co.getSysParamActionArgMapVO().getOP_ID());
			    //incase we save an arg_type list with no values inside the list 
			    if(ButtonCustomizationConstants.MAP_TYPE.LIST.equals(co.getSysParamActionArgMapVO().getMAP_TYPE()))
			    {
				    int count = buttonCustomizationBO.returnBtnCustActionArgListCount(sc);
				    if(count == 0)
				    {
					throw new BOException(MessageCodes.NO_RECORD_FOUND);
				    }
			    }
			    else // in case we change the arg type from list to any other type then delete all list data
			    {
				buttonCustomizationBO.deleteAllButtonActionArgList(sc);
			    }
			 }
		    }
			
		}
		buttonCustomizationBO.saveButtonAction(buttonCustomizationCO);    
		
		set_warning(getText("Record_Saved_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    public String dependencyByActionCode()
    {
	try
	{
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getApiCodeValue()))
	    {	
		SessionCO sessionCO = returnSessionObject();
		buttonCustomizationCO.setCompCode(sessionCO.getCompanyCode());
		buttonCustomizationCO.setBranchCode(sessionCO.getBranchCode());
		buttonCustomizationCO.setUserName(sessionCO.getUserName());
		buttonCustomizationCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
		buttonCustomizationCO.setLanguage(sessionCO.getLanguage());
		buttonCustomizationCO.getImImalApiVO().setRELATED_APP(sessionCO.getCurrentAppName());
		buttonCustomizationCO = buttonCustomizationBO.dependencyByActionCode(buttonCustomizationCO);
	    }
	    else
	    {
		buttonCustomizationCO.getImImalApiVO().setSERVICE_TYPE(null);
		buttonCustomizationCO.getImImalApiVO().setDESCRIPTION(null);
		buttonCustomizationCO.getImImalApiVO().setPROCEDURE_NAME(null);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    buttonCustomizationCO.setApiCodeValue(null);
	    if(!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getLinkToPreviousAction()))
	    {
		buttonCustomizationCO.getSysParamBtnCustActionsVO().setAPI_CODE(null);
	    }
	}
	NumberUtil.resetEmptyValues(buttonCustomizationCO);
	return "jsonSuccess";
    }
    
    public String dependencyByBtnOutOpId()
    {
	try
	{
	    	SessionCO sessionCO = returnSessionObject();
	    	dependancyCriteria.setCurrAppName(sessionCO.getCurrentAppName());
	    	dependancyCriteria.setNbRec(1);
		List<ButtonCustomizationCO>  list = buttonCustomizationBO.returnActionsOutMapList(dependancyCriteria);
		if(!list.isEmpty() || list.size()>0)
		{
		    buttonCustomizationCO  = list.get(0);
		}
		else
		{
		    buttonCustomizationCO.getSysParamBtnCustActionsVO().setOP_ID(null);
		    buttonCustomizationCO.getSysParamBtnCustActionsVO().setDESCRIPTION(null);
		}
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    buttonCustomizationCO.getSysParamBtnCustActionsVO().setOP_ID(null);
	    buttonCustomizationCO.getSysParamBtnCustActionsVO().setDESCRIPTION(null);
	}
	NumberUtil.resetEmptyValues(buttonCustomizationCO);
	return "jsonSuccess";
    }
    
    public String dependencyByGlobalActionCode()
    {
	try
	{
	    List<ButtonCustomizationCO> actionsList = null;
	    dependancyCriteria.setNbRec(-1);
	    if(!NumberUtil.isEmptyDecimal(dependancyCriteria.getDependentOpId()))
	    {
		actionsList = buttonCustomizationBO.returnActionsList(dependancyCriteria);
		if(actionsList == null || actionsList.isEmpty() || actionsList.size() > 1)
		{
		    throw new BOException(MessageCodes.INVALID_ACTION);
		}
		buttonCustomizationCO = actionsList.get(0);
	    }
	    else
	    {
		buttonCustomizationCO.getSysParamBtnCustActionsVO().setOP_ID(null);
		buttonCustomizationCO.getSysParamBtnCustActionsVO().setDESCRIPTION(null);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	NumberUtil.resetEmptyValues(buttonCustomizationCO);
	return "jsonSuccess";
    }
    
    public String dependencyByLinkArg()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamActionArgMapVO().getARG_ID()))
	    {	
		SessionCO sessionCO = returnSessionObject();
		buttonCustomizationCO.setLanguage(sessionCO.getLanguage());
		buttonCustomizationCO = buttonCustomizationBO.dependencyByLinkArg(buttonCustomizationCO);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    buttonCustomizationCO.getSysParamActionArgMapVO().setARG_ID(null);
	}
	NumberUtil.resetEmptyValues(buttonCustomizationCO);
	return "jsonSuccess";
    }
    
    public String dependencyByScreenElementMap()
    {
	try
	{
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_VALUE())
		    && StringUtil.isNumeric(buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_VALUE(), false))
	    {	
		SessionCO sessionCO = returnSessionObject();
		
		if(DynamicScreenConstant.MAP_ELEMENT_TYPE.DYN_BTN_LINK_TO_DYN_SCREEN.equals(String.valueOf(buttonCustomizationCO.getMapElementType()))
			|| DynamicScreenConstant.MAP_ELEMENT_TYPE.DYN_BTN_LINK_TO_GLOBAL_ACT.equals(String.valueOf(buttonCustomizationCO.getMapElementType())))
		{    
		    DynCommonLookupSC criteria = new DynCommonLookupSC();
		    criteria.setElementId(new BigDecimal(buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_VALUE()));
		    criteria.setScreenId(buttonCustomizationCO.getDynScreenId());
		    criteria.setLovTypeId(DynamicScreenConstant.LOV_ELEMENT_TYPE);
		    criteria.setPreferredLanguage(sessionCO.getLanguage());
		    DynamicScreenCO dynamicScreenCO = buttonCustomizationBO.dependencyByScreenElementId(criteria);
		    
		    if(StringUtil.isNotEmpty(dynamicScreenCO.getElementId()))
		    {
			buttonCustomizationCO.getSysParamBtnCustVO().setDESCRIPTION(dynamicScreenCO.getElementId());
		    }
		}
		else
		{
		    buttonCustomizationCO.getSysParamBtnCustVO().setAPP_NAME(StringUtil.nullEmptyToValue(buttonCustomizationCO.getSysParamBtnCustVO().getAPP_NAME(), sessionCO.getCurrentAppName()));
		    String theProgRef = StringUtil.nullEmptyToValue(buttonCustomizationCO.getSysParamBtnCustVO().getPROG_REF(),get_pageRef());
		    buttonCustomizationCO.getSysParamBtnCustVO().setPROG_REF(returnCommonLibBO().returnOrginProgRef(buttonCustomizationCO.getSysParamBtnCustVO().getAPP_NAME(),theProgRef));
		
		    buttonCustomizationCO = buttonCustomizationBO.dependencyBySourceMap(buttonCustomizationCO);
		
		    if(StringUtil.isNotEmpty(buttonCustomizationCO.getSysParamBtnCustVO().getDESCRIPTION()))
		    {
			buttonCustomizationCO.getSysParamBtnCustVO().setDESCRIPTION(getText(buttonCustomizationCO.getSysParamBtnCustVO().getDESCRIPTION()));
		    }
		}
	    }	
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    buttonCustomizationCO.getSysParamActionArgMapVO().setMAP_VALUE(null);
	}
	NumberUtil.resetEmptyValues(buttonCustomizationCO);
	return "jsonSuccess";
    }
    
    public String dependencyByConstantMapping()
    {
	try
	{
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_VALUE())
		    && StringUtil.isNotEmpty(buttonCustomizationCO.getImApiArgumentVO().getARG_TYPE()))
	    {	
		
		//checking on numeric type
		if(ButtonCustomizationConstants.ARG_TYPE.NUMBER.equals(buttonCustomizationCO.getImApiArgumentVO().getARG_TYPE())
			&& !StringUtil.isNumeric(buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_VALUE(), false))
		{
		    throw new BOException(MessageCodes.INVALID_VALUE);
		}
		//TODO checking on date type
	    }	
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    buttonCustomizationCO.getSysParamActionArgMapVO().setMAP_VALUE(null);
	}
	NumberUtil.resetEmptyValues(buttonCustomizationCO);
	return "jsonSuccess";
    }
    
    public String dependencyBySessionElementMap()
    {
	try
	{
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_VALUE()))
	    {	
		String sessionFieldValue = buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_VALUE();
		Class<?> sessionFieldType = PathPropertyUtil.returnPropertyType(returnSessionObject(), sessionFieldValue);
		
		if(sessionFieldType == null || !ButtonCustomizationConstants.SESSIONCO_PROPERTIES.containsKey(sessionFieldValue))
		{
		    throw new BOException(MessageCodes.INVALID_VALUE);
		}
		buttonCustomizationCO.setFieldDesc(ButtonCustomizationConstants.SESSIONCO_PROPERTIES.get(
		buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_VALUE()).getDescription());
	    }	
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    buttonCustomizationCO.getSysParamActionArgMapVO().setMAP_VALUE(null);
	}
	NumberUtil.resetEmptyValues(buttonCustomizationCO);
	return "jsonSuccess";
    }
    
    public String dependencyByGridColumnElementMap()
    {
	try
	{
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_VALUE()))
	    {	
		String sessionFieldValue = buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_VALUE();

		List<BtnCustSessionCO> declaredFieldsList = new ArrayList<BtnCustSessionCO>();
		if(StringUtil.isNotEmpty(buttonCustomizationCO.getGridColumns()))
		{
		    ObjectMapper mapper = new ObjectMapper();
		    declaredFieldsList = mapper.readValue(URLDecoder.decode(buttonCustomizationCO.getGridColumns(),FileUtil.DEFAULT_FILE_ENCODING), new TypeReference<List<BtnCustSessionCO>>(){});
		}
		boolean found = false;
		String fieldDesc = null;
		for(BtnCustSessionCO gridCO : declaredFieldsList)
		{
		    if(gridCO.getPropertyName().equals(sessionFieldValue))
		    {
			found = true;
			fieldDesc = gridCO.getDescription();
			break;
		    }

		}
		if(!found)
		{
		    throw new BOException(MessageCodes.INVALID_VALUE);
		}
		buttonCustomizationCO.setFieldDesc(fieldDesc);
	    }	
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    buttonCustomizationCO.getSysParamActionArgMapVO().setMAP_VALUE(null);
	}
	NumberUtil.resetEmptyValues(buttonCustomizationCO);
	return "jsonSuccess";
    }
    
    public String dependencyForScreenElementsOrSessionLookup()
    {
	try
	{
	    if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_TYPE()))
	    {
		dependencyBySessionElementMap();
		buttonCustomizationCO.getSysParamBtnCustVO().setDESCRIPTION(buttonCustomizationCO.getFieldDesc());
	    }
	    else if(ButtonCustomizationConstants.MAP_TYPE.GRIDCOLUMN.equals(buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_TYPE()))
	    {
		dependencyByGridColumnElementMap();
		buttonCustomizationCO.getSysParamBtnCustVO().setDESCRIPTION(buttonCustomizationCO.getFieldDesc());
	    }
	    else if(ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(buttonCustomizationCO.getSysParamActionArgMapVO().getMAP_TYPE()))
	    {
		dependencyByScreenElementMap();
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    buttonCustomizationCO.getSysParamActionArgMapVO().setMAP_VALUE(null);
	}
	NumberUtil.resetEmptyValues(buttonCustomizationCO);
	return "jsonSuccess";
    }
    
    public String dependencyByAccessProgRef()
    {
	try
	{
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getSysParamBtnCustVO().getACCESS_PROG_REF()))
	    {	
		Pattern p = Pattern.compile("^[a-zA-Z0-9\\-\\_]+$");
		if (!p.matcher(buttonCustomizationCO.getSysParamBtnCustVO().getACCESS_PROG_REF()).matches()) 
		{
		    throw new BOException(MessageCodes.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	    }	
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    buttonCustomizationCO.getSysParamBtnCustVO().setACCESS_PROG_REF(null);;
	}
	NumberUtil.resetEmptyValues(buttonCustomizationCO);
	return "jsonSuccess";
    }
    
    public String dependencyByOperationId()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamActionCondMapVO().getRESULT_OP_ID()))
	    {	
		SessionCO sessionCO = returnSessionObject();
		buttonCustomizationCO.setLanguage(sessionCO.getLanguage());
		buttonCustomizationCO = buttonCustomizationBO.dependencyByOperationId(buttonCustomizationCO);
	    }	
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    buttonCustomizationCO.getSysParamActionCondMapVO().setRESULT_OP_ID(null);
	}
	NumberUtil.resetEmptyValues(buttonCustomizationCO);
	return "jsonSuccess";
    }
    
    public String deleteButtonCondMap() 
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamActionCondMapVO().getBTN_ID())
		    && !NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamActionCondMapVO().getOP_ID())
		    && !NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamActionCondMapVO().getLINE_NO()))
	    {	
		buttonCustomizationCO = buttonCustomizationBO.deleteButtonCondMap(buttonCustomizationCO);
		
		set_warning(getText("Record_was_Deleted_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }	
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "jsonSuccess";
    }
    
    public String saveButtonCondMap()
    {
	try
	{
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getGridUpdate()))
	    {	
		GridUpdates gu = getGridUpdates(buttonCustomizationCO.getGridUpdate(), ButtonCustomizationCO.class, true);
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<ButtonCustomizationCO> buttonCustomizationCOList = gu.getLstAllRec();
		    if(buttonCustomizationCOList != null && !buttonCustomizationCOList.isEmpty())
		    {
			SessionCO sessionCO = returnSessionObject();
			buttonCustomizationCO.setUserName(sessionCO.getUserName());
			buttonCustomizationCO.setRunningDate(sessionCO.getRunningDateRET());
			buttonCustomizationCO.setButtonCustCOList(buttonCustomizationCOList);
			buttonCustomizationCO = buttonCustomizationBO.saveButtonCondMap(buttonCustomizationCO);
			
			set_warning(getText("Record_Saved_Successfully_key"));
			set_msgTitle(getText("info_msg_title_key"));
		    }
		}
		
	    }	
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "jsonSuccess";
    }
    
    public String copyButtonCust()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    buttonCustomizationCO.setUserName(sessionCO.getUserName());
	    buttonCustomizationCO.setRunningDate(sessionCO.getRunningDateRET());
	    buttonCustomizationCO.setProgRef(get_pageRef());
	    buttonCustomizationCO.setAppName(sessionCO.getCurrentAppName());
	    buttonCustomizationCO = buttonCustomizationBO.copyButtonCust(buttonCustomizationCO);

	    set_warning(getText("Record_Saved_Successfully_key"));
	    set_msgTitle(getText("info_msg_title_key"));
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "jsonSuccess";
    }
    
    public String reloadParamMapping()
    {
	try
	{
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getApiCodeValue())
			&& !NumberUtil.isEmptyDecimal(buttonCustomizationCO.getSysParamBtnCustActionsVO().getBTN_ID()))
	    {
		
		if(ButtonCustomizationConstants.API_TYPE.REPORT.equals(buttonCustomizationCO.getImImalApiVO().getSERVICE_TYPE()))
		{
		    buttonCustomizationCO.getSysParamBtnCustActionsVO().setREPORT_PROG_REF(buttonCustomizationCO.getApiCodeValue());
		}
		else if(StringUtil.isNotEmpty(buttonCustomizationCO.getApiCodeValue()) 
			&& StringUtil.isNumeric(buttonCustomizationCO.getApiCodeValue(), false))
		{
		    buttonCustomizationCO.getSysParamBtnCustActionsVO().setAPI_CODE(new BigDecimal(buttonCustomizationCO.getApiCodeValue()));
		}
		
		/////////////////////////////////
		
		SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_MAP_TYPE);
		selSC.setLovCodesExclude("'5','7'");// used to exclude BPM process variable option 
		if(Boolean.valueOf(buttonCustomizationCO.getGlobalOperationMode()))
		{
		    selSC.setLovCodesExclude("'5','1','7'");// used to exclude Screen option in case of global operations 
		}
		mappingSourceList = returnLOV(selSC);
		mappingSourceList.add(new SelectCO("",""));
		
		SelectSC selSC1 = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_MAP_TYPE);
		selSC1.setLovCodesInlude("'4','6','7'");// used to exclude Screen option in case of global operations 
		mappingSourceArrayList = returnLOV(selSC1);
		mappingSourceArrayList.add(new SelectCO("",""));
		    
		////////////////////////////////
		
		SessionCO sessionCO = returnSessionObject();
		buttonCustomizationCO.setLanguage(sessionCO.getLanguage());
		// need to send original prog ref in case of Save AS since the original screen elements are defined in SYS_PARAM_SCREEN_ELEMENTS only
		String theProgRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName() ,get_pageRef());
		buttonCustomizationCO.setProgRef(theProgRef);
		
		argumentsList = buttonCustomizationBO.returnActionArguments(buttonCustomizationCO);

		ArrayList<DynamicParamsVO> dynamicParamVOList = new ArrayList<DynamicParamsVO>();
		if(argumentsList != null && !argumentsList.isEmpty())
		{
		    DynamicParamsVO dynamicParamVO = new DynamicParamsVO();
		    dynamicParamVO.setElement_type(LABEL_ELEMENT);
		    dynamicParamVO.setLabel(getText("Argument_id_key"));
		    dynamicParamVO.setColumn(1);
		    dynamicParamVO.setRow(0);
		    dynamicParamVOList.add(dynamicParamVO);
			
		    DynamicParamsVO dynamicParamVO1 = new DynamicParamsVO();
		    dynamicParamVO1.setElement_type(LABEL_ELEMENT);
		    dynamicParamVO1.setLabel(getText("arg_type_key"));
		    dynamicParamVO1.setColumn(2);
		    dynamicParamVO1.setRow(0);
		    dynamicParamVOList.add(dynamicParamVO1);
		    
		    DynamicParamsVO dynamicParamVO2 = new DynamicParamsVO();
		    dynamicParamVO2.setElement_type(LABEL_ELEMENT);
		    dynamicParamVO2.setLabel(getText("arg_name_key"));
		    dynamicParamVO2.setColumn(3);
		    dynamicParamVO2.setRow(0);
		    dynamicParamVOList.add(dynamicParamVO2);
		    
		    DynamicParamsVO dynamicParamVO3 = new DynamicParamsVO();
		    dynamicParamVO3.setElement_type(LABEL_ELEMENT);
		    dynamicParamVO3.setLabel(getText("Status_key"));
		    dynamicParamVO3.setColumn(4);
		    dynamicParamVO3.setRow(0);
		    dynamicParamVOList.add(dynamicParamVO3);
		    
		    DynamicParamsVO dynamicParamVO4 = new DynamicParamsVO();
		    dynamicParamVO4.setElement_type(LABEL_ELEMENT);
		    dynamicParamVO4.setLabel(getText("def_val_key"));
		    dynamicParamVO4.setColumn(5);
		    dynamicParamVO4.setRow(0);
		    dynamicParamVOList.add(dynamicParamVO4);
		    
		    DynamicParamsVO dynamicParamVO5 = new DynamicParamsVO();
		    dynamicParamVO5.setElement_type(LABEL_ELEMENT);
		    dynamicParamVO5.setLabel(getText("Mapping_source_key"));
		    dynamicParamVO5.setColumn(6);
		    dynamicParamVO5.setRow(0);
		    dynamicParamVOList.add(dynamicParamVO5);
		    
		    for(int i=0; i< argumentsList.size(); i++)
		    {
			ButtonCustomizationCO argument = argumentsList.get(i);
			
			Boolean requiredArg = ConstantsCommon.ONE.equals(argument.getImApiArgumentVO().getREQ_ARG());  
			
			DynamicParamsVO dynamicParamVOId = new DynamicParamsVO();
			dynamicParamVOId.setElement_type(LABEL_ELEMENT);
			dynamicParamVOId.setRequired(requiredArg.toString());
			dynamicParamVOId.setLabel(String.valueOf(argument.getImApiArgumentVO().getARG_ID()));
			dynamicParamVOId.setColumn(1);
			dynamicParamVOId.setRow(i+1);
			dynamicParamVOList.add(dynamicParamVOId);
				
			DynamicParamsVO dynamicParamVOType = new DynamicParamsVO();
			dynamicParamVOType.setElement_type(LABEL_ELEMENT);
			dynamicParamVOType.setRequired(requiredArg.toString());
			dynamicParamVOType.setLabel(StringUtil.nullToEmpty(argument.getTranslatedArgType()));
			dynamicParamVOType.setColumn(2);
			dynamicParamVOType.setRow(i+1);
			dynamicParamVOList.add(dynamicParamVOType);
			    
			DynamicParamsVO dynamicParamVOName = new DynamicParamsVO();
			dynamicParamVOName.setElement_type(LABEL_ELEMENT);
			dynamicParamVOName.setRequired(requiredArg.toString());
			dynamicParamVOName.setLabel(StringUtil.nullToEmpty(argument.getImApiArgumentVO().getDESCRIPTION()));
			dynamicParamVOName.setColumn(3);
			dynamicParamVOName.setRow(i+1);
			dynamicParamVOList.add(dynamicParamVOName);
			
			DynamicParamsVO dynamicParamVOStatus = new DynamicParamsVO();
			dynamicParamVOStatus.setElement_type(LABEL_ELEMENT);
			dynamicParamVOStatus.setRequired(requiredArg.toString());
			dynamicParamVOStatus.setLabel(StringUtil.nullToEmpty(argument.getTranslatedArgStatus()));
			dynamicParamVOStatus.setColumn(4);
			dynamicParamVOStatus.setRow(i+1);
			dynamicParamVOList.add(dynamicParamVOStatus);
			
			if(!ButtonCustomizationConstants.ARG_STATUS.OUT.equals(argument.getImApiArgumentVO().getSTATUS()))
			{
			    	DynamicParamsVO dynamicParamVOHiddenBtnId = new DynamicParamsVO();
        			dynamicParamVOHiddenBtnId.setElement_type(HIDDEN_ELEMENT);
        			dynamicParamVOHiddenBtnId.setName("argumentsList[" + i + "].sysParamActionArgMapVO.BTN_ID");
        			dynamicParamVOHiddenBtnId.setValue(String.valueOf(argument.getSysParamActionArgMapVO().getBTN_ID()));
        			dynamicParamVOHiddenBtnId.setId("ArgumentSourceBtnId_" + i + "_" + get_pageRef());
        			dynamicParamVOHiddenBtnId.setColumn(5);
        			dynamicParamVOHiddenBtnId.setRow(i+1);
        			dynamicParamVOList.add(dynamicParamVOHiddenBtnId);
        			
        			
        			DynamicParamsVO dynamicParamVOHiddenOpId = new DynamicParamsVO();
        			dynamicParamVOHiddenOpId.setElement_type(HIDDEN_ELEMENT);
        			dynamicParamVOHiddenOpId.setName("argumentsList[" + i + "].sysParamActionArgMapVO.OP_ID");
        			dynamicParamVOHiddenOpId.setValue(String.valueOf(argument.getSysParamActionArgMapVO().getOP_ID()));
        			dynamicParamVOHiddenOpId.setId("ArgumentSourceOpId_" + i + "_" + get_pageRef());
        			dynamicParamVOHiddenOpId.setColumn(6);
        			dynamicParamVOHiddenOpId.setRow(i+1);
        			dynamicParamVOList.add(dynamicParamVOHiddenOpId);
        					
        			DynamicParamsVO dynamicParamVOHiddenArgId = new DynamicParamsVO();
        			dynamicParamVOHiddenArgId.setElement_type(HIDDEN_ELEMENT);
        			dynamicParamVOHiddenArgId.setName("argumentsList[" + i + "].sysParamActionArgMapVO.ARG_ID");
        			dynamicParamVOHiddenArgId.setValue(String.valueOf(argument.getSysParamActionArgMapVO().getARG_ID()));
        			dynamicParamVOHiddenArgId.setId("ArgumentSourceArgId_" + i + "_" + get_pageRef());
        			dynamicParamVOHiddenArgId.setColumn(7);
        			dynamicParamVOHiddenArgId.setRow(i+1);
        			dynamicParamVOList.add(dynamicParamVOHiddenArgId);
			    
        			DynamicParamsVO dynamicParamVOHiddenArgType = new DynamicParamsVO();
        			dynamicParamVOHiddenArgType.setElement_type(HIDDEN_ELEMENT);
        			dynamicParamVOHiddenArgType.setName("argumentsList[" + i + "].imApiArgumentVO.ARG_TYPE");
        			dynamicParamVOHiddenArgType.setValue(String.valueOf(argument.getImApiArgumentVO().getARG_TYPE()));
        			dynamicParamVOHiddenArgType.setId("btnCustLinkButtonType" + i + "_" + get_pageRef());
        			dynamicParamVOHiddenArgType.setColumn(8);
        			dynamicParamVOHiddenArgType.setRow(i+1);
        			dynamicParamVOList.add(dynamicParamVOHiddenArgType);
        			
        			DynamicParamsVO dynamicParamVOHiddenReqArg = new DynamicParamsVO();
        			dynamicParamVOHiddenReqArg.setElement_type(HIDDEN_ELEMENT);
        			dynamicParamVOHiddenReqArg.setName("argumentsList[" + i + "].imApiArgumentVO.REQ_ARG");
        			dynamicParamVOHiddenReqArg.setValue(String.valueOf(argument.getImApiArgumentVO().getREQ_ARG()));
        			dynamicParamVOHiddenReqArg.setId("btnCustReqArg" + i + "_" + get_pageRef());
        			dynamicParamVOHiddenReqArg.setColumn(9);
        			dynamicParamVOHiddenReqArg.setRow(i+1);
        			dynamicParamVOList.add(dynamicParamVOHiddenReqArg);
        			
        			DynamicParamsVO dynamicParamVOHiddenDefaultVal = new DynamicParamsVO();
        			dynamicParamVOHiddenDefaultVal.setElement_type(TEXTFIELD_ELEMENT);
        			dynamicParamVOHiddenDefaultVal.setName("argumentsList[" + i + "].imApiArgumentVO.DEFAULT_VALUE");
        			dynamicParamVOHiddenDefaultVal.setValue(StringUtil.nullToEmpty(argument.getImApiArgumentVO().getDEFAULT_VALUE()));
        			dynamicParamVOHiddenDefaultVal.setId("btnCustDefaultValue" + i + "_" + get_pageRef());
        			dynamicParamVOHiddenDefaultVal.setColumn(10);
        			dynamicParamVOHiddenDefaultVal.setRow(i+1);
        			dynamicParamVOHiddenDefaultVal.setReadOnly("true");
        			dynamicParamVOList.add(dynamicParamVOHiddenDefaultVal);
        			
        			
        			DynamicParamsVO dynamicParamVOMapSource = new DynamicParamsVO();
        			dynamicParamVOMapSource.setId("ArgumentSource_" + i + "_" + get_pageRef());
        			dynamicParamVOMapSource.setElement_type(COMBO_ELEMENT);
        			ListParamVO lstParamVO = new ListParamVO();
        			if(ButtonCustomizationConstants.ARG_TYPE.LIST.equals(argument.getImApiArgumentVO().getARG_TYPE()))
        			{
        			    lstParamVO.setValueList("mappingSourceArrayList");
        			}
        			else
        			{
        			    lstParamVO.setValueList("mappingSourceList");
        			}
        			lstParamVO.setKey("code");
        			lstParamVO.setValue("descValue");
        			dynamicParamVOMapSource.setListParamVO(lstParamVO);
        			dynamicParamVOMapSource.setColumn(11);
        			dynamicParamVOMapSource.setRow(i+1);
        			dynamicParamVOMapSource.setOnchange("buttonCustomizationActions_reloadMappingSource(" + i + "," + argument.getImApiArgumentVO().getARG_ID() +  ")");
        			dynamicParamVOMapSource.setName("argumentsList[" + i + "].sysParamActionArgMapVO.MAP_TYPE");
        			if(argumentsList.get(i).getSysParamActionArgMapVO().getMAP_TYPE() != null)
        			{
        			    dynamicParamVOMapSource.setValue(argumentsList.get(i).getSysParamActionArgMapVO().getMAP_TYPE());
        			}
        			dynamicParamVOList.add(dynamicParamVOMapSource);
        			
        			DynamicParamsVO dynamicParamVOHiddenLabel = new DynamicParamsVO();
        			dynamicParamVOHiddenLabel.setId("ArgumentSourceElementDiv_" + i + "_" + get_pageRef());
        			dynamicParamVOHiddenLabel.setElement_type(DIV_ELEMENT);
        			dynamicParamVOHiddenLabel.setColumn(12);
        			dynamicParamVOHiddenLabel.setRow(i+1);
        			dynamicParamVOHiddenLabel.setJspIncludeDiv("/WEB-INF/pages/common/customization/button/ButtonCustomizationReloadMapSource.jsp?rowId="+i);
        			dynamicParamVOList.add(dynamicParamVOHiddenLabel);
        			
        			//set the default selection to empty in case it does not defined in table
        			if(argumentsList.get(i).getSysParamActionArgMapVO().getMAP_TYPE() == null)
        			{
        			    argumentsList.get(i).getSysParamActionArgMapVO().setMAP_TYPE("");
        			}
        			
        			if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(argument.getSysParamActionArgMapVO().getMAP_TYPE()))
        			{
        			    if(ButtonCustomizationConstants.SESSIONCO_PROPERTIES.get(argument
        					.getSysParamActionArgMapVO().getMAP_VALUE()) != null)
        			    {
        				    argument.setFieldDesc(ButtonCustomizationConstants.SESSIONCO_PROPERTIES.get(
        					    argument.getSysParamActionArgMapVO().getMAP_VALUE()).getDescription());
        			    }
        			}
        			if(ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(argument.getSysParamActionArgMapVO().getMAP_TYPE()))
        			{
        			    if(StringUtil.isNotEmpty(argument.getFieldDesc()))
        			    {
        				    argument.setFieldDesc(getText(argument.getFieldDesc()));
        			    }
        			}
			
			}
		    }
		    
		}

		super.fillFormElements(dynamicParamVOList, "", "", "");
		
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "SUCCESS_DYNAMIC_PARAM";
	
    }
    
    public String reloadMappingSource()
    {
	String rowId = ServletActionContext.getRequest().getParameter("rowId");
	if(StringUtil.isNotEmpty(rowId) && StringUtil.isNumeric(rowId, false))
	{
	    int rowIdVal = Integer.valueOf(rowId);
	    ButtonCustomizationCO [] array = new ButtonCustomizationCO [rowIdVal+1];
	    array[rowIdVal] = buttonCustomizationCO;
	    argumentsList = Arrays.asList(array);
	}
	return "reloadMappingSource";
    }
    
    public String loadButtonActionsArgList()
    {
	return "loadButtonActionsArgList";
    }
    
    public String callCustomBtnActions()
    {
	Boolean proceedOnFail = false;
	boolean containFile = false;
	// TP 1084532 - SUPT200364 - CBS -Performance of Upload file from Gateway Module
	Set<String> filesKeySet = new HashSet<>(); 
	try
	{
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getCustomBtnData()))
	    {
		    HashMap<String, Object> customBtnDataMap = (HashMap<String, Object>)JSONUtil.deserialize(buttonCustomizationCO.getCustomBtnData());
		    if(customBtnDataMap != null)
		    {
		    	
	    	// HusseinZaraket : TP 889735/ Replace uploaded files with there contents and file name in case of global activity.
	    	if(null != customBtnDataMap.get("isGlobalActivity") && customBtnDataMap.get("isGlobalActivity").toString().equals("true") && customBtnDataMap.toString().contains("FILE"))
		    {
	    		containFile =true;
		    	SysParamGlobalActArgMapSC criteria = new SysParamGlobalActArgMapSC();
		    	criteria.setLovTypeId(ButtonCustomizationConstants.LOV_TYPE_MAP_TYPE);
		 	    criteria.setLovMapId(ButtonCustomizationConstants.LOV_TYPE_ARG_STATUS);
		 	    criteria.setLovDynParamType(ButtonCustomizationConstants.LOV_TYPE_DYN_PARAM_TYPE);
		 	    criteria.setPreferredLanguage(returnSessionObject().getLanguage());
		 	    criteria.setScreenPageRef(get_pageRef());
		 	    criteria.getSysParamGlobalActArgMapVO().setBTN_ID(BigDecimal.valueOf(Long.parseLong(customBtnDataMap.get("customBtnId").toString())));
		 	    criteria.getSysParamGlobalActArgMapVO().setDYN_SCREEN_ID(buttonCustomizationCO.getFromDynScreenId());
		 	    criteria.getSysParamGlobalActArgMapVO().setDYN_SCREEN_ELEMENT_ID(buttonCustomizationCO.getFromDynElementId());
		    	List<SysParamGlobalActArgMapSC> paramMapList = buttonCustomizationBO.returnButtonCustomizationParamMap(criteria);
		    	
		    	HashMap<String, String> scrnMappingParamMap = (HashMap<String, String>) customBtnDataMap.get("customBtnData");
		    	filesKeySet = scrnMappingParamMap.keySet();
		    	Iterator<String> itr = filesKeySet.iterator();
		    	while(itr.hasNext())
		    	{
		    		  String key = itr.next();
		    		  String val = scrnMappingParamMap.get(key);
		    		  if(val.contains("FILE:"))
		    		  {
		    			  String[] list = key.split("-");
		    			  BigDecimal OP_ID = BigDecimal.valueOf(Long.parseLong(list[0]));
		    			  BigDecimal ARG_ID = BigDecimal.valueOf(Long.parseLong(list[1]));
		    			  SysParamGlobalActArgMapSC sysParamGlobalActArgMapSC = paramMapList.stream().filter(paramMap -> paramMap.getSysParamGlobalActArgMapVO().getOP_ID().equals(OP_ID) && paramMap.getSysParamGlobalActArgMapVO().getARG_ID().equals(ARG_ID)).collect(Collectors.toList()).get(0);
		    			  String eltHtmlName = val.replace("FILE:","");
		    			  
		    			  if(dynFileElemHm.containsKey(eltHtmlName))
		    			  {
		    				  if(BigDecimal.ONE.equals(sysParamGlobalActArgMapSC.getSysParamGlobalActArgMapVO().getARG_ADDITIONAL_ATTR_YN()))
		    				  {
		    					  scrnMappingParamMap.put(key, dynFileElemHm.get(eltHtmlName).getUploadFileFileName());
		    				  }
		    				  else 
		    				  {
		    					  byte[] fileBytes = FileUtils.readFileToByteArray(dynFileElemHm.get(eltHtmlName).getUploadFile());
				    			  String value = Base64.getEncoder().encodeToString(fileBytes);
				    			  scrnMappingParamMap.put(key, value);
		    				  }
			    		  }
		    			  else
			    		  {
		    				  scrnMappingParamMap.put(key, "");
			    		  } 
		    		  }
		    	}
		    }
		    	
			SessionCO sessionCO = returnSessionObject();
			buttonCustomizationCO.setProgRef(get_pageRef());
			buttonCustomizationCO.setAppName(sessionCO.getCurrentAppName());
			buttonCustomizationCO.setLanguage(sessionCO.getLanguage());
			
			Long customBtnId = (Long)customBtnDataMap.get("customBtnId");
			//This map contains the String value of the parameter coming from the screen. The key is actionId-btnId.  
			HashMap<String, String> screenMappingParamList = (HashMap<String, String>) customBtnDataMap.get("customBtnData");
			BigDecimal customBtnIdValue = new BigDecimal(customBtnId);
			buttonCustomizationCO.setButtonId(customBtnIdValue);
			// need to send original prog ref in case of Save AS since the original screen elements are defined in SYS_PARAM_SCREEN_ELEMENTS only
			String theProgRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName() ,get_pageRef());
			ButtonCustomizationSC buttonCustomizationSC = new ButtonCustomizationSC();
			buttonCustomizationSC.setButtonId(customBtnIdValue);
			buttonCustomizationSC.setProgRef(theProgRef);
			buttonCustomizationSC.setOnBtnLoad(null);
			buttonCustomizationSC.setShowArgDetails("1");
			buttonCustomizationSC.setGlobalActivity(customBtnDataMap.get("isGlobalActivity") == null ? false : (Boolean) customBtnDataMap.get("isGlobalActivity"));
			buttonCustomizationSC.setFldIdentifier( customBtnDataMap.get("fldIdentifier") == null ? null : new BigDecimal( customBtnDataMap.get("fldIdentifier").toString()));
			buttonCustomizationSC.setBtnProgRef(buttonCustomizationCO.getDynScreenProgRef());
			buttonCustomizationSC.setCurrAppName(StringUtil.nullToEmpty(customBtnDataMap.get("currentAppName")));
			if(customBtnDataMap.get("isGlobalActivity") != null && customBtnDataMap.get("elemSequenceId") != null)
			{
			    buttonCustomizationSC.setElemSequenceId(new BigDecimal(customBtnDataMap.get("elemSequenceId").toString()));
			}
			
			proceedOnFail = (Boolean)customBtnDataMap.get("proceed") == null ? proceedOnFail:(Boolean)customBtnDataMap.get("proceed");
			
			buttonCustomizationSC.setDynScreenId(buttonCustomizationCO.getFromDynScreenId());
			buttonCustomizationSC.setDynElementId(buttonCustomizationCO.getFromDynElementId());
			
			ButtonCustomizationCO returnedButtonCustomizationCO  = returnCommonLibBO().returnButtonCustActionData(buttonCustomizationSC);
			List<CustomActionParamCO>  mappingParamList = null;
			if(returnedButtonCustomizationCO != null)
			{    
			   mappingParamList = returnedButtonCustomizationCO.getCustomActionParamCOList();
			}
			
			Map<BigDecimal, Map<BigDecimal, CustomActionParamCO>> actionsParamMap = new LinkedHashMap<BigDecimal, Map<BigDecimal,CustomActionParamCO>>(); 
			Map<BigDecimal, BigDecimal> nextActionsMap = new HashMap<BigDecimal, BigDecimal>();
			Map<String, Object> condExprData = null;
			
			condExprData = buildCondExprValues(true);
			buildScreenElementExprValues(condExprData, (Map<String, Object>)customBtnDataMap.get("customBtnElementData"));
			
			if(mappingParamList != null && !mappingParamList.isEmpty())
			{ 
        			for(CustomActionParamCO customActionParamCO : mappingParamList)
        			{
        			    if(ButtonCustomizationConstants.MAP_TYPE.LIST.equals(customActionParamCO.getMapType()))
    				    {
    		        		SysParamActionArgListSC sc = new SysParamActionArgListSC();
    		        		sc.getSysParamActionArgListVO().setARG_ID(customActionParamCO.getArgId());
    		        		sc.getSysParamActionArgListVO().setOP_ID(customActionParamCO.getOperationId());
    		        		sc.getSysParamActionArgListVO().setBTN_ID(customActionParamCO.getBtnId());
    		        		sc.setNbRec(-1);
    		        		ArrayList<SysParamActionArgListSC> array = (ArrayList<SysParamActionArgListSC>) buttonCustomizationBO.returnBtnCustActionArgList(sc);
    		        		ArrayList<String> StringArray  		= new  ArrayList<String>(); ;
    		        		for(SysParamActionArgListSC listSC : array)
    		        		{
    		        		    	StringArray.add(listSC.getSysParamActionArgListVO().getLIST_VALUE());
    		        		}
    		        		if(StringArray.size()>0)
    		        		{
    		        		    customActionParamCO.setArgValue(StringArray);
    		        		}
    		        		else
    		        		{
    		        		    customActionParamCO.setArgValue(null);
    		        		}
    				     }
        			    else
        			    {
        				customActionParamCO = ButtonCustomizationCommonMethods.commonParamConversion(customActionParamCO, screenMappingParamList,sessionCO,null);
        			    }
        			    ButtonCustomizationCommonMethods.buildActionsParamMap(actionsParamMap, customActionParamCO);
        			    ButtonCustomizationCommonMethods.buildNextActionMap(nextActionsMap, customActionParamCO);
        			    
        			    if(customActionParamCO.getParentOpId() == null)
        			    {
        				buttonCustomizationCO.setOperationId(customActionParamCO.getOperationId());
        			    }
        			    
        			    //check if default value exists and the arg value is still empty, then apply the default value
        			    if(customActionParamCO.getArgValue() == null 
        				    && StringUtil.isNotEmpty(customActionParamCO.getArgDefaultVal())
        				    	&& !ButtonCustomizationConstants.MAP_TYPE.LINK.equals(customActionParamCO.getMapType())
        				    	&& !ButtonCustomizationConstants.MAP_TYPE.EXPRESSION.equals(customActionParamCO.getMapType()))
        			    {
        				customActionParamCO.setMapValue(customActionParamCO.getArgDefaultVal()); 
        				customActionParamCO.setMapType(ButtonCustomizationConstants.MAP_TYPE.CONSTANT.getCode());
        				customActionParamCO = ButtonCustomizationCommonMethods.commonParamConversion(customActionParamCO, screenMappingParamList,sessionCO,null);
        			    }
        			}
			}
			if(customBtnDataMap.get("proceedExpression")!=null)
			{
			    buttonCustomizationCO.setProceedOnExpression(customBtnDataMap.get("proceedExpression").toString());
			}
			buttonCustomizationCO.setProceedOnFail(proceedOnFail);
			buttonCustomizationCO = buttonCustomizationBO.callCustomBtnActions(actionsParamMap,nextActionsMap,condExprData,buttonCustomizationCO);
			if(StringUtil.isNotEmpty(buttonCustomizationCO.getCustomActionParamCO().getScreenTitle())) 
			{
			    buttonCustomizationCO.getCustomActionParamCO().setScreenTitle(getText(buttonCustomizationCO.getCustomActionParamCO().getScreenTitle()));
			}
			
			// TP 1084532 - SUPT200364 - CBS -Performance of Upload file from Gateway Module
			if(containFile && filesKeySet.size() > 0) 
			{
			    Iterator<String> it = filesKeySet.iterator();
			    while(it.hasNext())
			    {
				String[] keys = it.next().split("-");
				if(keys.length == 2 && StringUtil.isNumeric(keys[0], false) && StringUtil.isNumeric(keys[1], false)) 
				{
				    BigDecimal opId = BigDecimal.valueOf(Integer.valueOf(keys[0]));
				    BigDecimal argId = BigDecimal.valueOf(Integer.valueOf(keys[1]));
				    if(null != buttonCustomizationCO.getActionsParamMap().get(opId) 
					    && null != buttonCustomizationCO.getActionsParamMap().get(opId).get(argId))
				    {
					buttonCustomizationCO.getActionsParamMap().get(opId).remove(argId);
				    }
				}
			    }
			}
		    }
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	if(containFile) {
		return "jsonFileSuccess";
	}
	return "jsonSuccess";
    }
    
    /*private CustomActionParamCO commonParamConversion(CustomActionParamCO customActionParamCO,
	    HashMap<String, String> screenMappingParamList, Object sessionCOObj) throws BaseException
    {
	String mapType = customActionParamCO.getMapType();

	// Screen map type
	if(ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(mapType))
	{
	    if(screenMappingParamList != null
		    && screenMappingParamList.containsKey(customActionParamCO.getOperationId() + "-"
			    + customActionParamCO.getArgId()))
	    {
		customActionParamCO.setMapValue(screenMappingParamList.get(customActionParamCO.getOperationId() + "-"
			+ customActionParamCO.getArgId()));
		ButtonCustomizationCommonMethods.constantParamMapConversion(customActionParamCO);
	    }
	}
	// Session map type
	else if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(mapType))
	{
	    PathPropertyUtil.copyProperties(sessionCOObj, customActionParamCO, customActionParamCO.getMapValue() + " argValue");
	}
	// Constant map type
	else if(ButtonCustomizationConstants.MAP_TYPE.CONSTANT.equals(mapType))
	{
	    ButtonCustomizationCommonMethods.constantParamMapConversion(customActionParamCO);
	}
	else if(ButtonCustomizationConstants.MAP_TYPE.MAP.equals(mapType))
	{
	    if(screenMappingParamList != null
		    && screenMappingParamList.containsKey(customActionParamCO.getMapValue()))
	    {
		customActionParamCO.setMapValue(screenMappingParamList.get(customActionParamCO.getMapValue()));
		ButtonCustomizationCommonMethods.constantParamMapConversion(customActionParamCO);
	    }
	}
	return customActionParamCO;
    }*/
    
    private void buildScreenElementExprValues(Map<String, Object> condExprData, Map<String, Object> customBtnElementData)
    {
	if(customBtnElementData != null && !customBtnElementData.isEmpty())
	{
	    for(String key : customBtnElementData.keySet())
	    {
		Map<String, String> screenElementMap = (Map<String, String>) customBtnElementData.get(key);
		if(screenElementMap != null && !screenElementMap.isEmpty())
		{
		    CustomActionParamCO customActionParamCO = new CustomActionParamCO();
		    customActionParamCO.setArgType(screenElementMap.get("FIELD_TYPE"));
		    customActionParamCO.setMapValue(screenElementMap.get("FIELD_VALUE"));
		    ButtonCustomizationCommonMethods.constantParamMapConversion(customActionParamCO);
		    if(condExprData != null)
		    {
			condExprData.put(key, customActionParamCO.getArgValue());
		    }
		}
	    }
	}
    }
    
    private Map<String, Object> buildCondExprValues(boolean withValues)
    {
	SessionCO sessionCO = returnSessionObject();
	Map<String, Object> condExprData = new HashMap<String, Object>();
	condExprData.put(ButtonCustomizationConstants.USER_ID_EXP_VAR, withValues ? sessionCO.getUserName():null);
	condExprData.put(ButtonCustomizationConstants.COMP_CODE_EXP_VAR, withValues ? sessionCO.getCompanyCode():null);
	condExprData.put(ButtonCustomizationConstants.COMP_NAME_EXP_VAR, withValues ? sessionCO.getCompanyName():null);
	condExprData.put(ButtonCustomizationConstants.BRANCH_CODE_EXP_VAR, withValues ? sessionCO.getBranchCode():null);
	condExprData.put(ButtonCustomizationConstants.BRANCH_NAME_EXP_VAR, withValues ? sessionCO.getBranchName():null);
	condExprData.put(ButtonCustomizationConstants.USER_FIRST_NAME_EXP_VAR, withValues ? sessionCO.getUserFirstName():null);
	condExprData.put(ButtonCustomizationConstants.USER_LAST_NAME_EXP_VAR, withValues ? sessionCO.getUserLastName():null);
	condExprData.put(ButtonCustomizationConstants.BASE_CURR_NAME_EXP_VAR, withValues ? sessionCO.getBaseCurrencyName():null);
	condExprData.put(ButtonCustomizationConstants.TELLER_CODE_EXP_VAR, (withValues && sessionCO.getCtsTellerVO() != null) ? sessionCO.getCtsTellerVO().getCODE():null);
	condExprData.put(ButtonCustomizationConstants.RUNNING_DATE, (withValues && sessionCO.getRunningDateRET() != null) ? sessionCO.getRunningDateRET():null);
	return condExprData;
    }
    
/*    private void buildNextActionMap(Map<BigDecimal, BigDecimal> nextActionsMap,  CustomActionParamCO customActionParamCO)
    {
	BigDecimal parentOpId = customActionParamCO.getParentOpId();
	//when the parent op id is -1 that means the parent operation is a condition, so no need to add this operation in the next action map
	BigDecimal conditionParentOpId = new BigDecimal(-1);
	
	if(parentOpId != null && !conditionParentOpId.equals(parentOpId))
	{
	    nextActionsMap.put(parentOpId,customActionParamCO.getOperationId());
	}
    }*/
    
/*    private void buildActionsParamMap(Map<BigDecimal, Map<BigDecimal, CustomActionParamCO>> actionsParamMap, CustomActionParamCO customActionParamCO)
    {
	Map<BigDecimal, CustomActionParamCO> btnMap = null;
	if(actionsParamMap.containsKey(customActionParamCO.getOperationId()))
	{
	    btnMap = actionsParamMap.get(customActionParamCO.getOperationId());
	}
	else
	{
	    btnMap = new HashMap<BigDecimal, CustomActionParamCO>();
	    actionsParamMap.put(customActionParamCO.getOperationId(), btnMap);
	}
	if(ButtonCustomizationConstants.OP_TYPE.ACTION.equals(customActionParamCO.getOperationType()))
	{
	    if(customActionParamCO.getArgId() != null)
	    {
		btnMap.put(customActionParamCO.getArgId(), customActionParamCO);
	    }
	    else
	    {
		btnMap.put(ConstantsCommon.EMPTY_BIGDECIMAL_VALUE, customActionParamCO);
	    }
	}
	else if(ButtonCustomizationConstants.OP_TYPE.CONDITION.equals(customActionParamCO.getOperationType()))
	{
	    btnMap.put(customActionParamCO.getCondLineNo(), customActionParamCO);
	}
    }*/
    
    
    public String loadOperationTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_OPERATION_TYPE);
	    operationTypeList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return "jsonSuccess";
    }

    public String loadActionTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_API_TYPE);
	    actionTypeList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return "jsonSuccess";
    }
    
    /**
    * Function used to manage the dependency for the button activity id 	
    */	
    public String dependencyByButtonActivityId()
    {
	try
	{
	    if(StringUtil.isNotEmpty(buttonCustomizationCO.getCustomActionParamCO().getOperationType())
		    && !"0".equals(buttonCustomizationCO.getCustomActionParamCO().getOperationType())
		    && !NumberUtil.isEmptyDecimal(buttonCustomizationCO.getCustomActionParamCO().getOperationId()))
	    {	
		buttonCustomizationCO = buttonCustomizationBO.dependencyByButtonActivityId(buttonCustomizationCO);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    buttonCustomizationCO.getCustomActionParamCO().setOperationId(null);
	}
	NumberUtil.resetEmptyValues(buttonCustomizationCO);
	return "jsonSuccess";
    }
    
    /*TP#983067 Option to load JS Method to be called from js File located on the server*/
    /**
     * loads external javascript file for received operationId and buttonId
     * @return
     */
    public String loadExternalScriptFiles()
    {
	String uri=null;

	BigDecimal operationId = buttonCustomizationCO.getOperationId();
	BigDecimal buttonId = buttonCustomizationCO.getButtonId();
	ButtonCustomizationSC buttonCustomizationSC = new ButtonCustomizationSC();
	buttonCustomizationSC.setButtonId(buttonId);
	buttonCustomizationSC.setOperationId(operationId);
	try 
	{
	    uri = buttonCustomizationBO.returnScriptUri(buttonCustomizationSC);
	    if(StringUtil.isNotEmpty(uri))
	    {
		String repositoryPath, fileName;
		repositoryPath = FileUtil.getFileURLByName("repository") + '/';
		fileName = repositoryPath + uri;
		    Pattern pattern = Pattern.compile("^(?!.*\\.\\.\\/.*)([a-zA-Z0-9\\s_\\/\\\\.\\-\\(\\)]*)([a-zA-Z0-9]\\.js)$");
		    if(!pattern.matcher(uri).find())
		    {
			throw new BOException(getText("invalid_js_file_key")+": "+uri);
		    }
		    PathFileSecure jsFile = new PathFileSecure(fileName);
		    if(!jsFile.exists() || jsFile.isDirectory())
		    {
			throw new BOException(getText("specified_file_not_found_key")+": "+uri);
		    }   
		    byte[] fileBytes = PathFileSecure.readFileToByteArray(jsFile ,200000000);
		    HttpServletResponse response = ServletActionContext.getResponse();
		    setServletResponse(response);
		    response.setContentType("application/javascript");
		    response.getOutputStream().write(fileBytes);
		    response.getOutputStream().flush();
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex,null , null);
	    return "jsonSuccess";
	}
	return null;
    }
    /**
     * [TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
     * @createdBy Sajjad Soomro
     * @description this function is used to return button actions List by given criteria 
     * 
     * @return String
     * @throws BaseException
     */
    public String returnButtonActionsList() throws BaseException
    {
	dependancyCriteria.setNbRec(-1);
	argumentsList = buttonCustomizationBO.returnButtonActionsList(dependancyCriteria);
	return "jsonSuccess";
    }
    
    public void setButtonCustomizationBO(ButtonCustomizationBO buttonCustomizationBO)
    {
        this.buttonCustomizationBO = buttonCustomizationBO;
    }

    public ButtonCustomizationCO getButtonCustomizationCO()
    {
        return buttonCustomizationCO;
    }

    public void setButtonCustomizationCO(ButtonCustomizationCO buttonCustomizationCO)
    {
        this.buttonCustomizationCO = buttonCustomizationCO;
    }

    public List<SelectCO> getMappingSourceList()
    {
        return mappingSourceList;
    }

    public void setMappingSourceList(List<SelectCO> mappingSourceList)
    {
        this.mappingSourceList = mappingSourceList;
    }

    public List<ButtonCustomizationCO> getArgumentsList()
    {
        return argumentsList;
    }

    public void setArgumentsList(List<ButtonCustomizationCO> argumentsList)
    {
        this.argumentsList = argumentsList;
    }

    public List<SelectCO> getOperationTypeList()
    {
        return operationTypeList;
    }

    public void setOperationTypeList(List<SelectCO> operationTypeList)
    {
        this.operationTypeList = operationTypeList;
    }

    public List<SelectCO> getActionTypeList()
    {
        return actionTypeList;
    }

    public void setActionTypeList(List<SelectCO> actionTypeList)
    {
        this.actionTypeList = actionTypeList;
    }
   
    public File getUploadFile()
    {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile)
    {
        this.uploadFile = uploadFile;
    }
    
    public InputStream getImageStream()
    {
        return imageStream;
    }

    public void setImageStream(InputStream imageStream)
    {
        this.imageStream = imageStream;
    }
    public ButtonCustomizationSC getDependancyCriteria()
    {
        return dependancyCriteria;
    }

    public void setDependancyCriteria(ButtonCustomizationSC dependancyCriteria)
    {
        this.dependancyCriteria = dependancyCriteria;
    }

    public List<SelectCO> getMappingSourceArrayList()
    {
        return mappingSourceArrayList;
    }

    public void setMappingSourceArrayList(List<SelectCO> mappingSourceArrayList)
    {
        this.mappingSourceArrayList = mappingSourceArrayList;
    }

	public Map<String, DynamicScreenFileCO> getDynFileElemHm() 
	{
		return dynFileElemHm;
	}

	public void setDynFileElemHm(Map<String, DynamicScreenFileCO> dynFileElemHm) 
	{
		this.dynFileElemHm = dynFileElemHm;
	}
    
}
