package com.path.vo.reporting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.IRP_SUB_REPORTVO;
import com.path.lib.vo.BaseVO;

public class IRP_SUB_REPORTCO extends BaseVO
{
    

    private IRP_SUB_REPORTVO irpSubReportVO= new IRP_SUB_REPORTVO();
    private String SUB_REPORT_NAME;
    private String PARENT_REP_NAME;
    private BigDecimal PARENT_REPORT_ID;
    private BigDecimal DOWNLOADABLE_FLAG;
    //private IRP_REP_ARGUMENTSCO irpRepArgumentsCO = new IRP_REP_ARGUMENTSCO();//mapping to parent rep
    private List<IRP_REP_ARGUMENTSCO> subRepArgsList=new ArrayList <IRP_REP_ARGUMENTSCO>();//to store the 
    //mapping of the hyperlink parameters 
    private int subRepWidth ;
    private int subRepHeight ;
//    private HashMap<BigDecimal, List <IRP_SUB_REPORTCO>> subRepMap = new HashMap<BigDecimal, List<IRP_SUB_REPORTCO>>();  
    
    private  List <IRP_SUB_REPORTCO> subRepList= new  ArrayList<IRP_SUB_REPORTCO>();
    
    private byte[] JRXML_FILE;
    private String PROG_REF;
    private String APP_NAME;
    private String REPORT_VERSION;
    private Date   VERSION_DATE; 
//    public IRP_REP_ARGUMENTSCO getIrpRepArgumentsCO()
//    {
//        return irpRepArgumentsCO;
//    }
//    public void setIrpRepArgumentsCO(IRP_REP_ARGUMENTSCO irpRepArgumentsCO)
//    {
//        this.irpRepArgumentsCO = irpRepArgumentsCO;
//    }
    
    public Date getVERSION_DATE()
    {
        return VERSION_DATE;
    }
    public void setVERSION_DATE(Date vERSIONDATE)
    {
        VERSION_DATE = vERSIONDATE;
    }
    
    private ArrayList<BigDecimal> REPORTS_ID;
    
    
    

   
    public String getREPORT_VERSION()
    {
        return REPORT_VERSION;
    }
    public void setREPORT_VERSION(String rEPORTVERSION)
    {
        REPORT_VERSION = rEPORTVERSION;
    }
 
    
    public ArrayList<BigDecimal> getREPORTS_ID()
    {
        return REPORTS_ID;
    }
    public void setREPORTS_ID(ArrayList<BigDecimal> rEPORTSID)
    {
        REPORTS_ID = rEPORTSID;
    }
    public List<IRP_SUB_REPORTCO> getSubRepList()
    {
        return subRepList;
    }
    public String getPROG_REF()
    {
        return PROG_REF;
    }
    public void setPROG_REF(String pROGREF)
    {
        PROG_REF = pROGREF;
    }
    public String getAPP_NAME()
    {
        return APP_NAME;
    }
    public void setAPP_NAME(String aPPNAME)
    {
        APP_NAME = aPPNAME;
    }
    public byte[] getJRXML_FILE()
    {
        return JRXML_FILE;
    }
    public void setJRXML_FILE(byte[] jRXMLFILE)
    {
        JRXML_FILE = jRXMLFILE;
    }
    public BigDecimal getDOWNLOADABLE_FLAG()
    {
        return DOWNLOADABLE_FLAG;
    }
    public void setDOWNLOADABLE_FLAG(BigDecimal dOWNLOADABLEFLAG)
    {
        DOWNLOADABLE_FLAG = dOWNLOADABLEFLAG;
    }
    public void setSubRepList(List<IRP_SUB_REPORTCO> subRepList)
    {
        this.subRepList = subRepList;
    }
    public IRP_SUB_REPORTVO getIrpSubReportVO()
    {
        return irpSubReportVO;
    }
//    public HashMap<BigDecimal, List<IRP_SUB_REPORTCO>> getSubRepMap()
//    {
//        return subRepMap;
//    }
//    public void setSubRepMap(HashMap<BigDecimal, List<IRP_SUB_REPORTCO>> subRepMap)
//    {
//        this.subRepMap = subRepMap;
//    }
    public List<IRP_REP_ARGUMENTSCO> getSubRepArgsList()
    {
        return subRepArgsList;
    }
    public void setSubRepArgsList(List<IRP_REP_ARGUMENTSCO> subRepArgsList)
    {
        this.subRepArgsList = subRepArgsList;
    }
    public void setIrpSubReportVO(IRP_SUB_REPORTVO irpSubReportVO)
    {
        this.irpSubReportVO = irpSubReportVO;
    }
    public String getSUB_REPORT_NAME()
    {
        return SUB_REPORT_NAME;
    }
    public void setSUB_REPORT_NAME(String sUBREPORTNAME)
    {
        SUB_REPORT_NAME = sUBREPORTNAME;
    }
    public String getPARENT_REP_NAME()
    {
        return PARENT_REP_NAME;
    }
    public void setPARENT_REP_NAME(String pARENTREPNAME)
    {
        PARENT_REP_NAME = pARENTREPNAME;
    }
    public BigDecimal getPARENT_REPORT_ID()
    {
        return PARENT_REPORT_ID;
    }
    public void setPARENT_REPORT_ID(BigDecimal pARENTREPORTID)
    {
        PARENT_REPORT_ID = pARENTREPORTID;
    }
    public int getSubRepWidth()
    {
        return subRepWidth;
    }
    public void setSubRepWidth(int subRepWidth)
    {
        this.subRepWidth = subRepWidth;
    }
    public int getSubRepHeight()
    {
        return subRepHeight;
    }
    public void setSubRepHeight(int subRepHeight)
    {
        this.subRepHeight = subRepHeight;
    }
    
}
