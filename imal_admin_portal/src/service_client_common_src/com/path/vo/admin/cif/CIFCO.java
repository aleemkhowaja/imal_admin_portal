package com.path.vo.admin.cif;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.dbmaps.vo.CIF1VO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_AUTH_SIGNATORYVO;
import com.path.dbmaps.vo.CIF_EXTENDEDVO;
import com.path.dbmaps.vo.CTSCERTIFICATE_AUTH_SIGVO;
import com.path.dbmaps.vo.PMSCIFSWIFTVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: WissamChebli
 * 
 * CIFCO.java used to
 */

public class CIFCO extends RetailBaseVO
{
    private CIFVO cifVO = new CIFVO();
    private CIF1VO cif1VO = new CIF1VO();
    
    // TP 324728 -- Hala Al Sheikh Enhance the checking on the US
    private CIF_EXTENDEDVO cifExtendedVO = new CIF_EXTENDEDVO();
    private String countryOfIssuanceDesc;
    // End Hala
    
    private RIFCTTVO rifcttVO = new RIFCTTVO();
    private CIF_AUTH_SIGNATORYVO cif_auth_signatoryVO = new CIF_AUTH_SIGNATORYVO(); // For the
    // signatory
    // opening
    private CTSCERTIFICATE_AUTH_SIGVO ctscertificate_auth_sigVO = new CTSCERTIFICATE_AUTH_SIGVO();// For
    // the
    // signatory
    // opening
    private String SHORT_NAME;
    private String natioName;
    private String ADDRESS1;
    private String ADDRESS2;
    private String ADDRESS3;
    private String actionStr;
    private int messageId;
    // Added by jihad
    private int countCif;
    private BigDecimal jointCifNo;
    private BigDecimal authCifNo;
    private String ID_TYPE_NAME;
    private BigDecimal ID_TYPE;

    // Added by Libin
    private String COUNTRY_DESC;
    private String CIF_TYPE_DESC;
    private String REGION_DESC;
    private String NATION_DESC;
    private String LEGAL_STATUS_DESC;
    public boolean showDepMsg;

    //
    private PMSCIFSWIFTVO pmsCifSwiftVO = new PMSCIFSWIFTVO();
    private BigDecimal bicCodeLimit;
    private String countryName;
    private String branchName;

    private String bankCifInd; // B (Bank) , C (Client)
    private String bicCode;
    private String warningMessage;
    private String errorMessage;
    private BigDecimal errorCode;
    private String errorType;// to get the error type
    private String infoMsgParam;

    private BigDecimal countryBlacklisted;

    private BigDecimal branchCode;// the branch code of an account
    private BigDecimal glCode;// the gl code of an account
    private BigDecimal currenCyCode; // the currency code of an account
    private String validateCifAccount;// this flag is used to validate if this cif related to an
    // account
    private int isRTLDir;// 1 means Right To left Direction, 0 Otherwise
    private String validateSpecialCond;// to validate the special condition

    private BigDecimal cifInterdiction; // Additional field to indicate if the CIF has invalid
    // trading status
    private BigDecimal cifAddressCountry; // CIF Address country code
    private String cifAddCountryDesc; // CIF Address country description

    private String idTypesName; // ID type name
    private String cifNis; // CIF-NIS
    private String cifNif; // CIF-NIF
    private String vehicleNo;
    private String[] paramsCtsMsg;

    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private boolean bicCodeReadOnly;
    private String countryNameLong;

    private String cif1CountryOfIssuanceDesc;
    private String cif1CountryOfIssuanceDesc2;
    private String cif1CountryOfIssuanceDesc3;
    
    private String ID_NO;
    private String DETAILS_TYPE;
    private String AUTH_NAME;
    private BigDecimal LINE_NO;
    
    //TP # 412662 - Customer RelationShip Management -- [Joyce Kanazeh]
    private String representiveUserId;
    private String priorityDesc;
    private String categoryDesc;
    
    public String getID_TYPE_NAME()
    {
        return ID_TYPE_NAME;
    }

    public void setID_TYPE_NAME(String iDTYPENAME)
    {
        ID_TYPE_NAME = iDTYPENAME;
    }

    public BigDecimal getAuthCifNo()
    {
        return authCifNo;
    }

    public void setAuthCifNo(BigDecimal authCifNo)
    {
        this.authCifNo = authCifNo;
    }

    public BigDecimal getJointCifNo()
    {
        return jointCifNo;
    }

    public void setJointCifNo(BigDecimal jointCifNo)
    {
        this.jointCifNo = jointCifNo;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
    {
        return buisnessElement;
    }

    public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
    {
        this.buisnessElement = buisnessElement;
    }

    public String getNatioName()
    {
        return natioName;
    }

    public void setNatioName(String natioName)
    {
        this.natioName = natioName;
    }

    /**
     * @return the cifVO
     */
    public CIFVO getCifVO()
    {
        return cifVO;
    }

    /**
     * @param cifVO the cifVO to set
     */
    public void setCifVO(CIFVO cifVO)
    {
        this.cifVO = cifVO;
    }

    /**
     * @return the cif1VO
     */
    public CIF1VO getCif1VO()
    {
        return cif1VO;
    }

    /**
     * @param cif1vo the cif1VO to set
     */
    public void setCif1VO(CIF1VO cif1vo)
    {
        cif1VO = cif1vo;
    }

    /**
     * @return the sHORT_NAME
     */
    public String getSHORT_NAME()
    {
        return SHORT_NAME;
    }

    /**
     * @param sHORTNAME the sHORT_NAME to set
     */
    public void setSHORT_NAME(String sHORTNAME)
    {
        SHORT_NAME = sHORTNAME;
    }

    /**
     * @return the aDDRESS1
     */
    public String getADDRESS1()
    {
        return ADDRESS1;
    }

    /**
     * @param aDDRESS1 the aDDRESS1 to set
     */
    public void setADDRESS1(String aDDRESS1)
    {
        ADDRESS1 = aDDRESS1;
    }

    /**
     * @return the aDDRESS2
     */
    public String getADDRESS2()
    {
        return ADDRESS2;
    }

    /**
     * @param aDDRESS2 the aDDRESS2 to set
     */
    public void setADDRESS2(String aDDRESS2)
    {
        ADDRESS2 = aDDRESS2;
    }

    /**
     * @return the aDDRESS3
     */
    public String getADDRESS3()
    {
        return ADDRESS3;
    }

    /**
     * @param aDDRESS3 the aDDRESS3 to set
     */
    public void setADDRESS3(String aDDRESS3)
    {
        ADDRESS3 = aDDRESS3;
    }

    /**
     * @return the messageId
     */
    public int getMessageId()
    {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(int messageId)
    {
        this.messageId = messageId;
    }

    public int getCountCif()
    {
        return countCif;
    }

    public void setCountCif(int countCif)
    {
        this.countCif = countCif;
    }

    public String getCOUNTRY_DESC()
    {
        return COUNTRY_DESC;
    }

    public void setCOUNTRY_DESC(String cOUNTRYDESC)
    {
        COUNTRY_DESC = cOUNTRYDESC;
    }

    public String getCIF_TYPE_DESC()
    {
        return CIF_TYPE_DESC;
    }

    public void setCIF_TYPE_DESC(String cIFTYPEDESC)
    {
        CIF_TYPE_DESC = cIFTYPEDESC;
    }

    public String getREGION_DESC()
    {
        return REGION_DESC;
    }

    public void setREGION_DESC(String rEGIONDESC)
    {
        REGION_DESC = rEGIONDESC;
    }

    public String getNATION_DESC()
    {
        return NATION_DESC;
    }

    public void setNATION_DESC(String nATIONDESC)
    {
        NATION_DESC = nATIONDESC;
    }

    public String getLEGAL_STATUS_DESC()
    {
        return LEGAL_STATUS_DESC;
    }

    public void setLEGAL_STATUS_DESC(String lEGALSTATUSDESC)
    {
        LEGAL_STATUS_DESC = lEGALSTATUSDESC;
    }

    public boolean isShowDepMsg()
    {
        return showDepMsg;
    }

    public void setShowDepMsg(boolean showDepMsg)
    {
        this.showDepMsg = showDepMsg;
    }

    public RIFCTTVO getRifcttVO()
    {
        return rifcttVO;
    }

    public void setRifcttVO(RIFCTTVO rifcttVO)
    {
        this.rifcttVO = rifcttVO;
    }

    /**
     * @return the pmsCifSwiftVO
     */
    public PMSCIFSWIFTVO getPmsCifSwiftVO()
    {
        return pmsCifSwiftVO;
    }

    /**
     * @param pmsCifSwiftVO the pmsCifSwiftVO to set
     */
    public void setPmsCifSwiftVO(PMSCIFSWIFTVO pmsCifSwiftVO)
    {
        this.pmsCifSwiftVO = pmsCifSwiftVO;
    }

    /**
     * @return the bicCodeLimit
     */
    public BigDecimal getBicCodeLimit()
    {
        return bicCodeLimit;
    }

    /**
     * @param bicCodeLimit the bicCodeLimit to set
     */
    public void setBicCodeLimit(BigDecimal bicCodeLimit)
    {
        this.bicCodeLimit = bicCodeLimit;
    }

    /**
     * @return the countryName
     */
    public String getCountryName()
    {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }

    /**
     * @return the branchName
     */
    public String getBranchName()
    {
        return branchName;
    }

    /**
     * @param branchName the branchName to set
     */
    public void setBranchName(String branchName)
    {
        this.branchName = branchName;
    }

    /**
     * @return the bicCode
     */
    public String getBicCode()
    {
        return bicCode;
    }

    /**
     * @param bicCode the bicCode to set
     */
    public void setBicCode(String bicCode)
    {
        this.bicCode = bicCode;
    }

    /**
     * @return the warningMessage
     */
    public String getWarningMessage()
    {
        return warningMessage;
    }

    /**
     * @param warningMessage the warningMessage to set
     */
    public void setWarningMessage(String warningMessage)
    {
        this.warningMessage = warningMessage;
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

    /**
     * @return the bankCifInd
     */
    public String getBankCifInd()
    {
        return bankCifInd;
    }

    /**
     * @param bankCifInd the bankCifInd to set
     */
    public void setBankCifInd(String bankCifInd)
    {
        this.bankCifInd = bankCifInd;
    }

    /**
     * @return the errorCode
     */
    public BigDecimal getErrorCode()
    {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }

    /**
     * @return the countryBlacklisted
     */
    public BigDecimal getCountryBlacklisted()
    {
        return countryBlacklisted;
    }

    /**
     * @param countryBlacklisted the countryBlacklisted to set
     */
    public void setCountryBlacklisted(BigDecimal countryBlacklisted)
    {
        this.countryBlacklisted = countryBlacklisted;
    }

    public BigDecimal getGlCode()
    {
        return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
        this.glCode = glCode;
    }

    public BigDecimal getCurrenCyCode()
    {
        return currenCyCode;
    }

    public void setCurrenCyCode(BigDecimal currenCyCode)
    {
        this.currenCyCode = currenCyCode;
    }

    public String getValidateCifAccount()
    {
        return validateCifAccount;
    }

    public void setValidateCifAccount(String validateCifAccount)
    {
        this.validateCifAccount = validateCifAccount;
    }

    public int getIsRTLDir()
    {
        return isRTLDir;
    }

    public void setIsRTLDir(int isRTLDir)
    {
        this.isRTLDir = isRTLDir;
    }

    public BigDecimal getBranchCode()
    {
        return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }

    public String getErrorType()
    {
        return errorType;
    }

    public void setErrorType(String errorType)
    {
        this.errorType = errorType;
    }

    public String getValidateSpecialCond()
    {
        return validateSpecialCond;
    }

    public void setValidateSpecialCond(String validateSpecialCond)
    {
        this.validateSpecialCond = validateSpecialCond;
    }

    public String getActionStr()
    {
        return actionStr;
    }

    public void setActionStr(String actionStr)
    {
        this.actionStr = actionStr;
    }

    /**
     * @return the infoMsgParam
     */
    public String getInfoMsgParam()
    {
        return infoMsgParam;
    }

    /**
     * @param infoMsgParam the infoMsgParam to set
     */
    public void setInfoMsgParam(String infoMsgParam)
    {
        this.infoMsgParam = infoMsgParam;
    }

    /**
     * @return the cifInterdiction
     */
    public BigDecimal getCifInterdiction()
    {
        return cifInterdiction;
    }

    /**
     * @param cifInterdiction the cifInterdiction to set
     */
    public void setCifInterdiction(BigDecimal cifInterdiction)
    {
        this.cifInterdiction = cifInterdiction;
    }

    /**
     * @return the cifAddressCountry
     */
    public BigDecimal getCifAddressCountry()
    {
        return cifAddressCountry;
    }

    /**
     * @param cifAddressCountry the cifAddressCountry to set
     */
    public void setCifAddressCountry(BigDecimal cifAddressCountry)
    {
        this.cifAddressCountry = cifAddressCountry;
    }

    /**
     * @return the cifAddCountryDesc
     */
    public String getCifAddCountryDesc()
    {
        return cifAddCountryDesc;
    }

    /**
     * @param cifAddCountryDesc the cifAddCountryDesc to set
     */
    public void setCifAddCountryDesc(String cifAddCountryDesc)
    {
        this.cifAddCountryDesc = cifAddCountryDesc;
    }

    /**
     * @return the idTypesName
     */
    public String getIdTypesName()
    {
        return idTypesName;
    }

    /**
     * @param idTypesName the idTypesName to set
     */
    public void setIdTypesName(String idTypesName)
    {
        this.idTypesName = idTypesName;
    }

    /**
     * @return the cifNis
     */
    public String getCifNis()
    {
        return cifNis;
    }

    /**
     * @param cifNis the cifNis to set
     */
    public void setCifNis(String cifNis)
    {
        this.cifNis = cifNis;
    }

    /**
     * @return the cifNif
     */
    public String getCifNif()
    {
        return cifNif;
    }

    /**
     * @param cifNif the cifNif to set
     */
    public void setCifNif(String cifNif)
    {
        this.cifNif = cifNif;
    }

    public String getVehicleNo()
    {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo)
    {
        this.vehicleNo = vehicleNo;
    }

    public String[] getParamsCtsMsg()
    {
        return paramsCtsMsg;
    }

    public void setParamsCtsMsg(String... paramsCtsMsg)
    {
        this.paramsCtsMsg = paramsCtsMsg;
    }

    public CIF_AUTH_SIGNATORYVO getCif_auth_signatoryVO()
    {
        return cif_auth_signatoryVO;
    }

    public void setCif_auth_signatoryVO(CIF_AUTH_SIGNATORYVO cifAuthSignatoryVO)
    {
        cif_auth_signatoryVO = cifAuthSignatoryVO;
    }

    public BigDecimal getID_TYPE()
    {
        return ID_TYPE;
    }

    public void setID_TYPE(BigDecimal iDTYPE)
    {
        ID_TYPE = iDTYPE;
    }

    public CTSCERTIFICATE_AUTH_SIGVO getCtscertificate_auth_sigVO()
    {
        return ctscertificate_auth_sigVO;
    }

    public void setCtscertificate_auth_sigVO(CTSCERTIFICATE_AUTH_SIGVO ctscertificateAuthSigVO)
    {
        ctscertificate_auth_sigVO = ctscertificateAuthSigVO;
    }

    public boolean isBicCodeReadOnly()
    {
        return bicCodeReadOnly;
    }

    public void setBicCodeReadOnly(boolean bicCodeReadOnly)
    {
        this.bicCodeReadOnly = bicCodeReadOnly;
    }
    
    public String getCountryNameLong()
    {
        return countryNameLong;
    }

    public void setCountryNameLong(String countryNameLong)
    {
        this.countryNameLong = countryNameLong;
    }

    public CIF_EXTENDEDVO getCifExtendedVO()
    {
        return cifExtendedVO;
    }

    public void setCifExtendedVO(CIF_EXTENDEDVO cifExtendedVO)
    {
        this.cifExtendedVO = cifExtendedVO;
    }

    public String getCountryOfIssuanceDesc()
    {
        return countryOfIssuanceDesc;
    }

    public void setCountryOfIssuanceDesc(String countryOfIssuanceDesc)
    {
        this.countryOfIssuanceDesc = countryOfIssuanceDesc;
    }

    public String getCif1CountryOfIssuanceDesc()
    {
        return cif1CountryOfIssuanceDesc;
    }

    public void setCif1CountryOfIssuanceDesc(String cif1CountryOfIssuanceDesc)
    {
        this.cif1CountryOfIssuanceDesc = cif1CountryOfIssuanceDesc;
    }

    public String getCif1CountryOfIssuanceDesc2()
    {
        return cif1CountryOfIssuanceDesc2;
    }

    public void setCif1CountryOfIssuanceDesc2(String cif1CountryOfIssuanceDesc2)
    {
        this.cif1CountryOfIssuanceDesc2 = cif1CountryOfIssuanceDesc2;
    }

    public String getCif1CountryOfIssuanceDesc3()
    {
        return cif1CountryOfIssuanceDesc3;
    }

    public void setCif1CountryOfIssuanceDesc3(String cif1CountryOfIssuanceDesc3)
    {
        this.cif1CountryOfIssuanceDesc3 = cif1CountryOfIssuanceDesc3;
    }
    
    public String getID_NO()
    {
        return ID_NO;
    }

    public void setID_NO(String ID_NO)
    {
	this.ID_NO = ID_NO;
    }

    public String getDETAILS_TYPE()
    {
        return DETAILS_TYPE;
    }

    public void setDETAILS_TYPE(String DETAILS_TYPE)
    {
	this.DETAILS_TYPE = DETAILS_TYPE;
    }

    public String getAUTH_NAME()
    {
        return AUTH_NAME;
    }

    public void setAUTH_NAME(String AUTH_NAME)
    {
	this.AUTH_NAME = AUTH_NAME;
    }

    public BigDecimal getLINE_NO()
    {
        return LINE_NO;
    }

    public void setLINE_NO(BigDecimal lINENO)
    {
	this.LINE_NO = lINENO;
    }

    public String getRepresentiveUserId()
    {
        return representiveUserId;
    }

    public void setRepresentiveUserId(String representiveUserId)
    {
        this.representiveUserId = representiveUserId;
    }

    public String getPriorityDesc()
    {
        return priorityDesc;
    }

    public void setPriorityDesc(String priorityDesc)
    {
        this.priorityDesc = priorityDesc;
    }

    public String getCategoryDesc()
    {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc)
    {
        this.categoryDesc = categoryDesc;
    }
    
    
    
}
