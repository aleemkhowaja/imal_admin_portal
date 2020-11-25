package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;
import java.math.BigDecimal;
import java.util.Date;

public class SYS_PARAM_OBJ_DETAILS_DISPLAYVO extends BaseVO {
    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.OBJ_DET_NAME
     */
    private String OBJ_DET_NAME;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.OBJ_DISPLAY_ID
     */
    private BigDecimal OBJ_DISPLAY_ID;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_READONLY
     */
    private BigDecimal IS_READONLY;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_VISIBLE
     */
    private BigDecimal IS_VISIBLE;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_MANDATORY
     */
    private BigDecimal IS_MANDATORY;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.LABEL_KEY
     */
    private String LABEL_KEY;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.DEFAULT_VALUE
     */
    private String DEFAULT_VALUE;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MIN_LENGTH
     */
    private BigDecimal MIN_LENGTH;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MAX_LENGTH
     */
    private BigDecimal MAX_LENGTH;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.DFLT_VAL_EXPR_PRIORITY_YN
     */
    private BigDecimal DFLT_VAL_EXPR_PRIORITY_YN;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_ADM_CUST_DIS_YN
     */
    private BigDecimal IS_ADM_CUST_DIS_YN;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.CREATED_BY
     */
    private String CREATED_BY;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.CREATED_DATE
     */
    private Date CREATED_DATE;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MODIFIED_BY
     */
    private String MODIFIED_BY;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MODIFIED_DATE
     */
    private Date MODIFIED_DATE;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.READONLY_EXPR
     */
    private String READONLY_EXPR;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.VISIBILITY_EXPR
     */
    private String VISIBILITY_EXPR;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MANDATORY_EXPR
     */
    private String MANDATORY_EXPR;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.LABEL_KEY_EXPR
     */
    private String LABEL_KEY_EXPR;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.VALUE_VALID_EXPR
     */
    private String VALUE_VALID_EXPR;

    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.DEFAULT_VALUE_EXPR
     */
    private String DEFAULT_VALUE_EXPR;
    
    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.BUS_RELATED
     */
    private BigDecimal BUS_RELATED;
    
    /**
     * This field corresponds to the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.ENABLE_FIELD_AUDIT_YN
     */
    private String ENABLE_FIELD_AUDIT_YN;
    
    

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.OBJ_DET_NAME
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.OBJ_DET_NAME
     */
    public String getOBJ_DET_NAME() {
        return OBJ_DET_NAME;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.OBJ_DET_NAME
     *
     * @param OBJ_DET_NAME the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.OBJ_DET_NAME
     */
    public void setOBJ_DET_NAME(String OBJ_DET_NAME) {
        this.OBJ_DET_NAME = OBJ_DET_NAME == null ? null : OBJ_DET_NAME.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.OBJ_DISPLAY_ID
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.OBJ_DISPLAY_ID
     */
    public BigDecimal getOBJ_DISPLAY_ID() {
        return OBJ_DISPLAY_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.OBJ_DISPLAY_ID
     *
     * @param OBJ_DISPLAY_ID the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.OBJ_DISPLAY_ID
     */
    public void setOBJ_DISPLAY_ID(BigDecimal OBJ_DISPLAY_ID) {
        this.OBJ_DISPLAY_ID = OBJ_DISPLAY_ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_READONLY
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_READONLY
     */
    public BigDecimal getIS_READONLY() {
        return IS_READONLY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_READONLY
     *
     * @param IS_READONLY the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_READONLY
     */
    public void setIS_READONLY(BigDecimal IS_READONLY) {
        this.IS_READONLY = IS_READONLY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_VISIBLE
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_VISIBLE
     */
    public BigDecimal getIS_VISIBLE() {
        return IS_VISIBLE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_VISIBLE
     *
     * @param IS_VISIBLE the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_VISIBLE
     */
    public void setIS_VISIBLE(BigDecimal IS_VISIBLE) {
        this.IS_VISIBLE = IS_VISIBLE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_MANDATORY
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_MANDATORY
     */
    public BigDecimal getIS_MANDATORY() {
        return IS_MANDATORY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_MANDATORY
     *
     * @param IS_MANDATORY the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_MANDATORY
     */
    public void setIS_MANDATORY(BigDecimal IS_MANDATORY) {
        this.IS_MANDATORY = IS_MANDATORY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.LABEL_KEY
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.LABEL_KEY
     */
    public String getLABEL_KEY() {
        return LABEL_KEY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.LABEL_KEY
     *
     * @param LABEL_KEY the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.LABEL_KEY
     */
    public void setLABEL_KEY(String LABEL_KEY) {
        this.LABEL_KEY = LABEL_KEY == null ? null : LABEL_KEY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.DEFAULT_VALUE
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.DEFAULT_VALUE
     */
    public String getDEFAULT_VALUE() {
        return DEFAULT_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.DEFAULT_VALUE
     *
     * @param DEFAULT_VALUE the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.DEFAULT_VALUE
     */
    public void setDEFAULT_VALUE(String DEFAULT_VALUE) {
        this.DEFAULT_VALUE = DEFAULT_VALUE == null ? null : DEFAULT_VALUE.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MIN_LENGTH
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.MIN_LENGTH
     */
    public BigDecimal getMIN_LENGTH() {
        return MIN_LENGTH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MIN_LENGTH
     *
     * @param MIN_LENGTH the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.MIN_LENGTH
     */
    public void setMIN_LENGTH(BigDecimal MIN_LENGTH) {
        this.MIN_LENGTH = MIN_LENGTH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MAX_LENGTH
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.MAX_LENGTH
     */
    public BigDecimal getMAX_LENGTH() {
        return MAX_LENGTH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MAX_LENGTH
     *
     * @param MAX_LENGTH the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.MAX_LENGTH
     */
    public void setMAX_LENGTH(BigDecimal MAX_LENGTH) {
        this.MAX_LENGTH = MAX_LENGTH;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.DFLT_VAL_EXPR_PRIORITY_YN
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.DFLT_VAL_EXPR_PRIORITY_YN
     */
    public BigDecimal getDFLT_VAL_EXPR_PRIORITY_YN() {
        return DFLT_VAL_EXPR_PRIORITY_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.DFLT_VAL_EXPR_PRIORITY_YN
     *
     * @param DFLT_VAL_EXPR_PRIORITY_YN the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.DFLT_VAL_EXPR_PRIORITY_YN
     */
    public void setDFLT_VAL_EXPR_PRIORITY_YN(BigDecimal DFLT_VAL_EXPR_PRIORITY_YN) {
        this.DFLT_VAL_EXPR_PRIORITY_YN = DFLT_VAL_EXPR_PRIORITY_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_ADM_CUST_DIS_YN
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_ADM_CUST_DIS_YN
     */
    public BigDecimal getIS_ADM_CUST_DIS_YN() {
        return IS_ADM_CUST_DIS_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_ADM_CUST_DIS_YN
     *
     * @param IS_ADM_CUST_DIS_YN the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.IS_ADM_CUST_DIS_YN
     */
    public void setIS_ADM_CUST_DIS_YN(BigDecimal IS_ADM_CUST_DIS_YN) {
        this.IS_ADM_CUST_DIS_YN = IS_ADM_CUST_DIS_YN;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.CREATED_BY
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.CREATED_BY
     */
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.CREATED_BY
     *
     * @param CREATED_BY the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.CREATED_BY
     */
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY == null ? null : CREATED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.CREATED_DATE
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.CREATED_DATE
     */
    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.CREATED_DATE
     *
     * @param CREATED_DATE the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.CREATED_DATE
     */
    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MODIFIED_BY
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.MODIFIED_BY
     */
    public String getMODIFIED_BY() {
        return MODIFIED_BY;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MODIFIED_BY
     *
     * @param MODIFIED_BY the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.MODIFIED_BY
     */
    public void setMODIFIED_BY(String MODIFIED_BY) {
        this.MODIFIED_BY = MODIFIED_BY == null ? null : MODIFIED_BY.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MODIFIED_DATE
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.MODIFIED_DATE
     */
    public Date getMODIFIED_DATE() {
        return MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MODIFIED_DATE
     *
     * @param MODIFIED_DATE the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.MODIFIED_DATE
     */
    public void setMODIFIED_DATE(Date MODIFIED_DATE) {
        this.MODIFIED_DATE = MODIFIED_DATE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.READONLY_EXPR
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.READONLY_EXPR
     */
    public String getREADONLY_EXPR() {
        return READONLY_EXPR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.READONLY_EXPR
     *
     * @param READONLY_EXPR the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.READONLY_EXPR
     */
    public void setREADONLY_EXPR(String READONLY_EXPR) {
        this.READONLY_EXPR = READONLY_EXPR == null ? null : READONLY_EXPR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.VISIBILITY_EXPR
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.VISIBILITY_EXPR
     */
    public String getVISIBILITY_EXPR() {
        return VISIBILITY_EXPR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.VISIBILITY_EXPR
     *
     * @param VISIBILITY_EXPR the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.VISIBILITY_EXPR
     */
    public void setVISIBILITY_EXPR(String VISIBILITY_EXPR) {
        this.VISIBILITY_EXPR = VISIBILITY_EXPR == null ? null : VISIBILITY_EXPR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MANDATORY_EXPR
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.MANDATORY_EXPR
     */
    public String getMANDATORY_EXPR() {
        return MANDATORY_EXPR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.MANDATORY_EXPR
     *
     * @param MANDATORY_EXPR the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.MANDATORY_EXPR
     */
    public void setMANDATORY_EXPR(String MANDATORY_EXPR) {
        this.MANDATORY_EXPR = MANDATORY_EXPR == null ? null : MANDATORY_EXPR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.LABEL_KEY_EXPR
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.LABEL_KEY_EXPR
     */
    public String getLABEL_KEY_EXPR() {
        return LABEL_KEY_EXPR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.LABEL_KEY_EXPR
     *
     * @param LABEL_KEY_EXPR the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.LABEL_KEY_EXPR
     */
    public void setLABEL_KEY_EXPR(String LABEL_KEY_EXPR) {
        this.LABEL_KEY_EXPR = LABEL_KEY_EXPR == null ? null : LABEL_KEY_EXPR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.VALUE_VALID_EXPR
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.VALUE_VALID_EXPR
     */
    public String getVALUE_VALID_EXPR() {
        return VALUE_VALID_EXPR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.VALUE_VALID_EXPR
     *
     * @param VALUE_VALID_EXPR the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.VALUE_VALID_EXPR
     */
    public void setVALUE_VALID_EXPR(String VALUE_VALID_EXPR) {
        this.VALUE_VALID_EXPR = VALUE_VALID_EXPR == null ? null : VALUE_VALID_EXPR.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.DEFAULT_VALUE_EXPR
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.DEFAULT_VALUE_EXPR
     */
    public String getDEFAULT_VALUE_EXPR() {
        return DEFAULT_VALUE_EXPR;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.DEFAULT_VALUE_EXPR
     *
     * @param DEFAULT_VALUE_EXPR the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.DEFAULT_VALUE_EXPR
     */
    public void setDEFAULT_VALUE_EXPR(String DEFAULT_VALUE_EXPR) {
        this.DEFAULT_VALUE_EXPR = DEFAULT_VALUE_EXPR == null ? null : DEFAULT_VALUE_EXPR.trim();
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.BUS_RELATED
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.BUS_RELATED
     */
    public BigDecimal getBUS_RELATED() {
        return BUS_RELATED;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.BUS_RELATED
     *
     * @param BUS_RELATED the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.BUS_RELATED
     */
    public void setBUS_RELATED(BigDecimal BUS_RELATED) {
        this.BUS_RELATED = BUS_RELATED;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.ENABLE_FIELD_AUDIT_YN
     *
     * @return the value of SYS_PARAM_OBJ_DETAILS_DISPLAY.ENABLE_FIELD_AUDIT_YN
     */
    public String getENABLE_FIELD_AUDIT_YN() {
	return ENABLE_FIELD_AUDIT_YN;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PARAM_OBJ_DETAILS_DISPLAY.ENABLE_FIELD_AUDIT_YN
     *
     * @param ENABLE_FIELD_AUDIT_YN the value for SYS_PARAM_OBJ_DETAILS_DISPLAY.ENABLE_FIELD_AUDIT_YN
     */
    public void setENABLE_FIELD_AUDIT_YN(String ENABLE_FIELD_AUDIT_YN) {
	this.ENABLE_FIELD_AUDIT_YN = ENABLE_FIELD_AUDIT_YN;
    }
}