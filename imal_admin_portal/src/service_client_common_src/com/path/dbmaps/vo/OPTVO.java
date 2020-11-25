package com.path.dbmaps.vo;

import java.math.BigDecimal;

public class OPTVO extends OPTVOKey {
    
    private String level;
    private String parent;
    private String isLeaf;
    private String theKey;
    private String parentKey;

    /**
     * This field corresponds to the database column OPT.PROG_DESC
     */
    private String PROG_DESC;

    /**
     * This field corresponds to the database column OPT.ALLOW_ADD_OPTIONS
     */
    private String ALLOW_ADD_OPTIONS;

    /**
     * This field corresponds to the database column OPT.ADD_OPT_REF
     */
    private String ADD_OPT_REF;

    /**
     * This field corresponds to the database column OPT.AUDIT_SAVE
     */
    private String AUDIT_SAVE;

    /**
     * This field corresponds to the database column OPT.AUDIT_DELETE
     */
    private String AUDIT_DELETE;

    /**
     * This field corresponds to the database column OPT.AUDIT_RETRIEVE
     */
    private String AUDIT_RETRIEVE;

    /**
     * This field corresponds to the database column OPT.MAIN_OPTION_1
     */
    private String MAIN_OPTION_1;

    /**
     * This field corresponds to the database column OPT.MAIN_OPTION_2
     */
    private String MAIN_OPTION_2;

    /**
     * This field corresponds to the database column OPT.PARENT_REF
     */
    private String PARENT_REF;

    /**
     * This field corresponds to the database column OPT.WINDOW_NAME
     */
    private String WINDOW_NAME;

    /**
     * This field corresponds to the database column OPT.PROG_TYPE
     */
    private String PROG_TYPE;

    /**
     * This field corresponds to the database column OPT.PROG_ORDER
     */
    private BigDecimal PROG_ORDER;

    /**
     * This field corresponds to the database column OPT.MENU_TITLE_ARAB
     */
    private String MENU_TITLE_ARAB;

    /**
     * This field corresponds to the database column OPT.MENU_TITLE_ENG
     */
    private String MENU_TITLE_ENG;

    /**
     * This field corresponds to the database column OPT.APP_VERSION
     */
    private BigDecimal APP_VERSION;

    /**
     * This field corresponds to the database column OPT.APP_TYPE
     */
    private String APP_TYPE;

    /**
     * This field corresponds to the database column OPT.DISP_ORDER
     */
    private BigDecimal DISP_ORDER;

    /**
     * This field corresponds to the database column OPT.HELP_PATH
     */
    private String HELP_PATH;

    /**
     * This field corresponds to the database column OPT.HELPFILE_NAME
     */
    private String HELPFILE_NAME;

    /**
     * This field corresponds to the database column OPT.USE_IN_TEMP
     */
    private String USE_IN_TEMP;

    /**
     * This field corresponds to the database column OPT.OPT_TYPE
     */
    private String OPT_TYPE;

    /**
     * This field corresponds to the database column OPT.OPT_CLIENT
     */
    private String OPT_CLIENT;

    /**
     * This field corresponds to the database column OPT.DYNAMIC_OPT
     */
    private String DYNAMIC_OPT;

    /**
     * This field corresponds to the database column OPT.CRUD_PARENT_REF
     */
    private String CRUD_PARENT_REF;

    /**
     * This field corresponds to the database column OPT.MENU_TITLE_FR
     */
    private String MENU_TITLE_FR;

    /**
     * This field corresponds to the database column OPT.PROG_DESC_FR
     */
    private String PROG_DESC_FR;

    /**
     * This field corresponds to the database column OPT.PROG_DESC_ARAB
     */
    private String PROG_DESC_ARAB;

    /**
     * This field corresponds to the database column OPT.CATEG_ID
     */
    private BigDecimal CATEG_ID;

    /**
     * This field corresponds to the database column OPT.MENU_TITLE_FA
     */
    private String MENU_TITLE_FA;

    /**
     * This field corresponds to the database column OPT.PROG_DESC_FA
     */
    private String PROG_DESC_FA;

    /**
     * This field corresponds to the database column OPT.MENU_TITLE_RU
     */
    private String MENU_TITLE_RU;

    /**
     * This field corresponds to the database column OPT.MENU_TITLE_TK
     */
    private String MENU_TITLE_TK;

    /**
     * This field corresponds to the database column OPT.PROG_DESC_RU
     */
    private String PROG_DESC_RU;

    /**
     * This field corresponds to the database column OPT.PROG_DESC_TK
     */
    private String PROG_DESC_TK;

    /**
     * This field corresponds to the database column OPT.ALLOW_DUPLICATE_YN
     */
    private String ALLOW_DUPLICATE_YN;
    
    /**
     * This field corresponds to the database column OPT.IS_VISIBLE_AFTER_BR_CLOSURE_YN
     */
    private String IS_VISIBLE_AFTER_BR_CLOSURE_YN;
    
    /**
     * This field corresponds to the database column OPT.DISABLE_CUSTOMIZATION_YN
     */
    private String DISABLE_CUSTOMIZATION_YN;
    
    /**
     * This field corresponds to the database column OPT.TAX_REG_ID
     */
    private BigDecimal TAX_REG_ID;

    /**
     * This field corresponds to the database column OPT.ACC_RESTRICTION_YN
     */
    private String ACC_RESTRICTION_YN;
    
    private String IS_ADMIN_YN;
    
    private String HR_ADMIN_OPT_YN;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.ACC_RESTRICTION_YN
     *
     * @return the value of OPT.ACC_RESTRICTION_YN
     */
    public String getACC_RESTRICTION_YN() {
        return ACC_RESTRICTION_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.ACC_RESTRICTION_YN
     *
     * @param ACC_RESTRICTION_YN the value for OPT.ACC_RESTRICTION_YN
     */
    public void setACC_RESTRICTION_YN(String ACC_RESTRICTION_YN) {
        this.ACC_RESTRICTION_YN = ACC_RESTRICTION_YN == null ? null : ACC_RESTRICTION_YN.trim();
    }
    
    
    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column OPT.TAX_REG_ID
     * 
     * @return the value of OPT.TAX_REG_ID
     */
    public BigDecimal getTAX_REG_ID()
    {
	return TAX_REG_ID;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column OPT.TAX_REG_ID
     * 
     * @param tAX_REG_ID the value for OPT.TAX_REG_ID
     */
    public void setTAX_REG_ID(BigDecimal tAX_REG_ID)
    {
	TAX_REG_ID = tAX_REG_ID;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.PROG_DESC
     *
     * @return the value of OPT.PROG_DESC
     */
    public String getPROG_DESC() {
        return PROG_DESC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.PROG_DESC
     *
     * @param PROG_DESC the value for OPT.PROG_DESC
     */
    public void setPROG_DESC(String PROG_DESC) {
        this.PROG_DESC = PROG_DESC == null ? null : PROG_DESC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.ALLOW_ADD_OPTIONS
     *
     * @return the value of OPT.ALLOW_ADD_OPTIONS
     */
    public String getALLOW_ADD_OPTIONS() {
        return ALLOW_ADD_OPTIONS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.ALLOW_ADD_OPTIONS
     *
     * @param ALLOW_ADD_OPTIONS the value for OPT.ALLOW_ADD_OPTIONS
     */
    public void setALLOW_ADD_OPTIONS(String ALLOW_ADD_OPTIONS) {
        this.ALLOW_ADD_OPTIONS = ALLOW_ADD_OPTIONS == null ? null : ALLOW_ADD_OPTIONS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.ADD_OPT_REF
     *
     * @return the value of OPT.ADD_OPT_REF
     */
    public String getADD_OPT_REF() {
        return ADD_OPT_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.ADD_OPT_REF
     *
     * @param ADD_OPT_REF the value for OPT.ADD_OPT_REF
     */
    public void setADD_OPT_REF(String ADD_OPT_REF) {
        this.ADD_OPT_REF = ADD_OPT_REF == null ? null : ADD_OPT_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.AUDIT_SAVE
     *
     * @return the value of OPT.AUDIT_SAVE
     */
    public String getAUDIT_SAVE() {
        return AUDIT_SAVE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.AUDIT_SAVE
     *
     * @param AUDIT_SAVE the value for OPT.AUDIT_SAVE
     */
    public void setAUDIT_SAVE(String AUDIT_SAVE) {
        this.AUDIT_SAVE = AUDIT_SAVE == null ? null : AUDIT_SAVE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.AUDIT_DELETE
     *
     * @return the value of OPT.AUDIT_DELETE
     */
    public String getAUDIT_DELETE() {
        return AUDIT_DELETE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.AUDIT_DELETE
     *
     * @param AUDIT_DELETE the value for OPT.AUDIT_DELETE
     */
    public void setAUDIT_DELETE(String AUDIT_DELETE) {
        this.AUDIT_DELETE = AUDIT_DELETE == null ? null : AUDIT_DELETE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.AUDIT_RETRIEVE
     *
     * @return the value of OPT.AUDIT_RETRIEVE
     */
    public String getAUDIT_RETRIEVE() {
        return AUDIT_RETRIEVE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.AUDIT_RETRIEVE
     *
     * @param AUDIT_RETRIEVE the value for OPT.AUDIT_RETRIEVE
     */
    public void setAUDIT_RETRIEVE(String AUDIT_RETRIEVE) {
        this.AUDIT_RETRIEVE = AUDIT_RETRIEVE == null ? null : AUDIT_RETRIEVE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.MAIN_OPTION_1
     *
     * @return the value of OPT.MAIN_OPTION_1
     */
    public String getMAIN_OPTION_1() {
        return MAIN_OPTION_1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.MAIN_OPTION_1
     *
     * @param MAIN_OPTION_1 the value for OPT.MAIN_OPTION_1
     */
    public void setMAIN_OPTION_1(String MAIN_OPTION_1) {
        this.MAIN_OPTION_1 = MAIN_OPTION_1 == null ? null : MAIN_OPTION_1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.MAIN_OPTION_2
     *
     * @return the value of OPT.MAIN_OPTION_2
     */
    public String getMAIN_OPTION_2() {
        return MAIN_OPTION_2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.MAIN_OPTION_2
     *
     * @param MAIN_OPTION_2 the value for OPT.MAIN_OPTION_2
     */
    public void setMAIN_OPTION_2(String MAIN_OPTION_2) {
        this.MAIN_OPTION_2 = MAIN_OPTION_2 == null ? null : MAIN_OPTION_2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.PARENT_REF
     *
     * @return the value of OPT.PARENT_REF
     */
    public String getPARENT_REF() {
        return PARENT_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.PARENT_REF
     *
     * @param PARENT_REF the value for OPT.PARENT_REF
     */
    public void setPARENT_REF(String PARENT_REF) {
        this.PARENT_REF = PARENT_REF == null ? null : PARENT_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.WINDOW_NAME
     *
     * @return the value of OPT.WINDOW_NAME
     */
    public String getWINDOW_NAME() {
        return WINDOW_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.WINDOW_NAME
     *
     * @param WINDOW_NAME the value for OPT.WINDOW_NAME
     */
    public void setWINDOW_NAME(String WINDOW_NAME) {
        this.WINDOW_NAME = WINDOW_NAME == null ? null : WINDOW_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.PROG_TYPE
     *
     * @return the value of OPT.PROG_TYPE
     */
    public String getPROG_TYPE() {
        return PROG_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.PROG_TYPE
     *
     * @param PROG_TYPE the value for OPT.PROG_TYPE
     */
    public void setPROG_TYPE(String PROG_TYPE) {
        this.PROG_TYPE = PROG_TYPE == null ? null : PROG_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.PROG_ORDER
     *
     * @return the value of OPT.PROG_ORDER
     */
    public BigDecimal getPROG_ORDER() {
        return PROG_ORDER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.PROG_ORDER
     *
     * @param PROG_ORDER the value for OPT.PROG_ORDER
     */
    public void setPROG_ORDER(BigDecimal PROG_ORDER) {
        this.PROG_ORDER = PROG_ORDER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.MENU_TITLE_ARAB
     *
     * @return the value of OPT.MENU_TITLE_ARAB
     */
    public String getMENU_TITLE_ARAB() {
        return MENU_TITLE_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.MENU_TITLE_ARAB
     *
     * @param MENU_TITLE_ARAB the value for OPT.MENU_TITLE_ARAB
     */
    public void setMENU_TITLE_ARAB(String MENU_TITLE_ARAB) {
        this.MENU_TITLE_ARAB = MENU_TITLE_ARAB == null ? null : MENU_TITLE_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.MENU_TITLE_ENG
     *
     * @return the value of OPT.MENU_TITLE_ENG
     */
    public String getMENU_TITLE_ENG() {
        return MENU_TITLE_ENG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.MENU_TITLE_ENG
     *
     * @param MENU_TITLE_ENG the value for OPT.MENU_TITLE_ENG
     */
    public void setMENU_TITLE_ENG(String MENU_TITLE_ENG) {
        this.MENU_TITLE_ENG = MENU_TITLE_ENG == null ? null : MENU_TITLE_ENG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.APP_VERSION
     *
     * @return the value of OPT.APP_VERSION
     */
    public BigDecimal getAPP_VERSION() {
        return APP_VERSION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.APP_VERSION
     *
     * @param APP_VERSION the value for OPT.APP_VERSION
     */
    public void setAPP_VERSION(BigDecimal APP_VERSION) {
        this.APP_VERSION = APP_VERSION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.APP_TYPE
     *
     * @return the value of OPT.APP_TYPE
     */
    public String getAPP_TYPE() {
        return APP_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.APP_TYPE
     *
     * @param APP_TYPE the value for OPT.APP_TYPE
     */
    public void setAPP_TYPE(String APP_TYPE) {
        this.APP_TYPE = APP_TYPE == null ? null : APP_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.DISP_ORDER
     *
     * @return the value of OPT.DISP_ORDER
     */
    public BigDecimal getDISP_ORDER() {
        return DISP_ORDER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.DISP_ORDER
     *
     * @param DISP_ORDER the value for OPT.DISP_ORDER
     */
    public void setDISP_ORDER(BigDecimal DISP_ORDER) {
        this.DISP_ORDER = DISP_ORDER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.HELP_PATH
     *
     * @return the value of OPT.HELP_PATH
     */
    public String getHELP_PATH() {
        return HELP_PATH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.HELP_PATH
     *
     * @param HELP_PATH the value for OPT.HELP_PATH
     */
    public void setHELP_PATH(String HELP_PATH) {
        this.HELP_PATH = HELP_PATH == null ? null : HELP_PATH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.HELPFILE_NAME
     *
     * @return the value of OPT.HELPFILE_NAME
     */
    public String getHELPFILE_NAME() {
        return HELPFILE_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.HELPFILE_NAME
     *
     * @param HELPFILE_NAME the value for OPT.HELPFILE_NAME
     */
    public void setHELPFILE_NAME(String HELPFILE_NAME) {
        this.HELPFILE_NAME = HELPFILE_NAME == null ? null : HELPFILE_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.USE_IN_TEMP
     *
     * @return the value of OPT.USE_IN_TEMP
     */
    public String getUSE_IN_TEMP() {
        return USE_IN_TEMP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.USE_IN_TEMP
     *
     * @param USE_IN_TEMP the value for OPT.USE_IN_TEMP
     */
    public void setUSE_IN_TEMP(String USE_IN_TEMP) {
        this.USE_IN_TEMP = USE_IN_TEMP == null ? null : USE_IN_TEMP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.OPT_TYPE
     *
     * @return the value of OPT.OPT_TYPE
     */
    public String getOPT_TYPE() {
        return OPT_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.OPT_TYPE
     *
     * @param OPT_TYPE the value for OPT.OPT_TYPE
     */
    public void setOPT_TYPE(String OPT_TYPE) {
        this.OPT_TYPE = OPT_TYPE == null ? null : OPT_TYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.OPT_CLIENT
     *
     * @return the value of OPT.OPT_CLIENT
     */
    public String getOPT_CLIENT() {
        return OPT_CLIENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.OPT_CLIENT
     *
     * @param OPT_CLIENT the value for OPT.OPT_CLIENT
     */
    public void setOPT_CLIENT(String OPT_CLIENT) {
        this.OPT_CLIENT = OPT_CLIENT == null ? null : OPT_CLIENT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.DYNAMIC_OPT
     *
     * @return the value of OPT.DYNAMIC_OPT
     */
    public String getDYNAMIC_OPT() {
        return DYNAMIC_OPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.DYNAMIC_OPT
     *
     * @param DYNAMIC_OPT the value for OPT.DYNAMIC_OPT
     */
    public void setDYNAMIC_OPT(String DYNAMIC_OPT) {
        this.DYNAMIC_OPT = DYNAMIC_OPT == null ? null : DYNAMIC_OPT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.CRUD_PARENT_REF
     *
     * @return the value of OPT.CRUD_PARENT_REF
     */
    public String getCRUD_PARENT_REF() {
        return CRUD_PARENT_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.CRUD_PARENT_REF
     *
     * @param CRUD_PARENT_REF the value for OPT.CRUD_PARENT_REF
     */
    public void setCRUD_PARENT_REF(String CRUD_PARENT_REF) {
        this.CRUD_PARENT_REF = CRUD_PARENT_REF == null ? null : CRUD_PARENT_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.MENU_TITLE_FR
     *
     * @return the value of OPT.MENU_TITLE_FR
     */
    public String getMENU_TITLE_FR() {
        return MENU_TITLE_FR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.MENU_TITLE_FR
     *
     * @param MENU_TITLE_FR the value for OPT.MENU_TITLE_FR
     */
    public void setMENU_TITLE_FR(String MENU_TITLE_FR) {
        this.MENU_TITLE_FR = MENU_TITLE_FR == null ? null : MENU_TITLE_FR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.PROG_DESC_FR
     *
     * @return the value of OPT.PROG_DESC_FR
     */
    public String getPROG_DESC_FR() {
        return PROG_DESC_FR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.PROG_DESC_FR
     *
     * @param PROG_DESC_FR the value for OPT.PROG_DESC_FR
     */
    public void setPROG_DESC_FR(String PROG_DESC_FR) {
        this.PROG_DESC_FR = PROG_DESC_FR == null ? null : PROG_DESC_FR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.PROG_DESC_ARAB
     *
     * @return the value of OPT.PROG_DESC_ARAB
     */
    public String getPROG_DESC_ARAB() {
        return PROG_DESC_ARAB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.PROG_DESC_ARAB
     *
     * @param PROG_DESC_ARAB the value for OPT.PROG_DESC_ARAB
     */
    public void setPROG_DESC_ARAB(String PROG_DESC_ARAB) {
        this.PROG_DESC_ARAB = PROG_DESC_ARAB == null ? null : PROG_DESC_ARAB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.CATEG_ID
     *
     * @return the value of OPT.CATEG_ID
     */
    public BigDecimal getCATEG_ID() {
        return CATEG_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.CATEG_ID
     *
     * @param CATEG_ID the value for OPT.CATEG_ID
     */
    public void setCATEG_ID(BigDecimal CATEG_ID) {
        this.CATEG_ID = CATEG_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.MENU_TITLE_FA
     *
     * @return the value of OPT.MENU_TITLE_FA
     */
    public String getMENU_TITLE_FA() {
        return MENU_TITLE_FA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.MENU_TITLE_FA
     *
     * @param MENU_TITLE_FA the value for OPT.MENU_TITLE_FA
     */
    public void setMENU_TITLE_FA(String MENU_TITLE_FA) {
        this.MENU_TITLE_FA = MENU_TITLE_FA == null ? null : MENU_TITLE_FA.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.PROG_DESC_FA
     *
     * @return the value of OPT.PROG_DESC_FA
     */
    public String getPROG_DESC_FA() {
        return PROG_DESC_FA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.PROG_DESC_FA
     *
     * @param PROG_DESC_FA the value for OPT.PROG_DESC_FA
     */
    public void setPROG_DESC_FA(String PROG_DESC_FA) {
        this.PROG_DESC_FA = PROG_DESC_FA == null ? null : PROG_DESC_FA.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.MENU_TITLE_RU
     *
     * @return the value of OPT.MENU_TITLE_RU
     */
    public String getMENU_TITLE_RU() {
        return MENU_TITLE_RU;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.MENU_TITLE_RU
     *
     * @param MENU_TITLE_RU the value for OPT.MENU_TITLE_RU
     */
    public void setMENU_TITLE_RU(String MENU_TITLE_RU) {
        this.MENU_TITLE_RU = MENU_TITLE_RU == null ? null : MENU_TITLE_RU.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.MENU_TITLE_TK
     *
     * @return the value of OPT.MENU_TITLE_TK
     */
    public String getMENU_TITLE_TK() {
        return MENU_TITLE_TK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.MENU_TITLE_TK
     *
     * @param MENU_TITLE_TK the value for OPT.MENU_TITLE_TK
     */
    public void setMENU_TITLE_TK(String MENU_TITLE_TK) {
        this.MENU_TITLE_TK = MENU_TITLE_TK == null ? null : MENU_TITLE_TK.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.PROG_DESC_RU
     *
     * @return the value of OPT.PROG_DESC_RU
     */
    public String getPROG_DESC_RU() {
        return PROG_DESC_RU;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.PROG_DESC_RU
     *
     * @param PROG_DESC_RU the value for OPT.PROG_DESC_RU
     */
    public void setPROG_DESC_RU(String PROG_DESC_RU) {
        this.PROG_DESC_RU = PROG_DESC_RU == null ? null : PROG_DESC_RU.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.PROG_DESC_TK
     *
     * @return the value of OPT.PROG_DESC_TK
     */
    public String getPROG_DESC_TK() {
        return PROG_DESC_TK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.PROG_DESC_TK
     *
     * @param PROG_DESC_TK the value for OPT.PROG_DESC_TK
     */
    public void setPROG_DESC_TK(String PROG_DESC_TK) {
        this.PROG_DESC_TK = PROG_DESC_TK == null ? null : PROG_DESC_TK.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OPT.ALLOW_DUPLICATE_YN
     *
     * @return the value of OPT.ALLOW_DUPLICATE_YN
     */
    public String getALLOW_DUPLICATE_YN() {
        return ALLOW_DUPLICATE_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OPT.ALLOW_DUPLICATE_YN
     *
     * @param ALLOW_DUPLICATE_YN the value for OPT.ALLOW_DUPLICATE_YN
     */
    public void setALLOW_DUPLICATE_YN(String ALLOW_DUPLICATE_YN) {
        this.ALLOW_DUPLICATE_YN = ALLOW_DUPLICATE_YN == null ? null : ALLOW_DUPLICATE_YN.trim();
    }

    /**
     * @return the level
     */
    public String getLevel()
    {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level)
    {
        this.level = level;
    }

    /**
     * @return the parent
     */
    public String getParent()
    {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(String parent)
    {
        this.parent = parent;
    }

    /**
     * @return the isLeaf
     */
    public String getIsLeaf()
    {
        return isLeaf;
    }

    /**
     * @param isLeaf the isLeaf to set
     */
    public void setIsLeaf(String isLeaf)
    {
        this.isLeaf = isLeaf;
    }

    /**
     * @return the theKey
     */
    public String getTheKey()
    {
        return theKey;
    }

    /**
     * @param theKey the theKey to set
     */
    public void setTheKey(String theKey)
    {
        this.theKey = theKey;
    }

    /**
     * @return the parentKey
     */
    public String getParentKey()
    {
        return parentKey;
    }

    /**
     * @param parentKey the parentKey to set
     */
    public void setParentKey(String parentKey)
    {
        this.parentKey = parentKey;
    }

    public String getIS_VISIBLE_AFTER_BR_CLOSURE_YN()
    {
        return IS_VISIBLE_AFTER_BR_CLOSURE_YN;
    }

    public void setIS_VISIBLE_AFTER_BR_CLOSURE_YN(String iSVISIBLEAFTERBRCLOSUREYN)
    {
        IS_VISIBLE_AFTER_BR_CLOSURE_YN = iSVISIBLEAFTERBRCLOSUREYN;
    }

    /**
     * @return the dISABLE_CUSTOMIZATION_YN
     */
    public String getDISABLE_CUSTOMIZATION_YN()
    {
        return DISABLE_CUSTOMIZATION_YN;
    }

    /**
     * @param dISABLECUSTOMIZATIONYN the dISABLE_CUSTOMIZATION_YN to set
     */
    public void setDISABLE_CUSTOMIZATION_YN(String dISABLECUSTOMIZATIONYN)
    {
        DISABLE_CUSTOMIZATION_YN = dISABLECUSTOMIZATIONYN;
    }

	public String getIS_ADMIN_YN() {
		return IS_ADMIN_YN;
	}

	public void setIS_ADMIN_YN(String iS_ADMIN_YN) {
		IS_ADMIN_YN = iS_ADMIN_YN;
	}

	public String getHR_ADMIN_OPT_YN() {
		return HR_ADMIN_OPT_YN;
	}

	public void setHR_ADMIN_OPT_YN(String hR_ADMIN_OPT_YN) {
		HR_ADMIN_OPT_YN = hR_ADMIN_OPT_YN;
	}
    
    
}