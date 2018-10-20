package com.entity;

import java.io.Serializable;

/**
 * ������
 * @author ��С��
 *
 */
public class Order implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 * ����
	 */
	private Integer id;
	/**
	 *�û�������
	 */
	private String username;
    /**
    * ������id
    * ϵͳ�Զ�����ʮ��λ����
    */
	private String orderid;
	/**
	 * Ʒ����
	 * null
	 */
	private Integer bnumber;
	/**
	 * �ջ��˵�����
	 * not null
	 */
	private String receviename;
	/**
	 * �ջ��˵ĵ�ַ
	 * not null
	 */
	private String address;
	/**
	 * �ջ��˵ĵ绰
	 * not null
	 */
	private String tel;
	/**
	 * ����������
	 * not null
	 */
	private String orderdate;
	/**
	 * ��ע 
	 * null
	 */
	private String bz;
	/**���㹺�ﳵ����ܼۣ�ǰ̨��
	 * �ܼ�
	 */
	private double allprice;
	public double getAllprice() {
		return allprice;
	}
	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}
	public String getOrderid() {
		return orderid;
	}
	public Integer getBnumber() {
		return bnumber;
	}
	public String getReceviename() {
		return receviename;
	}
	public String getAddress() {
		return address;
	}
	public String getTel() {
		return tel;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public String getBz() {
		return bz;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public void setBnumber(Integer bnumber) {
		this.bnumber = bnumber;
	}
	public void setReceviename(String receviename) {
		this.receviename = receviename;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Order(String username, String orderid, Integer bnumber, String receviename, String address, String tel,
			String orderdate, double allprice) {
		super();
		this.username = username;
		this.orderid = orderid;
		this.bnumber = bnumber;
		this.receviename = receviename;
		this.address = address;
		this.tel = tel;
		this.orderdate = orderdate;
		this.allprice = allprice;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", bnumber=" + bnumber + ", receviename=" + receviename + ", address="
				+ address + ", tel=" + tel + ", orderdate=" + orderdate + ", bz=" + bz + "]";
	}
	
}
