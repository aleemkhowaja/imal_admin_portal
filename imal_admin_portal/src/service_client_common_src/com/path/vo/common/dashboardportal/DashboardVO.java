package com.path.vo.common.dashboardportal;

import java.util.ArrayList;
import java.util.List;

public class DashboardVO  extends DashBoardBaseVO
{
    private String json_data;
    private String layout_title;
    private String layout_id;
    private String layout_classname;
    private String layout_html;
    private String layout_image;
    private String appVersion;
    /**
     * Access rights for customised functionality of workspace used in Dashboard.ftl
     */
    private String wkspceCustRight;
    /**
     * Access rights for assign functionality of widget used in Dashboard.ftl
     */
    private String wdgtAssignRight;


    public List<WidgetVO> widgetVOLst = new ArrayList<WidgetVO>();
    
    
    public String getJson_data()
    {
        return json_data;
    }
    public void setJson_data(String jsonData)
    {
        json_data = jsonData;
    }
    public String getLayout_title()
    {
        return layout_title;
    }
    public void setLayout_title(String layoutTitle)
    {
        layout_title = layoutTitle;
    }
    public String getLayout_id()
    {
        return layout_id;
    }
    public void setLayout_id(String layoutId)
    {
        layout_id = layoutId;
    }
    public String getLayout_classname()
    {
        return layout_classname;
    }
    public void setLayout_classname(String layoutClassname)
    {
        layout_classname = layoutClassname;
    }
    public String getLayout_html()
    {
        return layout_html;
    }
    public void setLayout_html(String layoutHtml)
    {
        layout_html = layoutHtml;
    }
    public String getLayout_image()
    {
        return layout_image;
    }
    public void setLayout_image(String layoutImage)
    {
        layout_image = layoutImage;
    }
    public List<WidgetVO> getWidgetVOLst()
    {
        return widgetVOLst;
    }
    public void setWidgetVOLst(List<WidgetVO> widgetVOLst)
    {
        this.widgetVOLst = widgetVOLst;
    }
    public String getWkspceCustRight()
    {
        return wkspceCustRight;
    }
    public void setWkspceCustRight(String wkspceCustRight)
    {
        this.wkspceCustRight = wkspceCustRight;
    }
    public String getWdgtAssignRight()
    {
        return wdgtAssignRight;
    }
    public void setWdgtAssignRight(String wdgtAssignRight)
    {
        this.wdgtAssignRight = wdgtAssignRight;
    }
    public String getAppVersion()
    {
        return appVersion;
    }
    public void setAppVersion(String appVersion)
    {
        this.appVersion = appVersion;
    }
    
}
