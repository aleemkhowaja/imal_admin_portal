package com.path.bo.admin.companies;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.COMPANIESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.companies.CompaniesSC;
import com.path.vo.core.trxmgnt.MICRSC;

public interface CompaniesBO
{
    public List getCompaniesList(CompaniesSC companiesSC) throws BaseException;

    public int getCompaniesCount(CompaniesSC companiesSC) throws BaseException;

    public List getCompaniesByUsrList(CompaniesSC companiesSC) throws BaseException;

    public int getCompaniesByUsrCount(CompaniesSC companiesSC) throws BaseException;

    public COMPANIESVO getCompaniesDetails(COMPANIESVO companiesVO) throws BaseException;

    public COMPANIESVO getCompaniesByUsrDetails(CompaniesSC companiesSC) throws BaseException;

    public String getShowBranchesfromCompany(CompaniesSC companiesSC) throws BaseException;

    public BigDecimal returnCompCodeAIB(MICRSC micrSC) throws BaseException;

    public Integer getCompanyCurrLkpCount(CompaniesSC companiesSC) throws BaseException;

    public List getCompanyCurrLkpList(CompaniesSC companiesSC) throws BaseException;
    
    public int getPPSGroupCompaniesCount(CompaniesSC companiesSC) throws BaseException;
    
    public List getPPSGroupCompaniesList(CompaniesSC companiesSC) throws BaseException;
}
