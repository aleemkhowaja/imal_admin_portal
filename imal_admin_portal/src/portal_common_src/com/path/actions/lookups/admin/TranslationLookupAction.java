/**
 * 
 */
package com.path.actions.lookups.admin;

import java.util.List;

import net.sf.json.JSONException;

import com.path.bo.common.CommonLibBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.translation.TranslationBO;
import com.path.dbmaps.vo.OPTVO;
import com.path.dbmaps.vo.SYS_PARAM_LANGUAGESVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.translation.TranslationSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: rabihelkhatib
 * 
 *          TranslationLookupAction.java used to generate the Translation Screen
 *          Lookups
 */
public class TranslationLookupAction extends LookupBaseAction
{

    private TranslationBO translationBO;
    private TranslationSC translationSC = new TranslationSC();
    private List<?> locationList;

    @Override
    public Object getModel()
    {
	return translationSC;
    }

    /**
     * Group ID lookup
     * 
     * @return
     */
    public String groupLookup()
    {
	try
	{
	    String[] name = { "sysParamKeyGroupVO.KEY_GROUP_ID", "sysParamKeyGroupVO.KEY_GROUP_DESC", "prefTrans" };
	    String[] colType = { "number", "text", "text" };
	    String[] titles = { getText("Group_ID_key"), getText("Group_Description_key"), getText("curr_language_trans_key")};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption("");
	    grid.setRowNum("5");

	    grid.setUrl("/pathdesktop/TranslationLookup_fillGroupLookup");
	    lookup(grid, translationSC, name, colType, titles);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillGroupLookup() throws BaseException
    {
	try
	{
	    setSearchFilter(translationSC);
	    copyproperties(translationSC);
	    SessionCO sessionCO = returnSessionObject();
	    translationSC.setPreferredLanguage(sessionCO.getLanguage());

	    if(checkNbRec(translationSC))
	    {
		setRecords(translationBO.selectGroupListCount(translationSC));
	    }
	    locationList = translationBO.selectGroupList(translationSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(locationList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String pageRefLookup()
    {
	try
	{
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("code_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/TranslationLookup_fillPageRefLookup");
	    
	    String[] name = { "PROG_REF","PROG_DESC","parent" };
	    String[] colType = { "text","text","text" };
	    String[] titles = { getText("prog_ref_key"), getText("prog_ref_desc_key"), getText("prog_ref_parent_desc_key") };
	    lookup(grid, translationSC, name, colType, titles);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /**
     * Fill the lookup PageRef data filtered by the defined criteria
     * 
     * @return
     * @throws JSONException
     */
    public String fillPageRefLookup()
    {
	try
	{
	    String[] searchCols = new String[] { "PROG_REF", "PROG_DESC", "parent" };
	    SessionCO sessionCO = returnSessionObject();
	    if((ConstantsCommon.EXPORT_SPECIFIC_APP.equals(translationSC.getSelectedApp()))
		    || ((ConstantsCommon.IBIS_APP_NAME.equals(sessionCO.getCurrentAppName()) || ConstantsCommon.REP_APP_NAME
			    .equals(sessionCO.getCurrentAppName())) && StringUtil
			    .isNotEmpty(translationSC.getAppName())))
	    {
		translationSC.setAppName(translationSC.getAppName());
	    }
	    else
	    {
		translationSC.setAppName(sessionCO.getCurrentAppName());
	    }

	    translationSC.setPreferredLanguage(sessionCO.getLanguage());
	    translationSC.setSearchCols(searchCols);
	    setSearchFilter(translationSC);
	    copyproperties(translationSC);
	    if(getRecords() == 0)
	    {
		setRecords(translationBO.transPageRefListCount(translationSC));
	    }
	    List<OPTVO> locationList = translationBO.transPageRefList(translationSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(locationList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    /**
     * 
     * @author marwanmaddah
     * @date   Jul 21, 2014
     * @return String
     *
     */
    public String labelKeyLookup()
    {
	try
	{
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("code_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/TranslationLookup_fillLabelKeyLookup");
	    
	    String[] name = { "sysParamKeyLabelVO.KEY_LABEL_CODE","sysParamKeyLabelVO.KEY_LABEL_DESC"};
	    String[] colType = { "text","text"};
	    String[] titles = { getText("label_key"),getText("lbl_desc_key")};
	    lookup(grid, translationSC, name, colType, titles);
	    
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    /**
     * Fill the lookup label Key data filtered by the defined criteria
     * @author marwanmaddah
     * @date   Jul 21, 2014
     * @return String
     *
     */
    public String fillLabelKeyLookup()
    {
	try
	{
	    String[] searchCols = new String[] { "sysParamKeyLabelVO.KEY_LABEL_CODE","sysParamKeyLabelVO.KEY_LABEL_DESC"};
	    SessionCO sessionCO = returnSessionObject();
	    
	    if(ConstantsCommon.EXPORT_SPECIFIC_APP.equals(translationSC.getSelectedApp()))
	    {
		translationSC.setAppName(translationSC.getAppName());
	    }
	    else
	    {
		translationSC.setAppName(sessionCO.getCurrentAppName());
	    }

	    translationSC.setPreferredLanguage(sessionCO.getLanguage());
	    translationSC.setSearchCols(searchCols);
	    setSearchFilter(translationSC);
	    copyproperties(translationSC);
	    if(getRecords() == 0)
	    {
		setRecords(translationBO.transLabelKeyListCount(translationSC));
	    }
	    List<OPTVO> locationList = translationBO.transLabelKeyList(translationSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(locationList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    public String langDescLookup()
    {
	try
	{
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("code_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/TranslationLookup_fillLangDescLookup");

	    String[] name = { "code","descValue" };
	    String[] colType = { "text","text" };
	    String[] titles = { getText("language_code_key"), getText("language_desc_key") };
	    lookup(grid, translationSC, name, colType, titles);


	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /**
     * Fill the lookup PageRef data filtered by the defined criteria
     * 
     * @return
     * @throws JSONException
     */
    public String fillLangDescLookup()
    {
	try
	{
	    String[] searchCols = new String[] { "code", "descValue" };
	    translationSC.setSearchCols(searchCols);
	    CommonLibBO commonLibBO = returnCommonLibBO();
	    SelectSC sc = new SelectSC();
	    sc.setLovTypeId(ConstantsCommon.LANGUAGES_LOV_TYPE);
	    sc.setLanguage(returnSessionObject().getLanguage());
	    List<SYS_PARAM_LANGUAGESVO> locationList = commonLibBO.returnLanguages(sc);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(locationList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public TranslationSC getTranslationSC()
    {
	return translationSC;
    }

    public void setTranslationSC(TranslationSC translationSC)
    {
	this.translationSC = translationSC;
    }

    public List<?> getLocationList()
    {
	return locationList;
    }

    public void setLocationList(List<?> locationList)
    {
	this.locationList = locationList;
    }

    public void setTranslationBO(TranslationBO translationBO)
    {
	this.translationBO = translationBO;
    }

}
