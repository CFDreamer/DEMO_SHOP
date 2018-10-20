package com.entity;

import java.io.Serializable;

/**
 * 管理员表
 * @author 陈小锋
 *
 */
public class Manger implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
    * id
    * 自动增长
    * not null
    */
	private Integer id;
	/**
	 * 管理员名字
	 * not null
	 */
	private String manger;
	/**
	 * 密码
	 * not null
	 */
	private String password;
	
	/**
	 * 构造一些必要的信息
	 * @param manger
	 * @param password
	 */
	public Manger(String manger, String password) {
		super();
		this.manger = manger;
		this.password = password;
	}
	public Manger() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getManger() {
		return manger;
	}
	public void setManger(String manger) {
		this.manger = manger;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Manger [id=" + id + ", manger=" + manger + ", password=" + password + "]";
	}
	
	
}
