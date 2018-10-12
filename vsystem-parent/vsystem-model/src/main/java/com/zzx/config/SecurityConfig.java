package com.zzx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.zzx.system.component.AccessDecisionManagerImpl;
import com.zzx.system.component.AccessDeniedHandlerImpl;
import com.zzx.system.component.AuthenticationSuccessHandlerImpl;
import com.zzx.system.component.UrlFilterInvocationSecurityMetadataSourceImpl;
import com.zzx.system.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	/**
	 * 访问页面查看 所需要的权限
	 */
	@Autowired
	private UrlFilterInvocationSecurityMetadataSourceImpl filterInvocationSecurityMetadataSourceImpl;

	/**
	 * 接收一个用户的信息和访问一个url所需要的权限，判断该用户是否可以访问
	 */
	@Autowired
	private AccessDecisionManagerImpl accessDecisionManagerImpl;
	
	@Autowired
	private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;

	/**
	 * 403 权限不足 页面
	 */
	@Autowired
	private AccessDeniedHandlerImpl accessDeniedHandlerImpl;
	
	@Autowired
	AuthenticationFailureHandler AuthenticationFailureHandlerImpl;

	/**
	 * 定义认证用户信息获取来源，密码校验规则等 注入实现接口UserDetailsService 的userService中 这个貌似走的默认
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		auth.userDetailsService(userDetailsServiceImpl);
	}

	/**
	 * 这些资源 直接绕过spring security
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/index.html", "/static/**","/login_p");
	}

	/**
	 * 核心校验 安全策略
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest() 
		.authenticated() 					//所有请求 都被security管理
		.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
			public <O extends FilterSecurityInterceptor> O postProcess(
					O fsi) {
				fsi.setSecurityMetadataSource(filterInvocationSecurityMetadataSourceImpl);
				fsi.setAccessDecisionManager(accessDecisionManagerImpl);
				return fsi;
			}
			}
		)
		.and()
		.formLogin() 						//允许用户进行基于表单的认证
		.loginPage("/login_p") 				//登录页面
		.loginProcessingUrl("/login")
		.usernameParameter("username")  //指定用户名接收的名称
		.passwordParameter("password")  //指定密码接收的名称
		.permitAll() 						//允许基于表单登录的所有的URL 的所有用户的访问。
		.failureHandler(AuthenticationFailureHandlerImpl)
		.successHandler(authenticationSuccessHandlerImpl)
		.and()
		.httpBasic()
		.and()
		.logout() 							//提供注销支持，使用WebSecurityConfigurerAdapter会自动被应用
		.permitAll()		
		.and()
		.csrf()
		.disable()					//禁掉csrf  后面加
		.exceptionHandling()
		.accessDeniedHandler(accessDeniedHandlerImpl);
		http
		.sessionManagement()
		.maximumSessions(1)
		.expiredUrl("/login");
	}
}
