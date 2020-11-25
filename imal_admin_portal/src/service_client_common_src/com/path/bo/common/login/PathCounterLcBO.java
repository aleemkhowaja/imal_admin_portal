/**
 * 
 */
package com.path.bo.common.login;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.PathCounterLcSC;

/**
 * Copyright 2014, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * LicensesMgntBO.java used to
 */
public interface PathCounterLcBO
{
    public String logLicenses(PathCounterLcSC criteria) throws BaseException;
}
