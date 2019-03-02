package com.swu.ai.service.Impl;

import com.swu.ai.dao.UserTkDao;
import com.swu.ai.entity.UserTk;
import com.swu.ai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mhp
 * @date 2019/3/2 17:34
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserTkDao userTkDao;

    @Override
    public UserTk getUserByUserIdAndPwd(String userId, String pwd) {
        return userTkDao.getUserByUserIdAndPwd(userId,pwd);
    }
}
