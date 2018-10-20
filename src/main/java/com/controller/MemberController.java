package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.entity.Member;
import com.service.MemberService;

/**
 * 会员控制器
 * 
 * @author 陈小锋
 *
 */
@Controller
@RequestMapping("/member")
@SessionAttributes(types={Member.class})
public class MemberController {
	@Autowired
	private MemberService service;

	/**
	 * 会员注册
	 */
  @RequestMapping("register")
  public ModelAndView Register( Member member) {
	  ModelAndView m=new ModelAndView();
	  String registerMessage="";
	  if(service.Register(member))
		 registerMessage="注册成功";
	  else
		  registerMessage="注册失败";
	  m.addObject("registerMessage", registerMessage);
	  m.setView(new MappingJackson2JsonView());
	  return m;
	  
  }
  /**
   * 会员登录
   */
  @RequestMapping("login")
  public ModelAndView Login(String username,String password) {
	  System.out.println(username+" "+password);
	  ModelAndView m=new ModelAndView();
	  String loginMessage="";
	  if(service.login(username, password))
	  {
		  loginMessage="登录成功";
		  //获取会员信息
		  
		  Member mb=service.selectMemberInfoByUsername(username);
		  //保存用户信息
		  System.out.println(mb);
		  m.addObject("memberInfo", mb);
	  }
	  else
	      loginMessage="登录失败";
	  m.addObject("loginMessage", loginMessage);
	  m.setView(new MappingJackson2JsonView());
	  return m;
  }
  /**
   * 退出
   */
  @RequestMapping("logout")
  public ModelAndView logout() {
	  String logoutMessage="注销成功";
	  ModelAndView m=new ModelAndView();
	  Member mb=null;
	  m.addObject("logoutMessage",logoutMessage);
	  //置空用户对象
	  m.addObject("memberInfo",mb);
	  m.setView(new MappingJackson2JsonView());
	  return m;
	  
  }

 
}
