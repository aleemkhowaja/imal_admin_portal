/**
 * 
 */
package com.path.actions.common.dynamicscreen;

import java.util.List;

import com.path.bo.common.dynamicscreen.DynamicScreenBO;
import com.path.dbmaps.vo.SYS_DYN_SCREEN_DEFVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.dynamicscreen.DynamicScreenConstant;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapSC;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * DynamicScreenParamListAction.java used to
 */
public class DynamicScreenParamListAction extends GridBaseAction
{
    private DynamicScreenBO dynamicScreenBO;
    private String disableScreenLookup;
    
    private DynamicScreenParamsMapSC criteria = new DynamicScreenParamsMapSC();
    @Override
    public Object getModel()
    {
 	return criteria;
    }
    
    public String loadDynamicScreenParamMapList()
    {
	try
	{
	    if(DynamicScreenConstant.MAP_ELEMENT_TYPE.CUSTOM_BTN.equals(criteria.getMapElementType())
		    || DynamicScreenConstant.MAP_ELEMENT_TYPE.NORMAL_BTN_LINK_TO_DYN_SCREEN.equals(criteria
			    .getMapElementType())
		    || DynamicScreenConstant.MAP_ELEMENT_TYPE.DYN_BTN_LINK_TO_DYN_SCREEN.equals(criteria
			    .getMapElementType()))
	    {
		disableScreenLookup = Boolean.TRUE.toString();
	    }

	    if(!NumberUtil.isEmptyDecimal(criteria.getDefaultScreenId()))
	    {
		CommonLibSC commonLibSC = new CommonLibSC();
		commonLibSC.setScreenId(criteria.getDefaultScreenId());
		SYS_DYN_SCREEN_DEFVO  defaultScreenDefVO = dynamicScreenBO.returnScreenInfo(commonLibSC);
		if(defaultScreenDefVO != null)
		{
		    criteria.setDefaultScreenDesc(defaultScreenDefVO.getDYN_SCREEN_DESC());
		}
	    }
	}
	catch(BaseException e)
	{
	    
	}
	return "loadDynamicScreenParamMapList";
    }
    
    public String loadDyanmicScreenParamMapGrid()
    {
	String[] searchCol = { "DYN_SCREEN_ID", "DYN_SCREEN_DESC" };
	try
	{
	    /**
	     * copy the details related to search criteria to the SC
	     */
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setLovTypeId(ButtonCustomizationConstants.LOV_TYPE_MAP_TYPE);
	    criteria.setLovDynParamType(ButtonCustomizationConstants.LOV_TYPE_DYN_PARAM_TYPE);
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    criteria.setSearchCols(searchCol);
	    // Read the Original ProgRef same as applied for Lookup, since the Screen Elements added to original PRog REf
	    String theProgRef = returnCommonLibBO().returnOrginProgRef(criteria.getCurrAppName(),get_pageRef());
	    criteria.setScreenPageRef(theProgRef);
	    copyproperties(criteria);
	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(criteria))
	    {
		setRecords(dynamicScreenBO.returnDynScreenParamMapCount(criteria));
	    }

	    /**
	     * return the collection of records
	     */
	    List<DynamicScreenParamsMapCO> generatedList = dynamicScreenBO.returnDynScreenParamMap(criteria);

	    if(generatedList != null && !generatedList.isEmpty())
	    {
		for(DynamicScreenParamsMapCO dynamicScreenParamsMapCO : generatedList)
		{    
		    if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(dynamicScreenParamsMapCO
			    .getSysParamElmDynScrnMapDet().getMAP_TYPE()))
		    {
			dynamicScreenParamsMapCO.setMapValueDesc(ButtonCustomizationConstants.SESSIONCO_PROPERTIES.get(
				dynamicScreenParamsMapCO.getSysParamElmDynScrnMapDet().getMAP_VALUE()).getDescription());
		    }
		    else if(ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(dynamicScreenParamsMapCO
			    .getSysParamElmDynScrnMapDet().getMAP_TYPE()) && StringUtil.isNotEmpty(dynamicScreenParamsMapCO.getMapValueDesc()))
		    {
			dynamicScreenParamsMapCO.setMapValueDesc(getText(dynamicScreenParamsMapCO.getMapValueDesc()));
		    }
		    else if(ButtonCustomizationConstants.MAP_TYPE.CONSTANT.equals(dynamicScreenParamsMapCO
			    .getSysParamElmDynScrnMapDet().getMAP_TYPE()))
		    {
			dynamicScreenParamsMapCO.getSysParamElmDynScrnMapDet().setMAP_VALUE(null);
		    }
			
		}
	    }
	    
	    /**
	     * set the collection into gridModel attribute defined at JSP grid
	     * tag
	     */
	    setGridModel(generatedList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadDyanmicScreenParamMapGrid");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public void setDynamicScreenBO(DynamicScreenBO dynamicScreenBO)
    {
        this.dynamicScreenBO = dynamicScreenBO;
    }

    public DynamicScreenParamsMapSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(DynamicScreenParamsMapSC criteria)
    {
        this.criteria = criteria;
    }

    /**
     * @return the disableScreenLookup
     */
    public String getDisableScreenLookup()
    {
        return disableScreenLookup;
    }

    /**
     * @param disableScreenLookup the disableScreenLookup to set
     */
    public void setDisableScreenLookup(String disableScreenLookup)
    {
        this.disableScreenLookup = disableScreenLookup;
    }
    
}
