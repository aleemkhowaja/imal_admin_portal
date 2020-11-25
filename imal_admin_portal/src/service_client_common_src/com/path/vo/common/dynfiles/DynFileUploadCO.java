package com.path.vo.common.dynfiles;

import java.io.File;

/**
 * 
 * @author EliasAoun
 *
 */
public class DynFileUploadCO extends DynFilesDetCO
{
    private String userName;
    private File uploadedFile;

    public String getUserName()
    {
	return userName;
    }

    public void setUserName(String userName)
    {
	this.userName = userName;
    }

    public File getUploadedFile()
    {
	return uploadedFile;
    }

    public void setUploadedFile(File uploadedFile)
    {
	this.uploadedFile = uploadedFile;
    }

}
