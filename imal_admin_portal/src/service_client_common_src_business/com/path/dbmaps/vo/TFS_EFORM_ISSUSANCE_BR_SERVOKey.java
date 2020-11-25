package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class TFS_EFORM_ISSUSANCE_BR_SERVOKey extends BaseVO {
    /**
     * This field corresponds to the database column IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.BRANCH_CODE
     */
    private BigDecimal BRANCH_CODE;

    /**
     * This field corresponds to the database column IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.COMP_CODE
     */
    private BigDecimal COMP_CODE;

    /**
     * This field corresponds to the database column IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.LINE_NO
     */
    private BigDecimal LINE_NO;

    /**
     * This field corresponds to the database column IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.SERIAL
     */
    private String SERIAL;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.BRANCH_CODE
     *
     * @return the value of IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.BRANCH_CODE
     */
    public BigDecimal getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.BRANCH_CODE
     *
     * @param BRANCH_CODE the value for IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.BRANCH_CODE
     */
    public void setBRANCH_CODE(BigDecimal BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.COMP_CODE
     *
     * @return the value of IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.COMP_CODE
     */
    public BigDecimal getCOMP_CODE() {
        return COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.COMP_CODE
     *
     * @param COMP_CODE the value for IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.COMP_CODE
     */
    public void setCOMP_CODE(BigDecimal COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.LINE_NO
     *
     * @return the value of IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.LINE_NO
     */
    public BigDecimal getLINE_NO() {
        return LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.LINE_NO
     *
     * @param LINE_NO the value for IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.LINE_NO
     */
    public void setLINE_NO(BigDecimal LINE_NO) {
        this.LINE_NO = LINE_NO;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.SERIAL
     *
     * @return the value of IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.SERIAL
     */
    public String getSERIAL() {
        return SERIAL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.SERIAL
     *
     * @param SERIAL the value for IMAL141_DEV_O11.TFS_EFORM_ISSUSANCE_BR_SER.SERIAL
     */
    public void setSERIAL(String SERIAL) {
        this.SERIAL = SERIAL == null ? null : SERIAL.trim();
    }
}