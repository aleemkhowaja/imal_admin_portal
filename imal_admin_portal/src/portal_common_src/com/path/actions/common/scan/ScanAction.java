package com.path.actions.common.scan;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.path.bo.common.ConstantsCommon;
import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class ScanAction extends BaseAction
{
    private InputStream scriptStream;
    private String imgName, language, imgSide, imgNameFront, imgNameRear, micrLine, imgB64Data, folderName;

    // ///PANINI DEVICE METHODS//////////////////////////////
    /* method to receive and save panini cheque images */ 
    public String savePaniniImage() throws Exception
    {
    	try
    	{
    		String s;
    		String imagePath, repositoryPath, fileName, eMsg;

    		// get repository path
    		repositoryPath = FileUtil.getFileURLByName("repository");

    		// define image path
    		imagePath = repositoryPath + "/" + ConstantsCommon.PANINI_PATH + "/" + folderName + "/";

    		// Create any missing directories
    		boolean mkDir = new PathFileSecure(imagePath).mkdirs();
    		log.debug("the directory " + imagePath + " creation result is " + mkDir);

    		// create image full name
    		fileName = imagePath + getImgName()+ "_" + getImgSide() + ConstantsCommon.PANINI_EXT;

    		String incoming = imgB64Data.replace('_', '/').replace('-', '+');
    		switch(imgB64Data.length() % 4) {
    		case 2: incoming += "=="; break;
    		case 3: incoming += "="; break;
    		}
    		byte[] imageBytes = Base64.getDecoder().decode(incoming);
    		Path destinationFile = Paths.get(fileName);
    		Files.write(destinationFile, imageBytes);
    		boolean available = (imageBytes != null && imageBytes.length>0) ? true : false;

    		PrintWriter printWriter = null;
    		String txtFile = imagePath +  imgName + "." + ConstantsCommon.TXT_EXT;
    		PathFileSecure file = new PathFileSecure(txtFile);
    		synchronized(file.getCanonicalPath().intern()) {
    			try
        		{  
        			String content;

        			if(file.exists())
        			{
        				content = FileUtil.readFile(txtFile, ConstantsCommon.ENCODING_TYPE_UTF);
        				JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(content);
        				if(null == jsonFilter.get(imgName))
        				{
        					jsonFilter.put(imgName, new String[] { getImgName()+ "_" + getImgSide() + ConstantsCommon.PANINI_EXT });
        				}
        				else
        				{
        					jsonFilter.getJSONArray(imgName).add(getImgName()+ "_" + getImgSide() + ConstantsCommon.PANINI_EXT);
        					jsonFilter.getJSONArray(imgName).add(micrLine);		
        				}
        				content = PathJSONUtil.serialize(jsonFilter);
        			}
        			else
        			{
        				content = "{\"" + imgName + "\" : ['" + getImgName()+ "_" + getImgSide() + ConstantsCommon.PANINI_EXT + "']}";
        			}
        			printWriter = new PrintWriter(new PathFileSecure(txtFile));
        			// Create File if not exists , overriwe if exists
        			file.createNewFile();
        			printWriter.write(content);
        		}	   
        		catch(IOException ioex)
        		{
        			log.error(ioex, "Error In Encoding savePathTwainImage");
        			throw ioex;
        		}
        		finally
        		{
        			if(printWriter != null)
        			{
        				printWriter.flush();
        				printWriter.close();
        			}
        		}
    		}
			//Files.write(Paths.get(txtFile), "", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    		



    		// return response a XML string to the ActiveX object
    		if(available)
    		{
    			eMsg = "Success";//returnCommonLibBO().returnTranslErrorMessage(MessageCodes.SCAN_COMPLETE, language);

    			s = "<scannedObject><image result='" + eMsg + "' name='" + getImgName()
    			+ "'></image><title>Panini Cheque Imaging</title></scannedObject>";
    			scriptStream = new ByteArrayInputStream(s.getBytes(FileUtil.DEFAULT_FILE_ENCODING));
    		}
    		else
    		{
    			eMsg = "Error";//returnCommonLibBO().returnTranslErrorMessage(MessageCodes.SCAN_ERROR, language);
    			s = "<scannedObject><image result='" + eMsg + "' name=''"
    					+ "><title>Panini Cheque Imaging</title></image></scannedObject>";
    			scriptStream = new ByteArrayInputStream(s.getBytes(FileUtil.DEFAULT_FILE_ENCODING));
    		}
    	}
    	catch(RuntimeException e)
    	{
    		throw e;
    	}
    	catch(Exception e)
    	{
    		String sE = "<scannedObject><image result='Error' name=''></image><title>Panini Cheque Imaging</title></scannedObject>";
    		try
    		{
    			scriptStream = new ByteArrayInputStream(sE.getBytes(FileUtil.DEFAULT_FILE_ENCODING));
    		}
    		catch(UnsupportedEncodingException ex)
    		{
    			log.error(ex, "Error In Encoding savePaniniImage");
    			throw ex;
    		}
    		throw e;
    	}
    	return "scanSuccess";
    }
    
    public String saveTWAINCheque() throws Exception
    {
    	try
    	{
    		String s;
    		String imagePath, repositoryPath, fileName, eMsg;

    		// get repository path
    		repositoryPath = FileUtil.getFileURLByName("repository");

    		// define image path
    		imagePath = repositoryPath + "/" + ConstantsCommon.TWAIN_PATH + "/" + folderName + "/";

    		// Create any missing directories
    		boolean mkDir = new PathFileSecure(imagePath).mkdirs();
    		log.debug("the directory " + imagePath + " creation result is " + mkDir);

    		// create image full name
    		fileName = imagePath + getImgName()+ "_" + getImgSide() + ConstantsCommon.PANINI_EXT;

    		String incoming = imgB64Data.replace('_', '/').replace('-', '+');
    		switch(imgB64Data.length() % 4) {
    		case 2: incoming += "=="; break;
    		case 3: incoming += "="; break;
    		}
    		byte[] imageBytes = Base64.getDecoder().decode(incoming);
    		Path destinationFile = Paths.get(fileName);
    		Files.write(destinationFile, imageBytes);
    		boolean available = (imageBytes != null && imageBytes.length>0) ? true : false;

    		PrintWriter printWriter = null;
    		String txtFile = imagePath +  imgName + "." + ConstantsCommon.TXT_EXT;

    		PathFileSecure file = new PathFileSecure(txtFile);
    		synchronized(file.getCanonicalPath().intern()) {
    			try
        		{  
        			String content;

        			if(file.exists())
        			{
        				content = FileUtil.readFile(txtFile, ConstantsCommon.ENCODING_TYPE_UTF);
        				JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(content);
        				if(null == jsonFilter.get(imgName))
        				{
        					jsonFilter.put(imgName, new String[] { getImgName()+ "_" + getImgSide() + ConstantsCommon.PANINI_EXT });
        				}
        				else
        				{
        					jsonFilter.getJSONArray(imgName).add(getImgName()+ "_" + getImgSide() + ConstantsCommon.PANINI_EXT);
        					jsonFilter.getJSONArray(imgName).add(micrLine);		
        				}
        				content = PathJSONUtil.serialize(jsonFilter);
        			}
        			else
        			{
        				content = "{\"" + imgName + "\" : ['" + getImgName()+ "_" + getImgSide() + ConstantsCommon.PANINI_EXT + "']}";
        			}
        			printWriter = new PrintWriter(new PathFileSecure(txtFile));
        			// Create File if not exists , overriwe if exists
        			file.createNewFile();
        			printWriter.write(content);
        		}	   
        		catch(IOException ioex)
        		{
        			log.error(ioex, "Error In Encoding savePathTwainImage");
        			throw ioex;
        		}
        		finally
        		{
        			if(printWriter != null)
        			{
        				printWriter.flush();
        				printWriter.close();
        			}
        		}
    		}

    		// return response a XML string to the ActiveX object
    		if(available)
    		{
    			eMsg = "Success";//returnCommonLibBO().returnTranslErrorMessage(MessageCodes.SCAN_COMPLETE, language);

    			s = "<scannedObject><image result='" + eMsg + "' name='" + getImgName()
    			+ "'></image><title>Panini Cheque Imaging</title></scannedObject>";
    			scriptStream = new ByteArrayInputStream(s.getBytes(FileUtil.DEFAULT_FILE_ENCODING));
    		}
    		else
    		{
    			eMsg = "Error";//returnCommonLibBO().returnTranslErrorMessage(MessageCodes.SCAN_ERROR, language);
    			s = "<scannedObject><image result='" + eMsg + "' name=''"
    					+ "></image><title>Panini Cheque Imaging</title></scannedObject>";
    			scriptStream = new ByteArrayInputStream(s.getBytes(FileUtil.DEFAULT_FILE_ENCODING));
    		}
    	}
    	catch(RuntimeException e)
    	{
    		throw e;
    	}
    	catch(Exception e)
    	{
    		String sE = "<scannedObject><image result='Error' name=''></image><title>Panini Cheque Imaging</title></scannedObject>";
    		try
    		{
    			scriptStream = new ByteArrayInputStream(sE.getBytes(FileUtil.DEFAULT_FILE_ENCODING));
    		}
    		catch(UnsupportedEncodingException ex)
    		{
    			log.error(ex, "Error In Encoding savePaniniImage");
    			throw ex;
    		}
    		throw e;
    	}
    	return "scanSuccess";
    }
    /**
     * Method to write Scanned Images in jsp page
     */
    public String previewPaniniImg()
    {
	return "scanned";
    }
    /**
     * Method to write Panini Images in jsp page
     */
    public void loadPaniniImages()
    {
	try
	{
	    String repositoryPath, fileName;
	    repositoryPath = FileUtil.getFileURLByName("repository");
	    fileName = repositoryPath + imgName;

	    RandomAccessFile f = new RandomAccessFile(fileName, "r");
	    byte[] b = new byte[(int) f.length()];
	    int nbRead = f.read(b);
	    log.debug("number of bytes read in loadPaniniImages is : " + nbRead);
	    f.close();

	    HttpServletResponse response = ServletActionContext.getResponse();
	    setServletResponse(response);
	    response.setContentType("image/jpeg");
	    response.getOutputStream().write(b);
	    response.getOutputStream().flush();
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
    }
    // ///PANINI DEVICE METHODS//////////////////////////////
    /* method to receive and save panini cheque images */

   /*
    * set file name
    */
    protected String returnFileName() throws Exception
    {
	    String imagePath, repositoryPath;

	    // get repository path
	    repositoryPath = FileUtil.getFileURLByName("repository");

	    // define image path
	    imagePath = repositoryPath + "/" + ConstantsCommon.SCANNED_PATH + "/";

	    // Create any missing directories
	    boolean mkDir = new PathFileSecure(imagePath).mkdirs();
	    log.debug("the directory " + imagePath + " creation result is " + mkDir);

	    // create image full name
	    return imagePath + getImgName() + ConstantsCommon.SCANNED_EXT;
    }
    
    /*
     * Unsecured saveImage() method called by the ActiveX object Receives input
     * stream HTTP request (the image scanned object from the ActiveX), imgName
     * (the image name from JavaScript "Scan.js") and Save the stream as an
     * image file in the repository.
     */
    public String saveImage()
    {
	try
	{
	    String fileName, eMsg;

	    fileName = returnFileName();

		// create image full name
	    String incoming = imgB64Data.replace('_', '/').replace('-', '+');
		switch(imgB64Data.length() % 4) {
		case 2: incoming += "=="; break;
		case 3: incoming += "="; break;
		}
		byte[] imageBytes = Base64.getDecoder().decode(incoming);
		Path destinationFile = Paths.get(fileName);
		Files.write(destinationFile, imageBytes);
		boolean available = (imageBytes != null && imageBytes.length>0) ? true : false;
	    
	    // get the input stream
	    String s;

	    // return response a XML string to the ActiveX object
	    if(available)
	    {
		eMsg = "Sucess";//returnCommonLibBO().returnTranslErrorMessage(MessageCodes.SCAN_COMPLETE, language);

		s = "<scannedObject><image result='" + eMsg + "' name='" + getImgName()
			+ "'></image><title>Dynamic web TWAIN</title></scannedObject>";
		scriptStream = new ByteArrayInputStream(s.getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    }
	    else
	    {
		eMsg = "Error";//returnCommonLibBO().returnTranslErrorMessage(MessageCodes.SCAN_ERROR, language);
		s = "<scannedObject><image result='" + eMsg
			+ "' name=''></image><title>Dynamic web TWAIN</title></scannedObject>";
		scriptStream = new ByteArrayInputStream(s.getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    }

	}
	catch(RuntimeException e)
	{
	    throw e;
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	    String sE = null;
		sE = "<scannedObject><image result='Error' name=''></image><title>Dynamic web TWAIN</title></scannedObject>";
	    try
	    {
		scriptStream = new ByteArrayInputStream(sE.getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    }
	    catch(UnsupportedEncodingException ex)
	    {
		log.error(ex, "Error In Encoding saveImage");
	    }
	}
	return "scanSuccess";
    }

    /*
     * Secured method checkImage() Checks if an image with the specified imgName
     * exist and if yes returns true and stores the image name in the session
     * object else returns false
     */
    public boolean checkImage()
    {
	try
	{
	    String imagePath, repositoryPath, fileName;
	    repositoryPath = FileUtil.getFileURLByName("repository");
	    imagePath = repositoryPath + "/" + ConstantsCommon.SCANNED_PATH + "/";

	    fileName = imagePath + getImgName() + ConstantsCommon.SCANNED_EXT;

	    // check if such file exist
	    if(!FileUtil.existFile(fileName))
	    {
		return false;
	    }
	    // store the image name in the session object
	    SessionCO sessionCO = returnSessionObject();
	    sessionCO.addScannedImg(getImgName(), fileName);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return true;
    }

    /**
     * Method to write Scanned Images in jsp page
     */
    public void loadPreviewImage()
    {
	try
	{
	    String imagePath, repositoryPath, fileName;
	    repositoryPath = FileUtil.getFileURLByName("repository");
	    imagePath = repositoryPath + "/" + ConstantsCommon.SCANNED_PATH + "/";
	    fileName = imagePath + imgName + ConstantsCommon.SCANNED_EXT;

	    RandomAccessFile f = new RandomAccessFile(fileName, "r");
	    byte[] b = new byte[(int) f.length()];
	    int nbRead = f.read(b);
	    log.debug("number of bytes read in loadPreviewImage is : " + nbRead);
	    f.close();

	    HttpServletResponse response = ServletActionContext.getResponse();
	    setServletResponse(response);
	    response.setContentType("image/jpeg");
	    response.getOutputStream().write(b);
	    response.getOutputStream().flush();
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
    }

    public InputStream getScriptStream()
    {
	return scriptStream;
    }

    public void setScriptStream(InputStream scriptStream)
    {
	this.scriptStream = scriptStream;
    }

    public String getImgName()
    {
	return imgName;
    }

    public void setImgName(String imgName)
    {
	this.imgName = imgName;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public String getImgSide()
    {
        return imgSide;
    }

    public void setImgSide(String imgSide)
    {
        this.imgSide = imgSide;
    }

    public String getImgNameFront()
    {
        return imgNameFront;
    }

    public void setImgNameFront(String imgNameFront)
    {
        this.imgNameFront = imgNameFront;
    }

    public String getImgNameRear()
    {
        return imgNameRear;
    }

    public void setImgNameRear(String imgNameRear)
    {
        this.imgNameRear = imgNameRear;
    }

    public String getMicrLine()
    {
        return micrLine;
    }

    public void setMicrLine(String micrLine)
    {
        this.micrLine = micrLine;
    }

    public String getImgB64Data()
    {
	return imgB64Data;
    }

    public void setImgB64Data(String imgB64Data)
    {
	this.imgB64Data = imgB64Data;
    }

    public String getFolderName()
    {
        return folderName;
    }

    public void setFolderName(String folderName)
    {
        this.folderName = folderName;
    }

}
