package com.path.vo.common.dashboardportal;

import com.path.dbmaps.vo.SYS_PARAM_PORTLET_TYPEVO;
import com.path.dbmaps.vo.USER_PORTLETSVO;

public class WidgetVO  extends DashBoardBaseVO
{
    SYS_PARAM_PORTLET_TYPEVO portletTypeVO;
    USER_PORTLETSVO userPortlets;
    String title;
    String titleKey;
    String id;
    String column;
    String url;
    String editurl;
    boolean open ;
    String edit;
    String widgetTemplate;
    String abvTitle;
    String defaultImg;
    String imgUrl;
    String userDefinedType;
    String loadingTrans;
    String customHeight;
    String wrkspceCustDisplay;
    String wdgtAssignDisplay;
    
    String repUrl;
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getColumn()
    {
        return column;
    }
    public void setColumn(String column)
    {
        this.column = column;
    }
    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }
    public String getEditurl()
    {
        return editurl;
    }
    public void setEditurl(String editurl)
    {
        this.editurl = editurl;
    }
    public boolean isOpen()
    {
        return open;
    }
    public void setOpen(boolean open)
    {
        this.open = open;
    }
    public String getEdit()
    {
        return edit;
    }
    public void setEdit(String edit)
    {
        this.edit = edit;
    }
    public String getWidgetTemplate()
    {
        return widgetTemplate;
    }
    public void setWidgetTemplate(String widgetTemplate)
    {
        this.widgetTemplate = widgetTemplate;
    }
    public String getAbvTitle()
    {
        return abvTitle;
    }
    public void setAbvTitle(String abvTitle)
    {
        this.abvTitle = abvTitle;
    }
    public String getDefaultImg()
    {
        return defaultImg;
    }
    public void setDefaultImg(String defaultImg)
    {
        this.defaultImg = defaultImg;
    }
    public String getImgUrl()
    {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }
    public SYS_PARAM_PORTLET_TYPEVO getPortletTypeVO()
    {
        return portletTypeVO;
    }
    public void setPortletTypeVO(SYS_PARAM_PORTLET_TYPEVO portletTypeVO)
    {
        this.portletTypeVO = portletTypeVO;
    }
    public USER_PORTLETSVO getUserPortlets()
    {
        return userPortlets;
    }
    public void setUserPortlets(USER_PORTLETSVO userPortlets)
    {
        this.userPortlets = userPortlets;
    }
    public String getTitleKey()
    {
        return titleKey;
    }
    public void setTitleKey(String titleKey)
    {
        this.titleKey = titleKey;
    }
    public String getUserDefinedType()
    {
        return userDefinedType;
    }
    public void setUserDefinedType(String userDefinedType)
    {
        this.userDefinedType = userDefinedType;
    }
    public String getLoadingTrans()
    {
        return loadingTrans;
    }
    public void setLoadingTrans(String loadingTrans)
    {
        this.loadingTrans = loadingTrans;
    }
    public String getCustomHeight()
    {
        return customHeight;
    }
    public void setCustomHeight(String customHeight)
    {
        this.customHeight = customHeight;
    }
    public String getWrkspceCustDisplay()
    {
        return wrkspceCustDisplay;
    }
    public void setWrkspceCustDisplay(String wrkspceCustDisplay)
    {
        this.wrkspceCustDisplay = wrkspceCustDisplay;
    }
    public String getWdgtAssignDisplay()
    {
        return wdgtAssignDisplay;
    }
    public void setWdgtAssignDisplay(String wdgtAssignDisplay)
    {
        this.wdgtAssignDisplay = wdgtAssignDisplay;
    }
    /**
     * @return the repUrl
     */
    public String getRepUrl()
    {
        return repUrl;
    }
    /**
     * @param repUrl the repUrl to set
     */
    public void setRepUrl(String repUrl)
    {
        this.repUrl = repUrl;
    }
}
