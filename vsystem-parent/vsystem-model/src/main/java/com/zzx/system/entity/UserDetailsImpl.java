package com.zzx.system.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
   *   实现UserDetails接口，供程序调用
 * @author zzx
 *
 */
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	private User user;
	
	private List<Role> roles;
	
	public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

	/**
	 * [Description:无参构造]
	 */
    public UserDetailsImpl() {
    	
    }

    /**
     * [Description:用user构造]
     * @param user
     */
    public UserDetailsImpl(User user) {
        this.user=user;
    }
    
    /**
     * [Description:用user 和 List<Role> 构造]
     * @param user
     * @param roles
     */
    public UserDetailsImpl(User user, List<Role> roles) {
    	this.user=user;  
    	this.roles = roles;    
    }

	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * [Description:返回用户所有角色的封装，一个Role对应一个GrantedAuthority]
	 *---------------------------
	 * @Date Create in  2018年9月28日 下午10:22:59
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getrName())); 
			}      
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 是否过期
	 */
	@Override
	public boolean isEnabled() {
		if(user.getEnabled().equals("1"))
			return true;
		return false;
	}
}
