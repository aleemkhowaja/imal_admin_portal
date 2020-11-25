package com.path.bo.common.alerts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.CTSCONTROL_ALERTVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.dbmaps.vo.SYS_PARAM_TODO_ALERT_TYPEVO;
import com.path.dbmaps.vo.S_APPLOGVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.ConnectionCO;
import com.path.vo.common.AlertCO;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.core.account.AccountSC;
import com.path.vo.core.alerts.AlertsRequestParamSC;
import com.path.vo.core.alerts.AlertsSC;
import com.path.vo.core.ctsteller.CTSTELLERSC;
import com.path.vo.core.trxmgnt.TrxMgntCO;

public interface AlertsBO {

    public Integer getAlertsListCount(CTSTELLERSC ctsTellerSC)throws BaseException;
	public S_TODO_DETVO returnSTodoDet(S_TODO_DETVO sTodoDet)throws BaseException;
	public int returnIsSubordinate(CTSTELLERSC ctsTellerSC)throws BaseException;
	public int returnAccessPrivileges(AlertsSC alertsSC)throws BaseException;
	public String returnDefaultRefreshTime(AlertsSC alertsSC)throws BaseException;
	public String returnIfAndOrTrs(AlertsSC alertsSC)throws BaseException;
	public String returnUserAccLimit(CTSTELLERSC ctsTellerSC)throws BaseException;
	public void checkIfSameStatus(AlertsParamCO alertsParamCO) throws BaseException;
	public void saveAlert( S_TODO_DETVO sToDoDetVO) throws BaseException;
	public void snoozeSelectedTransactional(AlertCO alertCO)  throws BaseException;
	public void okForAll( AlertCO alertCO)  throws BaseException;
	public void updateAlertStatusAfterOk( S_TODO_DETVO sToDoDetVO) throws BaseException;
	public AlertsSC callToDoDet(AlertsSC alertsSC) throws BaseException;
	public TrxMgntCO checkCtsTrsStatusForAlert(AlertsSC alertsSC) throws BaseException;
	public BigDecimal returnAccBalance(AccountSC accountSC) throws BaseException;
	public TrxMgntCO returnUsrLevelAllowOverride(AlertsSC alertsSC) throws BaseException;
	public TrxMgntCO returnUsrLevelAllowForOr(AlertsSC alertsSC) throws BaseException;
	public void updateUsrPushAlert(AlertsSC alertsSC) throws BaseException;
	public void insertOrUpdateUsrSnoozeAlert(AlertsSC alertsSC) throws BaseException;
	public ArrayList<AlertCO> getAlertsList(CTSTELLERSC ctsTellerSC)throws BaseException;
	public ArrayList<AlertCO> getTrsAckTOutAlertsList(AlertsSC alertsSC)throws BaseException;
	public Integer getTrsAckTOutAlertsListCount(AlertsSC alertsSC)throws BaseException;
	public SYS_PARAM_TODO_ALERT_TYPEVO returnSysParamTodoAlertType(SYS_PARAM_TODO_ALERT_TYPEVO todoAlertTypeVo) throws BaseException;
	public CTSCONTROL_ALERTVO returnCtsControlAlert(AlertsSC alertsSC) throws BaseException;
	public int fUpdateTodo(S_TODO_DETVO sTodoDet, String updateAllTrx ) throws BaseException;
	public String returnAlertsNextProgRefByStatus(AlertsSC alertSC) throws BaseException;
	public Map<String, CTSCONTROL_ALERTVO> returnAllCtsControlAlert(AlertsSC alertsSC) throws BaseException;
	public void fAlertAcknowledgment(S_TODO_DETVO sTodoDet, AlertsParamCO alertsParamCO) throws BaseException;
	public void updateTodoAndSendAck(AlertsParamCO receivedAlertParamCO) throws BaseException;
	public BigDecimal countCtstrxTypeStatusByType(AlertsSC alertsSC) throws BaseException;
	public Map<String, CTSCONTROL_ALERTVO> returnCtsControlAlertEntity(AlertsSC alertsSC) throws BaseException;
	public List<String> returnAllTellersByLevel(AlertsSC alertsSC) throws BaseException;
	public List<String> returnAllTellersByGroup(AlertsSC alertsSC) throws BaseException;
	public CTSTELLERVO ctsTellerDetails(CTSTELLERSC ctsTellerSC)throws BaseException;
	public Map<String, Object> returnAlertsParamMap(String applicationName, String progRef) throws BaseException;
	public TrxMgntCO returnTrxStatusDataForMinLine(AlertsSC alertSC) throws BaseException;
	public TrxMgntCO returnOverDrawnForInsertStatus(AlertsSC alertSC) throws BaseException;
	public AlertsParamCO returnSaveAsOptDetails(String appName, String progRef) throws BaseException;
	/* Login Alert Implementation TP#297149 */
	public AlertsParamCO loadLoginAlertDetails(AlertsParamCO alertsParamCO) throws BaseException;
	
	// Edited - TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
	public void updateAlertLoginApprovalDate(String todoParam) throws BaseException;
	
	public void sendAlert(AlertsRequestParamSC alertsRequestParamSC) throws BaseException;
	public PTH_CTRLVO returnPthCtrl() throws BaseException;
	
	// TP #969401 (DB200043 - BCR - Print List of transactions and Stop User from Posting Trx (AUD_Point5))
	public ArrayList<AlertCO> getAlertsListForFinalSignOff(CTSTELLERSC ctsTellerSC)throws BaseException;
	public Integer getAlertsListForFinalSignOffCount(CTSTELLERSC ctsTellerSC)throws BaseException;
	public void updateAllLoginApprovalRequestsToDeleted(AlertsSC alertsSC) throws BaseException;
	public void updateOldSendAckAlertsToDeleted(AlertsSC alertsSC) throws BaseException;
	public S_APPLOGVO returnS_APPLOG(AlertsSC alertsSC) throws BaseException;
	public void alertApproveReject(AlertsParamCO alertsParamCO, boolean isReject) throws BaseException;
	
	//TP #1083417	AIBI200030 - adding Internal Alerts as Communication mode
	public void sendAlert(AlertsRequestParamSC alertsRequestParamSC, ConnectionCO connCO) throws BaseException;
	
}
