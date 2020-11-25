package com.path.actions.common.customization;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.customization.ThemeCustomizationBO;
import com.path.dbmaps.vo.SYS_PARAM_STYLEVO;
import com.path.dbmaps.vo.SYS_THEMEVO;
import com.path.dbmaps.vo.SYS_THEME_STYLE_ATTRIBUTE_VALVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.customization.ThemeCustomizationCO;
import com.path.vo.common.customization.ThemeCustomizationConstant;
import com.path.vo.common.customization.css.ThemeCss;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>ThemeCustomizationAction.java</strong> used to customized the themes
 * of the client.
 * 
 * @author Khaledhussein
 * 
 */
@SuppressWarnings("serial")
public class ThemeCustomizationAction extends GridBaseAction
{
    private ThemeCustomizationBO themeCustomizationBO;
    private ThemeCustomizationCO themeCustomizationCO = new ThemeCustomizationCO();
    private ThemeCss themeCss;
    private File upload;
    private String cssData;
    private String imageRef;
    private String themeCssStr;
    private String      fileName;
    private String fromChangePwd;
    private File    uploadFile;
    private InputStream exportStream;
    private InputStream errorStream;
    private static final String EXPORT_FILE_ENC_PASS = "pathexpthemecust";
    /**
     * 1: return css file for dialog div 2: return css file for global app
     */
    private String cssScope;

    private InputStream imageStream;
    private InputStream cssStream;

    private List<SelectCO> fontFamilyDropDown = new ArrayList<SelectCO>();

    /**
     * Load the theme screen and initialize all the needed data
     * 
     * @return
     */
    public String initialize()
    {
	try
	{
	    String themeCustAccessRight = returnAccessRightByProgRef(ConstantsCommon.USER_THEME_OPT);
	    if(themeCustAccessRight == null)
	    {
		throw new BOException(MessageCodes.NO_ACCESS);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
	return ThemeCustomizationConstant.RESULT_INIT;
    }

    /**
     * Load the Grid that contains the themes
     * 
     * @return
     */
    public String loadAvailableCustomThemes()
    {
	try
	{
	    GridParamsSC gridParamSC = new GridParamsSC();
	    gridParamSC.setSearchCols(new String[] { "THEME_NAME", "IS_ACTIVE_YN", "APP_NAME" });
	    copyproperties(gridParamSC);
	    String imalAppDesc = getEscText("global_ref_key");
	    // pass this to the query
	    gridParamSC.setCurrAppName(imalAppDesc);
	    List<ThemeCustomizationCO> result = themeCustomizationBO.loadUserThemes(gridParamSC);
	    if(checkNbRec(gridParamSC))
	    {
		setRecords(themeCustomizationBO.returnUserThemesCount(gridParamSC));
	    }
	    setGridModel(result);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Load the theme
     * 
     * @return
     */
    public String loadTheme()
    {
	return ThemeCustomizationConstant.RESULT_THEME_DETAILS;
    }

    /**
     * Get the attributes for specific style
     * 
     * @return
     */
    public String returnStyleAttrs()
    {
	try
	{
	    themeCustomizationCO.setStyleAttrVOs(themeCustomizationBO.getStyleAttrs(themeCustomizationCO.getStyleVO()
		    .getSTYLE_TECH_NAME()));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /**
     * Method to upload the image for the path login page
     * 
     * @return String
     */
    @SuppressWarnings("unchecked")
    public String uploadImage()
    {
	try
	{
	    //limit the size of the file to be below of 200 MB = 200000000 bytes 
	    byte[] fileBytes = PathFileSecure.readFileToByteArray(upload,200000000);
	    Map<String, byte[]> images = new HashMap<String, byte[]>();
	    if(session.containsKey("ImageUploaded"))
	    {
		images = (Map<String, byte[]>) session.get("ImageUploaded");
	    }
	    images.put(imageRef, fileBytes);
	    session.put("ImageUploaded", images);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return ThemeCustomizationConstant.RESULT_FILE_SUCCESS;
    }

    /**
     * Construct the customization dialog for the given class
     * 
     * @return
     */
    public String buildCustomizationDialog()
    {
	try
	{
	    if(themeCustomizationCO.getFontChange() != null)
	    {
		loadFontFamilyDropDown();
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return ThemeCustomizationConstant.RESULT_CUSTOMIZATION_DIALOG;
    }

    /**
     * Return css file
     * 
     * @return
     */
    public String returnCssFile()
    {
	try
	{
	    StringBuffer buf = new StringBuffer();
	    String appName = StringUtil.nullEmptyToValue(returnSessionObject().getCurrentAppName(),
		    ConstantsCommon.IMAL_APP_NAME);
	    if(themeCustomizationCO.getThemeVO() == null || themeCustomizationCO.getThemeVO().getTHEME_ID() == null)
	    {
        	    if(StringUtil.nullToEmpty(cssData).isEmpty())
        	    {
        		// calling create new theme, so check if there is an active
        		// theme and load the css
        		buf.append(themeCustomizationBO.constructThemeCss(null, ThemeCustomizationConstant.THEMES_MAIN_DIV_ID,
        			null, true, null, appName));
        	    }
        	    else
        	    {
        		// construct the css from the data sent for a repsective class
        		buf.append(cssData);
        	    }
	    }
	    else  // If the theme id is provided then construct the css file from the database
	    {
		// set style Ref = null to get all the styles
		buf.append(themeCustomizationBO.constructThemeCss(themeCustomizationCO.getThemeVO().getTHEME_ID(),
			ThemeCustomizationConstant.THEMES_MAIN_DIV_ID, null, true, null, appName));

	    }
	    
	    byte[] buffer = buf.toString().getBytes();
	    cssStream = new ByteArrayInputStream(buffer);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return ThemeCustomizationConstant.RESULT_CSS;
    }

    /**
     * Called in case default attributes take over changed ones
     * 
     * @return
     */
    public String returnCssFileWithDefault()
    {
	try
	{
	    // check if there is any defaulted class
	    StringBuffer buf = new StringBuffer();
	    String appName = StringUtil.nullEmptyToValue(returnSessionObject().getCurrentAppName(),
		    ConstantsCommon.IMAL_APP_NAME);
	    if(cssScope != null && !cssScope.isEmpty() && getThemeCssStr() != null && !getThemeCssStr().isEmpty())
	    {
		// Converting json string to ThemeCss.class
		ObjectMapper mapper = new ObjectMapper();
		ThemeCss defaultedThemeCss = mapper.readValue(getThemeCssStr(), ThemeCss.class);

		if("1".equals(cssScope))
		{
		    buf.append(themeCustomizationBO.constructThemeCss(
			    themeCustomizationCO.getThemeVO() == null ? null : themeCustomizationCO.getThemeVO().getTHEME_ID()
				    , ThemeCustomizationConstant.THEMES_MAIN_DIV_ID, null, true,
			    defaultedThemeCss, appName));
		}
		else
		{
		    // Get only the ones for the Desktop
		    buf.append(themeCustomizationBO.constructThemeCss(
			    themeCustomizationCO.getThemeVO() == null ? null : themeCustomizationCO.getThemeVO().getTHEME_ID()
				    , ThemeCustomizationConstant.THEMES_MAIN_DIV_ID,
			    ThemeCustomizationConstant.DESKTOP_STYLE_REF, false, defaultedThemeCss, appName));
		}
	    }
	    byte[] buffer = buf.toString().getBytes();
	    cssStream = new ByteArrayInputStream(buffer);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return ThemeCustomizationConstant.RESULT_CSS;
    }

    /**
     * Save the created theme / updated theme into the database
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String saveUserTheme()
    {
	try
	{
	    if(getThemeCssStr() != null && !getThemeCssStr().isEmpty())
	    {
		// Converting json string to ThemeCss.class
		ObjectMapper mapper = new ObjectMapper();
		themeCss = mapper.readValue(getThemeCssStr(), ThemeCss.class);

		themeCustomizationCO.getThemeVO().setUPDATED_BY(returnSessionObject().getUserName());
		themeCustomizationCO.getThemeVO().setUPDATED_DATE(returnSessionObject().getRunningDateRET());

		// creating new theme
		if(themeCustomizationCO.getThemeVO().getTHEME_ID() == null)
		{
		    themeCustomizationCO.getThemeVO().setCREATED_BY(returnSessionObject().getUserName());
		    themeCustomizationCO.getThemeVO().setCREATED_DATE(returnSessionObject().getRunningDateRET());

		}

		// Send the images for save if they are uploaded
		Map<String, byte[]> images = null;
		if(session.containsKey("ImageUploaded"))
		{
		    images = (Map<String, byte[]>) session.get("ImageUploaded");
		}

		// Mark the theme as updated
		themeCustomizationCO.getThemeVO().setIS_UPDATED_YN(BigDecimal.ONE);
		themeCustomizationBO.saveUserTheme(themeCustomizationCO, themeCss, images);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Remove the images from the session
     * 
     * @return
     */
    public String removeImagesFromMemory()
    {
	try
	{
	    // Remove the images from the session
	    session.remove("ImageUploaded");
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Get the css file for the custom theme from the repo
     * 
     * @return
     */
    public String loadCssFromRepository()
    {
	try
	{
	    String appName = StringUtil.nullEmptyToValue(returnSessionObject().getCurrentAppName(),
		    ConstantsCommon.IMAL_APP_NAME);
	    String css = themeCustomizationBO.constructCssInRepository(ThemeCustomizationConstant.DESKTOP_STYLE_REF,
		    appName);
	    // incase it is called from changePwd screen then the namespace will be /pwdChanges (the url needs only one ../) while if it is coming from normal screen.
	    // the namespace will be /path/customization thus it needs ../../ 
	    if(ConstantsCommon.ONE.equals(fromChangePwd) && css!=null) 
	    {
		css = css.replaceAll("../../","../");
	    }
	    cssStream = new ByteArrayInputStream(css.getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return ThemeCustomizationConstant.RESULT_CSS;
    }

    /**
     * Activate the given theme id
     * 
     * @return
     */
    public String activateUserTheme()
    {
	try
	{
	    if(themeCustomizationCO.getThemeVO() != null && themeCustomizationCO.getThemeVO().getTHEME_ID() != null)
	    {
		themeCustomizationBO.activateUserTheme(themeCustomizationCO.getThemeVO());
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * De-Activate the given theme id
     * 
     * @return
     */
    public String deactivateUserTheme()
    {
	try
	{
	    if(themeCustomizationCO.getThemeVO() != null && themeCustomizationCO.getThemeVO().getTHEME_ID() != null)
	    {
		themeCustomizationBO.deactivateUserTheme(themeCustomizationCO.getThemeVO().getTHEME_ID());
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Delete the user theme
     * 
     * @return
     */
    public String deleteUserTheme()
    {
	try
	{
	    if(themeCustomizationCO.getThemeVO() != null && themeCustomizationCO.getThemeVO().getTHEME_ID() != null)
	    {
		themeCustomizationBO.deleteUserTheme(themeCustomizationCO.getThemeVO().getTHEME_ID());
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    private void loadFontFamilyDropDown() throws BaseException
    {
	SelectSC selectSC = new SelectSC(ThemeCustomizationConstant.FF_LOV_TYPE_ID);
	selectSC.setOrderCriteria(ConstantsCommon.LOV_ORDER_VALUE);
	setFontFamilyDropDown(returnLOV(selectSC));
    }

    public String exportScreen()
    {
	try{
	    themeCustomizationCO.setStyleVO(new SYS_PARAM_STYLEVO());
	    themeCustomizationCO.getStyleVO().setSTYLE_REFERENCE(null);
	    List<SYS_THEME_STYLE_ATTRIBUTE_VALVO> themeDetailsData =   themeCustomizationBO.returnThemeDetails(themeCustomizationCO);
	    SYS_THEMEVO themeVO = themeCustomizationBO.returnUserTheme(themeCustomizationCO.getThemeVO().getTHEME_ID());
	   
	    themeCustomizationCO.setThemeDetailsData(themeDetailsData);
	    themeCustomizationCO.setThemeVO(themeVO);
	    String themeDataStr = PathJSONUtil.strutsJsonSerialize(themeCustomizationCO, null, null, false, true);
	    themeDataStr = SecurityUtils.encryptAES(EXPORT_FILE_ENC_PASS,themeDataStr);
	    byte[] resultBytes = themeDataStr.getBytes(FileUtil.DEFAULT_FILE_ENCODING);
	    exportStream = new ByteArrayInputStream(resultBytes);
	    setFileName("Export_ThemeCust_"+themeCustomizationCO.getThemeVO().getTHEME_ID()+".themecust");
	    ServletActionContext.getResponse().setHeader("Set-Cookie", "fileDownload=true; path=/");
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    try
	    {
	    	setErrorStream(new ByteArrayInputStream(get_error().getBytes(FileUtil.DEFAULT_FILE_ENCODING)));
	    }
	    catch(UnsupportedEncodingException e1)
	    {
		   log.error(e1, "Error in reading the error message");
	    }
	    return "fileError";

	}
	return "exported";
    }
    /**
     * @author marwanmaddah
     * @return
     */
    public String openImportDialog()
    {
	return "openImportDialog";
    }
    /**
     * @author MarwanMaddah
     * @return
     */
    public String importScreen()
    {
	try
	{
	    if(uploadFile != null && uploadFile.isFile() && uploadFile.length() > 0)
	    {
		//limit the size of the file to be below of 200 MB = 200000000 bytes 
		byte[] content = PathFileSecure.readFileToByteArray(uploadFile,200000000);
		String result = new String(content);
		String themeDataStr = SecurityUtils.decryptAES(EXPORT_FILE_ENC_PASS, result);
		
		
	        ThemeCustomizationCO themeCustCO = new ThemeCustomizationCO();
	        //TP#1029247 Issue with date parsing when importing theme
	        themeCustCO = (ThemeCustomizationCO) CommonMethods.returnJsonObjectFromStr(ThemeCustomizationCO.class,themeDataStr);
	        if(ConstantsCommon.IMAL_APP_NAME.equals(StringUtil.nullToEmpty(themeCustCO.getThemeVO().getAPP_NAME())))
	        {
	            themeCustCO.setIsGlobal(BigDecimal.ONE);
	        }
	        int themeId = themeCustomizationBO.returnUserThemeExit(themeCustCO.getThemeVO().getTHEME_NAME());
	        if(themeId != 0) 
	        {
	            if(ConstantsCommon.TRUE.equals(themeCustomizationCO.getOverrideCustImport())) 
	            {
	        	themeCustCO.getThemeVO().setTHEME_ID(new BigDecimal(themeId));
	        	themeCustomizationBO.saveUserTheme(themeCustCO, null, null);
	            }else 
	            {
	        	throw new BOException(MessageCodes.THEME_NAME_ALREADY_USED);
	            }
	        }else 
	        {
	            themeCustCO.getThemeVO().setTHEME_ID(null);
	            themeCustomizationBO.saveUserTheme(themeCustCO, null, null);
	        }
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return  ThemeCustomizationConstant.RESULT_FILE_SUCCESS;
    }
    
    /**
     * @param themeCustomizationBO the themeCustomizationBO to set
     */
    public void setThemeCustomizationBO(ThemeCustomizationBO themeCustomizationBO)
    {
	this.themeCustomizationBO = themeCustomizationBO;
    }

    /**
     * @return the themeCustomizationCO
     */
    public ThemeCustomizationCO getThemeCustomizationCO()
    {
	return themeCustomizationCO;
    }

    /**
     * @param themeCustomizationCO the themeCustomizationCO to set
     */
    public void setThemeCustomizationCO(ThemeCustomizationCO themeCustomizationCO)
    {
	this.themeCustomizationCO = themeCustomizationCO;
    }

    /**
     * @param upload the upload to set
     */
    public void setUpload(File upload)
    {
	this.upload = upload;
    }

    /**
     * @return the imageStream
     */
    public InputStream getImageStream()
    {
	return imageStream;
    }

    /**
     * @param imageStream the imageStream to set
     */
    public void setImageStream(InputStream imageStream)
    {
	this.imageStream = imageStream;
    }

    /**
     * @return the cssStream
     */
    public InputStream getCssStream()
    {
	return cssStream;
    }

    /**
     * @param cssStream the cssStream to set
     */
    public void setCssStream(InputStream cssStream)
    {
	this.cssStream = cssStream;
    }

    /**
     * @return the cssData
     */
    public String getCssData()
    {
	return cssData;
    }

    /**
     * @param cssData the cssData to set
     */
    public void setCssData(String cssData)
    {
	this.cssData = cssData;
    }

    /**
     * @return the fontFamilyDropDown
     */
    public List<SelectCO> getFontFamilyDropDown()
    {
	return fontFamilyDropDown;
    }

    /**
     * @param fontFamilyDropDown the fontFamilyDropDown to set
     */
    public void setFontFamilyDropDown(List<SelectCO> fontFamilyDropDown)
    {
	this.fontFamilyDropDown = fontFamilyDropDown;
    }

    /**
     * @return the imageRef
     */
    public String getImageRef()
    {
	return imageRef;
    }

    /**
     * @param imageRef the imageRef to set
     */
    public void setImageRef(String imageRef)
    {
	this.imageRef = imageRef;
    }

    /**
     * @return the themeCss
     */
    public ThemeCss getThemeCss()
    {
	return themeCss;
    }

    /**
     * @param themeCss the themeCss to set
     */
    public void setThemeCss(ThemeCss themeCss)
    {
	this.themeCss = themeCss;
    }

    /**
     * @return the themeCssStr
     */
    public String getThemeCssStr()
    {
	return themeCssStr;
    }

    /**
     * @param themeCssStr the themeCssStr to set
     */
    public void setThemeCssStr(String themeCssStr)
    {
	this.themeCssStr = themeCssStr;
    }

    /**
     * @return the cssScope
     */
    public String getCssScope()
    {
	return cssScope;
    }

    /**
     * @param cssScope the cssScope to set
     */
    public void setCssScope(String cssScope)
    {
	this.cssScope = cssScope;
    }
    
    /**
     * @return the exportStream
     */
    public InputStream getExportStream()
    {
        return exportStream;
    }
    /**
     * @param exportStream the exportStream to set
     */
    public void setExportStream(InputStream exportStream)
    {
        this.exportStream = exportStream;
    }
    /**
     * @return the errorStream
     */
    public InputStream getErrorStream()
    {
        return errorStream;
    }
    /**
     * @param errorStream the errorStream to set
     */
    public void setErrorStream(InputStream errorStream)
    {
        this.errorStream = errorStream;
    }
    /**
     * @return the fileName
     */
    public String getFileName()
    {
        return fileName;
    }
    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    /**
     * @return the uploadFile
     */
    public File getUploadFile()
    {
        return uploadFile;
    }
    /**
     * @param uploadFile the uploadFile to set
     */
    public void setUploadFile(File uploadFile)
    {
        this.uploadFile = uploadFile;
    }

    public String getFromChangePwd()
    {
        return fromChangePwd;
    }

    public void setFromChangePwd(String fromChangePwd)
    {
        this.fromChangePwd = fromChangePwd;
    }
    
}
