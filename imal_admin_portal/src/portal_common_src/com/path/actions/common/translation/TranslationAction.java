package com.path.actions.common.translation;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.translation.TranslationBO;
import com.path.bo.common.translation.TranslationConstants;
import com.path.dbmaps.vo.SYS_PARAM_KEY_GROUP_TRANSVO;
import com.path.dbmaps.vo.SYS_PARAM_KEY_LABEL_TRANSVO;
import com.path.dbmaps.vo.SYS_PARAM_LANGUAGESVO;
import com.path.dbmaps.vo.SYS_PARAM_LOV_TYPEVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.StringUtil;
import com.path.lib.common.util.UnicodeUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.translation.TransUpdateCO;
import com.path.vo.common.translation.TranslationCO;
import com.path.vo.common.translation.TranslationSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: rabihelkhatib
 * 
 *          TranslationAction.java used to implement the Action methods of the
 *          translation screen
 */
@SuppressWarnings("serial")
public class TranslationAction extends GridBaseAction
{
    private TranslationBO translationBO;
    private TranslationSC translationSC = new TranslationSC();
    private TranslationCO translationCO = new TranslationCO();
    private List<SelectCO> langSelect =  new ArrayList<SelectCO>();
    private InputStream scriptStream;
    private File file;
    private String lovAccessRight;

    @Override
    public Object getModel()
    {
	return translationSC;
    }

    /***
     * Method for Loading the Translation Screen
     * 
     * @return String
     */
    public String loadTransScreen()
    {
	try
	{
	    String labelingAccessRight = returnAccessRightByProgRef(ConstantsCommon.LABELING_CONFIG_OPT);
	    if(labelingAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }

	   setLovAccessRight(checkLOVAccess());
	   loadExportLables();
	   exportDisplayManagement();
	   set_pageRef(ConstantsCommon.LABELING_CONFIG_OPT);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}

	return SUCCESS;
    }

    /**
     * Method for Loading the new Key Label Screen
     * 
     * @return String
     */
    public String newKeyLabelScreen()
    {
	return "newKeyLabel";
    }

    /**
     * Method for Loading the new Key Group Screen
     * 
     * @return String
     */
    public String newKeyGroupScreen()
    {
	return "newKeyGroup";
    }

    /**
     * Method for Loading the Import / Export tab Screen
     * 
     * @return String
     */
    public String loadImpExp()
    {
	try
	{
	    loadExportLables();
	    exportDisplayManagement();
	    translationSC.setGlobalRef(true);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "loadImpExp";
    }
    /**
     * Method for Loading the Types list tab Screen
     * 
     * @return String
     */
    public String loadLOVTypeList()
    {
	try
	{
	    translationSC.setGlobalRef(true);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "loadLOVTypeList";
    }
    /**
     * to manage the default display management in Export Screen 
     * @author marwanmaddah
     * @date   Jul 22, 2014 void
     *
     */
    private void exportDisplayManagement()
    {
	try
	{
	    SYS_PARAM_SCREEN_DISPLAYVO sysParam     = new SYS_PARAM_SCREEN_DISPLAYVO();
	    SYS_PARAM_SCREEN_DISPLAYVO sysParamDesc = new SYS_PARAM_SCREEN_DISPLAYVO();
	    
	    sysParam.setIS_VISIBLE(BigDecimal.ZERO);
	    sysParam.setIS_MANDATORY(BigDecimal.ZERO);
	    
	    sysParamDesc.setIS_VISIBLE(BigDecimal.ZERO);
	    sysParamDesc.setIS_MANDATORY(BigDecimal.ZERO);
	    sysParamDesc.setIS_READONLY(BigDecimal.ONE);
	    
	    getAdditionalScreenParams().put("translationCO.sysParamKeyLabelVO.PROG_REF", sysParam);
	    getAdditionalScreenParams().put("Labeling_PROG_DESC", sysParamDesc);
	    getAdditionalScreenParams().put("translationCO.sysParamKeyLabelVO.KEY_LABEL_CODE", sysParam);
	    getAdditionalScreenParams().put("labeling_KEY_LABEL_DESC", sysParamDesc);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);  
	}
    }
    /***
     * Method for populating the Key label details grid
     * 
     * @return String
     */
    public String loadLabelDetailsGrid()
    {
	try
	{
	    String[] searchCols = { "APP_NAME", "PROG_REF", "progRefDesc", "KEY_LABEL_CODE", "KEY_LABEL_DESC",
		    "KEY_GROUP_ID", "KEY_GROUP_DESC", "prefTrans" };
	    SessionCO sessionObject = returnSessionObject();
	    // for Reporting Application all Applications labels need to be displayed
	    String currApp = sessionObject.getCurrentAppName();
	    if(ConstantsCommon.REP_APP_NAME.equals(currApp) || ConstantsCommon.IBIS_APP_NAME.equals(currApp))
	    {
		translationSC.setSelectedApp(TranslationConstants.ALL_APPS_SELECTION);
	    }
	    translationSC.setAppName(StringUtil.nullEmptyToValue(translationSC.getAppName(), currApp));
	    translationSC.setSearchCols(searchCols);
	    translationSC.setPreferredLanguage(sessionObject.getLanguage());
	    translationSC.setRootDesc(StringUtil.nullEmptyToValue(getText("ROOT_KEY"), "ROOT"));

	    copyproperties(translationSC);
	    if(checkNbRec(translationSC))
	    {
		setRecords(translationBO.selectLabelListCount(translationSC));
	    }
	    ArrayList<TranslationCO> translationCOList = translationBO
		    .selectLabelList(translationSC);
	    setGridModel(translationCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    /***
     * Method for populating the LOV details grid
     * 
     * @return String
     */
    public String loadLOVTypesGrid()
    {
	try
	{
	    String[] searchCols = { "LOV_TYPE_ID", "LOV_TYPE_DESCRIPTION"};
	    SessionCO sessionObject = returnSessionObject();
	    translationSC.setSearchCols(searchCols);
	    translationSC.setPreferredLanguage(sessionObject.getLanguage());

	    copyproperties(translationSC);
	    if(checkNbRec(translationSC))
	    {
		setRecords(translationBO.selectLOVListCount(translationSC));
	    }
	    ArrayList<SYS_PARAM_LOV_TYPEVO> translationLOVList = translationBO
		    .selectLOVList(translationSC);
	    setGridModel(translationLOVList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    /***
     * Method for populating the Key label translation grid
     * 
     * @return String
     */
    public String loadLabelTranslationGrid()
    {
	try
	{

	    String[] searchCols = { "LANG_CODE", "VALUE_TRANS", "langDesc" };
	    SessionCO sessionObject = returnSessionObject();
	    translationSC.setLangCode(sessionObject.getLanguage());
	    translationSC.setSearchCols(searchCols);
	    copyproperties(translationSC);
	    if(checkNbRec(translationSC))
	    {
		setRecords(translationBO.selectLabelTransListCount(translationSC));
	    }
	    ArrayList<TranslationCO> translationCOList = translationBO
		    .selectLabelTransList(translationSC);
	    setGridModel(translationCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    /***
     * Method for populating the LOV translation grid
     * 
     * @return String
     */
    public String loadLOVTranslationGrid()
    {
	try
	{

	    String[] searchCols = { "LANG_CODE", "VALUE_DESC", "langDesc" };
	    SessionCO sessionObject = returnSessionObject();
	    translationSC.setLangCode(sessionObject.getLanguage());
	    translationSC.setSearchCols(searchCols);
	    copyproperties(translationSC);
	    if(checkNbRec(translationSC))
	    {
		setRecords(translationBO.selectLOVTransListCount(translationSC));
	    }
	    ArrayList<TranslationCO> translationCOList = translationBO
		    .selectLOVTransList(translationSC);
	    setGridModel(translationCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    /***
     * Method for populating the Group details grid
     * 
     * @return String
     */
    public String loadGroupDetailsGrid()
    {
	try
	{
	    String[] searchCols = { "KEY_GROUP_ID", "KEY_GROUP_DESC", "prefTrans" };
	    SessionCO sessionObject = returnSessionObject();
	    translationSC.setPreferredLanguage(sessionObject.getLanguage());
	    translationSC.setSearchCols(searchCols);
	    copyproperties(translationSC);
	    if(checkNbRec(translationSC))
	    {
		setRecords(translationBO.selectGroupListCount(translationSC));
	    }
	    ArrayList<TranslationCO> translationCOList = translationBO
		    .selectGroupList(translationSC);
	    setGridModel(translationCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    /***
     * Method for populating the Group translation grid
     * 
     * @return String
     */
    public String loadGroupTranslationGrid()
    {
	try
	{

	    String[] searchCols = { "LANG_CODE", "VALUE_TRANS", "langDesc" };
	    SessionCO sessionObject = returnSessionObject();
	    translationSC.setPreferredLanguage(sessionObject.getLanguage());
	    translationSC.setSearchCols(searchCols);
	    copyproperties(translationSC);
	    if(checkNbRec(translationSC))
	    {
		setRecords(translationBO.selectGroupTransListCount(translationSC));
	    }
	    ArrayList<TranslationCO> translationCOList = translationBO
		    .selectGroupTransList(translationSC);
	    setGridModel(translationCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    
    /***
     * Method for populating the Group Dependent labels grid
     * 
     * @return String
     */
    public String loadGroupDependentGrid()
    {
	return "loadGrpDep";
    }
    
    /***
     * Method for populating the Groups details grid for Labels dependent
     * 
     * @return String
     */
    public String loadGroupDependentGridData()
    {
	try
	{
	    String[] searchCols = { "APP_NAME", "PROG_REF", "progRefDesc", "KEY_LABEL_CODE", "KEY_LABEL_DESC",
		    "KEY_GROUP_ID", "KEY_GROUP_DESC", "prefTrans" };
	    SessionCO sessionObject = returnSessionObject();
	    translationSC.setAppName(StringUtil.nullEmptyToValue(translationSC.getAppName(), sessionObject
		    .getCurrentAppName()));
	    translationSC.setSearchCols(searchCols);
	    translationSC.setPreferredLanguage(sessionObject.getLanguage());
	    translationSC.setRootDesc(StringUtil.nullEmptyToValue(getText("ROOT_KEY"), "ROOT"));

	    copyproperties(translationSC);
	    if(checkNbRec(translationSC))
	    {
		setRecords(translationBO.returnGrpDependentListCount(translationSC));
	    }
	    ArrayList<TranslationCO> translationCOList = translationBO
		    .returnGrpDependentList(translationSC);
	    setGridModel(translationCOList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    public String returnGrpDependent()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    translationSC.setAppName(StringUtil.nullEmptyToValue(translationSC.getAppName(), sessionObject
		    .getCurrentAppName()));
	    translationSC.setPreferredLanguage(sessionObject.getLanguage());
	    translationSC.setRootDesc(StringUtil.nullEmptyToValue(getText("ROOT_KEY"), "ROOT"));
	    translationSC.setTransDeps(translationBO.returnGrpDependent(translationSC));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    

    /***
     * Method for deleting the Group Keys
     * 
     * @return String
     */
    public String deleteKeyGroup()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(translationSC.getKeyGroupID()))
	    {
		translationCO.getSysParamKeyGroupVO().setKEY_GROUP_ID(translationSC.getKeyGroupID());
		translationBO.deleteKeyGroup(translationCO);
	    }
	    if(!StringUtil.isNotEmpty(translationSC.getPreferredLanguage()))
	    {
		SessionCO sessionObject = returnSessionObject();
		translationSC.setPreferredLanguage(sessionObject.getLanguage());
	    }
	    TranslationConstants.clearTransCash(translationSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    /***
     * Method for deleting the Label Keys
     * 
     * @return String
     */
    public String deleteKeyLabel()
    {
	try
	{
	    if(StringUtil.isNotEmpty(translationSC.getAppName()) && StringUtil.isNotEmpty(translationSC.getPageRef())
		    && StringUtil.isNotEmpty(translationSC.getKeyLabelCode()))
	    {
		String keyLblID = translationSC.getKeyLabelCode();

		translationCO.getSysParamKeyLabelVO().setAPP_NAME(translationSC.getAppName());
		translationCO.getSysParamKeyLabelVO().setPROG_REF(translationSC.getPageRef());
		translationCO.getSysParamKeyLabelVO().setKEY_LABEL_CODE(keyLblID);
		translationBO.deleteKeyLabel(translationCO);
	    }
	    if(!StringUtil.isNotEmpty(translationSC.getPreferredLanguage()))
	    {
		SessionCO sessionObject = returnSessionObject();
		translationSC.setPreferredLanguage(sessionObject.getLanguage());
	    }
	    TranslationConstants.clearTransCash(translationSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    /***
     * Method for saving the new Label Key
     * 
     * @return String
     */
    public String saveNewKeyLabel()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    if(translationSC.getGlobalRef())
	    {
		translationSC.setAppName(ConstantsCommon.IMAL_APP_NAME);
	    }
	    else
	    {	
		translationSC.setAppName(StringUtil.nullEmptyToValue(translationCO.getSysParamKeyLabelVO().getAPP_NAME(), sessionObject
			.getCurrentAppName()));
	    }
	    translationCO.getSysParamKeyLabelVO().setAPP_NAME(translationSC.getAppName());
	    translationSC.setPageRef(translationCO.getSysParamKeyLabelVO().getPROG_REF());
	    translationSC.setKeyLabelCode(translationCO.getSysParamKeyLabelVO().getKEY_LABEL_CODE());
	    translationSC.setPreferredLanguage(sessionObject.getLanguage());
	    translationSC.setRootDesc(StringUtil.nullEmptyToValue(getText("ROOT_KEY"), "ROOT"));
	    translationBO.saveNewKeyLabel(translationCO, translationSC);
	    copyproperties(translationSC);
	    NumberUtil.resetEmptyValues(translationCO);
	    NumberUtil.resetEmptyValues(translationSC);
	    TranslationConstants.clearTransCash(translationSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    /***
     * Method for saving the new Group Key
     * 
     * @return String
     */
    public String saveNewKeyGroup()
    {
	try
	{
	    int grpID;
	    grpID = translationBO.saveNewKeyGroup(translationCO);
	    translationCO.getSysParamKeyGroupVO().setKEY_GROUP_ID(new BigDecimal(grpID));
	    NumberUtil.resetEmptyValues(translationCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    /**
     * Method to save the group Translation
     * 
     * @return String
     */
    @SuppressWarnings("unchecked")
    public String saveGroupTrans()
    {
	try
	{
	    SYS_PARAM_KEY_GROUP_TRANSVO transVO;
	    TranslationCO transCO;
	    String transUpdate = StringUtil.nullToEmpty(translationSC.getTransUpdate());
	    ArrayList<TranslationCO> lstAdd = null, lstMod = null, lstDel = null;
	    if(!transUpdate.isEmpty())
	    {
		TransUpdateCO transUpdateCO = new TransUpdateCO();
		GridUpdates gu = getGridUpdates(transUpdate, TranslationCO.class);
		lstAdd = gu.getLstAdd();
		for(int i = 0; lstAdd.size() > i; i++)
		{
		    transCO = lstAdd.get(i);
		    transVO = lstAdd.get(i).getSysParamKeyGroupTransVO();
		    transVO.setKEY_GROUP_ID(translationSC.getKeyGroupID());
		    transVO.setVALUE_TRANS(transCO.getLblValueTrans());
		}
		transUpdateCO.setAddSysParamKeyGroupTransVO(lstAdd);
		lstMod = gu.getLstModify();
		transUpdateCO.setModSysParamKeyGroupTransVO(lstMod);
		lstDel = gu.getLstDelete();
		transUpdateCO.setDelSysParamKeyGroupTransVO(lstDel);
		translationBO.saveGroupTrans(transUpdateCO);
	    }

	    SessionCO sessionObject = returnSessionObject();
	    translationSC.setPreferredLanguage(sessionObject.getLanguage());

	    transCO = translationBO.checkGroupByIDDep(translationSC);

	    if(transCO != null)
	    {
		if(StringUtil.isNotEmpty(transCO.getPrefTrans()))
		{
		    translationCO.setPrefTrans(transCO.getPrefTrans());
		}
		else
		{
		    translationCO.setPrefTrans(translationCO.getSysParamKeyGroupVO().getKEY_GROUP_DESC());
		}
	    }
	    TranslationConstants.clearTransCash(translationSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    /**
     * Method to save the label Translation
     * 
     * @return String
     */
    @SuppressWarnings("unchecked")
    public String saveLabelTrans()
    {
	try
	{
	    SYS_PARAM_KEY_LABEL_TRANSVO transVO;
	    TranslationCO transCO = new TranslationCO();
	    String transUpdate = StringUtil.nullToEmpty(translationSC.getTransUpdate());
	    ArrayList lstAdd = null, lstMod = null, lstDel = null;
	    if(!transUpdate.isEmpty())
	    {
		TransUpdateCO transUpdateCO = new TransUpdateCO();
		GridUpdates gu = getGridUpdates(transUpdate, TranslationCO.class);
		lstAdd = gu.getLstAdd();
		for(int i = 0; lstAdd.size() > i; i++)
		{
		    transCO = (TranslationCO) lstAdd.get(i);
		    transVO = ((TranslationCO) lstAdd.get(i)).getSysParamKeyLabelTransVO();
		    transVO.setAPP_NAME(translationSC.getAppName());
		    transVO.setPROG_REF(translationSC.getPageRef());
		    transVO.setKEY_LABEL_CODE(translationSC.getKeyLabelCode());
		    transVO.setVALUE_TRANS(transCO.getLblValueTrans());
		}
		transUpdateCO.setAddSysParamKeyLabelTransVO(lstAdd);
		lstMod = gu.getLstModify();
		transUpdateCO.setModSysParamKeyLabelTransVO(lstMod);
		lstDel = gu.getLstDelete();
		transUpdateCO.setDelSysParamKeyLabelTransVO(lstDel);
		translationBO.saveLabelTrans(transUpdateCO);
	    }

	    SessionCO sessionObject = returnSessionObject();
	    translationSC.setPreferredLanguage(sessionObject.getLanguage());
	    if(StringUtil.isNotEmpty(translationSC.getAppName()))
	    {
		transCO = translationBO.returnLabelTrans(translationSC);
	    }

	    if(transCO == null)
	    {
		translationCO.setPrefTrans(translationCO.getSysParamKeyLabelVO().getKEY_LABEL_DESC());
	    }
	    else
	    {
		if(StringUtil.isNotEmpty(transCO.getLblValueTrans()))
		{
		    translationCO.setPrefTrans(transCO.getLblValueTrans());
		}
	    }
	    TranslationConstants.clearTransCash(translationSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
    

    /**
     * Method to save the LOV Translation
     * 
     * @return String
     */
    @SuppressWarnings("unchecked")
    public String saveLOVTrans()
    {
	try
	{
	    String transUpdate = StringUtil.nullToEmpty(translationSC.getTransUpdate());
	    ArrayList lstMod = null;
	    if(!transUpdate.isEmpty())
	    {
		TransUpdateCO transUpdateCO = new TransUpdateCO();
		GridUpdates gu = getGridUpdates(transUpdate, TranslationCO.class);
		lstMod = gu.getLstModify();
		transUpdateCO.setModSysParamLOVTransVO(lstMod);
		translationBO.saveLOVTrans(transUpdateCO);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    

    /**
     * Method to delete the group Translation
     * 
     * @return String
     */
    public String deleteGroupTrans()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(translationSC.getKeyGroupID())
		    && StringUtil.isNotEmpty(translationSC.getLangCode()))
	    {
		translationCO.getSysParamKeyGroupTransVO().setKEY_GROUP_ID(translationSC.getKeyGroupID());
		translationCO.getSysParamKeyGroupTransVO().setLANG_CODE(translationSC.getLangCode());
		translationBO.deleteGroupTrans(translationCO);
	    }
	    if(!StringUtil.isNotEmpty(translationSC.getPreferredLanguage()))
	    {
		SessionCO sessionObject = returnSessionObject();
		translationSC.setPreferredLanguage(sessionObject.getLanguage());
	    }
	    TranslationConstants.clearTransCash(translationSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    /**
     * Method to delete the label Translation
     * 
     * @return String
     */
    public String deleteLabelTrans()
    {
	try
	{
	    if(StringUtil.isNotEmpty(translationSC.getAppName()) && StringUtil.isNotEmpty(translationSC.getPageRef())
		    && StringUtil.isNotEmpty(translationSC.getKeyLabelCode())
		    && StringUtil.isNotEmpty(translationSC.getLangCode()))
	    {
		translationCO.getSysParamKeyLabelTransVO().setAPP_NAME(translationSC.getAppName());
		translationCO.getSysParamKeyLabelTransVO().setPROG_REF(translationSC.getPageRef());
		translationCO.getSysParamKeyLabelTransVO().setKEY_LABEL_CODE(translationSC.getKeyLabelCode());
		translationCO.getSysParamKeyLabelTransVO().setLANG_CODE(translationSC.getLangCode());
		translationBO.deleteLabelTrans(translationCO);
	    }
	    if(!StringUtil.isNotEmpty(translationSC.getPreferredLanguage()))
	    {
		SessionCO sessionObject = returnSessionObject();
		translationSC.setPreferredLanguage(sessionObject.getLanguage());
	    }
	    TranslationConstants.clearTransCash(translationSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }

    private void loadExportLables() throws BaseException
    {
	    SelectSC sc = new SelectSC();
	    SelectCO sco;
	    sc.setLovTypeId(ConstantsCommon.LANGUAGES_LOV_TYPE);
	    sc.setLanguage(returnSessionObject().getLanguage());
	    List<SYS_PARAM_LANGUAGESVO> languageVO = returnCommonLibBO().returnLanguages(sc);
	   
	    int langSize = languageVO.size();
	    for(int i = 0; i < langSize;  i++)
	    {
		sco = new SelectCO();
		sco.setCode(languageVO.get(i).getLANG_CODE());
		sco.setDescValue(languageVO.get(i).getLANG_NAME());
		langSelect.add(i,sco);
	    }
    }
/**
 * Method to export the selected labels into  file
 * @return String
 */
    public String exportLabelsFile()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    translationSC.setAppName(StringUtil.nullEmptyToValue(translationSC.getAppName(), sessionObject
		    .getCurrentAppName()));
	    
	    // languages list to export
	    String strLang = translationSC.getPreferredLanguage().replace(" ", "");
	    strLang = strLang.replace(",", "','");
	    strLang = ("'".concat(strLang)).concat("'");
	    translationSC.setPreferredLanguage(strLang);
	    StringBuffer scriptBuff = translationBO.returnLblExp(translationSC);
	    byte[] scriptByte = scriptBuff.toString().getBytes(FileUtil.DEFAULT_FILE_ENCODING);
	    scriptByte = UnicodeUtil.addBOMToBytes(scriptByte, FileUtil.DEFAULT_FILE_ENCODING);
	    scriptStream = new ByteArrayInputStream(scriptByte);
	    ServletActionContext.getResponse().setHeader("Set-Cookie", "fileDownload=true; path=/");
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		setScriptStream(new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING)));
	    }
	    catch(UnsupportedEncodingException e1)
	    {
		log.error(e1, "Error in reading the error message");
	    }
	    return "fileError";
	}
	return "saveScript";
    }
    /**
     * Method to return details about specific key in reference database
     * @return
     */
    public String checkReferenceDBDetails()
    {
	try
	{
	    translationBO.checkReferenceDBDetails(translationSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    /**
     * Method to send details about specific key into reference database
     * method used during development and QA and not at client side.
     * @return
     */
    public String pushTransToRefDB()
    {
	try
	{
	    translationBO.sendReferenceDBDetails(translationSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    
/**
 * Method to get the user selected CSV file and send it as byte[] to the BO class
 * @return String
 */
    public String importLabelsFile()
    {
	try
	{
	    //limit the size of the translation file to be below of 200 MB = 200000000 bytes 
	    byte[] fileBytes = PathFileSecure.readFileToByteArray(file,200000000);
	    translationCO.setImportedBytes(fileBytes);
	    translationCO = translationBO.importLabels(translationCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "fileSuccess";
    }
    
    protected String checkLOVAccess()
    {
	try
	{
		return returnAccessRightByProgRef(ConstantsCommon.LOV_TRANSLATION_TAB);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return null;
    }

    public void setTranslationBO(TranslationBO translationBO)
    {
	this.translationBO = translationBO;
    }

    public TranslationSC getTranslationSC()
    {
	return translationSC;
    }

    public void setTranslationSC(TranslationSC translationSC)
    {
	this.translationSC = translationSC;
    }

    public TranslationCO getTranslationCO()
    {
	return translationCO;
    }

    public void setTranslationCO(TranslationCO translationCO)
    {
	this.translationCO = translationCO;
    }

    public void setLangSelect(List<SelectCO> langSelect)
    {
	this.langSelect = langSelect;
    }

    public List<SelectCO> getLangSelect()
    {
	return langSelect;
    }

    public void setScriptStream(InputStream scriptStream)
    {
	this.scriptStream = scriptStream;
    }

    public InputStream getScriptStream()
    {
	return scriptStream;
    }

    public void setUpload(File file)
    {
	this.file = file;
    }

    public String getLovAccessRight()
    {
        return lovAccessRight;
    }

    public void setLovAccessRight(String lovAccessRight)
    {
        this.lovAccessRight = lovAccessRight;
    }
}
