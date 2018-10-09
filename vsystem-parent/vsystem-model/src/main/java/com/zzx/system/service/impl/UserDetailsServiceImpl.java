package com.zzx.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzx.system.dao.UserDao;
import com.zzx.system.entity.User;
import com.zzx.system.entity.UserDetailsImpl;
import com.zzx.system.service.RoleService;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleService roleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		 if(user == null)
	        {
	            throw new UsernameNotFoundException("没有该用户");
	        }
		//查到User后将其封装为UserDetails的实现类的实例供程序调用
	    //用该User和它对应的Role实体们构造UserDetails的实现类
		return new UserDetailsImpl(user, roleService.getRolesByUserId(user.getuId()));
	}

}