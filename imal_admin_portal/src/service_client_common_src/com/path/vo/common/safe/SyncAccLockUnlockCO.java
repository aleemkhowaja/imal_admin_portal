package com.path.vo.common.safe;

import java.math.BigDecimal;
import java.util.List;
import com.path.dbmaps.vo.SYNC_LOCKUNLOCK_ACCVO;
import com.path.lib.vo.BaseVO;
/**
 * Copyright 15, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author:HGhazal
 * 
 * Description: SafeAccLockMgmt used to manage Safe account locking methods
 * Reference: 	TP#259473 
 * Date: 		11/06/2015
 */
public class SyncAccLockUnlockCO extends BaseVO
{	
	private static final long serialVersionUID = 1L;
	
	private List<SYNC_LOCKUNLOCK_ACCVO> listAccounts;
	private BigDecimal loggedCompany;
	private BigDecimal loggedBranch;
	private String loggedUser;
	private String module;
	private BigDecimal timeout;
	
	//Filled by the locking process:
	private String action; //LR=locking, UR=unlocking
	private BigDecimal lockId; //Mandatory as input for Unlocking
	private BigDecimal errorCode;
	private String errorType; //W=WARNING, E=TECHNICAL ERROR, B=BUSINESS ERROR
	private String errorDesc;

	
	public List<SYNC_LOCKUNLOCK_ACCVO> getListAccounts() {
		return listAccounts;
	}
	public void setListAccounts(List<SYNC_LOCKUNLOCK_ACCVO> listAccounts) {
		this.listAccounts = listAccounts;
	}
	public BigDecimal getLoggedCompany() {
		return loggedCompany;
	}
	public void setLoggedCompany(BigDecimal loggedCompany) {
		this.loggedCompany = loggedCompany;
	}
	public BigDecimal getLoggedBranch() {
		return loggedBranch;
	}
	public void setLoggedBranch(BigDecimal loggedBranch) {
		this.loggedBranch = loggedBranch;
	}
	public String getLoggedUser() {
		return loggedUser;
	}
	public void setLoggedUser(String loggedUser) {
		this.loggedUser = loggedUser;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public BigDecimal getTimeout() {
		return timeout;
	}
	public void setTimeout(BigDecimal timeout) {
		this.timeout = timeout;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BigDecimal getLockId() {
		return lockId;
	}
	public void setLockId(BigDecimal lockId) {
		this.lockId = lockId;
	}
	public BigDecimal getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(BigDecimal errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDescription(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
}
