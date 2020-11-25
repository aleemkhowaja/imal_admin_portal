package com.path.vo.admin.dynamicparams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.BaseVO;
import com.path.vo.common.screengenerator.DynScrTableColsCO;

public class DynamicParamsVO extends BaseVO
{
    String label;
    String labelKeyCode;
    String labelId;
    String labelForElemId;
    String element_type;
    String element_dataType;
    String id;
    String name;
    ListParamVO listParamVO;
    Integer row;
    Integer column;
    String nbFormat;
    String formatter;
    String value;
    String targets;
    String readOnly;
    String visible;
    String cssStyle;
    Integer maxLength;
    BigDecimal maxValue;
    BigDecimal minValue;
    BigDecimal maxLenBeforeDec;
    String maxValueStr;
    String minValueStr;
    String maxLenBeforeDecStr;
    String mode;
    String jspIncludeDiv;
    // datepicker
    /**
     * to specify where datepicker need to be with Time or not (true means with time)
     */
    String dateWithTime;
    String dateTimeAmPm;
    String showHijri;
    String showOnlyHijri;
    String timepicker;
    String timepickerOnly;
    //Table id
    String tableId;
    //enable search property for grid
    String enblSearch;
    // livesearch attributes
    String parameters;
    String dependency;
    String dependencySrc;
    String actionName;
    String searchElement;
    String paramList;
    String gridIdList;
    String resultList;
    String onchange;
    String afterDepEvent;
    /**
     * used for button only
     */
    private String onClick;

    /**
     * Upper and lower cases 
     */
    private boolean upperCase;
    private boolean lowerCase;
    private String  cssClass;
    private String  txtFormat;
    /**
     * multiselection livesearch attributes multiSelect,multiResultInput,selectColumn
     */
    private String  multiSelect;
    private String  multiResultInput;
    private String  selectColumn;
    
    private String  required;
    private boolean positionAbsolute;
    private String  valOpt;
    private String  onLoadScript;
    private String  colspan;
    private BigDecimal techId;
    private BigDecimal parentTechId;
    private String     title;
    //List of text fields on screen to be chosen as description fields for liveSearch element
    private String	lookupDesc;
    //List of elements available on screen to be assigned for label.
    private String	labelFor;
    private String      considerChoiceValue;
    
    //471675 added to handle button scripts.
    private String buttonScript;
    
    private String onChangeScript;
    
    private String relatedCol;
    
    //Bug 514831 Handling Radio Group label
    private String 	groupLabel;
    private String emptyOption;
    private String allowDefValCust;
    private String zeroNotAllowed;
    
    // for grid elements
    private List<DynScrTableColsCO>  colsLst;
    private String height;
    private String editable;
    
    /**
     * added to cover the Omni admin needs, where the icons that will appear on the button are dynamic based on the button business 
     */
    private String buttonIcon;
    
    // TP #864592 : added to handle rendering download button in a file
    private String renderFileDownloadBtn;
    
    public DynamicParamsVO()
    {
	listParamVO = new ListParamVO();
	colsLst = new ArrayList<DynScrTableColsCO>();
	label = "";
	element_type = "";
	element_dataType = "";
	id = "";
	name = "";
	nbFormat = "";
	value = "";
	targets = "";
	readOnly = "false";
	required = "false";
	visible = "true";
	emptyOption = "false";
    }

    private String footerRow;
    
    private String defaultValueAvailable;
    
    private String sortable = "true";
    
    public String getLabel()
    {
	return label;
    }

    public void setLabel(String label)
    {
	this.label = label;
    }

    public String getElement_type()
    {
	return element_type;
    }

    public void setElement_type(String elementType)
    {
	element_type = elementType;
    }

    public String getElement_dataType()
    {
	return element_dataType;
    }

    public void setElement_dataType(String elementDataType)
    {
	element_dataType = elementDataType;
    }

    public String getId()
    {
	return id;
    }

    public void setId(String id)
    {
	this.id = id;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public Integer getRow()
    {
	return row;
    }

    public void setRow(Integer row)
    {
	this.row = row;
    }

    public Integer getColumn()
    {
	return column;
    }

    public void setColumn(Integer column)
    {
	this.column = column;
    }

    public String getNbFormat()
    {
	return nbFormat;
    }

    public void setNbFormat(String nbFormat)
    {
	this.nbFormat = nbFormat;
    }

    public ListParamVO getListParamVO()
    {
	return listParamVO;
    }

    public void setListParamVO(ListParamVO listParamVO)
    {
	this.listParamVO = listParamVO;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getTargets()
    {
        return targets;
    }

    public void setTargets(String targets)
    {
        this.targets = targets;
    }

    public String getReadOnly()
    {
        return readOnly;
    }

    public void setReadOnly(String readOnly)
    {
        this.readOnly = readOnly;
    }

    public String getVisible()
    {
	    return this.visible;
    }
    public String getCssStyle()
    {
	if(StringUtil.nullToEmpty(this.visible).equals("false"))
	{
	    return "display:none;";
	}
	return cssStyle;
    }

    public void setVisible(String visible)
    {
        this.visible = visible;
    }

    public String getParameters()
    {
        return parameters;
    }

    public void setParameters(String parameters)
    {
        this.parameters = parameters;
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

    public String getActionName()
    {
        return actionName;
    }

    public void setActionName(String actionName)
    {
        this.actionName = actionName;
    }

    public String getMode()
    {
        return mode;
    }

    public void setMode(String mode)
    {
        this.mode = mode;
    }

    public String getSearchElement()
    {
        return searchElement;
    }

    public void setSearchElement(String searchElement)
    {
        this.searchElement = searchElement;
    }

    public String getParamList()
    {
        return paramList;
    }

    public void setParamList(String paramList)
    {
        this.paramList = paramList;
    }

    public String getResultList()
    {
        return resultList;
    }

    public void setResultList(String resultList)
    {
        this.resultList = resultList;
    }

    public String getOnchange()
    {
        return onchange;
    }

    public void setOnchange(String onchange)
    {
        this.onchange = onchange;
    }

    public String getLabelId()
    {
        return labelId;
    }

    public void setLabelId(String labelId)
    {
        this.labelId = labelId;
    }

    public String getOnClick()
    {
        return onClick;
    }

    public void setOnClick(String onClick)
    {
        this.onClick = onClick;
    }

    public String getDateWithTime()
    {
        return dateWithTime;
    }

    public void setDateWithTime(String dateWithTime)
    {
        this.dateWithTime = dateWithTime;
    }

    public String getDateTimeAmPm()
    {
        return dateTimeAmPm;
    }

    public void setDateTimeAmPm(String dateTimeAmPm)
    {
        this.dateTimeAmPm = dateTimeAmPm;
    }

    public void setCssStyle(String cssStyle)
    {
        this.cssStyle = cssStyle;
    }

    public Integer getMaxLength()
    {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength)
    {
        this.maxLength = maxLength;
    }
    /**
     * return maxValue as String 
     * @return
     */
    public String getMaxValueStr()
    {
	if(maxValue != null)
	{
	    return maxValue.toString();
	}
	return null;
    }

    public void setMaxValue(BigDecimal maxValue)
    {
        this.maxValue = maxValue;
    }

    public void setMinValue(BigDecimal minValue)
    {
        this.minValue = minValue;
    }
    /**
     * return minValue as String 
     * @return
     */
    public String getMinValueStr()
    {
	if(minValue != null)
	{
	    return minValue.toString();
	}
	return null;
    }

    public String getLabelForElemId()
    {
        return labelForElemId;
    }

    public void setLabelForElemId(String labelForElemId)
    {
        this.labelForElemId = labelForElemId;
    }

    /**
     * @return the cssClass
     */
    public String getCssClass()
    {
        return cssClass;
    }

    /**
     * @param cssClass the cssClass to set
     */
    public void setCssClass(String cssClassArg)
    {
	String classToAdd = "";
	String cssClass   = cssClassArg;
	/**
	 * [MarwanMaddah]: in case upperCase is True
	 * will remove the lower case class in case exists and add the upper case css class
	 * in case upperCase is False 
	 * will remove the upper case class in case exists and then will check the lower case concept
	 * based on the same behavior  
	 */
	if(isUpperCase())
	{
	    if(!StringUtil.nullToEmpty(cssClass).isEmpty())
	    {
	       cssClass   = cssClass.replace("path-lower-case", "");
	    }
	    classToAdd = "path-upper-case";
	}
	else 
	{
	    if(!StringUtil.nullToEmpty(cssClass).isEmpty())
	    {
	       cssClass = cssClass.replace("path-upper-case", "");
	    }
	    if(isLowerCase())
	    {
		classToAdd = "path-lower-case"; 
	    }
	    else
	    {
		if(!StringUtil.nullToEmpty(cssClass).isEmpty())
		{
		  cssClass = cssClass.replace("path-lower-case", "");
		}
	    }
	}
	
	if(!StringUtil.nullToEmpty(classToAdd).isEmpty())
	{
	   cssClass = StringUtil.nullToEmpty(cssClass).isEmpty()?classToAdd :cssClass.concat(" ").concat(classToAdd);
	}
	this.cssClass = cssClass;
    }

    /**
     * @return the upperCase
     */
    public boolean isUpperCase()
    {
        return upperCase;
    }

    /**
     * @param upperCase the upperCase to set
     */
    public void setUpperCase(boolean upperCase)
    {
        this.upperCase = upperCase;
        /**
         * reset cssClass with UpperCase Management
         */
        setCssClass(cssClass);
    }

    /**
     * @return the lowerCase
     */
    public boolean isLowerCase()
    {
        return lowerCase;
    }

    /**
     * @param lowerCase the lowerCase to set
     */
    public void setLowerCase(boolean lowerCase)
    {
        this.lowerCase = lowerCase;
        /**
         * [MarwanMaddah]reset cssClass with lowerCase management
         */
        setCssClass(cssClass);        
    }

    public String getMaxLenBeforeDecStr()
    {
	if(maxLenBeforeDec != null)
	{
	    return maxLenBeforeDec.toString();
	}
	return null;
    }

    public void setMaxLenBeforeDec(BigDecimal maxLenBeforeDec)
    {
        this.maxLenBeforeDec = maxLenBeforeDec;
    }

    public String getTxtFormat()
    {
        return txtFormat;
    }

    public void setTxtFormat(String txtFormat)
    {
        this.txtFormat = txtFormat;
    }

    public String getMultiSelect()
    {
        return multiSelect;
    }

    public void setMultiSelect(String multiSelect)
    {
        this.multiSelect = multiSelect;
    }

    public String getMultiResultInput()
    {
        return multiResultInput;
    }

    public void setMultiResultInput(String multiResultInput)
    {
        this.multiResultInput = multiResultInput;
    }

    public String getSelectColumn()
    {
        return selectColumn;
    }

    public void setSelectColumn(String selectColumn)
    {
        this.selectColumn = selectColumn;
    }

    public String getJspIncludeDiv()
    {
        return jspIncludeDiv;
    }

    public void setJspIncludeDiv(String jspIncludeDiv)
    {
        this.jspIncludeDiv = jspIncludeDiv;
    }

    public String getRequired()
    {
        return required;
    }

    public void setRequired(String required)
    {
        this.required = required;
    }

    /**
     * @return the positionAbsolute
     */
    public boolean isPositionAbsolute()
    {
        return positionAbsolute;
    }

    /**
     * @param positionAbsolute the positionAbsolute to set
     */
    public void setPositionAbsolute(boolean positionAbsolute)
    {
        this.positionAbsolute = positionAbsolute;
    }

    /**
     * @return the valOpt
     */
    public String getValOpt()
    {
        return valOpt;
    }

    /**
     * @param valOpt the valOpt to set
     */
    public void setValOpt(String valOpt)
    {
        this.valOpt = valOpt;
    }

    /**
     * @return the showHijri
     */
    public String getShowHijri()
    {
        return showHijri;
    }

    /**
     * @param showHijri the showHijri to set
     */
    public void setShowHijri(String showHijri)
    {
        this.showHijri = showHijri;
    }

    /**
     * @return the showOnlyHijri
     */
    public String getShowOnlyHijri()
    {
        return showOnlyHijri;
    }

    /**
     * @param showOnlyHijri the showOnlyHijri to set
     */
    public void setShowOnlyHijri(String showOnlyHijri)
    {
        this.showOnlyHijri = showOnlyHijri;
    }

    /**
     * @return the onLoadScript
     */
    public String getOnLoadScript()
    {
        return onLoadScript;
    }

    /**
     * @param onLoadScript the onLoadScript to set
     */
    public void setOnLoadScript(String onLoadScript)
    {
        this.onLoadScript = onLoadScript;
    }

    public String getAfterDepEvent()
    {
        return afterDepEvent;
    }

    public void setAfterDepEvent(String afterDepEvent)
    {
        this.afterDepEvent = afterDepEvent;
    }

    public BigDecimal getParentTechId()
    {
        return parentTechId;
    }

    public void setParentTechId(BigDecimal parentTechId)
    {
        this.parentTechId = parentTechId;
    }

    public BigDecimal getTechId()
    {
        return techId;
    }

    public void setTechId(BigDecimal techId)
    {
        this.techId = techId;
    }

    public String getColspan()
    {
        return colspan;
    }

    public void setColspan(String colspan)
    {
        this.colspan = colspan;
    }

    public String getTimepicker()
    {
        return timepicker;
    }

    public void setTimepicker(String timepicker)
    {
        this.timepicker = timepicker;
    }

    public String getTimepickerOnly()
    {
        return timepickerOnly;
    }

    public void setTimepickerOnly(String timepickerOnly)
    {
        this.timepickerOnly = timepickerOnly;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getLookupDesc()
    {
        return lookupDesc;
    }

    public void setLookupDesc(String lookupDesc)
    {
        this.lookupDesc = lookupDesc;
    }

    public String getLabelFor()
    {
        return labelFor;
    }

    public void setLabelFor(String labelFor)
    {
        this.labelFor = labelFor;
    }

    /**
     * @return the considerChoiceValue
     */
    public String getConsiderChoiceValue()
    {
        return considerChoiceValue;
    }

    /**
     * @param considerChoiceValue the considerChoiceValue to set
     */
    public void setConsiderChoiceValue(String considerChoiceValue)
    {
        this.considerChoiceValue = considerChoiceValue;
    }

	public String getLabelKeyCode() {
		return labelKeyCode;
	}

	public void setLabelKeyCode(String labelKeyCode) {
		this.labelKeyCode = labelKeyCode;
	}

	public String getButtonScript()
	{
	    return buttonScript;
	}

	public void setButtonScript(String buttonScript)
	{
	    this.buttonScript = buttonScript;
	}

	public String getRelatedCol()
	{
	    return relatedCol;
	}

	public void setRelatedCol(String relatedCol)
	{
	    this.relatedCol = relatedCol;
	}

	public String getGroupLabel()
	{
	    return groupLabel;
	}

	public void setGroupLabel(String groupLabel)
	{
	    this.groupLabel = groupLabel;
	}

	/**
	 * @return the emptyOption
	 */
	public String getEmptyOption()
	{
	    return emptyOption;
	}

	/**
	 * @param emptyOption the emptyOption to set
	 */
	public void setEmptyOption(String emptyOption)
	{
	    this.emptyOption = emptyOption;
	}
    
	/**
	 * @return the allowDefValCust
	 */
	public String getAllowDefValCust()
	{
	    return allowDefValCust;
	}

	/**
	 * @param allowDefValCust the allowDefValCust to set
	 */
	public void setAllowDefValCust(String allowDefValCust)
	{
	    this.allowDefValCust = allowDefValCust;
	}

	/**
	 * @return the formatter
	 */
	public String getFormatter()
	{
	    return formatter;
	}

	/**
	 * @param formatter the formatter to set
	 */
	public void setFormatter(String formatter)
	{
	    this.formatter = formatter;
	}

	/**
	 * @return the zeroNotAllowed
	 */
	public String getZeroNotAllowed()
	{
	    return zeroNotAllowed;
	}

	/**
	 * @param zeroNotAllowed the zeroNotAllowed to set
	 */
	public void setZeroNotAllowed(String zeroNotAllowed)
	{
	    this.zeroNotAllowed = zeroNotAllowed;
	}
	
        /**
         * @return the grid columns
         */
        public List<DynScrTableColsCO> getColsLst()
        {
    	return colsLst;
        }
    
        /**
         * @param colsLst
         */
        public void setColsLst(List<DynScrTableColsCO> colsLst)
        {
    	this.colsLst = colsLst;
        }

        /**
         * @return the element height
         */
	public String getHeight()
	{
	    return height;
	}
	
	 /**
         * @param height
         */
	public void setHeight(String height)
	{
	    this.height = height;
	}

	public String getEditable()
	{
	    return editable;
	}

	public void setEditable(String editable)
	{
	    this.editable = editable;
	}

	/**
	 * @return the onChangeScript
	 */
	public String getOnChangeScript()
	{
	    return onChangeScript;
	}

	/**
	 * @param onChangeScript the onChangeScript to set
	 */
	public void setOnChangeScript(String onChangeScript)
	{
	    this.onChangeScript = onChangeScript;
	}

	/**
	 * @return the buttonIcon
	 */
	public String getButtonIcon()
	{
	    return buttonIcon;
	}

	/**
	 * @param buttonIcon the buttonIcon to set
	 */
	public void setButtonIcon(String buttonIcon)
	{
	    this.buttonIcon = buttonIcon;
	}

	public String getRenderFileDownloadBtn() {
		return renderFileDownloadBtn;
	}

	public void setRenderFileDownloadBtn(String renderFileDownloadBtn) {
		this.renderFileDownloadBtn = renderFileDownloadBtn;
	}

	public String getTableId()
	{
	    return tableId;
	}

	public void setTableId(String tableId)
	{
	    this.tableId = tableId;
	}
	public String getEnblSearch()
	{
	    return enblSearch;
	}

	public void setEnblSearch(String enblSearch)
	{
	    this.enblSearch = enblSearch;
	}

	public String getGridIdList()
	{
	    return gridIdList;
	}

	public void setGridIdList(String gridIdList)
	{
	    this.gridIdList = gridIdList;
	}
	
	public String getFooterRow()
	{
	    return footerRow;
	}

	public void setFooterRow(String footerRow)
	{
	    this.footerRow = footerRow;
	}

	public String getDefaultValueAvailable()
	{
	    return defaultValueAvailable;
	}

	public void setDefaultValueAvailable(String defaultValueAvailable)
	{
	    this.defaultValueAvailable = defaultValueAvailable;
	}

	public String getSortable()
	{
	    return sortable;
	}

	public void setSortable(String sortable)
	{
	    this.sortable = sortable;
	}

}
