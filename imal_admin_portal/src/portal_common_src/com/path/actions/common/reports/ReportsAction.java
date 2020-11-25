package com.path.actions.common.reports;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;

public class ReportsAction extends BaseAction 
{
    private String c_c; // companyCode
    private String c_d; // companyName
    private String c_a_d; // companyArabName
    private String b_c; // branchCode
    private String u_i; // userName
    private String l; // language (EN, AR, FR, TK, RU, FA) getLanguage
    private String r_d;// runningDateRET
    private String b_c_c;// baseCurrencyCode
    private String b_c_d;// baseCurrDecPoint
    private String r_r; // OPT
    private String c_t; // clientType
    private String f_y; // fiscalYear
    private String b_c_n; // baseCurrencyName
    private String e_c_c; // exposureCurrCode
    private String e_c_n; // exposCurName
    private String a; // currentAppName
    private String d_p; // 1 if Parameter Window need to be shown zero otherwise
    private String a_p; // whether to AutoPrint the report or not (d_p should be
    private String r_i; // Report ID
    private String r_a_p; // Addition parameters used in advices
    private String htmlPageRef; // page reference (- replaced by _)
    private String use_r_r;// added to not override the r_r with the page_ref

    private String url;

    private InputStream isFile;
    private String filename;

    public String getUse_r_r() {
		return use_r_r;
	}

	public void setUse_r_r(String use_r_r) {
		this.use_r_r = use_r_r;
	}
	
    public String getC_c()
    {
	return c_c;
    }

    public void setC_c(String cC)
    {
	c_c = cC;
    }

    public String getC_d()
    {
	return c_d;
    }

    public void setC_d(String cD)
    {
	c_d = cD;
    }

    public String getC_a_d()
    {
	return c_a_d;
    }

    public void setC_a_d(String cAD)
    {
	c_a_d = cAD;
    }

    public String getB_c()
    {
	return b_c;
    }

    public void setB_c(String bC)
    {
	b_c = bC;
    }

    public String getU_i()
    {
	return u_i;
    }

    public void setU_i(String uI)
    {
	u_i = uI;
    }

    public String getL()
    {
	return l;
    }

    public void setL(String l)
    {
	this.l = l;
    }

    public String getR_d()
    {
	return r_d;
    }

    public void setR_d(String rD)
    {
	r_d = rD;
    }

    public String getB_c_c()
    {
	return b_c_c;
    }

    public void setB_c_c(String bCC)
    {
	b_c_c = bCC;
    }

    public String getB_c_d()
    {
	return b_c_d;
    }

    public void setB_c_d(String bCD)
    {
	b_c_d = bCD;
    }

    public String getR_r()
    {
	return r_r;
    }

    public void setR_r(String rR)
    {
	r_r = rR;
    }

    public String getC_t()
    {
	return c_t;
    }

    public void setC_t(String cT)
    {
	c_t = cT;
    }

    public String getF_y()
    {
	return f_y;
    }

    public void setF_y(String fY)
    {
	f_y = fY;
    }

    public String getB_c_n()
    {
	return b_c_n;
    }

    public void setB_c_n(String bCN)
    {
	b_c_n = bCN;
    }

    public String getE_c_c()
    {
	return e_c_c;
    }

    public void setE_c_c(String eCC)
    {
	e_c_c = eCC;
    }

    public String getE_c_n()
    {
	return e_c_n;
    }

    public void setE_c_n(String eCN)
    {
	e_c_n = eCN;
    }

    public String getA()
    {
	return a;
    }

    public void setA(String a)
    {
	this.a = a;
    }

    public String getD_p()
    {
	return d_p;
    }

    public void setD_p(String dP)
    {
	d_p = dP;
    }

    public String getA_p()
    {
	return a_p;
    }

    public void setA_p(String aP)
    {
	a_p = aP;
    }

    public String callReports()
    {
	String result = SUCCESS;
	try
	{
	SessionCO sessionCO = returnSessionObject();
	c_c = sessionCO.getCompanyCode().toString();
	c_d = sessionCO.getCompanyName();
	c_a_d = sessionCO.getCompanyArabName();
	b_c = sessionCO.getBranchCode().toString();
	u_i = sessionCO.getUserName();
	l = sessionCO.getLanguage();
	r_d = DateUtil.format(sessionCO.getRunningDateRET(), "dd/MM/yyyy");
	String coreImalYn=returnCommonLibBO().returnPthCtrl1().getCORE_IMAL_YN();
	if(ConstantsCommon.YES.equals(coreImalYn) && !ConstantsCommon.SADS_APP_NAME.equals(sessionCO.getCurrentAppName()) && !ConstantsCommon.UPG_APP_NAME.equals(sessionCO.getCurrentAppName()))
	{
	    if(sessionCO.getBaseCurrencyCode() == null)
	    {
	    	throw new BOException(MessageCodes.PARAM1_IS_MISSING_INVALID, new String[]{"Base_Currency_key"});
	    }
	    b_c_c = sessionCO.getBaseCurrencyCode().toString();
	    b_c_d = sessionCO.getBaseCurrDecPoint().toString();
	    //in case of IBIS application , the exposCurCode will be null in the session
	    BigDecimal exposCurCode=sessionCO.getExposCurCode();
	    if(exposCurCode!=null)
	    {
		e_c_c = exposCurCode.toString();
	    }
	}
	//annasuccar- 20/08/2014: r_r is sent in the url
	if(use_r_r==null)
	{
		r_r = get_pageRef();
	}
	c_t = sessionCO.getClientType();
	f_y = sessionCO.getFiscalYear() == null? null:sessionCO.getFiscalYear().toString();
	b_c_n = sessionCO.getBaseCurrencyName();
	e_c_n = sessionCO.getExposCurName();
	if(a==null)
	{
	    a = sessionCO.getCurrentAppName();
	}
	d_p = "1";
	a_p = "0";
	if(StringUtil.nullToEmpty(get_pageRef()).isEmpty())
	{
	    htmlPageRef = String.valueOf(Calendar.getInstance().getTimeInMillis());
	}
	else
	{
	    htmlPageRef = get_pageRef().replace("-", "_");
	}
	set_showSmartInfoBtn("false"); 
	
	    String hasVerifyAccess = returnAccessRightByProgRef(ConstantsCommon.OPT_VERIFY_BTN);
	    if(hasVerifyAccess == null)
	    {
		showHideBtn("0", "verifyBtn_");
	    }
	    else
	    {
		showHideBtn("1", "verifyBtn_");
	    }
	}
	catch(Exception e)
	{
	    result = ERROR;
	    handleException(e, null, null);
	}
	return result;
    }


    /**
     * Method that shows and hides buttons from the retrieval screen
     * @return
     * @throws BaseException
     */
    public void showHideBtn(String visibleVal, String elemId)
    {
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> button = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
	try
	{
	    button = returnCommonLibBO().applyDynScreenDisplay(elemId + htmlPageRef, null,
		    ConstantsCommon.ACTION_TYPE_VISIBLE, visibleVal, button, null);
	    getAdditionalScreenParams().putAll(button);
	}
	catch(BaseException e)
	{
	    log.error(e, e.getMessage());
	}
    }
    public String getUrl()
    {
	return url;
    }

    public void setUrl(String url)
    {
	this.url = url;
    }

    public InputStream getIsFile()
    {
	return isFile;
    }

    public void setIsFile(InputStream isFile)
    {
	this.isFile = isFile;
    }

    public String getFilename()
    {
	return filename;
    }

    public void setFilename(String filename)
    {
	this.filename = filename;
    }

    public String getR_i()
    {
	return r_i;
    }

    public void setR_i(String rI)
    {
	r_i = rI;
    }

    public String getR_a_p()
    {
        return r_a_p;
    }

    public void setR_a_p(String rAP)
    {
        r_a_p = rAP;
    }

    public String getHtmlPageRef()
    {
        return htmlPageRef;
    }

    public void setHtmlPageRef(String htmlPageRef)
    {
        this.htmlPageRef = htmlPageRef;
    }
}
