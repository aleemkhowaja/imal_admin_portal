/**
 * 
 */
package com.path.bo.common.alerts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 * AlertsConstants.java used to
 */
public class AlertsConstants
{
    public static final String IVCRUD_PAGE_REF_PATTERN = "_pageRef={0}_ALERT&iv_crud={1}";
    public static final String PAGE_REF_SUFFIX = "_ALERT";
    public static final String EXECUTE_RET_PROC_KEY = "executeRetProc";
    public static final String RET_PROC_PARAM_MAP_KEY = "retProcParamMap";
    //Alerts types
    public static final String ALERT_TYPE_TRANS = "TRANS";
    public static final String ALERT_TYPE_ACK   = "ACK";
    public static final String ALERT_TYPE_TO    = "TO";
    public static final String ALERT_TYPE_PBD   = "PBD";
    
    //ALERTS STATUS IN S_TODO_DET
    public static final String STATUS_ACTIVE  = "A";
    public static final String STATUS_DELETED = "D";
    
    //ToDoDet params
    public static final String USER_ACTION_G = "G";
    public static final String JOB_ACTION_G  = "G";
    public static final String JOB_ACTION_C  = "C";
    
    //Todo Alert type
    public static final String TODO_ALERT_X = "X";
    public static final String TODO_ALERT_Y = "Y";
    
    //Action types
    public static final String ACTION_TYPE_X = "X";
    
    //Distribution
    public static final String DISTRIBUTION_TYPE_B = "B";
    public static final String DISTRIBUTION_TO_U   = "U";
    
    //Todo Type
    public static final String TODO_TYPE_P = "P";
    public static final String TODO_TYPE_C = "C";
    
    //Todo Priority
    public static final String TODO_PRIORITY_A = "A";
    
    //Todo checked
    public static final String TODO_CHECKED_U = "U";
    
    //Todo execution
    public static final String TODO_EXECUTION_N = "N";
    
    //ALERTS STATUS IN S_TODO_DET
    public static final String ALERTS_PAGE_REF_SUFFIX = "_ALERT";
    
    //Url parameters
    public static final String PARMETERS_SEPARATOR    = "?";
    public static final String PARMETERS_CONCATENATOR = "&";
    public static final String PARMETERS_EQUAL        = "=";

    //Alerts action results
    public static final String ALERT_JSON_SUCCESS  = "alert_success";
    /* Login Alert Implementation TP#297149 */
    public static final String ALERT_LOGIN_MGNT_PAGE  = "loadAlertsLoginMgnt";
    //Alerts f_update_todo
    public static final String UPDATE_ALL_TRX = "ALL";
    public static final String UPDATE_NO_TRX = "NO";
    
    //Alerts label key suffix
    public static final String ALERT_FORWARD_TITLE_SUFFIX = "_FORWARD_TITLE";
    public static final String ALERT_SEND_TITLE_SUFFIX = "_SEND_TITLE";
    public static final String ALERT_SEND_TITLE_SUFFIX_LOWERCASE = "_send_title";
    
    public static final String ALERT_TODO_EXCEP_PATTERN = "{0}_{1}_TODO_EXCEP";
    
    public static final String OPEN_ITEM_JS_FUNC_KEY  			 = "OPEN_ITEM_BUILD_PARAM_FUNC";
    public static final String OPEN_ITEM_PARAMS_KEY 			 = "OPEN_ITEM_PARAMS_KEY";
    public static final String OPEN_ITEM_ADD_BUTTON_FUNCTION_KEY = "OPEN_ITEM_ADD_BUTTON_FUNC";
    public static final String OPEN_ITEM_IV_CRUD_KEY 			 = "OPEN_ITEM_IV_CRUD";
    public static final String CALL_BACK_PRINT_FUNC_KEY 		 = "PRINT_FUNC";
    public static final String ALERT_PARAM_KEY  				 = "ALERT_PARAM";
    public static final String CALL_BACK_PRINT_REQUIRE_JS_KEY 	 = "REQUIRE_JS_FILE";
    public static final String CALL_BACK_PRINT_REQUIRE_PATH_KEY  = "REQUIRE_JS_PATH";
    public static final String CALL_BACK_FUNC_KEY 				 = "OPEN_ITEM_CALLBACK_FUNC";
    public static final String CALL_BACK_TRX_DETAILS_FUNC_KEY 	 = "TRX_DETAILS_FUNC";
    
    public static final String ALLOW_LOCAL_APPROVE_BY_DEFAULT = "1";
    public static final BigDecimal ALERT_WAIT_TIME_BY_DEFAULT = new BigDecimal(60);
    
    //NABIL FEGHALI - BISI120150 - Alert Offline
    public static final String HIGHLIGHT_COLOR_ENTRY = "color";
    public static final String HIGHLIGHT_USERS_ENTRY = "users";
    public static final String HIGHLIGHT_COLOR_RED = "red";
    public static final BigDecimal ONLINE_STATUS_LOV_TYPE = new BigDecimal(389);
    public static final BigDecimal STATUS_LOV_TYPE = new BigDecimal(118);
    public static final BigDecimal TODO_ALERT_LOV_TYPE = new BigDecimal(100);
    public static final BigDecimal TODO_ALERT_DESC_LOV_TYPE = new BigDecimal(96);
    public static final BigDecimal TODO_ALERT_DESC_IIS_LOV_TYPE = new BigDecimal(571);
    public static final BigDecimal TODO_ALERT_DESC_FMS_LOV_TYPE = new BigDecimal(572);
    
    public static final String LOAD_IN_NEW_WINDOW = "loadInNewWindow";
    
    /******************************************** Login Alerts - alerts constants *******************************************************/
    /* Login Alert Implementation TP#297149 */
    public static final String TODO_ALERT_LOGIN_REQUEST = "@LM";
    public static final String TODO_ALERT_LOGIN_APPROVAL = "@LA";
    public static final String TODO_ALERT_LOGIN_REJECTION = "@LR";
    public static final String ALERT_LOGIN_APPROVAL_FLAG = "ALERT_LOGIN_APPROVAL_FLAG";
    
    // TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
    public static final String TODO_ALERT_LOGIN_REQUEST_AFTER_FINAL_SIGNOFF = "@LMS";
    public static final String TODO_ALERT_LOGIN_APPROVAL_AFTER_FINAL_SIGNOFF = "@LAS";
    public static final String TODO_ALERT_LOGIN_REJECTION_AFTER_FINAL_SIGNOFF = "@LRS";
    public static final String ALERT_LOGIN_AFTER_FINAL_SIGNOFF_FLAG = "ALERT_LOGIN_AFTER_FINAL_SIGNOFF_FLAG";
    
    public static final String LOGIN_ALERT_PAGE_REF = "LOGIN_ALERT";
    public static final String LOGIN_ALERT_LABEL_KEY = "Login_Alert_key";
    public static final String LOGIN_ALERT_DESCRIPTION_PATTERN = "<User_Id_key>: {0}, \n<User_Name_key>: {1} {2}, \n<app_name_key>: {3}";
    public static final String LOGIN_ALERT_DESCRIPTION_DETAILS_PATTERN = "<Company_key>: {0}, <Branch_key>: {1}, <User_Id_key>: {2}, <User_Name_key>: {3}, <app_name_key>:{4}";
    
    public static final String LOGIN_ALERT_USR_LOGIN_LOG_REJECT_REASON = "T";
    // TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
    public static final String LOGIN_ALERT_USR_LOGIN_LOG_REJECT_REASON_FOR_FINAL_SIGNOFF = "U";
    
    //this static arraylist contains the allowed urls, it is used in PathSessionInterceptor to check which action is allowed and which one should be blocked 
    public final static List<String> LOGIN_ALERT_ALLOWED_URL = new ArrayList<String>();
    static
    {
	LOGIN_ALERT_ALLOWED_URL.add("/pathdesktop/generateMenuOnRequest"); //needed to allow loading the menu
	LOGIN_ALERT_ALLOWED_URL.add("/path/alerts/AlertsGrid_");//needed to allow all send alerts actions
	LOGIN_ALERT_ALLOWED_URL.add("/path/alerts/AlertsMaint_");//needed to allow all send alerts actions
	LOGIN_ALERT_ALLOWED_URL.add("/path/alerts/TrsAckTOutAlertsMaint_");//needed to allow all received alerts actions
	LOGIN_ALERT_ALLOWED_URL.add("/path/alerts/TrsAckTOutAlertsGrid_");//needed to allow all received alerts actions
	LOGIN_ALERT_ALLOWED_URL.add("/pathdesktop/DesktopAction_returnExternalUrls");//needed to allow the logout actions
	LOGIN_ALERT_ALLOWED_URL.add("/login/unSecureAction_logout");//needed to allow the logout actions
	LOGIN_ALERT_ALLOWED_URL.add("/pathdesktop/DesktopAction_");//needed when clicking on F5
	LOGIN_ALERT_ALLOWED_URL.add("/pathdesktop/loginCompBrAction_moduleRedirect");
	LOGIN_ALERT_ALLOWED_URL.add("/pathdesktop/dashboard.action");//needed when clicking on switch view
	LOGIN_ALERT_ALLOWED_URL.add("/login/unSecureAction_sessionTimeout");//needed to let the session timeout action to proceed
	LOGIN_ALERT_ALLOWED_URL.add("/login/unSecureAction_prelogin");//needed to let the session timeout action to proceed
	LOGIN_ALERT_ALLOWED_URL.add("/path/alerts/AlertsLoginMgnt_");//needed to enable all alerts login management actions
	LOGIN_ALERT_ALLOWED_URL.add("/pathdesktop/loginCompBrAction_loginCoBrScreen");//needed when click on switch view
	
    }
    
    
 /******************************************** Transfer Accounts - alerts constants *******************************************************/
    
    public static final String TRANSFER_ACCOUNTS_ALERT_TYPE = "TA";
    
    public static final String TRANSFER_ACCOUNTS_REASON_CODE = "TA";

    public static final String TRANSFER_ACCOUNTS_APPROVE_KEY = "Approve_key";

    public static final String TRANSFER_ACCOUNTS_CREATE_ADD_CODE = "TABC";
    public static final String TRANSFER_ACCOUNTS_CANCEL_ADD_CODE = "TACP";
    public static final String TRANSFER_ACCOUNTS_PRIVELEGE_ADD_CODE = "TANA";

    public static final String TRANSFER_ACCOUNTS_PROGREF_APPROVE = "TA001P";
    public static final String TRANSFER_ACCOUNTS_PROGREF_APPROVE_CANCEL = "TA001CP";
    
    public static final String TRANSFER_ACCOUNTS_APPROVE_CANCEL_IV_CRUD= "C";
    public static final String TRANSFER_ACCOUNTS_APPROVE_IV_CRUD= "P";

    public static final String TRANSFER_ACCOUNTS_ACK_APPROVE = "TAP";
    public static final String TRANSFER_ACCOUNTS_ACK_REJECTED = "TAR";
    
    public static final String TRANSFER_ACCOUNTS_EXCEP_ON_UPDATE = "TA_UPDATE_TODO_EXCEP";

  
    public static final String TRANSFER_ACCOUNTS_TELLER_ALERT_DESCRIPTION_PATTERN = "<batch_no_key> : {0}";
       

    
    /******************************************** Recording of Remittance - alerts constants *******************************************************/
    
    public static final String REMITTANCE_PAGE_RRTP = "RRTP";
    public static final String REMITTANCE_ALERT_LABEL_KEY = "Recording_of_Remittance__key";
    public static final String REMITTANCE_ALERT_DESCRIPTION_PATTERN = "<Recording_of_Remittance_No_key>:{0}, \n<vaultLookup.vault>:{1}, \n<_Reference_key>:{2}, \n<Remittance_Type_key>:{3}, \n<Currency_key>:{4}";
    public static final String REMITTANCE_ALERT_REASON_CODE = "ROF";
    public static final String REMITTANCE_ALERT_TYPE = "REMITTANCE_RECORD";
    public static final String REMITTANCE_TODO_ALERT = "RR";
    public static final String REMITTANCE_APPROVE_DESC = "Approve_key";
    public static final String REMITTANCE_TODO_EXCEP_ON_UPDATE = "RR_UPDATE_TODO_EXCEP";
  
    //Rania
    public static final String EXC_AUTH_OFFICE_DESCRIPTION_PATTERN = "<exch_auth_office_key>\n<auth_no_key>:{0}";
    public static final String EXC_AUTH_OFFICE_TODO_ALERT = "EOA";
    public static final String EXC_AUTH_OFFICE_ALERT_REASON_CODE = "EOA";
    public static final String EXC_AUTH_OFFICE_TODO_ALERT_CANCEL = "EOC";
    public static final String EXC_AUTH_OFFICE_ALERT_REASON_CODE_CANCEL = "EOC";
    public static final String EXC_AUTH_OFFICE_APPROVE_DESC = "Approve_key";
    public static final String EXC_AUTH_OFFICE_CANCEL_DESC = "Cancel_key";
    public static final String EXC_AUTH_OFFICE_ALERT_ADD_CODE_EACR = "EACR";
    public static final String EXC_AUTH_OFFICE_ALERT_ADD_CODE_EACA = "EACA";
    public static final String EXC_AUTH_OFFICE_ALERT_ADD_CODE_NAP = "NAP";
    public static final String EXC_AUTH_OFFICE_PAGE_EOA00MT = "EOA00MT";
    public static final String EXC_AUTH_OFFICE_TODO_EXCEP_ON_UPDATE = "EXOA_UPDATE_TODO_EXCEP";
    public static final String EXC_AUTH_OFFICE_PAGE_EOA00P = "EOA00P";
    public static final String EXC_AUTH_OFFICE_PAGE_EOA00C = "EOA00AC";
    public static final String EXC_AUTH_OFFICE_ALERT_IV_CRUD_P = "P";
    public static final String EXC_AUTH_OFFICE_ALERT_IV_CRUD_AC = "AC";
    public static final String EXC_AUTH_OFFICE_ACK_APPROVE = "EOP";
    public static final String EXC_AUTH_OFFICE_ACK_REJECT = "EOJ";
    
    public static final String EXC_AUTH_OFFICE_ACK_CANCEL_APPROVE = "EOK";
    public static final String EXC_AUTH_OFFICE_ACK_CANCEL_REJECT = "EOL";
    
    /** Negotiation Rate
     * 
     */
    
    public static final String USE_NEGO_RATE = "true";
    //End Rania
    
    
    //Remittance Alert Additional code
    public static final String REMITTANCE_ALERT_ADD_CODE_RI = "RI";
    
    //Remittance IV_CRUD
    public static final String REMITTANCE_ALERT_IV_CRUD_P = "P";
    public static final String REMITTANCE_ALERT_IV_CRUD_N = "N";
    public static final String REMITTANCE_ALERT_IV_CRUD_ADY = "ADY";
    public static final String REMITTANCE_ALERT_IV_CRUD_ADM = "ADM";
   	
    //Remittance Ack response
    public static final String REMITTANCE_ACK_APPROVE = "RRP";
    public static final String REMITTANCE_ACK_DESTROY = "RRY";
    public static final String REMITTANCE_ACK_CANCEL = "RRN";
    public static final String REMITTANCE_ACK_DAMAGE = "RRM";
    public static final String REMITTANCE_ACK_REJECT = "RRJ";

    
    /******************************************** CLUBBED ACCOUNTS - alerts constants *******************************************************/
    
    public static final String CLUBBED_ACCOUNTS_PAGE_CLA0TP = "CLA0TP";
    public static final String CLUBBED_ACCOUNTS_ALERT_LABEL_KEY = "Clubbed_Accounts_key";
    public static final String CLUBBED_ACCOUNTS_ALERT_TYPE = "CLUBBED_ACCOUNTS";
    public static final String CLUBBED_ACCOUNTS_ALERT_REASON_CODE = "CLA";
    public static final String CLUBBED_ACCOUNTS_ALERT_DESCRIPTION_PATTERN = "<Clubbed_Accounts_No_key>:{0}";
    public static final String CLUBBED_ACCOUNTS_TODO_ALERT = "CLA";
    public static final String CLUBBED_ACCOUNTS_TODO_EXCEP = "CLA_TODO_EXCEP";
    public static final String AMEND_CLUBBED_ACCOUNTS_TODO_EXCEP = "CLA_UPDATE_TODO_EXCEP";
    public static final String CLUBBED_ACCOUNTS_TODO_EXCEP_ON_CANCEL = "CLA_CANCEL_TODO_EXCEP";
    public static final String CREATION_CLUBBED_ACCOUNTS_TODO_EXCEP = "CLA_CREATE_TODO_EXCEP";
    public static final String NO_APP_PROV_CLUBBED_ACCOUNTS_TODO_EXCEP = "CLA_NO_APPROVE_PRIVILEGE_TODO_EXCEP";
    public static final String CLUBBED_ACCOUNTS_TODO_EXCEP_ON_TO_CANCEL = "CLA_TO_CANCEL_TODO_EXCEP";
    
    //CLUBBED ACCOUNTS IV_CRUD
    public static final String CLUBBED_ACCOUNTS_ALERT_IV_CRUD_P = "P"; //APPROVE
    public static final String CLUBBED_ACCOUNTS_ALERT_IV_CRUD_AC = "AC"; //TOCANCEL
    public static final String CLUBBED_ACCOUNTS_ALERT_IV_CRUD_Z = "Z"; //CANCEL
    public static final String CLUBBED_ACCOUNTS_ALERT_IV_CRUD_APPROVE_CANCEL= "C"; //CANCEL APPROVE

    
    //CLUBBED ACCOUNTS ACK RESPONSE
    public static final String CLUBBED_ACCOUNTS_ACK_APPROVE = "CAP";
    public static final String CLUBBED_ACCOUNTS_ACK_CANCEL = "CAN";
    public static final String CLUBBED_ACCOUNTS_ALERT_REJECT = "CAR";
    public static final String CLUBBED_ACCOUNTS_TODO_ALERT_APPROVE = "CAA";
    public static final String CLUBBED_ACCOUNTS_TODO_ALERT_CANCEL = "CAC";
    
    public static final String CLUBBED_ACC_CREATION_ALERT_ADD_CODE_CI = "CI";
    public static final String CLUBBED_ACC_APPROVE_PRIVILEGE_ALERT_ADD_CODE_NP = "NP";
    public static final String CLUBBED_ACC_APPROVE_PRIVILEGE_ALERT_ADD_CODE_AI = "AI";
    public static final String CLUBBED_ACC_CANCELLATION_ALERT_ADD_CODE_CN = "CN";

    
    /******************************************** SMS Subscription - alerts constants *******************************************************/
    public static final String SMS_ALERT_REASON_CODE = "SMS";
    public static final String SMS_ALERT_DESCRIPTION_PATTERN = "<SMS_Subscription_No_key>:{0}";
    public static final String SMS_ALERT_ADD_CODE_KYC = "KYC";
    public static final String SMS_PAGE_SMS00P = "SMS00P";
    public static final String SMS_TODO_EXCEP_ON_UPDATE = "sms_todo_excep_on_update";
    public static final String SMS_APPROVE_DESC = "Approve_key";
    
   // public static final String SMS_TODO_ALERT_APPROVE 		= "SMSA";
    public static final String SMS_TODO_ALERT = "SMS";
    public static final String SMS_ACK_APPROVE 			= "SMSP";
    public static final String SMS_ACK_REJECT			= "SMSR";
   
       
    /******************************************** Lost and Found - alerts constants *******************************************************/
    
    public static final String LOSTFOUND_ALERT_DESCRIPTION_PATTERN = "<Lost_And_Found_Trx_No_key>:{0},\n<CIF_key>:{1},\n<AC_No._key>:{2},\n<Document_Type_key>:{3}";
    public static final String LOSTFOUND_ALERT_REASON_CODE = "LFD";
    public static final String LOSTFOUND_ALERT_TYPE = "LOSTFOUND";
    public static final String LOSTFOUND_TODO_ALERT = "LF";
    public static final String LOSTFOUND_PAGE_N001AP = "N001AP";
    public static final String LOSTFOUND_TODO_EXCEP_ON_UPDATE = "LF_UPDATE_TODO_EXCEP";
    
    //Lost and Found Ack response
    public static final String LOSTFOUND_ACK_APPROVE = "LFA";
    public static final String LOSTFOUND_ACK_CANCEL  = "LFN";
    public static final String LOSTFOUND_ACK_REJECT  = "LFR";
    
    public static final String LOSTFOUND_ALERT_ADD_CODE_LR = "LR";
    public static final String LOSTFOUND_ADD_CODE_KYC      = "KYC";
    
    /******************************************** Batch Processing - alerts constants *******************************************************/
    public static final String BATCHPROCESSING_TODO_ALERT = "BP";
    public static final String BATCHPROCESSING_ALERT_ADD_CODE ="IB";
    public static final String BATCHPROCESSING_ALERT_ADD_CODE_TL ="IBTL";
    public static final String BATCH_PROCESSING_DESC ="batchProcessing_key";
    public static final String BATCH_PROCESSING_ALERT_REASON_CODE = "X";
    public static final String BATCH_PROCESSING_TODO_ALERT = "BP";
    //NABIL FEGHALI - #92506 - BISI120150 - Offline Alert - Batch Processing
    public static final String BATCHPROCESSING_MULTILEVEL_TODO_ALERT = "DO";
    
    /******************************************** ChequeBook Request - alerts constants *******************************************************/
    
    public static final String CHEQUEBOOK_ALERT_DESCRIPTION_PATTERN = "<Chequebook_Number_key>: {0},\n"+
    								      "<CIF_key>: {1},\n"+
    								      "<AC_No._key>: {2},\n"+
    								      "<number_of_chequebooks_key>: {3},\n"+
    								      "{4},\n"+
    								      "<ChequeBook_Type_key>: {5},\n"+
    								      "<Number_Of_Leaves_key>: {6}";
    public static final String CHEQUEBOOK_ALERT_SEQUENCE_PATTERN = "<From_Number_key>: {0} <To_Number_key>: {1}";
    
    public static final String CHEQUEBOOK_ALERT_REASON_CODE = "CHQ";
    public static final String CHEQUEBOOK_ALERT_REASON_CODE_BATCH = "CHQB";
    public static final String CHEQUEBOOK_ALERT_TYPE = "CHEQUEBOOK";
    public static final String CHEQUEBOOK_TODO_ALERT = "Q";
    public static final String CHEQUEBOOK_BULK_TODO_ALERT = "BQ"; //Rania - BMO180068
    public static final String CHEQUEBOOK_BATCH_APPROVE_TODO_ALERT = "QAB";
    
    //ChequeBook Request Ack response
    public static final String CHEQUEBOOK_ACK_REJECT  = "QR";
    public static final String CHEQUEBOOK_ACK_APPROVE = "QA";
    public static final String CHEQUEBOOK_ACK_DESTROY = "QD";
    public static final String CHEQUEBOOK_ACK_CANCEL  = "QC";
    public static final String CHEQUEBOOK_ACK_BRANCH  = "QB";
    public static final String CHEQUEBOOK_ACK_SUBMIT  = "QS";
    public static final String CHEQUEBOOK_ACK_REVERSE = "QV";
    public static final String CHEQUEBOOK_ACK_APPROVE_REV_CANCEL = "QAR";
    public static final String CHEQUEBOOK_ACK_REJECT_REV_CANCEL = "QRC";
    public static final String CHEQUEBOOK_ACK_APPROVE_BATCH_CANCEL = "QAB";
    public static final String CHEQUEBOOK_ACK_REJECT_BATCH_CANCEL = "QCB";
    public static final String CHEQUEBOOK_ACK_APPROVE_REVERSE_BATCH_CANCEL = "QAB";
    public static final String CHEQUEBOOK_ACK_REJECT_REVERSE_BATCH_CANCEL = "QCB";
    
    //ChequeBook Alert Status
    public static final String CANCEL_CHEQUEBOOK   = "Cancel_Chequebook_key";
    public static final String CANCEL_CHEQUEBOOKS  = "Cancel_Chequebooks_key";
    public static final String APPROVE_CHEQUEBOOK  = "Approve_Chequebook_key";
    public static final String DESTROY_CHEQUEBOOK  = "Destroy_Chequebook_key";
    public static final String SUBMIT_CHEQUEBOOK   = "Submit_Chequebook_key";
    public static final String REVERSE_CHEQUEBOOK  = "Reverse_Chequebook_key";
    public static final String REV_OF_CANCELLATION = "Rev_of_Cancellation_key";
    
    public static final String CHEQUEBOOK_ALERT_ADD_CODE_CH  = "CH";
    public static final String CHEQUEBOOK_ALERT_ADD_CODE_KYC = "KYC";
    
        
/******************************************** Transfer Cash Request - alerts constants *******************************************************/
    public static final String TRANSFER_CASH_ACK_APPROVE = "TFA";
    public static final String TRANSFER_CASH_ACK_REVERSE = "TCR";
    public static final String TRANSFER_CASH_ACK_REOPEN = "TCO";
    
    public static final String TRANSFER_CASH_ACK_REOPEN_REJECT  = "TOJ";
    public static final String TRANSFER_CASH_ACK_APPROVE_REJECT = "TFR";
    public static final String TRANSFER_CASH_ACK_REVERSE_REJECT = "TRJ";
    
    public static final String TRANSFER_CASH_TODO_ALERT_APPROVE = "TF";
    public static final String TRANSFER_CASH_TODO_ALERT_REVERSE = "B";
    public static final String TRANSFER_CASH_TODO_ALERT_REOPEN = "AO";
    //CDMI170094- Modification Option at Cash Transfer level -TP:533630
    public static final String TRANSFER_CASH_TODO_ALERT_MODIFY = "AM";
    //
    //CDMI170093-Transfert de fond vers un utilisateur specifique-TP: #536820
    public static final String TRANSFER_CASH_TODO_ALERT_TO_BE_TRANSFERRED = "TBT";
    public static final String TRANSFER_CASH_TODO_ALERT_TO_BE_REVERSED = "TBR";
    
    public static final String TRANSFER_CASH_PROG_REF_APPROVE = "AP";
    public static final String TRANSFER_CASH_PROG_REF_REVERSE = "RV";
    public static final String TRANSFER_CASH_PROG_REF_REOPEN = "O";
    
    public static final String ALERT_BREIF_DESC_SUFFIX = "_BREIF_DESC";
    
    public static final String TSFR_VAULT_TELLER_ALERT_DESCRIPTION_PATTERN = "<Cash_Transfer_key> <Trx_No_key>.: {0},\n"+
                                                                	         "<From_Vault_key>: {1},\n"+
                                                                	         "<To_Teller_key>: {2} .";
    public static final String TSFR_TELLER_CASH_BALANCE_ALERT_DESCRIPTION_PATTERN = "<Cash_Transfer_key> <Trx_No_key>.: {0},\n"+
                                                                                    "<From_Teller_key>: {1} .";
    public static final String TSFR_TELLER_VAULT_ALERT_DESCRIPTION_PATTERN = "<Cash_Transfer_key> <Trx_No_key>.: {0},\n"+
                                                                            "<From_Teller_key>: {1},\n"+
                                                                            "<To_Vault_key>: {2} .";
    public static final String TSFR_VAULT_VAULT_ALERT_DESCRIPTION_PATTERN = "<Cash_Transfer_key> <Trx_No_key>.: {0},\n"+
                                                                            "<From_Vault_key>: {1},\n"+
                                                                            "<To_Vault_key>: {2} .";
    public static final String TSFR_TELLER_TELLER_ALERT_DESCRIPTION_PATTERN = "<Cash_Transfer_key> <Trx_No_key>.: {0},\n"+
                                                                                "<From_Teller_key>: {1},\n"+
                                                                                "<To_Teller_key>: {2} .";
    public static final String TSFR_PARTIAL_TRANSFER_ALERT_DESCRIPTION_PATTERN = "<Cash_Transfer_key> <Trx_No_key>.: {0},\n"+
                                                                                    "<From_Teller_key>: {1},\n"+
                                                                                    "<To_Vault_key>: {2} .";
    public static final String TSFR_SEND_CASH_TO_CB_ALERT_DESCRIPTION_PATTERN = "<Cash_Transfer_key> <Trx_No_key>.: {0},\n"+
                                                                                "<From_Vault_key>: {1} .";
    public static final String TSFR_ECEIVE_CASH_FROM_CB_ALERT_DESCRIPTION_PATTERN = "<Cash_Transfer_key> <Trx_No_key>.: {0},\n"+
    											"<To_Vault_key>: {1} .";
                         
    public static final String TSFR_ALERT_TYPE = "TRS";
    public static final String TSFR_NO_APPROVAL_PRIVILEGE = "TCN";
    public static final String TSFR_CASH_FROM_VAULT_TO_TELLER = "TCVT";
    public static final String TSFR_CASH_FROM_TELLER_TO_VAULT = "TCTV";
    public static final String TSFR_CASH_FROM_VAULT_TO_VAULT = "TCVV";
    public static final String TSFR_CASH_FROM_TELLER_TO_TELLER = "TCTT";
    public static final String TSFR_PARTIAL_CASH_FROM_TELLER_TO_VAULT = "PCTV";
    public static final String TSFR_SEND_CASH_TO_CENTRAL_BANK = "SCB";
    public static final String TSFR_RECEIVE_CASH_FROM_CENTRAL_BANK = "RCB";
    public static final String TSFR_TELLER_CASH_BALANCE = "TCB";
    public static final String TSFR_TELLER_CASH_BALANCE_REOPEN = "TCBO";
    public static final String TSFR_REVERSAL_FROM_VAULT_TO_TELLER = "RVT";
    public static final String TSFR_REVERSAL_FROM_TELLER_TO_VAULT = "RTV";
    public static final String TSFR_REVERSAL_FROM_VAULT_TO_VAULT = "RVV";
    public static final String TSFR_REVERSAL_FROM_TELLER_TO_TELLER = "RTT";
    public static final String TSFR_REVERSAL_SEND_CASH_TO_CENTRAL_BANK = "RSCB";  	
    public static final String TSFR_REVERSAL_RECEIVE_CASH_FROM_CENTRAL_BANK = "RRCB";  
    public static final String TSFR_REVERSAL_PARTIAL_TELLER_TO_VAULT = "RPTV";

  
    
    /******************************************** Front Office Management - alerts constants *******************************************************/
    public static final String FOM_ALERT_DESCRIPTION_PATTERN = "<CIF_key>: {0},\n"+
                                                    	       "<Cif_Type_key>: {1},\n"+
                                                    	       "<Eco_Sector_key>: {2},\n"+
                                                    	       "<cust.priority>: {3},\n"+
                                                    	       "<Country_key>: {4},\n"+
                                                    	       "<Nationality_key>: {5}";
    
    public static final String FOM_TODO_PROG_REF = "F00I1P";
    public static final String FOM_SIGNATURE_PROG_REF = "SIGN002P";
    public static final String FOM_ALERT_REASON_CODE = "X";
    public static final String FOM_SIGN_REASON_CODE = "SIGN";
    public static final String FOM_TODO_ALERT = "F";
    public static final String FOM_TODO_REJECT_ACTIVE_ALERT = "MC";
    public static final String FOM_ACK_APPROVE_CIF = "FP";
    public static final String FOM_ACK_REJECT_CIF = "FR";
    public static final String FOM_ACK_SIGN_APPROVE = "FSA";
    public static final String FOM_ACK_SIGN_REJECT = "FSR";
    public static final String FOM_ACK_SIGN_APPROVE_CIF = "FP";
    public static final String FOM_ACK_SIGN_REJECT_CIF = "FR";
    public static final String FOM_ACK_SIGN_APPROVE_CIFSIGN = "SAA";
    public static final String FOM_ACK_SIGN_REJECT_CIFSIGN = "RAA";
    public static final String FOM_ACK_SIGN_APPCIF_REJSIGN = "ARS";
    public static final String FOM_ACK_SIGN_REJCIF_APPSIGN = "CAS";
	
    public static final String FOM_ALERT_TYPE = "FOM";
    public static final String FOM_TODO_EXCEP_ACTIVE = "Active_CIF_key";
    public static final String FOM_TODO_EXCEP_INACTIVE = "Inactive_CIF_key";
    public static final String FOM_ALERT_ADD_CODE_IR = "IR";
    public static final String FOM_ALERT_ADD_CODE_KYC = "KYC";
    
    public static final String FOM_ALERT_ADD_CODE_MINAGE = "BA";
    public static final String FOM_ALERT_ADD_CODE_TYPE = "ID";
    public static final String FOM_ALERT_ADD_CODE_AMENDCIF = "AI";
    public static final String FOM_ALERT_ADD_CODE_INACTIVE = "IC";
   
    public static final String FOM_ALERT_ADD_CODE_DUPLICATE_CIF_NAME = "CIFD"; //IDB170046
    
    public static final String FOM_TODO_EXCEP_NO_ACCESS_APP = "No_Access_Approve_CIF_key";
    public static final String FOM_TODO_EXCEP_AMEND_CIF = "Amendment_CIF_Information_key";
    public static final String FOM_TODO_EXCEP_ID_TYEP_DIFF_CIVIL = "ID_Type_different_CIVIL_ID_key";
    public static final String FOM_TODO_EXCEP_CIF_MIN_AGE = "CIF_Below_Minimun_Age_key";
    public static final String FOM_TODO_EXCEP_REGIST_USED = "Registration_Number_Already_Used_key";
    public static final String FOM_TODO_EXCEP_CIF_RESTRICTED = "cif_below_is_restricted_key";
    public static final String FOM_TODO_EXCEP_CIF_BLACK_LISTED = "CIF_Blacklisted_key";
    public static final String FOM_TODO_EXCEP_CIF_SUSPICIOUS = "CIF_Suspicious_key";
    public static final String FOM_TODO_EXCEP_KYC_OUTSTANDING = "ALERT_TRX_KYC_KEY_IS_OUTSTANDING";
    public static final String FOM_TODO_EXCEP_KYC_COMPLETED_BY_CALL = "ALERT_TRX_KYC_KEY_IS_COMPLETED_BY_CALL";
    public static final String FOM_TODO_EXCEP_KYC_RECALCITRANT = "ALERT_TRX_KYC_KEY_IS_RECALCITRANT";
    public static final String FOM_TODO_EXCEP_CHECK_ACC = "Account_No_key";
    public static final String FOM_TODO_EXCEP_CHECK_ACC_AUTHORIZE= "Needs_to_be_Authorized_key";
    public static final String FOM_TODO_EXCEP_IRIS_APPROVE= "IRIS_approval_key";
    public static final String FOM_DUPLICATE_CIF_NAME 	= "DUPLICATE_CIF_NAME"; //IDB170046
    
    public static final String FOM_CHECK_APPROVE 	= "checkApproveAccess";
    public static final String FOM_CHECK_MINAGE 	= "checkMinAge";
    public static final String FOM_CHECK_TYPE 		= "checkIdType";
    public static final String FOM_CHECK_REGISTRATION 	= "checkRegistrationNo";
    public static final String FOM_CHECK_BLACKLIST 	= "blackListChecked";
    public static final String FOM_CHECK_DUPLICATE_CIF_NAME 	= "cifNameDuplicateChecked";//IDB170046
    public static final String FOM_CHECK_AMENDMENT_OF_SCORE 	= "checkAmendmentOfScore";
    
    public static final String PROCEED_CIF_HAS_NON_ALLOWED_ACC ="<A_PROCEED_CIF_HAS_NON_ALLOWED_ACC_TODO_EXCEP>,";
    public static final String NON_ALLOWED_ACC_CIF_ADD_CODE_NID  = "NAAC";     
    
    
    /******************************************** Transacton Management - alerts constants *******************************************************/
    
    public static final String TRX_ALERT_DESCRIPTION_PATTERN = "<trs_no_key>: {0} , <trs_date_key>: {1}\n"+
                                                                	    "<Transaction_Type_key>: {2},\n"+
                                                                	    "<acc_no_key>: {3},\n"+
                                                                	    "<ac_name_key>: {4},\n"+
                                                                	    "<CIF_key>: {5},\n"+
                                                                	    "<trs_cy_key>: {6} , <Amount_key>: {7}";

    public static final String TRX_ALERT_DESCRIPTION_PATTERN_FOR_TRANSFER = ",\n"+
                                                                "<to_Account_key>: {0},\n"+
                                                                "<ac_name_key>: {1},\n"+
                                                                "<to_cif_key>: {2},\n";
    
    public static final String TRX_ALERT_REASON_CODE = "X";
    public static final String TRX_TODO_ALERT = "X";
    public static final String TRX_TODO_ALERT_TYPE = "TRX";
    
    //Alerts add code
    public static final String TRX_ADD_CODE_BC = "BC";
    public static final String TRX_ADD_CODE_BD = "BD";
    public static final String TRX_ADD_CODE_IB = "IB";
    public static final String TRX_ADD_CODE_LM = "LM";
    public static final String TRX_ADD_CODE_CC = "CC";
    public static final String TRX_ADD_CODE_SOD = "SOD";
    public static final String TRX_ADD_CODE_OD = "OD";
    public static final String TRX_ADD_CODE_LE = "LE";
    public static final String TRX_ADD_CODE_AL = "AL";
    public static final String TRX_ADD_CODE_MA = "MA";
    public static final String TRX_ADD_CODE_CS = "CS";
    public static final String TRX_ADD_CODE_CB = "CB";
    public static final String TRX_ADD_CODE_NS = "NS";
    public static final String TRX_ADD_CODE_RT = "RT";
    public static final String TRX_ADD_CODE_ML = "ML";
    public static final String TRX_ADD_CODE_AZ = "AZ";
    public static final String TRX_ADD_CODE_VD = "VD";
    public static final String TRX_ADD_CODE_PC = "PC";
    public static final String TRX_ADD_CODE_NR = "NR";
    public static final String TRX_ADD_CODE_NL = "NL";
    public static final String TRX_ADD_CODE_PB = "PB";
    public static final String TRX_ADD_CODE_BCB = "BCB";
    public static final String TRX_ADD_CODE_ICB = "ICB";
    public static final String TRX_ADD_CODE_KYCT = "KYCT";
    public static final String TRX_ADD_CODE_CN = "CN";
    public static final String TRX_ADD_CODE_CNN = "cnn";
    public static final String TRX_ADD_CODE_RV = "RV";
    public static final String TRX_ADD_CODE_AD = "AD";
    public static final String TRX_ADD_CODE_AT = "AT";
    public static final String TRX_ADD_CODE_CLC = "CLC";
    public static final String TRX_ADD_CODE_CLF = "CLF";
    public static final String TRX_ADD_CODE_CLT = "CLT";
    public static final String TRX_ADD_CODE_CLM = "CLM";
    public static final String TRX_ADD_CODE_CLP = "CLP";
    public static final String TRX_ADD_CODE_OIT = "OIT";//Abdo ABARSI160019 11/04/2017
    public static final String TRX_ADD_CODE_RLL = "release_reason";
    public static final String TRX_ADD_CODE_TS = "TS";
    public static final String TRX_ADD_CODE_TSS = "stop_reason";
    public static final String TRX_ADD_CODE_RL = "RL";
    public static final String TRX_ADD_CODE_TPA = "TPA";// falha 795320 Restrict Staff transactions on personal accounts


    //Abdo BURJ150069 11/08/2016
    public static final String TRX_ADD_CODE_EML = "EML";
    public static final String TRX_ADD_CODE_EBL = "EBL";
    //End Abdo

    
    //TONY NOUH User Story#315732 AMANA130105 Overdraft Products
    public static final String TRX_ADD_CODE_OO = "OO";
    public static final String TRX_ADD_CODE_OI = "IISOI"; //907464 - ABEI190642
    public static final String TRX_ADD_CODE_CW = "CW";
    public static final String TRX_ADD_CODE_CP = "CP";
    // END TONY NOUH User Story#315732 AMANA130105 Overdraft Products
   
    public static final String TRX_ADD_CODE_OBL = "OBL";
    
    
    
    
    //Alerts app excep
    public static final String TRX_EXCEP_APP_CODE_EX = "EX";
    public static final String TRX_EXCEP_APP_CODE_AT = "AT";
    public static final String TRX_EXCEP_APP_CODE_SO = "SO";
    public static final String TRX_EXCEP_APP_CODE_AS = "AS";
    public static final String TRX_EXCEP_APP_CODE_TS = "TS";
    public static final String TRX_EXCEP_APP_CODE_TCL = "TCL";
    public static final String TRX_EXCEP_APP_CODE_CL = "CL";
    
    //Alerts and/or trx
    public static final String TRX_AND = "A";
    public static final String TRX_OR = "O";
    
    //Alerts ack codes
    public static final String TRX_ACK_STOP = "TS";
    public static final String TRX_ACK_CANCEL = "TC";
    public static final String TRX_ACK_RETURN = "TRO";
    public static final String TRX_ACK_REVERSE = "TV";
    public static final String TRX_ACK_RELEASE = "TD";
    public static final String TRX_ACK_CLOSE_SO = "TCL";
    public static final String TRX_ACK_REACTIVATE_SO = "RS";
    public static final String TRX_ACK_CLEARING = "ARC";
    public static final String TRX_ACK_REACTIVATE_REMITTANCE = "REM";
    public static final String TRX_ACK_REJECT = "TR";
    public static final String TRX_ACK_REJECT_ACTIVE = "TM";
    public static final String TRX_ACK_VOID = "TO";
    public static final String TRX_ACK_APPROVE = "T";
    
    //Amf alert status for P_RET_ALERT_CTSTRS
    public static final String TRX_AMF_STATUS_AS = "AS";
    public static final String TRX_AMF_STATUS_RS = "RS";
    public static final String TRX_AMF_STATUS_S = "S";
    
    public static final String TRX_REJECT_STATUS_REASON = "REJ";

    //Trx title pattern
    public static final String TRX_TITLE_PATTERN = "X_{0}_TITLE";
    public static final String TRX_BRIEF_NAME_PATTERN = "X_{0}_BRIEF_NAME";
    public static final String TRX_MONEY_LAUNDRING_PROGREF = "D001@";
    /******************************************** Black List - alerts constants *******************************************************/
    
    public static final String BLACK_LIST_ALERT_TYPE = "BLACK";
    
    public static final String BLACK_LIST_PROG_REF_APPROVE = "P";
    public static final String BLACK_LIST_PROG_REF_UPDATE_AFTER_APPROVE = "UP";
    public static final String BLACK_LIST_PROG_REF_REVERSE = "V";
    
    public static final String BLACK_LIST_TODO_ALERT_APPROVE = "BLA";
    public static final String BLACK_LIST_TODO_ALERT_REVERSE = "RB";
    
    public static final String BLACK_LIST_ACK_APPROVE = "BL";
    public static final String BLACK_LIST_ACK_REVERSE = "RV";
    
    public static final String BLACK_LIST_ACK_APPROVE_REJECT  = "BR";
    public static final String BLACK_LIST_ACK_REVERSE_REJECT = "RRB";
    
    public static final String BLACK_LIST_ALERT_TODO_EXCEP = "_TODO_EXCEP";
    
    public static final String BLACK_LIST_TELLER_ALERT_DESCRIPTION_PATTERN = "<Code_key> : {0},\n"+
                                                                                "<brief_Name_key>: {1},\n"+
                                                                                "<Long_Name_key>: {2} ,\n"+
                                                                                "<Register_No_key>: {3} ,\n"+
                                                                                "<Cif_Type_key>: {4} .";
    /******************************************** PassBook - alerts constants *******************************************************/
    public static final String PASSBOOK_ALERT_DESCRIPTION_PATTERN = "<PassBook_Code_key>: {0},\n"+
	      								"<passbook_type_key>: {1},\n"+
	      								"<CIF_key>: {2},\n";
    public static final String PASSBOOK_ALERT_TYPE = "PAS";
    public static final String PASSBOOK_TODO_ALERT = "PA";
    public static final String PASSBOOK_ALERT_ADD_CODE_PA ="PA";
    public static final String PASSBOOK_PAGE_S000IP ="S000IP";
    
    public static final String PASSBOOK_ACK_APPROVE = "PI";
    public static final String PASSBOOK_TODO_EXCEP_ON_UPDATE ="PA_UPDATE_TODO_EXCEP";
    public static final String PASSBOOK_APPROVE_DESC = "Issuance_key";
    public static final String PASSBOOK_ALERT_REASON_CODE = "X";
    public static final String PASSBOOK_ACK_REJECT = "PJ";
    public static final String PASSBOOK_ACK_ACTIVE_REJECT = "PM";
    
    /******************************************** Safe Box - alerts constants *******************************************************/
    public static final String SAFE_BOX_ALERT_ADD_CODE = "SFB";
    
    public static final String SAFE_BOX_ADD_CODE_NP  = "NP";
    public static final String SAFE_BOX_ADD_CODE_OC  = "OC";
    public static final String SAFE_BOX_ADD_CODE_OL  = "OL";
    public static final String SAFE_BOX_ADD_CODE_OA  = "OA";
    public static final String SAFE_BOX_ADD_CODE_OB  = "OB";
    public static final String SAFE_BOX_ADD_CODE_OR  = "OR";
    public static final String SAFE_BOX_ADD_CODE_OE  = "OE";
    public static final String SAFE_BOX_ADD_CODE_KYC = "KYC";
    
    public static final String SAFE_BOX_ALERT_TYPE = "SAFEBOX";
    public static final String SAFE_BOX_TODO_ALERT = "S";
    
    public static final String SAFE_BOX_PROG_REF_APPROVE = "AP";
    public static final String SAFE_BOX_PROG_REF_CANCEL = "CN";
    public static final String SAFE_BOX_PROG_REF_CLOSE = "CL";
    public static final String SAFE_BOX_PROG_REF_ABANDON = "AB";
    public static final String SAFE_BOX_PROG_REF_BLOCK = "BL";
    public static final String SAFE_BOX_PROG_REF_RENEW = "RN";
    public static final String SAFE_BOX_PROG_REF_RELEASE = "RL";
    
    public static final String SAFE_BOX_ACK_REJECT  = "SR";
    public static final String SAFE_BOX_ACK_APPROVE = "SP";
    public static final String SAFE_BOX_ACK_AMMEND = "SPM";
    public static final String SAFE_BOX_ACK_CANCEL = "SC";
    public static final String SAFE_BOX_ACK_ABONDONED = "BB";
    public static final String SAFE_BOX_ACK_CLOSED = "BC";
    public static final String SAFE_BOX_ACK_BLOCKED = "BA";
    
    
    public static final String SAFE_BOX_ALERT_DESCRIPTION_PATTERN = "<Safebox_key> <Trx_No_key> : {0} \n"+
                                                                    "<CIF_key> : {1} \n"+
                                                                    "<AC_No._key> : {2} \n"+
                                                                    "<From_date_key> : {3} <To_Date_key> : {4} \n"+
                                                                    "<Safebox_Type_key> : {5} \n"+
                                                                    "<Safebox_Location_key> : {6} ";
    
    //[EliasAoun - IIAB110476 - Internal Mailbox]
    public static final String MAIL_BOX_ACK_REJECT  = "MSR";
    public static final String MAIL_BOX_ACK_APPROVE = "MSP";
    public static final String MAIL_BOX_ACK_AMMEND = "MSPM";
    public static final String MAIL_BOX_ACK_CANCEL = "MSC";
    public static final String MAIL_BOX_ACK_ABONDONED = "MBB";
    public static final String MAIL_BOX_ACK_CLOSED = "MBC";
    public static final String MAIL_BOX_ACK_BLOCKED = "MBA";
    
    public static final String MAIL_BOX_ALERT_TYPE = "MAILBOX";
    public static final String MAIL_BOX_TODO_ALERT = "M";
    
    public static final String MAIL_BOX_ALERT_DESCRIPTION_PATTERN = "<Mailbox_key> <Trx_No_key> : {0} \n"+
                                                                    "<CIF_key> : {1} \n"+
                                                                    "<AC_No._key> : {2} \n"+
                                                                    "<From_date_key> : {3} <To_Date_key> : {4} \n"+
                                                                    "<mailbox_type_key> : {5} \n"+
                                                                    "<mailbox_location_key> : {6} ";
    /******************************************** LinksManagement - alerts constants *******************************************************/
    public static final String LINKSMANAGEMENT_ALERT_DESCRIPTION_PATTERN = "<link_serial_key>: {0},{1}\n"+
	      								"<Link_key>: {2},\n";
    public static final String LINKSMANAGEMENT_ALERT_TYPE = "LMG";
    public static final String LINKSMANAGEMENT_TODO_ALERT = "LM";
    public static final String LINKSMANAGEMENT_ALERT_ADD_CODE_GI ="GI";
    public static final String LINKSMANAGEMENT_ALERT_ADD_CODE_GP ="GP";
    public static final String LINKSMANAGEMENT_REASON_CODE = "X";
    public static final String LINKSMANAGEMENT_TODO_EXCEP_ON_UPDATE ="LM_UPDATE_TODO_EXCEP";
    public static final String LINKSMANAGEMENT_TODO_EXCEP_ON_CREATE ="LM_CREATE_TODO_EXCEP";
    public static final String LINKSMANAGEMENT_TODO_EXCEP_ON_NO_APPROVAL ="LM_NO_APPROVAL_TODO_EXCEP";
    public static final String LINKSMANAGEMENT_PAGE_LM01AP ="LM01AP";
    public static final String LINKSMANAGEMENT_ACK_APPROVE = "LMA";
    public static final String LINKSMANAGEMENT_ACK_SUSPEND  = "LMS";
    public static final String LINKSMANAGEMENT_ACK_CANCEL  = "LMN";
    public static final String LINKSMANAGEMENT_ACK_REACTIVATE  = "LMR";
    public static final String LINKSMANAGEMENT_ACK_REJECT  = "LMJ";
    
    /******************************************** Memo Detail - alerts constants *******************************************************/
    public static final String MEMO_ALERT_DESCRIPTION_PATTERN = "<Memo_Type_key>: {0}\n"+
	      								"<Comments_key>: {1},\n"+
	      								"<to_cif_key>: {2},\n";
    public static final String MEMO_ALERT_TYPE = "MEM";
    public static final String MEMO_TODO_ALERT ="MEM";
    public static final String MEMO_ALERT_ADD_CODE_MI ="MI";
    public static final String MEMO_REASON_CODE = "X";
    public static final String MEMO_TODO_EXCEP_ON_UPDATE ="MEM_UPDATE_TODO_EXCEP";
    public static final String MEMO_TODO_EXCEP_ON_CREATE ="MEM_CREATE_TODO_EXCEP";
    public static final String MEMO_PAGE_M001P ="M001P";
    public static final String MEMO_ACK_APPROVE = "MA";
    public static final String MEMO_ACK_SUSPEND  = "MS";
    public static final String MEMO_ACK_CANCEL  = "MN";
    public static final String MEMO_ACK_REACTIVATE  = "MR";
    public static final String MEMO_ACK_REJECT  = "MJ";
    public static final String MEMO_ADD_CODE_KYC = "KYC";
    
    
    
    /******************************************** Currency Exchange- alerts constants *******************************************************/
    public static final String CY_EXCH_ALERT_TYPE = "CYEX";
    public static final String CY_EXCH_TODO_ALERT = "EXC";
    public static final String CY_EXCH_TODO_ALERT_TYPE = "EXC";
    public static final String CY_EXCH_TODO_REASON_CODE = "EXC";
    public static final String CY_EXCH_ACK_APPROVE = "EXA";
    public static final String CY_EXCH_ACK_REJECT = "EXR";
    public static final String CY_EXCH_ACK_MODIFY = "EXM";
    public static final String CY_EXCH_ALERT_DESCRIPTION_PATTERN = "<currency_exchange_alert_title_key>  : {0},\n"+
									"<cash_in>: {1}  <in_key> {2} <cash_out>: {3} <in_key> \n"+
									" {4} < {5} >";
    
    /******************************************** General and Fixed Account - alerts constants *******************************************************/
    
    public static final String ACCOUNT_ALERT_DESCRIPTION_PATTERN = "<Account_No_key>: {0} ({1})\n"+
    								   "<Account_Name_key>: {2},\n"+
    								   "<Account_Branch_key>: {3},\n"+
    								   "<Currency_key>: {4},\n"+
    								   "<type_key>: {5},\n"+
    								   "<account_cif_key>: {6},\n"+
    								   "<SL_key>: {7}";
    								   
    public static final String ACCOUNT_ALERT_TYPE  = "ACC";
    public static final String ACCOUNT_TODO_ALERT  = "A";
    public static final String ACCOUNT_REASON_CODE = "X";
    public static final String ACCOUNT_CLOSE_WITH_TRSFR_REASON_CODE = "CLT";
    public static final String ACCOUNT_SIGN_REASON_CODE = "SIGN";
    
    public static final String ACCOUNT_GEN_PAGE_REF_A002MT  = "A002MT";
    public static final String ACCOUNT_GEN_PAGE_REF_A002MA  = "A002MA";
    public static final String ACCOUNT_GEN_PAGE_REF_A002P = "A002P";
    public static final String ACCOUNT_GEN_PAGE_REF_A002L  = "A002L";
    public static final String ACCOUNT_GEN_PAGE_REF_A002S  = "A002S";
    public static final String ACCOUNT_GEN_PAGE_REF_A002A  = "A002A";
    public static final String ACCOUNT_GEN_PAGE_REF_A002J  = "A002J";
    public static final String ACCOUNT_GEN_PAGE_REF_A002AC = "A002AC";
    public static final String ACCOUNT_GEN_PAGE_REF_A002AU =  "A002AU";
    public static final String ACCOUNT_GEN_PAGE_REF_A002CL =  "A002CL";
    public static final String ACCOUNT_GEN_PAGE_REF_A002CLT=  "A002CLT";
    public static final String ACCOUNT_GEN_PAGE_REF_A002RJ =  "A002RJ";
    public static final String ACCOUNT_GEN_PAGE_REF_A002RE =  "A002RE";
    public static final String ACCOUNT_GEN_PAGE_REF_A002SP =  "A002SP";
    public static final String ACCOUNT_GEN_PAGE_REF_A002ACT=  "A002ACT";
    public static final String ACCOUNT_GEN_PAGE_REF_A002YP =  "A002YP";
    public static final String ACCOUNT_GEN_PAGE_REF_A002YR =  "A002YR";
    public static final String ACCOUNT_GEN_PAGE_REF_A002XJ =  "A002XJ";
    public static final String ACCOUNT_GEN_PAGE_REF_A002ZP =  "A002ZP";
    
    public static final String ACCOUNT_FIX_PAGE_REF_A001P = "A001P";
    public static final String ACCOUNT_FIX_PAGE_REF_A001MT  = "A001MT";
    public static final String ACCOUNT_FIX_PAGE_REF_A001MA  = "A001MA";
    public static final String ACCOUNT_FIX_PAGE_REF_A001L  = "A001L";
    public static final String ACCOUNT_FIX_PAGE_REF_A001S  = "A001S";
    public static final String ACCOUNT_FIX_PAGE_REF_A001SP = "A001SP";
    public static final String ACCOUNT_FIX_PAGE_REF_A001A  = "A001A";
    public static final String ACCOUNT_FIX_PAGE_REF_A001RE = "A001RE";
    public static final String ACCOUNT_FIX_PAGE_REF_A001J  = "A001J";
    public static final String ACCOUNT_FIX_PAGE_REF_A001RJ = "A001RJ";
    public static final String ACCOUNT_FIX_PAGE_REF_A001AC = "A001AC";
    public static final String ACCOUNT_FIX_PAGE_REF_A001AU =  "A001AU";
    public static final String ACCOUNT_FIX_PAGE_REF_A001CL =  "A001CL";
    public static final String ACCOUNT_FIX_PAGE_REF_A001YP =  "A001YP";
    public static final String ACCOUNT_FIX_PAGE_REF_A001XJ =  "A001XJ";
    public static final String ACCOUNT_FIX_PAGE_REF_A001ZP =  "A001ZP";

    public static final String ACCOUNT_INTERNAL_PAGE_REF_B001MT  = "B001MT";
    public static final String ACCOUNT_INTERNAL_PAGE_REF_B001SP  = "B001SP";
    public static final String ACCOUNT_INTERNAL_PAGE_REF_B001AP  = "B001AP";
    public static final String ACCOUNT_INTERNAL_PAGE_REF_B001ZP  = "B001ZP";
    
    public static final String ACCOUNT_FIX_ALERT_TYPE = "FMA";
    public static final String ACCOUNT_GEN_ALERT_TYPE = "GAC";
    
    public static final String ACCOUNT_ALERT_ADD_CODE_AT ="AT";
    public static final String ACCOUNT_ALERT_ADD_CODE_AA ="AA";
    public static final String ACCOUNT_ALERT_ADD_CODE_BL ="BL";
    public static final String ACCOUNT_ALERT_ADD_CODE_BA ="BA";
    public static final String ACCOUNT_ALERT_ADD_CODE_AB ="AB";
    public static final String ACCOUNT_ALERT_ADD_CODE_NP ="NP";
    public static final String ACCOUNT_ALERT_ADD_CODE_OS ="OS";
    public static final String ACCOUNT_ALERT_ADD_CODE_CC ="CC";
    public static final String ACCOUNT_ALERT_ADD_CODE_CAD ="CAD";
    public static final String ACCOUNT_ALERT_ADD_CODE_KYC ="KYC";
    public static final String ACCOUNT_ALERT_ADD_CODE_AAPD ="AAPD"; //Rania - DB170108 - Advance profit payment
    
    public static final String ACCOUNT_ACK_AUTHORISE 	= "AP";
    public static final String ACCOUNT_ACK_SUSPEND 	= "AS";
    public static final String ACCOUNT_ACK_REACTIVATE  	= "AT";
    public static final String ACCOUNT_ACK_REJECT  	= "AJ";
    public static final String ACCOUNT_ACK_AUTHORISECLOSE      = "AC";
    public static final String ACCOUNT_ACK_AUTHORISECLOSE_AR   = "AR";
    public static final String ACCOUNT_ACK_ACTIVE_REJECT       = "MSM";
    public static final String ACCOUNT_ACK_SIGN_APPROVE 	= "ASG";
    public static final String ACCOUNT_ACK_SIGN_REJECT 		= "RSG";
    public static final String ACCOUNT_ACK_SIGN_APPROVE_ACC 	= "AP";
    public static final String ACCOUNT_ACK_SIGN_REJECT_ACC 	= "AR";
    public static final String ACCOUNT_ACK_SIGN_APPROVE_ACCSIGN = "MAS";
    public static final String ACCOUNT_ACK_SIGN_REJECT_ACCSIGN 	= "MSC";
    public static final String ACCOUNT_ACK_SIGN_APPROVE_ACC_REJECT_SIGN = "RAS";
    public static final String ACCOUNT_ACK_SIGN_REJECT_ACC_APPROVE_SIGN = "SAR";

    
    public static final String ACCOUNT_AMF_STATUS_AS       = "AS";
    public static final String ACCOUNT_AMF_STATUS_RS       = "RS";
    public static final String ACCOUNT_AMF_STATUS_S	 = "S";
    
    
    public static final String ACCOUNT_SIGNATURE_PROG_REF = "SIGN002P";
    
    // added by nancy- 30/10/2017-574009-SBI170024 - account wise slabs required, Rack rate change in the product with date range for profit
    public static final String ACC_FMA_CHANGED_EXCP_RATES 	= "EF";
    public static final String ACC_GEN_CHANGED_EXCP_RATES 	= "EG";
    // end nancy
    
    
    public static final String ACCOUNT_TODO_EXCEP_AUTHORIZATION	 = "<A_AUTHORIZATION_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_AMENDMENT	 = "<A_AMENDMENT_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_CIF_RESTRICTED	 = "<ACCOUNT_IS_RESTRICTED>,";
    public static final String ACCOUNT_TODO_EXCEP_CIF_MINAGE	 ="<A_CIF_MINAGE_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_CIF_BLACKLISTED	 	="<A_CIF_BLACKLISTED_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_APPROVAL	 		="<A_APPROVAL_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_CHANGE_CREDIT_RATE	 	="<A_CHANGE_CREDIT_RATE_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_SPECIAL_RATE_CHANGE_PT_RATE	="<A_SPECIAL_RATE_CHANGE_PT_RATE_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_SPECIAL_RATE	 		="<A_SPECIAL_RATE_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_CHANGE_PT_RATE	 	="<A_CHANGE_PT_RATE_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_ACCOUNTS_DORMANT	 	="<A_ACCOUNTS_DORMANT_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_BALANCE	 	="<A_BALANCE_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_OPENING_DATE	 	="<A_OPENING_DATE_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_CIF_SUSPICIOUS	 	="<A_CIF_SUSPICIOUS_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_CIF_KYC_OUTSTANDINIG	 ="<A_CIF_KYC_OUTSTANDINIG_TODO_EXCEP>";
    public static final String ACCOUNT_TODO_EXCEP_CIF_KYC_COMPLETED_BY_CALL	 ="<A_CIF_KYC_COMPLETED_BY_CALL_TODO_EXCEP>";
    public static final String ACCOUNT_TODO_EXCEP_CIF_KYC_RECALCITRANT	 ="<A_CIF_KYC_RECALCITRANT_TODO_EXCEP>";
    
    public static final String ACCOUNT_TODO_EXCEP_REACTIVATE_DORMANT	 	="<A_REACTIVATE_DORMANT_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_SUSPENDED_ACCOUNT	 	="<A_SUSPENDED_ACCOUNT_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_OFFENDED_ACCOUNT	 	="<A_OFFENDED_ACCOUNT_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_CLOSED_ACCOUNT	 	="<A_CLOSED_ACCOUNT_TODO_EXCEP>,";
    
    // added by nancy- 30/10/2017-574009-SBI170024 - account wise slabs required, Rack rate change in the product with date range for profit
    public static final String ACC_FMA_TODO_EXCEP_CHD_EXP_RT 	="<ACC_FMA_TODO_EXCEP_CHD_EXP_RT>,";
    public static final String ACC_GEN_TODO_EXCEP_CHD_EXP_RT 	="<ACC_GEN_TODO_EXCEP_CHD_EXP_RT>,";
    // end nancy 
    public static final String ACCOUNT_TODO_EXCEP_ADVANCE_PROFIT ="<ACC_FMA_ADVANCE_PROFIT_TODO_EXCEP>,"; //Rania - DB170108 - Advance profit payment
    
    //Rania - IDB200048 - Exceed user limitation
    public static final String ACCOUNT_TODO_EXCEP_OPEN_DEP_COD_TRX_APPROVAL = "<A_OPEN_DEP_COD_TRX_APPROVAL_TODO_EXCEP>,";
    public static final String ACCOUNT_TODO_EXCEP_ACC_CLOSE_TRX_APPROVAL  = "<A_ACC_CLOSE_TRX_APPROVAL_TODO_EXCEP>,";
    //
    
    /******************************************** CardssManagement - alerts constants *******************************************************/
    public static final String CARDSSMANAGEMENT_ALERT_DESCRIPTION_PATTERN = "<Application_Id_key>: {0},\n"+
	      								"<Card_Number_key>: {1},\n"+
	      								"<Card_Type_key>: {2} ({3}) {4}\n"+
	      								"<CIF_key>: {5} {6}\n";
    public static final String CARDSSMANAGEMENT_ALERT_TYPE = "CARDS";
    public static final String CARDSSMANAGEMENT_TODO_ALERT = "CD";
    public static final String CARDSSMANAGEMENT_ALERT_ADD_CODE_AI ="AI";
    public static final String CARDSSMANAGEMENT_ALERT_ADD_CODE_GP ="GP";
    public static final String CARDSSMANAGEMENT_ALERT_ADD_CODE_KYC ="KYC";
    public static final String CARDSMGNT_ALERT_REASON_CODE = "X";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_AC ="CD_AC_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_NP ="CD_NP_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_AI ="CD_AI_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_UC ="CD_UC_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_AP ="CD_AP_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_CI ="CD_CI_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_CA ="CD_CA_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_CP ="CD_CP_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_CC ="CD_CC_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_CM ="CD_CM_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_CD ="CD_CD_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_CB ="CD_CB_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_CH ="CD_CH_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_CR ="CD_CR_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_CU ="CD_CU_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_CY ="CD_CY_TITLE";
    public static final String CARDSSMANAGEMENT_TODO_EXCEP_NID ="CD_NID_TITLE";
    public static final String CARDSSMANAGEMENT_PAGE_G001P ="G001P";
    public static final String CARDSSMANAGEMENT_ACK_APPROVE = "CRP";
    public static final String CARDSSMANAGEMENT_ACK_RENEW = "CRN";
    public static final String CARDSSMANAGEMENT_ACK_REACTIVATE  = "CRV";
    public static final String CARDSSMANAGEMENT_ACK_ISSUE  = "CRI";
    public static final String CARDSSMANAGEMENT_ACK_ACTIVATE  = "CRT";
    public static final String CARDSSMANAGEMENT_ACK_BLOCK  = "CRK";
    public static final String CARDSSMANAGEMENT_ACK_MONITORING  = "CRM";
    public static final String CARDSSMANAGEMENT_ACK_DEACTIVATE  = "CRD";
    public static final String CARDSSMANAGEMENT_ACK_HOT  = "CRH";
    public static final String CARDSSMANAGEMENT_ACK_REPLACE  = "CRE";
    public static final String CARDSSMANAGEMENT_ACK_CANCEL  = "CRC";
    public static final String CARDSSMANAGEMENT_ACK_UNBLOCK  = "CRU";
    public static final String CARDSSMANAGEMENT_ACK_DESTROY  = "CRY";
    public static final String CARDSSMANAGEMENT_ACK_APPLY  = "CRA";
    public static final String CARDSSMANAGEMENT_ACK_AMEND  = "CRX";   
    public static final String CARDSSMANAGEMENT_ACK_REJECT  = "CRJ";
    
    public static final String CARDSSMANAGEMENT_PROG_REF_P = "P";
    public static final String CARDSSMANAGEMENT_PROG_REF_AP = "AP";
    public static final String CARDSSMANAGEMENT_PROG_REF_R ="R";
    public static final String ALERT_CARD_STATUS ="RS";
    
    /******************************************** MultiChequeEntry - alerts constants *******************************************************/
    public static final String MULTICHQ_SEND_ALERT_CALLBACK	  ="mutiChqEntry_sendAlertCallback";
    public static final String BULKREMITTANCE_SEND_ALERT_CALLBACK ="bulkRemittance_sendAlertCallback";
    
    /******************************************** Signature - alerts constants *******************************************************/
    
    public static final String SIGNATURE_APPROVE_KEY 	= "<SIGNATURE_APPROVE>,";
    public static final String SIGNATURE_RENAME_KEY 	= "<SIGNATURE_RENAME>,";
    public static final String SIGNATURE_AMOUNT_KEY 	= "<SIGNATURE_AMOUNT>,";
    public static final String SIGNATURE_DELETE_KEY 	= "<SIGNATURE_DELETE>,";
    public static final String SIGNATURE_MODIFY_SCHEMA_KEY 	= "<SIGNATURE_MODIFY_SCHEMA>,";
    public static final String SIGNATURE_CIF_DORMANT_KEY 	= "<SIGNATURE_CIF_DORMANT>,";
    public static final String SIGNATURE_COPY_KEY 		= "<SIGNATURE_COPY,>";
    
    
    
    /******************************************** PassBook Stock - alerts constants *******************************************************/
	    
	    /********************************************  Destroy - alerts constants *******************************************************/
	    public static final String PASSBOOK_DESTROY_KEY 					 = "Passbook_destroy_key";
		public static final String PASSBOOKDESTROY_ALERT_DESCRIPTION_PATTERN = "\n<Passbook_Destroy_Trx_No_key>:{0}, \n<Branch_key>:{1}";
		public static final String PASSBOOK_DESTROY_APPROVED 				 = "PDA";
		
	    // ProgRef
	    public static final String PASSBOOK_DESTROY_PROGREF	= "DEST0";
		
		//PassBook Destroy IV_CRUD
	    public static final String PASSBOOKDESTROY_ALERT_IV_CRUD_D = "D";
	    
	    
	    public static final String PASSBOOK_DESTROY_ACK_ACTIVE_REJECT = "PDM";
	    /***************************************************************************************************************************************/
	
	    /********************************************  Request - alerts constants *******************************************************/
	    public static final String TODO_ALERT_TYPE_PBI   		 = "PBI";	
	    public static final String TODO_ALERT_TYPE_PB    		 = "PB";
	    public static final String PASSBKRQST_ALERT_TYPE 		 = "PBKREQ";
	    public static final String PASSBOOK_REQUEST_APPROVAL 	 = "Passbook_Request_Approval_key";
	    public static final String PASSBOOK_REQUEST_CANCELLATION 	 = "Passbook_Request_Cancellation_key";
	    public static final String PASSBOOK_REQUEST_FROM_PROVIDER_APPROVAL = "Passbook_Request_From_Provider_Approval_key";
	    public static final String PASSBOOK_REQUEST_FROM_PROVIDER_CANCELLATION = "Passbook_Request_From_Provider_Cancellation_key";
	    public static final String PASSBOOK_RECEIVED_FROM_PROVIDER_APPROVAL = "Passbook_Received_From_Provider_Approval_key";
	    public static final String PASSBOOK_RECEIVED_FROM_PROVIDER_CANCELLATION = "Passbook_Received_From_Provider_Cancellation_key";
	    public static final String PASSBOOK_APPROVAL_RECEIVED = "Passbook_Approval_Received_key";
	    public static final String PASSBOOK_CANCELLATION_RECEIVED = "Passbook_Cancellation_Received_key";
	    public static final String PASSBOOK_APPROVAL_REQUESTED = "Passbook_Approval_Requested_key";
	    public static final String PASSBOOK_CANCELLATION_REQUESTED = "Passbook_Cancellation_Requested_key";
	    public static final String PASSBOOK_APPROVAL_SENT = "Passbook_Approval_Sent_key";
	    public static final String PASSBOOK_CANCELLATION_SENT = "Passbook_Cancellation_Sent_key";
	
	    public static final String PASSBK_SENT_TO_PROVIDER 		 = "Passbook_Sent_to_Provider_key";
	    public static final String PASSBK_RECEIVED_FROM_PROVIDER = "Passbook_Recieved_from_Provider_key";
	    public static final String PASSBK_RQST_FROM_BR 			 = "Passbook_Request_from_Branch_key";
	    public static final String PASSBK_SENT_TO_BR			 = "Passbook_Sent_to_Branch_key";
	    public static final String PASSBK_RECIEVED_BY_BR		 = "Passbook_Recieved_By_Branch_key";
	
	    public static final String PASSBK_REQUEST_ALERT_DESCRIPTION_PATTERN = "\n<Passbook_Request_Trx_No_key>:{0}, \n<BATCH_NAME_key>:{1}, \n<Branch_key>:{2}";
	
	    // PassBook Stock Request IV_CRUD
	    public static final String PASSBK_ALERT_IV_CRUD_P = "P";
	    public static final String PASSBK_ALERT_IV_CRUD_N = "N";
	    public static final String PASSBK_ALERT_IV_CRUD_R = "R";
	    
	    //ACK WHEN MODIFYING
	    public static final String PASSBOOK_REQUEST_ACK_MODIFY		   = "M";
	    public static final String PASSBOOK_REQUEST_DYNAMIC_ACK_REJECT = "J";
	    public static final String PASSBOOK_REQUEST_ACK_REJECT		   = "RFJ";
	    /***************************************************************************************************************************************/
	    
    /***************************************************************************************************************************************/
    
    
    /******************************************** Certificate - alerts constants *******************************************************/

    public static final String CERTIFICATE_ALERT_REASON_CODE = "CER";
    public static final String CERTIFICATE_ALERT_ADD_CODE_EI = "EI";
    public static final String CERTIFICATE_ALERT_ADD_CODE_EC = "EC";
    public static final String CERTIFICATE_ALERT_ADD_CODE_EP = "EP";
    public static final String CERTIFICATE_ALERT_ADD_CODE_KYC = "KYC";
    public static final String CERTIFICATE_ALERT_ADD_CODE_EL = "EL";
    public static final String CERTIFICATE_TODO_EXCEP_ON_UPDATE = "cer_update_todo_excep"; //maureen for bug 682715
    public static final String CERTIFICATE_TODO_EXCEP_ON_CANCEL = "CER_CANCEL_TODO_EXCEP";
    public static final String CERTIFICATE_TODO_EXCEP_ON_CREATE = "cer_create_todo_excep"; //maureen for bug 682715
    public static final String CERTIFICATE_TODO_ALERT = "CER";
    public static final String CERTIFICATE_ALERT_DESCRIPTION_PATTERN = "<Code__key>: {0}\n"+
	            "<CIF_No_key>: {1},\n"+
		    "<Certificate_type_Key>: {2},\n"+
		    "<Balance_date_key>: {3}";
    
    public static final String CERTIFICATE_APPROVE_DESC = "Approve_key";
    public static final String CERTIFICATE_CANCEL_DESC = "Cancel_key";   
    public static final String CERTIFICATE_ACK_APPROVE = "CEP";
    public static final String CERTIFICATE_ACK_REJECT = "CEJ";
    public static final String CERTIFICATE_ACK_CANCEL = "CEC";
    public static final String CERTIFICATE_PAGE_P0049P = "P0049P";
    public static final String CERTIFICATE_PAGE_P0049CP = "P0049CP";
    public static final String CERTIFICATE_ALERT_IV_CRUD_P = "P";
    public static final String CERTIFICATE_ALERT_IV_CRUD_CP = "CP";
    
       
    /** Special Conditions (SPCONDS)**/
    public static final String SPCONDS_ALERT_TYPE = "SPC";
    public static final String SPCONDS_SCC = "SCC";
    public static final String SPCONDS_SCD = "SCD";
    public static final String SPCONDS_SCR = "SCR";
    public static final String SPCONDS_SCP = "SCP"; //approval privilege // BB110153 - Special Condition
    public static final String SPCONDS_ALERT_DESC_PATTERN = "<Special_Conditions_No_key>: {0} \n{1} {2} {3} \n<Reason_key>: {4}";
    public static final String SPCONDS_EXCEP_NEW_REASON = "<SPC_NEW_REASON>";
    public static final String SPCONDS_EXCEP_DEL_REASON = "<SPC_DEL_REASON>";
    public static final String SPCONDS_EXCEP_AMEND_REASON = "<SPC_AMEND_REASON>";  

    
    /** Dues Management **/
    public static final String DUES_ALERT_TYPE = "DUES";
    public static final String DUES_TODO_ALERT = "DUE";
    public static final String DUES_REASON_CODE = "DUE";
    public static final String DUES_DUEN = "DUEN";
    public static final String DUES_DUEA = "DUEA";
    public static final String DUES_DUEC = "DUEC";
    public static final String DUES_DUER = "DUER";
    public static final String DUES_APPROVAL_REASON = "<DUES_APPROVAL_REASON>"; 
    public static final String DUES_ALERT_DESC_PATTERN = "<Dues_Management_No_key>: <CIF_key>: {0} {1} \n<acc_no_key>: {2} {3}\n";
    
 /******************************************** Merchant Management - alerts constants *******************************************************/
    
    public static final String MERCHANTMGNT_ALERT_TYPE = "MERCHANT";
    
    public static final String MERCHANTMGNT_PROG_REF_APPROVE = "P";
    public static final String MERCHANTMGNT_PROG_REF_UPDATE_AFTER_APPROVE = "UP"; 
    
    public static final String MERCHANTMGNT_ALERT_ADD_CODE_RI = "MER";
    
    //used for upon sending alert
    public static final String MERCHANTMGNT_ALERT_DESCRIPTION_PATTERN = "<Merchant_Mgnt_Code_Key>:{0}, " + "\n<cif_key>:{1}, " + "\n<AC_No._key>:{2}";
    public static final String MERCHANTMGNT_PAGE_P = "MER00P";
    public static final String MERCHANTMGNT_PAGE_N = "MER00N";
    
    //used upon showing alert
    public static final String MERCHANTMGNT_ALERT_DESCRIPTION_APPROVE_PATTERN = "<Merchant_Mgnt_Approve_Key>" ;
    public static final String MERCHANTMGNT_ALERT_DESCRIPTION_CANCEL_PATTERN = "<Merchant_Mgnt_Cancel_Key>" ;
    
    public static final String MERCHANTMGNT_TODO_ALERT = "MER";

    public static final String MERCHANTMGNT_ALERT_REASON_CODE = "MER";
    public static final String MERCHANTMGNT_APPROVE_DESC = "Approve_key";
    
    //crud
    public static final String  MERCHANTMGNT_ALERT_IV_CRUD_P = "P";
    public static final String  MERCHANTMGNT_ALERT_IV_CRUD_N = "N";
    
    //Remittance Ack response
    public static final String MERCHANTMGNT_ACK_APPROVE = "MEA";
    public static final String MERCHANTMGNT_ACK_CANCEL  = "MEN";
    public static final String MERCHANTMGNT_ACK_REJECT  = "MEJ";
    /******************************************** Merchant Pos Management - alerts constants *******************************************************/
    public static final String MERCHANTPOSMGNT_ALERT_TYPE = "MERCHANT_POS";
    
    public static final String MERCHANTPOSMGNT_PROG_REF_APPROVE = "P";
    public static final String MERCHANTPOSMGNT_PROG_REF_UPDATE_AFTER_APPROVE = "UP"; 
    
    public static final String MERCHANTPOSMGNT_ALERT_ADD_CODE_RI = "POS";
    
    //used for upon sending alert
    public static final String MERCHANTPOSMGNT_ALERT_DESCRIPTION_PATTERN = "<pos_code_Key>: {0} {1}, \n" +
 									"<Merchant_Code_key>:  {2}, \n"+
 							                "<cif_key>: {3} {4}";

    public static final String MERCHANTPOSMGNT_PAGE_P = "POS00P";
    public static final String MERCHANTPOSMGNT_PAGE_N = "POS00N";
    
    //used upon showing alert
    public static final String MERCHANTPOSMGNT_ALERT_DESCRIPTION_APPROVE_PATTERN = "<Merchant_Pos_Mgnt_Approve_Key>" ;
    public static final String MERCHANTPOSMGNT_ALERT_DESCRIPTION_CANCEL_PATTERN = "<Merchant_Pos_Mgnt_Cancel_Key>" ;
    
    public static final String MERCHANTPOSMGNT_TODO_ALERT = "POS";

    public static final String MERCHANTPOSMGNT_ALERT_REASON_CODE = "POS";
    public static final String MERCHANTPOSMGNT_APPROVE_DESC = "approve_key";
    
    //crud
    public static final String  MERCHANTPOSMGNT_ALERT_IV_CRUD_P = "P";
    public static final String  MERCHANTPOSMGNT_ALERT_IV_CRUD_N = "N";
    
    //Remittance Ack response
    public static final String MERCHANTPOSMGNT_ACK_APPROVE = "POA";
    public static final String MERCHANTPOSMGNT_ACK_CANCEL  = "PON";
    public static final String MERCHANTPOSMGNT_ACK_REJECT  = "POJ";
    
/******************************************** Denomination Management - alerts constants *******************************************************/
    
    public static final String DENOMINATION_ALERT_REASON_CODE = "DEN";
    public static final String DENOMINATION_TODO_ALERT = "DEN";
    public static final String DENOMINATION_ALERT_ADD_CODE_DC = "DC";
    public static final String DENOMINATION_ALERT_ADD_CODE_DI = "DI";
    public static final String DENOMINATION_ALERT_ADD_CODE_DP = "DP";
    
    public static final String DENOM_AMEND_TELLER = "<DENOM_AMEND_TELLER>";
    public static final String DENOM_AMEND_INFORMATION = "<DENOM_AMEND_INFORMATION>";
    public static final String DENOM_AMEND_NO_APPROVE_PRIVILEGE = "<DENOM_AMEND_NO_APPROVE_PRIVILEGE>";
    
    public static final String DENOM_APPROVE_OPT = "P0050P";
    public static final String DENOMINATION_APPROVE_DESC = "Approve_key";
    
    public static final String DENOMINATION_ALERT_DESCRIPTION_PATTERN = "<Code__key>: {0}\n"+
    "<tellerCode_key>: {1},\n"+
    "<teller_key>: {2}";
    
    public static final String DENOMINATION_ACK_APPROVE = "DEP";
    public static final String DENOMINATION_ACK_REJECT  = "DEJ";
  //crud
    public static final String  DENOMINATION_ALERT_IV_CRUD_P = "P";
    
    /******************************************** Trade Finance TFA - alerts constants *******************************************************/
    
    public static final String REMITTANCE_VALIDATE_DESC = "Validate_key";
    public static final String TFA_VALIDATE_DESC = "Validate_key";
    public static final String TFA_APPROVE_DESC = "Approve_key";
    

    /******************************************** End Trade Finance TFA - alerts constants *******************************************************/
    public static final String AMENDCHEQUECARD_ALERT_REASON_CODE = "QG";
    public static final String AMENDCHEQUECARD_ACK_APPROVE = "QGP";
    public static final String AMENDCHEQUECARD_TODO_ALERT = "QG";
    public static final String AMENDCHEQUECARD_ALERT_ADD_CODE_DC = "DC";
    public static final String AMENDCHEQUECARD_ALERT_ADD_CODE_DI = "DI";
    public static final String AMENDCHEQUECARD_ALERT_ADD_CODE_DP = "DP";
    public static final String AMENDCHEQUECARD_ALERT_ADD_CODE_RI = "QG001";
    public static final String AMENDCHEQUECARD_PAGE_P = "QG001P";
    public static final String AMENDCHEQUECARD_TODO_ALERT_LOWER_CASE = "qg";
    public static final String AMENDCHEQUECARD_PAGE_M = "QG001MT";
    public static final String AMENDCHEQUECARD_APPROVE_DESC = "Approve_key";
    public static final String AMENDCHEQUECARD_ALERT_DESCRIPTION_PATTERN = "<amend_cheque_products_key> \n"
	    + "<of_type_key>: {0},\n" + "<batch_no_key>: {1}";
    /******************************************** Account Charges - alerts constants *******************************************************/
    
    public static final String ACCOUNTCHARGES_ALERT_TYPE = "ACH";    

    public static final String ACCOUNTCHARGES_CREATION_ON_INFORMATION 	= "ACCC";
    public static final String ACCOUNTCHARGES_AMENDMENT_OF_INFORMATION  = "ACCA";
    public static final String ACCOUNTCHARGES_NO_APPROVAL_PRIVELEGE 	= "ACCN";
    
    
    public static final String CONVENTION_APPROVE_RECORD = "SEGA";
    public static final String CONVENTION_SUSPEND_RECORD 	= "SEGS";
    public static final String CONVENTION_REACTIVATE_RECORD 	= "SEGR";
    public static final String CONVENTION_ALERT_TYPE 		= "SEG";    
    
    //used for upon sending alert
    public static final String ACCOUNTCHARGES_ALERT_DESCRIPTION_PATTERN = "<account_charges_key> <branch_code_key>: {0}, "
    		+ "<acc_br_key>: {1}, <acc_cy_key>: {2}, <acc_gl_key>: {3}, <acc_cif_key>: {4}, <acc_sl_key>: {5}";
    
    public static final String CONVENTION_ACCOUNT_ALERT_DESCRIPTION_PATTERN = "<account_convention_charges_key>\n,"+ " <branch_code_key>: {0}, "
  		+ "<acc_br_key>: {1}, <acc_cy_key>: {2}, <acc_gl_key>: {3}, <acc_cif_key>: {4}, <acc_sl_key>: {5} ";
      
    public static final String CONVENTION_CIF_ALERT_DESCRIPTION_PATTERN = "<cif_convention_charges_key>\n" + " <cif_no_key>: {0}";

    public static final String CONVENTION_SEGMENT_ALERT_DESCRIPTION_PATTERN = "<segment_convention_charges_key>\n" + " <segment_no_key>: {0}";
      
      
    
//    //used upon showing alert
//    public static final String TRANSFERBILL_ALERT_DESCRIPTION_APPROVE_PATTERN = "<Transfer_Bill_Approve_Key>" ;
//    public static final String TRANSFERBILL_ALERT_DESCRIPTION_REVERSE_PATTERN = "<Transfer_Bill_Cancel_Key>" ;

    public static final String ACCOUNTCHARGES_ALERT_REASON_CODE 	= "ACC";

    public static final String ACCOUNTCHARGES_TODO_ALERT_APPROVE 	= "ACA";
    
    public static final String ACCOUNTCHARGES_ACK_APPROVE 			= "ACP";
    public static final String ACCOUNTCHARGES_ACK_REJECT			= "ACR";
   
    public static final String ACCOUNTCHARGES_TODO_EXCEP_APPROVE ="<A_APPROVE_ACCOUNT_CHARGES_TODO_EXCEP>,";
    
    /******************************************** End Account Charges - alerts constants *******************************************************/
    
    //Raed Saad -[PATH120131] related to [BPI120361] - 27/12/2016
    public static final String FOM_TODO_EXCEP_TO_SUSPEND = "CIF_REQUIRES_SUSPEND_AUTHORIZATION";
    public static final String FOM_TODO_EXCEP_TO_REINSTATE = "CIF_REQUIRES_REINSTATE_AUTHORIZATION";
    public static final String FOM_ALERT_ADD_CODE_CIFS = "CIFS";
    public static final String FOM_ALERT_ADD_CODE_CIFR = "CIFR";
   //End Raed Saad -[PATH120131] related to [BPI120361] - 27/12/2016
    
    public static final String AMENDCHEQUECARD_ACK_REJECT = "DEJ";
    public static final String AMENDCHEQUECARD_ALERT_IV_CRUD_P = "P";
    
    /****************************************** Ava File - alerts constans ************************************************************************/
    public static final String AVAFILE_ALERT_REASON_CODE = "ADD";
    
    public static final String AVAFILE_CREATION_ALERT_ADD_CODE_AFC = "AFC";
    
    public static final String AVAFILE_AMENDMENT_OF_INFO_ADD_CODE_AFI = "AFI";
    
    public static final String AVAFILE_SUSPESION_ALERT_ADD_CODE_AFS = "AFS";
    public static final String AVAFILE_REACTIVATION_ALERT_ADD_CODE_AFR = "AFR";
    public static final String AVAFILE_CLOSE_ALERT_ADD_CODE_AFL = "AFL";
    public static final String AVAFILE_NO_APPROVE_PRIVILEGE_ALERT_ADD_CODE_NAP= "NAP";
   
    
    public static final String AVA_FILE_TODO_ALERT_APPROVE = "FPT";
    public static final String AVA_FILE_TODO_ALERT_SUSPEND = "AST";
    public static final String AVA_FILE_TODO_ALERT_REACTIVATE = "FRT";
    public static final String AVA_FILE_TODO_ALERT_CLOSE = "FCT";
    
    public static final String AVA_FILE_ACK_APPROVE = "FPA";
    public static final String AVA_FILE_ACK_SUSPEND = "ASA";
    public static final String AVA_FILE_ACK_REACTIVATE = "FRA";
    public static final String AVA_FILE_ACK_CLOSE = "FCA";
    
    public static final String AVA_FILE_ACK_APROVE_REJECT  = "FPR";
    public static final String AVA_FILE_ACK_SUSPEND_REJECT = "ASR";
    public static final String AVA_FILE_ACK_REACTIVATE_REJECT = "FRR";
    public static final String AVA_FILE_ACK_CLOSE_REJECT = "FCR";
    
    public static final String AVA_FILE_TODO_EXCEP_CREATION ="<A_APPROVE_AVA_FILE_TODO_EXCEP>,";
    public static final String AVA_FILE_TODO_EXCEP_AMEND_INFORMATION ="<A_AMEND_INFORMATION_AVA_FILE_TODO_EXCEP>,";
    public static final String AVA_FILE_TODO_EXCEP_SUSPENSION ="<A_SUSPEND_AVA_FILE_TODO_EXCEP>,";
    public static final String AVA_FILE_TODO_EXCEP_REACTIVATION ="<A_REACTIVATE_AVA_FILE_TODO_EXCEP>,";
    public static final String AVA_FILE_TODO_EXCEP_CLOSE ="<A_CLOSE_AVA_FILE_TODO_EXCEP>,";
    public static final String AVA_FILE_TODO_EXCEP_NO_APPROVAL_PRIVILEGE ="<A_NO_APPROVAL_PRIVILEGE_AVA_FILE_TODO_EXCEP>,";
    
    public static final String AVA_FILE_ALERT_DESCRIPTION_PATTERN = "<AvaFileCode_key>: {0}\n"+
    "<CIF_No_key>: {1},\n"+
    "<Category_type_Key>: {2}";
    
    public static final String AVA_FILE_ALERT_WITHOUT_CIF_DESCRIPTION_PATTERN = "<AvaFileCode_key>: {0}\n"+ "<Category_type_Key>: {1}";
   
    public static final String AVAFILE_ALERT_TYPE = "X";

    /****************************************** End Ava File - alerts constans ************************************************************************/

    /*********************************************Ava Allocation****************************************************************/
    public static final String AVAALLOCATION_ALERT_TYPE = "ADD Allocation";
    public static final String AVAALLOCATION_ALERT_REASON_CODE = "ADD"; 
    public static final String AVAALLOCATION_ALERT_ADD_CODE_AAC = "AAC"; 
    public static final String AVAALLOCATION_NO_APPROVE_PRIVILEGE_ALERT_ADD_CODE_NAP= "NAP";
    public static final String AVAALLOCATION_TODO_EXCEP_ON_UPDATE = "AAC_UPDATE_TODO_EXCEP";
    public static final String AVA_ALLOCATION_TODO_EXCEP_NO_APPROVAL_PRIVILEGE ="<A_NO_APPROVAL_PRIVILEGE_AVA_ALLOCATION_TODO_EXCEP>,";
    public static final String AVAALLOCATION_TODO_ALERT = "ALA";
    public static final String AVAALLOCATION_ALERT_DESCRIPTION_PATTERN = "<Code__key>: {0}\n"+
    "<Ava_File_Code_key>: {1},\n"+
    "<Ava_File_Name_Key>: {2},\n"+    
    "<Allocation_Date_key>: {3}";  
    
    public static final String AVAALLOCATION_APPROVE_DESC = "Approve_key";
    public static final String AVAALLOCATION_ACK_APPROVE = "ALP";
    public static final String AVAALLOCATION_ACK_REJECT = "ALJ";
    public static final String AVAALLOCATION_PAGE_AVAALP = "AVAALP";
    public static final String AVAALLOCATION_ALERT_IV_CRUD_P = "P";
    
    /*********************************************AVA Payment****************************************************************/
    public static final String AVAPAYMENT_ALERT_REASON_CODE = "ADD"; 
    
    public static final String AVAPAYMENT_CREATION_ALERT_ADD_CODE_APC = "APC";
    public static final String AVAPAYMENT_CANCELLATION_ALERT_ADD_CODE_APN = "APN";
    public static final String AVAPAYMENT_TODO_ALERT_APPROVE = "APA";
    public static final String AVAPAYMENT_TODO_ALERT_CANCEL = "PCA";
    public static final String AVAPAYMENT_PAGE_AVAPAYP = "AVAPAYP";
    public static final String AVAPAYMENT_PAGE_AVAPAYNP = "AVAPAYNP";
    public static final String AVAPAYMENT_NO_APPROVE_PRIVILEGE_ALERT_ADD_CODE_NAP = "NAP";
    public static final String AVA_PAYMENT_TODO_EXCEP_NO_APPROVAL_PRIVILEGE= "<A_NO_APPROVAL_PRIVILEGE_AVA_PAYMENT_TODO_EXCEP>,";
    
 //   public static final String AVAPAYMENT_ALERT_ADD_CODE_AAC = "APC";  
    public static final String AVA_PAYMENT_TODO_EXCEP_CREATION = "<A_APPROVE_AVA_PAYMENT_TODO_EXCEP>,";
    public static final String AVA_PAYMENT_TODO_EXCEP_CANCALATION = "<A_CANCEL_AVA_PAYMENT_TODO_EXCEP>,";
    public static final String AVAPAYMENT_TODO_EXCEP_ON_UPDATE = "AAC_UPDATE_TODO_EXCEP";
   
    public static final String AVAPAYMENT_ALERT_DESCRIPTION_PATTERN = "<Code__key>: {0}\n"+
    "<Ava_File_Code_key>: {1},\n"+
    "<Ava_File_Name_Key>: {2},\n"+    
    "<Payment_Date_key>: {3}";  
   
    
    public static final String AVAPAYMENT_APPROVE_DESC = "Approve_key";
    public static final String AVAPAYMENT_ACK_APPROVE = "APP";
    public static final String AVAPAYMENT_ACK_REJECT = "APR";
    public static final String AVAPAYMENT_PAGE_AVAPAY = "AVAPAY";
    public static final String AVAPAYMENT_ALERT_IV_CRUD_P = "P";
     
    public static final String AVAPAYMENT_APPROVE_CANCEL_DESC = "ApproveCancel_key";
    public static final String AVAPAYMENT_ACK_CANCEL_APPROVE = "PCP";
    public static final String AVAPAYMENT_ACK_CANCEL_REJECT = "PCR";
    public static final String AVAPAYMENT_ALERT_IV_CRUD_NP = "NP";
    public static final String AVAPAYMENT_ALERT_TYPE = "X";
    
    /******************************************** Remittance Stock - alerts constants *******************************************************/

    public static final String REMIT_STOCK_ALERT_TYPE = "REMITTANCE";
    
    public static final String REMIT_STOCK_TODO_ALERT_RMI = "RMI";
    public static final String REMIT_STOCK_TODO_ALERT_RM = "RM";
    public static final String REMIT_STOCK_TODO_ALERT_RMA = "RMA";
    public static final String REMIT_STOCK_TODO_ALERT_RMR = "RMR";
    
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_RMSB = "<Remittance_Request_key>" ;
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_RMRB = "<Remittance_Recieved_key>" ;
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_RMISB = "<Send_To_Branch_Remit_key>" ;
    
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_FROM_BRANCH = "<From_Br_key>" ;
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_TO_BRACNCH = "<To_Br_key>" ;
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_FROM_MAIN_VAULT = "<From_Main_Vault_key>" ;
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_TO_MAIN_VAULT = "<To_Main_Vault_key>" ;
    
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_REMIT_REQ_TRX_NO = "<Remit_Req_Trx_No_key>" ;
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_REMIT_SEND_TO_BR_TRX_NO = "<Remit_To_Br_Trx_No_key>" ;
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_REMIT_REC_BY_BR_TRX_NO = "<Remit_By_Br_Trx_No_key>" ;
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_REMIT_TO_MAIN_VAULT_TRX_NO = "<Remit_To_Main_Vault_Trx_No_key>" ;
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_REMIT_SEND_TRX_NO = "<Remit_Send_Trx_No_key>" ;
    
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_RMIRS_PATTERN = "<Remit_Req_Trx_No_key>. : {0},\n"+
	         "{1} : {2} \n {3} : {4} {5}";
    
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_RMI_PATTERN = " {0},\n"+
	         "{1} : {2} {3} \n {4} : {5}";
    
    
    public static final String REMIT_STOCK_ALERT_DESCRIPTION_RMSB_PATTERN = "<Remit_Req_Trx_No_key>. : {0},\n"+
	         "{1} : {2} \n {3} : {4} {5}";

    public static final String REMIT_STOCK_ALERT_DESCRIPTION_RM_PATTERN = "<Remit_Send_Trx_No_key>. : {0},\n"
	    + "{1} : {2} {3} \n {4} : {5}"; 
    
    public static final String FOM_TODO_EXCEP_SIRON 	= "SIRON_CHECK_THIS_CASE_AND_TAKE_REQUIRED_ACTION";
    
    public static final String BENEF_COOLING_ALERT = "BNF";
    public static final String BENEF_PAGE_BNFCOOLP = "BNFCOOLP";
    public static final String BENEF_PAGE_BNFCOOLAS = "BNFCOOLAS";
    public static final String BENEF_COOLING_CREATION_OF_INFO="BFC";
    public static final String BENEF_COOLING_NO_APPROVAL_PRIVILEGE="BFA";
    public static final String BENEF_COOLING_DELETE="BFS";
    public static final String BENEF_COOLING_TODO_EXCEP_CREATE="benef_cooling_todo_excep_create_key";
    public static final String BENEF_COOLING_TODO_EXCEP_DELETE="benef_cooling_todo_excep_delete_key";
    public static final String BENEF_ALERT_DESCRIPTION_PATTERN = "<benef_cooling_exception_code_key>:{0},\n<cif_key>:{1}";
    
    
    //beneficiary cooling Ack response
    public static final String BENEFCOOL_ACK_APPROVE = "BNA";
    public static final String BENEFCOOL_ACK_REJECT  = "BRP";
    
    public static final String BENEFCOOL_ACK_APPROVE_DELETION = "BNS";
    public static final String BENEFCOOL_ACK_REJECT_DELETION  = "BRS";

    //Rania - Customers Segmentation
    public static final String SEGMENTATION_APPROVE_TODO_ALERT  = "CSAP";
    
    
    /******************************************** Transfer Bill - alerts constants *******************************************************/
    public static final String TRANSFERBILL_ALERT_TYPE = "TB";
    
    public static final String TRANSFERBILL_PROG_REF_APPROVE = "P";
    
    public static final String TRANSFERBILL_APPROVED_ALERT_ADD_CODE_TBA = "TBA";
    public static final String TRANSFERBILL_REVERSED_ALERT_ADD_CODE_TBR = "TBR";
    
    public static final String TRANSFERBILL_APPROVE_TRANSFER_ALERT_ADD_CODE_TBT = "TBT";
    public static final String TRANSFERBILL_REVERSE_TRANSFER_ALERT_ADD_CODE_TBV = "TBV";
    
    public static final String TRANSFERBILL_APPROVE_SEND_TO_COURT_ALERT_ADD_CODE_TBSA = "TBSA";
    public static final String TRANSFERBILL_REVERSE_SEND_TO_COURT_ALERT_ADD_CODE_TBSV = "TBSV";
    
    public static final String TRANSFERBILL_APPROVE_SEND_TO_LEGAL_PROCEEDING_ALERT_ADD_CODE_TBLA = "TBLA";
    public static final String TRANSFERBILL_REVERSE_SEND_TO_LEGAL_PROCEEDING_ALERT_ADD_CODE_TBLV = "TBLV";
    public static final String TRX_ADD_CODE_CDA = "CDA";
    
    //used for upon sending alert
    public static final String TRANSFERBILL_ALERT_DESCRIPTION_PATTERN = "<Bill_Transfer_key> <Code_key>.: {0}";

    public static final String TRANSFERBILL_PAGE_TP = "TB00TVP";
    public static final String TRANSFERBILL_PAGE_TV = "TB00TVV";
    public static final String TRANSFERBILL_PAGE_VP = "TB00VCP";
    public static final String TRANSFERBILL_PAGE_VV = "TB00VCV";
    
    //used upon showing alert
    public static final String TRANSFERBILL_ALERT_DESCRIPTION_APPROVE_PATTERN = "<Transfer_Bill_Approve_Key>" ;
    public static final String TRANSFERBILL_ALERT_DESCRIPTION_REVERSE_PATTERN = "<Transfer_Bill_Cancel_Key>" ;
    
    public static final String TRANSFERBILL_TODO_ALERT = "TB";

    public static final String TRANSFERBILL_ALERT_REASON_CODE = "TB";
    
    //crud
    public static final String  TRANSFERBILL_ALERT_IV_CRUD_P = "P";
    public static final String  TRANSFERBILL_ALERT_IV_CRUD_V = "V";

    public static final String TRANSFERBILL_TODO_ALERT_APPROVE_TV = "BAT";
    public static final String TRANSFERBILL_ACK_APPROVED_APPROVE_TV = "BAA";
    public static final String TRANSFERBILL_ACK_REJECTED_APPROVE_TV = "BAR";
    public static final String TRANSFERBILL_TODO_ALERT_APPROVE = "BAT";
    public static final String TRANSFERBILL_TODO_ALERT_REVERSED = "BRT";
    public static final String TRANSFERBILL_TODO_ALERT_APPROVE_TRANSFERRED = "BTT";
    public static final String TRANSFERBILL_TODO_ALERT_REVERSE_TRANSFERRED = "TRT";
    
    public static final String TRANSFERBILL_TODO_ALERT_REVERSED_TV = "BRT";
    public static final String TRANSFERBILL_ACK_APPROVED_REVERSE_TV = "BRA";
    public static final String TRANSFERBILL_ACK_REJECTED_REVERSE_TV = "BRR";
    public static final String TRANSFERBILL_ACK_APPROVE = "BAA";
    public static final String TRANSFERBILL_ACK_REVERSE = "BRA";
    public static final String TRANSFERBILL_ACK_APPROVE_TRANSFER = "BTA";
    public static final String TRANSFERBILL_ACK_REVERSE_TRANSFER = "TRA";
    
    
    public static final String TRANSFERBILL_TODO_ALERT_APPROVE_VC = "BTT";
    public static final String TRANSFERBILL_ACK_APPROVED_APPROVE_VC = "BTA";
    public static final String TRANSFERBILL_ACK_REJECTED_APPROVE_VC = "BTR";
    
    public static final String TRANSFERBILL_TODO_ALERT_REVERSE_VC = "TRT";
    public static final String TRANSFERBILL_ACK_APPROVED_REVERSE_VC = "TRA";
    public static final String TRANSFERBILL_ACK_REJECTED_REVERSE_VC = "TRR";
    
    public static final String BIOMETRIC_ALERT_TYPE = "NID";
    public static final String BIOMETRIC_TODO_ALERT = "NID";
    public static final String BIOMETRIC_ADD_CODE_NID  = "NID"; 
    public static final String BIOMETRIC_TODO_EXCEP_APPROVED ="<A_BIOMETRIC_CHECKING_FAILED_TODO_EXCEP>,";
    
    public static final String FOM_CHECK_RESTRICTION = "CCR";
    public static final String FOM_CHECK_RESTRICTION_TYPE = "CACR";
    public static final String ACCOUNT_CHECK_RESTRICTION = "ACR";
    
    /****************************************** Incident Report - alerts constans ************************************************************************/
    public static final String INC_REPORT_ALERT_REASON_CODE = "INR";
    
    public static final String TRANSFERBILL_TODO_ALERT_APPROVE_SEND_TO_COURT = "BAS";
    public static final String TRANSFERBILL_ACK_APPROVED_APPROVE_SEND_TO_COURT = "SCA";
    public static final String TRANSFERBILL_ACK_REJECTED_APPROVE_SEND_TO_COURT = "RSC";
    
    
    public static final String TRANSFERBILL_TODO_ALERT_REVERSED_SEND_TO_COURT = "BRSC";
    public static final String TRANSFERBILL_ACK_APPROVED_REVERSE_SEND_TO_COURT = "RSCA";
    public static final String TRANSFERBILL_ACK_REJECTED_REVERSE_SEND_TO_COURT = "RSCR";
    
    public static final String TRANSFERBILL_TODO_ALERT_APPROVE_SEND_TO_LP = "ALP";
    public static final String TRANSFERBILL_ACK_APPROVED_APPROVE_SEND_TO_LP = "LPA";
    public static final String TRANSFERBILL_ACK_REJECTED_APPROVE_SEND_TO_LP = "LPR";
    
    
    
    public static final String TRANSFERBILL_TODO_ALERT_REVERSED_SEND_TO_LP = "RLP";
    public static final String TRANSFERBILL_ACK_APPROVED_REVERSE_SEND_TO_LP = "RLPA";
    public static final String TRANSFERBILL_ACK_REJECTED_REVERSE_SEND_TO_LP = "RLPR";
    public static final String INC_REPORT_CREATION_ALERT_ADD_CODE_IRC = "IRC";
    public static final String INC_REPORT_APPROVE_PRIVILEGE_ALERT_ADD_CODE_NAP = "NAP";
    public static final String INC_REPORT_CANCELLATION_ALERT_ADD_CODE_IRN = "IRN";
    public static final String INC_REPORT_REGULARIZATION_ALERT_ADD_CODE_IRR = "IRR";
    
    public static final String INC_REPORT_TODO_ALERT_APPROVE = "IRA";
    public static final String INC_REPORT_TODO_ALERT_CANCEL = "IRC";
    public static final String INC_REPORT_TODO_ALERT_REGULARIZED = "IRR";
    
    public static final String INC_REPORT_ACK_APPROVE = "IAA";
    public static final String INC_REPORT_ACK_CANCEL = "ICA";
    public static final String INC_REPORT_ACK_REGULARIZED = "IAR";
    
    public static final String INC_REPORT_ACK_REJECT  = "IRJ";

    
    public static final String INC_REPORT_TODO_EXCEP_CREATION ="<A_APPROVE_INC_REPORT_TODO_EXCEP>,";
    public static final String INC_REPORT_TODO_EXCEP_NO_APPROVAL_PRIVILEGE ="<A_NO_APPROVAL_PRIVILEGE_INC_REPORT_TODO_EXCEP>,";
    public static final String INC_REPORT_TODO_EXCEP_CANCELLATION ="<A_CANCEL_INC_REPORT_TODO_EXCEP>,";
    public static final String INC_REPORT_TODO_EXCEP_REGULARIZATION ="<A_REGULARIZED_INC_REPORT_TODO_EXCEP>,";
    
    public static final String INC_REPORT_ALERT_DESCRIPTION_PATTERN = "<Incident_Code_key>: {0}";
    
    public static final String INC_REPORT_ALERT_TYPE = "X";
    
    
    public static final String TRANSFERBILL_TODO_EXCEP_APPROVE ="<A_APPROVE_TRANSFER_BILL_TODO_EXCEP>,";
    public static final String TRANSFERBILL_TODO_EXCEP_REVERSE ="<A_REVERSE_TRANSFER_BILL_TODO_EXCEP>,";
    
    public static final String TRANSFERBILL_TODO_EXCEP_APPROVE_TRANSFER ="<A_APPROVE_TRANSFERRED_TRANSFER_BILL_TODO_EXCEP>,";
    public static final String TRANSFERBILL_TODO_EXCEP_REVERSE_TRANSFERRED ="<A_REVERSE_TRANSFERRED_TRANSFER_BILL_TODO_EXCEP>,";
    
    public static final String TRANSFERBILL_TODO_EXCEP_APPROVE_SEND_TO_COURT ="<A_APPROVE_SEND_TO_COURT_TRANSFER_BILL_TODO_EXCEP>,";
    public static final String TRANSFERBILL_TODO_EXCEP_REVERSE_SEND_TO_COURT ="<A_REVERSE_SEND_TO_COURT_TRANSFER_BILL_TODO_EXCEP>,";
    
    public static final String TRANSFERBILL_TODO_EXCEP_APPROVE_SEND_TO_LEGAL_PROCEEDING ="<A_APPROVE_SEND_TO_LP_TRANSFER_BILL_TODO_EXCEP>,";
    public static final String TRANSFERBILL_TODO_EXCEP_REVERSE_SEND_TO_LEGAL_PROCEEDING ="<A_REVERSE_SEND_TO_LP_TRANSFER_BILL_TODO_EXCEP>,";
    
    /** Rania 
     *  FIBSI170001 - Bill Payment integration
     */
    public static final String TRF_INTEGRATION_TODO_ALERT = "TI";
    //added by rany for tpid:514489-SBI170088 tfa blacklist checking
    public static final String BLACK_LIST_LOG_ALERT = "BLL";
    public static final String STATUS_REJECTED_1 = "Y";
    public static final String STATUS_REJECTED_2 = "J";
    public static final String ILC = "ILC";
    public static final String ELC = "ELC";
    public static final String LG  = "LG";
    public static final String IBL = "IBL";
    public static final String EBL = "EBL";
    public static final String ADV = "ADV";
    public static final String IAD = "IAD";
    public static final String EAD = "EAD";
    public static final String EBD = "EBD";
    public static final String TFSLC1 = "TFSLC1";
    public static final String TFSTRX = "TFSTRX";
    public static final String TFSLG  = "TFSLG";
    public static final String TFSBILL = "TFSBILL";
    public static final String BLR = "BLR";
    public static final BigDecimal TRX_TYPE_DECLARATION = BigDecimal.valueOf(1005);
    public static final BigDecimal TRX_TYPE_ISSUE = BigDecimal.valueOf(1010);
    //end rany
    
    public static final String TRX_ADD_CODE_CLE = "CLE";//#795165 Branches cash limit monitoring [MFALHA]
    
    //Rania - ABSAI180073
    public static final String AMEND_SCORE_ALERT_TYPE = "FOM";
    public static final String AMEND_SCORE_TODO_ALERT = "AS";
    public static final String AMEND_SCORE_ADD_CODE_AS  = "AS"; 
    public static final String AMEND_SCORE_TODO_EXCEP_APPROVED ="Amendment of Score";
    public static final String CHEQUEBOOK_BULK_CANCEL_TODO_ALERT = "BCC";
    public static final String CHEQUEBOOK_BULK_REVERSE_CANCEL_TODO_ALERT = "BCR";
    //
    
    /******************************************** Transfer Entity - alerts constants *******************************************************/
    
    public static final String TRANSFERENTITY_ALERT_TYPE = "TOE";    

    public static final String TRANSFERENTITY_BATCH_CREATION 	= "TEC";
    public static final String TRANSFERENTITY_BATCH_CANCELLATION  = "TEZ";
    public static final String TRANSFERENTITY_NO_APPROVAL_PRIVELEGE 	= "TEN";
    
    public static final String TRANSFERENTITY_TODO_ALERT = "TOA";   
    
    //used for upon sending alert
    public static final String TRANSFERENTITY_ALERT_DESCRIPTION_PATTERN = "<transfer_entity_key> <branch_code_key>: {0}, "
    		+ "<batch_no_key>: {1}";
    
    //used upon showing alert
    public static final String TRANSFERENTITY_ALERT_DESCRIPTION_APPROVE_PATTERN = "<Transfer_Entity_Approve_Key>" ;
    public static final String TRANSFERENTITY_ALERT_DESCRIPTION_CANCEL_PATTERN = "<Transfer_Entity_Cancel_Key>" ;

    public static final String TRANSFERENTITY_ALERT_REASON_CODE 	= "TOE";

    public static final String TRANSFERENTITY_TODO_ALERT_APPROVE 	= "TOA";
    
    public static final String TRANSFERENTITY_ACK_APPROVE 			= "TOP";
    public static final String TRANSFERENTITY_ACK_CANCEL 			= "TOC";
    public static final String TRANSFERENTITY_ACK_REJECT			= "TOR";
   
    public static final String TRANSFERENTITY_TODO_EXCEP_APPROVE ="<A_APPROVE_TRANSFER_ENTITY_TODO_EXCEP>,";

    //#999384 - DB190016 - Dhofar - Charges Refund and Authority Matrix
    public static final String CHARGES_REFUND_ALERT_DESCRIPTION_PATTERN = "<Refund_Charges_key> \n <refund_code_key>:{0}, <branch_code_key>: {1}";

    
    public static final String CHARGES_REFUND_TODO_ALERT = "CHR";
    
    public static final String CHARGES_REFUND_ALERT_CODE 	= "CRJR";
    public static final String CHARGES_REFUND_ALERT_TYPE 	= "CRJR";
    public static final String CHARGES_REFUND_ALERT_APPROVE 	= "CRA";
    public static final String CHARGES_REFUND_ALERT_REVERSE = "CRR";
    public static final String CHARGES_REFUND_TODO_EXCEP_APPROVE ="approve_charges_refund_todo_excep";
    public static final String CHARGES_REFUND_TODO_EXCEP_REVERSE ="reverse_charges_refund_todo_excep";
    public static final String CHARGES_REFUND_ACK_APPROVE = "CHRA";
    public static final String CHARGES_REFUND_ACK_REVERSE  = "CHRR";
    public static final String CHARGES_REFUND_ACK_REJECT  = "CHRJ";
}
 