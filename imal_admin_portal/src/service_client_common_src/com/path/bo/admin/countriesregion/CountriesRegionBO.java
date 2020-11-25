package com.path.bo.admin.countriesregion;

import java.util.List;

import com.path.dbmaps.vo.COUNTRIES_REGIONVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.countriesregion.CountriesRegionSC;
import com.path.vo.common.address.AddressCommonCO;

public interface CountriesRegionBO
{
    public int countriesRegionListCount(CountriesRegionSC criteria) throws BaseException;
    public List countriesRegionList(CountriesRegionSC criteria) throws BaseException;
    public COUNTRIES_REGIONVO returnCountriesRegionById(CountriesRegionSC criteria) throws BaseException;
    public AddressCommonCO checkAllowedMobileCodes(AddressCommonCO addressCommonCO)throws BaseException;
}
