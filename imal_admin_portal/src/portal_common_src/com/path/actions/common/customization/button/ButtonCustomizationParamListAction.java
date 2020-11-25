package com.path.actions.common.customization.button;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.path.bo.common.customization.button.ButtonCustomizationBO;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationCO;
import com.path.vo.common.customization.button.ButtonCustomizationConstants;
import com.path.vo.common.customization.button.ButtonCustomizationConstants.BtnCustSessionCO;
import com.path.vo.common.customization.button.ButtonCustomizationSC;
import com.path.vo.common.customization.button.SysParamGlobalActArgMapSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

public class ButtonCustomizationParamListAction extends GridBaseAction
{
    
    private ButtonCustomizationBO buttonCustomizationBO;
    private SysParamGlobalActArgMapSC criteria = new SysParamGlobalActArgMapSC();
    private ButtonCustomizationSC dependancyCriteria = new ButtonCustomizationSC();
    private ButtonCustomizationCO buttonCustomizationCO = new ButtonCustomizationCO();
    public  ButtonCustomizationCO getButtonCustomizationCO()
    {
        return buttonCustomizationCO;
    }

    public void setButtonCustomizationCO(ButtonCustomizationCO buttonCustomizationCO)
    {
        this.buttonCustomizationCO = buttonCustomizationCO;
    }

    List<SelectCO> mapTypeList  = new ArrayList<SelectCO>();
    List<SelectCO> selectionTypeList  = new ArrayList<SelectCO>();
    List<SelectCO> mapDirectionList  = new ArrayList<SelectCO>();
    List<SelectCO> dynParamMapList  = new ArrayList<SelectCO>();

    public SysParamGlobalActArgMapSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(SysParamGlobalActArgMapSC criteria)
    {
        this.criteria = criteria;
    }

    public Object getModel()
    {
	return criteria;
    }

    public void setButtonCustomizationBO(ButtonCustomizationBO buttonCustomizationBO)
    {
        this.buttonCustomizationBO = buttonCustomizationBO;
    }

    public String loadParamMapList()
    {
	return "loadButtonCustomizationParamList";
    }
    
    public String loadObjCustParamMapList()
    {
	return "loadObjectCustomizationParamList";
    }

    public String loadSelectionType() 
    {
	try
	{
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_SELECTION_TYPE);
	  //TP#934567 Add empty option for selection Type 
	    selSC.setLovCodesInlude("'U','A','S'");
	    selectionTypeList = returnLOV(selSC);
	    //Add empty option
	    SelectCO emptyOption = new SelectCO();
	    emptyOption.setCode("");
	    emptyOption.setDescValue("");
	    selectionTypeList.add(0,emptyOption);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    public String loadParamMapGrid()
    {
	String[] searchCol = { "MAP_ID","mapDirection","OP_ID","opIdDescription","ARG_ID","mapTypeDesc","MAP_VALUE","screenFldIdDesc","mapDescription","DYN_ELEM_IDENTIFIER"};
	try
	{
	    /**
	     * copy the details related to search criteria to the SC
	     */
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setLovTypeId(ButtonCustomizationConstants.LOV_TYPE_MAP_TYPE);
	    criteria.setLovMapId(ButtonCustomizationConstants.LOV_TYPE_ARG_STATUS);
	    criteria.setLovDynParamType(ButtonCustomizationConstants.LOV_TYPE_DYN_PARAM_TYPE);
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(criteria))
	    {
		setRecords(buttonCustomizationBO.returnButtonCustomizationParamMapCount(criteria));
	    }

	    /**
	     * return the collection of records
	     */
	    List<SysParamGlobalActArgMapSC> generatedList = buttonCustomizationBO.returnButtonCustomizationParamMap(criteria);
	    
	    if(generatedList != null && !generatedList.isEmpty())
	    {
		Map<String, String> gridColumnDecMap = null;
		
		for(SysParamGlobalActArgMapSC buttonCustParamsMapSC : generatedList)
		{    
		    if(ButtonCustomizationConstants.MAP_TYPE.SESSION.equals(buttonCustParamsMapSC
			    .getSysParamGlobalActArgMapVO().getMAP_TYPE()) && StringUtil.isNotEmpty(buttonCustParamsMapSC.getSysParamGlobalActArgMapVO().getMAP_VALUE()))
		    {
			buttonCustParamsMapSC.setMapDescription(ButtonCustomizationConstants.SESSIONCO_PROPERTIES.get(
				buttonCustParamsMapSC.getSysParamGlobalActArgMapVO().getMAP_VALUE()).getDescription());
			buttonCustParamsMapSC.setScreenFldIdDesc(buttonCustParamsMapSC.getSysParamGlobalActArgMapVO().getMAP_VALUE());
			buttonCustParamsMapSC.getSysParamGlobalActArgMapVO().setMAP_VALUE(null);
		    }
		    if(ButtonCustomizationConstants.MAP_TYPE.GRIDCOLUMN.equals(buttonCustParamsMapSC
			    .getSysParamGlobalActArgMapVO().getMAP_TYPE()) && StringUtil.isNotEmpty(buttonCustParamsMapSC.getSysParamGlobalActArgMapVO().getMAP_VALUE()))
		    {
			
			if(gridColumnDecMap == null)
			{
			    gridColumnDecMap = new HashMap<String, String>();
			    if(StringUtil.isNotEmpty(criteria.getGridColumns()))
			    {
				List<BtnCustSessionCO> declaredFieldsList = new ArrayList<BtnCustSessionCO>();
				ObjectMapper mapper = new ObjectMapper();
				declaredFieldsList = mapper.readValue(URLDecoder.decode(criteria.getGridColumns(),FileUtil.DEFAULT_FILE_ENCODING), new TypeReference<List<BtnCustSessionCO>>(){});
				for(BtnCustSessionCO gridCO : declaredFieldsList)
				{
				    gridColumnDecMap.put(gridCO.getPropertyName(), gridCO.getDescription());
				}
			    }
			}
			
			buttonCustParamsMapSC.setMapDescription(gridColumnDecMap.get(buttonCustParamsMapSC.getSysParamGlobalActArgMapVO().getMAP_VALUE()));
			buttonCustParamsMapSC.setScreenFldIdDesc(buttonCustParamsMapSC.getSysParamGlobalActArgMapVO().getMAP_VALUE());
			buttonCustParamsMapSC.getSysParamGlobalActArgMapVO().setMAP_VALUE(null);
		    }
		    else if(ButtonCustomizationConstants.MAP_TYPE.SCREEN.equals(buttonCustParamsMapSC
			    .getSysParamGlobalActArgMapVO().getMAP_TYPE()) && (StringUtil.isNotEmpty(buttonCustParamsMapSC.getMapDescription()) ||!NumberUtil.isEmptyDecimal(buttonCustParamsMapSC.getSysParamGlobalActArgMapVO().getSCREEN_FLD_IDENTIFIER())))
		    {
			buttonCustParamsMapSC.setMapDescription(getText(buttonCustParamsMapSC.getMapDescription()));
			buttonCustParamsMapSC.setScreenFldIdDesc(buttonCustParamsMapSC.getSysParamGlobalActArgMapVO().getSCREEN_FLD_IDENTIFIER().toString());
			buttonCustParamsMapSC.getSysParamGlobalActArgMapVO().setSCREEN_FLD_IDENTIFIER(null);
		    }
		    else if(ButtonCustomizationConstants.MAP_TYPE.CONSTANT.equals(buttonCustParamsMapSC
			    .getSysParamGlobalActArgMapVO().getMAP_TYPE()))
		    {
			buttonCustParamsMapSC.getSysParamGlobalActArgMapVO().setSCREEN_FLD_IDENTIFIER(null);
			buttonCustParamsMapSC.setScreenFldIdDesc(null);
		    }
			
		}
	    }
	    /**
	     * set the collection into gridModel attribute defined at JSP grid
	     * tag
	     */
	    setGridModel(generatedList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in loadDyanmicScreenParamMapGrid");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * this function is used to load mapping type list
     * @return
     */
    public String loadMapTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_MAP_TYPE);
	    if(criteria.isLoadedInObjDisplay())
	    {
		selSC.setLovCodesInlude("'1','2','3','9'");
	    }
	    else
	    {
		selSC.setLovCodesInlude("'1','2','3'");
	    }
		
	    mapTypeList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    /**
     * this function is used to load mapping Direction(input/output) list
     * @return
     */
    public String loadMapDirectionSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_ARG_STATUS);
	    selSC.setLovCodesExclude("'B'");
	    mapDirectionList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    /**
     * this function is used to load mapping type list
     * @return
     */
    public String loadDynParamTypeSelect()
    {
	try
	{
	    SelectSC selSC = new SelectSC(ButtonCustomizationConstants.LOV_TYPE_DYN_PARAM_TYPE);
	    dynParamMapList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	
	return SUCCESS;
    }
    
    public ButtonCustomizationSC getDependancyCriteria()
    {
        return dependancyCriteria;
    }

    public void setDependancyCriteria(ButtonCustomizationSC dependancyCriteria)
    {
        this.dependancyCriteria = dependancyCriteria;
    }
    public List<SelectCO> getMapDirectionList()
    {
        return mapDirectionList;
    }

    public void setMapDirectionList(List<SelectCO> mapDirectionList)
    {
        this.mapDirectionList = mapDirectionList;
    }

    public List<SelectCO> getMapTypeList()
    {
        return mapTypeList;
    }

    public void setMapTypeList(List<SelectCO> mapTypeList)
    {
        this.mapTypeList = mapTypeList;
    }
    
    public List<SelectCO> getSelectionTypeList()
    {
	return selectionTypeList;
    }
    
    public void setSelectionTypeList(List<SelectCO> selectionTypeList)
    {
	this.selectionTypeList = selectionTypeList;
    }
    
    public List<SelectCO> getDynParamMapList()
    {
        return dynParamMapList;
    }

    public void setDynParamMapList(List<SelectCO> dynParamMapList)
    {
        this.dynParamMapList = dynParamMapList;
    }
}
