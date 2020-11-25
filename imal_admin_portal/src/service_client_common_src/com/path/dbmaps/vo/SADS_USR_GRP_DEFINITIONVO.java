package com.path.dbmaps.vo;

import java.util.Date;
import com.path.lib.vo.BaseVO;

public class SADS_USR_GRP_DEFINITIONVO extends BaseVO {
   
    private String GROUP_ID;
    private String STATUS;
    private String BRIEF_DESC_ENG;
    private String LONG_DESC_ENG;
    private String BRIEF_DESC_AR;
    private String LONG_NAME_AR;
    private String ADDITIONAL_REFERENCE;
    private String CREATED_BY;
    private Date CREATED_DATE;
    private String MODIFIED_BY;
    private Date MODIFIED_DATE;
    private String APPROVED_BY;
    private Date APPROVED_DATE;
    private String REJECTED_BY;
    private Date REJECTED_DATE;
    private String DELETED_BY;
    private Date DELETED_DATE;
	
	public String getGROUP_ID()
	{
		return GROUP_ID;
	}
	
	public void setGROUP_ID(String gROUP_ID)
	{
		GROUP_ID = gROUP_ID;
	}
	
	public String getSTATUS()
	{
		return STATUS;
	}
	
	public void setSTATUS(String sTATUS)
	{
		STATUS = sTATUS;
	}
	
	public String getBRIEF_DESC_ENG()
	{
		return BRIEF_DESC_ENG;
	}
	
	public void setBRIEF_DESC_ENG(String bRIEF_DESC_ENG)
	{
		BRIEF_DESC_ENG = bRIEF_DESC_ENG;
	}
	
	public String getLONG_DESC_ENG()
	{
		return LONG_DESC_ENG;
	}
	
	public void setLONG_DESC_ENG(String lONG_DESC_ENG)
	{
		LONG_DESC_ENG = lONG_DESC_ENG;
	}
	
	public String getBRIEF_DESC_AR()
	{
		return BRIEF_DESC_AR;
	}
	
	public void setBRIEF_DESC_AR(String bRIEF_DESC_AR)
	{
		BRIEF_DESC_AR = bRIEF_DESC_AR;
	}
	
	public String getLONG_NAME_AR()
	{
		return LONG_NAME_AR;
	}
	
	public void setLONG_NAME_AR(String lONG_NAME_AR)
	{
		LONG_NAME_AR = lONG_NAME_AR;
	}
	
	public String getADDITIONAL_REFERENCE()
	{
		return ADDITIONAL_REFERENCE;
	}
	
	public void setADDITIONAL_REFERENCE(String aDDITIONAL_REFERENCE)
	{
		ADDITIONAL_REFERENCE = aDDITIONAL_REFERENCE;
	}
	
	public String getCREATED_BY()
	{
		return CREATED_BY;
	}
	
	public void setCREATED_BY(String cREATED_BY)
	{
		CREATED_BY = cREATED_BY;
	}
	
	public Date getCREATED_DATE()
	{
		return CREATED_DATE;
	}
	
	public void setCREATED_DATE(Date cREATED_DATE)
	{
		CREATED_DATE = cREATED_DATE;
	}
	
	public String getMODIFIED_BY()
	{
		return MODIFIED_BY;
	}
	
	public void setMODIFIED_BY(String mODIFIED_BY)
	{
		MODIFIED_BY = mODIFIED_BY;
	}
	
	public Date getMODIFIED_DATE()
	{
		return MODIFIED_DATE;
	}
	
	public void setMODIFIED_DATE(Date mODIFIED_DATE)
	{
		MODIFIED_DATE = mODIFIED_DATE;
	}
	
	public String getAPPROVED_BY()
	{
		return APPROVED_BY;
	}
	
	public void setAPPROVED_BY(String aPPROVED_BY)
	{
		APPROVED_BY = aPPROVED_BY;
	}
	
	public Date getAPPROVED_DATE()
	{
		return APPROVED_DATE;
	}
	
	public void setAPPROVED_DATE(Date aPPROVED_DATE)
	{
		APPROVED_DATE = aPPROVED_DATE;
	}
	
	public String getREJECTED_BY()
	{
		return REJECTED_BY;
	}
	
	public void setREJECTED_BY(String rEJECTED_BY)
	{
		REJECTED_BY = rEJECTED_BY;
	}
	
	public Date getREJECTED_DATE()
	{
		return REJECTED_DATE;
	}
	
	public void setREJECTED_DATE(Date rEJECTED_DATE)
	{
		REJECTED_DATE = rEJECTED_DATE;
	}

	
	public String getDELETED_BY()
	{
		return DELETED_BY;
	}

	
	public void setDELETED_BY(String dELETED_BY)
	{
		DELETED_BY = dELETED_BY;
	}

	
	public Date getDELETED_DATE()
	{
		return DELETED_DATE;
	}

	
	public void setDELETED_DATE(Date dELETED_DATE)
	{
		DELETED_DATE = dELETED_DATE;
	}


   
}