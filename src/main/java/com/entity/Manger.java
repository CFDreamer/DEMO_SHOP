package com.entity;

import java.io.Serializable;

/**
 * ����Ա��
 * @author ��С��
 *
 */
public class Manger implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
    * id
    * �Զ�����
    * not null
    */
	private Integer id;
	/**
	 * ����Ա����
	 * not null
	 */
	private String manger;
	/**
	 * ����
	 * not null
	 */
	private String password;
	
	/**
	 * ����һЩ��Ҫ����Ϣ
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
