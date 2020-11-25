package com.path.actions.common.customization.button;

import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.customization.button.ButtonCustomizationBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.customization.button.SysParamActionArgListSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

public class ButtonCustomizationArgListAction extends GridBaseAction
{
   ButtonCustomizationBO buttonCustomizationBO  ;
   SysParamActionArgListSC criteria =  new SysParamActionArgListSC();
   List<SelectCO> mappingSourceList  = new ArrayList<SelectCO>();
   /**
    * retrieve the argument list grid data. and set search criteria.
    * @return
    */
    public String loadActionArgListGrid()
    {
	String[] searchCol = { "listTypeDescription","LIST_VALUE"};
	try
	{
	    if(!NumberUtil.isEmptyDecimal(criteria.getSysParamActionArgListVO().getBTN_ID()) &&
		  !NumberUtil.isEmptyDecimal(criteria.getSysParamActionArgListVO().getOP_ID()) &&
		    !NumberUtil.isEmptyDecimal(criteria.getSysParamActionArgListVO().getARG_ID()))
	    {
		/**
		 * copy the details related to search criteria to the SC
		 */
		SessionCO sessionCO = returnSessionObject();
		criteria.setLovTypeId(ButtonCustomizationConstants.LOV_TYPE_MAP_TYPE);
		criteria.setPreferredLanguage(sessionCO.getLanguage());
		criteria.setSearchCols(searchCol);
		copyproperties(criteria);
		
		/**
		 * set number of rows to be displayed in the page of grid, and
		 * the total number of records for first time load only
		 */
		
		if(checkNbRec(criteria))
		{
		    setRecords(buttonCustomizationBO.returnBtnCustActionArgListCount(criteria));
		}
		    
		List<SysParamActionArgListSC> generatedList = buttonCustomizationBO.returnBtnCustActionArgList(criteria);
		 /**
		  * set the collection into gridModel attribute defined at JSP grid
		  * tag
		 */
		setGridModel(generatedList);
	    }
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}
	return "success";
    }
    
    public Object getModel()
    {
        return criteria;
    }
    
    /**
     * load action type for arg list (for now it is only 3 = constants)
     * @return
     */
    public String loadActionTypeCombo()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_MAP_TYPE);
	    selSC.setLovCodesInlude("'3'");
	    mappingSourceList = returnLOV(selSC);
	}
	catch(BaseException e)
	{
	  handleException(e, null, null);
	}
	return "success";
    }
   

    public void setButtonCustomizationBO(ButtonCustomizationBO buttonCustomizationBO)
    {
   	this.buttonCustomizationBO = buttonCustomizationBO;
    }


    public SysParamActionArgListSC getCriteria()
    {
	return criteria;
    }


    public void setCriteria(SysParamActionArgListSC criteria)
    {
	this.criteria = criteria;
    }


    public List<SelectCO> getMappingSourceList()
    {
        return mappingSourceList;
    }


    public void setMappingSourceList(List<SelectCO> mappingSourceList)
    {
        this.mappingSourceList = mappingSourceList;
    }


}
