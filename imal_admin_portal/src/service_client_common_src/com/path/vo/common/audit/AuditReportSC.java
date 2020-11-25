package com.path.vo.common.audit;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.S_AUDIT_ACTIONSVO;
import com.path.dbmaps.vo.S_AUDIT_ACTION_DTLVO;
import com.path.struts2.lib.common.GridParamsSC;

/**
 * @author raees
 * 
 */
@SuppressWarnings("serial")
public class AuditReportSC extends GridParamsSC
{
	private String appName;
	private String progRef;
	private String trxNbr;
	//BUG 512116 Sending company code as number to the procedure instead of varchar
	private String companyCode;
	//768542  BB180246 - AUdit Trail report
	private BigDecimal branchCode;
	private String langCode;
	private Date actionDate;
	private Long actionDateMs;
	private String trackOP;
	private String custPageRef;
	private S_AUDIT_ACTIONSVO auditVO = new S_AUDIT_ACTIONSVO();
	private S_AUDIT_ACTION_DTLVO auditDtlVO = new S_AUDIT_ACTION_DTLVO();
	//439073 ADD support for additional fields labels
	private String ordinaryFieldType;
	
	//Support FATCA stand alone environment
	private int isStandAlone;

	//447471 Masking the info of VIP customers
	private boolean tellerCifMask; //CTSTELLER.ALLOW_CIF_CREATION_MASK_YN, getting the flag value from session object
	private int maskTheName; //boolean to check if the Name masking flags are true
	private int maskTheSalary ; //boolean to check if the Salary masking flags are true
	private int maskAll ; //boolean to check if masking is enabled without Name/Salary checking
	
	//642699 Show the CIF instead of button clicked
	private String fieldAuditDetails;
	
	//691148 Field & CIF Audit
	private String screenCIFHTMLIDs;
	private String screenCIFHTMLVals;
	private String jsFuntionName;
	private int fieldAuditCIFLnNb;
	
	/**
	 * @return the appName
	 */
	public String getAppName()
	{
		return appName;
	}
	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName)
	{
		this.appName = appName;
	}
	/**
	 * @return the progRef
	 */
	public String getProgRef()
	{
		return progRef;
	}
	/**
	 * @param progRef the progRef to set
	 */
	public void setProgRef(String progRef)
	{
		this.progRef = progRef;
	}
	/**
	 * @return the trxNbr
	 */
	public String getTrxNbr()
	{
		return trxNbr;
	}
	/**
	 * @param trxNbr the trxNbr to set
	 */
	public void setTrxNbr(String trxNbr)
	{
		this.trxNbr = trxNbr;
	}
	/**
	 * @return the actionDate
	 */
	public Date getActionDate()
	{
		return actionDate;
	}
	/**
	 * @param actionDate the actionDate to set
	 */
	public void setActionDate(Date actionDate)
	{
		this.actionDate = actionDate;
	}
	/**
	 * @return the actionDateMs
	 */
	public Long getActionDateMs()
	{
		return actionDateMs;
	}
	/**
	 * @param actionDateMs the actionDateMs to set
	 */
	public void setActionDateMs(Long actionDateMs)
	{
		this.actionDateMs = actionDateMs;
	}
	/**
	 * @return the langCode
	 */
	public String getLangCode()
	{
		return langCode;
	}
	/**
	 * @param langCode the langCode to set
	 */
	public void setLangCode(String langCode)
	{
		this.langCode = langCode;
	}
	public void setTrackOP(String trackOP)
	{
	    this.trackOP = trackOP;
	}
	public String getTrackOP()
	{
	    return trackOP;
	}
	public String getCustPageRef()
	{
	    return custPageRef;
	}
	public void setCustPageRef(String custPageRef)
	{
	    this.custPageRef = custPageRef;
	}
	public S_AUDIT_ACTIONSVO getAuditVO()
	{
	    return auditVO;
	}
	public void setAuditVO(S_AUDIT_ACTIONSVO auditVO)
	{
	    this.auditVO = auditVO;
	}
	public S_AUDIT_ACTION_DTLVO getAuditDtlVO()
	{
	    return auditDtlVO;
	}
	public void setAuditDtlVO(S_AUDIT_ACTION_DTLVO auditDtlVO)
	{
	    this.auditDtlVO = auditDtlVO;
	}
	public String getOrdinaryFieldType() {
		return ordinaryFieldType;
	}
	public void setOrdinaryFieldType(String ordinaryFieldType) {
		this.ordinaryFieldType = ordinaryFieldType;
	}
	public int getIsStandAlone() {
		return isStandAlone;
	}
	public void setIsStandAlone(int isStandAlone) {
		this.isStandAlone = isStandAlone;
	}
	public boolean isTellerCifMask()
	{
	    return tellerCifMask;
	}
	public void setTellerCifMask(boolean tellerCifMask)
	{
	    this.tellerCifMask = tellerCifMask;
	}
	public int getMaskTheName()
	{
	    return maskTheName;
	}
	public void setMaskTheName(int maskTheName)
	{
	    this.maskTheName = maskTheName;
	}
	public int getMaskTheSalary()
	{
	    return maskTheSalary;
	}
	public void setMaskTheSalary(int maskTheSalary)
	{
	    this.maskTheSalary = maskTheSalary;
	}
	public int getMaskAll()
	{
	    return maskAll;
	}
	public void setMaskAll(int maskAll)
	{
	    this.maskAll = maskAll;
	}
	public String getCompanyCode()
	{
	    return companyCode;
	}
	public void setCompanyCode(String companyCode)
	{
	    this.companyCode = companyCode;
	}

        public String getFieldAuditDetails()
        {
    	return fieldAuditDetails;
        }
    
        public void setFieldAuditDetails(String fieldAuditDetails)
        {
    	this.fieldAuditDetails = fieldAuditDetails;
        }
	public String getScreenCIFHTMLIDs()
	{
	    return screenCIFHTMLIDs;
	}
	public void setScreenCIFHTMLIDs(String screenCIFHTMLIDs)
	{
	    this.screenCIFHTMLIDs = screenCIFHTMLIDs;
	}
	public String getJsFuntionName()
	{
	    return jsFuntionName;
	}
	public void setJsFuntionName(String jsFuntionName)
	{
	    this.jsFuntionName = jsFuntionName;
	}
	public String getScreenCIFHTMLVals()
	{
	    return screenCIFHTMLVals;
	}
	public void setScreenCIFHTMLVals(String screenCIFHTMLVals)
	{
	    this.screenCIFHTMLVals = screenCIFHTMLVals;
	}
	public int getFieldAuditCIFLnNb()
	{
	    return fieldAuditCIFLnNb;
	}
	public void setFieldAuditCIFLnNb(int fieldAuditCIFLnNb)
	{
	    this.fieldAuditCIFLnNb = fieldAuditCIFLnNb;
	}
	public BigDecimal getBranchCode()
	{
	    return branchCode;
	}
	public void setBranchCode(BigDecimal branchCode)
	{
	    this.branchCode = branchCode;
	}
}
