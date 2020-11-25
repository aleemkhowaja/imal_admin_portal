/**
 * 
 */
package com.path.actions.common.screengenerator;

import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;
import com.path.vo.common.select.SelectCO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: MarwanMaddah
 *
 * ElementsOptionsListAction.java used to
 */
public class ElementsOptionsListAction extends GridBaseAction
{
   private ScreenGeneratorSC criteria = new ScreenGeneratorSC();
   @Override
   public Object getModel()
   {
	return criteria;
   }
   
   /**
    * 
    * @author MarwanMaddah
    * @date   Feb 3, 2016
    * @return String
    *
    */
   public String loadOptionsGrid()
   {
	String[] searchCol = {"code","descValue","defaultValue"};
	try {
	     /**
	      *  copy the details related to search criteria to the SC
	      */
	     SessionCO sessionCO = returnSessionObject();
             criteria.setSearchCols(searchCol);
             List<SelectCO> optionsList = new ArrayList<SelectCO>();
             if(!StringUtil.nullToEmpty(criteria.getOptionsData()).isEmpty())
             {        	 
	        	 JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(criteria.getOptionsData());
	        	 Object[] modelArr = jsonModel.toArray();
	        	 JSONObject obj = null; 
	        	if ( modelArr != null && modelArr.length > 0 )
	        			obj = (JSONObject) modelArr[0];
	        	
	 	         if ( obj !=null && ( !obj.has("tableDatasource") ||  ((String)obj.get("tableDatasource") ).equals(ConstantsCommon.DATASOURCE_BY_STATIC) ) ) 
	 	         {        	 
		        	 for(int i=0;i<modelArr.length;i++)
		        	 {
		        	     obj = (JSONObject) modelArr[i];
		        	     SelectCO currOptionData = (SelectCO)JSONObject.toBean(obj, SelectCO.class);
		        	     optionsList.add(currOptionData);
		        	 }
	             }
             }
             
	     copyproperties(criteria);
	     String optionsData = criteria.getOptionsData();
	     
	     /**
	      *  set number of rows to be displayed in the page of grid, and the
	      * total number of records for first time load only
	      */
	     if(checkNbRec(criteria))
	     {
		setRecords(optionsList.size());
             }
	     /**
	      *  return the collection of records
	      */
	     /**
	      *  set the collection into gridModel attribute defined at JSP grid tag
	      */
	     setGridModel(optionsList);
	}
	catch(Exception e)
	{
	  log.error(e, "Error in loadOptionsScreen");
	  handleException(e, null, null);
	}
	return SUCCESS;
   }

   
    /**
     * @return the criteria
     */
    public ScreenGeneratorSC getCriteria()
    {
        return criteria;
    }
    
    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(ScreenGeneratorSC criteria)
    {
        this.criteria = criteria;
    }
}
