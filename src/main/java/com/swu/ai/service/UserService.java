package com.swu.ai.service;

import com.swu.ai.entity.User;
import com.swu.ai.entity.UserTk;

/**
 * @author mhp
 * @date 2019/3/2 17:32
 */
public interface UserService {
    UserTk getUserByUserIdAndPwd(String userId,String pwd);

    User getUserByUserTk(UserTk userTk);
}
