package com.zzx.system.component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException e)
			throws IOException, ServletException {
		res.setContentType("application/json;charset=utf-8"); //设置响应头信息 支持json
		PrintWriter out = null; //获取响应输出流
		Map<String,Object> map = new LinkedHashMap<>();
		try {
			out = res.getWriter();
			if(e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
				map.put("status", "error");
				map.put("msg", "用户名或密码输入错误，登录失败!");
			}else if (e instanceof DisabledException) {
				map.put("status", "error");
				map.put("msg", "账户被禁用，登录失败，请联系管理员!");
			}else {
				map.put("status", "error");
				map.put("msg", "登录失败");
			}
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(map);
			out.write(json);
		}catch (Exception exception) {
			exception.printStackTrace();
		} 
		finally {
			out.close();
		}
	}
}