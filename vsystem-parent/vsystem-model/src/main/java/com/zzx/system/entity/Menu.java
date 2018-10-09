package com.zzx.system.entity;

/**
 * 菜单实体类
 * @author zzx
 *
 * @date 2018年10月9日
 */
public class Menu {
	
	/**
	 * 菜单id
	 */
	private String mId;
	/**
	 * 被管理的url
	 */
	private String url;
	/**
	 * 路由  vue 用的
	 */
	private String route;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 父菜单的id
	 */
	private String parentId;
	
	/**
	 *  菜单的展示顺序
	 */
	private int mOrder;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getmOrder() {
		return mOrder;
	}

	public void setmOrder(int mOrder) {
		this.mOrder = mOrder;
	}
}
