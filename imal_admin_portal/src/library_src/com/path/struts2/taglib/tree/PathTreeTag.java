/**
 * 
 */
package com.path.struts2.taglib.tree;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.views.jsp.ui.AbstractContainerTag;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>PathTreeTag.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
@SuppressWarnings("serial")
public class PathTreeTag extends AbstractContainerTag
{
    protected String jstreetheme;
    protected String htmlTitles;
    protected String animation;
    protected String initiallyOpen;
    protected String rtl;
    protected String href;
    protected String onClickTopics;
    protected String onDBlClickTopics;
    protected String afterNodeCheckUncheckedTopic;
    protected String rootNode;
    protected String childCollectionProperty;
    protected String nodeTitleProperty;
    protected String nodeTypeProperty;
    protected String nodeIdProperty;
    protected String nodeHref;
    protected String nodeHrefParamName;
    protected String nodeTargets;
    protected String openAllOnLoad;
    protected String openAllOnRefresh;
    protected String contextmenu;
    protected String types;
    protected String showThemeDots;
    protected String showThemeIcons;
    protected String checkbox;
    protected String checkboxTwoState;
    protected String checkboxCheckAllTopics;
    protected String checkboxUncheckAllTopics;
    protected String checkboxHideTopics;
    protected String checkboxShowTopics;
    protected String enableAddNode;
    protected String enableRemoveNode;
    protected String enableRenameNode;
    protected String addNodeKey;
    protected String removeNodeKey;
    protected String renameNodeKey;
    protected String addNodeFunc;
    protected String removeNodeFunc;
    protected String renameNodeFunc;
    protected String ccp;
    // additional menu items to be added to context menu
    protected String additionalContextMenuItems;
    // flag to identify if the move of nodes with drag and drop in the same tree is enabled
    protected String dndInSameTreeEnabled;
    // method for checking if move of node is permitted
    protected String dndCheckMoveAllowedFunc;
    // method to be called when move is completed successfully
    protected String dndMoveCompleteFunc;

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	return new PathTree(stack, request, response);
    }

    @Override
    protected void populateParams()
    {
	super.populateParams();

	PathTree tree = (PathTree) component;
	tree.setJstreetheme(jstreetheme);
	tree.setAnimation(animation);
	tree.setHtmlTitles(htmlTitles);
	tree.setInitiallyOpen(initiallyOpen);
	tree.setRtl(rtl);
	tree.setHref(href);
	tree.setOnClickTopics(onClickTopics);
	tree.setOnDBlClickTopics(onDBlClickTopics);
	tree.setAfterNodeCheckUncheckedTopic(afterNodeCheckUncheckedTopic);
	tree.setRootNode(rootNode);
	tree.setChildCollectionProperty(childCollectionProperty);
	tree.setNodeIdProperty(nodeIdProperty);
	tree.setNodeTitleProperty(nodeTitleProperty);
	tree.setNodeTypeProperty(nodeTypeProperty);
	tree.setNodeHref(nodeHref);
	tree.setNodeHrefParamName(nodeHrefParamName);
	tree.setNodeTargets(nodeTargets);
	tree.setOpenAllOnLoad(openAllOnLoad);
	tree.setOpenAllOnRefresh(openAllOnRefresh);
	tree.setContextmenu(contextmenu);
	tree.setTypes(types);
	tree.setShowThemeDots(showThemeDots);
        tree.setShowThemeIcons(showThemeIcons);
        tree.setCheckbox(checkbox);
        tree.setCheckboxTwoState(checkboxTwoState);
        tree.setCheckboxCheckAllTopics(checkboxCheckAllTopics);
        tree.setCheckboxUncheckAllTopics(checkboxUncheckAllTopics);
        tree.setCheckboxShowTopics(checkboxShowTopics);
        tree.setCheckboxHideTopics(checkboxHideTopics);
        tree.setEnableAddNode(enableAddNode);
        tree.setEnableRemoveNode(enableRemoveNode);
        tree.setEnableRenameNode(enableRenameNode);
        tree.setAddNodeFunc(addNodeFunc);
        tree.setRemoveNodeFunc(removeNodeFunc);
        tree.setRenameNodeFunc(renameNodeFunc);
        tree.setAddNodeKey(addNodeKey);
        tree.setRemoveNodeKey(removeNodeKey);
        tree.setRenameNodeKey(renameNodeKey);
        tree.setCcp(ccp);
        tree.setDisabled(disabled);
        tree.setAdditionalContextMenuItems(additionalContextMenuItems);
        tree.setDndInSameTreeEnabled(dndInSameTreeEnabled);
        tree.setDndCheckMoveAllowedFunc(dndCheckMoveAllowedFunc);
        tree.setDndMoveCompleteFunc(dndMoveCompleteFunc);
    }

    /**
     * @return the jstreetheme
     */
    public String getJstreetheme()
    {
	return jstreetheme;
    }

    /**
     * @param jstreetheme the jstreetheme to set
     */
    public void setJstreetheme(String jstreetheme)
    {
	this.jstreetheme = jstreetheme;
    }

    /**
     * @return the htmlTitles
     */
    public String getHtmlTitles()
    {
	return htmlTitles;
    }

    /**
     * @param htmlTitles the htmlTitles to set
     */
    public void setHtmlTitles(String htmlTitles)
    {
	this.htmlTitles = htmlTitles;
    }

    /**
     * @return the animation
     */
    public String getAnimation()
    {
	return animation;
    }

    /**
     * @param animation the animation to set
     */
    public void setAnimation(String animation)
    {
	this.animation = animation;
    }

    /**
     * @return the initiallyOpen
     */
    public String getInitiallyOpen()
    {
	return initiallyOpen;
    }

    /**
     * @param initiallyOpen the initiallyOpen to set
     */
    public void setInitiallyOpen(String initiallyOpen)
    {
	this.initiallyOpen = initiallyOpen;
    }

    /**
     * @return the rtl
     */
    public String getRtl()
    {
	return rtl;
    }

    /**
     * @param rtl the rtl to set
     */
    public void setRtl(String rtl)
    {
	this.rtl = rtl;
    }

    /**
     * @return the href
     */
    public String getHref()
    {
	return href;
    }

    /**
     * @param href the href to set
     */
    @Override
    public void setHref(String href)
    {
	this.href = href;
    }

    /**
     * @return the onClickTopics
     */
    public String getOnClickTopics()
    {
	return onClickTopics;
    }

    /**
     * @param onClickTopics the onClickTopics to set
     */
    public void setOnClickTopics(String onClickTopics)
    {
	this.onClickTopics = onClickTopics;
    }

    /**
     * @return the rootNode
     */
    public String getRootNode()
    {
	return rootNode;
    }

    /**
     * @param rootNode the rootNode to set
     */
    public void setRootNode(String rootNode)
    {
	this.rootNode = rootNode;
    }

    /**
     * @return the childCollectionProperty
     */
    public String getChildCollectionProperty()
    {
	return childCollectionProperty;
    }

    /**
     * @param childCollectionProperty the childCollectionProperty to set
     */
    public void setChildCollectionProperty(String childCollectionProperty)
    {
	this.childCollectionProperty = childCollectionProperty;
    }

    /**
     * @return the nodeTitleProperty
     */
    public String getNodeTitleProperty()
    {
	return nodeTitleProperty;
    }

    /**
     * @param nodeTitleProperty the nodeTitleProperty to set
     */
    public void setNodeTitleProperty(String nodeTitleProperty)
    {
	this.nodeTitleProperty = nodeTitleProperty;
    }

    /**
     * @return the nodeTypeProperty
     */
    public String getNodeTypeProperty()
    {
	return nodeTypeProperty;
    }

    /**
     * @param nodeTypeProperty the nodeTypeProperty to set
     */
    public void setNodeTypeProperty(String nodeTypeProperty)
    {
	this.nodeTypeProperty = nodeTypeProperty;
    }

    /**
     * @return the nodeIdProperty
     */
    public String getNodeIdProperty()
    {
	return nodeIdProperty;
    }

    /**
     * @param nodeIdProperty the nodeIdProperty to set
     */
    public void setNodeIdProperty(String nodeIdProperty)
    {
	this.nodeIdProperty = nodeIdProperty;
    }

    /**
     * @return the nodeHref
     */
    public String getNodeHref()
    {
	return nodeHref;
    }

    /**
     * @param nodeHref the nodeHref to set
     */
    public void setNodeHref(String nodeHref)
    {
	this.nodeHref = nodeHref;
    }

    /**
     * @return the nodeHrefParamName
     */
    public String getNodeHrefParamName()
    {
	return nodeHrefParamName;
    }

    /**
     * @param nodeHrefParamName the nodeHrefParamName to set
     */
    public void setNodeHrefParamName(String nodeHrefParamName)
    {
	this.nodeHrefParamName = nodeHrefParamName;
    }

    /**
     * @return the nodeTargets
     */
    public String getNodeTargets()
    {
	return nodeTargets;
    }

    /**
     * @param nodeTargets the nodeTargets to set
     */
    public void setNodeTargets(String nodeTargets)
    {
	this.nodeTargets = nodeTargets;
    }

    /**
     * @return the openAllOnLoad
     */
    public String getOpenAllOnLoad()
    {
	return openAllOnLoad;
    }

    /**
     * @param openAllOnLoad the openAllOnLoad to set
     */
    public void setOpenAllOnLoad(String openAllOnLoad)
    {
	this.openAllOnLoad = openAllOnLoad;
    }

    /**
     * @return the openAllOnRefresh
     */
    public String getOpenAllOnRefresh()
    {
	return openAllOnRefresh;
    }

    /**
     * @param openAllOnRefresh the openAllOnRefresh to set
     */
    public void setOpenAllOnRefresh(String openAllOnRefresh)
    {
	this.openAllOnRefresh = openAllOnRefresh;
    }

    /**
     * @return the contextmenu
     */
    public String getContextmenu()
    {
	return contextmenu;
    }

    /**
     * @param contextmenu the contextmenu to set
     */
    public void setContextmenu(String contextmenu)
    {
	this.contextmenu = contextmenu;
    }

    /**
     * @return the types
     */
    public String getTypes()
    {
	return types;
    }

    /**
     * @param types the types to set
     */
    public void setTypes(String types)
    {
	this.types = types;
    }

    /**
     * @return the showThemeDots
     */
    public String getShowThemeDots()
    {
	return showThemeDots;
    }

    /**
     * @param showThemeDots the showThemeDots to set
     */
    public void setShowThemeDots(String showThemeDots)
    {
	this.showThemeDots = showThemeDots;
    }

    /**
     * @return the showThemeIcons
     */
    public String getShowThemeIcons()
    {
	return showThemeIcons;
    }

    /**
     * @param showThemeIcons the showThemeIcons to set
     */
    public void setShowThemeIcons(String showThemeIcons)
    {
	this.showThemeIcons = showThemeIcons;
    }

    /**
     * @return the checkbox
     */
    public String getCheckbox()
    {
	return checkbox;
    }

    /**
     * @param checkbox the checkbox to set
     */
    public void setCheckbox(String checkbox)
    {
	this.checkbox = checkbox;
    }

    /**
     * @return the checkboxTwoState
     */
    public String getCheckboxTwoState()
    {
	return checkboxTwoState;
    }

    /**
     * @param checkboxTwoState the checkboxTwoState to set
     */
    public void setCheckboxTwoState(String checkboxTwoState)
    {
	this.checkboxTwoState = checkboxTwoState;
    }

    /**
     * @return the checkboxCheckAllTopics
     */
    public String getCheckboxCheckAllTopics()
    {
	return checkboxCheckAllTopics;
    }

    /**
     * @param checkboxCheckAllTopics the checkboxCheckAllTopics to set
     */
    public void setCheckboxCheckAllTopics(String checkboxCheckAllTopics)
    {
	this.checkboxCheckAllTopics = checkboxCheckAllTopics;
    }

    /**
     * @return the checkboxUncheckAllTopics
     */
    public String getCheckboxUncheckAllTopics()
    {
	return checkboxUncheckAllTopics;
    }

    /**
     * @param checkboxUncheckAllTopics the checkboxUncheckAllTopics to set
     */
    public void setCheckboxUncheckAllTopics(String checkboxUncheckAllTopics)
    {
	this.checkboxUncheckAllTopics = checkboxUncheckAllTopics;
    }

    /**
     * @return the checkboxHideTopics
     */
    public String getCheckboxHideTopics()
    {
	return checkboxHideTopics;
    }

    /**
     * @param checkboxHideTopics the checkboxHideTopics to set
     */
    public void setCheckboxHideTopics(String checkboxHideTopics)
    {
	this.checkboxHideTopics = checkboxHideTopics;
    }

    /**
     * @return the checkboxShowTopics
     */
    public String getCheckboxShowTopics()
    {
	return checkboxShowTopics;
    }

    /**
     * @param checkboxShowTopics the checkboxShowTopics to set
     */
    public void setCheckboxShowTopics(String checkboxShowTopics)
    {
	this.checkboxShowTopics = checkboxShowTopics;
    }

    /**
     * @return the enableAddNode
     */
    public String getEnableAddNode()
    {
        return enableAddNode;
    }

    /**
     * @param enableAddNode the enableAddNode to set
     */
    public void setEnableAddNode(String enableAddNode)
    {
        this.enableAddNode = enableAddNode;
    }

    /**
     * @return the enableRemoveNode
     */
    public String getEnableRemoveNode()
    {
        return enableRemoveNode;
    }

    /**
     * @param enableRemoveNode the enableRemoveNode to set
     */
    public void setEnableRemoveNode(String enableRemoveNode)
    {
        this.enableRemoveNode = enableRemoveNode;
    }

    /**
     * @return the enableRenameNode
     */
    public String getEnableRenameNode()
    {
        return enableRenameNode;
    }

    /**
     * @param enableRenameNode the enableRenameNode to set
     */
    public void setEnableRenameNode(String enableRenameNode)
    {
        this.enableRenameNode = enableRenameNode;
    }

    /**
     * @return the addNodeKey
     */
    public String getAddNodeKey()
    {
        return addNodeKey;
    }

    /**
     * @param addNodeKey the addNodeKey to set
     */
    public void setAddNodeKey(String addNodeKey)
    {
        this.addNodeKey = addNodeKey;
    }

    /**
     * @return the removeNodeKey
     */
    public String getRemoveNodeKey()
    {
        return removeNodeKey;
    }

    /**
     * @param removeNodeKey the removeNodeKey to set
     */
    public void setRemoveNodeKey(String removeNodeKey)
    {
        this.removeNodeKey = removeNodeKey;
    }

    /**
     * @return the renameNodeKey
     */
    public String getRenameNodeKey()
    {
        return renameNodeKey;
    }

    /**
     * @param renameNodeKey the renameNodeKey to set
     */
    public void setRenameNodeKey(String renameNodeKey)
    {
        this.renameNodeKey = renameNodeKey;
    }

    /**
     * @return the addNodeFunc
     */
    public String getAddNodeFunc()
    {
        return addNodeFunc;
    }

    /**
     * @param addNodeFunc the addNodeFunc to set
     */
    public void setAddNodeFunc(String addNodeFunc)
    {
        this.addNodeFunc = addNodeFunc;
    }

    /**
     * @return the removeNodeFunc
     */
    public String getRemoveNodeFunc()
    {
        return removeNodeFunc;
    }

    /**
     * @param removeNodeFunc the removeNodeFunc to set
     */
    public void setRemoveNodeFunc(String removeNodeFunc)
    {
        this.removeNodeFunc = removeNodeFunc;
    }

    /**
     * @return the renameNodeFunc
     */
    public String getRenameNodeFunc()
    {
        return renameNodeFunc;
    }

    /**
     * @param renameNodeFunc the renameNodeFunc to set
     */
    public void setRenameNodeFunc(String renameNodeFunc)
    {
        this.renameNodeFunc = renameNodeFunc;
    }

    /**
     * @return the ccp
     */
    public String getCcp()
    {
        return ccp;
    }

    /**
     * @param ccp the ccp to set
     */
    public void setCcp(String ccp)
    {
        this.ccp = ccp;
    }

    public String getAfterNodeCheckUncheckedTopic()
    {
        return afterNodeCheckUncheckedTopic;
    }

    public void setAfterNodeCheckUncheckedTopic(String afterNodeCheckUncheckedTopic)
    {
        this.afterNodeCheckUncheckedTopic = afterNodeCheckUncheckedTopic;
    }

    public String getAdditionalContextMenuItems()
    {
        return additionalContextMenuItems;
    }

    public void setAdditionalContextMenuItems(String additionalContextMenuItems)
    {
        this.additionalContextMenuItems = additionalContextMenuItems;
    }

    public String getDndInSameTreeEnabled()
    {
        return dndInSameTreeEnabled;
    }

    public void setDndInSameTreeEnabled(String dndInSameTreeEnabled)
    {
        this.dndInSameTreeEnabled = dndInSameTreeEnabled;
    }

    public String getDndCheckMoveAllowedFunc()
    {
        return dndCheckMoveAllowedFunc;
    }

    public void setDndCheckMoveAllowedFunc(String dndCheckMoveAllowedFunc)
    {
        this.dndCheckMoveAllowedFunc = dndCheckMoveAllowedFunc;
    }

    public String getDndMoveCompleteFunc()
    {
        return dndMoveCompleteFunc;
    }

    public void setDndMoveCompleteFunc(String dndMoveCompleteFunc)
    {
        this.dndMoveCompleteFunc = dndMoveCompleteFunc;
    }

    public String getOnDBlClickTopics()
    {
        return onDBlClickTopics;
    }

    public void setOnDBlClickTopics(String onDBlClickTopics)
    {
        this.onDBlClickTopics = onDBlClickTopics;
    }
}
