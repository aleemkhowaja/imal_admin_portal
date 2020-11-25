package com.path.actions.common.statuscustomization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.statuscustomization.StatusCustomizationBO;
import com.path.dbmaps.vo.OPTVO;
import com.path.dbmaps.vo.SYS_PARAM_LOV_TYPEVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.statuscustomization.StatusCustomizationCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * StatusCustomizationMaintAction.java used to
 */
public class StatusCustomizationMaintAction extends BaseAction
{
    private StatusCustomizationBO statusCustomizationBO;
    private StatusCustomizationCO statusCustomizationCO = new StatusCustomizationCO();
    private String _toolBarMode;
    private String _menuReadOnly    = "false";
    private String _lovTypeReadOnly = "false";
    private String actionType;
    @Override
    public Object getModel()
    {
        // TODO Auto-generated method stub
        return statusCustomizationCO;
    }
    public String loadStatusCustomizationPage()
    {
	try
	{
	    String statusCustAccessRight = returnAccessRightByProgRef(ConstantsCommon.SETTINGS_CONFIG_OPT);
	    if(statusCustAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }

	    SessionCO sessionCO = returnSessionObject();
	    statusCustomizationCO.setAPP_NAME(sessionCO.getCurrentAppName());
	    if(!StringUtil.nullToEmpty(get_pageRef()).isEmpty())
	    {
		statusCustomizationCO.setPROG_REF(get_pageRef());
		OPTVO optVO = new OPTVO();
		optVO.setAPP_NAME(statusCustomizationCO.getAPP_NAME());
		optVO.setPROG_REF(get_pageRef());
		OPTVO resultOpt = returnCommonLibBO().returnOptDetails(optVO);
		statusCustomizationCO.setScreenLocation(resultOpt.getPROG_DESC());
		statusCustomizationCO.setSECTION_DESC(resultOpt.getPROG_DESC());
		set_menuReadOnly("true");
	    }
	    setActionType(ConstantsCommon.ACTION_TYPE_SAVE_NEW);
	    S_APPVO s_appVO = new S_APPVO();
	    s_appVO.setAPP_NAME(sessionCO.getCurrentAppName());
	    s_appVO = returnCommonLibBO().returnApplication(s_appVO);
	    statusCustomizationCO.setAPP_DESC(s_appVO.getAPP_DESC());
	    set_searchGridId("statusCustomizationListGridTbl_Id");
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    return ERROR_ACTION;
	}
	return "statusCustomizationList";
    }

    public String initialize()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    statusCustomizationCO.setAPP_NAME(sessionCO.getCurrentAppName());
	    if(!StringUtil.nullToEmpty(get_pageRef()).isEmpty())
	    {
		statusCustomizationCO.setPROG_REF(get_pageRef());
		OPTVO optVO = new OPTVO();
		optVO.setAPP_NAME(statusCustomizationCO.getAPP_NAME());
		optVO.setPROG_REF(get_pageRef());
		OPTVO resultOpt = returnCommonLibBO().returnOptDetails(optVO);
		statusCustomizationCO.setScreenLocation(resultOpt.getPROG_DESC());
		statusCustomizationCO.setSECTION_DESC(resultOpt.getPROG_DESC());
		set_menuReadOnly("true");
	    }
	    S_APPVO s_appVO = new S_APPVO();
	    s_appVO.setAPP_NAME(sessionCO.getCurrentAppName());
	    s_appVO = returnCommonLibBO().returnApplication(s_appVO);
	    statusCustomizationCO.setAPP_DESC(s_appVO.getAPP_DESC());

	    if(getIv_crud().equals("R"))
	    {
		set_lovTypeReadOnly("false");
	    }
	    else
	    {
		set_lovTypeReadOnly("true");
		_toolBarMode = "true";
	    }
	    setActionType(ConstantsCommon.ACTION_TYPE_SAVE_NEW);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    return ERROR_ACTION;
	}
	return SUCCESS;
    }

    /**
     * prepare data, and fill the form on dbClick on a record from the grid.
     * 
     * @return
     */
    public String edit()
    {
	try
	{
	    setActionType("update");
	    statusCustomizationCO.setSelectedKey(getText("selected_key"));
	    statusCustomizationCO = statusCustomizationBO.returnStatusCustInfo(statusCustomizationCO);
	    String jsonStr = returnSerializedStrFromObj(statusCustomizationCO.getHmSts());
	    statusCustomizationCO.setSelectedStsCodes(jsonStr);
	    statusCustomizationCO.setScreenLocation(statusCustomizationCO.getSECTION_DESC());
            set_lovTypeReadOnly("true");
            set_menuReadOnly("true");
	    _toolBarMode = "false";
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public String saveNew()
    {
	try
	{
	    
	    SessionCO sessionCO = returnSessionObject();
            
	    JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(statusCustomizationCO.getSelectedStsCodes());
	    JSONArray  jsonModel  = jsonFilter.getJSONArray("root");
	    Object[]   modelArr   = jsonModel.toArray();
	    List<String> selectedCodes = new ArrayList<String>();
	    for(int i = 0; i < modelArr.length; i++)
	    {
		JSONObject currObj = (JSONObject)modelArr[i];
		HashMap<String,Object> hm = (HashMap) JSONObject.toBean(currObj, HashMap.class);
		for(Map.Entry<String, Object> e : hm.entrySet())
		{
		    selectedCodes.add((String)e.getValue()); 
		}
	    }
	    /**
	     * call the business layer ...
	     */
	    
	    statusCustomizationCO.setSelectedStsCodesList(selectedCodes);
	    statusCustomizationBO.saveNew(statusCustomizationCO);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    public String update()
    {
	try
	{
	    
	    SessionCO sessionCO = returnSessionObject();
	    
	    JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(statusCustomizationCO.getSelectedStsCodes());
	    JSONArray  jsonModel  = jsonFilter.getJSONArray("root");
	    Object[]   modelArr   = jsonModel.toArray();
	    List<String> selectedCodes = new ArrayList<String>();
	    for(int i = 0; i < modelArr.length; i++)
	    {
		JSONObject currObj = (JSONObject)modelArr[i];
		HashMap<String,Object> hm = (HashMap) JSONObject.toBean(currObj, HashMap.class);
		for(Map.Entry<String, Object> e : hm.entrySet())
		{
		    selectedCodes.add((String)e.getValue()); 
		}
	    }
	    /**
	     * call the business layer ...
	     */
	    
	    statusCustomizationCO.setSelectedStsCodesList(selectedCodes);
	    statusCustomizationBO.update(statusCustomizationCO);
	    /**
	     * call the method checkForAlert for the alert Management ...
	     */
	    statusCustomizationCO = new StatusCustomizationCO();
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    /**
     * 
     * @author marwanmaddah
     * @date   Sep 23, 2015
     * @return String
     *
     */
    public String delete()
    {
	try{
	    SessionCO sessionCO = returnSessionObject();
	    statusCustomizationBO.delete(statusCustomizationCO);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);  
	}
	return SUCCESS;
    }
    /**
     * 
     * @author marwanmaddah
     * @date   Sep 3, 2015
     * @return String
     *
     */
    public String dependencyByLovType()
    {
	try{
	    SessionCO sessionCO = returnSessionObject();
	    if(NumberUtil.isEmptyDecimal(statusCustomizationCO.getLOV_TYPE_ID()))
	    {
		statusCustomizationCO = new StatusCustomizationCO();
	    }
	    else
	    {		
		SYS_PARAM_LOV_TYPEVO sysParamLovTypeVO = statusCustomizationBO.returnLovTypeObject(statusCustomizationCO);
		statusCustomizationCO.setLOV_TYPE_ID(sysParamLovTypeVO.getLOV_TYPE_ID());
		statusCustomizationCO.setLOV_TYPE_DESCRIPTION(sysParamLovTypeVO.getLOV_TYPE_DESCRIPTION());
	    }
	}
	catch(Exception ex)
	{
	    statusCustomizationCO = new StatusCustomizationCO();
	    handleException(ex, null, null);
	}
	return "jsonSuccess";
    }
    public void setStatusCustomizationBO(StatusCustomizationBO statusCustomizationBO)
    {
	this.statusCustomizationBO = statusCustomizationBO;
    }

    /**
     * @return the statusCustomizationCO
     */
    public StatusCustomizationCO getStatusCustomizationCO()
    {
	return statusCustomizationCO;
    }

    /**
     * @param statusCustomizationCO the statusCustomizationCO to set
     */
    public void setStatusCustomizationCO(StatusCustomizationCO statusCustomizationCO)
    {
	this.statusCustomizationCO = statusCustomizationCO;
    }

    /**
     * @return the _toolBarMode
     */
    public String get_toolBarMode()
    {
	return _toolBarMode;
    }

    /**
     * @param toolBarMode the _toolBarMode to set
     */
    public void set_toolBarMode(String toolBarMode)
    {
	_toolBarMode = toolBarMode;
    }

    /**
     * @return the actionType
     */
    public String getActionType()
    {
	return actionType;
    }

    /**
     * @param actionType the actionType to set
     */
    public void setActionType(String actionType)
    {
	this.actionType = actionType;
    }
    /**
     * @return the _menuReadOnly
     */
    public String get_menuReadOnly()
    {
        return _menuReadOnly;
    }
    /**
     * @param menuReadOnly the _menuReadOnly to set
     */
    public void set_menuReadOnly(String menuReadOnly)
    {
        _menuReadOnly = menuReadOnly;
    }
    /**
     * @return the _lovTypeReadOnly
     */
    public String get_lovTypeReadOnly()
    {
        return _lovTypeReadOnly;
    }
    /**
     * @param lovTypeReadOnly the _lovTypeReadOnly to set
     */
    public void set_lovTypeReadOnly(String lovTypeReadOnly)
    {
        _lovTypeReadOnly = lovTypeReadOnly;
    }
}
