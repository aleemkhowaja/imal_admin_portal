package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class TRS_PROV_PROCESS_AMENDVOKey extends BaseVO {
    /**
     * This field corresponds to the database column TRS_PROV_PROCESS_AMEND.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column TRS_PROV_PROCESS_AMEND.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column TRS_PROV_PROCESS_AMEND.TRX_DATE
     */
    private Date TRX_DATE;

    /**
     * This field corresponds to the database column TRS_PROV_PROCESS_AMEND.TRX_NO
     */
    private BigDecimal TRX_NO;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROV_PROCESS_AMEND.BRANCH_CODE
     *
     * @return the value of TRS_PROV_PROCESS_AMEND.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROV_PROCESS_AMEND.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for TRS_PROV_PROCESS_AMEND.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROV_PROCESS_AMEND.COMP_CODE
     *
     * @return the value of TRS_PROV_PROCESS_AMEND.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROV_PROCESS_AMEND.COMP_CODE
     *
     * @param COMP_CODE the value for TRS_PROV_PROCESS_AMEND.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROV_PROCESS_AMEND.TRX_DATE
     *
     * @return the value of TRS_PROV_PROCESS_AMEND.TRX_DATE
     */
    public Date getTRX_DATE() {
        return TRX_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROV_PROCESS_AMEND.TRX_DATE
     *
     * @param TRX_DATE the value for TRS_PROV_PROCESS_AMEND.TRX_DATE
     */
    public void setTRX_DATE(Date TRX_DATE) {
        this.TRX_DATE = TRX_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TRS_PROV_PROCESS_AMEND.TRX_NO
     *
     * @return the value of TRS_PROV_PROCESS_AMEND.TRX_NO
     */
    public BigDecimal getTRX_NO() {
        return TRX_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TRS_PROV_PROCESS_AMEND.TRX_NO
     *
     * @param TRX_NO the value for TRS_PROV_PROCESS_AMEND.TRX_NO
     */
    public void setTRX_NO(BigDecimal TRX_NO) {
        this.TRX_NO = TRX_NO;
    }
}