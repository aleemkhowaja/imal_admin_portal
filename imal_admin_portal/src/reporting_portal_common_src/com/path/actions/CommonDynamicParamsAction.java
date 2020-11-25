package com.path.actions;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.struts2.ServletActionContext;

import com.path.actions.ReportAction.SepartorFormat;
import com.path.actions.admin.dynamicparams.DynamicParamsAction;
import com.path.bo.common.CommonLibBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.reporting.CommonReportingBO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.BRANCHESVOKey;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.CURRENCIESVOKey;
import com.path.dbmaps.vo.IRP_CONNECTIONSVO;
import com.path.dbmaps.vo.IRP_REP_ARGUMENTSVO;
import com.path.dbmaps.vo.IRP_REP_ARGUMENTS_FILTERSVO;
import com.path.dbmaps.vo.SYS_PARAM_LOV_TRANSVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.reporting.exception.ReportException;
import com.path.vo.admin.dynamicparams.DynamicParamsVO;
import com.path.vo.admin.dynamicparams.ListParamVO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.reporting.CommonReportingSessionCO;
import com.path.vo.reporting.DynLookupSC;
import com.path.vo.reporting.IRP_AD_HOC_QUERYCO;
import com.path.vo.reporting.IRP_AD_HOC_REPORTCO;
import com.path.vo.reporting.IRP_AD_HOC_REPORTSC;
import com.path.vo.reporting.IRP_FIELDSCO;
import com.path.vo.reporting.IRP_QUERY_ARG_MAPPINGCO;
import com.path.vo.reporting.IRP_REP_ARGUMENTSCO;
import com.path.vo.reporting.IRP_REP_ARG_CONSTRAINTSCO;
import com.path.vo.reporting.IRP_REP_FILTERSSC;
import com.path.vo.reporting.SQL_OBJECT;

/**
 * 
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: annasuccar
 *
 * CommonDynamicParamsAction.java used as common for all iMAL projects 
 * therefore the content should not be application specific.
 */
public class CommonDynamicParamsAction extends DynamicParamsAction
{
    /**
     * Report Id
     */
    private BigDecimal r_i;
    /**
     * Report Reference
     */
    private String r_r;
    /**
     * Report db connection
     */
    private BigDecimal r_c;
    /**
     * Report additional parameters
     */
    private String r_a_p;
    /**
     * page reference (- replaced by _)
     */
    private String a;
    
    public String getA()
    {
        return a;
    }
    public void setA(String a)
    {
        this.a = a;
    }

    private String htmlPageRef;
    
    private ArrayList<DynamicParamsVO> formLst;
    private List<SYS_PARAM_LOV_TRANSVO> formatList;
    private List langList;
    private List chkSaveList;
    private List chkFlagList;
    HashMap paramsFlag = new HashMap();
    
    private CommonReportingBO commonReportingBO;
    IRP_AD_HOC_REPORTCO reportCO;
    private String updates;
    private CommonLibBO commonLibBO;

	public void setCommonLibBO(CommonLibBO commonLibBO) {
		this.commonLibBO = commonLibBO;
	}

    String l;
    private String var_format;
    private List csvSeparatorsList;
    private String var_separator;
    private List chkNoHeadAndFootLst;
    HashMap noHeadFootMap = new HashMap();
    private List<IRP_CONNECTIONSVO> connectionList;
    private BigDecimal var_db;
    private  HashMap<String, ArrayList<LinkedHashMap>> combosLists = new HashMap<String, ArrayList<LinkedHashMap>>();

    public void setCombosLists(HashMap<String, ArrayList<LinkedHashMap>> combosLists)
    {
        this.combosLists = combosLists;
    }

    public HashMap<String, ArrayList<LinkedHashMap>> getCombosLists()
    {
        return combosLists;
    }

    
    
    
    
    


    public BigDecimal getVar_db()
    {
        return var_db;
    }
    public void setVar_db(BigDecimal varDb)
    {
        var_db = varDb;
    }
    public List<IRP_CONNECTIONSVO> getConnectionList()
    {
        return connectionList;
    }
    public void setConnectionList(List<IRP_CONNECTIONSVO> connectionList)
    {
        this.connectionList = connectionList;
    }
    public HashMap getNoHeadFootMap()
    {
        return noHeadFootMap;
    }
    public void setNoHeadFootMap(HashMap noHeadFootMap)
    {
        this.noHeadFootMap = noHeadFootMap;
    }
    public List getChkNoHeadAndFootLst()
    {
        return chkNoHeadAndFootLst;
    }
    public void setChkNoHeadAndFootLst(List chkNoHeadAndFootLst)
    {
        this.chkNoHeadAndFootLst = chkNoHeadAndFootLst;
    }
    public String getVar_separator()
    {
        return var_separator;
    }
    public void setVar_separator(String varSeparator)
    {
        var_separator = varSeparator;
    }
    public List getCsvSeparatorsList()
    {
        return csvSeparatorsList;
    }
    public void setCsvSeparatorsList(List csvSeparatorsList)
    {
        this.csvSeparatorsList = csvSeparatorsList;
    }
    public String getVar_format()
    {
        return var_format;
    }
    public void setVar_format(String varFormat)
    {
        var_format = varFormat;
    }
    public String getL() {
		return l;
	}
	public void setL(String l) {
		this.l = l;
	}
	public BigDecimal getR_i()
    {
        return r_i;
    }
    public void setR_i(BigDecimal rI)
    {
        r_i = rI;
    }
    public String getR_r()
    {
        return r_r;
    }
    public void setR_r(String rR)
    {
        r_r = rR;
    }
    public BigDecimal getR_c()
    {
        return r_c;
    }
    public void setR_c(BigDecimal rC)
    {
        r_c = rC;
    }
    public String getR_a_p()
    {
        return r_a_p;
    }
    public void setR_a_p(String rAP)
    {
        r_a_p = rAP;
    }
    public String getHtmlPageRef()
    {
        return htmlPageRef;
    }
    public void setHtmlPageRef(String htmlPageRef)
    {
        this.htmlPageRef = htmlPageRef;
    }
    public ArrayList<DynamicParamsVO> getFormLst()
    {
        return formLst;
    }
    public void setFormLst(ArrayList<DynamicParamsVO> formLst)
    {
        this.formLst = formLst;
    }

    /**
     * @return the formatList
     */
    public List<SYS_PARAM_LOV_TRANSVO> getFormatList()
    {
        return formatList;
    }
    /**
     * @param formatList the formatList to set
     */
    public void setFormatList(List<SYS_PARAM_LOV_TRANSVO> formatList)
    {
        this.formatList = formatList;
    }
    public List getLangList()
    {
        return langList;
    }
    public void setLangList(List langList)
    {
        this.langList = langList;
    }
    public List getChkSaveList()
    {
        return chkSaveList;
    }
    public void setChkSaveList(List chkSaveList)
    {
        this.chkSaveList = chkSaveList;
    }
    public List getChkFlagList()
    {
        return chkFlagList;
    }
    public void setChkFlagList(List chkFlagList)
    {
        this.chkFlagList = chkFlagList;
    }
    
    public HashMap getParamsFlag()
    {
        return paramsFlag;
    }
    public void setCommonReportingBO(CommonReportingBO commonReportingBO)
    {
        this.commonReportingBO = commonReportingBO;
    }
    
    public String getUpdates()
    {
        return updates;
    }
    
    public void setUpdates(String updates)
    {
        this.updates = updates;
    }
    
    public CommonReportingSessionCO returnReportingSessionObject(String pageRef)
    {
	SessionCO sessionCO= (SessionCO)session.get(ConstantsCommon.SESSION_VO_ATTR);
	HashMap<String, CommonReportingSessionCO> sessionMap=(HashMap<String, CommonReportingSessionCO>)sessionCO.getReportingAppDet();
	if(sessionMap==null)
	{
	    sessionCO.setReportingAppDet(new HashMap<String, CommonReportingSessionCO>());
	}
	sessionMap=(HashMap<String, CommonReportingSessionCO>)sessionCO.getReportingAppDet();
	if(sessionMap.get(pageRef)==null)
	{
	    sessionMap.put(pageRef, new CommonReportingSessionCO());
	}
	return sessionMap.get(pageRef);
    }
    
    public void loadReport()throws Exception
    {
	IRP_FIELDSCO irpFieldCO;
	ArrayList<IRP_FIELDSCO> lst=new ArrayList<IRP_FIELDSCO>();
    	    //if the report prog ref is sent then retrieve the report id based on the prog ref
    	    //even if the report id is sent in the url
	//annasuccar 9/5/2014: if report previewd from designer, return the report from the session
	if( "RD00R".equals(r_r) )
	{
	    reportCO = returnReportingSessionObject(r_r).getReportCO();
	}
	else {
    	    if(!StringUtil.nullToEmpty(r_r).isEmpty() )
    	    {
    		SessionCO sessionCO = returnSessionObject();
    		String appName=(a == null ? sessionCO.getCurrentAppName():  a);
    		IRP_AD_HOC_REPORTSC reportSC = new IRP_AD_HOC_REPORTSC();
    		reportSC.setPROG_REF(r_r);
    		reportSC.setAPP_NAME(appName);    		
    		HashMap<String,Object> repSCMap=new HashMap<String,Object>();
    		String[] propsArr= ConstantsCommon.retRepIdByProgRef_PROPS.toArray(new String[ConstantsCommon.retRepIdByProgRef_PROPS.size()]);
    		PathPropertyUtil.copyProperties(reportSC, repSCMap,false,propsArr);
    		HashMap<String,Object> retHm = commonReportingBO.retRepIdByProgRef(repSCMap);
    		reportCO =(IRP_AD_HOC_REPORTCO) PathPropertyUtil.convertToObject(retHm, IRP_AD_HOC_REPORTCO.class);
    		
    		if(NumberUtil.isEmptyDecimal(reportCO.getREPORT_ID()))
    		{
    		    throw new Exception(getText("loadReport.exceptionMsg._key") + "\n report reference: "+r_r+" and report application: "+appName);
    		}
    		else {
    		    r_i = reportCO.getREPORT_ID();
    		}
    	    }  
    	    
    	    //to add later a call to a method to retrieve the new report id before querying the report
    	    //not needed currently since only the report reference is sent
    	    if(!StringUtil.nullToEmpty(r_i).isEmpty())
    	    {
    		HashMap<String,Object> retMap = commonReportingBO.returnReportById(r_i);
    		reportCO=(IRP_AD_HOC_REPORTCO) PathPropertyUtil.convertToObject(retMap, IRP_AD_HOC_REPORTCO.class);
    	    }
    	    
    	    if(reportCO == null || NumberUtil.isEmptyDecimal(reportCO.getREPORT_ID()))
	    {
		throw new Exception(getText("loadReport.exceptionMsg._key") + "\n report id: "+r_i);
	    }
//    	    //fill the CommonRepSessionCO with the reportCO
	    CommonReportingSessionCO repSessionCO = returnReportingSessionObject(r_r);
	    SessionCO sessionCO = returnSessionObject();
	    /* start fares */
	    IRP_FIELDSCO feCO;
	    Boolean addedToSortedList;
	    // check if sorting exist in IRP_REP_SORT table
	    HashMap<String, Object> lstSortingMap = new HashMap<String, Object>();
	    lstSortingMap.put("reportId", reportCO.getREPORT_ID());
	    lstSortingMap.put("userId", sessionCO.getUserName());
	    lstSortingMap = commonReportingBO.retSortingListFromIrpRepSort(lstSortingMap);

	    // fill the prevOrder list by looping through all the sorting field
	    SQL_OBJECT sqlObj = reportCO.getQueriesList().get(0).getSqlObject();
	    LinkedHashMap<Long, IRP_FIELDSCO> feMap = sqlObj.getFields();
	    Iterator it = feMap.values().iterator();
	    iter1: while(it.hasNext())
	    {
		addedToSortedList = false;
		feCO = (IRP_FIELDSCO) it.next();
		ArrayList<HashMap<String, Object>> SortingMapList = (ArrayList<HashMap<String, Object>>) lstSortingMap.get("irpFieldsCOList");
		if(SortingMapList != null && !SortingMapList.isEmpty())
		{
		    HashMap<String, Object> SortMap;
		    Iterator<HashMap<String, Object>> itSort = SortingMapList.iterator();
		    iter2: while(itSort.hasNext())
		    {
			SortMap = itSort.next();
			irpFieldCO = (IRP_FIELDSCO) PathPropertyUtil.convertToObject(SortMap, IRP_FIELDSCO.class);
			if(feCO.getFIELD_ALIAS().equals(irpFieldCO.getFIELD_ALIAS()))
			{
			    irpFieldCO.setIndex(feCO.getIndex());
			    irpFieldCO.setFIELD_DB_NAME(feCO.getFIELD_DB_NAME());
			    irpFieldCO.setEntityAliasWithCount(feCO.getEntityAliasWithCount());
			    irpFieldCO.setENTITY_ALIAS(feCO.getENTITY_ALIAS());
			    irpFieldCO.setLabelAlias(feCO.getLabelAlias());
			    lst.add(irpFieldCO);
			    addedToSortedList = true;
			    break iter2;
			}
		    }
		}
		if(addedToSortedList)
		{
		    continue iter1;
		}
		// in case not all the fields exist in IRP_REP_SORT Table
		irpFieldCO = new IRP_FIELDSCO();
		irpFieldCO.setIndex(feCO.getIndex());
		irpFieldCO.setFIELD_DB_NAME(feCO.getFIELD_DB_NAME());
		irpFieldCO.setEntityAliasWithCount(feCO.getEntityAliasWithCount());
		irpFieldCO.setENTITY_ALIAS(feCO.getENTITY_ALIAS());
		irpFieldCO.setLabelAlias(feCO.getLabelAlias());
		irpFieldCO.setFIELD_ALIAS(feCO.getFIELD_ALIAS());
		irpFieldCO.setOrder(null);
		lst.add(irpFieldCO);
	    }
	    reportCO.setPrevOrderList(lst);
	    /* end fares */
    	    repSessionCO.setReportCO(reportCO);
	}
	
    	  //translate the field_alias
    		SessionCO sessionCO = returnSessionObject();
    		CommonLibSC sc= new CommonLibSC();
			sc.setAppName(reportCO.getAPP_NAME());
			sc.setProgRef(reportCO.getPROG_REF());
			sc.setLanguage(sessionCO.getLanguage());
			
    		SQL_OBJECT sqlObj=reportCO.getQueriesList().get(0).getSqlObject();
    		IRP_FIELDSCO feCO;
			Iterator it=sqlObj.getFields().values().iterator();
			String feTrans;
			while(it.hasNext())
			{
				feCO=(IRP_FIELDSCO)it.next();
				sc.setKeyLabelCode(feCO.getFIELD_ALIAS());
				feTrans=commonLibBO.returnKeyLabelTrans(sc);
				feCO.setFIELD_ALIAS(feTrans);
				feCO.setFeName(feTrans);
			}
			
//			String hasVerifyAccess=returnAccessRightByProgRef(ConstantsCommon.OPT_VERIFY_BTN);
//			if(hasVerifyAccess ==null)
//			{
//			    showHideBtn("0","verifyBtn_");
//			}
//			else
//			{
//			    showHideBtn("1","verifyBtn_");
//			}
    		
    }
    
//    public void showHideBtn(String visibleVal,String elemId)
//	{
//	    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> button = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
//	    try
//	    {
//		button = returnCommonLibBO().applyDynScreenDisplay(elemId+get_pageRef(),null,
//		    ConstantsCommon.ACTION_TYPE_VISIBLE, visibleVal, button, null);
//		getAdditionalScreenParams().putAll(button);
//	    }
//	    catch(BaseException e)
//	    {
//		e.printStackTrace();
//	    }
//	}
    
    public String loadDynParam() 
    {
	try
	{
        	loadReport();
        	fillFormElement();
	}
	catch(BaseException e)
	{
	    handleException(e, null,"loadReport.repDetails.exceptionMsg._key");
	    log.error(">>>>>>>>>>> Error retrieving the report having the reference =="+r_r);
	    return "repnotfound";
	}
	catch(Exception e)
    	{
    	    handleException(e, null,"loadReport.repDetails.exceptionMsg._key");
    	    log.error(">>>>>>>>>>> Error retrieving the report having the reference =="+r_r);
    	    return "repnotfound";
    	}
	return "SUCCESS_DYNAMIC_PARAM";
    }
    
	public ArrayList<LinkedHashMap> retQryDfltVal(IRP_AD_HOC_REPORTCO repCO,IRP_REP_ARGUMENTSVO argObj) throws BaseException
	{
	    
		LinkedHashMap argsMap = repCO.getArgumentsList();
		ArrayList<IRP_REP_ARGUMENTSCO> argsList = new ArrayList(argsMap.values());
		String val ="";
		IRP_AD_HOC_REPORTSC reportSC = new IRP_AD_HOC_REPORTSC();
		Object argSessionValue;
		SessionCO sessionCO = returnSessionObject();
		String sessionParamName;
		List<IRP_QUERY_ARG_MAPPINGCO> listDfltSrc;
		for (int i = 0; i < argsList.size(); i++) {
		    
		    if(!NumberUtil.isEmptyDecimal(argsList.get(i).getQUERY_ID_DEFAULT()) && argsList.get(i).getARGUMENT_NAME().equals(argObj.getARGUMENT_NAME()))
		    {
			
			DynLookupSC dynLookupSC = new DynLookupSC();
			HashMap<String, String> hmQryParam = new HashMap<String, String>();
			
			reportSC.setREPORT_ID(repCO.getREPORT_ID());
			reportSC.setReportArgumentId(argsList.get(i).getARGUMENT_ID());
			reportSC.setDefaultSrc(new BigDecimal(2));
			listDfltSrc=fillQryArgsMapList(reportSC);
			
			
			try {
				HashMap<String,Object> retMap= commonReportingBO.returnQueryById(argsList.get(i).getQUERY_ID_DEFAULT(), true);
				IRP_AD_HOC_QUERYCO query =(IRP_AD_HOC_QUERYCO) PathPropertyUtil.convertToObject(retMap, IRP_AD_HOC_QUERYCO.class);
				for (int j = 0; j < query.getSqlObject().getArgumentsList().size(); j++) {
				   	LinkedHashMap<Long, IRP_REP_ARGUMENTSCO>arguments = query.getSqlObject().getArgumentsList();
				   	ArrayList<IRP_REP_ARGUMENTSCO> argsQryList = new ArrayList(arguments.values());

					for (int m = 0; m < listDfltSrc.size(); m++) {
						for (int n = 0; n < listDfltSrc.size(); n++) {
							if (listDfltSrc.get(m).getIrpQueryArgsMappingVO().getQUERY_ARG_NAME().equals(argsQryList.get(n).getARGUMENT_NAME())) {
							    listDfltSrc.get(m).setARGUMENT_TYPE(argsQryList.get(n).getARGUMENT_TYPE());
							    if(listDfltSrc.get(m).getIrpQueryArgsMappingVO().getSTATIC_VALUE() == null|| ("").equals(listDfltSrc.get(m).getIrpQueryArgsMappingVO().getSTATIC_VALUE())) 
							    {
								for (int a = 0; a < argsList.size(); a++) 
								{
								   if(listDfltSrc.get(m).getIrpQueryArgsMappingVO().getREPORT_MAPPED_ARG_NAME().equals(argsList.get(a).getARGUMENT_NAME()))
								   {
								       
								       if(argsList.get(a).getARGUMENT_SOURCE().equals(ConstantsCommon.SESSION_ARG_SOURCE)
									       || argsList.get(a).getARGUMENT_SOURCE().equals(ConstantsCommon.TRANS_SESSION_ARG_SOURCE))
								       {
									   sessionParamName=argsList.get(a).getSESSION_ATTR_NAME();
									    if(ConstantsCommon.LANGUAGE_ARABIC.equals(sessionCO.getLanguage())
										    && ConstantsCommon.COMP_NAME_EXP_VAR.equals(sessionParamName) )
									    {
										sessionParamName=ConstantsCommon.COMP_AR_NAME_SESSION;
									    }
									    argSessionValue = PathPropertyUtil.returnProperty(sessionCO,sessionParamName);
									    hmQryParam.put(listDfltSrc.get(m).getIrpQueryArgsMappingVO().getQUERY_ARG_NAME(), argSessionValue.toString());
									}
								       else if(argsList.get(a).getARGUMENT_SOURCE().equals(new BigDecimal(5)))
								       {
									   hmQryParam.put(listDfltSrc.get(m).getIrpQueryArgsMappingVO().getQUERY_ARG_NAME(), r_r);
								       }
								       else
								       {
									    hmQryParam.put(listDfltSrc.get(m).getIrpQueryArgsMappingVO().getQUERY_ARG_NAME(), argsList.get(a).getARGUMENT_VALUE());
								       }
								       
								   }
								}
							    }
							    else
							    {
								hmQryParam.put(listDfltSrc.get(m).getIrpQueryArgsMappingVO().getQUERY_ARG_NAME(), listDfltSrc.get(m).getIrpQueryArgsMappingVO().getSTATIC_VALUE());
							    }
							}
						}
					}

				}
				query.getSqlSyntax();

			} catch (ClassNotFoundException e) {
			    	log.error(e,"error in retQryDfltVal method on report having id: "+repCO.getREPORT_ID() +", reference: "+repCO.getPROG_REF() + " and application: "+repCO.getAPP_NAME());
			} catch (IOException e) {
			    	log.error(e,"error in retQryDfltVal method on report having id: "+repCO.getREPORT_ID() +", reference: "+repCO.getPROG_REF() + " and application: "+repCO.getAPP_NAME());
			}
			catch(ReportException e)
			{
			    log.error(e,"error in retQryDfltVal method on report having id: "+repCO.getREPORT_ID() +", reference: "+repCO.getPROG_REF() + " and application: "+repCO.getAPP_NAME());
			}

			dynLookupSC.setIsSybase(commonLibBO.returnIsSybase());
			dynLookupSC.setQryId(argsList.get(i).getQUERY_ID_DEFAULT().toString());//100405 -- 100182
			dynLookupSC.setConnId(repCO.getCONN_ID());
			dynLookupSC.setHmQryParam(hmQryParam);
			dynLookupSC.setNbRec(1);
			dynLookupSC.setRecToskip(0);
			dynLookupSC.setCompCode(sessionCO.getCompanyCode());
		    dynLookupSC.setBranchCode(sessionCO.getBranchCode());
		    dynLookupSC.setUserId(sessionCO.getUserName());
		    dynLookupSC.setCurrAppName(sessionCO.getCurrentAppName());
			 try
			{
			    HashMap<String,Object> dynLookupSCMap=new HashMap<String,Object>();
			    String[] propsArr= ConstantsCommon.returnQryResult_PROPS.toArray(new String[ConstantsCommon.returnQryResult_PROPS.size()]);
			    PathPropertyUtil.copyProperties(dynLookupSC, dynLookupSCMap,false,propsArr);
			    ArrayList<LinkedHashMap> dfltValqry = commonReportingBO.returnQryResult(dynLookupSCMap);
				   
			    return dfltValqry;
			}
			catch(ClassNotFoundException e)
			{
			    log.error(e,"error in retQryDfltVal method in CommonDynamicParamsAction class on report having id: "+repCO.getREPORT_ID() +", reference: "+repCO.getPROG_REF() + " and application: "+repCO.getAPP_NAME());
			}
			catch(IOException e)
			{
			    log.error(e,"error in retQryDfltVal method in CommonDynamicParamsAction class on report having id: "+repCO.getREPORT_ID() +", reference: "+repCO.getPROG_REF() + " and application: "+repCO.getAPP_NAME());
			}
			catch(SQLException e)
			{
			    log.error(e,"error in retQryDfltVal method in CommonDynamicParamsAction class on report having id: "+repCO.getREPORT_ID() +", reference: "+repCO.getPROG_REF() + " and application: "+repCO.getAPP_NAME());
			}
			catch(Exception e)
			{
			    log.error(e,"error in retQryDfltVal method in CommonDynamicParamsAction class on report having id: "+repCO.getREPORT_ID() +", reference: "+repCO.getPROG_REF() + " and application: "+repCO.getAPP_NAME());
			}

		    }
		}
	    return null;
	}
	
    private List<IRP_QUERY_ARG_MAPPINGCO> fillQryArgsMapList(IRP_AD_HOC_REPORTSC reportSC)
    {
	ArrayList<IRP_QUERY_ARG_MAPPINGCO> listDfltSrc = new ArrayList<IRP_QUERY_ARG_MAPPINGCO>();
	try
	{
	    HashMap<String, Object> hm;
	    IRP_QUERY_ARG_MAPPINGCO argMapCO;
	    List<HashMap<String, Object>> retLst;
	    HashMap<String, Object> repSCMap = new HashMap<String, Object>();
	    String[] propsArr= ConstantsCommon.retQryArgMapping_PROPS.toArray(new String[ConstantsCommon.retQryArgMapping_PROPS.size()]);
	    PathPropertyUtil.copyProperties(reportSC, repSCMap, false, propsArr);
	    retLst = commonReportingBO.retQryArgMapping(repSCMap);
	    listDfltSrc = new ArrayList<IRP_QUERY_ARG_MAPPINGCO>();
	    propsArr= ConstantsCommon.retQryArgMappingRet_PROPS.toArray(new String[ConstantsCommon.retQryArgMappingRet_PROPS.size()]);
	    for(int j = 0; j < retLst.size(); j++)
	    {
		hm = retLst.get(j);
		argMapCO = new IRP_QUERY_ARG_MAPPINGCO();
		PathPropertyUtil.copyProperties(hm, argMapCO, false, propsArr);
		listDfltSrc.add(argMapCO);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return listDfltSrc;
    }
    /**
     * Method that fills additionnal properties for paramVO
     * 
     * @param argType
     * @param paramVO
     * @param constrCO
     * @return
     */
    public DynamicParamsVO fillAdditionalProps(String argType, DynamicParamsVO paramVO,
	    IRP_REP_ARG_CONSTRAINTSCO constrCO, HashMap<String, HashMap<Integer, Object>> argFunctionMap, String argName)
    {
	DynamicParamsVO lParamVO = paramVO;
	if(ConstantsCommon.PARAM_TYPE_NUMBER.equals(argType))
	{
	    if(!StringUtil.nullToEmpty(constrCO.getMAX_LENGTH()).isEmpty())
	    {
		lParamVO.setMaxLength(Integer.valueOf(constrCO.getMAX_LENGTH()));
	    }
	    if(!StringUtil.nullToEmpty(constrCO.getMAX_VAL()).isEmpty())
	    {
		lParamVO.setMaxValue(new BigDecimal(constrCO.getMAX_VAL()));
	    }
	    if(!StringUtil.nullToEmpty(constrCO.getMIN_VAL()).isEmpty())
	    {
		lParamVO.setMinValue(new BigDecimal(constrCO.getMIN_VAL()));
	    }
	    if(StringUtil.nullToEmpty(constrCO.getFORMAT()).isEmpty())
	    {
		lParamVO.setNbFormat("0.####");
	    }
	    else
	    {
		lParamVO.setNbFormat(constrCO.getFORMAT());
	    }
	}
	else if(ConstantsCommon.PARAM_TYPE_VARCHAR2.equals(argType))
	{
	    if(!StringUtil.nullToEmpty(constrCO.getCASE_SENSITIVITY()).isEmpty())
	    {
		lParamVO.setLowerCase((constrCO.getCASE_SENSITIVITY().equals("1")) ? false : true);
		lParamVO.setUpperCase((constrCO.getCASE_SENSITIVITY().equals("1")) ? true : false);
	    }
	    if(!StringUtil.nullToEmpty(constrCO.getMAX_LENGTH()).isEmpty())
	    {
		lParamVO.setMaxLength(Integer.valueOf(constrCO.getMAX_LENGTH()));
	    }
	    if(!StringUtil.nullToEmpty(constrCO.getFORMAT()).isEmpty())
	    {
		lParamVO.setTxtFormat(constrCO.getFORMAT());
	    }
	}
	if(argFunctionMap.get(argName) != null)
	{
	    String onChangeContent = "";
	    // comparison
	    if(argFunctionMap.get(argName).get(0) != null)
	    {
		onChangeContent = "onChangeComparison('" + lParamVO.getName() + "')";
	    }
	    // has hide or show expressions
	    if(argFunctionMap.get(argName).get(1) != null || argFunctionMap.get(argName).get(2) != null)
	    {
		onChangeContent += ";onChangeShowHide('" + lParamVO.getName() + "')";
	    }
	    lParamVO.setOnchange(onChangeContent);
	}
	return lParamVO;
    }
	
    public void fillFormElement()throws BaseException
    {
	try { 
	    //Map containing the hidden elements related to the multi liveSearch and will be looped 
	    HashMap <String,DynamicParamsVO> multiHiddenMap = new HashMap <String, DynamicParamsVO>();
	    SessionCO sessionCO = returnSessionObject();
	    IRP_AD_HOC_REPORTSC reportSC=new IRP_AD_HOC_REPORTSC();
	    String appName=(a == null ? sessionCO.getCurrentAppName():  a);
	    String[] addParams = null;
	    if(!StringUtil.nullToEmpty(r_a_p).isEmpty()) {
		addParams = r_a_p.split("~#~");
	    }
	    
	    //get all the report arguments
	    List<IRP_REP_ARGUMENTSCO> argumentsList = new ArrayList(reportCO.getArgumentsList().values());
	  
	    BigDecimal globalArgPerRow=commonLibBO.returnPthCtrl1().getNBR_DISPLAYED_REP_ARG_PER_ROW();
	    BigDecimal repArgPerRow=reportCO.getNBR_DISPLAYED_ARG_PER_ROW();
	    int argPerRow=4;
	    if(NumberUtil.nullToZero(repArgPerRow).intValue()>0)
	    {
		argPerRow=repArgPerRow.intValue();
	    }
	    else if(NumberUtil.nullToZero(globalArgPerRow).intValue()>0)
	    {
		argPerRow=globalArgPerRow.intValue();
	    }

	    int count = 0;
	    String argType;
	    BigDecimal argSource;
	    Object argValue =  new Object();
		
	    formLst = new ArrayList<DynamicParamsVO>();
	    DynamicParamsVO paramVO;    
	    int paramCnt = 0;
	    String valStr;
	    String defaultColDescValue ="";
	    
	    //to store the arguments that are dependent on a specific argument
	    ArrayList<IRP_REP_ARGUMENTSVO> argDepList;
	    IRP_REP_ARGUMENTSVO argDep;
	    StringBuffer argDepId;
	    StringBuffer dependency;
	    String sessionParamName;
	    
	    IRP_REP_ARG_CONSTRAINTSCO constrCO;
	    //below map has argument name as key and value hashmap with 3 possible entries
	    //0=>comparison,1=>show,2=>hide
	    HashMap<String,HashMap<Integer,Object>> argFunctionMap = new HashMap<String, HashMap<Integer,Object>>(); 
	    fillArgFunctionMap(argFunctionMap,argumentsList);
	    StringBuffer sessTransOnChangeSb=new StringBuffer();
	    StringBuffer repLangParamsIdSb = new StringBuffer();
	    StringBuffer repLangParamsNameSb = new StringBuffer();
	    String sessTransAr="";
	    String sessTransEn="";
	    CURRENCIESVOKey currVOKey;
	    CURRENCIESVO curVO=null;
	    BRANCHESVOKey brVOKey;
	    BRANCHESVO brVO=null;
	    int sessTransCnt=0;
	    HashMap<String, String> refreshHm = new HashMap<String, String>();
	    List<IRP_QUERY_ARG_MAPPINGCO> argsMapCOList;
	    for(Entry<String, List<IRP_QUERY_ARG_MAPPINGCO>> entry : reportCO.getLinkQryArsMap().entrySet())
	    {
		argsMapCOList = entry.getValue();
		for(int i = 0; i < argsMapCOList.size(); i++)
		{
		    refreshHm.put(argsMapCOList.get(i).getIrpQueryArgsMappingVO().getREPORT_MAPPED_ARG_NAME(),
			    ConstantsCommon.TRUE);
		}
	    }
	    BigDecimal defaultFilter = null;
	    HashMap<BigDecimal, String> ArgsFilter = new HashMap<BigDecimal, String>();
	    if(addParams == null)
	    {
		IRP_REP_FILTERSSC filterSC = new IRP_REP_FILTERSSC();
		filterSC.setREPORT_ID(reportCO.getREPORT_ID());
		filterSC.setCREATED_BY(sessionCO.getUserName());
		HashMap<String, Object> filtersSCMap = PathPropertyUtil.convertToMap(filterSC);
		IRP_REP_ARGUMENTS_FILTERSVO argFilterVO;
		try
		{
		    defaultFilter = commonReportingBO.selectDefaultFilter(filtersSCMap);
		}
		catch(Exception e)
		{
		    log.error(e, "Error retrieving the default filter " + e.getMessage());

		}

		if(defaultFilter != null)
		{
		    filterSC.setFILTER_ID(defaultFilter);
		    filtersSCMap = PathPropertyUtil.convertToMap(filterSC);
		    List<HashMap<String, Object>> filterArgslistMap = null;
		    try
		    {
			filterArgslistMap = commonReportingBO.retFilterArgumentsValues(filtersSCMap);
		    }
		    catch(Exception e)
		    {
			log.error(e, "Error retrieving the filter arguments " + e.getMessage());

		    }
		    String[] propsArr = ConstantsCommon.retFiltersArgsListMap_PROPS.toArray(new String[ConstantsCommon.retFiltersArgsListMap_PROPS.size()]);
		    HashMap<String, Object> retMap;
		    for(int i = 0; i < filterArgslistMap.size(); i++)
		    {
			retMap = filterArgslistMap.get(i);
			argFilterVO = new IRP_REP_ARGUMENTS_FILTERSVO();
			PathPropertyUtil.copyProperties(retMap, argFilterVO, false, propsArr);
			ArgsFilter.put(argFilterVO.getARGUMENT_ID(), argFilterVO.getARGUMENT_VALUE());
		    }
		}
	    }
	    for(IRP_REP_ARGUMENTSCO argObj : argumentsList)
	    {
		argSource = argObj.getARGUMENT_SOURCE();
		String valFromFilter = ArgsFilter.get(argObj.getARGUMENT_ID());
		if(valFromFilter != null)
		{
		    // if liveSearch with multi select
		    if((new BigDecimal("3").equals(argSource) || new BigDecimal("10").equals(argSource)) && BigDecimal.ONE.equals(argObj.getMULTISELECT_YN()))
		    {
			argObj.setARGUMENT_VALUE(valFromFilter.split(",").length + ConstantsCommon.P_SELECTED);
		    }
		    else
		    {
			argObj.setARGUMENT_VALUE(valFromFilter);
		    }
		}
		constrCO = argObj.getIrpRepArgConstraintCO();
		paramVO = new DynamicParamsVO();
		//removed min-width:120px;max-width:120px because the label was not well displayed under IE9
		paramVO.setCssStyle("width:120px;");

		//check if the key exist for this prog ref as lower case
		String paramLblTrans = returnKeyTrans(argObj.getARGUMENT_NAME().toLowerCase(), reportCO.getAPP_NAME(), reportCO.getPROG_REF());
		
		//in case no translation was found check it as upper case
		if(paramLblTrans != null && paramLblTrans.equals(argObj.getARGUMENT_NAME().toLowerCase()))
		{
		    paramLblTrans = returnKeyTrans(argObj.getARGUMENT_NAME(), reportCO.getAPP_NAME(), reportCO.getPROG_REF());
		}
	    if((argObj.getARGUMENT_NAME()).equals(paramLblTrans))
	    {
	       paramVO.setLabel(returnKeyTrans(argObj.getARGUMENT_LABEL(), reportCO.getAPP_NAME(), reportCO.getPROG_REF()));
	    }
	    else
	    {
	    	paramVO.setLabel(paramLblTrans);
	    }
	    	paramVO.setLabelKeyCode(argObj.getARGUMENT_NAME());
	    	CommonReportingSessionCO repSessionCO = returnReportingSessionObject(r_r);
		IRP_AD_HOC_REPORTCO repCO;
	    	repCO = repSessionCO.getReportCO();
		paramVO.setName(ConstantsCommon.PARAM_TILDA+argObj.getARGUMENT_NAME()+"~"+argObj.getARGUMENT_TYPE());
		if(refreshHm.get(argObj.getARGUMENT_NAME()) != null
			&& ConstantsCommon.YES.equals(argObj.getDISPLAY_FLAG())
			&& !(ConstantsCommon.REP_ARG_TYPE_QRY.equals(argObj.getARGUMENT_SOURCE()) && (ConstantsCommon.ARG_QRY_LIVESEARCH_WITHOUT_DESC
				.equals(argObj.getARG_QUERY_OPTIONS()) || ConstantsCommon.ARG_QRY_LIVESEARCH_WITH_DESC
				.equals(argObj.getARG_QUERY_OPTIONS()))))
		{
		    paramVO.setOnchange("onChangeRefresh('" + paramVO.getName() + "')");
		}
		paramVO.setId("p_"+"param_"+argObj.getARGUMENT_NAME()+"_"+argObj.getARGUMENT_TYPE()+"_"+htmlPageRef);
		HashMap<BigDecimal, String> localMap = new HashMap<BigDecimal, String>();
		localMap.put(BigDecimal.valueOf(0), paramVO.getId());
		repCO.getArgShowHideMap().put(paramVO.getName(), localMap);		
		argType = argObj.getARGUMENT_TYPE();
		//if display_flag=No 		
		if(argObj.getDISPLAY_FLAG().equals("N"))
		{
		    paramVO.setElement_type(HIDDEN_ELEMENT);
		    if(argSource.equals(ConstantsCommon.REP_LANG_ARG_SOURCE))
		    {
			if(repLangParamsIdSb.length() > 0)
			{
			    repLangParamsIdSb.append("," + paramVO.getId());
			    repLangParamsNameSb.append("," + paramVO.getName());
			}
			else
			{
			    repLangParamsIdSb.append(paramVO.getId());
			    repLangParamsNameSb.append(paramVO.getName());
			}
		    }
		}
		else if(argSource.equals(new BigDecimal("4")))
		{
		    repCO.getArgShowHideMap().remove(paramVO.getName());
		    HashMap<BigDecimal, String> lMap = new HashMap<BigDecimal, String>();
		    lMap.put(BigDecimal.valueOf(0), paramVO.getId());
		    repCO.getArgShowHideMap().put("__checkbox_paramsFlag."+argObj.getARGUMENT_NAME()+"_Y_N", lMap);
		    paramVO.setElement_dataType(DT_STRING);
		    paramVO.setElement_type(CHKBOX_ELEMENT);
		    //
//		    ListParamVO lst = new ListParamVO();
//		    chkFlagList = setChkBox();
//		    lst.setValueList("chkFlagList");
//		    lst.setKey("code");
//		    lst.setValue("description");
//		    paramVO.setListParamVO(lst);
		}
		else if(argSource.equals(new BigDecimal("3")) || argSource.equals(new BigDecimal("10")))
		{
		    if (ConstantsCommon.ARG_QRY_COMBO.equals(argObj.getARG_QUERY_OPTIONS()))
		    {
			paramVO.setElement_type(COMBO_ELEMENT);
			ListParamVO lstCmbParamVO = new ListParamVO();
			if(NumberUtil.isEmptyDecimal(argObj.getQUERY_ID_DEFAULT()))
			{
			    combosLists.put(argObj.getARGUMENT_NAME(), (ArrayList<LinkedHashMap>) retQryCombo(argObj
				    .getQUERY_ID(), repCO, argObj));
			}
			else
			{
			    combosLists.put(argObj.getARGUMENT_NAME(), (ArrayList<LinkedHashMap>) retQryCombo(argObj
				    .getQUERY_ID_DEFAULT(), repCO, argObj));
			}
			lstCmbParamVO.setValueList("combosLists." + argObj.getARGUMENT_NAME());
			lstCmbParamVO.setKey(argObj.getCOLUMN_NAME());
			lstCmbParamVO.setValue(argObj.getCOLUMN_DESC());
			paramVO.setElement_dataType(DT_STRING);
			paramVO.setListParamVO(lstCmbParamVO);
			paramVO.setLabelId(argObj.getARGUMENT_LABEL() + "_" + htmlPageRef);	
			repCO.getArgComboMap().put(paramVO.getId(),"");
		    }
		    else
		    {
		    paramVO.setElement_type(LIVESEARCH_ELEMENT);
		    //checking if multiselect livesearch
		    if(BigDecimal.ONE.equals(argObj.getMULTISELECT_YN()))
		    {
			// adding a hidden to the form next to the livesearch
			DynamicParamsVO multiHiddenVO = new DynamicParamsVO();
			multiHiddenVO.setElement_type(HIDDEN_ELEMENT);
			multiHiddenVO.setName(ConstantsCommon.PARAM_H+"~" + argObj.getARGUMENT_NAME() + "~" + argObj.getARGUMENT_TYPE());
			multiHiddenVO.setId(ConstantsCommon.P_PARAM_UNDERSCORE + argObj.getARGUMENT_NAME() + "_" + argObj.getARGUMENT_TYPE()
				+ "_" + htmlPageRef);
			multiHiddenVO.setColumn(1);
			multiHiddenVO.setReadOnly(ConstantsCommon.TRUE);
			StringBuffer sb = new StringBuffer();
			valFromFilter = StringUtil.nullToEmpty(ArgsFilter.get(argObj.getARGUMENT_ID()));
			if(!valFromFilter.isEmpty())
			{
			    String[] valArray = valFromFilter.split(",");
			    for(int j = 0; j < valArray.length; j++)
			    {
				if(sb.length() > 0)
				{
				    sb.append(",");
				}
				if(ConstantsCommon.PARAM_TYPE_VARCHAR2.equals(argObj.getARGUMENT_TYPE()))
				{
				    // if string contains ""
				    valArray[j] = valArray[j].replace("\"\"", "\\\"");
				    sb.append("{\"" + argObj.getCOLUMN_NAME() + "\":" + valArray[j].trim() + "}");
				}
				else
				{
				    sb.append("{\"" + argObj.getCOLUMN_NAME() + "\":\"" + valArray[j].trim() + "\"}");
				}
			    }
			    multiHiddenVO.setValue(ConstantsCommon.MULTI_P_ROOT + sb.toString() + "]}");
			}
			multiHiddenMap.put(multiHiddenVO.getName(),multiHiddenVO);
			paramVO.setMultiSelect(ConstantsCommon.TRUE);
			paramVO.setMultiResultInput(multiHiddenVO.getId());
			paramVO.setSelectColumn(argObj.getCOLUMN_NAME());
			String name = paramVO.getName();
			HashMap<BigDecimal, String> map = repCO.getArgShowHideMap().get(name);
			repCO.getArgShowHideMap().remove(name);
			//removing param~ to not take it into consideration on retrieve
			paramVO.setName(name.substring(name.indexOf("~") + 1, name.length()));
			repCO.getArgShowHideMap().put(paramVO.getName(), map);
		    }
		    // if it's livesearch adjust the id (lookuptxt_) in
		    // ArgShowHideMap
		    repCO.getArgShowHideMap().get(paramVO.getName()).put(BigDecimal.valueOf(0),
			    "lookuptxt_" + paramVO.getId());
		    if(ConstantsCommon.PARAM_TYPE_NUMBER.equals(argType)&&!BigDecimal.ONE.equals(argObj.getMULTISELECT_YN()))
		    {
			paramVO.setMode(ConstantsCommon.COLUMN_NUMBER_TYPE);
		    }
		    //paramVO.setId(""+paramCnt);
		    // get the default value if it have a type query
//		    String val =retQryDfltVal(reportCO,argObj);
//		    paramVO.setValue(val);
//		    argObj.setARGUMENT_VALUE(val);
		    
		    // if the type = 3(arg type = query)
    	   	    ArrayList<IRP_REP_ARGUMENTSCO> argsList=new ArrayList<IRP_REP_ARGUMENTSCO>();
	   	    LinkedHashMap argsMap=reportCO.getArgumentsList();
	   	    argsList = new ArrayList(argsMap.values());
	   	    List<IRP_QUERY_ARG_MAPPINGCO> list;
	   	    StringBuffer queryParam=new StringBuffer();
	   	    StringBuffer queryStr;
	   	    for(int i=0;i<argsList.size();i++)
	   	    {
	   		reportSC.setREPORT_ID(reportCO.getREPORT_ID());
	   		if(!NumberUtil.isEmptyDecimal(argsList.get(i).getQUERY_ID())&&(argsList.get(i).getARGUMENT_ID().equals(argObj.getARGUMENT_ID())))
	   		{
	   		    reportSC.setReportArgumentId(argsList.get(i).getARGUMENT_ID());
	   		    reportSC.setDefaultSrc(BigDecimal.ONE);
	   		    list=fillQryArgsMapList(reportSC);
	   		   
	   		    
	   		 try
			{
			    //IRP_AD_HOC_QUERYCO query = queryBO.returnQueryById(argsList.get(i).getQUERY_ID(), true);
	   		   HashMap<String,Object> retMap = commonReportingBO.returnQueryById(argsList.get(i).getQUERY_ID(), true);
	   		   IRP_AD_HOC_QUERYCO query=(IRP_AD_HOC_QUERYCO) PathPropertyUtil.convertToObject(retMap, IRP_AD_HOC_QUERYCO.class);
			       for(int j=0;j<query.getSqlObject().getArgumentsList().size();j++)
			       {
				   LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> arguments =query.getSqlObject().getArgumentsList();
				   ArrayList<IRP_REP_ARGUMENTSCO> argsQryList = new ArrayList(arguments.values());
				   
				   for(int m=0;m<list.size();m++)
				   {
				       for(int n=0;n<argsQryList.size();n++)
				       {
					   if(list.get(m).getIrpQueryArgsMappingVO().getQUERY_ARG_NAME().equals(argsQryList.get(n).getARGUMENT_NAME()))
					   {
					       list.get(m).setARGUMENT_TYPE(argsQryList.get(n).getARGUMENT_TYPE()); 
					   }
				       }
				   }
		
			       }
			       
			}
			catch(ClassNotFoundException e)
			{
			    log.error(e, e.getMessage() + " on report having id: "+reportCO.getREPORT_ID() +", reference: "+reportCO.getPROG_REF() + " and application: "+reportCO.getAPP_NAME());
			}
			catch(IOException e)
			{
			    log.error(e, e.getMessage() + " on report having id: "+reportCO.getREPORT_ID() +", reference: "+reportCO.getPROG_REF() + " and application: "+reportCO.getAPP_NAME());
			}
	   		 
			
		 	 // append all dyn and static param name and value to queryStr(put the id of the argument(param for qry) in paramStr)
	   	    	queryStr= new StringBuffer();
    			for(int s=0;s<list.size();s++)
    			{
    			 // add an additional parameter for each argument that includes the type of the argument.
    			    queryStr.append(list.get(s).getIrpQueryArgsMappingVO().getQUERY_ARG_NAME())
				    .append("@TYPE:")
				    .append(list.get(s).getARGUMENT_TYPE()).append(",");
				
    			    if(list.get(s).getIrpQueryArgsMappingVO().getSTATIC_VALUE()==null || ("").equals(list.get(s).getIrpQueryArgsMappingVO().getSTATIC_VALUE()))
    			    {
    				queryStr.append(list.get(s).getIrpQueryArgsMappingVO().getQUERY_ARG_NAME()+ (((new BigDecimal(3)).equals(list.get(s).getArgumentCO()
					    .getARGUMENT_SOURCE()) || (new BigDecimal(10)).equals(list.get(s).getArgumentCO()
							    .getARGUMENT_SOURCE())) ? ":lookuptxt_p_" : ":p_")+"param_"+list.get(s).getIrpQueryArgsMappingVO().getREPORT_MAPPED_ARG_NAME()+"_"+list.get(s).getARGUMENT_TYPE()+"_"+htmlPageRef+",");   
    			    }
    			    else
    			    {
    				queryStr.append(list.get(s).getIrpQueryArgsMappingVO().getQUERY_ARG_NAME()+":"+list.get(s).getIrpQueryArgsMappingVO().getSTATIC_VALUE()+"-"+list.get(s).getARGUMENT_TYPE()+","); 
    			    }
    			}
			
    			queryParam.append(queryStr);
    			
	   		}
	   	    }
	   	 
	   	 queryParam.append("conId:connection_id_"+ htmlPageRef);
			if(queryParam.toString().endsWith(","))
    			{
			    queryParam = new StringBuffer(queryParam.substring(0, queryParam.length()-1));
    			}
    			//loop on the list to construct queryParam
    			paramVO.setParamList(queryParam.toString());   
			paramVO.setActionName("/path/repCommon/dynLkupAction_constructQryLookup?qryId="+argObj.getQUERY_ID()+"&repApp="+ reportCO.getAPP_NAME()+"&repRef="+reportCO.getPROG_REF());//+"&queryStr="+queryStr //+queryParamUrl  +queryParamUrl
			
			paramVO.setSearchElement(argObj.getCOLUMN_NAME());
			
			//annasuccar-05/08/2014: return the report arguments dependent on this one
			    reportSC.setReportArgumentId(argObj.getARGUMENT_ID());
			    reportSC.setReportArgumentName(argObj.getARGUMENT_NAME());
			    
			    HashMap<String,Object> reportSCMap=new HashMap<String,Object>();
			    String[] propsArr= ConstantsCommon.retRepArgDepList_PROPS.toArray(new String[ConstantsCommon.retRepArgDepList_PROPS.size()]);
		    	    PathPropertyUtil.copyProperties(reportSC, reportSCMap,false,propsArr);
		    	    List<HashMap<String,Object>> retLstt=  commonReportingBO.retRepArgDepList(reportSCMap);
		    	    
		    	    argDepList=new ArrayList<IRP_REP_ARGUMENTSVO>();
		    	    HashMap<String,Object> hmm;
		    	    IRP_REP_ARGUMENTSVO repArgVO;
		    	    propsArr= ConstantsCommon.retRepArgDepListRet_PROPS.toArray(new String[ConstantsCommon.retRepArgDepListRet_PROPS.size()]);
		    	    for(int i=0;i<retLstt.size();i++)
		    	    {
		    		hmm=retLstt.get(i);
		    		repArgVO=new IRP_REP_ARGUMENTSVO();
		    		PathPropertyUtil.copyProperties(hmm, repArgVO,false,propsArr);
		    		argDepList.add(repArgVO);
		    	    }
		    	    
		    	    
			    dependency = new StringBuffer("");
			    argDepId = new StringBuffer("");
			    for( int a = 0; a < argDepList.size(); a++ )
			    {
				argDep = argDepList.get(a);
				if( new BigDecimal(3).equals(argDep.getARGUMENT_SOURCE()) || new BigDecimal(10).equals(argDep.getARGUMENT_SOURCE()))
				{
				    argDepId.append("lookuptxt_");
				}
				argDepId.append("p_").append("param_").append(argDep.getARGUMENT_NAME()).append("_").append(argDep.getARGUMENT_TYPE())
				.append("_").append(htmlPageRef);
				
				if (a > 0)
				{
				    dependency.append(",");
				}
				dependency.append(argDepId.toString()).append(": ''");
			    }
			    // remove the dependency conditions because there should be
			    // always dependency
        		    if(!BigDecimal.ONE.equals(argObj.getMULTISELECT_YN()))
        		    {
        			paramVO = addParamsLiveSearch(argumentsList, "", paramVO);
        			paramVO.setDependency(dependency.toString());
        			if((StringUtil.nullToEmpty(paramVO.getDependency())).isEmpty())
        			{
        			    paramVO.setDependency("lookuptxt_" + paramVO.getId() + ":" + paramVO.getName());
        			}
        			paramVO.setDependencySrc("/path/repCommon/reportAction_applyArgsDependency?qryId="
        				+ argObj.getQUERY_ID() + "&argId=" + argObj.getARGUMENT_ID());
        		    }
        		    if (ConstantsCommon.ARG_QRY_LIVESEARCH_WITH_DESC.equals(argObj.getARG_QUERY_OPTIONS()))
        		    {
        			paramVO.setResultList(argObj.getCOLUMN_DESC()+":"+"p_" + "desc_"+ argObj.getARGUMENT_NAME()+"_" + htmlPageRef);
        		    }
		    }
		}
		else if(argSource.equals(ConstantsCommon.REP_LANG_ARG_SOURCE))
		{
		    paramVO.setElement_dataType(DT_STRING);
		    paramVO.setElement_type(TEXTFIELD_ELEMENT);
		    paramVO.setReadOnly(ConstantsCommon.TRUE);
		    if(repLangParamsIdSb.length()>0)
		    {
			repLangParamsIdSb.append(","+paramVO.getId());
			repLangParamsNameSb.append(","+paramVO.getName());
		    }
		    else
		    {
			repLangParamsIdSb.append(paramVO.getId());
			repLangParamsNameSb.append(paramVO.getName());
		    }
		}
		else if(ConstantsCommon.PARAM_TYPE_NUMBER.equals(argType))
		{
		    paramVO.setElement_dataType(DT_NUMBER);
		    paramVO.setElement_type(TEXTFIELD_ELEMENT);
		    paramVO = fillAdditionalProps(argType, paramVO, constrCO,argFunctionMap,argObj.getARGUMENT_NAME());

		}
		else if(ConstantsCommon.PARAM_TYPE_VARCHAR2.equals(argType))
		{
		    paramVO.setElement_dataType(DT_STRING);
		    paramVO.setElement_type(TEXTFIELD_ELEMENT);
		    paramVO = fillAdditionalProps(argType, paramVO, constrCO,argFunctionMap,argObj.getARGUMENT_NAME());
		}
		else if(ConstantsCommon.PARAM_TYPE_DATE.equals(argType))
		{
		    paramVO.setElement_dataType(DT_DATE);
		    paramVO.setElement_type(DATE_ELEMENT);
		    paramVO = fillAdditionalProps(argType, paramVO, constrCO,argFunctionMap,argObj.getARGUMENT_NAME());
		}
		else if(ConstantsCommon.datetime.equals(argType))
		{
		    //if  system date 
		    if(BigDecimal.valueOf(7).equals(argObj.getARGUMENT_SOURCE()))
		    {
			paramVO.setElement_dataType(DT_STRING);
			paramVO.setElement_type(TEXTFIELD_ELEMENT);
			paramVO.setReadOnly("true");
		    }
		    else
		    {
    		    	paramVO.setElement_dataType(DT_DATE);
    		    	paramVO.setElement_type(DATE_ELEMENT);
    		    	paramVO.setDateWithTime("true");
    		    	paramVO.setDateTimeAmPm("true");
		    }
		    paramVO = fillAdditionalProps(argType, paramVO, constrCO,argFunctionMap,argObj.getARGUMENT_NAME());
		}

		if(argSource.equals(ConstantsCommon.REP_LANG_ARG_SOURCE))
		{
		    valStr=sessionCO.getLanguage();
		}
		else
		{
		    valStr=argObj.getARGUMENT_VALUE();
		}
		if(argSource.equals(ConstantsCommon.SESSION_ARG_SOURCE) || argSource.equals(ConstantsCommon.TRANS_SESSION_ARG_SOURCE)) {//value from session
		    sessionParamName=argObj.getSESSION_ATTR_NAME();
		    if("".equals(StringUtil.nullToEmpty(valStr)))
		    {
			    if(ConstantsCommon.LANGUAGE_ARABIC.equals(sessionCO.getLanguage())
				    && ConstantsCommon.COMP_NAME_EXP_VAR.equals(sessionParamName) )
			    {
				argValue = PathPropertyUtil.returnProperty(sessionCO, ConstantsCommon.COMP_AR_NAME_SESSION); 
			    }
			    else if(ConstantsCommon.LANGUAGE_ARABIC.equals(sessionCO.getLanguage())
				    && ConstantsCommon.BASE_CURR_NAME_EXP_VAR.equals(sessionParamName))
			    {
				currVOKey= new CURRENCIESVOKey();
				currVOKey.setCOMP_CODE(sessionCO.getCompanyCode());
				currVOKey.setCURRENCY_CODE(sessionCO.getBaseCurrencyCode());
				curVO=commonLibBO. returnCurrency(currVOKey);
				argValue=curVO.getBRIEF_DESC_ARAB();
			    }
			    else if(ConstantsCommon.LANGUAGE_ARABIC.equals(sessionCO.getLanguage())
				    && ConstantsCommon.BRANCH_NAME_EXP_VAR.equals(sessionParamName))
			    {
				brVOKey= new BRANCHESVOKey();
				brVOKey.setCOMP_CODE(sessionCO.getCompanyCode());
				brVOKey.setBRANCH_CODE(sessionCO.getBranchCode());
				brVO=commonLibBO. returnBranch(brVOKey);
				argValue=brVO.getBRIEF_DESC_ARAB();
			    }
			    else
			    {
				argValue = PathPropertyUtil.returnProperty(sessionCO, sessionParamName); 
			    }
			// if the default value is null then use the session value
			if(argValue == null)
			{
			    argValue = StringUtil.nullToEmpty(valStr);
			}
			valStr=argValue.toString();
			if(ConstantsCommon.PARAM_TYPE_DATE.equals(argObj.getARGUMENT_TYPE()))
			{
				valStr = DateUtil.format(DateUtil.parseDate(valStr, "EEE MMM dd HH:mm:ss Z yyyy"), "dd/MM/yyyy");
			}
		    }
		    if(argSource.equals(ConstantsCommon.TRANS_SESSION_ARG_SOURCE) && "0".equals(repCO.getLANG_INDEPENDENT_YN())
			    && "".equals(StringUtil.nullToEmpty(argObj.getARGUMENT_VALUE())))
		    {
			if(ConstantsCommon.COMP_NAME_EXP_VAR.equals(sessionParamName))
			{
			    sessTransEn = (String) PathPropertyUtil.returnProperty(sessionCO, sessionParamName);
			    sessTransAr = (String) PathPropertyUtil.returnProperty(sessionCO,
				    ConstantsCommon.COMP_AR_NAME_SESSION);
			}
			else if(ConstantsCommon.BASE_CURR_NAME_EXP_VAR.equals(sessionParamName))
			{
			    if(curVO == null)
			    {
				currVOKey = new CURRENCIESVOKey();
				currVOKey.setCOMP_CODE(sessionCO.getCompanyCode());
				currVOKey.setCURRENCY_CODE(sessionCO.getBaseCurrencyCode());
				curVO = commonLibBO.returnCurrency(currVOKey);
			    }
			    sessTransEn = curVO.getBRIEF_DESC_ENG();
			    sessTransAr = curVO.getBRIEF_DESC_ARAB();
			}
			else if(ConstantsCommon.BRANCH_NAME_EXP_VAR.equals(sessionParamName))
			{
			    if(brVO == null)
			    {
				brVOKey = new BRANCHESVOKey();
				brVOKey.setCOMP_CODE(sessionCO.getCompanyCode());
				brVOKey.setBRANCH_CODE(sessionCO.getBranchCode());
				brVO = commonLibBO.returnBranch(brVOKey);
			    }
			    sessTransEn = brVO.getBRIEF_DESC_ENG();
			    sessTransAr = brVO.getBRIEF_DESC_ARAB();
			}
			sessTransCnt++;
			sessTransAr=StringUtil.nullToEmpty(sessTransAr);
			sessTransEn=StringUtil.nullToEmpty(sessTransEn);
			sessTransOnChangeSb.append("elt" + sessTransCnt + ":{id:'" + paramVO.getId() + "',transAr:'"
				+ sessTransAr + "',transEn:'" + sessTransEn + "'},");
		    }

		   
		}	
		else if(argSource.equals(new BigDecimal(4)))  //based on flag
		{
		    if(addParams != null && addParams.length > 0 && (argObj.getARGUMENT_ORDER()).intValue() <= addParams.length)
		    {
			argValue = addParams[(argObj.getARGUMENT_ORDER()).intValue() - 1];
			valStr = argValue.toString();
		    }
		    
		    if(valStr.equals(argObj.getFLAG_VALUE_ON()))
		    {
			paramsFlag.put(argObj.getARGUMENT_NAME() + "_" + argObj.getFLAG_VALUE_ON() + "_" + argObj.getFLAG_VALUE_OFF(), "true");
			valStr = ConstantsCommon.TRUE;
			paramVO.setValue(valStr);
		    }
		    else
		    {
			paramsFlag.put(argObj.getARGUMENT_NAME() + "_" + argObj.getFLAG_VALUE_ON() + "_" + argObj.getFLAG_VALUE_OFF(), "false");
			valStr = ConstantsCommon.FALSE;
			paramVO.setValue(valStr);
		    }
                    paramVO.setName("paramsFlag."
                    + argObj.getARGUMENT_NAME() + "_"
                    + argObj.getFLAG_VALUE_ON() + "_"
                    + argObj.getFLAG_VALUE_OFF());
		}
		else
		{
		    if(argSource.equals(new BigDecimal("5")))
		    {
			paramVO.setValue(htmlPageRef);
			valStr = htmlPageRef;
			// repCO.setPROG_REF(menu);
		    }
		    else
		    {
			 ArrayList<LinkedHashMap> argValueRes= retQryDfltVal(reportCO, argObj);
			    String dynVal ="";
			    if (argValueRes != null && !argValueRes.isEmpty())
			    {
				Object obj=argValueRes.get(0).get(argObj.getDEFAULT_VALUE_COL_NAME());
				if(obj instanceof Timestamp)
				{
				    Timestamp ts=(Timestamp) obj;
				    Date dt= new Date(ts.getTime());
				    dynVal =DateUtil.format(dt,DateUtil.DEFAULT_DATE_FORMAT);
				}
				else
				{
				    dynVal = obj.toString();
				}
				 if (!StringUtil.nullToEmpty(argObj.getDEFAULT_VALUE_COL_DESC()).isEmpty())
				{
				defaultColDescValue = argValueRes.get(0).get(argObj.getDEFAULT_VALUE_COL_DESC()).toString();
				}
			    }
			if(!"".equals(dynVal))
			{
			    if(ConstantsCommon.PARAM_TYPE_DATE.equals(argType))
			    {
				dynVal= StringUtil.replaceInString(dynVal, "-","/");
			    }
    
			    valStr = dynVal;
			}	
        		    
			if(addParams != null && addParams.length > 0 && (argObj.getARGUMENT_ORDER()).intValue() <= addParams.length)
			{
			    valStr=(addParams[(argObj.getARGUMENT_ORDER()).intValue() - 1]).toString();
			}
		    }	
		}
		
		if(valStr==null)
		{
		    valStr="";
		}
		    
		if(ConstantsCommon.PARAM_TYPE_DATE.equals(argType) && !valStr.isEmpty() &&  "Y".equals(argObj.getDISPLAY_FLAG()))
		{
		    if((BigDecimal.ONE).equals(argObj.getARGUMENT_SRC_DEFAULT()))
		    {
			valStr = DateUtil.format(DateUtil.parseDate(valStr, "dd/MM/yyyy"), "yyyy-MM-dd");
		    }
		    else
		    {
			valStr = DateUtil.format(DateUtil.parseDate(valStr, DateUtil.getDatePattern(valStr)), "yyyy-MM-dd");
		    }
		}
		else if (ConstantsCommon.datetime.equals(argType) && !valStr.isEmpty() && "Y".equals(argObj.getDISPLAY_FLAG()))
		{
		    valStr = DateUtil.format(DateUtil.parseDate(valStr,DateUtil.getDatePattern(valStr)), "yyyy-MM-dd'T'HH:mm:ss");//naaaaab
		}
		//if sysdate parameter
		if(ConstantsCommon.datetime.equals(argType)
			&& BigDecimal.valueOf(7).equals(argObj.getARGUMENT_SOURCE()))
		{
		    valStr = commonReportingBO.retSysDateParamLovVal(sessionCO.getLanguage());
		}
		paramVO.setValue(valStr);
		
		if(argObj.getENABLE_FLAG().equals("N"))
		{
		    paramVO.setReadOnly("true");
		}
				
		paramVO.setColumn(1);
		if(paramCnt==0 || paramCnt==argPerRow)
		{
		    paramVO.setRow(++count);
		    if(paramCnt==argPerRow)
		    {
			paramCnt=0;
		    }
		}
		else 
		{
		    paramVO.setRow(count);
		}
		paramCnt++;
		
		formLst.add(paramVO);
		if (argObj.getARG_QUERY_OPTIONS().equals(ConstantsCommon.ARG_QRY_LIVESEARCH_WITH_DESC))
		{
		    DynamicParamsVO colDescVO = new DynamicParamsVO();
		    colDescVO.setElement_dataType(DT_STRING);
		    colDescVO.setElement_type(TEXTFIELD_ELEMENT);
		    colDescVO.setId("p_" + "desc_"+ argObj.getARGUMENT_NAME()+"_" + htmlPageRef);
		    colDescVO.setReadOnly(ConstantsCommon.TRUE);
		    colDescVO.setColumn(1);
		    if( !NumberUtil.isEmptyDecimal(argObj.getQUERY_ID_DEFAULT()))
		    {
		    colDescVO.setValue(defaultColDescValue);
		    }
		    if(paramCnt == 0 || paramCnt == 4)
		    {
			colDescVO.setRow(++count);
			if(paramCnt == 4)
			{
			    paramCnt = 0;
			}
		    }
		    else
		    {
			colDescVO.setRow(count);
		    }
		    paramCnt++;
		    formLst.add(colDescVO);
		}
	    }
	    
	    DynamicParamsVO hiddenVO;
	    //skip one row
	    count++;
	    for(Entry <String,DynamicParamsVO> entry : multiHiddenMap.entrySet())
	    {
		hiddenVO = entry.getValue();
		hiddenVO.setRow(count);
		formLst.add(hiddenVO);
	    }
	    
	    
	    count = count+10; //to add spaces between the parameters and the below
	    
	    BigDecimal db =BigDecimal.ZERO; 
	    if( reportCO.getCONN_ID() != null )
	    {
		db = reportCO.getCONN_ID();
	    }

	    
	    if( BigDecimal.ONE.equals(r_c) )
	    {
		BigDecimal appDb = commonReportingBO.returnConnectionId(appName);
		if(appDb != null)
		{
		    db = appDb;
		}
	    }
	    
	    // languages DDL
	    ListParamVO lstParamVO = new ListParamVO();
	    DynamicParamsVO paramVO1 = new DynamicParamsVO();
	    langList = setLangCombo();
	    lstParamVO.setValueList("langList");
	    lstParamVO.setKey("LANG_CODE");
	    lstParamVO.setValue("LANG_NAME");
	    paramVO1.setElement_dataType(DT_STRING);
	    paramVO1.setElement_type(COMBO_ELEMENT);
	    paramVO1.setId("lang_id_"+htmlPageRef);
	    paramVO1.setName(ConstantsCommon.LANG_PARAM);
	    paramVO1.setLabel("language");
	    paramVO1.setLabelId("langLblId_"+r_r);
	    StringBuffer onChangeFuncSb = new StringBuffer();
	    if(sessTransOnChangeSb.length() > 0)
	    {
		String sessTransOnChangeStr = sessTransOnChangeSb.toString();
		sessTransOnChangeStr = "{" + sessTransOnChangeStr.substring(0, sessTransOnChangeStr.length() - 1) + "}";
		onChangeFuncSb.append("updateTransSessionArgs(" + sessTransCnt + ",'lang_id_" + htmlPageRef + "',"
			+ sessTransOnChangeStr + ");");
	    }
	    if(repLangParamsIdSb.length() > 0)
	    {
		String repLangParamsIds = repLangParamsIdSb.toString();
		String repLangParamsNames = repLangParamsNameSb.toString();
		onChangeFuncSb.append("updateRepLangParams('" + htmlPageRef + "','" + repLangParamsIds + "','"+repLangParamsNames+"')");
	    }
	    if(onChangeFuncSb.length()>0)
	    {
		paramVO1.setOnchange(onChangeFuncSb.toString());
	    }
	    paramVO1.setValue(sessionCO.getLanguage());
	    paramVO1.setConsiderChoiceValue(ConstantsCommon.TRUE);
	    if("1".equals(reportCO.getLANG_INDEPENDENT_YN()))
	    {
		paramVO1.setVisible("false");
		paramVO1.setValue(ConstantsCommon.LANGUAGE_ENGLISH);
		paramVO1.setConsiderChoiceValue(ConstantsCommon.TRUE);
	    }
	    paramVO1.setRow(++count);
	    paramVO1.setColumn(1);
	    paramVO1.setListParamVO(lstParamVO);
	    if("0".equals(reportCO.getLANG_INDEPENDENT_YN()))
	    {
		formLst.add(paramVO1);
	    }
	    // report format DDL
	    lstParamVO = new ListParamVO();
	    paramVO = new DynamicParamsVO();
	    formatList = setCombo();
	    lstParamVO.setValueList("formatList");
	    lstParamVO.setKey("VALUE_CODE");
    	    lstParamVO.setValue("VALUE_DESC");
	    paramVO.setElement_dataType(DT_STRING);
	    paramVO.setElement_type(COMBO_ELEMENT);
	    paramVO.setId("format_id_"+htmlPageRef);
	    paramVO.setName("var_format");
	    paramVO.setLabel(getText("designer.defaultFormat"));
	    paramVO.setRow(count);
	    paramVO.setColumn(1);
	    paramVO.setListParamVO(lstParamVO);
	    paramVO.setValue(reportCO.getDEFAULT_FORMAT());
	    paramVO.setConsiderChoiceValue(ConstantsCommon.TRUE);
	    paramVO.setOnchange("hideShowCsvSepartor('" + htmlPageRef + "')");
	    formLst.add(paramVO);
	    
	    	// csv separators
		lstParamVO = new ListParamVO();
		paramVO = new DynamicParamsVO();
		csvSeparatorsList = setSepartor();
		lstParamVO.setValueList("csvSeparatorsList");
		lstParamVO.setKey("code");
		lstParamVO.setValue("description");
		paramVO.setElement_dataType(DT_STRING);
		paramVO.setElement_type(COMBO_ELEMENT);
		paramVO.setId("csvSeparatorId_" + htmlPageRef);
		paramVO.setName("var_separator");
		paramVO.setRow(count);
		paramVO.setColumn(1);
		if (ConstantsCommon.CSV_REP_FORMAT.equals(getVar_format()) 
			|| ConstantsCommon.TEXT_ROW_DATA_REP_FORMAT.equals(reportCO.getDEFAULT_FORMAT())) {
			paramVO.setVisible("true");
		} else {
			paramVO.setVisible("false");
		}
		paramVO.setListParamVO(lstParamVO);
		String csvSeparator = reportCO.getCSV_SEPARATOR();
		if ("\\t".equals(csvSeparator)) {
			csvSeparator = "\t";
		}
		paramVO.setValue(StringUtil.nullToEmpty(csvSeparator));
		paramVO.setConsiderChoiceValue(ConstantsCommon.TRUE);
		formLst.add(paramVO);
		
		// report connection DDL
		lstParamVO = new ListParamVO();
		paramVO = new DynamicParamsVO();
		connectionList = setConnectionList(); 
		lstParamVO.setValueList("connectionList");
		lstParamVO.setKey("CONN_ID");
		lstParamVO.setValue("CONN_DESC");
		paramVO.setElement_dataType(DT_STRING);
		paramVO.setElement_type(COMBO_ELEMENT);
		paramVO.setId("connection_id_" + htmlPageRef);
		paramVO.setName(ConstantsCommon.DB_PARAM);
		paramVO.setLabel(getText("connection.conDescription"));
		paramVO.setValue(db.toString());
		paramVO.setConsiderChoiceValue(ConstantsCommon.TRUE);
		
		paramVO.setRow(count);
		paramVO.setColumn(1);
		paramVO.setListParamVO(lstParamVO);
		formLst.add(paramVO);
		
		//put the language combo as hidden at the end of the row just for display purpose
		if("1".equals(reportCO.getLANG_INDEPENDENT_YN()))
		{
		   formLst.add(paramVO1);
		}
		// hide/show header and footer
		lstParamVO = new ListParamVO();
		paramVO = new DynamicParamsVO();
		chkNoHeadAndFootLst = setChkBox();
		lstParamVO.setValueList("chkNoHeadAndFootLst");
		lstParamVO.setKey("code");
		lstParamVO.setValue("description");
		if(ConstantsCommon.EXCEL_ROW_DATA_REP_FORMAT.equals(reportCO.getDEFAULT_FORMAT()) ||
			ConstantsCommon.TEXT_ROW_DATA_REP_FORMAT.equals(reportCO.getDEFAULT_FORMAT()))
		{
		    paramVO.setLabel(getText("reporting.noHeaders"));
		}
		else
		{
		    paramVO.setLabel(getText("reporting.noHeadAndFoot"));
		}
		paramVO.setElement_dataType(DT_STRING);
		paramVO.setElement_type(CHKBOX_ELEMENT);
		paramVO.setId("chkHeadFootId_" + htmlPageRef);
		// paramVO.setName("var_noHeadAndFoot");
		paramVO.setRow(++count);
		paramVO.setColumn(1);
		paramVO.setListParamVO(lstParamVO);
		if (BigDecimal.ZERO.toString().equals(
			reportCO.getSHOW_HEAD_FOOT())
				|| "true".equals(reportCO.getSHOW_HEAD_FOOT())) {
			noHeadFootMap.put(ConstantsCommon.HEAD_FOOT_PARAM, "true");
		} else {
			noHeadFootMap.put(ConstantsCommon.HEAD_FOOT_PARAM, "false");
		}
		paramVO.setName("noHeadFootMap.var_noHeadAndFoot");
		paramVO.setLabelId("chkHeadFootLblId_" + htmlPageRef);
		if (ConstantsCommon.SQL_REP_FORMAT.equals(getVar_format())) 
		{
			paramVO.setVisible("false");
		}
		else
		{
			paramVO.setVisible("true");
		}
		
		formLst.add(paramVO);
		
		// create the 'Save Copy' checkBox
		// if not called from designer and not fcr or ftr report
		paramVO = new DynamicParamsVO();
		lstParamVO = new ListParamVO();
		chkSaveList = setSnapshotCombo();
		lstParamVO.setValueList("chkSaveList");
		lstParamVO.setKey("code");
		lstParamVO.setValue("description");
		paramVO.setLabel(getText("saveSnapshot_key"));
		paramVO.setElement_dataType(DT_STRING);
		paramVO.setElement_type(COMBO_ELEMENT);
		paramVO.setId("chkId_" + htmlPageRef);
		paramVO.setName("var_chkName");
		paramVO.setRow(count);
		paramVO.setColumn(1);
		paramVO.setListParamVO(lstParamVO);
		formLst.add(paramVO);
	    
		
		int maxInactInterv = ServletActionContext.getRequest().getSession().getMaxInactiveInterval();
		int interv=1200000;
		if(maxInactInterv > 0)
		{
			// get the 20% of the session timeout value
			BigDecimal intervPerc = new BigDecimal((maxInactInterv / 5)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
			interv = (maxInactInterv - intervPerc.intValue()) * 1000;
		}
		
		paramVO = new DynamicParamsVO();
		paramVO.setElement_dataType(DT_NUMBER);
		 paramVO.setElement_type(HIDDEN_ELEMENT);
		paramVO.setId("hiddenSessionTimeOut_" + htmlPageRef);
		paramVO.setName(ConstantsCommon.SESSION_TIMEOUT_PARAM);
		paramVO.setValue(String.valueOf(interv));
		paramVO.setRow(count);
		paramVO.setColumn(1);
		formLst.add(paramVO);
		
	    // set the filter id hidden
	    DynamicParamsVO filterParamVO = new DynamicParamsVO();
	    filterParamVO.setElement_dataType(DT_STRING);
	    filterParamVO.setElement_type(HIDDEN_ELEMENT);
	    filterParamVO.setId("hiddenFilterId_" + htmlPageRef);
	    filterParamVO.setName(ConstantsCommon.FILTER_ID_PARAM);
	    filterParamVO.setRow(++count);
	    filterParamVO.setColumn(1);
	    if(defaultFilter != null)
	    {
		filterParamVO.setValue(defaultFilter.toString());
	    }
	    formLst.add(filterParamVO);
	    // set the filter id hidden
	    DynamicParamsVO filterParamTmpVO = new DynamicParamsVO();
	    filterParamTmpVO.setElement_dataType(DT_STRING);
	    filterParamTmpVO.setElement_type(HIDDEN_ELEMENT);
	    filterParamTmpVO.setId("hiddenFilterTmpId_" + htmlPageRef);
	    filterParamTmpVO.setRow(++count);
	    filterParamTmpVO.setColumn(1);
	    formLst.add(filterParamTmpVO);
	    //set the menuId as hidden
	    paramVO = new DynamicParamsVO();
	    paramVO.setElement_dataType(DT_STRING);
	    paramVO.setElement_type(HIDDEN_ELEMENT);
	    paramVO.setId("hiddenMenuId_"+htmlPageRef);
	    paramVO.setName(ConstantsCommon.MENU_ID_PARAM);
	    paramVO.setValue(r_r);
	    paramVO.setRow(++count);
	    paramVO.setColumn(1);
	    formLst.add(paramVO);
	    if(!StringUtil.nullToEmpty(r_a_p).isEmpty())
	    {
	    //set the r_a_p as hidden
	    paramVO = new DynamicParamsVO();
	    paramVO.setElement_dataType(DT_STRING);
	    paramVO.setElement_type(HIDDEN_ELEMENT);
	    paramVO.setId("hidden_r_a_p_"+htmlPageRef);
	    paramVO.setName(ConstantsCommon.REPORT_ARG_PARAM);
	    paramVO.setValue(r_a_p);
	    paramVO.setRow(++count);
	    paramVO.setColumn(1);
	    formLst.add(paramVO);
	    }
	    if(reportCO != null && reportCO.getREPORT_ID() != null)
	    {
		    //set report id as hidden
		    paramVO = new DynamicParamsVO();
		    paramVO.setElement_dataType(DT_STRING);
		    paramVO.setElement_type(HIDDEN_ELEMENT);
		    paramVO.setId("hiddenRepId");
		    paramVO.setName(ConstantsCommon.REPORT_ID_PARAM);
		    paramVO.setValue((reportCO.getREPORT_ID()).toString());
		    paramVO.setRow(count);
		    paramVO.setColumn(1);
		    formLst.add(paramVO);
	    }
	    
	    
	       
	    /*
	    //set the report db connection as hidden
	    paramVO = new DynamicParamsVO();
	    paramVO.setElement_dataType(DT_STRING);
	    paramVO.setElement_type(HIDDEN_ELEMENT);
	    paramVO.setId("hiddenDbId");
	    paramVO.setName("var_db");
	    paramVO.setValue(db.toString());
	    paramVO.setRow(count);
	    paramVO.setColumn(1);
	    formLst.add(paramVO);
	     */
	    
	    //set the app name as hidden
	    paramVO = new DynamicParamsVO();
	    paramVO.setElement_dataType(DT_STRING);
	    paramVO.setElement_type(HIDDEN_ELEMENT);
	    paramVO.setId("hiddenAppName");
	    paramVO.setName(ConstantsCommon.APP_NAME_PARAM);
	    //changed from appName to reportCO.getAPP_NAME after discussion with Anna
	    paramVO.setValue(reportCO.getAPP_NAME()); 
	    paramVO.setRow(count);
	    paramVO.setColumn(1);
	    formLst.add(paramVO);
	    
	  //set d_p param as hidden
		paramVO = new DynamicParamsVO();
		paramVO.setElement_dataType(DT_STRING);
		paramVO.setElement_type(HIDDEN_ELEMENT);
		paramVO.setId("hiddenDP");
		paramVO.setName(ConstantsCommon.DYNAMIC_SCREEN_PARAM);
		paramVO.setValue("1");
		paramVO.setRow(count);
		paramVO.setColumn(1);
		formLst.add(paramVO);
	    
        //super.fillFormElements(formLst, "","dynParamFrmId"+r_r.replace("-", "_"),"_blank");
	super.fillFormElements(formLst, "","dynParamFrmId"+htmlPageRef,"_blank");
	}
	catch (ReportException e) 
	{
	     if(Integer.valueOf(1).equals(e.getMsgType()))
	     {
		 BaseException ba = retBaseExceptionFromRepException(e);
		 throw ba;
	     }
	     else
	     {
		 throw new BaseException(e.getMessage());
	     }
	}
	catch(BaseException e)
	{
	   throw e;	    
	}
    }
    
    /**
     * Method that dynamically adds the livesearch parameters
     * @param argumentsList
     * @param idSched
     * @param paramVO
     * @return
     */
    public DynamicParamsVO addParamsLiveSearch(List<IRP_REP_ARGUMENTSCO> argumentsList, String idSched,
	    DynamicParamsVO paramVO)
    {
	DynamicParamsVO lParamVO = paramVO;
	// adding the parameters
	StringBuffer parameters = new StringBuffer();
	IRP_REP_ARGUMENTSCO arg;
	for(int i = 0; i < argumentsList.size(); i++)
	{
	    arg = argumentsList.get(i);
	    parameters.append(ConstantsCommon.PARAM_TILDA + arg.getARGUMENT_NAME() + "~" + arg.getARGUMENT_TYPE() + ":");
	    if(new BigDecimal(3).equals(arg.getARGUMENT_SOURCE()) || new BigDecimal(10).equals(arg.getARGUMENT_SOURCE()))
	    {
		parameters.append("lookuptxt_");
	    }
	    parameters.append("p_").append("param_" + idSched).append(arg.getARGUMENT_NAME()).append("_").append(
		    arg.getARGUMENT_TYPE()).append("_").append(htmlPageRef);
	    parameters.append(",");
	}
	parameters.append("var_menuId:~CONST_" + htmlPageRef + ",updates:'" + lParamVO.getName() + "',conId:connection_id_"+htmlPageRef);
	lParamVO.setParameters(parameters.toString());
	return lParamVO;
    }
    
    private List setChkBox()
    {
	ArrayList<ReportFormat> repChkList = new ArrayList<ReportFormat>();
	repChkList.add(new ReportFormat("","true"));
	return repChkList;
    }
    
    public List<SYS_PARAM_LOV_TRANSVO> setCombo() 
    {
	List<SYS_PARAM_LOV_TRANSVO> reportFormatsList = new ArrayList<SYS_PARAM_LOV_TRANSVO>();
	try
	{
	    	SessionCO sessionCO = returnSessionObject();
		SYS_PARAM_LOV_TRANSVO sysParamLovVO= new SYS_PARAM_LOV_TRANSVO();
		sysParamLovVO.setLOV_TYPE_ID(ConstantsCommon.FILE_FORMAT_LOV_TYPE); 
		sysParamLovVO.setLANG_CODE(sessionCO.getLanguage());
		
		HashMap<String,Object> sysParamLovVOMap=new HashMap<String,Object>();
		String[] propsArr= ConstantsCommon.getLookupListMap_PROPS.toArray(new String[ConstantsCommon.getLookupListMap_PROPS.size()]);
		PathPropertyUtil.copyProperties(sysParamLovVO, sysParamLovVOMap,false,propsArr);
		ArrayList<HashMap<String,Object>>  retLst=(ArrayList<HashMap<String,Object>>) commonReportingBO.getLookupListMap(sysParamLovVOMap);
		HashMap<String,Object> hm;
		propsArr= ConstantsCommon.getLookupListMapRet_PROPS.toArray(new String[ConstantsCommon.getLookupListMapRet_PROPS.size()]);
		for(int i=0;i<retLst.size();i++)
		{
		    hm=retLst.get(i);
		    sysParamLovVO = new SYS_PARAM_LOV_TRANSVO();
		    PathPropertyUtil.copyProperties(hm, sysParamLovVO,false,propsArr);
		    reportFormatsList.add(sysParamLovVO);
		}
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return reportFormatsList;
		
    }
    
    public List setLangCombo()
    {
		try
		{
			SessionCO sessionCO = returnSessionObject();
			SelectSC sc= new SelectSC();
			sc.setLovTypeId(ConstantsCommon.LANGUAGES_LOV_TYPE);
			sc.setLanguage(sessionCO.getLanguage());
			langList= commonLibBO.returnLanguages(sc);
		}
		catch(BaseException e)
		{
		    log.error(e,e.getMessage());
		}
		return langList;
    }
    
    public List setSnapshotCombo()
    {
    	ArrayList<ReportFormat> snapShotList = new ArrayList<ReportFormat>();
    	snapShotList.add(new ReportFormat("", ""));
    	snapShotList.add(new ReportFormat(getText("reporting.db"), "DB"));
    	snapShotList.add(new ReportFormat(getText("reporting.repository"), "Repository"));
    	return snapShotList;
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
    public List setSepartor() {
	ArrayList<SepartorFormat> separatorsList = new ArrayList<SepartorFormat>();
	separatorsList.add(new SepartorFormat(",", ","));
	separatorsList.add(new SepartorFormat(getText("reporting.tab"), "\t"));
	return separatorsList;
}

    public List<IRP_CONNECTIONSVO> setConnectionList() {
	List<IRP_CONNECTIONSVO> conList = new ArrayList<IRP_CONNECTIONSVO>();
	conList.add(new IRP_CONNECTIONSVO());
	try
	{
	    List<HashMap<String,Object>> retLst=commonReportingBO.returnConnectionsList();
	    List<IRP_CONNECTIONSVO> newConLst=new ArrayList<IRP_CONNECTIONSVO>();
	    IRP_CONNECTIONSVO conVO;
	    HashMap<String,Object> hm;
	    String[] propsArr= ConstantsCommon.returnConnectionsListRet_PROPS.toArray(new String[ConstantsCommon.returnConnectionsListRet_PROPS.size()]);
	    for(int i=0;i<retLst.size();i++)
	    {
		hm=retLst.get(i);
		conVO=new IRP_CONNECTIONSVO();
		PathPropertyUtil.copyProperties(hm,conVO,false,propsArr);
		newConLst.add(conVO);
	    }
	    conList.addAll(newConLst);
	}
	catch(Exception e)
	{
	    log.error(e.getMessage());
	}
	return conList;
		
	}
    
    public void fillArgFunctionMap(HashMap<String, HashMap<Integer, Object>> argFunctionMap,
	    List<IRP_REP_ARGUMENTSCO> argumentsList)
    {
	IRP_REP_ARG_CONSTRAINTSCO constrCO;
	String argName;

	for(IRP_REP_ARGUMENTSCO argObj : argumentsList)
	{
	    argName = argObj.getARGUMENT_NAME();
	    constrCO = argObj.getIrpRepArgConstraintCO();
	    if(constrCO.getCONDITION() != null)
	    {
		if(argFunctionMap.get(argName) == null)
		{
		    HashMap<Integer, Object> internalMap = new HashMap<Integer, Object>();
		    internalMap.put(0, "");
		    argFunctionMap.put(argName, internalMap);
		}
		else if(argFunctionMap.get(argName).get(0) == null)
		{
		    HashMap<Integer, Object> internalMap = argFunctionMap.get(argName);
		    internalMap.put(0, "");
		    argFunctionMap.put(argName, internalMap);
		}
		checkArgsUsedInExpr(argName, constrCO.getCONDITION(), argumentsList, argFunctionMap, 0);
	    }
	    if(constrCO.getSHOW_EXPR() != null)
	    {

		if(argFunctionMap.get(argName) == null)
		{
		    HashMap<Integer, Object> internalMap = new HashMap<Integer, Object>();
		    internalMap.put(1, "");
		    argFunctionMap.put(argName, internalMap);
		}
		else if(argFunctionMap.get(argName).get(1) == null)
		{
		    HashMap<Integer, Object> internalMap = argFunctionMap.get(argName);
		    internalMap.put(1, "");
		    argFunctionMap.put(argName, internalMap);
		}
		checkArgsUsedInExpr(argName, constrCO.getSHOW_EXPR(), argumentsList, argFunctionMap, 1);
	    }
	    if(constrCO.getHIDE_EXPR() != null)
	    {
		if(argFunctionMap.get(argName) == null)
		{
		    HashMap<Integer, Object> internalMap = new HashMap<Integer, Object>();
		    internalMap.put(2, "");
		    argFunctionMap.put(argName, internalMap);
		}
		else if(argFunctionMap.get(argName).get(2) == null)
		{
		    HashMap<Integer, Object> internalMap = argFunctionMap.get(argName);
		    internalMap.put(2, "");
		    argFunctionMap.put(argName, internalMap);
		}
		checkArgsUsedInExpr(argName, constrCO.getHIDE_EXPR(), argumentsList, argFunctionMap, 2);
	    }
	}
    }

    /**
     * Method that checks the argument that are used in an expression in order
     * to add js function to them
     * 
     * @param argName
     * @param expression
     * @param argumentsList
     * @param argFunctionMap
     * @param option
     */
    public void checkArgsUsedInExpr(String argName, String expression, List<IRP_REP_ARGUMENTSCO> argumentsList,
	    HashMap<String, HashMap<Integer, Object>> argFunctionMap, int option)
    {
	HashMap<Integer, Object> internalMap;
	for(IRP_REP_ARGUMENTSCO argObj : argumentsList)
	{
	    if(expression.indexOf(argObj.getARGUMENT_NAME()) != -1 && !argName.equals(argObj.getARGUMENT_NAME()))
	    {
		if(argFunctionMap.get(argObj.getARGUMENT_NAME()) == null)
		{
		    internalMap = new HashMap<Integer, Object>();
		    internalMap.put(option, "");
		    argFunctionMap.put(argObj.getARGUMENT_NAME(), internalMap);
		}
		else if(argFunctionMap.get(argObj.getARGUMENT_NAME()).get(option) == null)
		{
		    internalMap = argFunctionMap.get(argObj.getARGUMENT_NAME());
		    internalMap.put(option, "");
		    argFunctionMap.put(argObj.getARGUMENT_NAME(), internalMap);
		}
	    }
	}
    }
    
    /**
     * Method that fills combo element with related records
     * @param queryId
     * @param repCO
     * @param argumentId
     * @return
     */
    public List retQryCombo(BigDecimal queryId, IRP_AD_HOC_REPORTCO repCO, IRP_REP_ARGUMENTSCO argObj)
    {
	try
	{
	    HashMap<String, String> hmQryParam = new HashMap<String, String>();
	    Object argSessionValue;
	    BigDecimal argumentId = argObj.getARGUMENT_ID();
	    LinkedHashMap argsMap = repCO.getArgumentsList();
	    SessionCO sessionCO = returnSessionObject();
	    String sessionParamName;
	    ArrayList<IRP_REP_ARGUMENTSCO> argsList = new ArrayList(argsMap.values());
	    DynLookupSC dynLookupSC = new DynLookupSC();
	    dynLookupSC.setIsSybase(commonLibBO.returnIsSybase());
	    dynLookupSC.setQryId(queryId.toString());
	    dynLookupSC.setConnId(repCO.getCONN_ID());
	    IRP_AD_HOC_REPORTSC reportSC = new IRP_AD_HOC_REPORTSC();
	    reportSC.setREPORT_ID(repCO.getREPORT_ID());
	    reportSC.setReportArgumentId(argumentId);
	    reportSC.setDefaultSrc(argObj.getQUERY_ID_DEFAULT()==null?BigDecimal.ONE:new BigDecimal(2));
	    HashMap<String, Object> repSCMap = new HashMap<String, Object>();
	    String[] propsArr= ConstantsCommon.retQryArgMapping_PROPS.toArray(new String[ConstantsCommon.retQryArgMapping_PROPS.size()]);
	    PathPropertyUtil.copyProperties(reportSC, repSCMap, false, propsArr);
	    List<IRP_QUERY_ARG_MAPPINGCO>  listDfltSrc=fillQryArgsMapList(reportSC);
	    HashMap<String,Object> retMap = commonReportingBO.returnQueryById(queryId, true);
   	    IRP_AD_HOC_QUERYCO query=(IRP_AD_HOC_QUERYCO) PathPropertyUtil.convertToObject(retMap, IRP_AD_HOC_QUERYCO.class);
	    for(int j = 0; j < query.getSqlObject().getArgumentsList().size(); j++)
	    {
		LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> arguments = query.getSqlObject().getArgumentsList();
		ArrayList<IRP_REP_ARGUMENTSCO> argsQryList = new ArrayList(arguments.values());

		for(int m = 0; m < listDfltSrc.size(); m++)
		{
		    for(int n = 0; n < (argsQryList.size() < listDfltSrc.size() ? argsQryList.size() : listDfltSrc
			    .size()); n++)
		    {
			if(listDfltSrc.get(m).getIrpQueryArgsMappingVO().getQUERY_ARG_NAME().equals(
				argsQryList.get(n).getARGUMENT_NAME()))
			{
			    listDfltSrc.get(m).setARGUMENT_TYPE(argsQryList.get(n).getARGUMENT_TYPE());
			    if(listDfltSrc.get(m).getIrpQueryArgsMappingVO().getSTATIC_VALUE() == null
				    || ("").equals(listDfltSrc.get(m).getIrpQueryArgsMappingVO().getSTATIC_VALUE()))
			    {
				for(int a = 0; a < argsList.size(); a++)
				{
				    if(listDfltSrc.get(m).getIrpQueryArgsMappingVO().getREPORT_MAPPED_ARG_NAME()
					    .equals(argsList.get(a).getARGUMENT_NAME()))
				    {
					if(argsList.get(a).getARGUMENT_SOURCE().equals(
						ConstantsCommon.SESSION_ARG_SOURCE)
						|| argsList.get(a).getARGUMENT_SOURCE().equals(
							ConstantsCommon.TRANS_SESSION_ARG_SOURCE))
					{
					    sessionParamName = argsList.get(a).getSESSION_ATTR_NAME();
					    if(ConstantsCommon.LANGUAGE_ARABIC.equals(sessionCO.getLanguage())
						    && ConstantsCommon.COMP_NAME_EXP_VAR.equals(sessionParamName))
					    {
						sessionParamName = ConstantsCommon.COMP_AR_NAME_SESSION;
					    }
					    argSessionValue = PathPropertyUtil.returnProperty(sessionCO,
						    sessionParamName);
					    hmQryParam.put(listDfltSrc.get(m).getIrpQueryArgsMappingVO()
						    .getQUERY_ARG_NAME(), argSessionValue.toString());
					}
					else if(argsList.get(a).getARGUMENT_SOURCE().equals(new BigDecimal(5)))
					{
					    hmQryParam.put(listDfltSrc.get(m).getIrpQueryArgsMappingVO()
						    .getQUERY_ARG_NAME(), htmlPageRef);
					}
					else
					{
					    hmQryParam.put(listDfltSrc.get(m).getIrpQueryArgsMappingVO()
						    .getQUERY_ARG_NAME(), argsList.get(a).getARGUMENT_VALUE());
					}
				    }
				}
			    }
			    else
			    {
				hmQryParam.put(listDfltSrc.get(m).getIrpQueryArgsMappingVO().getQUERY_ARG_NAME(),
					listDfltSrc.get(m).getIrpQueryArgsMappingVO().getSTATIC_VALUE());
			    }
			}
		    }
		}

	    }
	    HashMap<String,Object> dynLookupSCMap=new HashMap<String,Object>();
	    String[] propsQryResArr= ConstantsCommon.returnQryResult_PROPS.toArray(new String[ConstantsCommon.returnQryResult_PROPS.size()]);
	    PathPropertyUtil.copyProperties(dynLookupSC, dynLookupSCMap,false,propsQryResArr);
	    dynLookupSC.setHmQryParam(hmQryParam);
	    dynLookupSC.setCompCode(sessionCO.getCompanyCode());
	    dynLookupSC.setBranchCode(sessionCO.getBranchCode());
	    dynLookupSC.setUserId(sessionCO.getUserName());
	    dynLookupSC.setCurrAppName(sessionCO.getCurrentAppName());
	    dynLookupSC.setNbRec(commonReportingBO.returnQryResultCnt(dynLookupSCMap));
	    dynLookupSC.setRecToskip(0);
	    PathPropertyUtil.copyProperties(dynLookupSC, dynLookupSCMap,false,propsQryResArr);
	    List queryComboList = commonReportingBO.returnQryResult(dynLookupSCMap);
	    return queryComboList;
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return null;
    }
	
    private BaseException retBaseExceptionFromRepException(ReportException re)
    {
	BaseException ba = new BaseException(re.getMessage(),re.getParams());
	ba.setErrorCode(re.getErrorCode());
	return ba;
    }

}
