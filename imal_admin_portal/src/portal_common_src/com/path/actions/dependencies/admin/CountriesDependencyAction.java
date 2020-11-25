package com.path.actions.dependencies.admin;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.admin.countries.CountriesBO;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.alerts.AlertsConstants;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.csmfom.FomElementsConstant;
import com.path.dbmaps.vo.COUNTRIESVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.countries.CountriesCO;
import com.path.vo.admin.countries.CountriesSC;
import com.path.vo.common.SessionCO;
import com.path.vo.common.address.AddressCommonCO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: lvalappil
 * 
 *          CountriesDependencyAction.java used to
 */
public class CountriesDependencyAction extends RetailBaseAction
{
    private CountriesBO countriesBO;
    private CountriesSC criteria = new CountriesSC();
    private CoreCommonServiceBO coreCommonServiceBO;
    private COUNTRIESVO countriesVO;
    private BigDecimal COUNTRY_CODE;
    private BigDecimal REGION_CODE;
    private BigDecimal POSTAL_CODE;
    private String callingScreen;
    private String screenReference;
    private String DEP_SRC;
    private String cifLanguage;
    private String isoCountryNoNull; // used to get the list of countries with ISO_COUNTRY not null
    //EWBI160173 - [mfalha]
    private BigDecimal CIF_TYPE;

    private String fromAddressCountry;
    
   //EWBI160173 - [mfalha]
	HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();

    public String dependencyByCountryCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    //POS mean from merchant pos screen
	    if(callingScreen != null && (FomConstant.FOM_SCREEN_NAME.equalsIgnoreCase(callingScreen)
	    		|| AlertsConstants.MERCHANTPOSMGNT_TODO_ALERT.equalsIgnoreCase(callingScreen)))
	    {
		set_forceAfterDepEvent("true");
		AddressCommonCO addressCO = new AddressCommonCO();
		
		//[mfalha]
		addressCO.setCOMP_CODE(sessionCO.getCompanyCode());
		addressCO.setBRANCH_CODE(sessionCO.getBranchCode());
		addressCO.setLoginUserId(sessionCO.getUserName());
		addressCO.setAppName(sessionCO.getCurrentAppName());
		addressCO.setOpt(get_pageRef());
		
		
		addressCO.setPreferredLanguage(sessionCO.getPreferredLanguage());
		addressCO.setREGION(REGION_CODE);
		addressCO.setCOUNTRY(COUNTRY_CODE);
		addressCO.setPOSTAL_CODE(POSTAL_CODE);
		addressCO.getCifVO().setCIF_TYPE(getCIF_TYPE());
		
		//Added By Lina for TP#925559
//		if (ConstantsCommon.AML_APP_NAME.equals(addressCO.getAppName()))
//		{
			addressCO.getCifVO().setLANGUAGE(getCifLanguage());
//		}
		addressCO.setOpt(screenReference);
		addressCO = coreCommonServiceBO.checkAddressCountry(addressCO);
		/*In FOM the arabic description must be according to the cif language instead of prefferred language BMOUPI170114 - TP:532453*/
		if (FomConstant.FOM_SCREEN_NAME.equalsIgnoreCase(callingScreen) && !("").equals(StringUtil.nullToEmpty(getCifLanguage())) )
		{
		    addressCO.setPreferredLanguage (getCifLanguage());
		}
		else
		{
		    addressCO.setPreferredLanguage(sessionCO.getPreferredLanguage());  
		}
		addressCO.setREGION(REGION_CODE);
		addressCO.setCOUNTRY(COUNTRY_CODE);
		addressCO.setPOSTAL_CODE(POSTAL_CODE);
		addressCO.getCifVO().setCIF_TYPE(getCIF_TYPE());
		addressCO.setOpt(screenReference);
		addressCO.getCifVO().setLANGUAGE(getCifLanguage());
		addressCO.setFromDependency("true"); //DASI180068
		addressCO.setAddrScreenMode(DEP_SRC); //BMO180181
		addressCO = coreCommonServiceBO.checkAddressCountry(addressCO);
		
		elementHashmap = addressCO.getBuisnessElement();

		setAdditionalScreenParams(elementHashmap);

		countriesVO = new COUNTRIESVO();
		if(NumberUtil.emptyDecimalToNull(COUNTRY_CODE) != null && COUNTRY_CODE.compareTo(BigDecimal.ZERO) > 0)
		{
		    countriesVO.setCOUNTRY_CODE(COUNTRY_CODE);
		}
		else
		{
		    countriesVO.setCOUNTRY_CODE(null);
		}

		if(elementHashmap.containsKey(FomElementsConstant.ADD_COUNTRY_DESC_ID))
		{
		    String countryDesc = StringUtil.nullToEmpty(elementHashmap.get(
			    FomElementsConstant.ADD_COUNTRY_DESC_ID).getValue());
		    countriesVO.setLONG_DESC_ENG(countryDesc.toString());
		}
		else
		{
		    countriesVO.setLONG_DESC_ENG(null);
		}

		if(addressCO.getWarningMsg() != null && !addressCO.getWarningMsg().isEmpty())
		{
		    set_warning(addressCO.getWarningMsg());
		    set_msgTitle(getText("warning_title_key"));
		}
	    }
	    else
	    {
		if(NumberUtil.emptyDecimalToNull(COUNTRY_CODE) != null)
		{
		    criteria.setCompCode(sessionCO.getCompanyCode());
		    if(ConstantsCommon.PREFERED_LANG_BOTH.equals(StringUtil.nullEmptyToValue(criteria
			    .getPreferredLanguage(), ConstantsCommon.PREFERED_LANG_BOTH)))
		    {
			criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
		    }
		    criteria.setLanguage(sessionCO.getLanguage());
		    criteria.setCountryCode(COUNTRY_CODE);
		    //Bassam Eid - BUG 637103 - Error upon retrieving XML report
		    criteria.setIsoCountryNoNull(isoCountryNoNull);
		    ////////////////////////////////////////////////////////////
		    CountriesCO countriesCO = countriesBO.returnCountryById(criteria);
		    countriesVO = countriesCO.getCountriesVO();
		    
		    //id:961309 Details:ABSAI200113 - Reset region and postal code TAR:ABSAI200113
		    if("mainCountry".equals(DEP_SRC)|| "1".equals(fromAddressCountry))//Rania - BMO180181
		    {	
		    getAdditionalScreenParams().putAll(returnCommonLibBO().applyDynScreenDisplay(new String[]{"lookuptxt_addressCO_REGION","addressCO_regionDesc"}, 
			    ConstantsCommon.ACTION_TYPE_VALUE, "", getAdditionalScreenParams(), null));
		    }
		    //id:961309 Details:ABSAI200113 - Reset region and postal code TAR:ABSAI200113
	
		    //John Massaad PATH130241 - FOM V.S Relationship File (If calling from FOM -> More Occupation screen button) 
		    if(FomConstant.MORE_OCCUPATION_SCREEN.equals(callingScreen))
		    {
			getAdditionalScreenParams().putAll(
				returnCommonLibBO().applyDynScreenDisplay(
					new String[] { "lookuptxt_cifOccupationVO_POSTAL_ADDR_REGION",
						"fomCifOccupationCO_regionDesc" }, ConstantsCommon.ACTION_TYPE_VALUE,
					"", getAdditionalScreenParams(), null));
		    }
		  //John Massaad PATH130241 - FOM V.S Relationship File
		    
		    // filling warning message
		    if(countriesCO.getWarningMsg() != null && !countriesCO.getWarningMsg().isEmpty())
		    {
			// addDependencyMsg(countriesCO.getWarningMsg(), null);
			set_warning(countriesCO.getWarningMsg());
			set_msgTitle(getText("warning_title_key"));
		    }
		}
	    }
	}
	catch(Exception e)
	{
	    countriesVO = new COUNTRIESVO();// added by assets team for tp bug
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    

    public COUNTRIESVO getCountriesVO()
    {
	return countriesVO;
    }

    public void setCountriesVO(COUNTRIESVO countriesVO)
    {
	this.countriesVO = countriesVO;
    }

    public BigDecimal getCOUNTRY_CODE()
    {
	return COUNTRY_CODE;
    }

    public void setCOUNTRY_CODE(BigDecimal cOUNTRYCODE)
    {
	COUNTRY_CODE = cOUNTRYCODE;
    }

    public void setCountriesBO(CountriesBO countriesBO)
    {
	this.countriesBO = countriesBO;
    }

    public String getCallingScreen()
    {
	return callingScreen;
    }

    public void setCallingScreen(String callingScreen)
    {
	this.callingScreen = callingScreen;
    }

    public String getScreenReference()
    {
	return screenReference;
    }

    public void setScreenReference(String screenReference)
    {
	this.screenReference = screenReference;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getElementHashmap()
    {
	return elementHashmap;
    }

    public void setElementHashmap(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> elementHashmap)
    {
	this.elementHashmap = elementHashmap;
    }

    public BigDecimal getREGION_CODE()
    {
	return REGION_CODE;
    }

    public void setREGION_CODE(BigDecimal rEGIONCODE)
    {
	REGION_CODE = rEGIONCODE;
    }

    public BigDecimal getPOSTAL_CODE()
    {
	return POSTAL_CODE;
    }

    public void setPOSTAL_CODE(BigDecimal pOSTALCODE)
    {
	POSTAL_CODE = pOSTALCODE;
    }

    public CountriesSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CountriesSC criteria)
    {
	this.criteria = criteria;
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
    
    public String getIsoCountryNoNull() 
    {
  		return isoCountryNoNull;
  	}

  	public void setIsoCountryNoNull(String isoCountryNoNull) 
  	{
  		this.isoCountryNoNull = isoCountryNoNull;
  	}
  	    public BigDecimal getCIF_TYPE()
  	    {
  	        return CIF_TYPE;
  	    }


  	    public void setCIF_TYPE(BigDecimal cIFTYPE)
  	    {
  	        CIF_TYPE = cIFTYPE;
  	    }


	    public String getFromAddressCountry()
	    {
	        return fromAddressCountry;
	    }


	    public void setFromAddressCountry(String fromAddressCountry)
	    {
	        this.fromAddressCountry = fromAddressCountry;
	    }
  	    
  	    
	
	public String getDEP_SRC()
	{
		return DEP_SRC;
	}


	
	public void setDEP_SRC(String dEP_SRC)
	{
		DEP_SRC = dEP_SRC;
	}
}
