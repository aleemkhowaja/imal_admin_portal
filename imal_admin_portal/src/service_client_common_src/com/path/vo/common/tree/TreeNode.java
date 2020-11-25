package com.path.vo.common.tree;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

/**
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code </br>
 * 
 * <strong>TreeNode.java</strong> used to
 * 
 * @author Khaledhussein
 * 
 */
public class TreeNode
{
    public static final String NODE_STATE_CLOSED = "closed";
    public static final String NODE_STATE_LEAF = "leaf";
    public static final String NODE_STATE_OPEN = "open";

    private Map<String, Object> attr;
    private List<TreeNode> children;
    private Map<String, Object> data;
    private String icon;
    private String id;
    private String state = TreeNode.NODE_STATE_OPEN;
    private String title;
    private String type;
    private String nodeCode;
    private String parentNodeCode;
    // order of the node inside its parent
    private Integer nodeOrder;
    private boolean hasChild;
    private boolean aChild;
    private String checked;
    private String disabled;
    private String childrenDisabled;


    /**
     * Default constructor
     */
    public TreeNode()
    {
	super();
    }

    /**
     * @param title
     */
    public TreeNode(String title)
    {
	this.title = title;
    }

    /**
     * @param title
     * @param children
     */
    public TreeNode(String title, List<TreeNode> children)
    {
	setTitle(title);
	setChildren(children);
    }

    /**
     * @param id
     * @param title
     */
    public TreeNode(String id, String title)
    {
	setId(id);
	setTitle(title);
    }

    /**
     * @param id
     * @param title
     * @param children
     */
    public TreeNode(String id, String title, List<TreeNode> children)
    {
	setId(id);
	setTitle(title);
	setChildren(children);
    }

    /**
     * 
     * @param nodeCode
     * @param parentNodeCode
     * @param icon
     * @param title
     * @param nodeOrder Order of the Node inside its parent
     */
    public TreeNode(String nodeCode, String parentNodeCode, String icon, String title, BigDecimal nodeOrder)
    {
	setNodeCode(nodeCode);
	setParentNodeCode(parentNodeCode);
	if(nodeOrder != null)
	{
	    setNodeOrder(nodeOrder.intValue());
	}
	setIcon(icon);
	setTitle(title);
	setState(NODE_STATE_OPEN);
	setChildren(new ArrayList<TreeNode>());
    }

    /**
     * @return the attr
     */
    public Map<String, Object> getAttr()
    {
	return attr;
    }

    /**
     * @param attr the attr to set
     */
    public void setAttr(Map<String, Object> attr)
    {
	this.attr = attr;
    }

    /**
     * @return the children
     */
    public List<TreeNode> getChildren()
    {
	return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<TreeNode> children)
    {
	this.children = children;
    }

    /**
     * @return the data
     */
    public Map<String, Object> getData()
    {
	return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Map<String, Object> data)
    {
	this.data = data;
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
	if(this.data == null)
	{
	    data = new HashMap<String, Object>();
	}

	if(this.data.containsKey("icon"))
	{
	    this.data.remove("icon");
	}

	this.data.put("icon", icon);
	this.icon = icon;
    }

    /**
     * @return the id
     */
   /* public String getId()
    {
	return id;
    }*/

    /**
     * @param id the id to set
     */
    public void setId(String id)
    {
	addAtributeToNode("id",id);
	this.id = id;
    }

    /**
     * @return the state
     */
    public String getState()
    {
	return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state)
    {
	this.state = state;
    }

    /**
     * @return the title
     */
    
  /*  public String getTitle()
    {
	return title;
    }
    */

    /**
     * @param title the title to set
     */
    public void setTitle(String title)
    {
	if(this.data == null)
	{
	    data = new HashMap<String, Object>();
	}

	if(this.data.containsKey("title"))
	{
	    this.data.remove("title");
	}

	this.data.put("title", title);
	this.title = title;
    }

    /**
     * @return the type
     */
    public String getType()
    {
	return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
	this.type = type;
    }

    /**
     * @return the nodeCode
     */
    @JSON(serialize=false)
    public String getNodeCode()
    {
	return nodeCode;
    }

    /**
     * @param nodeCode the nodeCode to set
     */
    public void setNodeCode(String nodeCode)
    {
	addAtributeToNode("nodeCode",nodeCode);
	this.nodeCode = nodeCode;
    }
    /**
     * Method to allow adding Custom attributes at level of Node
     * @param customAtt Map of Custom Nodes
     */
    public void addAdditionalCustomAttr(HashMap<String, Object> customAtt)
    {
    	if(customAtt != null)
    	{	
    		if(this.attr == null)
    		{
    			attr = new HashMap<String, Object>();
    		}
    		attr.putAll(customAtt);
    	}
    }
    /**
     * MEthod that will add an attribute to the tree <li/> item
     * @param nodeAttrbuteName Name of the attribute
     * @param theValue Value of the attribute
     */
    private void addAtributeToNode(String nodeAttrbuteName, Object theValue)
    {
	if(theValue != null)
	{
	    if(this.attr == null)
	    {
		attr = new HashMap<String, Object>();
	    }

	    if(this.attr.containsKey(nodeAttrbuteName))
	    {
		this.attr.remove(nodeAttrbuteName);
	    }
	    this.attr.put(nodeAttrbuteName, theValue);
	}
    }

    /**
     * @return the parentNodeCode
     */
    @JSON(serialize=false)
    public String getParentNodeCode()
    {
	return parentNodeCode;
    }
    

    /**
     * @param parentNodeCode the parentNodeCode to set
     */
    public void setParentNodeCode(String parentNodeCode)
    {
	addAtributeToNode("parentNodeCode",parentNodeCode);
	this.parentNodeCode = parentNodeCode;
    }

    /**
     * @return the hasChild
     */
    public boolean isHasChild()
    {
        return hasChild;
    }

    /**
     * @param hasChild the hasChild to set
     */
    public void setHasChild(boolean hasChild)
    {
        this.hasChild = hasChild;
    }

    /**
     * @return the aChild
     */
    public boolean isaChild()
    {
        return aChild;
    }

    /**
     * @param aChild the aChild to set
     */
    public void setaChild(boolean aChild)
    {
        this.aChild = aChild;
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
	addAtributeToNode("nodechecked",checked);
        this.checked = checked;
    }

    @Override
    public String toString()
    {
	StringBuffer buffer = new StringBuffer();
	buffer.append("TreeNode [id=").append(id).append(", title=").append(title).append(", icon=").append(icon)
		.append(", state=").append(state).append(", attr=").append(attr).append(", children=").append(children)
		.append("]");
	return buffer.toString();
    }
    /**
     * set the order of the Node within its parent
     * @param nodeOrder
     */
    public void setNodeOrder(Integer nodeOrder)
    {
	addAtributeToNode("initOrder",nodeOrder);
        this.nodeOrder = nodeOrder;
    }
    @JSON(serialize=false)
    public Integer getNodeOrder()
    {
        return nodeOrder;
    }
    
    @JSON(serialize=false)
    public String getDisabled()
    {
        return disabled;
    }

    public void setDisabled(String disabled)
    {
	addAtributeToNode("nodedisabled",disabled);
        this.disabled = disabled;
    }

    public String getChildrenDisabled()
    {
        return childrenDisabled;
    }

    public void setChildrenDisabled(String childrenDisabled)
    {
	addAtributeToNode("childrendisabeled",childrenDisabled);
        this.childrenDisabled = childrenDisabled;
    }
  

}
