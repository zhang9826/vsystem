package com.zzx.system.service;

import java.util.List;

import com.zzx.system.entity.Menu;
import com.zzx.system.entity.Role;

public interface MenuService {

	Menu getMenuByUrl(String requestUrl);

	List<Role> getRoles(String reId);

	List<Menu> getMenuByUId(String uId);

}
