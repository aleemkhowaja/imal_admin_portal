package com.path.actions.common.filemanagement;

import java.util.ArrayList;

import org.apache.struts2.json.JSONException;

import com.path.bo.common.dynfiles.DynFilesBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.dynfiles.DynFilesImportCO;
import com.path.vo.common.dynfiles.DynFilesSC;
import com.path.vo.common.dynfiles.DynFilesTagParametersCO;

public class DynFileGridAction extends GridBaseAction {

	private DynFilesBO dynFilesBO;
	private DynFilesSC dynFilesSC;

	public String loadDynFilesData() throws JSONException {
		try {

			dynFilesSC.setStructType("2");
			dynFilesSC.setCompCode(returnSessionObject().getCompanyCode());
			dynFilesSC.setBranchCode(returnSessionObject().getBranchCode());
			dynFilesSC.setBaseCurr(returnSessionObject().getBaseCurrencyCode());
			dynFilesSC.setAppName(returnSessionObject().getCurrentAppName());
			// dynFilesSC.setFileCode(dynFilesDetCO.getDfDataFileVO().getFILE_CODE());
			// dynFilesSC.setStructCode(dynFilesDetCO.getDfFileStructVO().getSTRUCT_CODE());
			
	 
			dynFilesSC.setRowRange(getRows());			
			dynFilesSC.setFromRow((getRows()*(getPage() - 1))+1);
			dynFilesSC.setUserId(returnSessionObject().getUserName());
			dynFilesSC.setProfType(NumberUtil.nullToZero(returnCommonLibBO().returnPthCtrl().getPOP_PROF_MOD_ACCESS()));
			/** temp **/
			//dynFilesSC.setFileType("3");
			/** temp **/

			copyproperties(dynFilesSC);		     
			if(checkNbRec(dynFilesSC))
			{
				setRecords(dynFilesBO.returnDynFilesRowsCount(dynFilesSC));
			}
			
			DynFilesImportCO dynFilesImportCO = dynFilesBO.returnRowsToGrid(dynFilesSC);			 
			setGridModel(dynFilesImportCO.getRowMapList());

		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	
	public String loadTagValues()throws BaseException{			 
		dynFilesSC.setCompCode(returnSessionObject().getCompanyCode());
		dynFilesSC.setBranchCode(returnSessionObject().getBranchCode());
		dynFilesSC.setBaseCurr(returnSessionObject().getBaseCurrencyCode());
		dynFilesSC.setAppName(returnSessionObject().getCurrentAppName());
		copyproperties(dynFilesSC);	
		ArrayList<DynFilesTagParametersCO> dynFilesTagValues = dynFilesBO.getDynFilesTagParameterValuesList(dynFilesSC);		
		setGridModel(dynFilesTagValues);
		return SUCCESS;
		
	}

	public void setDynFilesBO(DynFilesBO dynFilesBO) {
		this.dynFilesBO = dynFilesBO;
	}

	public DynFilesSC getDynFilesSC() {
		return dynFilesSC;
	}

	public void setDynFilesSC(DynFilesSC dynFilesSC) {
		this.dynFilesSC = dynFilesSC;
	}

}
