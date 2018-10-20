package com.entity;

import java.io.Serializable;

/**
 * 购物车
 * @author 陈小锋
 *
 */
public class Car implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
   * id
   * 主键
   * 自增
   */
	private Integer id;
	/**
	 * 用户的id
	 * not null
	 */
	private Integer memberid;
	/**
	 * 商品的id
	 * not null
	 */
	private Integer goodsid;
	/**
	 * 商品的名称
	 * not null
	 */
	private String goodsname;
	/**
	 * 商品的价格
	 * not null
	 */
	private double price;
	/**
	 * 商品的数量
	 * not null
	 */
	private Integer count;
	/**
	 * 商品的图片
	 */
	private String picture;
	public Car(Integer memberid, Integer goodsid, String goodsname, double price, Integer count, String picture) {
		super();
		this.memberid = memberid;
		this.goodsid = goodsid;
		this.goodsname = goodsname;
		this.price = price;
		this.count = count;
		this.picture = picture;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public Integer getMemberid() {
		return memberid;
	}
	public Integer getGoodsid() {
		return goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public double getPrice() {
		return price;
	}
	public Integer getCount() {
		return count;
	}
	public String getPicture() {
		return picture;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public void setGoodid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", memberid=" + memberid + ", goodid=" + goodsid + ", goodsname=" + goodsname
				+ ", price=" + price + ", count=" + count + ", picture=" + picture + "]";
	}
	
	
}
