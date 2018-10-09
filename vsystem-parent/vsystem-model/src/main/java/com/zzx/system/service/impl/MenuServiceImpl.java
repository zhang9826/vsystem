package com.zzx.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzx.system.dao.MenuDao;
import com.zzx.system.entity.Menu;
import com.zzx.system.entity.Role;
import com.zzx.system.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Override
	public Menu getMenuByUrl(String requestUrl) {
		return menuDao.getMenuByUrl(requestUrl);
	}

	@Override
	public List<Role> getRoles(String reId) {
		return menuDao.getRoles(reId);
	}

	@Override
	public List<Menu> getMenuByUId(String uId) {
		return menuDao.getMenuByUId(uId);
	}
}
