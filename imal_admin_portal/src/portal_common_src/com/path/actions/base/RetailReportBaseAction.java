package com.path.actions.base;

import java.util.HashMap;
import java.util.List;

import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.select.SelectCO;

public class RetailReportBaseAction extends BaseAction
{
    // to hold the screen type( specially if we have common screens)
    protected String _type = "";
    // redirect to json
    public String LOADJSON = "loadJson";

    protected HashMap<String, String> gregoHijriDateList = new HashMap<String, String>(),
	    languageList = new HashMap<String, String>(), yesNoRadioList = new HashMap<String, String>();
    protected List<SelectCO> stmtPeriodicityList;

    public List<SelectCO> getStmtPeriodicityList()
    {
	return stmtPeriodicityList;
    }

    public void setStmtPeriodicityList(List<SelectCO> stmtPeriodicityList)
    {
	this.stmtPeriodicityList = stmtPeriodicityList;
    }

    public HashMap<String, String> getGregoHijriDateList()
    {
	return gregoHijriDateList;
    }

    public void setGregoHijriDateList(HashMap<String, String> gregoHijriDateList)
    {
	this.gregoHijriDateList = gregoHijriDateList;
    }

    public String get_type()
    {
	return _type;
    }

    public void set_type(String type)
    {
	_type = type;
    }

    public HashMap<String, String> getLanguageList()
    {
	return languageList;
    }

    public void setLanguageList(HashMap<String, String> languageList)
    {
	this.languageList = languageList;
    }

    public HashMap<String, String> getYesNoRadioList()
    {
	return yesNoRadioList;
    }

    public void setYesNoRadioList(HashMap<String, String> yesNoRadioList)
    {
	this.yesNoRadioList = yesNoRadioList;
    }

}
