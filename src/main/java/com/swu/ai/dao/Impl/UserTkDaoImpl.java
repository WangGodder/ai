package com.swu.ai.dao.Impl;

import com.swu.ai.dao.UserTkDao;
import com.swu.ai.entity.UserTk;
import com.swu.ai.mapper.UserTkMapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

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

}
