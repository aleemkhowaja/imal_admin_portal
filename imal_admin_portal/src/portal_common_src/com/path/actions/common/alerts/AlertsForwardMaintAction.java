package com.path.actions.common.alerts;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.alerts.AlertsBO;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.alerts.AlertsSC;
import com.path.vo.core.ctsteller.CTSTELLERSC;

@SuppressWarnings("serial")
public class AlertsForwardMaintAction extends BaseAction
{
    private AlertsBO alertsBO;
    private CTSTELLERSC ctsTellerSC = new CTSTELLERSC();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private AlertsSC alertsSC = new AlertsSC();
    private String allowLocalApprove;
    private String receiverCode;
    private String todoParam;
    private BigDecimal alertWaitingTime;
    private String buildGridOnLoad;
    private String forwardList;
    
    public Object getModel()
    {
	return ctsTellerSC;
    }

    /**
     * Loads the ForwardAlert details page
     * 
     * @return
     */
    public String loadForwardAlertsPage() throws JSONException
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
		ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
		ctsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
		ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);
		setAllowLocalApprove(ctsControlVO.getALLOW_LOCAL_APPROVE());
		setAlertWaitingTime(ctsControlVO.getALERT_WAIT_TIME());
	    }
	    else
	    {
		setAllowLocalApprove(AlertsConstants.ALLOW_LOCAL_APPROVE_BY_DEFAULT);
		setAlertWaitingTime(AlertsConstants.ALERT_WAIT_TIME_BY_DEFAULT);
	    }
	    
	    setTodoParam(alertsSC.getTodoParam());
	    
	    // Return the current S_TODO_DET record, to set alert's description
	    S_TODO_DETVO currentSTodoDet = new S_TODO_DETVO();
	    currentSTodoDet.setTODO_CODE(ctsTellerSC.getTodoCode());
	    currentSTodoDet.setTODO_LINE(ctsTellerSC.getTodoLine());
	    currentSTodoDet = alertsBO.returnSTodoDet(currentSTodoDet);
	    
	    ctsTellerSC.setAlertDescTranslated(translateMatchingMessage(currentSTodoDet.getALERT_DESC()));
	    
	    ctsTellerSC.setAlertLabelKey(getText(currentSTodoDet.getTODO_ALERT() + AlertsConstants.ALERT_FORWARD_TITLE_SUFFIX));
	    
	}
	catch(BaseException e)
	{
	   handleException(e, null, null);
	}
	return "loadForwardPage";
    }

    /**
     * process the alerts forward
     * 
     * @return
     * @throws JSONException
     * @throws ParseException
     */
    public String forwadAlert() throws JSONException, ParseException
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();

	    // alertsSC.setTodoCode(ctsTellerSC.getTodoCode());
	    // alertsSC.setTodoLine(ctsTellerSC.getTodoLine());
	    // alertsSC.setStatus(ctsTellerSC.getStatusCode());
	    AlertsParamCO alertsParamCO = new AlertsParamCO();
	    alertsParamCO.setTodoCode(ctsTellerSC.getTodoCode());
	    alertsParamCO.setTodoLine(ctsTellerSC.getTodoLine());
	    alertsParamCO.setStatus(ctsTellerSC.getStatusCode());
	    alertsBO.checkIfSameStatus(alertsParamCO);

	    S_TODO_DETVO sToDoDetVO = new S_TODO_DETVO();

	    S_TODO_DETVO oldSTodoDet = new S_TODO_DETVO();
	    oldSTodoDet.setTODO_CODE(ctsTellerSC.getTodoCode());
	    oldSTodoDet.setTODO_LINE(ctsTellerSC.getTodoLine());
	    oldSTodoDet = alertsBO.returnSTodoDet(oldSTodoDet);
	   
	    Calendar calendar = GregorianCalendar.getInstance();
	    Date dateReceived = returnCommonLibBO().returnSystemDateWithTime();
	    calendar.setTime(dateReceived);
	    
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
		ctsControlVO.setCOMP_CODE(sessionCO.getCompanyCode());
		ctsControlVO.setBRANCH_CODE(sessionCO.getBranchCode());
		ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);
		calendar.add(Calendar.SECOND, NumberUtil.emptyDecimalToZero(ctsControlVO.getALERT_WAIT_TIME())
			.intValue());
	    }
	    else
	    {
		calendar.add(Calendar.SECOND, NumberUtil.emptyDecimalToZero(AlertsConstants.ALERT_WAIT_TIME_BY_DEFAULT)
			.intValue());
	    }
	    
	    sToDoDetVO.setALERT_WAITING_TIME(calendar.getTime());
	    sToDoDetVO.setUSER_ID(ctsTellerSC.getReceiverUserId());
	    sToDoDetVO.setRECEIVED_FROM(oldSTodoDet.getRECEIVED_FROM());
	    sToDoDetVO.setDATE_RECEIVED(dateReceived);

	    alertsSC.setTellerId(sessionCO.getUserName());
	    alertsSC.setUserId(ctsTellerSC.getReceiverUserId());
	    alertsSC.setUserAction(AlertsConstants.USER_ACTION_G);
	    alertsSC.setJobAction(AlertsConstants.JOB_ACTION_C);
	    alertsSC = alertsBO.callToDoDet(alertsSC);
	    sToDoDetVO.setTODO_CODE(alertsSC.getTodoCode());
	    sToDoDetVO.setTODO_LINE(alertsSC.getTodoLine());
	    sToDoDetVO.setJOB_ID(oldSTodoDet.getJOB_ID());
	    sToDoDetVO.setALLOW_TO_SEND(BigDecimal.ONE);
	    /*
	     * If istr_alert.prog_ref = 'D001@' Then istr_alert.trs_param =
	     * String(istr_alert.trs_no) ElseIf left(istr_alert.prog_ref,2) =
	     * 'F0' Then istr_alert.trs_param = String(istr_alert.trs_no) End If
	     */
	    sToDoDetVO.setTODO_PARAM(oldSTodoDet.getTODO_PARAM());
	    if(oldSTodoDet.getTODO_PROG_REF() != null)
	    {
		if("D001@".equals(oldSTodoDet.getTODO_PROG_REF()))
		{
		    sToDoDetVO.setTODO_PARAM(oldSTodoDet.getTRX_NUMBER());
		}
		/*FIX #473371
		else if("F0".equals(oldSTodoDet.getTODO_PROG_REF().substring(0, 2)))
		{
		    sToDoDetVO.setTODO_PARAM(oldSTodoDet.getTRX_NUMBER());
		}
		*/
	    }

	    sToDoDetVO.setCOMP_CODE(oldSTodoDet.getCOMP_CODE());
	    sToDoDetVO.setBRANCH_CODE(oldSTodoDet.getBRANCH_CODE());
	    sToDoDetVO.setTODO_APPLICATION(oldSTodoDet.getTODO_APPLICATION());
	    sToDoDetVO.setTODO_PROG_REF(oldSTodoDet.getTODO_PROG_REF());
	    sToDoDetVO.setBRIEF_NAME_ARAB(oldSTodoDet.getBRIEF_NAME_ARAB());
	    sToDoDetVO.setBRIEF_NAME_ENG(oldSTodoDet.getBRIEF_NAME_ENG());
	    sToDoDetVO.setTODO_ALERT(oldSTodoDet.getTODO_ALERT());
	    sToDoDetVO.setTODO_EXCEP_ENG(oldSTodoDet.getTODO_EXCEP_ENG());
	    sToDoDetVO.setTODO_EXCEP_ARABIC(oldSTodoDet.getTODO_EXCEP_ARABIC());
	    sToDoDetVO.setTODO_REASON(oldSTodoDet.getTODO_REASON());
	    sToDoDetVO.setTODO_TELLER_BR(oldSTodoDet.getTODO_TELLER_BR());
	    sToDoDetVO.setTODO_TELLER_ID(oldSTodoDet.getTODO_TELLER_ID());
	    sToDoDetVO.setTODO_ALERT_OLD_STATUS(oldSTodoDet.getTODO_ALERT_OLD_STATUS());
	    sToDoDetVO.setTODO_FR_BRANCH(oldSTodoDet.getTODO_FR_BRANCH());
	    sToDoDetVO.setTODO_ADDITIONAL_PARAMS(oldSTodoDet.getTODO_ADDITIONAL_PARAMS());

	    /*
	    // If istr_alert.todo_alert = 'Y' Or istr_alert.todo_alert = 'X'
	    // Then ls_todoParam = String(istr_alert.status_order)
	    if(AlertsConstants.TODO_ALERT_X.equals(oldSTodoDet.getTODO_ALERT())
		    || AlertsConstants.TODO_ALERT_Y.equals(oldSTodoDet.getTODO_ALERT()))
	    {
		// ls_todoParam = String(istr_alert.status_order)
		// sToDoDetVO.setTODO_PARAM()
	    }
	    */
	    
	    // Update old S_TODO_DET status to deleted
	    oldSTodoDet.setTODO_STATUS(AlertsConstants.STATUS_DELETED);
	    alertsBO.updateAlertStatusAfterOk(oldSTodoDet);

	    //check the condition that does not exists in PB
	    /*
	    String progRefSubString = get_pageRef().substring(0, 2);
	    if(progRefSubString.equals("A0"))
	    {
		// to be used by the developper of account section 
		String todoParam = alertsSC.getTodoParam();
		String accCompCode = todoParam.substring(0, 4);
		String accBranchCode = todoParam.substring(4, 8);
		String accCy = todoParam.substring(8, 11);
		String accGl = todoParam.substring(11, 17);
		String accCif = todoParam.substring(17, 25);
		String accSl = todoParam.substring(25, 28);
	    }
	    */
	    
	    sToDoDetVO.setDISTRIBUTION_TYPE(AlertsConstants.DISTRIBUTION_TYPE_B);
	    sToDoDetVO.setDISTRIBUTION_TO(AlertsConstants.DISTRIBUTION_TO_U);
	    sToDoDetVO.setTODO_TYPE(AlertsConstants.TODO_TYPE_P);
	    sToDoDetVO.setTODO_PRIORITY(AlertsConstants.TODO_PRIORITY_A);
	    sToDoDetVO.setTODO_STATUS(AlertsConstants.STATUS_ACTIVE);
	    sToDoDetVO.setTODO_CHECKED(AlertsConstants.TODO_CHECKED_U);
	    sToDoDetVO.setTODO_EXECUTION(AlertsConstants.TODO_EXECUTION_N);
	    alertsBO.saveAlert(sToDoDetVO);

	}
	catch(BaseException e)
	{
	   handleException(e, null, null);
	}
	return "success";
    }

    public String getTodoParam()
    {
	return todoParam;
    }

    public void setTodoParam(String todoParam)
    {
	this.todoParam = todoParam;
    }

    public CTSTELLERSC getCtsTellerSC()
    {
	return ctsTellerSC;
    }

    public void setCtsTellerSC(CTSTELLERSC ctsTellerSC)
    {
	this.ctsTellerSC = ctsTellerSC;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public AlertsSC getAlertsSC()
    {
	return alertsSC;
    }

    public void setAlertsSC(AlertsSC alertsSC)
    {
	this.alertsSC = alertsSC;
    }

    public String getAllowLocalApprove()
    {
	return allowLocalApprove;
    }

    public void setAllowLocalApprove(String allowLocalApprove)
    {
	this.allowLocalApprove = allowLocalApprove;
    }

    public String getReceiverCode()
    {
	return receiverCode;
    }

    public void setReceiverCode(String receiverCode)
    {
	this.receiverCode = receiverCode;
    }

    public BigDecimal getAlertWaitingTime()
    {
	return alertWaitingTime;
    }

    public void setAlertWaitingTime(BigDecimal alertWaitingTime)
    {
	this.alertWaitingTime = alertWaitingTime;
    }

    public void setAlertsBO(AlertsBO alertsBO)
    {
	this.alertsBO = alertsBO;
    }

    public String getBuildGridOnLoad()
    {
        return buildGridOnLoad;
    }

    public void setBuildGridOnLoad(String buildGridOnLoad)
    {
        this.buildGridOnLoad = buildGridOnLoad;
    }

    public String getForwardList()
    {
        return forwardList;
    }

    public void setForwardList(String forwardList)
    {
        this.forwardList = forwardList;
    }

}
