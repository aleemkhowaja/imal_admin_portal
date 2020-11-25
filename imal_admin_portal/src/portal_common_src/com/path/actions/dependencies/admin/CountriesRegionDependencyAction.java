package com.path.actions.dependencies.admin;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.admin.countriesregion.CountriesRegionBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.csmfom.FomElementsConstant;
import com.path.dbmaps.vo.COUNTRIES_REGIONVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.countriesregion.CountriesRegionSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.address.AddressCommonCO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: lvalappil
 * 
 *          CountriesRegionDependencyAction.java used to
 */
public class CountriesRegionDependencyAction extends RetailBaseAction
{
    private CountriesRegionBO countriesRegionBO;
    private CoreCommonServiceBO coreCommonServiceBO;
    private COUNTRIES_REGIONVO countriesRegionVO;
    private BigDecimal COUNTRY_CODE;
    private BigDecimal REGION_CODE;
    private BigDecimal POSTAL_CODE;
    private String callingScreen;
    private String callingField;
    private String screenReference;
    private String issuePlace;
    private String cifLanguage;
    private String mobileNO;
    private AddressCommonCO addressCO= new AddressCommonCO();
    
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    public String dependencyByRegionCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();

	    //POS mean from merchant POS screen
	    if(callingScreen != null && (FomConstant.FOM_SCREEN_NAME.equalsIgnoreCase(callingScreen)
	    		|| AlertsConstants.MERCHANTPOSMGNT_TODO_ALERT.equalsIgnoreCase(callingScreen)))
	    {
		set_forceAfterDepEvent("true");
		if(NumberUtil.emptyDecimalToNull(COUNTRY_CODE) == null)
		{
		    countriesRegionVO = new COUNTRIES_REGIONVO();
		}
		else
		{
		    AddressCommonCO addressCO = new AddressCommonCO();
		    addressCO.setCOMP_CODE(sessionCO.getCompanyCode());
		    addressCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
		    addressCO.setCOUNTRY(COUNTRY_CODE);
		    addressCO.setPOSTAL_CODE(POSTAL_CODE);
		    addressCO.setOpt(get_pageRef());
		    /*In FOM the arabic description must be according to the cif language instead of prefferred language BMOUPI170114 - TP:532453*/
			if (FomConstant.FOM_SCREEN_NAME.equalsIgnoreCase(callingScreen) && !("").equals(StringUtil.nullToEmpty(getCifLanguage())) )
			{
			    addressCO.setPreferredLanguage (getCifLanguage());
			}
			else
			{
			    addressCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
			}
		    if(callingField != null && "REGION".equalsIgnoreCase(callingField))
		    {
			addressCO.setREGION(REGION_CODE);
			elementHashmap = coreCommonServiceBO.checkAddressRegion(addressCO);
			elementHashmap.get("cifVO_TEL");

			setAdditionalScreenParams(elementHashmap);

			countriesRegionVO = new COUNTRIES_REGIONVO();
			if(elementHashmap.containsKey(FomElementsConstant.REGION_ID)
				&& !"".equalsIgnoreCase(elementHashmap.get(FomElementsConstant.REGION_ID).getValue()
					.toString()))
			{
			    countriesRegionVO.setBRIEF_DESC_ENG(elementHashmap.get(FomElementsConstant.REGION_ID)
				    .getValue().toString());
			    countriesRegionVO.setREGION_CODE(REGION_CODE);
			}
			else
			{
			    countriesRegionVO.setREGION_CODE(null);
			}

			if(elementHashmap.containsKey(FomElementsConstant.REGION_DESC_ID)
				&& !"".equalsIgnoreCase(elementHashmap.get(FomElementsConstant.REGION_DESC_ID)
					.getValue().toString()))
			{
			    countriesRegionVO.setREGION_CODE(REGION_CODE);
			    countriesRegionVO.setBRIEF_DESC_ENG(elementHashmap.get(FomElementsConstant.REGION_DESC_ID)
				    .getValue().toString());
			}
			else
			{
			    countriesRegionVO.setBRIEF_DESC_ENG(null);
			}

		    }
		    else if(callingField != null && "POBOX_AREA".equalsIgnoreCase(callingField))
		    {
			addressCO.setPOBOX_AREA(REGION_CODE);
			elementHashmap = coreCommonServiceBO.checkAddressPoBoxArea(addressCO);

			setAdditionalScreenParams(elementHashmap);

			countriesRegionVO = new COUNTRIES_REGIONVO();
			if(elementHashmap.containsKey(FomElementsConstant.POBOX_AREA_ID)
				&& !"".equalsIgnoreCase(elementHashmap.get(FomElementsConstant.POBOX_AREA_ID)
					.getValue().toString()))
			{
			    countriesRegionVO.setREGION_CODE(REGION_CODE);
			    countriesRegionVO.setBRIEF_DESC_ENG(elementHashmap.get(FomElementsConstant.POBOX_AREA_ID)
				    .getValue().toString());
			}
			else
			{
			    countriesRegionVO.setREGION_CODE(null);
			}

			if(elementHashmap.containsKey(FomElementsConstant.POBOX_AREA_DESC_ID)
				&& !"".equalsIgnoreCase(elementHashmap.get(FomElementsConstant.POBOX_AREA_DESC_ID)
					.getValue().toString()))
			{
			    countriesRegionVO.setREGION_CODE(REGION_CODE);
			    countriesRegionVO.setBRIEF_DESC_ENG(elementHashmap.get(
				    FomElementsConstant.POBOX_AREA_DESC_ID).getValue().toString());
			}
			else
			{
			    countriesRegionVO.setBRIEF_DESC_ENG(null);
			}
		    }
		}

	    }
	    else
	    {
		CountriesRegionSC criteria = new CountriesRegionSC();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		criteria.setCountry_code(COUNTRY_CODE);
		criteria.setRegionCode(REGION_CODE);
		criteria.setIssuePlace(issuePlace);
   
		//Hasan Bug#485368 22/02/2017
		if(!NumberUtil.isEmptyDecimal(COUNTRY_CODE) && !NumberUtil.isEmptyDecimal(REGION_CODE))
		{
		    countriesRegionVO = countriesRegionBO.returnCountriesRegionById(criteria);

		    /*
		     * to display the Arabic description in case the language
		     * was Arabic
		     */
		    if(countriesRegionVO == null)
		    {
			throw new BOException(MessageCodes.INVALID_REGION_CODE);
		    }
		    else
		    {
			if(StringUtil.nullToEmpty(sessionCO.getLanguage()).equals(ConstantsCommon.LANGUAGE_ARABIC))
			{
			    countriesRegionVO.setBRIEF_DESC_ENG(countriesRegionVO.getBRIEF_DESC_ARAB());
			}
			else
			{
			    countriesRegionVO.setBRIEF_DESC_ENG(countriesRegionVO.getBRIEF_DESC_ENG());
			}
		    }

		}
	    }

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByRegionCode method of CountriesRegionDependencyAction");
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    public String dependencyByMobileNumber()
    {
	try{
	    
	    SessionCO sessionCO = returnSessionObject();
	   
	    addressCO.setCOMP_CODE(sessionCO.getCompanyCode());
	    addressCO.setMOBILE(mobileNO);
	    addressCO.setCOUNTRY(COUNTRY_CODE);
	    addressCO = countriesRegionBO.checkAllowedMobileCodes(addressCO);
	    	
	   }
	catch(Exception e)
	{
	    log.error(e, "Error in dependencyByRegionCode method of CountriesRegionDependencyAction");
	    handleException(e, null, null);
	    addressCO.setMOBILE(null);
	}
	return SUCCESS;
    }
    

    public COUNTRIES_REGIONVO getCountriesRegionVO()
    {
	return countriesRegionVO;
    }

    public void setCountriesRegionVO(COUNTRIES_REGIONVO countriesRegionVO)
    {
	this.countriesRegionVO = countriesRegionVO;
    }

    public BigDecimal getCOUNTRY_CODE()
    {
	return COUNTRY_CODE;
    }

    public void setCOUNTRY_CODE(BigDecimal cOUNTRYCODE)
    {
	COUNTRY_CODE = cOUNTRYCODE;
    }

    public BigDecimal getREGION_CODE()
    {
	return REGION_CODE;
    }

    public void setREGION_CODE(BigDecimal rEGIONCODE)
    {
	REGION_CODE = rEGIONCODE;
    }

    public void setCountriesRegionBO(CountriesRegionBO countriesRegionBO)
    {
	this.countriesRegionBO = countriesRegionBO;
    }

    public BigDecimal getPOSTAL_CODE()
    {
	return POSTAL_CODE;
    }

    public void setPOSTAL_CODE(BigDecimal pOSTALCODE)
    {
	POSTAL_CODE = pOSTALCODE;
    }

    public String getCallingScreen()
    {
	return callingScreen;
    }

    public void setCallingScreen(String callingScreen)
    {
	this.callingScreen = callingScreen;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getElementHashmap()
    {
	return elementHashmap;
    }

    public void setElementHashmap(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap)
    {
	this.elementHashmap = elementHashmap;
    }

    public String getCallingField()
    {
	return callingField;
    }

    public void setCallingField(String callingField)
    {
	this.callingField = callingField;
    }

    public String getScreenReference()
    {
	return screenReference;
    }

    public void setScreenReference(String screenReference)
    {
	this.screenReference = screenReference;
    }

    public String getIssuePlace()
    {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace)
    {
        this.issuePlace = issuePlace;
    }

    public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
    {
        this.coreCommonServiceBO = coreCommonServiceBO;
    }
    
    public String getCifLanguage()
    {
        return cifLanguage;
    }

    public void setCifLanguage(String cifLanguage)
    {
        this.cifLanguage = cifLanguage;
    }


    public String getMobileNO()
    {
        return mobileNO;
    }

    public void setMobileNO(String mobileNO)
    {
        this.mobileNO = mobileNO;
    }

    public AddressCommonCO getAddressCO()
    {
        return addressCO;
    }

    public void setAddressCO(AddressCommonCO addressCO)
    {
        this.addressCO = addressCO;
    }


}
