package com.swu.ai.dao.Impl;

import com.swu.ai.dao.SysUserDao;
import com.swu.ai.entity.SysUser;
import com.swu.ai.mapper.SysUserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserDaoImpl implements SysUserDao {

	@Resource
	private SysUserMapper sysUserMapper;

//	@Resource
//	private BCryptPasswordEncoder passwordEncoder;
//			sysUser.setPassword(passwordEncoder.encode(user.getPassword()));

	@Override
	public SysUser getUser(String username) {
		SysUser sysUser = new SysUser();
		sysUser.setUsername(username);
		return sysUserMapper.selectOne(sysUser);
	}


}
