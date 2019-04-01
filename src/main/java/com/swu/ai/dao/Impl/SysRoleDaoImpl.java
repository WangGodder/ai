package com.swu.ai.dao.Impl;

import com.swu.ai.dao.SysRoleDao;
import com.swu.ai.entity.SysRole;
import com.swu.ai.mapper.SysRoleMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * -------------------------------------------------
 *
 * @ Author  :       Administrator
 * @ date    :       2019/4/1 0001 下午 3:55
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */
@Repository
public class SysRoleDaoImpl implements SysRoleDao {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> selectRolesByUserName(String username) {
        return sysRoleMapper.selectRolesByUserName(username);
    }
}
