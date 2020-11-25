package com.path.actions.common.customization.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.ws.rs.core.MediaType;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.customization.file.FileCustomizationBO;
import com.path.bo.reporting.ReportingConstantsCommon;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;

/**
 * This Action handle all the file customization behaviors such as download
 * files and others ...
 * 
 * @author MohammadAliMezzawi
 *
 */
public class FileCustomizationAction extends BaseAction
{

    /**
     * Hold the file name subject of customization
     */
    private String fileName;

    /**
     * Hold file mime type
     */
    private String mimeType;
    
    /**
     * Hold file content length
     */
    private long contentLength;

    /**
     * Hold Reference to the export stream
     */
    private InputStream exportStream;

    /**
     * Testing Bo reference
     */
    private FileCustomizationBO fileCustomizationBO;

    /**
     * Download the given file.
     */
    public String download()
    {

	try
	{

	    if(StringUtil.isEmptyString(StringUtil.nullToEmpty(fileName)))
		throw new BOException("File can't be empty");

	    // check if file exists
	    StringBuilder sb = new StringBuilder(FileUtil.getFileURLByName(ReportingConstantsCommon.repositoryFolder))
		    .append(File.separator).append(ConstantsCommon.DYNC_FILE_DIR).append(File.separator)
		    .append(fileName);

	    File fileToDownload = new PathFileSecure(sb.toString());

	    // check if file exists
	    if(!fileToDownload.exists())
		throw new BOException(String.format("File %S not found",fileName));

	    /**
	     * Currently in the system we don't have a ABAC control which mean
	     * any user can download any file. When the Access control is
	     * implement a permission check up need to be done here
	     */

	    // open file stream
	    exportStream = new FileInputStream(fileToDownload);

	    // guess mime type
	    String guessMimeType = HttpURLConnection.guessContentTypeFromStream(exportStream);
	    setMimeType(null != guessMimeType ? guessMimeType : MediaType.APPLICATION_OCTET_STREAM );
	    
	    setContentLength(fileToDownload.length());
	    
	}
	catch(Exception e)
	{

	    // handle the exception and populate error message
	    handleException(e, null, null);
	    return "SUCCESS_JSON";
	}

	return "download";
    }

    /**
     * Return the file name subject of the current action
     * 
     * @return
     */
    public String getFileName()
    {
	return fileName;
    }

    /**
     * Set the file name subject of the current action
     * 
     * @param fileName
     */
    public void setFileName(String fileName)
    {
	this.fileName = fileName;
    }

    /**
     * Return file mime type of the File subject of the action
     * 
     * @return the mimeType
     */
    public String getMimeType()
    {
	return mimeType;
    }

    /**
     * @param mimeType the mimeType to set
     */
    public void setMimeType(String mimeType)
    {
	this.mimeType = mimeType;
    }

    /**
     * @return the contentLength
     */
    public long getContentLength()
    {
	return contentLength;
    }

    /**
     * @param contentLength the contentLength to set
     */
    public void setContentLength(long contentLength)
    {
	this.contentLength = contentLength;
    }

    /**
     * OutputStream Getter
     * 
     * @return OutputStream
     */
    public InputStream getExportStream()
    {
	return exportStream;
    }

    /**
     * OutputStream Setter
     * 
     * @param exportStream
     */
    public void setExportStream(InputStream exportStream)
    {
	this.exportStream = exportStream;
    }

    /**
     * @return the fileCustomizationBO
     */
    public FileCustomizationBO getFileCustomizationBO()
    {
	return fileCustomizationBO;
    }

    /**
     * @param fileCustomizationBO the fileCustomizationBO to set
     */
    public void setFileCustomizationBO(FileCustomizationBO fileCustomizationBO)
    {
	this.fileCustomizationBO = fileCustomizationBO;
    }
}
