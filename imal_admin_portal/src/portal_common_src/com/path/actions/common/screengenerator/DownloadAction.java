/**
 * 
 */
package com.path.actions.common.screengenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.path.lib.common.util.FileUtil;
import com.path.lib.common.util.PathFileSecure;
import com.path.struts2.lib.common.base.BaseAction;

/**
 * @author marwanmaddah
 *
 */
public class DownloadAction extends BaseAction
{		 
		private InputStream fileInputStream;
	 
		public InputStream getFileInputStream() 
		{
			return fileInputStream;
		}
	 
		@Override
		public String execute() throws Exception 
		{
		  try 
			{
			  String repPath  = FileUtil.getFileURLByName("repository");
			  File newF       = new PathFileSecure(repPath+"\\ProfileModelMaint.jsp");
              fileInputStream = new FileInputStream(newF);
			}
			catch(Exception ex){
					  ex.printStackTrace();
			}			    
			return "success";
	   }

		/**
		 * @param fileInputStream the fileInputStream to set
		 */
	   public void setFileInputStream(InputStream fileInputStream) 
	   {
			this.fileInputStream = fileInputStream;
	   }	
}
