/**
 * 
 */
package com.path.bo.common.dynamicscreen;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.path.dbmaps.vo.SYS_DYN_SCREEN_DEFVO;
import com.path.dbmaps.vo.SYS_DYN_SCREEN_ELEMENTS_DETVO;
import com.path.dbmaps.vo.SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.admin.dynamicparams.DynamicParamsVO;
import com.path.vo.common.CommonLibSC;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.customization.button.SysParamGlobalActArgMapSC;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapCO;
import com.path.vo.common.dynamicscreen.DynamicScreenParamsMapSC;
import com.path.vo.common.dynamicscreen.LinkDynScrTabCO;
import com.path.vo.common.dynamicscreen.LinkDynamicScreenCO;
import com.path.vo.common.dynlookup.DynCommonLookupSC;
import com.path.vo.common.screengenerator.DynamicScreenCreatorCO;
import com.path.vo.common.screengenerator.DynamicScreenFileCO;
import com.path.vo.common.screengenerator.ScreenGeneratorSC;
import com.path.vo.common.select.SelectCO;

/**
 * Copyright 2016, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DynLookupBO.java used to
 */
public interface DynamicScreenBO
{
  //public String returnLookupQueryData(DynCommonLookupSC criteria) throws BaseException;
  public DynamicScreenCO returnelemPropertyDetails(DynCommonLookupSC criteria) throws BaseException;
  public ArrayList<LinkedHashMap> returnLookupQryResult(DynCommonLookupSC criteria) throws BaseException;
  public int returnLookupQryCount(DynCommonLookupSC criteria) throws BaseException;
  public Map<String,SYS_PARAM_SCREEN_DISPLAYVO> returnDynScreenElemExpressions(CommonLibSC criteria) throws BaseException;
  public List<DynamicScreenCreatorCO> dynScreensLkpRecords(DynCommonLookupSC criteria) throws BaseException;
  public int dynScreensLkpCount(DynCommonLookupSC criteria) throws BaseException;
  public SYS_DYN_SCREEN_DEFVO returnScreenInfo(CommonLibSC criteria) throws BaseException;
  /**
   * this function will return the count of the list of parameter mapping of the dynamic screen.
   * 
   * @param criteria
   * @return
   * @throws DAOException
   */
  public int returnDynScreenParamMapCount(DynamicScreenParamsMapSC criteria) throws BaseException;
    
  /**
   * this function will return the list of parameter mapping of the dynamic screen.
   * 
   * @param criteria
   * @return
   * @throws DAOException
   */
  public List<DynamicScreenParamsMapCO> returnDynScreenParamMap(DynamicScreenParamsMapSC criteria) throws BaseException;
  
  /**
   * 
   * Get the list of elements in a dynamic screen and define the fliping management...
   * @param criteria
   * @return
   * @throws BaseException List
   *
   */
  public List<DynamicScreenCO> dynScreenElementsLkpRecords(DynCommonLookupSC criteria) throws BaseException; 
  
  /**
   * Get the count of elements in a dynamic screen, based on a criteria ...
   * @param criteria
   * @return
   * @throws BaseException
   */
  public int dynScreenElementsLkpCount(DynCommonLookupSC criteria) throws BaseException;
  
  /**
   * this function handles the dependency by screen element id
   * @param dynamicScreenCO
   * @return
   * @throws BaseException
   */
  public DynamicScreenCO dependencyByScreenElementId(DynCommonLookupSC criteria) throws BaseException;
  
  /**
   * This function is used to save the dynamic screen mapping records defined in the grid.
   * @param dynamicScreenParamsMapCO
   * @param dynamicScreenParamsMapCOList
   * @return
   * @throws BaseException
   */
  public DynamicScreenParamsMapCO saveDynamicScreenParamMap(DynamicScreenParamsMapCO dynamicScreenParamsMapCO,  List<DynamicScreenParamsMapCO> dynamicScreenParamsMapCOList) throws BaseException;
  
  /**
   * This function will delete a record in field mapping grid
   * @param dynamicScreenParamsMapCO
   * @return
   * @throws BaseException
   */
  public DynamicScreenParamsMapCO deleteDynScreenFieldMapping(DynamicScreenParamsMapCO dynamicScreenParamsMapCO)throws BaseException;
  
  /**
   * This function will check if an element map id is defined for the specified criteria
   * @return
   * @throws BaseException
   */
  public BigDecimal checkExistingElementMapId(DynamicScreenParamsMapSC criteria) throws BaseException;
  
  /**
   * This function returns all the mapped parameters defined for a dynamic screen
   * @param criteria
   * @throws BaseException
   */
  public List<DynamicScreenParamsMapCO> returnDynScreenMappedParameters(DynamicScreenParamsMapSC criteria) throws BaseException;
  
  /**
   * This function is used to return old mapping done in SYS_PARAM_ELM_DYN_SCRN_MAP and SYS_PARAM_ELM_DYN_SCRN_MAP_DET when changing the screen id
   * @param criteria
   * @throws BaseException
   */
  public List<BigDecimal> returnOldDynScreenMapping(DynamicScreenParamsMapSC criteria) throws BaseException;
  
  /**
   * This function is used to delete an old record of SYS_PARAM_ELM_DYN_SCRN_MAP that don't have any SYS_PARAM_ELM_DYN_SCRN_MAP_DET
   * @param criteria
   * @throws BaseException
   */
  public void deleteOldSysDynScreenDef(DynamicScreenParamsMapSC criteria) throws BaseException;
  
  /**
   * Used to return all the elements ids that are exists in the screen with the data type and the related mode.
   * @author marwanmaddah
   * @date   Mar 16, 2016
   * @param criteria
   * @return
   * @throws BaseException HashMap<String,String>
   *
   */
  public Map<String,DynamicScreenCO> returnParamsDataType(DynCommonLookupSC criteria) throws BaseException;
  /**
   * 
   * @param criteria
   * @param dynScrParamMap
   * @param paramVO
   * @param propertyBigValue
   * @return
   * @throws BaseException
   */
  public Object executeCurrentExpression(ScreenGeneratorSC criteria,Map<BigDecimal, SYS_PARAM_ELM_DYN_SCRN_MAP_DETVO> dynScrParamMap,DynamicParamsVO paramVO,String propertyBigValue,RequiredFieldsSC requiredFieldsSC) throws BaseException;
  public List<DynamicScreenCO> linkDynScreenListRecords(ScreenGeneratorSC criteria) throws BaseException;
  public int linkDynScreenListCount(ScreenGeneratorSC criteria) throws BaseException;
  public void linkDynScreenSubmitMgnt(LinkDynamicScreenCO linkDynamicScreenCO) throws BaseException;
  public LinkDynamicScreenCO returnLinkDynScreenData(ScreenGeneratorSC criteria) throws BaseException;
  public void linkDynScreenDeleteMgnt(LinkDynamicScreenCO linkDynamicScreenCO) throws BaseException;
  /**
   * 
   * marwanmaddah
   */
  public void linkDynScrTabDeleteMgnt(LinkDynScrTabCO linkDynScrTabCO) throws BaseException;
  /**
   * create new Tab and link it to a dynamic screen section
   * marwanmaddah
   */
  public List<LinkDynScrTabCO> linkDynScrTabListRecords(ScreenGeneratorSC criteria) throws BaseException;
  public int linkDynScrTabListCount(ScreenGeneratorSC criteria) throws BaseException;
  public void linkDynScrTabSubmitMgnt(LinkDynScrTabCO linkDynScrTabCO) throws BaseException;
  public List<LinkDynScrTabCO> returnAdditionalObjElements(ScreenGeneratorSC criteria) throws BaseException;
  public LinkDynScrTabCO returnLinkDynScrTabData(ScreenGeneratorSC criteria) throws BaseException;
  public Map<String,SYS_PARAM_SCREEN_DISPLAYVO> retrnElemsValAndExp(ScreenGeneratorSC criteria, Map <String,SYS_PARAM_SCREEN_DISPLAYVO> displayhm) throws BaseException;
  /**
   * Update LiveSearch assigned description field value.
   * @param criteria
   * @throws BaseException
   */
  public void updateLiveSearchDesc(CommonLibSC criteria) throws BaseException;
  /**
   * Submit Dynamic form in order to insert a new record in the database
   * @param scrElemHm,screenGeneratorSC
   * @throws BaseException
   * adelnasrallah
   */
  public void submitDynamicScreenForm(Map<String,String> scrElemHm,Map<String,DynamicScreenFileCO> dynFileElemHm,Map<String,String> gridElemHm,ScreenGeneratorSC screenGeneratorSC) throws BaseException;
  /**
   * retrieve dynamic table information related to screen
   * @param ScreenGeneratorSC
   * @throws BaseException
   * adelnasrallah
   */
  public List<DynamicScreenCreatorCO> retrieveDynamicTableInfo(ScreenGeneratorSC screenGeneratorSC) throws BaseException;
  /**
   * retrieve dynamic grid records
   * @param ScreenGeneratorSC
   * @throws BaseException
   * adelnasrallah
   */
  public List<LinkedHashMap> returnDynGridListRecords(ScreenGeneratorSC criteria) throws BaseException;
  /**
   * retrieve dynamic grid count of records
   * @param ScreenGeneratorSC
   * @throws BaseException
   * adelnasrallah
   */
  public int returnDynGridListCount(ScreenGeneratorSC criteria) throws BaseException;
  /**
   * Delete Dynamic form record from database
   * @param scrElemHm,screenGeneratorSC
   * @throws BaseException
   * adelnasrallah
   */
  public void deleteDynamicScreenForm(Map<String,String> scrElemHm,ScreenGeneratorSC screenGeneratorSC) throws BaseException;
  /**
   * Retrieve Dynamic Table Columns with Property Name
   * @param screenGeneratorSC
   * @throws BaseException
   * adelnasrallah
   */
  public List<DynamicScreenCreatorCO> retrieveDynTableScreenColsInfo(ScreenGeneratorSC screenGeneratorSC) throws BaseException;
  /**
   * Retrieve dynamic file from DB
   * @param scrElemHm,dynFileElemHm,screenGeneratorSC
   * @throws BaseException
   * adelnasrallah
   */
  public DynamicScreenFileCO downloadDynFile(Map<String,String> scrElemHm,Map<String,DynamicScreenFileCO> dynFileElemHm,ScreenGeneratorSC screenGeneratorSC) throws BaseException;
  /**
   * retrieve dynamic table information by table id
   * @param ScreenGeneratorSC
   * @throws BaseException
   * adelnasrallah
   */
  public List<DynamicScreenCreatorCO> retrieveTableInfoById(ScreenGeneratorSC screenGeneratorSC) throws BaseException;
  /**
   * return col query lookup related to grid widget
   * @param ScreenGeneratorSC
   * @throws BaseException
   * adelnasrallah
   */
  public String returnGridWidgetLookup(DynCommonLookupSC criteria) throws BaseException;
  
  /**
   * function used to save into SYS_PARAM_GLOBAL_ACT_ARG_MAP
   * @param buttonCustParamsMapSC
   * @param buttonCustParamsMapSCList
   * @throws BaseException
   */
  public void saveButtonCustParamMap(SysParamGlobalActArgMapSC buttonCustParamsMapSC, List<SysParamGlobalActArgMapSC> buttonCustParamsMapSCList) throws BaseException;
  /**
   * @author Muhammad.Asif 
   * function used to fill combo box static, query & reset service.
   * @param ScreenGeneratorSC
   * @throws BaseException
   */
  public List<SelectCO> fillOptionsDataList(ScreenGeneratorSC criteria)  throws BaseException;
  
  /**
   * @author Muhammad.Asif 
   * function used to fill grid on rest operation 
   * @param ScreenGeneratorSC
   * @throws BaseException
   */
  public List<LinkedHashMap> loadByRestService(ScreenGeneratorSC criteria)  throws BaseException;

  /**
   * Function used to return grid column properties
   * @param criteria
   * @return
   * @throws BaseException
   */
  public String returnColProps(ScreenGeneratorSC criteria) throws BaseException;
  /**
   * 
   * Function used to return Column Property Value
   * @param elementID this is element id
   * @param propertyCode this is to specify which property to be retrieved,
   *            Ex: id, name etc.
   * @return
   * @throws BaseException
   */
  public SYS_DYN_SCREEN_ELEMENTS_DETVO returnColumnPropertyValue(BigDecimal elementID,String propertyCode)throws BaseException;
  /**
   * Function used to return live search query result for Column Properties 
   * @param requiredFieldsSC
   * @param dynCommonLookupSC
   * @param elemHm
   * @return
   * @throws BaseException
   */
  public ArrayList<LinkedHashMap> validateColPropLookupQuery( RequiredFieldsSC requiredFieldsSC,DynCommonLookupSC dynCommonLookupSC,Map<String, Object> elemHm) throws BaseException;
}
