package com.path.actions.common.dynclientparams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.JSONUtil;

import com.path.actions.admin.dynamicparams.DynamicParamsAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.dynclientparams.DynClientParamsBO;
import com.path.dbmaps.vo.SYS_DYN_PARAM_COLUMNSVOWithBLOBs;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.PathActionContextMethods;
import com.path.vo.admin.dynamicparams.DynamicParamsVO;
import com.path.vo.admin.dynamicparams.ListParamVO;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.dynclientparams.DynClientParamsCO;
import com.path.vo.common.dynclientparams.DynClientParamsSC;
import com.path.vo.common.select.SelectCO;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: rabihelkhatib
 * 
 *          DynClientDynamicParamsAction.java used to implement the Action
 *          methods of the Dynamic Client Params screen
 */
@SuppressWarnings("serial")
public class DynClientDynamicParamsAction extends DynamicParamsAction
{
    private DynClientParamsBO dynClientParamsBO;
    private DynClientParamsSC dynClientParamsSC = new DynClientParamsSC();
    private DynClientParamsCO dynClientParamsCO = new DynClientParamsCO();
    ArrayList<DynClientParamsCO> colsList = new ArrayList<DynClientParamsCO>();
    HashMap<String, String> combosValues = new HashMap<String, String>();
    HashMap<String, String> auditInitialValues = new HashMap<String, String>();
    String auditKeyRef;;
    private final HashMap<String, ArrayList<SelectCO>> combosLists = new HashMap<String, ArrayList<SelectCO>>();
    ArrayList<DynamicParamsVO> formLst;

    public String execute()
    {
	try
	{
	    set_pageRef(ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT);
	    fillFormElement();
	    return SUCCESS_DYNAMIC_PARAM;
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
    }

    private void fillFormElement() throws Exception
    {

	    int colN = 0, rowN = 0;
	    formLst = new ArrayList<DynamicParamsVO>();
	    HashMap<String, String[]> colInfo = dynClientParamsBO.returnColumnsInfo(dynClientParamsSC.getTableName());
	    	    
	    SessionCO currSession = returnSessionObject();
	    dynClientParamsSC.setCompCode(currSession.getCompanyCode());
	    dynClientParamsSC.setBranchCode(currSession.getBranchCode());
	    dynClientParamsSC.setBaseCurrencyCode(currSession.getBaseCurrencyCode());
	    dynClientParamsSC.setUserId(currSession.getUserName());
	    
	    colsList = dynClientParamsBO.selectColumnsList(dynClientParamsSC);
	    HashMap<String, Object> colsVal = new HashMap<String, Object>();
	    if(StringUtil.isNotEmpty(dynClientParamsSC.getPkCols())
		    && !ConstantsCommon.OPERATION_TYPE_NEW.equals(dynClientParamsSC.getDynCltParOpType()))
	    {
		colsVal = dynClientParamsBO.returnDynClientParamsFormData(dynClientParamsSC);
	    }
	    String recStatus = ConstantsCommon.OLD_RECORD, readOnlyFlag, requiredFlag;
	    DynamicParamsVO paramVO;
	    HashMap<String, String> selectedRowData = new HashMap<String, String>();

	    selectedRowData = (HashMap<String, String>) JSONUtil.deserialize(dynClientParamsSC.getLookupVal());
	    StringBuffer auditKeyBuff = new StringBuffer();
	    String tableID = dynClientParamsBO.returnTableID(dynClientParamsSC);
	    
	    auditKeyBuff.append(tableID);
	    auditKeyBuff.append(":");
	    auditKeyBuff.append("12");
	    auditKeyBuff.append(":");
	    auditKeyBuff.append("X");
	    auditKeyBuff.append(",");
	    for(DynClientParamsCO colDetailsCO : colsList)
	    {
		readOnlyFlag = "false";
		requiredFlag = "false";
		
		SYS_DYN_PARAM_COLUMNSVOWithBLOBs colDetails = colDetailsCO.getSysDynParamColumns();
		if((colN % 3) == 0)
		{
		    colN = 0;
		    rowN++;
		}
		colN++;
		
		String controlType = colDetails.getCONTROL_TYPE();
		String paramVal = "";
		
		if(colsVal != null && colsVal.size() > 0)
		{
		    if(colsVal.get(colDetails.getCOLUMN_NAME())!=null)
		    {
			if(ConstantsCommon.DATE_CONTROL_TYPE.equals(controlType))
			{
			    paramVal = DateUtil.format((Date) colsVal.get(colDetails.getCOLUMN_NAME()), "MM/dd/yyyy");
			}
			else
			{
			    paramVal = colsVal.get(colDetails.getCOLUMN_NAME()).toString();
			}

			if(ConstantsCommon.YES.equals(colDetails.getPK_YN()))
			{
			    if("-".equals(StringUtil.substring(paramVal, 1)))
			    {
				paramVal = StringUtil.substring(paramVal,2,paramVal.length());
			    }
			    readOnlyFlag = "true";
			    auditKeyBuff.append(colDetails.getCOLUMN_NAME());
			    auditKeyBuff.append(":");
			    auditKeyBuff.append(Integer.parseInt(colInfo.get(colDetails.getCOLUMN_NAME())[1]));
			    auditKeyBuff.append(",");
			}
		    }
		}
		else
		{
		    recStatus = ConstantsCommon.NEW_RECORD;
		}
		if(ConstantsCommon.YES.equals(colDetails.getPK_YN()) || ConstantsCommon.ZERO.equals(colInfo.get(StringUtil.nullToEmpty(colDetails.getCOLUMN_NAME()).toUpperCase())[2]))
		{
		    requiredFlag = "true";
		}
		
		char cntrl = controlType.charAt(0);
		switch (cntrl)
		{
		    case 'T': //Control type text
			paramVO = new DynamicParamsVO();
			paramVO.setLabel(colDetails.getKEY_LABEL_CODE());
			paramVO.setElement_dataType(colInfo.get(colDetails.getCOLUMN_NAME())[0]);
			//set maxlength to actual length -1 to handle the negative (-) sign added for active/approved status
			paramVO.setMaxLength(Integer.parseInt(colInfo.get(colDetails.getCOLUMN_NAME())[1])-1);
			paramVO.setElement_type(TEXTFIELD_ELEMENT);
			paramVO.setId(colDetails.getCOLUMN_NAME()+"_"+get_pageRef());
			paramVO.setName(colDetails.getCOLUMN_NAME());
			paramVO.setValue(paramVal);
			paramVO.setRow(rowN);
			paramVO.setColumn(colN);
			paramVO.setReadOnly(readOnlyFlag);
			paramVO.setRequired(requiredFlag);
			formLst.add(paramVO);
			break;
		    case 'D':
			paramVO = new DynamicParamsVO();
			paramVO.setLabel(colDetails.getKEY_LABEL_CODE());
			paramVO.setElement_dataType(colInfo.get(colDetails.getCOLUMN_NAME())[0]);
			paramVO.setElement_type(DATE_ELEMENT);
			paramVO.setId(colDetails.getCOLUMN_NAME()+"_"+get_pageRef());
			paramVO.setName(colDetails.getCOLUMN_NAME());
			paramVO.setValue(paramVal);
			paramVO.setRow(rowN);
			paramVO.setColumn(colN);
			paramVO.setReadOnly(readOnlyFlag);
			paramVO.setRequired(requiredFlag);
			formLst.add(paramVO);
			break;

		    case 'S':
			// for LiveSearch
			paramVO = new DynamicParamsVO();
			paramVO.setLabel(colDetails.getKEY_LABEL_CODE());
			paramVO.setMode(StringUtil.nullToEmpty(colInfo.get(colDetails.getCOLUMN_NAME())[0]).toLowerCase());
			paramVO.setElement_type(LIVESEARCH_ELEMENT);
			paramVO.setId(colDetails.getCOLUMN_NAME()+"_"+get_pageRef());
			paramVO.setName(colDetails.getCOLUMN_NAME());
			if(DT_NUMBER.equals(colInfo.get(colDetails.getCOLUMN_NAME())))
			{
			    paramVO.setMode(MODE_NUMBER);
			}
			paramVO.setParamList(colDetails.getVALUE_FIELD().toUpperCase() + ":lookuptxt_" + colDetails.getCOLUMN_NAME()+"_"+get_pageRef());
			//set maxlength to actual length -1 to handle the negative (-) sign added for active/approved status 
			paramVO.setMaxLength(Integer.parseInt(colInfo.get(colDetails.getCOLUMN_NAME())[1])-1);
			String colsNames = dynClientParamsBO.returnLookupColsNames(colDetails.getLOOKUP_EXPRESSION());
			paramVO
				.setActionName("/pathdesktop/DynClientParamsLookup_constructDynClientGridDataLookup?" +
						"dynClientParamsSC.valueField="	+ colDetails.getVALUE_FIELD()
					+ "&dynClientParamsSC.displayField=" + colDetails.getDISPLAY_FIELD()
					+ "&dynClientParamsSC.tableName=" + dynClientParamsSC.getTableName()
					+ "&dynClientParamsSC.groupCode=" + dynClientParamsSC.getGroupCode()
					+ "&dynClientParamsSC.dynamicQuery=" + colDetails.getCOLUMN_NAME()
					+ "&dynClientParamsSC.colsNames=" + colsNames);

			paramVO.setSearchElement(colDetails.getVALUE_FIELD().toUpperCase());
			paramVO.setResultList(colDetails.getVALUE_FIELD().toUpperCase() + ":lookuptxt_" + colDetails.getCOLUMN_NAME()+"_"+get_pageRef()
				+ "," + colDetails.getDISPLAY_FIELD().toUpperCase() + ":lookup_name_"
				+ colDetails.getCOLUMN_NAME()+"_"+get_pageRef());
			paramVO.setParameters("dynClientParamsSC.displayField:'" + colDetails.getDISPLAY_FIELD()
				+ "',dynClientParamsSC.lookupVal:" + "lookuptxt_" + colDetails.getCOLUMN_NAME()+"_"+get_pageRef()
				+ ",dynClientParamsSC.valueField:'" + colDetails.getVALUE_FIELD().toUpperCase() + "'"
				+ ",dynClientParamsSC.tableName:'" + dynClientParamsSC.getTableName()+"'"
				//668564 dependency couldn't convert quoted string to BigDecimal
				+ ",dynClientParamsSC.groupCode:~CONST_" + dynClientParamsSC.getGroupCode()
				+",dynClientParamsSC.dynamicQuery:'"+colDetails.getCOLUMN_NAME() + "'");
			paramVO
				.setDependencySrc("/path/dynClientParams/DynClientParamsMaint_dynClientParamsLookupDependency");
			paramVO.setDependency("lookup_name_" + colDetails.getCOLUMN_NAME()+"_"+get_pageRef()
				+ ":dynClientParamsSC.displayField,lookuptxt_" + colDetails.getCOLUMN_NAME()+"_"+get_pageRef()
				+ ":dynClientParamsSC.lookupVal");

			paramVO.setValue(paramVal);
			paramVO.setRow(rowN);
			paramVO.setColumn(colN);
			paramVO.setReadOnly(readOnlyFlag);
			paramVO.setRequired(requiredFlag);
			formLst.add(paramVO);
			// LiveSearch Related Text
			paramVO = new DynamicParamsVO();
			paramVO.setElement_type(TEXTFIELD_ELEMENT);
			paramVO.setId("lookup_name_" + colDetails.getCOLUMN_NAME()+"_"+get_pageRef());
			if(ConstantsCommon.OLD_RECORD.equals(recStatus))
			{
			    dynClientParamsSC.setDynamicQuery(colDetails.getLOOKUP_EXPRESSION());
			    dynClientParamsSC.setValueField(colDetails.getVALUE_FIELD());
			    dynClientParamsSC.setDisplayField(colDetails.getDISPLAY_FIELD());
			    dynClientParamsSC.setLookupVal(selectedRowData.get(colDetails.getCOLUMN_NAME()));
			    paramVO.setValue(getLookupDesc(dynClientParamsSC));
			}
			paramVO.setReadOnly("true");
			paramVO.setRow(rowN);
			paramVO.setColumn((colN == 3)?4:++colN);
			formLst.add(paramVO);
			break;

		    case 'C':
			paramVO = new DynamicParamsVO();
			paramVO.setId(colDetails.getCOLUMN_NAME()+"_"+get_pageRef());
			paramVO.setElement_type(COMBO_ELEMENT);
			paramVO.setLabel(colDetails.getKEY_LABEL_CODE());
			paramVO.setElement_dataType(colInfo.get(colDetails.getCOLUMN_NAME())[0]);
			paramVO.setColumn(colN);
			paramVO.setRow(rowN);
			paramVO.setReadOnly(readOnlyFlag);
			paramVO.setRequired(requiredFlag);
			ListParamVO lstParamVO = new ListParamVO();
			if(StringUtil.isNotEmpty(colDetails.getLOOKUP_EXPRESSION()))
			{
			    fillCombo(colDetails.getLOOKUP_EXPRESSION(), colDetails, true);
			}
			else
			{
			    fillCombo(colDetails.getCOMBO_LIST(), colDetails, false);
			}
			lstParamVO.setValueList("combosLists."+colDetails.getCOLUMN_NAME());
			lstParamVO.setKey("code");
			lstParamVO.setValue("descValue");
			paramVO.setListParamVO(lstParamVO);
			paramVO.setName("combosValues." + colDetails.getCOLUMN_NAME());
			combosValues.put(colDetails.getCOLUMN_NAME(), paramVal);
			paramVO.setListParamVO(lstParamVO);
			formLst.add(paramVO);

			break;
		    default:
			break;
		}

		if(StringUtil.isNotEmpty(paramVal)&&ConstantsCommon.DATE_CONTROL_TYPE.equals(controlType))
		{
		    paramVal = DateUtil.format(DateUtil.parseDate(paramVal, "MM/dd/yyyy"), "dd/MM/yyyy");			    
		}
		auditInitialValues.put(colDetails.getCOLUMN_NAME(), paramVal);
	    }

	    auditKeyRef = auditKeyBuff.toString();

	    if(ConstantsCommon.OPERATION_TYPE_MODIFY.equals(dynClientParamsSC.getDynCltParOpType()))
	    {
		applyRetrieveAudit(auditKeyRef, auditInitialValues, auditInitialValues);
	    }
	    
	    if(!ConstantsCommon.OPERATION_TYPE_APPROVE.equals(dynClientParamsSC.getDynCltParOpType()))
	    {
		paramVO = new DynamicParamsVO();
		paramVO.setLabel("save_key");
		paramVO.setElement_type(BUTTON_ELEMENT);
		paramVO.setId("saveDynClientDynamicParamsContent"+"_"+get_pageRef());
		paramVO.setName("saveDynClientDynamicParamsContent");
		paramVO.setRow(++rowN);
		paramVO.setColumn(4);
		formLst.add(paramVO);
	    }

	    paramVO = new DynamicParamsVO();
	    paramVO.setElement_dataType("DT_NUMBER");
	    paramVO.setElement_type(HIDDEN_ELEMENT);
	    paramVO.setId("groupCode");
	    paramVO.setName("groupCode");
	    paramVO.setValue(dynClientParamsSC.getGroupCode().toString());
	    paramVO.setRow(0);
	    paramVO.setColumn(2);
	    formLst.add(paramVO);

	    paramVO = new DynamicParamsVO();
	    paramVO.setElement_dataType("DT_STRING");
	    paramVO.setElement_type(HIDDEN_ELEMENT);
	    paramVO.setId("tableName");
	    paramVO.setName("tableName");
	    paramVO.setValue(dynClientParamsSC.getTableName());
	    paramVO.setRow(0);
	    paramVO.setColumn(4);
	    formLst.add(paramVO);


	    paramVO = new DynamicParamsVO();
	    paramVO.setElement_dataType("DT_STRING");
	    paramVO.setElement_type(HIDDEN_ELEMENT);
	    paramVO.setId("dynClientParamsAuditTrxNbr"+"_"+get_pageRef());
	    paramVO.setName("dynClientParamsAuditTrxNbr");
	    paramVO.setValue(StringUtil.nullToEmpty(getAuditTrxNbr()));
	    paramVO.setRow(0);
	    paramVO.setColumn(1);
	    formLst.add(paramVO);
	    
	    paramVO = new DynamicParamsVO();
	    paramVO.setElement_dataType("DT_STRING");
	    paramVO.setElement_type(HIDDEN_ELEMENT);
	    paramVO.setId("dynClientParamsPageRef");
	    paramVO.setName("dynClientParamsPageRef");
	    paramVO.setValue(get_pageRef());
	    paramVO.setRow(0);
	    paramVO.setColumn(3);
	    formLst.add(paramVO);
	    
	    super.fillFormElements(formLst, "", "dynClientParamsDynamicFormId_"+ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT, "", ConstantsCommon.TRUE);
	    getFormVO().setUseHiddenProps(ConstantsCommon.TRUE);
    }

    public String submitAction()
    {
	try
	{
	    Map paramMap = PathActionContextMethods.returnParameters();
	    String[] colsNames = (String[]) paramMap.get("colsNames");
	    String[] pkCols = (String[]) paramMap.get("pkCols");
	    String[] groupCode = (String[]) paramMap.get("groupCode");
	    String[] tableName = (String[]) paramMap.get("tableName");
	    String[] dynCltRecStatus = (String[]) paramMap.get("dynCltRecStatus");
	    String[] dynCltParOpType = (String[]) paramMap.get("dynCltParOpType");
	    String[] auditTrxNbr = (String[]) paramMap.get("auditTrxNbr");
	    String dataValue;
	    HashMap colValueMap = new HashMap();

	    if(colsNames != null)
	    {
		String[] colsNamesArray = colsNames[0].split(",");
		for(String colName : colsNamesArray)
		{
		    String[] colVal = (String[]) paramMap.get(colName);
		    dataValue = colVal != null ? colVal[0] : null;
		    colValueMap.put(colName, dataValue);
		}
		dynClientParamsSC.setColsValues(colValueMap);
		dynClientParamsSC.setColsNames(colsNames[0]);
	    }

	    dynClientParamsSC.setPkCols(pkCols != null ? pkCols[0] : null);
	    dynClientParamsSC.setGroupCode(groupCode != null ? new BigDecimal(groupCode[0]) : null);
	    dynClientParamsSC.setTableName(tableName != null ? tableName[0] : null);
	    dynClientParamsSC.setDynCltParOpType(dynCltParOpType != null ? dynCltParOpType[0] : null);
	    dynClientParamsSC.setDynCltRecStatus(dynCltRecStatus != null ? dynCltRecStatus[0] : null);
	    
	    SessionCO currSession = returnSessionObject();
	    dynClientParamsSC.setCompCode(currSession.getCompanyCode());
	    dynClientParamsSC.setBranchCode(currSession.getBranchCode());
	    dynClientParamsSC.setBaseCurrencyCode(currSession.getBaseCurrencyCode());
	    dynClientParamsSC.setUserId(currSession.getUserName());
	    
	    if(ConstantsCommon.OPERATION_TYPE_NEW.equals(dynClientParamsSC.getDynCltParOpType()))
	    {
		// construct Audit Reference
		AuditRefCO refCO = initAuditRefCO();
		refCO.setOperationType(AuditConstant.CREATED);
		refCO.setProgRef(ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT);
		refCO.setTrxNbr(auditTrxNbr != null ? auditTrxNbr[0] : null);
		dynClientParamsSC.getAuditCO().setAuditRefCO(refCO);
	    }
	    else
	    {
		// construct Audit Reference
		AuditRefCO refCO = initAuditRefCO();
		refCO.setOperationType(AuditConstant.UPDATE);
		refCO.setProgRef(ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT);
		refCO.setTrxNbr(auditTrxNbr != null ? auditTrxNbr[0] : null);
		dynClientParamsSC.getAuditCO().setAuditRefCO(refCO);
		dynClientParamsSC.getAuditCO().setAuditObj(returnAuditObject(auditInitialValues.getClass()));
	    }
	    
	    dynClientParamsBO.updateDynClientParams(dynClientParamsSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    private void fillCombo(String comboList, SYS_DYN_PARAM_COLUMNSVOWithBLOBs colDetails, Boolean isQuery)
	    throws BaseException
    {
	    List optionsList = new ArrayList<SelectCO>();
	    SelectCO sco;
	    if(isQuery)
	    {
		dynClientParamsSC.setDynamicQuery(comboList);
		dynClientParamsSC.setNbRec(-1);

		List resultsList = dynClientParamsBO.returnDynClientParamsQueryList(dynClientParamsSC);
		if(resultsList != null && resultsList.size() > 0)
		{
		    if(resultsList.size() > 500)
		    {
			throw new BOException("Combo list: " + getText(colDetails.getKEY_LABEL_CODE())
				+ " have too many values! \n Please use Live Search instead.");
		    }
		    for(int j = 0; resultsList.size() > j; j++)
		    {
			LinkedHashMap<String, String> resultRow = (LinkedHashMap<String, String>) resultsList.get(j);
			sco = new SelectCO();
			Object overcomeBD = resultRow.get(colDetails.getVALUE_FIELD());
			sco.setCode(overcomeBD.toString());
			sco.setDescValue(StringUtil.nullEmptyToValue(resultRow.get(colDetails.getDISPLAY_FIELD()), sco
				.getCode()));
			optionsList.add(j, sco);
		    }
		}

	    }
	    else
	    {
		int i = 0;
		String[] comboOptions = comboList.split(",");
		for(String option : comboOptions)
		{
		    sco = new SelectCO();
		    String[] optKeyVal = option.split(":");
		    sco.setCode(optKeyVal[0]);
		    sco.setDescValue(getText(optKeyVal[1]));
		    optionsList.add(i, sco);
		    i++;
		}
	    }
	    combosLists.put(colDetails.getCOLUMN_NAME(), (ArrayList<SelectCO>) optionsList);
    }

    private String getLookupDesc (DynClientParamsSC dynClientParamsSC) 
    {
	String lookUpDesc = "";
	try
	{
		List<Object> queryResult = dynClientParamsBO.evaluateLookupExpression(dynClientParamsSC);
		
		HashMap<String, String> lookUpRow = new HashMap<String, String>();
		
		if(queryResult != null && queryResult.size()>0)
		{
		    lookUpRow = (HashMap<String, String>) queryResult.get(0);
		}
		
		lookUpDesc = lookUpRow.get(dynClientParamsSC.getDisplayField().toUpperCase());
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return StringUtil.nullToEmpty(lookUpDesc);

    }

    public String createAuditKeyRef() throws BaseException
    {
	String[] columnsKeyVal = dynClientParamsSC.getPkCols().split("~");
	if(!ConstantsCommon.FALSE.equals(StringUtil.nullEmptyToValue(columnsKeyVal[0], ConstantsCommon.FALSE)))
	{
	    HashMap<String, String> theKeyMap = new HashMap<String, String>();
	    StringBuffer auditKeyBuff = new StringBuffer();
	    String tableID = dynClientParamsBO.returnTableID(dynClientParamsSC);
	    HashMap<String, String[]> colInfo = dynClientParamsBO.returnColumnsInfo(dynClientParamsSC.getTableName());

	    auditKeyBuff.append(tableID);
	    auditKeyBuff.append(":");
	    auditKeyBuff.append("12");
	    auditKeyBuff.append(":");
	    auditKeyBuff.append("X");
	    auditKeyBuff.append(",");

	    for(String colKeyVal : columnsKeyVal)
	    {
		String colKey, colVal;
		String[] keyVal = colKeyVal.split(":");
		colKey = keyVal[0];
		colVal = keyVal[1];
		colVal = ("-".equals(StringUtil.nullToEmpty(colVal).substring(0, 1))) ? colVal.substring(1, colVal
			.length()) : colVal;
		theKeyMap.put(colKey, colVal);
		auditKeyBuff.append(colKey);
		auditKeyBuff.append(":");
		auditKeyBuff.append(Integer.parseInt(colInfo.get(colKey)[1]));
		auditKeyBuff.append(",");
	    }
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.RETRIEVE);
	    refCO.setProgRef(ConstantsCommon.DYN_CLNT_PARAMS_EDIT_OPT);
	    refCO.setKeyRef(auditKeyBuff.toString());
	    refCO.setTrxNbr(auditBO.checkAuditKey(theKeyMap, refCO));
	    dynClientParamsSC.getAuditCO().setAuditRefCO(refCO);
	}

	return "jsonSuccess";
    }
    
    public ArrayList<DynClientParamsCO> getColsList()
    {
	return colsList;
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

    public ArrayList<DynamicParamsVO> getFormLst()
    {
	return formLst;
    }

    public void setFormLst(ArrayList<DynamicParamsVO> formLst)
    {
	this.formLst = formLst;
    }

    public void setDynClientParamsCO(DynClientParamsCO dynClientParamsCO)
    {
	this.dynClientParamsCO = dynClientParamsCO;
    }

    public void setColsList(ArrayList<DynClientParamsCO> colsList)
    {
	this.colsList = colsList;
    }

    public HashMap<String, String> getCombosValues()
    {
        return combosValues;
    }

    public HashMap<String, ArrayList<SelectCO>> getCombosLists()
    {
        return combosLists;
    }

    public String getAuditRef()
    {
        return auditKeyRef;
    }

    public void setAuditRef(String auditRef)
    {
        this.auditKeyRef = auditRef;
    }
   
}