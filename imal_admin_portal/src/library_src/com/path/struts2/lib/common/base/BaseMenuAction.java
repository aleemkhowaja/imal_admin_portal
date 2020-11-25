package com.path.struts2.lib.common.base;

import java.util.ArrayList;

import com.path.lib.vo.MenuVO;

public class BaseMenuAction extends BaseAction
{
	protected ArrayList<MenuVO> menuData= new ArrayList<MenuVO>();//collection menuVO for both tree and horizontal menu.
	protected String actionName;//keeping action name for treemenu and horizontal menu which has to be invoked when a menu item is clicked.
	protected String targetName;//keep the target name where the menu to be loaded.
	protected String id;//
	protected boolean root;//flag describes whether the menu is generated for root or not
	private String menuVar;//keeps the menu items id for tree and horizontal menu
	private String scrollSize;//tells how many menu items to be displayed in the horizontal menu.
	private String targetLoadAction;//responsible for loading the  target view for horizontal menu.
	protected String enableReportOrdering;//to know if the menu is report to make a specific ordering TP 571957 CIHAN CBR170133 Reports Ordering By Name

 
	public String loadScreen()
	{
		try
		{
			return menuVar;
		}
		catch(Exception ex)
		{
			log.error("wrong menu id or check if mapping is done correctly for action loadScreen in menu-struts.xml");
		}
		return SUCCESS;
	}	

	public String getTargetLoadAction() {
		return targetLoadAction;
	}
	public void setTargetLoadAction(String targetLoadAction) {
		this.targetLoadAction = targetLoadAction;
	}
	public String getScrollSize() {
		return scrollSize;
	}
	public void setScrollSize(String scrollSize) {
		this.scrollSize = scrollSize;
	}
	public String getActionName()
	{
		return actionName;
	}
	public void setActionName(String actionName)
	{
		this.actionName = actionName;
	}
	public String getTargetName()
	{
		return targetName;
	}
	public void setTargetName(String targetName)
	{
		this.targetName = targetName;
	}
	public String getEnableReportOrdering()
	{
	    return enableReportOrdering;
	}

	public void setEnableReportOrdering(String enableReportOrdering)
	{
	    this.enableReportOrdering = enableReportOrdering;
	}
	public boolean isRoot()
	{
		return root;
	}
	public void setRoot(boolean root)
	{
		this.root = root;
	}
	public ArrayList<MenuVO> getMenuData()
	{
		return menuData;
	}
	public void setMenuData(ArrayList<MenuVO> menuData)
	{
		this.menuData = menuData;
	}
	public String getMenuVar()
	{
		return menuVar;
	}
	public void setMenuVar(String menuVar)
	{
		this.menuVar = menuVar;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
  
}
