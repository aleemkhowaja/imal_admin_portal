package com.path.bo.common.menu;

import java.util.Collection;
import java.util.List;

import com.path.dbmaps.vo.OPTVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.vo.MenuVO;
import com.path.vo.common.menu.MenuSC;
import com.path.vo.common.menu.TreeMenuSC;

public interface MenuBO
{
    public Collection<MenuVO> getMenu(MenuSC menuSc) throws BaseException;

    public Collection<MenuVO> getHorizontalMenu(MenuSC menuSc) throws BaseException;

    /**
     * 
     * Used for returning Application list that Have Reports, used in Reporting
     * Application
     * 
     * @return
     * @throws BaseException
     */
    public Collection<MenuVO> returnReportsApps(MenuSC menuSc) throws BaseException;
    /**
     * 
     * Used for returning Category Menu
     * 
     * @param menuSc
     * @return
     * @throws BaseException
     */
    public Collection<MenuVO> returnCategMenuAndOpts(MenuSC menuSc)throws BaseException;
    
    /**
     * Used to get the List of menu to be loaded in a tree grid based on the
     * user access right
     * @author marwanmaddah
     * @date Dec 27, 2013
     * @return List<OPTVO>
     * @throws BaseException
     * 
     */
    public List<OPTVO> returnMenuList(TreeMenuSC criteria) throws BaseException;
    
    public String returnParent(TreeMenuSC criteria) throws BaseException;
}
