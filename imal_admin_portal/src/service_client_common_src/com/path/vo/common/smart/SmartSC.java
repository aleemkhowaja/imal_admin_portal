/**
 * 
 */
package com.path.vo.common.smart;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.path.vo.common.CommonLibSC;
import com.path.vo.common.audit.AuditRefCO;

/**
 * @author raees
 *
 */
public class SmartSC extends CommonLibSC
{
	private String trxNbr;
	private String selectSmartOPT;
	private String auditOption;
	private String auditOperation;
	private String s_view; 
	private String s_scan;
	private String s_detach;
	private String s_edit;
	private String s_update;
	//Changed saddTypeCode variable non standard name Bug 501397
	private BigDecimal saddTypeCode;
	private int maxObjCode;
	private byte[] OLE_OBJECT;
	private String language; 

        // ENH 519846 variables needed to receive the file location.
        private String fileStorageMedia;
        private String filePhysicalLoc;
        private String fileThirdPartyLoc;
	private String filename;
	//DN variables to set/get the screens params for the third party call
	private String smartScreenParams;
	private String smartCifNo;
	private String smartCifAddRef;
	private boolean isNotNewRec;
	
	// for additional entities that are defined in the Screen Entities
	private Map<String,Object> entityTypeInfosMap;
	
	//TP 841913 Handle SMART auditing upon upload/delete attachments
	//Added for audit on detach of files
	private AuditRefCO auditRefCO;

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
	public void setSelectSmartOPT(String selectSmartOPT)
	{
	    this.selectSmartOPT = selectSmartOPT;
	}
	public String getSelectSmartOPT()
	{
	    return selectSmartOPT;
	}
	public void setAuditOption(String auditOption)
	{
	    this.auditOption = auditOption;
	}
	public String getAuditOption()
	{
	    return auditOption;
	}
	public void setAuditOperation(String auditOperation)
	{
	    this.auditOperation = auditOperation;
	}
	public String getAuditOperation()
	{
	    return auditOperation;
	}
	public void setS_view(String s_view)
	{
	    this.s_view = s_view;
	}
	public String getS_view()
	{
	    return s_view;
	}
	public String getS_scan()
	{
	    return s_scan;
	}
	public void setS_scan(String sScan)
	{
	    s_scan = sScan;
	}
	public String getS_detach()
	{
	    return s_detach;
	}
	public void setS_detach(String sDetach)
	{
	    s_detach = sDetach;
	}
	public String getS_edit()
	{
	    return s_edit;
	}
	public void setS_edit(String sEdit)
	{
	    s_edit = sEdit;
	}
	public String getS_update()
	{
	    return s_update;
	}
	public void setS_update(String sUpdate)
	{
	    s_update = sUpdate;
	}
	public void setMaxObjCode(int maxObjCode)
	{
	    this.maxObjCode = maxObjCode;
	}
	public int getMaxObjCode()
	{
	    return maxObjCode;
	}
	public void setOLE_OBJECT(byte[] oLE_OBJECT)
	{
	    OLE_OBJECT = oLE_OBJECT;
	}
	public byte[] getOLE_OBJECT()
	{
	    return OLE_OBJECT;
	}
	public String getLanguage()
	{
		return language;
	}
	public void setLanguage(String language)
	{
		this.language = language;
	}
	public BigDecimal getSaddTypeCode()
	{
	    return saddTypeCode;
	}
	public void setSaddTypeCode(BigDecimal saddTypeCode)
	{
	    this.saddTypeCode = saddTypeCode;
	}
	public String getFileStorageMedia()
	{
	    return fileStorageMedia;
	}
	public void setFileStorageMedia(String fileStorageMedia)
	{
	    this.fileStorageMedia = fileStorageMedia;
	}
	public String getFilePhysicalLoc()
	{
	    return filePhysicalLoc;
	}
	public void setFilePhysicalLoc(String filePhysicalLoc)
	{
	    this.filePhysicalLoc = filePhysicalLoc;
	}
	public String getFileThirdPartyLoc()
	{
	    return fileThirdPartyLoc;
	}
	public void setFileThirdPartyLoc(String fileThirdPartyLoc)
	{
	    this.fileThirdPartyLoc = fileThirdPartyLoc;
	}
	public String getFilename()
	{
	    return filename;
	}
	public void setFilename(String filename)
	{
	    this.filename = filename;
	}
	public String getSmartScreenParams()
	{
	    return smartScreenParams;
	}
	public void setSmartScreenParams(String smartScreenParams)
	{
	    this.smartScreenParams = smartScreenParams;
	}
	public String getSmartCifAddRef()
	{
	    return smartCifAddRef;
	}
	public void setSmartCifAddRef(String smartCifAddRef)
	{
	    this.smartCifAddRef = smartCifAddRef;
	}
	public String getSmartCifNo()
	{
	    return smartCifNo;
	}
	public void setSmartCifNo(String smartCifNo)
	{
	    this.smartCifNo = smartCifNo;
	}
	public boolean isNotNewRec()
	{
	    return isNotNewRec;
	}
	public void setNotNewRec(boolean isNotNewRec)
	{
	    this.isNotNewRec = isNotNewRec;
	}
	@JSON(serialize=false)
	public Map<String, Object> getEntityTypeInfosMap()
	{
	    return entityTypeInfosMap;
	}
	public void setEntityTypeInfosMap(Map<String, Object> entityTypeInfosMap)
	{
	    this.entityTypeInfosMap = entityTypeInfosMap;
	}
	public AuditRefCO getAuditRefCO()
	{
	    return auditRefCO;
	}
	public void setAuditRefCO(AuditRefCO auditRefCO)
	{
	    this.auditRefCO = auditRefCO;
	}
}
