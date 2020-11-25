package com.path.struts2.taglib.gtree;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.struts2.lib.common.base.BaseAction;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>PathGTree.java</strong> used to represent Graphical Tree
 * 
 * @author Khaledhussein
 * 
 */
public class PathGTree extends UIBean
{
    public static final String TEMPLATE = "path-gtree";

    private static final transient Random RANDOM = new Random();

    private String width;
    private String height;
    private String onDblClickTopic;
    private String onLinkDblClickTopic;
    private String editable;
    private String editableLink;
    private String customAddDialog;
    private String customAddLinkDialog;
    private String customNodeDetailsFunc;
    private String hideNodeRenameBtn;
    private String hideLinkLabelField;
    private String hideAddLinkBtn;
    private String deleteNodeCallBack;
    
    private String cssClassAdd;
    private String cssClassDelete;
    private String cssClassInfo;
    private String cssClassLink;
    private String cssClassRename;

    // Json Object contains all the graphical cells
    private String cells;

    public PathGTree(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    @Override
    protected String getDefaultTemplate()
    {
	return TEMPLATE;
    }

    @Override
    public void evaluateExtraParams()
    {
	super.evaluateExtraParams();

	final String addLabelKey = "btn.add";
	final String linkLabelKey = "Link_key";
	final String removeLabelKey = "btn.remove";
	final String renameLabelKey = "btn.rename";
	final String gtreeNameLblKey = "Name_key";
	final String okButtonLblKey = "ok_key";
	final String cancelButtonLblKey = "cancel_key";
	final String detailsLblKey = "details";

	if(cells != null)
	{
	    addParameter("cells", findString(cells));
	}

	if(onDblClickTopic != null)
	{
	    addParameter("onDblClickTopic", findString(onDblClickTopic));
	}
	if(onLinkDblClickTopic != null)
	{
	    addParameter("onLinkDblClickTopic", findString(onLinkDblClickTopic));
	}

	if(width != null)
	{
	    addParameter("width", findString(width));
	}

	if(height != null)
	{
	    addParameter("height", findString(height));
	}

	if((id == null || id.length() == 0))
	{
	    int nextInt = RANDOM.nextInt();
	    nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
	    id = "pathGtree" + String.valueOf(nextInt);
	    addParameter("id", id);
	}
	if(editable != null)
	{
	    addParameter("editable", findString(editable));
	}
	if(editableLink != null)
	{
	    addParameter("editableLink", findString(editableLink));
	}
	

	if(customAddDialog != null)
	{
	    addParameter("customAddDialog", findString(customAddDialog));
	}
	if(customAddLinkDialog != null)
	{
	    addParameter("customAddLinkDialog", findString(customAddLinkDialog));
	}
	
	if(customNodeDetailsFunc != null)
	{
	    addParameter("customNodeDetailsFunc", findString(customNodeDetailsFunc));
	}
	if(hideNodeRenameBtn != null)
	{
	    addParameter("hideNodeRenameBtn", findString(hideNodeRenameBtn));
	}
	if(hideLinkLabelField != null)
	{
	    addParameter("hideLinkLabelField", findString(hideLinkLabelField));
	}
	if(hideAddLinkBtn != null)
	{
	    addParameter("hideAddLinkBtn", findString(hideAddLinkBtn));
	}
	if(deleteNodeCallBack != null)
	{
	    addParameter("deleteNodeCallBack", findString(deleteNodeCallBack));
	}
	if(cssClassAdd != null)
	{
	    addParameter("cssClassAdd", findString(cssClassAdd));
	}
	if(cssClassDelete != null)
	{
	    addParameter("cssClassDelete", findString(cssClassDelete));
	}
	if(cssClassInfo != null)
	{
	    addParameter("cssClassInfo", findString(cssClassInfo));
	}
	if(cssClassLink != null)
	{
	    addParameter("cssClassLink", findString(cssClassLink));
	}
	if(cssClassRename != null)
	{
	    addParameter("cssClassRename", findString(cssClassRename));
	}
	
	// add translations
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	addParameter("addLabel", findString(baseAction.getEscText(addLabelKey)));
	addParameter("linkLabel", findString(baseAction.getEscText(linkLabelKey)));
	addParameter("removeLabel", findString(baseAction.getEscText(removeLabelKey)));
	addParameter("renameLabel", findString(baseAction.getEscText(renameLabelKey)));
	addParameter("gtreeNameLbl", findString(baseAction.getEscText(gtreeNameLblKey)));
	addParameter("okButtonLbl", findString(baseAction.getEscText(okButtonLblKey)));
	addParameter("cancelButtonLbl", findString(baseAction.getEscText(cancelButtonLblKey)));
	addParameter("detailsButtonLbl", findString(baseAction.getEscText(detailsLblKey)));

    }

    /**
     * @return the cells
     */
    public String getCells()
    {
	return cells;
    }

    /**
     * @param cells the cells to set
     */
    public void setCells(String cells)
    {
	this.cells = cells;
    }

    /**
     * @return the onDblClickTopic
     */
    public String getOnDblClickTopic()
    {
	return onDblClickTopic;
    }

    /**
     * @param onDblClickTopic the onDblClickTopic to set
     */
    public void setOnDblClickTopic(String onDblClickTopic)
    {
	this.onDblClickTopic = onDblClickTopic;
    }
    
    
    /**
     * @return the onLinkDblClickTopic
     */
    public String getOnLinkDblClickTopic()
    {
        return onLinkDblClickTopic;
    }

    /**
     * @param onLinkDblClickTopic the onLinkDblClickTopic to set
     */
    public void setOnLinkDblClickTopic(String onLinkDblClickTopic)
    {
        this.onLinkDblClickTopic = onLinkDblClickTopic;
    }

    /**
     * @return the width
     */
    public String getWidth()
    {
	return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(String width)
    {
	this.width = width;
    }

    /**
     * @return the height
     */
    public String getHeight()
    {
	return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height)
    {
	this.height = height;
    }

    public String getEditable()
    {
        return editable;
    }

    public void setEditable(String editable)
    {
        this.editable = editable;
    }

    /**
     * @return the editableLink
     */
    public String getEditableLink()
    {
        return editableLink;
    }

    /**
     * @param editableLink the editableLink to set
     */
    public void setEditableLink(String editableLink)
    {
        this.editableLink = editableLink;
    }

    public String getCustomAddDialog()
    {
        return customAddDialog;
    }

    public void setCustomAddDialog(String customAddDialog)
    {
        this.customAddDialog = customAddDialog;
    }

    /**
     * @return the customAddLinkDialog
     */
    public String getCustomAddLinkDialog()
    {
        return customAddLinkDialog;
    }

    /**
     * @param customAddLinkDialog the customAddLinkDialog to set
     */
    public void setCustomAddLinkDialog(String customAddLinkDialog)
    {
        this.customAddLinkDialog = customAddLinkDialog;
    }

    /**
     * @return the customNodeDetailsFunc
     */
    public String getCustomNodeDetailsFunc()
    {
        return customNodeDetailsFunc;
    }

    /**
     * @param customNodeDetailsFunc the customNodeDetailsFunc to set
     */
    public void setCustomNodeDetailsFunc(String customNodeDetailsFunc)
    {
        this.customNodeDetailsFunc = customNodeDetailsFunc;
    }


    /**
     * @return the hideNodeRenameBtn
     */
    public String getHideNodeRenameBtn()
    {
        return hideNodeRenameBtn;
    }

    /**
     * @param hideNodeRenameBtn the hideNodeRenameBtn to set
     */
    public void setHideNodeRenameBtn(String hideNodeRenameBtn)
    {
        this.hideNodeRenameBtn = hideNodeRenameBtn;
    }

    /**
     * @return the hideLinkLabelField
     */
    public String getHideLinkLabelField()
    {
        return hideLinkLabelField;
    }

    /**
     * @param hideLinkLabelField the hideLinkLabelField to set
     */
    public void setHideLinkLabelField(String hideLinkLabelField)
    {
        this.hideLinkLabelField = hideLinkLabelField;
    }

    /**
     * @return the hideAddLinkBtn
     */
    public String getHideAddLinkBtn()
    {
        return hideAddLinkBtn;
    }

    /**
     * @param hideAddLinkBtn the hideAddLinkBtn to set
     */
    public void setHideAddLinkBtn(String hideAddLinkBtn)
    {
        this.hideAddLinkBtn = hideAddLinkBtn;
    }

    /**
     * @return the deleteNodeCallBack
     */
    public String getDeleteNodeCallBack()
    {
        return deleteNodeCallBack;
    }

    /**
     * @param deleteNodeCallBack the deleteNodeCallBack to set
     */
    public void setDeleteNodeCallBack(String deleteNodeCallBack)
    {
        this.deleteNodeCallBack = deleteNodeCallBack;
    }

    /**
     * @return the cssClassAdd
     */
    public String getCssClassAdd()
    {
        return cssClassAdd;
    }

    /**
     * @param cssClassAdd the cssClassAdd to set
     */
    public void setCssClassAdd(String cssClassAdd)
    {
        this.cssClassAdd = cssClassAdd;
    }

    /**
     * @return the cssClassDelete
     */
    public String getCssClassDelete()
    {
        return cssClassDelete;
    }

    /**
     * @param cssClassDelete the cssClassDelete to set
     */
    public void setCssClassDelete(String cssClassDelete)
    {
        this.cssClassDelete = cssClassDelete;
    }

    /**
     * @return the cssClassInfo
     */
    public String getCssClassInfo()
    {
        return cssClassInfo;
    }

    /**
     * @param cssClassInfo the cssClassInfo to set
     */
    public void setCssClassInfo(String cssClassInfo)
    {
        this.cssClassInfo = cssClassInfo;
    }

    /**
     * @return the cssClassLink
     */
    public String getCssClassLink()
    {
        return cssClassLink;
    }

    /**
     * @param cssClassLink the cssClassLink to set
     */
    public void setCssClassLink(String cssClassLink)
    {
        this.cssClassLink = cssClassLink;
    }

    /**
     * @return the cssClassRename
     */
    public String getCssClassRename()
    {
        return cssClassRename;
    }

    /**
     * @param cssClassRename the cssClassRename to set
     */
    public void setCssClassRename(String cssClassRename)
    {
        this.cssClassRename = cssClassRename;
    }
    
}
