package com.path.actions.common.filemanagement;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.path.bo.common.dynfiles.DynFilesBO;
import com.path.bo.common.dynfiles.DynFilesConstant;
import com.path.dbmaps.vo.DF_DATA_FILEVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.SecurityUtils;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynfiles.DynFilesDetCO;
import com.path.vo.common.dynfiles.DynFilesImportCO;
import com.path.vo.common.dynfiles.DynFilesMiscSQLListCO;
import com.path.vo.common.dynfiles.DynFilesSC;
import com.path.vo.common.dynfiles.DynFilesTagParametersCO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DynFileMaintAction extends BaseAction
{

    private DynFilesBO dynFilesBO;
    private DynFilesSC dynFilesSC;
    private DynFilesDetCO dynFilesDetCO;
    private File file;
    private DynFilesImportCO dynFilesImportCO;
    private DF_DATA_FILEVO dfDataFileVO;
    private InputStream scriptStream;
    private ArrayList<Boolean> fileOptions;
    private String tagGridJSON;
    private String downloadFileName;

    /**
     * Action called while opening Import Dynamic File
     * 
     * @return
     */
    public String loadDynFileImportPage()
    {
	dynFilesSC = new DynFilesSC();
	dynFilesSC.setStructType("2");
	String dynFileCode = null;
	BigDecimal selctedFileType = null;
	
	
	/** Rania - SQL session tracing R14.1 */
	int maxInactInterv = ServletActionContext.getRequest().getSession().getMaxInactiveInterval();
	int interv = 1200000;
	if(maxInactInterv > 0)
	{
	    // get the 20% of the session timeout value
	    BigDecimal intervPerc = new BigDecimal((maxInactInterv / 5)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
	    interv = (maxInactInterv - intervPerc.intValue()) * 1000;
	}
	
	if(dynFilesDetCO != null && dynFilesDetCO.getDfDataFileVO() != null){
	    
	    dynFileCode = dynFilesDetCO.getDfDataFileVO().getFILE_CODE();
	    selctedFileType = dynFilesDetCO.getSelectedFileType();
	}
 
	    dynFilesDetCO = new DynFilesDetCO();
	    dynFilesDetCO.setNbvCalcSessionTimeOut(interv);
	    dynFilesDetCO.getDfDataFileVO().setFILE_CODE(dynFileCode);
	    dynFilesDetCO.setSelectedFileType(selctedFileType);

	    holdEnableProgressBar();

	return "loadDynFilePage";

    }

    /**
     * DBU190598
     * add a new flag at the level of PathRetRemoting to enable/disable the visibility of progress bar when run a file
     * by default the is 0
     */
    private void holdEnableProgressBar()
    {
	String enableProgressBar = "1";
	try
	{
	    // by default the progress bar is disabled to maintain backward compatibility
	    enableProgressBar = StringUtil.nullEmptyToValue(PathPropertyUtil
		    .returnPathPropertyFromFile("PathRetRemoting.properties", "dynamicFile.progressBar.enable"), "0");
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	ServletActionContext.getRequest().setAttribute("enableProgressBar", enableProgressBar);
    }

    /**
     * Action called while opening Export Dynamic File
     * 
     * @return
     */

    public String loadDynFileExportPage()
    {
	dynFilesSC = new DynFilesSC();
	dynFilesSC.setStructType("1");
	return "loadDynFilePage";
    }

    /**
     * Get the dynfile details corresponding to enquiry file code
     * 
     * @return
     * @throws IOException
     */

    public String loadDynFileDetails() throws IOException
    {

	SessionCO sesCo = returnSessionObject();
	dynFilesSC.setCompCode(sesCo.getCompanyCode());
	dynFilesSC.setBranchCode(sesCo.getBranchCode());
	dynFilesSC.setBaseCurr(sesCo.getBaseCurrencyCode());
	dynFilesSC.setAppName(sesCo.getCurrentAppName());
	dynFilesSC.setSystemDate(sesCo.getRunningDateRET());
	dynFilesSC.setFiscalYear(sesCo.getFiscalYear());
	dynFilesSC.setExposureCurrency(sesCo.getExposCurCode());
	dynFilesSC.setExposureCurrencyName(sesCo.getExposCurName());
	dynFilesSC.setCompName(sesCo.getCompanyName());
	dynFilesSC.setCompNameArab(sesCo.getCompanyArabName());
	dynFilesSC.setBaseCurrDecPoint(sesCo.getBaseCurrDecPoint());
	dynFilesSC.setBaseCurrName(sesCo.getBaseCurrencyName());
	dynFilesSC.setUserId(sesCo.getUserName());

	try
	{
	    dynFilesDetCO = dynFilesBO.returnDynFilesDetails(dynFilesSC);
	    holdEnableProgressBar();
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR_ACTION;
	}
	return "loadDynFileDetails";
    }

    /**
     * Removes the unselected file options from the object
     */
    private void removeUnSelectedFileOptions()
    {
	if(fileOptions != null)
	{
	    ArrayList<DynFilesMiscSQLListCO> deleteFileOpt = new ArrayList<DynFilesMiscSQLListCO>();
	    for(int i = 0; i < fileOptions.size(); i++)
	    {
		if(!fileOptions.get(i))
		{
		    deleteFileOpt.add(dynFilesDetCO.getDfMiscSQLListCO().get(i));
		}
	    }
	    dynFilesDetCO.getDfMiscSQLListCO().removeAll(deleteFileOpt);
	}
    }

    /**
     * Uploads the file and returns the file data to be displayed in the grid
     * 
     * @return
     * @throws Exception
     */
    public String viewFile() throws Exception
    {
	try
	{

	    dynFilesSC.setCompCode(returnSessionObject().getCompanyCode());
	    dynFilesSC.setBranchCode(returnSessionObject().getBranchCode());
	    dynFilesSC.setBaseCurr(returnSessionObject().getBaseCurrencyCode());
	    dynFilesSC.setAppName(returnSessionObject().getCurrentAppName());
	    dynFilesSC.setFileCode(dynFilesDetCO.getDfDataFileVO().getFILE_CODE());
	    dynFilesSC.setStructCode(dynFilesDetCO.getDfFileStructVO().getSTRUCT_CODE());
	    dynFilesSC.setUserId(returnSessionObject().getUserName());
	    dynFilesSC.setSystemDate(returnSessionObject().getRunningDateRET());
	    dynFilesSC.setBatchSystemDate(returnCommonLibBO().returnSystemDateWithTime());
	    removeUnSelectedFileOptions();
	    
	    //decryption of query string BMO Security & Penetration Testing
	    if(dynFilesDetCO != null && dynFilesDetCO.getDfMiscSQLListCO() != null)
	    {
		String sqlText;
		for(int j=0;j<dynFilesDetCO.getDfMiscSQLListCO().size(); j++)
		{
		    if(dynFilesDetCO.getDfMiscSQLListCO().get(j).getDfSrcSQLStructVO() != null)
		    {
			sqlText = dynFilesDetCO.getDfMiscSQLListCO().get(j).getDfSrcSQLStructVO().getSOURCE_SQL_TEXT();
			if(sqlText != null && !sqlText.isEmpty())
			{
			    String decryptedQuery = SecurityUtils.decryptAES(DynFilesConstant.QUERY_STRING_ENCRIPTION, sqlText);
			    
			    dynFilesDetCO.getDfMiscSQLListCO().get(j).getDfSrcSQLStructVO().setSOURCE_SQL_TEXT(decryptedQuery);
			}
		    }
		}
	    }
	    
	    if(dynFilesSC.getProceed() == 0)
	    {
		//limit the size of the file to be below of 200 MB = 200000000 bytes 
		dynFilesImportCO = dynFilesBO.processDynFilesImportView(dynFilesDetCO, dynFilesSC, PathFileSecure.readFileToByteArray(file,200000000));
	    }
	    else
	    {
		dynFilesImportCO = dynFilesBO.continueExecuting(dynFilesSC, dynFilesDetCO);
	    }

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    scriptStream = new ByteArrayInputStream(JSONObject.fromObject(this).toString().getBytes(
		    FileUtil.DEFAULT_FILE_ENCODING));
	    return "downloadError";
	}

	return "loadDynFileGrid";
    }

    /**
     * validate enquiry file code
     * 
     * @return
     */
    public String checkDynFilesFileCode()
    {
	try
	{
	    dynFilesSC.setCompCode(returnSessionObject().getCompanyCode());
	    dynFilesSC.setBranchCode(returnSessionObject().getBranchCode());
	    dynFilesSC.setAppName(returnSessionObject().getCurrentAppName());
	    dynFilesSC.setUserId(returnSessionObject().getUserName());
	    dynFilesSC.setSystemDate(returnSessionObject().getRunningDateRET());
	    dynFilesSC.setProfType(NumberUtil.nullToZero(returnCommonLibBO().returnPthCtrl().getPOP_PROF_MOD_ACCESS()));
	    dynFilesDetCO = dynFilesBO.checkDynFilesFileCode(dynFilesSC);

	    if(dynFilesDetCO == null)
	    {
		dynFilesDetCO = new DynFilesDetCO();
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }

    /**
     * Returns a script file as byte stream
     * 
     * @return
     */
    public String saveScript() throws Exception
    {
	try
	{
	    dynFilesSC.setCompCode(returnSessionObject().getCompanyCode());
	    dynFilesSC.setBranchCode(returnSessionObject().getBranchCode());
	    dynFilesSC.setBaseCurr(returnSessionObject().getBaseCurrencyCode());
	    dynFilesSC.setAppName(returnSessionObject().getCurrentAppName());
	    dynFilesSC.setUserId(returnSessionObject().getUserName());
	    dynFilesSC.setSystemDate(returnSessionObject().getRunningDateRET());
	    byte[] scriptByte = dynFilesBO.saveScript(dynFilesSC);
	    if(scriptByte==null)
	    {
		return null;
	    }
	    scriptStream = new ByteArrayInputStream(scriptByte);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    scriptStream = new ByteArrayInputStream(JSONObject.fromObject(this).toString().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    return "downloadError";
	}

	return "saveScript";
    }

    /**
     * Return execution log as byte stream
     * 
     * @return
     */
    public String saveExecutionLog() throws Exception
    {
	try
	{
	    dynFilesSC.setCompCode(returnSessionObject().getCompanyCode());
	    dynFilesSC.setBranchCode(returnSessionObject().getBranchCode());
	    dynFilesSC.setBaseCurr(returnSessionObject().getBaseCurrencyCode());
	    dynFilesSC.setAppName(returnSessionObject().getCurrentAppName());
	    dynFilesSC.setUserId(returnSessionObject().getUserName());
	    dynFilesSC.setSystemDate(returnSessionObject().getRunningDateRET());
	    byte[] scriptByte = dynFilesBO.saveExecutionLog(dynFilesSC);
	    scriptStream = new ByteArrayInputStream(scriptByte);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    scriptStream = new ByteArrayInputStream(JSONObject.fromObject(this).toString().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    return "downloadError";
	}

	return "saveExecLog";
    }

    /**
     * check If File uploaded Is valid
     * 
     * @return
     */
    public String checkIfFileIsvalid() throws Exception
    {
	try
	{
	    String fileSizeLimit = null;
	    try
	    {
		fileSizeLimit = PathPropertyUtil.returnPathPropertyFromFile("PathRetRemoting.properties",DynFilesConstant.FILESIZE_LIMIT);
	    }
	    catch(Exception e1)
	    {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    if(fileSizeLimit !=null && ((double) file.length() > (double) Math.round(Integer.parseInt(fileSizeLimit.trim()) * 1000000)))
	    {
		throw new BOException("File size exceeds the limit");
	    }
	    dynFilesImportCO = new DynFilesImportCO();
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR;
	}
	
	return SUCCESS;
    }
    
    /**
     * Run the script
     * 
     * @return
     */
    public String runScript()
    {
	try
	{
	    dynFilesSC.setCompCode(returnSessionObject().getCompanyCode());
	    dynFilesSC.setBranchCode(returnSessionObject().getBranchCode());
	    dynFilesSC.setBaseCurr(returnSessionObject().getBaseCurrencyCode());
	    dynFilesSC.setAppName(returnSessionObject().getCurrentAppName());
	    dynFilesSC.setUserId(returnSessionObject().getUserName());
	    dynFilesSC.setSystemDate(returnSessionObject().getRunningDateRET());
	    dynFilesSC.setFileCode(dynFilesDetCO.getDfDataFileVO().getFILE_CODE());
	    dynFilesSC.setStructCode(dynFilesDetCO.getDfFileStructVO().getSTRUCT_CODE());
	    removeUnSelectedFileOptions();
	    
	    //decryption of query string BMO Security & Penetration Testing
	    if(dynFilesDetCO != null && dynFilesDetCO.getDfMiscSQLListCO() != null)
	    {
		String sqlText;
		for(int j=0;j<dynFilesDetCO.getDfMiscSQLListCO().size(); j++)
		{
		    if(dynFilesDetCO.getDfMiscSQLListCO().get(j).getDfSrcSQLStructVO() != null)
		    {
			sqlText = dynFilesDetCO.getDfMiscSQLListCO().get(j).getDfSrcSQLStructVO().getSOURCE_SQL_TEXT();
			if(sqlText != null && !sqlText.isEmpty())
			{
			    String decryptedQuery = SecurityUtils.decryptAES(DynFilesConstant.QUERY_STRING_ENCRIPTION, sqlText);
			    
			    dynFilesDetCO.getDfMiscSQLListCO().get(j).getDfSrcSQLStructVO().setSOURCE_SQL_TEXT(decryptedQuery);
			}
		    }
		}
	    }
	    
	    if(dynFilesSC.getProceed() == 0)
	    {
		dynFilesBO.runExecuteScript(dynFilesSC, dynFilesDetCO,PathFileSecure.readFileToByteArray(file,200000000));
	    }
	    else
	    {
		dynFilesImportCO = dynFilesBO.continueExecuting(dynFilesSC, dynFilesDetCO);
//			scriptStream = new ByteArrayInputStream("<pre>{}</pre>".getBytes());
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);	
//			scriptStream =  new ByteArrayInputStream(JSONObject.fromObject(this).toString().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	}
	return SUCCESS;
    }

    public String generateFileExport() throws Exception
    {
	try
	{
	    if(tagGridJSON!=null) //input tags are available
	    {
		dynFilesDetCO.setDfFileTagParametersCO((ArrayList<DynFilesTagParametersCO>) JSONArray.toCollection(
			JSONArray.fromObject(tagGridJSON), DynFilesTagParametersCO.class));
	    }
	    dynFilesSC.setCompCode(returnSessionObject().getCompanyCode());
	    dynFilesSC.setBranchCode(returnSessionObject().getBranchCode());
	    dynFilesSC.setBaseCurr(returnSessionObject().getBaseCurrencyCode());
	    dynFilesSC.setAppName(returnSessionObject().getCurrentAppName());
	    dynFilesSC.setFileCode(dynFilesDetCO.getDfDataFileVO().getFILE_CODE());
	    dynFilesSC.setStructCode(dynFilesDetCO.getDfFileStructVO().getSTRUCT_CODE());
	    dynFilesSC.setUserId(returnSessionObject().getUserName());
	    dynFilesSC.setSystemDate(returnSessionObject().getRunningDateRET());
	    removeUnSelectedFileOptions();
	    //FIBSI180509 - CSM-File management display incorrect file name by adding this (.xml,)
	    if(dynFilesDetCO.getDfFileStructVO().getFILE_EXT().toLowerCase().split(",").length > 1)
	    {
		downloadFileName = dynFilesDetCO.getDfDataFileVO().getFILE_NAME()
    		    + dynFilesDetCO.getDfFileStructVO().getFILE_EXT().toLowerCase().trim().split(",")[0];
	    }
	    else
	    {
		downloadFileName = dynFilesDetCO.getDfDataFileVO().getFILE_NAME()
        		    + dynFilesDetCO.getDfFileStructVO().getFILE_EXT().toLowerCase().trim();
	    }
	    
	    //decryption of query string BMO Security & Penetration Testing
	    if(dynFilesDetCO != null && dynFilesDetCO.getDfMiscSQLListCO() != null)
	    {
		String sqlText;
		for(int j=0;j<dynFilesDetCO.getDfMiscSQLListCO().size(); j++)
		{
		    if(dynFilesDetCO.getDfMiscSQLListCO().get(j).getDfSrcSQLStructVO() != null)
		    {
			sqlText = dynFilesDetCO.getDfMiscSQLListCO().get(j).getDfSrcSQLStructVO().getSOURCE_SQL_TEXT();
			if(sqlText != null && !sqlText.isEmpty())
			{
			    String decryptedQuery = SecurityUtils.decryptAES(DynFilesConstant.QUERY_STRING_ENCRIPTION, sqlText);
			    
			    dynFilesDetCO.getDfMiscSQLListCO().get(j).getDfSrcSQLStructVO().setSOURCE_SQL_TEXT(decryptedQuery);
			}
		    }
		}
	    }
	    
	    byte[] scriptByte = dynFilesBO.processDynFilesGenerateExport(dynFilesDetCO, dynFilesSC);
	    if(FileUtil.checkIfZip(scriptByte))
	    {
		renameFileExtension();
	    }
	    scriptStream = new ByteArrayInputStream(scriptByte);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    scriptStream = new ByteArrayInputStream(JSONObject.fromObject(this).toString().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    return "downloadError";
	}
	ServletActionContext.getResponse().setHeader("Set-Cookie", "fileDownload=true; path=/");
	return "generateFileExport";
    }

    /**
     * 864566 : this method is used to rename the file so that it would be downloaded as zip file
     */
    private void renameFileExtension()
    {
	int lastIndex = downloadFileName.lastIndexOf(".");
	String extension = downloadFileName.substring(lastIndex , downloadFileName.length());
	downloadFileName = downloadFileName.replace(extension, ".zip");
    }

    /** Rania - SQL session tracing R14.1 */
    public void refreshDual()
    {
	try
	{
	    dynFilesBO.refreshDual();
	}
	catch(Exception e)
	{

	    handleException(e, null, null);

	}
	
    }

    public void setDynFilesBO(DynFilesBO dynFilesBO)
    {
	this.dynFilesBO = dynFilesBO;
    }

    public DynFilesSC getDynFilesSC()
    {
	return dynFilesSC;
    }

    public void setDynFilesSC(DynFilesSC dynFileSC)
    {
	this.dynFilesSC = dynFileSC;
    }

    public DynFilesDetCO getDynFilesDetCO()
    {
	return dynFilesDetCO;
    }

    public void setDynFilesDetCO(DynFilesDetCO dynFilesDetCO)
    {
	this.dynFilesDetCO = dynFilesDetCO;
    }

    public void setUpload(File file)
    {
	this.file = file;
    }

    public DynFilesImportCO getDynFilesImportCO()
    {
	return dynFilesImportCO;
    }

    public void setDynFilesImportCO(DynFilesImportCO dynFilesImportCO)
    {
	this.dynFilesImportCO = dynFilesImportCO;
    }

    public InputStream getScriptStream()
    {
	return scriptStream;
    }

    public void setScriptStream(InputStream scriptStream)
    {
	this.scriptStream = scriptStream;
    }

    @Override
    public Object getModel()
    {
	return dynFilesImportCO;
    }

    public DF_DATA_FILEVO getDfDataFileVO()
    {
	return dfDataFileVO;
    }

    public void setDfDataFileVO(DF_DATA_FILEVO dfDataFileVO)
    {
	this.dfDataFileVO = dfDataFileVO;
    }

    public ArrayList<Boolean> getFileOptions()
    {
	return fileOptions;
    }

    public void setFileOptions(ArrayList<Boolean> fileOptions)
    {
	this.fileOptions = fileOptions;
    }

    public void setTagGridJSON(String tagGridJSON)
    {
	this.tagGridJSON = tagGridJSON;
    }

    public String getTagGridJSON()
    {
	return tagGridJSON;
    }

    public String getDownloadFileName()
    {
	return downloadFileName;
    }

    public void setDownloadFileName(String downloadFileName)
    {
	this.downloadFileName = downloadFileName;
    }

}
