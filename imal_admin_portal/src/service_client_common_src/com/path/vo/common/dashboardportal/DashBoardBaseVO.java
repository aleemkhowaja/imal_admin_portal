package com.path.vo.common.dashboardportal;

import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: deniskhaddad
 * 
 *          DashBoardBaseVO.java used to hold common properties between all
 *          widgets
 */
public class DashBoardBaseVO extends BaseVO
{
    private String minimize;
    private String maximize;
    private String refresh;
    private String del;
    private String resize_key_trans;
    private String customize_key_trans;
    private String assign_key_trans;
    private String wdgtDeleteDisplay;

    public String getMinimize()
    {
	return minimize;
    }

    public void setMinimize(String minimize)
    {
	this.minimize = minimize;
    }

    public String getMaximize()
    {
	return maximize;
    }

    public void setMaximize(String maximize)
    {
	this.maximize = maximize;
    }

    public String getRefresh()
    {
	return refresh;
    }

    public void setRefresh(String refresh)
    {
	this.refresh = refresh;
    }

    public String getDel()
    {
	return del;
    }

    public void setDel(String del)
    {
	this.del = del;
    }

    public String getWdgtDeleteDisplay()
    {
	return wdgtDeleteDisplay;
    }

    public void setWdgtDeleteDisplay(String wdgtDeleteDisplay)
    {
	this.wdgtDeleteDisplay = wdgtDeleteDisplay;
    }

    public String getResize_key_trans()
    {
        return resize_key_trans;
    }

    public void setResize_key_trans(String resize_key_trans)
    {
        this.resize_key_trans = resize_key_trans;
    }

    public String getCustomize_key_trans()
    {
        return customize_key_trans;
    }

    public void setCustomize_key_trans(String customize_key_trans)
    {
        this.customize_key_trans = customize_key_trans;
    }

    public String getAssign_key_trans()
    {
        return assign_key_trans;
    }

    public void setAssign_key_trans(String assign_key_trans)
    {
        this.assign_key_trans = assign_key_trans;
    }

}
