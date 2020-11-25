package com.path.bo.security;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DateUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.SecurityUtilsExt;
import com.path.lib.common.util.StringUtil;
import com.path.lib.log.Log;
import com.path.vo.common.SessionCO;


public class PathUrlParamEncryptFilter implements Filter
{
    private static Log log = Log.getInstance();

    @Override
    public void destroy()
    {
	// TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
	    ServletException
    {
	if(request instanceof HttpServletRequest && response instanceof HttpServletResponse)
	{
	    HttpServletRequest httprequest = (HttpServletRequest) request;
	    //add info to thread name
	    String currentThreadName = StringUtil.nullToEmpty(Thread.currentThread().getName());
	    String newThreadName = currentThreadName;
	    int portaInx = newThreadName.indexOf("_PATH_PORTAL[");
	    if(portaInx > 0)
	    {
		newThreadName = newThreadName.substring(0,portaInx);
	    }
	    Thread.currentThread().setName(newThreadName.concat("_").concat(returnUserFromSession(httprequest, true)));
	    
	    String requestURI = httprequest.getRequestURI();
	    if(requestURI != null)
	    {
	    	requestURI = requestURI.toUpperCase();
	    }
	    if(requestURI.contains("?"))
	    {
	    	requestURI = requestURI.substring(0,requestURI.indexOf("?"));
	    }
	    if((requestURI.endsWith(".JS") && StringUtil.isNotEmpty(httprequest.getParameter("_")))
		    || requestURI.endsWith(".CSS") || requestURI.endsWith(".PNG") || requestURI.endsWith(".SVG")
		    || requestURI.endsWith(".GIF") || requestURI.endsWith(".JPG") || requestURI.endsWith(".JPEG"))
	    {
		 response = new PathUrlParamWrapperResponse((HttpServletResponse) response);
	    }
	    
	    HttpServletResponse httpresponse = (HttpServletResponse) response;
	    boolean error = false;
	    String errorMsg = null;
	    try
	    {
		String pathEncryptedParam = request.getParameter("PATHPARAM");
		/*if(false && pathEncryptedParam == null && request.getContentType() != null && request.getContentType().contains("multipart/form-data") )
		{
		    PathFileUploadWrapperRequest fileUploadRequest = new PathFileUploadWrapperRequest(httprequest);
		    pathEncryptedParam = fileUploadRequest.getParameter("PATHPARAM");
		    Map<String, String[]> customparams = decryptRequestParam(httprequest, pathEncryptedParam);
		    fileUploadRequest.addParameters(customparams);
		    request = fileUploadRequest;
		}
		else
		*/
		if(StringUtil.isNotEmpty(pathEncryptedParam))
		{
		    Map<String, String[]> customparams = decryptRequestParam(httprequest, pathEncryptedParam);
		    request = new PathUrlParamWrapperRequest(httprequest, customparams);
		}
	    }
	    catch(Exception e)
	    {
		error = true;
		errorMsg = e.getMessage();
		e.printStackTrace();
		log.error(e, "SecurityFilter doFilter. Error in decrypting request parameters User="+returnUserFromSession(httprequest,false)+" URL="+httprequest.getRequestURI());
	    }
	    if(error)
	    {
	    	//TP 692485 BMOUPI180328  to randomize token after login, in case several login pages opened and attempt done for several ones
			if(errorMsg != null && errorMsg.contains("Invalid Session Token") && httprequest.getRequestURI().endsWith("/j_spring_security_check"))
			{
			    httpresponse.sendRedirect(httprequest.getRequestURI().replace("/j_spring_security_check", "")+"/"); 
			}
			else
			{
			    httpresponse.sendError(409);
			    //remove info from thread name
			    Thread.currentThread().setName(currentThreadName);
			}
			return;
	    }
	    else
	    {
		try
		{
		    chain.doFilter(request, response);
		}
		catch(IOException | ServletException e)
		{
		    //remove info from thread name
		    Thread.currentThread().setName(currentThreadName);
		    throw e;
		}
	    }
	    
	    //remove info from thread name
	    Thread.currentThread().setName(currentThreadName);

	}
	else
	{
	    chain.doFilter(request, response);
	}
    }
    /**
     * returning user name for informative details
     * @param request
     * @return
     */
    private static String returnUserFromSession(HttpServletRequest request, boolean fullDetails)
    {
    	String userName= "UNKNOWN";
    	try
    	{
    		SessionCO sessCO = (SessionCO) request.getSession().getAttribute(ConstantsCommon.SESSION_VO_ATTR);
    		if(sessCO != null)
    		{
    			if(fullDetails)
    			{
    			    userName = "PATH_PORTAL[".concat(DateUtil.format(Calendar.getInstance().getTime(),"dd_MM_yyyy_hh_mm_ss"))
    				    .concat("-")
    				    .concat(String.valueOf(sessCO.getUserName()))
    				    .concat("-")
    				    .concat(String.valueOf(sessCO.getCompanyCode()))
    				    .concat("-")
    				    .concat(String.valueOf(sessCO.getBranchCode()))
    				    .concat("-")
    				    .concat(String.valueOf(sessCO.getCurrentAppName()))
    				    .concat("-")
    				    //.concat(request.getRequestURI())
    				    //.concat("-")
    				    .concat(StringUtil.nullToEmpty(sessCO.getHttpSessionID()))
    				    .concat("]");
    			}
    			else
    			{
    			    userName = sessCO.getUserName();
    			}
    		}
    	}
    	catch(Exception e)
    	{
    		 log.error(e,"Error in Returning UserName from Session");
    	}
    	return userName;
    }
    
    public static Map<String, String[]> decryptRequestParam(HttpServletRequest request, String pathEncryptedParam) throws Exception
    {
	Map<String, String[]> customparams = new HashMap<String, String[]>();
	if(pathEncryptedParam != null)
	{
	    if(pathEncryptedParam.isEmpty() )
	    {
		throw new BaseException("Path Security Error . Invalid Encrypted Parameter");
	    }
	    Map<String, Object> decryptedMap = SecurityUtils.returnDecryptedNoPaddingParams(request,pathEncryptedParam);
	    for(String key : decryptedMap.keySet())
	    {
		String decodedKey = URLDecoder.decode(key, SecurityUtilsExt.DEFAULT_ENCODING);
		Object valueObj = decryptedMap.get(key);
		if(valueObj instanceof String[])
		{
		    String[] paramArr = (String[])valueObj;
		    for(int i = 0; i < paramArr.length; i++)
		    {
			paramArr[i] = URLDecoder.decode(paramArr[i], SecurityUtilsExt.DEFAULT_ENCODING);
		    }
		    customparams.put(decodedKey, paramArr);
		}
		else
		{
		    String decodedValue = URLDecoder.decode(valueObj.toString(), SecurityUtilsExt.DEFAULT_ENCODING);
		    customparams.put(decodedKey, new String[] { decodedValue });
		}
	    }
	   
	}
	return customparams;
    }
    

    @Override
    public void init(FilterConfig arg0) throws ServletException
    {
	try
	{
	    ConstantsCommon.SECURITY_ENCRYPTPARAMS_ENABLED = ConstantsCommon.ONE.equals(StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile("PathRemoting","security.encryptparams.enabled"),ConstantsCommon.ONE).trim());
	    ConstantsCommon.SECURITY_ENCRYPTPARAMS_DYNAMIC_PWD =  ConstantsCommon.ONE.equals(StringUtil.nullEmptyToValue(PathPropertyUtil.returnPathPropertyFromFile("PathRemoting","security.encryptparams.dynamicpwd"),ConstantsCommon.ZERO).trim());
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	    log.error(e, "SecurityFilter init. Error reading security.encryptparams.enabled from PathRemoting.properties");
	}
    }
    
}
