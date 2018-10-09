package com.zzx.system.entity;

/**
 * 
 * 用户实体类
 * @author zzx
 *
 * @date 2018年10月9日
 */
public class User {
	/**
	 * 用户id
	 */
	private String uId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 电话号码
	 */
	private String telephone;
	/**
	 * 家庭住址
	 */
	private String address;
	/**
	 * 是否启用   1 启用 0 禁用
	 */
	private String enabled;
	/**
	 * 昵称
	 */
	private String petname;
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
}
