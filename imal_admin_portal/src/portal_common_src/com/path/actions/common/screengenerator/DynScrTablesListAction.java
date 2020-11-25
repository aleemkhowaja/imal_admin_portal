/**
 * 
 */
package com.path.actions.common.screengenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.screengenerator.ScreenGeneratorBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.screengenerator.DynScrTableColsCO;
import com.path.vo.common.screengenerator.DynScrTablesCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * @author marwanmaddah
 *
 */
public class DynScrTablesListAction extends GridBaseAction
{
    private ScreenGeneratorBO screenGeneratorBO;
    private ScreenGeneratorSC criteria       = new ScreenGeneratorSC();
    private List<SelectCO>    columnTypeList = new ArrayList<SelectCO>();
    @Override
    public Object getModel()
    {
	return criteria;
    }

    public String loadDynScrTablesGrid()
    {
	String[] searchCol = { "TABLE_ID", "TABLE_TECH_NAME", "TABLE_DESC", "COL_ID", "COL_TECH_NAME", "COL_DESC",
		"PRIMARY_KEY", "COL_TYPE","COL_TYPE_DESC","COL_LENGTH","DECIMAL_VALUE" };
	try
	{
	    /**
	     * copy the details related to search criteria to the SC
	     */
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setSearchCols(searchCol);
	    criteria.setLovTypeId(ConstantsCommon.DATA_TYPE_LOV_TYPE);
	    criteria.setLangCode(sessionCO.getLanguage());
	    if(criteria.getTableId() == null)
	    {
		criteria.setTableId(new BigDecimal("-1"));
	    }
	    copyproperties(criteria);
	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(criteria))
	    {
		setRecords(screenGeneratorBO.dynScrTablesListCount(criteria));
	    }

	    /**
	     * return the collection of records
	     */
	    List<DynScrTableColsCO> scrTablesList = screenGeneratorBO.dynScrTablesList(criteria);

	    /**
	     * set the collection into gridModel attribute defined at JSP grid
	     * tag
	     */
	    setGridModel(scrTablesList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadDynScrTablesGrid");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    /**
     * 
     * @return
     */
    public String loadGeneratedTblGrid()
    {
	String[] searchCol = { "TABLE_ID", "TABLE_TECH_NAME", "TABLE_DESC"};
	try
	{
	    /**
	     * copy the details related to search criteria to the SC
	     */
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    criteria.setTableId(BigDecimal.valueOf(-1));
	    if(checkNbRec(criteria))
	    {
		setRecords(screenGeneratorBO.dynScrGeneratedTblListCount(criteria));
	    }
	    
	    /**
	     * return the collection of records
	     */
	    List<DynScrTablesCO> scrGeneratedTblList = screenGeneratorBO.dynScrGeneratedTblList(criteria);
	    
	    /**
	     * set the collection into gridModel attribute defined at JSP grid
	     * tag
	     */
	    setGridModel(scrGeneratedTblList);
	    
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadGeneratedTblGrid");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    /**
     * 
     * @return
     */
    public String loadGridWigetColProperties()
    {
	String[] searchCol = { "TABLE_ID", "TABLE_TECH_NAME", "TABLE_DESC" };
	copyproperties(criteria);

	try
	{
	    if(!criteria.getColProperties().isEmpty())
	    {
		JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(criteria.getColProperties());
		JSONArray jsonModel = jsonFilter.getJSONArray("root");
		Object[] modelArr = jsonModel.toArray();
		List<HashMap<String,Object>> colsList = new ArrayList<HashMap<String,Object>>();
		SelectSC selSC = new SelectSC();
		selSC.setLanguage(returnSessionObject().getLanguage());
		String desc;

		for(int i = 0; i < modelArr.length; i++)
		{
		    JSONObject obj = (JSONObject) modelArr[i];
		    HashMap<String,Object> gridColsElemHm =(HashMap<String, Object>) new ObjectMapper().readValue(obj.toString(), HashMap.class);
		    if(gridColsElemHm.get("QUERY_DATA").getClass()==ArrayList.class)
		    {
			    String queryData = obj.get("QUERY_DATA").toString();
			    gridColsElemHm.put("QUERY_DATA",queryData);
		    }
		    /*SUPT190250,Vysakh,BEGIN*/
		    if(gridColsElemHm.get("SOURCE_MAPPING_CODE") != null)
		    {
			selSC.setLovTypeId(ConstantsCommon.SOURCE_MAPPING_LOV_TYPE);
			selSC.setLovCodesInlude("'"+gridColsElemHm.get("SOURCE_MAPPING_CODE").toString()+"'");
			desc = returnCommonLibBO().returnSingleLOV(selSC);
			gridColsElemHm.put("SOURCE_MAPPING", desc);
		    }
		    
		    if(gridColsElemHm.get("AGGREGATE_CODE") != null)
		    {
			selSC.setLovTypeId(ConstantsCommon.AGGREGATE_LOV_TYPE);
			selSC.setLovCodesInlude("'"+gridColsElemHm.get("AGGREGATE_CODE").toString()+"'");
			desc = returnCommonLibBO().returnSingleLOV(selSC);
			gridColsElemHm.put("AGGREGATE", desc);
		    }

		    if(gridColsElemHm.get("VISIBILITY_YN") == null)
		    {
			gridColsElemHm.put("VISIBILITY_YN", "1");
		    }
		    /*SUPT190250,Vysakh,END*/
		    
		    
		    colsList.add(gridColsElemHm);
		}
		if(checkNbRec(criteria))
		{
		    setRecords(colsList.size());
		}
		/**
		 * set the collection into gridModel attribute defined at JSP
		 * grid tag
		 */
		setGridModel(colsList);
	    }
	    else
	    {
		/**
		 * copy the details related to search criteria to the SC
		 */
		SessionCO sessionCO = returnSessionObject();
		criteria.setSearchCols(searchCol);
		criteria.setLovTypeId(ConstantsCommon.DATA_TYPE_LOV_TYPE);
		criteria.setLangCode(sessionCO.getLanguage());
		/**
		 * set number of rows to be displayed in the page of grid, and
		 * the total number of records for first time load only
		 */
		criteria.setTableId(BigDecimal.valueOf(-1));
		if(checkNbRec(criteria))
		{
		    setRecords(screenGeneratorBO.dynScrGridWidgetColsListCount(criteria));
		}

		/**
		 * return the collection of records
		 */
		List<DynScrTableColsCO> scrGeneratedTblList = screenGeneratorBO.dynScrGridWidgetColsList(criteria);
		/*SUPT190250,Vysakh,BEGIN*/
		for(DynScrTableColsCO dynScrTableColsCO : scrGeneratedTblList)
		{
		    dynScrTableColsCO.setVISIBILITY_YN(ConstantsCommon.ONE);
		    dynScrTableColsCO.setSOURCE_MAPPING_CODE(ConstantsCommon.SOURCE_MAPPING_STANDARD_INPUT);
		    SelectSC selSC = new SelectSC(ConstantsCommon.SOURCE_MAPPING_LOV_TYPE);
		    selSC.setLovCodesInlude("'5'");
		    selSC.setLanguage(returnSessionObject().getLanguage());
		    dynScrTableColsCO.setSOURCE_MAPPING(returnCommonLibBO().returnSingleLOV(selSC));
		}
		/*SUPT190250,Vysakh,END*/
		
		setGridModel(scrGeneratedTblList);
	    }

	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadGeneratedTblGrid");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    /**
     * 
     */
    public String loadColumnTypeSelect()
    {
	try{
	    SelectSC selSC = new SelectSC(ConstantsCommon.DATA_TYPE_LOV_TYPE);
	    columnTypeList = returnLOV(selSC);
	}
	catch(Exception ex)
	{
	    log.error(ex, "Error in loadColumnTypeSelect");
	    handleException(ex, null, null);  
	}
	return SUCCESS;
    }
    /*SUPT190250,Vysakh,BEGIN*/
    public String loadSourceMappingSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ConstantsCommon.SOURCE_MAPPING_LOV_TYPE);
	    selSC.setLovCodesInlude("'1','2','3','4','5'");
	    columnTypeList = returnLOV(selSC);
	}
	catch(Exception ex)
	{
	    log.error(ex, "Error in loadColumnTypeSelect");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * 
     */
    public String loadAggregateSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ConstantsCommon.AGGREGATE_LOV_TYPE);
	    selSC.setLovCodesInlude("'0','1','2'");
	    columnTypeList = returnLOV(selSC);
	}
	catch(Exception ex)
	{
	    log.error(ex, "Error in loadColumnTypeSelect");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    /*SUPT190250,Vysakh,END*/
    
    /**
     * @param screenGeneratorBO the screenGeneratorBO to set
     */
    public void setScreenGeneratorBO(ScreenGeneratorBO screenGeneratorBO)
    {
	this.screenGeneratorBO = screenGeneratorBO;
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

    /**
     * @return the columnTypeList
     */
    public List<SelectCO> getColumnTypeList()
    {
        return columnTypeList;
    }

    /**
     * @param columnTypeList the columnTypeList to set
     */
    public void setColumnTypeList(List<SelectCO> columnTypeList)
    {
        this.columnTypeList = columnTypeList;
    }

}
