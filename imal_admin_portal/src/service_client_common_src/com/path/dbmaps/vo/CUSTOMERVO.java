package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;

public class CUSTOMERVO extends BaseVO
{
	private String CUST_ID;
	private String FIRST_NAME;
	private String MARITAL_STATUS;
	private String DATE_BIRTH;
	private String GENDER;
	private String ADDRESS;

	public String getCUST_ID()
	{
		return CUST_ID;
	}

	public void setCUST_ID(String cUSTID)
	{
		CUST_ID = cUSTID;
	}

	public String getFIRST_NAME()
	{
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRSTNAME)
	{
		FIRST_NAME = fIRSTNAME;
	}

	public String getGENDER()
	{
		return GENDER;
	}

	public void setGENDER(String gENDER)
	{
		GENDER = gENDER;
	}

	public String getDATE_BIRTH()
	{
		return DATE_BIRTH;
	}

	public void setDATE_BIRTH(String dATEBIRTH)
	{
		DATE_BIRTH = dATEBIRTH;
	}

	public String getMARITAL_STATUS()
	{
		return MARITAL_STATUS;
	}

	public void setMARITAL_STATUS(String mARITALSTATUS)
	{
		MARITAL_STATUS = mARITALSTATUS;
	}

	public String getADDRESS()
	{
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS)
	{
		ADDRESS = aDDRESS;
	}
}
