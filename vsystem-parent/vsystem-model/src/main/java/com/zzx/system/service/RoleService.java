package com.zzx.system.service;

import java.util.List;

import com.zzx.system.entity.Role;

public interface RoleService {

	List<Role> getRolesByUserId(String uId);

}
