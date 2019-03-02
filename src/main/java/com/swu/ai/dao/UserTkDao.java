package com.swu.ai.dao;

import com.swu.ai.entity.UserTk;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * -------------------------------------------------
 *
 * @ Author  :       彭健彪
 * @ date    :       2019/2/27 11:00
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */
public interface UserTkDao {
    Object selectByExample(Example example);

    List<UserTk> findAll();

    UserTk getUserByUserIdAndPwd(String userId,String pwd);

    boolean regUser(String uerId, String pwd);
}
