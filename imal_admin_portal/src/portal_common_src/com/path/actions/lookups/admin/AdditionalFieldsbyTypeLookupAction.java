package com.path.actions.lookups.admin;

import java.util.List;
import java.util.Map;

import com.path.bo.common.MessageCodes;
import com.path.bo.common.additionalfields.AdditionalFieldsBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.admin.additionalfields.AdditionalFieldsByTypeSC;
import com.path.vo.common.SessionCO;

public class AdditionalFieldsbyTypeLookupAction extends LookupBaseAction
{
    private AdditionalFieldsBO additionalFieldsBO;
    private AdditionalFieldsByTypeSC additionalFieldsByTypeSC = new AdditionalFieldsByTypeSC();
    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    Map<String, Object> gridDetails = additionalFieldsBO.returnGridDetails(additionalFieldsByTypeSC);
	    String[] name = (String[])gridDetails.get("name");
	    String[] colType = (String[])gridDetails.get("colType");
	    String[] titles = (String[])gridDetails.get("titles");

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AddFieldsByTypeOptions_fillAdditionalFieldsOptionsLookup");
	    lookup(grid, additionalFieldsByTypeSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of AdditionalFieldsbyTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Fill the lookup AdditionalFields by Type filtered by the defined criteria
     * 
     * @return String
     */
    public String fillAdditionalFieldsOptionsLookup()
    {
	try
	{
	    if(additionalFieldsByTypeSC.getPARAM1_LINK_VALUE() != null
			&& additionalFieldsByTypeSC.getPARAM1_LINK_VALUE().equals(""))
	    {
		throw new BOException(MessageCodes.PLEASE_FILL,
			new String[] { additionalFieldsByTypeSC.getParam1LinkLabel() }, true);
	    }
	    if(additionalFieldsByTypeSC.getPARAM2_LINK_VALUE() != null
			&& additionalFieldsByTypeSC.getPARAM2_LINK_VALUE().equals(""))
	    {
		throw new BOException(MessageCodes.PLEASE_FILL,
			new String[] { additionalFieldsByTypeSC.getParam2LinkLabel() }, true);
	    }
	    if(additionalFieldsByTypeSC.getPARAM3_LINK_VALUE() != null
			&& additionalFieldsByTypeSC.getPARAM3_LINK_VALUE().equals(""))
	    {
		throw new BOException(MessageCodes.PLEASE_FILL,
			new String[] { additionalFieldsByTypeSC.getParam3LinkLabel() }, true);
	    }
	    if(additionalFieldsByTypeSC.getPARAM4_LINK_VALUE() != null
			&& additionalFieldsByTypeSC.getPARAM4_LINK_VALUE().equals(""))
	    {
		throw new BOException(MessageCodes.PLEASE_FILL,
			new String[] { additionalFieldsByTypeSC.getParam4LinkLabel() }, true);
	    }
	    if(additionalFieldsByTypeSC.getPARAM5_LINK_VALUE() != null
			&& additionalFieldsByTypeSC.getPARAM5_LINK_VALUE().equals(""))
	    {
		throw new BOException(MessageCodes.PLEASE_FILL,
			new String[] { additionalFieldsByTypeSC.getParam5LinkLabel() }, true);
	    }
		
	    setSearchFilter(additionalFieldsByTypeSC);
	    copyproperties(additionalFieldsByTypeSC);
	    //Setting session values
	    SessionCO sessionCO = returnSessionObject();
	    additionalFieldsByTypeSC.setCompCode(sessionCO.getCompanyCode());
	    additionalFieldsByTypeSC.setBranchCode(sessionCO.getBranchCode());
	    additionalFieldsByTypeSC.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    additionalFieldsByTypeSC.setFiscalYear(sessionCO.getFiscalYear());
	    additionalFieldsByTypeSC.setBaseCurrDecPoint(sessionCO.getBaseCurrDecPoint());
	    additionalFieldsByTypeSC.setExposCurCode(sessionCO.getExposCurCode());
	    additionalFieldsByTypeSC.setCompanyName(sessionCO.getCompanyName());
	    additionalFieldsByTypeSC.setCompanyArabName(sessionCO.getCompanyArabName());
	    additionalFieldsByTypeSC.setUserName(sessionCO.getUserName());
	    additionalFieldsByTypeSC.setClientType(sessionCO.getClientType());
	    additionalFieldsByTypeSC.setBaseCurrencyName(sessionCO.getBaseCurrencyName());
	    additionalFieldsByTypeSC.setExposCurName(sessionCO.getExposCurName());
	    additionalFieldsByTypeSC.setCurrentAppName(sessionCO.getCurrentAppName());
	    additionalFieldsByTypeSC.setRunningDateRET(sessionCO.getRunningDateRET());
	 
	    if(checkNbRec(additionalFieldsByTypeSC))
	    {
		setRecords(additionalFieldsBO.returnAdditionalFieldsbyTypeLookupDataListCount(additionalFieldsByTypeSC));
	    }
	    List<Object> additionalFieldsByTypeList = additionalFieldsBO.returnAdditionalFieldsbyTypeLookupDataList(additionalFieldsByTypeSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(additionalFieldsByTypeList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillAdditionalFieldsOptionsLookup of AdditionalFieldsbyTypeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * @param additionalFieldsBO the additionalFieldsBO to set
     */
    public void setAdditionalFieldsBO(AdditionalFieldsBO additionalFieldsBO)
    {
        this.additionalFieldsBO = additionalFieldsBO;
    }

    public Object getModel()
    {
        return additionalFieldsByTypeSC;
    }
    
    /**
     * @return the additionalFieldsByTypeSC
     */
    public AdditionalFieldsByTypeSC getAdditionalFieldsByTypeSC()
    {
        return additionalFieldsByTypeSC;
    }

    /**
     * @param additionalFieldsByTypeSC the additionalFieldsByTypeSC to set
     */
    public void setAdditionalFieldsByTypeSC(AdditionalFieldsByTypeSC additionalFieldsByTypeSC)
    {
        this.additionalFieldsByTypeSC = additionalFieldsByTypeSC;
    }
}
