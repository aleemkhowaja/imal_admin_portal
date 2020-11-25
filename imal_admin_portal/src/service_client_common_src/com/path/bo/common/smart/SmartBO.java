/**
 * 
 */
package com.path.bo.common.smart;

import java.util.ArrayList;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.smart.SAdditionsDetailsCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.common.smart.SmartSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees/ Rabih El Khatib
 * SmartBO.java used to
 */


public interface SmartBO
{
    	public String returnSmartParentRef(SmartSC smartSC) throws BaseException;
	public ArrayList<SmartCO> returnSMARTfieldsList(SmartSC smartSC, AuditRefCO refCO) throws BaseException;
	public void updateSMARTfieldsList(SAdditionsDetailsCO sAdditionsDetailsCO, SmartSC smartSC) throws BaseException;
	public int checkSmartDetailsDefined(SmartSC smartSC, Boolean fromValidate) throws BaseException;
	//public void checkAuditForSmart(SmartSC smartSC) throws BaseException;
	public String deleteSmartRec(SmartSC smartSC) throws BaseException;
	public byte[] previewSmartObj(SmartSC smartSC) throws BaseException;
	public void updateSmartObj(SmartSC smartSC) throws BaseException;
	
	public SAdditionsDetailsCO returnSAdditionsDetailsCO(Boolean isSubmit, ArrayList<SmartCO> smartCOList, SmartSC smartSC ) throws BaseException;
	
	public void validateAndUpdateSmartDetails(ArrayList<SmartCO> smartCOList, SmartSC smartSC, AuditRefCO auditRefCO, Object auditObj)  throws BaseException;
	public boolean validateMandatorySmartFields(ArrayList<SmartCO> smartCOList, SmartSC smartSC )  throws BaseException;
	public void updateNewSmartDetails(ArrayList<SmartCO> smartCOList, SmartSC smartSC, AuditRefCO auditRefCO, Object auditObj)  throws BaseException;
	public ArrayList<SelectCO> returnSmartScreenParams(SmartSC smartSC) throws BaseException;
	public ArrayList<SmartCO> returnSMARTList(SmartSC smartSC, AuditRefCO refCO)throws BaseException;
	public void deleteSmartDet(SmartSC smartSC) throws BaseException;
	public String  checkIfEnabledCustomization()throws BaseException;
}
