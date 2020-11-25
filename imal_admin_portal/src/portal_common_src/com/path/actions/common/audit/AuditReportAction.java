package com.path.actions.common.audit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.audit.AuditBO;
import com.path.bo.common.audit.AuditConstant;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.PTH_CTRL1VO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_CIFSVO;
import com.path.dbmaps.vo.S_AUDIT_ACTIONSVO;
import com.path.dbmaps.vo.S_AUDIT_ACTION_DTLVO;
import com.path.dbmaps.vo.S_AUDIT_ACTION_DTL_CIFVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditReportCO;
import com.path.vo.common.audit.AuditReportSC;
import com.path.vo.common.audit.TrackReportCO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AuditReportAction.java used to handle audit report actions
 */
@SuppressWarnings("serial")
public class AuditReportAction extends GridBaseAction
{
    private String auditActionUrl;
    private String trackActionUrl;
    private String emptyResult;
    private AuditBO auditBO;
    private final AuditReportSC auditReportSC = new AuditReportSC();

    /**
     * Method to load audit report page
     * 
     * @return String
     */
    public String showAuditReport()
    {
	try
	{
	    ServletContext application = ServletActionContext.getServletContext();
	    String theRealPath = application.getContextPath();
	    // check if the appName is passed and not empty, and current application is not the logged in app
	    // then consider that application in Audit Checking
	    String currentApp = returnSessionObject().getCurrentAppName();
	    if(!StringUtil.nullToEmpty(auditReportSC.getAppName()).trim().isEmpty())
	    	//886121 removed checking on REP application to handle all apps.
	    	//	&& ConstantsCommon.REP_APP_NAME.equals(currentApp))
	    {
	    	currentApp = auditReportSC.getAppName();
	    	log.debug("the application Name Used for Audit Report showing [showAuditReport] is "+currentApp);
	    }
	    auditActionUrl = theRealPath + "/path/audit/audit_loadAuditActions.action?appName="
		    + currentApp + "&progRef=" + auditReportSC.getProgRef() + "&trxNbr="
		    + auditReportSC.getTrxNbr();
	    return "auditReport";
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    return ERROR_ACTION;
	}

    }

    /**
     * Method to Load Tracking Highlights report
     */
    public String showTrackReport()
    {
	try
	{
	    return "trackReport";
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    return ERROR_ACTION;
	}

    }

	/**
	 * Loads the tracked changes grid data
	 * @return
	 */
	public String loadTrackActions()
	{
		String[] searchCol = { "fieldLocation", "fieldLabel", "oldValue", "newValue" };	
		try
		{
		    SessionCO sessionCO = returnSessionObject();
		    //BUG 512116 Sending company code as number to the procedure instead of varchar
		    auditReportSC.setCompanyCode(NumberUtil.emptyDecimalToZero(sessionCO.getCompanyCode()).toString());
		    auditReportSC.setAppName(sessionCO.getCurrentAppName());
		    auditReportSC.setSearchCols(searchCol);
		    copyproperties(auditReportSC);
		    // return the collection of records
		    ArrayList<TrackReportCO> trackReportCOList = auditBO.returnChangesReport(auditReportSC);
		    // set the collection into gridModel attribute defined at JSP grid
		    // tag
		    String[] fieldLoc = null;
		    for(TrackReportCO trackReportCO : trackReportCOList)
		    {
			trackReportCO.setFieldLabel(getText(trackReportCO.getFieldLabel()));
			fieldLoc = trackReportCO.getFieldLocation().split(",");
			StringBuffer fieldLocBuff = new StringBuffer();
			    for (int i = 0; i < fieldLoc.length; i++)
			    {
				fieldLocBuff.append(getText(fieldLoc[i]));
				if(i<fieldLoc.length -1)
				{
				fieldLocBuff.append("/");
				}
			    }
			    trackReportCO.setFieldLocation(fieldLocBuff.toString());
		    }
		    setGridModel(trackReportCOList);
		}
		catch(Exception ex)
		{
		    log.error("Error in the loadTrackActions method");
		    handleException(ex, null, null);
		}
		return "auditActions";
	    }

    /**
     * Method to load audit actions to the grid
     * 
     * @return String
     */
    public String loadAuditActions()
    {
	String[] searchCols = {"ACTION_TYPE", "USER_ID","USER_NAME", "MACHINE_ID" ,"ACTION_DATE"};
	
	
	try
	{
	    HashMap<String, String> dateSearchCols = new HashMap<String, String>();
	    dateSearchCols.put("ACTION_DATE", "ACTION_DATE");
	    auditReportSC.setDateSearchCols(dateSearchCols);
	    auditReportSC.setSearchCols(searchCols);
	    auditReportSC.setLangCode(returnSessionObject().getLanguage());
	    copyproperties(auditReportSC);
	    // set number of rows to be displayed in the page of grid, and the
	    // total number of records for first time load only
	    if(checkNbRec(auditReportSC))
	    {
		setRecords(auditBO.returnAuditActionsCount(auditReportSC));
	    }
	    // return the collection of records
	    ArrayList<AuditReportCO> auditReportCOList = auditBO.returnAuditActionsList(auditReportSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    // tag
	    for(AuditReportCO auditReportCO : auditReportCOList)
	    {
		auditReportCO.setACTION_DATE_MS(auditReportCO.getACTION_DATE().getTime());
	    }
	    setGridModel(auditReportCOList);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "auditActions";
    }

    /**
     * Method to load audit action details to the grid
     * 
     * @return String
     */
    public String loadAuditActionDetails()
    {
	try
	{
		ArrayList<S_AUDIT_ACTION_DTLVO> sAuditActionDtlVOList = new ArrayList<>();
		if(auditReportSC.getAppName()!=null && auditReportSC.getProgRef()!=null && auditReportSC.getActionDateMs()!=null){
	    Calendar instance = Calendar.getInstance();
	    instance.setTimeInMillis(auditReportSC.getActionDateMs());
	    auditReportSC.setActionDate(instance.getTime());
	    //439073 ADD support for additional fields labels
	    auditReportSC.setCompCode(returnSessionObject().getCompanyCode());
	    auditReportSC.setUserId(returnSessionObject().getUserName());//447471
	    auditReportSC.setLovTypeId(ConstantsCommon.AUDIT_ADD_FIELD_TYPES);
	    auditReportSC.setPreferredLanguage(returnSessionObject().getLanguage());
	    auditReportSC.setOrdinaryFieldType(getText(ConstantsCommon.ORDINARY_FIELD_TYPE_KEY));
	    copyproperties(auditReportSC);


	    
	    //447471 Masking the info of VIP customers
	    //CTSTELLER.ALLOW_CIF_CREATION_MASK_YN, getting the flag value from session object
	    CTSTELLERVO tellerVO = returnSessionObject().getCtsTellerVO();
	    if(tellerVO != null)
	    {
		auditReportSC.setTellerCifMask(ConstantsCommon.ONE.equals(tellerVO.getALLOW_CIF_CREATION_MASK_YN()));
	    }
	    
	  //Support FATCA stand alone environment
	    PTH_CTRL1VO pthCtrl1VO = returnCommonLibBO().returnPthCtrl1();
        if(pthCtrl1VO != null && ConstantsCommon.NO.equals(pthCtrl1VO.getCORE_IMAL_YN()))
        {  
        	auditReportSC.setIsStandAlone(1);
        }
	    
	    // return the collection of records
	    sAuditActionDtlVOList = auditBO.returnAuditActionDtlList(auditReportSC);	   
		}
		 // set the collection into gridModel attribute defined at JSP grid
	    // tag
	    setGridModel(sAuditActionDtlVOList);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "auditActionDetails";
    }

    /**
     * @return the auditReportSC
     */
    @Override
    public Object getModel()
    {
	return auditReportSC;
    }

    public String auditOnField()
    {
	String returnVal = "JSON_DUMMY";
	emptyResult = "";
	try
	{
	    if(auditReportSC.getActionDate() == null)
	    {
		auditReportSC.setActionDate(returnCommonLibBO().returnSystemDateWithTime());
		returnVal = "auditActionDetails";
	    }

	    
	    SessionCO sessionCO = returnSessionObject();
	    
	    //768542  BB180246 - AUdit Trail report
	    auditReportSC.setBranchCode(sessionCO.getBranchCode());
	    
	    S_AUDIT_ACTIONSVO auditVO = new S_AUDIT_ACTIONSVO();
	    auditVO.setAPP_NAME(sessionCO.getCurrentAppName());
	    auditVO.setPROG_REF(auditReportSC.getProgRef());
	    auditVO.setTRX_NBR(auditReportSC.getProgRef());
	    auditVO.setACTION_TYPE(AuditConstant.UPDATE);
	    auditVO.setACTION_DATE(auditReportSC.getActionDate());
	    auditVO.setRUNNING_DATE(sessionCO.getRunningDateRET());
	    auditVO.setMACHINE_ID(sessionCO.getMachineIp());
	    auditVO.setFIELD_AUDIT_YN(BigDecimal.ONE);
	    auditVO.setUSER_ID(sessionCO.getUserName());


	    S_AUDIT_ACTION_DTLVO auditDtlVO = new S_AUDIT_ACTION_DTLVO();

	    
	    auditDtlVO.setAPP_NAME(sessionCO.getCurrentAppName());
	    auditDtlVO.setPROG_REF(auditReportSC.getProgRef());
	    auditDtlVO.setTRX_NUMBER(auditReportSC.getProgRef());
	    auditDtlVO.setACTION_DATE(auditReportSC.getActionDate());
	    auditDtlVO.setRUNNING_DATE(sessionCO.getRunningDateRET());
	    String elemName = StringUtil.nullToEmpty(auditReportSC.getAuditDtlVO().getELEMENT_NAME());
	    if(StringUtil.isNotEmpty(elemName) && elemName.lastIndexOf(".") > 0)
	    {
		elemName = elemName.substring(elemName.lastIndexOf(".")+1, elemName.length());
	    }
	    String fldLabel = auditReportSC.getAuditDtlVO().getFIELD_NAME();
	    if(StringUtil.isEmptyString(fldLabel))
	    {
		 fldLabel = elemName;
	    }
	    
	    String newVal=auditReportSC.getAuditDtlVO().getNEW_VALUE(),oldVal = auditReportSC.getAuditDtlVO().getOLD_VALUE();
	    BigDecimal type = auditReportSC.getAuditDtlVO().getELEMENT_TYPE();

	    //Bug 514831 Below is commented since Radio button and radio group labels are now handled from JavasSript  
//	    if(type.compareTo(new BigDecimal(ConstantsCommon.ELEMENT_TYPE_RADIOBUTTON)) == 0)
//	    {
//		newVal = fldLabel;
//		oldVal = "";
//	    }
	    if(type.compareTo(new BigDecimal(ConstantsCommon.ELEMENT_TYPE_CHECKBOX)) == 0)
	    {
		newVal = ConstantsCommon.TRUE.equals(newVal)?"checkedValKey":"notCheckedValKey";
		oldVal = ConstantsCommon.TRUE.equals(oldVal)?"checkedValKey":"notCheckedValKey";
	    }
	    if(type.compareTo(new BigDecimal(ConstantsCommon.ELEMENT_TYPE_BUTTON)) == 0)
	    {
		//642699 Show the CIF instead of button clicked
		if(StringUtil.isNotEmpty(auditReportSC.getFieldAuditDetails()))
		{
			newVal = auditReportSC.getFieldAuditDetails();
			oldVal = "";
			auditVO.setACTION_TYPE(AuditConstant.RETRIEVE);
		}
		else
		{
			newVal = getText("buttonClickedKey");
			oldVal = "";
		}
	    }

	    auditDtlVO.setNEW_VALUE(newVal);
	    auditDtlVO.setOLD_VALUE(oldVal);
	    auditDtlVO.setELEMENT_TYPE(type);
	    auditDtlVO.setFIELD_NAME(getText(fldLabel));
	    auditDtlVO.setELEMENT_NAME(elemName);
	    auditReportSC.setAuditVO(auditVO);
	    auditReportSC.setAuditDtlVO(auditDtlVO);
	    
	    int lineNb = auditBO.insertAuditOnField(auditReportSC);
	    
	    //691148 Field & CIF Audit
	    auditReportSC.setAppName(sessionCO.getCurrentAppName());
	    List<SYS_PARAM_SCREEN_CIFSVO> screenCIFs = auditBO.returnScreenCIFsToAudit(auditReportSC);
	    if(screenCIFs!=null && screenCIFs.size()>0)
	    {
		returnVal = "auditActionDetails";
		String jsFuncName = "";
		JSONObject mainJson = new JSONObject();
		JSONArray selectArr = new JSONArray();
		for(SYS_PARAM_SCREEN_CIFSVO screenCIF : screenCIFs)
		    {
			JSONObject selectIndex = new JSONObject();
			
			selectIndex.put("htmlID", screenCIF.getELEMENT_ID());
			jsFuncName = StringUtil.isNotEmpty(screenCIF.getJS_FUNCTION())?screenCIF.getJS_FUNCTION():jsFuncName;

			selectArr.add(selectIndex);
		    }

		    mainJson.put("screenCIFHTMLIDs", selectArr);
		    auditReportSC.setScreenCIFHTMLIDs(mainJson.toString());
		    auditReportSC.setJsFuntionName(jsFuncName);
		    auditReportSC.setFieldAuditCIFLnNb(lineNb);
	    }
	}
	catch(Exception e)
	{
	    //Exception is not handled in order not to show on-screen message 
	    log.error(e,"Could not insert Audit on field: " + auditReportSC.getAuditDtlVO().getFIELD_NAME() + "In Screen: " + get_pageRef());
	}
	return returnVal;
    }
    
    
 // 691148 Field & CIF Audit
    public String auditOnFieldAddCIFs()
    {
	String returnVal = "auditActionDetails";
	try
	{
		String theCIFs = auditReportSC.getScreenCIFHTMLVals();
		if(StringUtil.isNotEmpty(theCIFs))
		{
		    SessionCO sessionCO = returnSessionObject();
		    String[] splittedCIFs = theCIFs.split(",");
		    ArrayList<S_AUDIT_ACTION_DTL_CIFVO> auditCIFVOList = new ArrayList<S_AUDIT_ACTION_DTL_CIFVO>();
		    for(String cifNO : splittedCIFs)
		    {
			S_AUDIT_ACTION_DTL_CIFVO auditCIFVO = new S_AUDIT_ACTION_DTL_CIFVO();
			auditCIFVO.setAPP_NAME(sessionCO.getCurrentAppName());
			auditCIFVO.setPROG_REF(auditReportSC.getProgRef());
			auditCIFVO.setTRX_NUMBER(auditReportSC.getProgRef());
			auditCIFVO.setACTION_DATE(auditReportSC.getActionDate());
			auditCIFVO.setLINE_NUMBER(new BigDecimal(auditReportSC.getFieldAuditCIFLnNb()));
			auditCIFVO.setCIF_NO(new BigDecimal(cifNO));
			auditCIFVOList.add(auditCIFVO);
		    }
			auditBO.insertAuditOnFieldCIFs(auditCIFVOList);
		}
	}
	catch(BaseException ex)
	{
	    log.error(ex,"Could not insert Audit on field CIF: " + auditReportSC.getAuditDtlVO().getFIELD_NAME() + "In Screen: " + get_pageRef());
	}

	return returnVal;
    }
    
    public String loadAuditReportDetailsPage()
	{

		return "loadAuditReportDetailsPage";
	}
    /**
     * @return the auditActionUrl
     */
    public String getAuditActionUrl()
    {
	return auditActionUrl;
    }

    /**
     * @param auditBO the auditBO to set
     */
    @Override
    public void setAuditBO(AuditBO auditBO)
    {
	this.auditBO = auditBO;
    }

    public String getTrackActionUrl()
    {
        return trackActionUrl;
    }

    public String getEmptyResult()
    {
	return emptyResult;
    }

    public void setEmptyResult(String emptyResult)
    {
	this.emptyResult = emptyResult;
    }


}
