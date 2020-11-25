package com.path.vo.reporting;

import java.io.Serializable;

import com.path.dbmaps.vo.IRP_REP_ARG_CONSTRAINTSVO;
import com.path.lib.vo.BaseVO;

public class IRP_REP_ARG_CONSTRAINTSCO extends BaseVO implements Serializable
{
    private   IRP_REP_ARG_CONSTRAINTSVO irpRepArgConstraintsVO = new IRP_REP_ARG_CONSTRAINTSVO();
    private String CASE_SENSITIVITY;
    private String MAX_LENGTH;
    private String MAX_VAL;
    private String MIN_VAL;
    private String FORMAT;
    private String CONDITION;
    private String SHOW_EXPR;
    private String HIDE_EXPR;
    private String BTR_CONTROL_DISP;

    

    public String getBTR_CONTROL_DISP()
    {
        return BTR_CONTROL_DISP;
    }

    public void setBTR_CONTROL_DISP(String bTRCONTROLDISP)
    {
        BTR_CONTROL_DISP = bTRCONTROLDISP;
    }

    public String getCASE_SENSITIVITY()
    {
        return CASE_SENSITIVITY;
    }

    public void setCASE_SENSITIVITY(String cASESENSITIVITY)
    {
        CASE_SENSITIVITY = cASESENSITIVITY;
    }

    public String getMAX_LENGTH()
    {
        return MAX_LENGTH;
    }

    public void setMAX_LENGTH(String mAXLENGTH)
    {
        MAX_LENGTH = mAXLENGTH;
    }

    public String getMAX_VAL()
    {
        return MAX_VAL;
    }

    public void setMAX_VAL(String mAXVAL)
    {
        MAX_VAL = mAXVAL;
    }

    public String getMIN_VAL()
    {
        return MIN_VAL;
    }

    public void setMIN_VAL(String mINVAL)
    {
        MIN_VAL = mINVAL;
    }

    public String getFORMAT()
    {
        return FORMAT;
    }

    public void setFORMAT(String fORMAT)
    {
        FORMAT = fORMAT;
    }

    public String getCONDITION()
    {
        return CONDITION;
    }

    public void setCONDITION(String cONDITION)
    {
        CONDITION = cONDITION;
    }

    public String getSHOW_EXPR()
    {
        return SHOW_EXPR;
    }

    public void setSHOW_EXPR(String sHOWEXPR)
    {
        SHOW_EXPR = sHOWEXPR;
    }

    public String getHIDE_EXPR()
    {
        return HIDE_EXPR;
    }

    public void setHIDE_EXPR(String hIDEEXPR)
    {
        HIDE_EXPR = hIDEEXPR;
    }

    public IRP_REP_ARG_CONSTRAINTSVO getIrpRepArgConstraintsVO()
    {
        return irpRepArgConstraintsVO;
    }

    public void setIrpRepArgConstraintsVO(IRP_REP_ARG_CONSTRAINTSVO irpRepArgConstraintsVO)
    {
        this.irpRepArgConstraintsVO = irpRepArgConstraintsVO;
    }
    
}
