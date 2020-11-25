/**
 * 
 */
package com.path.vo.common.smart;

import java.io.File;
import java.math.BigDecimal;

import com.path.dbmaps.vo.S_ADDITIONS_DETAILSVO;
import com.path.dbmaps.vo.S_ADDITIONS_OPTIONSVO;
import com.path.dbmaps.vo.S_ADDITIONS_TYPEVO;
import com.path.lib.vo.BaseVO;

/**
 * @author raees
 *
 */
public class SmartCO extends BaseVO
{
	//Classes are declared as public since the freemarker template (ftl)
	//cannot read the objects' properties declared as private.
	public S_ADDITIONS_TYPEVO sAdditionsTypeVO  = new S_ADDITIONS_TYPEVO();
	public S_ADDITIONS_DETAILSVO sAdditionsDetailsVO = new S_ADDITIONS_DETAILSVO();
	public S_ADDITIONS_OPTIONSVO sAdditionsOptionsVO  =  new S_ADDITIONS_OPTIONSVO();
	public SmartTypesVO smartTypesVO = new SmartTypesVO();
	
	//#BUG 506707 variables names are not compatible with ftl invocation standard.
	public String soptionDesc;
	private String saddOptionsBriefNameArab;
	private String saddOptionsBriefNameEng;
	private String ssmartMandatory;
	private String senableSmartFunc;
	
	private File externalFile;
	private String externalFileContentType;
	private String externalFileFileName;
	private byte[] smartFileBytes;
	private String smartFileEncodedBytes;
	private String smartFileEncodedFileName;
		
	// ENH 519846 variables needed to receive the file StorageMedia.
	private String fileStorageMedia;
	
	//759740 return company and branch code of the BLOB to the webservice request
	private BigDecimal smartObjCompany;
	private BigDecimal smartObjBranch;
	
	
	/**
	 * @return the sAdditionsTypeVO
	 */
	public S_ADDITIONS_TYPEVO getSAdditionsTypeVO()
	{
		return sAdditionsTypeVO;
	}
	/**
	 * @param sAdditionsTypeVO the sAdditionsTypeVO to set
	 */
	public void setSAdditionsTypeVO(S_ADDITIONS_TYPEVO sAdditionsTypeVO)
	{
		this.sAdditionsTypeVO = sAdditionsTypeVO;
	}
	/**
	 * @return the sAdditionsDetailsVO
	 */
	public S_ADDITIONS_DETAILSVO getSAdditionsDetailsVO()
	{
		return sAdditionsDetailsVO;
	}
	/**
	 * @param SAdditionsDetailsVO the SAdditionsDetailsVO to set
	 */
	public void setSAdditionsDetailsVO(S_ADDITIONS_DETAILSVO sAdditionsDetailsVO)
	{
		this.sAdditionsDetailsVO = sAdditionsDetailsVO;
	}
	/**
	 * @return the sAdditionsOptionsVO
	 */
	public S_ADDITIONS_OPTIONSVO getSAdditionsOptionsVO()
	{
		return sAdditionsOptionsVO;
	}
	/**
	 * @param sAdditionsOptionsVO the sAdditionsOptionsVO to set
	 */
	public void setSAdditionsOptionsVO(S_ADDITIONS_OPTIONSVO sAdditionsOptionsVO)
	{
		this.sAdditionsOptionsVO = sAdditionsOptionsVO;
	}

	public void setSmartTypesVO(SmartTypesVO smartTypesVO)
	{
	    this.smartTypesVO = smartTypesVO;
	}
	public SmartTypesVO getSmartTypesVO()
	{
	    return smartTypesVO;
	}
	/**
	 * @return the externalFile
	 */
	public File getExternalFile()
	{
	    return externalFile;
	}
	/**
	 * @param externalFile the externalFile to set
	 */
	public void setExternalFile(File externalFile)
	{
	    this.externalFile = externalFile;
	}
	/**
	 * @return the externalFileContentType
	 */
	public String getExternalFileContentType()
	{
	    return externalFileContentType;
	}
	/**
	 * @param externalFileContentType the externalFileContentType to set
	 */
	public void setExternalFileContentType(String externalFileContentType)
	{
	    this.externalFileContentType = externalFileContentType;
	}
	/**
	 * @return the externalFileFileName
	 */
	public String getExternalFileFileName()
	{
	    return externalFileFileName;
	}
	/**
	 * @param externalFileFileName the externalFileFileName to set
	 */
	public void setExternalFileFileName(String externalFileFileName)
	{
	    this.externalFileFileName = externalFileFileName;
	}
	public byte[] getSmartFileBytes()
	{
	    return smartFileBytes;
	}
	public void setSmartFileBytes(byte[] smartFileBytes)
	{
	    this.smartFileBytes = smartFileBytes;
	}
	public String getSoptionDesc()
	{
	    return soptionDesc;
	}
	public void setSoptionDesc(String soptionDesc)
	{
	    this.soptionDesc = soptionDesc;
	}
	public String getSaddOptionsBriefNameArab()
	{
	    return saddOptionsBriefNameArab;
	}
	public void setSaddOptionsBriefNameArab(String saddOptionsBriefNameArab)
	{
	    this.saddOptionsBriefNameArab = saddOptionsBriefNameArab;
	}
	public String getSaddOptionsBriefNameEng()
	{
	    return saddOptionsBriefNameEng;
	}
	public void setSaddOptionsBriefNameEng(String saddOptionsBriefNameEng)
	{
	    this.saddOptionsBriefNameEng = saddOptionsBriefNameEng;
	}
	public String getSsmartMandatory()
	{
	    return ssmartMandatory;
	}
	public void setSsmartMandatory(String ssmartMandatory)
	{
	    this.ssmartMandatory = ssmartMandatory;
	}
	public String getSenableSmartFunc()
	{
	    return senableSmartFunc;
	}
	public void setSenableSmartFunc(String senableSmartFunc)
	{
	    this.senableSmartFunc = senableSmartFunc;
	}
	public String getSmartFileEncodedBytes()
	{
	    return smartFileEncodedBytes;
	}
	public void setSmartFileEncodedBytes(String smartFileEncodedBytes)
	{
	    this.smartFileEncodedBytes = smartFileEncodedBytes;
	}
	public String getSmartFileEncodedFileName()
	{
	    return smartFileEncodedFileName;
	}
	public void setSmartFileEncodedFileName(String smartFileEncodedFileName)
	{
	    this.smartFileEncodedFileName = smartFileEncodedFileName;
	}
	public String getFileStorageMedia()
	{
	    return fileStorageMedia;
	}
	public void setFileStorageMedia(String fileStorageMedia)
	{
	    this.fileStorageMedia = fileStorageMedia;
	}
	public BigDecimal getSmartObjCompany()
	{
	    return smartObjCompany;
	}
	public void setSmartObjCompany(BigDecimal smartObjCompany)
	{
	    this.smartObjCompany = smartObjCompany;
	}
	public BigDecimal getSmartObjBranch()
	{
	    return smartObjBranch;
	}
	public void setSmartObjBranch(BigDecimal smartObjBranch)
	{
	    this.smartObjBranch = smartObjBranch;
	}

}
