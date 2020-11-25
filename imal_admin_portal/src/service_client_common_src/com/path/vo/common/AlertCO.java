package com.path.vo.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CTSCONTROL_ALERTVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.vo.core.common.RetailBaseVO;

@SuppressWarnings("serial")
public class AlertCO extends RetailBaseVO
{  
    private S_TODO_DETVO sTodoDet = new S_TODO_DETVO();
    private BigDecimal errorCode;
    private String errorMessage; 
    private String ALERT_SUB_TYPE; 
    private String gridSelectedRow;
    private String TODO_REFRESH_TIME;
    private String TODO_REFRESH_HOURS;
    private String TODO_REFRESH_MINUTES;
    private String TODO_REFRESH_SECONDS;
    private List<S_TODO_DETVO> listAlertsAdd = new ArrayList<S_TODO_DETVO>();
    private String isNewUser;
    private String alertDescription;
    private String alertType;
    private String alertCode;
    private String userName;
    private String progRef;
    private String password;
    private CTSCONTROL_ALERTVO ctsControlAlertVO = new CTSCONTROL_ALERTVO();
    private String entityActivte;
    private String entityType;
    private BigDecimal countActivate;
    private String openMethodUrl;
    private String approveMethodeUrl;
    private String rejectMethodUrl;
    private String printMethodUrl;
    private String itemPageRef;
    private String prepareParamsJsFunction;
    private String addButtonJsFunction;
    private String openItemParams;
    private AlertsParamCO alertsParamCO = new AlertsParamCO();
    private String isCheckForPassWord;
    private String callBackJsFunc;
    private String callBackPrintFunc;
    private String callBackPrintFuncRequireJs;
    private String callBackPrintFuncRequirePath;
    private Boolean showToolbar = Boolean.TRUE;
    private String refreshDataMessage;
    private String snoozeAlertDisabled;
    private String loadInNewWindow;
    private String forwardMethodUrl;
    
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getProgRef()
    {
        return progRef;
    }

    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getTODO_REFRESH_TIME()
    {
        return TODO_REFRESH_TIME;
    }

    public String getTODO_REFRESH_HOURS()
    {
        return TODO_REFRESH_HOURS;
    }

    public void setTODO_REFRESH_HOURS(String tODOREFRESHHOURS)
    {
        TODO_REFRESH_HOURS = tODOREFRESHHOURS;
    }

    public String getTODO_REFRESH_MINUTES()
    {
        return TODO_REFRESH_MINUTES;
    }

    public void setTODO_REFRESH_MINUTES(String tODOREFRESHMINUTES)
    {
        TODO_REFRESH_MINUTES = tODOREFRESHMINUTES;
    }

    public String getTODO_REFRESH_SECONDS()
    {
        return TODO_REFRESH_SECONDS;
    }

    public void setTODO_REFRESH_SECONDS(String tODOREFRESHSECONDS)
    {
        TODO_REFRESH_SECONDS = tODOREFRESHSECONDS;
    }

    public void setTODO_REFRESH_TIME(String tODOREFRESHTIME)
    {
        TODO_REFRESH_TIME = tODOREFRESHTIME;
    }

    public List<S_TODO_DETVO> getListAlertsAdd()
    {
        return listAlertsAdd;
    }

    public void setListAlertsAdd(List<S_TODO_DETVO> listAlertsAdd)
    {
        this.listAlertsAdd = listAlertsAdd;
    }

    public String getGridSelectedRow()
    {
        return gridSelectedRow;
    }

    public void setGridSelectedRow(String gridSelectedRow)
    {
        this.gridSelectedRow = gridSelectedRow;
    }

    public String getALERT_SUB_TYPE()
    {
        return ALERT_SUB_TYPE;
    }

    public void setALERT_SUB_TYPE(String aLERTSUBTYPE)
    {
        ALERT_SUB_TYPE = aLERTSUBTYPE;
    }

    public String getAlertType()
    {
        return alertType;
    }

    public void setAlertType(String alertType)
    {
        this.alertType = alertType;
    }
  
    public String getIsNewUser()
    {
        return isNewUser;
    }

    public String getAlertDescription()
    {
        return alertDescription;
    }

    public void setAlertDescription(String alertDescription)
    {
        this.alertDescription = alertDescription;
    }

    public String getAlertCode()
    {
        return alertCode;
    }

    public void setAlertCode(String alertCode)
    {
        this.alertCode = alertCode;
    }

    public void setIsNewUser(String isNewUser)
    {
        this.isNewUser = isNewUser;
    }

    public BigDecimal getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public S_TODO_DETVO getsTodoDet()
    {
        return sTodoDet;
    }

    public void setsTodoDet(S_TODO_DETVO sTodoDet)
    {
        this.sTodoDet = sTodoDet;
    }

    public String getOpenMethodUrl()
    {
        return openMethodUrl;
    }

    public void setOpenMethodUrl(String openMethodUrl)
    {
        this.openMethodUrl = openMethodUrl;
    }

    public String getApproveMethodeUrl()
    {
        return approveMethodeUrl;
    }

    public void setApproveMethodeUrl(String approveMethodeUrl)
    {
        this.approveMethodeUrl = approveMethodeUrl;
    }

    public String getRejectMethodUrl()
    {
        return rejectMethodUrl;
    }

    public void setRejectMethodUrl(String rejectMethodUrl)
    {
        this.rejectMethodUrl = rejectMethodUrl;
    }

    public AlertsParamCO getAlertsParamCO()
    {
        return alertsParamCO;
    }

    public void setAlertsParamCO(AlertsParamCO alertsParamCO)
    {
        this.alertsParamCO = alertsParamCO;
    }

    public String getItemPageRef()
    {
        return itemPageRef;
    }

    public void setItemPageRef(String itemPageRef)
    {
        this.itemPageRef = itemPageRef;
    }

    public String getPrepareParamsJsFunction()
    {
        return prepareParamsJsFunction;
    }

    public void setPrepareParamsJsFunction(String prepareParamsJsFunction)
    {
        this.prepareParamsJsFunction = prepareParamsJsFunction;
    }

    public String getAddButtonJsFunction()
    {
        return addButtonJsFunction;
    }

    public void setAddButtonJsFunction(String addButtonJsFunction)
    {
        this.addButtonJsFunction = addButtonJsFunction;
    }

    public CTSCONTROL_ALERTVO getCtsControlAlertVO()
    {
        return ctsControlAlertVO;
    }

    public void setCtsControlAlertVO(CTSCONTROL_ALERTVO ctsControlAlertVO)
    {
        this.ctsControlAlertVO = ctsControlAlertVO;
    }

    public String getEntityActivte()
    {
        return entityActivte;
    }

    public void setEntityActivte(String entityActivte)
    {
        this.entityActivte = entityActivte;
    }

    public String getEntityType()
    {
        return entityType;
    }

    public void setEntityType(String entityType)
    {
        this.entityType = entityType;
    }

    public BigDecimal getCountActivate()
    {
        return countActivate;
    }

    public void setCountActivate(BigDecimal countActivate)
    {
        this.countActivate = countActivate;
    }

    public String getOpenItemParams()
    {
        return openItemParams;
    }

    public void setOpenItemParams(String openItemParams)
    {
        this.openItemParams = openItemParams;
    }

    public String getIsCheckForPassWord()
    {
        return isCheckForPassWord;
    }

    public void setIsCheckForPassWord(String isCheckForPassWord)
    {
        this.isCheckForPassWord = isCheckForPassWord;
    }

    public String getCallBackJsFunc()
    {
        return callBackJsFunc;
    }

    public void setCallBackJsFunc(String callBackJsFunc)
    {
        this.callBackJsFunc = callBackJsFunc;
    }

    public Boolean getShowToolbar()
    {
        return showToolbar;
    }

    public void setShowToolbar(Boolean showToolbar)
    {
        this.showToolbar = showToolbar;
    }

    public String getPrintMethodUrl()
    {
        return printMethodUrl;
    }

    public void setPrintMethodUrl(String printMethodUrl)
    {
        this.printMethodUrl = printMethodUrl;
    }

    public String getCallBackPrintFunc()
    {
        return callBackPrintFunc;
    }

    public void setCallBackPrintFunc(String callBackPrintFunc)
    {
        this.callBackPrintFunc = callBackPrintFunc;
    }

    public String getCallBackPrintFuncRequireJs()
    {
        return callBackPrintFuncRequireJs;
    }

    public void setCallBackPrintFuncRequireJs(String callBackPrintFuncRequireJs)
    {
        this.callBackPrintFuncRequireJs = callBackPrintFuncRequireJs;
    }

    public String getCallBackPrintFuncRequirePath()
    {
        return callBackPrintFuncRequirePath;
    }

    public void setCallBackPrintFuncRequirePath(String callBackPrintFuncRequirePath)
    {
        this.callBackPrintFuncRequirePath = callBackPrintFuncRequirePath;
    }

    public String getRefreshDataMessage()
    {
        return refreshDataMessage;
    }

    public void setRefreshDataMessage(String refreshDataMessage)
    {
        this.refreshDataMessage = refreshDataMessage;
    }

    public String getSnoozeAlertDisabled()
    {
        return snoozeAlertDisabled;
    }

    public void setSnoozeAlertDisabled(String snoozeAlertDisabled)
    {
        this.snoozeAlertDisabled = snoozeAlertDisabled;
    }

    public String getLoadInNewWindow()
    {
        return loadInNewWindow;
    }

    public void setLoadInNewWindow(String loadInNewWindow)
    {
        this.loadInNewWindow = loadInNewWindow;
    }

    public String getForwardMethodUrl()
    {
        return forwardMethodUrl;
    }

    public void setForwardMethodUrl(String forwardMethodUrl)
    {
        this.forwardMethodUrl = forwardMethodUrl;
    }
    
}
