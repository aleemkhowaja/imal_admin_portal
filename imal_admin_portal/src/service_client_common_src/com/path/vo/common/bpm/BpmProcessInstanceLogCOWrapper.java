package com.path.vo.common.bpm;

import com.path.struts2.lib.common.BaseObject;

public abstract class BpmProcessInstanceLogCOWrapper extends BaseObject
{
    private boolean showAbortBtn;
    private boolean showProcessImageBtn;
    private String comment;

    public boolean isShowAbortBtn()
    {
	return showAbortBtn;
    }

    public void setShowAbortBtn(boolean showAbortBtn)
    {
	this.showAbortBtn = showAbortBtn;
    }

    public boolean isShowProcessImageBtn()
    {
	return showProcessImageBtn;
    }

    public void setShowProcessImageBtn(boolean showProcessImageBtn)
    {
	this.showProcessImageBtn = showProcessImageBtn;
    }

    public String getComment()
    {
	return comment;
    }

    public void setComment(String comment)
    {
	this.comment = comment;
    }

}
