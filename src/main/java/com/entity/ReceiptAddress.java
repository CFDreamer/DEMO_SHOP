package com.entity;

import java.io.Serializable;

/**
 * 用户的收货地址
 * @author 陈小锋
 *
 */
public class ReceiptAddress implements Serializable{
	private static final long serialVersionUID = 1L;
  /**
   * id
   * 自增
   */
	private Integer id;
	/**
	 * 用户id
	 * not null
	 */
	private Integer memberid;
	/**
	 * 收货人姓名
	 * not null
	 */
	private String receviename;
	/**
	 * 收货人电话
	 * not null
	 */
	private String tel;
	/**
	 * 收货人的地址
	 */
	private String address;
	/**
	 * 地址的使用次数
	 */
	private Integer usecount;
	public Integer getId() {
		return id;
	}
	public Integer getMemberid() {
		return memberid;
	}
	public String getReceviename() {
		return receviename;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	public Integer getUsecount() {
		return usecount;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public void setReceviename(String receviename) {
		this.receviename = receviename;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setUsecount(Integer usecount) {
		this.usecount = usecount;
	}
	public ReceiptAddress(Integer memberid, String receviename, String tel, String address) {
		super();
		this.memberid = memberid;
		this.receviename = receviename;
		this.tel = tel;
		this.address = address;
	}
	public ReceiptAddress() {
		super();
	}
	@Override
	public String toString() {
		return "ReceiptAddress [id=" + id + ", memberid=" + memberid + ", receviename=" + receviename + ", tel=" + tel
				+ ", address=" + address + ", usecount=" + usecount + "]";
	}
	
}
