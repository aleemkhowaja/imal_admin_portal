package com.path.actions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.ListUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONException;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.reporting.CommonReportingBO;
import com.path.dbmaps.vo.IRP_REP_FILTERSVO;
import com.path.dbmaps.vo.SYS_PARAM_LOV_TRANSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.reporting.exception.ReportException;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.reporting.CONDITION_OBJECT;
import com.path.vo.reporting.CommonReportingSessionCO;
import com.path.vo.reporting.GROUP_BYSC;
import com.path.vo.reporting.IRP_AD_HOC_QUERYCO;
import com.path.vo.reporting.IRP_AD_HOC_REPORTCO;
import com.path.vo.reporting.IRP_ENTITIESCO;
import com.path.vo.reporting.IRP_FIELDSCO;
import com.path.vo.reporting.IRP_REP_ARGUMENTSCO;
import com.path.vo.reporting.IRP_REP_FILTERSSC;
import com.path.vo.reporting.QRY_GRIDSC;
import com.path.vo.reporting.SQL_OBJECT;

public class CommonReportingAction extends LookupBaseAction
{
    private CommonReportingBO commonReportingBO;
    HttpServletResponse response = ServletActionContext.getResponse();
    private String updates,fromAddButton;
    private String update1;
    private String updates1;
    private String qryType;
    IRP_AD_HOC_REPORTCO reportCO;
    private final QRY_GRIDSC qryGridSC = new QRY_GRIDSC();
    private CONDITION_OBJECT conditionObject;
    protected Long locIndex;
    protected List<IRP_FIELDSCO> fields1 = new ArrayList<IRP_FIELDSCO>();
    protected List<IRP_FIELDSCO> fields2 = new ArrayList<IRP_FIELDSCO>();
    private String conditionEntity;
    private String conditionIndex;
    private String conditionField;
    protected String ARGUMENT1;
    protected String ARGUMENT2;
    protected String conditionRecordsCount;
    protected String tab;
    private List<SYS_PARAM_LOV_TRANSVO> conjunctionsList;
    private List<IRP_ENTITIESCO> entitiesList;
    private ArrayList<SYS_PARAM_LOV_TRANSVO> operatorsList;
    private ArrayList<IRP_REP_ARGUMENTSCO> argumentsList = new ArrayList<IRP_REP_ARGUMENTSCO>();
    private String orderMsg;
    private String qryField;
    private String htmlTableId;
    private String qryNamee;
    private String grpName;
    private BigDecimal grpId;
    GROUP_BYSC sc = new GROUP_BYSC();
    private ArrayList fieldsCmbo =new ArrayList();
    private String qryFieldName;
    private Long fieldIndex;
    private String htmlPageRef; // page reference (- replaced by _)
    private IRP_REP_FILTERSSC filtersSC = new IRP_REP_FILTERSSC();

    public IRP_REP_FILTERSSC getFiltersSC()
    {
	return filtersSC;
    }

    public void setFiltersSC(IRP_REP_FILTERSSC filtersSC)
    {
	this.filtersSC = filtersSC;
    }

	
    
	public String getHtmlPageRef() {
		return htmlPageRef;
	}

	public String getTab()
	{
	    return tab;
	}

	public void setTab(String tab)
	{
	    this.tab = tab;
	}

	public void setHtmlPageRef(String htmlPageRef) {
		this.htmlPageRef = htmlPageRef;
	}
    
    public void setCommonReportingBO(CommonReportingBO commonReportingBO)
    {
        this.commonReportingBO = commonReportingBO;
    }
    
    public String getQryFieldName() {
	return qryFieldName;
    }

    public void setQryFieldName(String qryFieldName) {
	this.qryFieldName = qryFieldName;
    }
    
    public Long getFieldIndex() {
	return fieldIndex;
    }
    
    public void setFieldIndex(Long fieldIndex) {
    	this.fieldIndex = fieldIndex;
    }
    
    public String getOrderMsg()
    {
	return orderMsg;
    }

    public void setOrderMsg(String orderMsg)
    {
	this.orderMsg = orderMsg;
    }
    
    public String getQryField() {
	return qryField;
    }
    
    public void setQryField(String qryField) {
    	this.qryField = qryField;
    }
    
    public String getHtmlTableId() {
	return htmlTableId;
    }
    
    public void setHtmlTableId(String htmlTableId) {
    	this.htmlTableId = htmlTableId;
    }
    
    public String getQryNamee() {
	return qryNamee;
    }
    
    public void setQryNamee(String qryNamee) {
    	this.qryNamee = qryNamee;
    }

    public String getGrpName() {
	return grpName;
    }
    
    public void setGrpName(String grpName) {
    	this.grpName = grpName;
    }	
    
    public BigDecimal getGrpId() {
	return grpId;
    }
    
    public void setGrpId(BigDecimal grpId) {
    	this.grpId = grpId;
    }

    public String getUpdates()
    {
        return updates;
    }
    public void setUpdates(String updates)
    {
        this.updates = updates;
    }
    
    public String getUpdate1() 
    {
	return update1;
    }
    
    public void setUpdate1(String update1) 
    {
    	this.update1 = update1;
    }
    
    public String getUpdates1() 
    {
	return updates1;
    }

    public void setUpdates1(String updates1) 
    {
	this.updates1 = updates1;
    }
    
    public String getFromAddButton()
    {
        return fromAddButton;
    }

    public void setFromAddButton(String fromAddButton)
    {
        this.fromAddButton = fromAddButton;
    }

    public String openPrevOrder()throws Exception
    {
    	htmlPageRef = get_pageRef().replace("-", "_");
    	setUpdate1("fromPrev");
    	return "order";
    }
    
    public String changeOrderPosition() throws JSONException
    {
	try
	{
	    Long orderId=Long.valueOf(getUpdates());
	    String mode=getUpdates1(); // 1 :Up   ;    2:Down
	    CommonReportingSessionCO repSessionCO=retPrevRepSessionCO() ;
	    IRP_AD_HOC_REPORTCO repCO=repSessionCO.getReportCO();
		
	    IRP_FIELDSCO feCO;
	    int k=0;
	    
	    if(getUpdate1()!=null && getUpdate1().equals("fromPrev"))
	    {
		List<IRP_FIELDSCO> prevOrderLst=repCO.getPrevOrderList();
		ArrayList <IRP_FIELDSCO> newPrevOrderLst=new ArrayList<IRP_FIELDSCO>();
		
		//get the position of the object that we are moving 
		for(int i=0;i<prevOrderLst.size();i++)
		{
		    feCO=(IRP_FIELDSCO)prevOrderLst.get(i);
		    if(feCO.getIndex().equals(orderId))
		    {
			k=i;
			break;
		    }
		}
		//change the position
		if("1".equals(mode))
		{
		    if(k!=0)
		    {
			for(int j=0;j<prevOrderLst.size();j++)
			{
			    if(j==k-1)
			    {
				newPrevOrderLst.add(prevOrderLst.get(j+1));
			    }
			    else if(j==k)
			    {
				newPrevOrderLst.add(prevOrderLst.get(j-1));
			    }
			    else
			    {
				newPrevOrderLst.add(prevOrderLst.get(j));
			    }
			}
			repCO.setPrevOrderList(newPrevOrderLst);	
		    }
		}
		else
		{
		    if(k!=prevOrderLst.size()-1)
		    {
			for(int j=0;j<prevOrderLst.size();j++)
			{
			    if(j==k)
			    {
				newPrevOrderLst.add(prevOrderLst.get(j+1));
			    }
			    else if(j==k+1)
			    {
				newPrevOrderLst.add(prevOrderLst.get(j-1));
			    }
			    else
			    {
				newPrevOrderLst.add(prevOrderLst.get(j));
			    }
			}
			repCO.setPrevOrderList(newPrevOrderLst);	
		    }
		}
	    }
	}
	catch(Exception e)
	{
	    log.error(e,"");
	}
	return SUCCESS;
    }
    
    public String conditionGridUrl()
    {
	String fromPrev=getUpdate1();
	CommonReportingSessionCO repSessionCO ;		
		
	copyproperties(qryGridSC);
	LinkedHashMap<Long, CONDITION_OBJECT> conditions ;
	if(fromPrev!=null && fromPrev.equals("prevFilter"))
	{
	    repSessionCO=retPrevRepSessionCO();
	    IRP_AD_HOC_REPORTCO repCO=repSessionCO.getReportCO();
	    conditions=repCO.getPrevFilterMap();
	}
	else
	{
	    SQL_OBJECT sqlObj=retSqlObj();
//	    if(retSqlObj()==null)
//	    {
//		repSessionCO.setSqlObj(new SQL_OBJECT());
//	    }
	    if(sqlObj.getConditionsList()==null)
	    {
		sqlObj.setConditionsList(new LinkedHashMap<Long, CONDITION_OBJECT>());
	    }
	    conditions =sqlObj.getConditionsList();
	}
	
	int nbRec=qryGridSC.getNbRec();
	int recToSkip=qryGridSC.getRecToskip();
	int maxRec=nbRec+recToSkip;
	if(conditions.size()<maxRec)
	{
	    maxRec=conditions.size();
	}
	ArrayList<CONDITION_OBJECT> lst=new ArrayList<CONDITION_OBJECT>();
	for(int i=recToSkip;i<maxRec;i++)
	{
	    CONDITION_OBJECT condition=(CONDITION_OBJECT) conditions.values().toArray()[i];
	    if(condition.getConjunction()!=null && condition.getConjunction().equalsIgnoreCase("and"))
	    {
		condition.setConjunctionName(getText("criteria.and"));
	    }
	    else if(condition.getConjunction()!=null && condition.getConjunction().equalsIgnoreCase("or"))
	    {
		condition.setConjunctionName(getText("criteria.or"));
	    }
	    else
	    {
		condition.setConjunctionName(condition.getConjunction());
	    }
	    
	    lst.add(condition);
	}
		
	setRecords(conditions.size());
	setGridModel(lst);
	
	return SUCCESS;
    }
    
    public String loadOrderGrid() 
    {
	try
	{
	    IRP_FIELDSCO irpFieldCO;
	    ArrayList<IRP_FIELDSCO> lst=new ArrayList<IRP_FIELDSCO>();
	    copyproperties(qryGridSC);
	    int nbRec=qryGridSC.getNbRec();
	    int recToSkip=qryGridSC.getRecToskip();
	    int maxRec=nbRec+recToSkip;
	    
	    String fromPrv=getUpdates1();
	    if(fromPrv!=null && fromPrv.equals("fromPrev"))
	    {
		CommonReportingSessionCO repSessionCO=retPrevRepSessionCO() ;
		IRP_AD_HOC_REPORTCO repCO=repSessionCO.getReportCO();
		IRP_FIELDSCO feCO;
		IRP_FIELDSCO newFeCO;
		List<IRP_FIELDSCO> prevOrderLst=repCO.getPrevOrderList();
		if(prevOrderLst.isEmpty()) //fill the prevOrder list
		{
		    SQL_OBJECT sqlObj=repCO.getQueriesList().get(0).getSqlObject();
		    LinkedHashMap<Long,IRP_FIELDSCO> feMap=sqlObj.getFields();
		    Iterator it=feMap.values().iterator();
		    while(it.hasNext())
		    {
			feCO=(IRP_FIELDSCO)it.next();
			newFeCO=new IRP_FIELDSCO();
			newFeCO.setIndex(feCO.getIndex());
			newFeCO.setFIELD_DB_NAME(feCO.getFIELD_DB_NAME());
			newFeCO.setEntityAliasWithCount(feCO.getEntityAliasWithCount());
			newFeCO.setFIELD_ALIAS(feCO.getFIELD_ALIAS());
			newFeCO.setENTITY_ALIAS(feCO.getENTITY_ALIAS());
			newFeCO.setLabelAlias(feCO.getLabelAlias());
			if(feCO.getHasBusinessName()==1)
			{
				prevOrderLst.add(newFeCO);
			}
		    }
		    //Add expressions
		    LinkedHashMap< Long, IRP_FIELDSCO> exprMap=sqlObj.getExpressionFields();
		    it=exprMap.values().iterator();
		    while(it.hasNext())
		    {
			feCO=(IRP_FIELDSCO)it.next();
			newFeCO=new IRP_FIELDSCO();
			newFeCO.setIndex(feCO.getIndex());
			newFeCO.setFIELD_DB_NAME(feCO.getLabelAlias());
			newFeCO.setEntityAliasWithCount(getText("expr.ExpressionList"));
			newFeCO.setFIELD_ALIAS(feCO.getLabelAlias());
			newFeCO.setENTITY_ALIAS(feCO.getENTITY_ALIAS());
			newFeCO.setLabelAlias(feCO.getLabelAlias());
			prevOrderLst.add(newFeCO);
			
		    }
		    
		}
		if(prevOrderLst.size()<maxRec)
		{
		    maxRec=prevOrderLst.size();
		}
		
		for(int i=recToSkip;i<maxRec;i++)
		{
		    lst.add((IRP_FIELDSCO) prevOrderLst.get(i));
		}
		
		setRecords(prevOrderLst.size());
	    }
	    else
	    {
		SQL_OBJECT sqlObj=retSqlObj();
		LinkedHashMap<Long,IRP_FIELDSCO> feMap=sqlObj.getFields();
		
		if(feMap.size()<maxRec)
		{
		    maxRec=feMap.size();
		}
		for(int i=recToSkip;i<maxRec;i++)
		{
		    lst.add((IRP_FIELDSCO) feMap.values().toArray()[i]);
		}
		
		setRecords(feMap.size());
	    }
	    if(fromAddButton == null)
	    {
		// check if sorting exist in IRP_REP_SORT table
		htmlPageRef = get_pageRef().replace("-", "_");
		SessionCO sessionCO = returnSessionObject();
		CommonReportingSessionCO repSessionCO = returnReportingSessionObject(htmlPageRef);
		HashMap<String, Object> lstSortingMap = new HashMap<String, Object>();
		lstSortingMap.put("reportId", repSessionCO.getReportCO().getREPORT_ID());
		lstSortingMap.put("userId", sessionCO.getUserName());
		lstSortingMap = commonReportingBO.retSortingListFromIrpRepSort(lstSortingMap);

		ArrayList<HashMap<String, Object>> SortingMapList = new ArrayList<HashMap<String, Object>>();
		SortingMapList = (ArrayList<HashMap<String, Object>>) lstSortingMap.get("irpFieldsCOList");
		if(SortingMapList != null && !SortingMapList.isEmpty())
		{
		    HashMap<String, Object> SortMap;
		    Iterator<HashMap<String, Object>> itSort = SortingMapList.iterator();
		    while(itSort.hasNext())
		    {
			SortMap = itSort.next();
			irpFieldCO = (IRP_FIELDSCO) PathPropertyUtil.convertToObject(SortMap, IRP_FIELDSCO.class);
			for(int j = 0; j < lst.size(); j++)
			{
			    if(lst.get(j).getFIELD_ALIAS().equals(irpFieldCO.getFIELD_ALIAS()))
			    {
				lst.get(j).setOrder(irpFieldCO.getOrder());
			    }
			}
		    }
		}
	    }
	    setGridModel(lst);
	}
	catch(Exception e)
	{
	    //log.error(e,"Error loading orders");
	    handleException(e, "Error loading orders","loadOrders.exceptionMsg._key");
	}
	return SUCCESS;
    }
    
    public String validateOrder() throws JSONException
    {
	try
	{
	    if(updates!=null && !updates.equals(""))
	    {
		GridUpdates gu = getGridUpdates(updates, IRP_FIELDSCO.class);
		ArrayList lstMod = gu.getLstModify();
		IRP_FIELDSCO feCO;
		IRP_FIELDSCO origFeCO;
		if(getUpdate1()!=null && getUpdate1().equals("fromPrev"))
		{	
		    gu = getGridUpdates(updates, IRP_FIELDSCO.class);
		    lstMod = gu.getLstModify();
		    CommonReportingSessionCO repSessionCO=retPrevRepSessionCO() ;
		    IRP_AD_HOC_REPORTCO repCO=repSessionCO.getReportCO();
		    List<IRP_FIELDSCO> prevOrderLst=repCO.getPrevOrderList();
		    updates1="";
		    HashMap<Long, IRP_FIELDSCO> grpMap=repCO.getPrevGrpMap();
		    for(int j=0;j<lstMod.size();j++) // find if one of requested orderBy is already used as groupBy 
		    {
			feCO=(IRP_FIELDSCO)lstMod.get(j);
			if(grpMap.get(feCO.getIndex())!=null && !(("").equals(feCO.getOrder()))  )
			{
			    updates1+= feCO.getFIELD_ALIAS()+" ,";
			}
		    }
		    if(!("").equals(updates1))
		    {
			updates1=updates1.substring(0,updates1.length()-1);
		    }
		    if(("").equals(updates1))// if doesn't exist,save order
		    {
			for(int j=0;j<lstMod.size();j++) 
			{
				feCO=(IRP_FIELDSCO)lstMod.get(j);
				for(int i=0;i<prevOrderLst.size();i++)
				{
					origFeCO=(IRP_FIELDSCO)prevOrderLst.get(i);
					if(origFeCO.getIndex().equals(feCO.getIndex()))
					{
						origFeCO.setOrder(feCO.getOrder());
						break;
					}
				}
			}
		    }
		}
		else
		{
		    SQL_OBJECT sqlObj=retSqlObj();
		    HashMap<Long,IRP_FIELDSCO> feMap=sqlObj.getFields();
		    for(int j=0;j<lstMod.size();j++) 
		    {
			feCO=(IRP_FIELDSCO)lstMod.get(j);
			origFeCO=feMap.get(feCO.getIndex());
			origFeCO.setOrder(feCO.getOrder());
		    }
		}
	    }
	}	
	catch(Exception e)
	{
	    //log.error(e,"Error validating order");
	    handleException(e, "Error validating order","validateOrder.exceptionMsg._key");
	}
	return SUCCESS;
    }
    
    public String openPrevFilter()throws Exception
    {
    	htmlPageRef = get_pageRef().replace("-", "_");	
		setUpdate1("prevFilter");
		setQryType(returnQryType());
		return "conditions";
    }
    
    public String openPrevGrp()throws Exception
    {
    	htmlPageRef = get_pageRef().replace("-", "_");
		setUpdates("prevGrp");
		//setQryType(returnQryType());
		return "groupBy";
    }
    
    public String openGroupBy()
    {
	setUpdates("");
	return "groupBy";
    }
    
    public String returnQryType()
    {
	String result=ConstantsCommon.SQB_QRY_TYPE;
	try 
	{
	    SQL_OBJECT sqlObj;
	    sqlObj = retPrevSqlObj();
	    if(sqlObj!=null && sqlObj.getSqbSyntax()==null && sqlObj.getEntities().size()>0)
	    {
		result=ConstantsCommon.QBE_QRY_TYPE;
	    }
	}
	catch (Exception e) 
	{
	    log.error(e,"");
	}
	return result;
    }
    
    public SQL_OBJECT retPrevSqlObj() throws Exception
    {
	CommonReportingSessionCO repSessionCO=retPrevRepSessionCO();
	IRP_AD_HOC_REPORTCO repCO=repSessionCO.getReportCO();
	return repCO.getQueriesList().get(0).getSqlObject();
    }
    
    public CommonReportingSessionCO retPrevRepSessionCO()
    {
	String pageRef=get_pageRef();
	CommonReportingSessionCO repSessionCO;
	//stoped by haytham.k for fcr reports
	//if(pageRef!=null && !pageRef.endsWith("DY0"))
	//{
	    repSessionCO = returnReportingSessionObject(pageRef);
	//}
	/*
	else
	{
	    repSessionCO = returnReportingSessionObject();
	}
	*/
	return repSessionCO;
    }
    
    public SQL_OBJECT retSqlObj()
    {
	CommonReportingSessionCO repSessionCO = returnReportingSessionObject(get_pageRef());
	return repSessionCO.getSqlObj();
    }
    
    public String getQryType() 
    {
	return qryType;
    }
    
    public void setQryType(String qryType) 
    {
    	this.qryType = qryType;
    }
    
    public String findSingleCondition() throws BaseException
    {
	try
	{
	    if(!locIndex.equals(Long.valueOf("0")))
	    {
		String fromPrev=getUpdate1();
		if(fromPrev!=null && fromPrev.equals("prevFilter"))
		{
		    CommonReportingSessionCO repSessionCO=retPrevRepSessionCO() ;
		    IRP_AD_HOC_REPORTCO repCO=repSessionCO.getReportCO();
		    LinkedHashMap<Long,CONDITION_OBJECT> filterMap=repCO.getPrevFilterMap();
		    conditionObject = filterMap.get(locIndex);
		    
		    String qryType=returnQryType();
		    if(qryType!=null && qryType.equals(ConstantsCommon.SQB_QRY_TYPE))
		    {
			fields1=new ArrayList(retPrevSqlObj().getFields().values());
		    }
		    else
		    {
			if(conditionObject.getEntity1().getIndex().equals(Long.valueOf("11111111")))//it is an expression
			{
			    conditionEntity=conditionObject.getEntity1().getIndex().toString();
			    fields1 =new ArrayList<IRP_FIELDSCO>();
			    SQL_OBJECT sqlObj = retPrevSqlObj();
			    LinkedHashMap< Long, IRP_FIELDSCO> exprMap=sqlObj.getExpressionFields();
			    Iterator it=exprMap.values().iterator();
			    IRP_FIELDSCO feCO; 
			    IRP_FIELDSCO newFeCO; 
			    while(it.hasNext())
			    {
				feCO=(IRP_FIELDSCO)it.next();
				newFeCO =new IRP_FIELDSCO();
				newFeCO.setFIELD_ALIAS(feCO.getFeName());
				newFeCO.setFIELD_DB_NAME(feCO.getIndex().toString());
				fields1.add(newFeCO);
			    }
			}
			else
			{
//			    copyproperties(qryGridSC);
//			    qryGridSC.setRecToskip(0);
//			    qryGridSC.setNbRec(32000);
//			    qryGridSC.setFIELD_NAME(null);
//			    qryGridSC.setENTITY_DB_NAME(conditionObject.getEntity1().getENTITY_DB_NAME());
//			    qryGridSC.setPARENT_ID(Long.valueOf("0"));
			    List<HashMap<String,Object>> retLst=commonReportingBO.retDBFields(null, conditionObject.getEntity1().getENTITY_DB_NAME());
			    fillFeLstFromMap(retLst);
			    addObjsIndex(fields1);
			}
			
		    }
		    
		}
		else	
		{
		    conditionObject = retSqlObj().getConditionsList().get(locIndex);
		    conditionObject.getEntity1().getENTITY_ALIAS();
//		    copyproperties(qryGridSC);
//		    qryGridSC.setRecToskip(0);
//		    qryGridSC.setNbRec(32000);
//		    qryGridSC.setFIELD_NAME(null);
//		    qryGridSC.setENTITY_DB_NAME(conditionObject.getEntity1().getENTITY_DB_NAME());
//		    qryGridSC.setPARENT_ID(Long.valueOf("0"));
		    List<HashMap<String,Object>> retLst=commonReportingBO.retDBFields(null,conditionObject.getEntity1().getENTITY_DB_NAME());
		    fillFeLstFromMap(retLst);
		    addObjsIndex(fields1);
		}
	    }	
	}
	catch(Exception e)
	{
	    log.error(e,"");
	}
	return SUCCESS;
    }
    
    public void fillFeLstFromMap( List<HashMap<String,Object>> retLst)
    {
	fields1= new ArrayList<IRP_FIELDSCO>();
	try
	{
	    HashMap<String,Object> retMap;
	    IRP_FIELDSCO fe;
	    String[] propsArr= ConstantsCommon.retDBFieldsRet_PROPS.toArray(new String[ConstantsCommon.retDBFieldsRet_PROPS.size()]);
	    for(int i=0;i<retLst.size();i++)
	    {
		retMap=retLst.get(i);
		fe=new IRP_FIELDSCO();
		PathPropertyUtil.copyProperties(retMap,fe,false,propsArr);
		fields1.add(fe);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
    }
    
    public CONDITION_OBJECT getConditionObject() {
	return conditionObject;
    }
    
    public void setConditionObject(CONDITION_OBJECT conditionObject) {
    	this.conditionObject = conditionObject;
    }
    
    public Long getLocIndex()
    {
        return locIndex;
    }

    public void setLocIndex(Long locIndex)
    {
        this.locIndex = locIndex;
    }

    public List<IRP_FIELDSCO> getFields1() 
    {
	try 
	{
		String fromPrev=getUpdate1();
		if(fromPrev!=null && fromPrev.equals("prevFilter"))
		{
			SQL_OBJECT sqlObj=retPrevSqlObj();
			String qryType=returnQryType();
			if(qryType!=null  && qryType.equals(ConstantsCommon.SQB_QRY_TYPE))//if sqb and fromPrev
			{
				fields1=new ArrayList<IRP_FIELDSCO>();
				IRP_FIELDSCO feCO=new IRP_FIELDSCO();
				feCO.setFIELD_ALIAS("");
				feCO.setFIELD_DB_NAME("");
				fields1.add(feCO);
				//only display the the fields having the attribute hasBusName=1
				IRP_FIELDSCO crtFeCO;
				Iterator it=sqlObj.getFields().values().iterator();
				while(it.hasNext())
				{
					crtFeCO=(IRP_FIELDSCO)it.next();
					if(crtFeCO.getHasBusinessName()==1)
					{
						fields1.add(crtFeCO);
					}
				}
			}
			else //if qbe
			{
				if(!fields1.isEmpty() && (conditionEntity==null || !conditionEntity.equals("11111111")) )
				{
						fields1=new ArrayList<IRP_FIELDSCO>();
						//only display the the fields having the attribute hasBusName=1
						IRP_FIELDSCO crtFeCO;
						Iterator it=sqlObj.getFields().values().iterator();
						while(it.hasNext())
						{
							crtFeCO=(IRP_FIELDSCO)it.next();
							if(crtFeCO.getHasBusinessName()==1)
							{
								fields1.add(crtFeCO);
							}
						}
				}
			}
		}
	} catch (Exception e) 
	{
		log.error(e,"");
	}
	return fields1;
    }

    public void setFields1(List<IRP_FIELDSCO> fields1) {
    	this.fields1 = fields1;
    }
    
    public List<IRP_FIELDSCO> getFields2() {
	return fields2;
    }
    
    public void setFields2(List<IRP_FIELDSCO> fields2) {
    	this.fields2 = fields2;
    }
    
    public String getConditionEntity() {
	return conditionEntity;
    }
    
    public void setConditionEntity(String conditionEntity) {
    	this.conditionEntity = conditionEntity;
    }
    
    protected void addObjsIndex(List<IRP_FIELDSCO> lst)
    {
	//add index to each obj since sybase does not have a conversion of rownum
	IRP_FIELDSCO feCO;
	for(int i=0;i<lst.size();i++)
	{
	    feCO=lst.get(i);
	    feCO.setIndex(Long.valueOf(i));
	}
    }
    
    public void addUpdateCondition() throws BaseException 
    {
	try
	{
	    IRP_ENTITIESCO entity1 = null;
	    IRP_FIELDSCO field1 = null;
	    CONDITION_OBJECT condition;
	    String fromPrev=getUpdate1();
	    String qryType=getQryType();
	    if(fromPrev!=null && fromPrev.equals("prevFilter"))
	    {
		CommonReportingSessionCO repSessionCO=retPrevRepSessionCO() ;
		IRP_AD_HOC_REPORTCO repCO=repSessionCO.getReportCO();
		LinkedHashMap<Long,CONDITION_OBJECT> filterMap=repCO.getPrevFilterMap();
		SQL_OBJECT sqlObj=retPrevSqlObj();
		boolean isExpr=false;
		
		if(conditionEntity!=null && conditionEntity.equals("11111111"))// it is an expression
		{
		    entity1=new IRP_ENTITIESCO();
		    entity1.setENTITY_DB_NAME(getText("expr.ExpressionList"));
		    entity1.setEntityAliasWithCount(getText("expr.ExpressionList"));
		    entity1.setIndex(Long.valueOf("11111111"));
		    isExpr=true;
		}
		else if(conditionEntity!=null && !conditionEntity.equals(""))
		{
		    entity1 = sqlObj.getEntities().get(Long.valueOf(conditionEntity));
		}

		if(conditionField==null || conditionField.equals("") || entity1==null || isExpr)
		{
			// if it is sqb and from prev  set field1
			if (qryType!=null  && qryType.equals(ConstantsCommon.SQB_QRY_TYPE))
			{
				LinkedHashMap<Long, IRP_FIELDSCO>feMap=sqlObj.getFields();
				Iterator it=feMap.values().iterator();
				IRP_FIELDSCO feCO;
				while(it.hasNext())
				{
				feCO=(IRP_FIELDSCO)it.next();
				if(feCO.getFIELD_DB_NAME().equals(conditionField))
				{
					field1=feCO;
					break;
				}
				}
			}
			else if(isExpr)
			{
				IRP_FIELDSCO field=sqlObj.getExpressionFields().get(Long.valueOf(conditionField));
				field1=new IRP_FIELDSCO();
				field1.setFIELD_ALIAS(field.getLabelAlias());
				field1.setLabelAlias(field.getLabelAlias());
				field1.setFIELD_DATA_TYPE(field.getFIELD_DATA_TYPE());
			}
		}
		else
		{
//		    copyproperties(qryGridSC);
//		    qryGridSC.setRecToskip(0);
//		    qryGridSC.setNbRec(32000);
//		    qryGridSC.setPARENT_ID(Long.valueOf("0"));
//		    
//		    qryGridSC.setENTITY_DB_NAME(entity1.getENTITY_DB_NAME());
//		    qryGridSC.setFIELD_NAME(conditionField);
		     List<HashMap<String,Object>> retLst= commonReportingBO.retDBFields(conditionField,entity1.getENTITY_DB_NAME());
		     HashMap<String,Object> frstFeCOMap=retLst.get(0);
		     field1 = new IRP_FIELDSCO();
		     String[] propsArr= ConstantsCommon.retDBFieldsRet_PROPS.toArray(new String[ConstantsCommon.retDBFieldsRet_PROPS.size()]);
		     PathPropertyUtil.copyProperties(frstFeCOMap, field1,false,propsArr); 
		    //set the labelAlias cs we will need it when creating the filter in reportUtils
		    LinkedHashMap<Long, IRP_FIELDSCO>feMap=sqlObj.getFields();
		    Iterator it=feMap.values().iterator();
		    IRP_FIELDSCO feCO;
		    while(it.hasNext())
		    {
			feCO=(IRP_FIELDSCO)it.next();
			if(feCO.getENTITY_DB_NAME().equals(entity1.getENTITY_DB_NAME()) && feCO.getFIELD_DB_NAME().equals(conditionField))
			{
			    field1.setLabelAlias(feCO.getLabelAlias());
			    break;
			}
		    }
		    
		    addObjsIndex(fields1);
		}
		
		if("".equals(conditionIndex))
		{
		    condition = new CONDITION_OBJECT();
		    condition.setIndex(generateId());
		}
		else
		{
		    condition = filterMap.get(Long.valueOf(conditionIndex));
		}
		
		condition.setConjunction(conditionObject.getConjunction());
		condition.setEntity1(entity1);
		condition.setField1(field1);
		
		condition.setLparenthesis(conditionObject.getLparenthesis());
		condition.setOperator(conditionObject.getOperator());
		condition.setRparenthesis(conditionObject.getRparenthesis());
		condition.setValue(conditionObject.getValue());
		
		condition.setOperatorName(conditionObject.getOperator());
		if(condition.getOperator()!=null && condition.getOperator().equals(ConstantsCommon.BETWEEN_OPERATOR))
		{
		    condition.setOperatorName("BETWEEN");
		}
		
		if("".equals(conditionIndex))
		{
		    filterMap.put(condition.getIndex(), condition);
		}
		
	    }
	    else
	    {
		SQL_OBJECT sqlObj = retSqlObj();
		
		if(sqlObj.getConditionsList()==null)
		{
		    sqlObj.setConditionsList(new LinkedHashMap<Long,CONDITION_OBJECT>());
		}
		
		IRP_REP_ARGUMENTSCO argument1=null;
		IRP_REP_ARGUMENTSCO argument2=null;
		
		if(ARGUMENT1 != null && !ARGUMENT1.equals(""))
		{
		    argument1 = sqlObj.getArgumentsList().get(Long.valueOf(ARGUMENT1));
		}
		if(ARGUMENT2 != null && !ARGUMENT2.equals(""))
		{
		    argument2 = sqlObj.getArgumentsList().get(Long.valueOf(ARGUMENT2)); 
		}
		
		if(conditionEntity!=null && !conditionEntity.equals(""))
		{
		    entity1 = sqlObj.getEntities().get(Long.valueOf(conditionEntity));
		}
		
		if(conditionField!=null && !conditionField.equals("") && entity1!=null)
		{
//		    copyproperties(qryGridSC);
//		    qryGridSC.setRecToskip(0);
//		    qryGridSC.setNbRec(32000);
//		    qryGridSC.setPARENT_ID(Long.valueOf("0"));
//		    
//		    qryGridSC.setENTITY_DB_NAME(entity1.getENTITY_DB_NAME());
//		    qryGridSC.setFIELD_NAME(conditionField);
		    List<HashMap<String,Object>> retLst = commonReportingBO.retDBFields(conditionField,entity1.getENTITY_DB_NAME());
		    HashMap<String,Object> frstFeCOMap=retLst.get(0);
		    field1 = new IRP_FIELDSCO();
		    String[] propsArr= ConstantsCommon.retDBFieldsRet_PROPS.toArray(new String[ConstantsCommon.retDBFieldsRet_PROPS.size()]);
		    PathPropertyUtil.copyProperties(frstFeCOMap, field1,false,propsArr); 
		    addObjsIndex(fields1);
		}
		
		if("".equals(conditionIndex))
		{
		    condition = new CONDITION_OBJECT();
		    condition.setIndex(generateId());
		}
		else
		{
		    condition = sqlObj.getConditionsList().get(Long.valueOf(conditionIndex));
		}
		
		condition.setArgument1(argument1);
		condition.setArgument2(argument2);
		condition.setConjunction(conditionObject.getConjunction());
		condition.setEntity1(entity1);
		condition.setField1(field1);
		
		condition.setLparenthesis(conditionObject.getLparenthesis());
		condition.setOperator(conditionObject.getOperator());
		condition.setRparenthesis(conditionObject.getRparenthesis());
		condition.setValue(conditionObject.getValue());
		
		condition.setOperatorName(conditionObject.getOperator());
		if(condition.getOperator()!=null && condition.getOperator().equals(ConstantsCommon.BETWEEN_OPERATOR))
		{
		    condition.setOperatorName("BETWEEN");
		}
		
		if( "".equals(conditionIndex))
		{
		    sqlObj.getConditionsList().put(condition.getIndex(), condition);
		}
		
	    }
	}
	catch(Exception e)
	{
	    log.error(e,"");
	}
    }
    
    public String getConditionIndex() {
	return conditionIndex;
    }
    
    public void setConditionIndex(String conditionIndex) {
    	this.conditionIndex = conditionIndex;
    }
    
    public String getConditionField() {
	return conditionField;
    }
    
    public void setConditionField(String conditionField) {
    	this.conditionField = conditionField;
    }
    
    public String getARGUMENT1() {
	return ARGUMENT1;
    }
    
    public void setARGUMENT1(String aRGUMENT1) {
    	ARGUMENT1 = aRGUMENT1;
    }
    
    public String getARGUMENT2() {
	return ARGUMENT2;
    }
    
    public void setARGUMENT2(String aRGUMENT2)
    {
        ARGUMENT2 = aRGUMENT2;
    }

    public Long generateId()	
    {
	Calendar cal = Calendar.getInstance();
	return cal.getTimeInMillis();
    }
    
    public String deleteCondition()
    {
	String fromPrev=getUpdate1();
	CommonReportingSessionCO repSessionCO ;
	if(fromPrev!=null && fromPrev.equals("prevFilter"))
	{
	    repSessionCO=retPrevRepSessionCO();
	    LinkedHashMap<Long,CONDITION_OBJECT> filterMap=repSessionCO.getReportCO().getPrevFilterMap();
	    filterMap.remove(locIndex);
	    conditionRecordsCount = String.valueOf(filterMap.size());		
	}
	else
	{
	    repSessionCO = returnReportingSessionObject(get_pageRef());
	    SQL_OBJECT sqlObj = repSessionCO.getSqlObj();
	    sqlObj.getConditionsList().remove(locIndex);
	    conditionRecordsCount = String.valueOf(sqlObj.getConditionsList().size());		
	}
	return SUCCESS;
    }
    
    public String getConditionRecordsCount() {
	return conditionRecordsCount;
    }
    
    public void setConditionRecordsCount(String conditionRecordsCount) {
    	this.conditionRecordsCount = conditionRecordsCount;
    }
    
    public String getHideEntGrid()
    {
	String fromPrev=getUpdate1();
	if( fromPrev!=null && fromPrev.equals("prevFilter")) 
	{
	    String qryType=returnQryType();
	    if(qryType!=null && qryType.equals(ConstantsCommon.SQB_QRY_TYPE))
	    {
		return "true";
	    }
	    else
	    {
		return "false";
	    }
	}
	else
	{
	    return "false";
	}
    }
    
    public String getHideArgsGrid()
    {
	String fromPrev=getUpdate1();
	if( fromPrev!=null && fromPrev.equals("prevFilter"))  {
	    return "true";
	}
	else
	{
	    return "false";
	}
    }
    
    public String getHideEntityCol()
    {
	CommonReportingSessionCO repSessionCO = returnReportingSessionObject(get_pageRef());
		SQL_OBJECT sqlObj=repSessionCO.getSqlObj();
		//if we are creating a query from the query section and not from the designer
		if(repSessionCO.getReportCO()==null)
		{
			return "false";
		}
		else if(sqlObj==null)
		{
		    if(repSessionCO.getReportCO().getQueriesList().isEmpty())
		    {
			return "true";
		    }
			IRP_AD_HOC_REPORTCO repCO=repSessionCO.getReportCO();
			IRP_AD_HOC_QUERYCO qryCO=repCO.getQueriesList().get(0);
			if(qryCO.getSqlObject()!=null && qryCO.getSqlObject().getEntities().size()>0)
			{
				return "false";
			}
			else
			{
				return "true";
			}
		}
		else
		{
			if(sqlObj.getSqbSyntax()==null && sqlObj.getEntities().size()>0)
			{
				return "false";
			}
			else
			{
				return "true";
			}
		}
		
    }
    
    public String getCondConjunctionDisabled()
    {
	String fromPrev=getUpdate1();
	if( tab!=null && tab.equals("conditions")) {
			
	    LinkedHashMap<Long, CONDITION_OBJECT> list = retSqlObj().getConditionsList();
	    return (list == null || list.isEmpty())? "true" : "false" ;
	}
	else if (fromPrev!=null && fromPrev.equals("prevFilter"))
	{
	    LinkedHashMap<Long, CONDITION_OBJECT> list;
	    try
	    {
		CommonReportingSessionCO repSessionCO =retPrevRepSessionCO();
		IRP_AD_HOC_REPORTCO repCO=repSessionCO.getReportCO();
		list=repCO.getPrevFilterMap();
		return (list == null || list.isEmpty())? "true" : "false";
	    }
	    catch (Exception e) 
	    {
		log.error(e,"");
	    }
	}
	return null;
    }
    
    public List<SYS_PARAM_LOV_TRANSVO> getConjunctionsList() 
    {
	String fromPrev=getUpdate1();
	if( (tab!=null && ( tab.equals("conditions") || tab.equals("having"))) || (fromPrev!=null && fromPrev.equals("prevFilter"))) 
	{
			conjunctionsList = new ArrayList<SYS_PARAM_LOV_TRANSVO>();
			SYS_PARAM_LOV_TRANSVO sysVO=new SYS_PARAM_LOV_TRANSVO();
			sysVO.setVALUE_CODE("And");
			sysVO.setVALUE_DESC(getText("criteria.and"));
			conjunctionsList.add(sysVO);
			sysVO=new SYS_PARAM_LOV_TRANSVO();
			sysVO.setVALUE_CODE("Or");
			sysVO.setVALUE_DESC(getText("criteria.or"));
			conjunctionsList.add(sysVO);
	}
	return conjunctionsList;
    }
    
    public void setConjunctionsList(List<SYS_PARAM_LOV_TRANSVO> conjunctionsList) {
    	this.conjunctionsList = conjunctionsList;
    }
    
    public List<IRP_ENTITIESCO> getEntitiesList() 
    {
	try {
		String fromPrev=getUpdate1();
		if( (tab!=null && ( tab.equals("conditions") || tab.equals("having") || tab.equals("joins") ) ) || (fromPrev!=null && fromPrev.equals("prevFilter"))) {
			LinkedHashMap<Long, IRP_ENTITIESCO> entitiesMap=new LinkedHashMap<Long, IRP_ENTITIESCO>() ;
			
			if(fromPrev!=null && fromPrev.equals("prevFilter"))
			{
				SQL_OBJECT sqlObj=retPrevSqlObj();
				entitiesMap.putAll(sqlObj.getEntities());
				//add expression option
				IRP_ENTITIESCO exprEntCO=new IRP_ENTITIESCO();
				exprEntCO.setIndex(Long.valueOf("11111111"));
				exprEntCO.setEntityAliasWithCount(getText("expr.ExpressionList"));
				entitiesMap.put(exprEntCO.getIndex(), exprEntCO);
			}
			else
			{
				 entitiesMap = retSqlObj().getEntities();
			}
			
			if(entitiesList==null)
			{
				entitiesList = new ArrayList<IRP_ENTITIESCO>();
			}
			else
			{
				entitiesList.clear();
			}
			for(int i=0;i<entitiesMap.size();i++)
			{
				entitiesList.add((IRP_ENTITIESCO) entitiesMap.values().toArray()[i]);
			}
		}
	} catch (Exception e) {
		log.error(e,"");
	}
	
	return entitiesList;
    }
    
    public void setEntitiesList(List<IRP_ENTITIESCO> entitiesList) {
    	this.entitiesList = entitiesList;
    }
    
    public String conditionEntityChange() throws BaseException
    {
	try {
	    if (conditionEntity == null || conditionEntity.isEmpty()) 
	    {
		fields1 = new ArrayList<IRP_FIELDSCO>();
	    }
	    else
	    {
		String fromPrev = getUpdate1();
		SQL_OBJECT zSqlObj=retSqlObj();
		if(fromPrev != null && fromPrev.equals("prevFilter") && conditionEntity.equals("11111111") ) //it is an expression
		{
		    fields1 =new ArrayList<IRP_FIELDSCO>();
		    SQL_OBJECT sqlObj = retPrevSqlObj();
		    LinkedHashMap< Long, IRP_FIELDSCO> exprMap=sqlObj.getExpressionFields();
		    Iterator it=exprMap.values().iterator();
		    IRP_FIELDSCO feCO; 
		    IRP_FIELDSCO newFeCO; 
		    while(it.hasNext())
		    {
			feCO=(IRP_FIELDSCO)it.next();
			newFeCO =new IRP_FIELDSCO();
			newFeCO.setFIELD_ALIAS(feCO.getFeName());
			newFeCO.setFIELD_DB_NAME(feCO.getIndex().toString());
			fields1.add(newFeCO);
		    }
		}
		else if ((zSqlObj != null && zSqlObj.getEntities() != null && zSqlObj.getEntities().get(Long.valueOf(conditionEntity)) != null)|| (fromPrev != null && fromPrev.equals("prevFilter"))) 
		{
		    IRP_ENTITIESCO currentEntity;
		    if (fromPrev != null && fromPrev.equals("prevFilter")) 
		    {
			SQL_OBJECT sqlObj = retPrevSqlObj();
			currentEntity=sqlObj.getEntities().get(Long.valueOf(conditionEntity));
		    }
		    else
		    {
			currentEntity = zSqlObj.getEntities().get(Long.valueOf(conditionEntity));
		    }
		    
//		    copyproperties(qryGridSC);
//		    qryGridSC.setRecToskip(0);
//		    qryGridSC.setNbRec(32000);
//		    qryGridSC.setFIELD_NAME(null);
//		    qryGridSC.setENTITY_DB_NAME(currentEntity.getENTITY_DB_NAME());
//		    qryGridSC.setPARENT_ID(Long.valueOf("0"));
		    List<HashMap<String,Object>> retLst = commonReportingBO.retDBFields(null,currentEntity.getENTITY_DB_NAME());
		    fillFeLstFromMap(retLst);
		    IRP_FIELDSCO emptyFeCO = new IRP_FIELDSCO();
		    emptyFeCO.setFIELD_ALIAS("");
		    emptyFeCO.setFIELD_DB_NAME("");
		    fields1.add(0, emptyFeCO);

		    addObjsIndex(fields1);
		}
	    }
	} catch (Exception e) {
	    log.error(e,"");
	}
	return SUCCESS;
    }
   
    /**
     * This function is called to show and hide the second argument input in the conditions screen based on the selected operator 
     * @return
     */
    public String showHideSecondArg()
    {
	 SYS_PARAM_SCREEN_DISPLAYVO screenDisplayFcr = new SYS_PARAM_SCREEN_DISPLAYVO();
	 if(ConstantsCommon.BETWEEN_OPERATOR.equals(updates))
	 {
	     screenDisplayFcr.setIS_VISIBLE(BigDecimal.ONE);
	 }
	 else
	 {
	     screenDisplayFcr.setIS_VISIBLE(BigDecimal.ZERO);
	 }
	 getAdditionalScreenParams().put("ARGUMENT2Cond", screenDisplayFcr);
	 getAdditionalScreenParams().put("arg2Lbl", screenDisplayFcr);
	return SUCCESS;
    }
    
    
    public String operatorChange() throws Exception
    {
	
	SessionCO sessionCO = returnSessionObject();
	SYS_PARAM_LOV_TRANSVO sysParamLovVO= new SYS_PARAM_LOV_TRANSVO();
	sysParamLovVO.setLOV_TYPE_ID(new BigDecimal(7)); // 7 =operator (check table sys_param_lov_type)
	sysParamLovVO.setLANG_CODE(sessionCO.getLanguage());
	try
	{
	 conditionEntityChange();
	 
	 HashMap<String,Object> sysParamLovVOMap=new HashMap<String,Object>();
	 String[] propsArr= ConstantsCommon.getLookupListMap_PROPS.toArray(new String[ConstantsCommon.getLookupListMap_PROPS.size()]);
	 PathPropertyUtil.copyProperties(sysParamLovVO, sysParamLovVOMap,false,propsArr);
	 ArrayList<HashMap<String,Object>>  retLst=(ArrayList<HashMap<String,Object>>) commonReportingBO.getLookupListMap(sysParamLovVOMap);
	 HashMap<String, Object> hm;
	 operatorsList = new ArrayList<SYS_PARAM_LOV_TRANSVO>();
	 propsArr= ConstantsCommon.getLookupListMapRet_PROPS.toArray(new String[ConstantsCommon.getLookupListMapRet_PROPS.size()]);
	 for(int i = 0; i < retLst.size(); i++)
	 {
	     hm = retLst.get(i);
	     sysParamLovVO = new SYS_PARAM_LOV_TRANSVO();
	     PathPropertyUtil.copyProperties(hm, sysParamLovVO, false, propsArr);
	     operatorsList.add(sysParamLovVO);
	 }
		
	 String fromPrev=getUpdate1();
	 if((fields1==null || fields1.isEmpty()) && "prevFilter".equals(fromPrev))
	 {
	     fields1=getFields1();
	 }
	 SYS_PARAM_LOV_TRANSVO lov;
	 for(int i=0;i<fields1.size();i++)
	 {
	     if(ConstantsCommon.STRING_IMPORT.equals(fields1.get(i).getFIELD_DATA_TYPE()) && conditionField.equals(fields1.get(i).getFIELD_DB_NAME()))
	     {
	    	operatorsList = new ArrayList<SYS_PARAM_LOV_TRANSVO>();
			lov=new SYS_PARAM_LOV_TRANSVO();
			lov.setLOV_TYPE_ID(new BigDecimal(8));
			lov.setVALUE_CODE("contains");
			lov.setVALUE_DESC(getText("reporting.contains"));
			operatorsList.add(lov);
			
			lov=new SYS_PARAM_LOV_TRANSVO();
			lov.setLOV_TYPE_ID(new BigDecimal(8));
			lov.setVALUE_CODE("startsWith");
			lov.setVALUE_DESC(getText("reporting.startsWith"));
			operatorsList.add(lov);
			
			lov=new SYS_PARAM_LOV_TRANSVO();
			lov.setLOV_TYPE_ID(new BigDecimal(8));
			lov.setVALUE_CODE("endsWith");
			lov.setVALUE_DESC(getText("reporting.endsWith"));
			operatorsList.add(lov);
	     }
		else if("".equals(StringUtil.nullToEmpty(fromPrev)) && ConstantsCommon.BIGDECIMAL_IMPORT.equals(fields1.get(i).getFIELD_DATA_TYPE())
			&& conditionField.equals(fields1.get(i).getFIELD_DB_NAME()))
		{
		    lov = new SYS_PARAM_LOV_TRANSVO();
		    lov.setLOV_TYPE_ID(new BigDecimal(7));
		    lov.setVALUE_CODE(ConstantsCommon.BETWEEN_OPERATOR);
		    lov.setVALUE_DESC(ConstantsCommon.BETWEEN_OPERATOR_CODE);
		    operatorsList.add(lov);
		}

//	     if(fields1.get(i).getFIELD_DATA_TYPE()!=null && (fields1.get(i).getFIELD_DATA_TYPE().equals("java.math.Date") || fields1.get(i).getFIELD_DATA_TYPE().equals("java.sql.Timestamp")) && fields1.get(i).getFIELD_DB_NAME().equals(conditionField))
//	     {
//		 for(int j=0;j<operatorsList.size();j++)
//		 {
//		     if(operatorsList.get(j).getVALUE_CODE().equals("<>"))
//		     {
//		 	operatorsList.remove(operatorsList.get(j));
//		     }
//		 }
//	     }
	 }
	 setUpdates((operatorsList.get(0)).getVALUE_CODE());
	 showHideSecondArg();
	}
	catch(Exception e1)
	{
	    log.error(e1,e1.getMessage());
	}
	 return SUCCESS;
    }
    
    public String getEmptyOptionFe()
    {
	String fromPrev=getUpdate1();
	if( fromPrev!=null && fromPrev.equals("prevFilter")) 
	{
	    String qryType=returnQryType();
	    if(qryType!=null && qryType.equals(ConstantsCommon.SQB_QRY_TYPE))
	    {
		return "false";
	    }
	    else
	    {
		return "true";
	    }
	}
	else
	{
	    return "true";
	}
    }
    
    public ArrayList<SYS_PARAM_LOV_TRANSVO> getOperatorsList() 
    {
	String fromPrev=getUpdate1();
	if(operatorsList==null && (( tab!=null && ( tab.equals("conditions") || tab.equals("having") )) ||(fromPrev!=null && fromPrev.equals("prevFilter"))) )// to check if the operators list is fill from operatorChange fuction to not override the operatorsList //&& fe==null
	{
		SessionCO sessionCO = returnSessionObject();
		SYS_PARAM_LOV_TRANSVO sysParamLovVO= new SYS_PARAM_LOV_TRANSVO();
		sysParamLovVO.setLOV_TYPE_ID(new BigDecimal(7)); // 7 =operator (check table sys_param_lov_type)
		sysParamLovVO.setLANG_CODE(sessionCO.getLanguage());
		try {
		    HashMap<String,Object> sysParamLovVOMap=new HashMap<String,Object>();
		    String[] propsArr= ConstantsCommon.getLookupListMap_PROPS.toArray(new String[ConstantsCommon.getLookupListMap_PROPS.size()]);
	    	    PathPropertyUtil.copyProperties(sysParamLovVO, sysParamLovVOMap,false,propsArr);
	    	    ArrayList<HashMap<String,Object>>  retLst=(ArrayList<HashMap<String,Object>>) commonReportingBO.getLookupListMap(sysParamLovVOMap);
	    	    HashMap<String, Object> hm;
	    	    operatorsList = new ArrayList<SYS_PARAM_LOV_TRANSVO>();
	    	    propsArr= ConstantsCommon.getLookupListMapRet_PROPS.toArray(new String[ConstantsCommon.getLookupListMapRet_PROPS.size()]);
	    	    for(int i = 0; i < retLst.size(); i++)
	    	    {
	    		hm = retLst.get(i);
	    		sysParamLovVO = new SYS_PARAM_LOV_TRANSVO();
	    		PathPropertyUtil.copyProperties(hm, sysParamLovVO, false, propsArr);
	    		operatorsList.add(sysParamLovVO);
	    	    }
		    SYS_PARAM_LOV_TRANSVO lov;
		    //added to the query condition
		    if(fromPrev==null)
		    {
			lov=new SYS_PARAM_LOV_TRANSVO();
			lov.setLOV_TYPE_ID(new BigDecimal(7));
			lov.setVALUE_CODE(ConstantsCommon.BETWEEN_OPERATOR);
			lov.setVALUE_DESC(ConstantsCommon.BETWEEN_OPERATOR_CODE);
			operatorsList.add(lov);
		    }
		    
		    
		    lov=new SYS_PARAM_LOV_TRANSVO();
		    lov.setLOV_TYPE_ID(new BigDecimal(8));
		    lov.setVALUE_CODE("contains");
		    lov.setVALUE_DESC(getText("reporting.contains"));
		    operatorsList.add(lov);
		    
		    lov=new SYS_PARAM_LOV_TRANSVO();
		    lov.setLOV_TYPE_ID(new BigDecimal(8));
		    lov.setVALUE_CODE("startsWith");
		    lov.setVALUE_DESC(getText("reporting.startsWith"));
		    operatorsList.add(lov);
		    
		    lov=new SYS_PARAM_LOV_TRANSVO();
		    lov.setLOV_TYPE_ID(new BigDecimal(8));
		    lov.setVALUE_CODE("endsWith");
		    lov.setVALUE_DESC(getText("reporting.endsWith"));
		    operatorsList.add(lov);
		}
		catch (ReportException e) 
		{
		     if(Integer.valueOf(1).equals(e.getMsgType()))
		     {
			 BaseException ba = retBaseExceptionFromRepException(e);
			 handleException(ba, "Error returning the operators list","returnOperators.exceptionMsg._key");
		     }
		     else
		     {
			 handleException(e, "Error returning the operators list","returnOperators.exceptionMsg._key");		     }
		}
		catch (BaseException e) {
		    //log.error("Error filling the operators list.");
		    handleException(e, "Error returning the operators list","returnOperators.exceptionMsg._key");
		    return null;
	    }
	}
	
	return operatorsList;
    }
    
    public void setOperatorsList(ArrayList<SYS_PARAM_LOV_TRANSVO> operationTypes) {
    	this.operatorsList = operationTypes;
    }
    
    public void setArgumentsList(ArrayList<IRP_REP_ARGUMENTSCO> argumentsList) {
	this.argumentsList = argumentsList;
    }
    
    public ArrayList<IRP_REP_ARGUMENTSCO> getArgumentsList() 
    {
    	if( tab!=null && ( tab.equals("conditions") || tab.equals("having") ) ) {
    		LinkedHashMap<Long, IRP_REP_ARGUMENTSCO> argumentsMap = retSqlObj().getArgumentsList();
    		
    		if(argumentsList==null)
    		{
    			argumentsList = new ArrayList<IRP_REP_ARGUMENTSCO>();
    		}
    		else
    		{
    			argumentsList.clear();
    		}
    		for(int i=0;i<argumentsMap.size();i++)
    		{
    			argumentsList.add((IRP_REP_ARGUMENTSCO) argumentsMap.values().toArray()[i]);
    		}
    	}
    	
    	return argumentsList;
    }
    
    public String checkGrpUsage() throws Exception
    {
	try
	{
	    CommonReportingSessionCO repSessionCO=retPrevRepSessionCO();
	    List<IRP_AD_HOC_QUERYCO> list = repSessionCO.getReportCO().getQueriesList();
	    SQL_OBJECT sqlObj;
	    LinkedHashMap<Long, IRP_FIELDSCO> groupByHM ;
	    int i=0;
	    for(IRP_AD_HOC_QUERYCO queryco : list) 
	    {
		sqlObj = queryco.getSqlObject();
		groupByHM = sqlObj.getGroupByHM();
		if(groupByHM != null && !groupByHM.isEmpty()) 
		{
		    i++;
		}
	    }
	    setUpdates(String.valueOf(i));
	}
	catch(Exception e)
	{
	    log.error(e,"-------->>>>>>>>pagRef="+get_pageRef());
	}
	return SUCCESS;
    }
    
    public void resetPreviewOptions()throws Exception
    {
	CommonReportingSessionCO repSessionCO = returnReportingSessionObject(get_pageRef());    	
	repSessionCO.getReportCO().setPrevOrderList(new ArrayList<IRP_FIELDSCO>());
	repSessionCO.getReportCO().setPrevFilterMap(new LinkedHashMap<Long, CONDITION_OBJECT>());
	repSessionCO.getReportCO().setPrevGrpMap(new LinkedHashMap<Long, IRP_FIELDSCO>());
    }
    
    public String addNewGroup()  throws JSONException
    {
	try
	{
	    BigDecimal feId=new BigDecimal(qryField);
			
	    CommonReportingSessionCO repSessionCO = retPrevRepSessionCO();
	    List<IRP_AD_HOC_QUERYCO> qryLst = repSessionCO.getReportCO().getQueriesList();
	    IRP_AD_HOC_QUERYCO qryCO;
			
	    String fromPrev=getUpdates();
	    if(fromPrev!=null && fromPrev.equals("prevGrp"))
	    {
		Iterator it;
		IRP_FIELDSCO fe;
		SQL_OBJECT sqlObj=retPrevSqlObj();
		IRP_FIELDSCO feCO=sqlObj.getFields().get(Long.valueOf(qryField));
		if(feCO==null) //it means that the index has been changed in the queryDesignerAction addObjsIndex()
		{
		    it=sqlObj.getFields().values().iterator();
		    while(it.hasNext())
		    {
			fe=(IRP_FIELDSCO)it.next();
			if(fe.getIndex().equals(Long.valueOf(qryField)))
			{
			    feCO=fe;
			    break;
			}
		    }
		}
		if(feCO==null) // it is an expression
		{
		    LinkedHashMap< Long, IRP_FIELDSCO> exprMap=sqlObj.getExpressionFields();
		    it=exprMap.values().iterator();
		    while(it.hasNext())
		    {
			feCO=(IRP_FIELDSCO)it.next();
			while(it.hasNext())
			{
			    fe=(IRP_FIELDSCO)it.next();
			    if(fe.getIndex().equals(Long.valueOf(qryField)))
			    {
				feCO=fe;
				break;
			    }
			    
			}
		    }
		}
		IRP_FIELDSCO newFeCO=new IRP_FIELDSCO();
		newFeCO.setGroupName(grpName);
		newFeCO.setLabelAlias(feCO.getLabelAlias());
		newFeCO.setFIELD_DATA_TYPE(feCO.getFIELD_DATA_TYPE());
		newFeCO.setIndex(feCO.getIndex());
		newFeCO.setFeName(feCO.getFeName());
		newFeCO.setFIELD_ALIAS(feCO.getLabelAlias());
		if(!StringUtil.nullToEmpty(updates1).isEmpty() && !"null".equalsIgnoreCase(updates1))
		{
			Long updatedFeId=Long.valueOf(updates1)	;
			IRP_FIELDSCO currFeGrp= repSessionCO.getReportCO().getPrevGrpMap().get(updatedFeId);
			if(currFeGrp!=null)
			{
				repSessionCO.getReportCO().getPrevGrpMap().remove(updatedFeId);
			}
		}
		
		repSessionCO.getReportCO().getPrevGrpMap().put(feCO.getIndex(), newFeCO);
	    }
	    else
	    {
		if(qryNamee !=null && !qryNamee.equals(""))
		{
		    for(int i=0;i<qryLst.size();i++)
		    {
			qryCO=qryLst.get(i);
			if(qryCO.getQUERY_NAME().equals(qryNamee))
			{
			    //create feCO
			    IRP_FIELDSCO feCO =qryCO.getSqlObject().getFields().get(feId.longValue());
			    feCO.setGroupName(grpName);
			    feCO.setOrder("asc");
			    qryCO.getSqlObject().getGroupByHM().put(feCO.getIndex(), feCO);
			    if( qryCO.getSqlObject().getOutputLayout().equals(ConstantsCommon.OUTPUT_LAYOUT_FREE_FORM) )  // free form
			    {
				htmlTableId = "root";
			    }
			    else
			    {
				htmlTableId = qryCO.getQUERY_NAME();
			    }
			    break;
			}
		    }
		}
	    }
	    
	    for(int i=0;i<qryLst.size();i++)
	    {	
		if(qryLst.get(i).getSqlObject().getEntities().size()>0)
		{
		    orderMsg="isNotQuerySyntax";
		}
		else
		{
		    orderMsg="isQuerySyntax";
		}
	    }
	      
	}
	catch(Exception e)
	{
	    //log.error("Error adding a new group.");
	    handleException(e, "Error adding a new grouping","addGrouping.exceptionMsg._key");
	   // log.error(e,"");
	}
	return SUCCESS;
    }
    
    public void deleteGroup() throws Exception
    {
	String fromPrev=getUpdates();
	BigDecimal grpId=getGrpId();
	String qryName=getQryNamee();
	CommonReportingSessionCO repSessionCO ;
		
	if(fromPrev!=null && fromPrev.equals("prevGrp"))
	{
	    repSessionCO = retPrevRepSessionCO();
	    repSessionCO.getReportCO().getPrevGrpMap().remove(grpId.longValue());
	}
	else
	{
	    repSessionCO = returnReportingSessionObject(get_pageRef());
	    List<IRP_AD_HOC_QUERYCO> qryLst = repSessionCO.getReportCO().getQueriesList();
	    IRP_AD_HOC_QUERYCO qryCO;
	    for(int i=0;i<qryLst.size();i++)
	    {
		qryCO=qryLst.get(i);
		if(qryCO.getQUERY_NAME().equals(qryName))
		{
		    qryCO.getSqlObject().getGroupByHM().remove(grpId.longValue());
		    qryCO.getSqlObject().getFields().get(grpId.longValue()).setGroupName(null);
		    break;
		}
	    }
	}
    }
    
    public String changeGrpPosition()throws Exception
    {
	try
	{
	    String updates=getUpdates();
	    if(updates !=null && !updates.equals(""))
	    {
		//selRowId+"~"+calledFrom+"~"+fromPrev
		String grpId=updates.split("~")[0];
		String mode=updates.split("~")[1]; // 1 :Up   ;    2:Down
		String fromPrev=updates.split("~")[2];
		CommonReportingSessionCO repSessionCO = retPrevRepSessionCO();
		IRP_AD_HOC_REPORTCO repCO=repSessionCO.getReportCO();
		IRP_FIELDSCO feCO;
		IRP_FIELDSCO lastFeCO=null;
		Long feId;
		if(fromPrev!=null && fromPrev.equals("prevGrp"))
		{
		    LinkedHashMap<Long,IRP_FIELDSCO> prevGrpMap=repCO.getPrevGrpMap();
		    LinkedHashMap<Long,IRP_FIELDSCO> newPrevGrpMap=new LinkedHashMap<Long,IRP_FIELDSCO>();
		    if("1".equals(mode))
		    {
			for(Map.Entry<Long,IRP_FIELDSCO> e : prevGrpMap.entrySet())
			{
			    feId=e.getKey();
			    feCO=e.getValue();
			    if(feId.equals(Long.valueOf(grpId)) && lastFeCO!=null)
			    {
				newPrevGrpMap.remove(lastFeCO.getIndex());
				newPrevGrpMap.put(feCO.getIndex(), feCO);
				newPrevGrpMap.put(lastFeCO.getIndex(), lastFeCO);
			    }
			    else
			    {
				newPrevGrpMap.put(feId, feCO);
				lastFeCO=feCO;
			    }
			    
			}
			repCO.setPrevGrpMap(newPrevGrpMap);
		    }
		    else
		    {
			for(Map.Entry<Long,IRP_FIELDSCO> e : prevGrpMap.entrySet())
			{
			    feId=e.getKey();
			    feCO=e.getValue();
			    if(feId.equals(Long.valueOf(grpId)))
			    {
				lastFeCO=feCO;
			    }
			    else
			    {
				newPrevGrpMap.put(feId, feCO);
				if(lastFeCO!=null)
				{
				    newPrevGrpMap.put(lastFeCO.getIndex(), lastFeCO);
				    lastFeCO=null;
				}
			    }
			}
			if(lastFeCO!=null) //if the map only contains one record or if we are moving down the last record
			{
			    newPrevGrpMap.put(lastFeCO.getIndex(), lastFeCO);
			}
			repCO.setPrevGrpMap(newPrevGrpMap);
		    }
		    
		}
	    }
	}
	catch(Exception e)
	{
	    log.error(e,"");
	}
	return SUCCESS;
    }
    
    public String loadGroupByList()
    {
	try 
	{
	    copyproperties(sc);
	    int nbRec=sc.getNbRec();
	    int recToSkip=sc.getRecToskip();
	    int maxRec=nbRec+recToSkip;
	    SQL_OBJECT sqlObj;
	    IRP_FIELDSCO feCO;
	    LinkedHashMap<Long, IRP_FIELDSCO> groupByHM ;
	    List<Group> groupList = new ArrayList<Group>();
	    Group group;
	    CommonReportingSessionCO repSessionCO ;
			
	    String fromPrev=getUpdates();
	    if(fromPrev!=null && fromPrev.equals("prevGrp"))
	    {
		repSessionCO=retPrevRepSessionCO();
		sqlObj=retPrevSqlObj();
		groupByHM=repSessionCO.getReportCO().getPrevGrpMap();
		Iterator it=groupByHM.values().iterator();
		while(it.hasNext())
		{
		    feCO=(IRP_FIELDSCO)it.next();
		    group=new Group(sqlObj.getQUERY_NAME(), feCO.getFeName(), feCO.getIndex(), feCO.getGroupName(), feCO.getFIELD_ALIAS());
		    groupList.add(group);
		}
	    }
	    else
	    {
		repSessionCO = returnReportingSessionObject(get_pageRef());
		List<IRP_AD_HOC_QUERYCO> list = repSessionCO.getReportCO().getQueriesList();
		for(IRP_AD_HOC_QUERYCO queryco : list) 
		{
		    sqlObj = queryco.getSqlObject();
		    groupByHM = sqlObj.getGroupByHM();
		    if(groupByHM != null) 
		    {
			for(IRP_FIELDSCO field : groupByHM.values())
			{
			    group = new Group(queryco.getQUERY_NAME(),field.getFeName(),field.getIndex(),field.getGroupName(),field.getFIELD_ALIAS());
			    groupList.add(group);
			}
		    }
		}
	    }
	    if(groupList.size()<maxRec)
	    {
		maxRec=groupList.size();
	    }
	    List<Group> finalGroupList = new ArrayList<Group>();
	    for(int i=recToSkip;i<maxRec;i++)
	    {
		finalGroupList.add((Group) groupList.get(i));
	    }
	    
	    setRecords(groupList.size());
	    setGridModel(finalGroupList);
	}
	catch(Exception e)
	{
	    //log.error(e, "Error in method loadGroupByList in CommonReportingAction");
	    handleException(e, "Error loading the grouping list","loadGrouping.exceptionMsg._key");
	}
	return SUCCESS;
    }
    
    @Override
    public Object getModel()
    {
	return sc;
    }
    
    public ArrayList<IRP_AD_HOC_QUERYCO> getQueriesCmbo() 
    {
	CommonReportingSessionCO repSessionCO=retPrevRepSessionCO();
	ArrayList<IRP_AD_HOC_QUERYCO> queriesCmbo = new ArrayList<IRP_AD_HOC_QUERYCO>();
	if(repSessionCO.getReportCO() != null && repSessionCO.getReportCO().getQueriesList().size()>0)
	{
		//knowing that the report only has one query ,we will display a common translated variables for all queries
		IRP_AD_HOC_QUERYCO grpByQryCO=new IRP_AD_HOC_QUERYCO();
		grpByQryCO.setQUERY_NAME(getText("reporting.reportQry"));
		grpByQryCO.setGrpByQryName(repSessionCO.getReportCO().getQueriesList().get(0).getQUERY_NAME());
		queriesCmbo=new ArrayList<IRP_AD_HOC_QUERYCO>();
		queriesCmbo.add(grpByQryCO);
	    //queriesCmbo = new ArrayList<IRP_AD_HOC_QUERYCO>(repSessionCO.getReportCO().getQueriesList());
	}
	return queriesCmbo;
    }
    
    public String qryFieldDependency() throws BaseException
    {
	try
	{
	    String fromPrev=getUpdates();
	    if(qryNamee ==null || qryNamee.equals(""))
	    {
		fieldsCmbo = new ArrayList<IRP_FIELDSCO>();
	    }
	    else
	    {
		CommonReportingSessionCO repSessionCO = retPrevRepSessionCO();
		LinkedHashMap<Long, IRP_FIELDSCO> groupByFields;
		LinkedHashMap<Long, IRP_FIELDSCO> allFields;
		List<IRP_FIELDSCO> arrayList1 ;
		List<IRP_FIELDSCO> arrayList2=new ArrayList<IRP_FIELDSCO>();
		List<IRP_FIELDSCO> remFields;
		List<IRP_AD_HOC_QUERYCO> qryLst;
		IRP_AD_HOC_QUERYCO qryCO;
		Iterator it ;
		IRP_FIELDSCO feCO;
		Long feId;
		Long feIndex;//sometimes the index is changed in the queryDesignerAction.addObjsIndex()
		qryLst = repSessionCO.getReportCO().getQueriesList();
		for(int i=0;i<qryLst.size();i++)
		{
		    qryCO=qryLst.get(i);
		    if(qryCO.getQUERY_NAME().equals(qryNamee))
		    {
			allFields = qryCO.getSqlObject().getFields();
			if(fromPrev!=null && fromPrev.equals("prevGrp"))
			{
			    groupByFields=repSessionCO.getReportCO().getPrevGrpMap();
			    for(Map.Entry<Long, IRP_FIELDSCO> e : allFields.entrySet())
			    {
				feId=e.getKey();
				feCO=e.getValue();
				feIndex=feCO.getIndex();
				if(groupByFields.get(feId)==null && groupByFields.get(feIndex)==null && feCO.getHasBusinessName()==1 )
				{
				    arrayList2.add(feCO);
				}
			    }
			    //add expressions
			    LinkedHashMap< Long, IRP_FIELDSCO> exprMap=qryCO.getSqlObject().getExpressionFields();
			    it=exprMap.values().iterator();
			    while(it.hasNext())
			    {
				feCO=(IRP_FIELDSCO)it.next();
				if( feCO!=null && groupByFields.get(feCO.getIndex())==null)
				{
				    arrayList2.add(feCO);
				}
			    }
			    remFields=new ArrayList<IRP_FIELDSCO>(arrayList2);
			}
			else
			{
			    arrayList1 = new ArrayList<IRP_FIELDSCO>(allFields.values());
			    groupByFields = qryCO.getSqlObject().getGroupByHM();
			    arrayList2 = new ArrayList<IRP_FIELDSCO>(groupByFields.values());
			    remFields = ListUtils.subtract(arrayList1, arrayList2);
			}
						
			fieldsCmbo = (ArrayList)remFields;
		    }
		}
	    }
	}
	catch(Exception e)
	{
	   // log.error("Error filling the fields combo.");
	    handleException(e, "Error filling the fields combo","fillFieldsCmb.exceptionMsg._key");
	    //log.error(e,"");
	}
	return SUCCESS;
    }
    
    public String retFieldsComboLst()throws Exception
    {
    	try
    	{
    		fieldsCmbo=new ArrayList<IRP_FIELDSCO>();
    		CommonReportingSessionCO repSessionCO = retPrevRepSessionCO();
        	List<IRP_AD_HOC_QUERYCO> qryLst = repSessionCO.getReportCO().getQueriesList();
        	IRP_AD_HOC_QUERYCO qryCO;
        	LinkedHashMap<Long, IRP_FIELDSCO> groupByFields;
    		List<IRP_FIELDSCO> arrayList2=new ArrayList<IRP_FIELDSCO>();
        	LinkedHashMap<Long, IRP_FIELDSCO> allFields;
        	List<IRP_FIELDSCO> remFields;
        	Iterator it;
        	IRP_FIELDSCO feCO;
    		Long feId;
    		Long feIndex;
        	for(int i=0;i<qryLst.size();i++)
    		{
    		    qryCO=qryLst.get(i);
    		    if(qryCO.getQUERY_NAME().equals(qryNamee))
    		    {
    		    	allFields = qryCO.getSqlObject().getFields();
    			    groupByFields=repSessionCO.getReportCO().getPrevGrpMap();
    			    for(Map.Entry<Long, IRP_FIELDSCO> e :allFields.entrySet())
    			    {
    				feId=e.getKey();
    				feCO=e.getValue();
    				feIndex=feCO.getIndex();
    				if(groupByFields.get(feId)==null && groupByFields.get(feIndex)==null && feCO.getHasBusinessName()==1)
    				{
    				    arrayList2.add(feCO);
    				}
    			    }
    			    arrayList2.add(allFields.get(fieldIndex));
    			    //add expressions
    			    LinkedHashMap< Long, IRP_FIELDSCO> exprMap=qryCO.getSqlObject().getExpressionFields();
    			    it=exprMap.values().iterator();
    			    while(it.hasNext())
    			    {
    				feCO=(IRP_FIELDSCO)it.next();
    				if(feCO!=null && groupByFields.get(feCO.getIndex())==null)
    				{
    				    arrayList2.add(feCO);
    				}
    			    }
    			    remFields=new ArrayList<IRP_FIELDSCO>(arrayList2);
    		    	
    		    	
    			    fieldsCmbo = (ArrayList)remFields;
    		    }
    		}
        	if(fieldsCmbo==null || fieldsCmbo.isEmpty())
        	{
        		fieldsCmbo = new ArrayList<IRP_FIELDSCO>();
        	}
    	}
    	catch(Exception e)
    	{
    		log.error(e,"");
    	}
    	
    	return SUCCESS;
    }
    
    /**
     * Method to open the filters dialog
     * @return
     */
    public String openArgsFilters()
    {
	try
	{
	    htmlPageRef = get_pageRef().replace("-", "_");
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return ConstantsCommon.REP_ARGS_FILTERS_SCREEN;
    }
    
    /**
     * Method to load the grid of filters
     * @return
     */
    public String loadArgumentsFilters()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    CommonReportingSessionCO repSessionCO = returnReportingSessionObject(get_pageRef());
	    filtersSC.setCREATED_BY(sessionCO.getUserName());
	    filtersSC.setREPORT_ID(repSessionCO.getReportCO().getREPORT_ID());
	    copyproperties(filtersSC);
	    HashMap<String, Object> filtersSCMap=PathPropertyUtil.convertToMap(filtersSC);
	    List<HashMap<String, Object>> filterslistMap = commonReportingBO.retFiltersList(filtersSCMap);
	    String[] propsArr = ConstantsCommon.retFiltersListMap_PROPS.toArray(new String[ConstantsCommon.retFiltersListMap_PROPS.size()]);
	    HashMap<String, Object> retMap;
	    IRP_REP_FILTERSVO filtersVO;
	    ArrayList<IRP_REP_FILTERSVO> listGridFilters = new ArrayList<IRP_REP_FILTERSVO>();
	    for(int i = 0; i < filterslistMap.size(); i++)
	    {
		retMap = filterslistMap.get(i);
		filtersVO = new IRP_REP_FILTERSVO();
		PathPropertyUtil.copyProperties(retMap, filtersVO, false, propsArr);
		listGridFilters.add(filtersVO);
	    }
	    setRecords(commonReportingBO.retFiltersListCount(filtersSCMap));
	    setGridModel(listGridFilters);
	}
	catch(Exception e)
	{
	    if(e.getCause() instanceof NoSuchMethodException)
	    {
	     handleException(null, null, "reporting.newReportingVersion");
	    }
	    else
	    {
		handleException(e, null, null);
	    }
	}
	return SUCCESS;
    }
    
    
    public ArrayList getFieldsCmbo() {
	return fieldsCmbo;
    }
    
    public void setFieldsCmbo(ArrayList fieldsCmbo) {
    	this.fieldsCmbo = fieldsCmbo;
    }
    
    public CommonReportingSessionCO returnReportingSessionObject()
    {
	return returnReportingSessionObject("RD00R");
    }
		
    public CommonReportingSessionCO returnReportingSessionObject(String ref)
    {
	String pageRef=ref;
	if(pageRef==null)
	{
	    pageRef="RD00R";
	}
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
    
    /**
     * Method to Save the sorting in IRP_REP_SORT table
     * @return
     */
    public void saveSorting()throws Exception
    {
	try
	{
	    IRP_FIELDSCO irpFieldCO;
	    htmlPageRef = get_pageRef().replace("-", "_");
	    CommonReportingSessionCO repSessionCO = returnReportingSessionObject(htmlPageRef);
	    SessionCO sessionCO = returnSessionObject();
	    ArrayList lstSortingAll = new ArrayList();
	    if(updates1 != null && !updates1.equals(""))
	    {
		GridUpdates gu = getGridUpdates(updates1, IRP_FIELDSCO.class, true);
		lstSortingAll = gu.getLstAllRec();
	    }
	    ArrayList<HashMap<String, Object>> SortMapList=new ArrayList<HashMap<String, Object>>();
	    for(int i = 0;i<lstSortingAll.size();i++)
	    {
		irpFieldCO = (IRP_FIELDSCO)lstSortingAll.get(i);
		SortMapList.add(PathPropertyUtil.convertToMap(irpFieldCO));
	    }
	    HashMap<String, Object> lstSortingAllMap = new HashMap<String, Object>();
	    lstSortingAllMap.put("lstSorting", SortMapList);
	    lstSortingAllMap.put("reportId", repSessionCO.getReportCO().getREPORT_ID());
	    lstSortingAllMap.put("userId", sessionCO.getUserName());
	    
	    // save
	    commonReportingBO.saveSorting(lstSortingAllMap);
	}
	catch(Exception e)
	{
	    
	}
    }
    
    public static class Group
    {
	public Group(String queryName, String fieldName, Long fieldIndex,String groupName,String feAlias)
	{
	    this.queryName = queryName;
	    this.fieldName = fieldName;
	    this.fieldIndex = fieldIndex;
	    this.groupName=groupName;
	    this.feAlias=feAlias;
	}
	private String groupName;
	private String queryName;
	private String fieldName;
	private Long fieldIndex;
	private String feAlias;
	
	public String getFeAlias() {
	    return feAlias;
	}
	public void setFeAlias(String feAlias) {
	    this.feAlias = feAlias;
	}
	public String getQueryName() {
	    return queryName;
	}
	public void setQueryName(String queryName) {
	    this.queryName = queryName;
	}
	public String getFieldName() {
	    return fieldName;
	}
	public void setFieldName(String fieldName) {
	    this.fieldName = fieldName;
	}
	public Long getFieldIndex() {
	    return fieldIndex;
	}
	public void setFieldIndex(Long fieldIndex) {
	    this.fieldIndex = fieldIndex;
	}
	public String getGroupName() {
	    return groupName;
	}
	public void setGroupName(String groupName) {
	    this.groupName = groupName;
	}
    }
    
    private BaseException retBaseExceptionFromRepException(ReportException re)
    {
	BaseException ba = new BaseException(re.getMessage(),re.getParams());
	ba.setErrorCode(re.getErrorCode());
	return ba;
    }
}