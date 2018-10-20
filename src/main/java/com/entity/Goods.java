package com.entity;

import java.io.Serializable;

/**
 * 商品信息表
 * @author 陈小锋
 *
 */
public class Goods implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 商品的id
     * 主键
     * 自动增长
     * not null
     */
	private Integer id;
	/**
	 * 商品类型id
	 * not null
	 */
	private Integer typeid;
	/**
	 * 商品的名称
	 * not null
	 */
	private String goodsname;
	/**
	 * 商品的描述
	 * null
	 */
	private String introduce;
	/**
	 * 商品的定价
	 * not null
	 */
	private double price;
	/**
	 * 商品的现价
	 * not null
	 */
	private double nowprice;
	/**
	 * 图片的url
	 *not null
	 */
    private String picture;
    /**
     * 商品的录入时间
     *not null
     */
    private String intime;
    /**
     * 是否为新商品
     * 默认值为0(否)
     */
    private Integer newgoods;
    /**
     * 是否为热卖商品
     * 默认值为0(否)
     */
    private Integer sale;
    /**
     * 点击次数
     * 初始值为0
     */
    private Integer hit;
    /**
     * 商品种类类的引用
     */
    private SuperType supertype;

	/**
     * 构造一些必要的函数
     * @param typeid
     * @param goodsname
     * @param introduce
     * @param price
     * @param nowprice
     * @param prcture
     * @param intime
     */
    /**
     * 商品的类型
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
