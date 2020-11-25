package com.path.vo.common.customization.button;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class ButtonCustomizationConstants
{
    
    public static final BigDecimal LOV_TYPE_MAP_TYPE = new BigDecimal(631);
    public static final BigDecimal LOV_TYPE_SELECTION_TYPE = new BigDecimal(1329);
    public static final BigDecimal LOV_TYPE_ARG_STATUS = new BigDecimal(633);
    public static final BigDecimal LOV_TYPE_ARG_TYPE = new BigDecimal(632);
    public static final BigDecimal LOV_TYPE_API_TYPE = new BigDecimal(634);
    public static final BigDecimal LOV_TYPE_OPERATION_TYPE = new BigDecimal(636);
    public static final BigDecimal LOV_TYPE_DYN_PARAM_TYPE = new BigDecimal(1241);

    public static final String ACCESS_RIGHT_DYNAMIC_OPT = "4";
    public static final String RESULT_RETURN_IMAGE = "returnImage";
    public static final String RESULT_RETURN_IMAGE_ERROR = "returnImage_error";
    public static final String REGISTERED = "1";
    public static final String AES_key = "PathSolutions123";

    
    public enum OP_TYPE
    {
	ACTION("A"), 
	CONDITION("C"); 
	
	private final String code;
	private OP_TYPE(final String code)
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
    
    public enum MAP_TYPE
    {
	SCREEN("1"), 
	SESSION("2"), 
	CONSTANT("3"),
	LINK("4"),
	MAP("6"),
	LIST("7"),
	EXPRESSION("8"),
	GRIDCOLUMN("9");
	
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
    
    
    public enum ARG_TYPE
    {
	NUMBER("N","NUMERIC"),
	DECIMAL("E","DECIMAL"),
	DATE_DATETIME("T","DATE"), 
	VARCHAR("V","VARCHAR"),
	CHAR("C","CHAR"),
	INTEGER("I","INTEGER"),
	LONG("L","NUMERIC"),//Mybatis mapping NUMERIC or LONG INTEGER
	DOUBLE("D","DOUBLE"),
	LIST("A","VARCHAR");
	
	private final String code;
	private final String jdbcType;
	
	private ARG_TYPE(final String code, final String jdbcType)
	{
	    this.code = code;
	    this.jdbcType = jdbcType;
	}
	
	public boolean equals(final String value){
	    return code.equalsIgnoreCase(value);
	}

	public String getJdbcType()
	{
	    return jdbcType;
	}
	
	public static ARG_TYPE getEnumByCode(String code)
	{
	    for(ARG_TYPE e : ARG_TYPE.values())
	    {
		if(e.code.equals(code))
		{
		    return e;
		}
	    }
	    return null;
	}
	
    };
    
    
    public enum ARG_STATUS
    {
	IN("I"), 
	OUT("O"), 
	INOUT("B");
	
	private final String code;
	private ARG_STATUS(final String code)
	{
	    this.code = code;
	}
	
	public boolean equals(final String value){
	    return code.equalsIgnoreCase(value);
	}
	
	public static ARG_STATUS getEnumByCode(String code)
	{
	    for(ARG_STATUS e : ARG_STATUS.values())
	    {
		if(e.code.equals(code))
		{
		    return e;
		}
	    }
	    return null;
	}
	
    };
    
    public enum DATA_TYPE
    {
	JSON("application/json"), 
	XML("application/xml");
		
	private final String code;
	private DATA_TYPE(final String code)
	{
	    this.code = code;
	}
	
	public boolean equals(final String value){
	    return code.equalsIgnoreCase(value);
	}
    }
    
    public enum API_TYPE
    {
	PROCEDURE("P"), 
	WEBSERVICE_SOAP("W"),
	WEBSERVICE_REST("R"),
	BO_SERVICE("S"),
	RMI_BO_SERVICE("M"),
	REPORT("I"),
	CLIENT_SCRIPT("C"),
	SCREEN("D");
	private final String code;
	private API_TYPE(final String code)
	{
	    this.code = code;
	}
	
	public boolean equals(final String value){
	    return code.equalsIgnoreCase(value);
	}
	
    };
    
    public enum ACTION_API_TYPE
    {
	INTEGRATION("1"), 
	REPORT("2"),
	SCREEN("3");
	private final String code;
	private ACTION_API_TYPE(final String code)
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
    
    public static Map<String,BtnCustSessionCO> SESSIONCO_PROPERTIES = new HashMap<String,BtnCustSessionCO>();
    static
    {
	SESSIONCO_PROPERTIES.put("language",new BtnCustSessionCO("language", "Language"));
	SESSIONCO_PROPERTIES.put("companyCode",new BtnCustSessionCO("companyCode", "Company Code"));
	SESSIONCO_PROPERTIES.put("branchCode",new BtnCustSessionCO("branchCode", "Branch Code"));
	SESSIONCO_PROPERTIES.put("userName",new BtnCustSessionCO("userName", "User Name"));
	SESSIONCO_PROPERTIES.put("runningDateRET",new BtnCustSessionCO("runningDateRET", "Running Date RET"));
	SESSIONCO_PROPERTIES.put("baseCurrencyCode",new BtnCustSessionCO("baseCurrencyCode", "Base Currency Code"));
	SESSIONCO_PROPERTIES.put("ctsTellerVO.CODE",new BtnCustSessionCO("ctsTellerVO.CODE", "Teller Code"));
	SESSIONCO_PROPERTIES.put("employeeId",new BtnCustSessionCO("employeeId", "Employee Id"));
	SESSIONCO_PROPERTIES.put("empCompCode",new BtnCustSessionCO("empCompCode", "Employee Company Code"));
	SESSIONCO_PROPERTIES.put("empBranchCode",new BtnCustSessionCO("empBranchCode", "Employee Branch Code"));
	SESSIONCO_PROPERTIES.put("currentAppName",new BtnCustSessionCO("currentAppName", "Current Application Name"));
    }
    
    public static class BtnCustSessionCO
    {
	private String propertyName;
	private String description;
	public String getPropertyName()
	{
	    return propertyName;
	}
	public String getDescription()
	{
	    return description;
	}
	public void setPropertyName(String propertyName)
	{
	    this.propertyName = propertyName;
	}
	public void setDescription(String description)
	{
	    this.description = description;
	}
	public BtnCustSessionCO(String propertyName, String description)
	{
	    this.propertyName = propertyName;
	    this.description = description;
	}
	public BtnCustSessionCO()
	{
	}
    }
    
    public final static String USER_ID_EXP_VAR = "session.userId";
    public final static String COMP_CODE_EXP_VAR = "session.companyCode";
    public final static String COMP_NAME_EXP_VAR = "session.companyName";
    public final static String BRANCH_CODE_EXP_VAR = "session.branchCode";
    public final static String BRANCH_NAME_EXP_VAR = "session.branchName";
    public final static String USER_FIRST_NAME_EXP_VAR = "session.userFirstName";
    public final static String USER_LAST_NAME_EXP_VAR = "session.userLastName";
    public final static String BASE_CURR_NAME_EXP_VAR = "session.baseCurrencyName";
    public final static String TELLER_CODE_EXP_VAR = "session.ctsTellerVO.CODE";
    public final static String RUNNING_DATE = "session.runningDateRET";
    
    public final static Map<String, Object> condExprData = new HashMap<String, Object>();
    static
    {
	condExprData.put(USER_ID_EXP_VAR, null);
	condExprData.put(COMP_CODE_EXP_VAR, null);
	condExprData.put(COMP_NAME_EXP_VAR, null);
	condExprData.put(BRANCH_CODE_EXP_VAR, null);
	condExprData.put(BRANCH_NAME_EXP_VAR, null);
	condExprData.put(USER_FIRST_NAME_EXP_VAR, null);
	condExprData.put(USER_LAST_NAME_EXP_VAR, null);
	condExprData.put(BASE_CURR_NAME_EXP_VAR, null);
	condExprData.put(TELLER_CODE_EXP_VAR, null);
	condExprData.put(RUNNING_DATE, null);
    }
    
    public enum ACTIVITY_TYPE
    {
	DYNAMIC("1"), 
	GLOBAL("2"), 
	CUSTOM("3"),
	BEFOREEXECUTION("4"),
	AFTEREXECUTION("5"),
	ONCHANGE("6"),
	KEYEVENT("7"),
	DOUBLECLICK("8"),
	BOTH("9");
	
	private final String code;
	private ACTIVITY_TYPE(final String code)
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
    
    public enum AUTH_TYPE
    {
	BASIC("B"), 
	OAUTH2("O"); 
	
	private final String code;
	private AUTH_TYPE(final String code)
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
    
}
