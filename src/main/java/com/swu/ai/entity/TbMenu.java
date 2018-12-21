package com.swu.ai.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_menu")
public class TbMenu {
    /**
     * 菜单ID
     */
    @Column(name = "Id")
    @Id
    private Integer id;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单备注
     */
    @Column(name = "menu_remark")
    private String menuRemark;

    /**
     * 父菜单ID
     */
    @Column(name = "menu_parent_id")
    private Integer menuParentId;

    /**
     * 菜单URL
     */
    @Column(name = "menu_url")
    private String menuUrl;

    /**
     * 创建人ID
     */
    @Column(name = "create_user")
    private Integer createUser;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改人ID
     */
    @Column(name = "update_user")
    private Integer updateUser;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 删除标志，0:未删除，1:已删除
     */
    @Column(name = "is_delete")
    private Byte isDelete;

    /**
     * 获取菜单ID
     *
     * @return Id - 菜单ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置菜单ID
     *
     * @param id 菜单ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 获取菜单备注
     *
     * @return menu_remark - 菜单备注
     */
    public String getMenuRemark() {
        return menuRemark;
    }

    /**
     * 设置菜单备注
     *
     * @param menuRemark 菜单备注
     */
    public void setMenuRemark(String menuRemark) {
        this.menuRemark = menuRemark == null ? null : menuRemark.trim();
    }

    /**
     * 获取父菜单ID
     *
     * @return menu_parent_id - 父菜单ID
     */
    public Integer getMenuParentId() {
        return menuParentId;
    }

    /**
     * 设置父菜单ID
     *
     * @param menuParentId 父菜单ID
     */
    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    /**
     * 获取菜单URL
     *
     * @return menu_url - 菜单URL
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置菜单URL
     *
     * @param menuUrl 菜单URL
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * 获取创建人ID
     *
     * @return create_user - 创建人ID
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人ID
     *
     * @param createUser 创建人ID
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人ID
     *
     * @return update_user - 修改人ID
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置修改人ID
     *
     * @param updateUser 修改人ID
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取删除标志，0:未删除，1:已删除
     *
     * @return is_delete - 删除标志，0:未删除，1:已删除
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * 设置删除标志，0:未删除，1:已删除
     *
     * @param isDelete 删除标志，0:未删除，1:已删除
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}