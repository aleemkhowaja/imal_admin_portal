/**
 * 
 */
package com.path.bo.common.additionalfields;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.admin.additionalfields.AdditionalFieldsByTypeSC;
import com.path.vo.common.FieldTechDetailsSC;
import com.path.vo.common.additionalfield.AdditionalFieldSC;
import com.path.vo.common.additionalfield.AdditionalFieldsByTypeCO;
import com.path.vo.core.trxmgnt.TrxMgntSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AdditionalFieldsBO.java used to
 */
public interface AdditionalFieldsBO
{
    public Map<String, Object> returnAdditionalFieldsByTypeCoMap(AdditionalFieldSC additionalFieldSC)throws BaseException;
    public AdditionalFieldsByTypeCO updateAdditionalFieldDetails(List<AdditionalFieldsByTypeCO> additionalFieldsByTypeCOList) throws BaseException;
    public AdditionalFieldsByTypeCO validateAdditionalFieldDate(AdditionalFieldsByTypeCO additionalFieldsByTypeCO)throws BaseException;
    
    public Map<String, Object> returnGridDetails(AdditionalFieldsByTypeSC additionalFieldsByTypeSC) throws BaseException;
    public List<Object> returnAdditionalFieldsbyTypeLookupDataList(AdditionalFieldsByTypeSC additionalFieldsByTypeSC) throws BaseException;
    public int returnAdditionalFieldsbyTypeLookupDataListCount(AdditionalFieldsByTypeSC additionalFieldsByTypeSC) throws BaseException;
    public AdditionalFieldsByTypeSC returnAdditionalFieldsByCode(AdditionalFieldsByTypeSC additionalFieldsByTypeSC) throws BaseException;
    
    public Map<String, String> returnAdditionalFieldsParam(AdditionalFieldSC additionalFieldSC)throws BaseException;
    public boolean validateMandatoryAdditionalFields(List<AdditionalFieldsByTypeCO> additionalFieldsByTypeCOList, boolean validateDate, AdditionalFieldSC additionalFieldSC) throws BaseException;
    public boolean checkForMandatoryAdditionalFields(AdditionalFieldSC additionalFieldSC)throws BaseException;
    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> returnMandatoryFieldsRelatedToDepositor(AdditionalFieldSC additionalFieldSC)throws BaseException;
    public AdditionalFieldsByTypeCO updateAdditionalFieldDetailsWithAudit(List<AdditionalFieldsByTypeCO> additionalFieldsByTypeCOList,AdditionalFieldsByTypeCO additionalFieldsByTypeCO)throws BaseException;
    
    public boolean checkForLookupDesc(AdditionalFieldsByTypeCO additionalFieldsByTypeCO) throws BaseException;
    public FieldTechDetailsSC returnElementFromFieldTech(String entity, String pbFieldName) throws BaseException;
    
    public AdditionalFieldsByTypeCO webServiceMapping(AdditionalFieldsByTypeCO additionalFieldsByTypeCO) throws BaseException;
    public boolean checkIfDataCanModified(CTSTELLERVO ctsTellerVO, String string, String iv_crud,
	    Integer accessDescriptionNumber) throws BaseException;
    public List<AdditionalFieldsByTypeCO> returnAdditionalFieldsByTypeCOList(AdditionalFieldSC additionalFieldSC)throws BaseException;
    public boolean returnCheckLinkedTRXSameADDFields(TrxMgntSC trxMgntSC) throws BaseException;
    public List<AdditionalFieldsByTypeCO> getAdditionalFieldsForLinkedTrx(AdditionalFieldSC additionalFieldSC) throws BaseException;

}
