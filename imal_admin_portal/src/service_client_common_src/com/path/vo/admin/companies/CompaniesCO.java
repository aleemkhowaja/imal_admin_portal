/**
 * 
 */
package com.path.vo.admin.companies;

import com.path.dbmaps.vo.COMPANIESVO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: EliasAoun
 * 
 *          CompaniesCO.java used to
 */
public class CompaniesCO extends RetailBaseVO
{

    private COMPANIESVO companiesVO = new COMPANIESVO();
    private CURRENCIESVO currenciesVO = new CURRENCIESVO();

    public COMPANIESVO getCompaniesVO()
    {
	return companiesVO;
    }

    public void setCompaniesVO(COMPANIESVO companiesVO)
    {
	this.companiesVO = companiesVO;
    }

    public CURRENCIESVO getCurrenciesVO()
    {
	return currenciesVO;
    }

    public void setCurrenciesVO(CURRENCIESVO currenciesVO)
    {
	this.currenciesVO = currenciesVO;
    }

}
