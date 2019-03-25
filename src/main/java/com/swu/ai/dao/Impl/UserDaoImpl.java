package com.swu.ai.dao.Impl;

import com.swu.ai.dao.UserDao;
import com.swu.ai.entity.User;
import com.swu.ai.entity.UserRole;
import com.swu.ai.mapper.UserMapper;
import com.swu.ai.mapper.UserRoleMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author: godder
 * @date: 2019/3/25
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    @Override
    public UserRole findUserRoleById(Long id) {
        return userRoleMapper.findUserRoleById(id);
    }
}
