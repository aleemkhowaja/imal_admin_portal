/**
 * 
 */
package com.path.vo.common.customization.button;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2017, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: peterabounader
 *
 * WebServiceSecurityCO.java used to
 */
public class WebServiceSecurityCO extends BaseVO
{
    private String AUTHENTICATION_TYPE;
    private String USER_NAME;
    private String PASSWORD;
    private String TOKEN_REGISTRATION_URL;
    private String TOKEN_REGISTRATION_APP_NAME;
    private String TOKEN_REGISTRATION_APP_PWD;
    private String TOKEN_GENERATION_URL;
    private BigDecimal API_CODE;
    private String TOKEN_AES_KEY;
    private String TOKEN_LIFETIME;
    public String getAUTHENTICATION_TYPE()
    {
        return AUTHENTICATION_TYPE;
    }
    public void setAUTHENTICATION_TYPE(String aUTHENTICATION_TYPE)
    {
        AUTHENTICATION_TYPE = aUTHENTICATION_TYPE;
    }
    public String getUSER_NAME()
    {
        return USER_NAME;
    }
    public void setUSER_NAME(String uSER_NAME)
    {
        USER_NAME = uSER_NAME;
    }
    public String getPASSWORD()
    {
        return PASSWORD;
    }
    public void setPASSWORD(String pASSWORD)
    {
        PASSWORD = pASSWORD;
    }
    public String getTOKEN_REGISTRATION_URL()
    {
        return TOKEN_REGISTRATION_URL;
    }
    public void setTOKEN_REGISTRATION_URL(String tOKEN_REGISTRATION_URL)
    {
        TOKEN_REGISTRATION_URL = tOKEN_REGISTRATION_URL;
    }
    public String getTOKEN_REGISTRATION_APP_NAME()
    {
        return TOKEN_REGISTRATION_APP_NAME;
    }
    public void setTOKEN_REGISTRATION_APP_NAME(String tOKEN_REGISTRATION_APP_NAME)
    {
	TOKEN_REGISTRATION_APP_NAME = tOKEN_REGISTRATION_APP_NAME;
    }
    public String getTOKEN_REGISTRATION_APP_PWD()
    {
        return TOKEN_REGISTRATION_APP_PWD;
    }
    public void setTOKEN_REGISTRATION_APP_PWD(String tOKEN_REGISTRATION_APP_PWD)
    {
	TOKEN_REGISTRATION_APP_PWD = tOKEN_REGISTRATION_APP_PWD;
    }
    public String getTOKEN_GENERATION_URL()
    {
        return TOKEN_GENERATION_URL;
    }
    public void setTOKEN_GENERATION_URL(String tOKEN_GENERATION_URL)
    {
        TOKEN_GENERATION_URL = tOKEN_GENERATION_URL;
    }
    public BigDecimal getAPI_CODE()
    {
        return API_CODE;
    }
    public void setAPI_CODE(BigDecimal aPI_CODE)
    {
        API_CODE = aPI_CODE;
    }
    public String getTOKEN_AES_KEY()
    {
        return TOKEN_AES_KEY;
    }
    public void setTOKEN_AES_KEY(String tOKEN_AES_KEY)
    {
        TOKEN_AES_KEY = tOKEN_AES_KEY;
    }
    public String getTOKEN_LIFETIME()
    {
        return TOKEN_LIFETIME;
    }
    public void setTOKEN_LIFETIME(String tOKEN_LIFETIME)
    {
        TOKEN_LIFETIME = tOKEN_LIFETIME;
    }

}
