package com.path.vo.common.iis.islamiccalculator;

import java.io.Serializable;

import com.path.dbmaps.vo.TRSDET_CALCULATORVO;
import com.path.lib.vo.BaseVO;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: saheer.naduthodi
 * 
 *          HedgeCalcContributorCO.java used to
 */
public class HedgeCalcContributorCO extends BaseVO implements Serializable
{
    private String partyName;
    private TRSDET_CALCULATORVO trsdetCalcVO;

    public String getPartyName()
    {
	return partyName;
    }

    public void setPartyName(String partyName)
    {
	this.partyName = partyName;
    }

    public TRSDET_CALCULATORVO getTrsdetCalcVO()
    {
	return trsdetCalcVO;
    }

    public void setTrsdetCalcVO(TRSDET_CALCULATORVO trsdetCalcVO)
    {
	this.trsdetCalcVO = trsdetCalcVO;
    }

}
