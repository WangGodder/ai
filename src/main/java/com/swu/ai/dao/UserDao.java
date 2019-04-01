package com.swu.ai.dao;

import com.swu.ai.entity.User;

/**
 * @author: godder
 * @date: 2019/3/25
 */
public interface UserDao {
    User findUserById(Long id);

//    UserRole findUserRoleById(Long id);
}
