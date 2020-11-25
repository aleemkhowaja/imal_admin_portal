/**
 * 
 */
package com.path.vo.common.additionalfield;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.AMF_DATA_ADD_FIELDSVOKey;
import com.path.dbmaps.vo.CIF_DATA_ADD_FIELDSVOKey;
import com.path.dbmaps.vo.CTSTRS_DATA_ADD_FIELDSVOKey;
import com.path.dbmaps.vo.CTS_ADD_FIELDSVO;
import com.path.dbmaps.vo.CTS_ADD_FIELDS_ENTITYVOKey;
import com.path.dbmaps.vo.CTS_ADD_FIELD_DROPDOWN_LST_DEFVO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.dbmaps.vo.CTSCARDS_DATA_ADD_FIELDSVOKey;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AdditionalFieldsTypeCO.java used to
 */
public class AdditionalFieldsByTypeCO extends RetailBaseVO implements Serializable
{
    private String ENTITY;
    private String FIELD_LABEL;
    private String SHOW;//1 or 0
    private String MANDATORY;//1 or 0
    private BigDecimal FIELD_SEQ;
    private String FIELD_TYPE; // V- textfields
    private BigDecimal FIELD_LENGHT;
    private String BRIEF_DESC_ENG;
    private BigDecimal COLUMN_NUMBER; // CTS_ADD_FIELDSVO
    private String LOOKUP_TYPE;
    private String ADD_NUM_DESC;
    private BigDecimal CODE;
    private BigDecimal COMP_CODE;
    private String DATA_ENTRY;
    private String DATE_VALIDATION;
    private String DATE_VALIDATION_OPERATOR;
    private String DESC_OUTPUT;
    private String TABLE_NAME;
    private Date addDateCompareTo;
    private String addDateCompareToElemId;
    private String addDateCompareToElemLabel;
    private String additionalParam;
    private String dependency;
    private boolean numberDependency;
    
    private Date   runningDate;
    private String FIELD_FORMAT;
    private String DATE_LINK;
    private String PARAM1_LINK;
    private String PARAM2_LINK;
    private String PARAM3_LINK;
    private String PARAM4_LINK;
    private String PARAM5_LINK;
    private String PARAM_VALUE1;
    private String PARAM_VALUE2;
    private String PARAM_VALUE3;
    private String PARAM_VALUE4;
    private String PARAM_VALUE5;
    private String RELATED_TO_DEPOSITOR_INFO;
    
    private BigDecimal ADD_NUM;
    private String ADD_VC;
    private Date ADD_DT;
    private String ADD_DR;
    //CDMI170110 - set field readonly for fields from BCT
    private String IS_READONLY_YN;
    
    private String addField1CompareToElemId;
    private String addField2CompareToElemId;
    private String addField3CompareToElemId;
    private String addField4CompareToElemId;
    private String addField5CompareToElemId;
    
    private String lookupDesc;

    private CTS_ADD_FIELDSVO ctsAddFieldVO = new CTS_ADD_FIELDSVO();
    private CIF_DATA_ADD_FIELDSVOKey cifDataAddFieldsVO = new CIF_DATA_ADD_FIELDSVOKey();
    private AMF_DATA_ADD_FIELDSVOKey amfDataAddFieldsVO = new AMF_DATA_ADD_FIELDSVOKey();
    private CTSTRS_DATA_ADD_FIELDSVOKey ctstrsDataAddFieldsVO = new CTSTRS_DATA_ADD_FIELDSVOKey();
    private CTS_ADD_FIELDS_ENTITYVOKey ctsAddFieldEntityVO = new CTS_ADD_FIELDS_ENTITYVOKey();
    //Audit Implementation
    private String applyAudit;
    private String auditClassName;
    private String auditRef;
    private String auditOpt;
    
    
    private String cifStatus;
    private Date cif_UpdateDate;
    private String LatestDateUpdated;
    
    // Additional Fields by Type isLoaded flag
    private List<AdditionalFieldsByTypeCO> dynamicList;
    private BigDecimal compCodeCif;

    private String fromWhere;
    
    private BigDecimal MIN_FIELD_LENGTH=new BigDecimal(0);

    //MajdHaidar -- Additional Fields DropDownList
    private List<CTS_ADD_FIELD_DROPDOWN_LST_DEFVO> ctsAddFieldDrpDwnDefVOList = new ArrayList<CTS_ADD_FIELD_DROPDOWN_LST_DEFVO>();
    private CTSCARDS_DATA_ADD_FIELDSVOKey ctsCardsDataAddFieldsVO = new CTSCARDS_DATA_ADD_FIELDSVOKey(); //DASI170129 
    
    /**
     * @return the fIELD_LABEL
     */
    public String getFIELD_LABEL()
    {
        return FIELD_LABEL;
    }
    /**
     * @param fIELDLABEL the fIELD_LABEL to set
     */
    public void setFIELD_LABEL(String fIELDLABEL)
    {
        FIELD_LABEL = fIELDLABEL;
    }
    /**
     * @return the sHOW
     */
    public String getSHOW()
    {
        return SHOW;
    }
    /**
     * @param sHOW the sHOW to set
     */
    public void setSHOW(String sHOW)
    {
        SHOW = sHOW;
    }
    /**
     * @return the mANDATORY
     */
    public String getMANDATORY()
    {
        return MANDATORY;
    }
    /**
     * @param mANDATORY the mANDATORY to set
     */
    public void setMANDATORY(String mANDATORY)
    {
        MANDATORY = mANDATORY;
    }
    /**
     * @return the fIELD_SEQ
     */
    public BigDecimal getFIELD_SEQ()
    {
        return FIELD_SEQ;
    }
    /**
     * @param fIELDSEQ the fIELD_SEQ to set
     */
    public void setFIELD_SEQ(BigDecimal fIELDSEQ)
    {
        FIELD_SEQ = fIELDSEQ;
    }
    /**
     * @return the fIELD_TYPE
     */
    public String getFIELD_TYPE()
    {
        return FIELD_TYPE;
    }
    /**
     * @param fIELDTYPE the fIELD_TYPE to set
     */
    public void setFIELD_TYPE(String fIELDTYPE)
    {
        FIELD_TYPE = fIELDTYPE;
    }
    /**
     * @return the fIELD_LENGHT
     */
    public BigDecimal getFIELD_LENGHT()
    {
        return FIELD_LENGHT;
    }
    /**
     * @param fIELDLENGHT the fIELD_LENGHT to set
     */
    public void setFIELD_LENGHT(BigDecimal fIELDLENGHT)
    {
        FIELD_LENGHT = fIELDLENGHT;
    }
    /**
     * @return the bRIEF_DESC_ENG
     */
    public String getBRIEF_DESC_ENG()
    {
        return BRIEF_DESC_ENG;
    }
    /**
     * @param bRIEFDESCENG the bRIEF_DESC_ENG to set
     */
    public void setBRIEF_DESC_ENG(String bRIEFDESCENG)
    {
        BRIEF_DESC_ENG = bRIEFDESCENG;
    }
    /**
     * @return the cOLUMN_NUMBER
     */
    public BigDecimal getCOLUMN_NUMBER()
    {
        return COLUMN_NUMBER;
    }
    /**
     * @param cOLUMNNUMBER the cOLUMN_NUMBER to set
     */
    public void setCOLUMN_NUMBER(BigDecimal cOLUMNNUMBER)
    {
        COLUMN_NUMBER = cOLUMNNUMBER;
    }

    /**
     * @return the lOOKUP_TYPE
     */
    public String getLOOKUP_TYPE()
    {
        return LOOKUP_TYPE;
    }
    /**
     * @param lOOKUPTYPE the lOOKUP_TYPE to set
     */
    public void setLOOKUP_TYPE(String lOOKUPTYPE)
    {
        LOOKUP_TYPE = lOOKUPTYPE;
    }
    /**
     * @return the aDD_NUM_DESC
     */
    public String getADD_NUM_DESC()
    {
        return ADD_NUM_DESC;
    }
    /**
     * @param aDDNUMDESC the aDD_NUM_DESC to set
     */
    public void setADD_NUM_DESC(String aDDNUMDESC)
    {
        ADD_NUM_DESC = aDDNUMDESC;
    }
    /**
     * @return the cODE
     */
    public BigDecimal getCODE()
    {
        return CODE;
    }
    /**
     * @param cODE the cODE to set
     */
    public void setCODE(BigDecimal cODE)
    {
        CODE = cODE;
    }
    /**
     * @return the cOMP_CODE
     */
    public BigDecimal getCOMP_CODE()
    {
        return COMP_CODE;
    }
    /**
     * @param cOMPCODE the cOMP_CODE to set
     */
    public void setCOMP_CODE(BigDecimal cOMPCODE)
    {
        COMP_CODE = cOMPCODE;
    }
    /**
     * @return the dATA_ENTRY
     */
    public String getDATA_ENTRY()
    {
        return DATA_ENTRY;
    }
    /**
     * @param dATAENTRY the dATA_ENTRY to set
     */
    public void setDATA_ENTRY(String dATAENTRY)
    {
        DATA_ENTRY = dATAENTRY;
    }
    /**
     * @return the additionalParam
     */
    public String getAdditionalParam()
    {
        return additionalParam;
    }
    /**
     * @param additionalParam the additionalParam to set
     */
    public void setAdditionalParam(String additionalParam)
    {
        this.additionalParam = additionalParam;
    }
    /**
     * @return the dependency
     */
    public String getDependency()
    {
        return dependency;
    }
    /**
     * @param dependency the dependency to set
     */
    public void setDependency(String dependency)
    {
        this.dependency = dependency;
    }
    /**
     * @return the dATE_VALIDATION
     */
    public String getDATE_VALIDATION()
    {
        return DATE_VALIDATION;
    }
    /**
     * @param dATEVALIDATION the dATE_VALIDATION to set
     */
    public void setDATE_VALIDATION(String dATEVALIDATION)
    {
        DATE_VALIDATION = dATEVALIDATION;
    }
    /**
     * @return the dATE_VALIDATION_OPERATOR
     */
    public String getDATE_VALIDATION_OPERATOR()
    {
        return DATE_VALIDATION_OPERATOR;
    }
    /**
     * @param dATEVALIDATIONOPERATOR the dATE_VALIDATION_OPERATOR to set
     */
    public void setDATE_VALIDATION_OPERATOR(String dATEVALIDATIONOPERATOR)
    {
        DATE_VALIDATION_OPERATOR = dATEVALIDATIONOPERATOR;
    }
    /**
     * @return the runningDate
     */
    @Override
    public Date getRunningDate()
    {
        return runningDate;
    }
    /**
     * @param runningDate the runningDate to set
     */
    @Override
    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }
    /**
     * @return the addDateCompareTo
     */
    public Date getAddDateCompareTo()
    {
        return addDateCompareTo;
    }
    /**
     * @param addDateCompareTo the addDateCompareTo to set
     */
    public void setAddDateCompareTo(Date addDateCompareTo)
    {
        this.addDateCompareTo = addDateCompareTo;
    }
    /**
     * @return the fIELD_FORMAT
     */
    public String getFIELD_FORMAT()
    {
        return FIELD_FORMAT;
    }
    /**
     * @param fIELDFORMAT the fIELD_FORMAT to set
     */
    public void setFIELD_FORMAT(String fIELDFORMAT)
    {
        FIELD_FORMAT = fIELDFORMAT;
    }
    /**
     * @return the dATE_LINK
     */
    public String getDATE_LINK()
    {
        return DATE_LINK;
    }
    /**
     * @param dATELINK the dATE_LINK to set
     */
    public void setDATE_LINK(String dATELINK)
    {
        DATE_LINK = dATELINK;
    }
    /**
     * @return the pARAM1_LINK
     */
    public String getPARAM1_LINK()
    {
        return PARAM1_LINK;
    }
    /**
     * @param pARAM1LINK the pARAM1_LINK to set
     */
    public void setPARAM1_LINK(String pARAM1LINK)
    {
        PARAM1_LINK = pARAM1LINK;
    }
    /**
     * @return the pARAM2_LINK
     */
    public String getPARAM2_LINK()
    {
        return PARAM2_LINK;
    }
    /**
     * @param pARAM2LINK the pARAM2_LINK to set
     */
    public void setPARAM2_LINK(String pARAM2LINK)
    {
        PARAM2_LINK = pARAM2LINK;
    }
    /**
     * @return the pARAM3_LINK
     */
    public String getPARAM3_LINK()
    {
        return PARAM3_LINK;
    }
    /**
     * @param pARAM3LINK the pARAM3_LINK to set
     */
    public void setPARAM3_LINK(String pARAM3LINK)
    {
        PARAM3_LINK = pARAM3LINK;
    }
    /**
     * @return the pARAM4_LINK
     */
    public String getPARAM4_LINK()
    {
        return PARAM4_LINK;
    }
    /**
     * @param pARAM4LINK the pARAM4_LINK to set
     */
    public void setPARAM4_LINK(String pARAM4LINK)
    {
        PARAM4_LINK = pARAM4LINK;
    }
    /**
     * @return the pARAM5_LINK
     */
    public String getPARAM5_LINK()
    {
        return PARAM5_LINK;
    }
    /**
     * @param pARAM5LINK the pARAM5_LINK to set
     */
    public void setPARAM5_LINK(String pARAM5LINK)
    {
        PARAM5_LINK = pARAM5LINK;
    }
    /**
     * @return the pARAM_VALUE1
     */
    public String getPARAM_VALUE1()
    {
        return PARAM_VALUE1;
    }
    /**
     * @param pARAMVALUE1 the pARAM_VALUE1 to set
     */
    public void setPARAM_VALUE1(String pARAMVALUE1)
    {
        PARAM_VALUE1 = pARAMVALUE1;
    }
    /**
     * @return the pARAM_VALUE2
     */
    public String getPARAM_VALUE2()
    {
        return PARAM_VALUE2;
    }
    /**
     * @param pARAMVALUE2 the pARAM_VALUE2 to set
     */
    public void setPARAM_VALUE2(String pARAMVALUE2)
    {
        PARAM_VALUE2 = pARAMVALUE2;
    }
    /**
     * @return the pARAM_VALUE3
     */
    public String getPARAM_VALUE3()
    {
        return PARAM_VALUE3;
    }
    /**
     * @param pARAMVALUE3 the pARAM_VALUE3 to set
     */
    public void setPARAM_VALUE3(String pARAMVALUE3)
    {
        PARAM_VALUE3 = pARAMVALUE3;
    }
    /**
     * @return the pARAM_VALUE4
     */
    public String getPARAM_VALUE4()
    {
        return PARAM_VALUE4;
    }
    /**
     * @param pARAMVALUE4 the pARAM_VALUE4 to set
     */
    public void setPARAM_VALUE4(String pARAMVALUE4)
    {
        PARAM_VALUE4 = pARAMVALUE4;
    }
    /**
     * @return the pARAM_VALUE5
     */
    public String getPARAM_VALUE5()
    {
        return PARAM_VALUE5;
    }
    /**
     * @param pARAMVALUE5 the pARAM_VALUE5 to set
     */
    public void setPARAM_VALUE5(String pARAMVALUE5)
    {
        PARAM_VALUE5 = pARAMVALUE5;
    }
    /**
     * @return the eNTITY
     */
    public String getENTITY()
    {
        return ENTITY;
    }
    /**
     * @param eNTITY the eNTITY to set
     */
    public void setENTITY(String eNTITY)
    {
        ENTITY = eNTITY;
    }
    /**
     * @return the addDateCompareToElemId
     */
    public String getAddDateCompareToElemId()
    {
        return addDateCompareToElemId;
    }
    /**
     * @param addDateCompareToElemId the addDateCompareToElemId to set
     */
    public void setAddDateCompareToElemId(String addDateCompareToElemId)
    {
        this.addDateCompareToElemId = addDateCompareToElemId;
    }
    /**
     * @return the addDateCompareToElemLabel
     */
    public String getAddDateCompareToElemLabel()
    {
        return addDateCompareToElemLabel;
    }
    /**
     * @param addDateCompareToElemLabel the addDateCompareToElemLabel to set
     */
    public void setAddDateCompareToElemLabel(String addDateCompareToElemLabel)
    {
        this.addDateCompareToElemLabel = addDateCompareToElemLabel;
    }
    /**
     * @return the amfDataAddFieldsVO
     */
    public AMF_DATA_ADD_FIELDSVOKey getAmfDataAddFieldsVO()
    {
        return amfDataAddFieldsVO;
    }
    /**
     * @param amfDataAddFieldsVO the amfDataAddFieldsVO to set
     */
    public void setAmfDataAddFieldsVO(AMF_DATA_ADD_FIELDSVOKey amfDataAddFieldsVO)
    {
        this.amfDataAddFieldsVO = amfDataAddFieldsVO;
    }
    /**
     * @return the cifDataAddFieldsVO
     */
    public CIF_DATA_ADD_FIELDSVOKey getCifDataAddFieldsVO()
    {
        return cifDataAddFieldsVO;
    }
    /**
     * @param cifDataAddFieldsVO the cifDataAddFieldsVO to set
     */
    public void setCifDataAddFieldsVO(CIF_DATA_ADD_FIELDSVOKey cifDataAddFieldsVO)
    {
        this.cifDataAddFieldsVO = cifDataAddFieldsVO;
    }
    /**
     * @return the aDD_NUM
     */
    public BigDecimal getADD_NUM()
    {
        return ADD_NUM;
    }
    /**
     * @param aDDNUM the aDD_NUM to set
     */
    public void setADD_NUM(BigDecimal aDDNUM)
    {
        ADD_NUM = aDDNUM;
    }
    /**
     * @return the aDD_VC
     */
    public String getADD_VC()
    {
        return ADD_VC;
    }
    /**
     * @param aDDVC the aDD_VC to set
     */
    public void setADD_VC(String aDDVC)
    {
        ADD_VC = aDDVC;
    }
    /**
     * @return the aDD_DT
     */
    public Date getADD_DT()
    {
        return ADD_DT;
    }
    /**
     * @param aDDDT the aDD_DT to set
     */
    public void setADD_DT(Date aDDDT)
    {
        ADD_DT = aDDDT;
    }
    /**
     * @return the ctstrsDataAddFieldsVO
     */
    public CTSTRS_DATA_ADD_FIELDSVOKey getCtstrsDataAddFieldsVO()
    {
        return ctstrsDataAddFieldsVO;
    }
    /**
     * @param ctstrsDataAddFieldsVO the ctstrsDataAddFieldsVO to set
     */
    public void setCtstrsDataAddFieldsVO(CTSTRS_DATA_ADD_FIELDSVOKey ctstrsDataAddFieldsVO)
    {
        this.ctstrsDataAddFieldsVO = ctstrsDataAddFieldsVO;
    }
    /**
     * @return the dESC_OUTPUT
     */
    public String getDESC_OUTPUT()
    {
        return DESC_OUTPUT;
    }
    /**
     * @param dESCOUTPUT the dESC_OUTPUT to set
     */
    public void setDESC_OUTPUT(String dESCOUTPUT)
    {
        DESC_OUTPUT = dESCOUTPUT;
    }
    /**
     * @return the numberDependency
     */
    public boolean isNumberDependency()
    {
        return numberDependency;
    }
    /**
     * @param numberDependency the numberDependency to set
     */
    public void setNumberDependency(boolean numberDependency)
    {
        this.numberDependency = numberDependency;
    }
    /**
     * @return the tABLE_NAME
     */
    public String getTABLE_NAME()
    {
        return TABLE_NAME;
    }
    /**
     * @param tABLENAME the tABLE_NAME to set
     */
    public void setTABLE_NAME(String tABLENAME)
    {
        TABLE_NAME = tABLENAME;
    }
    /**
     * @return the addField1CompareToElemId
     */
    public String getAddField1CompareToElemId()
    {
        return addField1CompareToElemId;
    }
    /**
     * @param addField1CompareToElemId the addField1CompareToElemId to set
     */
    public void setAddField1CompareToElemId(String addField1CompareToElemId)
    {
        this.addField1CompareToElemId = addField1CompareToElemId;
    }
    /**
     * @return the addField2CompareToElemId
     */
    public String getAddField2CompareToElemId()
    {
        return addField2CompareToElemId;
    }
    /**
     * @param addField2CompareToElemId the addField2CompareToElemId to set
     */
    public void setAddField2CompareToElemId(String addField2CompareToElemId)
    {
        this.addField2CompareToElemId = addField2CompareToElemId;
    }
    /**
     * @return the addField3CompareToElemId
     */
    public String getAddField3CompareToElemId()
    {
        return addField3CompareToElemId;
    }
    /**
     * @param addField3CompareToElemId the addField3CompareToElemId to set
     */
    public void setAddField3CompareToElemId(String addField3CompareToElemId)
    {
        this.addField3CompareToElemId = addField3CompareToElemId;
    }
    /**
     * @return the addField4CompareToElemId
     */
    public String getAddField4CompareToElemId()
    {
        return addField4CompareToElemId;
    }
    /**
     * @param addField4CompareToElemId the addField4CompareToElemId to set
     */
    public void setAddField4CompareToElemId(String addField4CompareToElemId)
    {
        this.addField4CompareToElemId = addField4CompareToElemId;
    }
    /**
     * @return the addField5CompareToElemId
     */
    public String getAddField5CompareToElemId()
    {
        return addField5CompareToElemId;
    }
    /**
     * @param addField5CompareToElemId the addField5CompareToElemId to set
     */
    public void setAddField5CompareToElemId(String addField5CompareToElemId)
    {
        this.addField5CompareToElemId = addField5CompareToElemId;
    }
    /**
     * @return the lookupDesc
     */
    public String getLookupDesc()
    {
        return lookupDesc;
    }
    /**
     * @param lookupDesc the lookupDesc to set
     */
    public void setLookupDesc(String lookupDesc)
    {
        this.lookupDesc = lookupDesc;
    }
    public String getRELATED_TO_DEPOSITOR_INFO()
    {
        return RELATED_TO_DEPOSITOR_INFO;
    }
    public void setRELATED_TO_DEPOSITOR_INFO(String rELATEDTODEPOSITORINFO)
    {
        RELATED_TO_DEPOSITOR_INFO = rELATEDTODEPOSITORINFO;
    }
    public String getApplyAudit()
    {
        return applyAudit;
    }
    public void setApplyAudit(String applyAudit)
    {
        this.applyAudit = applyAudit;
    }
    public String getAuditClassName()
    {
        return auditClassName;
    }
    public void setAuditClassName(String auditClassName)
    {
        this.auditClassName = auditClassName;
    }
    public String getAuditRef()
    {
        return auditRef;
    }
    public void setAuditRef(String auditRef)
    {
        this.auditRef = auditRef;
    }
    public String getAuditOpt()
    {
        return auditOpt;
    }
    public void setAuditOpt(String auditOpt)
    {
        this.auditOpt = auditOpt;
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
    public void setCif_UpdateDate(Date cifUpdateDate)
    {
        cif_UpdateDate = cifUpdateDate;
    }
    public String getLatestDateUpdated()
    {
        return LatestDateUpdated;
    }
    public void setLatestDateUpdated(String latestDateUpdated)
    {
        LatestDateUpdated = latestDateUpdated;
    }
    public List<AdditionalFieldsByTypeCO> getDynamicList()
    {
        return dynamicList;
    }
    public void setDynamicList(List<AdditionalFieldsByTypeCO> dynamicList)
    {
        this.dynamicList = dynamicList;
    }
    public CTS_ADD_FIELDSVO getCtsAddFieldVO()
    {
        return ctsAddFieldVO;
    }
    public void setCtsAddFieldVO(CTS_ADD_FIELDSVO ctsAddFieldVO)
    {
        this.ctsAddFieldVO = ctsAddFieldVO;
    }
    public String getIS_READONLY_YN()
    {
        return IS_READONLY_YN;
    }
    public void setIS_READONLY_YN(String iS_READONLY_YN)
    {
        IS_READONLY_YN = iS_READONLY_YN;
    }
    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }
    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }
    public String getFromWhere()
    {
        return fromWhere;
    }
    public void setFromWhere(String fromWhere)
    {
        this.fromWhere = fromWhere;
    }
    public CTS_ADD_FIELDS_ENTITYVOKey getCtsAddFieldEntityVO()
    {
        return ctsAddFieldEntityVO;
    }
    public void setCtsAddFieldEntityVO(CTS_ADD_FIELDS_ENTITYVOKey ctsAddFieldEntityVO)
    {
        this.ctsAddFieldEntityVO = ctsAddFieldEntityVO;
    }
    public String getADD_DR()
    {
        return ADD_DR;
    }
    public void setADD_DR(String aDD_DR)
    {
        ADD_DR = aDD_DR;
    }
    public List<CTS_ADD_FIELD_DROPDOWN_LST_DEFVO> getCtsAddFieldDrpDwnDefVOList()
    {
        return ctsAddFieldDrpDwnDefVOList;
    }
    public void setCtsAddFieldDrpDwnDefVOList(List<CTS_ADD_FIELD_DROPDOWN_LST_DEFVO> ctsAddFieldDrpDwnDefVOList)
    {
        this.ctsAddFieldDrpDwnDefVOList = ctsAddFieldDrpDwnDefVOList;
    }
  
    public BigDecimal getMIN_FIELD_LENGTH()
    {
        return MIN_FIELD_LENGTH;
    }
    public void setMIN_FIELD_LENGTH(BigDecimal mIN_FIELD_LENGTH)
    {
        MIN_FIELD_LENGTH = mIN_FIELD_LENGTH;
    }
    public CTSCARDS_DATA_ADD_FIELDSVOKey getCtsCardsDataAddFieldsVO()
    {
        return ctsCardsDataAddFieldsVO;
    }
    public void setCtsCardsDataAddFieldsVO(CTSCARDS_DATA_ADD_FIELDSVOKey ctsCardsDataAddFieldsVO)
    {
        this.ctsCardsDataAddFieldsVO = ctsCardsDataAddFieldsVO;
    }


}
