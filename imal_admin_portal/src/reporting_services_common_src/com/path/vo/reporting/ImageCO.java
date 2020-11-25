package com.path.vo.reporting;

import com.path.lib.vo.BaseVO;

public class ImageCO extends BaseVO
{
	private String fileName;
	private String id;
	private String imgName;
	private String imgLocation;
	private String mappedImgName;
	private String errorStatus;
	private String imgPathType;
	private String imgDynamicLocation;
	
	
	public String getErrorStatus()
	{
	    return errorStatus;
	}
	public void setErrorStatus(String errorStatus)
	{
	    this.errorStatus = errorStatus;
	}
	public String getMappedImgName()
	{
	    return mappedImgName;
	}
	public void setMappedImgName(String mappedImgName)
	{
	    this.mappedImgName = mappedImgName;
	}
	public String getImgLocation()
	{
	    return imgLocation;
	}
	public void setImgLocation(String imgLocation)
	{
	    this.imgLocation = imgLocation;
	}
	public String getImgName()
	{
	    return imgName;
	}
	public void setImgName(String imgName)
	{
	    this.imgName = imgName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImgPathType()
	{
	    return imgPathType;
	}
	public void setImgPathType(String imgPathType)
	{
	    this.imgPathType = imgPathType;
	}
	public String getImgDynamicLocation()
	{
	    return imgDynamicLocation;
	}
	public void setImgDynamicLocation(String imgDynamicLocation)
	{
	    this.imgDynamicLocation = imgDynamicLocation;
	}
	
}
