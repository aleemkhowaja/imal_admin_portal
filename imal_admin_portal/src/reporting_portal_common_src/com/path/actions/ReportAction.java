package com.path.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.reporting.CommonReportingBO;
import com.path.bo.reporting.ReportingConstantsCommon;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.BRANCHESVOKey;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.IRP_AD_HOC_REPORTVOWithBLOBs;
import com.path.dbmaps.vo.IRP_QUERY_ARG_MAPPINGVO;
import com.path.dbmaps.vo.IRP_REP_ARGUMENTS_FILTERSVO;
import com.path.dbmaps.vo.IRP_REP_FILTERSVO;
import com.path.dbmaps.vo.PTH_CTRL1VO;
import com.path.dbmaps.vo.SYS_PARAM_LOV_TRANSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.reporting.CommonReportingSessionCO;
import com.path.vo.reporting.DynLookupSC;
import com.path.vo.reporting.IRP_AD_HOC_REPORTCO;
import com.path.vo.reporting.IRP_AD_HOC_REPORTSC;
import com.path.vo.reporting.IRP_FCR_REPORTSCO;
import com.path.vo.reporting.IRP_QUERY_ARG_MAPPINGCO;
import com.path.vo.reporting.IRP_REP_ARGUMENTSCO;
import com.path.vo.reporting.IRP_REP_FILTERSSC;
import com.path.vo.reporting.IRP_SUB_REPORTCO;
import com.path.vo.reporting.ReportOutputCO;
import com.path.vo.reporting.ReportParamsCO;

public class ReportAction extends BaseAction
{
    private String var_format;
    private String var_menuId;
    private String var_reportName;
    private BigDecimal var_db;
    String var_user;
    ArrayList<SYS_PARAM_LOV_TRANSVO> reportFormatsList = new ArrayList<SYS_PARAM_LOV_TRANSVO>();
    private CommonReportingBO commonReportingBO;
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
    private HashMap paramsFlag;
    private HashMap noHeadFootMap;
    private String launchRep;
    IRP_AD_HOC_REPORTCO reportCO;
    private String contentType;
    private String contentHeader;
    private String filename;
    private String url;
    private String fromMenu;
    private BigDecimal fromPage;
    private BigDecimal toPage;

    private String l; // language
    private String r_r;
    private String d_p;
    private String r_c; // report connection
    private String a_p;
    private String r_i;
    private String r_a_p; // report additional params
    private String r_p; // printer name
    private String pb_r; // report from pb
    private String w_p; // reports with watermark parameter
    private String a; // report application name
    private String fei_p;
    private String r_c_d;//report check data 
    private BigDecimal p_c_nb; //print copies number.
    private String cookieStamp; //time stamp to identify cookies for different reports.
    private String r_e_cm; // report empty confirmation message
    private String r_e_im; // report empty info message
    private String r_e_nm; // report empty info message
    private String retrieveCall;
    private BigDecimal currentPage;
    private String s_s; //save snapshot
    private String s_i; //snapshot id
    private Date e_d; //execution Date

    public String getRetrieveCall()
    {
	return retrieveCall;
    }

    public void setRetrieveCall(String retrieveCall)
    {
	this.retrieveCall = retrieveCall;
    }

    public BigDecimal getCurrentPage()
    {
	return currentPage;
    }

    public void setCurrentPage(BigDecimal currentPage)
    {
	this.currentPage = currentPage;
    }
    
    public BigDecimal getP_c_nb()
    {
        return p_c_nb;
    }

    public void setP_c_nb(BigDecimal p_c_nb)
    {
        this.p_c_nb = p_c_nb;
    }

	public String getR_c_d() {
		return r_c_d;
	}

	public void setR_c_d(String r_c_d) {
		this.r_c_d = r_c_d;
	}

	private Map feiParameters = new HashMap();

    // put all session values in ReportParamsCO object to be sent to
    // jasperReport api
    ReportParamsCO repParamsCO = new ReportParamsCO();

    private boolean var_noHeadAndFoot;
    private String var_separator;
    String returnStr = "successtest";
    CommonReportingSessionCO repSessionCO;
    private ReportOutputCO reportOutputCO;
    private boolean flushResponse = true;
    private String saveSnp;
    private String updates;
    private String update;

    private ArrayList<String> repRefsLst;
    private String qryId;
    private BigDecimal conId;
    private BigDecimal argId;
    private String filterName;
    private String publicYn;
    private BigDecimal filterId;
    private IRP_REP_FILTERSVO irpRepFilterVO;
    private String defaultYn;
    private boolean reportHasData;
    private BigDecimal reportNbPages;
    private BigDecimal repPrintPdf;
    
    public String getR_e_cm()
    {
        return r_e_cm;
    }

    public void setR_e_cm(String r_e_cm)
    {
        this.r_e_cm = r_e_cm;
    }

    public String getR_e_im()
    {
        return r_e_im;
    }

    public void setR_e_im(String r_e_im)
    {
        this.r_e_im = r_e_im;
    }
    
    public String getR_e_nm()
    {
        return r_e_nm;
    }

    public void setR_e_nm(String r_e_nm)
    {
        this.r_e_nm = r_e_nm;
    }

    public String getCookieStamp()
    {
        return cookieStamp;
    }

    public void setCookieStamp(String cookieStamp)
    {
        this.cookieStamp = cookieStamp;
    }

    public BigDecimal getRepPrintPdf()
    {
        return repPrintPdf;
    }

    public void setRepPrintPdf(BigDecimal repPrintPdf)
    {
        this.repPrintPdf = repPrintPdf;
    }

    public BigDecimal getReportNbPages()
    {
        return reportNbPages;
    }

    public void setReportNbPages(BigDecimal reportNbPages)
    {
        this.reportNbPages = reportNbPages;
    }
    public boolean isReportHasData()
    {
        return reportHasData;
    }

    public void setReportHasData(boolean reportHasData)
    {
        this.reportHasData = reportHasData;
    }
    
    public String getDefaultYn() 
    {
		return defaultYn;
	}

	public void setDefaultYn(String defaultYn) 
	{
		this.defaultYn = defaultYn;
	}

    public BigDecimal getFilterId()
    {
        return filterId;
    }

    public void setFilterId(BigDecimal filterId)
    {
        this.filterId = filterId;
    }

    public IRP_REP_FILTERSVO getIrpRepFilterVO()
    {
        return irpRepFilterVO;
    }

    public void setIrpRepFilterVO(IRP_REP_FILTERSVO irpRepFilterVO)
    {
        this.irpRepFilterVO = irpRepFilterVO;
    }

    public String getFilterName()
    {
        return filterName;
    }

    public void setFilterName(String filterName)
    {
        this.filterName = filterName;
    }

    public String getPublicYn()
    {
        return publicYn;
    }

    public void setPublicYn(String publicYn)
    {
        this.publicYn = publicYn;
    }

    public String getQryId()
    {
        return qryId;
    }

    public void setQryId(String qryId)
    {
        this.qryId = qryId;
    }

    public BigDecimal getConId()
    {
        return conId;
    }

    public void setConId(BigDecimal conId)
    {
        this.conId = conId;
    }

    public BigDecimal getArgId()
    {
        return argId;
    }

    public void setArgId(BigDecimal argId)
    {
        this.argId = argId;
    }

    public void setRepRefsLst(ArrayList<String> repRefsLst)
    {
	this.repRefsLst = repRefsLst;
    }

    public ArrayList<String> getRepRefsLst()
    {
	return repRefsLst;
    }

    public String getUpdate()
    {
	return update;
    }
    public void setUpdate(String update)
    {
	this.update = update;
    }
    public String getUpdates()
    {
	return updates;
    }
    public void setUpdates(String updates)
    {
	this.updates = updates;
    }
    public String getSaveSnp()
    {
	return saveSnp;
    }
    public void setSaveSnp(String saveSnp)
    {
	this.saveSnp = saveSnp;
    }

    public ReportOutputCO getReportOutputCO()
    {
	return reportOutputCO;
    }

    public void setReportOutputCO(ReportOutputCO reportOutputCO)
    {
	this.reportOutputCO = reportOutputCO;
    }

    public String getVar_reportName()
    {
	return var_reportName;
    }

    public void setVar_reportName(String varReportName)
    {
	var_reportName = varReportName;
    }

    private String noData;

    public String getNoData()
    {
	return noData;
    }

    public void setNoData(String noData)
    {
	this.noData = noData;
    }

    public String getVar_separator()
    {
	return var_separator;
    }

    public void setVar_separator(String varSeparator)
    {
	var_separator = varSeparator;
    }

    public boolean isVar_noHeadAndFoot()
    {
	return var_noHeadAndFoot;
    }

    public void setVar_noHeadAndFoot(boolean varNoHeadAndFoot)
    {
	var_noHeadAndFoot = varNoHeadAndFoot;
    }

    public String getFromMenu()
    {
	return fromMenu;
    }

    public void setFromMenu(String fromMenu)
    {
	this.fromMenu = fromMenu;
    }

    public BigDecimal getFromPage()
    {
	return fromPage;
    }

    public void setFromPage(BigDecimal fromPage)
    {
	this.fromPage = fromPage;
    }

    public BigDecimal getToPage()
    {
	return toPage;
    }

    public void setToPage(BigDecimal toPage)
    {
	this.toPage = toPage;
    }

    public void setCommonReportingBO(CommonReportingBO commonReportingBO)
    {
	this.commonReportingBO = commonReportingBO;
    }

    public String getUrl()
    {
	return url;
    }

    public void setUrl(String url)
    {
	this.url = url;
    }

    public String getContentHeader()
    {
	return contentHeader;
    }

    public void setContentHeader(String contentHeader)
    {
	this.contentHeader = contentHeader;
    }

    private InputStream fileStream;

    public InputStream getFileStream()
    {
	return fileStream;
    }

    public void setFileStream(InputStream fileStream)
    {
	this.fileStream = fileStream;
    }

    public String getContentType()
    {
	return contentType;
    }

    public void setContentType(String contentType)
    {
	this.contentType = contentType;
    }

    public String getLaunchRep()
    {
	return launchRep;
    }

    public void setLaunchRep(String launchRep)
    {
	this.launchRep = launchRep;
    }

    @Override
    public String execute() throws Exception
    {
	return SUCCESS;
    }

    public String getVar_format()
    {
	return var_format;
    }

    public void setVar_format(String varFormat)
    {
	var_format = varFormat;
    }

    public String getVar_menuId()
    {
	return var_menuId;
    }

    public void setVar_menuId(String varMenuId)
    {
	var_menuId = varMenuId;
    }

    public BigDecimal getVar_db()
    {
	return var_db;
    }

    public void setVar_db(BigDecimal varDb)
    {
	var_db = varDb;
    }

    public HashMap getParamsFlag()
    {
	return paramsFlag;
    }

    public void setParamsFlag(HashMap paramsFlag)
    {
	this.paramsFlag = paramsFlag;
    }

    public HashMap getNoHeadFootMap()
    {
	return noHeadFootMap;
    }

    public void setNoHeadFootMap(HashMap noHeadFootMap)
    {
	this.noHeadFootMap = noHeadFootMap;
    }

    public List getReportFormats()
    {
	try
	{
	SessionCO sessionCO = returnSessionObject();
	SYS_PARAM_LOV_TRANSVO sysParamLovVO = new SYS_PARAM_LOV_TRANSVO();
	sysParamLovVO.setLOV_TYPE_ID(ConstantsCommon.FILE_FORMAT_LOV_TYPE);
	sysParamLovVO.setLANG_CODE(sessionCO.getLanguage());
	HashMap<String, Object> sysParamLovVOMap = new HashMap<String, Object>();
	String[] propsArr = ConstantsCommon.getLookupListMap_PROPS
		.toArray(new String[ConstantsCommon.getLookupListMap_PROPS.size()]);
	PathPropertyUtil.copyProperties(sysParamLovVO, sysParamLovVOMap, false, propsArr);
	ArrayList<HashMap<String, Object>> retLst = (ArrayList<HashMap<String, Object>>) commonReportingBO
		.getLookupListMap(sysParamLovVOMap);
	HashMap<String, Object> hm;
	reportFormatsList = new ArrayList<SYS_PARAM_LOV_TRANSVO>();
	propsArr = ConstantsCommon.getLookupListMapRet_PROPS
		.toArray(new String[ConstantsCommon.getLookupListMapRet_PROPS.size()]);
	for(int i = 0; i < retLst.size(); i++)
	{
	    hm = retLst.get(i);
	    sysParamLovVO = new SYS_PARAM_LOV_TRANSVO();
	    PathPropertyUtil.copyProperties(hm, sysParamLovVO, false, propsArr);
	    reportFormatsList.add(sysParamLovVO);
	}
	}
	catch(Exception e)
	{
	   log.error(e,"________ error in ReportAction.getReportFormats()");
	}
	return reportFormatsList;
    }

    public List<SepartorFormat> getCsvSeparators()
    {
	ArrayList<SepartorFormat> csvSeparatorsList = new ArrayList<SepartorFormat>();
	csvSeparatorsList.add(new SepartorFormat(",", ","));
	csvSeparatorsList.add(new SepartorFormat(getText("reporting.tab"), "\t"));
	return csvSeparatorsList;
    }

    public static class ReportFormat
    {
	private final String description;
	private final String code;

	public ReportFormat(String description, String code)
	{
	    this.description = description;
	    this.code = code;
	}

	public String getDescription()
	{
	    return description;
	}

	public String getCode()
	{
	    return code;
	}
    }

    public static class SepartorFormat implements Serializable
    {
	private final String description;
	private final String code;

	public SepartorFormat(String description, String code)
	{
	    this.description = description;
	    this.code = code;
	}

	public String getDescription()
	{
	    return description;
	}

	public String getCode()
	{
	    return code;
	}
    }

    /**
     * Retrieve the reports defined in File Export Import Screen
     * 
     * @return String
     */
    public String retrieveExportImportReports() 
    {
	try
	{
	    repSessionCO = returnReportingSessionObject(ConstantsCommon.FILE_EXP_IMP_PROG_REF);
	    HashMap<String, HashMap<String, Object>> RepParamsMap;
	    HashMap<String, Object> paramMap;
	    
	    RepParamsMap = repSessionCO.getFileExpImpParamsMap();
 	    setA_p("0"); // Automatic Print set to 0 as there will no automatic
			 // report printing only used for advices
	    setFei_p("1");
	    SessionCO sessionCO = returnSessionObject();
	    String progRef;
	    Iterator<Map.Entry<String, Object>> it;
	    Entry<String, Object> entry;
	    for(int i = 0; i < repRefsLst.size(); i++)
	    {
		progRef = repRefsLst.get(i);
		setR_r(progRef);

		setNoData("false");
		paramMap = RepParamsMap.get(progRef);

		if(paramMap == null)
		{
		    setD_p("1");
		    setL(sessionCO.getLanguage());
		    setVar_format(ConstantsCommon.XLS_REP_FORMAT);
		    setVar_menuId(progRef);
		}
		if(paramMap != null)
		{
		    it = paramMap.entrySet().iterator();
		    while(it.hasNext())
		    {
			entry = it.next();
			if(entry.getKey().equals("-1") && entry.getValue().equals("hasNext"))
			{
			    break;
			}
			else
			{
			    if("var_menuId".equals(entry.getKey()))
			    {
				setVar_menuId((String) entry.getValue());
			    }
			    if("a".equals(entry.getKey()))
			    {
				setA((String) entry.getValue());
			    }
			    if("var_format".equals(entry.getKey()))
			    {
				setVar_format((String) entry.getValue());
			    }
			    if("var_db".equals(entry.getKey()))
			    {
				if(entry.getValue() != null && !entry.getValue().equals(""))
				{
				    setVar_db((BigDecimal) entry.getValue());
				}
			    }
			    if("l".equals(entry.getKey()))
			    {
				setL((String) entry.getValue());
			    }
			    if("r_i".equals(entry.getKey()))
			    {
				setR_i((String) entry.getValue());
			    }
			    if("d_p".equals(entry.getKey()))
			    {
				setD_p((String) entry.getValue());
			    }
			    if("noHeadFoot".equals(entry.getKey()))
			    {
				if(entry.getValue() == "true")
				{
				    setVar_noHeadAndFoot(true);
				}
				else
				{
				    setVar_noHeadAndFoot(false);
				}
			    }
			    if(!"var_db".equals(entry.getKey()) && !"var_menuId".equals(entry.getKey())
				    && !"a".equals(entry.getKey()) && !"var_format".equals(entry.getKey())
				    && !"l".equals(entry.getKey()) && !"r_i".equals(entry.getKey())
				    && !"d_p".equals(entry.getKey()) && !"noHeadFoot".equals(entry.getKey()))

			    {
				feiParameters.put(entry.getKey(), entry.getValue());
			    }

			}
		    }
		}
		String result = generateReport();
	
		feiParameters.clear();
	    }
	}
	catch(Exception e)
	{    handleException(e, null,null);
	}
	return SUCCESS;

    }
    
    /**
     * returning user name for informative details
     * @param request
     * @return
     */
    private static String returnUserFromSession(SessionCO sessCO,String reportReference,String reportId)
    {
    	String userDetails= "UNKNOWN";
    	try
    	{
    		if(sessCO != null)
			{
    			userDetails = DateUtil.format(Calendar.getInstance().getTime(), "dd_MM_yyyy_hh_mm_ss").concat("-")
						.concat(String.valueOf(sessCO.getUserName())).concat("-")
						.concat(String.valueOf(sessCO.getCompanyCode())).concat("-")
						.concat(String.valueOf(sessCO.getBranchCode())).concat("-")
						.concat(String.valueOf(sessCO.getCurrentAppName())).concat("-")
						.concat(String.valueOf(reportId)).concat("-")
						.concat(String.valueOf(reportReference)).concat("-")
						.concat(StringUtil.nullToEmpty(sessCO.getHttpSessionID()));

			}
    	}
    	catch(Exception e)
    	{
    		 log.error(e,"Error in Returning UserName from Session");
    	}
    	return userDetails;
    }

    /**
     * Generate the report using jasper report api
     * 
     * @return String
     */
    public String generateReport() 
    {
    String currentThreadName = StringUtil.nullToEmpty(Thread.currentThread().getName());	
	byte[] origJrxml=null;
	String origFormat = var_format;
	try
	{
		// setting rep print pdf flag
		if(NumberUtil.isEmptyDecimal(repPrintPdf))
		{
		    repPrintPdf = BigDecimal.ZERO;
		}
		
	    SessionCO sessionCO = returnSessionObject();

	    Thread.currentThread().setName(currentThreadName.concat("_").concat(returnUserFromSession(sessionCO,r_r,r_i)));

	    
	    String zHypParams = request.getParameter("zHypParams");
	    if(zHypParams != null && zHypParams.length() > 0)// called from
	    // hyperlink
	    {
		// decode the hyperlink parameters
		String decHypParams = SecurityUtils.decodeB64(zHypParams);
		// fill the hyperlink parameters in a hashMap in order to fill
		// the session object and set the other parameters sent by the
		// request
		HashMap<String, String> hypParamMap = new HashMap<String, String>();
		String[] hypParamsArr = decHypParams.split("&");
		String zParam;
		for(int i = 0; i < hypParamsArr.length; i++)
		{
		    zParam = hypParamsArr[i];
		    hypParamMap.put(zParam.split("=")[0], zParam.split("=")[1]);
		}

		// fill the other parameters sent by the url
		r_r = hypParamMap.get("r_r");
		r_i = hypParamMap.get("r_i");

		if(sessionCO == null) /*
				       * if the main appl. is called from the
				       * server name and the hyperlink is called
				       * from the server ip and vice versa
				       */
		{
		    // fill the sesson object
		    sessionCO = new SessionCO();
		    session.put(ConstantsCommon.SESSION_VO_ATTR, sessionCO);
		    sessionCO.setBaseCurrencyName(hypParamMap.get("s_bcn"));
		    sessionCO.setBranchName(hypParamMap.get("s_bn"));
		    sessionCO.setClientType(hypParamMap.get("s_ct"));
		    sessionCO.setCompanyArabName(hypParamMap.get("s_can"));
		    sessionCO.setCompanyName(hypParamMap.get("s_cn"));
		    sessionCO.setCurrentAppName(hypParamMap.get("s_cAppn"));
		    sessionCO.setExposCurName(hypParamMap.get("s_ecn"));
		    sessionCO.setLanguage(hypParamMap.get("s_l"));
		    sessionCO.setBaseCurrDecPoint(new BigDecimal(hypParamMap.get("s_bcdp")));
		    sessionCO.setBaseCurrencyCode(new BigDecimal(hypParamMap.get("s_bcc")));
		    sessionCO.setBranchCode(new BigDecimal(hypParamMap.get("s_bc")));
		    sessionCO.setCompanyCode(new BigDecimal(hypParamMap.get("s_cc")));
		    sessionCO.setExposCurName(hypParamMap.get("s_excn"));
		    sessionCO.setEmployeeId(new BigDecimal(hypParamMap.get("e_i")));
		    if(hypParamMap.get("s_fy") == null)
		    {
			sessionCO.setFiscalYear(null);
		    }
		    else
		    {
			sessionCO.setFiscalYear(new BigDecimal(hypParamMap.get("s_fy")));
		    }
		    sessionCO.setUserName(hypParamMap.get("s_un"));
		    sessionCO.setRunningDateRET(DateUtil.parseDate((hypParamMap.get("s_rdr")),
			    "EEE MMM dd HH:mm:ss Z yyyy"));
		}
	    }

	    String appName =  (a == null ? sessionCO.getCurrentAppName() : a);

	    // this map is filled with parameters to be sent to jasperReport api
	    Map parameters = new HashMap();

	    parameters.put("isInsertTmpSessDet", ConstantsCommon.YES);

	    String saveCopyLocation = "";
	    String itemName;
	    String itemValue;
	    String[] arr;
	    String flag;
	    String valueOn;
	    String valueOff;

	    BigDecimal repId = null;
	    String dateFrmt;
	    Date dt;
	    if(("1").equals(d_p))
	    {
		// In case the generate is called from the retrieve button in
		// file export import
		if(("1").equals(fei_p))
		{
		    parameters = feiParameters;
		}
		else
		{
		    Enumeration enu = request.getParameterNames();
		    Map subConnections=null;
		    while(enu.hasMoreElements())
		    {
			itemName = (String) enu.nextElement();
			itemValue = request.getParameter(itemName);
			log.debug("----------->" + itemName + "==" + itemValue);
			if(itemName.startsWith("param~"))
			{
			    arr = itemName.split("~");
			    itemName = arr[1];
			    if("true".equals(noData))
			    {
				parameters.put(itemName, null);
			    }
			    else
			    {
				if(itemValue != null && !itemValue.equals(""))
				{
				    if(arr[2].equals("NUMBER"))
				    {
					parameters.put(itemName, new BigDecimal(itemValue));
				    }
				    else if(arr[2].equals("DATE"))
				    {
					parameters.put(itemName, DateUtil.parseDate(itemValue, "dd/MM/yyyy"));
				    }
				    else if(ConstantsCommon.datetime.equals(arr[2]))
				    {
					if(commonReportingBO.retSysDateParamLovVal(sessionCO.getLanguage()).equals(
						itemValue))
					{
					    dt = returnCommonLibBO().returnSystemDateWithTime();
					}
					else
					{
					    itemValue = itemValue.replace("+", " ");
					    dateFrmt = DateUtil.getDatePattern(itemValue);
					    dt = DateUtil.parseDate(itemValue, dateFrmt);
					}
					parameters.put(itemName, new java.sql.Timestamp(dt.getTime()));
				    }
				    else if(arr[2].equals(ConstantsCommon.CONNECTION))
				    {
				    	subConnections = (Map) parameters.get("SUB_CON");
				    	if(subConnections == null) {
				    		subConnections = new HashMap();
				    	}
				    	subConnections.put(itemName, new BigDecimal(itemValue));
				    	parameters.put("SUB_CON", subConnections);
				    }
				    else
				    {
					parameters.put(itemName, itemValue);
				    }
				}
			    }
			}
			// for ftr snapshots
			else if(itemName.startsWith("snp~"))
			{
			    parameters.put(itemName, itemValue);
			}

			else if(itemName.startsWith("__checkbox_paramsFlag"))
			{
			    flag = itemName.substring(11);

			    itemName = flag.substring(11, flag.length() - 4);
			    valueOn = flag.substring(flag.length() - 3, flag.length() - 2);
			    valueOff = flag.substring(flag.length() - 1, flag.length());

			    if(request.getParameter(flag) == null)
			    {
				parameters.put(itemName, valueOff);
			    }
			    else
			    {
				parameters.put(itemName, valueOn);
			    }
			}
			else if("var_chkName".equals(itemName))
			{
			    saveCopyLocation = itemValue;
			}
			else if(itemName.startsWith(ConstantsCommon.PARAM_H))
			{
			    arr = itemName.split("~");
			    itemName = arr[1];
			    if(!itemValue.isEmpty())
			    {
				 parameters=commonReportingBO.fillParametersWithCollection(itemName,
				 itemValue, parameters, arr[2],0);
			    }
			}
		    }

		    // put all parameters having values from session in
		    // repParamsCO
		    if(l == null)
		    {
			parameters.put("isInsertTmpSessDet", ConstantsCommon.NO);
			l = sessionCO.getLanguage();
		    }

		    var_user = sessionCO.getUserName();

		    // stoped by haytham.k for fcr reports
		    // if(!var_menuId.endsWith("DY0"))
		    // {
		    // repId = new BigDecimal(r_i);
		    // }

		    // set the var_noHeaderAndFooter value
		    var_noHeadAndFoot = false;
			
		    // This temp fix should be revisited later
		    if(noHeadFootMap != null)
		    {
			String val[] = (String[]) noHeadFootMap.get("var_noHeadAndFoot");
			if(ConstantsCommon.TRUE.equals(val[0]))
			{
			    var_noHeadAndFoot = true;
			}
		    }
			
		}
	    }
	    else
	    {
		// check if we are calling the report from PB
		if(("1").equals(pb_r))
		{
		    if(r_i != null)
		    {
			try
			{
			    repId = commonReportingBO.retRepIdFromOldRepId(new BigDecimal(r_i));
			}
			catch(Exception e)
			{
			    throw new BaseException("Error when retrieving report id from old id: " + r_i + "\n "
				    + e.getMessage(), e);
			}
		    }
		}
		else
		{
		    if(r_i != null)
		    {
			repId = new BigDecimal(r_i);
		    }
		}

		if(StringUtil.nullToEmpty(r_r).isEmpty() && repId == null)
		{
		    throw new Exception(getText("report.generate.exceptionMsg._key"));
		}

		// if the report prog ref is sent then retrieve the report id
		// based on the prog ref
		// even if the report id is sent in the url
		if(!StringUtil.nullToEmpty(r_r).isEmpty())
		{
		    try
		    {
			String repAppName = (a == null ? appName : a);
			IRP_AD_HOC_REPORTSC repSC = new IRP_AD_HOC_REPORTSC();
			repSC.setPROG_REF(r_r);
			repSC.setAPP_NAME(repAppName);

			HashMap<String, Object> repSCMap = new HashMap<String, Object>();
			String[] propsArr = ConstantsCommon.retRepIdByProgRef_PROPS
				.toArray(new String[ConstantsCommon.retRepIdByProgRef_PROPS.size()]);
			PathPropertyUtil.copyProperties(repSC, repSCMap, false, propsArr);
			HashMap<String, Object> retHm = commonReportingBO.retRepIdByProgRef(repSCMap);
			if(retHm==null || retHm.isEmpty())
			{
			    reportCO=null;
			}
			else
			{
			    reportCO=(IRP_AD_HOC_REPORTCO) PathPropertyUtil.convertToObject(retHm, IRP_AD_HOC_REPORTCO.class);
			}
		    }
		    catch(Exception e)
		    {
			throw new BOException("Error when retrieving report id by prog ref for report reference: "
				+ r_r + "\n " + e.getMessage(), e);
		    }
		    if(reportCO != null && !NumberUtil.isEmptyDecimal(reportCO.getREPORT_ID()))
		    {
			repId = reportCO.getREPORT_ID();
		    }
		}

		if(repId != null)
		{
		    try
		    {
			HashMap<String, Object> retMap = commonReportingBO.returnReportById(repId);
			reportCO=(IRP_AD_HOC_REPORTCO) PathPropertyUtil.convertToObject(retMap, IRP_AD_HOC_REPORTCO.class);
		    }
		    catch(Exception e)
		    {
			throw new BOException("Error when retrieving report by id for report id: " + repId + "\n "
				+ e.getMessage(), e);
		    }
		}

		if(reportCO == null || NumberUtil.isEmptyDecimal(reportCO.getREPORT_ID()))
		{
		    throw new Exception(getText("report.retrieve.exceptionMsg._key")
			    + getText("report_retrieve_reference_key") + r_r
			    + getText("report_retrieve_reportid_key") + repId);
		}

		repSessionCO = returnReportingSessionObject(r_r);
		repSessionCO.setReportCO(reportCO);

		// return all the report arguments
		List<IRP_REP_ARGUMENTSCO> argumentsList = new ArrayList(reportCO.getArgumentsList().values());

		String argType;
		BigDecimal argSource;

		String paramName;
		String paramVal;
		Object paramSessionVal;
		int argOrder;
		String sessionParamName;
		// CURRENCIESVOKey currVOKey;
		// CURRENCIESVO curVO = null;
		// BRANCHESVOKey brVOKey;
		// BRANCHESVO brVO = null;

		parameters.put("w_p", w_p);
		// get the report arguments from url
		String[] addParams = null;
		if(r_a_p != null)
		{
		    addParams = (r_a_p).split("~#~");
		}

		for(IRP_REP_ARGUMENTSCO argObj : argumentsList)
		{
		    paramName = argObj.getARGUMENT_NAME();
		    paramVal = argObj.getARGUMENT_VALUE();
		    argType = argObj.getARGUMENT_TYPE();
		    argSource = argObj.getARGUMENT_SOURCE();
		    argOrder = (argObj.getARGUMENT_ORDER()).intValue();

		    if(argSource.equals(ConstantsCommon.SESSION_ARG_SOURCE)
			    || argSource.equals(ConstantsCommon.TRANS_SESSION_ARG_SOURCE))
		    {
			if(addParams != null && addParams.length > 0 && argOrder <= addParams.length)
			{
			    paramSessionVal = addParams[argOrder - 1];
			    if("".equals(paramSessionVal))
			    {
				sessionParamName = argObj.getSESSION_ATTR_NAME();
				paramSessionVal = retSessionVal(sessionParamName, sessionCO, argSource);
			    }
			    else
			    {
				if(ConstantsCommon.PARAM_TYPE_DATE.equals(argType))
				{
				    paramSessionVal = DateUtil.parseDate((String) paramSessionVal, "dd/MM/yyyy");
				}
			    }
			}
			else
			{
			    sessionParamName = argObj.getSESSION_ATTR_NAME();
			    paramSessionVal = retSessionVal(sessionParamName, sessionCO, argSource);
			}
			if(ConstantsCommon.PARAM_TYPE_DATE.equals(argType))
			{
			    paramVal = DateUtil.format((Date) paramSessionVal, "dd/MM/yyyy");
			}
			else if(ConstantsCommon.datetime.equals(argType))
			{
			    paramVal = DateUtil.format((Date) paramSessionVal, "dd/MM/yyyy hh:mm:ss");
			}
			else
			{
			    paramVal = paramSessionVal.toString();
			}
			// }
		    }
		    else
		    {
			if(addParams != null && addParams.length > 0 && argOrder <= addParams.length)
			{
			    paramVal = addParams[argOrder - 1];
			}
		    }

		    if(StringUtil.nullToEmpty(paramVal).isEmpty())
		    {
			parameters.put(paramName, null);
		    }
		    else if(ConstantsCommon.PARAM_TYPE_NUMBER.equals(argType))
		    {
			parameters.put(paramName, new BigDecimal(paramVal));
		    }
		    else if(ConstantsCommon.PARAM_TYPE_DATE.equals(argType))
		    {
			dateFrmt = DateUtil.getDatePattern(paramVal);
			parameters.put(paramName, DateUtil.parseDate(paramVal, dateFrmt));
		    }
		    else if(ConstantsCommon.datetime.equals(argType))
		    {
			if(commonReportingBO.retSysDateParamLovVal(sessionCO.getLanguage()).equals(paramVal))
			{
			    dt = returnCommonLibBO().returnSystemDateWithTime();
			}
			else
			{
			    paramVal = paramVal.replace("+", " ");
			    dateFrmt = DateUtil.getDatePattern(paramVal);
			    dt = DateUtil.parseDate(paramVal, dateFrmt);
			}
			parameters.put(paramName, new java.sql.Timestamp(dt.getTime()));
		    }
		    else
		    {
			parameters.put(paramName, paramVal);
		    }
		}

		var_db = reportCO.getCONN_ID();
		if("1".equals(r_c))
		{
		    BigDecimal conn;
		    try
		    {
			// changed from appName to reportCO.getAppName after
			// discussion with Anna
			conn = commonReportingBO.returnConnectionId(reportCO.getAPP_NAME());
		    }
		    catch(Exception e)
		    {
			throw new BOException("Error when connecting to db for report id: " + reportCO.getREPORT_ID()
				+ " and report reference: " + reportCO.getPROG_REF() + " and report application: "
				+ reportCO.getAPP_NAME() + "\n " + e.getMessage(), e);
		    }
		    if(conn != null)
		    {
			var_db = conn;
		    }
		}

		if(!StringUtil.isNotEmpty(var_format))
		{
		    var_format = reportCO.getDEFAULT_FORMAT();
		}

		// csvSeparator
		var_separator = reportCO.getCSV_SEPARATOR();
		if(appName.equals(ConstantsCommon.REP_APP_NAME))
		{
		    if(BigDecimal.ONE.toString().equals(reportCO.getSHOW_HEAD_FOOT()))
		    {
			var_noHeadAndFoot = false;
		    }
		    else
		    {
			var_noHeadAndFoot = true;
		    }
		}
		var_menuId = reportCO.getPROG_REF();
		var_user = sessionCO.getUserName();
		if("1".equals(reportCO.getLANG_INDEPENDENT_YN()))
		{
			l=ConstantsCommon.LANGUAGE_ENGLISH;
		}
		else if(l == null)
		{
		    parameters.put("isInsertTmpSessDet", ConstantsCommon.NO);
		    l = sessionCO.getLanguage();
		}
	    }

	    // put all parameters having values from session in repParamsCO
	    String[] properties = new String[] { "baseCurrDecPoint", "baseCurrencyCode", "baseCurrencyName",
		    "branchCode", "clientType", "companyArabName", "companyCode", "companyName", "currentAppName",
		    "exposCurCode", "exposCurName", "fiscalYear", "runningDateRET", "language", "userName",
		    "branchName", "isRTLDir","employeeId","userNbFormats" };

	    PathPropertyUtil.copyProperties(sessionCO, repParamsCO, properties);
	    repParamsCO.setRepLanguage(l);

	    // stoped by haytham.k for fcr reports
	    // if(!var_menuId.endsWith("DY0"))
	    // {
	    if(("1").equals(d_p))
	    {
		if("1".equals(fei_p))
		{
		    var_user = sessionCO.getUserName();
		    String ftrOptProgRef=null;

		    if(!StringUtil.nullToEmpty(r_r).isEmpty())
		    {
			try
			{
			    String repAppName = (a == null ? appName : a);
			    IRP_AD_HOC_REPORTSC repSC = new IRP_AD_HOC_REPORTSC();
			    repSC.setAPP_NAME(repAppName);
			    HashMap<String, Object> repSCMap = new HashMap<String, Object>();
			    HashMap<String, Object> retHm;
			    if(var_menuId.endsWith(ConstantsCommon.OPT_FCR_EXTENSION))
			    {
				repSC.setCOMP_CODE(sessionCO.getCompanyCode());
				repSC.setPROG_REF(var_menuId.substring(0, var_menuId.length() - 3));
				IRP_FCR_REPORTSCO irpFcrRepCO = commonReportingBO.retFcrRep(repSC);
				if(var_menuId.endsWith(ConstantsCommon.OPT_FCR_EXTENSION))
				{
				    ftrOptProgRef=StringUtil.nullToEmpty(irpFcrRepCO.getProgRef());
				    repSC.setPROG_REF(ConstantsCommon.FCR_MAIN_REPORT_REF);
				}
				else if(irpFcrRepCO.getProgRef() != null)
				{
				    repSC.setPROG_REF(irpFcrRepCO.getProgRef());
				}	
				String[] prpArr = ConstantsCommon.retRepIdByProgRef_PROPS
					.toArray(new String[ConstantsCommon.retRepIdByProgRef_PROPS.size()]);
				PathPropertyUtil.copyProperties(repSC, repSCMap, false, prpArr);
				retHm = commonReportingBO.retRepIdByProgRef(repSCMap);
			    }
			    else
			    {
			    repSC.setPROG_REF(r_r);
			    String[] propsArr = ConstantsCommon.retRepIdByProgRef_PROPS
				    .toArray(new String[ConstantsCommon.retRepIdByProgRef_PROPS.size()]);
			    PathPropertyUtil.copyProperties(repSC, repSCMap, false, propsArr);
			    retHm = commonReportingBO.retRepIdByProgRef(repSCMap);
			    }
			    if(retHm==null || retHm.isEmpty())
			    {
				reportCO=null;
			    }
			    else
			    {
				reportCO =(IRP_AD_HOC_REPORTCO) PathPropertyUtil.convertToObject(retHm, IRP_AD_HOC_REPORTCO.class);
			    }
			   
			}
			catch(Exception e)
			{
			    throw new BOException("Error when retrieving report id by prog ref for report reference: "
				    + r_r + "\n " + e.getMessage(), e);
			}
			if(reportCO != null && !NumberUtil.isEmptyDecimal(reportCO.getREPORT_ID()))
			{
			    repId = reportCO.getREPORT_ID();
			}
			if(repId != null)
			{
			    try
			    {
				HashMap<String, Object> retMap = commonReportingBO.returnReportById(repId);
				reportCO=(IRP_AD_HOC_REPORTCO) PathPropertyUtil.convertToObject(retMap, IRP_AD_HOC_REPORTCO.class);
				if(var_menuId.endsWith(ConstantsCommon.OPT_FCR_EXTENSION)
					&& !ConstantsCommon.OPT_FCR_STANDARD.contains(var_menuId))
				{
				    reportCO.setFTR_OPT_PROG_REF(var_menuId.substring(0, var_menuId.length()
					    - ConstantsCommon.OPT_FCR_EXTENSION.length()));
				}
			    }
			    catch(Exception e)
			    {
				throw new BOException("Error when retrieving report by id for report id: " + repId
					+ "\n " + e.getMessage(), e);
			    }
			}

			if(reportCO == null || NumberUtil.isEmptyDecimal(reportCO.getREPORT_ID()))
			{
			    throw new Exception(getText("report.retrieve.exceptionMsg._key")
				    + getText("report_retrieve_reference_key ") + r_r
				    + getText("report_retrieve_reportid_key") + repId);
			}
			repSessionCO = returnReportingSessionObject(r_r);
			repSessionCO.setReportCO(reportCO);

			if(parameters.size() == 0)
			{
			    if(var_menuId.endsWith(ConstantsCommon.OPT_FCR_EXTENSION))
			    {
				HashMap<String, String> retHm = commonReportingBO.returnDynamicReportByRef(
					var_menuId.substring(0, var_menuId.length()
						- ConstantsCommon.OPT_FCR_EXTENSION.length()));
				parameters.put(ConstantsCommon.FCR_TEMPL_CODE, new BigDecimal(retHm
					.get(ConstantsCommon.FCR_TEMPL_CODE)));
				parameters.put(ConstantsCommon.FCR_COL_TMPLT_CODE, new BigDecimal(retHm
					.get(ConstantsCommon.FCR_COL_TMPLT_CODE)));
				parameters.put(ConstantsCommon.ARG_RA_TYPE, retHm.get(ConstantsCommon.ARG_RA_TYPE));
				parameters.put(ConstantsCommon.FCR_ROW_TO_COL, retHm
					.get(ConstantsCommon.FCR_ROW_TO_COL));
				parameters.put(ConstantsCommon.FCR_CURRENCY, new BigDecimal(retHm
					.get(ConstantsCommon.FCR_CURRENCY)));
				if(ConstantsCommon.FCR_REP_TYPE_SUMMARIZED.equals(retHm
					.get(ConstantsCommon.FCR_REP_TYPE)))
				{
				    parameters.put(ConstantsCommon.FCR_AP_REF, ConstantsCommon.FCR_SUMMARIZED_OPT);
				    parameters.put(ConstantsCommon.FCR_FCR_REF, ConstantsCommon.FCR_SUMMARIZED_OPT);
				}
				else
				{
				    parameters.put(ConstantsCommon.FCR_AP_REF, ConstantsCommon.FCR_DETAILED_OPT);
				    parameters.put(ConstantsCommon.FCR_FCR_REF, ConstantsCommon.FCR_DETAILED_OPT);
				}
				parameters.put(ConstantsCommon.FCR_PROG_REF, var_menuId);
				parameters.put(ConstantsCommon.FCR_RA_USER_ID, sessionCO.getUserName());
				parameters.put(ConstantsCommon.AP_TOPOF, BigDecimal.ZERO);
				parameters.put(ConstantsCommon.FCR_EXCLUDE_CIF, BigDecimal.ZERO);
				parameters.put(ConstantsCommon.FCR_CV_CURRENCY, sessionCO.getBaseCurrencyCode());
				parameters.put(ConstantsCommon.FCR_COMP_CODE, sessionCO.getCompanyCode());
				parameters.put(ConstantsCommon.FCR_CY_DEC, sessionCO.getBaseCurrDecPoint());
				parameters.put(ConstantsCommon.FCR_AS_VT, ConstantsCommon.FCR_DEFLT_VAL_TRADE_DTE);
				parameters.put(ConstantsCommon.FCR_APP, ConstantsCommon.REP_APP_NAME);
				parameters.put(ConstantsCommon.FCR_RA_LANG, sessionCO.getLanguage());
				parameters.put(ConstantsCommon.FCR_RA_TEMPLATE_HEADER, BigDecimal.ONE);
				parameters.put(ConstantsCommon.ARG_RA_FORMAT, ConstantsCommon.FCR_WITH_DEC);
				if(ConstantsCommon.OPT_FCR_STANDARD.contains(var_menuId))
				{
				    parameters.put(ConstantsCommon.FCR_STANDARD_FLAG_YN, ConstantsCommon.YES);

				}
				else
				{
				    parameters.put(ConstantsCommon.FCR_STANDARD_FLAG_YN, ConstantsCommon.NO);

				}
			    }
			    else
			    {
			    setA(reportCO.getAPP_NAME());
			    ArrayList<IRP_REP_ARGUMENTSCO> argsList = new ArrayList<IRP_REP_ARGUMENTSCO>();
			    LinkedHashMap argsMap = reportCO.getArgumentsList();
			    argsList = new ArrayList(argsMap.values());
			    String paramName;
			    String paramVal;
			    String paramType;
			    for(IRP_REP_ARGUMENTSCO argObj : argsList)
			    {
				paramName = argObj.getARGUMENT_NAME();
				paramVal = argObj.getARGUMENT_VALUE();
				paramType = argObj.getARGUMENT_TYPE();
				if(!(StringUtil.nullToEmpty(paramVal)).isEmpty())
				{
				    if(ConstantsCommon.PARAM_TYPE_NUMBER.equals(paramType))
				    {
					parameters.put(paramName, new BigDecimal(paramVal));
				    }
				    else if(ConstantsCommon.PARAM_TYPE_DATE.equals(paramType))
				    {
					parameters.put(paramName, DateUtil.parseDate(paramVal,
						DateUtil.DEFAULT_DATE_FORMAT));
				    }
				    else if(ConstantsCommon.datetime.equals(paramType))
				    {
					paramVal = paramVal.replace("+", " ");
					dateFrmt = DateUtil.getDatePattern(paramVal);

					if(commonReportingBO.retSysDateParamLovVal(sessionCO.getLanguage()).equals(
						paramVal))
					{
					    parameters.put(paramName, paramVal);
					}
					else
					{
					    dt = DateUtil.parseDate(paramVal, dateFrmt);
					    parameters.put(paramName, new java.sql.Timestamp(dt.getTime()));
					}

				    }
				    else
				    {
					parameters.put(paramName, paramVal);
				    }
				}
			    }
			}
			}

		    }
		    //added by Adel
		    if(var_menuId.endsWith(ConstantsCommon.OPT_FCR_EXTENSION))
		    {
			String raFormat = commonReportingBO.retTemplateDispVal(parameters, sessionCO.getCompanyCode());
			parameters.put(ConstantsCommon.ARG_RA_FORMAT, raFormat);
			if (parameters.get(ConstantsCommon.RA_REP_LANG) == null) 
			{
			    parameters.put(ConstantsCommon.RA_REP_LANG, sessionCO.getLanguage());
			}
			//construct dynamically the jrxml of the fcr reports
			byte[] jrxml =commonReportingBO.returnDynamicFcrJrxml(reportCO,ftrOptProgRef,parameters);
			reportCO.setJRXML_FILE(jrxml);
		    }
		}
		else
		{
		    repSessionCO = returnReportingSessionObject(var_menuId);
		    // for FCR Standard Reports, when retrieving or exporting
		    // the
		    // report,
		    // retrieve the report again from the DB based on the
		    // arguments
		    // values filled in the form
		    if(var_menuId.endsWith(ConstantsCommon.OPT_FCR_EXTENSION))
		    {
				   reportCO = repSessionCO.getReportCO();
				    origJrxml=reportCO.getJRXML_FILE();
				    String ftrOptProgRef=null;
				    if(ConstantsCommon.YES.equals(parameters.get(ConstantsCommon.FCR_STANDARD_FLAG_YN)))
				    {
					try
					{
					    String fcrProgRef = (String)parameters.get(ConstantsCommon.FCR_PROG_REF);
					    parameters.put(ConstantsCommon.FCR_applName, appName);
					    parameters.put(ConstantsCommon.FCR_PROG_REF, fcrProgRef.substring(0,
						    fcrProgRef.length() - 3));
					    IRP_AD_HOC_REPORTCO repCOTemp = commonReportingBO.returnNewFcrReport(parameters);
					    parameters.remove(ConstantsCommon.FCR_applName);
					    
					    ftrOptProgRef=repCOTemp.getFTR_OPT_PROG_REF();
					    reportCO.setXlsName(repCOTemp.getXlsName());
					}
					catch(Exception e)
					{
					    throw new BOException("Error when retrieving fcr report for report reference: "
						    + var_menuId + "\n " + e.getMessage(), e);
					}
					reportCO.setSTANDARD_FLAG_YN(ConstantsCommon.YES);
				    }
				    else
				    {
					IRP_AD_HOC_REPORTSC reptSC = new IRP_AD_HOC_REPORTSC();
					reptSC.setTemplateCode((BigDecimal) (parameters.get(ConstantsCommon.FCR_TEMPL_CODE)));//RA_TMPLT_CODE
					reptSC.setCOMP_CODE((BigDecimal) parameters.get(ConstantsCommon.FCR_COMP_CODE));//RA_COMP
					if(!NumberUtil.isEmptyDecimal(reptSC.getTemplateCode()))
					{
					    try
					    {
						HashMap<String,Object> reptSCMap=new HashMap<String,Object>();
						String[] propsArr= ConstantsCommon.returnXslName_PROPS.toArray(new String[ConstantsCommon.returnXslName_PROPS.size()]);
						PathPropertyUtil.copyProperties(reptSC, reptSCMap,false,propsArr);
						String xlsName = commonReportingBO.returnXslName(reptSCMap);
						reportCO.setXlsName(xlsName);
					    }
					    catch(Exception e)
					    {
						throw new BOException("Error when retrieving xls name of the report template for report reference: "+var_menuId+"\n "+e.getMessage(),e);
					    }
					}
				    }
				    
				    //return the RA_FORMAT following the template code
				    if(!ConstantsCommon.TRUE.equals(noData))
				    {
					String raFormat = commonReportingBO.retTemplateDispVal(parameters, sessionCO.getCompanyCode());
					parameters.put(ConstantsCommon.ARG_RA_FORMAT, raFormat);
					//construct dynamically the jrxml of the fcr reports
					byte[] jrxml =commonReportingBO.returnDynamicFcrJrxml(reportCO,ftrOptProgRef,parameters);
					reportCO.setJRXML_FILE(jrxml);
				    }
		    }
		    else
		    {
			reportCO = repSessionCO.getReportCO();
		    }
		}

	    }
	    StringBuffer emptyRepsBuf = new StringBuffer();
	    if(reportCO.getJRXML_FILE() == null)
	    {
		emptyRepsBuf.append(reportCO.getPROG_REF());
	    }
	    List<IRP_SUB_REPORTCO> subRepList = reportCO.getSubreportsList();
	    IRP_SUB_REPORTCO subRep;
	    for(int i = 0; i < subRepList.size(); i++)
	    {
		subRep = subRepList.get(i);
		if(subRep.getJRXML_FILE() == null)
		{
		    emptyRepsBuf.append("," + subRep.getPROG_REF() + " ");
		}
	    }
	    if(emptyRepsBuf.length() > 0)
	    {

		BOException e = new BOException(
			getText("jrxmlofreport") + " " + emptyRepsBuf.toString() + " " + getText("isnull"));
		throw e;
	    }
		if(ConstantsCommon.EXCEL_ROW_DATA_REP_FORMAT.equals(origFormat))
		{
		    var_reportName = reportCO.getPROG_REF() + "_" + reportCO.getAPP_NAME();
		}
		else
		{
		    var_reportName = reportCO.getPROG_REF() + "_" + reportCO.getAPP_NAME() + "_"
			+ var_user.replace(".", "");
		}
	    // }

	    // print report
	    if(("true").equals(fromMenu) || ("1".equals(fei_p)))
	    {
		printReport(parameters, "", ConstantsCommon.REP_DYNAMIC_PREV_PAGE);
	    }
	    else
	    {
		printReport(parameters, saveCopyLocation, ConstantsCommon.REP_DYNAMIC_PAGE);
	    }
	    if(("1").equals(fei_p))
		{
		 return null;
		}
	    else
	    {
		if(!ConstantsCommon.TRUE.equalsIgnoreCase(retrieveCall))
		{
	    		return returnStr;
		}
	    	else
	    	{
	    	    reportOutputCO.setOutputHtml(new String(reportOutputCO.getReportBytes(), "UTF-8"));
	    	    return SUCCESS;
	    	}
	    	
	    }
	}
	catch(Exception e)
	{
	    if("2".equals(d_p) && BigDecimal.ONE.compareTo(repPrintPdf) == 0)
	    {
		response.setHeader("Set-Cookie", "repPdfFileDownload"+cookieStamp+"=false; path=/");
	    }
	    // log.error(e, "Error in generateReport() method in ReportAction");
	    handleException(e, getText("error_retrieve_report_key"), null);
	    return ERROR_ACTION;
	}
	finally
	{
		if(!ConstantsCommon.TRUE.equals(noData)
			&& var_menuId !=null && var_menuId.endsWith(ConstantsCommon.OPT_FCR_EXTENSION) && origJrxml != null)
		{
		    //put the jrxml related to the main_fcr_report in the reportCO
		    reportCO.setJRXML_FILE(origJrxml);
		}
		Thread.currentThread().setName(currentThreadName);
	}

    }

    /*
     * This method will return the session value based on the parameter 'l'
     * (language)
     */
    private Object retSessionVal(String sessionParamName, SessionCO sessionCO, BigDecimal argSource)
    {
	Object paramSessionVal = "";
	CURRENCIESVOKey currVOKey;
	CURRENCIESVO curVO = null;
	BRANCHESVOKey brVOKey;
	BRANCHESVO brVO = null;
	try
	{
	    if((argSource.equals(new BigDecimal(2)) && ConstantsCommon.LANGUAGE_ARABIC.equals(sessionCO.getLanguage()))
		    || (argSource.equals(new BigDecimal(8)) && l != null))
	    {
		if(ConstantsCommon.COMP_NAME_EXP_VAR.equals(sessionParamName))
		{
		    if(argSource.equals(new BigDecimal(8)) && ConstantsCommon.LANGUAGE_ENGLISH.equals(l))
		    {
			paramSessionVal = PathPropertyUtil.returnProperty(sessionCO, ConstantsCommon.COMP_NAME_EXP_VAR);
		    }
		    else
		    {
			paramSessionVal = PathPropertyUtil.returnProperty(sessionCO,
				ConstantsCommon.COMP_AR_NAME_SESSION);
		    }
		}
		else if(ConstantsCommon.BASE_CURR_NAME_EXP_VAR.equals(sessionParamName))
		{
		    currVOKey = new CURRENCIESVOKey();
		    currVOKey.setCOMP_CODE(sessionCO.getCompanyCode());
		    currVOKey.setCURRENCY_CODE(sessionCO.getBaseCurrencyCode());
		    curVO = returnCommonLibBO().returnCurrency(currVOKey);
		    if(argSource.equals(new BigDecimal(8)) && ConstantsCommon.LANGUAGE_ENGLISH.equals(l))
		    {
			paramSessionVal = curVO.getBRIEF_DESC_ENG();
		    }
		    else
		    {
			paramSessionVal = curVO.getBRIEF_DESC_ARAB();
		    }
		}
		else if(ConstantsCommon.BRANCH_NAME_EXP_VAR.equals(sessionParamName))
		{
		    brVOKey = new BRANCHESVOKey();
		    brVOKey.setCOMP_CODE(sessionCO.getCompanyCode());
		    brVOKey.setBRANCH_CODE(sessionCO.getBranchCode());
		    brVO = returnCommonLibBO().returnBranch(brVOKey);
		    if(argSource.equals(new BigDecimal(8)) && ConstantsCommon.LANGUAGE_ENGLISH.equals(l))
		    {
			paramSessionVal = brVO.getBRIEF_DESC_ENG();
		    }
		    else
		    {
			paramSessionVal = brVO.getBRIEF_DESC_ARAB();
		    }
		}
		else
		{
		    paramSessionVal = PathPropertyUtil.returnProperty(sessionCO, sessionParamName);
		}
	    }
	    else
	    {
		paramSessionVal = PathPropertyUtil.returnProperty(sessionCO, sessionParamName);
	    }

	}
	catch(Exception e)
	{
	    log.error(e, " error in reportAction.retSessionVal");
	}
	return paramSessionVal;
    }

    public void printReport(Map parameters, String saveCopyLocation, String callingPage)
    {
	/*
	 * the origJrxml is added since when retrieving or exporting a report in
	 * 'rowData' format the jrxml of the current reportCO will be set the
	 * jrxml created dynamically to the rowData. This origJrxml will be
	 * stored in order to be set in the current reportCO after retrieving
	 * the data
	 */
	byte[] origJrxml = reportCO.getJRXML_FILE();
	/*
	 * The origFormat is stored since when retrieving a report the
	 * var_format will be set to HTML
	 */
	if(NumberUtil.isEmptyDecimal(repPrintPdf))
	{
	    repPrintPdf = BigDecimal.ZERO;
	}
	if(BigDecimal.ONE.compareTo(repPrintPdf)==0)
	{
	    var_format = ConstantsCommon.PDF_REP_FORMAT;
	}
	String origFormat = var_format;
	byte[] origJrxmlFile = null;
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    String appName = sessionCO.getCurrentAppName();
	    repSessionCO = null;
	    if(ConstantsCommon.REP_APP_NAME.equals(appName))
	    {
		if("RD00R".equals(var_menuId))
		{
		    repSessionCO = returnReportingSessionObject();
		}
		// stoped by haytham.k for fcr reports
		// else if( !var_menuId.endsWith("DY0") )
		else
		{
		    repSessionCO = returnReportingSessionObject(var_menuId);
		}
	    }
	    if(repSessionCO != null && !var_menuId.endsWith(ConstantsCommon.OPT_FCR_EXTENSION))
	    {
		reportCO = repSessionCO.getReportCO();
	    }
	    if(reportCO == null)
	    {
		repParamsCO.setProgRef(this.var_menuId);
	    }
	    else
	    {
		if(var_menuId.endsWith(ConstantsCommon.OPT_FCR_EXTENSION))
		{
		    repParamsCO.setProgRef(this.var_menuId);
		}
		else
		{
		    repParamsCO.setProgRef(reportCO.getPROG_REF());
		}
		repParamsCO.setRepAppName(reportCO.getAPP_NAME());
	    }

	    if("true".equals(noData))
	    {
		repParamsCO.setNoData(true);
	    }
	    else
	    {
		repParamsCO.setNoData(false);
	    }
	    
	    parameters.put("repParamsCO", repParamsCO);

	    BigDecimal decimalPts = BigDecimal.ZERO;
	    String language = (l == null ? sessionCO.getLanguage() : l);

	    String printerName = "";

	    if(appName.equals(ConstantsCommon.REP_APP_NAME))
	    {
		decimalPts = sessionCO.getBaseCurrDecPoint();
	    }

	    if(("0").equals(d_p))
	    {
		printerName = ("0").equals(a_p) ? "" : r_p;
	    }

	    if(!callingPage.equals(ConstantsCommon.REP_DYNAMIC_PREV_PAGE)
		    && (ConstantsCommon.TEXT_ROW_DATA_REP_FORMAT.equals(var_format)
			    || ConstantsCommon.EXCEL_ROW_DATA_REP_FORMAT.equals(var_format) || ConstantsCommon.SQL_REP_FORMAT
			    .equals(var_format)))
	    {

		HashMap<String, Object> repCOMap = new HashMap<String, Object>();
		String[] propsArr = ConstantsCommon.createDynamicRowDataJrxml_PROPS
			.toArray(new String[ConstantsCommon.createDynamicRowDataJrxml_PROPS.size()]);
		PathPropertyUtil.copyProperties(reportCO, repCOMap, false, propsArr);
		HashMap<String, Object> retMap = commonReportingBO.createDynamicRowDataJrxml(var_noHeadAndFoot,
			var_reportName, var_menuId, repCOMap);
		reportCO.setJRXML_FILE((byte[]) retMap.get("0"));
		reportCO.setJasperDesignFieldsMap((LinkedHashMap<String, String>) retMap.get("1"));
		// if it is called from the designer section
		if(var_menuId.endsWith(ConstantsCommon.DESIGNER_PROG_REF))
		{
		    // store the original jrxml in order to be replaced in the
		    // finally statement
		    origJrxmlFile = commonReportingBO.readFileFromRepository(var_reportName, ConstantsCommon.JRXML_EXT);

		    // write the dynamic jrxml under the repository then replace
		    // it with the original one in the finally statement
		    commonReportingBO.createJRXMLFile(reportCO.getJRXML_FILE(), var_reportName);
		}
	    }

	    if(callingPage.equals(ConstantsCommon.REP_DYNAMIC_PREV_PAGE)/*
									 * &&!(
									 * ConstantsCommon
									 * .
									 * SQL_REP_FORMAT
									 * .
									 * equals
									 * (
									 * origFormat
									 * ))
									 */&& (!"1".equals(fei_p)))
	    {
		var_format = ConstantsCommon.HTML_REP_FORMAT;
		var_reportName = reportCO.getPROG_REF() + "_" + reportCO.getAPP_NAME() + "_"
			+ (sessionCO.getUserName()).replace(".", "");
		// asuccar- 26-apr-2013: commented out the below
		// var_menuId="";
	    }
	    else
	    {
		if(ConstantsCommon.EXCEL_ROW_DATA_REP_FORMAT.equals(var_format))
		{
		    var_format = ConstantsCommon.XLS_REP_FORMAT;
		}
		else if(ConstantsCommon.TEXT_ROW_DATA_REP_FORMAT.equals(var_format))
		{
		    var_format = ConstantsCommon.CSV_REP_FORMAT;
		}
	    }

	    reportCO.setCOMP_CODE(sessionCO.getCompanyCode());
	    reportCO.setBRANCH_CODE(sessionCO.getBranchCode());
	    if(NumberUtil.isEmptyDecimal(var_db))
	    {
		var_db = BigDecimal.ZERO;
	    }

	    // check if save ftr snapshot
	    if("true".equals(getSaveSnp()))
	    {
		parameters.put("isNew", ConstantsCommon.YES);
		parameters.put("pathCnt", Integer.valueOf(-1));
		ArrayList<HashMap<String, Object>> ar = new ArrayList<HashMap<String, Object>>();
		parameters.put("pathArr", ar);
	    }

	    HashMap<String, String> TransMsgLangMap = new HashMap<String, String>();
	    TransMsgLangMap.put("1", getText("reporting.excMsgProcError"));
	    TransMsgLangMap.put("2", getText("reporting.excMsgPartOne"));
	    TransMsgLangMap.put("3", getText("reporting.excMsgPartTwo"));

	    HashMap<String, Object> repSessionCOMap=PathPropertyUtil.convertToMap(reportCO);
	    repSessionCOMap.put("httpSessionIdForLink", repParamsCO.getHttpSessionIdForLink());
	    if(BigDecimal.ONE.compareTo(repPrintPdf)==0)
	    {
		parameters.put(ConstantsCommon.REP_PRINT_PDF, BigDecimal.ONE);
	    }
	    if(!NumberUtil.isEmptyDecimal(p_c_nb))
	    {
		parameters.put(ConstantsCommon.REP_NBCOPIES_PRINT, p_c_nb);
	    }
	    if(!StringUtil.isEmptyString(a_p))
	    {
		parameters.put("a_p", a_p);
	    }
	    String showPrintPreview = sessionCO.getShowPrintPreview();
	    if(!StringUtil.isEmptyString(showPrintPreview))
	    {
		parameters.put("showPrintPreview", showPrintPreview);
	    }
	    
	    if(!StringUtil.isEmptyString(retrieveCall))
	    {
	    	parameters.put("retrieveCall", retrieveCall);
	    }
	    
	    if(!StringUtil.isEmptyString(r_e_cm))
	    {
		parameters.put("r_e_cm", r_e_cm);
	    }
	    
	    if(!StringUtil.isEmptyString(r_e_im))
	    {
		parameters.put("r_e_im", r_e_im);
	    }
	
	    if(!StringUtil.isEmptyString(r_e_nm))
	    {
		parameters.put("r_e_nm", r_e_nm);
	    }
	    
	    parameters.put("d_p", d_p);
	    
	    if(!StringUtil.isEmptyString(s_s))
	    {
	    	saveCopyLocation = s_s;
	    	parameters.put("s_s", s_s);
	    }
	    
	    boolean isXLSM = false;
	    if(BigDecimal.ONE.compareTo(repPrintPdf)==0 && (ConstantsCommon.ONE.equals(a_p) || ConstantsCommon.TRUE.equals(a_p))) {
	    	// check if has opt axs
			String hasPrintXlsAxs = returnAccessRightByProgRef(reportCO.getPROG_REF() + ReportingConstantsCommon.OPT_PXL, sessionCO.getCurrentAppName());
			if(hasPrintXlsAxs != null)
			{
				isXLSM = true;
				var_format = ConstantsCommon.XLS_REP_FORMAT;
				var_reportName = reportCO.getPROG_REF() + "_" + reportCO.getAPP_NAME();
			}
	    }
	    parameters.put("isXLSM", isXLSM);
	    
	    HashMap<String, Object> retMap = commonReportingBO.printReport(var_reportName, var_format, parameters,
		    saveCopyLocation, var_menuId, repSessionCOMap, decimalPts.intValue(), appName, var_user, language,
		    printerName, var_db, var_noHeadAndFoot, var_separator, noData, fromPage, toPage, origFormat,
		    fromMenu, TransMsgLangMap);

	    reportOutputCO = new ReportOutputCO();
	    String[] propsArr = ConstantsCommon.printReportRet_PROPS.toArray(new String[ConstantsCommon.printReportRet_PROPS
		    .size()]);
	    if(!ConstantsCommon.TRUE.equalsIgnoreCase(retrieveCall)||
		retMap.get("hasPagination") == null)
	    {
		List<String> newList = new ArrayList<>(ConstantsCommon.printReportRet_PROPS);
		newList.remove("hasPagination");
		newList.remove("paginationCount");
		propsArr = newList.toArray(new String[newList.size()]);
	    }
	    if(StringUtil.isEmptyString(s_s)  || retMap.get("snpShotID") == null)
		{
			List<String> newList = new ArrayList<>(ConstantsCommon.printReportRet_PROPS);
			newList.remove("hasPagination");
			newList.remove("paginationCount");
			newList.remove("snpShotID");
			newList.remove("execDate");
			propsArr=newList.toArray(new String[newList.size()]);
		}
	    PathPropertyUtil.copyProperties(retMap, reportOutputCO, false, propsArr);
	    // rds_verified_reports
	    if(reportOutputCO != null)
	    {
		session.put(ConstantsCommon.REPORT_NB_PAGES, BigDecimal.valueOf(reportOutputCO.getPagesNbr()));
		session.put(ConstantsCommon.REPORT_HAS_DATA, reportOutputCO.isHasData());
		/*added in case the user will execute more than report at the same time we will have problem ,
		so better to have it as global variable at the level of the class*/
		reportHasData=reportOutputCO.isHasData();
		reportNbPages=BigDecimal.valueOf(reportOutputCO.getPagesNbr());
		
		if(reportOutputCO.getSnpShotID()!=null) {
			s_i = reportOutputCO.getSnpShotID().toString();
		}
		e_d = reportOutputCO.getExecDate();
	    }
	    // rds_verified_reports

	    byte[] reportBytes = reportOutputCO.getReportBytes();
	    String ext = ConstantsCommon.HTML_EXT;
	    contentType = "text/html";

	    if("zip".equals(reportOutputCO.getOutputFormat()))
	    {
		ext = ConstantsCommon.ZIP_EXT;
		contentType = "application/zip";
	    }
	    if(!ConstantsCommon.TRUE.equalsIgnoreCase(retrieveCall))
	    {
	    if("".equals(printerName))
	    {
	    	/*if r_c_p=1 then the system should return a json object containing the report result as string (repStr) and a flag saying that the report has 
	    	data(hasData) , this JSON object will be used in openPreviewAdvice to check if the report will be displayed to the user if it has not data or not*/
    	if("1".equals(r_c_d))
    	{
    		if(reportBytes != null && reportBytes.length > 0)
    		{
    		    reportOutputCO.setRepStr(new String(reportBytes,FileUtil.DEFAULT_FILE_ENCODING));
    		}
    		returnStr=SUCCESS;
  	    }
  	    else
  	    {
  	  	if("2".equals(d_p))
		{
		    if(flushResponse)
		    {
			// setting cookie in order to let file download function
			// on client side to go to success callback
			if(BigDecimal.ONE.compareTo(repPrintPdf)==0)
			{
			    response.setHeader("Set-Cookie", "repPdfFileDownload"+cookieStamp+"=true; path=/");
			    if(!reportHasData && ConstantsCommon.TRUE.equals(r_e_nm))
			    {
				String cookieStampNoData = cookieStamp + "_NoData";
				response.addHeader("Set-Cookie", "repPdfFileDownload"+cookieStampNoData+"=true; path=/");
			    }
			    if(isXLSM) {
				    response.addHeader("Content-Disposition","attachment;filename=\"" + var_reportName + "." + ReportingConstantsCommon.XLSM_EXT
						+ "\"");
				    response.setContentType("application/vnd.ms-excel.sheet.macroenabled.12");
				}else {
					response.addHeader("Content-Disposition","inline;filename=\"" + var_reportName + "." + ConstantsCommon.PDF_EXT
							+ "\"");
					response.setContentType("application/pdf");
				}
			}
			else {
				// open the report in a new window when called from iMAL
				// app
				// section not from menu
				response.setContentType(contentType);
				response.addHeader("Content-Disposition","attachment;filename=\"" + var_reportName + "." + ext
					+ "\"");
			}
			response.getOutputStream().write(reportBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			returnStr = null;
		    }
		}
		else
		{
		    var_reportName = var_reportName.replaceAll(" ", "%20");
		    if(callingPage.equals(ConstantsCommon.REP_DYNAMIC_PAGE))
		    {
			if(var_format.equalsIgnoreCase(ConstantsCommon.PDF_REP_FORMAT))
			{
			    ext = ConstantsCommon.PDF_EXT;
			    contentType = "application/pdf";
			}
			else if(ConstantsCommon.RTF_REP_FORMAT.equalsIgnoreCase(var_format))
			{
			    ext = ConstantsCommon.RTF_EXT.toLowerCase();
			    contentType = "application/rtf";
			}
			else if(var_format.equalsIgnoreCase(ConstantsCommon.DOC_REP_FORMAT))
			{
			    ext = ConstantsCommon.DOC_EXT;
			    contentType = "application/vnd.ms-word";
			}
			else if(var_format.equalsIgnoreCase(ConstantsCommon.XLS_REP_FORMAT))
			{
			    ext = ConstantsCommon.XLSX_EXT;
			    contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
			}
			else if(var_format.equalsIgnoreCase(ConstantsCommon.CSV_REP_FORMAT))
			{
			    ext = ConstantsCommon.TXT_EXT;
			    contentType = "application/txt";
			}
			else if(var_format.equalsIgnoreCase(ConstantsCommon.CSV_EXT_REP_FORMAT))
			{
			    ext = ConstantsCommon.CSV_REP_FORMAT;
			    contentType = "application/txt";
			}
			else if(var_format.equalsIgnoreCase(ConstantsCommon.SQL_REP_FORMAT))
			{
			    ext = ConstantsCommon.SQL_EXT;
			    contentType = "application/txt";
			}
			else if(ConstantsCommon.TXT_FILE.equals(var_format))
			{
			    ext = ConstantsCommon.TXT_EXT;
			    contentType = "application/txt";
			}
			else if(ConstantsCommon.DAT_EXT.equals(var_format))
			{
			    ext = ConstantsCommon.DAT_EXT.toLowerCase();
			    contentType = "application/txt";
			}
			else if(ConstantsCommon.ODS_REP_FORMAT.equalsIgnoreCase(var_format))
			{
			    ext = ConstantsCommon.ODS_REP_FORMAT.toLowerCase();
			    contentType = "application/vnd.oasis.opendocument.spreadsheet";
			}
			if(reportBytes == null)
			{
			    byte[] emptyByte = new byte[0];
			    fileStream = new ByteArrayInputStream(emptyByte);
			}
			else
			{
			    fileStream = new ByteArrayInputStream(reportBytes);
			}
			String generatedFileName=StringUtil.nullToEmpty(reportCO.getGENERATED_FILE_NAME());
			if(generatedFileName.isEmpty())
			{
			    filename = var_reportName + "." + ext;
			}
			else
			{
			    filename=commonReportingBO.returnGeneratedFileName(generatedFileName,parameters)+ "." + ext;
			}
			contentHeader = "Content-Disposition:attachment;filename=\"" + var_reportName + "." + ext
				+ "\"";
			// setting cookie in order to let file download function
			// on client side to go to success callback
			if(BigDecimal.ONE.compareTo(repPrintPdf)==0)
			{
			    response.setHeader("Set-Cookie", "repPdfFileDownload=true; path=/");
			    returnStr="successprintpdf";
			}
			else
			{
			    response.setHeader("Set-Cookie", "fileDownload=true; path=/");
			}
		    }
		    else
		    {	
			if(!("1").equals(fei_p))
			{
			response.setContentType(contentType);
			response.getOutputStream().write(reportBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			}
			returnStr = null;
			
		    }

		}
  	    }
	    	
	
		    // stopped by haytham.k for fcr reports
		    // if(!var_menuId.equals("RD00R") &&
		    // !var_menuId.endsWith("DY0"))
		    if(!var_menuId.equals(ConstantsCommon.DESIGNER_PROG_REF))
		    {
			// delete jrxml and jasper files
			try
			{
			    commonReportingBO.deleteTempFiles(var_reportName);
			}
			catch(Exception e)
			{
			    throw new BOException("Error when deleting temporary files for report reference: "
				    + reportCO.getPROG_REF() + " and report application: " + reportCO.getAPP_NAME()
				    + "\n " + e.getMessage(), e);
			}
		    }

		    // call report audit
		    callReportAudit(callingPage, parameters);
		}
		else
		{
		    // if the report automatically printed
		    returnStr = null;
		}
	    }
	    else
	    {
		// call report audit
		callReportAudit(callingPage, parameters);
	    }
	}
	catch(Exception ex)
	{
	    // log.error(ex, "Error generating the report " + var_reportName +
	    // ".");
	    if("2".equals(d_p) && BigDecimal.ONE.compareTo(repPrintPdf) == 0)
	    {
		response.setHeader("Set-Cookie", "repPdfFileDownload"+cookieStamp+"=false; path=/");
	    }
	    handleException(ex, null, null);
	    returnStr = ERROR_ACTION;
	}
	finally
	{
	    if(!callingPage.equals(ConstantsCommon.REP_DYNAMIC_PREV_PAGE)
		    && (ConstantsCommon.TEXT_ROW_DATA_REP_FORMAT.equals(origFormat)
			    || ConstantsCommon.EXCEL_ROW_DATA_REP_FORMAT.equals(origFormat) || ConstantsCommon.SQL_REP_FORMAT
			    .equals(origFormat)))
	    {
		reportCO.setJRXML_FILE(origJrxml);
		// replace the current jrxml with the original one if it is
		// called from the designer section
		if(var_menuId.endsWith(ConstantsCommon.DESIGNER_PROG_REF))
		{
		    try
		    {
			commonReportingBO.writeFileToRepository(var_reportName, new String(origJrxmlFile,
				FileUtil.DEFAULT_FILE_ENCODING), ConstantsCommon.JRXML_EXT);
		    }
		    catch(Exception e)
		    {
			handleException(e, null, null);
		    }
		}
	    }
	}
    }

    
    /**
     * @author EliasAoun (929802- SBI170052) 
     * create this common method to call the applyReportAudit whenever the report is retrieved/exported
     * 
     * @param callingPage : indicator to distinguish the report calling source
     *            (retrieve,export...)
     * @param parameters : the set of parameters sent from web page in addition
     *            to some keys filled locally
     * @throws Exception 
     */
    private void callReportAudit(String callingPage, Map parameters) throws Exception
    {
	SessionCO sessionCO = returnSessionObject();
	// call report audit
	if(!ConstantsCommon.TRUE.equals(noData) && !var_menuId.equals(ConstantsCommon.DESIGNER_PROG_REF))
	{
	    String repFormat = var_format;// origFormat
	    String optType = AuditConstant.REPORT_EXPORT;
	    // if it is called from the retrieve button or from the preview advice
	    if(callingPage.equals(ConstantsCommon.REP_DYNAMIC_PREV_PAGE) || ("2").equals(d_p))
	    {
		optType = AuditConstant.REPORT_RETRIEVE;
		repFormat = ConstantsCommon.HTML_REP_FORMAT;
	    }
	    
	    // fill the audit parameters map with only the parameters having the display flag true
	    HashMap<BigDecimal, BigDecimal> cifMap = reportOutputCO.getCifMap();
	    boolean cifAuditEnabled = BigDecimal.ONE.compareTo(NumberUtil.nullToZero(reportCO.getCIF_AUDIT_YN())) == 0;
	    HashMap<Long, IRP_REP_ARGUMENTSCO> repArgsMap = reportCO.getArgumentsList();
	    
	    HashMap<String, Object> auditParamMap = new HashMap<String, Object>();
	    IRP_REP_ARGUMENTSCO argCO;
	    String argName;
	    Object argVal;
	    ArrayList<BigDecimal> argValList;
	    ArrayList<BigDecimal> cifList = null;
	    Iterator it = repArgsMap.values().iterator();
	    
	    while(it.hasNext())
	    {
		argCO = (IRP_REP_ARGUMENTSCO) it.next();
		argName = argCO.getARGUMENT_NAME();
		argVal = parameters.get(argName);
		if(ConstantsCommon.YES.equals(argCO.getDISPLAY_FLAG()))
		{
		    auditParamMap.put(argName, StringUtil.nullToEmpty(argVal));
		}
		if(BigDecimal.ONE.compareTo(NumberUtil.nullToZero(argCO.getCIF_AUDIT_YN())) == 0 && cifAuditEnabled)
		{
		    if(ConstantsCommon.PARAM_TYPE_NUMBER.equals(argCO.getARGUMENT_TYPE()))
		    {
			try
			{
			    if(BigDecimal.ONE.compareTo(NumberUtil.nullToZero(argCO.getMULTISELECT_YN())) == 0
				    && argVal != null)
			    {
				argValList = (ArrayList<BigDecimal>) argVal;
				for(int i = 0; i < argValList.size(); i++)
				{
				    if(argValList.get(i) != null)
				    {
					cifMap.put(argValList.get(i), argValList.get(i));
				    }
				}
			    }
			    else
			    {
				if(argVal != null)
				{
				    cifMap.put((BigDecimal) argVal, (BigDecimal) argVal);
				}
			    }
			}
			catch(Exception e)
			{
			    log.debug("Warning: fe.cifAudit related Report Argument not a number " + e.getMessage());
			}
		    }
		    else
		    {
			log.debug("Warning: fe.cifAudit related Report Argument not a number");
		    }
		}
	    }
	    if(cifAuditEnabled)
	    {
		cifList = (new ArrayList<BigDecimal>(cifMap.values()));
	    }
	    // set the report format as parameter
	    auditParamMap.put(ConstantsCommon.REPORT_FORMAT_STR, repFormat);
	    //940764 - append the connection to the list of audit details
	    if(NumberUtil.emptyDecimalToNull(var_db) != null && BigDecimal.ZERO.compareTo(var_db) != 0)
	    {
		auditParamMap.put(ConstantsCommon.REP_CONN_ID, commonReportingBO.retConnectionDescById(var_db));
	    }
	    // from advice
	    if(("2").equals(d_p))
	    {
		auditParamMap.put(ConstantsCommon.REPORT_ADVICE_CALL, ConstantsCommon.TRUE);
	    }
	    auditParamMap.put(ConstantsCommon.REPORT_RETRIEVAL_APP_NAME, sessionCO.getCurrentAppName());
	    if(var_menuId.endsWith(ConstantsCommon.OPT_FCR_EXTENSION))
	    {
		applyReportAudit(auditParamMap, optType, var_menuId, null, cifList);
	    }
	    else
	    {
		applyReportAudit(auditParamMap, optType, reportCO.getPROG_REF(), reportCO.getAPP_NAME(), cifList);
	    }
	}
    }
    
    
    public String verifyReport()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    repSessionCO = returnReportingSessionObject(get_pageRef());
	    IRP_AD_HOC_REPORTCO repCO = repSessionCO.getReportCO();
	    HashMap<String, Object> valuesHash = new HashMap<String, Object>();
	    valuesHash.put("BRANCH_CODE", sessionCO.getBranchCode());
	    valuesHash.put("APP_NAME", sessionCO.getCurrentAppName());
	    valuesHash.put("USER_ID", sessionCO.getUserName());
	    valuesHash.put("PAGES_NUMBER", session.get(ConstantsCommon.REPORT_NB_PAGES));
	    valuesHash.put("REP_ID", repCO.getREPORT_ID());
	    valuesHash.put("REP_TITLE", repCO.getREPORT_NAME());
	    valuesHash.put("PROG_REF", repCO.getPROG_REF());
	    commonReportingBO.verifyReport(valuesHash);
	    updates = getText("reporting_thereport") + " " + getText("reporting_isverified");
	}
	catch(Exception e)
	{
	    handleException(e, getText("reporting.errorVerify"), getText("reporting.cannotVerify"));
	}
	return SUCCESS;
    }

    public void loadReport()
    {
	try
	{
	    byte[] reportBytes = reportOutputCO.getReportBytes();
	    String format = reportOutputCO.getOutputFormat();
	    String ext = ConstantsCommon.HTML_EXT;
	    contentType = "text/html";

	    if(FileUtil.checkIfZip(reportBytes))
	    {
	    	ext = ConstantsCommon.ZIP_EXT;
			contentType = "application/zip";
	    }
	    else if(format.equalsIgnoreCase(ConstantsCommon.PDF_REP_FORMAT))
	    {
	    	ext = ConstantsCommon.PDF_EXT;
			contentType = "application/pdf";
	    }
	    else if(format.equalsIgnoreCase(ConstantsCommon.RTF_REP_FORMAT))
	    {
	    	ext = ConstantsCommon.RTF_EXT;
			contentType = "application/pdf";
	    }
	    else if(format.equalsIgnoreCase(ConstantsCommon.DOC_REP_FORMAT))
	    {
	    	ext = ConstantsCommon.DOC_EXT;
			contentType = "application/vnd.ms-word";
	    }
	    else if(format.equalsIgnoreCase(ConstantsCommon.XLS_REP_FORMAT))
	    {
	    	ext = ConstantsCommon.XLSX_EXT;
			contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	    }
	    // setting cookie in order to let file download function
	    // on client side to go to success callback
	    if(BigDecimal.ONE.compareTo(repPrintPdf)==0)
	    {
	    	response.setHeader("Set-Cookie", "repPdfFileDownload"+cookieStamp+"=true; path=/");
	    	response.addHeader("Content-Disposition","inline;filename=\"" + var_reportName + "." + ConstantsCommon.PDF_EXT + "\"");
			response.setContentType("application/pdf");
	    }
	    else
	    {
	    	response.setContentType(contentType);
			response.addHeader("Content-Disposition","attachment;filename=\"" + getVar_reportName() + "." + ext + "\"");
	    }
	    try
	    {
	    	response.getOutputStream().write(reportBytes);
	    }
	    catch(IOException e)
	    {
	    	log.error(e, e.getMessage());
	    }
	    try
	    {
	    	response.getOutputStream().flush();
			response.getOutputStream().close();
	    }
	    catch(IOException e)
	    {
	    	log.error(e, e.getMessage());
	    }
	}
	catch(Exception e)
	{
	    if("2".equals(d_p) && BigDecimal.ONE.compareTo(repPrintPdf) == 0)
	    {
	    	response.setHeader("Set-Cookie", "repPdfFileDownload"+cookieStamp+"=false; path=/");
	    }
	    log.error(e, e.getMessage());
	}
    }

    public String getL()
    {
	return l;
    }

    public void setL(String l)
    {
	this.l = l;
    }

    public String getR_r()
    {
	return r_r;
    }

    public void setR_r(String rR)
    {
	r_r = rR;
    }

    public String getD_p()
    {
	return d_p;
    }

    public void setD_p(String dP)
    {
	d_p = dP;
    }

    public String getA_p()
    {
	return a_p;
    }

    public void setA_p(String aP)
    {
	a_p = aP;
    }

    public String getR_i()
    {
	return r_i;
    }

    public void setR_i(String rI)
    {
	r_i = rI;
    }

    public String getR_a_p()
    {
	return r_a_p;
    }

    public void setR_a_p(String rAP)
    {
	r_a_p = rAP;
    }

    public String getR_c()
    {
	return r_c;
    }

    public void setR_c(String rC)
    {
	r_c = rC;
    }

    public String getR_p()
    {
	return r_p;
    }

    public void setR_p(String rP)
    {
	r_p = rP;
    }

    public String getPb_r()
    {
	return pb_r;
    }

    public void setPb_r(String pbR)
    {
	pb_r = pbR;
    }

    public String getFilename()
    {
	return filename;
    }

    public String getW_p()
    {
	return w_p;
    }

    public void setW_p(String wP)
    {
	w_p = wP;
    }

    public String getA()
    {
	return a;
    }

    public void setA(String a)
    {
	this.a = a;
    }

    public boolean isFlushResponse()
    {
	return flushResponse;
    }

    public void setFlushResponse(boolean flushResponse)
    {
	this.flushResponse = flushResponse;
    }

    public void setFilename(String filename)
    {
	this.filename = filename;
    }

    public CommonReportingSessionCO returnReportingSessionObject()
    {
	return returnReportingSessionObject("RD00R");
    }

    public CommonReportingSessionCO returnReportingSessionObject(String ref)
    {
	String pageRef = ref;
	if(pageRef == null)
	{
	    pageRef = "RD00R";
	}
	SessionCO sessionCO = (SessionCO) session.get(ConstantsCommon.SESSION_VO_ATTR);
	HashMap<String, CommonReportingSessionCO> sessionMap = (HashMap<String, CommonReportingSessionCO>) sessionCO
		.getReportingAppDet();
	if(sessionMap == null)
	{
	    sessionCO.setReportingAppDet(new HashMap<String, CommonReportingSessionCO>());
	}
	sessionMap = (HashMap<String, CommonReportingSessionCO>) sessionCO.getReportingAppDet();
	if(sessionMap.get(pageRef) == null)
	{
	    sessionMap.put(pageRef, new CommonReportingSessionCO());
	}
	return sessionMap.get(pageRef);
    }

    /**
     * Method called on livesearch dependency and executes the
     * comparison/showhide expressions
     * 
     * @return
     * @throws Exception
     */
    public String applyArgsDependency() throws Exception
    {
	if(var_menuId.endsWith(ConstantsCommon.OPT_FCR_EXTENSION) && updates.contains(ConstantsCommon.ARG_RA_TYPE))
	{
	    String groupBy = request.getParameter(ConstantsCommon.ARG_RA_TYPE_NAME);
	    BigDecimal compCode = returnSessionObject().getCompanyCode();
	    if(ConstantsCommon.GRP_BY_SEC_BRIEF_NAME.equals(groupBy))
	    {
		BigDecimal templateCode;
		if("".equals(request.getParameter(ConstantsCommon.ARG_TEMPL_CODE_NAME)))
		{
		    templateCode = BigDecimal.valueOf(-1);
		}
		else
		{
		    templateCode = new BigDecimal(request.getParameter(ConstantsCommon.ARG_TEMPL_CODE_NAME));
		}
		int result = commonReportingBO.checkTemplateGLRecords(templateCode, compCode);
		if(result == 0)
		{
		    handleException(null, getText("reporting.calcTypeAssetHolding"), null);
		}
	    }
	    else if(ConstantsCommon.BR_CODE_BR_NAME.equals(groupBy))
	    {
		BigDecimal colTmpltCode;
		if("".equals(request.getParameter(ConstantsCommon.ARG_COL_TMP_CODE)))
		{
		    colTmpltCode = BigDecimal.valueOf(-1);
		}
		else
		{
		    colTmpltCode = new BigDecimal(request.getParameter(ConstantsCommon.ARG_COL_TMP_CODE));
		}

		if(commonReportingBO.checkColTempCalcType(colTmpltCode, compCode) == 1)
		{
		    handleException(null, getText("reporting.detailedABD"), null);
		}
	    }
	}
	if(SUCCESS.equals(checkComparison()))
	{
	    checkShowHideExpr();
	    adjustVisibility();
	}	
	return SUCCESS;
    }

    /**
     * Method called to execute the comparison expression
     * 
     * @return
     */
    public String checkComparison()
    {
	try
	{
	Enumeration enu = request.getParameterNames();
	String itemName = "";
	String itemValue = "";
	HashMap<String, String> paramNameValMap = new HashMap<String, String>();
	while(enu.hasMoreElements())
	{
	    itemName = (String) enu.nextElement();
	    itemValue = request.getParameter(itemName);
	    paramNameValMap.put(itemName, itemValue);
	}

	String argName;
	// contains key (param name as it is in the screen) and the related
	// irp_rep_argumentsco (all the arguments)
	HashMap<String, IRP_REP_ARGUMENTSCO> nameObjMap = new HashMap<String, IRP_REP_ARGUMENTSCO>();
	// contains true argument name (as in CO) and its value
	HashMap<String, String> nameValueMap = new HashMap<String, String>();
	HashMap<String, String> nameLabelMap = new HashMap<String, String>();
	CommonReportingSessionCO repSessCO;
	if(ConstantsCommon.NO.equals(fromMenu))
	{
	    repSessCO = returnReportingSessionObject(ConstantsCommon.SCHED_PROG_REF);
	}
	else
	{
	    repSessCO = returnReportingSessionObject(var_menuId);
	}
	IRP_AD_HOC_REPORTCO repCO = repSessCO.getReportCO();
	List<IRP_REP_ARGUMENTSCO> argumentsList = new ArrayList(repCO.getArgumentsList().values());
	String descCol = "";
	for(IRP_REP_ARGUMENTSCO argObj : argumentsList)
	{
	    argName = argObj.getARGUMENT_NAME();

	    if(argObj.getARGUMENT_SOURCE().equals(new BigDecimal(4)))// flag
	    {
		itemName = "__checkbox_paramsFlag." + argName + "_" + argObj.getFLAG_VALUE_ON() + "_"
			+ argObj.getFLAG_VALUE_OFF();
		itemValue = paramNameValMap.get(itemName);
	    }
	    else
	    {
		itemName = "param~" + argName + "~" + argObj.getARGUMENT_TYPE();
		itemValue = paramNameValMap.get(itemName);
	    }
	    if(itemValue != null)
	    {
		nameObjMap.put(itemName, argObj);
		nameValueMap.put(argName, itemValue);
		nameLabelMap.put(argName, argObj.getARGUMENT_LABEL());
	    }
	    if(updates.split("~")[1].equals(argName))
	    {
		descCol = argObj.getCOLUMN_DESC();
	    }
	}
	
	//checking if livesearch
	argName = updates.split("~")[1];
	ArrayList<LinkedHashMap> resQry = new ArrayList<LinkedHashMap>();
	if(qryId!=null)
	{
		 //retrieve the value of the mapped arg. of type 'static'
		IRP_QUERY_ARG_MAPPINGVO argMapVO;
	    IRP_AD_HOC_REPORTSC reportSC = new IRP_AD_HOC_REPORTSC();
	    reportSC.setREPORT_ID(repCO.getREPORT_ID());
	    reportSC.setDefaultSrc(BigDecimal.ONE);
		reportSC.setReportArgumentId(argId);
		
	    HashMap<String, Object> repSCMap = new HashMap<String, Object>();
	    String[] propsArr1= ConstantsCommon.retQryArgMapping_PROPS.toArray(new String[ConstantsCommon.retQryArgMapping_PROPS.size()]);
	    PathPropertyUtil.copyProperties(reportSC, repSCMap, false, propsArr1);
	    List<HashMap<String, Object>> listDfltSrc = commonReportingBO.retQryArgMapping(repSCMap);
	    HashMap<String, Object> hm;
	    IRP_QUERY_ARG_MAPPINGCO argMapCO;
	    propsArr1= ConstantsCommon.retQryArgMappingRet_PROPS.toArray(new String[ConstantsCommon.retQryArgMappingRet_PROPS.size()]);
	    for(int j = 0; j < listDfltSrc.size(); j++)
	    {
		hm = listDfltSrc.get(j);
		argMapCO = new IRP_QUERY_ARG_MAPPINGCO();
		PathPropertyUtil.copyProperties(hm, argMapCO, false, propsArr1);
		argMapVO = argMapCO.getIrpQueryArgsMappingVO();
		if (!StringUtil.nullToEmpty(argMapVO.getSTATIC_VALUE()).isEmpty()) 
		{
			nameValueMap.put(argMapVO.getQUERY_ARG_NAME(), argMapVO.getSTATIC_VALUE());
		}
		}
	    //checking if value exists in db
	    // updates is the argument name being changed
	    DynLookupSC dynLookupSC = new DynLookupSC();
	    dynLookupSC.setIsSybase(returnCommonLibBO().returnIsSybase());
	    dynLookupSC.setHmQryParam(nameValueMap);
	    dynLookupSC.setQryId(qryId);
	    if(NumberUtil.emptyDecimalToNull(conId)!=null)
	    {
		dynLookupSC.setConnId(conId);
	    }
	    dynLookupSC.setArgId(argId);
	    dynLookupSC.setArgVal(nameValueMap.get(argName));
	    
	    SessionCO sessionCO = returnSessionObject();
	    dynLookupSC.setCompCode(sessionCO.getCompanyCode());
	    dynLookupSC.setBranchCode(sessionCO.getBranchCode());
	    dynLookupSC.setUserId(sessionCO.getUserName());
	    dynLookupSC.setCurrAppName(sessionCO.getCurrentAppName());
	    dynLookupSC.setReportId(repCO.getREPORT_ID());
	    HashMap<String,Object> dynLookupSCMap=new HashMap<String,Object>();
	    String[] propsArr= ConstantsCommon.returnQryResult_PROPS.toArray(new String[ConstantsCommon.returnQryResult_PROPS.size()]);
	    PathPropertyUtil.copyProperties(dynLookupSC, dynLookupSCMap,false,propsArr);	        
	    resQry = commonReportingBO.returnQryResult(dynLookupSCMap);
	    if(resQry.isEmpty())
	    {
		return ERROR;
	    }
	}
	// flag if expression should be evaluated
	boolean evaluate;
	StringBuffer resultExec = new StringBuffer();
	String conditionExpr2;
	String paramLblTrans;
	for(Entry<String, IRP_REP_ARGUMENTSCO> entryObj : nameObjMap.entrySet())
	{
	    evaluate = true;
	    String conditionExpr = entryObj.getValue().getIrpRepArgConstraintCO().getCONDITION();
	    conditionExpr2 = conditionExpr;
	    // some arguments can be defined without a condition
	    // update is the argument being changed
	    if(conditionExpr != null && conditionExpr.indexOf(nameObjMap.get(updates).getARGUMENT_NAME()) != -1)
	    {
		for(Entry<String, String> entryNameVal : nameValueMap.entrySet())
		{
		    if(conditionExpr.indexOf(entryNameVal.getKey()) != -1)
		    {
			// if an argument is empty don't evaluate the expression
			if("".equals(entryNameVal.getValue()))
			{
			    evaluate = false;
			    break;
			}
			else
			{
			    // replacing the argument name in the expression
			    // with its value
			    conditionExpr = conditionExpr.replace("[" + entryNameVal.getKey() + "]", entryNameVal
				    .getValue());
			    
			    paramLblTrans = returnKeyTrans(entryNameVal.getKey(), repCO.getAPP_NAME(),repCO.getPROG_REF());
				if(StringUtil.nullToEmpty(paramLblTrans).equals(entryNameVal.getKey()))
				{
					paramLblTrans=nameLabelMap.get(entryNameVal.getKey());
				}
			    conditionExpr2=conditionExpr2.replace("[" + entryNameVal.getKey() + "]", paramLblTrans);
			}
		    }
		}
		if(evaluate)
		{
		    Map<String, Object> row;
		    List<Map<String, Object>> rowData = new ArrayList<Map<String, Object>>();
		    row = new LinkedHashMap<String, Object>();
		    row.put("", "");
		    rowData.add(row);
		    try
		    {
			Object result = returnCommonLibBO().executeExpression(conditionExpr, 0, rowData);
			if(result instanceof Boolean)
			{
			    Boolean res = (Boolean) result;
			    if(!res.booleanValue())
			    {
			    	  paramLblTrans = returnKeyTrans(entryObj.getValue().getARGUMENT_NAME(), repCO.getAPP_NAME(),repCO.getPROG_REF());   	 
					  if(StringUtil.nullToEmpty(paramLblTrans).equals(entryObj.getValue().getARGUMENT_NAME()))
					  {
							paramLblTrans=entryObj.getValue().getARGUMENT_LABEL();
					  }
							    
				resultExec.append(getText("reporting.compNotSatisfied") + " " 
					+"\""+ paramLblTrans +"\"" + "\n"
					+ getText("reporting.shouldBe")
					+ conditionExpr2 + "\n"+"\n");
			    }
			}
		    }
		    catch(Exception e)
		    {
			handleException(e, null, null);
		    }
		}
	    }

	}
	String elemId = repCO.getArgShowHideMap().get(updates).get(BigDecimal.ZERO);
	if(!resultExec.toString().isEmpty())
	{
	    SYS_PARAM_SCREEN_DISPLAYVO vo = new SYS_PARAM_SCREEN_DISPLAYVO();
	    vo.setValue("");
	    // emptying the value of the argument being changed
	    getAdditionalScreenParams().put(elemId, vo);
	    if(elemId.startsWith("lookuptxt_"))
	    {
		SYS_PARAM_SCREEN_DISPLAYVO voDesc = new SYS_PARAM_SCREEN_DISPLAYVO();
		voDesc.setValue("");
		getAdditionalScreenParams().put(
			"p_desc_" + (ConstantsCommon.NO.equals(fromMenu) ? "sched_" : "") + updates.split("~")[1] + "_" + var_menuId, voDesc);
	    }
	    update = elemId;
	    updates = resultExec.toString();
	    addDependencyMsg(updates, null);
	}
	else if(qryId!=null)
	{
	    SYS_PARAM_SCREEN_DISPLAYVO vo = new SYS_PARAM_SCREEN_DISPLAYVO();
	    vo.setValue(nameValueMap.get(argName));
	    getAdditionalScreenParams().put(elemId, vo);
	    if(elemId.startsWith("lookuptxt_"))
	    {
		SYS_PARAM_SCREEN_DISPLAYVO voDesc = new SYS_PARAM_SCREEN_DISPLAYVO();
		if("".equals(vo.getValue()))
		{
		    voDesc.setValue("");
		}
		else
		{
		    voDesc.setValue(resQry.get(0).get(descCol));
		}
		getAdditionalScreenParams().put(
			"p_desc_" + (ConstantsCommon.NO.equals(fromMenu) ? "sched_" : "") + updates.split("~")[1]
			    + "_" + var_menuId, voDesc);
	    }
	    
	}
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Method that checks the show hide expressions
     * 
     * @return
     * @throws Exception
     */
    public String checkShowHideExpr() throws Exception
    {
	String itemName = "";
	String itemValue = "";
	HashMap<String, String> paramNameValMap = new HashMap<String, String>();
	Enumeration enu = request.getParameterNames();
	while(enu.hasMoreElements())
	{
	    itemName = (String) enu.nextElement();
	    itemValue = request.getParameter(itemName);
	    paramNameValMap.put(itemName, itemValue);
	}

	String argName;
	// contains key (param name as it is in the screen) and the related
	// irp_rep_argumentsco (all the arguments)
	HashMap<String, IRP_REP_ARGUMENTSCO> nameObjMap = new HashMap<String, IRP_REP_ARGUMENTSCO>();
	// contains true argument name (as in CO) and its value
	HashMap<String, String> nameValueMap = new HashMap<String, String>();

	CommonReportingSessionCO repSessCO;
	if(ConstantsCommon.NO.equals(fromMenu))
	{
	    repSessCO = returnReportingSessionObject(ConstantsCommon.SCHED_PROG_REF);
	}
	else
	{
	    repSessCO = returnReportingSessionObject(var_menuId);
	}
	IRP_AD_HOC_REPORTCO repCO = repSessCO.getReportCO();
	List<IRP_REP_ARGUMENTSCO> argumentsList = new ArrayList(repCO.getArgumentsList().values());
	for(IRP_REP_ARGUMENTSCO argObj : argumentsList)
	{
	    argName = argObj.getARGUMENT_NAME();
	    if(argObj.getARGUMENT_SOURCE().equals(new BigDecimal(4)))// flag
	    {
		itemName = "__checkbox_paramsFlag." + argName + "_" + argObj.getFLAG_VALUE_ON() + "_"
			+ argObj.getFLAG_VALUE_OFF();
		itemValue = paramNameValMap.get(itemName);
	    }
	    else
	    {
		itemName = "param~" + argName + "~" + argObj.getARGUMENT_TYPE();
		itemValue = paramNameValMap.get(itemName);
	    }

	    if(itemValue != null)
	    {
		nameObjMap.put(itemName, argObj);
		nameValueMap.put(argName, itemValue);
	    }
	}
	for(Entry<String, IRP_REP_ARGUMENTSCO> entryObj : nameObjMap.entrySet())
	{
	    String showExpression = entryObj.getValue().getIrpRepArgConstraintCO().getSHOW_EXPR();
	    testShowHideExpr(repCO, nameValueMap, "1", showExpression, entryObj.getKey());
	}
	for(Entry<String, IRP_REP_ARGUMENTSCO> entryObj : nameObjMap.entrySet())
	{
	    String hideExpression = entryObj.getValue().getIrpRepArgConstraintCO().getHIDE_EXPR();
	    testShowHideExpr(repCO, nameValueMap, "0", hideExpression, entryObj.getKey());
	}
	return SUCCESS;
    }

    /**
     * Method that executes the show and hide expression and set values in
     * session hashmap if result is true
     * 
     * @param repCO
     * @param nameValueMap
     * @param nameObjMap
     * @param option
     * @param expression
     * @param key
     */
    public void testShowHideExpr(IRP_AD_HOC_REPORTCO repCO, HashMap<String, String> nameValueMap, String option,
	    String theExpression, String argName)
    {
	String expression = theExpression;
	// some arguments can be defined without a condition
	// update is the argument being changed
	if(expression != null)
	{
	    boolean evaluate = true;
	    for(Entry<String, String> entryNameVal : nameValueMap.entrySet())
	    {
		if(expression.indexOf(entryNameVal.getKey()) != -1)
		{
		    // replacing the argument name in the expression
		    // with its value
		    if("".equals(entryNameVal.getValue()))
		    {
			evaluate = false;
		    }
		    else
		    {
			expression = expression.replace("[" + entryNameVal.getKey() + "]", entryNameVal.getValue());
		    }
		    break;
		}
	    }

	    if(evaluate)
	    {
		Map<String, Object> row;
		List<Map<String, Object>> rowData = new ArrayList<Map<String, Object>>();
		row = new LinkedHashMap<String, Object>();
		row.put("", "");
		rowData.add(row);
		try
		{
		    Object result = returnCommonLibBO().executeExpression(expression, 0, rowData);
		    if(result instanceof Boolean)
		    {
			Boolean res = (Boolean) result;
			if(res.booleanValue())
			{
			    // set the visibility flag in the map
			    // lMap contains get(0): the id and get(1): the
			    // visibility flag
			    HashMap<BigDecimal, String> lMap = repCO.getArgShowHideMap().get(argName);
			    // option ==1 => visible.0=>hide
			    // condition added to handle checkboxes because if
			    // checkbox hidden,
			    // conventional name being sent and doesn't matter
			    if(lMap != null)
			    {
				lMap.put(BigDecimal.valueOf(1), option);
			    }
			}
		    }
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
	    }
	}
    }

    /**
     * Method that adjust dynamically the visibility of screens' arguments
     * 
     * @return
     */
    public String adjustVisibility()
    {
	SYS_PARAM_SCREEN_DISPLAYVO screenArgHide = new SYS_PARAM_SCREEN_DISPLAYVO();
	SYS_PARAM_SCREEN_DISPLAYVO screenArgShow = new SYS_PARAM_SCREEN_DISPLAYVO();
	screenArgHide.setIS_VISIBLE(BigDecimal.ZERO);
	screenArgShow.setIS_VISIBLE(BigDecimal.ONE);
	String pageRef = var_menuId;
	if(ConstantsCommon.NO.equals(fromMenu))
	{
	    pageRef = ConstantsCommon.SCHED_PROG_REF;
	}
	else if(pageRef == null)
	{
	    pageRef = get_pageRef();
	}
	CommonReportingSessionCO repSessionCO = returnReportingSessionObject(pageRef);
	IRP_AD_HOC_REPORTCO repCO = repSessionCO.getReportCO();
	for(Entry<String, HashMap<BigDecimal, String>> entry : repCO.getArgShowHideMap().entrySet())
	{
	    if(entry.getValue().get(BigDecimal.valueOf(1)) != null
		    && entry.getValue().get(BigDecimal.valueOf(1)).equals("0"))
	    {
		getAdditionalScreenParams().put(entry.getValue().get(BigDecimal.valueOf(0)), screenArgHide);
	    }
	    else if(entry.getValue().get(BigDecimal.valueOf(1)) != null
		    && entry.getValue().get(BigDecimal.valueOf(1)).equals("1"))
	    {
		if(getAdditionalScreenParams().get(entry.getValue().get(BigDecimal.valueOf(0))) == null)
		{
		    getAdditionalScreenParams().put(entry.getValue().get(BigDecimal.valueOf(0)), screenArgShow);
		}
		// if already we have value="" set previously to preserve it
		else
		{
		    getAdditionalScreenParams().get(entry.getValue().get(BigDecimal.valueOf(0))).setIS_VISIBLE(
			    BigDecimal.ONE);
		}
	    }
	}
	// cleaning the map
	for(Entry<String, HashMap<BigDecimal, String>> entry : repCO.getArgShowHideMap().entrySet())
	{
	    entry.getValue().remove(BigDecimal.valueOf(1));
	}
	return SUCCESS;
    }
    
    /**
     * Method to fill new args values on change of an arg in the screen 
     * @return
     */
    public String fillNewArgsValuesInSession()
    {
	try
	{
	    String itemName = "";
	    String itemValue = "";
	    HashMap<String, String> paramNameValMap = new HashMap<String, String>();
	    Enumeration enu = request.getParameterNames();
	    while(enu.hasMoreElements())
	    {
		itemName = (String) enu.nextElement();
		itemValue = request.getParameter(itemName);
		paramNameValMap.put(itemName, itemValue);
	    }

	    String argName;
	    // contains key (param name as it is in the screen) and the related
	    // irp_rep_argumentsco (all the arguments)
	    HashMap<String, IRP_REP_ARGUMENTSCO> nameObjMap = new HashMap<String, IRP_REP_ARGUMENTSCO>();
	    // contains true argument name (as in CO) and its value
	    HashMap<String, String> nameValueMap = new HashMap<String, String>();

	    CommonReportingSessionCO repSessCO;
	    if(ConstantsCommon.NO.equals(fromMenu))
	    {
		repSessCO = returnReportingSessionObject(ConstantsCommon.SCHED_PROG_REF);
	    }
	    else
	    {
		repSessCO = returnReportingSessionObject(var_menuId);
	    }
	    IRP_AD_HOC_REPORTCO repCO = repSessCO.getReportCO();
	    List<IRP_REP_ARGUMENTSCO> argumentsList = new ArrayList(repCO.getArgumentsList().values());
	    for(IRP_REP_ARGUMENTSCO argObj : argumentsList)
	    {
		argName = argObj.getARGUMENT_NAME();
		if(argObj.getARGUMENT_SOURCE().equals(new BigDecimal(4)))// flag
		{
		    itemName = "__checkbox_paramsFlag." + argName + "_" + argObj.getFLAG_VALUE_ON() + "_"
			    + argObj.getFLAG_VALUE_OFF();
		    itemValue = paramNameValMap.get(itemName);
		}
		else
		{
		    itemName = "param~" + argName + "~" + argObj.getARGUMENT_TYPE();
		    itemValue = paramNameValMap.get(itemName);
		}

		if(itemValue != null)
		{
		    nameObjMap.put(itemName, argObj);
		    nameValueMap.put(argName, itemValue);
		}
		//combo empty not sent
		else if(new BigDecimal(ConstantsCommon.REP_ARG_TYPE_QRY).equals(argObj.getARGUMENT_SOURCE())
			&& ConstantsCommon.ARG_QRY_COMBO.equals(argObj.getARG_QUERY_OPTIONS()))
		{
		    nameObjMap.put(itemName, argObj);
		    nameValueMap.put(argName, "");
		}
	    }
	    IRP_REP_ARGUMENTSCO argCO;
	    DynLookupSC dynLookupSC;
	    HashMap<String, Object> dynLookupSCMap;
	    String[] propsArr;
	    ArrayList<LinkedHashMap> queryResult; 
	    HashMap<BigDecimal,String> refreshHm = new HashMap<BigDecimal, String>();
	    List<IRP_QUERY_ARG_MAPPINGCO> argsMapCOList;
	    for(Entry<String, List<IRP_QUERY_ARG_MAPPINGCO>> entry : repCO.getLinkQryArsMap().entrySet())
	    {
		argsMapCOList = entry.getValue();
		for(int i = 0; i < argsMapCOList.size(); i++)
		{
		    //if report_mapped_arg_name is the argument being changed in screen, put in refreshHm that the query
		    //needs to be rerun
		    if(updates.contains("~"
			    + argsMapCOList.get(i).getIrpQueryArgsMappingVO().getREPORT_MAPPED_ARG_NAME() + "~"))
		    {
			refreshHm.put(argsMapCOList.get(i).getIrpQueryArgsMappingVO().getQUERY_ID(),
				ConstantsCommon.TRUE);
		    }
		}
	    }
	    for(Entry<String, IRP_REP_ARGUMENTSCO> entryObj : nameObjMap.entrySet())
	    {
		//argument that will be refreshed
		argCO = entryObj.getValue();
		if(refreshHm.get(argCO.getQUERY_ID()) != null && !NumberUtil.isEmptyDecimal(argCO.getQUERY_ID()))
		{
		    // execute the main query and set the result in the
		    // related argument in screen
		    dynLookupSC = new DynLookupSC();
		    dynLookupSC.setIsSybase(returnCommonLibBO().returnIsSybase());
		    dynLookupSC.setHmQryParam(nameValueMap);
		    dynLookupSC.setQryId(argCO.getQUERY_ID().toString());
		    if(NumberUtil.emptyDecimalToNull(conId) != null)
		    {
			dynLookupSC.setConnId(conId);
		    }
		    dynLookupSC.setArgId(argCO.getARGUMENT_ID());
		    dynLookupSC.setReportId(repCO.getREPORT_ID());
		    dynLookupSCMap = new HashMap<String, Object>();
		    propsArr = ConstantsCommon.returnQryResult_PROPS.toArray(new String[ConstantsCommon.returnQryResult_PROPS.size()]);
		    PathPropertyUtil.copyProperties(dynLookupSC, dynLookupSCMap, false, propsArr);
		    queryResult = commonReportingBO.returnQryResult(dynLookupSCMap);
		    if(queryResult.isEmpty())
		    {
			repCO.getArgRefreshLkpMap().put(
				repCO.getArgShowHideMap().get(
					ConstantsCommon.PARAM_TILDA + argCO.getARGUMENT_NAME() + "~"
						+ argCO.getARGUMENT_TYPE()).get(BigDecimal.valueOf(0)), "");
		    }
		    else
		    {
			if(new BigDecimal(ConstantsCommon.REP_ARG_TYPE_QRY).equals(argCO.getARGUMENT_SOURCE())
				&& ConstantsCommon.ARG_QRY_COMBO.equals(argCO.getARG_QUERY_OPTIONS()))
			{
			    repCO.getArgRefreshLkpMap().put(
				    repCO.getArgShowHideMap().get(
					    ConstantsCommon.PARAM_TILDA + argCO.getARGUMENT_NAME() + "~"
						    + argCO.getARGUMENT_TYPE()).get(BigDecimal.valueOf(0)),
				    queryResult);
			}
			else
			{
			    repCO.getArgRefreshLkpMap().put(
				    repCO.getArgShowHideMap().get(
					    ConstantsCommon.PARAM_TILDA + argCO.getARGUMENT_NAME() + "~"
						    + argCO.getARGUMENT_TYPE()).get(BigDecimal.valueOf(0)),
				    queryResult.get(0).get(argCO.getCOLUMN_NAME()));
			}
		    }
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Method filling the new values on dependency
     * @return
     */
    public String refreshArgumentsValues() 
    {
	try
	{
	    String pageRef = var_menuId;
	    if(ConstantsCommon.NO.equals(fromMenu))
	    {
		pageRef = ConstantsCommon.SCHED_PROG_REF;
	    }
	    else if(pageRef == null)
	    {
		pageRef = get_pageRef();
	    }
	    CommonReportingSessionCO repSessionCO = returnReportingSessionObject(pageRef);
	    IRP_AD_HOC_REPORTCO repCO = repSessionCO.getReportCO();
	    SYS_PARAM_SCREEN_DISPLAYVO screenArgVal;
	    for(Entry<String, Object> entry : repCO.getArgRefreshLkpMap().entrySet())
	    {
		if(entry.getKey().contains("_" + ConstantsCommon.PARAM_TYPE_DATE + "_"))
		{
		    if(StringUtil.isNotEmpty((String) entry.getValue()))
		    {
			entry.setValue(DateUtil.parseDate((String) entry.getValue(), DateUtil.DEFAULT_DATE_FORMAT));
		    }
		    else
		    {
			entry.setValue(null);
		    }
		}
		screenArgVal = new SYS_PARAM_SCREEN_DISPLAYVO();
		screenArgVal.setValue(entry.getValue()==null?"":entry.getValue());
		getAdditionalScreenParams().put(entry.getKey(), screenArgVal);
	    }
	    repCO.getArgRefreshLkpMap().clear();
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Method for saving / loading filters
     * @return
     */
    public String saveLoadFilter()
    {
	try
	{
	    CommonReportingSessionCO repSessCO;
	    if(var_menuId == null)
	    {
		var_menuId = get_pageRef();
	    }
	    repSessCO = returnReportingSessionObject(var_menuId);
	    IRP_AD_HOC_REPORTCO repCO = repSessCO.getReportCO();
	    if(StringUtil.isNotEmpty(filterName))
	    {	if("".equals(filterName.trim()))
		{
		    handleException(null,getText("reporting.emptyFilterName"),null);
		    return ERROR;
		}
		IRP_REP_FILTERSSC filterSC = new IRP_REP_FILTERSSC();
		filterSC.setREPORT_ID(repCO.getREPORT_ID());
		filterSC.setFILTER_NAME(filterName.trim());
		filterSC.setFILTER_ID( NumberUtil.nullEmptyToValue(filterId,new BigDecimal(-1)));
	    SessionCO sessionCO = returnSessionObject();
		filterSC.setCREATED_BY(sessionCO.getUserName());
		HashMap<String, Object> filtersSCMap = PathPropertyUtil.convertToMap(filterSC);
		boolean isFilterNameUnique = commonReportingBO.checkFilterNameUnique(filtersSCMap);
		BigDecimal defaultFilter = null;
		if(ConstantsCommon.TRUE.equals(defaultYn))
		{
			defaultFilter = commonReportingBO.selectDefaultFilter(filtersSCMap);
		}
		if(!isFilterNameUnique || (defaultFilter != null && defaultFilter.compareTo(filterId) != 0))
		{
		    // already filter with given name exists
		    if(!isFilterNameUnique)
		    {
			update = "0";
		    }
		    // already default filter exists
		    if(defaultFilter != null && defaultFilter.compareTo(filterId) != 0)
		    {
			update = ("0").equals(update) ? "3" : "2";
		    }
		    return SUCCESS;
		}
	    }
	    String itemName = "";
	    String itemValue = "";
	    HashMap<String, String> paramNameValMap = new HashMap<String, String>();
	    Enumeration enu = request.getParameterNames();
	    while(enu.hasMoreElements())
	    {
		itemName = (String) enu.nextElement();
		itemValue = request.getParameter(itemName);
		paramNameValMap.put(itemName, itemValue);
	    }
	    String argName;
	    // contains key (param name as it is in the screen) and the related
	    // irp_rep_argumentsco (all the arguments)
	    HashMap<String, IRP_REP_ARGUMENTSCO> nameObjMap = new HashMap<String, IRP_REP_ARGUMENTSCO>();
	    // contains true argument name (as in CO) and its value
	    HashMap<String, String> nameValueMap = new HashMap<String, String>();
	    List<IRP_REP_ARGUMENTSCO> argumentsList = new ArrayList(repCO.getArgumentsList().values());
	    HashMap<BigDecimal, IRP_REP_ARGUMENTSCO> argsMap = new HashMap<BigDecimal, IRP_REP_ARGUMENTSCO>();
	    String valueMultiHidden;
	    String argType;
	    Map parameters;
	    StringBuffer sb;
	    ArrayList<Object> lstValues;
	    String val;
	    String valueOn;
	    String valueOff;
	    for(IRP_REP_ARGUMENTSCO argObj : argumentsList)
	    {
		argName = argObj.getARGUMENT_NAME();
		// flag
		if(new BigDecimal(4).equals(argObj.getARGUMENT_SOURCE()))
		{
		    itemName = "__checkbox_paramsFlag." + argName + "_" + argObj.getFLAG_VALUE_ON() + "_"
			    + argObj.getFLAG_VALUE_OFF();
		    val = itemName.substring(11);
		    itemName = val.substring(11, val.length() - 4);
		    valueOn = val.substring(val.length() - 3, val.length() - 2);
		    valueOff = val.substring(val.length() - 1, val.length());
		    if(paramNameValMap.get(val) == null)
		    {
			itemValue = valueOff;
		    }
		    else
		    {
			itemValue = valueOn;
		    }
		}
		else if(BigDecimal.ONE.equals(argObj.getMULTISELECT_YN()))
		{
		    itemName = ConstantsCommon.PARAM_H + "~" + argName + "~" + argObj.getARGUMENT_TYPE();
		    if(StringUtil.isNotEmpty(paramNameValMap.get(itemName)))
		    {
			// valueMultiHidden contains [root:...
			valueMultiHidden = paramNameValMap.get(itemName);
			argType = argObj.getARGUMENT_TYPE();
			parameters = new HashMap<String, Object>();
			parameters = commonReportingBO.fillParametersWithCollection(itemName, valueMultiHidden,
				parameters, argType, 1);
			sb = new StringBuffer();
			lstValues = (ArrayList<Object>) parameters.get(itemName);
			for(int i = 0; i < lstValues.size(); i++)
			{
			    val = lstValues.get(i).toString();
			    if(ConstantsCommon.PARAM_TYPE_VARCHAR2.equals(argType))
			    {
				val = val.replace("\"", "\"\"");
				sb.append("\"" + val + "\"");
			    }
			    else
			    {
				sb.append(val);
			    }
			    if(i < lstValues.size() - 1)
			    {
				sb.append(",");
			    }
			}
			itemValue = sb.toString();
		    }
		    else
		    {
			itemValue = "";
		    }
		}
		else
		{
		    itemName = "param~" + argName + "~" + argObj.getARGUMENT_TYPE();
		    itemValue = paramNameValMap.get(itemName);
		}
		if(BigDecimal.ONE.equals(argObj.getTO_SAVE_YN()))
		{
		    nameObjMap.put(itemName, argObj);
		    nameValueMap.put(argName, itemValue);
		}
		// emptying the values not savable
		else
		{
		    emptyArgsFromFilter(argObj, repCO, var_menuId);
		}
		argsMap.put(argObj.getARGUMENT_ID(), argObj);
	    }
	    // load existing filter
	    if(ConstantsCommon.TRUE.equals(update))
	    {
		IRP_REP_FILTERSSC filterSC = new IRP_REP_FILTERSSC();
		filterSC.setREPORT_ID(repCO.getREPORT_ID());
		filterSC.setFILTER_ID(filterId);
		HashMap<String, Object> filtersSCMap = PathPropertyUtil.convertToMap(filterSC);
		List<HashMap<String, Object>> filterArgslistMap = commonReportingBO
			.retFilterArgumentsValues(filtersSCMap);
		String[] propsArr = ConstantsCommon.retFiltersArgsListMap_PROPS.toArray(new String[ConstantsCommon.retFiltersArgsListMap_PROPS.size()]);
		HashMap<String, Object> retMap;
		IRP_REP_ARGUMENTS_FILTERSVO argFilterVO;
		ArrayList<IRP_REP_ARGUMENTS_FILTERSVO> listArgsFilters = new ArrayList<IRP_REP_ARGUMENTS_FILTERSVO>();
		for(int i = 0; i < filterArgslistMap.size(); i++)
		{
		    retMap = filterArgslistMap.get(i);
		    argFilterVO = new IRP_REP_ARGUMENTS_FILTERSVO();
		    PathPropertyUtil.copyProperties(retMap, argFilterVO, false, propsArr);
		    listArgsFilters.add(argFilterVO);
		}
		IRP_REP_ARGUMENTSCO argCO;
		String valArray[];
		String argValue;
		String valHidden;
		String valMulti;
		DynLookupSC dynLookupSC;
		HashMap<String, Object> dynLookupSCMap;
		ArrayList<LinkedHashMap> resQry;
		ArrayList<String> emptyValues;
		for(int i = 0; i < listArgsFilters.size(); i++)
		{
		    argFilterVO = listArgsFilters.get(i);
		    argCO = argsMap.get(argFilterVO.getARGUMENT_ID());
		    if(argCO == null)
		    {
			argsMap.remove(argFilterVO.getARGUMENT_ID());
			continue;
		    }
		    argValue = argFilterVO.getARGUMENT_VALUE();
		    valHidden = "";
		    valMulti = "";
		    if(BigDecimal.ONE.equals(argCO.getMULTISELECT_YN()))
		    {
			// constructing the json string from db values
			if(StringUtil.isNotEmpty(argFilterVO.getARGUMENT_VALUE()))
			{
			    valArray = argFilterVO.getARGUMENT_VALUE().split(",");
			    argValue = valArray.length + ConstantsCommon.P_SELECTED;
			    sb = new StringBuffer();
			    for(int j = 0; j < valArray.length; j++)
			    {
				if(sb.length() > 0)
				{
				    sb.append(",");
				}
				if(ConstantsCommon.PARAM_TYPE_VARCHAR2.equals(argCO.getARGUMENT_TYPE()))
				{
				    // if string contains ""
				    valArray[j] = valArray[j].replace("\"\"", "\\\"");
				    sb.append("{\"" + argCO.getCOLUMN_NAME() + "\":" + valArray[j].trim() + "}");
				}
				else
				{
				    sb.append("{\"" + argCO.getCOLUMN_NAME() + "\":\"" + valArray[j].trim() + "\"}");
				}
			    }
			    valHidden = ConstantsCommon.MULTI_P_ROOT + sb.toString() + "]}";
			    valMulti = argValue;
			}
			repCO.getArgRefreshLkpMap().put(
				ConstantsCommon.P_PARAM_UNDERSCORE + argCO.getARGUMENT_NAME() + "_"
					+ argCO.getARGUMENT_TYPE() + "_" + var_menuId, valHidden);
			repCO.getArgRefreshLkpMap().put(
				repCO.getArgShowHideMap()
					.get(argCO.getARGUMENT_NAME() + "~" + argCO.getARGUMENT_TYPE())
					.get(BigDecimal.valueOf(0)), valMulti);
			argsMap.remove(argFilterVO.getARGUMENT_ID());
			continue;
		    }
		    if(argCO.getARGUMENT_SOURCE().equals(new BigDecimal(4)))
		    {
			itemName = "__checkbox_paramsFlag." + argCO.getARGUMENT_NAME() + "_" + argCO.getFLAG_VALUE_ON()
				+ "_" + argCO.getFLAG_VALUE_OFF();
			val = itemName.substring(11);
			valueOn = val.substring(val.length() - 3, val.length() - 2);
			valueOff = val.substring(val.length() - 1, val.length());
			repCO.getArgRefreshLkpMap().put(
				repCO.getArgShowHideMap()
					.get("__checkbox_paramsFlag." + argCO.getARGUMENT_NAME() + "_"
						+ argCO.getFLAG_VALUE_ON() + "_" + argCO.getFLAG_VALUE_OFF())
					.get(BigDecimal.valueOf(0)),
				argValue.equals(valueOn) ? ConstantsCommon.TRUE : ConstantsCommon.FALSE);
		    }
		    else
		    {
			repCO.getArgRefreshLkpMap().put(
				repCO.getArgShowHideMap()
					.get(ConstantsCommon.PARAM_TILDA + argCO.getARGUMENT_NAME() + "~"
						+ argCO.getARGUMENT_TYPE()).get(BigDecimal.valueOf(0)), argValue);
			if(ConstantsCommon.ARG_QRY_LIVESEARCH_WITH_DESC.equals(argCO.getARG_QUERY_OPTIONS()))
			{
			    dynLookupSC = new DynLookupSC();
			    dynLookupSC.setIsSybase(returnCommonLibBO().returnIsSybase());
			    dynLookupSC.setHmQryParam(nameValueMap);
			    dynLookupSC.setQryId(argCO.getQUERY_ID().toPlainString());
			    if(NumberUtil.emptyDecimalToNull(conId) != null)
			    {
				dynLookupSC.setConnId(conId);
			    }
			    emptyValues = new ArrayList<String>();
			    for(Entry<String, String> entryHm : dynLookupSC.getHmQryParam().entrySet())
			    {
				if(entryHm.getValue() == null)
				{
				    emptyValues.add(entryHm.getKey());
				}
			    }
			    for(int j = 0; j < emptyValues.size(); j++)
			    {
				dynLookupSC.getHmQryParam().remove(emptyValues.get(j));
			    }
			    dynLookupSC.setArgId(argCO.getARGUMENT_ID());
			    dynLookupSC.setArgVal(nameValueMap.get(argCO.getARGUMENT_NAME()));
			    dynLookupSC.setReportId(repCO.getREPORT_ID());
			    dynLookupSCMap = new HashMap<String, Object>();
			    propsArr =  ConstantsCommon.returnQryResult_PROPS.toArray(new String[ConstantsCommon.returnQryResult_PROPS.size()]);
			    PathPropertyUtil.copyProperties(dynLookupSC, dynLookupSCMap, false, propsArr);
			    resQry = commonReportingBO.returnQryResult(dynLookupSCMap);
			    repCO.getArgRefreshLkpMap().put("p_desc_" + argCO.getARGUMENT_NAME() + "_" + var_menuId,
				    resQry.get(0).get(argCO.getCOLUMN_DESC()));
			}
		    }
		    argsMap.remove(argFilterVO.getARGUMENT_ID());
		}
		// handling case where user creates a new savable argument that
		// do not have a db record for the current
		// filter.should be emptied.remaining args in argsMap are the
		// arguments that should be emptied
		for(Entry<BigDecimal, IRP_REP_ARGUMENTSCO> entryObj : argsMap.entrySet())
		{
		    argCO = entryObj.getValue();
		    emptyArgsFromFilter(argCO, repCO, var_menuId);
		}
	    }
	    // preventing the save of filter without any savable argument
	    else if(nameObjMap.isEmpty())
	    {
		update = ConstantsCommon.FALSE;
	    }
	    else
	    {
		IRP_REP_FILTERSVO filterVO = new IRP_REP_FILTERSVO();
		if(ConstantsCommon.UPDATE_MODE.equals(update))
		{
		    filterVO.setFILTER_ID(filterId);
		}
		else
		{
		    updates = ConstantsCommon.TRUE;
		}
		filterVO.setFILTER_NAME(filterName);
		filterVO.setPUBLIC_YN(ConstantsCommon.TRUE.equals(publicYn) ? BigDecimal.ONE : BigDecimal.ZERO);
		filterVO.setDEFAULT_YN(ConstantsCommon.TRUE.equals(defaultYn) ? BigDecimal.ONE : BigDecimal.ZERO);
		filterVO.setCREATED_BY(returnSessionObject().getUserName());
		HashMap<String, Object> filtersVOMap = PathPropertyUtil.convertToMap(filterVO);
		HashMap<String, Object> nameObjConvertedMap = new HashMap<String, Object>();
		for(Entry<String, IRP_REP_ARGUMENTSCO> entryObj : nameObjMap.entrySet())
		{
		    HashMap<String, Object> argumentCOMap = PathPropertyUtil.convertToMap(entryObj.getValue());
		    nameObjConvertedMap.put(entryObj.getKey(), argumentCOMap);
		}
		filterId = commonReportingBO.saveFilter(nameValueMap, nameObjConvertedMap, filtersVOMap, update,
			Boolean.parseBoolean(updates));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Method for emptying arguments not related to a specific filter in
     * retrieval screen
     * 
     * @param argCO
     * @param repCO
     * @param var_menuId
     */
    private void emptyArgsFromFilter(IRP_REP_ARGUMENTSCO argCO, IRP_AD_HOC_REPORTCO repCO, String var_menuId)
    {
	try
	{
	    if(BigDecimal.ONE.equals(argCO.getMULTISELECT_YN()))
	    {
		repCO.getArgRefreshLkpMap().put(
			ConstantsCommon.P_PARAM_UNDERSCORE + argCO.getARGUMENT_NAME() + "_" + argCO.getARGUMENT_TYPE()
				+ "_" + var_menuId, "");
		repCO.getArgRefreshLkpMap().put(
			repCO.getArgShowHideMap().get(argCO.getARGUMENT_NAME() + "~" + argCO.getARGUMENT_TYPE())
				.get(BigDecimal.valueOf(0)), "");
	    }
	    else if(argCO.getARGUMENT_SOURCE().equals(new BigDecimal(4)))
	    {
		repCO.getArgRefreshLkpMap().put(
			repCO.getArgShowHideMap()
				.get("__checkbox_paramsFlag." + argCO.getARGUMENT_NAME() + "_"
					+ argCO.getFLAG_VALUE_ON() + "_" + argCO.getFLAG_VALUE_OFF())
				.get(BigDecimal.valueOf(0)), ConstantsCommon.FALSE);
	    }
	    else
	    {
		repCO.getArgRefreshLkpMap().put(
			repCO.getArgShowHideMap()
				.get(ConstantsCommon.PARAM_TILDA + argCO.getARGUMENT_NAME() + "~"
					+ argCO.getARGUMENT_TYPE()).get(BigDecimal.valueOf(0)), "");
		if(ConstantsCommon.ARG_QRY_LIVESEARCH_WITH_DESC.equals(argCO.getARG_QUERY_OPTIONS()))
		{
		    repCO.getArgRefreshLkpMap().put("p_desc_" + argCO.getARGUMENT_NAME() + "_" + var_menuId, "");
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
    }
 
    
    /**
     * method used to delete a filter
     * @return
     */
    public String deleteFilter()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    if(sessionCO.getUserName().equals(update))
	    {
		commonReportingBO.deleteFilterById(filterId);
	    }
	    else
	    {
		update = ConstantsCommon.ERROR_MSG_TYPE.toString();
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Method for loading filter details
     * @return
     */
    public String retFilterById()
    {
	try
	{
	    IRP_REP_FILTERSSC filtersSC = new IRP_REP_FILTERSSC();
	    SessionCO sessionCO = returnSessionObject();
	    if(var_menuId==null)
	    {
		var_menuId = get_pageRef();
	    }
	    CommonReportingSessionCO repSessionCO = returnReportingSessionObject(var_menuId);
	    String userName = sessionCO.getUserName();
	    filtersSC.setCREATED_BY(userName);
	    filtersSC.setFILTER_ID(filterId);
	    filtersSC.setREPORT_ID(repSessionCO.getReportCO().getREPORT_ID());
	    filtersSC.setWhereQuery(ConstantsCommon.FILTER_ID_COL + "=" + filterId);
	    filtersSC.setGrid(false);
	    HashMap<String, Object> filtersSCMap=PathPropertyUtil.convertToMap(filtersSC);
	    List<HashMap<String, Object>> filterslistMap = commonReportingBO.retFiltersList(filtersSCMap);
	    String[] propsArr = ConstantsCommon.retFiltersListMap_PROPS.toArray(new String[ConstantsCommon.retFiltersListMap_PROPS.size()]);
	    HashMap<String, Object> retMap = new HashMap<String, Object>();
	    if(!filterslistMap.isEmpty())
	    {
		retMap = filterslistMap.get(0);
	    }
	    irpRepFilterVO = new IRP_REP_FILTERSVO();
	    PathPropertyUtil.copyProperties(retMap, irpRepFilterVO, false, propsArr);
	    updates = ConstantsCommon.FALSE;
	    if(userName.equals(irpRepFilterVO.getCREATED_BY()))
	    {
		updates = ConstantsCommon.TRUE;
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
 
    public void setFeiParameters(Map feiParameters)
    {
	this.feiParameters = feiParameters;
    }

    public Map getFeiParameters()
    {
	return feiParameters;
    }

    public void setFei_p(String fei_p)
    {
	this.fei_p = fei_p;
    }

    public String getFei_p()
    {
	return fei_p;
    }

    /**
     * Method for checking the existence of a snapshot parameter in case of txt file format
     * @return
     */
    public String checkSnapshotExist() throws Exception
    {
    	try
    	{
    		SessionCO sessionCO = returnSessionObject();
    		CommonReportingSessionCO repSessionCO = returnReportingSessionObject(get_pageRef());

			// FCR_MAIN_REP
			IRP_AD_HOC_REPORTCO repCO = repSessionCO.getReportCO();
			IRP_AD_HOC_REPORTSC repSC = new IRP_AD_HOC_REPORTSC();
			if (ConstantsCommon.FCR_MAIN_REPORT_REF.equals(repCO.getPROG_REF()))
			{
				repSC.setPROG_REF(repCO.getFTR_OPT_PROG_REF());
			}
			else
			{
				repSC.setPROG_REF(repSessionCO.getReportCO().getPROG_REF());
			}
    	    HashMap<String, Object> repSCMap=PathPropertyUtil.convertToMap(repSC);
    	    int filterslistMap = commonReportingBO.checkTextFormulaExist(repSCMap);
    	  
    	    updates=ConstantsCommon.FALSE;
    	    if(filterslistMap == 0)
    		{
    			updates = ConstantsCommon.TRUE;
    		}
    	}
    	catch(Exception e)
    	{
    	    handleException(e, null, null);
    	}
    	return SUCCESS;
    }
    
    /**
     * Method that will return the report details based on the progRef and application name
     * @return
     */
    public String retReportDetailsByRefOrId()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    String appName = (a == null ? sessionCO.getCurrentAppName() : a);
	    IRP_AD_HOC_REPORTVOWithBLOBs vo =new IRP_AD_HOC_REPORTVOWithBLOBs();
	    vo.setAPP_NAME(appName);
	    vo.setPROG_REF(StringUtil.nullToEmpty(r_r));
	    BigDecimal repId= (StringUtil.nullToEmpty(r_i).isEmpty())?new BigDecimal(-1):new BigDecimal(r_i);
	    //if old report id is sent
	    if(("1").equals(pb_r))
	    {
			try
			{
			    repId = commonReportingBO.retRepIdFromOldRepId(repId);
			}
			catch(Exception e)
			{
			    throw new BaseException("Error when retrieving report id from old id: " + r_i + "\n "
				    + e.getMessage(), e);
			}
	    }
	    vo.setREPORT_ID(repId);
	    HashMap<String,Object>map=PathPropertyUtil.convertToMap(vo);
	    map=commonReportingBO.returnReportDetailsByRef(map);
	    vo=(IRP_AD_HOC_REPORTVOWithBLOBs) PathPropertyUtil.convertToObject(map, IRP_AD_HOC_REPORTVOWithBLOBs.class);
	    if(vo.getPROG_REF()==null)
	    {
		throw new BOException(getText("loadReport.repDetails.exceptionMsg._key"));
	    }
	    var_format=StringUtil.nullToEmpty(vo.getDEFAULT_FORMAT());
	    if(!repId.equals(new BigDecimal(-1)))
	    {
        	    a=StringUtil.nullToEmpty(vo.getAPP_NAME());
        	    r_r=StringUtil.nullToEmpty(vo.getPROG_REF());
	    }
	    return SUCCESS;
	}
	catch(Exception e)
	{
	    handleException(e,null ,null);
	    return ERROR;
	}
    }
    
    /**
     * Common method to fill a map with argument name and argument value after
     * serializing the form in js
     * 
     * @return
     */
    private HashMap<String, String> fillNameValueMap()
    {
	Enumeration enu = request.getParameterNames();
	String itemName = "";
	String itemValue = "";
	HashMap<String, String> paramNameValMap = new HashMap<String, String>();
	while(enu.hasMoreElements())
	{
	    itemName = (String) enu.nextElement();
	    itemValue = request.getParameter(itemName);
	    paramNameValMap.put(itemName, itemValue);
	}

	String argName;
	// contains true argument name (as in CO) and its value
	HashMap<String, String> nameValueMap = new HashMap<String,String>();
	CommonReportingSessionCO repSessCO = returnReportingSessionObject(var_menuId);
	IRP_AD_HOC_REPORTCO repCO = repSessCO.getReportCO();
	List<IRP_REP_ARGUMENTSCO> argumentsList = new ArrayList(repCO.getArgumentsList().values());
	for(IRP_REP_ARGUMENTSCO argObj : argumentsList)
	{
	    argName = argObj.getARGUMENT_NAME();
	    if(argObj.getARGUMENT_SOURCE().equals(new BigDecimal(4)))// flag
	    {
		itemName = "__checkbox_paramsFlag." + argName + "_" + argObj.getFLAG_VALUE_ON() + "_"
			+ argObj.getFLAG_VALUE_OFF();
		itemValue = paramNameValMap.get(itemName);
	    }
	    else
	    {
		itemName = "param~" + argName + "~" + argObj.getARGUMENT_TYPE();
		itemValue = paramNameValMap.get(itemName);
	    }
	    if(itemValue != null)
	    {
		nameValueMap.put(argName, itemValue);
	    }
	}
	return nameValueMap;
    }

    /**
     * Method for inserting audit print of a report
     * @return
     */
    public String checkAuditPrintReport()
    {
	try
	{
	    PTH_CTRL1VO pthCtrl1VO =returnCommonLibBO().returnPthCtrl1();
	    //1=> audit enabled when printing
	    if("1".equals(pthCtrl1VO.getPRINT_REPORT_AUDIT_YN()))
	    {
		SessionCO sessionCO = returnSessionObject();
		CommonReportingSessionCO repSessCO = returnReportingSessionObject(var_menuId);
		IRP_AD_HOC_REPORTCO repCO = repSessCO.getReportCO();
		HashMap<String, String> nameValueMap = fillNameValueMap();
		nameValueMap.put(ConstantsCommon.REPORT_FORMAT_STR, ConstantsCommon.HTML_REP_FORMAT);
		nameValueMap.put(getText("language_key"),sessionCO.getLanguage());
		if(NumberUtil.emptyDecimalToNull(conId) != null)
		{
		    nameValueMap.put(ConstantsCommon.REP_CONN_ID, commonReportingBO.retConnectionDescById(conId));
		}
		nameValueMap.put(ConstantsCommon.REPORT_RETRIEVAL_APP_NAME, sessionCO.getCurrentAppName());
		if(var_menuId != null && var_menuId.endsWith(ConstantsCommon.OPT_FCR_EXTENSION))
		{
		    applyReportAudit(nameValueMap, AuditConstant.REPORT_PRINT, var_menuId);
		}
		else
		{
		    applyReportAudit(nameValueMap, AuditConstant.REPORT_PRINT, repCO.getPROG_REF(),
			    repCO.getAPP_NAME());
		}
	    }
	    updates=pthCtrl1VO.getREP_PRINT_PDF_YN();
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Pagination Previous/Next
     * @return
     */
    public String paginationPreviousNext()
    {
    	try
    	{
    	    SessionCO sessionCO = returnSessionObject();
    	    reportOutputCO = new ReportOutputCO();
    	    IRP_AD_HOC_REPORTSC paginationSC = new IRP_AD_HOC_REPORTSC();
    	    paginationSC.setCurrentPage(currentPage);
    	    paginationSC.setUSER_ID(sessionCO.getUserName());
    	    paginationSC.setAPP_NAME(sessionCO.getCurrentAppName());
    	    paginationSC.setPROG_REF(get_pageRef().replace("-", "_"));
    	    HashMap<String,Object>map=PathPropertyUtil.convertToMap(paginationSC);
    	    map=commonReportingBO.returnReportByteArrayCurrentPage(map);
    	    paginationSC = (IRP_AD_HOC_REPORTSC) PathPropertyUtil.convertToObject(map,IRP_AD_HOC_REPORTSC.class);
    	    if(paginationSC.getRepPaginationBytes() != null)
    	    {
    	    	reportOutputCO.setOutputHtml(new String(paginationSC.getRepPaginationBytes(), "UTF-8"));
    	    }
    		return SUCCESS;
    	}
    	catch(Exception e)
    	{
    		handleException(e,null ,null);
    		return ERROR;
    	}
    }

	public String getS_s() {
		return s_s;
	}

	public void setS_s(String s_s) {
		this.s_s = s_s;
	}

	public String getS_i() {
		return s_i;
	}

	public void setS_i(String s_i) {
		this.s_i = s_i;
	}

	public Date getE_d() {
		return e_d;
	}

	public void setE_d(Date e_d) {
		this.e_d = e_d;
	}
}
