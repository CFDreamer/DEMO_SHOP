package com.entity;

import java.io.Serializable;

/**
 * ���ﳵ
 * @author ��С��
 *
 */
public class Car implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
   * id
   * ����
   * ����
   */
	private Integer id;
	/**
	 * �û���id
	 * not null
	 */
	private Integer memberid;
	/**
	 * ��Ʒ��id
	 * not null
	 */
	private Integer goodsid;
	/**
	 * ��Ʒ������
	 * not null
	 */
	private String goodsname;
	/**
	 * ��Ʒ�ļ۸�
	 * not null
	 */
	private double price;
	/**
	 * ��Ʒ������
	 * not null
	 */
	private Integer count;
	/**
	 * ��Ʒ��ͼƬ
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
