package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TRSCOLLATERALDETVO extends TRSCOLLATERALDETVOKey {
    /**
     * This field corresponds to the database column TRSCOLLATERALDET.DEAL_ALLOCATED
     */
    private BigDecimal DEAL_ALLOCATED;

    /**
     * This field corresponds to the database column TRSCOLLATERALDET.COLLATERAL_LINKED_DATE
     */
    private Date COLLATERAL_LINKED_DATE;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCOLLATERALDET.DEAL_ALLOCATED
     *
     * @return the value of TRSCOLLATERALDET.DEAL_ALLOCATED
     */
    public BigDecimal getDEAL_ALLOCATED() {
        return DEAL_ALLOCATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCOLLATERALDET.DEAL_ALLOCATED
     *
     * @param DEAL_ALLOCATED the value for TRSCOLLATERALDET.DEAL_ALLOCATED
     */
    public void setDEAL_ALLOCATED(BigDecimal DEAL_ALLOCATED) {
        this.DEAL_ALLOCATED = DEAL_ALLOCATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRSCOLLATERALDET.COLLATERAL_LINKED_DATE
     *
     * @return the value of TRSCOLLATERALDET.COLLATERAL_LINKED_DATE
     */
    public Date getCOLLATERAL_LINKED_DATE() {
        return COLLATERAL_LINKED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRSCOLLATERALDET.COLLATERAL_LINKED_DATE
     *
     * @param COLLATERAL_LINKED_DATE the value for TRSCOLLATERALDET.COLLATERAL_LINKED_DATE
     */
    public void setCOLLATERAL_LINKED_DATE(Date COLLATERAL_LINKED_DATE) {
        this.COLLATERAL_LINKED_DATE = COLLATERAL_LINKED_DATE;
    }
}