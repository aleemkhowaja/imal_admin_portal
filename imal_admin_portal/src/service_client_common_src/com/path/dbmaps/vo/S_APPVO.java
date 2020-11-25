package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

public class S_APPVO extends BaseVO {
    /**
     * This field corresponds to the database column S_APP.APP_NAME
     */
    private String APP_NAME;

    /**
     * This field corresponds to the database column S_APP.LONG_DESC
     */
    private String LONG_DESC;

    /**
     * This field corresponds to the database column S_APP.OPTION_SEQ
     */
    private BigDecimal OPTION_SEQ;

    /**
     * This field corresponds to the database column S_APP.PATH_NAME
     */
    private String PATH_NAME;

    /**
     * This field corresponds to the database column S_APP.F_PATH
     */
    private String f_PATH;

    /**
     * This field corresponds to the database column S_APP.E_PATH
     */
    private String e_PATH;

    /**
     * This field corresponds to the database column S_APP.R_PATH
     */
    private String r_PATH;

    /**
     * This field corresponds to the database column S_APP.D_PATH
     */
    private String d_PATH;

    /**
     * This field corresponds to the database column S_APP.VER
     */
    private BigDecimal VER;

    /**
     * This field corresponds to the database column S_APP.TYPE
     */
    private String TYPE;

    /**
     * This field corresponds to the database column S_APP.APP_TYPE
     */
    private String APP_TYPE;

    /**
     * This field corresponds to the database column S_APP.CLIENT_ACC_TYPE
     */
    private String CLIENT_ACC_TYPE;

    /**
     * This field corresponds to the database column S_APP.ONLINE_POSTING
     */
    private String ONLINE_POSTING;

    /**
     * This field corresponds to the database column S_APP.CASH_BALANCE
     */
    private String CASH_BALANCE;

    /**
     * This field corresponds to the database column S_APP.APP_DESC
     */
    private String APP_DESC;

    /**
     * This field corresponds to the database column S_APP.ACCRUAL_METHOD
     */
    private String ACCRUAL_METHOD;

    /**
     * This field corresponds to the database column S_APP.REVERSAL_DAYS
     */
    private BigDecimal REVERSAL_DAYS;

    /**
     * This field corresponds to the database column S_APP.CALC_ENABLE
     */
    private String CALC_ENABLE;

    /**
     * This field corresponds to the database column S_APP.MODIFY_DATE
     */
    private String MODIFY_DATE;

    /**
     * This field corresponds to the database column S_APP.ONLINE_LIMIT_CHECK
     */
    private String ONLINE_LIMIT_CHECK;

    /**
     * This field corresponds to the database column S_APP.EXE_VER
     */
    private String EXE_VER;

    /**
     * This field corresponds to the database column S_APP.BLOOM
     */
    private String BLOOM;

    /**
     * This field corresponds to the database column S_APP.BANK
     */
    private String BANK;

    /**
     * This field corresponds to the database column S_APP.POST_ACCRUAL
     */
    private String POST_ACCRUAL;

    /**
     * This field corresponds to the database column S_APP.AFFECT_DEPOSIT
     */
    private BigDecimal AFFECT_DEPOSIT;

    /**
     * This field corresponds to the database column S_APP.GEN_ACC_DESC_CIF
     */
    private String GEN_ACC_DESC_CIF;

    /**
     * This field corresponds to the database column S_APP.SERVICE
     */
    private String SERVICE;

    /**
     * This field corresponds to the database column S_APP.DYNAMIC_MENU
     */
    private String DYNAMIC_MENU;

    /**
     * This field corresponds to the database column S_APP.SHOW_FORWARD
     */
    private String SHOW_FORWARD;

    /**
     * This field corresponds to the database column S_APP.TRADE_IN_LOTS
     */
    private BigDecimal TRADE_IN_LOTS;

    /**
     * This field corresponds to the database column S_APP.SET_ACCOUNTS
     */
    private BigDecimal SET_ACCOUNTS;

    /**
     * This field corresponds to the database column S_APP.AFFECT_COST_WITH_PREMIUM
     */
    private String AFFECT_COST_WITH_PREMIUM;

    /**
     * This field corresponds to the database column S_APP.CATEG
     */
    private BigDecimal CATEG;

    /**
     * This field corresponds to the database column S_APP.APP_INFO
     */
    private String APP_INFO;

    /**
     * This field corresponds to the database column S_APP.SKIP_CHECK_EOM_XACT
     */
    private String SKIP_CHECK_EOM_XACT;

    /**
     * This field corresponds to the database column S_APP.TRANSFER_BY_DEAL
     */
    private String TRANSFER_BY_DEAL;

    /**
     * This field corresponds to the database column S_APP.FAIMS_DATABASE
     */
    private String FAIMS_DATABASE;

    /**
     * This field corresponds to the database column S_APP.ACC_GEN_FIX
     */
    private String ACC_GEN_FIX;

    /**
     * This field corresponds to the database column S_APP.SHOW_BRIEF_LONG_NAME
     */
    private String SHOW_BRIEF_LONG_NAME;

    /**
     * This field corresponds to the database column S_APP.COUPON_PAYMENT_DED
     */
    private String COUPON_PAYMENT_DED;

    /**
     * This field corresponds to the database column S_APP.CALC_FX_GL
     */
    private String CALC_FX_GL;

    /**
     * This field corresponds to the database column S_APP.ACCRUAL_CALC
     */
    private String ACCRUAL_CALC;

    /**
     * This field corresponds to the database column S_APP.APPEON_PATH
     */
    private String APPEON_PATH;

    /**
     * This field corresponds to the database column S_APP.ENABLE_LANGUAGE
     */
    private String ENABLE_LANGUAGE;

    /**
     * This field corresponds to the database column S_APP.LONG_DESC_AR
     */
    private String LONG_DESC_AR;

    /**
     * This field corresponds to the database column S_APP.LONG_DESC_FR
     */
    private String LONG_DESC_FR;

    /**
     * This field corresponds to the database column S_APP.APP_DESC_AR
     */
    private String APP_DESC_AR;

    /**
     * This field corresponds to the database column S_APP.APP_DESC_FR
     */
    private String APP_DESC_FR;

    /**
     * This field corresponds to the database column S_APP.DUAL_PARAM
     */
    private BigDecimal DUAL_PARAM;

    /**
     * This field corresponds to the database column S_APP.CHARGES_CY_CALC
     */
    private String CHARGES_CY_CALC;

    /**
     * This field corresponds to the database column S_APP.ENABLE_SWIFT_VAL
     */
    private String ENABLE_SWIFT_VAL;

    /**
     * This field corresponds to the database column S_APP.UPGRADE_ORDER
     */
    private BigDecimal UPGRADE_ORDER;

    /**
     * This field corresponds to the database column S_APP.APP_GROUP_CODE
     */
    private BigDecimal APP_GROUP_CODE;

    /**
     * This field corresponds to the database column S_APP.COPY_ALL_FOLDERS
     */
    private String COPY_ALL_FOLDERS;

    /**
     * This field corresponds to the database column S_APP.IS_WEB_YN
     */
    private BigDecimal IS_WEB_YN;

    /**
     * This field corresponds to the database column S_APP.WEB_VERSION
     */
    private String WEB_VERSION;

    /**
     * This field corresponds to the database column S_APP.APP_DESC_RU
     */
    private String APP_DESC_RU;

    /**
     * This field corresponds to the database column S_APP.APP_DESC_TK
     */
    private String APP_DESC_TK;

    /**
     * This field corresponds to the database column S_APP.LONG_DESC_RU
     */
    private String LONG_DESC_RU;

    /**
     * This field corresponds to the database column S_APP.LONG_DESC_TK
     */
    private String LONG_DESC_TK;

    /**
     * This field corresponds to the database column S_APP.LONG_DESC_FA
     */
    private String LONG_DESC_FA;

    /**
     * This field corresponds to the database column S_APP.APP_DESC_FA
     */
    private String APP_DESC_FA;

    /**
     * This field corresponds to the database column S_APP.SYNC_CON
     */
    private BigDecimal SYNC_CON;

    /**
     * This field corresponds to the database column S_APP.APP_CATEGORY
     */
    private BigDecimal APP_CATEGORY;

    /**
     * This field corresponds to the database column S_APP.MENU_SHOW_MODE
     */
    private BigDecimal MENU_SHOW_MODE;

    /**
     * This field corresponds to the database column S_APP.CHANGE_TABLE_SCHEMA_YN
     */
    private BigDecimal CHANGE_TABLE_SCHEMA_YN;

    /**
     * This field corresponds to the database column S_APP.STOP_REPLICATION_WHILE_RUN_YN
     */
    private BigDecimal STOP_REPLICATION_WHILE_RUN_YN;

    /**
     * This field corresponds to the database column S_APP.SCR_VERSION
     */
    private String SCR_VERSION;

    /**
     * This field corresponds to the database column S_APP.PRC_VERSION
     */
    private String PRC_VERSION;

    /**
     * This field corresponds to the database column S_APP.MAIN_APP_NAME
     */
    private String MAIN_APP_NAME;

    /**
     * This field corresponds to the database column S_APP.PATCH_NO
     */
    private BigDecimal PATCH_NO;

    /**
     * This field corresponds to the database column S_APP.COMMON_VERSION
     */
    private String COMMON_VERSION;

    /**
     * This field corresponds to the database column S_APP.BSSCR_VERSION
     */
    private String BSSCR_VERSION;
    
    private String APP_LOCATION_TYPE;
    
    private String IS_ADMIN_YN;
    
    private Date DATE_UPDATED;
    
    private String ENABLE_STS_MONITORING_YN;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.APP_NAME
     *
     * @return the value of S_APP.APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.APP_NAME
     *
     * @param APP_NAME the value for S_APP.APP_NAME
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME == null ? null : APP_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.LONG_DESC
     *
     * @return the value of S_APP.LONG_DESC
     */
    public String getLONG_DESC() {
        return LONG_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.LONG_DESC
     *
     * @param LONG_DESC the value for S_APP.LONG_DESC
     */
    public void setLONG_DESC(String LONG_DESC) {
        this.LONG_DESC = LONG_DESC == null ? null : LONG_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.OPTION_SEQ
     *
     * @return the value of S_APP.OPTION_SEQ
     */
    public BigDecimal getOPTION_SEQ() {
        return OPTION_SEQ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.OPTION_SEQ
     *
     * @param OPTION_SEQ the value for S_APP.OPTION_SEQ
     */
    public void setOPTION_SEQ(BigDecimal OPTION_SEQ) {
        this.OPTION_SEQ = OPTION_SEQ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.PATH_NAME
     *
     * @return the value of S_APP.PATH_NAME
     */
    public String getPATH_NAME() {
        return PATH_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.PATH_NAME
     *
     * @param PATH_NAME the value for S_APP.PATH_NAME
     */
    public void setPATH_NAME(String PATH_NAME) {
        this.PATH_NAME = PATH_NAME == null ? null : PATH_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.F_PATH
     *
     * @return the value of S_APP.F_PATH
     */
    public String getF_PATH() {
        return f_PATH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.F_PATH
     *
     * @param f_PATH the value for S_APP.F_PATH
     */
    public void setF_PATH(String f_PATH) {
        this.f_PATH = f_PATH == null ? null : f_PATH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.E_PATH
     *
     * @return the value of S_APP.E_PATH
     */
    public String getE_PATH() {
        return e_PATH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.E_PATH
     *
     * @param e_PATH the value for S_APP.E_PATH
     */
    public void setE_PATH(String e_PATH) {
        this.e_PATH = e_PATH == null ? null : e_PATH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.R_PATH
     *
     * @return the value of S_APP.R_PATH
     */
    public String getR_PATH() {
        return r_PATH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.R_PATH
     *
     * @param r_PATH the value for S_APP.R_PATH
     */
    public void setR_PATH(String r_PATH) {
        this.r_PATH = r_PATH == null ? null : r_PATH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.D_PATH
     *
     * @return the value of S_APP.D_PATH
     */
    public String getD_PATH() {
        return d_PATH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.D_PATH
     *
     * @param d_PATH the value for S_APP.D_PATH
     */
    public void setD_PATH(String d_PATH) {
        this.d_PATH = d_PATH == null ? null : d_PATH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.VER
     *
     * @return the value of S_APP.VER
     */
    public BigDecimal getVER() {
        return VER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.VER
     *
     * @param VER the value for S_APP.VER
     */
    public void setVER(BigDecimal VER) {
        this.VER = VER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.TYPE
     *
     * @return the value of S_APP.TYPE
     */
    public String getTYPE() {
        return TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.TYPE
     *
     * @param TYPE the value for S_APP.TYPE
     */
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE == null ? null : TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.APP_TYPE
     *
     * @return the value of S_APP.APP_TYPE
     */
    public String getAPP_TYPE() {
        return APP_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.APP_TYPE
     *
     * @param APP_TYPE the value for S_APP.APP_TYPE
     */
    public void setAPP_TYPE(String APP_TYPE) {
        this.APP_TYPE = APP_TYPE == null ? null : APP_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.CLIENT_ACC_TYPE
     *
     * @return the value of S_APP.CLIENT_ACC_TYPE
     */
    public String getCLIENT_ACC_TYPE() {
        return CLIENT_ACC_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.CLIENT_ACC_TYPE
     *
     * @param CLIENT_ACC_TYPE the value for S_APP.CLIENT_ACC_TYPE
     */
    public void setCLIENT_ACC_TYPE(String CLIENT_ACC_TYPE) {
        this.CLIENT_ACC_TYPE = CLIENT_ACC_TYPE == null ? null : CLIENT_ACC_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.ONLINE_POSTING
     *
     * @return the value of S_APP.ONLINE_POSTING
     */
    public String getONLINE_POSTING() {
        return ONLINE_POSTING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.ONLINE_POSTING
     *
     * @param ONLINE_POSTING the value for S_APP.ONLINE_POSTING
     */
    public void setONLINE_POSTING(String ONLINE_POSTING) {
        this.ONLINE_POSTING = ONLINE_POSTING == null ? null : ONLINE_POSTING.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.CASH_BALANCE
     *
     * @return the value of S_APP.CASH_BALANCE
     */
    public String getCASH_BALANCE() {
        return CASH_BALANCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.CASH_BALANCE
     *
     * @param CASH_BALANCE the value for S_APP.CASH_BALANCE
     */
    public void setCASH_BALANCE(String CASH_BALANCE) {
        this.CASH_BALANCE = CASH_BALANCE == null ? null : CASH_BALANCE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.APP_DESC
     *
     * @return the value of S_APP.APP_DESC
     */
    public String getAPP_DESC() {
        return APP_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.APP_DESC
     *
     * @param APP_DESC the value for S_APP.APP_DESC
     */
    public void setAPP_DESC(String APP_DESC) {
        this.APP_DESC = APP_DESC == null ? null : APP_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.ACCRUAL_METHOD
     *
     * @return the value of S_APP.ACCRUAL_METHOD
     */
    public String getACCRUAL_METHOD() {
        return ACCRUAL_METHOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.ACCRUAL_METHOD
     *
     * @param ACCRUAL_METHOD the value for S_APP.ACCRUAL_METHOD
     */
    public void setACCRUAL_METHOD(String ACCRUAL_METHOD) {
        this.ACCRUAL_METHOD = ACCRUAL_METHOD == null ? null : ACCRUAL_METHOD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.REVERSAL_DAYS
     *
     * @return the value of S_APP.REVERSAL_DAYS
     */
    public BigDecimal getREVERSAL_DAYS() {
        return REVERSAL_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.REVERSAL_DAYS
     *
     * @param REVERSAL_DAYS the value for S_APP.REVERSAL_DAYS
     */
    public void setREVERSAL_DAYS(BigDecimal REVERSAL_DAYS) {
        this.REVERSAL_DAYS = REVERSAL_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.CALC_ENABLE
     *
     * @return the value of S_APP.CALC_ENABLE
     */
    public String getCALC_ENABLE() {
        return CALC_ENABLE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.CALC_ENABLE
     *
     * @param CALC_ENABLE the value for S_APP.CALC_ENABLE
     */
    public void setCALC_ENABLE(String CALC_ENABLE) {
        this.CALC_ENABLE = CALC_ENABLE == null ? null : CALC_ENABLE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.MODIFY_DATE
     *
     * @return the value of S_APP.MODIFY_DATE
     */
    public String getMODIFY_DATE() {
        return MODIFY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.MODIFY_DATE
     *
     * @param MODIFY_DATE the value for S_APP.MODIFY_DATE
     */
    public void setMODIFY_DATE(String MODIFY_DATE) {
        this.MODIFY_DATE = MODIFY_DATE == null ? null : MODIFY_DATE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.ONLINE_LIMIT_CHECK
     *
     * @return the value of S_APP.ONLINE_LIMIT_CHECK
     */
    public String getONLINE_LIMIT_CHECK() {
        return ONLINE_LIMIT_CHECK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.ONLINE_LIMIT_CHECK
     *
     * @param ONLINE_LIMIT_CHECK the value for S_APP.ONLINE_LIMIT_CHECK
     */
    public void setONLINE_LIMIT_CHECK(String ONLINE_LIMIT_CHECK) {
        this.ONLINE_LIMIT_CHECK = ONLINE_LIMIT_CHECK == null ? null : ONLINE_LIMIT_CHECK.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.EXE_VER
     *
     * @return the value of S_APP.EXE_VER
     */
    public String getEXE_VER() {
        return EXE_VER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.EXE_VER
     *
     * @param EXE_VER the value for S_APP.EXE_VER
     */
    public void setEXE_VER(String EXE_VER) {
        this.EXE_VER = EXE_VER == null ? null : EXE_VER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.BLOOM
     *
     * @return the value of S_APP.BLOOM
     */
    public String getBLOOM() {
        return BLOOM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.BLOOM
     *
     * @param BLOOM the value for S_APP.BLOOM
     */
    public void setBLOOM(String BLOOM) {
        this.BLOOM = BLOOM == null ? null : BLOOM.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.BANK
     *
     * @return the value of S_APP.BANK
     */
    public String getBANK() {
        return BANK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.BANK
     *
     * @param BANK the value for S_APP.BANK
     */
    public void setBANK(String BANK) {
        this.BANK = BANK == null ? null : BANK.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.POST_ACCRUAL
     *
     * @return the value of S_APP.POST_ACCRUAL
     */
    public String getPOST_ACCRUAL() {
        return POST_ACCRUAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.POST_ACCRUAL
     *
     * @param POST_ACCRUAL the value for S_APP.POST_ACCRUAL
     */
    public void setPOST_ACCRUAL(String POST_ACCRUAL) {
        this.POST_ACCRUAL = POST_ACCRUAL == null ? null : POST_ACCRUAL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.AFFECT_DEPOSIT
     *
     * @return the value of S_APP.AFFECT_DEPOSIT
     */
    public BigDecimal getAFFECT_DEPOSIT() {
        return AFFECT_DEPOSIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.AFFECT_DEPOSIT
     *
     * @param AFFECT_DEPOSIT the value for S_APP.AFFECT_DEPOSIT
     */
    public void setAFFECT_DEPOSIT(BigDecimal AFFECT_DEPOSIT) {
        this.AFFECT_DEPOSIT = AFFECT_DEPOSIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.GEN_ACC_DESC_CIF
     *
     * @return the value of S_APP.GEN_ACC_DESC_CIF
     */
    public String getGEN_ACC_DESC_CIF() {
        return GEN_ACC_DESC_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.GEN_ACC_DESC_CIF
     *
     * @param GEN_ACC_DESC_CIF the value for S_APP.GEN_ACC_DESC_CIF
     */
    public void setGEN_ACC_DESC_CIF(String GEN_ACC_DESC_CIF) {
        this.GEN_ACC_DESC_CIF = GEN_ACC_DESC_CIF == null ? null : GEN_ACC_DESC_CIF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.SERVICE
     *
     * @return the value of S_APP.SERVICE
     */
    public String getSERVICE() {
        return SERVICE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.SERVICE
     *
     * @param SERVICE the value for S_APP.SERVICE
     */
    public void setSERVICE(String SERVICE) {
        this.SERVICE = SERVICE == null ? null : SERVICE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.DYNAMIC_MENU
     *
     * @return the value of S_APP.DYNAMIC_MENU
     */
    public String getDYNAMIC_MENU() {
        return DYNAMIC_MENU;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.DYNAMIC_MENU
     *
     * @param DYNAMIC_MENU the value for S_APP.DYNAMIC_MENU
     */
    public void setDYNAMIC_MENU(String DYNAMIC_MENU) {
        this.DYNAMIC_MENU = DYNAMIC_MENU == null ? null : DYNAMIC_MENU.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.SHOW_FORWARD
     *
     * @return the value of S_APP.SHOW_FORWARD
     */
    public String getSHOW_FORWARD() {
        return SHOW_FORWARD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.SHOW_FORWARD
     *
     * @param SHOW_FORWARD the value for S_APP.SHOW_FORWARD
     */
    public void setSHOW_FORWARD(String SHOW_FORWARD) {
        this.SHOW_FORWARD = SHOW_FORWARD == null ? null : SHOW_FORWARD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.TRADE_IN_LOTS
     *
     * @return the value of S_APP.TRADE_IN_LOTS
     */
    public BigDecimal getTRADE_IN_LOTS() {
        return TRADE_IN_LOTS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.TRADE_IN_LOTS
     *
     * @param TRADE_IN_LOTS the value for S_APP.TRADE_IN_LOTS
     */
    public void setTRADE_IN_LOTS(BigDecimal TRADE_IN_LOTS) {
        this.TRADE_IN_LOTS = TRADE_IN_LOTS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.SET_ACCOUNTS
     *
     * @return the value of S_APP.SET_ACCOUNTS
     */
    public BigDecimal getSET_ACCOUNTS() {
        return SET_ACCOUNTS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.SET_ACCOUNTS
     *
     * @param SET_ACCOUNTS the value for S_APP.SET_ACCOUNTS
     */
    public void setSET_ACCOUNTS(BigDecimal SET_ACCOUNTS) {
        this.SET_ACCOUNTS = SET_ACCOUNTS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.AFFECT_COST_WITH_PREMIUM
     *
     * @return the value of S_APP.AFFECT_COST_WITH_PREMIUM
     */
    public String getAFFECT_COST_WITH_PREMIUM() {
        return AFFECT_COST_WITH_PREMIUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.AFFECT_COST_WITH_PREMIUM
     *
     * @param AFFECT_COST_WITH_PREMIUM the value for S_APP.AFFECT_COST_WITH_PREMIUM
     */
    public void setAFFECT_COST_WITH_PREMIUM(String AFFECT_COST_WITH_PREMIUM) {
        this.AFFECT_COST_WITH_PREMIUM = AFFECT_COST_WITH_PREMIUM == null ? null : AFFECT_COST_WITH_PREMIUM.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.CATEG
     *
     * @return the value of S_APP.CATEG
     */
    public BigDecimal getCATEG() {
        return CATEG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.CATEG
     *
     * @param CATEG the value for S_APP.CATEG
     */
    public void setCATEG(BigDecimal CATEG) {
        this.CATEG = CATEG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.APP_INFO
     *
     * @return the value of S_APP.APP_INFO
     */
    public String getAPP_INFO() {
        return APP_INFO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.APP_INFO
     *
     * @param APP_INFO the value for S_APP.APP_INFO
     */
    public void setAPP_INFO(String APP_INFO) {
        this.APP_INFO = APP_INFO == null ? null : APP_INFO.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.SKIP_CHECK_EOM_XACT
     *
     * @return the value of S_APP.SKIP_CHECK_EOM_XACT
     */
    public String getSKIP_CHECK_EOM_XACT() {
        return SKIP_CHECK_EOM_XACT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.SKIP_CHECK_EOM_XACT
     *
     * @param SKIP_CHECK_EOM_XACT the value for S_APP.SKIP_CHECK_EOM_XACT
     */
    public void setSKIP_CHECK_EOM_XACT(String SKIP_CHECK_EOM_XACT) {
        this.SKIP_CHECK_EOM_XACT = SKIP_CHECK_EOM_XACT == null ? null : SKIP_CHECK_EOM_XACT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.TRANSFER_BY_DEAL
     *
     * @return the value of S_APP.TRANSFER_BY_DEAL
     */
    public String getTRANSFER_BY_DEAL() {
        return TRANSFER_BY_DEAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.TRANSFER_BY_DEAL
     *
     * @param TRANSFER_BY_DEAL the value for S_APP.TRANSFER_BY_DEAL
     */
    public void setTRANSFER_BY_DEAL(String TRANSFER_BY_DEAL) {
        this.TRANSFER_BY_DEAL = TRANSFER_BY_DEAL == null ? null : TRANSFER_BY_DEAL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.FAIMS_DATABASE
     *
     * @return the value of S_APP.FAIMS_DATABASE
     */
    public String getFAIMS_DATABASE() {
        return FAIMS_DATABASE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.FAIMS_DATABASE
     *
     * @param FAIMS_DATABASE the value for S_APP.FAIMS_DATABASE
     */
    public void setFAIMS_DATABASE(String FAIMS_DATABASE) {
        this.FAIMS_DATABASE = FAIMS_DATABASE == null ? null : FAIMS_DATABASE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.ACC_GEN_FIX
     *
     * @return the value of S_APP.ACC_GEN_FIX
     */
    public String getACC_GEN_FIX() {
        return ACC_GEN_FIX;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.ACC_GEN_FIX
     *
     * @param ACC_GEN_FIX the value for S_APP.ACC_GEN_FIX
     */
    public void setACC_GEN_FIX(String ACC_GEN_FIX) {
        this.ACC_GEN_FIX = ACC_GEN_FIX == null ? null : ACC_GEN_FIX.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.SHOW_BRIEF_LONG_NAME
     *
     * @return the value of S_APP.SHOW_BRIEF_LONG_NAME
     */
    public String getSHOW_BRIEF_LONG_NAME() {
        return SHOW_BRIEF_LONG_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.SHOW_BRIEF_LONG_NAME
     *
     * @param SHOW_BRIEF_LONG_NAME the value for S_APP.SHOW_BRIEF_LONG_NAME
     */
    public void setSHOW_BRIEF_LONG_NAME(String SHOW_BRIEF_LONG_NAME) {
        this.SHOW_BRIEF_LONG_NAME = SHOW_BRIEF_LONG_NAME == null ? null : SHOW_BRIEF_LONG_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.COUPON_PAYMENT_DED
     *
     * @return the value of S_APP.COUPON_PAYMENT_DED
     */
    public String getCOUPON_PAYMENT_DED() {
        return COUPON_PAYMENT_DED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.COUPON_PAYMENT_DED
     *
     * @param COUPON_PAYMENT_DED the value for S_APP.COUPON_PAYMENT_DED
     */
    public void setCOUPON_PAYMENT_DED(String COUPON_PAYMENT_DED) {
        this.COUPON_PAYMENT_DED = COUPON_PAYMENT_DED == null ? null : COUPON_PAYMENT_DED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.CALC_FX_GL
     *
     * @return the value of S_APP.CALC_FX_GL
     */
    public String getCALC_FX_GL() {
        return CALC_FX_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.CALC_FX_GL
     *
     * @param CALC_FX_GL the value for S_APP.CALC_FX_GL
     */
    public void setCALC_FX_GL(String CALC_FX_GL) {
        this.CALC_FX_GL = CALC_FX_GL == null ? null : CALC_FX_GL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.ACCRUAL_CALC
     *
     * @return the value of S_APP.ACCRUAL_CALC
     */
    public String getACCRUAL_CALC() {
        return ACCRUAL_CALC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.ACCRUAL_CALC
     *
     * @param ACCRUAL_CALC the value for S_APP.ACCRUAL_CALC
     */
    public void setACCRUAL_CALC(String ACCRUAL_CALC) {
        this.ACCRUAL_CALC = ACCRUAL_CALC == null ? null : ACCRUAL_CALC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.APPEON_PATH
     *
     * @return the value of S_APP.APPEON_PATH
     */
    public String getAPPEON_PATH() {
        return APPEON_PATH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.APPEON_PATH
     *
     * @param APPEON_PATH the value for S_APP.APPEON_PATH
     */
    public void setAPPEON_PATH(String APPEON_PATH) {
        this.APPEON_PATH = APPEON_PATH == null ? null : APPEON_PATH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.ENABLE_LANGUAGE
     *
     * @return the value of S_APP.ENABLE_LANGUAGE
     */
    public String getENABLE_LANGUAGE() {
        return ENABLE_LANGUAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.ENABLE_LANGUAGE
     *
     * @param ENABLE_LANGUAGE the value for S_APP.ENABLE_LANGUAGE
     */
    public void setENABLE_LANGUAGE(String ENABLE_LANGUAGE) {
        this.ENABLE_LANGUAGE = ENABLE_LANGUAGE == null ? null : ENABLE_LANGUAGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.LONG_DESC_AR
     *
     * @return the value of S_APP.LONG_DESC_AR
     */
    public String getLONG_DESC_AR() {
        return LONG_DESC_AR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.LONG_DESC_AR
     *
     * @param LONG_DESC_AR the value for S_APP.LONG_DESC_AR
     */
    public void setLONG_DESC_AR(String LONG_DESC_AR) {
        this.LONG_DESC_AR = LONG_DESC_AR == null ? null : LONG_DESC_AR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.LONG_DESC_FR
     *
     * @return the value of S_APP.LONG_DESC_FR
     */
    public String getLONG_DESC_FR() {
        return LONG_DESC_FR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.LONG_DESC_FR
     *
     * @param LONG_DESC_FR the value for S_APP.LONG_DESC_FR
     */
    public void setLONG_DESC_FR(String LONG_DESC_FR) {
        this.LONG_DESC_FR = LONG_DESC_FR == null ? null : LONG_DESC_FR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.APP_DESC_AR
     *
     * @return the value of S_APP.APP_DESC_AR
     */
    public String getAPP_DESC_AR() {
        return APP_DESC_AR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.APP_DESC_AR
     *
     * @param APP_DESC_AR the value for S_APP.APP_DESC_AR
     */
    public void setAPP_DESC_AR(String APP_DESC_AR) {
        this.APP_DESC_AR = APP_DESC_AR == null ? null : APP_DESC_AR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.APP_DESC_FR
     *
     * @return the value of S_APP.APP_DESC_FR
     */
    public String getAPP_DESC_FR() {
        return APP_DESC_FR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.APP_DESC_FR
     *
     * @param APP_DESC_FR the value for S_APP.APP_DESC_FR
     */
    public void setAPP_DESC_FR(String APP_DESC_FR) {
        this.APP_DESC_FR = APP_DESC_FR == null ? null : APP_DESC_FR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.DUAL_PARAM
     *
     * @return the value of S_APP.DUAL_PARAM
     */
    public BigDecimal getDUAL_PARAM() {
        return DUAL_PARAM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.DUAL_PARAM
     *
     * @param DUAL_PARAM the value for S_APP.DUAL_PARAM
     */
    public void setDUAL_PARAM(BigDecimal DUAL_PARAM) {
        this.DUAL_PARAM = DUAL_PARAM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.CHARGES_CY_CALC
     *
     * @return the value of S_APP.CHARGES_CY_CALC
     */
    public String getCHARGES_CY_CALC() {
        return CHARGES_CY_CALC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.CHARGES_CY_CALC
     *
     * @param CHARGES_CY_CALC the value for S_APP.CHARGES_CY_CALC
     */
    public void setCHARGES_CY_CALC(String CHARGES_CY_CALC) {
        this.CHARGES_CY_CALC = CHARGES_CY_CALC == null ? null : CHARGES_CY_CALC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.ENABLE_SWIFT_VAL
     *
     * @return the value of S_APP.ENABLE_SWIFT_VAL
     */
    public String getENABLE_SWIFT_VAL() {
        return ENABLE_SWIFT_VAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.ENABLE_SWIFT_VAL
     *
     * @param ENABLE_SWIFT_VAL the value for S_APP.ENABLE_SWIFT_VAL
     */
    public void setENABLE_SWIFT_VAL(String ENABLE_SWIFT_VAL) {
        this.ENABLE_SWIFT_VAL = ENABLE_SWIFT_VAL == null ? null : ENABLE_SWIFT_VAL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.UPGRADE_ORDER
     *
     * @return the value of S_APP.UPGRADE_ORDER
     */
    public BigDecimal getUPGRADE_ORDER() {
        return UPGRADE_ORDER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.UPGRADE_ORDER
     *
     * @param UPGRADE_ORDER the value for S_APP.UPGRADE_ORDER
     */
    public void setUPGRADE_ORDER(BigDecimal UPGRADE_ORDER) {
        this.UPGRADE_ORDER = UPGRADE_ORDER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.APP_GROUP_CODE
     *
     * @return the value of S_APP.APP_GROUP_CODE
     */
    public BigDecimal getAPP_GROUP_CODE() {
        return APP_GROUP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.APP_GROUP_CODE
     *
     * @param APP_GROUP_CODE the value for S_APP.APP_GROUP_CODE
     */
    public void setAPP_GROUP_CODE(BigDecimal APP_GROUP_CODE) {
        this.APP_GROUP_CODE = APP_GROUP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.COPY_ALL_FOLDERS
     *
     * @return the value of S_APP.COPY_ALL_FOLDERS
     */
    public String getCOPY_ALL_FOLDERS() {
        return COPY_ALL_FOLDERS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.COPY_ALL_FOLDERS
     *
     * @param COPY_ALL_FOLDERS the value for S_APP.COPY_ALL_FOLDERS
     */
    public void setCOPY_ALL_FOLDERS(String COPY_ALL_FOLDERS) {
        this.COPY_ALL_FOLDERS = COPY_ALL_FOLDERS == null ? null : COPY_ALL_FOLDERS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.IS_WEB_YN
     *
     * @return the value of S_APP.IS_WEB_YN
     */
    public BigDecimal getIS_WEB_YN() {
        return IS_WEB_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.IS_WEB_YN
     *
     * @param IS_WEB_YN the value for S_APP.IS_WEB_YN
     */
    public void setIS_WEB_YN(BigDecimal IS_WEB_YN) {
        this.IS_WEB_YN = IS_WEB_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.WEB_VERSION
     *
     * @return the value of S_APP.WEB_VERSION
     */
    public String getWEB_VERSION() {
        return WEB_VERSION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.WEB_VERSION
     *
     * @param WEB_VERSION the value for S_APP.WEB_VERSION
     */
    public void setWEB_VERSION(String WEB_VERSION) {
        this.WEB_VERSION = WEB_VERSION == null ? null : WEB_VERSION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.APP_DESC_RU
     *
     * @return the value of S_APP.APP_DESC_RU
     */
    public String getAPP_DESC_RU() {
        return APP_DESC_RU;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.APP_DESC_RU
     *
     * @param APP_DESC_RU the value for S_APP.APP_DESC_RU
     */
    public void setAPP_DESC_RU(String APP_DESC_RU) {
        this.APP_DESC_RU = APP_DESC_RU == null ? null : APP_DESC_RU.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.APP_DESC_TK
     *
     * @return the value of S_APP.APP_DESC_TK
     */
    public String getAPP_DESC_TK() {
        return APP_DESC_TK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.APP_DESC_TK
     *
     * @param APP_DESC_TK the value for S_APP.APP_DESC_TK
     */
    public void setAPP_DESC_TK(String APP_DESC_TK) {
        this.APP_DESC_TK = APP_DESC_TK == null ? null : APP_DESC_TK.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.LONG_DESC_RU
     *
     * @return the value of S_APP.LONG_DESC_RU
     */
    public String getLONG_DESC_RU() {
        return LONG_DESC_RU;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.LONG_DESC_RU
     *
     * @param LONG_DESC_RU the value for S_APP.LONG_DESC_RU
     */
    public void setLONG_DESC_RU(String LONG_DESC_RU) {
        this.LONG_DESC_RU = LONG_DESC_RU == null ? null : LONG_DESC_RU.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.LONG_DESC_TK
     *
     * @return the value of S_APP.LONG_DESC_TK
     */
    public String getLONG_DESC_TK() {
        return LONG_DESC_TK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.LONG_DESC_TK
     *
     * @param LONG_DESC_TK the value for S_APP.LONG_DESC_TK
     */
    public void setLONG_DESC_TK(String LONG_DESC_TK) {
        this.LONG_DESC_TK = LONG_DESC_TK == null ? null : LONG_DESC_TK.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.LONG_DESC_FA
     *
     * @return the value of S_APP.LONG_DESC_FA
     */
    public String getLONG_DESC_FA() {
        return LONG_DESC_FA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.LONG_DESC_FA
     *
     * @param LONG_DESC_FA the value for S_APP.LONG_DESC_FA
     */
    public void setLONG_DESC_FA(String LONG_DESC_FA) {
        this.LONG_DESC_FA = LONG_DESC_FA == null ? null : LONG_DESC_FA.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.APP_DESC_FA
     *
     * @return the value of S_APP.APP_DESC_FA
     */
    public String getAPP_DESC_FA() {
        return APP_DESC_FA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.APP_DESC_FA
     *
     * @param APP_DESC_FA the value for S_APP.APP_DESC_FA
     */
    public void setAPP_DESC_FA(String APP_DESC_FA) {
        this.APP_DESC_FA = APP_DESC_FA == null ? null : APP_DESC_FA.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.SYNC_CON
     *
     * @return the value of S_APP.SYNC_CON
     */
    public BigDecimal getSYNC_CON() {
        return SYNC_CON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.SYNC_CON
     *
     * @param SYNC_CON the value for S_APP.SYNC_CON
     */
    public void setSYNC_CON(BigDecimal SYNC_CON) {
        this.SYNC_CON = SYNC_CON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.APP_CATEGORY
     *
     * @return the value of S_APP.APP_CATEGORY
     */
    public BigDecimal getAPP_CATEGORY() {
        return APP_CATEGORY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.APP_CATEGORY
     *
     * @param APP_CATEGORY the value for S_APP.APP_CATEGORY
     */
    public void setAPP_CATEGORY(BigDecimal APP_CATEGORY) {
        this.APP_CATEGORY = APP_CATEGORY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.MENU_SHOW_MODE
     *
     * @return the value of S_APP.MENU_SHOW_MODE
     */
    public BigDecimal getMENU_SHOW_MODE() {
        return MENU_SHOW_MODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.MENU_SHOW_MODE
     *
     * @param MENU_SHOW_MODE the value for S_APP.MENU_SHOW_MODE
     */
    public void setMENU_SHOW_MODE(BigDecimal MENU_SHOW_MODE) {
        this.MENU_SHOW_MODE = MENU_SHOW_MODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.CHANGE_TABLE_SCHEMA_YN
     *
     * @return the value of S_APP.CHANGE_TABLE_SCHEMA_YN
     */
    public BigDecimal getCHANGE_TABLE_SCHEMA_YN() {
        return CHANGE_TABLE_SCHEMA_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.CHANGE_TABLE_SCHEMA_YN
     *
     * @param CHANGE_TABLE_SCHEMA_YN the value for S_APP.CHANGE_TABLE_SCHEMA_YN
     */
    public void setCHANGE_TABLE_SCHEMA_YN(BigDecimal CHANGE_TABLE_SCHEMA_YN) {
        this.CHANGE_TABLE_SCHEMA_YN = CHANGE_TABLE_SCHEMA_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.STOP_REPLICATION_WHILE_RUN_YN
     *
     * @return the value of S_APP.STOP_REPLICATION_WHILE_RUN_YN
     */
    public BigDecimal getSTOP_REPLICATION_WHILE_RUN_YN() {
        return STOP_REPLICATION_WHILE_RUN_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.STOP_REPLICATION_WHILE_RUN_YN
     *
     * @param STOP_REPLICATION_WHILE_RUN_YN the value for S_APP.STOP_REPLICATION_WHILE_RUN_YN
     */
    public void setSTOP_REPLICATION_WHILE_RUN_YN(BigDecimal STOP_REPLICATION_WHILE_RUN_YN) {
        this.STOP_REPLICATION_WHILE_RUN_YN = STOP_REPLICATION_WHILE_RUN_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.SCR_VERSION
     *
     * @return the value of S_APP.SCR_VERSION
     */
    public String getSCR_VERSION() {
        return SCR_VERSION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.SCR_VERSION
     *
     * @param SCR_VERSION the value for S_APP.SCR_VERSION
     */
    public void setSCR_VERSION(String SCR_VERSION) {
        this.SCR_VERSION = SCR_VERSION == null ? null : SCR_VERSION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.PRC_VERSION
     *
     * @return the value of S_APP.PRC_VERSION
     */
    public String getPRC_VERSION() {
        return PRC_VERSION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.PRC_VERSION
     *
     * @param PRC_VERSION the value for S_APP.PRC_VERSION
     */
    public void setPRC_VERSION(String PRC_VERSION) {
        this.PRC_VERSION = PRC_VERSION == null ? null : PRC_VERSION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.MAIN_APP_NAME
     *
     * @return the value of S_APP.MAIN_APP_NAME
     */
    public String getMAIN_APP_NAME() {
        return MAIN_APP_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.MAIN_APP_NAME
     *
     * @param MAIN_APP_NAME the value for S_APP.MAIN_APP_NAME
     */
    public void setMAIN_APP_NAME(String MAIN_APP_NAME) {
        this.MAIN_APP_NAME = MAIN_APP_NAME == null ? null : MAIN_APP_NAME.trim();
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.PATCH_NO
     *
     * @return the value of S_APP.PATCH_NO
     */
    public BigDecimal getPATCH_NO() {
        return PATCH_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.PATCH_NO
     *
     * @param OPTION_SEQ the value for S_APP.PATCH_NO
     */
    public void setPATCH_NO(BigDecimal PATCH_NO) {
        this.PATCH_NO = PATCH_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.COMMON_VERSION
     *
     * @return the value of S_APP.COMMON_VERSION
     */
    public String getCOMMON_VERSION() {
        return COMMON_VERSION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.COMMON_VERSION
     *
     * @param MAIN_APP_NAME the value for S_APP.COMMON_VERSION
     */
    public void setCOMMON_VERSION(String COMMON_VERSION) {
        this.COMMON_VERSION = COMMON_VERSION == null ? null : COMMON_VERSION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_APP.BSSCR_VERSION
     *
     * @return the value of S_APP.BSSCR_VERSION
     */
    public String getBSSCR_VERSION() {
        return BSSCR_VERSION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_APP.BSSCR_VERSION
     *
     * @param BSSCR_VERSION the value for S_APP.BSSCR_VERSION
     */
    public void setBSSCR_VERSION(String BSSCR_VERSION) {
        this.BSSCR_VERSION = BSSCR_VERSION == null ? null : BSSCR_VERSION.trim();
    }

	public String getAPP_LOCATION_TYPE() {
		return APP_LOCATION_TYPE;
	}

	public void setAPP_LOCATION_TYPE(String aPP_LOCATION_TYPE) {
		APP_LOCATION_TYPE = aPP_LOCATION_TYPE;
	}

	public String getIS_ADMIN_YN() {
		return IS_ADMIN_YN;
	}

	public void setIS_ADMIN_YN(String iS_ADMIN_YN) {
		IS_ADMIN_YN = iS_ADMIN_YN;
	}

	
	public Date getDATE_UPDATED()
	{
		return DATE_UPDATED;
	}

	
	public void setDATE_UPDATED(Date dATE_UPDATED)
	{
		DATE_UPDATED = dATE_UPDATED;
	}

	
	public String getENABLE_STS_MONITORING_YN()
	{
		return ENABLE_STS_MONITORING_YN;
	}

	
	public void setENABLE_STS_MONITORING_YN(String eNABLE_STS_MONITORING_YN)
	{
		ENABLE_STS_MONITORING_YN = eNABLE_STS_MONITORING_YN;
	}
    
    
}