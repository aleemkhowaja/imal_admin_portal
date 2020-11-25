package com.path.actions.common.horizontalmenu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import com.path.bo.common.menu.MenuBO;
import com.path.lib.vo.MenuVO;
import com.path.struts2.lib.common.base.BaseMenuAction;
import com.path.vo.common.menu.MenuSC;

@SuppressWarnings("serial")
public class HorizontalMenuAction extends BaseMenuAction
{

    public String showMenu()
    {
	return "showMenu";
    }

    private MenuBO menuBO;

    private String menuId;

    public MenuBO getMenuBO()
    {
	return menuBO;
    }

    public void setMenuBO(MenuBO menuBO)
    {
	this.menuBO = menuBO;
    }

    public String generateHorizontalMenuOnRequest()
    {
	try
	{

	    if(menuId == null || "".equals(menuId))
	    {
		menuId = "ROOT";
		root = true;
	    }

	    getRequestedMenuData(menuId);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    private void getRequestedMenuData(String menuId)
    {

	try
	{
	    MenuSC menuSC = new MenuSC();
	    menuSC.setAppName("IIS");
	    menuSC.setProgRef(menuId);
	    String compCode = "1", branchCode = "1";
	    menuSC.setCompCode(new BigDecimal(compCode));
	    menuSC.setBranchCode(new BigDecimal(branchCode));
	    menuSC.setUsrName("0111");
	    // to be changed later to DB values
	    menuSC.setLanguage("eng");
	    menuSC.setProfType("1");

	    // menuData = new MenuData()

	    Collection<MenuVO> collnMenu = new ArrayList<MenuVO>();

	    // collnMenu = menuBO.getHorizontalMenu(menuSC);

	    // below if else block is not required when we make BO call
	    if(root)
	    {
		for(int i = 0; i < 43; i++)
		{
		    MenuVO menuVO = new MenuVO();
		    if(i % 2 == 0)
		    {
			menuVO.setLeaf(true);
			menuVO.setOnLeafClick("addMenuTab(1," + i + ")");
		    }
		    else
		    {
			menuVO.setOnLeafClick("");
		    }
		    menuVO.setMenuName("Item " + i);
		    menuVO.setMenuVar(i + "001");

		    collnMenu.add(menuVO);
		}
	    }
	    else
	    {
		collnMenu = getRequestedMenuDataTemp(menuId);
	    }

	    // menuData.setMenuItemList(collnMenu);
	    menuData.addAll(collnMenu);

	}
	catch(Exception e)
	{
	    log.error(e, "error in getRequestedMenuData ");
	    handleException(e, null, null);
	}

    }

    /**
     * Remove this function
     * 
     * @param menuId
     * @return
     */
    private Collection<MenuVO> getRequestedMenuDataTemp(String menuId)
    {
	Collection<MenuVO> menuData = null;

	try
	{
	    int newMenuId = -1;
	    if(menuId.startsWith("sub"))
	    {
		newMenuId = Integer.parseInt(menuId.substring(3));
	    }
	    else
	    {
		newMenuId = Integer.parseInt(menuId);
	    }

	    newMenuId++;
	    menuData = new ArrayList<MenuVO>();
	    MenuVO menuVO = new MenuVO();
	    menuVO.setLeaf(false);
	    menuVO.setMenuName("Item" + newMenuId);
	    menuVO.setMenuVar("sub" + newMenuId);
	    menuData.add(menuVO);

	    newMenuId++;
	    menuVO = new MenuVO();
	    menuVO.setLeaf(true);
	    menuVO.setOnLeafClick("addMenuTab('1','Sub1')");
	    menuVO.setMenuName("Item" + newMenuId);
	    menuVO.setMenuVar("sub" + newMenuId);
	    menuData.add(menuVO);

	    newMenuId++;
	    menuVO = new MenuVO();
	    menuVO.setLeaf(true);
	    menuVO.setOnLeafClick("addMenuTab('2','Sub2')");
	    menuVO.setMenuName("Item" + newMenuId);
	    menuVO.setMenuVar("sub" + newMenuId);
	    menuData.add(menuVO);

	    newMenuId++;
	    menuVO = new MenuVO();
	    menuVO.setLeaf(true);
	    menuVO.setOnLeafClick("addMenuTab('3','Sub3')");
	    menuVO.setMenuName("Item" + newMenuId);
	    menuVO.setMenuVar("sub" + newMenuId);
	    menuData.add(menuVO);

	}
	catch(Exception e)
	{
	    log.error(e, "error in getRequestedMenuData ");
	    handleException(e, null, null);
	}

	return menuData;
    }

    public String getMenuId()
    {
	return menuId;
    }

    public void setMenuId(String menuId)
    {
	this.menuId = menuId;
    }

    public String loadTargetScreen()
    {
	try
	{
	    return getMenuVar();
	}
	catch(Exception ex)
	{
	    log.error(ex, "ERROR in loadTargetScreen");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

}
