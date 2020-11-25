package com.path.vo.reporting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.path.dbmaps.vo.IRP_AD_HOC_REPORTVOWithBLOBs;

public class IRP_AD_HOC_REPORTCO extends IRP_AD_HOC_REPORTVOWithBLOBs{
	
	/**
	 * 
	 */
	
	private String PARENT_REF;
	private String PARENT_REF_STR;
	private List<IRP_AD_HOC_QUERYCO> queriesList = new ArrayList<IRP_AD_HOC_QUERYCO>();
	private int orientation = 2; // Portrait
	private boolean titleRepeated ; // title band shows on first page only
	private LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> argumentsList = new LinkedHashMap<Long, IRP_REP_ARGUMENTSCO>();
	private LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> argsDbDelete = new LinkedHashMap<Long, IRP_REP_ARGUMENTSCO>();
	private LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> argsDBUpdate = new LinkedHashMap<Long, IRP_REP_ARGUMENTSCO>();
	//added to handle constraints related to a new arg being added
	private  LinkedHashMap<String,IRP_REP_ARG_CONSTRAINTSCO> argConstraintsMap = new LinkedHashMap<String, IRP_REP_ARG_CONSTRAINTSCO>();
	private List<IRP_REP_PROCCO> proceduresList=new ArrayList<IRP_REP_PROCCO>(); 
	//Store the list of procedure parameters in order to save it once when saving the procedures
	private HashMap<String,ArrayList<IRP_REP_PROC_PARAMSCO>> procParamsMap=new HashMap<String,ArrayList<IRP_REP_PROC_PARAMSCO>>();
	private boolean fromUpDown; //to set if the reportCO is filled from the upload download section or from the designer
	private boolean isUpdateUpDownRep; // to check if the report is overwritten by selecting another jrxml from the upload button
	private ArrayList<IRP_FIELDSCO> prevOrderList=new ArrayList<IRP_FIELDSCO>();
	private LinkedHashMap<Long,CONDITION_OBJECT> prevFilterMap=new LinkedHashMap<Long,CONDITION_OBJECT>();
	private LinkedHashMap<Long,IRP_FIELDSCO> prevGrpMap=new LinkedHashMap<Long,IRP_FIELDSCO>();
	private List<IRP_SUB_REPORTCO> subreportsList = new ArrayList<IRP_SUB_REPORTCO>();
	private String isSubRep;
	private boolean SKIP_QRY_VALIDATTION;
	private HashMap<String ,List<IRP_QUERY_ARG_MAPPINGCO>> linkQryArsMap=new HashMap<String, List<IRP_QUERY_ARG_MAPPINGCO>>();//to store the 
	private String SKIP_OPT_AXS;
	private List<IRP_HASH_TABLECO> hashTblList = new ArrayList<IRP_HASH_TABLECO>();
	//to store the list of fields of the jasperDesign object with the type of each field,it will be used to create the export sql qry result
	private LinkedHashMap<String, String> jasperDesignFieldsMap=new LinkedHashMap<String, String>();
	//to store the images list in jrxml
	private List<ImageCO> imagesList = new ArrayList<ImageCO>();
	//the below 2 properties are created to set the prog ref and app name of the report on save as to copy the translation of the old rep to the new rep
	private String oldRepProgRef;
	private String oldRepAppName;
	private String STANDARD_FLAG_YN;
	private String xlsName;
	private String OPT_DESC_NAME;
	private String FTR_REP_YN;
	private List<IRP_CLIENT_REPORTCO> repClientList = new ArrayList<IRP_CLIENT_REPORTCO>();
	private String cltRepFlag;
	private String HOST;
	//key arg name,value is a map with 2 values get(0) is the param id and get(1) is flag for visible or not 
	private HashMap<String,HashMap<BigDecimal,String>> argShowHideMap = new HashMap<String, HashMap<BigDecimal,String>>();
	private String FTR_OPT_PROG_REF;
	private String MENU_TITLE_ENG;
	//key arg Id,value arg obj containing the new value
	private HashMap<String,Object> argRefreshLkpMap = new HashMap<String, Object>();
	private HashMap<String,String> argComboMap = new HashMap<String, String>();
	private BigDecimal APP_IS_WEB_YN;
	private String CATEGORY_DESC;
	private BigDecimal CATEGORY_ID;
	private String METADATA_REPORT_YN;
	private String METADATA_REPORT_NAME;
	private BigDecimal TIMEOUT,minTimeOutValue,maxTimeOutValue;
	public BigDecimal getTIMEOUT()
	{
	    return TIMEOUT;
	}
	public void setTIMEOUT(BigDecimal tIMEOUT)
	{
	    TIMEOUT = tIMEOUT;
	}
	public BigDecimal getMinTimeOutValue()
	{
	    return minTimeOutValue;
	}
	public void setMinTimeOutValue(BigDecimal minTimeOutValue)
	{
	    this.minTimeOutValue = minTimeOutValue;
	}
	public BigDecimal getMaxTimeOutValue()
	{
	    return maxTimeOutValue;
	}
	public void setMaxTimeOutValue(BigDecimal maxTimeOutValue)
	{
	    this.maxTimeOutValue = maxTimeOutValue;
	}
	public String getMETADATA_REPORT_NAME()
	{
	    return METADATA_REPORT_NAME;
	}

	public void setMETADATA_REPORT_NAME(String mETADATA_REPORT_NAME)
	{
	    METADATA_REPORT_NAME = mETADATA_REPORT_NAME;
	}

	public String getMETADATA_REPORT_YN()
	{
	    return METADATA_REPORT_YN;
	}

	public void setMETADATA_REPORT_YN(String mETADATA_REPORT_YN)
	{
	    METADATA_REPORT_YN = mETADATA_REPORT_YN;
	}

	public String getCATEGORY_DESC() {
		return CATEGORY_DESC;
	}

	public void setCATEGORY_DESC(String cATEGORY_DESC) {
		CATEGORY_DESC = cATEGORY_DESC;
	}

	public BigDecimal getCATEGORY_ID() {
		return CATEGORY_ID;
	}

	public void setCATEGORY_ID(BigDecimal cATEGORY_ID) {
		CATEGORY_ID = cATEGORY_ID;
	}

	public BigDecimal getAPP_IS_WEB_YN() {
		return APP_IS_WEB_YN;
	}

	public void setAPP_IS_WEB_YN(BigDecimal aPP_IS_WEB_YN) {
		APP_IS_WEB_YN = aPP_IS_WEB_YN;
	}

	public HashMap<String, String> getArgComboMap()
	{
	    return argComboMap;
	}

	public void setArgComboMap(HashMap<String, String> argComboMap)
	{
	    this.argComboMap = argComboMap;
	}

	public HashMap<String, Object> getArgRefreshLkpMap()
	{
	    return argRefreshLkpMap;
	}

	public void setArgRefreshLkpMap(HashMap<String, Object> argRefreshLkpMap)
	{
	    this.argRefreshLkpMap = argRefreshLkpMap;
	}

	/**
	 * @return the mENU_TITLE_ENG
	 */
	public String getMENU_TITLE_ENG()
	{
	    return MENU_TITLE_ENG;
	}

	/**
	 * @param mENUTITLEENG the mENU_TITLE_ENG to set
	 */
	public void setMENU_TITLE_ENG(String mENUTITLEENG)
	{
	    MENU_TITLE_ENG = mENUTITLEENG;
	}

	public String getFTR_OPT_PROG_REF()
	{
	    return FTR_OPT_PROG_REF;
	}

	public void setFTR_OPT_PROG_REF(String fTROPTPROGREF)
	{
	    FTR_OPT_PROG_REF = fTROPTPROGREF;
	}

	public HashMap<String, HashMap<BigDecimal, String>> getArgShowHideMap()
	{
	    return argShowHideMap;
	}

	public void setArgShowHideMap(HashMap<String, HashMap<BigDecimal, String>> argShowHideMap)
	{
	    this.argShowHideMap = argShowHideMap;
	}

	public LinkedHashMap<String, IRP_REP_ARG_CONSTRAINTSCO> getArgConstraintsMap()
	{
	    return argConstraintsMap;
	}

	public void setArgConstraintsMap(LinkedHashMap<String, IRP_REP_ARG_CONSTRAINTSCO> argConstraintsMap)
	{
	    this.argConstraintsMap = argConstraintsMap;
	}

	public String getHOST() {
		return HOST;
	}

	public void setHOST(String hOST) {
		HOST = hOST;
	}

	
	public String getCltRepFlag()
	{
	    return cltRepFlag;
	}

	public void setCltRepFlag(String cltRepFlag)
	{
	    this.cltRepFlag = cltRepFlag;
	}

	public String getFTR_REP_YN()
	{
	    return FTR_REP_YN;
	}

	public void setFTR_REP_YN(String fTRREPYN)
	{
	    FTR_REP_YN = fTRREPYN;
	}

	public String getXlsName()
	{
	    return xlsName;
	}

	public void setXlsName(String xlsName)
	{
	    this.xlsName = xlsName;
	}

	public String getSTANDARD_FLAG_YN()
	{
	    return STANDARD_FLAG_YN;
	}

	public void setSTANDARD_FLAG_YN(String sTANDARDFLAGYN)
	{
	    STANDARD_FLAG_YN = sTANDARDFLAGYN;
	}

	public String getOldRepProgRef()
	{
	    return oldRepProgRef;
	}

	public void setOldRepProgRef(String oldRepProgRef)
	{
	    this.oldRepProgRef = oldRepProgRef;
	}

	public String getOldRepAppName()
	{
	    return oldRepAppName;
	}

	public void setOldRepAppName(String oldRepAppName)
	{
	    this.oldRepAppName = oldRepAppName;
	}

	public List<ImageCO> getImagesList()
	{
	    return imagesList;
	}

	public void setImagesList(List<ImageCO> imagesList)
	{
	    this.imagesList = imagesList;
	}
	
	public LinkedHashMap<String, String> getJasperDesignFieldsMap()
	{
	    return jasperDesignFieldsMap;
	}

	public void setJasperDesignFieldsMap(LinkedHashMap<String, String> jasperDesignFieldsMap)
	{
	    this.jasperDesignFieldsMap = jasperDesignFieldsMap;
	}

	public List<IRP_HASH_TABLECO> getHashTblList()
	{
	    return hashTblList;
	}

	public void setHashTblList(List<IRP_HASH_TABLECO> hashTblList)
	{
	    this.hashTblList = hashTblList;
	}

	public String getSKIP_OPT_AXS() {
		return SKIP_OPT_AXS;
	}

	public void setSKIP_OPT_AXS(String sKIPOPTAXS) {
		SKIP_OPT_AXS = sKIPOPTAXS;
	}

	public HashMap<String, List<IRP_QUERY_ARG_MAPPINGCO>> getLinkQryArsMap()
	{
	    return linkQryArsMap;
	}

	public void setLinkQryArsMap(HashMap<String, List<IRP_QUERY_ARG_MAPPINGCO>> linkQryArsMap)
	{
	    this.linkQryArsMap = linkQryArsMap;
	}

	public boolean isSKIP_QRY_VALIDATTION() {
		return SKIP_QRY_VALIDATTION;
	}

	public void setSKIP_QRY_VALIDATTION(boolean sKIPQRYVALIDATTION) {
		SKIP_QRY_VALIDATTION = sKIPQRYVALIDATTION;
	}

	public LinkedHashMap<Long, IRP_FIELDSCO> getPrevGrpMap() {
		return prevGrpMap;
	}

	public void setPrevGrpMap(LinkedHashMap<Long, IRP_FIELDSCO> prevGrpMap) {
		this.prevGrpMap = prevGrpMap;
	}

	public LinkedHashMap<Long, CONDITION_OBJECT> getPrevFilterMap() {
		return prevFilterMap;
	}

	public void setPrevFilterMap(LinkedHashMap<Long, CONDITION_OBJECT> prevFilterMap) {
		this.prevFilterMap = prevFilterMap;
	}

	public ArrayList<IRP_FIELDSCO> getPrevOrderList() {
		return prevOrderList;
	}

	public void setPrevOrderList(ArrayList<IRP_FIELDSCO> prevOrderList) {
		this.prevOrderList = prevOrderList;
	}

	public List<IRP_AD_HOC_QUERYCO> getQueriesList() {
		return queriesList;
	}

	public void setQueriesList(List<IRP_AD_HOC_QUERYCO> queriesList) {
		this.queriesList = queriesList;
	}

	public String getPARENT_REF() {
		return PARENT_REF;
	}

	public void setPARENT_REF(String pARENTREF) {
		PARENT_REF = pARENTREF;
	}

	public String getPARENT_REF_STR() {
		return PARENT_REF_STR;
	}

	public void setPARENT_REF_STR(String pARENTREFSTR) {
		PARENT_REF_STR = pARENTREFSTR;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public boolean getTitleRepeated() {
		return titleRepeated;
	}

	public void setTitleRepeated(boolean titleRepeated) {
		this.titleRepeated = titleRepeated;
	}

	public LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> getArgumentsList() {
		return argumentsList;
	}

	public void setArgumentsList(
			LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> argumentsList) {
		this.argumentsList = argumentsList;
	}

	public LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> getArgsDbDelete() {
		return argsDbDelete;
	}

	public void setArgsDbDelete(
			LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> argsDbDelete) {
		this.argsDbDelete = argsDbDelete;
	}

	public LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> getArgsDBUpdate() {
		return argsDBUpdate;
	}

	public void setArgsDBUpdate(
			LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> argsDBUpdate) {
		this.argsDBUpdate = argsDBUpdate;
	}

	public List<IRP_REP_PROCCO> getProceduresList() {
		return proceduresList;
	}

	public void setProceduresList(List<IRP_REP_PROCCO> proceduresList) {
		this.proceduresList = proceduresList;
	}
	
	public HashMap<String, ArrayList<IRP_REP_PROC_PARAMSCO>> getProcParamsMap() {
		return procParamsMap;
	}
	public void setProcParamsMap(
			HashMap<String, ArrayList<IRP_REP_PROC_PARAMSCO>> procParamsMap) {
		this.procParamsMap = procParamsMap;
	}

	public boolean isFromUpDown() {
		return fromUpDown;
	}

	public void setFromUpDown(boolean fromUpDown) {
		this.fromUpDown = fromUpDown;
	}

	public boolean isUpdateUpDownRep() {
		return isUpdateUpDownRep;
	}

	public void setUpdateUpDownRep(boolean isUpdateUpDownRep) {
		this.isUpdateUpDownRep = isUpdateUpDownRep;
	}

	public List<IRP_SUB_REPORTCO> getSubreportsList()
	{
	    return subreportsList;
	}

	public void setSubreportsList(List<IRP_SUB_REPORTCO> subreportsList)
	{
	    this.subreportsList = subreportsList;
	}

	public String getIsSubRep()
	{
	    return isSubRep;
	}

	public void setIsSubRep(String isSubRep)
	{
	    this.isSubRep = isSubRep;
	}

	public String getOPT_DESC_NAME()
	{
	    return OPT_DESC_NAME;
	}

	public void setOPT_DESC_NAME(String oPTDESCNAME)
	{
	    OPT_DESC_NAME = oPTDESCNAME;
	}

	public List<IRP_CLIENT_REPORTCO> getRepClientList()
	{
	    return repClientList;
	}

	public void setRepClientList(List<IRP_CLIENT_REPORTCO> repClientList)
	{
	    this.repClientList = repClientList;
	}

}
