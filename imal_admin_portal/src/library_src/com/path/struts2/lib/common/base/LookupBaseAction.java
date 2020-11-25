package com.path.struts2.lib.common.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.SYS_PARAM_OBJ_DETAILS_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.struts2.lib.common.RootUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class LookupBaseAction extends GridBaseAction
{
    private static final long serialVersionUID = 1L;
    private List<HashMap<String, Object>> _colModel = new ArrayList<HashMap<String, Object>>();
    private List<String> _colNames = new ArrayList<String>();
    private transient LookupGrid grid;
    private String searchValue;
    private String searchElement;
    private Boolean validateStatus;
    private String validateArgument;
    private final static String[] generalOperator = new String[4]; 
    private final static String[] textOperators = new String[10];
    static{
	generalOperator[0]="eq";
	generalOperator[1]="ne";
	generalOperator[2]="lt";
	generalOperator[3]="gt";

	textOperators[0]="eq";
	textOperators[1]="ne";
	textOperators[2]="bw";
	textOperators[3]="bn";
	textOperators[4]="ew";
	textOperators[5]="en";
	textOperators[6]="cn";
	textOperators[7]="nc";
	textOperators[8]="nu";
	textOperators[9]="nn";
    }
    /**
     * Method that generates the lookup with standard specification of Column
     * 
     * @param grid Grid Object
     * @param sc GridParamSC
     * @param name Array of Column Names
     * @param colType Array of Column Types
     * @param titles array of Titles
     */
    public void lookup(LookupGrid grid, GridParamsSC sc, String[] name, String[] colType, String... titles)
	    throws BaseException
    {
	List<LookupGridColumn> lsGridColumn = returnStandarColSpecs(name, colType, titles);
	lookup(grid, lsGridColumn, null, sc);
    }

    /**
     * Method that generates the lookup with standard specification of Column
     * given by double dimensional array as {{name,type,title},...}
     * 
     * @param grid
     * @param sc
     * @param columnDetails
     * @throws BaseException
     */
    public void lookup(LookupGrid grid, GridParamsSC sc, String[]... columnDetails) throws BaseException
    {
	List<LookupGridColumn> lsGridColumn = returnStandarColSpecs(columnDetails);
	lookup(grid, lsGridColumn, null, sc);
    }

    /**
     * Method Returns Standard Column Specification for Lookup Grid providing
     * double dimensional array of details
     * 
     * @param columnDetails
     * @return
     * @throws BaseException
     */
    public List<LookupGridColumn> returnStandarColSpecs(String[]... columnDetails) throws BaseException
    {
	if(columnDetails == null)
	{
	    throw new BaseException(
		    "Incorrect List Specification for Columns to Return Standard Specification for Double Array");
	}
	else
	{
	    int cols = columnDetails.length;
	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
	    for(int i = 0; i < cols; i++)
	    {
		// check if list size provided correctly
		if(columnDetails[i] != null && columnDetails[i].length >= 3)
		{
		    // check if . character available in the name, since index
		    // cannot have . in it.
		    // Defining each column
		    LookupGridColumn gridColumn = new LookupGridColumn();
		    gridColumn.setName(columnDetails[i][0]);
		    gridColumn.setIndex(columnDetails[i][0]);
		    gridColumn.setColType(columnDetails[i][1]);
		    gridColumn.setTitle(columnDetails[i][2]);
		    gridColumn.setSearch(true);
		    // adding column to the list
		    lsGridColumn.add(gridColumn);
		}
		else
		{
		    throw new BaseException(
			    "Incorrect List Specification for index "+i);
		}
	    }
	    return lsGridColumn;
	}
    }
    /**
     * Method Returns Standard Column Specification for Lookup Grid
     * 
     * @param grid
     * @param sc
     * @param name
     * @param colType
     * @param titles
     * @return
     * @throws BaseException
     */
    public List<LookupGridColumn> returnStandarColSpecs(String[] name, String[] colType, String... titles)
	    throws BaseException
    {

	if(name != null && colType != null && titles != null && name.length == colType.length
		&& colType.length == titles.length)
	{
	    int cols = name.length;
	    List<LookupGridColumn> lsGridColumn = new ArrayList<LookupGridColumn>();
	    for(int i = 0; i < cols; i++)
	    {
		// check if . character available in the name, since index
		// cannot have . in it.
		// Defining each column
		LookupGridColumn gridColumn = new LookupGridColumn();
		gridColumn.setName(name[i]);
		gridColumn.setIndex(name[i]);
		gridColumn.setColType(colType[i]);
		gridColumn.setTitle(titles[i]);
		gridColumn.setSearch(true);
		// adding column to the list
		lsGridColumn.add(gridColumn);
	    }
	    return lsGridColumn;
	}
	else
	{
	    throw new BaseException("Incorrect List Specification for Columns to Return Standard Specification");
	}
    }
    
    public void lookup(LookupGrid grid, List<LookupGridColumn> gridColumn, List gridModel, GridParamsSC sc)
    {
	try
	{
	    StringBuffer searchColumns = null;// search columns buffer to send
					      // to client side and return back
	    
	    HttpServletRequest httprequest = ServletActionContext.getRequest();//946722 LiveSearch Customization of Column is not reflected at RunTime
	
	    this.grid = grid;
	    /**
	     *[MarwanMaddah]: Grid User Preferences Management
	     */
	    String gridId = "";
	    boolean isIdEmpty = StringUtil.nullToEmpty(getId()).isEmpty();
	    if(!isIdEmpty)
	    {
		if(StringUtil.nullToEmpty(this.grid.getId()).isEmpty())
		{
		   gridId = getId();   
		   this.grid.setId(getId());
		}
		else
		{
		    gridId = this.grid.getId();
		}
	    }
	    
	    for(LookupGridColumn eachCol : gridColumn)
	    {
		_colNames.add(eachCol.getTitle());
		// check type of the column to add Additional options for search
		if(eachCol.getSearch() && !eachCol.getHidden())
		{
		    HashMap searchoptions = new HashMap();
		    // searchoptions.put("sopt", "['eq','ne','lt','gt']");
		    searchoptions.put("sopt", generalOperator);
		    if("text".equalsIgnoreCase(eachCol.getColType()))
		    {
			searchoptions.put("sopt", textOperators);
		    }
		    else if("number".equalsIgnoreCase(eachCol.getColType()))
		    {
			// adding right class css for numbers
			eachCol.setCssClass("right " + StringUtil.nullToEmpty(eachCol.getCssClass()));

			/**
			 * [MarwanMaddah]set the default values for the
			 * formatter and the nbFormat in case the colType is
			 * number
			 */
			if(!StringUtil.nullToEmpty(eachCol.getLeadZeros()).isEmpty()
				&& StringUtil.nullToEmpty(eachCol.getFormatter()).isEmpty())
			{
			    /**
			     * "defaultNumFmatter" it is the default formatter javaScript function
			     */
			    eachCol.setFormatter("defaultNumFmatter");
			    if(StringUtil.nullToEmpty(eachCol.getNbFormat()).isEmpty())
			    {
				eachCol.setNbFormat("###");
			    }
			}
		    }
		    
		    /**
		     * [MarwanMaddah]:in case the colType is a date we will set a default date formatter 
		     */
		    else if("date".equalsIgnoreCase(eachCol.getColType()) && StringUtil.nullToEmpty(eachCol.getFormatter()).isEmpty())
		    {
			eachCol.setFormatter("date");
			if(StringUtil.nullToEmpty(eachCol.getFormatoptions()).isEmpty())
			{
			    String gridDateformat = RootUtil.returnGridDateMask(ServletActionContext.getRequest().getSession());
			    String formatOptions  = "{srcformat: 'Y-m-d',newformat: '" + gridDateformat + "'}";
			    eachCol.setFormatoptions(formatOptions);
			}
		    }
		    eachCol.setSearchoptions(searchoptions);

		    // if no search columns defined for SC
		    if(sc == null || sc.getSearchCols() == null)
		    {
			// adding Search Columns
			if(searchColumns == null)
			{
			    searchColumns = new StringBuffer();
			    searchColumns.append(eachCol.getIndex());
			}
			else
			{
			    searchColumns.append("," + eachCol.getIndex());
			}
		    }

		}
		// 946722 LiveSearch Customization of Column is not reflected at RunTime
		if(!isIdEmpty && !eachCol.getHidden())
		{ 
			SYS_PARAM_OBJ_DETAILS_DISPLAYVO theObjDetailsVO = null;
			theObjDetailsVO = RootUtil.returnParamObjDetailsDisplay(httprequest, gridId,
				eachCol.getName());
			if(theObjDetailsVO != null)
			{
			    eachCol.setHidden((theObjDetailsVO.getIS_VISIBLE() != null
				    && theObjDetailsVO.getIS_VISIBLE().intValue() == 0) ? true : false);
			}
		}
		// 946722:end
		_colModel.add(eachCol.getColumnMap());
	    }
  
	    // add search column to grid
	    if(searchColumns != null)
	    {
		this.grid.setSearchColumns(searchColumns.toString());
	    }
	    
	    /**
	     *[MarwanMaddah]: Grid User Preferences Management
	     */
	    if(!isIdEmpty)
	    {
		String columnsOrder = returnObjectColumnsOrder(gridId,ConstantsCommon.PREF_OBJECT_TYPE_GRID);
		if(!StringUtil.nullToEmpty(columnsOrder).isEmpty())
		{
		    this.grid.setColumnsOrder(columnsOrder);
		}
	    }
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }

    public void setSearchFilter(GridParamsSC sc)
    {
	try
	{
	    // if search value of the input of livesearch component is passed
	    // (removed currenlty from JS LiveSearch.js)
	    if(searchValue != null && searchValue.length() > 0)
	    {
		// PathSolutions [Raees] modified for amending the search
		// criteria if search filter is present else add new search
		// filter
		String filters = sc.getFilters();
		if(filters != null && filters.length() > 0)
		{
		    JSONObject jSONObject = (JSONObject) JSONSerializer.toJSON(filters);
		    /**
		     * [MarwanMaddah]:527075 - Central Bank Parameters/ Template Header - Error message generated under Search
		     */
		    JSONArray rules = null;
		    int rulesCount = 0;
		    if(jSONObject.get("rules")!=null)
		    {			
			rules = jSONObject.getJSONArray("rules");
			rulesCount = JSONArray.getDimensions(rules)[0];
		    }
		    boolean addNewRule = true;
		    if(rulesCount > 0)
		    {
			for(int i = 0; i < rulesCount; i++)
			{
			    JSONObject rule = rules.getJSONObject(i);
			    String field = rule.getString("field");
			    if(field.equalsIgnoreCase(searchElement.substring(1, searchElement.length() - 1)))
			    {
				addNewRule = false;// to prevent if the search
						   // value in the toolbar need
						   // not to consider the search
						   // value
				break;
			    }
			}
		    }
		    if(addNewRule)
		    {
			String serchString = "{\"field\":" + searchElement + ",\"op\":\"bw\",\"data\":\"" + searchValue
				+ "\"}";
			rules.add(JSONSerializer.toJSON(serchString));
			sc.setFilters(jSONObject.toString());
			sc.set_search("true");
		    }
		}
		else
		{
		    searchValue = "\"" + searchValue + "\"" + "}]}";
		    String searchFilter = "{\"groupOp\":\"AND\",\"rules\":[{\"field\":" + searchElement
			    + ",\"op\":\"bw\",\"data\":" + searchValue;
		    sc.setFilters(searchFilter);
		    sc.set_search("true");
		}
	    }
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }

    public LookupGrid getGrid()
    {
	return grid;
    }

    public void setGrid(LookupGrid grid)
    {
	this.grid = grid;
    }

    public List<HashMap<String, Object>> get_colModel()
    {
	return _colModel;
    }

    public void set_colModel(List<HashMap<String, Object>> colModel)
    {
	_colModel = colModel;
    }

    public List<String> get_colNames()
    {
	return _colNames;
    }

    public void set_colNames(List<String> colNames)
    {
	_colNames = colNames;
    }

    public String getSearchValue()
    {
	return searchValue;
    }

    public void setSearchValue(String searchValue)
    {
	this.searchValue = searchValue;
    }

    public String getSearchElement()
    {
	return searchElement;
    }

    public void setSearchElement(String searchElement)
    {
	this.searchElement = searchElement;
    }

    public Boolean getValidateStatus()
    {
	return validateStatus;
    }

    public void setValidateStatus(Boolean validateStatus)
    {
	this.validateStatus = validateStatus;
    }

    public String getValidateArgument()
    {
	return validateArgument;
    }

    public void setValidateArgument(String validateArgument)
    {
	this.validateArgument = validateArgument;
    }
}
