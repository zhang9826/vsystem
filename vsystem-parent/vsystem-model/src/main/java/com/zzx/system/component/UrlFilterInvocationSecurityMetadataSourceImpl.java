package com.zzx.system.component;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.zzx.system.entity.Menu;
import com.zzx.system.entity.Role;
import com.zzx.system.service.MenuService;


/**
 * spring security 核心拦截器
 * 
 * @author zzx
 *
 */
@Component
public class UrlFilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {
	@Autowired
	private MenuService menuService;
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// 得到用户的请求地址
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		// 如果登录页面就不需要权限 直接放他走 本来这里想写注册的 但是管理系统没有注册 用户只能由超级管理员加 所以就算啦
		if ("/login_p".equals(requestUrl)) {
			return null;
		}
		Menu menu = menuService.getMenuByUrl(requestUrl);
		// 这里 路径对应的菜单没有 登录 后才可以访问
		if (menu == null) {
			return SecurityConfig.createList("ROLE_LOGIN");
		}
		// 将resource所需要到的roles按框架要求封装返回
		List<Role> roles = menuService.getRoles(menu.getmId());
		String[] values = new String[roles.size()];
		for (int i = 0; i < values.length; i++) {
			values[i] = roles.get(i).getrName();
		}
		return SecurityConfig.createList(values);
	}
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		 return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
