package com.zzx.system.entity;

/**
 * 权限实体类
 * @author zzx
 *
 * @date 2018年10月9日
 */
public class Role {
	/**
	 * 权限id
	 */
	private String rId;
	/**
	 * 权限名称 security 识别 ROUTE_** 格式
	 */
	private String routeName;
	/**
	 * 权限名称 中文
	 */
	private String routeNameZh;
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getRouteNameZh() {
		return routeNameZh;
	}
	public void setRouteNameZh(String routeNameZh) {
		this.routeNameZh = routeNameZh;
	}
}
