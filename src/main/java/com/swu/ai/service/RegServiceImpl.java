package com.swu.ai.service;

import com.swu.ai.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@service 用于服务层的接口 其实 @service 和 @repository 功能差不多。只不过数据层用 @Repository 服务层用 @Service 显得更严谨些
@Service
public class RegServiceImpl implements RegService {
/**
    这里也可以用 @Resource 但是最好是将@Resource放在setter方法上，因为这样更符合面向对象的思想，通过set、get去操作属性
/   @Resource(name="userDao")
    public void setUserDao(UserDao userDao) { // 用于属性的setter方法上
        this.userDao = userDao;
    }*/
    @Resource
    private UserDao userDao;

    @Override
    public boolean regUser(String uerId, String pwd){
        return userDao.regUser(uerId,pwd);
    }
}
