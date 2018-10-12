package com.zzx.system.component;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

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
	
	AntPathMatcher antPathMatcher = new AntPathMatcher();
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// 得到用户的请求地址
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
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
