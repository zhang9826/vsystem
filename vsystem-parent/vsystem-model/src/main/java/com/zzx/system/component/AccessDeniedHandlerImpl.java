package com.zzx.system.component;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
   *  出 403 异常 会走这
 * @author zzx
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

	/**
	 * 是 跳转页面 还是回显 看心情 我这做的是 回显
	 */
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("{\"status\":\"error\",\"msg\":\"权限不足，请联系管理员!\"}");
		out.flush();
		out.close();
	}
}
