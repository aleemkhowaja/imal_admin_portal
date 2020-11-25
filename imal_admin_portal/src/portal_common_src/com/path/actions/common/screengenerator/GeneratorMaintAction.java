/**
 * 
 */
package com.path.actions.common.screengenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.util.PropertiesReader;
import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.screengenerator.GeneratorBO;
import com.path.dbmaps.vo.DSN_TEMPLATE_DETAILSVO;
import com.path.dbmaps.vo.SYS_DYN_SCREEN_ELEMENTS_DETVO;
import com.path.dbmaps.vo.TranslationKeyVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.customization.button.SysParamGlobalActArgMapSC;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
import com.path.vo.common.dynamicscreen.DynamicScreenConstant;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;
import com.path.vo.common.screengenerator.DynGridOutParameterCO;
import com.path.vo.common.screengenerator.DynGridParameterCO;
import com.path.vo.common.screengenerator.DynScreenGridRestCO;
import com.path.vo.common.screengenerator.DynScreenQueryCO;
import com.path.vo.common.screengenerator.DynamicScreenCreatorCO;
import com.path.vo.common.screengenerator.DynamicScreenDetailsCO;
import com.path.vo.common.screengenerator.ElementPropertiesDetCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * @author marwanmaddah
 * 
 */
public class GeneratorMaintAction extends GridBaseAction
{

    private String screenIds;
    private int bfSize;
    private GeneratorBO generatorBO;
    private String afterSubmit = "false";
    private String screenData;
    private String propertiesData;
    private String optionalData;
    private String additionalData;
    private InputStream fileInputStream;
    private TranslationKeyVO translationKey;

    private String TEMPLATE_NAME;
    private String TEMPLATE_ID;

    private String destination_id;
    private String newTemplateName;

    List<TranslationKeyVO> keysList = new ArrayList<TranslationKeyVO>();
    private ScreenGeneratorSC criteria = new ScreenGeneratorSC();
    private DynamicScreenCreatorCO dynScreenCreatorCO = new DynamicScreenCreatorCO();
    
    private DynScreenQueryCO       dynScreenQueryCO   = new DynScreenQueryCO();
    private DynScreenGridRestCO    dynScreenGridRestCO   = new DynScreenGridRestCO();
    private List<SelectCO> 		   tableDataSourceList = new ArrayList<SelectCO>();
    private List<SelectCO> colDataTypeList  = new ArrayList<SelectCO>();
    private String tableDatasource;
    private String addLkpDesc;//TP#1053820 Additional lookup Description
    private BigDecimal dynScreenWidth;
    /**
     * 
     * @author marwanmaddah
     * @date Oct 30, 2015
     * @return String
     * 
     */
    
    public String search()
    {
	try
	{
	    prepareDataToLoad();
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * 
     * To prepare the code from the selected JSP file and load it in the editor
     * of the designer ... will be used in combo change ...
     */
    public String loadTheSelectedScreen() throws Exception
    {
	prepareDataToLoad();
	return SUCCESS;
    }

    public String loadScreenGeneratorPage()
    {
	try
	{
	    set_searchGridId("screenGeneratorListGridTbl_Id");

	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "screenGeneratorList";
    }
    /**
     * @description return string tabbedPanelScreen
     * @createdBy Sajjad Soomro
     * @createdDate 11 Dec, 2019
     * 
     * @return String
     */
    public String loadTabbedPanelScreen()
    {
	return "tabbedPanelScreen";
    }
    /**
     * 
     * @author MarwanMaddah
     * @date   Feb 3, 2016
     * @return String
     *
     */
    public String loadOptionsScreen()
    {
	try{
	    set_searchGridId("optionsGridId");
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	
	return "optionsScreen";
    }
    public String loadSmartLabel()
    {
	return "smartLabel";
    }
    /**
     * 
     * @author marwanmaddah
     * @date   Feb 5, 2016
     * @return String
     *
     */
    public String loadQueryScreen()
    {
	try{
		String data ;
		if (criteria.getPropertyCode() != null && criteria.getPropertyCode().equals(ConstantsCommon.PROPERTY_CODE_OPTIONS) )
			data = criteria.getOptionsData();
		else 
			data = criteria.getQueryData();
		
	    if(!StringUtil.nullToEmpty(data).isEmpty())
	    {
	       JSONArray jsonQueryModel = (JSONArray) JSONSerializer.toJSON(data);
	       Object[] modelArr = jsonQueryModel.toArray();
	       JSONObject obj   = null ; 
	       if ( modelArr != null && modelArr.length > 0 ) 
	    	   		obj = (JSONObject) modelArr[0];
	       
	       if ( obj != null && (!obj.has("tableDatasource") || !obj.getString("tableDatasource").equals(ConstantsCommon.DATASOURCE_BY_GLOBAL_ACTIVITY)) ) {
	   	       dynScreenQueryCO = (DynScreenQueryCO) JSONObject.toBean(obj, DynScreenQueryCO.class);
	   	       dynScreenQueryCO.setTableDatasource(criteria.getTableDatasource());
	       }
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	
	return "queryScreen";
    }
    
    private StringBuffer openPanel(BigDecimal elt_type
	                          ,BigDecimal elt_id
	                          ,BigDecimal elt_top
	                          ,BigDecimal elt_left
	                          ,BigDecimal techId
	                          ,BigDecimal parentTechId
	                          ,BigDecimal elt_width
	                          ,BigDecimal elt_height
	                          ,String     elt_title)throws Exception
    {
	String type = "", theClass = "", additionalImg = "", elt_desc_tns = "", elt_desc = "";
	ServletContext application = ServletActionContext.getServletContext();
	String theRealPath = application.getContextPath();
	StringBuffer htmlStr = new StringBuffer();
	if(StringUtil.nullToEmpty(elt_title).isEmpty())
	{
	    elt_title = getText("title_key"); 
	}
	BigDecimal divWidth = BigDecimal.valueOf((elt_width == null)?150:(elt_width.intValue()+55));
	htmlStr.append("<div class='_newdrag' tnsKey='"+elt_desc+"' id='"+elt_id+"_div' type='"+elt_type+"' value='"+elt_desc+"' style='position:absolute; top:"+elt_top+"px; left:"+elt_left+"px; border: 1px dotted #000;overflow:hidden;cursor:move;width:"+divWidth+"px' status='"+elt_id+"' onkeydown='onkeydown' techId='"+techId+"' parentTechId='"+parentTechId+"'>");
	htmlStr.append("<div id='"+elt_id+"' class = '"+elt_id+"_div' style='");
	htmlStr.append("width:").append(elt_width.intValue()+5).append("px;");
	if(elt_height != null)
	{
	    htmlStr.append("height:").append(elt_height).append("px;");
	}
	String _contentHeight =  elt_height != null?String.valueOf(elt_height.intValue()-25).concat("px"):"98%";
	htmlStr.append("'").append(">");
	htmlStr.append("<div style='position:relative;width:98%;height:15px' class='collapsibleContainerTitle ui-state-focus ui-corner-top path-collapsable-header'>");
	htmlStr.append("<span id='"+elt_id+"_spanLabel' class='collapsibleLabel'>"+elt_title+"</span><span class='collapsibleIcon'><span class='ui-icon ui-icon-circle-triangle-n'></span></span></div>");
	htmlStr.append("<div id='"+elt_id+"_collapseDiv' style='position:relative; width:100%; height:"+_contentHeight+"; border-style:solid; border-width:thin; border-color:black;' class='"+elt_id+"_div droppable collapsibleContainerContent ui-widget-content'>");
	return htmlStr;
    }
    /**
     * @description close main tabbed panel div area
     * @createdBy Sajjad Soomro
     * @createdDate 17 Dec, 2019
     * 
     * @return StringBuffer htmlStr
     */
    private StringBuffer closeTabbedPanel()
    {
	StringBuffer htmlStr = new StringBuffer();
	htmlStr.append("</div>");
	htmlStr.append("</div>");
	return htmlStr;
    }
    /**
     * @description build main tabbed panel UI
     * @createdBy Sajjad Soomro
     * @createdDate 17 Dec, 2019
     * 
     * @return StringBuffer htmlStr
     */
    private StringBuffer openTabbedPanel(List<DynamicScreenCreatorCO> dataLst, Map<BigDecimal,StringBuffer> tabsHtmlMap, 
	    BigDecimal elt_type, BigDecimal elt_id, BigDecimal elt_top, BigDecimal elt_left, BigDecimal elt_width, 
	    BigDecimal elt_height, String elt_title, String id_attr, BigDecimal tech_id, BigDecimal parent_tech_id)
    {
	StringBuffer htmlStr = new StringBuffer();
	String parent_tech_id_attr = "";
	if(parent_tech_id != null) parent_tech_id_attr = "parenttechid='"+parent_tech_id+"'";
	htmlStr.append("<div class='_newdrag ui-draggable ui-resizable' tnskey='Button' id='"+elt_id+"_div' propid='"+id_attr+"' type='"+elt_type+"' value='Tab' style='position: absolute; top: "+elt_top+"px; left: "+elt_left+"px; border: 1.5px dashed rgb(0, 0, 0); overflow: hidden; cursor: move; width: "+elt_width+"px; height : "+elt_height+"px;' status='1' onkeydown='onkeydown' techid='"+tech_id+"' "+parent_tech_id_attr+" tabtype='main_tab'>");
	htmlStr.append("<div id='"+elt_id+"' class='"+elt_id+"_div' style=' width:"+elt_width+"px; height:"+elt_height+"px;' propid='"+id_attr+"'>");
	htmlStr.append("<div id='"+elt_id+"_tabbedPanelDiv' class='pathMinWidth ui-tabs ui-widget ui-widget-content ui-corner-all' style='visibility: visible; padding-bottom: 0px; padding-top: 0px; min-width:100%; overflow:hidden;'>");
	htmlStr.append("<ul class='ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all'>");
	
	BigDecimal tab_elt_type = null;
	BigDecimal tab_parentTechId = null, tab_techId=null, tab_elementId=null;
	BigDecimal activeTabIndex = BigDecimal.ZERO, activeTabId = null;
	String tab_id_attr = null;
	String tab_elt_title = "";

	for(int temp = 0; temp < dataLst.size(); temp++)
	{
	    DynamicScreenCreatorCO tempCO = dataLst.get(temp);
	    if(temp > 0 && !tab_elementId.equals(tempCO.getElementId()))
	    {
		if(tab_parentTechId!=null && tab_parentTechId.equals(tech_id) && tab_elt_type.intValue()==14)
		{
		    if(activeTabIndex.equals(BigDecimal.ZERO))
		    {
			activeTabId = tab_elementId;
		    }
		    htmlStr.append(generateTabTitle(tab_elementId, tab_elt_title, tab_id_attr, activeTabIndex, elt_id));
		    tabsHtmlMap.put(tab_techId, generateTabArea(tab_elt_type, tab_elementId, tab_id_attr, tab_techId, tab_parentTechId, activeTabId, elt_width, elt_height, elt_id));
		    if(activeTabIndex.equals(BigDecimal.ZERO))
		    {
			activeTabIndex = BigDecimal.ONE;
		    }
		}
	    }
		    
	    tab_techId 	     = tempCO.getTechId();
	    tab_parentTechId = tempCO.getParentTechId();
	    tab_elementId    = tempCO.getElementId();
	    tab_elt_type     = tempCO.getElementType();
	    tab_id_attr      = tempCO.getTheId();
	    String propertyCode  = tempCO.getProperty_code();
	    String propertyValue = tempCO.getProperty_value();
	    if(ConstantsCommon.PROPERTY_CODE_TITLE.equals(propertyCode))
	    {
		tab_elt_title = propertyValue;
	    }

	    if(temp == dataLst.size() - 1)
	    {
		// if last component is tab and has no element inside it then create tab.
		if(tab_parentTechId!=null && tab_parentTechId.equals(tech_id) && tab_elt_type.intValue()==14)
		{
		    if(activeTabIndex.equals(BigDecimal.ZERO))
		    {
			activeTabId = tab_elementId;
		    }
		    htmlStr.append(generateTabTitle(tab_elementId, tab_elt_title, tab_id_attr, activeTabIndex, elt_id));
		    tabsHtmlMap.put(tab_techId, generateTabArea(tab_elt_type, tab_elementId, tab_id_attr, tab_techId, tab_parentTechId, activeTabId, elt_width, elt_height, elt_id));
		    if(activeTabIndex.equals(BigDecimal.ZERO))
		    {
			activeTabIndex = BigDecimal.ONE;
		    }
		}
	    }
	}
	htmlStr.append("</ul>");
	htmlStr.append("</div>");
	return htmlStr;
    }
    /**
     * @description build main tabbed panel UI tab
     * @createdBy Sajjad Soomro
     * @createdDate 17 Dec, 2019
     * 
     * @return StringBuffer htmlStr
     */
    private StringBuffer generateTabTitle(BigDecimal elt_id, String elt_title, String id_attr, BigDecimal tab_index, BigDecimal parent_elt_id)
    {
	StringBuffer htmlStr = new StringBuffer();
	String theClass = "";
	if(tab_index.equals(BigDecimal.ZERO))
	{
	    theClass = "ui-tabs-selected ui-state-active";
	}
	else
	{
	    theClass = "ui-tabs-disabled";
	}
	htmlStr.append("<li onclick=dynamicscreen_activateTab('"+parent_elt_id+"_tabbedPanelDiv','"+elt_id+"') id='"+elt_id+"' propertyid='"+id_attr+"' title='"+StringUtil.escapeString(elt_title)+"' class='path-screen-openned ui-state-default ui-corner-top ui-sortable "+theClass+"'>");
	htmlStr.append("<a href='javascript:void(0);'>"+StringUtil.escapeString(elt_title)+"</a>");
	htmlStr.append("</li>");
	return htmlStr;
    }
    /**
     * @description build main tabbed panel UI tab area
     * @createdBy Sajjad Soomro
     * @createdDate 17 Dec, 2019
     * 
     * @return StringBuffer htmlStr
     */
    private StringBuffer generateTabArea(BigDecimal elt_type, BigDecimal elt_id, String id_attr,
	    BigDecimal tech_id, BigDecimal parent_tech_id, BigDecimal active_tab_id, BigDecimal tab_elt_width, BigDecimal tab_elt_height, BigDecimal parent_elt_id)
    {
	StringBuffer htmlStr = new StringBuffer();
	String theClass = "";
	if(!elt_id.equals(active_tab_id))
	{
	    theClass =  "display: none";
	}
	String _contentWidth  =  tab_elt_width != null?String.valueOf(tab_elt_width.intValue()-5).concat("px"):"100%";
	String _contentHeight =  tab_elt_height != null?String.valueOf(tab_elt_height.intValue()-37).concat("px"):"98%";
	htmlStr.append("<div id='"+elt_id+"_div' techid='"+tech_id+"' parenttechid='"+parent_tech_id+"' propid='"+id_attr+"' type='"+elt_type+"' style='position:relative; width:"+_contentWidth+"; height:"+_contentHeight+"; border:1px solid #000; "+theClass+"' class='_newdrag droppable ui-widget-content ui-corner-bottom "+parent_elt_id+"_div_tab'>");
	return htmlStr;
    }    
    /**
     * @description close tab area
     * @createdBy Sajjad Soomro
     * @createdDate 17 Dec, 2019
     * 
     * @return StringBuffer htmlStr
     */
    private StringBuffer closeTab()
    {
	StringBuffer htmlStr = new StringBuffer();
	htmlStr.append("</div>");
	return htmlStr;
    }
    /**
     * 
     * marwanmaddah
     */
    private StringBuffer closePanel()throws Exception
    {
	StringBuffer htmlStr = new StringBuffer();
	htmlStr.append("</div>");
	htmlStr.append("</div>");
	htmlStr.append("</div>");
	return htmlStr;
    }
    /**
     * 
     * @author marwanmaddah
     * @date Nov 24, 2015
     * @param elt_type
     * @param elt_id
     * @param elt_top
     * @param elt_left
     * @return
     * @throws Exception StringBuffer
     * 
     */
    private StringBuffer constructElement(BigDecimal elt_type, BigDecimal elt_id, BigDecimal elt_top,
	    BigDecimal elt_left,String elt_val,String id_attr,BigDecimal elt_width, BigDecimal elt_height, BigDecimal techId, BigDecimal parentTechId ) throws Exception
    {
	String type = "", theClass = "", additionalImg = "", elt_desc_tns = "", elt_desc = "";
	ServletContext application = ServletActionContext.getServletContext();
	String theRealPath = application.getContextPath();
	StringBuffer theData = new StringBuffer();
	switch (elt_type.intValue())
	{
	    case 1:
		type = "text";
		theClass = "textCompSize ui-state-focus ui-corner-all";
		break;
	    case 2:
		type = ConstantsCommon.LAYOUT_TYPE_LABEL;
		elt_desc_tns = elt_val;
		break;
	    case 3:
		type = "select";
		theClass = "selectCompSize ui-state-focus ui-corner-all";
		break;
	    case 4:
		type = "date";
		theClass = "ui-state-focus ui-corner-all path-text-size hasDatepicker";
		additionalImg = "<img title='...' class='ui-datepicker-trigger' style='display: inline-block;' alt='...' src='"
			+ theRealPath + "/common/images/calendar.png'>";
		break;
	    case 5:
		type = "radio";
		break;
	    case 6:
		type = "checkbox";
		break;
	    case 7:
		type = ConstantsCommon.LAYOUT_TYPE_LIVESEARCH;
		theClass = "liveSearchText liveSearchCompSize ui-state-focus liveSearchInputCorner";
		additionalImg = "<span tabindex='0' class='ui-search ui-state-default ui-state-focus liveSearchSpanCorner liveSearchSpanSize liveSearchSpanDisplay'"+
				"id='"+elt_id+"_liveSearchIcon' role='button' oldtabindex='0'>"+
				"<span class='ui-icon ui-icon-search live-search-ui'></span>"+
				"</span>";
		break;
	    case 8:
		type = ConstantsCommon.LAYOUT_TYPE_BUTTON;
		elt_desc_tns = elt_val;
		theClass = "ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only";
		break;
	    case 9:
		type = ConstantsCommon.LAYOUT_TYPE_TEXTAREA;
		theClass = "textCompSize ui-state-focus ui-corner-all";	
		break;
	    case 11:
		type = ConstantsCommon.LAYOUT_TYPE_FILE;
		break;
	    case 12:
		type = ConstantsCommon.LAYOUT_TYPE_GRID;
		break;
	    case 13:
		type = ConstantsCommon.LAYOUT_TYPE_RANGE;
		break;
	    default:
		break;
	}
	theData.append("<div class='_newdrag' tnsKey='").append(elt_desc).append("' templateId='").append(elt_id)
		.append("' id='").append(elt_id);
	theData.append("_div' value='").append(elt_desc_tns).append("' type='").append(elt_type).append(
		"' style='position: absolute; top:");
	theData.append(elt_top).append("px; left:").append(elt_left).append("px; overflow:hidden; cursor:move;");
	if(elt_width == null)
	{
	    theData.append("width:150px;");
	}
	else
	{
	    theData.append("width:").append(elt_width.intValue()+50).append("px;");	
	}
	if(elt_height != null)
	{
	    theData.append("height:").append(elt_height.intValue()+15).append("px;");
	}
	theData.append("' ").append("status='").append(elt_id).append("'");
	/**
	 * [TP#1047223] -SBI200398 - IMPL; SMBL; Dynamic file - Create From Issue
	 * added techid and parenttechid with div if called using Create From Functionality
	 */
	if(dynScreenCreatorCO != null && Boolean.TRUE.equals(dynScreenCreatorCO.getCreateFrom()))
	{
	    if(techId != null)
	    {
		theData.append(" techid='").append(techId).append("'");
	    }
	    if(parentTechId != null)
	    {
		theData.append(" parenttechid='").append(parentTechId).append("'");
	    }
	}
	theData.append(">");
        String addIdAttr = StringUtil.nullToEmpty(id_attr).isEmpty()?"":"propId='"+id_attr+"'";
	if(elt_type.intValue() == 2)
	{
	    theData.append("<label id = '").append(elt_id).append("'").append(" ").append(addIdAttr).append(" ");
	    theData.append("class='").append(elt_id).append("_div'").append(" ");
	    theData.append("style='");
	    if(elt_width == null)
	    {
		theData.append("width:100px;"); 
	    }
	    else
	    {
		theData.append("width:").append(elt_width).append("px;");
	    }
	    if(elt_height != null)
	    {
		theData.append("height:").append(elt_height).append("px;");
	    }
	    theData.append("'").append(" ");
	    theData.append("labelkey='").append(elt_desc_tns).append("'>");
	    theData.append(elt_desc_tns).append("</label>");
	}
	else if(elt_type.intValue() == 3)
	{
	    theData.append("<select id='").append(elt_id).append("' ").append(addIdAttr).append(" ");
	    theData.append("class='").append(elt_id).append("_div").append(" ").append(theClass).append("'").append(" ");
	    theData.append("style='");
	    if(elt_width == null)
	    {
		theData.append("width:100px;"); 
	    }
	    else
	    {
		theData.append("width:").append(elt_width).append("px;");
	    }
	    if(elt_height != null)
	    {
		theData.append("height:").append(elt_height).append("px;");
	    }
	    theData.append("'").append(" ");
	    theData.append("disabled='true'></select>");
	}
	else if(elt_type.intValue() == 8)
	{
	    theData.append("<button id='").append(elt_id).append("'").append(" ");
	    theData.append("class='").append(elt_id).append("_div").append(" ").append(theClass).append("'").append(" ");
	    theData.append("type='").append(type).append("'").append(" ");
	    theData.append("style='");
	    if(elt_width == null)
	    {
		theData.append("width:100px;"); 
	    }
	    else
	    {
		theData.append("width:").append(elt_width).append("px;");
	    }
	    if(elt_height != null)
	    {
		theData.append("height:").append(elt_height).append("px;");
	    }
	    theData.append("'").append(" ");
	    theData.append("role='button'").append(" ");
	    theData.append("aria-disabled='false'").append("freezeonsubmit='true'").append(" ").append("value='Submit'>");
	    theData.append("<span class='ui-button-text'>").append(elt_val).append("</span>");
	    theData.append("</button>");
	}
	else if(elt_type.intValue() == 9)
	{
	    theData.append("<textarea id='").append(elt_id).append("' ").append(addIdAttr);
	    theData.append(" ").append("class='").append(elt_id).append("_div ").append(theClass).append("'").append(" ");
	    theData.append("role='textbox'").append(" ");
	    theData.append("style='float: left;");
	    if(elt_width == null)
	    {
		theData.append("width:100px;"); 
	    }
	    else
	    {
		theData.append("width:").append(elt_width).append("px;");
	    }
	    if(elt_height != null)
	    {
		theData.append("height:").append(elt_height).append("px;");
	    }
	    theData.append("'").append(" ");
	    theData.append("disabled='true'></textarea>");
	    theData.append(additionalImg);	    
	}
	else if(elt_type.intValue() == 12)
	{
	    theData.append("<div id='"+elt_id+"' class = '"+elt_id+"_div' style='");
	    	
	    if(elt_width == null)
	    {
		theData.append("width:100px;");
	    }
	    else
	    {
		theData.append("width:").append(elt_width).append("px;");
	    }
	    if(elt_height != null)
	    {
		theData.append("height:").append(elt_height).append("px;");
	    }
	    theData.append("'>").append("<div class='ui-jqgrid-view' id='").append(elt_id).append("'>");
	    theData.append("<div class='ui-jqgrid-titlebar ui-widget-header ui-corner-top ui-helper-clearfix' style='display: none;'></div>")
		   .append("<div class='ui-state-default ui-jqgrid-hdiv' style='width: 100%;'>")
		   .append("<div class='ui-jqgrid-hbox'>")
		   .append("<table class='ui-jqgrid-htable' style='width:100%;' role='grid' cellspacing='0' cellpadding='0' border='0'>")
		   .append("<thead><tr class='ui-jqgrid-labels ui-sortable' role='rowheader' style=''>")
		   .append("<th role='columnheader'class='ui-state-default ui-th-column ui-th-ltr' style='width: 100%;'>")
		   .append("<span class='ui-jqgrid-resize ui-jqgrid-resize-ltr' style='cursor: col-resize;''>&nbsp;</span>")
		   .append("Column Name</th></tr>").append("<tr class='ui-search-toolbar' role='rowheader'>")
		   .append("<th role='columnheader' class='ui-state-default ui-th-column ui-th-ltr'>")
		   .append("<div style='width:100%;position:relative;height:100%;padding-right:0.3em;'><input type='text' readonly style='width:95%;padding:0px;'  value=''></div>")
		   .append("</th></tr></thead></table></div></div></div>")
		   .append("</div>");

	}
	else
	{
	    theData.append("<input id='").append(elt_id).append("' ").append(addIdAttr);
	    theData.append(" ").append("class='").append(elt_id).append("_div ").append(theClass).append("'").append(" ");
	    theData.append("type='").append(type).append("'").append(" ");
	    theData.append("style='float: left;");
	    if(elt_width == null)
	    {
		theData.append("width:100px;"); 
	    }
	    else
	    {
		theData.append("width:").append(elt_width).append("px;");
	    }
	    if(elt_height != null)
	    {
		theData.append("height:").append(elt_height).append("px;");
	    }
	    theData.append("'").append(" ");
	    theData.append("disabled='true'></input>");
	    theData.append(additionalImg);
	}
	theData.append("</div>");
	return theData;
    }
    /**
     * @description this method will sort list in order of parent-child hierarchy
     * @createdBy Sajjad Soomro
     * 
     * @param dataLst
     * @param start
     * @param techId
     * @return parentChildList
     */
    private List<DynamicScreenCreatorCO> addChildElements(List<DynamicScreenCreatorCO> dataLst, int start, BigDecimal techId)
    {
	List<DynamicScreenCreatorCO> parentChildList = new ArrayList<DynamicScreenCreatorCO>();
	List<DynamicScreenCreatorCO> childList = new ArrayList<DynamicScreenCreatorCO>();
	BigDecimal prevElemTechId = null;
	BigDecimal prevElemParentTechId = null;
	for(int i = start; i < dataLst.size(); i++)
	{
	    DynamicScreenCreatorCO currCO = dataLst.get(i);
	    if(i>0 && prevElemTechId != null && !prevElemTechId.equals(currCO.getTechId()) && techId.equals(prevElemParentTechId))
	    {
		childList = addChildElements(dataLst, i, prevElemTechId);
		if(childList != null && !childList.isEmpty())
		{
		    parentChildList.addAll(childList);
		}
	    }
	    
	    if(currCO.getParentTechId() != null && currCO.getParentTechId().equals(techId))
	    {
		parentChildList.add(currCO);
	    }
	    prevElemTechId = currCO.getTechId();
	    prevElemParentTechId = currCO.getParentTechId();
	}
	return parentChildList;
    }
    /**
     * @description this method will sort list in order of parent-child hierarchy
     * @createdBy Sajjad Soomro
     * @createdDate 13 Feb, 2020
     * 
     * @param dataLst
     * @param tabType
     * @param tabId
     * @param eltTop
     * @param eltLeft
     * @param eltWidth
     * @param eltHeight
     * @param eltTitle
     * @param tab_eltId
     * @param tab_tech_id
     * @param start
     * @return
     * @throws Exception
     */
    private Map<String, Object> createTabbedPanel(List<DynamicScreenCreatorCO> dataLst, 
	    BigDecimal tabType, BigDecimal tabId, BigDecimal eltTop, BigDecimal eltLeft, BigDecimal eltWidth, 
	    BigDecimal eltHeight, String eltTitle, String tab_eltId, BigDecimal tab_tech_id, BigDecimal parent_tech_id, int start) throws Exception
    {	
	StringBuffer tabbedPanelHtml = new StringBuffer();
	Map<BigDecimal,StringBuffer> tabsHtmlMap = new HashMap<BigDecimal,StringBuffer>();
	Map<String,Object> tabbedPanelMap = new HashMap<String,Object>();
	List<DynamicScreenCreatorCO> tabbedPanelElemList = new ArrayList<DynamicScreenCreatorCO>();
	
	// create tabbed panel tabs and map for tabs area (tabsHtmlMap)
	tabbedPanelHtml = openTabbedPanel(dataLst, tabsHtmlMap, tabType, tabId, eltTop, eltLeft, eltWidth, eltHeight ,eltTitle, tab_eltId, tab_tech_id, parent_tech_id);
	
	// iterate tabs of tabbed panel
	for(Map.Entry<BigDecimal,StringBuffer> tab: tabsHtmlMap.entrySet())
	{
	    // append tab areas with tabbed panel
	    tabbedPanelHtml.append(tab.getValue());
	    
	    StringBuffer theData = new StringBuffer();
	    BigDecimal elt_type = null, elt_top = null, elt_left = null, elt_width  = null, elt_height = null;
	    String id_attr = null, elt_title = "", elt_val = "";
	    BigDecimal elementId = null;
	    boolean parentIsOpened = false;
	    BigDecimal techId = null;
	    BigDecimal parentTechId = null;
	    BigDecimal openPanelTechId = null;
	    
	    for(int i = start; i < dataLst.size(); i++)
	    {
		DynamicScreenCreatorCO currCO = dataLst.get(i);
		
		// check whether the element is child of tab or its child of collapsible  panel
		if(elementId != null && !elementId.equals(currCO.getElementId()) && (tab.getKey().equals(parentTechId) || (parentIsOpened && parentTechId != null && parentTechId.equals(openPanelTechId))))
		{
		    StringBuffer elemtHtml;
		    if(elt_type.intValue()==10)
		    {
			elemtHtml = openPanel(elt_type, elementId, elt_top, elt_left, techId, parentTechId, elt_width, elt_height,elt_title);
			parentIsOpened = true;
			openPanelTechId = techId;
		    }
		    else if(elt_type.intValue() == 14)
		    {
			Map<String, Object> elemMap = createTabbedPanel(dataLst, elt_type, elementId, elt_top, elt_left, elt_width, elt_height ,elt_title, id_attr, techId, parentTechId, i);
			elemtHtml = (StringBuffer) elemMap.get("tabbedPanelHtml");
			List<DynamicScreenCreatorCO> tabElemList = (List<DynamicScreenCreatorCO>) elemMap.get("tabbedPanelElemList");
			dataLst.removeAll(tabElemList);
			if(i < dataLst.size()) currCO = dataLst.get(i);
		    }
		    else
		    {
		        elemtHtml = constructElement(elt_type, elementId, elt_top, elt_left,elt_val,id_attr,elt_width,elt_height, techId, parentTechId);
		    }
		    elt_width  = null;
		    elt_height = null;
		    theData.append(elemtHtml);
		    /**
		     * check if collapsible panel is opened, and  
		     * whether current element and next element not belongs to the same parent, and current element also not collapsible panel
		     * whether current element and next element not belongs to the same parent, and also next element not belongs to the current element
		     * whether current element is collapsible panel and next element not belongs to the collapsible panel
		     */
		    if(parentIsOpened && ((parentTechId!=null && !parentTechId.equals(currCO.getParentTechId()) && elt_type.intValue() != 10) 
			    || (parentTechId!=null && !parentTechId.equals(currCO.getParentTechId()) && techId != null && !techId.equals(currCO.getParentTechId())))
			    || (elt_type.intValue() == 10 && currCO.getParentTechId() != null && !currCO.getParentTechId().equals(techId)))
		    {
			theData.append(closePanel());
			parentIsOpened = false;
		    }
		}
                techId       = currCO.getTechId();
                parentTechId = currCO.getParentTechId();
		elementId    = currCO.getElementId();
		elt_type     = currCO.getElementType();
		id_attr      = currCO.getTheId();
		String propertyCode  = currCO.getProperty_code();
		String propertyValue = currCO.getProperty_value();
		if(propertyCode.equals(ConstantsCommon.PROPERTY_CODE_LEFT))
		{
		    elt_left = new BigDecimal(propertyValue);
		}
		else if(propertyCode.equals(ConstantsCommon.PROPERTY_CODE_TOP))
		{
		    elt_top = new BigDecimal(propertyValue);
		}
		else if(propertyCode.equals(ConstantsCommon.PROPERTY_CODE_VALUE))
		{
		    elt_val = propertyValue;
		}
		else if(ConstantsCommon.PROPERTY_CODE_WIDTH.equals(propertyCode))
		{
		    elt_width = new BigDecimal(propertyValue);
		}
		else if(ConstantsCommon.PROPERTY_CODE_HEIGHT.equals(propertyCode))
		{
		    elt_height = new BigDecimal(propertyValue);
		}
		else if(ConstantsCommon.PROPERTY_CODE_TITLE.equals(propertyCode))
		{
		    elt_title = propertyValue;
		}
		if((i == dataLst.size() - 1) && (tab.getKey().equals(parentTechId) || (parentIsOpened && parentTechId != null && parentTechId.equals(openPanelTechId))))
		{
		    StringBuffer elemtHtml;
		    if((parentTechId!=null && !parentTechId.equals(openPanelTechId) && parentIsOpened))
		    {
			theData.append(closePanel());
		    }
		    if(elt_type.intValue()==10)
		    {
			elemtHtml = openPanel(elt_type, elementId, elt_top, elt_left, techId, parentTechId, elt_width, elt_height,elt_title);
			parentIsOpened = true;        			
		    }
		    else
		    {        			
			elemtHtml = constructElement(elt_type, elementId, elt_top, elt_left,elt_val,id_attr,elt_width,elt_height, techId, parentTechId);
		    }
		    theData.append(elemtHtml);
		    elt_width  = null;
		    elt_height = null;
		    if(parentTechId!=null && parentIsOpened || (elt_type.intValue()==10 && parentIsOpened))
		    {
			theData.append(closePanel());
		    }
		}
		/**
		 * check whether element itself is tab or
		 * is child of the tab or is child of collapsible panel then add it into list
		 */
		if((techId != null && tab.getKey().equals(techId)) 
			|| (parentTechId != null && tab.getKey().equals(parentTechId))
			|| (parentIsOpened && openPanelTechId.equals(currCO.getParentTechId())))
		{
		    tabbedPanelElemList.add(currCO);
		}
	    }
	    tabbedPanelHtml.append(theData);
	    tabbedPanelHtml.append(closeTab());
	}
	tabbedPanelHtml.append(closeTabbedPanel());
	
	tabbedPanelMap.put("tabbedPanelHtml", tabbedPanelHtml);
	tabbedPanelMap.put("tabbedPanelElemList", tabbedPanelElemList);
	return tabbedPanelMap;
    }    
    /**
     * @description this method used to display component in Optional Widgets of Dynamic Screen and Designer Window in Edit mode
     * @modifiedBy Sajjad Soomro
     * @modifiedDate 05 Dec, 2019
     * 
     * @throws Exception
     */
    private void prepareDataToLoad() throws Exception
    {
	StringBuffer theData = new StringBuffer();
	String theOptional = "", theAdditional = "";
	String elt_id = "";
	String elt_desc = "", elt_desc_tns = "", elt_title = "";
	String app_func_id;
	String type = "text";
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    BigDecimal temp_id = BigDecimal.ONE, app_id, elt_type = null, elt_top = null, elt_left = null, elt_category = null, elt_optional = null;
	    BigDecimal elt_width  = null;
	    BigDecimal elt_height = null;
	    BigDecimal techId = null;
	    BigDecimal parentTechId = null;
	    String elt_val = "";
	    String id_attr = null;
	    Boolean optionalWidget = false;
	    ServletContext application = ServletActionContext.getServletContext();
	    String theRealPath = application.getContextPath();
//	    criteria.setTemplateId(getTEMPLATE_ID());
	    List<DSN_TEMPLATE_DETAILSVO> lst = new ArrayList<DSN_TEMPLATE_DETAILSVO>();// generatorBO.dataToGenerate(criteria);
//	    List<DSN_TEMPLATE_DETAILSVO> screenDataLst = sessionCO.getScreenDataLst();
	    
	    if(criteria.getScreenId()!=null)
	    {
        	    List<DynamicScreenCreatorCO> dataLst = generatorBO.returnScreenElementsData(criteria);
        	    BigDecimal prevElemId = null;
        	    String theClass = "", additionalImg = "";
        	    BigDecimal elementId = null;
        	    boolean parentIsOpened = false;
        	    List<DynamicScreenCreatorCO> parentChildList = new ArrayList<DynamicScreenCreatorCO>();
        	    BigDecimal prevElemTechId = null;
        	    //iterate the list to sort the list in oder of parent-child hierarchy
        	    for(int i = 0; i < dataLst.size(); i++)
        	    {
        		DynamicScreenCreatorCO currCO = dataLst.get(i);        		
        		if(i>0 && prevElemTechId != null && !prevElemTechId.equals(currCO.getTechId()) && currCO.getParentTechId() != null)
        		{
        		    List<DynamicScreenCreatorCO> childList = addChildElements(dataLst, i, prevElemTechId);
        		    if(childList != null && !childList.isEmpty())
        		    {
        			parentChildList.addAll(childList);
        			dataLst.removeAll(childList);
        			--i;
        		    }
        		}
        		if(currCO.getParentTechId() == null)
        		{
        		    parentChildList.add(currCO);
        		}
        		prevElemTechId = currCO.getTechId();
        	    }
        	    dataLst = parentChildList;
        	    
        	    for(int i = 0; i < dataLst.size(); i++)
        	    {
        		DynamicScreenCreatorCO currCO = dataLst.get(i);
        		if(i > 0 && !elementId.equals(currCO.getElementId()))
        		{
        		    StringBuffer elemtHtml;
        		    if(elt_type.intValue()==10)
        		    {
        			elemtHtml = openPanel(elt_type, elementId, elt_top, elt_left, techId, parentTechId, elt_width, elt_height,elt_title);
        			parentIsOpened = true;
        		    }
        		    else if(elt_type.intValue() == 14)
        		    {
        			// process to create tabbed panel UI
        			Map<String, Object> elemtMap = createTabbedPanel(dataLst, elt_type, elementId, elt_top, elt_left, elt_width, elt_height ,elt_title, id_attr, techId, parentTechId, i);
        			// tabbed panel html
        			elemtHtml = (StringBuffer) elemtMap.get("tabbedPanelHtml");
        			// list of elements belongs to the tabbed panel
        			List<DynamicScreenCreatorCO> tabbedPanelElemList = (List<DynamicScreenCreatorCO>) elemtMap.get("tabbedPanelElemList");
        			//remove all elements added into the tabbed panel
        			dataLst.removeAll(tabbedPanelElemList);
        			// if next element exists after tabbed panel then update the current element
        			if(i < dataLst.size()) currCO = dataLst.get(i);
        		    }
        		    else
        		    {
        		        elemtHtml = constructElement(elt_type, elementId, elt_top, elt_left,elt_val,id_attr,elt_width,elt_height, techId, parentTechId);
        		    }
        		    dynScreenWidth = return_DynScrMaxWidth(elt_left, elt_width);
        		    elt_width  = null;
        		    elt_height = null;
        		    theData.append(elemtHtml);
        		    if((parentTechId!=null && !parentTechId.equals(currCO.getParentTechId()) && parentIsOpened) || (parentTechId==null && parentIsOpened && currCO.getElementType().intValue() == 10) || (currCO.getParentTechId()==null && parentIsOpened))
        		    {
        			theData.append(closePanel());
        			parentIsOpened = false;
        		    }
        		}
                        techId       = currCO.getTechId();
                        parentTechId = currCO.getParentTechId();
        		elementId    = currCO.getElementId();
        		elt_type     = currCO.getElementType();
        		id_attr      = currCO.getTheId();
        		String propertyCode  = currCO.getProperty_code();
        		String propertyValue = currCO.getProperty_value();
        		if(propertyCode.equals(ConstantsCommon.PROPERTY_CODE_LEFT))
        		{
        		    elt_left = new BigDecimal(propertyValue);
        		}
        		else if(propertyCode.equals(ConstantsCommon.PROPERTY_CODE_TOP))
        		{
        		    elt_top = new BigDecimal(propertyValue);
        		}
        		else if(propertyCode.equals(ConstantsCommon.PROPERTY_CODE_VALUE))
        		{
        		    elt_val = propertyValue;
        		}
        		else if(ConstantsCommon.PROPERTY_CODE_WIDTH.equals(propertyCode))
        		{
        		    elt_width = new BigDecimal(propertyValue);
        		}
        		else if(ConstantsCommon.PROPERTY_CODE_HEIGHT.equals(propertyCode))
        		{
        		    elt_height = new BigDecimal(propertyValue);
        		}
        		else if(ConstantsCommon.PROPERTY_CODE_TITLE.equals(propertyCode))
        		{
        		    elt_title = propertyValue;
        		}
        		if(i == dataLst.size() - 1)
        		{
        		    StringBuffer elemtHtml;
        		    if(elt_type.intValue()==10)
        		    {
        			elemtHtml = openPanel(elt_type, elementId, elt_top, elt_left, techId, parentTechId, elt_width, elt_height,elt_title);
        			parentIsOpened = true;        			
        		    }
        		    else
        		    {        			
        			elemtHtml = constructElement(elt_type, elementId, elt_top, elt_left,elt_val,id_attr,elt_width,elt_height, techId, parentTechId);
        		    }
        		    dynScreenWidth = return_DynScrMaxWidth(elt_left, elt_width);
        		    theData.append(elemtHtml);
        		    elt_width  = null;
        		    elt_height = null;
        		    if(parentTechId!=null && parentIsOpened || (elt_type.intValue()==10 && parentIsOpened))
        		    {
        			theData.append(closePanel());
        		    }
        		}
        	    }
	    }
	    int optionsSize = 14;
	    for(int i = 1; i <= optionsSize; i++)
	    {
		if(!"OADM".equals(sessionCO.getCurrentAppName()) && i==13)
	        {
		    continue;
	        }		
		temp_id = new BigDecimal(i);
		app_id = new BigDecimal(i);
		app_func_id = "";
		elt_id = "elem_" + i;
		elt_top = new BigDecimal(i);
		elt_left = new BigDecimal(i);
		elt_type = new BigDecimal(i);
		elt_category = new BigDecimal(i);
		optionalWidget = Boolean.TRUE;
		switch (elt_type.intValue())
		{
		    case 1:
			type = "text";
			elt_desc_tns = "Input";
			elt_desc = "INPUT";
			break;
		    case 2:
			type = "label";
			elt_desc_tns = "Label";
			elt_desc = "Label";
			break;
		    case 3:
			type = "select";
			elt_desc_tns = "Select Box";
			elt_desc = "Select Box";
			break;
		    case 4:
			type = "date";
			elt_desc_tns = "Date Picker";
			elt_desc = "Date Picker";
			break;
		    case 5:
			type = "radio";
			elt_desc_tns = "Radio button";
			elt_desc = "Radio button";
			break;
		    case 6:
			type = "checkbox";
			elt_desc_tns = "Check box";
			elt_desc = "Check box";
			break;
		    case 7:
			type = "livesearch";
			elt_desc_tns = "Live Search";
			elt_desc = "Live Search";
			break;
		    case 8:
			type = "button";
			elt_desc_tns = "Button";
			elt_desc = "Button";
			break;
		    case 9:
			type = "textarea";
			elt_desc_tns = "Text Area";
			break;
		    case 10:
			type = "panel";
			elt_desc_tns = "Panel";
			break;
		    case 11:
			type = "file";
			elt_desc_tns = "File";
			break;
		    case 12:
			type = "grid";
			elt_desc_tns = "Grid";
			break;
		    case 13:
			type = "range";
			elt_desc_tns = "Range";
			break;
		    case 14:	//add tab component to display in Optional Widgets of Dynamic Screen
			type = "tab";
			elt_desc_tns = "Tab";
			break;
		    default:
			break;
		}

		if(optionalWidget)
		{
		    theOptional += "<div class='_optdrag' tnsKey='" + elt_desc + "' templateId='" + temp_id
			    + "' theId='" + elt_id + "_div' id='" + elt_id + "_div' fromWidget='1' value='"
			    + elt_desc_tns + "' type='" + type
			    + "' style='overflow:hidden; cursor:move; width:100px' status='1'>";
		    theOptional += "<img src='" + theRealPath + "/common/images/";

		    theOptional += type + ".png' alt='" + elt_desc_tns + "'>" + elt_desc_tns + "</img>";
		    theOptional += "</div>";
		}
	    }
	    setOptionalData(theOptional);
	    setScreenData(theData.toString());
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}

    }

    /**
     * Prepare the needed data from the translation file and display them in a
     * jquery grid...
     * 
     * @return
     * @throws JSONException
     */
//    public String keyListData() throws JSONException
//    {
//	/**
//	 * Translated Keys Management...
//	 */
//	copyproperties(criteria);
//	String repPath = FileUtil.getFileURLByName("repository");
//	File makefile = new File(repPath + "/transMessages.properties");
//	if(makefile.exists())
//	{
//	    try
//	    {
//		FileInputStream inputS = new FileInputStream(makefile);
//		Reader r = new InputStreamReader(inputS);
//		PropertiesReader pr = new PropertiesReader(r);
//		while(pr.nextProperty())
//		{
//		    translationKey = new TranslationKeyVO();
//		    translationKey.setTheKey(pr.getPropertyName());
//		    translationKey.setValue(pr.getPropertyValue());
//		    keysList.add(translationKey);
//		}
//		setRecords(keysList.size());
//		setGridModel(keysList);
//	    }
//	    catch(Exception ex)
//	    {
//		handleException(ex, null, null);
//	    }
//	}
//	/**
//	 * 
//	 */
//
//	return "keysGrid";
//    }

    public String checkCustomizedLinks()
    {
	try
	{

	    SessionCO sessionCO = returnSessionObject();
	    JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(screenData);
	    JSONArray jsonModel = jsonFilter.getJSONArray("root");
	    Object[] modelArr = jsonModel.toArray();
	    JSONObject obj;
	    DSN_TEMPLATE_DETAILSVO theVO = new DSN_TEMPLATE_DETAILSVO();
	    BigDecimal elt_id = null;
	    List<BigDecimal> existElemIds = new ArrayList<BigDecimal>();
	    boolean newElement = true;
	    HashMap<String, BigDecimal> variablesMap = new HashMap<String, BigDecimal>();
	    for(int i = 0; i < modelArr.length; i++)
	    {
		obj = (JSONObject) modelArr[i];
		theVO = (DSN_TEMPLATE_DETAILSVO) JSONObject.toBean(obj, DSN_TEMPLATE_DETAILSVO.class);
		variablesMap.put(theVO.getPROP_ID(), theVO.getELT_TYPE());
		if(StringUtil.isNumeric(theVO.getELT_ID(), false))
		{
		    elt_id = new BigDecimal(theVO.getELT_ID());
		    newElement = false;
		}
		else
		{
		    elt_id = new BigDecimal(theVO.getELT_ID().split("_")[1]);
		    newElement = true;
		}

		if(!newElement)
		{
		    existElemIds.add(elt_id);
		}
	    }
	    dynScreenCreatorCO.setLangCode(sessionCO.getLanguage());
	    dynScreenCreatorCO.setExistElemIds(existElemIds);
	    /**
	     * in case the request is from update mode will check the saved data to check the links between liveSearch and descriptions 
	     */
	    if(dynScreenCreatorCO.getSysDynScreenDefVO()!=null && !NumberUtil.isEmptyDecimal(dynScreenCreatorCO.getSysDynScreenDefVO().getDYN_SCREEN_ID()))
	    {
	       dynScreenCreatorCO.setRespMsg(generatorBO.checkCustomizedLinks(dynScreenCreatorCO));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "successJson";
    }
    
    /**
     * To generate the JSP file from the template and the new values where the
     * setter is from the JSP Designer
     */

    public String submitLayout()
    {
	try
	{
	    // mandatory and optional fields
	    SessionCO sessionCO = returnSessionObject();
	    JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(screenData);
	    JSONArray jsonModel = jsonFilter.getJSONArray("root");
	    Object[] modelArr = jsonModel.toArray();
	    JSONObject obj;
	    List<Object> elemPropList = new ArrayList<Object>();
	    Object[] elemPropArr = elemPropList.toArray();
	    List<String> elemPropIds = new ArrayList<String>();
	    
	    if(!StringUtil.nullToEmpty(propertiesData).isEmpty())
	    {
        	JSONObject jsonPorpFilter = (JSONObject) JSONSerializer.toJSON(propertiesData);
        	JSONArray  jsonPropArr    = jsonPorpFilter.getJSONArray("root");
        	elemPropArr               = jsonPropArr.toArray();
	    }
	    JSONObject propObj;
	    
	    DSN_TEMPLATE_DETAILSVO theVO = new DSN_TEMPLATE_DETAILSVO();
	    ElementPropertiesDetCO elementPropCO = null;
	    boolean hasPropertiesObj = false;
	    ArrayList<DynamicScreenDetailsCO> screenDataLst = new ArrayList<DynamicScreenDetailsCO>();
	    BigDecimal elt_id  = null;
	    List<BigDecimal> existElemIds = new ArrayList<BigDecimal>();
	    boolean newElement = true;
	    SYS_DYN_SCREEN_ELEMENTS_DETVO currElementDetailsVO; 
	    String fieldValue = "";
	    HashMap<String, BigDecimal> variablesMap = new HashMap<String, BigDecimal>();
	    for(int i = 0; i < modelArr.length; i++)
	    {
		obj = (JSONObject) modelArr[i];
		theVO = (DSN_TEMPLATE_DETAILSVO) JSONObject.toBean(obj, DSN_TEMPLATE_DETAILSVO.class);
		variablesMap.put(theVO.getPROP_ID(), theVO.getELT_TYPE());
		if(StringUtil.isNumeric(theVO.getELT_ID(),false))
		{
		    elt_id = new BigDecimal(theVO.getELT_ID());
		    newElement = false;
		}
		else
		{
		    elt_id = new BigDecimal(theVO.getELT_ID().split("_")[1]);
		    newElement = true;
		}
		
		elementPropCO = null;
		hasPropertiesObj = false;
		for(int j=0;j<elemPropArr.length;j++)
		{
		    propObj = (JSONObject)elemPropArr[j];
		    elementPropCO = new ElementPropertiesDetCO();
		    elementPropCO = (ElementPropertiesDetCO)JSONObject.toBean(propObj, ElementPropertiesDetCO.class);
       		    if(elementPropCO.getElementId().equals(elt_id))
    		    {
       			hasPropertiesObj = true;
       			break;
    		    }

		}
		if(newElement && !hasPropertiesObj)
		{
		    throw new BOException("There is a new element without properties"); 
		}
		DynamicScreenDetailsCO dynScreenDetailsCO = new DynamicScreenDetailsCO();
		dynScreenDetailsCO.setUserName(sessionCO.getUserName());
		dynScreenDetailsCO.getSysDynScreenElemVO().setELEMENT_TYPE_CODE(""+theVO.getELT_TYPE());
		dynScreenDetailsCO.getSysDynScreenElemVO().setTECH_ID(theVO.getTechId());
		dynScreenDetailsCO.getSysDynScreenElemVO().setPARENT_TECH_ID(theVO.getParentTechId());
		
		if(!newElement)
		{		    
		    dynScreenDetailsCO.getSysDynScreenElemVO().setELEMENT_ID(elt_id);
		   /**
		    * used to catch the deleted elements and delete them
		    */
		    existElemIds.add(elt_id);
		}
		List<SYS_DYN_SCREEN_ELEMENTS_DETVO> elementsDetLst = new ArrayList<SYS_DYN_SCREEN_ELEMENTS_DETVO>();

		SYS_DYN_SCREEN_ELEMENTS_DETVO elementDetailsTopVO = new SYS_DYN_SCREEN_ELEMENTS_DETVO();
		elementDetailsTopVO.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_TOP);
		elementDetailsTopVO.setPROPERTY_VALUE("" + (theVO.getTOP_POS()==null?BigDecimal.ZERO:theVO.getTOP_POS()));
		elementsDetLst.add(elementDetailsTopVO);

		SYS_DYN_SCREEN_ELEMENTS_DETVO elementDetailsLeftVO = new SYS_DYN_SCREEN_ELEMENTS_DETVO();
		elementDetailsLeftVO.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_LEFT);
		elementDetailsLeftVO.setPROPERTY_VALUE("" + (theVO.getLEFT_POS()==null?BigDecimal.ZERO:theVO.getLEFT_POS()));
		elementDetailsLeftVO.setCREATED_BY(sessionCO.getUserName());
		elementsDetLst.add(elementDetailsLeftVO);
		
		SYS_DYN_SCREEN_ELEMENTS_DETVO elementDetailsWidthVO = new SYS_DYN_SCREEN_ELEMENTS_DETVO();
		elementDetailsWidthVO.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_WIDTH);
		elementDetailsWidthVO.setPROPERTY_VALUE("" + (theVO.getELT_WIDTH()==null?BigDecimal.valueOf(150):theVO.getELT_WIDTH()));
		elementDetailsWidthVO.setCREATED_BY(sessionCO.getUserName());
		elementsDetLst.add(elementDetailsWidthVO);
		if(theVO.getELT_HEIGHT()!=null)
		{
        	    SYS_DYN_SCREEN_ELEMENTS_DETVO elementDetailsHeightVO = new SYS_DYN_SCREEN_ELEMENTS_DETVO();
        	    elementDetailsHeightVO.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_HEIGHT);
        	    elementDetailsHeightVO.setPROPERTY_VALUE("" + theVO.getELT_HEIGHT());
        	    elementDetailsHeightVO.setCREATED_BY(sessionCO.getUserName());
        	    elementsDetLst.add(elementDetailsHeightVO);
		}
	        boolean checkColMode = false;
	        boolean isRetrievalCond = true;
	        String tableName = null;
	        String queryCondition= null;
	        String columnCode = "",columnDesc = "",querySynthax = "",addLookupDesc="",lookupDesc="";
		if(hasPropertiesObj)
		{
		        for (Map.Entry entry:elementPropCO.getPropertiesValMap().entrySet())
		        {
		          if(entry.getValue() instanceof String)
		          {		              
		              fieldValue = (String)entry.getValue();
		          }
		          else
		          {
		              
		              if (JSONSerializer.toJSON(entry.getValue()) instanceof JSONObject)
		              {
		        	  JSONObject jsonOptionsModel = (JSONObject) JSONSerializer.toJSON(entry.getValue());
		        	  fieldValue = jsonOptionsModel.toString();
		              }
		              else
		              {
		        	  JSONArray jsonOptionsModel = (JSONArray) JSONSerializer.toJSON(entry.getValue());
			          fieldValue = jsonOptionsModel.toString();
		              }
		          }
		          /**
		           * in case the property is the onChange and the script is empty no need to fill a VO for it 
		           * and it is not a mandatory property so will pass to the other properties
		           */
			    if("elemProp_onChangeData".equals(entry.getKey()) && StringUtil.nullToEmpty(fieldValue).isEmpty())
			    {
				continue;
			    }
		          /**
		           * 
		           */
		          if("elemProp_id".equals(entry.getKey()))
		          {
		        	    /**
		        	     * check the ID attribute
		        	     * it should not start with number and not contains special characters 
		        	     * only _ is acceptable with alpha numeric 
		        	     */
		        	    Pattern pattern = Pattern.compile("^(?!\\d)[A-Za-z0-9_]\\w*$");
		        	    Matcher matcher = pattern.matcher(fieldValue);
		        	    if(!matcher.matches())
		        	    {
		        		throw new BOException("Invalid Missing ID");
		        	    }
		        	    
		          }
		          if("elemProp_name".equals(entry.getKey()) && StringUtil.isNotEmpty(fieldValue))
		          {
		              /**
		               * check the ID attribute
		               * it should not start with number and not contains special characters 
		               * only _ is acceptable with alpha numeric 
		               */
		              Pattern pattern = Pattern.compile("^(?!\\d)[A-Za-z0-9_][\\w\\.]*$");
		              Matcher matcher = pattern.matcher(fieldValue);
		              if(!matcher.matches())
		              {
		        	  throw new BOException("Invalid Missing Name");
		              }
		              
		          }
		          if("elemProp_fileName".equals(entry.getKey()))
		          {
		        	    /**
		        	     * check the File Name attribute
		        	     * it should not start with number and not contains special characters 
		        	     * only _ is acceptable with alpha numeric 
		        	     */
		        	    Pattern pattern = Pattern.compile("^(?!\\d)[A-Za-z0-9_]\\w*$");
		        	    Matcher matcher = pattern.matcher(fieldValue);
		        	    if(!matcher.matches())
		        	    {
		        		throw new BOException("Invalid Missing File Name");
		        	    }
		        	    
		          }
		          //TP#1053820 case of lookup description
		          if("elemProp_lookupDesc".equals(entry.getKey()))
		          {
		              lookupDesc = StringUtil.nullToEmpty(fieldValue);
		          }
		          if(fieldValue!=null)
		          {		
		              currElementDetailsVO = new SYS_DYN_SCREEN_ELEMENTS_DETVO();
		              if("elemProp_optionData".equals(entry.getKey()))
		              {
		        	  currElementDetailsVO.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_OPTIONS);
		        	  if(StringUtil.nullToEmpty(fieldValue).isEmpty())
		        	  {
		        	      throw new BOException("Missing Option Data");
		        	  }
		        	  currElementDetailsVO.setPROPERTY_EXPRESSION_VALUE(fieldValue);
		              }
		              //case of retrieval condition
		              else if("elemProp_condData".equals(entry.getKey())) 
		              {
		        	  currElementDetailsVO.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_RETRIEVALCONDITION);
		        	  if(StringUtil.isNotEmpty(fieldValue)) 
		        	  {
		        	      currElementDetailsVO.setPROPERTY_EXPRESSION_VALUE(fieldValue);
		        	      queryCondition = fieldValue;
		        	  }
		              }
		              //case of query
		              else if("elemProp_queryData".equals(entry.getKey()))
		              {
		        	  
				currElementDetailsVO.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_QUERY);
				// added to check if the element is grid and editable is not checked (means query data)
				if((theVO.getELT_TYPE().toString().equals(ConstantsCommon.ELEMENT_TYPE_GRID)
					&& elementPropCO.getPropertiesValMap().get("elemProp_editable").toString().equals("0"))
					|| (!theVO.getELT_TYPE().toString().equals(ConstantsCommon.ELEMENT_TYPE_GRID)))
				{
				    if(StringUtil.nullToEmpty(fieldValue).isEmpty() && !ConstantsCommon.ELEMENT_TYPE_TEXTFIELD.equals(String.valueOf(theVO.getELT_TYPE())))
				    {
					    throw new BOException("Missing Query Data");
				    }
				    else if(!StringUtil.nullToEmpty(fieldValue).isEmpty())
				    {					
					currElementDetailsVO.setPROPERTY_EXPRESSION_VALUE(fieldValue);
					isRetrievalCond = false;
					// Add mode property to liveSearch elements;
					// checking the columnCode
					// type in order to set the mode correctly
					JSONArray jsonQueryModel = (JSONArray) JSONSerializer.toJSON(fieldValue);
					queryCondition = fieldValue;
					Object[] modelQueryArr = jsonQueryModel.toArray();
					JSONObject queryObj = (JSONObject) modelQueryArr[0];
					if(!ConstantsCommon.ELEMENT_TYPE_GRID.equals(theVO.getELT_TYPE().toString()))
					{
					    columnCode = queryObj.getString("columnCode");
					    columnDesc = queryObj.getString("columnDesc");
					    if(queryObj.has("addLkpDesc"))
					    {
						queryObj.put("addLkpDesc", queryObj.getString("addLkpDesc").replace("\\" ,""));
						addLookupDesc  = queryObj.getString("addLkpDesc");
					    }
					}
					if ( !queryObj.has("tableDatasource") || !queryObj.getString("tableDatasource").equals(ConstantsCommon.DATASOURCE_BY_GLOBAL_ACTIVITY) )
						querySynthax = queryObj.getString("querySynthax");
					
					if(!theVO.getELT_TYPE().toString().equals(ConstantsCommon.ELEMENT_TYPE_GRID)){
					    checkColMode = true;
					}
				    }
				}
				else
				{
				    currElementDetailsVO.setPROPERTY_EXPRESSION_VALUE(fieldValue);
				}
		              }//elemProp_onChangeData
		              else if("elemProp_sourceData".equals(entry.getKey()) || "elemProp_onChangeData".equals(entry.getKey()))
		              {
		        	  if(theVO.getELT_TYPE().toString().equals(ConstantsCommon.ELEMENT_TYPE_GRID))
		        	  {
		        	      currElementDetailsVO.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_DBL_CLICK);
		        	  }
		        	  else
		        	  {
				    if(StringUtil.nullToEmpty(fieldValue).isEmpty())
				    {
					throw new BOException("Missing Source Data");
				    }
		        	    if("elemProp_onChangeData".equals(entry.getKey()))
		        	    {
		        		currElementDetailsVO.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_ONCHANGE);
		        	    }
		        	    else
		        	    {		        		
		        		currElementDetailsVO.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_SOURCE);
		        	    }
				    fieldValue = returnDynScrParamMapGridUpdate(dynScreenDetailsCO, fieldValue);
		        	  }
		        	  currElementDetailsVO.setPROPERTY_EXPRESSION_VALUE(fieldValue);
		              }
		              else
		              {		        	  
		        	  currElementDetailsVO.setPROPERTY_CODE(((String)entry.getKey()).split("_")[1]);
		        	  if("elemProp_required".equals(entry.getKey()) 
		        	     || "elemProp_readOnly".equals(entry.getKey()) 
		        	     || "elemProp_visible".equals(entry.getKey())
		        	     || "elemProp_validate".equals(entry.getKey())
		        	     || "elemProp_colProperties".equals(entry.getKey())
		        	     || ("elemProp_value".equals(entry.getKey()) 
		        		 && !BigDecimal.valueOf(2).equals(theVO.getELT_TYPE()) 
		        		 && !BigDecimal.valueOf(8).equals(theVO.getELT_TYPE()) 
		        		 && !BigDecimal.valueOf(6).equals(theVO.getELT_TYPE())
		        		 && !BigDecimal.valueOf(12).equals(theVO.getELT_TYPE()))
		        	    )
		        	  {
				    if("elemProp_colProperties".equals(entry.getKey()))
				    {
					currElementDetailsVO.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_COLPROPS);
					//TP#1053820 validation of columnProp of type livesearch
					JSONObject jsonFltr = (JSONObject) JSONSerializer.toJSON(fieldValue);
					JSONArray  jsonPropArr    = jsonFltr.getJSONArray("root");
					Object[] addLkpDescArr  = jsonPropArr.toArray();
					//retrieve list of columns of dynamic table
					int k= 0;
					List<String> dynScrElmLst = new ArrayList<String>();
					JSONObject lkpDescElem;
					while(k<addLkpDescArr.length)
					{
					    lkpDescElem = (JSONObject)addLkpDescArr[k];
					    if(lkpDescElem != null)
					     {
						dynScrElmLst.add((String)lkpDescElem.get("COL_TECH_NAME"));
					     }
					    k++;
					}
					//TP#1053821 validation on save for colProp query data
					for(int j=0;j<addLkpDescArr.length;j++)
					{
					      
					      lkpDescElem = (JSONObject)addLkpDescArr[j];
					     if(lkpDescElem != null)
					     {
						 String sourceMapping =  StringUtil.nullToEmpty((String)lkpDescElem.get("SOURCE_MAPPING_CODE"));
						 if("1".equals(sourceMapping))//case of livesearch
						 {
						     lookupDesc = StringUtil.nullToEmpty((String)lkpDescElem.get("LOOKUP_DESC"));
						      
						 }
						 else
						 {
						     continue;
						 }
						 Object queryData = lkpDescElem.get("QUERY_DATA");
						 if(queryData!=null)
						 {
						     JSONArray jsonQueryModel = (JSONArray) JSONSerializer.toJSON(queryData);
						     Object[] modelQueryArr = jsonQueryModel.toArray();
						     JSONObject queryObj = (JSONObject) modelQueryArr[0];

						     columnCode = queryObj.getString("columnCode");
						     columnDesc = queryObj.getString("columnDesc");
						     querySynthax = queryObj.getString("querySynthax");
						     if(queryObj.has("addLkpDesc"))
						     {
							 queryObj.put("addLkpDesc", queryObj.getString("addLkpDesc").replace("\\" ,""));
							 addLookupDesc  = queryObj.getString("addLkpDesc");
						     }
						     
						     DynScreenQueryCO dynScrQ = new DynScreenQueryCO();
						     dynScrQ.setColumnCode(columnCode);
						     dynScrQ.setColumnDesc(columnDesc);
						     dynScrQ.setQuerySynthax(querySynthax);
						     dynScrQ.setAddLkpDesc(addLookupDesc);
						     dynScrQ.setLookupDescription(lookupDesc);
						     dynScrQ.setDynScrElmLst(dynScrElmLst);
						     dynScrQ = generatorBO.checkQueryValidation(dynScrQ);
						 }
						
					     }
					}
				    }
		        	    currElementDetailsVO.setPROPERTY_EXPRESSION_VALUE(fieldValue);
		        	  }
		        	  else if("elemProp_tableName".equals(entry.getKey())&& ConstantsCommon.ELEMENT_TYPE_GRID.equals(theVO.getELT_TYPE().toString())
		        		      && ConstantsCommon.ONE.equals(elementPropCO.getPropertiesValMap().get("elemProp_editable").toString()))
		        	  {
		        	      
		        	      if(StringUtil.nullToEmpty(fieldValue).isEmpty())
		        	      {
		        		  throw new BOException("Missing Table Name");
		        	      }
		        	      else 
		        	      {
		        		  tableName = fieldValue;
		        		  currElementDetailsVO.setPROPERTY_VALUE(tableName);
		        	      }
		        	  }
		        	  else
		        	  {
		        	      currElementDetailsVO.setPROPERTY_VALUE(fieldValue.isEmpty()?null:fieldValue);
		        	  }
		              }
		              currElementDetailsVO.setCREATED_BY(sessionCO.getUserName());
		              elementsDetLst.add(currElementDetailsVO);
		          }

		        }
		}
		// Add mode property to liveSearch elements; checking the columnCode 
		// type in order to set the mode correctly
		if(checkColMode)
		{
		    DynScreenQueryCO dynScrQ = new DynScreenQueryCO();
		    dynScrQ.setColumnCode(columnCode);
		    dynScrQ.setColumnDesc(columnDesc);
		    dynScrQ.setQuerySynthax(querySynthax);
		    //TP#1053820 Additional lookup description
		    dynScrQ.setAddLkpDesc(addLookupDesc);
		    List<String> dynScrElmLst = dynScreenQueryCO.getDynScrElmLst();
		    dynScrQ.setLookupDescription(lookupDesc);
		    dynScrQ.setDynScrElmLst(dynScrElmLst);
		    dynScrQ = generatorBO.checkQueryValidation(dynScrQ);

		    if(dynScrQ != null && dynScrQ.getQueryDataStruct() != null)
		    {
			String colType = dynScrQ.getQueryDataStruct().get(columnCode);

			if(colType != null && ConstantsCommon.ELEMENT_TYPE_LIVESEARCH.equals(theVO.getELT_TYPE().toPlainString()))
			{
			    SYS_DYN_SCREEN_ELEMENTS_DETVO modeElementDetailsVO = new SYS_DYN_SCREEN_ELEMENTS_DETVO();
			    modeElementDetailsVO.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_MODE);
			    modeElementDetailsVO.setPROPERTY_VALUE(String.valueOf("number".equals(colType) ? 2 : 1));
			    modeElementDetailsVO.setCREATED_BY(sessionCO.getUserName());
			    elementsDetLst.add(modeElementDetailsVO);
			}

		    }
		    checkColMode = false;
		}
		dynScreenDetailsCO.setElementDetLst(elementsDetLst);
		//check query validation
		if(ConstantsCommon.ELEMENT_TYPE_GRID.equals(dynScreenDetailsCO.getSysDynScreenElemVO().getELEMENT_TYPE_CODE()))
		{
		  //session parameters
		    RequiredFieldsSC requiredFieldsSC = new RequiredFieldsSC(); 
			requiredFieldsSC.setLoginUserId(sessionCO.getUserName());
			requiredFieldsSC.setCompCode(sessionCO.getCompanyCode());
			requiredFieldsSC.setCompanyName(sessionCO.getCompanyName());
			requiredFieldsSC.setBranchCode(sessionCO.getBranchCode());
			requiredFieldsSC.setBranchName(sessionCO.getBranchName());
			requiredFieldsSC.setUserFirstName(sessionCO.getUserFirstName());
			requiredFieldsSC.setUserLastName(sessionCO.getUserLastName());
			requiredFieldsSC.setBaseCurrencyName(sessionCO.getBaseCurrencyName());
			requiredFieldsSC.setIsTeller((sessionCO.getCtsTellerVO() != null ? BigDecimal.ONE : BigDecimal.ZERO));
			requiredFieldsSC.setRunningDate(sessionCO.getRunningDateRET());  
			//recordList contains session parameters
			List<Map<String, Object>> recordList = CommonMethods.returnBoolExpressionDataList(requiredFieldsSC);
			BigDecimal screenId = dynScreenCreatorCO.getSysDynScreenDefVO().getDYN_SCREEN_ID();
			dynScreenQueryCO.setScreenId(screenId);
			
			//if object is not loaded
			if(!hasPropertiesObj) 
			{
			    //get query ,tableName and isRetrievalCond from DB
			    ScreenGeneratorSC criteria = new ScreenGeneratorSC();
			    criteria.setScreenId(screenId);
			    criteria.setElementType(ConstantsCommon.ELEMENT_TYPE_GRID);
			    criteria.setElementId(elt_id);
			    List<DynamicScreenCreatorCO> elemList= generatorBO.returnScreenElementsData(criteria);
			    for(DynamicScreenCreatorCO currElementData :elemList)
			    {
				//case of query
				if(ConstantsCommon.PROPERTY_CODE_QUERY.equals(currElementData.getProperty_code()))
				{
				    if(StringUtil.isNotEmpty(currElementData.getProperty_big_value()))
				    {
					queryCondition = currElementData.getProperty_big_value();
					isRetrievalCond = false;
				    }
				    
				}
				//case of retrieval condition
				else if(ConstantsCommon.PROPERTY_CODE_RETRIEVALCONDITION.equals(currElementData.getProperty_code())) 
				    {
					if(StringUtil.isNotEmpty(currElementData.getProperty_big_value()))
					{
					    queryCondition = currElementData.getProperty_big_value();
					    
					}
				    }
				else if(ConstantsCommon.PROPERTY_CODE_TABLE_NAME.equals(currElementData.getProperty_code())) {
				    tableName = currElementData.getProperty_value();
				}
			    }
			}
			//if query contains screen parameters
			Map<String, DynamicScreenCO> hmElemDataType=new HashMap<String, DynamicScreenCO>() ;
			if( !StringUtil.nullToEmpty(queryCondition).isEmpty()) 
			{
			    JSONArray jsonQueryModel = (JSONArray) JSONSerializer.toJSON(queryCondition);
			    Object[] modelQueryArr = jsonQueryModel.toArray();
			    JSONObject queryObj = (JSONObject) modelQueryArr[0];
			    if ( queryObj.has("querySynthax") && ( queryObj.has("tableDatasource") && queryObj.getString("tableDatasource").equals(ConstantsCommon.DATASOURCE_BY_QUERY)) ) 
			    {
			    queryCondition = queryObj.getString("querySynthax");

			    Pattern pattern = Pattern.compile("(.*?)(\\[screen.(\\S*)\\])(.*?)");
			    Matcher matcher = pattern.matcher(queryCondition);

			    boolean scrVariableModified = false;
			    String screenParamName = null;
			    String elementType = null;
			    while(matcher.find())
			    {
				if(StringUtil.isNotEmpty(matcher.group(2)))
				{
				    screenParamName = matcher.group(3);
				}  
			    }
			    if(StringUtil.isNotEmpty(screenParamName))
			    {
				for(int j=0;j<elemPropArr.length;j++)
				{
				    propObj = (JSONObject)elemPropArr[j];
				    ElementPropertiesDetCO currPropCO = new ElementPropertiesDetCO();
				    currPropCO = (ElementPropertiesDetCO)JSONObject.toBean(propObj, ElementPropertiesDetCO.class);
				    if(currPropCO.getPropertiesValMap().get("elemProp_id").equals(screenParamName))
				    {
					elementType = currPropCO.getPropertiesValMap().get("elemProp_mode");
					scrVariableModified = true;
					break;
				    }

				}
				//if screen variable was selected for modification then retrieve value from screen
				if(scrVariableModified)
				{
				    DynamicScreenCO currDynScrCO = new DynamicScreenCO();
				    currDynScrCO.setElement_mode(elementType);
				    hmElemDataType.put(screenParamName,currDynScrCO);
				}
				//else  retrieve value from Database
				else 
				{
				    hmElemDataType = generatorBO.returnParamsDataType(dynScreenQueryCO);
				}
			    } 
			   	//Fill DynScreenQueryCO for validation
				dynScreenQueryCO.setSessionList(recordList);
				dynScreenQueryCO.setScreenParamMapValues(hmElemDataType);
				dynScreenQueryCO.setRetCond(isRetrievalCond);
				dynScreenQueryCO.setTableName(tableName);
				dynScreenQueryCO.setQuerySynthax(StringUtil.nullToEmpty(queryCondition));
				dynScreenQueryCO.setElementType(ConstantsCommon.ELEMENT_TYPE_GRID);
				generatorBO.checkQueryValidation(dynScreenQueryCO);
			    }
			}
		}
		/**
		 * if propId missing in json and element is not new then fetch it from database using elementId
		 * otherwise fetch propId from elementPropCO
		 */
		String propId  = null;
		if(!obj.has("PROP_ID"))
		{
		    if(!newElement)
		    {
			String eltId = (String) obj.get("ELT_ID");
			BigDecimal elementId = new BigDecimal(eltId);
			BigDecimal screenId = dynScreenCreatorCO.getSysDynScreenDefVO().getDYN_SCREEN_ID();
			ScreenGeneratorSC criteria = new ScreenGeneratorSC();
			criteria.setScreenId(screenId);
			criteria.setElementId(elementId);
			List<DynamicScreenCreatorCO> elemPropDetList = generatorBO.returnScreenElementsData(criteria);
			for(DynamicScreenCreatorCO dynamicScreenCreatorCO: elemPropDetList)
			{
			    if(dynamicScreenCreatorCO.getProperty_code().equals(ConstantsCommon.PROPERTY_CODE_ID))
			    {
				propId = dynamicScreenCreatorCO.getProperty_value();
				break;
			    }
			}
		    }
		    else
		    {
			for (Map.Entry entry:elementPropCO.getPropertiesValMap().entrySet())
		        {
		          if("elemProp_id".equals(entry.getKey()))
		          {
		              propId = (String) entry.getValue();
		              break;
		          }
		        }
		    }
		}
		else
		{
		    propId = (String) obj.get("PROP_ID");
		}

		// check the pattern for the propId of the tabs
		if(theVO.getELT_TYPE().intValue()==14 && theVO.getELT_CATEGORY() == null)
		{
		    final Pattern pattern = Pattern.compile("^[A-Za-z]\\w*$");
		    final Matcher matcher = pattern.matcher(propId);
		    if(!matcher.matches())
		    {
			throw new BOException(getText("invalid_input_key"));
		    }
		}

		//validate the duplication of PROP_ID on screen
		if(elemPropIds.contains(propId))
		{
		    throw new BOException(getText("duplicated_id_key"));
		}
		elemPropIds.add(propId);
		screenDataLst.add(dynScreenDetailsCO);
	    }
	    dynScreenCreatorCO.getSysDynScreenDefVO().setCREATED_BY(sessionCO.getUserName());
	    dynScreenCreatorCO.setDynScreenDetailsLst(screenDataLst);
	    dynScreenCreatorCO.setVariablesMap(variablesMap);
	    dynScreenCreatorCO.getSysDynScreenDefVO().setCREATED_DATE(sessionCO.getRunningDateRET());
	    
	    if(screenDataLst.size() > 0)
	    {
		if(NumberUtil.isEmptyDecimal(dynScreenCreatorCO.getSysDynScreenDefVO().getDYN_SCREEN_ID()) || Boolean.TRUE.equals(dynScreenCreatorCO.getCreateFrom()))
		{
		  if(Boolean.TRUE.equals(dynScreenCreatorCO.getCreateFrom()))
		  {
		      dynScreenCreatorCO.setCreateFromId(dynScreenCreatorCO.getSysDynScreenDefVO().getDYN_SCREEN_ID());
		  }
		  generatorBO.saveNew(dynScreenCreatorCO);
		}
		else
		{
		    dynScreenCreatorCO.setExistElemIds(existElemIds); 
		    generatorBO.update(dynScreenCreatorCO);  
		}
		
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	dynScreenCreatorCO = new DynamicScreenCreatorCO();
	return "successJson";
    }
    
    /**
     * TP #890998 : Method that save the button source dialog details in dynamic screen
     * 
     * @author HusseinZaraket
     */
    public String submitBtnSourceDialog() {
    	try 
    	{
    		if(!StringUtil.nullToEmpty(propertiesData).isEmpty())
    	    {
	    		JSONObject jsonPorpFilter = (JSONObject) JSONSerializer.toJSON(propertiesData);
            	
	    		String elementId = (String) jsonPorpFilter.get("elementId");
            	String sourceType = (String) jsonPorpFilter.get("sourceType");
            	
            	if(StringUtil.isNotEmpty(sourceType)) {
            		
            		SessionCO sessionCO = returnSessionObject();
            		
            		// If source type is dynamic screen or global activity save parameters grid
            		if(DynamicScreenConstant.SRC_TYPE_LINK_TO_DYN_SCREEN.equals(sourceType) || DynamicScreenConstant.SRC_TYPE_LINK_TO_GLOBAL_ACTIVITY.equals(sourceType)) {
            			
						String scrParamMapGridUpdateStr = (String) jsonPorpFilter.get("scrParamMapGridUpdate");
						
						if(StringUtil.isNotEmpty(scrParamMapGridUpdateStr)) {
							
							JSONArray jsonArray = new JSONArray();
	                    	JSONObject jsonObject = new JSONObject();
							jsonObject.put("sourceType", sourceType);
			            	jsonObject.put("scrParamMapGridUpdate", JSONObject.fromObject(scrParamMapGridUpdateStr));
			            	jsonArray.add(jsonObject);
			            	
			            	if(StringUtil.nullToEmpty(jsonArray.toString()).isEmpty())
						    {
			            		throw new BOException("Missing Source Data");
						    }
			            	
			            	List<DynamicScreenDetailsCO> dynScreenDetailsList = new ArrayList<>();
				    		DynamicScreenDetailsCO dynamicScreenDetailsCO = new DynamicScreenDetailsCO();
				    		
			            	returnDynScrParamMapGridUpdate(dynamicScreenDetailsCO, jsonArray.toString());
				    		
				    		dynamicScreenDetailsCO.setUserName(sessionCO.getUserName());
				    		dynamicScreenDetailsCO.getSysDynScreenElemVO().setELEMENT_TYPE_CODE(ConstantsCommon.ELEMENT_TYPE_BUTTON);
				    		dynamicScreenDetailsCO.getSysDynScreenElemVO().setELEMENT_ID(BigDecimal.valueOf(Long.valueOf(elementId)));
				    		
				    		DynamicScreenCreatorCO dynamicScreenCreatorCO = new DynamicScreenCreatorCO();
				    		
				    		dynamicScreenCreatorCO.getSysDynScreenDefVO().setCREATED_BY(sessionCO.getUserName());
				    		dynamicScreenCreatorCO.getSysDynScreenDefVO().setCREATED_DATE(sessionCO.getRunningDateRET());
				    		dynamicScreenCreatorCO.getSysDynScreenDefVO().setDYN_SCREEN_ID(dynScreenCreatorCO.getSysDynScreenDefVO().getDYN_SCREEN_ID());
				    		dynamicScreenDetailsCO.getSysDynScreenElemVO().setELEMENT_ID(BigDecimal.valueOf(Long.valueOf(elementId)));
				    		
			            	dynScreenDetailsList.add(dynamicScreenDetailsCO);
			            	dynamicScreenCreatorCO.setDynScreenDetailsLst(dynScreenDetailsList);
			            	
			            	generatorBO.saveDynamicScreenDetails(dynamicScreenCreatorCO);
						}
						jsonPorpFilter.remove("scrParamMapGridUpdate");
            		}
            		
            		jsonPorpFilter.remove("elementId");
            		
            		DynamicScreenDetailsCO dynScreenDetCO = new DynamicScreenDetailsCO();
            		dynScreenDetCO.getSysDynScreenElemVO().setDYN_SCREEN_ID(dynScreenCreatorCO.getSysDynScreenDefVO().getDYN_SCREEN_ID());
            		dynScreenDetCO.getSysDynScreenElemVO().setELEMENT_ID(BigDecimal.valueOf(Long.valueOf(elementId)));
            		dynScreenDetCO.setUserName(sessionCO.getUserName());
            		
            		List<SYS_DYN_SCREEN_ELEMENTS_DETVO> elementDetLst = new ArrayList<>();
            		SYS_DYN_SCREEN_ELEMENTS_DETVO elementDet = new SYS_DYN_SCREEN_ELEMENTS_DETVO();
            		
            		JSONArray jsonArray = new JSONArray();
            		jsonArray.add(jsonPorpFilter);
            		elementDet.setPROPERTY_EXPRESSION_VALUE(jsonArray.toString());
            		elementDet.setPROPERTY_CODE(ConstantsCommon.PROPERTY_CODE_SOURCE);
            		
            		elementDetLst.add(elementDet);
            		dynScreenDetCO.setElementDetLst(elementDetLst);
            		
            		generatorBO.updateDynScreenDet(dynScreenDetCO);  
            	}
    	    }
    		
    	}
    	catch(Exception e)
    	{
    	    handleException(e, null, null);
    	}
    	return "successJson";
    }
    
    /**
     * @author nabilfeghali
     * @param dynScreenDetailsCO
     * @return
     */
    private String returnDynScrParamMapGridUpdate(DynamicScreenDetailsCO dynScreenDetailsCO, String fieldValue)
    {
 	  JSONArray sourceJsonModel = (JSONArray) JSONSerializer.toJSON(fieldValue);
	  Object[] sourceScriptArr = sourceJsonModel.toArray();
	  JSONObject sourceObj = (JSONObject) sourceScriptArr[0];
	  Object scrParamMapGridUpdateObj = sourceObj.get("scrParamMapGridUpdate");
	  if(scrParamMapGridUpdateObj != null && !String.valueOf(scrParamMapGridUpdateObj).isEmpty())
	  {

	    JSONObject paramMapGridUpdate = (JSONObject) scrParamMapGridUpdateObj;
	    if(paramMapGridUpdate != null)
	    {
		String paramMapGridUpdateValue = paramMapGridUpdate.toString();
		if(StringUtil.isNotEmpty(paramMapGridUpdateValue))
		{
		    Object sourceTypeObj = sourceObj.get("sourceType");
		    String sourceType = String.valueOf(sourceObj.get("sourceType"));
		    if(DynamicScreenConstant.BTN_SRC_TYPE.GLOBAL_ACTIVITY.equals(sourceType))
		    {
			GridUpdates gu = getGridUpdates(paramMapGridUpdateValue, SysParamGlobalActArgMapSC.class, true);
			if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
			{
			    List<SysParamGlobalActArgMapSC> sysParamGlobalActArgMapSCList = gu.getLstAllRec();
			    dynScreenDetailsCO.setGlobalActivityParamsMapSCList(sysParamGlobalActArgMapSCList);
			}
		    }
		    else
		    {
			GridUpdates gu = getGridUpdates(paramMapGridUpdateValue, DynamicScreenParamsMapCO.class, true);
			if(gu.getLstAllRec() != null && gu.getLstAllRec().size() > 0)
			{
			    List<DynamicScreenParamsMapCO> dynamicScreenParamsMapCOList = gu.getLstAllRec();
			    dynScreenDetailsCO.setDynamicScreenParamsMapCOList(dynamicScreenParamsMapCOList);
			}
		    }
		}
		sourceObj.remove("scrParamMapGridUpdate");
	    }
	  }
	  return sourceJsonModel.toString();
    }
    
    /**
     * 
     * @author marwanmaddah
     * @date   Jan 4, 2016
     * @return String
     *
     */
    public String deleteScreen()
    {
	try
	{
	    generatorBO.delete(dynScreenCreatorCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "successJson";	
    }
    
    /**
     * Used to check The query validation
     * @author marwanmaddah
     * @date   Feb 17, 2016
     * @return String
     *
     */
    public String checkQueryValidation()
    {
	try{
	    SessionCO sessionCO = returnSessionObject();
	    RequiredFieldsSC requiredFieldsSC = new RequiredFieldsSC(); 
	    requiredFieldsSC.setLoginUserId(sessionCO.getUserName());
	    requiredFieldsSC.setCompCode(sessionCO.getCompanyCode());
	    requiredFieldsSC.setCompanyName(sessionCO.getCompanyName());
	    requiredFieldsSC.setBranchCode(sessionCO.getBranchCode());
	    requiredFieldsSC.setBranchName(sessionCO.getBranchName());
	    requiredFieldsSC.setUserFirstName(sessionCO.getUserFirstName());
	    requiredFieldsSC.setUserLastName(sessionCO.getUserLastName());
	    requiredFieldsSC.setBaseCurrencyName(sessionCO.getBaseCurrencyName());
	    requiredFieldsSC.setIsTeller((sessionCO.getCtsTellerVO() != null ? BigDecimal.ONE : BigDecimal.ZERO));
	    requiredFieldsSC.setRunningDate(sessionCO.getRunningDateRET());  
	    //recordList contains session parameters
	    List<Map<String, Object>> recordList = CommonMethods.returnBoolExpressionDataList(requiredFieldsSC);
	    //get screen elements properties
	    List<Object> elemPropList = new ArrayList<Object>();
	    Object[] elemPropArr = elemPropList.toArray();
	    JSONObject propObj;

	    if(!StringUtil.nullToEmpty(propertiesData).isEmpty())
	    {
		JSONObject jsonPorpFilter = (JSONObject) JSONSerializer.toJSON(propertiesData);
		JSONArray  jsonPropArr    = jsonPorpFilter.getJSONArray("root");
		elemPropArr               = jsonPropArr.toArray();
	    }
	    //if query contains screen parameters
	    Pattern pattern = Pattern.compile("(.*?)(\\[screen.(\\S*)\\])(.*?)");
	    Matcher matcher = pattern.matcher(dynScreenQueryCO.getQuerySynthax());
	    Map<String, DynamicScreenCO> hmElemDataType=new HashMap<String, DynamicScreenCO>() ;
	    boolean scrVariableModified = false;
	    String screenParamName = null;
	    String elementType = null;
	    while(matcher.find())
	    {

		if(StringUtil.isNotEmpty(matcher.group(2)))
		{
		    screenParamName = matcher.group(3);
		}  
	    }
	    if(!StringUtil.nullToEmpty(screenParamName).isEmpty()) {
		for(int j=0;j<elemPropArr.length;j++)
		{

		    propObj = (JSONObject)elemPropArr[j];
		    ElementPropertiesDetCO currPropCO = new ElementPropertiesDetCO();
		    currPropCO = (ElementPropertiesDetCO)JSONObject.toBean(propObj, ElementPropertiesDetCO.class);
		    if(currPropCO.getPropertiesValMap().get("elemProp_id").equals(screenParamName))
		    {
			elementType = currPropCO.getPropertiesValMap().get("elemProp_mode");
			scrVariableModified = true;
			break;
		    }

		}
		//if screen parameter was selected for modification then retrieve value from screen
		if(scrVariableModified)
		{

		    DynamicScreenCO currDynScrCO = new DynamicScreenCO();
		    currDynScrCO.setElement_mode(elementType);
		    hmElemDataType.put(screenParamName,currDynScrCO);

		}
		//else retrieve value from Database
		else 
		{
		    hmElemDataType = generatorBO.returnParamsDataType(dynScreenQueryCO);
		}
	    }
	    dynScreenQueryCO.setSessionList(recordList);
	    dynScreenQueryCO.setScreenParamMapValues(hmElemDataType);
	    dynScreenQueryCO = generatorBO.checkQueryValidation(dynScreenQueryCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);  
	}
	return "successJson";
    }
    
    /**
     * check if the parameter 'tnsKey' exists in the translation file. if not
     * exists a new key will be added ...
     * 
     * @param tnsKey
     */
    private String translationManagement(String tnsKey, String theValue, boolean onSubmit) throws Exception
    {
	boolean exist_key = false;
	String theResult = "false";
	String cont = "";
	String repPath = FileUtil.getFileURLByName("repository");
	File newF = new PathFileSecure(repPath + "\\transMessages.properties");
	if(newF.exists())
	{
	    FileInputStream inputS = new FileInputStream(newF);
	    Reader r = new InputStreamReader(inputS);
	    PropertiesReader pr = new PropertiesReader(r);
	    while(pr.nextProperty())
	    {
		if(pr.getPropertyName().equals(tnsKey))
		{
		    exist_key = true;
		    theResult = pr.getPropertyValue();
		    break;
		}

	    }
	    pr.close();
	    r.close();
	    inputS.close();
	   
	    
	    if(!exist_key && onSubmit)
	    {
		if(tnsKey != null && !"null".equals(tnsKey))
		{
		    tnsKey = tnsKey.replaceAll("\\s+", "_");
		}
		cont = "\r\n" + tnsKey + "=" + theValue + "\r\n";
		FileInputStream fw = new FileInputStream(newF);
		byte[] b = new byte[Integer.parseInt(newF.length() + "")];
		fw.read(b);
		String content = new String(b);
		fw.close();
		content += cont;
		byte[] newb = content.getBytes();

		FileOutputStream fout = new FileOutputStream(newF);
		fout.write(newb);
		fout.close();
	    }
	}
	return theResult;
    }

    /**
     * 
     * @return
     */
    public String download()
    {
	try
	{
	    String repPath = FileUtil.getFileURLByName("repository");
	    File newF = new PathFileSecure(repPath + "\\ProfileModelMaint.jsp");
	    fileInputStream = new FileInputStream(newF);
	    bfSize = fileInputStream.available();
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "download";
    }

    /**
     * 
     * @return
     */
    public String deleteDynScrTable()
    {
	try
	{
	    generatorBO.deleteDynScrTable(dynScreenCreatorCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "successJson";	
    }
    
    
    /**
     * @return the screenIds
     */
    public String getScreenIds()
    {
	return screenIds;
    }

    /**
     * @param screenIds the screenIds to set
     */
    public void setScreenIds(String screenIds)
    {
	this.screenIds = screenIds;
    }

    /**
     * @param generatorBO the generatorBO to set
     */
    public void setGeneratorBO(GeneratorBO generatorBO)
    {
	this.generatorBO = generatorBO;
    }

    /**
     * @return the bfSize
     */
    public int getBfSize()
    {
	return bfSize;
    }

    /**
     * @param bfSize the bfSize to set
     */
    public void setBfSize(int bfSize)
    {
	this.bfSize = bfSize;
    }

    /**
     * @return the afterSubmit
     */
    public String getAfterSubmit()
    {
	return afterSubmit;
    }

    /**
     * @param afterSubmit the afterSubmit to set
     */
    public void setAfterSubmit(String afterSubmit)
    {
	this.afterSubmit = afterSubmit;
    }

    // /**
    // * @return the generatorBO
    // */
    // public GeneratorBO getGeneratorBO() {
    // return generatorBO;
    // }
    /**
     * @return the screenData
     */
    public String getScreenData()
    {
	return screenData;
    }

    /**
     * @param screenData the screenData to set
     */
    public void setScreenData(String screenData)
    {
	this.screenData = screenData;
    }

    /**
     * @return the optionalData
     */
    public String getOptionalData()
    {
	return optionalData;
    }

    /**
     * @param optionalData the optionalData to set
     */
    public void setOptionalData(String optionalData)
    {
	this.optionalData = optionalData;
    }

    /**
     * @return the additionalData
     */
    public String getAdditionalData()
    {
	return additionalData;
    }

    /**
     * @param additionalData the additionalData to set
     */
    public void setAdditionalData(String additionalData)
    {
	this.additionalData = additionalData;
    }

    /**
     * @return the fileInputStream
     */
    public InputStream getFileInputStream()
    {
	return fileInputStream;
    }

    /**
     * @param fileInputStream the fileInputStream to set
     */
    public void setFileInputStream(InputStream fileInputStream)
    {
	this.fileInputStream = fileInputStream;
    }

    /**
     * @return the translationKey
     */
    public TranslationKeyVO getTranslationKey()
    {
	return translationKey;
    }

    /**
     * @param translationKey the translationKey to set
     */
    public void setTranslationKey(TranslationKeyVO translationKey)
    {
	this.translationKey = translationKey;
    }

    /**
     * @return the keysList
     */
    public List<TranslationKeyVO> getKeysList()
    {
	return keysList;
    }

    /**
     * @param keysList the keysList to set
     */
    public void setKeysList(List<TranslationKeyVO> keysList)
    {
	this.keysList = keysList;
    }

    /**
     * @return the tEMPLATE_NAME
     */
    public String getTEMPLATE_NAME()
    {
	return TEMPLATE_NAME;
    }

    /**
     * @param tEMPLATENAME the tEMPLATE_NAME to set
     */
    public void setTEMPLATE_NAME(String tEMPLATENAME)
    {
	TEMPLATE_NAME = tEMPLATENAME;
    }

    /**
     * @return the tEMPLATE_ID
     */
    public String getTEMPLATE_ID()
    {
	return TEMPLATE_ID;
    }

    /**
     * @param tEMPLATEID the tEMPLATE_ID to set
     */
    public void setTEMPLATE_ID(String tEMPLATEID)
    {
	TEMPLATE_ID = tEMPLATEID;
    }

    /**
     * @return the destination_id
     */
    public String getDestination_id()
    {
	return destination_id;
    }

    /**
     * @param destinationId the destination_id to set
     */
    public void setDestination_id(String destinationId)
    {
	destination_id = destinationId;
    }

    public String getNewTemplateName()
    {
	return newTemplateName;
    }

    public void setNewTemplateName(String newTemplateName)
    {
	this.newTemplateName = newTemplateName;
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
     * @return the dynScreenCreatorCO
     */
    public DynamicScreenCreatorCO getDynScreenCreatorCO()
    {
        return dynScreenCreatorCO;
    }

    /**
     * @param dynScreenCreatorCO the dynScreenCreatorCO to set
     */
    public void setDynScreenCreatorCO(DynamicScreenCreatorCO dynScreenCreatorCO)
    {
        this.dynScreenCreatorCO = dynScreenCreatorCO;
    }

    /**
     * @return the propertiesData
     */
    public String getPropertiesData()
    {
        return propertiesData;
    }

    /**
     * @param propertiesData the propertiesData to set
     */
    public void setPropertiesData(String propertiesData)
    {
        this.propertiesData = propertiesData;
    }

    /**
     * @return the dynScreenQueryCO
     */
    public DynScreenQueryCO getDynScreenQueryCO()
    {
        return dynScreenQueryCO;
    }

    /**
     * @param dynScreenQueryCO the dynScreenQueryCO to set
     */
    public void setDynScreenQueryCO(DynScreenQueryCO dynScreenQueryCO)
    {
        this.dynScreenQueryCO = dynScreenQueryCO;
    }
    public List<SelectCO> getTableDataSourceList() 
    {
		return tableDataSourceList;
	}

	public void setTableDataSourceList(List<SelectCO> tableDataSourceList) 
	{
		this.tableDataSourceList = tableDataSourceList;
	}
	
	/**
     * @author Muhammad.Asif
     * this method is used to load data source screen  
     * @date   Jun 20, 2019
     * @return String
     *
     */
    public String loadDatasourceMainScreen()
    {
	try{
		
		fillDropDownList();
		JSONObject obj   = null ; 
		if ( criteria.getPropertyCode().equals(ConstantsCommon.PROPERTY_CODE_QUERY) ) 
		{
			if(!StringUtil.nullToEmpty(criteria.getQueryData()).isEmpty())
		    {
		       JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(criteria.getQueryData());
		       Object[] modelArr = jsonModel.toArray();
		       if (modelArr != null && modelArr.length > 0 )
		    	   	obj   = (JSONObject) modelArr[0];
		       
		       if ( obj == null || !obj.has("tableDatasource") )
		    	   dynScreenQueryCO.setTableDatasource(ConstantsCommon.DATASOURCE_BY_QUERY);
		       else 
		    	   dynScreenQueryCO.setTableDatasource(obj.getString("tableDatasource"));
		    }
		}
		else 
		{
			if(!StringUtil.nullToEmpty(criteria.getOptionsData()).isEmpty())
		    {
		       JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(criteria.getOptionsData());
		       Object[] modelArr = jsonModel.toArray();
		       if (modelArr != null && modelArr.length > 0 )
		    	   	obj   = (JSONObject) modelArr[0];
		       
		       if ( obj == null || !obj.has("tableDatasource") )
		    	   dynScreenQueryCO.setTableDatasource(ConstantsCommon.DATASOURCE_BY_STATIC);
		       else
		    	   dynScreenQueryCO.setTableDatasource(obj.getString("tableDatasource"));
		       
		    }
			else 
				dynScreenQueryCO.setTableDatasource(ConstantsCommon.DATASOURCE_BY_STATIC);
		}
		
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}	
	return "datasourceScreen";
    } 
  /// method to fill drop down list 
  	private void fillDropDownList() throws Exception 
  	{
  		SelectSC selSC = new SelectSC(ConstantsCommon.LOV_TYPE_DATASOURCE);
  		if ( criteria.getPropertyCode().equals(ConstantsCommon.PROPERTY_CODE_QUERY) )
  			selSC.setLovCodesInlude("'Q','G'");
  		
  		if ( ConstantsCommon.ELEMENT_LAYOUT_TYPE_MAP.get(Integer.valueOf(criteria.getElementType())).equals(ConstantsCommon.LAYOUT_TYPE_LIVESEARCH) )
  			selSC.setLovCodesInlude("'Q'");
  		
  		if ( ConstantsCommon.ELEMENT_LAYOUT_TYPE_MAP.get(Integer.valueOf(criteria.getElementType())).equals(ConstantsCommon.LAYOUT_TYPE_RADIOBUTTON) )
  			selSC.setLovCodesInlude("'S'");
  		
  		selSC.setOrderCriteria("ORDER");
  		tableDataSourceList = returnLOV(selSC);
  		
  	}
  	/**
     * @author Muhammad.Asif
     * this method is used to load rest configuration (global activity) screen 
     * @date   Jul 7, 2019
     * @return String
     *
     */
    public String loadGlobalActivityScreen()
    {	
	try{
		
		String data ;
		if (criteria.getPropertyCode().equals(ConstantsCommon.PROPERTY_CODE_OPTIONS) )
			data = criteria.getOptionsData();
		else 
			data = criteria.getQueryData();
		
	    if(!StringUtil.nullToEmpty(data).isEmpty())
	    {
	    	JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(data);
	    	JSONObject obj  = null ; 
	    	Object[] modelArr = jsonModel.toArray();	    	
	    	if (modelArr != null && modelArr.length > 0 )
	    	   	obj   = (JSONObject) modelArr[0];
	    	
	        if ( obj != null && obj.has("tableDatasource") &&  ((String)obj.get("tableDatasource") ).equals(ConstantsCommon.DATASOURCE_BY_GLOBAL_ACTIVITY) ) 
	        {
		    	dynScreenGridRestCO = (DynScreenGridRestCO) JSONObject.toBean(obj, DynScreenGridRestCO.class);     
		       	dynScreenGridRestCO.setParameterGridData((List<DynGridParameterCO>) obj.get("parameterGridData"));
		       	dynScreenGridRestCO.setParameterOutGridData( (List<DynGridOutParameterCO>) obj.get("parameterOutGridData"));		       	
	        }	       	
	       	dynScreenGridRestCO.setTableDatasource(criteria.getTableDatasource());
	       	PathPropertyUtil.copyProperties(dynScreenGridRestCO, dynScreenCreatorCO);
	    }
	}
	catch(Exception ex)
	{
		
	    handleException(ex, null, null);
	}
	return "globalActivityScreen";
    }
  	/**
     * @author Muhammad.Asif
     * this method is used to load data source configuration screen either query or global activity.  
     * @date   Jul 7, 2019
     * @return String
     */
  	public String loadDatasourceScreen() 
  	{
  		String screenName = "";
  		try{  			
  			if ( criteria.getPropertyCode().equals(ConstantsCommon.PROPERTY_CODE_QUERY) ) 
  			{
	  			if ( criteria.getTableDatasource().equals(ConstantsCommon.DATASOURCE_BY_QUERY) )
	  	   	    {
	  	   	    	screenName=this.loadQueryScreen();
	  	   	    }
	  	   	    else if ( criteria.getTableDatasource().equals(ConstantsCommon.DATASOURCE_BY_GLOBAL_ACTIVITY) )
	  	   	    {
	  	   	    	screenName=this.loadGlobalActivityScreen();
	  	   	    }
  			}
  			else 
  			{
  				if ( criteria.getTableDatasource().equals(ConstantsCommon.DATASOURCE_BY_QUERY) )
	  	   	    {
	  	   	    	screenName=this.loadQueryScreen();
	  	   	    }
	  	   	    else if ( criteria.getTableDatasource().equals(ConstantsCommon.DATASOURCE_BY_GLOBAL_ACTIVITY) )
	  	   	    {
	  	   	    	screenName=this.loadGlobalActivityScreen();
	  	   	    }else 
	  	   	    	screenName=this.loadOptionsScreen();
  			}
  		}
  		catch(Exception ex)
  		{
  		    handleException(ex, null, null);
  		}
  		return screenName;
  	}
  	/**
     * @author Muhammad.Asif
     * this method is used to load parameter grid  
     * @date   Jul 7, 2019
     * @return String
     */
  	public String loadParamMapGrid()
    {
	String[] searchCol = { "MAP_ID","mapDirection","OP_ID","opIdDescription","ARG_ID","mapTypeDesc","MAP_VALUE","screenFldIdDesc","mapDescription","DYN_ELEM_IDENTIFIER"};
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    List<DynGridParameterCO> generatedList = new ArrayList<DynGridParameterCO>();
	    String data ;
		if (criteria.getPropertyCode().equals(ConstantsCommon.PROPERTY_CODE_OPTIONS) )
			data = criteria.getOptionsData();
		else 
			data = criteria.getQueryData();
		
		SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_MAP_TYPE);
		List<SelectCO> mapTypeList = returnLOV(selSC);
	    
	    if(!StringUtil.nullToEmpty(data).isEmpty())
	    {
	    	JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(data);
	    	JSONObject obj  = null ;
	    	Object[] modelArr = jsonModel.toArray();
	    	if (modelArr != null && modelArr.length > 0 )
	    	   	obj   = (JSONObject) modelArr[0];
	    	
	        if (obj != null &&  obj.has("tableDatasource") &&  ((String)obj.get("tableDatasource") ).equals(ConstantsCommon.DATASOURCE_BY_GLOBAL_ACTIVITY) ) 
	        {
        	   JSONArray jsonArr = (JSONArray) obj.get("parameterGridData");	    	    
	    	   if (jsonArr != null) 
	    	   {
		            for (Object object : jsonArr)
		            {
		            	JSONObject jObject   = (JSONObject) object;
		            	jObject.put("mapTypeDesc",mapTypeList.stream()
				                .filter(val ->  val.getCode().equals(jObject.getString("mapTypeDesc")) )
				                .map(SelectCO::getDescValue)
				                .findAny()
				                .orElse(jObject.getString("mapTypeDesc")));
		            }
	    	    }
		       dynScreenGridRestCO.setParameterGridData((List<DynGridParameterCO>) jsonArr);			       
		       generatedList = dynScreenGridRestCO.getParameterGridData();
		       PathPropertyUtil.copyProperties(dynScreenGridRestCO, dynScreenCreatorCO);
	        }
		   dynScreenGridRestCO.setTableDatasource(criteria.getTableDatasource());
	    }
	    setGridModel(generatedList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadDyanmicScreenParamMapGrid");
	    handleException(e, null, null);
	}
	return "successJson";
    }
  	/**
     * @author Muhammad.Asif
     * this method is used to load column parameter grid  
     * @date   Jul 7, 2019
     * @return String
     */
  	public String loadColumnMapGrid()
    {
	try
	{
		String[] searchCol = { "COL_TECH_NAME","COL_DESCRIPTION","REST_LIST_PROPERTIES","COL_DATA_TYPE","COL_FORMAT"};
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    loadColumnDataTypeSelect();
	    List<DynGridOutParameterCO> generatedList = new ArrayList<DynGridOutParameterCO>();
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_ARG_TYPE);
		List<SelectCO> lovList = returnLOV(selSC);
	    if(!StringUtil.nullToEmpty(criteria.getQueryData()).isEmpty())
	    {
	    	JSONArray jsonModel = (JSONArray) JSONSerializer.toJSON(criteria.getQueryData());
	    	JSONObject obj  = null ;
	    	Object[] modelArr = jsonModel.toArray();
	    	if (modelArr != null && modelArr.length > 0 )
	    	   	obj   = (JSONObject) modelArr[0];
	    	
	        if (obj != null && obj.has("tableDatasource") &&  ((String)obj.get("tableDatasource") ).equals(ConstantsCommon.DATASOURCE_BY_GLOBAL_ACTIVITY) ) 
	        {
		       JSONArray jsonArr = (JSONArray) obj.get("parameterOutGridData");	    	    
	    	   if (jsonArr != null) 
	    	   {
		            for (Object object : jsonArr)
		            {
		            	JSONObject jObject   = (JSONObject) object;
		            	jObject.put("COL_DATA_TYPE",lovList.stream()
				                .filter(val ->  val.getCode().equals(jObject.getString("COL_DATA_TYPE")) )
				                .map(SelectCO::getDescValue)
				                .findAny()
				                .orElse(jObject.getString("COL_DATA_TYPE")));
		            }
	    	    }
	    	   dynScreenGridRestCO.setParameterOutGridData( (List<DynGridOutParameterCO>) jsonArr );
		       generatedList = dynScreenGridRestCO.getParameterOutGridData();
		       PathPropertyUtil.copyProperties(dynScreenGridRestCO, dynScreenCreatorCO);
	       }
		   dynScreenGridRestCO.setTableDatasource(criteria.getTableDatasource());
	    }	    
	    setGridModel(generatedList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadColumnMapGrid");
	    handleException(e, null, null);
	}
	return "successJson";
    }
  	/**
     * @author Muhammad.Asif
     * this method is used to load DATA type in column grid  
     * @date   Jul 7, 2019
     * @return String
     */
  	public String loadColumnDataTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_ARG_TYPE);
	    selSC.setLovCodesInlude("'N','T','V'");
	    colDataTypeList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return "successJson";
    }
      /**
	 * TP#1053820 Additional lookup description
	 * Load addition lookup description grid
	 */
	public String loadGridAddLookupDescription()
	{
	    String[] searchCol = { "ELEMENT_ID", "COL_DESC"};
	    copyproperties(criteria);
	    try
	    {
		dynScreenQueryCO.setAddLkpDesc(addLkpDesc);
		if(StringUtil.isNotEmpty(addLkpDesc))
		{
		    addLkpDesc = addLkpDesc.replace("\\", "");
		    ObjectMapper mapper = new ObjectMapper();

		    if(StringUtil.isNotEmpty(addLkpDesc)&& PathJSONUtil.isValidJSON(addLkpDesc))
		    {
			Map<String,ArrayList<String>> lkpDescMap = mapper.readValue(addLkpDesc, java.util.HashMap.class);
			ArrayList<String> arrayList = lkpDescMap.get("root");
			setGridModel(arrayList);
		    }
		}
	    }
	    catch(Exception e)
	    {
		log.error(e, "Error in loadGridAddLookupDescription");
		handleException(e, null, null);
	    }
	    return "successJson";
	}
  	/**
  	 * @description the method used to compare the element position with the Dynamic screen size
  	 * and if element position is greater than the screen area then return the Dynamic Screen width
  	 * based on the element position
  	 * 
  	 * @param elt_left
  	 * @param elt_width
  	 * @return BigDecimal {dynScrWidth}
  	 */
  	private BigDecimal return_DynScrMaxWidth(BigDecimal elt_left, BigDecimal elt_width)
  	{
  	    BigDecimal dynScrWidth = NumberUtil.nullEmptyToValue(this.dynScreenWidth, DynamicScreenConstant.DYN_SCRN_DEFAULT_WIDTH);
	    if(!NumberUtil.isEmptyDecimal(elt_left) && !NumberUtil.isEmptyDecimal(elt_width))
	    {
		BigDecimal elt_size = elt_left.add(elt_width).add(BigDecimal.valueOf(55));
		if(elt_size.compareTo(dynScrWidth) == 1)
		{
		    dynScrWidth = elt_size;
		}
	    }
	    return dynScrWidth;
  	}

	public List<SelectCO> getColDataTypeList() 
	{
		return colDataTypeList;
	}

	public void setColDataTypeList(List<SelectCO> colDataTypeList) {
		this.colDataTypeList = colDataTypeList;
	}
	public DynScreenGridRestCO getDynScreenGridRestCO() 
	{
		return dynScreenGridRestCO;
	}
	public void setDynScreenGridRestCO(DynScreenGridRestCO dynScreenGridRestCO) {
		this.dynScreenGridRestCO = dynScreenGridRestCO;
	}
	public String getTableDatasource() 
	{
		return tableDatasource;
	}
	public void setTableDatasource(String tableDatasource) {
		this.tableDatasource = tableDatasource;
	}
	public String getAddLkpDesc()
	{
	    return addLkpDesc;
	}

	public void setAddLkpDesc(String addLkpDesc)
	{
	    this.addLkpDesc = addLkpDesc;
	}

	/**
	 * @return the dynScreenWidth
	 */
	public BigDecimal getDynScreenWidth()
	{
	    return dynScreenWidth;
	}

	/**
	 * @param dynScreenWidth the dynScreenWidth to set
	 */
	public void setDynScreenWidth(BigDecimal dynScreenWidth)
	{
	    this.dynScreenWidth = dynScreenWidth;
	}
}
