/**
 * 
 */
package com.path.vo.common.customization;

import java.util.List;

import com.path.dbmaps.vo.FIELD_TECH_DETAILSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * CustomizationSC.java used to
 */
public class CustomizationSC extends GridParamsSC
{
    private String                     appName;
    private String                     cutomizationPROG_REF;
    private String                     ivCrud;
    private SYS_PARAM_SCREEN_DISPLAYVO screenDispVO = new SYS_PARAM_SCREEN_DISPLAYVO();
    private String optUrl;								// used as OPT_URL column in OPT_EXTENDED table
    private String dynamicOpt;								// used as dynamic_opt column in OPT table
    private String forSeriesProgRef;							// used as FOR_SERIES_PROG_REF in OPT_EXTENDED table   
    private List<String> seriesProgRefList;					
    private List<CustomizationCO> custCoList;
    
    /**
     * Specify the type of object to export (page, field)
     */
    private String exportCustType;
    
    private boolean useSpecificPageRef;
    
    private byte[] importedBytes;
    
    private String overrideCustImport;

	public List<String> getSeriesProgRefList() {
		return seriesProgRefList;
	}


	public void setSeriesProgRefList(List<String> seriesProgRefList) {
		this.seriesProgRefList = seriesProgRefList;
	}


	public String getForSeriesProgRef() {
		return forSeriesProgRef;
	}


	public void setForSeriesProgRef(String forSeriesProgRef) {
		this.forSeriesProgRef = forSeriesProgRef;
	}


	public String getDynamicOpt() {
		return dynamicOpt;
	}


	public void setDynamicOpt(String dynamicOpt) {
		this.dynamicOpt = dynamicOpt;
	}


	public String getOptUrl() {
		return optUrl;
	}


	public void setOptUrl(String optUrl) {
		this.optUrl = optUrl;
	}

   
    
    /**
     * @return the cutomizationPROG_REF
     */
    public String getCutomizationPROG_REF()
    {
        return cutomizationPROG_REF;
    }
    /**
     * @param cutomizationPROGREF the cutomizationPROG_REF to set
     */
    public void setCutomizationPROG_REF(String cutomizationPROGREF)
    {
        cutomizationPROG_REF = cutomizationPROGREF;
    }
    /**
     * @return the screenDispVO
     */
    public SYS_PARAM_SCREEN_DISPLAYVO getScreenDispVO()
    {
        return screenDispVO;
    }
    /**
     * @param screenDispVO the screenDispVO to set
     */
    public void setScreenDispVO(SYS_PARAM_SCREEN_DISPLAYVO screenDispVO)
    {
        this.screenDispVO = screenDispVO;
    }
    /**
     * @return the appName
     */
    public String getAppName()
    {
        return appName;
    }
    /**
     * @param appName the appName to set
     */
    public void setAppName(String appName)
    {
        this.appName = appName;
    }
    /**
     * @return the ivCrud
     */
    public String getIvCrud()
    {
        return ivCrud;
    }
    /**
     * @param ivCrud the ivCrud to set
     */
    public void setIvCrud(String ivCrud)
    {
        this.ivCrud = ivCrud;
    }

    public String getExportCustType()
    {
        return exportCustType;
    }

    public void setExportCustType(String exportCustType)
    {
        this.exportCustType = exportCustType;
    }

    public byte[] getImportedBytes()
    {
        return importedBytes;
    }

    public void setImportedBytes(byte[] importedBytes)
    {
        this.importedBytes = importedBytes;
    }

    public String getOverrideCustImport()
    {
	return overrideCustImport;
    }

    public void setOverrideCustImport(String overrideCustImport)
    {
	this.overrideCustImport = overrideCustImport;
    }


    public List<CustomizationCO> getCustCoList()
    {
	return custCoList;
    }


    public void setCustCoList(List<CustomizationCO> custCoList)
    {
	this.custCoList = custCoList;
    }


    public boolean isUseSpecificPageRef()
    {
	return useSpecificPageRef;
    }


    public void setUseSpecificPageRef(boolean useSpecificPageRef)
    {
	this.useSpecificPageRef = useSpecificPageRef;
    }

}
