package com.path.vo.admin.genledger;

import com.path.dbmaps.vo.GEN_LEDGERVO;
import com.path.vo.core.common.RetailBaseVO;


/**
 * 
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: WissamChebli
 *
 * CIFCO.java used to
 */

public class GenLedgerCO extends RetailBaseVO{
   
    private GEN_LEDGERVO genledgerVO = new GEN_LEDGERVO();
    
    private int returnVal;
    private int messageId;
    private String balanceSheet;
    private String genLedgerType;
    private String briefDesc;
    

    /**
     * @return the returnVal
     */
    public int getReturnVal()
    {
        return returnVal;
    }
    /**
     * @param returnVal the returnVal to set
     */
    public void setReturnVal(int returnVal)
    {
        this.returnVal = returnVal;
    }
    /**
     * @return the genledgerVO
     */
    public GEN_LEDGERVO getGenledgerVO()
    {
        return genledgerVO;
    }
    /**
     * @param genledgerVO the genledgerVO to set
     */
    public void setGenledgerVO(GEN_LEDGERVO genledgerVO)
    {
        this.genledgerVO = genledgerVO;
    }
    /**
     * @return the messageId
     */
    public int getMessageId()
    {
        return messageId;
    }
    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(int messageId)
    {
        this.messageId = messageId;
    }
    /**
     * @return the balanceSheet
     */
    public String getBalanceSheet()
    {
        return balanceSheet;
    }
    /**
     * @param balanceSheet the balanceSheet to set
     */
    public void setBalanceSheet(String balanceSheet)
    {
        this.balanceSheet = balanceSheet;
    }
    /**
     * @return the genLedgerType
     */
    public String getGenLedgerType()
    {
        return genLedgerType;
    }
    /**
     * @param genLedgerType the genLedgerType to set
     */
    public void setGenLedgerType(String genLedgerType)
    {
        this.genLedgerType = genLedgerType;
    }
    /**
     * @return the briefDesc
     */
    public String getBriefDesc()
    {
        return briefDesc;
    }
    /**
     * @param briefDesc the briefDesc to set
     */
    public void setBriefDesc(String briefDesc)
    {
        this.briefDesc = briefDesc;
    }
    

}