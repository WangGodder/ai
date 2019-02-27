package com.swu.ai.mapper;

import com.swu.ai.Base.BaseMapper;
import com.swu.ai.entity.UserTk;

import java.util.List;

public interface UserTkMapper extends BaseMapper<UserTk> {
    List<UserTk> findUserTkAll();

}