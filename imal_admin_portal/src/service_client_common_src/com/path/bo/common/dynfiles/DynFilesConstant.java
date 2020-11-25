package com.path.bo.common.dynfiles;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: ElieAchkar
 * 
 *          AuditConstant.java used to set all data members that will be used in the BO 
 */
public class DynFilesConstant
{
    public static final String FUNCTION_PARAMETER = "f_";
    public static final String PERCENTAGE = "%";
    public static final String DAY_DD = "dd";
    public static final String MONTH_MM = "mm";
    public static final String YEAR_YYYY = "yyyy";
    public static final String YEAR_YY = "yy";
    
    public static final String COMPANY = PERCENTAGE + "COMPANY" + PERCENTAGE;
    public static final String COMP_DESC = PERCENTAGE + "COMP_DESC" + PERCENTAGE;
    public static final String COMP_ARABIC_DESC = PERCENTAGE + "COMP_ARABIC_DESC" + PERCENTAGE;
    public static final String BRANCH = PERCENTAGE + "BRANCH" + PERCENTAGE;
    public static final String USER_ID = PERCENTAGE + "USERID" + PERCENTAGE;
    public static final String TODAY_DATE = PERCENTAGE + "TODDATE" + PERCENTAGE;
    public static final String SYS_DATE = PERCENTAGE + "SYSDATE" + PERCENTAGE;
    public static final String BASE_CY = PERCENTAGE + "BASECY" + PERCENTAGE;
    public static final String CY_DEC = PERCENTAGE + "CYDEC" + PERCENTAGE;
    public static final String REFERENCE = PERCENTAGE + "REFERENCE" + PERCENTAGE;
    public static final String VERSION = PERCENTAGE + "VERSION" + PERCENTAGE;
    public static final String FISCAL_YEAR = PERCENTAGE + "FISCALYEAR" + PERCENTAGE;
    public static final String BASE_CY_NAME = PERCENTAGE + "BASECYNAME" + PERCENTAGE;
    public static final String EXPOSURE_CY = PERCENTAGE + "EXPOSURECY" + PERCENTAGE;
    public static final String EXPOSURE_CY_NAME = PERCENTAGE + "EXPOSURECYNAME" + PERCENTAGE;
    public static final String FILE_NAME = PERCENTAGE + "FILE_NAME" + PERCENTAGE;
    public static final String FILE_LOCATION = PERCENTAGE + "FILE_LOCATION" + PERCENTAGE;
    public static final String FILE_EXTENSION = PERCENTAGE + "FILE_EXTENSION" + PERCENTAGE;
    public static final String SERVER_DATE = PERCENTAGE + "SERVERDATE" + PERCENTAGE;
    public static final String COMPANY_BATCH = PERCENTAGE + "Batch_COMP_CODE" + PERCENTAGE;
    public static final String USER_ID_BATCH = PERCENTAGE + "Batch_USER_ID" + PERCENTAGE;
    public static final String FILE_TYPE = "file_type";
    
    
    public static final String UPPER_CASE = "!";
    public static final String LOWER_CASE = "^";
    public static final String NUMBER = "#";
    public static final String ALPHANUMERIC = "a";
    public static final String ANY_CHARACTER = "x";
    public static final String HOUR = "hh";
    public static final String MINUTES = "mm";
    
    public static final String DATE_TYPE = "1";
    public static final String DATE_TIME_TYPE = "2";
    public static final String DECIMAL_TYPE = "3"; 
    public static final String NUMBER_TYPE = "4";
    public static final String STRING_TYPE = "5";
    public static final String TIME_TYPE = "6"; 
    
    public static final String XML_FILE = "1";
    public static final String EXCEL_FILE = "2";
    public static final String DELIMITED_FILE = "3"; 
    public static final String TEXT_FILE = "4";
    
    public static final String TAB_DELIMITED = "1";
    public static final String SEMI_COLUMN_DELIMITED = "2";
    public static final String SPACE_DELIMITED = "3";
    public static final String COMMA_DELIMITED = "4";
    public static final String OTHER_DELIMITER = "5";
    
    public static final String TAB_DELIMITED_VALUE = "\t";
    public static final String SEMI_COLUMN_DELIMITED_VALUE = ";";
    public static final String SPACE_DELIMITED_VALUE = " ";
    public static final String COMMA_DELIMITED_VALUE = ",";
    
    public static final int IS_GROUP = 1;
    
    public static final String VALUE_SEPERATOR = "^&#";
    public static final String CONTROL_CHAR = "#~@%^";
    public static final String DEFAULT_DELIMITER = "#~";
    public static final String PARAMETER_SYMBOL = "?";
    public static final String NEW_LINE = "\n";
    public static final String CARRIAGE_RETURN = "\r";
    public static final String RETURN_NEW_LINE ="\r" + "\r" + "\n";
    
    public static final String CLOSE_PARENTHESES = ")";
    public static final String DOT = ".";
    
    public static final Integer BULK_COUNT_ORA = 5000;
    public static final Integer BULK_COUNT_SYB = 50;
    
    public static final String FORWARD_SLASH = "/";
    
    public static final String DYNAMIC_TABLE = "<dynamic_table>";
    public static final String FOOTER_TRL = "TRL";
    

    
    public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>";
   
    public static final ArrayList<String> DEFAULT_VALUES = new ArrayList<String>();
    public static final ArrayList<String> DELIMITERS = new ArrayList<String>();
    public static final ArrayList<String> FORMAT_EXPRESSION = new ArrayList<String>();
    
    public static final String QUERY_STRING_ENCRIPTION = "DYN_FILES_QUERYS";
    public static final String TRX_ATM = "#TRXATM#";
    
    //Security filesize limit
    public static final String FILESIZE_LIMIT = "dfs.fileSizeLimit";
    
    public static final String IMPORT_FILE_ERROR = "E";
    public static final String IMPORT_FILE_SUCCESS = "S";
    
    public static final BigDecimal CBS_UPLOAD_BATCH_IDENTFIER = BigDecimal.valueOf(9);
    
    static
    {
	DEFAULT_VALUES.add(COMPANY); 		// gv_company_code
	DEFAULT_VALUES.add(COMP_DESC); 		// gv_company_name
	DEFAULT_VALUES.add(COMP_ARABIC_DESC);	// gv_company_name_arabic
	DEFAULT_VALUES.add(BRANCH);		// gv_branch_code
	DEFAULT_VALUES.add(USER_ID);		// gv_userid
	DEFAULT_VALUES.add(TODAY_DATE);		// gv_today
	DEFAULT_VALUES.add(SYS_DATE);		// gv_system_date
	DEFAULT_VALUES.add(BASE_CY);		// gv_currency
	DEFAULT_VALUES.add(CY_DEC);		// gv_cy_dec
	DEFAULT_VALUES.add(REFERENCE);		// gv_window_reference
	DEFAULT_VALUES.add(VERSION);		// gi_version
	DEFAULT_VALUES.add(FISCAL_YEAR);	// gv_fiscal_year
	DEFAULT_VALUES.add(BASE_CY_NAME);	// gs_base_cy_name_eng
	DEFAULT_VALUES.add(EXPOSURE_CY);	// gv_exposure_cy
	DEFAULT_VALUES.add(EXPOSURE_CY_NAME);	// gv_exposure_cy_name_eng
	DEFAULT_VALUES.add(FILE_NAME);		// is_file_name
	DEFAULT_VALUES.add(FILE_LOCATION);	// is_file_location
	DEFAULT_VALUES.add(FILE_EXTENSION);	// is_file_extension
	DEFAULT_VALUES.add(SERVER_DATE); 	// uf_get_server_date(ldt_server_date)
    }
    
    static
    {
	DELIMITERS.add(TAB_DELIMITED);
	DELIMITERS.add(SEMI_COLUMN_DELIMITED);
	DELIMITERS.add(SPACE_DELIMITED);
	DELIMITERS.add(COMMA_DELIMITED);
    }
    
    static
    {
    	FORMAT_EXPRESSION.add(UPPER_CASE);
    	FORMAT_EXPRESSION.add(LOWER_CASE);
    	FORMAT_EXPRESSION.add(NUMBER);
    	FORMAT_EXPRESSION.add(ALPHANUMERIC);
    	FORMAT_EXPRESSION.add(ANY_CHARACTER);
    	FORMAT_EXPRESSION.add(DAY_DD);
    	FORMAT_EXPRESSION.add(MONTH_MM);
    	FORMAT_EXPRESSION.add(YEAR_YY);
    	FORMAT_EXPRESSION.add(YEAR_YYYY);
    	FORMAT_EXPRESSION.add(HOUR);
    	FORMAT_EXPRESSION.add(MINUTES);
    }

}