package com.swu.ai.dao;

import com.swu.ai.entity.UserTk;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * -------------------------------------------------
 *
 * @ Author  :       pengj
 * @ date    :       2018/12/18 17:19
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
}
