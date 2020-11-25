package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class PMSINVENTORYVO extends PMSINVENTORYVOKey {
    /**
     * This field corresponds to the database column PMSINVENTORY.SECURITY_LOT
     */
    private String SECURITY_LOT;

    /**
     * This field corresponds to the database column PMSINVENTORY.QTY
     */
    private BigDecimal QTY;

    /**
     * This field corresponds to the database column PMSINVENTORY.VALUE_SECURITY
     */
    private BigDecimal VALUE_SECURITY;

    /**
     * This field corresponds to the database column PMSINVENTORY.VALUE_PORTFOLIO
     */
    private BigDecimal VALUE_PORTFOLIO;

    /**
     * This field corresponds to the database column PMSINVENTORY.VALUE_CV
     */
    private BigDecimal VALUE_CV;

    /**
     * This field corresponds to the database column PMSINVENTORY.MARKET_PRICE
     */
    private BigDecimal MARKET_PRICE;

    /**
     * This field corresponds to the database column PMSINVENTORY.MARKET_PRICE_CV
     */
    private BigDecimal MARKET_PRICE_CV;

    /**
     * This field corresponds to the database column PMSINVENTORY.ACCRUALS
     */
    private BigDecimal ACCRUALS;

    /**
     * This field corresponds to the database column PMSINVENTORY.ACCRUALS_CV
     */
    private BigDecimal ACCRUALS_CV;

    /**
     * This field corresponds to the database column PMSINVENTORY.ACCRUALS_PORTFOLIO
     */
    private BigDecimal ACCRUALS_PORTFOLIO;

    /**
     * This field corresponds to the database column PMSINVENTORY.REVALUE_SECURITY
     */
    private BigDecimal REVALUE_SECURITY;

    /**
     * This field corresponds to the database column PMSINVENTORY.REVALUE_PORTFOLIO
     */
    private BigDecimal REVALUE_PORTFOLIO;

    /**
     * This field corresponds to the database column PMSINVENTORY.REVALUE_CV
     */
    private BigDecimal REVALUE_CV;

    /**
     * This field corresponds to the database column PMSINVENTORY.ACCRUED_DIV_FC
     */
    private BigDecimal ACCRUED_DIV_FC;

    /**
     * This field corresponds to the database column PMSINVENTORY.ACCRUED_DIV_CV
     */
    private BigDecimal ACCRUED_DIV_CV;

    /**
     * This field corresponds to the database column PMSINVENTORY.FUND_VALUE_SECURITY
     */
    private BigDecimal FUND_VALUE_SECURITY;

    /**
     * This field corresponds to the database column PMSINVENTORY.FUND_VALUE_PORTFOLIO
     */
    private BigDecimal FUND_VALUE_PORTFOLIO;

    /**
     * This field corresponds to the database column PMSINVENTORY.FUND_VALUE_CV
     */
    private BigDecimal FUND_VALUE_CV;

    /**
     * This field corresponds to the database column PMSINVENTORY.ACCEPTANCE_DATE
     */
    private Date ACCEPTANCE_DATE;

    /**
     * This field corresponds to the database column PMSINVENTORY.VALUE_EXPOSURE
     */
    private BigDecimal VALUE_EXPOSURE;

    /**
     * This field corresponds to the database column PMSINVENTORY.REVALUE_EXPOSURE
     */
    private BigDecimal REVALUE_EXPOSURE;

    /**
     * This field corresponds to the database column PMSINVENTORY.EXIT_QTY
     */
    private BigDecimal EXIT_QTY;

    /**
     * This field corresponds to the database column PMSINVENTORY.EXIT_AMT
     */
    private BigDecimal EXIT_AMT;

    /**
     * This field corresponds to the database column PMSINVENTORY.EXIT_AMT_CV
     */
    private BigDecimal EXIT_AMT_CV;

    /**
     * This field corresponds to the database column PMSINVENTORY.EXIT_AMT_PF
     */
    private BigDecimal EXIT_AMT_PF;

    /**
     * This field corresponds to the database column PMSINVENTORY.LAST_ACCRUAL_ENTRY_DATE
     */
    private Date LAST_ACCRUAL_ENTRY_DATE;

    /**
     * This field corresponds to the database column PMSINVENTORY.LAST_ACCRUAL_DATE
     */
    private Date LAST_ACCRUAL_DATE;

    /**
     * This field corresponds to the database column PMSINVENTORY.FAIR_VALUE
     */
    private BigDecimal FAIR_VALUE;

    /**
     * This field corresponds to the database column PMSINVENTORY.FAIR_VALUE_CV
     */
    private BigDecimal FAIR_VALUE_CV;

    /**
     * This field corresponds to the database column PMSINVENTORY.FAIR_VALUE_PF
     */
    private BigDecimal FAIR_VALUE_PF;

    /**
     * This field corresponds to the database column PMSINVENTORY.SHARE_PREM_TOT
     */
    private BigDecimal SHARE_PREM_TOT;

    /**
     * This field corresponds to the database column PMSINVENTORY.SHARE_PREM_TOT_CV
     */
    private BigDecimal SHARE_PREM_TOT_CV;

    /**
     * This field corresponds to the database column PMSINVENTORY.SHARE_PREM_TOT_PF
     */
    private BigDecimal SHARE_PREM_TOT_PF;

    /**
     * This field corresponds to the database column PMSINVENTORY.LAST_CAP_ENTRY_DATE
     */
    private Date LAST_CAP_ENTRY_DATE;

    /**
     * This field corresponds to the database column PMSINVENTORY.REVAL_AMT
     */
    private BigDecimal REVAL_AMT;

    /**
     * This field corresponds to the database column PMSINVENTORY.REVAL_AMT_CV
     */
    private BigDecimal REVAL_AMT_CV;

    /**
     * This field corresponds to the database column PMSINVENTORY.REVAL_AMT_PF
     */
    private BigDecimal REVAL_AMT_PF;

    /**
     * This field corresponds to the database column PMSINVENTORY.GOODWILL_AMOUNT
     */
    private BigDecimal GOODWILL_AMOUNT;

    /**
     * This field corresponds to the database column PMSINVENTORY.GOODWILL_AMOUNT_CV
     */
    private BigDecimal GOODWILL_AMOUNT_CV;

    /**
     * This field corresponds to the database column PMSINVENTORY.GOODWILL_AMOUNT_PF
     */
    private BigDecimal GOODWILL_AMOUNT_PF;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.SECURITY_LOT
     *
     * @return the value of PMSINVENTORY.SECURITY_LOT
     */
    public String getSECURITY_LOT() {
        return SECURITY_LOT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.SECURITY_LOT
     *
     * @param SECURITY_LOT the value for PMSINVENTORY.SECURITY_LOT
     */
    public void setSECURITY_LOT(String SECURITY_LOT) {
        this.SECURITY_LOT = SECURITY_LOT == null ? null : SECURITY_LOT.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.QTY
     *
     * @return the value of PMSINVENTORY.QTY
     */
    public BigDecimal getQTY() {
        return QTY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.QTY
     *
     * @param QTY the value for PMSINVENTORY.QTY
     */
    public void setQTY(BigDecimal QTY) {
        this.QTY = QTY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.VALUE_SECURITY
     *
     * @return the value of PMSINVENTORY.VALUE_SECURITY
     */
    public BigDecimal getVALUE_SECURITY() {
        return VALUE_SECURITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.VALUE_SECURITY
     *
     * @param VALUE_SECURITY the value for PMSINVENTORY.VALUE_SECURITY
     */
    public void setVALUE_SECURITY(BigDecimal VALUE_SECURITY) {
        this.VALUE_SECURITY = VALUE_SECURITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.VALUE_PORTFOLIO
     *
     * @return the value of PMSINVENTORY.VALUE_PORTFOLIO
     */
    public BigDecimal getVALUE_PORTFOLIO() {
        return VALUE_PORTFOLIO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.VALUE_PORTFOLIO
     *
     * @param VALUE_PORTFOLIO the value for PMSINVENTORY.VALUE_PORTFOLIO
     */
    public void setVALUE_PORTFOLIO(BigDecimal VALUE_PORTFOLIO) {
        this.VALUE_PORTFOLIO = VALUE_PORTFOLIO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.VALUE_CV
     *
     * @return the value of PMSINVENTORY.VALUE_CV
     */
    public BigDecimal getVALUE_CV() {
        return VALUE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.VALUE_CV
     *
     * @param VALUE_CV the value for PMSINVENTORY.VALUE_CV
     */
    public void setVALUE_CV(BigDecimal VALUE_CV) {
        this.VALUE_CV = VALUE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.MARKET_PRICE
     *
     * @return the value of PMSINVENTORY.MARKET_PRICE
     */
    public BigDecimal getMARKET_PRICE() {
        return MARKET_PRICE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.MARKET_PRICE
     *
     * @param MARKET_PRICE the value for PMSINVENTORY.MARKET_PRICE
     */
    public void setMARKET_PRICE(BigDecimal MARKET_PRICE) {
        this.MARKET_PRICE = MARKET_PRICE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.MARKET_PRICE_CV
     *
     * @return the value of PMSINVENTORY.MARKET_PRICE_CV
     */
    public BigDecimal getMARKET_PRICE_CV() {
        return MARKET_PRICE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.MARKET_PRICE_CV
     *
     * @param MARKET_PRICE_CV the value for PMSINVENTORY.MARKET_PRICE_CV
     */
    public void setMARKET_PRICE_CV(BigDecimal MARKET_PRICE_CV) {
        this.MARKET_PRICE_CV = MARKET_PRICE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.ACCRUALS
     *
     * @return the value of PMSINVENTORY.ACCRUALS
     */
    public BigDecimal getACCRUALS() {
        return ACCRUALS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.ACCRUALS
     *
     * @param ACCRUALS the value for PMSINVENTORY.ACCRUALS
     */
    public void setACCRUALS(BigDecimal ACCRUALS) {
        this.ACCRUALS = ACCRUALS;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.ACCRUALS_CV
     *
     * @return the value of PMSINVENTORY.ACCRUALS_CV
     */
    public BigDecimal getACCRUALS_CV() {
        return ACCRUALS_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.ACCRUALS_CV
     *
     * @param ACCRUALS_CV the value for PMSINVENTORY.ACCRUALS_CV
     */
    public void setACCRUALS_CV(BigDecimal ACCRUALS_CV) {
        this.ACCRUALS_CV = ACCRUALS_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.ACCRUALS_PORTFOLIO
     *
     * @return the value of PMSINVENTORY.ACCRUALS_PORTFOLIO
     */
    public BigDecimal getACCRUALS_PORTFOLIO() {
        return ACCRUALS_PORTFOLIO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.ACCRUALS_PORTFOLIO
     *
     * @param ACCRUALS_PORTFOLIO the value for PMSINVENTORY.ACCRUALS_PORTFOLIO
     */
    public void setACCRUALS_PORTFOLIO(BigDecimal ACCRUALS_PORTFOLIO) {
        this.ACCRUALS_PORTFOLIO = ACCRUALS_PORTFOLIO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.REVALUE_SECURITY
     *
     * @return the value of PMSINVENTORY.REVALUE_SECURITY
     */
    public BigDecimal getREVALUE_SECURITY() {
        return REVALUE_SECURITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.REVALUE_SECURITY
     *
     * @param REVALUE_SECURITY the value for PMSINVENTORY.REVALUE_SECURITY
     */
    public void setREVALUE_SECURITY(BigDecimal REVALUE_SECURITY) {
        this.REVALUE_SECURITY = REVALUE_SECURITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.REVALUE_PORTFOLIO
     *
     * @return the value of PMSINVENTORY.REVALUE_PORTFOLIO
     */
    public BigDecimal getREVALUE_PORTFOLIO() {
        return REVALUE_PORTFOLIO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.REVALUE_PORTFOLIO
     *
     * @param REVALUE_PORTFOLIO the value for PMSINVENTORY.REVALUE_PORTFOLIO
     */
    public void setREVALUE_PORTFOLIO(BigDecimal REVALUE_PORTFOLIO) {
        this.REVALUE_PORTFOLIO = REVALUE_PORTFOLIO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.REVALUE_CV
     *
     * @return the value of PMSINVENTORY.REVALUE_CV
     */
    public BigDecimal getREVALUE_CV() {
        return REVALUE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.REVALUE_CV
     *
     * @param REVALUE_CV the value for PMSINVENTORY.REVALUE_CV
     */
    public void setREVALUE_CV(BigDecimal REVALUE_CV) {
        this.REVALUE_CV = REVALUE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.ACCRUED_DIV_FC
     *
     * @return the value of PMSINVENTORY.ACCRUED_DIV_FC
     */
    public BigDecimal getACCRUED_DIV_FC() {
        return ACCRUED_DIV_FC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.ACCRUED_DIV_FC
     *
     * @param ACCRUED_DIV_FC the value for PMSINVENTORY.ACCRUED_DIV_FC
     */
    public void setACCRUED_DIV_FC(BigDecimal ACCRUED_DIV_FC) {
        this.ACCRUED_DIV_FC = ACCRUED_DIV_FC;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.ACCRUED_DIV_CV
     *
     * @return the value of PMSINVENTORY.ACCRUED_DIV_CV
     */
    public BigDecimal getACCRUED_DIV_CV() {
        return ACCRUED_DIV_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.ACCRUED_DIV_CV
     *
     * @param ACCRUED_DIV_CV the value for PMSINVENTORY.ACCRUED_DIV_CV
     */
    public void setACCRUED_DIV_CV(BigDecimal ACCRUED_DIV_CV) {
        this.ACCRUED_DIV_CV = ACCRUED_DIV_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.FUND_VALUE_SECURITY
     *
     * @return the value of PMSINVENTORY.FUND_VALUE_SECURITY
     */
    public BigDecimal getFUND_VALUE_SECURITY() {
        return FUND_VALUE_SECURITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.FUND_VALUE_SECURITY
     *
     * @param FUND_VALUE_SECURITY the value for PMSINVENTORY.FUND_VALUE_SECURITY
     */
    public void setFUND_VALUE_SECURITY(BigDecimal FUND_VALUE_SECURITY) {
        this.FUND_VALUE_SECURITY = FUND_VALUE_SECURITY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.FUND_VALUE_PORTFOLIO
     *
     * @return the value of PMSINVENTORY.FUND_VALUE_PORTFOLIO
     */
    public BigDecimal getFUND_VALUE_PORTFOLIO() {
        return FUND_VALUE_PORTFOLIO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.FUND_VALUE_PORTFOLIO
     *
     * @param FUND_VALUE_PORTFOLIO the value for PMSINVENTORY.FUND_VALUE_PORTFOLIO
     */
    public void setFUND_VALUE_PORTFOLIO(BigDecimal FUND_VALUE_PORTFOLIO) {
        this.FUND_VALUE_PORTFOLIO = FUND_VALUE_PORTFOLIO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.FUND_VALUE_CV
     *
     * @return the value of PMSINVENTORY.FUND_VALUE_CV
     */
    public BigDecimal getFUND_VALUE_CV() {
        return FUND_VALUE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.FUND_VALUE_CV
     *
     * @param FUND_VALUE_CV the value for PMSINVENTORY.FUND_VALUE_CV
     */
    public void setFUND_VALUE_CV(BigDecimal FUND_VALUE_CV) {
        this.FUND_VALUE_CV = FUND_VALUE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.ACCEPTANCE_DATE
     *
     * @return the value of PMSINVENTORY.ACCEPTANCE_DATE
     */
    public Date getACCEPTANCE_DATE() {
        return ACCEPTANCE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.ACCEPTANCE_DATE
     *
     * @param ACCEPTANCE_DATE the value for PMSINVENTORY.ACCEPTANCE_DATE
     */
    public void setACCEPTANCE_DATE(Date ACCEPTANCE_DATE) {
        this.ACCEPTANCE_DATE = ACCEPTANCE_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.VALUE_EXPOSURE
     *
     * @return the value of PMSINVENTORY.VALUE_EXPOSURE
     */
    public BigDecimal getVALUE_EXPOSURE() {
        return VALUE_EXPOSURE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.VALUE_EXPOSURE
     *
     * @param VALUE_EXPOSURE the value for PMSINVENTORY.VALUE_EXPOSURE
     */
    public void setVALUE_EXPOSURE(BigDecimal VALUE_EXPOSURE) {
        this.VALUE_EXPOSURE = VALUE_EXPOSURE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.REVALUE_EXPOSURE
     *
     * @return the value of PMSINVENTORY.REVALUE_EXPOSURE
     */
    public BigDecimal getREVALUE_EXPOSURE() {
        return REVALUE_EXPOSURE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.REVALUE_EXPOSURE
     *
     * @param REVALUE_EXPOSURE the value for PMSINVENTORY.REVALUE_EXPOSURE
     */
    public void setREVALUE_EXPOSURE(BigDecimal REVALUE_EXPOSURE) {
        this.REVALUE_EXPOSURE = REVALUE_EXPOSURE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.EXIT_QTY
     *
     * @return the value of PMSINVENTORY.EXIT_QTY
     */
    public BigDecimal getEXIT_QTY() {
        return EXIT_QTY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.EXIT_QTY
     *
     * @param EXIT_QTY the value for PMSINVENTORY.EXIT_QTY
     */
    public void setEXIT_QTY(BigDecimal EXIT_QTY) {
        this.EXIT_QTY = EXIT_QTY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.EXIT_AMT
     *
     * @return the value of PMSINVENTORY.EXIT_AMT
     */
    public BigDecimal getEXIT_AMT() {
        return EXIT_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.EXIT_AMT
     *
     * @param EXIT_AMT the value for PMSINVENTORY.EXIT_AMT
     */
    public void setEXIT_AMT(BigDecimal EXIT_AMT) {
        this.EXIT_AMT = EXIT_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.EXIT_AMT_CV
     *
     * @return the value of PMSINVENTORY.EXIT_AMT_CV
     */
    public BigDecimal getEXIT_AMT_CV() {
        return EXIT_AMT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.EXIT_AMT_CV
     *
     * @param EXIT_AMT_CV the value for PMSINVENTORY.EXIT_AMT_CV
     */
    public void setEXIT_AMT_CV(BigDecimal EXIT_AMT_CV) {
        this.EXIT_AMT_CV = EXIT_AMT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.EXIT_AMT_PF
     *
     * @return the value of PMSINVENTORY.EXIT_AMT_PF
     */
    public BigDecimal getEXIT_AMT_PF() {
        return EXIT_AMT_PF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.EXIT_AMT_PF
     *
     * @param EXIT_AMT_PF the value for PMSINVENTORY.EXIT_AMT_PF
     */
    public void setEXIT_AMT_PF(BigDecimal EXIT_AMT_PF) {
        this.EXIT_AMT_PF = EXIT_AMT_PF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.LAST_ACCRUAL_ENTRY_DATE
     *
     * @return the value of PMSINVENTORY.LAST_ACCRUAL_ENTRY_DATE
     */
    public Date getLAST_ACCRUAL_ENTRY_DATE() {
        return LAST_ACCRUAL_ENTRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.LAST_ACCRUAL_ENTRY_DATE
     *
     * @param LAST_ACCRUAL_ENTRY_DATE the value for PMSINVENTORY.LAST_ACCRUAL_ENTRY_DATE
     */
    public void setLAST_ACCRUAL_ENTRY_DATE(Date LAST_ACCRUAL_ENTRY_DATE) {
        this.LAST_ACCRUAL_ENTRY_DATE = LAST_ACCRUAL_ENTRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.LAST_ACCRUAL_DATE
     *
     * @return the value of PMSINVENTORY.LAST_ACCRUAL_DATE
     */
    public Date getLAST_ACCRUAL_DATE() {
        return LAST_ACCRUAL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.LAST_ACCRUAL_DATE
     *
     * @param LAST_ACCRUAL_DATE the value for PMSINVENTORY.LAST_ACCRUAL_DATE
     */
    public void setLAST_ACCRUAL_DATE(Date LAST_ACCRUAL_DATE) {
        this.LAST_ACCRUAL_DATE = LAST_ACCRUAL_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.FAIR_VALUE
     *
     * @return the value of PMSINVENTORY.FAIR_VALUE
     */
    public BigDecimal getFAIR_VALUE() {
        return FAIR_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.FAIR_VALUE
     *
     * @param FAIR_VALUE the value for PMSINVENTORY.FAIR_VALUE
     */
    public void setFAIR_VALUE(BigDecimal FAIR_VALUE) {
        this.FAIR_VALUE = FAIR_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.FAIR_VALUE_CV
     *
     * @return the value of PMSINVENTORY.FAIR_VALUE_CV
     */
    public BigDecimal getFAIR_VALUE_CV() {
        return FAIR_VALUE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.FAIR_VALUE_CV
     *
     * @param FAIR_VALUE_CV the value for PMSINVENTORY.FAIR_VALUE_CV
     */
    public void setFAIR_VALUE_CV(BigDecimal FAIR_VALUE_CV) {
        this.FAIR_VALUE_CV = FAIR_VALUE_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.FAIR_VALUE_PF
     *
     * @return the value of PMSINVENTORY.FAIR_VALUE_PF
     */
    public BigDecimal getFAIR_VALUE_PF() {
        return FAIR_VALUE_PF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.FAIR_VALUE_PF
     *
     * @param FAIR_VALUE_PF the value for PMSINVENTORY.FAIR_VALUE_PF
     */
    public void setFAIR_VALUE_PF(BigDecimal FAIR_VALUE_PF) {
        this.FAIR_VALUE_PF = FAIR_VALUE_PF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.SHARE_PREM_TOT
     *
     * @return the value of PMSINVENTORY.SHARE_PREM_TOT
     */
    public BigDecimal getSHARE_PREM_TOT() {
        return SHARE_PREM_TOT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.SHARE_PREM_TOT
     *
     * @param SHARE_PREM_TOT the value for PMSINVENTORY.SHARE_PREM_TOT
     */
    public void setSHARE_PREM_TOT(BigDecimal SHARE_PREM_TOT) {
        this.SHARE_PREM_TOT = SHARE_PREM_TOT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.SHARE_PREM_TOT_CV
     *
     * @return the value of PMSINVENTORY.SHARE_PREM_TOT_CV
     */
    public BigDecimal getSHARE_PREM_TOT_CV() {
        return SHARE_PREM_TOT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.SHARE_PREM_TOT_CV
     *
     * @param SHARE_PREM_TOT_CV the value for PMSINVENTORY.SHARE_PREM_TOT_CV
     */
    public void setSHARE_PREM_TOT_CV(BigDecimal SHARE_PREM_TOT_CV) {
        this.SHARE_PREM_TOT_CV = SHARE_PREM_TOT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.SHARE_PREM_TOT_PF
     *
     * @return the value of PMSINVENTORY.SHARE_PREM_TOT_PF
     */
    public BigDecimal getSHARE_PREM_TOT_PF() {
        return SHARE_PREM_TOT_PF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.SHARE_PREM_TOT_PF
     *
     * @param SHARE_PREM_TOT_PF the value for PMSINVENTORY.SHARE_PREM_TOT_PF
     */
    public void setSHARE_PREM_TOT_PF(BigDecimal SHARE_PREM_TOT_PF) {
        this.SHARE_PREM_TOT_PF = SHARE_PREM_TOT_PF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.LAST_CAP_ENTRY_DATE
     *
     * @return the value of PMSINVENTORY.LAST_CAP_ENTRY_DATE
     */
    public Date getLAST_CAP_ENTRY_DATE() {
        return LAST_CAP_ENTRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.LAST_CAP_ENTRY_DATE
     *
     * @param LAST_CAP_ENTRY_DATE the value for PMSINVENTORY.LAST_CAP_ENTRY_DATE
     */
    public void setLAST_CAP_ENTRY_DATE(Date LAST_CAP_ENTRY_DATE) {
        this.LAST_CAP_ENTRY_DATE = LAST_CAP_ENTRY_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.REVAL_AMT
     *
     * @return the value of PMSINVENTORY.REVAL_AMT
     */
    public BigDecimal getREVAL_AMT() {
        return REVAL_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.REVAL_AMT
     *
     * @param REVAL_AMT the value for PMSINVENTORY.REVAL_AMT
     */
    public void setREVAL_AMT(BigDecimal REVAL_AMT) {
        this.REVAL_AMT = REVAL_AMT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.REVAL_AMT_CV
     *
     * @return the value of PMSINVENTORY.REVAL_AMT_CV
     */
    public BigDecimal getREVAL_AMT_CV() {
        return REVAL_AMT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.REVAL_AMT_CV
     *
     * @param REVAL_AMT_CV the value for PMSINVENTORY.REVAL_AMT_CV
     */
    public void setREVAL_AMT_CV(BigDecimal REVAL_AMT_CV) {
        this.REVAL_AMT_CV = REVAL_AMT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.REVAL_AMT_PF
     *
     * @return the value of PMSINVENTORY.REVAL_AMT_PF
     */
    public BigDecimal getREVAL_AMT_PF() {
        return REVAL_AMT_PF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.REVAL_AMT_PF
     *
     * @param REVAL_AMT_PF the value for PMSINVENTORY.REVAL_AMT_PF
     */
    public void setREVAL_AMT_PF(BigDecimal REVAL_AMT_PF) {
        this.REVAL_AMT_PF = REVAL_AMT_PF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.GOODWILL_AMOUNT
     *
     * @return the value of PMSINVENTORY.GOODWILL_AMOUNT
     */
    public BigDecimal getGOODWILL_AMOUNT() {
        return GOODWILL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.GOODWILL_AMOUNT
     *
     * @param GOODWILL_AMOUNT the value for PMSINVENTORY.GOODWILL_AMOUNT
     */
    public void setGOODWILL_AMOUNT(BigDecimal GOODWILL_AMOUNT) {
        this.GOODWILL_AMOUNT = GOODWILL_AMOUNT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.GOODWILL_AMOUNT_CV
     *
     * @return the value of PMSINVENTORY.GOODWILL_AMOUNT_CV
     */
    public BigDecimal getGOODWILL_AMOUNT_CV() {
        return GOODWILL_AMOUNT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.GOODWILL_AMOUNT_CV
     *
     * @param GOODWILL_AMOUNT_CV the value for PMSINVENTORY.GOODWILL_AMOUNT_CV
     */
    public void setGOODWILL_AMOUNT_CV(BigDecimal GOODWILL_AMOUNT_CV) {
        this.GOODWILL_AMOUNT_CV = GOODWILL_AMOUNT_CV;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PMSINVENTORY.GOODWILL_AMOUNT_PF
     *
     * @return the value of PMSINVENTORY.GOODWILL_AMOUNT_PF
     */
    public BigDecimal getGOODWILL_AMOUNT_PF() {
        return GOODWILL_AMOUNT_PF;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PMSINVENTORY.GOODWILL_AMOUNT_PF
     *
     * @param GOODWILL_AMOUNT_PF the value for PMSINVENTORY.GOODWILL_AMOUNT_PF
     */
    public void setGOODWILL_AMOUNT_PF(BigDecimal GOODWILL_AMOUNT_PF) {
        this.GOODWILL_AMOUNT_PF = GOODWILL_AMOUNT_PF;
    }
}