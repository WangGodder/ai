package com.swu.ai.mapper;

import com.swu.ai.Base.BaseMapper;
import com.swu.ai.entity.UserTk;

import java.util.List;
import java.util.Map;

public interface UserTkMapper extends BaseMapper<UserTk> {
    List<UserTk> findUserTkAll();
    UserTk getUserByUserIdAndPwd(Map map);
}