package cn.bdqn.tangcco.lookwell.entity;

import java.util.Date;

public class Menu {
    private Integer menuId;

    private String text;//为简化传值，给属性menu_name取别名text

    private String menuUrl;

    private Date createTime;

    private Date updateTime;

    private Integer parentId;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", text='" + text + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", parentId=" + parentId +
                '}';
    }
}