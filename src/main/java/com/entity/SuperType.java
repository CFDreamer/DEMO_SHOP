package com.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类别
 * @author 陈小锋
 *
 */
public class SuperType implements Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
   * id
   * 主键
   * 手工赋值
   */
	private Integer sid;
	/**
	 * 类别名称
	 * not null
	 */
	private String typename;
	/**
	 * 一个编号对应多个商品
	 */
	private List<Goods> goodsList;
	public Integer getSid() {
		return sid;
	}
	public SuperType(Integer sid, String typename) {
		super();
		this.sid = sid;
		this.typename = typename;
	}
	public String getTypename() {
		return typename;
	}
	public void setId(Integer sid) {
		this.sid = sid;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public SuperType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	@Override
	public String toString() {
		return "SuperType [id=" + sid + ", typename=" + typename + "]";
	}
	
}
