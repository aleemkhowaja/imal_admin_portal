package com.path.struts2.taglib.tree;

import java.io.Writer;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.jgeppert.struts2.jquery.components.AbstractContainer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.RootUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>PathTree.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
public class PathTree extends AbstractContainer
{
    public static final String TEMPLATE = "tree";
    public static final String TEMPLATE_CLOSE = "tree-close";
    public static final String THEME = "jquery";
    public static final String JQUERYACTION = "tree";

    private static final transient Random RANDOM = new Random();

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
    // for customised context menu items
    protected String additionalContextMenuItems;
    // flag to identify if the move of nodes with drag and drop in the same tree is enabled
    protected String dndInSameTreeEnabled;
    // method for checking if move of node is permitted
    protected String dndCheckMoveAllowedFunc;
    // method to be called when move is completed successfully
    protected String dndMoveCompleteFunc;

    public PathTree(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    @Override
    public String getDefaultOpenTemplate()
    {
	return TEMPLATE;
    }

    @Override
    protected String getDefaultTemplate()
    {
	return TEMPLATE_CLOSE;
    }

    @Override
    public boolean start(Writer writer)
    {
	applyEvaluateExtraParams();
	return super.start(writer);
    }

    /**
     * Custom method to be added in the start method in order to avoid calling
     * it twice
     */
    private void applyEvaluateExtraParams()
    {
	addParameter("jqueryaction", JQUERYACTION);
	
	boolean _recReadOnly = false;
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	if(baseAction!=null)
	{		
		SessionCO sessionCO = baseAction.returnSessionObject();
		if(sessionCO.getIsRTLDir()==1)
		{
			rtl="true";
		}
		if("true".equals(StringUtil.nullToEmpty(baseAction.get_recReadOnly())))
		{
		    _recReadOnly = true;
		}
	}

	if(jstreetheme != null)
	{
	    addParameter("jstreetheme", findString(jstreetheme));
	}
	if(animation != null)
	{
	    addParameter("animation", findValue(animation, Number.class));
	}
	if(htmlTitles != null)
	{
	    addParameter("htmlTitles", findValue(htmlTitles, Boolean.class));
	}
	if(initiallyOpen != null)
	{
	    addParameter("initiallyOpen", findString(initiallyOpen));
	}
	if(rtl != null)
	{
	    addParameter("rtl", findValue(rtl, Boolean.class));
	}
	if(href != null)
	{
	    addParameter("href", findString(href));
	}
	if(onClickTopics != null)
	{
	    addParameter("onClickTopics", findString(onClickTopics));
	}
	if(onDBlClickTopics != null)
	{
	    addParameter("onDBlClickTopics", findString(onDBlClickTopics));
	}
	if(afterNodeCheckUncheckedTopic != null)
	{
	    addParameter("afterNodeCheckUncheckedTopic", findString(afterNodeCheckUncheckedTopic));
	}
	if(rootNode != null)
	{
	    addParameter("rootNode", findValue(rootNode));
	}
	if(childCollectionProperty != null)
	{
	    addParameter("childCollectionProperty", findString(childCollectionProperty));
	}
	if(nodeTitleProperty != null)
	{
	    addParameter("nodeTitleProperty", findString(nodeTitleProperty));
	}
	if(nodeTypeProperty != null)
	{
	    addParameter("nodeTypeProperty", findString(nodeTypeProperty));
	}
	if(nodeIdProperty != null)
	{
	    addParameter("nodeIdProperty", findString(nodeIdProperty));
	}
	if(nodeHref != null)
	{
	    addParameter("nodeHref", findString(nodeHref));
	}
	if(nodeHrefParamName != null)
	{
	    addParameter("nodeHrefParamName", findString(nodeHrefParamName));
	}
	if(nodeTargets != null)
	{
	    addParameter("nodeTargets", findString(nodeTargets));
	}
	if(openAllOnLoad != null)
	{
	    addParameter("openAllOnLoad", findValue(openAllOnLoad, Boolean.class));
	}
	if(openAllOnRefresh != null)
	{
	    addParameter("openAllOnRefresh", findValue(openAllOnRefresh, Boolean.class));
	}
	if(types != null)
	{
	    addParameter("types", findString(types));
	}
	if(showThemeDots != null)
	{
	    addParameter("showThemeDots", findValue(showThemeDots, Boolean.class));
	}
	if(showThemeIcons != null)
	{
	    addParameter("showThemeIcons", findValue(showThemeIcons, Boolean.class));
	}
	if(checkbox != null)
	{
	    addParameter("checkbox", findValue(checkbox, Boolean.class));
	}
	if(checkboxTwoState != null)
	{
	    addParameter("checkboxTwoState", findValue(checkboxTwoState, Boolean.class));
	}
	if(checkboxCheckAllTopics != null)
	{
	    addParameter("checkboxCheckAllTopics", findString(checkboxCheckAllTopics));
	}
	if(checkboxUncheckAllTopics != null)
	{
	    addParameter("checkboxUncheckAllTopics", findString(checkboxUncheckAllTopics));
	}
	if(checkboxHideTopics != null)
	{
	    addParameter("checkboxHideTopics", findString(checkboxHideTopics));
	}
	if(checkboxShowTopics != null)
	{
	    addParameter("checkboxShowTopics", findString(checkboxShowTopics));
	}
	if((this.id == null || this.id.length() == 0))
	{
	    int nextInt = RANDOM.nextInt();
	    nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
	    this.id = "tree" + String.valueOf(nextInt);
	    addParameter("id", this.id);
	}

	/* Modification to add contextmenu */
	Boolean isEnableAddNode = false, isEnableRemNode = false, isEnableRenNode = false, isCCP = false;
	if(!_recReadOnly)
	{
	    if(enableAddNode != null)
	    {
		isEnableAddNode = (Boolean) findValue(enableAddNode, Boolean.class);
	    }
	    if(enableRemoveNode != null)
	    {
		isEnableRemNode = (Boolean) findValue(enableRemoveNode, Boolean.class);
	    }
	    if(enableRenameNode != null)
	    {
		isEnableRenNode = (Boolean) findValue(enableRenameNode, Boolean.class);
	    }
	    if(ccp != null)
	    {
		isCCP = (Boolean) findValue(ccp, Boolean.class);
	    }

	}
	
	if(contextmenu == null && (isEnableAddNode || isEnableRemNode || isEnableRenNode || isCCP || additionalContextMenuItems != null))
	{
	    addParameter("contextmenu", findString(generateContextmenu(isEnableAddNode, isEnableRemNode,
		    isEnableRenNode, isCCP, _recReadOnly)));
	}
	else if(contextmenu != null)
	{
	    addParameter("contextmenu", findString(contextmenu));
	}

	if(!_recReadOnly)
	{
	    // Modification to make the tree disabled
	    if(disabled != null)
	    {
		addParameter("disabled", findValue(disabled, Boolean.class));
	    }
	}
	else // if record readonly then make tree readonly
	{
	    addParameter("disabled", true);
	}
	
	if(dndInSameTreeEnabled != null)
	{
	    addParameter("dndInSameTreeEnabled", findString(dndInSameTreeEnabled));
	}
	
	if(dndCheckMoveAllowedFunc != null)
	{
	    addParameter("dndCheckMoveAllowedFunc", findString(dndCheckMoveAllowedFunc));
	}
	if(dndMoveCompleteFunc != null)
	{
	    addParameter("dndMoveCompleteFunc", findString(dndMoveCompleteFunc));
	}
	
	//escape id from special characters that might be used for security intrusion
	id =  RootUtil.escapeJS(id);
    }

    /**
     * Generates the contextmenu based on the flags for each operation
     * (add/remove/rename)
     * 
     * @param isEnableAddNode
     * @param isEnableRemNode
     * @param isEnableRenNode
     * @param isCCP
     * @param _recReadOnly 
     * 
     * @return contextmenu string
     */
    private String generateContextmenu(Boolean isEnableAddNode, Boolean isEnableRemNode, Boolean isEnableRenNode,
	    Boolean isCCP, boolean _recReadOnly)
    {
	final String titleKey = "Title_key";
	final String nodeCodeKey = "node_code_key";
	final String cancelKey = "cancel_key";

	StringBuffer bf = new StringBuffer();
	BaseAction baseAction = ((BaseAction) ActionContext.getContext().getActionInvocation().getAction());
	String itemsJson = "{items:{";
	bf.append(itemsJson);
        /**
         * [MarwanMaddah]: BUG 533014 - user is able to open the right click on "Run_Batch_For_Branches" section on approve screen 
         * In case the tree is on read only mode, the default menus have to be hidden. 
         */
	if(_recReadOnly)
	{
	    bf.append("'create' : false ");
	    bf.append(" , 'rename' : false ");
	    bf.append(", 'remove' : false ");
	    bf.append(", 'ccp' : false ");
	}
	else
	{
	    if(isEnableAddNode)
	    {
		bf.append("'create' : { ").append("'label' : '");

		if(addNodeKey == null)
		{
		    bf.append("[addNodeKey] missing");
		}
		else
		{
		    bf.append(baseAction.getEscText(addNodeKey));
		}

		bf.append("' ");

		if(addNodeFunc != null)
		{
		    bf
		    .append(
			    ", 'action' : function (obj) { var jstree = this; createAddNodeDialog({obj:obj, jstree:jstree, funct :'")
			    .append(addNodeFunc).append("', title_lbl:'").append(baseAction.getEscText(titleKey)).append(
				    "', nodeCode_lbl:'").append(baseAction.getEscText(nodeCodeKey)).append("', add_lbl:'")
				    .append(baseAction.getEscText(addNodeKey)).append("', cancel_lbl:'").append(
					    baseAction.getEscText(cancelKey)).append("'}); } ");
		}

		bf.append("} ");
	    }
	    else
	    {
		bf.append("'create' : false ");
	    }
	    // rename node enabling
	    if(isEnableRenNode)
	    {
		bf.append(" , 'rename' : { ").append("'label' : '");

		if(renameNodeKey == null)
		{
		    bf.append("[renameNodeKey] missing");
		}
		else
		{
		    bf.append(baseAction.getEscText(renameNodeKey));
		}

		bf.append("' ");

		if(renameNodeFunc != null)
		{
		    bf.append(", 'action' : function (obj) { this.rename(obj); ").append(renameNodeFunc)
		    .append("(obj); } ");
		}

		bf.append("} ");
	    }
	    else
	    {
		bf.append(" , 'rename' : false ");
	    }
	    // delete Node enabling
	    if(isEnableRemNode)
	    {
		bf.append(", 'remove' : { ").append("'label' : '");

		if(removeNodeKey == null)
		{
		    bf.append("[removeNodeKey] missing");
		}
		else
		{
		    bf.append(baseAction.getEscText(removeNodeKey));
		}

		bf.append("' ");

		if(removeNodeFunc != null)
		{
		    bf.append(", 'action' : function (obj) { this.remove(obj); ").append(removeNodeFunc)
		    .append("(obj); } ");
		}

		bf.append("} ");
	    }
	    else
	    {
		bf.append(", 'remove' : false ");
	    }

	    if(!isCCP)
	    {
		bf.append(", 'ccp' : false ");
	    }
	}
	
	if(additionalContextMenuItems != null)
	{
	    if(bf.length() > itemsJson.length())
	    {
		bf.append(",");
	    }
	    bf.append(additionalContextMenuItems);
	}
	bf.append("} }");

	return bf.toString();
    }

    @Override
    @StrutsTagSkipInheritance
    public void setTheme(String theme)
    {
	super.setTheme(theme);
    }

    @Override
    public String getTheme()
    {
	return THEME;
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
