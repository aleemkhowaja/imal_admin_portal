package com.path.bo.reporting;

import java.io.File;

import com.path.lib.common.util.FileUtil;
import com.path.lib.log.Log;

public final class ReportingFileUtil
{
    private static final Log log = Log.getInstance();
    private ReportingFileUtil() 
    {
	log.error("This Class Should not be Instantiated");
    }

    public static String getReportingRepoPath(String name)
    {
	String repositoryPath = FileUtil.getFileURLByName(name);
	String reportingPath = repositoryPath + File.separator + ReportingConstantsCommon.reportingFolder;
	try
	{
	    if(!FileUtil.existFile(reportingPath))
	    {
	        FileUtil.makeDirectories(reportingPath);
	    }
	}
	catch(Exception e)
	{
	    log.error("Error in checking the reporting folder path under repository");
	}
	return reportingPath;
    }
}
