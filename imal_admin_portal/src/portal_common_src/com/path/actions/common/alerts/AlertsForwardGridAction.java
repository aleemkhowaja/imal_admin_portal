package com.path.actions.common.alerts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.AlertCO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ctsteller.CTSTELLERSC;

public class AlertsForwardGridAction extends GridBaseAction
{

private CTSTELLERSC ctsTellerSC = new CTSTELLERSC();
private AlertsBO alertsBO;

@Override
public Object getModel()
{
	return ctsTellerSC;
}


public CTSTELLERSC getCtsTellerSC()
{
    return ctsTellerSC;
}

public void setCtsTellerSC(CTSTELLERSC ctsTellerSC)
{
    this.ctsTellerSC = ctsTellerSC;
}

public void setAlertsBO(AlertsBO alertsBO)
{
    this.alertsBO = alertsBO;
}

/**
 * Load the data for Forward Alerts details grid 
 * @return
 */

    public String loadForwardAlertsGrid() 
    {
	String[] searchCol = { "CODE", "BRANCH_CODE", "BRIEF_NAME_ENG", "LONG_NAME_ENG", "BRIEF_NAME_ARAB",
		"LONG_NAME_ARAB", "STATUS", "USER_ID" };
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    ctsTellerSC.setSearchCols(searchCol);
	    ctsTellerSC.setCompCode(sessionCO.getCompanyCode());
	    // ctsTellerSC.setProgRef(get_pageRef());
	    ctsTellerSC.setBranchCode(sessionCO.getBranchCode());
	    ctsTellerSC.setIvCrud(getIv_crud());
	    ctsTellerSC.setUserId(sessionCO.getUserName());

	    //
	    S_TODO_DETVO sTodoDet = new S_TODO_DETVO();
	    sTodoDet.setTODO_CODE(ctsTellerSC.getTodoCode());
	    sTodoDet.setTODO_LINE(ctsTellerSC.getTodoLine());
	    sTodoDet = alertsBO.returnSTodoDet(sTodoDet);
	    ctsTellerSC.setTodoAlert(sTodoDet.getTODO_ALERT());
	    ctsTellerSC.setReasonCode(sTodoDet.getTODO_REASON());
	    ctsTellerSC.setProgRef(sTodoDet.getTODO_PROG_REF());
	    ctsTellerSC.setAppName(sTodoDet.getTODO_APPLICATION());
	    
	    //Fix issue in account forward
	    if(ConstantsCommon.RET_APP_NAME.equals(sTodoDet.getTODO_APPLICATION()))
	    {
		// Changed branch code for below from sTodoDet.getBRANCH_CODE() to sessionCO.getBranchCode() - Reda - 02/09/2019 - #885073 - ABSAI190327 - Error on alert forward upon opening the account
		CTSTELLERVO  ctstellervo = returnCommonLibBO().returnCtsTellerDetails(sTodoDet.getCOMP_CODE(), sessionCO.getBranchCode(), sessionCO.getUserName());
		if(ctstellervo != null)
		{
		    ctsTellerSC.setSubTellerCode(ctstellervo.getCODE());
		}
	    }
	    ctsTellerSC.setBranchSubCode(sessionCO.getBranchCode());
	    ctsTellerSC.setTodoParam(sTodoDet.getTODO_PARAM()); 
	    // TODO check if the amount should be always set to zero. In lost
	    // and found and remittance it should be zero.
	    ctsTellerSC.setAmount(BigDecimal.ZERO);
	    ctsTellerSC.setAlertType(sTodoDet.getTODO_ALERT());
	    ctsTellerSC.setLanguage(sessionCO.getLanguage());
	    
	    ctsTellerSC.setLanguage(sessionCO.getLanguage());
	    ctsTellerSC.setStatusLovType(AlertsConstants.STATUS_LOV_TYPE);
	    ctsTellerSC.setOnlineStatusLovType(AlertsConstants.ONLINE_STATUS_LOV_TYPE);
		
	    ctsTellerSC.setTodoTellerBranch(sTodoDet.getTODO_TELLER_BR());
	    ctsTellerSC.setTodoTellerId(sTodoDet.getTODO_TELLER_ID());
	    
	    /*set additional parameters into ctstellersc*/
	    if(StringUtil.isNotEmpty(sTodoDet.getTODO_ADDITIONAL_PARAMS()))
	    {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(JsonMethod.ALL, Visibility.NONE);
		mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
	        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        CTSTELLERSC addtionalCtstellerSC = mapper.readValue(sTodoDet.getTODO_ADDITIONAL_PARAMS(), CTSTELLERSC.class);
	        Map<String, String> additionalParamsMap = mapper.readValue(sTodoDet.getTODO_ADDITIONAL_PARAMS(), java.util.HashMap.class);
	        //copy properties with checkPropExist = true to avoid getting following exception : java.lang.NoSuchMethodException: Unknown property 'retProcParamMap' on class 'class com.path.vo.core.ctsteller.CTSTELLERSC'
	        PathPropertyUtil.copyProperties(addtionalCtstellerSC, ctsTellerSC, true, additionalParamsMap.keySet().toArray(new String[0]));
	        //copy additional param and additional param map from S_TODO_DET to ctstellerSC
	        ctsTellerSC.setAdditionalParams(sTodoDet.getTODO_ADDITIONAL_PARAMS());
	        Map<String, Object> additionalParamsObjMap = Collections.unmodifiableMap(additionalParamsMap);
	        ctsTellerSC.setAdditionalParamsMap(additionalParamsObjMap);
	    }
	    
	    copyproperties(ctsTellerSC);
	    
	    //Set application Name
	    if(ctsTellerSC.getAppName() == null || ctsTellerSC.getAppName().isEmpty())
	    {
		ctsTellerSC.setAppName(sTodoDet.getTODO_APPLICATION());
	    }
	    
	    if(checkNbRec(ctsTellerSC))
	    {
		setRecords(alertsBO.getAlertsListCount(ctsTellerSC));
	    }

	    ArrayList<AlertCO> alertList = alertsBO.getAlertsList(ctsTellerSC);
	    setGridModel(alertList);

	}
	catch(Exception e)
	{
	   handleException(e, null, null);
	}
	return SUCCESS;

    }
}
