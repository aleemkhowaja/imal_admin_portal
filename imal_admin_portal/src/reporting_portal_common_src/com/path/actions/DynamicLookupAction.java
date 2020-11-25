package com.path.actions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.path.bo.common.CommonLibBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.reporting.CommonReportingBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.reporting.DynLookupSC;

public class DynamicLookupAction extends LookupBaseAction implements ServletRequestAware, ServletResponseAware
{
    private String qryId;
    private String repApp;
    private String repRef;
    private final DynLookupSC dynLookupSC = new DynLookupSC();
    private CommonReportingBO commonReportingBO;
    protected HttpServletRequest request;
    private CommonLibBO commonLibBO;
    
    
    
    
    public void setCommonLibBO(CommonLibBO commonLibBO)
    {
        this.commonLibBO = commonLibBO;
    }

    public void setServletRequest(HttpServletRequest request)
    {
	this.request = request;
    }
    
    public void setCommonReportingBO(CommonReportingBO commonReportingBO)
    {
        this.commonReportingBO = commonReportingBO;
    }

    public String getQryId()
    {
        return qryId;
    }

    public void setQryId(String qryId)
    {
        this.qryId = qryId;
    }

    public String getRepApp()
    {
        return repApp;
    }

    public void setRepApp(String repApp)
    {
        this.repApp = repApp;
    }

    public String getRepRef()
    {
        return repRef;
    }

    public void setRepRef(String repRef)
    {
        this.repRef = repRef;
    }

    public String constructQryLookup()
    {
	try
	{	   
	    SessionCO sessionCO = returnSessionObject();
	    copyproperties(dynLookupSC);
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("10");
	    grid.setUrl("/path/repCommon/dynLkupAction_fillQryLookup?qryId="+qryId);
	    grid.setFilter(true);
	    List<String[]> colsList = commonReportingBO.returnColsList(qryId);
	    if(colsList==null)
	    {
		BOException queryNoSyntax = new BOException("");
		queryNoSyntax.setMsgIdent(ConstantsCommon.QUERY_NO_DEFINED_SYNTAX);
		throw queryNoSyntax;
	    }
	    String[] col;
	    LookupGridColumn gridColumn;
	    String  paramLblTrans;
	    
	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
	    
	    for(int i = 0; i < colsList.size(); i++)
	    {
		gridColumn = new LookupGridColumn();
		col = colsList.get(i);
		gridColumn.setName(col[0]);
		gridColumn.setIndex(col[0]);
		gridColumn.setColType(col[1]);
		if(ConstantsCommon.PARAM_TYPE_DATE.equals(col[1]))
		{
		    gridColumn.setFormatter(ConstantsCommon.COLUMN_DATE_TYPE);
		}
		//return the translation of the grid label
		paramLblTrans = returnKeyTrans(col[0], getRepApp(), getRepRef()); 
		gridColumn.setTitle(paramLblTrans);
		gridColumn.setSortable(true);
		lsGridColumn.add(gridColumn);
	    }
//	    dynLookupSC.setHmQryParam(hmQryParam);
	    lookup(grid, lsGridColumn, null, dynLookupSC);
	}
	catch(BOException e)
	{
	    if(ConstantsCommon.QUERY_NO_DEFINED_SYNTAX.equals(e.getMsgIdent()))
	    {
		handleException(e, getText("queryIdkey") + " " + qryId + " " + getText("hasnodefinedsyntaxkey"), null);
	    }
	    else
	    {
		handleException(e, "constructingQryLkp.exceptionMsg._key", "constructingQryLkp.exceptionMsg._key");
	    }

	}
	catch(Exception e)
	{
	    //log.error(e, "Error constructing the query lookup");
	    handleException(e, "Error constructing the query lookup","constructingQryLkp.exceptionMsg._key");
	}
	return SUCCESS;
    }
    
    public String fillQryLookup() 
    {
	try
	{
	    
	    
	    String itemName; 
	    String itemValue;
	    Enumeration enu = request.getParameterNames();
	    //String gridParamUrl="";
	   // request.getp
	    HashMap<String, String> hmQryParam = dynLookupSC.getHmQryParam();
    	    while(enu.hasMoreElements())
    	    {
    		itemName = (String) enu.nextElement();
    		itemValue = request.getParameter(itemName);
    		if(!"qryId".equals(itemName))
    		{
    		    //gridParamUrl = gridParamUrl+"&"+itemName+"="+itemValue;
    		    hmQryParam.put(itemName, itemValue);
    		}
    		if("conId".equals(itemName) && (!("").equals(itemValue)))
    		{
    		    dynLookupSC.setConnId(new BigDecimal(itemValue));
    		}
	    
    	    }
    	   List<String[]> colsList = commonReportingBO.returnColsList(qryId);
	    String[] searchCols = new String[colsList.size()];
	    String[] cols ;
	    String colName;
	    for(int i=0;i<colsList.size();i++)
	    {
		cols =colsList.get(i);
		colName =cols[0];
		searchCols[i] = colName;
	    }
	    dynLookupSC.setFilters(request.getParameter("filters"));
	    dynLookupSC.setSearchCols(searchCols);
	    
	   String sord= request.getParameter("sord");
	   String sidx=request.getParameter("sidx");
	   if(!StringUtil.nullToEmpty(sord).isEmpty() && !(StringUtil.nullToEmpty(sidx).isEmpty()))
	   {
		dynLookupSC.setSortOrder(ConstantsCommon.ORDER_BY_STR +sidx+" "+sord);
	   }
	   
    	    dynLookupSC.setIsSybase(commonLibBO.returnIsSybase());
    	    dynLookupSC.setHmQryParam(hmQryParam);
	    setSearchFilter(dynLookupSC);
	    copyproperties(dynLookupSC);
	    dynLookupSC.setQryId(qryId);
	    
	    SessionCO sessionCO = returnSessionObject();
	    
	    dynLookupSC.setCompCode(sessionCO.getCompanyCode());
	    dynLookupSC.setBranchCode(sessionCO.getBranchCode());
	    dynLookupSC.setUserId(sessionCO.getUserName());
	    dynLookupSC.setCurrAppName(sessionCO.getCurrentAppName());
	    HashMap<String,Object> dynLookupSCMap=new HashMap<String,Object>();
	    String[] propsArr= ConstantsCommon.returnQryResult_PROPS.toArray(new String[ConstantsCommon.returnQryResult_PROPS.size()]);
	    PathPropertyUtil.copyProperties(dynLookupSC, dynLookupSCMap,false,propsArr);
	    if(getRecords() == 0)
	    {
	    	setRecords(commonReportingBO.returnQryResultCnt(dynLookupSCMap));
	    }
	    ArrayList<LinkedHashMap> list = commonReportingBO.returnQryResult(dynLookupSCMap);
	    setGridModel(list);
	}
	catch(Exception e)
	{
	    //log.error(e, "Error filling query lookup");
	    handleException(e, "Error filling query lookup","fillQryLookup.exceptionMsg._key");
	}
	return SUCCESS;
    }
}
