package com.path.actions.lookups.admin; 

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.gl.GLBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.gl.GLCO;
import com.path.vo.core.gl.GLSC;

public class GLCodeLookupAction extends LookupBaseAction
{

    private GLSC glSC = new GLSC();
    private List<GLCO> glList;
    private GLBO glBO;

    public Object getModel()
    {
	return glSC;
    }

    public String constructLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "GL_CODE", "TERM_IND", "TERM_DAYS", "BRIEF_DESC_ENG", "BS_CONTRA",
		    "ADDITIONAL_REFERENCE", "AC_SIGN", "BRIEF_DESC_ARAB" };
	    String[] colType = { "number", "text", "number", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Gl_Code_key"), getText("Period_key"), getText("Number_key"),
		    getText("Brief_Desc_Eng_key"), getText("Bs_Contra_key"), getText("Additional_Reference_key"),
		    getText("AC_Sign_key"), getText("Brief_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "GL_CODE", "TERM_IND", "TERM_DAYS", "BRIEF_DESC_ENG", "BS_CONTRA",
			"ADDITIONAL_REFERENCE", "AC_SIGN" };
		colType = new String[] { "number", "text", "number", "text", "text", "text", "text" };
		titles = new String[] { getText("Gl_Code_key"), getText("Period_key"), getText("Number_key"),
			getText("Brief_Desc_Eng_key"), getText("Bs_Contra_key"), getText("Additional_Reference_key"),
			getText("AC_Sign_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    // grid.setCaption();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/GLLookup_fillGlLookup");
	    lookup(grid, glSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of GLCodeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillGlLookup()
    {
	try
	{
	    setSearchFilter(glSC);
	    copyproperties(glSC);
	    SessionCO sessionCO = returnSessionObject();
	    glSC.setCompCode(sessionCO.getCompanyCode());
	    glSC.setBranchCode(sessionCO.getBranchCode());
	    // w_maintain_general_acc_parent rbutton down even its passing as
	    // OpenWithParm(w_lookup_gl_gen_parent,'D')
	    glSC.setCategory("D");// GA
	    if(glSC.getGMI_FLAG() != null && glSC.getGMI_FLAG().equalsIgnoreCase("F"))// FMA
	    {
		glSC.setCategory("T");
	    }
	    glSC.setAppName(sessionCO.getCurrentAppName());
	    if(checkNbRec(glSC))
	    {
		setRecords(glBO.glListCount(glSC));
	    }
	    glList = glBO.glList(glSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(glList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of GLCodeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Method for gl lookup construction Get the GL CODE list from GEN_LEDGER
     * table only the columns selected here also differ from the above query
     * dw_lookup_common_gl--
     * 
     * @return
     */
    public String constructCommonLookup()
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "GL_CODE", "ADDITIONAL_REFERENCE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "GL_TYPE",
		    "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "text", "text", "text" };
	    String[] titles = { getText("Gl_Code_key"), getText("Additional_Reference_key"),
		    getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"), getText("Gl_Type_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "GL_CODE", "ADDITIONAL_REFERENCE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "GL_TYPE" };
		colType = new String[] { "number", "text", "text", "text", "text" };
		titles = new String[] { getText("Gl_Code_key"), getText("Additional_Reference_key"),
			getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"), getText("Gl_Type_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/GLLookup_fillCommonGlLookup");
	    lookup(grid, glSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of GLCodeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Method for gl lookup construction Get the GL CODE list from GEN_LEDGER
     * table only the columns selected here also differ from the above query
     * dw_lookup_common_gl--
     * 
     * @return
     */
    public String fillCommonGlLookup()
    {
	try
	{
	    setSearchFilter(glSC);
	    copyproperties(glSC);
	    SessionCO sessionCO = returnSessionObject();
	    /**
	     * if condition added By HanaaElJazzar for Assets TrxTemplate
	     * Screen. If the company code was not sent to this method, then
	     * take it from the session..
	     */
	    if(NumberUtil.isEmptyDecimal(glSC.getCompCode()))
	    {
	    	glSC.setCompCode(sessionCO.getCompanyCode());
	    }
	    
	    //added by rany for ctrl record screen(args sent from jsp)
	    if(!"flagFromCtrlRecAcc".equals(glSC.getAllowInternAcc()) )
	    {
	    	if(!ConstantsCommon.ASSETS_PARAM_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    	{
	    		if(glSC.getContraService() == null)
			    {
				// TODO, its using B as from the Account Transfer Details Tab,
				// consider this and generalize
			    	glSC.setBsContra("B");// TODO (Call the method getBsContra()from
				// GLBO after consulting with service
				// team) This should be taken from
				// GEN_LEDGER by passing the selected gl
				// code of selected record
					glSC.setGenLedgerType("N");
			    }
			    else
			    {
					glSC.setBsContra("Z");
					glSC.setGenLedgerType("Z");
			    }
			    // glSC.setCompCode(sessionCO.getCompanyCode());//moved inside if
	    	}
	    }
	    glSC.setAppName(sessionCO.getCurrentAppName());
	    if(checkNbRec(glSC))
	    {
	    	setRecords(glBO.glListFromGLCount(glSC));
	    }
	    glList = glBO.glListFromGL(glSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(glList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillLookupData of GLCodeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Method for gl lookup construction Get the GL CODE list from GEN_LEDGER
     * table only the columns selected here also differ from the above query
     * w_lookup_gl_amf
     * 
     * @return
     */
    public String constructGlAmfLookup()
    {
	try
	{
	    String[] name = { "GL_CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "GL_CATEGORY", "GL_TYPE"};
	    String[] colType = { "number", "text", "text", "text", "text"};
	    String[] titles = { getText("Gl_Code_key"), getText("Brief_Name_key"), getText("Long_Name__key"), getText("Category_key"), getText("Gl_Type_key") };
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/GLLookup_fillGlAmfLookup");
	    lookup(grid, glSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructGlAmfLookup of GLCodeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String fillGlAmfLookup()
    {
	try
	{
	    setSearchFilter(glSC);
	    copyproperties(glSC);
	    SessionCO sessionCO = returnSessionObject();
	    glSC.setCompCode(sessionCO.getCompanyCode());

	    glSC.setBsContra("B");
	    glSC.setGenLedgerType("N");
	    glSC.setGMI_FLAG("G");

	    glSC.setAFFECT_CARD("0");
	    glSC.setAffectPassChq(null);

	    glSC.setCurrencyCode(NumberUtil.nullToZero(glSC.getCurrencyCode()));
	    glSC.setBr_code(NumberUtil.nullToZero(glSC.getBr_code()));

	    glSC.setAppName(sessionCO.getCurrentAppName());
	    if(checkNbRec(glSC))
	    {
		setRecords(glBO.glAmfListCount(glSC));
	    }
	    glList = glBO.glAmfList(glSC);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(glList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in fillGlAmfLookup of GLCodeLookupAction");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public GLSC getGlSC()
    {
	return glSC;
    }

    public void setGlSC(GLSC glSC)
    {
	this.glSC = glSC;
    }

    /**
     * @param glBO the glBO to set
     */
    public void setGlBO(GLBO glBO)
    {
	this.glBO = glBO;
    }

}
