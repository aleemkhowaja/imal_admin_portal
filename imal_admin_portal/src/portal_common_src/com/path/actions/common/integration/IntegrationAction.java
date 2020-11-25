package com.path.actions.common.integration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.PluginsConstants;
import com.path.dbmaps.vo.DMS_SEARCH_INDEXVO;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.integration.DmsRequestSC;
import com.path.dbmaps.vo.DMS_SEARCH_INDEX_HEADERVO;
import com.path.dbmaps.vo.DMS_USER_MAPVO;
import com.path.dbmaps.vo.PTH_CTRLVO;
import com.path.lib.common.exception.BOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class IntegrationAction extends BaseAction
{
    private String theURL;
    private String intType;
    //#514292 AIB - Docuware Integration
    //change the variables from string arrays to detailed JSON string
    private String mainJsonString;

    private String dmsType;
    
    //782723 third party app arguments
    private String theArgs;
    //782723 CLSID for Application Launcher
    private String appLnchrCLSID = PluginsConstants.returnAppLnchrCLSID();
    //782723 Version for Application Launcher
    private String appLnchrVersion = PluginsConstants.returnAppLnchrVersion();
    
    public String loadServiceDialog()
    {
	return "loadDialog";
    }
    
    public String returnDmsSearchIndexFields()
    {
	try
	{
		SessionCO sesCO = returnSessionObject();
		DmsRequestSC criteria = new DmsRequestSC();
		//Use original progRef in case of dynamic screen.
		criteria.setProgRef(returnCommonLibBO().returnOrginProgRef(sesCO.getCurrentAppName(), get_pageRef()));
		criteria.setAppName(sesCO.getCurrentAppName());
		criteria.setCompCode(sesCO.getCompanyCode());
		criteria.setBranchCode(sesCO.getBranchCode());
		criteria.setUserId(sesCO.getUserName());

		ArrayList<DMS_SEARCH_INDEXVO> searchIndexList;

		//#514292 AIB - Docuware Integration
		//Set the dms details flag to be passed to the query
		criteria.setDmsDetailsParams(Integer.parseInt(StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile(
				"PathRemoting.properties", ConstantsCommon.DMS_DETAILED_PARAMS), ConstantsCommon.ZERO)));
		searchIndexList = (ArrayList<DMS_SEARCH_INDEXVO>) returnCommonLibBO().returnDMSIndexFieldNames(criteria);

		//#514292 AIB - Docuware Integration
		//Loop through the JSON Object and set the dms index mapping
		JSONArray imalArr = new JSONArray();
		JSONObject mainJson = new JSONObject();

		for(int i = 0 ; i< searchIndexList.size() ; i++)
		{
			JSONObject imalIndex = new JSONObject();
			JSONObject dmsIndex = new JSONObject();
			JSONArray dmsArr = new JSONArray();

			DMS_SEARCH_INDEXVO dmsSearchIndex = searchIndexList.get(i);

			dmsIndex.put("screenID", dmsSearchIndex.getSCREEN_ID());
			dmsIndex.put("colOrder", dmsSearchIndex.getORDER_VALUE());
			if(ConstantsCommon.DMS_EXPRESSION_FIELD_TYPE.equals(dmsSearchIndex.getELEMENT_TYPE()))
			{
				dmsIndex.put("expCode", dmsSearchIndex.getDMS_INDEX_NAME());
				dmsIndex.put("expCols", dmsSearchIndex.getEXPRESSION_COLUMNS());
				String[] expColsArr =  dmsSearchIndex.getEXPRESSION_COLUMNS().split(",");
				for (String e : expColsArr)
				{
					dmsIndex.put("name", e);
					dmsIndex.put("id", e);
					dmsIndex.put("type", dmsSearchIndex.getELEMENT_TYPE());
					dmsIndex.put("value",""); 
					dmsIndex.put("screenID", dmsSearchIndex.getSCREEN_ID());
					dmsIndex.put("colOrder", dmsSearchIndex.getORDER_VALUE());
					dmsArr.add(dmsIndex);
					imalIndex.put("name", dmsSearchIndex.getIMAL_INDEX_NAME());
					imalIndex.put("num", dmsSearchIndex.getDMS_INDEX_NUM());
					imalIndex.put("DMS_INDEX", dmsArr);
					imalArr.add(imalIndex);
					imalIndex = new JSONObject();
					dmsIndex = new JSONObject();
					dmsArr = new JSONArray();
				}
			}
			else
			{
				dmsIndex.put("name", dmsSearchIndex.getDMS_INDEX_NAME());
				dmsIndex.put("id", dmsSearchIndex.getCOLUMN_NAME());
				dmsIndex.put("type", dmsSearchIndex.getELEMENT_TYPE());
				dmsIndex.put("value","");
				dmsIndex.put("screenID", dmsSearchIndex.getSCREEN_ID());
				dmsIndex.put("colOrder", dmsSearchIndex.getORDER_VALUE());
				dmsArr.add(dmsIndex);
				imalIndex.put("name", dmsSearchIndex.getIMAL_INDEX_NAME());
				imalIndex.put("num", dmsSearchIndex.getDMS_INDEX_NUM());
				imalIndex.put("DMS_INDEX", dmsArr);
				imalArr.add(imalIndex);
			}
		}
		mainJson.put("IMAL_DMS_INDEX", imalArr);
		mainJsonString = mainJson.toString();
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return "jsonSuccess";
    }

    public String returnServiceLink()
    {
	try
	{
	    //#514292 AIB - Docuware Integration
	    //Loop through the JSON Object and get the dms index values
	    JSONObject mainJsonObject = (JSONObject) JSONSerializer.toJSON(mainJsonString);
	    JSONArray imalArr = mainJsonObject.getJSONArray("IMAL_DMS_INDEX");
	    HashMap<String, HashMap<String, String>> dmsIndexMap = new HashMap<String, HashMap<String, String>>();
	    SessionCO sesCO = returnSessionObject();
	    ArrayList<String> indexFieldNames = new ArrayList<String>();
	    ArrayList<String> indexFieldValues = new ArrayList<String>();

	    int dmsDetOn = Integer.parseInt(StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile(
			"PathRemoting.properties", ConstantsCommon.DMS_DETAILED_PARAMS), ConstantsCommon.ZERO));
	    HashMap<String, String> dmsDetails = new HashMap<String, String>();
	    String infinityScreenId ="";
	    //635576 FIBSI170005 - integration with e-file Archiving start
	    PTH_CTRLVO controlMap = returnCommonLibBO().returnPthCtrl();
	    boolean isInfinity = ConstantsCommon.DMS_TYPE_INFINITY.compareTo(controlMap.getDMS_TYPE()) == 0;
	    String archiveParamVal = "";
	    //635576 FIBSI170005 - integration with e-file Archiving end
	    for(int i = 0; i < imalArr.size(); i++)
	    {
		JSONObject imalIndex = (JSONObject) imalArr.get(i);
		JSONArray dmsArr = imalIndex.getJSONArray("DMS_INDEX");
		int colOrder = 0;
		for(int j = 0; j < dmsArr.size(); j++)
		{
		    JSONObject dmsIndex = (JSONObject) dmsArr.get(j);
		    colOrder++;
		    String dmsIndexName = isInfinity? StringUtil.nullEmptyToValue(dmsIndex.getString("colOrder"), colOrder).toString():dmsIndex.getString("name");
		    indexFieldNames.add(dmsIndex.getString("name"));
		    if(isInfinity)
		    {
		    	infinityScreenId = dmsIndex.getString("screenID");
		    }
		    if(ConstantsCommon.TWO.equals(String.valueOf(dmsIndex.get("type"))))
		    {
			Object indexObj = PathPropertyUtil.returnProperty(sesCO, dmsIndex.getString("id"));
			if(indexObj instanceof BigDecimal)
			{
			    indexObj = ((BigDecimal) indexObj);
			    //635576 FIBSI170005 - integration with e-file Archiving start
			    if(ConstantsCommon.DMS_TYPE_E_ARCHIVE.compareTo(controlMap.getDMS_TYPE()) == 0)
			    {
				archiveParamVal = archiveParamVal.concat(indexObj == null ? "" : indexObj.toString().concat("-"));
			    }
			    //635576 FIBSI170005 - integration with e-file Archiving end
			}
			// set the date in BPM as a String with dd/MM/yyyy format
			if(indexObj instanceof Date)
			{
			    indexObj = DateUtil.format((Date) indexObj);
			}
			String indexValue = indexObj == null ? "" : indexObj.toString();
			dmsDetails.put(dmsIndexName, indexValue);
			indexFieldValues.add(indexValue);
		    }
		    else if(ConstantsCommon.DMS_EXPRESSION_FIELD_TYPE.compareTo(new BigDecimal(StringUtil.nullEmptyToValue(dmsIndex.get("type"), "-1"))) == 0)
		    {
		    	String expCode = String.valueOf(dmsIndex.get("expCode"));
		    	String expColsString = String.valueOf(dmsIndex.get("expCols"));
		    	if(StringUtil.isNotEmpty(expCode) && StringUtil.isNotEmpty(expColsString))
		    	{
			    	String indexValue = "";
		    		ArrayList<Map<String, Object>> expCriteria = new ArrayList<Map<String, Object>>();
		    		String [] expColsArr = expColsString.split(",");
		    		HashMap<String, Object> dmsExpression = new HashMap<String, Object>();
		    		Object indexExpObj;
		    		
		    		for (String e : expColsArr)
		    		{
		    			if(StringUtil.nullToEmpty(e).toUpperCase().endsWith("[GLB]"))
		    			{
		    				e = e.substring(0, e.length()-5);
		    				indexExpObj = PathPropertyUtil.returnProperty(sesCO, e);
		    			}
		    			else
		    			{
		    				indexExpObj = dmsIndex.get("value");
		    			}
		    			dmsExpression.put(e, indexExpObj);
		    		}
		    		expCriteria.add(dmsExpression);

		    		indexExpObj = returnCommonLibBO().executeExpression(expCode, 0, expCriteria);
					if(indexExpObj instanceof BigDecimal)
					{
						BigDecimal indexExpObjDec = ((BigDecimal) indexExpObj);
						archiveParamVal = archiveParamVal.concat(indexExpObj == null ? "" : indexExpObjDec.toPlainString());
						indexValue = indexExpObj == null ? "" : indexExpObjDec.toPlainString();
					}
					else if(indexExpObj instanceof Date)
					{
						String indexExpObjVal = DateUtil.format((Date) indexExpObj);
						indexValue = indexExpObj == null ? "" : indexExpObjVal;
					}
					else
					{
						indexValue = indexExpObj == null ? "" : indexExpObj.toString();
					}
					if(StringUtil.isNotEmpty(indexValue))
					{
						dmsDetails.put(StringUtil.nullEmptyToValue(dmsIndex.getString("colOrder"), colOrder), indexValue);
					}
		    	}
		    }
		    else
		    {
			dmsDetails.put(dmsIndexName, dmsIndex.getString("value"));
			indexFieldValues.add(dmsIndex.getString("value"));			    
			// 635576 FIBSI170005 - integration with e-file Archiving start
			if(ConstantsCommon.DMS_TYPE_E_ARCHIVE.compareTo(controlMap.getDMS_TYPE()) == 0
				&& StringUtil.isNotEmpty(dmsIndex.getString("value")))
			{
			    archiveParamVal = archiveParamVal.concat(dmsIndex.getString("value")).concat("-");
			}
			// 635576 FIBSI170005 - integration with e-file Archiving end
		    }
		}
		//Check if the dms details flag is on and if the index num is available
		if(dmsDetOn == 1 && imalIndex.has("num"))
		{
		    String imalIndexNum = imalIndex.getString("num"); // As advised by CSM team the key to be used is the DMS_INDEX_NUM and not NAME.
		    dmsIndexMap.put(imalIndexNum, dmsDetails);
		    
		}

	    }
	    DmsRequestSC criteria = new DmsRequestSC();
	    criteria.setProgRef(returnCommonLibBO().returnOrginProgRef(sesCO.getCurrentAppName(), get_pageRef()));
	    criteria.setCompCode(sesCO.getCompanyCode());
	    criteria.setBranchCode(sesCO.getBranchCode());
	    criteria.setAppName(sesCO.getCurrentAppName());
	    criteria.setUserId(sesCO.getUserName());
	    
	    // Check if the dms details flag is on
	    if(dmsDetOn == 1)
	    {
		criteria.setIndexMap(dmsIndexMap);
	    }
	    else
	    {
		String[] names = indexFieldNames.toArray(new String[0]);
		String[] values = indexFieldValues.toArray(new String[0]);

		criteria.setIndexFieldName(names);
		criteria.setIndexFieldValue(values);
	    }
	    
	    
	    if(ConstantsCommon.DMS_TYPE_E_ARCHIVE.compareTo(controlMap.getDMS_TYPE()) == 0)
	    {
		String archiveURL = controlMap.getWS_LOCATION();
		if(StringUtil.isNotEmpty(archiveURL))
		{
		    	archiveURL = archiveURL.lastIndexOf("/") == archiveURL.length()-1? archiveURL :archiveURL.concat("/");
			DMS_SEARCH_INDEX_HEADERVO headerVO = new DMS_SEARCH_INDEX_HEADERVO();
			headerVO.setAPP_NAME(sesCO.getCurrentAppName());
			headerVO.setPROG_REF(returnCommonLibBO().returnOrginProgRef(sesCO.getCurrentAppName(), get_pageRef()));
			headerVO = returnCommonLibBO().returnDMSIndexFieldHeader(headerVO);
			
			if(headerVO != null && StringUtil.isNotEmpty(headerVO.getE_FILE_URL()))
			{
			    archiveURL = archiveURL.concat(headerVO.getE_FILE_URL());
			}
			else
			{
			    throw new BOException("E-File URL, is missing!");
			}

			archiveURL = archiveURL.replace("//","/");

			archiveURL = archiveURL.replace("http:/","http://");

			archiveURL = archiveURL.replace("https:/","https://");
			
			archiveURL = archiveURL.indexOf("?") < 0? archiveURL.concat("?"):archiveURL; 

			archiveURL = archiveURL.lastIndexOf("FLD_1=") == archiveURL.length()-6? archiveURL : archiveURL.concat("&FLD_1=");
			
			archiveParamVal = archiveParamVal.lastIndexOf("-") == archiveParamVal.length()-1? archiveParamVal.substring(0, archiveParamVal.length() - 1):archiveParamVal;
			
			archiveURL = archiveURL.concat(archiveParamVal);
		}
		else
		{
		    throw new BOException("E-File Server Name/Port, is missing!");
		}
		setDmsType(ConstantsCommon.DMS_TYPE_E_ARCHIVE.toString());
		setTheURL(archiveURL);
	    }
	    else if(ConstantsCommon.DMS_TYPE_INFINITY.compareTo(controlMap.getDMS_TYPE()) == 0)
	    {
	    	DMS_USER_MAPVO userMap = new DMS_USER_MAPVO();
	    	userMap.setUSER_ID(sesCO.getUserName());
	    	userMap = returnCommonLibBO().returnDMSUserMap(userMap);
	    	String thirdPartyAppName = controlMap.getWS_LOCATION();
	    	if(StringUtil.isEmptyString(thirdPartyAppName))
	    	{
			    throw new BOException("Third party application name (Infinite DMS - Exe Name), is missing!");
	    	}
	    	int paramCount = dmsDetails.size();
	    	String argsString = StringUtil.nullToEmpty(infinityScreenId).concat(",").concat(controlMap.getDMS_TREE_ID().toString()).concat(",").concat(userMap.getNAME_ENGLISH()).concat(",").concat(userMap.getNAME_ARABIC()).concat(",").concat(String.valueOf(paramCount));
	    	
	    	for (String key: dmsDetails.keySet())
	    	{
	    		argsString += ","+dmsDetails.get(key);
	    	}
			setDmsType(ConstantsCommon.DMS_TYPE_INFINITY.toString());
	    	setTheURL(thirdPartyAppName);
	    	setTheArgs(argsString);
	    }
	    else
	    {
		    String serviceURL = returnCommonLibBO().returnServiceLink(criteria);

		    if(StringUtil.isNotEmpty(serviceURL))
		    {
			setTheURL(serviceURL);
		    }
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return "jsonSuccess";
    }

    public String getTheURL()
    {
        return theURL;
    }
    public void setTheURL(String theURL)
    {
        this.theURL = theURL;
    }
    public String getIntType()
    {
        return intType;
    }
    public void setIntType(String intType)
    {
        this.intType = intType;
    }

    public String getMainJsonString()
    {
        return mainJsonString;
    }

    public void setMainJsonString(String mainJsonString)
    {
        this.mainJsonString = mainJsonString;
    }
    public String getDmsType()
    {
        return dmsType;
    }

    public void setDmsType(String dmsType)
    {
        this.dmsType = dmsType;
    }

	public String getTheArgs() {
		return theArgs;
	}

	public void setTheArgs(String theArgs) {
		this.theArgs = theArgs;
	}

	public String getAppLnchrCLSID() {
		return appLnchrCLSID;
	}

	public void setAppLnchrCLSID(String appLnchrCLSID) {
		this.appLnchrCLSID = appLnchrCLSID;
	}

	public String getAppLnchrVersion() {
		return appLnchrVersion;
	}

	public void setAppLnchrVersion(String appLnchrVersion) {
		this.appLnchrVersion = appLnchrVersion;
	}


}
