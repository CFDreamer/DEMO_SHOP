package com.entity;

import java.io.Serializable;

/**
 * ��Ʒ��Ϣ��
 * @author ��С��
 *
 */
public class Goods implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * ��Ʒ��id
     * ����
     * �Զ�����
     * not null
     */
	private Integer id;
	/**
	 * ��Ʒ����id
	 * not null
	 */
	private Integer typeid;
	/**
	 * ��Ʒ������
	 * not null
	 */
	private String goodsname;
	/**
	 * ��Ʒ������
	 * null
	 */
	private String introduce;
	/**
	 * ��Ʒ�Ķ���
	 * not null
	 */
	private double price;
	/**
	 * ��Ʒ���ּ�
	 * not null
	 */
	private double nowprice;
	/**
	 * ͼƬ��url
	 *not null
	 */
    private String picture;
    /**
     * ��Ʒ��¼��ʱ��
     *not null
     */
    private String intime;
    /**
     * �Ƿ�Ϊ����Ʒ
     * Ĭ��ֵΪ0(��)
     */
    private Integer newgoods;
    /**
     * �Ƿ�Ϊ������Ʒ
     * Ĭ��ֵΪ0(��)
     */
    private Integer sale;
    /**
     * �������
     * ��ʼֵΪ0
     */
    private Integer hit;
    /**
     * ��Ʒ�����������
     */
    private SuperType supertype;

	/**
     * ����һЩ��Ҫ�ĺ���
     * @param typeid
     * @param goodsname
     * @param introduce
     * @param price
     * @param nowprice
     * @param prcture
     * @param intime
     */
    /**
     * ��Ʒ������
     */
    private SuperType type;
	public SuperType getType() {
		return type;
	}
	public void setType(SuperType type) {
		this.type = type;
	}
	public Goods(Integer typeid, String goodsname, String introduce, double price, double nowprice, String picture,
			String intime) {
		super();
		this.typeid = typeid;
		this.goodsname = goodsname;
		this.introduce = introduce;
		this.price = price;
		this.nowprice = nowprice;
		this.picture = picture;
		this.intime = intime;
	}
	public Goods() {
		
	}
    public SuperType getSupertype() {
		return supertype;
	}
	public void setSupertype(SuperType supertype) {
		this.supertype = supertype;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getNowprice() {
		return nowprice;
	}
	public void setNowprice(double nowprice) {
		this.nowprice = nowprice;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public Integer getNewgoods() {
		return newgoods;
	}
	public void setNewgoods(Integer newgoods) {
		this.newgoods = newgoods;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	public Integer getHit() {
		return hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", typeid=" + typeid + ", goodsname=" + goodsname + ", introduce=" + introduce
				+ ", price=" + price + ", nowprice=" + nowprice + ", prcture=" + picture + ", intime=" + intime
				+ ", newgoods=" + newgoods + ", sale=" + sale + ", hit=" + hit + "]";
	}
	
    
	
}
