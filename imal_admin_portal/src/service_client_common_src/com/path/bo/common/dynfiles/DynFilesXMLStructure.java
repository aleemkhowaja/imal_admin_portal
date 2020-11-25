package com.path.bo.common.dynfiles;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.path.lib.vo.BaseVO;
import com.path.vo.common.dynfiles.DynFilesTagsCO;

public class DynFilesXMLStructure extends BaseVO 
{
	private BigDecimal tagNo;
	private DynFilesTagsCO dynFilesTagsCO;
	private ArrayList<DynFilesXMLStructure> dynFilesXMLStructure;
	
	public BigDecimal getTagNo() 
	{
		return tagNo;
	}
	public void setTagNo(BigDecimal tagNo) 
	{
		this.tagNo = tagNo;
	}
	public DynFilesTagsCO getDynFilesTagsCO() 
	{
		return dynFilesTagsCO;
	}
	public void setDynFilesTagsCO(DynFilesTagsCO dynFilesTagsCO) 
	{
		this.dynFilesTagsCO = dynFilesTagsCO;
	}
	public ArrayList<DynFilesXMLStructure> getDynFilesXMLStructure() 
	{
		return dynFilesXMLStructure;
	}
	public void setDynFilesXMLStructure(ArrayList<DynFilesXMLStructure> dynFilesXMLStructure) 
	{
		this.dynFilesXMLStructure = dynFilesXMLStructure;
	}
}
