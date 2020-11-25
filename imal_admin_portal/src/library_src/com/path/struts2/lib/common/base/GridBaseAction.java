package com.path.struts2.lib.common.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.conversion.impl.XWorkConverter;
import com.opensymphony.xwork2.ognl.OgnlUtil;
import com.path.bo.common.CommonLibBO;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.object.ObjectCustomizationSC;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class GridBaseAction extends BaseAction
{

    public static final String SUCCESS_JSON = "success";
    
    public static final String EXPORT_EXCEL_ERR = "excel_error";
    public static final String EXPORT_EXCEL = "excel";

    // Your result List
    private List gridModel;

    // Get the requested page. By default grid sets this to 1.
    private Integer page = 0;

    // Your Total Pages
    private Integer total = 0;

    // All Records count
    private Integer records = 0;

    // get how many rows we want to have into the grid - rowNum attribute in the
    // grid
    private Integer rows = 0;

    // specfies the OPT to be used for security(on add/modify/delete/display)
    private String securityRef;

    // specifies the multi headers
    private String multiHeader;

    // specifies the id of the row being deleted
    private String id;
    
    private HashMap userdata;


    // TreeGrid attribute
    private String nodeid;
    
    private String viewRecords;

    private String loadOnce;

    /**
     * Arguments to support exporting excel document
     **/
    private InputStream streamExcel;
    private String streamFileName;
    private String exportGridStr;
    private String gridColNamesStr;
    private String gridURLStr;
    private String gridMethodStr;
    
    
    /*953614 Specify Grid Filter Query Expression - Grid/Livesearch Customization Enhancements*/
    protected String filterExpToValidate;
    
    private boolean dbNotAccessed;
    
    public void setDbNotAccessed(boolean dbNotAccessed)
    {
        this.dbNotAccessed = dbNotAccessed;
    }
    /**
     * @return the filterExpToValidate
     */
    public String getFilterExpToValidate()
    {
	return filterExpToValidate;
    }
    /**
     * @param filterExpToValidate the filterExpToValidate to set
     */
    public void setFilterExpToValidate(String filterExpToValidate)
    {
	this.filterExpToValidate = filterExpToValidate;
    }
    
    private ObjectCustomizationSC generateObjectCustomizationSC()
    {
	ObjectCustomizationSC criteria = new ObjectCustomizationSC();
	criteria.setProgRef(get_pageRef());
	criteria.setAppName(returnSessionObject().getCurrentAppName());
	String id=null;
	if(getId() != null)
	{
	    id=getId();
	}
	else
	{
	    id=ServletActionContext.getRequest().getParameter("gridObjectId");
	    
	}
	if(id != null)
	{
	    String objectId = id.replace("_"+get_pageRef(), "").replace("gbox_", "");
	    criteria.setObjectId(objectId);
	}
	return criteria;
    }
    
    private void appendFilterQueryIfAny(StringBuffer resultQuery ,  Map addionalParams) throws BaseException
    {
	String queryString = null;
	if(this.getFltrExpValidateFlg() != null && this.getFltrExpValidateFlg().equals("1")) //validation attempt
	{
	    queryString = this.getFilterExpToValidate();
	}
	else
	{
	    CommonLibBO commonLibBO = null;
	    ObjectCustomizationSC custCO = null;
	    SessionCO sessionCO = null;
	    String _pageRef = null;
	    // if ActionContext and Request Available (Presentation Code Object Instantiation)
	    boolean isPortalSide = (ActionContext.getContext() != null && ServletActionContext.getRequest() != null);
	    if(isPortalSide)
	    {
		_pageRef=get_pageRef();
		sessionCO = returnSessionObject();
		custCO = generateObjectCustomizationSC();
		if(custCO.getObjectId() == null || custCO.getProgRef() == null)
		{
		    return;
		}
		commonLibBO = returnCommonLibBO();
	    }
	    //enable the filter on service calls
	    else
	    {
		if(addionalParams == null)
		{
		    return;
		}
		String appName = ConstantsCommon.returnCurrentAppName();
		
		if(addionalParams.get("_pageRef") instanceof String)
		{
		    _pageRef = (String) addionalParams.get("_pageRef");
		}
		else
		{
		    return;
		}
		String gridObjectId = null;
		if(addionalParams.get("gridObjectId") instanceof String)
		{
		    String id = (String) addionalParams.get("gridObjectId");
		    gridObjectId = id.replace("_" + _pageRef, "").replace("gbox_", "");
		}
		else
		{
		    return;
		}

		custCO = new ObjectCustomizationSC();
		custCO.setObjectId(gridObjectId);
		custCO.setProgRef(_pageRef);
		custCO.setAppName(appName);

		sessionCO = (SessionCO) PathPropertyUtil.convertToObject((HashMap<String, Object>) addionalParams,
			SessionCO.class);

		commonLibBO = (CommonLibBO) ApplicationContextProvider.getApplicationContext().getBean("commonLibBO");
	    }
	    String filterExpression = commonLibBO.returnFilterExpression(custCO);
	    if(StringUtil.nullToEmpty(filterExpression).isEmpty())
	    {
		return;
	    }
	    RequiredFieldsSC reqSc = CommonMethods.createRequiredFieldsSCFromSessionProps(sessionCO);
	    reqSc.setProgRef(_pageRef);
	    Object result = commonLibBO.executeExpression(filterExpression, 0,
		    CommonMethods.returnBoolExpressionDataList(reqSc), reqSc);
	    if(!(result instanceof String))
	    {
		return;
	    }
	    queryString = (String) result;

	}
	
	if(queryString.isEmpty())
	{
	    return;
	}
	
	if(!resultQuery.toString().isEmpty())
	{
	    resultQuery.append(" AND ");
	}
	resultQuery.append("(").append(queryString).append(")");
    }
    /*end: 953614*/
    /**
     * @return current page of the query
     */
    public Integer getPage()
    {
	return page;
    }

    public void setPage(Integer page)
    {
	this.page = page;
    }

    /**
     * @return total pages for the query
     */
    public Integer getTotal()
    {
	return total;
    }

    public void setTotal(Integer total)
    {
	this.total = total;
    }

    /**
     * @param gridModel an collection that contains the actual data
     * @throws BaseException 
     */

    public void setGridModel(List gridModel)
    {

	 /*953614 Specify Grid Filter Query Expression - Grid/Livesearch Customization Enhancements*/
	if(dbNotAccessed && ConstantsCommon.ONE.equals(getFltrExpValidateFlg()))
	{
	    setFltrExpValidateFlg(ConstantsCommon.TWO);
	    handleException(new BOException(getText("db_not_accessed_key")), null, null);
	}
	
	
	this.gridModel = gridModel;
	if(records > 0 && getRows() > 0)
	{
	    total = ((int) Math.ceil((double) records / (double) getRows()));
	}
	else
	{
	    total = 0;
	}
    }

    public List getGridModel()
    {
	return gridModel;
    }

    /**
     * @return total number of records for the query. e.g. select count(*) from
     *         table
     */

    public Integer getRecords()
    {
	return records;
    }

    /**
     * @param rows how many rows we want to have into the grid
     */

    public Integer getRows()
    {
	return rows;
    }

    public void setRows(Integer rows)
    {
	this.rows = rows;
    }

    public void setRecords(Integer records)
    {
	this.records = records;
    }

    public void copyproperties(GridParamsSC sc)
    {
	copysearchproperties(sc);
	sc.setNbRec(getRows());
	sc.setRecToskip(sc.getNbRec() * (getPage() - 1));
    }

    public String getSecurityRef()
    {
	return securityRef;
    }

    public void setSecurityRef(String securityRef)
    {
	this.securityRef = securityRef;
    }

    public String getMultiHeader()
    {
	return multiHeader;
    }

    public void setMultiHeader(String multiHeader)
    {
	this.multiHeader = multiHeader;
    }

    // jqGrid multiple search attributes
    private static final String jqGridFieldAttr = "field";
    private static final String jqGridOperatorAttr = "op";
    private static final String jqGridDataAttr = "data";
    private static final String jqGridColTypeAttr = "colType";
    // jqGrid search operators
    public static final String equal = "eq";
    public static final String notEqual = "ne";
    public static final String lessThan = "lt";
    public static final String lessOrEqualTo = "le";
    public static final String greaterThan = "gt";
    public static final String greaterOrEqualTo = "ge";
    public static final String beginsWith = "bw";
    public static final String isNull = "nu";
    public static final String isNotNull = "nn";
    public static final String notBeginsWith = "bn";
    public static final String endsWith = "ew";
    public static final String notEndsWith = "en";
    public static final String contains = "cn";
    public static final String notContains = "nc";
    public static final String in = "in";
    public static final String notIn = "not in";

    private static final String COLTYPE_NUMBER = "number";
    /**
     * sets the search query filter in the SC used for toolbar and
     * multiple/single search to be called in all actions needed for grid
     * display and search
     * 
     * @param sc
     * @param request
     */
    public void copysearchproperties(GridParamsSC sc)
    {
	copysearchgridproperties( sc, PathActionContextMethods.returnParameters(), null);
    }
    /**
     *  making new method for copy grid search column 
     *  to be able to be called from web services to initialize the grid search parameters
     * 
     * @param sc Grid SC object
     * @param Map the parameter Maps to search accordingly
     * @param Map additional parameters that could be needed to not access the spring for BO access like baseService
     */
    public void copysearchgridproperties(GridParamsSC sc, Map paramMap, Map addionalParams)
    {
	try
	{
	    	String filters = sc.getFilters();
	    	int isSybase = 0;
	    	String theAppName = null, coreIMAL = ConstantsCommon.YES;
	    	if(addionalParams != null && addionalParams.get("isSybase") != null)
	    	{
	    	    isSybase = (Integer) addionalParams.get("isSybase");
	    	    theAppName = addionalParams.get("appName") != null? (String)addionalParams.get("appName"):null;
	    	}
	    	else
	    	{
	    	    isSybase = baseServices.returnIsSybase();
	    	    // read current applicationName
	    	    SessionCO sessCO = returnSessionObject();
	    	    if(sessCO != null)
	    	    {
	    		theAppName = sessCO.getCurrentAppName();
	    		// if OMNI Admin then check if CORE is IMAL, to apply the Column Search that are VARCHAR _CODE to be as NUMERIC
	    		if(ConstantsCommon.OADM_APP_NAME.equals(theAppName))
	    		{
	    		    coreIMAL = returnCommonLibBO().returnPthCtrl1().getCORE_IMAL_YN();
	    		}
	    	    }
	    	}
		String leftSideComp = "UPPER( ";
		String rightSideComp = ")LIKE UPPER( ";
		String endComp = ")";
		String sybConvertOpen = "";
		String sybConvertClose = "";
		StringBuffer resultQuery = new StringBuffer();
		String orOperator = "OR";
		String dateToChar = "to_char(";
		String dateFormat = ",'dd/mm/yyyy')";
		String concatOperator = "||";
		String numberConvertOpen = "TO_NUMBER(", numberConvertClose = ") ";
		if(isSybase == 1)
		{
		// VARCHAR(100) defined character size because the sybase
		// convert function is default to 32 character, if exceeded will
		// not return a result.
		    sybConvertOpen = "CONVERT(VARCHAR(100), ";
		    dateToChar = sybConvertOpen ; 
		    sybConvertClose = ")";
		    dateFormat = ",103)";
		    concatOperator = "+";
		    numberConvertOpen = "CONVERT(NUMERIC,";
		}
		if(getPage() == 1) // only on first page, dont need to set on flip
		{		   
		    setRecords(0);
		}
		// Single Search 
		if(filters == null || filters.isEmpty())
		{
		    if(sc.getSearchField() != null && !sc.getSearchField().isEmpty())
		    {
			    String op = sc.getSearchOper();
			    String query = "";

			    if(op.equals(equal) || op.equals(notEqual))
			    {
				query = sybConvertOpen + " "+sc.getSearchField() +" "+ sybConvertClose;
			    }
			    else if(op.equals(beginsWith) || op.equals(notBeginsWith) || op.equals(endsWith)
				    || op.equals(notEndsWith) || op.equals(contains) || op.equals(notContains))
			    {
				query = leftSideComp + sybConvertOpen + " "+sc.getSearchField()+" " + sybConvertClose + endComp;
			    }
			    else
			    {
				query = sc.getSearchField();
			    }
			    query = query.concat(mapSearchOper(op, sc.getSearchString(), isSybase,null));
			    resultQuery.append(query);
		    }		    
		}
		else// Multiple search(grid attribute multipleSearch=true)
		{
		    filters = filters.replaceAll("(\\r|\\n|\\r\\n)+", "\\\\n");
		    resultQuery.append(returnSearchQuery((JSONObject) JSONSerializer.toJSON(filters), isSybase,sc));
		}
		
		/*953614 Specify Grid Filter Query Expression - Grid/Livesearch Customization Enhancements*/
		appendFilterQueryIfAny(resultQuery,addionalParams);
		if(!resultQuery.toString().isEmpty())
		    {
		      sc.setSearchQuery(resultQuery.toString());
		    }
		/*end: 953614*/
	  
//		else
//		{
		// check if there is search columns or livesearch columns
		  if(sc.getSearchCols() != null || sc.getLiveSearchCols() != null)
		  {
			  HashMap dateSearchCols = sc.getDateSearchCols();
		    StringBuffer colSearchQuery = new StringBuffer();
		    String[] searchCols = sc.getSearchCols();
		     if(searchCols == null)
		     {
			 searchCols = sc.getLiveSearchCols().split(",");
		     }
		     
		     
		    String[] value = null; // value of parameter in the map is a string array
		    String dataValue = null;
		 // get the parameters of request inside a map to look within the
		 // search columns which one is filled
		 //  Map paramMap = ActionContext.getContext().getParameters();
		   String _searchQry = "";
		   StringBuffer _dateSearchQry = new StringBuffer();
		   HashMap srchMapFldsOnly = new HashMap();
		    for(int i = 0; i < searchCols.length; i++)
		    {
			dataValue = null;
			_searchQry = "";
			_dateSearchQry = new StringBuffer();
			
			//toolbar search
			if(paramMap.get(searchCols[i]) != null)
			{
			    /**
			     * [MarwanMaddah] BUG#542174
			     */
			    String paramIsNbr = ConstantsCommon.ZERO;
			    if(paramMap.containsKey(searchCols[i]+"_isNbr") && paramMap.get(searchCols[i]+"_isNbr")!=null)
			    {
				paramIsNbr = ((String[])paramMap.get(searchCols[i]+"_isNbr"))[0];
			    }
			    // When calling from service there is option to pass the List parameters
			    if("java.util.List".equals(paramMap.get(searchCols[i]).getClass().getCanonicalName()))
			    {
				// check if the List Parameter is not Empty
				List dataList =  (List)paramMap.get(searchCols[i]);
				if(dataList != null && dataList.size() > 0)
				{
				    StringBuffer lstValues = new StringBuffer();
				    Iterator iterator = dataList.iterator();
				    boolean searchConvDone = false;
				    while(iterator.hasNext())
				    {
					Object theListValue = (Object) iterator.next();
					if(theListValue != null)
					{
					    // adding comma delimiter for values
					    if(!lstValues.toString().trim().isEmpty())
					    {
						lstValues.append(",");
					    }
					    if(ConstantsCommon.ONE.equals(paramIsNbr))
					    {
						if(NumberUtil.isNumber(theListValue.toString()))
						{
						    lstValues.append(theListValue.toString());
						}
						else
						{
						    _searchQry  = " 1 = 2 ";
						    log.debug(">>>> Incorrect Number Value included into the List Parameter of Search Column "+searchCols[i]);
						    break;
						}
					    }
					    else
					    {
						String currListValue = theListValue.toString();
						currListValue = currListValue.replaceAll("'", "''"); //replacing single quote in value with double quote since we r using like '%%'
	        				searchConvDone = verifyNumericColumnConv(coreIMAL, theAppName,searchCols[i],"SEARCH",currListValue);
	        				if(searchConvDone)
	        				{
	        				    lstValues.append(currListValue);
	        				}
	        				else
	        				{
	        				    lstValues.append("'"+currListValue+"'");
	        				}
					    }
					}
				    }
				    // loop on the list check the datatype
				    if(searchConvDone)
				    {
					_searchQry = numberConvertOpen +searchCols[i] + numberConvertClose+" IN (" + lstValues.toString() + ")";
				    }
				    else
				    {
					_searchQry = searchCols[i] + " IN (" + lstValues.toString() + ")";
				    }
				    srchMapFldsOnly.put(searchCols[i], lstValues.toString());
				}
			    }
			    else
			    if("java.util.Date".equals(paramMap.get(searchCols[i]).getClass().getCanonicalName()))
			    {
				//using this format because we are using the convert with 103
				dataValue =  DateUtil.format((Date)paramMap.get(searchCols[i]),"dd/MM/yyyy");
				srchMapFldsOnly.put(searchCols[i], dataValue);
			    }
			    else
			    {
        			    value = (String[]) paramMap.get(searchCols[i]);
        			    dataValue = value[0];
        			    /**
        			     * [MarwanMaddah] BUG#542174 On entering valid process code data with 2 digits decimal point, search operation is not working properly in Process Code field
        			     * in case the value is a number with decimal part end by 0+
        			     */
//        			    if(ConstantsCommon.ONE.equals(paramIsNbr))
//        			    {        				
//        				String patrn  = "(\\w+)(\\.)(\\d*[0]+$)";
//        				Pattern pattern = Pattern.compile(patrn);
//        				Matcher matcher = pattern.matcher(dataValue);
//        				if(matcher.find())
//        				{
//        				    String grp1 = matcher.group(1);
//        				    String grp2 = matcher.group(2);
//        				    String grp3 = matcher.group(3).replaceAll("[0]+$","");
//        				    if(StringUtil.nullToEmpty(grp3).isEmpty())
//        				    {
//        					dataValue = grp1;
//        				    }
//        				    else
//        				    {
//        					dataValue = grp1.concat(grp2).concat(grp3); 
//        				    }
//        				    
//        				}
//        			    }
        			    /**
        			     * 
        			     */
        			    srchMapFldsOnly.put(searchCols[i], dataValue);
        			    // if searchDate Columns not Containing same column as Date
        			    if(dateSearchCols == null || !dateSearchCols.containsKey(searchCols[i]))
        			    {
        				
        				// if numeric column then perform exact search
        				// without like search
        				if(ConstantsCommon.ONE.equals(paramIsNbr))
        				{
        				    if(NumberUtil.isNumber(dataValue))
        				    {
        					//limit number of digits to avoid numeric overflow exception.
        					if(dataValue.length()>70) 
        					{
        					    throw new BOException(getText("less_than_seventy_key"));
        					}
            					    _searchQry = searchCols[i] + " = " + dataValue;
        				    }
        				    else
        				    {

        					_searchQry  = " 1 = 2 ";
        				    }
        				}
        				else
        				{
        				    boolean searchConvDone = verifyNumericColumnConv(coreIMAL, theAppName,searchCols[i],"SEARCH",dataValue);
        				    if(searchConvDone)
        				    {
        						_searchQry = numberConvertOpen + " " + searchCols[i] + " "
                						+ numberConvertClose + " = " + dataValue + " ";
        						searchConvDone = true;
        				    }
        				    else
        				    {
        					dataValue = dataValue.replaceAll("'", "''"); //replacing single quote in value with double quote since we r using like '%%'
        					_searchQry = leftSideComp + sybConvertOpen + " " + searchCols[i] + " "
        						+ sybConvertClose + rightSideComp + sybConvertOpen + "'%" + dataValue + "%'"
        						+ sybConvertClose + endComp;
        				    }
        				}
        			    }
			    }
			    
			    if(dateSearchCols != null && dateSearchCols.containsKey(searchCols[i]))
			    {
				String sybTimeFrmt = ""; // sybase time format
//				 return date pattern according to date parameter.
				String datePattern = DateUtil.getDatePattern(dataValue);
				if(datePattern != null)
				{
				    dateFormat = ",'"+datePattern+"')";
				    if(isSybase == 1)
				    {
					dateFormat =  ",103)";
					// if time exists then sybase with time pattern
					if(datePattern.contains("HH"))
					{
					    sybTimeFrmt =  ",108)";
					}
					    
				    }
				    else
				    {
					// replace Java format returned from getDatePattern to Oracle Format
					// 24 hours replacement
					dateFormat = dateFormat.replace("HH", "HH24");
					// minutes replacement
					dateFormat = dateFormat.replace("mm", "MI");

					//removing milliseconds only in case of oracle 
					if(dateFormat.indexOf("S") > -1)
					{
					    dateFormat = dateFormat.replace(":S", "S").replace("S", "");
					    dataValue = dataValue.substring(0,dataValue.lastIndexOf(":"));
					}
					// AM/PM replacement
					dateFormat = dateFormat.replace("aaa", "AM");
				    }
				}
			    	_dateSearchQry.append(leftSideComp + dateToChar + " "+searchCols[i]+ " "+ dateFormat)  ;
			    	// if sybase with time then need to concatenate Time to Date 
			    	if(!sybTimeFrmt.isEmpty())
			    	{
			    	 _dateSearchQry = _dateSearchQry.append(" "+concatOperator+" ' ' "+concatOperator+" "+ dateToChar + " "+searchCols[i]+ " "+ sybTimeFrmt) ;
			    	}
			    	_dateSearchQry = _dateSearchQry.append(rightSideComp + sybConvertOpen + "'%" + dataValue + "%'" + sybConvertClose + endComp);
			    }

			    if(!_searchQry.isEmpty() || dataValue != null)
			    {
        			    if(!colSearchQuery.toString().isEmpty() )
        			    {
        				colSearchQuery.append(" AND ");
        			    }
        			    
        			    if(_dateSearchQry.length() == 0)
        			    {
        			    	colSearchQuery.append("( "+ _searchQry+" ) ");
        			    }
        			    else
        			    {
        				if(_searchQry.isEmpty())
        				{
        				    colSearchQuery.append(_dateSearchQry);
        				}
        				else
        				{
        				    colSearchQuery.append("( ("+ _searchQry+") "+orOperator+" ( "+_dateSearchQry+") )");
        				}
        			    }
			    }
			}
		    }
		    if(!colSearchQuery.toString().isEmpty())
		    {
			sc.setColSearchQuery(colSearchQuery.toString());
		    }
		    sc.setSrchMapFldsOnly(srchMapFldsOnly);
		  }
		  
		  // check the Sort Columns in order to verify in case Numeric Conversion required
		  if(ConstantsCommon.OADM_APP_NAME.equals(theAppName))
		  {
		      String sortCols = sc.getSidx();
		      String sortColsParams = sortCols;
		      boolean convExst = false;
		      if(!StringUtil.nullToEmpty(sortCols).trim().isEmpty())
		      {
			  String[] listSortCols = sortCols.split(",");
			  String curSortCol;
			  for(int j = 0; j < listSortCols.length; j++)
			  {
			      curSortCol = listSortCols[j].replaceAll("(?i) (asc|desc)", "");
			      boolean sortConvDone = verifyNumericColumnConv(coreIMAL, theAppName,curSortCol,"SORT",null);
			      if(sortConvDone)
			      {
				  sortColsParams = sortColsParams.replace(curSortCol,numberConvertOpen + curSortCol+ numberConvertClose );
				  convExst = true;
			      }
			  }
			  // there is something converted so need to update the sort columns
			  if(convExst)
			  {
			      sc.setSidx(sortColsParams); 
			  }
		      }
		  }
		  
	}
	catch(BOException boe)
	{
	    handleException(boe, null, null);
	}
	catch(Exception e)
	{
	    handleException(e, "Error in the function copyproperties in the class BaseAction", null);
	}
    }

    /**
     * Method to specify whether the conversion of VARCHAR Column to be doen as Numeric
     * @param coreIMAL Y/N if iMAL Core or Not
     * @param theAppName the Application NAme
     * @param searchColName Column Name of the Dynamic Search
     * @param typeConv SEARCH/SORT whcih is the Conversion type needed
     * @param dataValue the Value of the search
     * @return true if conversion needed false otherwise
     * @throws BaseException
     */
    private boolean verifyNumericColumnConv(String coreIMAL , String theAppName,String searchColName,String typeConv, String dataValue) throws BaseException
    {
	if(ConstantsCommon.OADM_APP_NAME.equals(theAppName))
	{
	    try
	    {
		String colNameRegExpToConsiderConv = StringUtil.nullToEmpty(PathPropertyUtil.returnPathPropertyFromFile("PathOADMRemoting.properties", "omni.columns.number.convert.match"));
		boolean regExpMatch = false;

		if(!colNameRegExpToConsiderConv.trim().isEmpty())
		{
		    Pattern ptr = Pattern.compile(colNameRegExpToConsiderConv);
		    Matcher numericFieldMatcher = ptr.matcher(searchColName);
		    regExpMatch = numericFieldMatcher.matches();

		    if(regExpMatch)
		    {
			if("SEARCH".equals(typeConv) && !NumberUtil.isNumber(dataValue))
			{
			    throw new BOException("Searching with Not Numeric Value "+dataValue);
			}
			else
			{
			    return true;
			}
		    }
		}
	    }
	    catch(Exception e)
	    {
		log.error(e,"Error in checkign Conversion For Numeric Fields");
	    }
	}
	return false;
    }
    private String returnSearchQuery(JSONObject jsonFilter, int isSybase, GridParamsSC sc) throws BaseException
    {
	JSONArray groups = null;
	JSONArray rules = null;
	int groupsCount = 0;
	StringBuffer s = new StringBuffer("(");
	int rulesCount = 0;
	
	if(jsonFilter.get("groups") != null)
	{
	    groups = jsonFilter.getJSONArray("groups");   
	    groupsCount = JSONArray.getDimensions(groups)[0] ;
	}
	
	String groupOp = jsonFilter.getString("groupOp");
	/**
	 * [MarwanMaddah]:527075 - Central Bank Parameters/ Template Header - Error message generated under Search
	 */	
	if(jsonFilter.get("rules") != null)
	{
	  rules = jsonFilter.getJSONArray("rules");
	  // number of search criteria entered
	  rulesCount = JSONArray.getDimensions(rules)[0];
	}
	if (groupsCount > 0) {
		for (int index = 0; index < groupsCount; index++) {
			if (s.length() > 1) {
					s.append( " "+groupOp+" ");
			}
			s.append( returnSearchQuery(groups.getJSONObject(index),isSybase,sc));
		}
	}
	
	if (rulesCount > 0) {
		for (int index = 0; index < rulesCount; index++) {
			if (s.length() > 1) {
        				s.append(" "+groupOp+" ");
			}
			s.append( getRuleQuery(rules.getJSONObject(index),isSybase, sc ));
		}
	}
	s.append( ")");

	if (s.toString().equals("()")) {
		return ""; // ignore groups that don't have rules
	} else {
		return s.toString();
	}

    }

    private String getRuleQuery(JSONObject rule, int isSybase, GridParamsSC sc) throws BaseException {
	String field = "";
	String op = "";
	String data = "";
	String colType = "";
	boolean isNumeric = false;
	String leftSideComp = "UPPER( ";
	String endComp = ")";
	String sybConvertOpen = "";
	String sybConvertClose = "";
	String toDate = "to_date(";
	String toDateToChar = "to_date(to_char(";
	String dateFormat = ",'dd/mm/yy')";
	HashMap dateSearchCols  = sc.getDateSearchCols();
	String concatOperator = "||";
	
	StringBuffer searchQuery = new StringBuffer();
	if(rule!=null)
	{
	    field = rule.getString(jqGridFieldAttr);
	    // operator search criteria
	    op = rule.getString(jqGridOperatorAttr);
	    // search string inputed by user
	    if(rule.containsKey(jqGridDataAttr))
	    {		
		data = rule.getString(jqGridDataAttr);
	    }
	    if(rule.containsKey(jqGridColTypeAttr))
	    {		
		colType = rule.getString(jqGridColTypeAttr);
		isNumeric = !StringUtil.nullToEmpty(colType).isEmpty() && COLTYPE_NUMBER.equals(colType);
	    }
	}
	
	if(isSybase == 1)
	{
	    sybConvertOpen = "CONVERT(VARCHAR, ";
	    if(isNumeric)
	    {
		sybConvertOpen = "CONVERT(NUMERIC, ";
	    }
	    sybConvertClose = ")";
	    toDate = "CONVERT(DATE,"; 
	    dateFormat = ",103)";
	    concatOperator = "+";
	}
	    if(data == null || data.equals(""))
	    {
		// check if operator is Null or Not Null
		if(op.equals(isNull) || op.equals(isNotNull))
		{
		    searchQuery.append(mapSearchOper(op, field, isSybase,colType));
		}
		else
		{
		    //different operator is chosen with empty value, means should behave like isnull
		    searchQuery.append(mapSearchOper(isNull, field, isSybase,colType));
		}		
	    }
	    else
	    {
		 if(dateSearchCols != null && dateSearchCols.containsKey(field))
		 {
		     	String datePattern = DateUtil.getDatePattern(data.trim());
		     	if(datePattern == null)
			{
			    throw new BOException (getText("INVALID_ENTRY"));
			}
		     	
		     	dateFormat = ",'"+datePattern+"')";
		     	
		     	Date dateValue;
			try
			{
			    dateValue = DateUtil.parseDate(data.trim(), datePattern);
			    //reapply formatting on date because in cases of wrong time eg: format HH and value above 24 then the time gets added to following day and the date returned from parseDate would be different
			    data = DateUtil.format(dateValue, datePattern);
			}
			catch(Exception e)
			{
			    throw new BOException (getText("INVALID_ENTRY"),e);
			}
		     	if(isSybase == 1)
			{
		     	    String tempPattern = datePattern.toLowerCase(Locale.ENGLISH); 
		     	    if(tempPattern.contains("hh") )//date with time
		     	    {
		     		String timeStr = tempPattern.substring(tempPattern.indexOf("hh"));
		     		String[] timeLen = timeStr.split(":");
		     		if(timeLen.length == 4) //with milliseconds
		     		{
		     		   data = DateUtil.format(dateValue,"MMM dd yyyy hh:mm:ss:SSSaaa");
		     		   searchQuery.append(field);
		     		   
		     		}
		     		else if (timeLen.length == 3) //with seconds
		     		{
		     		    data = DateUtil.format(dateValue,"dd/MM/yyyy hh:mm:ssaaa");
		     		    searchQuery.append("CONVERT(DATETIME,CONVERT(VARCHAR,"+field+",103) "+concatOperator+" ' ' "+concatOperator+" CONVERT(VARCHAR,"+field+",108),103)");
		     		}
		     		else if (timeLen.length == 2) //with minutes
		     		{
		     		    data = DateUtil.format(dateValue,"MMM dd yyyy hh:mmaaa");
		     		    searchQuery.append("CONVERT(DATETIME,dateadd(millisecond, -(datepart(millisecond, "+field+") + datepart(second, "+field+")*1000), "+field+"),103)"); 
		     		}
		     		else //with hour
		     		{
		     		    data = DateUtil.format(dateValue,"MMM dd yyyy hhaaa");
		     		    searchQuery.append("CONVERT(DATETIME,dateadd(millisecond, -(datepart(millisecond, "+field+") + datepart(second, "+field+")*1000 + datepart(minute, "+field+")*60000 ), "+field+"),103)"); 
		     		}
		     		data = "CONVERT(DATETIME,'".concat(data).concat("',103)");
		     	    }
		     	    else //no time
		     	    {
		     		data = DateUtil.format(dateValue,"dd/MM/yyyy");
		     		searchQuery.append("CONVERT(DATETIME,CONVERT(VARCHAR,"+field+",103),103)");
		     		data = "CONVERT(DATETIME,'".concat(data).concat("',103)");
		     	    }
			 }
			 else
			 {
				// replace Java format returned from getDatePattern to Oracle Format
				// 24 hours replacement
				dateFormat = dateFormat.replace("HH", "HH24");
				// minutes replacement
				dateFormat = dateFormat.replace("mm", "MI");
				
				//removing milliseconds only in case of oracle 
				if(dateFormat.indexOf("S") > -1)
				{
				    dateFormat = dateFormat.replace(":S", "S").replace("S", "");
				    data = data.substring(0,data.lastIndexOf(":"));
				}
				// AM/PM replacement
				dateFormat = dateFormat.replace("aaa", "AM");
				
				searchQuery.append(toDateToChar).append(" "+ field+ " "+ dateFormat).append(dateFormat);
				data = toDate.concat(" '").concat(data).concat("' ").concat(dateFormat);
			 }
		 }
		 else if(op.equals(equal) || op.equals(notEqual) || op.equals(beginsWith) || op.equals(notBeginsWith) || op.equals(endsWith)
			|| op.equals(notEndsWith) || op.equals(contains) || op.equals(notContains))
		 {
		     // if numeric
		     if((op.equals(equal) || op.equals(notEqual)) && isNumeric)
		     {
			 searchQuery.append(sybConvertOpen).append(" "+field+" ").append(sybConvertClose);
		     }
		     else
		     {
			searchQuery.append(leftSideComp).append(sybConvertOpen).append(" "+field+" ").append(sybConvertClose)
			    .append(endComp);
		     }
		}
   		else
   		{
   			searchQuery.append(" "+field);
   		}
		searchQuery.append(mapSearchOper(op, data, isSybase,colType)); 

	    }
	return searchQuery.toString();
}
    /*
     * operators: [ { op: "eq", text: "is equal to" }, { op: "ne", text:
     * "is not equal to" }, { op: "lt", text: "is less than" }, { op: "le",
     * text: "is less or equal to" }, { op: "gt", text: "is greater than" }, {
     * op: "ge", text: "is greater or equal to" }, { op: "bw", text:
     * "begins with" }, { op: "bn", text: "does not begin with" }, { op: "ew",
     * text: "ends with" }, { op: "en", text: "does not end with" }, { op: "cn",
     * text: "contains" }, { op: "nc", text: "does not contain" } ],
     */
    public String mapSearchOper(String op, String theData, int isSybase,String colType) throws BaseException
    {
	String likeUpperOpen = "LIKE UPPER (";
	String notLikeUpperOpen = "NOT " + likeUpperOpen;
        String concatOperator = "||";
	String sybConvertOpen = "";
	String sybConvertClose = "";
	String toDateStr = "to_date(";
	boolean isDateCol = false;
	boolean isNumericCol = false;
	String data = theData;
	// check if numeric is to lengthy
	if(!StringUtil.nullToEmpty(colType).isEmpty() && COLTYPE_NUMBER.equals(colType))
	{
	    if(NumberUtil.isNumber(data))
	    {
		//limit number of digits to avoid numeric overflow exception.
		if(theData.length()>70) 
		{
		    throw new BOException(getText("less_than_seventy_key"));
		}
	    }
	    isNumericCol = true;
	}
	
	if(isSybase == 1)
	{
	    sybConvertOpen = "CONVERT(VARCHAR, ";
	    if(isNumericCol)
	    {
		sybConvertOpen = "CONVERT(NUMERIC, ";
	    }
	    sybConvertClose = ")";
	    toDateStr = "CONVERT(DATE";
	    concatOperator = "+";
	}
	/**
	 * [MarwanMaddah]:
	 * To cover the cases where the selected column is a number to 
	 * to avoid the problem with the decimal points in case the value is end with zeros
	 * like ***.00 for example.
	 */
	else if(isNumericCol)
	{
	    sybConvertOpen = "TO_NUMBER(";
	    sybConvertClose = ")";
	}
	    
	if(data.replaceAll(" ", "").contains(toDateStr.replaceAll(" ", "")))
	{
	    isDateCol = true;
	}
	if(!isDateCol )
	{
	    data = data.replaceAll("'", "''");
	}

	if(op.equals(lessThan)) // is less than
	{
	    return " < " + data;
	}
	else if(op.equals(lessOrEqualTo)) // is less or equal to
	{
	    return " <= " + data;
	}
	else if(op.equals(greaterThan)) // is greater than
	{
	    return " > " + data;
	}
	else if(op.equals(greaterOrEqualTo)) // is greater or equal to
	{
	    return " >= " + data;
	}

	else if(op.equals(equal)) // is equal to
	{
	    if(!isDateCol)
	    {
		if(isNumericCol)
		{
		    return " = " + sybConvertOpen + "'" + data + "'" + sybConvertClose+" ";
		}
		else
		{
		    return " = UPPER (" + sybConvertOpen + "'" + data + "'" + sybConvertClose+" ) ";
		}
	    }
	    return " = " + data  ;
	}
	else if(op.equals(notEqual)) // is not equal to
	{
	    if(!isDateCol)
	    {
		if(isNumericCol)
		{
		    return " != " + sybConvertOpen + "'" + data + "'" + sybConvertClose+" ";
		}
		else
		{
		    return " != UPPER (" + sybConvertOpen + "'" + data + "'" + sybConvertClose+" ) ";
		}
	    }
	    return " != " + data ;
	}
	else if(op.equals(isNotNull)) // is not equal to
	{
	    return data+ " IS NOT NULL";
	}
	else if(op.equals(isNull)) // is not equal to
	{
	    return data+ " IS NULL";
	}
	else if(op.equals(beginsWith)) // begins with
	{
	    return likeUpperOpen + sybConvertOpen + "'" + data + "' "+concatOperator+" '%'" + sybConvertClose + ")";
	}
	else if(op.equals(notBeginsWith)) // does not begin with
	{
	    return notLikeUpperOpen + sybConvertOpen + "'" + data + "' "+concatOperator+" '%'" + sybConvertClose + ")";
	}
	else if(op.equals(endsWith)) // ends with
	{
	    return likeUpperOpen + sybConvertOpen + " '%' "+concatOperator+" '" + data + "'" + sybConvertClose + ")";
	}
	else if(op.equals(notEndsWith)) // does not ends with
	{
	    return notLikeUpperOpen + sybConvertOpen + "'%' "+concatOperator+" '" + data + "'" + sybConvertClose + ")";
	}
	else if(op.equals(contains)) // contains
	{
	    return likeUpperOpen + sybConvertOpen + "'%' "+concatOperator+" '" + data + "' "+concatOperator+" '%'" + sybConvertClose + ")";
	}
	else if(op.equals(notContains)) // does not contain
	{
	    return notLikeUpperOpen + sybConvertOpen + "'%' "+concatOperator+" '" + data + "' "+concatOperator+" '%'" + sybConvertClose + ")";
	}
	else if(op.equalsIgnoreCase(in) || op.equalsIgnoreCase(notIn) )
	 {// checking if the operator is In or not in (come from Webservice calls, not screen Grid)
	     String theCond = " IN ";
	     if(op.equalsIgnoreCase(notIn))
	     {
		 theCond = " NOT IN ";
	     }
	     data = data.trim();
	     // JSON sctring comes as list with ' or " delimiter for that need to replace them
	     if(data.startsWith("[") ||  data.startsWith("'") ||  data.startsWith("\""))
	     {
		 data = data.substring(1, data.length()-1).replace("','", ",");
	     }
	     
	     return theCond + "("+data+")";
	 }
	else
	{
	    return " = " + sybConvertOpen + "'" + data + "'" + sybConvertClose;
	}
    }

   

    /**
     * method to check whether to call the query of count, instead of the old
     * check getRecords added to support cases on search for resetting count and
     * number of pages
     * 
     * @param sc
     * @return
     */
    public boolean checkNbRec(GridParamsSC sc)
    {
	//rows=-1 or loadonce = true means no paging, viewrecords=false means total nb of records not to be displayed
	if((getRows() == -1 || "true".equals(getLoadOnce())) && ("false").equals(getViewRecords()))
	{
	    return false;
	}
	
	if(getRecords() == 0 || (getPage() == 1 && "false".equals(sc.get_search())))
	{
	    return true;
	}
	return false;
    }
    
    /**
     * Exports the grid into excel. This method is called when the user chooses
     * to export all the grid pages. For that aim, this method calls the grid
     * action class wrap the data in java list and then convert it to excel.
     * 
     * @return Excel file
     * 
     * @author Khaledhussein
     */
    public String exportGridToExcelAllPages()
    {
	try
	{
	    // Obtain a reference to the action of the GRID
	    GridBaseAction gridAction = (GridBaseAction) ActionContext.getContext().getActionInvocation().getAction();
	    Class<?> gridActionClass = gridAction.getClass();
	    // The method name that is originally called in the grid action,
	    // will use it to get the data
	    String methodName = gridMethodStr;
	    // The grid URL with all the needed parameters
	    String gridUrl = URLDecoder.decode(gridURLStr, FileUtil.DEFAULT_FILE_ENCODING);

	    if(StringUtil.isNotEmpty(methodName))
	    {
		// Get the method object
		Method methodToCall = gridActionClass.getMethod(methodName, new Class[] {});
		if(methodToCall != null)
		{
		    // prepare the data so that all the needed objects are set
		    prepareGridUrlParams(gridAction, gridUrl);
		    // No Paging
		    gridAction.setRows(-1);
		    // call the method
		    methodToCall.invoke(gridAction, new Object[] {});
		    // get the result list
		    List<?> resultList = gridAction.getGridModel();
		    // prepare the excel
		    prepareGenerateExcel(resultList);
		}
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		streamExcel = new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    }
	    catch(UnsupportedEncodingException e1)
	    {
		log.error(e1, "Error in reading the error message");
	    }
	    return EXPORT_EXCEL_ERR;
	}
	return EXPORT_EXCEL;
    }

    /**
     * Exports the grid into excel. This method is called when the user chooses
     * to export the current page.
     * 
     * @return Excel file
     * 
     * @author Khaledhussein
     */
    public String exportGridToExcel()
    {
	try
	{
	    // prepare the excel
	    prepareGenerateExcel(null);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    try
	    {
		streamExcel = new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    }
	    catch(UnsupportedEncodingException e1)
	    {
		log.error(e1, "Error in reading the error message");
	    }
	    return EXPORT_EXCEL_ERR;
	}
	return EXPORT_EXCEL;
    }

    /**
     * Prepare the data needed to generate the excel
     * 
     * @param jGridData
     * 
     * @throws Exception
     * 
     * @author Khaledhussein
     */
    @SuppressWarnings("unchecked")
    private void prepareGenerateExcel(List<?> jGridData) throws Exception
    {
	// Wrap all the needed data
	HashMap<String, Object> gridInfo = (HashMap<String, Object>) PathJSONUtil.deserialize(URLDecoder.decode(
		exportGridStr, FileUtil.DEFAULT_FILE_ENCODING));
	ArrayList<HashMap<String, Object>> gridGroupHeader = (ArrayList<HashMap<String, Object>>) gridInfo
		.get("gridGroupHeaders");
	ArrayList<HashMap<String, Object>> gridColModel = (ArrayList<HashMap<String, Object>>) gridInfo
		.get("gridColModel");
	Map<String, Object> gridFooter = (Map<String, Object>) gridInfo.get("gridFooter");
	ArrayList<String> gridColNames = (ArrayList<String>) PathJSONUtil.deserialize(URLDecoder.decode(
		gridColNamesStr, FileUtil.DEFAULT_FILE_ENCODING));

	Workbook workbook;

	if(jGridData == null || jGridData.isEmpty())
	{
	    ArrayList<HashMap<String, Object>> gridData = (ArrayList<HashMap<String, Object>>) gridInfo.get("gridData");
	    // generate the excel
	    workbook = generateGridExcelWorkbook(gridColNames, gridGroupHeader, gridColModel, gridData, gridFooter,
		    null);
	}
	else
	{
	    // generate the excel
	    workbook = generateGridExcelWorkbook(gridColNames, gridGroupHeader, gridColModel, null, gridFooter,
		    jGridData);
	}

	ByteArrayOutputStream bout = new ByteArrayOutputStream();
	workbook.write(bout);
	workbook.close();
	streamExcel = new ByteArrayInputStream(bout.toByteArray());

	bout.close();

	// IMP: this will call the success callback function
	ServletActionContext.getResponse().setHeader("Set-Cookie", "fileDownload=true; path=/");
    }

    /**
     * This method is responsible of writing excel based on the provided
     * paramters. <br/>
     * It checks if there is a group then it merges and writes group header
     * based on the given conditions. <br/>
     * It checks if there is a footer and write it. <br/>
     * It checks if the data are in java list object and applies respective
     * logic otherwise it applies the needed algorithm. <br/>
     * All the styles, fonts, and positionings are included in this function.
     * 
     * @param gridColNames the column names of the grid
     * 
     * @param gridGroupHeader the group header names with their positions
     * 
     * @param gridColModel model of the columns contain name, column type, and
     *            other info
     * 
     * @param gridData data provided form the grid (in case of exporting current
     *            page)
     * 
     * @param gridFooter the grid footer
     * 
     * @param jGridData data provided form the action of the grid ( in case of
     *            exporting all pages)
     * 
     * @return Excel file
     * 
     * @throws BaseException
     * 
     * @author Khaledhussein
     */
    @SuppressWarnings("unchecked")
    private Workbook generateGridExcelWorkbook(ArrayList<String> gridColNames,
	    ArrayList<HashMap<String, Object>> gridGroupHeader, ArrayList<HashMap<String, Object>> gridColModel,
	    ArrayList<HashMap<String, Object>> gridData, Map<String, Object> gridFooter, List<?> jGridData)
	    throws Exception
    {
	Workbook workbook = null;

	// font sizes
	final short fontHeaderSize = 10;
	final short fontContentSize = 9;

	// TODO add date instead of Data ??
	// The name of the sheet in the workbook
	final String sheetName = "DataExport";

	// for Temp file creation
	final String fileName = "DataExportExcel";
	final String fileExtension = ".xlsx";

	// Properties
	final String hiddenProp = "hidden";
	final String nameProp = "name";
	final String startColumnNameProp = "startColumnName";
	final String numberOfColumnsProp = "numberOfColumns";
	final String titleTextProp = "titleText";
	final String colTypeProp = "colType";
	final String indexProp = "index";

	// font
	final String fontName = "Calibri";

	streamFileName = fileName + fileExtension;

	// create the workbook (.xlsx)
	workbook = new XSSFWorkbook();

	// Generate a safe name for the sheet
	String safeName = WorkbookUtil.createSafeSheetName(sheetName);
	Sheet sheet = workbook.createSheet(safeName);

	// switch sheet to support RTL
	if(returnSessionObject().getIsRTLDir() == 1)
	{
	    sheet.setRightToLeft(true);
	}

	// flag to check the groups
	boolean isAnyGroup = (gridGroupHeader != null);

	// flag to check the groups
	boolean isAnyFooter = (gridFooter != null);

	// Create a header font
	Font headerFont = workbook.createFont();
	headerFont.setFontHeightInPoints(fontHeaderSize);
	headerFont.setFontName(fontName);
	headerFont.setBold(true);
	headerFont.setColor(IndexedColors.BLUE.getIndex());

	// Create a content font
	Font contentFont = workbook.createFont();
	contentFont.setFontHeightInPoints(fontContentSize);
	contentFont.setFontName(fontName);
	contentFont.setColor(IndexedColors.BLACK.getIndex());

	// Create Header Style
	CellStyle headerCellStyle = workbook.createCellStyle();
	headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
	headerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	headerCellStyle.setBorderBottom(CellStyle.BORDER_THIN);
	headerCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	headerCellStyle.setBorderLeft(CellStyle.BORDER_THIN);
	headerCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	headerCellStyle.setBorderRight(CellStyle.BORDER_THIN);
	headerCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
	headerCellStyle.setBorderTop(CellStyle.BORDER_THIN);
	headerCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
	headerCellStyle.setFont(headerFont);
	headerCellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
	headerCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

	// Create Content Style
	CellStyle contentCellStyle = workbook.createCellStyle();
	contentCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
	contentCellStyle.setBorderBottom(CellStyle.BORDER_THIN);
	contentCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	contentCellStyle.setBorderLeft(CellStyle.BORDER_THIN);
	contentCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	contentCellStyle.setBorderRight(CellStyle.BORDER_THIN);
	contentCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
	contentCellStyle.setBorderTop(CellStyle.BORDER_THIN);
	contentCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
	contentCellStyle.setFont(contentFont);

	// check if we will lookup java or string
	boolean isAllPages = gridData == null ? true : false;

	// Loop over GridColModel instead of names because names list
	// includes Hidden Fields
	if(gridColModel != null)
	{
	    // initialize counters
	    int col = 0, rowIndex = 0, colModelCounter = -1, removedColNamesCounter = 0;

	    // Cell represent the cell item
	    Cell cell;

	    // Apache POI support writing row by row only,
	    // thus create all rows for the data in array to access
	    // them accordingly
	    Row[] rows;

	    // Calculate the needed size (+1 for the label)
	    int size = 1 + (isAllPages ? jGridData.size() : gridData.size()) + (isAnyGroup ? 1 : 0)
		    + (isAnyFooter ? 1 : 0);
	    rows = new Row[size];

	    if(isAnyGroup)
	    {
		rows[rowIndex] = sheet.createRow(rowIndex);
		rowIndex++;
	    }

	    // create row for the title
	    rows[rowIndex] = sheet.createRow(rowIndex);

	    // Create hashmap to identify formatter for every column
	    // text, date, number
	    // and the index of the column
	    Map<String, Map<String, Object>> refColumns = new HashMap<String, Map<String, Object>>();
	    Map<String, Object> refs;

	    for(HashMap<String, Object> hm : gridColModel)
	    {
		colModelCounter++;
		// Skip hidden columns and delete hidden names
		if(hm.get(hiddenProp) != null && (Boolean) hm.get(hiddenProp))
		{
		    gridColNames.remove(colModelCounter - removedColNamesCounter);
		    removedColNamesCounter++;
		    continue;
		}
		String key = String.valueOf(hm.get(nameProp));
		if(isAnyGroup)
		{
		    for(HashMap<String, Object> ghm : gridGroupHeader)
		    {
			if(key.equals(ghm.get(startColumnNameProp)))
			{
			    String mergeToInt = ((Long) ghm.get(numberOfColumnsProp)).toString();

			    CellRangeAddress mergedRange = new CellRangeAddress(0, // first
				    // row
				    0, // last row
				    col, // first column (0-based)
				    (col + Integer.valueOf(mergeToInt) - 1) // last
			    // column
			    );

			    sheet.addMergedRegion(mergedRange);

			    // Group row
			    cell = rows[0].createCell(col);
			    cell.setCellValue(ghm.get(titleTextProp).toString());
			    cell.setCellStyle(headerCellStyle);

			    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, mergedRange, sheet, workbook);
			    RegionUtil.setBottomBorderColor(IndexedColors.BLACK.getIndex(), mergedRange, sheet,
				    workbook);
			    RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, mergedRange, sheet, workbook);
			    RegionUtil.setLeftBorderColor(IndexedColors.BLACK.getIndex(), mergedRange, sheet, workbook);
			    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, mergedRange, sheet, workbook);
			    RegionUtil
				    .setRightBorderColor(IndexedColors.BLACK.getIndex(), mergedRange, sheet, workbook);
			    RegionUtil.setBorderTop(CellStyle.BORDER_THIN, mergedRange, sheet, workbook);
			    RegionUtil.setTopBorderColor(IndexedColors.BLACK.getIndex(), mergedRange, sheet, workbook);

			    // Make search faster next time by decreasing
			    // the number of objects
			    gridGroupHeader.remove(ghm);
			    break;
			}
		    }
		}

		String title = gridColNames.get(col);
		cell = rows[rowIndex].createCell(col);
		cell.setCellValue(title);
		cell.setCellStyle(headerCellStyle);

		// Fill the columns with the type and the index
		String colType = hm.get(colTypeProp) == null ? "text" : hm.get(colTypeProp).toString();

		// identify if there is time
		Object formatOp = hm.get("formatoptions");
		if(formatOp != null)
		{
		    String format = ((HashMap<String, String>) formatOp).get("srcformat");
		    if(format != null && format.contains("H"))
		    {
			colType = "dateTime";
		    }
		}

		refs = new HashMap<String, Object>();
		refs.put(colTypeProp, colType);
		refs.put(indexProp, col);
		refColumns.put(key, refs);
		// Adjust the width
		sheet.autoSizeColumn(col);
		col++;
	    }

	    // For date columns
	    String dateMask = DateUtil.returnDateMask(returnSessionObject().getUserNbFormats());

	    // go to next row
	    rowIndex++;
	    if(isAllPages)
	    {
		for(Object o : jGridData)
		{
		    rows[rowIndex] = sheet.createRow(rowIndex);
		    for(Map.Entry<String, Map<String, Object>> entry : refColumns.entrySet())
		    {
			Object value = PathPropertyUtil.returnProperty(o, entry.getKey());
			String text = value == null ? "" : value.toString();
			Integer indexColumn = (Integer) entry.getValue().get(indexProp);

			String colType = entry.getValue().get(colTypeProp).toString();
			if("date".equals(colType))
			{
			    text = DateUtil.format((Date) value, dateMask);
			}
			else if("dateTime".equals(colType))
			{
			    text = DateUtil.format((Date) value, dateMask.concat(" HH:mm:ss"));
			}

			cell = rows[rowIndex].createCell(indexColumn);
			cell.setCellValue(text);
			cell.setCellStyle(contentCellStyle);
		    }
		    // iterate rows
		    rowIndex++;
		}
	    }
	    else
	    {
		for(HashMap<String, Object> dhm : gridData)
		{
		    rows[rowIndex] = sheet.createRow(rowIndex);

		    for(Map.Entry<String, Map<String, Object>> entry : refColumns.entrySet())
		    {
			String text = dhm.get(entry.getKey()) == null ? "" : dhm.get(entry.getKey()).toString();

			Integer indexColumn = (Integer) entry.getValue().get(indexProp);

			String colType = entry.getValue().get(colTypeProp).toString();
			
			/**
			 * [MarwanMaddah]
			 * #BUG 665860-when click on export to excel on plan of T023
			 * in case the text is null or empty , no need to enter in the date format process
			 */
			if(!StringUtil.nullToEmpty(text).isEmpty())
			{			    
			    if("date".equals(colType))
			    {
				text = DateUtil.format(DateUtil.parseDate(text, DateUtil.getDatePattern(text)), dateMask);
			    }
			    else if("dateTime".equals(colType))
			    {
				text = DateUtil.format(DateUtil.parseDate(text, DateUtil.getDatePattern(text)), dateMask
					.concat(" HH:mm:ss"));
			    }
			}

			cell = rows[rowIndex].createCell(indexColumn);
			cell.setCellValue(text);
			cell.setCellStyle(contentCellStyle);
		    }

		    // iterate rows
		    rowIndex++;

		}
	    }
	    // if any footer
	    if(isAnyFooter)
	    {
		// Create a footer font
		Font footerFont = workbook.createFont();
		footerFont.setFontHeightInPoints(fontContentSize);
		footerFont.setFontName(fontName);
		footerFont.setColor(IndexedColors.BLACK.getIndex());
		footerFont.setBold(true);

		// Create Footer Style
		CellStyle footerCellStyle = workbook.createCellStyle();
		footerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		footerCellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		footerCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		footerCellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		footerCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		footerCellStyle.setBorderRight(CellStyle.BORDER_THIN);
		footerCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		footerCellStyle.setBorderTop(CellStyle.BORDER_THIN);
		footerCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		footerCellStyle.setFont(footerFont);

		rows[rowIndex] = sheet.createRow(rowIndex);
		for(Map.Entry<String, Object> entry : gridFooter.entrySet())
		{
		    String key = entry.getKey();
		    String text = entry.getValue().toString();
		    Map<String, Object> refDt = refColumns.get(key);
		    // the grid footer contains hidden fields sometimes so
		    // better
		    // to check if there is a reference for it in the grid
		    // model
		    // before putting it into excel
		    if(refDt != null)
		    {
			Integer column = (Integer) refDt.get(indexProp);

			cell = rows[rowIndex].createCell(column);
			cell.setCellValue(text);
			cell.setCellStyle(footerCellStyle);
		    }
		}
	    }
	}

	return workbook;
    }

    /**
     * Utility method to wrap the grid url parameters
     * 
     * @param actionObject
     * @param gridUrl
     */
    private void prepareGridUrlParams(Object actionObject, String gridUrl)
    {
	if(gridUrl.contains("?"))
	{
	    String paramString = gridUrl.substring(gridUrl.lastIndexOf("?") + 1, gridUrl.length() - 1);
	    if(StringUtil.isNotEmpty(paramString))
	    {
		String[] parameters = paramString.split("&");
		Map<String, Object> contextMap = ActionContext.getContext().getContextMap();
		XWorkConverter converter = ActionContext.getContext().getContainer().getInstance(XWorkConverter.class);
		Map<String, Object> ognlUtilMap = new HashMap<String, Object>();
		OgnlUtil ognlUtil = new OgnlUtil();

		for(String parameter : parameters)
		{
		    if(!parameter.contains("="))
		    {
			continue;
		    }
		    String[] paramDetails = parameter.split("=", -1);
		    String paramName = paramDetails[0];
		    String paramValue = paramDetails[1];

		    Map<String, Class<?>> returnMap = returnPropertyTypeInAction(actionObject, paramName);
		    if(returnMap != null && !returnMap.isEmpty())
		    {
			String actionParamName = returnMap.keySet().iterator().next();
			Class<?> actionParamClass = returnMap.get(actionParamName);

			if(StringUtil.isNotEmpty(actionParamName) && actionParamClass != null)
			{
			    Object paramObjectValue = converter.convertValue(contextMap, paramValue, actionParamClass);
			    if(paramObjectValue != null)
			    {
				try
				{
				    ognlUtil.setValue(actionParamName, ognlUtilMap, actionObject, paramObjectValue);
				}
				catch(Exception e)
				{
				    handleException(e, "[prepareGridUrlParams] Error while setting parameter "
					    + actionParamName, null);
				}
			    }
			}
		    }
		}
	    }
	}
    }

    /**
     * Utility method to return the type of the object
     * 
     * @param actionObject
     * @param propertyName
     * @return
     */
    private Map<String, Class<?>> returnPropertyTypeInAction(Object actionObject, String propertyName)
    {
	if(actionObject != null && StringUtil.isNotEmpty(propertyName))
	{
	    Map<String, Class<?>> returnMap = new HashMap<String, Class<?>>();
	    Class<?> propertyType = null;

	    if(propertyName.startsWith("model."))
	    {
		propertyType = PathPropertyUtil.returnPropertyType(actionObject, propertyName);
		returnMap.put(propertyName, propertyType);
	    }
	    else
	    {
		String modelPropertyName = "model.".concat(propertyName);
		propertyType = PathPropertyUtil.returnPropertyType(actionObject, modelPropertyName);
		if(propertyType == null)
		{
		    propertyType = PathPropertyUtil.returnPropertyType(actionObject, propertyName);
		    returnMap.put(propertyName, propertyType);
		}
		else
		{
		    returnMap.put(modelPropertyName, propertyType);
		}
	    }
	    return returnMap;
	}
	else
	{
	    return null;
	}
    }

    public String getId()
    {
	return id;
    }

    public void setId(String id)
    {
	this.id = id;
    }

 
    public String getNodeid()
    {
	return nodeid;
    }

    public void setNodeid(String nodeid)
    {
	this.nodeid = nodeid;
    }

    public HashMap getUserdata()
    {
        return userdata;
    }

    public void setUserdata(HashMap userdata)
    {
        this.userdata = userdata;
    }

    public String getViewRecords()
    {
        return viewRecords;
    }

    public void setViewRecords(String viewRecords)
    {
        this.viewRecords = viewRecords;
    }

    public String getLoadOnce()
    {
        return loadOnce;
    }

    public void setLoadOnce(String loadOnce)
    {
        this.loadOnce = loadOnce;
    }

    /**
     * @return the streamExcel
     */
    public InputStream getStreamExcel()
    {
	return streamExcel;
    }

    /**
     * @param streamExcel the streamExcel to set
     */
    public void setStreamExcel(InputStream streamExcel)
    {
	this.streamExcel = streamExcel;
    }

    /**
     * @return the streamFileName
     */
    public String getStreamFileName()
    {
	return streamFileName;
    }

    /**
     * @param streamFileName the streamFileName to set
     */
    public void setStreamFileName(String streamFileName)
    {
	this.streamFileName = streamFileName;
    }

    /**
     * @return the exportGridStr
     */
    public String getExportGridStr()
    {
	return exportGridStr;
    }

    /**
     * @param exportGridStr the exportGridStr to set
     */
    public void setExportGridStr(String exportGridStr)
    {
	this.exportGridStr = exportGridStr;
    }

    /**
     * @return the gridColNamesStr
     */
    public String getGridColNamesStr()
    {
	return gridColNamesStr;
    }

    /**
     * @param gridColNamesStr the gridColNamesStr to set
     */
    public void setGridColNamesStr(String gridColNamesStr)
    {
	this.gridColNamesStr = gridColNamesStr;
    }

    /**
     * @return the gridURLStr
     */
    public String getGridURLStr()
    {
	return gridURLStr;
    }

    /**
     * @param gridURLStr the gridURLStr to set
     */
    public void setGridURLStr(String gridURLStr)
    {
	this.gridURLStr = gridURLStr;
    }

    /**
     * @return the gridMethodStr
     */
    public String getGridMethodStr()
    {
	return gridMethodStr;
    }

    /**
     * @param gridMethodStr the gridMethodStr to set
     */
    public void setGridMethodStr(String gridMethodStr)
    {
	this.gridMethodStr = gridMethodStr;
    }
}
