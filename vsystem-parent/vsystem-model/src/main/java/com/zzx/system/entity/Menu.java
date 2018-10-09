package com.zzx.system.entity;

import java.util.List;

/**
 *   菜单实体类
 * 
 * @author zzx
 *
 */
public class Menu {
	/**
	 * 菜单id
	 */
	private String mId;
	
	/**
	 * 父菜单id
	 */
	private String parentId;
	
	/**
	 * 允许登录访问的url
	 */
	private String url;
	/**
	 * 路由
	 */
	private String route;
	
	/**
	 * 资源名称
	 */
	private String name;
	
	/**
	 * 子菜单
	 */
	private List<Menu> childrenMenus;
	
	private String icon;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Menu> getChildrenMenus() {
		return childrenMenus;
	}

	public void setChildrenMenus(List<Menu> childrenMenus) {
		this.childrenMenus = childrenMenus;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Menu [mId=" + mId + ", parentId=" + parentId + ", url=" + url + ", route=" + route + ", name=" + name
				+ ", childrenMenus=" + childrenMenus + "]";
	}
}
