package com.zzx.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzx.system.entity.Role;

public interface RoleDao {
	List<Role> getRolesByUserId(@Param("uId") String uId);
}
