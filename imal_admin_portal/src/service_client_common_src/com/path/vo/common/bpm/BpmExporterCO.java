/**
 * 
 */
package com.path.vo.common.bpm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.path.dbmaps.vo.FIELD_TECH_DETAILSVO;
import com.path.dbmaps.vo.OPTVO;
import com.path.dbmaps.vo.OPT_EXTENDEDVO;
import com.path.dbmaps.vo.SYS_PARAM_ACTION_ARG_MAPVO;
import com.path.dbmaps.vo.SYS_PARAM_ACTION_COND_MAPVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_PROCESS_DEFVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_PROCESS_VARVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_TASK_MAPVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_TASK_MAP_ARG_INVO;
import com.path.dbmaps.vo.SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO;
import com.path.dbmaps.vo.SYS_PARAM_BTN_CUSTVO;
import com.path.dbmaps.vo.SYS_PARAM_BTN_CUST_ACTIONSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;

/**
 * @author fareskassab
 *
 */
public class BpmExporterCO extends BaseVO
{

    private SYS_PARAM_BPM_PROCESS_DEFVO processDefVO;
    private List<SYS_PARAM_BPM_TASK_MAPVO> taskMapVOList = new ArrayList<SYS_PARAM_BPM_TASK_MAPVO>();
    private List<SYS_PARAM_BPM_TASK_MAP_ARG_INVO> mapArgInVOList = new ArrayList<SYS_PARAM_BPM_TASK_MAP_ARG_INVO>();
    private List<SYS_PARAM_BPM_PROCESS_VARVO> procVarVOList = new ArrayList<SYS_PARAM_BPM_PROCESS_VARVO>();
    private List<OPTVO> optVOList = new ArrayList<OPTVO>();
    private List<OPT_EXTENDEDVO> optExtendedVOList = new ArrayList<OPT_EXTENDEDVO>();
    private List<SYS_PARAM_BTN_CUSTVO> paramBtnCustVOList = new ArrayList<SYS_PARAM_BTN_CUSTVO>();
    private List<SYS_PARAM_BTN_CUST_ACTIONSVO> paramBtnCustActionVOList = new ArrayList<SYS_PARAM_BTN_CUST_ACTIONSVO>();
    private List<SYS_PARAM_ACTION_ARG_MAPVO> paramActionArgMapVOList = new ArrayList<SYS_PARAM_ACTION_ARG_MAPVO>();
    private List<SYS_PARAM_ACTION_COND_MAPVO> paramActionCondMapVOList = new ArrayList<SYS_PARAM_ACTION_COND_MAPVO>();
    
    private List<SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO> mapArgOutVOList = new ArrayList<SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO>();
    private Map<BigDecimal, String> fldIdentifierArgOutMap = new HashMap<BigDecimal, String>(); 
    private Map<BigDecimal, String> fldIdentifierParamActionArgMap = new HashMap<BigDecimal, String>();
    private List<SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenDisplayVOList = new ArrayList<SYS_PARAM_SCREEN_DISPLAYVO>();
    private List<FIELD_TECH_DETAILSVO> fieldTechDetailsVOList = new ArrayList<FIELD_TECH_DETAILSVO>();
    
    //@JsonIgnore used to avoid adding the mapArgOutVO and elementName in the generated json file
    @JsonIgnore
    private SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO mapArgOutVO = null;
    @JsonIgnore
    private String elementName;
    @JsonIgnore
    private SYS_PARAM_ACTION_ARG_MAPVO actionArgMapVO = null;
    
    public SYS_PARAM_BPM_PROCESS_DEFVO getProcessDefVO()
    {
        return processDefVO;
    }
    public void setProcessDefVO(SYS_PARAM_BPM_PROCESS_DEFVO processDefVO)
    {
        this.processDefVO = processDefVO;
    }
    public List<SYS_PARAM_BPM_TASK_MAPVO> getTaskMapVOList()
    {
        return taskMapVOList;
    }
    public void setTaskMapVOList(List<SYS_PARAM_BPM_TASK_MAPVO> taskMapVOList)
    {
        this.taskMapVOList = taskMapVOList;
    }
    public List<SYS_PARAM_BPM_TASK_MAP_ARG_INVO> getMapArgInVOList()
    {
        return mapArgInVOList;
    }
    public void setMapArgInVOList(List<SYS_PARAM_BPM_TASK_MAP_ARG_INVO> mapArgInVOList)
    {
        this.mapArgInVOList = mapArgInVOList;
    }
    public List<SYS_PARAM_BPM_PROCESS_VARVO> getProcVarVOList()
    {
        return procVarVOList;
    }
    public void setProcVarVOList(List<SYS_PARAM_BPM_PROCESS_VARVO> procVarVOList)
    {
        this.procVarVOList = procVarVOList;
    }
    public List<OPTVO> getOptVOList()
    {
        return optVOList;
    }
    public void setOptVOList(List<OPTVO> optVOList)
    {
        this.optVOList = optVOList;
    }
    public List<OPT_EXTENDEDVO> getOptExtendedVOList()
    {
        return optExtendedVOList;
    }
    public void setOptExtendedVOList(List<OPT_EXTENDEDVO> optExtendedVOList)
    {
        this.optExtendedVOList = optExtendedVOList;
    }
    public List<SYS_PARAM_BTN_CUSTVO> getParamBtnCustVOList()
    {
        return paramBtnCustVOList;
    }
    public void setParamBtnCustVOList(List<SYS_PARAM_BTN_CUSTVO> paramBtnCustVOList)
    {
        this.paramBtnCustVOList = paramBtnCustVOList;
    }
    public List<SYS_PARAM_BTN_CUST_ACTIONSVO> getParamBtnCustActionVOList()
    {
        return paramBtnCustActionVOList;
    }
    public void setParamBtnCustActionVOList(List<SYS_PARAM_BTN_CUST_ACTIONSVO> paramBtnCustActionVOList)
    {
        this.paramBtnCustActionVOList = paramBtnCustActionVOList;
    }
    public List<SYS_PARAM_ACTION_ARG_MAPVO> getParamActionArgMapVOList()
    {
        return paramActionArgMapVOList;
    }
    public void setParamActionArgMapVOList(List<SYS_PARAM_ACTION_ARG_MAPVO> paramActionArgMapVOList)
    {
        this.paramActionArgMapVOList = paramActionArgMapVOList;
    }
    public List<SYS_PARAM_ACTION_COND_MAPVO> getParamActionCondMapVOList()
    {
        return paramActionCondMapVOList;
    }
    public void setParamActionCondMapVOList(List<SYS_PARAM_ACTION_COND_MAPVO> paramActionCondMapVOList)
    {
        this.paramActionCondMapVOList = paramActionCondMapVOList;
    }
    public List<SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO> getMapArgOutVOList()
    {
        return mapArgOutVOList;
    }
    public void setMapArgOutVOList(List<SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO> mapArgOutVOList)
    {
        this.mapArgOutVOList = mapArgOutVOList;
    }
    public Map<BigDecimal, String> getFldIdentifierArgOutMap()
    {
        return fldIdentifierArgOutMap;
    }
    public void setFldIdentifierArgOutMap(Map<BigDecimal, String> fldIdentifierArgOutMap)
    {
        this.fldIdentifierArgOutMap = fldIdentifierArgOutMap;
    }
    public SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO getMapArgOutVO()
    {
        return mapArgOutVO;
    }
    public void setMapArgOutVO(SYS_PARAM_BPM_TASK_MAP_ARG_OUTVO mapArgOutVO)
    {
        this.mapArgOutVO = mapArgOutVO;
    }
    public String getElementName()
    {
        return elementName;
    }
    public void setElementName(String elementName)
    {
        this.elementName = elementName;
    }
    public Map<BigDecimal, String> getFldIdentifierParamActionArgMap()
    {
        return fldIdentifierParamActionArgMap;
    }
    public void setFldIdentifierParamActionArgMap(Map<BigDecimal, String> fldIdentifierParamActionArgMap)
    {
        this.fldIdentifierParamActionArgMap = fldIdentifierParamActionArgMap;
    }
    public SYS_PARAM_ACTION_ARG_MAPVO getActionArgMapVO()
    {
        return actionArgMapVO;
    }
    public void setActionArgMapVO(SYS_PARAM_ACTION_ARG_MAPVO actionArgMapVO)
    {
        this.actionArgMapVO = actionArgMapVO;
    }
    public List<SYS_PARAM_SCREEN_DISPLAYVO> getSysParamScreenDisplayVOList()
    {
        return sysParamScreenDisplayVOList;
    }
    public void setSysParamScreenDisplayVOList(List<SYS_PARAM_SCREEN_DISPLAYVO> sysParamScreenDisplayVOList)
    {
        this.sysParamScreenDisplayVOList = sysParamScreenDisplayVOList;
    }
    public List<FIELD_TECH_DETAILSVO> getFieldTechDetailsVOList()
    {
        return fieldTechDetailsVOList;
    }
    public void setFieldTechDetailsVOList(List<FIELD_TECH_DETAILSVO> fieldTechDetailsVOList)
    {
        this.fieldTechDetailsVOList = fieldTechDetailsVOList;
    }
    
}
