package com.entity;

import java.io.Serializable;

/**
 * ��Ա��
 * @author ��С��
 *
 */
public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ����
	 * ��Ʒ��id
	 * �Զ���������
	 */
   private Integer id;
   /**
    * ��Ա��(Ψһ)
    * not null
    */
   private String username;
   /**
    * ����
    * not null
    */
   private String password;
   /**
    * ����
    * null
    */
   private String city;
   /**
    * ��ַ
    * null
    */
   private String address;
   /**
    * �ʱ�
    * null
    */
    private String postcode;
    /**
     * 
     */
    private String cardtype;
    /**
     * ��Ա�ȼ�
     * null
     */
    private String grade;
    private String amount;
    /**
     * �绰
     * not null
     */
    private String tel;
    /**
     * �ʱ�
     * not null
     */
    private String email;
    
    /**
     * ���
     * Ĭ��Ϊ0   
     */
    private String freeze;
    /**
     * ���캯�����û��ı�����Ϣ
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
