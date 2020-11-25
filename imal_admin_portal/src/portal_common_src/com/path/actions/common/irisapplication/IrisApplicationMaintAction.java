package com.path.actions.common.irisapplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.cif.CifBO;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.irisapplication.IrisApplicationCO;

@SuppressWarnings("unused")
public class IrisApplicationMaintAction extends GridBaseAction
{
    private IrisApplicationCO irisApplicationCO = new IrisApplicationCO();
    private CifBO cifBO;
    private String noInfoBar;// used to specify whether to load info Bar or not
    private CifSC criteria = new CifSC();
    private CoreCommonServiceBO coreCommonServiceBO;
    
    
    private String irs;
    
    public Object getModel()
    {
	return criteria;
    }
    public String loadIrisApplicationMaintPage()
    {
	try
	{
	    initialize();
	    return SUCCESS;
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}

    }

    private void initialize()
    {
	 SessionCO sessCO = returnSessionObject();
	 if(sessCO.getScannedCIFNo() != null)
	 {
	     criteria.setCif_no(sessCO.getScannedCIFNo());
	 }
    }

    public String scanIris()
    {
	try
	{

	    //irisApplicationCO = new IrisApplicationCO();
	    /*
	    if(StringUtil.isNotEmpty(getIrs()))
	     {
		JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(getIrs()); 
		irisApplicationCO = (IrisApplicationCO) JSONObject.toBean(jsonFilter, IrisApplicationCO.class);
		
	     }*/

	    SessionCO sessCO = returnSessionObject();
	    criteria.setCompCode(sessCO.getCompanyCode());
	    if (StringUtil.isNotEmpty(irisApplicationCO.getCifNo()))
	    {
		criteria.setCif_no(new BigDecimal(irisApplicationCO.getCifNo()));
	    }
	    ArrayList<CIFVO> scannedCifs = coreCommonServiceBO.returncifByIrisRecog(criteria);
	    if(scannedCifs == null || scannedCifs.isEmpty())
	    {
		throw new BOException(MessageCodes.NO_CIF_WAS_FOUND);
	    }
	    irisApplicationCO.setScannedCifs(new ArrayList<CIFVO>());
	    irisApplicationCO.getScannedCifs().addAll(scannedCifs);
	    return SUCCESS;
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return SUCCESS;
	}
    }
    
    public String searchCIF() 
    {
	try
	{
	    String[] searchCol = { "CIF_NO","SHORT_NAME_ENG","LONG_NAME_ENG","SHORT_NAME_ARAB","LONG_NAME_ARAB"};
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);
	    SessionCO sessCO = returnSessionObject();
	    criteria.setUserId(sessCO.getUserName());
	    criteria.setRaFlag(ConstantsCommon.CIF_All_BRANCHES);// I means All Branches
	    criteria.setRaStatus(ConstantsCommon.CIF_ACTIVE);
	    criteria.setRaResident(ConstantsCommon.CIF_RESIDENT_AND_NOT_RESIDENT);

	    criteria.setComp_code(sessCO.getCompanyCode());
	    criteria.setBranchCode(sessCO.getBranchCode());
	    
	    if(checkNbRec(criteria))
	    {
		setRecords(cifBO.cifLookupQueryListCount(criteria));
	    }
	    List<CIFVO> cifVOList = cifBO.cifLookupQueryList(criteria);
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(cifVOList);
	    
    	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String assignCIFGlobaly()
    {
	BigDecimal chosenCIfNo = criteria.getCif_no();
	String chosenCIfName = criteria.getCif_name();
	SessionCO sessCO = returnSessionObject();
	sessCO.setScannedCIFNo(chosenCIfNo);
	sessCO.setScannedCIFName(chosenCIfName);
	return SUCCESS;
    }

    public IrisApplicationCO getIrisApplicationCO()
    {
        return irisApplicationCO;
    }

    public void setIrisApplicationCO(IrisApplicationCO irisApplicationCO)
    {
        this.irisApplicationCO = irisApplicationCO;
    }

    public String getNoInfoBar()
    {
        return noInfoBar;
    }

    public void setNoInfoBar(String noInfoBar)
    {
        this.noInfoBar = noInfoBar;
    }

    public void setCifBO(CifBO cifBO)
    {
        this.cifBO = cifBO;
    }
    public CifSC getCriteria()
    {
        return criteria;
    }
    public String getIrs()
    {
        return irs;
    }
    public void setIrs(String irs)
    {
        this.irs = irs;
    }
    public void setCriteria(CifSC criteria)
    {
        this.criteria = criteria;
    }
    public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
    {
        this.coreCommonServiceBO = coreCommonServiceBO;
    }
    

}
