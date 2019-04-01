package com.swu.ai.dao;

import com.swu.ai.entity.SysRole;

import java.util.List;

/**
 * -------------------------------------------------
 *
 * @ Author  :       Administrator
 * @ date    :       2019/4/1 0001 下午 3:54
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */
public interface SysRoleDao {
        List<SysRole> selectRolesByUserName(String username);

}
