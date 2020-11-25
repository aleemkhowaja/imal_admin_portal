package com.path.vo.common.bpm;

import com.path.lib.vo.BaseVO;

public abstract class BpmTaskCOWrapper extends BaseVO
{
    private boolean showReleaseBtn;
    private boolean showClaimBtn;
    private boolean showForwardBtn;
    private boolean showCompleteBtn;
    private boolean showOpenBtn;
    private boolean showInstanceImageBtn;
    private boolean showSuspendBtn;
    private boolean showResumeBtn;
    private boolean showAdminLogsBtn;
    private boolean showDocumentsBtn;
    private String highlightColor;
    private String priority;
    private boolean addComment;
    private boolean deleteComment;
    private boolean updateComment;

    public boolean isShowReleaseBtn()
    {
	return showReleaseBtn;
    }

    public void setShowReleaseBtn(boolean showReleaseBtn)
    {
	this.showReleaseBtn = showReleaseBtn;
    }

    public boolean isShowClaimBtn()
    {
	return showClaimBtn;
    }

    public void setShowClaimBtn(boolean showClaimBtn)
    {
	this.showClaimBtn = showClaimBtn;
    }

    public boolean isShowCompleteBtn()
    {
	return showCompleteBtn;
    }

    public void setShowCompleteBtn(boolean showCompleteBtn)
    {
	this.showCompleteBtn = showCompleteBtn;
    }

    public boolean isShowOpenBtn()
    {
	return showOpenBtn;
    }

    public void setShowOpenBtn(boolean showOpenBtn)
    {
	this.showOpenBtn = showOpenBtn;
    }

    public String getHighlightColor()
    {
	return highlightColor;
    }

    public void setHighlightColor(String highlightColor)
    {
	this.highlightColor = highlightColor;
    }

    public boolean isShowForwardBtn()
    {
	return showForwardBtn;
    }

    public void setShowForwardBtn(boolean showForwardBtn)
    {
	this.showForwardBtn = showForwardBtn;
    }

    public boolean isShowInstanceImageBtn()
    {
	return showInstanceImageBtn;
    }

    public void setShowInstanceImageBtn(boolean showInstanceImageBtn)
    {
	this.showInstanceImageBtn = showInstanceImageBtn;
    }

    public boolean isShowSuspendBtn()
    {
	return showSuspendBtn;
    }

    public void setShowSuspendBtn(boolean showSuspendBtn)
    {
	this.showSuspendBtn = showSuspendBtn;
    }

    public boolean isShowResumeBtn()
    {
	return showResumeBtn;
    }

    public void setShowResumeBtn(boolean showResumeBtn)
    {
	this.showResumeBtn = showResumeBtn;
    }

    public boolean isShowAdminLogsBtn()
    {
	return showAdminLogsBtn;
    }

    public void setShowAdminLogsBtn(boolean showAdminLogsBtn)
    {
	this.showAdminLogsBtn = showAdminLogsBtn;
    }

    public boolean isShowDocumentsBtn()
    {
	return showDocumentsBtn;
    }

    public void setShowDocumentsBtn(boolean showDocumentsBtn)
    {
	this.showDocumentsBtn = showDocumentsBtn;
    }

    /**
     * @return the priority
     */
    public String getPriority()
    {
	return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(String priority)
    {
	this.priority = priority;
    }

    public boolean isAddComment()
    {
	return addComment;
    }

    public void setAddComment(boolean addComment)
    {
	this.addComment = addComment;
    }

    public boolean isDeleteComment()
    {
	return deleteComment;
    }

    public void setDeleteComment(boolean deleteComment)
    {
	this.deleteComment = deleteComment;
    }

    public boolean isUpdateComment()
    {
	return updateComment;
    }

    public void setUpdateComment(boolean updateComment)
    {
	this.updateComment = updateComment;
    }
}
