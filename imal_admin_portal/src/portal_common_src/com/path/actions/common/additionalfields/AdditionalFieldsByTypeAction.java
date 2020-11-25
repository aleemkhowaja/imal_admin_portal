/**
 * 
 */
package com.path.actions.common.additionalfields;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.additionalfields.AdditionalFieldsBO;
import com.path.bo.common.additionalfields.AdditionalFieldsConstant;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.account.AccountsConstant;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.additionalfield.AdditionalFieldSC;
import com.path.vo.common.additionalfield.AdditionalFieldsByTypeCO;
import com.path.vo.common.audit.AuditRefCO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AdditionalFieldsAction.java used to
 */
public class AdditionalFieldsByTypeAction extends BaseAction
{
    private AdditionalFieldSC additionalFieldSC = new AdditionalFieldSC();
    private AdditionalFieldsBO additionalFieldsBO;
    private AdditionalFieldsByTypeCO additionalFieldsByTypeCO = new AdditionalFieldsByTypeCO();
    List<AdditionalFieldsByTypeCO> additionalFieldsByTypeCOList = new ArrayList<AdditionalFieldsByTypeCO>();
    private String errorMessage;
    private String cifStatus;
    private Date cif_UpdateDate;
    private String latestCifupdateDate;
    private CoreCommonServiceBO coreCommonServiceBO;
    
    public String validateAdditionalFieldsPopup()
    {
	try
	{
	    if(AdditionalFieldsConstant.CIF.equals(additionalFieldSC.getEntity()) && NumberUtil.isEmptyDecimal(additionalFieldSC.getTypeCode()))
	    {
		throw new BOException(MessageCodes.PLEASE_FILL, new String[] { "Cif_Type_key" });
	    }
	    else if(AdditionalFieldsConstant.AMF.equals(additionalFieldSC.getEntity()) && NumberUtil.isEmptyDecimal(additionalFieldSC.getTypeCode()))
	    {
		throw new BOException(MessageCodes.PLEASE_FILL, new String[] { "Type_key" });
	    }
	    else if(AdditionalFieldsConstant.CTSTRS.equals(additionalFieldSC.getEntity()) && NumberUtil.isEmptyDecimal(additionalFieldSC.getTypeCode()))
	    {
		throw new BOException(MessageCodes.PLEASE_FILL, new String[] { "Trx_Type_key" });
	    }
	    //DASI170129 
	    else if(AdditionalFieldsConstant.CARD.equals(additionalFieldSC.getEntity()) && NumberUtil.isEmptyDecimal(additionalFieldSC.getTypeCode()))
	    {
		throw new BOException(MessageCodes.PLEASE_FILL, new String[] { "Card_Type_key" });
	    }	    
	}
	catch (Exception e) 
	{
	    handleException(e, null, null);
	}
	return "validatepopulateAdditionalFields";
    }
    
    @SuppressWarnings("unchecked")
    public String populateAdditionalFieldsPopup()
    {
	try
	{
	    
	    SessionCO sessionCO = returnSessionObject();

	    String allowToModifyCif = "";
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		allowToModifyCif = sessionCO.getCtsTellerVO().getALLOW_TO_MODIFY_CIF();
	    }
	    if(!StringUtils.isNotEmpty(allowToModifyCif))
	    {
		allowToModifyCif = "N";
	    }
	    
		Integer AccessDescriptionNumber = NCifMaintenanceConstant.ADDITIONAL_FIELDS;
	    
		   // Bug # 346325 -- [John Massaad] sending the Transaction branchCode
		    // as a parameter (the branch where the transaction has been
		    // created), because this trx can be opened from another branch

		    
		    // For Accounts use business crud
		    if(StringUtil.isNotEmpty(additionalFieldSC.getAccountType()))
		    {
			String accountType = additionalFieldSC.getAccountType();
			if(AccountsConstant.GENERAL_ACCOUNT.equals(accountType))
			{
			    additionalFieldSC.setIv_crud(AccountsConstant.returnGeneralBuisnessCrud(additionalFieldSC.getIv_crud()));
			}
			else if(AccountsConstant.FIXED_ACCOUNT.equals(accountType))
			{
			    additionalFieldSC.setIv_crud(AccountsConstant.returnFixedBuisnessCrud(additionalFieldSC.getIv_crud()));
			}
		    }	  
		    //SUPT190382 - [AUB-Upgrade] Modify Draft CIF
		    boolean checkAcess;

		         if(AdditionalFieldsConstant.CIF.equals(additionalFieldSC.getEntity()))
		    {
			 checkAcess = additionalFieldsBO.checkIfDataCanModified(sessionCO.getCtsTellerVO(),
				 additionalFieldSC.getStatus(),    additionalFieldSC.getIv_crud(), AccessDescriptionNumber);
		    }
		    else
		    {
			checkAcess = additionalFieldsBO.checkIfDataCanModified(sessionCO.getCtsTellerVO(),
				    "A",    additionalFieldSC.getIv_crud(), AccessDescriptionNumber);
			
		    }
		//SUPT190382 - [AUB-Upgrade] Modify Draft CIF

		    if (checkAcess  && ConstantsCommon.YES.equals(allowToModifyCif))
		    {
			allowToModifyCif = "Y";
		    }
		    else
		    {	
		   if(checkAcess && AdditionalFieldsConstant.CIF.equals(additionalFieldSC.getEntity()))
		    {
			allowToModifyCif = "Y";
		    
		    }
		    else
		    {
			allowToModifyCif = "N";
		    }
		    }
			//SUPT190382 - [AUB-Upgrade] Modify Draft CIF

	    additionalFieldSC.setAllowToModifyCif(allowToModifyCif); 
	    additionalFieldSC.setCompCode(sessionCO.getCompanyCode());	
	    additionalFieldSC.setCurrAppName(sessionCO.getCurrentAppName());
		if (additionalFieldSC.getProgRef() == null)
		{
		    additionalFieldSC.setProgRef("ROOT");
		}
	    String prog_ref =  returnCommonLibBO().returnOptDetailsList("RET", additionalFieldSC.getProgRef())[3];
	    StringUtil.nullEmptyToValue(prog_ref, "ROOT");
	    additionalFieldSC.setProgRef(prog_ref);
	    additionalFieldSC.setPreferredLanguage(sessionCO.getLanguage());
	  
	    //Bug # 346325 -- [John Massaad] sending the Transaction branchCode as a parameter (the branch where the transaction has been created), because this trx can be opened form another branch
	    if(NumberUtil.isEmptyDecimal(additionalFieldSC.getBranchCode()))
	    {
		additionalFieldSC.setBranchCode(sessionCO.getBranchCode());
	    }
	   //Bug # 346325 -- [John Massaad] sending the Transaction branchCode as a parameter (the branch where the transaction has been created), because this trx can be opened form another branch
	    
	    Map<String, Object> additionalFieldsByTypeMap = additionalFieldsBO.returnAdditionalFieldsByTypeCoMap(additionalFieldSC);
	    additionalFieldsByTypeCOList= (List<AdditionalFieldsByTypeCO>)additionalFieldsByTypeMap.get("additionalFieldsByTypeCOList");
	    if(!additionalFieldsByTypeCOList.isEmpty())
	    {
		getAdditionalScreenParams().putAll((HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>)additionalFieldsByTypeMap.get("hm"));
	    }
	    
	    //Rakan Makarem- #584327
	    
	   // falha #820502 Additional Field is disabled at all levels
	   //only at CIF level we must disable add fields  using access
	    if(AdditionalFieldsConstant.CIF.equals(additionalFieldSC.getEntity()))
	    {
	    Boolean cifUserAcess=true;
	    
	    //cifUserAcess=coreCommonServiceBO.checkAccesTellerModified(sessionCO.getCtsTellerVO(), NCifMaintenanceConstant.ADDITIONAL_FIELDS);
	    //SUPT190382 - [AUB-Upgrade] Modify Draft CIF
	    cifUserAcess=additionalFieldsBO.checkIfDataCanModified(sessionCO.getCtsTellerVO(),
		    additionalFieldSC.getStatus(),    additionalFieldSC.getIv_crud(), AccessDescriptionNumber);
	
	    if(!cifUserAcess)
	    {
		set_recReadOnly("true");
	    }
	    }
	}
	catch(BOException e)
	{
	    Integer errorCode = e.getErrorCode();
	    if(MessageCodes.INVALID_MISSING.compareTo(errorCode) == 0)
	    {
		String[] params = e.getParams();
		errorMessage = "Cannot map the curresponding pb field name of " + params[0] + " in " + params[1]
			+ " from FIELD_TECH_DETAILS";
	    }
	    handleException(e, null, null);
	    if(MessageCodes.THE_PARAMETRIZATIONS_MUST_NOT_CONTAIN_ANY_LINK_TO_CTSTRS.compareTo(errorCode) == 0)
	    {
		errorMessage = get_error();
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	// copied from Antonella from 14.0.9 Hassan Bug#519493 21/07/2017, if sectionKey is empty means is called on 14.0.9 (SAVEFOM) (to copy later to other releases)
	if(AdditionalFieldsConstant.CIF.equals(additionalFieldSC.getEntity())
		&& !StringUtil.isNotEmpty(additionalFieldSC.getSectionKey()))
	{
	    return "populateAdditionalFieldsForm";
	}
	return "populateAdditionalFields";
    }
    
    private void prepareAuditObject()throws BaseException
    {
	try
	{
	    AuditRefCO refCO = initAuditRefCO();
	    refCO.setOperationType(AuditConstant.UPDATE);
	    refCO.setKeyRef(additionalFieldsByTypeCO.getAuditRef());
	    additionalFieldsByTypeCO.setAuditRefCO(refCO);
	    Class<?> auditClass = Class.forName(additionalFieldsByTypeCO.getAuditClassName());
	    additionalFieldsByTypeCO.setAuditObj(returnAuditObject(auditClass));
	}
	catch (Exception e) 
	{
	    throw new BaseException(e);
	}
	
    }
	
    
    public String saveAdditionalFieldsDetails()
    {
	try
	{
	    additionalFieldsByTypeCO.setLoginCompCode(returnSessionObject().getCompanyCode());
	    additionalFieldsByTypeCO.setRunningDate(returnSessionObject().getRunningDateRET());
	    //Abdo TP#641518 20/03/2018
	    additionalFieldsByTypeCO.setCompCodeCif(//Hasan EWBI160091 13/06/2016
		    NumberUtil.nullEmptyToValue(additionalFieldSC.getCompCodeCif(), returnSessionObject().getCompanyCode()));
	    additionalFieldsByTypeCO.setCifStatus(cifStatus);
	    additionalFieldsByTypeCO.setCif_UpdateDate(cif_UpdateDate);
	   //End  
	    for(AdditionalFieldsByTypeCO additionalFieldsByTypeCO:additionalFieldsByTypeCOList)
	    {		
		if(AdditionalFieldsConstant.FIELD_TYPE_DATE.equals(additionalFieldsByTypeCO.getFIELD_TYPE()) && additionalFieldsByTypeCO.getADD_DT()!=null)
		{   
		    additionalFieldsByTypeCO.setRunningDate(returnSessionObject().getRunningDateRET());
		}
	    }
	   
	    if(Boolean.valueOf(additionalFieldsByTypeCO.getApplyAudit()))
	    {
	       set_pageRef(additionalFieldsByTypeCO.getAuditOpt());
	       prepareAuditObject();
	       additionalFieldsByTypeCO = additionalFieldsBO.updateAdditionalFieldDetailsWithAudit(additionalFieldsByTypeCOList,additionalFieldsByTypeCO);
	    }
	    else
	    {
		additionalFieldsByTypeCO = additionalFieldsBO.updateAdditionalFieldDetails(additionalFieldsByTypeCOList);
	    }
	    if(additionalFieldsByTypeCO != null)
	    {
		// EWBI160091 (403157)- reset the hidden value
		additionalFieldsByTypeCO.setCompCodeCif(NumberUtil.nullToZero(additionalFieldsByTypeCO.getCompCodeCif()));
	    }
	    //Abdo TP#641518 21/03/2018
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS", Locale.ENGLISH);
	    latestCifupdateDate = df.format(additionalFieldsByTypeCO.getCif_UpdateDate());
	    setCifStatus(additionalFieldsByTypeCO.getCifStatus());
	    //End Abdo
	   
	   
	}	
	catch (Exception e) {
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String validateAdditionalFieldDate()
    {
	try
	{
	    if(additionalFieldsByTypeCO.getADD_DT()!=null){
		additionalFieldsByTypeCO.setRunningDate(returnSessionObject().getRunningDateRET());
		additionalFieldsByTypeCO = additionalFieldsBO.validateAdditionalFieldDate(additionalFieldsByTypeCO);
	    }
	}
	catch (Exception e) {
	    additionalFieldsByTypeCO.setADD_DT(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    
    /**
     * @return the additionalFieldSC
     */
    @Override
    public Object getModel()
    {
        return additionalFieldSC;
    }
    /**
     * @return the additionalFieldSC
     */
    public AdditionalFieldSC getAdditionalFieldSC()
    {
        return additionalFieldSC;
    }
    /**
     * @param additionalFieldSC the additionalFieldSC to set
     */
    public void setAdditionalFieldSC(AdditionalFieldSC additionalFieldSC)
    {
        this.additionalFieldSC = additionalFieldSC;
    }

    /**
     * @param additionalFieldsBO the additionalFieldsBO to set
     */
    public void setAdditionalFieldsBO(AdditionalFieldsBO additionalFieldsBO)
    {
        this.additionalFieldsBO = additionalFieldsBO;
    }

    /**
     * @return the additionalFieldsByTypeCOList
     */
    public List<AdditionalFieldsByTypeCO> getAdditionalFieldsByTypeCOList()
    {
        return additionalFieldsByTypeCOList;
    }

    /**
     * @param additionalFieldsByTypeCOList the additionalFieldsByTypeCOList to set
     */
    public void setAdditionalFieldsByTypeCOList(List<AdditionalFieldsByTypeCO> additionalFieldsByTypeCOList)
    {
        this.additionalFieldsByTypeCOList = additionalFieldsByTypeCOList;
    }

    /**
     * @return the additionalFieldsByTypeCO
     */
    public AdditionalFieldsByTypeCO getAdditionalFieldsByTypeCO()
    {
        return additionalFieldsByTypeCO;
    }

    /**
     * @param additionalFieldsByTypeCO the additionalFieldsByTypeCO to set
     */
    public void setAdditionalFieldsByTypeCO(AdditionalFieldsByTypeCO additionalFieldsByTypeCO)
    {
        this.additionalFieldsByTypeCO = additionalFieldsByTypeCO;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage()
    {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public String getCifStatus()
    {
        return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
        this.cifStatus = cifStatus;
    }

    public Date getCif_UpdateDate()
    {
        return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cif_UpdateDate)
    {
        this.cif_UpdateDate = cif_UpdateDate;
    }

    public String getLatestCifupdateDate()
    {
        return latestCifupdateDate;
    }

    public void setLatestCifupdateDate(String latestCifupdateDate)
    {
        this.latestCifupdateDate = latestCifupdateDate;
    }
    
    public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
    {
	this.coreCommonServiceBO = coreCommonServiceBO;
    }
   
}
