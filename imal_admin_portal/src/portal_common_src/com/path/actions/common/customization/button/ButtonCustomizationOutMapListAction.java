package com.path.actions.common.customization.button;

import java.util.List;

import com.path.bo.common.customization.button.ButtonCustomizationBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.customization.button.SysParamBtnCustOutMapSC;

public class ButtonCustomizationOutMapListAction extends GridBaseAction
{
   ButtonCustomizationBO buttonCustomizationBO  ;
   SysParamBtnCustOutMapSC criteria =  new SysParamBtnCustOutMapSC();
   
   /**
    * retrieve output map grid data.
    * @return
    */
    public String loadOutputMapGrid()
    {
	String[] searchCol = { "MAP_KEY","OP_ID","ARG_ID","operationDescription","argDescription"};
	try
	{
	    if(!NumberUtil.isEmptyDecimal(criteria.getSysParamBtnCustOutMap().getBTN_ID()))
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
		    setRecords(buttonCustomizationBO.returnBtnCustOutMapCount(criteria));
		}
		    
		List<SysParamBtnCustOutMapSC> generatedList = buttonCustomizationBO.returnBtnCustOutMap(criteria);
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
   
    public void setButtonCustomizationBO(ButtonCustomizationBO buttonCustomizationBO)
    {
        this.buttonCustomizationBO = buttonCustomizationBO;
    }



    public SysParamBtnCustOutMapSC getCriteria()
    {
        return criteria;
    }


    public void setCriteria(SysParamBtnCustOutMapSC criteria)
    {
        this.criteria = criteria;
    } 
   
   
}
