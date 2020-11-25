package com.path.actions.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.memo.MemoBO;
import com.path.bo.common.memo.MemoConstants;
import com.path.bo.core.common.CoreCommonBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.memo.MemoSC;
import com.path.vo.core.conditionalautomation.ConditionalAutomationCO;

public class RetailBaseAction extends GridBaseAction
{
    private MemoSC _memo;
    private String _memoJson;
    private MemoBO memoBO;
    protected CoreCommonBO coreCommonBO;
    
    public MemoSC get_memo()
    {
	return _memo;
    }

    public void set_memo(MemoSC memo)
    {
	this._memo = memo;
    }

    /**
     * This function Checks the access option for the logged-in user. return -1
     * if Access Denied return 1 if Access Granted
     * PB=f_checkaccess_without_message
     */
    public int checkAccessByProgRef(String progRef)
    {
	SessionCO sesCO = returnSessionObject();
	String accessOnPageRef = returnAccessRightByProgRef(progRef, sesCO.getCurrentAppName());
	String pathStatus = sesCO.getUsrPathSts();

	if("1".equals(pathStatus))
	{
	    if(ConstantsCommon.SADS_APP_NAME.equals(sesCO.getCurrentAppName()))
	    {
		return 1;
	    }
	    else
	    {
		return -1;
	    }
	}
	else if((accessOnPageRef != null && !accessOnPageRef.trim().isEmpty()) || "0".equals(pathStatus))
	{
	    return 1;
	}
	else
	{
	    return -1;
	}
    }

    public void checkForMemo(MemoSC memoSC)
    {
	try
	{
	    SessionCO sesCO = returnSessionObject();
	    //to add apptype for each application
	    String apptype = "";
	    if(sesCO.getCurrentAppName().equals(ConstantsCommon.RET_APP_NAME))
	    {
		apptype = MemoConstants.CSM_APP_TYPE;
	    }

	    memoSC.setAppType(apptype);
	    memoSC.setAppName(sesCO.getCurrentAppName());
	    memoSC.setLangCode(sesCO.getLanguage());
	    // temp due to date issue being send to client
	    memoSC.setRunningDate(sesCO.getRunningDateRET());
	    memoSC.setLovType(MemoConstants.LOV_TYPE);

	    // check if the memo is enabled for this teller, this is flag
	    // FTP_MEMO in teller VO for CSM.
	    BigDecimal ftpMemoForTeller = BigDecimal.ONE;
	    if(MemoConstants.CSM_APP_TYPE.equals(memoSC.getAppType()))
	    {
		ftpMemoForTeller = NumberUtil.nullToZero(sesCO.getCtsTellerVO().getFTP_MEMO());
		
		//NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
		checkConditionalAutomation(memoSC);
		//NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
	    }
	    if(ftpMemoForTeller.equals(BigDecimal.ONE) && memoBO.isMemoAvailable(memoSC))
	    {
		if((MemoConstants.CIF.equals(memoSC.getForAccOrCif()) && !NumberUtil.isEmptyDecimal(memoSC.getCifNo()))
			|| (MemoConstants.ACCOUNTS.equals(memoSC.getForAccOrCif())))
		{
		    // temp due to date issue being send to client
		    memoSC.setRunningDate(null);
		    set_memo(memoSC);
		}
	    }
	}
	catch(BaseException ex)
	{
	    handleException(ex, null, null);
	}
    }

    /**
     * NABIL FEGHALI - IIAB110182 - IIAB100424 - Conditional Automation
     * 
     * @param memoSC
     * @throws BaseException
     */
    private void checkConditionalAutomation(MemoSC memoSC) throws BaseException
    {
	BigDecimal cifNo = null;
	SessionCO sesCO = returnSessionObject();
	if(memoSC != null && ConstantsCommon.RET_APP_NAME.equals(sesCO.getCurrentAppName())
		&& memoSC.getCheckConditionalAutomation() != null
		&& memoSC.getCheckConditionalAutomation().booleanValue())
	{
	    if(MemoConstants.CIF.equals(memoSC.getForAccOrCif()))
	    {
		cifNo = memoSC.getCifNo();
	    }
	    else if(MemoConstants.ACCOUNTS.equals(memoSC.getForAccOrCif()))
	    {
		cifNo = memoSC.getAccCIF();
	    }
	    if(!NumberUtil.isEmptyDecimal(cifNo))
	    {
		ConditionalAutomationCO conditionalAutomationCO = new ConditionalAutomationCO();
		conditionalAutomationCO.setLoginCompCode(sesCO.getCompanyCode());
		conditionalAutomationCO.setLoginBraCode(sesCO.getBranchCode());
		conditionalAutomationCO.setCifNO(cifNo);
		conditionalAutomationCO.setRunningDate(sesCO.getRunningDateRET());
		conditionalAutomationCO.setLoginUserId(sesCO.getUserName());
		conditionalAutomationCO.setLanguage(sesCO.getLanguage());
		conditionalAutomationCO.setLoginPreferrredLanguage(sesCO.getPreferredLanguage());
		conditionalAutomationCO.setActionFlag(2);
		conditionalAutomationCO.setShowSpecialConditionMessage(memoSC.getShowSpecialConditionMessage());
		conditionalAutomationCO = coreCommonBO.checkConditionalAutomation(conditionalAutomationCO);

		if(StringUtil.isNotEmpty(conditionalAutomationCO.getWarningMessages()))
		{
		    set_warning(StringUtil.nullToEmpty(get_warning()) + conditionalAutomationCO.getWarningMessages());
		}
	    }
	}
    }

    public void applyMemoOnRetrieve(List<MemoSC> memoSC, boolean checkConditionalAutomation) throws BaseException
    {
	/* Check if the application is 'RET'*/
	SessionCO sessionCO = returnSessionObject();
	if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	{
	    /**
	     * Loop for the list MemoSC to know if the account and CIF have a
	     * related Memo. the available memo will be filled in a list to be
	     * shown on retrieve
	     */
	    List<MemoSC> avlMemoList = new ArrayList<MemoSC>();
	    for(Iterator iterator = memoSC.iterator(); iterator.hasNext();)
	    {
		MemoSC memoSCTOCheck = (MemoSC) iterator.next();
		/* setting _memo variable to null in purpose to check every memosc */
		set_memo(null);
		/* To avoid the checking on conditional automation because its not needed on retrieve */
		memoSCTOCheck.setCheckConditionalAutomation(checkConditionalAutomation);
		checkForMemo(memoSCTOCheck);
		memoSCTOCheck = get_memo();
		/* If memo is filled in the function checkFromMemo, it will be appended to the grid memo to be shown */
		if(null != memoSCTOCheck)
		{
		    avlMemoList.add(memoSCTOCheck);
		}
	    }
	    if(!avlMemoList.isEmpty())
	    {
		//The JSONArray.fromObject is commented because null value are not excluded.
		//The PathJSONUtil.strutsJsonSerialize is used instead to exclude null values
		//_memoJson = JSONArray.fromObject(avlMemoList).toString();
		try
		{
		    _memoJson = PathJSONUtil.strutsJsonSerialize(avlMemoList, null, null, false, true);
		}
		catch(Exception e)
		{
		    _memoJson = null;
		    log.error(e,"RetailBaseAction.applyMemoOnRetrieve : error in the serialize of _memoJson");
		}
	    }
	}
    }

    public void setMemoBO(MemoBO memoBO)
    {
	this.memoBO = memoBO;
    }

    public MemoBO returnMemoBO()
    {
	return memoBO;
    }

    public void setCoreCommonBO(CoreCommonBO coreCommonBO)
    {
        this.coreCommonBO = coreCommonBO;
    }

    public String get_memoJson()
    {
        return _memoJson;
    }
    
    
}
