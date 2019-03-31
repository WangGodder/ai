package com.swu.ai.mapper;

import com.swu.ai.Base.BaseMapper;
import com.swu.ai.entity.UserRole;

public interface UserRoleMapper extends BaseMapper<UserRole> {
    UserRole findUserRoleById(Long id);
}