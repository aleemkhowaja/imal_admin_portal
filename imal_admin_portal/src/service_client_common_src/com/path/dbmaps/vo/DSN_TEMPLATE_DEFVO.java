package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;

public class DSN_TEMPLATE_DEFVO extends BaseVO {
    /**
     * This field corresponds to the database column DSN_TEMPLATE_DEF.TEMPLATE_ID
     */
    private BigDecimal TEMPLATE_ID;

    /**
     * This field corresponds to the database column DSN_TEMPLATE_DEF.TEMPLATE_NAME
     */
    private String TEMPLATE_NAME;

    /**
     * This field corresponds to the database column DSN_TEMPLATE_DEF.APP_ID
     */
    private BigDecimal APP_ID;
    private String BRIEF_NAME;
    /**
     * This field corresponds to the database column DSN_TEMPLATE_DEF.APP_FUNC_ID
     */
    private String APP_FUNC_ID;
    private String APP_FN_DESC;

    /**
     * This field corresponds to the database column DSN_TEMPLATE_DEF.IS_DEFAULT
     */
    private BigDecimal IS_DEFAULT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSN_TEMPLATE_DEF.TEMPLATE_ID
     *
     * @return the value of DSN_TEMPLATE_DEF.TEMPLATE_ID
     */
    public BigDecimal getTEMPLATE_ID() {
        return TEMPLATE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSN_TEMPLATE_DEF.TEMPLATE_ID
     *
     * @param TEMPLATE_ID the value for DSN_TEMPLATE_DEF.TEMPLATE_ID
     */
    public void setTEMPLATE_ID(BigDecimal TEMPLATE_ID) {
        this.TEMPLATE_ID = TEMPLATE_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSN_TEMPLATE_DEF.TEMPLATE_NAME
     *
     * @return the value of DSN_TEMPLATE_DEF.TEMPLATE_NAME
     */
    public String getTEMPLATE_NAME() {
        return TEMPLATE_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSN_TEMPLATE_DEF.TEMPLATE_NAME
     *
     * @param TEMPLATE_NAME the value for DSN_TEMPLATE_DEF.TEMPLATE_NAME
     */
    public void setTEMPLATE_NAME(String TEMPLATE_NAME) {
        this.TEMPLATE_NAME = TEMPLATE_NAME == null ? null : TEMPLATE_NAME.trim();
    }



    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSN_TEMPLATE_DEF.IS_DEFAULT
     *
     * @return the value of DSN_TEMPLATE_DEF.IS_DEFAULT
     */
    public BigDecimal getIS_DEFAULT() {
        return IS_DEFAULT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSN_TEMPLATE_DEF.IS_DEFAULT
     *
     * @param IS_DEFAULT the value for DSN_TEMPLATE_DEF.IS_DEFAULT
     */
    public void setIS_DEFAULT(BigDecimal IS_DEFAULT) {
        this.IS_DEFAULT = IS_DEFAULT;
    }


    /**
     * @return the aPP_ID
     */
    public BigDecimal getAPP_ID()
    {
        return APP_ID;
    }

    /**
     * @param aPPID the aPP_ID to set
     */
    public void setAPP_ID(BigDecimal aPPID)
    {
        APP_ID = aPPID;
    }

    /**
     * @return the bRIEF_NAME
     */
    public String getBRIEF_NAME()
    {
        return BRIEF_NAME;
    }

    /**
     * @param bRIEFNAME the bRIEF_NAME to set
     */
    public void setBRIEF_NAME(String bRIEFNAME)
    {
        BRIEF_NAME = bRIEFNAME;
    }

    /**
     * @return the aPP_FN_DESC
     */
    public String getAPP_FN_DESC()
    {
        return APP_FN_DESC;
    }

    /**
     * @param aPPFNDESC the aPP_FN_DESC to set
     */
    public void setAPP_FN_DESC(String aPPFNDESC)
    {
        APP_FN_DESC = aPPFNDESC;
    }

    /**
     * @return the aPP_FUNC_ID
     */
    public String getAPP_FUNC_ID()
    {
        return APP_FUNC_ID;
    }

    /**
     * @param aPPFUNCID the aPP_FUNC_ID to set
     */
    public void setAPP_FUNC_ID(String aPPFUNCID)
    {
        APP_FUNC_ID = aPPFUNCID;
    }
}