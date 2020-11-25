/**
 * @Auther:MarwanMaddah
 * @Date:Jan 13, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.struts2.taglib;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.components.UIBean;
import org.apache.struts2.util.TextProviderHelper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.dbmaps.vo.SYS_PARAM_ELEM_ACTIVITIESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.CustomElementActivitiesSC;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;

public class PathAccount extends UIBean // component
{
    public static final String PATH_TEMPLATE = "pathaccount";
    public static final String PATH_THEME = "path-xhtml";
    private String inputIds;
    private String inputNames;
    private String toolTipKeys;
    private String accountLabel;
    private String readOnly;
    private String readOnlyMode;
    private String leadZeros;
    private String rowLocation;
    private String colSpan;
    private String onchange;
    private String onblur;
    private String ondblclick;
    private String maxlen; //for max length specification

    private Boolean readonly;
    private String dependency;
    private String dependencySrc;
    private String afterDepEvent;
    private String beforeDepEvent;
    private String parameter;
    private String mode;
    private String nbFormat;

    private String size;
    private String inputSizes;
    private String cssStyle;
    private String fromAccount;
    private String overrideLabelTextStr = "";
    private String overrideLabelKeyStr = "";
    private String cssDisp = "";
    private String additionalLabels;
    private String fieldAudit;
    
    private String required;
    private String dontLoadData;//TP 887297 dont Load Data for livesearch feature

    /**
     * Specify the action name of Action Class(Implementer should define the
     * class) which needs to get invoked while clicking the lookup button of the
     * dialog.
     * 
     */

    private String actionName;
    /**
     * Using for where clause parameters (ColumnName:ComponentId) Column Name =
     * DbColumnName and ComponentId = Id of the component(ie, textfield,textarea
     * etc...)
     */

    private String paramList;
    /**
     * Using for setting the data (Once the record is selected in the grid and
     * clicks OK button of the lookup component) into corresponding components
     * like textfield,textarea,etc...(ColumnName:Component Id) Column Name = The
     * column name (column header) Component Id = The id of the component in
     * which the value get set.
     */
    private String resultList;
    /**
     * Name of the function which needs to call while clicking OK button of the
     * dialog (The implementer should write the function). If no functions
     * specified then the component will take the value of outputparam and fill
     * the content automatically
     */
    private String onOk;

    /**
     * Name of the function which needs to call while clicking CANCEL button of
     * the dialog (The implementer should write the function). If no functions
     * specified then the component will take the value of outputparam and fill
     * the content automatically
     */
    private String onCancel;
    private String searchElement;
    private String multiSelect = "false";
    private String selectColumn;
    /**
     * The auto search element by default it is off.If it is true then it will
     * open the search window directly once clicks on the text field
     */
    private String autoSearch = "false";

    private String validateAction;

    private String nameValues;
    private String inputsOrder;
    
    private final static List<String> mainAccLst = Arrays.asList("br", "cy", "gl", "cif", "sl");

    /**
     * 
     */

    public PathAccount(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    @Override
    public void evaluateExtraParams()
    {
	super.evaluateExtraParams();
	String[] readOnlyArr = null;
	String[] requiredArr = null;
	String[] maxLengthArr = null;
	StringBuffer addLabelsKeys = new StringBuffer();
	if(inputIds != null)
	{
	    addParameter("inputIds", findString(inputIds));
	}
	if(inputNames != null)
	{
	    addParameter("inputNames", findString(inputNames));
	}
	
	/**
	 * additional field management 
	 */
	if(StringUtil.nullToEmpty(additionalLabels).isEmpty())
	{
	    additionalLabels = "N~N~N~N~N~N~Account_Name_key~account_cy_key~Account_Type_key~account_cif_key" ; 
	}

	
	if(readOnly != null)
	{
	    readOnlyArr = readOnly.split("~");
	    addParameter("readOnly", findString(readOnly));
	}
	if(required != null)
	{
	    requiredArr = required.split("~");
	    
	}
	if(maxlen == null)
	{
	    maxlen = "4~3~6~8~3~34~N";
	}
	maxLengthArr = maxlen.split("~");
	addParameter("maxLen", findString(maxlen));
	
	if(leadZeros == null)
	{
	    leadZeros = "4~3~6~8~3~N~N";
	}
	addParameter("leadZeros", findString(leadZeros));
	
	if(rowLocation != null)
	{
	    addParameter("rowLocation", findString(rowLocation));
	}
	if(colSpan != null)
	{
	    addParameter("colSpan", findString(colSpan));
	}
	if(onchange != null)
	{
	    addParameter("onchange", findString(onchange));
	}
	if(onblur != null)
	{
	    addParameter("onblur", findString(onblur));
	}

	if(ondblclick != null)
	{
	    addParameter("ondblclick", findString(ondblclick));
	}
	if(dependency != null)
	{
	    String escapedDep = findString(dependency);
	    escapedDep = StringUtil.removeNewLineTabSpace(escapedDep);
	    addParameter("dependency", escapedDep);
	}
	if(dependencySrc != null)
	{
	    String escapedDep = findString(dependencySrc);
	    escapedDep = StringUtil.removeNewLineTabSpace(escapedDep);
	    addParameter("dependencySrc", escapedDep);
	}
	if(afterDepEvent != null)
	{
	    addParameter("afterDepEvent", findString(afterDepEvent));
	}
	if(beforeDepEvent !=null)
	{
	    addParameter("beforeDepEvent", findString(beforeDepEvent));
	}
	if(parameter != null)
	{
	    String escapedDep = findString(parameter);
	    escapedDep = StringUtil.removeNewLineTabSpace(escapedDep);
	    addParameter("parameter", escapedDep);
	}
	if(accountLabel != null)
	{
	    addParameter("accountLabel", findString(accountLabel));
	}
	if(inputSizes != null)
	{
	    addParameter("inputSizes", findString(inputSizes));
	}
	if(mode == null)
	{
	    addParameter("mode", "number");
	}
	else
	{
	    addParameter("mode", findString(mode));
	}

	if(actionName != null)
	{
	    String escapedAct = findString(actionName);
	    escapedAct = StringUtil.removeNewLineTabSpace(escapedAct);
	    addParameter("actionName", escapedAct);
	}
	if(paramList != null)
	{
	    String escapedDep = findString(paramList);
	    escapedDep = StringUtil.removeNewLineTabSpace(escapedDep);
	    addParameter("paramList", escapedDep);
	}
	if(resultList != null)
	{
	    addParameter("resultList", findString(resultList));
	}
	if(onOk != null)
	{
	    addParameter("onOk", findString(onOk));
	}
	if(onCancel != null)
	{
	    addParameter("onCancel", findString(onCancel));
	}
	if(searchElement != null)
	{
	    addParameter("searchElement", findString(searchElement));
	}
	if(multiSelect != null)
	{
	    addParameter("multiSelect", findString(multiSelect));
	}
	if(selectColumn != null)
	{
	    addParameter("selectColumn", findString(selectColumn));
	}
	if(validateAction != null)
	{
	    addParameter("validateAction", findString(validateAction));
	}
	//TP 887297 dont Load Data for livesearch feature
	if(dontLoadData != null)
	{
	    addParameter("dontLoadData", findString(dontLoadData));
	}
	
	if(inputsOrder == null)
	{
	    inputsOrder = "br~cy~gl~cif~sl~ref";
	}
	addParameter("inputsOrder", findString(inputsOrder));

	addParameter("readonly", false);
	addParameter("readOnlyMode", false);
	addParameter("nbFormat", "");
	addParameter("cssStyle", "");
	addParameter("cssClass","");
	addParameter("fromAccount", true);
	addParameter("name", "");
	// setting as empty to be able to fill in FTL
	addParameter("title", "");
	addParameter("maxlength", "");
	addParameter("nameValue", "");
	addParameter("overrideLabelText","");
	addParameter("overrideLabelKey","");
	addParameter("inputOrder","");
	// addParameter("tabindex", "");
	addParameter("contextPath", request.getContextPath());

	StringBuffer toolTipNames = new StringBuffer();	
	StringBuffer fieldDescNames = new StringBuffer();
	String[] toolTipKeysLst = null;
	if(toolTipKeys != null)
	{
	    toolTipKeysLst = toolTipKeys.split("~");
	}

	String[] lst            = inputNames.split("~");
	String[] idLst          = inputIds.split("~"); // getting array of ids
	String[] modeLst        = mode.split("~"); // getting array of modes
	String[] inputsOrderLst = StringUtil.nullToEmpty(inputsOrder).split("~"); // getting array of ids
	int idSize              = idLst.length;
	int modeSize            = modeLst.length;
	StringBuffer temp             = new StringBuffer();
	String tempId, tempMode;
	StringBuffer tempReadOnly = new StringBuffer();
	StringBuffer tempRequired = new StringBuffer();
	StringBuffer tempMaxLngth = new StringBuffer();
	boolean hideAccount = false;
	
	String[] onchangeArray =  initializeArray(lst.length, "N");
	String[] onchangeProvidedArray = StringUtil.nullToEmpty(onchange).split("~");
	if (onchangeProvidedArray.length >= onchangeArray.length)
	{
	    System.arraycopy(onchangeProvidedArray, 0, onchangeArray, 0, lst.length);
	}
	String[] customBtnDataArray =  initializeArray(lst.length, "N");
	String[] customKeyEventBtnDataArray =  initializeArray(lst.length, "N");
	
	
	for(int i = 0; i < lst.length; i++)
	{
	    tempId = null;
	    if(i < idSize) // means id exists for this name
	    {
		tempId = idLst[i];
		// if live search mode then adjust id
		if(i < modeSize)
		{
		 tempMode = modeLst[i];
		 if("livesearch".equalsIgnoreCase(tempMode))
		 {
		     tempId = "lookuptxt_".concat(tempId);
		 }
		}
	    }
	    // get required/readonly/visible attributes for each element name
	    SYS_PARAM_SCREEN_DISPLAYVO theVO = RootUtil.returnParamScreenDisplay(request, lst[i],tempId);
	    if(theVO == null)// vo not found in SYS_PARAM_SCREEN_DISPLAY
	    {
		if(!hideAccount)
		{
		    if(!cssDisp.isEmpty())
		    {
			cssDisp += "~";
		    }
		    cssDisp += "N";
		}
		
		if(readOnlyArr != null && readOnlyArr.length > i)
        	    {
        		if(!tempReadOnly.toString().isEmpty())
        		{
        		    tempReadOnly.append("~");
        		}
        		tempReadOnly.append(readOnlyArr[i]);
        	    }
		
		// required filling
		String curRecValue = "false";
		if(requiredArr != null && requiredArr.length > i)
        	{
        		curRecValue = requiredArr[i];
        	}
		 if(!tempRequired.toString().isEmpty())
		 {
    		    tempRequired.append("~");
		 }
    		 tempRequired.append(curRecValue);
		    
		
		// max length manipulation if not specified in dynamic screen
		if(maxLengthArr != null)
		{
		    if(tempMaxLngth.length() > 0 )
		    {
			tempMaxLngth.append("~");
		    }
		    if(maxLengthArr.length > i) // taking value
		    {
			tempMaxLngth.append(maxLengthArr[i]);
		    }
		}
	    }
	    else 
	    {
		if(!tempReadOnly.toString().isEmpty())
		{
		    tempReadOnly.append("~");
		}
		
		if(!tempRequired.toString().isEmpty())
		{
		    tempRequired.append("~");
		}

		if(theVO.getIS_MANDATORY() != null)
		{
		    if(theVO.getIS_MANDATORY().intValue() == 1)
		    {
			tempRequired.append("true");
		    }
		    else
		    {
			tempRequired.append("false");
		    }
		}
		if(theVO.getIS_READONLY() != null && theVO.getIS_READONLY().intValue() == 1)
		{
		    tempReadOnly.append("true");
		}
		else if(readOnlyArr != null && readOnlyArr.length > i)
		{
		    tempReadOnly.append(readOnlyArr[i]);
		}
		// else
		// {
		// tempReadOnly += "false";
		// }
		if(theVO.getIS_VISIBLE() != null && theVO.getIS_VISIBLE().intValue() == 0 && !hideAccount)
		{
        		if(inputsOrderLst.length > 0 && inputsOrderLst.length > i  && mainAccLst.contains(inputsOrderLst[i]))
        		{
        		    cssDisp = "";
        		    hideAccount = true;
        		    if(cssStyle == null || cssStyle.isEmpty())
        		    {
        			cssStyle = "";
        		    }
        		    else
        		    {
        			cssStyle += ";";
        		    }
        		    cssStyle += "display:none";
        		    //display none in this case will be used for all elements in account
        		    addParameter("cssStyle", findString(cssStyle));
        		    addParameter("hideAccount", "true");
        		}
        		else
        		{
        		    if(!cssDisp.isEmpty())
        		    {
        			cssDisp += "~";
        		    }
        		    cssDisp += "display:none";
        		    cssDisp += applyBackGroundColor(theVO, cssDisp);
        		}
		}
		else // if whole account is hidden
		    if(!hideAccount)
		    {
			if(!cssDisp.isEmpty())
			{
			    cssDisp += "~";
			}
			// return if there is background customization
			String cssCurrBgDisp = applyBackGroundColor(theVO, cssDisp);
			if(!cssCurrBgDisp.isEmpty())
			{
			    cssDisp += cssCurrBgDisp;
			}
			else
			{
			    cssDisp += "N";
			}
		    }
		
		if(!StringUtil.nullToEmpty(theVO.getLABEL_KEY()).isEmpty())
		{
		    if(!StringUtil.nullToEmpty(overrideLabelTextStr).isEmpty())
		    {
			overrideLabelTextStr += "~";
			overrideLabelKeyStr += "~";
		    }
		    BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
		    overrideLabelTextStr += baseAction.getText(theVO.getLABEL_KEY());
		    overrideLabelKeyStr += theVO.getLABEL_KEY();
		}
		
		if(tempMaxLngth.length() > 0 )
		{
		    tempMaxLngth.append("~");
		}
		// control on Max Length Field if Exists
		if(theVO.getMAX_LENGTH() != null && theVO.getMAX_LENGTH().intValue() > 0)
		{
		    tempMaxLngth.append(theVO.getMAX_LENGTH().intValue());
		}
		
		// Enable field audit management
		if(theVO.getENABLE_FIELD_AUDIT_YN() != null)
		{
		    if(theVO.getENABLE_FIELD_AUDIT_YN().intValue() == 1)
		    {
			fieldAudit = "true";
		    }
		    else
		    {
			fieldAudit = "false";
		    }
		    addParameter("fieldAudit", findValue(fieldAudit, Boolean.class));
		}
		
		
		
		/************************************************************************************************************************/
		
		BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
		SessionCO sessionCO = baseAction.returnSessionObject();
		theVO.setAPP_NAME(sessionCO.getCurrentAppName());
		List<CustomElementActivitiesSC> activitiesVOList = RootUtil.returnParamElemActivities(theVO);
		
        	if(activitiesVOList != null && activitiesVOList.size()>0)
        	{
        	    for(CustomElementActivitiesSC activityVO : activitiesVOList)
        	    {
        		SYS_PARAM_ELEM_ACTIVITIESVO sysParamElemActivity = activityVO.getSysParamElemActivitiesVO();
        		theVO.setElemSequenceId(sysParamElemActivity.getSEQUENCE_ID());
        		try
        		{
        		    if(ButtonCustomizationConstants.ACTIVITY_TYPE.ONCHANGE
        			    .equals(sysParamElemActivity.getACTIVITY_TYPE())|| ButtonCustomizationConstants.ACTIVITY_TYPE.BOTH
        			    .equals(sysParamElemActivity.getACTIVITY_TYPE()))
        		    {
        			Map<String, Object> customBtnDataMap = RootUtil.returnButtonCustActionData(request,
        				sysParamElemActivity.getACTIVITY_ID(), true, theVO);
        			customBtnDataMap.put("dynScreenAppName", sessionCO.getCurrentAppName());
        			customBtnDataMap.put("dynScreenProgRef", theVO.getPROG_REF());
        			customBtnDataMap.put("dynScreenCompCode", theVO.getCOMP_CODE());
        			customBtnDataMap.put("dynScreenFldIdentifier", sysParamElemActivity.getFLD_IDENTIFIER());
        			customBtnDataMap.put("isGlobalActivity", true);
        			customBtnDataMap.put("elemSequenceId", sysParamElemActivity.getSEQUENCE_ID());
        			customBtnDataMap.put("proceedExpression", sysParamElemActivity.getPROCEED_ON_EXPRESSION());
        			RootUtil.addScreenElements(customBtnDataMap, activitiesVOList,request);
        			customBtnDataArray[i] = PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null, false, true);
        			String initialOnChange = StringUtil.nullToEmpty(onchangeArray[i]);
        			initialOnChange = "N".equals(initialOnChange) ? "" : initialOnChange; 
        			onchangeArray[i] = "var stopPropagation = customBtnActionCall('" + tempId + "', '0',"
            				+ ("1".equals(sysParamElemActivity.getPROCEED_ON_FAIL()))+"); if(!stopPropagation){"
            				+  initialOnChange + "}";
            		    }
        		      
            		    if(ButtonCustomizationConstants.ACTIVITY_TYPE.KEYEVENT
        			    .equals(sysParamElemActivity.getACTIVITY_TYPE()) || ButtonCustomizationConstants.ACTIVITY_TYPE.BOTH
        			    .equals(sysParamElemActivity.getACTIVITY_TYPE()))
        		    {
        			Map<String, Object> customBtnDataMap = RootUtil.returnButtonCustActionData(request,
        				sysParamElemActivity.getACTIVITY_ID(), true, theVO);
        			customBtnDataMap.put("dynScreenAppName", sessionCO.getCurrentAppName());
        			customBtnDataMap.put("dynScreenProgRef", theVO.getPROG_REF());
        			customBtnDataMap.put("dynScreenCompCode", theVO.getCOMP_CODE());
        			customBtnDataMap.put("dynScreenFldIdentifier", sysParamElemActivity.getFLD_IDENTIFIER());
        			customBtnDataMap.put("isGlobalActivity", true);
        			customBtnDataMap.put("elemSequenceId", sysParamElemActivity.getSEQUENCE_ID());
        			customBtnDataMap.put("proceedExpression", sysParamElemActivity.getPROCEED_ON_EXPRESSION());
        			RootUtil.addScreenElements(customBtnDataMap, activitiesVOList,request);
        			customKeyEventBtnDataArray[i]= PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null, false, true);
        		    }
            		}
        		catch(Exception e)
        		{
        		   e.printStackTrace();
        		}
        	    }
        	    
        	}
        	
		/************************************************************************************************************************/
		
		
	    }

	    if(i > 0)
	    {
		temp.append("~");
	    }
	    temp.append(findValue(lst[i]));
	    
	    
	    // adding translation for tool tips for account entries
	    // tooltip for the input
	    String toolTip = RootUtil.returnFieldToolTipWithCustomization(request,lst[i], tempId, theVO);
	    if(i > 0)
	    {
		toolTipNames.append("~");
		fieldDescNames.append("~");
	    }
	    if(toolTip == null)
	    {
		// check if tooltip defined in JSP tag or give Default Tooltip
		if(toolTipKeysLst == null || toolTipKeysLst.length < i)
		{
		    fieldDescNames.append("N");
		    switch( i) 
		    {
			case 0: // branch code
			    toolTipNames.append(TextProviderHelper.getText("Branch_Code_key", "Branch_Code_key", stack));
			break;
			case 1: // currency
			    toolTipNames.append(TextProviderHelper.getText("Currency_Code_key", "Currency_Code_key", stack));
			break;
			case 2:// GL
			    toolTipNames.append(TextProviderHelper.getText("Gl_Code_key", "Gl_Code_key", stack));
			break;
			case 3: // CIF
			    toolTipNames.append(TextProviderHelper.getText("CIF_code_key", "CIF_code_key", stack));
			break;
			case 4: // SL
			    toolTipNames.append(TextProviderHelper.getText("Serial_key", "Serial_key", stack));
			break;
			case 6: // Account NAme
			    toolTipNames.append(TextProviderHelper.getText("Account_Name_key", "Account_Name_key", stack));
			break;
			case 5: // Acc Reference
			    toolTipNames.append(TextProviderHelper.getText("Additional_Reference_key", "Additional_Reference_key", stack));
			break;
			default:
			    toolTipNames.append(TextProviderHelper.getText("Code_key", "Code_key", stack));
			break;
		    }
		}
		else
		{
		    if("N".equals(toolTipKeysLst[i]))
		    {
			toolTipNames.append("N");
		    }
		    else
		    {
			toolTipNames.append(TextProviderHelper.getText(toolTipKeysLst[i], toolTipKeysLst[i], stack));			
		    }
		    addFieldDescNames(fieldDescNames,i);
		}
	    }
	    else
	    {
		// tooltip from Business translation
		toolTipNames.append(toolTip);
		addFieldDescNames(fieldDescNames,i);
	    }
	    /**
	     * Additional Fields management
	     */
	        String[] addLabelsLst = additionalLabels.split("~");
	        if(i<6)
	        {
	            addLabelsKeys.append((i==0)?"N":"~N");
	        }
	        else
	        {  
	            switch(i)
	            {
	        	case 6:
	        	    if(StringUtil.nullToEmpty(addLabelsLst[i]).isEmpty() || "N".equals(StringUtil.nullToEmpty(addLabelsLst[i])))
	        	    {
	        		addLabelsKeys.append("~Account_Name_key");
	        	    }
	        	    else
	        	    {
	        		addLabelsKeys.append("~").append(addLabelsLst[i]);	
	        	    }		
	        	    break;
	        	case 7:
	        	    if(StringUtil.nullToEmpty(addLabelsLst[i]).isEmpty() || "N".equals(StringUtil.nullToEmpty(addLabelsLst[i])))
	        	    {
	        		addLabelsKeys.append("~account_cy_key");
	        		
	        	    }
	        	    else
	        	    {
	        		addLabelsKeys.append("~").append(addLabelsLst[i]);	
	        	    }		
	        	    break;
	        	case 8:
	        	    if(StringUtil.nullToEmpty(addLabelsLst[i]).isEmpty() || "N".equals(StringUtil.nullToEmpty(addLabelsLst[i])))
	        	    {
	        		addLabelsKeys.append("~Account_Type_key");	
	        	    }
	        	    else
	        	    {
	        		addLabelsKeys.append("~").append(addLabelsLst[i]);
	        	    }		
	        	    break;
	        	case 9:
	        	    if(StringUtil.nullToEmpty(addLabelsLst[i]).isEmpty() || "N".equals(StringUtil.nullToEmpty(addLabelsLst[i])))
	        	    {
	        		addLabelsKeys.append("~account_cif_key");
	        	    }
	        	    else
	        	    {
	        		addLabelsKeys.append("~").append(addLabelsLst[i]);
	        	    }		
	        	    break;
	        	default:
	        	    if(StringUtil.nullToEmpty(addLabelsLst[i]).isEmpty() || "N".equals(StringUtil.nullToEmpty(addLabelsLst[i])))
	        	    {
	        		addLabelsKeys.append("~N");
	        	    }
	        	    else
	        	    {
	        		addLabelsKeys.append("~").append(addLabelsLst[i]);
	        	    }		        	    
	        	    break;
	            }	
	        }
	}
	
	
	if(onchangeArray != null && onchangeArray.length > 0)
	{
	    addParameter("onchangeStr", findString(StringUtils.join(onchangeArray,"~")));
	}
	if(customBtnDataArray != null && customBtnDataArray.length > 0)
	{
	    addParameter("customBtnDataStr", findString(StringUtils.join(customBtnDataArray,"~")));
	}
	if(customKeyEventBtnDataArray != null && customKeyEventBtnDataArray.length > 0)
	{
	    addParameter("customKeyEventBtnDataStr", findString(StringUtils.join(customKeyEventBtnDataArray,"~")));
	}
	 
	
	// adding tooltip translated values
	if(toolTipNames != null)
	{
	    addParameter("toolTipNames", toolTipNames);
	}
	
	if(fieldDescNames != null)
	{
	    addParameter("fieldDescNames", fieldDescNames);
	}
	
	if(addLabelsKeys != null)
	{
	   addParameter("additionalLabels",addLabelsKeys);
	}
	
	if(!tempReadOnly.toString().isEmpty())
	{
	    addParameter("readOnly", tempReadOnly.toString());
	}
	
	if(!tempRequired.toString().isEmpty())
	{
	    addParameter("required", tempRequired.toString());
	}
	
	if(tempMaxLngth.length() > 0)
	{
	    addParameter("maxLength", tempMaxLngth.toString());
	}
	
	if(overrideLabelTextStr.length() > 0)
	{
	    addParameter("overrideLabelTextStr", findString(overrideLabelTextStr));
	}
	if(overrideLabelKeyStr.length() > 0)
	{
	    addParameter("overrideLabelKeyStr", findString(overrideLabelTextStr));
	}
	setNameValues(temp.toString());
	addParameter("nameValues", nameValues);
	addParameter("cssDisp", cssDisp);
    }

    private String applyBackGroundColor(SYS_PARAM_SCREEN_DISPLAYVO theVO, String currentStyle)
    {
	String bgColorCss = "";
	// apply background color on BACKGROUND_COLOR if Exists
	if(StringUtil.isNotEmpty(theVO.getBACKGROUND_COLOR()))
	{
	    
	    if((StringUtil.isNotEmpty( currentStyle)))
	    {
		bgColorCss = ";";
	    }
	    bgColorCss = "background:" + theVO.getBACKGROUND_COLOR() + " !important";
	}
	return bgColorCss;
    }

    private void addFieldDescNames(StringBuffer fieldDescNames,int i)
    {
	 switch( i) 
	    {
		case 0: // branch code
		    fieldDescNames.append(TextProviderHelper.getText("Branch_Code_key", "Branch_Code_key", stack));
		break;
		case 1: // currency
		    fieldDescNames.append(TextProviderHelper.getText("Currency_Code_key", "Currency_Code_key", stack));
		break;
		case 2:// GL
		    fieldDescNames.append(TextProviderHelper.getText("Gl_Code_key", "Gl_Code_key", stack));
		break;
		case 3: // CIF
		    fieldDescNames.append(TextProviderHelper.getText("CIF_code_key", "CIF_code_key", stack));
		break;
		case 4: // SL
		    fieldDescNames.append(TextProviderHelper.getText("Serial_key", "Serial_key", stack));
		break;
		case 6: // Account NAme
		    fieldDescNames.append(TextProviderHelper.getText("Account_Name_key", "Account_Name_key", stack));
		break;
		case 5: // Acc Reference
		    fieldDescNames.append(TextProviderHelper.getText("Additional_Reference_key", "Additional_Reference_key", stack));
		break;
		default:
		    fieldDescNames.append(TextProviderHelper.getText("Code_key", "Code_key", stack));
		break;
	    }
	
    }
    
    private String[] initializeArray(int size, String defaultValue)
    {
	String [] myarray = new String[size];
	Arrays.fill(myarray, defaultValue);
	return myarray; 
    }
    
    @Override
    public void setTheme(String theme)
    {
	super.setTheme(PATH_THEME);
    }

    @Override
    protected String getDefaultTemplate()
    {
	return PATH_TEMPLATE;
    }

    /**
     * @return the inputIds
     */
    public String getInputIds()
    {
	return inputIds;
    }

    /**
     * @param inputIds the inputIds to set
     */
    public void setInputIds(String inputIds)
    {
	this.inputIds = inputIds;
    }

    /**
     * @return the inputNames
     */
    public String getInputNames()
    {
	return inputNames;
    }

    /**
     * @param inputNames the inputNames to set
     */
    public void setInputNames(String inputNames)
    {
	this.inputNames = inputNames;
    }

    /**
     * @return the leadZeros
     */
    public String getLeadZeros()
    {
	return leadZeros;
    }

    /**
     * @param leadZeros the leadZeros to set
     */
    public void setLeadZeros(String leadZeros)
    {
	this.leadZeros = leadZeros;
    }

    /**
     * @return the readOnly
     */
    public String getReadOnly()
    {
	return readOnly;
    }

    /**
     * @param readOnly the readOnly to set
     */
    public void setReadOnly(String readOnly)
    {
	this.readOnly = readOnly;
    }

    /**
     * @return the rowLocation
     */
    public String getRowLocation()
    {
	return rowLocation;
    }

    /**
     * @param rowLocation the rowLocation to set
     */
    public void setRowLocation(String rowLocation)
    {
	this.rowLocation = rowLocation;
    }

    /**
     * @return the colSpan
     */
    public String getColSpan()
    {
	return colSpan;
    }

    /**
     * @param colSpan the colSpan to set
     */
    public void setColSpan(String colSpan)
    {
	this.colSpan = colSpan;
    }

    /**
     * @return the onchange
     */
    public String getOnchange()
    {
	return onchange;
    }

    /**
     * @param onchange the onchange to set
     */
    @Override
    public void setOnchange(String onchange)
    {
	this.onchange = onchange;
    }

    /**
     * @return the dependencySrc
     */
    public String getDependencySrc()
    {
	return dependencySrc;
    }

    /**
     * @param dependencySrc the dependencySrc to set
     */
    public void setDependencySrc(String dependencySrc)
    {
	this.dependencySrc = dependencySrc;
    }

    /**
     * @return the parameter
     */
    public String getParameter()
    {
	return parameter;
    }

    /**
     * @param parameter the parameter to set
     */
    public void setParameter(String parameter)
    {
	this.parameter = parameter;
    }

    /**
     * @return the dependency
     */
    public String getDependency()
    {
	return dependency;
    }

    /**
     * @param dependency the dependency to set
     */
    public void setDependency(String dependency)
    {
	this.dependency = dependency;
    }

    /**
     * @return the readonly
     */
    public Boolean getReadonly()
    {
	return readonly;
    }

    /**
     * @param readonly the readonly to set
     */
    public void setReadonly(Boolean readonly)
    {
	this.readonly = readonly;
    }

    /**
     * @return the mode
     */
    public String getMode()
    {
	return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(String mode)
    {
	this.mode = mode;
    }

    /**
     * @return the ondblclick
     */
    public String getOndblclick()
    {
	return ondblclick;
    }

    /**
     * @param ondblclick the ondblclick to set
     */
    @Override
    public void setOndblclick(String ondblclick)
    {
	this.ondblclick = ondblclick;
    }

    /**
     * @return the nbFormat
     */
    public String getNbFormat()
    {
	return nbFormat;
    }

    /**
     * @param nbFormat the nbFormat to set
     */
    public void setNbFormat(String nbFormat)
    {
	this.nbFormat = nbFormat;
    }

    /**
     * @return the accountLabel
     */
    public String getAccountLabel()
    {
	return accountLabel;
    }

    /**
     * @param accountLabel the accountLabel to set
     */
    public void setAccountLabel(String accountLabel)
    {
	this.accountLabel = accountLabel;
    }

    /**
     * @return the size
     */
    public String getSize()
    {
	return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size)
    {
	this.size = size;
    }

    /**
     * @return the inputSizes
     */
    public String getInputSizes()
    {
	return inputSizes;
    }

    /**
     * @param inputSizes the inputSizes to set
     */
    public void setInputSizes(String inputSizes)
    {
	this.inputSizes = inputSizes;
    }

    /**
     * @return the fromAccount
     */
    public String getFromAccount()
    {
	return fromAccount;
    }

    /**
     * @param fromAccount the fromAccount to set
     */
    public void setFromAccount(String fromAccount)
    {
	this.fromAccount = fromAccount;
    }

    /**
     * @return the cssStyle
     */
    public String getCssStyle()
    {
	return cssStyle;
    }

    /**
     * @param cssStyle the cssStyle to set
     */
    @Override
    public void setCssStyle(String cssStyle)
    {
	this.cssStyle = cssStyle;
    }

    /**
     * @return the actionName
     */
    public String getActionName()
    {
	return actionName;
    }

    /**
     * @param actionName the actionName to set
     */
    public void setActionName(String actionName)
    {
	this.actionName = actionName;
    }

    /**
     * @return the paramList
     */
    public String getParamList()
    {
	return paramList;
    }

    /**
     * @param paramList the paramList to set
     */
    public void setParamList(String paramList)
    {
	this.paramList = paramList;
    }

    /**
     * @return the resultList
     */
    public String getResultList()
    {
	return resultList;
    }

    /**
     * @param resultList the resultList to set
     */
    public void setResultList(String resultList)
    {
	this.resultList = resultList;
    }

    /**
     * @return the onOk
     */
    public String getOnOk()
    {
	return onOk;
    }

    /**
     * @param onOk the onOk to set
     */
    public void setOnOk(String onOk)
    {
	this.onOk = onOk;
    }

    /**
     * @return the onCancel
     */
    public String getOnCancel()
    {
	return onCancel;
    }

    /**
     * @param onCancel the onCancel to set
     */
    public void setOnCancel(String onCancel)
    {
	this.onCancel = onCancel;
    }

    /**
     * @return the searchElement
     */
    public String getSearchElement()
    {
	return searchElement;
    }

    /**
     * @param searchElement the searchElement to set
     */
    public void setSearchElement(String searchElement)
    {
	this.searchElement = searchElement;
    }

    /**
     * @return the multiSelect
     */
    public String getMultiSelect()
    {
	return multiSelect;
    }

    /**
     * @param multiSelect the multiSelect to set
     */
    public void setMultiSelect(String multiSelect)
    {
	this.multiSelect = multiSelect;
    }

    /**
     * @return the selectColumn
     */
    public String getSelectColumn()
    {
	return selectColumn;
    }

    /**
     * @param selectColumn the selectColumn to set
     */
    public void setSelectColumn(String selectColumn)
    {
	this.selectColumn = selectColumn;
    }

    /**
     * @return the autoSearch
     */
    public String getAutoSearch()
    {
	return autoSearch;
    }

    /**
     * @param autoSearch the autoSearch to set
     */
    public void setAutoSearch(String autoSearch)
    {
	this.autoSearch = autoSearch;
    }

    /**
     * @return the validateAction
     */
    public String getValidateAction()
    {
	return validateAction;
    }

    /**
     * @param validateAction the validateAction to set
     */
    public void setValidateAction(String validateAction)
    {
	this.validateAction = validateAction;
    }

    /**
     * @return the nameValues
     */
    public String getNameValues()
    {
	return nameValues;
    }

    /**
     * @param nameValues the nameValues to set
     */
    public void setNameValues(String nameValues)
    {
	this.nameValues = nameValues;
    }

    /**
     * @return the onblur
     */
    public String getOnblur()
    {
	return onblur;
    }

    /**
     * @param onblur the onblur to set
     */
    @Override
    public void setOnblur(String onblur)
    {
	this.onblur = onblur;
    }

    public String getReadOnlyMode()
    {
	return readOnlyMode;
    }

    public void setReadOnlyMode(String readOnlyMode)
    {
	this.readOnlyMode = readOnlyMode;
    }

    public String getAfterDepEvent()
    {
	return afterDepEvent;
    }

    public void setAfterDepEvent(String afterDepEvent)
    {
	this.afterDepEvent = afterDepEvent;
    }

    public String getToolTipKeys()
    {
	return toolTipKeys;
    }

    public void setToolTipKeys(String toolTipKeys)
    {
	this.toolTipKeys = toolTipKeys;
    }

    public String getOverrideLabelTextStr()
    {
	return overrideLabelTextStr;
    }

    public void setOverrideLabelTextStr(String overrideLabelTextStr)
    {
	this.overrideLabelTextStr = overrideLabelTextStr;
    }

    public String getMaxlen()
    {
        return maxlen;
    }

    public void setMaxlen(String maxlength)
    {
        this.maxlen = maxlength;
    }

    /**
     * @return the inputsOrder
     */
    public String getInputsOrder()
    {
        return inputsOrder;
    }

    /**
     * @param inputsOrder the inputsOrder to set
     */
    public void setInputsOrder(String inputsOrder)
    {
        this.inputsOrder = inputsOrder;
    }

    public String getCssDisp()
    {
        return cssDisp;
    }

    public void setCssDisp(String cssDisp)
    {
        this.cssDisp = cssDisp;
    }

    /**
     * @return the additionalLabels
     */
    public String getAdditionalLabels()
    {
        return additionalLabels;
    }

    /**
     * @param additionalLabels the additionalLabels to set
     */
    public void setAdditionalLabels(String additionalLabels)
    {
        this.additionalLabels = additionalLabels;
    }

    /**
     * @return the beforeDepEvent
     */
    public String getBeforeDepEvent()
    {
        return beforeDepEvent;
    }

    /**
     * @param beforeDepEvent the beforeDepEvent to set
     */
    public void setBeforeDepEvent(String beforeDepEvent)
    {
        this.beforeDepEvent = beforeDepEvent;
    }

    public String getOverrideLabelKeyStr()
    {
        return overrideLabelKeyStr;
    }

    public void setOverrideLabelKeyStr(String overrideLabelKeyStr)
    {
        this.overrideLabelKeyStr = overrideLabelKeyStr;
    }
    
    public String getFieldAudit()
    {
        return fieldAudit;
    }
    public void setFieldAudit(String fieldAudit)
    {
        this.fieldAudit = fieldAudit;
    }

    /**
     * @return the required
     */
    public String getRequired()
    {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(String required)
    {
        this.required = required;
    }
    /**
     * @return the dontLoadData
     */
    public String getDontLoadData()
    {
        return dontLoadData;
    }

    /**
     * @param dontLoadData the dontLoadData to set
     */
    public void setDontLoadData(String dontLoadData)
    {
        this.dontLoadData = dontLoadData;
    }
    
}
