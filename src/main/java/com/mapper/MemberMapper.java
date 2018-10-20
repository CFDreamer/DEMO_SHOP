package com.mapper;

import org.apache.ibatis.annotations.Param;

import com.entity.Member;

public interface MemberMapper {
  /**
   * 会员注册
   */
 public void Register(@Param("member") Member m) ;
  /**
   * 会员登录
   */
 public String login(@Param("username") String username);
   /**
    * 查询用户信息
    */
  public Member selectMemberInfoByUsername(@Param("username") String username) ;
	  
  }
