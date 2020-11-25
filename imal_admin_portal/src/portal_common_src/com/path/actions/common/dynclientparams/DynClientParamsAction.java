package com.path.actions.common.dynclientparams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.dynclientparams.DynClientParamsBO;
import com.path.dbmaps.vo.SYS_DYN_PARAM_COLUMNSVOWithBLOBs;
import com.path.dbmaps.vo.SYS_DYN_PARAM_GROUPSVO;
import com.path.dbmaps.vo.SYS_DYN_PARAM_TABLESVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.dynclientparams.DynClientParamsCO;
import com.path.vo.common.dynclientparams.DynClientParamsSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: rabihelkhatib
 * 
 *          TranslationAction.java used to implement the Action methods of the
 *          translation screen
 */
@SuppressWarnings("serial")
public class DynClientParamsAction extends GridBaseAction
{
    private DynClientParamsBO dynClientParamsBO;
    private DynClientParamsSC dynClientParamsSC = new DynClientParamsSC();
    private final DynClientParamsCO dynClientParamsCO = new DynClientParamsCO();
    ArrayList<DynClientParamsCO> colsList = new ArrayList<DynClientParamsCO>();
    private List controlTypeSelect = new ArrayList<SelectCO>();
    private List availableColumns = new ArrayList<SelectCO>();
    
    @Override
    public Object getModel()
    {
	return dynClientParamsSC;
    }

    /***
     * Method for Loading the Main Screen
     * 
     * @return String
     */
    public String loadMainParamScreen()
    {
	if(ConstantsCommon.OPERATION_TYPE_APPROVE.equals(dynClientParamsSC.getDynCltParOpType()))
	{
		set_pageRef(ConstantsCommon.DYN_CLNT_PARAMS_APPROVE_OPT);
	}
	else if(ConstantsCommon.OPERATION_TYPE_EDIT_COLS.equals(dynClientParamsSC.getDynCltParOpType()))
	{
		set_pageRef(ConstantsCommon.DYN_CLNT_PARAMS_COLS_EDIT_OPT);
	}
	else
	{
		set_pageRef(ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT);
	}

	try
	{
	    String dynClientParamAccessRight = returnAccessRightByProgRef(get_pageRef());
	    if(dynClientParamAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
	return SUCCESS;
    }
    public String loadDynClientColsScreen()
    {
	set_showSmartInfoBtn("false");// Disable SMART Button
	set_showRecordLogsBtn("false");
	set_pageRef(ConstantsCommon.DYN_CLNT_PARAMS_COLS_EDIT_OPT);
	return "loadColsScreen";
    }
    
    /***
     * Method for Loading the Main Screen
     * 
     * @return String
     */
    public String loadDynClientScreenData()
    {
	try
	{
	    if(!StringUtil.nullToEmpty(dynClientParamsSC.getTableName()).startsWith(
		    ConstantsCommon.PS_TABLE_NAME_PREFIX))
	    {
		throw new BOException(MessageCodes.WRONG_TABLE_NAME);
	    }
	    set_showSmartInfoBtn("false");// Disable SMART Button
	    set_showRecordLogsBtn("false");
	    if(ConstantsCommon.OPERATION_TYPE_APPROVE.equals(dynClientParamsSC.getDynCltParOpType()))
	    {
		set_pageRef(ConstantsCommon.DYN_CLNT_PARAMS_APPROVE_OPT);
	    }
	    else if(ConstantsCommon.OPERATION_TYPE_EDIT_COLS.equals(dynClientParamsSC.getDynCltParOpType()))
	    {
		set_pageRef(ConstantsCommon.DYN_CLNT_PARAMS_COLS_EDIT_OPT);
	    }
	    else
	    {
		set_pageRef(ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT);
	    }
	    SessionCO currSession = returnSessionObject();
	    dynClientParamsSC.setCompCode(currSession.getCompanyCode());
	    dynClientParamsSC.setBranchCode(currSession.getBranchCode());
	    dynClientParamsSC.setBaseCurrencyCode(currSession.getBaseCurrencyCode());
	    dynClientParamsSC.setUserId(currSession.getUserName());
	    colsList = dynClientParamsBO.selectColumnsList(dynClientParamsSC);
	    dynClientParamsSC.setColsList(colsList);
	    dynClientParamsSC.setColsNames(dynClientParamsBO.returnColsNames(colsList));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return "loadDynClientScreenData";
    }

    /***
     * Method for populating the Groups details grid
     * 
     * @return String
     */
    public String loadGroupsDetailsGrid()
    {
	try
	{
	    String[] searchCols = {"GROUP_CODE", "GROUP_DESC"};
	    dynClientParamsSC.setSearchCols(searchCols);
	    copyproperties(dynClientParamsSC);
	    if(checkNbRec(dynClientParamsSC))
	    {
		setRecords(dynClientParamsBO.selectGroupsListCount(dynClientParamsSC));
	    }
	    ArrayList<SYS_DYN_PARAM_GROUPSVO> dynClientGroupsList = dynClientParamsBO
		    .selectGroupsList(dynClientParamsSC);
	    setGridModel(dynClientGroupsList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    /***
     * Method for populating the Group translation grid
     * 
     * @return String
     */
    public String loadGroupTablesGrid()
    {
	try
	{

	    String[] searchCols = { "GROUP_CODE", "TABLE_NAME", "TABLE_DESC" };
	    dynClientParamsSC.setSearchCols(searchCols);
	    copyproperties(dynClientParamsSC);
	    if(checkNbRec(dynClientParamsSC))
	    {
		setRecords(dynClientParamsBO.selectTablesListCount(dynClientParamsSC));
	    }
	    ArrayList<SYS_DYN_PARAM_TABLESVO> dynClientTablesList = dynClientParamsBO
		    .selectTablesList(dynClientParamsSC);
	    setGridModel(dynClientTablesList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    /***
     * Method for populating the Group translation grid
     * 
     * @return String
     */
    public String loadDynClientColsGrid()
    {
	try
	{
	    String[] searchCols = { "GROUP_CODE", "TABLE_NAME", "COLUMN_NAME", "CONTROL_TYPE", "LOOKUP_EXPRESSION",
		    "VALUE_FIELD", "DISPLAY_FIELD", "COMBO_LIST", "KEY_LABEL_CODE", "PK_YN" };
	    SessionCO currSession = returnSessionObject();
	    dynClientParamsSC.setLovTypeId(ConstantsCommon.CONTROL_TYPE_LOV_ID);
	    dynClientParamsSC.setPreferredLanguage(currSession.getLanguage());
	    dynClientParamsSC.setSearchCols(searchCols);
	    copyproperties(dynClientParamsSC);
	    if(checkNbRec(dynClientParamsSC))
	    {
		setRecords(dynClientParamsBO.selectColumnsListCount(dynClientParamsSC));
	    }
	    ArrayList<DynClientParamsCO> dynClientColumnsList = dynClientParamsBO.selectColumnsList(dynClientParamsSC);
	    setGridModel(dynClientColumnsList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    /**
     * Prepare the needed information from dynamic Grid Get The Sql configured
     * in SADS as parameter return the hash map of the columns values and
     * display the dynamic grid
     * 
     * @return
     */
    public String loadDynClientGridData()
    {
	try
	{
	    DynClientParamsSC newCriteria = new DynClientParamsSC();
	    
	    newCriteria.setColsList(dynClientParamsSC.getColsList());
	    newCriteria.setGroupCode(dynClientParamsSC.getGroupCode());
	    newCriteria.setTableName(dynClientParamsSC.getTableName());
	    newCriteria.setDynCltParOpType(dynClientParamsSC.getDynCltParOpType());
	    ArrayList<DynClientParamsCO> columnsList = dynClientParamsBO.selectColumnsList(newCriteria);

	    String[] searchCol = new String[200];
	    copyproperties(dynClientParamsSC);
	    SessionCO currSession = returnSessionObject();
	    dynClientParamsSC.setCompCode(currSession.getCompanyCode());
	    dynClientParamsSC.setBranchCode(currSession.getBranchCode());
	    dynClientParamsSC.setBaseCurrencyCode(currSession.getBaseCurrencyCode());
	    dynClientParamsSC.setUserId(currSession.getUserName());
	    
	    if(columnsList != null)
	    {
		searchCol[0] = ConstantsCommon.DYNAMIC_STATUS_COLUMN;
		for(int i = 1; columnsList.size() > i; i++)
		{
		    searchCol[i] = columnsList.get(i).getSysDynParamColumns().getCOLUMN_NAME();
		}
		dynClientParamsSC.setColsList(columnsList);
	    }

	    dynClientParamsSC.setPreferredLanguage(currSession.getLanguage());
	    dynClientParamsSC.setSearchCols(searchCol);
	    copysearchproperties(dynClientParamsSC);
	    
	    if(checkNbRec(dynClientParamsSC))
	    {
		setRecords(dynClientParamsBO.returnDynClientParamsQueryListCount(dynClientParamsSC));
	    }
	    List<Object> objList = dynClientParamsBO.returnDynClientParamsQueryList(dynClientParamsSC);
	    setGridModel(objList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    public String dynClientParamsLookupDependency()
    {
	try
	{
	    SessionCO currSession = returnSessionObject();
	    dynClientParamsSC.setCompCode(currSession.getCompanyCode());
	    dynClientParamsSC.setBranchCode(currSession.getBranchCode());
	    dynClientParamsSC.setBaseCurrencyCode(currSession.getBaseCurrencyCode());
	    dynClientParamsSC.setUserId(currSession.getUserName());
	    ArrayList<DynClientParamsCO> columnsList = dynClientParamsBO.selectColumnsList(dynClientParamsSC);
	    List<Object> queryResult = null;
	    if(columnsList != null)
	    {
		for(DynClientParamsCO colDetailsCO : columnsList)
		{
		    if(colDetailsCO.getSysDynParamColumns().getCOLUMN_NAME().equals(dynClientParamsSC.getDynamicQuery()) && ConstantsCommon.LIVESEARCH_CONTROL_TYPE.equals(colDetailsCO.getSysDynParamColumns().getCONTROL_TYPE()))
		    {
			dynClientParamsSC.setDynamicQuery(colDetailsCO.getSysDynParamColumns().getLOOKUP_EXPRESSION());
			queryResult = dynClientParamsBO.evaluateLookupExpression(dynClientParamsSC);
		    }
		}
	    }

		HashMap<String, Object> lookUpRow = new HashMap<String, Object>();
		
		if(queryResult != null && queryResult.size()>0)
		{
		    lookUpRow = (HashMap<String, Object>) queryResult.get(0);
		    dynClientParamsSC.setDisplayField((String) lookUpRow.get(dynClientParamsSC.getDisplayField().toUpperCase()));
		    Object theCode = lookUpRow.get(dynClientParamsSC.getValueField().toUpperCase());
		    dynClientParamsSC.setLookupVal(theCode.toString());
		}
		else
		{
		    dynClientParamsSC.setDisplayField(null);
		    dynClientParamsSC.setLookupVal(null);
		}
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    dynClientParamsSC.setDisplayField(null);
	    dynClientParamsSC.setLookupVal(null);
	}
	return "jsonSuccess";
    }
    
    public String approveAction()
    {
	try
	{
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.APPROVE);
	    refCO.setProgRef(ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT);
	    dynClientParamsSC.getAuditCO().setAuditRefCO(refCO);
	    dynClientParamsSC.setDynCltParOpType(ConstantsCommon.OPERATION_TYPE_APPROVE);
	    dynClientParamsBO.updateDynClientParams(dynClientParamsSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }   

    public String deletedClientParam()
    {
	try
	{
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.DELETE);
	    refCO.setProgRef(ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT);
	    dynClientParamsSC.getAuditCO().setAuditRefCO(refCO);
	    dynClientParamsSC.setDynCltParOpType(ConstantsCommon.OPERATION_TYPE_DELETE);
	    dynClientParamsBO.updateDynClientParams(dynClientParamsSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }


    public String loadControlTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(new BigDecimal(658));
	    controlTypeSelect = returnLOV(selSC);
	    controlTypeSelect.add(0, new SelectCO("-1", ""));

	    HashMap<String, String[]> colsList = dynClientParamsBO.returnColumnsInfo(dynClientParamsSC.getTableName());

	    if(StringUtil.isEmptyString(dynClientParamsSC.getValueField()))
	    {
		controlTypeSelect.clear();
		return "jsonSuccess";
	    }
	    if(colsList != null && colsList.size() > 0)
	    {
		String[] colProps = colsList.get(dynClientParamsSC.getValueField());
		if(colProps != null)
		{
			Iterator<SelectCO> itr = controlTypeSelect.iterator();
			while(itr.hasNext())
			{
			    SelectCO selectedCol = itr.next();
			    if("Date".equals(colProps[0]))
			    {
				    if(!"-1".equals(selectedCol.getCode()) && !"D".equals(selectedCol.getCode()))
				    {
					itr.remove();
				    }
			    }
			    else
			    {
				if("D".equals(selectedCol.getCode()))
				    {
					itr.remove();
				    }
			    }
			    
			}
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    public String loadColumnsList()
    {
	try
	{
	    HashMap<String, String[]> colsList = dynClientParamsBO.returnColumnsInfo(dynClientParamsSC.getTableName());
	    int i = 1;
	    availableColumns.add(0,new SelectCO("-1", ""));
	    for (String entry : colsList.keySet())
	    {
		SelectCO codeDesc = new SelectCO();
		codeDesc.setCode(entry);
		codeDesc.setDescValue(entry);
		availableColumns.add(i,codeDesc);
		i++;
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    public String saveColumnsSpecs()
    {
	try
	{
	    AuditRefCO refCO = initAuditRefCO();
	    dynClientParamsSC.getAuditCO().setAuditRefCO(refCO);
	    SessionCO currSession = returnSessionObject();
	    dynClientParamsSC.setCompCode(currSession.getCompanyCode());
	    dynClientParamsSC.setBranchCode(currSession.getBranchCode());
	    dynClientParamsSC.setBaseCurrencyCode(currSession.getBaseCurrencyCode());
	    dynClientParamsSC.setUserId(currSession.getUserName());
	    String params = StringUtil.nullToEmpty(dynClientParamsSC.getDynCltParamsGridUpd());
	    ArrayList<DynClientParamsCO> lstAdd = null, lstMod = null, lstDel = null;
	    if(!params.isEmpty())
	    {
		GridUpdates gu = getGridUpdates(params, DynClientParamsCO.class);
		lstAdd = gu.getLstAdd();
		if(lstAdd.size() > 0)
		{
		    for(DynClientParamsCO addCO : lstAdd)
		    {
			addCO.getSysDynParamColumns().setPK_YN(StringUtil.nullEmptyToValue(addCO.getSysDynParamColumns().getPK_YN(), "N").toUpperCase());
		    }
		}
		dynClientParamsSC.setAddSysDynParamColumns(lstAdd);
		lstMod = gu.getLstModify();
		if(lstMod.size() > 0)
		{
		    for(DynClientParamsCO addCO : lstMod)
		    {
			if(StringUtil.isNotEmpty(addCO.getSysDynParamColumns().getLOOKUP_EXPRESSION()))
			{
			    
			}
			addCO.getSysDynParamColumns().setPK_YN(StringUtil.nullEmptyToValue(addCO.getSysDynParamColumns().getPK_YN(), "N").toUpperCase());
		    }
		}
		dynClientParamsSC.setModSysDynParamColumns(lstMod);
		lstDel = gu.getLstDelete();
		dynClientParamsSC.setDelSysDynParamColumns(lstDel);
		dynClientParamsBO.saveDynClientParamsTblsColumns(dynClientParamsSC);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    public String createColAuditKeyRef()
    {
	try
	{
	    AuditRefCO refCO = initAuditRefCO();
	    set_pageRef(ConstantsCommon.DYN_CLNT_PARAMS_COLS_EDIT_OPT);
	    refCO.setProgRef(ConstantsCommon.DYN_CLNT_PARAMS_COLS_EDIT_OPT);
	    dynClientParamsSC.getAuditCO().setAuditRefCO(refCO);
	    HashMap<String,String> selectedRow = (HashMap<String,String>) returnJsonObjectFromStr(HashMap.class, dynClientParamsSC.getPkCols());
            putAuditObject(dynClientParamsSC);
	    refCO.setKeyRef(AuditConstant.DYNAMIC_CLIENT_PARAMS_KEY_REF);
	    SYS_DYN_PARAM_COLUMNSVOWithBLOBs selectedAuditRow = new SYS_DYN_PARAM_COLUMNSVOWithBLOBs();
	    selectedAuditRow.setGROUP_CODE(new BigDecimal(selectedRow.get("GROUP_CODE")));
	    selectedAuditRow.setTABLE_NAME(selectedRow.get("TABLE_NAME"));
	    selectedAuditRow.setCONTROL_TYPE(selectedRow.get("CONTROL_TYPE"));
	    selectedAuditRow.setCOLUMN_NAME(selectedRow.get("COLUMN_NAME"));
	    setAuditTrxNbr(auditBO.checkAuditKey(selectedAuditRow, refCO));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    public void setDynClientParamsBO(DynClientParamsBO dynClientParamsBO)
    {
        this.dynClientParamsBO = dynClientParamsBO;
    }
    
    public DynClientParamsSC getDynClientParamsSC()
    {
        return dynClientParamsSC;
    }

    public void setDynClientParamsSC(DynClientParamsSC dynClientParamsSC)
    {
        this.dynClientParamsSC = dynClientParamsSC;
    }


    public DynClientParamsCO getDynClientParamsCO()
    {
        return dynClientParamsCO;
    }  
    public ArrayList<DynClientParamsCO> getColsList()
    {
        return colsList;
    }

    public List getControlTypeSelect()
    {
        return controlTypeSelect;
    }

    public void setControlTypeSelect(List controlTypeSelect)
    {
        this.controlTypeSelect = controlTypeSelect;
    }

    public List getAvailableColumns()
    {
        return availableColumns;
    }

    public void setAvailableColumns(List availableColumns)
    {
        this.availableColumns = availableColumns;
    }
}