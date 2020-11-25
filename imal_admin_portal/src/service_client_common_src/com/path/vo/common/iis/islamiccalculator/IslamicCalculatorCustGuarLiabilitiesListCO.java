package com.path.vo.common.iis.islamiccalculator;

import com.path.dbmaps.vo.TRSDEAL_CUST_GUAR_LIABLITIESVO;
import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Ravikant.Singh
 * 
 *          IslamicCalculatorCustGuarLiabilitiesListCO.java used to
 */
@SuppressWarnings("serial")
public class IslamicCalculatorCustGuarLiabilitiesListCO extends BaseVO
{
    TRSDEAL_CUST_GUAR_LIABLITIESVO trsdealCustGuarLiabilitiesVO = new TRSDEAL_CUST_GUAR_LIABLITIESVO();

    public TRSDEAL_CUST_GUAR_LIABLITIESVO getTrsdealCustGuarLiabilitiesVO()
    {
	return trsdealCustGuarLiabilitiesVO;
    }

    public void setTrsdealCustGuarLiabilitiesVO(TRSDEAL_CUST_GUAR_LIABLITIESVO trsdealCustGuarLiabilitiesVO)
    {
	this.trsdealCustGuarLiabilitiesVO = trsdealCustGuarLiabilitiesVO;
    }

}
