/**
 * 
 */
package com.path.actions.common.bpm;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.security.core.context.SecurityContextHolder;

import com.path.actions.admin.dynamicparams.DynamicParamsAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.bpm.BpmBO;
import com.path.bo.common.bpm.BpmEngineConstant;
import com.path.dbmaps.vo.SYS_PARAM_BPM_PROCESS_DEFVO;
import com.path.dbmaps.vo.SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DEFINITIONVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateDeserializer;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.json.PathJSONUtil;
import com.path.vo.admin.dynamicparams.DynamicParamsVO;
import com.path.vo.admin.dynamicparams.ListParamVO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.bpm.BpmCO;
import com.path.vo.common.bpm.BpmExporterCO;
import com.path.vo.common.bpm.BpmSC;
import com.path.vo.common.bpm.BpmTaskMappingCO;
import com.path.vo.common.bpm.jbpm.JbpmProcessVarCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.customization.button.ButtonCustomizationConstants.BtnCustSessionCO;
import com.path.vo.common.customization.button.CustomActionParamCO;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * BpmMaintAction.java used to
 */
public class BpmMaintAction extends DynamicParamsAction
{
    private BpmBO bpmBO;
    private BpmCO bpmCO = new BpmCO();
    private File uploadFile;
    private List<SelectCO> mappingSourceList  = new ArrayList<SelectCO>();
    private List<SelectCO> assignmentTypeList  = new ArrayList<SelectCO>();
    private List<SelectCO> accessRightAssignmentTypeList  = new ArrayList<SelectCO>();
    private List<SelectCO> completionTypeList  = new ArrayList<SelectCO>();
    List<SelectCO> actionTypeList  = new ArrayList<SelectCO>();
    List<SelectCO> procVarDefaultTypeList  = new ArrayList<SelectCO>();
    private List<SelectCO> taskPriorityList  = new ArrayList<SelectCO>();
    private boolean showConfirmation;
    private String confirmationResponse;
    /**
     * Arguments to support exporting excel document
     **/
    private InputStream streamDoc;
    private InputStream imageStream;
    private InputStream streamExcel;
    private String streamFileName;
    public static final String EXPORT_EXCEL_ERR = "excel_error";
    public static final String EXPORT_EXCEL = "excel";
    public static final String EXPORT_DOC_ERR = "doc_error";
    public static final String EXPORT_DOC = "doc";
    public static final String RETURN_IMAGE = "returnImage";
    public static final String RETURN_IMAGE_SVG = "returnImageSvg";
    public static final String RETURN_IMAGE_ERROR = "returnImage_error";
    
    @Override
    @JSON(serialize=false)
    public Object getModel()
    {
	return bpmCO;
    }
    
    
    public String loadProcessInstanceTasksList()
    {
	bpmCO.setType("procInst");
	return BpmEngineConstant.LOAD_BPM_PROCESS_INST_TASKS_LIST;
    }
    
    public String loadBpmUserTasksPage()
    {
	try
	{
	    if(Boolean.valueOf(StringUtil.nullToEmpty(PathPropertyUtil.getPathRemotingProp("PathRemoting", "bpm.enabled")).trim()))
	    {
		bpmCO.setType("user");
		bpmCO.setTaskGridRefreshTime(BpmEngineConstant.BPM_PROPERTIES.TASK_GRID_REFRESH_TIME.getValue());
		return BpmEngineConstant.LOAD_BPM_USER_TASKS_PAGE;
	    }
	    else
	    {
		CommonLibSC sc = new CommonLibSC();
		sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
		sc.setProgRef(ConstantsCommon.PROGREF_ROOT);
		sc.setKeyLabelCode("bpm_disabled_key");
		sc.setLanguage(returnSessionObject().getLanguage());
		String transMessage = returnCommonLibBO().returnKeyLabelTrans(sc);
		addActionError(transMessage);
		return ERROR_ACTION;
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "[loadBpmUserTasksPage] " + e.getMessage());
	    addActionError("[loadBpmUserTasksPage] " + e.getMessage());
	    return ERROR_ACTION;
	}
    }
    
    public String loadBpmProcessInstantiationPage()
    {
	try
	{
	    if(Boolean.valueOf(StringUtil.nullToEmpty(PathPropertyUtil.getPathRemotingProp("PathRemoting", "bpm.enabled")).trim()))
	    {
		return BpmEngineConstant.LOAD_BPM_PROCESS_INSTANTIATION_PAGE;
	    }
	    else
	    {
		CommonLibSC sc = new CommonLibSC();
		sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
		sc.setProgRef(ConstantsCommon.PROGREF_ROOT);
		sc.setKeyLabelCode("bpm_disabled_key");
		sc.setLanguage(returnSessionObject().getLanguage());
		String transMessage = returnCommonLibBO().returnKeyLabelTrans(sc);
		addActionError(transMessage);
		return ERROR_ACTION;
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "[loadBpmProcessInstantiationPage] " + e.getMessage());
	    addActionError("[loadBpmProcessInstantiationPage] " + e.getMessage());
	    return ERROR_ACTION;
	}
    }
    
    public String loadBpmProcessMappingPage()
    {
	try
	{
	    if(Boolean.valueOf(StringUtil.nullToEmpty(PathPropertyUtil.getPathRemotingProp("PathRemoting", "bpm.enabled")).trim()))
	    {
		return BpmEngineConstant.LOAD_BPM_PROCESS_MAPPING_PAGE;
	    }
	    else
	    {
		CommonLibSC sc = new CommonLibSC();
		sc.setAppName(ConstantsCommon.IMAL_APP_NAME);
		sc.setProgRef(ConstantsCommon.PROGREF_ROOT);
		sc.setKeyLabelCode("bpm_disabled_key");
		sc.setLanguage(returnSessionObject().getLanguage());
		String transMessage = returnCommonLibBO().returnKeyLabelTrans(sc);
		addActionError(transMessage);
		return ERROR_ACTION;
	    }
	}
	catch(Exception e)
	{
	    log.error(e, "[loadBpmProcessMappingPage] " + e.getMessage());
	    addActionError("[loadBpmProcessMappingPage] " + e.getMessage());
	    return ERROR_ACTION;
	}
    }
    
    public String loadBpmUserTaskMappingList()
    {
	return BpmEngineConstant.LOAD_BPM_USER_TASK_MAPPING_LIST;
    }
    
    public String loadProcessAccessRightList()
    {
	return BpmEngineConstant.LOAD_BPM_PROCESS_ACCESS_RIGHT_LIST;
    }
    
    public String loadProcessVariablesList()
    {
	return BpmEngineConstant.LOAD_BPM_PROCESS_VARIABLES_LIST;
    }
    
    public String loadBpmTaskForwardPage()
    {
	try
	{
	    bpmCO.setTaskId(bpmCO.getBpmTaskId());
	    SYS_PARAM_SCREEN_DEFINITIONVO screenDefVO = bpmBO.returnBpmScreenProgRef(bpmCO);
	    bpmCO.getBpmTaskMappingCO().setScreenDefVO(screenDefVO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return BpmEngineConstant.LOAD_BPM_TASK_FORWARD_PAGE;
    }
    public String loadBpmProcessImage()
    {
	return BpmEngineConstant.LOAD_BPM_PROCESS_IMAGE;
    }
    public String loadUploadProcMaintPage()
    {
	return BpmEngineConstant.LOAD_UPLOAD_PROC_MAINT_PAGE;
    }
    public String loadBpmCommonCommentPage()
    {
	return BpmEngineConstant.LOAD_BPM_COMMON_COMMENT_PAGE;
    }
    
    public String loadBpmLogsList()
    {
	return BpmEngineConstant.LOAD_BPM_LOGS_LIST;
    }
    
    public String openImportDialog()
    {
	return BpmEngineConstant.OPEN_IMPORT_DIALOG;
    }
    
    public String loadBpmDocumentsList()
    {
	try
	{
	    BpmSC criteria = new BpmSC();
	    criteria.setUserId(bpmCO.getBpmUserName());
	    Map<String, BpmTaskMappingCO> accessRightMap = bpmBO.returnProcesAccessRightByUser(criteria);
	    if(accessRightMap != null && !accessRightMap.isEmpty())
	    {
		bpmCO.getBpmProcessCO().setShowDocDeleteBtn(ConstantsCommon.ONE.equals(accessRightMap.get(
			    bpmCO.getProcessDefId()).getAccessRightVO().getSHOW_DOC_DELETE_YN()));
		bpmCO.getBpmProcessCO().setShowDocUploadBtn(ConstantsCommon.ONE.equals(accessRightMap.get(
			    bpmCO.getProcessDefId()).getAccessRightVO().getSHOW_DOC_UPLOAD_YN()));
		bpmCO.getBpmProcessCO().setShowDocDownloadBtn(ConstantsCommon.ONE.equals(accessRightMap.get(
			    bpmCO.getProcessDefId()).getAccessRightVO().getSHOW_DOC_DOWNLOAD_YN()));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return BpmEngineConstant.LOAD_BPM_DOCS_LIST;
    }
    
    
    public String loadTaskAssignmentPage()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    SelectSC selSC = new SelectSC(BpmEngineConstant.LOV_TYPE_TASK_ASSIGNMENT_DESC,sessionCO.getLanguage());
	    selSC.setLovCodesInlude("'3'");
	    bpmCO.getBpmTaskMappingCO().setFieldDesc(returnCommonLibBO().returnSingleLOV(selSC));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return BpmEngineConstant.LOAD_TASK_ASSIGNMENT_PAGE;
    }

    public String loadUserTaskOutputMapping()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getTaskMapId()))
	    {
		SelectSC selSC = new SelectSC(BpmEngineConstant.LOV_TYPE_MAP_TYPE);
		selSC.setLovCodesInlude("'1','2','3'");// used to exclude BPM process variable option and link to other argument and session options
		mappingSourceList = returnLOV(selSC);
		mappingSourceList.add(new SelectCO("",""));
		
		BpmSC criteria = new BpmSC();
		criteria.setTaskMapId(bpmCO.getTaskMapId());
		criteria.setProcessId(bpmCO.getProcessId());
		criteria.setTaskName(bpmCO.getTaskName());
		
		List<BpmTaskMappingCO> bpmTaskMappingCOList = bpmBO.returnTaskOutputArg(criteria);
		bpmCO.setBpmTaskMappingCOList(bpmTaskMappingCOList);
		
		if(bpmTaskMappingCOList != null && !bpmTaskMappingCOList.isEmpty())
		{
		    ArrayList<DynamicParamsVO> dynamicParamVOList = new ArrayList<DynamicParamsVO>();
		    DynamicParamsVO dynamicParamVO1 = new DynamicParamsVO();
		    dynamicParamVO1.setElement_type(LABEL_ELEMENT);
		    dynamicParamVO1.setLabel(getText("arg_name_key"));
		    dynamicParamVO1.setColumn(1);
		    dynamicParamVO1.setRow(0);
		    dynamicParamVOList.add(dynamicParamVO1);
		    
		    DynamicParamsVO dynamicParamVO3 = new DynamicParamsVO();
		    dynamicParamVO3.setElement_type(LABEL_ELEMENT);
		    dynamicParamVO3.setLabel(getText("Mapping_source_key"));
		    dynamicParamVO3.setColumn(2);
		    dynamicParamVO3.setRow(0);
		    dynamicParamVOList.add(dynamicParamVO3);
		    
		    DynamicParamsVO dynamicParamVOHiddenProgRef = new DynamicParamsVO();
		    dynamicParamVOHiddenProgRef.setElement_type(HIDDEN_ELEMENT);
		    dynamicParamVOHiddenProgRef.setValue(StringUtil.nullToEmpty(bpmCO.getProgRef()));
		    dynamicParamVOHiddenProgRef.setId("bpmTaskOutput_ProgRef");
		    dynamicParamVOHiddenProgRef.setName("bpmCO.progRef");
		    dynamicParamVOHiddenProgRef.setColumn(3);
		    dynamicParamVOHiddenProgRef.setRow(0);
		    dynamicParamVOList.add(dynamicParamVOHiddenProgRef);
		    
		    DynamicParamsVO dynamicParamVOHiddenAppName = new DynamicParamsVO();
		    dynamicParamVOHiddenAppName.setElement_type(HIDDEN_ELEMENT);
		    dynamicParamVOHiddenAppName.setValue(StringUtil.nullToEmpty(bpmCO.getAppName()));
		    dynamicParamVOHiddenAppName.setId("bpmTaskOutput_AppName");
		    dynamicParamVOHiddenAppName.setName("bpmCO.appName");
		    dynamicParamVOHiddenAppName.setColumn(4);
		    dynamicParamVOHiddenAppName.setRow(0);
		    dynamicParamVOList.add(dynamicParamVOHiddenAppName);
		    
		    for(int i=0; i< bpmTaskMappingCOList.size(); i++)
		    {
			  
			BpmTaskMappingCO argument = bpmTaskMappingCOList.get(i);
			
			DynamicParamsVO dynamicParamVOArgDesc = new DynamicParamsVO();
			dynamicParamVOArgDesc.setElement_type(LABEL_ELEMENT);
			dynamicParamVOArgDesc.setLabel(StringUtil.nullToEmpty(argument.getTaskMapArgOutVO().getARG_NAME()));
			dynamicParamVOArgDesc.setColumn(1);
			dynamicParamVOArgDesc.setRow(i+1);
			dynamicParamVOList.add(dynamicParamVOArgDesc);
			
			DynamicParamsVO dynamicParamVOMapSource = new DynamicParamsVO();
			dynamicParamVOMapSource.setId("bpmTaskOutput_ArgumentSource_" + i );
			dynamicParamVOMapSource.setElement_type(COMBO_ELEMENT);
			ListParamVO lstParamVO = new ListParamVO();
			lstParamVO.setValueList("mappingSourceList");
			lstParamVO.setKey("code");
			lstParamVO.setValue("descValue");
			dynamicParamVOMapSource.setListParamVO(lstParamVO);
			dynamicParamVOMapSource.setColumn(2);
			dynamicParamVOMapSource.setRow(i+1);
			dynamicParamVOMapSource.setOnchange("bpmUsrTaskMapping_reloadOutArgMappingSource(" + i + ")");
			dynamicParamVOMapSource.setName("bpmTaskMappingCOList[" + i + "].taskMapArgOutVO.MAP_TYPE");
			
			String mapTypeValue = StringUtil.nullEmptyToValue(bpmTaskMappingCOList.get(i).getTaskMapArgOutVO().getMAP_TYPE(),BpmEngineConstant.MAP_TYPE.CONSTANT.getCode());
			dynamicParamVOMapSource.setValue(mapTypeValue);
			dynamicParamVOList.add(dynamicParamVOMapSource);
		        argument.getTaskMapArgOutVO().setMAP_TYPE(mapTypeValue);
		        
			DynamicParamsVO dynamicParamVOHiddenLabel = new DynamicParamsVO();
			dynamicParamVOHiddenLabel.setId("bpmTaskOutput_ArgumentSourceElementDiv_" + i );
			dynamicParamVOHiddenLabel.setElement_type(DIV_ELEMENT);
			dynamicParamVOHiddenLabel.setColumn(3);
			dynamicParamVOHiddenLabel.setRow(i+1);
			dynamicParamVOHiddenLabel.setJspIncludeDiv("/WEB-INF/pages/common/bpm/BpmOutArgReloadMapSource.jsp?rowId="+i);
			dynamicParamVOList.add(dynamicParamVOHiddenLabel);
			
			
			DynamicParamsVO dynamicParamVOHiddenArgName = new DynamicParamsVO();
			dynamicParamVOHiddenArgName.setElement_type(HIDDEN_ELEMENT);
			dynamicParamVOHiddenArgName.setName("bpmTaskMappingCOList[" + i + "].taskMapArgOutVO.ARG_NAME");
			dynamicParamVOHiddenArgName.setValue(String.valueOf(argument.getTaskMapArgOutVO().getARG_NAME()));
			dynamicParamVOHiddenArgName.setId("bpmTaskOutput_ArgumentName_" + i );
			dynamicParamVOHiddenArgName.setColumn(4);
			dynamicParamVOHiddenArgName.setRow(i+1);
			dynamicParamVOList.add(dynamicParamVOHiddenArgName);
					
			DynamicParamsVO dynamicParamVOHiddenTaskMapId = new DynamicParamsVO();
			dynamicParamVOHiddenTaskMapId.setElement_type(HIDDEN_ELEMENT);
			dynamicParamVOHiddenTaskMapId.setName("bpmTaskMappingCOList[" + i + "].taskMapArgOutVO.TASK_MAP_ID");
			dynamicParamVOHiddenTaskMapId.setValue(String.valueOf(argument.getTaskMapArgOutVO().getTASK_MAP_ID()));
			dynamicParamVOHiddenTaskMapId.setId("bpmTaskOutput_TaskMapId_" + i );
			dynamicParamVOHiddenTaskMapId.setColumn(5);
			dynamicParamVOHiddenTaskMapId.setRow(i+1);
			dynamicParamVOList.add(dynamicParamVOHiddenTaskMapId);
			
			if(BpmEngineConstant.MAP_TYPE.SESSION.equals(argument.getTaskMapArgOutVO().getMAP_TYPE()))
			{
			    if(ButtonCustomizationConstants.SESSIONCO_PROPERTIES.get(argument
					.getTaskMapArgOutVO().getMAP_VALUE()) != null)
			    {
				    argument.setFieldDesc(ButtonCustomizationConstants.SESSIONCO_PROPERTIES.get(
					    argument.getTaskMapArgOutVO().getMAP_VALUE()).getDescription());
			    }
			}
			
			if(BpmEngineConstant.MAP_TYPE.SCREEN.equals(argument.getTaskMapArgOutVO().getMAP_TYPE()))
			{
			    if(StringUtil.isNotEmpty(argument.getFieldDesc()))
			    {
				    argument.setFieldDesc(getText(argument.getFieldDesc()));
			    }
			}
			
		    }
		    
		    super.fillFormElements(dynamicParamVOList, "", "bpmTaskArgMapForm", "", ConstantsCommon.TRUE);
		}
		else
		{
		    super.fillFormElements(new ArrayList<DynamicParamsVO>(), "", "", "", ConstantsCommon.TRUE);
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return BpmEngineConstant.LOAD_DYNAMIC_PARAMS;
    }
    
    public String loadUserTaskInputMapping() throws BaseException
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getTaskMapId()))
	    {
		SelectSC selSC = new SelectSC(BpmEngineConstant.LOV_TYPE_MAP_TYPE);
		selSC.setLovCodesInlude("'2','3','5'");// used to exclude BPM process variable option
		mappingSourceList = returnLOV(selSC);
		mappingSourceList.add(new SelectCO("",""));
		
		SessionCO sessionCO = returnSessionObject();
		BpmSC criteria = new BpmSC();
		criteria.setTaskMapId(bpmCO.getTaskMapId());
		criteria.setLovTypeId(BpmEngineConstant.LOV_TYPE_ID_ARG_DESC);
		criteria.setPreferredLanguage(sessionCO.getLanguage());
		criteria.setActionType(bpmCO.getActionTypes());
		criteria.setScreenCode(bpmCO.getBpmTaskMappingCO().getTaskMapVO().getSCREEN_CODE());
		
		List<BpmTaskMappingCO>  inputTaskMappingList = bpmBO.returnTaskInputArg(criteria);
		bpmCO.setBpmTaskMappingCOList(inputTaskMappingList);
		
		if(inputTaskMappingList != null && !inputTaskMappingList.isEmpty())
		{
		    //identifier of number of column to skip
		    int skip = 0;
		    ArrayList<DynamicParamsVO> dynamicParamVOList = new ArrayList<DynamicParamsVO>();
		    DynamicParamsVO dynamicParamVO1 = new DynamicParamsVO();
		    dynamicParamVO1.setElement_type(LABEL_ELEMENT);
		    dynamicParamVO1.setLabel(getText("arg_name_key"));
		    dynamicParamVO1.setColumn(1);
		    dynamicParamVO1.setRow(0);
		    dynamicParamVOList.add(dynamicParamVO1);
		    
		    if(BpmEngineConstant.TASK_ACTION_TYPE.DYNAMIC.equals(criteria.getActionType()))
		    {
			 // we need to skip 2 columns
			 skip = 2;
			 DynamicParamsVO dynamicParamVO4 = new DynamicParamsVO();
			 dynamicParamVO4.setElement_type(LABEL_ELEMENT);
			 dynamicParamVO4.setLabel(getText("Field_Type_key"));
			 dynamicParamVO4.setColumn(2);
			 dynamicParamVO4.setRow(0);
			 dynamicParamVOList.add(dynamicParamVO4);
			 
			 DynamicParamsVO dynamicParamVO5 = new DynamicParamsVO();
			 dynamicParamVO5.setElement_type(LABEL_ELEMENT);
			 dynamicParamVO5.setLabel(getText("valueType"));
			 dynamicParamVO5.setColumn(3);
			 dynamicParamVO5.setRow(0);
			 dynamicParamVOList.add(dynamicParamVO5);
		    }
		    DynamicParamsVO dynamicParamVO2 = new DynamicParamsVO();
		    dynamicParamVO2.setElement_type(LABEL_ELEMENT);
		    dynamicParamVO2.setLabel(getText("def_val_key"));
		    dynamicParamVO2.setColumn(2+skip);
		    dynamicParamVO2.setRow(0);
		    dynamicParamVOList.add(dynamicParamVO2);
		    
		    DynamicParamsVO dynamicParamVO3 = new DynamicParamsVO();
		    dynamicParamVO3.setElement_type(LABEL_ELEMENT);
		    dynamicParamVO3.setLabel(getText("Mapping_source_key"));
		    dynamicParamVO3.setColumn(3+skip);
		    dynamicParamVO3.setRow(0);
		    dynamicParamVOList.add(dynamicParamVO3);
		    
		    for(int i=0; i< inputTaskMappingList.size(); i++)
		    {
			  
			BpmTaskMappingCO argument = inputTaskMappingList.get(i);
			argument.getTaskMapArgInVO().setMAP_TYPE(StringUtil.nullToEmpty(argument.getTaskMapArgInVO().getMAP_TYPE()));
			
			DynamicParamsVO dynamicParamVOArgDesc = new DynamicParamsVO();
			dynamicParamVOArgDesc.setElement_type(LABEL_ELEMENT);
			dynamicParamVOArgDesc.setLabel(StringUtil.nullToEmpty(argument.getScreenArgVO().getARG_DESC()));
			dynamicParamVOArgDesc.setColumn(1);
			dynamicParamVOArgDesc.setRow(i+1);
			dynamicParamVOList.add(dynamicParamVOArgDesc);
			
			if(BpmEngineConstant.TASK_ACTION_TYPE.DYNAMIC.equals(criteria.getActionType()))
			{
			    DynamicParamsVO dynamicParamVOFieldType = new DynamicParamsVO();
			    dynamicParamVOFieldType.setElement_type(LABEL_ELEMENT);
			    dynamicParamVOFieldType.setLabel(StringUtil.nullToEmpty(argument.getFieldType()));
			    dynamicParamVOFieldType.setColumn(2);
			    dynamicParamVOFieldType.setRow(i + 1);
			    dynamicParamVOList.add(dynamicParamVOFieldType);
			    
			    DynamicParamsVO dynamicParamVOValueType = new DynamicParamsVO();
			    dynamicParamVOValueType.setElement_type(LABEL_ELEMENT);
			    dynamicParamVOValueType.setLabel("Varchar");
			    if("1".equals(argument.getTypeCode()) && "2".equals(argument.getValueType()))
			    {
				dynamicParamVOValueType.setLabel("Number");
			    }
			    else if("4".equals(argument.getTypeCode()))
			    {
				dynamicParamVOValueType.setLabel("Date");
			    }
			    dynamicParamVOValueType.setColumn(3);
			    dynamicParamVOValueType.setRow(i + 1);
			    dynamicParamVOList.add(dynamicParamVOValueType);
			}
			
			DynamicParamsVO dynamicParamVODefaultVal = new DynamicParamsVO();
			dynamicParamVODefaultVal.setElement_type(LABEL_ELEMENT);
			dynamicParamVODefaultVal.setLabel(StringUtil.nullToEmpty(argument.getScreenArgVO().getDEFAULT_VALUE()));
			dynamicParamVODefaultVal.setColumn(2+skip);
			dynamicParamVODefaultVal.setRow(i+1);
			dynamicParamVOList.add(dynamicParamVODefaultVal);
			
			DynamicParamsVO dynamicParamVOMapSource = new DynamicParamsVO();
			dynamicParamVOMapSource.setId("bpmTaskInput_ArgumentSource_" + i );
			dynamicParamVOMapSource.setElement_type(COMBO_ELEMENT);
			ListParamVO lstParamVO = new ListParamVO();
			lstParamVO.setValueList("mappingSourceList");
			lstParamVO.setKey("code");
			lstParamVO.setValue("descValue");
			dynamicParamVOMapSource.setListParamVO(lstParamVO);
			dynamicParamVOMapSource.setColumn(3+skip);
			dynamicParamVOMapSource.setRow(i+1);
			dynamicParamVOMapSource.setOnchange("bpmUsrTaskMapping_reloadInArgMappingSource(" + i + ")");
			dynamicParamVOMapSource.setName("bpmTaskMappingCOList[" + i + "].taskMapArgInVO.MAP_TYPE");
			
			String mapTypeValue = StringUtil.nullEmptyToValue(argument.getTaskMapArgInVO().getMAP_TYPE(),BpmEngineConstant.MAP_TYPE.CONSTANT.getCode());
			dynamicParamVOMapSource.setValue(mapTypeValue);
			dynamicParamVOList.add(dynamicParamVOMapSource);
			argument.getTaskMapArgInVO().setMAP_TYPE(mapTypeValue);
			
			DynamicParamsVO dynamicParamVOHiddenLabel = new DynamicParamsVO();
			dynamicParamVOHiddenLabel.setId("bpmTaskInput_ArgumentSourceElementDiv_" + i );
			dynamicParamVOHiddenLabel.setElement_type(DIV_ELEMENT);
			dynamicParamVOHiddenLabel.setColumn(4+skip);
			dynamicParamVOHiddenLabel.setRow(i+1);
			dynamicParamVOHiddenLabel.setJspIncludeDiv("/WEB-INF/pages/common/bpm/BpmInArgReloadMapSource.jsp?rowId="+i);
			dynamicParamVOList.add(dynamicParamVOHiddenLabel);
			
			
			DynamicParamsVO dynamicParamVOHiddenArgName = new DynamicParamsVO();
			dynamicParamVOHiddenArgName.setElement_type(HIDDEN_ELEMENT);
			dynamicParamVOHiddenArgName.setName("bpmTaskMappingCOList[" + i + "].screenArgVO.ARG_NAME");
			dynamicParamVOHiddenArgName.setValue(String.valueOf(argument.getScreenArgVO().getARG_NAME()));
			dynamicParamVOHiddenArgName.setId("bpmTaskInput_ArgumentName_" + i );
			dynamicParamVOHiddenArgName.setColumn(5+skip);
			dynamicParamVOHiddenArgName.setRow(i+1);
			dynamicParamVOList.add(dynamicParamVOHiddenArgName);
			
			DynamicParamsVO dynamicParamVOHiddenScreenCode = new DynamicParamsVO();
			dynamicParamVOHiddenScreenCode.setElement_type(HIDDEN_ELEMENT);
			dynamicParamVOHiddenScreenCode.setName("bpmTaskMappingCOList[" + i + "].screenArgVO.SCREEN_CODE");
			dynamicParamVOHiddenScreenCode.setValue(String.valueOf(argument.getScreenArgVO().getSCREEN_CODE()));
			dynamicParamVOHiddenScreenCode.setId("bpmTaskInput_ScreenCode_" + i );
			dynamicParamVOHiddenScreenCode.setColumn(6+skip);
			dynamicParamVOHiddenScreenCode.setRow(i+1);
			dynamicParamVOList.add(dynamicParamVOHiddenScreenCode);
			
			DynamicParamsVO dynamicParamVOHiddenTaskMapId = new DynamicParamsVO();
			dynamicParamVOHiddenTaskMapId.setElement_type(HIDDEN_ELEMENT);
			dynamicParamVOHiddenTaskMapId.setName("bpmTaskMappingCOList[" + i + "].taskMapArgInVO.TASK_MAP_ID");
			dynamicParamVOHiddenTaskMapId.setValue(String.valueOf(argument.getTaskMapArgInVO().getTASK_MAP_ID()));
			dynamicParamVOHiddenTaskMapId.setId("bpmTaskInput_TaskMapId_" + i );
			dynamicParamVOHiddenTaskMapId.setColumn(7+skip);
			dynamicParamVOHiddenTaskMapId.setRow(i+1);
			dynamicParamVOList.add(dynamicParamVOHiddenTaskMapId);
			
			if(BpmEngineConstant.MAP_TYPE.SESSION.equals(argument.getTaskMapArgInVO().getMAP_TYPE()))
			{
			    if(ButtonCustomizationConstants.SESSIONCO_PROPERTIES.get(argument
					.getTaskMapArgInVO().getMAP_VALUE()) != null)
			    {
				    argument.setFieldDesc(ButtonCustomizationConstants.SESSIONCO_PROPERTIES.get(
					    argument.getTaskMapArgInVO().getMAP_VALUE()).getDescription());
			    }
			}
			
		    }
		    
		    super.fillFormElements(dynamicParamVOList, "", "bpmTaskArgMapForm", "", ConstantsCommon.TRUE);
		}
		else
		{
		    super.fillFormElements(new ArrayList<DynamicParamsVO>(), "", "", "", ConstantsCommon.TRUE);
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return BpmEngineConstant.LOAD_DYNAMIC_PARAMS;
    }
    
    public String reloadInMappingSource()
    {
	String rowId = ServletActionContext.getRequest().getParameter("rowId");
	if(StringUtil.isNotEmpty(rowId) && StringUtil.isNumeric(rowId, false))
	{
	    int rowIdVal = Integer.valueOf(rowId);
	    BpmTaskMappingCO [] array = new BpmTaskMappingCO [rowIdVal+1];
	    array[rowIdVal] = bpmCO.getBpmTaskMappingCO();
	    bpmCO.setBpmTaskMappingCOList(Arrays.asList(array));
	}
	return BpmEngineConstant.RELOAD_IN_MAPPING_SOURCE;
    }
    
    public String reloadOutMappingSource()
    {
	reloadInMappingSource();
	return BpmEngineConstant.RELOAD_OUT_MAPPING_SOURCE;
    }
    
    public String saveArgMapping() throws BaseException
    {
	try
	{
	    if(bpmCO.getBpmTaskMappingCOList() != null 
		    && !bpmCO.getBpmTaskMappingCOList().isEmpty())
	    {
		prepareCommonParams();
		bpmCO = bpmBO.saveArgMapping(bpmCO);
		
		set_warning(getText("Record_Saved_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    private void prepareCommonParams()
    {
	SessionCO sessionCO = returnSessionObject();
	bpmCO.setLanguage(sessionCO.getLanguage());
	bpmCO.setRunningDate(sessionCO.getRunningDateRET());
	bpmCO.setBpmUserName(sessionCO.getUserName());
	bpmCO.setBpmUserPass((String)SecurityContextHolder.getContext().getAuthentication().getCredentials());
    }
    
    public String completeTask()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getBpmTaskId()))
	    {	
		prepareCommonParams();
		bpmBO.completeTask(bpmCO);
	    }
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String releaseTask()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getBpmTaskId()))
	    {
		prepareCommonParams();
		bpmBO.releaseTask(bpmCO);
	    }
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String forwardTask()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getBpmTaskId())
		    && StringUtil.isNotEmpty(bpmCO.getBpmTaskMappingCO().getTaskAssignVO().getENTITY_NAME()))
	    {
		prepareCommonParams();
		bpmBO.forwardTask(bpmCO);
	    }
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String claimTask()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getBpmTaskId()))
	    {
		prepareCommonParams();
		bpmBO.claimTask(bpmCO);
	    }	
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    private void prepareSessionDefaultParams(BpmCO bpmCO) throws BaseException
    {
	List<BpmTaskMappingCO> bpmTaskMappingCOList = bpmCO.getBpmTaskMappingCOList();
	if(bpmTaskMappingCOList == null)
	{
	    bpmTaskMappingCOList = new ArrayList<BpmTaskMappingCO>(); 
	}
	SessionCO sessionCO = returnSessionObject();
	for(BtnCustSessionCO custSessionCO : ButtonCustomizationConstants.SESSIONCO_PROPERTIES.values())
	{
	    Object sessionAttrObj = PathPropertyUtil.returnProperty(sessionCO, custSessionCO.getPropertyName());
	    BpmTaskMappingCO bpmTaskMappingCO = new BpmTaskMappingCO();
	    bpmTaskMappingCO.getProcessVariablesVO().setVARIABLE_NAME(BpmEngineConstant.SESSION_VAR_PREFIX.concat(custSessionCO.getPropertyName()));
	    if(sessionAttrObj instanceof String)
	    {
		bpmTaskMappingCO.getProcessVariablesVO().setDEFAULT_VALUE((String)sessionAttrObj);
	    }
	    else if(sessionAttrObj instanceof Date)
	    {
		bpmTaskMappingCO.getProcessVariablesVO().setDEFAULT_VALUE(DateUtil.format((Date)sessionAttrObj));
	    }
	    else if(sessionAttrObj instanceof BigDecimal)
	    {
		bpmTaskMappingCO.getProcessVariablesVO().setDEFAULT_VALUE(((BigDecimal)sessionAttrObj).toString());
	    }
	    bpmTaskMappingCOList.add(bpmTaskMappingCO);
	}
    }
        
    public String startProcessInstance()
    {
	try
	{
	    if(StringUtil.isNotEmpty(bpmCO.getProcessDefId())
		    && StringUtil.isNotEmpty(bpmCO.getDeploymentId()))
	    {
		prepareCommonParams();
		prepareSessionDefaultParams(bpmCO);
		bpmCO = bpmBO.startProcessInstance(bpmCO);
		if(bpmCO != null && StringUtil.isNotEmpty(bpmCO.getWarningMsg()))
		{
		    set_warning(bpmCO.getWarningMsg());
		    set_msgTitle(getText("info_title_key"));
		}
	    }	
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String startProcessInstanceWithVariables()
    {
	try
	{
	    if(StringUtil.isNotEmpty(bpmCO.getProcessDefId())
		    && StringUtil.isNotEmpty(bpmCO.getDeploymentId())
		    	&& StringUtil.isNotEmpty(bpmCO.getProcessName()))
	    {
		prepareCommonParams();
		bpmCO = bpmBO.startProcessInstanceWithVariables(bpmCO);
		
		loadStartProcessInstanceWithVar();
		
		if(bpmCO != null && StringUtil.isNotEmpty(bpmCO.getWarningMsg()))
		{
		    set_warning(bpmCO.getWarningMsg());
		}
	    }	
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return BpmEngineConstant.LOAD_DYNAMIC_PARAMS;
    }
    
    public void loadStartProcessInstanceWithVar()
    {
	try
	{
	    if(StringUtil.isNotEmpty(bpmCO.getProcessDefId()) && StringUtil.isNotEmpty(bpmCO.getProcessName()))
	    {
		ArrayList<DynamicParamsVO> dynamicParamVOList = new ArrayList<DynamicParamsVO>();
		DynamicParamsVO dynamicParamVOCommentLbl = new DynamicParamsVO();
		dynamicParamVOCommentLbl.setElement_type(LABEL_ELEMENT);
		dynamicParamVOCommentLbl.setLabel(getText("Comments_key"));
		dynamicParamVOCommentLbl.setColumn(1);
		dynamicParamVOCommentLbl.setRow(0);
		dynamicParamVOList.add(dynamicParamVOCommentLbl);
		dynamicParamVOCommentLbl.setMaxLength(255);
		
		DynamicParamsVO dynamicParamVOComment = new DynamicParamsVO();
		dynamicParamVOComment.setElement_type("textArea");
		dynamicParamVOComment.setColumn(2);
		dynamicParamVOComment.setRow(0);
		dynamicParamVOComment.setMaxLength(255);
		dynamicParamVOComment.setColspan("9");
		dynamicParamVOComment.setCssStyle("height:100px");
		dynamicParamVOComment.setName("bpmCO.comment");
		dynamicParamVOComment.setId("bpmProcessVar_Comment");
		dynamicParamVOList.add(dynamicParamVOComment);
		
		
		if(Boolean.valueOf(bpmCO.getStartWithProcessVariables()))
		{
		    List<BpmTaskMappingCO> bpmTaskMappingCOList = bpmBO.returnProcessVariablesListOnStartUp(bpmCO);
		    bpmCO.setBpmTaskMappingCOList(bpmTaskMappingCOList);
		
		    if(bpmTaskMappingCOList != null && !bpmTaskMappingCOList.isEmpty())
		    {
		    
			DynamicParamsVO dynamicParamVO1 = new DynamicParamsVO();
			dynamicParamVO1.setElement_type(LABEL_ELEMENT);
			dynamicParamVO1.setLabel(getText("var_key"));
			dynamicParamVO1.setColumn(1);
			dynamicParamVO1.setRow(1);
			dynamicParamVOList.add(dynamicParamVO1);
		    
			DynamicParamsVO dynamicParamVO2 = new DynamicParamsVO();
			dynamicParamVO2.setElement_type(LABEL_ELEMENT);
			dynamicParamVO2.setLabel(getText("type_key"));
			dynamicParamVO2.setColumn(2);
			dynamicParamVO2.setRow(1);
			dynamicParamVOList.add(dynamicParamVO2);
		    
			DynamicParamsVO dynamicParamVO3 = new DynamicParamsVO();
			dynamicParamVO3.setElement_type(LABEL_ELEMENT);
			dynamicParamVO3.setLabel(getText("Desc_key"));
			dynamicParamVO3.setColumn(3);
			dynamicParamVO3.setRow(1);
			dynamicParamVOList.add(dynamicParamVO3);
		    
			DynamicParamsVO dynamicParamVO4 = new DynamicParamsVO();
			dynamicParamVO4.setElement_type(LABEL_ELEMENT);
			dynamicParamVO4.setLabel(getText("defaulted_key"));
			dynamicParamVO4.setColumn(4);
			dynamicParamVO4.setRow(1);
			dynamicParamVOList.add(dynamicParamVO4);
			
			DynamicParamsVO dynamicParamVO5 = new DynamicParamsVO();
			dynamicParamVO5.setElement_type(LABEL_ELEMENT);
			dynamicParamVO5.setLabel(getText("def_val_key"));
			dynamicParamVO5.setColumn(5);
			dynamicParamVO5.setRow(1);
			dynamicParamVOList.add(dynamicParamVO5);
		    
		    	DynamicParamsVO dynamicParamVO6 = new DynamicParamsVO();
		    	dynamicParamVO6.setElement_type(LABEL_ELEMENT);
		    	dynamicParamVO6.setLabel(getText("Value_key"));
		    	dynamicParamVO6.setColumn(6);
		    	dynamicParamVO6.setRow(1);
		    	dynamicParamVOList.add(dynamicParamVO6);
			
		    	loadProcVarDefaultTypeSelect();
		    	Map<String, String> defaultTypeDescMap = new HashMap<String, String>();
		    	for(SelectCO selectCO : procVarDefaultTypeList)
		    	{
		    	    defaultTypeDescMap.put(selectCO.getCode(), selectCO.getDescValue());
		    	}
		    	
		    	for(int i=0; i< bpmTaskMappingCOList.size(); i++)
		    	{
			  
		    	    BpmTaskMappingCO argument = bpmTaskMappingCOList.get(i);
		    	    String requiredValue = Boolean.valueOf(ConstantsCommon.ONE.equals(argument.getProcessVariablesVO().getIS_MANDATORY_YN())).toString();
		    	    String textFieldValueId = "bpmProcessVar_VariableValue_" + i;
			
		    	    DynamicParamsVO dynamicParamVOBusinessName = new DynamicParamsVO();
		    	    dynamicParamVOBusinessName.setElement_type(LABEL_ELEMENT);
		    	    dynamicParamVOBusinessName.setLabel(StringUtil.nullEmptyToValue(argument.getProcessVariablesVO().getBUSINESS_NAME(),argument.getProcessVariablesVO().getVARIABLE_NAME()));
		    	    dynamicParamVOBusinessName.setColumn(1);
		    	    dynamicParamVOBusinessName.setRow(i+2);
		    	    dynamicParamVOBusinessName.setRequired(requiredValue);
		    	    dynamicParamVOBusinessName.setLabelForElemId(textFieldValueId);
		    	    dynamicParamVOBusinessName.setId(textFieldValueId.concat("_lbl"));
		    	    dynamicParamVOList.add(dynamicParamVOBusinessName);
			
		    	    DynamicParamsVO dynamicParamVOType = new DynamicParamsVO();
		    	    dynamicParamVOType.setElement_type(LABEL_ELEMENT);
		    	    dynamicParamVOType.setLabel(StringUtil.nullToEmpty(argument.getProcessVariablesVO().getVARIABLE_TYPE()));
		    	    dynamicParamVOType.setColumn(2);
		    	    dynamicParamVOType.setRow(i+2);
		    	    dynamicParamVOType.setRequired(requiredValue);
		    	    dynamicParamVOList.add(dynamicParamVOType);
			
		    	    DynamicParamsVO dynamicParamVODesc = new DynamicParamsVO();
		    	    dynamicParamVODesc.setElement_type(LABEL_ELEMENT);
		    	    dynamicParamVODesc.setLabel(StringUtil.nullToEmpty(argument.getProcessVariablesVO().getDESCRIPTION()));
		    	    dynamicParamVODesc.setColumn(3);
		    	    dynamicParamVODesc.setRow(i+2);
		    	    dynamicParamVODesc.setRequired(requiredValue);
		    	    dynamicParamVOList.add(dynamicParamVODesc);
		    	    
		    	    DynamicParamsVO dynamicParamVODefaulted = new DynamicParamsVO();
		    	    dynamicParamVODefaulted.setElement_type(LABEL_ELEMENT);
		    	    dynamicParamVODefaulted.setLabel(StringUtil.nullToEmpty(defaultTypeDescMap.get(argument.getProcessVariablesVO().getDEFAULT_TYPE())));
		    	    dynamicParamVODefaulted.setColumn(4);
		    	    dynamicParamVODefaulted.setRow(i+2);
		    	    dynamicParamVODefaulted.setRequired(requiredValue);
		    	    dynamicParamVOList.add(dynamicParamVODefaulted);
		    	
		    	    DynamicParamsVO dynamicParamVODefaultValue = new DynamicParamsVO();
		    	    dynamicParamVODefaultValue.setElement_type(TEXTFIELD_ELEMENT);
		    	    dynamicParamVODefaultValue.setId("bpmProcessVar_DefaultValue_" + i);
		    	    if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(argument.getProcessVariablesVO().getDEFAULT_TYPE()))
		    	    {
		    		dynamicParamVODefaultValue.setValue(StringUtil.nullToEmpty(ButtonCustomizationConstants.SESSIONCO_PROPERTIES.get(argument.getProcessVariablesVO().getDEFAULT_VALUE()).getDescription()));
		    	    }
		    	    else
		    	    {
		    		dynamicParamVODefaultValue.setValue(StringUtil.nullToEmpty(argument.getProcessVariablesVO().getDEFAULT_VALUE()));
		    	    }
		    	    dynamicParamVODefaultValue.setColumn(5);
		    	    dynamicParamVODefaultValue.setRow(i+2);
		    	    dynamicParamVODefaultValue.setReadOnly(Boolean.TRUE.toString());
		    	    dynamicParamVODefaultValue.setName("bpmTaskMappingCOList[" + i + "].processVariablesVO.DEFAULT_VALUE");
		    	    dynamicParamVOList.add(dynamicParamVODefaultValue);
			
		    	    DynamicParamsVO dynamicParamVOValue = new DynamicParamsVO();
		    	    dynamicParamVOValue.setElement_type(TEXTFIELD_ELEMENT);
		    	    dynamicParamVOValue.setId(textFieldValueId);
		    	    dynamicParamVOValue.setName("bpmTaskMappingCOList[" + i + "].variableValue");
		    	    dynamicParamVOValue.setColumn(6);
		    	    dynamicParamVOValue.setRow(i+2);
		    	    dynamicParamVOValue.setRequired(requiredValue);
		    	    if(BpmEngineConstant.PROCESS_VARAIBLES_TYPES.INTEGER.equals(argument.getProcessVariablesVO().getVARIABLE_TYPE()))
		    	    {
		    		dynamicParamVOValue.setMode("number");
		    	    }
		    	    if(BpmEngineConstant.PROCESS_VARAIBLES_TYPES.FLOAT.equals(argument.getProcessVariablesVO().getVARIABLE_TYPE()) )
		    	    {
		    		dynamicParamVOValue.setMode("number");
		    		dynamicParamVOValue.setNbFormat("#,###.00");
		    	    }
		    	    dynamicParamVOList.add(dynamicParamVOValue);
			
		    	    DynamicParamsVO dynamicParamVOHiddenVariableName = new DynamicParamsVO();
		    	    dynamicParamVOHiddenVariableName.setElement_type(HIDDEN_ELEMENT);
		    	    dynamicParamVOHiddenVariableName.setName("bpmTaskMappingCOList[" + i + "].processVariablesVO.VARIABLE_NAME");
		    	    dynamicParamVOHiddenVariableName.setValue(String.valueOf(argument.getProcessVariablesVO().getVARIABLE_NAME()));
		    	    dynamicParamVOHiddenVariableName.setId("bpmProcessVar_VariableName_" + i );
		    	    dynamicParamVOHiddenVariableName.setColumn(7);
		    	    dynamicParamVOHiddenVariableName.setRow(i+2);
		    	    dynamicParamVOList.add(dynamicParamVOHiddenVariableName);
		    
		    	}
		    }
		}
		
		super.fillFormElements(dynamicParamVOList, "", "bpmProcessVarStartUpForm", "", ConstantsCommon.TRUE);
	    	getFormVO().setTableCssStyle("width:100%;");
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
    }
    
    public String abortProcessInstance()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getProcessInstanceId())
		    && StringUtil.isNotEmpty(bpmCO.getDeploymentId()))
	    {
		prepareCommonParams();
		bpmCO = bpmBO.abortProcessInstance(bpmCO);
		if(bpmCO != null && StringUtil.isNotEmpty(bpmCO.getWarningMsg()))
		{
		    set_warning(bpmCO.getWarningMsg());
		}
	    }	
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String returnProcessDefinitionImage()
    {
	try
	{
	    if(StringUtil.isNotEmpty(bpmCO.getProcessDefId())
		    && StringUtil.isNotEmpty(bpmCO.getDeploymentId()))
	    {
		prepareCommonParams();
		
		// Added and used with jbpm v7, to return svg image
		bpmCO.setTypeSVG(true);
		
		bpmCO = bpmBO.returnProcessDefinitionImage(bpmCO);
		if(bpmCO != null && bpmCO.getBpmFileContent() != null && bpmCO.getBpmFileContent().length > 0)
		{
		    imageStream = new ByteArrayInputStream(bpmCO.getBpmFileContent()); 
		}
		ServletActionContext.getResponse().setContentType(BpmEngineConstant.IS_BPMV7 ? BpmEngineConstant.ACCEPT_APP_SVG_XML : BpmEngineConstant.ACCEPT_PNG);
	    }	
	}
	catch (Exception e) 
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
	    
	    return RETURN_IMAGE_ERROR;
	}
	return BpmEngineConstant.IS_BPMV7 ? RETURN_IMAGE_SVG : RETURN_IMAGE;
    }
    
    public String returnHumanTaskMapping()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getBpmTaskId()))
	    {
		prepareCommonParams();
		bpmCO = bpmBO.returnHumanTaskMapping(bpmCO);
		if(bpmCO.getBpmTaskMappingCOList() != null 
			&& !bpmCO.getBpmTaskMappingCOList().isEmpty())
		{
		    Map<String, Object> bpmTaskArgMap = new HashMap<String, Object>();
		    Map<String, Object> processVarMap = bpmCO.getBpmTaskArgMap();
		    List<DynamicScreenParamsMapCO> list = new ArrayList<DynamicScreenParamsMapCO>();
		    for(BpmTaskMappingCO mappingCO : bpmCO.getBpmTaskMappingCOList())
		    {
			bpmCO.getBpmTaskMappingCO().getScreenDefVO().setAPP_NAME(mappingCO.getScreenDefVO().getAPP_NAME());
			bpmCO.getBpmTaskMappingCO().getScreenDefVO().setPROG_REF(mappingCO.getTaskMapVO().getPROG_REF());
			bpmCO.getBpmTaskMappingCO().getScreenDefVO().setURL(mappingCO.getScreenDefVO().getURL());
			if(StringUtil.isNotEmpty(mappingCO.getTaskMapArgInVO().getARG_NAME())
				&& StringUtil.isNotEmpty(mappingCO.getTaskMapArgInVO().getMAP_VALUE()))
			{
			    commonParamConversion(mappingCO, processVarMap);
			    bpmTaskArgMap.put(mappingCO.getTaskMapArgInVO().getARG_NAME(), mappingCO.getTaskMapArgInVO().getMAP_VALUE());
			    //adjust the input parameters of the dynamic screen
			    if(BpmEngineConstant.TASK_ACTION_TYPE.DYNAMIC.equals(mappingCO.getTaskMapVO().getACTION_TYPE()))
			    {
				SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO spedsmd = new SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO();
				DynamicScreenParamsMapCO dspmc = new DynamicScreenParamsMapCO();
				spedsmd.setMAP_TYPE(mappingCO.getTaskMapArgInVO().getMAP_TYPE());
				spedsmd.setMAP_VALUE(mappingCO.getTaskMapArgInVO().getMAP_VALUE());
				spedsmd.setTO_ELEMENT_ID(new BigDecimal(mappingCO.getTaskMapArgInVO().getARG_NAME()));
				dspmc.setSysParamElmDynScrnMapDet(spedsmd);
				list.add(dspmc);
			    }
			}
		    }
		    bpmCO.setBpmTaskArgMap(bpmTaskArgMap);
		    bpmCO.setDynamicScreenParamsMapCOList(list);
		    
		    if((bpmCO.getBpmTaskMappingCO().getScreenDefVO().getURL() == null 
			    || bpmCO.getBpmTaskMappingCO().getScreenDefVO().getURL().isEmpty()) 
			    && BpmEngineConstant.TASK_ACTION_TYPE.NORMAL.equals(bpmCO.getBpmTaskMappingCO().getTaskMapVO().getACTION_TYPE()))
		    {
			throw new BOException(MessageCodes.BPM_TASK_NOT_LINKED_TO_IMAL);
			//load bpm task form developed in designer
			//return BpmEngineConstant.LOAD_BPM_EXTERNAL_TASK_FORM;
		    }
		}
	    }	
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    private BpmTaskMappingCO commonParamConversion(BpmTaskMappingCO mappingCO , Map<String, Object> processVarMap) throws BaseException
    {
	if(StringUtil.isNotEmpty(mappingCO.getTaskMapArgInVO().getARG_NAME()))
	{
	    String mapType = mappingCO.getTaskMapArgInVO().getMAP_TYPE();

	    // BPM process variable map type
	    if(BpmEngineConstant.MAP_TYPE.BPM_PROCESS_VARIABLE.equals(mapType))
	    {
		if(processVarMap != null && !processVarMap.isEmpty()
			&& processVarMap.containsKey(mappingCO.getTaskMapArgInVO().getMAP_VALUE()))
		{
		    String processVarName = mappingCO.getTaskMapArgInVO().getMAP_VALUE();
		    Object argValue = processVarMap.get(processVarName);
		    if(argValue != null)
		    {
			mappingCO.getTaskMapArgInVO().setMAP_VALUE(String.valueOf(argValue));
		    }
		    mappingCO.getTaskMapArgInVO().setMAP_TYPE(BpmEngineConstant.MAP_TYPE.CONSTANT.getCode());
		}
	    }
	    // Session map type
	    else if(BpmEngineConstant.MAP_TYPE.SESSION.equals(mapType))
	    {
		SessionCO sessionCO = returnSessionObject();
		Object propertyObject = PathPropertyUtil.returnProperty(sessionCO, mappingCO.getTaskMapArgInVO().getMAP_VALUE());
		if(propertyObject != null)
		{
		    mappingCO.getTaskMapArgInVO().setMAP_VALUE(propertyObject.toString());
		}
	    }

	    // Check for default value
	    if((mappingCO.getTaskMapArgInVO().getMAP_VALUE() == null || mappingCO.getTaskMapArgInVO().getMAP_VALUE().isEmpty())
		    && StringUtil.isNotEmpty(mappingCO.getScreenArgVO().getDEFAULT_VALUE()))
	    {
		mappingCO.getTaskMapArgInVO().setMAP_VALUE(mappingCO.getScreenArgVO().getDEFAULT_VALUE());
	    }
	}
	return mappingCO;
    }
    /**
     * Function used for session mapping conversion to the related action parameter type
     * @param customActionParamCO
     */
    private void sessionParamMapConversion(CustomActionParamCO customActionParamCO) throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	PathPropertyUtil.copyProperties(sessionCO, customActionParamCO, customActionParamCO.getMapValue() + " argValue");
    }
    
    
    public String uploadBpmnFile()
    {
	try
	{
	    if(uploadFile != null && uploadFile.isFile() && uploadFile.length() > 0)
	    {
		prepareCommonParams();
		//limit the size of the bpmn2 file to be below of 200 MB = 200000000 bytes 
		bpmCO.setBpmFileContent(PathFileSecure.readFileToByteArray(uploadFile,200000000));
		bpmCO = bpmBO.uploadBpmnFile(bpmCO);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return  BpmEngineConstant.FILE_SUCCESS;
    }
    
    public String uploadDocument()
    {
	try
	{
	    if(uploadFile != null && uploadFile.isFile() && uploadFile.length() > 0)
	    {
		prepareCommonParams();
		//limit the size of the file to be below of 200 MB = 200000000 bytes 
		bpmCO.setBpmFileContent(PathFileSecure.readFileToByteArray(uploadFile,200000000));
		bpmCO = bpmBO.uploadDocument(bpmCO);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return  BpmEngineConstant.FILE_SUCCESS;
    }
    
    
    public String deleteDocument()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getProcessInstanceId())
		    && !NumberUtil.isEmptyDecimal(bpmCO.getDocumentId()))
	    {
		prepareCommonParams();
		bpmCO = bpmBO.deleteDocument(bpmCO);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return  BpmEngineConstant.FILE_SUCCESS;
    }
    
    
    public String dependencyByScreenCode()
    {
	try
	{
	    if(StringUtil.isNotEmpty(bpmCO.getBpmTaskMappingCO().getTaskMapVO().getSCREEN_CODE()))
	    {	
		SessionCO sessionCO = returnSessionObject();
		bpmCO.setLanguage(sessionCO.getLanguage());
		bpmCO = bpmBO.dependencyByScreenCode(bpmCO);
	    }
	    else
	    {
		bpmCO.getBpmTaskMappingCO().getTaskMapVO().setPROG_REF(null);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    bpmCO.getBpmTaskMappingCO().getTaskMapVO().setSCREEN_CODE(null);
	}
	NumberUtil.resetEmptyValues(bpmCO);
	return SUCCESS;
    }
    
    public String dependencyByTaskAssignment()
    {
	try
	{
	    if(StringUtil.isNotEmpty(bpmCO.getBpmTaskMappingCO().getTaskAssignVO().getENTITY_NAME()))
	    {
	    	// TP #957629 - System is not displaying any User ID in the forward option for the Request
	    	SessionCO sessionCO = returnSessionObject();
	    	if(!NumberUtil.isEmptyDecimal(sessionCO.getCompanyCode()))
	    	{
	    		bpmCO.setCompCode(sessionCO.getCompanyCode());
	    	}
	    	if(!NumberUtil.isEmptyDecimal(sessionCO.getBranchCode()))
	    	{
	    		bpmCO.setBranchCode(sessionCO.getBranchCode());
	    	}
	    	// END TP #957629 ----------------------------------------------
	    	
	    	bpmCO = bpmBO.dependencyByTaskAssignment(bpmCO);
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    bpmCO.getBpmTaskMappingCO().getTaskAssignVO().setENTITY_NAME(null);
	}
	NumberUtil.resetEmptyValues(bpmCO);
	return SUCCESS;
    }
    
    public String dependencyByProcessVar()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getProcessId())
		    && StringUtil.isNotEmpty(bpmCO.getBpmTaskMappingCO().getTaskMapArgInVO().getMAP_VALUE()))
	    {	
		List<JbpmProcessVarCO> processVarList = bpmBO.returnProcessVarList(bpmCO);
		if(processVarList != null && !processVarList.isEmpty())
		{
		    boolean validProcVar = false;
		    for(JbpmProcessVarCO varCO : processVarList)
		    {
			if(varCO.getId().equals(bpmCO.getBpmTaskMappingCO().getTaskMapArgInVO().getMAP_VALUE()))
			{
			    validProcVar = true;
			    break;
			}
		    }
		    if(!validProcVar)
		    {
			throw new BOException(MessageCodes.INVALID_VALUE);
		    }
		}
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    bpmCO.getBpmTaskMappingCO().getTaskMapArgInVO().setMAP_VALUE(null);
	}
	NumberUtil.resetEmptyValues(bpmCO);
	return SUCCESS;
    }
    
    public String saveScreenMapping()
    {
	try
	{
	    
	    if(StringUtil.isNotEmpty(bpmCO.getGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(bpmCO.getGridUpdate(), BpmTaskMappingCO.class, true);
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<BpmTaskMappingCO> bpmTaskMappingCOList = gu.getLstAllRec();
		    if(bpmTaskMappingCOList != null && !bpmTaskMappingCOList.isEmpty())
		    {
			prepareCommonParams();
			bpmCO.setBpmTaskMappingCOList(bpmTaskMappingCOList);
			bpmCO = bpmBO.saveScreenMapping(bpmCO);
			
			set_warning(getText("Record_Saved_Successfully_key"));
			set_msgTitle(getText("info_msg_title_key"));
		    }
		}
	    }
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String saveProcessDef()
    {
	try
	{
	    if(StringUtil.isNotEmpty(bpmCO.getGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(bpmCO.getGridUpdate(), SYS_PARAM_BPM_PROCESS_DEFVO.class, true);
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<SYS_PARAM_BPM_PROCESS_DEFVO> bpmProcessDefList = gu.getLstAllRec();
		    if(bpmProcessDefList != null && !bpmProcessDefList.isEmpty())
		    {
			prepareCommonParams();
			bpmBO.saveProcessDef(bpmProcessDefList);
			
			set_warning(getText("Record_Saved_Successfully_key"));
			set_msgTitle(getText("info_msg_title_key"));
		    }
		}
	    }
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String deleteUploadedProcessDef()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getProcessId()))
	    {
		bpmCO = bpmBO.deleteUploadedProcessDef(bpmCO);
		
		set_warning(getText("Record_was_Deleted_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * this function is used to load process var defaulting type list
     * @return
     */
    public String loadProcVarDefaultTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_MAP_TYPE);
	    selSC.setLovCodesInlude("'2','3'");
	    procVarDefaultTypeList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public String loadAssignmentTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(BpmEngineConstant.LOV_TYPE_TASK_ASSIGNMENT_DESC);
	    assignmentTypeList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public String loadAccessRightAssignmentTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(BpmEngineConstant.LOV_TYPE_TASK_ASSIGNMENT_DESC);
	    selSC.setLovCodesInlude("'1','2'");
	    accessRightAssignmentTypeList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public String loadCompletionTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(BpmEngineConstant.LOV_TYPE_TASK_COMPLETION_DESC);
	    completionTypeList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public String deleteTaskAssignment()
    {
	try
	{   
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getBpmTaskMappingCO().getTaskAssignVO().getTASK_MAP_ID())
		    && StringUtil.isNotEmpty(bpmCO.getBpmTaskMappingCO().getTaskAssignVO().getENTITY_TYPE()))
	    {
		if(BpmEngineConstant.TASK_ASSIGN_TYPE.INITIATOR.equals(bpmCO.getBpmTaskMappingCO().getTaskAssignVO().getENTITY_TYPE()))
		{
		    bpmCO.getBpmTaskMappingCO().getTaskAssignVO().setENTITY_NAME(BpmEngineConstant.DEFAULT_INITIATOR_NAME);
		}
		
		bpmCO = bpmBO.deleteTaskAssignment(bpmCO);
		
		set_warning(getText("Record_was_Deleted_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String saveTaskAssignement()
    {
	try
	{   
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getTaskMapId()) && StringUtil.isNotEmpty(bpmCO.getGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(bpmCO.getGridUpdate(), BpmTaskMappingCO.class, true);
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<BpmTaskMappingCO> bpmTaskAssignCOList = gu.getLstAllRec();
		    if(bpmTaskAssignCOList != null && !bpmTaskAssignCOList.isEmpty())
		    {
			prepareCommonParams();
			bpmCO.setBpmTaskMappingCOList(bpmTaskAssignCOList);
			bpmCO = bpmBO.saveTaskAssignement(bpmCO);
			
			set_warning(getText("Record_Saved_Successfully_key"));
			set_msgTitle(getText("info_msg_title_key"));
		    }
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String deleteProcessAccessRight()
    {
	try
	{   
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getBpmTaskMappingCO().getAccessRightVO().getPROCESS_ID())
		    && StringUtil.isNotEmpty(bpmCO.getBpmTaskMappingCO().getAccessRightVO().getENTITY_TYPE())
		    && StringUtil.isNotEmpty(bpmCO.getBpmTaskMappingCO().getAccessRightVO().getENTITY_TYPE()))
	    {
		
		bpmCO = bpmBO.deleteProcessAccessRight(bpmCO);
		
		set_warning(getText("Record_was_Deleted_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String saveProcessAccessRight()
    {
	try
	{   
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getProcessId()) && StringUtil.isNotEmpty(bpmCO.getGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(bpmCO.getGridUpdate(), BpmTaskMappingCO.class, true);
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<BpmTaskMappingCO> bpmAccessRightCOList = gu.getLstAllRec();
		    if(bpmAccessRightCOList != null && !bpmAccessRightCOList.isEmpty())
		    {
			prepareCommonParams();
			bpmCO.setBpmTaskMappingCOList(bpmAccessRightCOList);
			bpmCO = bpmBO.saveProcessAccessRight(bpmCO);
			
			set_warning(getText("Record_Saved_Successfully_key"));
			set_msgTitle(getText("info_msg_title_key"));
		    }
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String saveProcessVariables()
    {
	try
	{   
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getProcessId()) && StringUtil.isNotEmpty(bpmCO.getGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(bpmCO.getGridUpdate(), BpmTaskMappingCO.class, true);
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<BpmTaskMappingCO> bpmProcessVarList = gu.getLstAllRec();
		    if(bpmProcessVarList != null && !bpmProcessVarList.isEmpty())
		    {
			prepareCommonParams();
			bpmCO.setBpmTaskMappingCOList(bpmProcessVarList);
			bpmCO = bpmBO.saveProcessVariables(bpmCO);
			
			set_warning(getText("Record_Saved_Successfully_key"));
			set_msgTitle(getText("info_msg_title_key"));
		    }
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String downloadProcessDoc()
    {
	boolean exportToDoc = BpmEngineConstant.EXPORT_DOC.equals(StringUtil.nullToEmpty(bpmCO.getExportType()));
	
	try
	{   
	    if(StringUtil.isNotEmpty(bpmCO.getProcessDefId()) && StringUtil.isNotEmpty(bpmCO.getDeploymentId()))
	    {
		//prepare translation map
		Map<String, String> transMap = new HashMap<String, String>();
		transMap.put("Type_key", getText("Type_key"));
		transMap.put("Name_key", getText("Name_key"));
		transMap.put("Documentation_key", getText("Documentation_key"));
		transMap.put("Process_key", getText("Process_key"));
		transMap.put("User_Task_key", getText("User_Task_key"));
		transMap.put("Custom_Task_key", getText("Custom_Task_key"));
		transMap.put("Preview_image_key", getText("Preview_image_key"));
		
		if(exportToDoc)
		{
		    bpmCO = bpmBO.downloadDocProcessDoc(bpmCO,transMap); 
		    if(bpmCO.getBpmFileContent() != null)
		    {
			streamFileName = bpmCO.getProcessDefId().concat(".docx");
			streamDoc = new ByteArrayInputStream(bpmCO.getBpmFileContent());
		    }
		}
		else
		{
		    bpmCO = bpmBO.downloadXlsProcessDoc(bpmCO,transMap); 
		    if(bpmCO.getBpmFileContent() != null)
		    {
			streamFileName = bpmCO.getProcessDefId().concat(".xlsx");
			streamExcel = new ByteArrayInputStream(bpmCO.getBpmFileContent());
		    }
		}
		
		// IMP: this will call the success callback function
		ServletActionContext.getResponse().setHeader("Set-Cookie", "fileDownload=true; path=/");
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		if(exportToDoc)
		{
		    streamDoc = new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
		}
		else
		{
		    streamExcel = new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
		}
	    }
	    catch(UnsupportedEncodingException e1)
	    {
		log.error(e1, "Error in reading the error message");
	    }
	    if(exportToDoc)
	    {
		return EXPORT_DOC_ERR;
	    }
	    else
	    {
		return EXPORT_EXCEL_ERR;
	    }
	}
	if(exportToDoc)
	{
	    return EXPORT_DOC;
	}
	else
	{
	    return EXPORT_EXCEL;
	}
    }
    
    
    public String downloadDocument()
    {
	try
	{   
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getProcessInstanceId()) && !NumberUtil.isEmptyDecimal(bpmCO.getDocumentId()))
	    {
		bpmCO = bpmBO.returnDownloadedDocument(bpmCO); 
		if(bpmCO != null && bpmCO.getBpmTaskMappingCO() != null && bpmCO.getBpmTaskMappingCO().getDocVO() != null
			&& bpmCO.getBpmTaskMappingCO().getDocVO().getDOC_BYTES() != null 
			&& bpmCO.getBpmTaskMappingCO().getDocVO().getDOC_BYTES().length > 0)
		{
			streamFileName = bpmCO.getBpmTaskMappingCO().getDocVO().getDOC_NAME().concat(".").concat(bpmCO.getBpmTaskMappingCO().getDocVO().getDOC_TYPE());
			streamDoc = new ByteArrayInputStream(bpmCO.getBpmTaskMappingCO().getDocVO().getDOC_BYTES());
		}
		// IMP: this will call the success callback function
		ServletActionContext.getResponse().setHeader("Set-Cookie", "fileDownload=true; path=/");
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		streamDoc = new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    }
	    catch(UnsupportedEncodingException e1)
	    {
		log.error(e1, "Error in reading the error message");
	    }
	    return EXPORT_DOC_ERR;
	}
	return EXPORT_DOC;
   }
    
    public String suspendTask()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getBpmTaskId()))
	    {
		prepareCommonParams();
		bpmBO.suspendTask(bpmCO);
	    }	
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String resumeTask()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getBpmTaskId()))
	    {
		prepareCommonParams();
		bpmBO.resumeTask(bpmCO);
	    }	
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String deleteBpmLog()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getBpmTaskMappingCO().getLogsVO().getLOG_ID()))
	    {
		bpmBO.deleteBpmLog(bpmCO.getBpmTaskMappingCO().getLogsVO());
		set_warning(getText("record_was_Deleted_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String saveLogs()
    {
	try
	{
	    
	    if(StringUtil.isNotEmpty(bpmCO.getGridUpdate()))
	    {
		GridUpdates gu = getGridUpdates(bpmCO.getGridUpdate(), BpmTaskMappingCO.class, true);
		if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
		{
		    List<BpmTaskMappingCO> bpmTaskMappingCOList = gu.getLstAllRec();
		    if(bpmTaskMappingCOList != null && !bpmTaskMappingCOList.isEmpty())
		    {
			prepareCommonParams();
			bpmCO.setBpmTaskMappingCOList(bpmTaskMappingCOList);
			bpmCO = bpmBO.saveNewLogs(bpmCO);
			set_warning(getText("Record_Saved_Successfully_key"));
			set_msgTitle(getText("info_msg_title_key"));
		    }
		}
	    }
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    public String exportProcDef()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(bpmCO.getProcessId()))
	    {
		BpmExporterCO bpmExporterCO = bpmBO.returnBpmExporter(bpmCO);
		String bpmExporterCOValue = PathJSONUtil.strutsJsonSerialize(bpmExporterCO, null, null, false, true);
		streamFileName = bpmExporterCO.getProcessDefVO().getPROCESS_DEF_ID() + ".txt";
		streamDoc = new ByteArrayInputStream(bpmExporterCOValue.getBytes());
		
		// IMP: this will call the success callback function
		ServletActionContext.getResponse().setHeader("Set-Cookie", "fileDownload=true; path=/");
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		streamDoc = new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING));

	    }
	    catch(UnsupportedEncodingException e1)
	    {
		log.error(e1, "Error in reading the error message");
	    }
	    return EXPORT_DOC_ERR;

	}
	return EXPORT_DOC;

    }
    
    public String importJsonFile()
    {
	try
	{
	    if(uploadFile != null && uploadFile.isFile() && uploadFile.length() > 0)
	    {
		prepareCommonParams();
		//limit the size of the file to be below of 200 MB = 200000000 bytes 
		byte[] content = PathFileSecure.readFileToByteArray(uploadFile,200000000);
		String result = new String(content);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(JsonMethod.ALL, Visibility.NONE);
		mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        // TP 1085170 - BAJI200108 - JBPM - Mapping file import is failed
        Version vers = new Version(0, 0, 0, null);
        SimpleModule module = new SimpleModule("dateModule", vers);
        module.addDeserializer(Date.class, new DateDeserializer());
        mapper.registerModule(module);
        mapper.getSerializationConfig().withDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SZ"));
        
        BpmExporterCO bpmImporterCO = new BpmExporterCO();
        bpmImporterCO =	mapper.readValue(result, BpmExporterCO.class);
	         
	        
		if(bpmImporterCO != null)  
		{
		    showConfirmation = bpmBO.insertBpmExporter(bpmImporterCO,confirmationResponse);
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return  BpmEngineConstant.FILE_SUCCESS;
    }
    
    public String loadActionTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(BpmEngineConstant.LOV_TYPE_ACTION_TYPE);
	    actionTypeList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public String loadTaskPrioritySelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(BpmEngineConstant.LOV_TYPE_TASK_PRIORITY);
	    taskPriorityList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public void setBpmBO(BpmBO bpmBO)
    {
        this.bpmBO = bpmBO;
    }

    public BpmCO getBpmCO()
    {
        return bpmCO;
    }

    public void setBpmCO(BpmCO bpmCO)
    {
        this.bpmCO = bpmCO;
    }

    public File getUploadFile()
    {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile)
    {
        this.uploadFile = uploadFile;
    }

    public List<SelectCO> getMappingSourceList()
    {
        return mappingSourceList;
    }

    public void setMappingSourceList(List<SelectCO> mappingSourceList)
    {
        this.mappingSourceList = mappingSourceList;
    }


    public List<SelectCO> getAssignmentTypeList()
    {
        return assignmentTypeList;
    }


    public void setAssignmentTypeList(List<SelectCO> assignmentTypeList)
    {
        this.assignmentTypeList = assignmentTypeList;
    }


    public List<SelectCO> getCompletionTypeList()
    {
        return completionTypeList;
    }


    public void setCompletionTypeList(List<SelectCO> completionTypeList)
    {
        this.completionTypeList = completionTypeList;
    }


    public List<SelectCO> getAccessRightAssignmentTypeList()
    {
        return accessRightAssignmentTypeList;
    }


    public void setAccessRightAssignmentTypeList(List<SelectCO> accessRightAssignmentTypeList)
    {
        this.accessRightAssignmentTypeList = accessRightAssignmentTypeList;
    }


    public InputStream getStreamExcel()
    {
        return streamExcel;
    }


    public void setStreamExcel(InputStream streamExcel)
    {
        this.streamExcel = streamExcel;
    }


    public String getStreamFileName()
    {
        return streamFileName;
    }


    public void setStreamFileName(String streamFileName)
    {
        this.streamFileName = streamFileName;
    }


    public InputStream getStreamDoc()
    {
        return streamDoc;
    }


    public void setStreamDoc(InputStream streamDoc)
    {
        this.streamDoc = streamDoc;
    }


    public InputStream getImageStream()
    {
        return imageStream;
    }


    public void setImageStream(InputStream imageStream)
    {
        this.imageStream = imageStream;
    }


    public boolean isShowConfirmation()
    {
        return showConfirmation;
    }


    public void setShowConfirmation(boolean showConfirmation)
    {
        this.showConfirmation = showConfirmation;
    }


    public String getConfirmationResponse()
    {
        return confirmationResponse;
    }


    public void setConfirmationResponse(String confirmationResponse)
    {
        this.confirmationResponse = confirmationResponse;
    }
       
    public List<SelectCO> getActionTypeList()
    {
        return actionTypeList;
    }

    public void setActionTypeList(List<SelectCO> actionTypeList)
    {
        this.actionTypeList = actionTypeList;
    }


    /**
     * @return the taskPriorityList
     */
    public List<SelectCO> getTaskPriorityList()
    {
        return taskPriorityList;
    }


    /**
     * @param taskPriorityList the taskPriorityList to set
     */
    public void setTaskPriorityList(List<SelectCO> taskPriorityList)
    {
        this.taskPriorityList = taskPriorityList;
    }


    /**
     * @return the procVarDefaultTypeList
     */
    public List<SelectCO> getProcVarDefaultTypeList()
    {
        return procVarDefaultTypeList;
    }


    /**
     * @param procVarDefaultTypeList the procVarDefaultTypeList to set
     */
    public void setProcVarDefaultTypeList(List<SelectCO> procVarDefaultTypeList)
    {
        this.procVarDefaultTypeList = procVarDefaultTypeList;
    }
    
}
