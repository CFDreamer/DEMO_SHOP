package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Member;
import com.mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	private MemberMapper mapper;
	  /**
	   * 会员注册
	   */
	 public Boolean Register(Member m) {
		 try {
			 mapper.Register(m);
			 return true;
		 }
		 catch(Exception e) {
			 return false;
		 }
	 } 
	  /**
	   * 会员登录
	   * 根据用户名判断数据库密码和输入的密码是否一致
	   */
	 public Boolean login(String username,String password) {
		 String pass=mapper.login(username);
		 if(password.equals(pass))
			 return true;
		 return false;
	 }
	 /**
	  * 获取会员信息
	  */
	 public Member selectMemberInfoByUsername(String username) {
		 return mapper.selectMemberInfoByUsername(username);
	 }
}
