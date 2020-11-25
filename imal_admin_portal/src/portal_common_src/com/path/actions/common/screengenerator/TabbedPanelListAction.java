package com.path.actions.common.screengenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * @author Sajjad Soomro
 * @date 12 Dec, 2019
 * @description TabbedPanelListAction.java used to generate the grid to load the detail of the tabs of the TabbedPanel
 */
public class TabbedPanelListAction extends GridBaseAction
{
   private ScreenGeneratorSC criteria = new ScreenGeneratorSC();
   
   @Override
   public Object getModel()
   {
	return criteria;
   }
   
   public String loadOptionsGrid()
   {
	String[] searchCol = {"tabPropId","tabName","tabId"};
	try {
	     /**
	      *  copy the details related to search criteria to the SC
	      */
             criteria.setSearchCols(searchCol);
             List<LinkedHashMap> gridList = null;
             if(!StringUtil.nullToEmpty(criteria.getSourceData()).isEmpty())
             {
        	 JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(criteria.getSourceData());
        	 Object[] modelArr = jsonModel.toArray();
        	 JSONObject obj;
        	 
         	 gridList = new ArrayList<LinkedHashMap>();
         	 for(int i = 0; i < modelArr.length; i++)
         	 {
         	    obj = (JSONObject) modelArr[i];
          	     LinkedHashMap linkedHashMap = (LinkedHashMap) JSONObject.toBean(obj, LinkedHashMap.class);
         	     gridList.add(linkedHashMap);
         	 }
             }
	     copyproperties(criteria);
	     
	     /**
	      * set number of rows to be displayed in the page of grid, and the
	      * total number of records for first time load only
	      */
	     if(checkNbRec(criteria))
	     {
		setRecords(gridList.size());
             }
	     
	     /**
	      *  set the collection into gridModel attribute defined at JSP grid tag
	      */
	     setGridModel(gridList);
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
