package com.path.vo.reporting;



import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.IRP_REP_ARGUMENTSVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.StringUtil;

public class IRP_REP_ARGUMENTSCO extends IRP_REP_ARGUMENTSVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2317842953757449911L;
	
	/**
	 * This property corresponds to the place of the argument in the list of arguments referenced in SQL_OBJECT.
	 * Index value is the time of object creation in milliseconds. 
	 */
	private long index;
	
	private boolean isUsedInQuery;
	private String QUERY_NAME;
	private boolean valueFlag;
	private boolean displayFlag;
	private boolean enableFlag;
	private String MAP_PARAM_TYPE;// for sub rep link param
	private String VALUE_COLUMN;
	private String VALUE_ARGUMENT;
	private String VALUE_STATIC;
	private String LINK_REP_QRY_ARG;//link the qry argument to the report argument in case of tabular report
	private String DEFAULT_VAL_QRY_NAME;
	private BigDecimal OLD_ARGUMENT_ID;
	private IRP_REP_ARG_CONSTRAINTSCO irpRepArgConstraintCO = new IRP_REP_ARG_CONSTRAINTSCO();
	private String MULTISELECT_YN_STR;
	private String TO_SAVE_YN_STR;	
	private String CIF_AUDIT_YN_STR;

	public String getCIF_AUDIT_YN_STR()
	{
	    return CIF_AUDIT_YN_STR;
	}

	public void setCIF_AUDIT_YN_STR(String cIF_AUDIT_YN_STR)
	{
	    CIF_AUDIT_YN_STR = cIF_AUDIT_YN_STR;
	}

	public String getTO_SAVE_YN_STR()
	{
	    return TO_SAVE_YN_STR;
	}

	public void setTO_SAVE_YN_STR(String tO_SAVE_YN_STR)
	{
	    TO_SAVE_YN_STR = tO_SAVE_YN_STR;
	}

	
	

	public String getMULTISELECT_YN_STR()
	{
	    return MULTISELECT_YN_STR;
	}

	public void setMULTISELECT_YN_STR(String mULTISELECTYNSTR)
	{
	    MULTISELECT_YN_STR = mULTISELECTYNSTR;
	}

	public IRP_REP_ARG_CONSTRAINTSCO getIrpRepArgConstraintCO()
	{
	    return irpRepArgConstraintCO;
	}

	public void setIrpRepArgConstraintCO(IRP_REP_ARG_CONSTRAINTSCO irpRepArgConstraintCO)
	{
	    this.irpRepArgConstraintCO = irpRepArgConstraintCO;
	}

	public BigDecimal getOLD_ARGUMENT_ID()
	{
	    return OLD_ARGUMENT_ID;
	}

	public void setOLD_ARGUMENT_ID(BigDecimal oLDARGUMENTID)
	{
	    OLD_ARGUMENT_ID = oLDARGUMENTID;
	}

	public String getDEFAULT_VAL_QRY_NAME()
	{
	    return DEFAULT_VAL_QRY_NAME;
	}

	public void setDEFAULT_VAL_QRY_NAME(String dEFAULTVALQRYNAME)
	{
	    DEFAULT_VAL_QRY_NAME = dEFAULTVALQRYNAME;
	}

	public String getLINK_REP_QRY_ARG()
	{
	    return LINK_REP_QRY_ARG;
	}

	public void setLINK_REP_QRY_ARG(String lINKREPQRYARG)
	{
	    LINK_REP_QRY_ARG = lINKREPQRYARG;
	}

	public String getVALUE_STATIC()
	{
	    return VALUE_STATIC;
	}

	public void setVALUE_STATIC(String vALUESTATIC)
	{
	    VALUE_STATIC = vALUESTATIC;
	}

	public String getVALUE_ARGUMENT()
	{
	    return VALUE_ARGUMENT;
	}

	public void setVALUE_ARGUMENT(String vALUEARGUMENT)
	{
	    VALUE_ARGUMENT = vALUEARGUMENT;
	}

	public String getVALUE_COLUMN()
	{
	    return VALUE_COLUMN;
	}

	public void setVALUE_COLUMN(String vALUECOLUMN)
	{
	    VALUE_COLUMN = vALUECOLUMN;
	}

	public String getMAP_PARAM_TYPE()
	{
	    return MAP_PARAM_TYPE;
	}

	public void setMAP_PARAM_TYPE(String mAPPARAMTYPE)
	{
	    MAP_PARAM_TYPE = mAPPARAMTYPE;
	}

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}
	
    public boolean isUsedInQuery() {
		return isUsedInQuery;
	}

	public void setUsedInQuery(boolean isUsedInQuery) {
		this.isUsedInQuery = isUsedInQuery;
	}
	
	public String getQUERY_NAME() {
		return QUERY_NAME;
	}

	public void setQUERY_NAME(String qUERYNAME) {
		QUERY_NAME = qUERYNAME;
	}
	
	public boolean isValueFlag() {
		return valueFlag;
	}

	public void setValueFlag(boolean valueFlag) {
		this.valueFlag = valueFlag;
		//if((BigDecimal.valueOf(4)).equals(this.getARGUMENT_SOURCE()))
			//this.setARGUMENT_VALUE(valueFlag? this.getFLAG_VALUE_ON() : this.getFLAG_VALUE_OFF());
	}
	
	public boolean isDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(boolean displayFlag) {
		this.displayFlag = displayFlag;
		this.setDISPLAY_FLAG(displayFlag? "Y" : "N");
	}

	public boolean isEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(boolean enableFlag) {
		this.enableFlag = enableFlag;
		this.setENABLE_FLAG(enableFlag? "Y" : "N");
	}
	
	public String getJrxmlType() 
	{
    		if(("number").equalsIgnoreCase(this.getARGUMENT_TYPE())) {
    		    return "java.math.BigDecimal";
		}
		else if(("date").equalsIgnoreCase(this.getARGUMENT_TYPE())) {
		    return "java.util.Date";
		}
		else if(("datetime").equalsIgnoreCase(this.getARGUMENT_TYPE()))
		{
		    return "java.sql.Timestamp";
		}
		else {
		    return "java.lang.String";
		}
	}

	public String getJrxmlValue() 
	{
	    	if(StringUtil.nullToEmpty(getARGUMENT_VALUE()).isEmpty() || "null".equalsIgnoreCase(getARGUMENT_VALUE()))
	    	{
		    return "";
	    	}
	    	
		if(("number").equalsIgnoreCase(this.getARGUMENT_TYPE()))
		{
		    return "new BigDecimal(\"" + this.getARGUMENT_VALUE() + "\")";
		}
		else if(("date").equalsIgnoreCase(this.getARGUMENT_TYPE()))
		{
		    //swap the day and the month since jasperReport api takes the parameter default date format as 'MM/dd/yyyy'
		    String[] dateArr = getARGUMENT_VALUE().split("/");
		    String argVal = dateArr[1] + "/" + dateArr[0] + "/" + dateArr[2];
		    return "new Date(\"" + argVal + "\")";
		}
		else if(("datetime").equalsIgnoreCase(this.getARGUMENT_TYPE()))
		{
		    try
		    {
			String argVal=this.getARGUMENT_VALUE();
			Date dt = DateUtil.parseDate(argVal,DateUtil.getDatePattern(argVal));
			return "new java.sql.Timestamp(Long.valueOf(\"" +dt.getTime() + "\"))";
		    }
		    catch(BaseException e)
		    {
			e.printStackTrace();
			return "error";
		    }
		}
		else
		{
		    return "new String(\"" + this.getARGUMENT_VALUE() + "\")";
		}
	}

	public String getArgTypeDesc() {
		if(("NUMBER").equals(this.getARGUMENT_TYPE()))
		{
			return "Numeric";
		}
		else if(("VARCHAR2").equals(this.getARGUMENT_TYPE()))
		{
			return "Character";
		}
		else if(("DATE").equals(this.getARGUMENT_TYPE()))
		{
		    return "Date";
		}
		else if(("DATETIME").equals(this.getARGUMENT_TYPE()))
		{
		    return "Date time";
		}
		else
		{
		    return "";
		}
	}

}
