package com.zzx.system.component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 321
 * @date 2018年10月10日 下午10:35:34
 *
 */
@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {


	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication authentication)
			throws IOException, ServletException {
		res.setContentType("application/json;charset=utf-8"); //设置响应头信息 支持json
		PrintWriter out = null;
		Map<String,Object> map = new LinkedHashMap<>();
		try {
			out = res.getWriter();
			map.put("status", "success");
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
