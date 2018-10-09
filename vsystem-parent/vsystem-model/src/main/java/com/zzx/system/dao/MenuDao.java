package com.zzx.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzx.system.entity.Menu;
import com.zzx.system.entity.Role;

public interface MenuDao {

	Menu getMenuByUrl(@Param("requestUrl") String requestUrl);

	List<Role> getRoles(@Param("mId") String mId);

	List<Menu> getMenuByUId(@Param("uId")String uId);

}
