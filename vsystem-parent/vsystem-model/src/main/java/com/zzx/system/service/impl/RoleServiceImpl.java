package com.zzx.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzx.system.dao.RoleDao;
import com.zzx.system.entity.Role;
import com.zzx.system.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired 
	private RoleDao roleDao;
	@Override
	public List<Role> getRolesByUserId(String uId) {
		return roleDao.getRolesByUserId(uId);
	}
}
