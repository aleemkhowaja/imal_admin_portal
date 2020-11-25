package com.path.struts2.taglib.jqgrid;

import java.io.Writer;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jgeppert.struts2.jquery.grid.components.GridColumn;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.SYS_PARAM_ELEM_ACTIVITIESVO;
import com.path.dbmaps.vo.SYS_PARAM_OBJ_DETAILS_DISPLAYVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.LabelElemCO;
import com.path.vo.common.customization.CustomElementActivitiesSC;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class PathGridColumn extends GridColumn
{
    public PathGridColumn(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    protected String colType;
    protected String dependency;
    protected String dependencySrc;
    protected String params;
    protected String dialogOptions;
    protected String dialogUrl;
    protected String searchType; // number, integer. default string
    protected String searchRules;
    protected String dataAction;
    protected String resultList;
    protected String autoSearch;
    protected String searchElement;
    protected String onOkMethod;
    protected String frozen;
    protected String paramList;
    protected String loadOnce;
    protected String leadZeros;
    protected String nbFormat;
    protected String formatCol; // name of the column containig the nb of
				// decPlaces for currency
    private String afterDepEvent;
    private String beforeDepEvent;
    private String dateFormat;
    private String timePicker;
    private String applyRounding;
    private String mode;
    private String unformat;
    private String minValue;
    private String maxValue;
    private String maxLenBeforeDec;
    private String overrideRecReadOnly;
    private String reConstruct;
    private String minLength;
    private String maxLength;
    private String fromCustomization;
    private String maxDisplayLen;
    private String multiSelect;
    private String multiResultInput;
    private String selectColumn;

    private String fieldAudit;
    
    private String required;
    
    private String readOnlyMode;
    protected String dontLoadData;//TP 887297 dont Load Data for livesearch feature
    private String customBtnData; //TP-1043972-OnChange Event For Grid Column- Editable Grid Customization Enhancements

    @Override
    public boolean start(Writer arg0)
    {
	PathGrid grid = (PathGrid)findAncestor(PathGrid.class);
	//get LabelsLst in case exists
	SYS_PARAM_SCREEN_DISPLAYVO theVO = RootUtil.returnParamScreenDisplay(request, grid.getId(), grid.getId());
	if(theVO != null && theVO.getLabelsLst() != null && !theVO.getLabelsLst().isEmpty())
	{
	    List<LabelElemCO> lst = theVO.getLabelsLst(); 
	    for(LabelElemCO lblCO : lst)
	    {
		if(StringUtil.nullToEmpty(lblCO.getGridColName()).equals(name))
		{
		    //set new value for label
		    if(!StringUtil.nullToEmpty(lblCO.getValue()).trim().isEmpty())
		    {
			setTitle(lblCO.getValue());
		    }
		    break;
		}
	    }
	}
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	SYS_PARAM_OBJ_DETAILS_DISPLAYVO theObjDetailsVO   = RootUtil.returnParamObjDetailsDisplay(request,grid.getId(),name);
	//initial editinline of the grid column
	String edit = editable == null ? "false" : editable;
	if(theObjDetailsVO!=null)
	{
	    if(theObjDetailsVO.getIS_READONLY() != null && theObjDetailsVO.getIS_READONLY().intValue() == 1)
	    {
		 editable = "false";
	    }
	    else
	    {
		 editable = "true";
	    }
	    if(theObjDetailsVO.getIS_VISIBLE() != null && theObjDetailsVO.getIS_VISIBLE().intValue() == 0)
	    {
		hidden = "true" ;
	    }
	    else
	    {
		hidden = "false" ;
	    }
	    if(theObjDetailsVO.getIS_MANDATORY() != null && theObjDetailsVO.getIS_MANDATORY().intValue() == 0)
	    {
		required = "false";
	    }
	    else
	    {
		required = "true";
	    }
	    //if the editinline changed then the readonly is comming from customization and not from development
	    if(!edit.equals(editable))
	    {
		addParameter("fromCustomization", true);
	    }
	    if(!StringUtil.nullToEmpty(theObjDetailsVO.getLABEL_KEY()).trim().isEmpty())
	    {
		setTitle(baseAction.getText(theObjDetailsVO.getLABEL_KEY()));
	    }
	    
	    if(theObjDetailsVO.getMIN_LENGTH() != null)
	    {
		setMinLength(String.valueOf(theObjDetailsVO.getMIN_LENGTH()));
	    }
	    
	    if(theObjDetailsVO.getMAX_LENGTH() != null)
	    {
		setMaxLength(String.valueOf(theObjDetailsVO.getMAX_LENGTH()));
	    }
	    
	    //Enable field audit management		    	
	    if(theObjDetailsVO.getENABLE_FIELD_AUDIT_YN() != null)
	    {										
		 if("1".equals(theObjDetailsVO.getENABLE_FIELD_AUDIT_YN()))
		 {
		     fieldAudit = "true";
		 }
		 else
		 {
		     fieldAudit = "false";
		 }
		addParameter("fieldAudit", findValue(fieldAudit, Boolean.class));
	    }
	}
	//the additional code should exists before calling super.start()	
	
	String _recReadOnly = StringUtil.nullToEmpty(baseAction.get_recReadOnly());
	if("true".equals(_recReadOnly) && !"true".equals(StringUtil.nullToEmpty(overrideRecReadOnly)))
	{
  	    //set editable=false, except when overrideRecReadOnly=true in this case the column editable property will remain as defined in jsp
		editable = "false";
		addParameter("editable", findValue(editable,Boolean.class));
		/**
		 * [MarwanMaddah]
		 * the formatoptions is dominated inisde jqGrid Management
		 * for that in case there is disabled:false inside the formatoptions of the checkbox
		 * and _recReadOnly is true, will replace it by disabled:true to make the checkbox disabled
		 */
		if(StringUtil.isNotEmpty(formatoptions) && colType != null && "checkbox".equals(colType))
		{
		    formatoptions = formatoptions.replaceAll("disabled\\s*:\\s*false","disabled:true");
		}
		
	}
	
	if(colType != null)
	{
	    addParameter("colType", findString(colType));

	    if("number".equals(colType))
	    {
		if(leadZeros != null)
		{
		    addParameter("leadZeros", findString(leadZeros));
		}
		if(nbFormat == null)
		{
		    nbFormat = "###";
		}
		addParameter("nbFormat", findString(nbFormat));
		if(applyRounding != null)
		{
		    addParameter("applyRounding", findString(applyRounding));
		}
		if(minValue != null)
		{
		    addParameter("minValue", findString(minValue));
		}
		if(maxValue != null)
		{
		    addParameter("maxValue", findString(maxValue));
		}
		if(maxLenBeforeDec != null)
		{
		    addParameter("maxLenBeforeDec", findString(maxLenBeforeDec));
		}
		if(formatter == null) // set the default formatter
		{
		    formatter = "defaultNumFmatter";
		    addParameter("formatter", findString(formatter));
		}
		if(formatCol != null)
		{
		    addParameter("formatCol", formatCol);
		}
		if(editable != null && "true".equals(editable) && !("true").equals(hidden))
		{
		    String editRulesStr = "";
		    if(StringUtil.nullToEmpty(editrules).isEmpty())
		    {
			editRulesStr = "{number:true";
		    }
		    else if(editrules.indexOf("integer") < 0 && editrules.indexOf("number") < 0)
		    {
			editRulesStr = editrules.substring(0, editrules.lastIndexOf("}")) + ",number:true";
		    }
		    if(!editRulesStr.isEmpty())
		    {
			editrules = editRulesStr + "}";
			addParameter("editrules", findString(editrules));
		    }
		    
		    // assign the correct group and decimal separator as per user details
		    HashMap<String , Object> theFormats = RootUtil.returnNumberFormat(request.getSession());
		    String decSeparator = StringUtil.nullEmptyToValue(theFormats.get("decimalSepa"), ".");
		    String grpSeparator = StringUtil.nullEmptyToValue(theFormats.get("groupSepa"), ",");

		    
		    String timeOutFn = "setTimeout(function() {$(el).numeric({textDir : true, minValue: "
			    + StringUtil.nullEmptyToValue(minValue, "false") + ", maxValue: '"
			    + StringUtil.nullEmptyToValue(maxValue, "false") + "', maxLenBeforeDec: '"
			    + StringUtil.nullEmptyToValue(maxLenBeforeDec, "false") + "', format : {format:'" + nbFormat
			    + "' ,leadZeros:'" + StringUtil.nullToEmpty(leadZeros) + "'," +
			    "decimalChar : '"+decSeparator+"', thousandsChar : '"+grpSeparator+"'}})},100)";
		    String numberFn = " function(el){" + timeOutFn + "}";
		    if(editoptions == null)
		    {
			editoptions = "{ dataInit:" + numberFn + "}";
		    }
		    else if(!editoptions.isEmpty() && editoptions.indexOf("dataInit") < 0)
		    {
			editoptions = editoptions.substring(0, 1) + " dataInit:" + numberFn + ","
				+ editoptions.substring(1);
		    }
		    else if(editoptions.indexOf("dataInit") > 0 && editoptions.indexOf(timeOutFn) < 0)
		    {
			int indexOfFnStart = 0;// index of { starting
			// dataInit:function(t)
			indexOfFnStart = editoptions.indexOf("{", editoptions.indexOf(":", editoptions
				.indexOf("dataInit"))) + 1;
			editoptions = editoptions.substring(0, indexOfFnStart) + timeOutFn + ","
				+ editoptions.substring(indexOfFnStart);
		    }
		    addParameter("editoptions", findString(editoptions));
		}
		if(getMinLength() != null)
		{
		    if(editoptions == null)
		    {
			editoptions = "{ minLength:" + getMinLength() + "}";
		    }
		    else if(!editoptions.isEmpty() && editoptions.indexOf("minLength") < 0)
		    {
			editoptions = editoptions.substring(0, 1) + " minLength:" + getMinLength() + "," + editoptions.substring(1);
		    }
		    else if(editoptions.indexOf("minLength") > 0 && editoptions.indexOf(":" + getMinLength()) < 0)
		    {
			int indexOfFnStart = 0;// index of { starting
			// dataInit:function(t)
			indexOfFnStart = editoptions.indexOf("{", editoptions.indexOf(":", editoptions.indexOf("minLength"))) + 1;
			editoptions = editoptions.substring(0, indexOfFnStart) + getMinLength() + ","
				+ editoptions.substring(indexOfFnStart);
		    }
		    addParameter("editoptions", findString(editoptions));
		}
		if(getMaxLength() != null)
		{
		    if(editoptions == null)
		    {
			editoptions = "{ maxLength:" + getMaxLength() + "}";
		    }
		    else if(!editoptions.isEmpty() && editoptions.indexOf("maxLength") < 0)
		    {
			editoptions = editoptions.substring(0, 1) + " maxLength:" + getMaxLength() + "," + editoptions.substring(1);
		    }
		    else if(editoptions.indexOf("maxLength") > 0 && editoptions.indexOf(":" + getMaxLength()) < 0)
		    {
			int indexOfFnStart = 0;// index of { starting
			// dataInit:function(t)
			indexOfFnStart = editoptions.indexOf("{", editoptions.indexOf(":", editoptions.indexOf("maxLength"))) + 1;
			editoptions = editoptions.substring(0, indexOfFnStart) + getMaxLength() + ","
				+ editoptions.substring(indexOfFnStart);
		    }
		    addParameter("editoptions", findString(editoptions));
		}
		// setting cssStyle to right for number inputs
		addParameter("cssClass", "right " + StringUtil.nullToEmpty(cssClass));
	    }
	    // set the custom edit type and edit options for dialog columns
	    else if("dialog".equals(colType))
	    {
		edittype = "custom";
		String dialogEditOpt = "custom_element: myelem, custom_value:myvalue";
		if(editoptions == null)
		{
		    editoptions = "{" + dialogEditOpt + "}";
		}
		else if(!editoptions.isEmpty() && editoptions.indexOf("myelem") < 0)
		{
		    editoptions = editoptions.substring(0, editoptions.lastIndexOf("}") - 1) + "," + dialogEditOpt
			    + "}";
		}
		
		if(paramList != null)
		{
		    addParameter("paramList", findString(paramList));
		}
		
		addParameter("edittype", findString(edittype));
		addParameter("editoptions", findString(editoptions));
	    }

	    else if("liveSearch".equals(colType))
	    {
		edittype = "custom";
		String liveSearchEditOpt = "custom_element: liveElem, custom_value:myvalue";
		if(editoptions == null)
		{
		    editoptions = "{" + liveSearchEditOpt + "}";
		}
		else if(!editoptions.isEmpty() && editoptions.indexOf("liveElem") < 0)
		{
		    editoptions = editoptions.substring(0, editoptions.lastIndexOf("}")) + "," + liveSearchEditOpt
			    + "}";
		}
		if(dataAction != null)
		{
		    addParameter("dataAction", findString(dataAction));
		}
		if(resultList != null)
		{
		    addParameter("resultList", findString(resultList));
		}
		if(autoSearch != null)
		{
		    addParameter("autoSearch", findString(autoSearch));
		}
		if(searchElement != null)
		{
		    addParameter("searchElement", findString(searchElement));
		}
		if(onOkMethod != null)
		{
		    addParameter("onOkMethod", findString(onOkMethod));
		}
		if(paramList != null)
		{
		    addParameter("paramList", findString(paramList));
		}
		if(StringUtil.isNotEmpty(cssStyle))
		{
		    addParameter("cssStyle", findString(cssStyle));
		}
		if(mode != null)
		{
		    formatter = "defaultNumFmatter";
		    if(nbFormat == null)
		    {
			nbFormat = "#"; // code format
		    }
		    addParameter("formatter", findString(formatter));
		    addParameter("mode", findString(mode));
		    addParameter("nbFormat", findString(nbFormat));
		    if(leadZeros != null)
		    {
			addParameter("leadZeros", findString(leadZeros));
		    }
		    if(minValue != null)
		    {
			addParameter("minValue", findString(minValue));
		    }
		    if(maxValue != null)
		    {
			addParameter("maxValue", findString(maxValue));
		    }
		}
                if(multiSelect != null)
                {
                    addParameter("multiSelect",findString(multiSelect));
                    if(ConstantsCommon.TRUE.equals(multiSelect) && ConstantsCommon.TRUE.equals(_recReadOnly) && !ConstantsCommon.TRUE.equals(StringUtil.nullToEmpty(overrideRecReadOnly)))
                    {
                	editable = "true";
                	addParameter("editable", findValue(editable,Boolean.class));
                    }	
                }
                if(multiResultInput != null)
                {
                    addParameter("multiResultInput",findString(multiResultInput));
                }
                if(selectColumn != null)
                {
                    addParameter("selectColumn",findString(selectColumn));
                }
                
                if(StringUtil.isNotEmpty(readOnlyMode))
                {
                    if(readOnlyMode=="true" && multiSelect=="true")
                    {
                	editable = "true";
                    }
                    addParameter("readOnlyMode",findString(readOnlyMode));
                }
                
                // TP 887297  
        	if(!StringUtil.nullToEmpty(dontLoadData).isEmpty())
        	{
        	    addParameter("dontLoadData",findString(dontLoadData));
        	}
                
		addParameter("edittype", findString(edittype)); 
		addParameter("editoptions", findString(editoptions));
	    }
	    else if("date".equals(colType))
	    {
		formatter = "date";
		// check for formatoptions and put the default values if they
		// dont exist
		if(formatoptions == null)
		{
		    String gridDateformat = RootUtil.returnGridDateMask(request.getSession());
		    formatoptions = "{reformatAfterEdit:true, srcformat: 'Y-m-d',newformat: '" + gridDateformat + "'}";
		}
		else
		{
		    formatoptions = formatoptions.substring(0, 1) + "reformatAfterEdit:true,"
			    + formatoptions.substring(1);
		    if(formatoptions.indexOf("srcformat") < 0)
		    {
			formatoptions = formatoptions.substring(0, 1) + "srcformat: 'Y-m-d',"
				+ formatoptions.substring(1);
		    }
		    if(formatoptions.indexOf("newformat") < 0)
		    {
			formatoptions = formatoptions.substring(0, 1).concat("newformat: 'd/m/Y',").concat(formatoptions.substring(1));
		    }
		}
		addParameter("formatoptions", findString(formatoptions));
		addParameter("formatter", findString(formatter));
		// add datepicker on columns of type date when edit
		if(editable != null && editable.equals("true") && !("true").equals(hidden))
		{
		    String timeOutFn;
		    dateFormat = RootUtil.returnDateMask(request.getSession());
		    if(formatoptions.indexOf("timepicker") < 0)
		    {
			timeOutFn = "setTimeout(function() {initDatePicker(el,'" + dateFormat + "','false')},200)";
		    }
		    else
		    {
			JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(formatoptions);
			Boolean isDateTimePicker = jsonObject.getBoolean("timepicker");
			if(isDateTimePicker)
			{
			    timePicker = "true";
			    addParameter("timePicker", findString(timePicker));
			    String timeFormat = jsonObject.has("timeFormat") ? jsonObject.getString("timeFormat")
				    : "hh:mm";
			    addParameter("timeFormat", timeFormat);
			    StringBuilder timepickerfmt = new StringBuilder("dateFormat:'" + dateFormat
				    + "',timeFormat:'" + timeFormat + "'");
			    if(jsonObject.has("timepickerOnly"))
			    {
				timepickerfmt.append(",tponly : true");
			    }
			    Boolean showSecond = jsonObject.has("showSecond") ? jsonObject.getBoolean("showSecond")
				    : false;
			    Boolean ampm = jsonObject.has("ampm") ? jsonObject.getBoolean("ampm") : false;

			    if(ampm)
			    {
				timepickerfmt.append(",ampm: true");
			    }
			    if(showSecond)
			    {
				timepickerfmt.append(",showSecond: true");
			    }

			    timeOutFn = "loadTimePicker() ;setTimeout(function() { initDatePicker(el,{" + timepickerfmt
				    + "},'true')},200)";
			    dateFormat = "{" + timepickerfmt + "}";
			}
			else
			{
			    timeOutFn = "setTimeout(function() {initDatePicker(el,'" + dateFormat + "','false')},200)";
			}
		    }
		    addParameter("dateFormat", findString(dateFormat));
		    String datePickerFn = " function(el){" + timeOutFn + "}";
		    if(editoptions == null)
		    {
			editoptions = "{ dataInit:" + datePickerFn + "}";
		    }
		    else if(!editoptions.isEmpty() && editoptions.indexOf("dataInit") < 0)
		    {
			editoptions = editoptions.substring(0, 1) + " dataInit:" + datePickerFn + ","
				+ editoptions.substring(1);
		    }
		    else if(editoptions.indexOf("dataInit") > 0)
		    {
			int indexOfFnStart = 0;// index of { starting
			// dataInit:function(t)
			indexOfFnStart = editoptions.indexOf("{", editoptions.indexOf(":", editoptions
				.indexOf("dataInit"))) + 1;
			editoptions = editoptions.substring(0, indexOfFnStart) + timeOutFn + ","
				+ editoptions.substring(indexOfFnStart);
		    }
		    addParameter("editoptions", findString(editoptions));
		}
	    }
	    else // Text Column Type
	    if("text".equals(colType) && searchoptions == null)
	    {
		// check if no search options is defined then set default for
		// Text
		addParameter("searchoptions", "{sopt:['eq','ne','bw','bn','ew','en','cn','nc','nu','nn']}");
		if(maxDisplayLen != null && !maxDisplayLen.trim().isEmpty())
		{
		    addParameter("maxDisplayLen", findString(maxDisplayLen));
		}
	    }
	    // adding editrules for required
	    if(StringUtil.nullToEmpty(required).equals("true"))
	    {
		if(editrules == null)
		{
		    editrules = "{required:true}";
		}
		else if(editrules.indexOf("required") < 0)
		{
		    String temp = editrules.substring(0, editrules.lastIndexOf("}"));
		    temp = temp.concat(", required:true");
		    editrules = temp .concat("}");
		}
		addParameter("editrules", findString(editrules));
	    }
	}
	if(dependency != null)
	{
	    String escapedDep = findString(dependency);
	    escapedDep = StringUtil.removeNewLineTabSpace(escapedDep);
	    addParameter("dependency", escapedDep);
	}
	if(dependencySrc != null)
	{
	    addParameter("dependencySrc", findString(dependencySrc));
	}
	if(params != null)
	{
	    String escapedParms = findString(params);
	    escapedParms = StringUtil.removeNewLineTabSpace(escapedParms);
	    addParameter("params", escapedParms);
	}
	if(dialogOptions != null)
	{
	    addParameter("dialogOptions", findString(dialogOptions));
	}
	if(dialogUrl != null)
	{
	    addParameter("dialogUrl", findString(dialogUrl));
	}
	if(searchType != null)
	{
	    addParameter("searchType", findString(searchType));
	}
	if(searchRules != null)
	{
	    addParameter("searchRules", findString(searchRules));
	}
	if(frozen != null)
	{
	    addParameter("frozen", findValue(frozen, Boolean.class));
	}
	if(loadOnce != null)
	{
	    addParameter("loadOnce", findValue(loadOnce, Boolean.class));
	}
	if(afterDepEvent != null)
	{
	    addParameter("afterDepEvent", findString(afterDepEvent));
	}
	if(beforeDepEvent != null)
	{
	    addParameter("beforeDepEvent", findString(beforeDepEvent));
	}
	if(unformat != null)
	{
	    addParameter("unformat", findString(unformat));
	}
	if(reConstruct != null)
	{
	    addParameter("reConstruct", findString(reConstruct));
	}
	if(getMinLength() != null)
	{
	    if(editoptions == null)
	    {
		editoptions = "{ minLength:" + getMinLength() + "}";
	    }
	    else if(!editoptions.isEmpty() && editoptions.indexOf("minLength") < 0)
	    {
		editoptions = editoptions.substring(0, 1) + " minLength:" + getMinLength() + "," + editoptions.substring(1);
	    }
	    else if(editoptions.indexOf("minLength") > 0 && editoptions.indexOf(":" + getMinLength()) < 0)
	    {
		int indexOfFnStart = 0;// index of { starting
		// dataInit:function(t)
		indexOfFnStart = editoptions.indexOf("{", editoptions.indexOf(":", editoptions.indexOf("minLength"))) + 1;
		editoptions = editoptions.substring(0, indexOfFnStart) + getMinLength() + ","
			+ editoptions.substring(indexOfFnStart);
	    }
	    addParameter("editoptions", findString(editoptions));
	}
	if(getMaxLength() != null)
	{
	    if(editoptions == null)
	    {
		editoptions = "{ maxLength:" + getMaxLength() + "}";
	    }
	    else if(!editoptions.isEmpty() && editoptions.indexOf("maxLength") < 0)
	    {
		editoptions = editoptions.substring(0, 1) + " maxLength:" + getMaxLength() + "," + editoptions.substring(1);
	    }
	    else if(editoptions.indexOf("maxLength") > 0 && editoptions.indexOf(":" + getMaxLength()) < 0)
	    {
		int indexOfFnStart = 0;// index of { starting
		// dataInit:function(t)
		indexOfFnStart = editoptions.indexOf("{", editoptions.indexOf(":", editoptions.indexOf("maxLength"))) + 1;
		editoptions = editoptions.substring(0, indexOfFnStart) + getMaxLength() + ","
			+ editoptions.substring(indexOfFnStart);
	    }
	    addParameter("editoptions", findString(editoptions));
	}
	/**
	 * [TP#1043972] OnChange Event For Grid Column- Editable Grid Customization Enhancements
	 * validate if column is editable and not hidden then apply onchange event for grid column 
	 * and doesn't apply it for custom data types except livesearch component
	 */
	boolean others_liveSearchOfCustom = ("custom".equals(edittype) && !"livesearch".equalsIgnoreCase(colType))?false:true;
	if((StringUtil.nullToEmpty(hidden).equals("false") || hidden == null) && StringUtil.nullToEmpty(editable).equals("true") && others_liveSearchOfCustom)
	{
	    //return activities list for a custom element 
	    List<CustomElementActivitiesSC> activitiesVOList = RootUtil.returnParamElemActivities(request, grid.getId());
	    if(activitiesVOList != null && activitiesVOList.size() > 0)
	    {
		//iterate list of activities and compare the grid column name to apply the change event if matched. 
		for(CustomElementActivitiesSC activityVO : activitiesVOList)
		{
		    if(activityVO.getGridColumnName() != null && !activityVO.getGridColumnName().isEmpty() && activityVO.getGridColumnName().equals(name))
		    {
			SYS_PARAM_ELEM_ACTIVITIESVO sysParamElemActivityVO = activityVO.getSysParamElemActivitiesVO();

			//fill SYS_PARAM_SCREEN_DISPLAYVO to get customBtnDataMap
			theVO = new SYS_PARAM_SCREEN_DISPLAYVO(); 
			theVO.setAPP_NAME(sysParamElemActivityVO.getAPP_NAME());
			theVO.setPROG_REF(sysParamElemActivityVO.getPROG_REF());
			theVO.setElemSequenceId(sysParamElemActivityVO.getSEQUENCE_ID());
			theVO.setFLD_IDENTIFIER(sysParamElemActivityVO.getFLD_IDENTIFIER());

			if(ButtonCustomizationConstants.ACTIVITY_TYPE.ONCHANGE.equals(sysParamElemActivityVO.getACTIVITY_TYPE()))
			{
			    BigDecimal compCode = activityVO.getCompCode() != null ? activityVO.getCompCode() : BigDecimal.ZERO;
			    Map<String, Object> customBtnDataMap = RootUtil.returnButtonCustActionData(request, sysParamElemActivityVO.getACTIVITY_ID(), true, theVO);
			    customBtnDataMap.put("dynScreenAppName", sysParamElemActivityVO.getAPP_NAME());
			    customBtnDataMap.put("dynScreenProgRef", sysParamElemActivityVO.getPROG_REF());
			    customBtnDataMap.put("dynScreenCompCode", compCode);
			    customBtnDataMap.put("dynScreenFldIdentifier", sysParamElemActivityVO.getFLD_IDENTIFIER());
			    customBtnDataMap.put("isGlobalActivity", true);
			    customBtnDataMap.put("elemSequenceId", sysParamElemActivityVO.getSEQUENCE_ID());
			    customBtnDataMap.put("proceedExpression", sysParamElemActivityVO.getPROCEED_ON_EXPRESSION());
			    customBtnDataMap.put("proceedOnFail", ConstantsCommon.ONE.equals(sysParamElemActivityVO.getPROCEED_ON_FAIL()));
			    customBtnDataMap.put("screenWidth", sysParamElemActivityVO.getSCREEN_WIDTH());
			    customBtnDataMap.put("screenHeight", sysParamElemActivityVO.getSCREEN_HEIGHT());
			    customBtnDataMap.put("screenTitle", sysParamElemActivityVO.getSCREEN_TITLE());
			    customBtnDataMap.put("gridId", grid.getId());
			    try
			    {
				RootUtil.addScreenElements(customBtnDataMap, activitiesVOList,request);
				customBtnData = PathJSONUtil.strutsJsonSerialize(customBtnDataMap, null, null, false, true);
				if("liveSearch".equalsIgnoreCase(colType))
				{
				    addParameter("customBtnData", findString(customBtnData));
				}

				String initialOnChange = onchange;
				String customBtnActionCall = "var stopPropagation = customBtnActionCall(e.target.id, '0',"
					+ ("1".equals(sysParamElemActivityVO.getPROCEED_ON_FAIL()))+"," + customBtnData + "); if(!stopPropagation){"+ initialOnChange + "}";
				String dataEventsFn = "fn: function(e) { if(!e) {e = window.event} " + customBtnActionCall + "}";
				String dataEvents_changeEvent = "{ type: 'change', " + dataEventsFn + "}";

				if(editoptions == null)
				{
				    editoptions = "{dataEvents:[" + dataEvents_changeEvent + "]}";
				}
				else if(!editoptions.isEmpty())
				{
				    /**
				     * validate if dataEvents properties already applied then only add change event
				     * otherwise add it with property dataEvent
				     */
				    if(editoptions.indexOf("dataEvents") > 0)
				    {
					int indexOfFnStart = 0;// index of { starting
					indexOfFnStart = editoptions.indexOf("[", editoptions.indexOf(":", editoptions.indexOf("dataEvents"))) + 1; // index of [ in dataEvents
					editoptions = editoptions.substring(0, indexOfFnStart) + dataEvents_changeEvent + "," + editoptions.substring(indexOfFnStart);
				    }
				    else
				    {
					dataEvents_changeEvent = "dataEvents:[" + dataEvents_changeEvent + "]";
					editoptions = editoptions.substring(0, 1) + dataEvents_changeEvent + "," + editoptions.substring(1);
				    }
				}
				addParameter("editoptions", findString(editoptions));
			    }
			    catch(Exception e)
			    {
				customBtnData = null;
				Log.getInstance().error(e, "Error in applying onChange event for Grid Column " + name);
			    }
			    break;
			}
		    }
		}
	    }
	}
	//the super.start() should be called at the end of the method
	return super.start(arg0);
    }

    public void setColType(String colType)
    {
	this.colType = colType;
    }

    public String getDependency()
    {
	return dependency;
    }

    public void setDependency(String dependency)
    {
	this.dependency = dependency;
    }

    public String getDependencySrc()
    {
	return dependencySrc;
    }

    public void setDependencySrc(String dependencySrc)
    {
	this.dependencySrc = dependencySrc;
    }

    public String getParams()
    {
	return params;
    }

    public void setParams(String params)
    {
	this.params = params;
    }

    public String getDialogOptions()
    {
	return dialogOptions;
    }

    public void setDialogOptions(String dialogOptions)
    {
	this.dialogOptions = dialogOptions;
    }

    public String getDialogUrl()
    {
	return dialogUrl;
    }

    public void setDialogUrl(String dialogUrl)
    {
	this.dialogUrl = dialogUrl;
    }

    public String getSearchType()
    {
	return searchType;
    }

    public void setSearchType(String searchType)
    {
	this.searchType = searchType;
    }

    public String getSearchRules()
    {
	return searchRules;
    }

    public void setSearchRules(String searchRules)
    {
	this.searchRules = searchRules;
    }

    public String getDataAction()
    {
	return dataAction;
    }

    public void setDataAction(String dataAction)
    {
	this.dataAction = dataAction;
    }

    public String getResultList()
    {
	return resultList;
    }

    public void setResultList(String resultList)
    {
	this.resultList = resultList;
    }

    public String getAutoSearch()
    {
	return autoSearch;
    }

    public void setAutoSearch(String autoSearch)
    {
	this.autoSearch = autoSearch;
    }

    public String getSearchElement()
    {
	return searchElement;
    }

    public void setSearchElement(String searchElement)
    {
	this.searchElement = searchElement;
    }

    public String getOnOkMethod()
    {
	return onOkMethod;
    }

    public void setOnOkMethod(String onOkMethod)
    {
	this.onOkMethod = onOkMethod;
    }

    public String getParamList()
    {
	return paramList;
    }

    public void setParamList(String paramList)
    {
	this.paramList = paramList;
    }

    public String getFrozen()
    {
	return frozen;
    }

    public void setFrozen(String frozen)
    {
	this.frozen = frozen;
    }

    public String getLoadOnce()
    {
	return loadOnce;
    }

    public void setLoadOnce(String loadOnce)
    {
	this.loadOnce = loadOnce;
    }

    public String getAfterDepEvent()
    {
	return afterDepEvent;
    }

    public void setAfterDepEvent(String afterDepEvent)
    {
	this.afterDepEvent = afterDepEvent;
    }

    public String getLeadZeros()
    {
	return leadZeros;
    }

    public void setLeadZeros(String leadZeros)
    {
	this.leadZeros = leadZeros;
    }

    public String getNbFormat()
    {
	return nbFormat;
    }

    public void setNbFormat(String nbFormat)
    {
	this.nbFormat = nbFormat;
    }

    public String getFormatCol()
    {
	return formatCol;
    }

    public void setFormatCol(String formatCol)
    {
	this.formatCol = formatCol;
    }

    public String getDateFormat()
    {
	return dateFormat;
    }

    public void setDateFormat(String dateFormat)
    {
	this.dateFormat = dateFormat;
    }

    public String getTimePicker()
    {
	return timePicker;
    }

    public void setTimePicker(String timePicker)
    {
	this.timePicker = timePicker;
    }

    public String getBeforeDepEvent()
    {
	return beforeDepEvent;
    }

    public void setBeforeDepEvent(String beforeDepEvent)
    {
	this.beforeDepEvent = beforeDepEvent;
    }

    public String getApplyRounding()
    {
	return applyRounding;
    }

    public void setApplyRounding(String applyRounding)
    {
	this.applyRounding = applyRounding;
    }

    public String getMode()
    {
	return mode;
    }

    public void setMode(String mode)
    {
	this.mode = mode;
    }

    public String getUnformat()
    {
	return unformat;
    }

    public void setUnformat(String unformat)
    {
	this.unformat = unformat;
    }

    public String getMinValue()
    {
	return minValue;
    }

    public void setMinValue(String minValue)
    {
	this.minValue = minValue;
    }

    public String getMaxValue()
    {
	return maxValue;
    }

    public void setMaxValue(String maxValue)
    {
	this.maxValue = maxValue;
    }

    public String getOverrideRecReadOnly()
    {
	return overrideRecReadOnly;
    }

    public void setOverrideRecReadOnly(String overrideRecReadOnly)
    {
	this.overrideRecReadOnly = overrideRecReadOnly;
    }

    /**
     * @return the maxLenBeforeDec
     */
    public String getMaxLenBeforeDec()
    {
        return maxLenBeforeDec;
    }

    /**
     * @param maxLenBeforeDec the maxLenBeforeDec to set
     */
    public void setMaxLenBeforeDec(String maxLenBeforeDec)
    {
        this.maxLenBeforeDec = maxLenBeforeDec;
    }

    public String getReConstruct()
    {
        return reConstruct;
    }

    public void setReConstruct(String reConstruct)
    {
        this.reConstruct = reConstruct;
    }

    public String getMinLength()
    {
        return minLength;
    }

    public void setMinLength(String minLength)
    {
        this.minLength = minLength;
    }

    public String getMaxLength()
    {
        return maxLength;
    }

    public void setMaxLength(String maxLength)
    {
        this.maxLength = maxLength;
    }

    public String getFromCustomization()
    {
        return fromCustomization;
    }

    public void setFromCustomization(String fromCustomization)
    {
        this.fromCustomization = fromCustomization;
    }

    public String getMaxDisplayLen()
    {
        return maxDisplayLen;
    }

    public void setMaxDisplayLen(String maxDisplayLen)
    {
        this.maxDisplayLen = maxDisplayLen;
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
     * @return the multiResultInput
     */
    public String getMultiResultInput()
    {
        return multiResultInput;
    }

    /**
     * @param multiResultInput the multiResultInput to set
     */
    public void setMultiResultInput(String multiResultInput)
    {
        this.multiResultInput = multiResultInput;
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
     * @return the readOnlyMode
     */
    public String getReadOnlyMode()
    {
        return readOnlyMode;
    }

    /**
     * @param readOnlyMode the readOnlyMode to set
     */
    public void setReadOnlyMode(String readOnlyMode)
    {
        this.readOnlyMode = readOnlyMode;
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

    /**
     * @return the customBtnData
     */
    public String getCustomBtnData()
    {
	return customBtnData;
    }

    /**
     * @param customBtnData the customBtnData to set
     */
    public void setCustomBtnData(String customBtnData)
    {
	this.customBtnData = customBtnData;
    }

}
