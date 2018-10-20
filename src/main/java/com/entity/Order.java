package com.entity;

import java.io.Serializable;

/**
 * 订单表
 * @author 陈小锋
 *
 */
public class Order implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 * 主键
	 */
	private Integer id;
	/**
	 *用户的姓名
	 */
	private String username;
    /**
    * 订单的id
    * 系统自动生成十四位的数
    */
	private String orderid;
	/**
	 * 品种数
	 * null
	 */
	private Integer bnumber;
	/**
	 * 收货人的姓名
	 * not null
	 */
	private String receviename;
	/**
	 * 收货人的地址
	 * not null
	 */
	private String address;
	/**
	 * 收货人的电话
	 * not null
	 */
	private String tel;
	/**
	 * 订单的日期
	 * not null
	 */
	private String orderdate;
	/**
	 * 备注 
	 * null
	 */
	private String bz;
	/**结算购物车后的总价，前台传
	 * 总价
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
