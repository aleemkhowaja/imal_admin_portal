package com.path.vo.common.tree;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>TreeNodeCO.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
public class TreeNodeCO implements Serializable
{
    private String nodeCode;
    private String parentNodeCode;
    private String icon;
    private String title;
    private String checked;
    // node Order within its parent specification
    private BigDecimal nodeOrder;
    // to specify whether the Node to be disabled upon load of tree
    private String disabled;
    // specify whether all descendant nodes will be disabled
    private String childrenDisabled;
    // list of custom attributes to be added to the node
    private HashMap<String, Object> customAttributes;
    // State of the Node (Opened, Closed, Leaf) Constatnts in TreeNode.java
    private String nodeState;

    /**
     * Method to return the Node order of the tree Node within its parent
     * @return
     */
    public BigDecimal getNodeOrder()
    {
        return nodeOrder;
    }
    /**
     * @return the nodeCode
     */
    public String getNodeCode()
    {
	return nodeCode;
    }

    /**
     * @param nodeCode the nodeCode to set
     */
    public void setNodeCode(String nodeCode)
    {
	this.nodeCode = nodeCode;
    }

    /**
     * @return the parentNodeCode
     */
    public String getParentNodeCode()
    {
	return parentNodeCode;
    }

    /**
     * @param parentNodeCode the parentNodeCode to set
     */
    public void setParentNodeCode(String parentNodeCode)
    {
	this.parentNodeCode = parentNodeCode;
    }

    /**
     * @return the icon
     */
    public String getIcon()
    {
	return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon)
    {
	this.icon = icon;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
	return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title)
    {
	this.title = title;
    }

    /**
     * @return the checked
     */
    public String getChecked()
    {
        return checked;
    }

    /**
     * @param checked the checked to set
     */
    public void setChecked(String checked)
    {
        this.checked = checked;
    }
    public void setNodeOrder(BigDecimal nodeOrder)
    {
        this.nodeOrder = nodeOrder;
    }
    public String getDisabled()
    {
        return disabled;
    }
    public void setDisabled(String disabled)
    {
        this.disabled = disabled;
    }
    public String getChildrenDisabled()
    {
        return childrenDisabled;
    }

    /**
     * To disable All Children of current Node
     * 
     * @param childrenDisabled
     */
    public void setChildrenDisabled(String childrenDisabled)
    {
	this.childrenDisabled = childrenDisabled;
    }
   
    public HashMap<String, Object> getCustomAttributes()
    {
	return customAttributes;
    }
    /**
     * To add Custom Attribute to Tree Node
     * @return
     */
    public void setCustomAttributes(HashMap<String, Object> customAttributes)
    {
	this.customAttributes = customAttributes;
    }
    public String getNodeState()
    {
        return nodeState;
    }
    public void setNodeState(String nodeState)
    {
        this.nodeState = nodeState;
    }
}
