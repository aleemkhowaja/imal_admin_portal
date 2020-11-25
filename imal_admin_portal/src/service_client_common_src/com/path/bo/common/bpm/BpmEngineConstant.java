/**
 * 
 */
package com.path.bo.common.bpm;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Copyright 2015, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * JbpmEngineConstant.java used to
 */
public class BpmEngineConstant
{
	
	public static boolean IS_BPMV7 = false;
	public static final String PROPERTIES_FILE_NAME = "PathBpm";
	public static final String BPM_VERSION = "BPM_VERSION";
	
	public enum INSTANCE_STATUS
    {
	ACTIVE("active","1"), 
	COMPLETED("completed","2"), 
	ABORTED("aborted","3");
	
	private final String value;
	private final String statusCode;
	private INSTANCE_STATUS(final String value, final String statusCode)
	{
	    this.value = value;
	    this.statusCode = statusCode;
	}
	
	public boolean equals(final String statusCode){
	    return this.statusCode.equalsIgnoreCase(statusCode);
	}
	
	public String getValue()
	{
	    return this.value;
	}

	public String getStatusCode()
	{
	    return statusCode;
	}
	
    };
    
    public enum TASK_STATUS
    {
	READY("Ready"), 
	RESERVED("Reserved"), 
	IN_PROGRESS("InProgress"),
	CREATED("Created"),
	SUSPENDED("Suspended");
	
	private final String value;
	private TASK_STATUS(final String value)
	{
	    this.value = value;
	}
	
	public boolean equals(final String value){
	    return this.value.equalsIgnoreCase(value);
	}
	public String getValue()
	{
	    return this.value;
	}
    };
    
    public static final String DATE_FORMAT_WITH_TIME = "dd/MM/yyyy HH:mm:ss";
    public static final String INPUT_ARG = "I"; 
    public static final String OUTPUT_ARG = "O"; 
 
    public static final String BPM_PROPERTY_FILE = "PathBpm.properties";
    public static final String BPM_BO_MAPPING_PROPERTY_FILE = "PathBpmBOMapping.properties";
        
    public static final String LOAD_BPM_PROCESS_INST_TASKS_LIST = "loadProcessInstanceTasksGrid";
    public static final String LOAD_BPM_USER_TASKS_PAGE = "loadBpmUserTasksPage";
    public static final String LOAD_BPM_PROCESS_INSTANTIATION_PAGE = "loadBpmProcessInstantiationPage";
    public static final String LOAD_BPM_PROCESS_MAPPING_PAGE = "loadBpmProcessMappingPage";
    public static final String LOAD_BPM_PROCESS_IMAGE = "loadBpmProcessImage";
    public static final String FILE_SUCCESS = "fileSuccess";
    public static final String LOAD_BPM_USER_TASK_MAPPING_LIST = "loadBpmUserTaskMappingList";
    public static final String LOAD_BPM_PROCESS_ACCESS_RIGHT_LIST = "loadProcessAccessRightList";
    public static final String LOAD_BPM_PROCESS_VARIABLES_LIST = "loadProcessVariablesList";
    public static final String LOAD_BPM_TASK_FORWARD_PAGE = "loadBpmTaskForwardPage";
    public static final String LOAD_DYNAMIC_PARAMS = "loadDynamicParams";
    public static final String RELOAD_IN_MAPPING_SOURCE = "reloadInMappingSource";
    public static final String RELOAD_OUT_MAPPING_SOURCE = "reloadOutMappingSource";
    public static final String LOAD_UPLOAD_PROC_MAINT_PAGE = "loadUploadProcMaintPage";
    public static final String LOAD_TASK_ASSIGNMENT_PAGE = "loadTaskAssignmentPage";
    public static final String LOAD_BPM_EXTERNAL_TASK_FORM = "loadBpmExternalTaskForm";
    public static final String LOAD_BPM_COMMON_COMMENT_PAGE = "loadBpmCommonCommentPage";
    public static final String LOAD_BPM_LOGS_LIST = "loadBpmLogsList";
    public static final String LOAD_BPM_DOCS_LIST = "loadBpmDocsList";
    public static final String OPEN_IMPORT_DIALOG = "openImportDialog";
    
    public static final BigDecimal LOV_TYPE_MAP_TYPE = new BigDecimal(631);
    public static final BigDecimal LOV_TYPE_ID_SCREEN_DESC = new BigDecimal(651);
    public static final BigDecimal LOV_TYPE_ID_ARG_DESC = new BigDecimal(652);
    public static final BigDecimal LOV_TYPE_TASK_ASSIGNMENT_DESC = new BigDecimal(654);
    public static final BigDecimal LOV_TYPE_TASK_COMPLETION_DESC = new BigDecimal(662);
    public static final BigDecimal LOV_TYPE_TASK_ACTIONS_DESC = new BigDecimal(763);
    public static final BigDecimal LOV_TYPE_ACTION_TYPE = new BigDecimal(927);
    public static final BigDecimal LOV_TYPE_DYN_ELM_TYPE = new BigDecimal(659);
    public static final BigDecimal LOV_TYPE_TASK_PRIORITY = new BigDecimal(1102);
    
    public static final String DEFAULT_INITIATOR_NAME = "INIT";
    public static final String PNG_IMAGE_TYPE = "png";
    public static final String JPG_IMAGE_TYPE = "jpg";
    
    public static final String EXPORT_DOC = "DOC";
    public static final String EXPORT_XLS = "XLS";
    
    public static final String ACCEPT_PNG = "image/png";
    public static final String ACCEPT_XML = "text/xml";
    
    // Added for upgrade JBPM to 7.31
    public static final String SVG_IMAGE_TYPE = "svg";
    public static final String ACCEPT_APP_XML = "application/xml";
    public static final String ACCEPT_APP_JSON = "application/json";
    public static final String ACCEPT_APP_SVG_XML = "application/svg+xml";
    
    public static final String SESSION_VAR_PREFIX = "session.";
    
    public static Map<String, Map<String, Map<String, String>>> BPM_BO_MAPPING = null;
    static
    {
	if(BPM_BO_MAPPING == null)
	{
	    BpmCommonMethods.initializeBpmBOMappingProperties();
	}
    }
    
    public static String BPM_ADMIN_PASSWORD = null;
    public static enum BPM_PROPERTIES
    {
	URL_PORTAL(null),
	URL_USER_ASSIGNED_AVAILABLE_TASKS(null), 
	URL_COMPLETE_TASK_WITH_PARAM(null),
	URL_CLAIM_TASK(null),
	URL_RELEASE_TASK(null),
	URL_START_TASK(null),
	URL_FORWARD_TASK(null),
	URL_PROCESS_DEFINITION_LIST(null),
	URL_START_PROCESS_INSTANCE(null),
	URL_PROCESS_DEFINITION_IMAGE(null),
	URL_PROCESS_INSTANCE_IMAGE(null),
	URL_TASK_DETAILS(null),
	URL_PROCESS_VARIABLES(null),
	URL_TASKS_BY_PROCESS_INSTANCE(null),
	URL_NOMINATE_TASK(null),
	BPM_ADMIN_USERNAME(null),
	EXPIRED_TASK_HIGHLIGHT_COLOR(null),
	URL_TASK_FORM_URL(null),
	URL_PROCESS_INSTANCES(null),
	URL_ABORT_INSTANCE(null),
	URL_SUSPEND_TASK(null),
	URL_RESUME_TASK(null),
	URL_USER_ASSIGNED_BPMADMIN_TASKS(null),
	URL_DELEGATE_TASK(null),
	TASK_GRID_REFRESH_TIME(null);
	
	private String value;
	private BPM_PROPERTIES(final String value)
	{
	    this.value = value;
	}
	public String getValue()
	{
	    return value;
	}
	public void setValue(String value)
	{
	    this.value = value;
	}
	
	static
	{
	    //this code is executed only one time , at the first access or use of BPM_PROPERTIES
	    BpmCommonMethods.initializeBpmEngineProperties();
	}
    };
    
    public enum MAP_TYPE
    {
	SCREEN("1"), 
	SESSION("2"), 
	CONSTANT("3"),
	BPM_PROCESS_VARIABLE("5");
	
	private final String code;
	private MAP_TYPE(final String code)
	{
	    this.code = code;
	}
	
	public boolean equals(final String value){
	    return code.equalsIgnoreCase(value);
	}
	public String getCode()
	{
	    return code;
	}
    };
    
    public enum TASK_ASSIGN_TYPE
    {
	USER("1"), 
	ROLE("2"), 
	INITIATOR("3");
	
	private final String value;
	private TASK_ASSIGN_TYPE(final String value)
	{
	    this.value = value;
	}
	
	public boolean equals(final String value){
	    return this.value.equalsIgnoreCase(value);
	}
	public String getValue()
	{
	    return this.value;
	}
    };
    
    public enum COMPLETION_TYPE
    {
	MANUEL("1"), 
	AUTOMATIC("2"), 
	BOTH("3");
	private final String value;
	private COMPLETION_TYPE(final String value)
	{
	    this.value = value;
	}
	public boolean equals(final String value){
	    return this.value.equalsIgnoreCase(value);
	}
	public String getValue()
	{
	    return this.value;
	}
    };
    
    
    public enum TASK_ACTION_TYPE
    {
	NORMAL("1"), 
	DYNAMIC("2");
	
	private final String value;
	private TASK_ACTION_TYPE(final String value)
	{
	    this.value = value;
	}
	public boolean equals(final String value){
	    return this.value.equalsIgnoreCase(value);
	}
	public String getValue()
	{
	    return this.value;
	}
    };
    
    public enum PROCESS_VARAIBLES_TYPES
    {
	FLOAT("Float"), 
	INTEGER("Integer");
	
	private final String value;
	private PROCESS_VARAIBLES_TYPES(final String value)
	{
	    this.value = value;
	}
	public boolean equals(final String value){
	    return this.value.equalsIgnoreCase(value);
	}
	public String getValue()
	{
	    return this.value;
	}
    };
    
    public enum LOG_ENTITY_TYPES
    {
	INSTANCE("1"), 
	TASK("2");
	
	private final String value;
	private LOG_ENTITY_TYPES(final String value)
	{
	    this.value = value;
	}
	public boolean equals(final String value){
	    return this.value.equalsIgnoreCase(value);
	}
	public String getValue()
	{
	    return this.value;
	}
    };
    
    public enum LOG_ACTION_TYPES
    {
	TASK_SUSPEND_REASON("1"), 
	TASK_RESUME_REASON("2"),
	INSTANCE_CREATION_DESCRIPTION("3"),
	TASK_COMMENT("4");
	
	private final String value;
	private LOG_ACTION_TYPES(final String value)
	{
	    this.value = value;
	}
	public boolean equals(final String value){
	    return this.value.equalsIgnoreCase(value);
	}
	public String getValue()
	{
	    return this.value;
	}
    };
	
}
