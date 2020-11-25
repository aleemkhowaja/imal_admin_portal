package com.path.dbmaps.vo;

import com.path.lib.vo.BaseVO;

public class SADS_USR_GRP_DETAILSVO  extends BaseVO  {
   
   private String GROUP_ID;
   private String USER_ID;
   private String STATUS;

	public String getGROUP_ID()
	{
		return GROUP_ID;
	}
	
	public void setGROUP_ID(String gROUP_ID)
	{
		GROUP_ID = gROUP_ID;
	}
	
	public String getUSER_ID()
	{
		return USER_ID;
	}
	
	public void setUSER_ID(String uSER_ID)
	{
		USER_ID = uSER_ID;
	}
	
	public String getSTATUS()
	{
		return STATUS;
	}
	
	public void setSTATUS(String sTATUS)
	{
		STATUS = sTATUS;
	}
}