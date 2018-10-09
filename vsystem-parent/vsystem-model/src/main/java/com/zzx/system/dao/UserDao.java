package com.zzx.system.dao;

import org.apache.ibatis.annotations.Param;

import com.zzx.system.entity.User;

public interface UserDao {

	User findByUsername(@Param("username") String username);

}
