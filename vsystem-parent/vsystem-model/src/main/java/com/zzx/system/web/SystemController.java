package com.zzx.system.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zzx.system.entity.Menu;
import com.zzx.system.entity.UserDetailsImpl;
import com.zzx.system.service.MenuService;

@RestController
public class SystemController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("login_p")
	public void  login(HttpServletResponse resp) throws IOException {
		resp.sendRedirect("/index.html");
	}
	@RequestMapping(value="/loadMenu",method=RequestMethod.POST)
	public List<Menu> loadMenu(){
		String uId = ((UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication() .getPrincipal()).getUser().getuId();
		return menuService.getMenuByUId(uId);
	}
	@RequestMapping(value="/loadPetname",method=RequestMethod.POST)
	public String loadPetname(){
		return  ((UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication() .getPrincipal()).getUser().getPetname();
	}
}
