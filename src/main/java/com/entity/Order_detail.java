package com.entity;

import java.io.Serializable;

/**
	 * 
	 * @author 陈小锋
	 *
	 */
	public class Order_detail implements Serializable {
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
		 * 订单的id
		 * not null
		 * 外键
		 */
		private String orderid;
		/**
		 * 商品的名字
		 * not null
		 */
		private String goodsname;
		/**
		 * 价格
		 * not null
		 */
		
		private double price;
		/**
		 *商品 图片
		 */
		private String picture;
		public String getGoodsname() {
			return goodsname;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		/**
		 * 商品数量
		 */
		private Integer number;
		
		public Order_detail(String orderid, String goodsname, double price, String picture, Integer number) {
			super();
			this.orderid = orderid;
			this.goodsname = goodsname;
			this.price = price;
			this.picture = picture;
			this.number = number;
		}
		public Order_detail() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Integer getId() {
			return id;
		}
		public String getOrderid() {
			return orderid;
		}
		public String getGoodsid() {
			return goodsname;
		}
		public double getPrice() {
			return price;
		}
		public Integer getNumber() {
			return number;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public void setOrderid(String orderid) {
			this.orderid = orderid;
		}
		public void setGoodsname(String goodsname) {
			this.goodsname = goodsname;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public void setNumber(Integer number) {
			this.number = number;
		}
		@Override
		public String toString() {
			return "Order_detail [id=" + id + ", orderid=" + orderid + ", goodsid=" + goodsname + ", price=" + price
					+ ", number=" + number + "]";
		}
		
		
	}
