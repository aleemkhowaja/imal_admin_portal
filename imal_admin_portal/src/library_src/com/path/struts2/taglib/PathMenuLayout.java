package com.path.struts2.taglib;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;

import com.opensymphony.xwork2.util.ValueStack;
import com.path.vo.common.MainMenuVO;


public class PathMenuLayout extends UIBean
{
    public static final String PATH_TEMPLATE = "menulayout";
    public static final String PATH_THEME = "path-xhtml";

    protected ArrayList<MainMenuVO> list;
    
    public PathMenuLayout(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
    {
	super(stack, request, response);
    }

    protected String getDefaultTemplate()
    {
	return PATH_TEMPLATE;
    }


    @Override
    public void setTheme(String theme)
    {
	// TODO Auto-generated method stub
	super.setTheme(PATH_THEME);
    }

    @Override
    protected void evaluateExtraParams()
    {
	// TODO Auto-generated method stub
	super.evaluateExtraParams();
	addParameter("list", list);
	addParameter("id", id);
    }

    public ArrayList<MainMenuVO> getList()
    {
        return list;
    }

    public void setList(ArrayList<MainMenuVO> list)
    {
        this.list = list;
    }

}
