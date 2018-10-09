package com.zzx.system.entity;

public class Role {
	/**
	 * 角色id
	 */
	private String rId;
	/**
	 * 角色名称
	 */
	private String rName;
	/**
	 * 角色 中文名称
	 */
	private String rNameZh;
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrNameZh() {
		return rNameZh;
	}
	public void setrNameZh(String rNameZh) {
		this.rNameZh = rNameZh;
	}
}
