package com.path.actions.dependencies.admin;

import java.math.BigDecimal;

import com.path.bo.admin.companies.CompaniesBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.COMPANIESVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.admin.branches.BranchesCO;
import com.path.vo.admin.companies.CompaniesSC;
import com.path.vo.common.SessionCO;

/**
 * 
 * Copyright 2011, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author GhenoieSaab
 * 
 * 
 *         CompaniesDependencyAction.java used for all dependencies related to
 * 
 * 
 */
public class CompaniesDependencyAction extends BaseAction
{

    CompaniesBO companiesBO;
    private BigDecimal COMP_CODE;
    private COMPANIESVO companiesVO = new COMPANIESVO();
    private BranchesCO branchesCO = new BranchesCO();
    private BRANCHESVO branchesVO = new BRANCHESVO();

    /**
     * Get dependency between Company Code and Description
     * 
     * @return
     */
    public String dependencyByCompanies()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    CompaniesSC companiesSC = new CompaniesSC();
	    if(NumberUtil.isEmptyDecimal(COMP_CODE))
	    {
		companiesVO = null;
		branchesVO = null;
	    }
	    else
	    {
		companiesSC.setCompCode(COMP_CODE);
		companiesSC.setUserId(sessionCO.getUserName());
		companiesVO = companiesBO.getCompaniesByUsrDetails(companiesSC);
	    }

	    if(companiesVO == null)
	    {
		branchesCO.setBRANCH_CODE_READONLY(true);
		branchesCO.setBRIEF_DESC_ENG_READONLY("all");
	    }
	    else
	    {
		if(!ConstantsCommon.ONLY_COMP.equals(sessionCO.getAppLocationType()))
		{
		    branchesVO.setBRANCH_CODE(null);
		}
		branchesCO.setBRANCH_CODE_READONLY(false);
		branchesCO.setBRIEF_DESC_ENG_READONLY("false");
	    }

	}
	catch(BOException e)
	{
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCompanies method of CompaniesDependencyAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Method to check whether a company code exists in table or not regardless
     * of user_id or whether this company has location or not.
     * 
     * @return String
     * @author hanaaeljazzar
     */
    public String dependencyOnlyByCompCode()
    {
	try
	{
	    COMPANIESVO companyVO = new COMPANIESVO();
	    SessionCO sessionCO = returnSessionObject();

	    if(NumberUtil.isEmptyDecimal(COMP_CODE))
	    {
		companiesVO = null;
	    }
	    else
	    {
		companyVO.setCOMP_CODE(COMP_CODE);
		companiesVO = returnCommonLibBO().returnCompany(companyVO);

		if(companiesVO == null || NumberUtil.isEmptyDecimal(companiesVO.getCOMP_CODE()))
		{
		    throw new BOException(returnCommonLibBO().returnTranslErrorMessage(
			    MessageCodes.INVALID_COMPANY_CODE, sessionCO.getLanguage()));
		}
	    }
	}
	catch(BOException e)
	{
	    handleException(e, null, null);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByCompanies method of CompaniesDependencyAction");
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    public BigDecimal getCOMP_CODE()
    {
	return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMPCODE)
    {
	COMP_CODE = cOMPCODE;
    }

    public COMPANIESVO getCompaniesVO()
    {
	return companiesVO;
    }

    public void setCompaniesVO(COMPANIESVO companiesVO)
    {
	this.companiesVO = companiesVO;
    }

    public BranchesCO getBranchesCO()
    {
	return branchesCO;
    }

    public void setBranchesCO(BranchesCO branchesCO)
    {
	this.branchesCO = branchesCO;
    }

    public void setCompaniesBO(CompaniesBO companiesBO)
    {
	this.companiesBO = companiesBO;
    }

    public BRANCHESVO getBranchesVO()
    {
	return branchesVO;
    }

    public void setBranchesVO(BRANCHESVO branchesVO)
    {
	this.branchesVO = branchesVO;
    }

}
