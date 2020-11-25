package com.path.bo.admin.countries;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.admin.countries.CountriesCO;
import com.path.vo.admin.countries.CountriesSC;

public interface CountriesBO
{

    public int countriesListCount(CountriesSC countriesSC) throws BaseException;

    public List countriesList(CountriesSC countriesSC) throws BaseException;

    public CountriesCO returnCountryById(CountriesSC criteria) throws BaseException;
    
    public int returnCtsCountryProhibitedCurrency(CountriesSC countriesSC) throws BaseException;
    
    public CountriesCO returnCountryByISO(CountriesSC countrySC) throws BaseException;

}
