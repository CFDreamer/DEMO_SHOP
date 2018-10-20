package com.entity;

import java.io.Serializable;

/**
 * �û����ջ���ַ
 * @author ��С��
 *
 */
public class ReceiptAddress implements Serializable{
	private static final long serialVersionUID = 1L;
  /**
   * id
   * ����
   */
	private Integer id;
	/**
	 * �û�id
	 * not null
	 */
	private Integer memberid;
	/**
	 * �ջ�������
	 * not null
	 */
	private String receviename;
	/**
	 * �ջ��˵绰
	 * not null
	 */
	private String tel;
	/**
	 * �ջ��˵ĵ�ַ
	 */
	private String address;
	/**
	 * ��ַ��ʹ�ô���
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
