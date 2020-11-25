/**
 * 
 */
package com.path.actions.common.customization.object;

import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.customization.object.ObjectCustomizationBO;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.customization.object.ObjectCustomizationSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

/**
 * @author marwanmaddah
 *
 */
public class ObjectCustomizationListAction extends GridBaseAction
{
    private ObjectCustomizationBO objectCustomizationBO;
    private ObjectCustomizationSC custSC = new ObjectCustomizationSC();
    private List<SelectCO> columnNameList;
    private List<SelectCO> visibilityCmbList;
    private List<SelectCO> readonlyCmbList;
    private List<SelectCO> requiredCmbList;
    
    @Override
    public Object getModel()
    {
        return custSC;
    }
    /**
     * Used for loading the Grid of Business Translation
     * 
     * @return
     */
    public String loadCustDetailsList()
    {
	try
	{
	    String[] searchCol = { "LABEL_KEY", "MIN_LENGTH", "MAX_LENGTH","BUS_RELATED"};
	    /**
	     * copy the details related to search criteria to the SC
	     */
	    SessionCO sessionCO = returnSessionObject();
	    custSC.setPreferredLanguage(sessionCO.getLanguage());
	    custSC.setSearchCols(searchCol);
	    copyproperties(custSC);
	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(!NumberUtil.isEmptyDecimal(custSC.getSysParamObjDetailsDispVO().getOBJ_DISPLAY_ID()))
	    {
		    if(checkNbRec(custSC))
		    {
			setRecords(objectCustomizationBO.returnCusomizationDetailsListCount(custSC));
		    }

		    /**
		     * return the collection of records
		     */
		    List<ObjectCustomizationSC> generatedList = objectCustomizationBO.returnCusomizationDetailsList(custSC);
		    for(ObjectCustomizationSC oc : generatedList)
		    {
			setComboDesc(oc);
		    }
		    NumberUtil.resetEmptyValues(generatedList);
		    setGridModel(generatedList);
	    }

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    /**
     * setting the combo description for all combo lists
     */
    private void setComboDesc(ObjectCustomizationSC oc)
    {
	switch(oc.getSysParamObjDetailsDispVO().getIS_READONLY().toString())
	{
	    case "0": oc.setReadOnlyComboDesc(getText("editable_key"));break;
	    case "1": oc.setReadOnlyComboDesc(getText("readonly_key"));break;
	    case "2": oc.setReadOnlyComboDesc(getText("readOnly_expr_key"));break;
	}
	switch(oc.getSysParamObjDetailsDispVO().getIS_MANDATORY().toString())
	{
	    case "0": oc.setMandatoryComboDesc(getText("not_required_key"));break;
	    case "1": oc.setMandatoryComboDesc(getText("required_key"));break;
	    case "2": oc.setMandatoryComboDesc(getText("required_expr_key"));break;
	}
	switch(oc.getSysParamObjDetailsDispVO().getIS_VISIBLE().toString())
	{
	    case "0": oc.setVisibilityComboDesc(getText("not_visibile_key"));break;
	    case "1": oc.setVisibilityComboDesc(getText("visibile_key"));break;
	    case "2": oc.setVisibilityComboDesc(getText("visibility_expr_key"));break;
	}
    }
    /**
     * fill all combo boxes for the related screen
     */
    public String fillComboBox()
    {
	if(visibilityCmbList == null || visibilityCmbList.size()<=0 || readonlyCmbList==null || readonlyCmbList.size()<= 0 || requiredCmbList == null || requiredCmbList.size()<= 0)
	{
        	/**
        	 * combo boxes management
        	 */
        	SelectCO visibilityCO = null;
        	SelectCO readOnlyCO = null;
        	SelectCO requiredCO = null;
        	visibilityCmbList = new ArrayList<SelectCO>();
        	readonlyCmbList = new ArrayList<SelectCO>();
        	requiredCmbList = new ArrayList<SelectCO>();
        	/**
        	 *  define the LOV of the button activity type
        	 */
        	SelectSC selSC = new SelectSC(ConstantsCommon.BUTTON_ACTIVITY_LOV_TYPE);
        	/**
        	 * [MarwanMaddah]:the length will be 4 in case the entity type is
        	 * cifType to add hide_and_override_business and
        	 * hide_and_override_business_based_on_expression management to the
        	 * visibility
        	 * ConstantsCommon.ENTITY_CIF_TYPE_DISPLAY.equals(StringUtil.nullToEmpty(custCO.getEntityType()))?4:2;
        	 */
        	int comboLength = 2;
        	for(int i = 0; i <= comboLength; i++)
        	{
        	    visibilityCO = new SelectCO();
        	    visibilityCO.setCode(String.valueOf(i));
        	    
        	    readOnlyCO = new SelectCO();
        	    readOnlyCO.setCode(String.valueOf(i));
        
        	    requiredCO = new SelectCO();
        	    requiredCO.setCode(String.valueOf(i));
        	    switch (i)
        	    {
        		case 0:
        		    visibilityCO.setDescValue(getText("not_visibile_key"));
        		    readOnlyCO.setDescValue(getText("editable_key"));
        		    requiredCO.setDescValue(getText("not_required_key"));
        		    break;
        		case 1:
        		    visibilityCO.setDescValue(getText("visibile_key"));
        		    readOnlyCO.setDescValue(getText("readonly_key"));
        		    requiredCO.setDescValue(getText("required_key"));
        		    break;
        		case 2:
        		    visibilityCO.setDescValue(getText("visibility_expr_key"));
        		    readOnlyCO.setDescValue(getText("readOnly_expr_key"));
        		    requiredCO.setDescValue(getText("required_expr_key"));
        		    break;
        		default:
        		    break;
        	    }
        		visibilityCmbList.add(visibilityCO);
        		readonlyCmbList.add(readOnlyCO);
        		requiredCmbList.add(requiredCO);
        	}
	}
	return "jsonSuccess";
    }
    
    
    public String deleteObjectCustDetails()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(custSC.getSysParamObjDetailsDispVO().getOBJ_DISPLAY_ID()))
	    {
		objectCustomizationBO.deleteObjectCustDetails(custSC);

		set_warning(getText("Record_was_Deleted_Successfully_key"));
		set_msgTitle(getText("info_msg_title_key"));
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "jsonSuccess";
    }
    /**
     * @param objectCustomizationBO the objectCustomizationBO to set
     */
    public void setObjectCustomizationBO(ObjectCustomizationBO objectCustomizationBO)
    {
        this.objectCustomizationBO = objectCustomizationBO;
    }

    /**
     * @return the custSC
     */
    public ObjectCustomizationSC getCustSC()
    {
        return custSC;
    }

    /**
     * @param custSC the custSC to set
     */
    public void setCustSC(ObjectCustomizationSC custSC)
    {
        this.custSC = custSC;
    }
    public List<SelectCO> getColumnNameList()
    {
        return columnNameList;
    }
    public void setColumnNameList(List<SelectCO> columnNameList)
    {
        this.columnNameList = columnNameList;
    }
    public List<SelectCO> getVisibilityCmbList()
    {
        return visibilityCmbList;
    }
    public void setVisibilityCmbList(List<SelectCO> visibilityCmbList)
    {
        this.visibilityCmbList = visibilityCmbList;
    }
    public List<SelectCO> getReadonlyCmbList()
    {
        return readonlyCmbList;
    }
    public void setReadonlyCmbList(List<SelectCO> readonlyCmbList)
    {
        this.readonlyCmbList = readonlyCmbList;
    }
    public List<SelectCO> getRequiredCmbList()
    {
        return requiredCmbList;
    }
    public void setRequiredCmbList(List<SelectCO> requiredCmbList)
    {
        this.requiredCmbList = requiredCmbList;
    }
    
}
