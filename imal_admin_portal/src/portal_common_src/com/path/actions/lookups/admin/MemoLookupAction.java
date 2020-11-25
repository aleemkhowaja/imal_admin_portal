package com.path.actions.lookups.admin;

import java.util.ArrayList;

import com.path.bo.common.memo.MemoBO;
import com.path.bo.common.memo.MemoConstants;
import com.path.dbmaps.vo.CTSMEMOVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.memo.MemoSC;

public class MemoLookupAction extends LookupBaseAction
{
    private MemoSC memoSC = new MemoSC();
    private MemoBO memoBO;

    public String memoLookupDef()
    {

	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "TYPE", "EXP_REVIEW", "NUMBER_REVIEWS",
		    "DATE_INTERVAL", "ACC_SPECIFIC", "CIF_SPECIFIC", "SEGMENT_SPECIFIC_YN", "BRIEF_DESC_ARAB", "LONG_DESC_ARAB" };
	    String[] colType = { "number", "text", "text", "text", "number", "number", "text", "text", "text", "text", "text",
		    "text" };
	    String[] titles = { getText("Memo_Code_key"), getText("Brief_Desc_Eng_key"), getText("Long_Desc_Eng_key"),
		    getText("Type_key"), getText("Exp_Review_key"), getText("Number_Reviews_key"),
		    getText("Date_Interval_key"), getText("Acc_Specific_key"), getText("Cif_Specific_key"), getText("segment_specific_key"),
		    getText("Brief_Desc_Arab_key"), getText("Long_Desc_Arab_key") };

	    /*
	     * PTH_CTRL.LANGUAGE (0,Null= Arabic Visible Not Mandatory But
	     * English Mandatory, 1=Arabic Hidden and English Mandatory, 2=
	     * Arabic Visible and Mandatory And English Mandatory , 3= Arabic
	     * Visible and Mandatory English Not Mandatory).
	     */
	    if(returnSessionObject().getHideArabicColumns())
	    {
		name = new String[] { "CODE", "BRIEF_DESC_ENG", "LONG_DESC_ENG", "TYPE", "EXP_REVIEW",
			"NUMBER_REVIEWS", "DATE_INTERVAL", "ACC_SPECIFIC", "CIF_SPECIFIC", "SEGMENT_SPECIFIC_YN" };
		colType = new String[] { "number", "text", "text", "text", "number", "number", "text", "text", "text" };
		titles = new String[] { getText("Memo_Code_key"), getText("Brief_Desc_Eng_key"),
			getText("Long_Desc_Eng_key"), getText("Type_key"), getText("Exp_Review_key"),
			getText("Number_Reviews_key"), getText("Date_Interval_key"), getText("Acc_Specific_key"),
			getText("Cif_Specific_key"), getText("segment_specific_key") };
	    }

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("branches.branchList"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/MemoLookup_loadMemoLookup");
	    lookup(grid, memoSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of MemoLookupAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    /**
     * Fill the lookup branch data filtered by user.
     * 
     * @return
     */
    public String loadMemoLookup()
    {
	try
	{
	    setSearchFilter(memoSC);
	    // Get the data from BO
	    copyproperties(memoSC);
	    SessionCO sessionCO = returnSessionObject();
	    memoSC.setCompCode(sessionCO.getCompanyCode());
	    memoSC.setLangCode(sessionCO.getLanguage());
	    memoSC.setType(MemoConstants.MEMO_TYPE_NR);

	    if(getRecords() == 0)
	    {
		setRecords(memoBO.getCtsMemoCount(memoSC));
	    }

	    ArrayList<CTSMEMOVO> ctsMemoList = memoBO.getCtsMemoList(memoSC);

	    setGridModel(ctsMemoList);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in loading Memo lookup");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public MemoSC getMemoSC()
    {
	return memoSC;
    }

    public void setMemoSC(MemoSC memoSC)
    {
	this.memoSC = memoSC;
    }

    public MemoBO returnMemoBO()
    {
	return memoBO;
    }

    public void setMemoBO(MemoBO memoBO)
    {
	this.memoBO = memoBO;
    }

    @Override
    public Object getModel()
    {
	return memoSC;
    }

}
