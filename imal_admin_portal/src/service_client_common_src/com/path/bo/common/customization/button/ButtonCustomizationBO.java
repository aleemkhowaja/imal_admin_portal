package com.path.bo.common.customization.button;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.JSONException;
import com.path.dbmaps.vo.SYS_PARAM_BTN_CUST_OUTPUT_MAPVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_ELEMENTSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.customization.CustomElementActivitiesSC;
import com.path.vo.common.customization.button.ButtonCustomizationCO;
import com.path.vo.common.customization.button.ButtonCustomizationSC;
import com.path.vo.common.customization.button.CustomActionParamCO;
import com.path.vo.common.customization.button.SysParamActionArgListSC;
import com.path.vo.common.customization.button.SysParamBtnCustOutMapSC;
import com.path.vo.common.customization.button.SysParamGlobalActArgMapSC;
import com.path.vo.common.dynamicscreen.DynamicScreenCO;
import com.path.vo.common.dynlookup.DynCommonLookupSC;

public interface ButtonCustomizationBO
{
    /**
     * this function is used to return the count of the custom button
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnButtonCustomListCount(ButtonCustomizationSC criteria) throws BaseException;
    /**
     * this function is used to return the list of custom buttons that should be displayed in the button grid in the customization screen.
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<ButtonCustomizationCO> returnButtonCustomList(ButtonCustomizationSC criteria) throws BaseException;
    
    /**
     * this function will return the count of the actions attached to a custom button
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnButtonActionsListCount(ButtonCustomizationSC criteria) throws BaseException;
    /**
     * this function will return the actions attached to a custom button and that should be displayed inside the action's grid
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<ButtonCustomizationCO> returnButtonActionsList(ButtonCustomizationSC criteria) throws BaseException;
    
    /**
     * this function will save the custom button details like label_key, order..
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO saveButtonCustDetails(ButtonCustomizationCO buttonCustomizationCO, Map<String, Object> condExprMap) throws BaseException;
    /**
     * this function is used to delete the custom button including all attached actions and argument mapping
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO deleteButtonCustDetails(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;
    
    /**
     * returns the actions count defined in IM_IMAL_API
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnActionsListCount(ButtonCustomizationSC criteria) throws BaseException;
    /**
     * return the actions defined in  IM_IMAL_API
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<ButtonCustomizationCO> returnActionsList(ButtonCustomizationSC criteria) throws BaseException;
    /**
     * delete an action already attached to a custom button including the argument mapping related to it 
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO deleteButtonAction(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;
    /**
     * save the action info attached to the button like the action order, action id, result expression
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO saveButtonAction(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;
    /**
     * dependency by action code that is called when selecting an action to be attached to the custom button
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO dependencyByActionCode(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;
    /**
     * returns action arguments to construct the dynamic mapping table
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public List<ButtonCustomizationCO> returnActionArguments(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;
    /**
     * common function that will execute all the actions attached to a custom button
     * @param actionsParamMap
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO callCustomBtnActions(Map<BigDecimal, Map<BigDecimal, CustomActionParamCO>> actionsParamMap,Map<BigDecimal, BigDecimal> nextActionsMap,Map<String, Object> condExprData, ButtonCustomizationCO buttonCustomizationCO) throws BaseException;
    
    /**
     * return the list of element defined in SYS_PARAM_SCREEN_ELEMENT for the current screen
     * @param buttonCustomizationSC
     * @return
     * @throws BaseException
     */
    public List<SYS_PARAM_SCREEN_ELEMENTSVO> returnScreenElementList(ButtonCustomizationSC buttonCustomizationSC) throws BaseException;
    /**
     * return the count of element defined in SYS_PARAM_SCREEN_ELEMENT for the current screen
     * @param buttonCustomizationSC
     * @return
     * @throws BaseException
     */
    public int returnScreenElementListCount(ButtonCustomizationSC buttonCustomizationSC) throws BaseException;
    /**
     * dependency called when changing the mapping type from screen to session to constant and used to reload the mapping content
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO dependencyBySourceMap(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;
    /**
     * return the list of argument defined for a specific action and used when we need to link an argument to another argument
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<ButtonCustomizationCO> returnArgList(ButtonCustomizationSC criteria) throws BaseException;
    /**
     * return the count of list of argument defined for a specific action and used when we need to link an argument to another argument
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnArgListCount(ButtonCustomizationSC criteria) throws BaseException;
    /**
     * dependency called when we need to link an arguemnt to another argument. 
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO dependencyByLinkArg(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;
    /**
     * function that will load the action details when selection an action from the grid of actions attached to a custom button
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO loadButtonCustActionsDetails(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;
    
    /**
     * return the list of operations defined for the related custom button
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<ButtonCustomizationCO> returnButtonCondList(ButtonCustomizationSC criteria) throws BaseException;
    
    /**
     * return the count of the list of operations defined for the related custom button
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnButtonCondListCount(ButtonCustomizationSC criteria) throws BaseException;
   
    /**
     * This function is used to select the button customization details. it will return the details in SYS_PARAM_BTN_CUSTVO of the buttonCustomizationCO.
     * The select is done by PK
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO loadButtonCustDetails(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;
    
    
    /**
     * dependency by operation id
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO dependencyByOperationId(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;

    /**
     * function to delete a single condition mapping in sysParamActionCondMapVO
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO deleteButtonCondMap(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;

    /**
     * function used to save the condition mapping. it will create/update the record based on the value of LINE_NO. 
     * LINE_NO = null then create otherwise update.
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO saveButtonCondMap(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;

    /**
     * This function is used to unformat the condition expression . it will replace the {1-2} repesenting the operation id and the argument id by their correspondent description
     * @param buttonCustomizationCO
     * @param customActionParamCOMap
     * @return
     */
    public ButtonCustomizationCO unformatConditionExpr(ButtonCustomizationCO buttonCustomizationCO, Map<BigDecimal, Map<BigDecimal, CustomActionParamCO>> customActionParamCOMap);
    
    /**
     * This function returns the screen elements defined in SYS_PARAM_SCREEN_ELEMENTS
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public List<ButtonCustomizationCO> returnScreenElements(ButtonCustomizationCO buttonCustomizationCO)  throws BaseException;

    /**
     * This function will copy a button and all it's details from an opt to another opt under the same parentRef 
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO copyButtonCust(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;

    /**
     * dependency to check if the global activity (IMAL/ROOT custom button) is correct or if the selected dynamic screen is correct 
     * @param buttonCustomizationCO
     * @return
     * @throws BaseException
     */
    public ButtonCustomizationCO dependencyByButtonActivityId(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;
    
    /**
     * call the dependency in dynamicScrfeenBo to check if the element id exists in the dynamic screen id. 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public DynamicScreenCO dependencyByScreenElementId(DynCommonLookupSC criteria)throws BaseException;
    
    /**
     * this function will return the list of parameter mapping of the dynamic screen.
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<SysParamGlobalActArgMapSC> returnButtonCustomizationParamMap(SysParamGlobalActArgMapSC criteria) throws BaseException;
   
    /**
     * this function will return the count of the list of parameter mapping of the dynamic screen.
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnButtonCustomizationParamMapCount(SysParamGlobalActArgMapSC criteria) throws BaseException;
    
    /**
     * This function is used to save the global screen mapping records defined in the grid.
     * @param buttonCustParamsMapSC
     * @param buttonCustParamsMapSCList
     * @throws BaseException
     */
    public void saveButtonCustParamMap(SysParamGlobalActArgMapSC buttonCustParamsMapSC,  List<SysParamGlobalActArgMapSC> buttonCustParamsMapSCList) throws BaseException;
    
    /**
     * This function is used to delete the global screen mapping record defined in the grid.
     * @param buttonCustomizationCO
     * @throws BaseException
     */
    public void deleteButtonCustFieldMapping(ButtonCustomizationCO buttonCustomizationCO) throws BaseException;
    
    /**
     *  This function is used to save the element activity screen records defined in the grid.
     * @param customElementActivitiesSC
     * @param customElementActivitiesSCList
     * @throws BaseException
     */
    public List<String> saveCustomElement(CustomElementActivitiesSC customElementActivitiesSC,List<CustomElementActivitiesSC> customElementActivitiesSCList)throws BaseException;
   
    /**
     * call custom button with map input parameter and return map output parameter.
     * @param buttonCustomizationCO
     * @param inputParamMap
     * @return
     * @throws BaseException
     */
    public Map<String, Object> callCustomBtnActions(ButtonCustomizationCO buttonCustomizationCO, Map<String, Object> inputParamMap)throws BaseException;
    /**
     * 
     * return button customization out Map for specific activity.
     * @param criteria
     * @return 
     * @throws BaseException
     */
    public List<SysParamBtnCustOutMapSC> returnBtnCustOutMap(SysParamBtnCustOutMapSC criteria)throws BaseException;
    /**
     * return button customization out Map count for specific activity.
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnBtnCustOutMapCount(SysParamBtnCustOutMapSC criteria)throws BaseException;
    
    /**
     * 
     * return count actions for output mapping 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int  returnActionsOutMapListCount(ButtonCustomizationSC criteria)throws BaseException;
    /**
     * return list of actions for output mapping.
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<ButtonCustomizationCO> returnActionsOutMapList(ButtonCustomizationSC criteria)throws BaseException;
    /**
     * delete button cust out map 
     * @param sysParamBtnCustOutMap
     * @throws BaseException
     */
    public void deleteButtonCustOutMap(SYS_PARAM_BTN_CUST_OUTPUT_MAPVO sysParamBtnCustOutMap)throws BaseException;
    /**
     * return action argument list count 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int returnBtnCustActionArgListCount(SysParamActionArgListSC criteria)throws BaseException;
    /**
     * return action argument list 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List<SysParamActionArgListSC> returnBtnCustActionArgList(SysParamActionArgListSC criteria)throws BaseException;
    /**
     * insert action argument list 
     * @param buttonCustomizationCO
     * @throws BaseException
     */
    public void saveButtonActionArgList(ButtonCustomizationCO buttonCustomizationCO)throws BaseException;
    /**
     * delete button Action argument list based on btn_id, op_id, arg_id, line_no.
     * @param buttonCustomizationCO
     * @throws BaseException
     */
    public void deleteButtonActionArgList(ButtonCustomizationCO buttonCustomizationCO)throws BaseException;
    /**
     * delete all button action arg list.
     * @param sc
     * @throws BaseException
     */
    public void deleteAllButtonActionArgList(SysParamActionArgListSC sc)throws BaseException;
    
    /*TP#983067 Option to load JS Method to be called from js File located on the server*/
    public String returnScriptUri(ButtonCustomizationSC buttonCustomizationSC) throws BaseException ;
    /**
     *TP#1015205
     * function used to return Button Customization Actions Details
     * @param criteria
     * @return List<ButtonCustomizationCO>
     * @throws BaseException
     */
    List<ButtonCustomizationCO> returnButtonActionDetails(ButtonCustomizationSC criteria) throws BaseException;
    /**
     * TP#1015205
     * used to return parameter map for specified Customized Button
     * Tp#101520 
     * @param buttonId
     * @param progRef
     * @param appName
     * @return hashmap
     * @throws BaseException
     */
    public HashMap<String,HashMap<String,String>> returnButtonCustParamMap (BigDecimal buttonId,String progRef, String appName) throws BaseException ;
    /**
     * return return JSON representation of dynamic screen details to be available for webservice call
     * Tp#101520
     * @param buttonId
     * @param progRef
     * @param appName
     * @param hashmap
     * @return String
     * @throws JSONException 
     */
    public String returnDynamicScreenDetails(BigDecimal buttonId,String progRef, String appName, Map<String, Object> operationFieldsMap) throws BaseException, JSONException;
}
