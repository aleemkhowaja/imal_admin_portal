package com.path.vo.reporting;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.path.struts2.lib.common.GridParamsSC;

public class IRP_AD_HOC_REPORTSC extends GridParamsSC {
	
   /**
     * 
     */
    private static final long serialVersionUID = 6728658153418597483L;
    
    private String REPORT_NAME;
	private String PROG_REF;
	private BigDecimal REPORT_ID;
	private String FILTER_DESIGNER_REP;
	private String APP_NAME;
	private String USER_ID;
	private BigDecimal COMP_CODE;
	private BigDecimal BRANCH_CODE;
	private String profType;
	private String fromSched;
	private BigDecimal reportArgumentId;
	private String reportArgumentName;
	private BigDecimal defaultSrc;
	private BigDecimal templateCode;
	private String OPT_EXT="";
	private boolean IS_DEPENDENCY;
	private String tblName;
	private BigDecimal QUERY_ID;
	private ArrayList<BigDecimal> listProcIds;
	private ArrayList<BigDecimal> listArgsIds;
	private ArrayList<BigDecimal> listHashIds;
	private String REPORT_REF;
	private ArrayList<String> listClientAcronym;
	private ArrayList<BigDecimal> listQryIds;
	private ArrayList<BigDecimal> listConIds;
	private ArrayList<String> listOpts;
	private ArrayList<String> listFolderRef;
	private BigDecimal PARENT_REP_ID;
	private ArrayList<BigDecimal> listReportsId;
	private String argumentType;
	private ArrayList<BigDecimal> filterslist;
	private String calledFrom;
	private BigDecimal currentPage;
	private byte[] repPaginationBytes;
	public byte[] getRepPaginationBytes() {
		return repPaginationBytes;
	}

	public void setRepPaginationBytes(byte[] repPaginationBytes) {
		this.repPaginationBytes = repPaginationBytes;
	}

	public BigDecimal getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(BigDecimal currentPage) {
		this.currentPage = currentPage;
	}
	public String getCalledFrom()
	{
	    return calledFrom;
	}

	public void setCalledFrom(String calledFrom)
	{
	    this.calledFrom = calledFrom;
	}

	public String getArgumentType()
	{
	    return argumentType;
	}

	public void setArgumentType(String argumentType)
	{
	    this.argumentType = argumentType;
	}

	public ArrayList<BigDecimal> getFilterslist()
	{
	    return filterslist;
	}

	public void setFilterslist(ArrayList<BigDecimal> filterslist)
	{
	    this.filterslist = filterslist;
	}

	public ArrayList<BigDecimal> getListReportsId()
	{
	    return listReportsId;
	}

	public void setListReportsId(ArrayList<BigDecimal> listReportsId)
	{
	    this.listReportsId = listReportsId;
	}

	public BigDecimal getPARENT_REP_ID()
	{
	    return PARENT_REP_ID;
	}

	public void setPARENT_REP_ID(BigDecimal pARENTREPID)
	{
	    PARENT_REP_ID = pARENTREPID;
	}

	public ArrayList<String> getListFolderRef()
	{
	    return listFolderRef;
	}

	public void setListFolderRef(ArrayList<String> listFolderRef)
	{
	    this.listFolderRef = listFolderRef;
	}

	public ArrayList<String> getListOpts()
	{
	    return listOpts;
	}

	public void setListOpts(ArrayList<String> listOpts)
	{
	    this.listOpts = listOpts;
	}

	public ArrayList<BigDecimal> getListConIds()
	{
	    return listConIds;
	}

	public void setListConIds(ArrayList<BigDecimal> listConIds)
	{
	    this.listConIds = listConIds;
	}

	public ArrayList<BigDecimal> getListQryIds()
	{
	    return listQryIds;
	}

	public void setListQryIds(ArrayList<BigDecimal> listQryIds)
	{
	    this.listQryIds = listQryIds;
	}

	public ArrayList<String> getListClientAcronym()
	{
	    return listClientAcronym;
	}

	public void setListClientAcronym(ArrayList<String> listClientAcronym)
	{
	    this.listClientAcronym = listClientAcronym;
	}

	public String getREPORT_REF()
	{
	    return REPORT_REF;
	}

	public void setREPORT_REF(String rEPORTREF)
	{
	    REPORT_REF = rEPORTREF;
	}

	public ArrayList<BigDecimal> getListHashIds()
	{
	    return listHashIds;
	}

	public void setListHashIds(ArrayList<BigDecimal> listHashIds)
	{
	    this.listHashIds = listHashIds;
	}

	public ArrayList<BigDecimal> getListArgsIds()
	{
	    return listArgsIds;
	}

	public void setListArgsIds(ArrayList<BigDecimal> listArgsIds)
	{
	    this.listArgsIds = listArgsIds;
	}

	public ArrayList<BigDecimal> getListProcIds()
	{
	    return listProcIds;
	}

	public void setListProcIds(ArrayList<BigDecimal> listProcIds)
	{
	    this.listProcIds = listProcIds;
	}

	public BigDecimal getQUERY_ID()
	{
	    return QUERY_ID;
	}

	public void setQUERY_ID(BigDecimal qUERYID)
	{
	    QUERY_ID = qUERYID;
	}

	public String getTblName()
	{
	    return tblName;
	}

	public void setTblName(String tblName)
	{
	    this.tblName = tblName;
	}

	public String getOPT_EXT()
	{
	    return OPT_EXT;
	}

	public void setOPT_EXT(String oPTEXT)
	{
	    OPT_EXT = oPTEXT;
	}


	
	public BigDecimal getTemplateCode()
	{
	    return templateCode;
	}

	public void setTemplateCode(BigDecimal templateCode)
	{
	    this.templateCode = templateCode;
	}

	public BigDecimal getDefaultSrc()
	{
	    return defaultSrc;
	}

	public void setDefaultSrc(BigDecimal defaultSrc)
	{
	    this.defaultSrc = defaultSrc;
	}

	public BigDecimal getReportArgumentId()
	{
	    return reportArgumentId;
	}

	public void setReportArgumentId(BigDecimal reportArgumentId)
	{
	    this.reportArgumentId = reportArgumentId;
	}

	public String getReportArgumentName()
	{
	    return reportArgumentName;
	}

	public void setReportArgumentName(String reportArgumentName)
	{
	    this.reportArgumentName = reportArgumentName;
	}

	public String getFromSched() {
		return fromSched;
	}

	public void setFromSched(String fromSched) {
		this.fromSched = fromSched;
	}

	public String getProfType() {
		return profType;
	}

	public void setProfType(String profType) {
		this.profType = profType;
	}

	public BigDecimal getCOMP_CODE() {
		return COMP_CODE;
	}

	public void setCOMP_CODE(BigDecimal cOMPCODE) {
		COMP_CODE = cOMPCODE;
	}

	public BigDecimal getBRANCH_CODE() {
		return BRANCH_CODE;
	}

	public void setBRANCH_CODE(BigDecimal bRANCHCODE) {
		BRANCH_CODE = bRANCHCODE;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSERID) {
		USER_ID = uSERID;
	}

	public IRP_AD_HOC_REPORTSC(){
		super.setSearchCols(new String[] {"REPORT_ID","REPORT_NAME","PROG_REF","APP_NAME","OLD_REPORT_ID","eodBatchMasterVO.BATCH_CODE","eodBatchMasterVO.BATCH_BRIEF_NAME"});
	}

	public String getREPORT_NAME() {
		return REPORT_NAME;
	}

	public void setREPORT_NAME(String rEPORTNAME) {
		REPORT_NAME = rEPORTNAME;
	}

	public String getPROG_REF() {
		return PROG_REF;
	}

	public void setPROG_REF(String pROGREF) {
		PROG_REF = pROGREF;
	}

	public BigDecimal getREPORT_ID() {
		return REPORT_ID;
	}

	public void setREPORT_ID(BigDecimal rEPORTID) {
		REPORT_ID = rEPORTID;
	}

	public String getFILTER_DESIGNER_REP() {
		return FILTER_DESIGNER_REP;
	}

	public void setFILTER_DESIGNER_REP(String fILTERDESIGNERREP) {
		FILTER_DESIGNER_REP = fILTERDESIGNERREP;
	}

	public String getAPP_NAME() {
		return APP_NAME;
	}

	public void setAPP_NAME(String aPPNAME) {
		APP_NAME = aPPNAME;
	}

	public boolean isIS_DEPENDENCY()
	{
	    return IS_DEPENDENCY;
	}

	public void setIS_DEPENDENCY(boolean iSDEPENDENCY)
	{
	    IS_DEPENDENCY = iSDEPENDENCY;
	}
}
