/**
 * 
 */
package com.path.vo.common.printswift;

import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * PrintSwiftCO.java used to
 */
public class PrintSwiftCO extends RetailBaseVO
{
    private String printSwiftMessage;
    private String trxNbr;
    private String printSwiftHistory;
    private String trxType;
    private String retTrxNbr;

    /**
     * @return the printSwiftMessage
     */
    public String getPrintSwiftMessage()
    {
        return printSwiftMessage;
    }
    
    /**
     * @param printSwiftMessage the printSwiftMessage to set
     */
    public void setPrintSwiftMessage(String printSwiftMessage)
    {
        this.printSwiftMessage = printSwiftMessage;
    }

    /**
     * @return the trxNbr
     */
    public String getTrxNbr()
    {
        return trxNbr;
    }

    /**
     * @param trxNbr the trxNbr to set
     */
    public void setTrxNbr(String trxNbr)
    {
        this.trxNbr = trxNbr;
    }

    public String getPrintSwiftHistory()
    {
        return printSwiftHistory;
    }

    public void setPrintSwiftHistory(String printSwiftHistory)
    {
        this.printSwiftHistory = printSwiftHistory;
    }

    public String getTrxType()
    {
        return trxType;
    }

    public void setTrxType(String trxType)
    {
        this.trxType = trxType;
    }

    public String getRetTrxNbr()
    {
        return retTrxNbr;
    }

    public void setRetTrxNbr(String retTrxNbr)
    {
        this.retTrxNbr = retTrxNbr;
    }
    
}
