package com.entity;

import java.io.Serializable;

/**
 * 会员表
 * @author 陈小锋
 *
 */
public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 * 商品的id
	 * 自动增长类型
	 */
   private Integer id;
   /**
    * 会员名(唯一)
    * not null
    */
   private String username;
   /**
    * 密码
    * not null
    */
   private String password;
   /**
    * 城市
    * null
    */
   private String city;
   /**
    * 地址
    * null
    */
   private String address;
   /**
    * 邮编
    * null
    */
    private String postcode;
    /**
     * 
     */
    private String cardtype;
    /**
     * 会员等级
     * null
     */
    private String grade;
    private String amount;
    /**
     * 电话
     * not null
     */
    private String tel;
    /**
     * 邮编
     * not null
     */
    private String email;
    
    /**
     * 封号
     * 默认为0   
     */
    private String freeze;
    /**
     * 构造函数，用户的必须信息
     * @param username
     * @param password
     * @param tel
     * @param email
     */
    public Member(String username,String password,String tel,String email) {
    	this.username=username;
    	this.password=password;
    	this.tel=tel;
    	this.email=email;
    }
    public Member() {
    	
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFreeze() {
		return freeze;
	}
	public void setFreeze(String freeze) {
		this.freeze = freeze;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", password=" + password + ", city=" + city
				+ ", address=" + address + ", postcode=" + postcode + ", cardtype=" + cardtype + ", grade=" + grade
				+ ", amount=" + amount + ", tel=" + tel + ", email=" + email + ", freeze=" + freeze + "]";
	}
    
    
}
