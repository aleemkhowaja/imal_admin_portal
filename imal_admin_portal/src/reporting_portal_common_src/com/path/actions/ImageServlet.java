package com.path.actions;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.reporting.CommonReportingBO;
import com.path.lib.common.util.ApplicationContextProvider;
import com.path.lib.log.Log;

public class ImageServlet extends HttpServlet
{
    private final static Log log = Log.getInstance();

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
	try
	{
	    String fileName = request.getParameter("image");
	    String deleteImg = request.getParameter("deleteImg");
	    String reportFormat = request.getParameter("reportFormat");
	    CommonReportingBO commonReportingBO = (CommonReportingBO) ApplicationContextProvider.getApplicationContext().getBean("commonReportingBO");
	    byte[] data = commonReportingBO.loadImage(fileName, deleteImg);

	    response.setContentLength(data.length);
	    ServletOutputStream ouputStream = response.getOutputStream();
	    if(ConstantsCommon.HTML_REP_FORMAT.equalsIgnoreCase(reportFormat))
	    {
		String photoType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toUpperCase();
		if(!((ConstantsCommon.PHOTO_EXTENSION_JPEG.equals(photoType))
			|| (ConstantsCommon.PHOTO_EXTENSION_PNG.equals(photoType))
			|| (ConstantsCommon.PHOTO_EXTENSION_BMP.equals(photoType))
			|| (ConstantsCommon.PHOTO_EXTENSION_GIF.equals(photoType))))
		{
		    photoType = ConstantsCommon.PHOTO_EXTENSION_JPEG;
		}
		response.setContentType("image/" + photoType.toLowerCase(Locale.ENGLISH));
	    }
	    // For pie charts and blob images
	    else if(null == reportFormat)
	    {
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
		String mimeType = HttpURLConnection.guessContentTypeFromStream(is);
		response.setContentType(mimeType == null ? ConstantsCommon.PHOTO_EXTENSION_PNG : mimeType);
	    }
	    ouputStream.write(data, 0, data.length);
	    ouputStream.flush();
	    ouputStream.close();
	}
	catch(Exception e)
	{
	    log.error(e, e.getMessage());
	}
    }
}
