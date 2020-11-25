package com.path.vo.common.smart;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;
/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: RabihElKhatib
 *
 * SmartTypesVO.java used to store the visibility conditions of the smart buttons
 */
public class SmartTypesVO extends BaseVO
{
    private BigDecimal S_ADD_TYPE_CODE;
    private Boolean bView;
    private Boolean bRun;
    private Boolean bScan;
    private Boolean bBrowse;
    private Boolean bDetach;
    private Boolean bEdit;
    private Boolean bUpdate;
    
    public void setSAddTypeCode(BigDecimal sAddTypeCode)
    {
	S_ADD_TYPE_CODE = sAddTypeCode;
    }
    public BigDecimal getSAddTypeCode()
    {
	return S_ADD_TYPE_CODE;
    }
    public void setbView(Boolean bView)
    {
	this.bView = bView;
    }
    public Boolean getbView()
    {
	return bView;
    }
    public void setbRun(Boolean bRun)
    {
	this.bRun = bRun;
    }
    public Boolean getbRun()
    {
	return bRun;
    }
    public void setbScan(Boolean bScan)
    {
	this.bScan = bScan;
    }
    public Boolean getbScan()
    {
	return bScan;
    }
    public void setbDetach(Boolean bDetach)
    {
	this.bDetach = bDetach;
    }
    public Boolean getbDetach()
    {
	return bDetach;
    }
    public void setbEdit(Boolean bEdit)
    {
	this.bEdit = bEdit;
    }
    public Boolean getbEdit()
    {
	return bEdit;
    }
    public void setbUpdate(Boolean bUpdate)
    {
	this.bUpdate = bUpdate;
    }
    public Boolean getbUpdate()
    {
	return bUpdate;
    }
    public void setbBrowse(Boolean bBrowse)
    {
	this.bBrowse = bBrowse;
    }
    public Boolean getbBrowse()
    {
	return bBrowse;
    }
}