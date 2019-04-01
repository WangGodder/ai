package com.swu.ai.service.Impl;

import com.swu.ai.dao.SysRoleDao;
import com.swu.ai.dao.SysUserDao;
import com.swu.ai.entity.SysRole;
import com.swu.ai.entity.SysUser;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 首先我们需要自定义 UserDetailsService ，将用户信息和权限注入进来。
 *
 * 我们需要重写 loadUserByUsername 方法，参数是用户输入的用户名。
 *
 * 返回值是UserDetails，这是一个接口，一般使用它的子类org.springframework.security.core.userdetails.User，
 * 它有三个参数，分别是用户名、密码和权限集。
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Resource
	private SysUserDao sysUserDao;
	@Resource
	private SysRoleDao sysRoleDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		// 从数据库中取出用户信息
		SysUser user = sysUserDao.getUser(username);
		// 判断用户是否存在
		if (user == null) {
			throw new AuthenticationCredentialsNotFoundException("用户名不存在");
//		} else if (sysUser.getStatus() == SysUser.Status.DISABLED) {
//			throw new LockedException("用户无效,请联系管理员");
//		} else if (sysUser.getStatus() == SysUser.Status.LOCKED) {
//			throw new DisabledException("用户已作废");
		}

//		LoginUser loginUser = new LoginUser();
//		BeanUtils.copyProperties(sysUser, loginUser);
//
//		List<Permission> permissions = permissionDao.listByUserId(sysUser.getId());
//		loginUser.setPermissions(permissions);
//
//		return loginUser;

		// 添加权限
        List<SysRole> sysRoles = sysRoleDao.selectRolesByUserName(username);
		for (SysRole role : sysRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        // 返回UserDetails实现类
        return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
