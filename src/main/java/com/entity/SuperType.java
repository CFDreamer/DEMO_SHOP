package com.entity;

import java.io.Serializable;
import java.util.List;

/**
 * ��Ʒ���
 * @author ��С��
 *
 */
public class SuperType implements Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
   * id
   * ����
   * �ֹ���ֵ
   */
	private Integer sid;
	/**
	 * �������
	 * not null
	 */
	private String typename;
	/**
	 * һ����Ŷ�Ӧ�����Ʒ
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
