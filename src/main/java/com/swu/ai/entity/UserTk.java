package com.swu.ai.entity;

import javax.persistence.*;

@Table(name = "user_tk")
public class UserTk {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 用户
     */
    private String userid;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取密码
     *
     * @return pwd - 密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置密码
     *
     * @param pwd 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * 获取用户
     *
     * @return userid - 用户
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户
     *
     * @param userid 用户
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}