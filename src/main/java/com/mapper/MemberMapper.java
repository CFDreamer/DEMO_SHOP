package com.mapper;

import org.apache.ibatis.annotations.Param;

import com.entity.Member;

public interface MemberMapper {
  /**
   * ��Աע��
   */
 public void Register(@Param("member") Member m) ;
  /**
   * ��Ա��¼
   */
 public String login(@Param("username") String username);
   /**
    * ��ѯ�û���Ϣ
    */
  public Member selectMemberInfoByUsername(@Param("username") String username) ;
	  
  }
