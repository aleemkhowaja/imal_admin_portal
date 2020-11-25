package com.path.dbmaps.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.vo.common.LabelElemCO;

public class SYS_PARAM_SCREEN_DISPLAYVO extends SYS_PARAM_SCREEN_DISPLAYVOKey {
    /**
     * This is Custom Field not located in the database, used for specifying the format for numeric Fields
     */
    private String decFormat;
    /**
     * specifies the format patterns for text Fields
     */
    private String txtFormat;
    /**
     * This is Custom Field not located in the database, used for specifying the value for the Field
     */
    private Object value;
    /**
     * This is Custom Field not located in the database, used for specifying the value for the DATE Field
     */
    private Date dateValue;
    
    private String status;
    /**
     * used to specify whether we need to overwrite readonly Flag or Not
     */
    private Boolean overWriteReadOnly;
    /**
     * Expression used for Visibility
     */
    private String VISIBILITY_EXPR;
    /**
     * Expression used for ReadOnly
     */
    private String READONLY_EXPR;
    /**
     * Expression used for ReadOnly
     */
    private String MANDATORY_EXPR;
    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_DISPLAY.BUS_RELATED
     */
    private BigDecimal BUS_RELATED;
    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_DISPLAY.IS_MANDATORY
     */
    private BigDecimal IS_MANDATORY;

    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_DISPLAY.IS_VISIBLE
     */
    private BigDecimal IS_VISIBLE;

    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_DISPLAY.IS_READONLY
     */
    private BigDecimal IS_READONLY;

    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_DISPLAY.ARABIC_DEPENDANT
     */
    private BigDecimal ARABIC_DEPENDANT;

    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_DISPLAY.MESSAGE_CODE
     */
    private BigDecimal MESSAGE_CODE;

    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_DISPLAY.ZERO_NOT_ALLOWED
     */
    private BigDecimal ZERO_NOT_ALLOWED;

    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_DISPLAY.TRIM_STRING
     */
    private BigDecimal TRIM_STRING;

    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_DISPLAY.LABEL_KEY
     */
    private String LABEL_KEY;

    /**
     * This field corresponds to the database column SYS_PARAM_SCREEN_DISPLAY.MAX_LENGTH
     */
    private BigDecimal MAX_LENGTH;

    private String LABEL_KEY_EXPR;
    private String ZERO_NOT_ALLOWED_EXPR;
    
    private String VALUE_VALID_EXPR;
    private String KEYBOARD_SHORTCUT_KEY;
    private String DEFAULT_VALUE; 
    private String ACTIVITY_TYPE; 
    private BigDecimal ACTIVITY_ID;
    
    /**
     * This field stores the label key after dependency/ load labelKeyVal
     */
    private String labelKeyVal;
    
    /**
     * hide and override business based on expresssion
     */
    private Boolean hideOverBusBasedExpr;
    /**
     * Hide and override Business 
     */
    private Boolean hideOverBusiness;
    
    private List<LabelElemCO> labelsLst;
    
    private BigDecimal IS_ADM_CUST_DIS_YN;								
    private BigDecimal ENABLE_FIELD_AUDIT_YN;															
    
    /**
     * specify the min length of a text field, mode = text
     */
    private BigDecimal MIN_LENGTH;
    
    private String DEFAULT_VALUE_EXPR;
    private BigDecimal DFLT_VAL_EXPR_PRIORITY_YN;
    private String triggerChange;
    private BigDecimal elemSequenceId;
    
    /**
     * specify the screen width when opening a dynamic screen
     */
    private BigDecimal SCREEN_WIDTH;
    /**
     * specify the screen height when opening a dynamic screen
     */
    private BigDecimal SCREEN_HEIGHT;
    /**
     * specify the BACKGROUND_COLOR of an element
     */
    private String BACKGROUND_COLOR;
    /**
     * specify the BACKGROUND_COLOR_EXPR of an element
     */
    private String BACKGROUND_COLOR_EXPR;
    
    //AUBBHU200146 - Performance in CSM
	//Added custom element activities data to cache
    private BigDecimal activitiesCount;
    
    /**
     * TP #945072 - Adding tooltip option via SYS_PARAM_SCREEN_DISPLAY_VO
     */
    private String tooltip;
    
    public BigDecimal getENABLE_FIELD_AUDIT_YN()
    {
        return ENABLE_FIELD_AUDIT_YN;
    }


    public void setENABLE_FIELD_AUDIT_YN(BigDecimal eNABLE_FIELD_AUDIT_YN)
    {
        ENABLE_FIELD_AUDIT_YN = eNABLE_FIELD_AUDIT_YN;
    }


    public BigDecimal getIS_ADM_CUST_DIS_YN()
    {
        return IS_ADM_CUST_DIS_YN;
    }

    
    public void setIS_ADM_CUST_DIS_YN(BigDecimal iS_ADM_CUST_DIS_YN)
    {
        IS_ADM_CUST_DIS_YN = iS_ADM_CUST_DIS_YN;
    }

    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_SCREEN_DISPLAY.IS_MANDATORY
     *
     * @return the value of SYS_PARAM_SCREEN_DISPLAY.IS_MANDATORY
     */
    public BigDecimal getIS_MANDATORY() {
        return IS_MANDATORY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_SCREEN_DISPLAY.IS_MANDATORY
     *
     * @param IS_MANDATORY the value for SYS_PARAM_SCREEN_DISPLAY.IS_MANDATORY
     */
    public void setIS_MANDATORY(BigDecimal IS_MANDATORY) {
        this.IS_MANDATORY = IS_MANDATORY;
    }

        
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_SCREEN_DISPLAY.IS_VISIBLE
     *
     * @return the value of SYS_PARAM_SCREEN_DISPLAY.IS_VISIBLE
     */
    public BigDecimal getIS_VISIBLE() {
        return IS_VISIBLE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_SCREEN_DISPLAY.IS_VISIBLE
     *
     * @param IS_VISIBLE the value for SYS_PARAM_SCREEN_DISPLAY.IS_VISIBLE
     */
    public void setIS_VISIBLE(BigDecimal IS_VISIBLE) {
        this.IS_VISIBLE = IS_VISIBLE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_SCREEN_DISPLAY.IS_READONLY
     *
     * @return the value of SYS_PARAM_SCREEN_DISPLAY.IS_READONLY
     */
    public BigDecimal getIS_READONLY() {
        return IS_READONLY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_SCREEN_DISPLAY.IS_READONLY
     *
     * @param IS_READONLY the value for SYS_PARAM_SCREEN_DISPLAY.IS_READONLY
     */
    public void setIS_READONLY(BigDecimal IS_READONLY) {
        this.IS_READONLY = IS_READONLY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_SCREEN_DISPLAY.ARABIC_DEPENDANT
     *
     * @return the value of SYS_PARAM_SCREEN_DISPLAY.ARABIC_DEPENDANT
     */
    public BigDecimal getARABIC_DEPENDANT() {
        return ARABIC_DEPENDANT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_SCREEN_DISPLAY.ARABIC_DEPENDANT
     *
     * @param ARABIC_DEPENDANT the value for SYS_PARAM_SCREEN_DISPLAY.ARABIC_DEPENDANT
     */
    public void setARABIC_DEPENDANT(BigDecimal ARABIC_DEPENDANT) {
        this.ARABIC_DEPENDANT = ARABIC_DEPENDANT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_SCREEN_DISPLAY.MESSAGE_CODE
     *
     * @return the value of SYS_PARAM_SCREEN_DISPLAY.MESSAGE_CODE
     */
    public BigDecimal getMESSAGE_CODE() {
        return MESSAGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_SCREEN_DISPLAY.MESSAGE_CODE
     *
     * @param MESSAGE_CODE the value for SYS_PARAM_SCREEN_DISPLAY.MESSAGE_CODE
     */
    public void setMESSAGE_CODE(BigDecimal MESSAGE_CODE) {
        this.MESSAGE_CODE = MESSAGE_CODE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_SCREEN_DISPLAY.ZERO_NOT_ALLOWED
     *
     * @return the value of SYS_PARAM_SCREEN_DISPLAY.ZERO_NOT_ALLOWED
     */
    public BigDecimal getZERO_NOT_ALLOWED() {
        return ZERO_NOT_ALLOWED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_SCREEN_DISPLAY.ZERO_NOT_ALLOWED
     *
     * @param ZERO_NOT_ALLOWED the value for SYS_PARAM_SCREEN_DISPLAY.ZERO_NOT_ALLOWED
     */
    public void setZERO_NOT_ALLOWED(BigDecimal ZERO_NOT_ALLOWED) {
        this.ZERO_NOT_ALLOWED = ZERO_NOT_ALLOWED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_SCREEN_DISPLAY.TRIM_STRING
     *
     * @return the value of SYS_PARAM_SCREEN_DISPLAY.TRIM_STRING
     */
    public BigDecimal getTRIM_STRING() {
        return TRIM_STRING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_SCREEN_DISPLAY.TRIM_STRING
     *
     * @param TRIM_STRING the value for SYS_PARAM_SCREEN_DISPLAY.TRIM_STRING
     */
    public void setTRIM_STRING(BigDecimal TRIM_STRING) {
        this.TRIM_STRING = TRIM_STRING;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_SCREEN_DISPLAY.LABEL_KEY
     *
     * @return the value of SYS_PARAM_SCREEN_DISPLAY.LABEL_KEY
     */
    public String getLABEL_KEY() {
        return LABEL_KEY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_SCREEN_DISPLAY.LABEL_KEY
     *
     * @param LABEL_KEY the value for SYS_PARAM_SCREEN_DISPLAY.LABEL_KEY
     */
    public void setLABEL_KEY(String LABEL_KEY) {
        this.LABEL_KEY = LABEL_KEY == null ? null : LABEL_KEY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_SCREEN_DISPLAY.MAX_LENGTH
     *
     * @return the value of SYS_PARAM_SCREEN_DISPLAY.MAX_LENGTH
     */
    public BigDecimal getMAX_LENGTH() {
        return MAX_LENGTH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_SCREEN_DISPLAY.MAX_LENGTH
     *
     * @param MAX_LENGTH the value for SYS_PARAM_SCREEN_DISPLAY.MAX_LENGTH
     */
    public void setMAX_LENGTH(BigDecimal MAX_LENGTH) {
        this.MAX_LENGTH = MAX_LENGTH;
    }

    public String getDecFormat()
    {
        return decFormat;
    }

    public void setDecFormat(String decFormat)
    {
        this.decFormat = decFormat;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public Boolean getOverWriteReadOnly()
    {
        return overWriteReadOnly;
    }

    public void setOverWriteReadOnly(Boolean overWriteReadOnly)
    {
        this.overWriteReadOnly = overWriteReadOnly;
    }

    public String getTxtFormat()
    {
        return txtFormat;
    }

    public void setTxtFormat(String txtFormat)
    {
        this.txtFormat = txtFormat;
    }

    public BigDecimal getBUS_RELATED()
    {
        return BUS_RELATED;
    }

    public void setBUS_RELATED(BigDecimal bUS_RELATED)
    {
        BUS_RELATED = bUS_RELATED;
    }

    public String getVISIBILITY_EXPR()
    {
        return VISIBILITY_EXPR;
    }

    public void setVISIBILITY_EXPR(String vISIBILITY_EXPR)
    {
        VISIBILITY_EXPR = vISIBILITY_EXPR;
    }

    public String getREADONLY_EXPR()
    {
        return READONLY_EXPR;
    }

    public void setREADONLY_EXPR(String rEADONLY_EXPR)
    {
        READONLY_EXPR = rEADONLY_EXPR;
    }

    public String getMANDATORY_EXPR()
    {
        return MANDATORY_EXPR;
    }

    public void setMANDATORY_EXPR(String mANDATORY_EXPR)
    {
        MANDATORY_EXPR = mANDATORY_EXPR;
    }

    public Date getDateValue()
    {
        return dateValue;
    }

    public void setDateValue(Date dateValue)
    {
        this.dateValue = dateValue;
    }

    /**
     * @return the lABEL_KEY_EXPR
     */
    public String getLABEL_KEY_EXPR()
    {
        return LABEL_KEY_EXPR;
    }

    /**
     * @param lABELKEYEXPR the lABEL_KEY_EXPR to set
     */
    public void setLABEL_KEY_EXPR(String lABELKEYEXPR)
    {
        LABEL_KEY_EXPR = lABELKEYEXPR;
    }

    /**
     * @return the zERO_NOT_ALLOWED_EXPR
     */
    public String getZERO_NOT_ALLOWED_EXPR()
    {
        return ZERO_NOT_ALLOWED_EXPR;
    }

    /**
     * @param zERONOTALLOWEDEXPR the zERO_NOT_ALLOWED_EXPR to set
     */
    public void setZERO_NOT_ALLOWED_EXPR(String zERONOTALLOWEDEXPR)
    {
        ZERO_NOT_ALLOWED_EXPR = zERONOTALLOWEDEXPR;
    }

    public String getLabelKeyVal()
    {
        return labelKeyVal;
    }

    public void setLabelKeyVal(String labelKeyVal)
    {
        this.labelKeyVal = labelKeyVal;
    }

    /**
     * @return the hideOverBusBasedExpr
     */
    public Boolean getHideOverBusBasedExpr()
    {
        return hideOverBusBasedExpr;
    }

    /**
     * @param hideOverBusBasedExpr the hideOverBusBasedExpr to set
     */
    public void setHideOverBusBasedExpr(Boolean hideOverBusBasedExpr)
    {
        this.hideOverBusBasedExpr = hideOverBusBasedExpr;
    }

    /**
     * @return the hideOverBusiness
     */
    public Boolean getHideOverBusiness()
    {
        return hideOverBusiness;
    }

    /**
     * @param hideOverBusiness the hideOverBusiness to set
     */
    public void setHideOverBusiness(Boolean hideOverBusiness)
    {
        this.hideOverBusiness = hideOverBusiness;
    }

    public String getVALUE_VALID_EXPR()
    {
        return VALUE_VALID_EXPR;
    }

    public void setVALUE_VALID_EXPR(String vALUEVALIDEXPR)
    {
        VALUE_VALID_EXPR = vALUEVALIDEXPR;
    }

    public String getKEYBOARD_SHORTCUT_KEY()
    {
        return KEYBOARD_SHORTCUT_KEY;
    }

    public void setKEYBOARD_SHORTCUT_KEY(String kEYBOARDSHORTCUTKEY)
    {
        KEYBOARD_SHORTCUT_KEY = kEYBOARDSHORTCUTKEY;
    }

    public String getDEFAULT_VALUE()
    {
        return DEFAULT_VALUE;
    }

    public void setDEFAULT_VALUE(String dEFAULTVALUE)
    {
        DEFAULT_VALUE = dEFAULTVALUE;
    }

    public List<LabelElemCO> getLabelsLst()
    {
        return labelsLst;
    }

    public void setLabelsLst(List<LabelElemCO> labelsLst)
    {
        this.labelsLst = labelsLst;
    }

    public String getACTIVITY_TYPE()
    {
        return ACTIVITY_TYPE;
    }

    public void setACTIVITY_TYPE(String aCTIVITYTYPE)
    {
        ACTIVITY_TYPE = aCTIVITYTYPE;
    }

    public BigDecimal getACTIVITY_ID()
    {
        return ACTIVITY_ID;
    }

    public void setACTIVITY_ID(BigDecimal aCTIVITYID)
    {
        ACTIVITY_ID = aCTIVITYID;
    }

    public BigDecimal getMIN_LENGTH()
    {
        return MIN_LENGTH;
    }

    public void setMIN_LENGTH(BigDecimal mINLENGTH)
    {
        MIN_LENGTH = mINLENGTH;
    }


    public String getDEFAULT_VALUE_EXPR()
    {
        return DEFAULT_VALUE_EXPR;
    }


    public void setDEFAULT_VALUE_EXPR(String dEFAULT_VALUE_EXPR)
    {
        DEFAULT_VALUE_EXPR = dEFAULT_VALUE_EXPR;
    }


    public BigDecimal getDFLT_VAL_EXPR_PRIORITY_YN()
    {
        return DFLT_VAL_EXPR_PRIORITY_YN;
    }


    public void setDFLT_VAL_EXPR_PRIORITY_YN(BigDecimal dFLT_VAL_EXPR_PRIORITY_YN)
    {
        DFLT_VAL_EXPR_PRIORITY_YN = dFLT_VAL_EXPR_PRIORITY_YN;
    }


    public String getTriggerChange()
    {
        return triggerChange;
    }


    public void setTriggerChange(String triggerChange)
    {
        this.triggerChange = triggerChange;
    }


    /**
     * @return the sCREEN_WIDTH
     */
    public BigDecimal getSCREEN_WIDTH()
    {
        return SCREEN_WIDTH;
    }


    /**
     * @param sCREEN_WIDTH the sCREEN_WIDTH to set
     */
    public void setSCREEN_WIDTH(BigDecimal sCREEN_WIDTH)
    {
        SCREEN_WIDTH = sCREEN_WIDTH;
    }


    /**
     * @return the sCREEN_HEIGHT
     */
    public BigDecimal getSCREEN_HEIGHT()
    {
        return SCREEN_HEIGHT;
    }


    /**
     * @param sCREEN_HEIGHT the sCREEN_HEIGHT to set
     */
    public void setSCREEN_HEIGHT(BigDecimal sCREEN_HEIGHT)
    {
        SCREEN_HEIGHT = sCREEN_HEIGHT;
    }


    /**
     * @return the bACKGROUND_COLOR
     */
    public String getBACKGROUND_COLOR()
    {
        return BACKGROUND_COLOR;
    }


    /**
     * @param bACKGROUND_COLOR the bACKGROUND_COLOR to set
     */
    public void setBACKGROUND_COLOR(String bACKGROUND_COLOR)
    {
        BACKGROUND_COLOR = bACKGROUND_COLOR;
    }
    
    /**
     * 
     * @return the BACKGROUND_COLOR_EXPR
     */
    public String getBACKGROUND_COLOR_EXPR()
    {
        return BACKGROUND_COLOR_EXPR;
    }
    /**
     * 
     * @param bACKGROUND_COLOR_EXPR the BACKGROUND_COLOR_EXPR to set
     */
    public void setBACKGROUND_COLOR_EXPR(String bACKGROUND_COLOR_EXPR)
    {
        BACKGROUND_COLOR_EXPR = bACKGROUND_COLOR_EXPR;
    }


    public BigDecimal getElemSequenceId()
    {
        return elemSequenceId;
    }


    public void setElemSequenceId(BigDecimal elemSequenceId)
    {
        this.elemSequenceId = elemSequenceId;
    }


    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }


    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }


	public String getTooltip() 
	{
		return tooltip;
	}
	
	public void setTooltip(String tooltip) 
	{
		this.tooltip = tooltip;
	}


	public BigDecimal getActivitiesCount() {
		return activitiesCount;
	}


	public void setActivitiesCount(BigDecimal activitiesCount) {
		this.activitiesCount = activitiesCount;
	}

    
}