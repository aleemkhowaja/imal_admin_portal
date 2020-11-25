package com.path.actions.dependencies.admin;

import java.math.BigDecimal;

import com.path.bo.admin.branches.BranchesBO;
import com.path.bo.common.MessageCodes;
import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.admin.branches.BranchesCO;
import com.path.vo.admin.branches.BranchesSC;
import com.path.vo.common.SessionCO;

/**
 * 
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author GhenoieSaab
 * 
 * 
 *         BranchesDependencyAction.java used for all dependencies related to
 *         branches.
 * 
 */
public class BranchesDependencyAction extends BaseAction
{

    BranchesBO branchesBO;
    private BigDecimal COMP_CODE;
    private BigDecimal BRANCH_CODE;
    private BigDecimal userIndependent;
    private BRANCHESVO branchesVO = new BRANCHESVO();
    private BranchesCO branchesCO = new BranchesCO();
    private AMFVO account = new AMFVO();
    private BigDecimal displayMsg;
    private String screenName;
    private boolean physicalBranch;
    
    /**
     * Get dependency between Branch Code and Description
     * 
     * @return
     */
    public String dependencyByBranches()
    {
	try
	{
	    BranchesSC branchesSC = new BranchesSC();
	    SessionCO sessionCO = returnSessionObject();

	    if(!NumberUtil.isEmptyDecimal(COMP_CODE) && !NumberUtil.isEmptyDecimal(BRANCH_CODE))
	    {
		branchesSC.setCompCode(COMP_CODE);
		branchesSC.setBranchCode(BRANCH_CODE);
		branchesSC.setLoggedInBranch(sessionCO.getBranchCode());//Hala Al Sheikh -TP537584 - SBI170065
		branchesSC.setScreenName(screenName);
		branchesSC.setPhysicalBranch(physicalBranch);
		if(NumberUtil.nullToZero(getUserIndependent()).intValue() == 0)
		{
		    branchesSC.setUserId(sessionCO.getUserName());
		}

		branchesVO = branchesBO.getBranchesByUsrDetails(branchesSC);
	    }
	    if(null == branchesVO)
	    {
		branchesVO = new BRANCHESVO();
	    }
	}
	catch(BOException e)
	{
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByBranches method of BranchesDependencyAction.java");
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /**
     * Used from the default account dependency management on branch_id change
     * Remove all the others account inputs and check if the entered value is a
     * valid branch id,
     * 
     * @return
     */
    public String dependencyByBrId()
    {
	try
	{
	    BranchesSC criteria = new BranchesSC();
	    SessionCO sessionCO = returnSessionObject();

	    criteria.setBranchCode(account.getBRANCH_CODE());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());

	    if(!NumberUtil.isEmptyDecimal(account.getBRANCH_CODE()) && !branchesBO.checkBranchValidation(criteria))
	    {
		account.setBRANCH_CODE(null);
	    }
	    account.setCIF_SUB_NO(null);
	    account.setSL_NO(null);
	    account.setGL_CODE(null);
	    account.setCURRENCY_CODE(null);
	    account.setCOMP_CODE(null);
	    account.setBRIEF_NAME_ENG(null);
	    NumberUtil.resetEmptyValues(account);
	}
	catch(BOException e)
	{
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByBrId method of BranchesDependencyAction.java");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String branchDescByCode()
    {
	try
	{
	    BranchesSC branchesSC = new BranchesSC();
	    SessionCO sessionCO = returnSessionObject();
	    branchesSC.setLanguage(sessionCO.getLanguage());
	    // branchesSC.setCompCode(sessionCO.getCompanyCode());//moved down
	    /*
	     * Added Condition by HanaaElJazzar to check if BRANCH_CODE is null,
	     * then no need to proceed to BO checking for BugFixing tp# 202023
	     */
	    if(NumberUtil.isEmptyDecimal(BRANCH_CODE))
	    {
		branchesVO = new BRANCHESVO();
	    }
	    else
	    {
		branchesSC.setBranchCode(BRANCH_CODE);
		/**
		 * If the company code was not sent to this method, then take it
		 * from the session.... By HanaaElJazzar for TrxTemplate Screen.
		 */
		if(NumberUtil.isEmptyDecimal(COMP_CODE))
		{
		    branchesSC.setCompCode(sessionCO.getCompanyCode());
		}
		else
		{
		    branchesSC.setCompCode(getCOMP_CODE());
		}

		if(NumberUtil.nullToZero(getDisplayMsg()).equals(BigDecimal.ONE))
		{
		    branchesSC.setDisplayMsg(getDisplayMsg());
		}
		branchesVO = branchesBO.getBranchDescByCode(branchesSC);
		/**
		 * the below was added by Assets Team to return empty in case we
		 * empty the branch
		 */
		if(branchesVO == null || NumberUtil.isEmptyDecimal(branchesVO.getBRANCH_CODE()))
		{
		    branchesVO = new BRANCHESVO();
		}
	    }
	}
	catch(BOException e)
	{
	    branchesVO = new BRANCHESVO();
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in getBranchDescByCode method of BranchesDependencyAction.java");
	    branchesVO = new BRANCHESVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // TP#235336;Arun.R.Variyath;02/01/2015 [Start]
    // To show the message if code is invalid
    public String dependencyByBrIdWithExceptionMessage()
    {
	try
	{
	    BranchesSC criteria = new BranchesSC();
	    SessionCO sessionCO = returnSessionObject();

	    criteria.setBranchCode(account.getBRANCH_CODE());
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(NumberUtil.nullEmptyToValue(COMP_CODE, sessionCO.getCompanyCode()));
	    if(!NumberUtil.isEmptyDecimal(account.getBRANCH_CODE()) && !branchesBO.checkBranchValidation(criteria))
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_BRANCH_CODE);
	    }
	    account.setCIF_SUB_NO(null);
	    account.setSL_NO(null);
	    account.setGL_CODE(null);
	    account.setCURRENCY_CODE(null);
	    account.setCOMP_CODE(null);
	    account.setBRIEF_NAME_ENG(null);
	    NumberUtil.resetEmptyValues(account);
	}

	catch(Exception e)
	{
	    account = new AMFVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // TP#235336;Arun.R.Variyath;02/01/2015 [End]

    public BigDecimal getCOMP_CODE()
    {
	return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMPCODE)
    {
	COMP_CODE = cOMPCODE;
    }

    public BranchesCO getBranchesCO()
    {
	return branchesCO;
    }

    public void setBranchesCO(BranchesCO branchesCO)
    {
	this.branchesCO = branchesCO;
    }

    public void setBranchesBO(BranchesBO branchesBO)
    {
	this.branchesBO = branchesBO;
    }

    public BigDecimal getBRANCH_CODE()
    {
	return BRANCH_CODE;
    }

    public void setBRANCH_CODE(BigDecimal bRANCHCODE)
    {
	BRANCH_CODE = bRANCHCODE;
    }

    public BRANCHESVO getBranchesVO()
    {
	return branchesVO;
    }

    public void setBranchesVO(BRANCHESVO branchesVO)
    {
	this.branchesVO = branchesVO;
    }

    public AMFVO getAccount()
    {
	return account;
    }

    public void setAccount(AMFVO account)
    {
	this.account = account;
    }

    public BigDecimal getUserIndependent()
    {
	return userIndependent;
    }

    public void setUserIndependent(BigDecimal userIndependent)
    {
	this.userIndependent = userIndependent;
    }

    public BigDecimal getDisplayMsg()
    {
	return displayMsg;
    }

    public void setDisplayMsg(BigDecimal displayMsg)
    {
	this.displayMsg = displayMsg;
    }

    public String getScreenName()
    {
        return screenName;
    }

    public void setScreenName(String screenName)
    {
        this.screenName = screenName;
    }

	public boolean isPhysicalBranch() {
		return physicalBranch;
	}

	public void setPhysicalBranch(boolean physicalBranch) {
		this.physicalBranch = physicalBranch;
	}

}
