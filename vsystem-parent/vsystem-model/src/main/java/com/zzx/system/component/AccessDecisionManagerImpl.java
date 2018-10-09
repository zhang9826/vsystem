package com.zzx.system.component;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * 是否可以登录
 * 
 * @author zzx
 *
 */
@Component
public class AccessDecisionManagerImpl implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		// 迭代器遍历目标url的菜单列表
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute ca = iterator.next();
			String needRole = ca.getAttribute();
			if ("ROLE_LOGIN".equals(needRole)) {
				//需要访问的角色为ROLE_LOGIN 那就说明 此页面为登陆后可以访问的页面
				if (authentication instanceof AnonymousAuthenticationToken) {
					//用户没有登录 抛异常 登录失败
					throw new BadCredentialsException("未登录");
				} else
					//没有异常 这步 认证结束 
					return;
			}
			// 遍历当前用户所具有的权限
			Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			for (GrantedAuthority authority : authorities) {
				if (authority.getAuthority().equals(needRole)) {
					//需要的角色 当前登录用户如果有 那么 这步认证也没有异常  认证通过
					return;
				}
			}
			// 执行到这里说明没有匹配到应有权限
			throw new AccessDeniedException("权限不足!");
		}
	}
	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}
