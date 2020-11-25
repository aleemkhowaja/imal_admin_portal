package com.path.bo.common.safe;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.safe.SyncAccLockUnlockCO;
/**
 * Copyright 15, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author:HGhazal
 * 
 * Description: SafeAccLockMgmt used to manage Safe account locking methods
 * Power-builder library: common/sync_lock_unlock
 * Reference: 	TP#259473 
 * Date: 		04/05/2015
 */
public interface SafeAccLockBO {
	//	Lock/Unlock accounts passed in list
	public SyncAccLockUnlockCO lockUnlockAccounts_NewTrans(SyncAccLockUnlockCO syncAccLockUnlockCO, String action ) 
		throws BaseException;
}
