/**
 * 
 */
package com.path.actions.common.printswift;

import java.math.BigDecimal;

import com.path.bo.common.swift.swiftoutward.SwiftOutwardNonTransBO;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.printswift.PrintSwiftCO;
import com.path.vo.common.swift.swiftoutward.SwiftCO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * PrintSwiftMainAction.java used to
 */
public class PrintSwiftMainAction extends BaseAction      
{
    private SwiftOutwardNonTransBO swiftOutwardNonTransBO;
    private PrintSwiftCO printSwiftCO = new PrintSwiftCO();
    private SwiftCO swftCO = new SwiftCO();
    
    public Object getModel()
    {
        return printSwiftCO;
    }
    
    public SwiftCO getSwftCO()
    {
        return swftCO;
    }

    public void setSwftCO(SwiftCO swftCO)
    {
        this.swftCO = swftCO;
    }

    /**
     * Load the print swift page 
     * @date   Apr 29, 2013
     * @return String
     *
     */
    public String loadPrintSwiftPage()
    {
	try
	{
	    String sTrsNo, sProgRef, sAppName, sLanguage, sUserId;
	    BigDecimal bdBranchCode;
	    
	    SessionCO sessCo = returnSessionObject();
	    
	    sTrsNo = getAuditTrxNbr();
	    //HGhazal - get parent ref - AGIB TFA issue - 26/01/2016
	    //sProgRef = get_pageRef();
	    String[] optDetails = returnCommonLibBO().returnOptDetailsList(sessCo.getCurrentAppName(), get_pageRef());
	    sProgRef = optDetails[3];
	    sAppName = sessCo.getCurrentAppName();
	    bdBranchCode = sessCo.getBranchCode();
	    sLanguage = sessCo.getLanguage();
	    sUserId = sessCo.getUserName();
	   // #558956 SBI170063 - Real Time Gross Settlement (RTGS)
	    // if H implies that print swift history button is pressed. we add HIS to the prog ref in order get 
	    // the report id of the swift history 
	    if("H".equals(printSwiftCO.getPrintSwiftHistory()))
	    {
		swftCO.setBdMsgOrder(new BigDecimal(1));
		swftCO.setBdCompCode(sessCo.getCompanyCode());
		swftCO.setBdTrsNO(new BigDecimal(printSwiftCO.getRetTrxNbr()));
		swftCO.setTrxType(printSwiftCO.getTrxType());
		swftCO.setsModule("RET");
		swftCO.setPrintSwiftHistory("H");
	    
	    }
	   
	    swftCO = swiftOutwardNonTransBO.previewSwiftMessage(sTrsNo, sProgRef, bdBranchCode, sAppName, sLanguage, sUserId, swftCO);
	    
	    String theMessage = swftCO.getSwiftMessage();
	    String theHTMLMessage = theMessage.replaceAll("\\r\\n", "<br/>");
	    theHTMLMessage = theHTMLMessage.replaceAll("\\\\r\\\\n", "<br/>");
	    printSwiftCO.setPrintSwiftMessage(theHTMLMessage);  
	}
	catch(Exception ex)
	{
	    printSwiftCO.setPrintSwiftMessage(ex.getMessage());
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    /**
     * @return the printSwiftCO
     */
    public PrintSwiftCO getPrintSwiftCO()
    {
        return printSwiftCO;
    }

    /**
     * @param printSwiftCO the printSwiftCO to set
     */
    public void setPrintSwiftCO(PrintSwiftCO printSwiftCO)
    {
        this.printSwiftCO = printSwiftCO;
    }
    /**
     * @param swiftOutwardNonTransBO the swiftOutwardNonTransBO to set
     */
    public void setSwiftOutwardNonTransBO(SwiftOutwardNonTransBO swiftOutwardNonTransBO)
    {
        this.swiftOutwardNonTransBO = swiftOutwardNonTransBO;
    }
}
