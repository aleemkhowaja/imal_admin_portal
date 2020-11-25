package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class PMSCONTROLVO extends PMSCONTROLVOKey {
    /**
     * This field corresponds to the database column PMSCONTROL.CURRENCY
     */
    private BigDecimal CURRENCY;

    /**
     * This field corresponds to the database column PMSCONTROL.GL_CODE
     */
    private BigDecimal GL_CODE;

    /**
     * This field corresponds to the database column PMSCONTROL.CIF_SUB_NO
     */
    private BigDecimal CIF_SUB_NO;

    /**
     * This field corresponds to the database column PMSCONTROL.SL_NO
     */
    private BigDecimal SL_NO;

    /**
     * This field corresponds to the database column PMSCONTROL.CLIENT_MAIN_CASH_GL
     */
    private BigDecimal CLIENT_MAIN_CASH_GL;

    /**
     * This field corresponds to the database column PMSCONTROL.CLIENT_MAIN_CASH_CIF
     */
    private BigDecimal CLIENT_MAIN_CASH_CIF;

    /**
     * This field corresponds to the database column PMSCONTROL.CLIENT_MAIN_CASH_SL
     */
    private BigDecimal CLIENT_MAIN_CASH_SL;

    /**
     * This field corresponds to the database column PMSCONTROL.CHANGE_SUB_QTY
     */
    private String CHANGE_SUB_QTY;

    /**
     * This field corresponds to the database column PMSCONTROL.CHANGE_SUB_PRICE
     */
    private String CHANGE_SUB_PRICE;

    /**
     * This field corresponds to the database column PMSCONTROL.CHANGE_RED_QTY
     */
    private String CHANGE_RED_QTY;

    /**
     * This field corresponds to the database column PMSCONTROL.CHANGE_RED_PRICE
     */
    private String CHANGE_RED_PRICE;

    /**
     * This field corresponds to the database column PMSCONTROL.DEF_SUB_TYPE
     */
    private BigDecimal DEF_SUB_TYPE;

    /**
     * This field corresponds to the database column PMSCONTROL.DEF_RED_TYPE
     */
    private BigDecimal DEF_RED_TYPE;

    /**
     * This field corresponds to the database column PMSCONTROL.INTMAN
     */
    private String INTMAN;

    /**
     * This field corresponds to the database column PMSCONTROL.PRINT_SUB
     */
    private String PRINT_SUB;

    /**
     * This field corresponds to the database column PMSCONTROL.PRINT_RED
     */
    private String PRINT_RED;

    /**
     * This field corresponds to the database column PMSCONTROL.AUTHOR_SUB
     */
    private String AUTHOR_SUB;

    /**
     * This field corresponds to the database column PMSCONTROL.AUTHOR_RED
     */
    private String AUTHOR_RED;

    /**
     * This field corresponds to the database column PMSCONTROL.RECOMPUTE_ORDERS_NAV
     */
    private String RECOMPUTE_ORDERS_NAV;

    /**
     * This field corresponds to the database column PMSCONTROL.AUTHOR_ISSUE
     */
    private String AUTHOR_ISSUE;

    /**
     * This field corresponds to the database column PMSCONTROL.SUB_CHECK_CIF
     */
    private String SUB_CHECK_CIF;

    /**
     * This field corresponds to the database column PMSCONTROL.SUB_CHECK_AMF
     */
    private String SUB_CHECK_AMF;

    /**
     * This field corresponds to the database column PMSCONTROL.SUB_CHECK_BAL
     */
    private String SUB_CHECK_BAL;

    /**
     * This field corresponds to the database column PMSCONTROL.RED_CHECK_CIF
     */
    private String RED_CHECK_CIF;

    /**
     * This field corresponds to the database column PMSCONTROL.RED_CHECK_AMF
     */
    private String RED_CHECK_AMF;

    /**
     * This field corresponds to the database column PMSCONTROL.RED_CHECK_BAL
     */
    private String RED_CHECK_BAL;

    /**
     * This field corresponds to the database column PMSCONTROL.CHECK_PF_MODEL
     */
    private String CHECK_PF_MODEL;

    /**
     * This field corresponds to the database column PMSCONTROL.CHECK_UNIT_PRICE
     */
    private String CHECK_UNIT_PRICE;

    /**
     * This field corresponds to the database column PMSCONTROL.SUB_REP_ID
     */
    private BigDecimal SUB_REP_ID;

    /**
     * This field corresponds to the database column PMSCONTROL.RED_REP_ID
     */
    private BigDecimal RED_REP_ID;

    /**
     * This field corresponds to the database column PMSCONTROL.CERTIFICATE_REP_ID
     */
    private BigDecimal CERTIFICATE_REP_ID;

    /**
     * This field corresponds to the database column PMSCONTROL.RED_VALUE_DAYS
     */
    private BigDecimal RED_VALUE_DAYS;

    /**
     * This field corresponds to the database column PMSCONTROL.CREATE_CIF
     */
    private String CREATE_CIF;

    /**
     * This field corresponds to the database column PMSCONTROL.CREATE_PF
     */
    private String CREATE_PF;

    /**
     * This field corresponds to the database column PMSCONTROL.CREATE_INVACC
     */
    private String CREATE_INVACC;

    /**
     * This field corresponds to the database column PMSCONTROL.CREATE_PFCASHACC
     */
    private String CREATE_PFCASHACC;

    /**
     * This field corresponds to the database column PMSCONTROL.CREATE_KCASHACC
     */
    private String CREATE_KCASHACC;

    /**
     * This field corresponds to the database column PMSCONTROL.PF_BASE_CURRENCY
     */
    private BigDecimal PF_BASE_CURRENCY;

    /**
     * This field corresponds to the database column PMSCONTROL.PF_MAIN_MANAGER
     */
    private BigDecimal PF_MAIN_MANAGER;

    /**
     * This field corresponds to the database column PMSCONTROL.PF_CUSTODY_TYPE
     */
    private BigDecimal PF_CUSTODY_TYPE;

    /**
     * This field corresponds to the database column PMSCONTROL.PF_CATG_CODE
     */
    private BigDecimal PF_CATG_CODE;

    /**
     * This field corresponds to the database column PMSCONTROL.AMF_DIV
     */
    private BigDecimal AMF_DIV;

    /**
     * This field corresponds to the database column PMSCONTROL.AMF_DEPT
     */
    private BigDecimal AMF_DEPT;

    /**
     * This field corresponds to the database column PMSCONTROL.PF_BASE_CUR_OPTION
     */
    private String PF_BASE_CUR_OPTION;

    /**
     * This field corresponds to the database column PMSCONTROL.INVACC_GLCODE
     */
    private BigDecimal INVACC_GLCODE;

    /**
     * This field corresponds to the database column PMSCONTROL.PFCASHACC_GLCODE
     */
    private BigDecimal PFCASHACC_GLCODE;

    /**
     * This field corresponds to the database column PMSCONTROL.KCASHACC_GLCODE
     */
    private BigDecimal KCASHACC_GLCODE;

    /**
     * This field corresponds to the database column PMSCONTROL.CREATE_TRSFR_AMF
     */
    private String CREATE_TRSFR_AMF;

    /**
     * This field corresponds to the database column PMSCONTROL.BRANCH
     */
    private BigDecimal BRANCH;

    /**
     * This field corresponds to the database column PMSCONTROL.SHOW_PF_DETAILS
     */
    private String SHOW_PF_DETAILS;

    /**
     * This field corresponds to the database column PMSCONTROL.SHOW_PF_CASH
     */
    private String SHOW_PF_CASH;

    /**
     * This field corresponds to the database column PMSCONTROL.EXCLUDE_INTERBRANCH
     */
    private String EXCLUDE_INTERBRANCH;

    /**
     * This field corresponds to the database column PMSCONTROL.EXCLUDE_YECLOSING
     */
    private String EXCLUDE_YECLOSING;

    /**
     * This field corresponds to the database column PMSCONTROL.CHECK_PE_PURCHASE
     */
    private String CHECK_PE_PURCHASE;

    /**
     * This field corresponds to the database column PMSCONTROL.CHECK_PE_SUB
     */
    private String CHECK_PE_SUB;

    /**
     * This field corresponds to the database column PMSCONTROL.OUT_PRICE
     */
    private BigDecimal OUT_PRICE;

    /**
     * This field corresponds to the database column PMSCONTROL.SHOW_OTHER_AFFACC
     */
    private String SHOW_OTHER_AFFACC;

    /**
     * This field corresponds to the database column PMSCONTROL.DIV_ACC_ENTRY
     */
    private String DIV_ACC_ENTRY;

    /**
     * This field corresponds to the database column PMSCONTROL.BS_COLLECTION
     */
    private String BS_COLLECTION;

    /**
     * This field corresponds to the database column PMSCONTROL.SIGCAP
     */
    private String SIGCAP;

    /**
     * This field corresponds to the database column PMSCONTROL.RETRIEVE_ON
     */
    private String RETRIEVE_ON;

    /**
     * This field corresponds to the database column PMSCONTROL.INCENTIVE_CALC_METHOD
     */
    private String INCENTIVE_CALC_METHOD;

    /**
     * This field corresponds to the database column PMSCONTROL.MINIMUM_PERFORMANCE
     */
    private BigDecimal MINIMUM_PERFORMANCE;

    /**
     * This field corresponds to the database column PMSCONTROL.USE_CIF_AS_ADDREF
     */
    private String USE_CIF_AS_ADDREF;

    /**
     * This field corresponds to the database column PMSCONTROL.USE_FUND_CASH
     */
    private String USE_FUND_CASH;

    /**
     * This field corresponds to the database column PMSCONTROL.BOOK_FEES
     */
    private String BOOK_FEES;

    /**
     * This field corresponds to the database column PMSCONTROL.AFFECT_ALLOC
     */
    private String AFFECT_ALLOC;

    /**
     * This field corresponds to the database column PMSCONTROL.MIN_PERF_YEAR
     */
    private BigDecimal MIN_PERF_YEAR;

    /**
     * This field corresponds to the database column PMSCONTROL.DAILY_DIV
     */
    private String DAILY_DIV;

    /**
     * This field corresponds to the database column PMSCONTROL.LAST_DAILY_DIV_DATE
     */
    private Date LAST_DAILY_DIV_DATE;

    /**
     * This field corresponds to the database column PMSCONTROL.DEAL_ROUND
     */
    private BigDecimal DEAL_ROUND;

    /**
     * This field corresponds to the database column PMSCONTROL.ENABLE_VALUE_DATE
     */
    private BigDecimal ENABLE_VALUE_DATE;

    /**
     * This field corresponds to the database column PMSCONTROL.SUB_SHOW_BROKER
     */
    private String SUB_SHOW_BROKER;

    /**
     * This field corresponds to the database column PMSCONTROL.RED_SHOW_BROKER
     */
    private String RED_SHOW_BROKER;

    /**
     * This field corresponds to the database column PMSCONTROL.SUB_BROKER_CODE
     */
    private BigDecimal SUB_BROKER_CODE;

    /**
     * This field corresponds to the database column PMSCONTROL.RED_BROKER_CODE
     */
    private BigDecimal RED_BROKER_CODE;

    /**
     * This field corresponds to the database column PMSCONTROL.AR_GLCODE
     */
    private BigDecimal AR_GLCODE;

    /**
     * This field corresponds to the database column PMSCONTROL.AP_GLCODE
     */
    private BigDecimal AP_GLCODE;

    /**
     * This field corresponds to the database column PMSCONTROL.DEAL_SMART_CODE
     */
    private BigDecimal DEAL_SMART_CODE;

    /**
     * This field corresponds to the database column PMSCONTROL.AFFECT_ADD_STRING
     */
    private BigDecimal AFFECT_ADD_STRING;

    /**
     * This field corresponds to the database column PMSCONTROL.AFFECT_CHARGES
     */
    private String AFFECT_CHARGES;

    /**
     * This field corresponds to the database column PMSCONTROL.MANDATORY_BR
     */
    private String MANDATORY_BR;

    /**
     * This field corresponds to the database column PMSCONTROL.CHANGE_BR
     */
    private String CHANGE_BR;

    /**
     * This field corresponds to the database column PMSCONTROL.BASE_CHARGES_NET
     */
    private String BASE_CHARGES_NET;

    /**
     * This field corresponds to the database column PMSCONTROL.INCENTIVE_PERC
     */
    private BigDecimal INCENTIVE_PERC;

    /**
     * This field corresponds to the database column PMSCONTROL.SHOW_REALIZED
     */
    private String SHOW_REALIZED;

    /**
     * This field corresponds to the database column PMSCONTROL.INT_CY
     */
    private BigDecimal INT_CY;

    /**
     * This field corresponds to the database column PMSCONTROL.SHOW_PF_NAME
     */
    private String SHOW_PF_NAME;

    /**
     * This field corresponds to the database column PMSCONTROL.RECOMP_SCH_TEMP
     */
    private String RECOMP_SCH_TEMP;

    /**
     * This field corresponds to the database column PMSCONTROL.ROUND_METHOD
     */
    private String ROUND_METHOD;

    /**
     * This field corresponds to the database column PMSCONTROL.VALUE_FLAG
     */
    private String VALUE_FLAG;

    /**
     * This field corresponds to the database column PMSCONTROL.FUND_CAPITAL_BASIS
     */
    private String FUND_CAPITAL_BASIS;

    /**
     * This field corresponds to the database column PMSCONTROL.SEC_PRICE_SORT_ORDER
     */
    private String SEC_PRICE_SORT_ORDER;

    /**
     * This field corresponds to the database column PMSCONTROL.YEARLY_RENTAL_DIV
     */
    private String YEARLY_RENTAL_DIV;

    /**
     * This field corresponds to the database column PMSCONTROL.GENERATED_TD
     */
    private String GENERATED_TD;

    /**
     * This field corresponds to the database column PMSCONTROL.GENERATED_VD
     */
    private String GENERATED_VD;

    /**
     * This field corresponds to the database column PMSCONTROL.SUPPLEMENT
     */
    private String SUPPLEMENT;

    /**
     * This field corresponds to the database column PMSCONTROL.SHARE_CASH
     */
    private String SHARE_CASH;

    /**
     * This field corresponds to the database column PMSCONTROL.DEFAULT_ENTITY
     */
    private String DEFAULT_ENTITY;

    /**
     * This field corresponds to the database column PMSCONTROL.POSTGL_OPT
     */
    private String POSTGL_OPT;

    /**
     * This field corresponds to the database column PMSCONTROL.SUB_CERT_REP_NO
     */
    private BigDecimal SUB_CERT_REP_NO;

    /**
     * This field corresponds to the database column PMSCONTROL.EXCEED_TRADE_RANGE
     */
    private String EXCEED_TRADE_RANGE;

    /**
     * This field corresponds to the database column PMSCONTROL.PERC_RATE
     */
    private String PERC_RATE;

    /**
     * This field corresponds to the database column PMSCONTROL.INC_ACCRUALS
     */
    private String INC_ACCRUALS;

    /**
     * This field corresponds to the database column PMSCONTROL.DED_PAY
     */
    private String DED_PAY;

    /**
     * This field corresponds to the database column PMSCONTROL.AMORT_PER
     */
    private String AMORT_PER;

    /**
     * This field corresponds to the database column PMSCONTROL.MAND_ACC_REV
     */
    private String MAND_ACC_REV;

    /**
     * This field corresponds to the database column PMSCONTROL.MAND_PAY_REC_GL
     */
    private String MAND_PAY_REC_GL;

    /**
     * This field corresponds to the database column PMSCONTROL.ACROSS_BR
     */
    private String ACROSS_BR;

    /**
     * This field corresponds to the database column PMSCONTROL.SHOW_DEP_ACC
     */
    private String SHOW_DEP_ACC;

    /**
     * This field corresponds to the database column PMSCONTROL.RENT_DIV
     */
    private String RENT_DIV;

    /**
     * This field corresponds to the database column PMSCONTROL.SHOW_PF_BID
     */
    private String SHOW_PF_BID;

    /**
     * This field corresponds to the database column PMSCONTROL.DECLARATION_TEMP
     */
    private String DECLARATION_TEMP;

    /**
     * This field corresponds to the database column PMSCONTROL.SHOW_DVID_SEC
     */
    private String SHOW_DVID_SEC;

    /**
     * This field corresponds to the database column PMSCONTROL.CHECK_LIST
     */
    private String CHECK_LIST;

    /**
     * This field corresponds to the database column PMSCONTROL.INC_FEE_PERIOD
     */
    private String INC_FEE_PERIOD;

    /**
     * This field corresponds to the database column PMSCONTROL.UPDATE_JV_REF
     */
    private String UPDATE_JV_REF;

    /**
     * This field corresponds to the database column PMSCONTROL.ALLOC_DEAL_CIF_INC
     */
    private String ALLOC_DEAL_CIF_INC;

    /**
     * This field corresponds to the database column PMSCONTROL.UPDATE_VDATE
     */
    private String UPDATE_VDATE;

    /**
     * This field corresponds to the database column PMSCONTROL.GENERATE_TRADE_DEALS
     */
    private String GENERATE_TRADE_DEALS;

    /**
     * This field corresponds to the database column PMSCONTROL.SPA_GROUP
     */
    private String SPA_GROUP;

    /**
     * This field corresponds to the database column PMSCONTROL.POST_BY_TRXTYPE
     */
    private String POST_BY_TRXTYPE;

    /**
     * This field corresponds to the database column PMSCONTROL.CALL_ENTRY_DATE
     */
    private String CALL_ENTRY_DATE;

    /**
     * This field corresponds to the database column PMSCONTROL.CHANGE_PRICE_COMMIT
     */
    private String CHANGE_PRICE_COMMIT;

    /**
     * This field corresponds to the database column PMSCONTROL.ADD_CHECK_APPROVE
     */
    private String ADD_CHECK_APPROVE;

    /**
     * This field corresponds to the database column PMSCONTROL.DEF_REV_MARKET_PRICE
     */
    private String DEF_REV_MARKET_PRICE;

    /**
     * This field corresponds to the database column PMSCONTROL.BANK_NAME
     */
    private String BANK_NAME;

    /**
     * This field corresponds to the database column PMSCONTROL.PROC_SUB_RED_DATE
     */
    private String PROC_SUB_RED_DATE;

    /**
     * This field corresponds to the database column PMSCONTROL.TRS_AMT_CATG
     */
    private String TRS_AMT_CATG;

    /**
     * This field corresponds to the database column PMSCONTROL.CHECK_AMT
     */
    private String CHECK_AMT;

    /**
     * This field corresponds to the database column PMSCONTROL.INC_FEE_RELOFF_DAYS
     */
    private BigDecimal INC_FEE_RELOFF_DAYS;

    /**
     * This field corresponds to the database column PMSCONTROL.CHECK_REF
     */
    private String CHECK_REF;

    /**
     * This field corresponds to the database column PMSCONTROL.ACC_PROC_REPAYMENT_PLAN
     */
    private String ACC_PROC_REPAYMENT_PLAN;

    /**
     * This field corresponds to the database column PMSCONTROL.ENABLE_COUPON_DUE_DATE
     */
    private String ENABLE_COUPON_DUE_DATE;

    /**
     * This field corresponds to the database column PMSCONTROL.AUTOMATIC_SETTLEMENT
     */
    private String AUTOMATIC_SETTLEMENT;

    /**
     * This field corresponds to the database column PMSCONTROL.PAYMENT_VIA
     */
    private String PAYMENT_VIA;

    /**
     * This field corresponds to the database column PMSCONTROL.TRS_METHOD
     */
    private String TRS_METHOD;

    /**
     * This field corresponds to the database column PMSCONTROL.DOC_LANGUAGE
     */
    private String DOC_LANGUAGE;

    /**
     * This field corresponds to the database column PMSCONTROL.MAND_SALES_OFF
     */
    private String MAND_SALES_OFF;

    /**
     * This field corresponds to the database column PMSCONTROL.SHOW_DEAL_OFFICER
     */
    private String SHOW_DEAL_OFFICER;

    /**
     * This field corresponds to the database column PMSCONTROL.COMMON_LIMITS_FMS
     */
    private String COMMON_LIMITS_FMS;

    /**
     * This field corresponds to the database column PMSCONTROL.CHANGE_FID_ACC
     */
    private String CHANGE_FID_ACC;

    /**
     * This field corresponds to the database column PMSCONTROL.GENERATE_TRADE_ENTRY
     */
    private String GENERATE_TRADE_ENTRY;

    /**
     * This field corresponds to the database column PMSCONTROL.ADD_SWIFT_DET
     */
    private String ADD_SWIFT_DET;

    /**
     * This field corresponds to the database column PMSCONTROL.BLACK_LIST_CHECK
     */
    private String BLACK_LIST_CHECK;

    /**
     * This field corresponds to the database column PMSCONTROL.PF_OPENED_DATE
     */
    private String PF_OPENED_DATE;

    /**
     * This field corresponds to the database column PMSCONTROL.CHECK_ACC_STATUS
     */
    private String CHECK_ACC_STATUS;

    /**
     * This field corresponds to the database column PMSCONTROL.CREATE_PF_TRD
     */
    private String CREATE_PF_TRD;

    /**
     * This field corresponds to the database column PMSCONTROL.BOOK_PREMIUM
     */
    private String BOOK_PREMIUM;

    /**
     * This field corresponds to the database column PMSCONTROL.ZAK_RATE
     */
    private BigDecimal ZAK_RATE;

    /**
     * This field corresponds to the database column PMSCONTROL.XLD_HTM_CATEG
     */
    private String XLD_HTM_CATEG;

    /**
     * This field corresponds to the database column PMSCONTROL.VALID_PAYMNT_DATE
     */
    private String VALID_PAYMNT_DATE;

    /**
     * This field corresponds to the database column PMSCONTROL.FLOAT_RATE_BASE
     */
    private String FLOAT_RATE_BASE;

    /**
     * This field corresponds to the database column PMSCONTROL.EXIT_REP_ID
     */
    private BigDecimal EXIT_REP_ID;

    /**
     * This field corresponds to the database column PMSCONTROL.TRADE_FEES_CALC
     */
    private String TRADE_FEES_CALC;

    /**
     * This field corresponds to the database column PMSCONTROL.SHOW_ADD_AMOUNT
     */
    private String SHOW_ADD_AMOUNT;

    /**
     * This field corresponds to the database column PMSCONTROL.ADD_LABEL
     */
    private String ADD_LABEL;

    /**
     * This field corresponds to the database column PMSCONTROL.AFFECT_INV_ACC
     */
    private String AFFECT_INV_ACC;

    /**
     * This field corresponds to the database column PMSCONTROL.CHECK_LIMIT
     */
    private String CHECK_LIMIT;

    /**
     * This field corresponds to the database column PMSCONTROL.SHOW_QTY_TEXT
     */
    private String SHOW_QTY_TEXT;

    /**
     * This field corresponds to the database column PMSCONTROL.REVAL_COMMON_LIMITS
     */
    private String REVAL_COMMON_LIMITS;

    /**
     * This field corresponds to the database column PMSCONTROL.MARGIN_GLCODE
     */
    private BigDecimal MARGIN_GLCODE;

    /**
     * This field corresponds to the database column PMSCONTROL.REVAL_HISTORICAL_COST
     */
    private String REVAL_HISTORICAL_COST;

    /**
     * This field corresponds to the database column PMSCONTROL.AUTO_SETT_ACTIVE_APPROVED_LIST
     */
    private String AUTO_SETT_ACTIVE_APPROVED_LIST;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CURRENCY
     *
     * @return the value of PMSCONTROL.CURRENCY
     */
    public BigDecimal getCURRENCY() {
        return CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CURRENCY
     *
     * @param CURRENCY the value for PMSCONTROL.CURRENCY
     */
    public void setCURRENCY(BigDecimal CURRENCY) {
        this.CURRENCY = CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.GL_CODE
     *
     * @return the value of PMSCONTROL.GL_CODE
     */
    public BigDecimal getGL_CODE() {
        return GL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.GL_CODE
     *
     * @param GL_CODE the value for PMSCONTROL.GL_CODE
     */
    public void setGL_CODE(BigDecimal GL_CODE) {
        this.GL_CODE = GL_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CIF_SUB_NO
     *
     * @return the value of PMSCONTROL.CIF_SUB_NO
     */
    public BigDecimal getCIF_SUB_NO() {
        return CIF_SUB_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CIF_SUB_NO
     *
     * @param CIF_SUB_NO the value for PMSCONTROL.CIF_SUB_NO
     */
    public void setCIF_SUB_NO(BigDecimal CIF_SUB_NO) {
        this.CIF_SUB_NO = CIF_SUB_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SL_NO
     *
     * @return the value of PMSCONTROL.SL_NO
     */
    public BigDecimal getSL_NO() {
        return SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SL_NO
     *
     * @param SL_NO the value for PMSCONTROL.SL_NO
     */
    public void setSL_NO(BigDecimal SL_NO) {
        this.SL_NO = SL_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CLIENT_MAIN_CASH_GL
     *
     * @return the value of PMSCONTROL.CLIENT_MAIN_CASH_GL
     */
    public BigDecimal getCLIENT_MAIN_CASH_GL() {
        return CLIENT_MAIN_CASH_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CLIENT_MAIN_CASH_GL
     *
     * @param CLIENT_MAIN_CASH_GL the value for PMSCONTROL.CLIENT_MAIN_CASH_GL
     */
    public void setCLIENT_MAIN_CASH_GL(BigDecimal CLIENT_MAIN_CASH_GL) {
        this.CLIENT_MAIN_CASH_GL = CLIENT_MAIN_CASH_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CLIENT_MAIN_CASH_CIF
     *
     * @return the value of PMSCONTROL.CLIENT_MAIN_CASH_CIF
     */
    public BigDecimal getCLIENT_MAIN_CASH_CIF() {
        return CLIENT_MAIN_CASH_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CLIENT_MAIN_CASH_CIF
     *
     * @param CLIENT_MAIN_CASH_CIF the value for PMSCONTROL.CLIENT_MAIN_CASH_CIF
     */
    public void setCLIENT_MAIN_CASH_CIF(BigDecimal CLIENT_MAIN_CASH_CIF) {
        this.CLIENT_MAIN_CASH_CIF = CLIENT_MAIN_CASH_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CLIENT_MAIN_CASH_SL
     *
     * @return the value of PMSCONTROL.CLIENT_MAIN_CASH_SL
     */
    public BigDecimal getCLIENT_MAIN_CASH_SL() {
        return CLIENT_MAIN_CASH_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CLIENT_MAIN_CASH_SL
     *
     * @param CLIENT_MAIN_CASH_SL the value for PMSCONTROL.CLIENT_MAIN_CASH_SL
     */
    public void setCLIENT_MAIN_CASH_SL(BigDecimal CLIENT_MAIN_CASH_SL) {
        this.CLIENT_MAIN_CASH_SL = CLIENT_MAIN_CASH_SL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHANGE_SUB_QTY
     *
     * @return the value of PMSCONTROL.CHANGE_SUB_QTY
     */
    public String getCHANGE_SUB_QTY() {
        return CHANGE_SUB_QTY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHANGE_SUB_QTY
     *
     * @param CHANGE_SUB_QTY the value for PMSCONTROL.CHANGE_SUB_QTY
     */
    public void setCHANGE_SUB_QTY(String CHANGE_SUB_QTY) {
        this.CHANGE_SUB_QTY = CHANGE_SUB_QTY == null ? null : CHANGE_SUB_QTY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHANGE_SUB_PRICE
     *
     * @return the value of PMSCONTROL.CHANGE_SUB_PRICE
     */
    public String getCHANGE_SUB_PRICE() {
        return CHANGE_SUB_PRICE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHANGE_SUB_PRICE
     *
     * @param CHANGE_SUB_PRICE the value for PMSCONTROL.CHANGE_SUB_PRICE
     */
    public void setCHANGE_SUB_PRICE(String CHANGE_SUB_PRICE) {
        this.CHANGE_SUB_PRICE = CHANGE_SUB_PRICE == null ? null : CHANGE_SUB_PRICE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHANGE_RED_QTY
     *
     * @return the value of PMSCONTROL.CHANGE_RED_QTY
     */
    public String getCHANGE_RED_QTY() {
        return CHANGE_RED_QTY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHANGE_RED_QTY
     *
     * @param CHANGE_RED_QTY the value for PMSCONTROL.CHANGE_RED_QTY
     */
    public void setCHANGE_RED_QTY(String CHANGE_RED_QTY) {
        this.CHANGE_RED_QTY = CHANGE_RED_QTY == null ? null : CHANGE_RED_QTY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHANGE_RED_PRICE
     *
     * @return the value of PMSCONTROL.CHANGE_RED_PRICE
     */
    public String getCHANGE_RED_PRICE() {
        return CHANGE_RED_PRICE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHANGE_RED_PRICE
     *
     * @param CHANGE_RED_PRICE the value for PMSCONTROL.CHANGE_RED_PRICE
     */
    public void setCHANGE_RED_PRICE(String CHANGE_RED_PRICE) {
        this.CHANGE_RED_PRICE = CHANGE_RED_PRICE == null ? null : CHANGE_RED_PRICE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.DEF_SUB_TYPE
     *
     * @return the value of PMSCONTROL.DEF_SUB_TYPE
     */
    public BigDecimal getDEF_SUB_TYPE() {
        return DEF_SUB_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.DEF_SUB_TYPE
     *
     * @param DEF_SUB_TYPE the value for PMSCONTROL.DEF_SUB_TYPE
     */
    public void setDEF_SUB_TYPE(BigDecimal DEF_SUB_TYPE) {
        this.DEF_SUB_TYPE = DEF_SUB_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.DEF_RED_TYPE
     *
     * @return the value of PMSCONTROL.DEF_RED_TYPE
     */
    public BigDecimal getDEF_RED_TYPE() {
        return DEF_RED_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.DEF_RED_TYPE
     *
     * @param DEF_RED_TYPE the value for PMSCONTROL.DEF_RED_TYPE
     */
    public void setDEF_RED_TYPE(BigDecimal DEF_RED_TYPE) {
        this.DEF_RED_TYPE = DEF_RED_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.INTMAN
     *
     * @return the value of PMSCONTROL.INTMAN
     */
    public String getINTMAN() {
        return INTMAN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.INTMAN
     *
     * @param INTMAN the value for PMSCONTROL.INTMAN
     */
    public void setINTMAN(String INTMAN) {
        this.INTMAN = INTMAN == null ? null : INTMAN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.PRINT_SUB
     *
     * @return the value of PMSCONTROL.PRINT_SUB
     */
    public String getPRINT_SUB() {
        return PRINT_SUB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.PRINT_SUB
     *
     * @param PRINT_SUB the value for PMSCONTROL.PRINT_SUB
     */
    public void setPRINT_SUB(String PRINT_SUB) {
        this.PRINT_SUB = PRINT_SUB == null ? null : PRINT_SUB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.PRINT_RED
     *
     * @return the value of PMSCONTROL.PRINT_RED
     */
    public String getPRINT_RED() {
        return PRINT_RED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.PRINT_RED
     *
     * @param PRINT_RED the value for PMSCONTROL.PRINT_RED
     */
    public void setPRINT_RED(String PRINT_RED) {
        this.PRINT_RED = PRINT_RED == null ? null : PRINT_RED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AUTHOR_SUB
     *
     * @return the value of PMSCONTROL.AUTHOR_SUB
     */
    public String getAUTHOR_SUB() {
        return AUTHOR_SUB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AUTHOR_SUB
     *
     * @param AUTHOR_SUB the value for PMSCONTROL.AUTHOR_SUB
     */
    public void setAUTHOR_SUB(String AUTHOR_SUB) {
        this.AUTHOR_SUB = AUTHOR_SUB == null ? null : AUTHOR_SUB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AUTHOR_RED
     *
     * @return the value of PMSCONTROL.AUTHOR_RED
     */
    public String getAUTHOR_RED() {
        return AUTHOR_RED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AUTHOR_RED
     *
     * @param AUTHOR_RED the value for PMSCONTROL.AUTHOR_RED
     */
    public void setAUTHOR_RED(String AUTHOR_RED) {
        this.AUTHOR_RED = AUTHOR_RED == null ? null : AUTHOR_RED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.RECOMPUTE_ORDERS_NAV
     *
     * @return the value of PMSCONTROL.RECOMPUTE_ORDERS_NAV
     */
    public String getRECOMPUTE_ORDERS_NAV() {
        return RECOMPUTE_ORDERS_NAV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.RECOMPUTE_ORDERS_NAV
     *
     * @param RECOMPUTE_ORDERS_NAV the value for PMSCONTROL.RECOMPUTE_ORDERS_NAV
     */
    public void setRECOMPUTE_ORDERS_NAV(String RECOMPUTE_ORDERS_NAV) {
        this.RECOMPUTE_ORDERS_NAV = RECOMPUTE_ORDERS_NAV == null ? null : RECOMPUTE_ORDERS_NAV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AUTHOR_ISSUE
     *
     * @return the value of PMSCONTROL.AUTHOR_ISSUE
     */
    public String getAUTHOR_ISSUE() {
        return AUTHOR_ISSUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AUTHOR_ISSUE
     *
     * @param AUTHOR_ISSUE the value for PMSCONTROL.AUTHOR_ISSUE
     */
    public void setAUTHOR_ISSUE(String AUTHOR_ISSUE) {
        this.AUTHOR_ISSUE = AUTHOR_ISSUE == null ? null : AUTHOR_ISSUE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SUB_CHECK_CIF
     *
     * @return the value of PMSCONTROL.SUB_CHECK_CIF
     */
    public String getSUB_CHECK_CIF() {
        return SUB_CHECK_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SUB_CHECK_CIF
     *
     * @param SUB_CHECK_CIF the value for PMSCONTROL.SUB_CHECK_CIF
     */
    public void setSUB_CHECK_CIF(String SUB_CHECK_CIF) {
        this.SUB_CHECK_CIF = SUB_CHECK_CIF == null ? null : SUB_CHECK_CIF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SUB_CHECK_AMF
     *
     * @return the value of PMSCONTROL.SUB_CHECK_AMF
     */
    public String getSUB_CHECK_AMF() {
        return SUB_CHECK_AMF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SUB_CHECK_AMF
     *
     * @param SUB_CHECK_AMF the value for PMSCONTROL.SUB_CHECK_AMF
     */
    public void setSUB_CHECK_AMF(String SUB_CHECK_AMF) {
        this.SUB_CHECK_AMF = SUB_CHECK_AMF == null ? null : SUB_CHECK_AMF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SUB_CHECK_BAL
     *
     * @return the value of PMSCONTROL.SUB_CHECK_BAL
     */
    public String getSUB_CHECK_BAL() {
        return SUB_CHECK_BAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SUB_CHECK_BAL
     *
     * @param SUB_CHECK_BAL the value for PMSCONTROL.SUB_CHECK_BAL
     */
    public void setSUB_CHECK_BAL(String SUB_CHECK_BAL) {
        this.SUB_CHECK_BAL = SUB_CHECK_BAL == null ? null : SUB_CHECK_BAL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.RED_CHECK_CIF
     *
     * @return the value of PMSCONTROL.RED_CHECK_CIF
     */
    public String getRED_CHECK_CIF() {
        return RED_CHECK_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.RED_CHECK_CIF
     *
     * @param RED_CHECK_CIF the value for PMSCONTROL.RED_CHECK_CIF
     */
    public void setRED_CHECK_CIF(String RED_CHECK_CIF) {
        this.RED_CHECK_CIF = RED_CHECK_CIF == null ? null : RED_CHECK_CIF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.RED_CHECK_AMF
     *
     * @return the value of PMSCONTROL.RED_CHECK_AMF
     */
    public String getRED_CHECK_AMF() {
        return RED_CHECK_AMF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.RED_CHECK_AMF
     *
     * @param RED_CHECK_AMF the value for PMSCONTROL.RED_CHECK_AMF
     */
    public void setRED_CHECK_AMF(String RED_CHECK_AMF) {
        this.RED_CHECK_AMF = RED_CHECK_AMF == null ? null : RED_CHECK_AMF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.RED_CHECK_BAL
     *
     * @return the value of PMSCONTROL.RED_CHECK_BAL
     */
    public String getRED_CHECK_BAL() {
        return RED_CHECK_BAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.RED_CHECK_BAL
     *
     * @param RED_CHECK_BAL the value for PMSCONTROL.RED_CHECK_BAL
     */
    public void setRED_CHECK_BAL(String RED_CHECK_BAL) {
        this.RED_CHECK_BAL = RED_CHECK_BAL == null ? null : RED_CHECK_BAL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHECK_PF_MODEL
     *
     * @return the value of PMSCONTROL.CHECK_PF_MODEL
     */
    public String getCHECK_PF_MODEL() {
        return CHECK_PF_MODEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHECK_PF_MODEL
     *
     * @param CHECK_PF_MODEL the value for PMSCONTROL.CHECK_PF_MODEL
     */
    public void setCHECK_PF_MODEL(String CHECK_PF_MODEL) {
        this.CHECK_PF_MODEL = CHECK_PF_MODEL == null ? null : CHECK_PF_MODEL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHECK_UNIT_PRICE
     *
     * @return the value of PMSCONTROL.CHECK_UNIT_PRICE
     */
    public String getCHECK_UNIT_PRICE() {
        return CHECK_UNIT_PRICE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHECK_UNIT_PRICE
     *
     * @param CHECK_UNIT_PRICE the value for PMSCONTROL.CHECK_UNIT_PRICE
     */
    public void setCHECK_UNIT_PRICE(String CHECK_UNIT_PRICE) {
        this.CHECK_UNIT_PRICE = CHECK_UNIT_PRICE == null ? null : CHECK_UNIT_PRICE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SUB_REP_ID
     *
     * @return the value of PMSCONTROL.SUB_REP_ID
     */
    public BigDecimal getSUB_REP_ID() {
        return SUB_REP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SUB_REP_ID
     *
     * @param SUB_REP_ID the value for PMSCONTROL.SUB_REP_ID
     */
    public void setSUB_REP_ID(BigDecimal SUB_REP_ID) {
        this.SUB_REP_ID = SUB_REP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.RED_REP_ID
     *
     * @return the value of PMSCONTROL.RED_REP_ID
     */
    public BigDecimal getRED_REP_ID() {
        return RED_REP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.RED_REP_ID
     *
     * @param RED_REP_ID the value for PMSCONTROL.RED_REP_ID
     */
    public void setRED_REP_ID(BigDecimal RED_REP_ID) {
        this.RED_REP_ID = RED_REP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CERTIFICATE_REP_ID
     *
     * @return the value of PMSCONTROL.CERTIFICATE_REP_ID
     */
    public BigDecimal getCERTIFICATE_REP_ID() {
        return CERTIFICATE_REP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CERTIFICATE_REP_ID
     *
     * @param CERTIFICATE_REP_ID the value for PMSCONTROL.CERTIFICATE_REP_ID
     */
    public void setCERTIFICATE_REP_ID(BigDecimal CERTIFICATE_REP_ID) {
        this.CERTIFICATE_REP_ID = CERTIFICATE_REP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.RED_VALUE_DAYS
     *
     * @return the value of PMSCONTROL.RED_VALUE_DAYS
     */
    public BigDecimal getRED_VALUE_DAYS() {
        return RED_VALUE_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.RED_VALUE_DAYS
     *
     * @param RED_VALUE_DAYS the value for PMSCONTROL.RED_VALUE_DAYS
     */
    public void setRED_VALUE_DAYS(BigDecimal RED_VALUE_DAYS) {
        this.RED_VALUE_DAYS = RED_VALUE_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CREATE_CIF
     *
     * @return the value of PMSCONTROL.CREATE_CIF
     */
    public String getCREATE_CIF() {
        return CREATE_CIF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CREATE_CIF
     *
     * @param CREATE_CIF the value for PMSCONTROL.CREATE_CIF
     */
    public void setCREATE_CIF(String CREATE_CIF) {
        this.CREATE_CIF = CREATE_CIF == null ? null : CREATE_CIF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CREATE_PF
     *
     * @return the value of PMSCONTROL.CREATE_PF
     */
    public String getCREATE_PF() {
        return CREATE_PF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CREATE_PF
     *
     * @param CREATE_PF the value for PMSCONTROL.CREATE_PF
     */
    public void setCREATE_PF(String CREATE_PF) {
        this.CREATE_PF = CREATE_PF == null ? null : CREATE_PF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CREATE_INVACC
     *
     * @return the value of PMSCONTROL.CREATE_INVACC
     */
    public String getCREATE_INVACC() {
        return CREATE_INVACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CREATE_INVACC
     *
     * @param CREATE_INVACC the value for PMSCONTROL.CREATE_INVACC
     */
    public void setCREATE_INVACC(String CREATE_INVACC) {
        this.CREATE_INVACC = CREATE_INVACC == null ? null : CREATE_INVACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CREATE_PFCASHACC
     *
     * @return the value of PMSCONTROL.CREATE_PFCASHACC
     */
    public String getCREATE_PFCASHACC() {
        return CREATE_PFCASHACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CREATE_PFCASHACC
     *
     * @param CREATE_PFCASHACC the value for PMSCONTROL.CREATE_PFCASHACC
     */
    public void setCREATE_PFCASHACC(String CREATE_PFCASHACC) {
        this.CREATE_PFCASHACC = CREATE_PFCASHACC == null ? null : CREATE_PFCASHACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CREATE_KCASHACC
     *
     * @return the value of PMSCONTROL.CREATE_KCASHACC
     */
    public String getCREATE_KCASHACC() {
        return CREATE_KCASHACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CREATE_KCASHACC
     *
     * @param CREATE_KCASHACC the value for PMSCONTROL.CREATE_KCASHACC
     */
    public void setCREATE_KCASHACC(String CREATE_KCASHACC) {
        this.CREATE_KCASHACC = CREATE_KCASHACC == null ? null : CREATE_KCASHACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.PF_BASE_CURRENCY
     *
     * @return the value of PMSCONTROL.PF_BASE_CURRENCY
     */
    public BigDecimal getPF_BASE_CURRENCY() {
        return PF_BASE_CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.PF_BASE_CURRENCY
     *
     * @param PF_BASE_CURRENCY the value for PMSCONTROL.PF_BASE_CURRENCY
     */
    public void setPF_BASE_CURRENCY(BigDecimal PF_BASE_CURRENCY) {
        this.PF_BASE_CURRENCY = PF_BASE_CURRENCY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.PF_MAIN_MANAGER
     *
     * @return the value of PMSCONTROL.PF_MAIN_MANAGER
     */
    public BigDecimal getPF_MAIN_MANAGER() {
        return PF_MAIN_MANAGER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.PF_MAIN_MANAGER
     *
     * @param PF_MAIN_MANAGER the value for PMSCONTROL.PF_MAIN_MANAGER
     */
    public void setPF_MAIN_MANAGER(BigDecimal PF_MAIN_MANAGER) {
        this.PF_MAIN_MANAGER = PF_MAIN_MANAGER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.PF_CUSTODY_TYPE
     *
     * @return the value of PMSCONTROL.PF_CUSTODY_TYPE
     */
    public BigDecimal getPF_CUSTODY_TYPE() {
        return PF_CUSTODY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.PF_CUSTODY_TYPE
     *
     * @param PF_CUSTODY_TYPE the value for PMSCONTROL.PF_CUSTODY_TYPE
     */
    public void setPF_CUSTODY_TYPE(BigDecimal PF_CUSTODY_TYPE) {
        this.PF_CUSTODY_TYPE = PF_CUSTODY_TYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.PF_CATG_CODE
     *
     * @return the value of PMSCONTROL.PF_CATG_CODE
     */
    public BigDecimal getPF_CATG_CODE() {
        return PF_CATG_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.PF_CATG_CODE
     *
     * @param PF_CATG_CODE the value for PMSCONTROL.PF_CATG_CODE
     */
    public void setPF_CATG_CODE(BigDecimal PF_CATG_CODE) {
        this.PF_CATG_CODE = PF_CATG_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AMF_DIV
     *
     * @return the value of PMSCONTROL.AMF_DIV
     */
    public BigDecimal getAMF_DIV() {
        return AMF_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AMF_DIV
     *
     * @param AMF_DIV the value for PMSCONTROL.AMF_DIV
     */
    public void setAMF_DIV(BigDecimal AMF_DIV) {
        this.AMF_DIV = AMF_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AMF_DEPT
     *
     * @return the value of PMSCONTROL.AMF_DEPT
     */
    public BigDecimal getAMF_DEPT() {
        return AMF_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AMF_DEPT
     *
     * @param AMF_DEPT the value for PMSCONTROL.AMF_DEPT
     */
    public void setAMF_DEPT(BigDecimal AMF_DEPT) {
        this.AMF_DEPT = AMF_DEPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.PF_BASE_CUR_OPTION
     *
     * @return the value of PMSCONTROL.PF_BASE_CUR_OPTION
     */
    public String getPF_BASE_CUR_OPTION() {
        return PF_BASE_CUR_OPTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.PF_BASE_CUR_OPTION
     *
     * @param PF_BASE_CUR_OPTION the value for PMSCONTROL.PF_BASE_CUR_OPTION
     */
    public void setPF_BASE_CUR_OPTION(String PF_BASE_CUR_OPTION) {
        this.PF_BASE_CUR_OPTION = PF_BASE_CUR_OPTION == null ? null : PF_BASE_CUR_OPTION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.INVACC_GLCODE
     *
     * @return the value of PMSCONTROL.INVACC_GLCODE
     */
    public BigDecimal getINVACC_GLCODE() {
        return INVACC_GLCODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.INVACC_GLCODE
     *
     * @param INVACC_GLCODE the value for PMSCONTROL.INVACC_GLCODE
     */
    public void setINVACC_GLCODE(BigDecimal INVACC_GLCODE) {
        this.INVACC_GLCODE = INVACC_GLCODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.PFCASHACC_GLCODE
     *
     * @return the value of PMSCONTROL.PFCASHACC_GLCODE
     */
    public BigDecimal getPFCASHACC_GLCODE() {
        return PFCASHACC_GLCODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.PFCASHACC_GLCODE
     *
     * @param PFCASHACC_GLCODE the value for PMSCONTROL.PFCASHACC_GLCODE
     */
    public void setPFCASHACC_GLCODE(BigDecimal PFCASHACC_GLCODE) {
        this.PFCASHACC_GLCODE = PFCASHACC_GLCODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.KCASHACC_GLCODE
     *
     * @return the value of PMSCONTROL.KCASHACC_GLCODE
     */
    public BigDecimal getKCASHACC_GLCODE() {
        return KCASHACC_GLCODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.KCASHACC_GLCODE
     *
     * @param KCASHACC_GLCODE the value for PMSCONTROL.KCASHACC_GLCODE
     */
    public void setKCASHACC_GLCODE(BigDecimal KCASHACC_GLCODE) {
        this.KCASHACC_GLCODE = KCASHACC_GLCODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CREATE_TRSFR_AMF
     *
     * @return the value of PMSCONTROL.CREATE_TRSFR_AMF
     */
    public String getCREATE_TRSFR_AMF() {
        return CREATE_TRSFR_AMF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CREATE_TRSFR_AMF
     *
     * @param CREATE_TRSFR_AMF the value for PMSCONTROL.CREATE_TRSFR_AMF
     */
    public void setCREATE_TRSFR_AMF(String CREATE_TRSFR_AMF) {
        this.CREATE_TRSFR_AMF = CREATE_TRSFR_AMF == null ? null : CREATE_TRSFR_AMF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.BRANCH
     *
     * @return the value of PMSCONTROL.BRANCH
     */
    public BigDecimal getBRANCH() {
        return BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.BRANCH
     *
     * @param BRANCH the value for PMSCONTROL.BRANCH
     */
    public void setBRANCH(BigDecimal BRANCH) {
        this.BRANCH = BRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SHOW_PF_DETAILS
     *
     * @return the value of PMSCONTROL.SHOW_PF_DETAILS
     */
    public String getSHOW_PF_DETAILS() {
        return SHOW_PF_DETAILS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SHOW_PF_DETAILS
     *
     * @param SHOW_PF_DETAILS the value for PMSCONTROL.SHOW_PF_DETAILS
     */
    public void setSHOW_PF_DETAILS(String SHOW_PF_DETAILS) {
        this.SHOW_PF_DETAILS = SHOW_PF_DETAILS == null ? null : SHOW_PF_DETAILS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SHOW_PF_CASH
     *
     * @return the value of PMSCONTROL.SHOW_PF_CASH
     */
    public String getSHOW_PF_CASH() {
        return SHOW_PF_CASH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SHOW_PF_CASH
     *
     * @param SHOW_PF_CASH the value for PMSCONTROL.SHOW_PF_CASH
     */
    public void setSHOW_PF_CASH(String SHOW_PF_CASH) {
        this.SHOW_PF_CASH = SHOW_PF_CASH == null ? null : SHOW_PF_CASH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.EXCLUDE_INTERBRANCH
     *
     * @return the value of PMSCONTROL.EXCLUDE_INTERBRANCH
     */
    public String getEXCLUDE_INTERBRANCH() {
        return EXCLUDE_INTERBRANCH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.EXCLUDE_INTERBRANCH
     *
     * @param EXCLUDE_INTERBRANCH the value for PMSCONTROL.EXCLUDE_INTERBRANCH
     */
    public void setEXCLUDE_INTERBRANCH(String EXCLUDE_INTERBRANCH) {
        this.EXCLUDE_INTERBRANCH = EXCLUDE_INTERBRANCH == null ? null : EXCLUDE_INTERBRANCH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.EXCLUDE_YECLOSING
     *
     * @return the value of PMSCONTROL.EXCLUDE_YECLOSING
     */
    public String getEXCLUDE_YECLOSING() {
        return EXCLUDE_YECLOSING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.EXCLUDE_YECLOSING
     *
     * @param EXCLUDE_YECLOSING the value for PMSCONTROL.EXCLUDE_YECLOSING
     */
    public void setEXCLUDE_YECLOSING(String EXCLUDE_YECLOSING) {
        this.EXCLUDE_YECLOSING = EXCLUDE_YECLOSING == null ? null : EXCLUDE_YECLOSING.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHECK_PE_PURCHASE
     *
     * @return the value of PMSCONTROL.CHECK_PE_PURCHASE
     */
    public String getCHECK_PE_PURCHASE() {
        return CHECK_PE_PURCHASE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHECK_PE_PURCHASE
     *
     * @param CHECK_PE_PURCHASE the value for PMSCONTROL.CHECK_PE_PURCHASE
     */
    public void setCHECK_PE_PURCHASE(String CHECK_PE_PURCHASE) {
        this.CHECK_PE_PURCHASE = CHECK_PE_PURCHASE == null ? null : CHECK_PE_PURCHASE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHECK_PE_SUB
     *
     * @return the value of PMSCONTROL.CHECK_PE_SUB
     */
    public String getCHECK_PE_SUB() {
        return CHECK_PE_SUB;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHECK_PE_SUB
     *
     * @param CHECK_PE_SUB the value for PMSCONTROL.CHECK_PE_SUB
     */
    public void setCHECK_PE_SUB(String CHECK_PE_SUB) {
        this.CHECK_PE_SUB = CHECK_PE_SUB == null ? null : CHECK_PE_SUB.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.OUT_PRICE
     *
     * @return the value of PMSCONTROL.OUT_PRICE
     */
    public BigDecimal getOUT_PRICE() {
        return OUT_PRICE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.OUT_PRICE
     *
     * @param OUT_PRICE the value for PMSCONTROL.OUT_PRICE
     */
    public void setOUT_PRICE(BigDecimal OUT_PRICE) {
        this.OUT_PRICE = OUT_PRICE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SHOW_OTHER_AFFACC
     *
     * @return the value of PMSCONTROL.SHOW_OTHER_AFFACC
     */
    public String getSHOW_OTHER_AFFACC() {
        return SHOW_OTHER_AFFACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SHOW_OTHER_AFFACC
     *
     * @param SHOW_OTHER_AFFACC the value for PMSCONTROL.SHOW_OTHER_AFFACC
     */
    public void setSHOW_OTHER_AFFACC(String SHOW_OTHER_AFFACC) {
        this.SHOW_OTHER_AFFACC = SHOW_OTHER_AFFACC == null ? null : SHOW_OTHER_AFFACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.DIV_ACC_ENTRY
     *
     * @return the value of PMSCONTROL.DIV_ACC_ENTRY
     */
    public String getDIV_ACC_ENTRY() {
        return DIV_ACC_ENTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.DIV_ACC_ENTRY
     *
     * @param DIV_ACC_ENTRY the value for PMSCONTROL.DIV_ACC_ENTRY
     */
    public void setDIV_ACC_ENTRY(String DIV_ACC_ENTRY) {
        this.DIV_ACC_ENTRY = DIV_ACC_ENTRY == null ? null : DIV_ACC_ENTRY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.BS_COLLECTION
     *
     * @return the value of PMSCONTROL.BS_COLLECTION
     */
    public String getBS_COLLECTION() {
        return BS_COLLECTION;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.BS_COLLECTION
     *
     * @param BS_COLLECTION the value for PMSCONTROL.BS_COLLECTION
     */
    public void setBS_COLLECTION(String BS_COLLECTION) {
        this.BS_COLLECTION = BS_COLLECTION == null ? null : BS_COLLECTION.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SIGCAP
     *
     * @return the value of PMSCONTROL.SIGCAP
     */
    public String getSIGCAP() {
        return SIGCAP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SIGCAP
     *
     * @param SIGCAP the value for PMSCONTROL.SIGCAP
     */
    public void setSIGCAP(String SIGCAP) {
        this.SIGCAP = SIGCAP == null ? null : SIGCAP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.RETRIEVE_ON
     *
     * @return the value of PMSCONTROL.RETRIEVE_ON
     */
    public String getRETRIEVE_ON() {
        return RETRIEVE_ON;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.RETRIEVE_ON
     *
     * @param RETRIEVE_ON the value for PMSCONTROL.RETRIEVE_ON
     */
    public void setRETRIEVE_ON(String RETRIEVE_ON) {
        this.RETRIEVE_ON = RETRIEVE_ON == null ? null : RETRIEVE_ON.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.INCENTIVE_CALC_METHOD
     *
     * @return the value of PMSCONTROL.INCENTIVE_CALC_METHOD
     */
    public String getINCENTIVE_CALC_METHOD() {
        return INCENTIVE_CALC_METHOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.INCENTIVE_CALC_METHOD
     *
     * @param INCENTIVE_CALC_METHOD the value for PMSCONTROL.INCENTIVE_CALC_METHOD
     */
    public void setINCENTIVE_CALC_METHOD(String INCENTIVE_CALC_METHOD) {
        this.INCENTIVE_CALC_METHOD = INCENTIVE_CALC_METHOD == null ? null : INCENTIVE_CALC_METHOD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.MINIMUM_PERFORMANCE
     *
     * @return the value of PMSCONTROL.MINIMUM_PERFORMANCE
     */
    public BigDecimal getMINIMUM_PERFORMANCE() {
        return MINIMUM_PERFORMANCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.MINIMUM_PERFORMANCE
     *
     * @param MINIMUM_PERFORMANCE the value for PMSCONTROL.MINIMUM_PERFORMANCE
     */
    public void setMINIMUM_PERFORMANCE(BigDecimal MINIMUM_PERFORMANCE) {
        this.MINIMUM_PERFORMANCE = MINIMUM_PERFORMANCE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.USE_CIF_AS_ADDREF
     *
     * @return the value of PMSCONTROL.USE_CIF_AS_ADDREF
     */
    public String getUSE_CIF_AS_ADDREF() {
        return USE_CIF_AS_ADDREF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.USE_CIF_AS_ADDREF
     *
     * @param USE_CIF_AS_ADDREF the value for PMSCONTROL.USE_CIF_AS_ADDREF
     */
    public void setUSE_CIF_AS_ADDREF(String USE_CIF_AS_ADDREF) {
        this.USE_CIF_AS_ADDREF = USE_CIF_AS_ADDREF == null ? null : USE_CIF_AS_ADDREF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.USE_FUND_CASH
     *
     * @return the value of PMSCONTROL.USE_FUND_CASH
     */
    public String getUSE_FUND_CASH() {
        return USE_FUND_CASH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.USE_FUND_CASH
     *
     * @param USE_FUND_CASH the value for PMSCONTROL.USE_FUND_CASH
     */
    public void setUSE_FUND_CASH(String USE_FUND_CASH) {
        this.USE_FUND_CASH = USE_FUND_CASH == null ? null : USE_FUND_CASH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.BOOK_FEES
     *
     * @return the value of PMSCONTROL.BOOK_FEES
     */
    public String getBOOK_FEES() {
        return BOOK_FEES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.BOOK_FEES
     *
     * @param BOOK_FEES the value for PMSCONTROL.BOOK_FEES
     */
    public void setBOOK_FEES(String BOOK_FEES) {
        this.BOOK_FEES = BOOK_FEES == null ? null : BOOK_FEES.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AFFECT_ALLOC
     *
     * @return the value of PMSCONTROL.AFFECT_ALLOC
     */
    public String getAFFECT_ALLOC() {
        return AFFECT_ALLOC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AFFECT_ALLOC
     *
     * @param AFFECT_ALLOC the value for PMSCONTROL.AFFECT_ALLOC
     */
    public void setAFFECT_ALLOC(String AFFECT_ALLOC) {
        this.AFFECT_ALLOC = AFFECT_ALLOC == null ? null : AFFECT_ALLOC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.MIN_PERF_YEAR
     *
     * @return the value of PMSCONTROL.MIN_PERF_YEAR
     */
    public BigDecimal getMIN_PERF_YEAR() {
        return MIN_PERF_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.MIN_PERF_YEAR
     *
     * @param MIN_PERF_YEAR the value for PMSCONTROL.MIN_PERF_YEAR
     */
    public void setMIN_PERF_YEAR(BigDecimal MIN_PERF_YEAR) {
        this.MIN_PERF_YEAR = MIN_PERF_YEAR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.DAILY_DIV
     *
     * @return the value of PMSCONTROL.DAILY_DIV
     */
    public String getDAILY_DIV() {
        return DAILY_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.DAILY_DIV
     *
     * @param DAILY_DIV the value for PMSCONTROL.DAILY_DIV
     */
    public void setDAILY_DIV(String DAILY_DIV) {
        this.DAILY_DIV = DAILY_DIV == null ? null : DAILY_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.LAST_DAILY_DIV_DATE
     *
     * @return the value of PMSCONTROL.LAST_DAILY_DIV_DATE
     */
    public Date getLAST_DAILY_DIV_DATE() {
        return LAST_DAILY_DIV_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.LAST_DAILY_DIV_DATE
     *
     * @param LAST_DAILY_DIV_DATE the value for PMSCONTROL.LAST_DAILY_DIV_DATE
     */
    public void setLAST_DAILY_DIV_DATE(Date LAST_DAILY_DIV_DATE) {
        this.LAST_DAILY_DIV_DATE = LAST_DAILY_DIV_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.DEAL_ROUND
     *
     * @return the value of PMSCONTROL.DEAL_ROUND
     */
    public BigDecimal getDEAL_ROUND() {
        return DEAL_ROUND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.DEAL_ROUND
     *
     * @param DEAL_ROUND the value for PMSCONTROL.DEAL_ROUND
     */
    public void setDEAL_ROUND(BigDecimal DEAL_ROUND) {
        this.DEAL_ROUND = DEAL_ROUND;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.ENABLE_VALUE_DATE
     *
     * @return the value of PMSCONTROL.ENABLE_VALUE_DATE
     */
    public BigDecimal getENABLE_VALUE_DATE() {
        return ENABLE_VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.ENABLE_VALUE_DATE
     *
     * @param ENABLE_VALUE_DATE the value for PMSCONTROL.ENABLE_VALUE_DATE
     */
    public void setENABLE_VALUE_DATE(BigDecimal ENABLE_VALUE_DATE) {
        this.ENABLE_VALUE_DATE = ENABLE_VALUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SUB_SHOW_BROKER
     *
     * @return the value of PMSCONTROL.SUB_SHOW_BROKER
     */
    public String getSUB_SHOW_BROKER() {
        return SUB_SHOW_BROKER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SUB_SHOW_BROKER
     *
     * @param SUB_SHOW_BROKER the value for PMSCONTROL.SUB_SHOW_BROKER
     */
    public void setSUB_SHOW_BROKER(String SUB_SHOW_BROKER) {
        this.SUB_SHOW_BROKER = SUB_SHOW_BROKER == null ? null : SUB_SHOW_BROKER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.RED_SHOW_BROKER
     *
     * @return the value of PMSCONTROL.RED_SHOW_BROKER
     */
    public String getRED_SHOW_BROKER() {
        return RED_SHOW_BROKER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.RED_SHOW_BROKER
     *
     * @param RED_SHOW_BROKER the value for PMSCONTROL.RED_SHOW_BROKER
     */
    public void setRED_SHOW_BROKER(String RED_SHOW_BROKER) {
        this.RED_SHOW_BROKER = RED_SHOW_BROKER == null ? null : RED_SHOW_BROKER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SUB_BROKER_CODE
     *
     * @return the value of PMSCONTROL.SUB_BROKER_CODE
     */
    public BigDecimal getSUB_BROKER_CODE() {
        return SUB_BROKER_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SUB_BROKER_CODE
     *
     * @param SUB_BROKER_CODE the value for PMSCONTROL.SUB_BROKER_CODE
     */
    public void setSUB_BROKER_CODE(BigDecimal SUB_BROKER_CODE) {
        this.SUB_BROKER_CODE = SUB_BROKER_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.RED_BROKER_CODE
     *
     * @return the value of PMSCONTROL.RED_BROKER_CODE
     */
    public BigDecimal getRED_BROKER_CODE() {
        return RED_BROKER_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.RED_BROKER_CODE
     *
     * @param RED_BROKER_CODE the value for PMSCONTROL.RED_BROKER_CODE
     */
    public void setRED_BROKER_CODE(BigDecimal RED_BROKER_CODE) {
        this.RED_BROKER_CODE = RED_BROKER_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AR_GLCODE
     *
     * @return the value of PMSCONTROL.AR_GLCODE
     */
    public BigDecimal getAR_GLCODE() {
        return AR_GLCODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AR_GLCODE
     *
     * @param AR_GLCODE the value for PMSCONTROL.AR_GLCODE
     */
    public void setAR_GLCODE(BigDecimal AR_GLCODE) {
        this.AR_GLCODE = AR_GLCODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AP_GLCODE
     *
     * @return the value of PMSCONTROL.AP_GLCODE
     */
    public BigDecimal getAP_GLCODE() {
        return AP_GLCODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AP_GLCODE
     *
     * @param AP_GLCODE the value for PMSCONTROL.AP_GLCODE
     */
    public void setAP_GLCODE(BigDecimal AP_GLCODE) {
        this.AP_GLCODE = AP_GLCODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.DEAL_SMART_CODE
     *
     * @return the value of PMSCONTROL.DEAL_SMART_CODE
     */
    public BigDecimal getDEAL_SMART_CODE() {
        return DEAL_SMART_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.DEAL_SMART_CODE
     *
     * @param DEAL_SMART_CODE the value for PMSCONTROL.DEAL_SMART_CODE
     */
    public void setDEAL_SMART_CODE(BigDecimal DEAL_SMART_CODE) {
        this.DEAL_SMART_CODE = DEAL_SMART_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AFFECT_ADD_STRING
     *
     * @return the value of PMSCONTROL.AFFECT_ADD_STRING
     */
    public BigDecimal getAFFECT_ADD_STRING() {
        return AFFECT_ADD_STRING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AFFECT_ADD_STRING
     *
     * @param AFFECT_ADD_STRING the value for PMSCONTROL.AFFECT_ADD_STRING
     */
    public void setAFFECT_ADD_STRING(BigDecimal AFFECT_ADD_STRING) {
        this.AFFECT_ADD_STRING = AFFECT_ADD_STRING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AFFECT_CHARGES
     *
     * @return the value of PMSCONTROL.AFFECT_CHARGES
     */
    public String getAFFECT_CHARGES() {
        return AFFECT_CHARGES;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AFFECT_CHARGES
     *
     * @param AFFECT_CHARGES the value for PMSCONTROL.AFFECT_CHARGES
     */
    public void setAFFECT_CHARGES(String AFFECT_CHARGES) {
        this.AFFECT_CHARGES = AFFECT_CHARGES == null ? null : AFFECT_CHARGES.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.MANDATORY_BR
     *
     * @return the value of PMSCONTROL.MANDATORY_BR
     */
    public String getMANDATORY_BR() {
        return MANDATORY_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.MANDATORY_BR
     *
     * @param MANDATORY_BR the value for PMSCONTROL.MANDATORY_BR
     */
    public void setMANDATORY_BR(String MANDATORY_BR) {
        this.MANDATORY_BR = MANDATORY_BR == null ? null : MANDATORY_BR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHANGE_BR
     *
     * @return the value of PMSCONTROL.CHANGE_BR
     */
    public String getCHANGE_BR() {
        return CHANGE_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHANGE_BR
     *
     * @param CHANGE_BR the value for PMSCONTROL.CHANGE_BR
     */
    public void setCHANGE_BR(String CHANGE_BR) {
        this.CHANGE_BR = CHANGE_BR == null ? null : CHANGE_BR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.BASE_CHARGES_NET
     *
     * @return the value of PMSCONTROL.BASE_CHARGES_NET
     */
    public String getBASE_CHARGES_NET() {
        return BASE_CHARGES_NET;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.BASE_CHARGES_NET
     *
     * @param BASE_CHARGES_NET the value for PMSCONTROL.BASE_CHARGES_NET
     */
    public void setBASE_CHARGES_NET(String BASE_CHARGES_NET) {
        this.BASE_CHARGES_NET = BASE_CHARGES_NET == null ? null : BASE_CHARGES_NET.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.INCENTIVE_PERC
     *
     * @return the value of PMSCONTROL.INCENTIVE_PERC
     */
    public BigDecimal getINCENTIVE_PERC() {
        return INCENTIVE_PERC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.INCENTIVE_PERC
     *
     * @param INCENTIVE_PERC the value for PMSCONTROL.INCENTIVE_PERC
     */
    public void setINCENTIVE_PERC(BigDecimal INCENTIVE_PERC) {
        this.INCENTIVE_PERC = INCENTIVE_PERC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SHOW_REALIZED
     *
     * @return the value of PMSCONTROL.SHOW_REALIZED
     */
    public String getSHOW_REALIZED() {
        return SHOW_REALIZED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SHOW_REALIZED
     *
     * @param SHOW_REALIZED the value for PMSCONTROL.SHOW_REALIZED
     */
    public void setSHOW_REALIZED(String SHOW_REALIZED) {
        this.SHOW_REALIZED = SHOW_REALIZED == null ? null : SHOW_REALIZED.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.INT_CY
     *
     * @return the value of PMSCONTROL.INT_CY
     */
    public BigDecimal getINT_CY() {
        return INT_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.INT_CY
     *
     * @param INT_CY the value for PMSCONTROL.INT_CY
     */
    public void setINT_CY(BigDecimal INT_CY) {
        this.INT_CY = INT_CY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SHOW_PF_NAME
     *
     * @return the value of PMSCONTROL.SHOW_PF_NAME
     */
    public String getSHOW_PF_NAME() {
        return SHOW_PF_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SHOW_PF_NAME
     *
     * @param SHOW_PF_NAME the value for PMSCONTROL.SHOW_PF_NAME
     */
    public void setSHOW_PF_NAME(String SHOW_PF_NAME) {
        this.SHOW_PF_NAME = SHOW_PF_NAME == null ? null : SHOW_PF_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.RECOMP_SCH_TEMP
     *
     * @return the value of PMSCONTROL.RECOMP_SCH_TEMP
     */
    public String getRECOMP_SCH_TEMP() {
        return RECOMP_SCH_TEMP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.RECOMP_SCH_TEMP
     *
     * @param RECOMP_SCH_TEMP the value for PMSCONTROL.RECOMP_SCH_TEMP
     */
    public void setRECOMP_SCH_TEMP(String RECOMP_SCH_TEMP) {
        this.RECOMP_SCH_TEMP = RECOMP_SCH_TEMP == null ? null : RECOMP_SCH_TEMP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.ROUND_METHOD
     *
     * @return the value of PMSCONTROL.ROUND_METHOD
     */
    public String getROUND_METHOD() {
        return ROUND_METHOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.ROUND_METHOD
     *
     * @param ROUND_METHOD the value for PMSCONTROL.ROUND_METHOD
     */
    public void setROUND_METHOD(String ROUND_METHOD) {
        this.ROUND_METHOD = ROUND_METHOD == null ? null : ROUND_METHOD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.VALUE_FLAG
     *
     * @return the value of PMSCONTROL.VALUE_FLAG
     */
    public String getVALUE_FLAG() {
        return VALUE_FLAG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.VALUE_FLAG
     *
     * @param VALUE_FLAG the value for PMSCONTROL.VALUE_FLAG
     */
    public void setVALUE_FLAG(String VALUE_FLAG) {
        this.VALUE_FLAG = VALUE_FLAG == null ? null : VALUE_FLAG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.FUND_CAPITAL_BASIS
     *
     * @return the value of PMSCONTROL.FUND_CAPITAL_BASIS
     */
    public String getFUND_CAPITAL_BASIS() {
        return FUND_CAPITAL_BASIS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.FUND_CAPITAL_BASIS
     *
     * @param FUND_CAPITAL_BASIS the value for PMSCONTROL.FUND_CAPITAL_BASIS
     */
    public void setFUND_CAPITAL_BASIS(String FUND_CAPITAL_BASIS) {
        this.FUND_CAPITAL_BASIS = FUND_CAPITAL_BASIS == null ? null : FUND_CAPITAL_BASIS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SEC_PRICE_SORT_ORDER
     *
     * @return the value of PMSCONTROL.SEC_PRICE_SORT_ORDER
     */
    public String getSEC_PRICE_SORT_ORDER() {
        return SEC_PRICE_SORT_ORDER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SEC_PRICE_SORT_ORDER
     *
     * @param SEC_PRICE_SORT_ORDER the value for PMSCONTROL.SEC_PRICE_SORT_ORDER
     */
    public void setSEC_PRICE_SORT_ORDER(String SEC_PRICE_SORT_ORDER) {
        this.SEC_PRICE_SORT_ORDER = SEC_PRICE_SORT_ORDER == null ? null : SEC_PRICE_SORT_ORDER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.YEARLY_RENTAL_DIV
     *
     * @return the value of PMSCONTROL.YEARLY_RENTAL_DIV
     */
    public String getYEARLY_RENTAL_DIV() {
        return YEARLY_RENTAL_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.YEARLY_RENTAL_DIV
     *
     * @param YEARLY_RENTAL_DIV the value for PMSCONTROL.YEARLY_RENTAL_DIV
     */
    public void setYEARLY_RENTAL_DIV(String YEARLY_RENTAL_DIV) {
        this.YEARLY_RENTAL_DIV = YEARLY_RENTAL_DIV == null ? null : YEARLY_RENTAL_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.GENERATED_TD
     *
     * @return the value of PMSCONTROL.GENERATED_TD
     */
    public String getGENERATED_TD() {
        return GENERATED_TD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.GENERATED_TD
     *
     * @param GENERATED_TD the value for PMSCONTROL.GENERATED_TD
     */
    public void setGENERATED_TD(String GENERATED_TD) {
        this.GENERATED_TD = GENERATED_TD == null ? null : GENERATED_TD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.GENERATED_VD
     *
     * @return the value of PMSCONTROL.GENERATED_VD
     */
    public String getGENERATED_VD() {
        return GENERATED_VD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.GENERATED_VD
     *
     * @param GENERATED_VD the value for PMSCONTROL.GENERATED_VD
     */
    public void setGENERATED_VD(String GENERATED_VD) {
        this.GENERATED_VD = GENERATED_VD == null ? null : GENERATED_VD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SUPPLEMENT
     *
     * @return the value of PMSCONTROL.SUPPLEMENT
     */
    public String getSUPPLEMENT() {
        return SUPPLEMENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SUPPLEMENT
     *
     * @param SUPPLEMENT the value for PMSCONTROL.SUPPLEMENT
     */
    public void setSUPPLEMENT(String SUPPLEMENT) {
        this.SUPPLEMENT = SUPPLEMENT == null ? null : SUPPLEMENT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SHARE_CASH
     *
     * @return the value of PMSCONTROL.SHARE_CASH
     */
    public String getSHARE_CASH() {
        return SHARE_CASH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SHARE_CASH
     *
     * @param SHARE_CASH the value for PMSCONTROL.SHARE_CASH
     */
    public void setSHARE_CASH(String SHARE_CASH) {
        this.SHARE_CASH = SHARE_CASH == null ? null : SHARE_CASH.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.DEFAULT_ENTITY
     *
     * @return the value of PMSCONTROL.DEFAULT_ENTITY
     */
    public String getDEFAULT_ENTITY() {
        return DEFAULT_ENTITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.DEFAULT_ENTITY
     *
     * @param DEFAULT_ENTITY the value for PMSCONTROL.DEFAULT_ENTITY
     */
    public void setDEFAULT_ENTITY(String DEFAULT_ENTITY) {
        this.DEFAULT_ENTITY = DEFAULT_ENTITY == null ? null : DEFAULT_ENTITY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.POSTGL_OPT
     *
     * @return the value of PMSCONTROL.POSTGL_OPT
     */
    public String getPOSTGL_OPT() {
        return POSTGL_OPT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.POSTGL_OPT
     *
     * @param POSTGL_OPT the value for PMSCONTROL.POSTGL_OPT
     */
    public void setPOSTGL_OPT(String POSTGL_OPT) {
        this.POSTGL_OPT = POSTGL_OPT == null ? null : POSTGL_OPT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SUB_CERT_REP_NO
     *
     * @return the value of PMSCONTROL.SUB_CERT_REP_NO
     */
    public BigDecimal getSUB_CERT_REP_NO() {
        return SUB_CERT_REP_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SUB_CERT_REP_NO
     *
     * @param SUB_CERT_REP_NO the value for PMSCONTROL.SUB_CERT_REP_NO
     */
    public void setSUB_CERT_REP_NO(BigDecimal SUB_CERT_REP_NO) {
        this.SUB_CERT_REP_NO = SUB_CERT_REP_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.EXCEED_TRADE_RANGE
     *
     * @return the value of PMSCONTROL.EXCEED_TRADE_RANGE
     */
    public String getEXCEED_TRADE_RANGE() {
        return EXCEED_TRADE_RANGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.EXCEED_TRADE_RANGE
     *
     * @param EXCEED_TRADE_RANGE the value for PMSCONTROL.EXCEED_TRADE_RANGE
     */
    public void setEXCEED_TRADE_RANGE(String EXCEED_TRADE_RANGE) {
        this.EXCEED_TRADE_RANGE = EXCEED_TRADE_RANGE == null ? null : EXCEED_TRADE_RANGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.PERC_RATE
     *
     * @return the value of PMSCONTROL.PERC_RATE
     */
    public String getPERC_RATE() {
        return PERC_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.PERC_RATE
     *
     * @param PERC_RATE the value for PMSCONTROL.PERC_RATE
     */
    public void setPERC_RATE(String PERC_RATE) {
        this.PERC_RATE = PERC_RATE == null ? null : PERC_RATE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.INC_ACCRUALS
     *
     * @return the value of PMSCONTROL.INC_ACCRUALS
     */
    public String getINC_ACCRUALS() {
        return INC_ACCRUALS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.INC_ACCRUALS
     *
     * @param INC_ACCRUALS the value for PMSCONTROL.INC_ACCRUALS
     */
    public void setINC_ACCRUALS(String INC_ACCRUALS) {
        this.INC_ACCRUALS = INC_ACCRUALS == null ? null : INC_ACCRUALS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.DED_PAY
     *
     * @return the value of PMSCONTROL.DED_PAY
     */
    public String getDED_PAY() {
        return DED_PAY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.DED_PAY
     *
     * @param DED_PAY the value for PMSCONTROL.DED_PAY
     */
    public void setDED_PAY(String DED_PAY) {
        this.DED_PAY = DED_PAY == null ? null : DED_PAY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AMORT_PER
     *
     * @return the value of PMSCONTROL.AMORT_PER
     */
    public String getAMORT_PER() {
        return AMORT_PER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AMORT_PER
     *
     * @param AMORT_PER the value for PMSCONTROL.AMORT_PER
     */
    public void setAMORT_PER(String AMORT_PER) {
        this.AMORT_PER = AMORT_PER == null ? null : AMORT_PER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.MAND_ACC_REV
     *
     * @return the value of PMSCONTROL.MAND_ACC_REV
     */
    public String getMAND_ACC_REV() {
        return MAND_ACC_REV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.MAND_ACC_REV
     *
     * @param MAND_ACC_REV the value for PMSCONTROL.MAND_ACC_REV
     */
    public void setMAND_ACC_REV(String MAND_ACC_REV) {
        this.MAND_ACC_REV = MAND_ACC_REV == null ? null : MAND_ACC_REV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.MAND_PAY_REC_GL
     *
     * @return the value of PMSCONTROL.MAND_PAY_REC_GL
     */
    public String getMAND_PAY_REC_GL() {
        return MAND_PAY_REC_GL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.MAND_PAY_REC_GL
     *
     * @param MAND_PAY_REC_GL the value for PMSCONTROL.MAND_PAY_REC_GL
     */
    public void setMAND_PAY_REC_GL(String MAND_PAY_REC_GL) {
        this.MAND_PAY_REC_GL = MAND_PAY_REC_GL == null ? null : MAND_PAY_REC_GL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.ACROSS_BR
     *
     * @return the value of PMSCONTROL.ACROSS_BR
     */
    public String getACROSS_BR() {
        return ACROSS_BR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.ACROSS_BR
     *
     * @param ACROSS_BR the value for PMSCONTROL.ACROSS_BR
     */
    public void setACROSS_BR(String ACROSS_BR) {
        this.ACROSS_BR = ACROSS_BR == null ? null : ACROSS_BR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SHOW_DEP_ACC
     *
     * @return the value of PMSCONTROL.SHOW_DEP_ACC
     */
    public String getSHOW_DEP_ACC() {
        return SHOW_DEP_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SHOW_DEP_ACC
     *
     * @param SHOW_DEP_ACC the value for PMSCONTROL.SHOW_DEP_ACC
     */
    public void setSHOW_DEP_ACC(String SHOW_DEP_ACC) {
        this.SHOW_DEP_ACC = SHOW_DEP_ACC == null ? null : SHOW_DEP_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.RENT_DIV
     *
     * @return the value of PMSCONTROL.RENT_DIV
     */
    public String getRENT_DIV() {
        return RENT_DIV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.RENT_DIV
     *
     * @param RENT_DIV the value for PMSCONTROL.RENT_DIV
     */
    public void setRENT_DIV(String RENT_DIV) {
        this.RENT_DIV = RENT_DIV == null ? null : RENT_DIV.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SHOW_PF_BID
     *
     * @return the value of PMSCONTROL.SHOW_PF_BID
     */
    public String getSHOW_PF_BID() {
        return SHOW_PF_BID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SHOW_PF_BID
     *
     * @param SHOW_PF_BID the value for PMSCONTROL.SHOW_PF_BID
     */
    public void setSHOW_PF_BID(String SHOW_PF_BID) {
        this.SHOW_PF_BID = SHOW_PF_BID == null ? null : SHOW_PF_BID.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.DECLARATION_TEMP
     *
     * @return the value of PMSCONTROL.DECLARATION_TEMP
     */
    public String getDECLARATION_TEMP() {
        return DECLARATION_TEMP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.DECLARATION_TEMP
     *
     * @param DECLARATION_TEMP the value for PMSCONTROL.DECLARATION_TEMP
     */
    public void setDECLARATION_TEMP(String DECLARATION_TEMP) {
        this.DECLARATION_TEMP = DECLARATION_TEMP == null ? null : DECLARATION_TEMP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SHOW_DVID_SEC
     *
     * @return the value of PMSCONTROL.SHOW_DVID_SEC
     */
    public String getSHOW_DVID_SEC() {
        return SHOW_DVID_SEC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SHOW_DVID_SEC
     *
     * @param SHOW_DVID_SEC the value for PMSCONTROL.SHOW_DVID_SEC
     */
    public void setSHOW_DVID_SEC(String SHOW_DVID_SEC) {
        this.SHOW_DVID_SEC = SHOW_DVID_SEC == null ? null : SHOW_DVID_SEC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHECK_LIST
     *
     * @return the value of PMSCONTROL.CHECK_LIST
     */
    public String getCHECK_LIST() {
        return CHECK_LIST;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHECK_LIST
     *
     * @param CHECK_LIST the value for PMSCONTROL.CHECK_LIST
     */
    public void setCHECK_LIST(String CHECK_LIST) {
        this.CHECK_LIST = CHECK_LIST == null ? null : CHECK_LIST.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.INC_FEE_PERIOD
     *
     * @return the value of PMSCONTROL.INC_FEE_PERIOD
     */
    public String getINC_FEE_PERIOD() {
        return INC_FEE_PERIOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.INC_FEE_PERIOD
     *
     * @param INC_FEE_PERIOD the value for PMSCONTROL.INC_FEE_PERIOD
     */
    public void setINC_FEE_PERIOD(String INC_FEE_PERIOD) {
        this.INC_FEE_PERIOD = INC_FEE_PERIOD == null ? null : INC_FEE_PERIOD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.UPDATE_JV_REF
     *
     * @return the value of PMSCONTROL.UPDATE_JV_REF
     */
    public String getUPDATE_JV_REF() {
        return UPDATE_JV_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.UPDATE_JV_REF
     *
     * @param UPDATE_JV_REF the value for PMSCONTROL.UPDATE_JV_REF
     */
    public void setUPDATE_JV_REF(String UPDATE_JV_REF) {
        this.UPDATE_JV_REF = UPDATE_JV_REF == null ? null : UPDATE_JV_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.ALLOC_DEAL_CIF_INC
     *
     * @return the value of PMSCONTROL.ALLOC_DEAL_CIF_INC
     */
    public String getALLOC_DEAL_CIF_INC() {
        return ALLOC_DEAL_CIF_INC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.ALLOC_DEAL_CIF_INC
     *
     * @param ALLOC_DEAL_CIF_INC the value for PMSCONTROL.ALLOC_DEAL_CIF_INC
     */
    public void setALLOC_DEAL_CIF_INC(String ALLOC_DEAL_CIF_INC) {
        this.ALLOC_DEAL_CIF_INC = ALLOC_DEAL_CIF_INC == null ? null : ALLOC_DEAL_CIF_INC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.UPDATE_VDATE
     *
     * @return the value of PMSCONTROL.UPDATE_VDATE
     */
    public String getUPDATE_VDATE() {
        return UPDATE_VDATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.UPDATE_VDATE
     *
     * @param UPDATE_VDATE the value for PMSCONTROL.UPDATE_VDATE
     */
    public void setUPDATE_VDATE(String UPDATE_VDATE) {
        this.UPDATE_VDATE = UPDATE_VDATE == null ? null : UPDATE_VDATE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.GENERATE_TRADE_DEALS
     *
     * @return the value of PMSCONTROL.GENERATE_TRADE_DEALS
     */
    public String getGENERATE_TRADE_DEALS() {
        return GENERATE_TRADE_DEALS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.GENERATE_TRADE_DEALS
     *
     * @param GENERATE_TRADE_DEALS the value for PMSCONTROL.GENERATE_TRADE_DEALS
     */
    public void setGENERATE_TRADE_DEALS(String GENERATE_TRADE_DEALS) {
        this.GENERATE_TRADE_DEALS = GENERATE_TRADE_DEALS == null ? null : GENERATE_TRADE_DEALS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SPA_GROUP
     *
     * @return the value of PMSCONTROL.SPA_GROUP
     */
    public String getSPA_GROUP() {
        return SPA_GROUP;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SPA_GROUP
     *
     * @param SPA_GROUP the value for PMSCONTROL.SPA_GROUP
     */
    public void setSPA_GROUP(String SPA_GROUP) {
        this.SPA_GROUP = SPA_GROUP == null ? null : SPA_GROUP.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.POST_BY_TRXTYPE
     *
     * @return the value of PMSCONTROL.POST_BY_TRXTYPE
     */
    public String getPOST_BY_TRXTYPE() {
        return POST_BY_TRXTYPE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.POST_BY_TRXTYPE
     *
     * @param POST_BY_TRXTYPE the value for PMSCONTROL.POST_BY_TRXTYPE
     */
    public void setPOST_BY_TRXTYPE(String POST_BY_TRXTYPE) {
        this.POST_BY_TRXTYPE = POST_BY_TRXTYPE == null ? null : POST_BY_TRXTYPE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CALL_ENTRY_DATE
     *
     * @return the value of PMSCONTROL.CALL_ENTRY_DATE
     */
    public String getCALL_ENTRY_DATE() {
        return CALL_ENTRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CALL_ENTRY_DATE
     *
     * @param CALL_ENTRY_DATE the value for PMSCONTROL.CALL_ENTRY_DATE
     */
    public void setCALL_ENTRY_DATE(String CALL_ENTRY_DATE) {
        this.CALL_ENTRY_DATE = CALL_ENTRY_DATE == null ? null : CALL_ENTRY_DATE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHANGE_PRICE_COMMIT
     *
     * @return the value of PMSCONTROL.CHANGE_PRICE_COMMIT
     */
    public String getCHANGE_PRICE_COMMIT() {
        return CHANGE_PRICE_COMMIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHANGE_PRICE_COMMIT
     *
     * @param CHANGE_PRICE_COMMIT the value for PMSCONTROL.CHANGE_PRICE_COMMIT
     */
    public void setCHANGE_PRICE_COMMIT(String CHANGE_PRICE_COMMIT) {
        this.CHANGE_PRICE_COMMIT = CHANGE_PRICE_COMMIT == null ? null : CHANGE_PRICE_COMMIT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.ADD_CHECK_APPROVE
     *
     * @return the value of PMSCONTROL.ADD_CHECK_APPROVE
     */
    public String getADD_CHECK_APPROVE() {
        return ADD_CHECK_APPROVE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.ADD_CHECK_APPROVE
     *
     * @param ADD_CHECK_APPROVE the value for PMSCONTROL.ADD_CHECK_APPROVE
     */
    public void setADD_CHECK_APPROVE(String ADD_CHECK_APPROVE) {
        this.ADD_CHECK_APPROVE = ADD_CHECK_APPROVE == null ? null : ADD_CHECK_APPROVE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.DEF_REV_MARKET_PRICE
     *
     * @return the value of PMSCONTROL.DEF_REV_MARKET_PRICE
     */
    public String getDEF_REV_MARKET_PRICE() {
        return DEF_REV_MARKET_PRICE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.DEF_REV_MARKET_PRICE
     *
     * @param DEF_REV_MARKET_PRICE the value for PMSCONTROL.DEF_REV_MARKET_PRICE
     */
    public void setDEF_REV_MARKET_PRICE(String DEF_REV_MARKET_PRICE) {
        this.DEF_REV_MARKET_PRICE = DEF_REV_MARKET_PRICE == null ? null : DEF_REV_MARKET_PRICE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.BANK_NAME
     *
     * @return the value of PMSCONTROL.BANK_NAME
     */
    public String getBANK_NAME() {
        return BANK_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.BANK_NAME
     *
     * @param BANK_NAME the value for PMSCONTROL.BANK_NAME
     */
    public void setBANK_NAME(String BANK_NAME) {
        this.BANK_NAME = BANK_NAME == null ? null : BANK_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.PROC_SUB_RED_DATE
     *
     * @return the value of PMSCONTROL.PROC_SUB_RED_DATE
     */
    public String getPROC_SUB_RED_DATE() {
        return PROC_SUB_RED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.PROC_SUB_RED_DATE
     *
     * @param PROC_SUB_RED_DATE the value for PMSCONTROL.PROC_SUB_RED_DATE
     */
    public void setPROC_SUB_RED_DATE(String PROC_SUB_RED_DATE) {
        this.PROC_SUB_RED_DATE = PROC_SUB_RED_DATE == null ? null : PROC_SUB_RED_DATE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.TRS_AMT_CATG
     *
     * @return the value of PMSCONTROL.TRS_AMT_CATG
     */
    public String getTRS_AMT_CATG() {
        return TRS_AMT_CATG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.TRS_AMT_CATG
     *
     * @param TRS_AMT_CATG the value for PMSCONTROL.TRS_AMT_CATG
     */
    public void setTRS_AMT_CATG(String TRS_AMT_CATG) {
        this.TRS_AMT_CATG = TRS_AMT_CATG == null ? null : TRS_AMT_CATG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHECK_AMT
     *
     * @return the value of PMSCONTROL.CHECK_AMT
     */
    public String getCHECK_AMT() {
        return CHECK_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHECK_AMT
     *
     * @param CHECK_AMT the value for PMSCONTROL.CHECK_AMT
     */
    public void setCHECK_AMT(String CHECK_AMT) {
        this.CHECK_AMT = CHECK_AMT == null ? null : CHECK_AMT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.INC_FEE_RELOFF_DAYS
     *
     * @return the value of PMSCONTROL.INC_FEE_RELOFF_DAYS
     */
    public BigDecimal getINC_FEE_RELOFF_DAYS() {
        return INC_FEE_RELOFF_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.INC_FEE_RELOFF_DAYS
     *
     * @param INC_FEE_RELOFF_DAYS the value for PMSCONTROL.INC_FEE_RELOFF_DAYS
     */
    public void setINC_FEE_RELOFF_DAYS(BigDecimal INC_FEE_RELOFF_DAYS) {
        this.INC_FEE_RELOFF_DAYS = INC_FEE_RELOFF_DAYS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHECK_REF
     *
     * @return the value of PMSCONTROL.CHECK_REF
     */
    public String getCHECK_REF() {
        return CHECK_REF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHECK_REF
     *
     * @param CHECK_REF the value for PMSCONTROL.CHECK_REF
     */
    public void setCHECK_REF(String CHECK_REF) {
        this.CHECK_REF = CHECK_REF == null ? null : CHECK_REF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.ACC_PROC_REPAYMENT_PLAN
     *
     * @return the value of PMSCONTROL.ACC_PROC_REPAYMENT_PLAN
     */
    public String getACC_PROC_REPAYMENT_PLAN() {
        return ACC_PROC_REPAYMENT_PLAN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.ACC_PROC_REPAYMENT_PLAN
     *
     * @param ACC_PROC_REPAYMENT_PLAN the value for PMSCONTROL.ACC_PROC_REPAYMENT_PLAN
     */
    public void setACC_PROC_REPAYMENT_PLAN(String ACC_PROC_REPAYMENT_PLAN) {
        this.ACC_PROC_REPAYMENT_PLAN = ACC_PROC_REPAYMENT_PLAN == null ? null : ACC_PROC_REPAYMENT_PLAN.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.ENABLE_COUPON_DUE_DATE
     *
     * @return the value of PMSCONTROL.ENABLE_COUPON_DUE_DATE
     */
    public String getENABLE_COUPON_DUE_DATE() {
        return ENABLE_COUPON_DUE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.ENABLE_COUPON_DUE_DATE
     *
     * @param ENABLE_COUPON_DUE_DATE the value for PMSCONTROL.ENABLE_COUPON_DUE_DATE
     */
    public void setENABLE_COUPON_DUE_DATE(String ENABLE_COUPON_DUE_DATE) {
        this.ENABLE_COUPON_DUE_DATE = ENABLE_COUPON_DUE_DATE == null ? null : ENABLE_COUPON_DUE_DATE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AUTOMATIC_SETTLEMENT
     *
     * @return the value of PMSCONTROL.AUTOMATIC_SETTLEMENT
     */
    public String getAUTOMATIC_SETTLEMENT() {
        return AUTOMATIC_SETTLEMENT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AUTOMATIC_SETTLEMENT
     *
     * @param AUTOMATIC_SETTLEMENT the value for PMSCONTROL.AUTOMATIC_SETTLEMENT
     */
    public void setAUTOMATIC_SETTLEMENT(String AUTOMATIC_SETTLEMENT) {
        this.AUTOMATIC_SETTLEMENT = AUTOMATIC_SETTLEMENT == null ? null : AUTOMATIC_SETTLEMENT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.PAYMENT_VIA
     *
     * @return the value of PMSCONTROL.PAYMENT_VIA
     */
    public String getPAYMENT_VIA() {
        return PAYMENT_VIA;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.PAYMENT_VIA
     *
     * @param PAYMENT_VIA the value for PMSCONTROL.PAYMENT_VIA
     */
    public void setPAYMENT_VIA(String PAYMENT_VIA) {
        this.PAYMENT_VIA = PAYMENT_VIA == null ? null : PAYMENT_VIA.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.TRS_METHOD
     *
     * @return the value of PMSCONTROL.TRS_METHOD
     */
    public String getTRS_METHOD() {
        return TRS_METHOD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.TRS_METHOD
     *
     * @param TRS_METHOD the value for PMSCONTROL.TRS_METHOD
     */
    public void setTRS_METHOD(String TRS_METHOD) {
        this.TRS_METHOD = TRS_METHOD == null ? null : TRS_METHOD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.DOC_LANGUAGE
     *
     * @return the value of PMSCONTROL.DOC_LANGUAGE
     */
    public String getDOC_LANGUAGE() {
        return DOC_LANGUAGE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.DOC_LANGUAGE
     *
     * @param DOC_LANGUAGE the value for PMSCONTROL.DOC_LANGUAGE
     */
    public void setDOC_LANGUAGE(String DOC_LANGUAGE) {
        this.DOC_LANGUAGE = DOC_LANGUAGE == null ? null : DOC_LANGUAGE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.MAND_SALES_OFF
     *
     * @return the value of PMSCONTROL.MAND_SALES_OFF
     */
    public String getMAND_SALES_OFF() {
        return MAND_SALES_OFF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.MAND_SALES_OFF
     *
     * @param MAND_SALES_OFF the value for PMSCONTROL.MAND_SALES_OFF
     */
    public void setMAND_SALES_OFF(String MAND_SALES_OFF) {
        this.MAND_SALES_OFF = MAND_SALES_OFF == null ? null : MAND_SALES_OFF.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SHOW_DEAL_OFFICER
     *
     * @return the value of PMSCONTROL.SHOW_DEAL_OFFICER
     */
    public String getSHOW_DEAL_OFFICER() {
        return SHOW_DEAL_OFFICER;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SHOW_DEAL_OFFICER
     *
     * @param SHOW_DEAL_OFFICER the value for PMSCONTROL.SHOW_DEAL_OFFICER
     */
    public void setSHOW_DEAL_OFFICER(String SHOW_DEAL_OFFICER) {
        this.SHOW_DEAL_OFFICER = SHOW_DEAL_OFFICER == null ? null : SHOW_DEAL_OFFICER.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.COMMON_LIMITS_FMS
     *
     * @return the value of PMSCONTROL.COMMON_LIMITS_FMS
     */
    public String getCOMMON_LIMITS_FMS() {
        return COMMON_LIMITS_FMS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.COMMON_LIMITS_FMS
     *
     * @param COMMON_LIMITS_FMS the value for PMSCONTROL.COMMON_LIMITS_FMS
     */
    public void setCOMMON_LIMITS_FMS(String COMMON_LIMITS_FMS) {
        this.COMMON_LIMITS_FMS = COMMON_LIMITS_FMS == null ? null : COMMON_LIMITS_FMS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHANGE_FID_ACC
     *
     * @return the value of PMSCONTROL.CHANGE_FID_ACC
     */
    public String getCHANGE_FID_ACC() {
        return CHANGE_FID_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHANGE_FID_ACC
     *
     * @param CHANGE_FID_ACC the value for PMSCONTROL.CHANGE_FID_ACC
     */
    public void setCHANGE_FID_ACC(String CHANGE_FID_ACC) {
        this.CHANGE_FID_ACC = CHANGE_FID_ACC == null ? null : CHANGE_FID_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.GENERATE_TRADE_ENTRY
     *
     * @return the value of PMSCONTROL.GENERATE_TRADE_ENTRY
     */
    public String getGENERATE_TRADE_ENTRY() {
        return GENERATE_TRADE_ENTRY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.GENERATE_TRADE_ENTRY
     *
     * @param GENERATE_TRADE_ENTRY the value for PMSCONTROL.GENERATE_TRADE_ENTRY
     */
    public void setGENERATE_TRADE_ENTRY(String GENERATE_TRADE_ENTRY) {
        this.GENERATE_TRADE_ENTRY = GENERATE_TRADE_ENTRY == null ? null : GENERATE_TRADE_ENTRY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.ADD_SWIFT_DET
     *
     * @return the value of PMSCONTROL.ADD_SWIFT_DET
     */
    public String getADD_SWIFT_DET() {
        return ADD_SWIFT_DET;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.ADD_SWIFT_DET
     *
     * @param ADD_SWIFT_DET the value for PMSCONTROL.ADD_SWIFT_DET
     */
    public void setADD_SWIFT_DET(String ADD_SWIFT_DET) {
        this.ADD_SWIFT_DET = ADD_SWIFT_DET == null ? null : ADD_SWIFT_DET.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.BLACK_LIST_CHECK
     *
     * @return the value of PMSCONTROL.BLACK_LIST_CHECK
     */
    public String getBLACK_LIST_CHECK() {
        return BLACK_LIST_CHECK;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.BLACK_LIST_CHECK
     *
     * @param BLACK_LIST_CHECK the value for PMSCONTROL.BLACK_LIST_CHECK
     */
    public void setBLACK_LIST_CHECK(String BLACK_LIST_CHECK) {
        this.BLACK_LIST_CHECK = BLACK_LIST_CHECK == null ? null : BLACK_LIST_CHECK.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.PF_OPENED_DATE
     *
     * @return the value of PMSCONTROL.PF_OPENED_DATE
     */
    public String getPF_OPENED_DATE() {
        return PF_OPENED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.PF_OPENED_DATE
     *
     * @param PF_OPENED_DATE the value for PMSCONTROL.PF_OPENED_DATE
     */
    public void setPF_OPENED_DATE(String PF_OPENED_DATE) {
        this.PF_OPENED_DATE = PF_OPENED_DATE == null ? null : PF_OPENED_DATE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHECK_ACC_STATUS
     *
     * @return the value of PMSCONTROL.CHECK_ACC_STATUS
     */
    public String getCHECK_ACC_STATUS() {
        return CHECK_ACC_STATUS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHECK_ACC_STATUS
     *
     * @param CHECK_ACC_STATUS the value for PMSCONTROL.CHECK_ACC_STATUS
     */
    public void setCHECK_ACC_STATUS(String CHECK_ACC_STATUS) {
        this.CHECK_ACC_STATUS = CHECK_ACC_STATUS == null ? null : CHECK_ACC_STATUS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CREATE_PF_TRD
     *
     * @return the value of PMSCONTROL.CREATE_PF_TRD
     */
    public String getCREATE_PF_TRD() {
        return CREATE_PF_TRD;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CREATE_PF_TRD
     *
     * @param CREATE_PF_TRD the value for PMSCONTROL.CREATE_PF_TRD
     */
    public void setCREATE_PF_TRD(String CREATE_PF_TRD) {
        this.CREATE_PF_TRD = CREATE_PF_TRD == null ? null : CREATE_PF_TRD.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.BOOK_PREMIUM
     *
     * @return the value of PMSCONTROL.BOOK_PREMIUM
     */
    public String getBOOK_PREMIUM() {
        return BOOK_PREMIUM;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.BOOK_PREMIUM
     *
     * @param BOOK_PREMIUM the value for PMSCONTROL.BOOK_PREMIUM
     */
    public void setBOOK_PREMIUM(String BOOK_PREMIUM) {
        this.BOOK_PREMIUM = BOOK_PREMIUM == null ? null : BOOK_PREMIUM.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.ZAK_RATE
     *
     * @return the value of PMSCONTROL.ZAK_RATE
     */
    public BigDecimal getZAK_RATE() {
        return ZAK_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.ZAK_RATE
     *
     * @param ZAK_RATE the value for PMSCONTROL.ZAK_RATE
     */
    public void setZAK_RATE(BigDecimal ZAK_RATE) {
        this.ZAK_RATE = ZAK_RATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.XLD_HTM_CATEG
     *
     * @return the value of PMSCONTROL.XLD_HTM_CATEG
     */
    public String getXLD_HTM_CATEG() {
        return XLD_HTM_CATEG;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.XLD_HTM_CATEG
     *
     * @param XLD_HTM_CATEG the value for PMSCONTROL.XLD_HTM_CATEG
     */
    public void setXLD_HTM_CATEG(String XLD_HTM_CATEG) {
        this.XLD_HTM_CATEG = XLD_HTM_CATEG == null ? null : XLD_HTM_CATEG.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.VALID_PAYMNT_DATE
     *
     * @return the value of PMSCONTROL.VALID_PAYMNT_DATE
     */
    public String getVALID_PAYMNT_DATE() {
        return VALID_PAYMNT_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.VALID_PAYMNT_DATE
     *
     * @param VALID_PAYMNT_DATE the value for PMSCONTROL.VALID_PAYMNT_DATE
     */
    public void setVALID_PAYMNT_DATE(String VALID_PAYMNT_DATE) {
        this.VALID_PAYMNT_DATE = VALID_PAYMNT_DATE == null ? null : VALID_PAYMNT_DATE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.FLOAT_RATE_BASE
     *
     * @return the value of PMSCONTROL.FLOAT_RATE_BASE
     */
    public String getFLOAT_RATE_BASE() {
        return FLOAT_RATE_BASE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.FLOAT_RATE_BASE
     *
     * @param FLOAT_RATE_BASE the value for PMSCONTROL.FLOAT_RATE_BASE
     */
    public void setFLOAT_RATE_BASE(String FLOAT_RATE_BASE) {
        this.FLOAT_RATE_BASE = FLOAT_RATE_BASE == null ? null : FLOAT_RATE_BASE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.EXIT_REP_ID
     *
     * @return the value of PMSCONTROL.EXIT_REP_ID
     */
    public BigDecimal getEXIT_REP_ID() {
        return EXIT_REP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.EXIT_REP_ID
     *
     * @param EXIT_REP_ID the value for PMSCONTROL.EXIT_REP_ID
     */
    public void setEXIT_REP_ID(BigDecimal EXIT_REP_ID) {
        this.EXIT_REP_ID = EXIT_REP_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.TRADE_FEES_CALC
     *
     * @return the value of PMSCONTROL.TRADE_FEES_CALC
     */
    public String getTRADE_FEES_CALC() {
        return TRADE_FEES_CALC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.TRADE_FEES_CALC
     *
     * @param TRADE_FEES_CALC the value for PMSCONTROL.TRADE_FEES_CALC
     */
    public void setTRADE_FEES_CALC(String TRADE_FEES_CALC) {
        this.TRADE_FEES_CALC = TRADE_FEES_CALC == null ? null : TRADE_FEES_CALC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SHOW_ADD_AMOUNT
     *
     * @return the value of PMSCONTROL.SHOW_ADD_AMOUNT
     */
    public String getSHOW_ADD_AMOUNT() {
        return SHOW_ADD_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SHOW_ADD_AMOUNT
     *
     * @param SHOW_ADD_AMOUNT the value for PMSCONTROL.SHOW_ADD_AMOUNT
     */
    public void setSHOW_ADD_AMOUNT(String SHOW_ADD_AMOUNT) {
        this.SHOW_ADD_AMOUNT = SHOW_ADD_AMOUNT == null ? null : SHOW_ADD_AMOUNT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.ADD_LABEL
     *
     * @return the value of PMSCONTROL.ADD_LABEL
     */
    public String getADD_LABEL() {
        return ADD_LABEL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.ADD_LABEL
     *
     * @param ADD_LABEL the value for PMSCONTROL.ADD_LABEL
     */
    public void setADD_LABEL(String ADD_LABEL) {
        this.ADD_LABEL = ADD_LABEL == null ? null : ADD_LABEL.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.AFFECT_INV_ACC
     *
     * @return the value of PMSCONTROL.AFFECT_INV_ACC
     */
    public String getAFFECT_INV_ACC() {
        return AFFECT_INV_ACC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.AFFECT_INV_ACC
     *
     * @param AFFECT_INV_ACC the value for PMSCONTROL.AFFECT_INV_ACC
     */
    public void setAFFECT_INV_ACC(String AFFECT_INV_ACC) {
        this.AFFECT_INV_ACC = AFFECT_INV_ACC == null ? null : AFFECT_INV_ACC.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.CHECK_LIMIT
     *
     * @return the value of PMSCONTROL.CHECK_LIMIT
     */
    public String getCHECK_LIMIT() {
        return CHECK_LIMIT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.CHECK_LIMIT
     *
     * @param CHECK_LIMIT the value for PMSCONTROL.CHECK_LIMIT
     */
    public void setCHECK_LIMIT(String CHECK_LIMIT) {
        this.CHECK_LIMIT = CHECK_LIMIT == null ? null : CHECK_LIMIT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.SHOW_QTY_TEXT
     *
     * @return the value of PMSCONTROL.SHOW_QTY_TEXT
     */
    public String getSHOW_QTY_TEXT() {
        return SHOW_QTY_TEXT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.SHOW_QTY_TEXT
     *
     * @param SHOW_QTY_TEXT the value for PMSCONTROL.SHOW_QTY_TEXT
     */
    public void setSHOW_QTY_TEXT(String SHOW_QTY_TEXT) {
        this.SHOW_QTY_TEXT = SHOW_QTY_TEXT == null ? null : SHOW_QTY_TEXT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.REVAL_COMMON_LIMITS
     *
     * @return the value of PMSCONTROL.REVAL_COMMON_LIMITS
     */
    public String getREVAL_COMMON_LIMITS() {
        return REVAL_COMMON_LIMITS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.REVAL_COMMON_LIMITS
     *
     * @param REVAL_COMMON_LIMITS the value for PMSCONTROL.REVAL_COMMON_LIMITS
     */
    public void setREVAL_COMMON_LIMITS(String REVAL_COMMON_LIMITS) {
        this.REVAL_COMMON_LIMITS = REVAL_COMMON_LIMITS == null ? null : REVAL_COMMON_LIMITS.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.MARGIN_GLCODE
     *
     * @return the value of PMSCONTROL.MARGIN_GLCODE
     */
    public BigDecimal getMARGIN_GLCODE() {
        return MARGIN_GLCODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.MARGIN_GLCODE
     *
     * @param MARGIN_GLCODE the value for PMSCONTROL.MARGIN_GLCODE
     */
    public void setMARGIN_GLCODE(BigDecimal MARGIN_GLCODE) {
        this.MARGIN_GLCODE = MARGIN_GLCODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSCONTROL.REVAL_HISTORICAL_COST
     *
     * @return the value of PMSCONTROL.REVAL_HISTORICAL_COST
     */
    public String getREVAL_HISTORICAL_COST() {
        return REVAL_HISTORICAL_COST;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSCONTROL.REVAL_HISTORICAL_COST
     *
     * @param REVAL_HISTORICAL_COST the value for PMSCONTROL.REVAL_HISTORICAL_COST
     */
    public void setREVAL_HISTORICAL_COST(String REVAL_HISTORICAL_COST) {
        this.REVAL_HISTORICAL_COST = REVAL_HISTORICAL_COST == null ? null : REVAL_HISTORICAL_COST.trim();
    }

	public String getAUTO_SETT_ACTIVE_APPROVED_LIST() {
		return AUTO_SETT_ACTIVE_APPROVED_LIST;
	}

	public void setAUTO_SETT_ACTIVE_APPROVED_LIST(String aUTO_SETT_ACTIVE_APPROVED_LIST) {
		AUTO_SETT_ACTIVE_APPROVED_LIST = aUTO_SETT_ACTIVE_APPROVED_LIST;
	}
}