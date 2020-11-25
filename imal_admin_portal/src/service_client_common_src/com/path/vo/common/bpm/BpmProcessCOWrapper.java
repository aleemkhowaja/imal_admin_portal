package com.path.vo.common.bpm;

import com.path.struts2.lib.common.BaseObject;

public abstract class BpmProcessCOWrapper extends BaseObject
{
    private boolean showStartBtn;
    private boolean showProcessImageBtn;
    private boolean showExportDocBtn;
    private boolean showDocUploadBtn;
    private boolean showDocDownloadBtn;
    private boolean showDocDeleteBtn;

    public boolean isShowStartBtn()
    {
	return showStartBtn;
    }

    public void setShowStartBtn(boolean showStartBtn)
    {
	this.showStartBtn = showStartBtn;
    }

    public boolean isShowProcessImageBtn()
    {
	return showProcessImageBtn;
    }

    public void setShowProcessImageBtn(boolean showProcessImageBtn)
    {
	this.showProcessImageBtn = showProcessImageBtn;
    }

    public boolean isShowExportDocBtn()
    {
	return showExportDocBtn;
    }

    public void setShowExportDocBtn(boolean showExportDocBtn)
    {
	this.showExportDocBtn = showExportDocBtn;
    }

    /**
     * @return the showDocUploadBtn
     */
    public boolean isShowDocUploadBtn()
    {
	return showDocUploadBtn;
    }

    /**
     * @param showDocUploadBtn the showDocUploadBtn to set
     */
    public void setShowDocUploadBtn(boolean showDocUploadBtn)
    {
	this.showDocUploadBtn = showDocUploadBtn;
    }

    /**
     * @return the showDocDownloadBtn
     */
    public boolean isShowDocDownloadBtn()
    {
	return showDocDownloadBtn;
    }

    /**
     * @param showDocDownloadBtn the showDocDownloadBtn to set
     */
    public void setShowDocDownloadBtn(boolean showDocDownloadBtn)
    {
	this.showDocDownloadBtn = showDocDownloadBtn;
    }

    /**
     * @return the showDocDeleteBtn
     */
    public boolean isShowDocDeleteBtn()
    {
	return showDocDeleteBtn;
    }

    /**
     * @param showDocDeleteBtn the showDocDeleteBtn to set
     */
    public void setShowDocDeleteBtn(boolean showDocDeleteBtn)
    {
	this.showDocDeleteBtn = showDocDeleteBtn;
    }
}
