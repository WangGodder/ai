package com.swu.ai.dao.Impl;

import com.swu.ai.dao.UserDao;
import com.swu.ai.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


//Dao 用 @Repository 表示数据层的操作,用@Service也可以，只不过数据层用 @Repository 服务层用 @Service 显得更严谨些
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean regUser(String uerId, String pwd) {
        boolean flag;
        try {
            flag = userMapper.insertUsers(uerId, pwd);
        } catch (Exception e) {
            return false;
        }
        return flag;
    }

}
