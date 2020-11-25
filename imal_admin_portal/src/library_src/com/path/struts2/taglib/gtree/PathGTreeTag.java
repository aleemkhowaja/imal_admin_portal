package com.path.struts2.taglib.gtree;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>PathTreeTag.java</strong> used to represent Graphical Tree Tag
 * 
 * @author Khaledhussein
 * 
 */
@SuppressWarnings("serial")
public class PathGTreeTag extends AbstractUITag
{
    // Json Object contains all the graphical cells
    private String cells;
    private String onDblClickTopic;
    private String onLinkDblClickTopic;

    private String width;
    private String height;
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

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	return new PathGTree(stack, request, response);
    }

    @Override
    protected void populateParams()
    {
	super.populateParams();

	PathGTree gTree = (PathGTree) component;
	gTree.setId(id);
	gTree.setCells(cells);
	gTree.setOnDblClickTopic(onDblClickTopic);
	gTree.setOnLinkDblClickTopic(onLinkDblClickTopic);
	gTree.setWidth(width);
	gTree.setHeight(height);
	gTree.setEditable(editable);
	gTree.setEditableLink(editableLink);
	gTree.setCustomAddDialog(customAddDialog);
	gTree.setCustomAddLinkDialog(customAddLinkDialog);
	gTree.setCustomNodeDetailsFunc(customNodeDetailsFunc);
	gTree.setHideNodeRenameBtn(hideNodeRenameBtn);
	gTree.setHideLinkLabelField(hideLinkLabelField);
	gTree.setHideAddLinkBtn(hideAddLinkBtn);
	gTree.setDeleteNodeCallBack(deleteNodeCallBack);
	
	gTree.setCssClassAdd(cssClassAdd);
	gTree.setCssClassDelete(cssClassDelete);
	gTree.setCssClassInfo(cssClassInfo);
	gTree.setCssClassLink(cssClassLink);
	gTree.setCssClassRename(cssClassRename);
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

    /**
     * @return the editable
     */
    public String getEditable()
    {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(String editable)
    {
        this.editable = editable;
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
