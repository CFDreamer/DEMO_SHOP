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
	   * ��Աע��
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
	   * ��Ա��¼
	   * �����û����ж����ݿ����������������Ƿ�һ��
	   */
	 public Boolean login(String username,String password) {
		 String pass=mapper.login(username);
		 if(password.equals(pass))
			 return true;
		 return false;
	 }
	 /**
	  * ��ȡ��Ա��Ϣ
	  */
	 public Member selectMemberInfoByUsername(String username) {
		 return mapper.selectMemberInfoByUsername(username);
	 }
}
