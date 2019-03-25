package com.swu.ai.mapper;

import com.swu.ai.Base.BaseMapper;
import com.swu.ai.entity.User;

public interface UserMapper extends BaseMapper<User> {
    User findUserById(Long id);
}