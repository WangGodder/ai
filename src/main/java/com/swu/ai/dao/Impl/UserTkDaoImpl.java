package com.swu.ai.dao.Impl;

import com.swu.ai.dao.UserTkDao;
import com.swu.ai.entity.UserTk;
import com.swu.ai.mapper.UserTkMapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * -------------------------------------------------
 *
 * @ Author  :       pengj
 * @ date    :       2018/12/18 17:20
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */
@Repository
public class UserTkDaoImpl implements UserTkDao {
    @Resource
    private UserTkMapper userTkMapper;

    @Override
    public Object selectByExample(Example example){
        return  userTkMapper.selectByExample(example);
    }

    @Override
    public List<UserTk> findAll(){
        return userTkMapper.findUserTkAll();
    }

    @Override
    public boolean regUser(String userId, String pwd){
        boolean r;
        UserTk userTk = new UserTk();
        userTk.setPwd(pwd);
        userTk.setUserid(userId);
        r = userTkMapper.insertSelective(userTk) > 0;
        return r;
    }

    @Override
    public UserTk getUserByUserIdAndPwd(String userId,String pwd){
        Map map = new HashMap();
        map.put("userId",userId);
        map.put("pwd",pwd);
        return userTkMapper.getUserByUserIdAndPwd(map);
    }

}
